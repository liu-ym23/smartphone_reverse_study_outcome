package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.google.gson.JsonObject;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class s2 {
    public static final JsonObject a = null;

    static {
        JsonObject r0 = new JsonObject();
        JsonObject r1 = new JsonObject();
        r1.addProperty(LiveEndPageData.TAG_RANK, 0);
        r1.addProperty("gap_description", 0);
        r1.addProperty("fixed_footer_description", 0);
        JsonObject r3 = new JsonObject();
        r3.addProperty("id", 0);
        r3.addProperty("sec_uid", 0);
        r3.addProperty("nickname", 0);
        JsonObject r4 = new JsonObject();
        JsonObject r5 = new JsonObject();
        r5.addProperty("_length", 1);
        Unit r6 = Unit.INSTANCE;
        r4.add("url_list", r5);
        r3.add("avatar_thumb", r4);
        JsonObject r7 = new JsonObject();
        r7.addProperty("follow_status", 0);
        r3.add("follow_info", r7);
        JsonObject r8 = new JsonObject();
        JsonObject r9 = new JsonObject();
        r9.addProperty("_length", -1);
        r8.add("room_ids", r9);
        r3.add("own_room", r8);
        r1.add("user", r3);
        r0.addProperty("delta_time", 0);
        r0.addProperty("subtitle", 0);
        r0.addProperty("region_name", 0);
        r0.addProperty("rules_url_v2", 0);
        r0.addProperty("charts_description", 0);
        r0.add("anchor_info", r1);
        JsonObject r2 = new JsonObject();
        r2.addProperty("_length", -1);
        r2.add("_filter_keys", r1);
        r0.add("ranks", r2);
        a = r0;
    }

    public static final JsonObject a() {
        return a;
    }
}
