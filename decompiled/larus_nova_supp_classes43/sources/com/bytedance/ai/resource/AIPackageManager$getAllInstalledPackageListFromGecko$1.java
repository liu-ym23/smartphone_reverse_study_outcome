package com.bytedance.ai.resource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.AIPackageManager", f = "AIPackageManager.kt", i = {0, 0}, l = {368}, m = "getAllInstalledPackageListFromGecko$ai_sdk_release", n = {com.bytedance.android.ec.core.event.a.KEY_RESULT, "packageList"}, s = {"L$0", "L$1"})
public final class AIPackageManager$getAllInstalledPackageListFromGecko$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageManager this$0;

    public AIPackageManager$getAllInstalledPackageListFromGecko$1(AIPackageManager r1, Continuation<? super AIPackageManager$getAllInstalledPackageListFromGecko$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(this);
    }
}
