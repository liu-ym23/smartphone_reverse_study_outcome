package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.browser.jsbridge.base.SendCommerceEventResultModel;
import com.bytedance.android.livesdkapi.business.ILiveDouPlusService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.net.URLDecoder;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "sendCommerceEvent")
public final class rb extends w20.v5<w20.zd, SendCommerceEventResultModel> {
    public rb() {
    }

    public final void invoke(Object r18, CallContext r19) {
        w20.zd r1 = (w20.zd) r18;
        Intrinsics.checkNotNullParameter(r1, "params");
        Intrinsics.checkNotNullParameter(r19, "context");
        String r13 = r1.a();
        JsonObject r2 = r1.b();
        if (r2 == null) goto L86;
        JsonElement r14 = r2.get("enter_from_dou_plus");     // Catch: Exception -> L80
        if (r14 == null) goto L8;
        String r15 = r14.getAsString();     // Catch: Exception -> L80
    L10:
        if ((!Intrinsics.areEqual(r15, GamePromoteDataContext.GAME_TYPE_MOBILE)) == true) goto L85;
        JsonElement r16 = r2.get("creative_id");     // Catch: Exception -> L80
        if (r16 == null) goto L14;
        String r17 = r16.getAsString();     // Catch: Exception -> L80
    L15:
        if (r17 == null) goto L20;
        if (r17.length() == 0) goto L20;
        boolean r110 = false;
    L21:
        if (r110 == true) goto L87;
        JSONObject r111 = new JSONObject();     // Catch: Exception -> L78
        JsonElement r112 = r2.get("enter_from_merge");     // Catch: Exception -> L78
        if (r112 == null) goto L26;
        String r113 = r112.getAsString();     // Catch: Exception -> L78
    L27:
        r111.put("enter_from_merge", r113);     // Catch: Exception -> L78
        JsonElement r114 = r2.get("enter_method");     // Catch: Exception -> L78
        if (r114 == null) goto L30;
        String r115 = r114.getAsString();     // Catch: Exception -> L78
    L31:
        r111.put("enter_from_method", r115);     // Catch: Exception -> L78
        JsonElement r11 = r2.get("room_id");     // Catch: Exception -> L78
        if (r11 == null) goto L34;
        String r12 = r11.getAsString();     // Catch: Exception -> L78
    L35:
        r111.put("room_id", r12);     // Catch: Exception -> L78
        JsonElement r9 = r2.get("author_id");     // Catch: Exception -> L78
        if (r9 == null) goto L38;
        String r21 = r9.getAsString();     // Catch: Exception -> L78
    L39:
        r111.put("author_id", r21);     // Catch: Exception -> L78
        JsonElement r8 = r2.get("vs_episode_id");     // Catch: Exception -> L78
        if (r8 == null) goto L42;
        String r22 = r8.getAsString();     // Catch: Exception -> L78
    L43:
        r111.put("vs_episode_id", r22);     // Catch: Exception -> L78
        JsonElement r7 = r2.get("vs_episode_stage");     // Catch: Exception -> L78
        if (r7 == null) goto L46;
        String r116 = r7.getAsString();     // Catch: Exception -> L78
    L47:
        r111.put("vs_episode_stage", r116);     // Catch: Exception -> L78
        JsonElement r6 = r2.get("vs_follow_position");     // Catch: Exception -> L78
        if (r6 == null) goto L50;
        r111.put("vs_follow_position", r6.getAsString());     // Catch: Exception -> L78
    L50:
        r111.put("is_ad_event", GamePromoteDataContext.GAME_TYPE_MOBILE);     // Catch: Exception -> L78
        HashMap r5 = new HashMap();     // Catch: Exception -> L78
        JsonElement r23 = r2.get("creative_id");     // Catch: Exception -> L78
        String r24 = "";
        if (r23 == null) goto L55;
        String r25 = r23.getAsString();     // Catch: Exception -> L78
        if (r25 == null) goto L55;
    L56:
        r5.put("value", r25);     // Catch: Exception -> L78
        JsonElement r26 = r2.get("ad_id");     // Catch: Exception -> L78
        if (r26 == null) goto L60;
        String r27 = r26.getAsString();     // Catch: Exception -> L78
        if (r27 == null) goto L60;
    L61:
        r5.put("ad_id", r27);     // Catch: Exception -> L78
        JsonElement r4 = r2.get("is_other_channel");     // Catch: Exception -> L78
        if (r4 == null) goto L65;
        String r28 = r4.getAsString();     // Catch: Exception -> L78
        if (r28 == null) goto L65;
    L66:
        r5.put("is_other_channel", r28);     // Catch: Exception -> L78
        JsonElement r3 = r2.get("log_extra");     // Catch: Exception -> L78
        if (r3 == null) goto L72;
        String r29 = r3.getAsString();     // Catch: Exception -> L78
        if (r29 == null) goto L72;
        r24 = r29;
    L72:
        r5.put("log_extra", URLDecoder.decode(r24));     // Catch: Exception -> L78
        r5.put("event_type", "vs_video_native_action");     // Catch: Exception -> L78
        ILiveDouPlusService r31 = jc1.k.n(ILiveDouPlusService.class);     // Catch: Exception -> L78
        HashMap r32 = new HashMap();     // Catch: Exception -> L78
        r32.put("ad_extra_data", r111.toString());     // Catch: Exception -> L78
        if (r5.isEmpty() == true) goto L76;
        r32.putAll(r5);     // Catch: Exception -> L78
    L76:
        r31.logEvent(true, "vs_ad", r13, r32);     // Catch: Exception -> L78
        com.bytedance.android.livesdk.utils.c1.a = r111;     // Catch: Exception -> L78
        com.bytedance.android.livesdk.utils.c1.b = r5;     // Catch: Exception -> L78
        SendCommerceEventResultModel r33 = new SendCommerceEventResultModel();     // Catch: Exception -> L78
        r33.a(SendCommerceEventResultModel.Code.Success);     // Catch: Exception -> L78
        Unit r34 = Unit.INSTANCE;     // Catch: Exception -> L78
        finishWithResult(r33);     // Catch: Exception -> L78
        return;
    L65:
        r28 = "";
    L60:
        r27 = "";
    L55:
        r25 = "";
        goto L56
    L46:
        r116 = null;
        goto L47
    L42:
        r22 = null;
        goto L43
    L38:
        r21 = null;
        goto L39
    L34:
        r12 = null;
        goto L35
    L30:
        r115 = null;
        goto L31
    L26:
        r113 = null;
    L78:
        SendCommerceEventResultModel r35 = new SendCommerceEventResultModel();
        r35.a(SendCommerceEventResultModel.Code.Failed);
        Unit r36 = Unit.INSTANCE;
        finishWithResult(r35);
        return;
    L87:
        return;
    L20:
        r110 = true;
        goto L21
    L14:
        r17 = null;
        goto L15
    L85:
        return;
    L8:
        r15 = null;
    L89:
        return;
    }
}
