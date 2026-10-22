package com.obric.assistant.interaction.impl.window.behaviors;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.keyguard.BiometricState;
import com.obric.assistant.interaction.api.keyguard.IKeyguardBiometricSetting;
import com.obric.assistant.interaction.api.keyguard.RequestSource;
import com.obric.assistant.interaction.api.window.IBehavior;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/behaviors/WindowKeyguardBiometricSettingBehavior;", "Lcom/obric/assistant/interaction/api/window/IBehavior;", "<init>", "()V", "keyguardBiometricSetting", "Lcom/obric/assistant/interaction/api/keyguard/IKeyguardBiometricSetting;", "getKeyguardBiometricSetting", "()Lcom/obric/assistant/interaction/api/keyguard/IKeyguardBiometricSetting;", "keyguardBiometricSetting$delegate", "Lkotlin/Lazy;", "init", "", "onWindowShow", "onWindowHide", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowKeyguardBiometricSettingBehavior implements IBehavior {
    public static final Companion Companion = null;
    private static final String TAG = "WindowKeyguardBiometricSettingBehavior";
    private final Lazy keyguardBiometricSetting$delegate;

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ IKeyguardBiometricSetting a() {
        return keyguardBiometricSetting_delegate$lambda$0();
    }

    private final IKeyguardBiometricSetting getKeyguardBiometricSetting() {
        return (IKeyguardBiometricSetting) this.keyguardBiometricSetting$delegate.getValue();
    }

    private static final IKeyguardBiometricSetting keyguardBiometricSetting_delegate$lambda$0() {
        return (IKeyguardBiometricSetting) ServiceManager.get().getService(IKeyguardBiometricSetting.class);
    }

    public void init() {
        FLogger.a.i(TAG, "init");
    }

    public WindowKeyguardBiometricSettingBehavior() {
        this.keyguardBiometricSetting$delegate = LazyKt.lazy(new b0());
    }

    public void onWindowHide() {
        IBehavior.DefaultImpls.onWindowHide(this);
        FLogger.a.i(TAG, "onWindowHide");
        IKeyguardBiometricSetting r0 = getKeyguardBiometricSetting();
        if (r0 == null) goto L6;
        r0.cancelRequestBiometricState(RequestSource.WINDOW);
        return;
    }

    public void onWindowShow() {
        IBehavior.DefaultImpls.onWindowShow(this);
        FLogger.a.i(TAG, "onWindowShow");
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L8;
        IKeyguardBiometricSetting r0 = getKeyguardBiometricSetting();
        if (r0 == null) goto L9;
        r0.requestBiometricState(RequestSource.WINDOW, BiometricState.DISABLED);
        return;
    L9:
        return;
    }

    public void onAppBackground() {
        IBehavior.DefaultImpls.onAppBackground(this);
    }

    public void onAppForeground() {
        IBehavior.DefaultImpls.onAppForeground(this);
    }

    public void onWindowDismiss() {
        IBehavior.DefaultImpls.onWindowDismiss(this);
    }

    public void onWindowPreDismiss() {
        IBehavior.DefaultImpls.onWindowPreDismiss(this);
    }

    public void onWindowPreHide() {
        IBehavior.DefaultImpls.onWindowPreHide(this);
    }

    public void onWindowPreOpenClear() {
        IBehavior.DefaultImpls.onWindowPreOpenClear(this);
    }

    public void onWindowPreShow() {
        IBehavior.DefaultImpls.onWindowPreShow(this);
    }

    public void onWindowPreloaded() {
        IBehavior.DefaultImpls.onWindowPreloaded(this);
    }

    public void onScreenRotationChanged(int r1, int r2) {
        IBehavior.DefaultImpls.onScreenRotationChanged(this, r1, r2);
    }
}
