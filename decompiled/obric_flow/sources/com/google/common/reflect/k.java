package com.google.common.reflect;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ TypeToken f9364c;

    public k(TypeToken r5, Method r10) {
        this.f9364c = r5;
        super(r10);
    }

    @Override // com.google.common.reflect.a
    public final TypeToken a() {
        return this.f9364c;
    }

    public final String toString() {
        String r5 = String.valueOf(this.f9364c);
        String r10 = this.f9355b.toString();
        return androidx.room.jarjarred.org.antlr.runtime.a.m(androidx.room.jarjarred.org.antlr.runtime.a.g(r5.length() + 1, r10), r5, ".", r10);
    }
}
