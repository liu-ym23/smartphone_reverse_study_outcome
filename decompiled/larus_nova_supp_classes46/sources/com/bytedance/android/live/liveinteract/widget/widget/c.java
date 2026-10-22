package com.bytedance.android.live.liveinteract.widget.widget;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.livesdk.chatroom.model.ILinkmicAudienceSetting;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.service.ILinkDistributionSettingCallback;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ ChatRoomGuestSettingDialog a;

    public static final class a implements ILinkDistributionSettingCallback {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final void onStatusChanged(int r3) {
            ChatRoomGuestSettingDialog r0 = this.a.a;
            int r1 = ChatRoomGuestSettingDialog.f;
            r0.M0(r3);
        }
    }

    public c(ChatRoomGuestSettingDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        Context r1 = this.a.getContext();
        Intrinsics.checkNotNull(r1);
        LinkDistributeSettingDialog r8 = new LinkDistributeSettingDialog(r1, ((ILinkmicAudienceSetting.LinkmicSettingStatus) b6.r.getValue()).getValue(), "live_settings", false, new a(this));
        r8.M0();
        if (DialogLancet.shouldBlockDialogShow(r8) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r8);
    L7:
        int r9 = ChatRoomGuestSettingDialog.f;
        LinkedHashMap r10 = new LinkedHashMap();
        int r0 = ((IInteractService) jc1.k.n(IInteractService.class)).getCurrentScene();
        TalkRoomLogUtils.B0(r10, Integer.valueOf(r0), null, 4);
        TalkRoomLogUtils.I0(r10, r0);
        j0.l().sendLog("livesdk_guest_connection_settings_policy_click", r10, new Object[]{IRoom.class, am2.x.class});
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(r8);
        r8.show();
        DialogLancet.afterDialogShow(r8);
        goto L7
    }
}
