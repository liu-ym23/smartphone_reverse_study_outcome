package kotlin.sequences;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.ExperimentalStdlibApi;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.OverloadResolutionByLambdaReturnType;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.Grouping;
import kotlin.collections.IndexedValue;
import kotlin.collections.SetsKt;
import kotlin.collections.SlidingWindowKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\n_Sequences.kt\nKotlin\n*S Kotlin\n*F\n+ 1 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,3112:1\n179#1,2:3113\n316#1,7:3115\n1324#1,3:3123\n739#1,4:3126\n704#1,4:3130\n722#1,4:3134\n775#1,4:3138\n1017#1,3:3142\n1020#1,3:3152\n1037#1,3:3155\n1040#1,3:3165\n1324#1,3:3182\n1313#1,2:3185\n1#2:3122\n372#3,7:3145\n372#3,7:3158\n372#3,7:3168\n372#3,7:3175\n*S KotlinDebug\n*F\n+ 1 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n87#1:3113,2\n99#1:3115,7\n458#1:3123,3\n658#1:3126,4\n674#1:3130,4\n689#1:3134,4\n760#1:3138,4\n988#1:3142,3\n988#1:3152,3\n1003#1:3155,3\n1003#1:3165,3\n1106#1:3182,3\n1144#1:3185,2\n988#1:3145,7\n1003#1:3158,7\n1019#1:3168,7\n1039#1:3175,7\n*E\n"})
class SequencesKt___SequencesKt extends SequencesKt___SequencesJvmKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlin.sequences.SequencesKt___SequencesKt$flatMap$1, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C04461<R> extends FunctionReferenceImpl implements Function1<Iterable<? extends R>, Iterator<? extends R>> {
        public static final C04461 INSTANCE = null;

        static {
            INSTANCE = new C04461();
        }

        C04461() {
            super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object r10) {
            return invoke((Iterable) r10);
        }

