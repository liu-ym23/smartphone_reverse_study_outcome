package com.amap.api.location;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.location.database.StarLocationDbManager;
import org.json.JSONObject;
import qa.t3;

/* JADX INFO: loaded from: classes.dex */
public class AMapLocation extends Location implements Cloneable {
    public static final Parcelable.Creator<AMapLocation> CREATOR = null;
    public double A;
    public double B;
    public double C;
    public float D;
    public float E;
    public Bundle F;
    public String G;
    public int H;
    public String I;
    public int J;
    public boolean K;
    public String L;
    public boolean M;
    public String N;
    public String O;
    public com.amap.api.location.a P;
    public String Q;
    public int R;
    public int S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f3634a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f3635b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f3636m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f3637n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f3638o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f3639p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f3640q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f3641r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f3642s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f3643t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f3644u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f3645v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3646w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f3647x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f3648y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f3649z;

    public static class a implements Parcelable.Creator<AMapLocation> {
        @Override // android.os.Parcelable.Creator
        public final AMapLocation createFromParcel(Parcel r8) {
            AMapLocation r10 = new AMapLocation((Location) Location.CREATOR.createFromParcel(r8));
            r10.f3638o = r8.readString();
            r10.f3639p = r8.readString();
            r10.I = r8.readString();
            r10.N = r8.readString();
            r10.f3635b = r8.readString();
            r10.f3637n = r8.readString();
            r10.f3641r = r8.readString();
            r10.f3636m = r8.readString();
            r10.f3646w = r8.readInt();
            r10.f3647x = r8.readString();
            r10.O = r8.readString();
            boolean r11 = true;
            if (r8.readInt() == 0) goto L5;
            boolean r12 = true;
        L6:
            r10.M = r12;
            if (r8.readInt() == 0) goto L9;
            boolean r13 = true;
        L10:
            r10.f3645v = r13;
            r10.A = r8.readDouble();
            r10.f3648y = r8.readString();
            r10.f3649z = r8.readInt();
            r10.B = r8.readDouble();
            if (r8.readInt() != 0) goto L14;
            r11 = false;
        L14:
            r10.K = r11;
            r10.f3644u = r8.readString();
            r10.f3640q = r8.readString();
            r10.f3634a = r8.readString();
            r10.f3642s = r8.readString();
            r10.H = r8.readInt();
            r10.J = r8.readInt();
            r10.f3643t = r8.readString();
            r10.L = r8.readString();
            r10.Q = r8.readString();
            r10.R = r8.readInt();
            r10.S = r8.readInt();
            return r10;
        L9:
            r13 = false;
            goto L10
        L5:
            r12 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public final AMapLocation[] newArray(int r8) {
            return new AMapLocation[r8];
        }
    }

    static {
        CREATOR = new a();
    }

    public AMapLocation(Location r8) {
        super(r8);
        this.f3634a = "";
        this.f3635b = "";
        this.f3636m = "";
        this.f3637n = "";
        this.f3638o = "";
        this.f3639p = "";
        this.f3640q = "";
        this.f3641r = "";
        this.f3642s = "";
        this.f3643t = "";
        this.f3644u = "";
        this.f3645v = true;
        this.f3646w = 0;
        this.f3647x = "success";
        this.f3648y = "";
        this.f3649z = 0;
        this.A = 0.0d;
        this.B = 0.0d;
        this.C = 0.0d;
        this.D = 0.0f;
        this.E = 0.0f;
        Bundle r10 = null;
        this.F = null;
        this.H = 0;
        this.I = "";
        this.J = -1;
        this.K = false;
        this.L = "";
        this.M = false;
        this.N = "";
        this.O = "";
        this.P = new com.amap.api.location.a();
        this.Q = "GCJ02";
        this.R = 1;
        this.A = r8.getLatitude();
        this.B = r8.getLongitude();
        this.C = r8.getAltitude();
        this.E = r8.getBearing();
        this.D = r8.getSpeed();
        this.G = r8.getProvider();
        if (r8.getExtras() == null) goto L6;
        r10 = new Bundle(r8.getExtras());
    L6:
        this.F = r10;
    }

