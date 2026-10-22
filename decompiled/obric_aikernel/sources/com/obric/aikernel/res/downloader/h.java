package com.obric.aikernel.res.downloader;

import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.runtime.utils.NetworkUtil;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class h {
    public static final int a(boolean r10, boolean r11, boolean r12) {
        if (r11 == true) goto L4;
        return 5;
    L4:
        if (r10 == false) goto L7;
        if (r12 == true) goto L7;
        return 3;
    L7:
        return 0;
    }

    public static final boolean b(PackageResourceManager.PresmConfig r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        NetworkUtil r11 = NetworkUtil.f5399a;
        if (r11.f(r10.getContext()) == false) goto L5;
    L8:
        return true;
    L5:
        if (r11.d(r10.getContext()) == true) goto L8;
        return false;
    }

    public static final f c(PackageResourceManager.PresmConfig r10) {
        Intrinsics.checkNotNullParameter(r10, "config");
        return new f(NetworkUtil.f5399a.e(r10.getContext()), b(r10));
    }

    public static final boolean d(boolean r10) {
        return r10;
    }

    public static final boolean e(boolean r10, boolean r11, boolean r12, int r13, int r14) {
        if (r10 == false) goto L9;
        if (r11 == false) goto L9;
        if (r12 == true) goto L9;
        if (r14 != 0) goto L9;
        if (b.b(r13) == true) goto L9;
        return true;
    L9:
        return false;
    }
}
