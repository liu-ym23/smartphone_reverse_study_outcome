package com.bytedance.android.live.profit.fansclub.widget.entrance.mviview;

import android.animation.AnimatorSet;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ SingleVipMVIView a;

    public u(SingleVipMVIView r1) {
        this.a = r1;
    }

    public final void accept(Object r1) {
        Long r2 = (Long) r1;
        AnimatorSet r3 = this.a.l;
        if (r3 == null) goto L6;
        r3.start();
        return;
    }
}
