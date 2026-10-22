package com.bytedance.android.live.openplatform.impl.minigameanchor.cloudgame;

import android.graphics.Rect;
import android.graphics.RectF;
import com.bytedance.android.live.broadcastgame.api.xplay.r;
import com.bytedance.android.live.liveinteract.api.utils.g;
import com.bytedance.android.live.openplatform.api.minigame.datacontext.AnchorMiniGameDataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.livelink.kmp.api.base.config.Vendor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ti6.f;
import ti6.h;
import ti6.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class d implements j {
    public boolean a;
    public final fi6.a b;
    public final r c;
    public final Pair<Integer, Integer> d;
    public final Rect e;

    public static final class a {
    }

    static {
    }

    public final /* synthetic */ boolean b(aj6.d r1, aj6.b r2) {
        ti6.a.a(r1, r2);
        return false;
    }

    public final String a(int r16, int r17, List<f> r18) {
        Intrinsics.checkNotNullParameter(r18, "mixRegions");
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r2 = AnchorMiniGameDataContext.a.a();
        if (r2 == null) goto L69;
        m<Rect> r3 = r2.getLittleWindowRect();
        if (r3 == null) goto L84;
        Rect r4 = (Rect) r3.getValue();
        if (r4 == null) goto L85;
        int r5 = this.e.width();
        int r6 = this.e.height();
        float r7 = r5;
        float r9 = r6;
        RectF r8 = new RectF(r4.left / r7, r4.top / r9, r4.right / r7, r4.bottom / r9);
        int r10 = qo0.a.a;
        StringBuilder r11 = new StringBuilder("mix stream, windowRect = ");
        r11.append(r4);
        r11.append(", normalRect = ");
        r11.append(r8);
        r11.append(", screenW = ");
        r11.append(r5);
        r11.append(", screenH = ");
        r11.append(r6);
        r11.append(", openCamera = ");
        AnchorMiniGameDataContext r12 = AnchorMiniGameDataContext.a.a();
        if (r12 == null) goto L14;
        m<Boolean> r13 = r12.getOpenCamera();
        if (r13 == null) goto L14;
        Boolean r14 = (Boolean) r13.getValue();
    L15:
        r11.append(r14);
        String r15 = "XplayStreamMixer";
        qo0.a.c("XplayStreamMixer", r11.toString());
        List r19 = CollectionsKt.toMutableList(r18);
        if (r19 == null) goto L41;
        Iterator r20 = r19.iterator();
    L19:
        if (r20.hasNext() == false) goto L41;
        f r21 = (f) r20.next();
        String r110 = r21.b;
        r r111 = this.c;
        if (r111 == null) goto L23;
        String r112 = r111.i;
    L25:
        if (Intrinsics.areEqual(r110, r112) == true) goto L27;
        r21.o = 0;
        r21.s = 2;
    L40:
        r15 = r15;
        goto L19
    L27:
        if (this.a == false) goto L38;
        AnchorMiniGameDataContext.Companion.getClass();
        AnchorMiniGameDataContext r113 = AnchorMiniGameDataContext.a.a();
        if (r113 == null) goto L33;
        m<Boolean> r114 = r113.getOpenCamera();
        if (r114 == null) goto L33;
        Boolean r115 = (Boolean) r114.getValue();
    L35:
        if (Intrinsics.areEqual(r115, Boolean.FALSE) == false) goto L37;
        r21.a = 1;
        r21.f = 0.0d;
        r21.g = 0.0d;
        r21.d = 0.0d;
        r21.e = 0.0d;
        r21.l = true;
        r21.o = 1;
        goto L40
    L37:
        r21.a = 1;
        float r116 = r8.right;
        float r117 = r8.left;
        double r118 = r116 - r117;
        float r119 = r8.bottom;
        float r120 = r8.top;
        r21.f = r118;
        r21.g = r119 - r120;
        r21.d = r117;
        r21.e = r120;
        r21.l = true;
        r21.o = 1;
    L33:
        r115 = null;
        goto L35
    L38:
        r21.a = 1;
        r21.f = 1.0d;
        r21.g = 1.0d;
        r21.d = 0.0d;
        r21.e = 0.0d;
        r21.o = 1;
        goto L40
    L23:
        r112 = null;
    L41:
        String r121 = r15;
        r18.clear();
        if (r19 == null) goto L44;
        List r22 = r19;
    L45:
        r18.addAll(r22);
        fi6.a r23 = this.b;
        Pair<Integer, Integer> r24 = this.d;
        JSONObject r25 = new JSONObject();     // Catch: JSONException -> L66
        r25.put("ver", r23.d);     // Catch: JSONException -> L66
        r25.put("vendor", Vendor.BYTE.getValue());     // Catch: JSONException -> L66
        r25.put("timestamp", System.currentTimeMillis());     // Catch: JSONException -> L66
        r25.put("channel_id", String.valueOf(0));     // Catch: JSONException -> L66
        JSONArray r26 = new JSONArray();     // Catch: JSONException -> L66
        Iterator<f> r1 = r18.iterator();     // Catch: JSONException -> L66
    L48:
        if (r1.hasNext() == false) goto L61;
        f r27 = r1.next();     // Catch: JSONException -> L66
        if (r27.l == false) goto L48;
        JSONObject r28 = new JSONObject();     // Catch: JSONException -> L66
        r28.put("type", r27.a);     // Catch: JSONException -> L66
        r28.put("alpha", 1);     // Catch: JSONException -> L66
        r28.put("w", r27.f);     // Catch: JSONException -> L66
        r28.put("h", r27.g);     // Catch: JSONException -> L66
        r28.put("x", r27.d);     // Catch: JSONException -> L66
        r28.put("y", r27.e);     // Catch: JSONException -> L66
        r28.put("account", 0);     // Catch: JSONException -> L66
        r28.put("uid", 0);     // Catch: JSONException -> L66
        r28.put("uid_str", r27.b);     // Catch: JSONException -> L66
        r28.put("zorder", r27.o);     // Catch: JSONException -> L66
        r28.put("render_mode", r27.s);     // Catch: JSONException -> L66
        r28.put("stat", r27.i);     // Catch: JSONException -> L66
        if (r27.j == false) goto L55;
        int r122 = 1;
    L56:
        r28.put("talk", r122);     // Catch: JSONException -> L66
        if (r27.m == false) goto L59;
        int r29 = 1;
    L60:
        r28.put("mute_audio", r29);     // Catch: JSONException -> L66
        r26.put(r28);     // Catch: JSONException -> L66
        goto L48
    L59:
        r29 = 0;
        goto L60
    L55:
        r122 = 0;
        goto L56
    L61:
        r25.put("grids", r26);     // Catch: JSONException -> L66
        JSONObject r30 = new JSONObject();     // Catch: JSONException -> L66
        r30.put("width", r24.getFirst());     // Catch: JSONException -> L66
        r30.put("height", r24.getSecond());     // Catch: JSONException -> L66
        h r31 = r23.T;     // Catch: JSONException -> L66
        if (r31 == null) goto L64;
        r30.put("background", r31.b());     // Catch: JSONException -> L66
    L64:
        r25.put("canvas", r30);     // Catch: JSONException -> L66
        HashMap r32 = new HashMap();     // Catch: JSONException -> L66
        r32.put("sei", r25.toString());     // Catch: JSONException -> L66
        g.p(r32);     // Catch: JSONException -> L66
        JSONObject r33 = r25;
    L67:
        String r34 = r33.toString();
        int r35 = qo0.a.a;
        qo0.a.c(r121, "mix stream, rtcSeiJson = " + r34 + ", isFirstRemoteVideoArrived = " + this.a);
        return r34;
    L66:
        r33 = null;
        goto L67
    L44:
        r22 = new ArrayList();
    L14:
        r14 = null;
        goto L15
    L85:
        return "";
    L84:
        return "";
    L69:
        return "";
    }

    public d(fi6.a r2, r r3, Pair<Integer, Integer> r4, Rect r5) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r4, "canvasSize");
        Intrinsics.checkNotNullParameter(r5, "liveCastRect");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
