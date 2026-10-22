package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.livesdkapi.model.AnchorInteractInfo;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiCanvas;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.android.livesdkapi.model.StreamSize;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class w {
    public long a;
    public final j b;

    public w(j r3) {
        this.a = 0;
        this.b = r3;
    }

    public static SeiAppData a(JSONObject r20) throws JSONException {
        String r0 = "loading";
        String r2 = "talk_volume";
        SeiAppData r8 = new SeiAppData();
        r8.setTimestamp(r20.optLong("timestamp"));
        r8.setVersion(r20.optInt("ver"));
        r8.setStyle(r20.optInt("style"));
        r8.setVendor(r20.optString("vendor"));
        r8.setChannelId(r20.optString("channel_id"));
        r8.setSubScene(r20.optInt("sub_scene"));
        r8.setGameType(r20.optInt("game_type"));
        r8.setGameFull(r20.optInt("game_full"));
        r8.setGameFullV2(r20.optInt("game_full_v2"));
        r8.setGameMixStreamType(r20.optInt("mix_stream_type"));
        r8.setLayoutKey(r20.optString("layout_key"));
        String r9 = r20.optString("grids");
        r8.setCount(r20.optLong("count", 0));
        r8.setEventParams(r20.optJSONObject("event_params"));
        JSONObject r10 = r20.optJSONObject("anchor_interact_info");     // Catch: Exception -> L46
        if (r10 == null) goto L6;
        AnchorInteractInfo r11 = new AnchorInteractInfo();     // Catch: Exception -> L46
        r11.setFocusID(r10.optString("focus_id"));     // Catch: Exception -> L46
        r11.setLayoutType(r10.optInt("layout_type"));     // Catch: Exception -> L46
        r11.setOwnerIndex(r10.optInt("owner_index"));     // Catch: Exception -> L46
        r8.setAnchorInteractInfo(r11);     // Catch: Exception -> L46
    L6:
        JSONObject r12 = r20.optJSONObject("stream_size");     // Catch: Exception -> L46
        if (r12 == null) goto L11;
        StreamSize r15 = new StreamSize();     // Catch: Exception -> L46
        r15.setH(r12.optDouble("h"));     // Catch: Exception -> L46
        r15.setW(r12.optDouble("w"));     // Catch: Exception -> L46
        r15.setX(r12.optDouble("x"));     // Catch: Exception -> L46
        r15.setY(r12.optDouble("y"));     // Catch: Exception -> L46
        r15.setGameRatio(r12.optDouble("game_ratio"));     // Catch: Exception -> L46
        r8.setStreamSize(r15);     // Catch: Exception -> L46
    L11:
        JSONArray r1 = new JSONArray(r9);     // Catch: Exception -> L46
        int r3 = r1.length();     // Catch: Exception -> L46
        ArrayList r13 = new ArrayList();     // Catch: Exception -> L46
        int r16 = 0;
    L12:
        if (r16 >= r3) goto L42;
        JSONObject r14 = (JSONObject) r1.opt(r16);     // Catch: Exception -> L46
        JSONArray r17 = r1;
        int r18 = r3;
        SeiAppData r4 = r8;
        ArrayList r19 = r13;
        SeiRegion r5 = new SeiRegion().setType(r14.optInt("type")).setX(r14.optDouble("x")).setY(r14.optDouble("y")).setWidth(r14.optDouble("w")).setHeight(r14.optDouble("h"));     // Catch: Exception -> L44
        r5.setAccount(r14.optLong("account"));     // Catch: Exception -> L44
        if (r14.has("p") == false) goto L19;
        r5.setPosition(r14.optInt("p"));     // Catch: Exception -> L44
    L19:
        if (r14.has("uid") == false) goto L22;
        r5.setUid(r14.optInt("uid"));     // Catch: Exception -> L44
    L22:
        if (r14.has("uid_str") == false) goto L25;
        r5.setUidStr(r14.optString("uid_str"));     // Catch: Exception -> L44
    L25:
        if (r14.has("talk") == false) goto L28;
        r5.setTalk(r14.optInt("talk"));     // Catch: Exception -> L44
    L28:
        if (r14.has("mute_audio") == false) goto L31;
        r5.setMuteAudio(r14.optInt("mute_audio"));     // Catch: Exception -> L44
    L31:
        if (r14.has(r2) == false) goto L33;
        r5.setTalkVolume(r14.optInt(r2));     // Catch: Exception -> L44
    L33:
        String r21 = r0;
        if (r14.has(r21) == false) goto L41;
        boolean r6 = true;
        if (r14.optInt(r21) == 1) goto L39;
        r6 = false;
    L39:
        r5.setIsLocal(r6);     // Catch: Exception -> L44
    L41:
        r5.setStatus(r14.optInt("stat"));     // Catch: Exception -> L44
        r19.add(r5);     // Catch: Exception -> L44
        r16 = r16 + 1;     // Catch: Exception -> L44
        r13 = r19;
        r2 = r2;
        r1 = r17;
        r0 = r21;
        r8 = r4;
        r3 = r18;
    L44:
        e = e;
    L48:
        e.printStackTrace();
    L49:
        JSONObject r7 = r20.optJSONObject("canvas");
        if (r7 == null) goto L52;
        SeiCanvas r22 = new SeiCanvas();
        r22.setWidth(r7.optInt("width"));
        r22.setHeight(r7.optInt("height"));
        r22.setBackground(r7.optString("background"));
        r4.setCanvas(r22);
    L52:
        return r4;
    L42:
        r4 = r8;
        r4.setGrids(r13);     // Catch: Exception -> L44
    L46:
        e = e;
        r4 = r8;
        goto L48
    }
}
