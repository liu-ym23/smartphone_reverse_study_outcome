package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ LiveOpenFeatureChooseFragment a;

    public c(LiveOpenFeatureChooseFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        SubscriberJsEvent r4 = (SubscriberJsEvent) r3;
        ALogger.d("OpenFeatureChooseListFragment", "receive " + r4.getEventName() + " event!");
        if ((!Intrinsics.areEqual(r4.getEventName(), "live_broadcast_interact_close_panel")) == false) goto L5;
        return;
    L5:
        if (this.a.isHidden() == false) goto L7;
        return;
    L7:
        if (this.a.isDetached() == false) goto L17;
        return;
    L17:
        this.a.dismiss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r5 = DialogFragmentLancet.sLastShowStack;
        if (r5 == null) goto L21;
        com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
