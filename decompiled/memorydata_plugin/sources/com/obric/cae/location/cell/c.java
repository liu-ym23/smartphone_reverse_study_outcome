package com.obric.cae.location.cell;

import android.content.Context;
import android.database.Cursor;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrength;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.cae.libs.location.CoordinateTransformUtils;
import com.obric.cae.location.geosdk.poi.StarPoiManager;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import okhttp3.HttpUrl;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.apache.logging.log4j.message.StructuredDataId;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f7034a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f7035b = null;
    public static final Set<String> c = null;
    public static final Set<String> d = null;
    public static volatile c e;
    public final Context f;
    public final TelephonyManager g;
    public final com.obric.cae.location.database.a h;
    public final e i;
    public final Object j;
    public final CopyOnWriteArraySet k;
    public final CopyOnWriteArraySet l;
    public final C0351c m;
    public HandlerThread n;
    public Handler o;
    public d p;
    public Runnable q;
    public b r;
    public b s;
    public List<b> t;
    public Location u;
    public boolean v;
    public boolean w;

    public interface a {
        void a(List<b> r1);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7037b;
        public final String c;
        public final long d;
        public final long e;
        public final int f;
        public final boolean g;
        public final long h;
        public final double i;
        public final double j;
        public final double k;

        public b(String r19, String r20, String r21, long r22, long r24, int r26, boolean r27, long r28) {
            this(r19, r20, r21, r22, r24, r26, r27, r28, -1.0d, -1.0d, -1.0d);
        }

        public b(String r4, String r5, String r6, long r7, long r9, int r11, boolean r12, long r13, double r15, double r17, double r19) {
            this.f7036a = r4;
            this.f7037b = a(r5);
            this.c = b(r6);
            this.d = a(r7);
            this.e = a(r9);
            this.f = a(r11);
            this.g = r12;
            this.h = r13;
            this.i = a(r15);
            this.j = a(r17);
            this.k = a(r19);
        }

        public static double a(double r1) {
            if (Double.isNaN(r1) == false) goto L5;
        L6:
            return -1.0d;
        L5:
            if (Double.isInfinite(r1) == true) goto L6;
            return r1;
        }

        public static int a(int r1) {
            if (r1 != Integer.MAX_VALUE) goto L6;
            return -1;
        L6:
            return r1;
        }

        public static int a(CellSignalStrength r0) {
            if (r0 != null) goto L5;
            return -1;
        L5:
            return a(r0.getDbm());
        }

        public static long a(long r2) {
            if (r2 != 2147483647L) goto L5;
        L6:
            return -1;
        L5:
            if (r2 == Long.MAX_VALUE) goto L6;
            return r2;
        }

        public static long a(CellInfo r4) {
            if (r4.getTimestampMillis() > 0) goto L6;
            return 0;
        L6:
            return r4.getTimestampMillis();
        }

        public static String a(String r1) {
            if (TextUtils.isEmpty(r1) == false) goto L6;
            return StructuredDataId.RESERVED;
        L6:
            return r1;
        }

        public static boolean a(b r4) {
            if (TextUtils.isEmpty(r4.f7036a) == false) goto L5;
        L19:
            return false;
        L5:
            if (TextUtils.equals(StructuredDataId.RESERVED, r4.f7036a) == true) goto L19;
            if (TextUtils.isEmpty(r4.f7037b) == true) goto L19;
            if (TextUtils.equals(StructuredDataId.RESERVED, r4.f7037b) == true) goto L19;
            if (TextUtils.isEmpty(r4.c) == true) goto L19;
            if (TextUtils.equals(StructuredDataId.RESERVED, r4.c) == true) goto L19;
            if (r4.d == (-1)) goto L19;
            if (r4.e == (-1)) goto L19;
            return true;
        }

        public static String b(String r1) {
            String r2 = a(r1);
            if (TextUtils.equals(StructuredDataId.RESERVED, r2) == false) goto L8;
            return r2;
        L8:
            return String.valueOf(Integer.parseInt(r2));
        L10:
            return r2;
        }

        public static boolean b(b r5) {
            double r0 = r5.k;
            if (r0 > 0.0d) goto L5;
        L9:
            return false;
        L5:
            if (r0 > 3.4028234663852886E38d) goto L9;
            if (com.obric.cae.location.util.d.a().a(r5.i, r5.j) == false) goto L9;
            return true;
        }

        public b a(double r21, double r23, double r25) {
            return new b(this.f7036a, this.f7037b, this.c, this.d, this.e, this.f, this.g, this.h, r21, r23, r25);
        }

        public String a() {
            return this.f7037b;
        }

        public String b() {
            return this.c;
        }

        public long c() {
            return this.d;
        }

        public long d() {
            return this.e;
        }

        public String e() {
            return this.f7036a + ParameterizedMessage.ERROR_MSG_SEPARATOR + this.f7037b + ParameterizedMessage.ERROR_MSG_SEPARATOR + this.c + ParameterizedMessage.ERROR_MSG_SEPARATOR + this.d + ParameterizedMessage.ERROR_MSG_SEPARATOR + this.e;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.memorydata.plugin");
            if (this.d != r10.d) goto L20;
            if (this.e != r10.e) goto L20;
            if (TextUtils.equals(this.f7036a, r10.f7036a) == false) goto L20;
            if (TextUtils.equals(this.f7037b, r10.f7037b) == false) goto L20;
            if (TextUtils.equals(this.c, r10.c) == false) goto L20;
            return true;
        L20:
            return false;
        }

        public String getType() {
            return this.f7036a;
        }

        public int hashCode() {
            int r0 = this.f7036a.hashCode() * 31;
            int r1 = (this.f7037b.hashCode() + r0) * 31;
            int r2 = (this.c.hashCode() + r1) * 31;
            long r3 = this.d;
            int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
            long r5 = this.e;
            return r4 + ((int) (r5 ^ (r5 >>> 32)));
        }

        public String toString() {
            return "StarCellInfo[cell=" + e() + ", dbm=" + this.f + ", registered=" + this.g + ", timestampMillis=" + this.h + ", latitude=" + this.i + ", longitude=" + this.j + ", radius=" + this.k + ']';
        }
    }

    /* JADX INFO: renamed from: com.obric.cae.location.cell.c$c, reason: collision with other inner class name */
    public class C0351c extends InnerAwareInfoCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f7038a;

        public C0351c(c r1) {
            this.f7038a = r1;
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public final void onLocationChanged(Location r6) {
            c r5 = this.f7038a;
            Set<String> r0 = c.f7034a;
            r5.getClass();
            if (r6 != null) goto L5;
        L23:
            StringBuilder r7 = new StringBuilder("skip near cell db refresh for invalid location=").append(r6);
        L24:
            com.obric.cae.log.a.d("StarLocation-cell", r7.toString());
            return;
        L5:
            if (com.obric.cae.location.util.d.a().a(r6.getLatitude(), r6.getLongitude()) == false) goto L23;
            double r1 = r5.a(r6);
            if (r1 >= 0.0d) goto L10;
        L12:
            boolean r2 = r5.h.a(r6);
            if (r2 == false) goto L22;
            Object r3 = r5.j;
            monitor-enter(r3);
            r5.u = new Location(r6);     // Catch: Throwable -> L19
            monitor-exit(r3);     // Catch: Throwable -> L19
        L19:
            th = move-exception;
            throw th;
        L22:
            r7 = new StringBuilder("refresh near cell db after location changed, distanceMeters=").append(r1).append(", thresholdMeters=500.0, refreshed=").append(r2);
            goto L24
        L10:
            if (r1 > 500.0d) goto L12;
            r7 = new StringBuilder("skip near cell db refresh, distanceMeters=").append(r1).append(", thresholdMeters=500.0");
            goto L24
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public final void onNetworkValid(boolean r3) {
            com.obric.cae.log.a.d("StarLocation-cell", "onNetworkValid, valid=" + r3);
            if (r3 == false) goto L6;
            c r2 = this.f7038a;
            Set<String> r4 = c.f7034a;
            r2.a();
            return;
        }
    }

    public final class d extends TelephonyCallback implements TelephonyCallback.CellInfoListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f7039a;

        public d(c r1) {
            this.f7039a = r1;
        }

        @Override // android.telephony.TelephonyCallback.CellInfoListener
        public final void onCellInfoChanged(List<CellInfo> r3) {
            List<CellInfo> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
            c r2 = this.f7039a;
            Set<String> r0 = c.f7034a;
            r2.a(r4);
        }
    }

    static {
        f7034a = ConcurrentHashMap.newKeySet();
        f7035b = ConcurrentHashMap.newKeySet();
        ConcurrentHashMap.KeySetView r0 = ConcurrentHashMap.newKeySet();
        c = r0;
        ConcurrentHashMap.KeySetView r1 = ConcurrentHashMap.newKeySet();
        d = r1;
        r1.add("011901");
        r1.add("052201");
        r1.add("052202");
        r0.addAll(r1);
    }

    public c(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.j = new Object();
        this.k = new CopyOnWriteArraySet();
        this.l = new CopyOnWriteArraySet();
        this.m = new C0351c(this);
        this.t = Collections.emptyList();
        this.v = true;
        com.obric.cae.log.a.f("StarLocation-cell", "StarCellManager constructor");
        Context r6 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r5.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        this.f = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.g = (TelephonyManager) ZeusTransformUtils.preCheckCast(r6.getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");
        com.obric.cae.location.database.a r7 = com.obric.cae.location.database.a.a(r6);
        this.h = r7;
        r7.a();
        this.i = new e(new $$Lambda$BLNdV1rGyxpKtGbWqHtwDRMfOQ(this));
    }

    public static synchronized c a(Context r3) {
        monitor-enter(c.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (e != null) goto L7;
        e = new c(r4);     // Catch: Throwable -> L10
    L7:
        c r5 = e;     // Catch: Throwable -> L10
        monitor-exit(c.class);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    public static void a(b r9) {
        if (b.b(r9) == true) goto L7;
        StringBuilder r0 = new StringBuilder("skip cell location source without valid location, cell=");
    L5:
        com.obric.cae.log.a.d("StarLocation-cell", r0.append(r9.e()).toString());
        return;
    L7:
        com.obric.cae.location.a r1 = com.obric.cae.location.a.a();
        long r2 = System.currentTimeMillis();
        com.obric.cae.location.util.d r4 = com.obric.cae.location.util.d.a();
        Bundle r5 = new Bundle();
        r5.putString("cellId", r9.e());
        boolean r3 = r1.d(new com.obric.cae.location.a.C0349a().a(6).a(LocationAnnotation.LightLocationType.LIGHT_LOCATION_CELL).a(r2).b(SystemClock.elapsedRealtimeNanos()).c(r2).a(r9.i).b(r9.j).a((float) r9.k).a(CoordinateTransformUtils.CoordinateSystem.WGS84).b(4).b(r4.u()).c(r4.f()).a(r5).c(0));
        r0 = new StringBuilder("update cell location source, updated=").append(r3).append(", cell=");
        goto L5
    }

    private /* synthetic */ void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        this.o.post(r4);
    }

    public static boolean a(String r5) {
        if (TextUtils.isEmpty(r5) == false) goto L5;
        return false;
    L5:
        String r6 = r5.trim();
        if (c.contains(r6) == false) goto L9;
        return true;
    L9:
        if (r6.length() >= 6) goto L11;
        return false;
    L11:
        String r0 = r6.substring(0, 2) + "0000";
        String r7 = r6.substring(0, 4) + "00";
        if (f7034a.contains(r0) == true) goto L16;
        if (f7035b.contains(r7) == true) goto L16;
        return false;
    L16:
        return true;
    }

    private void b(Executor r3) {
        Executor r4 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (this.w == true) goto L7;
    L17:
        com.obric.cae.log.a.d("StarLocation-cell", "skip requestCellInfoUpdate, listener stopped");     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L7:
        if (this.p == null) goto L17;
        monitor-exit(this);     // Catch: Throwable -> L20
        this.g.requestCellInfoUpdate(r4, new f(this));     // Catch: Throwable -> L12 SecurityException -> L14
        com.obric.cae.log.a.d("StarLocation-cell", "requestCellInfoUpdate success");     // Catch: Throwable -> L12 SecurityException -> L14
    L27:
        return;
    L14:
        e = move-exception;
        com.obric.cae.log.a.j("StarLocation-cell", "requestCellInfoUpdate failed: " + e.getMessage());
        return;
    L12:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-cell", "requestCellInfoUpdate failed", th);
    }

    public static boolean b(String r1) {
        if (TextUtils.isEmpty(r1) == false) goto L7;
        return false;
    L7:
        return d.contains(r1.trim());
    }

    /* JADX INFO: renamed from: lambda$OnSRSk-rGXMx3uqiYsUiNBXmdfs, reason: not valid java name */
    public static /* synthetic */ void m375lambda$OnSRSkrGXMx3uqiYsUiNBXmdfs(c r0, Executor r1) {
        r0.b(r1);
    }

    public static /* synthetic */ void lambda$VqHdI5ywZFi7nJN5r9IZkbjyej8(c r0, Runnable r1) {
        r0.a(r1);
    }

    public final double a(Location r10) {
        Object r0 = this.j;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.u != null) goto L7;
        Location r9 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L14
        if (r9 != null) goto L13;
        return -1.0d;
    L13:
        return com.obric.cae.location.util.d.a().a(r9.getLatitude(), r9.getLongitude(), r10.getLatitude(), r10.getLongitude());
    L7:
        r9 = new Location(this.u);     // Catch: Throwable -> L14
        goto L8
    }

    public final void a() {
        if (com.obric.cae.location.util.d.a().e() == true) goto L5;
        return;
    L5:
        Object r0 = this.j;
        monitor-enter(r0);
    L27:
        th = move-exception;
        throw th;
    L8:
        if (this.v == true) goto L25;
        b r1 = this.s;     // Catch: Throwable -> L27
        if (r1 == null) goto L25;
        monitor-exit(r0);     // Catch: Throwable -> L27
        com.obric.cae.log.a.d("StarLocation-cell", "network valid, retry pending cell area query: " + r1.e());
        b r2 = c(r1);
        if (r2 != null) goto L31;
        b r5 = d(r1);
        if (r5 == null) goto L33;
        a(r5);
        return;
    L33:
        return;
    L31:
        com.obric.cae.location.geosdk.poi.a.a(this.f, 0).f(r2.toString());     // Catch: Throwable -> L17
    L19:
        a(r2);
        f(r1);
        return;
    L17:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-cell", "dump cell info to poi log failed: " + r2.e(), th);
    L25:
        monitor-exit(r0);     // Catch: Throwable -> L27
    }

    public final void a(int r4, int r5, int r6, int r7, long r8, int r10) {
        String r9 = com.obric.cae.libs.statemachine.e.a(com.obric.cae.location.b.a("CellPoiStatusChange[clientId=", r4, ", cellPoiType=", r5, ", rat="), r6, ", tac=", r7, ", cellid=").append(r8).append(", pci=").append(r10).append(']').toString();
        com.obric.cae.log.a.f("StarLocation-cell", r9);
        com.obric.cae.location.geosdk.poi.a.a(this.f, 0).f(r9);     // Catch: Throwable -> L5
        StarPoiManager.a().a(r5, r8);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-cell", "dump cell poi status to poi log failed", th);
    }

    public final void a(ArrayList r12) {
        Object r0 = this.j;
        monitor-enter(r0);
    L46:
        th = move-exception;
        throw th;
    L5:
        if (r12.equals(this.t) == false) goto L9;
        com.obric.cae.log.a.b("StarLocation-cell", "neighbor cells not changed");     // Catch: Throwable -> L46
        monitor-exit(r0);     // Catch: Throwable -> L46
        return;
    L9:
        List<b> r1 = this.t;     // Catch: Throwable -> L46
        if (r12.isEmpty() == false) goto L12;
        List r2 = Collections.emptyList();     // Catch: Throwable -> L46
    L19:
        this.t = Collections.unmodifiableList(new ArrayList(r12));     // Catch: Throwable -> L46
        monitor-exit(r0);     // Catch: Throwable -> L46
        StringBuilder r3 = new StringBuilder("neighbor cells changed: ");
        if (r12.isEmpty() == false) goto L24;
        String r4 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L31:
        com.obric.cae.log.a.d("StarLocation-cell", r3.append(r4).toString());
        Iterator r5 = r2.iterator();
    L33:
        if (r5.hasNext() == false) goto L37;
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5.next(), b.class, "com.obric.memorydata.plugin");
        if (b(r6) == true) goto L33;
        com.obric.cae.log.a.d("StarLocation-cell", "insert cell info, inserted=" + this.h.a(new com.obric.cae.location.database.a.C0353a(r6.getType(), r6.a(), r6.b(), r6.c(), r6.d())) + ", cell=" + r6.e());
        goto L33
    L37:
        List<b> r13 = Collections.unmodifiableList(new ArrayList(r12));
        Iterator r11 = this.l.iterator();
    L39:
        if (r11.hasNext() == false) goto L45;
        ((a) ZeusTransformUtils.preCheckCast(r11.next(), a.class, "com.obric.memorydata.plugin")).a(r13);     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-cell", "notify cell callback failed", th);
        goto L39
    L45:
        return;
    L24:
        StringBuilder r7 = new StringBuilder("[");
        int r8 = 0;
    L26:
        if (r8 >= r12.size()) goto L30;
        if (r8 <= 0) goto L29;
        r7.append(", ");
    L29:
        r7.append(((b) ZeusTransformUtils.preCheckCast(r12.get(r8), b.class, "com.obric.memorydata.plugin")).e());
        r8 = r8 + 1;
        goto L26
    L30:
        r7.append(']');
        r4 = r7.toString();
        goto L31
    L12:
        ArrayList r9 = new ArrayList();     // Catch: Throwable -> L46
        Iterator r10 = r12.iterator();     // Catch: Throwable -> L46
    L14:
        if (r10.hasNext() == false) goto L18;
        b r14 = (b) ZeusTransformUtils.preCheckCast(r10.next(), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L46
        if (r1.contains(r14) == true) goto L14;
        r9.add(r14);     // Catch: Throwable -> L46
        goto L14
    L18:
        r2 = r9;
        goto L19
    }

    public final void a(List<CellInfo> r22) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L90:
        com.obric.cae.log.a.b("StarLocation-cell", "cellInfos is null or empty");
        return;
    L5:
        if (r0.isEmpty() == true) goto L90;
        ArrayList r2 = new ArrayList();
        Iterator r1 = r0.iterator();
        b r4 = null;
    L9:
        if (r1.hasNext() == false) goto L44;
        CellInfo r5 = (CellInfo) ZeusTransformUtils.preCheckCast(r1.next(), CellInfo.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L14;
    L32:
        b r6 = null;
    L33:
        if (r6 == null) goto L34;
        if (b.a(r6) == false) goto L37;
        if (r5.isRegistered() == true) goto L40;
        com.obric.cae.log.a.b("StarLocation-cell", "neighbor cell, cell=" + r6.e());
        r2.add(r6);
        goto L9
    L40:
        com.obric.cae.log.a.b("StarLocation-cell", "registered cell, cell=" + r6.e());
        if (r4 != null) goto L9;
        r4 = r6;
        goto L9
    L37:
        com.obric.cae.log.a.d("StarLocation-cell", "skip invalid cell identity: " + r6.e());
        goto L9
    L34:
        com.obric.cae.log.a.b("StarLocation-cell", "skip unknown cell type, class=".concat(r5.getClass().getSimpleName()));
        goto L9
    L14:
        if (ZeusTransformUtils.instanceOf(r5, CellInfoGsm.class) == false) goto L18;
        CellInfoGsm r7 = (CellInfoGsm) ZeusTransformUtils.preCheckCast(r5, CellInfoGsm.class, "com.obric.memorydata.plugin");
        CellIdentityGsm r8 = r7.getCellIdentity();
        b r20 = new b(LocationInfoConst.GSM, r8.getMccString(), r8.getMncString(), r8.getLac(), r8.getCid(), b.a(r7.getCellSignalStrength()), r5.isRegistered(), b.a(r5));
    L16:
        r6 = r20;
        goto L33
    L18:
        if (ZeusTransformUtils.instanceOf(r5, CellInfoWcdma.class) == false) goto L21;
        CellInfoWcdma r9 = (CellInfoWcdma) ZeusTransformUtils.preCheckCast(r5, CellInfoWcdma.class, "com.obric.memorydata.plugin");
        CellIdentityWcdma r10 = r9.getCellIdentity();
        r20 = new b(LocationInfoConst.WCDMA, r10.getMccString(), r10.getMncString(), r10.getLac(), r10.getCid(), b.a(r9.getCellSignalStrength()), r5.isRegistered(), b.a(r5));
        goto L16
    L21:
        if (ZeusTransformUtils.instanceOf(r5, CellInfoTdscdma.class) == false) goto L24;
        CellInfoTdscdma r11 = (CellInfoTdscdma) ZeusTransformUtils.preCheckCast(r5, CellInfoTdscdma.class, "com.obric.memorydata.plugin");
        CellIdentityTdscdma r12 = r11.getCellIdentity();
        r20 = new b("tdscdma", r12.getMccString(), r12.getMncString(), r12.getLac(), r12.getCid(), b.a(r11.getCellSignalStrength()), r5.isRegistered(), b.a(r5));
        goto L16
    L24:
        if (ZeusTransformUtils.instanceOf(r5, CellInfoLte.class) == false) goto L27;
        CellInfoLte r13 = (CellInfoLte) ZeusTransformUtils.preCheckCast(r5, CellInfoLte.class, "com.obric.memorydata.plugin");
        CellIdentityLte r14 = r13.getCellIdentity();
        r20 = new b(LocationInfoConst.LTE, r14.getMccString(), r14.getMncString(), r14.getTac(), r14.getCi(), b.a(r13.getCellSignalStrength()), r5.isRegistered(), b.a(r5));
        goto L16
    L27:
        if (ZeusTransformUtils.instanceOf(r5, CellInfoNr.class) == false) goto L30;
        CellInfoNr r15 = (CellInfoNr) ZeusTransformUtils.preCheckCast(r5, CellInfoNr.class, "com.obric.memorydata.plugin");
        CellIdentityNr r16 = (CellIdentityNr) ZeusTransformUtils.preCheckCast(r15.getCellIdentity(), CellIdentityNr.class, "com.obric.memorydata.plugin");
        r20 = new b(LocationInfoConst.NR, r16.getMccString(), r16.getMncString(), r16.getTac(), r16.getNci(), b.a(r15.getCellSignalStrength()), r5.isRegistered(), b.a(r5));
        goto L16
    L30:
        if (ZeusTransformUtils.instanceOf(r5, CellInfoCdma.class) == false) goto L32;
        CellInfoCdma r17 = (CellInfoCdma) ZeusTransformUtils.preCheckCast(r5, CellInfoCdma.class, "com.obric.memorydata.plugin");
        CellIdentityCdma r18 = r17.getCellIdentity();
        r20 = new b(LocationInfoConst.CDMA, StructuredDataId.RESERVED, String.valueOf(b.a(r18.getSystemId())), r18.getNetworkId(), r18.getBasestationId(), b.a(r17.getCellSignalStrength()), r5.isRegistered(), b.a(r5));
        goto L16
    L44:
        boolean r3 = true;
        if (r4 != null) goto L48;
        com.obric.cae.log.a.b("StarLocation-cell", "serving cell is null");
    L47:
        r3 = false;
    L83:
        if (r3 == true) goto L85;
        return;
    L85:
        a(r2);
        return;
    L48:
        Object r19 = this.j;
        monitor-enter(r19);
    L87:
        th = move-exception;
        throw th;
    L51:
        if (r4.equals(this.r) == true) goto L53;
        this.r = r4;     // Catch: Throwable -> L87
        boolean r21 = false;
    L61:
        monitor-exit(r19);     // Catch: Throwable -> L87
        if (r21 == false) goto L64;
        com.obric.cae.log.a.d("StarLocation-cell", "serving cell not changed, retry pending cell area query: " + r4.e());
        a();
        goto L47
    L64:
        com.obric.cae.log.a.d("StarLocation-cell", "serving cell changed: " + r4.e());
        b r23 = c(r4);
        if (r23 == null) goto L72;
        com.obric.cae.log.a.d("StarLocation-cell", "serving cell exists in db, skip query: " + r4.e());
        com.obric.cae.location.geosdk.poi.a.a(this.f, 0).f(r23.toString());     // Catch: Throwable -> L69
    L71:
        a(r23);
        f(r4);
    L69:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-cell", "dump cell info to poi log failed: " + r23.e(), th);
        goto L71
    L72:
        b r24 = d(r4);
        if (r24 == null) goto L75;
        a(r24);
    L75:
        List<b> r25 = Collections.singletonList(r4);
        Iterator r26 = this.k.iterator();
    L77:
        if (r26.hasNext() == false) goto L83;
        ((a) ZeusTransformUtils.preCheckCast(r26.next(), a.class, "com.obric.memorydata.plugin")).a(r25);     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-cell", "notify cell callback failed", th);
        goto L77
    L53:
        if (this.v == false) goto L55;
    L57:
        com.obric.cae.log.a.b("StarLocation-cell", "serving cell not changed: " + r4.e());     // Catch: Throwable -> L87
        monitor-exit(r19);     // Catch: Throwable -> L87
        goto L47
    L55:
        if (r4.equals(this.s) == false) goto L57;
        r21 = true;
        goto L61
    }

    public final void a(Executor r4) {
        final Executor r5 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        Handler r0 = this.o;
        if (r0 == null) goto L7;
        Runnable r1 = this.q;
        if (r1 == null) goto L7;
        r0.removeCallbacks(r1);
    L7:
        this.q = null;
        Runnable r2 = new $$Lambda$c$OnSRSkrGXMx3uqiYsUiNBXmdfs(this, r5);
        this.q = r2;
        this.o.postDelayed(r2, 30000);
        com.obric.cae.log.a.d("StarLocation-cell", "schedule requestCellInfoUpdate delayMs=30000");
    }

    public synchronized void b() {
        monitor-enter(this);
        com.obric.cae.log.a.f("StarLocation-cell", "called, mIsListening=" + this.w);     // Catch: Throwable -> L66
        if (this.w == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        if (this.g != null) goto L13;
        com.obric.cae.log.a.j("StarLocation-cell", "failed: TelephonyManager is null");     // Catch: Throwable -> L66
        monitor-exit(this);
        return;
    L13:
        if (this.n != null) goto L15;
    L17:
        HandlerThread r0 = new HandlerThread("StarCellManager");     // Catch: Throwable -> L66
        this.n = r0;     // Catch: Throwable -> L66
        r0.start();     // Catch: Throwable -> L66
        this.o = new Handler(this.n.getLooper());     // Catch: Throwable -> L66
    L18:
        this.i.a();     // Catch: Throwable -> L66
        Executor r1 = new $$Lambda$c$VqHdI5ywZFi7nJN5r9IZkbjyej8(this);     // Catch: Throwable -> L66
        this.p = new d(this);     // Catch: Throwable -> L66
        UserAwareManager.getInstance().registerInnerCallback(this.m);     // Catch: Throwable -> L22 SecurityException -> L43
        this.g.registerTelephonyCallback(r1, this.p);     // Catch: Throwable -> L22 SecurityException -> L43
        this.w = true;     // Catch: Throwable -> L22 SecurityException -> L43
        com.obric.cae.log.a.f("StarLocation-cell", "success");     // Catch: Throwable -> L22 SecurityException -> L43
        a(this.g.getAllCellInfo());     // Catch: Throwable -> L22 SecurityException -> L43
        a(r1);     // Catch: Throwable -> L22 SecurityException -> L43
    L64:
        monitor-exit(this);
        return;
    L22:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-cell", "listen cell info failed", th);     // Catch: Throwable -> L66
        Handler r2 = this.o;     // Catch: Throwable -> L35
        if (r2 == null) goto L29;
        Runnable r3 = this.q;     // Catch: Throwable -> L35
        if (r3 == null) goto L29;
        r2.removeCallbacks(r3);     // Catch: Throwable -> L35
    L29:
        this.q = null;     // Catch: Throwable -> L35
        UserAwareManager.getInstance().unregisterInnerCallback(this.m);     // Catch: Throwable -> L35
        TelephonyManager r4 = this.g;     // Catch: Throwable -> L35
        if (r4 == null) goto L78;
        d r5 = this.p;     // Catch: Throwable -> L35
        if (r5 == null) goto L78;
        r4.unregisterTelephonyCallback(r5);     // Catch: Throwable -> L35
    L78:
        this.i.b();     // Catch: Throwable -> L39
    L41:
        this.p = null;     // Catch: Throwable -> L66
    L42:
        this.w = false;     // Catch: Throwable -> L66
        goto L64
    L39:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-cell", "stop wwan sensor service failed", th);     // Catch: Throwable -> L66
    L35:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-cell", "clear registered callbacks failed", th);     // Catch: Throwable -> L66
    L43:
        e = move-exception;
        com.obric.cae.log.a.j("StarLocation-cell", "listen cell info failed: " + e.getMessage());     // Catch: Throwable -> L66
        Handler r6 = this.o;     // Catch: Throwable -> L56
        if (r6 == null) goto L50;
        Runnable r7 = this.q;     // Catch: Throwable -> L56
        if (r7 == null) goto L50;
        r6.removeCallbacks(r7);     // Catch: Throwable -> L56
    L50:
        this.q = null;     // Catch: Throwable -> L56
        UserAwareManager.getInstance().unregisterInnerCallback(this.m);     // Catch: Throwable -> L56
        TelephonyManager r8 = this.g;     // Catch: Throwable -> L56
        if (r8 == null) goto L72;
        d r9 = this.p;     // Catch: Throwable -> L56
        if (r9 == null) goto L72;
        r8.unregisterTelephonyCallback(r9);     // Catch: Throwable -> L56
    L72:
        this.i.b();     // Catch: Throwable -> L60
    L62:
        this.p = null;     // Catch: Throwable -> L66
        goto L42
    L60:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-cell", "stop wwan sensor service failed", th);     // Catch: Throwable -> L66
    L56:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-cell", "clear registered callbacks failed", th);     // Catch: Throwable -> L66
        goto L72
    L15:
        if (this.o == null) goto L17;
    L66:
        th = move-exception;
        throw th;
    }

    public final boolean b(b r10) {
        Cursor r9 = this.h.a(r10.getType(), r10.a(), r10.b(), r10.c(), r10.d());     // Catch: Throwable -> L18
        if (r9 != null) goto L21;
    L14:
        boolean r1 = false;
    L15:
        if (r9 == null) goto L17;
        r9.close();     // Catch: Throwable -> L18
    L17:
        return r1;
    L21:
        if (r9.moveToFirst() == false) goto L14;
        r1 = true;
        goto L15
    L8:
        th = move-exception;
        r9.close();     // Catch: Throwable -> L11
    L13:
        throw th;     // Catch: Throwable -> L18
    L11:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-cell", "query cell info failed: " + r10.e(), th);
        return false;
    }

    public final b c(b r13) {
        Cursor r12 = this.h.a(r13.getType(), r13.a(), r13.b(), r13.c(), r13.d());     // Catch: Throwable -> L42
        if (r12 != null) goto L47;
    L39:
        if (r12 == null) goto L41;
        r12.close();     // Catch: Throwable -> L42
    L41:
        return null;
    L47:
    L33:
        th = move-exception;
        r12.close();     // Catch: Throwable -> L36
    L38:
        throw th;     // Catch: Throwable -> L42
    L36:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Throwable -> L42
        goto L38
    L6:
        if (r12.moveToFirst() == false) goto L39;
        int r3 = r12.getColumnIndex("latitude");     // Catch: Throwable -> L33
        double r4 = -1.0d;
        if (r3 >= 0) goto L11;
    L14:
        double r6 = -1.0d;
    L15:
        int r5 = r12.getColumnIndex("longitude");     // Catch: Throwable -> L33
        if (r5 >= 0) goto L18;
    L21:
        double r8 = -1.0d;
    L22:
        int r7 = r12.getColumnIndex("radius");     // Catch: Throwable -> L33
        if (r7 >= 0) goto L25;
    L28:
        b r9 = r13.a(r6, r8, r4);     // Catch: Throwable -> L33
        if (b.b(r9) == true) goto L31;
        com.obric.cae.log.a.d("StarLocation-cell", "cell info exists in db without valid location, cell=" + r13.e());     // Catch: Throwable -> L33
    L31:
        r12.close();     // Catch: Throwable -> L42
        return r9;
    L25:
        if (r12.isNull(r7) == true) goto L28;
        r4 = r12.getDouble(r7);     // Catch: Throwable -> L33
        goto L28
    L18:
        if (r12.isNull(r5) == true) goto L21;
        r8 = r12.getDouble(r5);     // Catch: Throwable -> L33
        goto L22
    L11:
        if (r12.isNull(r3) == true) goto L14;
        r6 = r12.getDouble(r3);     // Catch: Throwable -> L33
    L42:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-cell", "read cell info from db failed: " + r13.e(), th);
        return null;
    }

    public final b d(b r6) {
        boolean r1 = false;
        b r2 = null;
        if (com.obric.cae.location.util.d.a().e() == true) goto L13;
        Object r0 = this.j;
        monitor-enter(r0);
        this.s = r6;     // Catch: Throwable -> L10
        this.v = false;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
        com.obric.cae.log.a.d("StarLocation-cell", "network invalid, pending cell area query: " + r6.e());
        return null;
    L10:
        th = move-exception;
        throw th;
    L13:
        boolean r3 = com.obric.cae.location.geosdk.bytedance.a.a().c(Collections.singletonList(r6));
        if (r3 == false) goto L16;
        r2 = c(r6);
    L16:
        if (r2 == null) goto L18;
        f(r6);
    L19:
        StringBuilder r4 = new StringBuilder("query cell area, success=").append(r3).append(", hasValidLocation=");
        if (r2 != null) goto L22;
    L24:
        com.obric.cae.log.a.d("StarLocation-cell", r4.append(r1).append(", cell=").append(r6.e()).toString());
        return r2;
    L22:
        if (b.b(r2) == false) goto L24;
        r1 = true;
        goto L24
    L18:
        e(r6);
        goto L19
    }

    public final void e(b r2) {
        Object r0 = this.j;
        monitor-enter(r0);
        this.s = r2;     // Catch: Throwable -> L7
        this.v = false;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void f(b r3) {
        Object r0 = this.j;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (r3.equals(this.s) == false) goto L7;
        this.s = null;     // Catch: Throwable -> L10
    L7:
        this.v = true;     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }
}
