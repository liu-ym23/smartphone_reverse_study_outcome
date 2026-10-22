package qa;

import android.annotation.SuppressLint;
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
import com.ttnet.org.chromium.net.NetError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"NewApi"})
public final class c3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList<b3> f10268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f10269e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<b3> f10270f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TelephonyManager f10271g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a3 f10272h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f10273i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f10274j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SignalStrength f10275k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Object f10276l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @SuppressLint({"NewApi"})
    public a f10277m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f10278n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f10279o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public StringBuilder f10280p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f10281q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f10282r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f10283s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public volatile boolean f10284t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public volatile boolean f10285u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile boolean f10286v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public u2 f10287w;

    @SuppressLint({"NewApi"})
    public class a extends TelephonyManager.CellInfoCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c3 f10288a;

        public a(c3 r8) {
            this.f10288a = r8;
        }

        @Override // android.telephony.TelephonyManager.CellInfoCallback
        public final void onCellInfo(List<CellInfo> r8) {
            StringBuilder r10 = new StringBuilder("noLocReqCgiEnable:");     // Catch: Throwable -> L12 SecurityException -> L15
            r10.append(this.f10288a.f10285u);     // Catch: Throwable -> L12 SecurityException -> L15
            r10.append(" isStartLocation:");     // Catch: Throwable -> L12 SecurityException -> L15
            r10.append(this.f10288a.f10284t);     // Catch: Throwable -> L12 SecurityException -> L15
            if (this.f10288a.f10285u == false) goto L5;
        L7:
            long r11 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12 SecurityException -> L15
            c3 r12 = this.f10288a;     // Catch: Throwable -> L12 SecurityException -> L15
            if ((r11 - r12.f10273i) >= 500) goto L10;
            return;
        L10:
            r12.f10278n = true;     // Catch: Throwable -> L12 SecurityException -> L15
            CellLocation r13 = r12.o();     // Catch: Throwable -> L12 SecurityException -> L15
            this.f10288a.h(r13);     // Catch: Throwable -> L12 SecurityException -> L15
            this.f10288a.i(r8);     // Catch: Throwable -> L12 SecurityException -> L15
            c3 r14 = this.f10288a;     // Catch: Throwable -> L12 SecurityException -> L15
            r14.f10273i = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12 SecurityException -> L15
            return;
        L5:
            if (this.f10288a.f10284t == true) goto L7;
            return;
        L15:
            e = move-exception;
            c3 r15 = this.f10288a;
            r15.f10283s = e.getMessage();
            return;
        L12:
            th = move-exception;
            t3.g("Cgi", "cellInfo", th);
        }
    }

    public class b extends PhoneStateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c3 f10289a;

        public b(c3 r8) {
            this.f10289a = r8;
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellInfoChanged(List<CellInfo> r8) {
            boolean r10 = this.f10289a.f10285u;     // Catch: Throwable -> L22
            boolean r11 = this.f10289a.f10284t;     // Catch: Throwable -> L22
            if (this.f10289a.f10285u == false) goto L5;
        L7:
            u2 r12 = this.f10289a.f10287w;     // Catch: Throwable -> L22
            if (r12 != null) goto L27;
        L17:
            long r13 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L22
            c3 r14 = this.f10289a;     // Catch: Throwable -> L22
            if ((r13 - r14.f10273i) >= 500) goto L20;
            return;
        L20:
            CellLocation r15 = r14.o();     // Catch: Throwable -> L22
            this.f10289a.h(r15);     // Catch: Throwable -> L22
            this.f10289a.i(r8);     // Catch: Throwable -> L22
            c3 r16 = this.f10289a;     // Catch: Throwable -> L22
            r16.f10273i = SystemClock.elapsedRealtime();     // Catch: Throwable -> L22
            return;
        L27:
        L15:
            th = move-exception;
            t3.g("cl", "upc", th);     // Catch: Throwable -> L22
            goto L17
        L10:
            if (r12.f11142f == null) goto L17;
            c3 r17 = r12.f11141e;     // Catch: Throwable -> L15
            if (r17 == null) goto L17;
            d2.a(r17.a());     // Catch: Throwable -> L15
        L5:
            if (this.f10289a.f10284t == true) goto L7;
            return;
        L22:
            th = move-exception;
            th.printStackTrace();
        }

        @Override // android.telephony.PhoneStateListener
        public final void onCellLocationChanged(CellLocation r8) {
            StringBuilder r10 = new StringBuilder("noLocReqCgiEnable:");
            r10.append(this.f10289a.f10285u);
            r10.append(" isStartLocation:");
            r10.append(this.f10289a.f10284t);
            if (this.f10289a.f10285u == false) goto L5;
        L7:
            long r11 = SystemClock.elapsedRealtime();
            c3 r12 = this.f10289a;
            if ((r11 - r12.f10273i) >= 500) goto L15;
            return;
        L15:
            r12.h(r8);     // Catch: Throwable -> L12
            List<CellInfo> r13 = this.f10289a.p();     // Catch: Throwable -> L12
            this.f10289a.i(r13);     // Catch: Throwable -> L12
            c3 r14 = this.f10289a;     // Catch: Throwable -> L12
            r14.f10273i = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
            return;
        L12:
            th = move-exception;
            th.printStackTrace();
            return;
        L5:
            if (this.f10289a.f10284t == true) goto L7;
        }

        @Override // android.telephony.PhoneStateListener
        public final void onDataConnectionStateChanged(int r8) {
            super.onDataConnectionStateChanged(r8);
        }

        @Override // android.telephony.PhoneStateListener
        public final void onServiceStateChanged(ServiceState r8) {
            StringBuilder r10 = new StringBuilder("noLocReqCgiEnable:");     // Catch: Throwable -> L16
            r10.append(this.f10289a.f10285u);     // Catch: Throwable -> L16
            r10.append(" isStartLocation:");     // Catch: Throwable -> L16
            r10.append(this.f10289a.f10284t);     // Catch: Throwable -> L16
            if (this.f10289a.f10285u == false) goto L5;
        L7:
            int r11 = r8.getState();     // Catch: Throwable -> L16
            if (r11 != 0) goto L10;
            this.f10289a.j(false, false);     // Catch: Throwable -> L16
            return;
        L10:
            if (r11 != 1) goto L18;
            this.f10289a.m();     // Catch: Throwable -> L16
            return;
        L18:
            return;
        L5:
            if (this.f10289a.f10284t == true) goto L7;
            return;
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthChanged(int r8) {
            super.onSignalStrengthChanged(r8);
        }

        @Override // android.telephony.PhoneStateListener
        public final void onSignalStrengthsChanged(SignalStrength r8) {
            boolean r10 = this.f10289a.f10285u;
            boolean r11 = this.f10289a.f10284t;
            if (r8 != null) goto L5;
            return;
        L5:
            c3 r12 = this.f10289a;
            r12.f10275k = r8;
            if (r12.f10285u == false) goto L8;
        L24:
            u2 r13 = this.f10289a.f10287w;     // Catch: Throwable -> L21
            if (r13 == null) goto L26;
        L18:
            th = move-exception;
            t3.g("cl", "upc", th);     // Catch: Throwable -> L21
            return;
        L13:
            if (r13.f11142f == null) goto L27;
            c3 r14 = r13.f11141e;     // Catch: Throwable -> L18
            if (r14 == null) goto L28;
            d2.a(r14.a());     // Catch: Throwable -> L18
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
            if (this.f10289a.f10284t == true) goto L24;
        }
    }

    public c3(Context r8, Handler r10) {
        this.f10266b = false;
        this.f10267c = false;
        this.f10268d = new ArrayList();
        this.f10269e = null;
        this.f10270f = new ArrayList();
        this.f10271g = null;
        this.f10272h = null;
        this.f10273i = 0;
        this.f10274j = null;
        this.f10276l = new Object();
        this.f10278n = false;
        this.f10279o = false;
        this.f10280p = null;
        this.f10281q = null;
        this.f10282r = null;
        this.f10283s = null;
        this.f10284t = true;
        this.f10285u = true;
        this.f10286v = false;
        this.f10265a = r8;
        if (this.f10271g != null) goto L6;
        this.f10271g = (TelephonyManager) y3.d(r8, "phone");
    L6:
        if (this.f10271g == null) goto L9;
        n();
    L9:
        a3 r11 = new a3(r8, "cellAge", r10, 0);
        this.f10272h = r11;
        if (r11.f11232b == true) goto L14;
        Handler r12 = r11.f11234d;
        if (r12 == null) goto L14;
        y2.a r13 = r11.f11237g;
        r12.removeCallbacks(r13);
        r12.postDelayed(r13, 60000);
    L14:
        r11.f11232b = true;
    }

    public static b3 b(int r8, boolean r10, int r11, int r12, int r13, int r14, int r15) {
        b3 r16 = new b3(r8, r10);
        r16.f10230a = r11;
        r16.f10231b = r12;
        r16.f10232c = r13;
        r16.f10233d = r14;
        r16.f10240k = r15;
        return r16;
    }

    @SuppressLint({"NewApi"})
    public static b3 d(CellInfoGsm r8, boolean r10) {
        if (r8.getCellIdentity() != null) goto L6;
        return null;
    L6:
        CellIdentityGsm r11 = r8.getCellIdentity();
        b3 r12 = b(1, r10, r11.getMcc(), r11.getMnc(), r11.getLac(), r11.getCid(), r8.getCellSignalStrength().getDbm());
        r12.f10243n = r8.getCellIdentity().getBsic();
        r12.f10244o = r8.getCellIdentity().getArfcn();
        r12.f10245p = r8.getCellSignalStrength().getTimingAdvance();
        r12.f10247r = r8.getCellSignalStrength().getDbm();
        return r12;
    }

    public static b3 e(CellInfoLte r8, boolean r10) {
        if (r8.getCellIdentity() != null) goto L6;
        return null;
    L6:
        CellIdentityLte r11 = r8.getCellIdentity();
        b3 r12 = b(3, r10, r11.getMcc(), r11.getMnc(), r11.getTac(), r11.getCi(), r8.getCellSignalStrength().getDbm());
        r12.f10243n = r11.getPci();
        r12.f10244o = r11.getEarfcn();
        r12.f10245p = r8.getCellSignalStrength().getTimingAdvance();
        r12.f10247r = r8.getCellSignalStrength().getDbm();
        return r12;
    }

    public static b3 f(CellInfoNr r14, boolean r15) {
        if (r14.getCellIdentity() != null) goto L6;
        return null;
    L6:
        CellIdentityNr r8 = (CellIdentityNr) r14.getCellIdentity();
        int r10 = r8.getTac();
        int r11 = 0;
        if (r10 == Integer.MAX_VALUE) goto L9;
    L15:
        long r12 = r8.getNci();
        int r13 = Integer.parseInt(r8.getMccString());     // Catch: Throwable -> L21
        r11 = Integer.parseInt(r8.getMncString());     // Catch: Throwable -> L19
    L24:
        b3 r16 = b(5, r15, r13, r11, r8.getTac(), 0, ((CellSignalStrengthNr) r14.getCellSignalStrength()).getSsRsrp());
        r16.f10234e = r12;
        if (r10 <= 16777215) goto L27;
        r16.f10232c = 65535;
    L30:
        r16.f10243n = r8.getPci();
        r16.f10244o = r8.getNrarfcn();
        r16.f10247r = r14.getCellSignalStrength().getDbm();
        return r16;
    L27:
        if (r10 <= 65535) goto L29;
        r16.f10232c = 65535;
        r16.f10245p = r10;
        goto L30
    L29:
        r16.f10232c = r10;
    L19:
        Throwable th = th;
    L23:
        th.printStackTrace();
    L21:
        th = move-exception;
        th = th;
        r13 = 0;
        goto L23
    L9:
        if ("HUAWEI".equals(Build.MANUFACTURER) == false) goto L15;
        r10 = ((Integer) l6.a.g(r8, "getHwTac", new Object[0])).intValue();     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        th.printStackTrace();
        goto L15
    }

    public static b3 g(CellInfoWcdma r8, boolean r10) {
        if (r8.getCellIdentity() != null) goto L6;
        return null;
    L6:
        CellIdentityWcdma r11 = r8.getCellIdentity();
        b3 r12 = b(4, r10, r11.getMcc(), r11.getMnc(), r11.getLac(), r11.getCid(), r8.getCellSignalStrength().getDbm());
        r12.f10243n = r11.getPsc();
        r12.f10244o = r8.getCellIdentity().getUarfcn();
        r12.f10247r = r8.getCellSignalStrength().getDbm();
        return r12;
    }

    public final ArrayList a() {
        ArrayList r8 = new ArrayList();
        TelephonyManager r10 = this.f10271g;
        if (r10 == null) goto L5;
        List<CellInfo> r11 = r10.getAllCellInfo();
    L6:
        if (r11 == null) goto L23;
        Iterator<CellInfo> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L23;
        CellInfo r13 = r12.next();
        if ((r13 instanceof CellInfoCdma) == true) goto L12;
        if ((r13 instanceof CellInfoGsm) == true) goto L15;
        if ((r13 instanceof CellInfoLte) == false) goto L20;
        CellInfoLte r14 = (CellInfoLte) r13;
        CellIdentityLte r15 = r14.getCellIdentity();
        i2 r16 = new i2(r13.isRegistered());
        r16.f10402a = String.valueOf(r15.getMcc());
        r16.f10403b = String.valueOf(r15.getMnc());
        r16.f10522v = r15.getPci();
        r16.f10405n = r14.getCellSignalStrength().getAsuLevel();
        r16.f10521u = r15.getCi();
        r16.f10520t = r15.getTac();
        r16.f10524x = r14.getCellSignalStrength().getTimingAdvance();
        r16.f10404m = r14.getCellSignalStrength().getDbm();
        r16.f10523w = r15.getEarfcn();
        r8.add(r16);
        goto L9
    L20:
        if ((r13 instanceof CellInfoWcdma) == false) goto L9;
        CellInfoWcdma r17 = (CellInfoWcdma) r13;
        CellIdentityWcdma r18 = r17.getCellIdentity();
        j2 r19 = new j2(r13.isRegistered(), true);
        r19.f10402a = String.valueOf(r18.getMcc());
        r19.f10403b = String.valueOf(r18.getMnc());
        r19.f10624t = r18.getLac();
        r19.f10625u = r18.getCid();
        r19.f10626v = r18.getPsc();
        r19.f10405n = r17.getCellSignalStrength().getAsuLevel();
        r19.f10404m = r17.getCellSignalStrength().getDbm();
        r19.f10627w = r18.getUarfcn();
        Object r20 = r19;
    L22:
        r8.add(r20);
        goto L9
    L15:
        CellInfoGsm r21 = (CellInfoGsm) r13;
        CellIdentityGsm r22 = r21.getCellIdentity();
        h2 r23 = new h2(r13.isRegistered(), true);
        r23.f10402a = String.valueOf(r22.getMcc());
        r23.f10403b = String.valueOf(r22.getMnc());
        r23.f10498t = r22.getLac();
        r23.f10499u = r22.getCid();
        r23.f10404m = r21.getCellSignalStrength().getDbm();
        r23.f10405n = r21.getCellSignalStrength().getAsuLevel();
        r23.f10501w = r22.getArfcn();
        r23.f10502x = r22.getBsic();
        r20 = r23;
        goto L22
    L12:
        CellInfoCdma r24 = (CellInfoCdma) r13;
        CellIdentityCdma r25 = r24.getCellIdentity();
        g2 r26 = new g2(r13.isRegistered(), true);
        r26.f10449w = r25.getLatitude();
        r26.f10450x = r25.getLongitude();
        r26.f10446t = r25.getSystemId();
        r26.f10447u = r25.getNetworkId();
        r26.f10448v = r25.getBasestationId();
        r26.f10405n = r24.getCellSignalStrength().getAsuLevel();
        r26.f10404m = r24.getCellSignalStrength().getCdmaDbm();
        r20 = r26;
    L23:
        return r8;
    L5:
        r11 = null;
        goto L6
    }

    public final b3 c(CellInfoCdma r11, boolean r12) {
        if (r11.getCellIdentity() == null) goto L28;
        CellIdentityCdma r8 = r11.getCellIdentity();
        if (r8.getSystemId() > 0) goto L8;
        return null;
    L8:
        if (r8.getNetworkId() >= 0) goto L10;
        return null;
    L10:
        if (r8.getBasestationId() < 0) goto L27;
        CellIdentityCdma r10 = r11.getCellIdentity();
        String[] r13 = y3.q(this.f10271g);
        int r14 = 0;
        int r15 = Integer.parseInt(r13[0]);     // Catch: Throwable -> L16
        r14 = Integer.parseInt(r13[1]);     // Catch: Throwable -> L21
    L15:
        int r16 = r14;
        int r17 = r15;
    L17:
        b3 r18 = b(2, r12, r17, r16, 0, 0, r11.getCellSignalStrength().getCdmaDbm());
        r18.f10237h = r10.getSystemId();
        r18.f10238i = r10.getNetworkId();
        r18.f10239j = r10.getBasestationId();
        r18.f10235f = r10.getLatitude();
        r18.f10236g = r10.getLongitude();
        r18.f10247r = r11.getCellSignalStrength().getCdmaDbm();
        return r18;
    L16:
        r17 = 0;
        r16 = 0;
        goto L17
    L27:
        return null;
    L28:
        return null;
    }

    public final synchronized void h(CellLocation r8) {
        monitor-enter(this);
        String[] r10 = y3.q(this.f10271g);     // Catch: Throwable -> L23
        this.f10268d.clear();     // Catch: Throwable -> L23
        if ((r8 instanceof GsmCellLocation) == false) goto L16;
        GsmCellLocation r11 = (GsmCellLocation) r8;     // Catch: Throwable -> L23
        b3 r12 = new b3(1, true);     // Catch: Throwable -> L23
        r12.f10230a = Integer.parseInt(r10[0]);     // Catch: Throwable -> L23
        r12.f10231b = Integer.parseInt(r10[1]);     // Catch: Throwable -> L23
        r12.f10232c = r11.getLac();     // Catch: Throwable -> L23
        r12.f10233d = r11.getCid();     // Catch: Throwable -> L23
        SignalStrength r13 = this.f10275k;     // Catch: Throwable -> L23
        if (r13 == null) goto L12;
        int r14 = r13.getGsmSignalStrength();     // Catch: Throwable -> L23
        if (r14 != 99) goto L10;
        int r15 = Integer.MAX_VALUE;
    L11:
        r12.f10247r = r15;     // Catch: Throwable -> L23
        goto L12
    L10:
        r15 = (r14 * 2) + NetError.ERR_SSL_VERSION_OR_CIPHER_MISMATCH;     // Catch: Throwable -> L23
    L12:
        r12.f10246q = false;     // Catch: Throwable -> L23
        a3 r16 = this.f10272h;     // Catch: Throwable -> L23
        r16.getClass();     // Catch: Throwable -> L23
        r16.d(SystemClock.elapsedRealtime(), r12);     // Catch: Throwable -> L23
        this.f10268d.add(r12);     // Catch: Throwable -> L23
        monitor-exit(this);
        return;
    L16:
        if ((r8 instanceof CdmaCellLocation) == false) goto L21;
        CdmaCellLocation r17 = (CdmaCellLocation) r8;     // Catch: Throwable -> L23
        b3 r18 = new b3(2, true);     // Catch: Throwable -> L23
        r18.f10230a = Integer.parseInt(r10[0]);     // Catch: Throwable -> L23
        r18.f10231b = Integer.parseInt(r10[1]);     // Catch: Throwable -> L23
        r18.f10235f = r17.getBaseStationLatitude();     // Catch: Throwable -> L23
        r18.f10236g = r17.getBaseStationLongitude();     // Catch: Throwable -> L23
        r18.f10237h = r17.getSystemId();     // Catch: Throwable -> L23
        r18.f10238i = r17.getNetworkId();     // Catch: Throwable -> L23
        r18.f10239j = r17.getBaseStationId();     // Catch: Throwable -> L23
        SignalStrength r19 = this.f10275k;     // Catch: Throwable -> L23
        if (r19 == null) goto L20;
        r18.f10247r = r19.getCdmaDbm();     // Catch: Throwable -> L23
    L20:
        r18.f10246q = false;     // Catch: Throwable -> L23
        a3 r20 = this.f10272h;     // Catch: Throwable -> L23
        r20.getClass();     // Catch: Throwable -> L23
        r20.d(SystemClock.elapsedRealtime(), r18);     // Catch: Throwable -> L23
        this.f10268d.add(r18);     // Catch: Throwable -> L23
    L21:
        monitor-exit(this);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public final synchronized void i(List<CellInfo> r10) {
        monitor-enter(this);
        ArrayList<b3> r8 = this.f10270f;     // Catch: Throwable -> L43
        if (r8 == null) goto L6;
        r8.clear();     // Catch: Throwable -> L43
    L6:
        if (r10 != null) goto L8;
    L41:
        monitor-exit(this);
        return;
    L8:
        if (r10.size() <= 0) goto L41;
        int r11 = 0;
    L12:
        if (r11 >= r10.size()) goto L34;
        CellInfo r12 = r10.get(r11);     // Catch: Throwable -> L43
        if (r12 == null) goto L33;
        boolean r13 = r12.isRegistered();     // Catch: Throwable -> L43
        if ((r12 instanceof CellInfoCdma) == false) goto L19;
        b3 r14 = c((CellInfoCdma) r12, r13);     // Catch: Throwable -> L43
    L31:
        if (r14 == null) goto L33;
        a3 r15 = this.f10272h;     // Catch: Throwable -> L43
        r15.getClass();     // Catch: Throwable -> L43
        r15.d(SystemClock.elapsedRealtime(), r14);     // Catch: Throwable -> L43
        a3 r16 = this.f10272h;     // Catch: Throwable -> L43
        r16.getClass();     // Catch: Throwable -> L43
        Math.min(65535, (SystemClock.elapsedRealtime() - r16.g(r14)) / 1000);     // Catch: Throwable -> L43
        r14.f10246q = true;     // Catch: Throwable -> L43
        this.f10270f.add(r14);     // Catch: Throwable -> L43
        goto L33
    L19:
        if ((r12 instanceof CellInfoGsm) == false) goto L22;
        r14 = d((CellInfoGsm) r12, r13);     // Catch: Throwable -> L43
        goto L31
    L22:
        if ((r12 instanceof CellInfoWcdma) == false) goto L25;
        r14 = g((CellInfoWcdma) r12, r13);     // Catch: Throwable -> L43
        goto L31
    L25:
        if ((r12 instanceof CellInfoLte) == false) goto L28;
        r14 = e((CellInfoLte) r12, r13);     // Catch: Throwable -> L43
        goto L31
    L28:
        if ((r12 instanceof CellInfoNr) == false) goto L30;
        r14 = f((CellInfoNr) r12, r13);     // Catch: Throwable -> L43
        goto L31
    L30:
        r14 = null;
    L33:
        r11 = r11 + 1;     // Catch: Throwable -> L43
        goto L12
    L34:
        this.f10266b = false;     // Catch: Throwable -> L43
        ArrayList<b3> r17 = this.f10270f;     // Catch: Throwable -> L43
        if (r17 != null) goto L37;
    L39:
        monitor-exit(this);
        return;
    L37:
        if (r17.size() <= 0) goto L39;
        this.f10266b = true;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        throw th;
    }

    public final void j(boolean r8, boolean r10) {
        boolean r11 = y3.h(this.f10265a);     // Catch: Throwable -> L15 SecurityException -> L18
        this.f10279o = r11;     // Catch: Throwable -> L15 SecurityException -> L18
        if (r11 == false) goto L6;
    L7:
        boolean r12 = false;
    L9:
        if (r12 == false) goto L12;
        k(r8, r10);     // Catch: Throwable -> L15 SecurityException -> L18
        h(o());     // Catch: Throwable -> L15 SecurityException -> L18
        i(p());     // Catch: Throwable -> L15 SecurityException -> L18
    L12:
        if (this.f10279o == false) goto L23;
        m();     // Catch: Throwable -> L15 SecurityException -> L18
        return;
    L23:
        return;
    L6:
        if ((SystemClock.elapsedRealtime() - this.f10273i) < 45000) goto L7;
        r12 = true;
    L18:
        e = move-exception;
        this.f10283s = e.getMessage();
        return;
    L15:
        th = move-exception;
        t3.g("CgiManager", "refresh", th);
    }

    @SuppressLint({"NewApi"})
    public final void k(boolean r8, boolean r10) {
        if (this.f10279o == false) goto L5;
    L25:
        this.f10267c = false;
        TelephonyManager r11 = this.f10271g;
        if (r11 == null) goto L30;
        String r12 = r11.getNetworkOperator();
        this.f10269e = r12;
        if (TextUtils.isEmpty(r12) == true) goto L30;
        this.f10267c = true;
    L30:
        this.f10273i = SystemClock.elapsedRealtime();
        return;
    L5:
        if (this.f10271g == null) goto L25;
        if (this.f10265a.getApplicationInfo().targetSdkVersion < 29) goto L25;
        if (this.f10277m != null) goto L35;
        this.f10277m = new a(this);
    L35:
        this.f10271g.requestCellInfoUpdate(l1.f10784d.f10847a, this.f10277m);     // Catch: Throwable -> L13
    L15:
        if (r10 == true) goto L17;
        if (r8 == false) goto L25;
    L17:
        int r13 = 0;
    L19:
        if (this.f10278n == true) goto L25;
        if (r13 >= 20) goto L25;
        Thread.sleep(5);     // Catch: Throwable -> L32
    L24:
        r13 = r13 + 1;
    L13:
        th = move-exception;
        t3.g("Cgi", "refreshCgi", th);
        goto L15
    }

    public final synchronized b3 l() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.f10279o == false) goto L8;
        monitor-exit(this);
        return null;
    L8:
        ArrayList<b3> r8 = this.f10268d;     // Catch: Throwable -> L15
        if (r8.size() <= 0) goto L13;
        b3 r10 = r8.get(0).c();     // Catch: Throwable -> L15
        monitor-exit(this);
        return r10;
    L13:
        monitor-exit(this);
        return null;
    }

    public final synchronized void m() {
        monitor-enter(this);
        this.f10283s = null;     // Catch: Throwable -> L7
        this.f10268d.clear();     // Catch: Throwable -> L7
        this.f10270f.clear();     // Catch: Throwable -> L7
        this.f10266b = false;     // Catch: Throwable -> L7
        this.f10267c = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void n() {
    L32:
        e = move-exception;
        e.printStackTrace();
        return;
    L4:
        if (this.f10274j != null) goto L7;
        this.f10274j = new b(this);     // Catch: Exception -> L32
    L7:
        String r8 = "hasFineLocPerm";
        if (this.f10265a.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) goto L10;
        this.f10282r = "hasFineLocPerm";     // Catch: Exception -> L32
        int r10 = 336;
    L11:
        boolean r11 = false;
        if (this.f10265a.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) goto L14;
        boolean r12 = true;
    L16:
        if (this.f10265a.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0) goto L18;
        r11 = true;
    L18:
        if (r12 == false) goto L21;
        if (r11 == false) goto L21;
        r10 = r10 | 1024;     // Catch: Exception -> L32
    L21:
        if (r12 == false) goto L23;
        String r13 = "hasReadPhoneStatePerm";
    L24:
        this.f10281q = r13;     // Catch: Exception -> L32
        if (r11 == true) goto L28;
        r8 = "hasNoFineLocPerm";
    L28:
        this.f10282r = r8;     // Catch: Exception -> L32
        b r14 = this.f10274j;     // Catch: Exception -> L32
        if (r14 == null) goto L37;
        this.f10271g.listen(r14, r10);     // Catch: Exception -> L32
        this.f10286v = true;     // Catch: Exception -> L32
        return;
    L37:
        return;
    L23:
        r13 = "hasNoReadPhoneStatePerm";
        goto L24
    L14:
        r12 = false;
        goto L16
    L10:
        this.f10282r = "hasNoFineLocPerm";     // Catch: Exception -> L32
        r10 = 320;
        goto L11
    }

    public final CellLocation o() {
        TelephonyManager r8 = this.f10271g;
        if (r8 != null) goto L5;
        return null;
    L5:
        if (r8 == null) goto L15;
        CellLocation r10 = r8.getCellLocation();     // Catch: Throwable -> L8 SecurityException -> L10
        this.f10283s = null;     // Catch: Throwable -> L8 SecurityException -> L10
    L16:
        return r10;
    L10:
        e = move-exception;
        this.f10283s = e.getMessage();
        return null;
    L8:
        th = move-exception;
        this.f10283s = null;
        t3.g("CgiManager", "getCellLocation", th);
        return null;
    L15:
        return null;
    }

    @SuppressLint({"NewApi"})
    public final List<CellInfo> p() {
    L22:
        th = move-exception;
        t3.g("Cgi", "getNewCells", th);
        return null;
    L4:
        if (y3.w() >= 18) goto L6;
        return null;
    L6:
        TelephonyManager r8 = this.f10271g;     // Catch: Throwable -> L22
        if (r8 != null) goto L9;
        return null;
    L9:
        if (r8 != null) goto L25;
        List<CellInfo> r10 = null;
    L28:
        this.f10283s = null;     // Catch: SecurityException -> L17 Throwable -> L22
        return r10;
    L17:
        e = move-exception;
        List<CellInfo> r11 = r10;
        e = e;
    L19:
        this.f10283s = e.getMessage();     // Catch: Throwable -> L22
        return r11;
    L25:
        r10 = r8.getAllCellInfo();     // Catch: SecurityException -> L12 Throwable -> L22
    L12:
        e = e;
        r11 = null;
        goto L19
    }
}
