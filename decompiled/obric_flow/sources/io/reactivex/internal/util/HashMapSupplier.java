package io.reactivex.internal.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes3.dex */
public final enum HashMapSupplier extends Enum<HashMapSupplier> implements Callable<Map<Object, Object>> {
    public static final HashMapSupplier INSTANCE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HashMapSupplier[] f18166a = null;

    static {
        HashMapSupplier r5 = new HashMapSupplier("INSTANCE", 0);
        INSTANCE = r5;
        f18166a = new HashMapSupplier[]{r5};
    }

    public static <K, V> Callable<Map<K, V>> asCallable() {
        return INSTANCE;
    }

    public static HashMapSupplier valueOf(String r5) {
        return (HashMapSupplier) Enum.valueOf(HashMapSupplier.class, r5);
    }

    public static HashMapSupplier[] values() {
        return (HashMapSupplier[]) f18166a.clone();
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Map<Object, Object> call() throws Exception {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Map<Object, Object> call2() throws Exception {
        return new HashMap();
    }
}
