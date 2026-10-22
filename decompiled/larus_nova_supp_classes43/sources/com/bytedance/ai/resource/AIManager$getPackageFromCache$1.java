package com.bytedance.ai.resource;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager", f = "AIManager.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 2}, l = {1609, 1191, 1202}, m = "getPackageFromCache", n = {"packageName", BdpAwemeConstant.KEY_APP_ID, "packageType", "versionTag", "$this$withLock_u24default$iv", "packageName", BdpAwemeConstant.KEY_APP_ID, "packageType", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$0"})
public final class AIManager$getPackageFromCache$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIManager this$0;

    public AIManager$getPackageFromCache$1(AIManager r1, Continuation<? super AIManager$getPackageFromCache$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        AIManager r0 = this.this$0;
        AIManager r11 = AIManager.a;
        return r0.k(null, null, null, null, this);
    }
}
