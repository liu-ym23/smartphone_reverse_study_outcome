package com.bytedance.ai.resource;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIManager", f = "AIManager.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5}, l = {892, 899, 944, 960, 973, 998}, m = "loadAIPackage", n = {"packageName", BdpAwemeConstant.KEY_APP_ID, "packageType", "extraInfo", "versionTag", "installIfAbsent", "packageName", BdpAwemeConstant.KEY_APP_ID, "packageType", "extraInfo", "versionTag", "installIfAbsent", "start", "packageName", BdpAwemeConstant.KEY_APP_ID, "packageType", "extraInfo", "start", "packageName", BdpAwemeConstant.KEY_APP_ID, "packageType", "extraInfo", "targetPackage", "start", "versionCode", "packageName", BdpAwemeConstant.KEY_APP_ID, "packageType", "extraInfo", "targetPackage", "start", "versionCode", "packageName", BdpAwemeConstant.KEY_APP_ID, "packageType", "extraInfo", "installResult", "start"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0"})
public final class AIManager$loadAIPackage$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIManager this$0;

    public AIManager$loadAIPackage$1(AIManager r1, Continuation<? super AIManager$loadAIPackage$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.y(null, null, false, null, null, null, this);
    }
}
