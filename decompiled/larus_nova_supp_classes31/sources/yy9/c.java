package yy9;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public final Context a;
    public final Lazy b;
    public final Lazy c;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.a;
    }

    public c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new yy9.a(this));
        this.c = LazyKt.lazy(new b());
    }
}
