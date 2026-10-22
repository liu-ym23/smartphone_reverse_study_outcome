package akc;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class c<K, V> implements Map<K, V>, KMutableMap {
    public final Map<K, V> a;
    public final Object b;

    public c() {
        HashMap r0 = new HashMap();
        Intrinsics.checkNotNullParameter(r0, "delegate");
        this.a = r0;
        this.b = new Object();
    }

    @Override // java.util.Map
    public final void clear() {
        Object r0 = this.b;
        monitor-enter(r0);
        this.a.clear();     // Catch: Throwable -> L7
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        Object r0 = this.b;
        monitor-enter(r0);
        d r1 = new d(this.a.entrySet(), this.b);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        Object r0 = this.b;
        monitor-enter(r0);
        boolean r1 = this.a.isEmpty();     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final Set<K> keySet() {
        Object r0 = this.b;
        monitor-enter(r0);
        d r1 = new d(this.a.keySet(), this.b);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final int size() {
        Object r0 = this.b;
        monitor-enter(r0);
        int r1 = this.a.size();     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final Collection<V> values() {
        Object r0 = this.b;
        monitor-enter(r0);
        a r1 = new a(this.a.values(), this.b);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object r3) {
        Object r0 = this.b;
        monitor-enter(r0);
        boolean r4 = this.a.containsKey(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object r3) {
        Object r0 = this.b;
        monitor-enter(r0);
        boolean r4 = this.a.containsValue(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final V get(Object r3) {
        Object r0 = this.b;
        monitor-enter(r0);
        V r4 = this.a.get(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final void putAll(Map<? extends K, ? extends V> r3) {
        Intrinsics.checkNotNullParameter(r3, "from");
        Object r0 = this.b;
        monitor-enter(r0);
        this.a.putAll(r3);     // Catch: Throwable -> L7
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final V remove(Object r3) {
        Object r0 = this.b;
        monitor-enter(r0);
        V r4 = this.a.remove(r3);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.util.Map
    public final V put(K r3, V r4) {
        Object r0 = this.b;
        monitor-enter(r0);
        V r5 = this.a.put(r3, r4);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return r5;
    L7:
        th = move-exception;
        throw th;
    }
}
