package com.bytedance.android.live.revlink.impl.pk.vote;

import android.view.View;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ InteractVoteStartDialog a;

    public d(InteractVoteStartDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        this.a.dismiss();     // Catch: Exception -> L5
    L9:
        com.bytedance.android.live.revlink.impl.multianchor.service.c r5 = com.bytedance.android.live.revlink.impl.global.b.y();
        if (r5 == null) goto L15;
        com.bytedance.android.live.revlink.impl.multianchor.service.c.a.a(r5, 0, 0, null, 7);
        return;
    L15:
        return;
    L5:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r6 = DialogFragmentLancet.sLastShowStack;
        if (r6 == null) goto L9;
        com.bytedance.crash.d.d(r6, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L9
    }
}
