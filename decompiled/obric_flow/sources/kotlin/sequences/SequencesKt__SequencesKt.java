package kotlin.sequences;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.internal.InlineOnly;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\bø\u0001\u0000\u001a\u0012\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001ab\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\f2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00050\u000eH\u0000\u001a&\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a<\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000e\u001a=\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u0001H\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u000eH\u0007¢\u0006\u0002\u0010\u0014\u001a+\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0017\"\u0002H\u0002¢\u0006\u0002\u0010\u0018\u001a\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001aC\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00050\u000eH\u0002¢\u0006\u0002\b\u001c\u001a)\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001d0\u0001H\u0007¢\u0006\u0002\b\u001e\u001a\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a2\u0010\u001f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0007\u001a!\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\b\u001a\u001e\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a&\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0007\u001a@\u0010%\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0'0&\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\b*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0&0\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, d2 = {"Sequence", "Lkotlin/sequences/Sequence;", ExifInterface.GPS_DIRECTION_TRUE, "iterator", "Lkotlin/Function0;", "", "emptySequence", "flatMapIndexed", "R", "C", "source", "transform", "Lkotlin/Function2;", "", "Lkotlin/Function1;", "generateSequence", "", "nextFunction", "seedFunction", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "asSequence", "constrainOnce", "flatten", "flatten$SequencesKt__SequencesKt", "", "flattenSequenceOfIterable", "ifEmpty", "defaultValue", "orEmpty", "shuffled", "random", "Lkotlin/random/Random;", "unzip", "Lkotlin/Pair;", "", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/sequences/SequencesKt")
class SequencesKt__SequencesKt extends SequencesKt__SequencesJVMKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "C", "R", "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0}, l = {350}, m = "invokeSuspend", n = {"$this$sequence", "index"}, s = {"L$0", "I$0"})
    public static final class C02451<R> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<C, Iterator<R>> $iterator;
        final /* synthetic */ Sequence<T> $source;
        final /* synthetic */ Function2<Integer, T, C> $transform;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public C02451(Sequence<? extends T> r5, Function2<? super Integer, ? super T, ? extends C> r10, Function1<? super C, ? extends Iterator<? extends R>> r11, Continuation<? super C02451> r12) {
            this.$source = r5;
            this.$transform = r10;
            this.$iterator = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            C02451 r11 = new C02451(this.$source, this.$transform, this.$iterator, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(Object r5, Continuation<? super Unit> r10) {
            return invoke((SequenceScope) r5, r10);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            int r12 = this.I$0;
            Iterator r13 = (Iterator) this.L$1;
            SequenceScope r14 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r10);
            int r15 = r12;
        L10:
            if (r13.hasNext() == false) goto L19;
            Object r16 = r13.next();
            Function2<Integer, T, C> r17 = this.$transform;
            int r18 = r15 + 1;
            if (r15 >= 0) goto L14;
            CollectionsKt.throwIndexOverflow();
        L14:
            Iterator<R> r19 = this.$iterator.invoke((C) r17.mo2invoke(Boxing.boxInt(r15), (T) r16));
            this.L$0 = r14;
            this.L$1 = r13;
            this.I$0 = r18;
            this.label = 1;
            if (r14.yieldAll(r19, this) == r5) goto L16;
            r15 = r18;
            goto L10
        L16:
            return r5;
        L19:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            r14 = (SequenceScope) this.L$0;
            r15 = 0;
            r13 = this.$source.iterator();
            goto L10
        }

        public final Object invoke(SequenceScope<? super R> r5, Continuation<? super Unit> r10) {
            return ((C02451) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", i = {}, l = {69, 71}, m = "invokeSuspend", n = {}, s = {})
    public static final class C02491<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Sequence<T>> $defaultValue;
        final /* synthetic */ Sequence<T> $this_ifEmpty;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public C02491(Sequence<? extends T> r5, Function0<? extends Sequence<? extends T>> r10, Continuation<? super C02491> r11) {
            this.$this_ifEmpty = r5;
            this.$defaultValue = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            C02491 r11 = new C02491(this.$this_ifEmpty, this.$defaultValue, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(Object r5, Continuation<? super Unit> r10) {
            return invoke((SequenceScope) r5, r10);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L10;
            if (r11 == 1) goto L9;
            if (r11 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
        L19:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r10);
            SequenceScope r12 = (SequenceScope) this.L$0;
            Iterator<? extends T> r13 = this.$this_ifEmpty.iterator();
            if (r13.hasNext() == false) goto L15;
            this.label = 1;
            if (r12.yieldAll(r13, this) != r5) goto L19;
            return r5;
        L15:
            Sequence<T> r14 = this.$defaultValue.invoke();
            this.label = 2;
            if (r12.yieldAll(r14, this) != r5) goto L19;
            return r5;
        }

        public final Object invoke(SequenceScope<? super T> r5, Continuation<? super Unit> r10) {
            return ((C02491) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.sequences.SequencesKt__SequencesKt$shuffled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/sequences/SequenceScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
    public static final class C02501<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Random $random;
        final /* synthetic */ Sequence<T> $this_shuffled;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        public C02501(Sequence<? extends T> r5, Random r10, Continuation<? super C02501> r11) {
            this.$this_shuffled = r5;
            this.$random = r10;
            super(2, r11);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
            C02501 r11 = new C02501(this.$this_shuffled, this.$random, r10);
            r11.L$0 = r5;
            return r11;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2invoke(Object r5, Continuation<? super Unit> r10) {
            return invoke((SequenceScope) r5, r10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L8;
            if (r11 != 1) goto L7;
            List r12 = (List) this.L$1;
            SequenceScope r13 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r10);
            SequenceScope r14 = r13;
        L10:
            if (r12.isEmpty() == true) goto L18;
            int r15 = this.$random.nextInt(r12.size());
            Object r16 = CollectionsKt.removeLast(r12);
            if (r15 >= r12.size()) goto L14;
            r16 = r12.set(r15, r16);
        L14:
            this.L$0 = r14;
            this.L$1 = r12;
            this.label = 1;
            if (r14.yield(r16, this) != r5) goto L10;
            return r5;
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            SequenceScope r17 = (SequenceScope) this.L$0;
            r12 = SequencesKt___SequencesKt.toMutableList(this.$this_shuffled);
            r14 = r17;
            goto L10
        }

        public final Object invoke(SequenceScope<? super T> r5, Continuation<? super Unit> r10) {
            return ((C02501) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public SequencesKt__SequencesKt() {
    }

    @InlineOnly
    private static final <T> Sequence<T> Sequence(final Function0<? extends Iterator<? extends T>> r5) {
        Intrinsics.checkNotNullParameter(r5, "iterator");
        return new AnonymousClass1(r5);
    }

    public static <T> Sequence<T> asSequence(final Iterator<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return constrainOnce(new SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(r5));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Sequence<T> constrainOnce(Sequence<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if ((r5 instanceof ConstrainedOnceSequence) == false) goto L6;
        return r5;
    L6:
        return new ConstrainedOnceSequence(r5);
    }

    public static <T> Sequence<T> emptySequence() {
        return EmptySequence.INSTANCE;
    }

    public static final <T, C, R> Sequence<R> flatMapIndexed(Sequence<? extends T> r5, Function2<? super Integer, ? super T, ? extends C> r10, Function1<? super C, ? extends Iterator<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r5, "source");
        Intrinsics.checkNotNullParameter(r10, "transform");
        Intrinsics.checkNotNullParameter(r11, "iterator");
        return SequencesKt__SequenceBuilderKt.sequence(new C02451(r5, r10, r11, null));
    }

    public static final <T> Sequence<T> flatten(Sequence<? extends Sequence<? extends T>> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return flatten$SequencesKt__SequencesKt(r5, C02461.INSTANCE);
    }

    private static final <T, R> Sequence<R> flatten$SequencesKt__SequencesKt(Sequence<? extends T> r5, Function1<? super T, ? extends Iterator<? extends R>> r10) {
        if ((r5 instanceof TransformingSequence) == false) goto L7;
        return ((TransformingSequence) r5).flatten$kotlin_stdlib(r10);
    L7:
        return new FlatteningSequence(r5, AnonymousClass3.INSTANCE, r10);
    }

    @JvmName(name = "flattenSequenceOfIterable")
    public static <T> Sequence<T> flattenSequenceOfIterable(Sequence<? extends Iterable<? extends T>> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return flatten$SequencesKt__SequencesKt(r5, AnonymousClass2.INSTANCE);
    }

    public static <T> Sequence<T> generateSequence(final Function0<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "nextFunction");
        return constrainOnce(new GeneratorSequence(r5, new C02471(r5)));
    }

    @SinceKotlin(version = "1.3")
    public static final <T> Sequence<T> ifEmpty(Sequence<? extends T> r5, Function0<? extends Sequence<? extends T>> r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "defaultValue");
        return SequencesKt__SequenceBuilderKt.sequence(new C02491(r5, r10, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Sequence<T> orEmpty(Sequence<? extends T> r5) {
        if (r5 == 0) goto L4;
        return r5;
    L4:
        return emptySequence();
    }

    public static <T> Sequence<T> sequenceOf(T... r5) {
        Intrinsics.checkNotNullParameter(r5, "elements");
        return ArraysKt.asSequence(r5);
    }

    @SinceKotlin(version = "1.4")
    public static final <T> Sequence<T> shuffled(Sequence<? extends T> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return shuffled(r5, Random.Default);
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Sequence<? extends Pair<? extends T, ? extends R>> r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        ArrayList r10 = new ArrayList();
        ArrayList r11 = new ArrayList();
        Iterator<? extends Pair<? extends T, ? extends R>> r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L7;
        Pair<? extends T, ? extends R> r13 = r12.next();
        r10.add(r13.getFirst());
        r11.add(r13.getSecond());
        goto L4
    L7:
        return TuplesKt.to(r10, r11);
    }

    @LowPriorityInOverloadResolution
    public static <T> Sequence<T> generateSequence(final T r5, Function1<? super T, ? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "nextFunction");
        if (r5 != null) goto L6;
        return EmptySequence.INSTANCE;
    L6:
        return new GeneratorSequence(new C02482(r5), r10);
    }

    @SinceKotlin(version = "1.4")
    public static final <T> Sequence<T> shuffled(Sequence<? extends T> r5, Random r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "random");
        return SequencesKt__SequenceBuilderKt.sequence(new C02501(r5, r10, null));
    }

    public static <T> Sequence<T> generateSequence(Function0<? extends T> r5, Function1<? super T, ? extends T> r10) {
        Intrinsics.checkNotNullParameter(r5, "seedFunction");
        Intrinsics.checkNotNullParameter(r10, "nextFunction");
        return new GeneratorSequence(r5, r10);
    }
}
