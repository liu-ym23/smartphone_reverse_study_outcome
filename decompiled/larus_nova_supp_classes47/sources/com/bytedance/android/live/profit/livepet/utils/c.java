package com.bytedance.android.live.profit.livepet.utils;

import android.animation.AnimatorSet;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ AnimatorSet a;

    public c(AnimatorSet r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Disposable r2 = (Disposable) r1;
        this.a.start();
    }
}
