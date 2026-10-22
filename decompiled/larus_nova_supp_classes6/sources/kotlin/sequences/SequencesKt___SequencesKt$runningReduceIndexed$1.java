package kotlin.sequences;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [S] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u008a@"}, d2 = {"<anonymous>", "", "S", "T", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {2397, 2401}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator", "index"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
public final class SequencesKt___SequencesKt$runningReduceIndexed$1<S> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super S>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Integer, S, T, S> $operation;
    final /* synthetic */ Sequence<T> $this_runningReduceIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$runningReduceIndexed$1(Sequence<? extends T> r1, Function3<? super Integer, ? super S, ? super T, ? extends S> r2, Continuation<? super SequencesKt___SequencesKt$runningReduceIndexed$1> r3) {
        this.$this_runningReduceIndexed = r1;
        this.$operation = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        SequencesKt___SequencesKt$runningReduceIndexed$1 r0 = new SequencesKt___SequencesKt$runningReduceIndexed$1(this.$this_runningReduceIndexed, this.$operation, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((SequenceScope) r1, (Continuation) r2);
    }

    public final Object invoke(SequenceScope<? super S> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        int r3 = 1;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        int r2 = this.I$0;
        Object r4 = this.L$2;
        Iterator r5 = (Iterator) this.L$1;
        SequenceScope r6 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r11);
        r3 = r2;
        Object r7 = r4;
    L17:
        if (r5.hasNext() == false) goto L26;
        Function3<Integer, S, T, S> r8 = this.$operation;
        int r9 = r3 + 1;
        if (r3 >= 0) goto L21;
        CollectionsKt.throwIndexOverflow();
    L21:
        Object r10 = r8.invoke(Boxing.boxInt(r3), r7, r5.next());
        this.L$0 = r6;
        this.L$1 = r5;
        this.L$2 = r10;
        this.I$0 = r9;
        this.label = 2;
        if (r6.yield(r10, this) == r0) goto L23;
        r7 = r10;
        r3 = r9;
        goto L17
    L23:
        return r0;
    L26:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r7 = this.L$2;
        r5 = (Iterator) this.L$1;
        r6 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r11);
        goto L17
    L10:
        ResultKt.throwOnFailure(r11);
        r6 = (SequenceScope) this.L$0;
        r5 = this.$this_runningReduceIndexed.iterator();
        if (r5.hasNext() == false) goto L26;
        r7 = r5.next();
        this.L$0 = r6;
        this.L$1 = r5;
        this.L$2 = r7;
        this.label = 1;
        if (r6.yield(r7, this) != r0) goto L17;
        return r0;
    }
}
