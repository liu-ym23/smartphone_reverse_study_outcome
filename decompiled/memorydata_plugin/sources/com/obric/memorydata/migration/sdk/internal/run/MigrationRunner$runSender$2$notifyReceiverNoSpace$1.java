package com.obric.memorydata.migration.sdk.internal.run;

import com.bytedance.crash.constants.Constants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.migration.sdk.internal.run.MigrationRunner$runSender$2", f = "MigrationRunner.kt", i = {0, 0, 0}, l = {204, Constants.UPLOAD_HTTP_ERROR}, m = "invokeSuspend$notifyReceiverNoSpace", n = {"this$0", "$this$withContext", "conn"}, s = {"L$0", "L$1", "L$2"})
final class MigrationRunner$runSender$2$notifyReceiverNoSpace$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    MigrationRunner$runSender$2$notifyReceiverNoSpace$1(Continuation<? super MigrationRunner$runSender$2$notifyReceiverNoSpace$1> r3) {
        super((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return MigrationRunner$runSender$2.access$invokeSuspend$notifyReceiverNoSpace(null, null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
    }
}
