package com.ss.android.lark.forwardv3;

import com.ss.android.lark.forwardv3.data.ForwardTargetBaseInfoNew;
import com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/forwardv3/ExternalForwardOutcome;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.forwardv3.ExternalForwardSendHelperKt$awaitExternalForwardOutcome$2", f = "ExternalForwardSendHelper.kt", i = {0}, l = {596}, m = "invokeSuspend", n = {"timeoutScope"}, s = {"L$0"})
public final class ExternalForwardSendHelperKt$awaitExternalForwardOutcome$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.ss.android.lark.forwardv3.a>, Object> {
    final /* synthetic */ Function2<CoroutineScope, IExternalForwardExecutor.a, Unit> $execute;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public static final class a implements IExternalForwardExecutor.a {
        public final /* synthetic */ AtomicBoolean a;
        public final /* synthetic */ kotlinx.coroutines.i<com.ss.android.lark.forwardv3.a> b;

        @Override // com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor.a
        public final void onFailure(String r6) {
            Intrinsics.checkNotNullParameter(r6, "errorMsg");
            ExternalForwardSendHelperKt$awaitExternalForwardOutcome$2.access$invokeSuspend$lambda$0$complete(this.a, this.b, new com.ss.android.lark.forwardv3.a.C0071a(r6, null, 6));
        }

        @Override // com.ss.android.lark.forwardv3.dependency.IExternalForwardExecutor.a
        public final void onSuccess(Map<String, ? extends ForwardTargetBaseInfoNew> r4) {
            Intrinsics.checkNotNullParameter(r4, "result");
            ExternalForwardSendHelperKt$awaitExternalForwardOutcome$2.access$invokeSuspend$lambda$0$complete(this.a, this.b, new com.ss.android.lark.forwardv3.a.b(r4));
        }

        public a(AtomicBoolean r1, kotlinx.coroutines.j r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public ExternalForwardSendHelperKt$awaitExternalForwardOutcome$2(Function2<? super CoroutineScope, ? super IExternalForwardExecutor.a, Unit> r1, Continuation<? super ExternalForwardSendHelperKt$awaitExternalForwardOutcome$2> r2) {
        this.$execute = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ExternalForwardSendHelperKt$awaitExternalForwardOutcome$2 r0 = new ExternalForwardSendHelperKt$awaitExternalForwardOutcome$2(this.$execute, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.ss.android.lark.forwardv3.a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        Function2 r2 = (Function2) this.L$1;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r7);
    L20:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        Function2<CoroutineScope, IExternalForwardExecutor.a, Unit> r4 = this.$execute;
        this.L$0 = r8;
        this.L$1 = r4;
        this.label = 1;
        kotlinx.coroutines.j r5 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(this), 1);
        r5.C();
        final AtomicBoolean r6 = new AtomicBoolean(false);
        r5.i(new ExternalForwardSendHelperKt$awaitExternalForwardOutcome$2$1$1(r6));
        r4.invoke(r8, new a(r6, r5));     // Catch: Throwable -> L11
    L15:
        r7 = r5.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L18;
        DebugProbesKt.probeCoroutineSuspended(this);
    L18:
        if (r7 != r0) goto L20;
        return r0;
    L11:
        th = move-exception;
        if ((th instanceof CancellationException) == true) goto L21;
        access$invokeSuspend$lambda$0$complete(r6, r5, new com.ss.android.lark.forwardv3.a.C0071a("", th, 4));
        goto L15
    L21:
        throw th;
    }

    public static final void access$invokeSuspend$lambda$0$complete(AtomicBoolean r2, kotlinx.coroutines.i r3, com.ss.android.lark.forwardv3.a r4) {
        if (r2.compareAndSet(false, true) == false) goto L6;
        r3.resumeWith(Result.constructor-impl(r4));
        return;
    }
}
