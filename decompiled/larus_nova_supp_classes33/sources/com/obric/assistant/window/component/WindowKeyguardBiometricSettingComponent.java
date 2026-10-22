package com.obric.assistant.window.component;

import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IKeyguardStateKt;
import com.obric.assistant.interaction.api.keyguard.BiometricState;
import com.obric.assistant.interaction.api.keyguard.IKeyguardBiometricSetting;
import com.obric.assistant.interaction.api.keyguard.RequestSource;
import com.obric.assistant.spi.window.WindowOpenSource;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0001\u0012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/obric/assistant/window/component/WindowKeyguardBiometricSettingComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/obric/assistant/spi/window/WindowLifecycleListener;", "<init>", "()V", "keyguardBiometricSetting", "Lcom/obric/assistant/interaction/api/keyguard/IKeyguardBiometricSetting;", "getKeyguardBiometricSetting", "()Lcom/obric/assistant/interaction/api/keyguard/IKeyguardBiometricSetting;", "keyguardBiometricSetting$delegate", "Lkotlin/Lazy;", "onCreate", "", "onDestroy", "onWindowOpened", "source", "Lcom/obric/assistant/spi/window/WindowOpenSource;", "onWindowStashed", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowKeyguardBiometricSettingComponent extends ComponentFeature implements wga.b {
    public static final /* synthetic */ int i = 0;
    public final Lazy h;

    public static final class a {
    }

    static {
    }

    public final void onScreenRotationChanged(int r1, int r2) {
    }

    public final void onWindowDismissed() {
    }

    public final void onWindowPreDismissed() {
    }

    public final void onWindowPreOpenClear() {
    }

    public final void onWindowPreStashed() {
    }

    public final void onCreate() {
        FLogger.a.i("WindowKeyguardBiometricSettingComponent", "onCreate");
        IAssistantChatWindow r0 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r0 == null) goto L6;
        r0.addWindowLifecycleListener(this);
        return;
    }

    public final void onDestroy() {
        FLogger.a.i("WindowKeyguardBiometricSettingComponent", "onDestroy");
        IAssistantChatWindow r0 = (IAssistantChatWindow) ServiceManager.get().getService(IAssistantChatWindow.class);
        if (r0 == null) goto L6;
        r0.removeWindowLifecycleListener(this);
        return;
    }

    public final void onWindowStashed() {
        FLogger.a.i("WindowKeyguardBiometricSettingComponent", "onWindowStashed");
        IKeyguardBiometricSetting r0 = (IKeyguardBiometricSetting) this.h.getValue();
        if (r0 == null) goto L6;
        r0.cancelRequestBiometricState(RequestSource.WINDOW);
        return;
    }

    public WindowKeyguardBiometricSettingComponent() {
        this.h = LazyKt.lazy(new m0());
    }

    public final void onWindowOpened(WindowOpenSource r4) {
        Intrinsics.checkNotNullParameter(r4, "source");
        FLogger.a.i("WindowKeyguardBiometricSettingComponent", "onWindowOpened, source = " + r4);
        if (IKeyguardStateKt.getKeyguardState().isKeyguardLocked() == false) goto L8;
        IKeyguardBiometricSetting r5 = (IKeyguardBiometricSetting) this.h.getValue();
        if (r5 == null) goto L9;
        r5.requestBiometricState(RequestSource.WINDOW, BiometricState.DISABLED);
        return;
    L9:
        return;
    }

    public final void onWindowPreOpened(WindowOpenSource r2) {
        Intrinsics.checkNotNullParameter(r2, "source");
    }
}
