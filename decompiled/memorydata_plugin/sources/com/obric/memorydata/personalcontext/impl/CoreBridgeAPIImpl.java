package com.obric.memorydata.personalcontext.impl;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Point;
import android.net.Uri;
import android.os.PowerManager;
import android.provider.Settings;
import androidx.core.app.NotificationCompat;
import com.bytedance.crash.Ensure;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.bytedance.rpc.model.func_callConstants;
import com.obric.aiagent.product.platform.api.IPlatformService;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aiagent.product.platform.api.rom.IRomInfo;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.awareness.api.LocationSnapshot;
import com.obric.memorydata.datatransport.api.DataTransportManagerApi;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.e;
import com.obric.memorydata.middleware.api.logging.g;
import com.obric.memorydata.middleware.api.logging.l;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.logging.w;
import com.obric.memorydata.middleware.api.settings.AppSettingsManager;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.plugin_api.BuildConfig;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.utils.am;
import com.obric.memorydata.utils.c;
import com.obric.memorydata.utils.r;
import com.obric.memorydata.utils.x;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\u0000H\u0007J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\rH\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J&\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00052\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dH\u0016J&\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u00052\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0014H\u0016J \u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0014H\u0016J\u0018\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u00052\u0006\u0010-\u001a\u00020#H\u0016J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000f0\n2\u0006\u0010/\u001a\u00020\u0005H\u0016J\u0010\u00100\u001a\u00020\u00172\u0006\u00101\u001a\u00020#H\u0016J\b\u00102\u001a\u00020\u0005H\u0016J\b\u00103\u001a\u00020\u0014H\u0016J\b\u00104\u001a\u00020\u0014H\u0016J\b\u00105\u001a\u00020\u0014H\u0016J\b\u00106\u001a\u00020\u0014H\u0016J\u0010\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u00020\u0005H\u0016J\b\u00109\u001a\u00020\u0005H\u0016J\b\u0010:\u001a\u00020\u0005H\u0016J\b\u0010;\u001a\u00020\u0005H\u0016J\u0018\u0010<\u001a\u00020\u00052\u0006\u0010=\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/obric/memorydata/personalcontext/impl/CoreBridgeAPIImpl;", "Lcom/obric/memorydata/middleware/api/bridge/ICoreBridgeAPI;", "<init>", "()V", "TAG", "", "powerManager", "Landroid/os/PowerManager;", "getInst", "getLocation", "", "", "effectiveTimeInterval", "", "getTemperatureState", "", "getSetting", "table", "key", "isWorkDay", "", "ts", "removeTask", "", ActivityLifecycle.NAME, "removeTaskIncludingScheduled", "reportEvent", "event", TrackerImpl.PARAMS, "", "", "reportDevelopEvent", "getAppName", ObricMemoryConstants.KEY_PACKAGE_NAME, "getInstalledAppList", "Lorg/json/JSONObject;", "reportError", NotificationCompat.CATEGORY_MESSAGE, "isDebug", "callBizAsFlow", "modelName", Params.CONTENT, "useCloud", "callPackage", "bizName", "input", "getImageDimensions", "uri", "enqueueTask", "taskInfo", "getUid", "isAIKernelAvailable", "isSupportVLM", "isObricOsDevice", "isUTDataCollectEnabled", "deleteFile", Params.FILE_PATH, "getDeviceModel", "getRomReleaseRegion", "getSystemLocale", "functionCall", "apiName", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CoreBridgeAPIImpl implements ICoreBridgeAPI {
    public static final CoreBridgeAPIImpl INSTANCE = null;
    public static final String TAG = "BridgeAPIImpl";
    private static PowerManager powerManager;

    /* JADX INFO: renamed from: com.obric.memorydata.personalcontext.impl.CoreBridgeAPIImpl$callBizAsFlow$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.personalcontext.impl.CoreBridgeAPIImpl$callBizAsFlow$1", f = "CoreBridgeAPIImpl.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $content;
        final /* synthetic */ String $modelName;
        final /* synthetic */ Ref.ObjectRef<String> $responseJson;
        final /* synthetic */ boolean $useCloud;
        int label;

        AnonymousClass1(String r3, String r4, boolean r5, Ref.ObjectRef<String> r6, Continuation<? super AnonymousClass1> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            this.$modelName = r3;
            this.$content = r4;
            this.$useCloud = r5;
            this.$responseJson = r6;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$modelName, this.$content, this.$useCloud, this.$responseJson, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Type inference failed for: r14v5, types: [T, java.lang.String] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L11:
            ?? r15 = (String) ZeusTransformUtils.preCheckCast(r14, String.class, "com.obric.memorydata.plugin");
            if (r15 == 0) goto L14;
            this.$responseJson.element = r15;
            return Unit.INSTANCE;
        L14:
            return null;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            com.obric.memorydata.aikernelcore.a r16 = com.obric.memorydata.aikernelcore.a.INSTANCE;
            String r4 = this.$modelName;
            String r5 = this.$content;
            boolean r6 = this.$useCloud;
            Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r14 = com.obric.memorydata.aikernelcore.a.a(r16, r4, r5, r6, 0, null, r10, 24, null);
            if (r14 != r0) goto L11;
            return r0;
        }
    }

    static {
        INSTANCE = new CoreBridgeAPIImpl();
    }

    private CoreBridgeAPIImpl() {
    }

    @JvmStatic
    public static final CoreBridgeAPIImpl getInst() {
        return INSTANCE;
    }

    private static final String getInstalledAppList$lambda$1(ResolveInfo r0) {
        ActivityInfo r1 = r0.activityInfo;
        if (r1 != null) goto L7;
        return null;
    L7:
        return r1.packageName;
    }

    private static final String getInstalledAppList$lambda$2(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    }

    private static final boolean getInstalledAppList$lambda$3(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ String lambda$BDdf6SF791IhjtHBLchMNiJSnDo(ResolveInfo r0) {
        return getInstalledAppList$lambda$1(r0);
    }

    public static /* synthetic */ String lambda$K2DG1L8FanelClkr9qvF2hDyD1I(String r0) {
        return getInstalledAppList$lambda$2(r0);
    }

    public static /* synthetic */ boolean lambda$afAijS9gH0CAsn7h2WR_6d1M3Cw(String r0) {
        return getInstalledAppList$lambda$3(r0);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public String callBizAsFlow(String r8, String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "modelName");
        Intrinsics.checkNotNullParameter(r9, Params.CONTENT);
        Ref.ObjectRef r7 = new Ref.ObjectRef();
        r7.element = "";
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r8, r9, r10, r7, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        return (String) ZeusTransformUtils.preCheckCast(r7.element, String.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public JSONObject callPackage(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "bizName");
        Intrinsics.checkNotNullParameter(r3, "input");
        TaskResult r1 = ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(r2).setInputParam(r3), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        JSONObject r4 = new JSONObject();
        r4.put("code", r1.getCode());
        r4.put(NotificationCompat.CATEGORY_MESSAGE, r1.getMsg());
        r4.put("data", r1.getOutput());
        return r4;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public boolean deleteFile(String r4) {
        Intrinsics.checkNotNullParameter(r4, Params.FILE_PATH);
        File r3 = new File(r4);     // Catch: Exception -> L9
        if (r3.exists() == true) goto L6;
        return false;
    L6:
        if (r3.isFile() == false) goto L16;
        return r3.delete();
    L16:
        return false;
    L9:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "deleteFile error: " + r4, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return false;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public void enqueueTask(JSONObject r8) {
        Intrinsics.checkNotNullParameter(r8, "taskInfo");
        TaskRequest r7 = TaskRequest.Companion.a(r8);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "enqueueTask name=" + r8.optString(ActivityLifecycle.NAME, "unknown"), false, 4, null);
        r7.enqueue();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public String functionCall(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "apiName");
        Intrinsics.checkNotNullParameter(r12, TrackerImpl.PARAMS);
        o r10 = (o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin");
        e r0 = new e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L6;
        g r2 = new g();
        r2.a("api_name", r11);
        r2.a("params_length", Integer.valueOf(r12.length()));
        Unit r4 = Unit.INSTANCE;
        r10.a("处理 core.functionCall 调用", r0, r2.a());
    L6:
        switch(r11.hashCode()) {
            case -1529229269: goto L26;
            case -954130694: goto L21;
            case -545605146: goto L17;
            case 1729783036: goto L13;
            case 1730097562: goto L9;
            default: goto L29;
        };
    L29:
        o r13 = (o) ZeusTransformUtils.preCheckCast(w.f11638a, o.class, "com.obric.memorydata.plugin");
        e r14 = new e(null, null, null, 7, null);
        g r1 = new g();
        r1.a("api_name", r11);
        r13.a("unknown_function_call", "core.functionCall 调用未注册", r14, r1.a());
        return "";
    L9:
        if (r11.equals("getPluginVersionName") == false) goto L29;
        String r15 = BuildConfig.PLUGIN_VERSION_NAME;
        Intrinsics.checkNotNullExpressionValue(r15, "PLUGIN_VERSION_NAME");
        return r15;
    L13:
        if (r11.equals("getPluginVersionCode") == false) goto L29;
        int r16 = BuildConfig.PLUGIN_VERSION_CODE;
    L33:
        return String.valueOf(r16);
    L17:
        if (r11.equals("getAgentRuntimeContext") == false) goto L29;
        return a.f12190a.a(r12);
    L21:
        if (r11.equals("getAppVersionCode") == false) goto L29;
        r16 = AppContext.INSTANCE.getVersionCode();
        goto L33
    L26:
        if (r11.equals("reportMemoryLogEvent") == false) goto L29;
        return String.valueOf(l.f11625a.a(r12));
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public String getAppName(String r3) {
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_PACKAGE_NAME);
        c.a r2 = c.a(c.f13193a, r3, null, 2, null);
        if (r2 == null) goto L6;
        String r4 = r2.a();
        if (r4 == null) goto L6;
        return r4;
    L6:
        return "";
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public String getDeviceModel() {
        return DeviceInfoState.INSTANCE.getDeviceModel();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public List<Integer> getImageDimensions(String r4) {
        Intrinsics.checkNotNullParameter(r4, "uri");
        Point r3 = x.f13267a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), Uri.parse(r4));
        return CollectionsKt.listOf(new Integer[]{Integer.valueOf(r3.x), Integer.valueOf(r3.y)});
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public JSONObject getInstalledAppList() {
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "getInstalledAppList privacy not agreed", null, 4, null);
        return new JSONObject();
    L6:
        PackageManager r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getPackageManager();
        if (r0 == null) goto L9;
        Intent r2 = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER");
        Intrinsics.checkNotNullExpressionValue(r2, "addCategory(...)");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L13
        CoreBridgeAPIImpl r8 = (CoreBridgeAPIImpl) ZeusTransformUtils.preCheckCast(this, CoreBridgeAPIImpl.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        Object r9 = Result.m1421constructorimpl(r0.queryIntentActivities(r2, 0));     // Catch: Throwable -> L13
    L15:
        List r3 = CollectionsKt.emptyList();
        if (Result.m1427isFailureimpl(r9) == false) goto L18;
        r9 = r3;
    L18:
        List r10 = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
        JSONObject r5 = new JSONObject();
        Iterator r11 = SequencesKt.distinct(SequencesKt.filter(SequencesKt.map(SequencesKt.mapNotNull(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")), $$Lambda$CoreBridgeAPIImpl$BDdf6SF791IhjtHBLchMNiJSnDo.INSTANCE), $$Lambda$CoreBridgeAPIImpl$K2DG1L8FanelClkr9qvF2hDyD1I.INSTANCE), $$Lambda$CoreBridgeAPIImpl$afAijS9gH0CAsn7h2WR_6d1M3Cw.INSTANCE)).iterator();
    L20:
        if (r11.hasNext() == false) goto L37;
        String r6 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");
        Object r7 = null;
        c.a r12 = c.a(c.f13193a, r6, null, 2, null);
        if (r12 == null) goto L38;
        String r13 = r12.a();
        if (r13 == null) goto L38;
    L36:
        r5.put(r6, r13);
    L38:
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L27
        Object r15 = Result.m1421constructorimpl(r0.getApplicationLabel(r0.getApplicationInfo(r6, 0)).toString());     // Catch: Throwable -> L27
    L30:
        if (Result.m1427isFailureimpl(r15) == true) goto L33;
        r7 = r15;
    L33:
        r13 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L36;
        r13 = "";
    L27:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L30
    L37:
        return r5;
    L13:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r9 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L15
    L9:
        return new JSONObject();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public List<Double> getLocation(long r1) {
        return LocationSnapshot.INSTANCE.getLocation(r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public String getRomReleaseRegion() {
        IPlatformService r0 = am.f13169a.a();     // Catch: NoSuchMethodError -> L11
        if (r0 == null) goto L16;
        IRomInfo r1 = r0.romInfo();     // Catch: NoSuchMethodError -> L11
        if (r1 == null) goto L17;
        String r2 = r1.getRomReleaseRegion();     // Catch: NoSuchMethodError -> L11
        if (r2 != null) goto L18;
        return "";
    L18:
        return r2;
    L17:
        return "";
    L16:
        return "";
    L11:
        e = move-exception;
        RunLog.INSTANCE.error(TAG, "getRomReleaseRegion not available in current SDK version", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return "";
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public String getSetting(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "table");
        Intrinsics.checkNotNullParameter(r4, "key");
        int r2 = r3.hashCode();
        if (r2 == (-1243020381)) goto L20;
        if (r2 == (-906273929)) goto L15;
        if (r2 == (-887328209)) goto L10;
        return "";
    L10:
        if (r3.equals(func_callConstants.RoleType_System) == true) goto L13;
        return "";
    L13:
        return Settings.System.getString(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r4);
    L15:
        if (r3.equals("secure") == true) goto L18;
        return "";
    L18:
        return Settings.Secure.getString(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r4);
    L20:
        if (r3.equals("global") == true) goto L24;
        return "";
    L24:
        return Settings.Global.getString(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), r4);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public String getSystemLocale() {
        String r1 = Locale.getDefault().toString();
        Intrinsics.checkNotNullExpressionValue(r1, "toString(...)");
        return r1;
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public int getTemperatureState() {
        if (powerManager != null) goto L9;
        Object r2 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("power");
        if (ZeusTransformUtils.instanceOf(r2, PowerManager.class) == false) goto L7;
        PowerManager r3 = (PowerManager) ZeusTransformUtils.preCheckCast(r2, PowerManager.class, "com.obric.memorydata.plugin");
    L8:
        powerManager = r3;
        goto L9
    L7:
        r3 = null;
    L9:
        PowerManager r4 = powerManager;
        if (r4 != null) goto L14;
        return -1;
    L14:
        return r4.getCurrentThermalStatus();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public String getUid() {
        return AppContext.INSTANCE.getUserId();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public boolean isAIKernelAvailable() {
        return DeviceInfoState.INSTANCE.isAIKernelAvailable();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public boolean isDebug() {
        return AppContext.INSTANCE.isDebug();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public boolean isObricOsDevice() {
        return DeviceInfoState.INSTANCE.isObricOsDevice();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public boolean isSupportVLM() {
        return DeviceInfoState.INSTANCE.isSupportVLM();
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public boolean isUTDataCollectEnabled() {
        if (AppContext.INSTANCE.isDebug() == false) goto L8;
        DataTransportManagerApi r4 = com.obric.memorydata.datatransport.api.c.a();
        if (r4 != null) goto L7;
        return false;
    L7:
        return r4.isUTDataCollectEnabled();
    L8:
        List<String> r5 = AppSettingsManager.INSTANCE.getRecommendSettings().getCollectDid();
        if (((CharSequence) ZeusTransformUtils.preCheckCast(AppContext.INSTANCE.getServerDeviceId(), CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L11;
        boolean r1 = true;
    L12:
        if (r1 == false) goto L15;
        return false;
    L15:
        if (r5.contains(AppContext.INSTANCE.getServerDeviceId()) == false) goto L24;
        DataTransportManagerApi r6 = com.obric.memorydata.datatransport.api.c.a();
        if (r6 == null) goto L19;
        boolean r7 = r6.isUTDataCollectEnabled();
    L20:
        if (r7 == true) goto L22;
        return false;
    L22:
        return true;
    L19:
        r7 = false;
        goto L20
    L24:
        return false;
    L11:
        r1 = false;
        goto L12
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public boolean isWorkDay(long r1) {
        return r.d(r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public void removeTask(String r3) {
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        RunLog.INSTANCE.debug(TAG, "remove task " + r3);
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().a(r3);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public void removeTaskIncludingScheduled(String r1) {
        Intrinsics.checkNotNullParameter(r1, ActivityLifecycle.NAME);
        com.obric.memorydata.task.scheduler.impl.c.f12961a.d().d(r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public void reportDevelopEvent(String r2, Map<String, ? extends Object> r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r1, TrackerImpl.PARAMS);
        Tracker.INSTANCE.reportDevEvent(r2, new JSONObject(r1));
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public void reportError(String r1) {
        Intrinsics.checkNotNullParameter(r1, NotificationCompat.CATEGORY_MESSAGE);
        Ensure.ensureNotReachHere(new Throwable(r1), r1);
    }

    @Override // com.obric.memorydata.middleware.api.bridge.ICoreBridgeAPI
    public void reportEvent(String r2, Map<String, ? extends Object> r3) {
        Map r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r1, TrackerImpl.PARAMS);
        Tracker.INSTANCE.reportEvent(r2, new JSONObject(r1));
    }
}
