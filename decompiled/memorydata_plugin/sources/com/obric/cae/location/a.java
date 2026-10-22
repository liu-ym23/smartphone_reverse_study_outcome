package com.obric.cae.location;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.obric.cae.libs.location.CoordinateTransformUtils;
import com.obric.cae.location.geofence.StarGeoCallback;
import com.obric.cae.location.geofence.StarGeofenceManager;
import com.obric.cae.location.util.d;
import com.obric.cae.userAware.InnerAwareInfoCallback;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f7022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f7023b;
    public final ArrayDeque<C0349a> c;
    public final Object d;
    public final Object e;
    public final ArrayDeque<b> f;
    public final ExecutorService g;
    public final AtomicReference<Location> h;
    public final AtomicReference<Location> i;
    public final AtomicBoolean j;
    public final AtomicBoolean k;
    public final AtomicLong l;
    public boolean m;
    public volatile File n;
    public volatile Context o;

    /* JADX INFO: renamed from: com.obric.cae.location.a$a, reason: collision with other inner class name */
    public static class C0349a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f7024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f7025b;
        public long c;
        public double d;
        public double e;
        public float f;
        public boolean g;
        public CoordinateTransformUtils.CoordinateSystem h;
        public int i;
        public boolean j;
        public boolean k;
        public Bundle l;
        public long m;
        public long n;
        public boolean o;
        public int p;

        public C0349a() {
            this.f7024a = 0;
            this.f7025b = "";
            this.c = 0;
            this.d = 0.0d;
            this.e = 0.0d;
            this.f = 0.0f;
            this.g = true;
            this.h = CoordinateTransformUtils.CoordinateSystem.WGS84;
            this.i = 0;
            this.j = false;
            this.k = false;
            this.l = new Bundle();
            this.m = 0;
            this.n = 0;
            this.o = false;
            this.p = 0;
        }

        public C0349a(C0349a r6) {
            this.f7024a = 0;
            this.f7025b = "";
            this.c = 0;
            this.d = 0.0d;
            this.e = 0.0d;
            this.f = 0.0f;
            this.g = true;
            this.h = CoordinateTransformUtils.CoordinateSystem.WGS84;
            this.i = 0;
            this.j = false;
            this.k = false;
            this.l = new Bundle();
            this.m = 0;
            this.n = 0;
            this.o = false;
            this.p = 0;
            this.f7024a = r6.f7024a;
            this.f7025b = r6.f7025b;
            this.c = r6.c;
            this.d = r6.d;
            this.e = r6.e;
            this.f = r6.f;
            this.g = r6.g;
            this.h = r6.h;
            this.i = r6.i;
            this.j = r6.j;
            this.k = r6.k;
            this.l = new Bundle(r6.l);
            this.m = r6.m;
            this.n = r6.n;
            this.o = r6.o;
            this.p = r6.p;
        }

        public C0349a a() {
            return new C0349a(this);
        }

        public C0349a a(double r1) {
            this.d = r1;
            return this;
        }

        public C0349a a(float r1) {
            this.f = r1;
            return this;
        }

        public C0349a a(int r1) {
            this.f7024a = r1;
            return this;
        }

        public C0349a a(long r1) {
            this.c = r1;
            return this;
        }

        public C0349a a(Bundle r2) {
            if (r2 != null) goto L4;
            Bundle r3 = new Bundle();
        L5:
            this.l = r3;
            return this;
        L4:
            r3 = new Bundle(r2);
            goto L5
        }

        public C0349a a(CoordinateTransformUtils.CoordinateSystem r1) {
            if (r1 != null) goto L4;
            r1 = CoordinateTransformUtils.CoordinateSystem.WGS84;
        L4:
            this.h = r1;
            return this;
        }

        public C0349a a(String r1) {
            if (r1 != null) goto L4;
            r1 = "";
        L4:
            this.f7025b = r1;
            return this;
        }

        public C0349a a(boolean r1) {
            this.g = r1;
            return this;
        }

        public int b() {
            return this.f7024a;
        }

        public C0349a b(double r1) {
            this.e = r1;
            return this;
        }

        public C0349a b(int r1) {
            this.i = r1;
            return this;
        }

        public C0349a b(long r1) {
            this.m = r1;
            return this;
        }

        public C0349a b(boolean r1) {
            this.j = r1;
            return this;
        }

        public C0349a c(int r1) {
            this.p = r1;
            return this;
        }

        public C0349a c(long r1) {
            this.n = r1;
            return this;
        }

        public C0349a c(boolean r1) {
            this.k = r1;
            return this;
        }

        public String c() {
            return this.f7025b;
        }

        public long d() {
            return this.c;
        }

        public C0349a d(boolean r1) {
            this.o = r1;
            return this;
        }

        public double e() {
            return this.d;
        }

        public boolean equals(Object r5) {
            if (ZeusTransformUtils.instanceOf(r5, C0349a.class) == false) goto L13;
            String r1 = c();
            C0349a r6 = (C0349a) ZeusTransformUtils.preCheckCast(r5, C0349a.class, "com.obric.memorydata.plugin");
            if (r1.equals(r6.c()) == false) goto L13;
            if (Double.compare(r6.e(), e()) != 0) goto L13;
            if (Double.compare(r6.f(), f()) != 0) goto L13;
            if (Float.compare(r6.g(), g()) != 0) goto L13;
            return true;
        L13:
            return false;
        }

        public double f() {
            return this.e;
        }

        public float g() {
            return this.f;
        }

        public boolean h() {
            return this.g;
        }

        public CoordinateTransformUtils.CoordinateSystem i() {
            return this.h;
        }

        public int j() {
            return this.i;
        }

        public boolean k() {
            return this.j;
        }

        public boolean l() {
            return this.k;
        }

        public Bundle m() {
            return new Bundle(this.l);
        }

        public long n() {
            return this.m;
        }

        public long o() {
            return this.n;
        }

        public boolean p() {
            return this.o;
        }

        public int q() {
            return this.p;
        }

        public String r() {
            JSONObject r0 = new JSONObject();
            r0.put("version", 2);
            r0.put(AILabCheckPermissionTask.KEY_SOURCE, this.f7024a);
            r0.put("provider", this.f7025b);
            r0.put("latitude", this.d);
            r0.put("longitude", this.e);
            r0.put("radius", this.f);
            r0.put("applied", this.g);
            r0.put("coordSys", this.h.name());
            r0.put("confidence", this.i);
            r0.put("updateTs", this.c);
            r0.put("elapsedRealtimeNanos", this.m);
            r0.put("locationTime", this.n);
            r0.put("simReady", this.j);
            r0.put("wifiConnected", this.k);
            r0.put("mock", this.o);
            r0.put("userId", this.p);
            Bundle r9 = this.l;
            JSONArray r1 = new JSONArray();
            Iterator<String> r2 = r9.keySet().iterator();
        L4:
            if (r2.hasNext() == false) goto L31;
            String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");
            JSONObject r4 = new JSONObject();
            Object r6 = r9.get(r3);
            r4.put("key", r3);
            if (r6 != null) goto L10;
            r4.put("type", "null");
            Object r5 = JSONObject.NULL;
        L8:
            r4.put(EventBody.KEY_VALUE, r5);
        L30:
            r1.put(r4);
            goto L4
        L10:
            if (ZeusTransformUtils.instanceOf(r6, Integer.class) == false) goto L15;
            String r7 = "int";
        L12:
            r4.put("type", r7);
        L13:
            r4.put(EventBody.KEY_VALUE, r6);
            goto L30
        L15:
            if (ZeusTransformUtils.instanceOf(r6, Long.class) == false) goto L18;
            r7 = "long";
            goto L12
        L18:
            if (ZeusTransformUtils.instanceOf(r6, Float.class) == false) goto L21;
            r4.put("type", TypedValues.Custom.S_FLOAT);
            r4.put(EventBody.KEY_VALUE, ((Float) ZeusTransformUtils.preCheckCast(r6, Float.class, "com.obric.memorydata.plugin")).doubleValue());
            goto L30
        L21:
            if (ZeusTransformUtils.instanceOf(r6, Double.class) == false) goto L24;
            r7 = "double";
            goto L12
        L24:
            if (ZeusTransformUtils.instanceOf(r6, Boolean.class) == false) goto L26;
            r7 = TypedValues.Custom.S_BOOLEAN;
            goto L12
        L26:
            boolean r8 = ZeusTransformUtils.instanceOf(r6, String.class);
            r4.put("type", TypedValues.Custom.S_STRING);
            if (r8 == true) goto L13;
            r5 = String.valueOf(r6);
            goto L8
        L31:
            r0.put(WsConstants.KEY_EXTRA, r1);
            return r0.toString();
        }

        public String toString() {
            return "LocationSource[source=" + this.f7024a + ", provider=" + this.f7025b + ", latitude=" + this.d + ", longitude=" + this.e + ", radius=" + this.f + ", applied=" + this.g + ", coordSys=" + this.h + ", confidence=" + this.i + ", updateTs=" + this.c + ", elapsedRealtimeNanos=" + this.m + ", locationTime=" + this.n + ", simReady=" + this.j + ", wifiConnected=" + this.k + ", mock=" + this.o + ", userId=" + this.p + ", extra=" + this.l + ']';
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0349a f7026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CountDownLatch f7027b;

        public b(C0349a r1, CountDownLatch r2) {
            this.f7026a = r1;
            this.f7027b = r2;
        }

        public static b a(C0349a r2) {
            return new b(r2, null);
        }

        public static /* synthetic */ CountDownLatch a(b r0) {
            return r0.f7027b;
        }
    }

    public a() {
        this.f7023b = new ConcurrentHashMap();
        this.c = new ArrayDeque();
        this.d = new Object();
        this.e = new Object();
        this.f = new ArrayDeque();
        this.g = Executors.newSingleThreadExecutor($$Lambda$urfgatlP8t_jFlw46qZKNpkFaXk.INSTANCE);
        this.h = new AtomicReference(null);
        this.i = new AtomicReference(null);
        this.j = new AtomicBoolean(false);
        this.k = new AtomicBoolean(false);
        this.l = new AtomicLong(0);
        this.m = false;
    }

    public static int a(Location r4) {
        float r5 = r4.getAccuracy();
        if (r5 > 0.0f) goto L5;
        return 0;
    L5:
        boolean r1 = d.a().m();
        if (r5 <= 0.0f) goto L13;
        if (r5 > 30.0f) goto L13;
        if (r1 == false) goto L22;
        return 4;
    L22:
        return 3;
    L13:
        if (r5 > 100.0f) goto L19;
        if (r1 == true) goto L23;
        return 1;
    L23:
        return 3;
    L19:
        if (r5 > 200.0f) goto L21;
        return r1 ? 1 : 0;
    L21:
        return 0;
    }

    public static synchronized a a() {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f7022a != null) goto L7;
        f7022a = new a();     // Catch: Throwable -> L10
    L7:
        a r1 = f7022a;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r1;
    }

    public static /* synthetic */ Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "StarLocationUpdateQueue");
    }

    private void a(int r5, int r6) {
        Thread.sleep(3000);     // Catch: InterruptedException -> L5
    L8:
        if (this.j.get() == true) goto L10;
    L13:
        Location r1 = (Location) ZeusTransformUtils.preCheckCast(this.h.get(), Location.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L17;
        com.obric.cae.log.a.d("StarLocation-manager", "skip null cached nlp location");
        return;
    L17:
        com.obric.cae.log.a.b("StarLocation-manager", "network location cache dispatch, userId=" + r5);
        a(r1, r6, true, r5);
        return;
    L10:
        if (this.k.get() == false) goto L13;
        com.obric.cae.log.a.d("StarLocation-manager", "skip cached nlp location while gnss on");
        return;
    L5:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-manager", "sleep interrupted", e);
        goto L8
    }

    public static /* synthetic */ void a(b r1, InnerAwareInfoCallback r2) {
        r2.onLocationSourceChanged(new C0349a(r1.f7026a));
    }

    public static /* synthetic */ void lambda$uIHw1kVY95oDKVe9_98iReHn3XY(a r0, int r1, int r2) {
        r0.a(r1, r2);
    }

    public int a(int r2) {
        if (r2 != 3) goto L5;
        return 1;
    L5:
        if (r2 != 4) goto L7;
        return 3;
    L7:
        if (r2 == 5) goto L10;
        return 0;
    L10:
        return 4;
    }

    public C0349a a(long r14) {
        if (r14 >= 0) goto L5;
        return null;
    L5:
        long r4 = SystemClock.elapsedRealtimeNanos();
        long r15 = TimeUnit.MILLISECONDS.toNanos(r14);
        Object r2 = this.d;
        monitor-enter(r2);
        Iterator<C0349a> r6 = this.c.descendingIterator();     // Catch: Throwable -> L31
    L9:
        if (r6.hasNext() == false) goto L19;
        C0349a r7 = (C0349a) ZeusTransformUtils.preCheckCast(r6.next(), C0349a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        long r8 = r7.n();     // Catch: Throwable -> L31
        long r10 = r4 - r8;     // Catch: Throwable -> L31
        if (r7.h() == false) goto L9;
        if (r8 <= 0) goto L9;
        if (r10 < 0) goto L9;
        if (r10 > r15) goto L9;
        C0349a r16 = new C0349a(r7);     // Catch: Throwable -> L31
    L20:
        monitor-exit(r2);     // Catch: Throwable -> L31
        if (r16 != null) goto L23;
        return null;
    L23:
        r16.a(System.currentTimeMillis());
        File r13 = this.n;
        if (r13 != null) goto L34;
        com.obric.cae.log.a.d("StarLocation-manager", "skipped, log file not initialized");
    L30:
        return r16;
    L34:
        com.obric.cae.log.a.c("StarLocation-manager", r16.r(), r13);     // Catch: Throwable -> L28
    L28:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-manager", "failed", e);
        goto L30
    L19:
        r16 = null;
    L31:
        th = move-exception;
        throw th;
    }

    public synchronized void a(Context r3) {
        monitor-enter(this);
        b((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void a(Location r5, int r6, int r7) {
        Context r4 = this.o;
        if (r4 != null) goto L7;
        com.obric.cae.log.a.c("StarLocation-manager", "dispatchGeofenceEventToManagers skipped, context is null");
        return;
    L7:
        if (r6 >= 0) goto L10;
        r6 = 0;
    L10:
        StarGeoCallback.getInstance(r4, r6).calculateGeofenceEvent(r5, r6, r7);
        if (r6 == 0) goto L14;
        com.obric.cae.log.a.d("StarLocation-manager", "include system geofences, currentUserId=" + r6);
        StarGeoCallback.getInstance(r4, 0).calculateGeofenceEvent(r5, r6, r7);
        return;
    }

    public final void a(b r11) {
        Object r0 = this.e;
        monitor-enter(r0);
        boolean r1 = false;
        int r3 = 0;
        boolean r4 = false;
    L37:
    L27:
        th = move-exception;
        throw th;
    L6:
        if (this.f.size() < 300) goto L22;
        if (b.a(r11) == null) goto L12;
        this.e.wait();     // Catch: InterruptedException -> L11 Throwable -> L27
    L11:
        r4 = true;
        goto L37
    L12:
        b r5 = null;
        Iterator<b> r6 = this.f.iterator();     // Catch: Throwable -> L27
    L15:
        if (r6.hasNext() == false) goto L19;
        b r7 = (b) ZeusTransformUtils.preCheckCast(r6.next(), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L27
        if (b.a(r7) != null) goto L15;
        r5 = r7;
    L19:
        if (r5 == null) goto L20;
        this.f.remove(r5);     // Catch: Throwable -> L27
        r3 = r3 + 1;     // Catch: Throwable -> L27
        this.l.incrementAndGet();     // Catch: Throwable -> L27
        goto L37
    L20:
        r3 = r3 + 1;     // Catch: Throwable -> L27
        this.l.incrementAndGet();     // Catch: Throwable -> L27
    L23:
        if (r1 == false) goto L29;
        this.f.addLast(r11);     // Catch: Throwable -> L27
        if (this.m == true) goto L29;
        this.m = true;     // Catch: Throwable -> L27
        this.g.execute(new $$Lambda$K9Y1QKTbGujAqd1D2BMdvWrhK3c(this));     // Catch: Throwable -> L27
    L29:
        monitor-exit(r0);     // Catch: Throwable -> L27
        if (r4 == false) goto L32;
        Thread.currentThread().interrupt();
    L32:
        if (r3 <= 0) goto L51;
        com.obric.cae.log.a.g("StarLocation-manager", "location update queue overflow, droppedTaskCount=" + r3);
        return;
    L51:
        return;
    L22:
        r1 = true;
        goto L23
    }

    public void a(boolean r2) {
        boolean r0 = this.j.getAndSet(r2);
        if (r2 == false) goto L5;
        if (r0 == false) goto L5;
        return;
    L5:
        this.k.set(false);
    }

    public final boolean a(final int r3, Location r4, final int r5) {
        if (r4.equals(this.h.get()) == false) goto L6;
        com.obric.cae.log.a.d("StarLocation-manager", "same nlp location");
        return a(r4, r3, false, r5);
    L6:
        Location r0 = new Location(r4);
        this.h.set(r0);
        d.a().r().submit(new $$Lambda$a$uIHw1kVY95oDKVe9_98iReHn3XY(this, r5, r3));
        return true;
    }

    public final boolean a(Location r5, int r6, boolean r7, int r8) {
        if (r5 != null) goto L5;
        C0349a r9 = null;
    L30:
        if (r9 != null) goto L32;
        return false;
    L32:
        d r0 = d.a();
        r9.b(r0.u()).c(r0.f()).d(r5.isMock()).a(r7);
        if (r7 == true) goto L43;
        C0349a r10 = (C0349a) ZeusTransformUtils.preCheckCast(this.f7023b.get(r9.c()), C0349a.class, "com.obric.memorydata.plugin");
        if (r10 != null) goto L37;
    L40:
        a(b.a(r9));
        return false;
    L37:
        if (r10.equals(r9) == false) goto L40;
        return a(r9);
    L43:
        return d(r9);
    L5:
        if (r5.getExtras() != null) goto L7;
        Bundle r1 = new Bundle();
    L9:
        if (r5.hasAltitude() == false) goto L12;
        r1.putDouble("ALTITUDE", r5.getAltitude());
        r1.putBoolean("HAS_ALTITUDE", true);
    L12:
        if (r5.hasVerticalAccuracy() == false) goto L15;
        r1.putFloat("VERTICAL_ACCURACY_METERS", r5.getVerticalAccuracyMeters());
    L15:
        if (r5.hasSpeed() == false) goto L18;
        r1.putFloat("SPEED", r5.getSpeed());
    L18:
        if (r5.hasBearing() == false) goto L21;
        r1.putFloat("BEARING", r5.getBearing());
    L21:
        if (r5.hasSpeedAccuracy() == false) goto L24;
        r1.putFloat("SPEED_ACCURACY_METERS_PER_SECOND", r5.getSpeedAccuracyMetersPerSecond());
    L24:
        if (r5.hasBearingAccuracy() == false) goto L26;
        r1.putFloat("BEARING_ACCURACY_DEGREES", r5.getBearingAccuracyDegrees());
    L26:
        r9 = new C0349a().a(r6).a(r5.getProvider()).a(System.currentTimeMillis()).b(r5.getElapsedRealtimeNanos()).c(r5.getTime()).a(r5.getLatitude()).b(r5.getLongitude()).a(CoordinateTransformUtils.CoordinateSystem.WGS84).b(c(r5)).c(r8).a(r1);
        if (r5.hasAccuracy() == false) goto L30;
        r9.a(r5.getAccuracy());
        goto L30
    L7:
        r1 = new Bundle(r5.getExtras());
        goto L9
    }

    public final boolean a(C0349a r6) {
        if (this.o != null) goto L5;
        com.obric.cae.log.a.d("StarLocation-manager", "skipped, context is null");
    L19:
        C0349a r0 = new C0349a(r6);
        r0.a(false);
        a(b.a(r0));
        return false;
    L5:
        boolean r1 = StarGeofenceManager.getInstance(this.o, r6.q()).hasUnknownStateGeofence(r6.q());
        boolean r3 = com.obric.cae.location.geosdk.poi.a.a(this.o, r6.q()).h();
        if (r1 == true) goto L10;
        if (r3 == true) goto L10;
        boolean r2 = false;
    L11:
        if (r2 == false) goto L13;
    L15:
        if (r2 == false) goto L18;
        C0349a r4 = new C0349a(r6);
        r4.a(true);
        a(b.a(r4));
        return true;
    L18:
        com.obric.cae.log.a.b("StarLocation-manager", "ignore same location");
        goto L19
    L13:
        if (StarGeoCallback.hasPendingReverseEvent(r6.q()) == false) goto L15;
        com.obric.cae.log.a.d("StarLocation-manager", "apply same location to confirm pending reverse geofence event");
        r2 = true;
    L10:
        r2 = true;
        goto L11
    }

    public int b(int r1) {
        if (r1 < 3) goto L5;
        return 1;
    L5:
        return 0;
    }

    public Location b(Location r5) {
        Location r0 = new Location(r5);
        if (r5.getExtras() == null) goto L5;
        Bundle r1 = new Bundle(r5.getExtras());
    L6:
        int r4 = c(r5);
        if ("gps".equals(r5.getProvider()) == false) goto L24;
        float r6 = r5.getAccuracy();
        if (r6 > 0.0f) goto L12;
        r4 = 0;
    L26:
        r1.putInt("location_confidence", r4);
        r0.setExtras(r1);
        return r0;
    L12:
        if (r6 <= 0.0f) goto L17;
        if (r6 > 20.0f) goto L17;
        r4 = 5;
    L17:
        if (r6 > 50.0f) goto L20;
        r4 = 4;
        goto L26
    L20:
        if (r6 > 70.0f) goto L22;
        r4 = 3;
        goto L26
    L22:
        r4 = 1;
        goto L26
    L24:
        if ("network".equals(r5.getProvider()) == false) goto L26;
        r4 = a(r5);
        goto L26
    L5:
        r1 = new Bundle();
        goto L6
    }

    public final C0349a b(C0349a r11) {
        C0349a r0 = new C0349a(r11);
        if (r0.b() != 6) goto L5;
    L8:
        r0.a(false);
    L9:
        Object r12 = this.d;
        monitor-enter(r12);
        long r1 = r0.n();     // Catch: Throwable -> L51
        if (r1 <= 0) goto L24;
        Iterator<C0349a> r5 = this.c.descendingIterator();     // Catch: Throwable -> L51
    L15:
        if (r5.hasNext() == false) goto L24;
        long r7 = ((C0349a) ZeusTransformUtils.preCheckCast(r5.next(), C0349a.class, "com.obric.memorydata.plugin")).n();     // Catch: Throwable -> L51
        if (r7 <= 0) goto L15;
        if (r1 >= r7) goto L24;
        com.obric.cae.log.a.d("StarLocation-manager", "drop elapsed realtime rollback location source, source=" + r0.b() + ", provider=" + r0.c() + ", elapsedRealtimeNanos=" + r1 + ", latestElapsedRealtimeNanos=" + r7);     // Catch: Throwable -> L51
        monitor-exit(r12);     // Catch: Throwable -> L51
        return null;
    L24:
        long r2 = r0.o();     // Catch: Throwable -> L51
        if (r2 <= 0) goto L45;
        Iterator<C0349a> r6 = this.c.descendingIterator();     // Catch: Throwable -> L51
    L28:
        if (r6.hasNext() == false) goto L37;
        long r8 = ((C0349a) ZeusTransformUtils.preCheckCast(r6.next(), C0349a.class, "com.obric.memorydata.plugin")).o();     // Catch: Throwable -> L51
        if (r8 <= 0) goto L28;
        if (r2 >= r8) goto L37;
        com.obric.cae.log.a.d("StarLocation-manager", "drop location time rollback location source, source=" + r0.b() + ", provider=" + r0.c() + ", locationTime=" + r2 + ", latestLocationTime=" + r8);     // Catch: Throwable -> L51
        monitor-exit(r12);     // Catch: Throwable -> L51
        return null;
    L37:
        Iterator<C0349a> r3 = this.c.iterator();     // Catch: Throwable -> L51
    L39:
        if (r3.hasNext() == false) goto L45;
        if (((C0349a) ZeusTransformUtils.preCheckCast(r3.next(), C0349a.class, "com.obric.memorydata.plugin")).o() != r2) goto L39;
        com.obric.cae.log.a.d("StarLocation-manager", "drop duplicate location source, source=" + r0.b() + ", provider=" + r0.c() + ", locationTime=" + r2);     // Catch: Throwable -> L51
        monitor-exit(r12);     // Catch: Throwable -> L51
        return null;
    L45:
        this.f7023b.put(r0.c(), r0);     // Catch: Throwable -> L51
        this.c.addLast(r0);     // Catch: Throwable -> L51
    L47:
        if (this.c.size() <= 100) goto L49;
        this.c.removeFirst();     // Catch: Throwable -> L51
        goto L47
    L49:
        monitor-exit(r12);     // Catch: Throwable -> L51
        return r0;
    L51:
        th = move-exception;
        throw th;
    L5:
        if (d.a().q() == false) goto L9;
        if ("network".equals(r0.c()) == false) goto L9;
        goto L8
    }

    public final void b() {
    L2:
        Object r0 = this.e;
        monitor-enter(r0);
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.f.pollFirst(), b.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L26
        if (r1 == null) goto L6;
        this.e.notifyAll();     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
        b(r1);     // Catch: Throwable -> L15 RuntimeException -> L17
    L12:
        CountDownLatch r2 = r1.f7027b;
        if (r2 == null) goto L2;
    L14:
        r2.countDown();
    L15:
        th = move-exception;
        CountDownLatch r3 = r1.f7027b;
        if (r3 == null) goto L25;
        r3.countDown();
    L25:
        throw th;
    L17:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-manager", "process location update task failed", e);     // Catch: Throwable -> L15
        if (r1.f7027b == null) goto L2;
        r2 = r1.f7027b;
        goto L14
    L6:
        this.m = false;     // Catch: Throwable -> L26
        this.e.notifyAll();     // Catch: Throwable -> L26
        monitor-exit(r0);     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public synchronized void b(Context r5) {
        monitor-enter(this);
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r6 != null) goto L8;
        com.obric.cae.log.a.c("StarLocation-manager", "initLogFile skipped, context is null");     // Catch: Throwable -> L19
        monitor-exit(this);
        return;
    L8:
        Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        if (r1 == null) goto L12;
        r6 = r1;
    L12:
        this.o = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        File r2 = new File(d.a().b(r6), "star_location.txt");     // Catch: Throwable -> L15 Throwable -> L19
        r2.delete();     // Catch: Throwable -> L15 Throwable -> L19
        r2.createNewFile();     // Catch: Throwable -> L15 Throwable -> L19
        this.n = r2;     // Catch: Throwable -> L15 Throwable -> L19
        com.obric.cae.log.a.c("StarLocation-manager", "initLogFile, file: " + this.n);     // Catch: Throwable -> L15 Throwable -> L19
        com.obric.cae.log.a.a("star_location", this.n);     // Catch: Throwable -> L15 Throwable -> L19
    L17:
        monitor-exit(this);
        return;
    L15:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-manager", "initLogFile failed", e);     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        throw th;
    }

    public final void b(final b r22) {
        C0349a r0 = r22.f7026a;
        com.obric.cae.log.a.f("StarLocation-manager", CommonConsts.APM_INNER_EVENT_COST_START);
        boolean r5 = true;
        if (r0.b() == 1) goto L5;
    L7:
        boolean r3 = false;
    L9:
        if (r3 == false) goto L90;
        Object r4 = this.d;
        monitor-enter(r4);
        Iterator<C0349a> r10 = this.c.descendingIterator();     // Catch: Throwable -> L162
    L15:
        if (r10.hasNext() == false) goto L26;
        C0349a r11 = (C0349a) ZeusTransformUtils.preCheckCast(r10.next(), C0349a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L162
        if (r11 == r0) goto L15;
        if ("network".equals(r11.c()) == false) goto L15;
        if (r11.b() == 6) goto L15;
        boolean r12 = r11.equals(r0);     // Catch: Throwable -> L162
        monitor-exit(r4);     // Catch: Throwable -> L162
    L28:
        if (r12 == false) goto L31;
        String r1 = "StarLocation-manager";
        String r6 = "skipped, same as latest previous network location";
    L30:
        com.obric.cae.log.a.d(r1, r6);
        goto L90
    L31:
        com.obric.cae.log.a.f("StarLocation-manager", "find nlp location");
        C0349a r7 = c(r0);
        if (r7 == null) goto L90;
        com.obric.cae.log.a.f("StarLocation-manager", "find cell location");
        float r13 = r7.g();
        if (r13 > 0.0f) goto L37;
    L39:
        boolean r14 = false;
    L40:
        if (r14 == false) goto L89;
        float r15 = r0.g();
        if (r15 > 0.0f) goto L44;
    L46:
        boolean r16 = false;
    L47:
        if (r16 == false) goto L89;
        long r17 = r7.n();
        long r18 = r0.n();
        if (r17 > 0) goto L52;
    L56:
        long r19 = r7.d();
        long r110 = r0.d();
        if (r19 > 0) goto L59;
    L63:
        boolean r111 = false;
    L64:
        if (r111 == true) goto L66;
        r1 = "StarLocation-manager";
        r6 = "skipped, cell location is later than nlp location";
        goto L30
    L66:
        CoordinateTransformUtils.CoordinateSystem r112 = r7.i();
        CoordinateTransformUtils.CoordinateSystem r113 = CoordinateTransformUtils.CoordinateSystem.WGS84;
        if (r112 == r113) goto L69;
    L88:
        r1 = "StarLocation-manager";
        r6 = "skipped, inconsistent coordinate system";
        goto L30
    L69:
        if (r0.i() != r113) goto L88;
        double r114 = d.a().a(r7.e(), r7.f(), r0.e(), r0.f());
        if (Double.isNaN(r114) == false) goto L74;
    L87:
        r1 = "StarLocation-manager";
        r6 = "skipped, invalid location distance";
        goto L30
    L74:
        if (Double.isInfinite(r114) == true) goto L87;
        float r115 = r7.g();
        double r116 = r115;
        if (r114 <= (r116 * 1.68d)) goto L83;
        if (r0.g() <= r115) goto L81;
        int r117 = 3;
    L86:
        com.obric.cae.log.a.f("StarLocation-manager", "nlpValidCode: " + r117);
        com.obric.cae.location.report.d.a(r7, r0, r117, r114);
        goto L90
    L81:
        r117 = 2;
        goto L86
    L83:
        if (r114 <= r116) goto L85;
        r117 = 1;
        goto L86
    L85:
        r117 = 0;
        goto L86
    L59:
        if (r110 <= 0) goto L63;
        if (r19 > r110) goto L63;
    L62:
        r111 = true;
        goto L64
    L52:
        if (r18 <= 0) goto L56;
        if (r17 > r18) goto L63;
    L44:
        if (Float.isInfinite(r15) == true) goto L46;
        r16 = true;
    L89:
        r1 = "StarLocation-manager";
        r6 = "skipped, invalid location radius";
        goto L30
    L37:
        if (Float.isInfinite(r13) == true) goto L39;
        r14 = true;
        goto L40
    L26:
        monitor-exit(r4);     // Catch: Throwable -> L162
        r12 = false;
    L162:
        th = move-exception;
        throw th;
    L90:
        C0349a r2 = r22.f7026a;
        if (r2.b() != 6) goto L94;
    L135:
        if (r5 == true) goto L140;
        if (r22.f7026a.p() == true) goto L140;
        r22.f7026a.a(false);
    L140:
        if (d.a().q() == true) goto L142;
    L144:
        C0349a r8 = r22.f7026a;
        File r9 = this.n;
        if (r9 != null) goto L167;
        com.obric.cae.log.a.d("StarLocation-manager", "skipped, log file not initialized");
    L151:
        com.obric.cae.location.report.d.a(r22.f7026a);
        if (r22.f7026a.h() == true) goto L154;
        return;
    L154:
        UserAwareManager.getInstance().notifyInnerCallbacks(new $$Lambda$fVCJ1mKyxHirzMdrz5zD2_Kss5k(r22));
        Location r20 = e(r22.f7026a);
        int r21 = r22.f7026a.b();
        d.a().b(r20);
        UserAwareManager.getInstance().notifyInnerCallbacks($$Lambda$e_zDBTe7Z1c4vKHps9Jfe9Yg244.INSTANCE, r20);
        a(r20, r22.f7026a.q(), r21);
        Context r23 = this.o;
        if (r23 != null) goto L165;
        com.obric.cae.log.a.d("StarLocation-manager", "skipped, context is null");
        return;
    L165:
        com.obric.cae.location.geosdk.poi.a.b(r23, r20);     // Catch: Throwable -> L159
        com.obric.cae.location.geosdk.poi.a.a(r23, r20);     // Catch: Throwable -> L159
        return;
    L159:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-manager", "failed", th);
        return;
    L167:
        com.obric.cae.log.a.c("StarLocation-manager", r8.r(), r9);     // Catch: Throwable -> L149
    L149:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-manager", "failed", e);
        goto L151
    L142:
        if ("network".equals(r22.f7026a.c()) == false) goto L144;
        r22.f7026a.a(false);
        goto L144
    L94:
        if ("gps".equals(r2.c()) == true) goto L135;
        C0349a r24 = c(r2);
        if (r24 == null) goto L135;
        float r25 = r24.g();
        if (r25 > 0.0f) goto L102;
    L104:
        boolean r26 = false;
    L105:
        if (r26 == true) goto L108;
        String r27 = "StarLocation-manager";
        String r28 = "skipped, invalid cell location radius";
    L107:
        com.obric.cae.log.a.d(r27, r28);
        goto L135
    L108:
        CoordinateTransformUtils.CoordinateSystem r29 = r24.i();
        CoordinateTransformUtils.CoordinateSystem r118 = CoordinateTransformUtils.CoordinateSystem.WGS84;
        if (r29 == r118) goto L111;
    L134:
        r27 = "StarLocation-manager";
        r28 = "skipped, inconsistent coordinate system";
        goto L107
    L111:
        if (r2.i() != r118) goto L134;
        double r119 = d.a().a(r24.e(), r24.f(), r2.e(), r2.f());
        if (Double.isNaN(r119) == false) goto L116;
    L133:
        r27 = "StarLocation-manager";
        r28 = "skipped, invalid location distance";
        goto L107
    L116:
        if (Double.isInfinite(r119) == true) goto L133;
        float r30 = r2.g();
        if (Float.compare(r30, 0.0f) != 0) goto L121;
        r30 = 50.0f;
    L121:
        double r120 = ((double) r24.g()) * 1.68d;
        if (r30 > 0.0f) goto L124;
    L126:
        boolean r31 = false;
    L127:
        if (r31 == false) goto L130;
        r120 = Math.max(r120, r24.g() + r30);
    L130:
        if (r119 <= r120) goto L135;
        com.obric.cae.log.a.c("StarLocation-manager", "drop location source outside cell coverage, source=" + r2.b() + ", provider=" + r2.c() + ", distance=" + r119 + ", cellRadius=" + r24.g() + ", radius=" + r30, this.n);
        r5 = false;
        goto L135
    L124:
        if (Float.isInfinite(r30) == true) goto L126;
        r31 = true;
        goto L127
    L102:
        if (Float.isInfinite(r25) == true) goto L104;
        r26 = true;
        goto L105
    L5:
        if ("network".equals(r0.c()) == false) goto L7;
        r3 = true;
        goto L9
    }

    public boolean b(int r7, Location r8, int r9) {
        com.obric.cae.log.a.d("StarLocation-manager", "updateLatest source=" + r7 + ", location=" + r8);
        if (r7 != 2) goto L12;
        if (d.a().a(r8, (Location) ZeusTransformUtils.preCheckCast(this.i.getAndSet(new Location(r8)), Location.class, "com.obric.memorydata.plugin")) == false) goto L7;
        com.obric.cae.log.a.b("StarLocation-manager", "skip same vendor geofence location");
        boolean r3 = true;
    L8:
        if (r3 == false) goto L12;
        return a(r8, r7, false, r9);
    L7:
        r3 = false;
    L12:
        if (5 != r7) goto L16;
        return a(r8, r7, true, r9);
    L16:
        if ("network".equals(r8.getProvider()) == false) goto L26;
        if (this.j.get() == false) goto L24;
        if (this.k.get() == false) goto L24;
        com.obric.cae.log.a.d("StarLocation-manager", "skip nlp location while gnss on and gps received");
        return false;
    L24:
        return a(r7, r8, r9);
    L26:
        if (this.j.get() == false) goto L31;
        if ("gps".equals(r8.getProvider()) == false) goto L31;
        this.k.set(true);
    L31:
        return a(r8, r7, true, r9);
    }

    public int c(Location r4) {
        if (r4 != null) goto L5;
        return 0;
    L5:
        Bundle r0 = r4.getExtras();
        if (r0 != null) goto L8;
    L11:
        String r1 = r4.getProvider();
        if ("gps".equals(r1) == false) goto L30;
        float r5 = r4.getAccuracy();
        if (r5 > 0.0f) goto L17;
        return 0;
    L17:
        if (r5 <= 0.0f) goto L22;
        if (r5 > 20.0f) goto L22;
        return 5;
    L22:
        if (r5 > 50.0f) goto L25;
        return 4;
    L25:
        if (r5 > 70.0f) goto L27;
        return 3;
    L27:
        return 1;
    L30:
        if ("network".equals(r1) == true) goto L32;
        return 0;
    L32:
        return a(r4);
    L8:
        if (r0.containsKey("location_confidence") == false) goto L11;
        return r0.getInt("location_confidence", 0);
    }

    public C0349a c() {
        Object r0 = this.d;
        monitor-enter(r0);
        C0349a r3 = (C0349a) ZeusTransformUtils.preCheckCast(this.c.peekLast(), C0349a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r3 != null) goto L7;
        C0349a r4 = null;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r4;
    L7:
        r4 = new C0349a(r3);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public final C0349a c(C0349a r14) {
        Object r0 = this.d;
        monitor-enter(r0);
        Iterator<C0349a> r13 = this.c.iterator();     // Catch: Throwable -> L44
        C0349a r2 = null;
    L6:
        if (r13.hasNext() == false) goto L39;
        C0349a r3 = (C0349a) ZeusTransformUtils.preCheckCast(r13.next(), C0349a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L44
        if (r3.b() != 6) goto L6;
        long r4 = r3.n();     // Catch: Throwable -> L44
        long r6 = r14.n();     // Catch: Throwable -> L44
        boolean r11 = false;
        if (r4 > 0) goto L12;
    L16:
        long r5 = r3.d();     // Catch: Throwable -> L44
        long r7 = r14.d();     // Catch: Throwable -> L44
        if (r5 > 0) goto L19;
    L23:
        boolean r8 = false;
    L24:
        if (r8 == false) goto L6;
        if (r2 == null) goto L38;
        long r9 = r3.n();     // Catch: Throwable -> L44
        long r10 = r2.n();     // Catch: Throwable -> L44
        if (r9 <= 0) goto L35;
        if (r10 <= 0) goto L35;
        if (r9 > r10) goto L36;
    L37:
        if (r11 == false) goto L6;
    L36:
        r11 = true;
    L35:
        if (r3.d() <= r2.d()) goto L37;
    L38:
        r2 = r3;
        goto L6
    L19:
        if (r7 <= 0) goto L23;
        if (r5 > r7) goto L23;
    L22:
        r8 = true;
        goto L24
    L12:
        if (r6 <= 0) goto L16;
        if (r4 > r6) goto L23;
    L39:
        monitor-exit(r0);     // Catch: Throwable -> L44
        if (r2 != null) goto L43;
        return null;
    L43:
        return new C0349a(r2);
    L44:
        th = move-exception;
        throw th;
    }

    public boolean d(C0349a r4) {
        C0349a r0 = (C0349a) ZeusTransformUtils.preCheckCast(this.f7023b.get(r4.c()), C0349a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        C0349a r5 = b(r4);
        if (r5 != null) goto L11;
        return false;
    L11:
        a(b.a(r5));
        return true;
    L5:
        if (r0.equals(r4) == false) goto L8;
        return a(r4);
    }

    public Location e(C0349a r5) {
        Location r4 = new Location(r5.c());
        r4.setLatitude(r5.e());
        r4.setLongitude(r5.f());
        if (r5.g() <= 0.0f) goto L6;
        r4.setAccuracy(r5.g());
    L6:
        if (r5.n() <= 0) goto L9;
        r4.setElapsedRealtimeNanos(r5.n());
    L9:
        if (r5.o() <= 0) goto L11;
        r4.setTime(r5.o());
    L11:
        Bundle r0 = r5.m();
        r0.putInt("location_confidence", r5.j());
        r4.setExtras(r0);
        if (r0.containsKey("ALTITUDE") == false) goto L15;
        r4.setAltitude(r0.getDouble("ALTITUDE"));
    L15:
        if (r0.containsKey("VERTICAL_ACCURACY_METERS") == false) goto L18;
        r4.setVerticalAccuracyMeters(r0.getFloat("VERTICAL_ACCURACY_METERS"));
    L18:
        if (r0.containsKey("SPEED") == false) goto L21;
        r4.setSpeed(r0.getFloat("SPEED"));
    L21:
        if (r0.containsKey("BEARING") == false) goto L24;
        r4.setBearing(r0.getFloat("BEARING"));
    L24:
        if (r0.containsKey("SPEED_ACCURACY_METERS_PER_SECOND") == false) goto L27;
        r4.setSpeedAccuracyMetersPerSecond(r0.getFloat("SPEED_ACCURACY_METERS_PER_SECOND"));
    L27:
        if (r0.containsKey("BEARING_ACCURACY_DEGREES") == false) goto L29;
        r4.setBearingAccuracyDegrees(r0.getFloat("BEARING_ACCURACY_DEGREES"));
    L29:
        r4.setMock(r5.p());
        return r4;
    }
}
