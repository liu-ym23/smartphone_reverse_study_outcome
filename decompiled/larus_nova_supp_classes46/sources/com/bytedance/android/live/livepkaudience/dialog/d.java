package com.bytedance.android.live.livepkaudience.dialog;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ PkAdminInviteFragment a;

    public d(PkAdminInviteFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        k0 r5 = this.a.d;
        if (r5 == null) goto L5;
        r5.dismiss();
    L5:
        PkAdminInviteFragment r6 = this.a;
        DataCenter r0 = r6.o;
        if (r0 == null) goto L8;
        r0.put("data_room_video_talk_log_over_for_over_path", "chat_close_icon");
    L8:
        int r1 = PkWithAudienceFeedbackDialog.m;
        PkWithAudienceFeedbackDialog r2 = PkWithAudienceFeedbackDialog.a.a(dl0.n.a(), r6.k, r6.q);
        FragmentActivity r7 = r6.getContext();
        if (r7 == null) goto L17;
        FragmentManager r8 = r7.getSupportFragmentManager();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "PkWithAudienceFeedbackDialog", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r8, r2, r3) == true) goto L21;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L18
    L14:
        r2.show(r8, "PkWithAudienceFeedbackDialog");
        return;
    L21:
        return;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
    }
}
