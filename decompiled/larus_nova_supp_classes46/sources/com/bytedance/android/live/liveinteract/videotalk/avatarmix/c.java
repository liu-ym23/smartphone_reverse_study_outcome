package com.bytedance.android.live.liveinteract.videotalk.avatarmix;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final boolean a(d r8, d r9) {
        Intrinsics.checkNotNullParameter(r8, "$this$equalTo");
        Intrinsics.checkNotNullParameter(r9, "struct");
        if (Intrinsics.areEqual(r8.a, r9.a) == true) goto L5;
        return false;
    L5:
        if (r8.getType() == r9.getType()) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(r8.c, r9.c) == false) goto L23;
        ti6.f r10 = r8.d;
        ti6.f r11 = r9.d;
        Intrinsics.checkNotNullParameter(r10, "$this$equalTo");
        Intrinsics.checkNotNullParameter(r11, "region");
        if (Math.abs(r10.d - r11.d) < 1.0E-9d) goto L11;
    L17:
        boolean r12 = false;
    L18:
        if (r12 == false) goto L24;
        return true;
    L24:
        return false;
    L11:
        if (Math.abs(r10.e - r11.e) >= 1.0E-9d) goto L17;
        if (Math.abs(r10.f - r11.f) >= 1.0E-9d) goto L17;
        if (Math.abs(r10.g - r11.g) >= 1.0E-9d) goto L17;
        r12 = true;
        goto L18
    L23:
        return false;
    }
}
