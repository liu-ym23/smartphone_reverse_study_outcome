package kotlin.sequences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
class SequencesKt__SequencesKt extends SequencesKt__SequencesJVMKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0}, l = {332}, m = "invokeSuspend", n = {"$this$sequence", "index"}, s = {"L$0", "I$0"})
    static final class C04361<R> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<C, Iterator<R>> $iterator;
        final /* synthetic */ Sequence<T> $source;
        final /* synthetic */ Function2<Integer, T, C> $transform;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04361(Sequence<? extends T> r10, Function2<? super Integer, ? super T, ? extends C> r11, Function1<? super C, ? extends Iterator<? extends R>> r12, Continuation<? super C04361> r13) {
            this.$source = r10;
            this.$transform = r11;
            this.$iterator = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            C04361 r12 = new C04361(this.$source, this.$transform, this.$iterator, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r10, Continuation<? super Unit> r11) {
            return invoke((SequenceScope) r10, r11);
        }

        public final Object invoke(SequenceScope<? super R> r10, Continuation<? super Unit> r11) {
            return ((C04361) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            int r13 = this.I$0;
            Iterator r14 = (Iterator) this.L$1;
            SequenceScope r15 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r10);
        L10:
            if (r14.hasNext() == false) goto L19;
            Object r16 = r14.next();
            Function2<Integer, T, C> r17 = this.$transform;
            int r18 = r13 + 1;
            if (r13 >= 0) goto L14;
            CollectionsKt.throwIndexOverflow();
        L14:
            Object r19 = r17.invoke(Boxing.boxInt(r13), (T) r16);
            Iterator<R> r20 = this.$iterator.invoke((C) r19);
            this.L$0 = r15;
            this.L$1 = r14;
            this.I$0 = r18;
            this.label = 1;
            if (r15.yieldAll(r20, this) == r11) goto L16;
            r13 = r18;
            goto L10
        L16:
            return r11;
        L19:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            SequenceScope r21 = (SequenceScope) this.L$0;
            r13 = 0;
            r14 = this.$source.iterator();
            r15 = r21;
            goto L10
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", i = {}, l = {69, 71}, m = "invokeSuspend", n = {}, s = {})
    static final class C04401<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Sequence<T>> $defaultValue;
        final /* synthetic */ Sequence<T> $this_ifEmpty;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04401(Sequence<? extends T> r10, Function0<? extends Sequence<? extends T>> r11, Continuation<? super C04401> r12) {
            this.$this_ifEmpty = r10;
            this.$defaultValue = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            C04401 r12 = new C04401(this.$this_ifEmpty, this.$defaultValue, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r10, Continuation<? super Unit> r11) {
            return invoke((SequenceScope) r10, r11);
        }

        public final Object invoke(SequenceScope<? super T> r10, Continuation<? super Unit> r11) {
            return ((C04401) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L10;
            if (r12 == 1) goto L9;
            if (r12 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
        L19:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r10);
            SequenceScope r13 = (SequenceScope) this.L$0;
            Iterator<? extends T> r14 = this.$this_ifEmpty.iterator();
            if (r14.hasNext() == false) goto L15;
            this.label = 1;
            if (r13.yieldAll(r14, this) != r11) goto L19;
            return r11;
        L15:
            Sequence<T> r15 = this.$defaultValue.invoke();
            this.label = 2;
            if (r13.yieldAll(r15, this) != r11) goto L19;
            return r11;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: kotlin.sequences.SequencesKt__SequencesKt$shuffled$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
    static final class C04411<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Random $random;
        final /* synthetic */ Sequence<T> $this_shuffled;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04411(Sequence<? extends T> r10, Random r11, Continuation<? super C04411> r12) {
            this.$this_shuffled = r10;
            this.$random = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            C04411 r12 = new C04411(this.$this_shuffled, this.$random, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r10, Continuation<? super Unit> r11) {
            return invoke((SequenceScope) r10, r11);
        }

        public final Object invoke(SequenceScope<? super T> r10, Continuation<? super Unit> r11) {
            return ((C04411) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L8;
            if (r12 != 1) goto L7;
            List r13 = (List) this.L$1;
            SequenceScope r14 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r10);
            SequenceScope r15 = r14;
        L10:
            if ((!r13.isEmpty()) == false) goto L18;
            int r16 = this.$random.nextInt(r13.size());
            Object r17 = CollectionsKt.removeLast(r13);
            if (r16 >= r13.size()) goto L14;
            r17 = r13.set(r16, r17);
        L14:
            this.L$0 = r15;
            this.L$1 = r13;
            this.label = 1;
            if (r15.yield(r17, this) != r11) goto L10;
            return r11;
        L18:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r10);
            SequenceScope r18 = (SequenceScope) this.L$0;
            r13 = SequencesKt.toMutableList(this.$this_shuffled);
            r15 = r18;
            goto L10
        }
    }

    public SequencesKt__SequencesKt() {
    }

    @InlineOnly
    private static final <T> Sequence<T> Sequence(final Function0<? extends Iterator<? extends T>> r10) {
        Intrinsics.checkNotNullParameter(r10, "iterator");
        return new AnonymousClass1(r10);
    }

    public static <T> Sequence<T> asSequence(final Iterator<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SequencesKt.constrainOnce(new SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(r10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Sequence<T> constrainOnce(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if ((r10 instanceof ConstrainedOnceSequence) == false) goto L6;
        return r10;
    L6:
        return new ConstrainedOnceSequence(r10);
    }

    public static <T> Sequence<T> emptySequence() {
        return EmptySequence.INSTANCE;
    }

    public static final <T, C, R> Sequence<R> flatMapIndexed(Sequence<? extends T> r10, Function2<? super Integer, ? super T, ? extends C> r11, Function1<? super C, ? extends Iterator<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "transform");
        Intrinsics.checkNotNullParameter(r12, "iterator");
        return SequencesKt.sequence(new C04361(r10, r11, r12, null));
    }

    public static final <T> Sequence<T> flatten(Sequence<? extends Sequence<? extends T>> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return flatten$SequencesKt__SequencesKt(r10, C04371.INSTANCE);
    }

    private static final <T, R> Sequence<R> flatten$SequencesKt__SequencesKt(Sequence<? extends T> r10, Function1<? super T, ? extends Iterator<? extends R>> r11) {
        if ((r10 instanceof TransformingSequence) == false) goto L7;
        return ((TransformingSequence) r10).flatten$kotlin_stdlib(r11);
    L7:
        return new FlatteningSequence(r10, AnonymousClass3.INSTANCE, r11);
    }

    @JvmName(name = "flattenSequenceOfIterable")
    public static final <T> Sequence<T> flattenSequenceOfIterable(Sequence<? extends Iterable<? extends T>> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return flatten$SequencesKt__SequencesKt(r10, AnonymousClass2.INSTANCE);
    }

    @LowPriorityInOverloadResolution
    public static <T> Sequence<T> generateSequence(final T r10, Function1<? super T, ? extends T> r11) {
        Intrinsics.checkNotNullParameter(r11, "nextFunction");
        if (r10 != null) goto L6;
        return EmptySequence.INSTANCE;
    L6:
        return new GeneratorSequence(new C04392(r10), r11);
    }

    public static <T> Sequence<T> generateSequence(final Function0<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "nextFunction");
        return SequencesKt.constrainOnce(new GeneratorSequence(r10, new C04381(r10)));
    }

    public static <T> Sequence<T> generateSequence(Function0<? extends T> r10, Function1<? super T, ? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "seedFunction");
        Intrinsics.checkNotNullParameter(r11, "nextFunction");
        return new GeneratorSequence(r10, r11);
    }

    @SinceKotlin(version = "1.3")
    public static final <T> Sequence<T> ifEmpty(Sequence<? extends T> r10, Function0<? extends Sequence<? extends T>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "defaultValue");
        return SequencesKt.sequence(new C04401(r10, r11, null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @InlineOnly
    private static final <T> Sequence<T> orEmpty(Sequence<? extends T> r10) {
        if (r10 == 0) goto L4;
        return r10;
    L4:
        return SequencesKt.emptySequence();
    }

    public static <T> Sequence<T> sequenceOf(T... r10) {
        Intrinsics.checkNotNullParameter(r10, "elements");
        if (r10.length != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L9;
        return SequencesKt.emptySequence();
    L9:
        return ArraysKt.asSequence(r10);
    L5:
        r11 = false;
        goto L6
    }

    @SinceKotlin(version = "1.4")
    public static final <T> Sequence<T> shuffled(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return shuffled(r10, Random.Default);
    }

    @SinceKotlin(version = "1.4")
    public static final <T> Sequence<T> shuffled(Sequence<? extends T> r10, Random r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "random");
        return SequencesKt.sequence(new C04411(r10, r11, null));
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Sequence<? extends Pair<? extends T, ? extends R>> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        Iterator<? extends Pair<? extends T, ? extends R>> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L7;
        Pair<? extends T, ? extends R> r14 = r13.next();
        r11.add(r14.getFirst());
        r12.add(r14.getSecond());
        goto L4
    L7:
        return TuplesKt.to(r11, r12);
    }
}
