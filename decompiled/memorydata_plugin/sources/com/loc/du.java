package com.loc;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthNr;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: loaded from: classes3.dex */
public final class du {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    ArrayList<dt> f5468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    TelephonyManager f5469b;
    PhoneStateListener c;
    SignalStrength d;
    boolean e;
    StringBuilder f;
    String g;
    private Context h;
    private boolean i;
    private boolean j;
    private String k;
    private ArrayList<dt> l;
    private ds m;
    private long n;
    private boolean o;
    private Object p;
    private TelephonyManager.CellInfoCallback q;
    private boolean r;
    private String s;
    private String t;
    private volatile boolean u;
    private volatile boolean v;
    private volatile boolean w;
    private dm x;

    class a extends TelephonyManager.CellInfoCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ du f5470a;

        a(du r1) {
            this.f5470a = r1;
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(List<CellInfo> r5) {
            List<CellInfo> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Object[] r1 = new Object[2];     // Catch: Throwable -> L13 SecurityException -> L16
            ex.a();     // Catch: Throwable -> L13 SecurityException -> L16
            Object[] r0 = new Object[2];     // Catch: Throwable -> L13 SecurityException -> L16
            String r2 = "noLocReqCgiEnable:" + du.a(this.f5470a) + " isStartLocation:" + du.b(this.f5470a);     // Catch: Throwable -> L13 SecurityException -> L16
            ex.a();     // Catch: Throwable -> L13 SecurityException -> L16
            if (du.a(this.f5470a) == true) goto L9;
            if (du.b(this.f5470a) == true) goto L9;
            return;
        L9:
            if ((fd.b() - du.c(this.f5470a)) >= 500) goto L11;
            return;
        L11:
            du.d(this.f5470a);     // Catch: Throwable -> L13 SecurityException -> L16
            du.a(this.f5470a, du.e(this.f5470a));     // Catch: Throwable -> L13 SecurityException -> L16
            this.f5470a.a(r6);     // Catch: Throwable -> L13 SecurityException -> L16
            du.a(this.f5470a, fd.b());     // Catch: Throwable -> L13 SecurityException -> L16
            return;
        L16:
            e = move-exception;
            this.f5470a.g = e.getMessage();
            return;
        L13:
            th = move-exception;
            ev.a(th, "Cgi", "cellInfo");
        }
    }

    class b extends PhoneStateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ du f5471a;

