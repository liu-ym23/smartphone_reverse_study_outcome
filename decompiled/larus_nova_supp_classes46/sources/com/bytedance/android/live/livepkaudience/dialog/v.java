package com.bytedance.android.live.livepkaudience.dialog;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.livepkaudience.view.PkWithAudienceFeedbackView;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class v implements View.OnClickListener {
    public final /* synthetic */ PkWithAudienceFeedbackDialog a;

    public v(PkWithAudienceFeedbackDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        if (PkWithAudienceFeedbackDialog.T90(this.a) == false) goto L28;
        boolean r8 = !TextUtils.isEmpty(((PkWithAudienceFeedbackView) this.a.S90(2131372320)).getSelectedTag());
        PkWithAudienceFeedbackDialog r1 = this.a;
        r1.getClass();
        LinkedHashMap r2 = new LinkedHashMap();
        if (r1.g == false) goto L7;
        String r3 = "anchor";
    L8:
        r2.put("user_type", r3);
        el0.j.l(r2, r1.h);
        el0.j.j(r2, Integer.valueOf(r1.h));
        el0.j.n(r2, Integer.valueOf(r1.h));
        if (r8 == false) goto L11;
        String r4 = "1";
    L12:
        r2.put("has_feedback", r4);
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_live_chat_feedback_confirm_click", r2, new Object[]{am2.x.class, Room.class});
        this.a.W90();
        PkWithAudienceFeedbackDialog r0 = this.a;
        gd0.c r5 = r0.k;
        if (r5 == null) goto L15;
        r5.a(r0);
    L15:
        if (r8 == false) goto L17;
        PkWithAudienceFeedbackDialog.V90(this.a);
        PkWithAudienceFeedbackDialog.U90(this.a);
    L26:
        this.a.dismiss();     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r9 = DialogFragmentLancet.sLastShowStack;
        if (r9 == null) goto L29;
        com.bytedance.crash.d.d(r9, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L29:
        return;
    L17:
        PkWithAudienceFeedbackDialog.U90(this.a);
        goto L26
    L11:
        r4 = "0";
        goto L12
    L7:
        r3 = "guest";
        goto L8
    }
}
