package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;

/* JADX INFO: loaded from: classes3.dex */
public interface JvmTypeFactory<T> {
    T boxType(T r10);

    T createFromString(String r10);

    T createObjectType(String r10);

    T createPrimitiveType(PrimitiveType r10);

    T getJavaLangClassType();

    String toString(T r10);
}
