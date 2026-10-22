package com.obric.aiagent.product.platform.impl.pocketmode;

import com.obric.aiagent.platform.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/pocketmode/GRPocketModeDetector;", "Lcom/obric/aiagent/product/platform/impl/pocketmode/CommonPocketModeDetector;", "<init>", "()V", "showProximityNearAlert", "", "isPocketModeEnabled", "", "isPocketModeManuallyDismissed", "isProximityNearAlertShowing", "hideProximityNearAlert", "Companion", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GRPocketModeDetector extends CommonPocketModeDetector {
    public static final Companion Companion = null;
    private static final String TAG = "GRPocketModeDetector";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/aiagent/product/platform/impl/pocketmode/GRPocketModeDetector$Companion;", "", "<init>", "()V", "TAG", "", "product-platform_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public GRPocketModeDetector() {
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void hideProximityNearAlert() {
        d.f5954a.a(TAG, "hideProximityNearAlert() called, do nothing");
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isPocketModeEnabled() {
        d.f5954a.a(TAG, "isPocketModeEnabled() return false");
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isPocketModeManuallyDismissed() {
        d.f5954a.a(TAG, "isPocketModeManuallyDismissed() return false");
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public boolean isProximityNearAlertShowing() {
        d.f5954a.a(TAG, "isProximityNearAlertShowing() return false");
        return false;
    }

    @Override // com.obric.aiagent.product.platform.api.pocketmode.IPocketModeDetector
    public void showProximityNearAlert() {
        d.f5954a.a(TAG, "showProximityNearAlert() called, do nothing");
    }
}
