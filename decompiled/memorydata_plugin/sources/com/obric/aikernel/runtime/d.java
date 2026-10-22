package com.obric.aikernel.runtime;

import android.content.Context;
import android.os.Build;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.res.PackageResourceManager;
import com.obric.aikernel.runtime.utils.l;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.at;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000°\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ¿\u00012\u00020\u0001:\u0002¿\u0001Bl\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u001c\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0002\u0010\u0010J\b\u0010½\u0001\u001a\u00030¾\u0001R(\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R,\u0010\u0019\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00050\u001b0\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0018R\u001c\u0010'\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0018\"\u0004\b)\u0010*R \u0010+\u001a\b\u0012\u0004\u0012\u00020,0!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R \u0010/\u001a\b\u0012\u0004\u0012\u0002000!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010#\"\u0004\b2\u0010%R \u00103\u001a\b\u0012\u0004\u0012\u00020\u000e0!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010#\"\u0004\b5\u0010%R\"\u00106\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u001d\"\u0004\b8\u0010\u001fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\u0018R\u001a\u0010:\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R \u0010?\u001a\b\u0012\u0004\u0012\u00020\u000e0!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010#\"\u0004\bA\u0010%R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u001a\u0010E\u001a\u000200X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001c\u0010J\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0018\"\u0004\bL\u0010*R,\u0010\t\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nø\u0001\u0000¢\u0006\n\n\u0002\u0010O\u001a\u0004\bM\u0010NR\u001a\u0010P\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010<\"\u0004\bR\u0010>R\u001a\u0010S\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010<\"\u0004\bU\u0010>R\u001a\u0010V\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u0018\"\u0004\bX\u0010*R \u0010Y\u001a\b\u0012\u0004\u0012\u0002000!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010#\"\u0004\b[\u0010%R\"\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010#\"\u0004\b^\u0010%R\u001c\u0010_\u001a\u0004\u0018\u00010`X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\be\u0010<R(\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020g\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0014\"\u0004\bi\u0010\u0016RN\u0010j\u001a1\b\u0001\u0012\u0013\u0012\u00110l¢\u0006\f\bm\u0012\b\bn\u0012\u0004\b\b(o\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010kX\u0086\u000eø\u0001\u0000¢\u0006\u0010\n\u0002\u0010t\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u001a\u0010u\u001a\u00020vX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR!\u0010{\u001a\b\u0012\u0004\u0012\u00020\u00050|X\u0086\u000e¢\u0006\u000f\n\u0000\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R\u001f\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u0018\"\u0005\b\u0083\u0001\u0010*R2\u0010\u0084\u0001\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u001b\u0018\u00010|X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0085\u0001\u0010~\"\u0006\b\u0086\u0001\u0010\u0080\u0001R$\u0010\u0087\u0001\u001a\b\u0012\u0004\u0012\u00020\u00050|X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0088\u0001\u0010~\"\u0006\b\u0089\u0001\u0010\u0080\u0001R\"\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0012\u0010\u0006\u001a\u00020\u0005¢\u0006\t\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u0018R2\u0010\u0091\u0001\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u001b\u0018\u00010|X\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u0092\u0001\u0010~\"\u0006\b\u0093\u0001\u0010\u0080\u0001R\u001f\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010\u0018\"\u0005\b\u0096\u0001\u0010*R\u001f\u0010\u0097\u0001\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010\u0018\"\u0005\b\u0099\u0001\u0010*R\u001d\u0010\u009a\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010\u0018\"\u0005\b\u009c\u0001\u0010*R\"\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009f\u0001\u0010 \u0001\"\u0006\b¡\u0001\u0010¢\u0001R\u001f\u0010£\u0001\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¤\u0001\u0010\u0018\"\u0005\b¥\u0001\u0010*R$\u0010¦\u0001\u001a\t\u0012\u0005\u0012\u00030§\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010#\"\u0005\b©\u0001\u0010%R$\u0010ª\u0001\u001a\t\u0012\u0005\u0012\u00030§\u00010!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b«\u0001\u0010#\"\u0005\b¬\u0001\u0010%R\"\u0010\u00ad\u0001\u001a\u0005\u0018\u00010®\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R#\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020,0!X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0001\u0010#\"\u0005\bµ\u0001\u0010%R\u001d\u0010¶\u0001\u001a\u00020\u0005X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0001\u0010\u0018\"\u0005\b¸\u0001\u0010*R\u0012\u0010\u000f\u001a\u00020\u000e¢\u0006\t\n\u0000\u001a\u0005\b¹\u0001\u0010<R\u001d\u0010º\u0001\u001a\u00020\u000eX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b»\u0001\u0010<\"\u0005\b¼\u0001\u0010>\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006À\u0001"}, d2 = {"Lcom/obric/aikernel/runtime/RuntimeConfigBuilder;", "", "context", "Landroid/content/Context;", "aid", "", "projectId", "appVersion", "channel", "did", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "compatAppVersion", "multiAidDeploy", "", "useCenterDistribution", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Ljava/lang/String;ZZ)V", "VmHostEnv", "", "getVmHostEnv", "()Ljava/util/Map;", "setVmHostEnv", "(Ljava/util/Map;)V", "getAid", "()Ljava/lang/String;", "allowBackgroundUpdate", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlin/Pair;", "getAllowBackgroundUpdate", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "setAllowBackgroundUpdate", "(Lkotlinx/coroutines/flow/MutableStateFlow;)V", "allowNetworkRequest", "Lkotlin/Function0;", "getAllowNetworkRequest", "()Lkotlin/jvm/functions/Function0;", "setAllowNetworkRequest", "(Lkotlin/jvm/functions/Function0;)V", "getAppVersion", "assertRootDir", "getAssertRootDir", "setAssertRootDir", "(Ljava/lang/String;)V", "autoCleanResourceInterval", "", "getAutoCleanResourceInterval", "setAutoCleanResourceInterval", "autoCleanResourceTotalGB", "", "getAutoCleanResourceTotalGB", "setAutoCleanResourceTotalGB", "autoDeleteDebugPackage", "getAutoDeleteDebugPackage", "setAutoDeleteDebugPackage", "autoUpdateTrigger", "getAutoUpdateTrigger", "setAutoUpdateTrigger", "getChannel", "checkAssistantAutoUpdateSwitch", "getCheckAssistantAutoUpdateSwitch", "()Z", "setCheckAssistantAutoUpdateSwitch", "(Z)V", "checkPackageResource", "getCheckPackageResource", "setCheckPackageResource", "getCompatAppVersion", "getContext", "()Landroid/content/Context;", "corruptExceptionThreshold", "getCorruptExceptionThreshold", "()I", "setCorruptExceptionThreshold", "(I)V", "deviceRootDir", "getDeviceRootDir", "setDeviceRootDir", "getDid", "()Lkotlin/jvm/functions/Function1;", "Lkotlin/jvm/functions/Function1;", "enableDebug", "getEnableDebug", "setEnableDebug", "enableDownloadForegroundService", "getEnableDownloadForegroundService", "setEnableDownloadForegroundService", "hostType", "getHostType", "setHostType", "hostUserId", "getHostUserId", "setHostUserId", "inferNotResponseTimeMills", "getInferNotResponseTimeMills", "setInferNotResponseTimeMills", "logger", "Lcom/obric/aikernel/runtime/utils/ILogger;", "getLogger", "()Lcom/obric/aikernel/runtime/utils/ILogger;", "setLogger", "(Lcom/obric/aikernel/runtime/utils/ILogger;)V", "getMultiAidDeploy", "multiProcessPackageSettings", "Lcom/obric/aikernel/runtime/AIInferRuntime$Config$VmPackageSettings;", "getMultiProcessPackageSettings", "setMultiProcessPackageSettings", "networkRequestDelegate", "Lkotlin/Function2;", "Lokhttp3/RequestBody;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "body", "getNetworkRequestDelegate", "()Lkotlin/jvm/functions/Function2;", "setNetworkRequestDelegate", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "packageActionInjector", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$IPackageActionInjector;", "getPackageActionInjector", "()Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$IPackageActionInjector;", "setPackageActionInjector", "(Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$IPackageActionInjector;)V", "platformIntegrityModelRoots", "", "getPlatformIntegrityModelRoots", "()Ljava/util/List;", "setPlatformIntegrityModelRoots", "(Ljava/util/List;)V", "preInitPackageName", "getPreInitPackageName", "setPreInitPackageName", "presetLibraries", "getPresetLibraries", "setPresetLibraries", "presetModelRoots", "getPresetModelRoots", "setPresetModelRoots", "processLifeCycleController", "Lcom/obric/aikernel/runtime/AIInferRuntime$Config$IProcessLifeCycle;", "getProcessLifeCycleController", "()Lcom/obric/aikernel/runtime/AIInferRuntime$Config$IProcessLifeCycle;", "setProcessLifeCycleController", "(Lcom/obric/aikernel/runtime/AIInferRuntime$Config$IProcessLifeCycle;)V", "getProjectId", "pythonExtensionInfo", "getPythonExtensionInfo", "setPythonExtensionInfo", Api.KEY_REGION, "getRegion", "setRegion", "resRootDir", "getResRootDir", "setResRootDir", "rootDir", "getRootDir", "setRootDir", "runtimeCallback", "Lcom/obric/aikernel/runtime/AIInferRuntime$Callback;", "getRuntimeCallback", "()Lcom/obric/aikernel/runtime/AIInferRuntime$Callback;", "setRuntimeCallback", "(Lcom/obric/aikernel/runtime/AIInferRuntime$Callback;)V", "soc", "getSoc", "setSoc", "startDownloadForegroundService", "", "getStartDownloadForegroundService", "setStartDownloadForegroundService", "stopDownloadForegroundService", "getStopDownloadForegroundService", "setStopDownloadForegroundService", "subProcProxy", "Lcom/obric/aikernel/runtime/AIInferRuntime$Config$ISubProcessProxy;", "getSubProcProxy", "()Lcom/obric/aikernel/runtime/AIInferRuntime$Config$ISubProcessProxy;", "setSubProcProxy", "(Lcom/obric/aikernel/runtime/AIInferRuntime$Config$ISubProcessProxy;)V", "updateInterval", "getUpdateInterval", "setUpdateInterval", "url", "getUrl", "setUrl", "getUseCenterDistribution", "useObricDownloader", "getUseObricDownloader", "setUseObricDownloader", "build", "Lcom/obric/aikernel/runtime/AIInferRuntime$Config;", "Companion", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class d {
    private static final long W = 0;
    private static final String X = null;
    private static final String Y = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f6193a = null;
    private String A;
    private boolean B;
    private ae<Pair<Boolean, String>> C;
    private ae<String> D;
    private Function0<Long> E;
    private Function0<Integer> F;
    private Function2<? super RequestBody, ? super Continuation<? super String>, ? extends Object> G;
    private Function0<Boolean> H;
    private Function0<Boolean> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private String f6194J;
    private Function0<Boolean> K;
    private List<Pair<String, String>> L;
    private boolean M;
    private List<String> N;
    private List<String> O;
    private String P;
    private boolean Q;
    private Function0<Unit> R;
    private Function0<Unit> S;
    private Map<String, AIInferRuntime.d.e> T;
    private AIInferRuntime.d.c U;
    private Map<String, String> V;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f6195b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final Function1<Continuation<? super String>, Object> g;
    private final String h;
    private final boolean i;
    private final boolean j;
    private String k;
    private int l;
    private boolean m;
    private List<? extends Pair<String, ? extends Object>> n;
    private AIInferRuntime.b o;
    private Function0<Long> p;
    private Function0<Long> q;
    private String r;
    private String s;
    private AIInferRuntime.d.b t;
    private String u;
    private Function0<Integer> v;
    private String w;
    private String x;
    private com.obric.aikernel.runtime.utils.c y;
    private PackageResourceManager.PresmConfig.c z;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\r"}, d2 = {"Lcom/obric/aikernel/runtime/RuntimeConfigBuilder$Companion;", "", "()V", "DEFAULT_UPDATE_INTERVAL", "", "getDEFAULT_UPDATE_INTERVAL", "()J", "HOST_TYPE_APP", "", "getHOST_TYPE_APP", "()Ljava/lang/String;", "HOST_TYPE_PLUGIN", "getHOST_TYPE_PLUGIN", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final long a() {
            return d.b();
        }

        public final String b() {
            return d.c();
        }
    }

    @Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/obric/aikernel/runtime/RuntimeConfigBuilder$packageActionInjector$1", "Lcom/obric/aikernel/res/PackageResourceManager$PresmConfig$IPackageActionInjector;", "infer_runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements PackageResourceManager.PresmConfig.c {
        b() {
        }

        @Override // com.obric.aikernel.res.PackageResourceManager.PresmConfig.c
        public boolean a(int r1, String r2, String r3) {
            return PackageResourceManager.PresmConfig.c.b.a(this, r1, r2, r3);
        }
    }

    static {
        f6193a = new a(null);
        Duration.Companion r0 = Duration.Companion;
        W = Duration.m2793toLongimpl(DurationKt.toDuration(1, DurationUnit.HOURS), DurationUnit.MILLISECONDS);
        X = l.f6234a.a();
        Y = l.f6234a.b();
    }

    public d(Context r3, String r4, String r5, String r6, String r7, Function1<? super Continuation<? super String>, ? extends Object> r8, String r9, boolean r10, boolean r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Function1<Continuation<? super String>, Object> r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r8, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "context");
        Intrinsics.checkNotNullParameter(r4, "aid");
        Intrinsics.checkNotNullParameter(r5, "projectId");
        Intrinsics.checkNotNullParameter(r6, "appVersion");
        Intrinsics.checkNotNullParameter(r7, "channel");
        Intrinsics.checkNotNullParameter(r13, "did");
        Intrinsics.checkNotNullParameter(r9, "compatAppVersion");
        Context r14 = ZeusTransformUtils.wrapperContext(r12, "com.obric.memorydata.plugin");
        this.f6195b = r14;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r13;
        this.h = r9;
        this.i = r10;
        this.j = r11;
        this.k = com.obric.aikernel.runtime.utils.a.f6212a.a();
        this.l = 50;
        this.p = (Function0) ZeusTransformUtils.preCheckCast(RuntimeConfigBuilder$inferNotResponseTimeMills$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
        this.q = (Function0) ZeusTransformUtils.preCheckCast(RuntimeConfigBuilder$updateInterval$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
        String r15 = r14.getFilesDir().getPath();
        Intrinsics.checkNotNullExpressionValue(r15, "context.filesDir.path");
        this.r = r15;
        this.v = (Function0) ZeusTransformUtils.preCheckCast(RuntimeConfigBuilder$hostUserId$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
        this.w = X;
        this.z = (PackageResourceManager.PresmConfig.c) ZeusTransformUtils.preCheckCast(new b(), PackageResourceManager.PresmConfig.c.class, "com.obric.memorydata.plugin");
        this.A = com.obric.aikernel.runtime.utils.e.f6218a.a(r11);
        this.C = at.a(new Pair(false, "default disable background update."));
        this.E = (Function0) ZeusTransformUtils.preCheckCast(RuntimeConfigBuilder$autoCleanResourceInterval$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
        this.F = (Function0) ZeusTransformUtils.preCheckCast(RuntimeConfigBuilder$autoCleanResourceTotalGB$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
        this.H = (Function0) ZeusTransformUtils.preCheckCast(RuntimeConfigBuilder$autoDeleteDebugPackage$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
        this.I = (Function0) ZeusTransformUtils.preCheckCast(RuntimeConfigBuilder$checkPackageResource$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
        this.K = (Function0) ZeusTransformUtils.preCheckCast(RuntimeConfigBuilder$allowNetworkRequest$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
        this.N = CollectionsKt.emptyList();
        this.O = CollectionsKt.emptyList();
        this.P = Build.SOC_MODEL;
        this.R = (Function0) ZeusTransformUtils.preCheckCast(RuntimeConfigBuilder$startDownloadForegroundService$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
        this.S = (Function0) ZeusTransformUtils.preCheckCast(RuntimeConfigBuilder$stopDownloadForegroundService$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ d(Context r14, String r15, String r16, String r17, String r18, Function1 r19, String r20, boolean r21, boolean r22, int r23, DefaultConstructorMarker r24) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
        Function1 r9 = (Function1) ZeusTransformUtils.wrapperContextForParams(r19, Function1.class, "com.obric.memorydata.plugin");
        if ((r23 & 64) == 0) goto L5;
        String r10 = "";
    L7:
        if ((r23 & 128) == 0) goto L9;
        boolean r11 = false;
    L11:
        if ((r23 & 256) == 0) goto L13;
        boolean r12 = false;
    L14:
        this(r4, r15, r16, r17, r18, r9, r10, r11, r12);
        return;
    L13:
        r12 = r22;
        goto L14
    L9:
        r11 = r21;
        goto L11
    L5:
        r10 = r20;
        goto L7
    }

    public static final /* synthetic */ long b() {
        return W;
    }

    public static final /* synthetic */ String c() {
        return X;
    }

    public final AIInferRuntime.d a() {
        if (this.i == false) goto L5;
        String r1 = '/' + this.d;
    L6:
        String r8 = new File(this.r, "prs" + r1).getPath();
        String r2 = this.s;
        if (r2 == null) goto L12;
        String r3 = new File(r2, "prs" + r1).getPath();
        if (r3 == null) goto L12;
        String r9 = r3;
    L13:
        com.obric.aikernel.runtime.utils.c r4 = this.y;
        if (r4 == null) goto L16;
        AIInferRuntime.d.C0273d r5 = new AIInferRuntime.d.C0273d(r4);
    L17:
        Context r6 = this.f6195b;
        int r7 = this.l;
        boolean r10 = this.m;
        List<? extends Pair<String, ? extends Object>> r15 = this.n;
        AIInferRuntime.b r14 = this.o;
        Function0<Long> r13 = this.p;
        Function0<Long> r12 = this.q;
        Intrinsics.checkNotNullExpressionValue(r8, "finalRootDir");
        Intrinsics.checkNotNullExpressionValue(r9, "finalResDir");
        PackageResourceManager.PresmConfig.AppConfig r11 = new PackageResourceManager.PresmConfig.AppConfig(this.c, this.e, this.f, this.g, String.valueOf(((Number) ZeusTransformUtils.preCheckCast(this.v.invoke(), Number.class, "com.obric.memorydata.plugin")).intValue()), this.A, this.d, this.h, this.m, this.B, this.C, this.D, this.E, this.F, this.G, this.H, this.I, this.K, this.P, this.Q, this.R, this.S, this.k);
        String r16 = this.u;
        String r17 = this.x;
        com.obric.aikernel.runtime.utils.c r18 = (com.obric.aikernel.runtime.utils.c) ZeusTransformUtils.preCheckCast(r5, com.obric.aikernel.runtime.utils.c.class, "com.obric.memorydata.plugin");
        PackageResourceManager.PresmConfig.c r19 = this.z;
        AIInferRuntime.d.C0273d r24 = r5;
        String r20 = this.f6194J;
        List<Pair<String, String>> r21 = this.L;
        if (r21 == null) goto L28;
        Map r22 = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        Iterator r23 = ((Iterable) ZeusTransformUtils.preCheckCast(r21, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L21:
        if (r23.hasNext() == false) goto L27;
        Iterator r110 = r23;
        Pair r25 = (Pair) ZeusTransformUtils.preCheckCast(r23.next(), Pair.class, "com.obric.memorydata.plugin");
        Object r111 = r25.getFirst();
        Object r112 = r22.get(r111);
        Function0<Long> r28 = r13;
        if (r112 != null) goto L25;
        Object r113 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        r22.put(r111, r113);
    L26:
        ((Set) ZeusTransformUtils.preCheckCast(r113, Set.class, "com.obric.memorydata.plugin")).add(r25.getSecond());
        r23 = r110;
        r13 = r28;
        r14 = r14;
        goto L21
    L25:
        r113 = r112;
        goto L26
    L27:
        Function0<Long> r29 = r13;
        AIInferRuntime.b r210 = r14;
        Map r30 = r22;
    L30:
        return new AIInferRuntime.d(r6, r7, r10, r15, r210, r29, r12, new PackageResourceManager.PresmConfig(r6, r8, r9, r11, com.obric.aee.BuildConfig.PLATFORM_PYTHON_VERSION, r16, r17, r18, r19, r20, r30, this.M, 0, this.N, this.O, 4096, null), r24, this.U, this.t, this.T, this.V);
    L28:
        r29 = r13;
        r210 = r14;
        r30 = null;
        goto L30
    L16:
        r5 = null;
    L12:
        r9 = r8;
        goto L13
    L5:
        r1 = "";
        goto L6
    }

    public final void a(AIInferRuntime.b r3) {
        this.o = (AIInferRuntime.b) ZeusTransformUtils.wrapperContextForParams(r3, AIInferRuntime.b.class, "com.obric.memorydata.plugin");
    }

    public final void a(com.obric.aikernel.runtime.utils.c r3) {
        this.y = (com.obric.aikernel.runtime.utils.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aikernel.runtime.utils.c.class, "com.obric.memorydata.plugin");
    }

    public final void a(String r1) {
        this.u = r1;
    }

    public final void a(List<? extends Pair<String, ? extends Object>> r3) {
        this.n = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void a(Map<String, String> r3) {
        this.V = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    public final void a(Function0<Integer> r3) {
        Function0<Integer> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.v = r4;
    }

    public final void a(boolean r1) {
        this.m = r1;
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.w = r2;
    }

    public final void b(Function0<Boolean> r3) {
        Function0<Boolean> r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.K = r4;
    }

    public final Context getContext() {
        return this.f6195b;
    }
}
