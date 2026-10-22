package com.bytedance.android.livesdk.chorusconcert;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.android.annie.util.p;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.android.livesdk.chatroom.progress.context.PlayerProgressServiceContext;
import com.bytedance.android.livesdk.chatroom.progress.service.IPlayerProgressService;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.PlayerViewControl;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.ktvapi.concert_stage.models.JoinChorusConcertStatus;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.widget.LiveVerticalViewPager;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chorusconcert/VSChorusConcertWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "<init>", "()V", "a", "vs-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSChorusConcertWidget extends LiveRecyclableWidget {
    public static final /* synthetic */ int l = 0;
    public FrameLayout a;
    public View b;
    public SurfaceView c;
    public ViewGroup d;
    public View e;
    public Pair<Integer, Integer> f;
    public IPlayerProgressService g;
    public PlayerProgressServiceContext h;
    public boolean i;
    public final CompositeDisposable j;
    public final b k;

    public static final class a {
    }

    public static final class b implements gd2.b {
        public final /* synthetic */ VSChorusConcertWidget a;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                VSChorusConcertWidget r0 = this.a.a;     // Catch: Throwable -> L10
                Context r1 = ((Widget) r0).context;     // Catch: Throwable -> L10
                if (r1 == null) goto L7;
                Resources r2 = r1.getResources();     // Catch: Throwable -> L10
                if (r2 == null) goto L7;
                Configuration r3 = r2.getConfiguration();     // Catch: Throwable -> L10
            L8:
                int r4 = VSChorusConcertWidget.l;     // Catch: Throwable -> L10
                r0.Aq(r3, true);     // Catch: Throwable -> L10
                return;
            L7:
                r3 = null;
            L10:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L14;
                return;
            L14:
                throw th;
            }
        }

        public final void c() {
            Intrinsics.checkNotNullParameter("hide", "reason");
            VSChorusConcertWidget r0 = this.a;
            int r1 = VSChorusConcertWidget.l;
            r0.zq("onChorusCardHide");
            es1.a r2 = this.a.xq(false);
            if (r2 == null) goto L5;
            r2.a = false;
        L5:
            this.a.yq();
        }

        public final void d() {
            VSChorusConcertWidget r0 = this.a;
            int r1 = VSChorusConcertWidget.l;
            r0.zq("onChorusCardShow");
            es1.a r2 = this.a.xq(false);
            if (r2 == null) goto L5;
            r2.a = true;
        L5:
            this.a.Cq();
            VSChorusConcertWidget r3 = this.a;
            FrameLayout r4 = r3.a;
            if (r4 == null) goto L10;
            es1.a r5 = r3.xq(false);
            if (r5 == null) goto L10;
            WidgetManager r6 = ((Widget) this.a).subWidgetManager;
            Intrinsics.checkNotNullParameter(r4, "container");
            Intrinsics.checkNotNullParameter(r6, "subWidgetManager");
            r5.d = r4.getChildAt(0);
            es1.a.c("attachChorusCard " + r5.d);
        L10:
            FrameLayout r7 = this.a.a;
            if (r7 == null) goto L14;
            r7.post(new a(this));
            return;
        }

        public b(VSChorusConcertWidget r1) {
            this.a = r1;
        }

        public final void a(int r7) {
            int r2 = VSChorusConcertWidget.l;
            this.a.zq("onChorusStateChanged state:" + r7);
            es1.a r0 = this.a.xq(true);
            if (r0 == null) goto L8;
            r0.b = r7;
            if (r7 == JoinChorusConcertStatus.JOINED.getValue()) goto L8;
            JoinChorusConcertStatus.JOINING.getValue();
        L8:
            if (r7 != JoinChorusConcertStatus.JOINING.getValue()) goto L14;
            VSChorusConcertWidget r8 = this.a;
            r8.zq("disableSeek");
            ViewGroup r1 = ((Widget) r8).containerView;
            if (r1 == null) goto L12;
            r1.post(new ds1.a(r8));
        L12:
            ((Widget) r8).dataCenter.put("key_chorus_disable_seek_toast", "您已在合唱中，请保持最新进度");
            VSChorusConcertWidget.wq(this.a, true);
            return;
        L14:
            if (r7 != JoinChorusConcertStatus.JOINED.getValue()) goto L25;
            VSChorusConcertWidget r9 = this.a;
            r9.zq("disableSeek");
            ViewGroup r3 = ((Widget) r9).containerView;
            if (r3 == null) goto L18;
            r3.post(new ds1.a(r9));
        L18:
            ((Widget) r9).dataCenter.put("key_chorus_disable_seek_toast", "您已在合唱中，请保持最新进度");
            MiddlewareRoomContext r10 = o3.b();
            if (r10 == null) goto L23;
            m r11 = r10.getVsInChorusConcert();
            if (r11 == null) goto L23;
            r11.setValue(Boolean.FALSE);
        L23:
            VSChorusConcertWidget.wq(this.a, true);
            return;
        L25:
            if (r7 != JoinChorusConcertStatus.LEAVING.getValue()) goto L42;
            VSChorusConcertWidget r12 = this.a;
            SurfaceView r4 = r12.c;
            if (r4 == null) goto L42;
            r12.zq("replaceSurface remove");
            ViewGroup r5 = r12.d;
            if (r5 == null) goto L31;
            r5.removeView(r4);
        L31:
            es1.a r13 = r12.xq(false);
            if (r13 == null) goto L42;
            View r6 = r13.e;
            if (r6 == null) goto L41;
            ViewParent r14 = r6.getParent();
            if ((r14 instanceof ViewGroup) == true) goto L38;
            r14 = null;
        L38:
            ViewGroup r15 = (ViewGroup) r14;
            if (r15 == null) goto L41;
            r15.removeView(r6);
        L41:
            r13.e = null;
        L42:
            VSChorusConcertWidget r16 = this.a;
            r16.zq("enableSeek");
            PlayerProgressServiceContext r17 = r16.h;
            if (r17 == null) goto L47;
            m r18 = r17.getDisableSeek();
            if (r18 == null) goto L47;
            r18.setValue(Boolean.FALSE);
        L47:
            ((Widget) r16).dataCenter.put("key_chorus_disable_seek_toast", null);
            VSChorusConcertWidget.wq(this.a, false);
            es1.a r19 = this.a.xq(false);
            if (r19 == null) goto L61;
            View r20 = r19.e;
            if (r20 == null) goto L57;
            ViewParent r21 = r20.getParent();
            if ((r21 instanceof ViewGroup) == true) goto L54;
            r21 = null;
        L54:
            ViewGroup r22 = (ViewGroup) r21;
            if (r22 == null) goto L57;
            r22.removeView(r20);
        L57:
            r19.e = null;
            return;
        }

        public final void b(SurfaceView r7) {
            Intrinsics.checkNotNullParameter(r7, "surfaceView");
            int r2 = VSChorusConcertWidget.l;
            this.a.zq("onLinkSuccess" + r7);
            VSChorusConcertWidget r0 = this.a;
            r0.c = r7;
            if (r0.i == false) goto L9;
            IKtvService r8 = k.f(IKtvService.class);
            if (r8 == null) goto L17;
            gd2.c r9 = r8.getChorusConcertService();
            if (r9 == null) goto L17;
            r9.e(true);
        L17:
            if (this.a.isScreenLandscape() == false) goto L20;
            boolean r10 = MatchRoomLandScapeAnimUtil.a;
            MatchRoomLandScapeAnimUtil.c("chorus_surface", this.a.c, true, false, false, 24);
            return;
        L20:
            return;
        L9:
            ViewGroup r1 = r0.d;
            if (r1 == null) goto L17;
            View r3 = r0.e;
            if (r3 == null) goto L17;
            es1.a r4 = r0.xq(true);
            if (r4 == null) goto L17;
            r4.a(r7, r1, r3);
            goto L17
        }

        public final void f(SurfaceView r3) {
            Intrinsics.checkNotNullParameter(r3, "surfaceView");
            VSChorusConcertWidget r0 = this.a;
            int r1 = VSChorusConcertWidget.l;
            r0.zq("onRtcSurfaceViewCreated");
            this.a.c = r3;
        }

        public final void e(int r4, int r5) {
            int r2 = VSChorusConcertWidget.l;
            this.a.zq("onChorusSizeUpdate height:" + r4 + " width:" + r5);
            FrameLayout r0 = this.a.a;
            if (r0 == null) goto L7;
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
            if (r1 == null) goto L7;
            r1.height = r4;
        L7:
            FrameLayout r6 = this.a.a;
            if (r6 == null) goto L12;
            ViewGroup.LayoutParams r7 = r6.getLayoutParams();
            if (r7 == null) goto L12;
            r7.width = r5;
        L12:
            FrameLayout r8 = this.a.a;
            if (r8 == null) goto L16;
            r8.requestLayout();
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ VSChorusConcertWidget a;

        public c(VSChorusConcertWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VSChorusConcertWidget r0 = this.a;     // Catch: Throwable -> L8
            View r1 = r0.e;     // Catch: Throwable -> L8
            if (r1 == null) goto L11;
            es1.a r2 = r0.xq(false);     // Catch: Throwable -> L8
            if (r2 == null) goto L15;
            r2.b(r1);     // Catch: Throwable -> L8
            return;
        L15:
            return;
        L11:
            return;
        L8:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L16;
            throw th;
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ VSChorusConcertWidget a;
        public final /* synthetic */ ViewGroup b;

        public d(VSChorusConcertWidget r1, ViewGroup r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            int r0 = p.a.a(100.0f);
            ViewGroup r2 = this.b;
            FrameLayout r3 = this.a.a;
            if (r3 == null) goto L5;
            float r4 = r3.getHeight();
        L6:
            r2.setTranslationY((-r4) - r0);
            this.b.setTranslationZ(100.0f);
            this.a.zq("resolvePadFoldCard pad landscape, transY to " + this.b.getTranslationY());
            return;
        L5:
            r4 = 0.0f;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e implements Runnable {
        public final /* synthetic */ VSChorusConcertWidget a;
        public final /* synthetic */ ViewGroup b;

        public e(VSChorusConcertWidget r1, ViewGroup r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.setTranslationY(0.0f);     // Catch: Throwable -> L4
            VSChorusConcertWidget r0 = this.a;     // Catch: Throwable -> L4
            int r1 = VSChorusConcertWidget.l;     // Catch: Throwable -> L4
            r0.zq("resolvePadFoldCard pad portrait, transY to 0");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements Runnable {
        public final /* synthetic */ VSChorusConcertWidget a;
        public final /* synthetic */ ViewGroup b;

        public f(VSChorusConcertWidget r1, ViewGroup r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            int r0 = p.a.a(100.0f);
            ViewGroup r2 = this.b;
            FrameLayout r3 = this.a.a;
            if (r3 == null) goto L5;
            float r4 = r3.getHeight();
        L6:
            r2.setTranslationY((-r4) - r0);
            this.b.setTranslationZ(100.0f);
            this.a.zq("resolvePadFoldCard fold expanded, transY to " + this.b.getTranslationY());
            return;
        L5:
            r4 = 0.0f;
            goto L6
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ VSChorusConcertWidget a;
        public final /* synthetic */ ViewGroup b;

        public g(VSChorusConcertWidget r1, ViewGroup r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.setTranslationY(0.0f);     // Catch: Throwable -> L4
            VSChorusConcertWidget r0 = this.a;     // Catch: Throwable -> L4
            int r1 = VSChorusConcertWidget.l;     // Catch: Throwable -> L4
            r0.zq("resolvePadFoldCard fold collapsed, transY to 0");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class h implements Runnable {
        public final /* synthetic */ VSChorusConcertWidget a;

        public h(VSChorusConcertWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            VSChorusConcertWidget r0 = this.a;     // Catch: Throwable -> L9
            View r1 = r0.e;     // Catch: Throwable -> L9
            if (r1 == null) goto L12;
            es1.a r2 = r0.xq(false);     // Catch: Throwable -> L9
            if (r2 == null) goto L16;
            r2.b(r1);     // Catch: Throwable -> L9
            return;
        L16:
            return;
        L12:
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L17;
            throw th;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131567956;
    }

    public final void Bq() {
        zq("try restoreChorusSurfaceView");
        es1.a r1 = xq(false);
        SurfaceView r2 = null;
        View r3 = null;
        r2 = null;
        if (r1 == null) goto L11;
        View r4 = r1.e;
        if (r4 == null) goto L11;
        if ((r4 instanceof SurfaceView) == false) goto L10;
        r3 = r4;
    L10:
        r2 = (SurfaceView) r3;
    L11:
        es1.a r5 = xq(false);
        if (r5 != null) goto L14;
    L15:
        es1.a r6 = xq(false);
        if (r6 != null) goto L18;
        return;
    L18:
        if (r6.b != JoinChorusConcertStatus.JOINING.getValue()) goto L37;
    L19:
        if (r2 == null) goto L38;
        zq("restoreSurfaceView now");
        this.c = r2;
        ViewGroup r7 = this.d;
        if (r7 == null) goto L28;
        View r8 = this.e;
        if (r8 == null) goto L28;
        es1.a r0 = xq(false);
        if (r0 == null) goto L28;
        r0.a(r2, r7, r8);
    L28:
        if (isScreenLandscape() == false) goto L30;
        boolean r9 = MatchRoomLandScapeAnimUtil.a;
        MatchRoomLandScapeAnimUtil.c("chorus_surface", this.c, false, false, false, 28);
    L30:
        IKtvService r10 = k.f(IKtvService.class);
        if (r10 == null) goto L39;
        gd2.c r11 = r10.getChorusConcertService();
        if (r11 == null) goto L40;
        r11.f(r2.getWidth(), r2.getHeight());
        return;
    L40:
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L14:
        if (r5.b == JoinChorusConcertStatus.JOINED.getValue()) goto L19;
        goto L15
    }

    public final void Cq() {
        zq("showChorusCard");
        es1.a r1 = xq(false);
        if (r1 != null) goto L5;
    L8:
        es1.a r2 = xq(false);
        if (r2 != null) goto L11;
    L20:
        FrameLayout r3 = this.a;
        if (r3 == null) goto L24;
        r3.setVisibility(0);
    L24:
        if (isScreenLandscape() == true) goto L32;
        InteractionWidgetsPosContext.Companion.getClass();
        InteractionWidgetsPosContext r0 = InteractionWidgetsPosContext.a.a();
        if (r0 == null) goto L30;
        m r4 = r0.getVsChorusConcertHeight();
        if (r4 == null) goto L30;
        r4.setValue(Integer.valueOf(p.a.a(115.0f)));
    L30:
        zq("set vsChorusConcertHeight" + p.a.a(115.0f));
        return;
    L32:
        return;
    L11:
        if (r2.a != true) goto L20;
        PlayerProgressServiceContext r5 = this.h;
        if (r5 == null) goto L20;
        m r6 = r5.getAtLatest();
        if (r6 == null) goto L20;
        if (((Boolean) r6.getValue()).booleanValue() == true) goto L20;
        zq("showChorusCard return cause isCardShouldShow == true and atLatest == false");
        yq();
        return;
    L5:
        if (r1.a == true) goto L8;
        zq("showChorusCard return cause isCardShouldShow == false");
        yq();
    }

    public final void onDestroy() {
        zq("destroyChorusCard");
        super.onDestroy();
    }

    public final void onUnload() {
        zq("onUnload");
        this.j.clear();
        IKtvService r0 = k.f(IKtvService.class);
        if (r0 == null) goto L7;
        gd2.c r1 = r0.getChorusConcertService();
        if (r1 == null) goto L7;
        r1.a(this.k);
    L7:
        es1.a r2 = xq(false);
        if (r2 == null) goto L11;
        r2.f = null;
        return;
    }

    public final void yq() {
        zq("hideChorusCard");
        if (isScreenLandscape() == true) goto L10;
        InteractionWidgetsPosContext.Companion.getClass();
        InteractionWidgetsPosContext r0 = InteractionWidgetsPosContext.a.a();
        if (r0 == null) goto L9;
        m r1 = r0.getVsChorusConcertHeight();
        if (r1 == null) goto L9;
        r1.setValue(0);
    L9:
        zq("set vsChorusConcertHeight 0");
    L10:
        FrameLayout r2 = this.a;
        if (r2 == null) goto L14;
        r2.setVisibility(8);
        return;
    }

    public VSChorusConcertWidget() {
        this.f = new Pair(0, 0);
        this.j = new CompositeDisposable();
        this.k = new b(this);
    }

    public final void onPause() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onPause();
        IKtvService r0 = k.f(IKtvService.class);
        if (r0 == null) goto L8;
        gd2.f r1 = r0.getConcertStageService();
        if (r1 == null) goto L9;
        r1.onPause();
        return;
    L9:
        return;
    }

    public final void onResume() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onResume();
        IKtvService r0 = k.f(IKtvService.class);
        if (r0 == null) goto L8;
        gd2.f r1 = r0.getConcertStageService();
        if (r1 == null) goto L9;
        r1.onResume();
        return;
    L9:
        return;
    }

    public final void onConfigurationChanged(Configuration r3) {
        zq("onConfigurationChanged " + r3);
        Aq(r3, false);
        super/*com.bytedance.ies.sdk.widgets.Widget*/.onConfigurationChanged(r3);
        IKtvService r1 = k.f(IKtvService.class);
        if (r1 == null) goto L7;
        gd2.f r2 = r1.getConcertStageService();
        if (r2 == null) goto L7;
        r2.onConfigurationChanged(r3);
    L7:
        FrameLayout r4 = this.a;
        if (r4 == null) goto L10;
        View r5 = r4.getChildAt(0);
    L11:
        this.b = r5;
        return;
    L10:
        r5 = null;
        goto L11
    }

    public final void onInit(Object[] r5) {
        zq("onInit");
        this.a = (FrameLayout) ((Widget) this).containerView.findViewById(2131392922);
        DataCenter r6 = ((Widget) this).dataCenter;
        if (r6 == null) goto L14;
        IRoom r7 = lu2.c.f(r6);
        if (r7 == null) goto L14;
        long r0 = r7.getId();
        es1.a.C0384a r8 = es1.a.j;
        monitor-enter(r8);
        es1.a.i.remove(Long.valueOf(r0));     // Catch: Throwable -> L11
        monitor-exit(r8);
        r8.b(r0);
    L11:
        th = move-exception;
        throw th;
    L14:
        Context r9 = ((Widget) this).context;
        if (r9 == null) goto L24;
        Resources r10 = r9.getResources();
        if (r10 == null) goto L25;
        Configuration r11 = r10.getConfiguration();
        if (r11 == null) goto L26;
        this.f = new Pair(Integer.valueOf(r11.screenWidthDp), Integer.valueOf(r11.screenHeightDp));
        return;
    L26:
        return;
    L25:
        return;
    }

    public final void onLoad(Object[] r6) {
        zq("onLoad");
        View r7 = ((Widget) this).containerView;
    L3:
        PlayerProgressServiceContext r0 = null;
        if (r7 != null) goto L160;
        ViewParent r1 = null;
    L10:
        if ((r1 instanceof View) == false) goto L20;
        Object r2 = r7.getParent();     // Catch: Exception -> L6
        if (r2 == null) goto L18;
        View r3 = (View) r2;     // Catch: Exception -> L6
        if ((r3 instanceof LiveVerticalViewPager) == true) goto L22;
        r7 = r3;
    L22:
        if (r7 == null) goto L33;
        View r8 = r7.findViewById(2131389695);
        this.e = r8;
        if (r8 == null) goto L28;
        ViewParent r9 = r8.getParent();
        if (r9 == null) goto L28;
        ViewParent r10 = r9.getParent();
    L30:
        if ((r10 instanceof ViewGroup) == true) goto L32;
        r10 = null;
    L32:
        this.d = (ViewGroup) r10;
        zq("Successfully found playerView within the current page.");
    L51:
        if (this.e != null) goto L53;
    L54:
        zq("!!! Failed to get playerView or its container.");
    L55:
        enableSubWidgetManager();
        if (this.e != null) goto L58;
    L59:
        zq("!!! Failed to get playerView or its container from IVSPlayerService.");
    L60:
        zq("initChorusCard");
        es1.a r4 = xq(true);
        if (r4 == null) goto L65;
        View r5 = r4.d;
        if (r5 == null) goto L65;
    L66:
        if (r5 == null) goto L88;
        zq("restoreChorusCardView success");
        zq("try restoreChorusCardView");
        es1.a r11 = xq(false);
        if (r11 == null) goto L72;
        View r12 = r11.d;
        if (r12 == null) goto L72;
    L73:
        if (r12 != null) goto L162;
    L87:
        Bq();
    L94:
        if (isScreenLandscape() == false) goto L110;
        IVSPlayerService r13 = (IVSPlayerService) k.f(IVSPlayerService.class);
        if (r13 == null) goto L102;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r14 = r13.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r14 == null) goto L102;
        NextLiveData<Integer> r15 = r14.g(PlayerViewControl.KEY.PlayerShadowBottom);
        if (r15 == null) goto L102;
        Integer r16 = (Integer) r15.getValue();
    L103:
        if (r16 == null) goto L110;
        if (r16.intValue() != 0) goto L110;
        FrameLayout r17 = this.a;
        if (r17 == null) goto L113;
        r17.setAlpha(0.2f);
    L113:
        yq();
        IKtvService r18 = k.f(IKtvService.class);
        if (r18 == null) goto L119;
        gd2.c r19 = r18.getChorusConcertService();
        if (r19 == null) goto L119;
        r19.c(this.k);
    L119:
        if (isScreenLandscape() == false) goto L139;
        IVSPlayerService r20 = (IVSPlayerService) k.f(IVSPlayerService.class);
        if (r20 == null) goto L127;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r21 = r20.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r21 == null) goto L127;
        NextLiveData<Integer> r22 = r21.g(PlayerViewControl.KEY.PlayerShadowBottom);
        if (r22 == null) goto L127;
        r22.observe(this, new ds1.b(this));
    L127:
        Disposable r23 = MatchRoomLandScapeAnimUtil.d.observeOn(AndroidSchedulers.mainThread()).subscribe(new ds1.c(this), ds1.d.a);
        if (r23 == null) goto L130;
        RxUtilKt.c(r23, this.j);
    L130:
        MiddlewareRoomContext r24 = o3.b();
        if (r24 == null) goto L139;
        m r25 = r24.isLandscapeLock();
        if (r25 == null) goto L139;
        Observable r26 = r25.a();
        if (r26 == null) goto L139;
        Disposable r27 = r26.subscribe(new ds1.e(this));
        if (r27 == null) goto L139;
        RxUtilKt.c(r27, this.j);
    L139:
        IPlayerProgressService r28 = k.n(rk1.a.class).M4(((Widget) this).dataCenter);
        this.g = r28;
        if (r28 == null) goto L142;
        r0 = r28.provideContext(((Widget) this).dataCenter);
    L142:
        this.h = r0;
        if (r0 == null) goto L151;
        com.bytedance.live.datacontext.k r29 = r0.getShowLatestEvent();
        if (r29 == null) goto L151;
        PublishSubject r30 = r29.onEvent();
        if (r30 == null) goto L151;
        Disposable r31 = r30.subscribe(new ds1.f(this));
        if (r31 == null) goto L151;
        RxUtilKt.c(r31, this.j);
    L151:
        es1.a r32 = xq(true);
        if (r32 == null) goto L155;
        r32.c = true;
    L155:
        if (isScreenLandscape() == false) goto L167;
        FrameLayout r33 = this.a;
        if (r33 == null) goto L168;
        r33.post(new c(this));
        return;
    L168:
        return;
    L167:
        return;
    L102:
        r16 = null;
    L110:
        FrameLayout r34 = this.a;
        if (r34 == null) goto L113;
        r34.setAlpha(1.0f);
        goto L113
    L162:
        ViewParent r35 = r12.getParent();     // Catch: Exception -> L85
        if ((r35 instanceof ViewGroup) == true) goto L77;
        r35 = null;
    L77:
        ViewGroup r36 = (ViewGroup) r35;     // Catch: Exception -> L85
        if (r36 == null) goto L80;
        r36.removeView(r12);     // Catch: Exception -> L85
    L80:
        FrameLayout r37 = this.a;     // Catch: Exception -> L85
        if (r37 == null) goto L83;
        r37.addView(r12);     // Catch: Exception -> L85
    L83:
        Cq();     // Catch: Exception -> L85
        zq("restoreChorusCardView success and addview now");     // Catch: Exception -> L85
    L85:
        e = move-exception;
        zq("restoreChorusCardView exception: " + e);
    L72:
        r12 = null;
        goto L73
    L88:
        zq("no chorusCard cache & initChorusCard continue");
        FrameLayout r38 = this.a;
        if (r38 == null) goto L94;
        IKtvService r39 = k.f(IKtvService.class);
        if (r39 == null) goto L94;
        r39.initChorusService(((Widget) this).context, r38, ((Widget) this).dataCenter);
    L65:
        r5 = null;
        goto L66
    L58:
        if (this.d != null) goto L60;
    L53:
        if (this.d != null) goto L55;
    L28:
        r10 = null;
        goto L30
    L33:
        zq("!!! CRITICAL: Could not find page root. Falling back to activity search.");
        Context r40 = ((Widget) this).context;
        if ((r40 instanceof Activity) == true) goto L36;
        r40 = null;
    L36:
        Activity r41 = (Activity) r40;
        if (r41 == null) goto L39;
        View r42 = r41.findViewById(2131389695);
    L40:
        this.e = r42;
        if (r42 == null) goto L45;
        ViewParent r43 = r42.getParent();
        if (r43 == null) goto L45;
        ViewParent r44 = r43.getParent();
    L47:
        if ((r44 instanceof ViewGroup) == true) goto L49;
        r44 = null;
    L49:
        this.d = (ViewGroup) r44;
    L45:
        r44 = null;
        goto L47
    L39:
        r42 = null;
        goto L40
    L18:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");     // Catch: Exception -> L6
    L6:
        e = move-exception;
        ALogger.e("VSChorusConcertWidget", "findPageRootView error", e);
    L20:
        r7 = null;
        goto L22
    L160:
        r1 = r7.getParent();     // Catch: Exception -> L6
        goto L10
    }

    public final es1.a xq(boolean r5) {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L7;
        IRoom r1 = lu2.c.f(r0);
        if (r1 == null) goto L7;
        long r2 = r1.getId();
        return es1.a.j.c(r2, ((Widget) this).context, r5);
    L7:
        return null;
    }

    public final void zq(String r2) {
        ALogger.i("VSChorusConcertWidget", r2);
    }

    public static final void wq(VSChorusConcertWidget r0, boolean r1) {
        r0.getClass();
        MiddlewareRoomContext r2 = o3.b();
        if (r2 == null) goto L8;
        m r3 = r2.getVsInChorusConcert();
        if (r3 == null) goto L9;
        r3.setValue(Boolean.valueOf(r1));
        return;
    L9:
        return;
    }

    public final void Aq(Configuration r6, boolean r7) {
        if (PadConfigUtils.c() == false) goto L5;
    L6:
        StringBuilder r0 = new StringBuilder("resolvePadFoldCard: newConfig.orientation=");
        ViewParent r1 = null;
        if (r6 == null) goto L9;
        Integer r2 = Integer.valueOf(r6.orientation);
    L10:
        r0.append(r2);
        r0.append(", newConfig.width=");
        if (r6 == null) goto L13;
        Integer r3 = Integer.valueOf(r6.screenWidthDp);
    L14:
        r0.append(r3);
        r0.append(", newConfig.height=");
        if (r6 == null) goto L17;
        Integer r4 = Integer.valueOf(r6.screenHeightDp);
    L18:
        r0.append(r4);
        r0.append(", previousSize=");
        r0.append(this.f);
        zq(r0.toString());
        if (r7 == false) goto L21;
        if (r6 == null) goto L21;
    L26:
        FrameLayout r8 = this.a;
        if (r8 == null) goto L31;
        ViewParent r9 = r8.getParent();
        if (r9 == null) goto L31;
        ViewParent r10 = r9.getParent();
    L33:
        if ((r10 instanceof ViewGroup) == true) goto L35;
        r10 = null;
    L35:
        ViewGroup r11 = (ViewGroup) r10;
        if (r11 != null) goto L39;
        return;
    L39:
        if (PadConfigUtils.c() == false) goto L62;
        int r5 = r6.orientation;
        if (r5 != 2) goto L51;
        ViewParent r12 = r11.getParent();
        if ((r12 instanceof ViewGroup) == true) goto L45;
        r12 = null;
    L45:
        ViewGroup r13 = (ViewGroup) r12;
        if (r13 == null) goto L48;
        r13.setClipChildren(false);
    L48:
        r11.setClipChildren(false);
        FrameLayout r14 = this.a;
        if (r14 == null) goto L62;
        r14.post(new d(this, r11));
        goto L62
    L51:
        if (r5 != 1) goto L62;
        ViewParent r15 = r11.getParent();
        if ((r15 instanceof ViewGroup) == true) goto L55;
        r15 = null;
    L55:
        ViewGroup r16 = (ViewGroup) r15;
        if (r16 == null) goto L58;
        r16.setClipChildren(true);
    L58:
        r11.setClipChildren(true);
        FrameLayout r17 = this.a;
        if (r17 == null) goto L62;
        r17.post(new e(this, r11));
    L62:
        if (FoldScreenUtils.f() == true) goto L64;
    L85:
        FrameLayout r18 = this.a;
        if (r18 == null) goto L88;
        r18.post(new h(this));
    L88:
        this.f = new Pair(Integer.valueOf(r6.screenWidthDp), Integer.valueOf(r6.screenHeightDp));
        Bq();
        return;
    L64:
        if (FoldScreenUtils.a() != 0) goto L75;
        ViewParent r19 = r11.getParent();
        if ((r19 instanceof ViewGroup) == false) goto L69;
        r1 = r19;
    L69:
        ViewGroup r20 = (ViewGroup) r1;
        if (r20 == null) goto L72;
        r20.setClipChildren(false);
    L72:
        r11.setClipChildren(false);
        FrameLayout r21 = this.a;
        if (r21 == null) goto L85;
        r21.post(new f(this, r11));
        goto L85
    L75:
        ViewParent r22 = r11.getParent();
        if ((r22 instanceof ViewGroup) == false) goto L79;
        r1 = r22;
    L79:
        ViewGroup r23 = (ViewGroup) r1;
        if (r23 == null) goto L82;
        r23.setClipChildren(true);
    L82:
        r11.setClipChildren(true);
        FrameLayout r24 = this.a;
        if (r24 == null) goto L85;
        r24.post(new g(this, r11));
    L31:
        r10 = null;
    L21:
        if (r6 != null) goto L23;
        return;
    L23:
        if (((Number) this.f.getFirst()).intValue() != r6.screenWidthDp) goto L26;
        if (((Number) this.f.getSecond()).intValue() != r6.screenHeightDp) goto L26;
        return;
    L17:
        r4 = null;
        goto L18
    L13:
        r3 = null;
        goto L14
    L9:
        r2 = null;
        goto L10
    L5:
        if (FoldScreenUtils.f() == true) goto L6;
    }
}
