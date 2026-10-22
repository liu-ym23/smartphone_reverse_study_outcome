package com.obric.memorydata.ui;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.ae;
import kotlinx.coroutines.flow.ar;
import kotlinx.coroutines.flow.at;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001VB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010+\u001a\u00020,J\u000e\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020\u00152\u0006\u0010.\u001a\u00020/J\u0010\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u000bH\u0002J\b\u00103\u001a\u00020\u000bH\u0002J\u0006\u00104\u001a\u00020\u0015J\u000e\u00105\u001a\u00020,2\u0006\u00106\u001a\u00020\u0015J\u0006\u00107\u001a\u00020\u0015J\u0006\u00108\u001a\u00020\u0015J\u0006\u00109\u001a\u00020\u0015J\u0006\u0010\u001e\u001a\u00020,J\u0006\u0010:\u001a\u00020,J\u000e\u0010;\u001a\u00020,2\u0006\u0010<\u001a\u00020\u0005J\u0010\u0010=\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/H\u0002J\u0016\u0010>\u001a\u00020,2\u0006\u0010?\u001a\u00020'2\u0006\u0010<\u001a\u00020\u0005J\u0018\u0010@\u001a\u00020,2\u0006\u0010A\u001a\u00020'2\b\b\u0002\u0010B\u001a\u00020\u000bJ\\\u0010C\u001a\u00020,2\u0006\u0010A\u001a\u00020'2\u0006\u0010D\u001a\u00020\u00152\f\u0010E\u001a\b\u0012\u0004\u0012\u00020,0F26\u0010G\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110L¢\u0006\f\bI\u0012\b\bJ\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020,0HJB\u0010N\u001a\u00020,2\u0006\u0010A\u001a\u00020'2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020,0F2\u0018\u0010G\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020,0H2\b\b\u0002\u0010O\u001a\u00020\u000bH\u0002J\u0012\u0010P\u001a\u0004\u0018\u00010\u00052\u0006\u0010A\u001a\u00020'H\u0002J\u0010\u0010Q\u001a\u00020\u00052\u0006\u0010A\u001a\u00020'H\u0002J\u0012\u0010R\u001a\u00020\u00052\b\u0010A\u001a\u0004\u0018\u00010'H\u0002J8\u0010S\u001a\u00020,2\u0006\u0010A\u001a\u00020'2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020,0F2\u0018\u0010G\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020,0HH\u0002J\u0018\u0010T\u001a\u00020L2\u0006\u0010K\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Lcom/obric/memorydata/ui/IdentityController;", "", "<init>", "()V", "TAG", "", "STORE_KEY_MEMORY_IDENTITY_AUTH", "AUTH_COOLDOWN_MS", "", "AUTH_MIN_LAUNCH_GAP_MS", "AUTH_LAUNCH_READY_MAX_ATTEMPTS", "", "FAST_CANCEL_AS_SYSTEM_MS", "mainHandler", "Landroid/os/Handler;", "store", "Lcom/obric/memorydata/middleware/api/store/IStore;", "authSessionStore", "Lcom/obric/memorydata/ui/IdentityAuthSessionStore;", "_needIdentityAuth", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "needIdentityAuth", "Lkotlinx/coroutines/flow/StateFlow;", "getNeedIdentityAuth", "()Lkotlinx/coroutines/flow/StateFlow;", EventBody.KEY_VALUE, "needReAuth", "getNeedReAuth", "()Z", "authed", "initialized", "authSessionId", "Ljava/util/concurrent/atomic/AtomicLong;", "currentSessionId", "currentPrompt", "Landroidx/biometric/BiometricPrompt;", "currentAuthOwner", "Ljava/lang/ref/WeakReference;", "Landroidx/fragment/app/FragmentActivity;", "authInFlight", "lastAuthEndElapsedMs", "lastAuthStartElapsedMs", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "canAuthenticate", "context", "Landroid/content/Context;", "isDeviceAuthAvailable", "isUnavailableTerminal", "code", "allowedAuthenticators", "isNeedIdentityAuth", "saveNeedIdentityAuth", "need", "needAuth", "isInFlight", "isAuthed", "freeAuthed", "requireReAuth", InfoRequestQPSOptTraceLogger.REASON, "currentBootCount", "invalidatePendingAuth", "owner", "checkAndAuth", "activity", "requestCode", "auth", "userInitiated", "onPassed", "Lkotlin/Function0;", "onFail", "Lkotlin/Function2;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "errorCode", "Lcom/obric/memorydata/ui/IdentityController$AuthCancelSource;", AILabCheckPermissionTask.KEY_SOURCE, "scheduleDoAuth", "attempts", "getAuthLaunchNotReadyReason", "activityAuthStateForLog", "activityNameForLog", "doAuth", "resolveCancelSource", "sinceStartMs", "AuthCancelSource", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IdentityController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final IdentityController f12979a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Handler f12980b = null;
    private static final IStore c = null;
    private static final f d = null;
    private static final ae<Boolean> e = null;
    private static final ar<Boolean> f = null;
    private static boolean g;
    private static boolean h;
    private static volatile boolean i;
    private static final AtomicLong j = null;
    private static long k;
    private static BiometricPrompt l;
    private static WeakReference<FragmentActivity> m;
    private static boolean n;
    private static long o;
    private static long p;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/ui/IdentityController$AuthCancelSource;", "", "<init>", "(Ljava/lang/String;I)V", "USER_CANCEL", "SYSTEM_INTERRUPT", "ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum AuthCancelSource extends Enum<AuthCancelSource> {
        private static final /* synthetic */ EnumEntries $ENTRIES = null;
        private static final /* synthetic */ AuthCancelSource[] $VALUES = null;
        public static final AuthCancelSource SYSTEM_INTERRUPT = null;
        public static final AuthCancelSource USER_CANCEL = null;

        private static final /* synthetic */ AuthCancelSource[] $values() {
            return new AuthCancelSource[]{USER_CANCEL, SYSTEM_INTERRUPT};
        }

        static {
            USER_CANCEL = new AuthCancelSource("USER_CANCEL", 0);
            SYSTEM_INTERRUPT = new AuthCancelSource("SYSTEM_INTERRUPT", 1);
            AuthCancelSource[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = EnumEntriesKt.enumEntries((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.memorydata.plugin"));
        }

        private AuthCancelSource(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumEntries<AuthCancelSource> getEntries() {
            return $ENTRIES;
        }

        public static AuthCancelSource valueOf(String r2) {
            return (AuthCancelSource) ZeusTransformUtils.preCheckCast(Enum.valueOf(AuthCancelSource.class, r2), AuthCancelSource.class, "com.obric.memorydata.plugin");
        }

        public static AuthCancelSource[] values() {
            return (AuthCancelSource[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AuthCancelSource[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f12979a = new IdentityController();
        f12980b = new Handler(Looper.getMainLooper());
        IStore r0 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        c = r0;
        d = new f(r0);
        ae<Boolean> r1 = at.a(Boolean.valueOf(r0.getBoolean("memory_identity_auth", false)));
        e = r1;
        f = (ar) ZeusTransformUtils.preCheckCast(r1, ar.class, "com.obric.memorydata.plugin");
        g = true;
        j = new AtomicLong(0);
    }

    private IdentityController() {
    }

    private final AuthCancelSource a(int r1, long r2) {
        if (r1 == 10) goto L8;
        if (r1 == 13) goto L8;
    L12:
        return AuthCancelSource.SYSTEM_INTERRUPT;
    L8:
        if (r2 < 1500) goto L12;
        return AuthCancelSource.USER_CANCEL;
    }

    public static final /* synthetic */ AuthCancelSource a(IdentityController r0, int r1, long r2) {
        return r0.a(r1, r2);
    }

    private final String a(FragmentActivity r2) {
        FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r2, FragmentActivity.class, "com.obric.memorydata.plugin");
        Lifecycle.State r3 = r1.getLifecycle().getCurrentState();
        Intrinsics.checkNotNullExpressionValue(r3, "getCurrentState(...)");
        if (r3.isAtLeast(Lifecycle.State.RESUMED) == true) goto L7;
        return "lifecycle=" + r3;
    L7:
        if (r1.getSupportFragmentManager().isStateSaved() == false) goto L11;
        return "fragmentStateSaved";
    L11:
        if (r1.hasWindowFocus() == true) goto L14;
        return "noWindowFocus";
    L14:
        Window r4 = r1.getWindow();
        boolean r5 = true;
        if (r4 == null) goto L21;
        View r6 = r4.getDecorView();
        if (r6 == null) goto L21;
        if (r6.isAttachedToWindow() != true) goto L21;
    L22:
        if (r5 == true) goto L25;
        return "decorNotAttached";
    L25:
        return null;
    L21:
        r5 = false;
        goto L22
    }

    public static final /* synthetic */ void a(long r0) {
        o = r0;
    }

    public static final /* synthetic */ void a(BiometricPrompt r0) {
        l = r0;
    }

    private final void a(FragmentActivity r11, Function0<Unit> r12, Function2<? super Integer, ? super AuthCancelSource, Unit> r13) {
        FragmentActivity r14 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r11, FragmentActivity.class, "com.obric.memorydata.plugin");
        final Function0 r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r12, Function0.class, "com.obric.memorydata.plugin");
        final Function2 r16 = (Function2) ZeusTransformUtils.wrapperContextForParams(r13, Function2.class, "com.obric.memorydata.plugin");
        final long r2 = j.incrementAndGet();
        k = r2;
        n = true;
        m = new WeakReference(r14);
        p = SystemClock.elapsedRealtime();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IdentityController", "doAuth: start session=" + r2, false, 4, null);
        Executor r0 = ContextCompat.getMainExecutor((Context) ZeusTransformUtils.preCheckCast(r14, Context.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNullExpressionValue(r0, "getMainExecutor(...)");
        BiometricPrompt r17 = new BiometricPrompt(r14, r0, (BiometricPrompt.AuthenticationCallback) ZeusTransformUtils.preCheckCast(new IdentityController$doAuth$callback$1(r2, r15, r16), BiometricPrompt.AuthenticationCallback.class, "com.obric.memorydata.plugin"));
        l = r17;
        BiometricPrompt.PromptInfo r18 = new BiometricPrompt.PromptInfo.Builder().setTitle((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_identity_auth_title, TypedValues.Custom.S_STRING, "memory_identity_auth_title")), CharSequence.class, "com.obric.memorydata.plugin")).setSubtitle((CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.utils.at.a(ZeusTransformUtils.mapRes(R.string.memory_identity_auth_subtitle, TypedValues.Custom.S_STRING, "memory_identity_auth_subtitle")), CharSequence.class, "com.obric.memorydata.plugin")).setAllowedAuthenticators(k()).build();
        Intrinsics.checkNotNullExpressionValue(r18, "build(...)");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
        IdentityController r10 = (IdentityController) ZeusTransformUtils.preCheckCast(this, IdentityController.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        r17.authenticate(r18);     // Catch: Throwable -> L5
        Object r19 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L8:
        if (Result.m1428isSuccessimpl(r19) == false) goto L10;
        Unit r110 = (Unit) ZeusTransformUtils.preCheckCast(r19, Unit.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IdentityController", "doAuth: authenticate requested session=" + r2, false, 4, null);
    L10:
        Throwable r111 = Result.m1424exceptionOrNullimpl(r19);
        if (r111 == null) goto L16;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IdentityController", "doAuth: authenticate threw " + r111.getClass().getSimpleName() + ": " + r111.getMessage(), false, 4, null);
        n = false;
        l = null;
        m = null;
        o = SystemClock.elapsedRealtime();
        r16.invoke(-1, AuthCancelSource.SYSTEM_INTERRUPT);
        return;
    L16:
        return;
    L5:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r19 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    private final void a(FragmentActivity r10, Function0<Unit> r11, Function2<? super Integer, ? super AuthCancelSource, Unit> r12, final int r13) {
        final FragmentActivity r14 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r10, FragmentActivity.class, "com.obric.memorydata.plugin");
        final Function0<Unit> r15 = (Function0) ZeusTransformUtils.wrapperContextForParams(r11, Function0.class, "com.obric.memorydata.plugin");
        final Function2<? super Integer, ? super AuthCancelSource, Unit> r16 = (Function2) ZeusTransformUtils.wrapperContextForParams(r12, Function2.class, "com.obric.memorydata.plugin");
        String r0 = a(r14);
        if (r0 != null) goto L5;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IdentityController", "scheduleDoAuth: ready, doAuth " + b(r14), false, 4, null);
        a(r14, r15, r16);
        return;
    L5:
        if (r13 < 40) goto L7;
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IdentityController", "scheduleDoAuth: give up, attempts=" + r13 + " reason=" + r0 + " state=" + r14.getLifecycle().getCurrentState(), false, 4, null);
        r16.invoke(-1, AuthCancelSource.SYSTEM_INTERRUPT);
        return;
    L7:
        if (r14.isFinishing() == true) goto L13;
        if (r14.isDestroyed() == true) goto L13;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IdentityController", "scheduleDoAuth: wait, attempts=" + r13 + " reason=" + r0, false, 4, null);
        f12980b.postDelayed(new $$Lambda$IdentityController$RRfs6gmL8gQwdU0LKDWUcHmpS_c(r14, r15, r16, r13), 50);
    }

    static /* synthetic */ void a(IdentityController r1, FragmentActivity r2, Function0 r3, Function2 r4, int r5, int r6, Object r7) {
        FragmentActivity r8 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r2, FragmentActivity.class, "com.obric.memorydata.plugin");
        Function0<Unit> r9 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function2<? super Integer, ? super AuthCancelSource, Unit> r10 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        if ((r6 & 8) == 0) goto L5;
        r5 = 0;
    L5:
        r1.a(r8, r9, r10, r5);
    }

    public static final /* synthetic */ void a(WeakReference r0) {
        m = r0;
    }

    private final boolean a(int r1) {
        if (r1 != 11) goto L5;
    L12:
        return true;
    L5:
        if (r1 == 12) goto L12;
        if (r1 == 15) goto L12;
        if (r1 == (-2)) goto L12;
        return false;
    }

    private final String b(FragmentActivity r4) {
        FragmentActivity r3 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r4, FragmentActivity.class, "com.obric.memorydata.plugin");
        StringBuilder r5 = new StringBuilder().append("state=").append(r3.getLifecycle().getCurrentState()).append(" stateSaved=").append(r3.getSupportFragmentManager().isStateSaved()).append(" hasFocus=").append(r3.hasWindowFocus()).append(" decorAttached=");
        Window r0 = r3.getWindow();
        boolean r1 = true;
        if (r0 == null) goto L9;
        View r2 = r0.getDecorView();
        if (r2 == null) goto L9;
        if (r2.isAttachedToWindow() != true) goto L9;
    L11:
        return r5.append(r1).append(" finishing=").append(r3.isFinishing()).append(" destroyed=").append(r3.isDestroyed()).toString();
    L9:
        r1 = false;
        goto L11
    }

    private static final void b(FragmentActivity r2, Function0 r3, Function2 r4) {
        FragmentActivity r5 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r2, FragmentActivity.class, "com.obric.memorydata.plugin");
        Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function2<? super Integer, ? super AuthCancelSource, Unit> r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        f12979a.a(r5, true, r6, r7);
    }

    private static final void b(FragmentActivity r2, Function0 r3, Function2 r4, int r5) {
        FragmentActivity r6 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r2, FragmentActivity.class, "com.obric.memorydata.plugin");
        Function0<Unit> r7 = (Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin");
        Function2<? super Integer, ? super AuthCancelSource, Unit> r8 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        f12979a.a(r6, r7, r8, r5 + 1);
    }

    public static final /* synthetic */ void b(boolean r0) {
        n = r0;
    }

    private final int c(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        IdentityController r3 = (IdentityController) ZeusTransformUtils.preCheckCast(this, IdentityController.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        Object r6 = Result.m1421constructorimpl(Integer.valueOf(Settings.Global.getInt(r5.getContentResolver(), "boot_count")));     // Catch: Throwable -> L5
    L7:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L12;
        RunLog.INSTANCE.error("IdentityController", "get boot count failed", r7);
        r6 = -1;
    L12:
        return ((Number) ZeusTransformUtils.preCheckCast(r6, Number.class, "com.obric.memorydata.plugin")).intValue();
    L5:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final String c(FragmentActivity r2) {
        FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r2, FragmentActivity.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return "null";
    L7:
        return r1.getClass().getSimpleName() + '@' + Integer.toHexString(r1.hashCode());
    }

    public static final /* synthetic */ long i() {
        return k;
    }

    public static final /* synthetic */ long j() {
        return p;
    }

    private final int k() {
        return 32783;
    }

    public static /* synthetic */ void lambda$RRfs6gmL8gQwdU0LKDWUcHmpS_c(FragmentActivity r0, Function0 r1, Function2 r2, int r3) {
        b(r0, r1, r2, r3);
    }

    public static /* synthetic */ void lambda$_QFKNbNB_ZCQlvQNX1PX_Tezgvg(FragmentActivity r0, Function0 r1, Function2 r2) {
        b(r0, r1, r2);
    }

    public final int a(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        return BiometricManager.from(r4).canAuthenticate(k());
    }

    public final ar<Boolean> a() {
        return f;
    }

    public final void a(FragmentActivity r11, String r12) {
        FragmentActivity r13 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r11, FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "owner");
        Intrinsics.checkNotNullParameter(r12, InfoRequestQPSOptTraceLogger.REASON);
        if (n == false) goto L5;
    L8:
        WeakReference<FragmentActivity> r0 = m;
        if (r0 == null) goto L11;
        FragmentActivity r1 = (FragmentActivity) ZeusTransformUtils.preCheckCast(r0.get(), FragmentActivity.class, "com.obric.memorydata.plugin");
    L13:
        if (r1 == r13) goto L16;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IdentityController", "invalidatePendingAuth: skip non-owner reason=" + r12 + " owner=" + c(r13) + " activeOwner=" + c(r1), false, 4, null);
        return;
    L16:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IdentityController", "invalidatePendingAuth: bump session, cancel current prompt reason=" + r12 + " owner=" + c(r13), false, 4, null);
        k = j.incrementAndGet();
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L23
        IdentityController r10 = (IdentityController) ZeusTransformUtils.preCheckCast(this, IdentityController.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        BiometricPrompt r15 = l;     // Catch: Throwable -> L23
        if (r15 == null) goto L20;
        r15.cancelAuthentication();     // Catch: Throwable -> L23
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L23
    L21:
        Result.m1421constructorimpl(r16);     // Catch: Throwable -> L23
    L25:
        l = null;
        m = null;
        n = false;
        return;
    L20:
        r16 = null;
    L23:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L25
    L11:
        r1 = null;
        goto L13
    L5:
        if (l != null) goto L8;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IdentityController", "invalidatePendingAuth: no active session reason=" + r12, false, 4, null);
    }

    public final void a(FragmentActivity r21, boolean r22, Function0<Unit> r23, Function2<? super Integer, ? super AuthCancelSource, Unit> r24) {
        final FragmentActivity r2 = (FragmentActivity) ZeusTransformUtils.wrapperContextForParams(r21, FragmentActivity.class, "com.obric.memorydata.plugin");
        final Function0 r4 = (Function0) ZeusTransformUtils.wrapperContextForParams(r23, Function0.class, "com.obric.memorydata.plugin");
        final Function2 r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r24, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r4, "onPassed");
        Intrinsics.checkNotNullParameter(r5, "onFail");
        long r6 = SystemClock.elapsedRealtime();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IdentityController", "auth: enter userInitiated=" + r22 + " inFlight=" + n + " needAuth=" + d() + ' ' + b(r2), false, 4, null);
        if (n == false) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IdentityController", "auth: already in flight, skip", false, 4, null);
        return;
    L6:
        if (r22 == false) goto L8;
    L11:
        long r8 = p;
        if ((r6 - r8) >= 600) goto L21;
        long r12 = 600 - (r6 - r8);
        IRunLog r14 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r0 = new StringBuilder().append("auth: launch gap, ");
        if (r22 == false) goto L16;
        String r3 = "retry";
    L17:
        IRunLog.a.a(r14, "IdentityController", r0.append(r3).append(" (delta=").append(r6 - p).append("ms, delay=").append(r12).append(')').toString(), false, 4, null);
        if (r22 == false) goto L30;
        f12980b.postDelayed(new $$Lambda$IdentityController$_QFKNbNB_ZCQlvQNX1PX_Tezgvg(r2, r4, r5), r12);
        return;
    L30:
        return;
    L16:
        r3 = "skip";
        goto L17
    L21:
        int r1 = a((Context) ZeusTransformUtils.preCheckCast(r2, Context.class, "com.obric.memorydata.plugin"));
        if (r1 != 0) goto L24;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IdentityController", "auth: canAuthenticate success, schedule auth " + b(r2), false, 4, null);
        a(this, r2, r4, r5, 0, 8, null);
        return;
    L24:
        if (a(r1) == false) goto L26;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IdentityController", "auth: device cannot authenticate (code=" + r1 + ", terminal) → pass through", false, 4, null);
        g();
        r4.invoke();
        return;
    L26:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IdentityController", "auth: canAuthenticate=" + r1 + ", treat as system interrupt", false, 4, null);
        r5.invoke(Integer.valueOf(r1), AuthCancelSource.SYSTEM_INTERRUPT);
        return;
    L8:
        if ((r6 - o) >= 1500) goto L11;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IdentityController", "auth: cooldown, skip (delta=" + (r6 - o) + "ms)", false, 4, null);
    }

    public final void a(String r8) {
        Intrinsics.checkNotNullParameter(r8, InfoRequestQPSOptTraceLogger.REASON);
        h = false;
        g = true;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IdentityController", "requireReAuth: reason=" + r8 + " persist invalidation=" + d.a(), false, 4, null);
    }

    public final void a(boolean r3) {
        e.b(Boolean.valueOf(r3));
        c.save("memory_identity_auth", r3);
        if (r3 == true) goto L6;
        a("identity_auth_disabled");
        return;
    }

    public final synchronized void b() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (i == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Object r1 = r0.getSystemService("power");     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type android.os.PowerManager");     // Catch: Throwable -> L14
        PowerManager r2 = (PowerManager) ZeusTransformUtils.preCheckCast(r1, PowerManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        Object r3 = r0.getSystemService("keyguard");     // Catch: Throwable -> L14
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.app.KeyguardManager");     // Catch: Throwable -> L14
        KeyguardManager r4 = (KeyguardManager) ZeusTransformUtils.preCheckCast(r3, KeyguardManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        int r5 = c(r0);     // Catch: Throwable -> L14
        boolean r6 = d.a(r5, r2.isInteractive(), r4.isDeviceLocked());     // Catch: Throwable -> L14
        h = r6;     // Catch: Throwable -> L14
        if (r6 == true) goto L10;
        boolean r7 = true;
    L11:
        g = r7;     // Catch: Throwable -> L14
        i = true;     // Catch: Throwable -> L14
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IdentityController", "init: restore session=" + r6 + " bootCount=" + r5 + " interactive=" + r2.isInteractive() + " deviceLocked=" + r4.isDeviceLocked(), false, 4, null);     // Catch: Throwable -> L14
        monitor-exit(this);
        return;
    L10:
        r7 = false;
        goto L11
    }

    public final boolean b(Context r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "context");
        if (a(r4) != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean c() {
        return ((Boolean) ZeusTransformUtils.preCheckCast(e.c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public final boolean d() {
        b();
        if (c() == true) goto L5;
    L9:
        return false;
    L5:
        if (g == false) goto L9;
        if (h == true) goto L9;
        return true;
    }

    public final boolean e() {
        return n;
    }

    public final boolean f() {
        return h;
    }

    public final void g() {
        h = true;
        g = false;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IdentityController", "authed: persist session=" + d.a(c((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"))), false, 4, null);
    }

    public final void h() {
        a("free_authed");
    }
}
