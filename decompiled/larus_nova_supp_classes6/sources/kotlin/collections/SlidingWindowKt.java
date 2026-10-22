package kotlin.collections;

import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.data.ISmModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequenceScope;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aH\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0006\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001aD\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u000e\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¨\u0006\u000f"}, d2 = {"checkWindowSizeStep", "", "size", "", "step", "windowedIterator", "", "", "T", "iterator", "partialWindows", "", "reuseBuffer", "windowedSequence", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class SlidingWindowKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.collections.SlidingWindowKt$windowedIterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", "T", "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 9, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    @DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 2, 2, 3, 3}, l = {ITaskManager.Stub.TRANSACTION_getAllConditionTaskRecords, ITaskManager.Stub.TRANSACTION_unregisterEventTaskChangeListener, ITaskManager.Stub.TRANSACTION_getShortInstructNotNullShortcutTasks, ITaskManager.Stub.TRANSACTION_removeEventTaskRecordsById, ITaskManager.Stub.TRANSACTION_getEventTaskExecutionRecords}, m = "invokeSuspend", n = {"$this$iterator", "buffer", "gap", "$this$iterator", "buffer", "$this$iterator", "buffer"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1"})
    public static final class AnonymousClass1<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Iterator<T> $iterator;
        final /* synthetic */ boolean $partialWindows;
        final /* synthetic */ boolean $reuseBuffer;
        final /* synthetic */ int $size;
        final /* synthetic */ int $step;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(int r1, int r2, Iterator<? extends T> r3, boolean r4, boolean r5, Continuation<? super AnonymousClass1> r6) {
            this.$size = r1;
            this.$step = r2;
            this.$iterator = r3;
            this.$reuseBuffer = r4;
            this.$partialWindows = r5;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            AnonymousClass1 r7 = new AnonymousClass1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, r10);
            r7.L$0 = r9;
            return r7;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((SequenceScope) r1, (Continuation) r2);
        }

        public final Object invoke(SequenceScope<? super List<? extends T>> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a6 -> B:16:0x0058). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x011d -> B:59:0x0120). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x014b -> B:72:0x014e). Please report as a decompilation issue!!! */
        public final Object invokeSuspend(Object r12) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L17;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L13;
            if (r1 == 4) goto L12;
            if (r1 == 5) goto L14;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            RingBuffer r2 = (RingBuffer) this.L$1;
            SequenceScope r4 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r12);
            AnonymousClass1<T> r13 = this;
        L72:
            r2.removeFirst(r13.$step);
        L64:
            if (r2.size() <= r13.$step) goto L74;
            if (r13.$reuseBuffer == false) goto L68;
            RingBuffer r5 = r2;
        L69:
            r13.L$0 = r4;
            r13.L$1 = r2;
            r13.L$2 = null;
            r13.label = 4;
            if (r4.yield(r5, r13) != r0) goto L72;
            return r0;
        L68:
            r5 = new ArrayList(r2);
            goto L69
        L74:
            if ((!r2.isEmpty()) == false) goto L79;
            r13.L$0 = null;
            r13.L$1 = null;
            r13.L$2 = null;
            r13.label = 5;
            if (r4.yield(r2, r13) != r0) goto L79;
            return r0;
        L79:
            return Unit.INSTANCE;
        L13:
            Iterator<T> r3 = (Iterator) this.L$2;
            RingBuffer r6 = (RingBuffer) this.L$1;
            SequenceScope r8 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r12);
            r13 = this;
        L59:
            r6.removeFirst(r13.$step);
        L46:
            if (r3.hasNext() == false) goto L61;
            r6.add(r3.next());
            if (r6.isFull() == false) goto L46;
            int r9 = r6.size();
            int r10 = r13.$size;
            if (r9 >= r10) goto L53;
            r6 = r6.expanded(r10);
            goto L46
        L53:
            if (r13.$reuseBuffer == false) goto L55;
            RingBuffer r11 = r6;
        L56:
            r13.L$0 = r8;
            r13.L$1 = r6;
            r13.L$2 = r3;
            r13.label = 3;
            if (r8.yield(r11, r13) != r0) goto L59;
            return r0;
        L55:
            r11 = new ArrayList(r6);
            goto L56
        L61:
            if (r13.$partialWindows == false) goto L79;
            r2 = r6;
            r4 = r8;
        L14:
            ResultKt.throwOnFailure(r12);
            goto L79
        L15:
            int r7 = this.I$0;
            Iterator<T> r14 = (Iterator) this.L$2;
            ArrayList r15 = (ArrayList) this.L$1;
            SequenceScope r16 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r12);
            AnonymousClass1<T> r17 = this;
        L16:
            int r18 = r7;
            if (r17.$reuseBuffer == false) goto L33;
            r15.clear();
        L34:
            r7 = r18;
        L21:
            if (r14.hasNext() == false) goto L36;
            T r19 = r14.next();
            if (r18 > 0) goto L24;
            r15.add(r19);
            if (r15.size() != r17.$size) goto L21;
            r17.L$0 = r16;
            r17.L$1 = r15;
            r17.L$2 = r14;
            r17.I$0 = r7;
            r17.label = 1;
            if (r16.yield(r15, r17) != r0) goto L16;
            return r0;
        L24:
            r18 = r18 - 1;
            goto L21
        L36:
            if ((!r15.isEmpty()) == false) goto L79;
            if (r17.$partialWindows == false) goto L40;
        L41:
            r17.L$0 = null;
            r17.L$1 = null;
            r17.L$2 = null;
            r17.label = 2;
            if (r16.yield(r15, r17) != r0) goto L79;
            return r0;
        L40:
            if (r15.size() != r17.$size) goto L79;
        L33:
            r15 = new ArrayList(r17.$size);
            goto L34
        L17:
            ResultKt.throwOnFailure(r12);
            SequenceScope r110 = (SequenceScope) this.L$0;
            int r20 = RangesKt.coerceAtMost(this.$size, ISmModel.VERSION_0400);
            int r21 = this.$step - this.$size;
            if (r21 < 0) goto L44;
            r16 = r110;
            r15 = new ArrayList(r20);
            r18 = 0;
            r14 = this.$iterator;
            r7 = r21;
            r17 = this;
            goto L21
        L44:
            r6 = new RingBuffer(r20);
            r3 = this.$iterator;
            r8 = r110;
            r13 = this;
            goto L46
        }
    }

    public static final void checkWindowSizeStep(int r3, int r4) {
        if (r3 <= 0) goto L5;
        if (r4 <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (r3 == r4) goto L10;
        String r5 = "Both size " + r3 + " and step " + r4 + " must be greater than zero.";
    L12:
        throw new IllegalArgumentException(r5.toString());
    L10:
        r5 = "size " + r3 + " must be greater than zero.";
    L5:
        r0 = false;
        goto L6
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> r8, int r9, int r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r8, "iterator");
        if (r8.hasNext() == true) goto L7;
        return EmptyIterator.INSTANCE;
    L7:
        return SequencesKt.iterator(new AnonymousClass1(r9, r10, r8, r12, r11, null));
    }

    public static final <T> Sequence<List<T>> windowedSequence(final Sequence<? extends T> r7, final int r8, final int r9, final boolean r10, final boolean r11) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        checkWindowSizeStep(r8, r9);
        return new SlidingWindowKt$windowedSequence$$inlined$Sequence$1(r7, r8, r9, r10, r11);
    }
}
