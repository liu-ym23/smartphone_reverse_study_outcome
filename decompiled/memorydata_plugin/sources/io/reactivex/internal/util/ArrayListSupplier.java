package io.reactivex.internal.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes6.dex */
public final enum ArrayListSupplier extends Enum<ArrayListSupplier> implements io.reactivex.b.h<Object, List<Object>>, Callable<List<Object>> {
    private static final /* synthetic */ ArrayListSupplier[] $VALUES = null;
    public static final ArrayListSupplier INSTANCE = null;

    static {
        ArrayListSupplier r0 = new ArrayListSupplier("INSTANCE", 0);
        INSTANCE = r0;
        $VALUES = new ArrayListSupplier[]{r0};
    }

    private ArrayListSupplier(String r1, int r2) {
        super(r1, r2);
    }

    public static <T> Callable<List<T>> asCallable() {
        return INSTANCE;
    }

    public static <T, O> io.reactivex.b.h<O, List<T>> asFunction() {
        return INSTANCE;
    }

    public static ArrayListSupplier valueOf(String r2) {
        return (ArrayListSupplier) ZeusTransformUtils.preCheckCast(Enum.valueOf(ArrayListSupplier.class, r2), ArrayListSupplier.class, "com.obric.memorydata.plugin");
    }

    public static ArrayListSupplier[] values() {
        return (ArrayListSupplier[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ArrayListSupplier[].class, "com.obric.memorydata.plugin");
    }

    @Override // io.reactivex.b.h
    public /* bridge */ /* synthetic */ List<Object> apply(Object r1) {
        return apply2(r1);
    }

    @Override // io.reactivex.b.h
    /* JADX INFO: renamed from: apply, reason: avoid collision after fix types in other method */
    public List<Object> apply2(Object r1) {
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
