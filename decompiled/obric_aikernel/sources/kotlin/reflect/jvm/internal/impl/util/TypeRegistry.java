package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeRegistry<K, V> {
    private final AtomicInteger idCounter;
    private final ConcurrentHashMap<KClass<? extends K>, Integer> idPerType;

    public TypeRegistry() {
        this.idPerType = new ConcurrentHashMap();
        this.idCounter = new AtomicInteger(0);
    }

    public static final /* synthetic */ AtomicInteger access$getIdCounter$p(TypeRegistry r10) {
        return r10.idCounter;
    }

    public abstract <T extends K> int customComputeIfAbsent(ConcurrentHashMap<KClass<? extends K>, Integer> r10, KClass<T> r11, Function1<? super KClass<? extends K>, Integer> r12);

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends V, KK extends K> NullableArrayMapAccessor<K, V, T> generateNullableAccessor(KClass<KK> r10) {
        Intrinsics.checkNotNullParameter(r10, "kClass");
        return new NullableArrayMapAccessor(r10, getId(r10));
    }

    public final <T extends K> int getId(KClass<T> r10) {
        Intrinsics.checkNotNullParameter(r10, "kClass");
        return customComputeIfAbsent(this.idPerType, r10, new AnonymousClass1(this));
    }

    protected final Collection<Integer> getIndices() {
        Collection<Integer> r10 = this.idPerType.values();
        Intrinsics.checkNotNullExpressionValue(r10, "idPerType.values");
        return r10;
    }
}
