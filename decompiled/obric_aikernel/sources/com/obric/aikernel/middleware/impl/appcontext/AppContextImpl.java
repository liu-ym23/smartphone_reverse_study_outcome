package com.obric.aikernel.middleware.impl.appcontext;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.news.common.service.manager.IService;
import com.obric.aikernel.api.b;
import com.obric.aikernel.middleware.api.appcontext.AppContext;
import com.obric.aikernel.middleware.api.appcontext.IAppBuildConfig;
import com.obric.aikernel.middleware.api.appcontext.IAppConfig;
import com.obric.aikernel.middleware.api.appcontext.IAppContext;
import com.obric.aikernel.middleware.api.log.AIKLog;
import com.obric.aikernel.utils.MultiUserUtils;
import d4.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.z0;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"StaticFieldLeak"})
public final class AppContextImpl implements IAppContext {
    private static final IAppBuildConfig AppBuildConfig = null;
    public static final AppContextImpl INSTANCE = null;
    private static final String TAG = "AppContextImpl";
    private static final long appStartTime = 0;
    private static Application application;
    private static Context baseContext;
    private static final ConcurrentHashMap<String, Long> dispatchThreadTidMap = null;
    private static final Lazy isClearColdBoot$delegate = null;

    /* JADX INFO: renamed from: com.obric.aikernel.middleware.impl.appcontext.AppContextImpl$postRestart$1, reason: invalid class name */
    @DebugMetadata(c = "com.obric.aikernel.middleware.impl.appcontext.AppContextImpl$postRestart$1", f = "AppContextImpl.kt", i = {1}, l = {Constants.UPLOAD_DISASTER_ESCAPE, 224}, m = "invokeSuspend", n = {"prefs"}, s = {"L$0"})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $WAIT_INTERVAL_MS;
        final /* synthetic */ long $delayMs;
        final /* synthetic */ int $signalCode;
        final /* synthetic */ String $source;
        Object L$0;
        int label;

        AnonymousClass1(long r10, long r11, String r12, int r13, Continuation<? super AnonymousClass1> r14) {
            this.$delayMs = r10;
            this.$WAIT_INTERVAL_MS = r11;
            this.$source = r12;
            this.$signalCode = r13;
            super(2, r14);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
            return new AnonymousClass1(this.$delayMs, this.$WAIT_INTERVAL_MS, this.$source, this.$signalCode, r11);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
            return invoke2(r10, r11);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
            return ((AnonymousClass1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r12) {
            Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r11 = this.label;
            if (r11 == 0) goto L10;
            if (r11 == 1) goto L9;
            if (r11 != 2) goto L8;
            SharedPreferences r13 = (SharedPreferences) this.L$0;
            ResultKt.throwOnFailure(r12);
        L21:
            SharedPreferences r14 = r13;
        L22:
            Intrinsics.checkNotNullExpressionValue(r14, "prefs");
            SharedPreferences.Editor r15 = r14.edit();
            Intrinsics.checkNotNullExpressionValue(r15, "editor");
            r15.putLong("last_kill_time", System.currentTimeMillis());
            r15.commit();
            AIKLog.INSTANCE.e(AppContextImpl.TAG, "[STUCK_TRACING] ready to restart source=" + this.$source + '.');
            Process.sendSignal(Process.myPid(), this.$signalCode);
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r12);
        L13:
            r14 = AppContextImpl.INSTANCE.getContext().getSharedPreferences("process_killer_prefs", 0);
            long r16 = r14.getLong("last_kill_time", 0);
            long r17 = System.currentTimeMillis();
            AIKLog r18 = AIKLog.INSTANCE;
            r18.d(AppContextImpl.TAG, "[STUCK_TRACING] postRestart: lastKillTime = " + r16 + ", now = " + r17);
            if (r17 <= r16) goto L22;
            long r19 = r17 - r16;
            long r20 = this.$WAIT_INTERVAL_MS;
            if (r19 >= r20) goto L22;
            long r21 = r20 - r19;
            r18.w(AppContextImpl.TAG, "[STUCK_TRACING] last restart elapse " + r19 + "ms, need wait " + r21 + "ms");
            this.L$0 = r14;
            this.label = 2;
            if (DelayKt.b(r21, this) != r10) goto L20;
            return r10;
        L20:
            r13 = r14;
            goto L21
        L10:
            ResultKt.throwOnFailure(r12);
            long r22 = this.$delayMs;
            this.label = 1;
            if (DelayKt.b(r22, this) != r10) goto L13;
            return r10;
        }
    }

    static {
        INSTANCE = new AppContextImpl();
        dispatchThreadTidMap = new ConcurrentHashMap();
        IService r10 = a.a(Reflection.getOrCreateKotlinClass(IAppBuildConfig.class));
        Intrinsics.checkNotNull(r10);
        AppBuildConfig = (IAppBuildConfig) r10;
        appStartTime = SystemClock.elapsedRealtime();
        isClearColdBoot$delegate = LazyKt.lazy(AnonymousClass2.INSTANCE);
    }

    private AppContextImpl() {
    }

    @JvmStatic
    public static final AppContextImpl getInst() {
        return INSTANCE;
    }

