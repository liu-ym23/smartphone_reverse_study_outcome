package com.obric.audio.enroll.ui.fragment;

import com.obric.audio.enroll.ui.VoicePrintEnrollActivity;
import com.obric.audio.enroll.vm.EnrollViewModel;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.ui.fragment.EnrollingFragment$observe$4", f = "EnrollingFragment.kt", i = {0}, l = {463}, m = "invokeSuspend", n = {"networkListener"}, s = {"L$0"})
final class EnrollingFragment$observe$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ EnrollingFragment this$0;

    public EnrollingFragment$observe$4(EnrollingFragment r1, Continuation<? super EnrollingFragment$observe$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new EnrollingFragment$observe$4(this.this$0, r3);
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
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L6;
        Function1<? super Boolean, Unit> r2 = (Function1) this.L$0;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L10
    L24:
        throw new KotlinNothingValueException();     // Catch: Throwable -> L10
    L10:
        th = th;
        Function1<? super Boolean, Unit> r3 = r2;
    L27:
        EnrollingFragment.c r4 = EnrollingFragment.c.a;     // Catch: Throwable -> L29
        Intrinsics.checkNotNullParameter(r3, "listener");     // Catch: Throwable -> L29
        EnrollingFragment.c.b.remove(r3);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r6);
        EnrollViewModel r7 = this.this$0.f;
        if (r7 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r7 = null;
    L16:
        if (r7.getEnrollDeviceType() != VoicePrintEnrollActivity.Companion.EnrollDeviceType.DEFAULT) goto L32;
        final EnrollingFragment r8 = this.this$0;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L29
        final AtomicBoolean r9 = new AtomicBoolean(false);     // Catch: Throwable -> L29
        final AtomicBoolean r10 = new AtomicBoolean(false);     // Catch: Throwable -> L29
        r3 = new c0(r9, r10, r8);     // Catch: Throwable -> L29
        EnrollingFragment.c.a.a(r8.requireContext().getApplicationContext(), r3);     // Catch: Throwable -> L29
        this.L$0 = r3;     // Catch: Throwable -> L26
        this.label = 1;     // Catch: Throwable -> L26
        if (DelayKt.awaitCancellation(this) != r0) goto L22;
        return r0;
    L22:
        r2 = r3;
    L26:
        th = th;
    L32:
        return Unit.INSTANCE;
    L29:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    }
}
