package com.obric.memorydata.aikernelcore;

import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.memorydata.constants.DevTrackerEventId;
import com.obric.memorydata.middleware.api.aikernel.PapayaAPI;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.controller.NetworkController;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.model.BaseResponse;
import com.obric.memorydata.task.cron.CronJobRunnerTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001aJ\u000e\u0010 \u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0005J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010$J\u000e\u0010 \u001a\u00020\u001a*\u0004\u0018\u00010$H\u0002J\u000e\u0010%\u001a\u00020\u001a*\u0004\u0018\u00010$H\u0002J\u000e\u0010&\u001a\u00020\u001a*\u0004\u0018\u00010$H\u0002J\u0010\u0010'\u001a\u0004\u0018\u00010(*\u0004\u0018\u00010$H\u0002J\u0010\u0010)\u001a\u0004\u0018\u00010**\u0004\u0018\u00010$H\u0002J\u0014\u0010+\u001a\u00020\u0005*\u00020(2\u0006\u0010,\u001a\u00020\u0005H\u0002J\u001b\u0010-\u001a\u0004\u0018\u00010.*\u00020(2\u0006\u0010,\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010/J\u0010\u00100\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\u0018\u00101\u001a\u00020\"2\u0006\u00102\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u001aH\u0002J\b\u00103\u001a\u00020\"H\u0002J\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u00050\tJ\u000e\u00105\u001a\u00020\"2\u0006\u00106\u001a\u00020\u0005J\u000e\u00107\u001a\u00020\"2\u0006\u00106\u001a\u00020\u0005J\u000e\u00108\u001a\u00020\"2\u0006\u00106\u001a\u00020\u0005J\u000e\u00109\u001a\u00020\"2\u0006\u0010:\u001a\u00020\rJ\u000e\u0010;\u001a\u00020\"2\u0006\u0010<\u001a\u00020\u0010J\u000e\u0010=\u001a\u00020\"2\u0006\u0010<\u001a\u00020\u0010J\u0006\u0010>\u001a\u00020\"J\u0016\u0010?\u001a\u00020\"2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0002J\u0006\u0010A\u001a\u00020\"J\u000e\u0010A\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u0005J\u0010\u0010B\u001a\u00020\u001a2\u0006\u0010C\u001a\u00020DH\u0002JG\u0010E\u001a\u00020F2\u0006\u0010\u001e\u001a\u00020\u00052\b\b\u0002\u0010G\u001a\u00020\u001a2%\b\u0002\u0010H\u001a\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0004\u0012\u00020\"\u0018\u00010IH\u0086@¢\u0006\u0002\u0010MJE\u0010N\u001a\u00020\"2\u0006\u0010C\u001a\u00020D2\u0006\u0010G\u001a\u00020\u001a2%\b\u0002\u0010H\u001a\u001f\u0012\u0013\u0012\u00110\u001a¢\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0004\u0012\u00020\"\u0018\u00010IH\u0082@¢\u0006\u0002\u0010OJ*\u0010P\u001a\u00020\"2\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010R\u001a\u00020S2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\"0IR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R4\u0010\u0006\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\t0\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001a0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u001c\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\t0\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006U"}, d2 = {"Lcom/obric/memorydata/aikernelcore/PapayaManager;", "", "<init>", "()V", "TAG", "", "readyPackageSet", "", "kotlin.jvm.PlatformType", "", "Ljava/util/Set;", "callbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/memorydata/aikernelcore/PackageFinishedCallback;", "packageUpdateListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/obric/memorydata/aikernelcore/PackageUpdateListener;", "MAX_RUNNING_TASK_COUNT", "", "HIGH_TASK_LOWEST_COUNT", "compatibilityVersionMap", "Ljava/util/concurrent/ConcurrentHashMap;", "runningPackages", "updatingMap", "Lkotlinx/coroutines/Job;", "concurrentConfigCache", "", "scheduleConfigCache", "fetchingConfigs", "canSubmitTask", "bizName", "highPriority", "hasScheduleConfig", "updateScheduleConfigCache", "", "extraConfig", "Lcom/google/gson/JsonElement;", "hasValidTimerConfig", "hasValidCronConfig", "asJsonObjectOrNull", "Lcom/google/gson/JsonObject;", "asJsonArrayOrNull", "Lcom/google/gson/JsonArray;", "optString", "key", "optLong", "", "(Lcom/google/gson/JsonObject;Ljava/lang/String;)Ljava/lang/Long;", "isConcurrent", "trackPendingTaskEvent", "curTask", "printRunningPackages", "getRunningPackages", "onTaskStart", "taskName", "onTaskEnd", "onTaskTimeout", "registerTaskFinishedCallback", "callback", "registerPackageUpdateListener", "listener", "unregisterPackageUpdateListener", "updateAllPackageInfo", "notifyPackageUpdated", "packageNames", "makePackageReadyCacheInvalid", "checkPkgVersion", "pkg", "Lcom/obric/aikernel/sdk/data/PackageResource;", "checkOrUpdate", "Lcom/obric/memorydata/model/BaseResponse;", "aikernelPkg", "loadCallback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "loadSuccess", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePackageResource", "(Lcom/obric/aikernel/sdk/data/PackageResource;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runTask", "businessName", "input", "Lorg/json/JSONObject;", "Landroid/os/Bundle;", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f8481a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f8482b = null;
    private static final CopyOnWriteArrayList<d> c = null;
    private static final CopyOnWriteArraySet<e> d = null;
    private static final ConcurrentHashMap<String, Integer> e = null;
    private static final CopyOnWriteArraySet<String> f = null;
    private static final ConcurrentHashMap<String, bx> g = null;
    private static final ConcurrentHashMap<String, Boolean> h = null;
    private static final ConcurrentHashMap<String, Boolean> i = null;
    private static final Set<String> j = null;

    static {
        f8481a = new h();
        f8482b = Collections.synchronizedSet((Set) ZeusTransformUtils.preCheckCast(new HashSet(), Set.class, "com.obric.memorydata.plugin"));
        c = new CopyOnWriteArrayList();
        d = new CopyOnWriteArraySet();
        ConcurrentHashMap<String, Integer> r0 = new ConcurrentHashMap();
        e = r0;
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put("next_app_init", 16419);
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put("next_app_predict", 16420);
        f = new CopyOnWriteArraySet();
        g = new ConcurrentHashMap();
        h = new ConcurrentHashMap();
        i = new ConcurrentHashMap();
        j = Collections.synchronizedSet((Set) ZeusTransformUtils.preCheckCast(new HashSet(), Set.class, "com.obric.memorydata.plugin"));
    }

    private h() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Object a(PackageResource r17, boolean r18, Function1<? super Boolean, Unit> r19, Continuation<? super Unit> r20) {
        h r0 = this;
        Function1 r2 = (Function1) ZeusTransformUtils.wrapperContextForParams(r19, Function1.class, "com.obric.memorydata.plugin");
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r4, PapayaManager$updatePackageResource$1.class) == false) goto L7;
        PapayaManager$updatePackageResource$1 r5 = (PapayaManager$updatePackageResource$1) ZeusTransformUtils.preCheckCast(r4, PapayaManager$updatePackageResource$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        PapayaManager$updatePackageResource$1 r9 = r5;
        Object r6 = r9.result;
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r8 = r9.label;
        if (r8 == 0) goto L16;
        if (r8 == 1) goto L15;
        if (r8 != 2) goto L14;
        long r10 = r9.J$0;
        Ref.ObjectRef r1 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r9.L$4, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r3 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r9.L$3, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        String r11 = (String) ZeusTransformUtils.preCheckCast(r9.L$2, String.class, "com.obric.memorydata.plugin");
        Function1 r12 = (Function1) ZeusTransformUtils.preCheckCast(r9.L$1, Function1.class, "com.obric.memorydata.plugin");
        h r13 = (h) ZeusTransformUtils.preCheckCast(r9.L$0, h.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
        long r14 = r10;
        Object r15 = r6;
        Ref.ObjectRef r16 = r1;
        r0 = r13;
    L26:
        T r21 = Result.m1421constructorimpl(r15);
    L27:
        r16.element = r21;
        RunLog.INSTANCE.debug("PapayaManager", "updatePackage " + r11 + " cost " + (System.currentTimeMillis() - r14) + "ms");
        Object r22 = r3.element;
        if (Result.m1427isFailureimpl(r22) == false) goto L30;
        r22 = null;
    L30:
        PackageResource r23 = (PackageResource) ZeusTransformUtils.preCheckCast(r22, PackageResource.class, "com.obric.memorydata.plugin");
        if (r23 != null) goto L33;
    L35:
        boolean r24 = false;
    L37:
        if (r24 == true) goto L41;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PapayaManager", "Update package " + r11 + " failed: " + Result.m1424exceptionOrNullimpl(r3.element), null, 4, null);
        if (r12 == null) goto L46;
        Boolean r25 = Boxing.boxBoolean(false);
    L44:
        r12.invoke(r25);
    L46:
        return Unit.INSTANCE;
    L41:
        RunLog.INSTANCE.debug("PapayaManager", "Update package " + r11 + " success.");
        r0.e(r11);
        r0.a(SetsKt.setOf(r11));
        if (r12 == null) goto L46;
        r25 = Boxing.boxBoolean(true);
        goto L44
    L33:
        if (r23.isAvailable() != true) goto L35;
        r24 = true;
        goto L37
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        long r26 = r9.J$0;
        Ref.ObjectRef r27 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r9.L$4, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r3 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r9.L$3, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r11 = (String) ZeusTransformUtils.preCheckCast(r9.L$2, String.class, "com.obric.memorydata.plugin");
        r12 = (Function1) ZeusTransformUtils.preCheckCast(r9.L$1, Function1.class, "com.obric.memorydata.plugin");
        h r28 = (h) ZeusTransformUtils.preCheckCast(r9.L$0, h.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r6);
        r14 = r26;
        r21 = ((Result) ZeusTransformUtils.preCheckCast(r6, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
        r16 = r27;
        r0 = r28;
        goto L27
    L16:
        ResultKt.throwOnFailure(r6);
        String r29 = r17.getName();
        RunLog.INSTANCE.debug("PapayaManager", "updatePackageResource for " + r29);
        r16 = new Ref.ObjectRef();
        r14 = System.currentTimeMillis();
        if (r18 == false) goto L22;
        IAIKernelManager r30 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
        r9.L$0 = r0;
        r9.L$1 = r2;
        r9.L$2 = r29;
        r9.L$3 = r16;
        r9.L$4 = r16;
        r9.J$0 = r14;
        r9.label = 1;
        Object r31 = IAIKernelManager.DefaultImpls.m191updatePackage0E7RQCE$default(r30, r17, null, r9, 2, null);
        if (r31 != r7) goto L21;
        return r7;
    L21:
        r11 = r29;
        r12 = r2;
        r3 = r16;
        r21 = r31;
        goto L27
    L22:
        Result.Companion r32 = Result.Companion;
        MemoryScriptEngineEnv r33 = MemoryScriptEngineEnv.INSTANCE;
        String r34 = r17.getName();
        r9.L$0 = r0;
        r9.L$1 = r2;
        r9.L$2 = r29;
        r9.L$3 = r16;
        r9.L$4 = r16;
        r9.J$0 = r14;
        r9.label = 2;
        r15 = r33.updatePackage(r34, r9);
        if (r15 != r7) goto L25;
        return r7;
    L25:
        r11 = r29;
        r12 = r2;
        r3 = r16;
    L7:
        r5 = new PapayaManager$updatePackageResource$1(r0, r4);
        goto L8
    }

    public static final /* synthetic */ Object a(h r2, PackageResource r3, boolean r4, Function1 r5, Continuation r6) {
        return r2.a(r3, r4, (Function1) ZeusTransformUtils.wrapperContextForParams(r5, Function1.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Object a(h r1, String r2, boolean r3, Function1 r4, Continuation r5, int r6, Object r7) {
        Function1<? super Boolean, Unit> r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Continuation<? super BaseResponse> r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r8 = null;
    L9:
        return r1.a(r2, r3, r8, r9);
    }

    private final String a(JsonObject r1, String r2) {
        JsonElement r0 = r1.get(r2);
        Object r3 = "";
        if (r0 != null) goto L15;
        return "";
    L15:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L7
        Object r5 = Result.m1421constructorimpl(r0.getAsString());     // Catch: Throwable -> L7
    L10:
        if (Result.m1427isFailureimpl(r5) == true) goto L14;
        r3 = r5;
    L14:
        return (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private static final Unit a(Throwable r3) {
        Intrinsics.checkNotNullParameter(r3, "error");
        RunLog.INSTANCE.error("PapayaManager", "package update listener failed", r3);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void a(h r2, Set r3) {
        r2.a((Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin"));
    }

    private final void a(Set<String> r3) {
        Set r2 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
        if (r2.isEmpty() == false) goto L5;
        return;
    L5:
        f.a((Iterable) ZeusTransformUtils.preCheckCast(d, Iterable.class, "com.obric.memorydata.plugin"), r2, $$Lambda$h$Ea2RYViD52NNNZU5umLatLfH1YY.INSTANCE);
    }

    private final boolean a(JsonElement r7) {
        JsonObject r8 = d(r7);
        if (r8 != null) goto L6;
        return false;
    L6:
        if (b(r8.get(CommonConsts.TIMER_TYPE)) == true) goto L42;
        JsonArray r1 = e(r8.get("timers"));
        if (r1 == null) goto L22;
        Iterable r2 = (Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, Collection.class) == true) goto L12;
    L14:
        Iterator r3 = r2.iterator();
    L16:
        if (r3.hasNext() == false) goto L13;
        if (f8481a.b((JsonElement) ZeusTransformUtils.preCheckCast(r3.next(), JsonElement.class, "com.obric.memorydata.plugin")) == false) goto L16;
        boolean r4 = true;
    L20:
        if (r4 != true) goto L22;
        boolean r5 = true;
    L23:
        if (r5 == true) goto L42;
        JsonArray r6 = e(r8.get("cron_list"));
        if (r6 == null) goto L39;
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r9, Collection.class) == true) goto L29;
    L31:
        Iterator r10 = r9.iterator();
    L33:
        if (r10.hasNext() == false) goto L30;
        if (f8481a.c((JsonElement) ZeusTransformUtils.preCheckCast(r10.next(), JsonElement.class, "com.obric.memorydata.plugin")) == false) goto L33;
        boolean r11 = true;
    L37:
        if (r11 != true) goto L39;
        boolean r12 = true;
    L40:
        if (r12 == true) goto L42;
        return false;
    L30:
        r11 = false;
        goto L37
    L29:
        if (((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L31;
    L39:
        r12 = false;
    L13:
        r4 = false;
        goto L20
    L12:
        if (((Collection) ZeusTransformUtils.preCheckCast(r2, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L14;
    L22:
        r5 = false;
    L42:
        return true;
    }

    private final boolean a(PackageResource r8) {
        ConcurrentHashMap<String, Integer> r7 = e;
        if (r7.containsKey(r8.getName()) == true) goto L6;
        return true;
    L6:
        if (TextUtils.isDigitsOnly((CharSequence) ZeusTransformUtils.preCheckCast(r8.getVersion(), CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L11;
        int r0 = Integer.parseInt(r8.getVersion());
        Integer r2 = r7.get(r8.getName());
        Intrinsics.checkNotNull(r2);
        if (r0 >= ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).intValue()) goto L11;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PapayaManager", "package " + r8.getName() + " version " + r8.getVersion() + " is lower than " + r7.get(r8.getName()), null, 4, null);
        return false;
    L11:
        return true;
    }

    private final Long b(JsonObject r3, String r4) {
        JsonElement r2 = r3.get(r4);
        Object r5 = null;
        if (r2 != null) goto L15;
        return null;
    L15:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L7
        Object r7 = Result.m1421constructorimpl(Long.valueOf(r2.getAsLong()));     // Catch: Throwable -> L7
    L10:
        if (Result.m1427isFailureimpl(r7) == true) goto L14;
        r5 = r7;
    L14:
        return (Long) ZeusTransformUtils.preCheckCast(r5, Long.class, "com.obric.memorydata.plugin");
    L7:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    private final void b(String r11, boolean r12) {
        JSONObject r0 = new JSONObject();
        r0.put("current_task", r11);
        r0.put("immediate", r12 ? 1 : 0);
        r0.put("running_tasks", CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(a(), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(",", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));
        Tracker.INSTANCE.reportDevEvent(DevTrackerEventId.TASK_PENDING_EVENT.getValue(), r0);
    }

    private final boolean b(JsonElement r5) {
        JsonObject r6 = d(r5);
        if (r6 != null) goto L5;
        return false;
    L5:
        String r1 = a(r6, "type");
        String r2 = a(r6, OaidModel.KEY_TIME);
        Long r4 = b(r6, "interval_sec");
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L8;
        return false;
    L8:
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L13;
        if (r4 != null) goto L11;
        return false;
    L11:
        if (r4.longValue() > 0) goto L13;
        return false;
    L13:
        return true;
    }

    private final boolean c(JsonElement r2) {
        JsonObject r3 = d(r2);
        if (r3 != null) goto L7;
        return false;
    L7:
        return !StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(a(r3, CronJobRunnerTask.KEY_CRON), CharSequence.class, "com.obric.memorydata.plugin"));
    }

    private final JsonObject d(JsonElement r1) {
        if (r1 != null) goto L4;
    L6:
        return null;
    L4:
        if (r1.isJsonObject() == false) goto L6;
        return r1.getAsJsonObject();
    }

    public static final /* synthetic */ ConcurrentHashMap d() {
        return h;
    }

    private final JsonArray e(JsonElement r1) {
        if (r1 != null) goto L4;
    L6:
        return null;
    L4:
        if (r1.isJsonArray() == false) goto L6;
        return r1.getAsJsonArray();
    }

    public static final /* synthetic */ CopyOnWriteArrayList e() {
        return c;
    }

    public static final /* synthetic */ Set f() {
        return j;
    }

    private final boolean f(String r9) {
        Boolean r8 = (Boolean) ZeusTransformUtils.preCheckCast(h.get(r9), Boolean.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L7;
        return r8.booleanValue();
    L7:
        if (j.add(r9) == false) goto L11;
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new PapayaManager$isConcurrent$2(r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        return false;
    L11:
        return false;
    }

    public static final /* synthetic */ ConcurrentHashMap g() {
        return g;
    }

    private final void h() {
        RunLog.INSTANCE.debug("PapayaManager", "running packages: " + f);
    }

    public static /* synthetic */ Unit lambda$Ea2RYViD52NNNZU5umLatLfH1YY(Throwable r0) {
        return a(r0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object a(String r24, boolean r25, Function1<? super Boolean, Unit> r26, Continuation<? super BaseResponse> r27) {
        h r0 = this;
        String r7 = r24;
        boolean r8 = r25;
        Function1 r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r26, Function1.class, "com.obric.memorydata.plugin");
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r27, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, PapayaManager$checkOrUpdate$1.class) == false) goto L7;
        PapayaManager$checkOrUpdate$1 r3 = (PapayaManager$checkOrUpdate$1) ZeusTransformUtils.preCheckCast(r2, PapayaManager$checkOrUpdate$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        PapayaManager$checkOrUpdate$1 r4 = r3;
        Object r5 = r4.result;
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r4.label;
        String r15 = "PapayaManager";
        if (r6 == 0) goto L16;
        if (r6 == 1) goto L15;
        if (r6 != 2) goto L14;
        long r9 = r4.J$0;
        boolean r1 = r4.Z$0;
        Ref.ObjectRef r12 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r4.L$4, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r13 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r4.L$3, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r10 = (Function1) ZeusTransformUtils.preCheckCast(r4.L$2, Function1.class, "com.obric.memorydata.plugin");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r4.L$1, String.class, "com.obric.memorydata.plugin");
        h r16 = (h) ZeusTransformUtils.preCheckCast(r4.L$0, h.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        Ref.ObjectRef r17 = r13;
        r7 = r14;
        r8 = r1;
        r0 = r16;
    L31:
        Object r18 = (PackageResource) ZeusTransformUtils.preCheckCast(r5, PackageResource.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L34;
        Result.Companion r19 = Result.Companion;
    L35:
        T r20 = Result.m1421constructorimpl(r18);
    L26:
        boolean r110 = r8;
        r12.element = r20;
        String r21 = r15;
        RunLog.INSTANCE.debug(r21, "getPackageResource " + r7 + " cost " + (System.currentTimeMillis() - r9) + "ms");
        if (Result.m1427isFailureimpl(r17.element) == false) goto L40;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PapayaManager", "getPackageResource " + r7 + " Failed: " + Result.m1424exceptionOrNullimpl(r17.element) + '\n', null, 4, null);
        return new BaseResponse(1004, "query package " + r7 + " failed");
    L40:
        T r22 = r17.element;
        ResultKt.throwOnFailure(r22);
        PackageResource r23 = (PackageResource) ZeusTransformUtils.preCheckCast(r22, PackageResource.class, "com.obric.memorydata.plugin");
        boolean r28 = r23.isAvailable();
        RunLog.INSTANCE.debug(r21, "getPackageResource " + r7 + " available = " + r28 + ", pkg version = " + r23.getVersion());
        if (r28 == true) goto L43;
    L46:
        if (r28 == false) goto L52;
        if (r0.a(r23) == false) goto L52;
        f8482b.add(r7);
        return new BaseResponse(0, "package " + r7 + " is ready");
    L52:
        if (NetworkController.INSTANCE.isNetworkPolicySatisfied() == false) goto L66;
        ConcurrentHashMap<String, bx> r29 = g;
        bx r30 = (bx) ZeusTransformUtils.preCheckCast(r29.get(r7), bx.class, "com.obric.memorydata.plugin");
        if (r30 != null) goto L56;
    L58:
        boolean r111 = false;
    L59:
        if (r111 == false) goto L65;
        RunLog.INSTANCE.debug(r21, "update package " + r7 + " is running, skip");
        if (r10 == null) goto L64;
        r10.invoke(Boxing.boxBoolean(false));
    L64:
        return new BaseResponse(1005, "query package " + r7 + " failed");
    L65:
        ((Map) ZeusTransformUtils.preCheckCast(r29, Map.class, "com.obric.memorydata.plugin")).put(r7, i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new PapayaManager$checkOrUpdate$updateJob$1(r23, r110, r10, r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null));
    L68:
        RunLog.INSTANCE.debug(r21, "return " + r7 + " ready status failed");
        return new BaseResponse(1005, "query package " + r7 + " failed");
    L56:
        if (r30.a() != true) goto L58;
        r111 = true;
        goto L59
    L66:
        if (r10 == null) goto L68;
        r10.invoke(Boxing.boxBoolean(false));
        goto L68
    L43:
        if (r0.a(r23) == true) goto L46;
        return new BaseResponse(1004, "package " + r7 + " version too low");
    L34:
        Result.Companion r31 = Result.Companion;
        r18 = ResultKt.createFailure(new Throwable("package " + r7 + " not found"));
        goto L35
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r9 = r4.J$0;
        boolean r32 = r4.Z$0;
        r12 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r4.L$4, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r33 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r4.L$3, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r10 = (Function1) ZeusTransformUtils.preCheckCast(r4.L$2, Function1.class, "com.obric.memorydata.plugin");
        String r34 = (String) ZeusTransformUtils.preCheckCast(r4.L$1, String.class, "com.obric.memorydata.plugin");
        h r35 = (h) ZeusTransformUtils.preCheckCast(r4.L$0, h.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r5);
        r17 = r33;
        r7 = r34;
        r15 = "PapayaManager";
        r8 = r32;
        r0 = r35;
        r20 = ((Result) ZeusTransformUtils.preCheckCast(r5, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
        goto L26
    L16:
        ResultKt.throwOnFailure(r5);
        RunLog.INSTANCE.debug("PapayaManager", "start checkOrUpdate " + r7);
        if (f8482b.contains(r7) == false) goto L20;
        RunLog.INSTANCE.debug("PapayaManager", "package " + r7 + " is ready in cache");
        return new BaseResponse(0, "package " + r7 + " is ready (cache)");
    L20:
        Ref.ObjectRef r36 = new Ref.ObjectRef();
        long r37 = System.currentTimeMillis();
        if (r8 == false) goto L27;
        IAIKernelManager r38 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
        r4.L$0 = r0;
        r4.L$1 = r7;
        r4.L$2 = r10;
        r4.L$3 = r36;
        r4.L$4 = r36;
        r4.Z$0 = r8;
        r4.J$0 = r37;
        r4.label = 1;
        r15 = "PapayaManager";
        r17 = r36;
        Object r39 = IAIKernelManager.DefaultImpls.m190getPackage0E7RQCE$default(r38, r24, null, r4, 2, null);
        if (r39 != r11) goto L25;
        return r11;
    L25:
        r12 = r17;
        r9 = r37;
        r20 = r39;
        goto L26
    L27:
        r17 = r36;
        MemoryScriptEngineEnv r40 = MemoryScriptEngineEnv.INSTANCE;
        r4.L$0 = r0;
        r4.L$1 = r7;
        r4.L$2 = r10;
        r4.L$3 = r17;
        r4.L$4 = r17;
        r4.Z$0 = r8;
        r4.J$0 = r37;
        r4.label = 2;
        r5 = r40.getPackage(r7, r4);
        if (r5 != r11) goto L30;
        return r11;
    L30:
        r12 = r17;
        r9 = r37;
    L7:
        r3 = new PapayaManager$checkOrUpdate$1(r0, r2);
        goto L8
    }

    public final Set<String> a() {
        return (Set) ZeusTransformUtils.preCheckCast(f, Set.class, "com.obric.memorydata.plugin");
    }

    public final void a(d r2) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r2, d.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "callback");
        c.add(r1);
    }

    public final void a(e r2) {
        e r1 = (e) ZeusTransformUtils.wrapperContextForParams(r2, e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "listener");
        d.add(r1);
    }

    public final void a(String r4, JsonElement r5) {
        Intrinsics.checkNotNullParameter(r4, "bizName");
        boolean r3 = a(r5);
        ((Map) ZeusTransformUtils.preCheckCast(i, Map.class, "com.obric.memorydata.plugin")).put(r4, Boolean.valueOf(r3));
        RunLog.INSTANCE.debug("PapayaManager", "package schedule config loaded: " + r4 + ", hasScheduleConfig=" + r3);
    }

    public final void a(String r8, JSONObject r9, Function1<? super Bundle, Unit> r10) {
        Function1 r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "businessName");
        Intrinsics.checkNotNullParameter(r9, "input");
        Intrinsics.checkNotNullParameter(r7, "callback");
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new PapayaManager$runTask$1(r8, r9, r7, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final boolean a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "bizName");
        return Intrinsics.areEqual(i.get(r1), true);
    }

    public final boolean a(String r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "bizName");
        CopyOnWriteArraySet<String> r0 = f;
        boolean r2 = false;
        if (r0.contains(r10) == true) goto L5;
    L8:
        if (r11 == false) goto L10;
        int r1 = 50;
    L12:
        if (r0.size() >= r1) goto L14;
        r2 = true;
    L14:
        if (r2 == true) goto L16;
        RunLog.INSTANCE.debug("PapayaManager", "cannot submit task " + r10 + " when running count = " + r0.size());
        b(r10, r11);
        h();
    L16:
        return r2;
    L10:
        r1 = 40;
        goto L12
    L5:
        if (f(r10) == true) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PapayaManager", "cannot submit same task " + r10 + " when running", null, 4, null);
        h();
        return false;
    }

    public final void b() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PapayaManager", "updateAllPackageInfo execute, init state " + PapayaAPI.INSTANCE.isInit(), false, 4, null);
        if (PapayaAPI.INSTANCE.isInit() == true) goto L5;
        return;
    L5:
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new PapayaManager$updateAllPackageInfo$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void b(String r3) {
        Intrinsics.checkNotNullParameter(r3, "taskName");
        RunLog.INSTANCE.debug("PapayaManager", "onTaskStart " + r3);
        f.add(r3);
    }

    public final void c() {
        f8482b.clear();
        h.clear();
        i.clear();
    }

    public final void c(String r4) {
        Intrinsics.checkNotNullParameter(r4, "taskName");
        RunLog.INSTANCE.debug("PapayaManager", "onTaskEnd " + r4);
        f.remove(r4);
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((d) ZeusTransformUtils.preCheckCast(r3.next(), d.class, "com.obric.memorydata.plugin")).a(r4);
        goto L4
    }

    public final void d(String r9) {
        Intrinsics.checkNotNullParameter(r9, "taskName");
        if (f.remove(r9) == true) goto L5;
        return;
    L5:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PapayaManager", "[code=package_task_timeout] release timeout package " + r9, null, 4, null);
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(c, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L7:
        if (r8.hasNext() == false) goto L9;
        ((d) ZeusTransformUtils.preCheckCast(r8.next(), d.class, "com.obric.memorydata.plugin")).a(r9);
        goto L7
    }

    public final void e(String r1) {
        Intrinsics.checkNotNullParameter(r1, "bizName");
        f8482b.remove(r1);
        h.remove(r1);
        i.remove(r1);
    }
}
