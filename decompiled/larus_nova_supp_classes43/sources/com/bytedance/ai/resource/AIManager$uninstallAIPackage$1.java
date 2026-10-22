package com.bytedance.ai.resource;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager", f = "AIManager.kt", i = {0, 0, 0, 1, 1, 1}, l = {464, 470}, m = "uninstallAIPackage", n = {"packageName", BdpAwemeConstant.KEY_APP_ID, "packageType", "packageName", BdpAwemeConstant.KEY_APP_ID, "packageType"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
public final class AIManager$uninstallAIPackage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIManager this$0;

    public AIManager$uninstallAIPackage$1(AIManager r1, Continuation<? super AIManager$uninstallAIPackage$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.K(null, null, null, this);
    }
}
