package com.bytedance.android.ec.adapter.impl.adapters.reverse.player;

import com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements le.b {
    public IECLivePlayerClient a;
    public final LivePlayerView b;

    @Override // le.b
    public final IECLivePlayerClient a() {
        if (this.a != null) goto L5;
        this.a = new a(this.b);
    L5:
        IECLivePlayerClient r0 = this.a;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("liveClient");
    L8:
        return r0;
    }

    @Override // le.b
    public final LivePlayerView getView() {
        return this.b;
    }

    public d(LivePlayerView r10) {
        Intrinsics.checkNotNullParameter(r10, "liveView");
        this.b = r10;
    }

    @Override // le.b
    public final void setScaleType(int r10) {
        this.b.setScaleType(r10);
    }
}
