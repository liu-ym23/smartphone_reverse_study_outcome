package com.bytedance.frameworks.baselib.network.http.util;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<K, V> f2542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2543b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public e(int r4) {
        if (r4 <= 0) goto L7;
        this.c = r4;
        this.f2542a = Collections.synchronizedMap(new LinkedHashMap(0, 0.75f, true));
        return;
    L7:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void a(int r5) {
    L3:
        if (this.f2543b <= r5) goto L11;
        if (this.f2542a.isEmpty() == true) goto L11;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(this.f2542a.entrySet().iterator().next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L11;
        Object r1 = r0.getKey();
        Object r2 = r0.getValue();
        this.f2542a.remove(r1);
        this.f2543b -= d(r1, r2);
        this.f++;
        b(r1, r2);
    L11:
        if (this.f2543b < 0) goto L18;
        if (this.f2542a.isEmpty() == true) goto L15;
        return;
    L15:
        if (this.f2543b != 0) goto L18;
        return;
    L18:
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
    }

    private int d(K r3, V r4) {
        int r2 = c(r3, r4);
        if (r2 < 0) goto L6;
        return r2;
    L6:
        throw new IllegalStateException("Negative size: " + r3 + "=" + r4);
    }

    public final synchronized V a(K r4) {
        monitor-enter(this);
        if (r4 == null) goto L17;
        V r0 = this.f2542a.get(r4);     // Catch: Throwable -> L14
        if (r0 == null) goto L9;
        this.g++;     // Catch: Throwable -> L14
        monitor-exit(this);
        return r0;
    L9:
        this.h++;     // Catch: Throwable -> L14
        V r1 = c(r4);     // Catch: Throwable -> L14
        if (r1 == null) goto L12;
        this.e++;     // Catch: Throwable -> L14
        this.f2543b += d(r4, r1);     // Catch: Throwable -> L14
        this.f2542a.put(r4, r1);     // Catch: Throwable -> L14
        a(this.c);     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);
        return r1;
    L17:
        throw new NullPointerException("key == null");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized V a(K r3, V r4) {
        monitor-enter(this);
        if (r3 == null) goto L12;
        if (r4 == null) goto L12;
        this.d++;     // Catch: Throwable -> L13
        this.f2543b += d(r3, r4);     // Catch: Throwable -> L13
        V r5 = this.f2542a.put(r3, r4);     // Catch: Throwable -> L13
        if (r5 == null) goto L8;
        this.f2543b -= d(r3, r5);     // Catch: Throwable -> L13
    L8:
        a(this.c);     // Catch: Throwable -> L13
        monitor-exit(this);
        return r5;
    L12:
        throw new NullPointerException("key == null || value == null");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized void a() {
        monitor-enter(this);
        a(-1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized V b(K r3) {
        monitor-enter(this);
        if (r3 == null) goto L12;
        V r0 = this.f2542a.remove(r3);     // Catch: Throwable -> L9
        if (r0 == null) goto L7;
        this.f2543b -= d(r3, r0);     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return r0;
    L12:
        throw new NullPointerException("key == null");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized Map<K, V> b() {
        monitor-enter(this);
        Map<K, V> r0 = this.f2542a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void b(K r1, V r2) {
    }

    public int c(K r1, V r2) {
        return 1;
    }

    public V c(K r1) {
        return null;
    }

    public final synchronized String toString() {
        monitor-enter(this);
        int r0 = this.g;     // Catch: Throwable -> L10
        int r1 = this.h + r0;     // Catch: Throwable -> L10
        if (r1 == 0) goto L6;
        int r2 = (r0 * 100) / r1;     // Catch: Throwable -> L10
    L7:
        String r3 = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.c), Integer.valueOf(this.g), Integer.valueOf(this.h), Integer.valueOf(r2)});     // Catch: Throwable -> L10
        monitor-exit(this);
        return r3;
    L6:
        r2 = 0;
    L10:
        th = move-exception;
        throw th;
    }
}
