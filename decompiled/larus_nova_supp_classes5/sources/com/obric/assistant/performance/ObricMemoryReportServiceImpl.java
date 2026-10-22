package com.obric.assistant.performance;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ObricMemoryReportConfig;
import com.obric.assistant.t1;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0019\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\u0005H\u0002J\b\u0010$\u001a\u00020\u001cH\u0002J\u0018\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u00122\u0006\u0010'\u001a\u00020(H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006*"}, d2 = {"Lcom/obric/assistant/performance/ObricMemoryReportServiceImpl;", "Lcom/obric/assistant/performance/IObricMemoryReportService;", "<init>", "()V", "bootTime", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isBackground", "", "()Z", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "config", "Lcom/obric/assistant/ObricMemoryReportConfig;", "currentScene", "", "reportUptime5minJob", "Lkotlinx/coroutines/Job;", "needReportHeapUptime5min", "needReportPssUptime5min", "needReportMemoryInfoUptime5min", "onBackgroundListener", "com/obric/assistant/performance/ObricMemoryReportServiceImpl$onBackgroundListener$1", "Lcom/obric/assistant/performance/ObricMemoryReportServiceImpl$onBackgroundListener$1;", "init", "", "changeScene", "scene", "onStateChange", "loopReportHeap", "intervalMs", "loopReportPss", "loopReportMemoryInfo", "timingReportUptime5min", "reportAsync", "eventName", "json", "Lorg/json/JSONObject;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricMemoryReportServiceImpl implements IObricMemoryReportService {
    public static final /* synthetic */ int j = 0;
    public final CoroutineScope b;
    public ObricMemoryReportConfig c;
    public String d;
    public Job e;
    public boolean f;
    public boolean g;
    public boolean h;
    public final b i;

    public static final class b implements f09.a.b {
        public final /* synthetic */ ObricMemoryReportServiceImpl a;

        public final void onAllActivityDestroyed() {
        }

        public final void onAppBackground() {
        }

        public final void onAppForeground() {
            FLogger.a.i("ObricMemoryReportService", "onAppForeground, cancel job");
            Job r0 = this.a.e;
            if (r0 == null) goto L5;
            Job.DefaultImpls.cancel$default(r0, null, 1, null);
        L5:
            AppHost.a.a().c(this);
            ObricMemoryReportServiceImpl r1 = this.a;
            r1.f = false;
            r1.g = false;
            r1.h = false;
        }

        public b(ObricMemoryReportServiceImpl r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.performance.ObricMemoryReportServiceImpl$init$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.performance.ObricMemoryReportServiceImpl$init$1", f = "ObricMemoryReportServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ObricMemoryReportServiceImpl this$0;

        public AnonymousClass1(ObricMemoryReportServiceImpl r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r21) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L36;
            ResultKt.throwOnFailure(r21);
            this.this$0.c = t1.a.getObricMemoryReportConfig();     // Catch: Exception -> L31
            ObricMemoryReportConfig r3 = this.this$0.c;     // Catch: Exception -> L31
            if (r3 != null) goto L8;
            r3 = new ObricMemoryReportConfig(false, false, 0, false, 0, false, 0, false, KotlinVersion.MAX_COMPONENT_VALUE, null);     // Catch: Exception -> L31
        L8:
            FLogger r4 = FLogger.a;     // Catch: Exception -> L31
            r4.d("ObricMemoryReportService", "init, config: " + r3 + ", local default: " + new ObricMemoryReportConfig(false, false, 0, false, 0, false, 0, false, KotlinVersion.MAX_COMPONENT_VALUE, null));     // Catch: Exception -> L31
            if (r3.isMemoryReportEnabled() == false) goto L34;
            if (r3.getEnableBackgroundUptime5min() == false) goto L18;
            this.this$0.getClass();     // Catch: Exception -> L31
            AppHost.Companion r0 = AppHost.a;     // Catch: Exception -> L31
            if (r0.a().isAppBackground() == false) goto L18;
            r0.a().j(this.this$0.i);     // Catch: Exception -> L31
            ObricMemoryReportServiceImpl r1 = this.this$0;     // Catch: Exception -> L31
            Job r5 = r1.e;     // Catch: Exception -> L31
            if (r5 == null) goto L17;
            Job.DefaultImpls.cancel$default(r5, null, 1, null);     // Catch: Exception -> L31
        L17:
            r1.e = BuildersKt.launch$default(r1.b, null, null, new ObricMemoryReportServiceImpl$timingReportUptime5min$1(r1, null), 3, null);     // Catch: Exception -> L31
        L22:
            if (r3.getEnableHeapSample() == false) goto L25;
            ObricMemoryReportServiceImpl r2 = this.this$0;     // Catch: Exception -> L31
            BuildersKt.launch$default(r2.b, null, null, new ObricMemoryReportServiceImpl$loopReportHeap$1(r3.getHeapIntervalMs(), r2, null), 3, null);     // Catch: Exception -> L31
        L25:
            if (r3.getEnableTotalPssSample() == false) goto L28;
            ObricMemoryReportServiceImpl r6 = this.this$0;     // Catch: Exception -> L31
            BuildersKt.launch$default(r6.b, null, null, new ObricMemoryReportServiceImpl$loopReportPss$1(r3.getTotalPssIntervalMs(), r6, null), 3, null);     // Catch: Exception -> L31
        L28:
            if (r3.getEnableMemoryStatsSample() == false) goto L34;
            ObricMemoryReportServiceImpl r7 = this.this$0;     // Catch: Exception -> L31
            BuildersKt.launch$default(r7.b, null, null, new ObricMemoryReportServiceImpl$loopReportMemoryInfo$1(r3.getMemoryStatsIntervalMs(), r7, null), 3, null);     // Catch: Exception -> L31
        L18:
            r4.i("ObricMemoryReportService", "start with foreground or disable 5min report, cancel timingReportUptime5min");     // Catch: Exception -> L31
            Job r8 = this.this$0.e;     // Catch: Exception -> L31
            if (r8 == null) goto L22;
            Job.DefaultImpls.cancel$default(r8, null, 1, null);     // Catch: Exception -> L31
        L34:
            return Unit.INSTANCE;
        L31:
            e = move-exception;
            FLogger.a.e("ObricMemoryReportService", "memory report error: " + e);
            goto L34
        L36:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final void init() {
        BuildersKt.launch$default(this.b, null, null, new AnonymousClass1(this, null), 3, null);
    }

    public ObricMemoryReportServiceImpl() {
        System.currentTimeMillis();
        this.b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.d = "";
        this.i = new b(this);
    }

    public final void a(String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "scene");
        if (r5 == true) goto L5;
    L11:
        FLogger.a.i("ObricMemoryReportService", "changeScene: " + r4 + ", last: " + this.d);
        this.d = r4;
        return;
    L5:
        if (this.d.length() != 0) goto L7;
        boolean r6 = true;
    L8:
        if (r6 == false) goto L11;
        FLogger.a.i("ObricMemoryReportService", "current scene is empty, ignore state change");
        return;
    L7:
        r6 = false;
        goto L8
    }

    public static final void b(ObricMemoryReportServiceImpl r6, String r7, JSONObject r8) {
        BuildersKt.launch$default(r6.b, null, null, new ObricMemoryReportServiceImpl$reportAsync$1(r8, r7, r6, null), 3, null);
    }
}
