package com.obric.assistant.tipoff;

import com.larus.common_ui.dialog.p0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.impl.databinding.ObricDialogfragTipOffBinding;
import com.obric.oui.checkbox.OCheckBoxLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class q implements p0 {
    public final /* synthetic */ ObricTipOffDialogFragment a;

    public final void confirm() {
        FLogger.a.i("ObricTipOffDialogFragment", "checkSearchFeedbackSubmit: user accepted log upload");
        ObricDialogfragTipOffBinding r0 = this.a.f;
        if (r0 == null) goto L7;
        OCheckBoxLayout r1 = r0.p;
        if (r1 == null) goto L7;
        r1.setChecked(true);
    L7:
        this.a.ja0("agree_submit", true);
        this.a.ba0(false, false);
    }

    public q(ObricTipOffDialogFragment r1) {
        this.a = r1;
    }
}
