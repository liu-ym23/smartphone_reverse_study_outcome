package ai;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 implements WildcardType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Type f303b;

    public v0(Type[] r5, Type[] r10) {
        if (r10.length > 1) goto L18;
        if (r5.length != 1) goto L16;
        if (r10.length != 1) goto L13;
        r10[0].getClass();
        w0.c(r10[0]);
        if (r5[0] != Object.class) goto L12;
        this.f303b = r10[0];
        this.f302a = Object.class;
        return;
    L12:
        throw new IllegalArgumentException();
    L13:
        r5[0].getClass();
        w0.c(r5[0]);
        this.f303b = null;
        this.f302a = r5[0];
        return;
    L16:
        throw new IllegalArgumentException();
    L18:
        throw new IllegalArgumentException();
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof WildcardType) == true) goto L5;
    L7:
        return false;
    L5:
        if (w0.d(this, (WildcardType) r5) == false) goto L7;
        return true;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type r5 = this.f303b;
        if (r5 == null) goto L6;
        return new Type[]{r5};
    L6:
        return w0.f305a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.f302a};
    }

    public final int hashCode() {
        Type r5 = this.f303b;
        if (r5 == null) goto L5;
        int r10 = r5.hashCode() + 31;
    L7:
        return (this.f302a.hashCode() + 31) ^ r10;
    L5:
        r10 = 1;
        goto L7
    }

    public final String toString() {
        Type r5 = this.f303b;
        if (r5 != null) goto L5;
        Type r10 = this.f302a;
        if (r10 != Object.class) goto L11;
        return "?";
    L11:
        return "? extends " + w0.k(r10);
    L5:
        return "? super " + w0.k(r5);
    }
}
