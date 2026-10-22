package com.obric.capability.schedulekit;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(k = 3, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "com.obric.capability.schedulekit.CapabilityScheduleSdk", f = "CapabilityScheduleSdk.kt", i = {}, l = {98}, m = "isDownloadAppIntentV2", n = {}, s = {})
final class CapabilityScheduleSdk$isDownloadAppIntentV2$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public CapabilityScheduleSdk$isDownloadAppIntentV2$1(b r1, Continuation<? super CapabilityScheduleSdk$isDownloadAppIntentV2$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r5) {
        this.result = r5;
        this.label |= IWakeupSessionConstant.RC_ERROR;
        b r6 = this.this$0;
        r6.getClass();
        int r1 = this.label;
        if ((r1 & IWakeupSessionConstant.RC_ERROR) == 0) goto L5;
        this.label = r1 - IWakeupSessionConstant.RC_ERROR;
        CapabilityScheduleSdk$isDownloadAppIntentV2$1 r0 = this;
    L6:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L12;
        if (r3 != 1) goto L11;
        ResultKt.throwOnFailure(r7);
    L16:
        if (((Number) r7).intValue() >= 2) goto L20;
        r4 = false;
    L20:
        return Boxing.boxBoolean(r4);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r7);
        r0.label = 1;
        r7 = c.a.a(r0);
        if (r7 != r2) goto L16;
        return r2;
    L5:
        r0 = new CapabilityScheduleSdk$isDownloadAppIntentV2$1(r6, this);
        goto L6
    }
}
