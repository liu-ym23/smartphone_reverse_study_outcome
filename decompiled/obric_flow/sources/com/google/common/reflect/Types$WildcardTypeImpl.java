package com.google.common.reflect;

import com.google.common.base.Optional;
import com.google.common.base.b0;
import com.google.common.base.z;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.e5;
import com.google.common.collect.ga;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
final class Types$WildcardTypeImpl implements WildcardType, Serializable {
    private static final long serialVersionUID = 0;
    private final ImmutableList<Type> lowerBounds;
    private final ImmutableList<Type> upperBounds;

    public Types$WildcardTypeImpl(Type[] r5, Type[] r10) {
        y.b(r5, "lower bound for wildcard");
        y.b(r10, "upper bound for wildcard");
        Types$JavaVersion r11 = Types$JavaVersion.CURRENT;
        this.lowerBounds = r11.usedInGenericType(r5);
        this.upperBounds = r11.usedInGenericType(r10);
    }

    public boolean equals(Object r5) {
        if ((r5 instanceof WildcardType) == false) goto L10;
        WildcardType r10 = (WildcardType) r5;
        if (this.lowerBounds.equals(Arrays.asList(r10.getLowerBounds())) == true) goto L7;
        return false;
    L7:
        if (this.upperBounds.equals(Arrays.asList(r10.getUpperBounds())) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() {
        ImmutableList<Type> r5 = this.lowerBounds;
        com.google.common.base.t r10 = y.f9380a;
        return (Type[]) r5.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() {
        ImmutableList<Type> r5 = this.upperBounds;
        com.google.common.base.t r10 = y.f9380a;
        return (Type[]) r5.toArray(new Type[0]);
    }

    public int hashCode() {
        int r5 = this.lowerBounds.hashCode();
        return this.upperBounds.hashCode() ^ r5;
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("?");
        ga r10 = this.lowerBounds.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Type r11 = (Type) r10.next();
        r5.append(" super ");
        r5.append(Types$JavaVersion.CURRENT.typeName(r11));
        goto L4
    L6:
        ImmutableList<Type> r12 = this.upperBounds;
        com.google.common.base.t r13 = y.f9380a;
        z r14 = b0.B(b0.x(Object.class));
        r12.getClass();
        Optional.absent();
        Iterator<Type> r15 = r12.iterator();
        r15.getClass();
        e5 r16 = new e5(r15, r14);
    L8:
        if (r16.hasNext() == false) goto L11;
        Type r17 = (Type) r16.next();
        r5.append(" extends ");
        r5.append(Types$JavaVersion.CURRENT.typeName(r17));
        goto L8
    L11:
        return r5.toString();
    }
}
