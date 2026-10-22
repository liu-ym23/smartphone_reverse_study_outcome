package com.obric.aiagent.product.platform.impl.pocketmode;

import android.app.Application;
import android.content.Intent;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.aiagent.platform.a.a;
import com.obric.aiagent.platform.a.d;
import com.obric.livecard.api.impl.IslandImpl;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/pocketmode/ObricPocketModeDetector;", "Lcom/obric/aiagent/product/platform/impl/pocketmode/CommonPocketModeDetector;", "<init>", "()V", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "showProximityNearAlert", "isPocketModeManuallyDismissed", "", "isPocketModeEnabled", "isProximityNearAlertShowing", "hideProximityNearAlert", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ObricPocketModeDetector extends CommonPocketModeDetector {
    private static final String ACTION_FORCE_ALERT_PROXIMITY_NEAR = "com.obric.systemui.FORCE_ALERT_PROXIMITY_NEAR";
    public static final Companion Companion = null;
    private static final String POCKET_MODE_ENABLE_STATE = "pocket_mode_enable";
    private static final String SYSTEMUI_PROXIMITY_HINT_STATE = "obric_proximity_hint_dismissed";
    private static final String TAG = "ObricPocketModeDetector";
    private static volatile boolean hasInit;
    private static volatile boolean isPocketModeEnabled;
    private static volatile boolean isPocketModeManuallyDismissed;
    private static final ObricPocketModeDetector$Companion$pocketModeEnableStateObserver$1 pocketModeEnableStateObserver = null;
    private static final ObricPocketModeDetector$Companion$systemUIStateObserver$1 systemUIStateObserver = null;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0002\u000e\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\u0006\u0010\u0016\u001a\u00020\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u0006\u0017"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/pocketmode/ObricPocketModeDetector$Companion;", "", "<init>", "()V", "TAG", "", "SYSTEMUI_PROXIMITY_HINT_STATE", "POCKET_MODE_ENABLE_STATE", "ACTION_FORCE_ALERT_PROXIMITY_NEAR", "isPocketModeEnabled", "", "isPocketModeManuallyDismissed", "hasInit", "systemUIStateObserver", "com/obric/aiagent/product/platform/impl/pocketmode/ObricPocketModeDetector$Companion$systemUIStateObserver$1", "Lcom/obric/aiagent/product/platform/impl/pocketmode/ObricPocketModeDetector$Companion$systemUIStateObserver$1;", "pocketModeEnableStateObserver", "com/obric/aiagent/product/platform/impl/pocketmode/ObricPocketModeDetector$Companion$pocketModeEnableStateObserver$1", "Lcom/obric/aiagent/product/platform/impl/pocketmode/ObricPocketModeDetector$Companion$pocketModeEnableStateObserver$1;", "updateSystemUIState", "", "updatePocketModeEnableState", CommonConsts.APM_INNER_EVENT_COST_INIT, "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static final /* synthetic */ void access$updatePocketModeEnableState(Companion r0) {
            r0.updatePocketModeEnableState();
        }

        public static final /* synthetic */ void access$updateSystemUIState(Companion r0) {
            r0.updateSystemUIState();
        }

        private final void updatePocketModeEnableState() {
            boolean r1 = true;
            if (Settings.System.getInt(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.f5948a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getContentResolver(), ObricPocketModeDetector.POCKET_MODE_ENABLE_STATE, 1) == 1) goto L7;
            r1 = false;
        L7:
            ObricPocketModeDetector.access$setPocketModeEnabled$cp(r1);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            d.f5954a.b(ObricPocketModeDetector.TAG, "updatePocketModeEnableState failed", th);
        }

        private final void updateSystemUIState() {
            boolean r1 = false;
            if (Settings.Global.getInt(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.f5948a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getContentResolver(), ObricPocketModeDetector.SYSTEMUI_PROXIMITY_HINT_STATE, 0) != 1) goto L6;
            r1 = true;
        L6:
            ObricPocketModeDetector.access$setPocketModeManuallyDismissed$cp(r1);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            d.f5954a.b(ObricPocketModeDetector.TAG, "updateSystemUIState failed", th);
        }

        public final synchronized void init() {
            monitor-enter(this);
        L14:
            th = move-exception;
            throw th;
        L4:
            if (ObricPocketModeDetector.access$getHasInit$cp() == false) goto L18;
            d.f5954a.b(ObricPocketModeDetector.TAG, "init() already called, skip");     // Catch: Throwable -> L14
            monitor-exit(this);
            return;
        L18:
            ZeusProviderTransform.registerContentObserver(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.f5948a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getContentResolver(), Settings.Global.getUriFor(ObricPocketModeDetector.SYSTEMUI_PROXIMITY_HINT_STATE), false, (ContentObserver) ZeusTransformUtils.preCheckCast(ObricPocketModeDetector.access$getSystemUIStateObserver$cp(), ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            ZeusProviderTransform.registerContentObserver(((Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.f5948a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin")).getContentResolver(), Settings.System.getUriFor(ObricPocketModeDetector.POCKET_MODE_ENABLE_STATE), false, (ContentObserver) ZeusTransformUtils.preCheckCast(ObricPocketModeDetector.access$getPocketModeEnableStateObserver$cp(), ContentObserver.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            updateSystemUIState();     // Catch: Throwable -> L10
            updatePocketModeEnableState();     // Catch: Throwable -> L10
            ObricPocketModeDetector.access$setHasInit$cp(true);     // Catch: Throwable -> L10
            d.f5954a.b(ObricPocketModeDetector.TAG, "init() called");     // Catch: Throwable -> L10
        L12:
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            d.f5954a.b(ObricPocketModeDetector.TAG, "init() failed", th);     // Catch: Throwable -> L14
            goto L12
        }
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [com.obric.aiagent.product.platform.impl.pocketmode.ObricPocketModeDetector$Companion$systemUIStateObserver$1] */
    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.aiagent.product.platform.impl.pocketmode.ObricPocketModeDetector$Companion$pocketModeEnableStateObserver$1] */
    static {
        Companion = new Companion(null);
        isPocketModeEnabled = true;
        final Handler r0 = com.obric.aiagent.product.a.d.f5969a.a();
        systemUIStateObserver = new ObricPocketModeDetector$Companion$systemUIStateObserver$1(r0);
        final Handler r1 = com.obric.aiagent.product.a.d.f5969a.b();
        pocketModeEnableStateObserver = new ObricPocketModeDetector$Companion$pocketModeEnableStateObserver$1(r1);
    }

    public ObricPocketModeDetector() {
    }

    public static final /* synthetic */ boolean access$getHasInit$cp() {
        return hasInit;
    }

    public static final /* synthetic */ ObricPocketModeDetector$Companion$pocketModeEnableStateObserver$1 access$getPocketModeEnableStateObserver$cp() {
        return pocketModeEnableStateObserver;
    }

    public static final /* synthetic */ ObricPocketModeDetector$Companion$systemUIStateObserver$1 access$getSystemUIStateObserver$cp() {
        return systemUIStateObserver;
    }

    public static final /* synthetic */ boolean access$isPocketModeEnabled$cp() {
        return isPocketModeEnabled;
    }

    public static final /* synthetic */ boolean access$isPocketModeManuallyDismissed$cp() {
        return isPocketModeManuallyDismissed;
    }

    public static final /* synthetic */ void access$setHasInit$cp(boolean r0) {
        hasInit = r0;
    }

    public static final /* synthetic */ void access$setPocketModeEnabled$cp(boolean r0) {
        isPocketModeEnabled = r0;
    }

    public static final /* synthetic */ void access$setPocketModeManuallyDismissed$cp(boolean r0) {
        isPocketModeManuallyDismissed = r0;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void hideProximityNearAlert() {
        d.f5954a.a(TAG, "hideProximityNearAlert() called, do nothing");
    }

    @Override // com.obric.aiagent.product.platform.impl.pocketmode.CommonPocketModeDetector, com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void init() {
        Companion.init();
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isPocketModeEnabled() {
        d.f5954a.b(TAG, "isPocketModeEnabled() return " + isPocketModeEnabled);
        return isPocketModeEnabled;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isPocketModeManuallyDismissed() {
        d.f5954a.b(TAG, "isPocketModeManuallyDismissed() return " + isPocketModeManuallyDismissed);
        return isPocketModeManuallyDismissed;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isProximityNearAlertShowing() {
        d.f5954a.b(TAG, "isProximityNearAlertShowing() return false");
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void showProximityNearAlert() {
        d.f5954a.b(TAG, "showProximityNearAlert() called");
        Application r2 = (Application) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.f5948a.a(), "com.obric.memorydata.plugin"), Application.class, "com.obric.memorydata.plugin");
        Intent r0 = new Intent(ACTION_FORCE_ALERT_PROXIMITY_NEAR);
        r0.setPackage(IslandImpl.LIVE_CARD_HOST);
        r2.sendBroadcast(r0);
    }
}
