package com.obric.assistant.interaction.impl;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.common.utils.e;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.keyguard.BiometricState;
import com.obric.assistant.interaction.api.keyguard.IKeyguardBiometricSetting;
import com.obric.assistant.interaction.api.keyguard.RequestSource;
import com.obric.assistant.reporter.c;
import com.obric.assistant.spi.keyguard.IKeyguardService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;
import oga.a;
import oga.b;
import v19.q5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J:\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010 \u001a\u00020\nH\u0002J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\nH\u0003J&\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00120(H\u0002J\u0010\u0010)\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\nH\u0002J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\nH\u0002J\b\u0010+\u001a\u00020\u0012H\u0016J\n\u0010,\u001a\u0004\u0018\u00010&H\u0016J\n\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\nH\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n00H\u0016J\b\u00101\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u00063"}, d2 = {"Lcom/obric/assistant/interaction/impl/ObricKeyguardServiceImpl;", "Lcom/obric/assistant/spi/keyguard/IKeyguardService;", "<init>", "()V", "workScope", "Lkotlinx/coroutines/CoroutineScope;", "playUnlockTtsJob", "Lkotlinx/coroutines/Job;", "isDismissingKeyguard", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "keyguardManager", "Landroid/app/KeyguardManager;", "getKeyguardManager", "()Landroid/app/KeyguardManager;", "keyguardManager$delegate", "Lkotlin/Lazy;", "registerDismissKeyguardChangedListener", "", "listener", "Lcom/obric/assistant/spi/keyguard/IDismissKeyguardStatusListener;", "unregisterDismissKeyguardChangedListener", "requestDismissKeyguard", "callback", "Lcom/obric/assistant/spi/keyguard/DismissKeyguardCallback;", "fastFailWhenAppBackground", "playTts", "allowBiometricUnlock", "autoPopupWindow", "reportParams", "Landroid/os/Bundle;", "reportAuthResultIfNeeded", "isSuccess", "dismissWithTopActivity", "completeTopActivityDismiss", "terminalGate", "Lcom/obric/assistant/interaction/impl/KeyguardDismissTerminalGate;", "source", "", "onFirstTerminal", "Lkotlin/Function0;", "setKeyGuardBiometricUnlock", "dismissWithHelperActivity", "cancelDismissKeyguard", "getHelperActivityName", "getHelperActivityComponentName", "Landroid/content/ComponentName;", "isKeyguardLocked", "Lkotlinx/coroutines/flow/StateFlow;", "isRequestingDismissKeyguard", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricKeyguardServiceImpl implements IKeyguardService {
    public static final Companion Companion = null;
    public static final String TAG = "DismissKeyguardHelper";
    private static CopyOnWriteArrayList<a> dismissKeyguardCallbacks;
    private static final CopyOnWriteArrayList<b> dismissKeyguardStatusChangedCallbacks = null;
    private static WeakReference<Activity> lockedHelperActivity;
    private static boolean shouldAutoPopupWindow;
    private final z0<Boolean> isDismissingKeyguard;
    private final Lazy keyguardManager$delegate;
    private volatile Job playUnlockTtsJob;
    private final CoroutineScope workScope;

    public static /* synthetic */ Unit a(ObricKeyguardServiceImpl r0, Throwable r1) {
        return requestDismissKeyguard$lambda$2$lambda$1(r0, r1);
    }

    public static /* synthetic */ KeyguardManager b() {
        return keyguardManager_delegate$lambda$0();
    }

    public static /* synthetic */ Unit c() {
        return dismissWithTopActivity$lambda$5$lambda$4();
    }

    static {
        Companion = new Companion(null);
        dismissKeyguardCallbacks = new CopyOnWriteArrayList();
        dismissKeyguardStatusChangedCallbacks = new CopyOnWriteArrayList();
    }

    private static final Unit dismissWithTopActivity$lambda$5$lambda$4() {
        Companion.onKeyguardDismissSucceeded$impl_mainlandRelease();
        return Unit.INSTANCE;
    }

    private final KeyguardManager getKeyguardManager() {
        return (KeyguardManager) this.keyguardManager$delegate.getValue();
    }

    private static final KeyguardManager keyguardManager_delegate$lambda$0() {
        Object r0 = AppHost.a.getApplication().getSystemService("keyguard");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.KeyguardManager");
        return (KeyguardManager) r0;
    }

    public void cancelDismissKeyguard() {
        FLogger.a.e(TAG, "cancelDismissKeyguard");
        this.isDismissingKeyguard.setValue(Boolean.FALSE);
        Companion.onKeyguardDismissCancelled$impl_mainlandRelease();
        WeakReference<Activity> r0 = lockedHelperActivity;
        if (r0 == null) goto L10;
        Activity r1 = r0.get();
        if (r1 != null) goto L7;
        return;
    L7:
        if (r1.isDestroyed() == true) goto L12;
        r1.finishAndRemoveTask();
        return;
    L12:
        return;
    }

    public ComponentName getHelperActivityComponentName() {
        if (ObricFeatureServiceDelegate.b.c() == true) goto L7;
        return null;
    L7:
        return new ComponentName(AppHost.a.getApplication(), LockedHelperActivity.class);
    }

    public boolean isRequestingDismissKeyguard() {
        WeakReference<Activity> r0 = lockedHelperActivity;
        if (r0 == null) goto L10;
        Activity r1 = r0.get();
        if (r1 != null) goto L7;
        return false;
    L7:
        if (r1.isDestroyed() == true) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public ObricKeyguardServiceImpl() {
        this.workScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.isDismissingKeyguard = j1.a(Boolean.FALSE);
        this.keyguardManager$delegate = LazyKt.lazy(new t());
    }

    public String getHelperActivityName() {
        ComponentName r0 = getHelperActivityComponentName();
        if (r0 == null) goto L8;
        String r1 = r0.getClassName();
        if (r1 != null) goto L7;
        return null;
    L7:
        return StringsKt.substringAfterLast$default(r1, '.', null, 2, null);
    L8:
        return null;
    }

    public boolean isKeyguardLocked() {
        return IKeyguardStateKt.getKeyguardState().isKeyguardLocked();
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getDismissKeyguardCallbacks$cp() {
        return dismissKeyguardCallbacks;
    }

    public static final /* synthetic */ CopyOnWriteArrayList access$getDismissKeyguardStatusChangedCallbacks$cp() {
        return dismissKeyguardStatusChangedCallbacks;
    }

    public static final /* synthetic */ boolean access$getShouldAutoPopupWindow$cp() {
        return shouldAutoPopupWindow;
    }

    public i1<Boolean> isDismissingKeyguard() {
        return this.isDismissingKeyguard;
    }

    public static final /* synthetic */ KeyguardManager access$getKeyguardManager(ObricKeyguardServiceImpl r0) {
        return r0.getKeyguardManager();
    }

    public static final /* synthetic */ Job access$getPlayUnlockTtsJob$p(ObricKeyguardServiceImpl r0) {
        return r0.playUnlockTtsJob;
    }

    public static final /* synthetic */ z0 access$isDismissingKeyguard$p(ObricKeyguardServiceImpl r0) {
        return r0.isDismissingKeyguard;
    }

    public static final /* synthetic */ void access$setLockedHelperActivity$cp(WeakReference r0) {
        lockedHelperActivity = r0;
    }

    private final void dismissWithHelperActivity(boolean r4) {
        FLogger.a.i(TAG, "dismiss with helper activity");
        setKeyGuardBiometricUnlock(r4);
        AppHost.Companion r5 = AppHost.a;
        Application r0 = r5.getApplication();
        Intent r1 = new Intent(r5.getApplication(), LockedHelperActivity.class);
        r1.addFlags(402653184);
        r1.putExtra("obric_allow_show_when_locked", true);
        r0.startActivity(r1);
        Iterator r6 = ((ArrayList) v19.a.a).iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        ((q5) r6.next()).gotoToSystemPage();
        goto L4
    }

    private final void dismissWithTopActivity(boolean r12) {
        FLogger r0 = FLogger.a;
        r0.i(TAG, "device is unlocked, dismiss with top activity quietly");
        KeyguardDismissTerminalGate r1 = new KeyguardDismissTerminalGate();
        dismissWithTopActivity.dismissCallback.1 r3 = new dismissWithTopActivity.dismissCallback.1(this, r1);
        Activity r4 = AppHost.a.a().getCurrentActivity();
        if (r4 == null) goto L8;
        setKeyGuardBiometricUnlock(r12);
        if (getKeyguardManager().isKeyguardLocked() == true) goto L7;
        completeTopActivityDismiss(r1, "pre_request_unlocked", new s());
        return;
    L7:
        getKeyguardManager().requestDismissKeyguard(r4, r3);
        BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new dismissWithTopActivity.1.2(this, r1, null), 3, null);
        return;
    L8:
        r0.e(TAG, "current activity is null!");
    }

    private final void setKeyGuardBiometricUnlock(boolean r3) {
        IKeyguardBiometricSetting r0 = (IKeyguardBiometricSetting) ServiceManager.get().getService(IKeyguardBiometricSetting.class);
        if (r0 == null) goto L10;
        RequestSource r1 = RequestSource.DISMISS_KEYGUARD;
        if (r3 == false) goto L7;
        BiometricState r4 = BiometricState.DEFAULT;
    L8:
        r0.requestBiometricState(r1, r4);
        return;
    L7:
        r4 = BiometricState.DISABLED;
        goto L8
    }

    public void registerDismissKeyguardChangedListener(b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        CopyOnWriteArrayList<b> r0 = dismissKeyguardStatusChangedCallbacks;
        if (r0.contains(r3) == true) goto L6;
        r0.add(r3);
        return;
    }

    public void unregisterDismissKeyguardChangedListener(b r3) {
        Intrinsics.checkNotNullParameter(r3, "listener");
        CopyOnWriteArrayList<b> r0 = dismissKeyguardStatusChangedCallbacks;
        if (r0.contains(r3) == false) goto L6;
        r0.remove(r3);
        return;
    }

    private final void reportAuthResultIfNeeded(Bundle r2, boolean r3) {
        if (IKeyguardStateKt.getKeyguardState().isDeviceSecure() == true) goto L6;
        FLogger.a.i(TAG, "skip reportAuthResult because device is not secure");
        return;
    L6:
        c.a(r2, r3);
    }

    private static final Unit requestDismissKeyguard$lambda$2$lambda$1(ObricKeyguardServiceImpl r0, Throwable r1) {
        r0.playUnlockTtsJob = null;
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ void access$reportAuthResultIfNeeded(ObricKeyguardServiceImpl r0, Bundle r1, boolean r2) {
        r0.reportAuthResultIfNeeded(r1, r2);
    }

    private final void completeTopActivityDismiss(KeyguardDismissTerminalGate r4, String r5, Function0<Unit> r6) {
        if (r4.tryComplete() == true) goto L6;
        FLogger.a.i(TAG, "ignore duplicated top activity dismiss result, source = " + r5);
        return;
    L6:
        FLogger.a.i(TAG, "complete top activity dismiss, source = " + r5);
        r6.invoke();
    }

    public static final /* synthetic */ void access$completeTopActivityDismiss(ObricKeyguardServiceImpl r0, KeyguardDismissTerminalGate r1, String r2, Function0 r3) {
        r0.completeTopActivityDismiss(r1, r2, r3);
    }

    public void requestDismissKeyguard(a r15, boolean r16, boolean r17, boolean r18, boolean r19, Bundle r20) {
        Intrinsics.checkNotNullParameter(r15, "callback");
        if (Build.VERSION.SDK_INT >= 26) goto L6;
        FLogger.a.e(TAG, "requestDismissKeyguard not support");
        r15.onDismissSucceeded();
        return;
    L6:
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("requestDismissKeyguard fastFail = ");
        r5.append(r16);
        r5.append(", allowBiometricUnlock = ");
        r5.append(r18);
        r5.append(", reportParams = ");
        r5.append(e.b(r20));
        r5.append(", isAppBackground = ");
        AppHost.Companion r7 = AppHost.a;
        r5.append(r7.a().isAppBackground());
        r5.append(", callback = ");
        r5.append(r15);
        r5.append(", dismissKeyguardCallback = ");
        r5.append(dismissKeyguardCallbacks);
        r4.e(TAG, r5.toString());
        if (getKeyguardManager().isKeyguardLocked() == true) goto L10;
        r15.onDismissSucceeded();
        return;
    L10:
        if (r16 == true) goto L12;
    L15:
        this.isDismissingKeyguard.setValue(Boolean.TRUE);
        shouldAutoPopupWindow = r19;
        Job r2 = this.playUnlockTtsJob;
        boolean r6 = true;
        if (r2 == null) goto L18;
        Job.DefaultImpls.cancel$default(r2, null, 1, null);
    L18:
        this.playUnlockTtsJob = null;
        if (r17 == true) goto L21;
    L23:
        WeakReference<Activity> r3 = lockedHelperActivity;
        if (r3 == null) goto L30;
        Activity r8 = r3.get();
        if (r8 == null) goto L30;
        if (r8.isDestroyed() == true) goto L30;
        r8.finishAndRemoveTask();
    L30:
        dismissKeyguardCallbacks.add(new requestDismissKeyguard.4(this, r20, r15));
        if (r7.a().isAppBackground() == true) goto L42;
        IAssistantChatWindow r1 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r1 != null) goto L35;
    L37:
        r6 = false;
    L38:
        if (r6 == false) goto L42;
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == true) goto L42;
        dismissWithTopActivity(r18);
        return;
    L35:
        if (r1.isShowing() == true) goto L37;
    L42:
        dismissWithHelperActivity(r18);
        return;
    L21:
        if (IKeyguardStateKt.getKeyguardState().isDeviceLocked() == false) goto L23;
        Job r9 = BuildersKt.launch$default(this.workScope, null, null, new requestDismissKeyguard.1(null), 3, null);
        r9.invokeOnCompletion(new u(this));
        this.playUnlockTtsJob = r9;
        goto L23
    L12:
        if (r7.a().isAppBackground() == false) goto L15;
        r4.e(TAG, "fast failed!");
        r15.onDismissFailed();
    }
}
