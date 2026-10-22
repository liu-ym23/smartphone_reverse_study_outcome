package com.bytedance.retrofit2;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class Utils$WildcardTypeImpl implements WildcardType {

    @Nullable
    private final Type lowerBound;
    private final Type upperBound;

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() {
        return new Type[]{this.upperBound};
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() {
        Type r0 = this.lowerBound;
        if (r0 == null) goto L6;
        return new Type[]{r0};
    L6:
        return Utils.EMPTY_TYPE_ARRAY;
    }

    public int hashCode() {
        Type r0 = this.lowerBound;
        if (r0 == null) goto L5;
        int r1 = r0.hashCode() + 31;
    L7:
        return r1 ^ (this.upperBound.hashCode() + 31);
    L5:
        r1 = 1;
        goto L7
    }

    public String toString() {
        if (this.lowerBound == null) goto L7;
        return "? super " + Utils.typeToString(this.lowerBound);
    L7:
        if (this.upperBound != Object.class) goto L11;
        return "?";
    L11:
        return "? extends " + Utils.typeToString(this.upperBound);
    }

    public boolean equals(Object r2) {
        if ((r2 instanceof WildcardType) == true) goto L5;
    L7:
        return false;
    L5:
        if (Utils.equals(this, (WildcardType) r2) == false) goto L7;
        return true;
    }

    public Utils$WildcardTypeImpl(Type[] r5, Type[] r6) {
        if (r6.length > 1) goto L24;
        if (r5.length != 1) goto L22;
        if (r6.length != 1) goto L16;
        Type r0 = r6[0];
        if (r0 == null) goto L15;
        Utils.checkNotPrimitive(r0);
        if (r5[0] != Object.class) goto L14;
        this.lowerBound = r6[0];
        this.upperBound = Object.class;
        return;
    L14:
        throw new IllegalArgumentException();
    L15:
        throw null;
    L16:
        Type r7 = r5[0];
        if (r7 == null) goto L20;
        Utils.checkNotPrimitive(r7);
        this.lowerBound = null;
        this.upperBound = r5[0];
        return;
    L20:
        throw null;
    L22:
        throw new IllegalArgumentException();
    L24:
        throw new IllegalArgumentException();
    }
}
