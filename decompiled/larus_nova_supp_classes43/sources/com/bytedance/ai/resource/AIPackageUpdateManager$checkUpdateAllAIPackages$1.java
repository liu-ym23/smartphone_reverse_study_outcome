package com.bytedance.ai.resource;

import com.byted.cast.sink.api.CastInfo;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageUpdateManager", f = "AIPackageUpdateManager.kt", i = {2}, l = {56, 59, 61, CastInfo.TYPE_INFO}, m = "checkUpdateAllAIPackages", n = {"inactiveAIPackages"}, s = {"L$0"})
public final class AIPackageUpdateManager$checkUpdateAllAIPackages$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageUpdateManager this$0;

    public AIPackageUpdateManager$checkUpdateAllAIPackages$1(AIPackageUpdateManager r1, Continuation<? super AIPackageUpdateManager$checkUpdateAllAIPackages$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(this);
    }
}
