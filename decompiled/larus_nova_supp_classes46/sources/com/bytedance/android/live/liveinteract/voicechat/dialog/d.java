package com.bytedance.android.live.liveinteract.voicechat.dialog;

import android.view.View;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.widget.widget.LinkDistributeSettingDialog;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdkapi.service.ILinkDistributionSettingCallback;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ ChatRoomDistributeTipsDialog a;

    public static final class a implements ILinkDistributionSettingCallback {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void onStatusChanged(int r3) {
            ChatRoomDistributeTipsDialog r0 = this.a.a;
            ChatRoomDistributeTipsDialog.a r1 = ChatRoomDistributeTipsDialog.f;
            r0.T90(r3);
        }
    }

    public d(ChatRoomDistributeTipsDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        LinkDistributeSettingDialog r8 = new LinkDistributeSettingDialog(this.a.requireContext(), ((ILinkmicAudienceSetting.LinkmicSettingStatus) b6.r.getValue()).getValue(), "first_link", false, new a(this));
        r8.M0();
        if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r8);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r8);
        r8.show();
        DialogLancet.afterDialogShow(r8);
    }
}
