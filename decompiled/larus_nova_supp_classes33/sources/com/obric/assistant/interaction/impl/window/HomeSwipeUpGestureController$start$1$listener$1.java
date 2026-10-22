package com.obric.assistant.interaction.impl.window;

import com.larus.utils.logger.FLogger;
import com.obric.aiagent.product.platform.api.view.ObricWindowGestureListener;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/assistant/interaction/impl/window/HomeSwipeUpGestureController$start$1$listener$1", "Lcom/obric/aiagent/product/platform/api/view/ObricWindowGestureListener;", "onHomeSwipeUp", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HomeSwipeUpGestureController$start$1$listener$1 extends ObricWindowGestureListener {
    final /* synthetic */ HomeSwipeUpGestureController this$0;

    public void onHomeSwipeUp() {
        FLogger.a.i("HomeSwipeUpGestureCtl", "onHomeSwipeUp triggered from framework");
        HomeSwipeUpGestureController.access$getOnGestureTriggered$p(this.this$0).invoke();
    }

    public HomeSwipeUpGestureController$start$1$listener$1(HomeSwipeUpGestureController r1) {
        this.this$0 = r1;
    }
}
