package sj8;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public final Lazy a;
    public final Lazy b;

    public c(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = LazyKt.lazy(new a(r2));
        this.b = LazyKt.lazy(new b());
    }
}
