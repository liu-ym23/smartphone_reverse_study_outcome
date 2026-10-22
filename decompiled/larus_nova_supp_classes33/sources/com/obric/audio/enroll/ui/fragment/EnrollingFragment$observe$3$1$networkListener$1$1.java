package com.obric.audio.enroll.ui.fragment;

import com.larus.utils.logger.FLogger;
import com.obric.audio.enroll.IEnrollService;
import com.obric.audio.enroll.recorder.VoicePrintEnrollRecordingsMgr;
import com.obric.audio.enroll.vm.EnrollViewModel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.ui.fragment.EnrollingFragment$observe$3$1$networkListener$1$1", f = "EnrollingFragment.kt", i = {}, l = {410}, m = "invokeSuspend", n = {}, s = {})
public final class EnrollingFragment$observe$3$1$networkListener$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EnrollingFragment this$0;

    public EnrollingFragment$observe$3$1$networkListener$1$1(EnrollingFragment r1, Continuation<? super EnrollingFragment$observe$3$1$networkListener$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        EnrollingFragment$observe$3$1$networkListener$1$1 r0 = new EnrollingFragment$observe$3$1$networkListener$1$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Unit r4 = null;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        EnrollingFragment r2 = (EnrollingFragment) this.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L26
    L18:
        EnrollViewModel r7 = r2.f;     // Catch: Throwable -> L26
        if (r7 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Throwable -> L26
        r7 = null;
    L21:
        r7.getRecordingManager().k.g();     // Catch: Throwable -> L26
        IEnrollService.a.getClass();     // Catch: Throwable -> L26
        IEnrollService r8 = IEnrollService.a.a();     // Catch: Throwable -> L26
        if (r8 == null) goto L24;
        r8.release();     // Catch: Throwable -> L26
        r4 = Unit.INSTANCE;     // Catch: Throwable -> L26
    L24:
        Object r9 = Result.constructor-impl(r4);     // Catch: Throwable -> L26
    L28:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L32;
        FLogger.a.e("EnrollingFragment", "networkState reset failed(third party): " + r10.getMessage());
    L32:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r6);
        CoroutineScope r11 = (CoroutineScope) this.L$0;
        EnrollingFragment r12 = this.this$0;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L26
        EnrollViewModel r5 = r12.f;     // Catch: Throwable -> L26
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Throwable -> L26
        r5 = null;
    L14:
        VoicePrintEnrollRecordingsMgr r13 = r5.getRecordingManager();     // Catch: Throwable -> L26
        this.L$0 = r12;     // Catch: Throwable -> L26
        this.label = 1;     // Catch: Throwable -> L26
        if (r13.d(this) != r0) goto L17;
        return r0;
    L17:
        r2 = r12;
    L26:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    }
}
