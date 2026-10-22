package com.bytedance.android.ec.core.imagex.opt;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class s {
    public static final com.bytedance.android.shopping.api.image.q c(com.bytedance.android.ec.core.imagex.r r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$tryGetUrlParams");
        if ((r10 instanceof com.bytedance.android.ec.core.imagex.u) == true) goto L5;
        r10 = null;
    L5:
        com.bytedance.android.ec.core.imagex.u r11 = (com.bytedance.android.ec.core.imagex.u) r10;
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.n();
    }

    public static final com.bytedance.android.shopping.api.image.r d(com.bytedance.android.ec.core.imagex.r r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$tryGetUrlParser");
        if ((r10 instanceof com.bytedance.android.ec.core.imagex.u) == true) goto L5;
        r10 = null;
    L5:
        com.bytedance.android.ec.core.imagex.u r11 = (com.bytedance.android.ec.core.imagex.u) r10;
        if (r11 != null) goto L8;
        return null;
    L8:
        return r11.z;
    }

    public static final int a(String r10, String[] r11, boolean r12) {
        int r0 = r11.length;
        int r13 = 0;
        int r14 = -1;
    L3:
        if (r13 >= r0) goto L10;
        String r15 = r11[r13];
        int r16 = StringsKt.indexOf$default(r10, r15, 0, false, 6, null);
        if (r16 >= 0) goto L6;
        r13 = r13 + 1;
        r14 = r16;
        goto L3
    L6:
        if (r12 == false) goto L8;
        r16 = r16 + r15.length();
    L8:
        r14 = r16;
    L10:
        if (r14 < 0) goto L12;
        return r14;
    L12:
        return -1;
    }

    public static final String b(String r10, String[] r11, boolean r12, String[] r13) {
        if (r10 != null) goto L5;
        return null;
    L5:
        int r14 = 0;
        if (r11.length != 0) goto L8;
        boolean r1 = true;
    L10:
        if ((!r1) == false) goto L12;
        int r15 = a(r10, r11, true);
    L14:
        if (r13.length != 0) goto L16;
        boolean r16 = true;
    L18:
        if ((!r16) == false) goto L20;
        int r17 = a(r10, r13, false);
    L21:
        if (r15 >= 0) goto L24;
        if (r12 == false) goto L24;
    L25:
        if (r17 >= 0) goto L27;
        r17 = r10.length();
    L27:
        if (r14 < 0) goto L32;
        if (r17 < 0) goto L32;
        if (r14 >= r17) goto L32;
        return r10.substring(r14, r17);
    L32:
        return null;
    L24:
        r14 = r15;
        goto L25
    L20:
        r17 = r10.length();
        goto L21
    L16:
        r16 = false;
        goto L18
    L12:
        r15 = 0;
        goto L14
    L8:
        r1 = false;
        goto L10
    }
}
