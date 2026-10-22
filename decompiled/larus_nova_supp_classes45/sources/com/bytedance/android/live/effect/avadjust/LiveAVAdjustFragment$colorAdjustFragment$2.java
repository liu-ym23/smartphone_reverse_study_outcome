package com.bytedance.android.live.effect.avadjust;

import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/live/effect/avadjust/LiveColorAdjustFragment;", "invoke"}, k = 3, mv = {1, 4, 3})
final class LiveAVAdjustFragment$colorAdjustFragment$2 extends Lambda implements Function0<LiveColorAdjustFragment> {
    final /* synthetic */ LiveAVAdjustFragment this$0;

    public LiveAVAdjustFragment$colorAdjustFragment$2(LiveAVAdjustFragment r1) {
        this.this$0 = r1;
        super(0);
    }

    public final LiveColorAdjustFragment invoke() {
        LiveEffectContextFactoryDelegate$Type r1 = this.this$0.getType();
        this.this$0.getClass();
        return new LiveColorAdjustFragment(r1, null);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m668invoke() {
        return invoke();
    }
}
