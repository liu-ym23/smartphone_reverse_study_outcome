package com.ss.android.lark.monitor.traffic;

import com.ss.android.lark.log.Log;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k {
    public float A;
    public float B;
    public float C;
    public float D;
    public float E;
    public float F;
    public float G;
    public float H;
    public float I;
    public float J;
    public String K;
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public float s;
    public float t;
    public float u;
    public float v;
    public float w;
    public float x;
    public float y;
    public float z;

    public k() {
    }

    public final JSONObject a() {
        JSONObject r1 = new JSONObject();     // Catch: Exception -> L97
        r1.put("status", this.K);     // Catch: Exception -> L95
        r1.put("total_cost", this.a);     // Catch: Exception -> L95
        r1.put("total_rx", this.d);     // Catch: Exception -> L95
        r1.put("total_tx", this.e);     // Catch: Exception -> L95
        float r0 = this.b;     // Catch: Exception -> L95
        if (r0 <= 0.0f) goto L7;
        r1.put("total_mobile_cost", r0);     // Catch: Exception -> L95
    L7:
        float r2 = this.c;     // Catch: Exception -> L95
        if (r2 <= 0.0f) goto L10;
        r1.put("total_wifi_cost", r2);     // Catch: Exception -> L95
    L10:
        float r3 = this.f;     // Catch: Exception -> L95
        if (r3 <= 0.0f) goto L24;
        r1.put("rust_cost", r3);     // Catch: Exception -> L95
        float r4 = this.i;     // Catch: Exception -> L95
        if (r4 <= 0.0f) goto L15;
        r1.put("rust_mobile_cost", r4);     // Catch: Exception -> L95
    L15:
        float r5 = this.j;     // Catch: Exception -> L95
        if (r5 <= 0.0f) goto L18;
        r1.put("rust_wifi_cost", r5);     // Catch: Exception -> L95
    L18:
        float r6 = this.g;     // Catch: Exception -> L95
        if (r6 <= 0.0f) goto L21;
        r1.put("rust_rx", r6);     // Catch: Exception -> L95
    L21:
        float r7 = this.h;     // Catch: Exception -> L95
        if (r7 <= 0.0f) goto L24;
        r1.put("rust_tx", r7);     // Catch: Exception -> L95
    L24:
        float r8 = this.k;     // Catch: Exception -> L95
        if (r8 <= 0.0f) goto L38;
        r1.put("http_cost", r8);     // Catch: Exception -> L95
        float r9 = this.l;     // Catch: Exception -> L95
        if (r9 <= 0.0f) goto L29;
        r1.put("http_mobile_cost", r9);     // Catch: Exception -> L95
    L29:
        float r10 = this.m;     // Catch: Exception -> L95
        if (r10 <= 0.0f) goto L32;
        r1.put("http_wifi_cost", r10);     // Catch: Exception -> L95
    L32:
        float r11 = this.n;     // Catch: Exception -> L95
        if (r11 <= 0.0f) goto L35;
        r1.put("http_rx", r11);     // Catch: Exception -> L95
    L35:
        float r12 = this.o;     // Catch: Exception -> L95
        if (r12 <= 0.0f) goto L38;
        r1.put("http_tx", r12);     // Catch: Exception -> L95
    L38:
        float r13 = this.p;     // Catch: Exception -> L95
        if (r13 <= 0.0f) goto L52;
        r1.put("web_cost", r13);     // Catch: Exception -> L95
        float r14 = this.q;     // Catch: Exception -> L95
        if (r14 <= 0.0f) goto L43;
        r1.put("web_mobile_cost", r14);     // Catch: Exception -> L95
    L43:
        float r15 = this.r;     // Catch: Exception -> L95
        if (r15 <= 0.0f) goto L46;
        r1.put("web_wifi_cost", r15);     // Catch: Exception -> L95
    L46:
        float r16 = this.s;     // Catch: Exception -> L95
        if (r16 <= 0.0f) goto L49;
        r1.put("web_rx", r16);     // Catch: Exception -> L95
    L49:
        float r17 = this.t;     // Catch: Exception -> L95
        if (r17 <= 0.0f) goto L52;
        r1.put("web_tx", r17);     // Catch: Exception -> L95
    L52:
        float r18 = this.u;     // Catch: Exception -> L95
        if (r18 <= 0.0f) goto L66;
        r1.put("rtc_cost", r18);     // Catch: Exception -> L95
        float r19 = this.v;     // Catch: Exception -> L95
        if (r19 <= 0.0f) goto L57;
        r1.put("rtc_mobile_cost", r19);     // Catch: Exception -> L95
    L57:
        float r20 = this.w;     // Catch: Exception -> L95
        if (r20 <= 0.0f) goto L60;
        r1.put("rtc_wifi_cost", r20);     // Catch: Exception -> L95
    L60:
        float r21 = this.x;     // Catch: Exception -> L95
        if (r21 <= 0.0f) goto L63;
        r1.put("rtc_rx", r21);     // Catch: Exception -> L95
    L63:
        float r22 = this.y;     // Catch: Exception -> L95
        if (r22 <= 0.0f) goto L66;
        r1.put("rtc_tx", r22);     // Catch: Exception -> L95
    L66:
        float r23 = this.z;     // Catch: Exception -> L95
        if (r23 <= 0.0f) goto L80;
        r1.put("video_cost", r23);     // Catch: Exception -> L95
        float r24 = this.A;     // Catch: Exception -> L95
        if (r24 <= 0.0f) goto L71;
        r1.put("video_mobile_cost", r24);     // Catch: Exception -> L95
    L71:
        float r25 = this.B;     // Catch: Exception -> L95
        if (r25 <= 0.0f) goto L74;
        r1.put("video_wifi_cost", r25);     // Catch: Exception -> L95
    L74:
        float r26 = this.C;     // Catch: Exception -> L95
        if (r26 <= 0.0f) goto L77;
        r1.put("video_rx", r26);     // Catch: Exception -> L95
    L77:
        float r27 = this.D;     // Catch: Exception -> L95
        if (r27 <= 0.0f) goto L80;
        r1.put("video_tx", r27);     // Catch: Exception -> L95
    L80:
        float r28 = this.E;     // Catch: Exception -> L95
        if (r28 <= 0.0f) goto L100;
        r1.put("ttnet_cost", r28);     // Catch: Exception -> L95
        float r29 = this.F;     // Catch: Exception -> L95
        if (r29 <= 0.0f) goto L85;
        r1.put("ttnet_mobile_cost", r29);     // Catch: Exception -> L95
    L85:
        float r30 = this.G;     // Catch: Exception -> L95
        if (r30 <= 0.0f) goto L88;
        r1.put("ttnet_wifi_cost", r30);     // Catch: Exception -> L95
    L88:
        float r31 = this.H;     // Catch: Exception -> L95
        if (r31 <= 0.0f) goto L91;
        r1.put("ttnet_rx", r31);     // Catch: Exception -> L95
    L91:
        float r32 = this.I;     // Catch: Exception -> L95
        if (r32 <= 0.0f) goto L100;
        r1.put("ttnet_tx", r32);     // Catch: Exception -> L95
    L100:
        return r1;
    L95:
        Exception e = e;
    L99:
        Log.e("ScenePerfMonitor", "get traffic report json to slardar exception", e);
    L97:
        e = move-exception;
        r1 = null;
        e = e;
        goto L99
    }
}
