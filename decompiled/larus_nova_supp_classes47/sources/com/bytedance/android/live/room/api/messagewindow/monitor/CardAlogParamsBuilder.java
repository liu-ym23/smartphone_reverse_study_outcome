package com.bytedance.android.live.room.api.messagewindow.monitor;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class CardAlogParamsBuilder {
    public Throwable a;
    public final Lazy b;

    public final a b() {
        return new a(((StringBuilder) this.b.getValue()).toString(), this.a);
    }

    public CardAlogParamsBuilder() {
        this.b = LazyKt.lazy(CardAlogParamsBuilder$strBuilder$2.INSTANCE);
    }

    public final void c(String r3) {
        ((StringBuilder) this.b.getValue()).append(r3 + '.');
    }

    public final void d(String r4) {
        Intrinsics.checkNotNullParameter(r4, "tag");
        ((StringBuilder) this.b.getValue()).append("tag:" + r4 + '\t');
    }

    public final void a(String r4, Object r5) {
        Intrinsics.checkNotNullParameter(r4, "key");
        Intrinsics.checkNotNullParameter(r5, "value");
        ((StringBuilder) this.b.getValue()).append("the " + r4 + " is " + r5 + '.');
    }
}
