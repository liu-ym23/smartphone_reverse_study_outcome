package com.bytedance.android.livesdk.interactivity.publicscreen.repository.first;

import io.reactivex.functions.Consumer;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f<T> implements Consumer {
    public final /* synthetic */ d a;

    public f(d r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        Throwable r3 = (Throwable) r2;
        this.a.c("timer error");
        d.a(this.a, CollectionsKt.emptyList());
    }
}
