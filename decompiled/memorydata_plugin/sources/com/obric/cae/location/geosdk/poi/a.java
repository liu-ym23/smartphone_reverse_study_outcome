package com.obric.cae.location.geosdk.poi;

import android.content.Context;
import android.location.Location;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.libs.location.poi.AoiBoard;
import com.obric.cae.location.geofence.StarGeofenceManager;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f7192a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f7193b = 0;
    public static final ConcurrentHashMap<Integer, a> c = null;
    public static final AtomicBoolean d = null;
    public static final b e = null;
    public long A;
    public String B;
    public String C;
    public AoiBoard.Confidence D;
    public float E;
    public volatile int F;
    public volatile int G;
    public volatile long H;
    public volatile boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final com.obric.cae.libs.location.poi.b.a f7194J;
    public final Context f;
    public final int g;
    public final InterfaceC0356a h;
    public final long i;
    public final int j;
    public final ConcurrentHashMap<IBinder, com.obric.cae.libs.location.poi.a> k;
    public final ConcurrentHashMap<IBinder, IBinder.DeathRecipient> l;
    public final ConcurrentHashMap<IBinder, Integer> m;
    public final ConcurrentHashMap<IBinder, Integer> n;
    public final ConcurrentHashMap<Integer, Set<IBinder>> o;
    public final ConcurrentHashMap<String, f> p;
    public final ExecutorService q;
    public final ScheduledExecutorService r;
    public final AtomicBoolean s;
    public final File t;
    public final Object u;
    public final com.obric.cae.location.geosdk.poi.e v;
    public ScheduledFuture<?> w;
    public ScheduledFuture<?> x;
    public boolean y;
    public long z;

    /* JADX INFO: renamed from: com.obric.cae.location.geosdk.poi.a$a, reason: collision with other inner class name */
    public interface InterfaceC0356a {
        int a(Set<AoiBoard.Type> r1);

        AoiBoard a(String r1);

        List<AoiBoard> a();

        boolean a(String r1, String r2);

        boolean a(List<AoiBoard> r1);

        int b();
    }

    public class b extends InnerAwareInfoCallback {
        public b() {
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public final void onHARStatusChanged(int r2, long r3) {
            Iterator r1 = a.c().iterator();
        L4:
            if (r1.hasNext() == false) goto L9;
            a r4 = (a) ZeusTransformUtils.preCheckCast(r1.next(), a.class, "com.obric.memorydata.plugin");
            if (r4.G == r2) goto L4;
            r4.G = r2;
            r4.g("har");
            goto L4
        }

        @Override // com.obric.cae.userAware.InnerAwareInfoCallback
        public final void onStepsCounterChanged(int r4) {
            Iterator r3 = a.c().iterator();
        L4:
            if (r3.hasNext() == false) goto L9;
            a r0 = (a) ZeusTransformUtils.preCheckCast(r3.next(), a.class, "com.obric.memorydata.plugin");
            if (r0.F == r4) goto L4;
            r0.F = r4;
            r0.g("steps");
            goto L4
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7196a = null;

        static {
            int[] r0 = new int[AoiBoard.Confidence.values().length];
            f7196a = r0;
            r0[AoiBoard.Confidence.MAX.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f7196a[AoiBoard.Confidence.HIGH.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f7196a[AoiBoard.Confidence.MEDIUM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f7196a[AoiBoard.Confidence.LOW.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f7196a[AoiBoard.Confidence.MIN.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ArrayList f7197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList f7198b;
        public final ArrayList c;
        public final ArrayList d;
        public AoiBoard e;
        public float f;

        public d() {
            this.f7197a = new ArrayList();
            this.f7198b = new ArrayList();
            this.c = new ArrayList();
            this.d = new ArrayList();
            this.f = Float.MAX_VALUE;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f7199a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f7200b;
        public final float c;

        public e(boolean r1, boolean r2, float r3) {
            this.f7199a = r1;
            this.f7200b = r2;
            this.c = r3;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f7201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f7202b;
        public AoiBoard.Confidence c;
        public AoiBoard.Confidence d;

        public f() {
            this.f7201a = Float.MAX_VALUE;
            AoiBoard.State r1 = AoiBoard.State.UNKNOWN;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AoiBoard f7203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Location f7204b;

        public g(AoiBoard r1, Location r2) {
            this.f7203a = r1;
            this.f7204b = new Location(r2);
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AoiBoard f7205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f7206b;
        public final StarGeofence c;
        public final LinkedHashMap<String, AoiBoard> d;
        public boolean e;

        public h(float r2, StarGeofence r3, AoiBoard r4) {
            this.d = new LinkedHashMap();
            this.f7205a = r4;
            this.f7206b = r2;
            this.c = r3;
            a(r4);
        }

        public final void a(AoiBoard r2) {
            if (r2.getPoiId().isEmpty() == true) goto L6;
            this.d.put(r2.getPoiId(), r2);
            return;
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<AoiBoard> f7207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f7208b;
        public float c;

        public i(ArrayList r2) {
            this.c = Float.MAX_VALUE;
            this.f7207a = r2;
        }
    }

    public static final class j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AoiBoard f7209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f7210b;

        public j(long r1, AoiBoard r3) {
            this.f7209a = r3;
            this.f7210b = r1;
        }
    }

    public static final class k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AoiBoard.Confidence f7211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AoiBoard.ConfidenceSource f7212b;

        public k(AoiBoard.Confidence r1, AoiBoard.ConfidenceSource r2) {
            this.f7211a = r1;
            this.f7212b = r2;
        }
    }

    public static final class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AoiBoard f7213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f7214b;

        public l(AoiBoard r1, float r2) {
            this.f7213a = r1;
            this.f7214b = r2;
        }
    }

    public static final class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final double f7215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final double f7216b;
        public final int c;
        public final boolean d;

        public m(double r1, double r3, int r5, boolean r6) {
            this.f7215a = r1;
            this.f7216b = r3;
            this.c = r5;
            this.d = r6;
        }
    }

    static {
        f7192a = TimeUnit.MINUTES.toMillis(10);
        f7193b = TimeUnit.SECONDS.toMillis(5);
        c = new ConcurrentHashMap();
        d = new AtomicBoolean(false);
        e = new b();
    }

    public a(Context r6, int r7, com.obric.cae.location.database.b r8, long r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        this.k = new ConcurrentHashMap();
        this.l = new ConcurrentHashMap();
        this.m = new ConcurrentHashMap();
        this.n = new ConcurrentHashMap();
        this.o = new ConcurrentHashMap();
        this.p = new ConcurrentHashMap();
        this.q = Executors.newSingleThreadExecutor();
        this.r = Executors.newSingleThreadScheduledExecutor();
        this.s = new AtomicBoolean(false);
        this.u = new Object();
        this.y = false;
        this.z = 0;
        this.A = 0;
        this.B = "";
        this.C = "";
        this.E = Float.MAX_VALUE;
        this.F = -1;
        this.G = 4;
        this.H = 0;
        this.I = false;
        this.f7194J = new AnonymousClass1(this);
        this.f = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r10.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.g = r7;
        this.h = r8;
        this.i = Math.max(0, r9);
        this.j = Math.max(1, 256);
        this.v = new com.obric.cae.location.geosdk.poi.e(this);
        this.t = l();
        f("init userId=" + r7);
        k();
    }

    public static long a(AoiBoard.Confidence r2) {
        int r3 = c.f7196a[r2.ordinal()];
        if (r3 != 1) goto L5;
        return 180000;
    L5:
        if (r3 != 2) goto L7;
        return 300000;
    L7:
        if (r3 != 3) goto L9;
        return 900000;
    L9:
        if (r3 == 4) goto L12;
        return Long.MAX_VALUE;
    L12:
        return 1800000;
    }

    public static AoiBoard a(AoiBoard r3) {
        AoiBoard r0 = new AoiBoard();
        r0.setPoiId(r3.getPoiId());
        r0.setPoiName(r3.getPoiName());
        r0.setAoiBoard(r3.getAoiBoard());
        r0.setCurState(r3.getCurState());
        r0.setTransitionType(r3.getTransitionType());
        r0.setConfidence(r3.getConfidence());
        r0.setConfidenceSource(r3.getConfidenceSource());
        r0.setEvent(r3.getEvent());
        r0.setType(r3.getType());
        r0.setGeofenceId(r3.getGeofenceId());
        r0.setEventTime(r3.getEventTime());
        return r0;
    }

    public static AoiBoard a(String r1, String r2, String r3, AoiBoard.Type r4) {
        AoiBoard r0 = new AoiBoard();
        r0.setPoiId(r1);
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.setPoiName(r2);
        if (r3 != null) goto L8;
        r3 = "";
    L8:
        r0.setAoiBoard(r3);
        r0.setCurState(AoiBoard.State.UNKNOWN);
        r0.setTransitionType(AoiBoard.TransitionType.ENTERED_AND_EXITED);
        r0.setConfidence(AoiBoard.Confidence.MIN);
        r0.setConfidenceSource(AoiBoard.ConfidenceSource.DEFAULT);
        r0.setEvent(AoiBoard.Event.UNKNOWN);
        r0.setType(r4);
        return r0;
    }

    public static /* synthetic */ f a(String r0) {
        return new f();
    }

    public static synchronized a a(Context r3) {
        monitor-enter(a.class);
        a r4 = a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), 0);     // Catch: Throwable -> L7
        monitor-exit(a.class);
        return r4;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized a a(Context r4, int r5) {
        monitor-enter(a.class);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L12
        if (d.compareAndSet(false, true) == false) goto L7;
        UserAwareManager.getInstance().registerInnerCallback(e);     // Catch: Throwable -> L12
        com.obric.cae.log.a.d("StarLocation-AoiManager", "inner aware callback registered");     // Catch: Throwable -> L12
    L7:
        if (r5 == 0) goto L9;
        b(r6, 0);     // Catch: Throwable -> L12
    L9:
        a r7 = b(r6, r5);     // Catch: Throwable -> L12
        monitor-exit(a.class);
        return r7;
    L12:
        th = move-exception;
        throw th;
    }

    public static String a(Context r7, StarGeofence r8, boolean r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        String r0 = r8.getPoiId();
        if (r0 != null) goto L5;
        return "null";
    L5:
        if (r0.isEmpty() == true) goto L35;
        int r11 = StarGeofenceManager.findUserIdByGeofence(r10, r8.getGeofenceId());
        if (r11 != (-1)) goto L10;
        r11 = 0;
    L10:
        StringBuilder r3 = new StringBuilder();
        Iterator<String> r1 = com.obric.cae.location.util.b.a(r0).iterator();
    L12:
        if (r1.hasNext() == false) goto L25;
        String r5 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        AoiBoard r6 = a(r10, r11).e(r5);
        if (r6 != null) goto L18;
        if (r9 == false) goto L18;
        if (r11 == 0) goto L18;
        r6 = a(r10, 0).e(r5);
    L18:
        if (r6 == null) goto L12;
        if (r3.length() <= 0) goto L23;
        r3.append(";");
    L23:
        r3.append(r6);
        goto L12
    L25:
        if (r3.length() != 0) goto L28;
        return "null";
    L28:
        return r3.toString();
    L35:
        return "null";
    }

    public static /* synthetic */ String a(boolean r0, String r1) {
        if (r0 == true) goto L4;
        return r1;
    L4:
        return com.obric.cae.log.a.d(r1);
    }

    public static EnumSet<AoiBoard.Type> a() {
        return EnumSet.of(AoiBoard.Type.AIRPORT, AoiBoard.Type.TRAIN_STATION);
    }

    public static List<AoiBoard> a(List<AoiBoard> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L19;
        if (r5.isEmpty() == true) goto L19;
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r6 = r5.iterator();
    L9:
        if (r6.hasNext() == false) goto L17;
        AoiBoard r2 = (AoiBoard) ZeusTransformUtils.preCheckCast(r6.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L9;
        if (r2.getPoiId().isEmpty() == true) goto L9;
        r0.put(r2.getPoiId(), a(r2));
        goto L9
    L17:
        return new ArrayList(r0.values());
    L19:
        return Collections.emptyList();
    }

    public static /* synthetic */ Set a(Integer r0) {
        return ConcurrentHashMap.newKeySet();
    }

    private void a(long r4, AoiBoard r6) {
        String r7 = r6.getPoiId();
        Object r0 = this.u;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (r4 == this.A) goto L7;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.y == false) goto L12;
        this.y = false;     // Catch: Throwable -> L14
        this.x = null;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        com.obric.cae.log.a.d("StarLocation-AoiManager", "[" + this.g + "] location task timeout, poiId=" + r7 + ", timeoutMs=20000");
        h(r7);
    }

    public static void a(Context r4, Location r5) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), 0);
        ArrayList r6 = c();
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r0 = r6.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.memorydata.plugin")).a(r5);
        goto L7
    L9:
        com.obric.cae.log.a.d("StarLocation-AoiManager", "fresh location dispatched to aoi managers, count=" + r6.size());
    }

    public static void a(Context r3, AoiBoard r4, Location r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Iterator r7 = c().iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        ((a) ZeusTransformUtils.preCheckCast(r7.next(), a.class, "com.obric.memorydata.plugin")).a(r4, r5);
        goto L4
    }

    public static boolean a(Context r7, int r8, StarGeofence r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
        return false;
    L5:
        String r2 = r9.getPoiId();
        if (r2 != null) goto L8;
    L31:
        return false;
    L8:
        if (r2.isEmpty() == true) goto L31;
        if (r8 != (-1)) goto L13;
        r8 = 0;
    L13:
        Iterator<String> r3 = com.obric.cae.location.util.b.a(r2).iterator();
    L15:
        if (r3.hasNext() == false) goto L31;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3.next(), String.class, "com.obric.memorydata.plugin");
        AoiBoard r5 = a(r10, r8).e(r4);
        if (r5 != null) goto L19;
    L23:
        if (r8 == 0) goto L15;
        AoiBoard r6 = a(r10, 0).e(r4);
        if (r6 == null) goto L15;
        if (r6.isBoundTo(r9) == false) goto L15;
        if (r6.getAoiBoard().isEmpty() == true) goto L15;
        return true;
    L19:
        if (r5.isBoundTo(r9) == false) goto L23;
        if (r5.getAoiBoard().isEmpty() == true) goto L23;
        return true;
    }

    public static boolean a(StarGeofence r2) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.getGeofenceId() == null) goto L18;
        String r3 = r2.getGeofenceId();
        if (r3 != null) goto L10;
        return false;
    L10:
        if (r3.startsWith("aoi_board_") == false) goto L12;
    L13:
        return true;
    L12:
        if (r3.startsWith("mall_") == true) goto L13;
        return false;
    L18:
        return false;
    }

    public static /* synthetic */ f b(String r0) {
        return new f();
    }

    public static synchronized a b(Context r8, int r9) {
        monitor-enter(a.class);
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        ConcurrentHashMap<Integer, a> r10 = c;     // Catch: Throwable -> L10
        a r1 = (a) ZeusTransformUtils.preCheckCast(r10.get(Integer.valueOf(r9)), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r1 != null) goto L8;
        a r7 = new a(r2, r9, new com.obric.cae.location.database.b((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r2.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r9), f7192a);     // Catch: Throwable -> L10
        r10.put(Integer.valueOf(r9), r7);     // Catch: Throwable -> L10
        r1 = r7;
    L8:
        monitor-exit(a.class);
        return r1;
    L10:
        th = move-exception;
        throw th;
    }

    public static String b(AoiBoard r2) {
        if (r2.getType() != AoiBoard.Type.MALL) goto L7;
        StringBuilder r0 = new StringBuilder("mall_");
    L6:
        return r0.append(r2.getPoiId()).toString();
    L7:
        r0 = new StringBuilder("aoi_board_");
        goto L6
    }

    public static LinkedHashMap b(List r5) {
        List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L11;
        AoiBoard r2 = (AoiBoard) ZeusTransformUtils.preCheckCast(r7.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        if (r2.getGeofenceId().isEmpty() == true) goto L4;
        ((List) ZeusTransformUtils.preCheckCast(r0.computeIfAbsent(r2.getGeofenceId(), $$Lambda$pCYFtL5oXMO2Ff5uGwcqBg6246g.INSTANCE), List.class, "com.obric.memorydata.plugin")).add(r2);
        goto L4
    L11:
        return r0;
    }

    public static ConcurrentHashMap<Integer, a> b() {
        return c;
    }

    public static void b(Context r4, Location r5) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), 0);
        ArrayList r6 = c();
        if (r6.isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r0 = r6.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        ((a) ZeusTransformUtils.preCheckCast(r0.next(), a.class, "com.obric.memorydata.plugin")).b(r5);
        goto L7
    L9:
        com.obric.cae.log.a.d("StarLocation-AoiManager", "fresh location dispatched to prune aoi geofences, count=" + r6.size());
    }

    private /* synthetic */ void b(IBinder r3) {
        a((IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin"));
    }

    public static ArrayList c() {
        return new ArrayList(c.values());
    }

    public static /* synthetic */ List c(String r0) {
        return new ArrayList();
    }

    private /* synthetic */ void c(long r1, String r3, AoiBoard r4) {
        a(r1, r3, a(r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v30, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.List] */
    private void c(Location r19) {
        String r4 = null;
        List<StarGeofence> r0 = com.obric.cae.location.database.c.a(this.f, this.g).a(this.g, null);     // Catch: Throwable -> L10
        ?? r5 = new ArrayList();     // Catch: Throwable -> L10
        Iterator<StarGeofence> r1 = r0.iterator();     // Catch: Throwable -> L10
    L5:
        if (r1.hasNext() == false) goto L13;
        StarGeofence r6 = (StarGeofence) ZeusTransformUtils.preCheckCast(r1.next(), StarGeofence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (a(r6) == false) goto L5;
        r5.add(r6);     // Catch: Throwable -> L10
    L13:
        if (r5.isEmpty() == true) goto L145;
        List<AoiBoard> r2 = g();
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator<AoiBoard> r8 = r2.iterator();
    L17:
        if (r8.hasNext() == false) goto L24;
        AoiBoard r9 = (AoiBoard) ZeusTransformUtils.preCheckCast(r8.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L17;
        if (r9.getPoiId().isEmpty() == true) goto L17;
        r7.put(r9.getPoiId(), r9);
        goto L17
    L24:
        LinkedHashMap r3 = b(r2);
        Iterator r10 = r5.iterator();
        int r11 = 0;
    L26:
        if (r10.hasNext() == false) goto L99;
        StarGeofence r12 = (StarGeofence) ZeusTransformUtils.preCheckCast(r10.next(), StarGeofence.class, "com.obric.memorydata.plugin");
        if (a(r12) == true) goto L30;
        Iterator r16 = r10;
        int r17 = r11;
    L97:
        r10 = r16;
        r11 = r17;
    L98:
        r4 = null;
        goto L26
    L30:
        String r13 = r12.getGeofenceId();
        LinkedHashMap r14 = new LinkedHashMap();
        Iterator<String> r15 = com.obric.cae.location.util.b.a(r12.getPoiId()).iterator();
    L32:
        if (r15.hasNext() == false) goto L36;
        AoiBoard r18 = (AoiBoard) ZeusTransformUtils.preCheckCast(r7.get((String) ZeusTransformUtils.preCheckCast(r15.next(), String.class, "com.obric.memorydata.plugin")), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r18 == null) goto L32;
        r14.put(r18.getPoiId(), r18);
        goto L32
    L36:
        String r110 = r12.getGeofenceId();
        if (r110 == null) goto L62;
        List r111 = (List) ZeusTransformUtils.preCheckCast(r3.get(r110), List.class, "com.obric.memorydata.plugin");
        if (r111 == null) goto L49;
        Iterator r112 = r111.iterator();
    L42:
        if (r112.hasNext() == false) goto L49;
        AoiBoard r113 = (AoiBoard) ZeusTransformUtils.preCheckCast(r112.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r113 == null) goto L42;
        if (r113.getPoiId().isEmpty() == true) goto L42;
        r14.put(r113.getPoiId(), r113);
    L49:
        if (r110.startsWith("aoi_board_") == false) goto L53;
        int r114 = 10;
    L51:
        String r115 = r110.substring(r114);
    L57:
        if (r14.isEmpty() == false) goto L62;
        if (r115 == null) goto L62;
        AoiBoard r116 = (AoiBoard) ZeusTransformUtils.preCheckCast(r7.get(r115), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r116 == null) goto L62;
        r14.put(r116.getPoiId(), r116);
        goto L62
    L53:
        if (r110.startsWith("mall_") == false) goto L55;
        r114 = 5;
        goto L51
    L55:
        r115 = r4;
    L62:
        i r117 = new i(new ArrayList(r14.values()));
        Iterator r118 = r14.values().iterator();
    L64:
        if (r118.hasNext() == false) goto L82;
        AoiBoard r119 = (AoiBoard) ZeusTransformUtils.preCheckCast(r118.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r119 != null) goto L68;
    L72:
        boolean r120 = false;
    L73:
        if (r120 == false) goto L64;
        Iterator r121 = r10;
        int r122 = r11;
        float r20 = com.obric.cae.location.util.c.b(r119.getAoiBoard(), r19.getLatitude(), r19.getLongitude());
        if (r20 >= r117.c) goto L79;
        r117.c = r20;
    L79:
        if (r20 > 5000.0f) goto L81;
        r117.f7208b = true;
    L81:
        r10 = r121;
        r11 = r122;
        goto L64
    L68:
        if (r119.getPoiId().isEmpty() == true) goto L72;
        if (r119.getAoiBoard().isEmpty() == true) goto L72;
        r120 = true;
        goto L73
    L82:
        r16 = r10;
        r17 = r11;
        if (r117.f7208b == true) goto L97;
        if (a(this.g, r13, "far_aoi") == false) goto L97;
        r11 = r17 + 1;
        Iterator<AoiBoard> r21 = r117.f7207a.iterator();
    L89:
        if (r21.hasNext() == false) goto L96;
        AoiBoard r22 = (AoiBoard) ZeusTransformUtils.preCheckCast(r21.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L89;
        if (r22.getPoiId().isEmpty() == true) goto L89;
        b(r22, r13, "far_away");
        goto L89
    L96:
        com.obric.cae.log.a.d("StarLocation-AoiManager", com.obric.cae.location.city.f.a("remove far aoi geofence id=", r13, ", poiIds=").append(r12.getPoiId()).append(", nearestDistanceMeters=").append(r117.c).append(", activeDistanceMeters=5000.0, boundCount=").append(r117.f7207a.size()).toString());
        r10 = r16;
        goto L98
    L99:
        int r123 = r11;
        if (r123 <= 0) goto L144;
        com.obric.cae.log.a.d("StarLocation-AoiManager", "[" + this.g + "] remove far aoi geofences, count=" + r123 + ", activeDistanceMeters=5000.0");
        return;
    L144:
        return;
    L145:
        return;
    L10:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-AoiManager", "list aoi geofences failed userId=" + this.g, th);
        r5 = Collections.emptyList();
        goto L13
    }

    public static /* synthetic */ f d(String r0) {
        return new f();
    }

    private void d(Location r23) {
        List<AoiBoard> r0 = g();
        if (r0.isEmpty() == false) goto L6;
        this.p.clear();
        String r1 = "empty";
    L5:
        i(r1);
        return;
    L6:
        HashSet r3 = new HashSet();
        Iterator<AoiBoard> r4 = r0.iterator();
    L8:
        if (r4.hasNext() == false) goto L14;
        AoiBoard r5 = (AoiBoard) ZeusTransformUtils.preCheckCast(r4.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L8;
        if (r5.getPoiId().isEmpty() == true) goto L8;
        r3.add(r5.getPoiId());
        goto L8
    L14:
        Iterator r6 = new ArrayList(this.p.keySet()).iterator();
    L16:
        if (r6.hasNext() == false) goto L20;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        if (r3.contains(r7) == true) goto L16;
        this.p.remove(r7);
        goto L16
    L20:
        SystemClock.elapsedRealtime();
        d r8 = new d();
        Iterator<AoiBoard> r9 = r0.iterator();
    L22:
        if (r9.hasNext() == false) goto L45;
        AoiBoard r10 = (AoiBoard) ZeusTransformUtils.preCheckCast(r9.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L22;
        if (r10.getPoiId().isEmpty() == true) goto L22;
        if (r10.getAoiBoard().isEmpty() == true) goto L22;
        e r2 = b(r10, r23);     // Catch: Throwable -> L42
        r8.f7197a.add(r10);     // Catch: Throwable -> L42
        float r11 = r2.c;     // Catch: Throwable -> L42
        if (r11 >= r8.f) goto L34;
        r8.f = r11;     // Catch: Throwable -> L42
        r8.e = r10;     // Catch: Throwable -> L42
    L34:
        if (r11 > 5000.0f) goto L37;
        r8.d.add(new l(r10, r11));     // Catch: Throwable -> L42
    L37:
        if (r2.f7199a == false) goto L22;
        r8.f7198b.add(r10);     // Catch: Throwable -> L42
        if (r2.f7200b == false) goto L22;
        r8.c.add(new g(r10, r23));     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-AoiManager", "failed, poiId=" + r10.getPoiId(), th);
        goto L22
    L45:
        if (r8.f7197a.isEmpty() == false) goto L47;
        r1 = "no-computed";
        goto L5
    L47:
        boolean r12 = d(r8.f7197a);
        if (r12 == true) goto L50;
        com.obric.cae.log.a.j("StarLocation-AoiManager", "update aoi boards failed userId=" + this.g + ", count=" + r8.f7197a.size());
        r1 = "save-failed";
        goto L5
    L50:
        Iterator r13 = r8.c.iterator();
    L52:
        if (r13.hasNext() == false) goto L57;
        g r14 = (g) ZeusTransformUtils.preCheckCast(r13.next(), g.class, "com.obric.memorydata.plugin");
        AoiBoard r15 = r14.f7203a;
        Location r16 = r14.f7204b;
        if (this.g == 0) goto L55;
        a(r15, r16);
        goto L52
    L55:
        a(this.f, r15, r16);
        goto L52
    L57:
        ArrayList r17 = r8.d;
        boolean r18 = true;
        if (r17.isEmpty() == true) goto L214;
        ArrayList r19 = new ArrayList();
        Iterator r20 = r17.iterator();
    L61:
        StarGeofence r21 = null;
        if (r20.hasNext() == false) goto L113;
        l r22 = (l) ZeusTransformUtils.preCheckCast(r20.next(), l.class, "com.obric.memorydata.plugin");
        if (r22 == null) goto L61;
        AoiBoard r110 = r22.f7213a;
        if (r110 != null) goto L68;
    L72:
        boolean r111 = false;
    L73:
        if (r111 == false) goto L80;
        AoiBoard.Type r112 = r110.getType();
        if (r112 == AoiBoard.Type.AIRPORT) goto L80;
        if (r112 == AoiBoard.Type.TRAIN_STATION) goto L80;
        boolean r113 = true;
    L81:
        if (r113 == false) goto L90;
        String r114 = r110.getGeofenceId();
        if (r114.isEmpty() == false) goto L86;
    L91:
        boolean r115 = true;
    L92:
        if (r115 == false) goto L61;
        AoiBoard r116 = r22.f7213a;
        com.obric.cae.location.util.c.a r117 = com.obric.cae.location.util.c.c(r116.getAoiBoard());
        if (r117 == null) goto L109;
        int r118 = Math.max(1, (int) Math.ceil(r117.c()));
        String r119 = this.f.getPackageName();
        AoiBoard.Type r120 = r116.getType();
        AoiBoard.Type r121 = AoiBoard.Type.MALL;
        if (r120 != r121) goto L102;
    L99:
        String r122 = b(r116);
    L104:
        r21 = new StarGeofence(r119, r122, r117.b(), r117.a(), r118, StarGeofence.GeoTransitionType.ENTERED_AND_EXITED);
        r21.setAddress(r116.getPoiName());
        r21.setConfidence(StarGeofence.GeoConfidence.HIGH);
        if (r116.getType() != r121) goto L107;
        StarGeofence.GeoType r24 = StarGeofence.GeoType.MALL;
    L108:
        r21.setGeoType(r24);
        r21.setPoiId(r116.getPoiId());
        goto L109
    L107:
        r24 = StarGeofence.GeoType.UNKNOWN;
        goto L108
    L102:
        if (r116.getGeofenceId().isEmpty() == true) goto L99;
        r122 = r116.getGeofenceId();
    L109:
        if (r21 == null) goto L61;
        r19.add(new h(r22.f7214b, r21, r22.f7213a));
        goto L61
    L86:
        if (r114.equals(b(r110)) == true) goto L91;
        if (r114.equals("aoi_board_" + r110.getPoiId()) == true) goto L91;
    L90:
        r115 = false;
    L80:
        r113 = false;
        goto L81
    L68:
        if (r110.getPoiId().isEmpty() == true) goto L72;
        if (r110.getAoiBoard().isEmpty() == true) goto L72;
        r111 = true;
        goto L73
    L113:
        if (r19.isEmpty() == true) goto L214;
        Iterator r25 = r19.iterator();
    L117:
        if (r25.hasNext() == false) goto L136;
        h r26 = (h) ZeusTransformUtils.preCheckCast(r25.next(), h.class, "com.obric.memorydata.plugin");
        Iterator r27 = r19.iterator();
        h r123 = null;
    L120:
        if (r27.hasNext() == false) goto L133;
        h r124 = (h) ZeusTransformUtils.preCheckCast(r27.next(), h.class, "com.obric.memorydata.plugin");
        if (r124 == r26) goto L120;
        if (r124.c.getRadius() <= r26.c.getRadius()) goto L120;
        StarGeofence r125 = r124.c;
        if (com.obric.cae.location.util.c.a(r26.f7205a.getAoiBoard(), r125.getLatitude(), r125.getLongitude(), r125.getRadius()) == false) goto L120;
        if (r123 == null) goto L132;
        if (r124.c.getRadius() >= r123.c.getRadius()) goto L120;
    L132:
        r123 = r124;
        goto L120
    L133:
        if (r123 == null) goto L117;
        r123.a(r26.f7205a);
        r26.e = true;
        com.obric.cae.log.a.d("StarLocation-AoiManager", "bind covered aoi to larger geofence, poiId=" + r26.f7205a.getPoiId() + ", geofenceId=" + r123.c.getGeofenceId() + ", ownerPoiId=" + r123.f7205a.getPoiId());
        goto L117
    L136:
        LinkedHashMap r28 = new LinkedHashMap();
        Iterator<StarGeofence> r29 = com.obric.cae.location.database.c.a(this.f, this.g).a().iterator();     // Catch: Throwable -> L157
    L139:
        if (r29.hasNext() == false) goto L144;
        StarGeofence r30 = (StarGeofence) ZeusTransformUtils.preCheckCast(r29.next(), StarGeofence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L157
        if (a(r30) == false) goto L139;
        r28.put(r30.getGeofenceId(), r30);     // Catch: Throwable -> L157
        goto L139
    L144:
        if (this.g == 0) goto L156;
        int r31 = 0;
        Iterator<StarGeofence> r32 = com.obric.cae.location.database.c.a(this.f, 0).a(-1, null).iterator();     // Catch: Throwable -> L154
    L149:
        if (r32.hasNext() == false) goto L160;
        StarGeofence r33 = (StarGeofence) ZeusTransformUtils.preCheckCast(r32.next(), StarGeofence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L154
        if (a(r33) == false) goto L149;
        r28.putIfAbsent(r33.getGeofenceId(), r33);     // Catch: Throwable -> L154
    L160:
        Iterator r34 = r19.iterator();
        int r35 = r31;
    L162:
        if (r34.hasNext() == false) goto L211;
        h r126 = (h) ZeusTransformUtils.preCheckCast(r34.next(), h.class, "com.obric.memorydata.plugin");
        if ((r126.e ^ r18) == false) goto L210;
        AoiBoard r36 = r126.f7205a;
        StarGeofence r127 = r126.c;
        if (r127 == null) goto L207;
        String r128 = r127.getGeofenceId();
        StarGeofence r129 = (StarGeofence) ZeusTransformUtils.preCheckCast(r28.get(r128), StarGeofence.class, "com.obric.memorydata.plugin");
        LinkedHashSet r130 = new LinkedHashSet();
        if (r129 == null) goto L172;
        r130.addAll(com.obric.cae.location.util.b.a(r129.getPoiId()));
    L172:
        r130.addAll(com.obric.cae.location.util.b.a(r126.c.getPoiId()));
        Iterator r37 = new ArrayList(r126.d.values()).iterator();
    L174:
        if (r37.hasNext() == false) goto L181;
        AoiBoard r38 = (AoiBoard) ZeusTransformUtils.preCheckCast(r37.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r38 == null) goto L174;
        if (r38.getPoiId().isEmpty() == true) goto L174;
        r130.add(r38.getPoiId());
        goto L174
    L181:
        r127.setPoiId(com.obric.cae.location.util.b.a(r130));
        if (r129 == null) goto L242;
        Set<String> r39 = com.obric.cae.location.util.b.a(r129.getPoiId());
        if (r39.isEmpty() == false) goto L186;
    L189:
        boolean r40 = a(r129, r127, r36, r126.f7206b);
        if (r40 == false) goto L192;
        r28.put(r128, r127);
    L192:
        int r41 = a(r128, "recover_existing", new ArrayList(r126.d.values()));
        if (r40 == true) goto L204;
        if (r41 <= 0) goto L207;
    L204:
        boolean r42 = true;
    L208:
        if (r42 == false) goto L210;
        r35 = r35 + r126.d.size();
        goto L210
    L186:
        if (Collections.disjoint(r39, r130) == false) goto L189;
        com.obric.cae.log.a.h("StarLocation-AoiManager", com.obric.cae.location.city.f.a("skip aoi geofence id conflict, geofenceId=", r128, ", poiId=").append(r36.getPoiId()).append(", existingPoiIds=").append(r39).toString());
        goto L207
    L242:
        byte r43 = StarGeofenceManager.getInstance(this.f, this.g).getBinder().addGeofence(r127);     // Catch: Throwable -> L205
        if (r43 != 0) goto L199;
    L202:
        r28.put(r128, r127);     // Catch: Throwable -> L205
        int r44 = a(r128, "nearby_add", new ArrayList(r126.d.values()));     // Catch: Throwable -> L205
        com.obric.cae.log.a.d("StarLocation-AoiManager", "add nearby aoi geofence id=" + r128 + ", poiIds=" + r127.getPoiId() + ", type=" + r36.getType() + ", distanceMeters=" + r126.f7206b + ", radius=" + r127.getRadius() + ", result=" + r43 + ", bindingCount=" + r44);     // Catch: Throwable -> L205
        if (r44 <= 0) goto L207;
    L199:
        if (r43 == 9) goto L202;
        com.obric.cae.log.a.h("StarLocation-AoiManager", "add nearby aoi geofence failed id=" + r128 + ", poiId=" + r36.getPoiId() + ", result=" + r43);     // Catch: Throwable -> L205
    L205:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-AoiManager", "add nearby aoi geofence failed id=" + r128, th);
    L207:
        r42 = false;
    L210:
        r18 = true;
        goto L162
    L211:
        if (r35 <= 0) goto L214;
        com.obric.cae.log.a.d("StarLocation-AoiManager", com.obric.cae.libs.statemachine.e.a(new StringBuilder("["), this.g, "] nearby aoi geofence coverage, count=", r35, ", activeDistanceMeters=5000.0, lat=").append(r23.getLatitude()).append(", lon=").append(r23.getLongitude()).toString());
    L154:
        th = th;
    L159:
        com.obric.cae.log.a.b("StarLocation-AoiManager", "query existing aoi geofences failed userId=" + this.g, th);
        goto L160
    L156:
        r31 = 0;
    L157:
        th = th;
        r31 = 0;
    L214:
        if (r8.f7198b.isEmpty() == true) goto L216;
        f("[" + this.g + "] location processed (" + r23.getLatitude() + ", " + r23.getLongitude() + "), computed=" + r8.f7197a.size() + ", changed=" + r8.f7198b.size() + ", dispatch=" + r8.c.size() + ", saved=" + r12);
    L216:
        AoiBoard r45 = r8.e;
        float r46 = r8.f;
        i("location-updated");
        if (r45 != null) goto L219;
        f("skip schedule userId=" + this.g + ", reason=aoi_update, nearestAoiBoard=null");
        return;
    L219:
        Object r47 = this.u;
        monitor-enter(r47);
        boolean r48 = r45.getPoiId().equals(this.C);     // Catch: Throwable -> L239
        if (r45.getConfidence() != this.D) goto L224;
        boolean r49 = true;
    L226:
        if (Math.abs(r46 - this.E) >= 100.0f) goto L228;
        boolean r50 = true;
    L229:
        if (r48 == false) goto L234;
        if (r49 == false) goto L234;
        if (r50 == false) goto L234;
        monitor-exit(r47);     // Catch: Throwable -> L239
    L237:
        b(a(r45.getConfidence()), "aoi_update-nearest", r45);
        return;
    L234:
        this.C = r45.getPoiId();     // Catch: Throwable -> L239
        this.D = r45.getConfidence();     // Catch: Throwable -> L239
        this.E = r46;     // Catch: Throwable -> L239
        monitor-exit(r47);     // Catch: Throwable -> L239
        com.obric.cae.log.a.b("StarLocation-AoiManager", "[" + this.g + "] reason= aoi_update, poiId=" + r45.getPoiId() + ", confidence=" + r45.getConfidence() + ", confidenceSource=" + r45.getConfidenceSource().name() + ", distanceMeters=" + r46);
        goto L237
    L228:
        r50 = false;
        goto L229
    L224:
        r49 = false;
    L239:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: lambda$BbRGOA9UEk_unuaTfsIU4y-Y7QE, reason: not valid java name */
    public static /* synthetic */ void m389lambda$BbRGOA9UEk_unuaTfsIU4yY7QE(a r0, Location r1) {
        r0.d(r1);
    }

    /* JADX INFO: renamed from: lambda$Od_W6I-f62kEw7Nc_Dqh155pmaU, reason: not valid java name */
    public static /* synthetic */ void m390lambda$Od_W6If62kEw7Nc_Dqh155pmaU(a r0, long r1, AoiBoard r3) {
        r0.a(r1, r3);
    }

    public static /* synthetic */ void lambda$TEysCNOMU90ULJxopzVbCSxhppQ(a r0, long r1, String r3, AoiBoard r4) {
        r0.c(r1, r3, r4);
    }

    public static /* synthetic */ void lambda$sMdlso0wot0yBUD_uMTnd51j9mc(a r0, IBinder r1) {
        r0.b(r1);
    }

    /* JADX INFO: renamed from: lambda$v0uRBpWvot4ip8b-tPD2qNUW4Uw, reason: not valid java name */
    public static /* synthetic */ void m391lambda$v0uRBpWvot4ip8btPD2qNUW4Uw(a r0, Location r1) {
        r0.c(r1);
    }

    public final int a(String r9, String r10, ArrayList r11) {
        Iterator r12 = r11.iterator();
        int r2 = 0;
    L4:
        if (r12.hasNext() == false) goto L30;
        AoiBoard r3 = (AoiBoard) ZeusTransformUtils.preCheckCast(r12.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L4;
        if (r3.getPoiId().isEmpty() == true) goto L4;
        String r5 = r3.getGeofenceId();
        if (r5.isEmpty() == true) goto L28;
        if (r5.equals(r9) == true) goto L28;
        if (r5.startsWith("aoi_board_") == false) goto L17;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == false) goto L28;
        com.obric.cae.log.a.d("StarLocation-AoiManager", "delete obsolete aoi geofence id=" + r5 + ", poiId=" + r3.getPoiId() + ", targetGeofenceId=" + r9 + ", result=" + StarGeofenceManager.getInstance(this.f, this.g).getBinder().deleteGeofenceById(this.f.getPackageName(), r5));     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-AoiManager", "delete obsolete aoi geofence failed id=".concat(r5), th);
        goto L28
    L17:
        if (r5.startsWith("mall_") == true) goto L20;
        r6 = false;
    L28:
        if (a(r3, r9, r10) == false) goto L4;
        r2 = r2 + 1;
        goto L4
    L30:
        return r2;
    }

    public int a(List<StarGeofence> r3, Set<AoiBoard.Type> r4) {
        return a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin"), null);
    }

    public final int a(List<StarGeofence> r10, Set<AoiBoard.Type> r11, List<AoiBoard> r12) {
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Set r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r11, Set.class, "com.obric.memorydata.plugin");
        List<AoiBoard> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin");
        if (r13.isEmpty() == false) goto L5;
        return 0;
    L5:
        com.obric.cae.log.a.d("StarLocation-AoiManager", "traffic list size=" + r13.size() + ", aoiBoardTypes=" + r14);
        Iterator r16 = r13.iterator();
        int r0 = 0;
    L7:
        if (r16.hasNext() == false) goto L41;
        StarGeofence r4 = (StarGeofence) ZeusTransformUtils.preCheckCast(r16.next(), StarGeofence.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L7;
        String r5 = r4.getGeofenceId();
        com.obric.cae.log.a.d("StarLocation-AoiManager", com.obric.cae.location.city.f.a("inspect traffic geofence id=", r5, ", geoType=").append(r4.getGeoType()).append(", address=").append(r4.getAddress()).toString());
        String r6 = r4.getGeofenceId();
        if (r4.getGeoType() != StarGeofence.GeoType.TRAFFIC) goto L21;
        if (r6 == null) goto L21;
        if (r6.startsWith("airport_") == false) goto L19;
        AoiBoard.Type r7 = AoiBoard.Type.AIRPORT;
    L22:
        if (r7 != null) goto L24;
    L26:
        boolean r8 = false;
    L27:
        if (r8 == false) goto L7;
        if (a(0, r5, "old_traffic") == false) goto L7;
        r0 = r0 + 1;
        if (r15 != null) goto L33;
        r15 = a(a());
    L33:
        if (r5 == null) goto L7;
        if (r5.isEmpty() == true) goto L7;
        Iterator<AoiBoard> r9 = r15.iterator();
    L39:
        if (r9.hasNext() == false) goto L7;
        b((AoiBoard) ZeusTransformUtils.preCheckCast(r9.next(), AoiBoard.class, "com.obric.memorydata.plugin"), r5, "old_traffic");
        goto L39
    L24:
        if (r14.contains(r7) == false) goto L26;
        r8 = true;
        goto L27
    L19:
        if (r6.startsWith("train_station_") == false) goto L21;
        r7 = AoiBoard.Type.TRAIN_STATION;
    L21:
        r7 = null;
        goto L22
    L41:
        return r0;
    }

    public synchronized List<AoiBoard> a(AoiBoard.Type r1) {
        monitor-enter(this);
        List<AoiBoard> r2 = a(Collections.singleton(r1));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r2;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized List<AoiBoard> a(Set<AoiBoard.Type> r6) {
        monitor-enter(this);
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r7.isEmpty() == false) goto L8;
        List<AoiBoard> r8 = Collections.emptyList();     // Catch: Throwable -> L26
        monitor-exit(this);
        return r8;
    L8:
        ArrayList r0 = new ArrayList();     // Catch: Throwable -> L26
        Iterator<AoiBoard> r1 = g().iterator();     // Catch: Throwable -> L26
    L10:
        if (r1.hasNext() == false) goto L24;
        AoiBoard r2 = (AoiBoard) ZeusTransformUtils.preCheckCast(r1.next(), AoiBoard.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r2 != null) goto L14;
    L18:
        boolean r3 = false;
    L19:
        if (r3 == false) goto L10;
        if (r7.contains(r2.getType()) == false) goto L10;
        r0.add(r2);     // Catch: Throwable -> L26
        goto L10
    L14:
        if (r2.getPoiId().isEmpty() == true) goto L18;
        if (r2.getAoiBoard().isEmpty() == true) goto L18;
        r3 = true;
        goto L19
    L24:
        monitor-exit(this);
        return r0;
    L26:
        th = move-exception;
        throw th;
    }

    public void a(int r6) {
        Set r0 = (Set) ZeusTransformUtils.preCheckCast(this.o.remove(Integer.valueOf(r6)), Set.class, "com.obric.memorydata.plugin");
        int r1 = 0;
        if (r0 == null) goto L10;
        Iterator r2 = r0.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        if (a((IBinder) ZeusTransformUtils.preCheckCast(r2.next(), IBinder.class, "com.obric.memorydata.plugin")) == false) goto L6;
        r1 = r1 + 1;
    L10:
        com.obric.cae.log.a.d("StarLocation-AoiManager", "unregister uid=" + r6 + ", removedCount=" + r1);
        f("unregister callback uid=" + r6 + ", removedCount=" + r1);
    }

    public void a(int r3, com.obric.cae.libs.location.poi.a r4) {
        a(r3, (com.obric.cae.libs.location.poi.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.cae.libs.location.poi.a.class, "com.obric.memorydata.plugin"), 255);
    }

    public void a(int r7, com.obric.cae.libs.location.poi.a r8, int r9) {
        com.obric.cae.libs.location.poi.a r10 = (com.obric.cae.libs.location.poi.a) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.cae.libs.location.poi.a.class, "com.obric.memorydata.plugin");
        final IBinder r1 = r10.asBinder();
        a(r1);
        IBinder.DeathRecipient r3 = new $$Lambda$a$sMdlso0wot0yBUD_uMTnd51j9mc(this, r1);
        r1.linkToDeath(r3, 0);     // Catch: RemoteException -> L5
        this.l.put(r1, r3);     // Catch: RemoteException -> L5
        this.m.put(r1, Integer.valueOf(r7));     // Catch: RemoteException -> L5
        this.n.put(r1, Integer.valueOf(r9));     // Catch: RemoteException -> L5
        ((Set) ZeusTransformUtils.preCheckCast(this.o.computeIfAbsent(Integer.valueOf(r7), $$Lambda$quAjs_7CY3VJ3E3uU_LYLOnWZM.INSTANCE), Set.class, "com.obric.memorydata.plugin")).add(r1);     // Catch: RemoteException -> L5
        this.k.put(r1, r10);     // Catch: RemoteException -> L5
        f(com.obric.cae.log.a.a() + " uid=" + r7 + (" callback=" + r10.hashCode()) + ", typeMask=" + r9);     // Catch: RemoteException -> L5
        return;
    L5:
        e = move-exception;
        f(com.obric.cae.log.a.a() + " failed uid=" + r7 + (" callback=" + r10.hashCode()) + ", error=" + e.getMessage());
    }

    public final void a(final long r6, String r8, final AoiBoard r9) {
        Object r0 = this.u;
        monitor-enter(r0);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (r6 == this.A) goto L9;
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L9:
        if (this.y == false) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L22
        return;
    L12:
        this.y = true;     // Catch: Throwable -> L22
        this.w = null;     // Catch: Throwable -> L22
        this.z = 0;     // Catch: Throwable -> L22
        ScheduledFuture<?> r2 = this.x;     // Catch: Throwable -> L22
        if (r2 == null) goto L15;
        r2.cancel(false);     // Catch: Throwable -> L22
    L15:
        this.x = this.r.schedule(new $$Lambda$a$Od_W6If62kEw7Nc_Dqh155pmaU(this, r6, r9), 20000, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L22
        monitor-exit(r0);     // Catch: Throwable -> L22
        g(Collections.singletonList(r9));
        this.H = SystemClock.elapsedRealtime();
        f("[" + this.g + "] run location task, reason= " + r8 + ", poiId=" + r9.getPoiId() + ", confidence=" + r9.getConfidence() + ", confidenceSource=" + r9.getConfidenceSource().name());
        com.obric.cae.location.a r7 = com.obric.cae.location.a.a();
        com.obric.cae.location.a.C0349a r10 = r7.a(f7193b);
        if (r10 != null) goto L20;
        com.obric.cae.location.util.d.a().b("fused", true, com.obric.cae.log.a.a());
        return;
    L20:
        this.H = TimeUnit.NANOSECONDS.toMillis(r10.n());
        a(r7.e(r10));
    }

    public final void a(Location r3) {
        final Location r0 = new Location(r3);
        this.q.execute(new $$Lambda$a$BbRGOA9UEk_unuaTfsIU4yY7QE(this, r0));
    }

    public void a(AoiBoard r12, Location r13) {
        int r3 = r12.getEvent().ordinal();
        if (r3 != 0) goto L5;
        return;
    L5:
        f("[" + this.g + "] notifyAoiBoardEvent " + r12.getEvent() + " to " + r12);
        UserAwareManager.getInstance().notifyInnerCallbacks($$Lambda$2SewHUK6DfRJkERW475v11YKhOs.INSTANCE, r12);
        Iterator<Map.Entry<IBinder, com.obric.cae.libs.location.poi.a>> r4 = this.k.entrySet().iterator();
    L7:
        if (r4.hasNext() == false) goto L21;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r4.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        IBinder r6 = (IBinder) ZeusTransformUtils.preCheckCast(r5.getKey(), IBinder.class, "com.obric.memorydata.plugin");
        Integer r8 = (Integer) ZeusTransformUtils.preCheckCast(this.m.get(r6), Integer.class, "com.obric.memorydata.plugin");
        com.obric.cae.libs.location.poi.a r7 = (com.obric.cae.libs.location.poi.a) ZeusTransformUtils.preCheckCast(r5.getValue(), com.obric.cae.libs.location.poi.a.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L7;
        if ((((Integer) ZeusTransformUtils.preCheckCast(this.n.getOrDefault(r6, 255), Integer.class, "com.obric.memorydata.plugin")).intValue() & (1 << r12.getType().getValue())) == 0) goto L7;
        r7.a(r12, r13, r3);     // Catch: Throwable -> L16
        f(com.obric.cae.log.a.a() + " uid=" + r8 + (" callback=" + r7.hashCode()) + ", poiId=" + r12.getPoiId() + ", event=" + r12.getEvent());     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        if (this.k.remove(r6, r7) == false) goto L20;
        a(r6);
    L20:
        f(com.obric.cae.log.a.a() + " failed uid=" + r8 + (" callback=" + r7.hashCode()) + ", poiId=" + r12.getPoiId() + ", event=" + r12.getEvent() + ", error=" + th.getMessage());
        goto L7
    }

    public final void a(AoiBoard r4, f r5, AoiBoard.Confidence r6, AoiBoard.State r7, String r8) {
        if (r5.f7202b >= 2) goto L5;
        return;
    L5:
        AoiBoard.Confidence r0 = r5.d;
        if (r0 == null) goto L9;
        r6 = r0;
    L9:
        int r1 = c.f7196a[r6.ordinal()];
        if (r1 == 1) goto L17;
        if (r1 != 2) goto L13;
        AoiBoard.Confidence r2 = AoiBoard.Confidence.MEDIUM;
    L18:
        r5.d = r2;
        r5.f7202b = 0;
        if (r6 == r2) goto L22;
        com.obric.cae.log.a.d("StarLocation-AoiManager", "[" + this.g + "] downgrade confidence , source=" + r8 + ", poiId=" + r4.getPoiId() + ", from=" + r6 + ", to=" + r2 + ", confidenceSource=" + AoiBoard.ConfidenceSource.RETRY.name() + ", curState=" + r7 + ", retryLimit=2");
        return;
    L22:
        return;
    L13:
        if (r1 == 3) goto L15;
        r2 = AoiBoard.Confidence.MIN;
        goto L18
    L15:
        r2 = AoiBoard.Confidence.LOW;
        goto L18
    L17:
        r2 = AoiBoard.Confidence.HIGH;
        goto L18
    }

    public void a(PrintWriter r3, String[] r4) {
        final boolean r0 = false;
        if (r4 != null) goto L5;
    L9:
        r3.println("Poi Log:");
        com.obric.cae.log.a.a(this.t, r3, new $$Lambda$cYxLOsnZNPsZUZY68r6mERdo34g(r0));
        return;
    L5:
        if (r4.length <= 0) goto L9;
        if ("--NeedDecrypt".equalsIgnoreCase(r4[0]) == false) goto L9;
        r0 = true;
        goto L9
    }

    public final boolean a(int r6, String r7, String r8) {
        if (r7 != null) goto L5;
    L13:
        return false;
    L5:
        if (r7.isEmpty() == true) goto L13;
        byte r5 = StarGeofenceManager.getInstance(this.f, r6).getBinder().deleteGeofenceById(this.f.getPackageName(), r7);     // Catch: Throwable -> L11
        com.obric.cae.log.a.d("StarLocation-AoiManager", "delete geofence id=" + r7 + ", reason=" + r8 + ", managerUserId=" + r6 + ", result=" + r5);     // Catch: Throwable -> L11
        if (r5 != 0) goto L16;
        return true;
    L16:
        return false;
    L11:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-AoiManager", "delete geofence failed id=" + r7 + ", reason=" + r8, th);
        goto L13
    }

    public boolean a(Location r32, List<StarGeofence> r33) {
        a r1 = this;
        String r2 = "com.obric.memorydata.plugin";
        List<StarGeofence> r0 = (List) ZeusTransformUtils.wrapperContextForParams(r33, List.class, "com.obric.memorydata.plugin");
        List<AoiBoard> r3 = r1.a(a());
        if (r0 != null) goto L6;
        r0 = j();
    L6:
        if (r0 != null) goto L9;
        return false;
    L9:
        if (r3.isEmpty() == false) goto L12;
        r1.a(r0, a(), r3);
        return true;
    L12:
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator<StarGeofence> r4 = r0.iterator();
    L14:
        if (r4.hasNext() == false) goto L23;
        StarGeofence r7 = (StarGeofence) ZeusTransformUtils.preCheckCast(r4.next(), StarGeofence.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L14;
        if (r7.getPoiId() == null) goto L14;
        if (r7.getPoiId().isEmpty() == true) goto L14;
        r5.put(r7.getPoiId(), r7);
        goto L14
    L23:
        Iterator<AoiBoard> r8 = r3.iterator();
    L25:
        if (r8.hasNext() == false) goto L108;
        AoiBoard r9 = (AoiBoard) ZeusTransformUtils.preCheckCast(r8.next(), AoiBoard.class, r2);
        float r6 = com.obric.cae.location.util.c.b(r9.getAoiBoard(), r32.getLatitude(), r32.getLongitude());
        StarGeofence r10 = (StarGeofence) ZeusTransformUtils.preCheckCast(r5.remove(r9.getPoiId()), StarGeofence.class, r2);
        if (r6 > 5000.0f) goto L100;
        AoiBoard.Type r11 = r9.getType();
        String r15 = r9.getPoiId();
        AoiBoard.Type r12 = AoiBoard.Type.AIRPORT;
        if (r11 != r12) goto L31;
        String r13 = "airport_";
    L32:
        String r14 = com.obric.cae.libs.utils.h.a(r13, r15);
        String r24 = r9.getPoiName();
        String r16 = r9.getPoiId();
        String r17 = r9.getAoiBoard();
        if (r9.getType() != r12) goto L35;
        int r18 = 3000;
    L36:
        int r22 = r18;
        if (r17 != null) goto L39;
    L48:
        m r19 = new m(0.0d, 0.0d, r22, false);
    L50:
        if (r17 == null) goto L57;
        if (r17.isEmpty() == true) goto L57;
        if (r19.d == true) goto L57;
        StarGeofence r110 = null;
    L65:
        if (r110 != null) goto L67;
    L66:
        r1 = this;
    L107:
        r8 = r8;
        r3 = r3;
        r2 = r2;
        r5 = r5;
        goto L25
    L67:
        String r20 = r110.getGeofenceId();
        String r21 = r9.getGeofenceId();
        if (r21.isEmpty() == true) goto L74;
        if (r10 != null) goto L71;
    L73:
        a r23 = this;
        r23.b(r9, null, "traffic_stale_binding");
    L75:
        if (r10 == null) goto L84;
        if (r20.equals(r10.getGeofenceId()) == false) goto L80;
        r23.c(r9, r20, "recover_existing");
        StringBuilder r25 = new StringBuilder("recover traffic geofence binding poiId=").append(r9.getPoiId()).append(", geofenceId=");
    L105:
        com.obric.cae.log.a.d("StarLocation-AoiManager", r25.append(r20).append(", distanceMeters=").append(r6).toString());
    L106:
        r1 = r23;
        goto L107
    L80:
        if (r23.a(0, r10.getGeofenceId(), "traffic") == false) goto L106;
        r23.b(r9, r10.getGeofenceId(), "traffic_replace_existing");
    L84:
        if (r9.getGeofenceId().isEmpty() == false) goto L106;
        byte r26 = StarGeofenceManager.getInstance(r23.f, 0).getBinder().addGeofence(r110);     // Catch: Throwable -> L96
        if (r26 != 0) goto L90;
    L93:
        boolean r27 = true;
    L94:
        com.obric.cae.log.a.d("StarLocation-AoiManager", "add nearby traffic geofence id=" + r110.getGeofenceId() + ", poiId=" + r110.getPoiId() + ", distanceMeters=" + r6 + ", radius=" + r110.getRadius() + ", result=" + r26);     // Catch: Throwable -> L96
    L98:
        if (r27 == false) goto L106;
        r23.c(r9, r20, "nearby_add");
        goto L106
    L90:
        if (r26 == 9) goto L93;
        r27 = false;
    L96:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-AoiManager", "add traffic geofence failed id=" + r110.getGeofenceId(), th);
        r27 = false;
        goto L98
    L71:
        if (r21.equals(r10.getGeofenceId()) == false) goto L73;
        com.obric.cae.log.a.b("StarLocation-AoiManager", "skip add bound traffic geofence poiId=" + r9.getPoiId() + ", geofenceId=" + r21 + ", distanceMeters=" + r6);
        goto L66
    L74:
        r23 = this;
    L57:
        StarGeofence r111 = new StarGeofence(r1.f.getPackageName(), r14, r19.f7215a, r19.f7216b, r19.c, StarGeofence.GeoTransitionType.ENTERED_AND_EXITED);
        if (r24 != null) goto L60;
        r24 = "";
    L60:
        r111.setAddress(r24);
        r111.setConfidence(StarGeofence.GeoConfidence.HIGH);
        r111.setGeoType(StarGeofence.GeoType.TRAFFIC);
        r111.setPoiId(r16);
        StringBuilder r28 = new StringBuilder("build traffic geofence id=").append(r14).append(", poiId=").append(r16).append(", radius=").append(r19.c).append(", source=");
        if (r19.d == false) goto L63;
        String r29 = "aoi";
    L64:
        com.obric.cae.log.a.b("StarLocation-AoiManager", r28.append(r29).toString());
        r110 = r111;
        goto L65
    L63:
        r29 = "fallback";
        goto L64
    L39:
        if (r17.isEmpty() == true) goto L48;
        com.obric.cae.location.util.c.a r30 = com.obric.cae.location.util.c.c(r17);
        if (r30 != null) goto L44;
    L47:
        r19 = new m(0.0d, 0.0d, r22, false);
        goto L50
    L44:
        if (r30.c() <= 0.0d) goto L47;
        r19 = new m(r30.b(), r30.a(), Math.max(300, (int) Math.ceil(r30.c())), true);
        goto L50
    L35:
        r18 = TypedValues.TransitionType.TYPE_DURATION;
        goto L36
    L31:
        r13 = "train_station_";
        goto L32
    L100:
        r2 = r2;
        r3 = r3;
        r5 = r5;
        r8 = r8;
        r6 = r6;
        r23 = r1;
        if (r10 == null) goto L106;
        if (r23.a(0, r10.getGeofenceId(), "traffic") == false) goto L106;
        r23.b(r9, r10.getGeofenceId(), "traffic_far_away");
        r25 = new StringBuilder("remove far traffic geofence poiId=").append(r9.getPoiId()).append(", geofenceId=");
        r20 = r10.getGeofenceId();
        goto L105
    L108:
        String r210 = r2;
        List<AoiBoard> r211 = r3;
        a r31 = r1;
        Iterator r34 = r5.values().iterator();
    L110:
        if (r34.hasNext() == false) goto L126;
        String r35 = r210;
        StarGeofence r36 = (StarGeofence) ZeusTransformUtils.preCheckCast(r34.next(), StarGeofence.class, r35);
        if (r36 != null) goto L114;
        boolean r37 = false;
    L115:
        if (r37 == false) goto L125;
        String r38 = r36.getGeofenceId();
        if (r38 == null) goto L125;
        if (r38.isEmpty() == true) goto L125;
        Iterator<AoiBoard> r39 = r211.iterator();
    L123:
        if (r39.hasNext() == false) goto L125;
        r31.b((AoiBoard) ZeusTransformUtils.preCheckCast(r39.next(), AoiBoard.class, r35), r38, "traffic_stale");
    L125:
        r210 = r35;
        goto L110
    L114:
        r37 = r31.a(0, r36.getGeofenceId(), "traffic");
        goto L115
    L126:
        return true;
    }

    public final boolean a(IBinder r6) {
        IBinder r7 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r6, IBinder.class, "com.obric.memorydata.plugin");
        com.obric.cae.libs.location.poi.a r0 = (com.obric.cae.libs.location.poi.a) ZeusTransformUtils.preCheckCast(this.k.remove(r7), com.obric.cae.libs.location.poi.a.class, "com.obric.memorydata.plugin");
        Integer r2 = (Integer) ZeusTransformUtils.preCheckCast(this.m.remove(r7), Integer.class, "com.obric.memorydata.plugin");
        this.n.remove(r7);
        if (r2 == null) goto L9;
        Set r3 = (Set) ZeusTransformUtils.preCheckCast(this.o.get(r2), Set.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L9;
        r3.remove(r7);
        if (r3.isEmpty() == false) goto L9;
        this.o.remove(r2, r3);
    L9:
        IBinder.DeathRecipient r5 = (IBinder.DeathRecipient) ZeusTransformUtils.preCheckCast(this.l.remove(r7), IBinder.DeathRecipient.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L17;
    L13:
        if (r0 == null) goto L19;
        return true;
    L19:
        return false;
    L17:
        r7.unlinkToDeath(r5, 0);     // Catch: Throwable -> L16
        goto L13
    }

    public final boolean a(StarGeofence r12, StarGeofence r13, AoiBoard r14, float r15) {
        boolean r3 = true;
        if (Math.abs(r12.getLatitude() - r13.getLatitude()) <= 1.0E-7d) goto L5;
    L14:
        boolean r2 = true;
    L15:
        if (r2 == true) goto L26;
        return false;
    L26:
        byte r11 = StarGeofenceManager.getInstance(this.f, this.g).getBinder().updateGeofence(r13);     // Catch: Throwable -> L23
        if (r11 == 0) goto L21;
        r3 = false;
    L21:
        com.obric.cae.log.a.d("StarLocation-AoiManager", "update nearby aoi geofence id=" + r13.getGeofenceId() + ", poiId=" + r14.getPoiId() + ", type=" + r14.getType() + ", distanceMeters=" + r15 + ", oldRadius=" + r12.getRadius() + ", newRadius=" + r13.getRadius() + ", result=" + r11);     // Catch: Throwable -> L23
        return r3;
    L23:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-AoiManager", "update nearby aoi geofence failed id=" + r13.getGeofenceId(), th);
        return false;
    L5:
        if (Math.abs(r12.getLongitude() - r13.getLongitude()) > 1.0E-7d) goto L14;
        if (r12.getRadius() != r13.getRadius()) goto L14;
        if (r12.getGeoType() != r13.getGeoType()) goto L14;
        if (Objects.equals(r12.getPoiId(), r13.getPoiId()) == false) goto L14;
        r2 = false;
        goto L15
    }

    public final boolean a(AoiBoard r3, String r4, String r5) {
        if (r4.equals(r3.getGeofenceId()) == false) goto L6;
        return true;
    L6:
        boolean r2 = a(r3.getPoiId(), r4);
        if (r2 == false) goto L9;
        r3.setGeofenceId(r4);
    L9:
        com.obric.cae.log.a.d("StarLocation-AoiManager", "persist aoi geofence binding poiId=" + r3.getPoiId() + ", geofenceId=" + r4 + ", reason=" + r5 + ", updated=" + r2);
        return r2;
    }

    public synchronized boolean a(String r10, String r11) {
        monitor-enter(this);
        if (r10 != null) goto L41;
    L34:
        monitor-exit(this);
        return false;
    L41:
    L36:
        th = move-exception;
        throw th;
    L6:
        if (r10.isEmpty() == true) goto L34;
        if (r11 != null) goto L10;
        r11 = "";
    L10:
        AoiBoard r2 = e(r10);     // Catch: Throwable -> L36
        if (r2 != null) goto L13;
    L39:
    L30:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-AoiManager", "updateAoiBoardGeofenceId failed, poiId=".concat(r10), e);     // Catch: Throwable -> L36
        return false;
    L17:
        if (this.h.a(r10, r11) == true) goto L20;
        monitor-exit(this);
        return false;
    L20:
        if (r2 != null) goto L22;
        r2 = this.h.a(r10);     // Catch: RuntimeException -> L30 Throwable -> L36
    L22:
        if (r2 == null) goto L28;
        r2.setGeofenceId(r11);     // Catch: RuntimeException -> L30 Throwable -> L36
        if (r2.getPoiId().isEmpty() == true) goto L27;
        this.v.put(r2.getPoiId(), new j(System.currentTimeMillis(), a(r2)));     // Catch: RuntimeException -> L30 Throwable -> L36
    L27:
        com.obric.cae.log.a.d("StarLocation-AoiManager", "[" + this.g + "] update aoi_board, poiId=" + r10 + ", geofenceId=" + r11);     // Catch: RuntimeException -> L30 Throwable -> L36
    L28:
        monitor-exit(this);
        return true;
    L13:
        if (r11.equals(r2.getGeofenceId()) == false) goto L39;
        monitor-exit(this);
        return true;
    }

    public synchronized boolean a(Set<AoiBoard.Type> r8, List<AoiBoard> r9) {
        monitor-enter(this);
        Set<AoiBoard.Type> r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r8, Set.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L45
        if (r10.isEmpty() == false) goto L8;
        monitor-exit(this);
        return false;
    L8:
        List<AoiBoard> r12 = a(r11);     // Catch: Throwable -> L45
        LinkedHashMap r0 = b(r10);     // Catch: RuntimeException -> L41 Throwable -> L45
        if (r12.isEmpty() == false) goto L12;
    L20:
        int r1 = this.h.a(r10);     // Catch: RuntimeException -> L41 Throwable -> L45
        Iterator<AoiBoard.Type> r2 = r10.iterator();     // Catch: RuntimeException -> L41 Throwable -> L45
    L22:
        if (r2.hasNext() == false) goto L24;
        b((AoiBoard.Type) ZeusTransformUtils.preCheckCast(r2.next(), AoiBoard.Type.class, "com.obric.memorydata.plugin"));     // Catch: RuntimeException -> L41 Throwable -> L45
        goto L22
    L24:
        this.p.clear();     // Catch: RuntimeException -> L41 Throwable -> L45
        Object r3 = this.u;     // Catch: RuntimeException -> L41 Throwable -> L45
        monitor-enter(r3);     // Catch: RuntimeException -> L41 Throwable -> L45
        this.B = "";     // Catch: Throwable -> L38
        this.z = 0;     // Catch: Throwable -> L38
        monitor-exit(r3);     // Catch: Throwable -> L38
        if (r12.isEmpty() == false) goto L31;
    L34:
        boolean r4 = true;
    L35:
        com.obric.cae.log.a.c("StarLocation-AoiManager", "replaceAoiBoardsByTypes replaceTypes=" + r10 + ", replacementCount=" + r12.size() + ", deletedCount=" + r1 + ", success=" + r4);     // Catch: RuntimeException -> L41 Throwable -> L45
        monitor-exit(this);
        return r4;
    L31:
        if (c(r12) == true) goto L34;
        r4 = false;
    L38:
        th = move-exception;
        throw th;     // Catch: RuntimeException -> L41 Throwable -> L45
    L12:
        if (r0.isEmpty() == true) goto L20;
        Iterator<AoiBoard> r5 = r12.iterator();     // Catch: RuntimeException -> L41 Throwable -> L45
    L16:
        if (r5.hasNext() == false) goto L20;
        AoiBoard r6 = (AoiBoard) ZeusTransformUtils.preCheckCast(r5.next(), AoiBoard.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L41 Throwable -> L45
        AoiBoard r7 = (AoiBoard) ZeusTransformUtils.preCheckCast(r0.get(r6.getPoiId()), AoiBoard.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L41 Throwable -> L45
        if (r7 == null) goto L16;
        r6.setCurState(r7.getCurState());     // Catch: RuntimeException -> L41 Throwable -> L45
        r6.setConfidence(r7.getConfidence());     // Catch: RuntimeException -> L41 Throwable -> L45
        r6.setConfidenceSource(r7.getConfidenceSource());     // Catch: RuntimeException -> L41 Throwable -> L45
        r6.setEvent(r7.getEvent());     // Catch: RuntimeException -> L41 Throwable -> L45
        r6.setEventTime(r7.getEventTime());     // Catch: RuntimeException -> L41 Throwable -> L45
        r6.setGeofenceId(r7.getGeofenceId());     // Catch: RuntimeException -> L41 Throwable -> L45
    L41:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-AoiManager", "replaceAoiBoardsByTypes failed, replaceTypes=" + r10, e);     // Catch: Throwable -> L45
        return false;
    L45:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Failed to calculate best type for var: r4v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v4 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v4 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v4 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v5 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v5 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r4v6 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v6 ??, new type: boolean
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$1(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r4v4 ??, new type: boolean
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    public final com.obric.cae.location.geosdk.poi.a.e b(com.obric.cae.libs.location.poi.AoiBoard r19, android.location.Location r20) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0199: CONST (r4v6 ?? I:??[boolean, int, float, short, byte, char]) = (1 ??[boolean, int, float, short, byte, char]) A[DECLARE_VAR] in method: com.obric.cae.location.geosdk.poi.a.b(com.obric.cae.libs.location.poi.AoiBoard, android.location.Location):com.obric.cae.location.geosdk.poi.a$e, file: classes3.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 417
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.cae.location.geosdk.poi.a.b(com.obric.cae.libs.location.poi.AoiBoard, android.location.Location):com.obric.cae.location.geosdk.poi.a$e");
    }

    public final LinkedHashMap b(Set r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator<AoiBoard> r4 = this.h.a().iterator();
    L4:
        if (r4.hasNext() == false) goto L13;
        AoiBoard r2 = (AoiBoard) ZeusTransformUtils.preCheckCast(r4.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        if (r2.getPoiId().isEmpty() == true) goto L4;
        if (r6.contains(r2.getType()) == false) goto L4;
        r0.put(r2.getPoiId(), a(r2));
        goto L4
    L13:
        return r0;
    }

    public final void b(long r17, final String r19, final AoiBoard r20) {
        long r2 = Long.MAX_VALUE;
        if (r17 != Long.MAX_VALUE) goto L7;
        StringBuilder r0 = new StringBuilder("[").append(this.g).append("] skip location task, reason= ").append(r19).append(", poiId=").append(r20.getPoiId()).append(", confidence=").append(r20.getConfidence()).append(", confidenceSource=");
        String r1 = r20.getConfidenceSource().name();
    L5:
        com.obric.cae.log.a.b("StarLocation-AoiManager", r0.append(r1).toString());
        return;
    L7:
        long r4 = SystemClock.elapsedRealtime();
        if (this.H <= 0) goto L11;
        r2 = r4 - this.H;
    L11:
        if (r2 >= 180000) goto L14;
        r0 = new StringBuilder("[").append(this.g).append("] skip location task, reason= ").append(r19).append(", poiId=").append(r20.getPoiId()).append(", elapsedSinceLastRequestMs=").append(r2);
        r1 = ", minIntervalMs=180000";
        goto L5
    L14:
        if (this.H <= 0) goto L16;
        long r3 = this.H + r17;
    L17:
        long r11 = Math.max(0, r3 - r4);
        Object r13 = this.u;
        monitor-enter(r13);
    L38:
        th = move-exception;
        throw th;
    L20:
        if (this.y == false) goto L24;
        com.obric.cae.log.a.b("StarLocation-AoiManager", "[" + this.g + "] skip location task, reason= " + r19 + ", poiId=" + r20.getPoiId() + ", inFlight=true");     // Catch: Throwable -> L38
        monitor-exit(r13);     // Catch: Throwable -> L38
        return;
    L24:
        ScheduledFuture<?> r5 = this.w;     // Catch: Throwable -> L38
        if (r5 != null) goto L27;
    L35:
        final long r14 = 1 + this.A;     // Catch: Throwable -> L38
        this.A = r14;     // Catch: Throwable -> L38
        this.B = r20.getPoiId();     // Catch: Throwable -> L38
        this.z = r4 + r11;     // Catch: Throwable -> L38
        this.w = this.r.schedule(new $$Lambda$a$TEysCNOMU90ULJxopzVbCSxhppQ(this, r14, r19, r20), r11, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L38
        com.obric.cae.log.a.d("StarLocation-AoiManager", "[" + this.g + "] reason= " + r19 + ", poiId=" + r20.getPoiId() + ", confidence=" + r20.getConfidence() + ", confidenceSource=" + r20.getConfidenceSource().name() + ", delayMs=" + r11 + ", intervalMs=" + r17);     // Catch: Throwable -> L38
        monitor-exit(r13);     // Catch: Throwable -> L38
        return;
    L27:
        if (r5.isDone() == true) goto L35;
        if (this.z <= r3) goto L31;
    L34:
        this.w.cancel(false);     // Catch: Throwable -> L38
        goto L35
    L31:
        if (r20.getPoiId().equals(this.B) == false) goto L34;
        monitor-exit(r13);     // Catch: Throwable -> L38
        return;
    L16:
        r3 = r4;
        goto L17
    }

    public final void b(Location r3) {
        final Location r0 = new Location(r3);
        this.q.execute(new $$Lambda$a$v0uRBpWvot4ip8btPD2qNUW4Uw(this, r0));
    }

    public final void b(AoiBoard.Type r7) {
        ArrayList r0 = new ArrayList();
        Iterator<Map.Entry<String, j>> r1 = this.v.entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        Map.Entry r2 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        j r4 = (j) ZeusTransformUtils.preCheckCast(r2.getValue(), j.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L4;
        if (r4.f7209a.getType() != r7) goto L4;
        r0.add((String) ZeusTransformUtils.preCheckCast(r2.getKey(), String.class, "com.obric.memorydata.plugin"));
        goto L4
    L10:
        Iterator r8 = r0.iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r8.next(), String.class, "com.obric.memorydata.plugin");
        this.v.remove(r3);
        goto L12
    }

    public final boolean b(AoiBoard r5, String r6, String r7) {
        String r0 = r5.getGeofenceId();
        if (r0.isEmpty() == false) goto L7;
        return true;
    L7:
        if (r6 != null) goto L9;
    L14:
        boolean r4 = a(r5.getPoiId(), "");
        if (r4 == false) goto L17;
        r5.setGeofenceId("");
    L17:
        com.obric.cae.log.a.b("StarLocation-AoiManager", "clear aoi geofence binding poiId=" + r5.getPoiId() + ", geofenceId=" + r0 + ", reason=" + r7 + ", updated=" + r4);
        return r4;
    L9:
        if (r6.isEmpty() == true) goto L14;
        if (r6.equals(r0) == true) goto L14;
        com.obric.cae.log.a.b("StarLocation-AoiManager", "skip clear aoi geofence binding poiId=" + r5.getPoiId() + ", boundGeofenceId=" + r0 + ", expectedGeofenceId=" + r6 + ", reason=" + r7);
        return false;
    }

    public final void c(AoiBoard r3, String r4, String r5) {
        if (r4.equals(r3.getGeofenceId()) == false) goto L5;
        return;
    L5:
        boolean r2 = a(r3.getPoiId(), r4);
        if (r2 == false) goto L8;
        r3.setGeofenceId(r4);
    L8:
        com.obric.cae.log.a.d("StarLocation-AoiManager", "persist traffic geofence binding poiId=" + r3.getPoiId() + ", geofenceId=" + r4 + ", reason=" + r5 + ", updated=" + r2);
    }

    public synchronized boolean c(AoiBoard r1) {
        monitor-enter(this);
        if (r1 != null) goto L5;
        List r2 = Collections.emptyList();     // Catch: Throwable -> L9
    L6:
        boolean r3 = h(r2);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r3;
    L5:
        r2 = Collections.singletonList(r1);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized boolean c(List<AoiBoard> r12) {
        monitor-enter(this);
    L103:
        th = move-exception;
        throw th;
    L107:
        List<AoiBoard> r13 = a((List) ZeusTransformUtils.wrapperContextForParams(r12, List.class, "com.obric.memorydata.plugin"));     // Catch: RuntimeException -> L99 Throwable -> L103
        Iterator<AoiBoard> r1 = r13.iterator();     // Catch: RuntimeException -> L99 Throwable -> L103
    L7:
        if (r1.hasNext() == false) goto L13;
        AoiBoard r2 = (AoiBoard) ZeusTransformUtils.preCheckCast(r1.next(), AoiBoard.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L99 Throwable -> L103
        AoiBoard r3 = this.h.a(r2.getPoiId());     // Catch: RuntimeException -> L99 Throwable -> L103
        if (r3 == null) goto L7;
        r2.setCurState(r3.getCurState());     // Catch: RuntimeException -> L99 Throwable -> L103
        r2.setConfidence(r3.getConfidence());     // Catch: RuntimeException -> L99 Throwable -> L103
        r2.setConfidenceSource(r3.getConfidenceSource());     // Catch: RuntimeException -> L99 Throwable -> L103
        r2.setEvent(r3.getEvent());     // Catch: RuntimeException -> L99 Throwable -> L103
        r2.setEventTime(r3.getEventTime());     // Catch: RuntimeException -> L99 Throwable -> L103
        r2.setGeofenceId(r3.getGeofenceId());     // Catch: RuntimeException -> L99 Throwable -> L103
    L13:
        if (r13.isEmpty() == false) goto L17;
        com.obric.cae.log.a.g("StarLocation-AoiManager", "addAoiBoards skipped, empty or invalid input");     // Catch: Throwable -> L103
        monitor-exit(this);
        return false;
    L17:
        ArrayList r4 = new ArrayList();     // Catch: Throwable -> L103
        ArrayList r5 = new ArrayList();     // Catch: Throwable -> L103
        Iterator<AoiBoard> r6 = r13.iterator();     // Catch: Throwable -> L103
    L18:
        boolean r7 = true;
        if (r6.hasNext() == false) goto L109;
        AoiBoard r8 = (AoiBoard) ZeusTransformUtils.preCheckCast(r6.next(), AoiBoard.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L103
        if (r8 == null) goto L18;
        if (r8.getPoiId().isEmpty() == true) goto L18;
        AoiBoard r9 = e(r8.getPoiId());     // Catch: Throwable -> L103
        if (r9 == null) goto L27;
        if (r9.getPoiId().equals(r8.getPoiId()) == true) goto L31;
    L51:
        r7 = false;
    L52:
        if (r7 == true) goto L18;
        r5.add(a(r8));     // Catch: Throwable -> L103
        goto L18
    L31:
        if (r9.getPoiName().equals(r8.getPoiName()) == false) goto L51;
        if (r9.getAoiBoard().equals(r8.getAoiBoard()) == false) goto L51;
        if (r9.getCurState() != r8.getCurState()) goto L51;
        if (r9.getTransitionType() != r8.getTransitionType()) goto L51;
        if (r9.getConfidence() != r8.getConfidence()) goto L51;
        if (r9.getConfidenceSource() != r8.getConfidenceSource()) goto L51;
        if (r9.getEvent() != r8.getEvent()) goto L51;
        if (r9.getEventTime() != r8.getEventTime()) goto L51;
        if (r9.getGeofenceId().equals(r8.getGeofenceId()) == false) goto L51;
        if (r9.getType() != r8.getType()) goto L51;
    L27:
        r4.add(a(r8));     // Catch: Throwable -> L103
        goto L18
    L109:
        boolean r10 = this.h.a(r13);     // Catch: RuntimeException -> L95 Throwable -> L103
        if (r10 == false) goto L93;
        f(r13);     // Catch: RuntimeException -> L95 Throwable -> L103
        Iterator r14 = r4.iterator();     // Catch: RuntimeException -> L95 Throwable -> L103
    L59:
        if (r14.hasNext() == false) goto L61;
        f("[" + this.g + "] add " + ((AoiBoard) ZeusTransformUtils.preCheckCast(r14.next(), AoiBoard.class, "com.obric.memorydata.plugin")));     // Catch: RuntimeException -> L95 Throwable -> L103
        goto L59
    L61:
        Iterator r15 = r5.iterator();     // Catch: RuntimeException -> L95 Throwable -> L103
    L63:
        if (r15.hasNext() == false) goto L65;
        AoiBoard r11 = (AoiBoard) ZeusTransformUtils.preCheckCast(r15.next(), AoiBoard.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L95 Throwable -> L103
        f("[" + this.g + "] update aoi_board: " + r11.getPoiId() + ", name=" + r11.getPoiName() + ", curState=" + r11.getCurState() + ", confidence=" + r11.getConfidence() + ", confidenceSource=" + r11.getConfidenceSource().name());     // Catch: RuntimeException -> L95 Throwable -> L103
        goto L63
    L65:
        ArrayList r16 = new ArrayList(r4.size() + r5.size());     // Catch: RuntimeException -> L95 Throwable -> L103
        r16.addAll(r4);     // Catch: RuntimeException -> L95 Throwable -> L103
        r16.addAll(r5);     // Catch: RuntimeException -> L95 Throwable -> L103
        if (r16.isEmpty() == true) goto L89;
        Iterator r17 = r16.iterator();     // Catch: RuntimeException -> L95 Throwable -> L103
    L70:
        if (r17.hasNext() == false) goto L89;
        AoiBoard r18 = (AoiBoard) ZeusTransformUtils.preCheckCast(r17.next(), AoiBoard.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L95 Throwable -> L103
        if (r18 != null) goto L74;
    L78:
        boolean r19 = false;
    L79:
        if (r19 == false) goto L86;
        AoiBoard.Type r20 = r18.getType();     // Catch: RuntimeException -> L95 Throwable -> L103
        if (r20 == AoiBoard.Type.AIRPORT) goto L86;
        if (r20 == AoiBoard.Type.TRAIN_STATION) goto L86;
        boolean r21 = true;
    L87:
        if (r21 == false) goto L70;
    L90:
        if (r18 == null) goto L93;
        b(180000, "aoi_geofence_cover", r18);     // Catch: RuntimeException -> L95 Throwable -> L103
    L86:
        r21 = false;
        goto L87
    L74:
        if (r18.getPoiId().isEmpty() == true) goto L78;
        if (r18.getAoiBoard().isEmpty() == true) goto L78;
        r19 = true;
    L89:
        r18 = null;
    L93:
        monitor-exit(this);
        return r10;
    L95:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-AoiManager", "addAoiBoards failed", e);     // Catch: Throwable -> L103
        return false;
    L99:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-AoiManager", "addAoiBoards failed to preserve runtime state", e);     // Catch: Throwable -> L103
        return false;
    }

    public com.obric.cae.libs.location.poi.b d() {
        return this.f7194J;
    }

    public synchronized boolean d(List<AoiBoard> r3) {
        monitor-enter(this);
        boolean r4 = h((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }

    public int e(List<StarGeofence> r3) {
        return a((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), a());
    }

    public synchronized AoiBoard e(String r9) {
        monitor-enter(this);
        if (r9 != null) goto L43;
    L39:
        monitor-exit(this);
        return null;
    L43:
    L36:
        th = move-exception;
        throw th;
    L6:
        if (r9.isEmpty() == true) goto L39;
        j r1 = (j) ZeusTransformUtils.preCheckCast(this.v.get(r9), j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        if (r1 != null) goto L11;
    L15:
        boolean r2 = false;
    L16:
        if (r2 == false) goto L20;
        AoiBoard r10 = a(r1.f7209a);     // Catch: Throwable -> L36
        monitor-exit(this);
        return r10;
    L20:
        this.v.remove(r9);     // Catch: Throwable -> L36
        AoiBoard r3 = this.h.a(r9);     // Catch: RuntimeException -> L32 Throwable -> L36
        if (r3 != null) goto L26;
        monitor-exit(this);
        return null;
    L26:
        if (r3.getPoiId().isEmpty() == true) goto L29;
        com.obric.cae.location.geosdk.poi.e r4 = this.v;     // Catch: RuntimeException -> L32 Throwable -> L36
        String r5 = r3.getPoiId();     // Catch: RuntimeException -> L32 Throwable -> L36
        AoiBoard r6 = a(r3);     // Catch: RuntimeException -> L32 Throwable -> L36
        r4.put(r5, new j(System.currentTimeMillis(), r6));     // Catch: RuntimeException -> L32 Throwable -> L36
    L29:
        AoiBoard r11 = a(r3);     // Catch: RuntimeException -> L32 Throwable -> L36
        monitor-exit(this);
        return r11;
    L32:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-AoiManager", "queryAoiBoardByPoiId failed, poiId=".concat(r9), e);     // Catch: Throwable -> L36
        return null;
    L11:
        if (this.i > 0) goto L13;
    L14:
        r2 = true;
        goto L16
    L13:
        if ((System.currentTimeMillis() - r1.f7210b) > this.i) goto L15;
        goto L14
    }

    public boolean e() {
        return this.s.get();
    }

    public synchronized int f() {
        monitor-enter(this);
        int r0 = this.h.b();     // Catch: Throwable -> L12 RuntimeException -> L14
        this.v.clear();     // Catch: Throwable -> L12 RuntimeException -> L14
        f(this.h.a());     // Catch: Throwable -> L12 RuntimeException -> L14
        this.p.clear();     // Catch: Throwable -> L12 RuntimeException -> L14
        Object r1 = this.u;     // Catch: Throwable -> L12 RuntimeException -> L14
        monitor-enter(r1);     // Catch: Throwable -> L12 RuntimeException -> L14
        this.B = "";     // Catch: Throwable -> L9
        this.z = 0;     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12 RuntimeException -> L14
    L14:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-AoiManager", "deleteAllAoiBoards failed", e);     // Catch: Throwable -> L12
        return 0;
    L12:
        th = move-exception;
        throw th;
    }

    public void f(String r2) {
        File r1 = this.t;
        if (r1 == null) goto L6;
        com.obric.cae.log.a.b("StarLocation-AoiManager", r2, r1);
        return;
    }

    public final void f(List<AoiBoard> r8) {
        List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L5;
        return;
    L5:
        if (r9.isEmpty() == true) goto L24;
        Iterator r10 = r9.iterator();
    L9:
        if (r10.hasNext() == false) goto L25;
        AoiBoard r0 = (AoiBoard) ZeusTransformUtils.preCheckCast(r10.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L9;
        if (r0.getPoiId().isEmpty() == true) goto L9;
        com.obric.cae.location.geosdk.poi.e r2 = this.v;
        String r3 = r0.getPoiId();
        AoiBoard r1 = a(r0);
        r2.put(r3, new j(System.currentTimeMillis(), r1));
        goto L9
    L25:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List<com.obric.cae.libs.location.poi.AoiBoard>] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.ArrayList] */
    public synchronized List<AoiBoard> g() {
        monitor-enter(this);
        List<AoiBoard> r0 = this.h.a();     // Catch: Throwable -> L17 RuntimeException -> L19
        this.v.clear();     // Catch: Throwable -> L17 RuntimeException -> L19
        f(r0);     // Catch: Throwable -> L17 RuntimeException -> L19
        if (r0 != null) goto L6;
    L14:
        ?? r1 = Collections.emptyList();     // Catch: Throwable -> L17 RuntimeException -> L19
    L15:
        monitor-exit(this);
        return r1;
    L6:
        if (r0.isEmpty() == true) goto L14;
        r1 = new ArrayList(r0.size());     // Catch: Throwable -> L17 RuntimeException -> L19
        Iterator<AoiBoard> r2 = r0.iterator();     // Catch: Throwable -> L17 RuntimeException -> L19
    L10:
        if (r2.hasNext() == false) goto L15;
        AoiBoard r3 = (AoiBoard) ZeusTransformUtils.preCheckCast(r2.next(), AoiBoard.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17 RuntimeException -> L19
        if (r3 == null) goto L10;
        r1.add(a(r3));     // Catch: Throwable -> L17 RuntimeException -> L19
    L17:
        th = move-exception;
        throw th;
    L19:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-AoiManager", "queryAllAoiBoards failed, userId=" + this.g, e);     // Catch: Throwable -> L17
        return Collections.emptyList();
    }

    public final void g(String r10) {
        List<AoiBoard> r0 = g();
        if (r0.isEmpty() == false) goto L5;
        return;
    L5:
        float r1 = Float.MAX_VALUE;
        Iterator<AoiBoard> r2 = r0.iterator();
        AoiBoard r3 = null;
        AoiBoard r4 = null;
    L7:
        if (r2.hasNext() == false) goto L21;
        AoiBoard r5 = (AoiBoard) ZeusTransformUtils.preCheckCast(r2.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L7;
        if (r5.getPoiId().isEmpty() == true) goto L7;
        if (r5.getAoiBoard().isEmpty() == true) goto L7;
        f r6 = (f) ZeusTransformUtils.preCheckCast(this.p.get(r5.getPoiId()), f.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L7;
        float r7 = r6.f7201a;
        if (r7 >= r1) goto L7;
        r4 = r5;
        r1 = r7;
        goto L7
    L21:
        if (r4 != null) goto L37;
        long r8 = Long.MAX_VALUE;
        Iterator<AoiBoard> r9 = r0.iterator();
    L25:
        if (r9.hasNext() == false) goto L36;
        AoiBoard r11 = (AoiBoard) ZeusTransformUtils.preCheckCast(r9.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r11 == null) goto L25;
        if (r11.getPoiId().isEmpty() == true) goto L25;
        if (r11.getAoiBoard().isEmpty() == true) goto L25;
        long r12 = a(r11.getConfidence());
        if (r12 >= r8) goto L25;
        r3 = r11;
        r8 = r12;
        goto L25
    L36:
        r4 = r3;
    L37:
        if (r4 != null) goto L40;
        com.obric.cae.log.a.d("StarLocation-AoiManager", "skip location request: reason=" + r10 + ", no controlling aoi");
        f("skip location request userId=" + this.g + ", reason=" + r10 + ", no controlling aoi");
        return;
    L40:
        b(a(r4.getConfidence()), r10, r4);
    }

    public final void g(List<AoiBoard> r6) {
        Iterator r7 = ((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r7.hasNext() == false) goto L16;
        AoiBoard r0 = (AoiBoard) ZeusTransformUtils.preCheckCast(r7.next(), AoiBoard.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L4;
        if (r0.getPoiId().isEmpty() == true) goto L4;
        if (r0.getAoiBoard().isEmpty() == true) goto L4;
        if (r0.getConfidence() == AoiBoard.Confidence.MIN) goto L4;
        ((f) ZeusTransformUtils.preCheckCast(this.p.computeIfAbsent(r0.getPoiId(), $$Lambda$S2C95rHdsZZbtdhcYc8MG1yBFT0.INSTANCE), f.class, "com.obric.memorydata.plugin")).f7202b++;
        r0.getCurState();
        goto L4
    }

    public final void h(String r12) {
        AoiBoard r6 = e(r12);
        if (r6 != null) goto L5;
    L30:
        com.obric.cae.log.a.d("StarLocation-AoiManager", "[" + this.g + "] skip timeout retry, poiId=" + r12);
        return;
    L5:
        if (r6.getPoiId().isEmpty() == true) goto L30;
        if (r6.getAoiBoard().isEmpty() == true) goto L30;
        f r9 = (f) ZeusTransformUtils.preCheckCast(this.p.computeIfAbsent(r12, $$Lambda$2ccEqJx1u9yiFe5RRLs5CMRHhNE.INSTANCE), f.class, "com.obric.memorydata.plugin");
        AoiBoard.Confidence r0 = r9.c;
        if (r0 != null) goto L12;
        r0 = r6.getConfidence();
    L12:
        AoiBoard.Confidence r10 = r0;
        a(r6, r9, r10, r6.getCurState(), LocationMonitorConst.TIMEOUT);
        AoiBoard.Confidence r1 = r9.d;
        if (r1 != null) goto L16;
    L17:
        r1 = r10;
    L19:
        if (r9.d == null) goto L22;
        if (r1 == r10) goto L22;
        AoiBoard.ConfidenceSource r2 = AoiBoard.ConfidenceSource.RETRY;
    L24:
        if (r6.getConfidence() == r1) goto L26;
    L27:
        r6.setConfidence(r1);
        r6.setConfidenceSource(r2);
        com.obric.cae.log.a.d("StarLocation-AoiManager", "[" + this.g + "] timeout retry update, poiId=" + r12 + ", confidence=" + r1 + ", confidenceSource=" + r2.name() + ", saved=" + c(r6));
    L28:
        b(a(r6.getConfidence()), "timeout_retry", r6);
        return;
    L26:
        if (r6.getConfidenceSource() == r2) goto L28;
    L22:
        r2 = AoiBoard.ConfidenceSource.DISTANCE;
        goto L24
    L16:
        if (r10.ordinal() > r1.ordinal()) goto L19;
        goto L17
    }

    public synchronized boolean h() {
        monitor-enter(this);
        Iterator<AoiBoard> r0 = g().iterator();     // Catch: Throwable -> L14
    L5:
        if (r0.hasNext() == false) goto L13;
        AoiBoard r1 = (AoiBoard) ZeusTransformUtils.preCheckCast(r0.next(), AoiBoard.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L14
        if (r1 == null) goto L5;
        if (AoiBoard.State.UNKNOWN != r1.getCurState()) goto L5;
        boolean r2 = true;
    L11:
        monitor-exit(this);
        return r2;
    L13:
        r2 = false;
    L14:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean h(List r6) {
        monitor-enter(this);
        List<AoiBoard> r7 = a((List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L18
        if (r7.isEmpty() == false) goto L22;
        monitor-exit(this);
        return false;
    L22:
        boolean r1 = this.h.a(r7);     // Catch: RuntimeException -> L14 Throwable -> L18
        if (r1 == false) goto L11;
        f(r7);     // Catch: RuntimeException -> L14 Throwable -> L18
    L11:
        com.obric.cae.log.a.d("StarLocation-AoiManager", "save calculated aoi boards, reason=direct_update, count=" + r7.size() + ", success=" + r1);     // Catch: RuntimeException -> L14 Throwable -> L18
        monitor-exit(this);
        return r1;
    L14:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-AoiManager", "saveCalculatedAoiBoards failed, reason=direct_update", e);     // Catch: Throwable -> L18
        return false;
    L18:
        th = move-exception;
        throw th;
    }

    public synchronized void i() {
        monitor-enter(this);
        this.s.set(false);     // Catch: Throwable -> L29
        List<AoiBoard> r3 = this.h.a();     // Catch: Throwable -> L20 RuntimeException -> L22
        this.v.clear();     // Catch: Throwable -> L20 RuntimeException -> L22
        f(r3);     // Catch: Throwable -> L20 RuntimeException -> L22
        this.p.clear();     // Catch: Throwable -> L20 RuntimeException -> L22
        Object r4 = this.u;     // Catch: Throwable -> L20 RuntimeException -> L22
        monitor-enter(r4);     // Catch: Throwable -> L20 RuntimeException -> L22
        ScheduledFuture<?> r5 = this.w;     // Catch: Throwable -> L17
        if (r5 == null) goto L10;
        r5.cancel(false);     // Catch: Throwable -> L17
        this.w = null;     // Catch: Throwable -> L17
    L10:
        ScheduledFuture<?> r6 = this.x;     // Catch: Throwable -> L17
        if (r6 == null) goto L13;
        r6.cancel(false);     // Catch: Throwable -> L17
        this.x = null;     // Catch: Throwable -> L17
    L13:
        this.y = false;     // Catch: Throwable -> L17
        this.A++;     // Catch: Throwable -> L17
        this.B = "";     // Catch: Throwable -> L17
        this.z = 0;     // Catch: Throwable -> L17
        this.C = "";     // Catch: Throwable -> L17
        this.D = null;     // Catch: Throwable -> L17
        this.E = Float.MAX_VALUE;     // Catch: Throwable -> L17
        monitor-exit(r4);     // Catch: Throwable -> L17
        this.I = true;     // Catch: Throwable -> L20 RuntimeException -> L22
        f("reload aoi boards after city switch userId=" + this.g + ", count=" + r3.size() + ", cacheSize=" + this.v.size());     // Catch: Throwable -> L20 RuntimeException -> L22
    L24:
        this.s.set(true);     // Catch: Throwable -> L29
        monitor-exit(this);
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20 RuntimeException -> L22
    L22:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-AoiManager", "failed", e);     // Catch: Throwable -> L20
        this.I = true;     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        this.s.set(true);     // Catch: Throwable -> L29
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;
    }

    public final void i(String r4) {
        Object r0 = this.u;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.y == true) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L8:
        this.y = false;     // Catch: Throwable -> L14
        ScheduledFuture<?> r2 = this.x;     // Catch: Throwable -> L14
        if (r2 == null) goto L11;
        r2.cancel(false);     // Catch: Throwable -> L14
        this.x = null;     // Catch: Throwable -> L14
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L14
        com.obric.cae.log.a.b("StarLocation-AoiManager", "[" + this.g + "] reason= " + r4);
    }

    public List<StarGeofence> j() {
        List<StarGeofence> r9 = com.obric.cae.location.database.c.a(this.f, 0).a(-1, StarGeofence.GeoType.TRAFFIC);     // Catch: Throwable -> L27
        ArrayList r3 = new ArrayList();     // Catch: Throwable -> L27
        Iterator<StarGeofence> r10 = r9.iterator();     // Catch: Throwable -> L27
    L5:
        if (r10.hasNext() == false) goto L25;
        StarGeofence r5 = (StarGeofence) ZeusTransformUtils.preCheckCast(r10.next(), StarGeofence.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (r5 == null) goto L19;
        String r6 = r5.getGeofenceId();     // Catch: Throwable -> L27
        if (r5.getGeoType() != StarGeofence.GeoType.TRAFFIC) goto L19;
        if (r6 == null) goto L19;
        if (r6.startsWith("airport_") == false) goto L17;
        AoiBoard.Type r7 = AoiBoard.Type.AIRPORT;     // Catch: Throwable -> L27
    L20:
        if (r7 == null) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == false) goto L5;
        r3.add(r5);     // Catch: Throwable -> L27
        goto L5
    L22:
        r8 = false;
        goto L23
    L17:
        if (r6.startsWith("train_station_") == false) goto L19;
        r7 = AoiBoard.Type.TRAIN_STATION;     // Catch: Throwable -> L27
    L19:
        r7 = null;
        goto L20
    L25:
        com.obric.cae.log.a.b("StarLocation-AoiManager", "traffic size=" + r3.size() + ", queriedUserId=-1");     // Catch: Throwable -> L27
        return r3;
    L27:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-AoiManager", "list traffic geofences failed", th);
        return null;
    }

    public final synchronized void k() {
        monitor-enter(this);
        this.s.set(false);     // Catch: Throwable -> L26
        List<AoiBoard> r2 = this.h.a();     // Catch: Throwable -> L16 RuntimeException -> L18
        this.v.clear();     // Catch: Throwable -> L16 RuntimeException -> L18
        f(r2);     // Catch: Throwable -> L16 RuntimeException -> L18
        f("init preload aoi boards userId=" + this.g + ", count=" + r2.size() + ", cacheSize=" + this.v.size());     // Catch: Throwable -> L16 RuntimeException -> L18
        Iterator<AoiBoard> r0 = r2.iterator();     // Catch: Throwable -> L16 RuntimeException -> L18
    L7:
        if (r0.hasNext() == false) goto L12;
        AoiBoard r3 = (AoiBoard) ZeusTransformUtils.preCheckCast(r0.next(), AoiBoard.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16 RuntimeException -> L18
        if (r3 == null) goto L7;
        f("[" + this.g + "] recover " + r3);     // Catch: Throwable -> L16 RuntimeException -> L18
        goto L7
    L12:
        this.I = true;     // Catch: Throwable -> L16 RuntimeException -> L18
        this.s.set(true);     // Catch: Throwable -> L26
        String r1 = "init preload aoi boards finished userId=" + this.g + ", cacheSize=" + this.v.size();     // Catch: Throwable -> L26
    L14:
        f(r1);     // Catch: Throwable -> L26
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        this.s.set(true);     // Catch: Throwable -> L26
        f("init preload aoi boards finished userId=" + this.g + ", cacheSize=" + this.v.size());     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L18:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-AoiManager", "failed", e);     // Catch: Throwable -> L16
        this.s.set(true);     // Catch: Throwable -> L26
        r1 = "init preload aoi boards finished userId=" + this.g + ", cacheSize=" + this.v.size();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;
    }

    public final File l() {
        if (this.g != 0) goto L5;
        String r1 = "star_poi.txt";
    L6:
        File r2 = new File(com.obric.cae.location.util.d.a().b(this.f), r1);
        r2.delete();
        r2.createNewFile();     // Catch: IOException -> L9
    L11:
        com.obric.cae.log.a.c("StarLocation-AoiManager", "initPoiLogFile, file: " + r2);
        com.obric.cae.log.a.a("poi", this.g, r2);
        return r2;
    L9:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-AoiManager", "initPoiLogFile failed", e);
        goto L11
    L5:
        r1 = "star_poi_" + this.g + ".txt";
        goto L6
    }
}
