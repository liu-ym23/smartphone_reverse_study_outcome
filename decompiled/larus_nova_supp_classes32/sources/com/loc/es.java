package com.loc;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.aivoice.core.data.NameKeys;
import n4a.b4;
import n4a.c4;
import n4a.f5;
import n4a.j4;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class es extends AMapLocation {
    public String J;
    public String K;
    public String L;
    public int M;
    public String N;
    public int O;
    public String P;
    public JSONObject Q;
    public String R;
    public boolean S;
    public String T;
    public String U;
    public String V;

    public es() {
        super(NameKeys.UnloadStrategy_No_Strategy);
        this.J = NameKeys.UnloadStrategy_No_Strategy;
        this.K = null;
        this.L = NameKeys.UnloadStrategy_No_Strategy;
        this.N = NameKeys.UnloadStrategy_No_Strategy;
        this.O = 0;
        this.P = "new";
        this.Q = null;
        this.R = NameKeys.UnloadStrategy_No_Strategy;
        this.S = true;
        this.T = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
        this.U = NameKeys.UnloadStrategy_No_Strategy;
        this.V = null;
    }

    public final void r(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L10:
        int r3 = -1;
    L11:
        this.M = r3;
        if (this.M != 0) goto L16;
        String r4 = "WGS84";
    L14:
        super.setCoordType(r4);
        return;
    L16:
        r4 = "GCJ02";
        goto L14
    L5:
        if (r2.equals("0") == false) goto L8;
        r3 = 0;
        goto L11
    L8:
        if (r2.equals("1") == false) goto L10;
        r3 = 1;
        goto L11
    }

    public final void setLocationType(int r2) {
        if (r2 != 2) goto L5;
    L8:
        b4.a(this);
    L9:
        super.setLocationType(r2);
        return;
    L5:
        if (r2 == 4) goto L8;
        if (r2 != 9) goto L9;
        goto L8
    }

    public final String toStr() {
        return toStr(1);
    }

    public final String toStr(int r4) {
        JSONObject r5 = toJson(r4);     // Catch: Throwable -> L5
        r5.put("nb", this.V);     // Catch: Throwable -> L5
    L7:
        if (r5 != null) goto L10;
        return null;
    L10:
        return r5.toString();
    L5:
        th = move-exception;
        c4.g(th, "AMapLocation", "toStr part2");
        r5 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.location.Location, com.amap.api.location.AMapLocation, com.loc.es] */
    public final es s() {
        String r0 = this.R;
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return null;
    L5:
        String[] r1 = r0.split(",");
        if (r1.length == 3) goto L8;
        return null;
    L8:
        ?? r2 = new es();
        r2.setProvider(getProvider());
        r2.setLongitude(CastDoubleProtector.parseDouble(r1[0]));
        r2.setLatitude(CastDoubleProtector.parseDouble(r1[1]));
        r2.setAccuracy(CastFloatProtector.parseFloat(r1[2]));
        r2.setCityCode(getCityCode());
        r2.setAdCode(getAdCode());
        r2.setCountry(getCountry());
        r2.setProvince(getProvince());
        r2.setCity(getCity());
        r2.setTime(getTime());
        r2.P = this.P;
        r2.r(String.valueOf(this.M));
        if (j4.m(r2) == true) goto L11;
        return null;
    L11:
        return r2;
    }

    public final void q(JSONObject r7) {
        c4.e(this, r7);     // Catch: Throwable -> L16
        this.P = r7.optString("type", this.P);     // Catch: Throwable -> L16
        this.N = r7.optString("retype", this.N);     // Catch: Throwable -> L16
        t(r7.optString("cens", this.U));     // Catch: Throwable -> L16
        this.J = r7.optString("desc", this.J);     // Catch: Throwable -> L16
        r(r7.optString("coord", String.valueOf(this.M)));     // Catch: Throwable -> L16
        this.R = r7.optString("mcell", this.R);     // Catch: Throwable -> L16
        this.S = r7.optBoolean("isReversegeo", this.S);     // Catch: Throwable -> L16
        this.T = r7.optString("geoLanguage", this.T);     // Catch: Throwable -> L16
        if (f5.h(r7, "poiid") == false) goto L7;
        setBuildingId(r7.optString("poiid"));     // Catch: Throwable -> L16
    L7:
        if (f5.h(r7, "pid") == false) goto L10;
        setBuildingId(r7.optString("pid"));     // Catch: Throwable -> L16
    L10:
        if (f5.h(r7, "floor") == false) goto L13;
        setFloor(r7.optString("floor"));     // Catch: Throwable -> L16
    L13:
        if (f5.h(r7, "flr") == false) goto L21;
        setFloor(r7.optString("flr"));     // Catch: Throwable -> L16
        return;
    L21:
        return;
    L16:
        th = move-exception;
        c4.g(th, "AmapLoc", "AmapLoc");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void t(String r7) {
        if (TextUtils.isEmpty(r7) == false) goto L5;
        return;
    L5:
        String[] r0 = r7.split("\\*");
        int r1 = r0.length;
        int r3 = 0;
    L6:
        if (r3 >= r1) goto L11;
        String r4 = r0[r3];
        if (TextUtils.isEmpty(r4) == false) goto L9;
        r3 = r3 + 1;
        goto L6
    L9:
        String[] r2 = r4.split(",");
        setLongitude(CastDoubleProtector.parseDouble(r2[0]));
        setLatitude(CastDoubleProtector.parseDouble(r2[1]));
        setAccuracy(CastIntegerProtector.parseInt(r2[2]));
    L11:
        this.U = r7;
    }

    public final JSONObject toJson(int r4) {
        JSONObject r1 = super.toJson(r4);     // Catch: Throwable -> L17
        if (r4 != 1) goto L6;
        r1.put("retype", this.N);     // Catch: Throwable -> L17
        r1.put("cens", this.U);     // Catch: Throwable -> L17
        r1.put("coord", this.M);     // Catch: Throwable -> L17
        r1.put("mcell", this.R);     // Catch: Throwable -> L17
        r1.put("desc", this.J);     // Catch: Throwable -> L17
        r1.put("address", getAddress());     // Catch: Throwable -> L17
        if (this.Q != null) goto L13;
    L15:
        r1.put("type", this.P);     // Catch: Throwable -> L17
        r1.put("isReversegeo", this.S);     // Catch: Throwable -> L17
        r1.put("geoLanguage", this.T);     // Catch: Throwable -> L17
        return r1;
    L13:
        if (f5.h(r1, "offpct") == false) goto L15;
        r1.put("offpct", JSONObjectProtectorUtils.getString(this.Q, "offpct"));     // Catch: Throwable -> L17
        goto L15
    L6:
        if (r4 == 2) goto L15;
        if (r4 == 3) goto L15;
        return r1;
    L17:
        th = move-exception;
        c4.g(th, "AmapLoc", "toStr");
        return null;
    }
}
