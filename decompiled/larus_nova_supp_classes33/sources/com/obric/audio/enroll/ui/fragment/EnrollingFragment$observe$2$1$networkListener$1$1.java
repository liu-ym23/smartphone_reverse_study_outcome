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
@DebugMetadata(c = "com.obric.audio.enroll.ui.fragment.EnrollingFragment$observe$2$1$networkListener$1$1", f = "EnrollingFragment.kt", i = {}, l = {359}, m = "invokeSuspend", n = {}, s = {})
public final class EnrollingFragment$observe$2$1$networkListener$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ EnrollingFragment this$0;

    public EnrollingFragment$observe$2$1$networkListener$1$1(EnrollingFragment r1, Continuation<? super EnrollingFragment$observe$2$1$networkListener$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        EnrollingFragment$observe$2$1$networkListener$1$1 r0 = new EnrollingFragment$observe$2$1$networkListener$1$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        Unit r2 = null;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L21
    L16:
        com.obric.audio.enroll.b.a.set(null);     // Catch: Throwable -> L21
        oia.a.b();     // Catch: Throwable -> L21
        oia.a.a();     // Catch: Throwable -> L21
        IEnrollService.a.getClass();     // Catch: Throwable -> L21
        IEnrollService r6 = IEnrollService.a.a();     // Catch: Throwable -> L21
        if (r6 == null) goto L19;
        r6.release();     // Catch: Throwable -> L21
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L21
    L19:
        Object r7 = Result.constructor-impl(r2);     // Catch: Throwable -> L21
    L23:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L27;
        FLogger.a.e("EnrollingFragment", "networkState reset failed: " + r8.getMessage());
    L27:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        EnrollingFragment r10 = this.this$0;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L21
        EnrollViewModel r11 = r10.f;     // Catch: Throwable -> L21
        if (r11 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: Throwable -> L21
        r11 = null;
    L13:
        VoicePrintEnrollRecordingsMgr r12 = r11.getRecordingManager();     // Catch: Throwable -> L21
        this.label = 1;     // Catch: Throwable -> L21
        if (r12.d(this) != r0) goto L16;
        return r0;
    L21:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }
}
