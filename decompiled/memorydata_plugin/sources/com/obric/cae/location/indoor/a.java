package com.obric.cae.location.indoor;

import android.app.ActivityManager;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.GnssStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings;
import com.google.gson.Gson;
import com.obric.aikernel.sdk.data.PackageResource;
import com.obric.cae.location.geofence.StarGeoCallback;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.cae.utils.AIKernelPythonBridge;
import com.obric.cae.utils.PythonPackageCallback;
import com.volcengine.zeus.receiver.PluginBroadcastReceiver;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.bouncycastle.jcajce.util.AnnotatedPrivateKey;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f7230a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final long f7231b = 0;
    public static final long c = 0;
    public static final long d = 0;
    public static final String e = "cae_indoor_check_model";
    public static final Gson f = null;
    public static volatile a g;
    public final AtomicBoolean h;
    public final AtomicBoolean i;
    public final AtomicReference<String> j;
    public final AtomicReference<o> k;
    public final AtomicReference<String> l;
    public final AtomicReference<String> m;
    public final ConcurrentHashMap<Integer, l> n;
    public final com.obric.cae.libs.location.indoor.b.a o;
    public final ScheduledExecutorService p;
    public volatile Context q;
    public volatile File r;
    public volatile b s;
    public volatile String t;

    /* JADX INFO: renamed from: com.obric.cae.location.indoor.a$1, reason: invalid class name */
    public class AnonymousClass1 extends com.obric.cae.libs.location.indoor.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f7232a;

        public AnonymousClass1(a r1) {
            this.f7232a = r1;
        }

        private void a(int r10, String r11, String r12, com.obric.cae.libs.location.indoor.a r13) {
            com.obric.cae.libs.location.indoor.a r14 = (com.obric.cae.libs.location.indoor.a) ZeusTransformUtils.wrapperContextForParams(r13, com.obric.cae.libs.location.indoor.a.class, "com.obric.memorydata.plugin");
            Bundle r1 = new Bundle();
            r1.putInt("indoor_status", -1);
            r1.putDouble("confidence", -1.0d);
            b r15 = this.f7232a.a(r10, r11, r12);     // Catch: RuntimeException -> L13
            if (r15 != null) goto L6;
        L34:
            r14.onReportIndoorCheckEvent(r1);     // Catch: RemoteException -> L17
        L19:
            a r9 = this.f7232a;
            Iterator<Map.Entry<Integer, l>> r16 = r9.n.entrySet().iterator();
        L21:
            if (r16.hasNext() == false) goto L32;
            Map.Entry r17 = (Map.Entry) ZeusTransformUtils.preCheckCast(r16.next(), Map.Entry.class, "com.obric.memorydata.plugin");
            int r18 = ((Integer) ZeusTransformUtils.preCheckCast(r17.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue();
            l r19 = (l) ZeusTransformUtils.preCheckCast(r17.getValue(), l.class, "com.obric.memorydata.plugin");
            if (r18 == r10) goto L21;
            r19.f7251b.onReportIndoorCheckEvent(r1);     // Catch: Throwable -> L27
        L27:
            e = move-exception;
            if (r9.n.remove(Integer.valueOf(r18), r19) == true) goto L40;
        L31:
            com.obric.cae.log.a.a("StarLocation-indoorCheck", "report indoor check result failed, pid=" + r18, e);
            goto L21
        L40:
            r19.f7250a.unlinkToDeath(r19.c, 0);     // Catch: RuntimeException -> L33
            goto L31
        L32:
            return;
        L17:
            e = move-exception;
            com.obric.cae.log.a.b("StarLocation-indoorCheck", "report indoor check result failed", e);
            goto L19
        L6:
            if (Double.isFinite(r15.a()) == false) goto L34;
            if (r15.a() < 0.0d) goto L34;
            if (r15.a() > 1.0d) goto L34;
            r1.putInt("indoor_status", r15.b());     // Catch: RuntimeException -> L13
            r1.putDouble("confidence", r15.a());     // Catch: RuntimeException -> L13
        L13:
            e = move-exception;
            com.obric.cae.log.a.b("StarLocation-indoorCheck", "run indoor check failed", e);
            goto L34
        }

        /* JADX INFO: renamed from: lambda$4-1pQ4knspkwEpexfKdg-t-Xlbc, reason: not valid java name */
        public static /* synthetic */ void m395lambda$41pQ4knspkwEpexfKdgtXlbc(AnonymousClass1 r0, int r1, String r2, String r3, com.obric.cae.libs.location.indoor.a r4) {
            r0.a(r1, r2, r3, r4);
        }

        @Override // com.obric.cae.libs.location.indoor.b
        public void a() {
            a r2 = this.f7232a;
            int r0 = Binder.getCallingPid();
            String r1 = a.e;
            l r3 = (l) ZeusTransformUtils.preCheckCast(r2.n.remove(Integer.valueOf(r0)), l.class, "com.obric.memorydata.plugin");
            if (r3 == null) goto L10;
            r3.f7250a.unlinkToDeath(r3.c, 0);     // Catch: RuntimeException -> L7
            return;
        L11:
            return;
        }

        @Override // com.obric.cae.libs.location.indoor.b
        public void a(com.obric.cae.libs.location.indoor.a r4) {
            com.obric.cae.libs.location.indoor.a r5 = (com.obric.cae.libs.location.indoor.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.cae.libs.location.indoor.a.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L6;
            com.obric.cae.log.a.d("StarLocation-indoorCheck", "callback is null");
            return;
        L6:
            Context r2 = this.f7232a.q;
            if (r2 != null) goto L16;
            com.obric.cae.log.a.d("StarLocation-indoorCheck", "manager is not initialized");
            return;
        L16:
            r2.enforceCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_FINE_LOCATION");     // Catch: SecurityException -> L13
            this.f7232a.a(Binder.getCallingPid(), r5);
            return;
        L13:
            e = move-exception;
            com.obric.cae.log.a.j("StarLocation-indoorCheck", "permission error, does not have " + e.getMessage());
        }

        @Override // com.obric.cae.libs.location.indoor.b
        public void a(com.obric.cae.libs.location.indoor.a r10, String r11) {
            final com.obric.cae.libs.location.indoor.a r8 = (com.obric.cae.libs.location.indoor.a) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.cae.libs.location.indoor.a.class, "com.obric.memorydata.plugin");
            if (r8 != null) goto L6;
            com.obric.cae.log.a.d("StarLocation-indoorCheck", "callback is null");
            return;
        L6:
            Context r1 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a.a(this.f7232a), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
            if (r1 != null) goto L19;
            com.obric.cae.log.a.d("StarLocation-indoorCheck", "manager is not initialized");
            return;
        L19:
            r1.enforceCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_FINE_LOCATION");     // Catch: SecurityException -> L16
            final int r5 = Binder.getCallingPid();
            final String r6 = a.a(this.f7232a, r5, Binder.getCallingUid());
            if (r11 != null) goto L14;
            r11 = "";
        L14:
            final String r7 = r11;
            com.obric.cae.log.a.d("StarLocation-indoorCheck", "called by pid=" + r5 + ", package=" + r6 + ", reason=" + r7);
            com.obric.cae.location.util.d.a().r().execute(new $$Lambda$a$1$41pQ4knspkwEpexfKdgtXlbc(this, r5, r6, r7, r8));
            return;
        L16:
            e = move-exception;
            com.obric.cae.log.a.j("StarLocation-indoorCheck", "permission error, does not have " + e.getMessage());
        }
    }

    /* JADX INFO: renamed from: com.obric.cae.location.indoor.a$a, reason: collision with other inner class name */
    public static final class C0357a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f7233a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7234b;
        public final String c;
        public final String d;
        public final String e;
        public final double f;
        public final double[] g;
        public final double[] h;

        public /* synthetic */ C0357a() {
            throw null;
        }

        public C0357a(long r2, String r4, String r5, String r6, String r7, double r8, double[] r10, double[] r11) {
            this.f7233a = r2;
            this.f7234b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = (double[]) ZeusTransformUtils.preCheckCast(r10.clone(), double[].class, "com.obric.memorydata.plugin");
            this.h = (double[]) ZeusTransformUtils.preCheckCast(r11.clone(), double[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7236b;
        public final double c;
        public final double[] d;
        public final double[] e;
        public final List<C0357a> f;

        public /* synthetic */ b() {
            throw null;
        }

        public b(String r2, String r3, double r4, double[] r6, double[] r7, ArrayList r8) {
            this.f7235a = r2;
            this.f7236b = r3;
            this.c = r4;
            this.d = (double[]) ZeusTransformUtils.preCheckCast(r6.clone(), double[].class, "com.obric.memorydata.plugin");
            this.e = (double[]) ZeusTransformUtils.preCheckCast(r7.clone(), double[].class, "com.obric.memorydata.plugin");
            this.f = Collections.unmodifiableList(new ArrayList(r8));
        }

        public double a() {
            return this.c;
        }

        public int b() {
            if ("indoor".equals(this.f7236b) == false) goto L7;
            return 1;
        L7:
            if ("outdoor".equals(this.f7236b) == false) goto L10;
            return 0;
        L10:
            return -1;
        }
    }

    public class c implements PythonPackageCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f7237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m f7238b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ a f;

        public c(a r3, o r4, m r5, String r6, String r7, Context r8) {
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
            this.f = r3;
            this.f7237a = r4;
            this.f7238b = r5;
            this.c = r6;
            this.d = r7;
            this.e = ZeusTransformUtils.wrapperContext(r9, "com.obric.memorydata.plugin");
        }

        private void a(o r25, Bundle r26, m r27, String r28, String r29, Context r30) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r30, Context.class, "com.obric.memorydata.plugin");
            if (r25.f7255a.equals(this.f.j.get()) == true) goto L5;
            return;
        L5:
            r25.n = false;
            String r8 = r26.getString("state", "");
            String r9 = r26.getString(AnnotatedPrivateKey.LABEL);
            double r14 = r26.getDouble("prob_indoor", Double.NaN);
            String r13 = r26.getString("base_features");
            String r2 = r26.getString("hmm_state");
            if (r13 != null) goto L8;
        L14:
            double[] r10 = new double[0];
        L15:
            double[] r11 = r10;
            if (r2 != null) goto L18;
        L24:
            double[] r4 = new double[0];
        L25:
            r25.q = r8;
            r25.l.add(new C0357a(r27.f7252a, r27.f7253b, r28, r8, r9, r14, r11, r4));
            com.obric.cae.log.a.b("StarLocation-indoorCheck", "indoor check inference result, sessionId=" + r25.f7255a + ", timestampSec=" + r27.f7252a + ", businessName=" + r29 + ", businessVersion=" + ((String) ZeusTransformUtils.preCheckCast(this.f.m.get(), String.class, "com.obric.memorydata.plugin")) + ", label=" + r9 + ", probIndoor=" + r14 + ", state=" + r8 + ", baseFeatures=" + r13 + ", hmmState=" + r2, this.f.r);
            if ("indoor".equals(r9) == false) goto L28;
        L29:
            r25.r = r9;
            r25.s = r14;
            r25.t = r11;
            r25.u = r4;
        L30:
            String r15 = r25.r;
            if (r15 == null) goto L33;
            this.f.s = new b(r25.f7255a, r15, r25.s, r25.t, r25.u, r25.l);
        L33:
            this.f.f(r5, r25);
            return;
        L28:
            if ("outdoor".equals(r9) == false) goto L30;
        L18:
            if (r2.isEmpty() == true) goto L24;
            r4 = (double[]) ZeusTransformUtils.preCheckCast(a.f.fromJson(r2, double[].class), double[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L35
            if (r4 != null) goto L25;
            r4 = new double[0];     // Catch: Throwable -> L35
        L8:
            if (r13.isEmpty() == true) goto L14;
            r10 = (double[]) ZeusTransformUtils.preCheckCast(a.f.fromJson(r13, double[].class), double[].class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
            if (r10 != null) goto L15;
            r10 = new double[0];     // Catch: Throwable -> L36
            goto L15
        }

        private void a(o r19, m r20, String r21, String r22, Context r23) {
            Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.memorydata.plugin");
            if (r19.f7255a.equals(this.f.j.get()) == false) goto L20;
            r19.n = false;
            if (r20.c >= 2) goto L13;
            monitor-enter(r19);
            r19.k.addFirst(r20);     // Catch: Throwable -> L10
            monitor-exit(r19);
        L16:
            com.obric.cae.log.a.c("StarLocation-indoorCheck", "inference failed, sessionId=" + r19.f7255a + ", message=" + r22);
            this.f.f(r3, r19);
            return;
        L10:
            th = move-exception;
            throw th;
        L13:
            r19.l.add(new C0357a(r20.f7252a, r20.f7253b, r21, "", null, Double.NaN, new double[0], new double[0]));
            String r8 = r19.r;
            if (r8 == null) goto L16;
            this.f.s = new b(r19.f7255a, r8, r19.s, r19.t, r19.u, r19.l);
            goto L16
        }

        public static /* synthetic */ void lambda$DlsRCGg_WAAGxvgu0tHetIlGQUk(c r0, o r1, Bundle r2, m r3, String r4, String r5, Context r6) {
            r0.a(r1, r2, r3, r4, r5, r6);
        }

        public static /* synthetic */ void lambda$soRj8Lltr1MHw2brsuqAXC3qgZI(c r0, o r1, m r2, String r3, String r4, Context r5) {
            r0.a(r1, r2, r3, r4, r5);
        }

        @Override // com.obric.cae.utils.PythonPackageCallback
        public final void onFailure(final String r10) {
            ScheduledExecutorService r0 = a.b(this.f);
            final o r3 = this.f7237a;
            final m r4 = this.f7238b;
            final String r5 = this.c;
            final Context r7 = this.e;
            r0.execute(new $$Lambda$a$c$soRj8Lltr1MHw2brsuqAXC3qgZI(this, r3, r4, r5, r10, r7));
        }

        @Override // com.obric.cae.utils.PythonPackageCallback
        public final void onSuccess(final Bundle r11) {
            ScheduledExecutorService r0 = a.b(this.f);
            final o r3 = this.f7237a;
            final m r5 = this.f7238b;
            final String r6 = this.c;
            final String r7 = this.d;
            final Context r8 = this.e;
            r0.execute(new $$Lambda$a$c$DlsRCGg_WAAGxvgu0tHetIlGQUk(this, r3, r11, r5, r6, r7, r8));
        }
    }

    public class d extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f7239a;

        public d(a r1) {
            this.f7239a = r1;
            super(null);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean r4) {
            a r3 = this.f7239a;
            String r5 = a.e;
            Context r6 = r3.q;
            if (r6 == null) goto L15;
            String r7 = Settings.Global.getString(r6.getContentResolver(), "cae_indoor_check_model");
            String r0 = "indoor_outdoor_recognition_without_wifi";
            if ("indoor_outdoor_recognition_without_wifi".equalsIgnoreCase(r7) == true) goto L13;
            if (r7 != null) goto L10;
        L12:
            r0 = "indoor_outdoor_recognition";
            goto L13
        L10:
            if ("indoor_outdoor_recognition".equalsIgnoreCase(r7) == true) goto L12;
            com.obric.cae.log.a.c("StarLocation-indoorCheck", "ignore invalid indoor check model: ".concat(r7));
        L13:
            r3.t = r0;
            r3.b();
            return;
        }
    }

    public class e implements com.obric.cae.utils.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f7241b;

        public e(a r1, String r2) {
            this.f7241b = r1;
            this.f7240a = r2;
        }

        @Override // com.obric.cae.utils.e
        public final void a() {
            this.f7241b.l.compareAndSet(this.f7240a, null);
            this.f7241b.m.set("");
            this.f7241b.i.set(false);
            this.f7241b.b();
        }

        @Override // com.obric.cae.utils.e
        public final void a(String r4) {
            this.f7241b.l.compareAndSet(this.f7240a, null);
            this.f7241b.m.set("");
            this.f7241b.i.set(false);
            com.obric.cae.log.a.c("StarLocation-indoorCheck", "unload indoor check model failed, businessName=" + this.f7240a + ", message=" + r4 + ", continue switching");
            this.f7241b.b();
        }
    }

    public class f implements com.obric.cae.utils.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f7242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f7243b;

        public f(a r1, String r2) {
            this.f7243b = r1;
            this.f7242a = r2;
        }

        @Override // com.obric.cae.utils.f
        public final void a(PackageResource r5) {
            this.f7243b.l.set(this.f7242a);
            this.f7243b.i.set(false);
            String r0 = r5.getVersion();
            List<PackageResource> r2 = r5.getSubRes();
            if (r2 != null) goto L5;
        L9:
            this.f7243b.m.set(r0);
            com.obric.cae.log.a.b("StarLocation-indoorCheck", "indoor check model loaded, businessName=" + r5.getName() + ", businessVersion=" + r0, this.f7243b.r);
            this.f7243b.b();
            return;
        L5:
            if (r2.isEmpty() == true) goto L9;
            PackageResource r1 = (PackageResource) ZeusTransformUtils.preCheckCast(r2.get(0), PackageResource.class, "com.obric.memorydata.plugin");
            if (r1 == null) goto L9;
            r0 = r0 + "@" + r1.getVersion();
            goto L9
        }

        @Override // com.obric.cae.utils.f
        public final void a(String r3) {
            this.f7243b.i.set(false);
            com.obric.cae.log.a.b("StarLocation-indoorCheck", "load indoor check model failed, businessName=" + this.f7242a + ", message=" + r3, this.f7243b.r);
        }
    }

    public class g extends ScanCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f7244a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f7245b;
        public final /* synthetic */ a c;

        public g(Context r3, o r4, a r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            this.c = r5;
            this.f7244a = r4;
            this.f7245b = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        }

        private /* synthetic */ void a(Context r3, o r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            a r2 = this.c;
            String r6 = r4.f7255a;
            String r0 = a.e;
            r2.a(r5, r6);
        }

        public static /* synthetic */ void lambda$3JWKVNwYJCFiepuiQRkDC9X8R40(g r0, Context r1, o r2) {
            r0.a(r1, r2);
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onBatchScanResults(List<ScanResult> r4) {
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
            if (r5 != null) goto L5;
            return;
        L5:
            Iterator r6 = r5.iterator();
        L7:
            if (r6.hasNext() == false) goto L9;
            onScanResult(1, (ScanResult) ZeusTransformUtils.preCheckCast(r6.next(), ScanResult.class, "com.obric.memorydata.plugin"));
            goto L7
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanFailed(int r4) {
            com.obric.cae.log.a.c("StarLocation-indoorCheck", "BLE scan failed, sessionId=" + o.a(this.f7244a) + ", errorCode=" + r4);
            ScheduledExecutorService r5 = a.b(this.c);
            final Context r0 = this.f7245b;
            final o r1 = this.f7244a;
            r5.execute(new $$Lambda$a$g$3JWKVNwYJCFiepuiQRkDC9X8R40(this, r0, r1));
        }

        @Override // android.bluetooth.le.ScanCallback
        public final void onScanResult(int r3, ScanResult r4) {
            if (r4 != null) goto L4;
            return;
        L4:
            if (r4.getDevice() != null) goto L6;
            return;
        L6:
            if (r4.getScanRecord() == null) goto L9;
            r4.getScanRecord().getDeviceName();
        L9:
            o r2 = this.f7244a;
            long r0 = System.currentTimeMillis();
            String r5 = r4.getDevice().getAddress();
            r2.a(r4.getRssi(), r0, r5);
        }
    }

    public class h extends GnssStatus.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f7246a;

        public h(o r1) {
            this.f7246a = r1;
        }

        @Override // android.location.GnssStatus.Callback
        public final void onSatelliteStatusChanged(GnssStatus r5) {
            ArrayList r0 = new ArrayList(r5.getSatelliteCount());
            int r1 = 0;
        L4:
            if (r1 >= r5.getSatelliteCount()) goto L6;
            r0.add(Float.valueOf(r5.getCn0DbHz(r1)));
            r1 = r1 + 1;
            goto L4
        L6:
            o r4 = this.f7246a;
            long r2 = System.currentTimeMillis();
            monitor-enter(r4);
            r4.j.put(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(r2)), new ArrayList(r0));     // Catch: Throwable -> L11
            monitor-exit(r4);
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    public class i implements SensorEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f7247a;

        public i(o r1) {
            this.f7247a = r1;
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor r1, int r2) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent r5) {
            if (r5.values.length != 0) goto L5;
            return;
        L5:
            this.f7247a.a(System.currentTimeMillis(), r5.values[0]);
            UserAwareManager.getInstance().notifyInnerCallbacks($$Lambda$XrFokPpBO8nOaGbVAFtHUrNMRo4.INSTANCE, r5);
        }
    }

    public class j extends PluginBroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ o f7248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ WifiManager f7249b;

        public j(o r1, WifiManager r2) {
            this.f7248a = r1;
            this.f7249b = r2;
        }

        public final void onReceive(Context r3, Intent r4) {
            Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
            if ("android.net.wifi.SCAN_RESULTS".equals(r4.getAction()) == false) goto L6;
            o r6 = this.f7248a;
            long r0 = System.currentTimeMillis();
            r6.a(this.f7249b.getScanResults(), r0);
            return;
        }
    }

    public static final class k {
        public k() {
        }
    }

    public static final class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IBinder f7250a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.obric.cae.libs.location.indoor.a f7251b;
        public final IBinder.DeathRecipient c;

        public l(IBinder r3, com.obric.cae.libs.location.indoor.a r4, IBinder.DeathRecipient r5) {
            IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r3, IBinder.class, "com.obric.memorydata.plugin");
            com.obric.cae.libs.location.indoor.a r7 = (com.obric.cae.libs.location.indoor.a) ZeusTransformUtils.wrapperContextForParams(r4, com.obric.cae.libs.location.indoor.a.class, "com.obric.memorydata.plugin");
            IBinder.DeathRecipient r8 = (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.DeathRecipient.class, "com.obric.memorydata.plugin");
            this.f7250a = r6;
            this.f7251b = r7;
            this.c = r8;
        }

        public /* synthetic */ l(IBinder r2, com.obric.cae.libs.location.indoor.a r3, IBinder.DeathRecipient r4, int r5) {
            this((IBinder) ZeusTransformUtils.wrapperContextForParams(r2, IBinder.class, "com.obric.memorydata.plugin"), (com.obric.cae.libs.location.indoor.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.cae.libs.location.indoor.a.class, "com.obric.memorydata.plugin"), (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.DeathRecipient.class, "com.obric.memorydata.plugin"));
        }

        public static /* synthetic */ IBinder.DeathRecipient a(l r0) {
            return r0.c;
        }

        public static /* synthetic */ IBinder b(l r0) {
            return r0.f7250a;
        }
    }

    public static final class m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f7252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7253b;
        public int c;

        public m(String r1, long r2) {
            this.f7252a = r2;
            this.f7253b = r1;
        }
    }

    public static final class n {
        public n() {
        }
    }

    public static final class o {
        public LocationManager A;
        public LocationListener B;
        public GnssStatus.Callback C;
        public SensorManager D;
        public Sensor E;
        public SensorEventListener F;
        public HandlerThread G;
        public WifiManager H;
        public PluginBroadcastReceiver I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public boolean f7254J;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7255a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f7256b;
        public final String c;
        public final boolean d;
        public final boolean e;
        public final HashMap f;
        public final HashMap g;
        public final HashMap h;
        public final HashMap i;
        public final HashMap j;
        public final ArrayDeque<m> k;
        public final ArrayList l;
        public int m;
        public boolean n;
        public boolean o;
        public long p;
        public String q;
        public String r;
        public double s;
        public double[] t;
        public double[] u;
        public Location v;
        public ScheduledFuture<?> w;
        public ScheduledFuture<?> x;
        public BluetoothLeScanner y;
        public ScanCallback z;

        public o(String r3, String r4, String r5, boolean r6, boolean r7) {
            this.f = new HashMap();
            this.g = new HashMap();
            this.h = new HashMap();
            this.i = new HashMap();
            this.j = new HashMap();
            this.k = new ArrayDeque();
            this.l = new ArrayList();
            this.p = Long.MIN_VALUE;
            this.q = "";
            this.s = Double.NaN;
            this.t = new double[0];
            this.u = new double[0];
            this.f7255a = r3;
            this.f7256b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
        }

        public static /* synthetic */ String a(o r0) {
            return r0.f7255a;
        }

        public static /* synthetic */ List a(Long r0) {
            return new ArrayList();
        }

        public static /* synthetic */ boolean a(long r2, Long r4) {
            if (r4.longValue() >= r2) goto L5;
            return true;
        L5:
            return false;
        }

        public static boolean a(o r3, long r4) {
            monitor-enter(r3);
        L12:
            th = move-exception;
            throw th;
        L5:
            if (r4 > r3.p) goto L9;
            boolean r5 = false;
        L7:
            monitor-exit(r3);
            return r5;
        L9:
            r3.k.addLast(new m(r3.a(r4), r4));     // Catch: Throwable -> L12
            r3.p = r4;     // Catch: Throwable -> L12
            r5 = true;
            goto L7
        }

        public static /* synthetic */ List b(Long r0) {
            return new ArrayList();
        }

        public static /* synthetic */ boolean b(long r2, Long r4) {
            if (r4.longValue() >= r2) goto L5;
            return true;
        L5:
            return false;
        }

        public static /* synthetic */ boolean b(o r0) {
            return r0.d;
        }

        public static /* synthetic */ String c(o r0) {
            return r0.r;
        }

        public static /* synthetic */ List c(Long r0) {
            return new ArrayList();
        }

        public static /* synthetic */ boolean c(long r2, Long r4) {
            if (r4.longValue() >= r2) goto L5;
            return true;
        L5:
            return false;
        }

        public static /* synthetic */ double d(o r2) {
            return r2.s;
        }

        public static /* synthetic */ boolean d(long r2, Long r4) {
            if (r4.longValue() >= r2) goto L5;
            return true;
        L5:
            return false;
        }

        public static /* synthetic */ ScheduledFuture e(o r0) {
            return r0.x;
        }

        public static /* synthetic */ boolean e(long r2, Long r4) {
            if (r4.longValue() >= r2) goto L5;
            return true;
        L5:
            return false;
        }

        public static /* synthetic */ ArrayDeque f(o r0) {
            return r0.k;
        }

        public static /* synthetic */ String g(o r0) {
            return r0.f7256b;
        }

        public static /* synthetic */ String h(o r0) {
            return r0.c;
        }

        public static /* synthetic */ Location i(o r0) {
            return r0.v;
        }

        public static /* synthetic */ ScheduledFuture j(o r0) {
            return r0.w;
        }

        public static /* synthetic */ boolean k(o r0) {
            return r0.f7254J;
        }

        public static /* synthetic */ PluginBroadcastReceiver l(o r0) {
            return r0.I;
        }

        public static /* synthetic */ SensorManager m(o r0) {
            return r0.D;
        }

        public static /* synthetic */ SensorEventListener n(o r0) {
            return r0.F;
        }

        public static /* synthetic */ Sensor o(o r0) {
            return r0.E;
        }

        public static /* synthetic */ HandlerThread p(o r0) {
            return r0.G;
        }

        public static /* synthetic */ LocationManager q(o r0) {
            return r0.A;
        }

        public static /* synthetic */ LocationListener r(o r0) {
            return r0.B;
        }

        public static /* synthetic */ GnssStatus.Callback s(o r0) {
            return r0.C;
        }

        public static /* synthetic */ BluetoothLeScanner t(o r0) {
            return r0.y;
        }

        public static /* synthetic */ ScanCallback u(o r0) {
            return r0.z;
        }

        public static /* synthetic */ boolean v(o r0) {
            return r0.e;
        }

        public final synchronized String a(long r5) {
            monitor-enter(this);
        L10:
            th = move-exception;
            throw th;
        L4:
            if (this.d == true) goto L7;
            List r1 = (List) ZeusTransformUtils.preCheckCast(this.f.remove(Long.valueOf(r5)), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        L7:
            List r2 = (List) ZeusTransformUtils.preCheckCast(this.g.remove(Long.valueOf(r5)), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            List r3 = (List) ZeusTransformUtils.preCheckCast(this.h.remove(Long.valueOf(r5)), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            String r4 = (String) ZeusTransformUtils.preCheckCast(this.i.remove(Long.valueOf(r5)), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            List r6 = (List) ZeusTransformUtils.preCheckCast(this.j.remove(Long.valueOf(r5)), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
            n r0 = new n();     // Catch: Throwable -> L10
            this.m++;     // Catch: Throwable -> L10
            b(r5);     // Catch: Throwable -> L10
            String r7 = a.f.toJson(r0);     // Catch: Throwable -> L10
            monitor-exit(this);
            return r7;
        }

        public final synchronized void a(int r1, long r2, String r4) {
            monitor-enter(this);
            if (r4 != null) goto L15;
        L13:
            monitor-exit(this);
            return;
        L15:
        L10:
            th = move-exception;
            throw th;
        L5:
            if (r4.isEmpty() == true) goto L13;
            ((List) ZeusTransformUtils.preCheckCast(this.g.computeIfAbsent(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(r2)), $$Lambda$08ATCOD1YWfKSkRRUPJsftMCwE.INSTANCE), List.class, "com.obric.memorydata.plugin")).add(new k());     // Catch: Throwable -> L10
            monitor-exit(this);
        }

        public final synchronized void a(long r3, float r5) {
            monitor-enter(this);
            ((List) ZeusTransformUtils.preCheckCast(this.h.computeIfAbsent(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(r3)), $$Lambda$HS5TO1ZOMQzLLkyQux6d_aNcwuA.INSTANCE), List.class, "com.obric.memorydata.plugin")).add(Float.valueOf(r5));     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public final synchronized void a(List r3, long r4) {
            monitor-enter(this);
            List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
            long r6 = TimeUnit.MILLISECONDS.toSeconds(r4);     // Catch: Throwable -> L21
            List r7 = (List) ZeusTransformUtils.preCheckCast(this.f.computeIfAbsent(Long.valueOf(r6), $$Lambda$UnuL_iWynX07HxFqFrhuETuGNZ8.INSTANCE), List.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
            if (r5 != null) goto L7;
            monitor-exit(this);
            return;
        L7:
            Iterator r8 = r5.iterator();     // Catch: Throwable -> L21
        L9:
            if (r8.hasNext() == false) goto L19;
            android.net.wifi.ScanResult r9 = (android.net.wifi.ScanResult) ZeusTransformUtils.preCheckCast(r8.next(), android.net.wifi.ScanResult.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
            if (r9 == null) goto L9;
            String r10 = r9.BSSID;     // Catch: Throwable -> L21
            if (r10 == null) goto L9;
            if (r10.isEmpty() == true) goto L9;
            r7.add(new p());     // Catch: Throwable -> L21
            goto L9
        L19:
            monitor-exit(this);
            return;
        L21:
            th = move-exception;
            throw th;
        }

        public final void b(final long r3) {
            this.f.keySet().removeIf(new $$Lambda$ZkU48LCdfCzk0ZUn7w3BT1yx6EI(r3));
            this.g.keySet().removeIf(new $$Lambda$YW7cr6ZNqkB9RjY03x4htHRkE(r3));
            this.h.keySet().removeIf(new $$Lambda$DDpVFlcqZ1pan66hZuMKCeSaXtU(r3));
            this.i.keySet().removeIf(new $$Lambda$HDQryR5VZYWGiFKuLri0v3sn5M(r3));
            this.j.keySet().removeIf(new $$Lambda$BA0jKtSgnDkZcxPjrdXR0rHJYY(r3));
        }
    }

    public static final class p {
        public p() {
        }
    }

    static {
        TimeUnit r0 = TimeUnit.SECONDS;
        f7230a = r0.toMillis(5);
        f7231b = r0.toMillis(1);
        c = r0.toMillis(3);
        d = r0.toMillis(2);
        f = new Gson();
    }

    public a() {
        this.h = new AtomicBoolean(false);
        this.i = new AtomicBoolean(false);
        this.j = new AtomicReference();
        this.k = new AtomicReference();
        this.l = new AtomicReference();
        this.m = new AtomicReference("");
        this.n = new ConcurrentHashMap();
        this.o = new AnonymousClass1(this);
        this.p = Executors.newSingleThreadScheduledExecutor($$Lambda$EfsGe9ajTs1AjPMmjAhbi8Ihppo.INSTANCE);
        this.t = "indoor_outdoor_recognition";
    }

    public static /* synthetic */ Context a(a r0) {
        return r0.q;
    }

    public static synchronized a a() {
        monitor-enter(a.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (g != null) goto L7;
        g = new a();     // Catch: Throwable -> L10
    L7:
        a r1 = g;     // Catch: Throwable -> L10
        monitor-exit(a.class);
        return r1;
    }

    public static String a(a r9, int r10, int r11) {
        r9.getClass();
        Context r12 = r9.q;     // Catch: RuntimeException -> L38
        if (r12 == null) goto L50;
        String[] r2 = r12.getPackageManager().getPackagesForUid(r11);     // Catch: RuntimeException -> L38
        ActivityManager r13 = (ActivityManager) ZeusTransformUtils.preCheckCast(r12.getSystemService(ActivityManager.class), ActivityManager.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L38
        if (r13 != null) goto L9;
        List<ActivityManager.RunningAppProcessInfo> r14 = null;
    L11:
        if (r14 == null) goto L33;
        Iterator<ActivityManager.RunningAppProcessInfo> r15 = r14.iterator();     // Catch: RuntimeException -> L38
    L14:
        if (r15.hasNext() == false) goto L33;
        ActivityManager.RunningAppProcessInfo r5 = (ActivityManager.RunningAppProcessInfo) ZeusTransformUtils.preCheckCast(r15.next(), ActivityManager.RunningAppProcessInfo.class, "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L38
        if (r5.pid != r10) goto L14;
        String r6 = r5.processName;     // Catch: RuntimeException -> L38
        if (r6 == null) goto L14;
        String r16 = r6.split(ParameterizedMessage.ERROR_MSG_SEPARATOR, 2)[0];     // Catch: RuntimeException -> L38
        if (r2 == null) goto L28;
        int r0 = r2.length;     // Catch: RuntimeException -> L38
        int r7 = 0;
    L23:
        if (r7 >= r0) goto L28;
        String r8 = r2[r7];     // Catch: RuntimeException -> L38
        if (r8.equals(r16) == true) goto L51;
        r7 = r7 + 1;     // Catch: RuntimeException -> L38
        goto L23
    L51:
        return r8;
    L28:
        String[] r17 = r5.pkgList;     // Catch: RuntimeException -> L38
        if (r17 == null) goto L33;
        if (r17.length != 1) goto L33;
        String r18 = r17[0];     // Catch: RuntimeException -> L38
    L54:
        return r18;
    L33:
        if (r2 != null) goto L35;
        return "unknown";
    L35:
        if (r2.length != 1) goto L53;
        r18 = r2[0];     // Catch: RuntimeException -> L38
        goto L54
    L53:
        return "unknown";
    L9:
        r14 = r13.getRunningAppProcesses();     // Catch: RuntimeException -> L38
        goto L11
    L50:
        return "unknown";
    L38:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-indoorCheck", "resolve calling package failed, pid=" + r10 + ", uid=" + r11, e);
        return "unknown";
    }

    public static /* synthetic */ Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "IndoorCheck");
    }

    private /* synthetic */ void a(int r4, IBinder r5) {
        IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.memorydata.plugin");
        l r0 = (l) ZeusTransformUtils.preCheckCast(this.n.get(Integer.valueOf(r4)), l.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.f7250a == r6) goto L7;
        return;
    L7:
        if (this.n.remove(Integer.valueOf(r4), r0) == false) goto L12;
        com.obric.cae.log.a.c("StarLocation-indoorCheck", "indoor check callback died, pid=" + r4);
        return;
    }

    public static void a(o r4, Location r5) {
        if (com.obric.cae.location.util.d.a().a(r5) == true) goto L6;
        com.obric.cae.log.a.c("StarLocation-indoorCheck", "ignore non-GPO GPS location, sessionId=" + r4.f7255a);
        return;
    L6:
        long r0 = System.currentTimeMillis();
        monitor-enter(r4);
        r4.i.put(Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(r0)), r5.getProvider());     // Catch: Throwable -> L11
        r4.v = new Location(r5);     // Catch: Throwable -> L11
        monitor-exit(r4);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static boolean a(Context r6, o r7) {
        SensorManager r8 = (SensorManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin")).getSystemService(SensorManager.class), SensorManager.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
        Sensor r1 = null;
    L6:
        if (r8 == null) goto L13;
        if (r1 == null) goto L15;
        HandlerThread r2 = new HandlerThread("IndoorCheckLight-" + r7.f7255a);
        r2.start();
        i r3 = new i(r7);
        r7.D = r8;
        r7.E = r1;
        r7.F = r3;
        r7.G = r2;
        boolean r9 = r8.registerListener(r3, r1, 1, new Handler(r2.getLooper()));
        if (r9 == true) goto L12;
        r2.quitSafely();
        r7.G = null;
    L12:
        return r9;
    L15:
        return false;
    L13:
        return false;
    L5:
        r1 = r8.getDefaultSensor(5);
        goto L6
    }

    public static boolean a(Context r5, boolean r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        BluetoothManager r0 = (BluetoothManager) ZeusTransformUtils.preCheckCast(r7.getSystemService(BluetoothManager.class), BluetoothManager.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        BluetoothAdapter r1 = null;
    L7:
        if (r1 != null) goto L9;
    L49:
        return false;
    L9:
        if (r1.getBluetoothLeScanner() == null) goto L49;
        if (Build.VERSION.SDK_INT >= 31) goto L13;
    L18:
        boolean r2 = true;
    L19:
        if (r2 == false) goto L49;
        LocationManager r3 = (LocationManager) ZeusTransformUtils.preCheckCast(r7.getSystemService(LocationManager.class), LocationManager.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L49;
        if (r3.isProviderEnabled("fused") == false) goto L49;
        if (r3.isProviderEnabled("gps") == false) goto L49;
        if (r7.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) goto L30;
    L33:
        boolean r4 = true;
    L34:
        if (r4 == false) goto L49;
        SensorManager r8 = (SensorManager) ZeusTransformUtils.preCheckCast(r7.getSystemService(SensorManager.class), SensorManager.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L49;
        if (r8.getDefaultSensor(5) == null) goto L49;
        if (r6 == true) goto L48;
        WifiManager r9 = (WifiManager) ZeusTransformUtils.preCheckCast(r7.getSystemService(WifiManager.class), WifiManager.class, "com.obric.memorydata.plugin");
        if (r9 != null) goto L45;
        return false;
    L45:
        if (r9.isWifiEnabled() == true) goto L47;
        return false;
    L47:
        return true;
    L48:
        return true;
    L30:
        if (r7.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) goto L33;
        r4 = false;
        goto L34
    L13:
        if (r7.checkSelfPermission("android.permission.BLUETOOTH_SCAN") == 0) goto L15;
    L17:
        r2 = false;
        goto L19
    L15:
        if (r7.checkSelfPermission("android.permission.BLUETOOTH_CONNECT") != 0) goto L17;
    L5:
        r1 = r0.getAdapter();
        goto L7
    }

    public static /* synthetic */ ScheduledExecutorService b(a r0) {
        return r0.p;
    }

    private /* synthetic */ void b(Context r3, String r4) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    private /* synthetic */ void b(Context r8, String r9, String r10, String r11, boolean r12, boolean r13) {
        a((Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin"), r9, r10, r11, r12, r13);
    }

    public static boolean b(Context r6, o r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        WifiManager r0 = (WifiManager) ZeusTransformUtils.preCheckCast(r8.getSystemService(WifiManager.class), WifiManager.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        return false;
    L6:
        j r2 = new j(r7, r0);
        r7.H = r0;
        r7.I = r2;
        IntentFilter r3 = new IntentFilter("android.net.wifi.SCAN_RESULTS");
        if (Build.VERSION.SDK_INT < 33) goto L9;
        ZeusTransformUtils.registerReceiver(r8, r2, r3, 4, "com.obric.memorydata.plugin");
    L10:
        r7.f7254J = true;
        return r0.startScan();
    L9:
        ZeusTransformUtils.registerReceiver(r8, r2, r3, "com.obric.memorydata.plugin");
        goto L10
    }

    public static void c(Context r4, o r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (o.j(r5) == null) goto L6;
        o.j(r5).cancel(false);
    L6:
        if (o.k(r5) == false) goto L14;
        if (o.l(r5) == null) goto L14;
        ZeusTransformUtils.unregisterReceiver(r6, o.l(r5), "com.obric.memorydata.plugin");     // Catch: RuntimeException -> L11
    L11:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-indoorCheck", "unregister Wi-Fi receiver failed, sessionId=" + o.a(r5), e);
    L14:
        if (o.m(r5) == null) goto L22;
        if (o.n(r5) == null) goto L22;
        o.m(r5).unregisterListener(o.n(r5), o.o(r5));     // Catch: RuntimeException -> L19
    L19:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-indoorCheck", "stop light failed, sessionId=" + o.a(r5), e);
    L22:
        if (o.p(r5) == null) goto L25;
        o.p(r5).quitSafely();
    L25:
        if (o.q(r5) == null) goto L39;
        if (o.r(r5) == null) goto L33;
        o.q(r5).removeUpdates(o.r(r5));     // Catch: RuntimeException -> L30
    L30:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-indoorCheck", "stop location failed, sessionId=" + o.a(r5), e);
    L33:
        if (o.s(r5) == null) goto L39;
        o.q(r5).unregisterGnssStatusCallback(o.s(r5));     // Catch: RuntimeException -> L36
    L36:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-indoorCheck", "stop GNSS failed, sessionId=" + o.a(r5), e);
    L39:
        if (o.t(r5) == null) goto L47;
        if (o.u(r5) == null) goto L47;
        o.t(r5).stopScan(o.u(r5));     // Catch: RuntimeException -> L44
    L44:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-indoorCheck", "stop BLE failed, sessionId=" + o.a(r5), e);
    L47:
        if (o.v(r5) == true) goto L60;
        com.obric.cae.location.util.d.a().b(false);
        return;
    }

    private /* synthetic */ void h(Context r3, o r4) {
        g((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), r4);
    }

    private void i(Context r5, o r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        if (r6.f7255a.equals(this.j.get()) == true) goto L6;
        return;
    L6:
        if (o.a(r6, TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()) - 1) == true) goto L8;
    L14:
        f(r7, r6);
        return;
    L8:
        if (r6.d == true) goto L14;
        if ((r6.m % 5) != 0) goto L14;
        WifiManager r0 = r6.H;
        if (r0 == null) goto L14;
        r0.startScan();
        goto L14
    }

    public static /* synthetic */ void lambda$1Ni64swqCYm_2O7ISj0EFbBUwQ4(a r0, Context r1, String r2) {
        r0.b(r1, r2);
    }

    public static /* synthetic */ void lambda$DjYiTdPz2cOtvj1QYP0HxyoRjrQ(a r0, Context r1, o r2) {
        r0.i(r1, r2);
    }

    /* JADX INFO: renamed from: lambda$RwH88vTpgqV-etEmQf37gD4r6sg, reason: not valid java name */
    public static /* synthetic */ void m392lambda$RwH88vTpgqVetEmQf37gD4r6sg(a r0, Context r1, o r2) {
        r0.h(r1, r2);
    }

    /* JADX INFO: renamed from: lambda$__FMQXk-o6ijcjKuVKRu_09tKh0, reason: not valid java name */
    public static /* synthetic */ void m393lambda$__FMQXko6ijcjKuVKRu_09tKh0(a r0, Context r1, String r2, String r3, String r4, boolean r5, boolean r6) {
        r0.b(r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: lambda$iGmBT_Ec-la3ZpKwNzngy43ELLs, reason: not valid java name */
    public static /* synthetic */ void m394lambda$iGmBT_Ecla3ZpKwNzngy43ELLs(a r0, int r1, IBinder r2) {
        r0.a(r1, r2);
    }

    public b a(int r7, String r8, String r9) {
        com.obric.cae.log.a.b("StarLocation-indoorCheck", "indoor check requested, pid=" + r7 + ", package=" + r8 + ", reason=" + r9, this.r);
        String r10 = a(r8, r9);
        if (r10 != null) goto L5;
        return null;
    L5:
        long r4 = TimeUnit.SECONDS.toMillis(1) + (((SystemClock.elapsedRealtime() + c) + f7230a) + d);
    L7:
        if (r10.equals(this.j.get()) == false) goto L12;
        if (SystemClock.elapsedRealtime() >= r4) goto L12;
        SystemClock.sleep(100);
    L12:
        if (r10.equals(this.j.get()) == false) goto L15;
        com.obric.cae.log.a.c("StarLocation-indoorCheck", "wait indoor check result timed out, sessionId=".concat(r10));
        return null;
    L15:
        b r6 = this.s;
        if (r6 != null) goto L18;
        return null;
    L18:
        if (r10.equals(r6.f7235a) == true) goto L20;
        return null;
    L20:
        return r6;
    }

    public final String a(final String r17, final String r18) {
        final Context r3 = this.q;
        if (r3 != null) goto L6;
        com.obric.cae.log.a.c("StarLocation-indoorCheck", "reject because context is invalid");
        return null;
    L6:
        final String r12 = com.obric.cae.utils.g.a();
        if (this.j.compareAndSet(null, r12) == true) goto L10;
        com.obric.cae.log.a.c("StarLocation-indoorCheck", "reject duplicate request, activeSessionId=" + ((String) ZeusTransformUtils.preCheckCast(this.j.get(), String.class, "com.obric.memorydata.plugin")));
        return null;
    L10:
        final boolean r7 = "indoor_outdoor_recognition_without_wifi".equals(this.t);
        c();
        com.obric.cae.location.util.d r13 = com.obric.cae.location.util.d.a();
        final boolean r14 = r13.o();
        if (r14 == false) goto L13;
    L16:
        this.s = null;
        this.p.execute(new $$Lambda$a$__FMQXko6ijcjKuVKRu_09tKh0(this, r3, r12, r17, r18, r7, r14));     // Catch: RejectedExecutionException -> L19
        return r12;
    L19:
        e = move-exception;
        if (r14 == true) goto L22;
        r13.b(false);
    L22:
        this.j.compareAndSet(r12, null);
        b();
        com.obric.cae.log.a.a("StarLocation-indoorCheck", "submit indoor check failed", e);
        return null;
    L13:
        if (r13.b(true) == true) goto L16;
        this.j.compareAndSet(r12, null);
        b();
        com.obric.cae.log.a.c("StarLocation-indoorCheck", "reject because location could not be enabled");
        return null;
    }

    public final void a(final int r7, com.obric.cae.libs.location.indoor.a r8) {
        com.obric.cae.libs.location.indoor.a r9 = (com.obric.cae.libs.location.indoor.a) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.cae.libs.location.indoor.a.class, "com.obric.memorydata.plugin");
        final IBinder r0 = r9.asBinder();
        IBinder.DeathRecipient r2 = new $$Lambda$a$iGmBT_Ecla3ZpKwNzngy43ELLs(this, r7, r0);
        l r3 = new l(r0, r9, r2, 0);
        r0.linkToDeath(r2, 0);     // Catch: Throwable -> L13
        l r10 = (l) ZeusTransformUtils.preCheckCast(this.n.put(Integer.valueOf(r7), r3), l.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L8;
        l.b(r10).unlinkToDeath(l.a(r10), 0);     // Catch: RuntimeException -> L16
    L8:
        if (r0.isBinderAlive() == false) goto L10;
        return;
    L10:
        if (this.n.remove(Integer.valueOf(r7), r3) == false) goto L25;
        r0.unlinkToDeath(r2, 0);     // Catch: RuntimeException -> L17
        return;
    L26:
        return;
    L25:
        return;
    L13:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-indoorCheck", "register indoor check callback failed, pid=" + r7, e);
    }

    public void a(Context r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        this.q = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r8.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        c();
        if (this.h.compareAndSet(false, true) == true) goto L26;
        return;
    L26:
        File r4 = new File(com.obric.cae.location.util.d.a().b(r8), "star_indoor_check.txt");     // Catch: Throwable -> L8
        r4.delete();     // Catch: Throwable -> L8
        r4.createNewFile();     // Catch: Throwable -> L8
        this.r = r4;     // Catch: Throwable -> L8
        com.obric.cae.log.a.c("StarLocation-indoorCheck", "init indoor check log file, file: " + this.r);     // Catch: Throwable -> L8
        com.obric.cae.log.a.a("indoor_check", this.r);     // Catch: Throwable -> L8
    L10:
        AIKernelPythonBridge.init(this.q, "default");
        Uri r1 = Settings.Global.getUriFor("cae_indoor_check_model");
        if (r1 == null) goto L13;
        ZeusProviderTransform.registerContentObserver(this.q.getContentResolver(), r1, false, new d(this), "com.obric.memorydata.plugin");
    L13:
        Context r2 = this.q;
        if (r2 == null) goto L28;
        String r9 = Settings.Global.getString(r2.getContentResolver(), "cae_indoor_check_model");
        String r3 = "indoor_outdoor_recognition_without_wifi";
        if ("indoor_outdoor_recognition_without_wifi".equalsIgnoreCase(r9) == true) goto L24;
        if (r9 != null) goto L21;
    L23:
        r3 = "indoor_outdoor_recognition";
        goto L24
    L21:
        if ("indoor_outdoor_recognition".equalsIgnoreCase(r9) == true) goto L23;
        com.obric.cae.log.a.c("StarLocation-indoorCheck", "ignore invalid indoor check model: ".concat(r9));
    L24:
        this.t = r3;
        b();
        return;
    L28:
        return;
    L8:
        e = move-exception;
        com.obric.cae.log.a.a("StarLocation-indoorCheck", "init indoor check log file failed", e);
        goto L10
    }

    public final void a(Context r6, String r7) {
        final Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.memorydata.plugin");
        if (r7.equals(this.j.get()) == true) goto L5;
        return;
    L5:
        final o r0 = (o) ZeusTransformUtils.preCheckCast(this.k.get(), o.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L8;
        return;
    L8:
        if (r0.f7255a.equals(r7) == true) goto L10;
        return;
    L10:
        if (r0.o == true) goto L16;
        TimeUnit r9 = TimeUnit.MILLISECONDS;
        o.a(r0, r9.toSeconds(System.currentTimeMillis()) - 1);
        r0.o = true;
        c(r8, r0);
        r0.x = this.p.schedule(new $$Lambda$a$RwH88vTpgqVetEmQf37gD4r6sg(this, r8, r0), d, r9);
        f(r8, r0);
        return;
    }

    public final void a(Context r20, final String r21, String r22, String r23, boolean r24, boolean r25) {
        final Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r20, Context.class, "com.obric.memorydata.plugin");
        final o r11 = new o(r21, r22, r23, r24, r25);
        this.k.set(r11);
        boolean r2 = true;
        long r5 = SystemClock.elapsedRealtime() + c;     // Catch: Throwable -> L32 RuntimeException -> L34
    L5:
        if (a(r10, r24) == true) goto L6;
        SystemClock.sleep(100);     // Catch: Throwable -> L32 RuntimeException -> L34
        if (SystemClock.elapsedRealtime() < r5) goto L5;
        boolean r6 = a(r10, r24);     // Catch: Throwable -> L32 RuntimeException -> L34
    L10:
        if (r6 == true) goto L16;
        String r0 = "scan resources not ready before timeout, sessionId=" + r21;     // Catch: Throwable -> L32 RuntimeException -> L34
    L12:
        com.obric.cae.log.a.c("StarLocation-indoorCheck", r0);     // Catch: Throwable -> L32 RuntimeException -> L34
        c(r10, r11);
        this.k.compareAndSet(r11, null);
        this.j.compareAndSet(r21, null);
        b();
        return;
    L16:
        if (d(r10, r11) == true) goto L18;
    L30:
        r0 = "start scan failed, sessionId=" + r21;     // Catch: Throwable -> L32 RuntimeException -> L34
        goto L12
    L18:
        if (e(r10, r11) == false) goto L30;
        if (a(r10, r11) == false) goto L30;
        if (r24 == false) goto L23;
    L25:
        ScheduledExecutorService r12 = this.p;     // Catch: Throwable -> L32 RuntimeException -> L34
        Runnable r13 = new $$Lambda$a$DjYiTdPz2cOtvj1QYP0HxyoRjrQ(this, r10, r11);     // Catch: Throwable -> L32 RuntimeException -> L34
        long r16 = f7231b;     // Catch: Throwable -> L32 RuntimeException -> L34
        TimeUnit r7 = TimeUnit.MILLISECONDS;     // Catch: Throwable -> L32 RuntimeException -> L34
        r11.w = r12.scheduleAtFixedRate(r13, r16, r16, r7);     // Catch: Throwable -> L32 RuntimeException -> L34
        this.p.schedule(new $$Lambda$a$1Ni64swqCYm_2O7ISj0EFbBUwQ4(this, r10, r21), f7230a, r7);     // Catch: Throwable -> L32 RuntimeException -> L34
        com.obric.cae.log.a.b("StarLocation-indoorCheck", "indoor check started, sessionId=" + r21 + ", withoutWifi=" + r24, this.r);     // Catch: RuntimeException -> L28 Throwable -> L40
        return;
    L28:
        e = e;
    L36:
        com.obric.cae.log.a.a("StarLocation-indoorCheck", "start indoor check exception, sessionId=" + r21, e);     // Catch: Throwable -> L40
        if (r2 == true) goto L51;
        c(r10, r11);
        this.k.compareAndSet(r11, null);
        this.j.compareAndSet(r21, null);
        b();
        return;
    L51:
        return;
    L40:
        th = th;
    L41:
        if (r2 == true) goto L43;
        c(r10, r11);
        this.k.compareAndSet(r11, null);
        this.j.compareAndSet(r21, null);
        b();
    L43:
        throw th;
    L23:
        if (b(r10, r11) == true) goto L25;
    L6:
        r6 = true;
    L34:
        e = e;
        r2 = false;
    L32:
        th = th;
        r2 = false;
        goto L41
    }

    public boolean a(String r2) {
        Context r0 = this.q;
        if (r0 != null) goto L5;
        String r1 = "unknown";
    L7:
        if (a(r1, r2) == null) goto L9;
        return true;
    L9:
        return false;
    L5:
        r1 = r0.getPackageName();
        goto L7
    }

    public final void b() {
        if (f() == false) goto L5;
        return;
    L5:
        if (this.i.compareAndSet(false, true) == false) goto L17;
        String r0 = this.t;
        String r1 = (String) ZeusTransformUtils.preCheckCast(this.l.get(), String.class, "com.obric.memorydata.plugin");
        if (r0.equals(r1) == false) goto L11;
        this.i.set(false);
        return;
    L11:
        if (r1 == null) goto L14;
        AIKernelPythonBridge.unloadPackageAsync(r1, new e(this, r1));
        return;
    L14:
        AIKernelPythonBridge.loadPackageWithResourceAsync(r0, new f(this, r0));
        return;
    }

    public final void c() {
        Context r7 = this.q;
        if (r7 == null) goto L34;
        boolean r5 = false;
        if (Build.VERSION.SDK_INT >= 31) goto L7;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L39;
        BluetoothManager r8 = (BluetoothManager) ZeusTransformUtils.preCheckCast(r7.getSystemService(BluetoothManager.class), BluetoothManager.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L18;
        BluetoothAdapter r9 = null;
    L19:
        if (r9 != null) goto L35;
        return;
    L35:
        Method r3 = BluetoothAdapter.class.getDeclaredMethod("isBleScanAlwaysAvailable", new Class[0]);     // Catch: Throwable -> L23
        r3.setAccessible(true);     // Catch: Throwable -> L23
        boolean r4 = Boolean.TRUE.equals(r3.invoke(r9, new Object[0]));     // Catch: Throwable -> L23
    L25:
        if (r4 == true) goto L37;
        String r10 = "BLE scan always available is disabled";
    L27:
        com.obric.cae.log.a.c("StarLocation-indoorCheck", r10);
        return;
    L37:
        Method r6 = BluetoothAdapter.class.getDeclaredMethod("enableBLE", new Class[0]);     // Catch: Throwable -> L31
        r6.setAccessible(true);     // Catch: Throwable -> L31
        r5 = Boolean.TRUE.equals(r6.invoke(r9, new Object[0]));     // Catch: Throwable -> L31
    L33:
        r10 = "enable BLE-only mode accepted=" + r5;
    L31:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-indoorCheck", "invoke failed", e);
    L23:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-indoorCheck", "invoke failed", e);
        r4 = false;
        goto L25
    L18:
        r9 = r8.getAdapter();
        goto L19
    L39:
        return;
    L7:
        if (r7.checkSelfPermission("android.permission.BLUETOOTH_SCAN") == 0) goto L9;
    L11:
        r2 = false;
        goto L13
    L9:
        if (r7.checkSelfPermission("android.permission.BLUETOOTH_CONNECT") != 0) goto L11;
    }

    public com.obric.cae.libs.location.indoor.b.a d() {
        return this.o;
    }

    public final boolean d(Context r4, o r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        BluetoothManager r0 = (BluetoothManager) ZeusTransformUtils.preCheckCast(r6.getSystemService(BluetoothManager.class), BluetoothManager.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        BluetoothAdapter r1 = null;
    L6:
        if (r1 != null) goto L8;
        BluetoothLeScanner r2 = null;
    L9:
        if (r2 != null) goto L12;
        return false;
    L12:
        g r3 = new g(r6, r5, this);
        r5.y = r2;
        r5.z = r3;
        r2.startScan(null, new ScanSettings.Builder().setScanMode(1).build(), r3);
        return true;
    L8:
        r2 = r1.getBluetoothLeScanner();
        goto L9
    L5:
        r1 = r0.getAdapter();
        goto L6
    }

    public void e() {
        Iterator<Integer> r0 = this.n.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        int r1 = ((Integer) ZeusTransformUtils.preCheckCast(r0.next(), Integer.class, "com.obric.memorydata.plugin")).intValue();
        l r2 = (l) ZeusTransformUtils.preCheckCast(this.n.remove(Integer.valueOf(r1)), l.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L4;
        r2.f7250a.unlinkToDeath(r2.c, 0);     // Catch: RuntimeException -> L11
        goto L4
    }

    public final boolean e(Context r11, final o r12) {
        LocationManager r13 = (LocationManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.memorydata.plugin")).getSystemService(LocationManager.class), LocationManager.class, "com.obric.memorydata.plugin");
        if (r13 != null) goto L5;
        return false;
    L5:
        LocationListener r7 = new $$Lambda$7wFYTdU01Z1NYr0WtXV0ne1EWrM(r12);
        h r1 = new h(r12);
        r12.A = r13;
        r12.B = r7;
        r12.C = r1;
        if (r13.registerGnssStatusCallback(this.p, r1) == true) goto L8;
        return false;
    L8:
        long r8 = f7231b;
        r13.requestLocationUpdates("fused", r8, 0.0f, this.p, r7);
        r13.requestLocationUpdates("gps", r8, 0.0f, this.p, r7);
        return true;
    }

    public final void f(Context r10, o r11) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        if (r11.f7255a.equals(this.j.get()) == true) goto L5;
        return;
    L5:
        if (r11.n == true) goto L28;
        monitor-enter(r11);
        m r3 = (m) ZeusTransformUtils.preCheckCast(r11.k.pollFirst(), m.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        monitor-exit(r11);
        if (r3 == null) goto L12;
        r11.n = true;
        r3.c++;
        String r4 = r11.q;
        Bundle r12 = new Bundle();
        r12.putString("raw_frame", r3.f7253b);
        r12.putString("state", r4);
        if (r11.d == false) goto L18;
        String r0 = "indoor_outdoor_recognition_without_wifi";
    L19:
        String r7 = r0;
        com.obric.cae.log.a.b("StarLocation-indoorCheck", "indoor check inference input, sessionId=" + r11.f7255a + ", timestampSec=" + r3.f7252a + ", businessName=" + r7 + ", businessVersion=" + ((String) ZeusTransformUtils.preCheckCast(this.m.get(), String.class, "com.obric.memorydata.plugin")) + ", rawFrame=" + r3.f7253b, this.r);
        AIKernelPythonBridge.runPackageAsync(r7, r12, new c(this, r11, r3, r4, r7, r6));
        return;
    L18:
        r0 = "indoor_outdoor_recognition";
        goto L19
    L12:
        if (r11.o == false) goto L27;
        g(r6, r11);
        return;
    L27:
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public boolean f() {
        if (this.j.get() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void g(Context r14, o r15) {
        Context r16 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
        String r11 = o.a(r15);
        if (r11.equals(this.j.get()) == true) goto L6;
        return;
    L6:
        if (o.e(r15) == null) goto L8;
        o.e(r15).cancel(false);
    L8:
        o.f(r15).clear();
        this.k.compareAndSet(r15, null);
        String r4 = o.g(r15);     // Catch: Throwable -> L25
        String r5 = o.h(r15);     // Catch: Throwable -> L25
        if (o.b(r15) == false) goto L13;
        String r3 = "indoor_outdoor_recognition_without_wifi";
    L14:
        com.obric.cae.location.report.d.a(r11, r4, r5, r3, (String) ZeusTransformUtils.preCheckCast(this.m.get(), String.class, "com.obric.memorydata.plugin"), o.c(r15), o.d(r15));     // Catch: Throwable -> L25
        if (o.c(r15) != null) goto L18;
        com.obric.cae.log.a.b("StarLocation-indoorCheck", "indoor check finished without result, sessionId=".concat(r11), this.r);     // Catch: Throwable -> L25
    L23:
        this.j.compareAndSet(r11, null);
        b();
        return;
    L18:
        if ("outdoor".equals(o.c(r15)) == false) goto L20;
        int r1 = 2;
    L21:
        com.obric.cae.log.a.b("StarLocation-indoorCheck", "indoor check finished, sessionId=" + r11 + ", label=" + o.c(r15) + ", probIndoor=" + o.d(r15), this.r);     // Catch: Throwable -> L25
        StarGeoCallback.notifyEngineStatusReportToAllUsers(r16, r1, o.i(r15));     // Catch: Throwable -> L25
        goto L23
    L20:
        r1 = 1;
        goto L21
    L13:
        r3 = "indoor_outdoor_recognition";
    L25:
        th = move-exception;
        this.j.compareAndSet(r11, null);
        b();
        throw th;
    }
}
