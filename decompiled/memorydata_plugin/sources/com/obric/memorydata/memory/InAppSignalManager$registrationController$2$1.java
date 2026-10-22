package com.obric.memorydata.memory;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* synthetic */ class InAppSignalManager$registrationController$2$1 extends FunctionReferenceImpl implements Function0<Boolean> {
    InAppSignalManager$registrationController$2$1(Object r8) {
        super(0, r8, k.class, "isDebugTraceCollectionEnabled", "isDebugTraceCollectionEnabled()Z", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Boolean invoke() {
        return Boolean.valueOf(((k) ZeusTransformUtils.preCheckCast(this.receiver, k.class, "com.obric.memorydata.plugin")).b());
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return invoke();
    }
}
