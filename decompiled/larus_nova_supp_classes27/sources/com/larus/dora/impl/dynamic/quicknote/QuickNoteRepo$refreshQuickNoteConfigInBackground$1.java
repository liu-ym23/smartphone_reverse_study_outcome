package com.larus.dora.impl.dynamic.quicknote;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.network.z;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.quicknote.QuickNoteRepo$refreshQuickNoteConfigInBackground$1", f = "QuickNoteRepo.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
public final class QuickNoteRepo$refreshQuickNoteConfigInBackground$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    private /* synthetic */ Object L$0;
    int label;

    public QuickNoteRepo$refreshQuickNoteConfigInBackground$1(DoraDevice r1, Continuation<? super QuickNoteRepo$refreshQuickNoteConfigInBackground$1> r2) {
        this.$device = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        QuickNoteRepo$refreshQuickNoteConfigInBackground$1 r0 = new QuickNoteRepo$refreshQuickNoteConfigInBackground$1(this.$device, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 != 1) goto L9;
        DoraDevice r2 = (DoraDevice) this.L$0;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L17
    L15:
        QuickNoteRepo.a.getClass();     // Catch: Throwable -> L17
        QuickNoteRepo.n(r2, (z) r4);     // Catch: Throwable -> L17
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L23;
        g49.d.c("QuickNoteRepo", "refreshQuickNoteConfigInBackground failed.", r6);
    L23:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r4);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        DoraDevice r8 = this.$device;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L17
        QuickNoteRepo r9 = QuickNoteRepo.a;     // Catch: Throwable -> L17
        this.L$0 = r8;     // Catch: Throwable -> L17
        this.label = 1;     // Catch: Throwable -> L17
        Object r10 = r9.g(r8, this);     // Catch: Throwable -> L17
        if (r10 != r0) goto L14;
        return r0;
    L14:
        r2 = r8;
        r4 = r10;
    L17:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }
}
