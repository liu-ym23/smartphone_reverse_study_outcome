package com.obric.memorydata.database.index;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class IndexPendingLifecycleGatewayEngine$PendingOnlyReplayRecord$receipt$2 extends FunctionReferenceImpl implements Function0<Boolean> {
    IndexPendingLifecycleGatewayEngine$PendingOnlyReplayRecord$receipt$2(Object r8) {
        super(0, r8, IndexPendingLifecycleGatewayEngine.f.class, "finalizeOnce", "finalizeOnce()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(IndexPendingLifecycleGatewayEngine.f.a((IndexPendingLifecycleGatewayEngine.f) ZeusTransformUtils.preCheckCast(this.receiver, IndexPendingLifecycleGatewayEngine.f.class, "com.obric.memorydata.plugin")));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
