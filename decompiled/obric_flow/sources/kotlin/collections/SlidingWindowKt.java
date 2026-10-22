package kotlin.collections;

import ai.j0;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aH\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0006\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001aD\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u000e\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¨\u0006\u000f"}, d2 = {"checkWindowSizeStep", "", "size", "", "step", "windowedIterator", "", "", ExifInterface.GPS_DIRECTION_TRUE, "iterator", "partialWindows", "", "reuseBuffer", "windowedSequence", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class SlidingWindowKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.collections.SlidingWindowKt$windowedIterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", i = {0, 0, 0, 2, 2, 3, 3}, l = {34, 40, 49, 55, 58}, m = "invokeSuspend", n = {"$this$iterator", "buffer", "gap", "$this$iterator", "buffer", "$this$iterator", "buffer"}, s = {"L$0", "L$1", "I$0", "L$0", "L$1", "L$0", "L$1"})
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
        public AnonymousClass1(int r5, int r10, Iterator<? extends T> r11, boolean r12, boolean r13, Continuation<? super AnonymousClass1> r14) {
            this.$size = r5;
            this.$step = r10;
            this.$iterator = r11;
            this.$reuseBuffer = r12;
            this.$partialWindows = r13;
            super(2, r14);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            AnonymousClass1 r12 = new AnonymousClass1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(Object r5, Continuation<? super Unit> r10) {
            return invoke((SequenceScope) r5, r10);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a2 -> B:16:0x0055). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x0117 -> B:59:0x011a). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x0145 -> B:72:0x0148). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r11) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r10 = this.label;
            if (r10 == 0) goto L17;
            if (r10 == 1) goto L15;
            if (r10 == 2) goto L14;
            if (r10 == 3) goto L13;
            if (r10 == 4) goto L12;
            if (r10 == 5) goto L14;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            RingBuffer r12 = (RingBuffer) this.L$1;
            SequenceScope r13 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r11);
        L72:
            r12.removeFirst(this.$step);
        L64:
            if (r12.size() <= this.$step) goto L74;
            if (this.$reuseBuffer == false) goto L68;
            RandomAccess r14 = r12;
        L69:
            this.L$0 = r13;
            this.L$1 = r12;
            this.L$2 = null;
            this.label = 4;
            if (r13.yield(r14, this) != r5) goto L72;
            return r5;
        L68:
            r14 = new ArrayList(r12);
            goto L69
        L74:
            if (r12.isEmpty() == true) goto L79;
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 5;
            if (r13.yield(r12, this) != r5) goto L79;
            return r5;
        L79:
            return Unit.INSTANCE;
        L13:
            Iterator<T> r15 = (Iterator) this.L$2;
            RingBuffer r16 = (RingBuffer) this.L$1;
            SequenceScope r17 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r11);
        L59:
            r16.removeFirst(this.$step);
        L46:
            if (r15.hasNext() == false) goto L61;
            r16.add(r15.next());
            if (r16.isFull() == false) goto L46;
            int r18 = r16.size();
            int r19 = this.$size;
            if (r18 >= r19) goto L53;
            r16 = r16.expanded(r19);
            goto L46
        L53:
            if (this.$reuseBuffer == false) goto L55;
            RandomAccess r110 = r16;
        L56:
            this.L$0 = r17;
            this.L$1 = r16;
            this.L$2 = r15;
            this.label = 3;
            if (r17.yield(r110, this) != r5) goto L59;
            return r5;
        L55:
            r110 = new ArrayList(r16);
            goto L56
        L61:
            if (this.$partialWindows == false) goto L79;
            r12 = r16;
            r13 = r17;
        L14:
            ResultKt.throwOnFailure(r11);
            goto L79
        L15:
            int r20 = this.I$0;
            Iterator<T> r21 = (Iterator) this.L$2;
            ArrayList r22 = (ArrayList) this.L$1;
            SequenceScope r23 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r11);
        L16:
            int r111 = r20;
            if (this.$reuseBuffer == false) goto L33;
            r22.clear();
        L34:
            r20 = r111;
        L21:
            if (r21.hasNext() == false) goto L36;
            T r24 = r21.next();
            if (r111 > 0) goto L24;
            r22.add(r24);
            if (r22.size() != this.$size) goto L21;
            this.L$0 = r23;
            this.L$1 = r22;
            this.L$2 = r21;
            this.I$0 = r20;
            this.label = 1;
            if (r23.yield(r22, this) != r5) goto L16;
            return r5;
        L24:
            r111 = r111 - 1;
            goto L21
        L36:
            if (r22.isEmpty() == true) goto L79;
            if (this.$partialWindows == false) goto L40;
        L41:
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (r23.yield(r22, this) != r5) goto L79;
            return r5;
        L40:
            if (r22.size() != this.$size) goto L79;
        L33:
            r22 = new ArrayList(this.$size);
            goto L34
        L17:
            ResultKt.throwOnFailure(r11);
            SequenceScope r112 = (SequenceScope) this.L$0;
            int r25 = RangesKt.coerceAtMost(this.$size, 1024);
            int r26 = this.$step - this.$size;
            if (r26 < 0) goto L44;
            r23 = r112;
            r111 = 0;
            r22 = new ArrayList(r25);
            r21 = this.$iterator;
            r20 = r26;
            goto L21
        L44:
            r16 = new RingBuffer(r25);
            r15 = this.$iterator;
            r17 = r112;
            goto L46
        }

        public final Object invoke(SequenceScope<? super List<? extends T>> r5, Continuation<? super Unit> r10) {
            return ((AnonymousClass1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public static final void checkWindowSizeStep(int r5, int r10) {
        if (r5 <= 0) goto L6;
        if (r10 <= 0) goto L6;
        return;
    L6:
        if (r5 == r10) goto L8;
        String r11 = "Both size " + r5 + " and step " + r10 + " must be greater than zero.";
    L10:
        throw new IllegalArgumentException(r11.toString());
    L8:
        r11 = j0.h(r5, "size ", " must be greater than zero.");
        goto L10
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
