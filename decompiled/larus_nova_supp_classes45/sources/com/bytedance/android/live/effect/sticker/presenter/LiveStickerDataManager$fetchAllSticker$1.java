package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.ss.android.ugc.effectmanager.effect.model.EffectChannelResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"onSyncStickerSuccess", "", "response", "Lcom/ss/android/ugc/effectmanager/effect/model/EffectChannelResponse;", "cacheType", "Lcom/bytedance/android/live/effect/base/EffectDataFetchCacheType;", "invoke"}, k = 3, mv = {1, 4, 3})
public final class LiveStickerDataManager$fetchAllSticker$1 extends Lambda implements Function2<EffectChannelResponse, EffectDataFetchCacheType, Unit> {
    final /* synthetic */ com.bytedance.android.live.effect.api.k.i $listener;

    public LiveStickerDataManager$fetchAllSticker$1(com.bytedance.android.live.effect.api.k.i r1) {
        this.$listener = r1;
        super(2);
    }

    public final void invoke(EffectChannelResponse r3, EffectDataFetchCacheType r4) {
        Intrinsics.checkNotNullParameter(r3, "response");
        Intrinsics.checkNotNullParameter(r4, "cacheType");
        com.bytedance.android.live.effect.api.k.i r0 = this.$listener;
        if (r0 == null) goto L5;
        r0.a(r3);
    L5:
        com.bytedance.android.live.effect.api.k.i r1 = this.$listener;
        if ((r1 instanceof com.bytedance.android.live.effect.api.k.j) == false) goto L9;
        ((com.bytedance.android.live.effect.api.k.j) r1).c(r3, r4);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((EffectChannelResponse) r1, (EffectDataFetchCacheType) r2);
        return Unit.INSTANCE;
    }
}
