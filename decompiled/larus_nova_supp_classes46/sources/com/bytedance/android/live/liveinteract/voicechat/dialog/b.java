package com.bytedance.android.live.liveinteract.voicechat.dialog;

import am2.x;
import android.view.View;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ ChatRoomDistributeTipsDialog a;

    public b(ChatRoomDistributeTipsDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        ChatRoomDistributeTipsDialog r6 = this.a;
        ChatRoomDistributeTipsDialog.a r0 = ChatRoomDistributeTipsDialog.f;
        r6.getClass();
        LinkedHashMap r7 = new LinkedHashMap();
        int r1 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        TalkRoomLogUtils.B0(r7, Integer.valueOf(r1), null, 4);
        TalkRoomLogUtils.I0(r7, r1);
        int r2 = ((ILinkmicAudienceSetting.LinkmicSettingStatus) b6.r.getValue()).getValue();
        if (r2 != ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OPEN.getValue()) goto L6;
        String r3 = "mutual";
    L9:
        r7.put("selection", r3);
        j0.l().sendLog("livesdk_guest_connection_distribution_popup_click", r7, new Object[]{IRoom.class, x.class});
        this.a.dismiss();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r8 = DialogFragmentLancet.sLastShowStack;
        if (r8 == null) goto L19;
        com.bytedance.crash.d.d(r8, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    L19:
        return;
    L6:
        if (r2 != ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_DELEGATED_TO_EVERYONE.getValue()) goto L8;
        r3 = "all";
        goto L9
    L8:
        ILinkmicAudienceSetting.LinkmicSettingStatus.SETTING_OFF.getValue();
        r3 = "none";
        goto L9
    }
}
