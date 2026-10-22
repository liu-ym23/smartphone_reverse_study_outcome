package com.larus.project;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public /* synthetic */ class TaskProjectFragment$onViewCreated$1$3$1 extends FunctionReferenceImpl implements Function1<i, Unit> {
    public TaskProjectFragment$onViewCreated$1$3$1(Object r8) {
        super(1, r8, TaskProjectFragment.class, "onProjectClick", "onProjectClick(Lcom/larus/project/TaskProject;)V", 0);
    }

    public final void invoke(i r2) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        TaskProjectFragment.W90((TaskProjectFragment) ((CallableReference) this).receiver, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((i) r1);
        return Unit.INSTANCE;
    }
}
