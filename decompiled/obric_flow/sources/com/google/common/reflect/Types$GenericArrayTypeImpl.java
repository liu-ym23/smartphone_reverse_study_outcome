package com.google.common.reflect;

import com.google.common.base.b0;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
final class Types$GenericArrayTypeImpl implements GenericArrayType, Serializable {
    private static final long serialVersionUID = 0;
    private final Type componentType;

    public Types$GenericArrayTypeImpl(Type r5) {
        this.componentType = Types$JavaVersion.CURRENT.usedInGenericType(r5);
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof GenericArrayType) == true) goto L5;
        return false;
    L5:
        return b0.w(getGenericComponentType(), ((GenericArrayType) r5).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.componentType;
    }

    public int hashCode() {
        return this.componentType.hashCode();
    }

    public String toString() {
        Type r5 = this.componentType;
        com.google.common.base.t r10 = y.f9380a;
        if ((r5 instanceof Class) == false) goto L5;
        String r11 = ((Class) r5).getName();
    L7:
        return String.valueOf(r11).concat("[]");
    L5:
        r11 = r5.toString();
        goto L7
    }
}
