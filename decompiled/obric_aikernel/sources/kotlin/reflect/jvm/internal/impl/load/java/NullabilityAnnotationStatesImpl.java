package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;

/* JADX INFO: loaded from: classes3.dex */
public final class NullabilityAnnotationStatesImpl<T> implements NullabilityAnnotationStates<T> {
    private final MemoizedFunctionToNullable<FqName, T> cache;
    private final Map<FqName, T> states;
    private final LockBasedStorageManager storageManager;

    /* JADX WARN: Multi-variable type inference failed */
    public NullabilityAnnotationStatesImpl(Map<FqName, ? extends T> r10) {
        Intrinsics.checkNotNullParameter(r10, "states");
        this.states = r10;
        LockBasedStorageManager r11 = new LockBasedStorageManager("Java nullability annotation states");
        this.storageManager = r11;
        MemoizedFunctionToNullable<FqName, T> r12 = r11.createMemoizedFunctionWithNullableValues(new NullabilityAnnotationStatesImpl$cache$1(this));
        Intrinsics.checkNotNullExpressionValue(r12, "storageManager.createMem…cificFqname(states)\n    }");
        this.cache = r12;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates
    public T get(FqName r10) {
        Intrinsics.checkNotNullParameter(r10, "fqName");
        return this.cache.invoke(r10);
    }

    public final Map<FqName, T> getStates() {
        return this.states;
    }
}
