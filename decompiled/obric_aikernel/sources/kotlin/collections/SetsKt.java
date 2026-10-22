package kotlin.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;

/* JADX INFO: loaded from: classes2.dex */
public final class SetsKt extends SetsKt___SetsKt {
    private SetsKt() {
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static /* bridge */ /* synthetic */ <E> Set<E> build(Set<E> r10) {
        return SetsKt__SetsJVMKt.build(r10);
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static /* bridge */ /* synthetic */ <E> Set<E> createSetBuilder() {
        return SetsKt__SetsJVMKt.createSetBuilder();
    }

    @SinceKotlin(version = "1.3")
    @PublishedApi
    public static /* bridge */ /* synthetic */ <E> Set<E> createSetBuilder(int r10) {
        return SetsKt__SetsJVMKt.createSetBuilder(r10);
    }

    public static /* bridge */ /* synthetic */ <T> Set<T> emptySet() {
        return SetsKt__SetsKt.emptySet();
    }

    public static /* bridge */ /* synthetic */ <T> HashSet<T> hashSetOf(T... r10) {
        return SetsKt__SetsKt.hashSetOf(r10);
    }

    public static /* bridge */ /* synthetic */ <T> LinkedHashSet<T> linkedSetOf(T... r10) {
        return SetsKt__SetsKt.linkedSetOf(r10);
    }

    public static /* bridge */ /* synthetic */ <T> Set<T> minus(Set<? extends T> r10, Iterable<? extends T> r11) {
        return SetsKt___SetsKt.minus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> Set<T> minus(Set<? extends T> r10, T r11) {
        return SetsKt___SetsKt.minus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> Set<T> mutableSetOf(T... r10) {
        return SetsKt__SetsKt.mutableSetOf(r10);
    }

    public static /* bridge */ /* synthetic */ <T> Set<T> plus(Set<? extends T> r10, Iterable<? extends T> r11) {
        return SetsKt___SetsKt.plus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> Set<T> plus(Set<? extends T> r10, T r11) {
        return SetsKt___SetsKt.plus(r10, r11);
    }

    public static /* bridge */ /* synthetic */ <T> Set<T> setOf(T r10) {
        return SetsKt__SetsJVMKt.setOf(r10);
    }

    public static /* bridge */ /* synthetic */ <T> Set<T> setOf(T... r10) {
        return SetsKt__SetsKt.setOf(r10);
    }
}
