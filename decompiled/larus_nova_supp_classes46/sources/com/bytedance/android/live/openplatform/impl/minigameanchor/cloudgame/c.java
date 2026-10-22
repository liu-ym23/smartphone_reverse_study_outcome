package com.bytedance.android.live.openplatform.impl.minigameanchor.cloudgame;

import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import io.reactivex.disposables.CompositeDisposable;
import uf2.d0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements com.bytedance.android.live.openplatform.impl.minigameanchor.cast.c {
    public final d0.b a;

    public static final class a {
    }

    public static final class b implements d0.b.a {
        public b() {
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigameanchor.cast.c
    public final void setRadioMode(boolean r1) {
    }

    public c() {
        new CompositeDisposable();
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r0 = ILiveWrappedLivePusher.a.b();
        if (r0 == null) goto L5;
        d0.b r1 = r0.newLiveCoreVideoFrameAvailableListener(new b());
    L6:
        this.a = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.openplatform.impl.minigameanchor.cast.c
    public final void a(int r3) {
        int r0 = qo0.a.a;
        qo0.a.c("MiniGameSingleCastStreamV2", "setCameraPushFrameRotation " + r3);
    }
}
