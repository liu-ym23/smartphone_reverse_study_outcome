package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends i implements Iterable<i> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ArrayList<i> f4213c;

    public f() {
        this.f4213c = new ArrayList();
    }

    private i n() {
        int r10 = this.f4213c.size();
        if (r10 != 1) goto L7;
        return this.f4213c.get(0);
    L7:
        throw new IllegalStateException("Array must have size 1, but has size " + r10);
    }

    @Override // com.google.gson.i
    public boolean a() {
        return n().a();
    }

    @Override // com.google.gson.i
    public double b() {
        return n().b();
    }

    @Override // com.google.gson.i
    public int c() {
        return n().c();
    }

    public boolean equals(Object r10) {
        if (r10 != this) goto L4;
    L9:
        return true;
    L4:
        if ((r10 instanceof f) == true) goto L6;
    L8:
        return false;
    L6:
        if (((f) r10).f4213c.equals(this.f4213c) == false) goto L8;
        goto L8
    }

    @Override // com.google.gson.i
    public long g() {
        return n().g();
    }

    @Override // com.google.gson.i
    public String h() {
        return n().h();
    }

    public int hashCode() {
        return this.f4213c.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<i> iterator() {
        return this.f4213c.iterator();
    }

    public void m(i r10) {
        if (r10 != null) goto L4;
        r10 = j.f4273a;
    L4:
        this.f4213c.add(r10);
    }
}
