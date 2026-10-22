package com.bytedance.android.live.liveinteract.interact.audience.fragment;

import android.content.DialogInterface;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements DialogInterface.OnClickListener {
    public final /* synthetic */ InteractAudienceContainerFragment a;

    public j(InteractAudienceContainerFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r5, int r6) {
        r5.dismiss();
        com.bytedance.android.live.liveinteract.plantform.base.d.j0.getClass();
        com.bytedance.android.live.liveinteract.plantform.base.d r7 = com.bytedance.android.live.liveinteract.plantform.base.d.a.a();
        if (this.a.l == false) goto L5;
        HashMap r8 = new HashMap();
        r8.put("anchor_action_type", "close");
        j0.l().sendLog("livesdk_guest_connection_anchor_switch", r8, new Object[]{IRoom.class});
    L5:
        if (r7 == null) goto L8;
        r7.finishInteract("stop_normally");
        return;
    }
}
