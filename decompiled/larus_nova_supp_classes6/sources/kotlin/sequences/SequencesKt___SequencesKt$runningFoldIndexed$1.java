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

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
@DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", i = {0, 1, 1, 1}, l = {2339, 2344}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator", "index"}, s = {"L$0", "L$0", "L$1", "I$0"})
public final class SequencesKt___SequencesKt$runningFoldIndexed$1<R> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ R $initial;
    final /* synthetic */ Function3<Integer, R, T, R> $operation;
    final /* synthetic */ Sequence<T> $this_runningFoldIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public SequencesKt___SequencesKt$runningFoldIndexed$1(R r1, Sequence<? extends T> r2, Function3<? super Integer, ? super R, ? super T, ? extends R> r3, Continuation<? super SequencesKt___SequencesKt$runningFoldIndexed$1> r4) {
        this.$initial = r1;
        this.$this_runningFoldIndexed = r2;
        this.$operation = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        SequencesKt___SequencesKt$runningFoldIndexed$1 r0 = new SequencesKt___SequencesKt$runningFoldIndexed$1(this.$initial, this.$this_runningFoldIndexed, this.$operation, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((SequenceScope) r1, (Continuation) r2);
    }

    public final Object invoke(SequenceScope<? super R> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        int r2 = this.I$0;
        Iterator r3 = (Iterator) this.L$2;
        Object r4 = this.L$1;
        SequenceScope r5 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r10);
        Object r11 = r4;
        int r6 = r2;
    L16:
        if (r3.hasNext() == false) goto L25;
        Object r7 = r3.next();
        Function3<Integer, R, T, R> r8 = this.$operation;
        int r9 = r6 + 1;
        if (r6 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        Object r12 = r8.invoke(Boxing.boxInt(r6), r11, r7);
        this.L$0 = r5;
        this.L$1 = r12;
        this.L$2 = r3;
        this.I$0 = r9;
        this.label = 2;
        if (r5.yield(r12, this) == r0) goto L22;
        r11 = r12;
        r6 = r9;
        goto L16
    L22:
        return r0;
    L25:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        SequenceScope r13 = (SequenceScope) this.L$0;
        ResultKt.throwOnFailure(r10);
    L13:
        r11 = this.$initial;
        r3 = this.$this_runningFoldIndexed.iterator();
        r6 = 0;
        r5 = r13;
        goto L16
    L10:
        ResultKt.throwOnFailure(r10);
        r13 = (SequenceScope) this.L$0;
        R r14 = this.$initial;
        this.L$0 = r13;
        this.label = 1;
        if (r13.yield(r14, this) != r0) goto L13;
        return r0;
    }
}
