package com.bytedance.android.livesdk.chatroom.ui.livesticker.utils;

import com.bytedance.android.live.core.monitor.LiveMonitor;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.android.live.core.utils.h1;
import com.bytedance.android.live.core.utils.i1;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.RoomDecoration;
import kotlin.jvm.JvmStatic;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    @JvmStatic
    public static final void b(int r3) {
        NewBroadcastMonitor.a r0 = NewBroadcastMonitor.c("ttlive_anchor_sticker_event", null, null, 14);
        r0.l(r3);
        r0.a().report();
    }

    @JvmStatic
    public static final void a(Room r3, RoomDecoration r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r4 != null) goto L6;
        return;
    L6:
        JSONObject r0 = new JSONObject();
        r0.put("room_id", String.valueOf(r3.id));
        LiveMode r5 = r3.getStreamType();
        int r1 = h1.a;
        r0.put("live_type", i1.a(r5));
        r0.put("source", "live_take_detail");
        r0.put("sticker_id", String.valueOf(r4.getId()));
        if (r4.isTextSticker() == false) goto L9;
        r0.put("sticker_type", "text");
        r0.put("sticker_content", r4.getContent());
    L10:
        NewBroadcastMonitor.a r6 = NewBroadcastMonitor.c("ttlive_anchor_select_sticker", null, null, 14);
        ((LiveMonitor.a) r6).e = r0;
        r6.a().report();
        return;
    L9:
        r0.put("sticker_type", "image");
        goto L10
    }

    @JvmStatic
    public static final void c(Integer r3, String r4, Throwable r5) {
        NewBroadcastMonitor.a r0 = NewBroadcastMonitor.c("ttlive_fetch_decoration_list", null, null, 14);
        if (r3 == null) goto L5;
        int r6 = r3.intValue();
    L6:
        r0.l(r6);
        r0.i("err_msg", r4);
        r0.n(r5);
        r0.a().report();
        return;
    L5:
        r6 = -1;
        goto L6
    }
}
