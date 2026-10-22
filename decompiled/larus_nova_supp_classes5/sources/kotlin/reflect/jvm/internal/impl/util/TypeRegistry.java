package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class TypeRegistry<K, V> {
    private final AtomicInteger idCounter;
    private final ConcurrentHashMap<String, Integer> idPerType;

    public static /* synthetic */ int accessor$TypeRegistry$lambda0(TypeRegistry r0, String r1) {
        return getId$lambda$0(r0, r1);
    }

    public abstract int customComputeIfAbsent(ConcurrentHashMap<String, Integer> r1, String r2, Function1<? super String, Integer> r3);

    public final Collection<Integer> getIndices() {
        return this.idPerType.values();
    }

    public TypeRegistry() {
        this.idPerType = new ConcurrentHashMap();
        this.idCounter = new AtomicInteger(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends V, KK extends K> NullableArrayMapAccessor<K, V, T> generateNullableAccessor(KClass<KK> r2) {
        Intrinsics.checkNotNullParameter(r2, "kClass");
        return new NullableArrayMapAccessor(getId(r2));
    }

    public final int getId(String r3) {
        Intrinsics.checkNotNullParameter(r3, "keyQualifiedName");
        return customComputeIfAbsent(this.idPerType, r3, new TypeRegistry$.Lambda.0(this));
    }

    public final <T extends K> int getId(KClass<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "kClass");
        String r3 = r2.getQualifiedName();
        Intrinsics.checkNotNull(r3);
        return getId(r3);
    }

    private static final int getId$lambda$0(TypeRegistry r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "it");
        return r1.idCounter.getAndIncrement();
    }
}
