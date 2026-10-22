package com.obric.assistant.interaction.impl;

import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.keyguard.IKeyguardBiometricSetting;
import com.obric.assistant.interaction.api.keyguard.RequestSource;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/obric/assistant/interaction/impl/ObricKeyguardServiceImpl$requestDismissKeyguard$4", "Lcom/obric/assistant/spi/keyguard/DismissKeyguardCallback;", "onDismissSucceeded", "", "onDismissFailed", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricKeyguardServiceImpl$requestDismissKeyguard$4 implements oga.a {
    final /* synthetic */ oga.a $callback;
    final /* synthetic */ Bundle $reportParams;
    final /* synthetic */ ObricKeyguardServiceImpl this$0;

    @Override // oga.a
    public void onDismissFailed() {
        Job r0 = ObricKeyguardServiceImpl.access$getPlayUnlockTtsJob$p(this.this$0);
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        ObricKeyguardServiceImpl.access$isDismissingKeyguard$p(this.this$0).setValue(Boolean.FALSE);
        FLogger.a.i("DismissKeyguardHelper", "onDismissFailed");
        ObricKeyguardServiceImpl.access$reportAuthResultIfNeeded(this.this$0, this.$reportParams, false);
        this.$callback.onDismissFailed();
        IKeyguardBiometricSetting r1 = (IKeyguardBiometricSetting) ServiceManager.get().getService(IKeyguardBiometricSetting.class);
        if (r1 == null) goto L9;
        r1.cancelRequestBiometricState(RequestSource.DISMISS_KEYGUARD);
        return;
    }

    @Override // oga.a
    public void onDismissSucceeded() {
        FLogger.a.i("DismissKeyguardHelper", "onDismissSucceeded");
        ObricKeyguardServiceImpl.access$isDismissingKeyguard$p(this.this$0).setValue(Boolean.FALSE);
        Job r0 = ObricKeyguardServiceImpl.access$getPlayUnlockTtsJob$p(this.this$0);
        if (r0 == null) goto L5;
        Job.DefaultImpls.cancel$default(r0, null, 1, null);
    L5:
        ObricKeyguardServiceImpl.access$reportAuthResultIfNeeded(this.this$0, this.$reportParams, true);
        this.$callback.onDismissSucceeded();
        IKeyguardBiometricSetting r1 = (IKeyguardBiometricSetting) ServiceManager.get().getService(IKeyguardBiometricSetting.class);
        if (r1 == null) goto L9;
        r1.cancelRequestBiometricState(RequestSource.DISMISS_KEYGUARD);
        return;
    }

    public ObricKeyguardServiceImpl$requestDismissKeyguard$4(ObricKeyguardServiceImpl r1, Bundle r2, oga.a r3) {
        this.this$0 = r1;
        this.$reportParams = r2;
        this.$callback = r3;
    }
}
