package com.obric.assistant.tipoff;

import com.larus.common_ui.dialog.u;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class p implements u {
    public final /* synthetic */ ObricTipOffDialogFragment a;

    public final void cancel() {
        FLogger.a.i("ObricTipOffDialogFragment", "checkSearchFeedbackSubmit: user canceled");
        ObricTipOffDialogFragment r0 = this.a;
        int r1 = ObricTipOffDialogFragment.Q;
        r0.ja0(WindowEvent.WindowOpenPerfResult.CANCEL, false);
    }

    public p(ObricTipOffDialogFragment r1) {
        this.a = r1;
    }
}
