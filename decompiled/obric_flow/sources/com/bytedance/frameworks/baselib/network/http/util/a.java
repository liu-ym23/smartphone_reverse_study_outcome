package com.bytedance.frameworks.baselib.network.http.util;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f4689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f4691c;
    public int d;
    public int e;

    public a(int r5) {
        if (r5 <= 0) goto L7;
        this.f4691c = r5;
        this.f4689a = Collections.synchronizedMap(new LinkedHashMap(0, 0.75f, true));
        return;
    L7:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final synchronized Object a(String r5) {
        monitor-enter(this);
        if (r5 == null) goto L16;
        Object r10 = this.f4689a.get(r5);     // Catch: Throwable -> L9
        if (r10 == null) goto L11;
        this.d++;     // Catch: Throwable -> L9
        monitor-exit(this);
        return r10;
    L11:
        this.e++;     // Catch: Throwable -> L9
        monitor-exit(this);
        return null;
    L16:
        throw new NullPointerException("key == null");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(String r5, Object r10) {
        monitor-enter(this);
        if (r5 == null) goto L13;
        this.f4690b++;     // Catch: Throwable -> L7
        if (this.f4689a.put(r5, r10) == null) goto L9;
        this.f4690b--;     // Catch: Throwable -> L7
    L9:
        c(this.f4691c);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L13:
        throw new NullPointerException("key == null || value == null");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    public final void c(int r5) {
    L2:
        int r10 = this.f4690b;
        Map r11 = this.f4689a;
        if (r10 <= r5) goto L11;
        if (r11.isEmpty() == true) goto L11;
        Map.Entry r12 = (Map.Entry) r11.entrySet().iterator().next();
        if (r12 == null) goto L11;
        Object r13 = r12.getKey();
        r12.getValue();
        r11.remove(r13);
        this.f4690b--;
    L11:
        if (this.f4690b < 0) goto L18;
        if (r11.isEmpty() == true) goto L15;
        return;
    L15:
        if (this.f4690b != 0) goto L18;
        return;
    L18:
        throw new IllegalStateException(a.class.getName().concat(".sizeOf() is reporting inconsistent results!"));
    }

    public final synchronized String toString() {
        monitor-enter(this);
        int r5 = this.d;     // Catch: Throwable -> L6
        int r10 = this.e + r5;     // Catch: Throwable -> L6
        if (r10 == 0) goto L8;
        int r11 = (r5 * 100) / r10;     // Catch: Throwable -> L6
    L9:
        String r12 = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f4691c), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(r11)});     // Catch: Throwable -> L6
        monitor-exit(this);
        return r12;
    L8:
        r11 = 0;
    L6:
        th = move-exception;
        throw th;
    }
}
