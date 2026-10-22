package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/* JADX INFO: loaded from: classes2.dex */
final class p {

    /* JADX INFO: Add missing generic type declarations: [OutElementT] */
    /* JADX INFO: renamed from: com.google.common.collect.p$1, reason: invalid class name */
    class AnonymousClass1<OutElementT> implements Spliterator<OutElementT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Spliterator f4687a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function f4688b;

        AnonymousClass1(Spliterator r3, Function r4) {
            Spliterator r5 = (Spliterator) ZeusTransformUtils.wrapperContextForParams(r3, Spliterator.class, "com.obric.memorydata.plugin");
            Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
            this.f4687a = r5;
            this.f4688b = r6;
        }

        private static /* synthetic */ void a(Consumer r2, Function r3, Object r4) {
            ((Consumer) ZeusTransformUtils.wrapperContextForParams(r2, Consumer.class, "com.obric.memorydata.plugin")).accept(((Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin")).apply(r4));
        }

        private static /* synthetic */ void b(Consumer r2, Function r3, Object r4) {
            ((Consumer) ZeusTransformUtils.wrapperContextForParams(r2, Consumer.class, "com.obric.memorydata.plugin")).accept(((Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin")).apply(r4));
        }

        public static /* synthetic */ void lambda$3uOQxL8fKIerKT9LHCuQc37V3Qg(Consumer r0, Function r1, Object r2) {
            a(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$H4qUGeKLPl_oPNcZ2lOreC9tEpg(Consumer r0, Function r1, Object r2) {
            b(r0, r1, r2);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f4687a.characteristics() & (-262);
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f4687a.estimateSize();
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super OutElementT> r3) {
            final Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            Spliterator r0 = this.f4687a;
            final Function r2 = this.f4688b;
            r0.forEachRemaining(new $$Lambda$p$1$3uOQxL8fKIerKT9LHCuQc37V3Qg(r4, r2));
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super OutElementT> r3) {
            final Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            Spliterator r0 = this.f4687a;
            final Function r2 = this.f4688b;
            return r0.tryAdvance(new $$Lambda$p$1$H4qUGeKLPl_oPNcZ2lOreC9tEpg(r4, r2));
        }

        @Override // java.util.Spliterator
        public Spliterator<OutElementT> trySplit() {
            Spliterator r0 = this.f4687a.trySplit();
            if (r0 != null) goto L7;
            return null;
        L7:
            return p.a(r0, this.f4688b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class a<T> implements Spliterator<T>, Consumer<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        T f4689a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Spliterator f4690b;
        final /* synthetic */ Predicate c;

        a(Spliterator r3, Predicate r4) {
            Spliterator r5 = (Spliterator) ZeusTransformUtils.wrapperContextForParams(r3, Spliterator.class, "com.obric.memorydata.plugin");
            Predicate r6 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r4, Predicate.class, "com.obric.memorydata.plugin");
            this.f4690b = r5;
            this.c = r6;
            this.f4689a = null;
        }

        @Override // java.util.function.Consumer
        public void accept(T r1) {
            this.f4689a = r1;
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f4690b.characteristics() & 277;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.f4690b.estimateSize() / 2;
        }

        @Override // java.util.Spliterator
        public Comparator<? super T> getComparator() {
            return this.f4690b.getComparator();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super T> r4) {
            Consumer r5 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r4, Consumer.class, "com.obric.memorydata.plugin");
        L4:
            if (this.f4690b.tryAdvance(this) == false) goto L15;
            Object r1 = ao.a(this.f4689a);     // Catch: Throwable -> L12
            if (this.c.test(r1) == true) goto L8;
            this.f4689a = null;
            goto L4
        L8:
            r5.accept(r1);     // Catch: Throwable -> L12
            this.f4689a = null;
            return true;
        L12:
            th = move-exception;
            this.f4689a = null;
            throw th;
        L15:
            return false;
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            Spliterator<T> r0 = this.f4690b.trySplit();
            if (r0 != null) goto L6;
            return null;
        L6:
            return p.a(r0, this.c);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    class b<T> implements Spliterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IntFunction f4691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f4692b;
        final /* synthetic */ Comparator c;
        private final Spliterator.OfInt d;

        b(Spliterator.OfInt r3, IntFunction r4, int r5, Comparator r6) {
            Spliterator.OfInt r7 = (Spliterator.OfInt) ZeusTransformUtils.wrapperContextForParams(r3, Spliterator.OfInt.class, "com.obric.memorydata.plugin");
            IntFunction r8 = (IntFunction) ZeusTransformUtils.wrapperContextForParams(r4, IntFunction.class, "com.obric.memorydata.plugin");
            Comparator r9 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r6, Comparator.class, "com.obric.memorydata.plugin");
            this.f4691a = r8;
            this.f4692b = r5;
            this.c = r9;
            this.d = r7;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static /* synthetic */ void a(Consumer r2, IntFunction r3, int r4) {
            ((Consumer) ZeusTransformUtils.wrapperContextForParams(r2, Consumer.class, "com.obric.memorydata.plugin")).accept(((IntFunction) ZeusTransformUtils.wrapperContextForParams(r3, IntFunction.class, "com.obric.memorydata.plugin")).apply(r4));
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static /* synthetic */ void b(Consumer r2, IntFunction r3, int r4) {
            ((Consumer) ZeusTransformUtils.wrapperContextForParams(r2, Consumer.class, "com.obric.memorydata.plugin")).accept(((IntFunction) ZeusTransformUtils.wrapperContextForParams(r3, IntFunction.class, "com.obric.memorydata.plugin")).apply(r4));
        }

        public static /* synthetic */ void lambda$3SegGQhYnJYf26Mm6NhfIX19mJw(Consumer r0, IntFunction r1, int r2) {
            a(r0, r1, r2);
        }

        public static /* synthetic */ void lambda$7UTkgWBDpKfNyqtTPLTFuv2X__8(Consumer r0, IntFunction r1, int r2) {
            b(r0, r1, r2);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.f4692b | 16464;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.d.estimateSize();
        }

        @Override // java.util.Spliterator
        public void forEachRemaining(Consumer<? super T> r3) {
            final Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            Spliterator.OfInt r0 = this.d;
            final IntFunction r2 = this.f4691a;
            r0.forEachRemaining(new $$Lambda$p$b$3SegGQhYnJYf26Mm6NhfIX19mJw(r4, r2));
        }

        @Override // java.util.Spliterator
        public Comparator<? super T> getComparator() {
            if (hasCharacteristics(4) == false) goto L7;
            return this.c;
        L7:
            throw new IllegalStateException();
        }

        @Override // java.util.Spliterator
        public boolean tryAdvance(Consumer<? super T> r3) {
            final Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            Spliterator.OfInt r0 = this.d;
            final IntFunction r2 = this.f4691a;
            return r0.tryAdvance(new $$Lambda$p$b$7UTkgWBDpKfNyqtTPLTFuv2X__8(r4, r2));
        }

        @Override // java.util.Spliterator
        public Spliterator<T> trySplit() {
            Spliterator.OfInt r0 = this.d.trySplit();
            if (r0 != null) goto L6;
            return null;
        L6:
            return new b(r0, this.f4691a, this.f4692b, this.c);
        }
    }

    static abstract class c<InElementT, OutElementT, OutSpliteratorT extends Spliterator<OutElementT>> implements Spliterator<OutElementT> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        OutSpliteratorT f4693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Spliterator<InElementT> f4694b;
        final Function<? super InElementT, OutSpliteratorT> c;
        final a<InElementT, OutSpliteratorT> d;
        int e;
        long f;

        @FunctionalInterface
        interface a<InElementT, OutSpliteratorT extends Spliterator<?>> {
            OutSpliteratorT newFlatMapSpliterator(OutSpliteratorT r1, Spliterator<InElementT> r2, Function<? super InElementT, OutSpliteratorT> r3, int r4, long r5);
        }

        c(OutSpliteratorT r3, Spliterator<InElementT> r4, Function<? super InElementT, OutSpliteratorT> r5, a<InElementT, OutSpliteratorT> r6, int r7, long r8) {
            OutSpliteratorT r9 = (OutSpliteratorT) ZeusTransformUtils.wrapperContextForParams(r3, Spliterator.class, "com.obric.memorydata.plugin");
            Spliterator<InElementT> r10 = (Spliterator) ZeusTransformUtils.wrapperContextForParams(r4, Spliterator.class, "com.obric.memorydata.plugin");
            Function<? super InElementT, OutSpliteratorT> r11 = (Function) ZeusTransformUtils.wrapperContextForParams(r5, Function.class, "com.obric.memorydata.plugin");
            a<InElementT, OutSpliteratorT> r12 = (a) ZeusTransformUtils.wrapperContextForParams(r6, a.class, "com.obric.memorydata.plugin");
            this.f4693a = r9;
            this.f4694b = r10;
            this.c = r11;
            this.d = r12;
            this.e = r7;
            this.f = r8;
        }

        private /* synthetic */ void a(Object r3) {
            this.f4693a = (OutSpliteratorT) ZeusTransformUtils.preCheckCast(this.c.apply(r3), Spliterator.class, "com.obric.memorydata.plugin");
        }

        private /* synthetic */ void a(Consumer r3, Object r4) {
            Consumer r5 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            Spliterator r2 = (Spliterator) ZeusTransformUtils.preCheckCast(this.c.apply(r4), Spliterator.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L6;
            r2.forEachRemaining(r5);
            return;
        }

        public static /* synthetic */ void lambda$2HrBUHDsFqVjMusLjavcLO0l45c(c r0, Object r1) {
            r0.a(r1);
        }

        public static /* synthetic */ void lambda$DZlpAhsSU5iZMam3yw2sfyu1Mzs(c r0, Consumer r1, Object r2) {
            r0.a(r1, r2);
        }

        @Override // java.util.Spliterator
        public final int characteristics() {
            return this.e;
        }

        @Override // java.util.Spliterator
        public final long estimateSize() {
            OutSpliteratorT r0 = this.f4693a;
            if (r0 == null) goto L6;
            this.f = Math.max(this.f, r0.estimateSize());
        L6:
            return Math.max(this.f, 0);
        }

        @Override // java.util.Spliterator
        public final void forEachRemaining(Consumer<? super OutElementT> r3) {
            final Consumer r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.memorydata.plugin");
            OutSpliteratorT r0 = this.f4693a;
            if (r0 == null) goto L5;
            r0.forEachRemaining(r4);
            this.f4693a = null;
        L5:
            this.f4694b.forEachRemaining(new $$Lambda$p$c$DZlpAhsSU5iZMam3yw2sfyu1Mzs(this, r4));
            this.f = 0;
        }

        @Override // java.util.Spliterator
        public final boolean tryAdvance(Consumer<? super OutElementT> r5) {
            Consumer r6 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r5, Consumer.class, "com.obric.memorydata.plugin");
        L3:
            OutSpliteratorT r0 = this.f4693a;
            if (r0 != null) goto L6;
        L12:
            this.f4693a = null;
            if (this.f4694b.tryAdvance(new $$Lambda$p$c$2HrBUHDsFqVjMusLjavcLO0l45c(this)) == true) goto L3;
            return false;
        L6:
            if (r0.tryAdvance(r6) == false) goto L12;
            long r1 = this.f;
            if (r1 == Long.MAX_VALUE) goto L19;
            this.f = r1 - 1;
            return true;
        L19:
            return true;
        }

        @Override // java.util.Spliterator
        public final OutSpliteratorT trySplit() {
            Spliterator<InElementT> r3 = this.f4694b.trySplit();
            if (r3 == null) goto L9;
            int r5 = this.e & (-65);
            long r1 = estimateSize();
            if (r1 >= Long.MAX_VALUE) goto L7;
            r1 = r1 / 2;
            this.f -= r1;
            this.e = r5;
        L7:
            OutSpliteratorT r2 = (OutSpliteratorT) this.d.newFlatMapSpliterator(this.f4693a, r3, this.c, r5, r1);
            this.f4693a = null;
            return r2;
        L9:
            OutSpliteratorT r4 = this.f4693a;
            if (r4 == null) goto L13;
            this.f4693a = null;
            return r4;
        L13:
            return null;
        }
    }

    static final class d<InElementT, OutElementT> extends c<InElementT, OutElementT, Spliterator<OutElementT>> {
        d(Spliterator<OutElementT> r11, Spliterator<InElementT> r12, Function<? super InElementT, Spliterator<OutElementT>> r13, int r14, long r15) {
            super((Spliterator) ZeusTransformUtils.wrapperContextForParams(r11, Spliterator.class, "com.obric.memorydata.plugin"), (Spliterator) ZeusTransformUtils.wrapperContextForParams(r12, Spliterator.class, "com.obric.memorydata.plugin"), (Function) ZeusTransformUtils.wrapperContextForParams(r13, Function.class, "com.obric.memorydata.plugin"), $$Lambda$mvuIlelUycXsPdjnTuk7wwQhQjE.INSTANCE, r14, r15);
        }
    }

    static <T> Spliterator<T> a(int r2, int r3, IntFunction<T> r4) {
        return a(r2, r3, (IntFunction) ZeusTransformUtils.wrapperContextForParams(r4, IntFunction.class, "com.obric.memorydata.plugin"), null);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.Spliterator$OfInt] */
    static <T> Spliterator<T> a(int r2, int r3, IntFunction<T> r4, Comparator<? super T> r5) {
        IntFunction r6 = (IntFunction) ZeusTransformUtils.wrapperContextForParams(r4, IntFunction.class, "com.obric.memorydata.plugin");
        Comparator r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r5, Comparator.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L10;
        if ((r3 & 4) == 0) goto L7;
        boolean r1 = true;
    L8:
        com.google.common.base.n.a(r1);
        goto L10
    L7:
        r1 = false;
    L10:
        return new b(IntStream.range(0, r2).spliterator(), r6, r3, r7);
    }

    static <InElementT, OutElementT> Spliterator<OutElementT> a(Spliterator<InElementT> r2, Function<? super InElementT, ? extends OutElementT> r3) {
        Spliterator r4 = (Spliterator) ZeusTransformUtils.wrapperContextForParams(r2, Spliterator.class, "com.obric.memorydata.plugin");
        Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        com.google.common.base.n.a(r5);
        return new AnonymousClass1(r4, r5);
    }

    static <InElementT, OutElementT> Spliterator<OutElementT> a(Spliterator<InElementT> r9, Function<? super InElementT, Spliterator<OutElementT>> r10, int r11, long r12) {
        Spliterator r4 = (Spliterator) ZeusTransformUtils.wrapperContextForParams(r9, Spliterator.class, "com.obric.memorydata.plugin");
        Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r10, Function.class, "com.obric.memorydata.plugin");
        boolean r13 = true;
        if ((r11 & 16384) != 0) goto L5;
        boolean r14 = true;
    L6:
        com.google.common.base.n.a(r14, "flatMap does not support SUBSIZED characteristic");
        if ((r11 & 4) == 0) goto L10;
        r13 = false;
    L10:
        com.google.common.base.n.a(r13, "flatMap does not support SORTED characteristic");
        com.google.common.base.n.a(r4);
        com.google.common.base.n.a(r5);
        return new d(null, r4, r5, r11, r12);
    L5:
        r14 = false;
        goto L6
    }

    static <T> Spliterator<T> a(Spliterator<T> r2, Predicate<? super T> r3) {
        Spliterator r4 = (Spliterator) ZeusTransformUtils.wrapperContextForParams(r2, Spliterator.class, "com.obric.memorydata.plugin");
        Predicate r5 = (Predicate) ZeusTransformUtils.wrapperContextForParams(r3, Predicate.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        com.google.common.base.n.a(r5);
        return new a(r4, r5);
    }
}
