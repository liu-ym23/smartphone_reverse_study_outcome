package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.in_live;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d<T> implements Consumer {
    public final /* synthetic */ LiveOpenFeatureChooseFragment a;

    public d(LiveOpenFeatureChooseFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        SubscriberJsEvent r5 = (SubscriberJsEvent) r4;
        ALogger.d("OpenFeatureChooseListFragment", "receive " + r5.getEventName() + " event!");
        if ((!Intrinsics.areEqual(r5.getEventName(), "live_broadcast_interact_dialog_event")) == false) goto L5;
        return;
    L5:
        if (this.a.isHidden() == false) goto L7;
        return;
    L7:
        if (this.a.isDetached() == true) goto L37;
        Map r0 = r5.getParams();
        if (r0 != null) goto L12;
        return;
    L12:
        if (r0.containsKey("action_type") != true) goto L32;
        Map r6 = r5.getParams();
        if (r6 == null) goto L33;
        Object r7 = r6.get("action_type");
        if (r7 != null) goto L18;
        return;
    L18:
        if (r7.equals(1) == true) goto L27;
        return;
    L27:
        this.a.dismiss();     // Catch: Exception -> L22
        return;
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L36;
        com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L36:
        return;
    L33:
        return;
    L32:
        return;
    }
}
