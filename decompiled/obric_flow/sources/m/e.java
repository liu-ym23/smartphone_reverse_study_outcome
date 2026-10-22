package m;

import java.io.Serializable;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes3.dex */
public class e<K, V> implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<K, V> f19871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ReentrantReadWriteLock f19872b;

    public e() {
        this(new WeakHashMap());
    }

    public V a(K r5) {
        this.f19872b.readLock().lock();
        V r10 = this.f19871a.get(r5);     // Catch: Throwable -> L6
        this.f19872b.readLock().unlock();
        return r10;
    L6:
        th = move-exception;
        this.f19872b.readLock().unlock();
        throw th;
    }

    public e(Map<K, V> r5) {
        this.f19872b = new ReentrantReadWriteLock();
        this.f19871a = r5;
    }

    public V a(K r5, Supplier<V> r10) {
        V r11 = a(r5);
        if (r11 != null) goto L19;
        if (r10 == null) goto L19;
        this.f19872b.writeLock().lock();
        V r12 = this.f19871a.get(r5);     // Catch: Throwable -> L10
        if (r12 == null) goto L21;
    L15:
        this.f19872b.writeLock().unlock();
        return r12;
    L21:
        r12 = r10.get();     // Catch: Throwable -> L10 Exception -> L12
        this.f19871a.put(r5, r12);     // Catch: Throwable -> L10
        goto L15
    L12:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.f19872b.writeLock().unlock();
        throw th;
    L19:
        return r11;
    }
}
