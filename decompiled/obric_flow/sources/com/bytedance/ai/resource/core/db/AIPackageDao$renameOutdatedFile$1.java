package com.bytedance.ai.resource.core.db;

import cn.nubia.neopush.commons.Constant;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.db.AIPackageDao", f = "AIPackageDao.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1}, l = {155, 162}, m = "renameOutdatedFile$ai_sdk_release", n = {"this", Constant.APPID, "packageName", "deploymentInfo", "fileList", "versionCode", "this", Constant.APPID, "packageName", "deploymentInfo", "fileList", "versionCode"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0"})
public final class AIPackageDao$renameOutdatedFile$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageDao this$0;

    public AIPackageDao$renameOutdatedFile$1(AIPackageDao r5, Continuation<? super AIPackageDao$renameOutdatedFile$1> r10) {
        this.this$0 = r5;
        super(r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.renameOutdatedFile$ai_sdk_release(0, null, null, null, this);
    }
}
