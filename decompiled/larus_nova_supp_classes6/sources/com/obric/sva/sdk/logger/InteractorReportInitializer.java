package com.obric.sva.sdk.logger;

import android.content.Context;
import android.util.Pair;
import com.larus.common.apphost.AppHost;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.AccountService;
import com.larus.settings.value.e10;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.apm.InteractorApmHelper;
import com.obric.sva.sdk.applog.InteractorLegacyAppLogHelper;
import com.obric.sva.sdk.session.IWakeupSessionConstant;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.ExecutorsKt;
import kotlinx.coroutines.SupervisorKt;
import sna.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u0015H\u0007J\u0016\u0010\u001a\u001a\u00020\u00152\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010\u001f\u001a\u00020\u001dJ\u0018\u0010 \u001a\u00020\u00152\b\u0010!\u001a\u0004\u0018\u00010\u00052\u0006\u0010\"\u001a\u00020\u0019J\u000e\u0010#\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0015H\u0002J\b\u0010&\u001a\u00020\u0015H\u0002J\b\u0010'\u001a\u00020\u0015H\u0002J\b\u0010(\u001a\u00020\u0015H\u0002J\b\u0010)\u001a\u00020\u0015H\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J\b\u0010+\u001a\u00020\u0015H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/obric/sva/sdk/logger/InteractorReportInitializer;", "", "<init>", "()V", "TAG", "", "RETRY_DELAY_MS", "", "REPORT_EVENT_DELAY_MS", "appLogInitialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "libTrackInitialized", "apmInitialized", "initScheduled", "initDispatcher", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "initScope", "Lkotlinx/coroutines/CoroutineScope;", "readyCallbacks", "", "Lkotlin/Function0;", "", "apmStartedCallback", "pendingUserId", "pendingOdinUserType", "", "initIfNeeded", "onReady", "isReady", "", "isApmReady", "isPrivacyAgreed", "updateReportAccount", "userId", "odinUserType", "runInitRound", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initAppLogIfNeeded", "initLibTrackIfNeeded", "initApmIfNeeded", "initAppLog", "initApm", "notifyReadyIfNeeded", "applyReportAccount", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class InteractorReportInitializer {
    public static final InteractorReportInitializer INSTANCE = null;
    public static final long REPORT_EVENT_DELAY_MS = 3000;
    private static final long RETRY_DELAY_MS = 10000;
    private static final String TAG = "InteractorReportInitializer";
    private static final AtomicBoolean apmInitialized = null;
    private static final Function0<Unit> apmStartedCallback = null;
    private static final AtomicBoolean appLogInitialized = null;
    private static final ExecutorCoroutineDispatcher initDispatcher = null;
    private static final AtomicBoolean initScheduled = null;
    private static final CoroutineScope initScope = null;
    private static final AtomicBoolean libTrackInitialized = null;
    private static volatile int pendingOdinUserType;
    private static volatile String pendingUserId;
    private static final List<Function0<Unit>> readyCallbacks = null;

    /* JADX INFO: renamed from: com.obric.sva.sdk.logger.InteractorReportInitializer$initIfNeeded$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    @DebugMetadata(c = "com.obric.sva.sdk.logger.InteractorReportInitializer$initIfNeeded$2", f = "InteractorReportInitializer.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
            return new AnonymousClass2(r2);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            InteractorReportInitializer r5 = InteractorReportInitializer.INSTANCE;
            this.label = 1;
            if (InteractorReportInitializer.access$runInitRound(r5, this) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.sva.sdk.logger.InteractorReportInitializer$runInitRound$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    @DebugMetadata(c = "com.obric.sva.sdk.logger.InteractorReportInitializer", f = "InteractorReportInitializer.kt", i = {}, l = {115}, m = "runInitRound", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ InteractorReportInitializer this$0;

        public AnonymousClass1(InteractorReportInitializer r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(r2);
        }

        public final Object invokeSuspend(Object r2) {
            this.result = r2;
            this.label |= IWakeupSessionConstant.RC_ERROR;
            return InteractorReportInitializer.access$runInitRound(this.this$0, this);
        }
    }

    private InteractorReportInitializer() {
    }

    public static /* synthetic */ Unit a() {
        return apmStartedCallback$lambda$2();
    }

    public static /* synthetic */ Thread b(Runnable r0) {
        return initDispatcher$lambda$1(r0);
    }

    static {
        INSTANCE = new InteractorReportInitializer();
        appLogInitialized = new AtomicBoolean(false);
        libTrackInitialized = new AtomicBoolean(false);
        apmInitialized = new AtomicBoolean(false);
        initScheduled = new AtomicBoolean(false);
        ExecutorCoroutineDispatcher r0 = ExecutorsKt.from(PThreadExecutorsUtils.newSingleThreadExecutor(new a()));
        initDispatcher = r0;
        initScope = CoroutineScopeKt.CoroutineScope(r0.plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        readyCallbacks = new ArrayList();
        apmStartedCallback = new b();
        pendingUserId = "";
    }

    private static final Unit apmStartedCallback$lambda$2() {
        if (apmInitialized.compareAndSet(false, true) == false) goto L6;
        SLogger.INSTANCE.i(TAG, "initApm done");
        INSTANCE.notifyReadyIfNeeded();
    L6:
        return Unit.INSTANCE;
    }

    private final void applyReportAccount() {
        String r2 = pendingUserId;
        if (StringsKt.isBlank(r2) == true) goto L28;
    L12:
        Long r3 = StringsKt.toLongOrNull(r2);
        if (r3 == null) goto L15;
        long r6 = r3.longValue();
    L17:
        if (r6 <= 0) goto L19;
        int r4 = pendingOdinUserType;
    L30:
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L22
        InteractorLegacyAppLogHelper.INSTANCE.setBDAccountCallback(new Pair(Integer.valueOf(r4), Long.valueOf(r6)));     // Catch: Throwable -> L22
        SLogger.INSTANCE.i(TAG, "applyReportAccount userIdLen=" + r2.length() + " userType=" + r4);     // Catch: Throwable -> L22
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r7 = Result.exceptionOrNull-impl(r1);
        if (r7 == null) goto L32;
        SLogger.INSTANCE.e(TAG, "applyReportAccount failed", r7);
        return;
    L32:
        return;
    L22:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L24
    L19:
        r4 = 0;
        goto L30
    L15:
        r6 = 0;
        goto L17
    L28:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L6
        Object r10 = Result.constructor-impl(AccountService.a.getUserId());     // Catch: Throwable -> L6
    L9:
        if (Result.isFailure-impl(r10) == false) goto L11;
        r10 = "";
    L11:
        r2 = (String) r10;
    L6:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    private final void initApm() {
        SLogger.INSTANCE.i(TAG, "initApm enter from interactor initializer");
        InteractorApmHelper.INSTANCE.initApm(apmStartedCallback);
    }

    private final void initApmIfNeeded() {
        if (apmInitialized.get() == false) goto L13;
        return;
    L13:
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L7
        initApm();     // Catch: Throwable -> L7
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L15;
        apmInitialized.set(false);
        SLogger.INSTANCE.e(TAG, "initApm failed", r2);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    private final void initAppLog() {
        e10 r0 = e10.a;
        qv9.a r1 = e10.j0().a();
        if (r1 != null) goto L5;
        r1 = new qv9.a(0);
    L5:
        AppHost.Companion r26 = AppHost.a;
        if (r26.isTestChannel() == false) goto L8;
    L10:
        boolean r10 = false;
    L12:
        if (r26.isTestChannel() == false) goto L14;
    L16:
        boolean r11 = false;
    L18:
        if (r26.isDebug() == false) goto L20;
    L22:
        boolean r24 = false;
    L23:
        SLogger.INSTANCE.i(TAG, "initAppLog: " + r26.getAppId() + ", " + r26.getAppName() + ", " + r26.getVersionCode() + ", " + r26.getVersionName() + ", " + r26.getUpdateVersionCode() + ", " + r26.getBuildChannel() + ", " + HttpExtKt.e().a + ", " + r10 + ", " + r11 + ", " + r1.h() + ", " + r26.isTestChannel());
        InteractorLegacyAppLogHelper r2 = InteractorLegacyAppLogHelper.INSTANCE;
        r2.init(new v48.a(r26.getAppId(), r26.getAppName(), r26.getVersionCode(), r26.getVersionName(), r26.getUpdateVersionCode(), r26.getBuildChannel(), HttpExtKt.e().a, r10, r11, r1.h(), r26.isTestChannel(), r1.d(), r1.c(), r1.a(), r1.b(), r1.i(), r1.l(), r1.k(), r1.j(), r24, false));
        if (r26.isDebug() == false) goto L26;
    L27:
        r2.openETVerify();
        return;
    L26:
        if (r26.isTestChannel() == true) goto L27;
        return;
    L20:
        if (r26.isTestChannel() == true) goto L22;
        r24 = true;
        goto L23
    L14:
        if (r1.f() == false) goto L16;
        r11 = true;
        goto L18
    L8:
        if (r1.e() == false) goto L10;
        r10 = true;
        goto L12
    }

    private final void initAppLogIfNeeded() {
        AtomicBoolean r1 = appLogInitialized;
        if (r1.get() == false) goto L13;
        return;
    L13:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        initAppLog();     // Catch: Throwable -> L7
        r1.set(true);     // Catch: Throwable -> L7
        SLogger.INSTANCE.i(TAG, "initAppLog done");     // Catch: Throwable -> L7
        Object r3 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L15;
        appLogInitialized.set(false);
        SLogger.INSTANCE.e(TAG, "initAppLog failed", r4);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    @JvmStatic
    public static final void initIfNeeded() {
        INSTANCE.initIfNeeded(null);
    }

    private final void initLibTrackIfNeeded() {
        AtomicBoolean r1 = libTrackInitialized;
        if (r1.get() == false) goto L13;
        return;
    L13:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        Map r3 = ay9.b.a;     // Catch: Throwable -> L7
        ay9.b.a(AppHost.a.getApplication(), new InteractorReportInitializer$initLibTrackIfNeeded$1$1());     // Catch: Throwable -> L7
        r1.set(true);     // Catch: Throwable -> L7
        SLogger.INSTANCE.i(TAG, "initLibTrack done");     // Catch: Throwable -> L7
        Object r4 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L15;
        libTrackInitialized.set(false);
        SLogger.INSTANCE.e(TAG, "initLibTrack failed", r5);
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public final boolean isApmReady() {
        int r0 = sna.d.a;
        Context r1 = f.a;
        Intrinsics.checkNotNullParameter("reporter_privacy_agreed", "key");
        sna.c r2 = f.b();
        r2.getClass();
        Intrinsics.checkNotNullParameter("reporter_privacy_agreed", "key");
        if (r2.a().getBoolean("reporter_privacy_agreed", false) == true) goto L5;
        return false;
    L5:
        if (apmInitialized.get() == false) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isPrivacyAgreed() {
        int r0 = sna.d.a;
        Context r1 = f.a;
        Intrinsics.checkNotNullParameter("reporter_privacy_agreed", "key");
        sna.c r2 = f.b();
        r2.getClass();
        Intrinsics.checkNotNullParameter("reporter_privacy_agreed", "key");
        return r2.a().getBoolean("reporter_privacy_agreed", false);
    }

    public final boolean isReady() {
        int r0 = sna.d.a;
        Context r1 = f.a;
        Intrinsics.checkNotNullParameter("reporter_privacy_agreed", "key");
        sna.c r2 = f.b();
        r2.getClass();
        Intrinsics.checkNotNullParameter("reporter_privacy_agreed", "key");
        if (r2.a().getBoolean("reporter_privacy_agreed", false) == true) goto L5;
        return false;
    L5:
        if (appLogInitialized.get() == true) goto L7;
        return false;
    L7:
        if (libTrackInitialized.get() == false) goto L12;
        return true;
    L12:
        return false;
    }

    private final boolean notifyReadyIfNeeded() {
        if (isReady() == true) goto L6;
        return false;
    L6:
        applyReportAccount();
        List<Function0<Unit>> r0 = readyCallbacks;
        monitor-enter(r0);
        List r1 = CollectionsKt.toList(r0);     // Catch: Throwable -> L23
        r0.clear();     // Catch: Throwable -> L23
        monitor-exit(r0);
        Iterator r2 = r1.iterator();
    L12:
        if (r2.hasNext() == false) goto L21;
        Function0 r3 = (Function0) r2.next();
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L16
        r3.invoke();     // Catch: Throwable -> L16
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L12;
        SLogger.INSTANCE.e(TAG, "ready callback failed", r6);
    L16:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L21:
        return true;
    L23:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ CoroutineScope access$getInitScope$p() {
        return initScope;
    }

    private static final Thread initDispatcher$lambda$1(Runnable r2) {
        PthreadThreadV2 r0 = new PthreadThreadV2(r2, TAG);
        r0.setDaemon(true);
        return r0;
    }

    private final Object runInitRound(Continuation<? super Unit> r5) {
        if ((r5 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r0 = (AnonymousClass1) r5;
        int r1 = r0.label;
        if ((r1 & IWakeupSessionConstant.RC_ERROR) == 0) goto L7;
        r0.label = r1 - IWakeupSessionConstant.RC_ERROR;
    L8:
        Object r6 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r6);
    L21:
        initIfNeeded();
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r6);
        initAppLogIfNeeded();
        initLibTrackIfNeeded();
        initApmIfNeeded();
        initScheduled.set(false);
        if (notifyReadyIfNeeded() == true) goto L17;
        r0.label = 1;
        if (DelayKt.delay(RETRY_DELAY_MS, r0) != r2) goto L21;
        return r2;
    L17:
        return Unit.INSTANCE;
    L7:
        r0 = new AnonymousClass1(this, r5);
        goto L8
    }

    public final void initIfNeeded(Function0<Unit> r7) {
        int r0 = sna.d.a;
        Context r1 = f.a;
        Intrinsics.checkNotNullParameter("reporter_privacy_agreed", "key");
        sna.c r2 = f.b();
        r2.getClass();
        Intrinsics.checkNotNullParameter("reporter_privacy_agreed", "key");
        if (r2.a().getBoolean("reporter_privacy_agreed", false) == true) goto L7;
        SLogger.INSTANCE.i(TAG, "init skipped: privacy not agreed");
        return;
    L7:
        if (isReady() == false) goto L11;
        if (r7 == null) goto L27;
        r7.invoke();
        return;
    L27:
        return;
    L11:
        if (r7 == null) goto L21;
        List<Function0<Unit>> r3 = readyCallbacks;
        monitor-enter(r3);
        r3.add(r7);     // Catch: Throwable -> L17
        monitor-exit(r3);
    L17:
        th = move-exception;
        throw th;
    L21:
        if (initScheduled.compareAndSet(false, true) == true) goto L23;
        return;
    L23:
        BuildersKt.launch$default(initScope, null, null, new AnonymousClass2(null), 3, null);
    }

    public static final /* synthetic */ Object access$runInitRound(InteractorReportInitializer r0, Continuation r1) {
        return r0.runInitRound(r1);
    }

    public final void updateReportAccount(String r1, int r2) {
        if (r1 != null) goto L4;
        r1 = "";
    L4:
        pendingUserId = r1;
        pendingOdinUserType = r2;
        if (isReady() == false) goto L8;
        applyReportAccount();
        return;
    }
}
