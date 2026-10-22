package com.facebook.imagepipeline.memory;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes2.dex */
class Bucket<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8206a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8207b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList f8208c;
    public int d;

    public Bucket(int r5, int r10, int r11) {
        if (r5 <= 0) goto L13;
        if (r10 < 0) goto L11;
        if (r11 < 0) goto L9;
        this.f8206a = r5;
        this.f8207b = r10;
        this.f8208c = new LinkedList();
        this.d = r11;
        return;
    L9:
        throw new IllegalStateException();
    L11:
        throw new IllegalStateException();
    L13:
        throw new IllegalStateException();
    }

    public Object a() {
        return this.f8208c.poll();
    }

    public void a(Object r5) {
        this.f8208c.add(r5);
    }
}
