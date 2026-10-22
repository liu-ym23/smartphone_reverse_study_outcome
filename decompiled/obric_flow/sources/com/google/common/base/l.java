package com.google.common.base;

import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class l implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Iterable f8663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f8664b;

    public l(m r5, Iterable r10) {
        this.f8664b = r5;
        this.f8663a = r10;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new k(this);
    }
}
