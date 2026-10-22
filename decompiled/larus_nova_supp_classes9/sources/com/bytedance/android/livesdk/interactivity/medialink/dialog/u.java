package com.bytedance.android.livesdk.interactivity.medialink.dialog;

import android.view.View;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdk.interactivity.medialink.dialog.vm.MediaMultiAnchorStartViewModel;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u implements View.OnClickListener {
    public final /* synthetic */ MediaMultiAnchorStartDialog a;

    public u(MediaMultiAnchorStartDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        MediaMultiAnchorStartDialog r4 = this.a;
        int r0 = MediaMultiAnchorStartDialog.h;
        if (MediaMultiAnchorStartViewModel.isOrganizer$default(r4.T90(), null, 1, null) == true) goto L7;
        f2.b(2131920312, 0);
        return;
    L7:
        if (this.a.T90().isOverLimit() == false) goto L10;
        f2.b(2131920261, 0);
        return;
    L10:
        com.bytedance.android.livesdk.interactivity.medialink.contract.a.Q0.getClass();
        com.bytedance.android.livesdk.interactivity.medialink.contract.a r5 = com.bytedance.android.livesdk.interactivity.medialink.contract.a.C0183a.a();
        if (r5 == null) goto L21;
        r5.Zh();
    L21:
        this.a.dismiss();     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L23;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }
}
