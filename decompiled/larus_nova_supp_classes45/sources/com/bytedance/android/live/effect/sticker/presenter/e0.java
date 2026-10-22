package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e0 implements com.bytedance.android.live.effect.api.k.b {
    public final /* synthetic */ com.bytedance.android.live.effect.api.k.b a;

    @Override // com.bytedance.android.live.effect.api.k.b
    public final void onFetchFailed() {
        com.bytedance.android.live.effect.api.k.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.onFetchFailed();
        return;
    }

    public e0(com.bytedance.android.live.effect.api.k.b r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.live.effect.api.k.b
    public final void a(List<Effect> r2, EffectDataFetchCacheType r3) {
        Intrinsics.checkNotNullParameter(r2, "effectList");
        Intrinsics.checkNotNullParameter(r3, "cacheType");
        com.bytedance.android.live.effect.api.k.b r0 = this.a;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }
}
