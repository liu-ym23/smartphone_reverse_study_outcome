package com.bytedance.android.livesdk.interactivity.zdanmaku.widget;

import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.base.model.message.h4;
import com.bytedance.android.live.base.model.message.p0;
import com.bytedance.android.live.base.model.message.s3;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomRecyclableWidget;
import com.bytedance.android.livesdk.config.PerformanceTestSettings;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.interactivity.api.monitor.DanmakuMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRealtimeIndicatorNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomIndicatorNode;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.PSRoomStatValueNode;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.PrivilegeDanmakuType;
import com.bytedance.android.livesdk.interactivity.zdanmaku.binder.c0;
import com.bytedance.android.livesdk.interactivity.zdanmaku.binder.f0;
import com.bytedance.android.livesdk.interactivity.zdanmaku.binder.v;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.q6;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.zdanmaku.DanmakuController;
import com.bytedance.live.zdanmaku.data.Danmaku;
import com.bytedance.live.zdanmaku.render.canvas.RenderEngineView;
import ec2.k1;
import ec2.w0;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import p22.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u0006B\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/widget/PortraitZDanmakuWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomRecyclableWidget;", "Lcom/bytedance/android/livesdk/interactivity/zdanmaku/widget/PortraitZDanmakuPresenter$IView;", "Lcom/bytedance/android/livesdk/common/i;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PortraitZDanmakuWidget extends MiddlewareRoomRecyclableWidget implements PortraitZDanmakuPresenter.IView, com.bytedance.android.livesdk.common.i {
    public static final /* synthetic */ int l = 0;
    public Boolean a;
    public RenderEngineView b;
    public final p22.a c;
    public final p22.k d;
    public final p e;
    public final p22.i f;
    public BarrageWidgetContext g;
    public final CompositeDisposable h;
    public PortraitZDanmakuPresenter i;
    public com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> j;
    public final g k;

    public static final class a {
    }

    public static final class b<T> implements h80.d {
        public final /* synthetic */ PortraitZDanmakuWidget a;

        public b(PortraitZDanmakuWidget r1) {
            this.a = r1;
        }

        public final Object get() {
            return this.a.c;
        }
    }

    public static final class c implements com.bytedance.live.zdanmaku.data.c<com.bytedance.android.livesdk.interactivity.zdanmaku.i> {
        public c() {
        }

        public final com.bytedance.android.livesdk.interactivity.zdanmaku.i a() {
            return new com.bytedance.android.livesdk.interactivity.zdanmaku.i();
        }
    }

    public static final class d<T> implements h80.d {
        public final /* synthetic */ PortraitZDanmakuWidget a;

        public d(PortraitZDanmakuWidget r1) {
            this.a = r1;
        }

        public final Object get() {
            return this.a.f;
        }
    }

    public static final class e<T> implements h80.d {
        public final /* synthetic */ PortraitZDanmakuWidget a;

        public e(PortraitZDanmakuWidget r1) {
            this.a = r1;
        }

        public final Object get() {
            return this.a.d;
        }
    }

    public static final class f<T> implements h80.d {
        public final /* synthetic */ PortraitZDanmakuWidget a;

        public f(PortraitZDanmakuWidget r1) {
            this.a = r1;
        }

        public final Object get() {
            return this.a.e;
        }
    }

    public static final class g implements DanmakuController.b<com.bytedance.android.livesdk.interactivity.zdanmaku.i> {
        public final /* synthetic */ PortraitZDanmakuWidget a;

        public g(PortraitZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void a(Danmaku r4) {
            com.bytedance.android.livesdk.interactivity.zdanmaku.i r5 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r4;
            Intrinsics.checkNotNullParameter(r5, "danmaku");
            PortraitZDanmakuPresenter r1 = this.a.i;
            if (r1 == null) goto L9;
            Intrinsics.checkNotNullParameter(r5, "danmaku");
            if (r5.getType() != DanmakuType.Official) goto L7;
            r1.l.remove(r5);
        L7:
            r1.n.k();
            r1.o.k();
            r1.p.k();
            r1.q.k();
            return;
        }

        public final void b(Danmaku r9) {
            com.bytedance.android.livesdk.interactivity.zdanmaku.i r10 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r9;
            Intrinsics.checkNotNullParameter(r10, "danmaku");
            PortraitZDanmakuPresenter r1 = this.a.i;
            if (r1 == null) goto L30;
            Intrinsics.checkNotNullParameter(r10, "danmaku");
            DanmakuType r0 = r10.getType();
            DanmakuType r2 = DanmakuType.Official;
            if (r0 != r2) goto L8;
            r1.l.add(r10);
        L8:
            if (r10.getType() != r2) goto L13;
            dq1.c r3 = pm1.f.k();
            if (r3 == null) goto L13;
            HashMap r4 = new HashMap();
            r4.put("position", "live");
            r4.put("position_page", "official_danmu");
            r4.put("resource_scene", "logo");
            Unit r5 = Unit.INSTANCE;
            r3.h("activity_ad_show", "official_danmu", null, r4);
        L13:
            if (r10.getType() != DanmakuType.Privilege) goto L15;
            DanmakuMonitor.d(2, Long.valueOf(r10.h().a));
        L15:
            long r6 = System.currentTimeMillis();
            z32.f.c(PSRoomStatValueNode.PortraitDanmakuShowCount);
            if (((PrivilegeDanmakuType) r10.b().e(PrivilegeDanmakuType.class)) == null) goto L19;
            z32.f.c(PSRoomStatValueNode.PaidDanmakuShowCount);
        L19:
            if (r10.g().c <= 0) goto L26;
            long r7 = System.currentTimeMillis() - r10.g().c;
            z32.e.a(PSRealtimeIndicatorNode.PortraitDanmakuShowDelay, r7);
            DanmakuType r8 = r10.getType();
            int r11 = com.bytedance.android.livesdk.interactivity.zdanmaku.widget.i.a[r8.ordinal()];
            if (r11 == 1) goto L25;
            if (r11 != 2) goto L26;
            z32.f.b(PSRoomIndicatorNode.PortraitAdminDanmakuShowDelay, r7);
            goto L26
        L25:
            z32.f.b(PSRoomIndicatorNode.PortraitPrivilegeDanmakuShowDelay, r7);
        L26:
            tc2.j r13 = (tc2.j) r10.b().e(tc2.j.class);
            if (r13 == null) goto L31;
            com.bytedance.android.livesdk.interactivity.utils.b.a(r13, r6);
            return;
        L31:
            return;
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ PortraitZDanmakuWidget a;

        public h(PortraitZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            if (((Boolean) r5).booleanValue() == false) goto L19;
            com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r6 = this.a.j;
            if (r6 == null) goto L8;
            r6.postRunnable(new com.bytedance.live.zdanmaku.f(r6, PortraitZDanmakuWidget$onInit$1$1.INSTANCE, PortraitZDanmakuWidget$onInit$1$2.INSTANCE));
        L8:
            IRoomContextService r7 = this.a.getDataService();
            if (r7 == null) goto L16;
            o r8 = IRoomContextService.a.a(r7, ((Widget) this.a).dataCenter, 0, 2);
            if (r8 == null) goto L17;
            m r9 = r8.W1();
            if (r9 == null) goto L18;
            r9.setValue(Boolean.FALSE);
            return;
        L18:
            return;
        L17:
            return;
        L16:
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ PortraitZDanmakuWidget a;

        public i(PortraitZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            sh6.b r3 = (sh6.b) r2;
            PortraitZDanmakuWidget r4 = this.a;
            int r0 = PortraitZDanmakuWidget.l;
            r4.wq();
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ PortraitZDanmakuWidget a;

        public j(PortraitZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            if (((Boolean) r3).booleanValue() == true) goto L8;
            PortraitZDanmakuPresenter r4 = this.a.i;
            if (r4 == null) goto L9;
            i0.c().post(new com.bytedance.android.livesdk.interactivity.zdanmaku.widget.j(r4));
            return;
        L9:
            return;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566757;
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    public final String nc() {
        return "PortraitZDanmakuWidget";
    }

    public final /* synthetic */ boolean nq() {
        return com.bytedance.android.livesdk.common.h.a();
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.PortraitZDanmakuPresenter.IView
    public final int U() {
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.j;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c();
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.PortraitZDanmakuPresenter.IView
    public final void Vb() {
        ViewGroup r0 = ((Widget) this).containerView;
        if (r0 == null) goto L6;
        r0.setAlpha(1.0f);
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.PortraitZDanmakuPresenter.IView
    public final boolean isInCarnival() {
        BarrageWidgetContext r0 = this.g;
        if (r0 == null) goto L9;
        m<Boolean> r1 = r0.isCarnivalStarted();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final void onUnload() {
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.j;
        if (r0 == null) goto L5;
        r0.e();
    L5:
        this.h.clear();
        PortraitZDanmakuPresenter r1 = this.i;
        if (r1 == null) goto L8;
        r1.detachView();
    L8:
        ViewGroup r2 = ((Widget) this).containerView;
        if (r2 == null) goto L11;
        r2.setAlpha(1.0f);
    L11:
        this.a = Boolean.FALSE;
        BarrageWidgetContext r3 = this.g;
        if (r3 != null) goto L14;
        return;
    L14:
        if ((!r3.hasCleared()) == true) goto L17;
        r3 = null;
    L17:
        if (r3 == null) goto L24;
        pk6.a r4 = (pk6.a) r3.getDanmakuAlpha().getValue();
        if (r4 == null) goto L21;
        r4.a = 255;
    L21:
        r3.getScrollBarrageView().setValue(null);
        return;
    }

    public final int supportClearScene() {
        if (((Boolean) k1.a.getValue()).booleanValue() == false) goto L5;
        return 17;
    L5:
        return 16;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.PortraitZDanmakuPresenter.IView
    public final void wT() {
        ViewGroup r0 = ((Widget) this).containerView;
        if (r0 == null) goto L6;
        r0.setAlpha(0.0f);
        return;
    }

    public final void wq() {
        RenderEngineView r1 = this.b;
        if (r1 != null) goto L5;
        return;
    L5:
        BarrageWidgetContext r2 = this.g;
        int r4 = s1.y();
        com.bytedance.android.livesdk.interactivity.zdanmaku.layout.a r10 = new com.bytedance.android.livesdk.interactivity.zdanmaku.layout.a(r4, s1.f(60.0f), s1.f(24.0f), UtilityKotlinExtentionsKt.i(2), 5000, r4 / 5000);
        this.d.a(r10.a);
        com.bytedance.android.livesdk.interactivity.zdanmaku.layout.b r13 = new com.bytedance.android.livesdk.interactivity.zdanmaku.layout.b(r10, s1.w());
        f r3 = new f(this);
        b r5 = new b(this);
        e r6 = new e(this);
        d r7 = new d(this);
        com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m r8 = new com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m(r13, r6, r3, false, 24);
        c r9 = new c();
        com.bytedance.live.zdanmaku.data.d r11 = new com.bytedance.live.zdanmaku.data.d();
        int r14 = com.bytedance.live.zdanmaku.e.i;
        com.bytedance.live.zdanmaku.e.a r15 = new com.bytedance.live.zdanmaku.e.a();
        r15.b(com.bytedance.android.livesdk.interactivity.zdanmaku.k.class, new com.bytedance.android.livesdk.interactivity.zdanmaku.binder.a((View) DanmakuCacheProviders.e.getValue(), r5, r2));
        r15.b(n22.d.class, new v((View) DanmakuCacheProviders.f.getValue(), r7, r2));
        r15.b(q72.e.class, new c0((View) DanmakuCacheProviders.i.getValue(), r3, r2));
        r15.b(com.bytedance.android.livesdk.interactivity.zdanmaku.j.class, new f0((View) DanmakuCacheProviders.n.getValue(), (View) DanmakuCacheProviders.m.getValue(), r6, r2));
        r15.b = r11;
        r15.d = AsyncTask.THREAD_POOL_EXECUTOR;
        r15.a = new vc2.a("Portrait");
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r16 = r15.a(r1, r9, r8);
        this.j = r16;
        r16.g.h = this.k;
    }

    public PortraitZDanmakuWidget() {
        this.a = Boolean.FALSE;
        BarrageSettingFont r1 = BarrageSettingFont.PORTRAIT;
        this.c = new p22.a(null, r1, 100.0f);
        BarrageSettingArea r4 = BarrageSettingArea.HALF;
        this.d = new p22.k(r4, r1, 100.0f);
        this.e = new p(r4, r1, 100.0f);
        this.f = new p22.i(null, r1, 100.0f);
        this.h = new CompositeDisposable();
        this.k = new g(this);
    }

    public final String Lg() {
        if (com.bytedance.android.livesdk.common.h.a() == false) goto L12;
        ALogger.i("CleanScreenManager", "PortraitZDanmakuWidget GONE");
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.j;
        if (r0 == null) goto L7;
        r0.b();
    L7:
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r1 = this.j;
        if (r1 == null) goto L14;
        r1.d();
        return "PortraitZDanmakuWidget";
    L14:
        return "PortraitZDanmakuWidget";
    L12:
        return null;
    }

    public final String cg() {
        if (com.bytedance.android.livesdk.common.h.a() == false) goto L9;
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.j;
        if (r0 == null) goto L7;
        r0.f();
    L7:
        ALogger.i("CleanScreenManager", "PortraitZDanmakuWidget SHOW");
        return "PortraitZDanmakuWidget";
    L9:
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.PortraitZDanmakuPresenter.IView
    public final IRoom getRoom() {
        IRoomContextService r0 = getRoomContextService();
        if (r0 == null) goto L9;
        o r1 = IRoomContextService.a.a(r0, ((Widget) this).dataCenter, 0, 2);
        if (r1 == null) goto L9;
        m r2 = r1.getRoom();
        if (r2 == null) goto L9;
        return (IRoom) r2.getValue();
    L9:
        return null;
    }

    public final View getContentView() {
        return ((Widget) this).contentView;
    }

    public final Boolean uk() {
        return this.a;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.PortraitZDanmakuPresenter.IView
    public final int PV(p0 r3) {
        Intrinsics.checkNotNullParameter(r3, "message");
        int r0 = this.e.e.a;
        if ((r3 instanceof h4) == false) goto L6;
        return this.c.d.a;
    L6:
        if ((r3 instanceof s3) == true) goto L8;
        return r0;
    L8:
        return this.d.d.a;
    }

    public final void onEnterClear(int r2) {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onEnterClear(r2);
        if (r2 != 16) goto L11;
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.j;
        if (r0 == null) goto L7;
        r0.b();
    L7:
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r1 = this.j;
        if (r1 == null) goto L11;
        r1.d();
    L11:
        if (((Boolean) k1.a.getValue()).booleanValue() == true) goto L13;
        return;
    L13:
        if (r2 != 1) goto L19;
        RenderEngineView r3 = this.b;
        if (r3 == null) goto L20;
        r3.j();
        return;
    L20:
        return;
    }

    public final void onExitClear(int r2) {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onExitClear(r2);
        if (r2 != 16) goto L8;
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.j;
        if (r0 == null) goto L8;
        r0.f();
    L8:
        if (((Boolean) k1.a.getValue()).booleanValue() == true) goto L10;
        return;
    L10:
        if (r2 != 1) goto L16;
        RenderEngineView r3 = this.b;
        if (r3 == null) goto L17;
        r3.i();
        return;
    L17:
        return;
    }

    public final void onInit(Object[] r5) {
        this.b = findViewById(2131384277);
        this.e.a(2, isScreenPortrait());
        p22.k r6 = this.d;
        int[] r0 = {0, 1};
        r6.getClass();
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r6.e = r0;
        IRoomContextService r7 = getRoomContextService();
        if (r7 == null) goto L14;
        o r8 = IRoomContextService.a.a(r7, ((Widget) this).dataCenter, 0, 2);
        if (r8 == null) goto L14;
        m r9 = r8.W1();
        if (r9 == null) goto L14;
        Observable r10 = r9.a();
        if (r10 == null) goto L14;
        ObservableSubscribeProxy r11 = (ObservableSubscribeProxy) r10.as(autoDispose());
        if (r11 == null) goto L14;
        r11.subscribe(new h(this));
    L14:
        if (((Boolean) q6.a.getValue()).booleanValue() == true) goto L16;
        return;
    L16:
        if (PadConfigUtils.a() == false) goto L30;
        IRoomContextService r13 = getDataService();
        if (r13 == null) goto L31;
        o r14 = IRoomContextService.a.a(r13, ((Widget) this).dataCenter, 0, 2);
        if (r14 == null) goto L32;
        n r15 = r14.getPadOrientation();
        if (r15 == null) goto L33;
        Observable r16 = r15.a();
        if (r16 == null) goto L34;
        Disposable r17 = r16.subscribe(new i(this));
        if (r17 == null) goto L35;
        this.h.add(r17);
        return;
    L35:
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    }

    public final void onLoad(Object[] r6) {
        if (((Boolean) PerformanceTestSettings.TEST_DISABLE_BARRAGE.getValue()).booleanValue() == false) goto L6;
        return;
    L6:
        if (getRoomContext() == null) goto L8;
        this.g = com.bytedance.android.livesdk.interactivity.barrage.widget.b.a(getRoomContext(), ((Widget) this).dataCenter);
    L9:
        BarrageWidgetContext r7 = this.g;
        if (r7 != null) goto L12;
    L20:
        com.bytedance.android.livesdk.interactivity.utils.j.a("mBarrageWidgetContext is null");
    L21:
        wq();
        PortraitZDanmakuPresenter r8 = new PortraitZDanmakuPresenter();
        this.i = r8;
        r8.g0(this);
        BarrageWidgetContext r9 = this.g;
        if (r9 == null) goto L31;
        m<Boolean> r10 = r9.isCarnivalStarted();
        if (r10 == null) goto L32;
        Observable r11 = r10.a();
        if (r11 == null) goto L33;
        ObservableSubscribeProxy r13 = (ObservableSubscribeProxy) r11.as(autoDispose());
        if (r13 == null) goto L34;
        r13.subscribe(new j(this));
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L12:
        if (r7.hasCleared() == true) goto L20;
        r7.getAdminDanmakuSettingConfig().setValue(this.c);
        r7.getPrivilegeDanmakuSettingConfig().setValue(this.d);
        r7.getNormalDanmakuSettingConfig().setValue(this.f);
        n<com.bytedance.android.livesdk.interactivity.barrage.widget.a> r0 = r7.getEnv();
        isScreenPortrait();
        DataCenter r2 = ((Widget) this).dataCenter;
        if (r2 == null) goto L16;
        ((Boolean) r2.get("data_is_anchor", Boolean.FALSE)).booleanValue();
    L16:
        r0.setValue(new com.bytedance.android.livesdk.interactivity.barrage.widget.a());
        pk6.a r1 = (pk6.a) r7.getDanmakuAlpha().getValue();
        if (r1 == null) goto L19;
        r1.a = 255;
    L19:
        r7.getScrollBarrageView().setValue(((Widget) this).contentView);
        goto L21
    L8:
        com.bytedance.android.livesdk.interactivity.utils.j.a("roomContext is null");
        goto L9
    }

    public final void qo(Boolean r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.PortraitZDanmakuPresenter.IView
    public final void JH(int r4, boolean r5) {
        RenderEngineView r0 = this.b;
        ViewGroup.LayoutParams r1 = null;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r2 = r0.getLayoutParams();
    L7:
        if ((r2 instanceof FrameLayout.LayoutParams) == false) goto L10;
        r1 = r2;
    L10:
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r1;
        if (r5 == true) goto L13;
        int r6 = s1.f(112.0f);
    L14:
        if (r3 == null) goto L16;
        r3.bottomMargin = r4 + r6;
    L16:
        RenderEngineView r7 = this.b;
        if (r7 == null) goto L20;
        r7.setLayoutParams(r3);
        return;
    L20:
        return;
    L13:
        r6 = s1.f(96.0f);
        goto L14
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.PortraitZDanmakuPresenter.IView
    public final void X(Object r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "danmakuData");
        if (((Boolean) w0.a.getValue()).booleanValue() == false) goto L6;
        ALogger.e("PortraitZDanmakuWidget", "sendDanmaku called but blocked by setting");
        return;
    L6:
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.j;
        if (r0 == null) goto L10;
        r0.a(r2, r3);
        return;
    }
}
