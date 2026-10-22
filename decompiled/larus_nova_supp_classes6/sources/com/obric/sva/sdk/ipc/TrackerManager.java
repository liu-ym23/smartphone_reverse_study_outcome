package com.obric.sva.sdk.ipc;

import android.app.ActivityManager;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.ixigua.lib.track.TrackParams;
import com.obric.assistant.t1;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.apm.InteractorApmHelper;
import com.obric.sva.sdk.controller.HotwordRecorderMgr;
import com.obric.sva.sdk.logger.BackTraceEventEmitter;
import com.obric.sva.sdk.logger.InteractorReportInitializer;
import com.obric.sva.sdk.logger.WakeupInterruptedEventEmitter;
import com.obric.sva.sdk.logger.WakeupMetricAttributionEmitter;
import com.obric.sva.sdk.upload.WakeupUploadManager;
import com.obric.sva.sdk.utils.LogUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import f06.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001[B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0013J\b\u00100\u001a\u00020.H\u0002J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u0013H\u0002J\u000e\u00104\u001a\u00020.2\u0006\u00105\u001a\u00020\u001aJ\u000e\u00106\u001a\u00020.2\u0006\u00105\u001a\u00020\u001aJ*\u00107\u001a\u00020.2\b\u00108\u001a\u0004\u0018\u0001092\b\u0010:\u001a\u0004\u0018\u0001092\u0006\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u0005J\u0010\u0010=\u001a\u00020.2\u0006\u0010<\u001a\u00020\u0005H\u0002J\u0010\u0010>\u001a\u00020.2\u0006\u0010<\u001a\u00020\u0005H\u0002J*\u0010?\u001a\u00020.2\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u0001092\u0006\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u0005H\u0002J \u0010@\u001a\u0002022\u0006\u00108\u001a\u0002092\u0006\u0010;\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u0005H\u0002J\u0018\u0010A\u001a\u00020.2\u0006\u0010B\u001a\u00020\u00172\u0006\u0010<\u001a\u00020\u0005H\u0002J\b\u0010C\u001a\u00020.H\u0002J\u0010\u0010D\u001a\u00020.2\u0006\u0010<\u001a\u00020\u0005H\u0002J\u001a\u0010E\u001a\u00020.2\u0006\u0010F\u001a\u00020\r2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u0005J\u0018\u0010H\u001a\u00020.2\u0006\u0010F\u001a\u00020\r2\u0006\u0010I\u001a\u00020\u0005H\u0002J\u0018\u0010J\u001a\u00020.2\u0006\u0010F\u001a\u00020\r2\u0006\u0010I\u001a\u00020\u0005H\u0002J\b\u0010K\u001a\u00020.H\u0002J\b\u0010L\u001a\u00020.H\u0002J\b\u0010M\u001a\u00020.H\u0002J\u0018\u0010N\u001a\u00020.2\u0006\u0010F\u001a\u00020\r2\u0006\u0010I\u001a\u00020\u0005H\u0002J\u0018\u0010O\u001a\u00020.2\u0006\u0010F\u001a\u00020\r2\u0006\u0010I\u001a\u00020\u0005H\u0002J\u0018\u0010P\u001a\u00020.2\u0006\u0010Q\u001a\u00020\r2\u0006\u0010I\u001a\u00020\u0005H\u0002J\u0010\u0010R\u001a\u00020\u00052\u0006\u0010I\u001a\u00020\u0005H\u0002J\u001c\u0010S\u001a\u0004\u0018\u00010\u00052\u0006\u0010F\u001a\u00020\r2\b\u0010G\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010T\u001a\u00020.*\u00020U2\u0006\u0010V\u001a\u00020\u0005H\u0002J\f\u0010W\u001a\u00020\u0005*\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00050\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010#\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010'\u001a\u0004\b*\u0010+R\u0014\u0010X\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bY\u0010Z¨\u0006\\"}, d2 = {"Lcom/obric/sva/sdk/ipc/TrackerManager;", "", "<init>", "()V", "TAG", "", "KEY_SESSION_TYPE", "SESSION_TYPE_VOICE", "SESSION_TYPE_BREATH", "voiceBreathTags", "", "[Ljava/lang/String;", "MAX_PENDING_REPORT_EVENTS", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "observerRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "context", "Landroid/content/Context;", "messenger", "Landroid/os/Messenger;", "attachedGeneration", "", "callbacks", "", "Lcom/obric/sva/sdk/ipc/TrackerManager$MessageCallback;", "pendingReportEvents", "Lkotlin/collections/ArrayDeque;", "Lkotlin/Pair;", "pendingReportDrainCallbackRegistered", "handlerThread", "Landroid/os/HandlerThread;", "interactorHandler", "Landroid/os/Handler;", "interactorMessenger", "getInteractorMessenger", "()Landroid/os/Messenger;", "interactorMessenger$delegate", "Lkotlin/Lazy;", "observer", "Landroid/database/ContentObserver;", "getObserver", "()Landroid/database/ContentObserver;", "observer$delegate", "initLocal", "", "_context", "ensureWorkerReady", "isMainProcessAlive", "", "ctx", "registerMessengerCallback", "callback", "unregisterMessengerCallback", "attachFromHostProvider", "binder", "Landroid/os/IBinder;", "ownerToken", "generation", "reason", "tryAttachFromProviderIfMainAlive", "tryAttachFromProvider", "attachMainMessenger", "detachMainMessengerIfCurrent", "onMainMessengerDetached", "prevGeneration", "sendInteractorMessengerLocked", "postHandshakeIfReady", "onTrackEvent", "trackerID", "trackerData", "handleTrackEventOnWorker", "data", "enqueueReportEvent", "schedulePendingReportDrainOnReady", "postDrainPendingReportEvents", "drainPendingReportEvents", "handleWakeupUploadTriggerInInteractor", "handleTrackerInInteractor", "traceDataInInteractor", "trackID", "wakeupSessionType", "buildTrackerDataForLog", "maskLogField", "Lorg/json/JSONObject;", "key", "toLogTail", "timeJson", "getTimeJson", "()Ljava/lang/String;", "MessageCallback", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class TrackerManager {
    public static final TrackerManager INSTANCE = null;
    private static final String KEY_SESSION_TYPE = "session_type";
    private static final int MAX_PENDING_REPORT_EVENTS = 200;
    private static final String SESSION_TYPE_BREATH = "BREATH";
    private static final String SESSION_TYPE_VOICE = "VOICE";
    private static final String TAG = "TrackerManager";
    private static volatile long attachedGeneration;
    private static final List<MessageCallback> callbacks = null;
    private static volatile Context context;
    private static final HandlerThread handlerThread = null;
    private static Handler interactorHandler;
    private static final Lazy interactorMessenger$delegate = null;
    private static final ReentrantLock lock = null;
    private static volatile Messenger messenger;
    private static final Lazy observer$delegate = null;
    private static final AtomicBoolean observerRegistered = null;
    private static final AtomicBoolean pendingReportDrainCallbackRegistered = null;
    private static final ArrayDeque<Pair<Integer, String>> pendingReportEvents = null;
    private static final String[] voiceBreathTags = null;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/obric/sva/sdk/ipc/TrackerManager$MessageCallback;", "", "onMessage", "", "msg", "Landroid/os/Message;", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public interface MessageCallback {
        void onMessage(Message r1);
    }

    /* JADX INFO: renamed from: com.obric.sva.sdk.ipc.TrackerManager$traceDataInInteractor$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    @DebugMetadata(c = "com.obric.sva.sdk.ipc.TrackerManager$traceDataInInteractor$1", f = "TrackerManager.kt", i = {0}, l = {476}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $data;
        final /* synthetic */ int $trackID;
        final /* synthetic */ Ref.ObjectRef<String> $wakeupStage;
        final /* synthetic */ Ref.BooleanRef $wakeupSuccess;
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(int r1, String r2, Ref.ObjectRef<String> r3, Ref.BooleanRef r4, Continuation<? super AnonymousClass1> r5) {
            this.$trackID = r1;
            this.$data = r2;
            this.$wakeupStage = r3;
            this.$wakeupSuccess = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass1 r6 = new AnonymousClass1(this.$trackID, this.$data, this.$wakeupStage, this.$wakeupSuccess, r9);
            r6.L$0 = r8;
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r23) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            int r3 = 1;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            CoroutineScope r1 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r23);
        L11:
            Map<Integer, String> r4 = com.obric.assistant.voice.m.a;
            Map<Integer, String> r5 = com.obric.assistant.voice.m.a;
            int r6 = this.$trackID;
            LinkedHashMap r7 = new LinkedHashMap();
            Iterator<Map.Entry<Integer, String>> r8 = r5.entrySet().iterator();
        L12:
            int r9 = 0;
            if (r8.hasNext() == false) goto L19;
            Map.Entry<Integer, String> r10 = r8.next();
            if (r10.getKey().intValue() != r6) goto L17;
            r9 = 1;
        L17:
            if (r9 == 0) goto L12;
            r7.put(r10.getKey(), r10.getValue());
            goto L12
        L19:
            String r11 = this.$data;
            Ref.ObjectRef<String> r12 = this.$wakeupStage;
            Ref.BooleanRef r13 = this.$wakeupSuccess;
            Iterator r14 = r7.entrySet().iterator();
        L21:
            if (r14.hasNext() == false) goto L70;
            String r15 = (String) ((Map.Entry) r14.next()).getValue();
            Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L25
            Object r17 = Result.constructor-impl(new JSONObject(r11));     // Catch: Throwable -> L25
        L27:
            JSONObject r18 = new JSONObject();
            if (Result.isFailure-impl(r17) == false) goto L30;
            r17 = r18;
        L30:
            JSONObject r19 = (JSONObject) r17;
            by7.a r20 = new by7.a(r15);     // Catch: Throwable -> L33
            r20.a.merge(new TrackParams().merge(r19));     // Catch: Throwable -> L33
            r20.b();     // Catch: Throwable -> L33
            Object r21 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L33
        L35:
            Throwable r22 = Result.exceptionOrNull-impl(r21);
            if (r22 == null) goto L79;
            LogUtils.w(TrackerManager.TAG, "Event.emit failed event=" + r15 + ": " + r22.getMessage(), new Object[r9]);
        L79:
        L49:
            th = th;
            String r24 = TrackerManager.TAG;
            String r25 = ": ";
        L51:
            Result.Companion r26 = Result.Companion;
            Object r27 = Result.constructor-impl(ResultKt.createFailure(th));
        L52:
            Throwable r28 = Result.exceptionOrNull-impl(r27);
            if (r28 == null) goto L56;
            LogUtils.w(r24, "schedule sys pb failed event=" + r15 + r25 + r28.getMessage(), new Object[0]);
        L56:
            if (InteractorReportInitializer.INSTANCE.isApmReady() == true) goto L58;
            r9 = 0;
            LogUtils.i(r24, "monitorEventForSlardar skipped before APM ready event=" + r15, new Object[0]);
        L68:
            LogUtils.i(r24, "traceDataInInteractor event=" + r15 + " payload=" + r19, new Object[r9]);
            r3 = 1;
            goto L21
        L58:
            if (t1.a.o0() == true) goto L77;
        L66:
            r9 = 0;
            goto L68
        L77:
            InteractorApmHelper.INSTANCE.monitorEventForSlardar(r15, r19, null, null);     // Catch: Throwable -> L61
            Object r29 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L61
        L63:
            Throwable r30 = Result.exceptionOrNull-impl(r29);
            if (r30 == null) goto L66;
            r9 = 0;
            LogUtils.w(r24, "monitorEventForSlardar failed: " + r30.getMessage(), new Object[0]);
        L61:
            th = move-exception;
            Result.Companion r31 = Result.Companion;
            r29 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L63
        L40:
            if (ArraysKt.contains(TrackerManager.access$getVoiceBreathTags$p(), r19.optString(TrackerManager.KEY_SESSION_TYPE)) == false) goto L44;
            CoroutineScope r110 = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, r3, null)));     // Catch: Throwable -> L49
            r24 = TrackerManager.TAG;
            r25 = ": ";
            BuildersKt.launch$default(r110, null, null, new 2.3.1(r15, r12, r13, r19, null), 3, null);     // Catch: Throwable -> L47
        L45:
            r27 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L47
        L47:
            th = th;
            goto L51
        L44:
            r24 = TrackerManager.TAG;
            r25 = ": ";
        L33:
            th = move-exception;
            Result.Companion r32 = Result.Companion;
            r21 = Result.constructor-impl(ResultKt.createFailure(th));
        L25:
            th = move-exception;
            Result.Companion r33 = Result.Companion;
            r17 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L27
        L70:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r23);
            this.L$0 = (CoroutineScope) this.L$0;
            this.label = 1;
            if (DelayKt.delay(InteractorReportInitializer.REPORT_EVENT_DELAY_MS, this) != r0) goto L11;
            return r0;
        }
    }

    private TrackerManager() {
    }

    public static /* synthetic */ void a() {
        postDrainPendingReportEvents$lambda$31();
    }

    public static /* synthetic */ void b(String r0) {
        postHandshakeIfReady$lambda$27(r0);
    }

    public static /* synthetic */ Messenger c() {
        return interactorMessenger_delegate$lambda$4();
    }

    public static /* synthetic */ void d(int r0, String r1) {
        onTrackEvent$lambda$28(r0, r1);
    }

    public static /* synthetic */ TrackerManager$observer$2$1 e() {
        return observer_delegate$lambda$5();
    }

    public static /* synthetic */ Unit f() {
        return schedulePendingReportDrainOnReady$lambda$30();
    }

    public static /* synthetic */ void g() {
        initLocal$lambda$8();
    }

    public static /* synthetic */ boolean h(Message r0) {
        return interactorMessenger_delegate$lambda$4$lambda$3(r0);
    }

    static {
        INSTANCE = new TrackerManager();
        voiceBreathTags = new String[]{SESSION_TYPE_VOICE, SESSION_TYPE_BREATH};
        lock = new ReentrantLock();
        observerRegistered = new AtomicBoolean(false);
        callbacks = new ArrayList();
        pendingReportEvents = new ArrayDeque();
        pendingReportDrainCallbackRegistered = new AtomicBoolean(false);
        handlerThread = new PthreadHandlerThreadV2("sva-interactor-tracker");
        interactorMessenger$delegate = LazyKt.lazy(new z());
        observer$delegate = LazyKt.lazy(new a0());
    }

    private final void drainPendingReportEvents() {
        ReentrantLock r0 = lock;
        r0.lock();
        ArrayDeque<Pair<Integer, String>> r1 = pendingReportEvents;     // Catch: Throwable -> L10
        List r2 = CollectionsKt.toList(r1);     // Catch: Throwable -> L10
        r1.clear();     // Catch: Throwable -> L10
        r0.unlock();
        Iterator r3 = r2.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        Pair r4 = (Pair) r3.next();
        INSTANCE.handleTrackerInInteractor(((Number) r4.component1()).intValue(), (String) r4.component2());
        goto L6
    L8:
        LogUtils.i(TAG, "drainPendingReportEvents size=" + r2.size(), new Object[0]);
        return;
    L10:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    private final void ensureWorkerReady() {
        HandlerThread r0 = handlerThread;
        if (ThreadMethodProxy.isAlive(r0) == true) goto L14;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L6:
        if (ThreadMethodProxy.isAlive(r0) == true) goto L8;
        ThreadMethodProxy.start(r0);     // Catch: Throwable -> L11
    L8:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L11
        monitor-exit(r0);
    L14:
        getInteractorMessenger();
    }

    private final Messenger getInteractorMessenger() {
        return (Messenger) interactorMessenger$delegate.getValue();
    }

    private final ContentObserver getObserver() {
        return (ContentObserver) observer$delegate.getValue();
    }

    private final String getTimeJson() {
        JSONObject r0 = new JSONObject();
        r0.put("timestamp", System.currentTimeMillis());
        return r0.toString();
    }

    private static final void initLocal$lambda$8() {
        INSTANCE.tryAttachFromProviderIfMainAlive("init_local");
    }

    private static final Messenger interactorMessenger_delegate$lambda$4() {
        interactorHandler = new Handler(handlerThread.getLooper(), new x());
        Handler r1 = interactorHandler;
        if (r1 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("interactorHandler");
        r1 = null;
    L6:
        return new Messenger(r1);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.obric.sva.sdk.ipc.TrackerManager$observer$2$1] */
    private static final TrackerManager$observer$2$1 observer_delegate$lambda$5() {
        final Handler r0 = interactorHandler;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("interactorHandler");
        r0 = null;
    L6:
        return new TrackerManager$observer$2$1(r0);
    }

    private static final void postDrainPendingReportEvents$lambda$31() {
        INSTANCE.drainPendingReportEvents();
    }

    private final void schedulePendingReportDrainOnReady() {
        AtomicBoolean r0 = pendingReportDrainCallbackRegistered;
        if (r0.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        InteractorReportInitializer r1 = InteractorReportInitializer.INSTANCE;
        r1.initIfNeeded(new t());
        if (r1.isPrivacyAgreed() == true) goto L9;
        r0.set(false);
        return;
    }

    private static final Unit schedulePendingReportDrainOnReady$lambda$30() {
        pendingReportDrainCallbackRegistered.set(false);
        INSTANCE.postDrainPendingReportEvents();
        return Unit.INSTANCE;
    }

    private final void sendInteractorMessengerLocked() {
        ReentrantLock r0 = lock;
        r0.lock();
        Messenger r1 = messenger;     // Catch: Throwable -> L22
        if (r1 == null) goto L7;
        Pair r2 = TuplesKt.to(r1, Long.valueOf(attachedGeneration));     // Catch: Throwable -> L22
    L8:
        r0.unlock();
        if (r2 != null) goto L11;
        return;
    L11:
        Messenger r3 = (Messenger) r2.component1();
        long r4 = ((Number) r2.component2()).longValue();
        Message r5 = Message.obtain();
        r5.what = 2;
        r5.replyTo = INSTANCE.getInteractorMessenger();
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L14
        r3.send(r5);     // Catch: Throwable -> L14
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L29;
        LogUtils.e(TAG, "sendInteractorMessenger failed: " + r8.getMessage(), new Object[0]);
        if ((r8 instanceof DeadObjectException) == false) goto L30;
        INSTANCE.detachMainMessengerIfCurrent(r3.getBinder(), r4, "dead_on_handshake");
        return;
    L30:
        return;
    L29:
        return;
    L14:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L7:
        r2 = null;
    L22:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    private final void postDrainPendingReportEvents() {
        ensureWorkerReady();
        Handler r0 = interactorHandler;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("interactorHandler");
        r0 = null;
    L5:
        r0.post(new y());
    }

    public static final /* synthetic */ String[] access$getVoiceBreathTags$p() {
        return voiceBreathTags;
    }

    private static final boolean interactorMessenger_delegate$lambda$4$lambda$3(Message r3) {
        Intrinsics.checkNotNullParameter(r3, "msg");
        Message r0 = Message.obtain();
        r0.what = r3.what;
        r0.arg1 = r3.arg1;
        r0.arg2 = r3.arg2;
        if (r3.getData() == null) goto L5;
        r0.setData(r3.getData());
    L5:
        ReentrantLock r4 = lock;
        r4.lock();
        Iterator<T> r1 = callbacks.iterator();     // Catch: Throwable -> L13
    L8:
        if (r1.hasNext() == false) goto L10;
        MessageCallback r2 = (MessageCallback) r1.next();     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r0);     // Catch: Throwable -> L13
        r2.onMessage(r0);     // Catch: Throwable -> L13
        goto L8
    L10:
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L13
        r4.unlock();
        return true;
    L13:
        th = move-exception;
        r4.unlock();
        throw th;
    }

    private final boolean isMainProcessAlive(Context r5) {
        Object r0 = r5.getSystemService("activity");
        Object r2 = null;
        if ((r0 instanceof ActivityManager) == false) goto L5;
        ActivityManager r1 = (ActivityManager) r0;
    L7:
        if (r1 != null) goto L9;
        return false;
    L9:
        String r6 = r5.getPackageName();
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L12
        Object r4 = Result.constructor-impl(r1.getRunningAppProcesses());     // Catch: Throwable -> L12
    L15:
        if (Result.isFailure-impl(r4) == true) goto L18;
        r2 = r4;
    L18:
        List r7 = (List) r2;
        if (r7 != null) goto L21;
        r7 = CollectionsKt.emptyList();
    L21:
        List r8 = r7;
        if ((r8 instanceof Collection) == true) goto L24;
    L26:
        Iterator r9 = r8.iterator();
    L28:
        if (r9.hasNext() == false) goto L39;
        if (Intrinsics.areEqual(((ActivityManager.RunningAppProcessInfo) r9.next()).processName, r6) == false) goto L28;
        return true;
    L39:
        return false;
    L24:
        if (r8.isEmpty() == false) goto L26;
        return false;
    L12:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L5:
        r1 = null;
        goto L7
    }

    private final void postHandshakeIfReady(final String r3) {
        ensureWorkerReady();
        Handler r0 = interactorHandler;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("interactorHandler");
        r0 = null;
    L5:
        r0.post(new u(r3));
    }

    private static final void postHandshakeIfReady$lambda$27(String r2) {
        ReentrantLock r0 = lock;
        r0.lock();
        boolean r1 = !callbacks.isEmpty();
        r0.unlock();
        if (r1 == true) goto L8;
        LogUtils.i(TAG, "handshake deferred: callback not ready reason=" + r2, new Object[0]);
        return;
    L8:
        INSTANCE.sendInteractorMessengerLocked();
        return;
    L10:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    private final String toLogTail(String r3) {
        if (r3.length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        return "";
    L10:
        return "***" + StringsKt.takeLast(r3, 4);
    L5:
        r0 = false;
        goto L6
    }

    private final void tryAttachFromProvider(String r14) {
        Context r3 = context;
        if (r3 != null) goto L5;
        return;
    L5:
        ReentrantLock r4 = lock;
        r4.lock();
        Messenger r5 = messenger;     // Catch: Throwable -> L77
        Unit r9 = null;
        if (r5 == null) goto L10;
        Pair r6 = TuplesKt.to(r5.getBinder(), Long.valueOf(attachedGeneration));     // Catch: Throwable -> L77
    L11:
        r4.unlock();
        if (r6 == null) goto L86;
        IBinder r7 = (IBinder) r6.component1();
        long r8 = ((Number) r6.component2()).longValue();
        if (r7.isBinderAlive() == false) goto L16;
        return;
    L16:
        Intrinsics.checkNotNull(r7);
        if (detachMainMessengerIfCurrent(r7, r8, "stale_before_attach") == true) goto L86;
        return;
    L86:
        ContentProviderClient r12 = com_obric_sva_sdk_ipc_TrackerManager_android_content_ContentResolver_acquireUnstableContentProviderClient(r3.getContentResolver(), com.obric.assistant.voice.l.a);     // Catch: Throwable -> L57 Exception -> L59
        if (r12 != null) goto L28;
        LogUtils.w(TAG, "tryAttachFromProvider: provider client null reason=" + r14, new Object[0]);     // Catch: Exception -> L55 Throwable -> L67
        Result.constructor-impl(null);     // Catch: Throwable -> L25
        return;
    L25:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L28:
        Bundle r2 = r12.call("get-tracker-messenger", null, null);     // Catch: Exception -> L55 Throwable -> L67
        if (r2 != null) goto L31;
    L49:
        LogUtils.i(TAG, "tryAttachFromProvider: main process not ready reason=" + r14, new Object[0]);     // Catch: Exception -> L55 Throwable -> L67
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L52
        r12.close();     // Catch: Throwable -> L52
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L52
        return;
    L52:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L31:
        if (r2.isEmpty() == true) goto L49;
        IBinder r11 = r2.getBinder("tracker_messenger");     // Catch: Exception -> L55 Throwable -> L67
        IBinder r13 = r2.getBinder("owner_token");     // Catch: Exception -> L55 Throwable -> L67
        long r15 = r2.getLong("ipc_generation", 0);     // Catch: Exception -> L55 Throwable -> L67
        if (r11 != null) goto L36;
    L43:
        LogUtils.w(TAG, "tryAttachFromProvider: binder null or dead reason=" + r14, new Object[0]);     // Catch: Exception -> L55 Throwable -> L67
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L46
        r12.close();     // Catch: Throwable -> L46
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L46
        return;
    L46:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L36:
        if (r11.isBinderAlive() == false) goto L43;
        attachMainMessenger(r11, r13, r15, r14);     // Catch: Exception -> L55 Throwable -> L67
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L41
        r12.close();     // Catch: Throwable -> L41
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L41
        return;
    L55:
        e = e;
    L61:
        LogUtils.e(TAG, "tryAttachFromProvider failed reason=" + r14 + ": " + e.getMessage(), new Object[0]);     // Catch: Throwable -> L67
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L41
        if (r12 == null) goto L65;
        r12.close();     // Catch: Throwable -> L41
        r9 = Unit.INSTANCE;     // Catch: Throwable -> L41
    L65:
        Result.constructor-impl(r9);     // Catch: Throwable -> L41
        return;
    L67:
        th = move-exception;
        Throwable r20 = th;
    L81:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L74
        if (0 == 0) goto L72;
        r9.close();     // Catch: Throwable -> L74
        r9 = Unit.INSTANCE;     // Catch: Throwable -> L74
    L72:
        Result.constructor-impl(r9);     // Catch: Throwable -> L74
        throw r20;
    L74:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        throw r20;
    L59:
        e = e;
        r12 = null;
    L57:
        th = move-exception;
        r20 = th;
    L41:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L10:
        r6 = null;
    L77:
        th = move-exception;
        r4.unlock();
        throw th;
    }

    private final void tryAttachFromProviderIfMainAlive(String r5) {
        Context r0 = context;
        if (r0 != null) goto L5;
        return;
    L5:
        int r1 = sna.d.a;
        Context r2 = sna.f.a;
        Intrinsics.checkNotNullParameter("reporter_privacy_agreed", "key");
        sna.c r3 = sna.f.b();
        r3.getClass();
        Intrinsics.checkNotNullParameter("reporter_privacy_agreed", "key");
        if (r3.a().getBoolean("reporter_privacy_agreed", false) == true) goto L10;
        LogUtils.i(TAG, "tryAttachFromProviderIfMainAlive skip: privacy not agreed reason=" + r5, new Object[0]);
        return;
    L10:
        if (isMainProcessAlive(r0) == true) goto L13;
        LogUtils.i(TAG, "tryAttachFromProviderIfMainAlive skip: main process not alive reason=" + r5, new Object[0]);
        return;
    L13:
        tryAttachFromProvider(r5);
    }

    private final String wakeupSessionType(String r3) {
        Object r0 = SESSION_TYPE_VOICE;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        Object r4 = Result.constructor-impl(new JSONObject(r3).optString(KEY_SESSION_TYPE, SESSION_TYPE_VOICE));     // Catch: Throwable -> L5
    L8:
        if (Result.isFailure-impl(r4) == true) goto L12;
        r0 = r4;
    L12:
        return (String) r0;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final void initLocal(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "_context");
        Context r6 = r5.getApplicationContext();
        context = r6;
        ensureWorkerReady();
        if (observerRegistered.compareAndSet(false, true) == true) goto L16;
    L11:
        Handler r7 = interactorHandler;
        if (r7 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("interactorHandler");
        r7 = null;
    L14:
        r7.post(new w());
        return;
    L16:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L6
        r6.getContentResolver().registerContentObserver(com.obric.assistant.voice.l.a, false, INSTANCE.getObserver());     // Catch: Throwable -> L6
        LogUtils.i(TAG, "initLocal ContentObserver registered", new Object[0]);     // Catch: Throwable -> L6
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L11;
        observerRegistered.set(false);
        LogUtils.e(TAG, "initLocal registerContentObserver failed: " + r9.getMessage(), new Object[0]);
    L6:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L8
    }

    public final void registerMessengerCallback(MessageCallback r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        ensureWorkerReady();
        ReentrantLock r0 = lock;
        r0.lock();
        callbacks.add(r3);     // Catch: Throwable -> L6
        r0.unlock();
        postHandshakeIfReady("callback_registered");
        return;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public final void unregisterMessengerCallback(MessageCallback r3) {
        Intrinsics.checkNotNullParameter(r3, "callback");
        ReentrantLock r0 = lock;
        r0.lock();
        callbacks.remove(r3);     // Catch: Throwable -> L6
        r0.unlock();
        return;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public static final /* synthetic */ void access$tryAttachFromProvider(TrackerManager r0, String r1) {
        r0.tryAttachFromProvider(r1);
    }

    private final String buildTrackerDataForLog(int r3, String r4) {
        if (r3 == 411) goto L5;
        return r4;
    L5:
        if (r4 != null) goto L7;
    L10:
        boolean r0 = true;
    L11:
        if (r0 == true) goto L26;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L15
        JSONObject r2 = new JSONObject(r4);     // Catch: Throwable -> L15
        TrackerManager r5 = INSTANCE;     // Catch: Throwable -> L15
        r5.maskLogField(r2, "raw_uid");     // Catch: Throwable -> L15
        r5.maskLogField(r2, "uid");     // Catch: Throwable -> L15
        r5.maskLogField(r2, "did");     // Catch: Throwable -> L15
        r5.maskLogField(r2, "os_did");     // Catch: Throwable -> L15
        r5.maskLogField(r2, "userHandleId");     // Catch: Throwable -> L15
        Object r6 = Result.constructor-impl(r2.toString());     // Catch: Throwable -> L15
    L17:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L22;
        LogUtils.w(TAG, "buildTrackerDataForLog failed: " + r7.getMessage(), new Object[0]);
        r6 = "[masked-invalid-truth-capture-payload]";
    L22:
        return (String) r6;
    L15:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    L26:
        return r4;
    L7:
        if (r4.length() == 0) goto L10;
        r0 = false;
        goto L11
    }

    private static ContentProviderClient com_obric_sva_sdk_ipc_TrackerManager_android_content_ContentResolver_acquireUnstableContentProviderClient(ContentResolver r18, Uri r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        b r11 = new b();
        g06.a r2 = (g06.a) ApiHookConfig.b.get(240008);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(240008, "android/content/ContentResolver", "acquireUnstableContentProviderClient", r18, r1, "android.content.ContentProviderClient", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return (ContentProviderClient) r4.b;
    L21:
        return r18.acquireUnstableContentProviderClient(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    private final void enqueueReportEvent(int r5, String r6) {
        ReentrantLock r0 = lock;
        r0.lock();
    L12:
        ArrayDeque<Pair<Integer, String>> r1 = pendingReportEvents;     // Catch: Throwable -> L9
        if (r1.size() < MAX_PENDING_REPORT_EVENTS) goto L6;
        r1.removeFirst();     // Catch: Throwable -> L9
        goto L12
    L6:
        r1.addLast(TuplesKt.to(Integer.valueOf(r5), r6));     // Catch: Throwable -> L9
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r0.unlock();
        return;
    L9:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    private final void handleTrackEventOnWorker(int r7, String r8) {
        String r0 = buildTrackerDataForLog(r7, r8);
        InteractorReportInitializer r1 = InteractorReportInitializer.INSTANCE;
        if (r1.isPrivacyAgreed() == true) goto L6;
        LogUtils.d(TAG, "onTrackEvent dropped before privacy agreed trackerID=" + r7 + " data=" + r0, new Object[0]);
        return;
    L6:
        handleWakeupUploadTriggerInInteractor(r7, r8);
        if (r1.isReady() == true) goto L10;
        enqueueReportEvent(r7, r8);
        schedulePendingReportDrainOnReady();
        LogUtils.d(TAG, "onTrackEvent queued until reporter ready trackerID=" + r7 + " data=" + r0, new Object[0]);
        return;
    L10:
        handleTrackerInInteractor(r7, r8);
        LogUtils.d(TAG, "onTrackEvent handled in interactor trackerID=" + r7 + " data=" + r0, new Object[0]);
    }

    private final void handleTrackerInInteractor(int r6, String r7) {
        if (r6 != 400) goto L5;
        WakeupInterruptedEventEmitter.INSTANCE.reportWakeupFailed(r7);
        return;
    L5:
        switch(r6) {
            case 500: goto L41;
            case 501: goto L43;
            case 502: goto L17;
            case 503: goto L39;
            default: goto L6;
        };
    L6:
        traceDataInInteractor(r6, r7);
        return;
    L17:
        BackTraceEventEmitter.INSTANCE.reportBacktraceDuration(r7);
        return;
    L39:
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L10
        Object r9 = Result.constructor-impl(new JSONObject(r7));     // Catch: Throwable -> L10
    L12:
        JSONObject r10 = new JSONObject();
        if (Result.isFailure-impl(r9) == false) goto L15;
        r9 = r10;
    L15:
        JSONObject r11 = (JSONObject) r9;
        String r12 = r11.optString("scene", "obric_hotword_wakeup");
        String r13 = r11.optString("error_reason", "");
        BackTraceEventEmitter r0 = BackTraceEventEmitter.INSTANCE;
        Intrinsics.checkNotNull(r12);
        Intrinsics.checkNotNull(r13);
        r0.reportBacktraceRecordError(r12, r13);
        return;
    L10:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L41:
        Result.Companion r15 = Result.Companion;     // Catch: Throwable -> L30
        Object r16 = Result.constructor-impl(new JSONObject(r7));     // Catch: Throwable -> L30
    L32:
        JSONObject r17 = new JSONObject();
        if (Result.isFailure-impl(r16) == false) goto L35;
        r16 = r17;
    L35:
        String r18 = ((JSONObject) r16).optString("scene", "obric_hotword_wakeup");
        BackTraceEventEmitter r19 = BackTraceEventEmitter.INSTANCE;
        Intrinsics.checkNotNull(r18);
        r19.reportAudioRecorderStart(r18);
        return;
    L30:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L32
    L43:
        Result.Companion r21 = Result.Companion;     // Catch: Throwable -> L21
        Object r22 = Result.constructor-impl(new JSONObject(r7));     // Catch: Throwable -> L21
    L23:
        JSONObject r23 = new JSONObject();
        if (Result.isFailure-impl(r22) == false) goto L26;
        r22 = r23;
    L26:
        JSONObject r24 = (JSONObject) r22;
        String r25 = r24.optString("scene", "obric_hotword_wakeup");
        boolean r2 = r24.optBoolean("success", false);
        String r26 = r24.optString("error_reason", "");
        BackTraceEventEmitter r1 = BackTraceEventEmitter.INSTANCE;
        Intrinsics.checkNotNull(r25);
        r1.reportAudioRecorderStartResult(r25, r2, r26);
        return;
    L21:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r22 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L23
    }

    private final void handleWakeupUploadTriggerInInteractor(int r2, String r3) {
        if (r2 == MAX_PENDING_REPORT_EVENTS) goto L17;
        return;
    L17:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L11
        if (Intrinsics.areEqual(wakeupSessionType(r3), SESSION_TYPE_BREATH) == false) goto L8;
        WakeupUploadManager.INSTANCE.onBreathWakeupPassed();     // Catch: Throwable -> L11
    L9:
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L19;
        LogUtils.w(TAG, "handleWakeupUploadTriggerInInteractor failed: " + r6.getMessage(), new Object[0]);
        return;
    L19:
        return;
    L8:
        WakeupUploadManager.INSTANCE.onVoiceWakeupPassed();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    private final void maskLogField(JSONObject r2, String r3) {
        if (r2.has(r3) == true) goto L5;
        return;
    L5:
        r2.put(r3, toLogTail(r2.optString(r3)));
    }

    private final void onMainMessengerDetached(long r2, String r4) {
        TrackerTelemetry.INSTANCE.onTrackerDetach(r2, r4);
        HotwordRecorderMgr.forceStopStream();
    }

    private static final void onTrackEvent$lambda$28(int r1, String r2) {
        INSTANCE.handleTrackEventOnWorker(r1, r2);
    }

    private final void traceDataInInteractor(int r12, String r13) {
        Ref.ObjectRef r3 = new Ref.ObjectRef();
        r3.element = "";
        Ref.BooleanRef r4 = new Ref.BooleanRef();
        if (r12 != 100) goto L5;
        r3.element = "stage1";
        r4.element = true;
    L24:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L17
        Object r1 = Result.constructor-impl(new JSONObject(r13));     // Catch: Throwable -> L17
    L19:
        JSONObject r2 = new JSONObject();
        if (Result.isFailure-impl(r1) == false) goto L22;
        r1 = r2;
    L22:
        WakeupMetricAttributionEmitter r5 = WakeupMetricAttributionEmitter.INSTANCE;
        r5.onSecondaryWakeup(r12, (JSONObject) r1);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new AnonymousClass1(r12, r13, r3, r4, null), 3, null);
        return;
    L17:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    L5:
        if (r12 != 300) goto L7;
        r3.element = "stage3";
        r4.element = true;
        goto L24
    L7:
        if (r12 != MAX_PENDING_REPORT_EVENTS) goto L9;
        r3.element = "stage2";
        r4.element = true;
        goto L24
    L9:
        if (r12 != 201) goto L24;
        r3.element = "stage2";
        r4.element = false;
        goto L24
    }

    public final void onTrackEvent(final int r3, final String r4) {
        if (r4 != null) goto L4;
        r4 = getTimeJson();
    L4:
        ensureWorkerReady();
        Handler r0 = interactorHandler;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("interactorHandler");
        r0 = null;
    L7:
        r0.post(new v(r3, r4));
    }

    private final boolean detachMainMessengerIfCurrent(IBinder r6, long r7, String r9) {
        ReentrantLock r0 = lock;
        r0.lock();
        Messenger r1 = messenger;     // Catch: Throwable -> L17
        Long r2 = null;
        if (r1 == null) goto L6;
        IBinder r3 = r1.getBinder();     // Catch: Throwable -> L17
    L7:
        if (r3 == r6) goto L9;
    L11:
        r0.unlock();
        if (r2 == null) goto L15;
        onMainMessengerDetached(r2.longValue(), r9);
        return true;
    L15:
        LogUtils.i(TAG, "detachMainMessengerIfCurrent ignored generation=" + r7 + " reason=" + r9, new Object[0]);
        return false;
    L9:
        if (attachedGeneration != r7) goto L11;
        long r4 = attachedGeneration;     // Catch: Throwable -> L17
        messenger = null;     // Catch: Throwable -> L17
        attachedGeneration = 0;     // Catch: Throwable -> L17
        r2 = Long.valueOf(r4);     // Catch: Throwable -> L17
        goto L11
    L6:
        r3 = null;
    L17:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public static final /* synthetic */ boolean access$detachMainMessengerIfCurrent(TrackerManager r0, IBinder r1, long r2, String r4) {
        return r0.detachMainMessengerIfCurrent(r1, r2, r4);
    }

    private final void attachMainMessenger(final IBinder r5, IBinder r6, final long r7, String r9) {
        ReentrantLock r0 = lock;
        r0.lock();
        Messenger r1 = messenger;     // Catch: Throwable -> L28
        if (r1 == null) goto L6;
        IBinder r2 = r1.getBinder();     // Catch: Throwable -> L28
    L7:
        if (r2 != null) goto L9;
    L15:
        messenger = new Messenger(r5);     // Catch: Throwable -> L28
        attachedGeneration = r7;     // Catch: Throwable -> L28
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L28
        r0.unlock();
        TrackerTelemetry.INSTANCE.onTrackerAttach(r7, r9);
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L19
        r5.linkToDeath(new TrackerManager$attachMainMessenger$2$1(r5, r7), 0);     // Catch: Throwable -> L19
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        Throwable r10 = Result.exceptionOrNull-impl(r8);
        if (r10 == null) goto L24;
        LogUtils.e(TAG, "linkToDeath failed: " + r10.getMessage(), new Object[0]);
    L24:
        if (r6 == null) goto L26;
        TemporaryWakeupGateManager.INSTANCE.onOwnerTokenAvailable(r6, r7);
    L26:
        postHandshakeIfReady(r9);
        return;
    L19:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L9:
        if (r2.isBinderAlive() == false) goto L15;
        if (attachedGeneration != r7) goto L15;
        r0.unlock();
        return;
    L6:
        r2 = null;
    L28:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public final void attachFromHostProvider(IBinder r2, IBinder r3, long r4, String r6) {
        Intrinsics.checkNotNullParameter(r6, "reason");
        if (r2 != null) goto L5;
    L9:
        LogUtils.w(TAG, "attachFromHostProvider ignored: binder null/dead reason=" + r6 + " generation=" + r4, new Object[0]);
        return;
    L5:
        if (r2.isBinderAlive() == false) goto L9;
        ensureWorkerReady();
        attachMainMessenger(r2, r3, r4, r6);
    }

    public static /* synthetic */ void onTrackEvent$default(TrackerManager r0, int r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.onTrackEvent(r1, r2);
    }
}
