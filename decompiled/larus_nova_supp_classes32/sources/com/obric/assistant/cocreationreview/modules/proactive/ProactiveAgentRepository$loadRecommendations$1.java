package com.obric.assistant.cocreationreview.modules.proactive;

import com.lynx.canvas.camera.CameraSize;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.cocreationreview.modules.proactive.ProactiveAgentRepository", f = "ProactiveAgentProvider.kt", i = {1, 1, 1, 1, 2, 2, 2, 2}, l = {CameraSize.mediumWidth, 489, 491}, m = "loadRecommendations", n = {"snapshot", "request", "todayKey", "recommendations", "snapshot", "request", "todayKey", "recommendations"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3"})
final class ProactiveAgentRepository$loadRecommendations$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProactiveAgentRepository this$0;

    public ProactiveAgentRepository$loadRecommendations$1(ProactiveAgentRepository r1, Continuation<? super ProactiveAgentRepository$loadRecommendations$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return ProactiveAgentRepository.a(this.this$0, null, null, null, false, this);
    }
}
