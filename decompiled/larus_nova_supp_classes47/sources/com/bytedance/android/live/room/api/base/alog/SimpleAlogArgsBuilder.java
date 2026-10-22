package com.bytedance.android.live.room.api.base.alog;

import com.bytedance.badger.collect.impl.constants.Constants;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class SimpleAlogArgsBuilder {
    public Throwable a;
    public final Lazy b;

    public final a b() {
        return new a(((StringBuilder) this.b.getValue()).toString(), this.a);
    }

    public SimpleAlogArgsBuilder() {
        this.b = LazyKt.lazy(SimpleAlogArgsBuilder$strBuilder$2.INSTANCE);
    }

    public final void c(String r3) {
        Intrinsics.checkNotNullParameter(r3, Constants.OperatorKey.MSG);
        ((StringBuilder) this.b.getValue()).append(r3 + '.');
    }

    public final void d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        ((StringBuilder) this.b.getValue()).append("tag:" + r4 + '\t');
    }

    public final void a(String r3, Object r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "value");
        ((StringBuilder) this.b.getValue()).append(r3 + '=' + r4 + "  ");
    }
}
