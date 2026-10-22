package com.obric.sva.sdk.effectplatform;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.core.content.ContextCompat;
import bytekn.foundation.logger.Logger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import com.obric.capabilitykit.PackageUtils;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.controller.Global;
import com.obric.sva.sdk.controller.SvaSdkGlobal;
import com.obric.sva.sdk.ipc.TrackAPI;
import com.obric.sva.sdk.sami.SamiPhoneEnrollManager;
import com.obric.sva.sdk.sami.SamiWakeupParamProvider;
import com.obric.sva.sdk.service.WakeupService;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.ugc.effectplatform.EffectConfig;
import com.ss.ugc.effectplatform.algorithm.AlgorithmModelResourceFinder;
import com.ss.ugc.effectplatform.algorithm.AlgorithmResourceManager;
import com.ss.ugc.effectplatform.listener.IEffectPlatformBaseListener;
import com.ss.ugc.effectplatform.model.ExceptionResult;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 R2\u00020\u0001:\u0003RSTB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020\tH\u0002J\b\u0010)\u001a\u00020\tH\u0002J\b\u0010*\u001a\u00020\tH\u0002J\b\u0010+\u001a\u00020\tH\u0002J\b\u0010,\u001a\u00020\tH\u0002J\n\u0010-\u001a\u0004\u0018\u00010%H\u0002J\u0006\u0010.\u001a\u00020\u001dJ\b\u0010/\u001a\u00020'H\u0002J\b\u00100\u001a\u00020'H\u0002J\u0018\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\tH\u0002J\u0006\u00105\u001a\u00020'J\u000e\u00106\u001a\u00020'2\u0006\u00107\u001a\u00020\tJ\b\u00108\u001a\u00020'H\u0002J\b\u00109\u001a\u00020\u001dH\u0002J\b\u0010:\u001a\u00020'H\u0002J\b\u0010;\u001a\u00020'H\u0002J\u0010\u0010<\u001a\u00020'2\u0006\u00107\u001a\u00020\tH\u0002J\u001b\u0010=\u001a\u00020>2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\t0@H\u0002¢\u0006\u0002\u0010AJ\u0010\u0010B\u001a\u00020'2\u0006\u00107\u001a\u00020\tH\u0002J\u0012\u0010C\u001a\u0004\u0018\u00010\t2\u0006\u0010D\u001a\u00020\tH\u0002J\b\u0010E\u001a\u00020'H\u0002J\b\u0010F\u001a\u00020'H\u0002J\u001b\u0010G\u001a\u00020>2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\t0@H\u0002¢\u0006\u0002\u0010AJ\u0006\u0010H\u001a\u00020'J>\u0010I\u001a\u00020'2\u0018\u0010J\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0@\u0012\u0004\u0012\u00020'0K2\u001a\u0010L\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010@\u0012\u0004\u0012\u00020'0KH\u0002J\b\u0010M\u001a\u00020'H\u0002J\b\u0010N\u001a\u00020'H\u0002J\b\u0010O\u001a\u00020'H\u0002J\u0006\u0010P\u001a\u00020\u001dJ\u0006\u0010Q\u001a\u00020\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006U"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/EffectPlatformProvider;", "", "appContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getAppContext", "()Landroid/content/Context;", "mDeviceId", "", "mAppVersionName", "mAppId", "isDownloading", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isAuthDownloading", "handlerThread", "Landroid/os/HandlerThread;", "handler", "Landroid/os/Handler;", "modelPath", "authModelPath", "startDownloadTime", "", "getStartDownloadTime", "()J", "setStartDownloadTime", "(J)V", "needResumeDownload", "fetchDownloadWhenNetworkConnected", "", "fetchDownloadWhenUserLogin", "needResumeAuthDownload", "fetchAuthDownloadWhenNetworkConnected", "authRetryCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "deprecatedAuthSdkCacheCleanupScheduled", "effectConfig", "Lcom/ss/ugc/effectplatform/EffectConfig;", "fetchIPCAsync", "", "queryDeviceIdToNova", "getDeviceId", "getAppId", "getAppVersionName", "getFinalEffectSDKVersion", "generateEffectConfig", "initAlgorithmResourceManager", "scheduleCleanupDeprecatedAuthSdkCacheOnce", "cleanupDeprecatedAuthSdkCache", "isSafeDeprecatedAuthSdkCachePath", "file", "Ljava/io/File;", "modelName", "downloadAsync", "triggerAuthModelDownload", "reason", "downloadAuthModelDelay", "shouldDownloadAuthModel", "clearAuthDownloadRetryState", "downloadAuthModel", "handleAuthDownloadFailure", "processAuthSuccess", "", "array", "", "([Ljava/lang/String;)I", "triggerLegacyMigrationAfterAuthReady", "findAuthSubDirContainManifest", "extractDir", "downloadModelDelay", "downloadModel", "processSuccess", "rollback", "downloadModelInternal", "onSuccess", "Lkotlin/Function1;", "onFailed", "observeNetworkChange", "observeUserLogin", "observeAppForeground", "canRollback", "isEngineInited", "Companion", "NetworkChangeReceiver", "UserLoginReceiver", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class EffectPlatformProvider {
    private static final long AUTH_RETRY_DELAY_MS = 3000;
    private static final int AUTH_RETRY_MAX = 3;
    public static final Companion Companion = null;
    private static final String TAG = "EffectPlatformProvider";
    private static final String VERSION = "16.0.8";
    private final Context appContext;
    private String authModelPath;
    private final AtomicInteger authRetryCount;
    private final AtomicBoolean deprecatedAuthSdkCacheCleanupScheduled;
    private EffectConfig effectConfig;
    private boolean fetchAuthDownloadWhenNetworkConnected;
    private boolean fetchDownloadWhenNetworkConnected;
    private boolean fetchDownloadWhenUserLogin;
    private final Handler handler;
    private final HandlerThread handlerThread;
    private AtomicBoolean isAuthDownloading;
    private AtomicBoolean isDownloading;
    private String mAppId;
    private String mAppVersionName;
    private String mDeviceId;
    private String modelPath;
    private final AtomicBoolean needResumeAuthDownload;
    private AtomicBoolean needResumeDownload;
    private long startDownloadTime;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/EffectPlatformProvider$Companion;", "", "<init>", "()V", "VERSION", "", "CHANNEL", "getCHANNEL", "()Ljava/lang/String;", "ENV", "Lcom/ss/ugc/effectplatform/EffectConfig$ModelFileEnv;", "getENV", "()Lcom/ss/ugc/effectplatform/EffectConfig$ModelFileEnv;", "TAG", "AUTH_RETRY_DELAY_MS", "", "AUTH_RETRY_MAX", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final String getCHANNEL() {
            AppHost.Companion r0 = AppHost.a;
            if (r0.isDebugChannel() == false) goto L5;
        L8:
            return "local_test";
        L5:
            if (r0.isTestChannel() == true) goto L8;
            return "online";
        }

        private final EffectConfig.ModelFileEnv getENV() {
            AppHost.Companion r0 = AppHost.a;
            if (r0.isDebugChannel() == true) goto L9;
            if (r0.isTestChannel() == true) goto L9;
            return EffectConfig.ModelFileEnv.ONLINE;
        L9:
            return EffectConfig.ModelFileEnv.TEST;
        }

        public static final /* synthetic */ String access$getCHANNEL(Companion r0) {
            return r0.getCHANNEL();
        }

        public static final /* synthetic */ EffectConfig.ModelFileEnv access$getENV(Companion r0) {
            return r0.getENV();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/EffectPlatformProvider$NetworkChangeReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "(Lcom/obric/sva/sdk/effectplatform/EffectPlatformProvider;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public final class NetworkChangeReceiver extends BroadcastReceiver {
        final /* synthetic */ EffectPlatformProvider this$0;

        public NetworkChangeReceiver(EffectPlatformProvider r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r4, Intent r5) {
            Intrinsics.checkNotNullParameter(r4, "context");
            Intrinsics.checkNotNullParameter(r5, "intent");
            if (Intrinsics.areEqual("android.net.conn.CONNECTIVITY_CHANGE", r5.getAction()) == true) goto L29;
            return;
        L29:
            Object r6 = r4.getSystemService("connectivity");     // Catch: Exception -> L26
            Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.net.ConnectivityManager");     // Catch: Exception -> L26
            NetworkInfo r7 = ((ConnectivityManager) r6).getActiveNetworkInfo();     // Catch: Exception -> L26
            if (r7 == null) goto L10;
            boolean r2 = true;
            if (r7.isConnected() != true) goto L10;
        L11:
            if (r2 == false) goto L31;
            StringBuilder r8 = new StringBuilder("network connected ,now try to init EP sdk if necessary! initialized ? ");     // Catch: Exception -> L26
            AlgorithmResourceManager.Companion r1 = AlgorithmResourceManager.Companion;     // Catch: Exception -> L26
            r8.append(r1.isInitialized());     // Catch: Exception -> L26
            r8.append(" fetchDownloadWhenNetworkConnected ");     // Catch: Exception -> L26
            r8.append(EffectPlatformProvider.access$getFetchDownloadWhenNetworkConnected$p(this.this$0));     // Catch: Exception -> L26
            r8.append(" fetchAuthDownloadWhenNetworkConnected ");     // Catch: Exception -> L26
            r8.append(EffectPlatformProvider.access$getFetchAuthDownloadWhenNetworkConnected$p(this.this$0));     // Catch: Exception -> L26
            LogUtils.i(EffectPlatformProvider.TAG, r8.toString(), new Object[0]);     // Catch: Exception -> L26
            if (r1.isInitialized() == true) goto L16;
            this.this$0.initAlgorithmResourceManager();     // Catch: Exception -> L26
        L16:
            if (EffectPlatformProvider.access$getFetchDownloadWhenNetworkConnected$p(this.this$0) == false) goto L21;
            if (this.this$0.isEngineInited() == false) goto L21;
            this.this$0.downloadAsync();     // Catch: Exception -> L26
            EffectPlatformProvider.access$setFetchDownloadWhenNetworkConnected$p(this.this$0, false);     // Catch: Exception -> L26
            return;
        L21:
            if (EffectPlatformProvider.access$getFetchAuthDownloadWhenNetworkConnected$p(this.this$0) == true) goto L23;
            return;
        L23:
            if (this.this$0.isEngineInited() == false) goto L34;
            EffectPlatformProvider.access$getAuthRetryCount$p(this.this$0).set(0);     // Catch: Exception -> L26
            EffectPlatformProvider.access$downloadAuthModelDelay(this.this$0);     // Catch: Exception -> L26
            EffectPlatformProvider.access$setFetchAuthDownloadWhenNetworkConnected$p(this.this$0, false);     // Catch: Exception -> L26
            return;
        L34:
            return;
        L31:
            return;
        L10:
            r2 = false;
        L26:
            e = move-exception;
            LogUtils.e(EffectPlatformProvider.TAG, "NetworkChangeReceiver error:" + e, new Object[0]);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/EffectPlatformProvider$UserLoginReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "(Lcom/obric/sva/sdk/effectplatform/EffectPlatformProvider;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public final class UserLoginReceiver extends BroadcastReceiver {
        final /* synthetic */ EffectPlatformProvider this$0;

        public UserLoginReceiver(EffectPlatformProvider r1) {
            this.this$0 = r1;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r7, Intent r8) {
            Intrinsics.checkNotNullParameter(r7, "context");
            Intrinsics.checkNotNullParameter(r8, "intent");
            if (Intrinsics.areEqual(EffectConstant.USER_LOGIN_INTENT, r8.getAction()) == false) goto L9;
            LogUtils.i(EffectPlatformProvider.TAG, "user login received ! needDownload ? " + EffectPlatformProvider.access$getFetchDownloadWhenUserLogin$p(this.this$0) + " engineInited ? " + AlgorithmResourceManager.Companion.isInitialized(), new Object[0]);
            if (EffectPlatformProvider.access$getFetchDownloadWhenUserLogin$p(this.this$0) == true) goto L7;
            return;
        L7:
            BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new onReceive.1(this.this$0, null), 3, null);
            return;
        }
    }

    /* JADX INFO: renamed from: com.obric.sva.sdk.effectplatform.EffectPlatformProvider$downloadAuthModel$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J%\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"com/obric/sva/sdk/effectplatform/EffectPlatformProvider$downloadAuthModel$1", "Lcom/ss/ugc/effectplatform/listener/IEffectPlatformBaseListener;", "", "", "onFail", "", "failedResult", "exception", "Lcom/ss/ugc/effectplatform/model/ExceptionResult;", "([Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/ExceptionResult;)V", "onSuccess", "response", "([Ljava/lang/String;)V", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class AnonymousClass1 implements IEffectPlatformBaseListener<String[]> {
        final /* synthetic */ EffectPlatformProvider this$0;

        public static /* synthetic */ void a(String[] r0, EffectPlatformProvider r1) {
            onSuccess$lambda$1(r0, r1);
        }

        public static /* synthetic */ void b(String[] r0, ExceptionResult r1, EffectPlatformProvider r2) {
            onFail$lambda$0(r0, r1, r2);
        }

        public AnonymousClass1(EffectPlatformProvider r1) {
            this.this$0 = r1;
        }

        public void onSuccess(final String[] r4) {
            Intrinsics.checkNotNullParameter(r4, "response");
            Handler r0 = EffectPlatformProvider.access$getHandler$p(this.this$0);
            final EffectPlatformProvider r1 = this.this$0;
            r0.post(new j(r4, r1));
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((String[]) r1);
        }

        private static final void onSuccess$lambda$1(String[] r14, EffectPlatformProvider r15) {
            LogUtils.i(EffectPlatformProvider.TAG, "downloadAuthModel 😊 success " + ArraysKt.joinToString$default(r14, ",", null, null, 0, null, null, 62, null), new Object[0]);
            int r16 = EffectPlatformProvider.access$processAuthSuccess(r15, r14);     // Catch: Throwable -> L9
            LogUtils.i(EffectPlatformProvider.TAG, "processAuthSuccess code=" + r16 + " (" + EffectConstant.INSTANCE.findError(r16) + ')', new Object[0]);     // Catch: Throwable -> L9
            if (r16 == (-7)) goto L7;
            if (r16 == 0) goto L7;
            EffectPlatformProvider.access$handleAuthDownloadFailure(r15, "process_code_" + r16);     // Catch: Throwable -> L9
        L18:
        L11:
            EffectPlatformProvider.access$isAuthDownloading$p(r15).set(false);
            return;
        L7:
            EffectPlatformProvider.access$getAuthRetryCount$p(r15).set(0);     // Catch: Throwable -> L9
            EffectPlatformProvider.access$getNeedResumeAuthDownload$p(r15).set(false);     // Catch: Throwable -> L9
            EffectPlatformProvider.access$setFetchAuthDownloadWhenNetworkConnected$p(r15, false);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            LogUtils.e(EffectPlatformProvider.TAG, "processAuthSuccess error: " + th.getMessage(), new Object[0]);     // Catch: Throwable -> L13
            EffectPlatformProvider.access$handleAuthDownloadFailure(r15, "process_exception");     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            EffectPlatformProvider.access$isAuthDownloading$p(r15).set(false);
            throw th;
        }

        public void onFail(String[] r4, ExceptionResult r5) {
            Intrinsics.checkNotNullParameter(r5, "exception");
            EffectPlatformProvider.access$getHandler$p(this.this$0).post(new k(r4, r5, this.this$0));
        }

        public /* bridge */ /* synthetic */ void onFail(Object r1, ExceptionResult r2) {
            onFail((String[]) r1, r2);
        }

        private static final void onFail$lambda$0(String[] r11, ExceptionResult r12, EffectPlatformProvider r13) {
            StringBuilder r0 = new StringBuilder("downloadAuthModel 😭 fail ");
            if (r11 == null) goto L5;
            String r14 = ArraysKt.joinToString$default(r11, ",", null, null, 0, null, null, 62, null);
        L6:
            r0.append(r14);
            r0.append(" reason=");
            r0.append(r12.getMsg());
            LogUtils.e(EffectPlatformProvider.TAG, r0.toString(), new Object[0]);
            EffectPlatformProvider.access$isAuthDownloading$p(r13).set(false);
            EffectPlatformProvider.access$handleAuthDownloadFailure(r13, "fetch_fail");
            return;
        L5:
            r14 = null;
            goto L6
        }
    }

    /* JADX INFO: renamed from: com.obric.sva.sdk.effectplatform.EffectPlatformProvider$downloadModelInternal$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J%\u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\tJ\u001b\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"com/obric/sva/sdk/effectplatform/EffectPlatformProvider$downloadModelInternal$1", "Lcom/ss/ugc/effectplatform/listener/IEffectPlatformBaseListener;", "", "", "onFail", "", "failedResult", "exception", "Lcom/ss/ugc/effectplatform/model/ExceptionResult;", "([Ljava/lang/String;Lcom/ss/ugc/effectplatform/model/ExceptionResult;)V", "onSuccess", "response", "([Ljava/lang/String;)V", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class C00071 implements IEffectPlatformBaseListener<String[]> {
        final /* synthetic */ Function1<String[], Unit> $onFailed;
        final /* synthetic */ Function1<String[], Unit> $onSuccess;
        final /* synthetic */ EffectPlatformProvider this$0;

        public static /* synthetic */ void a(EffectPlatformProvider r0, String[] r1, Function1 r2, ExceptionResult r3) {
            onFail$lambda$2(r0, r1, r2, r3);
        }

        public static /* synthetic */ void b(EffectPlatformProvider r0, String[] r1, Function1 r2) {
            onSuccess$lambda$5(r0, r1, r2);
        }

        public void onSuccess(String[] r5) {
            Intrinsics.checkNotNullParameter(r5, "response");
            EffectPlatformProvider.access$getHandler$p(this.this$0).post(new m(this.this$0, r5, this.$onSuccess));
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((String[]) r1);
        }

        public void onFail(final String[] r5, final ExceptionResult r6) {
            Intrinsics.checkNotNullParameter(r6, "exception");
            Handler r0 = EffectPlatformProvider.access$getHandler$p(this.this$0);
            final EffectPlatformProvider r1 = this.this$0;
            final Function1<String[], Unit> r2 = this.$onFailed;
            r0.post(new l(r1, r5, r2, r6));
        }

        public /* bridge */ /* synthetic */ void onFail(Object r1, ExceptionResult r2) {
            onFail((String[]) r1, r2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public C00071(EffectPlatformProvider r1, Function1<? super String[], Unit> r2, Function1<? super String[], Unit> r3) {
            this.this$0 = r1;
            this.$onFailed = r2;
            this.$onSuccess = r3;
        }

        private static final void onSuccess$lambda$5(EffectPlatformProvider r12, String[] r13, Function1 r14) {
            long r0 = System.currentTimeMillis() - r12.getStartDownloadTime();
            int r2 = 0;
            LogUtils.d(EffectPlatformProvider.TAG, "downloadModelInternal fetchResourcesWithModelNames 😊 success " + ArraysKt.joinToString$default(r13, ",", null, null, 0, null, null, 62, null) + " , cost time " + r0 + " ms", new Object[0]);
            TrackAPI r15 = TrackAPI.INSTANCE;
            UpdateTrackerType r3 = UpdateTrackerType.DOWNLOAD_SUCCESS;
            JSONObject r4 = new JSONObject();
            int r5 = r13.length;
        L3:
            if (r2 >= r5) goto L5;
            r4.put("download_response", r13[r2]);
            r2 = r2 + 1;
            goto L3
        L5:
            r4.put("download_cost_time", r0);
            Unit r1 = Unit.INSTANCE;
            r15.trackerModelUpdate(r3, r4);
            r14.invoke(r13);
        }

        private static final void onFail$lambda$2(EffectPlatformProvider r12, String[] r13, Function1 r14, ExceptionResult r15) {
            long r0 = System.currentTimeMillis() - r12.getStartDownloadTime();
            StringBuilder r16 = new StringBuilder("downloadModelInternal fetchResourcesWithModelNames  😭 failed ");
            if (r13 == null) goto L5;
            String r2 = ArraysKt.joinToString$default(r13, ",", null, null, 0, null, null, 62, null);
        L6:
            r16.append(r2);
            r16.append(" , cost time ");
            r16.append(r0);
            r16.append(" ms");
            int r3 = 0;
            LogUtils.d(EffectPlatformProvider.TAG, r16.toString(), new Object[0]);
            r14.invoke(r13);
            TrackAPI r17 = TrackAPI.INSTANCE;
            UpdateTrackerType r18 = UpdateTrackerType.DOWNLOAD_FAILED;
            JSONObject r4 = new JSONObject();
            if (r13 == null) goto L11;
            int r5 = r13.length;
        L9:
            if (r3 >= r5) goto L11;
            r4.put("download_response", r13[r3]);
            r3 = r3 + 1;
        L11:
            String r19 = r15.getMsg();
            if (r19 != null) goto L14;
            r19 = "";
        L14:
            r4.put("download_error_reason", r19);
            r4.put("download_cost_time", r0);
            Unit r110 = Unit.INSTANCE;
            r17.trackerModelUpdate(r18, r4);
            return;
        L5:
            r2 = null;
            goto L6
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ Unit a(EffectPlatformProvider r0, String[] r1) {
        return downloadModel$lambda$28(r0, r1);
    }

    public static /* synthetic */ void b(EffectPlatformProvider r0) {
        downloadAuthModelDelay$lambda$15(r0);
    }

    public static /* synthetic */ void c(EffectPlatformProvider r0) {
        downloadModelDelay$lambda$25(r0);
    }

    public static /* synthetic */ File d(File r0) {
        return isSafeDeprecatedAuthSdkCachePath$lambda$12(r0);
    }

    private final void downloadModelDelay() {
        LogUtils.i(TAG, "will download model after 3s", new Object[0]);
        this.handler.postDelayed(new c(this), 3000);
    }

    public static /* synthetic */ String e(EffectPlatformProvider r0) {
        return triggerLegacyMigrationAfterAuthReady$lambda$22(r0);
    }

    public static /* synthetic */ void f(EffectPlatformProvider r0) {
        handleAuthDownloadFailure$lambda$16(r0);
    }

    public static /* synthetic */ Unit g(EffectPlatformProvider r0, String[] r1) {
        return downloadModel$lambda$29(r0, r1);
    }

    private final String getFinalEffectSDKVersion() {
        return VERSION;
    }

    public static /* synthetic */ boolean h(File r0, File r1) {
        return isSafeDeprecatedAuthSdkCachePath$lambda$13(r0, r1);
    }

    public static /* synthetic */ void i(EffectPlatformProvider r0) {
        scheduleCleanupDeprecatedAuthSdkCacheOnce$lambda$2(r0);
    }

    private final String queryDeviceIdToNova() {
        LogUtils.d(TAG, "get mDeviceId start", new Object[0]);
        Bundle r1 = this.appContext.getContentResolver().call(UriProtector.parse(Global.SVA_SDK_IPC_CONTENT_URL), "device-id", null, null);
        String r3 = "";
        if (r1 == null) goto L8;
        String r2 = r1.getString("did", "");
        if (r2 == null) goto L8;
        r3 = r2;
    L8:
        LogUtils.d(TAG, "get mDeviceId size :" + r3.length(), new Object[0]);
        return r3;
    }

    public final void rollback() {
        LogUtils.i(TAG, "section error hanppens 【注意：模型回滚】, must rollback to previous models ", new Object[0]);
        EffectUtils r4 = EffectUtils.INSTANCE;
        EffectConstant r1 = EffectConstant.INSTANCE;
        boolean r3 = r4.checkContentValid(r1.getPrevRoot());
        LogUtils.i(TAG, "section ROLLBACK model [" + this.modelPath + "] isValid " + r3, new Object[0]);
        if (r3 == false) goto L5;
        LogUtils.i(TAG, "section ROLLBACK model [" + this.modelPath + "] backup content from  " + r1.getPrevRoot() + " to " + r1.getLatestRoot() + ' ', new Object[0]);
        boolean r2 = EffectUtils.copyDir$default(r4, r1.getPrevRoot(), r1.getLatestRoot(), false, 4, null);
        StringBuilder r5 = new StringBuilder("section ROLLBACK model [");
        r5.append(this.modelPath);
        r5.append("] backup done with ");
        r5.append(r2);
        r5.append(" files copied");
        LogUtils.i(TAG, r5.toString(), new Object[0]);
        return;
    L5:
        r4.restoreDefaultConfig();
    }

    private final void cleanupDeprecatedAuthSdkCache() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(AlgorithmResourceManager.Companion.getInstance().getResourceFinder());     // Catch: Throwable -> L4
    L6:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L10;
        LogUtils.w(TAG, "cleanupDeprecatedAuthSdkCache skip: get ResourceFinder fail error=" + r2.getMessage(), new Object[0]);
    L10:
        if (Result.isFailure-impl(r1) == false) goto L12;
        r1 = null;
    L12:
        AlgorithmModelResourceFinder r3 = (AlgorithmModelResourceFinder) r1;
        if (r3 != null) goto L15;
        return;
    L15:
        Iterator<T> r4 = EffectConstant.INSTANCE.getDEPRECATED_DOUBAO_OBRIC_VOICE_AUTH_NAMES().iterator();
    L17:
        if (r4.hasNext() == false) goto L65;
        String r5 = (String) r4.next();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L25
        String r7 = r3.findResourceUri(r5);     // Catch: Throwable -> L25
        if (r7 == null) goto L22;
        String r8 = StringsKt.replace$default(r7, "file://", "", false, 4, null);     // Catch: Throwable -> L25
    L23:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L25
    L27:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L31;
        LogUtils.w(TAG, "cleanupDeprecatedAuthSdkCache find fail model=" + r5 + " error=" + r10.getMessage(), new Object[0]);
    L31:
        if (Result.isFailure-impl(r9) == false) goto L33;
        r9 = null;
    L33:
        String r11 = (String) r9;
        if (r11 != null) goto L36;
    L39:
        boolean r12 = true;
    L40:
        if (r12 == true) goto L41;
        PolarisFileWrapper r13 = new PolarisFileWrapper(r11);
        if (r13.exists() == false) goto L44;
        if (isSafeDeprecatedAuthSdkCachePath(r13, r5) == false) goto L47;
        Object r14 = Result.constructor-impl(Boolean.valueOf(FilesKt.deleteRecursively(r13)));     // Catch: Throwable -> L50
    L52:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L55;
        LogUtils.w(TAG, "cleanupDeprecatedAuthSdkCache delete exception model=" + r5 + " path=" + r11 + " error=" + r15.getMessage(), new Object[0]);
    L55:
        Boolean r16 = Boolean.FALSE;
        if (Result.isFailure-impl(r14) == false) goto L59;
        r14 = r16;
    L59:
        if (((Boolean) r14).booleanValue() == true) goto L64;
        if (r13.exists() == false) goto L64;
        LogUtils.w(TAG, "cleanupDeprecatedAuthSdkCache delete failed model=" + r5 + " path=" + r11, new Object[0]);
    L64:
        LogUtils.i(TAG, "cleanupDeprecatedAuthSdkCache deleted model=" + r5 + " path=" + r11, new Object[0]);
    L50:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L52
    L47:
        LogUtils.w(TAG, "cleanupDeprecatedAuthSdkCache skip: unsafe path model=" + r5 + " path=" + r11, new Object[0]);
        goto L17
    L44:
        LogUtils.i(TAG, "cleanupDeprecatedAuthSdkCache skip: cache missing model=" + r5 + " path=" + r11, new Object[0]);
        goto L17
    L41:
        LogUtils.i(TAG, "cleanupDeprecatedAuthSdkCache skip: no local cache model=" + r5, new Object[0]);
        goto L17
    L36:
        if (r11.length() == 0) goto L39;
        r12 = false;
        goto L40
    L22:
        r8 = null;
    L25:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L65:
        return;
    L4:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    private final void clearAuthDownloadRetryState() {
        this.authRetryCount.set(0);
        this.needResumeAuthDownload.set(false);
        this.fetchAuthDownloadWhenNetworkConnected = false;
    }

    private final void downloadModel() {
        LogUtils.i(TAG, "start downloadModel 📥 to fetch model " + EffectConstant.getDownloadModelName(), new Object[0]);
        if (this.isDownloading.get() == false) goto L6;
        LogUtils.i(TAG, "downloadModel, isDownloading", new Object[0]);
        return;
    L6:
        boolean r0 = NetworkUtils.isNetworkAvailable(AppHost.a.getApplication());
        LogUtils.i(TAG, "downloadModel, isNetworkAvailable: " + r0, new Object[0]);
        if (r0 == true) goto L10;
        this.fetchDownloadWhenNetworkConnected = true;
        return;
    L10:
        this.fetchDownloadWhenNetworkConnected = false;
        this.isDownloading.set(true);
        this.startDownloadTime = System.currentTimeMillis();
        downloadModelInternal(new a(this), new b(this));
    }

    private final EffectConfig generateEffectConfig() {
        StringBuilder r0 = new StringBuilder("effectConfig 📝 detail is channel ");
        Companion r1 = Companion;
        r0.append(Companion.access$getCHANNEL(r1));
        r0.append(" sdkVersion : ");
        r0.append(getFinalEffectSDKVersion());
        r0.append(" appVersion : ");
        r0.append(this.mAppVersionName);
        r0.append(" deviceID: ");
        r0.append(this.mDeviceId);
        r0.append(" env : ");
        r0.append(Companion.access$getENV(r1));
        r0.append(" appid : ");
        r0.append(AppHost.a.getAppId());
        LogUtils.d(TAG, r0.toString(), new Object[0]);
        String r2 = getDeviceId();
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L12;
        LogUtils.d(TAG, "effectConfig deviceId is null , may be not yet login", new Object[0]);
        this.fetchDownloadWhenUserLogin = true;
        return null;
    L12:
        EffectConfig.Builder r4 = new EffectConfig.Builder();
        r4.i = Companion.access$getCHANNEL(r1);
        r4.b = getFinalEffectSDKVersion();
        r4.c = getAppVersionName();
        r4.k = Build.MODEL;
        r4.h = new dlc.a(new GSONConverter());
        r4.d = getDeviceId();
        r4.B = this.appContext;
        EffectConstant r5 = EffectConstant.INSTANCE;
        r4.n = new PolarisFileWrapper(r5.getSdkAlgorithmDir()).getAbsolutePath();
        r4.m = new PolarisFileWrapper(r5.getSdkEffectDir()).getAbsolutePath();
        r4.g = new TTNETImplNetWorker();
        r4.y = "https://doubao.com";
        r4.E = Companion.access$getENV(r1);
        r4.f = getAppId();
        r4.o = 3;
        r4.e = "CN";
        r4.j = "android";
        r4.T = true;
        r4.t = new EffectPlatformMonitor();
        return new EffectConfig(r4);
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    private final String getAppId() {
        if (this.mAppId.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        String r1 = rna.b.d(this.appContext);
        this.mAppId = r1;
        return r1;
    L8:
        return this.mAppId;
    L5:
        r0 = false;
        goto L6
    }

    private final String getAppVersionName() {
        if (this.mAppVersionName.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        String r1 = rna.b.e(this.appContext);
        this.mAppVersionName = r1;
        return r1;
    L8:
        return this.mAppVersionName;
    L5:
        r0 = false;
        goto L6
    }

    private final String getDeviceId() {
        if (this.mDeviceId.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        String r1 = queryDeviceIdToNova();
        this.mDeviceId = r1;
        return r1;
    L8:
        return this.mDeviceId;
    L5:
        r0 = false;
        goto L6
    }

    private final void observeAppForeground() {
        AppHost.a.a().j(new C00081(this));
    }

    private final void observeNetworkChange() {
        NetworkChangeReceiver r0 = new NetworkChangeReceiver(this);
        IntentFilter r1 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        INVOKEVIRTUAL_com_obric_sva_sdk_effectplatform_EffectPlatformProvider_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(AppHost.a.getApplication(), r0, r1);
    }

    private final void observeUserLogin() {
        UserLoginReceiver r0 = new UserLoginReceiver(this);
        IntentFilter r1 = new IntentFilter(EffectConstant.USER_LOGIN_INTENT);
        if (Build.VERSION.SDK_INT < 26) goto L6;
        INVOKEVIRTUAL_com_obric_sva_sdk_effectplatform_EffectPlatformProvider_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(AppHost.a.getApplication(), r0, r1, 4);
        return;
    }

    private final void scheduleCleanupDeprecatedAuthSdkCacheOnce() {
        if (this.deprecatedAuthSdkCacheCleanupScheduled.compareAndSet(false, true) == true) goto L6;
        return;
    L6:
        if (this.handler.post(new e(this)) == true) goto L9;
        LogUtils.w(TAG, "scheduleCleanupDeprecatedAuthSdkCacheOnce failed", new Object[0]);
        return;
    }

    private final boolean shouldDownloadAuthModel() {
        return !SamiWakeupParamProvider.INSTANCE.isBypassAdaptiveSid();
    }

    public final boolean canRollback() {
        PolarisFileWrapper r0 = new PolarisFileWrapper(EffectConstant.INSTANCE.getPrevRoot());
        if (r0.exists() == true) goto L7;
        return false;
    L7:
        return EffectUtils.INSTANCE.checkContentValid(r0.getAbsolutePath());
    }

    public final boolean initAlgorithmResourceManager() {
        StringBuilder r0 = new StringBuilder("initAlgorithmResourceManager start with effectConfig? ");
        r0.append(this.effectConfig);
        r0.append(" and engineInited ? ");
        AlgorithmResourceManager.Companion r1 = AlgorithmResourceManager.Companion;
        r0.append(r1.isInitialized());
        LogUtils.i(TAG, r0.toString(), new Object[0]);
        if (r1.isInitialized() == false) goto L7;
        LogUtils.i(TAG, "initAlgorithmResourceManager it has inited , just return !", new Object[0]);
        scheduleCleanupDeprecatedAuthSdkCacheOnce();
        return true;
    L7:
        if (this.effectConfig != null) goto L10;
        LogUtils.i(TAG, "generateEffectConfig start", new Object[0]);
        this.effectConfig = generateEffectConfig();
        LogUtils.i(TAG, "generateEffectConfig end and config: " + this.effectConfig, new Object[0]);
    L10:
        if (this.effectConfig != null) goto L22;
        return false;
    L22:
        EffectPlatformLogger r2 = new EffectPlatformLogger();     // Catch: IllegalStateException -> L20
        int r5 = EffectConfig.d0;     // Catch: IllegalStateException -> L20
        Logger.INSTANCE.setLogger(r2);     // Catch: IllegalStateException -> L20
        EffectConfig r3 = this.effectConfig;     // Catch: IllegalStateException -> L20
        if (r3 == null) goto L15;
        r1.initialize(r3);     // Catch: IllegalStateException -> L20
    L15:
        EffectConfig r4 = this.effectConfig;
        if (r4 == null) goto L18;
        r4.z.a = r1.getInstance().getEffectFetcher();
    L18:
        scheduleCleanupDeprecatedAuthSdkCacheOnce();
        LogUtils.i(TAG, "initAlgorithmResourceManager end", new Object[0]);
        return true;
    L20:
        LogUtils.e(TAG, "AlgorithmResourceManager initialize failed , check it !", new Object[0]);
        return false;
    }

    public final boolean isEngineInited() {
        boolean r0 = AlgorithmResourceManager.Companion.isInitialized();
        LogUtils.i(TAG, "isEngineInited? " + r0, new Object[0]);
        return r0;
    }

    private final void downloadAuthModel() {
        String r0 = EffectConstant.getDownloadAuthModelName();
        if (shouldDownloadAuthModel() == true) goto L7;
        clearAuthDownloadRetryState();
        LogUtils.i(TAG, "downloadAuthModel skip: auth switches disabled", new Object[0]);
        return;
    L7:
        if (this.isAuthDownloading.get() == false) goto L11;
        LogUtils.i(TAG, "downloadAuthModel, isAuthDownloading", new Object[0]);
        return;
    L11:
        if (NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()) == true) goto L14;
        this.fetchAuthDownloadWhenNetworkConnected = true;
        LogUtils.i(TAG, "downloadAuthModel skip: network unavailable, will retry on connect", new Object[0]);
        return;
    L14:
        this.fetchAuthDownloadWhenNetworkConnected = false;
        AlgorithmResourceManager.Companion r1 = AlgorithmResourceManager.Companion;
        if (r1.isInitialized() == true) goto L18;
        LogUtils.i(TAG, "downloadAuthModel skip: AlgorithmResourceManager not initialized", new Object[0]);
        return;
    L18:
        LogUtils.i(TAG, "start downloadAuthModel 📥 to fetch model " + r0, new Object[0]);
        this.isAuthDownloading.set(true);
        r1.getInstance().fetchResourcesWithModelNames(0, new String[]{r0}, new com.ss.ugc.effectplatform.a(), new AnonymousClass1(this));
    }

    private final void downloadAuthModelDelay() {
        if (shouldDownloadAuthModel() == true) goto L6;
        clearAuthDownloadRetryState();
        LogUtils.i(TAG, "downloadAuthModel skip: auth switches disabled", new Object[0]);
        return;
    L6:
        LogUtils.i(TAG, "will download auth model after 3s", new Object[0]);
        this.handler.postDelayed(new g(this), 3000);
    }

    public final void downloadAsync() {
        downloadModelDelay();
        downloadAuthModelDelay();
    }

    public final void fetchIPCAsync() {
        this.mDeviceId = getDeviceId();
        this.mAppVersionName = rna.b.e(this.appContext);
        this.mAppId = rna.b.d(this.appContext);
        LogUtils.d(TAG, "get deviceId length = " + this.mDeviceId.length() + ", appVersionName = " + this.mAppVersionName + ", appId = " + this.mAppId, new Object[0]);
    }

    public final Context getAppContext() {
        return this.appContext;
    }

    public final long getStartDownloadTime() {
        return this.startDownloadTime;
    }

    public EffectPlatformProvider(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "appContext");
        this.appContext = r3;
        this.mDeviceId = "";
        this.mAppVersionName = "";
        this.mAppId = "";
        this.isDownloading = new AtomicBoolean(false);
        this.isAuthDownloading = new AtomicBoolean(false);
        PthreadHandlerThreadV2 r4 = new PthreadHandlerThreadV2("UploadTaskThread");
        ThreadMethodProxy.start(r4);
        this.handlerThread = r4;
        this.handler = new Handler(r4.getLooper());
        this.needResumeDownload = new AtomicBoolean(false);
        this.needResumeAuthDownload = new AtomicBoolean(false);
        this.authRetryCount = new AtomicInteger(0);
        this.deprecatedAuthSdkCacheCleanupScheduled = new AtomicBoolean(false);
        observeNetworkChange();
        observeAppForeground();
        observeUserLogin();
    }

    public static final /* synthetic */ void access$downloadAuthModelDelay(EffectPlatformProvider r0) {
        r0.downloadAuthModelDelay();
    }

    public static final /* synthetic */ void access$downloadModelDelay(EffectPlatformProvider r0) {
        r0.downloadModelDelay();
    }

    public static final /* synthetic */ AtomicInteger access$getAuthRetryCount$p(EffectPlatformProvider r0) {
        return r0.authRetryCount;
    }

    public static final /* synthetic */ boolean access$getFetchAuthDownloadWhenNetworkConnected$p(EffectPlatformProvider r0) {
        return r0.fetchAuthDownloadWhenNetworkConnected;
    }

    public static final /* synthetic */ boolean access$getFetchDownloadWhenNetworkConnected$p(EffectPlatformProvider r0) {
        return r0.fetchDownloadWhenNetworkConnected;
    }

    public static final /* synthetic */ boolean access$getFetchDownloadWhenUserLogin$p(EffectPlatformProvider r0) {
        return r0.fetchDownloadWhenUserLogin;
    }

    public static final /* synthetic */ Handler access$getHandler$p(EffectPlatformProvider r0) {
        return r0.handler;
    }

    public static final /* synthetic */ AtomicBoolean access$getNeedResumeAuthDownload$p(EffectPlatformProvider r0) {
        return r0.needResumeAuthDownload;
    }

    public static final /* synthetic */ AtomicBoolean access$getNeedResumeDownload$p(EffectPlatformProvider r0) {
        return r0.needResumeDownload;
    }

    public static final /* synthetic */ AtomicBoolean access$isAuthDownloading$p(EffectPlatformProvider r0) {
        return r0.isAuthDownloading;
    }

    private static final void downloadAuthModelDelay$lambda$15(EffectPlatformProvider r0) {
        r0.downloadAuthModel();
    }

    private static final void downloadModelDelay$lambda$25(EffectPlatformProvider r5) {
        TrackAPI r0 = TrackAPI.INSTANCE;
        UpdateTrackerType r1 = UpdateTrackerType.DOWNLOAD_REQUEST;
        JSONObject r2 = new JSONObject();
        r2.put("is_downloading", r5.isDownloading.get());
        r2.put("network_available", NetworkUtils.isNetworkAvailable(AppHost.a.getApplication()));
        Unit r3 = Unit.INSTANCE;
        r0.trackerModelUpdate(r1, r2);
        r5.downloadModel();
    }

    private final String findAuthSubDirContainManifest(String r8) {
        PolarisFileWrapper r0 = new PolarisFileWrapper(r8);
        if (r0.exists() == true) goto L5;
        return null;
    L5:
        if (r0.isDirectory() == true) goto L8;
        return null;
    L8:
        if (new PolarisFileWrapper(r0, EffectConstant.AUTH_MODEL_MANIFEST_FILE_NAME).isFile() == true) goto L10;
        File[] r9 = r0.listFiles();
        if (r9 == null) goto L31;
        int r1 = r9.length;
        int r4 = 0;
    L14:
        if (r4 >= r1) goto L24;
        File r5 = r9[r4];
        if (r5.isDirectory() == true) goto L18;
    L20:
        boolean r6 = false;
    L21:
        if (r6 == true) goto L25;
        r4 = r4 + 1;
    L25:
        if (r5 != null) goto L27;
        return null;
    L27:
        return r5.getAbsolutePath();
    L18:
        if (new PolarisFileWrapper(r5, EffectConstant.AUTH_MODEL_MANIFEST_FILE_NAME).isFile() == false) goto L20;
        r6 = true;
        goto L21
    L24:
        r5 = null;
        goto L25
    L31:
        return null;
    L10:
        return r0.getAbsolutePath();
    }

    private final void handleAuthDownloadFailure(String r7) {
        AppHost.Companion r0 = AppHost.a;
        if (NetworkUtils.isNetworkAvailable(r0.getApplication()) == true) goto L7;
        this.fetchAuthDownloadWhenNetworkConnected = true;
        LogUtils.i(TAG, "handleAuthDownloadFailure mark network resume reason=" + r7, new Object[0]);
        return;
    L7:
        if (r0.a().isAppBackground() == false) goto L10;
        this.needResumeAuthDownload.set(true);
        LogUtils.i(TAG, "handleAuthDownloadFailure mark foreground resume reason=" + r7, new Object[0]);
        return;
    L10:
        int r1 = this.authRetryCount.incrementAndGet();
        if (r1 <= 3) goto L14;
        LogUtils.w(TAG, "handleAuthDownloadFailure give up: retryCount=" + r1 + " reason=" + r7, new Object[0]);
        return;
    L14:
        LogUtils.i(TAG, "handleAuthDownloadFailure schedule retry count=" + r1 + " reason=" + r7, new Object[0]);
        this.handler.postDelayed(new f(this), 3000);
    }

    private static final void handleAuthDownloadFailure$lambda$16(EffectPlatformProvider r0) {
        r0.downloadAuthModel();
    }

    private static final File isSafeDeprecatedAuthSdkCachePath$lambda$12(File r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1.getParentFile();
    }

    private final int processAuthSuccess(String[] r22) {
        String r0 = EffectConstant.getDownloadAuthModelName();
        String r10 = AlgorithmResourceManager.Companion.getInstance().getResourceFinder().findResourceUri(r0);
        if (r10 == null) goto L5;
        String r9 = StringsKt.replace$default(r10, "file://", "", false, 4, null);
    L6:
        this.authModelPath = r9;
        if (r9 != null) goto L9;
    L12:
        boolean r12 = true;
    L14:
        if (r12 == false) goto L16;
    L122:
        LogUtils.e(TAG, "processAuthSuccess auth zip not exist: " + r9, new Object[0]);
        return -2;
    L16:
        if (rna.c.c(r9) == false) goto L122;
        PolarisFileWrapper r13 = new PolarisFileWrapper(EffectConstant.INSTANCE.getAuthZipCacheDir(), r0 + ".zip");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L21
        rna.c.b(r13.getAbsolutePath());     // Catch: Throwable -> L21
        FilesKt.copyTo$default(new PolarisFileWrapper(r9), r13, true, 0, 4, null);     // Catch: Throwable -> L21
        Object r2 = Result.constructor-impl(Boolean.TRUE);     // Catch: Throwable -> L21
    L23:
        Throwable r11 = Result.exceptionOrNull-impl(r2);
        if (r11 == null) goto L26;
        LogUtils.e(TAG, "processAuthSuccess copy zip to internal fail: " + r11.getMessage(), new Object[0]);
    L26:
        Boolean r14 = Boolean.FALSE;
        if (Result.isFailure-impl(r2) == false) goto L30;
        r2 = r14;
    L30:
        if (((Boolean) r2).booleanValue() == true) goto L32;
    L120:
        LogUtils.e(TAG, "processAuthSuccess internal zip missing after copy: " + r13.getAbsolutePath(), new Object[0]);
        return -2;
    L32:
        if (r13.isFile() == false) goto L120;
        String r15 = r13.getAbsolutePath();
        StringBuilder r3 = new StringBuilder();     // Catch: Throwable -> L110
        EffectConstant r16 = EffectConstant.INSTANCE;     // Catch: Throwable -> L110
        r3.append(r16.getAuthUpdateDir());     // Catch: Throwable -> L110
        r3.append(File.separator);     // Catch: Throwable -> L110
        r3.append("extract_auth");     // Catch: Throwable -> L110
        String r4 = r3.toString();     // Catch: Throwable -> L110
        EffectUtils r17 = EffectUtils.INSTANCE;     // Catch: Throwable -> L110
        Intrinsics.checkNotNull(r15);     // Catch: Throwable -> L110
        if (r17.unzipFile(r15, r4) == true) goto L47;
        LogUtils.e(TAG, "processAuthSuccess unzip fail zip=" + r15, new Object[0]);     // Catch: Throwable -> L110
        rna.c.b(r15);     // Catch: Throwable -> L40
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L40
    L42:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L138;
        LogUtils.w(TAG, "processAuthSuccess cleanup internal zip fail: " + r6.getMessage(), new Object[0]);
        return -1;
    L138:
        return -1;
    L40:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L42
    L47:
        String r8 = findAuthSubDirContainManifest(r4);     // Catch: Throwable -> L110
        if (r8 == null) goto L51;
        r4 = r8;
    L51:
        AuthModelConfig r18 = AuthModelConfig.INSTANCE;     // Catch: Throwable -> L110
        AuthModelConfig.ManifestLoadResult r19 = r18.loadManifestWithStatus(r4);     // Catch: Throwable -> L110
        AuthModelManifest r110 = r19.getManifest();     // Catch: Throwable -> L110
        if (r110 != null) goto L59;
        LogUtils.e(TAG, "processAuthSuccess load auth manifest fail dir=" + r4 + " code=" + r19.getCode(), new Object[0]);     // Catch: Throwable -> L110
        int r20 = r19.getCode();     // Catch: Throwable -> L110
        rna.c.b(r15);
        Throwable r21 = Result.exceptionOrNull-impl(Result.constructor-impl(Unit.INSTANCE));
        if (r21 == null) goto L57;
        LogUtils.w(TAG, "processAuthSuccess cleanup internal zip fail: " + r21.getMessage(), new Object[0]);
    L57:
        return r20;
    L59:
        if (r18.checkAuthDigest(r4, r110) == true) goto L70;
        LogUtils.e(TAG, "processAuthSuccess digest fail dir=" + r4 + " version=" + r110.getVersion(), new Object[0]);     // Catch: Throwable -> L110
        rna.c.b(r15);     // Catch: Throwable -> L63
        Object r23 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L63
    L65:
        Throwable r24 = Result.exceptionOrNull-impl(r23);
        if (r24 == null) goto L139;
        LogUtils.w(TAG, "processAuthSuccess cleanup internal zip fail: " + r24.getMessage(), new Object[0]);
        return -4;
    L139:
        return -4;
    L63:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r23 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L65
    L70:
        String r26 = r16.getAuthLatestRoot();     // Catch: Throwable -> L110
        String r27 = r16.getAuthPrevRoot();     // Catch: Throwable -> L110
        AuthModelManifest r111 = r18.loadManifest(r26);     // Catch: Throwable -> L110
        if (r111 != null) goto L73;
    L77:
        boolean r112 = false;
    L78:
        if (r112 == false) goto L92;
        LogUtils.i(TAG, "processAuthSuccess no need update, latest already version=" + r110.getVersion() + " authVersion=" + r110.getAuthModelVersion() + " authRawMd5=" + r110.getAuthRawFileMd5(), new Object[0]);     // Catch: Throwable -> L110
        if (r18.updateFromLatest(this.appContext) == false) goto L128;
        triggerLegacyMigrationAfterAuthReady("auth_no_need_update");     // Catch: Throwable -> L110
    L128:
        rna.c.b(r15);     // Catch: Throwable -> L84
        Object r28 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L84
    L86:
        Throwable r29 = Result.exceptionOrNull-impl(r28);
        if (r29 == null) goto L140;
        LogUtils.w(TAG, "processAuthSuccess cleanup internal zip fail: " + r29.getMessage(), new Object[0]);
        return -7;
    L140:
        return -7;
    L84:
        th = move-exception;
        Result.Companion r30 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L86
    L92:
        if (new PolarisFileWrapper(r26).exists() == false) goto L95;
        rna.c.b(r27);     // Catch: Throwable -> L110
        EffectUtils.copyDir$default(r17, r26, r27, false, 4, null);     // Catch: Throwable -> L110
        LogUtils.i(TAG, "processAuthSuccess backup latest -> previous done", new Object[0]);     // Catch: Throwable -> L110
    L95:
        rna.c.b(r26);     // Catch: Throwable -> L110
        new PolarisFileWrapper(r26).mkdirs();     // Catch: Throwable -> L110
        LogUtils.i(TAG, "processAuthSuccess copy " + r4 + " -> " + r26 + " changed=" + EffectUtils.copyDir$default(r17, r4, r26, false, 4, null), new Object[0]);     // Catch: Throwable -> L110
        if (r18.updateFromLatest(this.appContext) == false) goto L98;
        LogUtils.i(TAG, "processAuthSuccess auth model updated to version=" + r110.getVersion() + " 🚀", new Object[0]);     // Catch: Throwable -> L110
        triggerLegacyMigrationAfterAuthReady("auth_updated");     // Catch: Throwable -> L110
        int r31 = 0;
    L126:
        rna.c.b(r15);     // Catch: Throwable -> L104
        Object r32 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L104
    L106:
        Throwable r33 = Result.exceptionOrNull-impl(r32);
        if (r33 == null) goto L109;
        LogUtils.w(TAG, "processAuthSuccess cleanup internal zip fail: " + r33.getMessage(), new Object[0]);
    L109:
        return r31;
    L104:
        th = move-exception;
        Result.Companion r34 = Result.Companion;
        r32 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L106
    L98:
        LogUtils.e(TAG, "processAuthSuccess updateFromLatest fail; rollback", new Object[0]);     // Catch: Throwable -> L110
        if (new PolarisFileWrapper(r27).exists() == false) goto L101;
        rna.c.b(r26);     // Catch: Throwable -> L110
        new PolarisFileWrapper(r26).mkdirs();     // Catch: Throwable -> L110
        EffectUtils.copyDir$default(r17, r27, r26, false, 4, null);     // Catch: Throwable -> L110
        r18.updateFromLatest(this.appContext);     // Catch: Throwable -> L110
    L101:
        r31 = -5;
        goto L126
    L73:
        if (r18.isSameAuthPackage(r110, r111) == false) goto L77;
        if (r18.checkAuthDigest(r26, r111) == false) goto L77;
        r112 = true;
    L110:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L114
        rna.c.b(r15);     // Catch: Throwable -> L114
        Object r36 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L114
    L116:
        Throwable r37 = Result.exceptionOrNull-impl(r36);
        if (r37 == null) goto L137;
        LogUtils.w(TAG, "processAuthSuccess cleanup internal zip fail: " + r37.getMessage(), new Object[0]);
        throw th;
    L137:
        throw th;
    L114:
        th = move-exception;
        Result.Companion r38 = Result.Companion;
        r36 = Result.constructor-impl(ResultKt.createFailure(th));
    L21:
        th = move-exception;
        Result.Companion r39 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    L9:
        if (r9.length() == 0) goto L12;
        r12 = false;
        goto L14
    L5:
        r9 = null;
        goto L6
    }

    private final int processSuccess(String[] r13) {
        LogUtils.i(TAG, " section 0 processSuccess " + ArraysKt.joinToString$default(r13, ",", null, null, 0, null, null, 62, null), new Object[0]);
        String r3 = AlgorithmResourceManager.Companion.getInstance().getResourceFinder().findResourceUri(EffectConstant.getDownloadModelName());
        ModelManifest r14 = null;
        if (r3 == null) goto L5;
        String r1 = StringsKt.replace$default(r3, "file://", "", false, 4, null);
    L6:
        this.modelPath = r1;
        boolean r2 = rna.c.c(r1);
        LogUtils.i(TAG, " section A model [" + this.modelPath + "] exist: " + r2, new Object[0]);
        if (r2 == true) goto L9;
        return -2;
    L9:
        if (this.modelPath == null) goto L98;
        String r4 = new PolarisFileWrapper(this.modelPath).getParentFile().getAbsolutePath() + File.separator + "extract";
        LogUtils.i(TAG, "section B1 model [" + this.modelPath + "] extractDir  : " + r4, new Object[0]);
        EffectUtils r5 = EffectUtils.INSTANCE;
        String r6 = this.modelPath;
        Intrinsics.checkNotNull(r6);
        boolean r7 = r5.unzipFile(r6, r4);
        LogUtils.i(TAG, "section B2 model [" + this.modelPath + "] extract result : " + r7, new Object[0]);
        if (r7 == false) goto L92;
        String r8 = r5.findSubDirContainManifest(r4);
        LogUtils.i(TAG, "section B3 model [" + this.modelPath + "] contentDir  : " + r8, new Object[0]);
        if (r8 == null) goto L16;
        r14 = r5.loadManifest(r8);
    L16:
        if (r14 != null) goto L18;
    L20:
        boolean r9 = false;
    L21:
        LogUtils.i(TAG, "section C1 model [" + this.modelPath + "] manifest  : " + r14 + " alright " + r9, new Object[0]);
        if (r9 == false) goto L90;
        if (r14 == null) goto L90;
        EffectConstant r11 = EffectConstant.INSTANCE;
        ModelManifest r10 = r5.loadManifest(r11.getLatestRoot());
        LogUtils.i(TAG, "更新前检查[latest]目录和[下载]目录差异 latestManifest " + r10 + " contentManifest " + r14, new Object[0]);
        if (r10 != null) goto L27;
        boolean r12 = true;
    L28:
        LogUtils.d(TAG, "emptyManifest ?? " + r12, new Object[0]);
        String r15 = "0.0.0";
        if (r10 == null) goto L39;
        String r16 = r14.getVersion();
        if (r16 != null) goto L33;
        r16 = "0.0.0";
    L33:
        String r17 = r10.getVersion();
        if (r17 != null) goto L37;
        r17 = "0.0.0";
    L37:
        if (r5.compareVersion(r16, r17) <= 0) goto L39;
        boolean r18 = true;
    L40:
        LogUtils.d(TAG, "largerManifestVersion ? ? " + r18, new Object[0]);
        if (r10 == null) goto L54;
        String r19 = r14.getVersion();
        if (r19 != null) goto L45;
        r19 = "0.0.0";
    L45:
        String r110 = r10.getVersion();
        if (r110 == null) goto L50;
        r15 = r110;
    L50:
        if (r5.compareVersion(r19, r15) != 0) goto L54;
        if (r5.sameManifest(r10, r14) == true) goto L54;
        boolean r20 = true;
    L55:
        LogUtils.d(TAG, "sameVersionDifferentFile ? ? " + r20, new Object[0]);
        if (r12 == true) goto L61;
        if (r18 == true) goto L61;
        if (r20 == true) goto L61;
        boolean r21 = false;
    L62:
        if (r21 == true) goto L65;
        LogUtils.i(TAG, "更新前检查[latest]目录和[下载]目录差异 , 无需升级，所以无需拷贝文件", new Object[0]);
        return -7;
    L65:
        LogUtils.i(TAG, "更新前检查[latest]目录和[下载]目录差异 , 可以升级，准备拷贝文件，先备份下使用中的目录内容。升级原因【 1. 更新目录为空 2 更大的版本号 3 相同版本不同文件 】【 1. " + r12 + " 2. " + r18 + " 3. " + r20 + " 】【Note ： 任何一个为 true ，就可以升级】", new Object[0]);
        boolean r22 = r5.checkContentValid(r11.getLatestRoot());
        StringBuilder r23 = new StringBuilder("section C2 model [");
        r23.append(this.modelPath);
        r23.append("] isValid ? ");
        r23.append(r22);
        LogUtils.i(TAG, r23.toString(), new Object[0]);
        if (r22 == false) goto L68;
        LogUtils.i(TAG, "section C3 model [" + this.modelPath + "] delete file under " + r11.getPrevRoot(), new Object[0]);
        rna.c.b(r11.getPrevRoot());
        LogUtils.i(TAG, "section C4 model [" + this.modelPath + "] backup content from " + r11.getLatestRoot() + " to " + r11.getPrevRoot(), new Object[0]);
        LogUtils.i(TAG, "section C5 model [" + this.modelPath + "] backup done with " + EffectUtils.copyDir$default(r5, r11.getLatestRoot(), r11.getPrevRoot(), false, 4, null) + " files copied", new Object[0]);
    L68:
        String r111 = r11.getLatestRoot();
        boolean r24 = EffectUtils.copyDir$default(r5, r8, r111, false, 4, null);
        LogUtils.i(TAG, "section D model [" + this.modelPath + "] copy to : " + r111 + " and copy result is " + r24, new Object[0]);
        if (r24 == true) goto L73;
        LogUtils.i(TAG, "section D INTERRUPT NO NEED COPY FILE , SO NO NEED RESTART SAMI CORE ", new Object[0]);
        return -6;
    L73:
        if (r5.checkDigest(r111, r14) == false) goto L88;
        LogUtils.i(TAG, "section E model [" + this.modelPath + "] updateCurrentConfig " + r5.updateCurrentConfig(r111), new Object[0]);
        Global.sReloadSamiCoreByUpdate = true;
        SvaSdkGlobal.INSTANCE.reload(this.appContext);
        Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L77
        Intent r113 = new Intent();     // Catch: Throwable -> L77
        r113.setAction(Global.RELOAD_VOICE_SID_MODEL_BY_UPDATE);     // Catch: Throwable -> L77
        r113.setPackage(PackageUtils.NOVA_PKG_NAME);     // Catch: Throwable -> L77
        r113.setClass(this.appContext, WakeupService.class);     // Catch: Throwable -> L77
        Object r114 = Result.constructor-impl(this.appContext.startService(r113));     // Catch: Throwable -> L77
    L80:
        if (Result.isSuccess-impl(r114) == false) goto L84;
        ComponentName r115 = (ComponentName) r114;
        LogUtils.i(TAG, "🚀 section F model [" + this.modelPath + "] succcess in reload service signal sent", new Object[0]);
        return 0;
    L84:
        if (Result.exceptionOrNull-impl(r114) == null) goto L87;
        LogUtils.e(TAG, "section ERROR F model [" + this.modelPath + "] in reload signal sent", new Object[0]);
        return -5;
    L87:
        return 0;
    L77:
        th = move-exception;
        Result.Companion r25 = Result.Companion;
        r114 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L80
    L88:
        LogUtils.i(TAG, "section ERROR E model [" + this.modelPath + "] targetContent : " + r111, new Object[0]);
        rollback();
        return -4;
    L61:
        r21 = true;
    L54:
        r20 = false;
    L39:
        r18 = false;
        goto L40
    L27:
        r12 = false;
    L90:
        LogUtils.i(TAG, "section Error D model [" + this.modelPath + ']', new Object[0]);
        return -3;
    L18:
        if (r5.checkDigest(r8, r14) == false) goto L20;
        r9 = true;
        goto L21
    L92:
        LogUtils.i(TAG, "section Error C model [" + this.modelPath + ']', new Object[0]);
        return -1;
    L98:
        return -2;
    L5:
        r1 = null;
        goto L6
    }

    private static final void scheduleCleanupDeprecatedAuthSdkCacheOnce$lambda$2(EffectPlatformProvider r0) {
        r0.cleanupDeprecatedAuthSdkCache();
    }

    private final void triggerLegacyMigrationAfterAuthReady(String r5) {
        if (AuthModelConfig.INSTANCE.isReady() == true) goto L6;
        LogUtils.i(TAG, "triggerLegacyMigrationAfterAuthReady skip: auth not ready reason=" + r5, new Object[0]);
        return;
    L6:
        LogUtils.i(TAG, "triggerLegacyMigrationAfterAuthReady reason=" + r5, new Object[0]);
        SamiPhoneEnrollManager.triggerMigrationAsync(this.appContext, new d(this));
    }

    private static final String triggerLegacyMigrationAfterAuthReady$lambda$22(EffectPlatformProvider r0) {
        return rna.b.i(r0.appContext);
    }

    public final void setStartDownloadTime(long r1) {
        this.startDownloadTime = r1;
    }

    public final void triggerAuthModelDownload(String r4) {
        Intrinsics.checkNotNullParameter(r4, "reason");
        LogUtils.i(TAG, "triggerAuthModelDownload reason=" + r4, new Object[0]);
        this.authRetryCount.set(0);
        downloadAuthModelDelay();
    }

    public static final /* synthetic */ void access$handleAuthDownloadFailure(EffectPlatformProvider r0, String r1) {
        r0.handleAuthDownloadFailure(r1);
    }

    public static final /* synthetic */ int access$processAuthSuccess(EffectPlatformProvider r0, String[] r1) {
        return r0.processAuthSuccess(r1);
    }

    public static final /* synthetic */ void access$setFetchAuthDownloadWhenNetworkConnected$p(EffectPlatformProvider r0, boolean r1) {
        r0.fetchAuthDownloadWhenNetworkConnected = r1;
    }

    public static final /* synthetic */ void access$setFetchDownloadWhenNetworkConnected$p(EffectPlatformProvider r0, boolean r1) {
        r0.fetchDownloadWhenNetworkConnected = r1;
    }

    public static final /* synthetic */ void access$setFetchDownloadWhenUserLogin$p(EffectPlatformProvider r0, boolean r1) {
        r0.fetchDownloadWhenUserLogin = r1;
    }

    private static final Unit downloadModel$lambda$28(EffectPlatformProvider r7, String[] r8) {
        Intrinsics.checkNotNullParameter(r8, "array");
        r7.isDownloading.set(false);
        TrackAPI r0 = TrackAPI.INSTANCE;
        TrackAPI.trackerModelUpdate$default(r0, UpdateTrackerType.MODEL_UPDATING, null, 2, null);
        int r9 = r7.processSuccess(r8);
        if (r9 == (-7)) goto L7;
        if (r9 == 0) goto L6;
        UpdateTrackerType r2 = UpdateTrackerType.MODEL_UPDATE_FAIL;
        JSONObject r3 = new JSONObject();
        r3.put("error_code", r9);
        r3.put("error_message", EffectConstant.INSTANCE.findError(r9));
        Unit r10 = Unit.INSTANCE;
        r0.trackerModelUpdate(r2, r3);
    L8:
        r7.needResumeDownload.set(false);
        return Unit.INSTANCE;
    L6:
        TrackAPI.trackerModelUpdate$default(r0, UpdateTrackerType.MODEL_UPDATE_SUCCESS, null, 2, null);
        goto L8
    L7:
        UpdateTrackerType r4 = UpdateTrackerType.MODEL_UPDATE_IGNORE;
        JSONObject r5 = new JSONObject();
        r5.put("error_code", r9);
        r5.put("error_message", EffectConstant.INSTANCE.findError(r9));
        Unit r11 = Unit.INSTANCE;
        r0.trackerModelUpdate(r4, r5);
        goto L8
    }

    private static final Unit downloadModel$lambda$29(EffectPlatformProvider r2, String[] r3) {
        r2.isDownloading.set(false);
        if (AppHost.a.a().isAppBackground() == false) goto L5;
        LogUtils.i(TAG, "needResumeDownload", new Object[0]);
        r2.needResumeDownload.set(true);
    L7:
        return Unit.INSTANCE;
    L5:
        r2.downloadModelDelay();
        goto L7
    }

    private final void downloadModelInternal(Function1<? super String[], Unit> r6, Function1<? super String[], Unit> r7) {
        AlgorithmResourceManager.Companion r0 = AlgorithmResourceManager.Companion;
        if (r0.isInitialized() == true) goto L6;
        r7.invoke(null);
        return;
    L6:
        TrackAPI.trackerModelUpdate$default(TrackAPI.INSTANCE, UpdateTrackerType.DOWNLOAD_START, null, 2, null);
        r0.getInstance().fetchResourcesWithModelNames(0, new String[]{EffectConstant.getDownloadModelName()}, new com.ss.ugc.effectplatform.a(), new C00071(this, r7, r6));
    }

    private final boolean isSafeDeprecatedAuthSdkCachePath(File r8, String r9) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(new PolarisFileWrapper(EffectConstant.INSTANCE.getSdkCacheRoot()).getCanonicalFile());     // Catch: Throwable -> L4
    L7:
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        File r2 = (File) r1;
        if (r2 != null) goto L41;
        return false;
    L41:
        Object r10 = Result.constructor-impl(r8.getCanonicalFile());     // Catch: Throwable -> L14
    L17:
        if (Result.isFailure-impl(r10) == false) goto L19;
        r10 = null;
    L19:
        File r11 = (File) r10;
        if (r11 != null) goto L23;
        return false;
    L23:
        if (Intrinsics.areEqual(r11.getPath(), r2.getPath()) == false) goto L25;
        return false;
    L25:
        if (StringsKt.startsWith$default(r11.getPath(), r2.getPath() + File.separator, false, 2, null) == false) goto L48;
        Set r3 = SetsKt.setOf(new String[]{r9, r9 + ".zip", r9 + "_model"});
        if (new Regex("^" + Regex.Companion.escape(r9) + "_v[0-9]+(?:_[0-9]+)*_size[0-9]+_md5[0-9a-fA-F]{32}_model$").matches(r11.getName()) == true) goto L37;
        Iterator r12 = SequencesKt.takeWhile(SequencesKt.generateSequence(r11, new h()), new i(r2)).iterator();
    L31:
        if (r12.hasNext() == false) goto L35;
        if (r3.contains(((File) r12.next()).getName()) == false) goto L31;
        boolean r13 = true;
    L36:
        if (r13 == true) goto L37;
        return false;
    L35:
        r13 = false;
    L37:
        return true;
    L48:
        return false;
    L14:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private static final boolean isSafeDeprecatedAuthSdkCachePath$lambda$13(File r1, File r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return !Intrinsics.areEqual(r2.getPath(), r1.getPath());
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_obric_sva_sdk_effectplatform_EffectPlatformProvider_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Application r8, BroadcastReceiver r9, IntentFilter r10) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, 0, null, null, 2, r8);     // Catch: Exception -> L36
        int r1 = r0.result;     // Catch: Exception -> L36
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r8.registerReceiver(r9, r10);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_com_obric_sva_sdk_effectplatform_EffectPlatformProvider_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Application r8, BroadcastReceiver r9, IntentFilter r10, int r11) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r9, r10, r11);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r10 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r10) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r0 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r9, r10, r11, null, null, 3, r8);     // Catch: Exception -> L36
        int r1 = r0.result;     // Catch: Exception -> L36
        if (r1 == 1) goto L23;
        if (r1 == 2) goto L21;
        if (r1 == 3) goto L19;
        return r8.registerReceiver(r9, r10, r11);
    L19:
        return r0.intent;
    L21:
        return new Intent();
    L23:
        return r8.registerReceiver(r9, r10, r11);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r8.registerReceiver(r9, r10, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r10) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r8, r9, r10, null, ReceiverRegisterLancet.sProxyHandler, r11);
    L35:
        return r8.registerReceiver(r9, r10, r11);
    }
}
