package com.bytedance.android.live.effect.beauty.sticker;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h implements Observer<Boolean> {
    public final /* synthetic */ LiveStickerListAdapter a;

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
    }

    public final void onSubscribe(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "d");
    }

    public final void onComplete() {
        this.a.notifyDataSetChanged();
        this.a.i = false;
    }

    public h(LiveStickerListAdapter r1) {
        this.a = r1;
    }

    public final /* bridge */ /* synthetic */ void onNext(Object r1) {
        ((Boolean) r1).booleanValue();
    }
}
