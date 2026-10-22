package com.bytedance.android.live.core.cache;

import android.util.Pair;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import io.reactivex.Observable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function3;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f<K, V> implements Cache<K, V> {
    public final Function<K, Integer> a;
    public final BiFunction<K, V, Boolean> b;
    public final Function3<K, V, Long, Boolean> c;
    public final BiFunction<V, V, V> d;
    public final Map<Integer, Pair<V, Long>> e;
    public final ConcurrentMap<Integer, Subject<V>> f;

    public f() {
        BiFunction<K, V, Boolean> r0 = new b();
        c r1 = new c();
        Function3<K, V, Long, Boolean> r2 = new d();
        BiFunction<V, V, V> r3 = new e();
        this.e = new ConcurrentHashMap();
        this.f = new ConcurrentHashMap(20, 0.75f, 4);
        this.a = r1;
        this.b = r0;
        this.c = r2;
        this.d = r3;
    }

    @Override // com.bytedance.android.live.core.cache.Cache
    public final void clear() {
        ((ConcurrentHashMap) this.e).clear();
    }

    @Override // com.bytedance.android.live.core.cache.Cache
    public void delete(K r3) {
        Map<Integer, Pair<V, Long>> r0 = this.e;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        r1.remove(RxUtil.apply(this.a, r3));
    }

    @Override // com.bytedance.android.live.core.cache.Cache
    public final V get(K r5) {
        Map<Integer, Pair<V, Long>> r0 = this.e;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        Pair r2 = (Pair) r1.get(RxUtil.apply(this.a, r5));
        if (r2 != null) goto L5;
        return null;
    L5:
        if (((Boolean) RxUtil.apply(this.c, r5, r2.first, (Long) r2.second)).booleanValue() == false) goto L7;
        return null;
    L7:
        return (V) r2.first;
    }

    @Override // com.bytedance.android.live.core.cache.Cache
    public final Observable<V> observe(K r4) {
        int r5 = ((Integer) RxUtil.apply(this.a, r4)).intValue();
        ConcurrentMap<Integer, Subject<V>> r0 = this.f;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        r1.putIfAbsent(Integer.valueOf(r5), PublishSubject.create());
        ConcurrentMap<Integer, Subject<V>> r2 = this.f;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        return (Observable) r3.get(Integer.valueOf(r5));
    }

    @Override // com.bytedance.android.live.core.cache.Cache
    public final void put(K r6, V r7) {
        if (((Boolean) RxUtil.apply(this.b, r6, r7)).booleanValue() == false) goto L5;
        return;
    L5:
        int r0 = ((Integer) RxUtil.apply(this.a, r6)).intValue();
        Map<Integer, Pair<V, Long>> r1 = this.e;
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
        Pair r3 = (Pair) r2.get(Integer.valueOf(r0));
        if (r3 != null) goto L8;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == false) goto L15;
        return;
    L15:
        Map<Integer, Pair<V, Long>> r8 = this.e;
        ConcurrentHashMap r9 = (ConcurrentHashMap) r8;
        r9.put(Integer.valueOf(r0), new Pair(r7, Long.valueOf(System.currentTimeMillis())));
        ConcurrentMap<Integer, Subject<V>> r11 = this.f;
        ConcurrentHashMap r12 = (ConcurrentHashMap) r11;
        if (r12.containsKey(Integer.valueOf(r0)) == false) goto L19;
        ConcurrentMap<Integer, Subject<V>> r13 = this.f;
        ConcurrentHashMap r14 = (ConcurrentHashMap) r13;
        ((Subject) r14.get(Integer.valueOf(r0))).onNext(r7);
        return;
    L19:
        return;
    L8:
        if (((Boolean) RxUtil.apply(this.c, r6, r3.first, (Long) r3.second)).booleanValue() == true) goto L12;
        Map<Integer, Pair<V, Long>> r15 = this.e;
        ConcurrentHashMap r16 = (ConcurrentHashMap) r15;
        Object r17 = ((Pair) r16.get(Integer.valueOf(r0))).first;
        r4 = r7.equals(r17);
        if (r4 == true) goto L13;
        r7 = (V) RxUtil.apply(this.d, r17, r7);
        r4 = r7.equals(r17);
        goto L13
    }
}
