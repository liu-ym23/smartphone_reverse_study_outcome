package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int r5) {
        if (r5 <= 0) goto L7;
        this.maxSize = r5;
        this.map = new LinkedHashMap(0, 0.75f, true);
        return;
    L7:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int safeSizeOf(K r5, V r10) {
        int r11 = sizeOf(r5, r10);
        if (r11 < 0) goto L6;
        return r11;
    L6:
        throw new IllegalStateException("Negative size: " + r5 + "=" + r10);
    }

    @Nullable
    public V create(@NonNull K r5) {
        return null;
    }

    public final synchronized int createCount() {
        monitor-enter(this);
        int r5 = this.createCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public void entryRemoved(boolean r5, @NonNull K r10, @NonNull V r11, @Nullable V r12) {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int evictionCount() {
        monitor-enter(this);
        int r5 = this.evictionCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public final V get(@NonNull K r5) {
        if (r5 == null) goto L35;
        monitor-enter(this);
        V r10 = this.map.get(r5);     // Catch: Throwable -> L9
        if (r10 == null) goto L11;
        this.hitCount++;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        return r10;
    L11:
        this.missCount++;     // Catch: Throwable -> L9
        monitor-exit(this);     // Catch: Throwable -> L9
        V r11 = create(r5);
        if (r11 != null) goto L17;
        return null;
    L17:
        monitor-enter(this);
        this.createCount++;     // Catch: Throwable -> L21
        V r12 = this.map.put(r5, r11);     // Catch: Throwable -> L21
        if (r12 == null) goto L23;
        this.map.put(r5, r12);     // Catch: Throwable -> L21
    L24:
        monitor-exit(this);     // Catch: Throwable -> L21
        if (r12 == null) goto L28;
        entryRemoved(false, r5, r11, r12);
        return r12;
    L28:
        trimToSize(this.maxSize);
        return r11;
    L23:
        this.size += safeSizeOf(r5, r11);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        throw th;
    L35:
        throw new NullPointerException("key == null");
    }

    public final synchronized int hitCount() {
        monitor-enter(this);
        int r5 = this.hitCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int maxSize() {
        monitor-enter(this);
        int r5 = this.maxSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int missCount() {
        monitor-enter(this);
        int r5 = this.missCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public final V put(@NonNull K r5, @NonNull V r10) {
        if (r5 == null) goto L18;
        if (r10 == null) goto L18;
        monitor-enter(this);
        this.putCount++;     // Catch: Throwable -> L8
        this.size += safeSizeOf(r5, r10);     // Catch: Throwable -> L8
        V r11 = this.map.put(r5, r10);     // Catch: Throwable -> L8
        if (r11 == null) goto L10;
        this.size -= safeSizeOf(r5, r11);     // Catch: Throwable -> L8
    L10:
        monitor-exit(this);     // Catch: Throwable -> L8
        if (r11 == null) goto L13;
        entryRemoved(false, r5, r11, r10);
    L13:
        trimToSize(this.maxSize);
        return r11;
    L8:
        th = move-exception;
        throw th;
    L18:
        throw new NullPointerException("key == null || value == null");
    }

    public final synchronized int putCount() {
        monitor-enter(this);
        int r5 = this.putCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public final V remove(@NonNull K r5) {
        if (r5 == null) goto L16;
        monitor-enter(this);
        V r10 = this.map.remove(r5);     // Catch: Throwable -> L7
        if (r10 == null) goto L9;
        this.size -= safeSizeOf(r5, r10);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r10 == null) goto L12;
        entryRemoved(false, r5, r10, null);
    L12:
        return r10;
    L7:
        th = move-exception;
        throw th;
    L16:
        throw new NullPointerException("key == null");
    }

    public void resize(int r5) {
        if (r5 <= 0) goto L12;
        monitor-enter(this);
        this.maxSize = r5;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        trimToSize(r5);
        return;
    L8:
        th = move-exception;
        throw th;
    L12:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final synchronized int size() {
        monitor-enter(this);
        int r5 = this.size;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public int sizeOf(@NonNull K r5, @NonNull V r10) {
        return 1;
    }

    public final synchronized Map<K, V> snapshot() {
        monitor-enter(this);
        LinkedHashMap r5 = new LinkedHashMap(this.map);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r5;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized String toString() {
        monitor-enter(this);
        int r5 = this.hitCount;     // Catch: Throwable -> L7
        int r10 = this.missCount + r5;     // Catch: Throwable -> L7
        if (r10 == 0) goto L9;
        int r11 = (r5 * 100) / r10;     // Catch: Throwable -> L7
    L10:
        Locale r12 = Locale.US;     // Catch: Throwable -> L7
        String r13 = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + r11 + "%]";     // Catch: Throwable -> L7
        monitor-exit(this);
        return r13;
    L9:
        r11 = 0;
    L7:
        th = move-exception;
        throw th;
    }

    public void trimToSize(int r5) {
    L2:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.size < 0) goto L23;
        if (this.map.isEmpty() == false) goto L13;
        if (this.size != 0) goto L23;
    L13:
        if (this.size <= r5) goto L20;
        if (this.map.isEmpty() == true) goto L20;
        Map.Entry<K, V> r10 = this.map.entrySet().iterator().next();     // Catch: Throwable -> L10
        K r11 = r10.getKey();     // Catch: Throwable -> L10
        V r12 = r10.getValue();     // Catch: Throwable -> L10
        this.map.remove(r11);     // Catch: Throwable -> L10
        this.size -= safeSizeOf(r11, r12);     // Catch: Throwable -> L10
        this.evictionCount++;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        entryRemoved(true, r11, r12, null);
    L20:
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L23:
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");     // Catch: Throwable -> L10
    }
}
