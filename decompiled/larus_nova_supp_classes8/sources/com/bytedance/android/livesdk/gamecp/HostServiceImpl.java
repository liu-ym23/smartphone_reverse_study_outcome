package com.bytedance.android.livesdk.gamecp;

import com.bytedance.android.gamecp.host_api.cloudgame.IFeatureService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bq\u0010rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\b\u0010%\u001a\u00020$H\u0016J\b\u0010'\u001a\u00020&H\u0016J\b\u0010)\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020*H\u0016J\b\u0010-\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020.H\u0016J\b\u00101\u001a\u000200H\u0016J\b\u00103\u001a\u000202H\u0016J\b\u00105\u001a\u000204H\u0016J\b\u00107\u001a\u000206H\u0016J\u0016\u0010;\u001a\b\u0012\u0002\b\u0003\u0018\u00010:2\u0006\u00109\u001a\u000208H\u0016R\u0018\u0010<\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010>\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010@\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010B\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010D\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010F\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010H\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010J\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u0018\u0010L\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010N\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010P\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010R\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010T\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010V\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010Y\u001a\u0004\u0018\u00010X8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010[\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010]\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0018\u0010_\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010a\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010c\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0018\u0010e\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010g\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010i\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010k\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010m\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0018\u0010o\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010p¨\u0006s"}, d2 = {"Lcom/bytedance/android/livesdk/gamecp/HostServiceImpl;", "Lbw/m;", "Lbw/e;", "getHostDownloadService", "Lbw/f;", "getHostFmpCalculatorService", "Lbw/h;", "getHostGameBindService", "Lbw/d;", "getHostContext", "Lbw/b;", "getHostAppService", "Lov/a;", "getHostBusiness", "Lbw/k;", "getHostMonitorService", "Lbw/i;", "getLiveService", "Lbw/j;", "getLogService", "Lgw/a;", "getStrategyService", "Lbw/p;", "getUserService", "Lbw/r;", "getActionHandleService", "Lnv/b;", "getAiService", "Lfw/c;", "getBrowserService", "Ltv/a;", "getCloudGameService", "Lov/b;", "getHostVerifyService", "Lbw/q;", "getHostVideoPlayerService", "Lyv/b;", "getHostNetwork", "Lyv/a;", "getHostAction", "Lbw/n;", "getHostSettingService", "Lbw/o;", "getHostStateService", "Lcw/d;", "getHostAirCompressService", "Lbw/c;", "getHostCommonSubscribeService", "Law/b;", "getHostPlayCardService", "Lcom/bytedance/android/gamecp/host_api/cloudgame/IFeatureService;", "getFeatureServiceApi", "Lbw/l;", "getHostRouteOutCertDataService", "Lbw/g;", "getHostFoldPadService", "", "className", "Ljava/lang/Class;", "reflectInPlugin", "mHostDownloadService", "Lbw/e;", "mHostContext", "Lbw/d;", "mHostAppService", "Lbw/b;", "mHostBusiness", "Lov/a;", "mHostMonitorService", "Lbw/k;", "mHostLiveService", "Lbw/i;", "mHostLogService", "Lbw/j;", "mHostUserService", "Lbw/p;", "mHostLiveActionHandleService", "Lbw/r;", "mHostAiService", "Lnv/b;", "mHostBrowserService", "Lfw/c;", "mHostVerify", "Lov/b;", "mHostNetwork", "Lyv/b;", "mHostAction", "Lyv/a;", "Lrv/a;", "mLiveIntroduceCardService", "Lrv/a;", "mHostSettingService", "Lbw/n;", "mCloudGameService", "Ltv/a;", "mStrategyService", "Lgw/a;", "mHostVideoPlayerService", "Lbw/q;", "mHostFmpCalculatorService", "Lbw/f;", "mHostAirCompressService", "Lcw/d;", "mHostCommonSubscribeService", "Lbw/c;", "mHostPlayCardService", "Law/b;", "mFeatureService", "Lcom/bytedance/android/gamecp/host_api/cloudgame/IFeatureService;", "mIHostRouteOutCertDataService", "Lbw/l;", "mIHostFoldPadService", "Lbw/g;", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class HostServiceImpl implements bw.m {
    private tv.a mCloudGameService;
    private IFeatureService mFeatureService;
    private yv.a mHostAction;
    private nv.b mHostAiService;
    private cw.d mHostAirCompressService;
    private bw.b mHostAppService;
    private fw.c mHostBrowserService;
    private ov.a mHostBusiness;
    private bw.c mHostCommonSubscribeService;
    private bw.d mHostContext;
    private bw.e mHostDownloadService;
    private bw.f mHostFmpCalculatorService;
    private bw.r mHostLiveActionHandleService;
    private bw.i mHostLiveService;
    private bw.j mHostLogService;
    private bw.k mHostMonitorService;
    private yv.b mHostNetwork;
    private aw.b mHostPlayCardService;
    private bw.n mHostSettingService;
    private bw.p mHostUserService;
    private ov.b mHostVerify;
    private bw.q mHostVideoPlayerService;
    private bw.g mIHostFoldPadService;
    private bw.l mIHostRouteOutCertDataService;
    private rv.a mLiveIntroduceCardService;
    private gw.a mStrategyService;

    public static final class a implements bw.h {
        public a() {
        }
    }

    public HostServiceImpl() {
    }

    public static /* synthetic */ Class access$000(String r0) throws ClassNotFoundException {
        return Class.forName(r0);
    }

    public bw.r getActionHandleService() {
        if (this.mHostLiveActionHandleService != null) goto L5;
        this.mHostLiveActionHandleService = new y();
    L5:
        bw.r r0 = this.mHostLiveActionHandleService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public nv.b getAiService() {
        if (this.mHostAiService != null) goto L5;
        this.mHostAiService = new ew.c();
    L5:
        nv.b r0 = this.mHostAiService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public fw.c getBrowserService() {
        if (this.mHostBrowserService != null) goto L5;
        this.mHostBrowserService = new vx1.a();
    L5:
        fw.c r0 = this.mHostBrowserService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public tv.a getCloudGameService() {
        if (this.mCloudGameService != null) goto L5;
        this.mCloudGameService = new ew.g();
    L5:
        tv.a r0 = this.mCloudGameService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public IFeatureService getFeatureServiceApi() {
        if (this.mFeatureService != null) goto L5;
        this.mFeatureService = new ew.j();
    L5:
        IFeatureService r0 = this.mFeatureService;
        if (r0 == null) goto L8;
        return r0;
    L8:
        return new ew.j();
    }

    public yv.a getHostAction() {
        if (this.mHostAction != null) goto L5;
        this.mHostAction = new g();
    L5:
        yv.a r0 = this.mHostAction;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public cw.d getHostAirCompressService() {
        if (this.mHostAirCompressService != null) goto L5;
        this.mHostAirCompressService = new ew.d();
    L5:
        cw.d r0 = this.mHostAirCompressService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public bw.b getHostAppService() {
        if (this.mHostAppService != null) goto L5;
        this.mHostAppService = new j();
    L5:
        bw.b r0 = this.mHostAppService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public ov.a getHostBusiness() {
        if (this.mHostBusiness != null) goto L5;
        this.mHostBusiness = new k();
    L5:
        ov.a r0 = this.mHostBusiness;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public bw.c getHostCommonSubscribeService() {
        if (this.mHostCommonSubscribeService != null) goto L5;
        this.mHostCommonSubscribeService = new l();
    L5:
        bw.c r0 = this.mHostCommonSubscribeService;
        if (r0 == null) goto L8;
        return r0;
    L8:
        return new l();
    }

    public bw.d getHostContext() {
        if (this.mHostContext != null) goto L5;
        this.mHostContext = new m();
    L5:
        bw.d r0 = this.mHostContext;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public bw.e getHostDownloadService() {
        if (this.mHostDownloadService != null) goto L5;
        this.mHostDownloadService = new n();
    L5:
        bw.e r0 = this.mHostDownloadService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public bw.f getHostFmpCalculatorService() {
        if (this.mHostFmpCalculatorService != null) goto L5;
        this.mHostFmpCalculatorService = new ew.k();
    L5:
        bw.f r0 = this.mHostFmpCalculatorService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public bw.g getHostFoldPadService() {
        if (this.mIHostFoldPadService != null) goto L5;
        this.mIHostFoldPadService = new ew.l();
    L5:
        bw.g r0 = this.mIHostFoldPadService;
        if (r0 == null) goto L8;
        return r0;
    L8:
        return new ew.l();
    }

    public bw.h getHostGameBindService() {
        return new a();
    }

    public bw.k getHostMonitorService() {
        if (this.mHostMonitorService != null) goto L5;
        this.mHostMonitorService = new t();
    L5:
        bw.k r0 = this.mHostMonitorService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public yv.b getHostNetwork() {
        if (this.mHostNetwork != null) goto L5;
        this.mHostNetwork = new u();
    L5:
        yv.b r0 = this.mHostNetwork;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public aw.b getHostPlayCardService() {
        if (this.mHostPlayCardService != null) goto L5;
        this.mHostPlayCardService = new ew.q();
    L5:
        aw.b r0 = this.mHostPlayCardService;
        if (r0 == null) goto L8;
        return r0;
    L8:
        return new ew.q();
    }

    public bw.l getHostRouteOutCertDataService() {
        if (this.mIHostRouteOutCertDataService != null) goto L5;
        this.mIHostRouteOutCertDataService = new ew.r();
    L5:
        bw.l r0 = this.mIHostRouteOutCertDataService;
        if (r0 == null) goto L8;
        return r0;
    L8:
        return new ew.r();
    }

    public bw.n getHostSettingService() {
        if (this.mHostSettingService != null) goto L5;
        this.mHostSettingService = new v();
    L5:
        bw.n r0 = this.mHostSettingService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public bw.o getHostStateService() {
        return new ew.u();
    }

    public ov.b getHostVerifyService() {
        if (this.mHostVerify != null) goto L5;
        this.mHostVerify = new w();
    L5:
        ov.b r0 = this.mHostVerify;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public bw.q getHostVideoPlayerService() {
        if (this.mHostVideoPlayerService != null) goto L5;
        this.mHostVideoPlayerService = new ew.y();
    L5:
        bw.q r0 = this.mHostVideoPlayerService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public bw.i getLiveService() {
        if (this.mHostLiveService != null) goto L5;
        this.mHostLiveService = new p();
    L5:
        bw.i r0 = this.mHostLiveService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public bw.j getLogService() {
        if (this.mHostLogService != null) goto L5;
        this.mHostLogService = new s();
    L5:
        bw.j r0 = this.mHostLogService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public gw.a getStrategyService() {
        if (this.mStrategyService != null) goto L5;
        this.mStrategyService = new ew.v();
    L5:
        gw.a r0 = this.mStrategyService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    public bw.p getUserService() {
        if (this.mHostUserService != null) goto L5;
        this.mHostUserService = new wx1.d();
    L5:
        bw.p r0 = this.mHostUserService;
        Intrinsics.checkNotNull(r0);
        return r0;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_android_livesdk_gamecp_HostServiceImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r3) throws ClassNotFoundException {
        ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
        FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r2 = access$000(r3);     // Catch: Throwable -> L8
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L8
    L7:
        return r2;
    L8:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r3);
    L12:
        throw th;
    L34:
        Class r4 = access$000(r3);     // Catch: Throwable -> L17
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r3);     // Catch: Throwable -> L17
    L16:
        return r4;
    L17:
        th = move-exception;
        if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r3);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r3);
    }

    public Class<?> reflectInPlugin(String r2) {
        Intrinsics.checkNotNullParameter(r2, "className");
        return INVOKESTATIC_com_bytedance_android_livesdk_gamecp_HostServiceImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r2);
    }
}
