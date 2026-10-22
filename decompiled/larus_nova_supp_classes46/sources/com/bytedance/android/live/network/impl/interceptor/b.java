package com.bytedance.android.live.network.impl.interceptor;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.core.cache.LruCache;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.network.impl.interceptor.business.MultiLinkCPInterceptor;
import com.bytedance.android.livesdk.config.cp0;
import com.bytedance.android.livesdk.config.hg1;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public class b implements com.bytedance.android.live.network.b {
    public final com.bytedance.android.live.network.impl.interceptor.business.a a;
    public final String[] b;

    public void b(Map<String, String> r1) {
        throw null;
    }

    public b() {
        com.bytedance.android.live.network.impl.interceptor.business.a r0 = new com.bytedance.android.live.network.impl.interceptor.business.a();
        MultiLinkCPInterceptor r1 = new MultiLinkCPInterceptor();
        Intrinsics.checkNotNullParameter(r1, "businessCPInterceptor");
        r0.a.add(r1);
        this.a = r0;
        this.b = new String[]{"CN", "MR", "SA", "FR", "AE"};
    }

    public final String a(boolean r16, String r17, String r18, byte[] r19) {
        if (TextUtils.isEmpty(r17) == false) goto L5;
        return r17;
    L5:
        Uri r2 = UriProtector.parse(r17);
        if (r2.isOpaque() == false) goto L8;
    L10:
        String r3 = UriProtector.parse(r17).getPath();
        if (r16 == true) goto L13;
        LruCache r4 = co0.c.a;
        if (r17 == null) goto L92;
        hg1 r5 = (hg1) cp0.a.getValue();
        if (r5 == null) goto L92;
        if (r5.b(r3) != true) goto L92;
        String r6 = co0.c.b(r17, r3);
        boolean r7 = false;
        if (r6 == null) goto L24;
        int r8 = r6.length();
    L25:
        String r9 = null;
        if (r8 <= r17.length()) goto L31;
        if (r6 == null) goto L31;
        if (StringsKt.contains$default(r6, "r_signature", false, 2, null) != true) goto L31;
        return r6;
    L31:
        if (r19 != null) goto L34;
    L74:
        String r0 = "";
    L76:
        if (r0.length() != 0) goto L78;
        boolean r10 = true;
    L79:
        if (r10 == true) goto L92;
        LruCache r11 = co0.c.a;
        if (r11 == null) goto L84;
        r9 = (String) r11.get(r0);
    L84:
        if (r9 == null) goto L92;
        if (r9.length() <= 0) goto L88;
        r7 = true;
    L88:
        if (r7 != true) goto L92;
        return co0.c.a(r17, r9);
    L78:
        r10 = false;
        goto L79
    L34:
        if (Intrinsics.areEqual(r18, "application/x-www-form-urlencoded; charset=UTF-8") == false) goto L74;
        String r12 = new String(r19, Charsets.UTF_8);     // Catch: Exception -> L37
    L39:
        if (r12 == null) goto L74;
        if (r12.length() <= 0) goto L43;
        boolean r1 = true;
    L44:
        if (r1 != true) goto L74;
        int r13 = StringsKt.indexOf$default(r12, "room_id=", 0, false, 6, null);
        if (r13 < 0) goto L74;
        int r14 = r12.length();
        int r15 = r13 + 8;
        if (r15 < 0) goto L74;
        if (r14 < r15) goto L74;
        r0 = r12.substring(r15);
        if (r0 == null) goto L74;
        if (r0.length() <= 0) goto L57;
        boolean r20 = true;
    L58:
        if (r20 != true) goto L74;
        int r21 = r0.length();
        int r22 = 0;
    L62:
        if (r22 >= r21) goto L67;
        if (Character.isDigit(r0.charAt(r22)) == false) goto L68;
        r22 = r22 + 1;
    L68:
        if (r22 == (-1)) goto L76;
        if (r22 <= 0) goto L74;
        if (r22 > r0.length()) goto L74;
        r0 = r0.substring(0, r22);
        goto L76
    L67:
        r22 = -1;
        goto L68
    L57:
        r20 = false;
        goto L58
    L43:
        r1 = false;
    L37:
        e = move-exception;
        SafetyGuard.a(null, e, "RoomParamHandler bytes to string error");
        ALogger.i("RoomParamHandler", "bytes to string error: " + e.getMessage());
        r12 = null;
        goto L39
    L24:
        r8 = 0;
    L92:
        return r17;
    L13:
        return co0.c.b(r17, r3);
    L8:
        if (UriProtector.getQueryParameter(r2, "r_signature") == null) goto L10;
        return r17;
    }
}
