package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;

/* JADX INFO: loaded from: classes3.dex */
public interface JvmTypeFactory<T> {
    T boxType(T r5);

    T createFromString(String r5);

    T createObjectType(String r5);

    T createPrimitiveType(PrimitiveType r5);

    T getJavaLangClassType();

    String toString(T r5);
}
