package com.obric.memorydata.aikernelcore;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.Ensure;
import com.bytedance.crash.constants.Constants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.ToNumberStrategy;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.obric.aiagent.sharedstate.SharedState;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.core.log.ILog;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.phx.sdk.api.IBaseModel;
import com.obric.aikernel.res.update.UpdateResult;
import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.aikernel.sdk.ext.ParamsKt;
import com.obric.aikernel.sdk.response.Response;
import com.obric.aikernel.sdk.response.ResponseKt;
import com.obric.capabilitykit.AtomicCapabilitySdk;
import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.memorydata.aikernelcore.bridge.DatabaseBridge;
import com.obric.memorydata.aikernelcore.utils.DataConvert;
import com.obric.memorydata.init.tasks.pitaya.BridgeData;
import com.obric.memorydata.init.tasks.pitaya.BridgeResponse;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.utils.at;
import com.obric.memorydata.utils.u;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.flow.j;
import kotlinx.coroutines.i;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0086@¢\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0016\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0014J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0016\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0014J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0014J\u0016\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0014J\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0\u001eH\u0086@¢\u0006\u0002\u0010\u0011J<\u0010 \u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00052\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\r0%H\u0086@¢\u0006\u0002\u0010'J\u0016\u0010(\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u0018H\u0086@¢\u0006\u0002\u0010*J$\u0010+\u001a\u00020\r2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fJ\u001e\u00101\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0082@¢\u0006\u0002\u00103J\u001e\u00104\u001a\u00020&2\u0006\u00102\u001a\u00020\u00052\u0006\u00100\u001a\u00020&H\u0082@¢\u0006\u0002\u00105J\u0018\u00106\u001a\u00020\u00052\u0006\u00102\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0003J\u0018\u00107\u001a\u00020&2\u0006\u00102\u001a\u00020\u00052\u0006\u00100\u001a\u00020&H\u0003J \u00108\u001a\u00020&2\u0006\u00109\u001a\u00020\u00052\u0006\u0010!\u001a\u00020&2\u0006\u0010:\u001a\u00020&H\u0003J&\u0010;\u001a\u00020&2\u0006\u00109\u001a\u00020\u00052\u0006\u0010!\u001a\u00020&2\u0006\u0010:\u001a\u00020&H\u0082@¢\u0006\u0002\u0010<J\u0018\u0010G\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u00052\u0006\u0010H\u001a\u00020\u0005H\u0003J\u0012\u0010I\u001a\u0004\u0018\u00010\u00012\u0006\u0010J\u001a\u00020\u0005H\u0002J\u0012\u0010K\u001a\u0004\u0018\u00010\u00012\u0006\u0010L\u001a\u00020MH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010=\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bC\u0010D¨\u0006N"}, d2 = {"Lcom/obric/memorydata/aikernelcore/MemoryScriptEngineEnv;", "", "<init>", "()V", "TAG", "", "MEMORY_SERVICE_ID", "", "runtime", "Lcom/obric/aikernel/runtime/AIInferRuntime;", "getRuntime", "()Lcom/obric/aikernel/runtime/AIInferRuntime;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "getAllPackageConfigs", "", "Lcom/obric/aikernel/res/metadata/config/PackageConfig;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadPkg", "bizPkg", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPackageConfig", "pkg", "getPackageCustomConfig", "Lcom/google/gson/JsonObject;", "getPackageConfigDesc", "getPackage", "Lcom/obric/aikernel/sdk/data/PackageResource;", "updatePackage", "updateAll", "", "Lcom/obric/aikernel/res/update/UpdateResult;", "runPackage", TrackerImpl.PARAMS, "Lcom/obric/aikernel/sdk/config/RequestParams;", "event", "callback", "Lkotlin/Function1;", "Landroid/os/Bundle;", "(Ljava/lang/String;Lcom/obric/aikernel/sdk/config/RequestParams;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pushDebugInfo", "info", "(Lcom/google/gson/JsonObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dump", "fd", "Ljava/io/FileDescriptor;", "fout", "Ljava/io/PrintWriter;", "args", "runAikModel", "modelName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runAikModelBundle", "(Ljava/lang/String;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callAikernelModelStr", "callAikernelModelBundle", "callLoraModel", Params.LORA_TYPE, "imageInfo", "callLoraModelInternal", "(Ljava/lang/String;Landroid/os/Bundle;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "RESULT_UNKNOWN", "RESULT_SUCCESS", "MSG_SUCCESS", "MAX_RESPONSE_LOG_LENGTH", "gsonBuilder", "Lcom/google/gson/GsonBuilder;", "getGsonBuilder", "()Lcom/google/gson/GsonBuilder;", "gsonBuilder$delegate", "Lkotlin/Lazy;", "sendNativeMsg", "biz", "getObjInstance", "className", "executeBridge", "bridgeData", "Lcom/obric/memorydata/init/tasks/pitaya/BridgeData;", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryScriptEngineEnv {
    public static final MemoryScriptEngineEnv INSTANCE = null;
    private static final int MAX_RESPONSE_LOG_LENGTH = 300;
    private static final int MEMORY_SERVICE_ID = 2;
    private static final String MSG_SUCCESS = "success";
    private static final int RESULT_SUCCESS = 0;
    private static final int RESULT_UNKNOWN = 2;
    private static final String TAG = "MemoryScriptEngineEnv";
    private static final Lazy gsonBuilder$delegate = null;
    private static final AIInferRuntime runtime = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class a<T> implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Bundle f8443a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f8444b;

        a(Bundle r1, String r2) {
            this.f8443a = r1;
            this.f8444b = r2;
        }

        private static final Unit a(Bundle r1, String r2, boolean r3, Object r4, JSONObject r5) {
            Intrinsics.checkNotNullParameter(r5, WsConstants.KEY_EXTRA);
            if (r3 == false) goto L12;
            r1.putInt("code", 0);
            r1.putString(NotificationCompat.CATEGORY_MESSAGE, "success");
            RunLog.INSTANCE.debug(MemoryScriptEngineEnv.TAG, "call lora " + r2 + " with result: " + r4);
            if (ZeusTransformUtils.instanceOf(r4, String.class) == false) goto L8;
            String r6 = (String) ZeusTransformUtils.preCheckCast(r4, String.class, "com.obric.memorydata.plugin");
        L7:
            r1.putString("data", r6);
            goto L12
        L8:
            if (r4 == null) goto L10;
            r6 = u.a(r4);
            goto L7
        L10:
            r6 = null;
        L12:
            return Unit.INSTANCE;
        }

        private static final Unit a(String r9, Bundle r10, int r11, String r12, JSONObject r13) {
            Intrinsics.checkNotNullParameter(r12, "errInfo");
            Intrinsics.checkNotNullParameter(r13, WsConstants.KEY_EXTRA);
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), MemoryScriptEngineEnv.TAG, "call lora " + r9 + " with error: " + r11 + ": " + r12 + " : " + r13, null, 4, null);
            r10.putInt("code", r11);
            r10.putString(NotificationCompat.CATEGORY_MESSAGE, r9 + " 推理失败 " + r11 + ": " + r12 + " : " + r13);
            return Unit.INSTANCE;
        }

        public static /* synthetic */ Unit lambda$5XbTT0gfgpttsnokbj8rI0s3k70(Bundle r0, String r1, boolean r2, Object r3, JSONObject r4) {
            return a(r0, r1, r2, r3, r4);
        }

        public static /* synthetic */ Unit lambda$phbUvcviB2Zsgp9a2bGuMQcMmtg(String r0, Bundle r1, int r2, String r3, JSONObject r4) {
            return a(r0, r1, r2, r3, r4);
        }

        public final Object a(Response<Object> r3, Continuation<? super Unit> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            final Bundle r6 = this.f8443a;
            final String r0 = this.f8444b;
            Response r7 = ResponseKt.ok(r3, new $$Lambda$MemoryScriptEngineEnv$a$5XbTT0gfgpttsnokbj8rI0s3k70(r6, r0));
            final String r8 = this.f8444b;
            final Bundle r2 = this.f8443a;
            ResponseKt.fail(r7, new $$Lambda$MemoryScriptEngineEnv$a$phbUvcviB2Zsgp9a2bGuMQcMmtg(r8, r2));
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.flow.j
        public /* synthetic */ Object emit(Object r3, Continuation r4) {
            Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return a((Response) ZeusTransformUtils.preCheckCast(r3, Response.class, "com.obric.memorydata.plugin"), r5);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/aikernelcore/MemoryScriptEngineEnv$gsonBuilder$2$1$1", "Lcom/google/gson/ToNumberStrategy;", "readNumber", "", "in", "Lcom/google/gson/stream/JsonReader;", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements ToNumberStrategy {
        b() {
        }

        @Override // com.google.gson.ToNumberStrategy
        public Number readNumber(JsonReader r6) {
            Intrinsics.checkNotNullParameter(r6, "in");
            double r5 = r6.nextDouble();
            boolean r0 = true;
            if ((r5 % ((double) 1)) == 0.0d) goto L7;
            r0 = false;
        L7:
            if (r0 == false) goto L17;
            if ((-2.147483648E9d) <= r5) goto L11;
        L13:
            Object r7 = Long.valueOf((long) r5);
        L15:
            return (Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin");
        L11:
            if (r5 > 2.147483647E9d) goto L13;
            r7 = Integer.valueOf((int) r5);
            goto L15
        L17:
            return (Number) ZeusTransformUtils.preCheckCast(Double.valueOf(r5), Number.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/obric/memorydata/aikernelcore/MemoryScriptEngineEnv$runtime$2$2", "Lcom/obric/aikernel/runtime/AIInferRuntime$Callback;", "onVmGilHoldTooLong", "", "threadId", "", "threadName", "", "holdTimeMs", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements AIInferRuntime.b {
        c() {
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.b
        public Integer a(com.obric.aee.res.b r1, RequestParams r2, int r3) {
            return AIInferRuntime.b.a.a(this, r1, r2, r3);
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.b
        public Object a(Continuation<? super Unit> r3) {
            return AIInferRuntime.b.a.a(this, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.b
        public Pair<Integer, Bundle> a(com.obric.aee.res.b r1, RequestParams r2) {
            return AIInferRuntime.b.a.a(this, r1, r2);
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.b
        public void a() {
            AIInferRuntime.b.a.a(this);
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.b
        public void a(long r7, String r9, long r10) {
            Intrinsics.checkNotNullParameter(r9, "threadName");
            ((o) ZeusTransformUtils.preCheckCast(com.obric.memorydata.middleware.api.logging.u.f11636a, o.class, "com.obric.memorydata.plugin")).a("vm_gil_hold_too_long", "Python VM 的 GIL 持有超时，已释放 threadId=" + r7 + " holdTimeMs=" + r10, new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null), new com.obric.memorydata.middleware.api.logging.g().a());
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.b
        public void a(com.obric.aee.res.b r1) {
            AIInferRuntime.b.a.a(this, r1);
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.b
        public void a(RequestParams r1) {
            AIInferRuntime.b.a.a(this, r1);
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.b
        public void a(RequestParams r1, Bundle r2) {
            AIInferRuntime.b.a.a(this, r1, r2);
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.b
        public void a(String r1, int r2, String r3, String r4, com.obric.aee.res.b r5, String r6) {
            AIInferRuntime.b.a.a(this, r1, r2, r3, r4, r5, r6);
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.b
        public void a(String r1, String r2) {
            AIInferRuntime.b.a.a(this, r1, r2);
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.b
        public void a(List<Object> r3) {
            AIInferRuntime.b.a.a(this, (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.b
        public Object b(Continuation<? super Unit> r3) {
            return AIInferRuntime.b.a.b(this, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.b
        public void b() {
            AIInferRuntime.b.a.b(this);
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.b
        public void b(RequestParams r1) {
            AIInferRuntime.b.a.b(this, r1);
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.b
        public AIInferRuntime.e c() {
            return AIInferRuntime.b.a.c(this);
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.b
        public Object c(Continuation<? super Unit> r3) {
            return AIInferRuntime.b.a.c(this, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.obric.aikernel.runtime.AIInferRuntime.b
        public AIInferRuntime.i d() {
            return AIInferRuntime.b.a.d(this);
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$callAikernelModelBundle$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$callAikernelModelBundle$1", f = "MemoryScriptEngineEnv.kt", i = {}, l = {307}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Bundle>, Object> {
        final /* synthetic */ Bundle $args;
        final /* synthetic */ String $modelName;
        int label;

        /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$callAikernelModelBundle$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$callAikernelModelBundle$1$1", f = "MemoryScriptEngineEnv.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
        static final class C04211 extends SuspendLambda implements Function2<al, Continuation<? super Bundle>, Object> {
            final /* synthetic */ Bundle $args;
            final /* synthetic */ String $modelName;
            int label;

            C04211(String r3, Bundle r4, Continuation<? super C04211> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.$modelName = r3;
                this.$args = r4;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C04211(this.$modelName, this.$args, r5), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Bundle> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Bundle> r4) {
                return ((C04211) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C04211.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r7) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r7);
            L11:
                return r7;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r7);
                MemoryScriptEngineEnv r8 = MemoryScriptEngineEnv.INSTANCE;
                String r2 = this.$modelName;
                Bundle r3 = this.$args;
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.label = 1;
                r7 = MemoryScriptEngineEnv.access$runAikModelBundle(r8, r2, r3, r4);
                if (r7 != r0) goto L11;
                return r0;
            }
        }

        AnonymousClass1(String r3, Bundle r4, Continuation<? super AnonymousClass1> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$modelName = r3;
            this.$args = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.$modelName, this.$args, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Bundle> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Bundle> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C04211(this.$modelName, this.$args, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r8 = i.a(r9, r2, r3);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$callAikernelModelStr$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$callAikernelModelStr$1", f = "MemoryScriptEngineEnv.kt", i = {}, l = {297}, m = "invokeSuspend", n = {}, s = {})
    static final class C10931 extends SuspendLambda implements Function2<al, Continuation<? super String>, Object> {
        final /* synthetic */ String $args;
        final /* synthetic */ String $modelName;
        int label;

        /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$callAikernelModelStr$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$callAikernelModelStr$1$1", f = "MemoryScriptEngineEnv.kt", i = {}, l = {298}, m = "invokeSuspend", n = {}, s = {})
        static final class C04221 extends SuspendLambda implements Function2<al, Continuation<? super String>, Object> {
            final /* synthetic */ String $args;
            final /* synthetic */ String $modelName;
            int label;

            C04221(String r3, String r4, Continuation<? super C04221> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.$modelName = r3;
                this.$args = r4;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C04221(this.$modelName, this.$args, r5), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super String> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super String> r4) {
                return ((C04221) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C04221.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r7) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                ResultKt.throwOnFailure(r7);
            L11:
                return r7;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r7);
                MemoryScriptEngineEnv r8 = MemoryScriptEngineEnv.INSTANCE;
                String r2 = this.$modelName;
                String r3 = this.$args;
                Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
                this.label = 1;
                r7 = MemoryScriptEngineEnv.access$runAikModel(r8, r2, r3, r4);
                if (r7 != r0) goto L11;
                return r0;
            }
        }

        C10931(String r3, String r4, Continuation<? super C10931> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.$modelName = r3;
            this.$args = r4;
            super(2, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10931(this.$modelName, this.$args, r5), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super String> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super String> r4) {
            return ((C10931) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10931.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            CoroutineContext r9 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C04221(this.$modelName, this.$args, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r8 = i.a(r9, r2, r3);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$callLoraModel$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$callLoraModel$1", f = "MemoryScriptEngineEnv.kt", i = {}, l = {TypedValues.AttributesType.TYPE_EASING}, m = "invokeSuspend", n = {}, s = {})
    static final class C10941 extends SuspendLambda implements Function2<al, Continuation<? super Bundle>, Object> {
        final /* synthetic */ Bundle $imageInfo;
        final /* synthetic */ String $loraType;
        final /* synthetic */ Bundle $params;
        int label;

        /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$callLoraModel$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$callLoraModel$1$1", f = "MemoryScriptEngineEnv.kt", i = {0, 0}, l = {320}, m = "invokeSuspend", n = {"result", "start$iv"}, s = {"L$0", "J$0"})
        static final class C04231 extends SuspendLambda implements Function2<al, Continuation<? super Bundle>, Object> {
            final /* synthetic */ Bundle $imageInfo;
            final /* synthetic */ String $loraType;
            final /* synthetic */ Bundle $params;
            long J$0;
            Object L$0;
            Object L$1;
            int label;

            C04231(String r3, Bundle r4, Bundle r5, Continuation<? super C04231> r6) {
                Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
                this.$loraType = r3;
                this.$params = r4;
                this.$imageInfo = r5;
                super(2, r7);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C04231(this.$loraType, this.$params, this.$imageInfo, r6), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Bundle> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Bundle> r4) {
                return ((C04231) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C04231.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v1, types: [T, android.os.Bundle] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r10) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L8;
                if (r1 != 1) goto L7;
                long r2 = this.J$0;
                Ref.ObjectRef r3 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$1, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
                Ref.ObjectRef r4 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
                ResultKt.throwOnFailure(r10);
                T r11 = r10;
            L12:
                r3.element = r11;
                long r5 = System.currentTimeMillis() - r2;
                String r9 = this.$loraType;
                JSONObject r12 = new JSONObject();
                r12.put("lora_name", r9);
                r12.put("cost_time", r5);
                r12.put("errorCode", ((Bundle) ZeusTransformUtils.preCheckCast(r4.element, Bundle.class, "com.obric.memorydata.plugin")).getInt("code", -1));
                r12.put(DTraitConstant.ERROR, ((Bundle) ZeusTransformUtils.preCheckCast(r4.element, Bundle.class, "com.obric.memorydata.plugin")).getString(NotificationCompat.CATEGORY_MESSAGE, "fail"));
                Tracker.INSTANCE.reportEvent("lora_model_call", r12);
                return r4.element;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L8:
                ResultKt.throwOnFailure(r10);
                Ref.ObjectRef r13 = new Ref.ObjectRef();
                r13.element = new Bundle();
                String r6 = this.$loraType;
                Bundle r7 = this.$params;
                Bundle r8 = this.$imageInfo;
                long r14 = System.currentTimeMillis();
                MemoryScriptEngineEnv r15 = MemoryScriptEngineEnv.INSTANCE;
                this.L$0 = r13;
                this.L$1 = r13;
                this.J$0 = r14;
                this.label = 1;
                Object r16 = MemoryScriptEngineEnv.access$callLoraModelInternal(r15, r6, r7, r8, this);
                if (r16 != r0) goto L11;
                return r0;
            L11:
                r3 = r13;
                r4 = r3;
                r11 = r16;
                r2 = r14;
                goto L12
            }
        }

        C10941(String r3, Bundle r4, Bundle r5, Continuation<? super C10941> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.$loraType = r3;
            this.$params = r4;
            this.$imageInfo = r5;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10941(this.$loraType, this.$params, this.$imageInfo, r6), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Bundle> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Bundle> r4) {
            return ((C10941) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10941.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r9) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r9);
        L11:
            return r9;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r9);
            CoroutineContext r10 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r2 = (Function2) ZeusTransformUtils.preCheckCast(new C04231(this.$loraType, this.$params, this.$imageInfo, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.label = 1;
            r9 = i.a(r10, r2, r3);
            if (r9 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$callLoraModelInternal$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv", f = "MemoryScriptEngineEnv.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5}, l = {345, 355, 381, 396, 398, 411}, m = "callLoraModelInternal", n = {"this", Params.LORA_TYPE, TrackerImpl.PARAMS, "imageInfo", "ret", "modelPkg", "appendCommonParams", "loraPackage", "this", Params.LORA_TYPE, TrackerImpl.PARAMS, "imageInfo", "ret", "modelPkg", "appendCommonParams", "loraPackage", "this", Params.LORA_TYPE, TrackerImpl.PARAMS, "ret", "modelPkg", "appendCommonParams", "uri", "fd", "this", Params.LORA_TYPE, TrackerImpl.PARAMS, "ret", "uri", "fd", "this", Params.LORA_TYPE, "ret", "this", Params.LORA_TYPE, "ret"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
    static final class C10951 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MemoryScriptEngineEnv this$0;

        C10951(MemoryScriptEngineEnv r3, Continuation<? super C10951> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return MemoryScriptEngineEnv.access$callLoraModelInternal(this.this$0, null, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J2\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u000b"}, d2 = {"com/obric/memorydata/aikernelcore/MemoryScriptEngineEnv$runtime$3$1", "Lcom/obric/aikernel/runtime/AIKernelModelProxy;", "checkIsAvail", "", "type", "", ActivityLifecycle.NAME, "version", "requestParams", "Lcom/obric/aikernel/sdk/config/RequestParams;", Params.LORA_TYPE, "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d extends com.obric.aikernel.runtime.a {
        d() {
        }

        @Override // com.obric.aikernel.runtime.a, com.obric.aikernel.res.metadata.data.a.c
        public boolean a(String r3, String r4, String r5, RequestParams r6, String r7) {
            Intrinsics.checkNotNullParameter(r3, "type");
            Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r5, "version");
            Intrinsics.checkNotNullParameter(r6, "requestParams");
            if (Intrinsics.areEqual(r7, "embedding") == false) goto L8;
            if (DeviceInfoState.INSTANCE.isSupportVLMEmbedding() == true) goto L8;
            return true;
        L8:
            if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == true) goto L11;
            return true;
        L11:
            if (at.a(r7) == false) goto L16;
            if (DeviceInfoState.INSTANCE.isSupportVLM() == true) goto L16;
            return true;
        L16:
            return super.a(r3, r4, r5, r6, r7);
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000f"}, d2 = {"com/obric/memorydata/aikernelcore/MemoryScriptEngineEnv$runtime$3$aikernelLogger$1", "Lcom/obric/aikernel/core/log/ILog;", "d", "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "e", "t", "", "i", "isDebug", "", BaseSwitches.V, "w", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class e implements ILog {
        e() {
        }

        @Override // com.obric.aikernel.core.log.ILog
        public void d(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            RunLog.INSTANCE.debug(r1, r2);
        }

        @Override // com.obric.aikernel.core.log.ILog
        public void e(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r8, NotificationCompat.CATEGORY_MESSAGE);
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r7, r8, null, 4, null);
        }

        @Override // com.obric.aikernel.core.log.ILog
        public void e(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(r3, "t");
            RunLog.INSTANCE.error(r1, r2, r3);
        }

        @Override // com.obric.aikernel.core.log.ILog
        public void i(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r8, NotificationCompat.CATEGORY_MESSAGE);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r7, r8, false, 4, null);
        }

        @Override // com.obric.aikernel.core.log.ILog
        public boolean isDebug() {
            return AppContext.INSTANCE.isDebug();
        }

        @Override // com.obric.aikernel.core.log.ILog
        public void v(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            RunLog.INSTANCE.debug(r1, r2);
        }

        @Override // com.obric.aikernel.core.log.ILog
        public void w(String r7, String r8) {
            Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r8, NotificationCompat.CATEGORY_MESSAGE);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), r7, r8, null, 4, null);
        }

        @Override // com.obric.aikernel.core.log.ILog
        public void w(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(r3, "t");
            RunLog.INSTANCE.warn(r1, r2, r3);
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$executeBridge$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$executeBridge$1", f = "MemoryScriptEngineEnv.kt", i = {0}, l = {515}, m = "invokeSuspend", n = {"result"}, s = {"L$0"})
    static final class C10961 extends SuspendLambda implements Function2<al, Continuation<? super Object>, Object> {
        final /* synthetic */ BridgeData $bridgeData;
        Object L$0;
        int label;

        /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$executeBridge$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
        @DebugMetadata(c = "com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$executeBridge$1$1", f = "MemoryScriptEngineEnv.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        static final class C04241 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
            final /* synthetic */ BridgeData $bridgeData;
            final /* synthetic */ Ref.ObjectRef<Object> $result;
            int label;

            C04241(Ref.ObjectRef<Object> r3, BridgeData r4, Continuation<? super C04241> r5) {
                Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
                this.$result = r3;
                this.$bridgeData = r4;
                super(2, r6);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
                Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
                return (Continuation) ZeusTransformUtils.preCheckCast(new C04241(this.$result, this.$bridgeData, r5), Continuation.class, "com.obric.memorydata.plugin");
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
                return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(al r3, Continuation<? super Unit> r4) {
                return ((C04241) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C04241.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Type inference failed for: r1v3, types: [T, java.lang.Object] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r2) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L7;
                ResultKt.throwOnFailure(r2);
                Ref.ObjectRef<Object> r3 = this.$result;
                r3.element = com.obric.memorydata.aikernelcore.b.f8455a.a(this.$bridgeData);
                return Unit.INSTANCE;
            L7:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        C10961(BridgeData r3, Continuation<? super C10961> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$bridgeData = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new C10961(this.$bridgeData, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Object> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<Object> r4) {
            return ((C10961) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), C10961.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            Ref.ObjectRef r7 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r8);
        L13:
            return r7.element;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            Ref.ObjectRef r9 = new Ref.ObjectRef();
            CoroutineContext r2 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
            Function2 r4 = (Function2) ZeusTransformUtils.preCheckCast(new C04241(r9, this.$bridgeData, null), Function2.class, "com.obric.memorydata.plugin");
            Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
            this.L$0 = r9;
            this.label = 1;
            if (i.a(r2, r4, r3) != r0) goto L11;
            return r0;
        L11:
            r7 = r9;
            goto L13
        }
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/obric/memorydata/aikernelcore/MemoryScriptEngineEnv$sendNativeMsg$typeToken$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/obric/memorydata/init/tasks/pitaya/BridgeData;", "aikernel_core_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f extends TypeToken<BridgeData> {
        f() {
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$getPackageConfigDesc$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv", f = "MemoryScriptEngineEnv.kt", i = {0}, l = {210}, m = "getPackageConfigDesc", n = {"pkg"}, s = {"L$0"})
    static final class C10971 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MemoryScriptEngineEnv this$0;

        C10971(MemoryScriptEngineEnv r3, Continuation<? super C10971> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getPackageConfigDesc(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$getPackageCustomConfig$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv", f = "MemoryScriptEngineEnv.kt", i = {}, l = {Constants.UPLOAD_HTTP_ERROR}, m = "getPackageCustomConfig", n = {}, s = {})
    static final class C10981 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MemoryScriptEngineEnv this$0;

        C10981(MemoryScriptEngineEnv r3, Continuation<? super C10981> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.getPackageCustomConfig(null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$runAikModel$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv", f = "MemoryScriptEngineEnv.kt", i = {0}, l = {252, 253}, m = "runAikModel", n = {"args"}, s = {"L$0"})
    static final class C10991 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MemoryScriptEngineEnv this$0;

        C10991(MemoryScriptEngineEnv r3, Continuation<? super C10991> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return MemoryScriptEngineEnv.access$runAikModel(this.this$0, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv$runAikModelBundle$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.aikernelcore.MemoryScriptEngineEnv", f = "MemoryScriptEngineEnv.kt", i = {0, 0, 1}, l = {265, 269}, m = "runAikModelBundle", n = {"modelName", "args", "modelName"}, s = {"L$0", "L$1", "L$0"})
    static final class C11001 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ MemoryScriptEngineEnv this$0;

        C11001(MemoryScriptEngineEnv r3, Continuation<? super C11001> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.this$0 = r3;
            super(r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            this.result = r3;
            this.label |= Integer.MIN_VALUE;
            return MemoryScriptEngineEnv.access$runAikModelBundle(this.this$0, null, null, (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        MemoryScriptEngineEnv r0 = new MemoryScriptEngineEnv();
        INSTANCE = r0;
        com.obric.aikernel.runtime.d r1 = new com.obric.aikernel.runtime.d((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), String.valueOf(AppContext.INSTANCE.getAid()), "542488", AppContext.INSTANCE.getPluginVersionName(), AppContext.INSTANCE.getChannel(), (Function1) ZeusTransformUtils.preCheckCast(new MemoryScriptEngineEnv$runtime$1(null), Function1.class, "com.obric.memorydata.plugin"), "4.0.0", false, true, 128, null);
        r1.a($$Lambda$MemoryScriptEngineEnv$rH0i29YHIlHWeN3qXLu5CrVCNyQ.INSTANCE);
        r1.b(com.obric.aikernel.runtime.d.f6193a.b());
        r1.a("prs");
        r1.a(AppContext.INSTANCE.isDebug());
        r1.a((com.obric.aikernel.runtime.utils.c) ZeusTransformUtils.preCheckCast(new g(), com.obric.aikernel.runtime.utils.c.class, "com.obric.memorydata.plugin"));
        r1.a((AIInferRuntime.b) ZeusTransformUtils.preCheckCast(new c(), AIInferRuntime.b.class, "com.obric.memorydata.plugin"));
        r1.b($$Lambda$MemoryScriptEngineEnv$O3dEPsx1TTbhPvaFc7j_fAiLBNQ.INSTANCE);
        r1.a(CollectionsKt.listOf(new Pair[]{TuplesKt.to("ScriptEngine", r0), TuplesKt.to("DatabaseBridge", DatabaseBridge.INSTANCE), TuplesKt.to("DataConvert", DataConvert.INSTANCE)}));
        Map r2 = MapsKt.createMapBuilder();
        r2.put("autoclose_mode", "1");
        r2.put("autoclose_service_timeout", "300");
        r2.put("autoclose_whitelist", "");
        if (AppContext.INSTANCE.isDebug() == false) goto L5;
    L6:
        r2.put("log_level", "debug");
    L8:
        if (AppContext.INSTANCE.isLocalTest() == false) goto L10;
        r2.put("tracing_memory", "1");
    L10:
        r1.a(MapsKt.build(r2));
        AIInferRuntime.d r3 = r1.a();
        r3.g().setDynamicResProxy(com.obric.aikernel.runtime.a.C0275a.a(com.obric.aikernel.runtime.a.f6185a, r3, new AIKernelConfig.Builder((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).appId(AppContext.INSTANCE.getAid()).packageName(AppContext.INSTANCE.getPackageName()).build(), (ILog) ZeusTransformUtils.preCheckCast(new e(), ILog.class, "com.obric.memorydata.plugin"), (com.obric.aikernel.runtime.a) ZeusTransformUtils.preCheckCast(new d(), com.obric.aikernel.runtime.a.class, "com.obric.memorydata.plugin"), null, 16, null));
        runtime = new AIInferRuntime(r3);
        gsonBuilder$delegate = LazyKt.lazy($$Lambda$MemoryScriptEngineEnv$RNYDw2CiGd9ck2MayW4KpCY92k.INSTANCE);
        return;
    L5:
        if (AppContext.INSTANCE.isLocalTest() == false) goto L8;
        goto L6
    }

    private MemoryScriptEngineEnv() {
    }

    public static final /* synthetic */ Object access$callLoraModelInternal(MemoryScriptEngineEnv r2, String r3, Bundle r4, Bundle r5, Continuation r6) {
        return r2.callLoraModelInternal(r3, r4, r5, (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$runAikModel(MemoryScriptEngineEnv r2, String r3, String r4, Continuation r5) {
        return r2.runAikModel(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object access$runAikModelBundle(MemoryScriptEngineEnv r2, String r3, Bundle r4, Continuation r5) {
        return r2.runAikModelBundle(r3, r4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @com.obric.aee.utils.a
    private final Bundle callAikernelModelBundle(String r2, Bundle r3) {
        return (Bundle) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r2, r3, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), Bundle.class, "com.obric.memorydata.plugin");
    }

    @com.obric.aee.utils.a
    private final String callAikernelModelStr(String r2, String r3) {
        return (String) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new C10931(r2, r3, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), String.class, "com.obric.memorydata.plugin");
    }

    @com.obric.aee.utils.a
    private final Bundle callLoraModel(String r2, Bundle r3, Bundle r4) {
        return (Bundle) ZeusTransformUtils.preCheckCast(i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new C10941(r2, r3, r4, null), Function2.class, "com.obric.memorydata.plugin"), 1, null), Bundle.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v18, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v26, types: [T, android.content.res.AssetFileDescriptor] */
    /* JADX WARN: Type inference failed for: r3v22, types: [T, java.lang.String] */
    private final Object callLoraModelInternal(String r28, Bundle r29, Bundle r30, Continuation<? super Bundle> r31) {
        final String r1 = r28;
        Class<MemoryScriptEngineEnv> r2 = MemoryScriptEngineEnv.class;
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r31, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, C10951.class) == false) goto L7;
        C10951 r5 = (C10951) ZeusTransformUtils.preCheckCast(r3, C10951.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r13 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r14 = "lora ";
        String r11 = "code";
        switch(r5.label) {
            case 0: goto L18;
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            default: goto L11;
        };
    L12:
        Bundle r0 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$2, Bundle.class, "com.obric.memorydata.plugin");
        String r6 = (String) ZeusTransformUtils.preCheckCast(r5.L$1, String.class, "com.obric.memorydata.plugin");
        MemoryScriptEngineEnv r7 = (MemoryScriptEngineEnv) ZeusTransformUtils.preCheckCast(r5.L$0, r2, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        return r0;
    L13:
        Bundle r8 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$2, Bundle.class, "com.obric.memorydata.plugin");
        String r9 = (String) ZeusTransformUtils.preCheckCast(r5.L$1, String.class, "com.obric.memorydata.plugin");
        MemoryScriptEngineEnv r10 = (MemoryScriptEngineEnv) ZeusTransformUtils.preCheckCast(r5.L$0, r2, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        r2 = r2;
        Object r12 = r4;
        String r25 = "code";
        r14 = "lora ";
        String r15 = NotificationCompat.CATEGORY_MESSAGE;
        String r16 = "com.obric.memorydata.plugin";
        Bundle r17 = r8;
        int r18 = -1;
    L105:
        kotlinx.coroutines.flow.i r19 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r12, kotlinx.coroutines.flow.i.class, r16);
        if (r19 == null) goto L110;
        j r20 = (j) ZeusTransformUtils.preCheckCast(new a(r17, r9), j.class, r16);
        r5.L$0 = r10;
        r5.L$1 = r9;
        r5.L$2 = r17;
        r5.label = 6;
        if (r19.collect(r20, r5) != r13) goto L113;
        return r13;
    L113:
        return r17;
    L110:
        final String r21 = r9;
        MemoryScriptEngineEnv r110 = r10;
    L111:
        MemoryScriptEngineEnv r22 = (MemoryScriptEngineEnv) ZeusTransformUtils.preCheckCast(r110, r2, r16);
        r17.putInt(r25, r18);
        r17.putString(r15, r14 + r21 + " 推理异常");
        goto L113
    L14:
        Ref.ObjectRef r23 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$5, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r24 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$4, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Bundle r26 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$3, Bundle.class, "com.obric.memorydata.plugin");
        final Bundle r27 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$2, Bundle.class, "com.obric.memorydata.plugin");
        r21 = (String) ZeusTransformUtils.preCheckCast(r5.L$1, String.class, "com.obric.memorydata.plugin");
        r110 = (MemoryScriptEngineEnv) ZeusTransformUtils.preCheckCast(r5.L$0, r2, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        r2 = r2;
        r25 = "code";
        r14 = "lora ";
        final Ref.ObjectRef r32 = r24;
        r16 = "com.obric.memorydata.plugin";
        r17 = r26;
        final Ref.ObjectRef r33 = r23;
        Object r34 = r4;
        r15 = NotificationCompat.CATEGORY_MESSAGE;
        r18 = -1;
    L99:
        IBaseModel r35 = (IBaseModel) ZeusTransformUtils.preCheckCast(r34, IBaseModel.class, r16);
        if (r35 == null) goto L111;
        RequestParams r36 = new RequestParams(null, new $$Lambda$MemoryScriptEngineEnv$JBscH3SrOpfCOHS0jyehttrAmFw(r32, r33, r21, r27), 1, null);
        r5.L$0 = r110;
        r5.L$1 = r21;
        r5.L$2 = r17;
        r5.L$3 = null;
        r5.L$4 = null;
        r5.L$5 = null;
        r5.label = 5;
        Object r37 = r35.inferAsFlow(r36, r5);
        if (r37 != r13) goto L104;
        return r13;
    L104:
        r12 = r37;
        r9 = r21;
        r10 = r110;
        goto L105
    L15:
        Ref.ObjectRef r38 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$7, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r39 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$6, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        final Function1 r40 = (Function1) ZeusTransformUtils.preCheckCast(r5.L$5, Function1.class, "com.obric.memorydata.plugin");
        String r41 = (String) ZeusTransformUtils.preCheckCast(r5.L$4, String.class, "com.obric.memorydata.plugin");
        Bundle r42 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$3, Bundle.class, "com.obric.memorydata.plugin");
        Bundle r43 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$2, Bundle.class, "com.obric.memorydata.plugin");
        String r111 = (String) ZeusTransformUtils.preCheckCast(r5.L$1, String.class, "com.obric.memorydata.plugin");
        MemoryScriptEngineEnv r112 = (MemoryScriptEngineEnv) ZeusTransformUtils.preCheckCast(r5.L$0, r2, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        r2 = r2;
        r14 = "lora ";
        String r210 = NotificationCompat.CATEGORY_MESSAGE;
        r16 = "com.obric.memorydata.plugin";
    L85:
        UriFileAccessSession r44 = (UriFileAccessSession) ZeusTransformUtils.preCheckCast(r4, UriFileAccessSession.class, r16);
        if (r44.getFd() != null) goto L89;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, r16), TAG, "openFileDescriptorPrivileged " + ((String) ZeusTransformUtils.preCheckCast(r39.element, String.class, r16)) + " failed " + r44, null, 4, null);
        r42.putInt(r11, -1);
        r42.putString(r210, "openFileDescriptorPrivileged " + ((String) ZeusTransformUtils.preCheckCast(r39.element, String.class, r16)) + " failed " + r44);
        return r42;
    L89:
        r15 = r210;
        r38.element = r44.getFd();
        r32 = r39;
        r17 = r42;
        Bundle r113 = r43;
        r1 = r111;
    L95:
        IAIKernelManager r45 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, r16);
        RequestParams r114 = new RequestParams(null, new $$Lambda$MemoryScriptEngineEnv$Pl4ZjrevWZ6HG8hNAqQZ68RDfE(r40), 1, null);
        r5.L$0 = r112;
        r5.L$1 = r1;
        r5.L$2 = r113;
        r5.L$3 = r17;
        r5.L$4 = r32;
        r5.L$5 = r38;
        r5.L$6 = null;
        r5.L$7 = null;
        r5.L$8 = null;
        r5.label = 4;
        r25 = r11;
        Ref.ObjectRef r115 = r38;
        MemoryScriptEngineEnv r116 = r112;
        r18 = -1;
        r34 = IAIKernelManager.DefaultImpls.loadPackage$default(r45, r41, false, r114, r5, 2, null);
        if (r34 != r13) goto L98;
        return r13;
    L98:
        r21 = r1;
        r27 = r113;
        r110 = r116;
        r33 = r115;
        goto L99
    L16:
        Ref.ObjectRef r46 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$8, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r47 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$7, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r40 = (Function1) ZeusTransformUtils.preCheckCast(r5.L$6, Function1.class, "com.obric.memorydata.plugin");
        String r48 = (String) ZeusTransformUtils.preCheckCast(r5.L$5, String.class, "com.obric.memorydata.plugin");
        Bundle r117 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$4, Bundle.class, "com.obric.memorydata.plugin");
        Bundle r49 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$3, Bundle.class, "com.obric.memorydata.plugin");
        Bundle r50 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$2, Bundle.class, "com.obric.memorydata.plugin");
        String r51 = (String) ZeusTransformUtils.preCheckCast(r5.L$1, String.class, "com.obric.memorydata.plugin");
        r112 = (MemoryScriptEngineEnv) ZeusTransformUtils.preCheckCast(r5.L$0, r2, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        Object r52 = ((Result) ZeusTransformUtils.preCheckCast(r4, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
        r2 = r2;
        String r53 = r48;
        r14 = "lora ";
        Ref.ObjectRef r54 = r46;
        Bundle r55 = r49;
        Ref.ObjectRef r56 = r47;
        r1 = r51;
    L39:
        boolean r57 = Result.m1427isFailureimpl(r52);
        T r58 = r52;
        if (r57 == false) goto L42;
        r58 = 0;
    L42:
        r16 = "com.obric.memorydata.plugin";
        PackageResource r59 = (PackageResource) ZeusTransformUtils.preCheckCast(r58, PackageResource.class, r16);
        if (r59 != null) goto L45;
    L47:
        boolean r60 = false;
    L48:
        if (r60 == true) goto L51;
        r117.putInt("code", -1);
        r117.putString(NotificationCompat.CATEGORY_MESSAGE, "Lora更新失败 " + r56.element);
        return r117;
    L51:
        r11 = r11;
        r54.element = r58;
        Bundle r211 = r50;
        r41 = r53;
        Bundle r61 = r211;
    L53:
        PackageResource r62 = (PackageResource) ZeusTransformUtils.preCheckCast(r56.element, PackageResource.class, r16);
        if (r62 != null) goto L56;
    L58:
        boolean r63 = false;
    L59:
        if (r63 == false) goto L114;
        Ref.ObjectRef r64 = new Ref.ObjectRef();
        r64.element = r55.getString("image_uri");
        String r65 = r55.getString("image_source_pkg");
        r210 = r15;
        RunLog.INSTANCE.debug(TAG, "callLoraModelInternal uri = " + ((String) ZeusTransformUtils.preCheckCast(r64.element, String.class, r16)) + ", sourcePkg = " + r65);
        Ref.ObjectRef r66 = new Ref.ObjectRef();
        CharSequence r67 = (CharSequence) ZeusTransformUtils.preCheckCast(r64.element, CharSequence.class, r16);
        if (r67 != null) goto L63;
    L66:
        boolean r68 = true;
    L67:
        if (r68 == true) goto L93;
        CharSequence r69 = (CharSequence) ZeusTransformUtils.preCheckCast(r65, CharSequence.class, r16);
        if (r69 != null) goto L71;
    L74:
        boolean r70 = true;
    L75:
        if (r70 == false) goto L77;
    L90:
        r15 = r210;
        Bundle r118 = r61;
        Ref.ObjectRef r212 = r66;
        if (StringsKt.startsWith$default((String) ZeusTransformUtils.preCheckCast(r64.element, String.class, r16), "/", false, 2, null) == false) goto L94;
        r64.element = ZeusTransformUtils.getUriForFile((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), r16), Context.class, r16), "com.obric.memorydata.fileprovider", new File((String) ZeusTransformUtils.preCheckCast(r64.element, String.class, r16)), r16).toString();
    L94:
        r32 = r64;
        r17 = r117;
        r113 = r118;
        r38 = r212;
        goto L95
    L77:
        if (Intrinsics.areEqual(r65, com.obric.memorydata.BuildConfig.LIBRARY_PACKAGE_NAME) == true) goto L90;
        if (Intrinsics.areEqual(r65, "com.larus.nova") == true) goto L90;
        AtomicCapabilitySdk r71 = AtomicCapabilitySdk.INSTANCE;
        Uri r72 = Uri.parse((String) ZeusTransformUtils.preCheckCast(r64.element, String.class, r16));
        r5.L$0 = r112;
        r5.L$1 = r1;
        r5.L$2 = r61;
        r5.L$3 = r117;
        r5.L$4 = r41;
        r5.L$5 = r40;
        r5.L$6 = r64;
        r5.L$7 = r66;
        r5.L$8 = null;
        r5.label = 3;
        r4 = r71.openFileDescriptorPrivileged(r65, r72, r5);
        if (r4 != r13) goto L84;
        return r13;
    L84:
        r43 = r61;
        r42 = r117;
        r111 = r1;
        r39 = r64;
        r38 = r66;
        goto L85
    L71:
        if (r69.length() == 0) goto L74;
        r70 = false;
        goto L75
    L93:
        r118 = r61;
        r212 = r66;
        r15 = r210;
        goto L94
    L63:
        if (r67.length() == 0) goto L66;
        r68 = false;
        goto L67
    L114:
        r117.putInt(r11, -1);
        r117.putString(NotificationCompat.CATEGORY_MESSAGE, new StringBuilder().append(r14).append(r1).append(" 不可用").toString());
        return r117;
    L56:
        if (r62.isAvailable() != true) goto L58;
        r63 = true;
        goto L59
    L45:
        if (r59.isAvailable() != true) goto L47;
        r60 = true;
        goto L48
    L17:
        Ref.ObjectRef r73 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$8, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r74 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(r5.L$7, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        r40 = (Function1) ZeusTransformUtils.preCheckCast(r5.L$6, Function1.class, "com.obric.memorydata.plugin");
        r41 = (String) ZeusTransformUtils.preCheckCast(r5.L$5, String.class, "com.obric.memorydata.plugin");
        Bundle r75 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$4, Bundle.class, "com.obric.memorydata.plugin");
        r55 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$3, Bundle.class, "com.obric.memorydata.plugin");
        Bundle r119 = (Bundle) ZeusTransformUtils.preCheckCast(r5.L$2, Bundle.class, "com.obric.memorydata.plugin");
        String r76 = (String) ZeusTransformUtils.preCheckCast(r5.L$1, String.class, "com.obric.memorydata.plugin");
        r112 = (MemoryScriptEngineEnv) ZeusTransformUtils.preCheckCast(r5.L$0, r2, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        Object r77 = ((Result) ZeusTransformUtils.preCheckCast(r4, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();
        r61 = r119;
        Ref.ObjectRef r78 = r73;
        r117 = r75;
        r56 = r74;
        r1 = r76;
    L26:
        boolean r120 = Result.m1427isFailureimpl(r77);
        T r79 = r77;
        if (r120 == false) goto L29;
        r79 = 0;
    L29:
        r78.element = r79;
        if (r56.element != 0) goto L34;
        r117.putInt("code", -1);
        r117.putString(NotificationCompat.CATEGORY_MESSAGE, "获取算法包 " + r1 + " 失败！");
        return r117;
    L34:
        if (((PackageResource) ZeusTransformUtils.preCheckCast(r56.element, PackageResource.class, "com.obric.memorydata.plugin")).isDownloaded() == true) goto L52;
        AIKernelManager r80 = AIKernelManager.INSTANCE;
        PackageResource r81 = (PackageResource) ZeusTransformUtils.preCheckCast(r56.element, PackageResource.class, "com.obric.memorydata.plugin");
        RequestParams r121 = new RequestParams(null, new $$Lambda$MemoryScriptEngineEnv$HSe3ZkOfqTBg9CdlsYMYcm4FcVg(r40), 1, null);
        r5.L$0 = r112;
        r5.L$1 = r1;
        r5.L$2 = r61;
        r5.L$3 = r55;
        r5.L$4 = r117;
        r5.L$5 = r41;
        r5.L$6 = r40;
        r5.L$7 = r56;
        r5.L$8 = r56;
        r5.label = 2;
        Object r82 = r80.mo189updatePackage0E7RQCE(r81, r121, r5);
        if (r82 != r13) goto L38;
        return r13;
    L38:
        r52 = r82;
        r54 = r56;
        String r213 = r41;
        r50 = r61;
        r53 = r213;
        goto L39
    L52:
        r16 = "com.obric.memorydata.plugin";
        goto L53
    L18:
        ResultKt.throwOnFailure(r4);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == true) goto L21;
    L116:
        Ensure.ensureNotReachHere("callLoraModelInternal called when AIKernel not available");
        throw new RuntimeException("callLoraModelInternal called when AIKernel not available");
    L21:
        if (DeviceInfoState.INSTANCE.isSupportVLM() == false) goto L116;
        Bundle r83 = new Bundle();
        final Function1 r84 = new $$Lambda$MemoryScriptEngineEnv$_h1CEGCT85LpyH0hWVqDTHsOHM(r1);
        r56 = new Ref.ObjectRef();
        AIKernelManager r85 = AIKernelManager.INSTANCE;
        RequestParams r122 = new RequestParams(null, new $$Lambda$MemoryScriptEngineEnv$Lu4Kl8jgL5RHNiYMOExAEaB5HxA(r84), 1, null);
        r5.L$0 = this;
        r5.L$1 = r1;
        r61 = r29;
        r5.L$2 = r61;
        r5.L$3 = r30;
        r5.L$4 = r83;
        r5.L$5 = "vlm_local";
        r5.L$6 = r84;
        r5.L$7 = r56;
        r5.L$8 = r56;
        r5.label = 1;
        Object r86 = r85.mo188getPackage0E7RQCE("vlm_local", r122, r5);
        if (r86 != r13) goto L25;
        return r13;
    L25:
        r117 = r83;
        r77 = r86;
        r55 = r30;
        r112 = this;
        r78 = r56;
        r41 = "vlm_local";
        r40 = r84;
        goto L26
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L7:
        r5 = new C10951(this, r3);
        goto L8
    }

    private static final Unit callLoraModelInternal$lambda$10(Function1 r2, RequestParams r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "$this$RequestParams");
        r4.invoke(r3);
        return Unit.INSTANCE;
    }

    private static final Unit callLoraModelInternal$lambda$11(Function1 r2, RequestParams r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "$this$RequestParams");
        r4.invoke(r3);
        return Unit.INSTANCE;
    }

    private static final Unit callLoraModelInternal$lambda$13(Function1 r2, RequestParams r3) {
        Function1 r4 = (Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "$this$RequestParams");
        r4.invoke(r3);
        return Unit.INSTANCE;
    }

    private static final Unit callLoraModelInternal$lambda$15(Ref.ObjectRef r3, Ref.ObjectRef r4, String r5, final Bundle r6, RequestParams r7) {
        Intrinsics.checkNotNullParameter(r7, "$this$RequestParams");
        ParamsKt.setCustomArgs(r7, new $$Lambda$MemoryScriptEngineEnv$63FQRxx_uyN34E_f5pVXr29Frag(r6));
        if (r3.element != 0) goto L5;
    L8:
        RunLog.INSTANCE.debug(TAG, "call lora " + r5 + " with params: " + BundleExtKt.bundle2json(r7.getBackend()));
        return Unit.INSTANCE;
    L5:
        if (r4.element == 0) goto L7;
        ParamsKt.setAssetFd(r7, (String) ZeusTransformUtils.preCheckCast(r3.element, String.class, "com.obric.memorydata.plugin"), (AssetFileDescriptor) ZeusTransformUtils.preCheckCast(r4.element, AssetFileDescriptor.class, "com.obric.memorydata.plugin"));
        goto L8
    L7:
        ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).grantUriPermission("com.obric.aikernel", Uri.parse((String) ZeusTransformUtils.preCheckCast(r3.element, String.class, "com.obric.memorydata.plugin")), 1);
        ParamsKt.setFilePath(r7, (String) ZeusTransformUtils.preCheckCast(r3.element, String.class, "com.obric.memorydata.plugin"));
        goto L8
    }

    private static final Unit callLoraModelInternal$lambda$15$lambda$14(Bundle r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$setCustomArgs");
        r2.putAll(r1);
        return Unit.INSTANCE;
    }

    private static final Unit callLoraModelInternal$lambda$9(String r0, RequestParams r1) {
        ParamsKt.setLora(r1, r0);
        return Unit.INSTANCE;
    }

    private final Object executeBridge(BridgeData r3) {
        return i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new C10961(r3, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
    }

    private final GsonBuilder getGsonBuilder() {
        return (GsonBuilder) ZeusTransformUtils.preCheckCast(gsonBuilder$delegate.getValue(), GsonBuilder.class, "com.obric.memorydata.plugin");
    }

    private final Object getObjInstance(String r1) {
        return ZeusTransformUtils.forName(r1, "com.obric.memorydata.plugin").getField("INSTANCE").get(null);
    }

    private static final GsonBuilder gsonBuilder_delegate$lambda$18() {
        GsonBuilder r0 = new GsonBuilder();
        r0.setObjectToNumberStrategy((ToNumberStrategy) ZeusTransformUtils.preCheckCast(new b(), ToNumberStrategy.class, "com.obric.memorydata.plugin"));
        return r0;
    }

    /* JADX INFO: renamed from: lambda$2qmrK_e1LRghTKguPZWTCFwoa-4, reason: not valid java name */
    public static /* synthetic */ Unit m453lambda$2qmrK_e1LRghTKguPZWTCFwoa4(String r0, Bundle r1) {
        return preloadPkg$lambda$5(r0, r1);
    }

    public static /* synthetic */ Unit lambda$63FQRxx_uyN34E_f5pVXr29Frag(Bundle r0, Bundle r1) {
        return callLoraModelInternal$lambda$15$lambda$14(r0, r1);
    }

    public static /* synthetic */ Unit lambda$HSe3ZkOfqTBg9CdlsYMYcm4FcVg(Function1 r0, RequestParams r1) {
        return callLoraModelInternal$lambda$11(r0, r1);
    }

    public static /* synthetic */ Unit lambda$JBscH3SrOpfCOHS0jyehttrAmFw(Ref.ObjectRef r0, Ref.ObjectRef r1, String r2, Bundle r3, RequestParams r4) {
        return callLoraModelInternal$lambda$15(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit lambda$Lu4Kl8jgL5RHNiYMOExAEaB5HxA(Function1 r0, RequestParams r1) {
        return callLoraModelInternal$lambda$10(r0, r1);
    }

    public static /* synthetic */ boolean lambda$O3dEPsx1TTbhPvaFc7j_fAiLBNQ() {
        return runtime$lambda$3$lambda$1();
    }

    /* JADX INFO: renamed from: lambda$Pl4ZjrevWZ6HG-8hNAqQZ68RDfE, reason: not valid java name */
    public static /* synthetic */ Unit m454lambda$Pl4ZjrevWZ6HG8hNAqQZ68RDfE(Function1 r0, RequestParams r1) {
        return callLoraModelInternal$lambda$13(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$RNYDw2CiGd9ck2MayW-4KpCY92k, reason: not valid java name */
    public static /* synthetic */ GsonBuilder m455lambda$RNYDw2CiGd9ck2MayW4KpCY92k() {
        return gsonBuilder_delegate$lambda$18();
    }

    /* JADX INFO: renamed from: lambda$_h1CEGCT85LpyH0hWVq-DTHsOHM, reason: not valid java name */
    public static /* synthetic */ Unit m456lambda$_h1CEGCT85LpyH0hWVqDTHsOHM(String r0, RequestParams r1) {
        return callLoraModelInternal$lambda$9(r0, r1);
    }

    public static /* synthetic */ Unit lambda$aRCI_UwwtvKPAeoD9ZVCTVsf03M(Throwable r0) {
        return sendNativeMsg$lambda$19(r0);
    }

    /* JADX INFO: renamed from: lambda$kN3p9-bkFbpqnAGqCScFOTv4FCM, reason: not valid java name */
    public static /* synthetic */ Unit m457lambda$kN3p9bkFbpqnAGqCScFOTv4FCM(String r0, Bundle r1) {
        return runAikModel$lambda$7$lambda$6(r0, r1);
    }

    public static /* synthetic */ int lambda$rH0i29YHIlHWeN3qXLu5CrVCNyQ() {
        return runtime$lambda$3$lambda$0();
    }

    /* JADX INFO: renamed from: lambda$sSG8bhNDJm2XFW5k7-zkEENkais, reason: not valid java name */
    public static /* synthetic */ Unit m458lambda$sSG8bhNDJm2XFW5k7zkEENkais(Bundle r0, RequestParams r1) {
        return runAikModelBundle$lambda$8(r0, r1);
    }

    public static /* synthetic */ Unit lambda$z1uQvoiklrnZROLvpp5xvgk0wBc(String r0, RequestParams r1) {
        return runAikModel$lambda$7(r0, r1);
    }

    private static final Unit preloadPkg$lambda$5(String r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        RunLog.INSTANCE.debug(TAG, "preloadPkg " + r3 + " return " + r4);
        return Unit.INSTANCE;
    }

    private final Object runAikModel(String r12, final String r13, Continuation<? super String> r14) {
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r15, C10991.class) == false) goto L7;
        C10991 r0 = (C10991) ZeusTransformUtils.preCheckCast(r15, C10991.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 != 2) goto L14;
        ResultKt.throwOnFailure(r11);
    L26:
        Response r17 = (Response) ZeusTransformUtils.preCheckCast(r11, Response.class, "com.obric.memorydata.plugin");
        if (r17 == null) goto L36;
        Bundle r18 = r17.getSrc();
        if (r18 == null) goto L37;
        String r19 = BundleExtKt.bundle2json(r18).toString();
        Intrinsics.checkNotNullExpressionValue(r19, "toString(...)");
        return r19;
    L37:
        return "{}";
    L36:
        return "{}";
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r13 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r11);
    L21:
        IBaseModel r110 = (IBaseModel) ZeusTransformUtils.preCheckCast(r11, IBaseModel.class, "com.obric.memorydata.plugin");
        if (r110 == null) goto L32;
        RequestParams r111 = new RequestParams(null, new $$Lambda$MemoryScriptEngineEnv$z1uQvoiklrnZROLvpp5xvgk0wBc(r13), 1, null);
        r0.L$0 = null;
        r0.label = 2;
        r11 = r110.infer(r111, r0);
        if (r11 != r16) goto L26;
        return r16;
    L32:
        return "{}";
    L16:
        ResultKt.throwOnFailure(r11);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L34;
        IAIKernelManager r3 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
        r0.L$0 = r13;
        r0.label = 1;
        r11 = IAIKernelManager.DefaultImpls.loadPackage$default(r3, r12, false, null, r0, 6, null);
        if (r11 != r16) goto L21;
        return r16;
    L34:
        Ensure.ensureNotReachHere("runAikModel called when AIKernel not available");
        throw new RuntimeException("runAikModel called when AIKernel not available");
    L7:
        r0 = new C10991(this, r15);
        goto L8
    }

    private static final Unit runAikModel$lambda$7(final String r1, RequestParams r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$RequestParams");
        ParamsKt.setCustomArgs(r2, new $$Lambda$MemoryScriptEngineEnv$kN3p9bkFbpqnAGqCScFOTv4FCM(r1));
        return Unit.INSTANCE;
    }

    private static final Unit runAikModel$lambda$7$lambda$6(String r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "$this$setCustomArgs");
        r4.putAll(BundleExtKt.json2Bundle$default(new JSONObject(r3), false, 2, null));
        return Unit.INSTANCE;
    }

    private final Object runAikModelBundle(String r24, Bundle r25, Continuation<? super Bundle> r26) {
        Continuation r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r26, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r0, C11001.class) == false) goto L7;
        C11001 r2 = (C11001) ZeusTransformUtils.preCheckCast(r0, C11001.class, "com.obric.memorydata.plugin");
        if ((r2.label & Integer.MIN_VALUE) == 0) goto L7;
        r2.label -= Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r2.label;
        Response r13 = null;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r2.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r1);
    L29:
        r13 = (Response) ZeusTransformUtils.preCheckCast(r1, Response.class, "com.obric.memorydata.plugin");
        String r5 = r4;
    L30:
        Bundle r6 = new Bundle();
        int r7 = -1;
        if (r13 != null) goto L35;
        StringBuilder r8 = new StringBuilder().append("runAikModelBundle modelName:").append(r5);
        String r9 = " res is null";
    L33:
        StringBuilder r11 = r8.append(r9);
    L34:
        String r12 = r11.toString();
        r6.putInt(IdlKeys.ErrorCode, r7);
        r6.putString(IdlKeys.ErrorInfo, r12);
        return r6;
    L35:
        Bundle r14 = r13.getSrc();
        if (r14 != null) goto L39;
        r8 = new StringBuilder().append("runAikModelBundle modelName:").append(r5);
        r9 = " res src is null";
        goto L33
    L39:
        if (r13.getErrorCode() == 0) goto L43;
        r7 = r13.getErrorCode();
        r11 = new StringBuilder().append("runAikModelBundle modelName:").append(r5).append(" error:").append(r13);
        goto L34
    L43:
        return r14;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        Bundle r15 = (Bundle) ZeusTransformUtils.preCheckCast(r2.L$1, Bundle.class, "com.obric.memorydata.plugin");
        String r16 = (String) ZeusTransformUtils.preCheckCast(r2.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r1);
        final Bundle r17 = r15;
        Object r18 = r1;
        r5 = r16;
    L21:
        IBaseModel r19 = (IBaseModel) ZeusTransformUtils.preCheckCast(r18, IBaseModel.class, "com.obric.memorydata.plugin");
        if (r19 != null) goto L24;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "runAikModelBundle modelName:" + r5 + " not found", null, 4, null);
    L24:
        if (r19 == null) goto L30;
        RequestParams r20 = new RequestParams(null, new $$Lambda$MemoryScriptEngineEnv$sSG8bhNDJm2XFW5k7zkEENkais(r17), 1, null);
        r2.L$0 = r5;
        r2.L$1 = null;
        r2.label = 2;
        Object r21 = r19.infer(r20, r2);
        if (r21 != r10) goto L28;
        return r10;
    L28:
        r4 = r5;
        r1 = r21;
        goto L29
    L16:
        ResultKt.throwOnFailure(r1);
        if (DeviceInfoState.INSTANCE.isAIKernelAvailable() == false) goto L44;
        IAIKernelManager r22 = (IAIKernelManager) ZeusTransformUtils.preCheckCast(AIKernelManager.INSTANCE, IAIKernelManager.class, "com.obric.memorydata.plugin");
        r5 = r24;
        r2.L$0 = r5;
        r17 = r25;
        r2.L$1 = r17;
        r2.label = 1;
        r18 = IAIKernelManager.DefaultImpls.loadPackage$default(r22, r24, false, null, r2, 6, null);
        if (r18 != r10) goto L21;
        return r10;
    L44:
        Ensure.ensureNotReachHere("runAikModelBundle called when AIKernel not available");
        throw new RuntimeException("runAikModelBundle called when AIKernel not available");
    L7:
        r2 = new C11001(this, r0);
        goto L8
    }

    private static final Unit runAikModelBundle$lambda$8(Bundle r1, RequestParams r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$RequestParams");
        r2.getBackend().putAll(r1);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object runPackage$default(MemoryScriptEngineEnv r7, String r8, RequestParams r9, String r10, Function1 r11, Continuation r12, int r13, Object r14) {
        Function1<? super Bundle, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if ((r13 & 4) == 0) goto L6;
        r10 = "";
    L6:
        return r7.runPackage(r8, r9, r10, r5, r6);
    }

    private static final int runtime$lambda$3$lambda$0() {
        int r0 = Process.myUid() / 100000;
        return SharedState.INSTANCE.getInt("doubao_os_user_id", r0);
    }

    private static final boolean runtime$lambda$3$lambda$1() {
        return UserSettings.INSTANCE.hasAgreePrivacy();
    }

    @com.obric.aee.utils.a
    private final String sendNativeMsg(String r9, String r10) {
        Type r11 = new f().getType();
        Object r12 = getGsonBuilder().create().fromJson(r9, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "fromJson(...)");
        BridgeData r13 = (BridgeData) ZeusTransformUtils.preCheckCast(r12, BridgeData.class, "com.obric.memorydata.plugin");
        Object r8 = executeBridge(r13);     // Catch: Throwable -> L10
        if (Intrinsics.areEqual(Void.TYPE, r8) == false) goto L6;
        BridgeResponse r14 = new BridgeResponse(0, "success", null, 4, null);     // Catch: Throwable -> L10
    L27:
    L20:
        String r15 = u.a(r14);
        if (r15 != null) goto L24;
        r15 = "{}";
    L24:
        if (r15.length() <= 300) goto L26;
        RunLog r0 = RunLog.INSTANCE;
        StringBuilder r16 = new StringBuilder().append("bridge handler request: ").append(r13.getApiInfo()).append(", response ====  ");
        String r17 = r15.substring(0, 300);
        Intrinsics.checkNotNullExpressionValue(r17, "substring(...)");
        r0.debug(TAG, r16.append(r17).toString());
    L26:
        return r15;
    L6:
        if (r8 != null) goto L9;
        r14 = new BridgeResponse(2, "return null data", null, 4, null);     // Catch: Throwable -> L10
        goto L27
    L9:
        r14 = new BridgeResponse(0, "success", r8);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        if (ZeusTransformUtils.instanceOf(th, InvocationTargetException.class) == false) goto L14;
        Throwable r1 = ((InvocationTargetException) ZeusTransformUtils.preCheckCast(th, InvocationTargetException.class, "com.obric.memorydata.plugin")).getTargetException();
    L16:
        if (AppContext.INSTANCE.isDebug() == false) goto L18;
        com.obric.memorydata.utils.j.a(new $$Lambda$MemoryScriptEngineEnv$aRCI_UwwtvKPAeoD9ZVCTVsf03M(th));
    L19:
        r14 = new BridgeResponse(-1, String.valueOf(r1.getMessage()), null, 4, null);
        goto L20
    L18:
        Ensure.ensureNotReachHere(th, "papaya bridge error");
        goto L19
    L14:
        r1 = th;
        goto L16
    }

    private static final Unit sendNativeMsg$lambda$19(Throwable r0) {
        throw r0;
    }

    public final void dump(FileDescriptor r2, PrintWriter r3, List<String> r4) {
        List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "fd");
        Intrinsics.checkNotNullParameter(r3, "fout");
        Intrinsics.checkNotNullParameter(r1, "args");
        runtime.a(r2, r3, r1);
    }

    public final Object getAllPackageConfigs(Continuation<? super List<com.obric.aikernel.res.metadata.config.i>> r2) {
        Continuation<? super List<com.obric.aikernel.res.metadata.config.i>> r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin");
        return runtime.a(r1);
    }

    public final Object getPackage(String r2, Continuation<? super PackageResource> r3) {
        Continuation<? super PackageResource> r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return runtime.a(r2, r1);
    }

    public final Object getPackageConfig(String r2, Continuation<? super com.obric.aikernel.res.metadata.config.i> r3) {
        Continuation<? super com.obric.aikernel.res.metadata.config.i> r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return runtime.b(r2, r1);
    }

    public final Object getPackageConfigDesc(String r5, Continuation<? super String> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, C10971.class) == false) goto L7;
        C10971 r0 = (C10971) ZeusTransformUtils.preCheckCast(r7, C10971.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        r5 = (String) ZeusTransformUtils.preCheckCast(r0.L$0, String.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
    L17:
        com.obric.aikernel.res.metadata.config.i r9 = (com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r4, com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L22;
        StringBuilder r10 = new StringBuilder().append("未找到算法包 ").append(r5);
    L21:
        return r10.toString();
    L22:
        r10 = new StringBuilder().append("算法包信息: name: ").append(r9.a()).append(", version: ").append(r9.c()).append(", extras: ").append(AIInferRuntime.f6160a.a(r9));
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        AIInferRuntime r11 = runtime;
        r0.L$0 = r5;
        r0.label = 1;
        r4 = r11.b(r5, r0);
        if (r4 != r8) goto L17;
        return r8;
    L7:
        r0 = new C10971(this, r7);
        goto L8
    }

    public final Object getPackageCustomConfig(String r5, Continuation<? super JsonObject> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r7, C10981.class) == false) goto L7;
        C10981 r0 = (C10981) ZeusTransformUtils.preCheckCast(r7, C10981.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r0.result;
        Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r4);
    L17:
        com.obric.aikernel.res.metadata.config.i r9 = (com.obric.aikernel.res.metadata.config.i) ZeusTransformUtils.preCheckCast(r4, com.obric.aikernel.res.metadata.config.i.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L22;
        return null;
    L22:
        return AIInferRuntime.f6160a.a(r9);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        AIInferRuntime r10 = runtime;
        r0.label = 1;
        r4 = r10.b(r5, r0);
        if (r4 != r8) goto L17;
        return r8;
    L7:
        r0 = new C10981(this, r7);
        goto L8
    }

    public final AIInferRuntime getRuntime() {
        return runtime;
    }

    public final void init() {
    }

    public final Object preloadPkg(final String r7, Continuation<? super Unit> r8) {
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        Object r6 = runtime.a(r7, new RequestParams(null, null, 3, null), "INIT", new $$Lambda$MemoryScriptEngineEnv$2qmrK_e1LRghTKguPZWTCFwoa4(r7), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public final Object pushDebugInfo(JsonObject r2, Continuation<? super Unit> r3) {
        Continuation<? super Unit> r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        Object r4 = runtime.a(r2, r1);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Unit.INSTANCE;
    }

    public final Object runPackage(String r8, RequestParams r9, String r10, Function1<? super Bundle, Unit> r11, Continuation<? super Unit> r12) {
        Function1<? super Bundle, Unit> r5 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        Object r7 = runtime.a(r8, r9, r10, r5, r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r7;
    L6:
        return Unit.INSTANCE;
    }

    public final Object updateAll(Continuation<? super Map<String, UpdateResult>> r3) {
        Continuation<? super Map<String, UpdateResult>> r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return runtime.a("self", false, r2);
    }

    public final Object updatePackage(String r9, Continuation<? super PackageResource> r10) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return AIInferRuntime.a(runtime, r9, "self", false, null, r5, 12, null);
    }
}