        public final Iterator<R> invoke(Iterable<? extends R> r10) {
            Intrinsics.checkNotNullParameter(r10, "p0");
            return r10.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlin.sequences.SequencesKt___SequencesKt$flatMap$2, reason: invalid class name and case insensitive filesystem */
    /* synthetic */ class C04472<R> extends FunctionReferenceImpl implements Function1<Sequence<? extends R>, Iterator<? extends R>> {
        public static final C04472 INSTANCE = null;

        static {
            INSTANCE = new C04472();
        }

        C04472() {
            super(1, Sequence.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object r10) {
            return invoke((Sequence) r10);
        }

        public final Iterator<R> invoke(Sequence<? extends R> r10) {
            Intrinsics.checkNotNullParameter(r10, "p0");
            return r10.iterator();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlin.sequences.SequencesKt___SequencesKt$runningFold$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFold$1", f = "_Sequences.kt", i = {0, 1, 1}, l = {2308, 2312}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator"}, s = {"L$0", "L$0", "L$1"})
    static final class C04541<R> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ R $initial;
        final /* synthetic */ Function2<R, T, R> $operation;
        final /* synthetic */ Sequence<T> $this_runningFold;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04541(R r10, Sequence<? extends T> r11, Function2<? super R, ? super T, ? extends R> r12, Continuation<? super C04541> r13) {
            this.$initial = r10;
            this.$this_runningFold = r11;
            this.$operation = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            C04541 r12 = new C04541(this.$initial, this.$this_runningFold, this.$operation, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r10, Continuation<? super Unit> r11) {
            return invoke((SequenceScope) r10, r11);
        }

        public final Object invoke(SequenceScope<? super R> r10, Continuation<? super Unit> r11) {
            return ((C04541) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0068 -> B:7:0x001b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L11;
            if (r12 == 1) goto L10;
            if (r12 != 2) goto L9;
            Iterator r13 = (Iterator) this.L$2;
            Object r14 = this.L$1;
            SequenceScope r15 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r10);
        L7:
            Object r16 = r14;
        L16:
            if (r13.hasNext() == false) goto L21;
            Object r17 = r13.next();
            r14 = this.$operation.invoke((R) r16, (T) r17);
            this.L$0 = r15;
            this.L$1 = r14;
            this.L$2 = r13;
            this.label = 2;
            if (r15.yield(r14, this) != r11) goto L7;
            return r11;
        L21:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            SequenceScope r18 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r10);
        L14:
            r16 = this.$initial;
            r15 = r18;
            r13 = this.$this_runningFold.iterator();
            goto L16
        L11:
            ResultKt.throwOnFailure(r10);
            r18 = (SequenceScope) this.L$0;
            R r19 = this.$initial;
            this.L$0 = r18;
            this.label = 1;
            if (r18.yield(r19, this) != r11) goto L14;
            return r11;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningFoldIndexed$1", f = "_Sequences.kt", i = {0, 1, 1, 1}, l = {2336, 2341}, m = "invokeSuspend", n = {"$this$sequence", "$this$sequence", "accumulator", "index"}, s = {"L$0", "L$0", "L$1", "I$0"})
    static final class C04551<R> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ R $initial;
        final /* synthetic */ Function3<Integer, R, T, R> $operation;
        final /* synthetic */ Sequence<T> $this_runningFoldIndexed;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04551(R r10, Sequence<? extends T> r11, Function3<? super Integer, ? super R, ? super T, ? extends R> r12, Continuation<? super C04551> r13) {
            this.$initial = r10;
            this.$this_runningFoldIndexed = r11;
            this.$operation = r12;
            super(2, r13);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            C04551 r12 = new C04551(this.$initial, this.$this_runningFoldIndexed, this.$operation, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r10, Continuation<? super Unit> r11) {
            return invoke((SequenceScope) r10, r11);
        }

        public final Object invoke(SequenceScope<? super R> r10, Continuation<? super Unit> r11) {
            return ((C04551) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L10;
            if (r12 == 1) goto L9;
            if (r12 != 2) goto L8;
            int r13 = this.I$0;
            Iterator r14 = (Iterator) this.L$2;
            Object r15 = this.L$1;
            SequenceScope r16 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r10);
            int r17 = r13;
            Object r18 = r15;
        L15:
            if (r14.hasNext() == false) goto L24;
            Object r19 = r14.next();
            Function3<Integer, R, T, R> r20 = this.$operation;
            int r21 = r17 + 1;
            if (r17 >= 0) goto L19;
            CollectionsKt.throwIndexOverflow();
        L19:
            R r22 = r20.invoke(Boxing.boxInt(r17), (R) r18, (T) r19);
            this.L$0 = r16;
            this.L$1 = r22;
            this.L$2 = r14;
            this.I$0 = r21;
            this.label = 2;
            if (r16.yield(r22, this) == r11) goto L21;
            r18 = r22;
            r17 = r21;
            goto L15
        L21:
            return r11;
        L24:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            SequenceScope r23 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r10);
        L13:
            r17 = 0;
            R r24 = this.$initial;
            r16 = r23;
            r18 = r24;
            r14 = this.$this_runningFoldIndexed.iterator();
            goto L15
        L10:
            ResultKt.throwOnFailure(r10);
            r23 = (SequenceScope) this.L$0;
            R r25 = this.$initial;
            this.L$0 = r23;
            this.label = 1;
            if (r23.yield(r25, this) != r11) goto L13;
            return r11;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* JADX INFO: renamed from: kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduce$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1}, l = {2366, 2369}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class C04561<S> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super S>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function2<S, T, S> $operation;
        final /* synthetic */ Sequence<T> $this_runningReduce;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04561(Sequence<? extends T> r10, Function2<? super S, ? super T, ? extends S> r11, Continuation<? super C04561> r12) {
            this.$this_runningReduce = r10;
            this.$operation = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            C04561 r12 = new C04561(this.$this_runningReduce, this.$operation, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r10, Continuation<? super Unit> r11) {
            return invoke((SequenceScope) r10, r11);
        }

        public final Object invoke(SequenceScope<? super S> r10, Continuation<? super Unit> r11) {
            return ((C04561) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L10;
            if (r12 == 1) goto L9;
            if (r12 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            Object r13 = this.L$2;
            Iterator r14 = (Iterator) this.L$1;
            SequenceScope r15 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r10);
        L17:
            if (r14.hasNext() == false) goto L22;
            r13 = this.$operation.invoke((S) r13, (T) r14.next());
            this.L$0 = r15;
            this.L$1 = r14;
            this.L$2 = r13;
            this.label = 2;
            if (r15.yield(r13, this) != r11) goto L17;
            return r11;
        L22:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r10);
            r15 = (SequenceScope) this.L$0;
            Iterator r16 = this.$this_runningReduce.iterator();
            if (r16.hasNext() == false) goto L22;
            r13 = r16.next();
            this.L$0 = r15;
            this.L$1 = r16;
            this.L$2 = r13;
            this.label = 1;
            if (r15.yield(r13, this) != r11) goto L15;
            return r11;
        L15:
            r14 = r16;
            goto L17
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* JADX INFO: renamed from: kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$runningReduceIndexed$1", f = "_Sequences.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {2395, 2399}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "accumulator", "$this$sequence", "iterator", "accumulator", "index"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "I$0"})
    static final class C04571<S> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super S>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<Integer, S, T, S> $operation;
        final /* synthetic */ Sequence<T> $this_runningReduceIndexed;
        int I$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04571(Sequence<? extends T> r10, Function3<? super Integer, ? super S, ? super T, ? extends S> r11, Continuation<? super C04571> r12) {
            this.$this_runningReduceIndexed = r10;
            this.$operation = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            C04571 r12 = new C04571(this.$this_runningReduceIndexed, this.$operation, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r10, Continuation<? super Unit> r11) {
            return invoke((SequenceScope) r10, r11);
        }

        public final Object invoke(SequenceScope<? super S> r10, Continuation<? super Unit> r11) {
            return ((C04571) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            int r13 = 1;
            if (r12 == 0) goto L10;
            if (r12 == 1) goto L9;
            if (r12 != 2) goto L8;
            int r14 = this.I$0;
            Object r15 = this.L$2;
            Iterator r16 = (Iterator) this.L$1;
            SequenceScope r17 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r10);
            r13 = r14;
            Object r18 = r15;
        L16:
            if (r16.hasNext() == false) goto L25;
            Function3<Integer, S, T, S> r19 = this.$operation;
            int r20 = r13 + 1;
            if (r13 >= 0) goto L20;
            CollectionsKt.throwIndexOverflow();
        L20:
            S r21 = r19.invoke(Boxing.boxInt(r13), (S) r18, (T) r16.next());
            this.L$0 = r17;
            this.L$1 = r16;
            this.L$2 = r21;
            this.I$0 = r20;
            this.label = 2;
            if (r17.yield(r21, this) == r11) goto L22;
            r18 = r21;
            r13 = r20;
            goto L16
        L22:
            return r11;
        L25:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            r18 = this.L$2;
            r16 = (Iterator) this.L$1;
            r17 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r10);
            goto L16
        L10:
            ResultKt.throwOnFailure(r10);
            r17 = (SequenceScope) this.L$0;
            r16 = this.$this_runningReduceIndexed.iterator();
            if (r16.hasNext() == false) goto L25;
            r18 = r16.next();
            this.L$0 = r17;
            this.L$1 = r16;
            this.L$2 = r18;
            this.label = 1;
            if (r17.yield(r18, this) != r11) goto L16;
            return r11;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: renamed from: kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2, reason: invalid class name and case insensitive filesystem */
    @DebugMetadata(c = "kotlin.sequences.SequencesKt___SequencesKt$zipWithNext$2", f = "_Sequences.kt", i = {0, 0, 0}, l = {2873}, m = "invokeSuspend", n = {"$this$result", "iterator", "next"}, s = {"L$0", "L$1", "L$2"})
    static final class C04622<R> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Sequence<T> $this_zipWithNext;
        final /* synthetic */ Function2<T, T, R> $transform;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        C04622(Sequence<? extends T> r10, Function2<? super T, ? super T, ? extends R> r11, Continuation<? super C04622> r12) {
            this.$this_zipWithNext = r10;
            this.$transform = r11;
            super(2, r12);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            C04622 r12 = new C04622(this.$this_zipWithNext, this.$transform, r11);
            r12.L$0 = r10;
            return r12;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object r10, Continuation<? super Unit> r11) {
            return invoke((SequenceScope) r10, r11);
        }

        public final Object invoke(SequenceScope<? super R> r10, Continuation<? super Unit> r11) {
            return ((C04622) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x005b -> B:6:0x0018). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r12 = this.label;
            if (r12 == 0) goto L9;
            if (r12 != 1) goto L8;
            Object r13 = this.L$2;
            Iterator r14 = (Iterator) this.L$1;
            SequenceScope r15 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(r10);
        L6:
            Object r16 = r13;
        L15:
            if (r14.hasNext() == false) goto L20;
            r13 = r14.next();
            R r17 = this.$transform.invoke((T) r16, (T) r13);
            this.L$0 = r15;
            this.L$1 = r14;
            this.L$2 = r13;
            this.label = 1;
            if (r15.yield(r17, this) != r11) goto L6;
            return r11;
        L20:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r10);
            SequenceScope r18 = (SequenceScope) this.L$0;
            Iterator r19 = this.$this_zipWithNext.iterator();
            if (r19.hasNext() == false) goto L12;
            r15 = r18;
            r16 = r19.next();
            r14 = r19;
            goto L15
        L12:
            return Unit.INSTANCE;
        }
    }

    public SequencesKt___SequencesKt() {
    }

    public static final <T> boolean all(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        if (r11.invoke(r12.next()).booleanValue() == true) goto L4;
        return false;
    L9:
        return true;
    }

    public static final <T> boolean any(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.iterator().hasNext();
    }

    public static final <T> boolean any(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        if (r11.invoke(r12.next()).booleanValue() == false) goto L4;
        return true;
    L9:
        return false;
    }

    public static <T> Iterable<T> asIterable(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new SequencesKt___SequencesKt$asIterable$$inlined$Iterable$1(r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InlineOnly
    private static final <T> Sequence<T> asSequence(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10;
    }

    public static final <T, K, V> Map<K, V> associate(Sequence<? extends T> r10, Function1<? super T, ? extends Pair<? extends K, ? extends V>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Pair<? extends K, ? extends V> r14 = r11.invoke(r13.next());
        r12.put(r14.getFirst(), r14.getSecond());
        goto L4
    L6:
        return r12;
    }

    public static final <T, K> Map<K, T> associateBy(Sequence<? extends T> r10, Function1<? super T, ? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        T r14 = r13.next();
        r12.put(r11.invoke(r14), r14);
        goto L4
    L6:
        return r12;
    }

    public static final <T, K, V> Map<K, V> associateBy(Sequence<? extends T> r10, Function1<? super T, ? extends K> r11, Function1<? super T, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        Intrinsics.checkNotNullParameter(r12, "valueTransform");
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator<? extends T> r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        T r15 = r14.next();
        r13.put(r11.invoke(r15), r12.invoke(r15));
        goto L4
    L6:
        return r13;
    }

    public static final <T, K, M extends Map<? super K, ? super T>> M associateByTo(Sequence<? extends T> r10, M r11, Function1<? super T, ? extends K> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        T r14 = r13.next();
        r11.put(r12.invoke(r14), r14);
        goto L4
    L6:
        return r11;
    }

    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateByTo(Sequence<? extends T> r10, M r11, Function1<? super T, ? extends K> r12, Function1<? super T, ? extends V> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        Intrinsics.checkNotNullParameter(r13, "valueTransform");
        Iterator<? extends T> r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L6;
        T r15 = r14.next();
        r11.put(r12.invoke(r15), r13.invoke(r15));
        goto L4
    L6:
        return r11;
    }

    public static final <T, K, V, M extends Map<? super K, ? super V>> M associateTo(Sequence<? extends T> r10, M r11, Function1<? super T, ? extends Pair<? extends K, ? extends V>> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        Pair<? extends K, ? extends V> r14 = r12.invoke(r13.next());
        r11.put(r14.getFirst(), r14.getSecond());
        goto L4
    L6:
        return r11;
    }

    @SinceKotlin(version = "1.3")
    public static final <K, V> Map<K, V> associateWith(Sequence<? extends K> r10, Function1<? super K, ? extends V> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "valueSelector");
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<? extends K> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        K r14 = r13.next();
        r12.put(r14, r11.invoke(r14));
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.3")
    public static final <K, V, M extends Map<? super K, ? super V>> M associateWithTo(Sequence<? extends K> r10, M r11, Function1<? super K, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "valueSelector");
        Iterator<? extends K> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        K r14 = r13.next();
        r11.put(r14, r12.invoke(r14));
        goto L4
    L6:
        return r11;
    }

    @JvmName(name = "averageOfByte")
    public static final double averageOfByte(Sequence<Byte> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Byte> r11 = r10.iterator();
        double r12 = 0.0d;
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        r12 = r12 + ((double) r11.next().byteValue());
        r13 = r13 + 1;
        if (r13 >= 0) goto L4;
        CollectionsKt.throwCountOverflow();
        goto L4
    L8:
        if (r13 != 0) goto L11;
        return Double.NaN;
    L11:
        return r12 / ((double) r13);
    }

    @JvmName(name = "averageOfDouble")
    public static final double averageOfDouble(Sequence<Double> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Double> r11 = r10.iterator();
        double r12 = 0.0d;
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        r12 = r12 + r11.next().doubleValue();
        r13 = r13 + 1;
        if (r13 >= 0) goto L4;
        CollectionsKt.throwCountOverflow();
        goto L4
    L8:
        if (r13 != 0) goto L11;
        return Double.NaN;
    L11:
        return r12 / ((double) r13);
    }

    @JvmName(name = "averageOfFloat")
    public static final double averageOfFloat(Sequence<Float> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Float> r11 = r10.iterator();
        double r12 = 0.0d;
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        r12 = r12 + ((double) r11.next().floatValue());
        r13 = r13 + 1;
        if (r13 >= 0) goto L4;
        CollectionsKt.throwCountOverflow();
        goto L4
    L8:
        if (r13 != 0) goto L11;
        return Double.NaN;
    L11:
        return r12 / ((double) r13);
    }

    @JvmName(name = "averageOfInt")
    public static final double averageOfInt(Sequence<Integer> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Integer> r11 = r10.iterator();
        double r12 = 0.0d;
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        r12 = r12 + ((double) r11.next().intValue());
        r13 = r13 + 1;
        if (r13 >= 0) goto L4;
        CollectionsKt.throwCountOverflow();
        goto L4
    L8:
        if (r13 != 0) goto L11;
        return Double.NaN;
    L11:
        return r12 / ((double) r13);
    }

    @JvmName(name = "averageOfLong")
    public static final double averageOfLong(Sequence<Long> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Long> r11 = r10.iterator();
        double r12 = 0.0d;
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        r12 = r12 + r11.next().longValue();
        r13 = r13 + 1;
        if (r13 >= 0) goto L4;
        CollectionsKt.throwCountOverflow();
        goto L4
    L8:
        if (r13 != 0) goto L11;
        return Double.NaN;
    L11:
        return r12 / ((double) r13);
    }

    @JvmName(name = "averageOfShort")
    public static final double averageOfShort(Sequence<Short> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Short> r11 = r10.iterator();
        double r12 = 0.0d;
        int r13 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        r12 = r12 + ((double) r11.next().shortValue());
        r13 = r13 + 1;
        if (r13 >= 0) goto L4;
        CollectionsKt.throwCountOverflow();
        goto L4
    L8:
        if (r13 != 0) goto L11;
        return Double.NaN;
    L11:
        return r12 / ((double) r13);
    }

    @SinceKotlin(version = "1.2")
    public static final <T> Sequence<List<T>> chunked(Sequence<? extends T> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return windowed(r10, r11, r11, true);
    }

    @SinceKotlin(version = "1.2")
    public static final <T, R> Sequence<R> chunked(Sequence<? extends T> r10, int r11, Function1<? super List<? extends T>, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "transform");
        return windowed(r10, r11, r11, true, r12);
    }

    public static final <T> boolean contains(Sequence<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (indexOf(r10, r11) < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static <T> int count(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r11 = r10.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L8;
        r11.next();
        r12 = r12 + 1;
        if (r12 >= 0) goto L4;
        CollectionsKt.throwCountOverflow();
        goto L4
    L8:
        return r12;
    }

    public static final <T> int count(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L10;
        if (r11.invoke(r12.next()).booleanValue() == false) goto L4;
        r13 = r13 + 1;
        if (r13 >= 0) goto L4;
        CollectionsKt.throwCountOverflow();
        goto L4
    L10:
        return r13;
    }

    public static final <T> Sequence<T> distinct(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return distinctBy(r10, AnonymousClass1.INSTANCE);
    }

    public static final <T, K> Sequence<T> distinctBy(Sequence<? extends T> r10, Function1<? super T, ? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        return new DistinctSequence(r10, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> Sequence<T> drop(Sequence<? extends T> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L15;
        if (r11 != 0) goto L10;
        return r10;
    L10:
        if ((r10 instanceof DropTakeSequence) == false) goto L13;
        return ((DropTakeSequence) r10).drop(r11);
    L13:
        return new DropSequence(r10, r11);
    L15:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    public static final <T> Sequence<T> dropWhile(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        return new DropWhileSequence(r10, r11);
    }

    public static final <T> T elementAt(Sequence<? extends T> r10, final int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (T) elementAtOrElse(r10, r11, new C04421(r11));
    }

    public static final <T> T elementAtOrElse(Sequence<? extends T> r10, int r11, Function1<? super Integer, ? extends T> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "defaultValue");
        if (r11 < 0) goto L5;
        Iterator<? extends T> r13 = r10.iterator();
        int r14 = 0;
    L8:
        if (r13.hasNext() == false) goto L5;
        T r15 = r13.next();
        int r16 = r14 + 1;
        if (r11 == r14) goto L11;
        r14 = r16;
        goto L8
    L11:
        return r15;
    L5:
        return r12.invoke(Integer.valueOf(r11));
    }

    public static final <T> T elementAtOrNull(Sequence<? extends T> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 >= 0) goto L5;
        return null;
    L5:
        Iterator<? extends T> r12 = r10.iterator();
        int r13 = 0;
    L7:
        if (r12.hasNext() == false) goto L12;
        T r14 = r12.next();
        int r15 = r13 + 1;
        if (r11 == r13) goto L10;
        r13 = r15;
        goto L7
    L10:
        return r14;
    L12:
        return null;
    }

    public static <T> Sequence<T> filter(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        return new FilteringSequence(r10, true, r11);
    }

    public static final <T> Sequence<T> filterIndexed(Sequence<? extends T> r10, final Function2<? super Integer, ? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        return new TransformingSequence(new FilteringSequence(new IndexingSequence(r10), true, new C04431(r11)), AnonymousClass2.INSTANCE);
    }

    public static final <T, C extends Collection<? super T>> C filterIndexedTo(Sequence<? extends T> r10, C r11, Function2<? super Integer, ? super T, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        Iterator<? extends T> r13 = r10.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L12;
        T r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (r12.invoke(Integer.valueOf(r14), r15).booleanValue() == false) goto L11;
        r11.add(r15);
    L11:
        r14 = r16;
        goto L4
    L12:
        return r11;
    }

    public static final /* synthetic */ <R> Sequence<R> filterIsInstance(Sequence<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.needClassReification();
        Sequence<R> r11 = SequencesKt.filter(r10, C04441.INSTANCE);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesKt.filterIsInstance>");
        return r11;
    }

    public static final /* synthetic */ <R, C extends Collection<? super R>> C filterIsInstanceTo(Sequence<?> r10, C r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Iterator<?> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        Object r13 = r12.next();
        Intrinsics.reifiedOperationMarker(3, "R");
        if ((r13 instanceof Object) == false) goto L4;
        r11.add(r13);
        goto L4
    L8:
        return r11;
    }

    public static <T> Sequence<T> filterNot(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        return new FilteringSequence(r10, false, r11);
    }

    public static <T> Sequence<T> filterNotNull(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Sequence<T> r11 = SequencesKt.filterNot(r10, C04451.INSTANCE);
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return r11;
    }

    public static final <C extends Collection<? super T>, T> C filterNotNullTo(Sequence<? extends T> r10, C r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        T r13 = r12.next();
        if (r13 == null) goto L4;
        r11.add(r13);
        goto L4
    L8:
        return r11;
    }

    public static final <T, C extends Collection<? super T>> C filterNotTo(Sequence<? extends T> r10, C r11, Function1<? super T, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        T r14 = r13.next();
        if (r12.invoke(r14).booleanValue() == true) goto L4;
        r11.add(r14);
        goto L4
    L8:
        return r11;
    }

    public static final <T, C extends Collection<? super T>> C filterTo(Sequence<? extends T> r10, C r11, Function1<? super T, Boolean> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "predicate");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        T r14 = r13.next();
        if (r12.invoke(r14).booleanValue() == false) goto L4;
        r11.add(r14);
        goto L4
    L8:
        return r11;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Object] */
    @InlineOnly
    private static final <T> T find(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        T r13 = r12.next();
        if (r11.invoke(r13).booleanValue() == false) goto L4;
        return r13;
    L8:
        return null;
    }

    @InlineOnly
    private static final <T> T findLast(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
        T r13 = null;
    L4:
        if (r12.hasNext() == false) goto L8;
        T r14 = r12.next();
        if (r11.invoke(r14).booleanValue() == false) goto L4;
        r13 = r14;
        goto L4
    L8:
        return r13;
    }

    public static <T> T first(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L7;
        return r11.next();
    L7:
        throw new NoSuchElementException("Sequence is empty.");
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final <T> T first(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        T r13 = r12.next();
        if (r11.invoke(r13).booleanValue() == false) goto L4;
        return r13;
    L9:
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <T, R> R firstNotNullOf(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        R r13 = r11.invoke(r12.next());
        if (r13 == null) goto L4;
    L9:
        if (r13 == null) goto L12;
        return r13;
    L12:
        throw new NoSuchElementException("No element of the sequence was transformed to a non-null value.");
    L8:
        r13 = null;
        goto L9
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    private static final <T, R> R firstNotNullOfOrNull(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        R r13 = r11.invoke(r12.next());
        if (r13 == null) goto L4;
        return r13;
    L8:
        return null;
    }

    public static <T> T firstOrNull(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == true) goto L7;
        return null;
    L7:
        return r11.next();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    public static final <T> T firstOrNull(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L8;
        T r13 = r12.next();
        if (r11.invoke(r13).booleanValue() == false) goto L4;
        return r13;
    L8:
        return null;
    }

    public static <T, R> Sequence<R> flatMap(Sequence<? extends T> r10, Function1<? super T, ? extends Sequence<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        return new FlatteningSequence(r10, r11, C04472.INSTANCE);
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "flatMapIndexedIterable")
    public static final <T, R> Sequence<R> flatMapIndexedIterable(Sequence<? extends T> r10, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        return SequencesKt__SequencesKt.flatMapIndexed(r10, r11, SequencesKt___SequencesKt$flatMapIndexed$1.INSTANCE);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "flatMapIndexedIterableTo")
    @OverloadResolutionByLambdaReturnType
    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedIterableTo(Sequence<? extends T> r10, C r11, Function2<? super Integer, ? super T, ? extends Iterable<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<? extends T> r13 = r10.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L9;
        T r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        CollectionsKt.addAll(r11, r12.invoke(Integer.valueOf(r14), r15));
        r14 = r16;
        goto L4
    L9:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "flatMapIndexedSequence")
    public static final <T, R> Sequence<R> flatMapIndexedSequence(Sequence<? extends T> r10, Function2<? super Integer, ? super T, ? extends Sequence<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        return SequencesKt__SequencesKt.flatMapIndexed(r10, r11, SequencesKt___SequencesKt$flatMapIndexed$2.INSTANCE);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "flatMapIndexedSequenceTo")
    @OverloadResolutionByLambdaReturnType
    private static final <T, R, C extends Collection<? super R>> C flatMapIndexedSequenceTo(Sequence<? extends T> r10, C r11, Function2<? super Integer, ? super T, ? extends Sequence<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<? extends T> r13 = r10.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L9;
        T r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        CollectionsKt.addAll(r11, r12.invoke(Integer.valueOf(r14), r15));
        r14 = r16;
        goto L4
    L9:
        return r11;
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "flatMapIterable")
    public static final <T, R> Sequence<R> flatMapIterable(Sequence<? extends T> r10, Function1<? super T, ? extends Iterable<? extends R>> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        return new FlatteningSequence(r10, r11, C04461.INSTANCE);
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @JvmName(name = "flatMapIterableTo")
    public static final <T, R, C extends Collection<? super R>> C flatMapIterableTo(Sequence<? extends T> r10, C r11, Function1<? super T, ? extends Iterable<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        CollectionsKt.addAll(r11, r12.invoke(r13.next()));
        goto L4
    L6:
        return r11;
    }

    public static final <T, R, C extends Collection<? super R>> C flatMapTo(Sequence<? extends T> r10, C r11, Function1<? super T, ? extends Sequence<? extends R>> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        CollectionsKt.addAll(r11, r12.invoke(r13.next()));
        goto L4
    L6:
        return r11;
    }

    public static final <T, R> R fold(Sequence<? extends T> r10, R r11, Function2<? super R, ? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        R r14 = r11;
        r11 = r12.invoke(r14, r13.next());
        goto L4
    L6:
        return r11;
    }

    public static final <T, R> R foldIndexed(Sequence<? extends T> r10, R r11, Function3<? super Integer, ? super R, ? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        Iterator<? extends T> r13 = r10.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L9;
        T r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r11 = r12.invoke(Integer.valueOf(r14), r11, r15);
        r14 = r16;
        goto L4
    L9:
        return r11;
    }

    public static final <T> void forEach(Sequence<? extends T> r10, Function1<? super T, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.invoke(r12.next());
        goto L4
    }

    public static final <T> void forEachIndexed(Sequence<? extends T> r10, Function2<? super Integer, ? super T, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        Iterator<? extends T> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L9;
        T r14 = r12.next();
        int r15 = r13 + 1;
        if (r13 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r11.invoke(Integer.valueOf(r13), r14);
        r13 = r15;
        goto L4
    }

    public static final <T, K> Map<K, List<T>> groupBy(Sequence<? extends T> r10, Function1<? super T, ? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        T r14 = r13.next();
        K r15 = r11.invoke(r14);
        Object r16 = r12.get(r15);
        if (r16 != null) goto L8;
        r16 = new ArrayList();
        r12.put(r15, r16);
    L8:
        ((List) r16).add(r14);
        goto L4
    L9:
        return r12;
    }

    public static final <T, K, V> Map<K, List<V>> groupBy(Sequence<? extends T> r10, Function1<? super T, ? extends K> r11, Function1<? super T, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        Intrinsics.checkNotNullParameter(r12, "valueTransform");
        LinkedHashMap r13 = new LinkedHashMap();
        Iterator<? extends T> r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L9;
        T r15 = r14.next();
        K r16 = r11.invoke(r15);
        List<V> r17 = r13.get(r16);
        if (r17 != null) goto L8;
        r17 = new ArrayList();
        r13.put(r16, r17);
    L8:
        r17.add(r12.invoke(r15));
        goto L4
    L9:
        return r13;
    }

    public static final <T, K, M extends Map<? super K, List<T>>> M groupByTo(Sequence<? extends T> r10, M r11, Function1<? super T, ? extends K> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        T r14 = r13.next();
        K r15 = r12.invoke(r14);
        Object r16 = r11.get(r15);
        if (r16 != null) goto L8;
        r16 = new ArrayList();
        r11.put(r15, r16);
    L8:
        ((List) r16).add(r14);
        goto L4
    L9:
        return r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T, K, V, M extends Map<? super K, List<V>>> M groupByTo(Sequence<? extends T> r10, M r11, Function1<? super T, ? extends K> r12, Function1<? super T, ? extends V> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "keySelector");
        Intrinsics.checkNotNullParameter(r13, "valueTransform");
        Iterator<? extends T> r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L9;
        T r15 = r14.next();
        K r16 = r12.invoke(r15);
        Object r17 = r11.get(r16);
        if (r17 != null) goto L8;
        r17 = new ArrayList();
        r11.put(r16, r17);
    L8:
        ((List) r17).add(r13.invoke(r15));
        goto L4
    L9:
        return r11;
    }

    @SinceKotlin(version = "1.1")
    public static final <T, K> Grouping<T, K> groupingBy(final Sequence<? extends T> r10, final Function1<? super T, ? extends K> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "keySelector");
        return new C04481(r10, r11);
    }

    public static final <T> int indexOf(Sequence<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L12;
        T r14 = r12.next();
        if (r13 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (Intrinsics.areEqual(r11, r14) == true) goto L10;
        r13 = r13 + 1;
        goto L4
    L10:
        return r13;
    L12:
        return -1;
    }

    public static final <T> int indexOfFirst(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L12;
        T r14 = r12.next();
        if (r13 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (r11.invoke(r14).booleanValue() == true) goto L10;
        r13 = r13 + 1;
        goto L4
    L10:
        return r13;
    L12:
        return -1;
    }

    public static final <T> int indexOfLast(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
        int r13 = -1;
        int r14 = 0;
    L4:
        if (r12.hasNext() == false) goto L12;
        T r15 = r12.next();
        if (r14 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (r11.invoke(r15).booleanValue() == false) goto L11;
        r13 = r14;
    L11:
        r14 = r14 + 1;
        goto L4
    L12:
        return r13;
    }

    public static final <T, A extends Appendable> A joinTo(Sequence<? extends T> r10, A r11, CharSequence r12, CharSequence r13, CharSequence r14, int r15, CharSequence r16, Function1<? super T, ? extends CharSequence> r17) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "buffer");
        Intrinsics.checkNotNullParameter(r12, "separator");
        Intrinsics.checkNotNullParameter(r13, "prefix");
        Intrinsics.checkNotNullParameter(r14, "postfix");
        Intrinsics.checkNotNullParameter(r16, "truncated");
        r11.append(r13);
        Iterator<? extends T> r18 = r10.iterator();
        int r19 = 0;
    L4:
        if (r18.hasNext() == false) goto L11;
        T r20 = r18.next();
        r19 = r19 + 1;
        if (r19 <= 1) goto L8;
        r11.append(r12);
    L8:
        if (r15 < 0) goto L10;
        if (r19 > r15) goto L11;
    L10:
        StringsKt.appendElement(r11, r20, r17);
    L11:
        if (r15 < 0) goto L14;
        if (r19 <= r15) goto L14;
        r11.append(r16);
    L14:
        r11.append(r14);
        return r11;
    }

    public static /* synthetic */ Appendable joinTo$default(Sequence r10, Appendable r11, CharSequence r12, CharSequence r13, CharSequence r14, int r15, CharSequence r16, Function1 r17, int r18, Object r19) {
        if ((r18 & 2) == 0) goto L5;
        CharSequence r20 = ", ";
    L6:
        CharSequence r21 = "";
        if ((r18 & 4) == 0) goto L9;
        CharSequence r22 = "";
    L11:
        if ((r18 & 8) != 0) goto L15;
        r21 = r14;
    L15:
        if ((r18 & 16) == 0) goto L17;
        int r23 = -1;
    L19:
        if ((r18 & 32) == 0) goto L21;
        CharSequence r24 = "...";
    L23:
        if ((r18 & 64) == 0) goto L25;
        Function1 r25 = null;
    L27:
        return joinTo(r10, r11, r20, r22, r21, r23, r24, r25);
    L25:
        r25 = r17;
        goto L27
    L21:
        r24 = r16;
        goto L23
    L17:
        r23 = r15;
        goto L19
    L9:
        r22 = r13;
        goto L11
    L5:
        r20 = r12;
        goto L6
    }

    public static final <T> String joinToString(Sequence<? extends T> r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, Function1<? super T, ? extends CharSequence> r16) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "separator");
        Intrinsics.checkNotNullParameter(r12, "prefix");
        Intrinsics.checkNotNullParameter(r13, "postfix");
        Intrinsics.checkNotNullParameter(r15, "truncated");
        String r17 = ((StringBuilder) joinTo(r10, new StringBuilder(), r11, r12, r13, r14, r15, r16)).toString();
        Intrinsics.checkNotNullExpressionValue(r17, "joinTo(StringBuilder(), …ed, transform).toString()");
        return r17;
    }

    public static /* synthetic */ String joinToString$default(Sequence r10, CharSequence r11, CharSequence r12, CharSequence r13, int r14, CharSequence r15, Function1 r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L5;
        r11 = ", ";
    L5:
        CharSequence r19 = "";
        if ((r17 & 2) == 0) goto L8;
        CharSequence r110 = "";
    L10:
        if ((r17 & 4) != 0) goto L14;
        r19 = r13;
    L14:
        if ((r17 & 8) == 0) goto L16;
        r14 = -1;
    L16:
        int r20 = r14;
        if ((r17 & 16) == 0) goto L19;
        r15 = "...";
    L19:
        CharSequence r21 = r15;
        if ((r17 & 32) == 0) goto L22;
        r16 = null;
    L22:
        CharSequence r22 = r11;
        CharSequence r23 = r110;
        CharSequence r24 = r19;
        return joinToString(r10, r22, r23, r24, r20, r21, r16);
    L8:
        r110 = r12;
        goto L10
    }

    public static <T> T last(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L9;
    L4:
        T r12 = r11.next();
        if (r11.hasNext() == true) goto L4;
        return r12;
    L9:
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static final <T> T last(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
        T r13 = null;
        boolean r14 = false;
    L4:
        if (r12.hasNext() == false) goto L8;
        T r15 = r12.next();
        if (r11.invoke(r15).booleanValue() == false) goto L4;
        r14 = true;
        r13 = r15;
        goto L4
    L8:
        if (r14 == false) goto L11;
        return r13;
    L11:
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public static final <T> int lastIndexOf(Sequence<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r12 = r10.iterator();
        int r13 = -1;
        int r14 = 0;
    L4:
        if (r12.hasNext() == false) goto L12;
        T r15 = r12.next();
        if (r14 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (Intrinsics.areEqual(r11, r15) == false) goto L11;
        r13 = r14;
    L11:
        r14 = r14 + 1;
        goto L4
    L12:
        return r13;
    }

    public static final <T> T lastOrNull(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == true) goto L6;
        return null;
    L6:
        T r12 = r11.next();
        if (r11.hasNext() == true) goto L6;
        return r12;
    }

    public static final <T> T lastOrNull(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
        T r13 = null;
    L4:
        if (r12.hasNext() == false) goto L8;
        T r14 = r12.next();
        if (r11.invoke(r14).booleanValue() == false) goto L4;
        r13 = r14;
        goto L4
    L8:
        return r13;
    }

    public static <T, R> Sequence<R> map(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        return new TransformingSequence(r10, r11);
    }

    public static final <T, R> Sequence<R> mapIndexed(Sequence<? extends T> r10, Function2<? super Integer, ? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        return new TransformingIndexedSequence(r10, r11);
    }

    public static final <T, R> Sequence<R> mapIndexedNotNull(Sequence<? extends T> r10, Function2<? super Integer, ? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        return SequencesKt.filterNotNull(new TransformingIndexedSequence(r10, r11));
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedNotNullTo(Sequence<? extends T> r10, C r11, Function2<? super Integer, ? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<? extends T> r13 = r10.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L12;
        T r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        R r17 = r12.invoke(Integer.valueOf(r14), r15);
        if (r17 == null) goto L11;
        r11.add(r17);
    L11:
        r14 = r16;
        goto L4
    L12:
        return r11;
    }

    public static final <T, R, C extends Collection<? super R>> C mapIndexedTo(Sequence<? extends T> r10, C r11, Function2<? super Integer, ? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<? extends T> r13 = r10.iterator();
        int r14 = 0;
    L4:
        if (r13.hasNext() == false) goto L9;
        T r15 = r13.next();
        int r16 = r14 + 1;
        if (r14 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        r11.add(r12.invoke(Integer.valueOf(r14), r15));
        r14 = r16;
        goto L4
    L9:
        return r11;
    }

    public static <T, R> Sequence<R> mapNotNull(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        return SequencesKt.filterNotNull(new TransformingSequence(r10, r11));
    }

    public static final <T, R, C extends Collection<? super R>> C mapNotNullTo(Sequence<? extends T> r10, C r11, Function1<? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        R r14 = r12.invoke(r13.next());
        if (r14 == null) goto L4;
        r11.add(r14);
        goto L4
    L8:
        return r11;
    }

    public static final <T, R, C extends Collection<? super R>> C mapTo(Sequence<? extends T> r10, C r11, Function1<? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Intrinsics.checkNotNullParameter(r12, "transform");
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r11.add(r12.invoke(r13.next()));
        goto L4
    L6:
        return r11;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = "1.4")
    public static final <T, R extends Comparable<? super R>> T maxByOrNull(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        T r13 = r12.next();
        if (r12.hasNext() == true) goto L9;
        return r13;
    L9:
        R r14 = r11.invoke(r13);
    L10:
        T r15 = r12.next();
        R r16 = r11.invoke(r15);
        r13 = r13;
        if (r14.compareTo(r16) >= 0) goto L14;
        r14 = r16;
        r13 = r15;
    L14:
        if (r12.hasNext() == true) goto L10;
        return (T) r13;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxByOrThrow")
    public static final <T, R extends Comparable<? super R>> T maxByOrThrow(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L15;
        T r13 = r12.next();
        if (r12.hasNext() == true) goto L7;
        return r13;
    L7:
        R r14 = r11.invoke(r13);
    L8:
        T r15 = r12.next();
        R r16 = r11.invoke(r15);
        r13 = r13;
        if (r14.compareTo(r16) >= 0) goto L12;
        r14 = r16;
        r13 = r15;
    L12:
        if (r12.hasNext() == true) goto L8;
        return (T) r13;
    L15:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> double maxOf(Sequence<? extends T> r10, Function1<? super T, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L10;
        double r13 = r11.invoke(r12.next()).doubleValue();
    L6:
        if (r12.hasNext() == false) goto L8;
        r13 = Math.max(r13, r11.invoke(r12.next()).doubleValue());
        goto L6
    L8:
        return r13;
    L10:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <T> float m1334maxOf(Sequence<? extends T> r10, Function1<? super T, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L10;
        float r13 = r11.invoke(r12.next()).floatValue();
    L6:
        if (r12.hasNext() == false) goto L8;
        r13 = Math.max(r13, r11.invoke(r12.next()).floatValue());
        goto L6
    L8:
        return r13;
    L10:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: maxOf, reason: collision with other method in class */
    private static final <T, R extends Comparable<? super R>> R m1335maxOf(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L12;
        R r13 = r11.invoke(r12.next());
    L6:
        if (r12.hasNext() == false) goto L10;
        R r14 = r11.invoke(r12.next());
        if (r13.compareTo(r14) >= 0) goto L6;
        r13 = r14;
        goto L6
    L10:
        return r13;
    L12:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R extends Comparable<? super R>> R maxOfOrNull(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        R r13 = r11.invoke(r12.next());
    L8:
        if (r12.hasNext() == false) goto L12;
        R r14 = r11.invoke(r12.next());
        if (r13.compareTo(r14) >= 0) goto L8;
        r13 = r14;
        goto L8
    L12:
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <T> Double m1336maxOfOrNull(Sequence<? extends T> r10, Function1<? super T, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        double r13 = r11.invoke(r12.next()).doubleValue();
    L8:
        if (r12.hasNext() == false) goto L11;
        r13 = Math.max(r13, r11.invoke(r12.next()).doubleValue());
        goto L8
    L11:
        return Double.valueOf(r13);
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: maxOfOrNull, reason: collision with other method in class */
    private static final <T> Float m1337maxOfOrNull(Sequence<? extends T> r10, Function1<? super T, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        float r13 = r11.invoke(r12.next()).floatValue();
    L8:
        if (r12.hasNext() == false) goto L11;
        r13 = Math.max(r13, r11.invoke(r12.next()).floatValue());
        goto L8
    L11:
        return Float.valueOf(r13);
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R maxOfWith(Sequence<? extends T> r10, Comparator<? super R> r11, Function1<? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        Iterator<? extends T> r13 = r10.iterator();
        if (r13.hasNext() == false) goto L12;
        R r14 = r12.invoke(r13.next());
    L6:
        if (r13.hasNext() == false) goto L10;
        R r15 = r12.invoke(r13.next());
        if (r11.compare(r14, r15) >= 0) goto L6;
        r14 = r15;
        goto L6
    L10:
        return r14;
    L12:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R maxOfWithOrNull(Sequence<? extends T> r10, Comparator<? super R> r11, Function1<? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        Iterator<? extends T> r13 = r10.iterator();
        if (r13.hasNext() == true) goto L6;
        return null;
    L6:
        R r14 = r12.invoke(r13.next());
    L8:
        if (r13.hasNext() == false) goto L12;
        R r15 = r12.invoke(r13.next());
        if (r11.compare(r14, r15) >= 0) goto L8;
        r14 = r15;
        goto L8
    L12:
        return r14;
    }

    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> T maxOrNull(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == true) goto L6;
        return null;
    L6:
        T r12 = r11.next();
    L8:
        if (r11.hasNext() == false) goto L12;
        T r13 = r11.next();
        if (r12.compareTo(r13) >= 0) goto L8;
        r12 = r13;
        goto L8
    L12:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    /* JADX INFO: renamed from: maxOrNull, reason: collision with other method in class */
    public static final Double m1338maxOrNull(Sequence<Double> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Double> r11 = r10.iterator();
        if (r11.hasNext() == true) goto L6;
        return null;
    L6:
        double r12 = r11.next().doubleValue();
    L8:
        if (r11.hasNext() == false) goto L11;
        r12 = Math.max(r12, r11.next().doubleValue());
        goto L8
    L11:
        return Double.valueOf(r12);
    }

    @SinceKotlin(version = "1.4")
    /* JADX INFO: renamed from: maxOrNull, reason: collision with other method in class */
    public static final Float m1339maxOrNull(Sequence<Float> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Float> r11 = r10.iterator();
        if (r11.hasNext() == true) goto L6;
        return null;
    L6:
        float r12 = r11.next().floatValue();
    L8:
        if (r11.hasNext() == false) goto L11;
        r12 = Math.max(r12, r11.next().floatValue());
        goto L8
    L11:
        return Float.valueOf(r12);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    public static final double maxOrThrow(Sequence<Double> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Double> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L10;
        double r12 = r11.next().doubleValue();
    L6:
        if (r11.hasNext() == false) goto L8;
        r12 = Math.max(r12, r11.next().doubleValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    /* JADX INFO: renamed from: maxOrThrow, reason: collision with other method in class */
    public static final float m1340maxOrThrow(Sequence<Float> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Float> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L10;
        float r12 = r11.next().floatValue();
    L6:
        if (r11.hasNext() == false) goto L8;
        r12 = Math.max(r12, r11.next().floatValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxOrThrow")
    /* JADX INFO: renamed from: maxOrThrow, reason: collision with other method in class */
    public static final <T extends Comparable<? super T>> T m1341maxOrThrow(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L12;
        T r12 = r11.next();
    L6:
        if (r11.hasNext() == false) goto L10;
        T r13 = r11.next();
        if (r12.compareTo(r13) >= 0) goto L6;
        r12 = r13;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    public static final <T> T maxWithOrNull(Sequence<? extends T> r10, Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        T r13 = r12.next();
    L8:
        if (r12.hasNext() == false) goto L12;
        T r14 = r12.next();
        if (r11.compare(r13, r14) >= 0) goto L8;
        r13 = r14;
        goto L8
    L12:
        return r13;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "maxWithOrThrow")
    public static final <T> T maxWithOrThrow(Sequence<? extends T> r10, Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L12;
        T r13 = r12.next();
    L6:
        if (r12.hasNext() == false) goto L10;
        T r14 = r12.next();
        if (r11.compare(r13, r14) >= 0) goto L6;
        r13 = r14;
        goto L6
    L10:
        return r13;
    L12:
        throw new NoSuchElementException();
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = "1.4")
    public static final <T, R extends Comparable<? super R>> T minByOrNull(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        T r13 = r12.next();
        if (r12.hasNext() == true) goto L9;
        return r13;
    L9:
        R r14 = r11.invoke(r13);
    L10:
        T r15 = r12.next();
        R r16 = r11.invoke(r15);
        r13 = r13;
        if (r14.compareTo(r16) <= 0) goto L14;
        r14 = r16;
        r13 = r15;
    L14:
        if (r12.hasNext() == true) goto L10;
        return (T) r13;
    }

    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [T] */
    @SinceKotlin(version = "1.7")
    @JvmName(name = "minByOrThrow")
    public static final <T, R extends Comparable<? super R>> T minByOrThrow(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L15;
        T r13 = r12.next();
        if (r12.hasNext() == true) goto L7;
        return r13;
    L7:
        R r14 = r11.invoke(r13);
    L8:
        T r15 = r12.next();
        R r16 = r11.invoke(r15);
        r13 = r13;
        if (r14.compareTo(r16) <= 0) goto L12;
        r14 = r16;
        r13 = r15;
    L12:
        if (r12.hasNext() == true) goto L8;
        return (T) r13;
    L15:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T> double minOf(Sequence<? extends T> r10, Function1<? super T, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L10;
        double r13 = r11.invoke(r12.next()).doubleValue();
    L6:
        if (r12.hasNext() == false) goto L8;
        r13 = Math.min(r13, r11.invoke(r12.next()).doubleValue());
        goto L6
    L8:
        return r13;
    L10:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <T> float m1342minOf(Sequence<? extends T> r10, Function1<? super T, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L10;
        float r13 = r11.invoke(r12.next()).floatValue();
    L6:
        if (r12.hasNext() == false) goto L8;
        r13 = Math.min(r13, r11.invoke(r12.next()).floatValue());
        goto L6
    L8:
        return r13;
    L10:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: minOf, reason: collision with other method in class */
    private static final <T, R extends Comparable<? super R>> R m1343minOf(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L12;
        R r13 = r11.invoke(r12.next());
    L6:
        if (r12.hasNext() == false) goto L10;
        R r14 = r11.invoke(r12.next());
        if (r13.compareTo(r14) <= 0) goto L6;
        r13 = r14;
        goto L6
    L10:
        return r13;
    L12:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R extends Comparable<? super R>> R minOfOrNull(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        R r13 = r11.invoke(r12.next());
    L8:
        if (r12.hasNext() == false) goto L12;
        R r14 = r11.invoke(r12.next());
        if (r13.compareTo(r14) <= 0) goto L8;
        r13 = r14;
        goto L8
    L12:
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <T> Double m1344minOfOrNull(Sequence<? extends T> r10, Function1<? super T, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        double r13 = r11.invoke(r12.next()).doubleValue();
    L8:
        if (r12.hasNext() == false) goto L11;
        r13 = Math.min(r13, r11.invoke(r12.next()).doubleValue());
        goto L8
    L11:
        return Double.valueOf(r13);
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    /* JADX INFO: renamed from: minOfOrNull, reason: collision with other method in class */
    private static final <T> Float m1345minOfOrNull(Sequence<? extends T> r10, Function1<? super T, Float> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        float r13 = r11.invoke(r12.next()).floatValue();
    L8:
        if (r12.hasNext() == false) goto L11;
        r13 = Math.min(r13, r11.invoke(r12.next()).floatValue());
        goto L8
    L11:
        return Float.valueOf(r13);
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R minOfWith(Sequence<? extends T> r10, Comparator<? super R> r11, Function1<? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        Iterator<? extends T> r13 = r10.iterator();
        if (r13.hasNext() == false) goto L12;
        R r14 = r12.invoke(r13.next());
    L6:
        if (r13.hasNext() == false) goto L10;
        R r15 = r12.invoke(r13.next());
        if (r11.compare(r14, r15) <= 0) goto L6;
        r14 = r15;
        goto L6
    L10:
        return r14;
    L12:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    @OverloadResolutionByLambdaReturnType
    @InlineOnly
    private static final <T, R> R minOfWithOrNull(Sequence<? extends T> r10, Comparator<? super R> r11, Function1<? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Intrinsics.checkNotNullParameter(r12, "selector");
        Iterator<? extends T> r13 = r10.iterator();
        if (r13.hasNext() == true) goto L6;
        return null;
    L6:
        R r14 = r12.invoke(r13.next());
    L8:
        if (r13.hasNext() == false) goto L12;
        R r15 = r12.invoke(r13.next());
        if (r11.compare(r14, r15) <= 0) goto L8;
        r14 = r15;
        goto L8
    L12:
        return r14;
    }

    @SinceKotlin(version = "1.4")
    public static final <T extends Comparable<? super T>> T minOrNull(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == true) goto L6;
        return null;
    L6:
        T r12 = r11.next();
    L8:
        if (r11.hasNext() == false) goto L12;
        T r13 = r11.next();
        if (r12.compareTo(r13) <= 0) goto L8;
        r12 = r13;
        goto L8
    L12:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    /* JADX INFO: renamed from: minOrNull, reason: collision with other method in class */
    public static final Double m1346minOrNull(Sequence<Double> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Double> r11 = r10.iterator();
        if (r11.hasNext() == true) goto L6;
        return null;
    L6:
        double r12 = r11.next().doubleValue();
    L8:
        if (r11.hasNext() == false) goto L11;
        r12 = Math.min(r12, r11.next().doubleValue());
        goto L8
    L11:
        return Double.valueOf(r12);
    }

    @SinceKotlin(version = "1.4")
    /* JADX INFO: renamed from: minOrNull, reason: collision with other method in class */
    public static final Float m1347minOrNull(Sequence<Float> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Float> r11 = r10.iterator();
        if (r11.hasNext() == true) goto L6;
        return null;
    L6:
        float r12 = r11.next().floatValue();
    L8:
        if (r11.hasNext() == false) goto L11;
        r12 = Math.min(r12, r11.next().floatValue());
        goto L8
    L11:
        return Float.valueOf(r12);
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    public static final double minOrThrow(Sequence<Double> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Double> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L10;
        double r12 = r11.next().doubleValue();
    L6:
        if (r11.hasNext() == false) goto L8;
        r12 = Math.min(r12, r11.next().doubleValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    /* JADX INFO: renamed from: minOrThrow, reason: collision with other method in class */
    public static final float m1348minOrThrow(Sequence<Float> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Float> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L10;
        float r12 = r11.next().floatValue();
    L6:
        if (r11.hasNext() == false) goto L8;
        r12 = Math.min(r12, r11.next().floatValue());
        goto L6
    L8:
        return r12;
    L10:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minOrThrow")
    /* JADX INFO: renamed from: minOrThrow, reason: collision with other method in class */
    public static final <T extends Comparable<? super T>> T m1349minOrThrow(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L12;
        T r12 = r11.next();
    L6:
        if (r11.hasNext() == false) goto L10;
        T r13 = r11.next();
        if (r12.compareTo(r13) <= 0) goto L6;
        r12 = r13;
        goto L6
    L10:
        return r12;
    L12:
        throw new NoSuchElementException();
    }

    @SinceKotlin(version = "1.4")
    public static final <T> T minWithOrNull(Sequence<? extends T> r10, Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        T r13 = r12.next();
    L8:
        if (r12.hasNext() == false) goto L12;
        T r14 = r12.next();
        if (r11.compare(r13, r14) <= 0) goto L8;
        r13 = r14;
        goto L8
    L12:
        return r13;
    }

    @SinceKotlin(version = "1.7")
    @JvmName(name = "minWithOrThrow")
    public static final <T> T minWithOrThrow(Sequence<? extends T> r10, Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L12;
        T r13 = r12.next();
    L6:
        if (r12.hasNext() == false) goto L10;
        T r14 = r12.next();
        if (r11.compare(r13, r14) <= 0) goto L6;
        r13 = r14;
        goto L6
    L10:
        return r13;
    L12:
        throw new NoSuchElementException();
    }

    public static final <T> Sequence<T> minus(final Sequence<? extends T> r10, final Iterable<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        return new AnonymousClass3(r11, r10);
    }

    public static final <T> Sequence<T> minus(final Sequence<? extends T> r10, final T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new C04491(r10, r11);
    }

    public static final <T> Sequence<T> minus(final Sequence<? extends T> r10, final Sequence<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        return new AnonymousClass4(r11, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> Sequence<T> minus(final Sequence<? extends T> r10, final T[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        if (r11.length != 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L9;
        return r10;
    L9:
        return new C04502(r10, r11);
    L5:
        r12 = false;
        goto L6
    }

    @InlineOnly
    private static final <T> Sequence<T> minusElement(Sequence<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return minus(r10, r11);
    }

    public static final <T> boolean none(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return !r10.iterator().hasNext();
    }

    public static final <T> boolean none(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        if (r11.invoke(r12.next()).booleanValue() == false) goto L4;
        return false;
    L9:
        return true;
    }

    @SinceKotlin(version = "1.1")
    public static final <T> Sequence<T> onEach(Sequence<? extends T> r10, final Function1<? super T, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        return SequencesKt.map(r10, new C04511(r11));
    }

    @SinceKotlin(version = "1.4")
    public static final <T> Sequence<T> onEachIndexed(Sequence<? extends T> r10, final Function2<? super Integer, ? super T, Unit> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "action");
        return mapIndexed(r10, new C04521(r11));
    }

    public static final <T> Pair<List<T>, List<T>> partition(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        ArrayList r12 = new ArrayList();
        ArrayList r13 = new ArrayList();
        Iterator<? extends T> r14 = r10.iterator();
    L4:
        if (r14.hasNext() == false) goto L10;
        T r15 = r14.next();
        if (r11.invoke(r15).booleanValue() == true) goto L7;
        r13.add(r15);
        goto L4
    L7:
        r12.add(r15);
        goto L4
    L10:
        return new Pair(r12, r13);
    }

    public static <T> Sequence<T> plus(Sequence<? extends T> r10, Iterable<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        return SequencesKt__SequencesKt.flatten(SequencesKt.sequenceOf(new Sequence[]{r10, CollectionsKt.asSequence(r11)}));
    }

    public static <T> Sequence<T> plus(Sequence<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SequencesKt__SequencesKt.flatten(SequencesKt.sequenceOf(new Sequence[]{r10, SequencesKt.sequenceOf(new Object[]{r11})}));
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> r10, Sequence<? extends T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        return SequencesKt__SequencesKt.flatten(SequencesKt.sequenceOf(new Sequence[]{r10, r11}));
    }

    public static final <T> Sequence<T> plus(Sequence<? extends T> r10, T[] r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "elements");
        return SequencesKt.plus(r10, ArraysKt.asList(r11));
    }

    @InlineOnly
    private static final <T> Sequence<T> plusElement(Sequence<? extends T> r10, T r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SequencesKt.plus(r10, r11);
    }

    public static final <S, T extends S> S reduce(Sequence<? extends T> r10, Function2<? super S, ? super T, ? extends S> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L10;
        S r13 = r12.next();
    L6:
        if (r12.hasNext() == false) goto L8;
        S r14 = r13;
        r13 = r11.invoke(r14, r12.next());
        goto L6
    L8:
        return r13;
    L10:
        throw new UnsupportedOperationException("Empty sequence can't be reduced.");
    }

    public static final <S, T extends S> S reduceIndexed(Sequence<? extends T> r10, Function3<? super Integer, ? super S, ? super T, ? extends S> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == false) goto L13;
        S r13 = r12.next();
        int r14 = 1;
    L6:
        if (r12.hasNext() == false) goto L11;
        int r15 = r14 + 1;
        if (r14 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        S r16 = r13;
        r13 = r11.invoke(Integer.valueOf(r14), r16, r12.next());
        r14 = r15;
        goto L6
    L11:
        return r13;
    L13:
        throw new UnsupportedOperationException("Empty sequence can't be reduced.");
    }

    @SinceKotlin(version = "1.4")
    public static final <S, T extends S> S reduceIndexedOrNull(Sequence<? extends T> r10, Function3<? super Integer, ? super S, ? super T, ? extends S> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        S r13 = r12.next();
        int r14 = 1;
    L8:
        if (r12.hasNext() == false) goto L13;
        int r15 = r14 + 1;
        if (r14 >= 0) goto L12;
        CollectionsKt.throwIndexOverflow();
    L12:
        S r16 = r13;
        r13 = r11.invoke(Integer.valueOf(r14), r16, r12.next());
        r14 = r15;
        goto L8
    L13:
        return r13;
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <S, T extends S> S reduceOrNull(Sequence<? extends T> r10, Function2<? super S, ? super T, ? extends S> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        Iterator<? extends T> r12 = r10.iterator();
        if (r12.hasNext() == true) goto L6;
        return null;
    L6:
        S r13 = r12.next();
    L8:
        if (r12.hasNext() == false) goto L10;
        S r14 = r13;
        r13 = r11.invoke(r14, r12.next());
        goto L8
    L10:
        return r13;
    }

    public static final <T> Sequence<T> requireNoNulls(final Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SequencesKt.map(r10, new C04531(r10));
    }

    @SinceKotlin(version = "1.4")
    public static final <T, R> Sequence<R> runningFold(Sequence<? extends T> r10, R r11, Function2<? super R, ? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        return SequencesKt.sequence(new C04541(r11, r10, r12, null));
    }

    @SinceKotlin(version = "1.4")
    public static final <T, R> Sequence<R> runningFoldIndexed(Sequence<? extends T> r10, R r11, Function3<? super Integer, ? super R, ? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        return SequencesKt.sequence(new C04551(r11, r10, r12, null));
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <S, T extends S> Sequence<S> runningReduce(Sequence<? extends T> r10, Function2<? super S, ? super T, ? extends S> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        return SequencesKt.sequence(new C04561(r10, r11, null));
    }

    @SinceKotlin(version = "1.4")
    public static final <S, T extends S> Sequence<S> runningReduceIndexed(Sequence<? extends T> r10, Function3<? super Integer, ? super S, ? super T, ? extends S> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "operation");
        return SequencesKt.sequence(new C04571(r10, r11, null));
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T, R> Sequence<R> scan(Sequence<? extends T> r10, R r11, Function2<? super R, ? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        return runningFold(r10, r11, r12);
    }

    @SinceKotlin(version = "1.4")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    public static final <T, R> Sequence<R> scanIndexed(Sequence<? extends T> r10, R r11, Function3<? super Integer, ? super R, ? super T, ? extends R> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r12, "operation");
        return runningFoldIndexed(r10, r11, r12);
    }

    public static final <T> T single(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L10;
        T r12 = r11.next();
        if (r11.hasNext() == true) goto L8;
        return r12;
    L8:
        throw new IllegalArgumentException("Sequence has more than one element.");
    L10:
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static final <T> T single(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
        T r13 = null;
        boolean r14 = false;
    L4:
        if (r12.hasNext() == false) goto L11;
        T r15 = r12.next();
        if (r11.invoke(r15).booleanValue() == false) goto L4;
        if (r14 == true) goto L10;
        r14 = true;
        r13 = r15;
        goto L4
    L10:
        throw new IllegalArgumentException("Sequence contains more than one matching element.");
    L11:
        if (r14 == false) goto L14;
        return r13;
    L14:
        throw new NoSuchElementException("Sequence contains no element matching the predicate.");
    }

    public static final <T> T singleOrNull(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == true) goto L5;
        return null;
    L5:
        T r12 = r11.next();
        if (r11.hasNext() == false) goto L8;
        return null;
    L8:
        return r12;
    }

    public static final <T> T singleOrNull(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        Iterator<? extends T> r12 = r10.iterator();
        boolean r13 = false;
        T r14 = null;
    L4:
        if (r12.hasNext() == false) goto L10;
        T r15 = r12.next();
        if (r11.invoke(r15).booleanValue() == false) goto L4;
        if (r13 == true) goto L8;
        r13 = true;
        r14 = r15;
        goto L4
    L8:
        return null;
    L10:
        if (r13 == true) goto L12;
        return null;
    L12:
        return r14;
    }

    public static final <T extends Comparable<? super T>> Sequence<T> sorted(final Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (Sequence<T>) new C04581(r10);
    }

    public static final <T, R extends Comparable<? super R>> Sequence<T> sortedBy(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        return sortedWith(r10, new ComparisonsKt__ComparisonsKt.AnonymousClass2(r11));
    }

    public static final <T, R extends Comparable<? super R>> Sequence<T> sortedByDescending(Sequence<? extends T> r10, Function1<? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        return sortedWith(r10, new ComparisonsKt__ComparisonsKt.AnonymousClass1(r11));
    }

    public static final <T extends Comparable<? super T>> Sequence<T> sortedDescending(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return sortedWith(r10, ComparisonsKt.reverseOrder());
    }

    public static final <T> Sequence<T> sortedWith(final Sequence<? extends T> r10, final Comparator<? super T> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "comparator");
        return new C04591(r10, r11);
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> int sumBy(Sequence<? extends T> r10, Function1<? super T, Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        r13 = r13 + r11.invoke(r12.next()).intValue();
        goto L4
    L6:
        return r13;
    }

    @Deprecated(message = "Use sumOf instead.", replaceWith = @ReplaceWith(expression = "this.sumOf(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final <T> double sumByDouble(Sequence<? extends T> r10, Function1<? super T, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        double r13 = 0.0d;
    L4:
        if (r12.hasNext() == false) goto L6;
        r13 = r13 + r11.invoke(r12.next()).doubleValue();
        goto L4
    L6:
        return r13;
    }

    @JvmName(name = "sumOfByte")
    public static final int sumOfByte(Sequence<Byte> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Byte> r11 = r10.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 + r11.next().byteValue();
        goto L4
    L6:
        return r12;
    }

    @JvmName(name = "sumOfDouble")
    public static final double sumOfDouble(Sequence<Double> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Double> r11 = r10.iterator();
        double r12 = 0.0d;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 + r11.next().doubleValue();
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfDouble")
    @OverloadResolutionByLambdaReturnType
    private static final <T> double sumOfDouble(Sequence<? extends T> r10, Function1<? super T, Double> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        double r13 = 0.0d;
    L4:
        if (r12.hasNext() == false) goto L6;
        r13 = r13 + r11.invoke(r12.next()).doubleValue();
        goto L4
    L6:
        return r13;
    }

    @JvmName(name = "sumOfFloat")
    public static final float sumOfFloat(Sequence<Float> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Float> r11 = r10.iterator();
        float r12 = 0.0f;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 + r11.next().floatValue();
        goto L4
    L6:
        return r12;
    }

    @JvmName(name = "sumOfInt")
    public static final int sumOfInt(Sequence<Integer> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Integer> r11 = r10.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 + r11.next().intValue();
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfInt")
    @OverloadResolutionByLambdaReturnType
    private static final <T> int sumOfInt(Sequence<? extends T> r10, Function1<? super T, Integer> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        int r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        r13 = r13 + r11.invoke(r12.next()).intValue();
        goto L4
    L6:
        return r13;
    }

    @JvmName(name = "sumOfLong")
    public static long sumOfLong(Sequence<Long> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Long> r11 = r10.iterator();
        long r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 + r11.next().longValue();
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @JvmName(name = "sumOfLong")
    @OverloadResolutionByLambdaReturnType
    private static final <T> long sumOfLong(Sequence<? extends T> r10, Function1<? super T, Long> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        Iterator<? extends T> r12 = r10.iterator();
        long r13 = 0;
    L4:
        if (r12.hasNext() == false) goto L6;
        r13 = r13 + r11.invoke(r12.next()).longValue();
        goto L4
    L6:
        return r13;
    }

    @JvmName(name = "sumOfShort")
    public static final int sumOfShort(Sequence<Short> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<Short> r11 = r10.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L6;
        r12 = r12 + r11.next().shortValue();
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfUInt")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final <T> int sumOfUInt(Sequence<? extends T> r10, Function1<? super T, UInt> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        int r12 = UInt.m127constructorimpl(0);
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12 = UInt.m127constructorimpl(r12 + r11.invoke(r13.next()).m179unboximpl());
        goto L4
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @InlineOnly
    @JvmName(name = "sumOfULong")
    @OverloadResolutionByLambdaReturnType
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    private static final <T> long sumOfULong(Sequence<? extends T> r10, Function1<? super T, ULong> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "selector");
        long r12 = ULong.m206constructorimpl(0);
        Iterator<? extends T> r13 = r10.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        r12 = ULong.m206constructorimpl(r12 + r11.invoke(r13.next()).m258unboximpl());
        goto L4
    L6:
        return r12;
    }

    public static final <T> Sequence<T> take(Sequence<? extends T> r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r11 < 0) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L15;
        if (r11 != 0) goto L10;
        return SequencesKt.emptySequence();
    L10:
        if ((r10 instanceof DropTakeSequence) == false) goto L13;
        return ((DropTakeSequence) r10).take(r11);
    L13:
        return new TakeSequence(r10, r11);
    L15:
        throw new IllegalArgumentException(("Requested element count " + r11 + " is less than zero.").toString());
    L5:
        r12 = false;
        goto L6
    }

    public static <T> Sequence<T> takeWhile(Sequence<? extends T> r10, Function1<? super T, Boolean> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "predicate");
        return new TakeWhileSequence(r10, r11);
    }

    public static final <T, C extends Collection<? super T>> C toCollection(Sequence<? extends T> r10, C r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "destination");
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(r12.next());
        goto L4
    L6:
        return r11;
    }

    public static final <T> HashSet<T> toHashSet(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (HashSet) toCollection(r10, new HashSet());
    }

    public static <T> List<T> toList(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L5;
        T r12 = r11.next();
        if (r11.hasNext() == false) goto L9;
        ArrayList r13 = new ArrayList();
    L11:
        r13.add(r12);
        if (r11.hasNext() == false) goto L14;
        r12 = r11.next();
        goto L11
    L14:
        return r13;
    L9:
        return CollectionsKt.listOf(r12);
    L5:
        return CollectionsKt.emptyList();
    }

    public static <T> List<T> toMutableList(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return (List) toCollection(r10, new ArrayList());
    }

    public static final <T> Set<T> toMutableSet(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        LinkedHashSet r11 = new LinkedHashSet();
        Iterator<? extends T> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L6;
        r11.add(r12.next());
        goto L4
    L6:
        return r11;
    }

    public static final <T> Set<T> toSet(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<? extends T> r11 = r10.iterator();
        if (r11.hasNext() == false) goto L5;
        T r12 = r11.next();
        if (r11.hasNext() == false) goto L9;
        LinkedHashSet r13 = new LinkedHashSet();
    L11:
        r13.add(r12);
        if (r11.hasNext() == false) goto L14;
        r12 = r11.next();
        goto L11
    L14:
        return r13;
    L9:
        return SetsKt.setOf(r12);
    L5:
        return SetsKt.emptySet();
    }

    @SinceKotlin(version = "1.2")
    public static final <T> Sequence<List<T>> windowed(Sequence<? extends T> r10, int r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return SlidingWindowKt.windowedSequence(r10, r11, r12, r13, false);
    }

    @SinceKotlin(version = "1.2")
    public static final <T, R> Sequence<R> windowed(Sequence<? extends T> r10, int r11, int r12, boolean r13, Function1<? super List<? extends T>, ? extends R> r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r14, "transform");
        return SequencesKt.map(SlidingWindowKt.windowedSequence(r10, r11, r12, r13, true), r14);
    }

    public static /* synthetic */ Sequence windowed$default(Sequence r10, int r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = 1;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return windowed(r10, r11, r12, r13);
    }

    public static /* synthetic */ Sequence windowed$default(Sequence r10, int r11, int r12, boolean r13, Function1 r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = 1;
    L6:
        if ((r15 & 4) == 0) goto L9;
        r13 = false;
    L9:
        return windowed(r10, r11, r12, r13, r14);
    }

    public static final <T> Sequence<IndexedValue<T>> withIndex(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new IndexingSequence(r10);
    }

    public static final <T, R> Sequence<Pair<T, R>> zip(Sequence<? extends T> r10, Sequence<? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        return new MergingSequence(r10, r11, C04601.INSTANCE);
    }

    public static final <T, R, V> Sequence<V> zip(Sequence<? extends T> r10, Sequence<? extends R> r11, Function2<? super T, ? super R, ? extends V> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        Intrinsics.checkNotNullParameter(r12, "transform");
        return new MergingSequence(r10, r11, r12);
    }

    @SinceKotlin(version = "1.2")
    public static final <T> Sequence<Pair<T, T>> zipWithNext(Sequence<? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return zipWithNext(r10, C04611.INSTANCE);
    }

    @SinceKotlin(version = "1.2")
    public static final <T, R> Sequence<R> zipWithNext(Sequence<? extends T> r10, Function2<? super T, ? super T, ? extends R> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "transform");
        return SequencesKt.sequence(new C04622(r10, r11, null));
    }
}
