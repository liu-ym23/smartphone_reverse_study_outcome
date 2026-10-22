package com.bytedance.apm.k;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LinkedList<T> f1392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1393b;

    public a(int r2) {
        this.f1392a = new LinkedList();
        this.f1393b = r2;
    }

    public LinkedList<T> a() {
        return this.f1392a;
    }

    public void a(T r3) {
        if (this.f1392a.size() <= this.f1393b) goto L5;
        this.f1392a.removeFirst();
    L5:
        this.f1392a.addLast(r3);
    }
}
