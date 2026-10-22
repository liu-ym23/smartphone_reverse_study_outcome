package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
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

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000\u001aH\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0006\"\u0004\b\u0000\u0010\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000\u001aD\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u000e\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0000¨\u0006\u000f"}, d2 = {"checkWindowSizeStep", "", "size", "", "step", "windowedIterator", "", "", ExifInterface.GPS_DIRECTION_TRUE, "iterator", "partialWindows", "", "reuseBuffer", "windowedSequence", "Lkotlin/sequences/Sequence;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class SlidingWindowKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.collections.SlidingWindowKt$windowedIterator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/SequenceScope;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
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

        AnonymousClass1(int r3, int r4, Iterator<? extends T> r5, boolean r6, boolean r7, Continuation<? super AnonymousClass1> r8) {
            Iterator<T> r9 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r5, Iterator.class, "com.obric.memorydata.plugin");
            Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
            this.$size = r3;
            this.$step = r4;
            this.$iterator = r9;
            this.$reuseBuffer = r6;
            this.$partialWindows = r7;
            super(2, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
            AnonymousClass1 r12 = new AnonymousClass1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, r8);
            r12.L$0 = r10;
            return (Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
            return invoke((SequenceScope) ZeusTransformUtils.preCheckCast(r3, SequenceScope.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        public final Object invoke(SequenceScope<? super List<? extends T>> r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create(r3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00e1 -> B:29:0x00e4). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0184 -> B:58:0x0187). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:69:0x01cf -> B:71:0x01d2). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r13) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L16;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L14;
            if (r1 == 3) goto L13;
            if (r1 == 4) goto L12;
            if (r1 == 5) goto L14;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            RingBuffer r2 = (RingBuffer) ZeusTransformUtils.preCheckCast(this.L$1, RingBuffer.class, "com.obric.memorydata.plugin");
            SequenceScope r4 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r13);
        L71:
            r2.removeFirst(this.$step);
        L63:
            if (r2.size() <= this.$step) goto L73;
            if (this.$reuseBuffer == false) goto L67;
            Object r14 = ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin");
        L68:
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r4;
            this.L$1 = r2;
            this.L$2 = null;
            this.label = 4;
            if (r4.yield((List) r14, r5) != r0) goto L71;
            return r0;
        L67:
            r14 = ZeusTransformUtils.preCheckCast(new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")), List.class, "com.obric.memorydata.plugin");
            goto L68
        L73:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L78;
            Continuation<? super Unit> r15 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 5;
            if (r4.yield(r2, r15) != r0) goto L78;
            return r0;
        L78:
            return Unit.INSTANCE;
        L13:
            Iterator<T> r3 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$2, Iterator.class, "com.obric.memorydata.plugin");
            RingBuffer r6 = (RingBuffer) ZeusTransformUtils.preCheckCast(this.L$1, RingBuffer.class, "com.obric.memorydata.plugin");
            SequenceScope r9 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r13);
        L58:
            r6.removeFirst(this.$step);
        L45:
            if (r3.hasNext() == false) goto L60;
            r6.add(r3.next());
            if (r6.isFull() == false) goto L45;
            int r16 = r6.size();
            int r10 = this.$size;
            if (r16 >= r10) goto L52;
            r6 = r6.expanded(r10);
            goto L45
        L52:
            if (this.$reuseBuffer == false) goto L54;
            Object r17 = ZeusTransformUtils.preCheckCast(r6, List.class, "com.obric.memorydata.plugin");
        L55:
            Continuation<? super Unit> r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r9;
            this.L$1 = r6;
            this.L$2 = r3;
            this.label = 3;
            if (r9.yield((List) r17, r11) != r0) goto L58;
            return r0;
        L54:
            r17 = ZeusTransformUtils.preCheckCast(new ArrayList((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")), List.class, "com.obric.memorydata.plugin");
            goto L55
        L60:
            if (this.$partialWindows == false) goto L78;
            r2 = r6;
            r4 = r9;
        L14:
            ResultKt.throwOnFailure(r13);
            goto L78
        L15:
            int r7 = this.I$0;
            Iterator<T> r8 = (Iterator) ZeusTransformUtils.preCheckCast(this.L$2, Iterator.class, "com.obric.memorydata.plugin");
            ArrayList r12 = (ArrayList) ZeusTransformUtils.preCheckCast(this.L$1, ArrayList.class, "com.obric.memorydata.plugin");
            SequenceScope r18 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r13);
            int r19 = r7;
        L30:
            if (this.$reuseBuffer == false) goto L32;
            r12.clear();
        L33:
            int r20 = r19;
        L20:
            if (r8.hasNext() == false) goto L35;
            T r110 = r8.next();
            if (r20 > 0) goto L23;
            r12.add(r110);
            if (r12.size() != this.$size) goto L20;
            Continuation<? super Unit> r111 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r18;
            this.L$1 = r12;
            this.L$2 = r8;
            this.I$0 = r19;
            this.label = 1;
            if (r18.yield(r12, r111) != r0) goto L30;
            return r0;
        L23:
            r20 = r20 - 1;
            goto L20
        L35:
            if ((!((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L78;
            if (this.$partialWindows == false) goto L39;
        L40:
            Continuation<? super Unit> r112 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.label = 2;
            if (r18.yield(r12, r112) != r0) goto L78;
            return r0;
        L39:
            if (r12.size() != this.$size) goto L78;
        L32:
            r12 = new ArrayList(this.$size);
            goto L33
        L16:
            ResultKt.throwOnFailure(r13);
            SequenceScope r113 = (SequenceScope) ZeusTransformUtils.preCheckCast(this.L$0, SequenceScope.class, "com.obric.memorydata.plugin");
            int r21 = RangesKt.coerceAtMost(this.$size, 1024);
            r19 = this.$step - this.$size;
            if (r19 < 0) goto L43;
            ArrayList r22 = new ArrayList(r21);
            r20 = 0;
            r18 = r113;
            r12 = r22;
            r8 = this.$iterator;
            goto L20
        L43:
            r6 = new RingBuffer(r21);
            r3 = this.$iterator;
            r9 = r113;
            goto L45
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
        StringBuilder r5 = new StringBuilder().append("Both size ").append(r3).append(" and step ").append(r4);
    L12:
        throw new IllegalArgumentException(r5.append(" must be greater than zero.").toString().toString());
    L10:
        r5 = new StringBuilder().append("size ").append(r3);
    L5:
        r0 = false;
        goto L6
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> r9, int r10, int r11, boolean r12, boolean r13) {
        Iterator r5 = (Iterator) ZeusTransformUtils.wrapperContextForParams(r9, Iterator.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "iterator");
        if (r5.hasNext() == true) goto L7;
        return (Iterator) ZeusTransformUtils.preCheckCast(EmptyIterator.INSTANCE, Iterator.class, "com.obric.memorydata.plugin");
    L7:
        return SequencesKt.iterator((Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r10, r11, r5, r13, r12, null), Function2.class, "com.obric.memorydata.plugin"));
    }

    public static final <T> Sequence<List<T>> windowedSequence(Sequence<? extends T> r8, final int r9, final int r10, final boolean r11, final boolean r12) {
        final Sequence r3 = (Sequence) ZeusTransformUtils.wrapperContextForParams(r8, Sequence.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "<this>");
        checkWindowSizeStep(r9, r10);
        return (Sequence) ZeusTransformUtils.preCheckCast(new SlidingWindowKt$windowedSequence$$inlined$Sequence$1(r3, r9, r10, r11, r12), Sequence.class, "com.obric.memorydata.plugin");
    }
}
