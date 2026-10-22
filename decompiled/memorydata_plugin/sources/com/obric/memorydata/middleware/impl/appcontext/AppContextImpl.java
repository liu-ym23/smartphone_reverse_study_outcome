package com.obric.memorydata.middleware.impl.appcontext;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Process;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.util.RomUtils;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.service.manager.ext.ServiceManagerExtKt;
import com.obric.aiagent.product.platform.api.IPlatformService;
import com.obric.aiagent.product.platform.api.rom.IRomInfo;
import com.obric.aiagent.sharedstate.SharedState;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.appcontext.IAppBuildConfig;
import com.obric.memorydata.middleware.api.appcontext.IAppConfig;
import com.obric.memorydata.middleware.api.appcontext.IAppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.middleware.impl.bdtracker.MemoryAppLogSettings;
import com.obric.memorydata.utils.am;
import com.obric.memorydata.utils.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u0000H\u0007J\u0018\u0010#\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u000bH\u0016J\b\u0010%\u001a\u00020&H\u0016J\b\u0010'\u001a\u00020\u0005H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J\b\u0010)\u001a\u00020\u0005H\u0016J\b\u0010*\u001a\u00020\u0005H\u0016J\b\u0010+\u001a\u00020&H\u0016J\b\u0010,\u001a\u00020\u0005H\u0016J \u0010-\u001a\u0004\u0018\u00010\u00052\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0016J\n\u0010/\u001a\u0004\u0018\u00010\u0005H\u0002J\u001c\u00100\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u000203H\u0002J\u001c\u00104\u001a\u0004\u0018\u00010\u00052\b\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u00102\u001a\u000203H\u0002J\u0018\u00105\u001a\u00020\u00122\u0006\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u000203H\u0002J\b\u00106\u001a\u00020\u0017H\u0016J\b\u00107\u001a\u00020\u0005H\u0016J\b\u00108\u001a\u00020\u0005H\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\b\u0010:\u001a\u00020\u0005H\u0016J\b\u0010;\u001a\u00020\u0017H\u0016J\b\u0010<\u001a\u00020\u0017H\u0016J\b\u0010=\u001a\u00020\u0005H\u0016J\b\u0010>\u001a\u00020\u0017H\u0016J\b\u0010?\u001a\u00020\u0017H\u0016J\u0010\u0010@\u001a\u00020\u00122\u0006\u0010A\u001a\u00020\u0017H\u0016J\b\u0010B\u001a\u00020\u0017H\u0016J\b\u0010C\u001a\u00020\u000bH\u0016J\b\u0010D\u001a\u00020\tH\u0016J\b\u0010E\u001a\u00020\u0005H\u0016J\b\u0010F\u001a\u00020&H\u0016J\b\u0010G\u001a\u00020&H\u0016J\b\u0010H\u001a\u00020\u0005H\u0016J\b\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020\u0005H\u0016J\b\u0010L\u001a\u00020\u0017H\u0016J\u0010\u0010M\u001a\u00020\u00052\u0006\u0010N\u001a\u00020OH\u0016J\u0010\u0010P\u001a\u00020\u00052\u0006\u0010N\u001a\u00020OH\u0002J\b\u0010Q\u001a\u00020\u0005H\u0016J\b\u0010R\u001a\u00020\u0005H\u0016J\b\u0010S\u001a\u00020\u0005H\u0016J\b\u0010T\u001a\u00020\u0005H\u0016J\u0014\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020W0VH\u0016J\b\u0010X\u001a\u00020\u0005H\u0016J\b\u0010Y\u001a\u00020\u0005H\u0016J\b\u0010Z\u001a\u00020\u0005H\u0016J\b\u0010[\u001a\u00020\u0017H\u0016J\b\u0010\\\u001a\u00020\u0017H\u0016J\b\u0010]\u001a\u00020\u0005H\u0016J\b\u0010^\u001a\u00020\u0005H\u0016J\b\u0010_\u001a\u00020\u0005H\u0016J\u0006\u0010`\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0018\u001a\n \u0019*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0018\u0010\u001b\u001a\n \u0019*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR(\u0010\u001e\u001a\u0004\u0018\u00010\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u00158V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006a"}, d2 = {"Lcom/obric/memorydata/middleware/impl/appcontext/AppContextImpl;", "Lcom/obric/memorydata/middleware/api/appcontext/IAppContext;", "<init>", "()V", "TAG", "", "AppBuildConfig", "Lcom/obric/memorydata/middleware/api/appcontext/IAppBuildConfig;", "application", "Landroid/app/Application;", "baseContext", "Landroid/content/Context;", "cachedOsDeviceId", "osDeviceIdFetching", "Ljava/util/concurrent/atomic/AtomicBoolean;", "pendingOsDeviceIdHandlers", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function1;", "", "STORE_KEY_OS_DEVICE_ID", "curActivity", "Landroid/app/Activity;", "debuggable", "", "romVersion", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "logEnableStatus", "getInst", EventBody.KEY_VALUE, "topActivity", "getTopActivity", "()Landroid/app/Activity;", "setTopActivity", "(Landroid/app/Activity;)V", "setApplicationContext", "context", "getVersionCode", "", "getVersionName", "getPluginVersionName", "getPluginPkgName", "getHostPkgName", "getUpdateVersionCode", "getServerDeviceId", "getOsDeviceId", "onDidUpdated", "getValidMemoryCachedDid", "cacheValidSdkDid", "rawDid", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "cacheValidStoredDid", "handleAsyncDid", "isLogin", "getToken", "getUserName", "getUserId", "getChannel", "isDebug", "isRoot", "getRomVersion", "isAllLogEnabled", "isLocalTest", "enableDebug", "debug", "isAdminMode", "getContext", "getApplication", "getPackageName", "getPid", "getAid", "getSecurityAid", "getApkId", "", "getAppTrackerTag", "isHostApp", "getHost", "hostType", "Lcom/obric/memorydata/middleware/api/appcontext/IAppConfig$HOST_TYPE;", "defaultHost", "getLanguage", "getAppName", "getBuildInfo", "getRegion", "getSlardarExtras", "", "", "getIid", "getPuiVersion", "getFlavor", "isObricFlavor", "isSsFlavor", "appEnv", "defaultTTEnvHeader", "defaultWebEnvHeader", "logString", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AppContextImpl implements IAppContext {
    private static final IAppBuildConfig AppBuildConfig = null;
    public static final AppContextImpl INSTANCE = null;
    private static final String STORE_KEY_OS_DEVICE_ID = "ai_lab_os_device_id";
    private static final String TAG = "AppContextImpl";
    private static Application application;
    private static Context baseContext;
    private static volatile String cachedOsDeviceId;
    private static Activity curActivity;
    private static boolean debuggable;
    private static final String logEnableStatus = null;
    private static final AtomicBoolean osDeviceIdFetching = null;
    private static final CopyOnWriteArrayList<Function1<String, Unit>> pendingOsDeviceIdHandlers = null;
    private static final String romVersion = null;

    static {
        INSTANCE = new AppContextImpl();
        IService r0 = ServiceManagerExtKt.impl(Reflection.getOrCreateKotlinClass(IAppBuildConfig.class));
        Intrinsics.checkNotNull(r0);
        AppBuildConfig = (IAppBuildConfig) ZeusTransformUtils.preCheckCast(r0, IAppBuildConfig.class, "com.obric.memorydata.plugin");
        osDeviceIdFetching = new AtomicBoolean(false);
        pendingOsDeviceIdHandlers = new CopyOnWriteArrayList();
        romVersion = RomUtils.getSystemProperty("ro.os.ota.version");
        logEnableStatus = RomUtils.getSystemProperty("persist.memorydata.debug");
    }

    private AppContextImpl() {
    }

    private final String cacheValidSdkDid(String r7, IStore r8) {
        IStore r6 = (IStore) ZeusTransformUtils.wrapperContextForParams(r8, IStore.class, "com.obric.memorydata.plugin");
        String r9 = a.a(r7);
        if (r9 == null) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "getOSDeviceIdFromCache returned valid did", false, 4, null);
        cachedOsDeviceId = r9;
        r6.save(STORE_KEY_OS_DEVICE_ID, r9);
    L16:
        return r9;
    L5:
        CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L8;
    L11:
        boolean r11 = true;
    L12:
        if (r11 == false) goto L14;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r3 = null;
        int r4 = 4;
        Object r5 = null;
        String r1 = TAG;
        String r2 = "getOSDeviceIdFromCache returned empty did";
    L15:
        IRunLog.a.a(r0, r1, r2, r3, r4, r5);
        goto L16
    L14:
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r3 = null;
        r4 = 4;
        r5 = null;
        r1 = TAG;
        r2 = "[code=invalid_os_device_id_sdk_cache] ignore invalid sdk cached did";
        goto L15
    L8:
        if (r10.length() == 0) goto L11;
        r11 = false;
        goto L12
    }

    private final String cacheValidStoredDid(String r7, IStore r8) {
        final IStore r6 = (IStore) ZeusTransformUtils.wrapperContextForParams(r8, IStore.class, "com.obric.memorydata.plugin");
        String r9 = a.a(r7, new $$Lambda$AppContextImpl$3aQuHr0SCCFwnxjxedp9gLpAgz8(r6));
        if (r9 == null) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "read valid did from StoreManager", false, 4, null);
        cachedOsDeviceId = r9;
    L7:
        return r9;
    L5:
        if (r7 != null) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "read did from StoreManager returned empty did", null, 4, null);
        goto L7
    }

    private static final Unit cacheValidStoredDid$lambda$12(IStore r8) {
        IStore r9 = (IStore) ZeusTransformUtils.wrapperContextForParams(r8, IStore.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r10 = Result.m1421constructorimpl(Boolean.valueOf(r9.remove(new String[]{STORE_KEY_OS_DEVICE_ID})));     // Catch: Throwable -> L5
    L8:
        if (Result.m1427isFailureimpl(r10) == false) goto L11;
        r10 = false;
    L11:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L13;
        String r11 = "[code=invalid_os_device_id_store_cache] removed invalid stored did";
    L14:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, r11, null, 4, null);
        return Unit.INSTANCE;
    L13:
        r11 = "[code=invalid_os_device_id_store_cleanup_failed] failed to remove invalid stored did";
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final String defaultHost(IAppConfig.HOST_TYPE r1) {
        return "ofa.obriccloud.com";
    }

    @JvmStatic
    public static final AppContextImpl getInst() {
        return INSTANCE;
    }

    private static final Unit getOsDeviceId$lambda$9$lambda$8(AppContextImpl r2, IStore r3, String r4) {
        IStore r5 = (IStore) ZeusTransformUtils.wrapperContextForParams(r3, IStore.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "rawDidFromAsync");
        r2.handleAsyncDid(r4, r5);     // Catch: Throwable -> L6
        osDeviceIdFetching.set(false);
        return Unit.INSTANCE;
    L6:
        th = move-exception;
        osDeviceIdFetching.set(false);
        throw th;
    }

    private final String getValidMemoryCachedDid() {
        String r7 = cachedOsDeviceId;
        if (r7 != null) goto L5;
        return null;
    L5:
        String r8 = a.a(r7);
        if (r8 != null) goto L8;
        cachedOsDeviceId = null;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "[code=invalid_os_device_id_memory_cache] ignore invalid cached did", null, 4, null);
    L8:
        return r8;
    }

    private final void handleAsyncDid(String r9, IStore r10) {
        IStore r8 = (IStore) ZeusTransformUtils.wrapperContextForParams(r10, IStore.class, "com.obric.memorydata.plugin");
        String r11 = a.a(r9);
        boolean r1 = true;
        if (r11 == null) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "getOSDeviceIdAsync returned valid did", false, 4, null);
        boolean r12 = !Intrinsics.areEqual(cachedOsDeviceId, r11);
        cachedOsDeviceId = r11;
        r8.save(STORE_KEY_OS_DEVICE_ID, r11);
        CopyOnWriteArrayList<Function1<String, Unit>> r13 = pendingOsDeviceIdHandlers;
        if (r12 == false) goto L26;
        List r14 = CollectionsKt.toList((Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.memorydata.plugin"));
        r13.clear();
        Iterator r15 = ((Iterable) ZeusTransformUtils.preCheckCast(r14, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L17:
        if (r15.hasNext() == false) goto L35;
        Function1 r16 = (Function1) ZeusTransformUtils.preCheckCast(r15.next(), Function1.class, "com.obric.memorydata.plugin");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L21
        r16.invoke(r11);     // Catch: Throwable -> L21
        Object r17 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r18 = Result.m1424exceptionOrNullimpl(r17);
        if (r18 == null) goto L17;
        RunLog.INSTANCE.warn(TAG, "onDidUpdated failed", r18);
    L21:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r17 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L23
    L35:
        return;
    L26:
        r13.clear();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "getOSDeviceIdAsync did not change", false, 4, null);
        return;
    L5:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L8;
        r1 = false;
    L8:
        if (r1 == false) goto L10;
        String r19 = "getOSDeviceIdAsync returned empty did";
    L11:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, r19, null, 4, null);
        return;
    L10:
        r19 = "[code=invalid_os_device_id_async] ignore invalid async did";
        goto L11
    }

    public static /* synthetic */ Unit lambda$3aQuHr0SCCFwnxjxedp9gLpAgz8(IStore r0) {
        return cacheValidStoredDid$lambda$12(r0);
    }

    public static /* synthetic */ Unit lambda$XvtnrdbclMktAK72OpEbRiklMsM(AppContextImpl r0, IStore r1, String r2) {
        return getOsDeviceId$lambda$9$lambda$8(r0, r1, r2);
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String appEnv() {
        return AppBuildConfig.appEnv();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String defaultTTEnvHeader() {
        return AppBuildConfig.defaultTTEnvHeader();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String defaultWebEnvHeader() {
        return AppBuildConfig.defaultWebEnvHeader();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public void enableDebug(boolean r1) {
        debuggable = r1;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public int getAid() {
        return AppBuildConfig.getAid();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public long getApkId() {
        return AppBuildConfig.getApkId();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getAppName() {
        return AppBuildConfig.getAppName();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getAppTrackerTag() {
        return AppBuildConfig.getAppTrackerTag();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public Application getApplication() {
        Application r0 = application;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("application");
        return null;
    L6:
        return r0;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getBuildInfo() {
        return AppBuildConfig.getBuildInfo();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getChannel() {
        return AppBuildConfig.getChannel();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public Context getContext() {
        Context r0 = baseContext;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("baseContext");
        return null;
    L6:
        return r0;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getFlavor() {
        return "obric";
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getHost(IAppConfig.HOST_TYPE r4) {
        Intrinsics.checkNotNullParameter(r4, "hostType");
        String r0 = AppBuildConfig.getHost(r4);
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L11;
        return r0;
    L11:
        return defaultHost(r4);
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getHostPkgName() {
        return AppBuildConfig.getHostPkgName();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getIid() {
        return MemoryAppLogSettings.INSTANCE.getIid();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getLanguage() {
        String r1 = Locale.getDefault().getDisplayLanguage();
        Intrinsics.checkNotNullExpressionValue(r1, "getDisplayLanguage(...)");
        return r1;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getOsDeviceId(Function1<? super String, Unit> r18) {
        Function1<String, Unit> r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r18, Function1.class, "com.obric.memorydata.plugin");
        String r0 = getValidMemoryCachedDid();
        if (r0 == null) goto L5;
        return r0;
    L5:
        final IStore r5 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L12
        AppContextImpl r2 = (AppContextImpl) ZeusTransformUtils.preCheckCast(this, AppContextImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        IPlatformService r3 = am.f13169a.a();     // Catch: Throwable -> L12
        if (r3 == null) goto L9;
        IRomInfo r6 = r3.romInfo();     // Catch: Throwable -> L12
    L10:
        Object r7 = Result.m1421constructorimpl(r6);     // Catch: Throwable -> L12
    L15:
        if (Result.m1427isFailureimpl(r7) == false) goto L17;
        r7 = null;
    L17:
        IRomInfo r8 = (IRomInfo) ZeusTransformUtils.preCheckCast(r7, IRomInfo.class, "com.obric.memorydata.plugin");
        IRunLog r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r10 = new StringBuilder().append("getOsDeviceId romInfoAvailable=");
        if (r8 == null) goto L20;
        boolean r11 = true;
    L21:
        IRunLog.a.a(r9, TAG, r10.append(r11).toString(), false, 4, null);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L28
        AppContextImpl r13 = (AppContextImpl) ZeusTransformUtils.preCheckCast(this, AppContextImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L28
        if (r8 == null) goto L25;
        String r14 = r8.getOSDeviceIdFromCache();     // Catch: Throwable -> L28
    L26:
        Object r15 = Result.m1421constructorimpl(r14);     // Catch: Throwable -> L28
    L30:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r15);
        if (r16 == null) goto L34;
        RunLog.INSTANCE.warn(TAG, "getOSDeviceIdFromCache failed", r16);
    L34:
        if (Result.m1427isFailureimpl(r15) == false) goto L36;
        r15 = null;
    L36:
        String r17 = cacheValidSdkDid((String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin"), r5);
        if (r17 == null) goto L70;
        return r17;
    L70:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L41
        AppContextImpl r20 = (AppContextImpl) ZeusTransformUtils.preCheckCast(this, AppContextImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L41
        Object r21 = Result.m1421constructorimpl(r5.getString(STORE_KEY_OS_DEVICE_ID, null));     // Catch: Throwable -> L41
    L43:
        Throwable r22 = Result.m1424exceptionOrNullimpl(r21);
        if (r22 == null) goto L47;
        RunLog.INSTANCE.warn(TAG, "read did from StoreManager failed", r22);
    L47:
        if (Result.m1427isFailureimpl(r21) == false) goto L49;
        r21 = null;
    L49:
        String r23 = cacheValidStoredDid((String) ZeusTransformUtils.preCheckCast(r21, String.class, "com.obric.memorydata.plugin"), r5);
        if (r23 == null) goto L52;
        return r23;
    L52:
        if (r4 == null) goto L55;
        if (r8 == null) goto L55;
        pendingOsDeviceIdHandlers.add(r4);
    L55:
        if (r8 != null) goto L57;
    L65:
        return null;
    L57:
        if (osDeviceIdFetching.compareAndSet(false, true) == false) goto L65;
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L60
        final AppContextImpl r25 = (AppContextImpl) ZeusTransformUtils.preCheckCast(this, AppContextImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L60
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "start getOSDeviceIdAsync", false, 4, null);     // Catch: Throwable -> L60
        r8.getOSDeviceIdAsync(new $$Lambda$AppContextImpl$XvtnrdbclMktAK72OpEbRiklMsM(r25, r5));     // Catch: Throwable -> L60
        Object r26 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L60
    L62:
        Throwable r27 = Result.m1424exceptionOrNullimpl(r26);
        if (r27 == null) goto L65;
        RunLog.INSTANCE.error(TAG, "getOSDeviceIdAsync invoke failed", r27);
        osDeviceIdFetching.set(false);
    L60:
        th = move-exception;
        Result.Companion r28 = Result.Companion;
        r26 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L41:
        th = move-exception;
        Result.Companion r29 = Result.Companion;
        r21 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L43
    L25:
        r14 = null;
    L28:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L30
    L20:
        r11 = false;
        goto L21
    L9:
        r6 = null;
    L12:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getPackageName() {
        Context r1 = baseContext;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("baseContext");
        r1 = null;
    L5:
        String r2 = r1.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r2, "getPackageName(...)");
        return r2;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public int getPid() {
        return Process.myPid();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getPluginPkgName() {
        return AppBuildConfig.getPluginPkgName();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getPluginVersionName() {
        return AppBuildConfig.getPluginVersionName();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getPuiVersion() {
        return d.f13204a.a();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getRegion() {
        String r1 = Locale.getDefault().getCountry();
        Intrinsics.checkNotNullExpressionValue(r1, "getCountry(...)");
        return r1;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getRomVersion() {
        String r1 = romVersion;
        Intrinsics.checkNotNullExpressionValue(r1, "romVersion");
        return r1;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getSecurityAid() {
        return "ocean_memorydata";
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getServerDeviceId() {
        return MemoryAppLogSettings.INSTANCE.getServerDeviceId();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public Map<String, Object> getSlardarExtras() {
        return AppBuildConfig.getSlardarExtras();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getToken() {
        return SharedState.INSTANCE.getString("doubao_account_token", "");
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public Activity getTopActivity() {
        return curActivity;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public int getUpdateVersionCode() {
        return AppBuildConfig.getUpdateVersionCode();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getUserId() {
        return SharedState.INSTANCE.getString("doubao_account_uid", "");
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public String getUserName() {
        return SharedState.INSTANCE.getString("doubao_account_user_name", "");
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public int getVersionCode() {
        return AppBuildConfig.getVersionCode();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public String getVersionName() {
        return AppBuildConfig.getVersionName();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public boolean isAdminMode() {
        if (AppBuildConfig.isAdminMode() == false) goto L5;
    L8:
        return true;
    L5:
        if (debuggable == true) goto L8;
        return false;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public boolean isAllLogEnabled() {
        return Intrinsics.areEqual(logEnableStatus, "1");
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public boolean isDebug() {
        if (AppBuildConfig.isDebug() == false) goto L5;
    L8:
        return true;
    L5:
        if (debuggable == true) goto L8;
        return false;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public boolean isHostApp() {
        return AppBuildConfig.isHostApp();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public boolean isLocalTest() {
        if (Intrinsics.areEqual(getChannel(), "local_test") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(getChannel(), "debug") == true) goto L8;
        return false;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public boolean isLogin() {
        return SharedState.INSTANCE.getBoolean("doubao_login_state", false);
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public boolean isObricFlavor() {
        return true;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppConfig
    public boolean isPureAndroid() {
        return IAppContext.a.a(this);
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public boolean isRoot() {
        String r7 = romVersion;
        Intrinsics.checkNotNullExpressionValue(r7, "romVersion");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("userroot", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L6;
        Intrinsics.checkNotNullExpressionValue(r7, "romVersion");
        if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("userdebug", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L6;
        return false;
    L6:
        return true;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public boolean isSsFlavor() {
        return false;
    }

    public final String logString() {
        StringBuilder r4 = new StringBuilder();
        r4.append("context : ").append((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).append(" \ngetServerDeviceId : ").append(AppContext.INSTANCE.getServerDeviceId()).append(" \ngetUserId : ").append(AppContext.INSTANCE.getUserId()).append(" \ngetPackageName : ").append(AppContext.INSTANCE.getPackageName()).append(" \nisLocalTest : ").append(AppContext.INSTANCE.isLocalTest()).append(" \ngetLanguage : ").append(AppContext.INSTANCE.getLanguage()).append(" \ngetRegion : ").append(AppContext.INSTANCE.getRegion()).append(" \ngetIid : ").append(AppContext.INSTANCE.getIid()).append(" \ngetPuiVersion : ").append(AppContext.INSTANCE.getPuiVersion()).append(" \ngetVersionCode : ").append(AppContext.INSTANCE.getVersionCode()).append(" \ngetVersionName : ").append(AppContext.INSTANCE.getVersionName()).append(" \ngetUpdateVersionCode : ");
        r4.append(AppContext.INSTANCE.getUpdateVersionCode()).append(" \ngetChannel : ").append(AppContext.INSTANCE.getChannel()).append(" \nisDebug : ").append(AppContext.INSTANCE.isDebug()).append(" \nisAdminMode : ").append(AppContext.INSTANCE.isAdminMode()).append(" \ngetAid : ").append(AppContext.INSTANCE.getAid()).append(" \ngetAppName : ").append(AppContext.INSTANCE.getAppName()).append(" \ngetSlardarExtras : ").append(AppContext.INSTANCE.getSlardarExtras()).append(" \nappEnv : ").append(AppContext.INSTANCE.appEnv()).append(" \ndefaultTTEnvHeader : ").append(AppContext.INSTANCE.defaultTTEnvHeader()).append(" \ndefaultWebEnvHeader : ").append(AppContext.INSTANCE.defaultWebEnvHeader()).append(" \ngetApkId : ").append(AppContext.INSTANCE.getApkId()).append(" \ngetAppTrackerTag : ").append(AppContext.INSTANCE.getAppTrackerTag());
        r4.append(" \nisHostApp : ").append(AppContext.INSTANCE.isHostApp()).append(" \nisPureAndroid : ").append(AppContext.INSTANCE.isPureAndroid()).append(" \n");
        return r4.toString();
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public void setApplicationContext(Application r2, Context r3) {
        Application r1 = (Application) ZeusTransformUtils.wrapperContextForParams(r2, Application.class, "com.obric.memorydata.plugin");
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "application");
        Intrinsics.checkNotNullParameter(r4, "context");
        application = r1;
        baseContext = r4;
    }

    @Override // com.obric.memorydata.middleware.api.appcontext.IAppContext
    public void setTopActivity(Activity r2) {
        curActivity = (Activity) ZeusTransformUtils.wrapperContextForParams(r2, Activity.class, "com.obric.memorydata.plugin");
    }
}
