package in8;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d {
    public final Context a;
    public final Lazy b;
    public final Lazy c;

    public static final class a {
    }

    static {
    }

    public final kn8.c a() {
        return (kn8.c) this.c.getValue();
    }

    public final Context getContext() {
        return this.a;
    }

    public d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new in8.a(this));
        this.c = LazyKt.lazy(new b());
    }
}
