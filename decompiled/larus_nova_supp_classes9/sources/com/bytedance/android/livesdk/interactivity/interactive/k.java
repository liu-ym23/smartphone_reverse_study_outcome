package com.bytedance.android.livesdk.interactivity.interactive;

import android.content.DialogInterface;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatusStyle;
import com.bytedance.ies.sdk.widgets.DataCenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k implements DialogInterface.OnDismissListener {
    public final /* synthetic */ LiveInteractiveAnnieXHelper a;

    public k(LiveInteractiveAnnieXHelper r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r2) {
        Integer r3 = this.a.o;
        if (r3 == null) goto L16;
        int r4 = r3.intValue();
        DataCenter r0 = this.a.q;
        if (r0 == null) goto L17;
        IRoom r1 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r0);
        if (r1 == null) goto L18;
        IRoomAuthStatus r5 = r1.getRoomAuthStatus();
        if (r5 == null) goto L19;
        IRoomAuthStatus.IRoomAuthSpecialStyle r6 = r5.getRoomAuthSpecialStyle();
        if (r6 == null) goto L20;
        IRoomAuthStatusStyle r7 = r6.getChatStyle();
        if (r7 == null) goto L21;
        r7.setUnableStyle(r4);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    }
}
