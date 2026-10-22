package com.obric.capability.schedulekit;

import android.app.Application;
import androidx.core.app.NotificationCompat;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.common.ICapabilityFeedbackReceiver;
import com.obric.capabilitykit.common.intent.AppIntentImplInfo;
import com.obric.capabilitykit.common.intent.IntentParams;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bo;
import kotlinx.coroutines.n;
import kotlinx.coroutines.o;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002HIB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0015\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0012H\u0002J\u0016\u0010\u0019\u001a\u00020\r2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0002Jg\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010$\u001a\u00020\u000f2\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040&H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010'Jg\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010(\u001a\u00020\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010$\u001a\u00020\u000f2\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040&H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u000fJ\b\u0010,\u001a\u00020\rH\u0002J\b\u0010-\u001a\u00020.H\u0002J\u0019\u0010/\u001a\u0002002\u0006\u0010\u001d\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u00101J\u0010\u00102\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\u0019\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u00101J\r\u00105\u001a\u00020\rH\u0000¢\u0006\u0002\b6J\r\u00107\u001a\u00020\rH\u0000¢\u0006\u0002\b8J!\u00109\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010:2\u0006\u0010<\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u00101J\u0015\u0010=\u001a\u00020\r2\u0006\u0010>\u001a\u00020?H\u0000¢\u0006\u0002\b@J\u0016\u0010A\u001a\u00020\r2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0007J\u0010\u0010B\u001a\u00020\r2\u0006\u0010C\u001a\u00020DH\u0007J\u0015\u0010E\u001a\u00020\r2\u0006\u0010F\u001a\u00020\u000fH\u0000¢\u0006\u0002\bGR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006J"}, d2 = {"Lcom/obric/capability/schedulekit/CapabilityScheduleSdk;", "", "()V", "TAG", "", "_config", "Lcom/obric/capability/schedulekit/CapabilityScheduleSdk$InitConfig;", "config", "getConfig", "()Lcom/obric/capability/schedulekit/CapabilityScheduleSdk$InitConfig;", "connectionListeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lkotlin/Function0;", "", "mPendingCallsExecuted", "", "mPendingCals", "", "Lcom/obric/capability/schedulekit/CapabilityScheduleSdk$ApiCall;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "addConnectionListener", "listener", "addPendingCall", NotificationCompat.CATEGORY_CALL, "callOrAddPendingCall", "func", "dispatchAppIntent", "Lcom/obric/capability/schedulekit/JobResultWrapper;", "intentName", TrackerImpl.PARAMS, "Lcom/obric/capabilitykit/common/intent/IntentParams;", "timeoutMillis", "", "questionId", ObricMemoryConstants.KEY_PACKAGE_NAME, "replyForServer", "actionExt", "", "(Ljava/lang/String;Lcom/obric/capabilitykit/common/intent/IntentParams;JJLjava/lang/String;ZLjava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toolName", "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;ZLjava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchServerActions", "payload", "execPendingCalls", "getApi", "Lcom/obric/capability/schedulekit/IScheduleProxy;", "getIntentSdkVersion", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", CommonConsts.APM_INNER_EVENT_COST_INIT, "isDownloadAppIntentV2", "actionName", "onApiInitComplete", "onApiInitComplete$capabilityschedulekit_release", "onConnectionClosed", "onConnectionClosed$capabilityschedulekit_release", "queryAppIntents", "", "Lcom/obric/capabilitykit/common/intent/AppIntentImplInfo;", ActivityLifecycle.NAME, "registerActionsResultReceiver", "receiver", "Lcom/obric/capabilitykit/common/ICapabilityFeedbackReceiver;", "registerActionsResultReceiver$capabilityschedulekit_release", "removeConnectionListener", "setLogger", "logger", "Lcom/obric/capability/schedulekit/logger/ILogger;", "setPendingCallsExecuted", "isExecuted", "setPendingCallsExecuted$capabilityschedulekit_release", "ApiCall", "InitConfig", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f7373a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7374b = null;
    private static final al c = null;
    private static b d;
    private static final List<InterfaceC0364a> e = null;
    private static boolean f;
    private static final CopyOnWriteArraySet<Function0<Unit>> g = null;

    /* JADX INFO: renamed from: com.obric.capability.schedulekit.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bb\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/obric/capability/schedulekit/CapabilityScheduleSdk$ApiCall;", "", NotificationCompat.CATEGORY_CALL, "", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private interface InterfaceC0364a {
        void call();
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/obric/capability/schedulekit/CapabilityScheduleSdk$InitConfig;", "", "app", "Landroid/app/Application;", "receiverBinder", "Lcom/obric/capabilitykit/common/ICapabilityFeedbackReceiver;", "extBindFlags", "", "(Landroid/app/Application;Lcom/obric/capabilitykit/common/ICapabilityFeedbackReceiver;I)V", "getApp", "()Landroid/app/Application;", "getExtBindFlags", "()I", "getReceiverBinder", "()Lcom/obric/capabilitykit/common/ICapabilityFeedbackReceiver;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Application f7375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final ICapabilityFeedbackReceiver f7376b;
        private final int c;

        public b(Application r3, ICapabilityFeedbackReceiver r4, int r5) {
            Application r6 = (Application) ZeusTransformUtils.wrapperContextForParams(r3, Application.class, "com.obric.memorydata.plugin");
            ICapabilityFeedbackReceiver r7 = (ICapabilityFeedbackReceiver) ZeusTransformUtils.wrapperContextForParams(r4, ICapabilityFeedbackReceiver.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "app");
            Intrinsics.checkNotNullParameter(r7, "receiverBinder");
            this.f7375a = r6;
            this.f7376b = r7;
            this.c = r5;
        }

        public final Application a() {
            return this.f7375a;
        }

        public final ICapabilityFeedbackReceiver b() {
            return this.f7376b;
        }

        public final int c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f7375a, r6.f7375a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f7376b, r6.f7376b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f7375a.hashCode() * 31) + this.f7376b.hashCode()) * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            return "InitConfig(app=" + this.f7375a + ", receiverBinder=" + this.f7376b + ", extBindFlags=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/capability/schedulekit/CapabilityScheduleSdk$callOrAddPendingCall$1", "Lcom/obric/capability/schedulekit/CapabilityScheduleSdk$ApiCall;", NotificationCompat.CATEGORY_CALL, "", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class c implements InterfaceC0364a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function0<Unit> f7377a;

        c(Function0<Unit> r3) {
            this.f7377a = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        }

        @Override // com.obric.capability.schedulekit.a.InterfaceC0364a
        public void call() {
            this.f7377a.invoke();
        }
    }

    static {
        f7373a = new a();
        f7374b = "CapabilityScheduleSdk";
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$a$MLU2XeQuvqVCQdijyNfTVS29O5I.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(r0, "newSingleThreadExecutor …pability-schedule\")\n    }");
        c = am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(bo.a(r0), CoroutineContext.class, "com.obric.memorydata.plugin"));
        e = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        g = new CopyOnWriteArraySet();
    }

    private a() {
    }

    public static final /* synthetic */ d a(a r0) {
        return r0.d();
    }

    public static /* synthetic */ Object a(a r10, String r11, IntentParams r12, long r13, long r15, String r17, boolean r18, Map r19, Continuation r20, int r21, Object r22) {
        IntentParams r0 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r12, IntentParams.class, "com.obric.memorydata.plugin");
        Map<String, String> r2 = (Map) ZeusTransformUtils.wrapperContextForParams(r19, Map.class, "com.obric.memorydata.plugin");
        Continuation<? super JobResultWrapper> r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        String r4 = null;
        if ((r21 & 2) == 0) goto L6;
        r0 = null;
    L6:
        if ((r21 & 4) == 0) goto L8;
        long r5 = 5000;
    L10:
        if ((r21 & 8) == 0) goto L12;
        long r7 = 0;
    L14:
        if ((r21 & 16) != 0) goto L18;
        r4 = r17;
    L18:
        if ((r21 & 32) == 0) goto L20;
        boolean r3 = false;
    L22:
        if ((r21 & 64) == 0) goto L25;
        r2 = MapsKt.emptyMap();
    L25:
        return r10.a(r11, r0, r5, r7, r4, r3, r2, r1);
    L20:
        r3 = r18;
        goto L22
    L12:
        r7 = r15;
        goto L14
    L8:
        r5 = r13;
        goto L10
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "capability-schedule");
    }

    private final void a(InterfaceC0364a r4) {
        InterfaceC0364a r3 = (InterfaceC0364a) ZeusTransformUtils.wrapperContextForParams(r4, InterfaceC0364a.class, "com.obric.memorydata.plugin");
        com.obric.capability.schedulekit.b.c r5 = com.obric.capability.schedulekit.b.c.f7384a;
        String r0 = f7374b;
        r5.a(r0, "addPendingCall");
        List<InterfaceC0364a> r6 = e;
        monitor-enter(r6);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f == false) goto L7;
        com.obric.capability.schedulekit.b.c.f7384a.d(r0, "in addPendingCall: pending-calls have all been executed; this call shall be execute RIGHT AWAY.");     // Catch: Throwable -> L10
        r3.call();     // Catch: Throwable -> L10
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r6);
        return;
    L7:
        Boolean.valueOf(r6.add(r3));     // Catch: Throwable -> L10
        goto L8
    }

    @JvmStatic
    public static final void a(b r5) {
        Intrinsics.checkNotNullParameter(r5, "config");
        a r0 = f7373a;
        d = r5;
        com.obric.capability.schedulekit.b.c.f7384a.c(f7374b, "CapabilityScheduleSdk init");
        com.obric.capability.schedulekit.a.c.f7378a.a((com.obric.capability.schedulekit.a.c) ZeusTransformUtils.preCheckCast(new com.obric.capability.schedulekit.a.d((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")), com.obric.capability.schedulekit.a.c.class, "com.obric.memorydata.plugin"));
        r0.b((Function0) ZeusTransformUtils.preCheckCast(CapabilityScheduleSdk$init$1.INSTANCE, Function0.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void a(a r2, Function0 r3) {
        r2.b((Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin"));
    }

    @JvmStatic
    public static final void a(Function0<Unit> r2) {
        Function0<Unit> r3 = (Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "listener");
        g.add(r3);
    }

    private final void b(Function0<Unit> r4) {
        Function0 r5 = (Function0) ZeusTransformUtils.wrapperContextForParams(r4, Function0.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(d(), com.obric.capability.schedulekit.b.f7381a) == true) goto L5;
        r5.invoke();
        return;
    L5:
        a((InterfaceC0364a) ZeusTransformUtils.preCheckCast(new c(r5), InterfaceC0364a.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ String c() {
        return f7374b;
    }

    private final d d() {
        return ScheduleServiceConnection.f7370a.a(e().c());
    }

    private final b e() {
        b r1 = d;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new RuntimeException("you need to invoke CapabilityScheduleSdk.init!");
    }

    private final void f() {
        com.obric.capability.schedulekit.b.c.f7384a.a(f7374b, "execPendingCalls");
        List<InterfaceC0364a> r5 = e;
        monitor-enter(r5);
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L11
    L6:
        if (r0.hasNext() == false) goto L8;
        InterfaceC0364a r1 = (InterfaceC0364a) ZeusTransformUtils.preCheckCast(r0.next(), InterfaceC0364a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        com.obric.capability.schedulekit.b.c.f7384a.a(f7374b, "exec foreach call");     // Catch: Throwable -> L11
        r1.call();     // Catch: Throwable -> L11
        goto L6
    L8:
        e.clear();     // Catch: Throwable -> L11
        f = true;     // Catch: Throwable -> L11
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r5);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ Thread lambda$MLU2XeQuvqVCQdijyNfTVS29O5I(Runnable r0) {
        return a(r0);
    }

    public final Object a(String r12, IntentParams r13, long r14, long r16, String r18, final boolean r19, Map<String, String> r20, Continuation<? super JobResultWrapper> r21) {
        IntentParams r4 = (IntentParams) ZeusTransformUtils.wrapperContextForParams(r13, IntentParams.class, "com.obric.memorydata.plugin");
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r20, Map.class, "com.obric.memorydata.plugin");
        Continuation<? super JobResultWrapper> r0 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        Long r2 = Boxing.boxLong(r16);
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue() == 0) goto L5;
        boolean r3 = true;
    L6:
        if (r3 == true) goto L9;
        r2 = null;
    L9:
        if (r2 == null) goto L11;
        long r5 = r2.longValue();
    L12:
        long r9 = r5;
        final String r6 = e.f7388a.a(r12, r4, r9, r18, r8);
        b((Function0) ZeusTransformUtils.preCheckCast(new CapabilityScheduleSdk$dispatchAppIntent$2(r6, r19), Function0.class, "com.obric.memorydata.plugin"));
        return com.obric.capability.schedulekit.c.f7386a.a(r9, r14, r0);
    L11:
        r5 = UUID.randomUUID().toString().hashCode() & Integer.MAX_VALUE;
        goto L12
    L5:
        r3 = false;
        goto L6
    }

    public final Object a(final String r5, Continuation<? super List<AppIntentImplInfo>> r6) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        o r7 = new o(IntrinsicsKt.intercepted(r4), 1);
        r7.e();
        final n r1 = (n) ZeusTransformUtils.preCheckCast(r7, n.class, "com.obric.memorydata.plugin");
        a(f7373a, (Function0) ZeusTransformUtils.preCheckCast(new CapabilityScheduleSdk$queryAppIntents$2$1(r5, r1), Function0.class, "com.obric.memorydata.plugin"));
        Object r8 = r7.h();
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r4);
    L5:
        return r8;
    }

    public final void a() {
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(g, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        Function0 r0 = (Function0) ZeusTransformUtils.preCheckCast(r6.next(), Function0.class, "com.obric.memorydata.plugin");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L8
        r0.invoke();     // Catch: Throwable -> L8
        Object r1 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r3 = Result.m1424exceptionOrNullimpl(r1);
        if (r3 == null) goto L4;
        com.obric.capability.schedulekit.b.c.f7384a.b(f7374b, "connectionListener throw exception: " + ExceptionsKt.stackTraceToString(r3));
    L8:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public final void a(ICapabilityFeedbackReceiver r3) {
        final ICapabilityFeedbackReceiver r4 = (ICapabilityFeedbackReceiver) ZeusTransformUtils.wrapperContextForParams(r3, ICapabilityFeedbackReceiver.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "receiver");
        b((Function0) ZeusTransformUtils.preCheckCast(new CapabilityScheduleSdk$registerActionsResultReceiver$1(r4), Function0.class, "com.obric.memorydata.plugin"));
    }

    public final void a(final String r2, final boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "payload");
        b((Function0) ZeusTransformUtils.preCheckCast(new CapabilityScheduleSdk$dispatchServerActions$1(r2, r3), Function0.class, "com.obric.memorydata.plugin"));
    }

    public final void a(boolean r1) {
        List<InterfaceC0364a> r0 = e;
        monitor-enter(r0);
        f = r1;     // Catch: Throwable -> L7
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final Object b(String r2, Continuation<? super Integer> r3) {
        Continuation<? super Integer> r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return f.f7411a.a(r2, r1);
    }

    public final void b() {
        f();
        a(e().b());
    }

    public final Object c(String r6, Continuation<? super Boolean> r7) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, CapabilityScheduleSdk$isDownloadAppIntentV2$1.class) == false) goto L7;
        CapabilityScheduleSdk$isDownloadAppIntentV2$1 r0 = (CapabilityScheduleSdk$isDownloadAppIntentV2$1) ZeusTransformUtils.preCheckCast(r8, CapabilityScheduleSdk$isDownloadAppIntentV2$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L18:
        if (((Number) ZeusTransformUtils.preCheckCast(r9, Number.class, "com.obric.memorydata.plugin")).intValue() >= 2) goto L22;
        r4 = false;
    L22:
        return Boxing.boxBoolean(r4);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        r0.label = 1;
        r9 = b(r6, r0);
        if (r9 != r2) goto L18;
        return r2;
    L7:
        r0 = new CapabilityScheduleSdk$isDownloadAppIntentV2$1(this, r8);
        goto L8
    }
}
