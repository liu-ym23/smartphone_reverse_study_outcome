package com.bytedance.android.live.openplatform.impl.minigameanchor.cast;

import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class l implements c {

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigameanchor.cast.c
    public final void setRadioMode(boolean r1) {
    }

    public l() {
        new CompositeDisposable();
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigameanchor.cast.c
    public final void a(int r3) {
        int r0 = qo0.a.a;
        qo0.a.c("MiniGameSingleCastStream", "setCameraPushFrameRotation " + r3);
    }
}
