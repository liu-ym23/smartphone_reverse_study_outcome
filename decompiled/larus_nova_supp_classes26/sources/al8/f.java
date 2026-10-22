package al8;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public final Context a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;

    public final Context getContext() {
        return this.a;
    }

    public f(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new a(this));
        this.c = LazyKt.lazy(new b());
        this.d = LazyKt.lazy(new c(this));
    }
}
