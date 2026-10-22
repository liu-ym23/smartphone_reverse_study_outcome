package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import android.text.TextUtils;
import android.view.View;
import com.bytedance.android.live.liveinteract.chatroom.chatroom.widget.TalkRoomFeedbackView;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j0 implements View.OnClickListener {
    public final /* synthetic */ TalkRoomFeedbackDialog a;

    public j0(TalkRoomFeedbackDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r8) {
        if (TalkRoomFeedbackDialog.T90(this.a) == false) goto L32;
        boolean r9 = !TextUtils.isEmpty(((TalkRoomFeedbackView) this.a.S90(2131372320)).getSelectedTag());
        boolean r0 = !TextUtils.isEmpty(((TalkRoomFeedbackView) this.a.S90(2131372320)).getSelectedSubTag());
        TalkRoomFeedbackDialog r2 = this.a;
        r2.getClass();
        LinkedHashMap r3 = new LinkedHashMap();
        if (r2.g == false) goto L7;
        String r4 = "anchor";
    L8:
        r3.put("user_type", r4);
        TalkRoomLogUtils.I0(r3, r2.h);
        TalkRoomLogUtils.B0(r3, Integer.valueOf(r2.h), null, 4);
        if (r9 == false) goto L11;
        String r5 = "1";
    L12:
        r3.put("has_feedback", r5);
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_chat_feedback_confirm_click", r3, new Object[]{am2.x.class, IRoom.class});
        this.a.Z90();
        TalkRoomFeedbackDialog r6 = this.a;
        gd0.c r7 = r6.l;
        if (r7 == null) goto L15;
        r7.a(r6);
    L15:
        if (r9 == false) goto L21;
        TalkRoomFeedbackDialog r10 = this.a;
        if (r10.n == false) goto L19;
        if (r0 == true) goto L19;
    L20:
        TalkRoomFeedbackDialog.U90(this.a, true);
    L30:
        this.a.dismiss();     // Catch: Exception -> L25
        return;
    L25:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r11 = DialogFragmentLancet.sLastShowStack;
        if (r11 == null) goto L33;
        com.bytedance.crash.d.d(r11, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L33:
        return;
    L19:
        TalkRoomFeedbackDialog.X90(r10);
        goto L20
    L21:
        TalkRoomFeedbackDialog.U90(this.a, false);
        goto L30
    L11:
        r5 = "0";
        goto L12
    L7:
        r4 = "guest";
        goto L8
    }
}
