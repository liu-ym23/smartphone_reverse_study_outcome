package com.google.common.collect;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o7 extends AbstractMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient Set f9106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient Set f9107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient Collection f9108c;

    public abstract Set a();

    public Set b() {
        return new a9(this);
    }

    public Collection c() {
        return new q6(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set r5 = this.f9106a;
        if (r5 != null) goto L6;
        Set r10 = a();
        this.f9106a = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set r5 = this.f9107b;
        if (r5 != null) goto L6;
        Set r10 = b();
        this.f9107b = r10;
        return r10;
    L6:
        return r5;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection r5 = this.f9108c;
        if (r5 != null) goto L6;
        Collection r10 = c();
        this.f9108c = r10;
        return r10;
    L6:
        return r5;
    }
}
