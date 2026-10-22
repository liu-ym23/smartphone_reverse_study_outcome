package com.loc;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.obric.cae.location.database.StarLocationDbManager;
import l6.a;
import org.json.JSONObject;
import qa.t3;
import qa.t4;
import qa.y3;

/* JADX INFO: loaded from: classes.dex */
public final class es extends AMapLocation {
    public String T;
    public String U;
    public String V;
    public int W;
    public String X;
    public int Y;
    public String Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public JSONObject f5207a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public String f5208b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f5209c0;
    public String d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public String f5210e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public String f5211f0;

    public es() {
        super("");
        this.T = "";
        this.U = null;
        this.V = "";
        this.X = "";
        this.Y = 0;
        this.Z = "new";
        this.f5207a0 = null;
        this.f5208b0 = "";
        this.f5209c0 = true;
        this.d0 = String.valueOf(AMapLocationClientOption.e.f3674a);
        this.f5210e0 = "";
        this.f5211f0 = null;
    }

    @Override // com.amap.api.location.AMapLocation
    public final String A(int r8) {
        JSONObject r10 = y(r8);     // Catch: Throwable -> L5
        r10.put("nb", this.f5211f0);     // Catch: Throwable -> L5
    L7:
        if (r10 != null) goto L10;
        return null;
    L10:
        return r10.toString();
    L5:
        th = move-exception;
        t3.g("AMapLocation", "toStr part2", th);
        r10 = null;
        goto L7
    }

    public final void B(JSONObject r8) {
        t3.e(this, r8);     // Catch: Throwable -> L16
        this.Z = r8.optString("type", this.Z);     // Catch: Throwable -> L16
        this.X = r8.optString("retype", this.X);     // Catch: Throwable -> L16
        E(r8.optString("cens", this.f5210e0));     // Catch: Throwable -> L16
        this.T = r8.optString("desc", this.T);     // Catch: Throwable -> L16
        C(r8.optString("coord", String.valueOf(this.W)));     // Catch: Throwable -> L16
        this.f5208b0 = r8.optString("mcell", this.f5208b0);     // Catch: Throwable -> L16
        this.f5209c0 = r8.optBoolean("isReversegeo", this.f5209c0);     // Catch: Throwable -> L16
        this.d0 = r8.optString("geoLanguage", this.d0);     // Catch: Throwable -> L16
        if (t4.g("poiid", r8) == false) goto L7;
        this.N = r8.optString("poiid");     // Catch: Throwable -> L16
    L7:
        if (t4.g("pid", r8) == false) goto L10;
        this.N = r8.optString("pid");     // Catch: Throwable -> L16
    L10:
        if (t4.g("floor", r8) == false) goto L13;
        w(r8.optString("floor"));     // Catch: Throwable -> L16
    L13:
        if (t4.g("flr", r8) == false) goto L21;
        w(r8.optString("flr"));     // Catch: Throwable -> L16
        return;
    L21:
        return;
    L16:
        th = move-exception;
        t3.g("AmapLoc", "AmapLoc", th);
    }

    public final void C(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L10:
        int r10 = -1;
    L11:
        this.W = r10;
        if (this.W != 0) goto L15;
        this.Q = "WGS84";
        return;
    L15:
        this.Q = "GCJ02";
        return;
    L5:
        if (r8.equals("0") == false) goto L8;
        r10 = 0;
        goto L11
    L8:
        if (r8.equals("1") == false) goto L10;
        r10 = 1;
        goto L11
    }

    public final es D() {
        String r8 = this.f5208b0;
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return null;
    L5:
        String[] r10 = r8.split(",");
        if (r10.length == 3) goto L8;
        return null;
    L8:
        es r11 = new es();
        r11.setProvider(this.G);
        r11.B = Double.parseDouble(r10[0]);
        r11.A = Double.parseDouble(r10[1]);
        r11.setAccuracy(Float.parseFloat(r10[2]));
        r11.f3637n = this.f3637n;
        r11.f3638o = this.f3638o;
        r11.f3641r = this.f3641r;
        r11.f3634a = this.f3634a;
        r11.f3635b = this.f3635b;
        r11.setTime(getTime());
        r11.Z = this.Z;
        r11.C(String.valueOf(this.W));
        if (y3.l(r11) == true) goto L11;
        return null;
    L11:
        return r11;
    }

    public final void E(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        String[] r10 = r8.split("\\*");
        int r11 = r10.length;
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L11;
        String r13 = r10[r12];
        if (TextUtils.isEmpty(r13) == false) goto L9;
        r12 = r12 + 1;
        goto L6
    L9:
        String[] r14 = r13.split(",");
        this.B = Double.parseDouble(r14[0]);
        this.A = Double.parseDouble(r14[1]);
        setAccuracy(Integer.parseInt(r14[2]));
    L11:
        this.f5210e0 = r8;
    }

    @Override // com.amap.api.location.AMapLocation
    public final void x(int r8) {
        if (r8 != 2) goto L5;
    L8:
        a.l(this);
    L9:
        this.f3649z = r8;
        return;
    L5:
        if (r8 == 4) goto L8;
        if (r8 != 9) goto L9;
        goto L8
    }

    @Override // com.amap.api.location.AMapLocation
    public final JSONObject y(int r8) {
        JSONObject r10 = super.y(r8);     // Catch: Throwable -> L17
        if (r8 != 1) goto L6;
        r10.put("retype", this.X);     // Catch: Throwable -> L17
        r10.put("cens", this.f5210e0);     // Catch: Throwable -> L17
        r10.put("coord", this.W);     // Catch: Throwable -> L17
        r10.put("mcell", this.f5208b0);     // Catch: Throwable -> L17
        r10.put("desc", this.T);     // Catch: Throwable -> L17
        r10.put(StarLocationDbManager.GeofenceEntry.ADDRESS, this.f3639p);     // Catch: Throwable -> L17
        if (this.f5207a0 != null) goto L13;
    L15:
        r10.put("type", this.Z);     // Catch: Throwable -> L17
        r10.put("isReversegeo", this.f5209c0);     // Catch: Throwable -> L17
        r10.put("geoLanguage", this.d0);     // Catch: Throwable -> L17
        return r10;
    L13:
        if (t4.g("offpct", r10) == false) goto L15;
        r10.put("offpct", this.f5207a0.getString("offpct"));     // Catch: Throwable -> L17
        goto L15
    L6:
        if (r8 == 2) goto L15;
        if (r8 == 3) goto L15;
        return r10;
    L17:
        th = move-exception;
        t3.g("AmapLoc", "toStr", th);
        return null;
    }

    @Override // com.amap.api.location.AMapLocation
    public final String z() {
        return A(1);
    }
}
