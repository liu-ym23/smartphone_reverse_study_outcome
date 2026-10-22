package com.bytedance.android.livesdk.interactivity.zdanmaku.cast;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.InputValueNode;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.a0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.b0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.c0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.d0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.y;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.z;
import com.bytedance.android.livesdk.interactivity.api.settings.config.p;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.android.livesdk.interactivity.zdanmaku.DanmakuRenderEngineView;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.android.livesdk.interactivity.zdanmaku.binder.f0;
import com.bytedance.android.livesdk.interactivity.zdanmaku.binder.j0;
import com.bytedance.android.livesdk.interactivity.zdanmaku.binder.s;
import com.bytedance.android.livesdk.interactivity.zdanmaku.binder.v;
import com.bytedance.android.livesdk.interactivity.zdanmaku.binder.x;
import com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.zdanmaku.DanmakuController;
import com.bytedance.live.zdanmaku.data.Danmaku;
import com.bytedance.live.zdanmaku.render.canvas.RenderEngineView;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zg1.e3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/cast/CastZDanmakuWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/interactivity/zdanmaku/widget/LandscapeDanmakuPresenterV2$IView;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CastZDanmakuWidget extends MiddlewareRoomWidget implements LandscapeDanmakuPresenterV2.IView, Observer<KVData> {
    public static boolean v;
    public final b a;
    public final String b;
    public final p c;
    public BarrageWidgetContext d;
    public p22.g e;
    public p22.c f;
    public p22.p g;
    public p22.k h;
    public p22.a i;
    public p22.i j;
    public com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> k;
    public m l;
    public DanmakuRenderEngineView m;
    public LandscapeDanmakuPresenterV2 n;
    public com.bytedance.android.livesdk.interactivity.zdanmaku.cast.a o;
    public final CompositeDisposable p;
    public final int q;
    public int r;
    public final int s;
    public com.bytedance.android.livesdk.interactivity.zdanmaku.cast.d t;
    public com.bytedance.android.livesdk.interactivity.zdanmaku.cast.c u;

    public static final class a {
    }

    public static final class b implements DanmakuController.b<com.bytedance.android.livesdk.interactivity.zdanmaku.i> {
        public final /* synthetic */ CastZDanmakuWidget a;

        public b(CastZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void a(Danmaku r2) {
            com.bytedance.android.livesdk.interactivity.zdanmaku.i r3 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r2;
            Intrinsics.checkNotNullParameter(r3, "danmaku");
            LandscapeDanmakuPresenterV2 r0 = this.a.n;
            if (r0 == null) goto L6;
            r0.k0(r3);
            return;
        }

        public final void b(Danmaku r14) {
            com.bytedance.android.livesdk.interactivity.zdanmaku.i r15 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r14;
            Intrinsics.checkNotNullParameter(r15, "danmaku");
            long r0 = System.currentTimeMillis();
            LandscapeDanmakuPresenterV2 r2 = this.a.n;
            if (r2 == null) goto L5;
            r2.l0(r15);
        L5:
            tc2.j r3 = (tc2.j) r15.b().e(tc2.j.class);
            if (r3 == null) goto L13;
            long r11 = r3.c - r3.b;
            long r9 = System.currentTimeMillis() - r3.b;
            com.bytedance.android.livesdk.interactivity.api.monitor.e.a(r3.a, "danmaku", r9, r11);
            com.bytedance.android.livesdk.interactivity.utils.b.a(r3, r0);
            if (r3.g == true) goto L10;
            return;
        L10:
            if (r15.getType() != DanmakuType.Chat) goto L15;
            z32.c.b(InputValueNode.LandscapeSelfChatShowCount);
            return;
        L15:
            return;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ CastZDanmakuWidget a;

        public c(CastZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            CastZDanmakuWidget r0 = this.a;
            r0.e = (p22.g) sh6.c.b((sh6.b) r2);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ CastZDanmakuWidget a;

        public d(CastZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            CastZDanmakuWidget r0 = this.a;
            r0.f = (p22.c) sh6.c.b((sh6.b) r2);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ CastZDanmakuWidget a;

        public e(CastZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            CastZDanmakuWidget r0 = this.a;
            r0.i = (p22.a) sh6.c.b((sh6.b) r2);
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ CastZDanmakuWidget a;

        public f(CastZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            CastZDanmakuWidget r0 = this.a;
            r0.h = (p22.k) sh6.c.b((sh6.b) r2);
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ CastZDanmakuWidget a;

        public g(CastZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            CastZDanmakuWidget r0 = this.a;
            r0.g = (p22.p) sh6.c.b((sh6.b) r2);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ CastZDanmakuWidget a;

        public h(CastZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            CastZDanmakuWidget r0 = this.a;
            r0.j = (p22.i) sh6.c.b((sh6.b) r2);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ CastZDanmakuWidget a;

        public i(CastZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            q22.c r4 = (q22.c) r3;
            Intrinsics.checkNotNullParameter(r4, "event");
            CastZDanmakuWidget r0 = this.a;
            boolean r5 = r4.a;
            boolean r1 = CastZDanmakuWidget.v;
            r0.getClass();
            BarrageSetting r2 = (BarrageSetting) l42.a.d.getValue();
            LandscapeDanmakuPresenterV2 r6 = r0.n;
            if (r6 == null) goto L11;
            if (r5 == true) goto L6;
        L8:
            boolean r7 = false;
        L9:
            r6.p0(r7);
            return;
        L6:
            if (r2.isLotteryOpen() == false) goto L8;
            r7 = true;
            goto L9
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ CastZDanmakuWidget a;

        public j(CastZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            if (((Boolean) r4).booleanValue() == false) goto L10;
            com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r5 = this.a.k;
            if (r5 == null) goto L9;
            r5.postRunnable(new com.bytedance.live.zdanmaku.f(r5, CastZDanmakuWidget$onCreate$11$1.INSTANCE, CastZDanmakuWidget$onCreate$11$2.INSTANCE));
            return;
        L9:
            return;
        }
    }

    public static final class k<T> implements Consumer {
        public final /* synthetic */ CastZDanmakuWidget a;

        public k(CastZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            e3 r4 = (e3) r3;
            Intrinsics.checkNotNullParameter(r4, "event");
            CastZDanmakuWidget r0 = this.a;
            boolean r1 = CastZDanmakuWidget.v;
            r0.getClass();
            if (r4.b == false) goto L7;
            RenderEngineView r5 = r0.m;
            if (r5 == null) goto L21;
            r5.setVisibility(4);
            return;
        L21:
            return;
        L7:
            RenderEngineView r6 = r0.m;
            if (r6 == null) goto L10;
            r6.setVisibility(0);
        L10:
            p22.g r7 = r0.wq((BarrageSetting) l42.a.d.getValue());
            r0.e = r7;
            r0.r = r0.yq(r7);
            p22.g r8 = r0.e;
            if (r8 == null) goto L13;
            BarrageSettingArea r9 = r8.a;
        L15:
            if (r9 != BarrageSettingArea.CLOSE) goto L17;
            r0.r = r0.s / 2;
        L17:
            m r10 = r0.l;
            if (r10 == null) goto L23;
            r10.h(r0.xq());
            return;
        L23:
            return;
        L13:
            r9 = null;
            goto L15
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ CastZDanmakuWidget a;

        public l(CastZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            q22.b r6 = (q22.b) r5;
            Intrinsics.checkNotNullParameter(r6, "event");
            CastZDanmakuWidget r0 = this.a;
            BarrageSetting r7 = r6.a;
            p22.g r1 = r0.e;
            if (r1 == null) goto L7;
            LandscapeDanmakuPresenterV2 r2 = r0.n;
            if (r2 == null) goto L7;
            r2.o0(r1.a, r1.b);
        L7:
            LandscapeDanmakuPresenterV2 r3 = r0.n;
            if (r3 == null) goto L10;
            r3.p0(r7.isLotteryOpen());
        L10:
            r0.r = r0.yq(r0.e);
            com.bytedance.android.livesdk.interactivity.zdanmaku.layout.a r8 = r0.xq();
            m r4 = r0.l;
            if (r4 == null) goto L14;
            r4.h(r8);
            return;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566692;
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final boolean isInCarnival() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final void K0() {
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.k;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final int N20() {
        m r0 = this.l;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.zdanmaku.layout.a r1 = r0.a;
        if (r1 == null) goto L7;
        return r1.a;
    L7:
        return 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final void Q7() {
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.k;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final int U() {
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.k;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c();
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final p22.p fR() {
        p22.p r0 = this.g;
        if (r0 != null) goto L6;
        BarrageSetting r1 = (BarrageSetting) l42.a.d.getValue();
        return new p22.p(r1.getBarrageArea(), r1.getFontSize(), r1.getAlpha());
    L6:
        return r0;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        ALogger.i(this.b, "CastZDanmakuWidget load");
        DataContext r1 = getRoomContext();
        if (r1 != null) goto L5;
        return;
    L5:
        BarrageWidgetContext r2 = com.bytedance.android.livesdk.interactivity.barrage.widget.b.a(r1, ((Widget) this).dataCenter);
        this.d = r2;
        if (r2 == null) goto L12;
        n<p22.g> r3 = r2.getGiftDanmakuSettingConfig();
        if (r3 == null) goto L12;
        this.e = (p22.g) r3.getValue();
        Disposable r4 = r3.a().subscribe(new c(this));
        if (r4 == null) goto L12;
        RxUtilKt.c(r4, this.p);
    L12:
        this.r = yq(this.e);
        com.bytedance.android.livesdk.interactivity.zdanmaku.layout.a r5 = xq();
        m r6 = this.l;
        if (r6 == null) goto L15;
        r6.h(r5);
    L15:
        BarrageWidgetContext r7 = this.d;
        if (r7 == null) goto L22;
        n<p22.c> r8 = r7.getBusinessDanmakuConfig();
        if (r8 == null) goto L22;
        this.f = (p22.c) r8.getValue();
        Disposable r9 = r8.a().subscribe(new d(this));
        if (r9 == null) goto L22;
        RxUtilKt.c(r9, this.p);
    L22:
        BarrageWidgetContext r10 = this.d;
        if (r10 == null) goto L29;
        n<p22.a> r11 = r10.getAdminDanmakuSettingConfig();
        if (r11 == null) goto L29;
        this.i = (p22.a) r11.getValue();
        Disposable r13 = r11.a().subscribe(new e(this));
        if (r13 == null) goto L29;
        RxUtilKt.c(r13, this.p);
    L29:
        BarrageWidgetContext r14 = this.d;
        if (r14 == null) goto L36;
        n<p22.k> r15 = r14.getPrivilegeDanmakuSettingConfig();
        if (r15 == null) goto L36;
        this.h = (p22.k) r15.getValue();
        Disposable r16 = r15.a().subscribe(new f(this));
        if (r16 == null) goto L36;
        RxUtilKt.c(r16, this.p);
    L36:
        BarrageWidgetContext r17 = this.d;
        if (r17 == null) goto L43;
        n<p22.p> r18 = r17.getTextDanmakuSettingConfig();
        if (r18 == null) goto L43;
        this.g = (p22.p) r18.getValue();
        Disposable r19 = r18.a().subscribe(new g(this));
        if (r19 == null) goto L43;
        RxUtilKt.c(r19, this.p);
    L43:
        BarrageWidgetContext r20 = this.d;
        if (r20 == null) goto L50;
        n<p22.i> r21 = r20.getNormalDanmakuSettingConfig();
        if (r21 == null) goto L50;
        this.j = (p22.i) r21.getValue();
        Disposable r23 = r21.a().subscribe(new h(this));
        if (r23 == null) goto L50;
        RxUtilKt.c(r23, this.p);
    L50:
        LandscapeDanmakuPresenterV2 r24 = new LandscapeDanmakuPresenterV2();
        this.n = r24;
        r24.g0(this);
        com.bytedance.android.livesdk.sharedpref.e<BarrageSetting> r25 = l42.a.d;
        BarrageSetting r26 = (BarrageSetting) r25.getValue();
        LandscapeDanmakuPresenterV2 r27 = this.n;
        int r28 = 0;
        if (r27 != null) goto L53;
    L59:
        p22.g r29 = this.e;
        if (r29 == null) goto L65;
        LandscapeDanmakuPresenterV2 r30 = this.n;
        if (r30 == null) goto L65;
        r30.o0(r29.a, r29.b);
    L65:
        if (this.m != null) goto L67;
        this.m = new DanmakuRenderEngineView(((Widget) this).context, null, 6, 0);
    L67:
        p22.g r31 = this.e;
        if (r31 != null) goto L70;
        r31 = wq((BarrageSetting) r25.getValue());
    L70:
        this.r = yq(r31);
        float r33 = this.q / Math.max(this.c.a(), 1);
        float r34 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        int r35 = r31.d.a;
        com.bytedance.android.livesdk.interactivity.zdanmaku.layout.b r110 = new com.bytedance.android.livesdk.interactivity.zdanmaku.layout.b(new com.bytedance.android.livesdk.interactivity.zdanmaku.layout.a(this.q, this.r, r35, UtilityKotlinExtentionsKt.i(2), (int) (r33 * r34), this.c.a() / r34), s1.w());
        com.bytedance.android.livesdk.interactivity.zdanmaku.cast.c r36 = new com.bytedance.android.livesdk.interactivity.zdanmaku.cast.c(this);
        this.u = r36;
        com.bytedance.android.livesdk.interactivity.zdanmaku.cast.h r37 = new com.bytedance.android.livesdk.interactivity.zdanmaku.cast.h(this);
        com.bytedance.android.livesdk.interactivity.zdanmaku.cast.f r38 = new com.bytedance.android.livesdk.interactivity.zdanmaku.cast.f(this);
        com.bytedance.android.livesdk.interactivity.zdanmaku.cast.e r39 = new com.bytedance.android.livesdk.interactivity.zdanmaku.cast.e(this);
        com.bytedance.android.livesdk.interactivity.zdanmaku.cast.i r40 = new com.bytedance.android.livesdk.interactivity.zdanmaku.cast.i(this);
        com.bytedance.android.livesdk.interactivity.zdanmaku.cast.d r111 = new com.bytedance.android.livesdk.interactivity.zdanmaku.cast.d(this);
        this.t = r111;
        m r41 = new m(r110, r111, r36, com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.j.a(false, getRoom()), 8);
        this.l = r41;
        com.bytedance.android.livesdk.interactivity.zdanmaku.cast.g r43 = new com.bytedance.android.livesdk.interactivity.zdanmaku.cast.g();
        com.bytedance.live.zdanmaku.data.d r112 = new com.bytedance.live.zdanmaku.data.d();
        r112.a(z.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
        r112.a(d0.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
        r112.a(c0.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
        r112.a(y.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
        r112.a(a0.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
        r112.a(b0.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
        int r113 = com.bytedance.live.zdanmaku.e.i;
        com.bytedance.live.zdanmaku.e.a r114 = new com.bytedance.live.zdanmaku.e.a();
        View r115 = (View) DanmakuCacheProviders.b.getValue();
        com.bytedance.android.livesdk.interactivity.zdanmaku.cast.c r116 = this.u;
        if (r116 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("textDanmakuSettingConfigSupplier");
    L73:
        r114.b(com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class, new com.bytedance.android.livesdk.interactivity.zdanmaku.binder.k(r115, r116, this.d));
        r114.b(q22.a.class, new s((View) DanmakuCacheProviders.d.getValue(), r37, this.d));
        r114.b(BusinessConfigure.class, new com.bytedance.android.livesdk.interactivity.zdanmaku.binder.e(r38, this.d));
        r114.b(com.bytedance.android.livesdk.interactivity.zdanmaku.k.class, new com.bytedance.android.livesdk.interactivity.zdanmaku.binder.a((View) DanmakuCacheProviders.e.getValue(), r39, this.d));
        r114.b(n22.d.class, new v((View) DanmakuCacheProviders.f.getValue(), r40, this.d));
        View r44 = (View) DanmakuCacheProviders.g.getValue();
        com.bytedance.android.livesdk.interactivity.zdanmaku.cast.c r45 = this.u;
        if (r45 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("textDanmakuSettingConfigSupplier");
    L76:
        r114.b(q72.f.class, new j0(r44, r45, this.d));
        View r46 = (View) DanmakuCacheProviders.h.getValue();
        com.bytedance.android.livesdk.interactivity.zdanmaku.cast.c r47 = this.u;
        if (r47 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("textDanmakuSettingConfigSupplier");
    L79:
        r114.b(q72.e.class, new com.bytedance.android.livesdk.interactivity.zdanmaku.binder.a0(r46, r47, this.d));
        View r48 = (View) DanmakuCacheProviders.n.getValue();
        View r49 = (View) DanmakuCacheProviders.m.getValue();
        com.bytedance.android.livesdk.interactivity.zdanmaku.cast.d r117 = this.t;
        if (r117 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("privilegeDanmakuSettingConfigSupplier");
    L82:
        r114.b(com.bytedance.android.livesdk.interactivity.zdanmaku.j.class, new f0(r48, r49, r117, this.d));
        r114.b(com.bytedance.android.livesdk.interactivity.zdanmaku.d.class, new x((View) DanmakuCacheProviders.o.getValue(), r40, this.d));
        r114.b = r112;
        r114.d = AsyncTask.THREAD_POOL_EXECUTOR;
        r114.a = new vc2.a("Landscape");
        DanmakuRenderEngineView r50 = this.m;
        if (r50 == null) goto L122;
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r51 = r114.a(r50, r43, r41);
        this.k = r51;
        r51.g.h = this.a;
        RenderEngineView r53 = this.m;
        if (r53 == null) goto L91;
        if (((Boolean) l42.a.g.getValue()).booleanValue() == false) goto L89;
        r28 = 4;
    L89:
        r53.setVisibility(r28);
    L91:
        if (isEnableLandscapeChat() == true) goto L95;
        RenderEngineView r54 = this.m;
        if (r54 == null) goto L95;
        r54.setVisibility(4);
    L95:
        StringBuilder r55 = new StringBuilder("init widget,visiable:");
        RenderEngineView r56 = this.m;
        if (r56 == null) goto L98;
        Integer r57 = Integer.valueOf(r56.getVisibility());
    L99:
        r55.append(r57);
        ALogger.w("ToolbarLandscapeBlockEvent", r55.toString());
        this.o = new com.bytedance.android.livesdk.interactivity.zdanmaku.cast.a(new WeakReference(this), new WeakReference(this.m));
        MiddlewareRoomContext r58 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r58 == null) goto L105;
        n r59 = r58.getDanmakuCastManager();
        if (r59 == null) goto L105;
        r59.setValue(this.o);
    L105:
        if (isEnableLandscapeChat() == true) goto L109;
        RenderEngineView r60 = this.m;
        if (r60 == null) goto L109;
        r60.setVisibility(4);
    L109:
        ((Widget) this).dataCenter.observe("data_room_comment_status", this);
        L7(e3.class, new k(this));
        L7(q22.b.class, new l(this));
        L7(q22.c.class, new i(this));
        IRoomContextService r61 = getRoomContextService();
        if (r61 == null) goto L123;
        o r63 = IRoomContextService.a.a(r61, ((Widget) this).dataCenter, 0, 2);
        if (r63 == null) goto L124;
        com.bytedance.live.datacontext.m r64 = r63.W1();
        if (r64 == null) goto L125;
        Observable r65 = r64.a();
        if (r65 == null) goto L126;
        ObservableSubscribeProxy r66 = (ObservableSubscribeProxy) r65.as(autoDispose());
        if (r66 == null) goto L127;
        r66.subscribe(new j(this));
        return;
    L127:
        return;
    L126:
        return;
    L125:
        return;
    L124:
        return;
    L123:
        return;
    L98:
        r57 = null;
        goto L99
    L122:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.artist.render.RenderEngine");
    L53:
        if (p61.a.a() == false) goto L55;
    L57:
        boolean r67 = false;
    L58:
        r27.p0(r67);
        goto L59
    L55:
        if (r26.isLotteryOpen() == false) goto L57;
        r67 = true;
        goto L58
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final void startDanmaku() {
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.k;
        if (r0 == null) goto L5;
        r0.start();
    L5:
        v = true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final void stopDanmaku() {
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.k;
        if (r0 == null) goto L5;
        r0.stop();
    L5:
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r1 = this.k;
        if (r1 == null) goto L8;
        r1.b();
    L8:
        v = false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final boolean vV() {
        p22.g r0 = this.e;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.e != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final void x0() {
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.k;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final int x60() {
        m r0 = this.l;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.zdanmaku.layout.a r1 = r0.a;
        if (r1 == null) goto L7;
        return r1.d;
    L7:
        return 0;
    }

    public final com.bytedance.android.livesdk.interactivity.zdanmaku.layout.a xq() {
        float r0 = this.q / Math.max(this.c.a(), 1);
        float r1 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        int r7 = (int) (r0 * r1);
        p22.g r2 = this.e;
        if (r2 != null) goto L6;
        r2 = wq((BarrageSetting) l42.a.d.getValue());
    L6:
        return new com.bytedance.android.livesdk.interactivity.zdanmaku.layout.a(this.q, this.r, r2.d.a, UtilityKotlinExtentionsKt.i(2), r7, this.c.a() / r1);
    }

    public CastZDanmakuWidget() {
        this.a = new b(this);
        this.b = "CastZDanmakuWidget";
        this.c = (p) r52.b0.a.getValue();
        this.p = new CompositeDisposable();
        this.q = Math.max(s1.w(), s1.y());
        int r0 = Math.min(s1.w(), s1.y());
        this.r = r0;
        this.s = r0;
    }

    public final IRoom getRoom() {
        IRoomContextService r0 = getRoomContextService();
        if (r0 == null) goto L9;
        o r1 = IRoomContextService.a.a(r0, ((Widget) this).dataCenter, 0, 2);
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L9;
        return (IRoom) r2.getValue();
    L9:
        return null;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final boolean isEnableLandscapeChat() {
        IRoom r0 = getRoom();
        if (r0 == null) goto L15;
        IRoomAuthStatus r1 = r0.getRoomAuthStatus();
        if (r1 == null) goto L15;
        if (r1.isEnableLandscapeChat() != true) goto L15;
        IRoom r2 = getRoom();
        if (r2 == null) goto L15;
        IRoomAuthStatus r3 = r2.getRoomAuthStatus();
        if (r3 == null) goto L15;
        if (r3.getEnableChat() != true) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final boolean isScreenPortrait() {
        IRoomContextService r0 = getRoomContextService();
        if (r0 == null) goto L9;
        o r1 = IRoomContextService.a.a(r0, ((Widget) this).dataCenter, 0, 2);
        if (r1 == null) goto L9;
        Boolean r2 = r1.isPortraitInteraction();
        if (r2 == null) goto L9;
        return r2.booleanValue();
    L9:
        return false;
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        ALogger.i(this.b, "CastZDanmakuWidget unload");
        this.o = null;
        MiddlewareRoomContext r1 = MiddlewareRoomContext.a.c(MiddlewareRoomContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r1 == null) goto L7;
        n r2 = r1.getDanmakuCastManager();
        if (r2 == null) goto L7;
        r2.setValue(null);
    L7:
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L10;
        r0.removeObserver(this);
    L10:
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r3 = this.k;
        if (r3 == null) goto L13;
        r3.e();
    L13:
        LandscapeDanmakuPresenterV2 r4 = this.n;
        if (r4 == null) goto L16;
        r4.detachView();
    L16:
        this.p.clear();
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final m WT() {
        return this.l;
    }

    public final void onChanged(Object r2) {
        KVData r3 = (KVData) r2;
        if (r3 != null) goto L6;
        return;
    L6:
        if (TextUtils.equals("data_room_comment_status", r3.getKey()) == false) goto L13;
        ALogger.w("ToolbarLandscapeBlockEvent", "room_comment_status_change, visible:" + isEnableLandscapeChat());
        RenderEngineView r4 = this.m;
        if (isEnableLandscapeChat() == false) goto L10;
        int r0 = 0;
    L11:
        UIUtils.setViewVisibility(r4, r0);
        return;
    L10:
        r0 = 8;
        goto L11
    }

    public final p22.g wq(BarrageSetting r5) {
        return new p22.g(r5.getBarrageArea(), r5.getFontSize(), r5.getAlpha(), r5.isGiftOpen());
    }

    public final int yq(p22.g r3) {
        int r0 = this.s;
        if (r3 == null) goto L5;
        BarrageSettingArea r1 = r3.a;
    L6:
        if (r1 != null) goto L8;
        return r0;
    L8:
        BarrageSettingArea r4 = r3.a;
        if (r4 == null) goto L28;
        int r5 = com.bytedance.android.livesdk.interactivity.zdanmaku.cast.b.a[r4.ordinal()];
        if (r5 == 1) goto L24;
        if (r5 == 2) goto L27;
        if (r5 == 3) goto L26;
        if (r5 == 4) goto L25;
        return r0;
    L25:
        return r0 * 0;
    L26:
        return r0 * 1;
    L27:
        return r0 / 2;
    L24:
        return r0 / 4;
    L28:
        return r0;
    L5:
        r1 = null;
        goto L6
    }

    public final <T> void L7(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final void X(Object r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "danmakuData");
        if (v == false) goto L8;
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.k;
        if (r0 == null) goto L9;
        r0.a(r2, r3);
        return;
    L9:
        return;
    }
}
