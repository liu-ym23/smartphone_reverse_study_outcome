package com.obric.memorydata.memory.ui.settings;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class ProactiveShortcutCoordinator$requestByUser$1 extends FunctionReferenceImpl implements Function1<Long, Unit> {
    ProactiveShortcutCoordinator$requestByUser$1(Object r8) {
        super(1, r8, r.class, "record", "record(J)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Unit invoke(Long r3) {
        invoke(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.memorydata.plugin")).longValue());
        return Unit.INSTANCE;
    }

    public final void invoke(long r3) {
        ((r) ZeusTransformUtils.preCheckCast(this.receiver, r.class, "com.obric.memorydata.plugin")).a(r3);
    }
}
