package com.obric.memorydata.middleware.impl.abtest;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.applog.AppLog;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.Level;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.dataplatform.g;
import com.bytedance.dataplatform.h;
import com.bytedance.dataplatform.i;
import com.bytedance.dataplatform.j;
import com.bytedance.dataplatform.k;
import com.bytedance.ies.abmock.ConfigurationManager;
import com.bytedance.rpc.service.GeneralService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.memorydata.middleware.api.abtest.IAbTestInit;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.logging.e;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.logging.w;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000Q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0003\u000e\u0011\u0018\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u0000H\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J\b\u0010 \u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0019¨\u0006!"}, d2 = {"Lcom/obric/memorydata/middleware/impl/abtest/AbTestInitImpl;", "Lcom/obric/memorydata/middleware/api/abtest/IAbTestInit;", "<init>", "()V", "AB_TEST_SDK_HOST", "", "LIBRA_EXPERIMENT_QUERY_PARAM", "gson", "Lcom/google/gson/Gson;", "initialized", "", "experimentListener", "Lcom/bytedance/dataplatform/IExperimentListener;", "settings", "com/obric/memorydata/middleware/impl/abtest/AbTestInitImpl$settings$1", "Lcom/obric/memorydata/middleware/impl/abtest/AbTestInitImpl$settings$1;", "serializationService", "com/obric/memorydata/middleware/impl/abtest/AbTestInitImpl$serializationService$1", "Lcom/obric/memorydata/middleware/impl/abtest/AbTestInitImpl$serializationService$1;", "exposureService", "Lcom/bytedance/dataplatform/IExposureService;", "netService", "Lcom/bytedance/dataplatform/INetService;", "loginStateListener", "com/obric/memorydata/middleware/impl/abtest/AbTestInitImpl$loginStateListener$1", "Lcom/obric/memorydata/middleware/impl/abtest/AbTestInitImpl$loginStateListener$1;", "getInst", "registerPluginConfig", "", "pluginContext", "Landroid/content/Context;", "initialize", "registerAppLogDidReadyListener", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AbTestInitImpl implements IAbTestInit {
    private static final String AB_TEST_SDK_HOST = "https://abtest-ch.snssdk.com/common";
    public static final AbTestInitImpl INSTANCE = null;
    private static final String LIBRA_EXPERIMENT_QUERY_PARAM = "doubao_support_libra_experiment";
    private static final g experimentListener = null;
    private static final h exposureService = null;
    private static final Gson gson = null;
    private static boolean initialized;
    private static final a loginStateListener = null;
    private static final i netService = null;
    private static final c serializationService = null;
    private static final d settings = null;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/middleware/impl/abtest/AbTestInitImpl$loginStateListener$1", "Lcom/obric/memorydata/middleware/api/app/LoginStateListener;", "onLogin", "", "userId", "", "onLogout", "lastUserId", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements com.obric.memorydata.middleware.api.app.d {
        a() {
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void a(String r1) {
            Intrinsics.checkNotNullParameter(r1, "userId");
            com.bytedance.dataplatform.d.a(r1);
            com.bytedance.dataplatform.d.c();
        }

        @Override // com.obric.memorydata.middleware.api.app.d
        public void b(String r1) {
            Intrinsics.checkNotNullParameter(r1, "lastUserId");
            com.bytedance.dataplatform.d.a("");
            com.bytedance.dataplatform.d.c();
        }
    }

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JL\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016J&\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u0019"}, d2 = {"com/obric/memorydata/middleware/impl/abtest/AbTestInitImpl$registerAppLogDidReadyListener$1", "Lcom/bytedance/applog/IDataObserver;", "onRemoteIdGet", "", "changed", "", "oldDid", "", "newDid", "oldIid", "newIid", "oldSsid", "newSsid", "onIdLoaded", "did", "iid", Api.KEY_SSID, "onRemoteConfigGet", "config", "Lorg/json/JSONObject;", "onRemoteAbConfigGet", "abConfig", "onAbVidsChange", "vids", "extVids", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.bytedance.applog.g {
        b() {
        }

        @Override // com.bytedance.applog.g
        public void a(String r1, String r2, String r3) {
            CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L5;
        L8:
            boolean r4 = true;
        L9:
            if (r4 == true) goto L12;
            com.bytedance.dataplatform.d.c();
            return;
        L12:
            return;
        L5:
            if (r0.length() == 0) goto L8;
            r4 = false;
            goto L9
        }

        @Override // com.bytedance.applog.g
        public void a(boolean r1, String r2, String r3, String r4, String r5, String r6, String r7) {
            if (r1 == false) goto L13;
            CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin");
            if (r0 != null) goto L6;
        L9:
            boolean r8 = true;
        L10:
            if (r8 == true) goto L14;
            com.bytedance.dataplatform.d.c();
            return;
        L14:
            return;
        L6:
            if (r0.length() == 0) goto L9;
            r8 = false;
            goto L10
        }

        @Override // com.bytedance.applog.g
        public void a(boolean r1, JSONObject r2) {
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J/\u0010\u0006\u001a\u0004\u0018\u0001H\u0007\"\n\b\u0000\u0010\u0007*\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"com/obric/memorydata/middleware/impl/abtest/AbTestInitImpl$serializationService$1", "Lcom/bytedance/dataplatform/ISerializationService;", "object2Json", "", "instance", "", "parseObject", ExifInterface.GPS_DIRECTION_TRUE, "input", "type", "Ljava/lang/reflect/Type;", "(Ljava/lang/String;Ljava/lang/reflect/Type;)Ljava/lang/Object;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements j {
        c() {
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J7\u0010\u0002\u001a\u0004\u0018\u0001H\u0003\"\n\b\u0000\u0010\u0003*\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u0001H\u0003H\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"com/obric/memorydata/middleware/impl/abtest/AbTestInitImpl$settings$1", "Lcom/bytedance/dataplatform/ISettings;", "getValue", ExifInterface.GPS_DIRECTION_TRUE, "", "key", "", "type", "Ljava/lang/reflect/Type;", "defaultValue", "(Ljava/lang/String;Ljava/lang/reflect/Type;Ljava/lang/Object;)Ljava/lang/Object;", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d implements k {
        d() {
        }
    }

    static {
        INSTANCE = new AbTestInitImpl();
        gson = new Gson();
        experimentListener = $$Lambda$AbTestInitImpl$JAeHGGWNoRCWkxyxZErbh_GzIbc.INSTANCE;
        settings = new d();
        serializationService = new c();
        exposureService = $$Lambda$AbTestInitImpl$bX8tE3bMceSdyYOpj6tdexH2oc.INSTANCE;
        netService = $$Lambda$AbTestInitImpl$FH5q6jh7YqoJHCXg0WaStxDja6Y.INSTANCE;
        loginStateListener = new a();
    }

    private AbTestInitImpl() {
    }

    public static final /* synthetic */ Gson access$getGson$p() {
        return gson;
    }

    private static final void experimentListener$lambda$6(JSONObject r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (com.obric.memorydata.middleware.impl.abtest.d.f11679a.a() == false) goto L18;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        Object r3 = Result.m1421constructorimpl(JsonParser.parseString(r2.toString()).getAsJsonObject());     // Catch: Throwable -> L8
    L11:
        if (Result.m1424exceptionOrNullimpl(r3) != null) goto L17;
        final JsonObject r4 = (JsonObject) ZeusTransformUtils.preCheckCast(r3, JsonObject.class, "com.obric.memorydata.plugin");
        y.a($$Lambda$AbTestInitImpl$E4OLuDsYU0dUYhEuQ0qeMCanLo.INSTANCE, new $$Lambda$AbTestInitImpl$2MHk9PIBYHQ1C0Uw94PIX_h0tM(r4));
        return;
    L17:
        return;
    L8:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r3 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    private static final Unit experimentListener$lambda$6$lambda$3(Exception r7) {
        Intrinsics.checkNotNullParameter(r7, "it");
        ((o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin")).a("abmock_config_save_failed", "ABMock Libra config save failed", new e(null, null, null, 7, null), new com.obric.memorydata.middleware.api.logging.g().a());
        return Unit.INSTANCE;
    }

    private static final Unit experimentListener$lambda$6$lambda$5(JsonObject r7) {
        com.bytedance.ies.abmock.datacenter.precise.c r0 = com.bytedance.ies.abmock.datacenter.precise.c.f2698a;
        Intrinsics.checkNotNull(r7);
        com.bytedance.ies.abmock.datacenter.precise.c.a(r0, r7, null, 2, null);
        com.bytedance.ies.abmock.datacenter.storage.k.a(r7, null);
        o r8 = (o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin");
        e r6 = new e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L6;
        com.obric.memorydata.middleware.api.logging.g r1 = new com.obric.memorydata.middleware.api.logging.g();
        Unit r2 = Unit.INSTANCE;
        r8.a("ABMock Libra config saved", r6, r1.a());
    L6:
        return Unit.INSTANCE;
    }

    private static final void exposureService$lambda$7(String r2) {
        com.obric.memorydata.middleware.impl.abtest.b.f11675a.a().update(AbVersionSource.AB_TEST_SDK, r2);
    }

    @JvmStatic
    public static final AbTestInitImpl getInst() {
        return INSTANCE;
    }

    private static final Unit initialize$lambda$12(Exception r12) {
        Intrinsics.checkNotNullParameter(r12, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);
        o.a((o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin"), "ABMock and AB Test SDK initialization failed", "abtest_sdk_initialization_failed", "abtest_sdk_initialization_failed", (Throwable) ZeusTransformUtils.preCheckCast(r12, Throwable.class, "com.obric.memorydata.plugin"), null, null, 48, null);
        if (AppContext.INSTANCE.isAdminMode() == true) goto L7;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("ABMock and AB Test SDK initialization failed", (Throwable) ZeusTransformUtils.preCheckCast(r12, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private static final Unit initialize$lambda$16() {
        if (com.obric.memorydata.middleware.impl.abtest.d.f11679a.a() == false) goto L10;
        ConfigurationManager.a().a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), (com.bytedance.ies.abmock.g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.middleware.impl.abtest.a(), com.bytedance.ies.abmock.g.class, "com.obric.memorydata.plugin"), false);
        com.bytedance.dataplatform.d.b();
        com.bytedance.dataplatform.d.a($$Lambda$AbTestInitImpl$qc0obiqLDMzTtYzU5KlEeweB5AI.INSTANCE, true, true);
        com.bytedance.dataplatform.d.a(experimentListener);
        com.bytedance.dataplatform.d.a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin"), AB_TEST_SDK_HOST, true, (k) ZeusTransformUtils.preCheckCast(settings, k.class, "com.obric.memorydata.plugin"), (j) ZeusTransformUtils.preCheckCast(serializationService, j.class, "com.obric.memorydata.plugin"), exposureService, netService);
        com.bytedance.dataplatform.d.a(UserSettings.INSTANCE.getUserId());
        INSTANCE.registerAppLogDidReadyListener();
        UserSettings.INSTANCE.registerLoginStateListener((com.obric.memorydata.middleware.api.app.d) ZeusTransformUtils.preCheckCast(loginStateListener, com.obric.memorydata.middleware.api.app.d.class, "com.obric.memorydata.plugin"));
        initialized = true;
        o r0 = (o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin");
        e r7 = new e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L8;
        com.obric.memorydata.middleware.api.logging.g r1 = new com.obric.memorydata.middleware.api.logging.g();
        Unit r2 = Unit.INSTANCE;
        r0.a("ABMock and AB Test SDK initialized", r7, r1.a());
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("ABMock plugin config must be registered before initialization".toString());
    }

    private static final void initialize$lambda$16$lambda$14(String r0, JSONObject r1) {
        AppLog.onEventV3(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$-E4OLuDsYU0dUYhEuQ0qeMCanLo, reason: not valid java name */
    public static /* synthetic */ Unit m1008lambda$E4OLuDsYU0dUYhEuQ0qeMCanLo(Exception r0) {
        return experimentListener$lambda$6$lambda$3(r0);
    }

    /* JADX INFO: renamed from: lambda$2MHk9PIBYHQ1-C0Uw94PIX_h0tM, reason: not valid java name */
    public static /* synthetic */ Unit m1009lambda$2MHk9PIBYHQ1C0Uw94PIX_h0tM(JsonObject r0) {
        return experimentListener$lambda$6$lambda$5(r0);
    }

    public static /* synthetic */ Unit lambda$2aHhROAYmX4cJVmaLYiQjO4nNOk(Exception r0) {
        return initialize$lambda$12(r0);
    }

    /* JADX INFO: renamed from: lambda$5HoaZdA2RkxUyD51-eYUSW7xLMg, reason: not valid java name */
    public static /* synthetic */ Unit m1010lambda$5HoaZdA2RkxUyD51eYUSW7xLMg() {
        return initialize$lambda$16();
    }

    public static /* synthetic */ String lambda$FH5q6jh7YqoJHCXg0WaStxDja6Y(String r0) {
        return netService$lambda$11(r0);
    }

    public static /* synthetic */ void lambda$JAeHGGWNoRCWkxyxZErbh_GzIbc(JSONObject r0) {
        experimentListener$lambda$6(r0);
    }

    /* JADX INFO: renamed from: lambda$bX8tE3bMceSdyYOpj6tdexH-2oc, reason: not valid java name */
    public static /* synthetic */ void m1011lambda$bX8tE3bMceSdyYOpj6tdexH2oc(String r0) {
        exposureService$lambda$7(r0);
    }

    public static /* synthetic */ void lambda$qc0obiqLDMzTtYzU5KlEeweB5AI(String r0, JSONObject r1) {
        initialize$lambda$16$lambda$14(r0, r1);
    }

    private static final String netService$lambda$11(String r10) {
        Object r2 = null;
        if (NetworkUtils.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L18;
        return null;
    L18:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        String r11 = Uri.parse(r10).buildUpon().appendQueryParameter(LIBRA_EXPERIMENT_QUERY_PARAM, "1").build().toString();     // Catch: Throwable -> L7
        Intrinsics.checkNotNullExpressionValue(r11, "toString(...)");     // Catch: Throwable -> L7
        Object r12 = Result.m1421constructorimpl((String) ZeusTransformUtils.preCheckCast(GeneralService.get(AppLog.addNetCommonParams((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r11, true, Level.L1), null, String.class), String.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L7
    L10:
        if (Result.m1424exceptionOrNullimpl(r12) == null) goto L13;
        ((o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin")).a("abtest_request_failed", "AB Test SDK request failed", new e(null, null, null, 7, null), new com.obric.memorydata.middleware.api.logging.g().a());
    L13:
        if (Result.m1427isFailureimpl(r12) == true) goto L17;
        r2 = r12;
    L17:
        return (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
    L7:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final void registerAppLogDidReadyListener() {
        AppLog.addDataObserver((com.bytedance.applog.g) ZeusTransformUtils.preCheckCast(new b(), com.bytedance.applog.g.class, "com.obric.memorydata.plugin"));
        CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(AppLog.getDid(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L12;
        com.bytedance.dataplatform.d.c();
        return;
    L12:
        return;
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    @Override // com.obric.memorydata.middleware.api.abtest.IAbTestInit
    public synchronized void initialize() {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (initialized == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        y.a($$Lambda$AbTestInitImpl$2aHhROAYmX4cJVmaLYiQjO4nNOk.INSTANCE, $$Lambda$AbTestInitImpl$5HoaZdA2RkxUyD51eYUSW7xLMg.INSTANCE);     // Catch: Throwable -> L10
        monitor-exit(this);
    }

    @Override // com.obric.memorydata.middleware.api.abtest.IAbTestInit
    public void registerPluginConfig(Context r2) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "pluginContext");
        com.obric.memorydata.middleware.impl.abtest.d.f11679a.a(r1);
    }
}
