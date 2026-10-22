package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class NullabilityAnnotationStatesImpl<T> implements NullabilityAnnotationStates<T> {
    private final MemoizedFunctionToNullable<FqName, T> cache;
    private final Map<FqName, T> states;
    private final LockBasedStorageManager storageManager;

    public static /* synthetic */ Object accessor$NullabilityAnnotationStatesImpl$lambda0(NullabilityAnnotationStatesImpl r0, FqName r1) {
        return cache$lambda$0(r0, r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public NullabilityAnnotationStatesImpl(Map<FqName, ? extends T> r2) {
        Intrinsics.checkNotNullParameter(r2, "states");
        this.states = r2;
        LockBasedStorageManager r3 = new LockBasedStorageManager("Java nullability annotation states");
        this.storageManager = r3;
        this.cache = r3.createMemoizedFunctionWithNullableValues(new NullabilityAnnotationStatesImpl$$Lambda$0(this));
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.NullabilityAnnotationStates
    public T get(FqName r2) {
        Intrinsics.checkNotNullParameter(r2, "fqName");
        return (T) this.cache.invoke(r2);
    }

    private static final Object cache$lambda$0(NullabilityAnnotationStatesImpl r1, FqName r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNull(r2);
        return FqNamesUtilKt.findValueForMostSpecificFqname(r2, r1.states);
    }
}
