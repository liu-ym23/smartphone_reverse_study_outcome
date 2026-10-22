package com.bytedance.android.live.effect.sticker.presenter;

import com.bytedance.android.live.effect.base.EffectDataFetchCacheType;
import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, d2 = {"onFetchSuccess", "", "effectList", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "cacheType", "Lcom/bytedance/android/live/effect/base/EffectDataFetchCacheType;", "invoke"}, k = 3, mv = {1, 4, 3})
final class LiveStickerDataManager$fetchManagerEffectByCategory$1 extends Lambda implements Function2<List<? extends Effect>, EffectDataFetchCacheType, Unit> {
    final /* synthetic */ com.bytedance.android.live.effect.api.k.b $listener;

    public LiveStickerDataManager$fetchManagerEffectByCategory$1(com.bytedance.android.live.effect.api.k.b r1) {
        this.$listener = r1;
        super(2);
    }

    public final void invoke(List<? extends Effect> r2, EffectDataFetchCacheType r3) {
        Intrinsics.checkNotNullParameter(r2, "effectList");
        Intrinsics.checkNotNullParameter(r3, "cacheType");
        com.bytedance.android.live.effect.api.k.b r0 = this.$listener;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((List) r1, (EffectDataFetchCacheType) r2);
        return Unit.INSTANCE;
    }
}
