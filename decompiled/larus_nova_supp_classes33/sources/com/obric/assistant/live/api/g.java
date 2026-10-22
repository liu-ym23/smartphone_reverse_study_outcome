package com.obric.assistant.live.api;

import com.obric.assistant.audio.service.ObricLiveServiceDelegate;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class g implements Function0 {
    public final /* synthetic */ ObricState a;

    public /* synthetic */ g(ObricState r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ObricState r0 = this.a;
        ObricLiveServiceDelegate.b.d(ObricInteractionScene.COMPLEX_TASK_SCENE.ordinal(), false, r0.getConversationId());
        return Unit.INSTANCE;
    }
}
