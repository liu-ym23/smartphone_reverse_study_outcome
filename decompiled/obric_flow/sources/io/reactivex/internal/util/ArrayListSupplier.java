package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import pt.o;

/* JADX INFO: loaded from: classes3.dex */
public final enum ArrayListSupplier extends Enum<ArrayListSupplier> implements Callable<List<Object>>, o {
    public static final ArrayListSupplier INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ArrayListSupplier[] f18163a = null;

    static {
        ArrayListSupplier r5 = new ArrayListSupplier("INSTANCE", 0);
        INSTANCE = r5;
        f18163a = new ArrayListSupplier[]{r5};
    }

    public static <T> Callable<List<T>> asCallable() {
        return INSTANCE;
    }

    public static <T, O> o asFunction() {
        return INSTANCE;
    }

    public static ArrayListSupplier valueOf(String r5) {
        return (ArrayListSupplier) Enum.valueOf(ArrayListSupplier.class, r5);
    }

    public static ArrayListSupplier[] values() {
        return (ArrayListSupplier[]) f18163a.clone();
    }

    @Override // pt.o
    public /* bridge */ /* synthetic */ Object apply(Object r5) throws Exception {
        return apply(r5);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ List<Object> call() throws Exception {
        return call2();
    }

    @Override // pt.o
    public List<Object> apply(Object r5) throws Exception {
        return new ArrayList();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public List<Object> call2() throws Exception {
        return new ArrayList();
    }
}
