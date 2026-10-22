package com.amap.api.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.loc.ev;
import com.loc.fd;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class AMapLocation extends Location implements Parcelable, Cloneable {
    public static final String COORD_TYPE_GCJ02 = "GCJ02";
    public static final String COORD_TYPE_WGS84 = "WGS84";
    public static final Parcelable.Creator<AMapLocation> CREATOR = null;
    public static final int ERROR_CODE_AIRPLANEMODE_WIFIOFF = 18;
    public static final int ERROR_CODE_FAILURE_AUTH = 7;
    public static final int ERROR_CODE_FAILURE_CELL = 11;
    public static final int ERROR_CODE_FAILURE_COARSE_LOCATION = 20;
    public static final int ERROR_CODE_FAILURE_CONNECTION = 4;
    public static final int ERROR_CODE_FAILURE_INIT = 9;
    public static final int ERROR_CODE_FAILURE_LOCATION = 6;
    public static final int ERROR_CODE_FAILURE_LOCATION_PARAMETER = 3;
    public static final int ERROR_CODE_FAILURE_LOCATION_PERMISSION = 12;
    public static final int ERROR_CODE_FAILURE_NOENOUGHSATELLITES = 14;
    public static final int ERROR_CODE_FAILURE_NOWIFIANDAP = 13;
    public static final int ERROR_CODE_FAILURE_PARSER = 5;
    public static final int ERROR_CODE_FAILURE_SIMULATION_LOCATION = 15;
    public static final int ERROR_CODE_FAILURE_WIFI_INFO = 2;
    public static final int ERROR_CODE_INVALID_PARAMETER = 1;
    public static final int ERROR_CODE_NOCGI_WIFIOFF = 19;
    public static final int ERROR_CODE_NO_COMPENSATION_CACHE = 33;
    public static final int ERROR_CODE_SERVICE_FAIL = 10;
    public static final int ERROR_CODE_UNKNOWN = 8;
    public static final int GPS_ACCURACY_BAD = 0;
    public static final int GPS_ACCURACY_GOOD = 1;
    public static final int GPS_ACCURACY_UNKNOWN = -1;
    public static final String LBS_REAL_LOCATION_TYPE = "realLocationType";
    public static final int LOCATION_COMPENSATION = 10;
    public static final int LOCATION_SUCCESS = 0;
    public static final int LOCATION_TYPE_AMAP = 7;
    public static final int LOCATION_TYPE_CELL = 6;
    public static final int LOCATION_TYPE_COARSE_LOCATION = 11;
    public static final int LOCATION_TYPE_FAST = 3;
    public static final int LOCATION_TYPE_FIX_CACHE = 4;
    public static final int LOCATION_TYPE_GPS = 1;
    public static final int LOCATION_TYPE_LAST_LOCATION_CACHE = 9;
    public static final int LOCATION_TYPE_NETWORK = 12;
    public static final int LOCATION_TYPE_OFFLINE = 8;
    public static final int LOCATION_TYPE_SAME_REQ = 2;
    public static final int LOCATION_TYPE_WIFI = 5;
    public static final int TRUSTED_LEVEL_BAD = 4;
    public static final int TRUSTED_LEVEL_HIGH = 1;
    public static final int TRUSTED_LEVEL_LOW = 3;
    public static final int TRUSTED_LEVEL_NORMAL = 2;
    private int A;
    private String B;
    private int C;
    private boolean D;
    private String E;
    private boolean F;
    private String G;
    private int H;
    private int I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected String f475b;
    c c;
    private String d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String n;
    private boolean o;
    private int p;
    private String q;
    private String r;
    private int s;
    private double t;
    private double u;
    private double v;
    private float w;
    private float x;
    private Bundle y;
    private String z;

    static {
        CREATOR = new AnonymousClass1();
    }

    public AMapLocation(Location r6) {
        super(r6);
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = true;
        this.p = 0;
        this.q = "success";
        this.r = "";
        this.s = 0;
        this.t = 0.0d;
        this.u = 0.0d;
        this.v = 0.0d;
        this.w = 0.0f;
        this.x = 0.0f;
        Bundle r3 = null;
        this.y = null;
        this.A = 0;
        this.B = "";
        this.C = -1;
        this.D = false;
        this.E = "";
        this.F = false;
        this.f474a = "";
        this.f475b = "";
        this.c = new c();
        this.G = COORD_TYPE_GCJ02;
        this.H = 1;
        this.t = r6.getLatitude();
        this.u = r6.getLongitude();
        this.v = r6.getAltitude();
        this.x = r6.getBearing();
        this.w = r6.getSpeed();
        this.z = r6.getProvider();
        if (r6.getExtras() == null) goto L6;
        r3 = new Bundle(r6.getExtras());
    L6:
        this.y = r3;
    }

    public AMapLocation(String r6) {
        super(r6);
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
        this.o = true;
        this.p = 0;
        this.q = "success";
        this.r = "";
        this.s = 0;
        this.t = 0.0d;
        this.u = 0.0d;
        this.v = 0.0d;
        this.w = 0.0f;
        this.x = 0.0f;
        this.y = null;
        this.A = 0;
        this.B = "";
        this.C = -1;
        this.D = false;
        this.E = "";
        this.F = false;
        this.f474a = "";
        this.f475b = "";
        this.c = new c();
        this.G = COORD_TYPE_GCJ02;
        this.H = 1;
        this.z = r6;
    }

    static /* synthetic */ double a(AMapLocation r0, double r1) {
        r0.t = r1;
        return r1;
    }

    static /* synthetic */ int a(AMapLocation r0, int r1) {
        r0.p = r1;
        return r1;
    }

    static /* synthetic */ String a(AMapLocation r0, String r1) {
        r0.h = r1;
        return r1;
    }

    static /* synthetic */ boolean a(AMapLocation r0, boolean r1) {
        r0.F = r1;
        return r1;
    }

    static /* synthetic */ double b(AMapLocation r0, double r1) {
        r0.u = r1;
        return r1;
    }

    static /* synthetic */ int b(AMapLocation r0, int r1) {
        r0.s = r1;
        return r1;
    }

    static /* synthetic */ String b(AMapLocation r0, String r1) {
        r0.i = r1;
        return r1;
    }

    static /* synthetic */ boolean b(AMapLocation r0, boolean r1) {
        r0.o = r1;
        return r1;
    }

    static /* synthetic */ int c(AMapLocation r0, int r1) {
        r0.A = r1;
        return r1;
    }

    static /* synthetic */ String c(AMapLocation r0, String r1) {
        r0.B = r1;
        return r1;
    }

    static /* synthetic */ boolean c(AMapLocation r0, boolean r1) {
        r0.D = r1;
        return r1;
    }

    static /* synthetic */ int d(AMapLocation r0, int r1) {
        r0.C = r1;
        return r1;
    }

    static /* synthetic */ String d(AMapLocation r0, String r1) {
        r0.e = r1;
        return r1;
    }

    static /* synthetic */ int e(AMapLocation r0, int r1) {
        r0.H = r1;
        return r1;
    }

    static /* synthetic */ String e(AMapLocation r0, String r1) {
        r0.g = r1;
        return r1;
    }

    static /* synthetic */ int f(AMapLocation r0, int r1) {
        r0.I = r1;
        return r1;
    }

    static /* synthetic */ String f(AMapLocation r0, String r1) {
        r0.k = r1;
        return r1;
    }

    static /* synthetic */ String g(AMapLocation r0, String r1) {
        r0.f = r1;
        return r1;
    }

    static /* synthetic */ String h(AMapLocation r0, String r1) {
        r0.q = r1;
        return r1;
    }

    static /* synthetic */ String i(AMapLocation r0, String r1) {
        r0.r = r1;
        return r1;
    }

    static /* synthetic */ String j(AMapLocation r0, String r1) {
        r0.n = r1;
        return r1;
    }

    static /* synthetic */ String k(AMapLocation r0, String r1) {
        r0.j = r1;
        return r1;
    }

    static /* synthetic */ String l(AMapLocation r0, String r1) {
        r0.d = r1;
        return r1;
    }

    static /* synthetic */ String m(AMapLocation r0, String r1) {
        r0.l = r1;
        return r1;
    }

    static /* synthetic */ String n(AMapLocation r0, String r1) {
        r0.m = r1;
        return r1;
    }

    static /* synthetic */ String o(AMapLocation r0, String r1) {
        r0.E = r1;
        return r1;
    }

    static /* synthetic */ String p(AMapLocation r0, String r1) {
        r0.G = r1;
        return r1;
    }

    public AMapLocation clone() {
        super.clone();     // Catch: Throwable -> L12
    L3:
        AMapLocation r0 = new AMapLocation(this);
        r0.setLatitude(this.t);     // Catch: Throwable -> L9
        r0.setLongitude(this.u);     // Catch: Throwable -> L9
        r0.setAdCode(this.h);     // Catch: Throwable -> L9
        r0.setAddress(this.i);     // Catch: Throwable -> L9
        r0.setAoiName(this.B);     // Catch: Throwable -> L9
        r0.setBuildingId(this.f474a);     // Catch: Throwable -> L9
        r0.setCity(this.e);     // Catch: Throwable -> L9
        r0.setCityCode(this.g);     // Catch: Throwable -> L9
        r0.setCountry(this.k);     // Catch: Throwable -> L9
        r0.setDistrict(this.f);     // Catch: Throwable -> L9
        r0.setErrorCode(this.p);     // Catch: Throwable -> L9
        r0.setErrorInfo(this.q);     // Catch: Throwable -> L9
        r0.setFloor(this.f475b);     // Catch: Throwable -> L9
        r0.setFixLastLocation(this.F);     // Catch: Throwable -> L9
        r0.setOffset(this.o);     // Catch: Throwable -> L9
        r0.setLocationDetail(this.r);     // Catch: Throwable -> L9
        r0.setLocationType(this.s);     // Catch: Throwable -> L9
        r0.setMock(this.D);     // Catch: Throwable -> L9
        r0.setNumber(this.n);     // Catch: Throwable -> L9
        r0.setPoiName(this.j);     // Catch: Throwable -> L9
        r0.setProvince(this.d);     // Catch: Throwable -> L9
        r0.setRoad(this.l);     // Catch: Throwable -> L9
        r0.setSatellites(this.A);     // Catch: Throwable -> L9
        r0.setGpsAccuracyStatus(this.C);     // Catch: Throwable -> L9
        r0.setStreet(this.m);     // Catch: Throwable -> L9
        r0.setDescription(this.E);     // Catch: Throwable -> L9
        r0.setExtras(getExtras());     // Catch: Throwable -> L9
        c r1 = this.c;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r0.setLocationQualityReport(r1.a());     // Catch: Throwable -> L9
    L7:
        r0.setCoordType(this.G);     // Catch: Throwable -> L9
        r0.setTrustedLevel(this.H);     // Catch: Throwable -> L9
        r0.setConScenario(this.I);     // Catch: Throwable -> L9
    L11:
        return r0;
    L9:
        th = move-exception;
        ev.a(th, "AMapLocation", "clone");
        goto L11
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m72clone() {
        return clone();
    }

    @Override // android.location.Location, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.location.Location
    public float getAccuracy() {
        return super.getAccuracy();
    }

    public String getAdCode() {
        return this.h;
    }

    public String getAddress() {
        return this.i;
    }

    @Override // android.location.Location
    public double getAltitude() {
        return this.v;
    }

    public String getAoiName() {
        return this.B;
    }

    @Override // android.location.Location
    public float getBearing() {
        return this.x;
    }

    public String getBuildingId() {
        return this.f474a;
    }

    public String getCity() {
        return this.e;
    }

    public String getCityCode() {
        return this.g;
    }

    public int getConScenario() {
        return this.I;
    }

    public String getCoordType() {
        return this.G;
    }

    public String getCountry() {
        return this.k;
    }

    public String getDescription() {
        return this.E;
    }

    public String getDistrict() {
        return this.f;
    }

    public int getErrorCode() {
        return this.p;
    }

    public String getErrorInfo() {
        StringBuilder r0 = new StringBuilder();
        r0.append(this.q);
        if (this.p == 0) goto L6;
        r0.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
        r0.append(",错误详细信息:" + this.r);
    L6:
        return r0.toString();
    }

    @Override // android.location.Location
    public Bundle getExtras() {
        return this.y;
    }

    public String getFloor() {
        return this.f475b;
    }

    public int getGpsAccuracyStatus() {
        return this.C;
    }

    @Override // android.location.Location
    public double getLatitude() {
        return this.t;
    }

    public String getLocationDetail() {
        return this.r;
    }

    public c getLocationQualityReport() {
        return this.c;
    }

    public int getLocationType() {
        return this.s;
    }

    @Override // android.location.Location
    public double getLongitude() {
        return this.u;
    }

    public String getPoiName() {
        return this.j;
    }

    @Override // android.location.Location
    public String getProvider() {
        return this.z;
    }

    public String getProvince() {
        return this.d;
    }

    public String getRoad() {
        return this.l;
    }

    public int getSatellites() {
        return this.A;
    }

    @Override // android.location.Location
    public float getSpeed() {
        return this.w;
    }

    public String getStreet() {
        return this.m;
    }

    public String getStreetNum() {
        return this.n;
    }

    public int getTrustedLevel() {
        return this.H;
    }

    public boolean isFixLastLocation() {
        return this.F;
    }

    @Override // android.location.Location
    public boolean isMock() {
        return this.D;
    }

    public boolean isOffset() {
        return this.o;
    }

    public void setAdCode(String r1) {
        this.h = r1;
    }

    public void setAddress(String r1) {
        this.i = r1;
    }

    @Override // android.location.Location
    public void setAltitude(double r1) {
        super.setAltitude(r1);
        this.v = r1;
    }

    public void setAoiName(String r1) {
        this.B = r1;
    }

    @Override // android.location.Location
    public void setBearing(float r3) {
        super.setBearing(r3);
    L4:
        if (r3 >= 0.0f) goto L7;
        r3 = r3 + 360.0f;
    L7:
        if (r3 < 360.0f) goto L9;
        r3 = r3 - 360.0f;
        goto L7
    L9:
        this.x = r3;
    }

    public void setBuildingId(String r1) {
        this.f474a = r1;
    }

    public void setCity(String r1) {
        this.e = r1;
    }

    public void setCityCode(String r1) {
        this.g = r1;
    }

    public void setConScenario(int r1) {
        this.I = r1;
    }

    public void setCoordType(String r1) {
        this.G = r1;
    }

    public void setCountry(String r1) {
        this.k = r1;
    }

    public void setDescription(String r1) {
        this.E = r1;
    }

    public void setDistrict(String r1) {
        this.f = r1;
    }

    public void setErrorCode(int r2) {
        if (this.p == 0) goto L5;
        return;
    L5:
        this.q = fd.a(r2);
        this.p = r2;
    }

    public void setErrorInfo(String r1) {
        this.q = r1;
    }

    @Override // android.location.Location
    public void setExtras(Bundle r2) {
        super.setExtras(r2);
        if (r2 != null) goto L5;
        Bundle r3 = null;
    L6:
        this.y = r3;
        return;
    L5:
        r3 = new Bundle(r2);
        goto L6
    }

    public void setFixLastLocation(boolean r1) {
        this.F = r1;
    }

    public void setFloor(String r4) {
        if (TextUtils.isEmpty(r4) == true) goto L9;
        r4 = r4.replace("F", "");
        Integer.parseInt(r4);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        ev.a(th, "AmapLoc", "setFloor");
        r4 = null;
    L9:
        this.f475b = r4;
    }

    public void setGpsAccuracyStatus(int r1) {
        this.C = r1;
    }

    @Override // android.location.Location
    public void setLatitude(double r1) {
        this.t = r1;
    }

    public void setLocationDetail(String r1) {
        this.r = r1;
    }

    public void setLocationQualityReport(c r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.c = r1;
    }

    public void setLocationType(int r1) {
        this.s = r1;
    }

    @Override // android.location.Location
    public void setLongitude(double r1) {
        this.u = r1;
    }

    @Override // android.location.Location
    public void setMock(boolean r1) {
        this.D = r1;
    }

    public void setNumber(String r1) {
        this.n = r1;
    }

    public void setOffset(boolean r1) {
        this.o = r1;
    }

    public void setPoiName(String r1) {
        this.j = r1;
    }

    @Override // android.location.Location
    public void setProvider(String r1) {
        super.setProvider(r1);
        this.z = r1;
    }

    public void setProvince(String r1) {
        this.d = r1;
    }

    public void setRoad(String r1) {
        this.l = r1;
    }

    public void setSatellites(int r1) {
        this.A = r1;
    }

    @Override // android.location.Location
    public void setSpeed(float r1) {
        super.setSpeed(r1);
        this.w = r1;
    }

    public void setStreet(String r1) {
        this.m = r1;
    }

    public void setTrustedLevel(int r1) {
        this.H = r1;
    }

    public JSONObject toJson(int r4) {
        JSONObject r0 = new JSONObject();     // Catch: Throwable -> L15
        if (r4 != 1) goto L6;
        r0.put("altitude", getAltitude());     // Catch: Throwable -> L18
        r0.put("speed", getSpeed());     // Catch: Throwable -> L18
        r0.put("bearing", getBearing());     // Catch: Throwable -> L18
    L11:
        r0.put("citycode", this.g);     // Catch: Throwable -> L15
        r0.put("adcode", this.h);     // Catch: Throwable -> L15
        r0.put("country", this.k);     // Catch: Throwable -> L15
        r0.put("province", this.d);     // Catch: Throwable -> L15
        r0.put("city", this.e);     // Catch: Throwable -> L15
        r0.put("district", this.f);     // Catch: Throwable -> L15
        r0.put("road", this.l);     // Catch: Throwable -> L15
        r0.put("street", this.m);     // Catch: Throwable -> L15
        r0.put("number", this.n);     // Catch: Throwable -> L15
        r0.put("poiname", this.j);     // Catch: Throwable -> L15
        r0.put("errorCode", this.p);     // Catch: Throwable -> L15
        r0.put("errorInfo", this.q);     // Catch: Throwable -> L15
        r0.put("locationType", this.s);     // Catch: Throwable -> L15
        r0.put("locationDetail", this.r);     // Catch: Throwable -> L15
        r0.put("aoiname", this.B);     // Catch: Throwable -> L15
        r0.put(MemoryKeyInfoEntity.KEY_ADDRESS, this.i);     // Catch: Throwable -> L15
        r0.put("poiid", this.f474a);     // Catch: Throwable -> L15
        r0.put("floor", this.f475b);     // Catch: Throwable -> L15
        r0.put("description", this.E);     // Catch: Throwable -> L15
    L12:
        r0.put(OaidModel.KEY_TIME, getTime());     // Catch: Throwable -> L15
    L13:
        r0.put("provider", getProvider());     // Catch: Throwable -> L15
        r0.put("lon", getLongitude());     // Catch: Throwable -> L15
        r0.put("lat", getLatitude());     // Catch: Throwable -> L15
        r0.put(LocationMonitorConst.ACCURACY, getAccuracy());     // Catch: Throwable -> L15
        r0.put("isOffset", this.o);     // Catch: Throwable -> L15
        r0.put("isFixLastLocation", this.F);     // Catch: Throwable -> L15
        r0.put("coordType", this.G);     // Catch: Throwable -> L15
        return r0;
    L6:
        if (r4 == 2) goto L12;
        if (r4 == 3) goto L13;
        return r0;
    L15:
        th = move-exception;
        ev.a(th, "AmapLoc", "toStr");
        return null;
    }

    public String toStr() {
        return toStr(1);
    }

    public String toStr(int r3) {
        JSONObject r2 = toJson(r3);     // Catch: Throwable -> L5
    L7:
        if (r2 != null) goto L10;
        return null;
    L10:
        return r2.toString();
    L5:
        th = move-exception;
        ev.a(th, "AMapLocation", "toStr part2");
        r2 = null;
        goto L7
    }

    @Override // android.location.Location
    public String toString() {
        StringBuffer r1 = new StringBuffer();
        r1.append("latitude=" + this.t + "#");     // Catch: Throwable -> L6
        r1.append("longitude=" + this.u + "#");     // Catch: Throwable -> L6
        r1.append("province=" + this.d + "#");     // Catch: Throwable -> L6
        r1.append("coordType=" + this.G + "#");     // Catch: Throwable -> L6
        r1.append("city=" + this.e + "#");     // Catch: Throwable -> L6
        r1.append("district=" + this.f + "#");     // Catch: Throwable -> L6
        r1.append("cityCode=" + this.g + "#");     // Catch: Throwable -> L6
        r1.append("adCode=" + this.h + "#");     // Catch: Throwable -> L6
        r1.append("address=" + this.i + "#");     // Catch: Throwable -> L6
        r1.append("country=" + this.k + "#");     // Catch: Throwable -> L6
        r1.append("road=" + this.l + "#");     // Catch: Throwable -> L6
        r1.append("poiName=" + this.j + "#");     // Catch: Throwable -> L6
        r1.append("street=" + this.m + "#");     // Catch: Throwable -> L6
        r1.append("streetNum=" + this.n + "#");     // Catch: Throwable -> L6
        r1.append("aoiName=" + this.B + "#");     // Catch: Throwable -> L6
        r1.append("poiid=" + this.f474a + "#");     // Catch: Throwable -> L6
        r1.append("floor=" + this.f475b + "#");     // Catch: Throwable -> L6
        r1.append("errorCode=" + this.p + "#");     // Catch: Throwable -> L6
        r1.append("errorInfo=" + this.q + "#");     // Catch: Throwable -> L6
        r1.append("locationDetail=" + this.r + "#");     // Catch: Throwable -> L6
        r1.append("description=" + this.E + "#");     // Catch: Throwable -> L6
        r1.append("locationType=" + this.s + "#");     // Catch: Throwable -> L6
        r1.append("conScenario=" + this.I);     // Catch: Throwable -> L6
    L5:
        return r1.toString();
    }

    @Override // android.location.Location, android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        super.writeToParcel(r5, r6);     // Catch: Throwable -> L16
        r5.writeString(this.h);     // Catch: Throwable -> L16
        r5.writeString(this.i);     // Catch: Throwable -> L16
        r5.writeString(this.B);     // Catch: Throwable -> L16
        r5.writeString(this.f474a);     // Catch: Throwable -> L16
        r5.writeString(this.e);     // Catch: Throwable -> L16
        r5.writeString(this.g);     // Catch: Throwable -> L16
        r5.writeString(this.k);     // Catch: Throwable -> L16
        r5.writeString(this.f);     // Catch: Throwable -> L16
        r5.writeInt(this.p);     // Catch: Throwable -> L16
        r5.writeString(this.q);     // Catch: Throwable -> L16
        r5.writeString(this.f475b);     // Catch: Throwable -> L16
        int r0 = 1;
        if (this.F == false) goto L5;
        int r7 = 1;
    L6:
        r5.writeInt(r7);     // Catch: Throwable -> L16
        if (this.o == false) goto L9;
        int r8 = 1;
    L10:
        r5.writeInt(r8);     // Catch: Throwable -> L16
        r5.writeDouble(this.t);     // Catch: Throwable -> L16
        r5.writeString(this.r);     // Catch: Throwable -> L16
        r5.writeInt(this.s);     // Catch: Throwable -> L16
        r5.writeDouble(this.u);     // Catch: Throwable -> L16
        if (this.D == true) goto L14;
        r0 = 0;
    L14:
        r5.writeInt(r0);     // Catch: Throwable -> L16
        r5.writeString(this.n);     // Catch: Throwable -> L16
        r5.writeString(this.j);     // Catch: Throwable -> L16
        r5.writeString(this.d);     // Catch: Throwable -> L16
        r5.writeString(this.l);     // Catch: Throwable -> L16
        r5.writeInt(this.A);     // Catch: Throwable -> L16
        r5.writeInt(this.C);     // Catch: Throwable -> L16
        r5.writeString(this.m);     // Catch: Throwable -> L16
        r5.writeString(this.E);     // Catch: Throwable -> L16
        r5.writeString(this.G);     // Catch: Throwable -> L16
        r5.writeInt(this.H);     // Catch: Throwable -> L16
        r5.writeInt(this.I);     // Catch: Throwable -> L16
        return;
    L9:
        r8 = 0;
        goto L10
    L5:
        r7 = 0;
    L16:
        th = move-exception;
        ev.a(th, "AMapLocation", "writeToParcel");
    }
}
