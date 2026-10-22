package com.amap.api.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.entity.region.RegionBean;
import com.loc.ev;
import com.obric.cae.userAware.NearElevator.NearElevator;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class AMapLocationClientOption implements Parcelable, Cloneable {
    public static final Parcelable.Creator<AMapLocationClientOption> CREATOR = null;
    public static boolean OPEN_ALWAYS_SCAN_WIFI = false;
    public static long SCAN_WIFI_INTERVAL = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static String f476a = null;
    private static int d = 0;
    private static int e = 1;
    private static int f = 2;
    private static int g = 4;
    private static AMapLocationProtocol p;
    private boolean A;
    private int B;
    private int C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private float H;
    private AMapLocationPurpose I;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    boolean f477b;
    String c;
    private long h;
    private long i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;
    private boolean n;
    private AMapLocationMode o;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private long x;
    private long y;
    private GeoLanguage z;

    /* JADX INFO: renamed from: com.amap.api.location.AMapLocationClientOption$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f478a = null;

        static {
            int[] r0 = new int[AMapLocationPurpose.values().length];
            f478a = r0;
            r0[AMapLocationPurpose.SignIn.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f478a[AMapLocationPurpose.Transport.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f478a[AMapLocationPurpose.Sport.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static final enum AMapLocationMode extends Enum<AMapLocationMode> {
        public static final AMapLocationMode Battery_Saving = null;
        public static final AMapLocationMode Device_Sensors = null;
        public static final AMapLocationMode Hight_Accuracy = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ AMapLocationMode[] f479a = null;

        static {
            AMapLocationMode r0 = new AMapLocationMode("Battery_Saving", 0);
            Battery_Saving = r0;
            AMapLocationMode r1 = new AMapLocationMode("Device_Sensors", 1);
            Device_Sensors = r1;
            AMapLocationMode r3 = new AMapLocationMode("Hight_Accuracy", 2);
            Hight_Accuracy = r3;
            f479a = new AMapLocationMode[]{r0, r1, r3};
        }

        private AMapLocationMode(String r1, int r2) {
            super(r1, r2);
        }

        public static AMapLocationMode valueOf(String r2) {
            return (AMapLocationMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(AMapLocationMode.class, r2), AMapLocationMode.class, "com.obric.memorydata.plugin");
        }

        public static AMapLocationMode[] values() {
            return (AMapLocationMode[]) ZeusTransformUtils.preCheckCast(f479a.clone(), AMapLocationMode[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum AMapLocationProtocol extends Enum<AMapLocationProtocol> {
        public static final AMapLocationProtocol HTTP = null;
        public static final AMapLocationProtocol HTTPS = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final /* synthetic */ AMapLocationProtocol[] f480b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f481a;

        static {
            AMapLocationProtocol r0 = new AMapLocationProtocol("HTTP", 0, 0);
            HTTP = r0;
            AMapLocationProtocol r1 = new AMapLocationProtocol("HTTPS", 1, 1);
            HTTPS = r1;
            f480b = new AMapLocationProtocol[]{r0, r1};
        }

        private AMapLocationProtocol(String r1, int r2, int r3) {
            super(r1, r2);
            this.f481a = r3;
        }

        public static AMapLocationProtocol valueOf(String r2) {
            return (AMapLocationProtocol) ZeusTransformUtils.preCheckCast(Enum.valueOf(AMapLocationProtocol.class, r2), AMapLocationProtocol.class, "com.obric.memorydata.plugin");
        }

        public static AMapLocationProtocol[] values() {
            return (AMapLocationProtocol[]) ZeusTransformUtils.preCheckCast(f480b.clone(), AMapLocationProtocol[].class, "com.obric.memorydata.plugin");
        }

        public final int getValue() {
            return this.f481a;
        }
    }

    public static final enum AMapLocationPurpose extends Enum<AMapLocationPurpose> {
        public static final AMapLocationPurpose SignIn = null;
        public static final AMapLocationPurpose Sport = null;
        public static final AMapLocationPurpose Transport = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ AMapLocationPurpose[] f482a = null;

        static {
            AMapLocationPurpose r0 = new AMapLocationPurpose("SignIn", 0);
            SignIn = r0;
            AMapLocationPurpose r1 = new AMapLocationPurpose("Transport", 1);
            Transport = r1;
            AMapLocationPurpose r3 = new AMapLocationPurpose("Sport", 2);
            Sport = r3;
            f482a = new AMapLocationPurpose[]{r0, r1, r3};
        }

        private AMapLocationPurpose(String r1, int r2) {
            super(r1, r2);
        }

        public static AMapLocationPurpose valueOf(String r2) {
            return (AMapLocationPurpose) ZeusTransformUtils.preCheckCast(Enum.valueOf(AMapLocationPurpose.class, r2), AMapLocationPurpose.class, "com.obric.memorydata.plugin");
        }

        public static AMapLocationPurpose[] values() {
            return (AMapLocationPurpose[]) ZeusTransformUtils.preCheckCast(f482a.clone(), AMapLocationPurpose[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final enum GeoLanguage extends Enum<GeoLanguage> {
        public static final GeoLanguage DEFAULT = null;
        public static final GeoLanguage EN = null;
        public static final GeoLanguage ZH = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final /* synthetic */ GeoLanguage[] f483a = null;

        static {
            GeoLanguage r0 = new GeoLanguage("DEFAULT", 0);
            DEFAULT = r0;
            GeoLanguage r1 = new GeoLanguage("ZH", 1);
            ZH = r1;
            GeoLanguage r3 = new GeoLanguage("EN", 2);
            EN = r3;
            f483a = new GeoLanguage[]{r0, r1, r3};
        }

        private GeoLanguage(String r1, int r2) {
            super(r1, r2);
        }

        public static GeoLanguage valueOf(String r2) {
            return (GeoLanguage) ZeusTransformUtils.preCheckCast(Enum.valueOf(GeoLanguage.class, r2), GeoLanguage.class, "com.obric.memorydata.plugin");
        }

        public static GeoLanguage[] values() {
            return (GeoLanguage[]) ZeusTransformUtils.preCheckCast(f483a.clone(), GeoLanguage[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        p = AMapLocationProtocol.HTTP;
        f476a = "";
        CREATOR = new AnonymousClass1();
        OPEN_ALWAYS_SCAN_WIFI = true;
        SCAN_WIFI_INTERVAL = 30000;
    }

    public AMapLocationClientOption() {
        this.h = 2000;
        this.i = ev.i;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = AMapLocationMode.Hight_Accuracy;
        this.q = false;
        this.r = false;
        this.s = true;
        this.t = true;
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = 30000;
        this.y = 30000;
        this.z = GeoLanguage.DEFAULT;
        this.A = false;
        this.B = NearElevator.WIFI_SCAN_INTERVAL_WHEN_OUT_ELEVATOR;
        this.C = RegionBean.DEFAULT_EXPIRE_TIME;
        this.D = false;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = 0.0f;
        this.I = null;
        this.f477b = false;
        this.c = null;
    }

    public AMapLocationClientOption(Parcel r8) {
        this.h = 2000;
        this.i = ev.i;
        boolean r0 = false;
        this.j = false;
        this.k = true;
        this.l = true;
        this.m = true;
        this.n = true;
        this.o = AMapLocationMode.Hight_Accuracy;
        this.q = false;
        this.r = false;
        this.s = true;
        this.t = true;
        this.u = false;
        this.v = false;
        this.w = true;
        this.x = 30000;
        this.y = 30000;
        this.z = GeoLanguage.DEFAULT;
        this.A = false;
        this.B = NearElevator.WIFI_SCAN_INTERVAL_WHEN_OUT_ELEVATOR;
        this.C = RegionBean.DEFAULT_EXPIRE_TIME;
        this.D = false;
        this.E = true;
        this.F = true;
        this.G = true;
        this.H = 0.0f;
        AMapLocationPurpose r2 = null;
        this.I = null;
        this.f477b = false;
        this.c = null;
        this.h = r8.readLong();
        this.i = r8.readLong();
        if (r8.readByte() == 0) goto L5;
        boolean r3 = true;
    L6:
        this.j = r3;
        if (r8.readByte() == 0) goto L9;
        boolean r4 = true;
    L10:
        this.k = r4;
        if (r8.readByte() == 0) goto L13;
        boolean r5 = true;
    L14:
        this.l = r5;
        if (r8.readByte() == 0) goto L17;
        boolean r6 = true;
    L18:
        this.m = r6;
        if (r8.readByte() == 0) goto L21;
        boolean r7 = true;
    L22:
        this.n = r7;
        int r9 = r8.readInt();
        if (r9 != (-1)) goto L25;
        AMapLocationMode r10 = AMapLocationMode.Hight_Accuracy;
    L26:
        this.o = r10;
        if (r8.readByte() == 0) goto L29;
        boolean r11 = true;
    L30:
        this.q = r11;
        if (r8.readByte() == 0) goto L33;
        boolean r12 = true;
    L34:
        this.r = r12;
        if (r8.readByte() == 0) goto L37;
        boolean r13 = true;
    L38:
        this.D = r13;
        if (r8.readByte() == 0) goto L41;
        boolean r14 = true;
    L42:
        this.E = r14;
        if (r8.readByte() == 0) goto L45;
        boolean r15 = true;
    L46:
        this.F = r15;
        if (r8.readByte() == 0) goto L49;
        boolean r16 = true;
    L50:
        this.G = r16;
        if (r8.readByte() == 0) goto L53;
        boolean r17 = true;
    L54:
        this.s = r17;
        if (r8.readByte() == 0) goto L57;
        boolean r18 = true;
    L58:
        this.t = r18;
        if (r8.readByte() == 0) goto L61;
        boolean r19 = true;
    L62:
        this.u = r19;
        if (r8.readByte() == 0) goto L65;
        boolean r20 = true;
    L66:
        this.v = r20;
        if (r8.readByte() == 0) goto L69;
        boolean r21 = true;
    L70:
        this.w = r21;
        this.x = r8.readLong();
        int r22 = r8.readInt();
        if (r22 != (-1)) goto L73;
        AMapLocationProtocol r23 = AMapLocationProtocol.HTTP;
    L74:
        p = r23;
        int r24 = r8.readInt();
        if (r24 != (-1)) goto L77;
        GeoLanguage r25 = GeoLanguage.DEFAULT;
    L78:
        this.z = r25;
        this.H = r8.readFloat();
        int r26 = r8.readInt();
        if (r26 == (-1)) goto L82;
        r2 = AMapLocationPurpose.values()[r26];
    L82:
        this.I = r2;
        if (r8.readByte() == 0) goto L85;
        r0 = true;
    L85:
        OPEN_ALWAYS_SCAN_WIFI = r0;
        this.y = r8.readLong();
        return;
    L77:
        r25 = GeoLanguage.values()[r24];
        goto L78
    L73:
        r23 = AMapLocationProtocol.values()[r22];
        goto L74
    L69:
        r21 = false;
        goto L70
    L65:
        r20 = false;
        goto L66
    L61:
        r19 = false;
        goto L62
    L57:
        r18 = false;
        goto L58
    L53:
        r17 = false;
        goto L54
    L49:
        r16 = false;
        goto L50
    L45:
        r15 = false;
        goto L46
    L41:
        r14 = false;
        goto L42
    L37:
        r13 = false;
        goto L38
    L33:
        r12 = false;
        goto L34
    L29:
        r11 = false;
        goto L30
    L25:
        r10 = AMapLocationMode.values()[r9];
        goto L26
    L21:
        r7 = false;
        goto L22
    L17:
        r6 = false;
        goto L18
    L13:
        r5 = false;
        goto L14
    L9:
        r4 = false;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    private AMapLocationClientOption a(AMapLocationClientOption r3) {
        this.h = r3.h;
        this.j = r3.j;
        this.o = r3.o;
        this.k = r3.k;
        this.q = r3.q;
        this.r = r3.r;
        this.D = r3.D;
        this.l = r3.l;
        this.m = r3.m;
        this.i = r3.i;
        this.s = r3.s;
        this.t = r3.t;
        this.u = r3.u;
        this.v = r3.isSensorEnable();
        this.w = r3.isWifiScan();
        this.x = r3.x;
        setLocationProtocol(r3.getLocationProtocol());
        this.z = r3.z;
        setDownloadCoordinateConvertLibrary(isDownloadCoordinateConvertLibrary());
        this.H = r3.H;
        this.I = r3.I;
        setOpenAlwaysScanWifi(isOpenAlwaysScanWifi());
        setScanWifiInterval(r3.getScanWifiInterval());
        this.y = r3.y;
        this.C = r3.getCacheTimeOut();
        this.A = r3.getCacheCallBack();
        this.B = r3.getCacheCallBackTime();
        this.E = r3.isSelfStartServiceEnable();
        this.F = r3.isNoLocReqCgiEnable();
        this.G = r3.isSysNetworkLocEnable();
        return this;
    }

    public static String getAPIKEY() {
        return f476a;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return false;
    }

    public static boolean isOpenAlwaysScanWifi() {
        return OPEN_ALWAYS_SCAN_WIFI;
    }

    public static void setDownloadCoordinateConvertLibrary(boolean r0) {
    }

    public static void setLocationProtocol(AMapLocationProtocol r0) {
        p = r0;
    }

    public static void setOpenAlwaysScanWifi(boolean r0) {
        OPEN_ALWAYS_SCAN_WIFI = r0;
    }

    public static void setScanWifiInterval(long r0) {
        SCAN_WIFI_INTERVAL = r0;
    }

    public AMapLocationClientOption clone() {
        super.clone();     // Catch: Throwable -> L4
    L7:
        return new AMapLocationClientOption().a(this);
    L4:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m73clone() {
        return clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean getCacheCallBack() {
        return this.A;
    }

    public int getCacheCallBackTime() {
        return this.B;
    }

    public int getCacheTimeOut() {
        return this.C;
    }

    public float getDeviceModeDistanceFilter() {
        return this.H;
    }

    public GeoLanguage getGeoLanguage() {
        return this.z;
    }

    public long getGpsFirstTimeout() {
        return this.y;
    }

    public long getHttpTimeOut() {
        return this.i;
    }

    public long getInterval() {
        return this.h;
    }

    public long getLastLocationLifeCycle() {
        return this.x;
    }

    public AMapLocationMode getLocationMode() {
        return this.o;
    }

    public AMapLocationProtocol getLocationProtocol() {
        return p;
    }

    public AMapLocationPurpose getLocationPurpose() {
        return this.I;
    }

    public long getScanWifiInterval() {
        return SCAN_WIFI_INTERVAL;
    }

    public boolean isBeidouFirst() {
        return this.D;
    }

    public boolean isGpsFirst() {
        return this.r;
    }

    public boolean isKillProcess() {
        return this.q;
    }

    public boolean isLocationCacheEnable() {
        return this.t;
    }

    public boolean isMockEnable() {
        return this.k;
    }

    public boolean isNeedAddress() {
        return this.l;
    }

    public boolean isNoLocReqCgiEnable() {
        return this.F;
    }

    public boolean isOffset() {
        return this.s;
    }

    public boolean isOnceLocation() {
        return this.j;
    }

    public boolean isOnceLocationLatest() {
        return this.u;
    }

    public boolean isSelfStartServiceEnable() {
        return this.E;
    }

    public boolean isSensorEnable() {
        return this.v;
    }

    public boolean isSysNetworkLocEnable() {
        return this.G;
    }

    public boolean isWifiActiveScan() {
        return this.m;
    }

    public boolean isWifiScan() {
        return this.w;
    }

    public AMapLocationClientOption setBeidouFirst(boolean r1) {
        this.D = r1;
        return this;
    }

    public void setCacheCallBack(boolean r1) {
        this.A = r1;
    }

    public void setCacheCallBackTime(int r1) {
        this.B = r1;
    }

    public void setCacheTimeOut(int r1) {
        this.C = r1;
    }

    public AMapLocationClientOption setDeviceModeDistanceFilter(float r3) {
        if (r3 >= 0.0f) goto L5;
        r3 = 0.0f;
    L5:
        this.H = r3;
        return this;
    }

    public AMapLocationClientOption setGeoLanguage(GeoLanguage r1) {
        this.z = r1;
        return this;
    }

    public AMapLocationClientOption setGpsFirst(boolean r1) {
        this.r = r1;
        return this;
    }

    public AMapLocationClientOption setGpsFirstTimeout(long r4) {
        if (r4 >= 5000) goto L6;
        r4 = 5000;
    L6:
        if (r4 <= 30000) goto L8;
        r4 = 30000;
    L8:
        this.y = r4;
        return this;
    }

    public AMapLocationClientOption setHttpTimeOut(long r1) {
        this.i = r1;
        return this;
    }

    public AMapLocationClientOption setInterval(long r4) {
        if (r4 > 800) goto L5;
        r4 = 800;
    L5:
        this.h = r4;
        return this;
    }

    public AMapLocationClientOption setKillProcess(boolean r1) {
        this.q = r1;
        return this;
    }

    public AMapLocationClientOption setLastLocationLifeCycle(long r1) {
        this.x = r1;
        return this;
    }

    public AMapLocationClientOption setLocationCacheEnable(boolean r1) {
        this.t = r1;
        return this;
    }

    public AMapLocationClientOption setLocationMode(AMapLocationMode r1) {
        this.o = r1;
        return this;
    }

    public AMapLocationClientOption setLocationPurpose(AMapLocationPurpose r5) {
        this.I = r5;
        if (r5 == null) goto L22;
        int r6 = AnonymousClass2.f478a[r5.ordinal()];
        if (r6 != 1) goto L7;
        this.o = AMapLocationMode.Hight_Accuracy;
        this.j = true;
        this.u = true;
        this.r = false;
        this.D = false;
        this.k = false;
        this.w = true;
        this.E = true;
        this.F = true;
        this.G = true;
        int r7 = d;
        int r0 = e;
        if ((r7 & r0) != 0) goto L22;
        this.f477b = true;
        d = r7 | r0;
        this.c = "signin";
        goto L22
    L7:
        if (r6 != 2) goto L9;
        int r8 = d;
        int r2 = f;
        if ((r8 & r2) != 0) goto L18;
        this.f477b = true;
        d = r8 | r2;
        String r9 = NotificationCompat.CATEGORY_TRANSPORT;
    L17:
        this.c = r9;
    L18:
        this.o = AMapLocationMode.Hight_Accuracy;
        this.j = false;
        this.u = false;
        this.r = true;
        this.D = false;
        this.E = true;
        this.F = true;
        this.G = true;
        this.k = false;
        this.w = true;
        goto L22
    L9:
        if (r6 != 3) goto L22;
        int r10 = d;
        int r3 = g;
        if ((r10 & r3) != 0) goto L18;
        this.f477b = true;
        d = r10 | r3;
        r9 = "sport";
    L22:
        return this;
    }

    public AMapLocationClientOption setMockEnable(boolean r1) {
        this.k = r1;
        return this;
    }

    public AMapLocationClientOption setNeedAddress(boolean r1) {
        this.l = r1;
        return this;
    }

    public void setNoLocReqCgiEnable(boolean r1) {
        this.F = r1;
    }

    public AMapLocationClientOption setOffset(boolean r1) {
        this.s = r1;
        return this;
    }

    public AMapLocationClientOption setOnceLocation(boolean r1) {
        this.j = r1;
        return this;
    }

    public AMapLocationClientOption setOnceLocationLatest(boolean r1) {
        this.u = r1;
        return this;
    }

    public void setSelfStartServiceEnable(boolean r1) {
        this.E = r1;
    }

    public AMapLocationClientOption setSensorEnable(boolean r1) {
        this.v = r1;
        return this;
    }

    public void setSysNetworkLocEnable(boolean r1) {
        this.G = r1;
    }

    public AMapLocationClientOption setWifiActiveScan(boolean r1) {
        this.m = r1;
        this.n = r1;
        return this;
    }

    public AMapLocationClientOption setWifiScan(boolean r1) {
        this.w = r1;
        if (r1 == false) goto L5;
        boolean r2 = this.n;
    L6:
        this.m = r2;
        return this;
    L5:
        r2 = false;
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("interval:").append(String.valueOf(this.h)).append("#");
        r0.append("isOnceLocation:").append(String.valueOf(this.j)).append("#");
        r0.append("locationMode:").append(String.valueOf(this.o)).append("#");
        r0.append("locationProtocol:").append(String.valueOf(p)).append("#");
        r0.append("isMockEnable:").append(String.valueOf(this.k)).append("#");
        r0.append("isKillProcess:").append(String.valueOf(this.q)).append("#");
        r0.append("isGpsFirst:").append(String.valueOf(this.r)).append("#");
        r0.append("isBeidouFirst:").append(String.valueOf(this.D)).append("#");
        r0.append("isSelfStartServiceEnable:").append(String.valueOf(this.E)).append("#");
        r0.append("noLocReqCgiEnable:").append(String.valueOf(this.F)).append("#");
        r0.append("sysNetworkLocEnable:").append(String.valueOf(this.G)).append("#");
        r0.append("isNeedAddress:").append(String.valueOf(this.l)).append("#");
        r0.append("isWifiActiveScan:").append(String.valueOf(this.m)).append("#");
        r0.append("wifiScan:").append(String.valueOf(this.w)).append("#");
        r0.append("httpTimeOut:").append(String.valueOf(this.i)).append("#");
        r0.append("isLocationCacheEnable:").append(String.valueOf(this.t)).append("#");
        r0.append("isOnceLocationLatest:").append(String.valueOf(this.u)).append("#");
        r0.append("sensorEnable:").append(String.valueOf(this.v)).append("#");
        r0.append("geoLanguage:").append(String.valueOf(this.z)).append("#");
        r0.append("locationPurpose:").append(String.valueOf(this.I)).append("#");
        r0.append("callback:").append(String.valueOf(this.A)).append("#");
        r0.append("time:").append(String.valueOf(this.B)).append("#");
        return r0.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        r4.writeLong(this.h);
        r4.writeLong(this.i);
        r4.writeByte(this.j ? 1 : 0);
        r4.writeByte(this.k ? 1 : 0);
        r4.writeByte(this.l ? 1 : 0);
        r4.writeByte(this.m ? 1 : 0);
        r4.writeByte(this.n ? 1 : 0);
        AMapLocationMode r6 = this.o;
        int r0 = -1;
        if (r6 != null) goto L5;
        int r7 = -1;
    L6:
        r4.writeInt(r7);
        r4.writeByte(this.q ? 1 : 0);
        r4.writeByte(this.r ? 1 : 0);
        r4.writeByte(this.D ? 1 : 0);
        r4.writeByte(this.E ? 1 : 0);
        r4.writeByte(this.F ? 1 : 0);
        r4.writeByte(this.G ? 1 : 0);
        r4.writeByte(this.s ? 1 : 0);
        r4.writeByte(this.t ? 1 : 0);
        r4.writeByte(this.u ? 1 : 0);
        r4.writeByte(this.v ? 1 : 0);
        r4.writeByte(this.w ? 1 : 0);
        r4.writeLong(this.x);
        if (p != null) goto L9;
        int r8 = -1;
    L10:
        r4.writeInt(r8);
        GeoLanguage r9 = this.z;
        if (r9 != null) goto L13;
        int r10 = -1;
    L14:
        r4.writeInt(r10);
        r4.writeFloat(this.H);
        AMapLocationPurpose r11 = this.I;
        if (r11 == null) goto L18;
        r0 = r11.ordinal();
    L18:
        r4.writeInt(r0);
        r4.writeInt(OPEN_ALWAYS_SCAN_WIFI ? 1 : 0);
        r4.writeLong(this.y);
        return;
    L13:
        r10 = r9.ordinal();
        goto L14
    L9:
        r8 = getLocationProtocol().ordinal();
        goto L10
    L5:
        r7 = r6.ordinal();
        goto L6
    }
}
