package com.bytedance.android.livesdk.chatroom.ui.setting;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ LiveRealTimePlaybackSettingItem a;

    public o(LiveRealTimePlaybackSettingItem r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        HashMap r6 = new HashMap();
        r6.put("anchor_id", (String) this.a.p.getValue());
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_real_time_playback_note_show", r6, new Object[]{Room.class});
        c9 r7 = (c9) this.a.q.getValue();
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L9;
        DialogLancet.handleBlockedDialogShow(r7);
        return;
    L9:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        DialogLancet.beforeDialogShow(r7);
        r7.show();
        DialogLancet.afterDialogShow(r7);
    }
}
