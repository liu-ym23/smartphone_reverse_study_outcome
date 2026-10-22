package com.bytedance.android.live.recharge.panel.dynamic;

import android.content.Context;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.gift.IGiftService;
import com.bytedance.android.live.recharge.IRechargeService;
import com.bytedance.android.live.recharge.RechargeDialogFactoryImpl;
import com.bytedance.android.live.recharge.deal.dto.AioDealSetConvertersKt;
import com.bytedance.android.live.recharge.deal.i;
import com.bytedance.android.live.recharge.j;
import com.bytedance.android.live.recharge.panel.aio.IPanelProperties;
import com.bytedance.android.live.recharge.utils.k;
import com.bytedance.android.live.recharge.utils.m;
import com.bytedance.android.live.revenue.common.p0;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdkapi.eventbus.HorizontalPlayEvent;
import com.bytedance.android.scope.l;
import com.bytedance.android.scope.o;
import com.bytedance.revenue.platform.api.core.rx.h;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.videoshop.context.VideoContext;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import zg1.x2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class DynamicRechargePanelProvider implements o, d {
    public static final /* synthetic */ int h = 0;
    public final List<Function0<Unit>> a;
    public b b;
    public final com.bytedance.android.live.recharge.core.b c;
    public final com.bytedance.android.live.recharge.balance.d d;
    public final com.bytedance.android.live.recharge.nopassword.b e;
    public final com.bytedance.android.live.recharge.panel.context.e f;
    public final com.bytedance.android.livesdk.revenue.service.user.a g;

    public static final class a {
    }

    public static final class b implements Disposable {
        public final CompositeDisposable a;
        public final j b;
        public final zy0.d c;
        public final com.bytedance.android.live.recharge.panel.dynamic.b d;

        public final void dispose() {
            this.a.dispose();
        }

        public final boolean isDisposed() {
            return this.a.isDisposed();
        }

        public b(CompositeDisposable r2, com.bytedance.android.live.recharge.model.d r3, RechargeDialogFactoryImpl.a r4, zy0.d r5, g r6) {
            Intrinsics.checkNotNullParameter(r2, "cd");
            Intrinsics.checkNotNullParameter(r3, "entranceParams");
            Intrinsics.checkNotNullParameter(r4, "rechargeListener");
            Intrinsics.checkNotNullParameter(r5, "dialog");
            Intrinsics.checkNotNullParameter(r6, "panelScope");
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r6;
        }
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
        b r0 = this.b;
        if (r0 == null) goto L5;
        r0.dispose();
    L5:
        ((ArrayList) this.a).clear();
    }

    public final f J1(com.bytedance.android.live.recharge.panel.context.f r7) {
        com.bytedance.android.live.recharge.model.d r0 = r7.i;
        f r1 = new f();
        r1.a(((Number) this.d.n().getValue()).longValue());
        r1.e(r0.d);
        r1.c(r7.j);
        r1.f(this.e.B1(r0).ordinal());
        IPanelProperties r2 = vw0.f.a();
        vw0.e.a(r2, r7.f);
        Unit r3 = Unit.INSTANCE;
        r1.g(r2);
        com.bytedance.android.live.recharge.model.b r4 = r0.j;
        if (r4 == null) goto L30;
        Class r5 = c.class.getAnnotation(JsonAdapter.class).value();
        ConcurrentHashMap r6 = vh7.b.a;
        Object r8 = r6.get(r5);
        if (r8 != null) goto L14;
        r8 = r5.getConstructor(new Class[0]);
        if (r8 == null) goto L13;
        Object r9 = r6.putIfAbsent(r5, r8);
        if (r9 == null) goto L14;
        r8 = r9;
        goto L14
    L13:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L14:
        Object r10 = ((SerializableObjectJsonAdapterBase) ((Constructor) r8).newInstance(new Object[0])).createInstance();
        if (r10 == null) goto L29;
        c r12 = (c) r10;
        r12.setGiftId(r4.e);
        int r13 = k.a;
        long r14 = r4.e;
        IGiftService r15 = jc1.k.f(IGiftService.class);
        if (r15 == null) goto L22;
        h2 r16 = r15.findLiteGiftById(r14);
        if (r16 == null) goto L22;
        String r17 = r16.getName();
        if (r17 == null) goto L22;
    L23:
        r12.setGiftName(r17);
        r12.p2(r4.d);
        r12.f0(r4.c);
        r12.r3(r4.b);
        r12.m1(r4.a);
        Map<String, String> r18 = r4.g;
        if (r18 != null) goto L27;
        r18 = MapsKt.emptyMap();
    L27:
        r12.S0(r18);
        r1.d(r12);
    L22:
        r17 = "";
        goto L23
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.recharge.panel.dynamic.GiftRechargeParams");
    L30:
        r1.b(AioDealSetConvertersKt.a((i) r7.b.b));
        return r1;
    }

    @Override // com.bytedance.android.live.recharge.panel.dynamic.d
    public final Disposable l1(final Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        ((ArrayList) this.a).add(r2);
        int r0 = h.a;
        return h.a(new DynamicRechargePanelProvider$addBeforeRechargePanelDestroyListener$1(this, r2));
    }

    @Override // com.bytedance.android.live.recharge.panel.dynamic.d
    public final void m1(boolean r9) {
        Iterator r0 = ((ArrayList) this.a).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Function0) r0.next()).invoke();
        goto L4
    L6:
        p0.a(0, false, r9, new DynamicRechargePanelProvider$closeRechargePanel$1(this), 3);
    }

    @Override // com.bytedance.android.live.recharge.panel.dynamic.d
    public final zy0.d d(Context r26, com.bytedance.android.live.recharge.model.d r27, RechargeDialogFactoryImpl.a r28) {
        Intrinsics.checkNotNullParameter(r26, "context");
        Intrinsics.checkNotNullParameter(r27, "entranceParams");
        Intrinsics.checkNotNullParameter(r28, "rechargeListener");
        com.bytedance.android.live.recharge.trace.session.a r6 = new com.bytedance.android.live.recharge.trace.session.a();
        r6.d.put("panel_type", "lynx");
        if (com.bytedance.android.live.recharge.model.g.a(com.bytedance.android.live.recharge.model.g.a) == true) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(r27.b, "debug") == true) goto L63;
        Intrinsics.checkNotNullParameter(r26, "context");
        Intrinsics.checkNotNullParameter(r27, "entranceParams");
        com.bytedance.android.live.revenue.core.util.j.a r4 = com.bytedance.android.live.revenue.core.util.j.C0;
        n01.a r5 = (n01.a) com.bytedance.android.live.revenue.core.util.f.d(r4.a(), n01.a.class);
        boolean r7 = false;
        if (r5 != null) goto L10;
    L12:
        boolean r8 = false;
    L13:
        if (r8 == true) goto L15;
    L17:
        yz0.k r9 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r4.a(), yz0.k.class);
        if (r9 == null) goto L20;
        boolean r10 = r9.isPortraitInteraction();
    L21:
        if (r10 == true) goto L40;
        n01.a r12 = (n01.a) com.bytedance.android.live.revenue.core.util.f.d(r4.a(), n01.a.class);
        long r22 = ((IRechargeService) jc1.k.n(IRechargeService.class)).rechargeCenter().getAvailableDiamonds();
        xs2.b r13 = xs2.b.a();
        String r14 = r27.b;
        String r15 = r27.h;
        com.bytedance.android.live.recharge.model.b r16 = r27.j;
        if (r16 == null) goto L25;
        long r17 = r16.e;
    L26:
        if (r16 == null) goto L28;
        long r18 = r16.d;
    L29:
        if (r16 == null) goto L31;
        long r19 = r16.c;
    L32:
        long r0 = r27.d;
        if (r16 == null) goto L35;
        String r23 = r16.b;
    L36:
        r13.post(new HorizontalPlayEvent(1, "source_for_live_recharge", new x2(r14, r15, r17, r18, r19, r0, r23, r22, false)));
        int r1 = m.a;
        m.j(r27);
        if (r12 == null) goto L39;
        r12.Fm();
    L39:
        VideoContext.n0(r26).l0();
        r7 = true;
        goto L40
    L35:
        r23 = null;
        goto L36
    L31:
        r19 = 0;
        goto L32
    L28:
        r18 = 0;
        goto L29
    L25:
        r17 = 0;
    L40:
        if (r7 == false) goto L43;
        return null;
    L43:
        b r2 = this.b;
        if (r2 == null) goto L61;
        if ((!r2.isDisposed()) == true) goto L49;
        r2 = null;
    L49:
        if (r2 == null) goto L61;
        r2.c.i();
        return r2.c;
    L61:
        final b r3 = E1(r26, r27, r28, r6);     // Catch: Throwable -> L56
        this.b = r3;
        int r20 = h.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(h.a(new DynamicRechargePanelProvider$provideDynamicRechargePanel$3(this, r3)), r3.a);
        r6.c(com.bytedance.android.live.recharge.trace.session.d.a);
        return r3.c;
    L56:
        th = move-exception;
        jy0.b.b("Recharge/DynamicRechargePanelProvider", "failed to create instance", th);
        return null;
    L20:
        r10 = s1.F();
        goto L21
    L15:
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.room.b.class).Ch() == false) goto L17;
        r10 = true;
        goto L21
    L10:
        if (r5.b1() != true) goto L12;
        r8 = true;
        goto L13
    L63:
        return null;
    }

    @Override // com.bytedance.android.live.recharge.panel.dynamic.d
    public final void e0(int r2, int r3, long r4) {
        b r0 = this.b;
        if (r0 == null) goto L8;
        j r1 = r0.b;
        if (r1 == null) goto L9;
        r1.b(r2, r3, r4);
        return;
    L9:
        return;
    }

    public final b E1(Context r8, com.bytedance.android.live.recharge.model.d r9, final RechargeDialogFactoryImpl.a r10, final com.bytedance.android.live.recharge.trace.session.a r12) {
        CompositeDisposable r6 = new CompositeDisposable();
        int r0 = h.a;
        com.bytedance.revenue.platform.api.core.rx.f.a(h.a(new DynamicRechargePanelProvider$createInstance$1(r10, r12)), r6);
        String r1 = this.g.getCurrentUserId();     // Catch: Throwable -> L16
        com.bytedance.live.kmp.util.c r2 = com.bytedance.live.kmp.util.c.a;     // Catch: Throwable -> L16
        r9.n = r1 + String.valueOf(System.currentTimeMillis());     // Catch: Throwable -> L16
        com.bytedance.android.live.recharge.panel.context.f r3 = new com.bytedance.android.live.recharge.panel.context.f(r9, vw0.h.a(r9), r12, r8);     // Catch: Throwable -> L16
        r6.add(r3.a);     // Catch: Throwable -> L16
        this.f.h1(r3);     // Catch: Throwable -> L16
        com.bytedance.android.live.recharge.core.b r4 = this.c;     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r4, "scope");     // Catch: Throwable -> L16
        String r5 = "panelContext";
        Intrinsics.checkNotNullParameter(r3, "panelContext");     // Catch: Throwable -> L16
        final g r7 = new g(r4);     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r7, "scope");     // Catch: Throwable -> L16
        Intrinsics.checkNotNullParameter(r3, "value");     // Catch: Throwable -> L16
        r7.e = r3;     // Catch: Throwable -> L16
        if (r3 == e33.k.a) goto L7;
        r5 = null;
    L7:
        if (r5 != null) goto L15;
        l.a(r7);     // Catch: Throwable -> L16
        com.bytedance.revenue.platform.api.core.rx.f.a(h.a(new DynamicRechargePanelProvider$createInstance$2(r7)), r6);     // Catch: Throwable -> L16
        x0 r13 = new x0(com.bytedance.android.live.recharge.model.g.a.getScheme());     // Catch: Throwable -> L16
        r13.b("initial_data", l97.a.a.toJson(J1(r3)));     // Catch: Throwable -> L16
        cy0.e.a.getClass();     // Catch: Throwable -> L16
        cy0.j r14 = cy0.e.a.a;     // Catch: Throwable -> L16
        com.bytedance.android.scope.m.e.getClass();     // Catch: Throwable -> L16
        Object r15 = com.bytedance.android.scope.m.b(r14).a(Reflection.getOrCreateKotlinClass(vy0.b.class));     // Catch: Throwable -> L16
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L16
        HybridDialogImpl r16 = ((vy0.b) ((f80.a) r15)).U0(r8, r13.c(), new DynamicRechargePanelProvider$createInstance$dialog$1(this, r6, r12));     // Catch: Throwable -> L16
        if (r16 == null) goto L13;
        com.bytedance.revenue.platform.api.core.rx.f.a(r16, r6);     // Catch: Throwable -> L16
        return new b(r6, r9, r10, r16, r7);
    L13:
        throw new IllegalStateException("createDialogAndShowOrNull returned null".toString());     // Catch: Throwable -> L16
    L15:
        throw new UninitializedPropertyAccessException(r5);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        r6.dispose();
        throw th;
    }

    public DynamicRechargePanelProvider(com.bytedance.android.live.recharge.core.b r2, com.bytedance.android.live.recharge.balance.d r3, com.bytedance.android.live.recharge.nopassword.b r4, com.bytedance.android.live.recharge.panel.context.e r5, com.bytedance.android.livesdk.revenue.service.user.a r6) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        Intrinsics.checkNotNullParameter(r3, "walletBalanceService");
        Intrinsics.checkNotNullParameter(r4, "noPasswordService");
        Intrinsics.checkNotNullParameter(r5, "panelContextManager");
        Intrinsics.checkNotNullParameter(r6, "hostUserService");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.a = new ArrayList();
    }
}
