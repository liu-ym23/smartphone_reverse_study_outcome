package com.obric.aikernel.runtime;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aikernel.core.log.ILog;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.aikernel.sdk.config.RequestParams;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.AbstractCoroutineContextElement;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.ak;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u001f\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b\u000fJ2\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u0005\u001a$\u0012\u0004\u0012\u00020\u0007\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n0\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/obric/aikernel/runtime/AIKernelModelProxy;", "Lcom/obric/aikernel/res/metadata/data/dynamic/IDynamicResourceProxy;", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "stateCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Pair;", "", "Lkotlinx/coroutines/Deferred;", "Lcom/obric/aikernel/sdk/data/PackageResource;", "buildCacheKey", "bizName", Params.LORA_TYPE, "buildCacheKey$sdk_pyvm_release", "checkIsAvail", "type", ActivityLifecycle.NAME, "version", "requestParams", "Lcom/obric/aikernel/sdk/config/RequestParams;", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "Companion", "sdk_pyvm_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public class a implements com.obric.aikernel.res.metadata.data.a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0275a f6185a = null;
    private static final long d = 0;
    private static Lazy<Unit> e;
    private static long f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final al f6186b;
    private final ConcurrentHashMap<String, Pair<Boolean, ar<PackageResource>>> c;

    /* JADX INFO: renamed from: com.obric.aikernel.runtime.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J;\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/obric/aikernel/runtime/AIKernelModelProxy$Companion;", "", "()V", "CACHE_INTERVAL", "", "TAG", "", "waitSdkInit", "Lkotlin/Lazy;", "", "waitTimeout", "registerAIKernelProxy", "Lcom/obric/aikernel/res/metadata/data/dynamic/IDynamicResourceProxy;", "rtConfig", "Lcom/obric/aikernel/runtime/AIInferRuntime$Config;", "config", "Lcom/obric/aikernel/sdk/AIKernelConfig;", "logger", "Lcom/obric/aikernel/core/log/ILog;", "proxy", "Lcom/obric/aikernel/runtime/AIKernelModelProxy;", LocationMonitorConst.TIMEOUT, "(Lcom/obric/aikernel/runtime/AIInferRuntime$Config;Lcom/obric/aikernel/sdk/AIKernelConfig;Lcom/obric/aikernel/core/log/ILog;Lcom/obric/aikernel/runtime/AIKernelModelProxy;Ljava/lang/Long;)Lcom/obric/aikernel/res/metadata/data/dynamic/IDynamicResourceProxy;", "sdk_pyvm_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class C0275a {
        private C0275a() {
        }

        public /* synthetic */ C0275a(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ com.obric.aikernel.res.metadata.data.a.c a(C0275a r6, AIInferRuntime.d r7, AIKernelConfig r8, ILog r9, a r10, Long r11, int r12, Object r13) {
            ILog r3 = (ILog) ZeusTransformUtils.wrapperContextForParams(r9, ILog.class, "com.obric.memorydata.plugin");
            if ((r12 & 8) == 0) goto L5;
            r10 = new a();
        L5:
            a r4 = r10;
            if ((r12 & 16) == 0) goto L9;
            r11 = null;
        L9:
            return r6.a(r7, r8, r3, r4, r11);
        }

        public final com.obric.aikernel.res.metadata.data.a.c a(AIInferRuntime.d r4, final AIKernelConfig r5, ILog r6, a r7, Long r8) {
            final ILog r3 = (ILog) ZeusTransformUtils.wrapperContextForParams(r6, ILog.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r4, "rtConfig");
            Intrinsics.checkNotNullParameter(r3, "logger");
            Intrinsics.checkNotNullParameter(r7, "proxy");
            r4.g().setUseAIKernelModel(true);
            r4.g().setDynamicResProxy((com.obric.aikernel.res.metadata.data.a.c) ZeusTransformUtils.preCheckCast(r7, com.obric.aikernel.res.metadata.data.a.c.class, "com.obric.memorydata.plugin"));
            if (r8 == null) goto L5;
            long r1 = ((Number) ZeusTransformUtils.preCheckCast(r8, Number.class, "com.obric.memorydata.plugin")).longValue();
            C0275a r9 = a.f6185a;
            a.a(r1);
        L5:
            a.b(r7);
            if (r5 == null) goto L9;
            C0275a r10 = a.f6185a;
            a.a(LazyKt.lazy((Function0) ZeusTransformUtils.preCheckCast(new AIKernelModelProxy$Companion$registerAIKernelProxy$2$1(r5, r3), Function0.class, "com.obric.memorydata.plugin")));
        L9:
            return (com.obric.aikernel.res.metadata.data.a.c) ZeusTransformUtils.preCheckCast(r7, com.obric.aikernel.res.metadata.data.a.c.class, "com.obric.memorydata.plugin");
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b extends AbstractCoroutineContextElement implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.a r3) {
            super((CoroutineContext.Key) ZeusTransformUtils.preCheckCast(r3, CoroutineContext.Key.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlinx.coroutines.CoroutineExceptionHandler
        public void handleException(CoroutineContext r3, Throwable r4) {
            com.obric.aikernel.runtime.utils.d.f6216a.g("AIKernelModelProxy", "crashed " + ((CoroutineContext) ZeusTransformUtils.wrapperContextForParams(r3, CoroutineContext.class, "com.obric.memorydata.plugin")) + ' ' + r4);
        }
    }

    static {
        f6185a = new C0275a(null);
        Duration.Companion r0 = Duration.Companion;
        d = Duration.m2793toLongimpl(DurationKt.toDuration(30, DurationUnit.MINUTES), DurationUnit.MILLISECONDS);
        f = 60000;
    }

    public a() {
        this.f6186b = am.a(ba.c().plus((CoroutineContext) ZeusTransformUtils.preCheckCast(new ak("AIKernelModelProxy"), CoroutineContext.class, "com.obric.memorydata.plugin")).plus((CoroutineContext) ZeusTransformUtils.preCheckCast((CoroutineExceptionHandler) ZeusTransformUtils.preCheckCast(new b(CoroutineExceptionHandler.f17198b), CoroutineExceptionHandler.class, "com.obric.memorydata.plugin"), CoroutineContext.class, "com.obric.memorydata.plugin")));
        this.c = new ConcurrentHashMap();
    }

    public static final /* synthetic */ long a() {
        return d;
    }

    public static final /* synthetic */ ConcurrentHashMap a(a r0) {
        return r0.c;
    }

    public static final /* synthetic */ void a(long r0) {
        f = r0;
    }

    public static final /* synthetic */ void a(Lazy r2) {
        e = (Lazy) ZeusTransformUtils.wrapperContextForParams(r2, Lazy.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ long b() {
        return f;
    }

    public static final /* synthetic */ void b(a r0) {
        r0.c();
    }

    private final void c() {
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new AIKernelModelProxy$init$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final String a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "bizName");
        StringBuilder r0 = new StringBuilder().append(r1).append('|');
        if (r2 != null) goto L6;
        r2 = "";
    L6:
        return r0.append(r2).toString();
    }

    @Override // com.obric.aikernel.res.metadata.data.a.c
    public boolean a(String r21, String r22, String r23, RequestParams r24, String r25) {
        Intrinsics.checkNotNullParameter(r21, "type");
        Intrinsics.checkNotNullParameter(r22, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r23, "version");
        Intrinsics.checkNotNullParameter(r24, "requestParams");
        Lazy<Unit> r1 = e;
        if (r1 == null) goto L5;
        r1.getValue();
    L5:
        String r9 = a(r22, r25);
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(this.c.get(r9), Pair.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L8;
    L10:
        boolean r3 = false;
    L11:
        if (r3 == false) goto L13;
        return true;
    L13:
        Pair r4 = (Pair) ZeusTransformUtils.preCheckCast(this.c.get(r9), Pair.class, "com.obric.memorydata.plugin");
        Boolean r12 = null;
        if (r4 == null) goto L16;
        ar r5 = (ar) ZeusTransformUtils.preCheckCast(r4.getSecond(), ar.class, "com.obric.memorydata.plugin");
    L17:
        if (r5 == null) goto L21;
        if (r5.a() == false) goto L21;
    L33:
        i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new AIKernelModelProxy$checkIsAvail$1(r5, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        com.obric.aikernel.runtime.utils.d r6 = com.obric.aikernel.runtime.utils.d.f6216a;
        StringBuilder r7 = new StringBuilder().append("checkIsAvail: ").append(r22).append(" lora:").append(r25).append(' ');
        Pair r8 = (Pair) ZeusTransformUtils.preCheckCast(this.c.get(r9), Pair.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L36;
        r12 = (Boolean) ZeusTransformUtils.preCheckCast(r8.getFirst(), Boolean.class, "com.obric.memorydata.plugin");
    L36:
        r6.e("AIKernelModelProxy", r7.append(r12).toString());
        Pair r0 = (Pair) ZeusTransformUtils.preCheckCast(this.c.get(r9), Pair.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L39;
        return false;
    L39:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r0.getFirst(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == true) goto L41;
        return false;
    L41:
        return true;
    L21:
        monitor-enter(a.class);
        Pair r10 = (Pair) ZeusTransformUtils.preCheckCast(this.c.get(r9), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
        if (r10 == null) goto L25;
        r5 = (ar) ZeusTransformUtils.preCheckCast(r10.getSecond(), ar.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L42
    L26:
        if (r5 != null) goto L28;
    L29:
        r5 = i.b(this.f6186b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AIKernelModelProxy$checkIsAvail$task$1$1(r22, r24, this, r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L42
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIKernelModelProxy", "checkIsAvail: " + r22 + " start check task " + r5);     // Catch: Throwable -> L42
        if (this.c.get(r9) != null) goto L32;
        ((Map) ZeusTransformUtils.preCheckCast(this.c, Map.class, "com.obric.memorydata.plugin")).put(r9, new Pair(false, r5));     // Catch: Throwable -> L42
    L32:
        monitor-exit(a.class);
        goto L33
    L28:
        if (r5.a() == true) goto L32;
    L25:
        r5 = null;
    L42:
        th = move-exception;
        throw th;
    L16:
        r5 = null;
        goto L17
    L8:
        if (((Boolean) ZeusTransformUtils.preCheckCast(r2.getFirst(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue() != true) goto L10;
        r3 = true;
        goto L11
    }
}
