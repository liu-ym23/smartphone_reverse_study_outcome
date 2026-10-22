package com.obric.memorydata.init.tasks;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.lego.init.model.IInitTask;
import com.obric.aiproactive.api.ae;
import com.obric.aiproactive.impl.bridge.AiProactiveAgentBridgeImpl;
import com.obric.aiproactive.impl.livecard.n;
import com.obric.aiproactive.impl.runtime.ProactiveRecommendationEnabledStoreImpl;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.bx;
import kotlinx.coroutines.cu;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000[\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u000f\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u000e\u0010\u0016\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/memorydata/init/tasks/AIProactiveAgentInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "syncJobLock", "", "syncJob", "Lkotlinx/coroutines/Job;", "lockScreenSyncManager", "Lcom/obric/aiproactive/impl/livecard/AiProactiveLockScreenSyncManager;", "initLifecycle", "Lcom/obric/memorydata/init/tasks/AiProactiveInitLifecycle;", "proactiveAgentObserver", "com/obric/memorydata/init/tasks/AIProactiveAgentInitTask$proactiveAgentObserver$1", "Lcom/obric/memorydata/init/tasks/AIProactiveAgentInitTask$proactiveAgentObserver$1;", "recommendationEnabledListener", "Lcom/obric/aiproactive/api/ProactiveRecommendationEnabledListener;", "run", "", "scheduleSyncProactiveAgentState", "syncProactiveAgentState", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isComponentInstalled", "", "packageManager", "Landroid/content/pm/PackageManager;", "component", "Landroid/content/ComponentName;", "queryProactiveAgentEnabled", "context", "Landroid/content/Context;", "Companion", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AIProactiveAgentInitTask extends IInitTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9886a = null;
    private static final List<String> i = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final al f9887b;
    private final Object c;
    private bx d;
    private final com.obric.aiproactive.impl.livecard.e e;
    private final com.obric.memorydata.init.tasks.b f;
    private final b g;
    private final ae h;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/init/tasks/AIProactiveAgentInitTask$Companion;", "", "<init>", "()V", "TAG", "", "STATUS_ENABLED", "", "PROACTIVE_LAUNCHER_COMPONENTS", "", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/obric/memorydata/init/tasks/AIProactiveAgentInitTask$proactiveAgentObserver$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "uri", "Landroid/net/Uri;", "ai_proactive_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AIProactiveAgentInitTask f9888a;

        b(AIProactiveAgentInitTask r1, Handler r2) {
            this.f9888a = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r8, Uri r9) {
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveAgentInitTask", "onChange proactiveAgentObserver selfChange=" + r8 + " uri=" + r9, false, 4, null);
            AIProactiveAgentInitTask.c(this.f9888a);
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.init.tasks.AIProactiveAgentInitTask$run$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.init.tasks.AIProactiveAgentInitTask$run$1", f = "AIProactiveAgentInitTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> r3) {
            super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
            return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r1) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r1);
            com.obric.aiproactive.impl.runtime.c.f6509a.a();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        f9886a = new a(null);
        i = CollectionsKt.listOf("com.obric.aiproactive.ui.ProactiveStartupActivity");
    }

    public AIProactiveAgentInitTask() {
        this.f9887b = am.a(cu.a(null, 1, null).plus((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.b().a(), CoroutineContext.class, "com.obric.memorydata.plugin")));
        this.c = new Object();
        this.e = new com.obric.aiproactive.impl.livecard.e(null, null, null, 7, null);
        this.f = new com.obric.memorydata.init.tasks.b((Function1) ZeusTransformUtils.preCheckCast(new AIProactiveAgentInitTask$initLifecycle$1(null), Function1.class, "com.obric.memorydata.plugin"), (Function0) ZeusTransformUtils.preCheckCast(new AIProactiveAgentInitTask$initLifecycle$2(ProactiveRecommendationEnabledStoreImpl.INSTANCE), Function0.class, "com.obric.memorydata.plugin"), (Function1) ZeusTransformUtils.preCheckCast(new AIProactiveAgentInitTask$initLifecycle$3(this, null), Function1.class, "com.obric.memorydata.plugin"));
        this.g = new b(this, new Handler(Looper.getMainLooper()));
        this.h = new $$Lambda$AIProactiveAgentInitTask$kdC5hdI2uzpZcuqq2PuxtpXff4(this);
    }

    public static final /* synthetic */ com.obric.memorydata.init.tasks.b a(AIProactiveAgentInitTask r0) {
        return r0.f;
    }

    public static final /* synthetic */ Object a(AIProactiveAgentInitTask r2, Continuation r3) {
        return r2.a((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(Continuation<? super Unit> r19) {
        Continuation r3 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r19, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r3, AIProactiveAgentInitTask$syncProactiveAgentState$1.class) == false) goto L7;
        AIProactiveAgentInitTask$syncProactiveAgentState$1 r5 = (AIProactiveAgentInitTask$syncProactiveAgentState$1) ZeusTransformUtils.preCheckCast(r3, AIProactiveAgentInitTask$syncProactiveAgentState$1.class, "com.obric.memorydata.plugin");
        if ((r5.label & Integer.MIN_VALUE) == 0) goto L7;
        r5.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r5.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r5.label;
        if (r7 == 0) goto L14;
        if (r7 != 1) goto L13;
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(r5.L$1, Context.class, "com.obric.memorydata.plugin");
        AIProactiveAgentInitTask r8 = (AIProactiveAgentInitTask) ZeusTransformUtils.preCheckCast(r5.L$0, AIProactiveAgentInitTask.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        Object r17 = r4;
        Context r9 = r0;
    L18:
        boolean r1 = ((Boolean) ZeusTransformUtils.preCheckCast(r17, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveAgentInitTask", "syncProactiveAgentState queried enabled=" + r1, false, 4, null);
        ProactiveRecommendationEnabledStoreImpl.INSTANCE.updateProactiveAgentEnabled(r1);
        if (r1 == true) goto L21;
        r8.e.b();
    L21:
        if (r1 == false) goto L23;
        int r10 = 1;
    L24:
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(i, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L26:
        if (r11.hasNext() == false) goto L43;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r11.next(), String.class, "com.obric.memorydata.plugin");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L37
        AIProactiveAgentInitTask r13 = (AIProactiveAgentInitTask) ZeusTransformUtils.preCheckCast(r8, AIProactiveAgentInitTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L37
        ComponentName r14 = new ComponentName(r9.getPackageName(), r12);     // Catch: Throwable -> L37
        PackageManager r15 = r9.getPackageManager();     // Catch: Throwable -> L37
        Intrinsics.checkNotNullExpressionValue(r15, "getPackageManager(...)");     // Catch: Throwable -> L37
        if (r13.a(r15, r14) == false) goto L30;
        int r16 = r9.getPackageManager().getComponentEnabledSetting(r14);     // Catch: Throwable -> L37
        RunLog.INSTANCE.debug("ProactiveAgentInitTask", "syncProactiveAppIcon check " + r12 + " current=" + r16 + " target=" + r10);     // Catch: Throwable -> L37
        if (r16 == r10) goto L34;
        ZeusTransformUtils.setComponentEnabledSetting(r9.getPackageManager(), r14, r10, 1);     // Catch: Throwable -> L37
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveAgentInitTask", "syncProactiveAppIcon: " + r12 + " -> " + r10, false, 4, null);     // Catch: Throwable -> L37
    L35:
        Object r18 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L37
    L39:
        Throwable r20 = Result.m1424exceptionOrNullimpl(r18);
        if (r20 == null) goto L26;
        RunLog.INSTANCE.warn("ProactiveAgentInitTask", "syncProactiveAppIcon failed for " + r12, r20);
        goto L26
    L34:
        RunLog.INSTANCE.debug("ProactiveAgentInitTask", "syncProactiveAppIcon noop " + r12);     // Catch: Throwable -> L37
        goto L35
    L30:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveAgentInitTask", "syncProactiveAppIcon skip missing component=" + r14, false, 4, null);     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r18 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L39
    L43:
        return Unit.INSTANCE;
    L23:
        r10 = 2;
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r4);
        r9 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        CoroutineContext r21 = (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r22 = (Function2) ZeusTransformUtils.preCheckCast(new AIProactiveAgentInitTask$syncProactiveAgentState$enabled$1(this, r9, null), Function2.class, "com.obric.memorydata.plugin");
        r5.L$0 = this;
        r5.L$1 = r9;
        r5.label = 1;
        Object r23 = i.a(r21, r22, r5);
        if (r23 != r6) goto L17;
        return r6;
    L17:
        r17 = r23;
        r8 = this;
    L7:
        r5 = new AIProactiveAgentInitTask$syncProactiveAgentState$1(this, r3);
        goto L8
    }

    private final void a() {
        Object r0 = this.c;
        monitor-enter(r0);
        bx r1 = this.d;     // Catch: Throwable -> L15
        boolean r2 = false;
        if (r1 != null) goto L7;
    L9:
        bx r3 = this.d;     // Catch: Throwable -> L15
        if (r3 == null) goto L12;
        bx.a.a(r3, null, 1, null);     // Catch: Throwable -> L15
    L12:
        RunLog.INSTANCE.debug("ProactiveAgentInitTask", "scheduleSyncProactiveAgentState cancelOld=" + r2);     // Catch: Throwable -> L15
        this.d = i.a(this.f9887b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AIProactiveAgentInitTask$scheduleSyncProactiveAgentState$1$1(this, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);     // Catch: Throwable -> L15
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r0);
        return;
    L7:
        if (r1.a() != true) goto L9;
        r2 = true;
    L15:
        th = move-exception;
        throw th;
    }

    private static final void a(AIProactiveAgentInitTask r9, boolean r10) {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveAgentInitTask", "onRecommendationEnabledChanged enabled=" + r10, false, 4, null);
        if (r10 == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveAgentInitTask", "stopAiProactiveEcaListening completed stopped=" + AiProactiveAgentBridgeImpl.INSTANCE.stopAiProactiveEcaListening(), false, 4, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveAgentInitTask", "stopSpellProactiveEcaListening completed stopped=" + AiProactiveAgentBridgeImpl.INSTANCE.stopSpellProactiveEcaListening(), false, 4, null);
        r9.e.b();
    L6:
        if (ProactiveRecommendationEnabledStoreImpl.INSTANCE.isDbPreparationEligible() == true) goto L8;
        return;
    L8:
        i.a(r9.f9887b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new AIProactiveAgentInitTask$recommendationEnabledListener$1$1(r9, r10, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private final boolean a(Context r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r12, Context.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.debug("ProactiveAgentInitTask", "queryProactiveAgentEnabled begin uri=content://com.obric.memorydata.memory.ailabprovider/ai_proactive_agent");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L29
        AIProactiveAgentInitTask r11 = (AIProactiveAgentInitTask) ZeusTransformUtils.preCheckCast(this, AIProactiveAgentInitTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        Cursor r14 = ZeusProviderTransform.query(r13.getContentResolver(), Uri.parse("content://com.obric.memorydata.memory.ailabprovider/ai_proactive_agent"), null, null, null, null, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        if (r14 == null) goto L26;
        Closeable r15 = (Closeable) ZeusTransformUtils.preCheckCast(r14, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        Cursor r4 = (Cursor) ZeusTransformUtils.preCheckCast(r15, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r4.moveToFirst() == true) goto L11;
        IRunLog r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        String r6 = "ProactiveAgentInitTask";
        String r7 = "queryProactiveAgentEnabled emptyCursor";
    L10:
        IRunLog.a.a(r5, r6, r7, null, 4, null);     // Catch: Throwable -> L21
        boolean r8 = false;
    L19:
        CloseableKt.closeFinally(r15, null);     // Catch: Throwable -> L29
    L27:
        Object r16 = Result.m1421constructorimpl(Boolean.valueOf(r8));     // Catch: Throwable -> L29
    L31:
        Throwable r17 = Result.m1424exceptionOrNullimpl(r16);
        if (r17 == null) goto L36;
        RunLog.INSTANCE.warn("ProactiveAgentInitTask", "queryProactiveAgentEnabled failed", r17);
        r16 = false;
    L36:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r16, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L11:
        int r9 = r4.getColumnIndex("status");     // Catch: Throwable -> L21
        if (r9 >= 0) goto L14;
        r5 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        r6 = "ProactiveAgentInitTask";
        r7 = "queryProactiveAgentEnabled missingColumn status";
        goto L10
    L14:
        int r10 = r4.getInt(r9);     // Catch: Throwable -> L21
        r8 = true;
        if (r10 == 1) goto L18;
        r8 = false;
    L18:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveAgentInitTask", "queryProactiveAgentEnabled " + r8, false, 4, null);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L26:
        r8 = false;
    L29:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r16 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L31
    }

    private final boolean a(PackageManager r8, ComponentName r9) {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        AIProactiveAgentInitTask r7 = (AIProactiveAgentInitTask) ZeusTransformUtils.preCheckCast(this, AIProactiveAgentInitTask.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        r8.getActivityInfo(r9, PackageManager.ComponentInfoFlags.of(512));     // Catch: Throwable -> L5
        Object r10 = Result.m1421constructorimpl(true);     // Catch: Throwable -> L5
    L8:
        if (Result.m1424exceptionOrNullimpl(r10) == null) goto L12;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveAgentInitTask", "isComponentInstalled missing component=" + r9, false, 4, null);
        r10 = false;
    L12:
        return ((Boolean) ZeusTransformUtils.preCheckCast(r10, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L5:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public static final /* synthetic */ boolean a(AIProactiveAgentInitTask r2, Context r3) {
        return r2.a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ com.obric.aiproactive.impl.livecard.e b(AIProactiveAgentInitTask r0) {
        return r0.e;
    }

    public static final /* synthetic */ void c(AIProactiveAgentInitTask r0) {
        r0.a();
    }

    /* JADX INFO: renamed from: lambda$kdC5hdI2uzpZcuqq2Puxtp-Xff4, reason: not valid java name */
    public static /* synthetic */ void m663lambda$kdC5hdI2uzpZcuqq2PuxtpXff4(AIProactiveAgentInitTask r0, boolean r1) {
        a(r0, r1);
    }

    @Override // java.lang.Runnable
    public void run() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveAgentInitTask", "run start", false, 4, null);
        com.obric.aiproactive.impl.progress.c.f6499a.a();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveAgentInitTask", "run initEventsTaskSdk success=" + com.obric.aiproactive.impl.assistant.a.f6389a.a((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getApplication(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")), false, 4, null);
        ProactiveRecommendationEnabledStoreImpl.INSTANCE.start();
        ProactiveRecommendationEnabledStoreImpl.INSTANCE.registerListener(this.h, true);
        n.f6478a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        ZeusProviderTransform.registerContentObserver(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), Uri.parse("content://com.obric.memorydata.memory.ailabprovider/ai_proactive_agent"), false, (ContentObserver) ZeusTransformUtils.preCheckCast(this.g, ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ProactiveAgentInitTask", "run registeredObserver uri=content://com.obric.memorydata.memory.ailabprovider/ai_proactive_agent", false, 4, null);
        a();
        i.a(this.f9887b, (CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin"), null, (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass1(null), Function2.class, "com.obric.memorydata.plugin"), 2, null);
    }
}
