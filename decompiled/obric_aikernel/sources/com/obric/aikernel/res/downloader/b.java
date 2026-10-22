package com.obric.aikernel.res.downloader;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final a a(c r10) {
        Intrinsics.checkNotNullParameter(r10, "snapshot");
        if (r10.b() == false) goto L31;
        boolean r11 = true;
        if (r10.f() == true) goto L9;
        return new a(1, "caller group canceled");
    L9:
        if (r10.e() == false) goto L22;
        if (r10.c() == false) goto L22;
        if (r10.a() == true) goto L22;
        String r12 = r10.d();
        if (r12.length() == 0) goto L18;
        r11 = false;
    L18:
        if (r11 == false) goto L33;
        r12 = "background update disallowed";
    L33:
        return new a(2, r12);
    L22:
        if (r10.h() == true) goto L25;
        return new a(5, "no valid internet");
    L25:
        if (r10.i() == false) goto L30;
        if (r10.g() == true) goto L30;
        return new a(3, "no unmetered network");
    L30:
        return new a(0, "ready");
    L31:
        return new a(4, "allowNetworkRequest=false");
    }

    public static final boolean b(int r10) {
        if (r10 != 2) goto L5;
    L11:
        return true;
    L5:
        if (r10 == 3) goto L11;
        if (r10 == 4) goto L11;
        if (r10 == 5) goto L11;
        return false;
    }
}
