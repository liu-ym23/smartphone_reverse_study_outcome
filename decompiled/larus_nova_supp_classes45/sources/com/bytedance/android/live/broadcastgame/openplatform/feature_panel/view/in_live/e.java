package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import com.bytedance.android.live.broadcastgame.api.model.ReloadPanelType;
import com.bytedance.android.live.broadcastgame.api.model.f0;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ LiveOpenFeatureChooseFragment a;

    public e(LiveOpenFeatureChooseFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r8) {
        SubscriberJsEvent r9 = (SubscriberJsEvent) r8;
        ALogger.d("OpenFeatureChooseListFragment", "receive " + r9.getEventName() + " event!");
        if ((!Intrinsics.areEqual(r9.getEventName(), "live_broadcast_interact_refresh_panel")) == false) goto L5;
        return;
    L5:
        if (this.a.isHidden() == false) goto L7;
        return;
    L7:
        if (this.a.isDetached() == true) goto L13;
        xs2.b.a().post(new f0("", ReloadPanelType.FROM_SEVER, false, false, 12));
        return;
    }
}
