package com.bytedance.android.livesdk.chatroom.utils;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livehostapi.business.depend.livead.ILiveAdService;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j0 implements com.bytedance.android.livesdk.log.filter.v {
    public static final com.bytedance.android.livesdk.log.b a = null;
    public static final j0 b = null;

    public j0() {
    }

    static {
        b = new j0();
        a = new com.bytedance.android.livesdk.log.b("LiveAdLogUtils", null);
    }

    public final void Rd() {
        a.a("added");
    }

    public final void onRemove() {
        a.a("removed");
    }

    public final void L9(String r10, Map<String, String> r11) {
        Intrinsics.checkNotNullParameter(r10, "eventName");
        Intrinsics.checkNotNullParameter(r11, "params");
        if (r10.hashCode() == 2009019068) goto L6;
        return;
    L6:
        if (r10.equals("livesdk_recharge_success") == false) goto L39;
        Activity r12 = com.bytedance.android.live.core.utils.a.d();
        String r3 = null;
        if ((r12 instanceof FragmentActivity) == true) goto L10;
        r12 = null;
    L10:
        FragmentActivity r13 = (FragmentActivity) r12;
        if (r13 == null) goto L40;
        JSONObject r14 = jc1.k.n(ILiveAdService.class).getCurrentRoomInfo(r13);
        if (r14 != null) goto L15;
        return;
    L15:
        HashMap r2 = new HashMap();
        JSONObject r4 = new JSONObject();
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);     // Catch: JSONException -> L33
        if (r5 == null) goto L23;
        com.bytedance.live.datacontext.m r7 = r5.getRoom();     // Catch: JSONException -> L33
        if (r7 == null) goto L23;
        Room r8 = (Room) r7.getValue();     // Catch: JSONException -> L33
        if (r8 == null) goto L23;
        Long r9 = Long.valueOf(r8.id);     // Catch: JSONException -> L33
    L24:
        r4.put("room_id", r9);     // Catch: JSONException -> L33
        if (r5 == null) goto L31;
        com.bytedance.live.datacontext.m r6 = r5.getRoom();     // Catch: JSONException -> L33
        if (r6 == null) goto L31;
        Room r15 = (Room) r6.getValue();     // Catch: JSONException -> L33
        if (r15 == null) goto L31;
        r3 = r15.getOwnerUserIdString();     // Catch: JSONException -> L33
    L31:
        r4.put("anchor_id", r3);     // Catch: JSONException -> L33
        r4.put("amount", r11.get("money"));     // Catch: JSONException -> L33
        r2.put("log_extra", r14.optString("log_extra"));     // Catch: JSONException -> L33
        r2.put("value", r14.optString("value"));     // Catch: JSONException -> L33
        r2.put("ad_extra_data", r4.toString());     // Catch: JSONException -> L33
    L35:
        jc1.k.n(ILiveDouPlusService.class).logEvent(true, "live_ad", "recharge", r2);
        a.b("report ad recharge_success");
        return;
    L23:
        r9 = null;
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L35
    L40:
        return;
    }
}
