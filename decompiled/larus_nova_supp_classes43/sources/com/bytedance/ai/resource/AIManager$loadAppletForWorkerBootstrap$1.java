package com.bytedance.ai.resource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager", f = "AIManager.kt", i = {0, 0, 2, 2, 2, 2, 2, 3, 3, 3, 3}, l = {234, 241, 251, 286, 320}, m = "loadAppletForWorkerBootstrap", n = {"appletId", "extraInfo", "appletId", "versionTag", "actualExtraInfo", "packageType", "start", "appletId", "actualExtraInfo", "packageType", "start"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "J$0"})
public final class AIManager$loadAppletForWorkerBootstrap$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIManager this$0;

    public AIManager$loadAppletForWorkerBootstrap$1(AIManager r1, Continuation<? super AIManager$loadAppletForWorkerBootstrap$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.D(null, null, this);
    }
}
