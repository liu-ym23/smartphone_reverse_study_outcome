package com.obric.memorydata.task.scheduler.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class TaskSerialExecutor$cancelActiveTaskId$targets$1$active$1 extends FunctionReferenceImpl implements Function1<d.a, a> {
    public static final TaskSerialExecutor$cancelActiveTaskId$targets$1$active$1 INSTANCE = null;

    static {
        INSTANCE = new TaskSerialExecutor$cancelActiveTaskId$targets$1$active$1();
    }

    TaskSerialExecutor$cancelActiveTaskId$targets$1$active$1() {
        super(1, d.a.class, "getEnqueueRunnable", "getEnqueueRunnable()Lcom/obric/memorydata/task/scheduler/impl/EnqueueRunnable;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final a invoke2(d.a r1) {
        Intrinsics.checkNotNullParameter(r1, "p0");
        return r1.b();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ a invoke(d.a r3) {
        return invoke2((d.a) ZeusTransformUtils.preCheckCast(r3, d.a.class, "com.obric.memorydata.plugin"));
    }
}
