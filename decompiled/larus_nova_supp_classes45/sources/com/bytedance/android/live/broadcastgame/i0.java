package com.bytedance.android.live.broadcastgame;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class i0 implements b0 {
    public final Map<Class<? extends v>, d0<? extends v>> a;
    public final Map<Class<? extends v>, List<c0<? extends v>>> b;
    public final List<a0> c;
    public final PublishSubject<v> d;

    public final void d() {
        Iterator r0 = ((LinkedHashMap) this.b).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        Iterator r1 = ((Iterable) ((Map.Entry) r0.next()).getValue()).iterator();
    L7:
        if (r1.hasNext() == false) goto L4;
        ((c0) r1.next()).release();
        goto L7
    L9:
        ((LinkedHashMap) this.b).clear();
    }

    public i0() {
        this.a = new LinkedHashMap();
        this.b = new LinkedHashMap();
        this.c = new ArrayList();
        this.d = PublishSubject.create();
        PublishSubject.create();
    }

    public final synchronized void a(a0 r2) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "messageInterceptor");     // Catch: Throwable -> L6
        ((ArrayList) this.c).add(r2);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final <T extends v> Observable<j0> e(T r4) {
        Intrinsics.checkNotNullParameter(r4, "message");
        d0 r1 = (d0) ((LinkedHashMap) this.a).get(r4.getClass());
        if (r1 == null) goto L7;
        Intrinsics.checkNotNullParameter(r4, "message");
        Observable<j0> r0 = r1.a(r4);
        if (r0 == null) goto L7;
        return r0;
    L7:
        return Observable.error(new Throwable("can't send message type: " + r4.getClass()));
    }

    public final <T extends v> Observable<T> f(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "messageType");
        if (this.b.containsKey(r2) == true) goto L7;
        return null;
    L7:
        return this.d.ofType(r2).observeOn(AndroidSchedulers.mainThread());
    }

    @Override // com.bytedance.android.live.broadcastgame.b0
    public <T extends v> void insert(T r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        monitor-enter(this);
        Iterator r0 = ((ArrayList) this.c).iterator();     // Catch: Throwable -> L15
    L6:
        if (r0.hasNext() == false) goto L10;
        if (((a0) r0.next()).a(r3) == false) goto L6;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L13;
        this.d.onNext(r3);     // Catch: Throwable -> L15
    L13:
        monitor-exit(this);
        return;
    L10:
        r1 = false;
    L15:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(Class r3, c0 r4) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "messageType");     // Catch: Throwable -> L12
        Intrinsics.checkNotNullParameter(r4, "messageReceiver");     // Catch: Throwable -> L12
        if (((LinkedHashMap) this.b).get(r3) != null) goto L6;
        this.b.put(r3, new ArrayList());     // Catch: Throwable -> L12
    L6:
        List r5 = (List) ((LinkedHashMap) this.b).get(r3);     // Catch: Throwable -> L12
        if (r5 == null) goto L9;
        r5.add(r4);     // Catch: Throwable -> L12
    L9:
        r4.a(this);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized void c(Class r2, d0 r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r2, "messageType");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r3, "messageSender");     // Catch: Throwable -> L6
        this.a.put(r2, r3);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
