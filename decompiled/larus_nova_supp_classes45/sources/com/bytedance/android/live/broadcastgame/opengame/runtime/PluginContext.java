package com.bytedance.android.live.broadcastgame.opengame.runtime;

import android.content.Context;
import android.graphics.Bitmap;
import com.bytedance.android.live.broadcastgame.api.openplatform.PluginType;
import com.bytedance.android.live.broadcastgame.opengame.auth.OpenBaseAuthService;
import com.bytedance.android.live.broadcastgame.opengame.auth.OpenSonicAuthService;
import com.bytedance.android.live.broadcastgame.opengame.control.OpenPlatformControlService;
import com.bytedance.android.live.broadcastgame.opengame.message.c0;
import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import com.bytedance.android.live.broadcastgame.opengame.service.AudienceMiniGameIntroCardService;
import com.bytedance.android.live.broadcastgame.opengame.service.CommercialService;
import com.bytedance.android.live.broadcastgame.opengame.service.OpenFeatureIconStateService;
import com.bytedance.android.live.broadcastgame.opengame.service.OpenPlatformMonitorService;
import com.bytedance.android.live.broadcastgame.opengame.service.PanelStateReportService;
import com.bytedance.android.live.broadcastgame.opengame.service.PerformanceDetectionService;
import com.bytedance.android.live.broadcastgame.opengame.service.ReportService;
import com.bytedance.android.live.broadcastgame.opengame.service.SimplePanelStateDispatchService;
import com.bytedance.android.live.broadcastgame.opengame.service.TrackLynxService;
import com.bytedance.android.live.broadcastgame.opengame.service.TrackMiniGameCardService;
import com.bytedance.android.live.broadcastgame.opengame.service.TrackMiniGameService;
import com.bytedance.android.live.broadcastgame.opengame.service.base.PluginServiceImpl;
import com.bytedance.android.live.broadcastgame.opengame.sonicgame.GameCastStrategy;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.model.LinkScreenCastType;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class PluginContext implements p, com.bytedance.android.live.broadcastgame.opengame.panel.i, o {
    public static final HashSet<Class<? extends y10.a>> r = null;
    public static final HashMap<PluginType, List<Class<? extends y10.a>>> s = null;
    public k a;
    public PluginType b;
    public final Object c;
    public final HashMap<Class<?>, Class<? extends y10.a>> d;
    public final Lazy e;
    public final Map<String, Object> f;
    public com.bytedance.android.live.broadcastgame.opengame.panel.h g;
    public final Context h;
    public final DataCenter i;
    public final com.bytedance.android.live.broadcastgame.opengame.i j;
    public final q k;
    public final c0 l;
    public final com.bytedance.android.live.broadcastgame.opengame.t m;
    public final Map<String, Object> n;
    public final boolean o;
    public final boolean p;
    public final com.bytedance.android.live.pushstream.d q;

    public static final class a {
    }

    public static final class b implements com.bytedance.android.live.broadcastgame.opengame.utils.h.a {
        public final /* synthetic */ PluginContext a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ Ref.ObjectRef d;

        @Override // com.bytedance.android.live.broadcastgame.opengame.utils.h.a
        public final void onFail() {
            jc1.k.n(IInteractService.class).startLinkCast(LinkScreenCastType.CAST_TYPE_GAME, this.a.m.i, this.b, this.c, null, (String) this.d.element, false);
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.utils.h.a
        public final void onSuccess(Bitmap r11) {
            Intrinsics.checkNotNullParameter(r11, "bitmap");
            jc1.k.n(IInteractService.class).startLinkCast(LinkScreenCastType.CAST_TYPE_GAME, this.a.m.i, this.b, this.c, r11, (String) this.d.element, false);
        }

        public b(PluginContext r1, int r2, int r3, Ref.ObjectRef r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void c() {
    }

    public final ConcurrentHashMap<Class<? extends y10.a>, Object> p() {
        return (ConcurrentHashMap) this.e.getValue();
    }

    static {
        r = SetsKt.hashSetOf(new Class[]{PanelStateReportService.class, SimplePanelStateDispatchService.class, ReportService.class, BootInfoService.class, OpenFeatureIconStateService.class, PerformanceDetectionService.class, OpenPlatformMonitorService.class, OpenPlatformControlService.class, OpenBaseAuthService.class});
        s = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(PluginType.LYNX, CollectionsKt.listOf(new Class[]{TrackLynxService.class, CommercialService.class, AudienceMiniGameIntroCardService.class, TrackMiniGameCardService.class})), TuplesKt.to(PluginType.SONIC_GAME, CollectionsKt.listOf(new Class[]{TrackMiniGameService.class, CommercialService.class, AudienceMiniGameIntroCardService.class, TrackMiniGameCardService.class, OpenSonicAuthService.class}))});
    }

    public final Context i() {
        Object r0 = this.g;
        if ((r0 instanceof Context) == true) goto L5;
        r0 = null;
    L5:
        Context r1 = (Context) r0;
        if (r1 == null) goto L8;
        return r1;
    L8:
        return this.h;
    }

    public final PanelType j() {
        com.bytedance.android.live.broadcastgame.opengame.panel.h r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getPanelType();
    }

    public final k k() {
        k r0 = this.a;
        if (r0 == null) goto L6;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("plugin");
        return r0;
    L8:
        return r0;
    L6:
        return null;
    }

    public final PluginType m() {
        PluginType r0 = this.b;
        if (r0 == null) goto L5;
        return r0;
    L5:
        PluginType.a r1 = PluginType.Companion;
        String r2 = this.m.n;
        r1.getClass();
        PluginType r3 = PluginType.a.a(r2);
        this.b = r3;
        return r3;
    }

    public final Room n() {
        DataCenter r0 = this.i;
        if (r0 != null) goto L5;
        return null;
    L5:
        return (Room) r0.get("data_room", null);
    }

    public final boolean r() {
        g r0 = this.m.l;
        if (r0 == null) goto L28;
        j r1 = r0.b;
        if (r1 == null) goto L29;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a> r2 = r1.a;
        if (r2 == null) goto L30;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a> r3 = r2;
        if ((r3 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r4 = r3.iterator();
    L15:
        if (r4.hasNext() == false) goto L19;
        if (((com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a) r4.next()).c().equals("doScreencast") == false) goto L15;
        boolean r5 = true;
    L20:
        if (r5 == true) goto L22;
        return false;
    L22:
        if (s() == false) goto L32;
        return true;
    L32:
        return false;
    L19:
        r5 = false;
        goto L20
    L11:
        if (r3.isEmpty() == false) goto L13;
    L30:
        return false;
    L29:
        return false;
    L28:
        return false;
    }

    public final boolean s() {
        IInteractService r0 = jc1.k.f(IInteractService.class);
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.isCurrentSceneSupportShowCastEntrance());
    L7:
        if (this.o == true) goto L9;
    L15:
        return false;
    L9:
        if (PadConfigUtils.a() == true) goto L15;
        if (tb1.c.a == false) goto L15;
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L15;
        return true;
    L5:
        r1 = null;
        goto L7
    }

    public final void v() {
        if (this.o == true) goto L5;
        return;
    L5:
        PanelType r0 = j();
        if (r0 == null) goto L8;
        int r5 = r0.getWidth();
    L9:
        PanelType r1 = j();
        if (r1 == null) goto L12;
        int r6 = r1.getHeight();
    L13:
        com.bytedance.android.live.broadcastgame.api.model.u r2 = this.m.e();
        if (r2 == null) goto L16;
        List<String> r3 = r2.iconUrl;
    L17:
        Ref.ObjectRef r4 = new Ref.ObjectRef();
        r4.element = "";
        if (r3 != null) goto L20;
    L22:
        if (r5 == 0) goto L25;
        if (r6 == 0) goto L25;
        int r7 = com.bytedance.android.live.broadcastgame.opengame.utils.h.a;
        com.bytedance.android.live.broadcastgame.opengame.utils.h.a(this.m.i, r5, r6, new b(this, r5, r6, r4));
        return;
    L25:
        jc1.k.n(IInteractService.class).startLinkCast(LinkScreenCastType.CAST_TYPE_GAME, this.m.i, r5, r6, null, (String) r4.element, false);
        return;
    L20:
        if ((!r3.isEmpty()) == false) goto L22;
        r4.element = (String) ListProtector.get(r3, 0);
        goto L22
    L16:
        r3 = null;
        goto L17
    L12:
        r6 = 0;
        goto L13
    L8:
        r5 = 0;
        goto L9
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void a() {
        Collection<Object> r0 = p().values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof com.bytedance.android.live.broadcastgame.opengame.panel.i) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((com.bytedance.android.live.broadcastgame.opengame.panel.i) r4.next()).a();
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void b() {
        Collection<Object> r0 = p().values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof com.bytedance.android.live.broadcastgame.opengame.panel.i) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((com.bytedance.android.live.broadcastgame.opengame.panel.i) r4.next()).b();
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.o
    public final void e() {
        Collection<Object> r0 = p().values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof o) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((o) r4.next()).e();
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.o
    public final void f() {
        Collection<Object> r0 = p().values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof o) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((o) r4.next()).f();
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void hide() {
        Collection<Object> r0 = p().values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof p) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((p) r4.next()).hide();
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void launch() {
        Collection<Object> r0 = p().values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof p) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((p) r4.next()).launch();
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void onBackPressed() {
        Collection<Object> r0 = p().values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof com.bytedance.android.live.broadcastgame.opengame.panel.i) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((com.bytedance.android.live.broadcastgame.opengame.panel.i) r4.next()).onBackPressed();
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
    public final void onPanelCancel() {
        Collection<Object> r0 = p().values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof com.bytedance.android.live.broadcastgame.opengame.panel.i) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((com.bytedance.android.live.broadcastgame.opengame.panel.i) r4.next()).onPanelCancel();
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void start() {
        Collection<Object> r0 = p().values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof p) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((p) r4.next()).start();
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void stop() {
        Collection<Object> r0 = p().values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof p) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((p) r4.next()).stop();
        goto L10
    }

    public final Context getContext() {
        return this.h;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.o
    public final void d(com.bytedance.android.live.broadcastgame.api.openplatform.a r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        Collection<Object> r0 = p().values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof o) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((o) r4.next()).d(r5);
        goto L10
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void fail(String r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        Collection<Object> r0 = p().values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof p) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((p) r4.next()).fail(r5);
        goto L10
    }

    public final <T> T g(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        T r3 = (T) ((LinkedHashMap) this.f).get(r2);
        if ((r3 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r3;
    }

    public final GameCastStrategy h(boolean r2) {
        int r0 = com.bytedance.android.live.broadcastgame.opengame.sonicgame.e.a;
        return com.bytedance.android.live.broadcastgame.opengame.sonicgame.e.a(r2, this.i);
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void l(Map<String, String> r5) {
        Collection<Object> r0 = p().values();
        ArrayList r1 = new ArrayList();
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Object r3 = r2.next();
        if ((r3 instanceof p) == false) goto L4;
        r1.add(r3);
        goto L4
    L8:
        Iterator r4 = r1.iterator();
    L10:
        if (r4.hasNext() == false) goto L12;
        ((p) r4.next()).l(r5);
        goto L10
    }

    public final <T extends y10.a> T o(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "service");
        Class<T> r0 = (Class) this.d.get(r3);
        if (r0 == null) goto L7;
        r3 = r0;
    L7:
        if (p().containsKey(r3) == false) goto L14;
        Object r4 = p().get(r3);
        if (r4 == null) goto L13;
        return (T) r4;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type T");
    L14:
        t(r3);
        Object r5 = p().get(r3);
        if (r5 == null) goto L19;
        return (T) r5;
    L19:
        throw new NullPointerException("null cannot be cast to non-null type T");
    }

    public final <T extends y10.a> void q(Class<T> r5) {
        Annotation[] r0 = r5.getAnnotations();
        int r1 = r0.length;
    L3:
        r1 = r1 - 1;
        if (r1 < 0) goto L8;
        Annotation r2 = r0[r1];
        if ((r2 instanceof PluginServiceImpl) == false) goto L3;
    L9:
        if (r2 != null) goto L11;
    L23:
        t(r5);
        return;
    L11:
        if ((r2 instanceof PluginServiceImpl) == false) goto L23;
        if (this.o == false) goto L15;
    L18:
        Class<? extends y10.a> r3 = ((PluginServiceImpl) r2).anchorService();
    L20:
        if (r5.isAssignableFrom(r3) == true) goto L22;
        ALogger.e("PluginContext", r3.getCanonicalName() + " is no a subClass for " + r5.getCanonicalName());
        return;
    L22:
        this.d.put(r5, r3);
        t(r3);
        return;
    L15:
        if (this.p == true) goto L18;
        r3 = ((PluginServiceImpl) r2).audienceService();
        goto L20
    L8:
        r2 = null;
        goto L9
    }

    public final <T extends y10.a> void t(Class<T> r7) {
        if (p().containsKey(r7) == false) goto L5;
        return;
    L5:
        Object r0 = this.c;
        monitor-enter(r0);
        ConcurrentHashMap<Class<? extends y10.a>, Object> r1 = p();     // Catch: Throwable -> L14
        T r2 = r7.getConstructor(new Class[]{PluginContext.class}).newInstance(new Object[]{this});     // Catch: Throwable -> L14
        if (r2 == null) goto L13;
        T r3 = r2;     // Catch: Throwable -> L14
        r3.g();     // Catch: Throwable -> L14
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L14
        r1.put(r7, r3);     // Catch: Throwable -> L14
        monitor-exit(r0);
        return;
    L13:
        throw new NullPointerException("null cannot be cast to non-null type T");     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final void u(String r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        this.f.put(r2, r3);
    }

    public PluginContext(Context r2, DataCenter r3, com.bytedance.android.live.broadcastgame.opengame.i r4, q r5, c0 r6, com.bytedance.android.live.broadcastgame.opengame.t r7, Map<String, ? extends Object> r8, boolean r9, boolean r11, com.bytedance.android.live.pushstream.d r12) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "runtime");
        Intrinsics.checkNotNullParameter(r7, "pluginInfo");
        Intrinsics.checkNotNullParameter(r8, "params");
        this.h = r2;
        this.i = r3;
        this.j = r4;
        this.k = r5;
        this.l = r6;
        this.m = r7;
        this.n = r8;
        this.o = r9;
        this.p = r11;
        this.q = r12;
        this.c = new Object();
        this.d = new HashMap();
        this.e = LazyKt.lazy(PluginContext$servicePool$2.INSTANCE);
        new LinkedHashMap();
        this.f = new LinkedHashMap();
        Iterator<T> r13 = r.iterator();
    L4:
        if (r13.hasNext() == false) goto L6;
        q((Class) r13.next());
        goto L4
    L6:
        List<Class<? extends y10.a>> r14 = s.get(m());
        if (r14 == null) goto L17;
        Iterator<T> r15 = r14.iterator();
    L10:
        if (r15.hasNext() == false) goto L25;
        Class<? extends y10.a> r16 = (Class) r15.next();
        q(r16);
        Iterator<T> r17 = r.iterator();
    L13:
        if (r17.hasNext() == false) goto L10;
        Class<?> r18 = (Class) r17.next();
        if (r18.isAssignableFrom(r16) == false) goto L13;
        this.d.put(r18, r16);
        goto L13
    L25:
        return;
    }
}
