package n;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class f<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashMap<K, V> f9375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f9378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9379e;

    public f(int r8) {
        if (r8 <= 0) goto L7;
        this.f9377c = r8;
        this.f9375a = new LinkedHashMap(0, 0.75f, true);
        return;
    L7:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final V a(K r8) {
        if (r8 == null) goto L17;
        monitor-enter(this);
        V r10 = this.f9375a.get(r8);     // Catch: Throwable -> L13
        if (r10 == null) goto L9;
        this.f9378d++;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r10;
    L9:
        this.f9379e++;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return null;
    L13:
        th = move-exception;
        throw th;
    L17:
        throw new NullPointerException("key == null");
    }

    public final V b(K r8, V r10) {
        if (r8 == null) goto L35;
        monitor-enter(this);
        this.f9376b++;     // Catch: Throwable -> L31
        V r11 = this.f9375a.put(r8, r10);     // Catch: Throwable -> L31
        if (r11 == null) goto L7;
        this.f9376b--;     // Catch: Throwable -> L31
    L7:
        monitor-exit(this);     // Catch: Throwable -> L31
        int r12 = this.f9377c;
    L9:
        monitor-enter(this);
    L28:
        th = move-exception;
        throw th;
    L11:
        if (this.f9376b < 0) goto L27;
        if (this.f9375a.isEmpty() == false) goto L17;
        if (this.f9376b != 0) goto L27;
    L17:
        if (this.f9376b <= r12) goto L24;
        if (this.f9375a.isEmpty() == true) goto L24;
        Map.Entry<K, V> r13 = this.f9375a.entrySet().iterator().next();     // Catch: Throwable -> L28
        K r14 = r13.getKey();     // Catch: Throwable -> L28
        r13.getValue();     // Catch: Throwable -> L28
        this.f9375a.remove(r14);     // Catch: Throwable -> L28
        this.f9376b--;     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
    L24:
        monitor-exit(this);     // Catch: Throwable -> L28
        return r11;
    L27:
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");     // Catch: Throwable -> L28
    L31:
        th = move-exception;
        throw th;
    L35:
        throw new NullPointerException("key == null || value == null");
    }

    public final synchronized String toString() {
        monitor-enter(this);
        int r8 = this.f9378d;     // Catch: Throwable -> L10
        int r10 = this.f9379e + r8;     // Catch: Throwable -> L10
        if (r10 == 0) goto L6;
        int r11 = (r8 * 100) / r10;     // Catch: Throwable -> L10
    L7:
        String r12 = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f9377c), Integer.valueOf(this.f9378d), Integer.valueOf(this.f9379e), Integer.valueOf(r11)});     // Catch: Throwable -> L10
        monitor-exit(this);
        return r12;
    L6:
        r11 = 0;
    L10:
        th = move-exception;
        throw th;
    }
}
