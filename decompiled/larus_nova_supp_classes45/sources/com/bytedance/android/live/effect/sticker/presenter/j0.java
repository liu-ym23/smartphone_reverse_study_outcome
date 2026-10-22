package com.bytedance.android.live.effect.sticker.presenter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class j0 extends p0<Boolean> {
    public final /* synthetic */ o.b a;

    public j0(LiveStickerDataManager.f r1) {
        this.a = r1;
    }

    public final void onError(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        this.a.a(false);
    }

    public final void onNext(Object r2) {
        boolean r3 = ((Boolean) r2).booleanValue();
        this.a.a(r3);
    }
}
