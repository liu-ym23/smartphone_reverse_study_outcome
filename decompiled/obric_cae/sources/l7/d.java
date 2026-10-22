package l7;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class d<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<K, V> f9166a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9167b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9168c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9169d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9170e;

    public d(int r8) {
        if (r8 <= 0) goto L7;
        this.f9168c = r8;
        this.f9166a = Collections.synchronizedMap(new LinkedHashMap(0, 0.75f, true));
        return;
    L7:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final synchronized void a() {
        monitor-enter(this);
        e(-1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final synchronized V b(K r8) {
        monitor-enter(this);
        if (r8 == null) goto L14;
        V r10 = this.f9166a.get(r8);     // Catch: Throwable -> L15
        if (r10 == null) goto L9;
        this.f9169d++;     // Catch: Throwable -> L15
        monitor-exit(this);
        return r10;
    L9:
        this.f9170e++;     // Catch: Throwable -> L15
        monitor-exit(this);
        return null;
    L14:
        throw new NullPointerException("key == null");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized Map<K, V> c() {
        monitor-enter(this);
        Map<K, V> r8 = this.f9166a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r8;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized void d(Object r8, Object r10) {
        monitor-enter(this);
        if (r8 == null) goto L12;
        if (r10 == null) goto L12;
        this.f9167b++;     // Catch: Throwable -> L13
        if (this.f9166a.put(r8, r10) == null) goto L8;
        this.f9167b--;     // Catch: Throwable -> L13
    L8:
        e(this.f9168c);     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L12:
        throw new NullPointerException("key == null || value == null");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final void e(int r8) {
    L2:
        int r10 = this.f9167b;
        Map<K, V> r11 = this.f9166a;
        if (r10 <= r8) goto L11;
        if (r11.isEmpty() == true) goto L11;
        Map.Entry<K, V> r12 = r11.entrySet().iterator().next();
        if (r12 == null) goto L11;
        K r13 = r12.getKey();
        r12.getValue();
        r11.remove(r13);
        this.f9167b--;
    L11:
        if (this.f9167b < 0) goto L18;
        if (r11.isEmpty() == true) goto L15;
        return;
    L15:
        if (this.f9167b != 0) goto L18;
        return;
    L18:
        throw new IllegalStateException(d.class.getName().concat(".sizeOf() is reporting inconsistent results!"));
    }

    public final synchronized String toString() {
        monitor-enter(this);
        int r8 = this.f9169d;     // Catch: Throwable -> L10
        int r10 = this.f9170e + r8;     // Catch: Throwable -> L10
        if (r10 == 0) goto L6;
        int r11 = (r8 * 100) / r10;     // Catch: Throwable -> L10
    L7:
        String r12 = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f9168c), Integer.valueOf(this.f9169d), Integer.valueOf(this.f9170e), Integer.valueOf(r11)});     // Catch: Throwable -> L10
        monitor-exit(this);
        return r12;
    L6:
        r11 = 0;
    L10:
        th = move-exception;
        throw th;
    }
}
