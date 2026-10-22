package com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view;

import androidx.recyclerview.widget.DiffUtil;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ TuningEffectAdapter a;

    public b(TuningEffectAdapter r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        ((DiffUtil.DiffResult) r2).dispatchUpdatesTo(this.a);
    }
}
