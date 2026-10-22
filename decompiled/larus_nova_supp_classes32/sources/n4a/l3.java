package n4a;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
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
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.loc.dv;
import com.loc.dw;
import com.loc.dx;
import com.loc.dy;
import com.loc.dz;
import com.obric.assistant.AutoEndConversationTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class l3 {
    public final Context a;
    public boolean b;
    public boolean c;
    public final ArrayList<k3> d;
    public String e;
    public final ArrayList<k3> f;
    public TelephonyManager g;
    public final j3 h;
    public long i;
    public b j;
    public SignalStrength k;
    public final Object l;
    public a m;
    public boolean n;
    public boolean o;
    public StringBuilder p;
    public String q;
    public String r;
    public String s;
    public volatile boolean t;
    public volatile boolean u;
    public volatile boolean v;
    public d3 w;

    public class a extends TelephonyManager.CellInfoCallback {
        public final /* synthetic */ l3 a;

        public a(l3 r1) {
            this.a = r1;
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(List<CellInfo> r7) {
            StringBuilder r0 = new StringBuilder("noLocReqCgiEnable:");     // Catch: Throwable -> L12 SecurityException -> L15
            r0.append(this.a.u);     // Catch: Throwable -> L12 SecurityException -> L15
            r0.append(" isStartLocation:");     // Catch: Throwable -> L12 SecurityException -> L15
            r0.append(this.a.t);     // Catch: Throwable -> L12 SecurityException -> L15
            if (this.a.u == false) goto L5;
        L7:
            long r1 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12 SecurityException -> L15
            l3 r2 = this.a;     // Catch: Throwable -> L12 SecurityException -> L15
            if ((r1 - r2.i) >= 500) goto L10;
            return;
        L10:
            r2.n = true;     // Catch: Throwable -> L12 SecurityException -> L15
            CellLocation r3 = r2.r();     // Catch: Throwable -> L12 SecurityException -> L15
            this.a.h(r3);     // Catch: Throwable -> L12 SecurityException -> L15
            this.a.i(r7);     // Catch: Throwable -> L12 SecurityException -> L15
            l3 r8 = this.a;     // Catch: Throwable -> L12 SecurityException -> L15
            r8.i = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12 SecurityException -> L15
            return;
        L5:
            if (this.a.t == true) goto L7;
            return;
        L15:
            e = move-exception;
            l3 r4 = this.a;
            r4.s = e.getMessage();
            return;
        L12:
            th = move-exception;
            c4.g(th, "Cgi", "cellInfo");
        }
    }

    public class b extends PhoneStateListener {
        public final /* synthetic */ l3 a;

        public b(l3 r1) {
            this.a = r1;
        }

        @Override // android.telephony.PhoneStateListener
        public final void onDataConnectionStateChanged(int r1) {
            super.onDataConnectionStateChanged(r1);
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthChanged(int r1) {
            super.onSignalStrengthChanged(r1);
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellInfoChanged(List<CellInfo> r7) {
            boolean r0 = this.a.u;     // Catch: Throwable -> L22
            boolean r1 = this.a.t;     // Catch: Throwable -> L22
            if (this.a.u == false) goto L5;
        L7:
            d3 r2 = this.a.w;     // Catch: Throwable -> L22
            if (r2 != null) goto L25;
        L17:
            long r3 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L22
            l3 r4 = this.a;     // Catch: Throwable -> L22
            if ((r3 - r4.i) >= 500) goto L20;
            return;
        L20:
            CellLocation r5 = r4.r();     // Catch: Throwable -> L22
            this.a.h(r5);     // Catch: Throwable -> L22
            this.a.i(r7);     // Catch: Throwable -> L22
            l3 r8 = this.a;     // Catch: Throwable -> L22
            r8.i = SystemClock.elapsedRealtime();     // Catch: Throwable -> L22
            return;
        L25:
        L15:
            th = move-exception;
            c4.g(th, "cl", "upc");     // Catch: Throwable -> L22
            goto L17
        L10:
            if (r2.f == null) goto L17;
            l3 r6 = r2.e;     // Catch: Throwable -> L15
            if (r6 == null) goto L17;
            p2.a(r6.a());     // Catch: Throwable -> L15
        L5:
            if (this.a.t == true) goto L7;
            return;
        L22:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellLocationChanged(CellLocation r7) {
            StringBuilder r0 = new StringBuilder("noLocReqCgiEnable:");
            r0.append(this.a.u);
            r0.append(" isStartLocation:");
            r0.append(this.a.t);
            if (this.a.u == false) goto L5;
        L7:
            long r1 = SystemClock.elapsedRealtime();
            l3 r2 = this.a;
            if ((r1 - r2.i) >= 500) goto L15;
            return;
        L15:
            r2.h(r7);     // Catch: Throwable -> L12
            List<CellInfo> r8 = this.a.s();     // Catch: Throwable -> L12
            this.a.i(r8);     // Catch: Throwable -> L12
            l3 r9 = this.a;     // Catch: Throwable -> L12
            r9.i = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            th.printStackTrace();
            return;
        L5:
            if (this.a.t == true) goto L7;
        }

        @Override // android.telephony.PhoneStateListener
        public final void onServiceStateChanged(ServiceState r3) {
            StringBuilder r0 = new StringBuilder("noLocReqCgiEnable:");     // Catch: Throwable -> L16
            r0.append(this.a.u);     // Catch: Throwable -> L16
            r0.append(" isStartLocation:");     // Catch: Throwable -> L16
            r0.append(this.a.t);     // Catch: Throwable -> L16
            if (this.a.u == false) goto L5;
        L7:
            int r4 = r3.getState();     // Catch: Throwable -> L16
            if (r4 != 0) goto L10;
            this.a.j(false, false);     // Catch: Throwable -> L16
            return;
        L10:
            if (r4 != 1) goto L18;
            this.a.p();     // Catch: Throwable -> L16
            return;
        L18:
            return;
        L5:
            if (this.a.t == true) goto L7;
            return;
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthsChanged(SignalStrength r3) {
            boolean r0 = this.a.u;
            boolean r1 = this.a.t;
            if (r3 != null) goto L5;
            return;
        L5:
            l3 r2 = this.a;
            r2.k = r3;
            if (r2.u == false) goto L8;
        L24:
            d3 r4 = this.a.w;     // Catch: Throwable -> L21
            if (r4 == null) goto L26;
        L18:
            th = move-exception;
            c4.g(th, "cl", "upc");     // Catch: Throwable -> L21
            return;
        L13:
            if (r4.f == null) goto L27;
            l3 r5 = r4.e;     // Catch: Throwable -> L18
            if (r5 == null) goto L28;
            p2.a(r5.a());     // Catch: Throwable -> L18
            goto L30
        L29:
            return;
        L28:
            return;
        L27:
            return;
        L26:
            return;
        L30:
            return;
        L8:
            if (this.a.t == true) goto L24;
        }
    }

    public static k3 b(int r1, boolean r2, int r3, int r4, int r5, int r6, int r7) {
        k3 r0 = new k3(r1, r2);
        r0.a = r3;
        r0.b = r4;
        r0.c = r5;
        r0.d = r6;
        r0.k = r7;
        return r0;
    }

    public static k3 d(CellInfoGsm r8, boolean r9) {
        if (r8.getCellIdentity() != null) goto L6;
        return null;
    L6:
        CellIdentityGsm r0 = r8.getCellIdentity();
        k3 r10 = b(1, r9, r0.getMcc(), r0.getMnc(), r0.getLac(), r0.getCid(), r8.getCellSignalStrength().getDbm());
        r10.n = r8.getCellIdentity().getBsic();
        r10.o = r8.getCellIdentity().getArfcn();
        r10.p = r8.getCellSignalStrength().getTimingAdvance();
        r10.r = r8.getCellSignalStrength().getDbm();
        return r10;
    }

    public static k3 e(CellInfoLte r8, boolean r9) {
        if (r8.getCellIdentity() != null) goto L6;
        return null;
    L6:
        CellIdentityLte r0 = r8.getCellIdentity();
        k3 r10 = b(3, r9, r0.getMcc(), r0.getMnc(), r0.getTac(), r0.getCi(), r8.getCellSignalStrength().getDbm());
        r10.n = r0.getPci();
        if (Build.VERSION.SDK_INT < 24) goto L9;
        r10.o = r0.getEarfcn();
    L9:
        r10.p = r8.getCellSignalStrength().getTimingAdvance();
        r10.r = r8.getCellSignalStrength().getDbm();
        return r10;
    }

    public static k3 g(CellInfoWcdma r8, boolean r9) {
        if (r8.getCellIdentity() != null) goto L6;
        return null;
    L6:
        CellIdentityWcdma r0 = r8.getCellIdentity();
        k3 r10 = b(4, r9, r0.getMcc(), r0.getMnc(), r0.getLac(), r0.getCid(), r8.getCellSignalStrength().getDbm());
        r10.n = r0.getPsc();
        r10.o = r8.getCellIdentity().getUarfcn();
        r10.r = r8.getCellSignalStrength().getDbm();
        return r10;
    }

    public final k3 c(CellInfoCdma r12, boolean r13) {
        if (r12.getCellIdentity() == null) goto L29;
        CellIdentityCdma r0 = r12.getCellIdentity();
        if (r0.getSystemId() > 0) goto L8;
        return null;
    L8:
        if (r0.getNetworkId() >= 0) goto L10;
        return null;
    L10:
        if (r0.getBasestationId() < 0) goto L28;
        CellIdentityCdma r1 = r12.getCellIdentity();
        String[] r2 = j4.r(this.g);
        int r3 = CastIntegerProtector.parseInt(r2[0]);     // Catch: Throwable -> L16
        int r7 = CastIntegerProtector.parseInt(r2[1]);     // Catch: Throwable -> L22
        int r6 = r3;
    L18:
        k3 r14 = b(2, r13, r6, r7, 0, 0, r12.getCellSignalStrength().getCdmaDbm());
        r14.h = r1.getSystemId();
        r14.i = r1.getNetworkId();
        r14.j = r1.getBasestationId();
        r14.f = r1.getLatitude();
        r14.g = r1.getLongitude();
        r14.r = r12.getCellSignalStrength().getCdmaDbm();
        return r14;
    L17:
        r6 = r3;
        r7 = 0;
    L16:
        r3 = 0;
        goto L17
    L28:
        return null;
    L29:
        return null;
    }

    public final synchronized ArrayList<k3> n() {
        monitor-enter(this);
        ArrayList<k3> r0 = new ArrayList();     // Catch: Throwable -> L12
        ArrayList<k3> r1 = this.f;     // Catch: Throwable -> L12
        if (r1 == null) goto L10;
        Iterator<k3> r2 = r1.iterator();     // Catch: Throwable -> L12
    L7:
        if (r2.hasNext() == false) goto L10;
        r0.add(r2.next().c());     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return r0;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized k3 o() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.o == false) goto L8;
        monitor-exit(this);
        return null;
    L8:
        ArrayList<k3> r0 = this.d;     // Catch: Throwable -> L15
        if (r0.size() <= 0) goto L13;
        k3 r1 = ((k3) ListProtector.get(r0, 0)).c();     // Catch: Throwable -> L15
        monitor-exit(this);
        return r1;
    L13:
        monitor-exit(this);
        return null;
    }

    public final synchronized void p() {
        monitor-enter(this);
        this.s = null;     // Catch: Throwable -> L7
        this.d.clear();     // Catch: Throwable -> L7
        this.f.clear();     // Catch: Throwable -> L7
        this.b = false;     // Catch: Throwable -> L7
        this.c = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void q() {
    L38:
        e = move-exception;
        e.printStackTrace();
        return;
    L3:
        if (this.j != null) goto L5;
        this.j = new b(this);     // Catch: Exception -> L38
    L5:
        int r0 = Build.VERSION.SDK_INT;     // Catch: Exception -> L38
        String r1 = "hasFineLocPerm";
        if (r0 >= 31) goto L9;
    L12:
        int r5 = 336;
    L14:
        if (r0 < 31) goto L33;
        boolean r4 = false;
        if (l(this.a, "android.permission.READ_PHONE_STATE") != 0) goto L18;
        boolean r2 = true;
    L20:
        if (l(this.a, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L22;
        r4 = true;
    L22:
        if (r2 == false) goto L25;
        if (r4 == false) goto L25;
        r5 = r5 | 1024;     // Catch: Exception -> L38
    L25:
        if (r2 == false) goto L27;
        String r3 = "hasReadPhoneStatePerm";
    L28:
        this.q = r3;     // Catch: Exception -> L38
        if (r4 == true) goto L32;
        r1 = "hasNoFineLocPerm";
    L32:
        this.r = r1;     // Catch: Exception -> L38
    L34:
        b r6 = this.j;     // Catch: Exception -> L38
        if (r6 == null) goto L43;
        this.g.listen(r6, r5);     // Catch: Exception -> L38
        this.v = true;     // Catch: Exception -> L38
        return;
    L43:
        return;
    L27:
        r3 = "hasNoReadPhoneStatePerm";
        goto L28
    L18:
        r2 = false;
        goto L20
    L33:
        r5 = r5 | 1024;     // Catch: Exception -> L38
        goto L34
    L9:
        if (l(this.a, "android.permission.ACCESS_FINE_LOCATION") != 0) goto L11;
        this.r = "hasFineLocPerm";     // Catch: Exception -> L38
        goto L12
    L11:
        this.r = "hasNoFineLocPerm";     // Catch: Exception -> L38
        r5 = 320;
        goto L14
    }

    public final List<CellInfo> s() {
    L22:
        th = move-exception;
        c4.g(th, "Cgi", "getNewCells");
        return null;
    L4:
        if (j4.y() >= 18) goto L6;
        return null;
    L6:
        TelephonyManager r1 = this.g;     // Catch: Throwable -> L22
        if (r1 != null) goto L9;
        return null;
    L9:
        if (r1 != null) goto L25;
        List<CellInfo> r2 = null;
    L28:
        this.s = null;     // Catch: SecurityException -> L17 Throwable -> L22
        return r2;
    L17:
        e = move-exception;
        List<CellInfo> r3 = r2;
        e = e;
    L19:
        this.s = e.getMessage();     // Catch: Throwable -> L22
        return r3;
    L25:
        r2 = r1.getAllCellInfo();     // Catch: SecurityException -> L12 Throwable -> L22
    L12:
        e = e;
        r3 = null;
        goto L19
    }

    public final List<dv> a() {
        ArrayList r0 = new ArrayList();
        TelephonyManager r1 = this.g;
        if (r1 == null) goto L5;
        List<CellInfo> r2 = r1.getAllCellInfo();
    L6:
        if (r2 == null) goto L31;
        Iterator<CellInfo> r3 = r2.iterator();
    L9:
        if (r3.hasNext() == false) goto L31;
        CellInfo r4 = r3.next();
        if ((r4 instanceof CellInfoCdma) == true) goto L12;
        if ((r4 instanceof CellInfoGsm) == false) goto L20;
        CellInfoGsm r5 = (CellInfoGsm) r4;
        CellIdentityGsm r6 = r5.getCellIdentity();
        dx r7 = new dx(r4.isRegistered(), true);
        r7.a = String.valueOf(r6.getMcc());
        r7.b = String.valueOf(r6.getMnc());
        r7.j = r6.getLac();
        r7.k = r6.getCid();
        r7.c = r5.getCellSignalStrength().getDbm();
        r7.d = r5.getCellSignalStrength().getAsuLevel();
        if (Build.VERSION.SDK_INT < 24) goto L18;
        r7.m = r6.getArfcn();
        r7.n = r6.getBsic();
    L18:
        r0.add(r7);
        goto L9
    L20:
        if ((r4 instanceof CellInfoLte) == true) goto L21;
        int r8 = Build.VERSION.SDK_INT;
        if ((r4 instanceof CellInfoWcdma) == false) goto L9;
        CellInfoWcdma r9 = (CellInfoWcdma) r4;
        CellIdentityWcdma r10 = r9.getCellIdentity();
        dz r11 = new dz(r4.isRegistered(), true);
        r11.a = String.valueOf(r10.getMcc());
        r11.b = String.valueOf(r10.getMnc());
        r11.j = r10.getLac();
        r11.k = r10.getCid();
        r11.l = r10.getPsc();
        r11.d = r9.getCellSignalStrength().getAsuLevel();
        r11.c = r9.getCellSignalStrength().getDbm();
        if (r8 < 24) goto L30;
        r11.m = r10.getUarfcn();
    L30:
        r0.add(r11);
        goto L9
    L21:
        CellInfoLte r12 = (CellInfoLte) r4;
        CellIdentityLte r13 = r12.getCellIdentity();
        dy r14 = new dy(r4.isRegistered());
        r14.a = String.valueOf(r13.getMcc());
        r14.b = String.valueOf(r13.getMnc());
        r14.l = r13.getPci();
        r14.d = r12.getCellSignalStrength().getAsuLevel();
        r14.k = r13.getCi();
        r14.j = r13.getTac();
        r14.n = r12.getCellSignalStrength().getTimingAdvance();
        r14.c = r12.getCellSignalStrength().getDbm();
        Object r15 = r14;
        if (Build.VERSION.SDK_INT < 24) goto L24;
        r14.m = r13.getEarfcn();
        r15 = r14;
    L24:
        r0.add(r15);
        goto L9
    L12:
        CellInfoCdma r16 = (CellInfoCdma) r4;
        CellIdentityCdma r17 = r16.getCellIdentity();
        dw r18 = new dw(r4.isRegistered(), true);
        r18.m = r17.getLatitude();
        r18.n = r17.getLongitude();
        r18.j = r17.getSystemId();
        r18.k = r17.getNetworkId();
        r18.l = r17.getBasestationId();
        r18.d = r16.getCellSignalStrength().getAsuLevel();
        r18.c = r16.getCellSignalStrength().getCdmaDbm();
        r15 = r18;
    L31:
        return r0;
    L5:
        r2 = null;
        goto L6
    }

    public final CellLocation r() {
        TelephonyManager r0 = this.g;
        if (r0 != null) goto L5;
        return null;
    L5:
        if (r0 == null) goto L15;
        CellLocation r1 = r0.getCellLocation();     // Catch: Throwable -> L8 SecurityException -> L10
        this.s = null;     // Catch: Throwable -> L8 SecurityException -> L10
    L16:
        return r1;
    L10:
        e = move-exception;
        this.s = e.getMessage();
        return null;
    L8:
        th = move-exception;
        this.s = null;
        c4.g(th, "CgiManager", "getCellLocation");
        return null;
    L15:
        return null;
    }

    public static String m(TelephonyManager r13) {
        f06.c r8 = new f06.c();
        Object[] r9 = new Object[0];
        f06.b r10 = new f06.b();
        f06.d r11 = r8.b(102021, "android/telephony/TelephonyManager", "getSimOperator", r13, r9, "java.lang.String", r10);
        if (r11.a == false) goto L6;
        r8.a(102021, "android/telephony/TelephonyManager", "getSimOperator", r13, r9, null, r10, false);
        return (String) r11.b;
    L6:
        String r12 = r13.getSimOperator();
        r8.a(102021, "android/telephony/TelephonyManager", "getSimOperator", r13, r9, r12, r10, true);
        return r12;
    }

    public final synchronized void h(CellLocation r7) {
        monitor-enter(this);
        String[] r0 = j4.r(this.g);     // Catch: Throwable -> L23
        this.d.clear();     // Catch: Throwable -> L23
        if ((r7 instanceof GsmCellLocation) == false) goto L16;
        GsmCellLocation r8 = (GsmCellLocation) r7;     // Catch: Throwable -> L23
        k3 r1 = new k3(1, true);     // Catch: Throwable -> L23
        r1.a = CastIntegerProtector.parseInt(r0[0]);     // Catch: Throwable -> L23
        r1.b = CastIntegerProtector.parseInt(r0[1]);     // Catch: Throwable -> L23
        r1.c = r8.getLac();     // Catch: Throwable -> L23
        r1.d = r8.getCid();     // Catch: Throwable -> L23
        SignalStrength r9 = this.k;     // Catch: Throwable -> L23
        if (r9 == null) goto L12;
        int r10 = r9.getGsmSignalStrength();     // Catch: Throwable -> L23
        if (r10 != 99) goto L10;
        int r11 = Integer.MAX_VALUE;
    L11:
        r1.r = r11;     // Catch: Throwable -> L23
        goto L12
    L10:
        r11 = (r10 * 2) - 113;     // Catch: Throwable -> L23
    L12:
        r1.q = false;     // Catch: Throwable -> L23
        j3 r12 = this.h;     // Catch: Throwable -> L23
        r12.getClass();     // Catch: Throwable -> L23
        r12.e(r1, SystemClock.elapsedRealtime());     // Catch: Throwable -> L23
        this.d.add(r1);     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L16:
        if ((r7 instanceof CdmaCellLocation) == false) goto L21;
        CdmaCellLocation r13 = (CdmaCellLocation) r7;     // Catch: Throwable -> L23
        k3 r2 = new k3(2, true);     // Catch: Throwable -> L23
        r2.a = CastIntegerProtector.parseInt(r0[0]);     // Catch: Throwable -> L23
        r2.b = CastIntegerProtector.parseInt(r0[1]);     // Catch: Throwable -> L23
        r2.f = r13.getBaseStationLatitude();     // Catch: Throwable -> L23
        r2.g = r13.getBaseStationLongitude();     // Catch: Throwable -> L23
        r2.h = r13.getSystemId();     // Catch: Throwable -> L23
        r2.i = r13.getNetworkId();     // Catch: Throwable -> L23
        r2.j = r13.getBaseStationId();     // Catch: Throwable -> L23
        SignalStrength r14 = this.k;     // Catch: Throwable -> L23
        if (r14 == null) goto L20;
        r2.r = r14.getCdmaDbm();     // Catch: Throwable -> L23
    L20:
        r2.q = false;     // Catch: Throwable -> L23
        j3 r15 = this.h;     // Catch: Throwable -> L23
        r15.getClass();     // Catch: Throwable -> L23
        r15.e(r2, SystemClock.elapsedRealtime());     // Catch: Throwable -> L23
        this.d.add(r2);     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public final synchronized void i(List<CellInfo> r10) {
        monitor-enter(this);
        ArrayList<k3> r0 = this.f;     // Catch: Throwable -> L45
        if (r0 == null) goto L6;
        r0.clear();     // Catch: Throwable -> L45
    L6:
        if (r10 != null) goto L8;
    L43:
        monitor-exit(this);
        return;
    L8:
        if (r10.size() <= 0) goto L43;
        int r1 = 0;
    L12:
        if (r1 >= r10.size()) goto L36;
        CellInfo r2 = (CellInfo) ListProtector.get(r10, r1);     // Catch: Throwable -> L45
        if (r2 == null) goto L35;
        boolean r4 = r2.isRegistered();     // Catch: Throwable -> L45
        if ((r2 instanceof CellInfoCdma) == false) goto L19;
        k3 r3 = c((CellInfoCdma) r2, r4);     // Catch: Throwable -> L45
    L33:
        if (r3 == null) goto L35;
        j3 r5 = this.h;     // Catch: Throwable -> L45
        r5.getClass();     // Catch: Throwable -> L45
        r5.e(r3, SystemClock.elapsedRealtime());     // Catch: Throwable -> L45
        j3 r6 = this.h;     // Catch: Throwable -> L45
        r6.getClass();     // Catch: Throwable -> L45
        Math.min(65535, (SystemClock.elapsedRealtime() - r6.h(r3)) / 1000);     // Catch: Throwable -> L45
        r3.q = true;     // Catch: Throwable -> L45
        this.f.add(r3);     // Catch: Throwable -> L45
        goto L35
    L19:
        if ((r2 instanceof CellInfoGsm) == false) goto L22;
        r3 = d((CellInfoGsm) r2, r4);     // Catch: Throwable -> L45
        goto L33
    L22:
        if ((r2 instanceof CellInfoWcdma) == false) goto L25;
        r3 = g((CellInfoWcdma) r2, r4);     // Catch: Throwable -> L45
        goto L33
    L25:
        if ((r2 instanceof CellInfoLte) == false) goto L28;
        r3 = e((CellInfoLte) r2, r4);     // Catch: Throwable -> L45
        goto L33
    L28:
        if (Build.VERSION.SDK_INT >= 29) goto L30;
    L32:
        r3 = null;
        goto L33
    L30:
        if ((r2 instanceof CellInfoNr) == false) goto L32;
        r3 = f((CellInfoNr) r2, r4);     // Catch: Throwable -> L45
    L35:
        r1 = r1 + 1;     // Catch: Throwable -> L45
        goto L12
    L36:
        this.b = false;     // Catch: Throwable -> L45
        ArrayList<k3> r11 = this.f;     // Catch: Throwable -> L45
        if (r11 != null) goto L39;
    L41:
        monitor-exit(this);
        return;
    L39:
        if (r11.size() <= 0) goto L41;
        this.b = true;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public l3(Context r5, Handler r6) {
        this.b = false;
        this.c = false;
        this.d = new ArrayList();
        this.e = null;
        this.f = new ArrayList();
        this.g = null;
        this.h = null;
        this.i = 0;
        this.j = null;
        this.l = new Object();
        this.n = false;
        this.o = false;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = true;
        this.u = true;
        this.v = false;
        this.a = r5;
        if (this.g != null) goto L6;
        this.g = (TelephonyManager) j4.e(r5, "phone");
    L6:
        if (this.g == null) goto L9;
        q();
    L9:
        j3 r0 = new j3(r5, r6);
        this.h = r0;
        if (r0.b == true) goto L14;
        Handler r7 = r0.d;
        if (r7 == null) goto L14;
        r7.removeCallbacks(r0.g);
        r0.d.postDelayed(r0.g, AutoEndConversationTime.AFTER_60_SECONDS);
    L14:
        r0.b = true;
    }

    public static k3 f(CellInfoNr r14, boolean r15) {
        if (r14.getCellIdentity() != null) goto L6;
        return null;
    L6:
        CellIdentityNr r0 = (CellIdentityNr) r14.getCellIdentity();
        int r1 = r0.getTac();
        if (r1 == Integer.MAX_VALUE) goto L9;
    L15:
        long r4 = r0.getNci();
        int r2 = CastIntegerProtector.parseInt(r0.getMccString());     // Catch: Throwable -> L21
        int r9 = r2;
        int r10 = CastIntegerProtector.parseInt(r0.getMncString());     // Catch: Throwable -> L19
    L24:
        int r13 = ((CellSignalStrengthNr) r14.getCellSignalStrength()).getSsRsrp();
        k3 r16 = b(5, r15, r9, r10, r0.getTac(), 0, r13);
        r16.e = r4;
        if (r1 <= 16777215) goto L27;
        r16.c = 65535;
    L30:
        r16.n = r0.getPci();
        r16.o = r0.getNrarfcn();
        r16.r = r14.getCellSignalStrength().getDbm();
        return r16;
    L27:
        if (r1 <= 65535) goto L29;
        r16.c = 65535;
        r16.p = r1;
        goto L30
    L29:
        r16.c = r1;
    L19:
        Throwable th = th;
    L23:
        th.printStackTrace();
        r9 = r2;
        r10 = 0;
    L21:
        th = move-exception;
        th = th;
        r2 = 0;
        goto L23
    L9:
        if ("HUAWEI".equals(Build.MANUFACTURER) == false) goto L15;
        r1 = ((Integer) f4.c(r0, "getHwTac", new Object[0])).intValue();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    }

    public static int l(Context r18, String r19) {
        ArrayList r0 = new ArrayList();
        Object[] r1 = {r19};
        f06.b r11 = new f06.b("auto_cert_com_loc_ex_android_content_Context_checkSelfPermission");
        g06.a r2 = (g06.a) ApiHookConfig.b.get(102608);
        if (r2 == null) goto L5;
        f06.a[] r3 = r2.i;
    L6:
        f06.a[] r15 = r3;
        int r9 = r15.length;
        int r8 = 0;
    L8:
        if (r8 >= r9) goto L15;
        f06.a r7 = r15[r8];
        int r16 = r8;
        int r17 = r9;
        f06.d r4 = r7.preInvoke(102608, "android/content/Context", "checkSelfPermission", r18, r1, "int", r11);     // Catch: Exception -> L22
        if (r4.a == true) goto L17;
        r0.add(r7);     // Catch: Exception -> L22
    L17:
        if (r4.a == false) goto L21;
        return ((Integer) r4.b).intValue();
    L21:
        return r18.checkSelfPermission(r19);
    L14:
        r8 = r16 + 1;
        r9 = r17;
        goto L8
    L15:
        r4 = new f06.d(false, null);
        goto L17
    L5:
        r3 = ApiHookConfig.d;
        goto L6
    }

    public final void j(boolean r6, boolean r7) {
        boolean r0 = j4.i(this.a);     // Catch: Throwable -> L15 SecurityException -> L18
        this.o = r0;     // Catch: Throwable -> L15 SecurityException -> L18
        if (r0 == false) goto L6;
    L7:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L12;
        k(r6, r7);     // Catch: Throwable -> L15 SecurityException -> L18
        h(r());     // Catch: Throwable -> L15 SecurityException -> L18
        i(s());     // Catch: Throwable -> L15 SecurityException -> L18
    L12:
        if (this.o == false) goto L23;
        p();     // Catch: Throwable -> L15 SecurityException -> L18
        return;
    L23:
        return;
    L6:
        if ((SystemClock.elapsedRealtime() - this.i) < 45000) goto L7;
        r1 = true;
    L18:
        e = move-exception;
        this.s = e.getMessage();
        return;
    L15:
        th = move-exception;
        c4.g(th, "CgiManager", "refresh");
    }

    public final void k(boolean r5, boolean r6) {
        if (this.o == false) goto L5;
    L27:
        this.c = false;
        TelephonyManager r7 = this.g;
        if (r7 == null) goto L32;
        String r8 = r7.getNetworkOperator();
        this.e = r8;
        if (TextUtils.isEmpty(r8) == true) goto L32;
        this.c = true;
    L32:
        this.i = SystemClock.elapsedRealtime();
        return;
    L5:
        if (this.g == null) goto L27;
        if (Build.VERSION.SDK_INT < 29) goto L27;
        if (this.a.getApplicationInfo().targetSdkVersion < 29) goto L27;
        if (this.m != null) goto L35;
        this.m = new a(this);
    L35:
        this.g.requestCellInfoUpdate(k1.d.a, this.m);     // Catch: Throwable -> L15
    L17:
        if (r6 == true) goto L19;
        if (r5 == false) goto L27;
    L19:
        int r9 = 0;
    L21:
        if (this.n == true) goto L27;
        if (r9 >= 20) goto L27;
        Thread.sleep(5);     // Catch: Throwable -> L34
    L26:
        r9 = r9 + 1;
    L15:
        th = move-exception;
        c4.g(th, "Cgi", "refreshCgi");
        goto L17
    }
}
