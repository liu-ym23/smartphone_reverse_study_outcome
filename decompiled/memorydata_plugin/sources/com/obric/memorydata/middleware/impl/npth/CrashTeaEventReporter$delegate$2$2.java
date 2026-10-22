package com.obric.memorydata.middleware.impl.npth;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class CrashTeaEventReporter$delegate$2$2 extends FunctionReferenceImpl implements Function1<String, Unit> {
    CrashTeaEventReporter$delegate$2$2(Object r8) {
        super(1, r8, a.class, "logFailure", "logFailure(Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(String r3) {
        invoke2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r3) {
        Intrinsics.checkNotNullParameter(r3, "p0");
        a.a((a) ZeusTransformUtils.preCheckCast(this.receiver, a.class, "com.obric.memorydata.plugin"), r3);
    }
}
