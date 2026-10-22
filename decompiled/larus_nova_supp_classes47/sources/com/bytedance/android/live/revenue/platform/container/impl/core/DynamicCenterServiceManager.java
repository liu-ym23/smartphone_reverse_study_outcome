package com.bytedance.android.live.revenue.platform.container.impl.core;

import android.content.Context;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.base.model.user.o;
import com.bytedance.android.live.revenue.common.y0;
import com.bytedance.android.live.revenue.platform.container.api.CenterServiceType;
import com.bytedance.android.live.revenue.platform.container.impl.RevenueJsDriver;
import com.bytedance.android.live.revenue.platform.container.impl.w;
import com.bytedance.android.scope.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DynamicCenterServiceManager implements com.bytedance.android.live.revenue.platform.container.impl.core.h {
    public l a;
    public final BehaviorSubject<String> b;
    public final CompositeDisposable c;
    public boolean d;
    public final ny0.a e;
    public final com.bytedance.android.live.revenue.platform.container.impl.core.g f;
    public final NativeHostServiceImpl g;
    public final Context h;
    public final cy0.f i;

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
        public final /* synthetic */ DynamicCenterServiceManager a;

        public d(DynamicCenterServiceManager r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Long r2 = (Long) r1;
            this.a.c.dispose();
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

    public static final class g<T> implements Consumer {
        public final /* synthetic */ DynamicCenterServiceManager a;

        public g(DynamicCenterServiceManager r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            Boolean r4 = (Boolean) r3;
            DynamicCenterServiceManager r5 = this.a;
            zy0.b r0 = r5.D();
            if (r0 == null) goto L8;
            xy0.a<?> r1 = r0.g();
            if (r1 == null) goto L9;
            ConcurrentHashMap r2 = com.bytedance.android.anniex.ability.f.a;
            r1.updateGlobalProps(com.bytedance.android.anniex.ability.f.o(r5.h, null));
            return;
        L9:
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Unit r2 = (Unit) r1;
        }
    }

    public static final class i<T> implements Consumer {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            Throwable r2 = (Throwable) r1;
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.h
    public final zy0.b D() {
        l r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.b;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.h
    public final RevenueJsDriver c() {
        l r0 = this.a;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.h
    public final void d() {
        com.bytedance.revenue.platform.api.core.rx.f.a(((com.bytedance.android.live.revenue.platform.container.impl.core.i) this.e.x(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revenue.platform.container.impl.core.i.class), CenterServiceType.PRE_CENTER_SERVICE)).notifyRoomState(NotifyRoomStateRequestState.LEFT.getTag()).subscribe(b.a, c.a), this.c);
        boolean r1 = true;
        if (getServiceVersion().length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L27;
        int r2 = y0.a;
        String r3 = getServiceVersion();
        Intrinsics.checkNotNullParameter(r3, "version1");
        Intrinsics.checkNotNullParameter("1.0.0.3007", "version2");
        List r4 = StringsKt.split$default(r3, new char[]{'.'}, false, 0, 6, null);
        List r5 = StringsKt.split$default("1.0.0.3007", new char[]{'.'}, false, 0, 6, null);
        int r6 = Math.max(r4.size(), r5.size());
        int r7 = 0;
    L9:
        if (r7 >= r6) goto L23;
        if (r7 >= r4.size()) goto L13;
        int r8 = CastIntegerProtector.parseInt((String) ListProtector.get(r4, r7));
    L15:
        if (r7 >= r5.size()) goto L17;
        int r9 = CastIntegerProtector.parseInt((String) ListProtector.get(r5, r7));
    L18:
        if (r8 > r9) goto L19;
        if (r8 < r9) goto L21;
        r7 = r7 + 1;
        goto L9
    L21:
        byte r10 = -1;
    L24:
        if (r10 < 0) goto L27;
        r1 = false;
        goto L27
    L19:
        r10 = 1;
        goto L24
    L17:
        r9 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L15
    L23:
        r10 = 0;
    L27:
        if (r1 == false) goto L29;
        ((NativeHostServiceImpl) com.bytedance.android.live.revenue.core.util.f.a(NativeHostServiceImpl.class)).I();
    L32:
        ((NativeHostServiceImpl) com.bytedance.android.live.revenue.core.util.f.a(NativeHostServiceImpl.class)).K(this, e());
        Single.timer(3000, TimeUnit.MILLISECONDS).subscribe(new d(this));
        return;
    L29:
        RevenueJsDriver r12 = c();
        if (r12 == null) goto L32;
        this.f.L0(r12);
        goto L32
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.h
    public final String getServiceVersion() {
        l r0 = this.a;
        if (r0 == null) goto L6;
        String r1 = r0.c;
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "0.0.0.0";
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.h
    public final void onStart() {
        l r0 = this.g.b0(this.h, new DynamicCenterServiceManager$onStart$impl$1(this));
        this.a = r0;
        com.bytedance.android.live.revenue.platform.room.impl.l r3 = null;
        if (((Boolean) com.bytedance.android.live.revenue.platform.container.impl.core.e.b.getValue(null, com.bytedance.android.live.revenue.platform.container.impl.core.e.a[0])).booleanValue() == false) goto L5;
        Context r1 = this.h;
    L6:
        RevenueJsDriver r2 = r0.a;
        if (r2 == null) goto L26;
        Disposable r4 = r0.b;
        if (r4 == null) goto L25;
        i57.g r5 = w.a(((com.bytedance.android.live.revenue.platform.hybrid.impl.ui.a) ((com.bytedance.android.live.revenue.platform.hybrid.impl.ui.c) r4)).d, r1, null);
        Intrinsics.checkNotNullParameter(r5, "aioCallContext");
        i57.e r6 = i57.e.f;
        Context r7 = (Context) r5.a(r6.a());
        if (r7 == null) goto L17;
        i57.g r8 = r2.g;
        if (r8 == null) goto L16;
        r8.b(r6.a(), r7);
        goto L17
    L16:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.platform.aio.context.MutableAioCallContext");
    L17:
        com.bytedance.android.scope.j r9 = (com.bytedance.android.scope.j) r5.a(r6.b());
        if (r9 == null) goto L26;
        i57.g r10 = r2.g;
        if (r10 == null) goto L23;
        r10.b(r6.b(), r9);
        goto L26
    L23:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.platform.aio.context.MutableAioCallContext");
    L25:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.platform.hybrid.impl.ui.BaseHybridComponentContainerBase");
    L26:
        this.g.w0(this, e());
        com.bytedance.revenue.platform.api.core.rx.f.a(((com.bytedance.android.live.revenue.platform.container.impl.core.i) this.e.x(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revenue.platform.container.impl.core.i.class), CenterServiceType.PRE_CENTER_SERVICE)).notifyRoomState(NotifyRoomStateRequestState.PRE_ENTERED.getTag()).subscribe(e.a, f.a), this.c);
        com.bytedance.android.scope.j r12 = e();
        if (r12 == null) goto L35;
        yz0.k r13 = (yz0.k) m.e.d(r12, yz0.k.class);
        if (r13 == null) goto L35;
        Observable<Boolean> r14 = r13.Z2();
        if (r14 == null) goto L35;
        Disposable r15 = r14.subscribe(new g(this));
        if (r15 == null) goto L35;
        com.bytedance.revenue.platform.api.core.rx.f.a(r15, this.c);
    L35:
        LinkedHashMap r16 = new LinkedHashMap();
        com.bytedance.android.scope.j r17 = e();
        if (r17 == null) goto L38;
        r3 = (com.bytedance.android.live.revenue.platform.room.impl.l) m.e.d(r17, com.bytedance.android.live.revenue.platform.room.impl.l.class);
    L38:
        if (r3 == null) goto L45;
        r16.put("room_id", Long.valueOf(r3.getRoom().getId()));
        r16.put("anchor_id", r3.getRoom().getAnchorId());
        IBaseUser r18 = r3.getRoom().getOwner();
        if (r18 == null) goto L44;
        Intrinsics.checkNotNullParameter(r18, "$this$secUidExt");
        String r19 = r18.getCastSecUid();
        if (r19 == null) goto L44;
        r16.put("sec_anchor_id", r19);
    L44:
        r16.put("user_id", r3.getUser().getIdString());
        r16.put("sec_user_id", o.a(r3.getUser()));
    L45:
        zy0.b r20 = D();
        if (r20 == null) goto L51;
        xy0.a<?> r22 = r20.g();
        if (r22 == null) goto L52;
        r22.updateGlobalProps(r16);
        return;
    L52:
        return;
    L51:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final com.bytedance.android.scope.j e() {
        RevenueJsDriver r0 = c();
        if (r0 == null) goto L7;
        com.bytedance.android.scope.j r1 = (com.bytedance.android.scope.j) r0.g.a(i57.e.f.b());
        if (r1 == null) goto L7;
        return r1;
    L7:
        return this.i.i().c();
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.h
    public final void onWidgetLoaded() {
        zy0.b r0 = D();
        if (r0 == null) goto L8;
        xy0.a<?> r1 = r0.g();
        if (r1 == null) goto L8;
        ConcurrentHashMap r2 = com.bytedance.android.anniex.ability.f.a;
        r1.updateGlobalProps(com.bytedance.android.anniex.ability.f.o(this.h, null));
    L8:
        if (this.d == true) goto L11;
        this.d = true;
        com.bytedance.revenue.platform.api.core.rx.f.a(((com.bytedance.android.live.revenue.platform.container.impl.core.i) this.e.x(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revenue.platform.container.impl.core.i.class), CenterServiceType.CENTER_SERVICE)).notifyRoomState(NotifyRoomStateRequestState.ENTERED.getTag()).subscribe(h.a, i.a), this.c);
        return;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.h
    public final BehaviorSubject a() {
        return this.b;
    }

    @Override // com.bytedance.android.live.revenue.platform.container.impl.core.h
    public final void b(NotifyServiceCenterStateRequest r6) {
        Intrinsics.checkNotNullParameter(r6, "request");
        int r0 = r6.getState();
        if (r0 != NotifyServiceCenterStateRequest.State.STARTED.getTag()) goto L16;
        String r7 = r6.getServiceVersion();
        if (r7 != null) goto L7;
        r7 = getServiceVersion();
    L7:
        Intrinsics.checkNotNullParameter(r7, "value");
        l r1 = this.a;
        if (r1 == null) goto L10;
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r1.c = r7;
        this.b.onNext(r7);
    L10:
        jy0.b.d("DynamicCenterServiceManager", "center started, version is: ".concat(getServiceVersion()));
        RevenueJsDriver r8 = c();
        if (r8 == null) goto L14;
        this.f.w0(com.bytedance.revenue.platform.api.core.c.a(new String[]{"core.service.DynamicHostService"}), r8);
        return;
    L14:
        throw com.bytedance.platform.aio.d.e("update dynamic service before jsb ready, initialize failed", null);
    L16:
        if (r0 != NotifyServiceCenterStateRequest.State.SCRIPTS_LOADED.getTag()) goto L32;
        NotifyServiceCenterStateRequest.b r9 = r6.I1();
        if (r9 == null) goto L21;
        List<NotifyServiceCenterStateRequest.b.InterfaceC0090b> r10 = r9.getServices();
        if (r10 == null) goto L21;
    L22:
        List<NotifyServiceCenterStateRequest.b.InterfaceC0090b> r12 = r10;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10));
        Iterator<T> r13 = r12.iterator();
    L24:
        if (r13.hasNext() == false) goto L26;
        r2.add(((NotifyServiceCenterStateRequest.b.InterfaceC0090b) r13.next()).T1());
        goto L24
    L26:
        jy0.b.d("DynamicCenterServiceManager", "updateDynamicServices: " + r2);
        RevenueJsDriver r14 = c();
        if (r14 == null) goto L30;
        this.f.I(r2, r14);
        return;
    L30:
        throw com.bytedance.platform.aio.d.e("update dynamic service before jsb ready, initialize failed", null);
    L21:
        r10 = CollectionsKt.emptyList();
        goto L22
    L32:
        if (r0 == NotifyServiceCenterStateRequest.State.STOPPED.getTag()) goto L39;
        jy0.b.c("DynamicCenterServiceManager", "receive unknown state: " + r6.getState(), null, 4);
        return;
    }

    public DynamicCenterServiceManager(ny0.a r2, com.bytedance.android.live.revenue.platform.container.impl.core.g r3, NativeHostServiceImpl r4, Context r5, cy0.f r6) {
        Intrinsics.checkNotNullParameter(r2, "rpcService");
        Intrinsics.checkNotNullParameter(r3, "centerService");
        Intrinsics.checkNotNullParameter(r4, "nativeHostServiceImpl");
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r6, "instanceScope");
        this.e = r2;
        this.f = r3;
        this.g = r4;
        this.h = r5;
        this.i = r6;
        this.b = BehaviorSubject.create();
        this.c = new CompositeDisposable();
    }
}
