package com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ Function1 a;

    public c(Function1 r1) {
        this.a = r1;
    }

    public final void accept(T r2) {
        this.a.invoke(r2);
    }
}
