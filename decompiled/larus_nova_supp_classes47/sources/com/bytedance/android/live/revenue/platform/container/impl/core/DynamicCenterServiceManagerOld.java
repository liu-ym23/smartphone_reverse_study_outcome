package com.bytedance.android.live.revenue.platform.container.impl.core;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.live.revenue.platform.container.api.CenterServiceType;
import com.bytedance.android.live.revenue.platform.container.impl.RevenueJsDriver;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.revenue.platform.api.core.rx.p;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DynamicCenterServiceManagerOld implements h {
    public static final long l = 0;
    public zy0.b a;
    public String b;
    public final BehaviorSubject<String> c;
    public RevenueJsDriver d;
    public final CompositeDisposable e;
    public boolean f;
    public final vy0.d g;
    public final ny0.a h;
    public final g i;
    public final Context j;
    public final cy0.f k;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Unit r2 = (Unit) r1;
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ DynamicCenterServiceManagerOld a;

        public d(DynamicCenterServiceManagerOld r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Long r5 = (Long) r4;
            jy0.b.c("DynamicCenterServiceManager", "stop Lynx service Center timeout: " + DynamicCenterServiceManagerOld.l + " ms, kill service Center", null, 4);
            this.a.e();
        }
    }

    public static final class e<T> implements Consumer {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Unit r2 = (Unit) r1;
        }
    }

    public static final class f<T> implements Consumer {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.revenue.platform.container.impl.core.DynamicCenterServiceManagerOld$onStart$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lyy0/c;", "", "invoke", "(Lyy0/c;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    public static final class AnonymousClass1 extends Lambda implements Function1<yy0.c, Unit> {
        final /* synthetic */ DynamicCenterServiceManagerOld this$0;

        public AnonymousClass1(DynamicCenterServiceManagerOld r1) {
            this.this$0 = r1;
            super(1);
        }

        public final void invoke(yy0.c r2) {
            Intrinsics.checkNotNullParameter(r2, "$receiver");
            r2.d(new C00861(this));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((yy0.c) r1);
            return Unit.INSTANCE;
        }
    }

    static {
        l = ((Number) com.bytedance.android.live.revenue.platform.container.impl.core.b.b.getValue(null, com.bytedance.android.live.revenue.platform.container.impl.core.b.a[0])).longValue();
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.h
    public final void d() {
        if (this.i.b0() != NotifyServiceCenterStateRequest.State.STOPPED) goto L15;
        e();
        return;
    L15:
        com.bytedance.revenue.platform.api.core.rx.f.a(((i) this.h.x(Reflection.getOrCreateKotlinClass(i.class), CenterServiceType.CENTER_SERVICE)).notifyRoomState(NotifyRoomStateRequestState.LEFT.getTag()).subscribe(b.a, c.a), this.e);     // Catch: Throwable -> L8
    L11:
        if (this.d == null) goto L13;
        this.i.E();
    L13:
        this.d = null;
        com.bytedance.revenue.platform.api.core.rx.l r0 = com.bytedance.revenue.platform.api.core.rx.l.a;
        long r1 = l;
        int r2 = p.a;
        Scheduler r3 = Schedulers.computation();
        com.bytedance.revenue.platform.api.core.rx.f.a(Observable.timer(r1, TimeUnit.MILLISECONDS, r3).subscribe(new d(this)), this.e);
        return;
    L8:
        th = move-exception;
        jy0.b.b("DynamicCenterServiceManager", "Failed to find IDynamicHostService", th);
        goto L11
    }

    public final void e() {
        jy0.b.d("DynamicCenterServiceManager", "stop Lynx service Center");
        ((NativeHostServiceImpl) com.bytedance.android.live.revenue.core.util.f.a(NativeHostServiceImpl.class)).K(this, this.k);
        zy0.b r0 = this.a;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        this.e.dispose();
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.h
    public final void onStart() {
        if (this.a == null) goto L5;
        return;
    L5:
        ((NativeHostServiceImpl) com.bytedance.android.live.revenue.core.util.f.a(NativeHostServiceImpl.class)).w0(this, this.k);
        vy0.d r0 = this.g;
        Context r1 = this.j;
        vy0.a.c r2 = new vy0.a.c();
        int r3 = com.bytedance.revenue.platform.api.core.e.a;
        ReadOnlyProperty r4 = com.bytedance.android.live.revenue.platform.container.impl.core.b.c;
        KProperty[] r5 = com.bytedance.android.live.revenue.platform.container.impl.core.b.a;
        Uri.Builder r6 = com.bytedance.revenue.platform.api.core.e.a((String) r4.getValue(null, r5[1])).buildUpon();
        List r7 = (List) com.bytedance.android.live.revenue.platform.container.impl.core.b.d.getValue(null, r5[2]);
        zy0.b r8 = r0.Xi(r1, r2, r6.appendQueryParameter("revenue_service_urls", GsonProtectorUtils.toJson(l97.a.a, r7)).build(), new AnonymousClass1(this));
        Intrinsics.checkNotNull(r8);
        Intrinsics.checkNotNullParameter(this, "$this$setupJsDriverAndLoad");
        Intrinsics.checkNotNullParameter(r8, "card");
        com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a r9 = (com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a) r8;
        this.d = r9.b;
        r9.d.load(null, null);
        Unit r10 = Unit.INSTANCE;
        this.a = r8;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.h
    public final void onWidgetLoaded() {
        if (this.f == true) goto L6;
        this.f = true;
        com.bytedance.revenue.platform.api.core.rx.f.a(((i) this.h.x(Reflection.getOrCreateKotlinClass(i.class), CenterServiceType.CENTER_SERVICE)).notifyRoomState(NotifyRoomStateRequestState.ENTERED.getTag()).subscribe(e.a, f.a), this.e);
        return;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.h
    public final zy0.b D() {
        return this.a;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.h
    public final BehaviorSubject a() {
        return this.c;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.h
    public final RevenueJsDriver c() {
        return this.d;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.h
    public final String getServiceVersion() {
        return this.b;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.h
    public final void b(NotifyServiceCenterStateRequest r8) {
        Intrinsics.checkNotNullParameter(r8, "request");
        int r0 = r8.getState();
        if (r0 != NotifyServiceCenterStateRequest.State.STARTED.getTag()) goto L13;
        jy0.b.d("DynamicCenterServiceManager", "center started");
        String r9 = r8.getServiceVersion();
        if (r9 != null) goto L7;
        r9 = this.b;
    L7:
        Intrinsics.checkNotNullParameter(r9, "value");
        this.b = r9;
        this.c.onNext(r9);
        RevenueJsDriver r10 = this.d;
        if (r10 == null) goto L11;
        this.i.w0(com.bytedance.revenue.platform.api.core.c.a(new String[]{"core.service.DynamicHostService"}), r10);
        return;
    L11:
        throw com.bytedance.platform.aio.d.e("update dynamic service before jsb ready, initialize failed", null);
    L13:
        if (r0 != NotifyServiceCenterStateRequest.State.SCRIPTS_LOADED.getTag()) goto L32;
        NotifyServiceCenterStateRequest.b r1 = r8.I1();
        if (r1 == null) goto L18;
        List<NotifyServiceCenterStateRequest.b.InterfaceC0090b> r2 = r1.getServices();
        if (r2 == null) goto L18;
    L19:
        List<NotifyServiceCenterStateRequest.b.InterfaceC0090b> r3 = r2;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L21:
        if (r5.hasNext() == false) goto L23;
        r4.add(((NotifyServiceCenterStateRequest.b.InterfaceC0090b) r5.next()).T1());
        goto L21
    L23:
        String r12 = r8.getServiceVersion();
        if (r12 != null) goto L26;
        r12 = this.b;
    L26:
        Intrinsics.checkNotNullParameter(r12, "value");
        this.b = r12;
        this.c.onNext(r12);
        jy0.b.d("DynamicCenterServiceManager", "updateDynamicServices: " + r4);
        RevenueJsDriver r13 = this.d;
        if (r13 == null) goto L30;
        this.i.I(r4, r13);
        return;
    L30:
        throw com.bytedance.platform.aio.d.e("update dynamic service before jsb ready, initialize failed", null);
    L18:
        r2 = CollectionsKt.emptyList();
        goto L19
    L32:
        if (r0 != NotifyServiceCenterStateRequest.State.STOPPED.getTag()) goto L34;
        e();
        return;
    L34:
        jy0.b.c("DynamicCenterServiceManager", "receive unknown state: " + r8.getState(), null, 4);
    }

    public DynamicCenterServiceManagerOld(vy0.d r2, ny0.a r3, g r4, Context r5, cy0.f r6) {
        Intrinsics.checkNotNullParameter(r2, "lynxCardService");
        Intrinsics.checkNotNullParameter(r3, "rpcService");
        Intrinsics.checkNotNullParameter(r4, "centerService");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "scope");
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.j = r5;
        this.k = r6;
        this.b = "0.0.0.0";
        int r7 = com.bytedance.revenue.platform.api.core.rx.c.a;
        this.c = BehaviorSubject.create();
        this.e = new CompositeDisposable();
    }
}
