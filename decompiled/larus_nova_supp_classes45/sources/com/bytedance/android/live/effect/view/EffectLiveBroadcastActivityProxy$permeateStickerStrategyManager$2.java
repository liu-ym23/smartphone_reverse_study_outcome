package com.bytedance.android.live.effect.view;

import com.bytedance.android.live.effect.sticker.PermeateStickerStrategyManager;
import com.bytedance.android.livesdkapi.depend.model.PermeateEffectType;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/live/effect/sticker/PermeateStickerStrategyManager;", "invoke"}, k = 3, mv = {1, 4, 3})
final class EffectLiveBroadcastActivityProxy$permeateStickerStrategyManager$2 extends Lambda implements Function0<PermeateStickerStrategyManager> {
    final /* synthetic */ EffectLiveBroadcastActivityProxy this$0;

    public EffectLiveBroadcastActivityProxy$permeateStickerStrategyManager$2(EffectLiveBroadcastActivityProxy r1) {
        this.this$0 = r1;
        super(0);
    }

    public final PermeateStickerStrategyManager invoke() {
        CollectionsKt.listOf(new PermeateEffectType[]{PermeateEffectType.Config, PermeateEffectType.Campaign, PermeateEffectType.Interact, PermeateEffectType.Recommend});
        this.this$0.getClass();
        throw null;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m844invoke() {
        return invoke();
    }
}
