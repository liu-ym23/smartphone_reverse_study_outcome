package io.reactivex.internal.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes2.dex */
public final enum HashMapSupplier extends Enum<HashMapSupplier> implements Callable<Map<Object, Object>> {
    private static final /* synthetic */ HashMapSupplier[] $VALUES = null;
    public static final HashMapSupplier INSTANCE = null;

    static {
        HashMapSupplier r10 = new HashMapSupplier("INSTANCE", 0);
        INSTANCE = r10;
        $VALUES = new HashMapSupplier[]{r10};
    }

    private HashMapSupplier(String r10, int r11) {
        super(r10, r11);
    }

    public static <K, V> Callable<Map<K, V>> asCallable() {
        return INSTANCE;
    }

    public static HashMapSupplier valueOf(String r10) {
        return (HashMapSupplier) Enum.valueOf(HashMapSupplier.class, r10);
    }

    public static HashMapSupplier[] values() {
        return (HashMapSupplier[]) $VALUES.clone();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Map<Object, Object> call() {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Map<Object, Object> call2() {
        return new HashMap();
    }
}
