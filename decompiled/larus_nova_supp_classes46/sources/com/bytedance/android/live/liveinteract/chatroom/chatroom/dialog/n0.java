package com.bytedance.android.live.liveinteract.chatroom.chatroom.dialog;

import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n0<T> implements Consumer {
    public final /* synthetic */ TalkRoomFeedbackDialog a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public n0(TalkRoomFeedbackDialog r1, String r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r7) {
        com.bytedance.android.live.network.response.a r8 = (com.bytedance.android.live.network.response.a) r7;
        TalkRoomFeedbackDialog r9 = this.a;
        String r0 = this.b;
        String r1 = this.c;
        int r2 = TalkRoomFeedbackDialog.r;
        r9.getClass();
        LinkedHashMap r3 = new LinkedHashMap();
        if (r9.g == false) goto L5;
        String r4 = "anchor";
    L6:
        r3.put("user_type", r4);
        int r5 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        TalkRoomLogUtils.I0(r3, r5);
        TalkRoomLogUtils.B0(r3, Integer.valueOf(r5), null, 4);
        TalkRoomLogUtils.Q0(r3);
        r3.put("is_ksong", "0");
        if (r0 != null) goto L9;
        r0 = "";
    L9:
        r3.put("first_feedback", r0);
        r3.put("second_feedback", r1);
        if (r9.g == false) goto L17;
        if (r9.Y90() <= 0) goto L14;
        String r6 = "end_ahead";
    L15:
        r3.put("request_page", r6);
        goto L17
    L14:
        r6 = "normal";
    L17:
        if (r9.h == 5) goto L19;
    L21:
        boolean r10 = false;
    L22:
        if (r10 == false) goto L24;
        r3.put("function_type", "party");
    L24:
        com.bytedance.android.livesdk.log.j0.l().sendLog("livesdk_live_chat_feedback_success", r3, new Object[]{am2.x.class, IRoom.class});
        TalkRoomFeedbackDialog.W90(this.a, "finish");
        TalkRoomFeedbackDialog r11 = this.a;
        int r12 = 2131922743;
        if (r11.m == false) goto L28;
        f2.b(2131922743, 0);
        return;
    L28:
        if (r11.g == true) goto L31;
        r12 = 2131922742;
    L31:
        f2.b(r12, 0);
        return;
    L19:
        if (com.bytedance.android.livesdk.chatroom.interact.model.d0.h(r9.f) == false) goto L21;
        r10 = true;
        goto L22
    L5:
        r4 = "guest";
        goto L6
    }
}
