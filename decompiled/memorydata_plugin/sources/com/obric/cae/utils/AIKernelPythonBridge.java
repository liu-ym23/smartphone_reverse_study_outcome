package com.obric.cae.utils;

import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.aikernel.core.log.ILog;
import com.obric.aikernel.phx.core.api.ScriptBizApi;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.phx.sdk.IAIKernelManager;
import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.aikernel.sdk.response.Response;
import com.obric.cae.commonsense.BuildConfig;
import com.obric.cae.userAware.WifiScanSceneType;
import com.obric.cae.userAware.utils.MatrixDidUtils;
import com.obric.cae.utils.bridge.CaeCoreBridgeApi;
import com.obric.cae.utils.bridge.CaeLocationBridgeApi;
import com.obric.cae.utils.bridge.PythonScriptEngineBridge;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001:\u00029:B\t\b\u0002¢\u0006\u0004\b7\u00108J,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u0007J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0001H\u0007J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0001H\u0007J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0013H\u0007J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J*\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0004H\u0007J\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0087@ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001dJA\u0010\"\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010\u0019\u001a\u00020\u00042\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\b0!H\u0087@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\b\u0010%\u001a\u00020$H\u0002R\u0014\u0010&\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010+\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b+\u0010'R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R \u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002000/8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b5\u0010'R\u0014\u00106\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b6\u0010'\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006;"}, d2 = {"Lcom/obric/cae/utils/AIKernelPythonBridge;", "", "Landroid/content/Context;", "context", "", "projectId", "appVersion", "channel", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "module", TypedValues.AttributesType.S_TARGET, "registerModule", "", "unregisterModule", ObricMemoryConstants.KEY_PACKAGE_NAME, "Lcom/obric/cae/utils/PythonPackageLifecycleCallback;", "callback", "loadPackageAsync", "Lcom/obric/cae/utils/PythonPackageLoadCallback;", "loadPackageWithResourceAsync", "unloadPackageAsync", "Landroid/os/Bundle;", "input", "Lcom/obric/cae/utils/PythonPackageCallback;", "event", "runPackageAsync", "Lcom/obric/aikernel/sdk/data/PackageResource;", "getPackage", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updatePackage", "Lcom/obric/aikernel/sdk/config/RequestParams;", TrackerImpl.PARAMS, "Lkotlin/Function1;", "runPackage", "(Ljava/lang/String;Lcom/obric/aikernel/sdk/config/RequestParams;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/obric/aikernel/runtime/AIInferRuntime;", "requireRuntime", "TAG", "Ljava/lang/String;", "", "AI_KERNEL_PRODUCT_ID", "J", "DEFAULT_PROJECT_ID", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/aikernel/phx/core/api/ScriptBizApi;", "scriptApis", "Ljava/util/concurrent/ConcurrentHashMap;", "runtime", "Lcom/obric/aikernel/runtime/AIInferRuntime;", "CORE_MODULE", "LOCATION_MODULE", "<init>", "()V", "a", "b", "CommSenseAAR_release"}, k = 1, mv = {1, 8, 0})
public final class AIKernelPythonBridge {
    private static final long AI_KERNEL_PRODUCT_ID = 570851;
    private static final String CORE_MODULE = "core";
    public static final String DEFAULT_PROJECT_ID = "default";
    public static final AIKernelPythonBridge INSTANCE = null;
    private static final String LOCATION_MODULE = "location";
    private static final String TAG = "AIKernelPythonBridge";
    private static volatile AIInferRuntime runtime;
    private static final al scope = null;
    private static final ConcurrentHashMap<String, ScriptBizApi> scriptApis = null;

    public static final class a implements ILog {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f7329a = null;

        static {
            f7329a = new a();
        }

        public a() {
        }

        @Override // com.obric.aikernel.core.log.ILog
        public final void d(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        }

        @Override // com.obric.aikernel.core.log.ILog
        public final void e(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        }

        @Override // com.obric.aikernel.core.log.ILog
        public final void e(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(r3, "t");
        }

        @Override // com.obric.aikernel.core.log.ILog
        public final void i(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        }

        @Override // com.obric.aikernel.core.log.ILog
        public final boolean isDebug() {
            return false;
        }

        @Override // com.obric.aikernel.core.log.ILog
        public final void v(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        }

        @Override // com.obric.aikernel.core.log.ILog
        public final void w(String r1, String r2) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
        }

