package com.obric.memorydata.middleware.impl.bdtracker;

import android.content.Context;
import android.util.Pair;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.applog.AppLog;
import com.bytedance.applog.o;
import com.bytedance.applog.p;
import com.bytedance.bdinstall.Env;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.bdinstall.ISstInfoProvider;
import com.bytedance.bdinstall.Level;
import com.bytedance.bdinstall.RangersHttpException;
import com.bytedance.bdinstall.sensitive.DefaultSensitiveInterceptor;
import com.bytedance.common.utility.CommonHttpException;
import com.bytedance.common.utility.f;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.IBdTrackerInit;
import com.obric.memorydata.middleware.api.controller.NetworkController;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.AppSettingsManager;
import com.obric.memorydata.utils.af;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000+\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\bH\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/middleware/impl/bdtracker/BdTrackerInit;", "Lcom/obric/memorydata/middleware/api/bdtracker/IBdTrackerInit;", "<init>", "()V", "appLogLifecycleListener", "com/obric/memorydata/middleware/impl/bdtracker/BdTrackerInit$appLogLifecycleListener$1", "Lcom/obric/memorydata/middleware/impl/bdtracker/BdTrackerInit$appLogLifecycleListener$1;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "flushAppLogIfDoubaoApp", ObricMemoryConstants.KEY_PACKAGE_NAME, "", "lifecycleState", "isAppLogNetworkRequestAllowed", "", "syncUserId", "Companion", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BdTrackerInit implements IBdTrackerInit {
    public static final a Companion = null;
    private static final String DOUBAO_APP_NAME = "nova_ai";
    private static final String TAG = "BdTrackerInit";
    private final b appLogLifecycleListener;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/middleware/impl/bdtracker/BdTrackerInit$Companion;", "", "<init>", "()V", "TAG", "", "DOUBAO_APP_NAME", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/middleware/impl/bdtracker/BdTrackerInit$appLogLifecycleListener$1", "Lcom/obric/memorydata/utils/MemoryAppStateListener$AppSwitchListener;", "onAppOpen", "", "appName", "", ObricMemoryConstants.KEY_PACKAGE_NAME, "onAppClose", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements af.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BdTrackerInit f11702a;

        b(BdTrackerInit r1) {
            this.f11702a = r1;
        }

        @Override // com.obric.memorydata.utils.af.a
        public void a(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "appName");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            BdTrackerInit.access$flushAppLogIfDoubaoApp(this.f11702a, r3, "前台");
        }

        @Override // com.obric.memorydata.utils.af.a
        public void b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "appName");
            Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
            BdTrackerInit.access$flushAppLogIfDoubaoApp(this.f11702a, r3, "后台");
        }
    }

    @Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J)\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH\u0096\u0002J2\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J.\u0010\f\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u001a\u0010\u0011\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0013\u0018\u00010\u0012H\u0016J2\u0010\u0014\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH\u0016R\u001a\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00038Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"com/obric/memorydata/middleware/impl/bdtracker/BdTrackerInit$init$1", "Lcom/bytedance/bdinstall/INetworkClient;", "mClient", "Lcom/bytedance/common/utility/NetworkClient;", "kotlin.jvm.PlatformType", "getMClient", "()Lcom/bytedance/common/utility/NetworkClient;", "get", "", "url", "requestHeaders", "", CozeCloudExt.API_KEY_HTTP_POST_METHOD, "data", "", "bytes", "contentType", TrackerImpl.PARAMS, "", "Landroid/util/Pair;", "postStream", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements INetworkClient {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ BdTrackerInit f11703a;

        c(BdTrackerInit r1) {
            this.f11703a = r1;
        }

        @Override // com.bytedance.bdinstall.INetworkClient
        public String get(String r3, Map<String, String> r4) {
            Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
            if (BdTrackerInit.access$isAppLogNetworkRequestAllowed(this.f11703a) == true) goto L15;
            return "";
        L15:
            String r2 = f.a().a(r3, r5, null);     // Catch: Exception -> L8
            Intrinsics.checkNotNull(r2);     // Catch: Exception -> L8
            return r2;
        L8:
            e = move-exception;
            if (ZeusTransformUtils.instanceOf(e, CommonHttpException.class) == false) goto L14;
            throw new RangersHttpException(((CommonHttpException) ZeusTransformUtils.preCheckCast(e, CommonHttpException.class, "com.obric.memorydata.plugin")).getResponseCode(), e.getCause());
        L14:
            throw new RangersHttpException(400, e.getCause());
        }

        @Override // com.bytedance.bdinstall.INetworkClient
        public String post(String r3, List<Pair<String, String>> r4) {
            List<Pair<String, String>> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            if (BdTrackerInit.access$isAppLogNetworkRequestAllowed(this.f11703a) == true) goto L6;
            return "";
        L6:
            String r2 = f.a().a(r3, r5);
            Intrinsics.checkNotNullExpressionValue(r2, "post(...)");
            return r2;
        }

        @Override // com.bytedance.bdinstall.INetworkClient
        public String post(String r3, byte[] r4, String r5) {
            if (BdTrackerInit.access$isAppLogNetworkRequestAllowed(this.f11703a) == true) goto L6;
            return "";
        L6:
            Map<String, String> r2 = (Map) ZeusTransformUtils.preCheckCast(new HashMap(), Map.class, "com.obric.memorydata.plugin");
            CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L9;
        L12:
            boolean r1 = true;
        L13:
            if (r1 == true) goto L20;
            r2.put(NetConst.KEY_CONTENT_TYPE, r5);
        L20:
            String r6 = f.a().a(r3, r4, r2, null);     // Catch: CommonHttpException -> L17
            Intrinsics.checkNotNull(r6);     // Catch: CommonHttpException -> L17
            return r6;
        L17:
            e = move-exception;
            throw new RangersHttpException(e.getResponseCode(), e.getCause());
        L9:
            if (r0.length() == 0) goto L12;
            r1 = false;
            goto L13
        }

        @Override // com.bytedance.bdinstall.INetworkClient
        public String post(String r3, byte[] r4, Map<String, String> r5) {
            Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
            if (BdTrackerInit.access$isAppLogNetworkRequestAllowed(this.f11703a) == true) goto L11;
            return "";
        L11:
            String r2 = f.a().a(r3, r4, r6, null);     // Catch: CommonHttpException -> L8
            Intrinsics.checkNotNull(r2);     // Catch: CommonHttpException -> L8
            return r2;
        L8:
            e = move-exception;
            throw new RangersHttpException(e.getResponseCode(), e.getCause());
        }

        @Override // com.bytedance.bdinstall.INetworkClient
        public byte[] postStream(String r3, byte[] r4, Map<String, String> r5) {
            Map<String, String> r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
            if (BdTrackerInit.access$isAppLogNetworkRequestAllowed(this.f11703a) == false) goto L5;
            byte[] r2 = f.a().b(r3, r4, r6, null);     // Catch: CommonHttpException -> L8
            Intrinsics.checkNotNull(r2);     // Catch: CommonHttpException -> L8
            return r2;
        L8:
            e = move-exception;
            throw new RangersHttpException(e.getResponseCode(), e.getCause());
        L5:
            return new byte[0];
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/middleware/impl/bdtracker/BdTrackerInit$syncUserId$3", "Lcom/obric/memorydata/middleware/api/app/LoginStateListener;", "onLogin", "", "userId", "", "onLogout", "lastUserId", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements com.obric.memorydata.middleware.api.app.d {
        d() {
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void a(String r6) {
            Intrinsics.checkNotNullParameter(r6, "userId");
            Long r5 = StringsKt.toLongOrNull(r6);
            if (r5 != null) goto L5;
            return;
        L5:
            if (((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L7;
            boolean r7 = true;
        L8:
            if (r7 == true) goto L11;
            r5 = null;
        L11:
            if (r5 == null) goto L15;
            AppLog.setUserID(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue());
            return;
        L15:
            return;
        L7:
            r7 = false;
            goto L8
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void b(String r1) {
            Intrinsics.checkNotNullParameter(r1, "lastUserId");
            AppLog.setUserID(0);
        }
    }

    static {
        Companion = new a(null);
    }

    public BdTrackerInit() {
        this.appLogLifecycleListener = new b(this);
    }

    public static final /* synthetic */ void access$flushAppLogIfDoubaoApp(BdTrackerInit r0, String r1, String r2) {
        r0.flushAppLogIfDoubaoApp(r1, r2);
    }

    public static final /* synthetic */ boolean access$isAppLogNetworkRequestAllowed(BdTrackerInit r0) {
        return r0.isAppLogNetworkRequestAllowed();
    }

    private final void flushAppLogIfDoubaoApp(String r2, String r3) {
        if (Intrinsics.areEqual(r2, AppContext.INSTANCE.getHostPkgName()) == false) goto L6;
        RunLog.INSTANCE.debug(TAG, "豆包 APP 进入" + r3 + "，触发 AppLog flush");
        AppLog.flush();
        return;
    }

    private static final HashMap init$lambda$0(Level r0) {
        return com.obric.memorydata.middleware.impl.bdtracker.a.f11706a.a();
    }

    private final boolean isAppLogNetworkRequestAllowed() {
        if (NetworkController.INSTANCE.isScreenOn() == true) goto L6;
        return false;
    L6:
        if (AppSettingsManager.INSTANCE.hasInited() == true) goto L8;
    L10:
        boolean r2 = false;
    L11:
        if (r2 == true) goto L15;
        if (NetworkController.INSTANCE.isNetworkPolicySatisfied() == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        if (AppSettingsManager.INSTANCE.getDataUploadSettings().getSkipAppLogBackgroundNetworkRestriction() == false) goto L10;
        r2 = true;
        goto L11
    }

    public static /* synthetic */ HashMap lambda$Wnio3BTonaecXA_b05lrRF58WpI(Level r0) {
        return init$lambda$0(r0);
    }

    private final void syncUserId() {
        if (Intrinsics.areEqual(AppContext.INSTANCE.getPackageName(), "com.obric.lifelog") == false) goto L5;
        return;
    L5:
        Long r5 = StringsKt.toLongOrNull(AppContext.INSTANCE.getUserId());
        if (r5 != null) goto L8;
    L16:
        UserSettings.INSTANCE.registerLoginStateListener((com.obric.memorydata.middleware.api.app.d) ZeusTransformUtils.preCheckCast(new d(), com.obric.memorydata.middleware.api.app.d.class, "com.obric.memorydata.plugin"));
        return;
    L8:
        if (((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue() <= 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == true) goto L14;
        r5 = null;
    L14:
        if (r5 == null) goto L16;
        AppLog.setUserID(((Number) ZeusTransformUtils.preCheckCast(r5, Number.class, "com.obric.memorydata.plugin")).longValue());
        goto L16
    L10:
        r1 = false;
        goto L11
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.IBdTrackerInit
    public void init() {
        String r0 = String.valueOf(AppContext.INSTANCE.getAid());
        boolean r1 = AppContext.INSTANCE.isDebug();
        o r2 = new o(r0, AppContext.INSTANCE.getChannel());
        r2.a(DOUBAO_APP_NAME);
        long r3 = AppContext.INSTANCE.getVersionCode();
        r2.a(r3);
        r2.b(AppContext.INSTANCE.getVersionName());
        r2.b(true);
        r2.c(r3);
        r2.c(AppContext.INSTANCE.getVersionName());
        r2.b(AppContext.INSTANCE.getUpdateVersionCode());
        r2.e(false);
        r2.a((Map) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.impl.bdtracker.a.f11706a.b(), Map.class, "com.obric.memorydata.plugin"));
        if (AppContext.INSTANCE.isSsFlavor() == false) goto L5;
        r2.a((ISstInfoProvider) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.middleware.impl.bdtracker.c(), ISstInfoProvider.class, "com.obric.memorydata.plugin"));
    L5:
        r2.a((DefaultSensitiveInterceptor) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.middleware.impl.bdtracker.b(), DefaultSensitiveInterceptor.class, "com.obric.memorydata.plugin"));
        r2.a(new p.a().a(Env.CHINA).a(new String[]{"https://log.doubao.com/service/2/app_log/"}).b(new String[]{"https://rtlog.doubao.com/service/2/app_log/"}).a("https://log.doubao.com/service/2/log_settings/").a());
        r2.a((INetworkClient) ZeusTransformUtils.preCheckCast(new c(this), INetworkClient.class, "com.obric.memorydata.plugin"));
        r2.a(true);
        r2.d(true);
        syncUserId();
        AppLog.setEncryptAndCompress(!r1);
        AppLog.setAdjustTerminate(true);
        AppLog.setBDInstallEventTrackEnabled(true);
        AppLog.setExtraParams($$Lambda$BdTrackerInit$Wnio3BTonaecXA_b05lrRF58WpI.INSTANCE);
        AppLog.init((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r2);
        af.f13160a.a((af.a) ZeusTransformUtils.preCheckCast(this.appLogLifecycleListener, af.a.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.middleware.impl.bdtracker.a.f11706a.c();
        MemoryAppLogSettings.INSTANCE.onMemoryAppLogInitialized();
    }
}
