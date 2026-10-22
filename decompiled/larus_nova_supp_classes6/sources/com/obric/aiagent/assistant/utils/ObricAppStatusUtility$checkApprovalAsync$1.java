package com.obric.aiagent.assistant.utils;

import android.os.CancellationSignal;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "com.obric.aiagent.assistant.utils.ObricAppStatusUtility", f = "ObricAppStatusUtility.kt", i = {0}, l = {114}, m = "checkApprovalAsync", n = {"cancellationSignal"}, s = {"L$0"})
final class ObricAppStatusUtility$checkApprovalAsync$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ b this$0;

    public ObricAppStatusUtility$checkApprovalAsync$1(b r1, Continuation<? super ObricAppStatusUtility$checkApprovalAsync$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r13) {
        this.result = r13;
        this.label |= IWakeupSessionConstant.RC_ERROR;
        b r14 = this.this$0;
        r14.getClass();
        int r1 = this.label;
        if ((r1 & IWakeupSessionConstant.RC_ERROR) == 0) goto L5;
        this.label = r1 - IWakeupSessionConstant.RC_ERROR;
        ObricAppStatusUtility$checkApprovalAsync$1 r0 = this;
    L6:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L12;
        if (r3 != 1) goto L11;
        CancellationSignal r4 = (CancellationSignal) r0.L$0;
        ResultKt.throwOnFailure(r15);
    L24:
        PrivacyApprovalStatus r16 = (PrivacyApprovalStatus) r15;
        if (r16 != null) goto L28;
        r4.cancel();
        r16 = PrivacyApprovalStatus.Timeout;
    L28:
        return r16;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r15);
        long r5 = System.currentTimeMillis();
        b.a r17 = b.f;
        long r6 = r17.b;
        if ((r5 - r6) < 5000) goto L15;
    L17:
        r17 = null;
    L18:
        if (r17 != null) goto L29;
        CancellationSignal r18 = new CancellationSignal();
        ObricAppStatusUtility$checkApprovalAsync$result$1 r7 = new ObricAppStatusUtility$checkApprovalAsync$result$1(null, r18, null);
        r0.L$0 = r18;
        r0.label = 1;
        Object r8 = TimeoutKt.c(2000, r7, r0);
        if (r8 == r2) goto L30;
        r4 = r18;
        r15 = r8;
        goto L24
    L30:
        return r2;
    L29:
        return r17.a;
    L15:
        if (r6 == (-1)) goto L17;
    L5:
        r0 = new ObricAppStatusUtility$checkApprovalAsync$1(r14, this);
        goto L6
    }
}
