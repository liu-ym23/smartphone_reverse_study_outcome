package com.obric.aikernel.service.res;

import com.obric.aikernel.middleware.api.appcontext.receiver.NetworkStateListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {
    public static final e a(e r10, e r11) {
        Intrinsics.checkNotNullParameter(r10, "computed");
        if (r11 != null) goto L6;
        return r10;
    L6:
        return r11;
    }

    public static final String b(int r10, boolean r11) {
        return "disallowed by batt:" + r10 + " charging:" + r11;
    }

    public static final boolean c(NetworkStateListener.b r10, NetworkStateListener.b r11) {
        Intrinsics.checkNotNullParameter(r11, "next");
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r10, r11) == true) goto L7;
        return true;
    }

    public static final boolean d(e r10, e r11) {
        Intrinsics.checkNotNullParameter(r10, "previous");
        Intrinsics.checkNotNullParameter(r11, "next");
        if (r10.a() == false) goto L5;
    L7:
        return false;
    L5:
        if (r11.a() == false) goto L7;
        return true;
    }
}
