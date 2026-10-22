package com.obric.assistant.live.api;

import com.obric.assistant.audio.service.ObricLiveServiceDelegate;
import com.obric.assistant.state.api.v2.core.bean.ObricInteractionScene;
import com.obric.assistant.state.api.v2.core.bean.ObricState;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class c implements Function0 {
    public final /* synthetic */ ObricState a;

    public /* synthetic */ c(ObricState r1) {
        this.a = r1;
    }

    public final Object invoke() {
        ObricState r0 = this.a;
        ObricLiveServiceDelegate r1 = ObricLiveServiceDelegate.b;
        if (r1.h("aigc_generation", r0.getConversationId()) != r0) goto L6;
        r1.d(ObricInteractionScene.AIGC_GENERATION_SCENE.ordinal(), false, r0.getConversationId());
    L6:
        return Unit.INSTANCE;
    }
}
