package com.bytedance.android.live.liveinteract.feed.datamerge;

import com.bytedance.android.live.base.model.message.ILinkmicEnlargeGuestMessage;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.service.MessageHub;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends a implements vlc.l {
    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void attach() {
        MessageHub r0 = c().getMessageHub();
        if (r0 == null) goto L6;
        r0.addMessageListener(MessageType.LINK_MIC_ENLARGE_GUEST_MESSAGE.getIntType(), this);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.feed.datamerge.j
    public final void detach() {
        MessageHub r0 = c().getMessageHub();
        if (r0 == null) goto L6;
        r0.removeMessageListener(MessageType.LINK_MIC_ENLARGE_GUEST_MESSAGE.getIntType(), this);
        return;
    }

    public c() {
    }

    public final void e(boolean r5) {
        wg0.a r6 = wg0.a.a(c().j(), r5, null, false, 6);
        c().c(r6);
    }

    public final void onMessage(tlc.d r3) {
        if ((r3 instanceof ILinkmicEnlargeGuestMessage) == false) goto L14;
        int r4 = ((ILinkmicEnlargeGuestMessage) r3).getMsg_type();
        if (r4 != ILinkmicEnlargeGuestMessage.LinkmicEnlargeGuestMessageType.EnlargeGuestMessageType_TurnOn.ordinal()) goto L8;
        e(true);
        return;
    L8:
        if (r4 != ILinkmicEnlargeGuestMessage.LinkmicEnlargeGuestMessageType.EnlargeGuestMessageType_ChangeUser.ordinal()) goto L11;
        e(true);
        return;
    L11:
        if (r4 != ILinkmicEnlargeGuestMessage.LinkmicEnlargeGuestMessageType.EnlargeGuestMessageType_TurnOff.ordinal()) goto L17;
        e(false);
        return;
    L17:
        return;
    }
}
