package com.bytedance.android.live.effect.api;

import com.bytedance.android.livesdkapi.depend.model.Sticker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g0 implements ILiveEffectComposerManager.d {
    public final /* synthetic */ o.a a;

    public g0(kh0.a.d r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.d
    public final void a(String r2, Sticker r3) {
        this.a.a(r2, r3);
    }

    @Override // com.bytedance.android.live.effect.api.ILiveEffectComposerManager.d
    public final void b(boolean r2, String r3, Sticker r4) {
        this.a.b(r2, r3, r4);
    }
}
