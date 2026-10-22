package com.bytedance.android.live.broadcastgame.opengame.runtime;

import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.openplatform.OpenPlatformMonitorUtils;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod;
import com.bytedance.android.live.broadcastgame.opengame.service.OpenPlatformMonitorService;
import com.bytedance.android.live.broadcastgame.opengame.service.SimplePanelStateDispatchService;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public abstract class LiveBasePluginWithPanel extends v implements SimplePanelStateDispatchService.b {
    public static final /* synthetic */ int p = 0;
    public l j;
    public Function0<Unit> k;
    public Function1<? super String, Unit> l;
    public final Lazy m;
    public final Lazy n;
    public final PluginContext o;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ LiveBasePluginWithPanel a;

        public b(LiveBasePluginWithPanel r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            com.bytedance.android.live.broadcastgame.opengame.panel.a r4 = (com.bytedance.android.live.broadcastgame.opengame.panel.a) r3;
            if (r4 == null) goto L12;
            BaseOpenMethod<R> r0 = r4.b;
            if (r0 != 0) goto L7;
            return;
        L7:
            if (r0.b != true) goto L14;
            LiveBasePluginWithPanel r1 = this.a;
            final int r5 = r4.a;
            l r2 = r1.j;
            if (r2 == null) goto L15;
            r2.r0(null, new LiveBasePluginWithPanel$setDoubleBallLoadingVisibility$1(r5));
            return;
        L15:
            return;
        L14:
            return;
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

    static {
    }

    public abstract l m();

    public boolean q() {
        return true;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.service.SimplePanelStateDispatchService.b
    public final void r0() {
    }

    public abstract void s(com.bytedance.android.live.broadcastgame.opengame.panel.h r1);

    @Override // com.bytedance.android.live.broadcastgame.opengame.service.SimplePanelStateDispatchService.b
    public final void v() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public void f() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePlugin", new Object[]{"on lifecycle: onLaunch"});
        p r1 = k();
        if (r1 == null) goto L6;
        r1.launch();
    L6:
        if (q() == true) goto L8;
    L10:
        Disposable r2 = RxUtilKt.h(xs2.b.a().b(com.bytedance.android.live.broadcastgame.opengame.panel.a.class)).subscribe(new b(this), c.a);
        Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
        this.h.a(r2);
        return;
    L8:
        if (this.j != null) goto L10;
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePluginWithPanel", new Object[]{"on lifecycle: onLaunch, init panel on launch"});
        o();
        goto L10
    }

    public final int n() {
        PluginContext r0 = this.o;
        if (r0.o == false) goto L6;
        return 1;
    L6:
        if (r0.m.d == false) goto L8;
        return 2;
    L8:
        return 3;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public void onStart() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePlugin", new Object[]{"on lifecycle: onStart"});
        this.d = false;
        p r1 = k();
        if (r1 == null) goto L6;
        r1.start();
    L6:
        if (q() == false) goto L8;
    L10:
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePluginWithPanel", new Object[]{"register panel state listener"});
        SimplePanelStateDispatchService r2 = (SimplePanelStateDispatchService) this.n.getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter(this, "listener");
        ((ArrayList) r2.a).add(this);
        return;
    L8:
        if (this.j != null) goto L10;
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePluginWithPanel", new Object[]{"on lifecycle: onStart, init panel on start"});
        o();
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public void onStop() {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePlugin", new Object[]{"on lifecycle: onStop, dispose"});
        this.h.b();
        p r1 = k();
        if (r1 == null) goto L5;
        r1.stop();
    L5:
        ((ArrayList) this.i.a).clear();
        com.bytedance.android.live.broadcastgame.opengame.openapi.y r2 = this.b;
        if (r2 == null) goto L8;
        r2.release();
    L8:
        com.bytedance.android.live.broadcastgame.opengame.i r3 = this.g.j;
        if (r3 == null) goto L11;
        r3.stopDebug();
    L11:
        l r4 = this.j;
        if (r4 == null) goto L14;
        r4.r0(null, C03071.INSTANCE);
    L14:
        InteractGameContext r5 = InteractGameContext.Companion.getContext();
        if (r5 == null) goto L20;
        com.bytedance.live.datacontext.m<Boolean> r6 = r5.getPanelShowing();
        if (r6 == null) goto L21;
        r6.setValue(Boolean.FALSE);
        return;
    L21:
        return;
    }

    public final void o() {
        this.j = m();
        this.k = LiveBasePluginWithPanel$initPanelAndHide$1.INSTANCE;
        this.l = new LiveBasePluginWithPanel$initPanelAndHide$2(this);
        l r0 = this.j;
        if (r0 == null) goto L5;
        r0.q0();
    L5:
        l r1 = this.j;
        if (r1 == null) goto L9;
        r1.r0(null, new LiveBasePluginWithPanel$initPanelAndHide$3(this));
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.v, com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public void onHide() {
        super.onHide();
        l r0 = this.j;
        if (r0 == null) goto L5;
        r0.r0(null, AnonymousClass1.INSTANCE);
    L5:
        InteractGameContext r1 = InteractGameContext.Companion.getContext();
        if (r1 == null) goto L11;
        com.bytedance.live.datacontext.m<Boolean> r2 = r1.getPanelShowing();
        if (r2 == null) goto L12;
        r2.setValue(Boolean.FALSE);
        return;
    L12:
        return;
    }

    public LiveBasePluginWithPanel(PluginContext r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        super(r2);
        this.o = r2;
        this.m = LazyKt.lazy(new LiveBasePluginWithPanel$commercialService$2(this));
        this.n = LazyKt.lazy(new LiveBasePluginWithPanel$panelRealStateService$2(this));
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public void onShow(Map<String, String> r11) {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePlugin", new Object[]{"on lifecycle: onShow"});
        this.f = System.currentTimeMillis();
        p r1 = k();
        if (r1 == null) goto L5;
        r1.l(r11);
    L5:
        OpenPlatformMonitorService r12 = (OpenPlatformMonitorService) this.g.o(OpenPlatformMonitorService.class);
        r12.a("ttlive_open_platform_panel_show", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, this.d ? 1 : 0, null, null).c();
        if (r12.e.m.o != PluginType.LYNX) goto L13;
        if (OpenPlatformMonitorUtils.a <= 0) goto L13;
        if (OpenPlatformMonitorUtils.b <= 0) goto L13;
        r12.m(System.currentTimeMillis() - OpenPlatformMonitorUtils.a);
    L13:
        if (this.j != null) goto L15;
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePluginWithPanel", new Object[]{"on lifecycle: onShow, init panel on show"});
        o();
    L15:
        l r13 = this.j;
        if ((r13 instanceof m) == true) goto L18;
        r13 = null;
    L18:
        m r14 = (m) r13;
        if (r14 == null) goto L21;
        com.bytedance.android.live.broadcastgame.opengame.q.f("LiveBasePluginWithPanel", new Object[]{"create lazy panel if not"});
        r14.a();
    L21:
        l r15 = this.j;
        if (r15 == null) goto L24;
        r15.r0(null, AnonymousClass2.INSTANCE);
    L24:
        InteractGameContext r16 = InteractGameContext.Companion.getContext();
        if (r16 == null) goto L30;
        com.bytedance.live.datacontext.m<Boolean> r17 = r16.getPanelShowing();
        if (r17 == null) goto L31;
        r17.setValue(Boolean.TRUE);
        return;
    L31:
        return;
    }

    public final void t(Function0<Unit> r3, final Function1<? super com.bytedance.android.live.broadcastgame.opengame.panel.h, Unit> r4) {
        Intrinsics.checkNotNullParameter(r4, "block");
        l r0 = this.j;
        if (r0 == null) goto L6;
        r0.r0(r3, new LiveBasePluginWithPanel$withPanel$1(r4));
        return;
    }
}
