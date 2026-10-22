package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {1, 2, 3}, l = {178, 180, 182, 183, 185}, m = "invokeSuspend", n = {"$this$transformLatest", "$this$transformLatest", "$this$transformLatest"}, s = {"L$0", "L$0", "L$0"})
final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<d<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ o1 this$0;

    StartedWhileSubscribed$command$1(o1 r10, Continuation<? super StartedWhileSubscribed$command$1> r11) {
        super(3, r11);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(d<? super SharingCommand> r10, Integer r11, Continuation<? super Unit> r12) {
        return invoke(r10, r11.intValue(), r12);
    }

    public final Object invoke(d<? super SharingCommand> r10, int r11, Continuation<? super Unit> r12) {
        StartedWhileSubscribed$command$1 r13 = new StartedWhileSubscribed$command$1(this.this$0, r12);
        r13.L$0 = r10;
        r13.I$0 = r11;
        return r13.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L16;
        if (r12 == 1) goto L15;
        if (r12 == 2) goto L14;
        if (r12 == 3) goto L13;
        if (r12 == 4) goto L12;
        if (r12 == 5) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        d r13 = (d) this.L$0;
        ResultKt.throwOnFailure(r10);
    L32:
        SharingCommand r14 = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
        this.L$0 = null;
        this.label = 5;
        if (r13.emit(r14, this) != r11) goto L36;
        return r11;
    L36:
        return Unit.INSTANCE;
    L13:
        r13 = (d) this.L$0;
        ResultKt.throwOnFailure(r10);
    L29:
        long r15 = o1.b(this.this$0);
        this.L$0 = r13;
        this.label = 4;
        if (DelayKt.b(r15, this) != r11) goto L32;
        return r11;
    L14:
        r13 = (d) this.L$0;
        ResultKt.throwOnFailure(r10);
    L25:
        if (o1.b(this.this$0) <= 0) goto L32;
        SharingCommand r16 = SharingCommand.STOP;
        this.L$0 = r13;
        this.label = 3;
        if (r13.emit(r16, this) != r11) goto L29;
        return r11;
    L15:
        ResultKt.throwOnFailure(r10);
        goto L36
    L16:
        ResultKt.throwOnFailure(r10);
        r13 = (d) this.L$0;
        if (this.I$0 <= 0) goto L21;
        SharingCommand r17 = SharingCommand.START;
        this.label = 1;
        if (r13.emit(r17, this) != r11) goto L36;
        return r11;
    L21:
        long r18 = o1.c(this.this$0);
        this.L$0 = r13;
        this.label = 2;
        if (DelayKt.b(r18, this) != r11) goto L25;
        return r11;
    }
}
