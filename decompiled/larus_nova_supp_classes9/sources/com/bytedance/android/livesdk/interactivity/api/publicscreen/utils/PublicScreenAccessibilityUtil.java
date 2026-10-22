package com.bytedance.android.livesdk.interactivity.api.publicscreen.utils;

import android.text.Spanned;
import android.view.View;
import com.bytedance.android.livesdk.r3;
import com.bytedance.bdlocation.BuildConfig;
import r52.k0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class PublicScreenAccessibilityUtil {
    public static final PublicScreenAccessibilityUtil a = null;

    public PublicScreenAccessibilityUtil() {
    }

    static {
        a = new PublicScreenAccessibilityUtil();
    }

    public static void a(Spanned r10, View r11, com.bytedance.android.livesdk.interactivity.api.entity.f r13) {
        if (r11 != null) goto L4;
        return;
    L4:
        if (r10 != null) goto L6;
        return;
    L6:
        pb2.a[] r0 = (pb2.a[]) x.a(r10, r10.length(), pb2.a.class);
        final boolean r1 = true;
        if (r0 != null) goto L9;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == false) goto L18;
        final String r14 = r10.toString();
    L36:
        if (r13 != null) goto L38;
    L48:
        r3.a(r11, r14);
        return;
    L38:
        if (((Boolean) k0.a.getValue()).booleanValue() == false) goto L48;
        if (r13.x() == null) goto L42;
        final boolean r2 = true;
    L44:
        if (r13.x() != null) goto L47;
        r1 = false;
    L47:
        r3.e(r11, new PublicScreenAccessibilityUtil$addAccessibilityTextV2$1(r2, r1, r14));
        return;
    L42:
        r2 = false;
        goto L44
    L18:
        String r4 = BuildConfig.FLAVOR;
        String r5 = BuildConfig.FLAVOR;
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
        int r9 = 0;
    L20:
        if (r6 >= r10.length()) goto L35;
        if (r7 >= r0.length) goto L24;
        r8 = r10.getSpanStart(r0[r7]);
        r9 = r10.getSpanEnd(r0[r7]);
    L24:
        if (r8 > r6) goto L34;
        if (r9 <= r6) goto L34;
        jb2.b r15 = r0[r7].m;
        if (r15 == null) goto L32;
        String r16 = r15.a;
        if (r16 == null) goto L32;
        r5 = r5 + r16;
    L33:
        r7 = r7 + 1;
        r6 = r9;
    L32:
        r4 = r4 + r10.subSequence(r8, r9);
    L34:
        r4 = r4 + r10.charAt(r6);
        r6 = r6 + 1;
        goto L20
    L35:
        r14 = r4 + r5;
        goto L36
    L9:
        if (r0.length != 0) goto L11;
        boolean r17 = true;
    L12:
        if (r17 == true) goto L15;
        r3 = false;
        goto L16
    L11:
        r17 = false;
        goto L12
    }
}
