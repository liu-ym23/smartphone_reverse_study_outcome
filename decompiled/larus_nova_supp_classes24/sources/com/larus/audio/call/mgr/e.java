package com.larus.audio.call.mgr;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static h a(AVKitDuplexState.DownState r1) {
        Intrinsics.checkNotNullParameter(r1, "next");
        int r0 = h.c;
        return h.a.a(r1);
    }

    public static h b(AVKitDuplexState.DownState r3, Function1 r4) {
        Intrinsics.checkNotNullParameter(r3, "next");
        Intrinsics.checkNotNullParameter(r4, "configurePending");
        int r2 = h.c;
        Intrinsics.checkNotNullParameter(r3, "next");
        Intrinsics.checkNotNullParameter(r4, "configurePending");
        return new h(r3, r4);
    }
}
