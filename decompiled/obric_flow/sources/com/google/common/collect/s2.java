package com.google.common.collect;

import com.google.common.base.Optional;

/* JADX INFO: loaded from: classes2.dex */
public abstract class s2 implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Optional f9155a;

    public s2() {
        this.f9155a = Optional.absent();
    }

    public static s2 b(Iterable r5) {
        if ((r5 instanceof s2) == false) goto L6;
        return (s2) r5;
    L6:
        return new r2(r5, r5);
    }

    public final String toString() {
        return p7.u0((Iterable) this.f9155a.or(this));
    }

    public s2(Iterable r5) {
        this.f9155a = Optional.of(r5);
    }
}
