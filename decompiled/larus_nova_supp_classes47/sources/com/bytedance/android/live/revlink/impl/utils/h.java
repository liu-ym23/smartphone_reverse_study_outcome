package com.bytedance.android.live.revlink.impl.utils;

import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.livesdk.model.AlignModeType;
import com.bytedance.android.livesdk.model.RenderViewScaleType;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.android.livesdk.model.RevStreamSize;
import com.bytedance.android.livesdk.model.m0;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdk.model.q0;
import com.bytedance.android.livesdk.model.r0;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class h {
    static {
    }

    public static p0 a(JSONObject r13) {
        Intrinsics.checkNotNullParameter(r13, "appData");
        p0 r1 = new p0();
        r1.A(r13.optLong("timestamp"));     // Catch: Throwable -> L54
        r1.D(r13.optInt("ver"));     // Catch: Throwable -> L54
        r1.B(r13.optInt("ui_layout"));     // Catch: Throwable -> L54
        r1.y(r13.optInt("style"));     // Catch: Throwable -> L54
        r1.C(r13.optString(Constants.OperatorKey.KEY_VENDOR));     // Catch: Throwable -> L54
        r1.l(r13.optString("channel_id"));     // Catch: Throwable -> L54
        r1.u(r13.optString("layout_key"));     // Catch: Throwable -> L54
        r1.z(r13.optInt("sub_scene"));     // Catch: Throwable -> L54
        r1.r(r13.optInt("game_type"));     // Catch: Throwable -> L54
        r1.o(r13.optInt("game_full"));     // Catch: Throwable -> L54
        r1.p(r13.optInt("game_full_v2"));     // Catch: Throwable -> L54
        r1.q(r13.optInt("mix_stream_type"));     // Catch: Throwable -> L54
        String r2 = r13.optString("grids");     // Catch: Throwable -> L54
        int r4 = 0;
        long r5 = 0;
        r5 = r13.optLong("count", r5);     // Catch: Throwable -> L7
    L9:
        r1.m(r5);     // Catch: Throwable -> L54
        r1.t((float) r13.optDouble("landscape_ratio"));     // Catch: Throwable -> L54
        r1.w((float) r13.optDouble("portrait_ratio"));     // Catch: Throwable -> L54
        r1.n(r13.optJSONObject("event_params"));     // Catch: Throwable -> L54
        JSONObject r3 = r13.optJSONObject("anchor_interact_info");     // Catch: Throwable -> L54
        if (r3 == null) goto L23;
        m0 r9 = new m0();     // Catch: Throwable -> L54
        r9.h(r3.optString("focus_id"));     // Catch: Throwable -> L54
        r9.j(r3.optInt("layout_type"));     // Catch: Throwable -> L54
        r9.l(r3.optInt("owner_index"));     // Catch: Throwable -> L54
        r9.k(r3.optInt("mix_owner_index"));     // Catch: Throwable -> L54
        r9.i(r3.optInt("is_horizontal"));     // Catch: Throwable -> L54
        int r10 = r9.c();     // Catch: Throwable -> L54
        UILayout r12 = UILayout.FULL;     // Catch: Throwable -> L54
        if (r10 != r12.ordinal()) goto L15;
        RenderViewScaleType r14 = RenderViewScaleType.HEIGHT_ALIGN;     // Catch: Throwable -> L54
    L16:
        r9.m(r14.getValue());     // Catch: Throwable -> L54
        if (r9.c() != r12.ordinal()) goto L19;
        AlignModeType r15 = AlignModeType.RIGHT_ALIGN;     // Catch: Throwable -> L54
    L20:
        r9.f(r15.getValue());     // Catch: Throwable -> L54
        r1.j(r9);     // Catch: Throwable -> L54
        JSONObject r6 = r3.optJSONObject("content");     // Catch: Throwable -> L54
        if (r6 == null) goto L23;
        r0 r16 = new r0();     // Catch: Throwable -> L54
        r16.g(r6.optDouble("x"));     // Catch: Throwable -> L54
        r16.h(r6.optDouble("y"));     // Catch: Throwable -> L54
        r16.f(r6.optDouble("w"));     // Catch: Throwable -> L54
        r16.e(r6.optDouble("h"));     // Catch: Throwable -> L54
        r9.g(r16);     // Catch: Throwable -> L54
        goto L23
    L19:
        r15 = AlignModeType.HORIZONTAL_CENTER_ALIGN;     // Catch: Throwable -> L54
        goto L20
    L15:
        r14 = RenderViewScaleType.WIDTH_ALIGN;     // Catch: Throwable -> L54
    L23:
        JSONObject r7 = r13.optJSONObject("stream_size");     // Catch: Throwable -> L54
        if (r7 == null) goto L26;
        RevStreamSize r17 = new RevStreamSize();     // Catch: Throwable -> L54
        r17.setH(r7.optDouble("h"));     // Catch: Throwable -> L54
        r17.setW(r7.optDouble("w"));     // Catch: Throwable -> L54
        r17.setX(r7.optDouble("x"));     // Catch: Throwable -> L54
        r17.setY(r7.optDouble("y"));     // Catch: Throwable -> L54
        r17.setGameRatio(r7.optDouble("game_ratio"));     // Catch: Throwable -> L54
        r1.x(r17);     // Catch: Throwable -> L54
    L26:
        JSONArray r8 = new JSONArray(r2);     // Catch: Throwable -> L54
        int r18 = r8.length();     // Catch: Throwable -> L54
        ArrayList r19 = new ArrayList();     // Catch: Throwable -> L54
        int r20 = 0;
    L29:
        if (r20 >= r18) goto L35;
        Object r22 = r8.opt(r20);     // Catch: Throwable -> L54
        if (r22 == null) goto L34;
        r19.add(b((JSONObject) r22, false));     // Catch: Throwable -> L54
        r20 = r20 + 1;     // Catch: Throwable -> L54
        goto L29
    L34:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.revenue.platform.api.core.JSONObject /* = org.json.JSONObject */");     // Catch: Throwable -> L54
    L35:
        r1.s(r19);     // Catch: Throwable -> L54
        if (z41.g.o.b() == true) goto L38;
    L50:
        JSONObject r110 = r13.optJSONObject("canvas");     // Catch: Throwable -> L54
        if (r110 == null) goto L56;
        q0 r0 = new q0();     // Catch: Throwable -> L54
        r0.e(r110.optInt("width"));     // Catch: Throwable -> L54
        r0.d(r110.optInt("height"));     // Catch: Throwable -> L54
        r0.c(r110.optString("background"));     // Catch: Throwable -> L54
        r1.k(r0);     // Catch: Throwable -> L54
    L56:
        return r1;
    L38:
        if (r13.has("mix_grids") == false) goto L50;
        JSONArray r23 = new JSONArray(r13.optString("mix_grids"));     // Catch: Throwable -> L48
        int r24 = r23.length();     // Catch: Throwable -> L48
        ArrayList r25 = new ArrayList();     // Catch: Throwable -> L48
    L40:
        if (r4 >= r24) goto L46;
        Object r26 = r23.opt(r4);     // Catch: Throwable -> L48
        if (r26 == null) goto L45;
        r25.add(b((JSONObject) r26, true));     // Catch: Throwable -> L48
        r4 = r4 + 1;     // Catch: Throwable -> L48
        goto L40
    L45:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.revenue.platform.api.core.JSONObject /* = org.json.JSONObject */");     // Catch: Throwable -> L48
    L46:
        r1.v(r25);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L54
        goto L50
    L7:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        th.printStackTrace();
        goto L56
    }

    public static RevSeiRegion b(JSONObject r3, boolean r4) {
        RevSeiRegion r0 = new RevSeiRegion();
        r0.setType(r3.optInt("type"));
        r0.setX(r3.optDouble("x"));
        r0.setY(r3.optDouble("y"));
        r0.setWidth(r3.optDouble("w"));
        r0.setHeight(r3.optDouble("h"));
        r0.setAccount(String.valueOf(r3.optLong("account")));     // Catch: Throwable -> L5
    L7:
        if (r3.has("p") == false) goto L10;
        r0.setPosition(r3.optInt("p"));
    L10:
        if (r3.has("uid") == false) goto L13;
        r0.setUid(r3.optInt("uid"));
    L13:
        if (r3.has("uid_str") == false) goto L16;
        r0.setUidStr(r3.optString("uid_str"));
    L16:
        if (r3.has("talk") == false) goto L19;
        r0.setTalk(r3.optInt("talk"));
    L19:
        if (r3.has("mute_audio") == false) goto L22;
        r0.setMuteAudio(r3.optInt("mute_audio"));
    L22:
        if (r3.has("talk_volume") == false) goto L25;
        r0.setTalkVolume(r3.optInt("talk_volume"));
    L25:
        if (r3.has("loading") == false) goto L31;
        boolean r2 = true;
        if (r3.optInt("loading") == 1) goto L30;
        r2 = false;
    L30:
        r0.setLocal(r2);
    L31:
        r0.setStatus(r3.optInt("stat"));
        if (r4 == false) goto L34;
        r0.setWindowType(r3.optInt("w_type"));
    L34:
        return r0;
    }
}
