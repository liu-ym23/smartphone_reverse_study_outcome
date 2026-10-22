package com.bytedance.retrofit2;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class Utils$GenericArrayTypeImpl implements GenericArrayType {
    private final Type componentType;

    public int hashCode() {
        return this.componentType.hashCode();
    }

    public String toString() {
        return Utils.typeToString(this.componentType) + "[]";
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.componentType;
    }

    public Utils$GenericArrayTypeImpl(Type r1) {
        this.componentType = r1;
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof GenericArrayType) == true) goto L5;
    L7:
        return false;
    L5:
        if (Utils.equals(this, (GenericArrayType) r2) == false) goto L7;
        return true;
    }
}
