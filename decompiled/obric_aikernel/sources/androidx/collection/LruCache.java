package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

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

    public LruCache(int r10) {
        if (r10 <= 0) goto L7;
        this.maxSize = r10;
        this.map = new LinkedHashMap(0, 0.75f, true);
        return;
    L7:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int safeSizeOf(K r10, V r11) {
        int r12 = sizeOf(r10, r11);
        if (r12 < 0) goto L6;
        return r12;
    L6:
        throw new IllegalStateException("Negative size: " + r10 + "=" + r11);
    }

    @Nullable
    protected V create(@NonNull K r10) {
        return null;
    }

    public final synchronized int createCount() {
        monitor-enter(this);
        int r10 = this.createCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    protected void entryRemoved(boolean r10, @NonNull K r11, @NonNull V r12, @Nullable V r13) {
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int evictionCount() {
        monitor-enter(this);
        int r10 = this.evictionCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public final V get(@NonNull K r10) {
        Objects.requireNonNull(r10, "key == null");
        monitor-enter(this);
        V r11 = this.map.get(r10);     // Catch: Throwable -> L29
        if (r11 == null) goto L9;
        this.hitCount++;     // Catch: Throwable -> L29
        monitor-exit(this);     // Catch: Throwable -> L29
        return r11;
    L9:
        this.missCount++;     // Catch: Throwable -> L29
        monitor-exit(this);     // Catch: Throwable -> L29
        V r12 = create(r10);
        if (r12 != null) goto L15;
        return null;
    L15:
        monitor-enter(this);
        this.createCount++;     // Catch: Throwable -> L26
        V r13 = this.map.put(r10, r12);     // Catch: Throwable -> L26
        if (r13 == null) goto L19;
        this.map.put(r10, r13);     // Catch: Throwable -> L26
    L20:
        monitor-exit(this);     // Catch: Throwable -> L26
        if (r13 == null) goto L24;
        entryRemoved(false, r10, r12, r13);
        return r13;
    L24:
        trimToSize(this.maxSize);
        return r12;
    L19:
        this.size += safeSizeOf(r10, r12);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    L29:
        th = move-exception;
        throw th;
    }

    public final synchronized int hitCount() {
        monitor-enter(this);
        int r10 = this.hitCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int maxSize() {
        monitor-enter(this);
        int r10 = this.maxSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized int missCount() {
        monitor-enter(this);
        int r10 = this.missCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public final V put(@NonNull K r10, @NonNull V r11) {
        if (r10 == null) goto L17;
        if (r11 == null) goto L17;
        monitor-enter(this);
        this.putCount++;     // Catch: Throwable -> L13
        this.size += safeSizeOf(r10, r11);     // Catch: Throwable -> L13
        V r12 = this.map.put(r10, r11);     // Catch: Throwable -> L13
        if (r12 == null) goto L8;
        this.size -= safeSizeOf(r10, r12);     // Catch: Throwable -> L13
    L8:
        monitor-exit(this);     // Catch: Throwable -> L13
        if (r12 == null) goto L11;
        entryRemoved(false, r10, r12, r11);
    L11:
        trimToSize(this.maxSize);
        return r12;
    L13:
        th = move-exception;
        throw th;
    L17:
        throw new NullPointerException("key == null || value == null");
    }

    public final synchronized int putCount() {
        monitor-enter(this);
        int r10 = this.putCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    @Nullable
    public final V remove(@NonNull K r10) {
        Objects.requireNonNull(r10, "key == null");
        monitor-enter(this);
        V r11 = this.map.remove(r10);     // Catch: Throwable -> L11
        if (r11 == null) goto L7;
        this.size -= safeSizeOf(r10, r11);     // Catch: Throwable -> L11
    L7:
        monitor-exit(this);     // Catch: Throwable -> L11
        if (r11 == null) goto L10;
        entryRemoved(false, r10, r11, null);
    L10:
        return r11;
    L11:
        th = move-exception;
        throw th;
    }

    public void resize(int r10) {
        if (r10 <= 0) goto L12;
        monitor-enter(this);
        this.maxSize = r10;     // Catch: Throwable -> L8
        monitor-exit(this);     // Catch: Throwable -> L8
        trimToSize(r10);
        return;
    L8:
        th = move-exception;
        throw th;
    L12:
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public final synchronized int size() {
        monitor-enter(this);
        int r10 = this.size;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    protected int sizeOf(@NonNull K r10, @NonNull V r11) {
        return 1;
    }

    public final synchronized Map<K, V> snapshot() {
        monitor-enter(this);
        LinkedHashMap r10 = new LinkedHashMap(this.map);     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized String toString() {
        monitor-enter(this);
        int r10 = this.hitCount;     // Catch: Throwable -> L10
        int r11 = this.missCount + r10;     // Catch: Throwable -> L10
        if (r11 == 0) goto L6;
        int r12 = (r10 * 100) / r11;     // Catch: Throwable -> L10
    L7:
        String r13 = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(r12)});     // Catch: Throwable -> L10
        monitor-exit(this);
        return r13;
    L6:
        r12 = 0;
    L10:
        th = move-exception;
        throw th;
    }

    public void trimToSize(int r10) {
    L2:
        monitor-enter(this);
    L21:
        th = move-exception;
        throw th;
    L4:
        if (this.size < 0) goto L20;
        if (this.map.isEmpty() == false) goto L10;
        if (this.size != 0) goto L20;
    L10:
        if (this.size <= r10) goto L17;
        if (this.map.isEmpty() == true) goto L17;
        Map.Entry<K, V> r11 = this.map.entrySet().iterator().next();     // Catch: Throwable -> L21
        K r12 = r11.getKey();     // Catch: Throwable -> L21
        V r13 = r11.getValue();     // Catch: Throwable -> L21
        this.map.remove(r12);     // Catch: Throwable -> L21
        this.size -= safeSizeOf(r12, r13);     // Catch: Throwable -> L21
        this.evictionCount++;     // Catch: Throwable -> L21
        monitor-exit(this);     // Catch: Throwable -> L21
        entryRemoved(true, r12, r13, null);
    L17:
        monitor-exit(this);     // Catch: Throwable -> L21
        return;
    L20:
        throw new IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");     // Catch: Throwable -> L21
    }
}
