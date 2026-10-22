package com.obric.memorydata.memory.ui.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class ProactiveShortcutCoordinator$supersedePinRequests$1 extends FunctionReferenceImpl implements Function1<Set<? extends Long>, Unit> {
    ProactiveShortcutCoordinator$supersedePinRequests$1(Object r8) {
        super(1, r8, r.class, "abandonAll", "abandonAll(Ljava/util/Set;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Set<? extends Long> r3) {
        invoke2((Set) ZeusTransformUtils.preCheckCast(r3, Set.class, "com.obric.memorydata.plugin"));
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Set<Long> r3) {
        Set<Long> r4 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "p0");
        ((r) ZeusTransformUtils.preCheckCast(this.receiver, r.class, "com.obric.memorydata.plugin")).a(r4);
    }
}
