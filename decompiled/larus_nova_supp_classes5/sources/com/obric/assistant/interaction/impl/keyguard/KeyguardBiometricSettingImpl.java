package com.obric.assistant.interaction.impl.keyguard;

import android.os.Build;
import android.provider.Settings;
import com.bytedance.keva.Keva;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ISessionAuthenticationService;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.keyguard.BiometricState;
import com.obric.assistant.interaction.api.keyguard.IKeyguardBiometricSetting;
import com.obric.assistant.interaction.api.keyguard.RequestSource;
import com.obric.assistant.interaction.impl.ObricKeyguardServiceImpl;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\f\b\u0007\u0018\u0000 '2\u00020\u0001:\u0001'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\rH\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\fH\u0016J\u0018\u0010 \u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010!\u001a\u00020\bH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\b\u0010#\u001a\u00020\u001cH\u0002J\b\u0010$\u001a\u00020\u001cH\u0002J\u0010\u0010%\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\b\u0010&\u001a\u00020\u0005H\u0002R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0010\u0010\u0012R#\u0010\u0015\u001a\n \u0017*\u0004\u0018\u00010\u00160\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u0018\u0010\u0019¨\u0006("}, d2 = {"Lcom/obric/assistant/interaction/impl/keyguard/KeyguardBiometricSettingImpl;", "Lcom/obric/assistant/interaction/api/keyguard/IKeyguardBiometricSetting;", "<init>", "()V", "cachedSystemSettingsState", "", "Ljava/lang/Integer;", "isSystemSettingChanged", "", "hasPendingCancelRequest", "requestStates", "", "Lcom/obric/assistant/interaction/api/keyguard/RequestSource;", "Lcom/obric/assistant/interaction/api/keyguard/BiometricState;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "isBiometricAuthenticating", "Lkotlinx/coroutines/flow/StateFlow;", "()Lkotlinx/coroutines/flow/StateFlow;", "isBiometricAuthenticating$delegate", "Lkotlin/Lazy;", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "init", "", "requestBiometricState", "requestSource", "state", "cancelRequestBiometricState", "ignoreBiometricAuthenticating", "adjustSystemSettingStateIfCancelPending", "adjustSystemSettingState", "restorePendingBiometricSettingIfNeeded", "setBiometricKeyguardState", "getBiometricKeyguardState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeyguardBiometricSettingImpl implements IKeyguardBiometricSetting {
    public static final Companion Companion = null;
    private static final int DEFAULT_BIOMETRIC_KEYGUARD_DISABLED = 0;
    private static final int DEFAULT_BIOMETRIC_KEYGUARD_ENABLED = 1;
    private static final String KEVA_REPO_NAME = "obric_keyguard_biometric_setting";
    private static final String KEY_BIOMETRIC_KEYGUARD_ENABLED = "biometric_keyguard_enabled";
    private static final String KEY_SHOULD_RESTORE_ENABLED = "should_restore_enabled";
    private static final String TAG = "KeyguardBiometricSettingImpl";
    private Integer cachedSystemSettingsState;
    private boolean hasPendingCancelRequest;
    private final Lazy isBiometricAuthenticating$delegate;
    private boolean isSystemSettingChanged;
    private final Lazy keva$delegate;
    private final CoroutineScope mainScope;
    private final Map<RequestSource, BiometricState> requestStates;

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.keyguard.KeyguardBiometricSettingImpl$init$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isAuthenticating", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.keyguard.KeyguardBiometricSettingImpl$init$1", f = "KeyguardBiometricSettingImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        /* synthetic */ boolean Z$0;
        int label;
        final /* synthetic */ KeyguardBiometricSettingImpl this$0;

        public AnonymousClass1(KeyguardBiometricSettingImpl r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.Z$0 = ((Boolean) r3).booleanValue();
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
        }

        public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
            return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r2);
            if (this.Z$0 == true) goto L8;
            KeyguardBiometricSettingImpl.access$adjustSystemSettingStateIfCancelPending(this.this$0);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ Keva a() {
        return keva_delegate$lambda$1();
    }

    private final void adjustSystemSettingState() {
        this.hasPendingCancelRequest = false;
        if ((!this.requestStates.isEmpty()) == false) goto L27;
        Integer r1 = this.cachedSystemSettingsState;
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L8:
        Enum r4 = (BiometricState) this.requestStates.get(RequestSource.DISMISS_KEYGUARD);
        Enum r5 = (BiometricState) this.requestStates.get(RequestSource.WINDOW);
        FLogger r6 = FLogger.a;
        r6.i(TAG, "adjustSystemSettingState, keyguardRequestState = " + r4 + ", windowRequestState = " + r5 + ", cachedSystemSettingsState = " + r2);
        if (r4 != null) goto L12;
        r4 = r5;
    L12:
        if (r4 != null) goto L14;
        int r7 = -1;
    L15:
        if (r7 == (-1)) goto L34;
        if (r7 == 1) goto L24;
        if (r7 != 2) goto L22;
        if (r2 == 0) goto L35;
        r6.i(TAG, "system setting not disabled, change to disabled");
        this.isSystemSettingChanged = true;
        setBiometricKeyguardState(0);
        return;
    L35:
        return;
    L22:
        throw new NoWhenBranchMatchedException();
    L24:
        if (this.isSystemSettingChanged == false) goto L26;
        r6.i(TAG, "system setting changed, restore to default");
        setBiometricKeyguardState(r2);
        return;
    L26:
        r6.i(TAG, "system setting not changed, keep default");
        return;
    L34:
        return;
    L14:
        r7 = WhenMappings.$EnumSwitchMapping$0[r4.ordinal()];
        goto L15
    L7:
        r2 = getBiometricKeyguardState();
        FLogger.a.i(TAG, "adjustSystemSettingState, cachedSystemSettingsState = " + r2);
        this.cachedSystemSettingsState = Integer.valueOf(r2);
        goto L8
    L27:
        FLogger r3 = FLogger.a;
        r3.i(TAG, "cachedSystemSettingsState = " + this.cachedSystemSettingsState + ", isSystemSettingChanged = " + this.isSystemSettingChanged);
        if (this.isSystemSettingChanged == false) goto L32;
        this.isSystemSettingChanged = false;
        Integer r0 = this.cachedSystemSettingsState;
        if (r0 == null) goto L32;
        int r8 = r0.intValue();
        r3.i(TAG, "restore to " + r8);
        setBiometricKeyguardState(r8);
    L32:
        this.cachedSystemSettingsState = null;
    }

    private final synchronized void adjustSystemSettingStateIfCancelPending() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.hasPendingCancelRequest == false) goto L12;
        i1<Boolean> r0 = isBiometricAuthenticating();     // Catch: Throwable -> L14
        boolean r1 = false;
        if (r0 != null) goto L8;
    L10:
        if (r1 == true) goto L12;
        FLogger.a.i(TAG, "biometric authentication finished, adjust pending cancel request");     // Catch: Throwable -> L14
        adjustSystemSettingState();     // Catch: Throwable -> L14
        goto L12
    L8:
        if (((Boolean) r0.getValue()).booleanValue() != true) goto L10;
        r1 = true;
    L12:
        monitor-exit(this);
    }

    public static /* synthetic */ i1 b() {
        return isBiometricAuthenticating_delegate$lambda$0();
    }

    private final int getBiometricKeyguardState() {
        return Settings.Secure.getInt(AppHost.a.getApplication().getContentResolver(), KEY_BIOMETRIC_KEYGUARD_ENABLED, 1);
    }

    private final Keva getKeva() {
        return (Keva) this.keva$delegate.getValue();
    }

    private final i1<Boolean> isBiometricAuthenticating() {
        return (i1) this.isBiometricAuthenticating$delegate.getValue();
    }

    private static final i1 isBiometricAuthenticating_delegate$lambda$0() {
        ISessionAuthenticationService r0 = (ISessionAuthenticationService) ServiceManager.get().getService(ISessionAuthenticationService.class);
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.l();
    }

    private static final Keva keva_delegate$lambda$1() {
        return Keva.getRepo(KEVA_REPO_NAME, 0);
    }

    public void init() {
        FLogger.a.i(TAG, "init");
        restorePendingBiometricSettingIfNeeded();
        final i1<Boolean> r0 = isBiometricAuthenticating();
        if (r0 == null) goto L6;
        final AnonymousClass1 r1 = new AnonymousClass1(this, null);
        e.x(new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r0, r1), this.mainScope);
    L6:
        if (Build.VERSION.SDK_INT < 33) goto L9;
        IKeyguardStateKt.getKeyguardState().registerKeyguardLockStateChangedListener(new AnonymousClass2(this));
        return;
    }

    public KeyguardBiometricSettingImpl() {
        this.requestStates = new LinkedHashMap();
        this.mainScope = CoroutineScopeKt.MainScope();
        this.isBiometricAuthenticating$delegate = LazyKt.lazy(new a());
        this.keva$delegate = LazyKt.lazy(new b());
    }

    private final void restorePendingBiometricSettingIfNeeded() {
        boolean r0 = getKeva().getBoolean(KEY_SHOULD_RESTORE_ENABLED, false);
        FLogger.a.i(TAG, "restorePendingBiometricSettingIfNeeded, shouldRestoreEnabled = " + r0);
        if (r0 == true) goto L5;
        return;
    L5:
        setBiometricKeyguardState(1);
    }

    public static final /* synthetic */ void access$adjustSystemSettingStateIfCancelPending(KeyguardBiometricSettingImpl r0) {
        r0.adjustSystemSettingStateIfCancelPending();
    }

    private final void setBiometricKeyguardState(int r9) {
        FLogger r0 = FLogger.a;
        r0.i(TAG, "setBiometricKeyguardState, state = " + r9);
        if (r9 != 0) goto L21;
        getKeva().storeBoolean(KEY_SHOULD_RESTORE_ENABLED, true);
        r0.i(TAG, "record pending biometric setting restore");
    L21:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L7
        Object r2 = Result.constructor-impl(Boolean.valueOf(Settings.Secure.putInt(AppHost.a.getApplication().getContentResolver(), KEY_BIOMETRIC_KEYGUARD_ENABLED, r9)));     // Catch: Throwable -> L7
    L9:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L13;
        FLogger.a.w(ObricKeyguardServiceImpl.TAG, "setBiometricKeyguardState failed: " + r3.getMessage(), r3);
    L13:
        if (Result.isSuccess-impl(r2) == true) goto L15;
        return;
    L15:
        if (((Boolean) r2).booleanValue() == true) goto L17;
        FLogger.a.w(ObricKeyguardServiceImpl.TAG, "setBiometricKeyguardState failed: putInt returned false, state = " + r9);
        return;
    L17:
        if (r9 == 0) goto L19;
        getKeva().erase(KEY_SHOULD_RESTORE_ENABLED);
        FLogger.a.i(TAG, "clear pending biometric setting restore");
    L19:
        FLogger.a.i(ObricKeyguardServiceImpl.TAG, "setBiometricKeyguardState success: state = " + r9);
        return;
    L7:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }

    public void cancelRequestBiometricState(RequestSource r2) {
        Intrinsics.checkNotNullParameter(r2, "requestSource");
        cancelRequestBiometricState(r2, false);
    }

    private final synchronized void cancelRequestBiometricState(RequestSource r5, boolean r6) {
        monitor-enter(this);
        FLogger r1 = FLogger.a;     // Catch: Throwable -> L25
        r1.i(TAG, "cancelRequestBiometricState, requestSource = " + r5);     // Catch: Throwable -> L25
        boolean r0 = false;
        if (this.requestStates.remove(r5) == null) goto L8;
        boolean r7 = true;
    L9:
        if (r7 == true) goto L12;
        monitor-exit(this);
        return;
    L12:
        if (r6 == true) goto L22;
        i1<Boolean> r8 = isBiometricAuthenticating();     // Catch: Throwable -> L25
        if (r8 != null) goto L16;
    L18:
        if (r0 == false) goto L22;
        r1.i(TAG, "cancelRequestBiometricState, biometric authentication is in progress, wait to adjust system setting");     // Catch: Throwable -> L25
        this.hasPendingCancelRequest = true;     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L16:
        if (((Boolean) r8.getValue()).booleanValue() != true) goto L18;
        r0 = true;
    L22:
        adjustSystemSettingState();     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L8:
        r7 = false;
    L25:
        th = move-exception;
        throw th;
    }

    public synchronized void requestBiometricState(RequestSource r5, BiometricState r6) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "requestSource");     // Catch: Throwable -> L9
        Intrinsics.checkNotNullParameter(r6, "state");     // Catch: Throwable -> L9
        FLogger.a.i(TAG, "requestBiometricState, requestSource = " + r5 + ", state = " + r6);     // Catch: Throwable -> L9
        if (this.requestStates.get(r5) == r6) goto L7;
        this.requestStates.put(r5, r6);     // Catch: Throwable -> L9
        adjustSystemSettingState();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ void access$cancelRequestBiometricState(KeyguardBiometricSettingImpl r0, RequestSource r1, boolean r2) {
        r0.cancelRequestBiometricState(r1, r2);
    }
}
