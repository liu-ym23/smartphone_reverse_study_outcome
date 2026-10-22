package e92;

import com.bytedance.android.livesdkapi.model.AnchorInteractInfo;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiCanvas;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c {
    public long a;
    public final b b;

    public c(b r3) {
        this.a = 0;
        this.b = r3;
    }

    public static SeiAppData a(JSONObject r18) throws JSONException {
        SeiAppData r8 = new SeiAppData();
        r8.setTimestamp(r18.optLong("timestamp"));
        r8.setVersion(r18.optInt("ver"));
        r8.setStyle(r18.optInt("style"));
        r8.setVendor(r18.optString("vendor"));
        r8.setChannelId(r18.optString("channel_id"));
        r8.setSubScene(r18.optInt("sub_scene"));
        String r9 = r18.optString("grids");
        r8.setCount(r18.optLong("count", 0));
        r8.setEventParams(r18.optJSONObject("event_params"));
        JSONObject r10 = r18.optJSONObject("anchor_interact_info");     // Catch: Exception -> L36
        if (r10 == null) goto L6;
        AnchorInteractInfo r11 = new AnchorInteractInfo();     // Catch: Exception -> L36
        r11.setFocusID(r10.optString("focus_id"));     // Catch: Exception -> L36
        r11.setLayoutType(r10.optInt("layout_type"));     // Catch: Exception -> L36
        r11.setOwnerIndex(r10.optInt("owner_index"));     // Catch: Exception -> L36
        r8.setAnchorInteractInfo(r11);     // Catch: Exception -> L36
    L6:
        JSONArray r13 = new JSONArray(r9);     // Catch: Exception -> L36
        int r14 = r13.length();     // Catch: Exception -> L36
        ArrayList r15 = new ArrayList();     // Catch: Exception -> L36
        int r16 = 0;
    L7:
        if (r16 >= r14) goto L34;
        JSONObject r17 = (JSONObject) r13.opt(r16);     // Catch: Exception -> L36
        int r19 = r14;
        JSONArray r110 = r13;
        int r111 = r16;
        SeiRegion r20 = new SeiRegion().setType(r17.optInt("type")).setX(r17.optDouble(sz1.a.KEY_X)).setY(r17.optDouble(sz1.a.KEY_Y)).setWidth(r17.optDouble("w")).setHeight(r17.optDouble("h"));     // Catch: Exception -> L36
        r20.setAccount(r17.optLong("account"));     // Catch: Exception -> L36
        if (r17.has("p") == false) goto L12;
        r20.setPosition(r17.optInt("p"));     // Catch: Exception -> L36
    L12:
        if (r17.has("uid") == false) goto L15;
        r20.setUid(r17.optInt("uid"));     // Catch: Exception -> L36
    L15:
        if (r17.has("uid_str") == false) goto L18;
        r20.setUidStr(r17.optString("uid_str"));     // Catch: Exception -> L36
    L18:
        if (r17.has("talk") == false) goto L21;
        r20.setTalk(r17.optInt("talk"));     // Catch: Exception -> L36
    L21:
        if (r17.has("mute_audio") == false) goto L24;
        r20.setMuteAudio(r17.optInt("mute_audio"));     // Catch: Exception -> L36
    L24:
        if (r17.has("talk_volume") == false) goto L27;
        r20.setTalkVolume(r17.optInt("talk_volume"));     // Catch: Exception -> L36
    L27:
        if (r17.has("loading") == false) goto L33;
        boolean r112 = true;
        if (r17.optInt("loading") == 1) goto L32;
        r112 = false;
    L32:
        r20.setIsLocal(r112);     // Catch: Exception -> L36
    L33:
        r20.setStatus(r17.optInt("stat"));     // Catch: Exception -> L36
        r15.add(r20);     // Catch: Exception -> L36
        r16 = r111 + 1;     // Catch: Exception -> L36
        r13 = r110;
        r14 = r19;
        goto L7
    L34:
        r8.setGrids(r15);     // Catch: Exception -> L36
    L38:
        JSONObject r0 = r18.optJSONObject("canvas");
        if (r0 == null) goto L41;
        SeiCanvas r1 = new SeiCanvas();
        r1.setWidth(r0.optInt(sz1.a.KEY_WIDTH));
        r1.setHeight(r0.optInt(sz1.a.KEY_HEIGHT));
        r1.setBackground(r0.optString("background"));
        r8.setCanvas(r1);
    L41:
        return r8;
    L36:
        e = move-exception;
        e.printStackTrace();
        goto L38
    }
}
