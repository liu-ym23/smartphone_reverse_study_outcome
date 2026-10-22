package kotlin.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
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

/* JADX INFO: loaded from: classes2.dex */
public final class SlidingWindowKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.collections.SlidingWindowKt$windowedIterator$1, reason: invalid class name */
    @DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 2, 2, 3, 3}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "buffer", "gap", "$this$iterator", "buffer", "$this$iterator", "buffer"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1"})
    static final class AnonymousClass1<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
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
        AnonymousClass1(int r10, int r11, Iterator<? extends T> r12, boolean r13, boolean r14, Continuation<? super AnonymousClass1> r15) {
            this.$size = r10;
            this.$step = r11;
            this.$iterator = r12;
            this.$reuseBuffer = r13;
            this.$partialWindows = r14;
            super(2, r15);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r10, Continuation<? super Unit> r11) {
            return invoke((SequenceScope) r10, r11);
        }

        public final Object invoke(SequenceScope<? super List<? extends T>> r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00a1 -> B:29:0x00a4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0117 -> B:58:0x011a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x0145 -> B:71:0x0148). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L16;
            if (r11 == 1) goto L15;
            if (r11 == 2) goto L14;
            if (r11 == 3) goto L13;
            if (r11 == 4) goto L12;
            if (r11 == 5) goto L14;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            RingBuffer r13 = (RingBuffer) this.L$1;
            SequenceScope r14 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r12);
        L71:
            r13.removeFirst(this.$step);
        L63:
            if (r13.size() <= this.$step) goto L73;
            if (this.$reuseBuffer == false) goto L67;
            RandomAccess r15 = r13;
        L68:
            this.L$0 = r14;
            this.L$1 = r13;
            this.L$2 = null;
            this.label = 4;
            if (r14.yield(r15, this) != r10) goto L71;
            return r10;
        L67:
            r15 = new ArrayList(r13);
            goto L68
        L73:
            if ((!r13.isEmpty()) == false) goto L78;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 5;
            if (r14.yield(r13, this) != r10) goto L78;
            return r10;
        L78:
            return Unit.INSTANCE;
        L13:
            Iterator<T> r16 = (Iterator) this.L$2;
            RingBuffer r17 = (RingBuffer) this.L$1;
            SequenceScope r18 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r12);
        L58:
            r17.removeFirst(this.$step);
        L45:
            if (r16.hasNext() == false) goto L60;
            r17.add(r16.next());
            if (r17.isFull() == false) goto L45;
            int r19 = r17.size();
            int r20 = this.$size;
            if (r19 >= r20) goto L52;
            r17 = r17.expanded(r20);
            goto L45
        L52:
            if (this.$reuseBuffer == false) goto L54;
            RandomAccess r110 = r17;
        L55:
            this.L$0 = r18;
            this.L$1 = r17;
            this.L$2 = r16;
            this.label = 3;
            if (r18.yield(r110, this) != r10) goto L58;
            return r10;
        L54:
            r110 = new ArrayList(r17);
            goto L55
        L60:
            if (this.$partialWindows == false) goto L78;
            r13 = r17;
            r14 = r18;
        L14:
            ResultKt.throwOnFailure(r12);
            goto L78
        L15:
            int r21 = this.I$0;
            Iterator<T> r22 = (Iterator) this.L$2;
            ArrayList r23 = (ArrayList) this.L$1;
            SequenceScope r24 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r12);
            int r25 = r21;
        L30:
            if (this.$reuseBuffer == false) goto L32;
            r23.clear();
        L33:
            int r26 = r25;
        L20:
            if (r22.hasNext() == false) goto L35;
            T r111 = r22.next();
            if (r26 > 0) goto L23;
            r23.add(r111);
            if (r23.size() != this.$size) goto L20;
            this.L$0 = r24;
            this.L$1 = r23;
            this.L$2 = r22;
            this.I$0 = r25;
            this.label = 1;
            if (r24.yield(r23, this) != r10) goto L30;
            return r10;
        L23:
            r26 = r26 - 1;
            goto L20
        L35:
            if ((!r23.isEmpty()) == false) goto L78;
            if (this.$partialWindows == false) goto L39;
        L40:
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (r24.yield(r23, this) != r10) goto L78;
            return r10;
        L39:
            if (r23.size() != this.$size) goto L78;
        L32:
            r23 = new ArrayList(this.$size);
            goto L33
        L16:
            ResultKt.throwOnFailure(r12);
            SequenceScope r112 = (SequenceScope) this.L$0;
            int r27 = RangesKt.coerceAtMost(this.$size, 1024);
            r25 = this.$step - this.$size;
            if (r25 < 0) goto L43;
            ArrayList r28 = new ArrayList(r27);
            r26 = 0;
            r24 = r112;
            r23 = r28;
            r22 = this.$iterator;
            goto L20
        L43:
            r17 = new RingBuffer(r27);
            r16 = this.$iterator;
            r18 = r112;
            goto L45
        }
    }

    public static final void checkWindowSizeStep(int r10, int r11) {
        if (r10 <= 0) goto L5;
        if (r11 <= 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return;
    L8:
        if (r10 == r11) goto L10;
        String r13 = "Both size " + r10 + " and step " + r11 + " must be greater than zero.";
    L12:
        throw new IllegalArgumentException(r13.toString());
    L10:
        r13 = "size " + r10 + " must be greater than zero.";
    L5:
        r12 = false;
        goto L6
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> r10, int r11, int r12, boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "iterator");
        if (r10.hasNext() == true) goto L7;
        return EmptyIterator.INSTANCE;
    L7:
        return SequencesKt.iterator(new AnonymousClass1(r11, r12, r10, r14, r13, null));
    }

    public static final <T> Sequence<List<T>> windowedSequence(final Sequence<? extends T> r10, final int r11, final int r12, final boolean r13, final boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        checkWindowSizeStep(r11, r12);
        return new SlidingWindowKt$windowedSequence$$inlined$Sequence$1(r10, r11, r12, r13, r14);
    }
}
