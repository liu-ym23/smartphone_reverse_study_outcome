package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.types.TypeAttribute;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TypeAttribute<T extends TypeAttribute<T>> {
    public TypeAttribute() {
    }

    public abstract T add(T r10);

    public abstract KClass<? extends T> getKey();

    public abstract T intersect(T r10);
}
