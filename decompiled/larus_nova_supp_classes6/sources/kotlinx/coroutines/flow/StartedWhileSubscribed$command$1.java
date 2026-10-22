package kotlinx.coroutines.flow;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/flow/SharingCommand;", "count", ""}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "kotlinx.coroutines.flow.StartedWhileSubscribed$command$1", f = "SharingStarted.kt", i = {1, 2, 3}, l = {174, 176, 178, 179, 181}, m = "invokeSuspend", n = {"$this$transformLatest", "$this$transformLatest", "$this$transformLatest"}, s = {"L$0", "L$0", "L$0"})
public final class StartedWhileSubscribed$command$1 extends SuspendLambda implements Function3<FlowCollector<? super SharingCommand>, Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ StartedWhileSubscribed this$0;

    public StartedWhileSubscribed$command$1(StartedWhileSubscribed r1, Continuation<? super StartedWhileSubscribed$command$1> r2) {
        this.this$0 = r1;
        super(3, r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3) {
        return invoke((FlowCollector) r1, ((Number) r2).intValue(), (Continuation) r3);
    }

    public final Object invoke(FlowCollector<? super SharingCommand> r3, int r4, Continuation<? super Unit> r5) {
        StartedWhileSubscribed$command$1 r0 = new StartedWhileSubscribed$command$1(this.this$0, r5);
        r0.L$0 = r3;
        r0.I$0 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L16;
        if (r1 == 1) goto L15;
        if (r1 == 2) goto L14;
        if (r1 == 3) goto L13;
        if (r1 == 4) goto L12;
        if (r1 == 5) goto L15;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        FlowCollector r2 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r10);
    L32:
        SharingCommand r11 = SharingCommand.STOP_AND_RESET_REPLAY_CACHE;
        this.L$0 = null;
        this.label = 5;
        if (r2.emit(r11, this) != r0) goto L36;
        return r0;
    L36:
        return Unit.INSTANCE;
    L13:
        r2 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r10);
    L29:
        long r4 = this.this$0.c;
        this.L$0 = r2;
        this.label = 4;
        if (DelayKt.delay(r4, this) != r0) goto L32;
        return r0;
    L14:
        r2 = (FlowCollector) this.L$0;
        ResultKt.throwOnFailure(r10);
    L25:
        if (this.this$0.c <= 0) goto L32;
        SharingCommand r12 = SharingCommand.STOP;
        this.L$0 = r2;
        this.label = 3;
        if (r2.emit(r12, this) != r0) goto L29;
        return r0;
    L15:
        ResultKt.throwOnFailure(r10);
        goto L36
    L16:
        ResultKt.throwOnFailure(r10);
        r2 = (FlowCollector) this.L$0;
        if (this.I$0 <= 0) goto L21;
        SharingCommand r13 = SharingCommand.START;
        this.label = 1;
        if (r2.emit(r13, this) != r0) goto L36;
        return r0;
    L21:
        long r6 = this.this$0.b;
        this.L$0 = r2;
        this.label = 2;
        if (DelayKt.delay(r6, this) != r0) goto L25;
        return r0;
    }
}
