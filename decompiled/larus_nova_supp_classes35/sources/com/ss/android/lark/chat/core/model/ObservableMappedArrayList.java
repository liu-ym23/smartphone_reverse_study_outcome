package com.ss.android.lark.chat.core.model;

import android.os.Looper;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.chatbase.BasePageStore;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.ExceptionsKt;
import x4b.e;
import x4b.f;
import x4b.g;
import x4b.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class ObservableMappedArrayList<K, T> extends ArrayList<T> implements d<T> {
    public transient d.a a;
    private a mAccessTracker;
    private b<K, T> mItemKey;
    private Map<K, Integer> mPositionMap;
    private ReentrantReadWriteLock mReadWriteLock;

    public static class a {
        public String a;
        public Thread b;
        public long c;
        public final boolean d;
        public long e;
        public int f;
        public String g;
        public long h;
        public long i;

        public final void a() {
            if (this.d == true) goto L6;
            return;
        L6:
            if (ThreadMethodProxy.currentThread() == this.b) goto L8;
            return;
        L8:
            if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != this.b) goto L17;
            long r0 = System.nanoTime() - this.c;
            this.e += r0;
            this.f++;
            if (r0 <= this.h) goto L13;
            this.h = r0;
            this.g = this.a;
        L13:
            if ((System.currentTimeMillis() - this.i) <= 30000) goto L18;
            Log.w("ObservableList", String.format("avg: %.3fms, count: %d, max: %.3fms, scense: %s", new Object[]{Float.valueOf(((this.e / ((long) this.f)) * 1.0f) / 1000000.0f), Integer.valueOf(this.f), Float.valueOf((this.h * 1.0f) / 1000000.0f), this.g}));
            this.e = 0;
            this.f = 0;
            this.g = null;
            this.h = 0;
            this.i = System.currentTimeMillis();
            return;
        L18:
            return;
        }

        public a(boolean r3) {
            this.e = 0;
            this.f = 0;
            this.d = r3;
        }
    }

    public interface b<K, T> {
    }

    @Override // com.ss.android.lark.chat.core.model.d
    public void acquireReadAccess() {
        if (this.mReadWriteLock == null) goto L10;
        Log.d("ObservableList", "acquireReadAccess: thread: " + ThreadMethodProxy.currentThread().getName() + " stack: " + ExceptionsKt.stackTraceToString(new Exception()));
        a r0 = this.mAccessTracker;
        if (r0.d == false) goto L8;
        r0.c = System.nanoTime();
        r0.a = "acquireReadAccess";
        r0.b = ThreadMethodProxy.currentThread();
    L8:
        this.mReadWriteLock.readLock().lock();
        return;
    }

    public void beginUpdate() {
        ReentrantReadWriteLock r0 = this.mReadWriteLock;
        if (r0 == null) goto L5;
        r0.writeLock().lock();
    L5:
        d.a r1 = this.a;
        if (r1 == null) goto L9;
        ((com.ss.android.lark.chat.core.model.b) r1).e();
        return;
    }

    public void finishUpdate() {
        d.a r0 = this.a;     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        ((com.ss.android.lark.chat.core.model.b) r0).f();     // Catch: Throwable -> L9
    L5:
        ReentrantReadWriteLock r1 = this.mReadWriteLock;
        if (r1 == null) goto L16;
        r1.writeLock().unlock();
        return;
    L16:
        return;
    L9:
        th = move-exception;
        ReentrantReadWriteLock r2 = this.mReadWriteLock;
        if (r2 == null) goto L13;
        r2.writeLock().unlock();
    L13:
        throw th;
    }

    @Override // com.ss.android.lark.chat.core.model.d
    public void releaseReadAccess() {
        if (this.mReadWriteLock == null) goto L6;
        Log.d("ObservableList", "releaseReadAccess: thread: " + ThreadMethodProxy.currentThread().getName() + " stack: " + ExceptionsKt.stackTraceToString(new Exception()));
        this.mReadWriteLock.readLock().unlock();
        this.mAccessTracker.a();
        return;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        int r0 = size();
        super.clear();
        this.mPositionMap.clear();
        if (r0 == 0) goto L6;
        f(0, r0);
        return;
    }

    public ObservableMappedArrayList(b<K, T> r2) {
        this(r2, false, false);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(T r5) {
        super.add(r5);
        int r0 = size() - 1;
        Map<K, Integer> r2 = this.mPositionMap;
        Object r6 = ((BasePageStore.b) this.mItemKey).a(r5);
        K r7 = (K) r6;
        r2.put(r7, Integer.valueOf(r0));
        d.a r8 = this.a;
        if (r8 == null) goto L5;
        ((com.ss.android.lark.chat.core.model.b) r8).d(this, r0, 1);
    L5:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends T> r6) {
        int r0 = size();
        boolean r7 = super.addAll(r6);
        if (r7 == false) goto L11;
        int r1 = r0;
    L6:
        if (r1 >= size()) goto L8;
        Map<K, Integer> r2 = this.mPositionMap;
        b<K, T> r3 = this.mItemKey;
        BasePageStore.b r4 = (BasePageStore.b) r3;
        Object r5 = r4.a(get(r1));
        K r8 = (K) r5;
        r2.put(r8, Integer.valueOf(r1));
        r1 = r1 + 1;
        goto L6
    L8:
        int r9 = size() - r0;
        d.a r10 = this.a;
        if (r10 == null) goto L11;
        ((com.ss.android.lark.chat.core.model.b) r10).d(this, r0, r9);
    L11:
        return r7;
    }

    @Override // com.ss.android.lark.chat.core.model.d
    public void addOnListUpdateCallback(d.a r1) {
        this.a = r1;
    }

    public boolean containsKey(final K... r2) {
        return ((Boolean) g("containsKey", new h(this, r2))).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsValue(T r3) {
        return containsKey(new Object[]{((BasePageStore.b) this.mItemKey).a(r3)});
    }

    public T getItemByKey(final K... r2) {
        return (T) g("getItemByKey", new f(this, r2));
    }

    public int getItemPosByKey(final K... r2) {
        return ((Integer) g("getItemPosByKey", new e(this, r2))).intValue();
    }

    public List<T> getItemsByKey(final Collection<K> r3) {
        final ArrayList r0 = new ArrayList();
        if (r3 != null) goto L5;
    L9:
        return r0;
    L5:
        if (r3.isEmpty() == true) goto L9;
        return (List) g("getItemsByKey", new g(this, r3, r0));
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public T remove(int r6) {
        T r0 = (T) super.remove(r6);
        this.mPositionMap.remove(((BasePageStore.b) this.mItemKey).a(r0));
        if (this.mPositionMap.size() == size()) goto L5;
        this.mPositionMap.clear();
        int r1 = 0;
    L7:
        if (r1 >= size()) goto L9;
        Map<K, Integer> r2 = this.mPositionMap;
        b<K, T> r3 = this.mItemKey;
        BasePageStore.b r4 = (BasePageStore.b) r3;
        Object r5 = r4.a(get(r1));
        K r7 = (K) r5;
        r2.put(r7, Integer.valueOf(r1));
        r1 = r1 + 1;
        goto L7
    L9:
        f(r6, 1);
        return r0;
    L5:
        r1 = r6;
        goto L7
    }

    @Override // com.ss.android.lark.chat.core.model.d
    public void removeOnListUpdateCallback(d.a r1) {
        this.a = null;
    }

    @Override // java.util.ArrayList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object r1) {
        int r2 = indexOf(r1);
        if (r2 < 0) goto L6;
        remove(r2);
        return true;
    L6:
        return false;
    }

    public static /* synthetic */ Integer c(ObservableMappedArrayList r4, Object[] r5) {
        r4.getClass();
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        Object r2 = r5[r1];
        if (r2 == null) goto L10;
        if (r4.mPositionMap.containsKey(r2) == false) goto L10;
        int r6 = r4.mPositionMap.get(r2).intValue();
    L13:
        return Integer.valueOf(r6);
    L10:
        r1 = r1 + 1;
        goto L3
    L11:
        r6 = -1;
        goto L13
    }

    public static /* synthetic */ Object d(ObservableMappedArrayList r4, Object[] r5) {
        r4.getClass();
        int r0 = r5.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        Object r2 = r5[r1];
        if (r2 == null) goto L10;
        if (r4.mPositionMap.containsKey(r2) == false) goto L10;
        return r4.get(r4.mPositionMap.get(r2).intValue());
    L10:
        r1 = r1 + 1;
        goto L3
    L11:
        return null;
    }

    public static /* synthetic */ Boolean e(ObservableMappedArrayList r5, Object[] r6) {
        r5.getClass();
        int r0 = r6.length;
        boolean r1 = false;
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L12;
        Object r3 = r6[r2];
        if (r3 == null) goto L10;
        if (r5.mPositionMap.containsKey(r3) == false) goto L10;
        r1 = true;
    L10:
        r2 = r2 + 1;
    L12:
        return Boolean.valueOf(r1);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public void add(int r4, T r5) {
        super.add(r4, r5);
        int r6 = r4;
    L4:
        if (r6 >= size()) goto L6;
        Map<K, Integer> r0 = this.mPositionMap;
        b<K, T> r1 = this.mItemKey;
        BasePageStore.b r2 = (BasePageStore.b) r1;
        Object r3 = r2.a(get(r6));
        K r7 = (K) r3;
        r0.put(r7, Integer.valueOf(r6));
        r6 = r6 + 1;
        goto L4
    L6:
        d.a r8 = this.a;
        if (r8 == null) goto L11;
        ((com.ss.android.lark.chat.core.model.b) r8).d(this, r4, 1);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public boolean addAll(int r6, Collection<? extends T> r7) {
        boolean r0 = super.addAll(r6, r7);
        if (r0 == false) goto L11;
        int r1 = r6;
    L6:
        if (r1 >= size()) goto L8;
        Map<K, Integer> r2 = this.mPositionMap;
        b<K, T> r3 = this.mItemKey;
        BasePageStore.b r4 = (BasePageStore.b) r3;
        Object r5 = r4.a(get(r1));
        K r8 = (K) r5;
        r2.put(r8, Integer.valueOf(r1));
        r1 = r1 + 1;
        goto L6
    L8:
        int r9 = r7.size();
        d.a r10 = this.a;
        if (r10 == null) goto L11;
        ((com.ss.android.lark.chat.core.model.b) r10).d(this, r6, r9);
    L11:
        return r0;
    }

    public final void f(int r5, int r6) {
        d.a r0 = this.a;
        if (r0 == null) goto L15;
        com.ss.android.lark.chat.core.model.b r1 = (com.ss.android.lark.chat.core.model.b) r0;
        r1.a();
        r1.e = true;
        int r2 = 0;
    L5:
        if (r2 >= r6) goto L7;
        ListProtector.remove(r1.c, r5);
        r2 = r2 + 1;
        goto L5
    L7:
        List<com.ss.android.lark.chat.core.model.b.a<T>> r3 = r1.g;
        if (r3 != null) goto L10;
        return;
    L10:
        if (r3.isEmpty() == true) goto L19;
        Iterator<com.ss.android.lark.chat.core.model.b.a<T>> r4 = r1.g.iterator();
    L13:
        if (r4.hasNext() == false) goto L20;
        r4.next().a(r1.c, r5, r6);
        goto L13
    L20:
        return;
    L19:
        return;
    }

    public final <R> R g(String r4, Callable<R> r5) {
        if (this.mReadWriteLock == null) goto L23;
        Log.d("ObservableList", "threadSafeAccess: thread: " + ThreadMethodProxy.currentThread().getName() + " stack: " + ExceptionsKt.stackTraceToString(new Exception()));
        a r0 = this.mAccessTracker;
        if (r0.d == false) goto L8;
        r0.c = System.nanoTime();
        r0.a = r4;
        r0.b = ThreadMethodProxy.currentThread();
    L8:
        this.mReadWriteLock.readLock().lock();
    L23:
        R r6 = r5.call();     // Catch: Throwable -> L14 Exception -> L16
        ReentrantReadWriteLock r7 = this.mReadWriteLock;
        if (r7 == null) goto L13;
        r7.readLock().unlock();
        this.mAccessTracker.a();
    L13:
        return r6;
    L14:
        th = move-exception;
        ReentrantReadWriteLock r8 = this.mReadWriteLock;
        if (r8 == null) goto L22;
        r8.readLock().unlock();
        this.mAccessTracker.a();
    L22:
        throw th;
    L16:
        e = move-exception;
        throw new RuntimeException(e);     // Catch: Throwable -> L14
    }

    @Override // java.util.ArrayList, java.util.AbstractList
    public void removeRange(int r5, int r6) {
        Iterator<T> r0 = subList(r5, r6).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        T r1 = r0.next();
        this.mPositionMap.remove(((BasePageStore.b) this.mItemKey).a(r1));
        goto L4
    L6:
        super.removeRange(r5, r6);
        int r2 = r5;
    L8:
        if (r2 >= size()) goto L10;
        Map<K, Integer> r3 = this.mPositionMap;
        b<K, T> r4 = this.mItemKey;
        BasePageStore.b r7 = (BasePageStore.b) r4;
        Object r8 = r7.a(get(r2));
        K r9 = (K) r8;
        r3.put(r9, Integer.valueOf(r2));
        r2 = r2 + 1;
        goto L8
    L10:
        f(r5, r6 - r5);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public T set(int r6, T r7) {
        T r0 = (T) super.set(r6, r7);
        this.mPositionMap.remove(((BasePageStore.b) this.mItemKey).a(r0));
        Map<K, Integer> r1 = this.mPositionMap;
        Object r8 = ((BasePageStore.b) this.mItemKey).a(r7);
        K r9 = (K) r8;
        r1.put(r9, Integer.valueOf(r6));
        d.a r10 = this.a;
        if (r10 == null) goto L12;
        com.ss.android.lark.chat.core.model.b r11 = (com.ss.android.lark.chat.core.model.b) r10;
        r11.a();
        r11.e = true;
        int r2 = r6 + 0;
        ListProtector.set(r11.c, r2, r11.a.b(get(r2)));
        List<com.ss.android.lark.chat.core.model.b.a<T>> r3 = r11.g;
        if (r3 == null) goto L12;
        if (r3.isEmpty() == true) goto L12;
        Iterator<com.ss.android.lark.chat.core.model.b.a<T>> r4 = r11.g.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        r4.next().c(r11.c, r6);
    L12:
        return r0;
    }

    public ObservableMappedArrayList(b<K, T> r2, boolean r3, boolean r4) {
        this.mPositionMap = new HashMap();
        this.mItemKey = r2;
        if (r3 == false) goto L5;
        this.mReadWriteLock = new ReentrantReadWriteLock(true);
    L5:
        this.mAccessTracker = new a(r4);
    }

    public static /* synthetic */ void a(ObservableMappedArrayList r2, Collection r3, List r4) {
        r2.getClass();
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r0 = r5.next();
        if (r2.mPositionMap.containsKey(r0) == false) goto L4;
        r4.add(r2.get(r2.mPositionMap.get(r0).intValue()));
        goto L4
    }
}
