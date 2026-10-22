package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.content.Context;
import android.view.View;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d2 extends com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d {
    public DataCenter b;
    public final String c;

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d
    public final int a() {
        return 2131392581;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final boolean showRedDot() {
        IBroadcastService r0 = jc1.k.f(IBroadcastService.class);
        if (r0 == null) goto L6;
        r0.getBroadcastDotManager();
    L6:
        if (Intrinsics.areEqual(null, Boolean.TRUE) == false) goto L12;
        IBroadcastService r1 = jc1.k.f(IBroadcastService.class);
        if (r1 == null) goto L14;
        r1.getBroadcastDotManager();
        return true;
    L14:
        return true;
    L12:
        return false;
    }

    public d2() {
        this.c = ((com.bytedance.android.livesdk.interactivity.api.settings.config.w0) r52.d4.a.getValue()).f();
    }

    public static void b(String r5) {
        LinkedHashMap r0 = new LinkedHashMap();
        IRoomService r1 = jc1.k.f(IRoomService.class);
        if (r1 == null) goto L8;
        Room r2 = r1.getCurrentRoom();
        if (r2 == null) goto L8;
        r0.put("room_id", String.valueOf(r2.id));
        r0.put("anchor_id", r2.getAnchorId());
        r0.put("live_type", String.valueOf(r2.getStreamType().getSceneName()));
    L8:
        r0.put("icon_type", "chat_channel");
        com.bytedance.android.livesdk.log.u.l().sendLog(r5, r0, new Object[]{am2.x.class});
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r6) {
        if (RoomContext.a.c(RoomContext.Companion, this.b, 0, 2) != null) goto L5;
        return;
    L5:
        IBroadcastService r0 = jc1.k.f(IBroadcastService.class);
        if (r0 == null) goto L8;
        r0.getBroadcastDotManager();
    L8:
        b("livesdk_more_function_chat_channel_icon_click");
        String r1 = this.c;
        if (r1 == null) goto L19;
        String r2 = com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.h.a(r1, "more_function_panel");
        if (r2 == null) goto L20;
        IBaseLiveActionHandler r3 = jc1.k.f(IBaseLiveActionHandler.class);
        if (r3 == null) goto L21;
        if (r6 == null) goto L16;
        Context r7 = r6.getContext();
    L17:
        r3.handle(r7, r2);
        return;
    L16:
        r7 = null;
        goto L17
    L21:
        return;
    L20:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.d, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "dataCenter");
        super.p4(r2, r3);
        b("livesdk_more_function_chat_channel_icon_show");
        this.b = r3;
    }
}
