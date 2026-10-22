package com.bytedance.android.livesdk.commerce;

import android.text.TextUtils;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.log.filter.u;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.log.model.LiveVSLog;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import java.util.HashMap;
import java.util.Map;
import jc1.k;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a {
    public final HashMap<String, String> a;

    public a(com.bytedance.android.live.base.model.g r7) {
        HashMap<String, String> r0 = new HashMap();
        this.a = r0;
        String r1 = "0";
        if (r7 != null) goto L5;
        String r2 = "0";
    L6:
        r0.put("room_id", r2);
        u r3 = j0.l().c(Room.class);
        if (r3 == null) goto L9;
        String r4 = r3.z(r2);
    L10:
        r0.put("request_id", r4);
        if (r7 != null) goto L13;
    L26:
        r0.put("sdk_version", String.valueOf(com.bytedance.android.livesdk.paas.c.b()));
        r0.put("_param_live_platform", "live");
        r0.put("device_id", k.f(IMiddleWareHostContext.class).getServerDeviceId());
        boolean r5 = r7 instanceof Room;
        if (r5 == false) goto L31;
        Room r6 = (Room) r7;
        if (r6.isMergeVSRoom() == false) goto L31;
        LiveVSLog.r.getClass();
        r0.putAll(LiveVSLog.b.a(r6).a());
    L31:
        if (r5 == false) goto L39;
        Room r8 = (Room) r7;
        if (r8.isEcomNew() == true) goto L35;
        return;
    L35:
        if (r8.isEcomNew() == false) goto L37;
        r1 = "1";
    L37:
        r0.put("is_ecom_new", r1);
        return;
    L39:
        return;
    L13:
        if (r7.getOwner() == null) goto L16;
        r0.put("anchor_id", r7.getOwner().getUserId());
    L16:
        if (TextUtils.isEmpty(r7.getRequestId()) == true) goto L19;
        r0.put("request_id", r7.getRequestId());
    L19:
        if (r7.getOwner() == null) goto L21;
        boolean r9 = r7.getOwner().isFollowing();
    L22:
        if (r9 == false) goto L24;
        String r10 = "1";
    L25:
        r0.put("follow_status", r10);
        goto L26
    L24:
        r10 = "0";
        goto L25
    L21:
        r9 = false;
        goto L22
    L9:
        r4 = "";
        goto L10
    L5:
        r2 = String.valueOf(r7.getId());
        goto L6
    }

    public final void a(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L6;
        this.a.put("action_type", r3);
        return;
    }

    public final void b(Map r6) {
        if (r6 == null) goto L8;
        Object r0 = r6.get("value");
        Object r7 = r6.get("log_extra");
        if (r0 == null) goto L9;
        if (r7 == null) goto L10;
        this.a.put("aweme_ad_type", "dou_plus");
        this.a.put("creative_id", r0.toString());
        this.a.put("log_extra", r7.toString());
        return;
    L10:
        return;
    L9:
        return;
    }

    public final void c(Map r6) {
        if (r6 == null) goto L8;
        Object r0 = r6.get("value");
        Object r7 = r6.get("log_extra");
        if (r0 == null) goto L9;
        if (r7 == null) goto L10;
        this.a.put("aweme_ad_type", "effect_ad");
        this.a.put("creative_id", r0.toString());
        this.a.put("log_extra", r7.toString());
        return;
    L10:
        return;
    L9:
        return;
    }

    public final void d(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L6;
        this.a.put("enter_from_merge", r3);
        return;
    }

    public final void e(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L6;
        this.a.put("enter_method", r3);
        return;
    }

    public final void f(String r4) {
        if (TextUtils.isEmpty(r4) == true) goto L24;
        JSONObject r0 = new JSONObject(r4);     // Catch: Exception -> L19
        String r5 = r0.optString("creativeID");     // Catch: Exception -> L19
        if (TextUtils.isEmpty(r5) == false) goto L9;
        r5 = r0.optString("creative_id");     // Catch: Exception -> L19
    L9:
        if (TextUtils.isEmpty(r5) == true) goto L11;
        this.a.put("creative_id", r5);     // Catch: Exception -> L19
    L11:
        String r6 = r0.optString("logExtra");     // Catch: Exception -> L19
        if (TextUtils.isEmpty(r6) == false) goto L16;
        r6 = r0.optString("log_extra");     // Catch: Exception -> L19
    L16:
        if (TextUtils.isEmpty(r6) == true) goto L25;
        this.a.put("log_extra", r6);     // Catch: Exception -> L19
        return;
    L25:
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    }

    public final void g(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L6;
        this.a.put("is_other_channel", r3);
        return;
    }

    public final void h(Map<String, String> r7) {
        HashMap r8 = (HashMap) r7;
        String r1 = (String) r8.get("search_id");
        String r3 = (String) r8.get("search_type");
        String r9 = (String) r8.get("search_params");
        if (r1 == null) goto L7;
        if (r3 == null) goto L7;
        this.a.put("search_id", r1);
        this.a.put("search_type", r3);
    L7:
        if (TextUtils.isEmpty(r9) == true) goto L17;
        JSONObject r0 = new JSONObject();
        r0.put("search_params", r9);     // Catch: JSONException -> L11
    L13:
        this.a.put("live_tracker_params", r0.toString());
        return;
    L11:
        e = move-exception;
        e.printStackTrace();
        goto L13
    }

    public final void i(String r3) {
        if (TextUtils.isEmpty(r3) == true) goto L6;
        this.a.put("group_id", r3);
        return;
    }
}
