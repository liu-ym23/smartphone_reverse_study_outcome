package jn8;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import v19.d6;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class r {
    public final Context a;
    public final Lazy b;
    public t c;
    public d6 d;

    public r(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new q(this));
    }
}
