package com.bytedance.android.live.broadcast;

import am2.x;
import android.content.Context;
import android.view.View;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.depend.model.broadcast.CommonBubble;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ Context a;
    public final /* synthetic */ CommonBubble b;
    public final /* synthetic */ String c;

    public b(Context r1, CommonBubble r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        ILiveService r11 = TTLiveService.getLiveService();
        if (r11 == null) goto L5;
        r11.handleSchema(this.a, UriProtector.parse(this.b.getSchema()));
    L5:
        g r12 = g.a;
        String r13 = this.c;
        CommonBubble r0 = this.b;
        LinkedHashMap r1 = new LinkedHashMap();
        RoomContext.a r2 = RoomContext.Companion;
        if (r2 == null) goto L14;
        RoomContext r3 = RoomContext.a.c(r2, null, 0, 3);
        if (r3 == null) goto L14;
        com.bytedance.live.datacontext.i r4 = r3.isAnchor();
        if (r4 == null) goto L14;
        if (((Boolean) r4.getValue()).booleanValue() != true) goto L14;
        String r5 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L15:
        r1.put("is_anchor", r5);
        if (Intrinsics.areEqual(r13, "create_page") == false) goto L18;
        String r14 = "live_take_page";
    L19:
        r1.put("event_page", r14);
        r1.put("text_detail", r0.getText());
        String r15 = String.valueOf(Long.valueOf(r0.getId()).longValue());
        if (r15 != null) goto L22;
        r15 = "";
    L22:
        r1.put("bubble_id", r15);
        r1.putAll(r0.getExtra());
        u.l().sendLog("livesdk_anchor_guide_bubble_click", r1, new Object[]{Room.class, x.class});
        return;
    L18:
        r14 = "live_detail";
    L14:
        r5 = "0";
        goto L15
    }
}
