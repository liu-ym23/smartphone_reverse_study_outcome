package vw0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static final void a(d r1, d r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$assign");
        Intrinsics.checkNotNullParameter(r2, "source");
        r1.setRechargeAgreementAccepted(r2.isRechargeAgreementAccepted());
        r1.setCombinedPaySelected(r2.isCombinedPaySelected());
        r1.setCustomPrice(r2.getCustomPrice());
        r1.setHidePanel(r2.isHidePanel());
        r1.setShowCenterLoading(r2.isShowCenterLoading());
        r1.setPanelMode(r2.getPanelMode());
    }
}
