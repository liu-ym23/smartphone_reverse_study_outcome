package com.larus.uaigc.chat.block.create;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.larus.bmhome.social.utils.RepeatOnLifecycleKt;
import com.tencent.open.log.TraceLevel;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.chat.block.create.AbsCreationBlockView$bindObservers$1", f = "AbsCreationBlockView.kt", i = {0}, l = {161, 163}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class AbsCreationBlockView$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AbsCreationBlockView this$0;

    public AbsCreationBlockView$bindObservers$1(AbsCreationBlockView r1, Continuation<? super AbsCreationBlockView$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        AbsCreationBlockView$bindObservers$1 r0 = new AbsCreationBlockView$bindObservers$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 == 1) goto L12;
        if (r1 != 2) goto L11;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L8
    L24:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L25:
        Result.constructor-impl(r3);     // Catch: Throwable -> L8
    L29:
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r7);
    L16:
        AbsCreationBlockView r8 = this.this$0;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L8
        Fragment r5 = r8.d;     // Catch: Throwable -> L8
        r3 = null;
        if (r5 == null) goto L25;
        LifecycleOwner r6 = r5.getViewLifecycleOwner();     // Catch: Throwable -> L8
        if (r6 == null) goto L25;
        Lifecycle.State r9 = Lifecycle.State.RESUMED;     // Catch: Throwable -> L8
        AbsCreationBlockView$bindObservers$1$1$1 r10 = new AbsCreationBlockView$bindObservers$1$1$1(r8, null);     // Catch: Throwable -> L8
        this.L$0 = null;     // Catch: Throwable -> L8
        this.label = 2;     // Catch: Throwable -> L8
        if (RepeatOnLifecycleKt.b(r6, r9, r10, this) != r0) goto L24;
        return r0;
    L13:
        ResultKt.throwOnFailure(r7);
        this.L$0 = (CoroutineScope) this.L$0;
        this.label = 1;
        if (DelayKt.delay(2000, this) != r0) goto L16;
        return r0;
    L8:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    }
}
