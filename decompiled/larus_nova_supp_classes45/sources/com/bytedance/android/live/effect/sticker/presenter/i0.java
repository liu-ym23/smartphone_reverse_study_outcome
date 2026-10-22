package com.bytedance.android.live.effect.sticker.presenter;

import com.ss.android.ugc.effectmanager.effect.model.Effect;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i0<T> implements ObservableOnSubscribe {
    public final /* synthetic */ LiveStickerDataManager a;
    public final /* synthetic */ Effect b;

    public i0(LiveStickerDataManager r1, Effect r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void subscribe(ObservableEmitter<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r3, "emitter");
        r3.onNext(Boolean.valueOf(this.a.t().isEffectDownloaded(this.b)));
    }
}
