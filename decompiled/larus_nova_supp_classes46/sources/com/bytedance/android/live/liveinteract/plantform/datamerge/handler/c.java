package com.bytedance.android.live.liveinteract.plantform.datamerge.handler;

import com.bytedance.android.live.base.model.message.ILinkmicEnlargeGuestMessage;
import com.bytedance.android.live.base.model.message.d6;
import com.bytedance.android.live.base.model.message.f6;
import com.bytedance.android.livesdk.chatroom.model.interact.EnlargeGuestInfo;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c extends a implements vlc.l {
    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void attach() {
        com.bytedance.android.livesdk.chatroom.t r0 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L9;
        r1.c(new CPositionDataHandler$attachMessage$1(this));
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.plantform.datamerge.handler.h
    public final void detach() {
        com.bytedance.android.livesdk.chatroom.t r0 = com.bytedance.android.live.liveinteract.api.utils.m.b();
        if (r0 == null) goto L8;
        com.bytedance.live.datacontext.j r1 = r0.getMessageManager();
        if (r1 == null) goto L9;
        r1.c(new CPositionDataHandler$detachMessage$1(this));
        return;
    L9:
        return;
    }

    public c() {
    }

    public final void onMessage(tlc.d r5) {
        if ((r5 instanceof ILinkmicEnlargeGuestMessage) == false) goto L20;
        ILinkmicEnlargeGuestMessage r6 = (ILinkmicEnlargeGuestMessage) r5;
        int r0 = r6.getMsg_type();
        EnlargeGuestInfo r2 = null;
        if (r0 != ILinkmicEnlargeGuestMessage.LinkmicEnlargeGuestMessageType.EnlargeGuestMessageType_TurnOn.ordinal()) goto L11;
        f6 r7 = r6.getTurn_on_content();
        if (r7 == null) goto L9;
        r2 = r7.getEnlargeGuestInfo();
    L9:
        d(true, r2);
        return;
    L11:
        if (r0 != ILinkmicEnlargeGuestMessage.LinkmicEnlargeGuestMessageType.EnlargeGuestMessageType_ChangeUser.ordinal()) goto L17;
        d6 r8 = r6.getChange_user_content();
        if (r8 == null) goto L15;
        r2 = r8.getEnlargeGuestInfo();
    L15:
        d(true, r2);
        return;
    L17:
        if (r0 != ILinkmicEnlargeGuestMessage.LinkmicEnlargeGuestMessageType.EnlargeGuestMessageType_TurnOff.ordinal()) goto L23;
        EnlargeGuestInfo r9 = (EnlargeGuestInfo) vh7.f.c(EnlargeGuestInfo.class);
        r9.setEnlargeGuestType(EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Unkown.ordinal());
        Unit r1 = Unit.INSTANCE;
        d(false, r9);
        return;
    L23:
        return;
    }

    public final void d(boolean r6, EnlargeGuestInfo r7) {
        wg0.a r0 = (wg0.a) a().b().getValue();
        if (r0 != null) goto L5;
        return;
    L5:
        EnlargeGuestInfo.EnlargeGuestType.a r1 = EnlargeGuestInfo.EnlargeGuestType.Companion;
        if (r7 == null) goto L8;
        Integer r8 = Integer.valueOf(r7.getEnlargeGuestType());
    L9:
        r1.getClass();
        EnlargeGuestInfo.EnlargeGuestType r2 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Unkown;
        int r3 = r2.ordinal();
        if (r8 != null) goto L13;
    L15:
        EnlargeGuestInfo.EnlargeGuestType r4 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Single;
        int r5 = r4.ordinal();
        if (r8 != null) goto L19;
    L21:
        r4 = EnlargeGuestInfo.EnlargeGuestType.EnlargeGuestType_Double;
        int r9 = r4.ordinal();
        if (r8 != null) goto L25;
    L27:
        wg0.a r10 = wg0.a.a(r0, r6, r2, false, 4);
        a().c(r10);
        return;
    L25:
        if (r8.intValue() != r9) goto L27;
    L20:
        r2 = r4;
        goto L27
    L19:
        if (r8.intValue() != r5) goto L21;
    L13:
        if (r8.intValue() != r3) goto L15;
    L8:
        r8 = null;
        goto L9
    }
}
