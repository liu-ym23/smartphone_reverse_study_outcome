package com.loc;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class ea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5476a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public double f5477b;
    public double c;
    public long d;
    public int e;
    public int f;
    public int g;
    public int h;

    public ea() {
        this.f5476a = 0;
        this.f5477b = 0.0d;
        this.c = 0.0d;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 63;
        this.h = 0;
    }

    public final String a() {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L4
        r0.put(OaidModel.KEY_TIME, this.d);     // Catch: Throwable -> L4
        r0.put("lon", this.c);     // Catch: Throwable -> L4
        r0.put("lat", this.f5477b);     // Catch: Throwable -> L4
        r0.put("radius", this.e);     // Catch: Throwable -> L4
        r0.put("locationType", this.f5476a);     // Catch: Throwable -> L4
        r0.put("reType", this.g);     // Catch: Throwable -> L4
        r0.put("reSubType", this.h);     // Catch: Throwable -> L4
    L5:
        if (r0 != null) goto L9;
        return "";
    L9:
        return r0.toString();
    L4:
        r0 = null;
        goto L5
    }

    public final void a(JSONObject r4) {
        this.f5477b = r4.optDouble("lat", this.f5477b);     // Catch: Throwable -> L4
        this.c = r4.optDouble("lon", this.c);     // Catch: Throwable -> L4
        this.f5476a = r4.optInt("locationType", this.f5476a);     // Catch: Throwable -> L4
        this.g = r4.optInt("reType", this.g);     // Catch: Throwable -> L4
        this.h = r4.optInt("reSubType", this.h);     // Catch: Throwable -> L4
        this.e = r4.optInt("radius", this.e);     // Catch: Throwable -> L4
        this.d = r4.optLong(OaidModel.KEY_TIME, this.d);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        ev.a(th, "CoreUtil", "transformLocation");
    }

    public final boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 != null) goto L8;
    L27:
        return false;
    L8:
        if (getClass() != r7.getClass()) goto L27;
        ea r8 = (ea) ZeusTransformUtils.preCheckCast(r7, ea.class, "com.obric.memorydata.plugin");
        if (this.f5476a != r8.f5476a) goto L27;
        if (Double.compare(r8.f5477b, this.f5477b) != 0) goto L27;
        if (Double.compare(r8.c, this.c) != 0) goto L27;
        if (this.d != r8.d) goto L27;
        if (this.e != r8.e) goto L27;
        if (this.f != r8.f) goto L27;
        if (this.g != r8.g) goto L27;
        if (this.h != r8.h) goto L27;
        return true;
    }

    public final int hashCode() {
        return Objects.hash(new Object[]{Integer.valueOf(this.f5476a), Double.valueOf(this.f5477b), Double.valueOf(this.c), Long.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(this.f), Integer.valueOf(this.g), Integer.valueOf(this.h)});
    }
}
