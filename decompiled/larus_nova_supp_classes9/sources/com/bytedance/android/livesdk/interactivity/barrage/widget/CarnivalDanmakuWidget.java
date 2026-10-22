package com.bytedance.android.livesdk.interactivity.barrage.widget;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.StatusBarUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.barrage.data.GeneralCarnivalDataSyncModel;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.b0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.PublicScreenStyleHelper;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.z;
import com.bytedance.android.livesdk.interactivity.api.seek.EpisodeInteractivityTracer;
import com.bytedance.android.livesdk.interactivity.api.settings.config.a1;
import com.bytedance.android.livesdk.interactivity.barrage.view.CarnivalRenderEngineView;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.android.livesdk.interactivity.zdanmaku.widget.CarnivalDanmakuPresenter;
import com.bytedance.android.livesdkapi.depend.model.live.IBaseStreamUrl;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.android.livesdkapi.view.IRenderView;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.artist.render.RenderEntity;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.zdanmaku.DanmakuController;
import com.bytedance.live.zdanmaku.data.Danmaku;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import ec2.k1;
import ec2.z0;
import gd0.v;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import r52.y3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\u00020\u0004:\u0001\u0007B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/barrage/widget/CarnivalDanmakuWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/livesdk/interactivity/zdanmaku/widget/CarnivalDanmakuPresenter$IView;", "<init>", "()V", "b", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CarnivalDanmakuWidget extends MiddlewareRoomWidget implements Observer<KVData>, CarnivalDanmakuPresenter.IView {
    public static boolean A;
    public BarrageWidgetContext a;
    public int b;
    public int c;
    public boolean d;
    public final com.bytedance.android.livesdk.interactivity.utils.f e;
    public final CompositeDisposable f;
    public final Lazy g;
    public com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> h;
    public com.bytedance.android.livesdk.interactivity.zdanmaku.a<com.bytedance.android.livesdk.interactivity.zdanmaku.i> i;
    public final d j;
    public CarnivalDanmakuPresenter k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final int p;
    public final int q;
    public final int r;
    public int s;
    public final boolean t;
    public int u;
    public final a v;
    public p22.p w;
    public o22.d x;
    public float y;
    public float z;

    public static final class a extends cc2.p<cc2.c> {
        public final Set<cc2.c> f;
        public final Set<cc2.c> g;

        @Override // cc2.p
        public final Set<cc2.c> b() {
            return this.f;
        }

        @Override // cc2.p
        public final Set<cc2.c> c() {
            return this.g;
        }

        public a(c r4) {
            super(true, r4);
            this.f = SetsKt.setOf(new cc2.c[]{cc2.c.b.c, cc2.c.C0011c.c, cc2.c.d.c, cc2.c.a.c});
            this.g = SetsKt.emptySet();
        }
    }

    public static final class b {
    }

    public static final class c implements cc2.n<cc2.c> {
        public final /* synthetic */ CarnivalDanmakuWidget a;

        public c(CarnivalDanmakuWidget r1) {
            this.a = r1;
        }

        @Override // cc2.n
        public final void a(cc2.c r1, Boolean r2) {
            ViewGroup r3 = ((Widget) this.a).containerView;
            if (r3 == null) goto L5;
            r3.setAlpha(1.0f);
        L5:
            CarnivalDanmakuWidget r4 = this.a;
            boolean r5 = CarnivalDanmakuWidget.A;
            r4.yq("carnival danmaku show");
        }

        @Override // cc2.n
        public final void b(cc2.c r1, Boolean r2) {
            ViewGroup r3 = ((Widget) this.a).containerView;
            if (r3 == null) goto L5;
            r3.setAlpha(0.0f);
        L5:
            CarnivalDanmakuWidget r4 = this.a;
            boolean r5 = CarnivalDanmakuWidget.A;
            r4.yq("carnival danmaku hide");
        }
    }

    public static final class d implements DanmakuController.b<com.bytedance.android.livesdk.interactivity.zdanmaku.i> {
        public final /* synthetic */ CarnivalDanmakuWidget a;

        public d(CarnivalDanmakuWidget r1) {
            this.a = r1;
        }

        public final void a(Danmaku r2) {
            com.bytedance.android.livesdk.interactivity.zdanmaku.i r3 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r2;
            Intrinsics.checkNotNullParameter(r3, "danmaku");
            CarnivalDanmakuPresenter r0 = this.a.k;
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
            tc2.k r0 = (tc2.k) r5.e(tc2.k.class);
            if (r0 == null) goto L9;
            r0.a(r5);
            return;
        L9:
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ CarnivalDanmakuWidget a;

        public e(CarnivalDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ok1.a r4 = (ok1.a) r3;
            if (r4 == null) goto L8;
            int r5 = r4.a;
            if (r5 == (-10086)) goto L9;
            CarnivalDanmakuWidget r0 = this.a;
            boolean r1 = CarnivalDanmakuWidget.A;
            r0.Aq(r5);
            return;
        L9:
            return;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ CarnivalDanmakuWidget a;

        public f(CarnivalDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ok1.a r4 = (ok1.a) r3;
            if (r4 != null) goto L5;
            return;
        L5:
            if (((Boolean) y3.a.getValue()).booleanValue() == false) goto L11;
            int r5 = r4.a;
            if (r5 == (-10086)) goto L12;
            CarnivalDanmakuWidget r0 = this.a;
            boolean r1 = CarnivalDanmakuWidget.A;
            r0.Aq(r5);
            return;
        L12:
            return;
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ CarnivalDanmakuWidget a;

        public g(CarnivalDanmakuWidget r1) {
            this.a = r1;
        }

        public final void a() {
            CarnivalDanmakuWidget r0 = this.a;
            boolean r1 = CarnivalDanmakuWidget.A;
            r0.b = r0.wq().getHeight();
            int r2 = (o22.a.b + o22.a.c) * 3;
            CarnivalDanmakuWidget r3 = this.a;
            int r4 = r2 + (-r3.b);
            if (r4 <= 0) goto L9;
            ViewGroup.LayoutParams r5 = r3.wq().getLayoutParams();
            if (r5 == null) goto L8;
            FrameLayout.LayoutParams r6 = (FrameLayout.LayoutParams) r5;
            r6.bottomMargin -= r4;
            this.a.wq().setLayoutParams(r6);
            this.a.b += r4;
            return;
        L8:
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
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

    public static final class h<T> implements Consumer {
        public final /* synthetic */ CarnivalDanmakuWidget a;

        public h(CarnivalDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ok1.a r4 = (ok1.a) r3;
            if (r4 == null) goto L6;
            CarnivalDanmakuWidget r0 = this.a;
            int r5 = r4.a;
            boolean r1 = CarnivalDanmakuWidget.A;
            r0.Aq(r5);
            return;
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ CarnivalDanmakuWidget a;

        public i(CarnivalDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ok1.a r4 = (ok1.a) r3;
            if (r4 != null) goto L5;
            return;
        L5:
            if (ok1.d.a() == false) goto L11;
            int r5 = r4.a;
            if (r5 == (-10086)) goto L12;
            CarnivalDanmakuWidget r0 = this.a;
            boolean r1 = CarnivalDanmakuWidget.A;
            r0.Aq(r5);
            return;
        L12:
            return;
        }
    }

    public static final class j<T> implements Consumer {
        public final /* synthetic */ CarnivalDanmakuWidget a;

        public j(CarnivalDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            ok1.a r4 = (ok1.a) r3;
            if (r4 != null) goto L5;
            return;
        L5:
            if (ok1.d.a() == false) goto L11;
            int r5 = r4.a;
            if (r5 == (-10086)) goto L12;
            CarnivalDanmakuWidget r0 = this.a;
            boolean r1 = CarnivalDanmakuWidget.A;
            r0.Aq(r5);
            return;
        L12:
            return;
        }
    }

    public static final class k<T, R> implements Function {
        public final /* synthetic */ BarrageWidgetContext a;

        public k(BarrageWidgetContext r1) {
            this.a = r1;
        }

        public final Object apply(Object r7) {
            sh6.b r8 = (sh6.b) r7;
            Intrinsics.checkNotNullParameter(r8, "it");
        L22:
            e = move-exception;
            ALogger.e("CARNIVAL_MESSAGE", "parse app data error " + e.getMessage());
            return -1;
        L4:
            if (((Boolean) this.a.isInCarnival().getValue()).booleanValue() == false) goto L20;
            String r9 = (String) sh6.c.b(r8);     // Catch: Exception -> L22
            if (r9 != null) goto L9;
            int r10 = -1;     // Catch: Exception -> L22
        L25:
            return r10;
        L9:
            if (StringsKt.startsWith$default(r9, "{", false, 2, null) == true) goto L11;
        L19:
            r10 = -1;     // Catch: Exception -> L22
            goto L25
        L11:
            if (StringsKt.endsWith$default(r9, "}", false, 2, null) == false) goto L19;
            if (StringsKt.contains$default(r9, "app_data", false, 2, null) == false) goto L19;
            LiveSeiUtil.i.getClass();     // Catch: Exception -> L22
            JSONObject r11 = LiveSeiUtil.c(r9);     // Catch: Exception -> L22
            if (r11.has("app_data") == false) goto L18;
            r10 = Integer.valueOf(new JSONArray(new JSONObject(new Regex("\\\\").replace(JSONObjectProtectorUtils.getString(r11, "app_data"), BuildConfig.FLAVOR)).optString("grids")).length());     // Catch: Exception -> L22
            goto L25
        L18:
            r10 = -1;     // Catch: Exception -> L22
            goto L25
        L20:
            r10 = -1;     // Catch: Exception -> L22
            goto L25
        }
    }

    public static final class l<T> implements Consumer {
        public final /* synthetic */ CarnivalDanmakuWidget a;

        public l(CarnivalDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Integer r5 = (Integer) r4;
            if (r5.intValue() < 0) goto L6;
            ALogger.i("CARNIVAL_MESSAGE", "carnival start, audience count is " + r5);
            this.a.u = r5.intValue();
            CarnivalDanmakuWidget r6 = this.a;
            r6.zq(((Number) ((Widget) r6).dataCenter.get("data_link_state", 0)).intValue());
            return;
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ CarnivalDanmakuWidget a;

        public m(CarnivalDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r6) {
            if (((Boolean) r6).booleanValue() == false) goto L5;
            this.a.xq();
            return;
        L5:
            CarnivalDanmakuWidget r7 = this.a;
            r7.yq("carnival end");
            ALogger.i("CARNIVAL_MESSAGE", "widget notify end");
            CarnivalDanmakuPresenter r0 = r7.k;
            if (r0 == null) goto L24;
            com.bytedance.android.livesdk.chatroom.o r2 = r0.m0();
            if (r2 == null) goto L10;
            Boolean r3 = r2.isVSRoom();
        L12:
            if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L20;
            int r4 = a1.a;
            if (a1.a.a().d() == false) goto L20;
            EpisodeInteractivityTracer.b("unregister first show listener");
            if (a1.a.a().d() == false) goto L18;
            jc1.h r5 = r0.u;
        L19:
            jc1.b.b(r5);
            goto L20
        L18:
            r5 = r0.t;
        L20:
            r0.u0(true);
            r0.h = 0;
            r0.l = null;
            com.bytedance.android.livesdk.interactivity.utils.e.f.getClass();
            Disposable r1 = com.bytedance.android.livesdk.interactivity.utils.e.c;
            if (r1 == null) goto L23;
            r1.dispose();
        L23:
            com.bytedance.android.livesdk.interactivity.utils.e.c = null;
            com.bytedance.android.livesdk.interactivity.utils.e.a = 0;
            com.bytedance.android.livesdk.interactivity.utils.e.b = 0;
            com.bytedance.android.livesdk.interactivity.utils.e.d = null;
            com.bytedance.android.livesdk.interactivity.utils.e.e = null;
            goto L24
        L10:
            r3 = null;
        L24:
            com.bytedance.android.livesdk.interactivity.zdanmaku.a<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r8 = r7.i;
            if (r8 == null) goto L27;
            r8.a();
        L27:
            com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r9 = r7.h;
            if (r9 == null) goto L30;
            r9.postRunnable(new com.bytedance.live.zdanmaku.g(r9));
        L30:
            CarnivalDanmakuWidget.A = false;
        }
    }

    public static final class n<T> implements Consumer {
        public n(CarnivalDanmakuWidget r1) {
        }

        public final /* bridge */ /* synthetic */ void accept(Object r1) {
            com.bytedance.android.livesdk.interactivity.api.barrage.data.g r2 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.g) r1;
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ CarnivalDanmakuWidget a;

        public o(CarnivalDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            this.a.v.e(cc2.c.a.c, !((Boolean) r3).booleanValue());
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ CarnivalDanmakuWidget a;

        public p(CarnivalDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r21) {
            if (((Boolean) r21).booleanValue() == false) goto L119;
            CarnivalDanmakuWidget r1 = this.a;
            BarrageWidgetContext r2 = r1.a;
            if (r2 != null) goto L7;
        L9:
            r1.Cq();
            o22.d r3 = r1.x;
            int r4 = 6;
            int r5 = 4;
            if (r3 != null) goto L12;
        L60:
            BarrageWidgetContext r6 = r1.a;
            if (r6 == null) goto L117;
            com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.api.barrage.data.d> r7 = r6.getChatCarnivalMessage();
            if (r7 == null) goto L117;
            com.bytedance.android.livesdk.interactivity.api.barrage.data.d r8 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.d) r7.getValue();
            if (r8 == null) goto L117;
            if (((Widget) r1).containerView.getWidth() <= 0) goto L69;
            int r13 = ((Widget) r1).containerView.getWidth();
        L70:
            int r14 = r13;
            int r15 = r1.b;
            int r9 = (int) ((r14 / ((int) UtilityKotlinExtentionsKt.h(Math.max(r8.t(), 800) / 10.0f))) * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
            int r16 = o22.a.c;
            int r17 = UtilityKotlinExtentionsKt.i(2);
            if (r8.k() != 1) goto L73;
            boolean r19 = true;
        L74:
            q72.a r10 = new q72.a(r14, r15, r16, r17, r9, r19);
            com.bytedance.android.livesdk.interactivity.barrage.widget.c r11 = new com.bytedance.android.livesdk.interactivity.barrage.widget.c();
            com.bytedance.live.zdanmaku.data.d r18 = new com.bytedance.live.zdanmaku.data.d();
            r18.a(z.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
            r18.a(b0.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
            if (r8.u() != 0) goto L77;
            com.bytedance.android.livesdk.interactivity.zdanmaku.a<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r110 = new com.bytedance.android.livesdk.interactivity.zdanmaku.layout.j(r10);
        L78:
            int r20 = com.bytedance.live.zdanmaku.e.i;
            com.bytedance.live.zdanmaku.e.a r23 = new com.bytedance.live.zdanmaku.e.a();
            r23.b(q72.b.class, new com.bytedance.android.livesdk.interactivity.zdanmaku.binder.g((View) DanmakuCacheProviders.j.getValue(), r1.a));
            r23.b(q72.c.class, new com.bytedance.android.livesdk.interactivity.zdanmaku.binder.h((View) DanmakuCacheProviders.l.getValue(), r1.a));
            r23.b = r18;
            r23.d = AsyncTask.THREAD_POOL_EXECUTOR;
            r23.a = new vc2.a("Carnival");
            com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r24 = r23.a(r1.wq(), r11, r110);
            r1.h = r24;
            r24.g.h = r1.j;
            r24.b();
            Unit r25 = Unit.INSTANCE;
            r1.i = r110;
            List<com.bytedance.android.livesdk.interactivity.api.barrage.data.f> r26 = r8.q();
            if (r26 != null) goto L81;
        L107:
            List<com.bytedance.android.livesdk.interactivity.api.barrage.data.i> r27 = r8.r();
            if (r27 != null) goto L110;
        L115:
            CarnivalDanmakuWidget.A = false;
        L116:
            r1.Bq(r8);
            goto L117
        L110:
            if ((!r27.isEmpty()) != true) goto L115;
            CarnivalDanmakuWidget.A = true;
            com.bytedance.android.livesdk.interactivity.zdanmaku.a<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r28 = r1.i;
            if (r28 == null) goto L116;
            r28.e(r1.e.a());
            goto L116
        L81:
            if ((!r26.isEmpty()) != true) goto L107;
            com.bytedance.android.livesdk.interactivity.utils.f r29 = r1.e;
            List<com.bytedance.android.livesdk.interactivity.api.barrage.data.f> r30 = r8.q();
            if (r30 != null) goto L85;
            r30 = new ArrayList();
        L85:
            r29.c(CollectionsKt.toList(r30));
            List<Long> r31 = r8.s();
            if (r31 == null) goto L88;
            int r33 = r31.size();
        L89:
            if (r33 < 2) goto L100;
            List<Long> r34 = r8.s();
            if (r34 == null) goto L95;
            Long r35 = (Long) ListProtector.get(r34, 0);
            if (r35 == null) goto L95;
            r5 = (int) r35.longValue();
        L95:
            List<Long> r36 = r8.s();
            if (r36 == null) goto L100;
            Long r37 = (Long) ListProtector.get(r36, 1);
            if (r37 == null) goto L100;
            r4 = (int) r37.longValue();
        L100:
            ArrayList r38 = new ArrayList();
            List<com.bytedance.android.livesdk.interactivity.api.barrage.data.i> r39 = r8.r();
            if (r39 == null) goto L106;
            Iterator<T> r40 = r39.iterator();
        L104:
            if (r40.hasNext() == false) goto L106;
            r38.add(Long.valueOf(((com.bytedance.android.livesdk.interactivity.api.barrage.data.i) r40.next()).d()));
        L106:
            r1.e.d(r38, r5, r4);
            goto L107
        L88:
            r33 = 0;
            goto L89
        L77:
            r110 = new com.bytedance.android.livesdk.interactivity.zdanmaku.layout.n(r10);
            goto L78
        L73:
            r19 = false;
            goto L74
        L69:
            r13 = s1.y();
        L117:
            r1.yq("carnival start");
            return;
        L12:
            if (r3.a() != true) goto L60;
            BarrageWidgetContext r41 = r1.a;
            if (r41 == null) goto L117;
            com.bytedance.live.datacontext.j<GeneralCarnivalDataSyncModel> r43 = r41.getGeneralCarnivalSyncModel();
            if (r43 == null) goto L117;
            GeneralCarnivalDataSyncModel r44 = (GeneralCarnivalDataSyncModel) r43.getValue();
            if (r44 == null) goto L117;
            dc2.c<com.bytedance.android.livesdk.interactivity.api.barrage.data.k> r45 = r44.getCarnivalMessage();
            if (r45 == null) goto L117;
            com.bytedance.android.livesdk.interactivity.api.barrage.data.k r46 = r45.c();
            if (r46 == null) goto L117;
            com.bytedance.android.livesdk.interactivity.api.barrage.data.j r47 = r46.a();
            if (r47 == null) goto L117;
            if (((Widget) r1).containerView.getWidth() <= 0) goto L29;
            int r111 = ((Widget) r1).containerView.getWidth();
        L30:
            int r112 = r111;
            q72.a r48 = new q72.a(r112, r1.b, o22.a.c, UtilityKotlinExtentionsKt.i(2), (int) ((r112 / ((int) UtilityKotlinExtentionsKt.h(Math.max(r47.x(), 800) / 10.0f))) * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW), false);
            com.bytedance.android.livesdk.interactivity.barrage.widget.d r49 = new com.bytedance.android.livesdk.interactivity.barrage.widget.d();
            com.bytedance.android.livesdk.interactivity.zdanmaku.layout.j r113 = new com.bytedance.android.livesdk.interactivity.zdanmaku.layout.j(r48);
            int r50 = com.bytedance.live.zdanmaku.e.i;
            com.bytedance.live.zdanmaku.e.a r51 = new com.bytedance.live.zdanmaku.e.a();
            r51.b(q72.d.class, new com.bytedance.android.livesdk.interactivity.zdanmaku.binder.p((View) DanmakuCacheProviders.k.getValue(), r1.a));
            r51.b(q72.c.class, new com.bytedance.android.livesdk.interactivity.zdanmaku.binder.n((View) DanmakuCacheProviders.l.getValue(), r1.a));
            r51.d = AsyncTask.THREAD_POOL_EXECUTOR;
            r51.a = new vc2.a("Carnival General");
            com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r53 = r51.a(r1.wq(), r49, r113);
            r1.h = r53;
            r53.g.h = r1.j;
            r53.b();
            Unit r54 = Unit.INSTANCE;
            r1.i = r113;
            List<Long> r55 = r47.v();
            if (r55 == null) goto L33;
            int r56 = r55.size();
        L34:
            if (r56 < 2) goto L45;
            List<Long> r57 = r47.v();
            if (r57 == null) goto L40;
            Long r58 = (Long) ListProtector.get(r57, 0);
            if (r58 == null) goto L40;
            r5 = (int) r58.longValue();
        L40:
            List<Long> r59 = r47.v();
            if (r59 == null) goto L45;
            Long r60 = (Long) ListProtector.get(r59, 1);
            if (r60 == null) goto L45;
            r4 = (int) r60.longValue();
        L45:
            ArrayList r61 = new ArrayList();
            List<com.bytedance.android.livesdk.interactivity.api.barrage.data.c> r63 = r47.u();
            if (r63 == null) goto L51;
            Iterator<T> r64 = r63.iterator();
        L49:
            if (r64.hasNext() == false) goto L51;
            r61.add(Long.valueOf(((com.bytedance.android.livesdk.interactivity.api.barrage.data.c) r64.next()).e()));
        L51:
            r1.e.d(r61, r5, r4);
            List<com.bytedance.android.livesdk.interactivity.api.barrage.data.c> r65 = r47.u();
            if (r65 != null) goto L54;
        L56:
            CarnivalDanmakuWidget.A = true;
            com.bytedance.android.livesdk.interactivity.zdanmaku.a<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r66 = r1.i;
            if (r66 == null) goto L59;
            r66.e(r1.e.a());
        L59:
            r1.Bq(r47);
            goto L117
        L54:
            if (r65.isEmpty() != true) goto L56;
            CarnivalDanmakuWidget.A = false;
            goto L59
        L33:
            r56 = 0;
            goto L34
        L29:
            r111 = s1.y();
            goto L30
        L7:
            if (r2.hasCleared() != true) goto L9;
            return;
        }
    }

    public static final class q implements Runnable {
        public final /* synthetic */ CarnivalDanmakuWidget a;
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.api.barrage.model.a b;

        public q(CarnivalDanmakuWidget r1, com.bytedance.android.livesdk.interactivity.api.barrage.model.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            CarnivalDanmakuWidget r1 = this.a;
            boolean r2 = CarnivalDanmakuWidget.A;
            RectF r0 = new RectF(0.0f, 0.0f, r1.wq().getWidth(), this.a.wq().getHeight());
            float r3 = this.b.j();
            Matrix r4 = com.ss.ugc.live.barrage.util.b.a;
            if (r3 != 0.0f) goto L5;
        L27:
            float[] r5 = {1.0f, 1.0f};
        L28:
            this.a.z = Math.max(1.0f, r5[0]);
            this.a.y = Math.max(1.0f, r5[1]);
            int r13 = (int) ((this.a.wq().getWidth() / ((int) UtilityKotlinExtentionsKt.h(Math.max(this.b.g(), 800) / 10.0f))) * IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW);
            float r6 = this.a.wq().getWidth();
            CarnivalDanmakuWidget r7 = this.a;
            int r8 = (int) (r6 * r7.z);
            float r9 = r7.wq().getHeight();
            CarnivalDanmakuWidget r10 = this.a;
            int r11 = (int) (r9 * r10.y);
            int r14 = r10.c;
            int r15 = o22.a.b;
            if (this.b.k() != 1) goto L31;
            boolean r16 = true;
        L32:
            q72.a r17 = new q72.a(r8, r11, r14, r15, r13, r16);
            com.bytedance.android.livesdk.interactivity.zdanmaku.a<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r18 = this.a.i;
            if (r18 == null) goto L35;
            r18.d(r17);
        L35:
            this.a.wq().setAngle(this.b.j());
            this.a.wq().setRealWidth((int) (this.a.wq().getWidth() * this.a.z));
            this.a.wq().setRealHeight((int) (this.a.wq().getHeight() * this.a.y));
            return;
        L31:
            r16 = false;
            goto L32
        L5:
            if (r0.width() == 0.0f) goto L27;
            if (r0.height() == 0.0f) goto L27;
            Matrix r19 = com.ss.ugc.live.barrage.util.b.a;
            r19.reset();
            r19.setRotate(r3);
            float r20 = r0.left;
            float r21 = r0.top;
            float r110 = r0.right;
            float r23 = r0.bottom;
            float[] r24 = {r20, r21, r110, r21, r110, r23, r20, r23};
            r19.mapPoints(r24);
            RectF r25 = new RectF(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
            int r26 = 1;
        L10:
            if (r26 >= 8) goto L26;
            float r27 = Math.round(r24[r26 - 1] * 10.0f) / 10.0f;
            float r111 = Math.round(r24[r26] * 10.0f) / 10.0f;
            float r112 = r25.left;
            if (r27 >= r112) goto L14;
            r112 = r27;
        L14:
            r25.left = r112;
            float r113 = r25.top;
            if (r111 >= r113) goto L17;
            r113 = r111;
        L17:
            r25.top = r113;
            float r114 = r25.right;
            if (r27 > r114) goto L21;
            r27 = r114;
        L21:
            r25.right = r27;
            float r28 = r25.bottom;
            if (r111 > r28) goto L25;
            r111 = r28;
        L25:
            r25.bottom = r111;
            r26 = r26 + 2;
            goto L10
        L26:
            r25.sort();
            r5 = new float[]{r25.width() / (r0.right - r0.left), r25.height() / (r0.bottom - r0.top)};
            goto L28
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

    static {
    }

    public final int getLayoutId() {
        return 2131566628;
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    public final CarnivalRenderEngineView wq() {
        return (CarnivalRenderEngineView) this.g.getValue();
    }

    public final void Cq() {
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 != null) goto L5;
        return;
    L5:
        boolean r2 = false;
        Integer r1 = (Integer) r0.get("data_link_state", 0);
        boolean r3 = v.a(r1.intValue(), 4);
        boolean r4 = v.a(r1.intValue(), 64);
        if (r3 == true) goto L10;
        if (r4 == true) goto L10;
        if (this.o == true) goto L10;
    L11:
        if (r2 == false) goto L13;
        int r5 = o22.a.d;
    L14:
        this.c = r5;
        BarrageWidgetContext r6 = this.a;
        if (r6 == null) goto L23;
        com.bytedance.live.datacontext.m<Float> r7 = r6.getScaleRate();
        if (r7 == null) goto L24;
        if (r2 == false) goto L20;
        float r8 = 0.85f;
    L21:
        r7.setValue(Float.valueOf(r8));
        return;
    L20:
        r8 = 1.0f;
        goto L21
    L24:
        return;
    L23:
        return;
    L13:
        r5 = o22.a.c;
    L10:
        r2 = true;
        goto L11
    }

    public final void Eq() {
        IInteractivityInjectService r0 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        IRenderView r1 = null;
        if (r0 == null) goto L5;
        ILivePlayerClient r2 = r0.currentClient();
    L6:
        if (r2 == null) goto L8;
        r2.getVideoSize();
    L8:
        boolean r3 = ((Boolean) ((Widget) this).dataCenter.get("data_is_anchor", Boolean.FALSE)).booleanValue();
        this.d = r3;
        if (r3 == true) goto L19;
        if (r2 == null) goto L12;
        r1 = r2.getRenderView();
    L12:
        if (r1 == null) goto L49;
        IRenderView r4 = r2.getRenderView();
        if (r4 == null) goto L16;
        r4.getWidth();
    L16:
        IRenderView r5 = r2.getRenderView();
        if (r5 == null) goto L50;
        r5.getHeight();
        return;
    L50:
        return;
    L49:
        return;
    L19:
        BarrageWidgetContext r6 = this.a;
        if (r6 == null) goto L25;
        if (r6.hasCleared() != true) goto L25;
        return;
    L25:
        if (this.a == null) goto L52;
        IRoomContextService r7 = jc1.k.f(IRoomContextService.class);
        if (r7 == null) goto L37;
        com.bytedance.android.livesdk.chatroom.o r8 = IRoomContextService.a.a(r7, ((Widget) this).dataCenter, 0, 2);
        if (r8 == null) goto L37;
        com.bytedance.live.datacontext.n r9 = r8.Q1();
        if (r9 == null) goto L37;
        WeakReference r10 = (WeakReference) r9.getValue();
        if (r10 == null) goto L37;
        ViewGroup r11 = (ViewGroup) r10.get();
        if (r11 == null) goto L37;
        r11.getWidth();
    L37:
        IRoomContextService r13 = jc1.k.f(IRoomContextService.class);
        if (r13 == null) goto L53;
        com.bytedance.android.livesdk.chatroom.o r14 = IRoomContextService.a.a(r13, ((Widget) this).dataCenter, 0, 2);
        if (r14 == null) goto L54;
        com.bytedance.live.datacontext.n r15 = r14.Q1();
        if (r15 == null) goto L55;
        WeakReference r16 = (WeakReference) r15.getValue();
        if (r16 == null) goto L56;
        ViewGroup r17 = (ViewGroup) r16.get();
        if (r17 == null) goto L57;
        r17.getHeight();
        return;
    L57:
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L5:
        r2 = null;
        goto L6
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
        p22.p r0 = this.w;
        if (r0 == null) goto L7;
        p22.p.a r1 = r0.e;
        if (r1 == null) goto L7;
        return r1.a;
    L7:
        return 0;
    }

    public final int supportClearScene() {
        if (((Boolean) k1.a.getValue()).booleanValue() == false) goto L6;
        return 1;
    L6:
        return super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.supportClearScene();
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.CarnivalDanmakuPresenter.IView
    public final int wa() {
        p22.p r0 = this.w;
        if (r0 == null) goto L7;
        p22.p.a r1 = r0.e;
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

    public CarnivalDanmakuWidget() {
        this.b = UtilityKotlinExtentionsKt.i(160);
        UtilityKotlinExtentionsKt.i(30);
        int r0 = o22.a.a;
        this.c = o22.a.c;
        this.e = new com.bytedance.android.livesdk.interactivity.utils.f();
        this.f = new CompositeDisposable();
        this.g = LazyKt.lazy(new CarnivalDanmakuWidget$renderEngineView$2(this));
        this.j = new d(this);
        this.l = true;
        this.m = true;
        this.p = UtilityKotlinExtentionsKt.i(61);
        this.q = UtilityKotlinExtentionsKt.i(55);
        this.r = UtilityKotlinExtentionsKt.i(6);
        UtilityKotlinExtentionsKt.i(45);
        this.t = true;
        this.v = new a(new c(this));
        this.y = 1.0f;
        this.z = 1.0f;
        s1.y();
        s1.w();
    }

    public final IRoom getRoom() {
        IRoomContextService r0 = getRoomContextService();
        if (r0 == null) goto L9;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, ((Widget) this).dataCenter, 0, 2);
        if (r1 == null) goto L9;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L9;
        return (IRoom) r2.getValue();
    L9:
        return null;
    }

    public final void onCreate() {
        super.onCreate();
        DataContext r0 = getRoomContext();
        if (r0 != null) goto L6;
        return;
    L6:
        if (((Widget) this).dataCenter != null) goto L8;
        return;
    L8:
        this.n = ((Boolean) ec2.j.a.getValue()).booleanValue();
        BarrageWidgetContext r1 = com.bytedance.android.livesdk.interactivity.barrage.widget.b.a(r0, ((Widget) this).dataCenter);
        this.a = r1;
        if (r1 != null) goto L11;
        return;
    L11:
        StatusBarUtil.getStatusBarHeight(((Widget) this).context);
        if (StatusBarUtil.isStatusBarTransparent() == false) goto L14;
        StatusBarUtil.getStatusBarHeight(((Widget) this).context);
    L14:
        CarnivalDanmakuPresenter r2 = new CarnivalDanmakuPresenter(r1);
        this.k = r2;
        r2.h0(this);
        r1.getChatCarnivalStylePicker().setValue(this.e);
        BarrageSetting r3 = (BarrageSetting) l42.a.d.getValue();
        this.w = new p22.p(r3.getBarrageArea(), r3.getFontSize(), r3.getAlpha());
        IRoom r4 = getRoom();
        if (r4 == null) goto L23;
        IBaseStreamUrl r5 = r4.getStreamUrl();
        if (r5 == null) goto L19;
        int r6 = r5.getStreamOrientation();
    L20:
        if (r6 != 2) goto L23;
        this.o = true;
        goto L23
    L19:
        r6 = 2;
    L23:
        if (this.n == false) goto L25;
        wq().setBackgroundColor(ColorProtector.parseColor("#34FFD200"));
        wq().setDebug(Boolean.valueOf(this.n));
    L25:
        CarnivalRenderEngineView r7 = wq();
        boolean r8 = n22.a.a;
        r7.setEnableEdgeBlur(((Boolean) r52.z.a.getValue()).booleanValue());
        wq().setClickable(false);
        ((Widget) this).dataCenter.observe("data_keyboard_status_douyin", this);
        ((Widget) this).dataCenter.observe("cmd_pk_state_change", this);
        ((Widget) this).dataCenter.observe("data_link_state", this);
        ((Widget) this).dataCenter.observe("cmd_normal_gift_layout_after_adjust_pos", this).observe("cmd_change_interactivity_component_visibility", this);
        ((Widget) this).containerView.post(new g(this));
        Eq();
        if (r1.hasCleared() == true) goto L37;
        Disposable r9 = r1.isCarnivalStarted().a().startWith(r1.isCarnivalStarted().getValue()).subscribe(new p(this));
        if (((Boolean) r1.isInCarnival().getValue()).booleanValue() == false) goto L30;
        xq();
    L30:
        Disposable r10 = r1.isInCarnival().a().subscribe(new m(this));
        this.v.e(cc2.c.a.c, true ^ ((Boolean) r1.isDanmakuVisible().getValue()).booleanValue());
        Disposable r11 = r1.isDanmakuVisible().a().subscribe(new o(this));
        Disposable r13 = r1.getContour().a().subscribe(new n(this));
        if (this.t == false) goto L33;
        Disposable r14 = r1.getAppData().a().map(new k(r1)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new l(this));
    L34:
        if (r14 == null) goto L36;
        this.f.add(r14);
    L36:
        this.f.add(r9);
        this.f.add(r10);
        this.f.add(r11);
        this.f.add(r13);
        r1.getDanmakuCarnivalManager().c(new AnonymousClass4(this));
        goto L37
    L33:
        r14 = null;
    L37:
        this.m = ((Boolean) z0.a.getValue()).booleanValue();
        InteractionWidgetsPosContext r15 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r15 == null) goto L40;
        this.f.add(r15.getAudioGiftTrayPos().a().startWith(r15.getAudioGiftTrayPos().getValue()).subscribe(new h(this)));
        this.f.add(r15.getMultiPkGiftTrayPos().a().startWith(r15.getMultiPkGiftTrayPos().getValue()).subscribe(new i(this)));
        this.f.add(r15.getRevenuePkGiftTrayPos().a().subscribe(new j(this)));
        this.f.add(r15.getEqualVideoTalkGiftTrayPos().a().startWith(r15.getEqualVideoTalkGiftTrayPos().getValue()).subscribe(new e(this)));
        this.f.add(r15.getVideoChorusGiftTrayPos().a().startWith(r15.getVideoChorusGiftTrayPos().getValue()).subscribe(new f(this)));
    L40:
        zq(((Number) ((Widget) this).dataCenter.get("data_link_state", 0)).intValue());
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        this.x = null;
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r1 = this.h;
        if (r1 == null) goto L8;
        r1.e();
    L8:
        this.f.dispose();
        CarnivalDanmakuPresenter r2 = this.k;
        if (r2 == null) goto L12;
        r2.detachView();
        return;
    }

    public final void xq() {
        Eq();
        Aq(this.s);
        zq(((Number) ((Widget) this).dataCenter.get("data_link_state", 0)).intValue());
        ALogger.i("CARNIVAL_MESSAGE", "widget notify start");
        CarnivalDanmakuPresenter r0 = this.k;
        if (r0 == null) goto L6;
        r0.q0();
        return;
    }

    public final void Aq(int r10) {
        if (isViewValid() == true) goto L5;
        return;
    L5:
        BarrageWidgetContext r0 = this.a;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.j r1 = null;
        if (r0 == null) goto L10;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.api.barrage.data.d> r2 = r0.getChatCarnivalMessage();
        if (r2 == null) goto L10;
        com.bytedance.android.livesdk.interactivity.api.barrage.model.a r3 = (com.bytedance.android.livesdk.interactivity.api.barrage.data.d) r2.getValue();
    L11:
        o22.d r4 = this.x;
        boolean r5 = true;
        if (r4 != null) goto L14;
    L27:
        if (r3 != null) goto L29;
    L31:
        r5 = false;
    L32:
        this.s = r10;
        ViewGroup.LayoutParams r6 = wq().getLayoutParams();
        if (r6 == null) goto L42;
        FrameLayout.LayoutParams r7 = (FrameLayout.LayoutParams) r6;
        int r8 = (this.c + o22.a.b) * 3;
        InteractionWidgetsPosContext r9 = InteractionWidgetsPosContext.a.c(InteractionWidgetsPosContext.Companion, ((Widget) this).dataCenter, 0, 2);
        if (r9 == null) goto L37;
        r10 = Math.max(r10, ((Number) r9.getPublicScreenHeight().getValue()).intValue() + ((Number) r9.getPublicScreenBottomMargin().getValue()).intValue());
    L37:
        if (r5 == true) goto L39;
        r10 = r10 + this.p;
    L39:
        r7.topMargin = o22.a.a;
        r7.bottomMargin = Math.min(((Widget) this).containerView.getHeight() - (r7.topMargin + r8), r10 + ((this.q * 2) + this.r));
        wq().setLayoutParams(r7);
        wq().invalidate();
        Bq(r3);
        return;
    L42:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    L29:
        if (r3.d() != 1) goto L31;
    L14:
        if (r4.a() != true) goto L27;
        BarrageWidgetContext r11 = this.a;
        if (r11 == null) goto L26;
        com.bytedance.live.datacontext.j<GeneralCarnivalDataSyncModel> r13 = r11.getGeneralCarnivalSyncModel();
        if (r13 == null) goto L26;
        GeneralCarnivalDataSyncModel r14 = (GeneralCarnivalDataSyncModel) r13.getValue();
        if (r14 == null) goto L26;
        dc2.c<com.bytedance.android.livesdk.interactivity.api.barrage.data.k> r15 = r14.getCarnivalMessage();
        if (r15 == null) goto L26;
        com.bytedance.android.livesdk.interactivity.api.barrage.data.k r16 = r15.c();
        if (r16 == null) goto L26;
        r1 = r16.a();
    L26:
        r3 = r1;
    L10:
        r3 = null;
        goto L11
    }

    public final void Bq(com.bytedance.android.livesdk.interactivity.api.barrage.model.a r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (this.i == null) goto L9;
        wq().post(new q(this, r3));
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.CarnivalDanmakuPresenter.IView
    public final void gd(int r2) {
        if (A == false) goto L8;
        com.bytedance.android.livesdk.interactivity.zdanmaku.a<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.i;
        if (r0 == null) goto L9;
        r0.e(r2);
        return;
    L9:
        return;
    }

    public final void onChanged(Object r6) {
        KVData r7 = (KVData) r6;
        if (r7 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r7.getKey()) == true) goto L63;
        String r0 = r7.getKey();
        Object r2 = null;
        switch(r0.hashCode()) {
            case -1540323875: goto L45;
            case -826138222: goto L33;
            case 294674590: goto L22;
            case 872172481: goto L16;
            case 1357974048: goto L11;
            default: goto L64;
        };
    L64:
        return;
    L11:
        if (r0.equals("cmd_normal_gift_layout_after_adjust_pos") == false) goto L51;
        Integer r8 = (Integer) r7.getData();
        if (r8 == null) goto L52;
        Aq(r8.intValue());
        return;
    L52:
        return;
    L51:
        return;
    L16:
        if (r0.equals("data_link_state") == false) goto L54;
        Integer r9 = (Integer) r7.getData(0);
        if (r9 != null) goto L20;
        r9 = 0;
    L20:
        zq(r9.intValue());
        return;
    L54:
        return;
    L22:
        if (r0.equals("data_keyboard_status_douyin") == false) goto L56;
        a r1 = this.v;
        cc2.c.C0011c r3 = cc2.c.C0011c.c;
        Boolean r4 = Boolean.FALSE;
        Object r10 = r7.getData();
        if ((r10 instanceof Boolean) == false) goto L27;
        r2 = r10;
    L27:
        Boolean r5 = (Boolean) r2;
        if (r5 == null) goto L31;
        r4 = r5;
    L31:
        r1.e(r3, r4.booleanValue());
        return;
    L56:
        return;
    L33:
        if (r0.equals("cmd_change_interactivity_component_visibility") == false) goto L58;
        Object r11 = r7.getData();
        if ((r11 instanceof cc2.e) == false) goto L38;
        r2 = r11;
    L38:
        cc2.e r13 = (cc2.e) r2;
        if (r13 == null) goto L59;
        cc2.f r14 = r13.b(cc2.c.class);
        if (r14 == null) goto L65;
        this.v.e(r14.a, r14.b);
        return;
    L65:
        return;
    L59:
        return;
    L58:
        return;
    L45:
        if (r0.equals("cmd_pk_state_change") == true) goto L47;
        return;
    L47:
        if (((zg1.z0) r7.getData()) == null) goto L62;
        Cq();
        return;
    L62:
        return;
    }

    public final void onEnterClear(int r2) {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onEnterClear(r2);
        if (((Boolean) k1.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (r2 != 1) goto L9;
        wq().j();
        return;
    }

    public final void onExitClear(int r2) {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onExitClear(r2);
        if (((Boolean) k1.a.getValue()).booleanValue() == true) goto L5;
        return;
    L5:
        if (r2 != 1) goto L9;
        wq().i();
        return;
    }

    public final void yq(String r2) {
        if (PublicScreenStyleHelper.n == false) goto L5;
    L6:
        PublicScreenStyleHelper.e(((Widget) this).dataCenter, r2);
        return;
    L5:
        if (com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.f.a().enable == true) goto L6;
    }

    public final void zq(int r6) {
        boolean r0 = false;
        if (r6 != 0) goto L5;
        boolean r2 = true;
    L6:
        boolean r3 = v.a(r6, 4);
        boolean r7 = v.a(r6, 2);
        if (r2 == true) goto L18;
        if (r3 == true) goto L10;
    L11:
        if (r7 == true) goto L13;
    L17:
        boolean r8 = false;
    L19:
        this.l = r8;
        wq().setEnableMask(this.l);
        CarnivalRenderEngineView r9 = wq();
        o22.d r4 = this.x;
        if (r4 != null) goto L22;
    L23:
        r0 = true;
    L24:
        r9.setCanDrawDanmakuEdge(r0);
        return;
    L22:
        if (r4.a() == true) goto L24;
    L13:
        if (this.d == true) goto L18;
        if (this.u != 0) goto L17;
    L10:
        if (this.m == false) goto L11;
    L18:
        r8 = true;
        goto L19
    L5:
        r2 = false;
        goto L6
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
