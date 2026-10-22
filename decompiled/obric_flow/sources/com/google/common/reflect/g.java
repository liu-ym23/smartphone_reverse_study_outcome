package com.google.common.reflect;

import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TypeVariable f9359a;

    public g(TypeVariable r5) {
        r5.getClass();
        this.f9359a = r5;
    }

    public final boolean a(TypeVariable r5) {
        TypeVariable r10 = this.f9359a;
        if (r10.getGenericDeclaration().equals(r5.getGenericDeclaration()) == true) goto L5;
    L7:
        return false;
    L5:
        if (r10.getName().equals(r5.getName()) == false) goto L7;
        return true;
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof g) == true) goto L5;
        return false;
    L5:
        return a(((g) r5).f9359a);
    }

    public final int hashCode() {
        TypeVariable r5 = this.f9359a;
        return Arrays.hashCode(new Object[]{r5.getGenericDeclaration(), r5.getName()});
    }

    public final String toString() {
        return this.f9359a.toString();
    }
}
