package in8;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class g {
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

    public g(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new e(this));
        this.c = LazyKt.lazy(new f());
    }
}
