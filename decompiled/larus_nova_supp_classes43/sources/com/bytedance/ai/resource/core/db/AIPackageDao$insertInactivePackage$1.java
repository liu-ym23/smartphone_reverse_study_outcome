package com.bytedance.ai.resource.core.db;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.resource.core.db.AIPackageDao", f = "AIPackageDao.kt", i = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4}, l = {224, 226, 232, 234, 240, 246, 248}, m = "insertInactivePackage", n = {"finalPackage", "packageType", "finalPackage", "packageType", "finalPackage", "packageType", "duplicatesPackages", "finalPackage", "packageType", "duplicatesPackages", "finalPackage", "packageType"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1"})
public final class AIPackageDao$insertInactivePackage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AIPackageDao this$0;

    public AIPackageDao$insertInactivePackage$1(AIPackageDao r1, Continuation<? super AIPackageDao$insertInactivePackage$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.j(null, this);
    }
}
