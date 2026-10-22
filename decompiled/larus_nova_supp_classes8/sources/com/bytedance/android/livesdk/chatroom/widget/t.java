package com.bytedance.android.livesdk.chatroom.widget;

import android.view.View;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class t implements View.OnClickListener {
    public final /* synthetic */ u a;
    public final /* synthetic */ RoomDecoration b;

    public t(u r1, RoomDecoration r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r5) {
        u.a r6 = this.a.O;
        if (r6 == null) goto L5;
        r6.T9(this.b.isTextSticker());
    L5:
        UtilityKotlinExtentionsKt.t(this.a);
        u r7 = this.a;
        r7.getClass();
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("sticker_id", String.valueOf(r7.getRoomDecoration().getId()));
        com.bytedance.android.livesdk.log.u.l().sendLog("livesdk_audience_sticker_close", r0, new Object[]{Room.class, new am2.x()});
    }
}
