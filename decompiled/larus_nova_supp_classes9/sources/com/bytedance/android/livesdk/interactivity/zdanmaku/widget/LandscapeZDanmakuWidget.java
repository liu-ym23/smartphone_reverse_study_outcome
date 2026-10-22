package com.bytedance.android.livesdk.interactivity.zdanmaku.widget;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.DigHoleScreenUtil;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.i0;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.viewmodule.IWidget;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.chatroom.vsplayer.api.IVSPlayerService;
import com.bytedance.android.livesdk.chatroom.vsplayer.model.VSPlayerViewControlContext;
import com.bytedance.android.livesdk.chatroom.widget.MiddlewareRoomWidget;
import com.bytedance.android.livesdk.gift.platform.business.effect.assets.IAssetsManager;
import com.bytedance.android.livesdk.interactivity.api.IInteractivityInjectService;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.monitor.DanmakuMonitor;
import com.bytedance.android.livesdk.interactivity.api.monitorV2.business.InputValueNode;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.a0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.b0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.c0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.d0;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.y;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.z;
import com.bytedance.android.livesdk.interactivity.barrage.widget.BarrageWidgetContext;
import com.bytedance.android.livesdk.interactivity.utils.DanmakuCacheProviders;
import com.bytedance.android.livesdk.interactivity.zdanmaku.attributes.DanmakuType;
import com.bytedance.android.livesdk.interactivity.zdanmaku.binder.f0;
import com.bytedance.android.livesdk.interactivity.zdanmaku.binder.j0;
import com.bytedance.android.livesdk.interactivity.zdanmaku.binder.s;
import com.bytedance.android.livesdk.interactivity.zdanmaku.binder.v;
import com.bytedance.android.livesdk.interactivity.zdanmaku.binder.x;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.vs.BusinessConfigure;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.rxbus.RxBusAbility;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.zdanmaku.DanmakuController;
import com.bytedance.live.zdanmaku.data.Danmaku;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import j40.u0;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r52.e0;
import zg1.e3;
import zg1.n3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/zdanmaku/widget/LandscapeZDanmakuWidget;", "Lcom/bytedance/android/livesdk/chatroom/widget/MiddlewareRoomWidget;", "Lcom/bytedance/android/livesdk/interactivity/zdanmaku/widget/LandscapeDanmakuPresenterV2$IView;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lzg1/n3;", "event", BuildConfig.FLAVOR, "onEvent", "<init>", "()V", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LandscapeZDanmakuWidget extends MiddlewareRoomWidget implements LandscapeDanmakuPresenterV2.IView, Observer<KVData> {
    public final k a;
    public final com.bytedance.android.livesdk.interactivity.api.settings.config.p b;
    public BarrageWidgetContext c;
    public p22.g d;
    public p22.c e;
    public p22.p f;
    public p22.k g;
    public p22.a h;
    public p22.i i;
    public com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> j;
    public com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m k;
    public final Lazy l;
    public LandscapeDanmakuPresenterV2 m;
    public int n;
    public int o;
    public final CompositeDisposable p;
    public Disposable q;
    public c r;
    public b s;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ LandscapeZDanmakuWidget a;
        public final /* synthetic */ int b;

        public a(LandscapeZDanmakuWidget r1, int r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r2) {
            Long r3 = (Long) r2;
            this.a.Fq(this.b);
        }
    }

    public static final class b<T> implements h80.d {
        public final /* synthetic */ LandscapeZDanmakuWidget a;

        public b(LandscapeZDanmakuWidget r1) {
            this.a = r1;
        }

        public final Object get() {
            LandscapeZDanmakuWidget r0 = this.a;
            p22.p r1 = r0.f;
            if (r1 == null) goto L5;
            return r1;
        L5:
            return r0.Cq((BarrageSetting) l42.a.d.getValue());
        }
    }

    public static final class c<T> implements h80.d {
        public final /* synthetic */ LandscapeZDanmakuWidget a;

        public c(LandscapeZDanmakuWidget r1) {
            this.a = r1;
        }

        public final Object get() {
            LandscapeZDanmakuWidget r0 = this.a;
            p22.k r1 = r0.g;
            if (r1 == null) goto L5;
            return r1;
        L5:
            return r0.Bq((BarrageSetting) l42.a.d.getValue());
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LandscapeZDanmakuWidget a;

        public d(LandscapeZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
            LandscapeZDanmakuWidget.wq(this.a);
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ LandscapeZDanmakuWidget a;

        public e(LandscapeZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            Boolean r2 = (Boolean) r1;
            LandscapeZDanmakuWidget.wq(this.a);
        }
    }

    public static final class f<T> implements h80.d {
        public final /* synthetic */ LandscapeZDanmakuWidget a;

        public f(LandscapeZDanmakuWidget r1) {
            this.a = r1;
        }

        public final Object get() {
            LandscapeZDanmakuWidget r0 = this.a;
            p22.a r1 = r0.h;
            if (r1 == null) goto L5;
            return r1;
        L5:
            return r0.xq((BarrageSetting) l42.a.d.getValue());
        }
    }

    public static final class g<T> implements h80.d {
        public final /* synthetic */ LandscapeZDanmakuWidget a;

        public g(LandscapeZDanmakuWidget r1) {
            this.a = r1;
        }

        public final Object get() {
            LandscapeZDanmakuWidget r0 = this.a;
            p22.c r1 = r0.e;
            if (r1 == null) goto L5;
            return r1;
        L5:
            return r0.yq((BarrageSetting) l42.a.d.getValue());
        }
    }

    public static final class h implements com.bytedance.live.zdanmaku.data.c<com.bytedance.android.livesdk.interactivity.zdanmaku.i> {
        public h() {
        }

        public final com.bytedance.android.livesdk.interactivity.zdanmaku.i a() {
            return new com.bytedance.android.livesdk.interactivity.zdanmaku.i();
        }
    }

    public static final class i<T> implements h80.d {
        public final /* synthetic */ LandscapeZDanmakuWidget a;

        public i(LandscapeZDanmakuWidget r1) {
            this.a = r1;
        }

        public final Object get() {
            LandscapeZDanmakuWidget r0 = this.a;
            p22.g r1 = r0.d;
            if (r1 == null) goto L5;
            return r1;
        L5:
            return r0.zq((BarrageSetting) l42.a.d.getValue());
        }
    }

    public static final class j<T> implements h80.d {
        public final /* synthetic */ LandscapeZDanmakuWidget a;

        public j(LandscapeZDanmakuWidget r1) {
            this.a = r1;
        }

        public final Object get() {
            LandscapeZDanmakuWidget r0 = this.a;
            p22.i r1 = r0.i;
            if (r1 == null) goto L5;
            return r1;
        L5:
            return r0.Aq((BarrageSetting) l42.a.d.getValue());
        }
    }

    public static final class k implements DanmakuController.b<com.bytedance.android.livesdk.interactivity.zdanmaku.i> {
        public final /* synthetic */ LandscapeZDanmakuWidget a;

        public k(LandscapeZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void a(Danmaku r2) {
            com.bytedance.android.livesdk.interactivity.zdanmaku.i r3 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r2;
            Intrinsics.checkNotNullParameter(r3, "danmaku");
            LandscapeDanmakuPresenterV2 r0 = this.a.m;
            if (r0 == null) goto L6;
            r0.k0(r3);
            return;
        }

        public final void b(Danmaku r14) {
            com.bytedance.android.livesdk.interactivity.zdanmaku.i r15 = (com.bytedance.android.livesdk.interactivity.zdanmaku.i) r14;
            Intrinsics.checkNotNullParameter(r15, "danmaku");
            long r0 = System.currentTimeMillis();
            LandscapeDanmakuPresenterV2 r2 = this.a.m;
            if (r2 == null) goto L6;
            r2.l0(r15);
        L6:
            if (r15.getType() != DanmakuType.Privilege) goto L8;
            DanmakuMonitor.d(2, Long.valueOf(r15.h().a));
        L8:
            tc2.j r3 = (tc2.j) r15.b().e(tc2.j.class);
            if (r3 == null) goto L16;
            long r11 = r3.c - r3.b;
            long r9 = System.currentTimeMillis() - r3.b;
            com.bytedance.android.livesdk.interactivity.api.monitor.e.a(r3.a, "danmaku", r9, r11);
            com.bytedance.android.livesdk.interactivity.utils.b.a(r3, r0);
            if (r3.g == true) goto L13;
            return;
        L13:
            if (r15.getType() != DanmakuType.Chat) goto L18;
            z32.c.b(InputValueNode.LandscapeSelfChatShowCount);
            return;
        L18:
            return;
        }
    }

    public static final class l implements Runnable {
        public final /* synthetic */ LandscapeZDanmakuWidget a;

        public l(LandscapeZDanmakuWidget r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.Kq();     // Catch: Throwable -> L11
            LandscapeDanmakuPresenterV2 r0 = this.a.m;     // Catch: Throwable -> L11
            if (r0 == null) goto L14;
            com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.a r1 = r0.E;     // Catch: Throwable -> L11
            r1.getClass();     // Catch: Throwable -> L11
            if (((xs1.e) com.bytedance.android.livesdk.chatroom.setting.a.a.getValue()).b() == false) goto L18;
            r1.l();     // Catch: Throwable -> L11
            MutableLiveData<Boolean> r2 = r1.d;     // Catch: Throwable -> L11
            if (r2 == null) goto L19;
            r2.observeForever(r1.e);     // Catch: Throwable -> L11
            return;
        L19:
            return;
        L18:
            return;
        L14:
            return;
        L11:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }
    }

    public static final class m<T> implements Consumer {
        public final /* synthetic */ LandscapeZDanmakuWidget a;

        public m(LandscapeZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            e3 r8 = (e3) r7;
            Intrinsics.checkNotNullParameter(r8, "event");
            LandscapeZDanmakuWidget r0 = this.a;
            DataCenter r1 = ((Widget) r0).dataCenter;
            if (r1 == null) goto L7;
            Boolean r2 = (Boolean) r1.get("byte_cast_danmaku_mode", Boolean.FALSE);
            if (r2 == null) goto L7;
            boolean r3 = r2.booleanValue();
        L9:
            if (r8.b == true) goto L35;
            if (r3 == true) goto L35;
            View r9 = ((Widget) r0).contentView;
            if (r9 == null) goto L15;
            r9.setVisibility(0);
        L15:
            p22.g r10 = r0.zq((BarrageSetting) l42.a.d.getValue());
            r0.d = r10;
            r0.n = r0.Lq(r10);
            p22.g r11 = r0.d;
            if (r11 == null) goto L18;
            BarrageSettingArea r13 = r11.a;
        L20:
            if (r13 != BarrageSettingArea.CLOSE) goto L32;
            ViewGroup r14 = ((Widget) r0).containerView;
            if (r14 == null) goto L24;
            int r15 = r14.getHeight();
        L25:
            if (r15 <= 0) goto L30;
            ViewGroup r16 = ((Widget) r0).containerView;
            if (r16 == null) goto L29;
            int r17 = r16.getHeight();
        L31:
            r0.n = r17 / 2;
            goto L32
        L29:
            r17 = 0;
            goto L31
        L30:
            r17 = s1.w();
            goto L31
        L24:
            r15 = 0;
        L32:
            r0.Iq(r0.n, false);
            com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m r18 = r0.k;
            if (r18 == null) goto L36;
            r18.h(r0.Gq());
        L36:
            IInteractivityInjectService r19 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
            if (r19 != null) goto L39;
            return;
        L39:
            if (r19.isInVrLandscape(((Widget) r0).dataCenter) != true) goto L53;
            IRoomContextService r20 = r0.getDataService();
            if (r20 == null) goto L54;
            com.bytedance.android.livesdk.chatroom.o r21 = IRoomContextService.a.a(r20, ((Widget) r0).dataCenter, 0, 2);
            if (r21 == null) goto L55;
            com.bytedance.live.datacontext.m r23 = r21.A1();
            if (r23 != null) goto L47;
            return;
        L47:
            if (((Boolean) r23.getValue()).booleanValue() != true) goto L57;
            View r24 = ((Widget) r0).contentView;
            if (r24 == null) goto L58;
            r24.setVisibility(8);
            return;
        L58:
            return;
        L57:
            return;
        L55:
            return;
        L54:
            return;
        L53:
            return;
        L18:
            r13 = null;
        L35:
            ((Widget) r0).contentView.setVisibility(4);
        L7:
            r3 = false;
            goto L9
        }
    }

    public static final class n<T> implements Consumer {
        public final /* synthetic */ LandscapeZDanmakuWidget a;

        public n(LandscapeZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            q22.b r6 = (q22.b) r5;
            Intrinsics.checkNotNullParameter(r6, "event");
            LandscapeZDanmakuWidget r0 = this.a;
            BarrageSetting r7 = r6.a;
            p22.g r1 = r0.zq(r7);
            r0.d = r1;
            int r2 = r0.Lq(r1);
            r0.n = r2;
            r0.Iq(r2, false);
            com.bytedance.android.livesdk.interactivity.zdanmaku.layout.a r3 = r0.Gq();
            com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m r4 = r0.k;
            if (r4 == null) goto L5;
            r4.h(r3);
        L5:
            p22.k r8 = r0.Bq(r7);
            r0.g = r8;
            r8.a(r3.a);
            r0.h = r0.xq(r7);
            r0.i = r0.Aq(r7);
            r0.e = r0.yq(r7);
            p22.p r9 = r0.Cq(r7);
            r0.f = r9;
            r9.a(r3.a, r0.isScreenPortrait());
            BarrageWidgetContext r10 = r0.c;
            if (r10 == null) goto L10;
            r10.getGiftDanmakuSettingConfig().setValue(r0.d);
            r10.getBusinessDanmakuConfig().setValue(r0.e);
            r10.getAdminDanmakuSettingConfig().setValue(r0.h);
            r10.getPrivilegeDanmakuSettingConfig().setValue(r0.g);
            r10.getTextDanmakuSettingConfig().setValue(r0.f);
            r10.getNormalDanmakuSettingConfig().setValue(r0.i);
            pk6.a r11 = (pk6.a) r10.getDanmakuAlpha().getValue();
            if (r11 == null) goto L10;
            r11.a = (int) ((r7.getAlpha() / 100) * 255);
        L10:
            p22.g r13 = r0.d;
            if (r13 == null) goto L15;
            LandscapeDanmakuPresenterV2 r14 = r0.m;
            if (r14 == null) goto L15;
            r14.o0(r13.a, r13.b);
        L15:
            LandscapeDanmakuPresenterV2 r15 = r0.m;
            if (r15 == null) goto L19;
            r15.p0(r7.isLotteryOpen());
            return;
        }
    }

    public static final class o<T> implements Consumer {
        public final /* synthetic */ LandscapeZDanmakuWidget a;

        public o(LandscapeZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            q22.c r4 = (q22.c) r3;
            Intrinsics.checkNotNullParameter(r4, "event");
            LandscapeZDanmakuWidget r0 = this.a;
            boolean r5 = r4.a;
            r0.getClass();
            BarrageSetting r1 = (BarrageSetting) l42.a.d.getValue();
            LandscapeDanmakuPresenterV2 r2 = r0.m;
            if (r2 == null) goto L11;
            if (r5 == true) goto L6;
        L8:
            boolean r6 = false;
        L9:
            r2.p0(r6);
            return;
        L6:
            if (r1.isLotteryOpen() == false) goto L8;
            r6 = true;
            goto L9
        }
    }

    public static final class p<T> implements Consumer {
        public final /* synthetic */ LandscapeZDanmakuWidget a;

        public p(LandscapeZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            LandscapeZDanmakuWidget r0 = this.a;
            r0.onEvent((n3) r2);
        }
    }

    public static final class q<T> implements Consumer {
        public final /* synthetic */ LandscapeZDanmakuWidget a;

        public q(LandscapeZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            if (((Boolean) r3).booleanValue() == false) goto L11;
            com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r4 = this.a.j;
            if (r4 == null) goto L7;
            r4.postRunnable(new com.bytedance.live.zdanmaku.g(r4));
        L7:
            LandscapeDanmakuPresenterV2 r5 = this.a.m;
            if (r5 == null) goto L10;
            r5.B.d();
            r5.y.d();
            r5.x.d();
            r5.F.d();
            r5.C.d();
            r5.z.d();
            r5.g.clear();
            r5.f.clear();
            r5.h.clear();
        L10:
            UtilityKotlinExtentionsKt.u(this.a.Jq());
            return;
        L11:
            LandscapeDanmakuPresenterV2 r6 = this.a.m;
            if (r6 == null) goto L14;
            i0.c().post(new com.bytedance.android.livesdk.interactivity.zdanmaku.widget.d(r6));
        L14:
            UtilityKotlinExtentionsKt.w(this.a.Jq());
        }
    }

    public static final class r<T> implements Consumer {
        public final /* synthetic */ LandscapeZDanmakuWidget a;

        public r(LandscapeZDanmakuWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            if (((Boolean) r5).booleanValue() == false) goto L19;
            com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r6 = this.a.j;
            if (r6 == null) goto L8;
            r6.postRunnable(new com.bytedance.live.zdanmaku.f(r6, LandscapeZDanmakuWidget$onCreate$9$1.INSTANCE, LandscapeZDanmakuWidget$onCreate$9$2.INSTANCE));
        L8:
            IRoomContextService r7 = this.a.getRoomContextService();
            if (r7 == null) goto L16;
            com.bytedance.android.livesdk.chatroom.o r8 = IRoomContextService.a.a(r7, ((Widget) this.a).dataCenter, 0, 2);
            if (r8 == null) goto L17;
            com.bytedance.live.datacontext.m r9 = r8.W1();
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

    public final View Jq() {
        return (View) this.l.getValue();
    }

    public final int getLayoutId() {
        return 2131566692;
    }

    public final /* synthetic */ String getLogTag() {
        return IWidget.-CC.$default$getLogTag(this);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final void startDanmaku() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final void stopDanmaku() {
    }

    public final com.bytedance.android.livesdk.interactivity.zdanmaku.layout.a Gq() {
        int r0 = Math.max(this.o, Math.max(Jq().getWidth(), s1.y()));
        this.o = r0;
        float r1 = r0 / Math.max(this.b.a(), 1);
        float r2 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        int r7 = (int) (r1 * r2);
        p22.g r3 = this.d;
        if (r3 != null) goto L6;
        r3 = zq((BarrageSetting) l42.a.d.getValue());
    L6:
        return new com.bytedance.android.livesdk.interactivity.zdanmaku.layout.a(this.o, this.n, r3.d.a, UtilityKotlinExtentionsKt.i(2), r7, this.b.a() / r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final void K0() {
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.j;
        if (r0 == null) goto L6;
        r0.b();
        return;
    }

    public final void Kq() {
        if (((Widget) this).isViewValid == true) goto L5;
        return;
    L5:
        p22.g r1 = this.d;
        if (r1 != null) goto L9;
        r1 = zq((BarrageSetting) l42.a.d.getValue());
    L9:
        if (((Widget) this).containerView.getHeight() <= 0) goto L11;
        int r2 = ((Widget) this).containerView.getHeight();
    L12:
        this.n = r2;
        int r3 = Lq(r1);
        this.n = r3;
        Iq(r3, true);
        int r4 = Math.max(this.o, Math.max(Jq().getWidth(), s1.y()));
        this.o = r4;
        float r5 = r4 / Math.max(this.b.a(), 1);
        float r6 = IAssetsManager.DownloadAssetsSource.SOURCE_LOCAL_SEND_GIFT_NOW;
        int r8 = r1.d.a;
        com.bytedance.android.livesdk.interactivity.zdanmaku.layout.a r7 = new com.bytedance.android.livesdk.interactivity.zdanmaku.layout.a(this.o, this.n, r8, UtilityKotlinExtentionsKt.i(2), (int) (r5 * r6), this.b.a() / r6);
        com.bytedance.android.livesdk.interactivity.zdanmaku.layout.b r13 = new com.bytedance.android.livesdk.interactivity.zdanmaku.layout.b(r7, s1.w());
        p22.k r9 = Bq((BarrageSetting) l42.a.d.getValue());
        this.g = r9;
        r9.a(r7.a);
        p22.p r10 = this.f;
        if (r10 == null) goto L15;
        r10.a(r7.a, isScreenPortrait());
    L15:
        this.s = new b(this);
        i r11 = new i(this);
        g r14 = new g(this);
        f r15 = new f(this);
        j r16 = new j(this);
        this.r = new c(this);
        IRoomContextService r17 = getRoomContextService();
        if (r17 == null) goto L22;
        com.bytedance.android.livesdk.chatroom.o r18 = IRoomContextService.a.a(r17, ((Widget) this).dataCenter, 0, 2);
        if (r18 == null) goto L22;
        Boolean r19 = r18.isAnchor();
        if (r19 == null) goto L22;
        boolean r20 = r19.booleanValue();
    L23:
        c r110 = this.r;
        if (r110 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("privilegeDanmakuSettingConfigSupplier");
    L26:
        b r111 = this.s;
        if (r111 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("textDanmakuSettingConfigSupplier");
    L29:
        com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m r112 = new com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m(r13, r110, r111, com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.j.a(r20, getRoom()), 8);
        this.k = r112;
        h r21 = new h();
        com.bytedance.live.zdanmaku.data.d r113 = new com.bytedance.live.zdanmaku.data.d();
        r113.a(z.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
        r113.a(d0.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
        r113.a(c0.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
        r113.a(y.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
        r113.a(a0.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
        r113.a(b0.class, com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class);
        int r114 = com.bytedance.live.zdanmaku.e.i;
        com.bytedance.live.zdanmaku.e.a r115 = new com.bytedance.live.zdanmaku.e.a();
        View r23 = (View) DanmakuCacheProviders.b.getValue();
        b r24 = this.s;
        if (r24 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("textDanmakuSettingConfigSupplier");
    L32:
        r115.b(com.bytedance.android.livesdk.interactivity.api.publicscreen.d.class, new com.bytedance.android.livesdk.interactivity.zdanmaku.binder.k(r23, r24, this.c));
        r115.b(q22.a.class, new s((View) DanmakuCacheProviders.d.getValue(), r11, this.c));
        r115.b(BusinessConfigure.class, new com.bytedance.android.livesdk.interactivity.zdanmaku.binder.e(r14, this.c));
        r115.b(com.bytedance.android.livesdk.interactivity.zdanmaku.k.class, new com.bytedance.android.livesdk.interactivity.zdanmaku.binder.a((View) DanmakuCacheProviders.e.getValue(), r15, this.c));
        r115.b(n22.d.class, new v((View) DanmakuCacheProviders.f.getValue(), r16, this.c));
        View r25 = (View) DanmakuCacheProviders.g.getValue();
        b r26 = this.s;
        if (r26 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("textDanmakuSettingConfigSupplier");
    L35:
        r115.b(q72.f.class, new j0(r25, r26, this.c));
        View r27 = (View) DanmakuCacheProviders.h.getValue();
        b r28 = this.s;
        if (r28 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("textDanmakuSettingConfigSupplier");
    L38:
        r115.b(q72.e.class, new com.bytedance.android.livesdk.interactivity.zdanmaku.binder.a0(r27, r28, this.c));
        View r29 = (View) DanmakuCacheProviders.n.getValue();
        View r30 = (View) DanmakuCacheProviders.m.getValue();
        c r31 = this.r;
        if (r31 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("privilegeDanmakuSettingConfigSupplier");
    L41:
        r115.b(com.bytedance.android.livesdk.interactivity.zdanmaku.j.class, new f0(r29, r30, r31, this.c));
        r115.b(com.bytedance.android.livesdk.interactivity.zdanmaku.d.class, new x((View) DanmakuCacheProviders.o.getValue(), r16, this.c));
        r115.b = r113;
        r115.d = AsyncTask.THREAD_POOL_EXECUTOR;
        r115.a = new vc2.a("Landscape");
        com.bytedance.live.artist.render.c r33 = Jq();
        if (r33 == null) goto L133;
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r34 = r115.a(r33, r21, r112);
        this.j = r34;
        r34.g.h = this.a;
        BarrageWidgetContext r35 = this.c;
        if (r35 != null) goto L46;
    L55:
        View r36 = ((Widget) this).contentView;
        if (((Boolean) l42.a.g.getValue()).booleanValue() == false) goto L58;
        int r37 = 4;
    L59:
        r36.setVisibility(r37);
        if (isEnableLandscapeChat() == true) goto L62;
        ((Widget) this).contentView.setVisibility(4);
    L62:
        ALogger.w("ToolbarLandscapeBlockEvent", "init widget,visiable:" + ((Widget) this).contentView.getVisibility());
        final boolean r38 = com.bytedance.android.livesdk.utils.landscape.d.c(((Widget) this).dataCenter);
        if (r38 == false) goto L65;
    L66:
        com.bytedance.android.livesdk.f.d().a.observe(this, new com.bytedance.android.livesdk.interactivity.zdanmaku.widget.h(this, r38));
    L67:
        IRoomContextService r39 = getRoomContextService();
        if (r39 == null) goto L79;
        com.bytedance.android.livesdk.chatroom.o r40 = IRoomContextService.a.a(r39, ((Widget) this).dataCenter, 0, 2);
        if (r40 == null) goto L79;
        com.bytedance.live.datacontext.m r41 = r40.x1();
        if (r41 == null) goto L78;
        Observable r43 = r41.a();
        if (r43 == null) goto L78;
        ObservableSubscribeProxy r44 = (ObservableSubscribeProxy) r43.as(autoDispose());
        if (r44 == null) goto L78;
        r44.subscribe(new com.bytedance.android.livesdk.interactivity.zdanmaku.widget.g(this, r38));
    L78:
        ((Widget) this).dataCenter.observe("data_is_hiding_landscape_buttons", new LandscapeZDanmakuWidget$observeForAlpha$$inlined$let$lambda$2(this, r38));
        ((Widget) this).dataCenter.observe("data_is_hiding_landscape_buttons_in_preview", new LandscapeZDanmakuWidget$observeForAlpha$$inlined$let$lambda$3(this, r38));
    L79:
        IVSPlayerService r45 = jc1.k.f(IVSPlayerService.class);
        if (r45 == null) goto L91;
        com.bytedance.android.livesdk.chatroom.vsplayer.api.c r46 = r45.provideVSPlayerViewControlService(((Widget) this).dataCenter);
        if (r46 == null) goto L84;
        VSPlayerViewControlContext r47 = r46.provideContext();
    L85:
        if (r47 == null) goto L91;
        com.bytedance.live.datacontext.m r48 = r47.getPlayerViewVisible();
        if (r48 == null) goto L91;
        Disposable r49 = i80.a.a(r48, new LandscapeZDanmakuWidget$observeForAlpha$3(this));
        if (r49 == null) goto L91;
        RxUtilKt.c(r49, this.p);
        goto L91
    L84:
        r47 = null;
    L91:
        IRoomContextService r50 = getRoomContextService();
        if (r50 == null) goto L102;
        com.bytedance.android.livesdk.chatroom.o r51 = IRoomContextService.a.a(r50, ((Widget) this).dataCenter, 0, 2);
        if (r51 == null) goto L102;
        com.bytedance.live.datacontext.m r53 = r51.z1();
        if (r53 == null) goto L102;
        Observable r54 = r53.a();
        if (r54 == null) goto L102;
        ObservableSubscribeProxy r55 = (ObservableSubscribeProxy) r54.as(autoDispose());
        if (r55 == null) goto L102;
        r55.subscribe(new d(this));
    L102:
        IInteractivityInjectService r56 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r56 == null) goto L109;
        com.bytedance.live.datacontext.m<Boolean> r57 = r56.getLandscapeDialogState(((MiddlewareRoomWidget) this).dataContext);
        if (r57 == null) goto L109;
        Disposable r58 = i80.a.a(r57, new LandscapeZDanmakuWidget$initDanmakuPlayer$5(this));
        if (r58 == null) goto L109;
        RxUtilKt.c(r58, this.p);
    L109:
        IRoomContextService r59 = getRoomContextService();
        if (r59 == null) goto L120;
        com.bytedance.android.livesdk.chatroom.o r60 = IRoomContextService.a.a(r59, ((Widget) this).dataCenter, 0, 2);
        if (r60 == null) goto L120;
        com.bytedance.live.datacontext.m r61 = r60.y2();
        if (r61 == null) goto L120;
        Observable r63 = r61.a();
        if (r63 == null) goto L120;
        Disposable r64 = r63.subscribe(new e(this));
        if (r64 == null) goto L120;
        RxUtilKt.c(r64, this.p);
    L120:
        BarrageWidgetContext r65 = this.c;
        if (r65 == null) goto L134;
        com.bytedance.live.datacontext.m<Boolean> r66 = r65.getDefaultVisibleAlpha();
        if (r66 != null) goto L125;
        return;
    L125:
        if (((Boolean) r66.getValue()).booleanValue() == true) goto L127;
        return;
    L127:
        if (com.bytedance.android.livesdk.utils.landscape.d.c(((Widget) this).dataCenter) == false) goto L129;
        float r67 = 0.7f;
    L130:
        Eq(r67);
        return;
    L129:
        r67 = 1.0f;
        goto L130
    L134:
        return;
    L65:
        if ((!isScreenPortrait()) == false) goto L67;
    L58:
        r37 = 0;
        goto L59
    L46:
        if (r35.isCleared() == true) goto L55;
        com.bytedance.live.datacontext.n<com.bytedance.android.livesdk.interactivity.barrage.widget.a> r68 = r35.getEnv();
        isScreenPortrait();
        IRoomContextService r69 = getRoomContextService();
        if (r69 == null) goto L54;
        com.bytedance.android.livesdk.chatroom.o r70 = IRoomContextService.a.a(r69, ((Widget) this).dataCenter, 0, 2);
        if (r70 == null) goto L54;
        Boolean r71 = r70.isAnchor();
        if (r71 == null) goto L54;
        r71.booleanValue();
    L54:
        r68.setValue(new com.bytedance.android.livesdk.interactivity.barrage.widget.a());
        goto L55
    L133:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.live.artist.render.RenderEngine");
    L22:
        r20 = false;
        goto L23
    L11:
        r2 = s1.w();
        goto L12
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final int N20() {
        com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m r0 = this.k;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.zdanmaku.layout.a r1 = r0.a;
        if (r1 == null) goto L7;
        return r1.a;
    L7:
        return 0;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final void Q7() {
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.j;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final int U() {
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.j;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.c();
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final p22.p fR() {
        p22.p r0 = this.f;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return Cq((BarrageSetting) l42.a.d.getValue());
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final boolean isInCarnival() {
        BarrageWidgetContext r0 = this.c;
        if (r0 == null) goto L9;
        com.bytedance.live.datacontext.m<Boolean> r1 = r0.isCarnivalStarted();
        if (r1 == null) goto L9;
        if (((Boolean) r1.getValue()).booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final boolean vV() {
        p22.g r0 = this.d;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.e != true) goto L7;
        return true;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final void x0() {
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.j;
        if (r0 == null) goto L6;
        r0.f();
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final int x60() {
        com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m r0 = this.k;
        if (r0 == null) goto L7;
        com.bytedance.android.livesdk.interactivity.zdanmaku.layout.a r1 = r0.a;
        if (r1 == null) goto L7;
        return r1.d;
    L7:
        return 0;
    }

    public LandscapeZDanmakuWidget() {
        this.a = new k(this);
        this.b = (com.bytedance.android.livesdk.interactivity.api.settings.config.p) r52.b0.a.getValue();
        this.l = LazyKt.lazy(new LandscapeZDanmakuWidget$renderEngineView$2(this));
        this.p = new CompositeDisposable();
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
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, ((Widget) this).dataCenter, 0, 2);
        if (r1 == null) goto L9;
        Boolean r2 = r1.isPortraitInteraction();
        if (r2 == null) goto L9;
        return r2.booleanValue();
    L9:
        return false;
    }

    public final void onCreate() {
        super.onCreate();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.c(this);
        DataContext r0 = getRoomContext();
        if (r0 != null) goto L5;
        return;
    L5:
        this.c = com.bytedance.android.livesdk.interactivity.barrage.widget.b.a(r0, ((Widget) this).dataCenter);
        BarrageSetting r1 = (BarrageSetting) l42.a.d.getValue();
        this.d = zq(r1);
        this.e = yq(r1);
        this.h = xq(r1);
        p22.k r2 = Bq(r1);
        this.g = r2;
        int[] r3 = {0, 1};
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        r2.e = r3;
        this.i = Aq(r1);
        this.f = Cq(r1);
        BarrageWidgetContext r4 = this.c;
        if (r4 == null) goto L11;
        r4.getGiftDanmakuSettingConfig().setValue(this.d);
        r4.getBusinessDanmakuConfig().setValue(this.e);
        r4.getAdminDanmakuSettingConfig().setValue(this.h);
        r4.getPrivilegeDanmakuSettingConfig().setValue(this.g);
        r4.getTextDanmakuSettingConfig().setValue(this.f);
        r4.getNormalDanmakuSettingConfig().setValue(this.i);
        pk6.a r5 = (pk6.a) r4.getDanmakuAlpha().getValue();
        if (r5 == null) goto L10;
        r5.a = (int) ((r1.getAlpha() / 100) * 255);
    L10:
        r4.getScrollBarrageView().setValue(((Widget) this).contentView);
    L11:
        LandscapeDanmakuPresenterV2 r6 = new LandscapeDanmakuPresenterV2();
        this.m = r6;
        r6.g0(this);
        LandscapeDanmakuPresenterV2 r7 = this.m;
        int r8 = 0;
        if (r7 != null) goto L14;
    L20:
        p22.g r9 = this.d;
        if (r9 == null) goto L25;
        LandscapeDanmakuPresenterV2 r10 = this.m;
        if (r10 == null) goto L25;
        r10.o0(r9.a, r9.b);
    L25:
        Jq().post(new l(this));
        if (isScreenPortrait() == true) goto L43;
        if (((Boolean) r52.c0.a.getValue()).booleanValue() == false) goto L43;
        IRoomContextService r11 = getRoomContextService();
        if (r11 == null) goto L43;
        com.bytedance.android.livesdk.chatroom.o r13 = IRoomContextService.a.a(r11, ((Widget) this).dataCenter, 0, 2);
        if (r13 == null) goto L43;
        com.bytedance.live.datacontext.m r14 = r13.getRoom();
        if (r14 == null) goto L43;
        IRoom r15 = (IRoom) r14.getValue();
        if (r15 == null) goto L43;
        IRoomAuthStatus r16 = r15.getRoomAuthStatus();
        if (r16 == null) goto L43;
        if (r16.isEnableLandscapeChat() != true) goto L43;
        y3.i(((Widget) this).dataCenter).k(ToolbarButton.BARRAGE_SETTING, new com.bytedance.android.livesdk.interactivity.barrage.widget.e());
    L43:
        if (isEnableLandscapeChat() == true) goto L46;
        ((Widget) this).contentView.setVisibility(4);
    L46:
        if (((Boolean) u0.a.getValue()).booleanValue() == true) goto L56;
        Context r17 = getContext();
        boolean r18 = isScreenPortrait();
        IRoomContextService r19 = getRoomContextService();
        if (r19 == null) goto L52;
        com.bytedance.android.livesdk.chatroom.o r20 = IRoomContextService.a.a(r19, ((Widget) this).dataCenter, 0, 2);
        if (r20 == null) goto L52;
        Boolean r21 = r20.isAnchor();
    L54:
        if (DigHoleScreenUtil.isNeedStatusBarAdapt(r17, r18, Intrinsics.areEqual(r21, Boolean.TRUE)) == false) goto L56;
        UIUtils.updateLayoutMargin(Jq(), -UIUtils.getStatusBarHeight(getContext()), -3, -3, -3);
    L52:
        r21 = null;
    L56:
        ((Widget) this).dataCenter.observe("data_room_comment_status", this);
        L7(e3.class, new m(this));
        L7(q22.b.class, new n(this));
        L7(q22.c.class, new o(this));
        IInteractivityInjectService r23 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r23 != null) goto L59;
    L72:
        BarrageWidgetContext r24 = this.c;
        if (r24 == null) goto L81;
        com.bytedance.live.datacontext.m<Boolean> r25 = r24.isCarnivalStarted();
        if (r25 == null) goto L81;
        Observable r26 = r25.a();
        if (r26 == null) goto L81;
        ObservableSubscribeProxy r27 = (ObservableSubscribeProxy) r26.as(autoDispose());
        if (r27 == null) goto L81;
        r27.subscribe(new q(this));
    L81:
        IRoomContextService r28 = getRoomContextService();
        if (r28 == null) goto L92;
        com.bytedance.android.livesdk.chatroom.o r29 = IRoomContextService.a.a(r28, ((Widget) this).dataCenter, 0, 2);
        if (r29 == null) goto L92;
        com.bytedance.live.datacontext.m r30 = r29.W1();
        if (r30 == null) goto L92;
        Observable r31 = r30.a();
        if (r31 == null) goto L92;
        ObservableSubscribeProxy r33 = (ObservableSubscribeProxy) r31.as(autoDispose());
        if (r33 == null) goto L92;
        r33.subscribe(new r(this));
    L92:
        this.p.add(Observable.interval(60, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.bytedance.android.livesdk.interactivity.zdanmaku.widget.f(this)));
        return;
    L59:
        if (r23.isInVrLandscape(((Widget) this).dataCenter) != true) goto L72;
        ((ObservableSubscribeProxy) RxBusAbility.INSTANCE.getRxBus(((Widget) this).dataCenter).b(n3.class).observeOn(AndroidSchedulers.mainThread()).as(autoDispose())).subscribe(new p(this));
        View r34 = ((Widget) this).contentView;
        if (r34 == null) goto L72;
        IRoomContextService r35 = getDataService();
        if (r35 == null) goto L71;
        com.bytedance.android.livesdk.chatroom.o r36 = IRoomContextService.a.a(r35, ((Widget) this).dataCenter, 0, 2);
        if (r36 == null) goto L71;
        com.bytedance.live.datacontext.m r37 = r36.A1();
        if (r37 == null) goto L71;
        if (((Boolean) r37.getValue()).booleanValue() != true) goto L71;
        r8 = 8;
    L71:
        r34.setVisibility(r8);
        goto L72
    L14:
        if (p61.a.a() == false) goto L16;
    L18:
        boolean r38 = false;
    L19:
        r7.p0(r38);
        goto L20
    L16:
        if (r1.isLotteryOpen() == false) goto L18;
        r38 = true;
        goto L19
    }

    public final void onDestroy() {
        super/*com.bytedance.android.live.core.tetris.widgets.LiveWidget*/.onDestroy();
        com.bytedance.android.livesdk.chatroom.ui.framework.utils.f.d(this);
        DataCenter r0 = ((Widget) this).dataCenter;
        if (r0 == null) goto L5;
        r0.removeObserver(this);
    L5:
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r1 = this.j;
        if (r1 == null) goto L8;
        r1.e();
    L8:
        LandscapeDanmakuPresenterV2 r2 = this.m;
        if (r2 == null) goto L11;
        r2.detachView();
    L11:
        this.p.clear();
        BarrageWidgetContext r3 = this.c;
        if (r3 == null) goto L17;
        com.bytedance.live.datacontext.n<View> r4 = r3.getScrollBarrageView();
        if (r4 == null) goto L18;
        r4.setValue(null);
        return;
    L18:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final com.bytedance.android.livesdk.interactivity.zdanmaku.layout.m WT() {
        return this.k;
    }

    public static final void wq(LandscapeZDanmakuWidget r8) {
        IRoomContextService r0 = r8.getRoomContextService();
        boolean r4 = false;
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.chatroom.o r1 = IRoomContextService.a.a(r0, ((Widget) r8).dataCenter, 0, 2);
        if (r1 == null) goto L11;
        com.bytedance.live.datacontext.m r2 = r1.z1();
        if (r2 == null) goto L11;
        Boolean r3 = (Boolean) r2.getValue();
        if (r3 == null) goto L11;
        boolean r5 = r3.booleanValue();
    L12:
        IInteractivityInjectService r6 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r6 == null) goto L19;
        com.bytedance.live.datacontext.m<Boolean> r7 = r6.getLandscapeDialogState(((MiddlewareRoomWidget) r8).dataContext);
        if (r7 == null) goto L19;
        Boolean r9 = (Boolean) r7.getValue();
        if (r9 == null) goto L19;
        boolean r10 = r9.booleanValue();
    L20:
        IRoomContextService r11 = r8.getRoomContextService();
        if (r11 == null) goto L29;
        com.bytedance.android.livesdk.chatroom.o r13 = IRoomContextService.a.a(r11, ((Widget) r8).dataCenter, 0, 2);
        if (r13 == null) goto L29;
        com.bytedance.live.datacontext.m r14 = r13.y2();
        if (r14 == null) goto L29;
        Boolean r15 = (Boolean) r14.getValue();
        if (r15 == null) goto L29;
        boolean r16 = r15.booleanValue();
    L30:
        if (r5 == true) goto L33;
        if (r10 == true) goto L33;
        if (r16 == true) goto L33;
    L34:
        if (r4 == false) goto L38;
        ViewGroup r17 = ((Widget) r8).containerView;
        if (r17 == null) goto L42;
        r17.setAlpha(0.0f);
        return;
    L42:
        return;
    L38:
        ViewGroup r18 = ((Widget) r8).containerView;
        if (r18 == null) goto L44;
        r18.setAlpha(1.0f);
        return;
    L44:
        return;
    L33:
        r4 = true;
    L29:
        r16 = false;
    L19:
        r10 = false;
    L11:
        r5 = false;
        goto L12
    }

    public final p22.i Aq(BarrageSetting r4) {
        return new p22.i(r4.getBarrageArea(), r4.getFontSize(), r4.getAlpha());
    }

    public final p22.k Bq(BarrageSetting r4) {
        return new p22.k(r4.getBarrageArea(), r4.getFontSize(), r4.getAlpha());
    }

    public final p22.p Cq(BarrageSetting r4) {
        return new p22.p(r4.getBarrageArea(), r4.getFontSize(), r4.getAlpha());
    }

    public final void Eq(float r4) {
        if (((Widget) this).contentView != null) goto L5;
        return;
    L5:
        BarrageWidgetContext r0 = this.c;
        if (r0 == null) goto L14;
        com.bytedance.live.datacontext.j<pk6.a> r1 = r0.getDanmakuAlpha();
        if (r1 == null) goto L15;
        pk6.a r2 = (pk6.a) r1.getValue();
        if (r2 == null) goto L16;
        r2.a = (int) (r4 * ((((BarrageSetting) l42.a.d.getValue()).getAlpha() / 100) * 255));
        return;
    L16:
        return;
    L15:
        return;
    }

    public final void Fq(int r4) {
        ALogger.d("dirtyRegionOpt", "landscape danmuku changeRenderViewHeight:" + r4);
        ViewGroup r0 = (ViewGroup) Jq().getParent();
        if (r0 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r0.getClipChildren());
    L7:
        if (Intrinsics.areEqual(r1, Boolean.FALSE) == false) goto L9;
        r0.setClipChildren(true);
    L9:
        View r2 = Jq();
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
        r3.height = r4;
        r2.setLayoutParams(r3);
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final int Lq(p22.g r3) {
        if (((Widget) this).containerView.getHeight() <= 0) goto L5;
        int r0 = ((Widget) this).containerView.getHeight();
    L6:
        BarrageSettingArea r4 = r3.a;
        if (r4 != null) goto L9;
        return r0;
    L9:
        if (r4 == null) goto L28;
        int r5 = com.bytedance.android.livesdk.interactivity.zdanmaku.widget.e.a[r4.ordinal()];
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
        r0 = s1.w();
        goto L6
    }

    public final void onChanged(Object r2) {
        KVData r3 = (KVData) r2;
        if (r3 != null) goto L6;
        return;
    L6:
        if (TextUtils.equals("data_room_comment_status", r3.getKey()) == false) goto L13;
        ALogger.w("ToolbarLandscapeBlockEvent", "room_comment_status_change, visible:" + isEnableLandscapeChat());
        View r4 = ((Widget) this).contentView;
        if (isEnableLandscapeChat() == false) goto L10;
        int r0 = 0;
    L11:
        UIUtils.setViewVisibility(r4, r0);
        return;
    L10:
        r0 = 8;
        goto L11
    }

    public final void onEvent(n3 r3) {
        IInteractivityInjectService r0 = (IInteractivityInjectService) jc1.k.f(IInteractivityInjectService.class);
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isInVrLandscape(((Widget) this).dataCenter) != true) goto L18;
        View r1 = ((Widget) this).contentView;
        if (r1 == null) goto L17;
        if (r3 != null) goto L11;
    L13:
        int r4 = 0;
    L14:
        r1.setVisibility(r4);
        return;
    L11:
        if (r3.a != true) goto L13;
        r4 = 8;
        goto L14
    L17:
        return;
    }

    public final p22.a xq(BarrageSetting r4) {
        return new p22.a(r4.getBarrageArea(), r4.getFontSize(), r4.getAlpha());
    }

    public final p22.c yq(BarrageSetting r4) {
        return new p22.c(r4.getBarrageArea(), r4.getFontSize(), r4.getAlpha());
    }

    public final p22.g zq(BarrageSetting r5) {
        return new p22.g(r5.getBarrageArea(), r5.getFontSize(), r5.getAlpha(), r5.isGiftOpen());
    }

    public final void Iq(int r8, boolean r9) {
        com.bytedance.android.livesdk.interactivity.api.settings.config.g r0 = (com.bytedance.android.livesdk.interactivity.api.settings.config.g) e0.a.getValue();
        IRoom r1 = getRoom();
        boolean r2 = true;
        if (r1 != null) goto L5;
    L6:
        IRoom r3 = getRoom();
        if (r3 != null) goto L9;
    L10:
        IRoom r4 = getRoom();
        if (r4 != null) goto L13;
        return;
    L13:
        if (r4.isGameRoom() == 1) goto L15;
        return;
    L15:
        if (r0.b() == true) goto L17;
        return;
    L17:
        if (r0.a() <= 0) goto L39;
        if (r8 <= 0) goto L41;
        Disposable r5 = this.q;
        if (r5 == null) goto L23;
        r5.dispose();
    L23:
        if (r9 == false) goto L26;
        Fq(r8);
        return;
    L26:
        int r10 = Jq().getHeight();
        ALogger.d("dirtyRegionOpt", "landscape danmuku height from:" + r10 + ",to:" + r8);
        if (r10 > r8) goto L30;
        r2 = false;
    L30:
        if (r2 == false) goto L32;
        this.q = Observable.timer(r0.a(), TimeUnit.MILLISECONDS).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, r8));
        return;
    L32:
        Fq(r8);
        return;
    L41:
        return;
    L39:
        return;
    L9:
        if (r3.isMergeVSRoom() != true) goto L10;
        return;
    L5:
        if (r1.isVsRoom() != true) goto L6;
    }

    public final <T> void L7(Class<T> r2, Consumer<T> r3) {
        ((ObservableSubscribeProxy) xs2.b.a().b(r2).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(this))).subscribe(r3);
    }

    @Override // com.bytedance.android.livesdk.interactivity.zdanmaku.widget.LandscapeDanmakuPresenterV2.IView
    public final void X(Object r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "danmakuData");
        com.bytedance.live.zdanmaku.e<com.bytedance.android.livesdk.interactivity.zdanmaku.i> r0 = this.j;
        if (r0 == null) goto L6;
        r0.a(r2, r3);
        return;
    }
}
