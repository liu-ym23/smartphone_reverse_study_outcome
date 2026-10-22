package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\b\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0015\u0010\u0006\u001a\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lkotlinx/coroutines/flow/h;", "Lkotlinx/coroutines/flow/SharingCommand;", "", "Lkotlin/ParameterName;", "name", "value", "count", "", "<anonymous>", "(Lkotlinx/coroutines/flow/h;I)V"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {1, 2, 3}, l = {174, 176, 178, 179, 181}, m = "invokeSuspend", n = {"$this$transformLatest", "$this$transformLatest", "$this$transformLatest"}, s = {"L$0", "L$0", "L$0"})
final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<h, Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ o2 this$0;

    public StartedWhileSubscribed$command$1(o2 r5, Continuation<? super StartedWhileSubscribed$command$1> r10) {
        super(3, r10);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(h r5, Integer r10, Continuation<? super Unit> r11) {
        return invoke(r5, r10.intValue(), r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L22;
        if (r11 != 1) goto L6;
    L12:
        ResultKt.throwOnFailure(r10);
    L28:
        return Unit.INSTANCE;
    L6:
        if (r11 != 2) goto L8;
        h r12 = (h) this.L$0;
        ResultKt.throwOnFailure(r10);
        throw null;
    L8:
        if (r11 != 3) goto L10;
        h r13 = (h) this.L$0;
        ResultKt.throwOnFailure(r10);
        throw null;
    L10:
        if (r11 == 4) goto L15;
        if (r11 == 5) goto L12;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        h r14 = (h) this.L$0;
        ResultKt.throwOnFailure(r10);
        SharingCommand r15 = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
        this.L$0 = null;
        this.label = 5;
        if (r14.emit(r15, this) != r5) goto L28;
        return r5;
    L22:
        ResultKt.throwOnFailure(r10);
        h r16 = (h) this.L$0;
        if (this.I$0 <= 0) goto L29;
        SharingCommand r17 = SharingCommand.START;
        this.label = 1;
        if (r16.emit(r17, this) != r5) goto L28;
        return r5;
    L29:
        throw null;
    }

    public final Object invoke(h r5, int r10, Continuation<? super Unit> r11) {
        StartedWhileSubscribed$command$1 r12 = new StartedWhileSubscribed$command$1(null, r11);
        r12.L$0 = r5;
        r12.I$0 = r10;
        return r12.invokeSuspend(Unit.INSTANCE);
    }
}
