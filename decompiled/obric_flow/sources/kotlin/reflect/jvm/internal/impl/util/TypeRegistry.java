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
    private final ConcurrentHashMap<String, Integer> idPerType;

    public TypeRegistry() {
        this.idPerType = new ConcurrentHashMap();
        this.idCounter = new AtomicInteger(0);
    }

    public static final /* synthetic */ AtomicInteger access$getIdCounter$p(TypeRegistry r5) {
        return r5.idCounter;
    }

    public abstract int customComputeIfAbsent(ConcurrentHashMap<String, Integer> r5, String r10, Function1<? super String, Integer> r11);

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends V, KK extends K> NullableArrayMapAccessor<K, V, T> generateNullableAccessor(KClass<KK> r5) {
        Intrinsics.checkNotNullParameter(r5, "kClass");
        return new NullableArrayMapAccessor(r5, getId(r5));
    }

    public final <T extends K> int getId(KClass<T> r5) {
        Intrinsics.checkNotNullParameter(r5, "kClass");
        ConcurrentHashMap<String, Integer> r10 = this.idPerType;
        String r11 = r5.getQualifiedName();
        Intrinsics.checkNotNull(r11);
        return customComputeIfAbsent(r10, r11, new AnonymousClass1(this));
    }

    public final Collection<Integer> getIndices() {
        return this.idPerType.values();
    }
}
