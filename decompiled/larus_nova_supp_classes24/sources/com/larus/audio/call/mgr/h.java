package com.larus.audio.call.mgr;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import s68.n;
import s68.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class h<S> {
    public static final /* synthetic */ int c = 0;
    public final S a;
    public final Function1<n<S>, Unit> b;

    public static final class a {
        public static h a(Object r2) {
            Intrinsics.checkNotNullParameter(r2, "next");
            return new h(r2, new o());
        }
    }

    static {
    }

    public h() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public h(Object r1, Function1 r2) {
        this.a = r1;
        this.b = r2;
    }
}
