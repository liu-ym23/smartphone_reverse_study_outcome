package eia;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public abstract class r extends v {
    public final Lazy d;
    public final Lazy e;

    public static final class a {
    }

    static {
    }

    public r(Context r2, final t1a.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "vContext");
        super(r2, r3);
        this.d = LazyKt.lazy(new p(r3));
        this.e = LazyKt.lazy(new q(this));
    }
}
