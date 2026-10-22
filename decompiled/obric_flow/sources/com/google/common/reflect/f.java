package com.google.common.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends sj.k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TypeVariable f9358c;
    public final /* synthetic */ sj.k d;

    public f(TypeVariable r5, sj.k r10) {
        this.f9358c = r5;
        this.d = r10;
        super(5);
    }

    @Override // sj.k
    public final Type n(TypeVariable r5, f r10) {
        if (r5.getGenericDeclaration().equals(this.f9358c.getGenericDeclaration()) == false) goto L6;
        return r5;
    L6:
        return this.d.n(r5, r10);
    }
}
