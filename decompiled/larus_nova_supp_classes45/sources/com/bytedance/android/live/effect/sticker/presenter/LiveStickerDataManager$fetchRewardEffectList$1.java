package com.bytedance.android.live.effect.sticker.presenter;

import com.ss.android.ugc.effectmanager.effect.model.Effect;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"onFetchSuccess", "", "rewardEffects", "", "Lcom/ss/android/ugc/effectmanager/effect/model/Effect;", "invoke"}, k = 3, mv = {1, 4, 3})
final class LiveStickerDataManager$fetchRewardEffectList$1 extends Lambda implements Function1<List<? extends Effect>, Unit> {
    final /* synthetic */ com.bytedance.android.live.effect.api.k.e $listener;

    public LiveStickerDataManager$fetchRewardEffectList$1(com.bytedance.android.live.effect.api.k.e r1) {
        this.$listener = r1;
        super(1);
    }

    public final void invoke(List<? extends Effect> r2) {
        Intrinsics.checkNotNullParameter(r2, "rewardEffects");
        com.bytedance.android.live.effect.api.k.e r0 = this.$listener;
        if (r0 == null) goto L6;
        r0.onFetchSuccess(r2);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((List) r1);
        return Unit.INSTANCE;
    }
}
