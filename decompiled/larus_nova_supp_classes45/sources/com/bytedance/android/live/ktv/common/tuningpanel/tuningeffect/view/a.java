package com.bytedance.android.live.ktv.common.tuningpanel.tuningeffect.view;

import androidx.recyclerview.widget.DiffUtil;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<T> implements SingleOnSubscribe {
    public final /* synthetic */ TuningEffectAdapter a;

    public a(TuningEffectAdapter r1) {
        this.a = r1;
    }

    public final void subscribe(SingleEmitter<DiffUtil.DiffResult> r4) {
        Intrinsics.checkNotNullParameter(r4, "emitter");
        TuningEffectAdapter r1 = this.a;
        r4.onSuccess(DiffUtil.calculateDiff(new TuningEffectAdapter.DiffCallback(r1.b, r1.a)));
    }
}
