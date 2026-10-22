package com.obric.assistant.tipoff;

import com.larus.common_ui.dialog.u;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class r implements u {
    public final /* synthetic */ ObricTipOffDialogFragment a;

    public final void cancel() {
        FLogger.a.i("ObricTipOffDialogFragment", "checkSubmit: user declined image upload in UI, final upload may still contain images when autoDrainInternalEnabled or app debug is on");
        ObricTipOffDialogFragment r0 = this.a;
        int r1 = ObricTipOffDialogFragment.Q;
        r0.ja0("submit", false);
        this.a.ba0(false, false);
    }

    public r(ObricTipOffDialogFragment r1) {
        this.a = r1;
    }
}
