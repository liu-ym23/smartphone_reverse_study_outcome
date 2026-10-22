package com.bytedance.android.livesdk.interactivity.barrage.widget;

import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.b0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.z;
import com.bytedance.android.livesdk.interactivity.api.seek.EpisodeInteractivityTracer;
import com.bytedance.android.livesdk.interactivity.api.settings.config.a1;
import com.bytedance.android.livesdk.interactivity.barrage.carnival.VSLandscapeDanmakuCarnivalTrayManager;
import com.bytedance.android.livesdk.interactivity.barrage.view.CarnivalRenderEngineView;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.CarnivalDanmakuPresenter;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.VSLandscapeCarnivalDanmakuPresenter;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.zdanmaku.DanmakuController;
import com.bytedance.live.zdanmaku.data.Danmaku;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p22.p;
import tc2.k;
import zg1.e3;
import zg1.w0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/widget/VSLandscapeCarnivalDanmakuWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/interactivity/zdanmaku/widget/CarnivalDanmakuPresenter$IView;", "<init>", "()V", "a", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VSLandscapeCarnivalDanmakuWidget extends MiddlewareRoomWidget implements CarnivalDanmakuPresenter.IView {
    public static final /* synthetic */ int q = 0;
    public BarrageWidgetContext a;
    public final int b;
    public final int c;
    public final com.bytedance.android.livesdk.interactivity.utils.f d;
    public final CompositeDisposable e;
    public VSLandscapeDanmakuCarnivalTrayManager f;
    public final Lazy g;
    public com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> h;
    public com.bytedance.android.livesdk.interactivity.zdanmaku.layout.e i;
    public final b j;
    public VSLandscapeCarnivalDanmakuPresenter k;
    public boolean l;
    public p m;
    public Pair<Integer, Integer> n;
    public float o;
    public float p;

    public static final class a {
    }

    public static final class b implements DanmakuController.b<com.bytedance.android.livesdk.interactivity.zdanmaku.i> {
        public final /* synthetic */ VSLandscapeCarnivalDanmakuWidget a;

        public b(VSLandscapeCarnivalDanmakuWidget r1) {
            this.a = r1;
        }

        public final void a(Danmaku r2) {
            com.bytedance.android.livesdk.interactivity.zdanmaku.i r3 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r2;
            Intrinsics.checkNotNullParameter(r3, "danmaku");
            VSLandscapeCarnivalDanmakuPresenter r0 = this.a.k;
            if (r0 == null) goto L6;
            r0.p0(r3);
            return;
        }

        public final void b(Danmaku r3) {
            com.bytedance.android.livesdk.interactivity.zdanmaku.i r4 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r3;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            if (this.a.k == null) goto L8;
            Intrinsics.checkNotNullParameter(r4, "danmaku");
            RenderEntity r5 = r4.b();
            Intrinsics.checkNotNullParameter(r5, "$this$onShow");
            k r0 = (k) r5.e(k.class);
            if (r0 == null) goto L9;
            r0.a(r5);
            return;
        L9:
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ VSLandscapeCarnivalDanmakuWidget a;

        public c(VSLandscapeCarnivalDanmakuWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Boolean r4 = (Boolean) r3;
            if (r4 == null) goto L20;
            r4.booleanValue();
            float r1 = 1.0f;
            if (com.bytedance.android.livesdk.f.d().d == false) goto L12;
            int r5 = a1.a;
            if (a1.a.a().d() == false) goto L21;
            VSLandscapeCarnivalDanmakuWidget r6 = this.a;
            int r0 = VSLandscapeCarnivalDanmakuWidget.q;
            View r7 = ((Widget) r6).contentView;
            if (r7 == null) goto L23;
            r7.setAlpha(1.0f);
            return;
        L23:
            return;
        L21:
            return;
        L12:
            VSLandscapeCarnivalDanmakuWidget r2 = this.a;
            if (r4.booleanValue() == false) goto L15;
            r1 = 0.2f;
        L15:
            int r8 = VSLandscapeCarnivalDanmakuWidget.q;
            View r9 = ((Widget) r2).contentView;
            if (r9 == null) goto L24;
            r9.setAlpha(r1);
            return;
        L24:
            return;
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ VSLandscapeCarnivalDanmakuWidget a;

        public d(VSLandscapeCarnivalDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((Boolean) r2).booleanValue() == false) goto L7;
            ViewGroup r3 = ((Widget) this.a).containerView;
            if (r3 == null) goto L11;
            r3.setAlpha(0.0f);
            return;
        L11:
            return;
        L7:
            ViewGroup r4 = ((Widget) this.a).containerView;
            if (r4 == null) goto L13;
            r4.setAlpha(1.0f);
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ VSLandscapeCarnivalDanmakuWidget a;

        public e(VSLandscapeCarnivalDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r18) {
            if (((Boolean) r18).booleanValue() == false) goto L111;
            VSLandscapeCarnivalDanmakuWidget r1 = this.a;
            BarrageWidgetContext r2 = r1.a;
            if (r2 == null) goto L26;
            n<com.bytedance.android.livesdk.interactivity.api.barrage.data.d> r3 = r2.getChatCarnivalMessage();
            if (r3 == null) goto L26;
            com.bytedance.android.livesdk.interactivity.api.barrage.data.d r4 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.d) r3.getValue();
            if (r4 == null) goto L26;
            ViewGroup r6 = ((Widget) r1).containerView;
            if (r6 == null) goto L13;
            int r7 = r6.getWidth();
        L14:
            if (r7 <= 0) goto L19;
            ViewGroup r8 = ((Widget) r1).containerView;
            if (r8 == null) goto L18;
            int r9 = r8.getWidth();
        L20:
            int r10 = r9;
        L21:
            int r11 = r1.xq(((BarrageSetting) l42.a.d.getValue()).getBarrageArea());
            int r13 = (int) ((r10 / ((int) UtilityKotlinExtentionsKt.h(Math.max(r4.t(), 800) / 10.0f))) * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
            int r14 = r1.c;
            int r15 = UtilityKotlinExtentionsKt.i(2);
            if (r4.k() != 1) goto L24;
            boolean r16 = true;
        L25:
            q72.a r17 = new q72.a(r10, r11, r14, r15, r13, r16);
            com.bytedance.android.livesdk.interactivity.barrage.widget.g r5 = new com.bytedance.android.livesdk.interactivity.barrage.widget.g();
            com.bytedance.live.zdanmaku.data.d r19 = new com.bytedance.live.zdanmaku.data.d();
            r19.a(z.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
            r19.a(b0.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
            com.bytedance.android.livesdk.interactivity.zdanmaku.layout.e r20 = new com.bytedance.android.livesdk.interactivity.zdanmaku.layout.e(r17);
            int r21 = com.bytedance.live.zdanmaku.e.i;
            com.bytedance.live.zdanmaku.e.a r23 = new com.bytedance.live.zdanmaku.e.a();
            r23.b(q72.b.class, new com.bytedance.android.livesdk.interactivity.zdanmaku.binder.g((View) DanmakuCacheProviders.j.getValue(), r1.a));
            r23.b(q72.c.class, new com.bytedance.android.livesdk.interactivity.zdanmaku.binder.h((View) DanmakuCacheProviders.l.getValue(), r1.a));
            r23.b = r19;
            r23.d = AsyncTask.THREAD_POOL_EXECUTOR;
            r23.a = new vc2.a("VS Carnival");
            com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r24 = r23.a(r1.wq(), r5, r20);
            r1.h = r24;
            r24.g.h = r1.j;
            r24.b();
            Unit r25 = Unit.INSTANCE;
            r1.i = r20;
            goto L26
        L24:
            r16 = false;
            goto L25
        L18:
            r10 = 0;
            goto L21
        L19:
            r9 = s1.y();
            goto L20
        L13:
            r7 = 0;
        L26:
            IInteractivityInjectService r26 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
            Integer r27 = null;
            if (r26 == null) goto L31;
            ILivePlayerClient r28 = r26.currentClient();
            if (r28 == null) goto L31;
            Pair<Integer, Integer> r29 = r28.getVideoSize();
        L32:
            r1.n = r29;
            IInteractivityInjectService r30 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
            if (r30 == null) goto L39;
            ILivePlayerClient r31 = r30.currentClient();
            if (r31 == null) goto L39;
            IRenderView r33 = r31.getRenderView();
            if (r33 == null) goto L39;
            r1.o = r33.getWidth();
            r1.p = r33.getHeight();
        L39:
            StringBuilder r34 = new StringBuilder("updateStreamParams. streamSize=");
            Pair<Integer, Integer> r35 = r1.n;
            if (r35 == null) goto L42;
            Integer r36 = (Integer) r35.getFirst();
        L43:
            r34.append(r36);
            r34.append('*');
            Pair<Integer, Integer> r37 = r1.n;
            if (r37 == null) goto L46;
            r27 = (Integer) r37.getSecond();
        L46:
            r34.append(r27);
            r34.append(" playerSize=");
            r34.append(r1.o);
            r34.append('*');
            r34.append(r1.p);
            r1.yq(r34.toString());
            r1.Bq((BarrageSetting) l42.a.d.getValue());
            int r38 = a1.a;
            if (a1.a.a().d() == true) goto L49;
            r1.wq().setVisibility(0);
        L49:
            BarrageWidgetContext r39 = r1.a;
            if (r39 == null) goto L98;
            n<com.bytedance.android.livesdk.interactivity.api.barrage.data.d> r40 = r39.getChatCarnivalMessage();
            if (r40 == null) goto L98;
            com.bytedance.android.livesdk.interactivity.api.barrage.data.d r41 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.d) r40.getValue();
            if (r41 == null) goto L98;
            BarrageWidgetContext r43 = r1.a;
            if (r43 != null) goto L58;
        L59:
            ALogger.i("CARNIVAL_MESSAGE_LANDSCAPE", "widget notify prepare");
            List<com.bytedance.android.livesdk.interactivity.api.barrage.data.f> r44 = r41.q();
            if (r44 != null) goto L62;
        L89:
            List<com.bytedance.android.livesdk.interactivity.api.barrage.data.i> r45 = r41.r();
            if (r45 != null) goto L92;
        L97:
            CarnivalDanmakuWidget.A = false;
            goto L98
        L92:
            if ((!r45.isEmpty()) != true) goto L97;
            CarnivalDanmakuWidget.A = true;
            com.bytedance.android.livesdk.interactivity.zdanmaku.layout.e r46 = r1.i;
            if (r46 == null) goto L98;
            r46.e = r1.d.a();
            goto L98
        L62:
            if ((!r44.isEmpty()) != true) goto L89;
            com.bytedance.android.livesdk.interactivity.utils.f r47 = r1.d;
            List<com.bytedance.android.livesdk.interactivity.api.barrage.data.f> r48 = r41.q();
            if (r48 != null) goto L66;
            r48 = new ArrayList();
        L66:
            r47.c(CollectionsKt.toList(r48));
            List<Long> r49 = r41.s();
            if (r49 == null) goto L69;
            int r50 = r49.size();
        L70:
            int r51 = 6;
            int r53 = 4;
            if (r50 < 2) goto L82;
            List<Long> r54 = r41.s();
            if (r54 == null) goto L77;
            Long r55 = (Long) ListProtector.get(r54, 0);
            if (r55 == null) goto L77;
            r53 = (int) r55.longValue();
        L77:
            List<Long> r56 = r41.s();
            if (r56 == null) goto L82;
            Long r57 = (Long) ListProtector.get(r56, 1);
            if (r57 == null) goto L82;
            r51 = (int) r57.longValue();
        L82:
            ArrayList r58 = new ArrayList();
            List<com.bytedance.android.livesdk.interactivity.api.barrage.data.i> r59 = r41.r();
            if (r59 == null) goto L88;
            Iterator<T> r60 = r59.iterator();
        L86:
            if (r60.hasNext() == false) goto L88;
            r58.add(Long.valueOf(((com.bytedance.android.livesdk.interactivity.api.barrage.data.i) r60.next()).d()));
        L88:
            r1.d.d(r58, r53, r51);
            goto L89
        L69:
            r50 = 0;
            goto L70
        L58:
            if (r43.hasCleared() != true) goto L59;
        L98:
            VSLandscapeCarnivalDanmakuPresenter r61 = r1.k;
            if (r61 == null) goto L113;
            EpisodeInteractivityTracer.b("register first show listener");
            int r63 = a1.a;
            if (a1.a.a().d() == false) goto L103;
            jc1.h r64 = r61.u;
        L104:
            jc1.b.a(r64);
            if (a1.a.a().d() == false) goto L108;
            r61.r0(com.bytedance.android.livesdk.interactivity.common.utils.f.a(((com.bytedance.android.livesdk.chatroom.presenter.n) r61).c));
            return;
        L108:
            if (com.bytedance.android.livesdk.interactivity.common.utils.f.a(((com.bytedance.android.livesdk.chatroom.presenter.n) r61).c) == true) goto L115;
            r61.r0(false);
            return;
        L115:
            return;
        L103:
            r64 = r61.t;
            goto L104
        L113:
            return;
        L42:
            r36 = null;
        L31:
            r29 = null;
            goto L32
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ VSLandscapeCarnivalDanmakuWidget a;

        public f(VSLandscapeCarnivalDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            if (((Boolean) r3).booleanValue() == false) goto L7;
            VSLandscapeCarnivalDanmakuWidget r4 = this.a;
            int r1 = VSLandscapeCarnivalDanmakuWidget.q;
            r4.getClass();
            ALogger.i("CARNIVAL_MESSAGE_LANDSCAPE", "widget in carnival");
            VSLandscapeCarnivalDanmakuPresenter r5 = r4.k;
            if (r5 == null) goto L21;
            r5.q0();
            return;
        L21:
            return;
        L7:
            VSLandscapeCarnivalDanmakuWidget r6 = this.a;
            int r2 = VSLandscapeCarnivalDanmakuWidget.q;
            r6.getClass();
            ALogger.i("CARNIVAL_MESSAGE_LANDSCAPE", "widget carnival end");
            VSLandscapeCarnivalDanmakuPresenter r0 = r6.k;
            if (r0 == null) goto L14;
            r0.w = false;
            r0.u0(true);
            EpisodeInteractivityTracer.b("unregister first show listener");
            int r7 = a1.a;
            if (a1.a.a().d() == false) goto L12;
            jc1.h r8 = r0.u;
        L13:
            jc1.b.b(r8);
            goto L14
        L12:
            r8 = r0.t;
        L14:
            com.bytedance.android.livesdk.interactivity.zdanmaku.layout.e r9 = r6.i;
            if (r9 == null) goto L17;
            r9.a();
        L17:
            com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r10 = r6.h;
            if (r10 == null) goto L23;
            r10.postRunnable(new com.bytedance.live.zdanmaku.g(r10));
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ VSLandscapeCarnivalDanmakuWidget a;

        public g(VSLandscapeCarnivalDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            VSLandscapeCarnivalDanmakuWidget r0 = this.a;
            boolean r4 = ((Boolean) r3).booleanValue();
            int r1 = VSLandscapeCarnivalDanmakuWidget.q;
            if (r4 == false) goto L5;
            UtilityKotlinExtentionsKt.w(r0.wq());
            r0.yq("carnival view visible");
            return;
        L5:
            UtilityKotlinExtentionsKt.u(r0.wq());
            r0.yq("carnival view invisible");
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ VSLandscapeCarnivalDanmakuWidget a;

        public h(VSLandscapeCarnivalDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Boolean r5 = (Boolean) r4;
            VSLandscapeCarnivalDanmakuPresenter r0 = this.a.k;
            if (r0 == null) goto L10;
            boolean r1 = r5.booleanValue();
            if (r0.x == r1) goto L10;
            r0.x = r1;
            if (r1 == false) goto L10;
            r0.y.clear();
            r0.i0();
        L10:
            VSLandscapeDanmakuCarnivalTrayManager r2 = this.a.f;
            if (r2 == null) goto L16;
            boolean r6 = r5.booleanValue();
            o22.d r3 = r2.a;
            if (r3 == null) goto L17;
            r3.b(r6);
            return;
        L17:
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public i(VSLandscapeCarnivalDanmakuWidget r1) {
        }

        public final void accept(Object r1) {
            ((com.bytedance.android.livesdk.interactivity.api.barrage.data.g) r1).getClass();
        }
    }

    public final class j implements Consumer {
        public final /* synthetic */ Function1 a;

        public j(Function1 r1) {
            this.a = r1;
        }

        public final /* synthetic */ void accept(Object r2) {
            this.a.invoke(r2);
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566681;
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    public final CarnivalRenderEngineView wq() {
        return (CarnivalRenderEngineView) this.g.getValue();
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.CarnivalDanmakuPresenter.IView
    public final void K0() {
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.h;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.CarnivalDanmakuPresenter.IView
    public final void Q7() {
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.h;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.CarnivalDanmakuPresenter.IView
    public final int U() {
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.h;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c();
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.CarnivalDanmakuPresenter.IView
    public final int getFontSize() {
        p r0 = this.m;
        if (r0 == null) goto L7;
        p.a r1 = r0.e;
        if (r1 == null) goto L7;
        return r1.a;
    L7:
        return 0;
    }

    public final void onCreate() {
        yq("widget onCreate");
        super.onCreate();
        DataContext r0 = getRoomContext();
        if (r0 != null) goto L6;
        return;
    L6:
        if (((Widget) this).dataCenter != null) goto L8;
        return;
    L8:
        this.l = ((Boolean) ec2.j.a.getValue()).booleanValue();
        BarrageWidgetContext r1 = com.bytedance.android.livesdk.interactivity.barrage.widget.b.a(r0, ((Widget) this).dataCenter);
        this.a = r1;
        if (r1 != null) goto L11;
        return;
    L11:
        StatusBarUtil.getStatusBarHeight(((Widget) this).context);
        VSLandscapeCarnivalDanmakuPresenter r2 = new VSLandscapeCarnivalDanmakuPresenter(r1);
        this.k = r2;
        r2.h0(this);
        boolean r3 = false;
        wq().setSupportRotate(false);
        CarnivalRenderEngineView r4 = wq();
        int r5 = a1.a;
        r4.setEnableMask(a1.a.a().c());
        wq().setEnableEdgeBlur(a1.a.a().a());
        wq().setCanDrawDanmakuEdge(a1.a.a().b());
        BarrageWidgetContext r6 = this.a;
        if (r6 == null) goto L17;
        m<Boolean> r7 = r6.isLandscapeDanmakuVisible();
        if (r7 == null) goto L17;
        if (((Boolean) r7.getValue()).booleanValue() == true) goto L17;
    L18:
        if (r3 == false) goto L20;
        UtilityKotlinExtentionsKt.w(wq());
        yq("carnival view visible");
    L21:
        r1.getChatCarnivalStylePicker().setValue(this.d);
        BarrageSetting r8 = (BarrageSetting) l42.a.d.getValue();
        this.m = new p(r8.getBarrageArea(), r8.getFontSize(), r8.getAlpha());
        IRoomContextService r9 = getRoomContextService();
        VSPlayerViewControlContext r10 = null;
        if (r9 == null) goto L28;
        o r11 = IRoomContextService.a.a(r9, ((Widget) this).dataCenter, 0, 2);
        if (r11 == null) goto L28;
        m r13 = r11.getRoom();
        if (r13 == null) goto L28;
        IRoom r14 = (IRoom) r13.getValue();
    L29:
        if (r14 == null) goto L34;
        IBaseStreamUrl r15 = r14.getStreamUrl();
        if (r15 == null) goto L34;
        r15.getStreamOrientation();
    L34:
        if (this.l == false) goto L37;
        wq().setBackgroundColor(ColorProtector.parseColor("#34FFD200"));
    L37:
        if (r1.hasCleared() == true) goto L49;
        RxUtilKt.c(r1.isCarnivalStarted().a().startWith(r1.isCarnivalStarted().getValue()).subscribe(new e(this)), this.e);
        if (((Boolean) r1.isInCarnival().getValue()).booleanValue() == false) goto L43;
        ALogger.i("CARNIVAL_MESSAGE_LANDSCAPE", "widget in carnival");
        VSLandscapeCarnivalDanmakuPresenter r16 = this.k;
        if (r16 == null) goto L43;
        r16.q0();
    L43:
        RxUtilKt.c(r1.isInCarnival().a().subscribe(new f(this)), this.e);
        RxUtilKt.c(r1.isLandscapeDanmakuVisible().a().subscribe(new g(this)), this.e);
        if (a1.a.a().d() == false) goto L47;
        RxUtilKt.c(r1.isLandscapeCarnivalDisabled().a().startWith(r1.isLandscapeCarnivalDisabled().getValue()).subscribe(new h(this)), this.e);
    L47:
        if (a1.a.a().c() == false) goto L49;
        RxUtilKt.c(r1.getContour().a().subscribe(new i(this)), this.e);
        Aq(w0.class, new AnonymousClass9(this));
    L49:
        this.f = new VSLandscapeDanmakuCarnivalTrayManager(((Widget) this).dataCenter);
        Aq(q22.b.class, new AnonymousClass10(this));
        if (a1.a.a().d() == false) goto L52;
        zq(((Boolean) l42.a.g.getValue()).booleanValue());
    L52:
        Aq(e3.class, new AnonymousClass11(this));
        com.bytedance.android.livesdk.f.d().a.observe(this, new c(this));
        IVSPlayerService r17 = jc1.k.f(IVSPlayerService.class);
        if (r17 == null) goto L63;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r18 = r17.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r18 == null) goto L57;
        r10 = r18.provideContext();
    L57:
        if (r10 == null) goto L63;
        m r19 = r10.getPlayerViewVisible();
        if (r19 == null) goto L63;
        Disposable r20 = i80.a.a(r19, new AnonymousClass13(this));
        if (r20 == null) goto L63;
        RxUtilKt.c(r20, this.e);
    L63:
        IRoomContextService r21 = getRoomContextService();
        if (r21 == null) goto L75;
        o r23 = IRoomContextService.a.a(r21, ((Widget) this).dataCenter, 0, 2);
        if (r23 == null) goto L76;
        m r24 = r23.z1();
        if (r24 == null) goto L77;
        Observable r25 = r24.a();
        if (r25 == null) goto L78;
        ObservableSubscribeProxy r26 = (ObservableSubscribeProxy) r25.as(autoDispose());
        if (r26 == null) goto L79;
        r26.subscribe(new d(this));
        return;
    L79:
        return;
    L78:
        return;
    L77:
        return;
    L76:
        return;
    L75:
        return;
    L28:
        r14 = null;
        goto L29
    L20:
        UtilityKotlinExtentionsKt.u(wq());
        yq("carnival view invisible");
    L17:
        r3 = true;
        goto L18
    }

    public final void onDestroy() {
        yq("widget onDestroy");
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.h;
        if (r0 == null) goto L5;
        r0.e();
    L5:
        this.e.dispose();
        VSLandscapeCarnivalDanmakuPresenter r1 = this.k;
        if (r1 == null) goto L8;
        r1.detachView();
    L8:
        VSLandscapeDanmakuCarnivalTrayManager r2 = this.f;
        if (r2 == null) goto L20;
        IVSPlayerService r3 = jc1.k.f(IVSPlayerService.class);
        if (r3 == null) goto L15;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.b r4 = r3.provideVSPlayerTipService(r2.c);
        if (r4 == null) goto L15;
        r4.hidePlayerTip("danmaku_carnival");
    L15:
        o22.d r5 = r2.a;
        if (r5 == null) goto L18;
        r5.reset();
        r5.f(null);
        r2.a = null;
        r2.b = null;
    L18:
        VSLandscapeDanmakuCarnivalTrayManager.a("release LandscapeDanmakuCarnivalManager");
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.CarnivalDanmakuPresenter.IView
    public final int wa() {
        p r0 = this.m;
        if (r0 == null) goto L7;
        p.a r1 = r0.e;
        if (r1 == null) goto L7;
        return r1.b;
    L7:
        return 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.CarnivalDanmakuPresenter.IView
    public final void x0() {
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.h;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    public VSLandscapeCarnivalDanmakuWidget() {
        this.b = UtilityKotlinExtentionsKt.i(2);
        this.c = UtilityKotlinExtentionsKt.i(36);
        this.d = new com.bytedance.android.livesdk.interactivity.utils.f();
        this.e = new CompositeDisposable();
        this.g = LazyKt.lazy(new VSLandscapeCarnivalDanmakuWidget$renderEngineView$2(this));
        this.j = new b(this);
        this.o = 1.0f;
        this.p = 1.0f;
    }

    public final void Bq(BarrageSetting r14) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        BarrageWidgetContext r0 = this.a;
        BarrageSettingFont r1 = null;
        if (r0 == null) goto L10;
        n<com.bytedance.android.livesdk.interactivity.api.barrage.data.d> r2 = r0.getChatCarnivalMessage();
        if (r2 == null) goto L10;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.d r3 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.d) r2.getValue();
    L11:
        if (r3 != null) goto L13;
        return;
    L13:
        if (this.i == null) goto L64;
        ViewGroup r4 = ((Widget) this).containerView;
        if (r4 == null) goto L26;
        Integer r5 = Integer.valueOf(r4.getWidth());
        if (r5.intValue() <= 0) goto L20;
        boolean r6 = true;
    L21:
        if (r6 == true) goto L24;
        r5 = null;
    L24:
        if (r5 == null) goto L26;
        int r7 = r5.intValue();
    L27:
        int r8 = r7;
        if (r14 == null) goto L30;
        BarrageSettingArea r9 = r14.getBarrageArea();
    L31:
        int r10 = xq(r9);
        int r11 = (int) ((r8 / ((int) UtilityKotlinExtentionsKt.h(Math.max(r3.t(), 800) / 10.0f))) * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
        int r13 = a1.a;
        if (a1.a.a().d() == false) goto L53;
        if (r14 == null) goto L35;
        r1 = r14.getFontSize();
    L35:
        if (r1 == null) goto L45;
        int r15 = com.bytedance.android.livesdk.interactivity.barrage.widget.f.a[r1.ordinal()];
        if (r15 != 1) goto L40;
        float r16 = 1.2f;
    L47:
        BarrageWidgetContext r17 = this.a;
        if (r17 == null) goto L52;
        m<Float> r18 = r17.getScaleRate();
        if (r18 == null) goto L52;
        r18.setValue(Float.valueOf(r16));
    L52:
        int r19 = (int) (this.c * r16);
    L54:
        int r20 = r19;
        int r21 = this.b;
        if (r3.k() != 1) goto L57;
        boolean r110 = true;
    L58:
        q72.a r111 = new q72.a(r8, r10, r20, r21, r11, r110);
        com.bytedance.android.livesdk.interactivity.zdanmaku.layout.e r23 = this.i;
        if (r23 == null) goto L63;
        r23.d(r111);
        return;
    L63:
        return;
    L57:
        r110 = false;
        goto L58
    L40:
        if (r15 == 2) goto L45;
        if (r15 != 3) goto L45;
        r16 = 0.8f;
    L45:
        r16 = 1.0f;
        goto L47
    L53:
        r19 = this.c;
        goto L54
    L30:
        r9 = null;
        goto L31
    L20:
        r6 = false;
    L26:
        r7 = s1.y();
        goto L27
    L64:
        return;
    L10:
        r3 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.CarnivalDanmakuPresenter.IView
    public final void gd(int r2) {
        if (CarnivalDanmakuWidget.A == false) goto L8;
        com.bytedance.android.livesdk.interactivity.zdanmaku.layout.e r0 = this.i;
        if (r0 == null) goto L9;
        r0.e = r2;
        return;
    L9:
        return;
    }

    public final int xq(BarrageSettingArea r5) {
        ViewGroup r0 = ((Widget) this).containerView;
        if (r0 == null) goto L13;
        Integer r1 = Integer.valueOf(r0.getHeight());
        if (r1.intValue() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L13;
        int r2 = r1.intValue();
    L14:
        if (r5 != null) goto L16;
        return r2;
    L16:
        int r6 = com.bytedance.android.livesdk.interactivity.barrage.widget.f.b[r5.ordinal()];
        if (r6 != 1) goto L19;
        float r7 = r2;
        float r4 = 0.25f;
    L31:
        return (int) (r7 * r4);
    L19:
        if (r6 != 2) goto L21;
        r7 = r2;
        r4 = 0.5f;
        goto L31
    L21:
        if (r6 == 3) goto L32;
        if (r6 != 4) goto L26;
        return 0;
    L26:
        throw new NoWhenBranchMatchedException();
    L32:
        return r2;
    L7:
        r3 = false;
    L13:
        r2 = s1.w();
        goto L14
    }

    public final void yq(String r2) {
        ALogger.i("CARNIVAL_MESSAGE_LANDSCAPE", r2);
    }

    public final void zq(boolean r3) {
        if (r3 == false) goto L6;
        View r4 = ((Widget) this).contentView;
        if (r4 == null) goto L15;
        UtilityKotlinExtentionsKt.u(r4);
        return;
    L15:
        return;
    L6:
        View r5 = ((Widget) this).contentView;
        if (r5 == null) goto L9;
        UtilityKotlinExtentionsKt.w(r5);
    L9:
        BarrageSetting r6 = (BarrageSetting) l42.a.d.getValue();
        if (r6.getBarrageArea() != BarrageSettingArea.CLOSE) goto L12;
        BarrageSettingArea r0 = BarrageSettingArea.HALF;
    L13:
        r6.setBarrageArea(r0);
        Bq(r6);
        return;
    L12:
        r0 = r6.getBarrageArea();
        goto L13
    }

    public final <T> void Aq(Class<T> r2, Function1<? super T, Unit> r3) {
        RxUtilKt.c(xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).subscribe(new j(r3)), this.e);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.CarnivalDanmakuPresenter.IView
    public final void X(Object r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "danmakuData");
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.h;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }
}
