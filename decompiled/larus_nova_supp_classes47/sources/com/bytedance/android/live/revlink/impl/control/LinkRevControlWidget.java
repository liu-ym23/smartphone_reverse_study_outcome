package com.bytedance.android.live.revlink.impl.control;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.jsbridge.newmethods.a9;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.LiveTracingMonitorKt;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.core.setting.m1;
import com.bytedance.android.live.core.setting.o1;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.rxutils.autodispose.AutoDispose;
import com.bytedance.android.live.core.utils.rxutils.autodispose.SingleSubscribeProxy;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.profile.monitor.DataType;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.live.revenue.common.player.vendor.link.RevSeiFrame;
import com.bytedance.android.live.revenue.common.x0;
import com.bytedance.android.live.revenue.model.extension.IRoomLinkExt;
import com.bytedance.android.live.revenue.platform.hybrid.impl.ui.HybridDialogImpl;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.live.revlink.impl.BaseLinkRevControlWidget;
import com.bytedance.android.live.revlink.impl.LinkCrossRoomDataHolder;
import com.bytedance.android.live.revlink.impl.RevLinkService;
import com.bytedance.android.live.revlink.impl.audience.EnterRoomFirstSeiChecker;
import com.bytedance.android.live.revlink.impl.audience.EnterRoomLinkInfoChecker;
import com.bytedance.android.live.revlink.impl.audience.LinkCheckLoadUtils;
import com.bytedance.android.live.revlink.impl.behavior.ToolbarPkBehavior;
import com.bytedance.android.live.revlink.impl.behavior.x;
import com.bytedance.android.live.revlink.impl.control.dialog.LinkRevPanelDataContext;
import com.bytedance.android.live.revlink.impl.control.dialog.RevInteractDialogFragmentBaseContract$View;
import com.bytedance.android.live.revlink.impl.control.dialog.RevLinkDialog;
import com.bytedance.android.live.revlink.impl.control.launchcontext.RevLinkSwitchExtraContext;
import com.bytedance.android.live.revlink.impl.dynamiclayout.RevenueDynamicLayout;
import com.bytedance.android.live.revlink.impl.jsb.BattleChorusMethod;
import com.bytedance.android.live.revlink.impl.jsb.BattlePanelActionMethod;
import com.bytedance.android.live.revlink.impl.jsb.a0;
import com.bytedance.android.live.revlink.impl.jsb.b0;
import com.bytedance.android.live.revlink.impl.jsb.c0;
import com.bytedance.android.live.revlink.impl.jsb.d0;
import com.bytedance.android.live.revlink.impl.jsb.e0;
import com.bytedance.android.live.revlink.impl.jsb.g0;
import com.bytedance.android.live.revlink.impl.jsb.i0;
import com.bytedance.android.live.revlink.impl.mergepk.pkbase.statemachine.PkBaseStateMachine;
import com.bytedance.android.live.revlink.impl.monitor.LiveFullLinkPKMonitor;
import com.bytedance.android.live.revlink.impl.monitor.RevLinkStallReporter;
import com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment.AnchorInteractContainerFragment;
import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchContext;
import com.bytedance.android.live.revlink.impl.multianchor.match.MultiPkMatchWidget;
import com.bytedance.android.live.revlink.impl.multianchor.pk.pklaunch.MultiAnchorPkLaunchControlWidget;
import com.bytedance.android.live.revlink.impl.multianchor.precisefind.MultiPkPreciseFindWidget;
import com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataContext;
import com.bytedance.android.live.revlink.impl.multianchor.profit.ProfitInteractionDataWidget;
import com.bytedance.android.live.revlink.impl.multianchor.utils.MultiEnterRoomTracer;
import com.bytedance.android.live.revlink.impl.multianchor.utils.y;
import com.bytedance.android.live.revlink.impl.multianchor.widget.MultiLinkAnchorControlService;
import com.bytedance.android.live.revlink.impl.multianchor.widget.RevLinkAnchorWidget;
import com.bytedance.android.live.revlink.impl.multianchor.widget.RevLinkAudienceWidget;
import com.bytedance.android.live.revlink.impl.multianchor.widget.dialogmananger.DialogLaunchService;
import com.bytedance.android.live.revlink.impl.perf.LinkRtcDegradeTask;
import com.bytedance.android.live.revlink.impl.pk.dialog.PkCancelMatchDialog;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.AnchorInteractSettingFragment;
import com.bytedance.android.live.revlink.impl.pk.dialog.fragment.InteractPkRecordFragmentNew;
import com.bytedance.android.live.revlink.impl.pk.scope.service.PkScopeProviderService;
import com.bytedance.android.live.revlink.impl.pk.service.IPKLinkBizDataService;
import com.bytedance.android.live.revlink.impl.pk.utils.AutoMatchSource;
import com.bytedance.android.live.revlink.impl.pk.vm.linkout.PkAutoMatchManager;
import com.bytedance.android.live.revlink.impl.plantform.AnchorLinkUserCenterV2;
import com.bytedance.android.live.revlink.impl.plantform.RevLinkMultiChannelDataContext;
import com.bytedance.android.live.revlink.impl.preload.RevLinkAnchorPreloadWidget;
import com.bytedance.android.live.revlink.impl.region.RevLinkWindowRegionContext;
import com.bytedance.android.live.revlink.impl.rtc.AnchorRtcLinkerWidget;
import com.bytedance.android.live.revlink.impl.service.internal.LinkRevInternalServiceContext;
import com.bytedance.android.live.revlink.link.infra.lifecontrol.context.RevLinkBizContext;
import com.bytedance.android.live.revlink.link.infra.rtcbiz.RTCBizManagerService;
import com.bytedance.android.live.revlink.widgetservice.RevLinkAnchorLaunchParam;
import com.bytedance.android.live.revlink.widgetservice.RevLinkAudienceFacade;
import com.bytedance.android.live.revlink.widgetservice.RevLinkAudienceLaunchParam;
import com.bytedance.android.live.schema.api.WebcastRedirectException;
import com.bytedance.android.livesdk.a5;
import com.bytedance.android.livesdk.link.model.ILinkMicBattleSetting;
import com.bytedance.android.livesdk.link.model.api.IBaseBattleSetting;
import com.bytedance.android.livesdk.link.model.c8;
import com.bytedance.android.livesdk.link.model.e4;
import com.bytedance.android.livesdk.link.model.f1;
import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.android.livesdk.padutils.PadConfigUtils;
import com.bytedance.android.livesdk.revenue.log.LogCommon;
import com.bytedance.android.livesdk.revenue.service.broadcast.IRevBroadcastService;
import com.bytedance.android.livesdk.revenue.toolbar.RevToolbarButton;
import com.bytedance.android.livesdkapi.depend.model.live.ILinkerDetailKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomBase;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKtKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomKt_androidKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomSpecificSceneTypeInfo;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.live.ILiveExternalCameraServiceForOther;
import com.bytedance.android.livesdkapi.liveprocast.ILiveProDualDeviceServiceForOther;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.live.core.setting.LiveFragmentLeakConfig;
import com.bytedance.android.livesdkapi.service.IPerformanceManager;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.ies.sdk.widgets.WidgetManager;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.Gson;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.UninitializedPropertyAccessException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u001a\u0012\b\u0012\u00060\u0003j\u0002`\u00040\u0002j\f\u0012\b\u0012\u00060\u0003j\u0002`\u0004`\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n:\u0001\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/live/revlink/impl/control/LinkRevControlWidget;", "Lcom/bytedance/android/live/revlink/impl/BaseLinkRevControlWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Lcom/bytedance/android/kvData/KVData;", "Lcom/bytedance/revenue/platform/api/core/android/lifecycle/Observer;", "Lcom/bytedance/android/live/revlink/impl/behavior/ToolbarPkBehavior$b;", "Lcom/bytedance/android/live/revlink/impl/service/internal/a;", "Lcom/bytedance/android/live/revlink/impl/control/e$b;", "Lcom/bytedance/android/live/revlink/impl/utils/j;", "Lu51/a;", "a", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LinkRevControlWidget extends BaseLinkRevControlWidget implements Observer<KVData>, ToolbarPkBehavior.b, com.bytedance.android.live.revlink.impl.service.internal.a, com.bytedance.android.live.revlink.impl.control.e.b, com.bytedance.android.live.revlink.impl.utils.j, u51.a {
    public static final a O = null;
    public h A;
    public IRoom B;
    public LiveMode C;
    public boolean D;
    public boolean E;
    public final CompositeDisposable F;
    public long G;
    public boolean H;
    public final String I;
    public u51.d J;
    public u51.e K;
    public com.bytedance.android.live.revlink.impl.b L;
    public final ViewGroup M;
    public final boolean N;
    public AnchorLinkUserCenterV2 a;
    public final EnterRoomLinkInfoChecker b;
    public RevLinkAnchorPreloadWidget c;
    public MultiLinkAnchorControlService d;
    public RevLinkLiveFeedViewModel e;
    public RevLinkAnchorWidget f;
    public RevLinkAudienceWidget g;
    public PkCancelMatchDialog h;
    public final ToolbarPkBehavior i;
    public int j;
    public com.bytedance.android.live.revlink.impl.control.e k;
    public View l;
    public LinkCheckLoadUtils m;
    public MultiAnchorPkLaunchControlWidget n;
    public String o;
    public final com.bytedance.android.live.revlink.impl.utils.i p;
    public RevLinkDialog q;
    public zy0.d r;
    public t s;
    public LinkOtherAnchorListener t;
    public w u;
    public final EnterRoomFirstSeiChecker v;
    public boolean w;
    public RevLinkStallReporter x;
    public final kc0.e y;
    public final com.bytedance.android.live.revlink.impl.control.p z;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static void a(String r3, boolean r4) {
            int r0 = com.bytedance.android.live.revlink.impl.pk.utils.e.a;
            HashMap r1 = new HashMap();
            r1.put("mode", r3);
            String r2 = DataType.FALSE;
            r1.put("stream_mix_on_client", DataType.FALSE);
            if (r4 == false) goto L5;
        L8:
            String r5 = DataType.TRUE;
        L9:
            r1.put("is_in", r5);
            if (TextUtils.equals(r3, "multi_linker") == false) goto L22;
            com.bytedance.android.live.revlink.impl.multianchor.service.d r6 = com.bytedance.android.live.revlink.impl.global.b.z();
            if (r6 == null) goto L21;
            i11.b r7 = r6.getLinkUserCenter();
            if (r7 == null) goto L21;
            List<com.bytedance.android.livesdk.link.model.p> r8 = r7.getOnlineUserList();
            if (r8 == null) goto L21;
            String r9 = String.valueOf(r8.size());
            if (r9 == null) goto L21;
            r2 = r9;
        L21:
            r1.put("linkers_count", r2);
        L22:
            Unit r10 = Unit.INSTANCE;
            Intrinsics.checkNotNullParameter(r1, "extra");
            IPerformanceManager r12 = jc1.k.f(IPerformanceManager.class);
            if (r12 == null) goto L26;
            r12.monitorPerformance("link_mic");
            HashMap r13 = com.bytedance.android.live.revlink.impl.pk.utils.e.a();
            r13.putAll(r1);
            r12.onModuleStart("link_mic", r13);
            return;
        L26:
            return;
        L5:
            if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).Sl() == true) goto L8;
            r5 = DataType.FALSE;
            goto L9
        }
    }

    public static final class b implements wy0.f {
        public final /* synthetic */ LinkRevControlWidget a;

        public static final class a implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final a a = null;

            static {
                a = new a();
            }

            public a() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.revlink.impl.jsb.g(com.bytedance.android.live.revlink.impl.global.b.k(), null);
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.live.revlink.impl.control.LinkRevControlWidget$b$b, reason: collision with other inner class name */
        public static final class C0122b implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final C0122b a = null;

            static {
                a = new C0122b();
            }

            public C0122b() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new d0(com.bytedance.android.live.revlink.impl.global.b.k());
            }
        }

        public static final class c implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final c a = null;

            static {
                a = new c();
            }

            public c() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new a0((dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class), com.bytedance.android.live.revlink.impl.global.b.k());
            }
        }

        public static final class d implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final d a = null;

            static {
                a = new d();
            }

            public d() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                com.bytedance.android.live.revlink.impl.global.c r1 = com.bytedance.android.live.revlink.impl.global.b.k();
                if (r1 == null) goto L5;
                com.bytedance.android.live.revlink.impl.lynxcontainer.a r2 = r1.w2();
            L7:
                return new com.bytedance.android.live.revlink.impl.jsb.s(r2);
            L5:
                r2 = null;
                goto L7
            }
        }

        public static final class e implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final e a = null;

            static {
                a = new e();
            }

            public e() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.revlink.impl.jsb.f(com.bytedance.android.live.revlink.impl.global.b.k());
            }
        }

        public static final class f implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final f a = null;

            static {
                a = new f();
            }

            public f() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.revlink.impl.jsb.k(com.bytedance.android.live.revlink.impl.global.b.k(), null);
            }
        }

        public static final class g implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final g a = null;

            static {
                a = new g();
            }

            public g() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new b0(com.bytedance.android.live.revlink.impl.global.b.k(), null);
            }
        }

        public static final class h implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final h a = null;

            static {
                a = new h();
            }

            public h() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.revlink.impl.jsb.l(com.bytedance.android.live.revlink.impl.global.b.k(), null, null, 6);
            }
        }

        public static final class i implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final i a = null;

            static {
                a = new i();
            }

            public i() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.revlink.impl.jsb.p(com.bytedance.android.live.revlink.impl.global.b.k(), null);
            }
        }

        public static final class j implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final j a = null;

            static {
                a = new j();
            }

            public j() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new c0(com.bytedance.android.live.revlink.impl.global.b.k());
            }
        }

        public static final class k implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final k a = null;

            static {
                a = new k();
            }

            public k() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.revlink.impl.jsb.n(com.bytedance.android.live.revlink.impl.global.b.k());
            }
        }

        public static final class l implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final l a = null;

            static {
                a = new l();
            }

            public l() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.revlink.impl.jsb.b(com.bytedance.android.live.revlink.impl.global.b.k());
            }
        }

        public static final class m implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final m a = null;

            static {
                a = new m();
            }

            public m() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new BattlePanelActionMethod(com.bytedance.android.live.revlink.impl.global.b.k());
            }
        }

        public static final class n implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final n a = null;

            static {
                a = new n();
            }

            public n() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new BattleChorusMethod(com.bytedance.android.live.revlink.impl.global.b.i());
            }
        }

        public static final class o implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final o a = null;

            static {
                a = new o();
            }

            public o() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.revlink.impl.jsb.j(com.bytedance.android.live.revlink.impl.global.b.k(), null);
            }
        }

        public static final class p implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final p a = null;

            static {
                a = new p();
            }

            public p() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.revlink.impl.jsb.q((dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class), com.bytedance.android.live.revlink.impl.global.b.k());
            }
        }

        public static final class q implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final q a = null;

            static {
                a = new q();
            }

            public q() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.revlink.impl.jsb.z();
            }
        }

        public static final class r implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final r a = null;

            static {
                a = new r();
            }

            public r() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.revlink.impl.jsb.x();
            }
        }

        public static final class s implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final s a = null;

            static {
                a = new s();
            }

            public s() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.revlink.impl.jsb.m(com.bytedance.android.live.revlink.impl.global.b.k());
            }
        }

        public static final class t implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final t a = null;

            static {
                a = new t();
            }

            public t() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new e0(com.bytedance.android.live.revlink.impl.global.b.k());
            }
        }

        public static final class u implements com.bytedance.ies.web.jsbridge2.f.b {
            public final /* synthetic */ b a;

            public u(b r1) {
                this.a = r1;
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.revlink.impl.jsb.t(this.a.a.B, (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class));
            }
        }

        public static final class v implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final v a = null;

            static {
                a = new v();
            }

            public v() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.revlink.impl.jsb.r(com.bytedance.android.live.revlink.impl.global.b.k(), ld.d.a(), ma1.a.a());
            }
        }

        public static final class w implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final w a = null;

            static {
                a = new w();
            }

            public w() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.revlink.impl.jsb.h();
            }
        }

        public static final class x implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final x a = null;

            static {
                a = new x();
            }

            public x() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new com.bytedance.android.live.revlink.impl.jsb.i(com.bytedance.android.live.revlink.impl.global.b.k(), null);
            }
        }

        public static final class y implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final y a = null;

            static {
                a = new y();
            }

            public y() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                com.bytedance.android.live.revenue.core.util.j.a r1 = com.bytedance.android.live.revenue.core.util.j.C0;
                return new i0((dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r1.a(), com.bytedance.android.livesdk.revenue.service.room.c.class), (yz0.g) com.bytedance.android.live.revenue.core.util.f.d(r1.a(), yz0.g.class), com.bytedance.android.live.revlink.impl.global.b.k());
            }
        }

        public static final class z implements com.bytedance.ies.web.jsbridge2.f.b {
            public static final z a = null;

            static {
                a = new z();
            }

            public z() {
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new g0(com.bytedance.android.live.revlink.impl.global.b.k());
            }
        }

        public b(LinkRevControlWidget r1) {
            this.a = r1;
        }

        @Override // wy0.f
        public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> a(y6.c r3) {
            Intrinsics.checkNotNullParameter(r3, "manager");
            HashMap r4 = new HashMap();
            r4.put("invitePK", k.a);
            r4.put("hidePKPanel", s.a);
            r4.put("setTeamTaskRunning", t.a);
            r4.put("openAnchorLinkPanel", new u(this));
            r4.put("notifyPKEvent", v.a);
            r4.put("getLiveServiceTime", w.a);
            r4.put("revenue.getRevenueInteractData", x.a);
            r4.put("trackPKEvent", y.a);
            r4.put("startAutoMatch", z.a);
            r4.put("getAnchorPkInfo", a.a);
            r4.put("revenue.setRtcEffectEnable", C0122b.a);
            r4.put("revenue.sendStreamXEvent", c.a);
            r4.put("observeRevenueInteractData", d.a);
            r4.put("getAnchorLinkInfo", e.a);
            r4.put("handlePkLynxView", f.a);
            r4.put("sendDataToTargetLynx", g.a);
            r4.put("handlePkNativeView", h.a);
            r4.put("modifyAnchorTopOffset", i.a);
            r4.put("sendMultiAnchorEvent", j.a);
            r4.put("battleLaunch", l.a);
            r4.put("battlePanelAction", m.a);
            r4.put("battleChorus", n.a);
            r4.put("handleBattleBgImage", o.a);
            r4.put("monitorPKEvent", p.a);
            r4.put("revenue.downloadEffectAssets", q.a);
            r4.put("revenue.currentPanelEffects", r.a);
            vh6.c.b(vr2.f.class).Oe(TypeIntrinsics.asMutableMap(r4));
            return r4;
        }

        @Override // wy0.d
        public final Map<String, wy0.h<Object, ?>> c(y6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            return wy0.f.a.a(r2);
        }

        @Override // wy0.f
        public final Map<String, com.bytedance.ies.web.jsbridge2.g<?, ?>> d(y6.c r3) {
            Intrinsics.checkNotNullParameter(r3, "manager");
            HashMap r4 = new HashMap();
            r4.put("getPKStatus", new com.bytedance.android.live.revlink.impl.jsb.w(com.bytedance.android.live.revlink.impl.global.b.k()));
            r4.put("getCurrentPKInfo", new com.bytedance.android.live.revlink.impl.jsb.v(com.bytedance.android.live.revlink.impl.global.b.k()));
            r4.put("openPKPanel", new a9());
            return r4;
        }

        @Override // wy0.d
        public final Map<String, com.bytedance.ies.web.jsbridge2.g<Object, ?>> f(y6.c r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            return wy0.f.a.b(r2);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ LinkRevControlWidget a;

        public c(LinkRevControlWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Integer r3 = (Integer) sh6.c.b((sh6.b) r2);
            if (r3 != null) goto L6;
        L8:
            this.a.i.y(1.0f);
            return;
        L6:
            if (r3.intValue() != 1) goto L8;
            this.a.i.y(0.5f);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ LinkRevControlWidget a;

        public d(LinkRevControlWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            gt1.b r4 = (gt1.b) sh6.c.b((sh6.b) r3);
            if (r4 == null) goto L14;
            LinkRevControlWidget r0 = this.a;
            if (r0.E == true) goto L8;
            return;
        L8:
            if (r4.c() == 2) goto L10;
            return;
        L10:
            if (r0.M == null) goto L17;
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).s4();
            return;
        L17:
            return;
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ LinkRevControlWidget a;

        public e(LinkRevControlWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r5) {
            sh6.b r6 = (sh6.b) r5;
            com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
            if (r0 == null) goto L5;
            int r1 = r0.getCurrentMode();
        L7:
            if (gd0.v.a(r1, 4) == true) goto L9;
            return;
        L9:
            if (Intrinsics.areEqual((Boolean) sh6.c.b(r6), Boolean.TRUE) == false) goto L11;
            LinkRevControlWidget r7 = this.a;
            a r2 = LinkRevControlWidget.O;
            r7.Cq(null);
            return;
        L11:
            LinkRevControlWidget r8 = this.a;
            m41.b.d r3 = new m41.b.d();
            a r4 = LinkRevControlWidget.O;
            r8.getClass();
            w31.c r9 = com.bytedance.android.live.revlink.impl.global.b.T();
            if (r9 == null) goto L16;
            com.bytedance.android.live.revlink.impl.pk.service.d r10 = r9.h();
            if (r10 == null) goto L16;
            r10.setUnLoadSource(r3);
        L16:
            com.bytedance.android.live.revlink.impl.service.internal.b.a.a(this.a, 4, false, 4);
            return;
        L5:
            r1 = 0;
            goto L7
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ LinkRevControlWidget a;

        public f(LinkRevControlWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r8) {
            gt1.d r9 = (gt1.d) sh6.c.b((sh6.b) r8);
            if (r9 == null) goto L118;
            LinkRevControlWidget r0 = this.a;
            a r1 = LinkRevControlWidget.O;
            r0.getClass();
            int r2 = r9.f;
            Object r3 = null;
            if (r2 != 5) goto L11;
            ToolbarPkBehavior r10 = r0.i;
            r10.getClass();
            com.bytedance.tools.kcp.spongepreference.runtime.a r4 = l51.a.f;
            KProperty[] r5 = l51.a.a;
            if (((Boolean) r4.getValue(null, r5[5])).booleanValue() == true) goto L9;
            return;
        L9:
            if (r10.e == false) goto L120;
            r4.setValue(null, r5[5], Boolean.FALSE);
            r10.J2(s1.B(2131919355));
            ((SingleSubscribeProxy) Single.timer(5, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).as(AutoDispose.bind(r10.z))).subscribe(new x(r10));
            return;
        L120:
            return;
        L11:
            boolean r6 = true;
            if (r2 != 1) goto L68;
            r0.i.f3();
            if (r0.E == true) goto L16;
        L51:
            IRoom r12 = r0.B;
            if (r12 != null) goto L54;
            return;
        L54:
            if (r12.getStreamType() != LiveMode.AUDIO) goto L123;
            HashMap r13 = new HashMap();
            xp2.j r7 = vh6.c.b(IRevBroadcastService.class).b2(((Widget) r0).dataCenter);
            if (r7 == null) goto L58;
            xp2.i r14 = r7.a();
        L59:
            if (r14 == null) goto L124;
            xp2.j r15 = vh6.c.b(IRevBroadcastService.class).b2(((Widget) r0).dataCenter);
            if (r15 == null) goto L65;
            xp2.i r16 = r15.a();
            if (r16 == null) goto L65;
            r3 = String.valueOf(r16.a());
        L65:
            if (r3 != null) goto L67;
            r3 = "";
        L67:
            r13.put("theme_id", r3);
            jc1.k.n(IPerformanceManager.class).onModuleStart("audio_animated_bg", r13);
            return;
        L124:
            return;
        L58:
            r14 = null;
            goto L59
        L123:
            return;
        L16:
            if (r0.M == null) goto L131;
            View r17 = r0.l;
            if (r17 == null) goto L50;
            ViewParent r18 = r17.getParent();
            ViewGroup r19 = r0.M;
            if (r18 != r19) goto L50;
            if (r19 == null) goto L24;
            r19.removeView(r0.l);
        L24:
            r0.l = null;
            com.bytedance.android.live.revenue.core.util.j.a r20 = com.bytedance.android.live.revenue.core.util.j.C0;
            com.bytedance.android.livesdk.revenue.service.room.c r22 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r20.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
            if (r22 == null) goto L31;
            com.bytedance.android.livesdk.revenue.room.a r23 = r22.getRoomContext();
            if (r23 == null) goto L31;
            com.bytedance.live.datacontext.j r24 = r23.getLiveStream();
            if (r24 == null) goto L31;
            com.bytedance.android.livesdk.revenue.pushstream.a r25 = (com.bytedance.android.livesdk.revenue.pushstream.a) r24.getValue();
        L32:
            if (r25 == null) goto L34;
            r25.x0();
        L34:
            yz0.k r26 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r20.a(), yz0.k.class);
            if (r26 == null) goto L37;
            IRoom r27 = r26.getRoom();
        L38:
            if (r27 == null) goto L44;
            IRoomSpecificSceneTypeInfo r28 = r27.getSceneTypeInfo();
            if (r28 == null) goto L44;
            if (r28.isLandscapeVerticalRoom() != 1) goto L44;
        L45:
            if (r6 == false) goto L47;
            vh6.c.b(IRevBroadcastService.class).Ng();
        L47:
            r0.i.reset();
            d51.b r29 = d51.b.m;
            r29.getClass();
            if (((Boolean) d51.b.d.getValue(r29, d51.b.a[2])).booleanValue() == false) goto L50;
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).I1(4, false);
        L44:
            r6 = false;
            goto L45
        L37:
            r27 = null;
        L31:
            r25 = null;
        L50:
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).s4();
            goto L51
        L131:
            return;
        L68:
            if (r2 != 0) goto L82;
            View r30 = r0.l;
            if (r30 == null) goto L76;
            ViewParent r32 = r30.getParent();
            ViewGroup r33 = r0.M;
            if (r32 != r33) goto L76;
            if (r33 == null) goto L75;
            r33.removeView(r0.l);
        L75:
            r0.l = null;
        L76:
            IRoom r34 = r0.B;
            if (r34 != null) goto L79;
            return;
        L79:
            if (r34.getStreamType() != LiveMode.AUDIO) goto L127;
            jc1.k.n(IPerformanceManager.class).onModuleStop("audio_animated_bg");
            return;
        L127:
            return;
        L82:
            if (r2 == 3) goto L84;
            return;
        L84:
            if (r0.E == false) goto L130;
            Object r35 = r9.a;
            if ((r35 instanceof ViewGroup) == true) goto L88;
        L116:
            vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).s4();
            return;
        L88:
            if ((r35 instanceof View) == true) goto L90;
            Object r36 = null;
        L91:
            r0.l = (View) r36;
            if (r35 == null) goto L115;
            View r37 = (View) r35;
            if (com.bytedance.android.live.revlink.impl.global.b.U() == null) goto L111;
            com.bytedance.android.live.revlink.impl.pk.service.h r38 = com.bytedance.android.live.revlink.impl.global.b.U();
            if (r38 == null) goto L98;
            oq2.d r39 = r38.getPkLayoutData(true);
        L99:
            if (r39 == null) goto L111;
            FrameLayout.LayoutParams r40 = new FrameLayout.LayoutParams(r39.b, r39.c);
            r40.topMargin = r39.a;
            r40.leftMargin = r39.b;
            r37.setLayoutParams(r40);
            ViewGroup r42 = r0.M;
            if (r42 == null) goto L103;
            r42.addView(r37, 0);
        L103:
            ld.a r43 = ld.d.a();
            if (r43 == null) goto L109;
            NextLiveData r44 = r43.Fc();
            if (r44 == null) goto L109;
            r3 = (Boolean) r44.getValue();
        L109:
            if (Intrinsics.areEqual(r3, Boolean.TRUE) == false) goto L111;
            wq2.e.a().c(Integer.valueOf(r39.c));
            goto L111
        L98:
            r39 = null;
        L111:
            View r45 = r0.l;
            if (r45 == null) goto L116;
            r45.post(new com.bytedance.android.live.revlink.impl.control.o(r0));
            goto L116
        L115:
            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
        L90:
            r36 = r35;
            goto L91
        L130:
            return;
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ LinkRevControlWidget a;

        public g(LinkRevControlWidget r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            Integer r3 = (Integer) sh6.c.b((sh6.b) r2);
            if (r3 == null) goto L5;
            int r4 = r3.intValue();
        L6:
            this.a.i.W2(r4);
            return;
        L5:
            r4 = 0;
            goto L6
        }
    }

    public static final class h implements MessageQueue.IdleHandler {
        public final /* synthetic */ LinkRevControlWidget a;

        public h(LinkRevControlWidget r1) {
            this.a = r1;
        }

        @Override // android.os.MessageQueue.IdleHandler
        public final boolean queueIdle() {
            int r0 = com.bytedance.android.live.revlink.impl.utils.g.a;
            Context r1 = ((Widget) this.a).context;
            com.bytedance.android.live.revlink.impl.global.c r2 = com.bytedance.android.live.revlink.impl.global.b.k();
            if (r2 == null) goto L5;
            LiveFullLinkPKMonitor r3 = r2.getLiveFullLinkPKMonitor();
        L30:
            String r4 = com.bytedance.android.live.revlink.impl.utils.g.a(r1);     // Catch: Throwable -> L27
            boolean r5 = true;
            if ((!Intrinsics.areEqual(r4, "unknown")) == false) goto L29;
            Map r6 = (Map) com.bytedance.android.livesdk.sharedpref.b.e.getValue();     // Catch: Throwable -> L27
            if (r6 != null) goto L12;
        L15:
            if (r5 == true) goto L25;
            String r7 = (String) r6.get("module");     // Catch: Throwable -> L27
            if (r7 != null) goto L19;
            r7 = "pk";
        L19:
            if (r3 == null) goto L25;
            JSONObject r8 = new JSONObject();     // Catch: Throwable -> L27
            Iterator r9 = r6.entrySet().iterator();     // Catch: Throwable -> L27
        L22:
            if (r9.hasNext() == false) goto L24;
            Map.Entry r10 = (Map.Entry) r9.next();     // Catch: Throwable -> L27
            r8.put((String) r10.getKey(), r10.getValue());     // Catch: Throwable -> L27
            goto L22
        L24:
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L27
            r3.l(r4, r8, LiveTracingMonitorKt.EventModule.valueOf(r7));     // Catch: Throwable -> L27
        L25:
            com.bytedance.android.livesdk.sharedpref.e r13 = com.bytedance.android.livesdk.sharedpref.b.e;     // Catch: Throwable -> L27
            r13.getClass();     // Catch: Throwable -> L27
            com.bytedance.android.livesdk.sharedpref.f.d(r13, null);     // Catch: Throwable -> L27
            goto L29
        L12:
            if (r6.isEmpty() == true) goto L15;
            r5 = false;
        L29:
            return false;
        L27:
            th = move-exception;
            ALogger.e("LinkCrashUtils", th);
            goto L29
        L5:
            r3 = null;
            goto L30
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ LinkRevControlWidget a;

        public i(LinkRevControlWidget r1) {
            this.a = r1;
        }

        public final void accept(T r12) {
            LinkRevControlWidget r0 = this.a;
            if (r0.E == true) goto L5;
            int r13 = ToastUtil.a;
            int r14 = w11.a.a;
            ToastUtil.a(2131922204, 0);
            return;
        L5:
            DataCenter r1 = ((Widget) r0).dataCenter;
            int r3 = RevLinkDialog.x;
            RevLinkDialog r4 = new RevLinkDialog.a(r1, r0).a();
            r0.q = r4;
            if ((r12 instanceof b30.g) == false) goto L11;
            if (((b30.g) r12).a == false) goto L11;
            r0.Ne(7, null, false);
            return;
        L11:
            if ((r12 instanceof b30.q) == false) goto L13;
            int r2 = AnchorInteractContainerFragment.S;
            DataCenter r5 = ((Widget) r0).dataCenter;
            KProperty[] r6 = com.bytedance.android.live.revlink.impl.behavior.o.a;
            AnchorInteractContainerFragment r15 = AnchorInteractContainerFragment.Companion.b(r4, r5, 1, ((b30.q) r12).a, null, 48);
            Intrinsics.checkNotNullParameter("", "guideType");
            Intrinsics.checkNotNullParameter("", "toUserGroup");
            Intrinsics.checkNotNullParameter("activity", "source");
            r15.C = "";
            r15.D = "";
            r15.F = "activity";
        L14:
            if (r15 == null) goto L27;
            RevLinkDialog r7 = r0.q;
            if (r7 == null) goto L18;
            r7.f = r15;
        L18:
            r0.Kq(null);
            RevLinkDialog r16 = r0.q;
            if (r16 == null) goto L28;
            FragmentActivity r8 = ((Widget) r0).context;
            if (r8 == null) goto L24;
            LinkRevControlWidget.wq(r16, r8.getSupportFragmentManager());
            return;
        L24:
            throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        L28:
            return;
        L27:
            return;
        L13:
            r15 = null;
            goto L14
        }
    }

    public static final class j implements DialogInterface.OnDismissListener {
        public final /* synthetic */ LinkRevControlWidget a;
        public final /* synthetic */ DialogInterface.OnDismissListener b;

        public j(LinkRevControlWidget r1, q r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r2) {
            DialogInterface.OnDismissListener r0 = this.b;
            if (r0 == null) goto L5;
            r0.onDismiss(r2);
        L5:
            this.a.q = null;
        }
    }

    public static final class k implements o60.e {
        public final /* synthetic */ LinkRevControlWidget a;
        public final /* synthetic */ int b;
        public final /* synthetic */ s c;

        public final void onPermissionDenied(String... r4) {
            Intrinsics.checkNotNullParameter(r4, "permissions");
            jy0.b.c("PK_BLUETOOTH_CONNECT", "permission_denied", null, 4);
            LinkRevControlWidget r5 = this.a;
            int r0 = this.b;
            s r1 = this.c;
            a r2 = LinkRevControlWidget.O;
            r5.Lq(r0, r1);
        }

        public final void onPermissionGrant(String... r4) {
            Intrinsics.checkNotNullParameter(r4, "permissions");
            jy0.b.c("PK_BLUETOOTH_CONNECT", "permission_grant", null, 4);
            LinkRevControlWidget r5 = this.a;
            int r0 = this.b;
            s r1 = this.c;
            a r2 = LinkRevControlWidget.O;
            r5.Lq(r0, r1);
        }

        public k(LinkRevControlWidget r1, int r2, s r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class l implements Runnable {
        public static final l a = null;

        static {
            a = new l();
        }

        public l() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public static final class m implements Runnable {
        public static final m a = null;

        static {
            a = new m();
        }

        public m() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public static final class n implements DialogInterface.OnDismissListener {
        public final /* synthetic */ s a;

        public n(s r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            s r2 = this.a;
            if (r2 == null) goto L6;
            r2.onDismiss();
            return;
        }
    }

    public static final class o implements DialogInterface.OnDismissListener {
        public final /* synthetic */ s a;

        public o(s r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            s r2 = this.a;
            if (r2 == null) goto L6;
            r2.onDismiss();
            return;
        }
    }

    public static final class p implements DialogInterface.OnDismissListener {
        public final /* synthetic */ s a;

        public p(s r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            s r2 = this.a;
            if (r2 == null) goto L6;
            r2.onDismiss();
            return;
        }
    }

    public static final class q implements DialogInterface.OnDismissListener {
        public final /* synthetic */ s a;

        public q(s r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public final void onDismiss(DialogInterface r1) {
            s r2 = this.a;
            if (r2 == null) goto L6;
            r2.onDismiss();
            return;
        }
    }

    @Override // com.bytedance.android.live.revlink.impl.control.e.b
    public final void Ab() {
        com.bytedance.android.live.revlink.impl.service.internal.b.a.a(this, 4, false, 4);
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.b
    public final void Sa() {
        Ne(1, null, false);
    }

    public final boolean qa(Runnable r1, boolean r2) {
        return false;
    }

    @Override // com.bytedance.android.live.revlink.impl.BaseLinkRevControlWidget
    public final String tag() {
        return "LinkRevControlWidget";
    }

    public final void yq() {
        RevLinkDialog r1 = this.q;     // Catch: Throwable -> L28
        if (r1 != null) goto L7;
    L16:
        zy0.d r2 = this.r;     // Catch: Throwable -> L28
        if (r2 == null) goto L26;
        DialogFragment r3 = r2.p1();     // Catch: Throwable -> L28
        if (r3 == null) goto L26;
        r3.dismiss();     // Catch: Exception -> L22 Throwable -> L28
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L28
        Throwable r4 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L28
        if (r4 == null) goto L26;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L28
    L26:
        this.r = null;     // Catch: Throwable -> L28
        return;
    L7:
        if (r1.isVisible() != true) goto L16;
        RevLinkDialog r5 = this.q;     // Catch: Throwable -> L28
        if (r5 == null) goto L16;
        r5.dismiss();     // Catch: Exception -> L12 Throwable -> L28
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L28
        Throwable r6 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L28
        if (r6 == null) goto L16;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L28
    L28:
        jy0.b.c("LinkRevControlWidget", "dismissAnchorInteractDialog error", null, 4);
    }

    static {
        O = new a();
    }

    public final String Aq() {
        if (this.i.w == false) goto L6;
        return "game_link";
    L6:
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L12;
        NextLiveData r1 = r0.A4();
        if (r1 == null) goto L12;
        String r2 = (String) r1.getValue();
        if (r2 == null) goto L12;
        return r2;
    L12:
        return "";
    }

    public final void Fq() {
        if (this.n != null) goto L6;
        this.n = new MultiAnchorPkLaunchControlWidget();
        enableSubWidgetManager();
        ((Widget) this).subWidgetManager.load(this.n);
        return;
    }

    public final void Iq() {
        if (gd0.v.a(this.j, 4) == false) goto L5;
        return;
    L5:
        if (gd0.v.a(this.j, 64) == true) goto L46;
        MultiAnchorPkLaunchControlWidget r0 = this.n;
        if (r0 == null) goto L9;
        r0.Ob();
    L9:
        RevLinkAnchorPreloadWidget r1 = this.c;
        if (r1 == null) goto L47;
        d31.e r3 = com.bytedance.android.live.revlink.impl.global.b.d0();
        if (r3 == null) goto L15;
        d31.e.f(r3, 1, 2);
    L15:
        if (r1.e == true) goto L17;
        return;
    L17:
        if (r1.d != LiveMode.VIDEO) goto L50;
        i41.a r4 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r4 != null) goto L22;
    L24:
        com.bytedance.android.live.revlink.impl.service.internal.a r5 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r5 == null) goto L27;
        int r6 = r5.getCurrentMode();
    L29:
        if (gd0.v.a(r6, 4) == false) goto L31;
        return;
    L31:
        if (gd0.v.a(r6, 64) == true) goto L52;
        r1.xq("link_exit");
        LinkRevPanelDataContext.b r2 = LinkRevPanelDataContext.Companion;
        LinkRevPanelDataContext r7 = r2.getContext();
        if (r7 == null) goto L40;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.control.dialog.b> r8 = r7.getLoader();
        if (r8 == null) goto L40;
        com.bytedance.android.live.revlink.impl.control.dialog.b r9 = (com.bytedance.android.live.revlink.impl.control.dialog.b) r8.getValue();
        if (r9 == null) goto L40;
        r9.n("link_end");
    L40:
        LinkRevPanelDataContext r10 = r2.getContext();
        if (r10 == null) goto L43;
        r10.asyncInflate(((Widget) r1).context);
    L43:
        r1.wq();
        return;
    L52:
        return;
    L27:
        r6 = 0;
        goto L29
    L22:
        if (r4.f != true) goto L24;
        return;
    L50:
        return;
    L47:
        return;
    }

    @Override // u51.a
    public final long Ud() {
        MultiLinkAnchorControlService r0 = this.d;
        if (r0 == null) goto L7;
        com.bytedance.android.live.revlink.impl.multianchor.utils.u.a r1 = r0.D;
        if (r1 == null) goto L7;
        return r1.b;
    L7:
        return 0;
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.a
    public final boolean V() {
        if (this.l == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.a
    public final String ce() {
        String r1 = null;
        if (this.E == false) goto L16;
        RevLinkAnchorWidget r0 = this.f;
        if (r0 == null) goto L28;
        com.bytedance.android.live.revlink.widgetservice.a r2 = r0.b;
        if (r2 == null) goto L13;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r3 = r2.getContext();
        if (r3 == null) goto L13;
        NextLiveData<o51.e> r4 = r3.d.i;
        if (r4 == null) goto L13;
        o51.e r5 = (o51.e) r4.getValue();
    L14:
        if (r5 == null) goto L28;
    L15:
        r1 = r5.b;
    L13:
        r5 = null;
    L28:
        if (r1 != null) goto L31;
        return "";
    L31:
        return r1;
    L16:
        RevLinkAudienceWidget r6 = this.g;
        if (r6 == null) goto L28;
        RevLinkAudienceFacade r7 = r6.a;
        if (r7 == null) goto L25;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h r8 = r7.getContext();
        if (r8 == null) goto L25;
        NextLiveData<o51.e> r9 = r8.d.i;
        if (r9 == null) goto L25;
        r5 = (o51.e) r9.getValue();
    L26:
        if (r5 == null) goto L28;
    L25:
        r5 = null;
        goto L26
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.a
    public final int getMixStreamType() {
        if (gd0.v.a(this.j, 4) == false) goto L5;
    L7:
        com.bytedance.android.live.revenuelink.rtc.f r0 = com.bytedance.android.live.revlink.impl.global.b.d();
        if (r0 == null) goto L12;
        com.bytedance.android.live.revenuelink.rtc.i r1 = r0.getRtcManager();
        if (r1 == null) goto L12;
        Boolean r2 = Boolean.valueOf(r1.F());
    L14:
        if (this.E == false) goto L22;
        if (r2 == null) goto L22;
        if (Intrinsics.areEqual(r2, Boolean.TRUE) == false) goto L20;
        return 1;
    L20:
        return 2;
    L22:
        return 0;
    L12:
        r2 = null;
        goto L14
    L5:
        if (gd0.v.a(this.j, 64) == true) goto L7;
        return 0;
    }

    public final void onCreate() {
        jy0.b.d("InteractionFrameworkTracer", "LinkRevControlWidget onCreate");
        ld.d.a();
        com.bytedance.android.live.revenue.core.util.j.a r1 = com.bytedance.android.live.revenue.core.util.j.C0;
        x11.c.a = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r1.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        xq(com.bytedance.android.live.revlink.impl.global.b.i());
        o41.a r2 = (o41.a) com.bytedance.android.live.revenue.core.util.f.d(r1.a(), o41.a.class);
        if (r2 == null) goto L7;
        o11.b r3 = r2.a;
        if (r3 == null) goto L7;
        PkScopeProviderService r4 = (PkScopeProviderService) com.bytedance.android.scope.m.e.d(r3, PkScopeProviderService.class);
    L8:
        com.bytedance.android.live.revlink.impl.pk.utils.q r5 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r5 == null) goto L11;
        r5.a = r4;
    L11:
        com.bytedance.android.live.revlink.impl.global.b.k();
        if (com.bytedance.android.live.revlink.impl.global.b.S() == null) goto L14;
        i97.a r6 = i97.a.a;
        System.currentTimeMillis();
    L14:
        super.onCreate();
        z41.d r7 = z41.d.d;
        r7.getClass();
        z41.d.c = (a51.c) z41.d.b.getValue(r7, z41.d.a[0]);
        vh6.c.b(vr2.f.class).Vc();
        StringBuilder r8 = new StringBuilder("refresh ");
        a51.c r9 = z41.d.c;
        Intrinsics.checkNotNullParameter(r9, "$this$formatString");
        StringBuilder r10 = new StringBuilder("RevLinkJankOptConfig{");
        r10.append("seiOpt=" + r9.a9() + ',');
        r10.append("multiSeiOpt=" + r9.B6() + ',');
        r10.append("pkMvpListOpt=" + r9.e7() + ',');
        StringBuilder r12 = new StringBuilder("multiAnchorTitleOpt=");
        r12.append(r9.t5());
        r10.append(r12.toString());
        r10.append("}");
        r8.append(r10.toString());
        jy0.b.d("RevLinkJankOptUtils", r8.toString());
        this.F.add(((vy0.c) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).O3(new b(this)));
        yz0.k r13 = (yz0.k) com.bytedance.android.live.revenue.core.util.f.d(r1.a(), yz0.k.class);
        if (r13 == null) goto L17;
        IRoom r14 = r13.getRoom();
    L18:
        this.B = r14;
        com.bytedance.android.livesdk.revenue.service.room.c r15 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r1.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r15 == null) goto L23;
        com.bytedance.android.livesdk.revenue.room.a r16 = r15.getRoomContext();
        if (r16 == null) goto L23;
        boolean r17 = r16.getCommonIsAnchor();
    L24:
        this.E = r17;
        ld.a r18 = ld.d.a();
        if (r18 == null) goto L29;
        NextLiveData r19 = r18.getLiveMode();
        if (r19 == null) goto L29;
        LiveMode r20 = (LiveMode) r19.getValue();
    L30:
        this.C = r20;
        ld.a r22 = ld.d.a();
        if (r22 == null) goto L37;
        NextLiveData r23 = r22.isPortrait();
        if (r23 == null) goto L37;
        Boolean r24 = (Boolean) r23.getValue();
        if (r24 == null) goto L37;
        boolean r25 = r24.booleanValue();
    L38:
        this.D = r25;
        if (this.E == false) goto L41;
        Pair r26 = com.bytedance.live.datacontext.d.a(AnonymousClass3.INSTANCE);
        com.bytedance.live.datacontext.b.a((DataContext) r26.getFirst(), "anchor_log_params_context");
        RxUtilKt.c((Disposable) r26.getSecond(), this.F);
    L42:
        final yz0.f r27 = (yz0.f) com.bytedance.android.live.revenue.core.util.f.d(r1.a(), yz0.f.class);
        Pair r28 = com.bytedance.live.datacontext.d.a(new AnonymousClass5(r27));
        DataContext r29 = (DataContext) r28.getFirst();
        RevLinkMultiChannelDataContext.Companion.getClass();
        com.bytedance.live.datacontext.b.a(r29, RevLinkMultiChannelDataContext.access$getTAG$cp());
        RxUtilKt.c((Disposable) r28.getSecond(), this.F);
        Pair r30 = com.bytedance.live.datacontext.d.a(LinkRevControlWidget$onCreate$pair$1.INSTANCE);
        ((LinkRevInternalServiceContext) r30.getFirst()).getService().d(this);
        com.bytedance.live.datacontext.j<AnchorLinkUserCenterV2> r32 = ((LinkRevInternalServiceContext) r30.getFirst()).getLinkUserCenter();
        AnchorLinkUserCenterV2 r33 = new AnchorLinkUserCenterV2(ld.d.a(), (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r1.a(), com.bytedance.android.livesdk.revenue.service.room.c.class), com.bytedance.android.live.revlink.impl.global.b.k(), (yz0.f) com.bytedance.android.live.revenue.core.util.f.d(r1.a(), yz0.f.class));
        this.a = r33;
        Unit r34 = Unit.INSTANCE;
        r32.d(r33);
        AnchorLinkUserCenterV2 r35 = (AnchorLinkUserCenterV2) ((LinkRevInternalServiceContext) r30.getFirst()).getLinkUserCenter().getValue();
        if (r35 == null) goto L45;
        r35.z();
    L45:
        ((LinkRevInternalServiceContext) r30.getFirst()).onInit(this.u);
        ((LinkRevInternalServiceContext) r30.getFirst()).setEnterRoom(this.B);
        com.bytedance.live.datacontext.b.a((DataContext) r30.getFirst(), LinkRevInternalServiceContext.TAG);
        LinkRevInternalServiceContext r36 = (LinkRevInternalServiceContext) r30.getFirst();
        IRoom r37 = this.B;
        if (r37 == null) goto L48;
        Long r38 = Long.valueOf(r37.getId());
    L49:
        r36.sharedWithRoomId(r38);
        RxUtilKt.c((Disposable) r30.getSecond(), this.F);
        Pair r39 = com.bytedance.live.datacontext.d.a(new AnonymousClass8(this));
        DataContext r40 = (DataContext) r39.getFirst();
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.c.E0.getClass();
        com.bytedance.live.datacontext.b.a(r40, "IPkPanelService");
        RxUtilKt.c((Disposable) r39.getSecond(), this.F);
        Pair r42 = com.bytedance.live.datacontext.d.a(LinkRevControlWidget$onCreate$dataPair$1.INSTANCE);
        com.bytedance.live.datacontext.b.a((DataContext) r42.getFirst(), RevLinkWindowRegionContext.TAG);
        ((RevLinkWindowRegionContext) r42.getFirst()).getPartnerService().d(new v31.a(com.bytedance.android.live.revlink.impl.global.b.k()));
        this.F.add((Disposable) r42.getSecond());
        Pair r43 = com.bytedance.live.datacontext.d.a(new AnonymousClass10(r27));
        com.bytedance.live.datacontext.b.a((DataContext) r43.getFirst(), "anchor_audio_punish_context");
        RxUtilKt.c((Disposable) r43.getSecond(), this.F);
        RevLinkLiveFeedViewModel r44 = new RevLinkLiveFeedViewModel(ld.d.a(), com.bytedance.android.live.revlink.impl.global.b.k());
        r44.onRoomRead(this.B, (com.bytedance.android.live.revlink.impl.control.c) ((LinkRevInternalServiceContext) r30.getFirst()).getEnterRoomLinkInfo().getValue());
        this.e = r44;
        u41.b r45 = u41.b.i;
        if (r45.a() == false) goto L52;
        int r46 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getMultiInteractMode();
    L56:
        String r47 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getCurrentFunctionType();
        zr2.c r48 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(((Widget) this).dataCenter);
        if (this.D == false) goto L71;
        IRoom r110 = this.B;
        if (r110 == null) goto L61;
        LiveMode r111 = r110.getStreamType();
    L63:
        if (r111 == LiveMode.SCREEN_RECORD) goto L71;
        RevToolbarButton r112 = RevToolbarButton.PK;
        r48.e(r112, this.i);
        if (((Boolean) m1.a.getValue()).booleanValue() == false) goto L71;
        if (r46 != 32) goto L71;
        if ((!Intrinsics.areEqual(r47, "new_audience")) == false) goto L71;
        r48.d(r112);
        goto L71
    L61:
        r111 = null;
    L71:
        if (this.D == false) goto L81;
        IRoom r49 = this.B;
        if (r49 == null) goto L75;
        LiveMode r50 = r49.getStreamType();
    L77:
        if (r50 != LiveMode.SCREEN_RECORD) goto L81;
        if (((Boolean) a5.a.getValue()).booleanValue() == false) goto L81;
        r48.e(RevToolbarButton.PK, this.i);
        goto L81
    L75:
        r50 = null;
    L81:
        com.bytedance.android.live.revlink.impl.global.c r52 = com.bytedance.android.live.revlink.impl.global.b.k();
        IRoom r113 = this.B;
        boolean r53 = this.E;
        LiveMode r114 = this.C;
        com.bytedance.android.livesdk.revenue.service.room.c r115 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r1.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r115 == null) goto L84;
        com.bytedance.android.livesdk.revenue.room.a r116 = r115.getRoomContext();
    L85:
        ld.a r210 = ld.d.a();
        com.bytedance.android.live.revlink.impl.control.e r54 = new com.bytedance.android.live.revlink.impl.control.e(r52, r113, r53, r114, r116, r210, (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r1.a(), com.bytedance.android.livesdk.revenue.service.room.c.class));
        this.k = r54;
        Intrinsics.checkNotNullParameter(this, "wiget");
        Intrinsics.checkNotNullParameter(this, "widget");
        ((com.bytedance.android.livesdk.common.k) r54).a = this;
        if (r210 == null) goto L94;
        NextLiveData r117 = r210.Pc();
        if (r117 == null) goto L94;
        Observable r118 = ld.c.a(r117);
        if (r118 == null) goto L94;
        Disposable r119 = r118.subscribe(new com.bytedance.android.live.revlink.impl.control.f(r54));
        if (r119 == null) goto L94;
        com.bytedance.revenue.platform.api.core.rx.f.a(r119, r54.c);
    L94:
        IRoom r120 = r54.e;
        if (r120 != null) goto L97;
    L143:
        int r121 = 0;
    L144:
        StringBuilder r122 = new StringBuilder("LinkRevControlPresenter#attachView room id:");
        IRoomBase r123 = r54.e;
        if (r123 == null) goto L147;
        Long r124 = Long.valueOf(IRoomKtKt.getId(r123));
    L148:
        r122.append(r124);
        r122.append(" linkMap:");
        IRoom r125 = r54.e;
        if (r125 == null) goto L151;
        Map r126 = IRoomKt_androidKt.getLinkMapKt(r125);
    L152:
        r122.append(r126);
        r122.append(", playModes: ");
        vh7.c r127 = r54.e;
        if (r127 == null) goto L159;
        IRoomLinkExt r128 = (IRoomLinkExt) r127.castTo(IRoomLinkExt.class);
        if (r128 == null) goto L159;
        z5 r129 = IRoomKt_androidKt.getLinkerDetailKt(r128);
        if (r129 == null) goto L159;
        List r130 = ILinkerDetailKt.getPlayModesEx(r129);
    L160:
        r122.append(r130);
        r122.append(", mode: ");
        r122.append(r121);
        jy0.b.f("ttlive_revlink", r122.toString(), null, 4);
        if (r53 == false) goto L163;
    L164:
        IRoom r131 = r54.e;
        if (r131 == null) goto L169;
        IBaseUser r132 = r131.getOwnerKt();
        if (r132 == null) goto L169;
        Intrinsics.checkNotNullParameter(r132, "$this$secUidExt");
        String r133 = r132.getCastSecUid();
    L170:
        if (r52 == null) goto L172;
        r31.a r134 = r52.getLinkNetwork();
    L173:
        if (r134 == null) goto L183;
        IRoomBase r55 = r54.e;
        if (r55 == null) goto L177;
        long r56 = IRoomKtKt.getId(r55);
    L178:
        Observable<ExtraResponse<com.bytedance.android.livesdk.link.model.o, Extra>> r57 = r134.getAnchorLinkSetting(r56, r133);
        if (r57 == null) goto L183;
        Disposable r58 = r57.subscribe(com.bytedance.android.live.revlink.impl.control.g.a, com.bytedance.android.live.revlink.impl.control.h.a);
        if (r58 == null) goto L183;
        com.bytedance.revenue.platform.api.core.rx.f.a(r58, r54.c);
        goto L183
    L177:
        r56 = 0;
    L183:
        if (r53 == false) goto L185;
    L186:
        IRoom r59 = r54.e;
        if (r59 == null) goto L191;
        IBaseUser r60 = r59.getOwnerKt();
        if (r60 == null) goto L191;
        Intrinsics.checkNotNullParameter(r60, "$this$secUidExt");
        r60.getCastSecUid();
    L191:
        IRoom r62 = r54.e;
        if (r62 == null) goto L196;
        IBaseUser r63 = r62.getOwnerKt();
        if (r63 == null) goto L196;
        String r64 = r63.getIdString();
    L197:
        if (r52 == null) goto L199;
        r31.a r65 = r52.getLinkNetwork();
    L200:
        if (r65 == null) goto L210;
        IRoomBase r66 = r54.e;
        if (r66 == null) goto L204;
        long r67 = IRoomKtKt.getId(r66);
    L205:
        Observable r68 = r65.i(r67, r64, 0);
        if (r68 == null) goto L210;
        Disposable r69 = r68.subscribe(com.bytedance.android.live.revlink.impl.control.i.a, com.bytedance.android.live.revlink.impl.control.j.a);
        if (r69 == null) goto L210;
        com.bytedance.revenue.platform.api.core.rx.f.a(r69, r54.c);
        goto L210
    L204:
        r67 = 0;
    L210:
        IRoom r70 = this.B;
        if (r70 == null) goto L331;
        com.bytedance.android.live.revlink.impl.control.c r72 = (com.bytedance.android.live.revlink.impl.control.c) ((LinkRevInternalServiceContext) r30.getFirst()).getEnterRoomLinkInfo().getValue();
        this.m = new LinkCheckLoadUtils(com.bytedance.android.live.revlink.impl.global.b.k(), r70, r72, (yz0.f) com.bytedance.android.live.revenue.core.util.f.d(r1.a(), yz0.f.class));
        EnterRoomLinkInfoChecker r73 = this.b;
        r73.getClass();
        if (r72 == null) goto L215;
        IRoomLinkExt r74 = r72.b;
    L216:
        if (r72 == null) goto L219;
        Map<String, Long> r75 = r72.a;
        if (r75 == null) goto L219;
    L220:
        if (r74 != null) goto L222;
        jy0.b.c("ttlive_revlink", "linkRoom is null, linkMap=" + r75, null, 4);
    L260:
        EnterRoomFirstSeiChecker r76 = this.v;
        if (r72 != null) goto L264;
        r76.getClass();
    L263:
        Object r77 = null;
    L312:
        if (r72 == null) goto L314;
        Object r78 = r72.c;
    L315:
        if (r78 == null) goto L321;
        ld.a r79 = ld.d.a();
        if (r79 == null) goto L331;
        NextLiveData r80 = r79.getEnterRoomLinkmicScene();
        if (r80 == null) goto L331;
        r80.setValue(1);
        goto L331
    L321:
        if (r72 == null) goto L323;
        Object r82 = r72.d;
    L324:
        if (r82 == null) goto L331;
        ld.a r83 = ld.d.a();
        if (r83 == null) goto L331;
        NextLiveData r84 = r83.getEnterRoomLinkmicScene();
        if (r84 == null) goto L331;
        r84.setValue(7);
        goto L331
    L323:
        r82 = r77;
        goto L324
    L314:
        r78 = r77;
        goto L315
    L264:
        EnterRoomFirstSeiChecker.b r85 = r76.d();
        Intrinsics.checkNotNullParameter("app_data", "str");
        if (StringsKt.contains$default(r85.a, "app_data", false, 2, null) == false) goto L287;
        Intrinsics.checkNotNullParameter("\\\"ver\\\":2,", "str");
        if (StringsKt.contains$default(r85.a, "\\\"ver\\\":2,", false, 2, null) == true) goto L269;
    L279:
        Intrinsics.checkNotNullParameter("\\\"ver\\\":6", "str");
        if (StringsKt.contains$default(r85.a, "\\\"ver\\\":6", false, 2, null) == false) goto L263;
        if (r72.d != null) goto L263;
        if (r72.c == null) goto L286;
        r76.b(EnterRoomFirstSeiChecker.MismatchError.SeiMultiButRoomPk, r85);
        goto L263
    L286:
        r76.b(EnterRoomFirstSeiChecker.MismatchError.SeiMultiButRoomEmpty, r85);
        goto L263
    L269:
        if (r72.c != null) goto L279;
        if (r72.d == null) goto L273;
        r76.b(EnterRoomFirstSeiChecker.MismatchError.SeiPkButRoomMulti, r85);
        goto L263
    L273:
        Map<String, Long> r86 = r72.a;
        if (r86 != null) goto L276;
    L278:
        jy0.b.c("ttlive_revlink_sei", "pkInfo null but linkerMap pk " + r72, null, 4);
        r77 = null;
        goto L312
    L276:
        if (r86.containsKey(String.valueOf(1)) == true) goto L278;
        r76.b(EnterRoomFirstSeiChecker.MismatchError.SeiPkButRoomEmpty, r85);
        goto L263
    L287:
        u r87 = r72.c;
        if (r87 == null) goto L290;
    L293:
        boolean r88 = true;
    L294:
        if (r88 == false) goto L263;
        if (r87 == null) goto L304;
        if (r85.a.length() != 0) goto L299;
        boolean r89 = true;
    L300:
        if (r89 == false) goto L302;
        r76.c(r72);
        goto L263
    L302:
        r77 = null;
        jy0.b.f("ttlive_revlink_sei", "sei invalid but room pk " + r72 + ' ' + r85, null, 4);
        goto L312
    L299:
        r89 = false;
        goto L300
    L304:
        if (r72.d == null) goto L263;
        if (r85.a.length() != 0) goto L308;
        boolean r90 = true;
    L309:
        if (r90 == false) goto L311;
        r76.c(r72);
        goto L263
    L311:
        r77 = null;
        jy0.b.f("ttlive_revlink_sei", "sei invalid but room multi " + r72 + ' ' + r85, null, 4);
        goto L312
    L308:
        r90 = false;
        goto L309
    L290:
        if (r72.d != null) goto L293;
        r88 = false;
        goto L294
    L222:
        Long r92 = r75.get(String.valueOf(1));
        long r93 = -1;
        if (r92 == null) goto L225;
        long r135 = r92.longValue();
    L226:
        Long r94 = r75.get(String.valueOf(7));
        if (r94 == null) goto L230;
        r93 = r94.longValue();
    L230:
        if (r74.getLinkMicInfo() != null) goto L237;
        if (r135 >= 0) goto L237;
        if (r93 < 0) goto L260;
    L237:
        if (r135 <= 0) goto L256;
        if (r93 <= 0) goto L242;
        r73.a(EnterRoomLinkInfoChecker.Error.LINKER_MAP_CONTAINS_1_AND_7);
        goto L260
    L242:
        if (r72.c != null) goto L248;
        StringBuilder r95 = new StringBuilder("room.link_mic=");
        com.bytedance.android.livesdk.link.model.a9 r96 = r74.getLinkMicInfo();
        if (r96 == null) goto L246;
        String r97 = ef2.a.c(r96);
    L247:
        r95.append(r97);
        jy0.b.c("ttlive_revlink", r95.toString(), null, 4);
        r73.a(EnterRoomLinkInfoChecker.Error.LINKER_MAP_PK_BUT_LINK_MIC_NULL);
        goto L260
    L246:
        r97 = null;
        goto L247
    L248:
        z5 r98 = IRoomKt_androidKt.getLinkerDetailKt(r74);
        if (r98 == null) goto L260;
        List r99 = ILinkerDetailKt.getPlayModesEx(r98);
        if (r99 == null) goto L260;
        if (r99.contains(3L) != true) goto L260;
        r73.a(EnterRoomLinkInfoChecker.Error.LINKER_MAP_PK_BUT_PLAY_MODE_MULTI_PK);
        goto L260
    L256:
        if (r93 <= 0) goto L260;
        if (r72.c == null) goto L260;
        r73.a(EnterRoomLinkInfoChecker.Error.LINKER_MAP_MULTI_BUT_LINK_MIC_NONNULL);
        goto L260
    L225:
        r135 = -1;
    L219:
        r75 = MapsKt.emptyMap();
        goto L220
    L215:
        r74 = null;
    L331:
        lr2.a r100 = com.bytedance.android.live.revenue.core.util.f.d(r1.a(), lr2.a.class);
        if (r100 != null) goto L334;
    L336:
        p11.h r101 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r101 == null) goto L339;
        r101.m(this.z);
    L339:
        this.s = new t(this.E, this.B, ((Widget) this).dataCenter, this.i);
        this.t = new LinkOtherAnchorListener(this.B);
        enableSubWidgetManager();
        v41.b r102 = v41.b.f;
        r102.getClass();
        if (((Boolean) v41.b.c.getValue(r102, v41.b.a[1])).booleanValue() == false) goto L342;
        ((Widget) this).subWidgetManager.load(new ProfitInteractionDataWidget());
    L342:
        boolean r103 = k60.b.a();
        String r136 = "linkInternalDataSet";
        if (this.E == false) goto L400;
        ld.a r104 = ld.d.a();
        if (r104 != null) goto L347;
        Gq("linkInternalDataSet");
    L353:
        com.bytedance.android.live.revenue.core.util.j.a r211 = r1;
        u41.b r212 = r45;
    L426:
        u51.d r105 = this.J;
        if (this.E == false) goto L434;
        IRoom r106 = this.B;
        if (r106 == null) goto L431;
        com.bytedance.android.live.revlink.impl.multianchor.widget.f r107 = new com.bytedance.android.live.revlink.impl.multianchor.widget.f(((Widget) this).context, ((Widget) this).dataCenter, r106, this);
    L432:
        MultiLinkAnchorControlService r108 = new MultiLinkAnchorControlService(this.L, r105, new LinkRevControlWidget$loadMultiControlWidget$1(this), r107);
        this.d = r108;
        ((Widget) this).subWidgetManager.load(r108, r103, r103);
        goto L434
    L431:
        r107 = null;
    L434:
        if (this.E == false) goto L440;
        ((Widget) this).subWidgetManager.load(new AnchorRtcLinkerWidget());
        Fq();
        Eq();
        ((Widget) this).subWidgetManager.load(new MultiPkMatchWidget());
        WidgetManager r109 = ((Widget) this).subWidgetManager;
        RevLinkAnchorPreloadWidget r137 = new RevLinkAnchorPreloadWidget();
        this.c = r137;
        Unit r138 = Unit.INSTANCE;
        r109.load(r137);
        if (d51.c.A0.f() == true) goto L438;
    L441:
        ld.a r139 = ld.d.a();
        if (r139 == null) goto L450;
        NextLiveData r140 = r139.Ze();
        if (r140 == null) goto L450;
        Observable r141 = ld.c.a(r140);
        if (r141 == null) goto L450;
        Disposable r142 = r141.subscribe(new c(this));
        if (r142 == null) goto L450;
        RxUtilKt.c(r142, this.F);
    L450:
        ld.a r143 = ld.d.a();
        if (r143 == null) goto L459;
        NextLiveData r144 = r143.ho();
        if (r144 == null) goto L459;
        Observable r145 = ld.c.a(r144);
        if (r145 == null) goto L459;
        Disposable r146 = r145.subscribe(new d(this));
        if (r146 == null) goto L459;
        RxUtilKt.c(r146, this.F);
    L459:
        ld.a r147 = ld.d.a();
        if (r147 == null) goto L468;
        NextLiveData r148 = r147.c7();
        if (r148 == null) goto L468;
        Observable r149 = ld.c.a(r148);
        if (r149 == null) goto L468;
        Disposable r150 = r149.subscribe(new e(this));
        if (r150 == null) goto L468;
        RxUtilKt.c(r150, this.F);
    L468:
        ld.a r151 = ld.d.a();
        if (r151 == null) goto L477;
        NextLiveData r152 = r151.Y1();
        if (r152 == null) goto L477;
        Observable r153 = ld.c.a(r152);
        if (r153 == null) goto L477;
        Disposable r154 = r153.subscribe(new f(this));
        if (r154 == null) goto L477;
        RxUtilKt.c(r154, this.F);
    L477:
        ld.a r155 = ld.d.a();
        if (r155 == null) goto L486;
        NextLiveData r156 = r155.ke();
        if (r156 == null) goto L486;
        Observable r157 = ld.c.a(r156);
        if (r157 == null) goto L486;
        Disposable r158 = r157.subscribe(new g(this));
        if (r158 == null) goto L486;
        RxUtilKt.c(r158, this.F);
    L486:
        Jq(b30.g.class);
        Jq(b30.q.class);
        Jq(b30.f.class);
        com.bytedance.android.live.revlink.impl.monitor.b r159 = com.bytedance.android.live.revlink.impl.global.b.S();
        if (r159 == null) goto L489;
        r159.c(this.B);
    L489:
        com.bytedance.android.livesdk.log.filter.v r160 = com.bytedance.android.live.revlink.impl.global.b.a0();
        if (r160 == null) goto L493;
        mz0.d.a(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revlink.impl.intercomment.q.class), r160);
    L493:
        if (r212.a() == false) goto L495;
        int r161 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getMultiInteractMode();
    L499:
        if (r161 == 0) goto L501;
        b(r161);
    L501:
        p11.d r162 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo469getPerfManager();
        r162.i("default");
        r162.c(new LinkRtcDegradeTask(ld.d.a(), (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(r211.a(), com.bytedance.android.livesdk.revenue.service.room.c.class), com.bytedance.android.live.revlink.impl.global.b.k(), com.bytedance.android.live.revlink.impl.global.b.i()));
        ld.a r163 = ld.d.a();
        if (r163 == null) goto L507;
        NextLiveData r164 = r163.getRevLinkControlLoadTs();
        if (r164 == null) goto L507;
        r164.setValue(Long.valueOf(System.currentTimeMillis()));
    L507:
        if (Build.VERSION.SDK_INT < 30) goto L509;
        h r165 = new h(this);
        Looper.getMainLooper().getQueue().addIdleHandler(r165);
        Unit r166 = Unit.INSTANCE;
        this.A = r165;
    L509:
        com.bytedance.android.live.revlink.impl.global.c r167 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r167 == null) goto L514;
        com.bytedance.android.live.revlink.impl.multianchor.service.h r168 = r167.wo();
        if (r168 == null) goto L514;
        r168.d();
    L514:
        boolean r169 = this.E;
        if (r169 == true) goto L517;
    L523:
        if (r169 == true) goto L525;
        return;
    L525:
        if (r41.b.a == false) goto L527;
        return;
    L527:
        if (com.bytedance.android.live.revlink.impl.utils.u.b() == false) goto L540;
        ViewGroup r170 = ((Widget) this).containerView;
        if (r170 == null) goto L541;
        WidgetManager r171 = ((Widget) this).subWidgetManager;
        if (r171 == null) goto L542;
        r171.load(r170, new CreateLinkLynxWidget(this.a), false);
        return;
    L542:
        return;
    L541:
        return;
    L540:
        return;
    L517:
        if (r41.b.a == false) goto L523;
        ViewGroup r172 = ((Widget) this).containerView;
        if (r172 == null) goto L523;
        WidgetManager r173 = ((Widget) this).subWidgetManager;
        if (r173 == null) goto L536;
        r173.load(r172, new CreateLinkLynxWidget(this.a), false);
        return;
    L536:
        return;
    L495:
        ox0.a r174 = com.bytedance.android.live.revlink.impl.global.b.s();
        if (r174 == null) goto L498;
        r161 = r174.a();
        goto L499
    L498:
        r161 = 0;
        goto L499
    L438:
        if (com.bytedance.android.live.core.utils.v.a() == false) goto L441;
        v11.a.a(this.M);
        goto L441
    L440:
        RevLinkStallReporter r175 = new RevLinkStallReporter();
        this.x = r175;
        r175.d();
        goto L441
    L347:
        o11.a r176 = com.bytedance.android.live.revlink.impl.global.b.o();
        if (r176 != null) goto L350;
        Gq("linkScope");
        goto L353
    L350:
        com.bytedance.android.live.revlink.impl.global.c r177 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r177 != null) goto L354;
        Gq("linkInstanceService");
        goto L353
    L354:
        com.bytedance.android.live.revenuelink.rtc.f r178 = com.bytedance.android.live.revlink.impl.global.b.d();
        if (r178 == null) goto L399;
        com.bytedance.android.live.revenuelink.rtc.i r179 = r178.getRtcManager();
        if (r179 == null) goto L399;
        com.bytedance.android.live.revenuelink.connect.f r180 = com.bytedance.android.live.revlink.impl.global.b.a();
        r211 = r1;
        if (r180 == null) goto L398;
        com.bytedance.android.live.revenuelink.connect.n r181 = r180.linkOutManager();
        if (r181 == null) goto L398;
        r212 = r45;
        com.bytedance.android.live.revlink.link.core.service.s r182 = (com.bytedance.android.live.revlink.link.core.service.s) RevenueDynamicLayout.a.getValue();
        Intrinsics.checkNotNullParameter(r176, "linkScope");
        Intrinsics.checkNotNullParameter(r182, "dynamicLayoutClient");
        Intrinsics.checkNotNullParameter(r104, "linkInternalDataSet");
        Intrinsics.checkNotNullParameter(r177, "linkInstanceService");
        Intrinsics.checkNotNullParameter(r179, "anchorRtcManager");
        Intrinsics.checkNotNullParameter(r181, "linkOutManager");
        Intrinsics.checkNotNullParameter(this, "revLinkHostService");
        u51.d r183 = new u51.d(r176);
        Intrinsics.checkNotNullParameter(r183, "scope");
        Intrinsics.checkNotNullParameter(r182, "value");
        r183.e = r182;
        Intrinsics.checkNotNullParameter(r104, "value");
        r183.f = r104;
        Intrinsics.checkNotNullParameter(r177, "value");
        r183.g = r177;
        Intrinsics.checkNotNullParameter(r179, "value");
        r183.h = r179;
        Intrinsics.checkNotNullParameter(r181, "value");
        r183.i = r181;
        Intrinsics.checkNotNullParameter(this, "value");
        r183.j = this;
        Object r184 = e33.k.a;
        if (r183.e != r184) goto L368;
        String r185 = "dynamicLayoutClient";
    L394:
        if (r185 != null) goto L397;
        this.J = r183;
        com.bytedance.android.scope.l.a(r183);
        goto L426
    L397:
        throw new UninitializedPropertyAccessException(r185);
    L368:
        if (r183.f != r184) goto L371;
        r185 = "linkInternalDataSet";
        goto L394
    L371:
        if (r183.g != r184) goto L374;
        r185 = "linkInstanceService";
        goto L394
    L374:
        if (r183.h != r184) goto L377;
        r185 = "anchorRtcManager";
        goto L394
    L377:
        if (r183.i != r184) goto L379;
        r185 = "linkOutManager";
        goto L394
    L379:
        if (this != r184) goto L382;
        r185 = "revLinkHostService";
        goto L394
    L382:
        if (r183.k != r184) goto L385;
        r185 = "linkDataScope";
        goto L394
    L385:
        if (r183.l != r184) goto L388;
        r185 = "revenueInstance";
        goto L394
    L388:
        if (r183.m != r184) goto L391;
        r185 = "revenueInstanceExt";
        goto L394
    L391:
        if (r183.n != r184) goto L393;
        r185 = "roomInstance";
        goto L394
    L393:
        r185 = null;
    L398:
        r212 = r45;
        Gq("linkOutManager");
    L399:
        r211 = r1;
        r212 = r45;
        Gq("anchorRtcManager");
        goto L426
    L400:
        r211 = r1;
        r212 = r45;
        ld.a r186 = ld.d.a();
        if (r186 != null) goto L403;
        Gq("linkInternalDataSet");
        goto L426
    L403:
        o11.a r187 = com.bytedance.android.live.revlink.impl.global.b.o();
        if (r187 != null) goto L406;
        Gq("linkScope");
        goto L426
    L406:
        com.bytedance.android.live.revlink.link.core.service.s r188 = (com.bytedance.android.live.revlink.link.core.service.s) RevenueDynamicLayout.a.getValue();
        Intrinsics.checkNotNullParameter(r187, "linkScope");
        Intrinsics.checkNotNullParameter(r188, "dynamicLayoutClient");
        Intrinsics.checkNotNullParameter(r186, "linkInternalDataSet");
        u51.e r189 = new u51.e(r187);
        Intrinsics.checkNotNullParameter(r189, "scope");
        Intrinsics.checkNotNullParameter(r186, "value");
        r189.e = r186;
        Intrinsics.checkNotNullParameter(r188, "value");
        r189.f = r188;
        Object r190 = e33.k.a;
        if (r189.e == r190) goto L424;
        if (r188 != r190) goto L412;
        r136 = "dynamicLayoutClient";
        goto L424
    L412:
        if (r189.g != r190) goto L415;
        r136 = "linkDataScope";
        goto L424
    L415:
        if (r189.h != r190) goto L418;
        r136 = "revenueInstance";
        goto L424
    L418:
        if (r189.i != r190) goto L421;
        r136 = "revenueInstanceExt";
        goto L424
    L421:
        if (r189.j != r190) goto L423;
        r136 = "roomInstance";
        goto L424
    L423:
        r136 = null;
    L424:
        if (r136 != null) goto L535;
        this.K = r189;
        com.bytedance.android.scope.l.a(r189);
        goto L426
    L535:
        throw new UninitializedPropertyAccessException(r136);
    L334:
        if (r100.isPaidLive() != true) goto L336;
        this.i.y(0.34f);
        goto L336
    L199:
        r65 = null;
    L196:
        r64 = null;
        goto L197
    L185:
        if (com.bytedance.android.live.utils.c.a(r121, 4) == false) goto L210;
    L172:
        r134 = null;
    L169:
        r133 = null;
        goto L170
    L163:
        if (com.bytedance.android.live.utils.c.a(r121, 64) == false) goto L183;
    L159:
        r130 = null;
        goto L160
    L151:
        r126 = null;
        goto L152
    L147:
        r124 = null;
        goto L148
    L97:
        if (r114 != LiveMode.THIRD_PARTY) goto L106;
        if (r210 == null) goto L102;
        NextLiveData r191 = r210.v1();
        if (r191 == null) goto L102;
        Boolean r192 = (Boolean) r191.getValue();
    L104:
        if (Intrinsics.areEqual(r192, Boolean.TRUE) == false) goto L106;
        boolean r193 = true;
    L107:
        Intrinsics.checkNotNullParameter(r120, "room");
        r54.e = r120;
        StringBuilder r194 = new StringBuilder("onRoom sync ");
        r194.append(IRoomKt_androidKt.getLinkMapKt(r120));
        r194.append(", battleSetting: ");
        vh7.c r195 = r54.e;
        if (r195 == null) goto L116;
        IRoomLinkExt r196 = (IRoomLinkExt) r195.castTo(IRoomLinkExt.class);
        if (r196 == null) goto L116;
        com.bytedance.android.livesdk.link.model.a9 r197 = r196.getLinkMicInfo();
        if (r197 == null) goto L116;
        ILinkMicBattleSetting r198 = r197.getBattleSetting();
        if (r198 == null) goto L116;
        Long r199 = Long.valueOf(r198.getBattleId());
    L117:
        r194.append(r199);
        jy0.b.c("link_preload", r194.toString(), null, 4);
        if (r193 == true) goto L143;
        IRoom r1100 = r54.e;
        if (r1100 == null) goto L123;
        Map r1101 = IRoomKt_androidKt.getLinkMapKt(r1100);
    L124:
        if (r1101 != null) goto L126;
        r121 = 0;
    L133:
        if (r53 == false) goto L144;
        if (r52 == null) goto L136;
        r31.a r1102 = r52.getLinkNetwork();
    L137:
        if (r1102 == null) goto L144;
        Observable<ExtraResponse<e4, Extra>> r1103 = r1102.G();
        if (r1103 == null) goto L144;
        Disposable r1104 = r1103.subscribe(com.bytedance.android.live.revlink.impl.control.m.a, com.bytedance.android.live.revlink.impl.control.n.a);
        if (r1104 == null) goto L144;
        com.bytedance.revenue.platform.api.core.rx.f.a(r1104, r54.c);
        goto L144
    L136:
        r1102 = null;
        goto L137
    L126:
        if (r1101.containsKey(String.valueOf(1)) == false) goto L128;
        int r1105 = com.bytedance.android.live.utils.c.a;
        r121 = 4;
    L130:
        if (r1101.containsKey(String.valueOf(7)) == false) goto L133;
        int r1106 = com.bytedance.android.live.utils.c.a;
        r121 = r121 | 64;
        goto L133
    L128:
        r121 = 0;
        goto L130
    L123:
        r1101 = null;
    L116:
        r199 = null;
    L102:
        r192 = null;
    L106:
        r193 = false;
        goto L107
    L84:
        r116 = null;
        goto L85
    L52:
        ox0.a r200 = com.bytedance.android.live.revlink.impl.global.b.s();
        if (r200 == null) goto L55;
        r46 = r200.a();
        goto L56
    L55:
        r46 = 0;
        goto L56
    L48:
        r38 = null;
        goto L49
    L41:
        this.u = new w();
    L37:
        r25 = true;
    L29:
        r20 = null;
    L23:
        r17 = false;
        goto L24
    L17:
        r14 = null;
    L7:
        r4 = null;
        goto L8
    }

    public final void onDestroy() {
        jy0.b.d("InteractionFrameworkTracer", "LinkRevControlWidget onDestroy");
        super.onDestroy();
        if (Build.VERSION.SDK_INT < 30) goto L8;
        h r1 = this.A;
        if (r1 == null) goto L7;
        Looper.getMainLooper().getQueue().removeIdleHandler(r1);
    L7:
        this.A = null;
    L8:
        LinkCheckLoadUtils r2 = this.m;
        if (r2 == null) goto L12;
        r2.f.dispose();
    L12:
        if (((LiveFragmentLeakConfig) o1.a.getValue()).getRevControlWidgetSwitch() == false) goto L14;
        this.L = null;
    L14:
        RevLinkLiveFeedViewModel r3 = this.e;
        if (r3 == null) goto L17;
        r3.onCleared();
    L17:
        DataCenter r4 = ((Widget) this).dataCenter;
        if (r4 == null) goto L20;
        r4.removeObserver(this);
    L20:
        com.bytedance.android.live.revlink.impl.control.e r5 = this.k;
        if (r5 != null) goto L23;
    L125:
        EnterRoomFirstSeiChecker r6 = this.v;
        Disposable r7 = r6.b;
        if (r7 == null) goto L128;
        r7.dispose();
    L128:
        Disposable r8 = r6.c;
        if (r8 == null) goto L131;
        r8.dispose();
    L131:
        LinkOtherAnchorListener r9 = this.t;
        if (r9 == null) goto L146;
        r9.a = null;
        Disposable r10 = r9.b;
        if (r10 == null) goto L136;
        r10.dispose();
    L136:
        i11.b r12 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r12 == null) goto L139;
        r12.l(r9);
    L139:
        com.bytedance.android.live.revlink.impl.pk.utils.q r13 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r13 == null) goto L146;
        PkScopeProviderService r14 = r13.a;
        if (r14 == null) goto L146;
        MutableLiveData<IBaseUser> r15 = r14.b;
        if (r15 == null) goto L146;
        r15.removeObserver(r9);
    L146:
        i41.a r16 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r16 == null) goto L149;
        r16.b(AutoMatchSource.Manual);
    L149:
        i41.r.c.a().a();
        this.F.dispose();
        this.y.j(0);
        com.bytedance.android.live.revlink.impl.monitor.b r17 = com.bytedance.android.live.revlink.impl.global.b.S();
        if (r17 == null) goto L152;
        r17.b();
    L152:
        yq();
        p11.h r18 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo470getPkService();
        if (r18 == null) goto L155;
        r18.i(this.z);
    L155:
        p11.d r19 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).mo469getPerfManager();
        if (r19 == null) goto L158;
        r19.d();
    L158:
        AnchorLinkUserCenterV2 r20 = this.a;
        if (r20 == null) goto L161;
        r20.l.clear();
        r20.g.dispose();
        r20.h.clear();
        ((CopyOnWriteArrayList) r20.a).clear();
        ((CopyOnWriteArrayList) r20.b).clear();
        r20.e.clear();
        r20.c.clear();
        r20.d.clear();
    L161:
        mz0.d.c(Reflection.getOrCreateKotlinClass(com.bytedance.android.live.revlink.impl.intercomment.q.class));
        RevLinkStallReporter r22 = this.x;
        if (r22 != null) goto L164;
    L180:
        this.x = null;
        x11.c.a = null;
        xq(null);
        com.bytedance.android.live.revlink.impl.pk.utils.q r23 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r23 == null) goto L183;
        r23.a = null;
    L183:
        d51.c r24 = d51.c.A0;
        r24.getClass();
        if (((Boolean) d51.c.e.getValue(r24, d51.c.a[3])).booleanValue() == false) goto L186;
        ((Widget) this).widgetCallback = null;
    L186:
        StringBuilder r25 = new StringBuilder("LinkRevControlWidget onDestroy ");
        IRoom r26 = this.B;
        if (r26 == null) goto L189;
        Long r27 = Long.valueOf(r26.getId());
    L190:
        r25.append(r27);
        jy0.b.f("ttlive_revlink", r25.toString(), null, 4);
        return;
    L189:
        r27 = null;
        goto L190
    L164:
        if (d51.c.A0.c().getEnable() == false) goto L180;
        or2.j r28 = vh6.c.b(or2.e.class).getCurrentClient();
        if (r28 == null) goto L179;
        or2.m r29 = r28.d();
        if (r22.d == false) goto L179;
        r22.d = false;
        MutableLiveData r30 = r29.getSeiUpdate();
        if (r30 == null) goto L173;
        r30.removeObserver((Observer) r22.j.getValue());
    L173:
        MutableLiveData r32 = r29.d();
        if (r32 == null) goto L176;
        r32.removeObserver((Observer) r22.k.getValue());
    L176:
        MutableLiveData r33 = r29.c();
        if (r33 == null) goto L179;
        r33.removeObserver((Observer) r22.l.getValue());
    L179:
        r22.e();
        goto L180
    L23:
        if (r5.f == false) goto L104;
        com.bytedance.android.live.revlink.impl.global.c r34 = r5.d;
        if (r34 == null) goto L27;
        w31.c r35 = r34.getPkLinkUtils();
    L28:
        if (r35 == null) goto L30;
        String r36 = r35.c();
    L31:
        if (r36 == null) goto L104;
        com.bytedance.android.live.revlink.impl.global.c r37 = r5.d;
        if (r37 == null) goto L35;
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r38 = r37.Ig();
    L36:
        long r39 = 0;
        if (r38 == null) goto L54;
        PkBaseStateMachine.c r40 = r38.getCurPKBaseState();
        if (r38.getBattleSettings() == null) goto L43;
        IBaseBattleSetting r42 = r38.getBattleSettings();
        if (r42 == null) goto L43;
        long r43 = r42.getMode();
    L44:
        com.bytedance.android.live.revlink.impl.global.c r110 = r5.d;
        if (r110 == null) goto L47;
        com.bytedance.android.live.revlink.impl.pk.utils.q r111 = r110.getPkUtils();
    L48:
        if (r111 == null) goto L52;
        com.bytedance.android.live.revlink.impl.mergepk.pkdouble.c r112 = r111.g();
        if (r112 == null) goto L52;
        boolean r113 = r112.isRoomCloser();
    L53:
        long r114 = r43;
        long r210 = r38.getPkId();
    L56:
        if (r5.f == false) goto L96;
        if (r40 == null) goto L96;
        if ((r40 instanceof PkBaseStateMachine.c.C0130c) != true) goto L96;
        LinkCrossRoomDataHolder r44 = r5.b;
        if (r44 == null) goto L63;
        long r115 = r44.c();
    L64:
        if (r113 == false) goto L66;
        int r45 = 11;
    L68:
        if (u41.a.c.a() == false) goto L74;
        int r46 = com.bytedance.android.live.revenue.common.h.a;
        StringBuilder r47 = new StringBuilder();
        r47.append(String.valueOf(r115));
        r47.append(DataType.TRUE);
        LinkCrossRoomDataHolder r48 = r5.b;
        if (r48 == null) goto L72;
        int r49 = r48.i();
    L73:
        r47.append(r49);
        r47.append(r45);
        String r50 = com.bytedance.android.live.revenue.common.h.a(r47.toString());
    L75:
        String r116 = r50;
        com.bytedance.android.livesdk.revenue.service.room.c r52 = r5.i;
        if (r52 == null) goto L82;
        com.bytedance.android.livesdk.revenue.room.a r53 = r52.getRoomContext();
        if (r53 == null) goto L82;
        IRoomBase r54 = r53.getCommonRoom();
        if (r54 == null) goto L82;
        r39 = IRoomKtKt.getId(r54);
    L82:
        long r117 = r39;
        com.bytedance.android.live.revlink.impl.global.c r55 = r5.d;
        if (r55 == null) goto L85;
        r31.a r56 = r55.getLinkNetwork();
    L86:
        if (r56 == null) goto L104;
        LinkCrossRoomDataHolder r57 = r5.b;
        if (r57 == null) goto L90;
        int r58 = r57.i();
    L91:
        long r59 = r115;
        Observable<ExtraResponse<f1, Extra>> r60 = r56.f(r115, r58, 1, r114, r45, r116, r117, 1, r210);
        if (r60 == null) goto L104;
        Disposable r62 = r60.subscribe(new com.bytedance.android.live.revlink.impl.control.k(r5, r59), new com.bytedance.android.live.revlink.impl.control.l(r5, r59));
        if (r62 == null) goto L104;
        com.bytedance.revenue.platform.api.core.rx.f.a(r62, r5.c);
        goto L104
    L90:
        r58 = 0;
        goto L91
    L85:
        r56 = null;
        goto L86
    L72:
        r49 = 0;
        goto L73
    L74:
        r50 = "";
        goto L75
    L66:
        r45 = 0;
        goto L68
    L63:
        r115 = 0;
    L96:
        if (r40 == null) goto L104;
        if ((r40 instanceof PkBaseStateMachine.c.a) == true) goto L104;
        LinkCrossRoomDataHolder r63 = r5.b;
        if (r63 == null) goto L102;
        r39 = r63.c();
    L102:
        r5.a(r39);
    L52:
        r113 = false;
        goto L53
    L47:
        r111 = null;
    L43:
        r43 = 0;
        goto L44
    L54:
        r40 = null;
        r114 = 0;
        r210 = 0;
        r113 = false;
        goto L56
    L35:
        r38 = null;
        goto L36
    L30:
        r36 = null;
        goto L31
    L27:
        r35 = null;
    L104:
        if (v41.a.m.a() == true) goto L106;
    L124:
        r5.c.clear();
        ((com.bytedance.android.livesdk.common.k) r5).a = null;
        goto L125
    L106:
        if (r5.f == false) goto L124;
        com.bytedance.android.live.revlink.impl.global.c r64 = r5.d;
        if (r64 == null) goto L110;
        com.bytedance.android.live.revenuelink.rtc.f r65 = r64.m0();
    L111:
        if (r65 == null) goto L124;
        com.bytedance.android.live.revenuelink.rtc.i r66 = r65.getRtcManager();
        if (r66 == null) goto L124;
        if (r66.hasLogin() != true) goto L124;
        com.bytedance.android.live.revlink.impl.global.c r67 = r5.d;
        if (r67 == null) goto L119;
        com.bytedance.android.live.revenuelink.rtc.f r68 = r67.m0();
    L120:
        if (r68 == null) goto L124;
        com.bytedance.android.live.revenuelink.rtc.i r69 = r68.getRtcManager();
        if (r69 == null) goto L124;
        r69.logout();
        goto L124
    L119:
        r68 = null;
        goto L120
    L110:
        r65 = null;
        goto L111
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.a
    public final boolean p() {
        View r0 = this.l;
        if (r0 != null) goto L5;
        return true;
    L5:
        if (r0.getParent() != this.M) goto L10;
        ToastUtil.a(2131919256, 0);
        return false;
    L10:
        return true;
    }

    public final String zq() {
        if (this.i.w == false) goto L6;
        return "cohost_game";
    L6:
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L11;
        NextLiveData r1 = r0.uf();
        if (r1 == null) goto L11;
        Integer r2 = (Integer) r1.getValue();
    L12:
        if (r2 != null) goto L15;
    L17:
        if (r2 != null) goto L20;
    L22:
        if (r2 != null) goto L25;
    L27:
        if (r2 != null) goto L30;
    L32:
        return "";
    L30:
        if (r2.intValue() != 4) goto L32;
    L31:
        return "anchor_link";
    L25:
        if (r2.intValue() != 1) goto L27;
    L20:
        if (r2.intValue() != 3) goto L22;
    L21:
        return "pk";
    L15:
        if (r2.intValue() != 2) goto L17;
    L11:
        r2 = null;
        goto L12
    }

    public final void Eq() {
        if (com.bytedance.android.live.revlink.impl.utils.u.b() == false) goto L6;
        enableSubWidgetManager();
        ((Widget) this).subWidgetManager.load(new MultiPkPreciseFindWidget());
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.a
    public final void F0() {
        ox0.a r0 = com.bytedance.android.live.revlink.impl.global.b.s();
        if (r0 == null) goto L5;
        int r1 = r0.a();
    L6:
        if (r1 != 0) goto L8;
    L9:
        LinkCrossRoomDataHolder r2 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r2 == null) goto L20;
        long r4 = 0;
        if (r2.c() != 0) goto L20;
        com.bytedance.android.live.revlink.impl.pk.service.a r6 = com.bytedance.android.live.revlink.impl.global.b.M();
        if (r6 == null) goto L22;
        IRoom r3 = this.B;
        if (r3 == null) goto L19;
        r4 = r3.getId();
    L19:
        r6.e(r4, null, PkAutoMatchManager.AutoMatchRequestSource.FromJsb, LinkRevControlWidget$startRandomPk$1.INSTANCE);
        return;
    L22:
        return;
    L20:
        ToastUtil.a(2131917956, 0);
        return;
    L8:
        if (r1 != 2) goto L20;
    L5:
        r1 = 0;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.b
    public final void Pg() {
        com.bytedance.android.live.revlink.impl.service.internal.a r0 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r0 == null) goto L5;
        View r1 = r0.Ii();
    L6:
        if (r1 != null) goto L11;
        com.bytedance.android.live.revlink.impl.pk.service.i r2 = com.bytedance.android.live.revlink.impl.global.b.h0();
        if (r2 == null) goto L12;
        r2.W2(2);
        return;
    L12:
        return;
    L11:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.b
    public final int Wp() {
        ld.a r0 = ld.d.a();
        if (r0 == null) goto L9;
        NextLiveData r1 = r0.d0();
        if (r1 == null) goto L9;
        Integer r2 = (Integer) r1.getValue();
        if (r2 == null) goto L9;
        return r2.intValue();
    L9:
        return 0;
    }

    public final void onPause() {
        super.onPause();
        this.H = true;
        jy0.b.f("LinkRevControlWidget", "onPause", null, 4);
    }

    public final void onResume() {
        super.onResume();
        this.H = false;
        jy0.b.f("LinkRevControlWidget", "onResume", null, 4);
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.a
    public final View Ii() {
        return this.l;
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.b
    public final boolean dc() {
        return this.H;
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.b
    public final int getCurrentMode() {
        return this.j;
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.b
    public final void m() {
        yq();
    }

    public static void Gq(String r3) {
        jy0.b.c("LinkRevControlWidget", "key component null with name: " + r3 + " and source: launchAnchorRevLinkScope", null, 4);
        com.bytedance.android.live.revlink.impl.multianchor.utils.v r4 = com.bytedance.android.live.revlink.impl.global.b.C();
        if (r4 == null) goto L6;
        Error r0 = new Error();
        Intrinsics.checkNotNullParameter(r0, "e");
        LinkedHashMap r1 = new LinkedHashMap();
        r1.put("exception", r0.toString());
        r4.H("rev_scope_load_exception", r1);
        return;
    }

    public static void xq(x11.a r2) {
        com.bytedance.android.live.revlink.impl.multianchor.dialog.linkopt.f r0 = com.bytedance.android.live.revlink.impl.global.b.m();
        if (r0 == null) goto L5;
        r0.a = r2;
    L5:
        com.bytedance.android.live.revlink.impl.global.c r1 = com.bytedance.android.live.revlink.impl.global.b.k();
        com.bytedance.android.live.revlink.impl.utils.a0 r3 = null;
        if (r1 == null) goto L8;
        h41.c r4 = r1.getLiveInviteLogger();
    L9:
        if (r4 == null) goto L11;
        r4.a = r2;
    L11:
        com.bytedance.android.live.revlink.impl.global.c r5 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r5 == null) goto L14;
        h41.d r6 = r5.hb();
    L15:
        if (r6 == null) goto L17;
        r6.a = r2;
    L17:
        ox0.a r7 = com.bytedance.android.live.revlink.impl.global.b.s();
        if (r7 == null) goto L20;
        r7.a = r2;
    L20:
        com.bytedance.android.live.revlink.impl.multianchor.utils.q r8 = com.bytedance.android.live.revlink.impl.global.b.v();
        if (r8 == null) goto L23;
        r8.a = r2;
    L23:
        d31.d r9 = com.bytedance.android.live.revlink.impl.global.b.c0();
        if (r9 == null) goto L26;
        r9.a = r2;
    L26:
        com.bytedance.android.live.revlink.impl.global.c r10 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r10 == null) goto L29;
        r3 = r10.fl();
    L29:
        if (r3 == null) goto L31;
        r3.a = r2;
    L31:
        LinkCrossRoomDataHolder r12 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r12 == null) goto L35;
        r12.a = r2;
        return;
    L35:
        return;
    L14:
        r6 = null;
        goto L15
    L8:
        r4 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.b
    public final void Ak(String r10) {
        Intrinsics.checkNotNullParameter(r10, "source");
        RevLinkDialog r0 = this.q;
        if (r0 != null) goto L5;
    L9:
        RevLinkDialog r1 = this.q;
        if (r1 != null) goto L12;
    L13:
        DataCenter r2 = ((Widget) this).dataCenter;
        int r3 = RevLinkDialog.x;
        RevLinkDialog r4 = new RevLinkDialog.a(r2, this).a();
        this.q = r4;
        int r5 = InteractPkRecordFragmentNew.y;
        InteractPkRecordFragmentNew r12 = InteractPkRecordFragmentNew.a.a(r4, ((Widget) this).dataCenter, 0, 0, false, true, r10);
        RevLinkDialog r6 = this.q;
        if (r6 == null) goto L16;
        r6.f = r12;
    L16:
        Kq(null);
        RevLinkDialog r13 = this.q;
        if (r13 == null) goto L24;
        FragmentActivity r7 = ((Widget) this).context;
        if (r7 == null) goto L22;
        wq(r13, r7.getSupportFragmentManager());
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L24:
        return;
    L12:
        if (r1.isVisible() == false) goto L13;
        return;
    L5:
        if (r0.isVisible() != true) goto L9;
        d51.c r8 = d51.c.A0;
        r8.getClass();
        if (((Boolean) d51.c.r0.getValue(r8, d51.c.a[68])).booleanValue() == false) goto L9;
        yq();
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [x11.a] */
    /* JADX WARN: Type inference failed for: r11v1, types: [x11.a] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void Bq(RevLinkSwitchExtraContext r14) {
        StringBuilder r0 = new StringBuilder("launchOrSwitchRevLinkService with audience scene: ");
        f80.b r1 = null;
        if (r14 == null) goto L7;
        RevLinkAudienceLaunchParam r2 = r14.f;
        if (r2 == null) goto L7;
        Integer r3 = Integer.valueOf(r2.a);
    L8:
        r0.append(r3);
        r0.append(" and anchor scene: ");
        if (r14 == null) goto L13;
        RevLinkAnchorLaunchParam r4 = r14.e;
        if (r4 == null) goto L13;
        Integer r5 = Integer.valueOf(r4.a);
    L14:
        r0.append(r5);
        r0.append(" and toBizType: ");
        if (r14 == null) goto L23;
        RevLinkAnchorLaunchParam r6 = r14.e;
        if (r6 == null) goto L23;
        com.bytedance.android.live.revlink.impl.control.launchcontext.a r7 = r6.k;
        if (r7 == null) goto L23;
        com.bytedance.android.live.revlink.impl.multianchor.utils.u r8 = r7.a;
        if (r8 == null) goto L23;
        Integer r9 = Integer.valueOf(r8.i);
    L24:
        r0.append(r9);
        r0.append(" witch stack: ");
        r0.append(ExceptionsKt.stackTraceToString(new Error()));
        jy0.b.c("SwitchSceneCompactComponent", r0.toString(), null, 4);
        if (this.E == false) goto L90;
        RevLinkAnchorWidget r10 = this.f;
        if (r10 != null) goto L52;
        if (r14 == null) goto L30;
        RevLinkAnchorLaunchParam r12 = r14.e;
    L31:
        u51.d r13 = this.J;
        wq2.f r15 = ma1.a.a();
        if (r12 == null) goto L51;
        if (r13 == null) goto L51;
        if (r15 == null) goto L51;
        if (this.L == null) goto L51;
        o11.a r16 = com.bytedance.android.live.revlink.impl.global.b.o();
        if (r16 == null) goto L50;
        com.bytedance.android.livesdk.revenue.service.room.c r17 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r17 == null) goto L48;
        ld.a r18 = ld.d.a();
        o11.a r19 = com.bytedance.android.live.revlink.impl.global.b.o();
        if (r19 == null) goto L44;
        r1 = (x11.a) com.bytedance.android.scope.m.e.d(r19, x11.a.class);
    L44:
        com.bytedance.android.live.revlink.impl.b r110 = this.L;
        Intrinsics.checkNotNull(r110);
        r1 = new RevLinkAnchorWidget(r12, r13, r16, r17, r15, r18, r1, new LinkRevControlWidget$launchOrSwitchRevLinkService$1$revLinkAnchorWidget$2(r110));
        com.bytedance.android.live.revlink.impl.b r111 = this.L;
        if (r111 == null) goto L51;
        r111.b(r1);
        goto L51
    L48:
        throw new Error("no rev room service");
    L50:
        throw new Error("no linkScope");
    L51:
        this.f = r1;
        return;
    L30:
        r12 = null;
        goto L31
    L52:
        if (r14 == null) goto L137;
        RevLinkAnchorLaunchParam r112 = r14.e;
        if (r112 == null) goto L138;
        Intrinsics.checkNotNullParameter(r112, "launchParam");
        com.bytedance.android.live.revlink.widgetservice.a r20 = r10.b;
        if (r20 == null) goto L85;
        Intrinsics.checkNotNullParameter(r112, "launchParam");
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r22 = r20.b;
        if (r22 == null) goto L62;
        RevLinkBizContext r23 = r22.d;
        if (r23 == null) goto L62;
        r23.o = r112.a;
    L62:
        if (r22 == null) goto L67;
        RevLinkBizContext r24 = r22.d;
        if (r24 == null) goto L67;
        r24.a(r112.c);
    L67:
        if (r112.o == true) goto L77;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r25 = r20.b;
        if (r25 == null) goto L71;
        r25.p = false;
    L71:
        if (r25 == null) goto L73;
        r25.o = true;
    L73:
        if (r25 == null) goto L75;
        r25.j = r112.l;
    L75:
        if (r25 == null) goto L77;
        r25.i = r112.k;
    L77:
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r26 = r20.b;
        if (r26 == null) goto L85;
        RevLinkBizContext r27 = r26.d;
        if (r27 == null) goto L85;
        PublishSubject<com.bytedance.android.live.revlink.link.infra.lifecontrol.context.m> r28 = r27.e;
        if (r28 == null) goto L85;
        r28.onNext(new com.bytedance.android.live.revlink.link.infra.lifecontrol.context.m(r112.p));
    L85:
        if (r112.o == true) goto L148;
        r10.g = r112;
        if (((RTCBizManagerService) r10.a.getValue()) == null) goto L139;
        Intrinsics.checkNotNullParameter(r112, "launchParam");
        return;
    L139:
        return;
    L148:
        return;
    L138:
        return;
    L137:
        return;
    L90:
        RevLinkAudienceWidget r29 = this.g;
        if (r29 != null) goto L114;
        if (r14 == null) goto L94;
        RevLinkAudienceLaunchParam r30 = r14.f;
    L95:
        u51.e r32 = this.K;
        wq2.f r33 = ma1.a.a();
        if (r30 == null) goto L113;
        if (r32 == null) goto L113;
        if (r33 == null) goto L113;
        o11.a r34 = com.bytedance.android.live.revlink.impl.global.b.o();
        if (r34 == null) goto L112;
        com.bytedance.android.livesdk.revenue.service.room.c r35 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r35 == null) goto L110;
        ld.a r113 = ld.d.a();
        o11.a r114 = com.bytedance.android.live.revlink.impl.global.b.o();
        if (r114 == null) goto L106;
        r1 = (x11.a) com.bytedance.android.scope.m.e.d(r114, x11.a.class);
    L106:
        r1 = new RevLinkAudienceWidget(r30, r32, r34, r35, r33, r113, r1);
        com.bytedance.android.live.revlink.impl.b r115 = this.L;
        if (r115 == null) goto L113;
        r115.b(r1);
        goto L113
    L110:
        throw new Error("no rev room service");
    L112:
        throw new Error("no linkScope");
    L113:
        this.g = r1;
        return;
    L94:
        r30 = null;
        goto L95
    L114:
        if (r14 == null) goto L142;
        RevLinkAudienceLaunchParam r116 = r14.f;
        if (r116 == null) goto L143;
        Intrinsics.checkNotNullParameter(r116, "launchParam");
        RevLinkAudienceFacade r36 = r29.a;
        if (r36 == null) goto L144;
        Intrinsics.checkNotNullParameter(r116, "launchParam");
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h r37 = r36.a;
        if (r37 == null) goto L124;
        RevLinkBizContext r38 = r37.d;
        if (r38 == null) goto L124;
        r38.o = r116.a;
    L124:
        if (r37 == null) goto L128;
        RevLinkBizContext r39 = r37.d;
        if (r39 == null) goto L128;
        r39.a(r116.b);
    L128:
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h r117 = r36.a;
        if (r117 == null) goto L145;
        RevLinkBizContext r118 = r117.d;
        if (r118 == null) goto L146;
        PublishSubject<com.bytedance.android.live.revlink.link.infra.lifecontrol.context.m> r119 = r118.e;
        if (r119 == null) goto L147;
        r119.onNext(new com.bytedance.android.live.revlink.link.infra.lifecontrol.context.m(true));
        return;
    L147:
        return;
    L146:
        return;
    L145:
        return;
    L144:
        return;
    L143:
        return;
    L142:
        return;
    L23:
        r9 = null;
    L13:
        r5 = null;
    L7:
        r3 = null;
        goto L8
    }

    public final void Cq(RevLinkSwitchExtraContext r2) {
        Bq(r2);
        a r3 = O;
        boolean r0 = this.E;
        r3.getClass();
        a.a("pk", r0);
        if (this.E == false) goto L16;
        vh6.c.b(qr2.c.class).tryLoadPkAudienceWidget();
        if (this.E == false) goto L11;
        IRoom r4 = this.B;
        if (r4 == null) goto L11;
        boolean r1 = true;
        if (r4.isLiveTypeAudio() != true) goto L11;
    L12:
        if (r1 == false) goto L15;
        jy0.b.d("ttlive_link", "loadCrossRoomWidget, useVoiceSceneToolbar, don't show interaction");
        return;
    L15:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(((Widget) this).dataCenter).b(RevToolbarButton.INTERACTION);
    L17:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.a.class).Ij(((Widget) this).dataCenter);
        wq2.f r5 = ma1.a.a();
        if (r5 == null) goto L21;
        r5.kn();
    L21:
        if (this.c == null) goto L30;
        LinkRevPanelDataContext r6 = LinkRevPanelDataContext.Companion.getContext();
        if (r6 == null) goto L31;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.control.dialog.b> r7 = r6.getLoader();
        if (r7 == null) goto L32;
        com.bytedance.android.live.revlink.impl.control.dialog.b r8 = (com.bytedance.android.live.revlink.impl.control.dialog.b) r7.getValue();
        if (r8 == null) goto L33;
        r8.o();
        return;
    L33:
        return;
    L32:
        return;
    L31:
        return;
    L30:
        return;
    L11:
        r1 = false;
        goto L12
    L16:
        vh6.c.b(qr2.c.class).tryLoadPkAudienceWidget();
        goto L17
    }

    public final <T> void Jq(Class<T> r3) {
        this.F.add(xs2.b.a().b(r3).subscribe(new i(this)));
    }

    @Override // com.bytedance.android.live.revlink.impl.utils.j
    public final void K4(int r4) {
        m41.b.a r0 = m41.b.a.c;
        if (r4 != 4) goto L10;
        w31.c r2 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r2 == null) goto L10;
        com.bytedance.android.live.revlink.impl.pk.service.d r3 = r2.h();
        if (r3 == null) goto L10;
        r3.setUnLoadSource(r0);
    L10:
        com.bytedance.android.live.revlink.impl.service.internal.b.a.a(this, r4, true, 4);
    }

    public final void Kq(DialogInterface.OnDismissListener r3) {
        RevLinkDialog r0 = this.q;
        if (r0 == null) goto L6;
        r0.setOnDismissListener(new j(this, (q) r3));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v18, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.bytedance.android.live.service.prerequest.b$b, java.lang.Object, kc0.f] */
    @Override // com.bytedance.android.live.revlink.impl.service.internal.a
    public final void P9(com.bytedance.android.live.service.prerequest.b.C0223b r8) {
        Intrinsics.checkNotNullParameter(r8, "callback");
        LinkOtherAnchorListener r1 = this.t;
        if (r1 == null) goto L66;
        Intrinsics.checkNotNullParameter(r8, "callback");
        if (((Boolean) r1.c.getValue()).booleanValue() == false) goto L67;
        r1.a = r8;
        if (y.d() == false) goto L17;
        w31.c r0 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r0 == null) goto L15;
        String r2 = r0.c();
        if (r2 == null) goto L15;
        ?? r3 = CollectionsKt.listOf(r2);
        if (r3 == 0) goto L15;
    L56:
        r8.a(r3);
        return;
    L15:
        r3 = CollectionsKt.emptyList();
        goto L56
    L17:
        if (y.c() == false) goto L55;
        i11.b r4 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r4 == null) goto L54;
        List<com.bytedance.android.livesdk.link.model.p> r5 = r4.getOnlineUserList();
        if (r5 == null) goto L54;
        ArrayList r6 = new ArrayList();
        Iterator r7 = r5.iterator();
    L24:
        if (r7.hasNext() == false) goto L45;
        Object r9 = r7.next();
        com.bytedance.android.livesdk.link.model.p r10 = (com.bytedance.android.livesdk.link.model.p) r9;
        IBaseUser r12 = r10.getUser();
        String r13 = null;
        if (r12 == null) goto L28;
        String r14 = r12.getIdString();
    L29:
        if (r14 == null) goto L42;
        IBaseUser r15 = r10.getUser();
        if (r15 == null) goto L33;
        String r16 = r15.getIdString();
    L34:
        IRoom r17 = r1.d;
        if (r17 == null) goto L40;
        IBaseUser r18 = r17.getOwner();
        if (r18 == null) goto L40;
        r13 = r18.getIdString();
    L40:
        if (Intrinsics.areEqual(r16, r13) == false) goto L42;
        boolean r19 = true;
    L43:
        if (r19 == true) goto L24;
        r6.add(r9);
        goto L24
    L33:
        r16 = null;
    L42:
        r19 = false;
        goto L43
    L28:
        r14 = null;
        goto L29
    L45:
        r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r6, 10));
        Iterator r20 = r6.iterator();
    L47:
        if (r20.hasNext() == false) goto L56;
        IBaseUser r22 = ((com.bytedance.android.livesdk.link.model.p) r20.next()).getUser();
        if (r22 == null) goto L52;
        String r23 = r22.getIdString();
        if (r23 == null) goto L52;
    L53:
        r3.add(r23);
    L52:
        r23 = "";
    L54:
        r3 = CollectionsKt.emptyList();
        goto L56
    L55:
        r3 = CollectionsKt.emptyList();
        goto L56
    L67:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.b
    public final void Rg(String r3) {
        RevLinkDialog r0 = this.q;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isShowing() != true) goto L13;
        if (r3 == null) goto L15;
        RevLinkDialog r1 = this.q;
        if (r1 == null) goto L14;
        UIUtils.setText(r1.j, r3);
        return;
    L14:
        return;
    L15:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.a
    public final void b(int r18) {
        this.p.a(this.j, r18);
        boolean r3 = true;
        if (this.E == false) goto L25;
        if (this.l == null) goto L25;
        int r2 = com.bytedance.android.live.revlink.impl.pk.utils.p.a;
        if (com.bytedance.android.live.revlink.impl.pk.utils.p.a(this.B) == true) goto L9;
    L11:
        boolean r4 = false;
    L12:
        IPKLinkBizDataService r5 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r5 == null) goto L15;
        r5.setIsRandomReMatch(false);
    L15:
        if (r4 == true) goto L25;
        gt1.d r6 = gt1.e.a(1, Boolean.FALSE, false, false, false, false, 0, false, false, null, 2044);
        ld.a r7 = ld.d.a();
        if (r7 == null) goto L21;
        NextLiveData r8 = r7.Y1();
        if (r8 == null) goto L21;
        r8.setValue(r6);
    L21:
        wq2.f r9 = ma1.a.a();
        if (r9 == null) goto L25;
        r9.S1(r6);
        goto L25
    L9:
        if (r18 != 4) goto L11;
        r4 = true;
    L25:
        if (r18 != 32) goto L28;
        this.i.y(0.34f);
        return;
    L28:
        if (r18 == 8) goto L30;
        return;
    L30:
        if (this.E == false) goto L36;
        IRoom r1 = this.B;
        if (r1 == null) goto L36;
        if (r1.isLiveTypeAudio() != true) goto L36;
    L37:
        if (r3 == false) goto L42;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.toolbar.e.class).b9(((Widget) this).dataCenter).d(RevToolbarButton.PK);
        return;
    L42:
        return;
    L36:
        r3 = false;
        goto L37
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.b
    public final JSONObject hn(List<String> r12) {
        JSONObject r0 = new JSONObject();
        List<String> r1 = r12;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == false) goto L11;
        return r0;
    L11:
        IPKLinkBizDataService r3 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r3 == null) goto L14;
        IPKLinkBizDataService.d r4 = r3.getLinkTypeParams();
    L15:
        com.bytedance.android.live.revlink.impl.multianchor.service.a r5 = com.bytedance.android.live.revlink.impl.global.b.t();
        if (r5 == null) goto L18;
        com.bytedance.android.live.revlink.impl.multianchor.utils.o r6 = r5.getLinkTypeParams();
    L19:
        com.bytedance.android.live.revenuelink.connect.f r7 = com.bytedance.android.live.revlink.impl.global.b.a();
        if (r7 == null) goto L24;
        LiveData<ey.f> r8 = r7.connectState();
        if (r8 == null) goto L24;
        ey.f r9 = (ey.f) r8.getValue();
    L25:
        Iterator<String> r13 = r12.iterator();
    L27:
        if (r13.hasNext() == false) goto L99;
        String r10 = r13.next();
        if (Intrinsics.areEqual(r10, "is_matching") == true) goto L30;
        if (Intrinsics.areEqual(r10, "match_type") == true) goto L39;
        if (Intrinsics.areEqual(r10, "invite_type") == true) goto L52;
        if (Intrinsics.areEqual(r10, "linkmic_list") == true) goto L65;
        if (Intrinsics.areEqual(r10, "linkmic_score") == false) goto L27;
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L97
        Gson r15 = GsonHelper.get();     // Catch: Throwable -> L97
        ProfitInteractionDataContext r16 = com.bytedance.android.live.revlink.impl.global.b.X();     // Catch: Throwable -> L97
        if (r16 == null) goto L94;
        com.bytedance.live.datacontext.n<c8> r17 = r16.getCurrentMessage();     // Catch: Throwable -> L97
        if (r17 == null) goto L94;
        c8 r18 = (c8) r17.getValue();     // Catch: Throwable -> L97
    L95:
        Result.constructor-impl(r0.put(r10, r15.toJson(r18)));     // Catch: Throwable -> L97
    L94:
        r18 = null;
    L97:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L65:
        ArrayList r20 = new ArrayList();
        if (r9 != null) goto L68;
    L81:
        com.bytedance.android.live.revlink.impl.pk.service.b r22 = com.bytedance.android.live.revlink.impl.global.b.N();
        if (r22 == null) goto L86;
        List<com.bytedance.android.livesdk.link.model.p> r23 = r22.getCurrentAnchorList();
        if (r23 == null) goto L86;
        r20.addAll(r23);
    L86:
        r0.put(r10, GsonProtectorUtils.toJson(GsonHelper.get(), r20));
        goto L27
    L68:
        if (r9.b != 7) goto L81;
        com.bytedance.android.live.revlink.impl.global.c r24 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r24 == null) goto L72;
        LinkRevInternalServiceContext r25 = r24.Cj();
    L73:
        if (r25 == null) goto L86;
        com.bytedance.live.datacontext.j<AnchorLinkUserCenterV2> r26 = r25.getLinkUserCenter();
        if (r26 == null) goto L86;
        AnchorLinkUserCenterV2 r27 = (AnchorLinkUserCenterV2) r26.getValue();
        if (r27 == null) goto L86;
        List<com.bytedance.android.livesdk.link.model.p> r28 = r27.d();
        if (r28 == null) goto L86;
        r20.addAll(r28);
        goto L86
    L72:
        r25 = null;
        goto L73
    L52:
        if (r9 == null) goto L59;
        if (r9.b != 7) goto L59;
        if (r6 == null) goto L57;
        String r29 = String.valueOf(r6.b);
    L58:
        r0.put(r10, r29);
        goto L27
    L57:
        r29 = null;
    L59:
        if (r4 == null) goto L61;
        String r30 = String.valueOf(r4.b);
    L62:
        r0.put(r10, r30);
        goto L27
    L61:
        r30 = null;
        goto L62
    L39:
        if (r9 == null) goto L46;
        if (r9.b != 7) goto L46;
        if (r6 == null) goto L44;
        String r32 = String.valueOf(r6.a);
    L45:
        r0.put(r10, r32);
        goto L27
    L44:
        r32 = null;
    L46:
        if (r4 == null) goto L48;
        String r33 = String.valueOf(r4.a);
    L49:
        r0.put(r10, r33);
        goto L27
    L48:
        r33 = null;
        goto L49
    L30:
        i41.a r34 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r34 != null) goto L33;
    L35:
        String r35 = DataType.FALSE;
    L36:
        r0.put(r10, r35);
        goto L27
    L33:
        if (r34.f != true) goto L35;
        r35 = DataType.TRUE;
        goto L36
    L99:
        return r0;
    L24:
        r9 = null;
        goto L25
    L18:
        r6 = null;
        goto L19
    L14:
        r4 = null;
        goto L15
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.b
    public final boolean k0(int r2) {
        return gd0.v.a(this.j, r2);
    }

    public final void onChanged(Object r2) {
        KVData r3 = (KVData) r2;
        if (isViewValid() == false) goto L7;
        if (r3 == null) goto L8;
        r3.getData();
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.b
    public final void onMultiAnchorStateChange(int r2) {
        this.i.onMultiAnchorStateChange(r2);
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.b
    public final void onPrecisionMatchEvent(int r2) {
        com.bytedance.android.live.revlink.impl.pk.service.e r0 = com.bytedance.android.live.revlink.impl.global.b.Q();
        if (r0 == null) goto L6;
        r0.onPrecisionMatchEvent(r2);
        return;
    }

    public final void onSei(String r13) {
        Intrinsics.checkNotNullParameter(r13, "sei");
        int r0 = 0;
    L94:
        e = move-exception;
        JSONObject r1 = new JSONObject();
        String r2 = e.getMessage();
        if (r2 != null) goto L98;
        r2 = "";
    L98:
        r1.put("message", r2);
        StringBuilder r3 = new StringBuilder();
        StackTraceElement[] r14 = e.getStackTrace();
        int r4 = r14.length;
    L99:
        if (r0 >= r4) goto L106;
        StackTraceElement r5 = r14[r0];
        if (r5 == null) goto L104;
        String r6 = r5.toString();
        if (r6 == null) goto L104;
    L105:
        r3.append(r6);
        r3.append("\n");
        r0 = r0 + 1;
    L104:
        r6 = "";
        goto L105
    L106:
        r1.put("trace", r3.toString());
        com.bytedance.android.live.revenuelink.f r15 = com.bytedance.android.live.revlink.impl.global.b.g0();
        if (r15 == null) goto L122;
        r15.b0("on_sei_error", LiveTracingMonitorKt.EventModule.PK, r1);
        return;
    L122:
        return;
    L4:
        if (this.E == false) goto L7;
        return;
    L7:
        if (gd0.v.a(this.j, 4) == false) goto L14;
        if (com.bytedance.android.live.revlink.impl.settings.live.c.D.a() == false) goto L14;
        RevLinkAudienceWidget r7 = this.g;     // Catch: Exception -> L94
        if (r7 == null) goto L14;
        r7.wq();     // Catch: Exception -> L94
    L14:
        if (gd0.v.a(this.j, 64) == true) goto L16;
    L20:
        com.bytedance.android.live.revlink.impl.settings.live.c r8 = com.bytedance.android.live.revlink.impl.settings.live.c.D;     // Catch: Exception -> L94
        r8.getClass();     // Catch: Exception -> L94
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.c.l.getValue(r8, com.bytedance.android.live.revlink.impl.settings.live.c.a[10])).booleanValue() == true) goto L23;
    L58:
        String r9 = r13;
    L60:
        if (TextUtils.equals(r9, this.o) == false) goto L64;
        com.bytedance.android.live.revlink.impl.settings.live.c r10 = com.bytedance.android.live.revlink.impl.settings.live.c.D;     // Catch: Exception -> L94
        r10.getClass();     // Catch: Exception -> L94
        if (((Boolean) com.bytedance.android.live.revlink.impl.settings.live.c.i.getValue(r10, com.bytedance.android.live.revlink.impl.settings.live.c.a[7])).booleanValue() == false) goto L64;
        return;
    L64:
        int r12 = com.bytedance.android.live.revenue.common.v.a;     // Catch: Exception -> L94
        com.bytedance.android.live.revenue.common.v.e("LinkRevControlWidget", "onSei mode=" + this.j + ' ' + r13);     // Catch: Exception -> L94
        if (gd0.v.a(this.j, 4) == false) goto L76;
        this.o = r9;     // Catch: Exception -> L94
        RevLinkAudienceWidget r16 = this.g;     // Catch: Exception -> L94
        if (r16 == null) goto L76;
        RevLinkAudienceFacade r17 = r16.a;     // Catch: Exception -> L94
        if (r17 == null) goto L76;
        RevSeiFrame r18 = RevSeiFrame.a.a(RevSeiFrame.G, r13, false, 4);     // Catch: Exception -> L94
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h r19 = r17.a;     // Catch: Exception -> L94
        if (r19 == null) goto L76;
        NextLiveData<RevSeiFrame> r20 = r19.a;     // Catch: Exception -> L94
        if (r20 == null) goto L76;
        r20.setValue(r18);     // Catch: Exception -> L94
    L76:
        if (gd0.v.a(this.j, 64) == false) goto L87;
        this.o = r9;     // Catch: Exception -> L94
        RevLinkAudienceWidget r22 = this.g;     // Catch: Exception -> L94
        if (r22 == null) goto L87;
        RevLinkAudienceFacade r23 = r22.a;     // Catch: Exception -> L94
        if (r23 == null) goto L87;
        RevSeiFrame r24 = RevSeiFrame.a.a(RevSeiFrame.G, r13, false, 4);     // Catch: Exception -> L94
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h r25 = r23.a;     // Catch: Exception -> L94
        if (r25 == null) goto L87;
        NextLiveData<RevSeiFrame> r26 = r25.a;     // Catch: Exception -> L94
        if (r26 == null) goto L87;
        r26.setValue(r24);     // Catch: Exception -> L94
    L87:
        if (this.m != null) goto L89;
        return;
    L89:
        if (d51.b.m.a() == false) goto L120;
        LinkCheckLoadUtils r27 = this.m;     // Catch: Exception -> L94
        if (r27 == null) goto L121;
        r27.b(r13);     // Catch: Exception -> L94
        return;
    L121:
        return;
    L120:
        return;
    L23:
        if (z41.d.c.a9() == false) goto L58;
        r9 = null;
        if (StringsKt.contains$default(r13, "TTLiveSDK_", false, 2, null) == false) goto L27;
        r9 = r13;
    L56:
        if (r9 != null) goto L60;
        return;
    L27:
        int r28 = StringsKt.indexOf$default(r13, "app_data", 0, false, 6, null);     // Catch: Exception -> L94
        if (r28 == (-1)) goto L56;
        int r29 = r13.length();     // Catch: Exception -> L94
    L32:
        if (r28 >= r29) goto L36;
        if (r13.charAt(r28) == '{') goto L36;
        r28 = r28 + 1;     // Catch: Exception -> L94
    L36:
        if (r28 < r29) goto L38;
    L40:
        int r30 = -1;
    L41:
        if (r30 == (-1)) goto L56;
        int r32 = 0;
    L44:
        if (r28 >= r29) goto L54;
        if (r13.charAt(r28) != '{') goto L49;
        r32 = r32 + 1;     // Catch: Exception -> L94
    L51:
        if (r32 == 0) goto L54;
        r28 = r28 + 1;     // Catch: Exception -> L94
        goto L44
    L49:
        if (r13.charAt(r28) != '}') goto L51;
        r32 = r32 - 1;     // Catch: Exception -> L94
    L54:
        if (r32 != 0) goto L56;
        r9 = r13.substring(r30, r28 + 1);     // Catch: Exception -> L94
        goto L56
    L38:
        if (r13.charAt(r28) != '{') goto L40;
        r30 = r28;
        goto L41
    L16:
        if (com.bytedance.android.live.revlink.impl.settings.live.c.D.a() == false) goto L20;
        RevLinkAudienceWidget r33 = this.g;     // Catch: Exception -> L94
        if (r33 == null) goto L20;
        r33.wq();     // Catch: Exception -> L94
        goto L20
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.b
    public final void startSwitchPk(com.bytedance.android.live.revlink.impl.mergepk.pkdouble.g r2) {
        com.bytedance.android.live.revlink.impl.multianchor.service.b r0 = com.bytedance.android.live.revlink.impl.global.b.w();
        if (r0 == null) goto L6;
        r0.startSwitchPk(r2);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.a
    public final void unLoadOtherWidget(int r2) {
        if (r2 != 2) goto L10;
        lr2.a r3 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), lr2.a.class);
        if (r3 != null) goto L7;
        return;
    L7:
        if (r3.isPaidLive() != true) goto L18;
        this.i.y(0.34f);
        return;
    L18:
        return;
    L10:
        if (r2 != 32) goto L20;
        lr2.a r4 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), lr2.a.class);
        if (r4 != null) goto L14;
        return;
    L14:
        if (r4.isPaidLive() == true) goto L22;
        this.i.y(1.0f);
        return;
    L22:
        return;
    }

    public static void wq(RevLinkDialog r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "LinkDialog", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "LinkDialog");
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.b
    public final void Gp(int r23, RevLinkSwitchExtraContext r24) {
        jy0.b.c("ttlive_anchor_link", "switchMode " + r23 + " " + gd0.v.a(this.j, r23) + " " + this.j + " allMode=" + vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getMultiLinkScene(), null, 4);
        if (gd0.v.a(this.j, r23) == false) goto L6;
        jy0.b.d("ttlive_anchor_linkLinkRevControlWidget", "duplicate switchMode " + this.j + " target=" + r23);
        return;
    L6:
        int r3 = this.j;
        if (r3 == 0) goto L10;
        this.p.a(r3, r23);
    L10:
        if (r23 == 4) goto L12;
        if (r23 == 64) goto L12;
    L15:
        int r7 = this.j | r23;
        this.j = r7;
        this.y.j(r7);
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).xf(this.j);
        jy0.b.c("switch", "target: " + r23 + " ,current:" + this.j, null, 4);
        if (r23 == 4) goto L20;
        if (r23 == 64) goto L20;
        if (r23 == 128) goto L20;
    L23:
        boolean r8 = false;
        if (this.E == true) goto L26;
    L44:
        sc0.a r9 = r24.a;
        if ((r9 instanceof com.bytedance.android.live.revlink.impl.control.launchcontext.a) == true) goto L47;
        r9 = null;
    L47:
        com.bytedance.android.live.revlink.impl.control.launchcontext.a r10 = (com.bytedance.android.live.revlink.impl.control.launchcontext.a) r9;
        if (r10 == null) goto L50;
        f21.a r12 = r10.b;
    L51:
        if (r23 != 64) goto L56;
        if (r12 == null) goto L56;
        if (r12.f != true) goto L56;
        boolean r13 = true;
    L57:
        jy0.b.f("ttlive_anchor_link", "switchOtherMode " + r23 + ", pkSwitchLink=" + r13 + "  " + r12, null, 4);
        com.bytedance.android.livesdk.revenue.service.interact.d r4 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class);
        if (r13 == false) goto L62;
        d51.b r5 = d51.b.m;
        r5.getClass();
        if (((Boolean) d51.b.i.getValue(r5, d51.b.a[7])).booleanValue() == false) goto L62;
        r8 = true;
    L62:
        r4.a5(r23, r8);
        if (r23 != 4) goto L80;
        PkCancelMatchDialog r0 = this.h;
        if (r0 != null) goto L67;
    L76:
        com.bytedance.android.live.revlink.impl.pk.service.a r1 = com.bytedance.android.live.revlink.impl.global.b.M();
        if (r1 == null) goto L79;
        r1.dismissDialog();
    L79:
        yq();
        this.G = SystemClock.elapsedRealtime();
        Cq(r24);
        return;
    L67:
        if (r0.isShowing() != true) goto L76;
        PkCancelMatchDialog r2 = this.h;
        if (r2 == null) goto L76;
        r2.dismiss();     // Catch: Exception -> L72
    L72:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L76;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L76
    L80:
        if (r23 != 64) goto L105;
        i41.a r14 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r14 == null) goto L84;
        r14.b(AutoMatchSource.Manual);
    L84:
        Bq(r24);
        ld.a r15 = ld.d.a();
        if (r15 == null) goto L89;
        NextLiveData r16 = r15.A6();
        if (r16 == null) goto L89;
        r16.setValue(Boolean.TRUE);
    L89:
        wq2.f r17 = ma1.a.a();
        if (r17 == null) goto L92;
        r17.U1(true);
    L92:
        a r18 = O;
        boolean r19 = this.E;
        r18.getClass();
        a.a("multi_linker", r19);
        this.i.onMultiAnchorStateChange(2);
        if (this.c == null) goto L106;
        LinkRevPanelDataContext r20 = LinkRevPanelDataContext.Companion.getContext();
        if (r20 == null) goto L107;
        com.bytedance.live.datacontext.j<com.bytedance.android.live.revlink.impl.control.dialog.b> r22 = r20.getLoader();
        if (r22 == null) goto L108;
        com.bytedance.android.live.revlink.impl.control.dialog.b r25 = (com.bytedance.android.live.revlink.impl.control.dialog.b) r22.getValue();
        if (r25 == null) goto L109;
        r25.o();
        return;
    L109:
        return;
    L108:
        return;
    L107:
        return;
    L106:
        return;
    L105:
        return;
    L56:
        r13 = false;
        goto L57
    L50:
        r12 = null;
        goto L51
    L26:
        if (this.l == null) goto L44;
        int r26 = com.bytedance.android.live.revlink.impl.pk.utils.p.a;
        if (com.bytedance.android.live.revlink.impl.pk.utils.p.a(this.B) == false) goto L31;
        if (r23 != 4) goto L31;
        boolean r27 = true;
    L32:
        IPKLinkBizDataService r110 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r110 == null) goto L35;
        r110.setIsRandomReMatch(true);
    L35:
        if (r27 == true) goto L44;
        gt1.d r28 = gt1.e.a(1, Boolean.FALSE, false, false, false, false, 0, false, false, null, 2044);
        ld.a r111 = ld.d.a();
        if (r111 == null) goto L41;
        NextLiveData r112 = r111.Y1();
        if (r112 == null) goto L41;
        r112.setValue(r28);
    L41:
        wq2.f r113 = ma1.a.a();
        if (r113 == null) goto L44;
        r113.S1(r28);
    L31:
        r27 = false;
    L20:
        wq2.f r29 = ma1.a.a();
        if (r29 == null) goto L23;
        r29.ha();
    L12:
        wq2.f r30 = ma1.a.a();
        if (r30 == null) goto L15;
        r30.ha();
        goto L15
    }

    public final void Lq(int r13, s r14) {
        com.bytedance.tools.kcp.spongepreference.runtime.a r0 = l51.a.G;
        KProperty[] r1 = l51.a.a;
        if (((Boolean) r0.getValue(null, r1[32])).booleanValue() == false) goto L5;
    L14:
        int r2 = 0;
        if (com.bytedance.android.live.revlink.impl.global.b.c0() == null) goto L17;
        int r3 = d31.d.n();
    L18:
        LinkCrossRoomDataHolder r4 = com.bytedance.android.live.revlink.impl.global.b.j();
        HashMap r5 = new HashMap();
        w31.c r6 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r6 == null) goto L21;
        Map<String, String> r7 = r6.f();
    L22:
        r5.putAll(r7);
        String r8 = "";
        if (com.bytedance.android.live.revlink.impl.global.b.z() == null) goto L35;
        com.bytedance.android.live.revlink.impl.multianchor.service.d r9 = com.bytedance.android.live.revlink.impl.global.b.z();
        if (r9 == null) goto L29;
        i11.b r10 = r9.getLinkUserCenter();
        if (r10 == null) goto L29;
        Integer r12 = Integer.valueOf(r10.c());
    L30:
        if (r12 == null) goto L33;
        String r15 = String.valueOf(r12.intValue());
        if (r15 == null) goto L33;
    L34:
        r5.put("anchor_connect_status", r15);
    L33:
        r15 = "";
    L29:
        r12 = null;
    L35:
        w31.c r16 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r16 == null) goto L38;
        IRoom r17 = r16.k();
    L39:
        int r18 = 1;
        if (r17 == null) goto L47;
        if (r4 == null) goto L47;
        if (r4.i() != 0) goto L47;
        if (r4.f() != 11) goto L47;
        r5.put("room_status", "best_invite_matching");
    L102:
        if (gd0.v.a(vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getMultiInteractMode(), 32) == false) goto L106;
        dq2.w r19 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).M1();
        if (r19 == null) goto L106;
        int r20 = r19.w();
    L107:
        r5.put("audience_connect_cnt", String.valueOf(r20));
        w31.c r22 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r22 == null) goto L110;
        Long r23 = Long.valueOf(r22.i());
    L111:
        r5.put("pk_id", String.valueOf(r23));
        r5.put("icon_type", zq());
        r5.put("words_type", Aq());
        IRoom r24 = this.B;
        if (r24 == null) goto L114;
        LiveMode r25 = r24.getStreamType();
    L116:
        if (r25 != LiveMode.SCREEN_RECORD) goto L118;
        String r26 = DataType.TRUE;
    L119:
        r5.put("is_game", r26);
        mz0.n r27 = new mz0.n();
        Map<String, String> r28 = r27.a;
        Intrinsics.checkNotNullParameter(r28, "map");
        Intrinsics.checkNotNullParameter(r5, "map");
        r28.putAll(r5);
        mz0.m r29 = new mz0.m();
        r29.b(LogCommon.ROOM);
        ((ArrayList) r27.b).addAll(r29.a);
        cy0.e.a.getClass();
        cy0.j r30 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r32 = com.bytedance.android.scope.m.b(r30).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r32);
        ((mz0.i) ((f80.a) r32)).w3("livesdk_interact_icon_click", r27.a, r27.b);
        IPKLinkBizDataService r33 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r33 == null) goto L122;
        r33.setIsRandomReMatch(false);
    L122:
        com.bytedance.android.live.revlink.impl.pk.service.e r34 = com.bytedance.android.live.revlink.impl.global.b.Q();
        if (r34 != null) goto L125;
    L128:
        com.bytedance.android.live.revlink.impl.pk.service.e r35 = com.bytedance.android.live.revlink.impl.global.b.Q();
        if (r35 != null) goto L131;
    L140:
        i41.a r36 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r36 != null) goto L143;
    L152:
        com.bytedance.android.live.revlink.impl.multianchor.match.a r37 = com.bytedance.android.live.revlink.impl.global.b.I();
        if (r37 != null) goto L155;
    L160:
        w31.c r38 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r38 != null) goto L163;
    L184:
        b51.b r39 = b51.b.c0;
        r39.getClass();
        ReadOnlyProperty r40 = b51.b.B;
        KProperty[] r110 = b51.b.a;
        if (((Boolean) r40.getValue(r39, r110[26])).booleanValue() == false) goto L210;
        String r42 = (String) b51.b.C.getValue(r39, r110[27]);
        if (TextUtils.isEmpty(r42) == true) goto L210;
        x0 r111 = new x0(r42);
        x0 r112 = r111.d("url");
        IRoom r43 = this.B;
        if (r43 == null) goto L191;
        Long r44 = Long.valueOf(r43.getRoomId());
    L192:
        r112.b("room_id", String.valueOf(r44));
        IBaseUser r45 = com.bytedance.android.live.revenue.core.util.e.a(com.bytedance.android.livesdk.revenue.service.user.a.class).b();     // Catch: Exception -> L203
        if (r45 == null) goto L205;
        py.k r46 = r45.getAvatarThumbKt();     // Catch: Exception -> L203
        if (r46 == null) goto L205;
        List r47 = r46.getUrls();     // Catch: Exception -> L203
        if (r47 == null) goto L205;
        String r48 = (String) ListProtector.get(r47, 0);     // Catch: Exception -> L203
        if (r48 == null) goto L205;
        r8 = r48;
    L205:
        r112.b("business_type", r41.b.a());
        r112.b("group", r41.b.a());
        r112.b("anchor_avatar", r8);
        HybridDialogImpl r113 = ((vy0.b) com.bytedance.android.live.revenue.core.util.f.a(vy0.c.class)).U0(((Widget) this).context, r111.c(), null);
        this.r = r113;
        if (r113 == null) goto L274;
        r113.j0(new LinkRevControlWidget$startPk$6(this));
        return;
    L274:
        return;
    L203:
        e = move-exception;
        ALogger.e("[Revlink] pk panel load", e);
        goto L205
    L191:
        r44 = null;
    L210:
        if (this.i.v == 0) goto L224;
        jy0.b.c("LinkRevControlWidget", "livesdk_pk_icon_click multiAnchorState = " + this.i.v + " mCurrentMode = " + this.j, null, 4);
        DataCenter r114 = ((Widget) this).dataCenter;
        int r115 = RevLinkDialog.x;
        RevLinkDialog.a r116 = new RevLinkDialog.a(r114, this);
        KProperty[] r117 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        r116.g = 0;
        this.q = r116.b(10);
        Kq(null);
        d51.c r118 = d51.c.A0;
        r118.getClass();
        if (((Boolean) d51.c.E.getValue(r118, d51.c.a[29])).booleanValue() == false) goto L216;
        int r119 = com.bytedance.android.live.revlink.impl.control.dialog.b.r;
        com.bytedance.android.live.revlink.impl.control.dialog.b r120 = com.bytedance.android.live.revlink.impl.control.dialog.b.a.b();
        if (r120 == null) goto L216;
        r120.m();
    L216:
        RevLinkDialog r121 = this.q;
        if (r121 == null) goto L223;
        FragmentActivity r122 = ((Widget) this).context;
        if (r122 == null) goto L222;
        wq(r121, r122.getSupportFragmentManager());
        return;
    L222:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L223:
        return;
    L224:
        i41.a r49 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r49 != null) goto L227;
    L237:
        int r50 = com.bytedance.android.live.revlink.impl.control.dialog.b.r;
        com.bytedance.android.live.revlink.impl.control.dialog.b r52 = com.bytedance.android.live.revlink.impl.control.dialog.b.a.b();
        if (r52 == null) goto L241;
        r52.m();
    L241:
        if (isViewValid() == true) goto L243;
        return;
    L243:
        RevLinkDialog r53 = this.q;
        if (r53 != null) goto L246;
    L247:
        DataCenter r54 = ((Widget) this).dataCenter;
        int r55 = RevLinkDialog.x;
        RevLinkDialog.a r56 = new RevLinkDialog.a(r54, this);
        r56.h = this.w;
        if (r13 != 7) goto L250;
        KProperty[] r123 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        r18 = 0;
    L251:
        r56.g = r18;
        RevLinkDialog r124 = r56.b(10);
        this.q = r124;
        this.w = false;
        FragmentActivity r57 = ((Widget) this).context;
        if (r57 == null) goto L260;
        wq(r124, r57.getSupportFragmentManager());
    L254:
        RevLinkDialog r125 = this.q;
        if (r125 == null) goto L257;
        r125.setOnDismissListener(new p(r14));
    L257:
        Kq(new q(r14));
        return;
    L260:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L250:
        KProperty[] r126 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        goto L251
    L246:
        if (r53.isVisible() == true) goto L254;
    L227:
        if (r49.f != true) goto L237;
        DataCenter r58 = ((Widget) this).dataCenter;
        int r59 = RevLinkDialog.x;
        RevLinkDialog.a r60 = new RevLinkDialog.a(r58, this);
        if (r13 != 7) goto L231;
        KProperty[] r127 = com.bytedance.android.live.revlink.impl.behavior.o.a;
    L232:
        r60.g = r2;
        RevLinkDialog r128 = r60.b(10);
        this.q = r128;
        FragmentActivity r62 = ((Widget) this).context;
        if (r62 == null) goto L236;
        wq(r128, r62.getSupportFragmentManager());
        goto L254
    L236:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L231:
        KProperty[] r129 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        r2 = 1;
        goto L232
    L163:
        if (r38.p() != true) goto L184;
        w31.c r63 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r63 == null) goto L184;
        IPKLinkBizDataService r64 = r63.g();
        if (r64 == null) goto L169;
        com.bytedance.android.live.revlink.impl.pk.vm.linkout.n r65 = r64.getPkConnectContext();
    L170:
        if (r65 == null) goto L184;
        if (r65.a == true) goto L184;
        PkCancelMatchDialog r130 = new PkCancelMatchDialog();
        FragmentActivity r66 = ContextUtil.contextToFragmentActivity(getContext());
        if (r66 == null) goto L182;
        FragmentManager r67 = r66.getSupportFragmentManager();
        if (r67 == null) goto L182;
        LandscapeRestrictionOperation r68 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r130, "PkCancelMatchDialog", r68);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r67, r130, r68) == true) goto L182;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L261
    L181:
        r130.show(r67, "PkCancelMatchDialog");
    L182:
        this.h = r130;
        r130.setOnDismissListener(new o(r14));
        return;
    L169:
        r65 = null;
        goto L170
    L155:
        if (r37.po() != true) goto L160;
        jy0.b.a("LinkRevControlWidget", "startNewDialog");
        com.bytedance.android.live.revlink.impl.multianchor.match.a r131 = com.bytedance.android.live.revlink.impl.global.b.I();
        if (r131 == null) goto L273;
        r131.Wd();
        return;
    L273:
        return;
    L143:
        if (r36.f != true) goto L152;
        if (com.bytedance.android.live.revlink.impl.global.b.M() == null) goto L270;
        com.bytedance.android.live.revlink.impl.pk.service.a r132 = com.bytedance.android.live.revlink.impl.global.b.M();     // Catch: Exception -> L150
        if (r132 == null) goto L271;
        r132.c(r14);     // Catch: Exception -> L150
        return;
    L271:
        return;
    L150:
        jy0.b.c("LinkRevControlWidget", "PKAutoMatch handleToolbarPkClick error", null, 4);
        return;
    L270:
        return;
    L131:
        if (r35.isMatchingCount() != true) goto L140;
        DataCenter r133 = ((Widget) this).dataCenter;
        int r69 = RevLinkDialog.x;
        RevLinkDialog r134 = new RevLinkDialog.a(r133, this).b(13);
        this.q = r134;
        FragmentActivity r70 = ((Widget) this).context;
        if (r70 == null) goto L139;
        wq(r134, r70.getSupportFragmentManager());
        RevLinkDialog r135 = this.q;
        if (r135 == null) goto L269;
        r135.setOnDismissListener(new n(r14));
        return;
    L269:
        return;
    L139:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L125:
        if (r34.isMatchWaiting() != true) goto L128;
        ToastUtil.a(2131917916, 0);
        return;
    L118:
        r26 = DataType.FALSE;
        goto L119
    L114:
        r25 = null;
        goto L116
    L110:
        r23 = null;
    L106:
        r20 = 0;
    L47:
        com.bytedance.android.live.revlink.impl.multianchor.match.a r72 = com.bytedance.android.live.revlink.impl.global.b.I();
        if (r72 != null) goto L50;
    L77:
        i41.a r73 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r73 != null) goto L80;
    L93:
        i41.a r74 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r74 != null) goto L96;
    L98:
        if (r3 <= 0) goto L100;
        r5.put("room_status", "audience_connection");
        goto L102
    L100:
        r5.put("room_status", "live");
        goto L102
    L96:
        if (r74.f != true) goto L98;
        r5.put("room_status", "random_2pk_matching");
        goto L102
    L80:
        if (r73.f != true) goto L93;
        i41.a r75 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r75 == null) goto L84;
        String r76 = r75.g;
    L86:
        if (TextUtils.isEmpty(r76) == true) goto L93;
        r5.put("room_status", "cohost_game_matching");
        i41.a r77 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r77 == null) goto L91;
        String r78 = r77.g;
        if (r78 == null) goto L91;
    L92:
        r5.put("open_game_app_id", r78);
    L91:
        r78 = "";
        goto L92
    L84:
        r76 = null;
        goto L86
    L50:
        if (r72.po() != true) goto L77;
        MultiPkMatchContext r79 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r79 == null) goto L60;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.revlink.impl.multianchor.match.c> r80 = r79.getMatchStatus();
        if (r80 == null) goto L60;
        com.bytedance.android.live.revlink.impl.multianchor.match.c r82 = (com.bytedance.android.live.revlink.impl.multianchor.match.c) r80.getValue();
        if (r82 == null) goto L60;
        if (r82.b != 9) goto L60;
        r5.put("room_status", "random_2link_matching");
    L60:
        MultiPkMatchContext r83 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r83 == null) goto L68;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.revlink.impl.multianchor.match.c> r84 = r83.getMatchStatus();
        if (r84 == null) goto L68;
        com.bytedance.android.live.revlink.impl.multianchor.match.c r85 = (com.bytedance.android.live.revlink.impl.multianchor.match.c) r84.getValue();
        if (r85 == null) goto L68;
        if (r85.b != 11) goto L68;
    L76:
        r5.put("room_status", "random_nlink_matching");
    L68:
        MultiPkMatchContext r86 = com.bytedance.android.live.revlink.impl.global.b.G();
        if (r86 == null) goto L102;
        com.bytedance.live.datacontext.m<com.bytedance.android.live.revlink.impl.multianchor.match.c> r87 = r86.getMatchStatus();
        if (r87 == null) goto L102;
        com.bytedance.android.live.revlink.impl.multianchor.match.c r88 = (com.bytedance.android.live.revlink.impl.multianchor.match.c) r87.getValue();
        if (r88 == null) goto L102;
        if (r88.b != 10) goto L102;
    L38:
        r17 = null;
        goto L39
    L21:
        r7 = MapsKt.emptyMap();
        goto L22
    L17:
        r3 = 0;
        goto L18
    L5:
        if (Build.VERSION.SDK_INT < 31) goto L14;
        if (m60.c.d(((Widget) this).context, new String[]{"android.permission.BLUETOOTH_CONNECT"}) == true) goto L14;
        f51.a r89 = f51.a.e;
        r89.getClass();
        if (((Boolean) f51.a.d.getValue(r89, f51.a.a[2])).booleanValue() == false) goto L14;
        r0.setValue(null, r1[32], Boolean.TRUE);
        Activity r90 = ContextUtil.contextToActivity(((Widget) this).context);
        if (r90 == null) goto L268;
        SettingKey r92 = m60.i.a;
        m60.i.b r93 = new m60.i.b(r90);
        r93.d = l.a;
        r93.e = m.a;
        r93.b(new k(this, r13, r14), null, m60.i.b, new String[]{"android.permission.BLUETOOTH_CONNECT"});
        return;
    }

    public final void Mq(int r3, boolean r4) {
        if (r4 == true) goto L17;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).xf(this.j);
        z41.g r5 = z41.g.o;
        r5.getClass();
        if (((Boolean) z41.g.n.getValue(r5, z41.g.a[12])).booleanValue() == false) goto L11;
        com.bytedance.android.live.revlink.impl.b r6 = this.L;
        if (r6 == null) goto L8;
        r6.a(this.f);
    L8:
        com.bytedance.android.live.revlink.impl.b r7 = this.L;
        if (r7 == null) goto L12;
        r7.a(this.g);
    L12:
        this.f = null;
        this.g = null;
        MultiLinkAnchorControlService r8 = this.d;
        if (r8 == null) goto L46;
        r8.G = null;
        return;
    L46:
        return;
    L11:
        ((Widget) this).subWidgetManager.unload(this.f);
        ((Widget) this).subWidgetManager.unload(this.g);
        goto L12
    L17:
        if (r3 != 4) goto L19;
        int r9 = 1;
    L23:
        RevLinkAnchorWidget r10 = this.f;
        if (r10 == null) goto L34;
        com.bytedance.android.live.revlink.widgetservice.a r12 = r10.b;
        if (r12 == null) goto L34;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.g r13 = r12.b;
        if (r13 == null) goto L34;
        RevLinkBizContext r14 = r13.d;
        if (r14 == null) goto L34;
        PublishSubject<Integer> r15 = r14.f;
        if (r15 == null) goto L34;
        r15.onNext(Integer.valueOf(r9));
    L34:
        RevLinkAudienceWidget r16 = this.g;
        if (r16 == null) goto L47;
        RevLinkAudienceFacade r17 = r16.a;
        if (r17 == null) goto L48;
        com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h r18 = r17.a;
        if (r18 == null) goto L49;
        RevLinkBizContext r19 = r18.d;
        if (r19 == null) goto L50;
        PublishSubject<Integer> r20 = r19.f;
        if (r20 == null) goto L51;
        r20.onNext(Integer.valueOf(r9));
        return;
    L51:
        return;
    L50:
        return;
    L49:
        return;
    L48:
        return;
    L47:
        return;
    L19:
        if (r3 == 64) goto L21;
        return;
    L21:
        r9 = 7;
        goto L23
    }

    public LinkRevControlWidget(RevLinkService.b r3, ViewGroup r4, boolean r5) {
        this.L = r3;
        this.M = r4;
        this.N = r5;
        this.b = new EnterRoomLinkInfoChecker(ld.d.a(), com.bytedance.android.live.revlink.impl.global.b.k());
        this.i = new ToolbarPkBehavior(this, this);
        this.p = new com.bytedance.android.live.revlink.impl.utils.i(com.bytedance.android.live.revlink.impl.global.b.k(), this);
        this.v = new EnterRoomFirstSeiChecker(ld.d.a(), com.bytedance.android.live.revlink.impl.global.b.k());
        kc0.e r6 = ((ILinkService) com.bytedance.android.live.revenue.core.util.f.a(ILinkService.class)).getRevLinkControlService();
        this.y = r6;
        this.z = new com.bytedance.android.live.revlink.impl.control.p(this);
        this.F = new CompositeDisposable();
        this.I = "settings";
        if (com.bytedance.android.live.revlink.impl.global.b.S() == null) goto L5;
        i97.a r7 = i97.a.a;
        System.currentTimeMillis();
    L5:
        com.bytedance.android.live.revlink.impl.global.c r8 = com.bytedance.android.live.revlink.impl.global.b.k();
        if (r8 == null) goto L8;
        MultiEnterRoomTracer r9 = r8.i7();
    L9:
        if (r9 == null) goto L11;
        i97.a r10 = i97.a.a;
        r9.e = System.currentTimeMillis();
    L11:
        r6.j(0);
        return;
    L8:
        r9 = null;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.behavior.ToolbarPkBehavior.b
    public final void Ne(int r13, com.bytedance.android.live.revlink.impl.behavior.u r14, boolean r15) {
        this.w = r15;
        DataCenter r16 = ((Widget) this).dataCenter;
        Boolean r1 = Boolean.FALSE;
        boolean r0 = false;
        if (Intrinsics.areEqual((Boolean) r16.get("data_live_picture_presentation_show", r1), Boolean.TRUE) == false) goto L6;
        f2.c("该功能暂不支持与图片演示同时使用，请关闭图片演示后使用", 0);
        return;
    L6:
        ILiveExternalCameraServiceForOther r17 = jc1.k.f(ILiveExternalCameraServiceForOther.class);
        if (r17 != null) goto L9;
    L12:
        ILiveProDualDeviceServiceForOther r18 = jc1.k.f(ILiveProDualDeviceServiceForOther.class);
        if (r18 == null) goto L27;
        if (r18.isUsingLiveProPhoneCameraInBroadCast() != true) goto L27;
        ILiveExternalCameraServiceForOther r19 = jc1.k.f(ILiveExternalCameraServiceForOther.class);
        if (r19 == null) goto L27;
        if (r19.isConnected() == true) goto L27;
        ILiveProDualDeviceServiceForOther r110 = jc1.k.f(ILiveProDualDeviceServiceForOther.class);
        if (r110 == null) goto L27;
        if (r110.needDisableAbility("pk") != true) goto L27;
        ToastUtil.b("正在使用外接手机摄像头，暂不支持该功能", 0);
        return;
    L27:
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).cg(com.bytedance.android.livesdk.revenue.service.interact.c.a) != true) goto L30;
        return;
    L30:
        if (this.E == false) goto L43;
        com.bytedance.android.livesdk.revenue.service.room.c r111 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r111 == null) goto L40;
        com.bytedance.android.livesdk.revenue.room.a r112 = r111.getRoomContext();
        if (r112 == null) goto L40;
        com.bytedance.live.datacontext.m r113 = r112.isCasting();
        if (r113 == null) goto L40;
        Boolean r114 = (Boolean) r113.getValue();
        if (r114 == null) goto L40;
        boolean r115 = r114.booleanValue();
    L41:
        if (r115 == false) goto L43;
        boolean r116 = true;
    L44:
        if (r116 == false) goto L47;
        int r117 = ToastUtil.a;
        ToastUtil.b(s1.B(2131922199), 0);
        return;
    L47:
        ld.a r118 = ld.d.a();
        Object r4 = null;
        if (r118 == null) goto L52;
        NextLiveData r119 = r118.Dc();
        if (r119 == null) goto L52;
        Integer r120 = (Integer) r119.getValue();
    L54:
        if (r120 != null) goto L57;
    L58:
        if (r120 != null) goto L61;
    L63:
        boolean r121 = false;
    L65:
        if (r121 == false) goto L68;
        ToastUtil.a(2131922201, 0);
        return;
    L68:
        lr2.a r122 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), lr2.a.class);
        if (r122 != null) goto L71;
    L74:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r123 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r123 == null) goto L77;
        PkBaseStateMachine.c r124 = r123.getCurPKBaseState();
    L78:
        int r6 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getMultiInteractMode();
        HashMap r7 = new HashMap();
        ox0.a r8 = com.bytedance.android.live.revlink.impl.global.b.s();
        if (r8 == null) goto L81;
        Integer r9 = Integer.valueOf(r8.a());
    L82:
        r7.put("current_mode", String.valueOf(r9));
        if (r124 == null) goto L85;
        r7.put("pk_state", r124.c);
    L85:
        int r125 = com.bytedance.android.live.revenue.common.v.a;
        com.bytedance.android.live.revenue.common.v.f("ttlive_pk", r7);
        hq2.d r126 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class).ya();
        if (r126 != null) goto L88;
    L91:
        View r127 = this.l;
        if (r127 != null) goto L94;
    L110:
        d51.c r128 = d51.c.A0;
        if (r128.l() == true) goto L114;
        int r129 = ToastUtil.a;
        ToastUtil.b((String) d51.c.f.getValue(r128, d51.c.a[4]), 0);
        return;
    L114:
        IRoom r130 = this.B;
        if (r130 == null) goto L122;
        IRoomLinkExt r131 = (IRoomLinkExt) r130.castTo(IRoomLinkExt.class);
        if (r131 == null) goto L122;
        if (r131.getMosaicStatus() != 1) goto L122;
        ToastUtil.a(2131919663, 0);
        return;
    L122:
        com.bytedance.android.live.revlink.impl.precisefind.a r132 = com.bytedance.android.live.revlink.impl.global.b.K();
        if (r132 != null) goto L125;
    L130:
        ox0.a r133 = com.bytedance.android.live.revlink.impl.global.b.s();
        if (r133 == null) goto L136;
        if (r133.a() != 0) goto L136;
        Lq(r13, r14);
        return;
    L136:
        if (gd0.v.a(this.j, 64) == false) goto L146;
        RevLinkAnchorWidget r134 = this.f;
        if (r134 == null) goto L266;
        DialogLaunchService r135 = r134.d;
        if (r135 == null) goto L267;
        NextLiveData<Integer> r136 = r135.j;
        if (r136 == null) goto L268;
        r136.setValue(0);
        return;
    L268:
        return;
    L267:
        return;
    L266:
        return;
    L146:
        if (gd0.v.a(this.j, 4) == false) goto L230;
        HashMap r137 = new HashMap();
        if (com.bytedance.android.live.revlink.impl.global.b.c0() == null) goto L150;
        int r138 = d31.d.n();
    L151:
        w31.c r139 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r139 == null) goto L154;
        Map<String, String> r140 = r139.f();
    L155:
        r137.putAll(r140);
        r137.put("room_status", "2pk");
        if (com.bytedance.android.live.revlink.impl.multianchor.match.b.a(com.bytedance.android.live.revlink.impl.global.b.I()) == false) goto L158;
        r137.put("room_status", "random_npk_matching");
    L165:
        LinkCrossRoomDataHolder r141 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r141 == null) goto L168;
        Long r142 = Long.valueOf(r141.c());
    L169:
        r137.put("channel_id", String.valueOf(r142));
        r137.put("anchor_cnt", "2");
        r137.put("audience_connect_cnt", String.valueOf(vh6.c.b(qr2.c.class).H()));
        w31.c r143 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r143 == null) goto L172;
        Long r144 = Long.valueOf(r143.i());
    L173:
        r137.put("pk_id", String.valueOf(r144));
        r137.put("icon_type", zq());
        r137.put("words_type", Aq());
        IRoom r145 = this.B;
        if (r145 == null) goto L176;
        LiveMode r146 = r145.getStreamType();
    L178:
        if (r146 != LiveMode.SCREEN_RECORD) goto L180;
        String r147 = DataType.TRUE;
    L181:
        r137.put("is_game", r147);
        mz0.n r148 = new mz0.n();
        Map<String, String> r149 = r148.a;
        Intrinsics.checkNotNullParameter(r149, "map");
        Intrinsics.checkNotNullParameter(r137, "map");
        r149.putAll(r137);
        mz0.m r150 = new mz0.m();
        r150.b(LogCommon.ROOM);
        ((ArrayList) r148.b).addAll(r150.a);
        cy0.e.a.getClass();
        cy0.j r151 = cy0.e.a.a;
        com.bytedance.android.scope.m.e.getClass();
        Object r152 = com.bytedance.android.scope.m.b(r151).a(Reflection.getOrCreateKotlinClass(mz0.i.class));
        Intrinsics.checkNotNull(r152);
        ((mz0.i) ((f80.a) r152)).w3("livesdk_interact_icon_click", r148.a, r148.b);
        i11.b r153 = com.bytedance.android.live.revlink.impl.global.b.e();
        if (r153 == null) goto L184;
        List<i11.d> r154 = r153.s();
    L186:
        if (com.bytedance.android.live.revlink.impl.multianchor.match.b.a(com.bytedance.android.live.revlink.impl.global.b.I()) == false) goto L198;
        com.bytedance.android.live.revlink.impl.multianchor.match.a r155 = com.bytedance.android.live.revlink.impl.global.b.I();
        if (r155 != null) goto L190;
    L194:
        com.bytedance.android.live.revlink.impl.multianchor.service.c r156 = com.bytedance.android.live.revlink.impl.global.b.y();
        if (r156 == null) goto L271;
        r156.Da();
        return;
    L271:
        return;
    L190:
        if (r155.Yj() != true) goto L194;
        com.bytedance.android.live.revlink.impl.multianchor.service.c r157 = com.bytedance.android.live.revlink.impl.global.b.y();
        if (r157 == null) goto L269;
        r157.Hb();
        return;
    L269:
        return;
    L198:
        List<i11.d> r158 = r154;
        if (r158 != null) goto L201;
    L204:
        boolean r159 = true;
    L205:
        if (r159 == true) goto L222;
        Iterator<T> r160 = r154.iterator();
    L208:
        if (r160.hasNext() == false) goto L212;
        Object r161 = r160.next();
        if (Intrinsics.areEqual(((i11.d) r161).b, "team_pk_invite") == false) goto L208;
        r4 = r161;
    L212:
        if (r4 == null) goto L214;
        r0 = true;
    L214:
        if (r0 == false) goto L218;
        com.bytedance.android.live.revlink.impl.multianchor.service.c r162 = com.bytedance.android.live.revlink.impl.global.b.y();
        if (r162 == null) goto L272;
        r162.r6();
        return;
    L272:
        return;
    L218:
        com.bytedance.android.live.revlink.impl.multianchor.service.c r163 = com.bytedance.android.live.revlink.impl.global.b.y();
        if (r163 == null) goto L274;
        r163.Da();
        return;
    L274:
        return;
    L222:
        RevLinkAnchorWidget r164 = this.f;
        if (r164 == null) goto L276;
        DialogLaunchService r165 = r164.d;
        if (r165 == null) goto L277;
        NextLiveData<Integer> r166 = r165.j;
        if (r166 == null) goto L278;
        r166.setValue(0);
        return;
    L278:
        return;
    L277:
        return;
    L276:
        return;
    L201:
        if (r158.isEmpty() == true) goto L204;
        r159 = false;
        goto L205
    L184:
        r154 = null;
        goto L186
    L180:
        r147 = DataType.FALSE;
        goto L181
    L176:
        r146 = null;
        goto L178
    L172:
        r144 = null;
        goto L173
    L168:
        r142 = null;
        goto L169
    L158:
        com.bytedance.android.live.revlink.impl.mergepk.pkbase.e r2 = com.bytedance.android.live.revlink.impl.global.b.R();
        if (r2 != null) goto L161;
    L163:
        if (r138 <= 0) goto L165;
        r137.put("room_status", "audience_connection");
        goto L165
    L161:
        if (r2.isInBreakThrough() != true) goto L163;
        r137.put("room_status", "pve");
        goto L165
    L154:
        r140 = MapsKt.emptyMap();
        goto L155
    L150:
        r138 = 0;
        goto L151
    L230:
        if (gd0.v.a(r6, 32) == false) goto L247;
        oq2.c r167 = vh6.c.b(qr2.c.class).Qd();
        if (r167 != null) goto L234;
    L241:
        dq2.w r168 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).M1();
        if (r168 != null) goto L244;
        return;
    L244:
        if (r168.n() != true) goto L283;
        Lq(r13, r14);
        return;
    L283:
        return;
    L234:
        if (r167.a() == true) goto L241;
        if (vh6.c.b(qr2.c.class).Qd() != null) goto L238;
    L240:
        ToastUtil.a(2131922650, 0);
        return;
    L238:
        if (us1.b.c() != true) goto L240;
        ToastUtil.a(2131922651, 0);
        return;
    L247:
        if (gd0.v.a(r6, 2) == false) goto L255;
        dq2.p r169 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).getInteractAudienceService();
        if (r169 != null) goto L251;
    L253:
        Lq(r13, r14);
        return;
    L251:
        if (r169.a() != true) goto L253;
        ToastUtil.a(2131917812, 0);
        return;
    L255:
        if (gd0.v.a(r6, 8) == true) goto L257;
        return;
    L257:
        if (vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).O0() != 29) goto L259;
        ToastUtil.a(2131922649, 0);
        return;
    L259:
        ToastUtil.a(2131922647, 0);
        return;
    L125:
        if (r132.nl() != true) goto L130;
        com.bytedance.android.live.revlink.impl.precisefind.a r170 = com.bytedance.android.live.revlink.impl.global.b.K();
        if (r170 == null) goto L265;
        r170.lp();
        return;
    L265:
        return;
    L94:
        if (r127.getParent() != this.M) goto L110;
        i41.a r171 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r171 == null) goto L98;
        r171.b(AutoMatchSource.Manual);
    L98:
        IPKLinkBizDataService r172 = com.bytedance.android.live.revlink.impl.global.b.P();
        if (r172 == null) goto L101;
        r172.setIsRandomReMatch(false);
    L101:
        gt1.d r173 = gt1.e.a(1, r1, false, false, false, false, 0, false, false, null, 2044);
        ld.a r174 = ld.d.a();
        if (r174 == null) goto L106;
        NextLiveData r175 = r174.Y1();
        if (r175 == null) goto L106;
        r175.setValue(r173);
    L106:
        wq2.f r176 = ma1.a.a();
        if (r176 == null) goto L264;
        r176.S1(r173);
        return;
    L264:
        return;
    L88:
        if (r126.a() != true) goto L91;
        r126.b();
        return;
    L81:
        r9 = null;
        goto L82
    L77:
        r124 = null;
        goto L78
    L71:
        if (r122.isPaidLive() != true) goto L74;
        int r177 = ToastUtil.a;
        ToastUtil.b(s1.B(2131922202), 0);
        return;
    L61:
        if (r120.intValue() != 2) goto L63;
    L64:
        r121 = true;
        goto L65
    L57:
        if (r120.intValue() == 1) goto L64;
    L52:
        r120 = null;
    L40:
        r115 = false;
    L43:
        r116 = false;
        goto L44
    L9:
        if (r17.isDisableAbility() != true) goto L12;
        ToastUtil.b("相机连接过程中暂不支持该功能", 0);
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.b
    public final void tn(Function0<Unit> r2, String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "reqSrc");
        com.bytedance.android.live.revlink.impl.multianchor.service.b r0 = com.bytedance.android.live.revlink.impl.global.b.w();
        if (r0 == null) goto L6;
        r0.finishInternal(r2, r3, r4);
        return;
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.b
    public final void ui(int r54, boolean r55, boolean r56) {
        Long r6 = null;
        jy0.b.c("ttlive_anchor_linkrev_scope_life_control", "call unloadWidget for mode: " + r54 + ",  current: " + this.j + ",  pkSwitchLink: " + r56, null, 4);
        if (r54 == 4) goto L6;
        if (r54 == 64) goto L6;
    L9:
        Pair r1 = TuplesKt.to(Integer.valueOf(r54), Boolean.FALSE);
    L17:
        int r5 = ((Number) r1.component1()).intValue();
        if (((Boolean) r1.component2()).booleanValue() == true) goto L20;
        return;
    L20:
        boolean r9 = false;
        if (r5 == 4) goto L48;
        if (r5 == 64) goto L25;
    L132:
        d51.b r2 = d51.b.m;
        r2.getClass();
        ReadOnlyProperty r3 = d51.b.d;
        KProperty[] r4 = d51.b.a;
        if (((Boolean) r3.getValue(r2, r4[2])).booleanValue() == false) goto L141;
        if (this.E == false) goto L141;
        if (r5 != 4) goto L141;
        if (this.l == null) goto L141;
        return;
    L141:
        if (((Boolean) d51.b.i.getValue(r2, r4[7])).booleanValue() == false) goto L144;
        if (r56 == false) goto L144;
        r9 = true;
    L144:
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).I1(r5, r9);
        return;
    L25:
        if (this.E == true) goto L31;
        ld.a r7 = ld.d.a();
        if (r7 == null) goto L31;
        NextLiveData r8 = r7.Cb();
        if (r8 == null) goto L31;
        r8.setValue(Boolean.FALSE);
    L31:
        Mq(r5, r55);
        ld.a r10 = ld.d.a();
        if (r10 == null) goto L36;
        NextLiveData r12 = r10.A6();
        if (r12 == null) goto L36;
        r12.setValue(Boolean.FALSE);
    L36:
        wq2.f r13 = ma1.a.a();
        if (r13 == null) goto L39;
        r13.U1(false);
    L39:
        MultiLinkAnchorControlService r14 = this.d;
        if (r14 == null) goto L46;
        f21.b r15 = (f21.b) r14.t.getValue();
        if (r15 == null) goto L44;
        f21.a r16 = new f21.a(r15.a, null, 0, false, null, false, false, false, false, 0, null, null, null, null, null, null, 0, null, 2097150);
    L45:
        r14.I = r16;
        goto L46
    L44:
        r16 = new f21.a(r14.Aq(), null, 0, false, null, false, false, false, false, 0, null, null, null, null, null, null, 0, null, 2097150);
    L46:
        onMultiAnchorStateChange(0);
        this.i.reset();
        O.getClass();
        int r17 = com.bytedance.android.live.revlink.impl.pk.utils.e.a;
        IPerformanceManager r18 = jc1.k.n(IPerformanceManager.class);
        r18.onModuleStop("link_mic");
        r18.onModuleStop("revlink_gift_hide");
        Iq();
        goto L132
    L48:
        if (this.E == false) goto L126;
        HashMap r19 = new HashMap();
        r19.put("event_page", "live_detail");
        IRoom r110 = this.B;
        String r111 = "";
        if (r110 == null) goto L53;
        String r112 = String.valueOf(r110.getId());
        if (r112 == null) goto L53;
    L54:
        r19.put("room_id", r112);
        IRoom r113 = this.B;
        if (r113 == null) goto L61;
        IBaseUser r114 = r113.getOwner();
        if (r114 == null) goto L61;
        String r115 = iz.a.a(r114);
        if (r115 == null) goto L61;
    L62:
        r19.put("anchor_id", r115);
        IRoom r116 = this.B;
        if (r116 == null) goto L65;
        Long r117 = Long.valueOf(r116.getId());
    L66:
        LinkCrossRoomDataHolder r118 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r118 == null) goto L69;
        Long r119 = Long.valueOf(r118.c());
    L71:
        if (Intrinsics.areEqual(r117, r119) == false) goto L84;
        IRoom r120 = this.B;
        if (r120 == null) goto L79;
        IBaseUser r121 = r120.getOwner();
        if (r121 == null) goto L79;
        String r122 = iz.a.a(r121);
        if (r122 == null) goto L79;
        r111 = r122;
    L79:
        r19.put("inviter_id", r111);
        w31.c r123 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r123 == null) goto L82;
        String r124 = r123.c();
    L83:
        r19.put("invitee_id", String.valueOf(r124));
    L96:
        LinkCrossRoomDataHolder r125 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r125 != null) goto L99;
    L101:
        String r126 = "manual";
    L102:
        r19.put("match_type", r126);
        w31.c r127 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r127 == null) goto L105;
        int r128 = r127.a();
    L106:
        if (r128 <= 0) goto L112;
        w31.c r129 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r129 == null) goto L110;
        Integer r130 = Integer.valueOf(r129.a());
    L111:
        r19.put("pk_time", String.valueOf(r130));
        goto L112
    L110:
        r130 = null;
    L112:
        com.bytedance.android.live.revlink.impl.pk.utils.q r131 = com.bytedance.android.live.revlink.impl.global.b.W();
        if (r131 != null) goto L115;
    L117:
        String r132 = DataType.FALSE;
    L118:
        r19.put("is_oncemore", r132);
        LinkCrossRoomDataHolder r133 = com.bytedance.android.live.revlink.impl.global.b.j();
        if (r133 == null) goto L121;
        Long r134 = Long.valueOf(r133.c());
    L122:
        r19.put("channel_id", String.valueOf(r134));
        w31.c r135 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r135 == null) goto L125;
        r6 = Long.valueOf(r135.i());
    L125:
        r19.put("pk_id", String.valueOf(r6));
        r19.put("connection_time", String.valueOf((System.currentTimeMillis() - this.G) / ((long) WebcastRedirectException.UNKNOWN)));
    L131:
        Mq(r5, r55);
        vh6.c.b(qr2.c.class).tryUnLoadPkAudienceWidget();
        O.getClass();
        int r20 = com.bytedance.android.live.revlink.impl.pk.utils.e.a;
        IPerformanceManager r22 = jc1.k.n(IPerformanceManager.class);
        r22.onModuleStop("link_mic");
        r22.onModuleStop("revlink_gift_hide");
        Iq();
        goto L132
    L121:
        r134 = null;
        goto L122
    L115:
        if (r131.e() != true) goto L117;
        r132 = DataType.TRUE;
        goto L118
    L105:
        r128 = 0;
        goto L106
    L99:
        if (r125.i() != 1) goto L101;
        r126 = "random";
        goto L102
    L82:
        r124 = null;
        goto L83
    L84:
        w31.c r136 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r136 == null) goto L87;
        String r137 = r136.c();
    L88:
        r19.put("inviter_id", String.valueOf(r137));
        IRoom r138 = this.B;
        if (r138 == null) goto L95;
        IBaseUser r139 = r138.getOwner();
        if (r139 == null) goto L95;
        String r140 = iz.a.a(r139);
        if (r140 == null) goto L95;
        r111 = r140;
    L95:
        r19.put("invitee_id", r111);
        goto L96
    L87:
        r137 = null;
        goto L88
    L69:
        r119 = null;
        goto L71
    L65:
        r117 = null;
    L61:
        r115 = "";
    L53:
        r112 = "";
        goto L54
    L126:
        ld.a r23 = ld.d.a();
        if (r23 == null) goto L131;
        NextLiveData r24 = r23.Cb();
        if (r24 == null) goto L131;
        r24.setValue(Boolean.FALSE);
    L6:
        if (gd0.v.a(this.j, 4) == false) goto L8;
    L10:
        jy0.b.c("ttlive_anchor_linkrev_scope_life_control", "do unloadWidget for mode: " + r54, null, 4);
        if (gd0.v.a(this.j, 4) == false) goto L13;
        int r25 = 4;
    L14:
        if (r55 == true) goto L16;
        vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).hc();
    L16:
        int r26 = gd0.v.b(this.j, 4);
        this.j = r26;
        int r27 = gd0.v.b(r26, 64);
        this.j = r27;
        this.y.j(r27);
        r1 = TuplesKt.to(Integer.valueOf(r25), Boolean.TRUE);
        goto L17
    L13:
        r25 = 64;
        goto L14
    L8:
        if (gd0.v.a(this.j, 64) == true) goto L10;
        goto L9
    }

    @Override // com.bytedance.android.live.revlink.impl.service.internal.a
    public final boolean r5(String r15, String r16, String r17, Integer r18) {
        String r9 = r15;
        Intrinsics.checkNotNullParameter(r15, "guideType");
        Intrinsics.checkNotNullParameter(r16, "toUserGroup");
        Intrinsics.checkNotNullParameter(r17, "page");
        t r2 = this.s;
        boolean r13 = false;
        if (r2 == null) goto L131;
        boolean r3 = r2.a;
        if (r3 == false) goto L127;
        if (r3 == false) goto L20;
        com.bytedance.android.livesdk.revenue.service.room.c r4 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.room.c.class);
        if (r4 == null) goto L17;
        com.bytedance.android.livesdk.revenue.room.a r5 = r4.getRoomContext();
        if (r5 == null) goto L17;
        com.bytedance.live.datacontext.m r6 = r5.isCasting();
        if (r6 == null) goto L17;
        Boolean r7 = (Boolean) r6.getValue();
        if (r7 == null) goto L17;
        boolean r8 = r7.booleanValue();
    L18:
        if (r8 == false) goto L20;
        boolean r10 = true;
    L21:
        if (r10 == true) goto L23;
        ld.a r12 = ld.d.a();
        if (r12 == null) goto L30;
        NextLiveData r14 = r12.Dc();
        if (r14 == null) goto L30;
        Integer r19 = (Integer) r14.getValue();
    L31:
        if (r19 != null) goto L34;
    L35:
        if (r19 != null) goto L38;
    L40:
        boolean r20 = false;
    L42:
        if (r20 == false) goto L44;
        ToastUtil.a(2131922201, 0);
        goto L127
    L44:
        lr2.a r22 = com.bytedance.android.live.revenue.core.util.f.d(com.bytedance.android.live.revenue.core.util.j.C0.a(), lr2.a.class);
        if (r22 != null) goto L47;
    L49:
        hq2.d r23 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interactivity.b.class).ya();
        if (r23 != null) goto L52;
    L54:
        com.bytedance.android.live.revlink.impl.service.internal.a r24 = com.bytedance.android.live.revlink.impl.global.b.n();
        if (r24 != null) goto L57;
    L59:
        d51.c r25 = d51.c.A0;
        if (r25.l() == true) goto L62;
        int r26 = ToastUtil.a;
        ToastUtil.b((String) d51.c.f.getValue(r25, d51.c.a[4]), 0);
        goto L127
    L62:
        IRoom r27 = r2.b;
        if (r27 != null) goto L65;
    L67:
        ox0.a r28 = com.bytedance.android.live.revlink.impl.global.b.s();
        if (r28 == null) goto L70;
        int r29 = r28.a();
    L71:
        if (r29 != 0) goto L104;
        com.bytedance.android.live.revlink.impl.pk.service.e r30 = com.bytedance.android.live.revlink.impl.global.b.Q();
        if (r30 != null) goto L75;
    L77:
        com.bytedance.android.live.revlink.impl.pk.service.e r32 = com.bytedance.android.live.revlink.impl.global.b.Q();
        if (r32 == null) goto L83;
        if (r32.isMatchingCount() != true) goto L83;
        ToastUtil.a(2131922648, 0);
    L83:
        if (com.bytedance.android.live.revlink.impl.multianchor.match.m.a().a == false) goto L85;
        ToastUtil.a(2131922648, 0);
        goto L127
    L85:
        i41.a r33 = com.bytedance.android.live.revlink.impl.global.b.g();
        if (r33 != null) goto L88;
    L90:
        w31.c r34 = com.bytedance.android.live.revlink.impl.global.b.T();
        if (r34 == null) goto L96;
        if (r34.p() != true) goto L96;
        ToastUtil.a(2131922648, 0);
    L96:
        if (r2.c.v == 0) goto L98;
        ToastUtil.a(2131922648, 0);
        goto L127
    L98:
        IRoom r35 = r2.b;
        if (r35 == null) goto L104;
        if (r35.isLiveTypeAudio() != true) goto L104;
    L88:
        if (r33.f != true) goto L90;
        ToastUtil.a(2131922648, 0);
        goto L127
    L75:
        if (r30.isMatchWaiting() != true) goto L77;
        ToastUtil.a(2131917916, 0);
    L104:
        if (gd0.v.a(r29, 32) == false) goto L125;
        if (com.bytedance.android.live.revlink.impl.pk.utils.n.a() == false) goto L108;
        dq2.w r36 = vh6.c.b(com.bytedance.android.livesdk.revenue.service.interact.d.class).M1();
        if (r36 == null) goto L125;
        if (r36.n() == true) goto L125;
    L108:
        if (PadConfigUtils.c() == false) goto L110;
    L115:
        boolean r37 = true;
    L116:
        if (r37 == false) goto L118;
        ToastUtil.a(2131922651, 0);
        goto L127
    L118:
        ToastUtil.a(2131922650, 0);
        goto L127
    L110:
        if (PadConfigUtils.c() == true) goto L115;
        if (FoldScreenUtils.f() == true) goto L115;
        r37 = false;
    L125:
        if (gd0.v.a(r29, 8) == false) goto L128;
        ToastUtil.a(2131922647, 0);
        goto L127
    L128:
        boolean r38 = true;
    L129:
        if (r38 == true) goto L131;
        return false;
    L70:
        r29 = 0;
        goto L71
    L65:
        if (r27.getMosaicStatusFlex() != 1) goto L67;
        ToastUtil.a(2131919663, 0);
        goto L127
    L57:
        if (r24.V() != true) goto L59;
        ToastUtil.a(2131922648, 0);
        goto L127
    L52:
        if (r23.a() != true) goto L54;
    L47:
        if (r22.isPaidLive() != true) goto L49;
        int r39 = ToastUtil.a;
        ToastUtil.b(s1.B(2131922202), 0);
        goto L127
    L38:
        if (r19.intValue() != 2) goto L40;
    L41:
        r20 = true;
        goto L42
    L34:
        if (r19.intValue() == 1) goto L41;
    L30:
        r19 = null;
        goto L31
    L23:
        if ((!Intrinsics.areEqual(vh6.c.b(com.bytedance.android.livesdk.revenue.service.broadcast.a.class).isOpenPlatformGameOpeningLynxPanelInGame(), Boolean.TRUE)) == false) goto L127;
        int r40 = ToastUtil.a;
        ToastUtil.b(s1.B(2131922199), 0);
    L17:
        r8 = false;
    L20:
        r10 = false;
    L127:
        r38 = false;
    L131:
        RevLinkDialog r42 = this.q;
        if (r42 != null) goto L134;
    L137:
        DataCenter r43 = ((Widget) this).dataCenter;
        int r44 = RevLinkDialog.x;
        this.q = new RevLinkDialog.a(r43, this).a();
        int r45 = com.bytedance.android.live.revlink.impl.control.dialog.b.r;
        com.bytedance.android.live.revlink.impl.control.dialog.b r46 = com.bytedance.android.live.revlink.impl.control.dialog.b.a.b();
        if (r46 == null) goto L141;
        r46.m();
    L141:
        if (Intrinsics.areEqual(r17, this.I) == false) goto L143;
        int r1 = AnchorInteractSettingFragment.H0;
        RevLinkDialog r47 = this.q;
        AnchorInteractSettingFragment r48 = new AnchorInteractSettingFragment();
        r48.f = new com.bytedance.android.live.revlink.impl.pk.dialog.presenter.a(r48);
        r48.d = r47;
        r48.Y = false;
        r48.k0 = false;
        RevInteractDialogFragmentBaseContract$View r49 = r48;
    L157:
        RevLinkDialog r50 = this.q;
        if (r50 == null) goto L160;
        r50.f = r49;
    L160:
        Kq(null);
        RevLinkDialog r52 = this.q;
        if (r52 == null) goto L167;
        FragmentActivity r53 = ((Widget) this).context;
        if (r53 == null) goto L166;
        wq(r52, r53.getSupportFragmentManager());
        goto L167
    L166:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    L167:
        return true;
    L143:
        int r54 = AnchorInteractContainerFragment.S;
        RevLinkDialog r55 = this.q;
        DataCenter r56 = ((Widget) this).dataCenter;
        if (r18 != null) goto L147;
    L149:
        KProperty[] r57 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        int r58 = 1;
    L150:
        AnchorInteractContainerFragment r59 = AnchorInteractContainerFragment.Companion.b(r55, r56, r58, null, r17, 24);
        if (r15.length() != 0) goto L154;
        r13 = true;
    L154:
        if (r13 == false) goto L156;
        r9 = "guide";
    L156:
        Intrinsics.checkNotNullParameter(r9, "guideType");
        Intrinsics.checkNotNullParameter(r16, "toUserGroup");
        Intrinsics.checkNotNullParameter("guide", "source");
        r59.C = r9;
        r59.D = r16;
        r59.F = "guide";
        r49 = r59;
        goto L157
    L147:
        if (r18.intValue() != 1) goto L149;
        KProperty[] r60 = com.bytedance.android.live.revlink.impl.behavior.o.a;
        r58 = 0;
        goto L150
    L134:
        if (r42.isVisible() == false) goto L137;
        return false;
    }
}
