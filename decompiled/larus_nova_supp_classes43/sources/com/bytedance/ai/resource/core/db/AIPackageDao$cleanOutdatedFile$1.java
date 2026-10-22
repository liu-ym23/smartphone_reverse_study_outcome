package com.bytedance.ai.resource.core.db;

import com.byted.mgl.merge.service.api.aweme.BdpAwemeConstant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.db.AIPackageDao", f = "AIPackageDao.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {127, 127}, m = "cleanOutdatedFile$ai_sdk_release", n = {BdpAwemeConstant.KEY_APP_ID, "packageName", "digest", "deploymentInfo", "versionCode", BdpAwemeConstant.KEY_APP_ID, "packageName", "digest", "deploymentInfo", "versionCode"}, s = {"L$0", "L$1", "L$2", "L$3", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0"})
public final class AIPackageDao$cleanOutdatedFile$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageDao this$0;

    public AIPackageDao$cleanOutdatedFile$1(AIPackageDao r1, Continuation<? super AIPackageDao$cleanOutdatedFile$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(0, null, null, null, this);
    }
}
