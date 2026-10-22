package com.bytedance.ai.resource;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager", f = "AIManager.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {1349}, m = "loadAIPackageFromGecko", n = {"packageName", BdpAwemeConstant.KEY_APP_ID, "packageType", "extraInfo", "aiPackage", "errMsg", "start$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0"})
public final class AIManager$loadAIPackageFromGecko$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIManager this$0;

    public AIManager$loadAIPackageFromGecko$1(AIManager r1, Continuation<? super AIManager$loadAIPackageFromGecko$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        AIManager r0 = this.this$0;
        AIManager r11 = AIManager.a;
        return r0.z(null, null, null, null, null, this);
    }
}
