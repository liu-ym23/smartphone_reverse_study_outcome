package com.bytedance.android.ec.core.utils;

import android.app.ActivityManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.bytedance.android.ec.core.utils.a$a, reason: collision with other inner class name */
    public interface InterfaceC0145a {
        void a(AccessibilityNodeInfoCompat r1);
    }

    public static boolean c() {
        Context r0 = ECAppInfoService.e.getApplicationContext();
        if (r0 != null) goto L15;
        return false;
    L15:
        Object r10 = r0.getSystemService("accessibility");     // Catch: Throwable -> L14
        if (r10 == null) goto L12;
        boolean r11 = ((AccessibilityManager) r10).isEnabled();     // Catch: Throwable -> L14
        boolean r1 = e(r0);     // Catch: Throwable -> L14
        if (r11 == false) goto L13;
        if (r1 == true) goto L17;
        return false;
    L17:
        return true;
    L13:
        return false;
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");     // Catch: Throwable -> L14
    L18:
        return false;
    }

    static {
    }

    @JvmStatic
    public static final String b(String r1) {
        Intrinsics.checkNotNullParameter(r1, "type");
        switch(r1.hashCode()) {
            case -1377687758: goto L15;
            case 3556653: goto L12;
            case 100313435: goto L9;
            case 100358090: goto L6;
            default: goto L17;
        };
    L17:
        return null;
    L6:
        if (r1.equals("input") == false) goto L17;
        return "android.widget.EditText";
    L9:
        if (r1.equals("image") == false) goto L17;
        return "android.widget.ImageView";
    L12:
        if (r1.equals("text") == false) goto L17;
        return "android.widget.TextView";
    L15:
        if (r1.equals(com.bytedance.android.ec.core.event.a.VALUE_CLICK_AREA_BUTTON) == false) goto L17;
        return "android.widget.Button";
    }

    public static boolean e(Context r11) {
        Intent r0 = new Intent("android.accessibilityservice.AccessibilityService");
        r0.addCategory("android.accessibilityservice.category.FEEDBACK_SPOKEN");
        boolean r10 = false;
        List<ResolveInfo> r1 = r11.getPackageManager().queryIntentServices(r0, 0);
        if (r1 != null) goto L5;
    L40:
        return false;
    L5:
        if (r1.size() <= 0) goto L40;
        if (Build.VERSION.SDK_INT < 26) goto L24;
        Iterator<ResolveInfo> r12 = r1.iterator();
        boolean r13 = false;
    L11:
        if (r12.hasNext() == false) goto L50;
        ServiceInfo r14 = r12.next().serviceInfo;
        String r15 = r14.packageName;
        String r16 = r14.name;
        if (StringsKt.indexOf$default(r16, r15, 0, false, 6, null) < 0) goto L15;
        String r17 = StringsKt.replace$default(r16, r15, "", false, 4, null);
    L17:
        if (d(r11, r15 + '/' + r16) == false) goto L19;
    L22:
        boolean r18 = true;
    L23:
        r13 = r13 | r18;
        goto L11
    L19:
        if (d(r11, r15 + '/' + r17) == true) goto L22;
        r18 = false;
        goto L23
    L15:
        r17 = "";
        goto L17
    L50:
        return r13;
    L24:
        ArrayList r19 = new ArrayList();
        Object r110 = r11.getSystemService(com.bytedance.android.ec.core.event.a.VALUE_ACTIVITY);
        if (r110 == null) goto L39;
        Iterator<ActivityManager.RunningServiceInfo> r111 = ((ActivityManager) r110).getRunningServices(Integer.MAX_VALUE).iterator();
    L28:
        if (r111.hasNext() == false) goto L30;
        r19.add(r111.next().service.getPackageName());
        goto L28
    L30:
        Iterator<ResolveInfo> r112 = r1.iterator();
    L32:
        if (r112.hasNext() == false) goto L37;
        if (r19.contains(r112.next().serviceInfo.packageName) == false) goto L32;
        r10 = r10 | true;
        goto L32
    L37:
        return r10;
    L39:
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    @JvmStatic
    public static final void f(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        if (Build.VERSION.SDK_INT < 26) goto L6;
        r10.setFocusable(0);
        r10.setImportantForAccessibility(2);
        return;
    }

    @JvmStatic
    public static final void a(View r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "$this$enableViewAccessibility");
        if (r11 == false) goto L6;
        r10.setImportantForAccessibility(1);
    L10:
        if (Build.VERSION.SDK_INT < 26) goto L13;
        r10.setFocusable(r11 ? 1 : 0);
        return;
    L13:
        return;
    L6:
        if ((r10 instanceof ViewGroup) == false) goto L8;
        ((ViewGroup) r10).setImportantForAccessibility(4);
        goto L10
    L8:
        r10.setImportantForAccessibility(2);
        goto L10
    }

    public static boolean d(Context r16, String r17) {
        TextUtils.SimpleStringSplitter r0 = new TextUtils.SimpleStringSplitter(':');
        ContentResolver r1 = r16.getApplicationContext().getContentResolver();
        f06.c r10 = new f06.c();
        Object[] r11 = {r1, "enabled_accessibility_services"};
        f06.b r15 = new f06.b();
        f06.d r12 = r10.b(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r11, "java.lang.String", r15);
        if (r12.a == false) goto L5;
        r10.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r11, null, r15, false);
        String r13 = (String) r12.b;
    L6:
        if (r13 == null) goto L13;
        r0.setString(r13);
    L9:
        if (r0.hasNext() == false) goto L13;
        if (StringsKt.equals(r0.next(), r17, true) == false) goto L9;
        return true;
    L13:
        return false;
    L5:
        r13 = Settings.Secure.getString(r1, "enabled_accessibility_services");
        r10.a(102004, "android/provider/Settings$Secure", "getString", Settings.Secure.class, r11, r13, r15, true);
        goto L6
    }
}
