package com.google.common.collect;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes2.dex */
final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Collector<Object, ?, ImmutableList<Object>> f4685a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Collector<Object, ?, ImmutableSet<Object>> f4686b = null;
    private static final Collector<Range<Comparable<?>>, ?, ImmutableRangeSet<Comparable<?>>> c = null;

    static {
        f4685a = Collector.of($$Lambda$OHptdYaOqXSLwg23i6hEPBxveI.INSTANCE, $$Lambda$Z_KFjC_HOhI_BQFaMYH7BsswY4.INSTANCE, $$Lambda$EjqKMZAHgST0i7Q3rIz8DeiyeQ.INSTANCE, $$Lambda$SiUWWea3vtAOdyBTwBqgik0rQ_Q.INSTANCE, new Collector.Characteristics[0]);
        f4686b = Collector.of($$Lambda$tUQFNVTjv8bounyyyykfrMgvqTA.INSTANCE, $$Lambda$ZWvUjtCsnoJZVxRfkPoLvcUTAoU.INSTANCE, $$Lambda$I121bn0zJ4fVTebU1SUBzK1SYY8.INSTANCE, $$Lambda$xWKV2wvubfLiVlunHq14BRVi7kM.INSTANCE, new Collector.Characteristics[0]);
        c = Collector.of($$Lambda$xglw94OkGIj6ImLg9lZa_3Sk03Y.INSTANCE, $$Lambda$RGZK18hXQchTuWhkBw_zIVak150.INSTANCE, $$Lambda$NlkdqxYSRJE2nyB_jSLPz3xzAU.INSTANCE, $$Lambda$aK6zaoaPLmebynldJJoBTMTHQU.INSTANCE, new Collector.Characteristics[0]);
    }

    private static /* synthetic */ ImmutableMultiset a(an r2) {
        return ImmutableMultiset.copyFromEntries(((an) ZeusTransformUtils.wrapperContextForParams(r2, an.class, "com.obric.memorydata.plugin")).entrySet());
    }

    private static /* synthetic */ am a(am r2, am r3) {
        am r4 = (am) ZeusTransformUtils.wrapperContextForParams(r2, am.class, "com.obric.memorydata.plugin");
        r4.putAll((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.memorydata.plugin"));
        return r4;
    }

    private static /* synthetic */ an a(an r2, an r3) {
        an r4 = (an) ZeusTransformUtils.wrapperContextForParams(r2, an.class, "com.obric.memorydata.plugin");
        r4.addAll((an) ZeusTransformUtils.wrapperContextForParams(r3, an.class, "com.obric.memorydata.plugin"));
        return r4;
    }

    static <E> Collector<E, ?, ImmutableList<E>> a() {
        return (Collector<E, ?, ImmutableList<E>>) f4685a;
    }

    static <E> Collector<E, ?, ImmutableSortedSet<E>> a(Comparator<? super E> r4) {
        final Comparator r5 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        return Collector.of(new $$Lambda$n$JftJRHGr_YN741xABXLVZmfm1Q(r5), $$Lambda$qTc9zH30nb1w7MSCEXOJ7uWNbq0.INSTANCE, $$Lambda$Xg8BawzzHQ24lQUbTzsX6tD7vJg.INSTANCE, $$Lambda$WSr7icKYkFtDsulhgF0I4Y83M4c.INSTANCE, new Collector.Characteristics[0]);
    }

    static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> a(Comparator<? super K> r4, Function<? super T, ? extends K> r5, Function<? super T, ? extends V> r6) {
        final Comparator r7 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r4, Comparator.class, "com.obric.memorydata.plugin");
        final Function r8 = (Function) ZeusTransformUtils.wrapperContextForParams(r5, Function.class, "com.obric.memorydata.plugin");
        final Function r9 = (Function) ZeusTransformUtils.wrapperContextForParams(r6, Function.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r7);
        com.google.common.base.n.a(r8);
        com.google.common.base.n.a(r9);
        return Collector.of(new $$Lambda$n$K_XIThW3OFfKE4vM4jQJYWpsU9k(r7), new $$Lambda$n$VemX6wJ7X95oDiFsG57lMtzPc(r8, r9), $$Lambda$XmwWCk4h00KTIIOpH1X_QLOOKU.INSTANCE, $$Lambda$AzA8Z4bceGWVXrCIfrJ12vm_jM.INSTANCE, new Collector.Characteristics[]{Collector.Characteristics.UNORDERED});
    }

    static <T, K, V> Collector<T, ?, ImmutableSortedMap<K, V>> a(Comparator<? super K> r2, Function<? super T, ? extends K> r3, Function<? super T, ? extends V> r4, BinaryOperator<V> r5) {
        final Comparator r6 = (Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin");
        Function r7 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        Function r8 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        BinaryOperator r9 = (BinaryOperator) ZeusTransformUtils.wrapperContextForParams(r5, BinaryOperator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r6);
        com.google.common.base.n.a(r7);
        com.google.common.base.n.a(r8);
        com.google.common.base.n.a(r9);
        return Collectors.collectingAndThen(Collectors.toMap(r7, r8, r9, new $$Lambda$n$ER1qhqjRV4b8Jn6P0WY6aqKMTOM(r6)), $$Lambda$4UhRpYIKXXlqOfqPtEEhuY9EUw.INSTANCE);
    }

    static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> a(Function<? super T, ? extends K> r3, Function<? super T, ? extends V> r4) {
        final Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        final Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        com.google.common.base.n.a(r6);
        return Collector.of($$Lambda$0sS_MHnCFbb0QxAgU2czxR6dydk.INSTANCE, new $$Lambda$n$XGjAXmOpkhEKTguTrprdc8smFpk(r5, r6), $$Lambda$jDDlf4rWQesJqfonZWdi6eOF_n4.INSTANCE, $$Lambda$FEW9QdkRbn6xX9apoJj91eKNYjU.INSTANCE, new Collector.Characteristics[0]);
    }

    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> a(Function<? super T, ? extends K> r2, Function<? super T, ? extends V> r3, BinaryOperator<V> r4) {
        Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        BinaryOperator r7 = (BinaryOperator) ZeusTransformUtils.wrapperContextForParams(r4, BinaryOperator.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        com.google.common.base.n.a(r6);
        com.google.common.base.n.a(r7);
        return Collectors.collectingAndThen(Collectors.toMap(r5, r6, r7, $$Lambda$n$Rr5wHpoNM5boD4b5K8greFBFLF8.INSTANCE), $$Lambda$KxfAxes3ebmIrrqlO5MIBZODs.INSTANCE);
    }

    static <T, K, V, M extends am<K, V>> Collector<T, ?, M> a(Function<? super T, ? extends K> r2, Function<? super T, ? extends Stream<? extends V>> r3, Supplier<M> r4) {
        final Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        final Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        Supplier r7 = (Supplier) ZeusTransformUtils.wrapperContextForParams(r4, Supplier.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        com.google.common.base.n.a(r6);
        com.google.common.base.n.a(r7);
        return Collector.of(r7, new $$Lambda$n$yF0RzJmO5Kuw2EwRyM_Vz6CGqm4(r5, r6), $$Lambda$n$KYtEJh3wS_3sZKbZaCQEsYLo_2w.INSTANCE, new Collector.Characteristics[0]);
    }

    static <T, E> Collector<T, ?, ImmutableMultiset<E>> a(Function<? super T, ? extends E> r3, ToIntFunction<? super T> r4) {
        final Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        final ToIntFunction r6 = (ToIntFunction) ZeusTransformUtils.wrapperContextForParams(r4, ToIntFunction.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        com.google.common.base.n.a(r6);
        return Collector.of($$Lambda$rC_xZw7QxBrO7NzDYC0Cxp_R_U.INSTANCE, new $$Lambda$n$xnTe4R8cP6EMqzP3fgG4imZH5Dc(r5, r6), $$Lambda$n$pGOA6wNYVHirDX4GC_EfSvqLUSU.INSTANCE, $$Lambda$n$1J8o2Ek8eIdrENNFYA53TOEQukE.INSTANCE, new Collector.Characteristics[0]);
    }

    private static /* synthetic */ Stream a(Function r2, Object r3) {
        return ((Stream) ZeusTransformUtils.preCheckCast(((Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin")).apply(r3), Stream.class, "com.obric.memorydata.plugin")).peek($$Lambda$sSzrCkPhmVwe16v7Ecldc5IHvq8.INSTANCE);
    }

    private static /* synthetic */ void a(Function r2, Function r3, ImmutableBiMap.a r4, Object r5) {
        Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        Function r7 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        r4.a(r6.apply(r5), r7.apply(r5));
    }

    private static /* synthetic */ void a(Function r2, Function r3, ImmutableListMultimap.a r4, Object r5) {
        Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        Function r7 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        r4.a(r6.apply(r5), r7.apply(r5));
    }

    private static /* synthetic */ void a(Function r2, Function r3, ImmutableMap.a r4, Object r5) {
        Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        Function r7 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        r4.b(r6.apply(r5), r7.apply(r5));
    }

    private static /* synthetic */ void a(Function r2, Function r3, ImmutableRangeMap.a r4, Object r5) {
        Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        Function r7 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        r4.a((Range) ZeusTransformUtils.preCheckCast(r6.apply(r5), Range.class, "com.obric.memorydata.plugin"), r7.apply(r5));
    }

    private static /* synthetic */ void a(Function r2, Function r3, ImmutableSetMultimap.a r4, Object r5) {
        Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        Function r7 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        r4.a(r6.apply(r5), r7.apply(r5));
    }

    private static /* synthetic */ void a(Function r2, Function r3, ImmutableSortedMap.a r4, Object r5) {
        Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        Function r7 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        r4.a(r6.apply(r5), r7.apply(r5));
    }

    private static /* synthetic */ void a(Function r2, Function r3, am r4, Object r5) {
        Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        Function r7 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        final Collection r8 = ((am) ZeusTransformUtils.wrapperContextForParams(r4, am.class, "com.obric.memorydata.plugin")).get(r6.apply(r5));
        Stream r9 = (Stream) ZeusTransformUtils.preCheckCast(r7.apply(r5), Stream.class, "com.obric.memorydata.plugin");
        Objects.requireNonNull(r8);
        r9.forEachOrdered(new $$Lambda$V8ksY1c7dt_x9qbYeLWCcrcYdZw(r8));
    }

    private static /* synthetic */ void a(Function r2, ToIntFunction r3, an r4, Object r5) {
        Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        ToIntFunction r7 = (ToIntFunction) ZeusTransformUtils.wrapperContextForParams(r3, ToIntFunction.class, "com.obric.memorydata.plugin");
        ((an) ZeusTransformUtils.wrapperContextForParams(r4, an.class, "com.obric.memorydata.plugin")).add(com.google.common.base.n.a(r6.apply(r5)), r7.applyAsInt(r5));
    }

    private static /* synthetic */ Object b(Function r2, Object r3) {
        return com.google.common.base.n.a(((Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin")).apply(r3));
    }

    private static /* synthetic */ TreeMap b(Comparator r2) {
        return new TreeMap((Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin"));
    }

    static <E> Collector<E, ?, ImmutableSet<E>> b() {
        return (Collector<E, ?, ImmutableSet<E>>) f4686b;
    }

    static <T, K, V> Collector<T, ?, ImmutableBiMap<K, V>> b(Function<? super T, ? extends K> r3, Function<? super T, ? extends V> r4) {
        final Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        final Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        com.google.common.base.n.a(r6);
        return Collector.of($$Lambda$XzqknmNoafgSeEfm7SzosClxbs.INSTANCE, new $$Lambda$n$p2qVRVtvH0uXpUtLZIsl0htPDVw(r5, r6), $$Lambda$pSjkNzGQ6GlV_nZEKtn6LzrGsw.INSTANCE, $$Lambda$AfNjhY7S7zqR7OJJyBrwPSvRytE.INSTANCE, new Collector.Characteristics[0]);
    }

    private static /* synthetic */ ImmutableSortedMap.a c(Comparator r2) {
        return new ImmutableSortedMap.a((Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin"));
    }

    static <E extends Comparable<? super E>> Collector<Range<E>, ?, ImmutableRangeSet<E>> c() {
        return (Collector<Range<E>, ?, ImmutableRangeSet<E>>) c;
    }

    static <T, K extends Comparable<? super K>, V> Collector<T, ?, ImmutableRangeMap<K, V>> c(Function<? super T, Range<K>> r3, Function<? super T, ? extends V> r4) {
        final Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        final Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5);
        com.google.common.base.n.a(r6);
        return Collector.of($$Lambda$xOB8tFkjQXu9FMr42xwH3PQfcys.INSTANCE, new $$Lambda$n$gGCbmaEtF93bywNOXK1Um4idXy8(r5, r6), $$Lambda$_dGz6GvQp444Y0gsxvoj6pfeCsQ.INSTANCE, $$Lambda$tF9EQVvsd7IChHwIMazgs_vwicA.INSTANCE, new Collector.Characteristics[0]);
    }

    private static /* synthetic */ Stream c(Function r2, Object r3) {
        return ((Stream) ZeusTransformUtils.preCheckCast(((Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin")).apply(r3), Stream.class, "com.obric.memorydata.plugin")).peek($$Lambda$sSzrCkPhmVwe16v7Ecldc5IHvq8.INSTANCE);
    }

    private static /* synthetic */ ImmutableSortedSet.a d(Comparator r2) {
        return new ImmutableSortedSet.a((Comparator) ZeusTransformUtils.wrapperContextForParams(r2, Comparator.class, "com.obric.memorydata.plugin"));
    }

    private static /* synthetic */ Object d(Function r2, Object r3) {
        return com.google.common.base.n.a(((Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin")).apply(r3));
    }

    static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> d(Function<? super T, ? extends K> r3, Function<? super T, ? extends V> r4) {
        final Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        final Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5, "keyFunction");
        com.google.common.base.n.a(r6, "valueFunction");
        return Collector.of($$Lambda$teXkrr_s0l7b1zPpwF4MyL07I7M.INSTANCE, new $$Lambda$n$F4auW8Nyvs6XSjcmnsZHxLMvAxY(r5, r6), $$Lambda$JXic3AOuGjuwjPsII8ErXfBXi4c.INSTANCE, $$Lambda$oyTgksyhEkUNmSCQU74Voe7IyYw.INSTANCE, new Collector.Characteristics[0]);
    }

    static <T, K, V> Collector<T, ?, ImmutableListMultimap<K, V>> e(Function<? super T, ? extends K> r2, Function<? super T, ? extends Stream<? extends V>> r3) {
        final Function r4 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        final Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        com.google.common.base.n.a(r5);
        Function r0 = new $$Lambda$n$nDYpfCKgJZbEgXE7aNte9Bt8pvg(r4);
        Function r6 = new $$Lambda$n$G7CzDqTIn4543z0mUJSltHEvU(r5);
        final MultimapBuilder.a<Object, Object> r7 = MultimapBuilder.a().b();
        Objects.requireNonNull(r7);
        return Collectors.collectingAndThen(a(r0, r6, new $$Lambda$EQE9sZL1Du2TpWIwS_wF_g_h8Y(r7)), $$Lambda$HvgJAf0jEQWmk3X3iusM6YsNxJU.INSTANCE);
    }

    static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> f(Function<? super T, ? extends K> r3, Function<? super T, ? extends V> r4) {
        final Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        final Function r6 = (Function) ZeusTransformUtils.wrapperContextForParams(r4, Function.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r5, "keyFunction");
        com.google.common.base.n.a(r6, "valueFunction");
        return Collector.of($$Lambda$Buz6vUD4BQcC6lmtyuCVDKK3Ezs.INSTANCE, new $$Lambda$n$KxdINWjPvj0YiJX3SzElBwprIM(r5, r6), $$Lambda$HRBMRqggpPTWe8UnVgyN1LNyD9c.INSTANCE, $$Lambda$9FZRY51ABNAbZkcWPto6xh3RHmE.INSTANCE, new Collector.Characteristics[0]);
    }

    static <T, K, V> Collector<T, ?, ImmutableSetMultimap<K, V>> g(Function<? super T, ? extends K> r2, Function<? super T, ? extends Stream<? extends V>> r3) {
        final Function r4 = (Function) ZeusTransformUtils.wrapperContextForParams(r2, Function.class, "com.obric.memorydata.plugin");
        final Function r5 = (Function) ZeusTransformUtils.wrapperContextForParams(r3, Function.class, "com.obric.memorydata.plugin");
        com.google.common.base.n.a(r4);
        com.google.common.base.n.a(r5);
        Function r0 = new $$Lambda$n$9K217uPA44_USYV5E7SBzrQuNuE(r4);
        Function r6 = new $$Lambda$n$wDzsmHDcRw8C81y87cxYJjuOvkw(r5);
        final MultimapBuilder.c<Object, Object> r7 = MultimapBuilder.a().c();
        Objects.requireNonNull(r7);
        return Collectors.collectingAndThen(a(r0, r6, new $$Lambda$vUlZyx1XycGGEvv0xpnyf8NCOw4(r7)), $$Lambda$6u2h53_bjMUhcrrnOvDoBq6IgVI.INSTANCE);
    }

    /* JADX INFO: renamed from: lambda$-VemX6w-J7X95oDiFsG57lMtzPc, reason: not valid java name */
    public static /* synthetic */ void m134lambda$VemX6wJ7X95oDiFsG57lMtzPc(Function r0, Function r1, ImmutableSortedMap.a r2, Object r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ ImmutableMultiset lambda$1J8o2Ek8eIdrENNFYA53TOEQukE(an r0) {
        return a(r0);
    }

    public static /* synthetic */ Object lambda$9K217uPA44_USYV5E7SBzrQuNuE(Function r0, Object r1) {
        return b(r0, r1);
    }

    public static /* synthetic */ TreeMap lambda$ER1qhqjRV4b8Jn6P0WY6aqKMTOM(Comparator r0) {
        return b(r0);
    }

    public static /* synthetic */ void lambda$F4auW8Nyvs6XSjcmnsZHxLMvAxY(Function r0, Function r1, ImmutableListMultimap.a r2, Object r3) {
        a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$G7CzDqTIn4-543z0mU-JSltHEvU, reason: not valid java name */
    public static /* synthetic */ Stream m135lambda$G7CzDqTIn4543z0mUJSltHEvU(Function r0, Object r1) {
        return c(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$JftJRHGr_YN741xAB-XLVZmfm1Q, reason: not valid java name */
    public static /* synthetic */ ImmutableSortedSet.a m136lambda$JftJRHGr_YN741xABXLVZmfm1Q(Comparator r0) {
        return d(r0);
    }

    public static /* synthetic */ am lambda$KYtEJh3wS_3sZKbZaCQEsYLo_2w(am r0, am r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ ImmutableSortedMap.a lambda$K_XIThW3OFfKE4vM4jQJYWpsU9k(Comparator r0) {
        return c(r0);
    }

    /* JADX INFO: renamed from: lambda$KxdINWj-Pvj0YiJX3SzElBwprIM, reason: not valid java name */
    public static /* synthetic */ void m137lambda$KxdINWjPvj0YiJX3SzElBwprIM(Function r0, Function r1, ImmutableSetMultimap.a r2, Object r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ LinkedHashMap lambda$Rr5wHpoNM5boD4b5K8greFBFLF8() {
        return new LinkedHashMap();
    }

    public static /* synthetic */ void lambda$XGjAXmOpkhEKTguTrprdc8smFpk(Function r0, Function r1, ImmutableMap.a r2, Object r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$gGCbmaEtF93bywNOXK1Um4idXy8(Function r0, Function r1, ImmutableRangeMap.a r2, Object r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ Object lambda$nDYpfCKgJZbEgXE7aNte9Bt8pvg(Function r0, Object r1) {
        return d(r0, r1);
    }

    public static /* synthetic */ void lambda$p2qVRVtvH0uXpUtLZIsl0htPDVw(Function r0, Function r1, ImmutableBiMap.a r2, Object r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ an lambda$pGOA6wNYVHirDX4GC_EfSvqLUSU(an r0, an r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ Stream lambda$wDzsmHDcRw8C81y87cxYJjuOvkw(Function r0, Object r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ void lambda$xnTe4R8cP6EMqzP3fgG4imZH5Dc(Function r0, ToIntFunction r1, an r2, Object r3) {
        a(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$yF0RzJmO5Kuw2EwRyM_Vz6CGqm4(Function r0, Function r1, am r2, Object r3) {
        a(r0, r1, r2, r3);
    }
}
