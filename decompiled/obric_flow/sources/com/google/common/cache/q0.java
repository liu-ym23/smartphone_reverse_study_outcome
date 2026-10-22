package com.google.common.cache;

import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import com.google.common.collect.p7;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public final class q0 extends AbstractMap implements ConcurrentMap {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Logger f8742v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final n f8743w = null;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final o f8744x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f8745a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8746b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LocalCache$Segment[] f8747c;
    public final int d;
    public final com.google.common.base.p e;
    public final com.google.common.base.p f;
    public final LocalCache$Strength g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final LocalCache$Strength f8748h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f8749i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final z0 f8750j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f8751k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f8752l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final AbstractQueue f8753m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final w0 f8754n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final com.google.common.base.h0 f8755o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final LocalCache$EntryFactory f8756p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f8757q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final h f8758r;
    public w s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public h0 f8759t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public w f8760u;

    static {
        f8742v = Logger.getLogger(q0.class.getName());
        f8743w = new n();
        f8744x = new o();
    }

    public q0(f r19, h r20) {
        int r5 = r19.f8706b;
        if (r5 != (-1)) goto L5;
        r5 = 4;
    L5:
        this.d = Math.min(r5, 65536);
        LocalCache$Strength r10 = r19.f;
        LocalCache$Strength r11 = LocalCache$Strength.STRONG;
        LocalCache$Strength r12 = (LocalCache$Strength) com.google.common.base.b0.y(r10, r11);
        this.g = r12;
        this.f8748h = (LocalCache$Strength) com.google.common.base.b0.y(r19.g, r11);
        this.e = (com.google.common.base.p) com.google.common.base.b0.y(r19.f8710j, ((LocalCache$Strength) com.google.common.base.b0.y(r19.f, r11)).defaultEquivalence());
        this.f = (com.google.common.base.p) com.google.common.base.b0.y(r19.f8711k, ((LocalCache$Strength) com.google.common.base.b0.y(r19.g, r11)).defaultEquivalence());
        long r13 = 0;
        if (r19.f8708h != 0) goto L8;
    L14:
        long r14 = 0;
    L15:
        this.f8749i = r14;
        z0 r15 = r19.e;
        CacheBuilder$OneWeigher r16 = CacheBuilder$OneWeigher.INSTANCE;
        z0 r17 = (z0) com.google.common.base.b0.y(r15, r16);
        this.f8750j = r17;
        long r18 = r19.f8709i;
        if (r18 != (-1)) goto L18;
        r18 = 0;
    L18:
        this.f8751k = r18;
        long r21 = r19.f8708h;
        if (r21 == (-1)) goto L22;
        r13 = r21;
    L22:
        this.f8752l = r13;
        w0 r22 = r19.f8712l;
        CacheBuilder$NullListener r23 = CacheBuilder$NullListener.INSTANCE;
        w0 r24 = (w0) com.google.common.base.b0.y(r22, r23);
        this.f8754n = r24;
        if (r24 != r23) goto L25;
        AbstractQueue r25 = f8744x;
    L26:
        this.f8753m = r25;
        int r26 = 0;
        if (d() == false) goto L29;
    L32:
        boolean r27 = true;
    L33:
        com.google.common.base.h0 r110 = r19.f8713m;
        if (r110 != null) goto L40;
        if (r27 == false) goto L39;
        com.google.common.base.h0 r28 = com.google.common.base.h0.f8659a;
    L38:
        r110 = r28;
        goto L40
    L39:
        r28 = f.f8703q;
    L40:
        this.f8755o = r110;
        if (c() == false) goto L43;
    L49:
        boolean r29 = true;
    L51:
        if (d() == false) goto L53;
    L56:
        boolean r111 = true;
    L57:
        this.f8756p = LocalCache$EntryFactory.getFactory(r12, r29, r111);
        com.google.common.base.e0 r112 = r19.f8714n;
        this.f8757q = (b) r112.get();
        this.f8758r = r20;
        int r30 = Math.min(16, BasicMeasure.EXACTLY);
        if (b() == false) goto L62;
        if (r17 != r16) goto L62;
        r30 = (int) Math.min(r30, r14);
    L62:
        int r31 = 1;
        int r32 = 0;
    L64:
        if (r31 >= this.d) goto L70;
        if (b() == false) goto L69;
        if ((r31 * 20) > this.f8749i) goto L70;
    L69:
        r32 = r32 + 1;
        r31 = r31 << 1;
    L70:
        this.f8746b = 32 - r32;
        this.f8745a = r31 - 1;
        this.f8747c = new LocalCache$Segment[r31];
        int r33 = r30 / r31;
        if ((r33 * r31) >= r30) goto L73;
        r33 = r33 + 1;
    L73:
        int r34 = 1;
    L74:
        if (r34 >= r33) goto L77;
        r34 = r34 << 1;
        goto L74
    L77:
        if (b() == false) goto L85;
        long r35 = this.f8749i;
        long r36 = r31;
        long r37 = (r35 / r36) + 1;
        long r113 = r35 % r36;
    L79:
        LocalCache$Segment[] r38 = this.f8747c;
        if (r26 >= r38.length) goto L88;
        if (r26 != r113) goto L84;
        r37 = r37 - 1;
    L84:
        long r114 = r37;
        r38[r26] = new LocalCache$Segment(this, r34, r114, (b) r112.get());
        r26 = r26 + 1;
        r37 = r114;
        goto L79
    L88:
        return;
    L85:
        LocalCache$Segment[] r39 = this.f8747c;
        if (r26 >= r39.length) goto L98;
        r39[r26] = new LocalCache$Segment(this, r34, -1, (b) r112.get());
        r26 = r26 + 1;
        goto L85
    L98:
        return;
    L53:
        if (d() == true) goto L56;
        r111 = false;
        goto L57
    L43:
        if (b() == true) goto L49;
        if (c() == true) goto L49;
        r29 = false;
        goto L51
    L29:
        if (c() == true) goto L32;
        r27 = false;
        goto L33
    L25:
        r25 = new ConcurrentLinkedQueue();
        goto L26
    L8:
        if (r19.f8709i == 0) goto L14;
        if (r19.e != null) goto L13;
        r14 = r19.f8707c;
        goto L15
    L13:
        r14 = r19.d;
        goto L15
    }

    public static ArrayList a(AbstractCollection r5) {
        ArrayList r10 = new ArrayList(r5.size());
        p7.j(r10, r5.iterator());
        return r10;
    }

    public final boolean b() {
        if (this.f8749i < 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean c() {
        if (this.f8751k <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        LocalCache$Segment[] r5 = this.f8747c;
        int r10 = r5.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        r5[r11].clear();
        r11 = r11 + 1;
        goto L3
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object compute(Object r5, BiFunction r10) {
        r5.getClass();
        r10.getClass();
        int r11 = e(r5);
        return i(r11).compute(r5, r11, r10);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object computeIfAbsent(Object r5, Function r10) {
        r5.getClass();
        r10.getClass();
        return compute(r5, new l(r5, r10));
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object computeIfPresent(Object r5, BiFunction r10) {
        r5.getClass();
        r10.getClass();
        return compute(r5, new m(r10, 0));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object r5) {
        if (r5 != null) goto L5;
        return false;
    L5:
        int r10 = e(r5);
        return i(r10).containsKey(r5, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object r20) {
        boolean r5 = false;
        if (r20 != null) goto L5;
        return false;
    L5:
        long r10 = this.f8755o.a();
        LocalCache$Segment[] r11 = this.f8747c;
        long r12 = -1;
        int r13 = 0;
    L7:
        if (r13 >= 3) goto L29;
        int r14 = r11.length;
        long r15 = 0;
        ?? r16 = r5;
    L9:
        if (r16 >= r14) goto L24;
        LocalCache$Segment r17 = r11[r16];
        int r18 = r17.count;
        AtomicReferenceArray<v0> r19 = r17.table;
        ?? r110 = r5;
    L12:
        if (r110 >= r19.length()) goto L23;
        v0 r21 = r19.get(r110);
    L14:
        if (r21 == null) goto L22;
        LocalCache$Segment[] r111 = r11;
        Object r22 = r17.getLiveValue(r21, r10);
        long r112 = r10;
        if (r22 == null) goto L21;
        if (this.f.equivalent(r20, r22) == false) goto L21;
        return true;
    L21:
        r21 = r21.getNext();
        r11 = r111;
        r10 = r112;
        goto L14
    L22:
        r110 = r110 + 1;
        goto L12
    L23:
        r15 = r15 + ((long) r17.modCount);
        r10 = r10;
        r5 = false;
        r16 = r16 + 1;
        goto L9
    L24:
        long r113 = r10;
        LocalCache$Segment[] r114 = r11;
        if (r15 == r12) goto L26;
        r13 = r13 + 1;
        r12 = r15;
        r11 = r114;
        r10 = r113;
        r5 = false;
        goto L7
    L26:
        return false;
    L29:
        return r5;
    }

    public final boolean d() {
        if (this.f8752l <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final int e(Object r5) {
        int r10 = this.e.hash(r5);
        int r11 = r10 + ((r10 << 15) ^ (-12931));
        int r12 = r11 ^ (r11 >>> 10);
        int r13 = r12 + (r12 << 3);
        int r14 = r13 ^ (r13 >>> 6);
        int r15 = ((r14 << 2) + (r14 << 14)) + r14;
        return (r15 >>> 16) ^ r15;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        w r5 = this.f8760u;
        if (r5 != null) goto L7;
        w r10 = new w(this, 0);
        this.f8760u = r10;
        return r10;
    L7:
        return r5;
    }

    public final boolean f(v0 r10, long r11) {
        r10.getClass();
        if (c() == false) goto L8;
        if ((r11 - r10.getAccessTime()) < this.f8751k) goto L8;
        return true;
    L8:
        if (d() == true) goto L10;
        return false;
    L10:
        if ((r11 - r10.getWriteTime()) < this.f8752l) goto L14;
        return true;
    L14:
        return false;
    }

    public final Map g(Set r10, h r11) {
        boolean r5 = false;
        b r12 = this.f8757q;
        r11.getClass();
        r10.getClass();
        com.google.common.base.b0.u(!false, "This stopwatch is already running.");
        com.bytedance.sdk.xbridge.cn.auth.g r13 = com.google.common.base.y.f8677a;
        long r14 = System.nanoTime();
        Map<Object, Object> r15 = r11.loadAll(r10);     // Catch: Throwable -> L21 Error -> L23 Exception -> L26 RuntimeException -> L29 InterruptedException -> L32 CacheLoader$UnsupportedLoadingOperationException -> L35
        if (r15 == null) goto L19;
        com.bytedance.sdk.xbridge.cn.auth.g r16 = com.google.common.base.y.f8677a;
        long r17 = (System.nanoTime() - r14) + 0;
        Iterator<Map.Entry<Object, Object>> r18 = r15.entrySet().iterator();
    L7:
        if (r18.hasNext() == false) goto L14;
        Map.Entry<Object, Object> r19 = r18.next();
        Object r20 = r19.getKey();
        Object r21 = r19.getValue();
        if (r20 == null) goto L13;
        if (r21 == null) goto L13;
        put(r20, r21);
    L13:
        r5 = true;
        goto L7
    L14:
        if (r5 == true) goto L17;
        TimeUnit r22 = TimeUnit.NANOSECONDS;
        r12.e(r22.convert(r17, r22));
        return r15;
    L17:
        TimeUnit r23 = TimeUnit.NANOSECONDS;
        r12.d(r23.convert(r17, r23));
        String r110 = String.valueOf(r11);
        throw new CacheLoader$InvalidCacheLoadException(androidx.room.jarjarred.org.antlr.runtime.a.l(r110.length() + 42, r110, " returned null keys or values from loadAll"));
    L19:
        TimeUnit r24 = TimeUnit.NANOSECONDS;
        com.bytedance.sdk.xbridge.cn.auth.g r111 = com.google.common.base.y.f8677a;
        r12.d(r24.convert((System.nanoTime() - r14) + 0, r24));
        String r112 = String.valueOf(r11);
        throw new CacheLoader$InvalidCacheLoadException(androidx.room.jarjarred.org.antlr.runtime.a.l(r112.length() + 31, r112, " returned null map from loadAll"));
    L21:
        th = th;
    L39:
        if (r5 == true) goto L41;
        TimeUnit r113 = TimeUnit.NANOSECONDS;
        com.bytedance.sdk.xbridge.cn.auth.g r114 = com.google.common.base.y.f8677a;
        r12.d(r113.convert((System.nanoTime() - r14) + 0, r113));
    L41:
        throw th;
    L29:
        e = move-exception;
        throw new UncheckedExecutionException(e);     // Catch: Throwable -> L21
    L23:
        e = move-exception;
        throw new ExecutionError(e);     // Catch: Throwable -> L21
    L32:
        e = move-exception;
        Thread.currentThread().interrupt();     // Catch: Throwable -> L21
        throw new ExecutionException(e);     // Catch: Throwable -> L21
    L35:
        e = move-exception;
        throw e;     // Catch: Throwable -> L37
    L37:
        th = th;
        r5 = true;
    L26:
        e = move-exception;
        throw new ExecutionException(e);     // Catch: Throwable -> L21
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r10 = e(r5);
        return i(r10).get(r5, r10);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object getOrDefault(Object r5, Object r10) {
        Object r11 = get(r5);
        if (r11 != null) goto L5;
        return r10;
    L5:
        return r11;
    }

    public final boolean h(BiPredicate r10) {
        Iterator r5 = ((w) keySet()).iterator();
        boolean r11 = false;
    L4:
        if (r5.hasNext() == false) goto L14;
        Object r12 = r5.next();
    L6:
        Object r13 = get(r12);
        if (r13 == null) goto L4;
        if (r10.test(r12, r13) == false) goto L4;
        if (remove(r12, r13) == false) goto L6;
        r11 = true;
        goto L4
    L14:
        return r11;
    }

    public final LocalCache$Segment i(int r5) {
        int r10 = (r5 >>> this.f8746b) & this.f8745a;
        return this.f8747c[r10];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        LocalCache$Segment[] r10 = this.f8747c;
        long r5 = 0;
        int r11 = 0;
    L4:
        if (r11 >= r10.length) goto L10;
        if (r10[r11].count != 0) goto L7;
        r5 = r5 + ((long) r10[r11].modCount);
        r11 = r11 + 1;
        goto L4
    L7:
        return false;
    L10:
        if (r5 == 0) goto L22;
        int r12 = 0;
    L13:
        if (r12 >= r10.length) goto L19;
        if (r10[r12].count != 0) goto L16;
        r5 = r5 - ((long) r10[r12].modCount);
        r12 = r12 + 1;
        goto L13
    L16:
        return false;
    L19:
        if (r5 == 0) goto L21;
        return false;
    L21:
        return true;
    L22:
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        w r5 = this.s;
        if (r5 != null) goto L7;
        w r10 = new w(this, 1);
        this.s = r10;
        return r10;
    L7:
        return r5;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object merge(Object r5, Object r10, BiFunction r11) {
        r5.getClass();
        r10.getClass();
        r11.getClass();
        return compute(r5, new l(0, r10, r11));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object r5, Object r10) {
        r5.getClass();
        r10.getClass();
        int r11 = e(r5);
        return i(r11).put(r5, r11, r10, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map r5) {
        Iterator r10 = r5.entrySet().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        Map.Entry r11 = (Map.Entry) r10.next();
        put(r11.getKey(), r11.getValue());
        goto L4
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object putIfAbsent(Object r5, Object r10) {
        r5.getClass();
        r10.getClass();
        int r11 = e(r5);
        return i(r11).put(r5, r11, r10, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object r5) {
        if (r5 != null) goto L5;
        return null;
    L5:
        int r10 = e(r5);
        return i(r10).remove(r5, r10);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object replace(Object r5, Object r10) {
        r5.getClass();
        r10.getClass();
        int r11 = e(r5);
        return i(r11).replace(r5, r11, r10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        LocalCache$Segment[] r5 = this.f8747c;
        long r10 = 0;
        int r11 = 0;
    L4:
        if (r11 >= r5.length) goto L7;
        r10 = r10 + ((long) r5[r11].count);
        r11 = r11 + 1;
        goto L4
    L7:
        return dn.a.U(r10);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        h0 r5 = this.f8759t;
        if (r5 != null) goto L7;
        h0 r10 = new h0(this);
        this.f8759t = r10;
        return r10;
    L7:
        return r5;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean remove(Object r5, Object r10) {
        if (r5 == null) goto L7;
        if (r10 == null) goto L9;
        int r11 = e(r5);
        return i(r11).remove(r5, r11, r10);
    L9:
        return false;
    L7:
        return false;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean replace(Object r5, Object r10, Object r11) {
        r5.getClass();
        r11.getClass();
        if (r10 != null) goto L6;
        return false;
    L6:
        int r12 = e(r5);
        return i(r12).replace(r5, r12, r10, r11);
    }
}
