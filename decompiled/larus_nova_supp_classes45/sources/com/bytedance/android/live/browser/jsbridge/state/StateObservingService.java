package com.bytedance.android.live.browser.jsbridge.state;

import com.bytedance.android.annie.api.data.subscribe.BaseDataObsProvider;
import com.bytedance.android.annie.api.data.subscribe.g;
import com.bytedance.android.live.browser.jsbridge.i;
import com.bytedance.android.live.revenue.ILiveRevenueService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.Gson;
import com.ss.android.ugc.effectmanager.common.ConcurrentHashSet;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import j30.h;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class StateObservingService implements i {
    public final Map<String, com.bytedance.android.live.browser.jsbridge.state.a<?>> a;
    public final ConcurrentHashSet b;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ StateObservingService a;
        public final /* synthetic */ com.bytedance.android.live.browser.jsbridge.state.a b;

        public a(StateObservingService r1, com.bytedance.android.live.browser.jsbridge.state.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            Disposable r4 = (Disposable) r3;
            Map<String, com.bytedance.android.live.browser.jsbridge.state.a<?>> r5 = this.a.a;
            ConcurrentHashMap r6 = (ConcurrentHashMap) r5;
            r6.put(this.b.getKey(), this.b);
        }
    }

    public static final class b implements Action {
        public final /* synthetic */ StateObservingService a;
        public final /* synthetic */ com.bytedance.android.live.browser.jsbridge.state.a b;

        public b(StateObservingService r1, com.bytedance.android.live.browser.jsbridge.state.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void run() {
            com.bytedance.android.live.browser.jsbridge.state.a r0 = this.b;
            if ((r0 instanceof BaseObservableState) == true) goto L5;
            r0 = null;
        L5:
            BaseObservableState r1 = (BaseObservableState) r0;
            if (r1 == null) goto L8;
            r1.i();
        L8:
            this.a.e(this.b);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class c<T> extends com.bytedance.android.live.browser.jsbridge.state.c<T> {
        public final i.e<T> f;
        public final /* synthetic */ Object g;

        @Override // com.bytedance.android.live.browser.jsbridge.state.BaseObservableState
        public final void i() {
        }

        @Override // com.bytedance.android.live.browser.jsbridge.state.a
        public final i.f d() {
            return this.f;
        }

        public c(i.e r1, Object r2, Object r3) {
            this.g = r2;
            super(r3);
            this.f = r1;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public static final class d<T> extends com.bytedance.android.annie.api.data.subscribe.b<T> {
        public final /* synthetic */ i.e c;
        public final /* synthetic */ Object d;

        public final void onRelease() {
        }

        public final String key() {
            return this.c.a();
        }

        public d(i.e r1, Object r2, Object r3) {
            this.c = r1;
            this.d = r2;
            super(r3);
        }
    }

    @Override // com.bytedance.android.live.browser.jsbridge.i
    public final Map<String, i.c> a() {
        return this.a;
    }

    public StateObservingService(Gson r3) {
        Intrinsics.checkNotNullParameter(r3, "gson");
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashSet();
        c(new com.bytedance.android.live.browser.jsbridge.state.observable.e(0)).subscribe();
        c(new com.bytedance.android.live.browser.jsbridge.state.observable.d()).subscribe();
        d(new j30.e());
        d(new j30.a());
        d(new j30.c());
        d(new h());
        d(new j30.i());
        d(new j30.f());
        k.n(ILiveRevenueService.class).getHybridService().D3(r3, AnonymousClass1.INSTANCE);
    }

    public final synchronized <T> Observable<Unit> c(com.bytedance.android.live.browser.jsbridge.state.a<T> r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "state");     // Catch: Throwable -> L6
        Observable<Unit> r4 = Observable.empty().doOnSubscribe(new a(this, r3)).doOnDispose(new b(this, r3));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    public final <T> void d(com.bytedance.android.live.browser.jsbridge.state.b<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "state");
        Map<String, com.bytedance.android.live.browser.jsbridge.state.a<?>> r0 = this.a;
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;
        r1.put(r3.getKey(), r3);
    }

    public final synchronized <T> void e(com.bytedance.android.live.browser.jsbridge.state.a<T> r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, "state");     // Catch: Throwable -> L8
        Map<String, com.bytedance.android.live.browser.jsbridge.state.a<?>> r0 = this.a;     // Catch: Throwable -> L8
        ConcurrentHashMap r1 = (ConcurrentHashMap) r0;     // Catch: Throwable -> L8
        if (Intrinsics.areEqual((com.bytedance.android.live.browser.jsbridge.state.a) r1.get(r3.getKey()), r3) == false) goto L6;
        Map<String, com.bytedance.android.live.browser.jsbridge.state.a<?>> r2 = this.a;     // Catch: Throwable -> L8
        ConcurrentHashMap r4 = (ConcurrentHashMap) r2;     // Catch: Throwable -> L8
        r4.remove(r3.getKey());     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.android.live.browser.jsbridge.i
    public final <T> void registerStaticState(Function1<? super DataCenter, ? extends i.a<? extends T>> r2) {
        Intrinsics.checkNotNullParameter(r2, "stateCreation");
        this.b.add(r2);
    }

    @Override // com.bytedance.android.live.browser.jsbridge.i
    public final <T> void b(i.e<T> r5, T r6) {
        Intrinsics.checkNotNullParameter(r5, "state");
        com.bytedance.android.live.browser.jsbridge.state.a r0 = (com.bytedance.android.live.browser.jsbridge.state.a) ((ConcurrentHashMap) this.a).get(r5.a());
        Unit r1 = null;
        if (r0 != null) goto L5;
        ((ConcurrentHashMap) this.a).put(r5.a(), new c(r5, r6, r6));
    L18:
        com.bytedance.android.annie.service.data.b r2 = com.bytedance.android.annie.service.data.b.a;
        g r3 = com.bytedance.android.annie.service.data.b.a(r5.a());
        if (r3 != null) goto L21;
    L34:
        com.bytedance.android.annie.service.data.b.b(new d(r5, r6, r6));
        Unit r7 = Unit.INSTANCE;
        return;
    L21:
        if ((r3 instanceof com.bytedance.android.annie.api.data.subscribe.b) == true) goto L23;
        g r4 = null;
    L24:
        com.bytedance.android.annie.api.data.subscribe.b r8 = (com.bytedance.android.annie.api.data.subscribe.b) r4;
        if (r8 == null) goto L28;
        r8.b = r6;
    L28:
        if ((r3 instanceof BaseDataObsProvider) == true) goto L30;
        r3 = null;
    L30:
        BaseDataObsProvider r9 = (BaseDataObsProvider) r3;
        if (r9 == null) goto L33;
        r9.i(r6);
        r1 = Unit.INSTANCE;
    L33:
        if (r1 == null) goto L34;
        return;
    L23:
        r4 = r3;
        goto L24
    L5:
        if ((r0 instanceof com.bytedance.android.live.browser.jsbridge.state.c) == true) goto L7;
        com.bytedance.android.live.browser.jsbridge.state.a r11 = null;
    L8:
        com.bytedance.android.live.browser.jsbridge.state.c r12 = (com.bytedance.android.live.browser.jsbridge.state.c) r11;
        if (r12 == null) goto L12;
        r12.e = r6;
    L12:
        if ((r0 instanceof BaseObservableState) == true) goto L14;
        r0 = null;
    L14:
        BaseObservableState r13 = (BaseObservableState) r0;
        if (r13 == null) goto L18;
        r13.h(r6);
        goto L18
    L7:
        r11 = r0;
        goto L8
    }
}
