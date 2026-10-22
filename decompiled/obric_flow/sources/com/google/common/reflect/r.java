package com.google.common.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends um.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f9372c;

    public r(AtomicReference r5) {
        this.f9372c = r5;
        super(4);
    }

    @Override // um.a
    public final void A(Class r5) {
        this.f9372c.set(r5.getComponentType());
    }

    @Override // um.a
    public final void B(GenericArrayType r5) {
        this.f9372c.set(r5.getGenericComponentType());
    }

    @Override // um.a
    public final void D(TypeVariable r5) {
        Type r10 = y.a(r5.getBounds());
        this.f9372c.set(r10);
    }

    @Override // um.a
    public final void E(WildcardType r5) {
        Type r10 = y.a(r5.getUpperBounds());
        this.f9372c.set(r10);
    }
}
