package com.bytedance.android.live.broadcastgame.opengame.lynx;

import android.content.Context;
import android.net.Uri;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.collection.LruCache;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.broadcastgame.api.AnchorGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.j;
import com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod;
import com.bytedance.android.live.broadcastgame.opengame.openapi.g0;
import com.bytedance.android.live.broadcastgame.opengame.openapi.y;
import com.bytedance.android.live.broadcastgame.opengame.panel.PanelType;
import com.bytedance.android.live.broadcastgame.opengame.panel.i;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.broadcastgame.opengame.runtime.BootInfoService;
import com.bytedance.android.live.broadcastgame.opengame.runtime.LaunchMode;
import com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.l;
import com.bytedance.android.live.broadcastgame.opengame.runtime.n;
import com.bytedance.android.live.broadcastgame.opengame.service.OpenPlatformMonitorService;
import com.bytedance.android.live.broadcastgame.opengame.t;
import com.bytedance.android.live.browser.IBrowserService;
import com.bytedance.android.live.browser.LynxThreadStrategy;
import com.bytedance.android.live.browser.d0;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.android.livesdk.config.a4;
import com.bytedance.android.livesdk.config.pc1;
import com.bytedance.android.livesdk.config.yd0;
import com.bytedance.android.livesdkapi.util.WeakReferenceWrapper;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.live.livecontainer.base.schema.LiveSchemaInfo;
import com.bytedance.bdp.serviceapi.hostimpl.info.BdpInfoService;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.live.datacontext.k;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.lynx.tasm.LynxView;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.WeakHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class LynxOpenPlugin extends LiveBasePluginWithPanel implements x7a.f {
    public static final /* synthetic */ int E = 0;
    public final j A;
    public final f B;
    public final b C;
    public final PluginContext D;
    public n q;
    public com.bytedance.android.live.lynx.api.d r;
    public final Stack<com.bytedance.android.live.lynx.api.d> s;
    public String t;
    public String u;
    public String v;
    public boolean w;
    public long x;
    public boolean y;
    public com.bytedance.android.live.broadcastgame.opengame.panel.h z;

    public static final class a {
    }

    public static final class b implements ra4.a.a {
        public final /* synthetic */ LynxOpenPlugin a;

        public b(LynxOpenPlugin r1) {
            this.a = r1;
        }

        public final void a(String r8, String r9) {
            Intrinsics.checkNotNullParameter(r8, "stage");
            if (r9 != null) goto L5;
            String r1 = IInteractGameMonitorService.ERROR_MSG_COMMON_UNKNOWN;
        L6:
            new Throwable(r1);
            System.currentTimeMillis();
            long r0 = this.a.x;
            int r2 = ra4.a.a;
            if (Intrinsics.areEqual(r8, "parse_params") == false) goto L9;
        L17:
            int r3 = 1;
        L18:
            OpenPlatformMonitorService r4 = (OpenPlatformMonitorService) this.a.D.o(OpenPlatformMonitorService.class);
            Integer r5 = Integer.valueOf(r3);
            r4.a("ttlive_open_platform_resource_download", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 1, r5, r9).c();
            LynxOpenPlugin r6 = this.a;
            n r7 = r6.q;
            if (r7 == null) goto L22;
            r7.n(r6.D.m.i, r9, r8);
            return;
        L22:
            return;
        L9:
            if (Intrinsics.areEqual(r8, "fetch_info") == true) goto L17;
            if (Intrinsics.areEqual(r8, "download") == false) goto L15;
            r3 = 2;
            goto L18
        L15:
            if (Intrinsics.areEqual(r8, "active") == false) goto L17;
            r3 = 3;
            goto L18
        L5:
            r1 = r9;
            goto L6
        }
    }

    public static final class c implements i {
        public final /* synthetic */ LynxOpenPlugin a;

        @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
        public final void a() {
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
        public final void c() {
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
        public final void b() {
            com.bytedance.android.live.lynx.api.d r0 = this.a.r;
            if (r0 == null) goto L5;
            r0.release();
        L5:
            Iterator<T> r1 = this.a.s.iterator();
        L7:
            if (r1.hasNext() == false) goto L9;
            ((com.bytedance.android.live.lynx.api.d) r1.next()).release();
            goto L7
        L9:
            com.bytedance.android.live.broadcastgame.opengame.panel.h r2 = this.a.z;
            if (r2 == null) goto L14;
            ViewGroup r3 = r2.getContentView();
            if (r3 == null) goto L14;
            r3.removeAllViews();
        L14:
            y r4 = this.a.b;
            if (r4 == null) goto L19;
            r4.release();
            return;
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
        public final void onBackPressed() {
            this.a.D.k.a();
            if (this.a.s.size() != 0) goto L8;
            com.bytedance.android.live.broadcastgame.opengame.panel.h r0 = this.a.z;
            if (r0 == null) goto L9;
            r0.p(0);
            return;
        L9:
            return;
        }

        @Override // com.bytedance.android.live.broadcastgame.opengame.panel.i
        public final void onPanelCancel() {
            this.a.D.k.a();
            if (this.a.s.size() != 0) goto L8;
            com.bytedance.android.live.broadcastgame.opengame.panel.h r0 = this.a.z;
            if (r0 == null) goto L9;
            r0.p(0);
            return;
        L9:
            return;
        }

        public c(LynxOpenPlugin r1) {
            this.a = r1;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LynxOpenPlugin a;

        public d(LynxOpenPlugin r1) {
            this.a = r1;
        }

        public final void accept(Object r15) {
            File r16 = (File) r15;
            File r17 = this.a.D.m.m;
            if (r17 != null) goto L5;
        L29:
            UtilityKotlinExtentionsKt.s(0, false, false, new LynxOpenPlugin$onStart$3$2(this), 7);
            return;
        L5:
            if (r17.exists() != true) goto L29;
            final File r3 = this.a.D.m.m;
            if (r3 == null) goto L36;
            final Ref.ObjectRef r5 = new Ref.ObjectRef();
            String r18 = "";
            r5.element = "";
            final Ref.ObjectRef r4 = new Ref.ObjectRef();
            com.bytedance.android.live.broadcastgame.opengame.lynx.b.C0063b r1 = null;
            r4.element = null;
            final Ref.ObjectRef r2 = new Ref.ObjectRef();
            r2.element = null;
            int r6 = com.bytedance.android.live.broadcastgame.opengame.utils.j.a;
            Intrinsics.checkNotNullParameter(r3, "res");
            com.bytedance.android.live.broadcastgame.opengame.lynx.b r7 = com.bytedance.android.live.broadcastgame.opengame.utils.j.c(FilesKt.resolve(r3, "config.json"));
            if (r7 == null) goto L28;
            Intrinsics.checkNotNullParameter(r7, "entity");
            Intrinsics.checkNotNullParameter("index", "pageAlias");
            Iterator<T> r8 = r7.a.iterator();
        L12:
            if (r8.hasNext() == false) goto L21;
            T r11 = r8.next();
            com.bytedance.android.live.broadcastgame.opengame.lynx.b.C0063b r12 = (com.bytedance.android.live.broadcastgame.opengame.lynx.b.C0063b) r11;
            if (Intrinsics.areEqual(r12.getType(), "panel") == true) goto L16;
        L18:
            boolean r13 = false;
        L19:
            if (r13 == false) goto L12;
            r1 = r11;
            goto L21
        L16:
            if (Intrinsics.areEqual(r12.b, "index") == false) goto L18;
            r13 = true;
        L21:
            com.bytedance.android.live.broadcastgame.opengame.lynx.b.C0063b r9 = r1;
            if (r9 == null) goto L27;
            String r0 = r9.c;
            if (r0 == null) goto L27;
            r18 = r0;
        L27:
            r5.element = r18;
            int r19 = com.bytedance.android.live.broadcastgame.opengame.utils.j.a;
            Intrinsics.checkNotNullParameter(r7, "entity");
            r4.element = r7.b;
            r2.element = com.bytedance.android.live.broadcastgame.opengame.utils.j.b(FilesKt.resolve(r3, (String) r5.element).getAbsolutePath());
        L28:
            UtilityKotlinExtentionsKt.s(0, false, false, new LynxOpenPlugin$onStart$3$$special$$inlined$let$lambda$1(r2, r3, r4, r5, this), 7);
            return;
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
            Throwable r2 = (Throwable) r1;
        }
    }

    public static final class f extends d0 {
        public final /* synthetic */ LynxOpenPlugin a;

        @Override // com.bytedance.android.live.browser.d0
        public final void a() {
            com.bytedance.android.live.broadcastgame.opengame.panel.h r0 = this.a.z;
            if (r0 == null) goto L5;
            r0.V(false);
        L5:
            Function1<? super String, Unit> r1 = this.a.l;
            if (r1 == null) goto L8;
            Unit r2 = (Unit) r1.invoke("lynx panel load fail");
        L8:
            com.bytedance.android.live.broadcastgame.opengame.panel.h r3 = this.a.z;
            if (r3 == null) goto L11;
            r3.L0();
        L11:
            this.a.getClass();
            ((OpenPlatformMonitorService) this.a.D.o(OpenPlatformMonitorService.class)).a("ttlive_open_platform_resource_load", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 1, null, null).c();
        }

        public f(LynxOpenPlugin r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.browser.d0
        public final void b(LynxView r2) {
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            Intrinsics.checkNotNullParameter(r2, "lynxView");
            ((OpenPlatformMonitorService) this.a.D.o(OpenPlatformMonitorService.class)).e();
            int r3 = q.a;
            q.g("on first srceen of root lynx view", "");
            com.bytedance.android.live.broadcastgame.opengame.panel.h r4 = this.a.z;
            if (r4 != null) goto L5;
            return;
        L5:
            if (r4.isShowing() != true) goto L9;
            this.a.G();
            return;
        }

        @Override // com.bytedance.android.live.browser.d0
        public final void d(View r7) {
            Intrinsics.checkNotNullParameter(r7, "lynxView");
            Intrinsics.checkNotNullParameter(r7, "lynxView");
            com.bytedance.android.live.broadcastgame.opengame.panel.h r8 = this.a.z;
            if (r8 == null) goto L5;
            r8.V(true);
        L5:
            com.bytedance.android.live.broadcastgame.opengame.panel.h r9 = this.a.z;
            if (r9 == null) goto L8;
            r9.i();
        L8:
            Function0<Unit> r11 = this.a.k;
            if (r11 == null) goto L11;
            Unit r12 = (Unit) r11.invoke();
        L11:
            this.a.getClass();
            ((OpenPlatformMonitorService) this.a.D.o(OpenPlatformMonitorService.class)).a("ttlive_open_platform_resource_load", LiveTracingMonitor.EventType.BUSSINESS_API_CALL, 0, null, null).c();
        }
    }

    static {
    }

    public final void A() {
        if ((!this.s.isEmpty()) == false) goto L10;
        LynxView r0 = this.s.peek().getLynxView();
        if ((r0 instanceof LynxView) == true) goto L7;
        r0 = null;
    L7:
        if (r0 == null) goto L11;
        D(r0);
        int r1 = q.a;
        q.g("lyxn 栈顶子页面 进入后台", "");
        return;
    L11:
        return;
    }

    public final void B() {
        if ((!this.s.isEmpty()) == false) goto L13;
        LynxView r0 = this.s.peek().getLynxView();
        if ((r0 instanceof LynxView) == true) goto L7;
        r0 = null;
    L7:
        if (r0 != null) goto L9;
        return;
    L9:
        if (((Boolean) a4.a.getValue()).booleanValue() == false) goto L11;
        r0.onEnterForeground();
    L11:
        int r1 = q.a;
        q.g("lyxn 栈顶子页面 进入前台", "");
        return;
    }

    public final void E() {
        com.bytedance.android.live.lynx.api.d r0 = this.r;
        LynxView r1 = null;
        if (r0 == null) goto L5;
        LynxView r2 = r0.getLynxView();
    L7:
        if ((r2 instanceof LynxView) == false) goto L10;
        r1 = r2;
    L10:
        if (r1 == null) goto L12;
        D(r1);
    L12:
        int r3 = q.a;
        q.g("root lynx view enter background", "");
        return;
    L5:
        r2 = null;
        goto L7
    }

    public final void G() {
        if (this.s.isEmpty() == false) goto L18;
        com.bytedance.android.live.lynx.api.d r0 = this.r;
        LynxView r1 = null;
        if (r0 == null) goto L7;
        LynxView r2 = r0.getLynxView();
    L9:
        if ((r2 instanceof LynxView) == false) goto L12;
        r1 = r2;
    L12:
        if (r1 != null) goto L14;
    L16:
        int r3 = q.a;
        q.g("root lynx view enter foreground", "");
        return;
    L14:
        if (((Boolean) a4.a.getValue()).booleanValue() == false) goto L16;
        r1.onEnterForeground();
        goto L16
    L7:
        r2 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel
    public final l m() {
        return new LynxOpenPlugin$createOpenPanelFactory$1(this);
    }

    public final void quit() {
        if (this.s.size() > 0) goto L6;
        this.D.k.a();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.service.SimplePanelStateDispatchService.b
    public final void s0() {
        int r0 = q.a;
        q.f("LynxOpenPlugin", new Object[]{"on panel real show"});
        if (this.s.isEmpty() == false) goto L5;
        G();
    L5:
        B();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.service.SimplePanelStateDispatchService.b
    public final void t0() {
        int r0 = q.a;
        q.f("LynxOpenPlugin", new Object[]{"on panel real hide"});
        E();
        A();
    }

    public final Map<String, Object> x() {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("startMode", Integer.valueOf(n()));
        return r0;
    }

    public final void y() {
        this.r = w(this.D.m, this.B, true);
        com.bytedance.android.live.broadcastgame.opengame.panel.h r0 = this.z;
        LynxView r1 = null;
        if (r0 == null) goto L5;
        ViewGroup r2 = r0.getContentView();
    L6:
        if (r2 == null) goto L8;
        r2.removeAllViews();
    L8:
        if (r2 == null) goto L14;
        com.bytedance.android.live.lynx.api.d r3 = this.r;
        if (r3 == null) goto L12;
        r1 = r3.getLynxView();
    L12:
        r2.addView(r1);
        return;
    L14:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel, com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public final void f() {
        super.f();
        this.w = true;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel, com.bytedance.android.live.broadcastgame.opengame.runtime.v, com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public final void onHide() {
        super.onHide();
        if (this.w == true) goto L5;
        return;
    L5:
        if (this.c == false) goto L13;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r0 = AnchorGameContext.a.a();
        if (r0 == null) goto L14;
        k<Boolean> r1 = r0.getOpenGameTestFloatBall();
        if (r1 == null) goto L15;
        r1.post(Boolean.TRUE);
        return;
    L15:
        return;
    L14:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel, com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public final void onStart() {
        super.onStart();
        if (this.D.m.l != null) goto L6;
        l("boot info must not null");
        return;
    L6:
        x7a.g r0 = x7a.g.d;
        r0.getClass();
        x7a.d r1 = new x7a.d(this, r0.c);
        r0.a.push(r1);
        ((WeakHashMap) r0.b).put(this, r1);
        if (this.a == LaunchMode.FROM_DEBUG) goto L22;
        Disposable r2 = Observable.just(this.D.m.m).subscribeOn(Schedulers.io()).subscribe(new d(this), e.a);
        Intrinsics.checkNotNullParameter(r2, "$this$autoDispose");
        this.h.a(r2);
        return;
    L22:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L10
        Object r4 = Result.constructor-impl(UriProtector.parse(this.D.m.n));     // Catch: Throwable -> L10
    L13:
        if (Result.isFailure-impl(r4) == false) goto L15;
        r4 = null;
    L15:
        Uri r5 = (Uri) r4;
        if (r5 == null) goto L24;
        j r6 = this.A;
        if (r6 == null) goto L25;
        r6.b(r5, new LynxOpenPlugin$onStart$$inlined$let$lambda$1(this));
        return;
    L25:
        return;
    L24:
        return;
    L10:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel, com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public final void onStop() {
        super.onStop();
        this.y = true;
        y r0 = this.b;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        com.bytedance.android.live.lynx.api.d r1 = this.r;
        if (r1 == null) goto L8;
        r1.release();
    L8:
        Iterator<T> r2 = this.s.iterator();
    L10:
        if (r2.hasNext() == false) goto L12;
        ((com.bytedance.android.live.lynx.api.d) r2.next()).release();
        goto L10
    L12:
        j r3 = this.A;
        if (r3 == null) goto L15;
        r3.a();
    L15:
        x7a.g r4 = x7a.g.d;
        x7a.d r5 = (x7a.d) ((WeakHashMap) r4.b).remove(this);
        if (r5 == null) goto L36;
        Iterator r6 = r5.b.iterator();
    L19:
        if (r6.hasNext() == false) goto L21;
        x7a.h r7 = (x7a.h) r6.next();
        r5.d.remove(r7);
        goto L19
    L21:
        r5.b.clear();
        HashMap r8 = r5.c;
        if (r8 == null) goto L24;
        r8.clear();
    L24:
        Iterator r9 = r4.a.iterator();
    L26:
        if (r9.hasNext() == false) goto L37;
        if (r9.next() != r5) goto L26;
        r9.remove();
        return;
    L37:
        return;
    }

    public LynxOpenPlugin(PluginContext r2) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        super(r2);
        this.D = r2;
        this.s = new Stack();
        com.bytedance.android.live.broadcastgame.opengame.i r3 = r2.j;
        if ((r3 instanceof j) == true) goto L5;
        r3 = null;
    L5:
        this.A = (j) r3;
        this.B = new f(this);
        this.C = new b(this);
    }

    public static void D(LynxView r1) {
        if (((Boolean) a4.a.getValue()).booleanValue() == false) goto L6;
        r1.onEnterBackground();
        return;
    }

    public final void a(LynxView r4) {
        if (r4 == null) goto L12;
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-1, -1);
        Slide r1 = new Slide(80);
        com.bytedance.android.live.broadcastgame.opengame.panel.h r2 = this.z;
        if (r2 == null) goto L6;
        ViewGroup r3 = r2.getContentView();
    L7:
        TransitionManager.beginDelayedTransition(r3, r1);
        com.bytedance.android.live.broadcastgame.opengame.panel.h r5 = this.z;
        if (r5 == null) goto L12;
        ViewGroup r6 = r5.getContentView();
        if (r6 == null) goto L12;
        r6.addView(r4, r0);
        goto L12
    L6:
        r3 = null;
    L12:
        com.bytedance.android.live.broadcastgame.opengame.panel.h r7 = this.z;
        if (r7 == null) goto L16;
        r7.p(8);
        return;
    }

    public final void d(LynxView r3) {
        if (r3 == null) goto L16;
        com.bytedance.android.live.broadcastgame.opengame.panel.h r0 = this.z;
        if (r0 == null) goto L6;
        r0.i();
    L6:
        Slide r1 = new Slide(80);
        com.bytedance.android.live.broadcastgame.opengame.panel.h r2 = this.z;
        if (r2 == null) goto L9;
        ViewGroup r4 = r2.getContentView();
    L10:
        TransitionManager.beginDelayedTransition(r4, r1);
        D(r3);
        int r5 = q.a;
        q.g("lynx 子页面 进入后台（dismissLynxView)", "");
        com.bytedance.android.live.broadcastgame.opengame.panel.h r6 = this.z;
        if (r6 == null) goto L16;
        ViewGroup r7 = r6.getContentView();
        if (r7 == null) goto L16;
        r7.removeView(r3);
        goto L16
    L9:
        r4 = null;
    L16:
        if (this.s.size() <= 0) goto L22;
        com.bytedance.android.live.lynx.api.d r8 = this.s.pop();
        y r9 = this.b;
        if (r9 == null) goto L20;
        r9.b(r8);
    L20:
        r8.release();
        B();
    L22:
        if (this.s.size() != 0) goto L28;
        com.bytedance.android.live.broadcastgame.opengame.panel.h r11 = this.z;
        if (r11 == null) goto L26;
        r11.p(0);
    L26:
        G();
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel, com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public final void onShow(Map<String, String> r2) {
        super.onShow(r2);
        if (this.s.size() != 0) goto L8;
        com.bytedance.android.live.broadcastgame.opengame.panel.h r3 = this.z;
        if (r3 == null) goto L8;
        r3.p(0);
    L8:
        if (this.w == true) goto L10;
        return;
    L10:
        if (this.c == false) goto L18;
        AnchorGameContext.Companion.getClass();
        AnchorGameContext r4 = AnchorGameContext.a.a();
        if (r4 == null) goto L19;
        k<Boolean> r5 = r4.getOpenGameTestFloatBall();
        if (r5 == null) goto L20;
        r5.post(Boolean.FALSE);
        return;
    L20:
        return;
    L19:
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.LiveBasePluginWithPanel
    public final void s(com.bytedance.android.live.broadcastgame.opengame.panel.h r4) {
        Intrinsics.checkNotNullParameter(r4, "panel");
        int r0 = q.a;
        q.f("LynxOpenPlugin", new Object[]{"on panel create"});
        this.z = r4;
        r4.registerListener(new c(this));
    }

    public static void H(Map r1, int r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TypeIntrinsics.isMutableMap(r1) == false) goto L8;
        r1.put("ERROR_CODE", Integer.valueOf(r2));
        return;
    }

    public static final void u(LynxOpenPlugin r2, String r3) {
        r2.getClass();
        if (Intrinsics.areEqual(r3, GamePromoteDataContext.GAME_TYPE_MOBILE) == false) goto L19;
        com.bytedance.android.live.broadcastgame.opengame.runtime.g r4 = ((BootInfoService) r2.D.o(BootInfoService.class)).c();
        if (r4 == null) goto L16;
        com.bytedance.android.live.broadcastgame.opengame.runtime.j r5 = r4.b;
        if (r5 == null) goto L16;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a> r6 = r5.a;
        if (r6 == null) goto L16;
        Iterator<T> r7 = r6.iterator();
    L12:
        if (r7.hasNext() == false) goto L16;
        if (Intrinsics.areEqual(((com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a) r7.next()).c(), "heightPanel") == false) goto L12;
        boolean r8 = true;
    L17:
        if (r8 == false) goto L19;
        PanelType r9 = PanelType.PANEL_TYPE_X_SCREEN;
    L20:
        Intrinsics.checkNotNullParameter(r9, "<set-?>");
        com.bytedance.android.live.broadcastgame.opengame.panel.h r11 = r2.z;
        if (r11 == null) goto L27;
        r11.r(r9);
        return;
    L27:
        return;
    L16:
        r8 = false;
    L19:
        r9 = PanelType.PANEL_TYPE_X_SCREEN_LOW;
        goto L20
    }

    public final void j(x7a.h r6, x7a.c r7) {
        t r0 = this.D.m;
        String r1 = r6.b;
        boolean r2 = false;
        if (r1 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        return;
    L11:
        int r4 = this.s.size() + 1;
        yd0 r5 = yd0.a;
        if (r5 == null) goto L16;
        pc1 r8 = (pc1) r5.getValue();
        if (r8 == null) goto L16;
        int r9 = r8.a();
    L17:
        if (r4 < r9) goto L20;
        H(r6.c, BaseOpenMethod.g);
        return;
    L20:
        com.bytedance.android.live.broadcastgame.opengame.panel.h r11 = this.z;
        if (r11 == null) goto L23;
        r11.h();
    L23:
        com.bytedance.android.live.lynx.api.d r12 = w(r0, null, false);
        r12.e(new LynxOpenPlugin$createLynxView$1(this, r7, r12));
        String r13 = this.t;
        if (r13 != null) goto L26;
    L27:
        r2 = true;
    L28:
        if (r2 == false) goto L31;
        Observable.just(r0.m).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.live.broadcastgame.opengame.lynx.c(this, r6, r12), com.bytedance.android.live.broadcastgame.opengame.lynx.d.a);
        return;
    L31:
        if (Intrinsics.areEqual(r6.b, "introduce") == false) goto L34;
        Observable.just(1).subscribeOn(Schedulers.io()).subscribe(new com.bytedance.android.live.broadcastgame.opengame.lynx.f(this, r6, r12), g.a);
        return;
    L34:
        r12.c(Intrinsics.stringPlus(r6.b, "/template.js"), this.t + r6.b + "/template.js", x());
        return;
    L26:
        if (r13.length() != 0) goto L28;
    L16:
        r9 = 10;
        goto L17
    L5:
        if (r1.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public final <T> void sendEvent(String r3, T r4) {
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r4, "data");
        com.bytedance.android.live.lynx.api.d r0 = this.r;
        if (r0 == null) goto L5;
        r0.sendJsEvent(r3, r4);
    L5:
        Iterator<com.bytedance.android.live.lynx.api.d> r1 = this.s.iterator();
    L7:
        if (r1.hasNext() == false) goto L11;
        com.bytedance.android.live.lynx.api.d r2 = r1.next();
        if (r2 == null) goto L7;
        r2.sendJsEvent(r3, r4);
        goto L7
    }

    public final com.bytedance.android.live.lynx.api.d w(t r11, f r12, boolean r13) {
        int r2 = UIUtils.getScreenWidth(this.D.getContext());
        String r14 = this.t;
        if (r14 != null) goto L5;
    L8:
        boolean r15 = true;
    L9:
        if (r15 == true) goto L11;
        com.bytedance.android.live.lynx.api.d r16 = ((IBrowserService) jc1.k.n(IBrowserService.class)).mo462createOpenLynxComponent(this.D.getContext(), r2, LynxThreadStrategy.ALL_ON_UI, r12, this.t);
    L16:
        y r17 = this.b;
        if (r17 == null) goto L19;
        String r1 = r11.i;
        PluginContext r0 = this.D;
        r17.a(r16, new g0(r1, r0.m.a, r0.getContext(), this.a, r11.h, r11.b(this.c)));
    L19:
        r16.a();
        r16.b(OpenPlatformBaseDebugger.APP_ID, r11.i);
        r16.b("app_name", r11.b(this.c));
        r16.b("is_anchor", Boolean.valueOf(this.c));
        u r18 = r11.e();
        if (r18 == null) goto L22;
        Object r19 = Integer.valueOf(r18.interactId);
    L23:
        r16.b("game_type", r19);
        r16.b("mode", Integer.valueOf(t.a.a(r11.n)));
        return r16;
    L22:
        r19 = "";
        goto L23
    L11:
        IBrowserService r3 = (IBrowserService) jc1.k.n(IBrowserService.class);
        Context r4 = this.D.getContext();
        LynxThreadStrategy r5 = LynxThreadStrategy.ALL_ON_UI;
        File r110 = r11.m;
        if (r110 == null) goto L14;
        String r111 = r110.getAbsolutePath();
    L15:
        r16 = r3.mo462createOpenLynxComponent(r4, r2, r5, r12, r111);
        goto L16
    L14:
        r111 = null;
        goto L15
    L5:
        if (r14.length() == 0) goto L8;
        r15 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.k
    public final void e(Context r17, String r18, Map<String, ? extends Object> r19, n r21) {
        Intrinsics.checkNotNullParameter(r17, "context");
        Intrinsics.checkNotNullParameter(r18, "schema");
        this.q = r21;
        String r7 = "";
        if (this.a != LaunchMode.FROM_DEBUG) goto L6;
        if (r21 == null) goto L114;
        r21.f(this.D.m.i, new PolarisFileWrapper(""));
        return;
    L114:
        return;
    L6:
        LruCache r2 = LiveSchemaInfo.r;
        LiveSchemaInfo r3 = LiveSchemaInfo.c.a(r18);
        if (r3 == null) goto L118;
        this.x = System.currentTimeMillis();
        int r4 = qa4.b.a;
        na4.f r5 = new na4.f();
        r5.c = this.D.getContext();
        r5.a.put("aid", String.valueOf(jc1.k.n(IHostContext.class).appId()));
        r5.a.put("app_version", jc1.k.n(IHostContext.class).getVersionCode());
        Map r6 = r5.a;
        int r8 = com.bytedance.android.live.broadcastgame.opengame.utils.j.a;
        Context r9 = this.D.getContext();
        Intrinsics.checkNotNullParameter(r9, "context");
        r6.put("meta_basepath", FilesKt.resolve(r9.getCacheDir(), "opengame").getAbsolutePath());
        Map r11 = r5.a;
        if (this.c == false) goto L11;
        String r12 = "anchor";
    L12:
        r11.put("target", r12);
        if (jc1.k.n(IHostContext.class).isBoe() == false) goto L15;
        String r13 = "developer-boe.toutiao.com/api/apps/live_meta";
    L17:
        if (jc1.k.n(IHostContext.class).isBoe() == false) goto L19;
        String r14 = "http://".concat(r13);
    L20:
        r5.a.put("meta_baseurl", r14);
        r5.a.put("meta_decompress", Boolean.TRUE);
        ra4.a.a r15 = (ra4.a.a) WeakReferenceWrapper.wrap(this.C);
        BdpInfoService r16 = BdpManager.getInst().getService(BdpInfoService.class);
        wa4.b r110 = new wa4.b();
        r110.d = xa4.a.a().c;     // Catch: Exception -> L23
    L24:
        Object r22 = ((LinkedHashMap) r5.a).get("meta_basepath");
        Object r111 = null;
        if ((r22 instanceof String) == true) goto L27;
        r22 = null;
    L27:
        String r23 = (String) r22;
        if (r23 != null) goto L30;
        r110.a = true;
        ((ArrayList) r110.b).add("Missing basic path to store downloaded files");
        r23 = "";
    L30:
        r110.k = r23;
        Object r24 = ((LinkedHashMap) r5.a).get("meta_baseurl");
        if ((r24 instanceof String) == true) goto L33;
        r24 = null;
    L33:
        String r25 = (String) r24;
        if (r25 != null) goto L36;
        r110.a = true;
        ((ArrayList) r110.b).add("Missing basic url to fetch meta info");
    L37:
        r110.c = r7;
        Object r26 = ((LinkedHashMap) r5.a).get("target");
        if (r26 == null) goto L113;
        r110.j = (String) r26;
        Object r27 = ((LinkedHashMap) r5.a).get("aid");
        if ((r27 instanceof String) == true) goto L42;
        r27 = null;
    L42:
        String r28 = (String) r27;
        if (r28 != null) goto L50;
        if (r16 == null) goto L49;
        lb4.a r29 = r16.getHostInfo();
        if (r29 == null) goto L49;
        r28 = r29.getAppId();
    L49:
        r28 = null;
    L50:
        if (r28 == null) goto L52;
        r110.i = r28;
    L53:
        Object r31 = ((LinkedHashMap) r5.a).get("app_version");
        if ((r31 instanceof String) == true) goto L56;
        r31 = null;
    L56:
        String r32 = (String) r31;
        if (r32 != null) goto L64;
        if (r16 == null) goto L63;
        lb4.a r33 = r16.getHostInfo();
        if (r33 == null) goto L63;
        r32 = r33.getVersionName();
    L63:
        r32 = null;
    L64:
        if (r32 == null) goto L66;
        r110.h = r32;
    L67:
        Object r34 = ((LinkedHashMap) r5.a).get("meta_channel");
        if ((r34 instanceof String) == true) goto L70;
        r34 = null;
    L70:
        String r35 = (String) r34;
        if (r35 != null) goto L78;
        if (r16 == null) goto L77;
        lb4.a r36 = r16.getHostInfo();
        if (r36 == null) goto L77;
        r35 = r36.getChannel();
    L77:
        r35 = null;
    L78:
        if (r35 == null) goto L80;
        r110.m = r35;
    L81:
        Object r37 = ((LinkedHashMap) r5.a).get("meta_deviceid");
        if ((r37 instanceof String) == true) goto L84;
        r37 = null;
    L84:
        String r38 = (String) r37;
        if (r38 != null) goto L92;
        if (r16 == null) goto L91;
        lb4.a r39 = r16.getHostInfo();
        if (r39 == null) goto L91;
        r38 = r39.getDeviceId((String) r3.c.getValue());
    L91:
        r38 = null;
    L92:
        if (r38 == null) goto L94;
        r110.l = r38;
    L95:
        Object r41 = ((LinkedHashMap) r5.a).get("meta_download");
        if ((r41 instanceof Boolean) == true) goto L98;
        r41 = null;
    L98:
        Boolean r42 = (Boolean) r41;
        if (r42 == null) goto L101;
        r42.booleanValue();
    L101:
        Object r43 = ((LinkedHashMap) r5.a).get("meta_decompress");
        if ((r43 instanceof Boolean) == false) goto L105;
        r111 = r43;
    L105:
        Boolean r112 = (Boolean) r111;
        if (r112 == null) goto L108;
        r112.booleanValue();
    L108:
        BdpManager.getInst().getSDKInfo().getClass();
        r110.e = (String) r3.d.getValue();
        r110.f = (String) r3.c.getValue();
        r110.n = (String) r3.e.getValue();
        if (r110.a == false) goto L111;
        int r1 = ra4.a.a;
        r15.a("parse_params", (String) CollectionsKt.firstOrNull(r110.b));
        return;
    L111:
        oa4.c.a.executeIO(new qa4.a(r17, r110, r15));
        return;
    L94:
        r110.a = true;
        ((ArrayList) r110.b).add("DEVICE ID is null");
        goto L95
    L80:
        r110.a = true;
        ((ArrayList) r110.b).add("CHANNEL is null");
        goto L81
    L66:
        r110.a = true;
        ((ArrayList) r110.b).add("APP VERSION is null");
        goto L67
    L52:
        r110.a = true;
        ((ArrayList) r110.b).add("AID is null");
        goto L53
    L113:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    L36:
        r7 = r25;
    L23:
        r110.a = true;
        ((ArrayList) r110.b).add("Failed to generate TTCode");
        goto L24
    L19:
        r14 = "https://".concat(r13);
        goto L20
    L15:
        r13 = "developer.toutiao.com/api/apps/live_meta";
        goto L17
    L11:
        r12 = "audience";
        goto L12
    }
}
