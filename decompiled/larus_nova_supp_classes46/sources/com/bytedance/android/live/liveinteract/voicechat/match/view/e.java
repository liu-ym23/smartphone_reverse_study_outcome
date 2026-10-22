package com.bytedance.android.live.liveinteract.voicechat.match.view;

import android.view.View;
import com.bytedance.android.live.liveinteract.api.chatroom.model.LinkApplyType;
import com.bytedance.android.live.liveinteract.voicechat.IVoiceChatGuestService;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ ChatMatchDialog a;

    public e(ChatMatchDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        ChatMatchDialog r6 = this.a;
        Boolean r1 = null;
        if (r6.l == false) goto L19;
        int r0 = us1.g.a;
        DataCenter r7 = r6.i;
        if (r7 == null) goto L8;
        r1 = (Boolean) r7.get("data_room_video_talk_integration_audience_has_send_prepare_apply_flag", Boolean.FALSE);
    L8:
        if (Intrinsics.areEqual(r1, Boolean.TRUE) == false) goto L14;
        ChatMatchDialog r8 = this.a;
        IRoom r2 = r8.g;
        if (r2 == null) goto L40;
        ChatMatchViewModel r9 = r8.h;
        if (r9 == null) goto L40;
        r9.prepareApplyCancel(r2);
    L40:
        ChatMatchViewModel r10 = this.a.h;
        if (r10 == null) goto L44;
        r10.stopAutoDismissCount();
        return;
    L44:
        return;
    L14:
        ChatMatchDialog r11 = this.a;
        IRoom r3 = r11.g;
        if (r3 == null) goto L40;
        ChatMatchViewModel r12 = r11.h;
        if (r12 == null) goto L40;
        r12.prepareApply(r3);
        goto L40
    L19:
        Integer r13 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r13 == null) goto L33;
        if (r13.intValue() != 0) goto L33;
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a().k0(32) == false) goto L29;
        rj0.l.n2.getClass();
        rj0.l r14 = rj0.l.a.a();
        if (r14 == null) goto L40;
        int r4 = bh0.a.a;
        rj0.l.b.a(r14, -1, 106, "chat_match_dialog_idle");
        goto L40
    L29:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r15 = IVoiceChatGuestService.a.a();
        if (r15 == null) goto L40;
        int r16 = bh0.a.a;
        r15.checkAndApply(-1, String.valueOf(106), LinkApplyType.NORMAL.getValue(), "chat_match_dialog_idle");
    L33:
        if (com.bytedance.android.live.liveinteract.plantform.base.f.a().k0(32) == false) goto L37;
        rj0.l.n2.getClass();
        rj0.l r17 = rj0.l.a.a();
        if (r17 == null) goto L40;
        rj0.l.b.c(r17, null, 7);
        goto L40
    L37:
        IVoiceChatGuestService.Companion.getClass();
        IVoiceChatGuestService r18 = IVoiceChatGuestService.a.a();
        if (r18 == null) goto L40;
        IVoiceChatGuestService.b.a(r18, null, 7);
        goto L40
    }
}
