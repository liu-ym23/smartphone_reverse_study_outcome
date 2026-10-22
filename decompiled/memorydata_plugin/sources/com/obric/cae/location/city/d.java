package com.obric.cae.location.city;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.location.geosdk.poi.StarPoiManager;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.cae.userAware.datacollection.TrafficRecognitionInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f7055a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f7056b = 0;
    public static final long[] c = null;
    public static final long d = 0;
    public static volatile d e;
    public final com.obric.cae.location.cell.b.InterfaceC0350b A;
    public ExecutorService B;
    public final Context f;
    public final AtomicReference<String> g;
    public final Handler h;
    public final e i;
    public final AtomicBoolean j;
    public final AtomicReference<Location> k;
    public final AtomicReference<AoiBoard> l;
    public final Object m;
    public final Object n;
    public final AtomicInteger o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public final a v;
    public final AtomicBoolean w;
    public final b x;
    public final AtomicReference<String> y;
    public final AtomicBoolean z;

    public class a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f7057a;

        public a(d r1, Handler r2) {
            this.f7057a = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r2) {
            com.obric.cae.log.a.e("StarLocation-trafficGeo", "proactiveAgentObserver onChange");
            this.f7057a.c();
        }
    }

    public class b extends InnerAwareInfoCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f7058a;

        public b(d r1) {
            this.f7058a = r1;
        }

        private /* synthetic */ void a(int r3) {
            d r2 = this.f7058a;     // Catch: Throwable -> L4
            long[] r0 = d.c;     // Catch: Throwable -> L4
            r2.a(r3);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            com.obric.cae.log.a.b("StarLocation-trafficGeo", "handleFlightModeChanged error, state=" + r3, th);
        }

        private /* synthetic */ void a(AoiBoard r2) {
            d.a(this.f7058a, r2);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            com.obric.cae.log.a.b("StarLocation-trafficGeo", "handleTrafficAoiBoardEvent error", th);
        }

        public static /* synthetic */ void a(d r1) {
            long[] r0 = d.c;
            r1.d();
        }

        public static /* synthetic */ void lambda$SopRjLz4gswJYS6x7C7L2FaLoCk(b r0, int r1) {
            r0.a(r1);
        }

        /* JADX INFO: renamed from: lambda$pd-3p_bgtGqbP28RDGF5I9odrGI, reason: not valid java name */
        public static /* synthetic */ void m379lambda$pd3p_bgtGqbP28RDGF5I9odrGI(b r0, AoiBoard r1) {
            r0.a(r1);
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public final void onAoiBoardEvent(final AoiBoard r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            d.c(this.f7058a).execute(new $$Lambda$d$b$pd3p_bgtGqbP28RDGF5I9odrGI(this, r3));
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public final void onLocationChanged(Location r3) {
            if (r3 != null) goto L4;
            return;
        L4:
            d.a(this.f7058a).set(new Location(r3));
            if (d.b(this.f7058a).compareAndSet(false, true) == true) goto L7;
            return;
        L7:
            ExecutorService r4 = d.c(this.f7058a);
            final d r2 = this.f7058a;
            r4.execute(new $$Lambda$HQSErvsNBtBME6sv7CL5Czefiws(r2));
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public final void onflightModeChanged(final int r3) {
            d.c(this.f7058a).execute(new $$Lambda$d$b$SopRjLz4gswJYS6x7C7L2FaLoCk(this, r3));
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<StarGeofence> f7060b;
        public final boolean c;

        public c(String r3, List<StarGeofence> r4, boolean r5) {
            List<StarGeofence> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            this.f7059a = r3;
            this.f7060b = r6;
            this.c = r5;
        }
    }

    static {
        TimeUnit r0 = TimeUnit.MINUTES;
        f7055a = r0.toMillis(1);
        f7056b = r0.toMillis(5);
        c = new long[]{r0.toMillis(10), r0.toMillis(20), r0.toMillis(30)};
        d = TimeUnit.SECONDS.toMillis(20);
    }

    public d(Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        this.g = new AtomicReference(null);
        Handler r6 = new Handler(Looper.getMainLooper());
        this.h = r6;
        this.j = new AtomicBoolean(false);
        this.k = new AtomicReference(null);
        this.l = new AtomicReference(null);
        this.m = new Object();
        this.n = new Object();
        this.o = new AtomicInteger(0);
        this.p = -1;
        this.q = -1;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = true;
        this.v = new a(this, r6);
        this.w = new AtomicBoolean(false);
        this.x = new b(this);
        this.y = new AtomicReference(null);
        this.z = new AtomicBoolean(false);
        this.A = new $$Lambda$d$rOyynnl9TOoslywbnwb2Q7w_vI(this);
        this.f = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r11.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.i = new e("StarLocation-trafficGeo", "traffic", r6, new $$Lambda$RIU77e1xL_p6yB50MoKqwF9jA(this), new $$Lambda$0kqODdwguO3Z410NHc89gKLVQvA(this));
    }

    public static d a(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (e != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (e != null) goto L9;
        e = new d(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return e;
    }

    public static g.b a(String r18, List r19, String r20, String r21, String r22, int r23) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.memorydata.plugin");
        com.obric.cae.location.util.e r1 = new com.obric.cae.location.util.e().a("new_type_name", r20);
        if (r21.isEmpty() == true) goto L5;
        r1.a("new_type_code", r21);
    L5:
        List r2 = Arrays.asList(new String[]{r1.a("lbs_city", r18).a("and").b()});
        $$Lambda$PniSzR3uXy4Grl9IeikPbybSXg r12 = $$Lambda$PniSzR3uXy4Grl9IeikPbybSXg.INSTANCE;
        int r13 = Math.max(1, Math.min(r23, 10));
        if (r2.isEmpty() == false) goto L8;
        r2 = Collections.singletonList("");
    L8:
        LinkedHashMap r14 = new LinkedHashMap();
        Iterator r15 = r2.iterator();     // Catch: Throwable -> L25
    L11:
        if (r15.hasNext() == false) goto L40;
        String r16 = (String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        Iterator r17 = r0.iterator();     // Catch: Throwable -> L25
    L14:
        if (r17.hasNext() == false) goto L11;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r17.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L25
        if (r3 == null) goto L14;
        if (r3.isEmpty() == true) goto L14;
        if (g.a(r18, r3, r16, r22, r13, r12, r14) == true) goto L14;
        return new g.b(false, Collections.emptyList());
    L40:
        return new g.b(true, new ArrayList(r14.values()));
    L25:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-trafficGeo", r22 + " poi search exception, city=" + r18, th);
        return new g.b(false, Collections.emptyList());
    }

    public static String a(com.obric.cae.location.geosdk.bytedance.a.ai r4) {
        Map<String, String> r0 = r4.l;
        String r1 = "";
        if (r0 != null) goto L5;
    L4:
        String r2 = "";
    L9:
        if (r2.isEmpty() == false) goto L16;
        StringBuilder r3 = new StringBuilder();
        String r5 = r4.g;
        if (r5 == null) goto L15;
        r1 = r5;
    L15:
        return r3.append(r1).append("_").append(r4.j).append("_").append(r4.i).toString();
    L16:
        return r2;
    L5:
        r2 = (String) ZeusTransformUtils.preCheckCast(r0.get("awe_poi_id"), String.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L9;
        goto L4
    }

    public static /* synthetic */ AtomicReference a(d r0) {
        return r0.k;
    }

    private void a(int r3, String r4) {
        this.y.set(r4);
        com.obric.cae.log.a.e("StarLocation-trafficGeo", "onHighConfidenceCellPoiStatusChange: cellPoiType=" + r3 + " stationName=" + r4);
        if (TextUtils.isEmpty(r4) == true) goto L7;
        Bundle r2 = new Bundle();
        r2.putLong("timestamp", System.currentTimeMillis());
        r2.putString("near_the_poi", "true");
        r2.putString("near_the_aoi", "false");
        r2.putString("poi_name", r4);
        r2.putString("new_type_name_l1", "地名地址");
        r2.putString("new_type_name_l2", "地铁站");
        r2.putString("new_type_name_l3", "地铁站");
        r2.putString("new_type_code_l1", "130000");
        r2.putString("new_type_code_l2", "131400");
        r2.putString("new_type_code_l3", "131401");
        StarPoiManager.a().d(r2);
        return;
    }

    public static void a(AoiBoard r9, boolean r10, String r11) {
        com.obric.cae.log.a.f("StarLocation-trafficGeo", f.a("report airport enter reason=", r11, ", poiId=").append(r9.getPoiId()).append(", inside=").append(r10).toString());
        if (r10 == false) goto L5;
        a(new TrafficRecognitionInfo(System.currentTimeMillis(), 1, 3, r9.getPoiId(), r9.getPoiName(), TrafficRecognitionInfo.SOURCE_AIRPORT_RECOGNITION));
    L5:
        com.obric.cae.location.report.d.a(r9, r10);
    }

    public static void a(d r10, AoiBoard r11) {
        r10.getClass();
        AoiBoard.Event r0 = r11.getEvent();
        AoiBoard.Event r1 = AoiBoard.Event.ENTER;
        if (r0 != r1) goto L13;
        if (r11.getPoiId().isEmpty() == true) goto L13;
        r10.l.set(com.obric.cae.location.geosdk.poi.a.a(r11));
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "record last inside aoi poiId=" + r11.getPoiId() + ", type=" + r11.getType() + ", eventTime=" + r11.getEventTime());
        if (r11.getType() != AoiBoard.Type.AIRPORT) goto L13;
        if (r10.u == true) goto L13;
        r10.f();
        a(r11, true, "ground_aoi_enter");
    L13:
        if (r11.getType() == AoiBoard.Type.TRAIN_STATION) goto L15;
        return;
    L15:
        if (r11.getEvent() != r1) goto L24;
        long r2 = r11.getEventTime();
        if (r2 > 0) goto L21;
        r2 = System.currentTimeMillis();
    L21:
        a(new TrafficRecognitionInfo(r2, 2, 1, r11.getPoiId(), r11.getPoiName(), TrafficRecognitionInfo.SOURCE_AOI_BOARD));
        return;
    }

    public static void a(TrafficRecognitionInfo r2) {
        UserAwareManager.getInstance().notifyInnerCallbacks($$Lambda$gcxmNcj91gSW7UdTORhPB_0CGjQ.INSTANCE, r2);
    }

    public static boolean a(AoiBoard.Type r4, List r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L5;
    L16:
        return false;
    L5:
        if (r6.isEmpty() == true) goto L16;
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L16;
        AoiBoard r2 = (AoiBoard) ZeusTransformUtils.preCheckCast(r7.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        if (r2.getType() != r4) goto L9;
        return true;
    }

    public static /* synthetic */ AtomicBoolean b(d r0) {
        return r0.j;
    }

    private /* synthetic */ void b(final int r3, final int r4) {
        g().execute(new $$Lambda$d$12dxiPkX8FwpGmFM4_8satkTFz4(this, r3, r4));
    }

    public static /* synthetic */ ExecutorService c(d r0) {
        return r0.g();
    }

    private /* synthetic */ void c(int r3, int r4) {
        a(r3, r4, null, LocationMonitorConst.TIMEOUT);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-trafficGeo", "handleAirportGroundLocationCheckResult timeout error, index=" + r4, th);
    }

    private /* synthetic */ void d(final int r3, final int r4) {
        if (this.o.get() == r3) goto L5;
        return;
    L5:
        g().execute(new $$Lambda$d$8i2uOgOq6biZZ53OxvhunYwcDaY(this, r3, r4));
    }

    private /* synthetic */ void e(int r2, int r3) {
        a(r2, r3);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-trafficGeo", "handleAirportGroundCheck error, index=" + r3, th);
    }

    private void h(String r1) {
        this.i.a(r1);
    }

    private void i(String r1) {
        this.i.a(r1);
    }

    /* JADX INFO: renamed from: lambda$-_4OHO2xHNy2ZcHaSMOtXwS-O6k, reason: not valid java name */
    public static /* synthetic */ void m376lambda$_4OHO2xHNy2ZcHaSMOtXwSO6k(d r0, String r1) {
        r0.i(r1);
    }

    public static /* synthetic */ void lambda$12dxiPkX8FwpGmFM4_8satkTFz4(d r0, int r1, int r2) {
        r0.c(r1, r2);
    }

    public static /* synthetic */ void lambda$8i2uOgOq6biZZ53OxvhunYwcDaY(d r0, int r1, int r2) {
        r0.e(r1, r2);
    }

    public static /* synthetic */ void lambda$9HYeLEhJnUeyV0dohrkwrN3Z8_I(d r0, int r1, int r2) {
        r0.d(r1, r2);
    }

    /* JADX INFO: renamed from: lambda$JFYwFr8yOXtODP57eJ-KpFjw6po, reason: not valid java name */
    public static /* synthetic */ void m377lambda$JFYwFr8yOXtODP57eJKpFjw6po(d r0, int r1, int r2) {
        r0.b(r1, r2);
    }

    public static /* synthetic */ void lambda$Tc3UGanGW8WjtBnWiSgYpz2gLgI(d r0, String r1) {
        r0.h(r1);
    }

    /* JADX INFO: renamed from: lambda$rOyynnl9TOoslywbnwb-2Q7w_vI, reason: not valid java name */
    public static /* synthetic */ void m378lambda$rOyynnl9TOoslywbnwb2Q7w_vI(d r0, int r1, String r2) {
        r0.a(r1, r2);
    }

    public void a() {
        com.obric.cae.location.city.a.a(this.f, this.v);     // Catch: Throwable -> L10
        if (this.w.compareAndSet(false, true) == false) goto L6;
        UserAwareManager.getInstance().registerInnerCallback(this.x);     // Catch: Throwable -> L10
    L6:
        if (this.z.compareAndSet(false, true) == false) goto L8;
        com.obric.cae.location.cell.b.a().a(this.A);     // Catch: Throwable -> L10
    L8:
        c();     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-trafficGeo", "init register observer failed", th);
    }

    public final void a(int r19) {
        boolean r4 = true;
        if (r19 == 1) goto L8;
        if (r19 == 2) goto L8;
        if (r19 == 0) goto L8;
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "skip invalid flight mode state=" + r19);
        return;
    L8:
        int r5 = this.p;
        if (r5 != r19) goto L13;
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "skip duplicate flight mode state=" + r19);
        return;
    L13:
        if (r19 != 2) goto L19;
        if (r5 == 1) goto L17;
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "skip invalid pre-landing transition, previousState=" + this.p);
        return;
    L17:
        this.p = r19;
        this.q = -1;
        com.obric.cae.log.a.f("StarLocation-trafficGeo", "record flight mode pre-landing, token=" + this.o.get());
        return;
    L19:
        this.q = r19;
        int r2 = this.o.incrementAndGet();
        f();
        this.t = 0;
        com.obric.cae.log.a.f("StarLocation-trafficGeo", "handle flight mode state=" + r19 + ", token=" + r2);
        if (r19 == 1) goto L22;
        r4 = b(r2);
    L116:
        if (r4 == false) goto L118;
        this.p = r19;
        this.q = -1;
        return;
    L118:
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "flight mode handling pending, state=" + r19);
        c();
        return;
    L22:
        if (this.o.get() == r2) goto L24;
    L28:
        boolean r3 = false;
    L29:
        if (r3 == false) goto L116;
        List<AoiBoard> r6 = h().a(AoiBoard.Type.AIRPORT);
        if (r6.isEmpty() == false) goto L34;
        com.obric.cae.log.a.h("StarLocation-trafficGeo", "skip flying airport report: no airport aoi board, searchState=" + d("airport_aoi_board"));
        r4 = e();
        goto L116
    L34:
        Iterator<AoiBoard> r7 = r6.iterator();
    L35:
        AoiBoard r10 = null;
        if (r7.hasNext() == false) goto L42;
        AoiBoard r8 = (AoiBoard) ZeusTransformUtils.preCheckCast(r7.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L35;
        if (r8.getCurState() != AoiBoard.State.INSIDE) goto L35;
    L43:
        if (r8 == null) goto L46;
        String r9 = "flying_inside";
    L45:
        a(r8, true, r9);
        goto L116
    L46:
        AoiBoard r11 = (AoiBoard) ZeusTransformUtils.preCheckCast(this.l.get(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L49;
    L53:
        boolean r12 = false;
    L55:
        if (r12 == false) goto L70;
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "last inside aoi poiId=" + r11.getPoiId() + ", type=" + r11.getType() + ", eventTime=" + r11.getEventTime());
        if (r11.getType() != AoiBoard.Type.AIRPORT) goto L97;
        String r13 = r11.getPoiId();
        if (r13.isEmpty() == true) goto L97;
        Iterator<AoiBoard> r14 = r6.iterator();
    L64:
        if (r14.hasNext() == false) goto L97;
        r8 = (AoiBoard) ZeusTransformUtils.preCheckCast(r14.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L64;
        if (r13.equals(r8.getPoiId()) == false) goto L64;
    L98:
        if (r8 == null) goto L100;
        r9 = "flying_previous_inside_airport";
        goto L45
    L100:
        Iterator<AoiBoard> r15 = r6.iterator();
    L102:
        if (r15.hasNext() == false) goto L112;
        AoiBoard r16 = (AoiBoard) ZeusTransformUtils.preCheckCast(r15.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r16 == null) goto L102;
        if (r16.getType() != AoiBoard.Type.AIRPORT) goto L102;
        if (r10 == null) goto L111;
        if (r16.getEventTime() <= r10.getEventTime()) goto L102;
    L111:
        r10 = r16;
        goto L102
    L112:
        if (r10 != null) goto L114;
        com.obric.cae.log.a.h("StarLocation-trafficGeo", "skip flying airport report: no report aoi board");
        goto L116
    L114:
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "skip flying airport report: no inside airport evidence, poiId=" + r10.getPoiId());
    L97:
        r8 = null;
        goto L98
    L70:
        Iterator<AoiBoard> r17 = h().g().iterator();
        r8 = null;
    L72:
        if (r17.hasNext() == false) goto L92;
        AoiBoard r18 = (AoiBoard) ZeusTransformUtils.preCheckCast(r17.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r18 != null) goto L76;
    L80:
        boolean r110 = false;
    L81:
        if (r110 == false) goto L72;
        if (r18.getEventTime() <= 0) goto L72;
        if (r18.getCurState() != AoiBoard.State.INSIDE) goto L72;
        if (r8 == null) goto L91;
        if (r18.getEventTime() <= r8.getEventTime()) goto L72;
    L91:
        r8 = r18;
        goto L72
    L76:
        if (r18.getPoiId().isEmpty() == true) goto L80;
        if (r18.getAoiBoard().isEmpty() == true) goto L80;
        r110 = true;
        goto L81
    L92:
        if (r8 != null) goto L94;
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "previous inside source not found");
        goto L97
    L94:
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "previous inside source poiId=" + r8.getPoiId() + ", type=" + r8.getType() + ", state=" + r8.getCurState() + ", event=" + r8.getEvent() + ", eventTime=" + r8.getEventTime());
        if (r8.getType() != AoiBoard.Type.AIRPORT) goto L97;
    L49:
        if (r11.getPoiId().isEmpty() == true) goto L53;
        if (r11.getAoiBoard().isEmpty() == true) goto L53;
        r12 = true;
        goto L55
    L42:
        r8 = null;
        goto L43
    L24:
        if (this.p != 1) goto L26;
    L27:
        r3 = true;
        goto L29
    L26:
        if (this.q != 1) goto L28;
        goto L27
    }

    public final void a(final int r7, final int r8) {
        if (this.o.get() == r7) goto L5;
    L9:
        boolean r0 = false;
    L11:
        if (r0 == true) goto L13;
    L24:
        StringBuilder r6 = com.obric.cae.location.b.a("skip ground check index=", r8, ", token=", r7, ", currentToken=").append(this.o.get()).append(", reportFinished=").append(this.u);
    L22:
        com.obric.cae.log.a.d("StarLocation-trafficGeo", r6.toString());
        return;
    L13:
        if (this.u == true) goto L24;
        if (h().a(AoiBoard.Type.AIRPORT).isEmpty() == false) goto L21;
        com.obric.cae.log.a.h("StarLocation-trafficGeo", "skip ground check: no airport aoi board, index=" + r8);
        if (r8 < c.length) goto L25;
        f();
        return;
    L25:
        return;
    L21:
        this.r = r7;
        this.s = r8;
        com.obric.cae.location.util.d.a().b("network", true, com.obric.cae.log.a.a());
        this.h.postDelayed(new $$Lambda$d$JFYwFr8yOXtODP57eJKpFjw6po(this, r7, r8), this.n, d);
        r6 = new StringBuilder("request airport ground location check, index=").append(r8).append(", token=").append(r7);
        goto L22
    L5:
        if (this.p != 0) goto L7;
    L8:
        r0 = true;
        goto L11
    L7:
        if (this.q != 0) goto L9;
        goto L8
    }

    public final void a(int r17, int r18, Location r19, String r20) {
        if (r17 <= 0) goto L127;
        if (r18 > 0) goto L6;
        return;
    L6:
        if (this.r == r17) goto L8;
        return;
    L8:
        if (this.s != r18) goto L130;
        this.r = 0;
        this.s = 0;
        if (this.o.get() == r17) goto L13;
    L17:
        boolean r5 = false;
    L19:
        if (r5 == true) goto L21;
    L92:
        com.obric.cae.log.a.d("StarLocation-trafficGeo", com.obric.cae.location.b.a("skip ground location check result index=", r18, ", token=", r17, ", currentToken=").append(this.o.get()).append(", reportFinished=").append(this.u).append(", source=").append(r20).toString());
        return;
    L21:
        if (this.u == true) goto L92;
        List<AoiBoard> r1 = h().a(AoiBoard.Type.AIRPORT);
        if (r1.isEmpty() == false) goto L29;
        com.obric.cae.log.a.h("StarLocation-trafficGeo", "skip ground location check result: no airport aoi board, index=" + r18 + ", source=" + r20);
        if (r18 < c.length) goto L124;
        f();
        return;
    L124:
        return;
    L29:
        if (r19 != null) goto L34;
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "airport ground check unknown, index=" + r18 + ", source=" + r20);
        if (r18 < c.length) goto L125;
        f();
        return;
    L125:
        return;
    L34:
        Iterator<AoiBoard> r6 = r1.iterator();
    L35:
        AoiBoard r11 = null;
        if (r6.hasNext() == false) goto L46;
        AoiBoard r9 = (AoiBoard) ZeusTransformUtils.preCheckCast(r6.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L35;
        if (r9.getAoiBoard().isEmpty() == true) goto L35;
        Iterator<AoiBoard> r110 = r6;
        boolean r4 = com.obric.cae.location.util.c.a(r9.getAoiBoard(), r19.getLatitude(), r19.getLongitude());
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "airport location check poiId=" + r9.getPoiId() + ", inside=" + r4);
        if (r4 == true) goto L47;
        r6 = r110;
    L47:
        if (r9 == null) goto L50;
        f();
        a(r9, true, "ground_check_inside_" + r18);
        return;
    L50:
        this.t++;
        com.obric.cae.log.a.d("StarLocation-trafficGeo", com.obric.cae.libs.statemachine.d.a("airport ground check outside, index=", r18, ", outsideCount=").append(this.t).append(", source=").append(r20).append(", hasLocation=true").toString());
        int r3 = this.t;
        long[] r7 = c;
        if (r3 < r7.length) goto L53;
        float r2 = Float.MAX_VALUE;
        Iterator<AoiBoard> r8 = r1.iterator();
        AoiBoard r10 = null;
    L58:
        if (r8.hasNext() == false) goto L71;
        AoiBoard r12 = (AoiBoard) ZeusTransformUtils.preCheckCast(r8.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r12 == null) goto L58;
        if (r12.getType() != AoiBoard.Type.AIRPORT) goto L58;
        if (r12.getAoiBoard().isEmpty() == true) goto L58;
        float r13 = com.obric.cae.location.util.c.b(r12.getAoiBoard(), r19.getLatitude(), r19.getLongitude());
        if (r10 == null) goto L70;
        if (r13 >= r2) goto L58;
    L70:
        r10 = r12;
        r2 = r13;
        goto L58
    L71:
        if (r10 == null) goto L73;
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "select nearest airport aoi poiId=" + r10.getPoiId() + ", distanceMeters=" + r2);
    L73:
        if (r10 != null) goto L87;
        Iterator<AoiBoard> r14 = r1.iterator();
    L76:
        if (r14.hasNext() == false) goto L86;
        AoiBoard r15 = (AoiBoard) ZeusTransformUtils.preCheckCast(r14.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L76;
        if (r15.getType() != AoiBoard.Type.AIRPORT) goto L76;
        if (r11 == null) goto L85;
        if (r15.getEventTime() <= r11.getEventTime()) goto L76;
    L85:
        r11 = r15;
        goto L76
    L86:
        r10 = r11;
    L87:
        if (r10 != null) goto L90;
        com.obric.cae.log.a.h("StarLocation-trafficGeo", "skip ground outside report: no report aoi board");
        f();
        return;
    L90:
        f();
        a(r10, false, "ground_check_all_outside");
        return;
    L53:
        if (r18 < r7.length) goto L126;
        f();
        return;
    L126:
        return;
    L46:
        r9 = null;
        goto L47
    L13:
        if (this.p != 0) goto L15;
    L16:
        r5 = true;
        goto L19
    L15:
        if (this.q != 0) goto L17;
    L130:
        return;
    }

    public void a(Address r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        String r3 = r2.getSubAdminArea();
        if (r3 != null) goto L7;
    L11:
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "skip: subAdminArea is empty");
        return;
    L7:
        if (r3.isEmpty() == true) goto L11;
        this.i.a(r3);
    }

    public final void a(String r8) {
        boolean r1 = false;
    L42:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-trafficGeo", "error", th);     // Catch: Throwable -> L47
        if (0 == 0) goto L58;
    L45:
        this.i.a();
        return;
    L58:
        return;
    L47:
        th = move-exception;
        if (0 == 0) goto L50;
        this.i.a();
    L50:
        throw th;
    L4:
        if (h().e() == true) goto L7;
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "skip: aoi board recovery not finished");     // Catch: Throwable -> L42
        this.i.b();     // Catch: Throwable -> L42
        return;
    L7:
        e r2 = this.i;     // Catch: Throwable -> L42
        if (r2.k.compareAndSet(false, true) == true) goto L11;
        com.obric.cae.log.a.d(r2.f7061a, "skip: add in progress");     // Catch: Throwable -> L42
    L12:
        if (r1 == true) goto L16;
        if (r1 == false) goto L54;
        this.i.a();
        return;
    L54:
        return;
    L16:
        c r9 = b(r8);     // Catch: Throwable -> L42
        if (r9 != null) goto L22;
        if (r1 == false) goto L55;
        this.i.a();
        return;
    L55:
        return;
    L22:
        if (a(r9) == true) goto L26;
        if (r1 == false) goto L56;
        this.i.a();
        return;
    L56:
        return;
    L26:
        com.obric.cae.location.a r3 = com.obric.cae.location.a.a();     // Catch: Throwable -> L42
        com.obric.cae.location.a.C0349a r4 = r3.a(f7055a);     // Catch: Throwable -> L42
        if (r4 != null) goto L30;
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "skip: recent applied location source unavailable");     // Catch: Throwable -> L42
    L32:
        int r10 = this.q;     // Catch: Throwable -> L42
        if (r10 == 1) goto L37;
        if (r10 == 0) goto L37;
    L40:
        if (r1 == true) goto L45;
        return;
    L37:
        if (this.p != r10) goto L39;
        this.q = -1;     // Catch: Throwable -> L42
        goto L40
    L39:
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "retry pending flight mode state=" + r10);     // Catch: Throwable -> L42
        a(r10);     // Catch: Throwable -> L42
        goto L40
    L30:
        if (h().a(r3.e(r4), r9.f7060b) == true) goto L32;
        this.i.b();     // Catch: Throwable -> L42
        goto L32
    L11:
        r1 = true;
        goto L12
    }

    public void a(String r8, boolean r9) {
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        this.h.removeCallbacksAndMessages(this.m);
        i().edit().remove("traffic_query_retry_count").remove("traffic_query_retry_at_ms").apply();
        LinkedHashMap r0 = new LinkedHashMap();
        int r3 = 0;
        if (r9 == false) goto L14;
        List<AoiBoard> r4 = h().a(com.obric.cae.location.geosdk.poi.a.a());
        if (a(AoiBoard.Type.AIRPORT, r4) == false) goto L10;
        int r5 = 2;
    L11:
        r0.put("airport_aoi_board", Integer.valueOf(r5));
        if (a(AoiBoard.Type.TRAIN_STATION, r4) == false) goto L15;
        r3 = 2;
    L15:
        r0.put("train_station_aoi_board", Integer.valueOf(r3));
        SharedPreferences.Editor r1 = i().edit();
        r1.putString("traffic_aoi_board_city", r8);
        Iterator r2 = r0.entrySet().iterator();
    L17:
        if (r2.hasNext() == false) goto L19;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r1.putInt((String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin"), ((Integer) ZeusTransformUtils.preCheckCast(r6.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        goto L17
    L19:
        r1.apply();
        if (e(r8) == false) goto L22;
        this.g.set(r8);
    L23:
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "city=" + r8 + ", restoredFromArchive=" + r9 + ", stateUpdates=" + r0 + ", activeCity=" + ((String) ZeusTransformUtils.preCheckCast(this.g.get(), String.class, "com.obric.memorydata.plugin")));
        return;
    L22:
        this.g.set(null);
        goto L23
    L10:
        r5 = 0;
        goto L11
    L14:
        r0.put("airport_aoi_board", 0);
        goto L15
    }

    public final void a(LinkedHashMap r18, LinkedHashMap r19, LinkedHashMap r20, String r21, String r22, String r23, String r24, String r25, int r26, String r27, AoiBoard.Type r28) {
        List r6 = Arrays.asList(new String[]{r22});
        int r4 = d(r27);
        if (r4 != 2) goto L13;
        List<AoiBoard> r5 = h().a(r28);
        if (r5.isEmpty() == true) goto L11;
        ArrayList r3 = new ArrayList();
        Iterator<AoiBoard> r7 = r5.iterator();
    L8:
        if (r7.hasNext() == false) goto L10;
        AoiBoard r12 = (AoiBoard) ZeusTransformUtils.preCheckCast(r7.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        r18.put(r12.getPoiId(), r12);
        r3.add(r12.getPoiId());
        goto L8
    L10:
        r19.putAll(com.obric.cae.location.database.c.a(this.f, 0).b(r3));
        StringBuilder r0 = new StringBuilder().append(r25).append(" skip search for city=").append(r21).append(", state=success, persistedCount=").append(r5.size()).append(", persistedNewTypeCodeL3Count=").append(r19.size());
    L15:
        com.obric.cae.log.a.d("StarLocation-trafficGeo", r0.toString());
        return;
    L11:
        com.obric.cae.log.a.h("StarLocation-trafficGeo", r25.concat(" state=success but persisted boards missing, retry search"));
    L16:
        g.b r8 = a(r21, r6, r23, r24, r25, r26);
        if (r8.f7064a == true) goto L21;
        com.obric.cae.log.a.h("StarLocation-trafficGeo", r25 + " search failed, mark query_error, city=" + r21);
        int r1 = -2;
    L19:
        r20.put(r27, Integer.valueOf(r1));
        return;
    L21:
        if (r8.f7065b.isEmpty() == false) goto L23;
    L22:
        r20.put(r27, -1);
        return;
    L23:
        LinkedHashMap r9 = new LinkedHashMap();
        Iterator<com.obric.cae.location.geosdk.bytedance.a.ai> r10 = r8.f7065b.iterator();
    L25:
        if (r10.hasNext() == false) goto L82;
        com.obric.cae.location.geosdk.bytedance.a.ai r11 = (com.obric.cae.location.geosdk.bytedance.a.ai) ZeusTransformUtils.preCheckCast(r10.next(), com.obric.cae.location.geosdk.bytedance.a.ai.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L29;
    L28:
        String r13 = "";
    L36:
        if (r13.isEmpty() == true) goto L25;
        Map<String, String> r14 = r11.l;
        if (r14 != null) goto L41;
    L54:
        Iterator<com.obric.cae.location.geosdk.bytedance.a.ai> r17 = r10;
        String r29 = "";
    L55:
        String r15 = r29;
    L57:
        if (r15.isEmpty() == true) goto L59;
        r19.put(r13, r15);
    L59:
        AoiBoard r16 = null;
        if (r13.isEmpty() == true) goto L78;
        String r30 = r11.g;
        String r31 = r11.k;
        if (TextUtils.isEmpty(r31) == false) goto L67;
        Map<String, String> r32 = r11.l;
        if (r32 == null) goto L67;
        r31 = (String) ZeusTransformUtils.preCheckCast(r32.get("aoi_border"), String.class, "com.obric.memorydata.plugin");
    L67:
        if (r31 != null) goto L69;
        String r33 = r29;
    L75:
        if (r33.isEmpty() == false) goto L77;
        com.obric.cae.log.a.b("StarLocation-trafficGeo", "traffic candidate missing aoi data, name=" + r30 + ", poiId=" + r13 + ", type=" + r28);
        com.obric.cae.location.report.d.a(r13, r30);
        goto L78
    L77:
        r16 = com.obric.cae.location.geosdk.poi.a.a(r13, r30, r33, r28);
        goto L78
    L69:
        r33 = r31.trim();
        if (r33.startsWith("{") == false) goto L72;
    L73:
        r33 = com.obric.cae.location.util.c.a(r33);
        goto L75
    L72:
        if (r33.startsWith("[") == false) goto L75;
    L78:
        if (r16 == null) goto L80;
        r9.put(r16.getPoiId(), r16);
    L80:
        r10 = r17;
        goto L25
    L41:
        if (r14.isEmpty() == true) goto L54;
        r17 = r10;
        r29 = "";
        r15 = (String) ZeusTransformUtils.preCheckCast(r14.get("new_type_code"), String.class, "com.obric.memorydata.plugin");
        if (r15 != null) goto L46;
    L47:
        r15 = (String) ZeusTransformUtils.preCheckCast(r14.get("NewTypeCode"), String.class, "com.obric.memorydata.plugin");
    L48:
        if (r15 != null) goto L50;
    L51:
        r15 = (String) ZeusTransformUtils.preCheckCast(r14.get("newTypeCode"), String.class, "com.obric.memorydata.plugin");
    L52:
        if (r15 != null) goto L57;
    L50:
        if (r15.isEmpty() == false) goto L52;
    L46:
        if (r15.isEmpty() == false) goto L48;
    L29:
        Map<String, String> r34 = r11.l;
        if (r34 == null) goto L28;
        r13 = (String) ZeusTransformUtils.preCheckCast(r34.get("awe_poi_id"), String.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L36;
    L82:
        if (r9.isEmpty() == false) goto L84;
        com.obric.cae.log.a.h("StarLocation-trafficGeo", r25 + " search returned candidates but no valid aoi boards, city=" + r21);
        goto L22
    L84:
        r18.putAll(r9);
        r1 = 2;
        goto L19
    L13:
        if (r4 != (-1)) goto L16;
        r0 = new StringBuilder().append(r25).append(" skip search for city=").append(r21).append(", state=no_result");
        goto L15
    }

    public final boolean a(c r7) {
        if (r7.c == true) goto L5;
        this.g.set(r7.f7059a);
        return true;
    L5:
        if (a(r7.f7059a, r7.f7060b) == true) goto L7;
        return false;
    L7:
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "ensureTrafficDataPrepared start query refreshed traffic geofences");
        List<StarGeofence> r3 = h().j();
        StringBuilder r4 = new StringBuilder("ensureTrafficDataPrepared queried refreshed traffic geofences, isNull=");
        if (r3 != null) goto L10;
        boolean r5 = true;
    L11:
        StringBuilder r6 = r4.append(r5).append(", size=");
        if (r3 != null) goto L14;
        int r8 = -1;
    L15:
        com.obric.cae.log.a.d("StarLocation-trafficGeo", r6.append(r8).toString());
        if (r3 != null) goto L19;
        this.i.b();
        return false;
    L19:
        r7.f7060b = r3;
        return true;
    L14:
        r8 = r3.size();
        goto L15
    L10:
        r5 = false;
        goto L11
    }

    public final boolean a(String r23, List<StarGeofence> r24) {
        List<StarGeofence> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.memorydata.plugin");
        if (com.obric.cae.location.util.d.a().e() == true) goto L7;
        com.obric.cae.log.a.h("StarLocation-trafficGeo", "skip reloadTrafficDataForCity: network invalid, city=" + r23);
        return false;
    L7:
        if (d("airport_aoi_board") != (-2)) goto L9;
    L12:
        boolean r0 = true;
    L13:
        if (r0 == true) goto L15;
    L17:
        c(r23);
        LinkedHashMap r16 = new LinkedHashMap();
        LinkedHashMap r8 = new LinkedHashMap();
        LinkedHashMap r7 = new LinkedHashMap();
        a(r16, r8, r7, r23, "国际机场", "飞机场", "131002", "airport", 1, "airport_aoi_board", AoiBoard.Type.AIRPORT);
        a(r16, r8, r7, r23, "火车站", "火车站", "131301", "train", 10, "train_station_aoi_board", AoiBoard.Type.TRAIN_STATION);
        ArrayList r1 = new ArrayList(r16.values());
        int r2 = h().e(r15);
        boolean r3 = h().a(com.obric.cae.location.geosdk.poi.a.a(), r1);
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "reloadTrafficDataForCity city=" + r23 + ", removedTrafficCount=" + r2 + ", trafficAoiBoardCount=" + r1.size() + ", saved=" + r3);
        if (r3 == false) goto L27;
        com.obric.cae.log.a.f("StarLocation-trafficGeo", com.obric.cae.libs.statemachine.d.a("traffic new_type_code_l3 saved count=", com.obric.cae.location.database.c.a(this.f, 0).a(r8), ", parsed count=").append(r8.size()).toString());
        SharedPreferences.Editor r4 = i().edit();
        r4.putString("traffic_aoi_board_city", r23);
        Iterator r5 = r7.entrySet().iterator();
    L21:
        if (r5.hasNext() == false) goto L23;
        Map.Entry r6 = (Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r4.putInt((String) ZeusTransformUtils.preCheckCast(r6.getKey(), String.class, "com.obric.memorydata.plugin"), ((Integer) ZeusTransformUtils.preCheckCast(r6.getValue(), Integer.class, "com.obric.memorydata.plugin")).intValue());
        goto L21
    L23:
        r4.apply();
        this.g.set(r23);
        if (r7.containsValue(-2) == false) goto L26;
        g(r23);
        goto L27
    L26:
        this.h.removeCallbacksAndMessages(this.m);
        i().edit().remove("traffic_query_retry_count").remove("traffic_query_retry_at_ms").apply();
    L27:
        return r3;
    L15:
        if (f(r23) == false) goto L17;
        return false;
    L9:
        if (d("train_station_aoi_board") == (-2)) goto L12;
        r0 = false;
        goto L13
    }

    public final boolean a(List<StarGeofence> r15) {
        List<StarGeofence> r16 = (List) ZeusTransformUtils.wrapperContextForParams(r15, List.class, "com.obric.memorydata.plugin");
        int r0 = i().getInt("traffic_version", 0);
        if (r0 != 0) goto L8;
        int r17 = h().e(r16);
        int r1 = h().f();
        this.g.set(null);
        i().edit().remove("traffic_aoi_board_city").remove("airport_aoi_board").remove("train_station_aoi_board").remove("subway_station_aoi_board").remove("traffic_query_retry_count").remove("traffic_query_retry_at_ms").putInt("traffic_version", 3).apply();
        StringBuilder r14 = new StringBuilder("finish traffic version migration, removedTrafficCount=").append(r17).append(", deletedAoiBoardCount=").append(r1);
    L5:
        com.obric.cae.log.a.f("StarLocation-trafficGeo", r14.toString());
        return true;
    L8:
        if (r0 != 2) goto L10;
        i().edit().remove("subway_station_aoi_board").putInt("traffic_version", 3).apply();
        r14 = new StringBuilder("finish traffic version migration, previousVersion=").append(r0).append(", currentVersion=3, removed legacy subway state");
        goto L5
    L10:
        if (r0 < 3) goto L12;
        return true;
    L12:
        if (d("airport_aoi_board") == 2) goto L14;
    L17:
        boolean r12 = true;
    L18:
        if (r12 == true) goto L21;
        i().edit().remove("subway_station_aoi_board").putInt("traffic_version", 3).apply();
        StringBuilder r18 = new StringBuilder("traffic aoi board already latest, previousVersion=").append(r0).append(", currentVersion=3");
    L20:
        com.obric.cae.log.a.f("StarLocation-trafficGeo", r18.toString());
        return true;
    L21:
        EnumSet r13 = EnumSet.of(AoiBoard.Type.AIRPORT, AoiBoard.Type.TRAIN_STATION);
        int r19 = h().a(r16, r13);
        boolean r110 = h().a(r13, null);
        boolean r111 = com.obric.cae.location.database.c.a(this.f, 0).c();
        if (r110 == false) goto L26;
        if (r111 == false) goto L26;
        this.g.set(null);
        i().edit().putInt("airport_aoi_board", 0).putInt("train_station_aoi_board", 0).remove("subway_station_aoi_board").remove("traffic_query_retry_count").remove("traffic_query_retry_at_ms").putInt("traffic_version", 3).apply();
        r18 = new StringBuilder("finish traffic aoi board migration, previousVersion=").append(r0).append(", currentVersion=3, removedTrafficCount=").append(r19);
    L26:
        com.obric.cae.log.a.h("StarLocation-trafficGeo", "traffic aoi board migration failed, previousVersion=" + r0 + ", deletedAoiBoards=" + r110 + ", deletedArchiveRoot=" + r111);
        return false;
    L14:
        if (d("train_station_aoi_board") != 2) goto L17;
        r12 = false;
        goto L18
    }

    public final c b(String r8) {
        List<StarGeofence> r0 = h().j();
        if (r0 != null) goto L7;
        com.obric.cae.log.a.h("StarLocation-trafficGeo", "skip: traffic geofence list unavailable");
        this.i.b();
        return null;
    L7:
        if (a(r0) == true) goto L10;
        this.i.b();
        return null;
    L10:
        boolean r3 = false;
        if (r8 != null) goto L13;
    L15:
        com.obric.cae.location.database.c.b r9 = com.obric.cae.location.database.c.a(this.f, 0).b();
        if (r9 != null) goto L18;
        r8 = null;
    L19:
        if (r8 != null) goto L21;
    L35:
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "skip: target city empty");
        return null;
    L21:
        if (r8.isEmpty() == true) goto L35;
        c(r8);
        com.obric.cae.location.database.c.b r2 = com.obric.cae.location.database.c.a(this.f, 0).g(r8);
        String r4 = (String) ZeusTransformUtils.preCheckCast(this.g.get(), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L32;
        if (r4 == null) goto L31;
        if (r4.isEmpty() == true) goto L31;
        if (r8.equals(r4) == false) goto L32;
    L31:
        if (e(r8) == false) goto L32;
    L33:
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "traffic sync city=" + r8 + ", needReloadTrafficData=" + r3 + ", activeCity=" + ((String) ZeusTransformUtils.preCheckCast(this.g.get(), String.class, "com.obric.memorydata.plugin")) + ", existingTrafficCount=" + r0.size());
        return new c(r8, r0, r3);
    L32:
        r3 = true;
        goto L33
    L18:
        r8 = r9.f7078b;
        goto L19
    L13:
        if (r8.isEmpty() == true) goto L15;
        goto L15
    }

    public void b() {
        com.obric.cae.location.city.a.b(this.f, this.v);     // Catch: Throwable -> L4
    L6:
        e r0 = this.i;
        r0.c.removeCallbacks(r0.l);
        r0.j.set(false);
        this.h.removeCallbacksAndMessages(this.m);
        this.o.incrementAndGet();
        f();
        if (this.w.compareAndSet(true, false) == false) goto L10;
        UserAwareManager.getInstance().unregisterInnerCallback(this.x);
    L10:
        if (this.z.compareAndSet(true, false) == false) goto L12;
        com.obric.cae.location.cell.b.a().b(this.A);
    L12:
        monitor-enter(this);
        ExecutorService r1 = this.B;     // Catch: Throwable -> L20
        if (r1 != null) goto L26;
    L18:
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L26:
        r1.shutdownNow();     // Catch: Throwable -> L23
    L17:
        this.B = null;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    L4:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-trafficGeo", "destroy unregister observer failed", th);
        goto L6
    }

    public final boolean b(final int r9) {
        if (h().a(AoiBoard.Type.AIRPORT).isEmpty() == false) goto L6;
        com.obric.cae.log.a.h("StarLocation-trafficGeo", "skip ground airport checks: no airport aoi board, searchState=" + d("airport_aoi_board"));
        return e();
    L6:
        int r2 = 0;
    L7:
        long[] r3 = c;
        if (r2 >= r3.length) goto L10;
        final int r4 = r2 + 1;
        long r5 = r3[r2];
        this.h.postDelayed(new $$Lambda$d$9HYeLEhJnUeyV0dohrkwrN3Z8_I(this, r9, r4), this.n, r5);
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "schedule airport ground check index=" + r4 + ", delayMs=" + r5 + ", token=" + r9);
        r2 = r4;
        goto L7
    L10:
        this.u = false;
        return true;
    }

    public void c() {
        this.i.a(null);
    }

    public final void c(String r5) {
        String r0 = i().getString("traffic_aoi_board_city", "");
        if (r5.equals(r0) == false) goto L5;
        return;
    L5:
        this.h.removeCallbacksAndMessages(this.m);
        i().edit().putString("traffic_aoi_board_city", r5).putInt("airport_aoi_board", 0).putInt("train_station_aoi_board", 0).remove("traffic_query_retry_count").remove("traffic_query_retry_at_ms").apply();
        com.obric.cae.log.a.f("StarLocation-trafficGeo", "reset traffic aoi search state, previousCity=" + r0 + ", currentCity=" + r5);
    }

    public final int d(String r2) {
        return i().getInt(r2, 0);
    }

    public final void d() {
    L35:
        Location r2 = (Location) ZeusTransformUtils.preCheckCast(this.k.getAndSet(null), Location.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r2 == null) goto L5;
        if (h().a(r2, null) == true) goto L14;
        this.i.b();     // Catch: Throwable -> L16
    L14:
        a(this.r, this.s, r2, "callback");     // Catch: Throwable -> L16
    L19:
        if (this.k.get() != null) goto L35;
        this.j.set(false);
        if (this.k.get() != null) goto L23;
        return;
    L23:
        if (this.j.compareAndSet(false, true) == false) goto L43;
        g().execute(new $$Lambda$cRGycfV2qypI8MKhu3ufT0MYyEc(this));
        return;
    L43:
        return;
    L16:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-trafficGeo", "error", th);     // Catch: Throwable -> L26
        goto L19
    L5:
        this.j.set(false);
        if (this.k.get() != null) goto L8;
        return;
    L8:
        if (this.j.compareAndSet(false, true) == false) goto L41;
        g().execute(new $$Lambda$cRGycfV2qypI8MKhu3ufT0MYyEc(this));
        return;
    L41:
        return;
    L26:
        th = move-exception;
        this.j.set(false);
        if (this.k.get() != null) goto L30;
    L32:
        throw th;
    L30:
        if (this.j.compareAndSet(false, true) == false) goto L32;
        g().execute(new $$Lambda$cRGycfV2qypI8MKhu3ufT0MYyEc(this));
        goto L32
    }

    public final boolean e() {
        int r1 = d("airport_aoi_board");
        if (r1 != 2) goto L5;
    L8:
        return true;
    L5:
        if (r1 == (-1)) goto L8;
        return false;
    }

    public final boolean e(String r7) {
        if (r7.equals(i().getString("traffic_aoi_board_city", "")) == true) goto L5;
        return false;
    L5:
        int r8 = d("airport_aoi_board");
        int r1 = d("train_station_aoi_board");
        if (r8 == 2) goto L10;
        if (r8 == (-1)) goto L10;
        boolean r5 = false;
    L11:
        if (r5 == false) goto L31;
        if (r1 == 2) goto L16;
        if (r1 == (-1)) goto L16;
        boolean r2 = false;
    L17:
        if (r2 == false) goto L34;
        List<AoiBoard> r3 = null;
        if (r8 == 2) goto L22;
        if (r1 == 2) goto L22;
    L23:
        if (r8 == 2) goto L25;
    L26:
        if (r1 != 2) goto L30;
        if (a(AoiBoard.Type.TRAIN_STATION, r3) == true) goto L30;
        return false;
    L30:
        return true;
    L25:
        if (a(AoiBoard.Type.AIRPORT, r3) == true) goto L26;
        return false;
    L22:
        r3 = h().a(com.obric.cae.location.geosdk.poi.a.a());
        goto L23
    L34:
        return false;
    L16:
        r2 = true;
        goto L17
    L31:
        return false;
    L10:
        r5 = true;
        goto L11
    }

    public final void f() {
        this.h.removeCallbacksAndMessages(this.n);
        this.r = 0;
        this.s = 0;
        this.u = true;
    }

    public final boolean f(final String r12) {
        SharedPreferences r0 = i();
        int r1 = r0.getInt("traffic_query_retry_count", 0);
        long r6 = r0.getLong("traffic_query_retry_at_ms", 0);
        if (r1 >= 10) goto L5;
    L8:
        long r7 = r6 - System.currentTimeMillis();
        if (r7 > 0) goto L11;
        return false;
    L11:
        this.h.removeCallbacksAndMessages(this.m);
        this.h.postDelayed(new $$Lambda$d$_4OHO2xHNy2ZcHaSMOtXwSO6k(this, r12), this.m, r7);
        com.obric.cae.log.a.d("StarLocation-trafficGeo", "defer traffic query retry, city=" + r12 + ", retryCount=" + r1 + ", delayMs=" + r7);
        return true;
    L5:
        if (r6 > 0) goto L8;
        com.obric.cae.log.a.h("StarLocation-trafficGeo", "traffic query retry limit reached, city=" + r12 + ", retryCount=" + r1);
        return true;
    }

    public final synchronized ExecutorService g() {
        monitor-enter(this);
        ExecutorService r0 = this.B;     // Catch: Throwable -> L13
        if (r0 != null) goto L6;
    L9:
        this.B = Executors.newSingleThreadExecutor();     // Catch: Throwable -> L13
    L10:
        ExecutorService r1 = this.B;     // Catch: Throwable -> L13
        monitor-exit(this);
        return r1;
    L6:
        if (r0.isShutdown() == true) goto L9;
        if (this.B.isTerminated() == false) goto L10;
    L13:
        th = move-exception;
        throw th;
    }

    public final void g(final String r11) {
        SharedPreferences r0 = i();
        int r2 = r0.getInt("traffic_query_retry_count", 0);
        if (r2 < 10) goto L7;
        r0.edit().remove("traffic_query_retry_at_ms").apply();
        this.h.removeCallbacksAndMessages(this.m);
        StringBuilder r10 = new StringBuilder("stop traffic query retry, city=").append(r11).append(", retryCount=").append(r2);
    L5:
        com.obric.cae.log.a.h("StarLocation-trafficGeo", r10.toString());
        return;
    L7:
        int r3 = r2 + 1;
        long r6 = f7056b * ((long) r3);
        long r8 = System.currentTimeMillis() + r6;
        r0.edit().putInt("traffic_query_retry_count", r3).putLong("traffic_query_retry_at_ms", r8).apply();
        this.h.removeCallbacksAndMessages(this.m);
        this.h.postDelayed(new $$Lambda$d$Tc3UGanGW8WjtBnWiSgYpz2gLgI(this, r11), this.m, r6);
        r10 = new StringBuilder("schedule traffic query retry, city=").append(r11).append(", retryCount=").append(r3).append(", delayMs=").append(r6);
        goto L5
    }

    public final com.obric.cae.location.geosdk.poi.a h() {
        return com.obric.cae.location.geosdk.poi.a.a(this.f, 0);
    }

    public final SharedPreferences i() {
        return this.f.getSharedPreferences("star_location_sp", 0);
    }
}
