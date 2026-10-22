package com.bytedance.android.live.effect.view;

import com.bytedance.android.live.effect.t;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ EffectLiveCameraActivityProxy a;

    public a(EffectLiveCameraActivityProxy r1) {
        this.a = r1;
    }

    public final void accept(Object r2) {
        if ((r2 instanceof com.bytedance.android.live.effect.gesture.a) == false) goto L11;
        EffectLiveCameraActivityProxy r0 = this.a;
        if (r2 == null) goto L10;
        com.bytedance.android.live.effect.gesture.a r3 = (com.bytedance.android.live.effect.gesture.a) r2;
        t r1 = r0.b;
        if (r1 == null) goto L12;
        r1.onEvent(r3);
        return;
    L12:
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.effect.gesture.LiveTouchEvent");
    }
}
