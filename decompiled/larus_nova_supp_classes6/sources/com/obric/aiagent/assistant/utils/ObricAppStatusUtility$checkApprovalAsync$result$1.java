package com.obric.aiagent.assistant.utils;

import android.content.Context;
import android.os.CancellationSignal;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/obric/aiagent/assistant/utils/PrivacyApprovalStatus;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "com.obric.aiagent.assistant.utils.ObricAppStatusUtility$checkApprovalAsync$result$1", f = "ObricAppStatusUtility.kt", i = {}, l = {123}, m = "invokeSuspend", n = {}, s = {})
final class ObricAppStatusUtility$checkApprovalAsync$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PrivacyApprovalStatus>, Object> {
    final /* synthetic */ CancellationSignal $cancellationSignal;
    final /* synthetic */ Context $context;
    int label;

    public ObricAppStatusUtility$checkApprovalAsync$result$1(Context r1, CancellationSignal r2, Continuation<? super ObricAppStatusUtility$checkApprovalAsync$result$1> r3) {
        this.$context = r1;
        this.$cancellationSignal = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ObricAppStatusUtility$checkApprovalAsync$result$1(this.$context, this.$cancellationSignal, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super PrivacyApprovalStatus> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CompletableDeferred r2 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        BuildersKt.launch$default(b.g, null, null, new 1(this.$context, this.$cancellationSignal, r2, null), 3, null);
        this.label = 1;
        r10 = r2.await(this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
