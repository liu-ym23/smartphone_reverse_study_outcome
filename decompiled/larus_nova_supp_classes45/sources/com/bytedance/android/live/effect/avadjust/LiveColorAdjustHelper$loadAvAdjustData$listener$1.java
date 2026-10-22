package com.bytedance.android.live.effect.avadjust;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.bytedance.common.utility.Lists;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LiveColorAdjustHelper$loadAvAdjustData$listener$1 implements com.bytedance.android.live.effect.api.k.j {
    public final /* synthetic */ l a;
    public final /* synthetic */ l.c b;

    @Override // com.bytedance.android.live.effect.api.k.i
    public final void a(EffectChannelResponse r1) {
    }

    @Override // com.bytedance.android.live.effect.api.k.i
    public final void b() {
        l.c r0 = this.b;
        if (r0 == null) goto L5;
        r0.onError();
    L5:
        ALogger.i("ttlive_anchor_effect_LiveColorAdjustHelper", "loadAvAdjustData onSyncStickersFailed");
    }

    public LiveColorAdjustHelper$loadAvAdjustData$listener$1(l r1, l.c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.android.live.effect.api.k.j
    public final void c(EffectChannelResponse r8, EffectDataFetchCacheType r9) {
        Intrinsics.checkNotNullParameter(r9, "cacheType");
        if (r8 != null) goto L5;
    L9:
        l.c r11 = this.b;
        if (r11 == null) goto L12;
        r11.onError();
    L12:
        ALogger.i("ttlive_anchor_effect_LiveColorAdjustHelper", "loadAvAdjustData error");
        return;
    L5:
        if (Lists.isEmpty(r8.getAllCategoryEffects()) == true) goto L9;
        ALogger.i("ttlive_anchor_effect_LiveColorAdjustHelper", "loadAvAdjustData start callback change thread");
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new LiveColorAdjustHelper$loadAvAdjustData$listener$1$onSyncStickersSuccess$1(this, r8, null), 2, null);
    }
}
