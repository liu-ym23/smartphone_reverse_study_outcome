package com.bytedance.android.live.core.cache;

import android.util.Pair;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.common.utility.Lists;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.functions.Function4;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class i<K, V> implements a<K, V> {
    public final Function<K, Integer> a;
    public final BiFunction<K, List<V>, List<V>> b;
    public final Function4<K, List<V>, Integer, List<V>, List<V>> c;
    public final Map<Integer, List<V>> d;
    public final ConcurrentMap<Integer, PublishSubject<a.C0138a>> e;
    public final PublishSubject<Pair<K, a.C0138a>> f;

    public i() {
        this(new c(), new g(), new h());
    }

    @Override // com.bytedance.android.live.core.cache.a
    public final void clear() {
        ((ConcurrentHashMap) this.d).clear();
    }

    @Override // com.bytedance.android.live.core.cache.a
    public final void e(K r4) {
        int r5 = ((Integer) RxUtil.apply(this.a, r4)).intValue();
        Map<Integer, List<V>> r0 = this.d;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        if (r1.containsKey(Integer.valueOf(r5)) == true) goto L5;
        Map<Integer, List<V>> r2 = this.d;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        r3.put(Integer.valueOf(r5), new ArrayList());
    L5:
        Map<Integer, List<V>> r6 = this.d;
        ConcurrentHashMap r7 = (ConcurrentHashMap) r6;
        ((List) r7.get(Integer.valueOf(r5))).clear();
    }

    @Override // com.bytedance.android.live.core.cache.a
    public final List<V> get(K r4) {
        int r5 = ((Integer) RxUtil.apply(this.a, r4)).intValue();
        Map<Integer, List<V>> r0 = this.d;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        if (r1.containsKey(Integer.valueOf(r5)) == true) goto L5;
        Map<Integer, List<V>> r2 = this.d;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        r3.put(Integer.valueOf(r5), new ArrayList());
    L5:
        Map<Integer, List<V>> r6 = this.d;
        ConcurrentHashMap r7 = (ConcurrentHashMap) r6;
        return (List) r7.get(Integer.valueOf(r5));
    }

    @Override // com.bytedance.android.live.core.cache.a
    public final int size(K r4) {
        int r5 = ((Integer) RxUtil.apply(this.a, r4)).intValue();
        Map<Integer, List<V>> r0 = this.d;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        if (r1.containsKey(Integer.valueOf(r5)) == true) goto L5;
        Map<Integer, List<V>> r2 = this.d;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        r3.put(Integer.valueOf(r5), new ArrayList());
    L5:
        Map<Integer, List<V>> r6 = this.d;
        ConcurrentHashMap r7 = (ConcurrentHashMap) r6;
        return ((List) r7.get(Integer.valueOf(r5))).size();
    }

    @Override // com.bytedance.android.live.core.cache.a
    public final int a(K r4, V r5) {
        int r6 = ((Integer) RxUtil.apply(this.a, r4)).intValue();
        Map<Integer, List<V>> r0 = this.d;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        if (r1.containsKey(Integer.valueOf(r6)) == true) goto L5;
        Map<Integer, List<V>> r2 = this.d;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        r3.put(Integer.valueOf(r6), new ArrayList());
    L5:
        Map<Integer, List<V>> r7 = this.d;
        ConcurrentHashMap r8 = (ConcurrentHashMap) r7;
        return ((List) r8.get(Integer.valueOf(r6))).indexOf(r5);
    }

    @Override // com.bytedance.android.live.core.cache.a
    public final V c(K r4, j<V> r5) {
        int r6 = ((Integer) RxUtil.apply(this.a, r4)).intValue();
        Map<Integer, List<V>> r0 = this.d;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        if (r1.containsKey(Integer.valueOf(r6)) == true) goto L5;
        Map<Integer, List<V>> r2 = this.d;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        r3.put(Integer.valueOf(r6), new ArrayList());
    L5:
        Map<Integer, List<V>> r7 = this.d;
        ConcurrentHashMap r8 = (ConcurrentHashMap) r7;
        Iterator r9 = ((List) r8.get(Integer.valueOf(r6))).iterator();
    L7:
        if (r9.hasNext() == false) goto L14;
        V r11 = (V) r9.next();
        if (r5.test(r11) == false) goto L7;
        return r11;
    L12:
        e = move-exception;
        e.printStackTrace();
        goto L7
    L14:
        return null;
    }

    @Override // com.bytedance.android.live.core.cache.a
    public final List<V> d(K r5, List<V> r6) {
        int r0 = ((Integer) RxUtil.apply(this.a, r5)).intValue();
        Map<Integer, List<V>> r1 = this.d;
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
        if (r2.containsKey(Integer.valueOf(r0)) == true) goto L5;
        Map<Integer, List<V>> r3 = this.d;
        ConcurrentHashMap r4 = (ConcurrentHashMap) r3;
        r4.put(Integer.valueOf(r0), new ArrayList());
    L5:
        Map<Integer, List<V>> r7 = this.d;
        ConcurrentHashMap r8 = (ConcurrentHashMap) r7;
        return insert(r5, ((List) r8.get(Integer.valueOf(r0))).size(), r6);
    }

    @Override // com.bytedance.android.live.core.cache.a
    public void delete(K r5, V r6) {
        int r0 = ((Integer) RxUtil.apply(this.a, r5)).intValue();
        Map<Integer, List<V>> r1 = this.d;
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
        if (r2.containsKey(Integer.valueOf(r0)) == true) goto L5;
        Map<Integer, List<V>> r3 = this.d;
        ConcurrentHashMap r4 = (ConcurrentHashMap) r3;
        r4.put(Integer.valueOf(r0), new ArrayList());
    L5:
        Map<Integer, List<V>> r7 = this.d;
        ConcurrentHashMap r8 = (ConcurrentHashMap) r7;
        List r9 = (List) r8.get(Integer.valueOf(r0));
        r9.indexOf(r6);
        if (r9.remove(r6) == true) goto L8;
        return;
    L8:
        a.C0138a r11 = new a.C0138a(Collections.singletonList(r6));
        ConcurrentMap<Integer, PublishSubject<a.C0138a>> r12 = this.e;
        ConcurrentHashMap r13 = (ConcurrentHashMap) r12;
        if (r13.containsKey(Integer.valueOf(r0)) == false) goto L11;
        ConcurrentMap<Integer, PublishSubject<a.C0138a>> r14 = this.e;
        ConcurrentHashMap r15 = (ConcurrentHashMap) r14;
        ((PublishSubject) r15.get(Integer.valueOf(r0))).onNext(r11);
    L11:
        this.f.onNext(Pair.create(r5, r11));
    }

    @Override // com.bytedance.android.live.core.cache.a
    public final V get(K r4, int r5) {
        int r6 = ((Integer) RxUtil.apply(this.a, r4)).intValue();
        Map<Integer, List<V>> r0 = this.d;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        if (r1.containsKey(Integer.valueOf(r6)) == true) goto L5;
        Map<Integer, List<V>> r2 = this.d;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        r3.put(Integer.valueOf(r6), new ArrayList());
    L5:
        Map<Integer, List<V>> r7 = this.d;
        ConcurrentHashMap r8 = (ConcurrentHashMap) r7;
        List r9 = (List) r8.get(Integer.valueOf(r6));
        if (r5 >= 0) goto L8;
        return null;
    L8:
        if (r5 <= r9.size()) goto L11;
        return null;
    L11:
        return (V) ListProtector.get(r9, r5);
    }

    @Override // com.bytedance.android.live.core.cache.a
    public void delete(K r4, int r5) {
        int r6 = ((Integer) RxUtil.apply(this.a, r4)).intValue();
        Map<Integer, List<V>> r0 = this.d;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        if (r1.containsKey(Integer.valueOf(r6)) == true) goto L5;
        Map<Integer, List<V>> r2 = this.d;
        ConcurrentHashMap r3 = (ConcurrentHashMap) r2;
        r3.put(Integer.valueOf(r6), new ArrayList());
    L5:
        Map<Integer, List<V>> r7 = this.d;
        ConcurrentHashMap r8 = (ConcurrentHashMap) r7;
        List r9 = (List) r8.get(Integer.valueOf(r6));
        if (r5 >= 0) goto L8;
        return;
    L8:
        if (r5 > r9.size()) goto L16;
        Object r11 = ListProtector.remove(r9, r5);
        ConcurrentMap<Integer, PublishSubject<a.C0138a>> r12 = this.e;
        ConcurrentHashMap r13 = (ConcurrentHashMap) r12;
        if (r13.containsKey(Integer.valueOf(r6)) == false) goto L15;
        ConcurrentMap<Integer, PublishSubject<a.C0138a>> r14 = this.e;
        ConcurrentHashMap r15 = (ConcurrentHashMap) r14;
        ((PublishSubject) r15.get(Integer.valueOf(r6))).onNext(new a.C0138a(Collections.singletonList(r11)));
        return;
    L15:
        return;
    }

    public i(Function<K, Integer> r5, Function4<K, List<V>, Integer, List<V>, List<V>> r6, BiFunction<K, List<V>, List<V>> r7) {
        this.d = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap(20, 0.75f, 4);
        this.f = PublishSubject.create();
        this.a = r5;
        this.c = r6;
        this.b = r7;
    }

    @Override // com.bytedance.android.live.core.cache.a
    public final void b(K r5, int r6, V r7) {
        int r0 = ((Integer) RxUtil.apply(this.a, r5)).intValue();
        Map<Integer, List<V>> r1 = this.d;
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;
        if (r2.containsKey(Integer.valueOf(r0)) == true) goto L5;
        Map<Integer, List<V>> r3 = this.d;
        ConcurrentHashMap r4 = (ConcurrentHashMap) r3;
        r4.put(Integer.valueOf(r0), new ArrayList());
    L5:
        Map<Integer, List<V>> r8 = this.d;
        ConcurrentHashMap r9 = (ConcurrentHashMap) r8;
        List r11 = (List) r9.get(Integer.valueOf(r0));
        if (r6 >= 0) goto L8;
        return;
    L8:
        if (r6 > r11.size()) goto L16;
        ListProtector.set(r11, r6, r7);
        a.C0138a r12 = new a.C0138a(Collections.singletonList(r7));
        ConcurrentMap<Integer, PublishSubject<a.C0138a>> r13 = this.e;
        ConcurrentHashMap r14 = (ConcurrentHashMap) r13;
        if (r14.containsKey(Integer.valueOf(r0)) == false) goto L13;
        ConcurrentMap<Integer, PublishSubject<a.C0138a>> r15 = this.e;
        ConcurrentHashMap r16 = (ConcurrentHashMap) r15;
        ((PublishSubject) r16.get(Integer.valueOf(r0))).onNext(r12);
    L13:
        this.f.onNext(Pair.create(r5, r12));
        return;
    }

    @Override // com.bytedance.android.live.core.cache.a
    public synchronized List<V> insert(K r5, int r6, List<V> r7) {
        monitor-enter(this);
        int r0 = ((Integer) RxUtil.apply(this.a, r5)).intValue();     // Catch: Throwable -> L16
        Map<Integer, List<V>> r1 = this.d;     // Catch: Throwable -> L16
        ConcurrentHashMap r2 = (ConcurrentHashMap) r1;     // Catch: Throwable -> L16
        if (r2.containsKey(Integer.valueOf(r0)) == true) goto L6;
        Map<Integer, List<V>> r3 = this.d;     // Catch: Throwable -> L16
        ConcurrentHashMap r4 = (ConcurrentHashMap) r3;     // Catch: Throwable -> L16
        r4.put(Integer.valueOf(r0), new ArrayList());     // Catch: Throwable -> L16
    L6:
        List r8 = (List) RxUtil.apply(this.b, r5, r7);     // Catch: Throwable -> L16
        Map<Integer, List<V>> r9 = this.d;     // Catch: Throwable -> L16
        ConcurrentHashMap r11 = (ConcurrentHashMap) r9;     // Catch: Throwable -> L16
        List r12 = (List) r11.get(Integer.valueOf(r0));     // Catch: Throwable -> L16
        List<V> r13 = (List) RxUtil.apply(this.c, r5, r12, Integer.valueOf(r6), r8);     // Catch: Throwable -> L16
        if (Lists.isEmpty(r13) == false) goto L10;
        monitor-exit(this);
        return r13;
    L10:
        r12.addAll(Math.min(r6, r12.size()), r13);     // Catch: Throwable -> L16
        Map<Integer, List<V>> r14 = this.d;     // Catch: Throwable -> L16
        ConcurrentHashMap r15 = (ConcurrentHashMap) r14;     // Catch: Throwable -> L16
        r15.put(Integer.valueOf(r0), r12);     // Catch: Throwable -> L16
        a.C0138a r16 = new a.C0138a(r13);     // Catch: Throwable -> L16
        ConcurrentMap<Integer, PublishSubject<a.C0138a>> r17 = this.e;     // Catch: Throwable -> L16
        ConcurrentHashMap r18 = (ConcurrentHashMap) r17;     // Catch: Throwable -> L16
        if (r18.containsKey(Integer.valueOf(r0)) == false) goto L13;
        ConcurrentMap<Integer, PublishSubject<a.C0138a>> r19 = this.e;     // Catch: Throwable -> L16
        ConcurrentHashMap r21 = (ConcurrentHashMap) r19;     // Catch: Throwable -> L16
        ((PublishSubject) r21.get(Integer.valueOf(r0))).onNext(r16);     // Catch: Throwable -> L16
    L13:
        this.f.onNext(Pair.create(r5, r16));     // Catch: Throwable -> L16
        monitor-exit(this);
        return r13;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.live.core.cache.a
    public List<V> insert(K r2, int r3, V r4) {
        ArrayList r0 = new ArrayList();
        r0.add(r4);
        return insert(r2, r3, r0);
    }
}
