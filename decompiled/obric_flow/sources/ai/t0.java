package ai;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public final class t0 implements GenericArrayType {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f296a;

    public t0(Type r5) {
        this.f296a = r5;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof GenericArrayType) == true) goto L5;
    L7:
        return false;
    L5:
        if (w0.d(this, (GenericArrayType) r5) == false) goto L7;
        return true;
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f296a;
    }

    public final int hashCode() {
        return this.f296a.hashCode();
    }

    public final String toString() {
        return w0.k(this.f296a) + "[]";
    }
}