        @Override // com.obric.aikernel.core.log.ILog
        public final void w(String r1, String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(r3, "t");
        }
    }

    public static final class b implements com.obric.aikernel.runtime.utils.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f7330a = null;

        static {
            f7330a = new b();
        }

        public b() {
        }

        @Override // com.obric.aikernel.runtime.utils.c
        public final void a(int r1, String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r3, Params.CONTENT);
            com.obric.cae.log.a.c("AIKernelPythonBridge-" + r2, r3);
        }

        @Override // com.obric.aikernel.runtime.utils.c
        public final void a(String r1, String r2, int r3) {
            Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
            Intrinsics.checkNotNullParameter(r2, "message");
            com.obric.cae.log.a.c("AIKernelPythonBridge-" + r1, r2);
        }
    }

    @DebugMetadata(c = "com.obric.cae.utils.AIKernelPythonBridge$init$config$1", f = "AIKernelPythonBridge.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class c extends SuspendLambda implements Function1<Continuation<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f7331a;

        public c(Context r3, Continuation<? super c> r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.f7331a = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
            super(1, r6);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return new c(this.f7331a, r4);
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super String> r3) {
            return ((c) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin")), c.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(r1);
            String r0 = MatrixDidUtils.getDid(this.f7331a);
            if (r0 != null) goto L6;
            return "";
        L6:
            return r0;
        }
    }

    public static final class d extends Lambda implements Function0<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f7332a = null;

        static {
            f7332a = new d();
        }

        public d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            return Integer.valueOf(Process.myUid() / 100000);
        }
    }

    @DebugMetadata(c = "com.obric.cae.utils.AIKernelPythonBridge$loadPackageAsync$1", f = "AIKernelPythonBridge.kt", i = {0, 1}, l = {188, 192, WifiScanSceneType.HAR_END}, m = "invokeSuspend", n = {"packageParams", "packageParams"}, s = {"L$0", "L$0"})
    public static final class e extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RequestParams f7333a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7334b;
        public final /* synthetic */ String c;
        public final /* synthetic */ com.obric.cae.utils.e d;

        public e(String r3, com.obric.cae.utils.e r4, Continuation<? super e> r5) {
            com.obric.cae.utils.e r6 = (com.obric.cae.utils.e) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.cae.utils.e.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.c = r3;
            this.d = r6;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return new e(this.c, this.d, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(al r3, Continuation<? super Unit> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin")), e.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.f7334b;
            ScriptBizApi r10 = null;
            if (r1 == 0) goto L19;
            if (r1 == 1) goto L16;
            if (r1 == 2) goto L13;
            if (r1 != 3) goto L12;
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L9
            Object r0 = r14;
        L40:
            if (ZeusTransformUtils.instanceOf(r0, ScriptBizApi.class) == false) goto L42;
            r10 = (ScriptBizApi) ZeusTransformUtils.preCheckCast(r0, ScriptBizApi.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        L42:
            if (r10 == null) goto L45;
            AIKernelPythonBridge.access$getScriptApis$p().putIfAbsent(this.c, r10);     // Catch: Throwable -> L9
            this.d.a();     // Catch: Throwable -> L9
        L53:
            return Unit.INSTANCE;
        L45:
            throw new IllegalStateException("Python package " + this.c + " failed to load");     // Catch: Throwable -> L9
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L13:
            RequestParams r2 = this.f7333a;
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L9
            Object r3 = ((Result) ZeusTransformUtils.preCheckCast(r14, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();     // Catch: Throwable -> L9
        L33:
            ResultKt.throwOnFailure(r3);     // Catch: Throwable -> L9
            PackageResource r4 = (PackageResource) ZeusTransformUtils.preCheckCast(r3, PackageResource.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        L34:
            RequestParams r5 = r2;
            if (r4.isAvailable() == false) goto L47;
            AIKernelManager r6 = AIKernelManager.INSTANCE;     // Catch: Throwable -> L9
            String r7 = this.c;     // Catch: Throwable -> L9
            this.f7333a = null;     // Catch: Throwable -> L9
            this.f7334b = 3;     // Catch: Throwable -> L9
            r0 = IAIKernelManager.DefaultImpls.loadPackage$default(r6, r7, false, r5, this, 2, null);     // Catch: Throwable -> L9
            if (r0 != r8) goto L40;
            return r8;
        L47:
            throw new IllegalStateException("Python package " + this.c + " is not available");     // Catch: Throwable -> L9
        L16:
            r2 = this.f7333a;
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L9
            Object r9 = ((Result) ZeusTransformUtils.preCheckCast(r14, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();     // Catch: Throwable -> L9
        L28:
            ResultKt.throwOnFailure(r9);     // Catch: Throwable -> L9
            r4 = (PackageResource) ZeusTransformUtils.preCheckCast(r9, PackageResource.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            if (r4.isAvailable() == true) goto L34;
            AIKernelManager r11 = AIKernelManager.INSTANCE;     // Catch: Throwable -> L9
            this.f7333a = r2;     // Catch: Throwable -> L9
            this.f7334b = 2;     // Catch: Throwable -> L9
            r3 = r11.mo189updatePackage0E7RQCE(r4, r2, this);     // Catch: Throwable -> L9
            if (r3 != r8) goto L33;
            return r8;
        L19:
            ResultKt.throwOnFailure(r14);
            if (AIKernelPythonBridge.access$getScriptApis$p().containsKey(this.c) == false) goto L24;
            this.d.a();     // Catch: Throwable -> L9
            return Unit.INSTANCE;
        L24:
            RequestParams r12 = new RequestParams(null, null, 3, null);     // Catch: Throwable -> L9
            AIKernelManager r13 = AIKernelManager.INSTANCE;     // Catch: Throwable -> L9
            String r15 = this.c;     // Catch: Throwable -> L9
            this.f7333a = r12;     // Catch: Throwable -> L9
            this.f7334b = 1;     // Catch: Throwable -> L9
            Object r16 = r13.mo188getPackage0E7RQCE(r15, r12, this);     // Catch: Throwable -> L9
            if (r16 != r8) goto L27;
            return r8;
        L27:
            r2 = r12;
            r9 = r16;
        L9:
            th = move-exception;
            com.obric.cae.log.a.c(AIKernelPythonBridge.TAG, "Python package load failed: " + th.getMessage());
            com.obric.cae.utils.e r17 = this.d;
            String r18 = th.getMessage();
            if (r18 != null) goto L51;
            r18 = "Python package load failed";
        L51:
            r17.a(r18);
            goto L53
        }
    }

    @DebugMetadata(c = "com.obric.cae.utils.AIKernelPythonBridge$loadPackageWithResourceAsync$1", f = "AIKernelPythonBridge.kt", i = {0, 1, 2}, l = {227, 231, 242}, m = "invokeSuspend", n = {"packageParams", "packageParams", "packageResource"}, s = {"L$0", "L$0", "L$0"})
    public static final class f extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f7335a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7336b;
        public final /* synthetic */ String c;
        public final /* synthetic */ com.obric.cae.utils.f d;

        public f(String r3, com.obric.cae.utils.f r4, Continuation<? super f> r5) {
            com.obric.cae.utils.f r6 = (com.obric.cae.utils.f) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.cae.utils.f.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.c = r3;
            this.d = r6;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return new f(this.c, this.d, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(al r3, Continuation<? super Unit> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin")), f.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r14) {
            Object r8 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.f7336b;
            ScriptBizApi r10 = null;
            if (r1 == 0) goto L18;
            if (r1 == 1) goto L15;
            if (r1 == 2) goto L12;
            if (r1 != 3) goto L11;
            PackageResource r2 = (PackageResource) ZeusTransformUtils.preCheckCast(this.f7335a, PackageResource.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L48
            Object r0 = r14;
        L40:
            if (ZeusTransformUtils.instanceOf(r0, ScriptBizApi.class) == false) goto L42;
            r10 = (ScriptBizApi) ZeusTransformUtils.preCheckCast(r0, ScriptBizApi.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
        L42:
            if (r10 == null) goto L45;
            AIKernelPythonBridge.access$getScriptApis$p().putIfAbsent(this.c, r10);     // Catch: Throwable -> L48
            this.d.a(r2);     // Catch: Throwable -> L48
        L54:
            return Unit.INSTANCE;
        L45:
            throw new IllegalStateException("Python package " + this.c + " failed to load");     // Catch: Throwable -> L48
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            RequestParams r3 = (RequestParams) ZeusTransformUtils.preCheckCast(this.f7335a, RequestParams.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L48
            Object r4 = ((Result) ZeusTransformUtils.preCheckCast(r14, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();     // Catch: Throwable -> L48
        L28:
            ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L48
            PackageResource r5 = (PackageResource) ZeusTransformUtils.preCheckCast(r4, PackageResource.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
        L29:
            RequestParams r6 = r3;
            if (r5.isAvailable() == false) goto L47;
            if (AIKernelPythonBridge.access$getScriptApis$p().containsKey(this.c) == false) goto L35;
            this.d.a(r5);     // Catch: Throwable -> L48
            return Unit.INSTANCE;
        L35:
            AIKernelManager r7 = AIKernelManager.INSTANCE;     // Catch: Throwable -> L48
            String r9 = this.c;     // Catch: Throwable -> L48
            this.f7335a = r5;     // Catch: Throwable -> L48
            this.f7336b = 3;     // Catch: Throwable -> L48
            Object r11 = IAIKernelManager.DefaultImpls.loadPackage$default(r7, r9, false, r6, this, 2, null);     // Catch: Throwable -> L48
            if (r11 != r8) goto L38;
            return r8;
        L38:
            r2 = r5;
            r0 = r11;
            goto L40
        L47:
            throw new IllegalStateException("Python package " + this.c + " is not available");     // Catch: Throwable -> L48
        L15:
            r3 = (RequestParams) ZeusTransformUtils.preCheckCast(this.f7335a, RequestParams.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L48
            Object r12 = ((Result) ZeusTransformUtils.preCheckCast(r14, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();     // Catch: Throwable -> L48
        L23:
            ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L48
            r5 = (PackageResource) ZeusTransformUtils.preCheckCast(r12, PackageResource.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
            if (r5.isAvailable() == true) goto L29;
            AIKernelManager r13 = AIKernelManager.INSTANCE;     // Catch: Throwable -> L48
            this.f7335a = r3;     // Catch: Throwable -> L48
            this.f7336b = 2;     // Catch: Throwable -> L48
            r4 = r13.mo189updatePackage0E7RQCE(r5, r3, this);     // Catch: Throwable -> L48
            if (r4 != r8) goto L28;
            return r8;
        L18:
            ResultKt.throwOnFailure(r14);
            RequestParams r15 = new RequestParams(null, null, 3, null);     // Catch: Throwable -> L48
            AIKernelManager r16 = AIKernelManager.INSTANCE;     // Catch: Throwable -> L48
            String r17 = this.c;     // Catch: Throwable -> L48
            this.f7335a = r15;     // Catch: Throwable -> L48
            this.f7336b = 1;     // Catch: Throwable -> L48
            Object r18 = r16.mo188getPackage0E7RQCE(r17, r15, this);     // Catch: Throwable -> L48
            if (r18 != r8) goto L22;
            return r8;
        L22:
            r3 = r15;
            r12 = r18;
        L48:
            th = move-exception;
            com.obric.cae.log.a.c(AIKernelPythonBridge.TAG, "Python package load failed: " + th.getMessage());
            com.obric.cae.utils.f r19 = this.d;
            String r20 = th.getMessage();
            if (r20 != null) goto L52;
            r20 = "Python package load failed";
        L52:
            r19.a(r20);
            goto L54
        }
    }

    @DebugMetadata(c = "com.obric.cae.utils.AIKernelPythonBridge$runPackageAsync$1", f = "AIKernelPythonBridge.kt", i = {0, 1}, l = {289, 293, 302, 310}, m = "invokeSuspend", n = {"packageParams", "packageParams"}, s = {"L$0", "L$0"})
    public static final class g extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public RequestParams f7337a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7338b;
        public final /* synthetic */ String c;
        public final /* synthetic */ Bundle d;
        public final /* synthetic */ PythonPackageCallback e;

        public g(String r3, Bundle r4, PythonPackageCallback r5, Continuation<? super g> r6) {
            PythonPackageCallback r7 = (PythonPackageCallback) ZeusTransformUtils.wrapperContextForParams(r5, PythonPackageCallback.class, "com.obric.memorydata.plugin");
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            this.c = r3;
            this.d = r4;
            this.e = r7;
            super(2, r8);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            return new g(this.c, this.d, this.e, r5);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(al r3, Continuation<? super Unit> r4) {
            return ((g) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin")), g.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r17) {
            Object r0 = r17;
            Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.f7338b;
            String r14 = null;
            if (r1 == 0) goto L22;
            if (r1 == 1) goto L19;
            if (r1 == 2) goto L16;
            if (r1 == 3) goto L12;
            if (r1 != 4) goto L11;
            ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L14
        L54:
            Response r2 = (Response) ZeusTransformUtils.preCheckCast(r0, Response.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
            if (r2 == null) goto L82;
            if (r2.getErrorCode() == 0) goto L63;
            StringBuilder r3 = new StringBuilder("Python package ").append(this.c).append(" failed: ").append(r2.getErrorCode()).append(' ');     // Catch: Throwable -> L14
            String r4 = r2.getErrorInfo();     // Catch: Throwable -> L14
            if (r4 != null) goto L62;
            r4 = "";
        L62:
            throw new IllegalStateException(r3.append(r4).toString());     // Catch: Throwable -> L14
        L63:
            Object r5 = r2.getData();     // Catch: Throwable -> L14
            if (ZeusTransformUtils.instanceOf(r5, Bundle.class) == false) goto L66;
            Bundle r6 = (Bundle) ZeusTransformUtils.preCheckCast(r5, Bundle.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        L67:
            if (r6 != null) goto L80;
            Bundle r7 = r2.getSrc();     // Catch: Throwable -> L14
            if (r7 == null) goto L71;
            r6 = new Bundle(r7);     // Catch: Throwable -> L14
        L72:
            if (r6 != null) goto L80;
            StringBuilder r8 = new StringBuilder("Python package ").append(this.c).append(" returned ");     // Catch: Throwable -> L14
            Object r10 = r2.getData();     // Catch: Throwable -> L14
            if (r10 == null) goto L76;
            r14 = r10.getClass().getName();     // Catch: Throwable -> L14
        L76:
            if (r14 != null) goto L79;
            r14 = "null";
        L79:
            throw new IllegalStateException(r8.append(r14).toString());     // Catch: Throwable -> L14
        L71:
            r6 = null;
        L80:
            this.e.onSuccess(r6);     // Catch: Throwable -> L14
        L90:
            return Unit.INSTANCE;
        L66:
            r6 = null;
            goto L67
        L82:
            throw new IllegalStateException("Python package " + this.c + " returned no response");     // Catch: Throwable -> L14
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L14
        L41:
            if (ZeusTransformUtils.instanceOf(r0, ScriptBizApi.class) == false) goto L43;
            ScriptBizApi r11 = (ScriptBizApi) ZeusTransformUtils.preCheckCast(r0, ScriptBizApi.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        L44:
            if (r11 == null) goto L46;
            AIKernelPythonBridge.access$getScriptApis$p().putIfAbsent(this.c, r11);     // Catch: Throwable -> L14
        L47:
            if (r11 == null) goto L50;
        L51:
            RequestParams r12 = new RequestParams(new Bundle(this.d), null, 2, null);     // Catch: Throwable -> L14
            this.f7337a = null;     // Catch: Throwable -> L14
            this.f7338b = 4;     // Catch: Throwable -> L14
            r0 = r11.infer(r12, this);     // Catch: Throwable -> L14
            if (r0 != r9) goto L54;
            return r9;
        L50:
            throw new IllegalStateException("Python package " + this.c + " failed to load");     // Catch: Throwable -> L14
        L46:
            r11 = null;
            goto L47
        L43:
            r11 = null;
            goto L44
        L16:
            RequestParams r13 = this.f7337a;
            ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L14
            Object r15 = ((Result) ZeusTransformUtils.preCheckCast(r0, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();     // Catch: Throwable -> L14
        L32:
            ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L14
            PackageResource r16 = (PackageResource) ZeusTransformUtils.preCheckCast(r15, PackageResource.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        L33:
            RequestParams r18 = r13;
            if (r16.isAvailable() == false) goto L84;
            r11 = (ScriptBizApi) ZeusTransformUtils.preCheckCast(AIKernelPythonBridge.access$getScriptApis$p().get(this.c), ScriptBizApi.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
            if (r11 != null) goto L51;
            AIKernelManager r19 = AIKernelManager.INSTANCE;     // Catch: Throwable -> L14
            String r20 = this.c;     // Catch: Throwable -> L14
            this.f7337a = null;     // Catch: Throwable -> L14
            this.f7338b = 3;     // Catch: Throwable -> L14
            r0 = IAIKernelManager.DefaultImpls.loadPackage$default(r19, r20, false, r18, this, 2, null);     // Catch: Throwable -> L14
            if (r0 != r9) goto L41;
            return r9;
        L84:
            throw new IllegalStateException("Python package " + this.c + " is not available");     // Catch: Throwable -> L14
        L19:
            r13 = this.f7337a;
            ResultKt.throwOnFailure(r17);     // Catch: Throwable -> L14
            Object r21 = ((Result) ZeusTransformUtils.preCheckCast(r0, Result.class, "com.obric.memorydata.plugin")).m1430unboximpl();     // Catch: Throwable -> L14
        L27:
            ResultKt.throwOnFailure(r21);     // Catch: Throwable -> L14
            r16 = (PackageResource) ZeusTransformUtils.preCheckCast(r21, PackageResource.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
            if (r16.isAvailable() == true) goto L33;
            AIKernelManager r22 = AIKernelManager.INSTANCE;     // Catch: Throwable -> L14
            this.f7337a = r13;     // Catch: Throwable -> L14
            this.f7338b = 2;     // Catch: Throwable -> L14
            r15 = r22.mo189updatePackage0E7RQCE(r16, r13, this);     // Catch: Throwable -> L14
            if (r15 != r9) goto L32;
            return r9;
        L22:
            ResultKt.throwOnFailure(r17);
            RequestParams r23 = new RequestParams(null, null, 3, null);     // Catch: Throwable -> L14
            AIKernelManager r24 = AIKernelManager.INSTANCE;     // Catch: Throwable -> L14
            String r25 = this.c;     // Catch: Throwable -> L14
            this.f7337a = r23;     // Catch: Throwable -> L14
            this.f7338b = 1;     // Catch: Throwable -> L14
            Object r26 = r24.mo188getPackage0E7RQCE(r25, r23, this);     // Catch: Throwable -> L14
            if (r26 != r9) goto L26;
            return r9;
        L26:
            r13 = r23;
            r21 = r26;
        L14:
            th = move-exception;
            com.obric.cae.log.a.c(AIKernelPythonBridge.TAG, "Python package execution failed: " + th.getMessage());
            PythonPackageCallback r27 = this.e;
            String r28 = th.getMessage();
            if (r28 != null) goto L88;
            r28 = "Python package execution failed";
        L88:
            r27.onFailure(r28);
            goto L90
        }
    }

    @DebugMetadata(c = "com.obric.cae.utils.AIKernelPythonBridge$unloadPackageAsync$1", f = "AIKernelPythonBridge.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class h extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7339a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.obric.cae.utils.e f7340b;

        public h(String r3, com.obric.cae.utils.e r4, Continuation<? super h> r5) {
            com.obric.cae.utils.e r6 = (com.obric.cae.utils.e) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.cae.utils.e.class, "com.obric.memorydata.plugin");
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
            this.f7339a = r3;
            this.f7340b = r6;
            super(2, r7);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return new h(this.f7339a, this.f7340b, r4);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(al r3, Continuation<? super Unit> r4) {
            return ((h) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin")), h.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(r3);
            ScriptBizApi r4 = (ScriptBizApi) ZeusTransformUtils.preCheckCast(AIKernelPythonBridge.access$getScriptApis$p().remove(this.f7339a), ScriptBizApi.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
            if (r4 == null) goto L6;
            r4.close();     // Catch: Throwable -> L8
        L6:
            this.f7340b.a();     // Catch: Throwable -> L8
        L14:
            return Unit.INSTANCE;
        L8:
            th = move-exception;
            com.obric.cae.log.a.c(AIKernelPythonBridge.TAG, "Python package unload failed: " + th.getMessage());
            com.obric.cae.utils.e r2 = this.f7340b;
            String r5 = th.getMessage();
            if (r5 != null) goto L12;
            r5 = "Python package unload failed";
        L12:
            r2.a(r5);
            goto L14
        }
    }

    static {
        INSTANCE = new AIKernelPythonBridge();
        scope = am.a(cu.a(null, 1, null).plus(ba.c()));
        scriptApis = new ConcurrentHashMap();
    }

    private AIKernelPythonBridge() {
    }

    public static final /* synthetic */ ConcurrentHashMap access$getScriptApis$p() {
        return scriptApis;
    }

    @JvmStatic
    public static final Object getPackage(String r2, Continuation<? super PackageResource> r3) {
        Continuation<? super PackageResource> r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return INSTANCE.requireRuntime().a(r2, r4);
    }

    @JvmStatic
    public static final void init(Context r6, String r7) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r7, "projectId");
        init$default(r0, r7, null, null, 12, null);
    }

    @JvmStatic
    public static final void init(Context r6, String r7, String r8) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r0, "context");
        Intrinsics.checkNotNullParameter(r7, "projectId");
        Intrinsics.checkNotNullParameter(r8, "appVersion");
        init$default(r0, r7, r8, null, 8, null);
    }

    @JvmStatic
    public static final synchronized void init(Context r15, String r16, String r17, String r18) {
        monitor-enter(AIKernelPythonBridge.class);
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r0, "context");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r16, "projectId");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r17, "appVersion");     // Catch: Throwable -> L19
        Intrinsics.checkNotNullParameter(r18, "channel");     // Catch: Throwable -> L19
        if (runtime == null) goto L9;
        monitor-exit(AIKernelPythonBridge.class);
        return;
    L9:
        if ((!StringsKt.isBlank(r16)) == false) goto L18;
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r0.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        com.obric.cae.utils.c r2 = com.obric.cae.utils.c.f7367a;     // Catch: Throwable -> L19
        Intrinsics.checkNotNullExpressionValue(r1, "contextToUse");     // Catch: Throwable -> L19
        r2.a(r1, AI_KERNEL_PRODUCT_ID);     // Catch: Throwable -> L19
        AIKernelConfig r3 = new AIKernelConfig.Builder(r1).appId(AI_KERNEL_PRODUCT_ID).build();     // Catch: Throwable -> L19
        com.obric.aikernel.runtime.d r14 = new com.obric.aikernel.runtime.d(r1, "941134", r16, r17, r18, new c(r1, null), null, false, 192, null);     // Catch: Throwable -> L19
        r14.a(false);     // Catch: Throwable -> L19
        r14.a(d.f7332a);     // Catch: Throwable -> L19
        r14.b(com.obric.aikernel.runtime.d.f6193a.b());     // Catch: Throwable -> L19
        r14.a(b.f7330a);     // Catch: Throwable -> L19
        r14.a(CollectionsKt.listOf(TuplesKt.to("ScriptEngine", PythonScriptEngineBridge.INSTANCE)));     // Catch: Throwable -> L19
        AIInferRuntime.d r11 = r14.a();     // Catch: Throwable -> L19
        com.obric.aikernel.runtime.a.C0275a.a(com.obric.aikernel.runtime.a.f6185a, r11, r3, a.f7329a, null, null, 24, null);     // Catch: Throwable -> L19
        CaeCoreBridgeApi r4 = new CaeCoreBridgeApi(r1);     // Catch: Throwable -> L19
        CaeLocationBridgeApi r5 = new CaeLocationBridgeApi(r1);     // Catch: Throwable -> L19
        com.obric.cae.utils.bridge.a r6 = com.obric.cae.utils.bridge.a.f7363a;     // Catch: Throwable -> L14
        r6.a(CORE_MODULE, r4);     // Catch: Throwable -> L14
        r6.a("location", r5);     // Catch: Throwable -> L14
        runtime = new AIInferRuntime(r11);     // Catch: Throwable -> L14
        monitor-exit(AIKernelPythonBridge.class);
        return;
    L14:
        th = move-exception;
        com.obric.cae.utils.bridge.a r7 = com.obric.cae.utils.bridge.a.f7363a;     // Catch: Throwable -> L19
        r7.b(CORE_MODULE, r4);     // Catch: Throwable -> L19
        r7.b("location", r5);     // Catch: Throwable -> L19
        throw th;     // Catch: Throwable -> L19
    L18:
        throw new IllegalArgumentException("projectId must not be blank".toString());     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ void init$default(Context r1, String r2, String r3, String r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        if ((r5 & 4) == 0) goto L6;
        r3 = BuildConfig.LIB_VERSION;
    L6:
        if ((r5 & 8) == 0) goto L8;
        r4 = "cae_release";
    L8:
        init(r7, r2, r3, r4);
    }

    @JvmStatic
    public static final void loadPackageAsync(String r7, com.obric.cae.utils.e r8) {
        com.obric.cae.utils.e r9 = (com.obric.cae.utils.e) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.cae.utils.e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r9, "callback");
        i.a(scope, null, null, new e(r7, r9, null), 3, null);
    }

    @JvmStatic
    public static final void loadPackageWithResourceAsync(String r7, com.obric.cae.utils.f r8) {
        com.obric.cae.utils.f r9 = (com.obric.cae.utils.f) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.cae.utils.f.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r9, "callback");
        i.a(scope, null, null, new f(r7, r9, null), 3, null);
    }

    @JvmStatic
    public static final void registerModule(String r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "module");
        Intrinsics.checkNotNullParameter(r2, TypedValues.AttributesType.S_TARGET);
        if (Intrinsics.areEqual(r1, CORE_MODULE) == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L12;
        com.obric.cae.utils.bridge.a.f7363a.a(r1, r2);
        return;
    L12:
        throw new IllegalArgumentException(("Bridge module " + r1 + " is reserved").toString());
    L5:
        if (Intrinsics.areEqual(r1, "location") == true) goto L7;
        r0 = true;
        goto L8
    }

    private final AIInferRuntime requireRuntime() {
        AIInferRuntime r1 = runtime;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("AIKernelPythonBridge.init(context) must be called before using Python packages");
    }

    @JvmStatic
    public static final Object runPackage(String r8, RequestParams r9, String r10, Function1<? super Bundle, Unit> r11, Continuation<? super Unit> r12) {
        Function1<? super Bundle, Unit> r6 = (Function1) ZeusTransformUtils.wrapperContextForParams(r11, Function1.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        Object r13 = INSTANCE.requireRuntime().a(r8, r9, r10, r6, r7);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Object runPackage$default(String r1, RequestParams r2, String r3, Function1 r4, Continuation r5, int r6, Object r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r4, Function1.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        if ((r6 & 4) == 0) goto L6;
        r3 = "";
    L6:
        return runPackage(r1, r2, r3, r8, r9);
    }

    @JvmStatic
    public static final void runPackageAsync(String r6, Bundle r7, PythonPackageCallback r8) {
        PythonPackageCallback r2 = (PythonPackageCallback) ZeusTransformUtils.wrapperContextForParams(r8, PythonPackageCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r7, "input");
        Intrinsics.checkNotNullParameter(r2, "callback");
        runPackageAsync$default(r6, r7, r2, null, 8, null);
    }

    @JvmStatic
    public static final void runPackageAsync(String r7, Bundle r8, PythonPackageCallback r9, String r10) {
        PythonPackageCallback r11 = (PythonPackageCallback) ZeusTransformUtils.wrapperContextForParams(r9, PythonPackageCallback.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r8, "input");
        Intrinsics.checkNotNullParameter(r11, "callback");
        Intrinsics.checkNotNullParameter(r10, "event");
        i.a(scope, null, null, new g(r7, r8, r11, null), 3, null);
    }

    public static /* synthetic */ void runPackageAsync$default(String r1, Bundle r2, PythonPackageCallback r3, String r4, int r5, Object r6) {
        PythonPackageCallback r7 = (PythonPackageCallback) ZeusTransformUtils.wrapperContextForParams(r3, PythonPackageCallback.class, "com.obric.memorydata.plugin");
        if ((r5 & 8) == 0) goto L5;
        r4 = "";
    L5:
        runPackageAsync(r1, r2, r7, r4);
    }

    @JvmStatic
    public static final void unloadPackageAsync(String r7, com.obric.cae.utils.e r8) {
        com.obric.cae.utils.e r9 = (com.obric.cae.utils.e) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.cae.utils.e.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r9, "callback");
        i.a(scope, null, null, new h(r7, r9, null), 3, null);
    }

    @JvmStatic
    public static final boolean unregisterModule(String r1, Object r2) {
        Intrinsics.checkNotNullParameter(r1, "module");
        Intrinsics.checkNotNullParameter(r2, TypedValues.AttributesType.S_TARGET);
        return com.obric.cae.utils.bridge.a.f7363a.b(r1, r2);
    }

    @JvmStatic
    public static final Object updatePackage(String r8, Continuation<? super PackageResource> r9) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        return AIInferRuntime.a(INSTANCE.requireRuntime(), r8, "cae", false, null, r5, 12, null);
    }
}
