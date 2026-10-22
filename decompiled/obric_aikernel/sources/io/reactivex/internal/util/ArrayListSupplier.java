package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final enum ArrayListSupplier extends Enum<ArrayListSupplier> implements Callable<List<Object>>, zb.h<Object, List<Object>> {
    private static final /* synthetic */ ArrayListSupplier[] $VALUES = null;
    public static final ArrayListSupplier INSTANCE = null;

    static {
        ArrayListSupplier r10 = new ArrayListSupplier("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new ArrayListSupplier[]{r10};
    }

    private ArrayListSupplier(String r10, int r11) {
        super(r10, r11);
    }

    public static <T> Callable<List<T>> asCallable() {
        return INSTANCE;
    }

    public static <T, O> zb.h<O, List<T>> asFunction() {
        return INSTANCE;
    }

    public static ArrayListSupplier valueOf(String r10) {
        return (ArrayListSupplier) Enum.valueOf(ArrayListSupplier.class, r10);
    }

    public static ArrayListSupplier[] values() {
        return (ArrayListSupplier[]) $VALUES.clone();
    }

    @Override // zb.h
    public /* bridge */ /* synthetic */ List<Object> apply(Object r10) {
        return apply2(r10);
    }

    @Override // zb.h
    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public List<Object> apply2(Object r10) {
        return new ArrayList();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ List<Object> call() {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public List<Object> call2() {
        return new ArrayList();
    }
}
