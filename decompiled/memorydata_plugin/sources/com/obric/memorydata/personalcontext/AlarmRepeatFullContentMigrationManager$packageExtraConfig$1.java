package com.obric.memorydata.personalcontext;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.core.data.IdlErrors;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.personalcontext.AlarmRepeatFullContentMigrationManager", f = "AlarmRepeatFullContentMigrationManager.kt", i = {0}, l = {117, IdlErrors.E_RejectInferDeviceOverheat}, m = "packageExtraConfig", n = {ObricMemoryConstants.KEY_PACKAGE_NAME}, s = {"L$0"})
final class AlarmRepeatFullContentMigrationManager$packageExtraConfig$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    AlarmRepeatFullContentMigrationManager$packageExtraConfig$1(b r3, Continuation<? super AlarmRepeatFullContentMigrationManager$packageExtraConfig$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return b.a(this.this$0, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
