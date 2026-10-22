package com.bytedance.crash.upload;

import ai.j0;
import com.bytedance.common.wschannel.WsConstants;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.Date;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4150c;
    public long d;
    public int e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f4151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f4152i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final JSONObject f4153j;

    public q(String r5, String r10) {
        this.f4149b = r5;
        this.f4150c = r10;
        this.e = 0;
        this.f = 0;
        this.d = 0;
        this.g = 0;
        this.f4151h = 0;
        this.f4152i = "";
        JSONObject r11 = new JSONObject();
        this.f4153j = r11;
        this.f4148a = s.e(r5, r10);
        r11.put(WsConstants.KEY_APP_ID, r5);     // Catch: Throwable -> L5
        r11.put(SVGRenderEngine.PATH, r10);     // Catch: Throwable -> L5
        return;
    }

    public final JSONObject a() {
        JSONObject r5 = this.f4153j;
        JSONObject r10 = new JSONObject();
        r5.put(WsConstants.KEY_APP_ID, this.f4149b);     // Catch: Throwable -> L9
        r5.put(SVGRenderEngine.PATH, this.f4150c);     // Catch: Throwable -> L9
        r5.put("update_time", this.d);     // Catch: Throwable -> L9
        r5.put("update_time_format", zm.p.o().format(new Date(this.d)));     // Catch: Throwable -> L6
    L7:
        r5.put("strategy", this.e);     // Catch: Throwable -> L9
        r5.put("alog_strategy", this.f);     // Catch: Throwable -> L9
        r5.put("retreatCount", this.g);     // Catch: Throwable -> L9
        r5.put("redirect", this.f4152i);     // Catch: Throwable -> L9
        r10.put(this.f4148a, r5);     // Catch: Throwable -> L9
        goto L8
    L6:
        r5.put("update_time_format", "");     // Catch: Throwable -> L9
    L8:
        return r10;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("[");
        r5.append(this.f4148a);
        r5.append(" ");
        r5.append(this.e);
        r5.append(" ");
        r5.append(this.f);
        r5.append(" ");
        r5.append(this.g);
        r5.append(" ");
        return j0.o(r5, this.f4151h, "]");
    }

    public q(JSONObject r5) {
        if (r5 == null) goto L7;
        String r10 = r5.optString(WsConstants.KEY_APP_ID);
        this.f4149b = r10;
        String r11 = r5.optString(SVGRenderEngine.PATH);
        this.f4150c = r11;
        this.e = r5.optInt("strategy");
        this.f = r5.optInt("alog_strategy");
        this.d = r5.optLong("update_time");
        r5.optString("update_time_format");
        this.g = r5.optInt("retreatCount");
        this.f4152i = r5.optString("redirect");
        this.f4153j = new JSONObject(r5.toString());
        this.f4148a = s.e(r10, r11);
        return;
    L7:
        throw new IllegalArgumentException("json can't be null");
    }
}
