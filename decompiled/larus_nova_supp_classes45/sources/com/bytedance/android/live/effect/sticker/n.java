package com.bytedance.android.live.effect.sticker;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n<T> implements Consumer {
    public final /* synthetic */ k a;

    public n(k r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        Throwable r4 = (Throwable) r3;
        ALogger.i("ttlive_anchor_effect_MultiAnchorEffectHelper", "getData failed,roomId=" + this.a.g);
    }
}