    public String A(int r8) {
        JSONObject r10 = y(1);     // Catch: Throwable -> L5
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

    public final /* bridge */ /* synthetic */ Object clone() {
        return t();
    }

    @Override // android.location.Location, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.location.Location
    public final float getAccuracy() {
        return super.getAccuracy();
    }

    @Override // android.location.Location
    public final double getAltitude() {
        return this.C;
    }

    @Override // android.location.Location
    public final float getBearing() {
        return this.E;
    }

    @Override // android.location.Location
    public final Bundle getExtras() {
        return this.F;
    }

    @Override // android.location.Location
    public final double getLatitude() {
        return this.A;
    }

    @Override // android.location.Location
    public final double getLongitude() {
        return this.B;
    }

    @Override // android.location.Location
    public final String getProvider() {
        return this.G;
    }

    @Override // android.location.Location
    public final float getSpeed() {
        return this.D;
    }

    @Override // android.location.Location
    public final boolean isMock() {
        return this.K;
    }

    @Override // android.location.Location
    public final void setAltitude(double r8) {
        super.setAltitude(r8);
        this.C = r8;
    }

    @Override // android.location.Location
    public final void setBearing(float r8) {
        super.setBearing(r8);
    L4:
        if (r8 >= 0.0f) goto L7;
        r8 = r8 + 360.0f;
    L7:
        if (r8 < 360.0f) goto L9;
        r8 = r8 - 360.0f;
        goto L7
    L9:
        this.E = r8;
    }

    @Override // android.location.Location
    public final void setExtras(Bundle r8) {
        super.setExtras(r8);
        if (r8 != null) goto L5;
        Bundle r10 = null;
    L6:
        this.F = r10;
        return;
    L5:
        r10 = new Bundle(r8);
        goto L6
    }

    @Override // android.location.Location
    public final void setLatitude(double r8) {
        this.A = r8;
    }

    @Override // android.location.Location
    public final void setLongitude(double r8) {
        this.B = r8;
    }

    @Override // android.location.Location
    public final void setMock(boolean r8) {
        this.K = r8;
    }

    @Override // android.location.Location
    public final void setProvider(String r8) {
        super.setProvider(r8);
        this.G = r8;
    }

    @Override // android.location.Location
    public final void setSpeed(float r8) {
        super.setSpeed(r8);
        this.D = r8;
    }

    public final AMapLocation t() {
        super.clone();     // Catch: Throwable -> L12
    L3:
        AMapLocation r8 = new AMapLocation(this);
        r8.A = this.A;     // Catch: Throwable -> L9
        r8.B = this.B;     // Catch: Throwable -> L9
        r8.f3638o = this.f3638o;     // Catch: Throwable -> L9
        r8.f3639p = this.f3639p;     // Catch: Throwable -> L9
        r8.I = this.I;     // Catch: Throwable -> L9
        r8.N = this.N;     // Catch: Throwable -> L9
        r8.f3635b = this.f3635b;     // Catch: Throwable -> L9
        r8.f3637n = this.f3637n;     // Catch: Throwable -> L9
        r8.f3641r = this.f3641r;     // Catch: Throwable -> L9
        r8.f3636m = this.f3636m;     // Catch: Throwable -> L9
        r8.v(this.f3646w);     // Catch: Throwable -> L9
        r8.f3647x = this.f3647x;     // Catch: Throwable -> L9
        r8.w(this.O);     // Catch: Throwable -> L9
        r8.M = this.M;     // Catch: Throwable -> L9
        r8.f3645v = this.f3645v;     // Catch: Throwable -> L9
        r8.f3648y = this.f3648y;     // Catch: Throwable -> L9
        r8.f3649z = this.f3649z;     // Catch: Throwable -> L9
        r8.K = this.K;     // Catch: Throwable -> L9
        r8.f3644u = this.f3644u;     // Catch: Throwable -> L9
        r8.f3640q = this.f3640q;     // Catch: Throwable -> L9
        r8.f3634a = this.f3634a;     // Catch: Throwable -> L9
        r8.f3642s = this.f3642s;     // Catch: Throwable -> L9
        r8.H = this.H;     // Catch: Throwable -> L9
        r8.J = this.J;     // Catch: Throwable -> L9
        r8.f3643t = this.f3643t;     // Catch: Throwable -> L9
        r8.L = this.L;     // Catch: Throwable -> L9
        r8.setExtras(getExtras());     // Catch: Throwable -> L9
        com.amap.api.location.a r10 = this.P;     // Catch: Throwable -> L9
        if (r10 == null) goto L7;
        r8.P = r10.a();     // Catch: Throwable -> L9
    L7:
        r8.Q = this.Q;     // Catch: Throwable -> L9
        r8.R = this.R;     // Catch: Throwable -> L9
        r8.S = this.S;     // Catch: Throwable -> L9
    L11:
        return r8;
    L9:
        th = move-exception;
        t3.g("AMapLocation", "clone", th);
        goto L11
    }

    @Override // android.location.Location
    public final String toString() {
        StringBuffer r8 = new StringBuffer();
        r8.append("latitude=" + this.A + "#");     // Catch: Throwable -> L6
        r8.append("longitude=" + this.B + "#");     // Catch: Throwable -> L6
        r8.append("province=" + this.f3634a + "#");     // Catch: Throwable -> L6
        r8.append("coordType=" + this.Q + "#");     // Catch: Throwable -> L6
        r8.append("city=" + this.f3635b + "#");     // Catch: Throwable -> L6
        r8.append("district=" + this.f3636m + "#");     // Catch: Throwable -> L6
        r8.append("cityCode=" + this.f3637n + "#");     // Catch: Throwable -> L6
        r8.append("adCode=" + this.f3638o + "#");     // Catch: Throwable -> L6
        r8.append("address=" + this.f3639p + "#");     // Catch: Throwable -> L6
        r8.append("country=" + this.f3641r + "#");     // Catch: Throwable -> L6
        r8.append("road=" + this.f3642s + "#");     // Catch: Throwable -> L6
        r8.append("poiName=" + this.f3640q + "#");     // Catch: Throwable -> L6
        r8.append("street=" + this.f3643t + "#");     // Catch: Throwable -> L6
        r8.append("streetNum=" + this.f3644u + "#");     // Catch: Throwable -> L6
        r8.append("aoiName=" + this.I + "#");     // Catch: Throwable -> L6
        r8.append("poiid=" + this.N + "#");     // Catch: Throwable -> L6
        r8.append("floor=" + this.O + "#");     // Catch: Throwable -> L6
        r8.append("errorCode=" + this.f3646w + "#");     // Catch: Throwable -> L6
        r8.append("errorInfo=" + this.f3647x + "#");     // Catch: Throwable -> L6
        r8.append("locationDetail=" + this.f3648y + "#");     // Catch: Throwable -> L6
        r8.append("description=" + this.L + "#");     // Catch: Throwable -> L6
        r8.append("locationType=" + this.f3649z + "#");     // Catch: Throwable -> L6
        StringBuilder r10 = new StringBuilder("conScenario=");     // Catch: Throwable -> L6
        r10.append(this.S);     // Catch: Throwable -> L6
        r8.append(r10.toString());     // Catch: Throwable -> L6
    L5:
        return r8.toString();
    }

    public final String u() {
        StringBuilder r8 = new StringBuilder();
        r8.append(this.f3647x);
        if (this.f3646w == 0) goto L6;
        r8.append(" 请到http://lbs.amap.com/api/android-location-sdk/guide/utilities/errorcode/查看错误码说明");
        r8.append(",错误详细信息:" + this.f3648y);
    L6:
        return r8.toString();
    }

    public final void v(int r8) {
        if (this.f3646w == 0) goto L6;
        return;
    L6:
        if (r8 == 33) goto L29;
        switch(r8) {
            case 0: goto L24;
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L28;
            case 9: goto L16;
            case 10: goto L15;
            case 11: goto L14;
            case 12: goto L13;
            case 13: goto L12;
            case 14: goto L11;
            case 15: goto L10;
            default: goto L8;
        };
    L8:
        switch(r8) {
            case 18: goto L27;
            case 19: goto L26;
            case 20: goto L25;
            default: goto L28;
        };
    L25:
        String r10 = "模糊定位失败，具体可查看错误信息/详细信息描述";
    L30:
        this.f3647x = r10;
        this.f3646w = r8;
        return;
    L26:
        r10 = "定位失败，没有检查到SIM卡，并且关闭了WIFI开关，请打开WIFI开关或者插入SIM卡";
        goto L30
    L27:
        r10 = "定位失败，飞行模式下关闭了WIFI开关，请关闭飞行模式或者打开WIFI开关";
        goto L30
    L10:
        r10 = "当前返回位置为模拟软件返回，请关闭模拟软件，或者在option中设置允许模拟";
        goto L30
    L11:
        r10 = "GPS 定位失败，由于设备当前 GPS 状态差,建议持设备到相对开阔的露天场所再次尝试";
        goto L30
    L12:
        r10 = "网络定位失败，请检查设备是否插入sim卡，是否开启移动网络或开启了wifi模块";
        goto L30
    L13:
        r10 = "缺少定位权限";
        goto L30
    L14:
        r10 = "错误的基站信息，请检查是否插入SIM卡";
        goto L30
    L15:
        r10 = "定位服务启动失败";
        goto L30
    L16:
        r10 = "初始化异常";
        goto L30
    L17:
        r10 = "KEY错误";
        goto L30
    L18:
        r10 = "定位结果错误";
        goto L30
    L19:
        r10 = "解析数据异常";
        goto L30
    L20:
        r10 = "网络连接异常";
        goto L30
    L21:
        r10 = "请求参数获取出现异常";
        goto L30
    L22:
        r10 = "WIFI信息不足";
        goto L30
    L23:
        r10 = "重要参数为空";
        goto L30
    L24:
        r10 = "success";
    L28:
        r10 = "其他错误";
        goto L30
    L29:
        r10 = "补偿定位失败，未命中缓存";
        goto L30
    }

    public final void w(String r8) {
        if (TextUtils.isEmpty(r8) == true) goto L9;
        r8 = r8.replace("F", "");
        Integer.parseInt(r8);     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        t3.g("AmapLoc", "setFloor", th);
        r8 = null;
    L9:
        this.O = r8;
    }

    @Override // android.location.Location, android.os.Parcelable
    public final void writeToParcel(Parcel r8, int r10) {
        super.writeToParcel(r8, r10);     // Catch: Throwable -> L16
        r8.writeString(this.f3638o);     // Catch: Throwable -> L16
        r8.writeString(this.f3639p);     // Catch: Throwable -> L16
        r8.writeString(this.I);     // Catch: Throwable -> L16
        r8.writeString(this.N);     // Catch: Throwable -> L16
        r8.writeString(this.f3635b);     // Catch: Throwable -> L16
        r8.writeString(this.f3637n);     // Catch: Throwable -> L16
        r8.writeString(this.f3641r);     // Catch: Throwable -> L16
        r8.writeString(this.f3636m);     // Catch: Throwable -> L16
        r8.writeInt(this.f3646w);     // Catch: Throwable -> L16
        r8.writeString(this.f3647x);     // Catch: Throwable -> L16
        r8.writeString(this.O);     // Catch: Throwable -> L16
        int r11 = 1;
        if (this.M == false) goto L5;
        int r12 = 1;
    L6:
        r8.writeInt(r12);     // Catch: Throwable -> L16
        if (this.f3645v == false) goto L9;
        int r13 = 1;
    L10:
        r8.writeInt(r13);     // Catch: Throwable -> L16
        r8.writeDouble(this.A);     // Catch: Throwable -> L16
        r8.writeString(this.f3648y);     // Catch: Throwable -> L16
        r8.writeInt(this.f3649z);     // Catch: Throwable -> L16
        r8.writeDouble(this.B);     // Catch: Throwable -> L16
        if (this.K == true) goto L14;
        r11 = 0;
    L14:
        r8.writeInt(r11);     // Catch: Throwable -> L16
        r8.writeString(this.f3644u);     // Catch: Throwable -> L16
        r8.writeString(this.f3640q);     // Catch: Throwable -> L16
        r8.writeString(this.f3634a);     // Catch: Throwable -> L16
        r8.writeString(this.f3642s);     // Catch: Throwable -> L16
        r8.writeInt(this.H);     // Catch: Throwable -> L16
        r8.writeInt(this.J);     // Catch: Throwable -> L16
        r8.writeString(this.f3643t);     // Catch: Throwable -> L16
        r8.writeString(this.L);     // Catch: Throwable -> L16
        r8.writeString(this.Q);     // Catch: Throwable -> L16
        r8.writeInt(this.R);     // Catch: Throwable -> L16
        r8.writeInt(this.S);     // Catch: Throwable -> L16
        return;
    L9:
        r13 = 0;
        goto L10
    L5:
        r12 = 0;
    L16:
        th = move-exception;
        t3.g("AMapLocation", "writeToParcel", th);
    }

    public void x(int r8) {
        this.f3649z = r8;
    }

    public JSONObject y(int r8) {
        JSONObject r10 = new JSONObject();     // Catch: Throwable -> L15
        if (r8 != 1) goto L6;
        r10.put("altitude", getAltitude());     // Catch: Throwable -> L18
        r10.put("speed", getSpeed());     // Catch: Throwable -> L18
        r10.put("bearing", getBearing());     // Catch: Throwable -> L18
    L11:
        r10.put("citycode", this.f3637n);     // Catch: Throwable -> L15
        r10.put("adcode", this.f3638o);     // Catch: Throwable -> L15
        r10.put("country", this.f3641r);     // Catch: Throwable -> L15
        r10.put("province", this.f3634a);     // Catch: Throwable -> L15
        r10.put("city", this.f3635b);     // Catch: Throwable -> L15
        r10.put("district", this.f3636m);     // Catch: Throwable -> L15
        r10.put("road", this.f3642s);     // Catch: Throwable -> L15
        r10.put("street", this.f3643t);     // Catch: Throwable -> L15
        r10.put("number", this.f3644u);     // Catch: Throwable -> L15
        r10.put("poiname", this.f3640q);     // Catch: Throwable -> L15
        r10.put("errorCode", this.f3646w);     // Catch: Throwable -> L15
        r10.put("errorInfo", this.f3647x);     // Catch: Throwable -> L15
        r10.put("locationType", this.f3649z);     // Catch: Throwable -> L15
        r10.put("locationDetail", this.f3648y);     // Catch: Throwable -> L15
        r10.put("aoiname", this.I);     // Catch: Throwable -> L15
        r10.put(StarLocationDbManager.GeofenceEntry.ADDRESS, this.f3639p);     // Catch: Throwable -> L15
        r10.put("poiid", this.N);     // Catch: Throwable -> L15
        r10.put("floor", this.O);     // Catch: Throwable -> L15
        r10.put("description", this.L);     // Catch: Throwable -> L15
    L12:
        r10.put("time", getTime());     // Catch: Throwable -> L15
    L13:
        r10.put("provider", getProvider());     // Catch: Throwable -> L15
        r10.put("lon", getLongitude());     // Catch: Throwable -> L15
        r10.put("lat", getLatitude());     // Catch: Throwable -> L15
        r10.put(LocationMonitorConst.ACCURACY, getAccuracy());     // Catch: Throwable -> L15
        r10.put("isOffset", this.f3645v);     // Catch: Throwable -> L15
        r10.put("isFixLastLocation", this.M);     // Catch: Throwable -> L15
        r10.put("coordType", this.Q);     // Catch: Throwable -> L15
        return r10;
    L6:
        if (r8 == 2) goto L12;
        if (r8 == 3) goto L13;
        return r10;
    L15:
        th = move-exception;
        t3.g("AmapLoc", "toStr", th);
        return null;
    }

    public String z() {
        return A(1);
    }

    public AMapLocation(String r8) {
        super(r8);
        this.f3634a = "";
        this.f3635b = "";
        this.f3636m = "";
        this.f3637n = "";
        this.f3638o = "";
        this.f3639p = "";
        this.f3640q = "";
        this.f3641r = "";
        this.f3642s = "";
        this.f3643t = "";
        this.f3644u = "";
        this.f3645v = true;
        this.f3646w = 0;
        this.f3647x = "success";
        this.f3648y = "";
        this.f3649z = 0;
        this.A = 0.0d;
        this.B = 0.0d;
        this.C = 0.0d;
        this.D = 0.0f;
        this.E = 0.0f;
        this.F = null;
        this.H = 0;
        this.I = "";
        this.J = -1;
        this.K = false;
        this.L = "";
        this.M = false;
        this.N = "";
        this.O = "";
        this.P = new com.amap.api.location.a();
        this.Q = "GCJ02";
        this.R = 1;
        this.G = r8;
    }
}
