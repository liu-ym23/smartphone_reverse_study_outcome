package com.bytedance.android.live.revlink.impl.pk.utils;

import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.android.livesdk.model.RevStreamSize;
import com.bytedance.android.livesdk.model.m0;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdk.model.q0;
import com.bytedance.badger.collect.impl.constants.Constants;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class s {
    public static final /* synthetic */ int c = 0;
    public long a;
    public final g b;

    public static final class a {
        public static p0 a(JSONObject r19, String r20) {
            String r0 = "loading";
            String r2 = "talk_volume";
            String r3 = "mute_audio";
            Intrinsics.checkNotNullParameter(r19, "appData");
            p0 r8 = new p0();
            r8.A(r19.optLong("timestamp"));
            r8.D(r19.optInt("ver"));
            r8.y(r19.optInt("style"));
            r8.C(r19.optString(Constants.OperatorKey.KEY_VENDOR));
            r8.l(r19.optString("channel_id"));
            r8.u(r19.optString("layout_key"));
            r8.z(r19.optInt("sub_scene"));
            r8.r(r19.optInt("game_type"));
            r8.o(r19.optInt("game_full"));
            r8.p(r19.optInt("game_full_v2"));
            r8.q(r19.optInt("mix_stream_type"));
            String r10 = r19.optString("grids");
            r8.m(r19.optLong("count", 0));
            r8.n(r19.optJSONObject("event_params"));
            JSONObject r12 = r19.optJSONObject("anchor_interact_info");     // Catch: Exception -> L55
            if (r12 == null) goto L6;
            m0 r13 = new m0();     // Catch: Exception -> L55
            r13.h(r12.optString("focus_id"));     // Catch: Exception -> L55
            r13.j(r12.optInt("layout_type"));     // Catch: Exception -> L55
            r13.l(r12.optInt("owner_index"));     // Catch: Exception -> L55
            r8.j(r13);     // Catch: Exception -> L55
        L6:
            JSONObject r14 = r19.optJSONObject("stream_size");     // Catch: Exception -> L55
            if (r14 == null) goto L12;
            RevStreamSize r1 = new RevStreamSize();     // Catch: Exception -> L55
            r1.setH(r14.optDouble("h"));     // Catch: Exception -> L55
            r1.setW(r14.optDouble("w"));     // Catch: Exception -> L55
            r1.setX(r14.optDouble("x"));     // Catch: Exception -> L55
            r1.setY(r14.optDouble("y"));     // Catch: Exception -> L55
            r1.setGameRatio(r14.optDouble("game_ratio"));     // Catch: Exception -> L55
            r8.x(r1);     // Catch: Exception -> L55
        L12:
            JSONArray r4 = r19.optJSONArray("grids");     // Catch: Exception -> L55
            if (z41.d.c.a9() == false) goto L16;
            if (r4 == null) goto L16;
        L17:
            int r5 = r4.length();     // Catch: Exception -> L55
            ArrayList r6 = new ArrayList();     // Catch: Exception -> L55
            int r9 = 0;
        L18:
            if (r9 >= r5) goto L53;
            Object r15 = r4.opt(r9);     // Catch: Exception -> L55
            if (r15 == null) goto L52;
            JSONObject r16 = (JSONObject) r15;     // Catch: Exception -> L55
            RevSeiRegion r17 = new RevSeiRegion();     // Catch: Exception -> L55
            JSONArray r18 = r4;
            r17.setType(r16.optInt("type"));     // Catch: Exception -> L55
            r17.setX(r16.optDouble("x"));     // Catch: Exception -> L55
            r17.setY(r16.optDouble("y"));     // Catch: Exception -> L55
            r17.setWidth(r16.optDouble("w"));     // Catch: Exception -> L55
            r17.setHeight(r16.optDouble("h"));     // Catch: Exception -> L55
            r17.setAccount(String.valueOf(r16.optLong("account")));     // Catch: Throwable -> L61
        L24:
            if (r16.has("p") == false) goto L27;
            r17.setPosition(r16.optInt("p"));     // Catch: Exception -> L55
        L27:
            if (r16.has("uid") == false) goto L30;
            r17.setUid(r16.optInt("uid"));     // Catch: Exception -> L55
        L30:
            if (r16.has("uid_str") == false) goto L33;
            r17.setUidStr(r16.optString("uid_str"));     // Catch: Exception -> L55
        L33:
            if (r16.has("talk") == false) goto L35;
            r17.setTalk(r16.optInt("talk"));     // Catch: Exception -> L55
        L35:
            r3 = r3;
            if (r16.has(r3) == false) goto L38;
            r17.setMuteAudio(r16.optInt(r3));     // Catch: Exception -> L55
        L38:
            r2 = r2;
            if (r16.has(r2) == false) goto L42;
            r17.setTalkVolume(r16.optInt(r2));     // Catch: Exception -> L55
        L42:
            r0 = r0;
            if (r16.has(r0) == false) goto L50;
            int r7 = r16.optInt(r0);     // Catch: Exception -> L55
            boolean r22 = true;
            if (r7 == 1) goto L48;
            r22 = false;
        L48:
            r17.setLocal(r22);     // Catch: Exception -> L55
        L50:
            r17.setStatus(r16.optInt("stat"));     // Catch: Exception -> L55
            r6.add(r17);     // Catch: Exception -> L55
            r9 = r9 + 1;     // Catch: Exception -> L55
            r4 = r18;
            goto L18
        L52:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.revenue.platform.api.core.JSONObject /* = org.json.JSONObject */");     // Catch: Exception -> L55
        L53:
            r8.s(r6);     // Catch: Exception -> L55
        L57:
            JSONObject r23 = r19.optJSONObject("canvas");
            if (r23 == null) goto L60;
            q0 r24 = new q0();
            r24.e(r23.optInt("width"));
            r24.d(r23.optInt("height"));
            r24.c(r23.optString("background"));
            r8.k(r24);
        L60:
            return r8;
        L16:
            r4 = new JSONArray(r10);     // Catch: Exception -> L55
        L55:
            e = move-exception;
            e.printStackTrace();
            goto L57
        }
    }

    static {
    }

    public s(g r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.b = r2;
    }
}
