package com.bytedance.api.location;

import android.security.obric.guard.ObricSecurityGuardStub;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.entity.LocationExtraBean;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.bytedance.bdlocation.service.BDLocationExtraDataServer;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class ByteLocationClientOption {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LocationOption f1012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1013b;
    private volatile int c;
    private int d;
    private LocationMode e;
    private long f;
    private long g;
    private long h;
    private String i;
    private LocationExtraBean j;
    private String k;
    private int l;
    private boolean m;
    private boolean n;
    private Object o;
    private long p;
    private LocationTraceLogger q;
    private String r;
    private BDLocationExtraDataServer s;

    public static final enum LocationMode extends Enum<LocationMode> {
        private static final /* synthetic */ LocationMode[] $VALUES = null;
        public static final LocationMode Battery_Saving = null;
        public static final LocationMode Device_Sensors = null;
        public static final LocationMode Hight_Accuracy = null;

        static {
            LocationMode r0 = new LocationMode("Battery_Saving", 0);
            Battery_Saving = r0;
            LocationMode r1 = new LocationMode("Device_Sensors", 1);
            Device_Sensors = r1;
            LocationMode r3 = new LocationMode("Hight_Accuracy", 2);
            Hight_Accuracy = r3;
            $VALUES = new LocationMode[]{r0, r1, r3};
        }

        private LocationMode(String r1, int r2) {
            super(r1, r2);
        }

        public static LocationMode valueOf(String r2) {
            return (LocationMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(LocationMode.class, r2), LocationMode.class, "com.obric.memorydata.plugin");
        }

        public static LocationMode[] values() {
            return (LocationMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), LocationMode[].class, "com.obric.memorydata.plugin");
        }
    }

    public ByteLocationClientOption(LocationOption r3) {
        this.c = 0;
        this.d = 0;
        this.e = LocationMode.Battery_Saving;
        this.f = 10000;
        this.g = 3000;
        this.l = 1;
        this.m = true;
        this.f1012a = r3;
    }

    public long a() {
        return this.f1013b;
    }

    public void a(int r1) {
        this.d = r1;
    }

    public void a(long r4) {
        long r0 = 0;
        if (r4 > 0) goto L5;
    L4:
        this.f1013b = r0;
        return;
    L5:
        r0 = 1000;
        if (r4 < 1000) goto L4;
        this.f1013b = r4;
    }

    public void a(LocationMode r1) {
        this.e = r1;
    }

    public void a(LocationExtraBean r1) {
        this.j = r1;
    }

    public void a(LocationTraceLogger r1) {
        this.q = r1;
    }

    public void a(BDLocationExtraDataServer r1) {
        this.s = r1;
    }

    public void a(Object r1) {
        this.o = r1;
    }

    public void a(String r1) {
        this.i = r1;
    }

    public void a(boolean r1) {
        this.m = r1;
    }

    public Object b() {
        return this.o;
    }

    public void b(int r1) {
        this.l = r1;
    }

    public void b(long r1) {
        this.h = r1;
    }

    public void b(String r1) {
        this.k = r1;
    }

    public void b(boolean r1) {
        this.n = r1;
    }

    public LocationMode c() {
        return this.e;
    }

    public void c(int r1) {
        this.c = r1;
    }

    public void c(long r1) {
        this.f = r1;
    }

    public void c(String r1) {
        this.r = r1;
    }

    public String d() {
        int r0 = this.d;
        if (r0 != 0) goto L5;
        return "no";
    L5:
        if (r0 != 1) goto L7;
        return "default_accuracy";
    L7:
        return this.d + "";
    }

    public void d(long r1) {
        this.p = r1;
    }

    public long e() {
        return this.h;
    }

    public String f() {
        return this.i;
    }

    public int g() {
        return this.l;
    }

    public long h() {
        return this.f;
    }

    public int i() {
        return this.c;
    }

    public boolean j() {
        return this.m;
    }

    public String k() {
        int r0 = this.c;
        if (r0 != 0) goto L5;
        return CommonConsts.APM_INNER_EVENT_COST_INIT;
    L5:
        if (r0 != 1) goto L7;
        return "requesting_network";
    L7:
        if (r0 != 2) goto L9;
        return "requesting_gps";
    L9:
        if (r0 != 3) goto L11;
        return "requesting_both";
    L11:
        if (r0 != 5) goto L13;
        return ObricSecurityGuardStub.SettingsEventConst.EVENT_RESULT_CANCEL;
    L13:
        if (r0 != 6) goto L15;
        return "end";
    L15:
        return String.valueOf(this.c);
    }

    public boolean l() {
        return this.n;
    }

    public long m() {
        return this.p;
    }

    public LocationExtraBean n() {
        return this.j;
    }

    public String o() {
        return this.k;
    }

    public LocationTraceLogger p() {
        return this.q;
    }

    public String q() {
        return this.r;
    }

    public BDLocationExtraDataServer r() {
        return this.s;
    }
}
