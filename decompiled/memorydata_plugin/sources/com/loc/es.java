package com.loc;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.bytedance.crash.entity.CrashBody;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class es extends AMapLocation {
    protected String d;
    boolean e;
    String f;
    private String g;
    private String h;
    private int i;
    private String j;
    private int k;
    private String l;
    private JSONObject m;
    private String n;
    private String o;
    private String p;

    public es(String r3) {
        super(r3);
        this.d = "";
        this.g = null;
        this.h = "";
        this.j = "";
        this.k = 0;
        this.l = "new";
        this.m = null;
        this.n = "";
        this.e = true;
        this.f = String.valueOf(AMapLocationClientOption.GeoLanguage.DEFAULT);
        this.o = "";
        this.p = null;
    }

    private void i(String r1) {
        this.n = r1;
    }

    private void j(String r7) {
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
        setLongitude(fd.c(r2[0]));
        setLatitude(fd.c(r2[1]));
        setAccuracy(fd.e(r2[2]));
    L11:
        this.o = r7;
    }

    public final String a() {
        return this.g;
    }

    public final void a(int r1) {
        this.k = r1;
    }

    public final void a(String r1) {
        this.g = r1;
    }

    public final void a(JSONObject r1) {
        this.m = r1;
    }

    public final void a(boolean r1) {
        this.e = r1;
    }

    public final String b() {
        return this.h;
    }

    public final void b(String r1) {
        this.h = r1;
    }

    public final void b(JSONObject r7) {
        ev.a(this, r7);     // Catch: Throwable -> L16
        e(r7.optString("type", this.l));     // Catch: Throwable -> L16
        d(r7.optString("retype", this.j));     // Catch: Throwable -> L16
        j(r7.optString("cens", this.o));     // Catch: Throwable -> L16
        g(r7.optString("desc", this.d));     // Catch: Throwable -> L16
        c(r7.optString("coord", String.valueOf(this.i)));     // Catch: Throwable -> L16
        i(r7.optString("mcell", this.n));     // Catch: Throwable -> L16
        a(r7.optBoolean("isReversegeo", this.e));     // Catch: Throwable -> L16
        f(r7.optString("geoLanguage", this.f));     // Catch: Throwable -> L16
        if (fd.a(r7, "poiid") == false) goto L7;
        setBuildingId(r7.optString("poiid"));     // Catch: Throwable -> L16
    L7:
        if (fd.a(r7, CrashBody.PID) == false) goto L10;
        setBuildingId(r7.optString(CrashBody.PID));     // Catch: Throwable -> L16
    L10:
        if (fd.a(r7, "floor") == false) goto L13;
        setFloor(r7.optString("floor"));     // Catch: Throwable -> L16
    L13:
        if (fd.a(r7, "flr") == false) goto L21;
        setFloor(r7.optString("flr"));     // Catch: Throwable -> L16
        return;
    L21:
        return;
    L16:
        th = move-exception;
        ev.a(th, "AmapLoc", "AmapLoc");
    }

    public final int c() {
        return this.i;
    }

    public final void c(String r2) {
        if (TextUtils.isEmpty(r2) == false) goto L5;
    L10:
        int r3 = -1;
    L11:
        this.i = r3;
        if (this.i != 0) goto L16;
        String r4 = AMapLocation.COORD_TYPE_WGS84;
    L14:
        super.setCoordType(r4);
        return;
    L16:
        r4 = AMapLocation.COORD_TYPE_GCJ02;
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

    public final String d() {
        return this.j;
    }

    public final void d(String r1) {
        this.j = r1;
    }

    public final String e() {
        return this.l;
    }

    public final void e(String r1) {
        this.l = r1;
    }

    public final JSONObject f() {
        return this.m;
    }

    public final void f(String r1) {
        this.f = r1;
    }

    public final String g() {
        return this.n;
    }

    public final void g(String r1) {
        this.d = r1;
    }

    public final es h() {
        String r0 = g();
        if (TextUtils.isEmpty(r0) == false) goto L5;
        return null;
    L5:
        String[] r1 = r0.split(",");
        if (r1.length == 3) goto L8;
        return null;
    L8:
        es r2 = new es("");
        r2.setProvider(getProvider());
        r2.setLongitude(fd.c(r1[0]));
        r2.setLatitude(fd.c(r1[1]));
        r2.setAccuracy(fd.d(r1[2]));
        r2.setCityCode(getCityCode());
        r2.setAdCode(getAdCode());
        r2.setCountry(getCountry());
        r2.setProvince(getProvince());
        r2.setCity(getCity());
        r2.setTime(getTime());
        r2.e(e());
        r2.c(String.valueOf(c()));
        if (fd.a(r2) == true) goto L11;
        return null;
    L11:
        return r2;
    }

    public final void h(String r1) {
        this.p = r1;
    }

    public final boolean i() {
        return this.e;
    }

    public final String j() {
        return this.f;
    }

    public final String k() {
        return this.p;
    }

    public final int l() {
        return this.k;
    }

    @Override // com.amap.api.location.AMapLocation
    public final void setLocationType(int r2) {
        if (r2 != 2) goto L5;
    L8:
        et.a(this);
    L9:
        super.setLocationType(r2);
        return;
    L5:
        if (r2 == 4) goto L8;
        if (r2 != 9) goto L9;
        goto L8
    }

    @Override // com.amap.api.location.AMapLocation
    public final JSONObject toJson(int r4) {
        JSONObject r1 = super.toJson(r4);     // Catch: Throwable -> L17
        if (r4 != 1) goto L6;
        r1.put("retype", this.j);     // Catch: Throwable -> L17
        r1.put("cens", this.o);     // Catch: Throwable -> L17
        r1.put("coord", this.i);     // Catch: Throwable -> L17
        r1.put("mcell", this.n);     // Catch: Throwable -> L17
        r1.put("desc", this.d);     // Catch: Throwable -> L17
        r1.put(MemoryKeyInfoEntity.KEY_ADDRESS, getAddress());     // Catch: Throwable -> L17
        if (this.m != null) goto L13;
    L15:
        r1.put("type", this.l);     // Catch: Throwable -> L17
        r1.put("isReversegeo", this.e);     // Catch: Throwable -> L17
        r1.put("geoLanguage", this.f);     // Catch: Throwable -> L17
        return r1;
    L13:
        if (fd.a(r1, "offpct") == false) goto L15;
        r1.put("offpct", this.m.getString("offpct"));     // Catch: Throwable -> L17
        goto L15
    L6:
        if (r4 == 2) goto L15;
        if (r4 == 3) goto L15;
        return r1;
    L17:
        th = move-exception;
        ev.a(th, "AmapLoc", "toStr");
        return null;
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr() {
        return toStr(1);
    }

    @Override // com.amap.api.location.AMapLocation
    public final String toStr(int r3) {
        JSONObject r4 = toJson(r3);     // Catch: Throwable -> L5
        r4.put("nb", this.p);     // Catch: Throwable -> L5
    L7:
        if (r4 != null) goto L10;
        return null;
    L10:
        return r4.toString();
    L5:
        th = move-exception;
        ev.a(th, "AMapLocation", "toStr part2");
        r4 = null;
        goto L7
    }
}
