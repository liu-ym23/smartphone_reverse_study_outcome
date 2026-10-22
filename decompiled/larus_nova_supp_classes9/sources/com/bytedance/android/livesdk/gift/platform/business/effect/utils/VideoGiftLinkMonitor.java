package com.bytedance.android.livesdk.gift.platform.business.effect.utils;

import com.bytedance.android.livesdk.gift.platform.business.effect.player.i;
import com.bytedance.android.livesdk.gift.platform.core.d0;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class VideoGiftLinkMonitor {

    public static final enum Event extends Enum<Event> {
        public static final /* synthetic */ Event[] a = null;
        public static final Event consume_effect_message = null;
        public static final Event consume_message = null;
        public static final Event load_resource_success = null;
        public static final Event playcontroller_end = null;
        public static final Event playcontroller_receive = null;
        public static final Event playcontroller_start = null;
        public static final Event receive_message = null;

        static {
            Event r0 = new Event("receive_message", 0);
            receive_message = r0;
            Event r1 = new Event("consume_message", 1);
            consume_message = r1;
            Event r3 = new Event("load_resource_success", 2);
            load_resource_success = r3;
            Event r5 = new Event("consume_effect_message", 3);
            consume_effect_message = r5;
            Event r7 = new Event("playcontroller_receive", 4);
            playcontroller_receive = r7;
            Event r9 = new Event("playcontroller_start", 5);
            playcontroller_start = r9;
            Event r11 = new Event("playcontroller_end", 6);
            playcontroller_end = r11;
            a = new Event[]{r0, r1, r3, r5, r7, r9, r11};
        }

        public static Event[] values() {
            return (Event[]) a.clone();
        }

        public static Event valueOf(String r1) {
            return (Event) a.a(Event.class, r1);
        }

        public Event(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static void a(Event r4, long r5, long r7, long r9) {
        JSONObject r0 = new JSONObject();     // Catch: Exception -> L11
        r0.put("timestamp", System.currentTimeMillis());     // Catch: Exception -> L11
        r0.put("event", r4.name());     // Catch: Exception -> L11
        i.a().getClass();     // Catch: Exception -> L11
        int r2 = 1;
        if (i.b.get(i.c) == null) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r2 = 0;
    L9:
        r0.put("player_state", r2);     // Catch: Exception -> L11
        r0.put("message_id", r5);     // Catch: Exception -> L11
        r0.put("gift_id", r7);     // Catch: Exception -> L11
        r0.put("effect_id", r9);     // Catch: Exception -> L11
        d0.e(r0);     // Catch: Exception -> L11
        return;
    L5:
        r1 = false;
    }
}
