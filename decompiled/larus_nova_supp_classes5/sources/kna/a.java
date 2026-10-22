package kna;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a implements c {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    @Override // kna.c
    public final boolean a() {
        return false;
    }

    @Override // kna.c
    public final String b() {
        return null;
    }

    @Override // kna.c
    public final void c(Function1<? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }
}
