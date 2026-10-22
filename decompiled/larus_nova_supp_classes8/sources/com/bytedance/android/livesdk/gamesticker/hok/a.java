package com.bytedance.android.livesdk.gamesticker.hok;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ Function0 a;

    public a(Function0 r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        this.a.invoke();
    }
}
