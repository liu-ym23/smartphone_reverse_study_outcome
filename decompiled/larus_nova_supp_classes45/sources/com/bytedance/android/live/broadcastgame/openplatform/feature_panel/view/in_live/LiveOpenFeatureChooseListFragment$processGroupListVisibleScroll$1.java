package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/LiveOpenFeatureChooseListFragment$b;", "it", "", "invoke", "(Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/view/in_live/LiveOpenFeatureChooseListFragment$b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class LiveOpenFeatureChooseListFragment$processGroupListVisibleScroll$1 extends Lambda implements Function1<LiveOpenFeatureChooseListFragment.b, Unit> {
    final /* synthetic */ LiveOpenFeatureChooseListFragment this$0;

    public LiveOpenFeatureChooseListFragment$processGroupListVisibleScroll$1(LiveOpenFeatureChooseListFragment r1) {
        this.this$0 = r1;
        super(1);
    }

    public final void invoke(LiveOpenFeatureChooseListFragment.b r3) {
        Intrinsics.checkNotNullParameter(r3, "it");
        LiveOpenFeatureChooseListFragment.b r0 = this.this$0.l;
        r0.a = r3.a;
        r0.b = r3.b;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((LiveOpenFeatureChooseListFragment.b) r1);
        return Unit.INSTANCE;
    }
}