    private final boolean isClearColdBoot() {
        return ((Boolean) isClearColdBoot$delegate.getValue()).booleanValue();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String appEnv() {
        return AppBuildConfig.appEnv();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public void cacheDispatchThreadTid(String r10, long r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Long r12 = Long.valueOf(r11);
        dispatchThreadTidMap.put(r10, r12);
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String defaultTTEnvHeader() {
        return AppBuildConfig.defaultTTEnvHeader();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String defaultWebEnvHeader() {
        return AppBuildConfig.defaultWebEnvHeader();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getAIKBizType() {
        return AppBuildConfig.getAIKBizType();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getAIKTargetSoC() {
        return AppBuildConfig.getAIKTargetSoC();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public int getAid() {
        return AppBuildConfig.getAid();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public t7.a getAikStore() {
        return IAppContext.a.a(this);
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public int getAndroidUserId() {
        return AppContext.INSTANCE.getAikStore().getInt("main_host_user_id", 0);
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getAppName() {
        return AppBuildConfig.getAppName();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public long getAppStartTime() {
        return appStartTime;
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getAppTrackerTag() {
        return AppBuildConfig.getAppTrackerTag();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public Application getApplication() {
        Application r10 = application;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("application");
        return null;
    L6:
        return r10;
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getBuildInfo() {
        return AppBuildConfig.getBuildInfo();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getChannel() {
        return AppBuildConfig.getChannel();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public Context getContext() {
        Context r10 = baseContext;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("baseContext");
        return null;
    L6:
        return r10;
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public Map<String, Long> getDispatchThreadTidSnapshot() {
        return MapsKt.toMap(dispatchThreadTidMap);
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getDistributePath() {
        return AppBuildConfig.getDistributePath();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getHost(IAppConfig.HOST_TYPE r10) {
        Intrinsics.checkNotNullParameter(r10, "hostType");
        return AppBuildConfig.getHost(r10);
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getIid() {
        String r10 = com.bytedance.applog.a.e();
        Intrinsics.checkNotNullExpressionValue(r10, "getIid()");
        return r10;
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getModelDistPath() {
        return AppBuildConfig.getModelDistPath();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getPackageName() {
        Context r10 = baseContext;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("baseContext");
        r10 = null;
    L5:
        String r11 = r10.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r11, "baseContext.packageName");
        return r11;
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public int getPid() {
        return Process.myPid();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getServerDeviceId() {
        return b.f4431a.a().e();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public Map<String, Object> getSlardarExtras() {
        return AppBuildConfig.getSlardarExtras();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public int getUpdateVersionCode() {
        return AppBuildConfig.getUpdateVersionCode();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getUserId() {
        String r10 = com.bytedance.applog.a.h();
        if (r10 != null) goto L6;
        return "";
    L6:
        return r10;
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public int getVersionCode() {
        return AppBuildConfig.getVersionCode();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public String getVersionName() {
        return AppBuildConfig.getVersionName();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public boolean isAdminMode() {
        return AppBuildConfig.isAdminMode();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public boolean isDebug() {
        return AppBuildConfig.isDebug();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public boolean isFirstColdBoot() {
        return isClearColdBoot();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public boolean isGlobalVersion() {
        return AppBuildConfig.isGlobalVersion();
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public boolean isLocalTest() {
        return b.f4431a.a().k(getChannel());
    }

    public final String logString() {
        return "AppContextInfo[versionCode:" + getVersionCode() + "|versionName:" + getVersionName() + "|updateVersionCode:" + getUpdateVersionCode() + "|channel:" + getChannel() + "|isDebug:" + isDebug() + "|isAdmin:" + isAdminMode() + "|appName:" + getAppName() + "|buildinFO:" + getBuildInfo() + "|appEnv:" + appEnv() + "|envHeader:" + defaultTTEnvHeader() + "|aid:" + getAid() + ']';
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public void postRestart(String r10, String r11, long r12, int r14) {
        Intrinsics.checkNotNullParameter(r10, "source");
        Intrinsics.checkNotNullParameter(r11, "reason");
        AIKLog.INSTANCE.e(TAG, "[STUCK_TRACING] postRestart: source = " + r10 + ", reason = " + r11 + ", delayMs = " + r12 + ", signalCode = " + r14);
        h.d(m0.a(z0.c()), null, null, new AnonymousClass1(r12, 300000, r10, r14, null), 3, null);
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public void setApplicationContext(Application r10, Context r11) {
        Intrinsics.checkNotNullParameter(r10, "application");
        Intrinsics.checkNotNullParameter(r11, "context");
        application = r10;
        baseContext = r11;
        StringBuilder r12 = new StringBuilder();
        r12.append("setApplicationContext ");
        String r13 = Process.myProcessName();
        AppContext r14 = AppContext.INSTANCE;
        r12.append(Intrinsics.areEqual(r13, r14.getPackageName()));
        r12.append(", userID=");
        MultiUserUtils r15 = MultiUserUtils.f5580a;
        r12.append(r15.a());
        Log.e(TAG, r12.toString());
        if (Intrinsics.areEqual(Process.myProcessName(), r14.getPackageName()) == false) goto L6;
        r14.getAikStore().d("main_host_user_id", r15.a());
        return;
    }

    @Override // com.obric.aikernel.middleware.api.appcontext.IAppContext
    public boolean testStubApp() {
        return AppBuildConfig.testStubApp();
    }
}
