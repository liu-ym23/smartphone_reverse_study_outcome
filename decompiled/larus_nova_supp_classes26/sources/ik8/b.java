package ik8;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import lk8.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b {
    public final Context a;
    public final Lazy b;
    public final e c;

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = LazyKt.lazy(new a(this));
        this.c = new e();
    }
}
