package com.bytedance.frameworks.baselib.network.http.util;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class e<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<K, V> f1873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f1874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f1875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f1876d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f1877e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1878f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f1879g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f1880h;

    public e(int r10) {
        if (r10 <= 0) goto L7;
        this.f1875c = r10;
        this.f1873a = Collections.synchronizedMap(new LinkedHashMap(0, 0.75f, true));
        return;
    L7:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int h(K r10, V r11) {
        int r12 = j(r10, r11);
        if (r12 < 0) goto L6;
        return r12;
    L6:
        throw new IllegalStateException("Negative size: " + r10 + "=" + r11);
    }

    private void k(int r10) {
    L3:
        if (this.f1874b <= r10) goto L11;
        if (this.f1873a.isEmpty() == true) goto L11;
        Map.Entry<K, V> r11 = this.f1873a.entrySet().iterator().next();
        if (r11 == null) goto L11;
        K r12 = r11.getKey();
        V r13 = r11.getValue();
        this.f1873a.remove(r12);
        this.f1874b -= h(r12, r13);
        this.f1878f++;
        b(r12, r13);
    L11:
        if (this.f1874b < 0) goto L18;
        if (this.f1873a.isEmpty() == true) goto L15;
        return;
    L15:
        if (this.f1874b != 0) goto L18;
        return;
    L18:
        throw new IllegalStateException(e.class.getName() + ".sizeOf() is reporting inconsistent results!");
    }

    protected V a(K r10) {
        return null;
    }

    protected void b(K r10, V r11) {
    }

    public final synchronized void c() {
        monitor-enter(this);
        k(-1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized V d(K r10) {
        monitor-enter(this);
        if (r10 == null) goto L17;
        V r11 = this.f1873a.get(r10);     // Catch: Throwable -> L14
        if (r11 == null) goto L9;
        this.f1879g++;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r11;
    L9:
        this.f1880h++;     // Catch: Throwable -> L14
        V r12 = a(r10);     // Catch: Throwable -> L14
        if (r12 == null) goto L12;
        this.f1877e++;     // Catch: Throwable -> L14
        this.f1874b += h(r10, r12);     // Catch: Throwable -> L14
        this.f1873a.put(r10, r12);     // Catch: Throwable -> L14
        k(this.f1875c);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return r12;
    L17:
        throw new NullPointerException("key == null");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public synchronized Map<K, V> e() {
        monitor-enter(this);
        Map<K, V> r10 = this.f1873a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized V f(K r10, V r11) {
        monitor-enter(this);
        if (r10 == null) goto L12;
        if (r11 == null) goto L12;
        this.f1876d++;     // Catch: Throwable -> L13
        this.f1874b += h(r10, r11);     // Catch: Throwable -> L13
        V r12 = this.f1873a.put(r10, r11);     // Catch: Throwable -> L13
        if (r12 == null) goto L8;
        this.f1874b -= h(r10, r12);     // Catch: Throwable -> L13
    L8:
        k(this.f1875c);     // Catch: Throwable -> L13
        monitor-exit(this);
        return r12;
    L12:
        throw new NullPointerException("key == null || value == null");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized V g(K r10) {
        monitor-enter(this);
        if (r10 == null) goto L12;
        V r11 = this.f1873a.remove(r10);     // Catch: Throwable -> L9
        if (r11 == null) goto L7;
        this.f1874b -= h(r10, r11);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return r11;
    L12:
        throw new NullPointerException("key == null");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized int i() {
        monitor-enter(this);
        int r10 = this.f1874b;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    protected int j(K r10, V r11) {
        return 1;
    }

    public final synchronized String toString() {
        monitor-enter(this);
        int r10 = this.f1879g;     // Catch: Throwable -> L10
        int r11 = this.f1880h + r10;     // Catch: Throwable -> L10
        if (r11 == 0) goto L6;
        int r12 = (r10 * 100) / r11;     // Catch: Throwable -> L10
    L7:
        String r13 = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f1875c), Integer.valueOf(this.f1879g), Integer.valueOf(this.f1880h), Integer.valueOf(r12)});     // Catch: Throwable -> L10
        monitor-exit(this);
        return r13;
    L6:
        r12 = 0;
    L10:
        th = move-exception;
        throw th;
    }
}
