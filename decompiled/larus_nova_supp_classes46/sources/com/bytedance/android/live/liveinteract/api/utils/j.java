package com.bytedance.android.live.liveinteract.api.utils;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.y4;
import com.bytedance.android.livesdk.config.b60;
import com.bytedance.android.livesdkapi.model.AnchorInteractInfo;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiCanvas;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.android.livesdkapi.model.StreamSize;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.MultiLinkBaseDegradeConfig;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.backupsei.MultiLinkBizBackupSeiExperimentUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class j implements md0.a {
    public long a;
    public long b;
    public final md0.a.InterfaceC0236a c;
    public final md0.a.b d;
    public final md0.a.c e;

    public j(md0.a.InterfaceC0236a r3) {
        this.a = 0;
        this.b = 0;
        this.c = r3;
    }

    public final boolean c(JSONObject r6) {
        List<String> r0 = LiveSeiUtil.a;
        int r2 = 0;
    L4:
        if (r2 >= r0.size()) goto L9;
        if (r6.has((String) ListProtector.get(r0, r2)) == true) goto L7;
        r2 = r2 + 1;
        goto L4
    L7:
        boolean r7 = true;
    L11:
        if (this.d == null) goto L17;
        if (r7 == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L9:
        r7 = false;
        goto L11
    }

    public final void d(String r12) {
        e(r12, new ye1.a(false, "", 0, 0, 0, null));
    }

    public j(md0.a.InterfaceC0236a r1, md0.a.c r2) {
        this(r1);
        this.e = r2;
    }

    public static SeiAppData a(JSONObject r22, String r23) throws JSONException {
        String r3 = "loading";
        String r4 = "talk_volume";
        SeiAppData r10 = new SeiAppData();
        r10.setTimestamp(r22.optLong("timestamp"));
        r10.setVersion(r22.optInt("ver"));
        r10.setUiLayout(r22.optInt("ui_layout"));
        r10.setStyle(r22.optInt("style"));
        r10.setPositionStashStatus(r22.optInt("position_stash_status"));
        r10.setVendor(r22.optString("vendor"));
        r10.setChannelId(r22.optString("channel_id"));
        r10.setSubScene(r22.optInt("sub_scene"));
        r10.setGameType(r22.optInt("game_type"));
        r10.setGameFull(r22.optInt("game_full"));
        r10.setGameFullV2(r22.optInt("game_full_v2"));
        r10.setGameMixStreamType(r22.optInt("mix_stream_type"));
        r10.setLayoutKey(r22.optString("layout_key"));
        String r11 = r22.optString("grids");
        r10.setCount(r22.optLong("count", 0));
        r10.setEventParams(r22.optJSONObject("event_params"));
        r10.setShowPlayer(r22.optString("show_player"));
        r10.setHideAudioBg(r22.optInt("hide_audio_bg"));
        if (r22.has("play_mode_list") == false) goto L5;
        r10.setPlayMode(r22.optString("play_mode_list"));
    L5:
        r10.setSubUILayout(r22.optInt("sub_ui_layout"));
        r10.setHideMicseat(r22.optInt("hide_micseat"));
        if (r22.has("ui_feature_list") == false) goto L63;
        r10.setUiFeatureList(r22.optJSONArray("ui_feature_list"));
    L63:
        JSONObject r12 = r22.optJSONObject("anchor_interact_info");     // Catch: Exception -> L55
        if (r12 == null) goto L11;
        AnchorInteractInfo r13 = new AnchorInteractInfo();     // Catch: Exception -> L55
        r13.setFocusID(r12.optString("focus_id"));     // Catch: Exception -> L55
        r13.setLayoutType(r12.optInt("layout_type"));     // Catch: Exception -> L55
        r13.setOwnerIndex(r12.optInt("owner_index"));     // Catch: Exception -> L55
        r10.setAnchorInteractInfo(r13);     // Catch: Exception -> L55
    L11:
        JSONObject r14 = r22.optJSONObject("stream_size");     // Catch: Exception -> L55
        String r1 = "h";
        if (r14 == null) goto L16;
        StreamSize r2 = new StreamSize();     // Catch: Exception -> L55
        r2.setH(r14.optDouble("h"));     // Catch: Exception -> L55
        r2.setW(r14.optDouble("w"));     // Catch: Exception -> L55
        r2.setX(r14.optDouble("x"));     // Catch: Exception -> L55
        r2.setY(r14.optDouble("y"));     // Catch: Exception -> L55
        r2.setGameRatio(r14.optDouble("game_ratio"));     // Catch: Exception -> L55
        r10.setStreamSize(r2);     // Catch: Exception -> L55
    L16:
        JSONArray r5 = new JSONArray(r11);     // Catch: Exception -> L55
        int r6 = r5.length();     // Catch: Exception -> L55
        ArrayList r7 = new ArrayList();     // Catch: Exception -> L55
        int r15 = 0;
    L17:
        if (r15 >= r6) goto L53;
        JSONObject r16 = (JSONObject) r5.opt(r15);     // Catch: Exception -> L55
        JSONArray r18 = r5;
        int r19 = r6;
        ArrayList r20 = r7;
        SeiRegion r8 = new SeiRegion().setType(r16.optInt("type")).setX(r16.optDouble("x")).setY(r16.optDouble("y")).setWidth(r16.optDouble("w")).setHeight(r16.optDouble(r1));     // Catch: Exception -> L55
        r8.setAccount(r16.optLong("account"));     // Catch: Exception -> L55
        if (r16.has("p") == false) goto L22;
        r8.setPosition(r16.optInt("p"));     // Catch: Exception -> L55
    L22:
        if (r16.has("uid") == false) goto L25;
        r8.setUid(r16.optInt("uid"));     // Catch: Exception -> L55
    L25:
        if (r16.has("uid_str") == false) goto L28;
        r8.setUidStr(r16.optString("uid_str"));     // Catch: Exception -> L55
    L28:
        if (r16.has("talk") == false) goto L31;
        r8.setTalk(r16.optInt("talk"));     // Catch: Exception -> L55
    L31:
        if (r16.has("mute_audio") == false) goto L33;
        r8.setMuteAudio(r16.optInt("mute_audio"));     // Catch: Exception -> L55
    L33:
        String r9 = r4;
        if (r16.has(r9) == false) goto L36;
        r8.setTalkVolume(r16.optInt(r9));     // Catch: Exception -> L55
    L36:
        String r17 = r3;
        String r110 = r1;
        if (r16.has(r17) == false) goto L45;
        if (r16.optInt(r17) != 1) goto L41;
        boolean r21 = true;
    L42:
        r8.setIsLocal(r21);     // Catch: Exception -> L55
        goto L45
    L41:
        r21 = false;
    L45:
        if (r16.has("visible") == true) goto L47;
        r8.setVisible(true);     // Catch: Exception -> L55
    L52:
        r8.setStatus(r16.optInt("stat"));     // Catch: Exception -> L55
        r20.add(r8);     // Catch: Exception -> L55
        r15 = r15 + 1;     // Catch: Exception -> L55
        r3 = r17;
        r5 = r18;
        r6 = r19;
        r7 = r20;
        r1 = r110;
        r4 = r9;
        goto L17
    L47:
        if (r16.optInt("visible") != 1) goto L49;
        boolean r24 = true;
    L50:
        r8.setVisible(r24);     // Catch: Exception -> L55
        goto L52
    L49:
        r24 = false;
        goto L50
    L53:
        r10.setGrids(r7);     // Catch: Exception -> L55
    L59:
        JSONObject r0 = r22.optJSONObject("canvas");
        if (r0 == null) goto L62;
        SeiCanvas r25 = new SeiCanvas();
        r25.setWidth(r0.optInt("width"));
        r25.setHeight(r0.optInt("height"));
        r25.setBackground(r0.optString("background"));
        r10.setCanvas(r25);
    L62:
        return r10;
    L55:
        e = move-exception;
        ALogger.e("LiveSeiHelper", e);
        if (r23 == null) goto L59;
        ALogger.e("LiveSeiHelper", "createSei crashed with ".concat(r23));
        goto L59
    }

    public final void e(String r14, ye1.a r15) {
        LiveSeiUtil.i.getClass();
        if (LiveSeiUtil.b(r14) == false) goto L79;
        long r5 = ((MultiLinkBaseDegradeConfig) b60.a.getValue()).getSeiConsumeDebounceTime();
        if (r5 > 0) goto L7;
    L10:
        boolean r6 = true;
    L11:
        if (r6 == false) goto L80;
        JSONObject r7 = LiveSeiUtil.c(r14);     // Catch: JSONException -> L75
        if (r7.has("info") == false) goto L21;
        if (r7.has("source") == false) goto L21;
        if (TextUtils.equals(r7.optString("source"), "zego") == false) goto L21;
        r7 = (JSONObject) r7.get("info");     // Catch: JSONException -> L75
    L21:
        if (r7.has("audio_subtitle") == false) goto L26;
        md0.a.c r4 = this.e;     // Catch: JSONException -> L75
        if (r4 == null) goto L26;
        r4.onAudioSubtitleUpdate(r14);     // Catch: JSONException -> L75
    L26:
        if (r7.has("audio_live_text_data") == false) goto L31;
        md0.a.c r8 = this.e;     // Catch: JSONException -> L75
        if (r8 == null) goto L31;
        r8.onRadioTextSeiUpdate(r7);     // Catch: JSONException -> L75
    L31:
        if (r7.has("radio_sei") == false) goto L35;
        md0.a.c r9 = this.e;     // Catch: JSONException -> L75
        if (r9 == null) goto L35;
        r9.onRadioSeiUpdate(r7);     // Catch: JSONException -> L75
    L35:
        b(r14, r7, r15);     // Catch: JSONException -> L75
        if (r7.has("app_data") == false) goto L61;
        JSONObject r2 = new JSONObject(JSONObjectProtectorUtils.getString(r7, "app_data").replaceAll("\\\\", ""));     // Catch: JSONException -> L75
        md0.a.InterfaceC0236a r16 = this.c;     // Catch: JSONException -> L75
        if (r16 == null) goto L40;
        r16.onBusinessAppSeiUpdate(r2);     // Catch: JSONException -> L75
    L40:
        long r3 = r2.optLong("timestamp");     // Catch: JSONException -> L75
        long r10 = this.a;     // Catch: JSONException -> L75
        if (r3 > r10) goto L52;
        if (r3 == r10) goto L44;
        return;
    L44:
        if (c(r7) == true) goto L46;
        return;
    L46:
        if (((Boolean) y4.a.getValue()).booleanValue() == true) goto L48;
        return;
    L48:
        if (c(r7) == false) goto L81;
        this.d.onKtvSeiUpdate(r14);     // Catch: JSONException -> L75
        return;
    L81:
        return;
    L52:
        if (r2.has("ver") == true) goto L54;
        return;
    L54:
        int r17 = r2.optInt("ver");     // Catch: JSONException -> L75
        int r1 = r2.optInt("ui_layout", 0);     // Catch: JSONException -> L75
        if (r2.has("style") == false) goto L58;
        r2.optInt("style");     // Catch: JSONException -> L75
    L58:
        if (this.c.isVersionSupported(r17, r1) == false) goto L83;
        this.a = r3;     // Catch: JSONException -> L75
        this.c.onSeiUpdated(a(r2, r14));     // Catch: JSONException -> L75
        return;
    L83:
        return;
    L61:
        if (TextUtils.equals(r7.optString("source"), "TTLiveSDK_Android") == true) goto L69;
        if (TextUtils.equals(r7.optString("source"), "TTLiveSDK_IOS") == true) goto L69;
        if (LiveSeiUtil.d(r7.optString("source")) == true) goto L69;
        if (TextUtils.equals(r7.optString("source"), "TTLiveSDK_Windows") == true) goto L69;
        return;
    L69:
        if (r7.has("stream_type") == true) goto L71;
    L73:
        this.c.isVersionSupported(0, 0);     // Catch: JSONException -> L75
        return;
    L71:
        if (JSONObjectProtectorUtils.getInt(r7, "stream_type") != 1) goto L73;
        this.c.isVersionSupported(-1, 0);     // Catch: JSONException -> L75
        return;
    L87:
        return;
    L80:
        return;
    L7:
        if ((System.currentTimeMillis() - this.b) >= r5) goto L9;
        r6 = false;
        goto L11
    L9:
        this.b = System.currentTimeMillis();
        goto L10
    }

    public j(md0.a.InterfaceC0236a r1, md0.a.b r2, md0.a.c r3) {
        this(r1);
        this.d = r2;
        this.e = r3;
    }

    public final void b(String r3, JSONObject r4, ye1.a r5) throws JSONException {
        if (r5 == null) goto L8;
        if (r5.a == false) goto L8;
        if (MultiLinkBizBackupSeiExperimentUtils.INSTANCE.isKtvAllInEnable(r5.g, false) == true) goto L8;
        return;
    L8:
        if (r4.has("music_recognition_result") == false) goto L13;
        md0.a.c r6 = this.e;
        if (r6 == null) goto L13;
        r6.onSpeechRecognitionSeiUpdate(r3);
    L13:
        if (r4.has("audio_mv_sei") == false) goto L18;
        md0.a.c r7 = this.e;
        if (r7 == null) goto L18;
        r7.onAudioMvControllerUpdate(r3);
    L18:
        if (r4.has("music_beat_result") == false) goto L23;
        md0.a.c r8 = this.e;
        if (r8 == null) goto L23;
        r8.onSpeechRhythm(r3);
    L23:
        if (r4.has("interact_video_sei") == false) goto L28;
        if (this.e == null) goto L28;
        LiveSeiUtil.i.getClass();
        ld0.a r9 = ld0.a.a(r3, "interact_video_sei", LiveSeiUtil.c(r3));
        this.e.onVideoStateSeiUpdate(r9);
    L28:
        if (r4.has("interact_full_video_sei") == false) goto L33;
        if (this.e == null) goto L33;
        LiveSeiUtil.i.getClass();
        ld0.a r10 = ld0.a.a(r3, "interact_full_video_sei", LiveSeiUtil.c(r3));
        this.e.onVideoStateSeiUpdate(r10);
    L33:
        if (c(r4) == false) goto L37;
        this.d.onKtvSeiUpdate(r3);
        return;
    }
}
