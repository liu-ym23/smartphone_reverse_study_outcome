package d7a;

import android.content.Context;
import android.text.TextUtils;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.m;
import com.lynx.tasm.eventreport.LynxEventReporter;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class a {
    public a() {
    }

    public static String b(Context r6, String r7, boolean r8) {
        if ((r6 instanceof LynxContext) == true) goto L5;
        return r7;
    L5:
        if (TextUtils.isEmpty(r7) == true) goto L81;
        LynxContext r9 = com.lynx.tasm.utils.a.a(r6);
        if (r9 != null) goto L10;
        LLog.e("ImageUrlRedirectUtils", "redirecting url failed due to no context available");
        return r7;
    L10:
        if (r8 == false) goto L12;
        m r10 = r9.getAsyncImageInterceptor();
    L13:
        if (r10 == null) goto L82;
        String r1 = r9.getTemplateUrl();
        if (TraceEvent.isTracingStarted() == false) goto L17;
        HashMap r2 = new HashMap();
        r2.put(LynxEventReporter.PROP_NAME_URL, r7);
        TraceEvent.beginSection("Interceptor.shouldRedirectImageUrl", r2);
    L17:
        String r3 = null;
        String r11 = r10.shouldRedirectImageUrl(r7);     // Catch: Exception -> L20
    L22:
        TraceEvent.endSection("Interceptor.shouldRedirectImageUrl");
        boolean r4 = false;
        if (r11 == null) goto L26;
    L54:
        r3 = r11;
    L55:
        if (r3 != null) goto L57;
        return r7;
    L57:
        if (r3.startsWith("res:///") == false) goto L74;
        int r0 = 7;
    L60:
        if (r0 >= r3.length()) goto L67;
        char r5 = r3.charAt(r0);
        if (r5 < '0') goto L68;
        if (r5 > '9') goto L68;
        r0 = r0 + 1;
    L68:
        if (r4 == true) goto L74;
        int r12 = r3.indexOf(46);
        if (r12 >= 0) goto L84;
        r12 = r3.length();
    L84:
        return "res:///" + r9.getResources().getIdentifier(r3.substring(7, r12), "drawable", r9.getPackageName());
    L67:
        r4 = true;
    L74:
        return r3;
    L26:
        if (TextUtils.isEmpty(r7) == true) goto L55;
        if (r7.startsWith("./") == false) goto L55;
        if (TextUtils.isEmpty(r1) == true) goto L55;
        int r13 = r1.lastIndexOf("/");
        if (r13 <= 0) goto L55;
        r3 = r1.substring(0, r13) + r7.substring(1);
        LLog.d("ImageUrlRedirectUtils", "shouldRedirectImageUrl use local image url:" + r3);
        if (r3.startsWith("http") == true) goto L55;
        if (r3.startsWith("file://") == true) goto L55;
        if (r3.startsWith("content://") == true) goto L55;
        if (r3.startsWith("res://") == true) goto L55;
        if (r3.startsWith("data:") == true) goto L55;
        if (r3.startsWith("assets:///") == false) goto L48;
        r3 = r3.replace("assets:///", "asset:///");
        goto L55
    L48:
        if (r3.startsWith("assets://") == false) goto L51;
        r3 = r3.replace("assets://", "asset:///");
        goto L55
    L51:
        if (r3.startsWith("asset:///") == true) goto L55;
        r11 = "file://".concat(r3);
    L20:
        e = move-exception;
        LLog.d("ImageUrlRedirectUtils", "shouldRedirectImageUrl occurred with exception: " + e.getMessage());
        r11 = null;
        goto L22
    L82:
        return r7;
    L12:
        r10 = r9.imageInterceptor();
        goto L13
    L81:
        return r7;
    }

    public static void a(Context r8, String r9, float r10, float r11, m.a r12) {
        LynxContext r1 = com.lynx.tasm.utils.a.a(r8);
        if (r1 != null) goto L6;
        LLog.e("ImageUrlRedirectUtils", "load image failed due to no context available");
        return;
    L6:
        m r0 = r1.imageInterceptor();
        if (r0 == null) goto L9;
        r0.loadImage(r1, null, r9, r10, r11, null, r12);
        return;
    L9:
        r12.a(null, null);
    }
}
