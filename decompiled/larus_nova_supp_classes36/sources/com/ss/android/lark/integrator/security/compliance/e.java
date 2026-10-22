package com.ss.android.lark.integrator.security.compliance;

import android.content.Context;
import android.content.Intent;
import com.larksuite.component.openplatform.plugins.config.LKPluginConfig;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.security.compliance.api.DefaultSecurityComplianceApiMock;
import com.ss.android.lark.security.compliance.api.ISecurityComplianceApi;
import com.ss.android.lark.security.compliance.api.params.ScreenshotProtectionUser;
import io.reactivex.Single;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Singleton
public final class e implements ISecurityComplianceApi {
    public final /* synthetic */ DefaultSecurityComplianceApiMock a;
    public final com.ss.android.lark.screenprotect.userscope.b b;

    public final boolean enableUrlSlashOpt() {
        return this.a.enableUrlSlashOpt();
    }

    public final List<LKPluginConfig> getAllPluginConfigs() {
        return this.a.getAllPluginConfigs();
    }

    public final p4c.a getAppLockApi() {
        return this.a.getAppLockApi();
    }

    public final p4c.b getConditionalAccessModuleApi() {
        return this.a.getConditionalAccessModuleApi();
    }

    public final p4c.c getDeviceSecurityDetectionApi() {
        return this.a.getDeviceSecurityDetectionApi();
    }

    public final Single<String> getMdmDeviceAuthToken(Context r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.a.getMdmDeviceAuthToken(r2, r3);
    }

    public final void gotoEncryptionUpgrade(Context r2, Intent r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a.gotoEncryptionUpgrade(r2, r3);
    }

    public final void gotoProxySettingPage(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a.gotoProxySettingPage(r2);
    }

    public final void handleRemoteEraseBySessionInvalid(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "remoteEraseSidList");
        this.a.handleRemoteEraseBySessionInvalid(r2);
    }

    public final boolean isGpsSupported(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.a.isGpsSupported(r2);
    }

    public final boolean isLocating(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return this.a.isLocating(r2);
    }

    public final boolean isPSDATokenDisable() {
        return this.a.isPSDATokenDisable();
    }

    public final boolean isProxyOpen() {
        return this.a.isProxyOpen();
    }

    public final boolean needEncryptionUpgrade() {
        return this.a.needEncryptionUpgrade();
    }

    public final boolean needEncryptionUpgradeColdBoot() {
        return this.a.needEncryptionUpgradeColdBoot();
    }

    public final void openFileSecurityCheckPage(Context r9, String r10, long r11, int r13, String r14) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "objToken");
        Intrinsics.checkNotNullParameter(r14, "locale");
        this.a.openFileSecurityCheckPage(r9, r10, r11, r13, r14);
    }

    public final void setPSDATokenDisable(boolean r2) {
        this.a.setPSDATokenDisable(r2);
    }

    public final void setSwitchToGlobal(ScreenshotProtectionUser r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "user");
        this.a.setSwitchToGlobal(r2, r3);
    }

    public final boolean shouldUseMdmDeviceAuth() {
        return this.a.shouldUseMdmDeviceAuth();
    }

    public final Object startLocationDetection(Context r2, int r3, Continuation<? super Boolean> r4) {
        return this.a.startLocationDetection(r2, r3, r4);
    }

    public final void stopLocationDetection(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a.stopLocationDetection(r2);
    }

    public final void verifySecureURL(String r2, Map<String, ? extends Object> r3, IGetDataCallback<o4c.c> r4) {
        Intrinsics.checkNotNullParameter(r2, "url");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r4, "callback");
        this.a.verifySecureURL(r2, r3, r4);
    }

    public final boolean getSwitchStatusFromAdmin() {
        return this.b.getSwitchStatusFromAdmin();
    }

    public final boolean getSwitchStatusFromCurrentApp() {
        return this.b.getSwitchStatusFromCurrentApp();
    }

    @Inject
    public e(com.ss.android.lark.screenprotect.userscope.b r2) {
        Intrinsics.checkNotNullParameter(r2, "screenProtectService");
        this.a = new DefaultSecurityComplianceApiMock();
        this.b = r2;
    }
}