        b(du r1) {
            this.f5471a = r1;
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellInfoChanged(List<CellInfo> r5) {
            List<CellInfo> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            Object[] r1 = new Object[2];     // Catch: Throwable -> L16
            ex.a();     // Catch: Throwable -> L16
            Object[] r0 = new Object[2];     // Catch: Throwable -> L16
            String r2 = "noLocReqCgiEnable:" + du.a(this.f5471a) + " isStartLocation:" + du.b(this.f5471a);     // Catch: Throwable -> L16
            ex.a();     // Catch: Throwable -> L16
            if (du.a(this.f5471a) == true) goto L9;
            if (du.b(this.f5471a) == true) goto L9;
            return;
        L9:
            if (du.g(this.f5471a) == null) goto L12;
            du.g(this.f5471a).c();     // Catch: Throwable -> L16
        L12:
            if ((fd.b() - du.c(this.f5471a)) >= 500) goto L14;
            return;
        L14:
            du.a(this.f5471a, du.e(this.f5471a));     // Catch: Throwable -> L16
            this.f5471a.a(r6);     // Catch: Throwable -> L16
            du.a(this.f5471a, fd.b());     // Catch: Throwable -> L16
            return;
        L16:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellLocationChanged(CellLocation r5) {
            Object[] r1 = new Object[2];
            ex.a();
            Object[] r0 = new Object[2];
            String r2 = "noLocReqCgiEnable:" + du.a(this.f5471a) + " isStartLocation:" + du.b(this.f5471a);
            ex.a();
            if (du.a(this.f5471a) == true) goto L8;
            if (du.b(this.f5471a) == true) goto L8;
            return;
        L8:
            if ((fd.b() - du.c(this.f5471a)) >= 500) goto L15;
            return;
        L15:
            du.a(this.f5471a, r5);     // Catch: Throwable -> L12
            this.f5471a.a(du.f(this.f5471a));     // Catch: Throwable -> L12
            du.a(this.f5471a, fd.b());     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onDataConnectionStateChanged(int r1) {
            super.onDataConnectionStateChanged(r1);
            Object[] r0 = new Object[2];
            ex.a();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onServiceStateChanged(ServiceState r3) {
            Object[] r1 = new Object[2];     // Catch: Throwable -> L17
            ex.a();     // Catch: Throwable -> L17
            Object[] r0 = new Object[2];     // Catch: Throwable -> L17
            String r2 = "noLocReqCgiEnable:" + du.a(this.f5471a) + " isStartLocation:" + du.b(this.f5471a);     // Catch: Throwable -> L17
            ex.a();     // Catch: Throwable -> L17
            if (du.a(this.f5471a) == false) goto L6;
        L8:
            int r4 = r3.getState();     // Catch: Throwable -> L17
            if (r4 != 0) goto L11;
            this.f5471a.a(false, false);     // Catch: Throwable -> L17
            return;
        L11:
            if (r4 != 1) goto L19;
            this.f5471a.j();     // Catch: Throwable -> L17
            return;
        L19:
            return;
        L6:
            if (du.b(this.f5471a) == true) goto L8;
            return;
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthChanged(int r1) {
            super.onSignalStrengthChanged(r1);
            Object[] r0 = new Object[2];
            ex.a();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthsChanged(SignalStrength r3) {
            Object[] r1 = new Object[2];
            ex.a();
            Object[] r0 = new Object[2];
            String r2 = "noLocReqCgiEnable:" + du.a(this.f5471a) + " isStartLocation:" + du.b(this.f5471a);
            ex.a();
            if (r3 != null) goto L5;
            return;
        L5:
            this.f5471a.d = r3;
            if (du.a(this.f5471a) == false) goto L8;
        L15:
            if (du.g(this.f5471a) == null) goto L17;
            du.g(this.f5471a).c();     // Catch: Throwable -> L14
            return;
        L17:
            return;
        L18:
            return;
        L8:
            if (du.b(this.f5471a) == true) goto L15;
        }
    }

    public du(Context r6, Handler r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        this.i = false;
        this.j = false;
        this.f5468a = new ArrayList();
        this.k = null;
        this.l = new ArrayList();
        this.f5469b = null;
        this.m = null;
        this.n = 0;
        this.c = null;
        this.o = false;
        this.p = new Object();
        this.r = false;
        this.e = false;
        this.f = null;
        this.s = null;
        this.t = null;
        this.g = null;
        this.u = true;
        this.v = true;
        this.w = false;
        Object[] r0 = new Object[2];
        ex.a();
        Context r1 = ZeusTransformUtils.wrapperContext(r8, "com.obric.memorydata.plugin");
        this.h = r1;
        if (this.f5469b != null) goto L5;
        this.f5469b = (TelephonyManager) ZeusTransformUtils.preCheckCast(fd.a(r1, MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");
    L5:
        o();
        ds r2 = new ds(r8, "cellAge", r7);
        this.m = r2;
        r2.a();
    }

    static /* synthetic */ long a(du r0, long r1) {
        r0.n = r1;
        return r1;
    }

    private static dt a(int r1, boolean r2, int r3, int r4, int r5, int r6, int r7) {
        dt r0 = new dt(r1, r2);
        r0.f5466a = r3;
        r0.f5467b = r4;
        r0.c = r5;
        r0.d = r6;
        r0.k = r7;
        return r0;
    }

    private dt a(CellInfoCdma r11, boolean r12) {
        if (r11 != null) goto L5;
    L21:
        return null;
    L5:
        if (r11.getCellIdentity() == null) goto L21;
        CellIdentityCdma r1 = r11.getCellIdentity();
        if (r1.getSystemId() <= 0) goto L21;
        if (r1.getNetworkId() < 0) goto L21;
        if (r1.getBasestationId() < 0) goto L21;
        CellIdentityCdma r0 = r11.getCellIdentity();
        String[] r10 = fd.a(this.f5469b);
        int r2 = 0;
        int r3 = Integer.parseInt(r10[0]);     // Catch: Throwable -> L18
        r2 = Integer.parseInt(r10[1]);     // Catch: Throwable -> L22
    L19:
        dt r13 = a(2, r12, r3, r2, 0, 0, r11.getCellSignalStrength().getCdmaDbm());
        r13.h = r0.getSystemId();
        r13.i = r0.getNetworkId();
        r13.j = r0.getBasestationId();
        r13.f = r0.getLatitude();
        r13.g = r0.getLongitude();
        r13.s = r11.getCellSignalStrength().getCdmaDbm();
        return r13;
    L18:
        r3 = 0;
        goto L19
    }

    private static dt a(CellInfoGsm r8, boolean r9) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (r8.getCellIdentity() == null) goto L10;
        CellIdentityGsm r0 = r8.getCellIdentity();
        dt r10 = a(1, r9, r0.getMcc(), r0.getMnc(), r0.getLac(), r0.getCid(), r8.getCellSignalStrength().getDbm());
        r10.o = r8.getCellIdentity().getBsic();
        r10.p = r8.getCellIdentity().getArfcn();
        r10.q = r8.getCellSignalStrength().getTimingAdvance();
        r10.s = r8.getCellSignalStrength().getDbm();
        return r10;
    L10:
        return null;
    }

    private static dt a(CellInfoLte r8, boolean r9) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (r8.getCellIdentity() == null) goto L13;
        CellIdentityLte r0 = r8.getCellIdentity();
        dt r10 = a(3, r9, r0.getMcc(), r0.getMnc(), r0.getTac(), r0.getCi(), r8.getCellSignalStrength().getDbm());
        r10.o = r0.getPci();
        if (Build.VERSION.SDK_INT < 24) goto L9;
        r10.p = r0.getEarfcn();
    L9:
        r10.q = r8.getCellSignalStrength().getTimingAdvance();
        r10.s = r8.getCellSignalStrength().getDbm();
        return r10;
    L13:
        return null;
    }

    private static dt a(CellInfoNr r15, boolean r16) {
        if (r15 != null) goto L4;
        return null;
    L4:
        if (r15.getCellIdentity() == null) goto L40;
        CellIdentityNr r1 = (CellIdentityNr) ZeusTransformUtils.preCheckCast(r15.getCellIdentity(), CellIdentityNr.class, "com.obric.memorydata.plugin");
        int r3 = r1.getTac();
        int r4 = 0;
        if (r3 == Integer.MAX_VALUE) goto L9;
    L15:
        long r5 = r1.getNci();
        int r7 = Integer.parseInt(r1.getMccString());     // Catch: Throwable -> L21
        r4 = Integer.parseInt(r1.getMncString());     // Catch: Throwable -> L19
    L24:
        dt r0 = a(5, r16, r7, r4, r1.getTac(), 0, ((CellSignalStrengthNr) ZeusTransformUtils.preCheckCast(r15.getCellSignalStrength(), CellSignalStrengthNr.class, "com.obric.memorydata.plugin")).getSsRsrp());
        r0.e = r5;
        if (r3 <= 16777215) goto L27;
        r0.c = 65535;
    L30:
        r0.o = r1.getPci();
        r0.p = r1.getNrarfcn();
        r0.s = r15.getCellSignalStrength().getDbm();
        return r0;
    L27:
        if (r3 <= 65535) goto L29;
        r0.c = 65535;
        r0.q = r3;
        goto L30
    L29:
        r0.c = r3;
    L19:
        th = th;
    L23:
        th.printStackTrace();
    L21:
        th = th;
        r7 = 0;
        goto L23
    L9:
        if ("HUAWEI".equals(Build.MANUFACTURER) == false) goto L15;
        r3 = ez.b(r1, "getHwTac", new Object[0]);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    L40:
        return null;
    }

    private static dt a(CellInfoWcdma r8, boolean r9) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (r8.getCellIdentity() == null) goto L10;
        CellIdentityWcdma r0 = r8.getCellIdentity();
        dt r10 = a(4, r9, r0.getMcc(), r0.getMnc(), r0.getLac(), r0.getCid(), r8.getCellSignalStrength().getDbm());
        r10.o = r0.getPsc();
        r10.p = r8.getCellIdentity().getUarfcn();
        r10.s = r8.getCellSignalStrength().getDbm();
        return r10;
    L10:
        return null;
    }

    private synchronized void a(CellLocation r6) {
        monitor-enter(this);
        String[] r0 = fd.a(this.f5469b);     // Catch: Throwable -> L23
        this.f5468a.clear();     // Catch: Throwable -> L23
        if (ZeusTransformUtils.instanceOf(r6, GsmCellLocation.class) == false) goto L16;
        GsmCellLocation r7 = (GsmCellLocation) ZeusTransformUtils.preCheckCast(r6, GsmCellLocation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        dt r1 = new dt(1, true);     // Catch: Throwable -> L23
        r1.f5466a = fd.e(r0[0]);     // Catch: Throwable -> L23
        r1.f5467b = fd.e(r0[1]);     // Catch: Throwable -> L23
        r1.c = r7.getLac();     // Catch: Throwable -> L23
        r1.d = r7.getCid();     // Catch: Throwable -> L23
        SignalStrength r8 = this.d;     // Catch: Throwable -> L23
        if (r8 == null) goto L12;
        int r9 = r8.getGsmSignalStrength();     // Catch: Throwable -> L23
        if (r9 != 99) goto L10;
        int r10 = Integer.MAX_VALUE;
    L11:
        r1.s = r10;     // Catch: Throwable -> L23
        goto L12
    L10:
        r10 = b(r9);     // Catch: Throwable -> L23
    L12:
        r1.r = false;     // Catch: Throwable -> L23
        this.m.a(r1);     // Catch: Throwable -> L23
        this.f5468a.add(r1);     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L16:
        if (ZeusTransformUtils.instanceOf(r6, CdmaCellLocation.class) == false) goto L21;
        CdmaCellLocation r11 = (CdmaCellLocation) ZeusTransformUtils.preCheckCast(r6, CdmaCellLocation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        dt r2 = new dt(2, true);     // Catch: Throwable -> L23
        r2.f5466a = Integer.parseInt(r0[0]);     // Catch: Throwable -> L23
        r2.f5467b = Integer.parseInt(r0[1]);     // Catch: Throwable -> L23
        r2.f = r11.getBaseStationLatitude();     // Catch: Throwable -> L23
        r2.g = r11.getBaseStationLongitude();     // Catch: Throwable -> L23
        r2.h = r11.getSystemId();     // Catch: Throwable -> L23
        r2.i = r11.getNetworkId();     // Catch: Throwable -> L23
        r2.j = r11.getBaseStationId();     // Catch: Throwable -> L23
        SignalStrength r12 = this.d;     // Catch: Throwable -> L23
        if (r12 == null) goto L20;
        r2.s = r12.getCdmaDbm();     // Catch: Throwable -> L23
    L20:
        r2.r = false;     // Catch: Throwable -> L23
        this.m.a(r2);     // Catch: Throwable -> L23
        this.f5468a.add(r2);     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    static /* synthetic */ void a(du r0, CellLocation r1) {
        r0.a(r1);
    }

    public static boolean a(int r1) {
        if (r1 > 0) goto L4;
        return false;
    L4:
        if (r1 > 15) goto L10;
        return true;
    L10:
        return false;
    }

    static /* synthetic */ boolean a(du r0) {
        return r0.v;
    }

    private static int b(int r0) {
        return (r0 * 2) + NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH;
    }

    private void b(boolean r5, boolean r6) {
        if (this.e == false) goto L5;
    L27:
        this.j = false;
        TelephonyManager r7 = this.f5469b;
        if (r7 == null) goto L32;
        String r8 = r7.getNetworkOperator();
        this.k = r8;
        if (TextUtils.isEmpty(r8) == true) goto L32;
        this.j = true;
    L32:
        this.n = fd.b();
        return;
    L5:
        if (this.f5469b == null) goto L27;
        if (Build.VERSION.SDK_INT < 29) goto L27;
        if (this.h.getApplicationInfo().targetSdkVersion < 29) goto L27;
        if (this.q != null) goto L35;
        this.q = new a(this);
    L35:
        this.f5469b.requestCellInfoUpdate(bp.a().b(), this.q);     // Catch: Throwable -> L15
    L17:
        if (r6 == true) goto L19;
        if (r5 == false) goto L27;
    L19:
        int r9 = 0;
    L21:
        if (this.r == true) goto L27;
        if (r9 >= 20) goto L27;
        Thread.sleep(5);     // Catch: Throwable -> L34
    L26:
        r9 = r9 + 1;
    L15:
        th = move-exception;
        ev.a(th, "Cgi", "refreshCgi");
        goto L17
    }

    static /* synthetic */ boolean b(du r0) {
        return r0.u;
    }

    static /* synthetic */ long c(du r2) {
        return r2.n;
    }

    static /* synthetic */ boolean d(du r1) {
        r1.r = true;
        return true;
    }

    static /* synthetic */ CellLocation e(du r0) {
        return r0.v();
    }

    static /* synthetic */ List f(du r0) {
        return r0.w();
    }

    static /* synthetic */ dm g(du r0) {
        return r0.x;
    }

    private void o() {
        if (this.f5469b != null) goto L5;
        return;
    L5:
        p();
    }

    private void p() {
    L41:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.c != null) goto L5;
        this.c = new b(this);     // Catch: Exception -> L41
    L5:
        int r0 = 320;
        String r2 = "hasFineLocPerm";
        if (Build.VERSION.SDK_INT >= 31) goto L9;
    L12:
        ex.b();     // Catch: Exception -> L41
        r0 = 336;
    L14:
        if (Build.VERSION.SDK_INT >= 17) goto L16;
    L37:
        PhoneStateListener r1 = this.c;     // Catch: Exception -> L41
        if (r1 == null) goto L46;
        this.f5469b.listen(r1, r0);     // Catch: Exception -> L41
        this.w = true;     // Catch: Exception -> L41
        return;
    L46:
        return;
    L16:
        if (Build.VERSION.SDK_INT < 31) goto L36;
        boolean r5 = false;
        if (this.h.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) goto L20;
        boolean r3 = true;
    L22:
        if (this.h.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) goto L24;
        r5 = true;
    L24:
        if (r3 == false) goto L27;
        if (r5 == false) goto L27;
        r0 = r0 | 1024;     // Catch: Exception -> L41
    L27:
        ex.b();     // Catch: Exception -> L41
        if (r3 == false) goto L30;
        String r4 = "hasReadPhoneStatePerm";
    L31:
        this.s = r4;     // Catch: Exception -> L41
        if (r5 == true) goto L35;
        r2 = "hasNoFineLocPerm";
    L35:
        this.t = r2;     // Catch: Exception -> L41
        new StringBuilder("CgiManager | mLFLPerm = ").append(this.t).append(";mLRPSPerm = ").append(this.s);     // Catch: Exception -> L41
        ex.b();     // Catch: Exception -> L41
        goto L37
    L30:
        r4 = "hasNoReadPhoneStatePerm";
        goto L31
    L20:
        r3 = false;
        goto L22
    L36:
        ex.b();     // Catch: Exception -> L41
        r0 = r0 | 1024;     // Catch: Exception -> L41
        goto L37
    L9:
        if (this.h.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) goto L11;
        this.t = "hasFineLocPerm";     // Catch: Exception -> L41
        goto L12
    L11:
        this.t = "hasNoFineLocPerm";     // Catch: Exception -> L41
        ex.b();     // Catch: Exception -> L41
        goto L14
    }

    private int q() {
        dt r0 = e();
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.l;
    }

    private CellLocation r() {
        TelephonyManager r0 = this.f5469b;
        if (r0 != null) goto L11;
    L10:
        return null;
    L11:
        CellLocation r1 = r0.getCellLocation();     // Catch: Throwable -> L6 SecurityException -> L8
        Object[] r2 = new Object[2];     // Catch: Throwable -> L6 SecurityException -> L8
        ex.a();     // Catch: Throwable -> L6 SecurityException -> L8
        this.g = null;     // Catch: Throwable -> L6 SecurityException -> L8
        return r1;
    L8:
        e = move-exception;
        this.g = e.getMessage();
    L6:
        th = move-exception;
        this.g = null;
        ev.a(th, "CgiManager", "getCellLocation");
        goto L10
    }

    private List<CellInfo> s() {
        TelephonyManager r1 = this.f5469b;
        if (r1 == null) goto L6;
        List<CellInfo> r2 = r1.getAllCellInfo();
        Object[] r0 = new Object[2];
        ex.a();
        return r2;
    L6:
        return null;
    }

    private boolean t() {
        if (this.e == false) goto L6;
        return false;
    L6:
        if ((fd.b() - this.n) < 45000) goto L11;
        return true;
    L11:
        return false;
    }

    private void u() {
        TelephonyManager r0 = this.f5469b;
        if (r0 == null) goto L11;
        PhoneStateListener r1 = this.c;
        if (r1 == null) goto L11;
        r0.listen(r1, 0);     // Catch: Throwable -> L9
        this.w = false;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        ev.a(th, "CgiManager", "destroy");
    L11:
        this.c = null;
    }

    private CellLocation v() {
        if (this.f5469b != null) goto L7;
        return null;
    L7:
        return r();
    }

    private List<CellInfo> w() {
    L18:
        th = move-exception;
        ev.a(th, "Cgi", "getNewCells");
        return null;
    L4:
        if (fd.c() >= 18) goto L7;
        return null;
    L7:
        if (this.f5469b != null) goto L24;
        return null;
    L24:
        List<CellInfo> r1 = s();     // Catch: SecurityException -> L14 Throwable -> L18
        this.g = null;     // Catch: SecurityException -> L12 Throwable -> L18
    L17:
        return r1;
    L12:
        e = e;
    L16:
        this.g = e.getMessage();     // Catch: Throwable -> L18
    L14:
        e = e;
        r1 = null;
        goto L16
    }

    public final List<dv> a() {
        ArrayList r0 = new ArrayList();
        List<CellInfo> r7 = s();
        if (Build.VERSION.SDK_INT < 17) goto L30;
        if (r7 == null) goto L30;
        Iterator<CellInfo> r8 = r7.iterator();
    L7:
        if (r8.hasNext() == false) goto L30;
        CellInfo r1 = (CellInfo) ZeusTransformUtils.preCheckCast(r8.next(), CellInfo.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r1, CellInfoCdma.class) == true) goto L10;
        if (ZeusTransformUtils.instanceOf(r1, CellInfoGsm.class) == true) goto L13;
        if (ZeusTransformUtils.instanceOf(r1, CellInfoLte.class) == false) goto L24;
        CellInfoLte r2 = (CellInfoLte) ZeusTransformUtils.preCheckCast(r1, CellInfoLte.class, "com.obric.memorydata.plugin");
        CellIdentityLte r3 = r2.getCellIdentity();
        dy r4 = new dy(r1.isRegistered());
        r4.f5472a = String.valueOf(r3.getMcc());
        r4.f5473b = String.valueOf(r3.getMnc());
        r4.l = r3.getPci();
        r4.d = r2.getCellSignalStrength().getAsuLevel();
        r4.k = r3.getCi();
        r4.j = r3.getTac();
        r4.n = r2.getCellSignalStrength().getTimingAdvance();
        r4.c = r2.getCellSignalStrength().getDbm();
        if (Build.VERSION.SDK_INT < 24) goto L22;
        r4.m = r3.getEarfcn();
    L22:
        r0.add(r4);
        goto L7
    L24:
        if (Build.VERSION.SDK_INT < 18) goto L7;
        if (ZeusTransformUtils.instanceOf(r1, CellInfoWcdma.class) == false) goto L7;
        CellInfoWcdma r5 = (CellInfoWcdma) ZeusTransformUtils.preCheckCast(r1, CellInfoWcdma.class, "com.obric.memorydata.plugin");
        CellIdentityWcdma r6 = r5.getCellIdentity();
        dz r9 = new dz(r1.isRegistered(), true);
        r9.f5472a = String.valueOf(r6.getMcc());
        r9.f5473b = String.valueOf(r6.getMnc());
        r9.j = r6.getLac();
        r9.k = r6.getCid();
        r9.l = r6.getPsc();
        r9.d = r5.getCellSignalStrength().getAsuLevel();
        r9.c = r5.getCellSignalStrength().getDbm();
        Object r10 = r9;
        if (Build.VERSION.SDK_INT >= 24) goto L29;
    L16:
        r0.add(r10);
        goto L7
    L29:
        r9.m = r6.getUarfcn();
        r10 = r9;
        goto L16
    L13:
        CellInfoGsm r11 = (CellInfoGsm) ZeusTransformUtils.preCheckCast(r1, CellInfoGsm.class, "com.obric.memorydata.plugin");
        CellIdentityGsm r12 = r11.getCellIdentity();
        dx r13 = new dx(r1.isRegistered(), true);
        r13.f5472a = String.valueOf(r12.getMcc());
        r13.f5473b = String.valueOf(r12.getMnc());
        r13.j = r12.getLac();
        r13.k = r12.getCid();
        r13.c = r11.getCellSignalStrength().getDbm();
        r13.d = r11.getCellSignalStrength().getAsuLevel();
        r10 = r13;
        if (Build.VERSION.SDK_INT < 24) goto L16;
        r13.m = r12.getArfcn();
        r13.n = r12.getBsic();
        r10 = r13;
        goto L16
    L10:
        CellInfoCdma r14 = (CellInfoCdma) ZeusTransformUtils.preCheckCast(r1, CellInfoCdma.class, "com.obric.memorydata.plugin");
        CellIdentityCdma r15 = r14.getCellIdentity();
        dw r16 = new dw(r1.isRegistered(), true);
        r16.m = r15.getLatitude();
        r16.n = r15.getLongitude();
        r16.j = r15.getSystemId();
        r16.k = r15.getNetworkId();
        r16.l = r15.getBasestationId();
        r16.d = r14.getCellSignalStrength().getAsuLevel();
        r16.c = r14.getCellSignalStrength().getCdmaDbm();
        r0.add(r16);
    L30:
        return r0;
    }

    public final void a(dm r1) {
        this.x = r1;
    }

    final synchronized void a(List<CellInfo> r10) {
        monitor-enter(this);
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        ArrayList<dt> r0 = this.l;     // Catch: Throwable -> L44
        if (r0 == null) goto L6;
        r0.clear();     // Catch: Throwable -> L44
    L6:
        if (r11 != null) goto L8;
    L42:
        monitor-exit(this);
        return;
    L8:
        if (r11.size() <= 0) goto L42;
        int r1 = 0;
    L12:
        if (r1 >= r11.size()) goto L35;
        CellInfo r2 = (CellInfo) ZeusTransformUtils.preCheckCast(r11.get(r1), CellInfo.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        if (r2 == null) goto L34;
        dt r4 = null;
        boolean r5 = r2.isRegistered();     // Catch: Throwable -> L44
        if (ZeusTransformUtils.instanceOf(r2, CellInfoCdma.class) == false) goto L19;
        r4 = a((CellInfoCdma) ZeusTransformUtils.preCheckCast(r2, CellInfoCdma.class, "com.obric.memorydata.plugin"), r5);     // Catch: Throwable -> L44
    L32:
        if (r4 == null) goto L34;
        this.m.a(r4);     // Catch: Throwable -> L44
        r4.m = (short) Math.min(WebSocketProtocol.PAYLOAD_SHORT_MAX, this.m.e(r4));     // Catch: Throwable -> L44
        r4.r = true;     // Catch: Throwable -> L44
        this.l.add(r4);     // Catch: Throwable -> L44
        goto L34
    L19:
        if (ZeusTransformUtils.instanceOf(r2, CellInfoGsm.class) == false) goto L22;
        r4 = a((CellInfoGsm) ZeusTransformUtils.preCheckCast(r2, CellInfoGsm.class, "com.obric.memorydata.plugin"), r5);     // Catch: Throwable -> L44
        goto L32
    L22:
        if (ZeusTransformUtils.instanceOf(r2, CellInfoWcdma.class) == false) goto L25;
        r4 = a((CellInfoWcdma) ZeusTransformUtils.preCheckCast(r2, CellInfoWcdma.class, "com.obric.memorydata.plugin"), r5);     // Catch: Throwable -> L44
        goto L32
    L25:
        if (ZeusTransformUtils.instanceOf(r2, CellInfoLte.class) == false) goto L28;
        r4 = a((CellInfoLte) ZeusTransformUtils.preCheckCast(r2, CellInfoLte.class, "com.obric.memorydata.plugin"), r5);     // Catch: Throwable -> L44
        goto L32
    L28:
        if (Build.VERSION.SDK_INT < 29) goto L32;
        if (ZeusTransformUtils.instanceOf(r2, CellInfoNr.class) == false) goto L32;
        r4 = a((CellInfoNr) ZeusTransformUtils.preCheckCast(r2, CellInfoNr.class, "com.obric.memorydata.plugin"), r5);     // Catch: Throwable -> L44
    L34:
        r1 = r1 + 1;     // Catch: Throwable -> L44
        goto L12
    L35:
        this.i = false;     // Catch: Throwable -> L44
        ArrayList<dt> r12 = this.l;     // Catch: Throwable -> L44
        if (r12 != null) goto L38;
    L40:
        monitor-exit(this);
        return;
    L38:
        if (r12.size() <= 0) goto L40;
        this.i = true;     // Catch: Throwable -> L44
    L44:
        th = move-exception;
        throw th;
    }

    public final void a(boolean r3) {
        this.m.a(r3);
        this.n = 0;
        Object r4 = this.p;
        monitor-enter(r4);
        this.o = true;     // Catch: Throwable -> L9
        monitor-exit(r4);     // Catch: Throwable -> L9
        u();
        this.d = null;
        this.f5469b = null;
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void a(boolean r2, boolean r3) {
        this.e = fd.a(this.h);     // Catch: Throwable -> L9 SecurityException -> L12
        if (t() == false) goto L6;
        b(r2, r3);     // Catch: Throwable -> L9 SecurityException -> L12
        a(v());     // Catch: Throwable -> L9 SecurityException -> L12
        a(w());     // Catch: Throwable -> L9 SecurityException -> L12
    L6:
        if (this.e == false) goto L17;
        j();     // Catch: Throwable -> L9 SecurityException -> L12
        return;
    L17:
        return;
    L12:
        e = move-exception;
        this.g = e.getMessage();
        return;
    L9:
        th = move-exception;
        ev.a(th, "CgiManager", "refresh");
    }

    public final void b() {
        boolean r0 = false;
    L27:
        ex.b();
        return;
    L4:
        if (Build.VERSION.SDK_INT >= 31) goto L6;
        return;
    L6:
        if (this.h.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) goto L8;
        String r1 = "hasFineLocPerm";
    L10:
        if (this.h.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) goto L12;
        String r2 = "hasReadPhoneStatePerm";
    L13:
        boolean r4 = true;
        if (TextUtils.isEmpty(this.t) == true) goto L19;
        if (this.t.equals(r1) == true) goto L19;
        r0 = true;
    L19:
        if (TextUtils.isEmpty(this.s) == false) goto L21;
    L23:
        r4 = r0;
    L24:
        if (r4 == false) goto L32;
        ex.b();     // Catch: Throwable -> L27
        p();     // Catch: Throwable -> L27
        return;
    L32:
        return;
    L21:
        if (this.s.equals(r2) == true) goto L23;
    L12:
        r2 = "hasNoReadPhoneStatePerm";
        goto L13
    L8:
        r1 = "hasNoFineLocPerm";
        goto L10
    }

    public final void b(boolean r2) {
        this.u = r2;
        if (this.v == true) goto L14;
        if (r2 == true) goto L6;
    L9:
        if (r2 == false) goto L11;
        return;
    L11:
        if (this.w == false) goto L16;
        u();
        return;
    L16:
        return;
    L6:
        if (this.w == true) goto L9;
        p();
        return;
    }

    public final synchronized ArrayList<dt> c() {
        monitor-enter(this);
        ArrayList<dt> r0 = new ArrayList();     // Catch: Throwable -> L12
        ArrayList<dt> r1 = this.f5468a;     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        Iterator<dt> r2 = r1.iterator();     // Catch: Throwable -> L12
    L7:
        if (r2.hasNext() == false) goto L10;
        r0.add(((dt) ZeusTransformUtils.preCheckCast(r2.next(), dt.class, "com.obric.memorydata.plugin")).d());     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return r0;
    L12:
        th = move-exception;
        throw th;
    }

    public final void c(boolean r1) {
        this.v = r1;
    }

    public final synchronized ArrayList<dt> d() {
        monitor-enter(this);
        ArrayList<dt> r0 = new ArrayList();     // Catch: Throwable -> L12
        ArrayList<dt> r1 = this.l;     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        Iterator<dt> r2 = r1.iterator();     // Catch: Throwable -> L12
    L7:
        if (r2.hasNext() == false) goto L10;
        r0.add(((dt) ZeusTransformUtils.preCheckCast(r2.next(), dt.class, "com.obric.memorydata.plugin")).d());     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return r0;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized dt e() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.e == false) goto L8;
        monitor-exit(this);
        return null;
    L8:
        ArrayList<dt> r0 = this.f5468a;     // Catch: Throwable -> L15
        if (r0.size() <= 0) goto L13;
        dt r1 = ((dt) ZeusTransformUtils.preCheckCast(r0.get(0), dt.class, "com.obric.memorydata.plugin")).d();     // Catch: Throwable -> L15
        monitor-exit(this);
        return r1;
    L13:
        monitor-exit(this);
        return null;
    }

    public final synchronized dt f() {
        monitor-enter(this);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.e == false) goto L8;
        monitor-exit(this);
        return null;
    L8:
        ArrayList<dt> r0 = this.l;     // Catch: Throwable -> L24
        if (r0.size() <= 0) goto L22;
        Iterator<dt> r1 = r0.iterator();     // Catch: Throwable -> L24
    L12:
        if (r1.hasNext() == false) goto L19;
        dt r2 = (dt) ZeusTransformUtils.preCheckCast(r1.next(), dt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r2.n == false) goto L12;
        dt r3 = r2.d();     // Catch: Throwable -> L24
        monitor-exit(this);
        return r3;
    L19:
        dt r4 = ((dt) ZeusTransformUtils.preCheckCast(r0.get(0), dt.class, "com.obric.memorydata.plugin")).d();     // Catch: Throwable -> L24
        monitor-exit(this);
        return r4;
    L22:
        monitor-exit(this);
        return null;
    }

    public final int g() {
        int r0 = q();
        int r2 = 0;
        if (this.i == false) goto L5;
        int r1 = 4;
    L6:
        int r3 = r0 | r1;
        if (this.j == false) goto L10;
        r2 = 8;
    L10:
        return r3 | r2;
    L5:
        r1 = 0;
        goto L6
    }

    public final int h() {
        return q() & 3;
    }

    public final TelephonyManager i() {
        return this.f5469b;
    }

    final synchronized void j() {
        monitor-enter(this);
        this.g = null;     // Catch: Throwable -> L7
        this.f5468a.clear();     // Catch: Throwable -> L7
        this.l.clear();     // Catch: Throwable -> L7
        this.i = false;     // Catch: Throwable -> L7
        this.j = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final String k() {
        return this.g;
    }

    public final String l() {
        return this.k;
    }

    public final synchronized String m() {
        monitor-enter(this);
    L40:
        th = move-exception;
        throw th;
    L4:
        if (this.e == false) goto L6;
        j();     // Catch: Throwable -> L40
    L6:
        StringBuilder r0 = this.f;     // Catch: Throwable -> L40
        if (r0 != null) goto L9;
        this.f = new StringBuilder();     // Catch: Throwable -> L40
    L11:
        if (h() != 1) goto L17;
        int r1 = 1;
    L15:
        if (r1 >= this.f5468a.size()) goto L17;
        this.f.append("#").append(((dt) ZeusTransformUtils.preCheckCast(this.f5468a.get(r1), dt.class, "com.obric.memorydata.plugin")).f5467b);     // Catch: Throwable -> L40
        this.f.append("|").append(((dt) ZeusTransformUtils.preCheckCast(this.f5468a.get(r1), dt.class, "com.obric.memorydata.plugin")).c);     // Catch: Throwable -> L40
        this.f.append("|").append(((dt) ZeusTransformUtils.preCheckCast(this.f5468a.get(r1), dt.class, "com.obric.memorydata.plugin")).d);     // Catch: Throwable -> L40
        r1 = r1 + 1;     // Catch: Throwable -> L40
    L17:
        int r2 = 1;
    L19:
        if (r2 >= this.l.size()) goto L35;
        dt r3 = (dt) ZeusTransformUtils.preCheckCast(this.l.get(r2), dt.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L40
        if (r3.l != 1) goto L23;
    L32:
        this.f.append("#").append(r3.l);     // Catch: Throwable -> L40
        this.f.append("|").append(r3.f5466a);     // Catch: Throwable -> L40
        this.f.append("|").append(r3.f5467b);     // Catch: Throwable -> L40
        this.f.append("|").append(r3.c);     // Catch: Throwable -> L40
        this.f.append("|").append(r3.a());     // Catch: Throwable -> L40
    L33:
        r2 = r2 + 1;     // Catch: Throwable -> L40
        goto L19
    L23:
        if (r3.l == 3) goto L32;
        if (r3.l == 4) goto L32;
        if (r3.l == 5) goto L32;
        if (r3.l != 2) goto L33;
        this.f.append("#").append(r3.l);     // Catch: Throwable -> L40
        this.f.append("|").append(r3.f5466a);     // Catch: Throwable -> L40
        this.f.append("|").append(r3.h);     // Catch: Throwable -> L40
        this.f.append("|").append(r3.i);     // Catch: Throwable -> L40
        this.f.append("|").append(r3.j);     // Catch: Throwable -> L40
        goto L33
    L35:
        if (this.f.length() <= 0) goto L37;
        this.f.deleteCharAt(0);     // Catch: Throwable -> L40
    L37:
        String r4 = this.f.toString();     // Catch: Throwable -> L40
        monitor-exit(this);
        return r4;
    L9:
        r0.delete(0, r0.length());     // Catch: Throwable -> L40
        goto L11
    }

    public final boolean n() {
        TelephonyManager r1 = this.f5469b;     // Catch: Throwable -> L24
        if (r1 == null) goto L26;
        if (TextUtils.isEmpty(r1.getSimOperator()) == true) goto L8;
        return true;
    L8:
        if (TextUtils.isEmpty(this.f5469b.getSimCountryIso()) == true) goto L26;
        return true;
    L26:
        int r2 = fd.a(fd.c(this.h));     // Catch: Throwable -> L25
        if (r2 != 0) goto L14;
    L21:
        return true;
    L14:
        if (r2 == 4) goto L21;
        if (r2 == 2) goto L21;
        if (r2 == 5) goto L21;
        if (r2 == 3) goto L21;
        return false;
    L30:
        return false;
    }
}
