package com.google.common.reflect;

import com.google.common.base.b0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.a5;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes2.dex */
final class Types$ParameterizedTypeImpl implements ParameterizedType, Serializable {
    private static final long serialVersionUID = 0;
    private final ImmutableList<Type> argumentsList;
    private final Type ownerType;
    private final Class<?> rawType;

    public Types$ParameterizedTypeImpl(Type r5, Class<?> r10, Type[] r11) {
        r10.getClass();
        if (r11.length != r10.getTypeParameters().length) goto L5;
        boolean r12 = true;
    L6:
        b0.i(r12);
        y.b(r11, "type parameter");
        this.ownerType = r5;
        this.rawType = r10;
        this.argumentsList = Types$JavaVersion.CURRENT.usedInGenericType(r11);
        return;
    L5:
        r12 = false;
        goto L6
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof ParameterizedType) == true) goto L5;
        return false;
    L5:
        ParameterizedType r10 = (ParameterizedType) r5;
        if (getRawType().equals(r10.getRawType()) == true) goto L8;
        return false;
    L8:
        if (b0.w(getOwnerType(), r10.getOwnerType()) == true) goto L10;
        return false;
    L10:
        if (Arrays.equals(getActualTypeArguments(), r10.getActualTypeArguments()) == false) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        ImmutableList<Type> r5 = this.argumentsList;
        com.google.common.base.t r10 = y.f9380a;
        return (Type[]) r5.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.ownerType;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.rawType;
    }

    public int hashCode() {
        Type r5 = this.ownerType;
        if (r5 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = r10 ^ this.argumentsList.hashCode();
        return this.rawType.hashCode() ^ r11;
    L5:
        r10 = r5.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder();
        if (this.ownerType == null) goto L7;
        Types$JavaVersion r10 = Types$JavaVersion.CURRENT;
        if (r10.jdkTypeDuplicatesOwnerName() == false) goto L7;
        r5.append(r10.typeName(this.ownerType));
        r5.append('.');
    L7:
        r5.append(this.rawType.getName());
        r5.append(Typography.less);
        com.google.common.base.t r11 = y.f9380a;
        ImmutableList<Type> r12 = this.argumentsList;
        final Types$JavaVersion r13 = Types$JavaVersion.CURRENT;
        Objects.requireNonNull(r13);
        com.google.common.base.q r14 = new v(r13);
        r12.getClass();
        r5.append(r11.a(new a5(r12, r14, 1)));
        r5.append(Typography.greater);
        return r5.toString();
    }
}
