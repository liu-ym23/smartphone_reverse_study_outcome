package io.reactivex.internal.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes6.dex */
public final enum HashMapSupplier extends Enum<HashMapSupplier> implements Callable<Map<Object, Object>> {
    private static final /* synthetic */ HashMapSupplier[] $VALUES = null;
    public static final HashMapSupplier INSTANCE = null;

    static {
        HashMapSupplier r0 = new HashMapSupplier("INSTANCE", 0);
        INSTANCE = r0;
        $VALUES = new HashMapSupplier[]{r0};
    }

    private HashMapSupplier(String r1, int r2) {
        super(r1, r2);
    }

    public static <K, V> Callable<Map<K, V>> asCallable() {
        return INSTANCE;
    }

    public static HashMapSupplier valueOf(String r2) {
        return (HashMapSupplier) ZeusTransformUtils.preCheckCast(Enum.valueOf(HashMapSupplier.class, r2), HashMapSupplier.class, "com.obric.memorydata.plugin");
    }

    public static HashMapSupplier[] values() {
        return (HashMapSupplier[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), HashMapSupplier[].class, "com.obric.memorydata.plugin");
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
