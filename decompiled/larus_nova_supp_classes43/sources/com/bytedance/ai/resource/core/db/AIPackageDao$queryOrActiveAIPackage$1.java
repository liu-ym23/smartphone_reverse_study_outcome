package com.bytedance.ai.resource.core.db;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.db.AIPackageDao", f = "AIPackageDao.kt", i = {0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5}, l = {44, 46, 73, 75, 83, 85}, m = "queryOrActiveAIPackage", n = {"aiPackageType", "versionCode", "aiPackageType", "versionCode", "aiPackageType", "installPkg", "inactivePkg", "finalPkg", "tempId", "finalId", "aiPackageType", "installPkg", "inactivePkg", "finalPkg", "tempId", "finalId", "installPkg", "inactivePkg", "finalPkg", "finalId", "installPkg", "inactivePkg", "finalPkg", "finalId"}, s = {"L$0", "J$0", "L$0", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "J$0", "J$1", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0"})
public final class AIPackageDao$queryOrActiveAIPackage$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageDao this$0;

    public AIPackageDao$queryOrActiveAIPackage$1(AIPackageDao r1, Continuation<? super AIPackageDao$queryOrActiveAIPackage$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.F(null, null, null, 0, this);
    }
}
