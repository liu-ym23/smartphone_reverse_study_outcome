package kotlin.sequences;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [S] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "S", "T", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1}, l = {2368, 2371}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
public final class SequencesKt___SequencesKt$runningReduce$1<S> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super S>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<S, T, S> $operation;
    final /* synthetic */ Sequence<T> $this_runningReduce;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$runningReduce$1(Sequence<? extends T> r1, Function2<? super S, ? super T, ? extends S> r2, Continuation<? super SequencesKt___SequencesKt$runningReduce$1> r3) {
        this.$this_runningReduce = r1;
        this.$operation = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        SequencesKt___SequencesKt$runningReduce$1 r0 = new SequencesKt___SequencesKt$runningReduce$1(this.$this_runningReduce, this.$operation, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((SequenceScope) r1, (Continuation) r2);
    }

    public final Object invoke(SequenceScope<? super S> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 == 1) goto L6;
        if (r1 == 2) goto L6;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L6:
        Object r2 = this.L$2;
        Iterator r3 = (Iterator) this.L$1;
        SequenceScope r4 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r8);
    L17:
        if (r3.hasNext() == false) goto L22;
        r2 = this.$operation.invoke(r2, r3.next());
        this.L$0 = r4;
        this.L$1 = r3;
        this.L$2 = r2;
        this.label = 2;
        if (r4.yield(r2, this) != r0) goto L17;
        return r0;
    L22:
        return Unit.INSTANCE;
    L9:
        ResultKt.throwOnFailure(r8);
        r4 = (SequenceScope) this.L$0;
        Iterator r9 = this.$this_runningReduce.iterator();
        if (r9.hasNext() == false) goto L22;
        r2 = r9.next();
        this.L$0 = r4;
        this.L$1 = r9;
        this.L$2 = r2;
        this.label = 1;
        if (r4.yield(r2, this) != r0) goto L14;
        return r0;
    L14:
        r3 = r9;
        goto L17
    }
}
