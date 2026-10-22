package com.obric.cae.location.geosdk.poi;

import android.R;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.annotation.LocationAnnotation;
import com.bytedance.bdlocation.callback.LocationSubmitNotification;
import com.bytedance.bdlocation.entity.PoiInfoEntity;
import com.bytedance.bdlocation.init.BDLocationAgent;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.crash.entity.EventBody;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiproactive.impl.livecard.ProactiveLiveCardDisplayTool;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.cae.userAware.datacollection.PoiAdspEventDispatcher;
import com.obric.cae.userAware.poi.PoiAdspTraceLogger;
import com.obric.cae.userAware.poi.PoiAwareBridge;
import com.obric.cae.userAware.poi.PoiWifiScanBridge;
import com.obric.cae.userAware.utils.MatrixDidUtils;
import com.obric.memorydata.database.entity.MemoryKeyInfoEntity;
import com.volcengine.zeus.transform.ZeusProviderTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class StarPoiManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final StarPoiManager f7164a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f7165b = null;
    public static final Set<String> c = null;
    public static final ConcurrentHashMap.KeySetView d = null;
    public static final long e = 0;
    public static final long f = 0;
    public static final long[] g = null;
    public static final long h = 0;
    public static final long i = 0;
    public static final long j = 0;
    public static final long k = 0;
    public volatile long A;
    public volatile String B;
    public volatile String C;
    public volatile com.obric.cae.location.geosdk.poi.c D;
    public volatile com.obric.cae.location.geosdk.poi.b E;
    public volatile boolean F;
    public volatile boolean G;
    public volatile boolean H;
    public volatile boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public volatile boolean f7166J;
    public volatile boolean K;
    public volatile boolean L;
    public volatile float M;
    public volatile int N;
    public volatile int O;
    public volatile long P;
    public PowerManager.WakeLock Q;
    public AlarmManager R;
    public PendingIntent S;
    public PendingIntent T;
    public PendingIntent U;
    public com.obric.cae.location.geosdk.poi.i V;
    public com.obric.cae.location.geosdk.poi.j W;
    public com.obric.cae.location.geosdk.poi.g X;
    public HandlerThread Y;
    public j Z;
    public int aA;
    public int aB;
    public long aC;
    public long aD;
    public int aE;
    public int aF;
    public String aG;
    public PoiWifiScanBridge aH;
    public volatile boolean aI;
    public volatile boolean aJ;
    public volatile int aK;
    public volatile String aL;
    public volatile e aM;
    public volatile Bundle aN;
    public volatile long aO;
    public volatile int aP;
    public volatile int aQ;
    public final o aR;
    public volatile boolean aS;
    public volatile boolean aT;
    public volatile int aU;
    public volatile long aV;
    public final AtomicInteger aW;
    public volatile i aX;
    public final a aY;
    public final b aZ;
    public com.obric.cae.location.geosdk.poi.h aa;
    public int ab;
    public int ac;
    public final AtomicBoolean ad;
    public volatile int ae;
    public volatile long af;
    public int ag;
    public boolean ah;
    public volatile int ai;
    public volatile int aj;
    public int ak;
    public long al;
    public long am;
    public int an;
    public long ao;
    public long ap;
    public int aq;
    public int ar;
    public long as;
    public volatile int at;
    public volatile boolean au;
    public PoiAwareBridge av;
    public int aw;
    public long ax;
    public int ay;
    public int az;
    public final com.obric.cae.location.geosdk.poi.f ba;
    public final HashMap bb;
    public final HashMap bc;
    public final d bd;
    public final com.obric.cae.libs.location.poi.d.a be;
    public final ConcurrentHashMap<Integer, f> l;
    public final AtomicBoolean m;
    public final AtomicBoolean n;
    public final AtomicBoolean o;
    public final AtomicBoolean p;
    public final AtomicBoolean q;
    public final ArrayDeque<String> r;
    public final ScheduledThreadPoolExecutor s;
    public volatile Context t;
    public volatile String u;
    public volatile String v;
    public volatile Bundle w;
    public volatile int x;
    public volatile long y;
    public volatile String z;

    /* JADX INFO: renamed from: com.obric.cae.location.geosdk.poi.StarPoiManager$1, reason: invalid class name */
    public class AnonymousClass1 extends com.obric.cae.libs.location.poi.d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ StarPoiManager f7167a;

        public AnonymousClass1(StarPoiManager r1) {
            this.f7167a = r1;
        }

        private static /* synthetic */ void b(Bundle r2) {
            Bundle r0 = r2.getBundle("entry");
            Bundle r3 = r2.getBundle("exit");
            if (r0 == null) goto L7;
            PoiAwareBridge r1 = StarPoiManager.f7164a.av;
            if (r1 == null) goto L7;
            r1.updateConfig(r0);
        L7:
            if (r3 == null) goto L12;
            PoiWifiScanBridge r4 = StarPoiManager.f7164a.aH;
            if (r4 == null) goto L13;
            r4.updateConfig(r3);
            return;
        L13:
            return;
        }

        public static /* synthetic */ void lambda$2EPD99RWnKAaUwRL28EHwqawvb0() {
            o();
        }

        public static /* synthetic */ void lambda$l680UTM_DEEf9t83UWSVRwK5e_w(Bundle r0) {
            b(r0);
        }

        /* JADX INFO: renamed from: lambda$uxt8zIXi-MLikomc64IeDXY4NAY, reason: not valid java name */
        public static /* synthetic */ void m385lambda$uxt8zIXiMLikomc64IeDXY4NAY() {
            n();
        }

        public static /* synthetic */ void lambda$y7sT1Ow1xETHOhNALzmp2RsQRJs() {
            m();
        }

        private static /* synthetic */ void m() {
            StarPoiManager r0 = StarPoiManager.f7164a;
            PoiAwareBridge r1 = r0.av;
            if (r1 == null) goto L5;
            r1.resetConfig();
        L5:
            PoiWifiScanBridge r2 = r0.aH;
            if (r2 == null) goto L9;
            r2.resetConfig();
            return;
        }

        private static /* synthetic */ void n() {
            StarPoiManager r0 = StarPoiManager.f7164a;
            PoiAwareBridge r1 = r0.av;
            if (r1 == null) goto L5;
            r1.requestConfigSnapshot();
        L5:
            PoiWifiScanBridge r2 = r0.aH;
            if (r2 == null) goto L9;
            r2.queryConfig();
            return;
        }

        private static /* synthetic */ void o() {
            StarPoiManager.f7164a.p();
        }

        @Override // com.obric.cae.libs.location.poi.d
        public void a() {
            StarPoiManager.f7164a.a(Binder.getCallingPid(), Binder.getCallingUid());
        }

        @Override // com.obric.cae.libs.location.poi.d
        public void a(int r9) {
            StarPoiManager r8 = StarPoiManager.f7164a;
            if (r8.m() == true) goto L5;
            com.obric.cae.log.a.d("StarLocation-PoiManager", "skip debug set state, poi detect disabled");
            return;
        L5:
            com.obric.cae.location.geosdk.poi.c r0 = com.obric.cae.location.geosdk.poi.c.f7219a;
            com.obric.cae.location.geosdk.poi.c[] r2 = com.obric.cae.location.geosdk.poi.c.values();
            int r3 = r2.length;
            int r4 = 0;
            int r5 = 0;
        L6:
            if (r5 >= r3) goto L11;
            com.obric.cae.location.geosdk.poi.c r6 = r2[r5];
            if (r6.ordinal() == r9) goto L9;
            r5 = r5 + 1;
            goto L6
        L9:
            r0 = r6;
        L11:
            com.obric.cae.log.a.f("StarLocation-PoiManager", "debug set state: " + r8.D + " -> " + r0);
            com.obric.cae.location.geosdk.poi.c r10 = com.obric.cae.location.geosdk.poi.c.d;
            boolean r1 = true;
            if (r0 != r10) goto L14;
        L27:
            if (r0 != r10) goto L29;
            com.obric.cae.location.geosdk.poi.b r11 = com.obric.cae.location.geosdk.poi.b.f7218b;
        L30:
            r8.a(r8.aw, "debug_manual_entry");
            r8.e("debug_manual_entry_reset");
            r8.d("debug_manual_entry_reset");
            if (r8.D != com.obric.cae.location.geosdk.poi.c.f7219a) goto L33;
            r8.b(com.obric.cae.location.geosdk.poi.c.c);
        L33:
            r8.b(r11);
            String r7 = "debug-manual-" + System.currentTimeMillis();
            PoiWifiScanBridge r12 = r8.aH;
            if (r12 == null) goto L36;
            r4 = r12.getSessionEpoch();
        L40:
            e r13 = new e(r7, r4);
            Bundle r14 = new Bundle();
            r14.putLong("timestamp", System.currentTimeMillis());
            r14.putString("poi_id", r7);
            r14.putString("poi_name", r7);
            r14.putBoolean("is_enter", true);
            r8.a(r13, r14);
            r8.a(r11);
            long r15 = System.currentTimeMillis();
            PoiAdspEventDispatcher.report(4, r15, "DEBUG_MANUAL_ENTRY:" + r11 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r15);
            String r16 = "AP DEBUG_MANUAL_ENTRY category=" + r11 + " poiId=" + r7;
        L41:
            r8.a(r16, r15);
            return;
        L36:
            PoiAwareBridge r17 = r8.av;
            if (r17 == null) goto L40;
            r4 = r17.getSessionEpoch();
            goto L40
        L29:
            r11 = com.obric.cae.location.geosdk.poi.b.c;
            goto L30
        L14:
            if (r0 == com.obric.cae.location.geosdk.poi.c.e) goto L27;
            com.obric.cae.location.geosdk.poi.c r18 = com.obric.cae.location.geosdk.poi.c.c;
            if (r0 != r18) goto L26;
            r8.a(r8.aw, "debug_manual_monitoring");
            r8.e("debug_manual_monitoring");
            r8.d("debug_manual_monitoring");
            if (r8.D == r18) goto L22;
            r1 = false;
        L22:
            r8.b(r18);
            r8.E = com.obric.cae.location.geosdk.poi.b.f7217a;
            r8.al = System.currentTimeMillis();
            if (r1 == false) goto L25;
            r8.c(0);
        L25:
            r15 = System.currentTimeMillis();
            PoiAdspEventDispatcher.report(5, r15, "DEBUG_MANUAL_MONITORING:" + r15);
            r16 = "AP DEBUG_MANUAL_MONITORING";
            goto L41
        L26:
            r8.b(r0);
        }

        @Override // com.obric.cae.libs.location.poi.d
        public void a(Bundle r2) {
            if (r2 != null) goto L4;
            return;
        L4:
            final Bundle r1 = new Bundle(r2);
            StarPoiManager.f7164a.Z.post(new $$Lambda$StarPoiManager$1$l680UTM_DEEf9t83UWSVRwK5e_w(r1));
        }

        @Override // com.obric.cae.libs.location.poi.d
        public void a(com.obric.cae.libs.location.poi.c r3) {
            com.obric.cae.libs.location.poi.c r2 = (com.obric.cae.libs.location.poi.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.cae.libs.location.poi.c.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L7;
            StarPoiManager.f7164a.a(Binder.getCallingPid(), Binder.getCallingUid(), r2);
            return;
        L7:
            throw new IllegalArgumentException("callback is null");
        }

        @Override // com.obric.cae.libs.location.poi.d
        public void a(boolean r2) {
            StarPoiManager.f7164a.I = r2;
            com.obric.cae.log.a.f("StarLocation-PoiManager", "setDebugBypassNearPoiCheck: " + r2);
        }

        @Override // com.obric.cae.libs.location.poi.d
        public Bundle b() {
            return StarPoiManager.f7164a.s();
        }

        @Override // com.obric.cae.libs.location.poi.d
        public void b(int r3) {
            StarPoiManager r2 = StarPoiManager.f7164a;
            if (r3 > 0) goto L5;
            r2.getClass();
            com.obric.cae.log.a.h("StarLocation-PoiManager", "ignore invalid stationary delay seconds: " + r3);
            return;
        L5:
            r2.ai = r3;
            r2.k();
            com.obric.cae.log.a.f("StarLocation-PoiManager", "setStationaryDelaySeconds: " + r3);
        }

        @Override // com.obric.cae.libs.location.poi.d
        public int c() {
            return StarPoiManager.f7164a.D.ordinal();
        }

        @Override // com.obric.cae.libs.location.poi.d
        public void c(int r2) {
            com.obric.cae.log.a.f("StarLocation-PoiManager", "ignore legacy trigger mode request=" + r2 + ", fixed=ADSP_ONLY");
        }

        @Override // com.obric.cae.libs.location.poi.d
        public Bundle d() {
            return StarPoiManager.f7164a.q();
        }

        @Override // com.obric.cae.libs.location.poi.d
        public void e() {
            StarPoiManager.f7164a.Z.post($$Lambda$StarPoiManager$1$2EPD99RWnKAaUwRL28EHwqawvb0.INSTANCE);
        }

        @Override // com.obric.cae.libs.location.poi.d
        public int f() {
            int r0 = StarPoiManager.f7164a.at;
            return 1;
        }

        @Override // com.obric.cae.libs.location.poi.d
        public Bundle g() {
            StarPoiManager r6 = StarPoiManager.f7164a;
            Bundle r0 = r6.q();
            ArrayDeque<String> r1 = r6.r;
            monitor-enter(r1);
            r0.putStringArrayList("poiArrivalLogs", new ArrayList(r6.r));     // Catch: Throwable -> L49
            monitor-exit(r1);     // Catch: Throwable -> L49
            r0.putInt("triggerMode", r6.at);
            int r2 = r6.at;
            boolean r3 = true;
            if (r2 != 1) goto L9;
            String r4 = "ADSP_ONLY";
        L13:
            r0.putString("triggerModeName", r4);
            if (r6.f() == false) goto L16;
            String r5 = "ADSP";
        L17:
            r0.putString("requestOwner", r5);
            r0.putBoolean("apTriggerEngineRunning", false);
            if (r6.au == true) goto L20;
        L22:
            boolean r7 = false;
        L23:
            r0.putBoolean("adspTriggerEngineRunning", r7);
            r0.putBoolean("poiAdspReady", r6.au);
            PoiAwareBridge r8 = r6.av;
            if (r8 != null) goto L26;
        L28:
            r3 = false;
        L29:
            r0.putBoolean("stateSynchronized", r3);
            r0.putInt("pendingAdspRequestId", r6.aw);
            r0.putString("activePoiId", r6.aL);
            if (r6.aM != null) goto L32;
            int r9 = 0;
        L33:
            r0.putInt("activePoiSessionEpoch", r9);
            r0.putInt("activePoiEntrySteps", r6.aP);
            r0.putInt("shadowVerificationCount", r6.aQ);
            r0.putString("shadowBudgetState", r6.aR.f7188a.name());
            i r10 = r6.aX;
            if (r10 != null) goto L36;
            int r11 = 0;
        L37:
            r0.putInt("pendingPoiQueryGeneration", r11);
            if (r10 != null) goto L40;
            int r12 = 0;
        L41:
            r0.putInt("pendingPoiQueryContext", r12);
            r0.putBoolean("timeoutRescuePending", r6.aS);
            r0.putBoolean("timeoutRescueUsed", r6.aT);
            r0.putInt("apCandidateCount", r6.az);
            r0.putInt("adspCandidateCount", r6.ay);
            r0.putInt("dualMatchCount", r6.aA);
            r0.putInt("dualMismatchCount", r6.aB);
            r0.putString("lastCompareResult", r6.aG);
            r0.putInt("latestHar", r6.aj);
            r0.putInt("latestSteps", r6.ab);
            r0.putInt("stationaryBaseSteps", r6.ag);
            r0.putInt("walkBaseSteps", r6.ac);
            r0.putBoolean("walkPending", false);
            r0.putBoolean("upDownRegistered", r6.ad.get());
            r0.putInt("latestUpDownType", r6.ae);
            r0.putLong("lastUpDownEventTimeMs", r6.af);
            if (r8 == null) goto L44;
            r0.putAll(r8.getDebugInfo());
            r0.putBundle("entryEffectiveConfig", r8.getEffectiveConfig());
        L44:
            PoiWifiScanBridge r13 = r6.aH;
            r0.putBoolean("wifiLeaveDesired", r6.aI);
            r0.putBoolean("wifiLeaveCommandSent", r6.aJ);
            r0.putInt("wifiLeaveConfiguredStoreType", r6.aK);
            if (r13 == null) goto L47;
            Bundle r14 = r13.getDebugInfo();
            r0.putBundle("exitEffectiveConfig", r13.getEffectiveConfig());
            PoiWifiScanBridge.Config r15 = r13.getConfig();
            r0.putBoolean("wifiLeaveConnected", r14.getBoolean("connected"));
            r0.putBoolean("wifiLeaveReady", r14.getBoolean("ready"));
            r0.putBoolean("wifiLeaveActive", r14.getBoolean("active"));
            r0.putBoolean("wifiLeaveScanning", r14.getBoolean("scanning"));
            r0.putInt("wifiLeaveReportMode", r15.reportMode);
            r0.putInt("wifiLeavePhase", r14.getInt("leavePhase"));
            r0.putInt("wifiLeaveAnchorScanCount", r14.getInt("anchorScanCount"));
            r0.putInt("wifiLeaveAnchorStableCount", r14.getInt("anchorStableCount"));
            r0.putInt("wifiLeaveCoreAnchorCount", r14.getInt("coreAnchorCount"));
            r0.putInt("wifiLeaveBackgroundAnchorCount", r14.getInt("backgroundAnchorCount"));
            r0.putInt("wifiLeaveAnchorOverflowCount", r14.getInt("anchorOverflowCount"));
            r0.putInt("wifiLeaveAnchorApMedian", r14.getInt("anchorApMedian"));
            r0.putInt("wifiLeaveCurrentApCount", r14.getInt("currentApCount"));
            r0.putInt("wifiLeaveSharedStableCount", r14.getInt("sharedStableCount"));
            r0.putInt("wifiLeaveSharedBssidCount", r14.getInt("sharedBssidCount"));
            r0.putInt("wifiLeaveStableRetentionPercent", r14.getInt("stableRetentionPercent"));
            r0.putInt("wifiLeaveRssiMedianDeltaDb", r14.getInt("rssiMedianDeltaDb"));
            r0.putInt("wifiLeaveDelta8Percent", r14.getInt("delta8Percent"));
            r0.putInt("wifiLeaveDensityPercent", r14.getInt("densityPercent"));
            r0.putInt("wifiLeaveRecent40Steps", r14.getInt("recent40Steps"));
            r0.putInt("wifiLeaveRecent60Steps", r14.getInt("recent60Steps"));
            r0.putInt("wifiLeaveStepsSinceStoreConfirmed", r14.getInt("stepsSinceStoreConfirmed"));
            r0.putBoolean("wifiLeaveIdentityVerifySent", r14.getBoolean("identityVerifySent"));
            r0.putInt("wifiLeaveContinuousMotionSeconds", r14.getInt("continuousMotionSeconds"));
            r0.putInt("wifiLeaveStationaryAfterMotionSeconds", r14.getInt("stationaryAfterMotionSeconds"));
            r0.putInt("wifiLeaveCandidateCount", r14.getInt("candidateCount"));
            r0.putBoolean("wifiLeaveSittableCandidateActive", r14.getBoolean("sittableCandidateActive"));
            r0.putBoolean("wifiLeaveSittableLockout", r14.getBoolean("sittableLockout"));
            r0.putBoolean("wifiLeaveTimeoutRescuePending", r6.aS);
            r0.putBoolean("wifiLeaveMigrated", r14.getBoolean("wifiMigrated"));
            r0.putBoolean("wifiLeaveStrongWifiExit", r14.getBoolean("strongWifiExit"));
            r0.putInt("wifiLeaveMigrationReason", r14.getInt("migrationReason"));
            r0.putInt("wifiLeaveStoreType", r14.getInt("storeType"));
            r0.putBoolean("wifiLeaveExited", r14.getBoolean("exited"));
            r0.putInt("wifiLeaveEventId", r14.getInt("leaveEventId"));
            r0.putInt("wifiLeaveReason", r14.getInt("leaveReason"));
            r0.putInt("wifiLeaveScanCount", r14.getInt("scanCount"));
            r0.putInt("wifiLeaveSuccessCount", r14.getInt("successCount"));
            r0.putInt("wifiLeaveFailureCount", r14.getInt("failureCount"));
            r0.putInt("wifiLeaveLastError", r14.getInt("lastError"));
            r0.putInt("wifiLeaveStrongAnchorMin", r15.minimumAnchorCountForStrongExit);
            r0.putInt("wifiLeaveStrongDensityMin", r15.minimumStrongExitDensityPercent);
            r0.putStringArrayList("wifiLeaveLogs", r14.getStringArrayList("logs"));
            r0.putString("wifiLeaveLogPath", r14.getString("logPath", ""));
        L47:
            r0.putInt("wifiLeaveEventId", r6.x);
            r0.putLong("wifiLeaveEventTimeMs", r6.y);
            r0.putString("wifiLeavePoiName", r6.z);
            r0.putString("wifiLeaveAoiName", r6.B);
            r0.putString("wifiLeavePoiCategory", r6.C);
            return r0;
        L40:
            r12 = r10.f7180b;
            goto L41
        L36:
            r11 = r10.f7179a;
            goto L37
        L32:
            r9 = r6.aM.f7173b;
            goto L33
        L26:
            if (r8.isStateSynchronized() == false) goto L28;
        L20:
            if (StarPoiManager.a(r6.D) == false) goto L22;
            r7 = true;
            goto L23
        L16:
            r5 = "AP";
            goto L17
        L9:
            if (r2 == 2) goto L11;
            r4 = "AP_ONLY";
            goto L13
        L11:
            r4 = "DUAL_COMPARE";
        L49:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.cae.libs.location.poi.d
        public void h() {
            StarPoiManager r4 = StarPoiManager.f7164a;
            com.obric.cae.location.geosdk.poi.c r0 = r4.D;
            boolean r1 = r4.aI;
            boolean r2 = r4.aJ;
            if (r0 != com.obric.cae.location.geosdk.poi.c.c) goto L6;
            g r3 = g.f7177b;
        L15:
            if (r3 != g.f7177b) goto L20;
            PoiAwareBridge r5 = r4.av;
            if (r5 == null) goto L25;
            r5.requestDebugSnapshot();
            return;
        L25:
            return;
        L20:
            if (r3 != g.c) goto L27;
            PoiWifiScanBridge r6 = r4.aH;
            if (r6 == null) goto L28;
            r6.queryStatus();
            return;
        L28:
            return;
        L27:
            return;
        L6:
            if (r0 != com.obric.cae.location.geosdk.poi.c.d) goto L8;
        L9:
            if (r1 == true) goto L13;
            if (r2 == true) goto L13;
        L12:
            r3 = g.f7176a;
        L13:
            r3 = g.c;
            goto L15
        L8:
            if (r0 != com.obric.cae.location.geosdk.poi.c.e) goto L12;
            goto L9
        }

        @Override // com.obric.cae.libs.location.poi.d
        public void i() {
            StarPoiManager r2 = StarPoiManager.f7164a;
            ArrayDeque<String> r0 = r2.r;
            monitor-enter(r0);
            r2.r.clear();     // Catch: Throwable -> L16
            monitor-exit(r0);     // Catch: Throwable -> L16
            PoiAwareBridge r1 = r2.av;
            if (r1 == null) goto L9;
            r1.clearDebugLogs();
        L9:
            PoiWifiScanBridge r3 = r2.aH;
            if (r3 == null) goto L12;
            r3.clearDebugLogs();
        L12:
            Context r4 = r2.t;
            if (r4 == null) goto L21;
            PoiAdspTraceLogger.getInstance(r4).clear();
            return;
        L21:
            return;
        L16:
            th = move-exception;
            throw th;
        }

        @Override // com.obric.cae.libs.location.poi.d
        public Bundle j() {
            Bundle r3 = new Bundle();
            StarPoiManager r0 = StarPoiManager.f7164a;
            PoiAwareBridge r1 = r0.av;
            PoiWifiScanBridge r2 = r0.aH;
            if (r1 != null) goto L5;
            Bundle r4 = Bundle.EMPTY;
        L6:
            r3.putBundle("entry", r4);
            if (r2 != null) goto L9;
            Bundle r5 = Bundle.EMPTY;
        L10:
            r3.putBundle("exit", r5);
            return r3;
        L9:
            r5 = r2.getEffectiveConfig();
            goto L10
        L5:
            r4 = r1.getEffectiveConfig();
            goto L6
        }

        @Override // com.obric.cae.libs.location.poi.d
        public void k() {
            StarPoiManager.f7164a.Z.post($$Lambda$StarPoiManager$1$uxt8zIXiMLikomc64IeDXY4NAY.INSTANCE);
        }

        @Override // com.obric.cae.libs.location.poi.d
        public void l() {
            StarPoiManager.f7164a.Z.post($$Lambda$StarPoiManager$1$y7sT1Ow1xETHOhNALzmp2RsQRJs.INSTANCE);
        }
    }

    public class a implements PoiAwareBridge.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StarPoiManager f7168a;

        public a(StarPoiManager r1) {
            this.f7168a = r1;
        }

        private void a() {
            StarPoiManager r2 = this.f7168a;
            r2.ba.f7224b = false;
            r2.au = false;
            com.obric.cae.log.a.h("StarLocation-PoiManager", "ADSP disconnected; waiting for bridge reconnect");
        }

        private void a(int r4) {
            PoiAwareBridge r0 = this.f7168a.av;
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isStateSynchronized() == true) goto L7;
            return;
        L7:
            if (r4 != r0.getStateVersion()) goto L26;
            this.f7168a.au = true;
            if (this.f7168a.f() == false) goto L22;
            StarPoiManager r1 = this.f7168a;
            AlarmManager r2 = r1.R;
            if (r2 == null) goto L16;
            PendingIntent r3 = r1.U;
            if (r3 == null) goto L16;
            r2.cancel(r3);
        L16:
            AlarmManager r5 = r1.R;
            if (r5 == null) goto L21;
            PendingIntent r6 = r1.T;
            if (r6 == null) goto L21;
            r5.cancel(r6);
        L21:
            r1.ag = -1;
            r1.ah = false;
            this.f7168a.o();
        L22:
            com.obric.cae.log.a.f("StarLocation-PoiManager", com.obric.cae.libs.statemachine.d.a("POI ADSP STATE_ACK v=", r4, ", mode=").append(this.f7168a.at).toString());
            return;
        }

        private void a(Bundle r3) {
            com.obric.cae.log.a.f("StarLocation-PoiManager", "ADSP transport detected details=" + r3);
            StarPoiManager r0 = this.f7168a;
            StarPoiManager r1 = StarPoiManager.f7164a;
            if (r0.f() == true) goto L5;
            return;
        L5:
            if (this.f7168a.c(r3) == false) goto L9;
            com.obric.cae.location.geosdk.poi.f r2 = this.f7168a.ba;
            r2.getClass();
            ((c) ZeusTransformUtils.preCheckCast(r2.f7223a, c.class, "com.obric.memorydata.plugin")).f7170a.b(com.obric.cae.location.geosdk.poi.c.f7219a);
            return;
        }

        private void a(Bundle r6, int r7) {
            StarPoiManager r0 = this.f7168a;
            StarPoiManager r1 = StarPoiManager.f7164a;
            PoiAwareBridge r2 = r0.av;
            if (r2 != null) goto L5;
        L11:
            boolean r8 = false;
        L12:
            StarPoiManager r5 = this.f7168a;
            if (r8 == true) goto L16;
            r5.c(r7);
            return;
        L16:
            com.obric.cae.location.geosdk.poi.f r9 = r5.ba;
            if (r9.f7224b == false) goto L20;
            com.obric.cae.location.geosdk.poi.f.a r10 = r9.f7223a;
            com.obric.cae.location.geosdk.poi.d[] r11 = com.obric.cae.location.geosdk.poi.d.f7221a;
            c r12 = (c) ZeusTransformUtils.preCheckCast(r10, c.class, "com.obric.memorydata.plugin");
            r12.getClass();
            r12.f7170a.a(r7, new Bundle());
            return;
        L20:
            return;
        L5:
            if (r6.getInt("sessionEpoch", -1) != r2.getSessionEpoch()) goto L11;
            if (r6.getInt("stateVersion", -1) != r2.getStateVersion()) goto L11;
            if (r6.getInt("state", -1) != r0.D.ordinal()) goto L11;
            r8 = true;
            goto L12
        }

        private void b() {
            StarPoiManager r0 = this.f7168a;
            r0.ba.f7224b = true;
            r0.au = false;
            this.f7168a.k();
            this.f7168a.c(0);
            com.obric.cae.log.a.f("StarLocation-PoiManager", "POI ADSP transport READY, waiting state ACK mode=" + this.f7168a.at);
        }

        /* JADX INFO: renamed from: lambda$2ZlyU8FUHtQ-BSaPEW2uQ3SLKUI, reason: not valid java name */
        public static /* synthetic */ void m386lambda$2ZlyU8FUHtQBSaPEW2uQ3SLKUI(a r0, int r1) {
            r0.a(r1);
        }

        public static /* synthetic */ void lambda$C4dRqQOL2d8Gm2L6q3XOpSYhR8c(a r0) {
            r0.a();
        }

        public static /* synthetic */ void lambda$K4cxsirkVOfAxbJnxZQLZALF5fw(a r0) {
            r0.b();
        }

        public static /* synthetic */ void lambda$QtR2XPNEWyNXT0ZYDozuT7Dlvn8(a r0, Bundle r1, int r2) {
            r0.a(r1, r2);
        }

        public static /* synthetic */ void lambda$TRN_D5OQYmiZchNTF6xM82KOsAQ(a r0, Bundle r1) {
            r0.a(r1);
        }

        @Override // com.obric.cae.userAware.poi.PoiAwareBridge.Listener
        public final void onBridgeStateChanged() {
        }

        @Override // com.obric.cae.userAware.poi.PoiAwareBridge.Listener
        public final void onDisconnected() {
            this.f7168a.Z.post(new $$Lambda$StarPoiManager$a$C4dRqQOL2d8Gm2L6q3XOpSYhR8c(this));
        }

        @Override // com.obric.cae.userAware.poi.PoiAwareBridge.Listener
        public final void onPoiRequest(final int r2, int r3, final Bundle r4) {
            this.f7168a.Z.post(new $$Lambda$StarPoiManager$a$QtR2XPNEWyNXT0ZYDozuT7Dlvn8(this, r4, r2));
        }

        @Override // com.obric.cae.userAware.poi.PoiAwareBridge.Listener
        public final void onReady() {
            this.f7168a.Z.post(new $$Lambda$StarPoiManager$a$K4cxsirkVOfAxbJnxZQLZALF5fw(this));
        }

        @Override // com.obric.cae.userAware.poi.PoiAwareBridge.Listener
        public final void onStateSynchronized(final int r3) {
            this.f7168a.Z.post(new $$Lambda$StarPoiManager$a$2ZlyU8FUHtQBSaPEW2uQ3SLKUI(this, r3));
        }

        @Override // com.obric.cae.userAware.poi.PoiAwareBridge.Listener
        public final void onTransportDetected(final Bundle r3) {
            this.f7168a.Z.post(new $$Lambda$StarPoiManager$a$TRN_D5OQYmiZchNTF6xM82KOsAQ(this, r3));
        }
    }

    public class b implements PoiWifiScanBridge.Listener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StarPoiManager f7169a;

        public b(StarPoiManager r1) {
            this.f7169a = r1;
        }

        private void a(Bundle r3) {
            com.obric.cae.location.geosdk.poi.f r2 = this.f7169a.ba;
            if (r2.f7224b == false) goto L6;
            StarPoiManager r4 = ((c) ZeusTransformUtils.preCheckCast(r2.f7223a, c.class, "com.obric.memorydata.plugin")).f7170a;
            StarPoiManager r0 = StarPoiManager.f7164a;
            r4.b(r3);
            return;
        }

        public static /* synthetic */ void a(StarPoiManager r1) {
            StarPoiManager r0 = StarPoiManager.f7164a;
            r1.h();
        }

        private void b(Bundle r14) {
            com.obric.cae.location.geosdk.poi.f r13 = this.f7169a.ba;
            if (r13.f7224b == false) goto L75;
            StarPoiManager r15 = ((c) ZeusTransformUtils.preCheckCast(r13.f7223a, c.class, "com.obric.memorydata.plugin")).f7170a;
            StarPoiManager r0 = StarPoiManager.f7164a;
            monitor-enter(r15);
        L72:
            th = move-exception;
            throw th;
        L7:
            if (r15.aI == false) goto L69;
            PoiWifiScanBridge r1 = r15.aH;     // Catch: Throwable -> L72
            if (r1 == null) goto L16;
            PoiWifiScanBridge.Config r3 = r1.getConfig();     // Catch: Throwable -> L72
            if (r14.getInt("sessionEpoch", -1) != r1.getSessionEpoch()) goto L16;
            if (r14.getInt("configVersion", -1) != r3.configVersion) goto L16;
            boolean r2 = true;
        L17:
            if (r2 == false) goto L69;
            Bundle r4 = r15.aN;     // Catch: Throwable -> L72
            r15.x = r14.getInt("eventId", 0);     // Catch: Throwable -> L72
            r15.y = System.currentTimeMillis();     // Catch: Throwable -> L72
            if (r4 != null) goto L22;
            String r5 = r15.aL;     // Catch: Throwable -> L72
        L23:
            r15.z = r5;     // Catch: Throwable -> L72
            if (r4 != null) goto L26;
            String r6 = "";
        L27:
            r15.B = r6;     // Catch: Throwable -> L72
            r15.C = r15.E.name();     // Catch: Throwable -> L72
            Bundle r7 = new Bundle(r14);     // Catch: Throwable -> L72
            r7.putString("poiName", r15.z);     // Catch: Throwable -> L72
            r7.putString("aoiName", r15.B);     // Catch: Throwable -> L72
            r15.c("wifi_scan");     // Catch: Throwable -> L72
            r15.a(r15.aw, "leave_confirmed");     // Catch: Throwable -> L72
            r15.e("leave_confirmed");     // Catch: Throwable -> L72
            r15.d("leave_confirmed");     // Catch: Throwable -> L72
            r15.E = com.obric.cae.location.geosdk.poi.b.f7217a;     // Catch: Throwable -> L72
            com.obric.cae.log.a.f("StarLocation-PoiManager", "POI_WIFI leave confirmed, transition to MONITORING details=" + r14);     // Catch: Throwable -> L72
            Context r16 = r15.t;     // Catch: Throwable -> L72
            if (r16 == null) goto L68;
            int r8 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L72
            if (r8 >= 33) goto L32;
        L34:
            NotificationManager r9 = (NotificationManager) ZeusTransformUtils.preCheckCast(r16.getSystemService("notification"), NotificationManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L72
            if (r9 == null) goto L68;
            if (r8 < 26) goto L41;
            NotificationChannel r10 = new NotificationChannel("poi_wifi_leave_events", "POI离店事件", 4);     // Catch: Throwable -> L72
            r10.setDescription("POI Wi-Fi离店检测确认事件");     // Catch: Throwable -> L72
            r9.createNotificationChannel(r10);     // Catch: Throwable -> L72
        L41:
            Intent r11 = r16.getPackageManager().getLaunchIntentForPackage(r16.getPackageName());     // Catch: Throwable -> L72
            PendingIntent r12 = null;
            if (r11 == null) goto L44;
            r11.addFlags(603979776);     // Catch: Throwable -> L72
            r12 = PendingIntent.getActivity(r16, 0, r11, 201326592);     // Catch: Throwable -> L72
        L44:
            int r17 = r7.getInt("eventId", 0);     // Catch: Throwable -> L72
            String r18 = r7.getString("aoiName", "") + " " + r7.getString("poiName", "");     // Catch: Throwable -> L72
            StringBuilder r19 = new StringBuilder("离开店铺");     // Catch: Throwable -> L72
            if (r18.trim().isEmpty() == false) goto L47;
            String r20 = "";
        L48:
            StringBuilder r21 = r19.append(r20).append("，原因=");     // Catch: Throwable -> L72
            int r110 = r7.getInt(InfoRequestQPSOptTraceLogger.REASON, 0);     // Catch: Throwable -> L72
            if (r110 != 1) goto L51;
            String r22 = "RSSI_SHIFT";
        L60:
            String r23 = r21.append(r22).append("，稳定AP保留=").append(r7.getInt("stableRetentionPercent", 0)).append("%，RSSI变化>=8dB=").append(r7.getInt("delta8Percent", 0)).append("%，步数=").append(r7.getInt("recent40Steps", 0)).append("/").append(r7.getInt("recent60Steps", 0)).toString();     // Catch: Throwable -> L72
            if (r8 < 26) goto L63;
            Notification.Builder r24 = new Notification.Builder(r16, "poi_wifi_leave_events");     // Catch: Throwable -> L72
        L64:
            r24.setSmallIcon(R.drawable.stat_notify_more).setContentTitle("Poi到店感知").setContentText(r23).setStyle(new Notification.BigTextStyle().bigText(r23)).setAutoCancel(true).setPriority(1);     // Catch: Throwable -> L72
            if (r12 == null) goto L67;
            r24.setContentIntent(r12);     // Catch: Throwable -> L72
        L67:
            r9.notify("poi_wifi_leave_events", Math.abs(r17) + 20260800, r24.build());     // Catch: Throwable -> L72
            goto L68
        L63:
            r24 = new Notification.Builder(r16);     // Catch: Throwable -> L72
            goto L64
        L51:
            if (r110 != 2) goto L53;
            r22 = "LOW_RETAIN";
            goto L60
        L53:
            if (r110 == 3) goto L57;
            if (r110 == 4) goto L56;
            r22 = "UNKNOWN(" + r110 + ")";     // Catch: Throwable -> L72
            goto L60
        L56:
            r22 = "SITTABLE_SUSTAINED_MOTION";
            goto L60
        L57:
            r22 = "WIFI_MOTION_CONFIRMED";
            goto L60
        L47:
            r20 = "：" + r18.trim();     // Catch: Throwable -> L72
            goto L48
        L32:
            if (r16.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) goto L34;
            com.obric.cae.log.a.h("PoiWifiLeaveNotification", "skip leave notification without POST_NOTIFICATIONS");     // Catch: Throwable -> L72
        L68:
            r15.b(com.obric.cae.location.geosdk.poi.c.c);     // Catch: Throwable -> L72
        L70:
            monitor-exit(r15);
            return;
        L26:
            r6 = r4.getString("aoi_name", "");     // Catch: Throwable -> L72
            goto L27
        L22:
            r5 = r4.getString("poi_name", r15.aL);     // Catch: Throwable -> L72
        L16:
            r2 = false;
        L69:
            com.obric.cae.log.a.d("StarLocation-PoiManager", "ignore non-production POI_WIFI leave event=" + r14);     // Catch: Throwable -> L72
            goto L70
        }

        /* JADX INFO: renamed from: lambda$Ebr0Xts-mpJG5XxGO-PSJijnFSQ, reason: not valid java name */
        public static /* synthetic */ void m387lambda$Ebr0XtsmpJG5XxGOPSJijnFSQ(b r0, Bundle r1) {
            r0.a(r1);
        }

        /* JADX INFO: renamed from: lambda$Sr-8FButnabqdzlMrZ6Ch7C061M, reason: not valid java name */
        public static /* synthetic */ void m388lambda$Sr8FButnabqdzlMrZ6Ch7C061M(b r0, Bundle r1) {
            r0.b(r1);
        }

        @Override // com.obric.cae.userAware.poi.PoiWifiScanBridge.Listener
        public final void onWifiIdentityVerificationRequested(final Bundle r3) {
            j r0 = this.f7169a.Z;
            if (r0 == null) goto L6;
            r0.post(new $$Lambda$StarPoiManager$b$Ebr0XtsmpJG5XxGOPSJijnFSQ(this, r3));
            return;
        }

        @Override // com.obric.cae.userAware.poi.PoiWifiScanBridge.Listener
        public final void onWifiLeaveDetected(final Bundle r3) {
            j r0 = this.f7169a.Z;
            if (r0 == null) goto L6;
            r0.post(new $$Lambda$StarPoiManager$b$Sr8FButnabqdzlMrZ6Ch7C061M(this, r3));
            return;
        }

        @Override // com.obric.cae.userAware.poi.PoiWifiScanBridge.Listener
        public final void onWifiScanStateChanged() {
            final StarPoiManager r2 = this.f7169a;
            j r0 = r2.Z;
            if (r0 == null) goto L6;
            r0.post(new $$Lambda$lejBd8LvD9lPbeI8o95cmjhJyoE(r2));
            return;
        }
    }

    public class c implements com.obric.cae.location.geosdk.poi.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StarPoiManager f7170a;

        public c(StarPoiManager r1) {
            this.f7170a = r1;
        }
    }

    public class d implements LocationSubmitNotification {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StarPoiManager f7171a;

        public d(StarPoiManager r1) {
            this.f7171a = r1;
        }

        @Override // com.bytedance.bdlocation.callback.LocationSubmitNotification
        public final void onSubmitListener(BDLocation r2) {
            StarPoiManager r1 = this.f7171a;
            StarPoiManager r0 = StarPoiManager.f7164a;
            r1.a(r2);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f7172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7173b;

        public e(String r1, int r2) {
            this.f7172a = r1;
            this.f7173b = r2;
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.memorydata.plugin");
            if (this.f7173b != r6.f7173b) goto L14;
            if (this.f7172a.equals(r6.f7172a) == false) goto L14;
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            return Objects.hash(new Object[]{this.f7172a, Integer.valueOf(this.f7173b)});
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.obric.cae.libs.location.poi.c f7174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final IBinder.DeathRecipient f7175b;

        public f(com.obric.cae.libs.location.poi.c r3, IBinder.DeathRecipient r4) {
            com.obric.cae.libs.location.poi.c r5 = (com.obric.cae.libs.location.poi.c) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.cae.libs.location.poi.c.class, "com.obric.memorydata.plugin");
            IBinder.DeathRecipient r6 = (IBinder.DeathRecipient) ZeusTransformUtils.wrapperContextForParams(r4, IBinder.DeathRecipient.class, "com.obric.memorydata.plugin");
            this.f7174a = r5;
            this.f7175b = r6;
        }
    }

    public static final enum g extends Enum<g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f7176a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final g f7177b = null;
        public static final g c = null;
        public static final /* synthetic */ g[] d = null;

        static {
            g r0 = new g("NONE", 0);
            f7176a = r0;
            g r1 = new g("POI_AWARE", 1);
            f7177b = r1;
            g r3 = new g("POI_WIFI_SCAN", 2);
            c = r3;
            d = new g[]{r0, r1, r3};
        }

        public g(String r1, int r2) {
            super(r1, r2);
        }

        public static g valueOf(String r2) {
            return (g) ZeusTransformUtils.preCheckCast(Enum.valueOf(g.class, r2), g.class, "com.obric.memorydata.plugin");
        }

        public static g[] values() {
            return (g[]) ZeusTransformUtils.preCheckCast(d.clone(), g[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f7178a;

        public h() {
        }

        public final synchronized void a(Runnable r3, Runnable r4, Runnable r5, Runnable r6) {
            monitor-enter(this);
            Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
            Runnable r8 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
            Runnable r9 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
            Runnable r10 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
            if (this.f7178a == false) goto L8;
            monitor-exit(this);
            return;
        L8:
            this.f7178a = true;     // Catch: Throwable -> L11
            r7.run();     // Catch: Throwable -> L11
            r8.run();     // Catch: Throwable -> L11
            r9.run();     // Catch: Throwable -> L11
            r10.run();     // Catch: Throwable -> L11
            monitor-exit(this);
            return;
        L11:
            th = move-exception;
            throw th;
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7179a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f7180b;
        public final long c;
        public final long d;
        public final long e;
        public final e f;
        public boolean g;

        public i(int r1, int r2, long r3, long r5, long r7, e r9) {
            this.f7179a = r1;
            this.f7180b = r2;
            this.c = r3;
            this.d = r5;
            this.e = r7;
            this.f = r9;
        }
    }

    public class j extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StarPoiManager f7181a;

        public j(StarPoiManager r1, Looper r2) {
            this.f7181a = r1;
            super(r2);
        }

        public final void a() {
            if (this.f7181a.F == false) goto L5;
            StarPoiManager r0 = this.f7181a;
            com.obric.cae.location.geosdk.poi.c r1 = r0.D;
            r0.getClass();
        L5:
            com.obric.cae.log.a.d("StarLocation-PoiManager", "skip stationary delayed query, stationary=" + this.f7181a.F + ", state=" + this.f7181a.D + ", actionTriggered=" + this.f7181a.ah);
        }

        public final void a(int r6) {
            StarPoiManager r0 = this.f7181a;
            StarPoiManager r1 = StarPoiManager.f7164a;
            r0.getClass();
            if (StarPoiManager.a(r6) == false) goto L6;
            a(1, false);
            this.f7181a.b(com.obric.cae.location.geosdk.poi.c.f7219a);
            return;
        L6:
            if (r6 != 0) goto L8;
            boolean r7 = true;
        L9:
            if (r7 == true) goto L24;
            com.obric.cae.location.geosdk.poi.c r2 = this.f7181a.D;
            com.obric.cae.location.geosdk.poi.c r3 = com.obric.cae.location.geosdk.poi.c.f7219a;
            if (r2 == r3) goto L24;
            StarPoiManager r4 = this.f7181a;
            com.obric.cae.location.geosdk.poi.c r5 = r4.D;
            if (r5 != r3) goto L15;
        L18:
            boolean r8 = true;
        L19:
            if (r8 == false) goto L24;
            if (r4.ad.compareAndSet(false, true) == false) goto L24;
            UserAwareManager.getInstance().getSensorCollectManager().registerUpDownStairSensor();
            goto L24
        L15:
            if (r5 == com.obric.cae.location.geosdk.poi.c.f7220b) goto L18;
            r8 = false;
        L24:
            a(1, r7);
            if (this.f7181a.D != com.obric.cae.location.geosdk.poi.c.f7220b) goto L28;
            this.f7181a.u();
            return;
        L28:
            return;
        L8:
            r7 = false;
            goto L9
        }

        public final void a(int r4, long r5) {
            com.obric.cae.log.a.d("StarLocation-PoiManager", "handleCellPoiStatusChanged cellPoiType=" + r4 + ", cellid=" + r5 + ", currentCellId=" + this.f7181a.am);
            StarPoiManager r0 = this.f7181a;
            r0.an = r4;
            if ((r4 & 2) == 0) goto L5;
            boolean r6 = true;
        L6:
            if (r6 == false) goto L11;
            r0.am = r5;
            if (r0.D != com.obric.cae.location.geosdk.poi.c.f7219a) goto L14;
            this.f7181a.b(com.obric.cae.location.geosdk.poi.c.f7220b);
            return;
        L14:
            return;
        L11:
            if (r5 != r0.am) goto L16;
            r0.b(com.obric.cae.location.geosdk.poi.c.f7219a);
            return;
        L16:
            return;
        L5:
            r6 = false;
            goto L6
        }

        public final void a(int r9, boolean r10) {
            StarPoiManager r0 = this.f7181a;
            StarPoiManager r1 = StarPoiManager.f7164a;
            r0.getClass();
            boolean r2 = true;
            if (r9 != 1) goto L8;
            this.f7181a.G = r10;
            if (r10 == true) goto L10;
            this.f7181a.H = false;
        L10:
            boolean r11 = this.f7181a.F;
            this.f7181a.getClass();
            this.f7181a.getClass();
            if (this.f7181a.G == false) goto L13;
        L16:
            this.f7181a.F = r2;
            StringBuilder r12 = com.obric.cae.libs.statemachine.d.a("updateStationaryState source=", r9, ", har=").append(this.f7181a.G).append(", step=").append(this.f7181a.H).append(", ").append(r11).append(" -> ").append(r2).append(", state=").append(this.f7181a.D).append(", actionTriggered=").append(this.f7181a.ah).append(", pendingWalkStepQuery=false");
            this.f7181a.getClass();
            com.obric.cae.log.a.d("StarLocation-PoiManager", r12.toString());
            StarPoiManager r13 = this.f7181a;
            if (r2 == true) goto L27;
            AlarmManager r3 = r13.R;
            if (r3 == null) goto L23;
            PendingIntent r14 = r13.U;
            if (r14 == null) goto L23;
            r3.cancel(r14);
        L23:
            StarPoiManager r8 = this.f7181a;
            r8.ah = false;
            if (r11 == false) goto L62;
            com.obric.cae.location.geosdk.poi.c r15 = r8.D;
            return;
        L62:
            return;
        L27:
            com.obric.cae.location.geosdk.poi.c r16 = r13.D;
            if (r11 == false) goto L30;
            return;
        L30:
            StarPoiManager r17 = this.f7181a;
            r17.getClass();
            if (r17.a(System.currentTimeMillis()) == false) goto L34;
            com.obric.cae.log.a.d("StarLocation-PoiManager", "skip stationary query in up/down stage, upDownType=" + this.f7181a.ae + ", lastUpDownEventTimeMs=" + this.f7181a.af);
            this.f7181a.o();
            return;
        L34:
            this.f7181a.o();
            if (this.f7181a.D != com.obric.cae.location.geosdk.poi.c.c) goto L37;
        L40:
            this.f7181a.getClass();
            if (this.f7181a.D != com.obric.cae.location.geosdk.poi.c.e) goto L43;
            this.f7181a.getClass();
        L43:
            StarPoiManager r18 = this.f7181a;
            if (r18.m() == true) goto L47;
            return;
        L47:
            if (r18.a(System.currentTimeMillis()) == false) goto L50;
            StringBuilder r19 = new StringBuilder("skip stationary delayed query in up/down stage, upDownType=").append(r18.ae).append(", lastUpDownEventTimeMs=").append(r18.af);
        L49:
            com.obric.cae.log.a.d("StarLocation-PoiManager", r19.toString());
            return;
        L50:
            AlarmManager r20 = r18.R;
            if (r20 == null) goto L55;
            PendingIntent r110 = r18.U;
            if (r110 == null) goto L55;
            r20.cancel(r110);
        L55:
            int r21 = r18.ai;
            long r4 = TimeUnit.SECONDS.toMillis(r21);
            AlarmManager r111 = r18.R;
            if (r111 != null) goto L58;
        L60:
            r19 = com.obric.cae.libs.statemachine.d.a("scheduleStationaryDelayedQuery delaySeconds=", r21, ", state=").append(r18.D);
            goto L49
        L58:
            if (r18.U == null) goto L60;
            r111.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + r4, r18.U);
            goto L60
        L37:
            if (this.f7181a.D == com.obric.cae.location.geosdk.poi.c.d) goto L40;
            if (this.f7181a.D == com.obric.cae.location.geosdk.poi.c.e) goto L40;
            return;
        L13:
            if (this.f7181a.H == true) goto L16;
            r2 = false;
            goto L16
        L8:
            if (r9 != 2) goto L10;
            this.f7181a.H = r10;
            goto L10
        }

        @Override // android.os.Handler
        public final void handleMessage(Message r5) {
            com.obric.cae.log.a.d("StarLocation-PoiManager", "handleMessage what=" + r5.what);
            StarPoiManager r0 = this.f7181a;     // Catch: Throwable -> L55
            StarPoiManager r2 = StarPoiManager.f7164a;     // Catch: Throwable -> L55
            if (r0.m() == true) goto L8;
            this.f7181a.e();
            return;
        L8:
            switch(r5.what) {
                case 1: goto L53;
                case 2: goto L52;
                case 3: goto L43;
                case 4: goto L34;
                case 5: goto L28;
                case 6: goto L26;
                case 7: goto L23;
                case 8: goto L11;
                case 9: goto L10;
                default: goto L54;
            };     // Catch: Throwable -> L55
        L10:
            a();     // Catch: Throwable -> L55
            goto L54
        L11:
            com.obric.cae.location.geosdk.poi.c r6 = this.f7181a.D;     // Catch: Throwable -> L55
            StarPoiManager r7 = this.f7181a;     // Catch: Throwable -> L55
            AlarmManager r1 = r7.R;     // Catch: Throwable -> L55
            if (r1 == null) goto L16;
            PendingIntent r3 = r7.U;     // Catch: Throwable -> L55
            if (r3 == null) goto L16;
            r1.cancel(r3);     // Catch: Throwable -> L55
        L16:
            AlarmManager r4 = r7.R;     // Catch: Throwable -> L55
            if (r4 == null) goto L21;
            PendingIntent r8 = r7.T;     // Catch: Throwable -> L55
            if (r8 == null) goto L21;
            r4.cancel(r8);     // Catch: Throwable -> L55
        L21:
            r7.ag = -1;     // Catch: Throwable -> L55
            r7.ah = false;     // Catch: Throwable -> L55
            goto L54
        L26:
            a(r5.arg1, ((Long) ZeusTransformUtils.preCheckCast(r5.obj, Long.class, "com.obric.memorydata.plugin")).longValue());     // Catch: Throwable -> L55
            goto L54
        L52:
            a(r5.arg1);     // Catch: Throwable -> L55
            goto L54
        L53:
            this.f7181a.u();     // Catch: Throwable -> L55
        L54:
            StarPoiManager r9 = this.f7181a;
        L58:
            r9.e();
            return;
        L23:
            if (this.f7181a.D != com.obric.cae.location.geosdk.poi.c.f7220b) goto L54;
            StarPoiManager r10 = this.f7181a;     // Catch: Throwable -> L55
            r10.ak = 0;     // Catch: Throwable -> L55
        L25:
            StarPoiManager.a(r10);     // Catch: Throwable -> L55
            goto L54
        L28:
            if (this.f7181a.D != com.obric.cae.location.geosdk.poi.c.f7219a) goto L31;
            this.f7181a.b(com.obric.cae.location.geosdk.poi.c.f7220b);     // Catch: Throwable -> L55
        L31:
            if (this.f7181a.D != com.obric.cae.location.geosdk.poi.c.f7220b) goto L54;
            r10 = this.f7181a;     // Catch: Throwable -> L55
            r10.ak = 0;     // Catch: Throwable -> L55
            goto L25
        L34:
            if (r5.arg1 == 0) goto L36;
            this.f7181a.b(com.obric.cae.location.geosdk.poi.c.f7219a);     // Catch: Throwable -> L55
            goto L54
        L36:
            if (this.f7181a.D != com.obric.cae.location.geosdk.poi.c.f7219a) goto L39;
            this.f7181a.b(com.obric.cae.location.geosdk.poi.c.f7220b);     // Catch: Throwable -> L55
        L39:
            if (this.f7181a.D != com.obric.cae.location.geosdk.poi.c.f7220b) goto L54;
            r10 = this.f7181a;     // Catch: Throwable -> L55
            r10.ak = 0;     // Catch: Throwable -> L55
            goto L25
        L43:
            if (this.f7181a.D == com.obric.cae.location.geosdk.poi.c.f7220b) goto L49;
            StarPoiManager r11 = this.f7181a;     // Catch: Throwable -> L55
            AlarmManager r12 = r11.R;     // Catch: Throwable -> L55
            if (r12 == null) goto L54;
            PendingIntent r13 = r11.S;     // Catch: Throwable -> L55
            if (r13 == null) goto L54;
            r12.cancel(r13);     // Catch: Throwable -> L55
            goto L54
        L49:
            this.f7181a.u();     // Catch: Throwable -> L55
            r10 = this.f7181a;     // Catch: Throwable -> L55
            int r14 = r10.ak;     // Catch: Throwable -> L55
            if (r14 >= StarPoiManager.g.length) goto L25;
            r10.ak = r14 + 1;     // Catch: Throwable -> L55
        L55:
            th = move-exception;
            com.obric.cae.log.a.b("StarLocation-PoiManager", "handleMessage failed", th);     // Catch: Throwable -> L60
            r9 = this.f7181a;
            StarPoiManager r15 = StarPoiManager.f7164a;
        L60:
            th = move-exception;
            StarPoiManager r16 = this.f7181a;
            StarPoiManager r17 = StarPoiManager.f7164a;
            r16.e();
            throw th;
        }
    }

    public static final enum k extends Enum<k> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final k f7182a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final k f7183b = null;
        public static final k c = null;
        public static final /* synthetic */ k[] d = null;

        static {
            k r0 = new k("KEEP_CURRENT", 0);
            f7182a = r0;
            k r1 = new k("HANDOFF", 1);
            f7183b = r1;
            k r3 = new k("APPLY_RESULT", 2);
            c = r3;
            d = new k[]{r0, r1, r3};
        }

        public k(String r1, int r2) {
            super(r1, r2);
        }

        public static k valueOf(String r2) {
            return (k) ZeusTransformUtils.preCheckCast(Enum.valueOf(k.class, r2), k.class, "com.obric.memorydata.plugin");
        }

        public static k[] values() {
            return (k[]) ZeusTransformUtils.preCheckCast(d.clone(), k[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final class l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final m f7184a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final com.obric.cae.location.geosdk.poi.b f7185b;

        public l(m r1, com.obric.cae.location.geosdk.poi.b r2) {
            this.f7184a = r1;
            this.f7185b = r2;
        }
    }

    public static final enum m extends Enum<m> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final m f7186a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final m f7187b = null;
        public static final m c = null;
        public static final m d = null;
        public static final /* synthetic */ m[] e = null;

        static {
            m r0 = new m("INVALID", 0);
            f7186a = r0;
            m r1 = new m("LOW_CONFIDENCE", 1);
            f7187b = r1;
            m r3 = new m("TRUSTED_UNKNOWN", 2);
            c = r3;
            m r5 = new m("TRUSTED_STORE", 3);
            d = r5;
            e = new m[]{r0, r1, r3, r5};
        }

        public m(String r1, int r2) {
            super(r1, r2);
        }

        public static m valueOf(String r2) {
            return (m) ZeusTransformUtils.preCheckCast(Enum.valueOf(m.class, r2), m.class, "com.obric.memorydata.plugin");
        }

        public static m[] values() {
            return (m[]) ZeusTransformUtils.preCheckCast(e.clone(), m[].class, "com.obric.memorydata.plugin");
        }
    }

    public static final class n implements ThreadFactory {
        public n() {
        }

        public /* synthetic */ n(int r1) {
            this();
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable r2) {
            Thread r3 = new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"), "star-poi-task");
            r3.setPriority(4);
            return r3;
        }
    }

    public static final class o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public p f7188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public e f7189b;
        public long c;

        public o() {
            this.f7188a = p.f7190a;
            this.c = -1;
        }
    }

    public static final enum p extends Enum<p> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final p f7190a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final p f7191b = null;
        public static final p c = null;
        public static final /* synthetic */ p[] d = null;

        static {
            p r0 = new p("AVAILABLE", 0);
            f7190a = r0;
            p r1 = new p("RESERVED", 1);
            f7191b = r1;
            p r3 = new p("CONSUMED", 2);
            c = r3;
            d = new p[]{r0, r1, r3};
        }

        public p(String r1, int r2) {
            super(r1, r2);
        }

        public static p valueOf(String r2) {
            return (p) ZeusTransformUtils.preCheckCast(Enum.valueOf(p.class, r2), p.class, "com.obric.memorydata.plugin");
        }

        public static p[] values() {
            return (p[]) ZeusTransformUtils.preCheckCast(d.clone(), p[].class, "com.obric.memorydata.plugin");
        }
    }

    static {
        f7164a = new StarPoiManager();
        f7165b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"stepBucketIntervalMs", "bucketCount", "entryStepThreshold", "requiredLowChecks", "harHoldSeconds", "harGuardStepThreshold", "eventAckTimeoutSeconds", "retryBackoffInitialSeconds", "retryBackoffMaxSeconds"})));
        c = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"scanWatchdogSeconds", "eventAckTimeoutSeconds", "retryBackoffInitialSeconds", "retryBackoffMaxSeconds", "minimumAnchorCountForStrongExit", "minimumStrongExitDensityPercent", "anchorFrameCount", "anchorMinHits", "anchorMaxMadDb", "anchorMinStableCount", "coreWeightQuarters", "backgroundWeightQuarters", "anchorIntervalSeconds", "monitorIntervalSeconds", "followUpIntervalSeconds", "gateCheckSeconds", "scanWake60sMinSteps", "sittableStart60sSteps", "sittableKeep60sSteps", "walkableFirst40sSteps", "walkableFirst60sSteps", "migrationConfirmFrames", "sharedStableMinCount", "rssiMedianDeltaMinDb", "delta8MinPercent", "rssiShiftDensityMinPercent", "lowRetainAnchorMinCount", "lowRetainMaxPercent", "lowRetainDensityMinPercent", "strongExitMaxSharedBssid", "coreRssiThresholdAbsDbm", "identityHandoffStepThreshold", "identityHandoffStationary60sSteps"})));
        ConcurrentHashMap.KeySetView r0 = ConcurrentHashMap.newKeySet();
        d = r0;
        e = TimeUnit.MINUTES.toMillis(2);
        TimeUnit r1 = TimeUnit.SECONDS;
        f = r1.toMillis(1);
        g = new long[]{60000, 180000, 300000, 600000, 1800000, ProactiveLiveCardDisplayTool.DEFAULT_AUTO_DISMISS_DURATION_MS, 7200000};
        h = r1.toMillis(20);
        i = r1.toMillis(15);
        j = r1.toMillis(45);
        k = r1.toMillis(30);
        r0.add("011901");
        r0.add("052201");
        r0.add("052202");
    }

    public StarPoiManager() {
        this.l = new ConcurrentHashMap();
        this.m = new AtomicBoolean(false);
        this.n = new AtomicBoolean(false);
        this.o = new AtomicBoolean(false);
        this.p = new AtomicBoolean(false);
        this.q = new AtomicBoolean(false);
        this.r = new ArrayDeque();
        ScheduledThreadPoolExecutor r0 = new ScheduledThreadPoolExecutor(1, new n(0));
        this.s = r0;
        this.u = "";
        this.v = "";
        this.z = "";
        this.B = "";
        this.C = "";
        this.D = com.obric.cae.location.geosdk.poi.c.f7219a;
        this.E = com.obric.cae.location.geosdk.poi.b.f7217a;
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.f7166J = false;
        this.K = true;
        this.L = false;
        this.M = 0.6f;
        this.N = AwareStateListener.DEFAULT_POI_WALK_STEP_THRESHOLD;
        this.O = 10;
        this.P = 60000;
        this.ab = -1;
        this.ac = 0;
        this.ad = new AtomicBoolean(false);
        this.ae = 0;
        this.af = 0;
        this.ag = -1;
        this.ah = false;
        this.ai = 20;
        this.aj = -1;
        this.ak = 0;
        this.al = 0;
        this.am = -1;
        this.an = -1;
        this.ao = 0;
        this.ap = 0;
        this.aq = 0;
        this.ar = 0;
        this.as = 0;
        this.at = 0;
        this.au = false;
        this.aw = 0;
        this.ax = 0;
        this.ay = 0;
        this.az = 0;
        this.aA = 0;
        this.aB = 0;
        this.aC = 0;
        this.aD = 0;
        this.aE = 0;
        this.aF = 0;
        this.aG = "NO_DATA";
        this.aK = 0;
        this.aL = "";
        this.aP = -1;
        this.aR = new o();
        this.aU = 0;
        this.aW = new AtomicInteger(1);
        m r1 = m.f7186a;
        this.aY = new a(this);
        this.aZ = new b(this);
        this.ba = new com.obric.cae.location.geosdk.poi.f(new c(this));
        this.bb = new HashMap();
        this.bc = new HashMap();
        this.bd = new d(this);
        this.be = new AnonymousClass1(this);
        r0.setRemoveOnCancelPolicy(true);
    }

    public static StarPoiManager a() {
        return f7164a;
    }

    public static String a(Bundle r6) {
        StringBuilder r0 = new StringBuilder("{");
        Iterator<String> r1 = r6.keySet().iterator();
        boolean r2 = true;
    L4:
        if (r1.hasNext() == false) goto L9;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (r2 == true) goto L8;
        r0.append(", ");
    L8:
        r2 = false;
        r0.append(r3).append("=").append(r6.get(r3));
        goto L4
    L9:
        r0.append("}");
        return r0.toString();
    }

    public static String a(String r4, Bundle r5, Set<String> r6, String r7) {
        Set r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        if (r7 != null) goto L5;
        ArrayList r9 = new ArrayList(r8);
        Collections.sort(r9);
        StringBuilder r10 = new StringBuilder(r4).append('{');
        boolean r11 = true;
        Iterator r12 = r9.iterator();
    L12:
        if (r12.hasNext() == false) goto L20;
        String r0 = (String) ZeusTransformUtils.preCheckCast(r12.next(), String.class, "com.obric.memorydata.plugin");
        if (r5.containsKey(r0) == false) goto L12;
        if (r11 == true) goto L18;
        r10.append(',');
    L18:
        r11 = false;
        r10.append(r0).append('=').append(r5.getInt(r0));
        goto L12
    L20:
        if (r5.containsKey("configVersion") == false) goto L25;
        if (r11 == true) goto L23;
        r10.append(',');
    L23:
        r10.append("configVersion=").append(r5.getInt("configVersion"));
    L25:
        return r10.append('}').toString();
    L5:
        if (r5.containsKey(r7) == false) goto L7;
        StringBuilder r13 = new StringBuilder().append(r4).append(".").append(r7).append("=").append(r5.getInt(r7));
    L9:
        return r13.toString();
    L7:
        r13 = new StringBuilder("ERROR ").append(r4).append(" config unavailable");
        goto L9
    }

    public static String a(List<PoiInfoEntity> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
        return "null";
    L5:
        StringBuilder r2 = new StringBuilder("[");
        int r3 = 0;
    L7:
        if (r3 >= r8.size()) goto L15;
        PoiInfoEntity r4 = (PoiInfoEntity) ZeusTransformUtils.preCheckCast(r8.get(r3), PoiInfoEntity.class, "com.obric.memorydata.plugin");
        if (r3 <= 0) goto L11;
        r2.append(", ");
    L11:
        if (r4 != null) goto L13;
        r2.append("null");
    L14:
        r3 = r3 + 1;
        goto L7
    L13:
        r2.append("{LocationID=").append(r4.LocationID).append(", AwemeID=").append(r4.AwemeID).append(", AmapID=").append(r4.AmapID).append(", Name=").append(r4.Name).append(", Typecode=").append(r4.Typecode).append(", Confidence=").append(r4.Confidence).append(", Distance=").append(r4.Distance).append(", Source=").append(r4.Source).append("}");
        goto L14
    L15:
        r2.append("]");
        return r2.toString();
    }

    private void a(int r9, final int r10, final i r11) {
        final boolean r4 = false;
    L13:
        th = th;
        final boolean r5 = false;
    L22:
        a("AP MIDDLEWARE_REQUEST failed error=".concat(th.getClass().getSimpleName()), System.currentTimeMillis());     // Catch: Throwable -> L19
        com.obric.cae.log.a.b("StarLocation-PoiManager", "failed", th);     // Catch: Throwable -> L19
        this.o.set(false);
        j r12 = this.Z;
        Runnable r0 = new $$Lambda$StarPoiManager$y9D6W_PsfUwaYtxK0PGtGHakBE(this, r5, r11, r10);
    L17:
        r12.post(r0);
        return;
    L19:
        th = move-exception;
        this.o.set(false);
        this.Z.post(new $$Lambda$StarPoiManager$y9D6W_PsfUwaYtxK0PGtGHakBE(this, r5, r11, r10));
        throw th;
    L4:
        if (f("queryNearPoiData task") == false) goto L8;
        a("AP MIDDLEWARE_REQUEST aborted reason=transport", System.currentTimeMillis());     // Catch: Throwable -> L13
        this.o.set(false);
        this.Z.post(new $$Lambda$StarPoiManager$y9D6W_PsfUwaYtxK0PGtGHakBE(this, r4, r11, r10));
        return;
    L8:
        a("near_poi_data_query");     // Catch: Throwable -> L13
        r5 = com.obric.cae.location.geosdk.bytedance.a.a().a(r9);     // Catch: Throwable -> L13
        a("AP MIDDLEWARE_REQUEST sent success=" + r5 + " requestId=" + r10 + " generation=" + r9, System.currentTimeMillis());     // Catch: Throwable -> L11
        com.obric.cae.log.a.f("StarLocation-PoiManager", "success=" + r5);     // Catch: Throwable -> L11
        this.o.set(false);
        r12 = this.Z;
        r0 = new $$Lambda$StarPoiManager$y9D6W_PsfUwaYtxK0PGtGHakBE(this, r5, r11, r10);
    L11:
        th = th;
        goto L22
    }

    private /* synthetic */ void a(Bundle r1, com.obric.cae.location.geosdk.poi.b r2, e r3) {
        b("enter", r1);
        b(r2);
    }

    private /* synthetic */ void a(e r1) {
        a(this.E);
    }

    public static void a(StarPoiManager r5) {
        if (r5.m() == false) goto L17;
        int r0 = r5.ak;
        long[] r1 = g;
        if (r0 < r1.length) goto L8;
        com.obric.cae.log.a.d("StarLocation-PoiManager", "skip schedule inside period alarm, index=" + r5.ak);
        return;
    L8:
        long r2 = r1[r0];
        AlarmManager r3 = r5.R;
        if (r3 != null) goto L11;
        return;
    L11:
        if (r5.S == null) goto L16;
        r3.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + r2, r5.S);
        return;
    L16:
        return;
    }

    public static void a(StarPoiManager r9, Context r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        r9.getClass();
        if (Settings.Global.getInt(r11.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_POI_DETECT_FUNCTION, 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        boolean r3 = com.obric.cae.location.city.a.a(r11);
        boolean r4 = r9.m();
        if (r9.f7166J == r0) goto L9;
    L11:
        r9.f7166J = r0;
        r9.L = r3;
        boolean r5 = r9.m();
        com.obric.cae.log.a.f("StarLocation-PoiManager", "poi detect switch changed, poiDetectEnabled=" + r0 + ", proactiveAgentEnabled=" + r3 + ", effectiveEnabled=" + r5);
        if (r4 == false) goto L15;
        if (r5 == true) goto L15;
        r9.n();
    L10:
        r9.j();
        r9.at = 1;
        Context r1 = r9.t;
        if (r1 != null) goto L21;
    L24:
        r9.c(0);
        r9.j();
        com.obric.cae.log.a.f("StarLocation-PoiManager", "POI trigger mode fixed to ADSP_ONLY");
        r9.a(r11);
        return;
    L21:
        if (r9.av != null) goto L24;
        PoiAwareBridge r2 = new PoiAwareBridge(r1, r9.aY);
        r9.av = r2;
        r2.start();
        r9.a(r9.av);
    L15:
        if (r4 == true) goto L10;
        if (r5 == false) goto L10;
        r9.g();
        goto L10
    L9:
        if (r9.L != r3) goto L11;
    L5:
        r0 = false;
        goto L6
    }

    public static void a(StarPoiManager r9, Intent r10, BroadcastReceiver.PendingResult r11) {
        r9.getClass();
        if (r10 != null) goto L7;
        r11.setResultCode(1);
        String r12 = "ERROR missing intent";
    L5:
        r11.setResultData(r12);
    L6:
        r11.finish();
        return;
    L7:
        String r1 = r10.getStringExtra("op");
        String r2 = r10.getStringExtra(TypedValues.AttributesType.S_TARGET);
        String r3 = r10.getStringExtra("key");
        if (r1 != null) goto L10;
        String r4 = "help";
    L12:
        if (r2 != null) goto L14;
        String r5 = LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL;
    L15:
        r4.getClass();
        r4.hashCode();
        r4.hashCode();
        byte r6 = -1;
        int r8 = 0;
        switch(r4.hashCode()) {
            case 102230: goto L35;
            case 113762: goto L31;
            case 3198785: goto L27;
            case 3322014: goto L23;
            case 108404047: goto L19;
            default: goto L39;
        };
    L19:
        if (r4.equals("reset") == false) goto L39;
        r6 = 4;
        goto L39
    L23:
        if (r4.equals(Constants.KEY_LIST) == false) goto L39;
        r6 = 3;
        goto L39
    L27:
        if (r4.equals("help") == false) goto L39;
        r6 = 2;
        goto L39
    L31:
        if (r4.equals("set") == false) goto L39;
        r6 = 1;
        goto L39
    L35:
        if (r4.equals("get") == false) goto L39;
        r6 = 0;
    L39:
        switch(r6) {
            case 0: goto L98;
            case 1: goto L71;
            case 2: goto L69;
            case 3: goto L68;
            case 4: goto L43;
            default: goto L40;
        };
    L40:
        r12 = "ERROR unknown op=".concat(r4);
    L41:
        r11.setResultCode(1);
        goto L5
    L68:
        r9.a(r11, r5, null);
        return;
    L69:
        r11.setResultCode(0);
        r12 = "op=set|get|list|reset target=entry|exit|all set: --es key NAME --ei value INT";
        goto L5
    L43:
        if ("entry".equals(r5) == false) goto L45;
    L46:
        PoiAwareBridge r13 = r9.av;
        if (r13 == null) goto L50;
        r13.resetConfig();
        r8 = 1;
    L50:
        if ("exit".equals(r5) == false) goto L52;
    L53:
        PoiWifiScanBridge r14 = r9.aH;
        if (r14 == null) goto L57;
        r14.resetConfig();
        r8 = 1;
    L57:
        if ("entry".equals(r5) == false) goto L59;
    L63:
        int r15 = r8 ^ 1;
        if (r8 == 0) goto L66;
        String r16 = com.obric.cae.libs.utils.h.a("OK reset queued target=", r5);
    L67:
        r11.setResultCode(r15);
        r11.setResultData(r16);
        goto L6
    L66:
        r16 = "ERROR target bridge unavailable";
        goto L67
    L59:
        if ("exit".equals(r5) == true) goto L63;
        if (LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL.equals(r5) == true) goto L63;
        r11.setResultCode(1);
        r12 = "ERROR reset target must be entry, exit, or all";
        goto L5
    L52:
        if (LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL.equals(r5) == false) goto L57;
    L45:
        if (LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL.equals(r5) == false) goto L50;
    L71:
        if (TextUtils.isEmpty(r3) == false) goto L73;
    L96:
        r11.setResultCode(1);
        r12 = "ERROR set requires --es key <name> --ei value <int>";
        goto L5
    L73:
        if (r10.hasExtra(EventBody.KEY_VALUE) == false) goto L96;
        Bundle r7 = new Bundle();
        r7.putInt(r3, r10.getIntExtra(EventBody.KEY_VALUE, 0));
        if ("entry".equals(r5) == false) goto L86;
        if (f7165b.contains(r3) == true) goto L81;
        StringBuilder r17 = new StringBuilder("ERROR unknown entry key=");
    L80:
        r12 = r17.append(r3).toString();
        goto L41
    L81:
        PoiAwareBridge r18 = r9.av;
        if (r18 != null) goto L84;
        r11.setResultCode(1);
        r12 = "ERROR entry bridge unavailable";
        goto L5
    L84:
        r18.updateConfig(r7);
    L94:
        r12 = "OK queued target=" + r5 + " key=" + r3 + " value=" + r10.getIntExtra(EventBody.KEY_VALUE, 0);
        com.obric.cae.log.a.f("StarLocation-PoiManager", "POI_CONFIG_COMMAND " + r12);
        r11.setResultCode(0);
        goto L5
    L86:
        if ("exit".equals(r5) == true) goto L88;
        r11.setResultCode(1);
        r12 = "ERROR set target must be entry or exit";
        goto L5
    L88:
        if (c.contains(r3) == true) goto L90;
        r17 = new StringBuilder("ERROR unknown exit key=");
        goto L80
    L90:
        PoiWifiScanBridge r19 = r9.aH;
        if (r19 != null) goto L93;
        r11.setResultCode(1);
        r12 = "ERROR exit bridge unavailable";
        goto L5
    L93:
        r19.updateConfig(r7);
        goto L94
    L98:
        if (TextUtils.isEmpty(r3) == false) goto L100;
        r11.setResultCode(1);
        r12 = "ERROR get requires --es key <name>";
        goto L5
    L100:
        r9.a(r11, r5, r3);
        return;
    L14:
        r5 = r2.toLowerCase(Locale.ROOT);
        goto L15
    L10:
        r4 = r1.toLowerCase(Locale.ROOT);
        goto L12
    }

    public static void a(String r6) {
        long r1 = System.currentTimeMillis();     // Catch: Exception -> L5
        JSONObject r3 = new JSONObject();     // Catch: Exception -> L5
        r3.put("report_type", 5);     // Catch: Exception -> L5
        r3.put("poi_event_key", r6 + "_" + r1);     // Catch: Exception -> L5
        r3.put("event_time", r1);     // Catch: Exception -> L5
        r3.put("user_choice", -1);     // Catch: Exception -> L5
        r3.put("poi_name", "");     // Catch: Exception -> L5
        r3.put("aoi_name", "");     // Catch: Exception -> L5
        r3.put("device_id", MatrixDidUtils.getDid());     // Catch: Exception -> L5
        com.obric.cae.cloud.applog.b.a("poi_feedback", r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-PoiManager", "report query poi_feedback failed", e);
    }

    public static void a(String r11, Bundle r12) {
        long r4 = r12.getLong("timestamp", System.currentTimeMillis());     // Catch: Exception -> L9
        JSONObject r6 = new JSONObject();     // Catch: Exception -> L9
        r6.put("report_type", 4);     // Catch: Exception -> L9
        if (r12.containsKey("poi_confidence") == false) goto L7;
        r11 = r11 + "_" + r12.getDouble("poi_confidence");     // Catch: Exception -> L9
    L7:
        r6.put("poi_event_key", r11 + "_" + r4);     // Catch: Exception -> L9
        r6.put("event_time", r4);     // Catch: Exception -> L9
        r6.put("user_choice", -1);     // Catch: Exception -> L9
        r6.put("poi_name", r12.getString("poi_name", ""));     // Catch: Exception -> L9
        r6.put("aoi_name", r12.getString("aoi_name", ""));     // Catch: Exception -> L9
        r6.put("device_id", MatrixDidUtils.getDid());     // Catch: Exception -> L9
        com.obric.cae.cloud.applog.b.a("poi_feedback", r6);     // Catch: Exception -> L9
        return;
    L9:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-PoiManager", "report blocked poi_feedback failed", e);
    }

    private void a(boolean r2, i r3, int r4) {
        if (r2 == false) goto L6;
        if (r3.g == false) goto L6;
    L10:
        this.ac = this.ab;
        a(r4, "scene_request_finished");
        return;
    L6:
        if (r2 == false) goto L8;
        String r5 = "response_missing_or_invalid";
    L9:
        a(r3, false, r5);
        goto L10
    L8:
        r5 = "scene_request_failed";
        goto L9
    }

    public static boolean a(int r1) {
        if (r1 != 6) goto L5;
    L12:
        return true;
    L5:
        if (r1 == 8) goto L12;
        if (r1 == 5) goto L12;
        if (r1 == 7) goto L12;
        return false;
    }

    public static boolean a(com.obric.cae.location.geosdk.poi.c r1) {
        if (r1 != com.obric.cae.location.geosdk.poi.c.c) goto L5;
    L10:
        return true;
    L5:
        if (r1 == com.obric.cae.location.geosdk.poi.c.d) goto L10;
        if (r1 == com.obric.cae.location.geosdk.poi.c.e) goto L10;
        return false;
    }

    public static boolean a(boolean r0) {
        return !r0;
    }

    private void b(BroadcastReceiver.PendingResult r6, String r7, String r8) {
        if ("entry".equals(r7) == false) goto L11;
        PoiAwareBridge r5 = this.av;
        if (r5 != null) goto L7;
        Bundle r9 = Bundle.EMPTY;
    L8:
        String r10 = a("entry", r9, f7165b, r8);
    L9:
        r6.setResultCode(0);
        r6.setResultData(r10);
        r6.finish();
        return;
    L7:
        r9 = r5.getEffectiveConfig();
        goto L8
    L11:
        if ("exit".equals(r7) == false) goto L17;
        PoiWifiScanBridge r11 = this.aH;
        if (r11 != null) goto L15;
        Bundle r12 = Bundle.EMPTY;
    L16:
        r10 = a("exit", r12, c, r8);
        goto L9
    L15:
        r12 = r11.getEffectiveConfig();
        goto L16
    L17:
        PoiAwareBridge r13 = this.av;
        if (r13 != null) goto L20;
        Bundle r14 = Bundle.EMPTY;
    L21:
        PoiWifiScanBridge r15 = this.aH;
        if (r15 != null) goto L24;
        Bundle r16 = Bundle.EMPTY;
    L25:
        r10 = a("entry", r14, f7165b, null) + " " + a("exit", r16, c, null);
        goto L9
    L24:
        r16 = r15.getEffectiveConfig();
        goto L25
    L20:
        r14 = r13.getEffectiveConfig();
        goto L21
    }

    private void b(BDLocation r3) {
        if (this.at == 0) goto L5;
    L9:
        a("AP LOCATION_RESULT ignored reason=outside_ap_request", System.currentTimeMillis());
        return;
    L5:
        if (d() == false) goto L9;
        a(r3, "submit_notification");
    }

    private /* synthetic */ void b(e r1) {
        c("shadow_handoff");
        e("shadow_handoff");
    }

    private /* synthetic */ void b(e r1, Bundle r2) {
        a(r1, r2);
    }

    private /* synthetic */ void b(PoiAwareBridge r2) {
        if (this.av == r2) goto L5;
        return;
    L5:
        if (this.at != 0) goto L7;
        return;
    L7:
        if (r2.isStateSynchronized() == true) goto L13;
        com.obric.cae.log.a.h("StarLocation-PoiManager", "ADSP state ACK timeout, keep mode=" + this.at + " with temporary AP fallback");
        return;
    }

    private /* synthetic */ void c(Bundle r1, int r2) {
        a(r1, r2);
    }

    private /* synthetic */ void e(int r2) {
        a(r2, LocationMonitorConst.TIMEOUT);
    }

    private /* synthetic */ void e(Bundle r1) {
        b(r1);
    }

    private /* synthetic */ void f(int r1) {
        this.l.remove(Integer.valueOf(r1));
    }

    private /* synthetic */ void f(Bundle r1) {
        b(r1);
    }

    public static /* synthetic */ void lambda$1s86yPmwmY1OVS2DjxpwLyQppOg(StarPoiManager r0, BroadcastReceiver.PendingResult r1, String r2, String r3) {
        r0.b(r1, r2, r3);
    }

    public static /* synthetic */ void lambda$8S6A_AQw3gESKEOo9DQKXg1R8pw(StarPoiManager r0, Bundle r1) {
        r0.e(r1);
    }

    public static /* synthetic */ void lambda$BWnEzK6HTgOZqEQrbshh3zVAUUg(StarPoiManager r0, e r1, Bundle r2) {
        r0.b(r1, r2);
    }

    public static /* synthetic */ void lambda$KrFQJp565miqNvCFUOaPkEkD6uU(StarPoiManager r0, Bundle r1) {
        r0.f(r1);
    }

    public static /* synthetic */ void lambda$QQovzsBQpVgKFNcZwgiKur2gneE(StarPoiManager r0, BDLocation r1) {
        r0.b(r1);
    }

    public static /* synthetic */ void lambda$Xvaf59C2_TM21A5_yQC2EV13nOo(StarPoiManager r0, Bundle r1, int r2) {
        r0.c(r1, r2);
    }

    public static /* synthetic */ void lambda$_rvRd11N5hORU4vmipkCpLoreS4(StarPoiManager r0, e r1) {
        r0.b(r1);
    }

    public static /* synthetic */ void lambda$aSZF_00rYCzTs0E7dBlGpLvtOQQ(StarPoiManager r0, PoiAwareBridge r1) {
        r0.b(r1);
    }

    public static /* synthetic */ void lambda$atGT3XIXANv16n4_dVE3snUFlGA(StarPoiManager r0, int r1) {
        r0.e(r1);
    }

    public static /* synthetic */ void lambda$jgzFzwZv23Q_FF3cmSxdtFA1c9w(StarPoiManager r0, int r1) {
        r0.f(r1);
    }

    /* JADX INFO: renamed from: lambda$kdeCBXcZVxlX-JyHoX_RbINLvC4, reason: not valid java name */
    public static /* synthetic */ void m383lambda$kdeCBXcZVxlXJyHoX_RbINLvC4(StarPoiManager r0, e r1) {
        r0.a(r1);
    }

    public static /* synthetic */ void lambda$nlESIzRufm6_71f9iIGM8ATVWh4(StarPoiManager r0, Bundle r1, com.obric.cae.location.geosdk.poi.b r2, e r3) {
        r0.a(r1, r2, r3);
    }

    public static /* synthetic */ void lambda$sJmEhHcRYKXuEIHDENNf24DFUNk(StarPoiManager r0, int r1, int r2, i r3) {
        r0.a(r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$y9D6W_PsfUwa-YtxK0PGtGHakBE, reason: not valid java name */
    public static /* synthetic */ void m384lambda$y9D6W_PsfUwaYtxK0PGtGHakBE(StarPoiManager r0, boolean r1, i r2, int r3) {
        r0.a(r1, r2, r3);
    }

    public void a(int r7, int r8) {
        if (r7 <= 0) goto L4;
        int r0 = r7;
    L7:
        f r6 = (f) ZeusTransformUtils.preCheckCast(this.l.remove(Integer.valueOf(r0)), f.class, "com.obric.memorydata.plugin");
        if (r6 != null) goto L15;
        String r9 = "skip unregister missing pid=";
    L10:
        com.obric.cae.log.a.d("StarLocation-PoiManager", com.obric.cae.location.b.a(r9, r7, ", uid=", r8, ", key=").append(r0).toString());
        return;
    L15:
        r6.f7174a.asBinder().unlinkToDeath(r6.f7175b, 0);     // Catch: Throwable -> L14
    L13:
        r9 = "unregister pid=";
        goto L10
    L4:
        if (r8 <= 0) goto L6;
        r0 = -r8;
        goto L7
    L6:
        r0 = Process.myPid();
        goto L7
    }

    public void a(int r8, int r9, com.obric.cae.libs.location.poi.c r10) {
        com.obric.cae.libs.location.poi.c r11 = (com.obric.cae.libs.location.poi.c) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.cae.libs.location.poi.c.class, "com.obric.memorydata.plugin");
        if (r8 <= 0) goto L5;
        final int r3 = r8;
    L8:
        IBinder r4 = r11.asBinder();
        f r2 = (f) ZeusTransformUtils.preCheckCast(this.l.remove(Integer.valueOf(r3)), f.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L20;
    L11:
        IBinder.DeathRecipient r5 = new $$Lambda$StarPoiManager$jgzFzwZv23Q_FF3cmSxdtFA1c9w(this, r3);
        r4.linkToDeath(r5, 0);     // Catch: RemoteException -> L14
        this.l.put(Integer.valueOf(r3), new f(r11, r5));     // Catch: RemoteException -> L14
        com.obric.cae.log.a.d("StarLocation-PoiManager", "register pid=" + r8 + ", uid=" + r9 + ", key=" + r3 + ", callback=" + r11.hashCode());     // Catch: RemoteException -> L14
        return;
    L14:
        e = move-exception;
        com.obric.cae.log.a.j("StarLocation-PoiManager", "register failed: " + e.getMessage());
        return;
    L20:
        r2.f7174a.asBinder().unlinkToDeath(r2.f7175b, 0);     // Catch: Throwable -> L17
        goto L11
    L5:
        if (r9 <= 0) goto L7;
        r3 = -r9;
        goto L8
    L7:
        r3 = Process.myPid();
        goto L8
    }

    public void a(int r6, long r7) {
        if (m() == true) goto L5;
        return;
    L5:
        Context r0 = this.t;
        if (r0 == null) goto L20;
        TelephonyManager r1 = (TelephonyManager) ZeusTransformUtils.preCheckCast(r0.getSystemService(MemoryKeyInfoEntity.KEY_PHONE), TelephonyManager.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L20;
        if (r1.getSimState() != 5) goto L20;
        ServiceState r2 = r1.getServiceState();     // Catch: SecurityException -> L18
        if (r2 == null) goto L20;
        if (r2.getState() != 0) goto L20;
        boolean r3 = true;
    L21:
        if (r3 == true) goto L24;
        return;
    L24:
        if (r6 == this.an) goto L26;
    L28:
        com.obric.cae.log.a.f("StarLocation-PoiManager", "handleCellPoiStatusChange cellPoiType=" + r6 + ", cellid=" + r7);
        d(6);
        this.Z.obtainMessage(6, r6, 0, Long.valueOf(r7)).sendToTarget();
        return;
    L26:
        if (this.D == com.obric.cae.location.geosdk.poi.c.f7219a) goto L28;
        return;
    L18:
        e = move-exception;
        com.obric.cae.log.a.h("StarLocation-PoiManager", "check sim registration failed: " + e.getMessage());
    L20:
        r3 = false;
        goto L21
    }

    public final void a(final int r7, Bundle r8) {
        long r0 = System.currentTimeMillis();
        PoiAdspEventDispatcher.report(3, r0, "ADSP_ENTRY_REQUEST:" + r7 + ParameterizedMessage.ERROR_MSG_SEPARATOR + r0);
        a("AP ADSP_TRIGGER received id=" + r7 + " reason=0 state=" + this.D, r0);
        boolean r1 = true;
        this.ay++;
        this.aD = SystemClock.elapsedRealtime();
        this.aF = 0;
        l();
        PoiAwareBridge r2 = this.av;
        if (r2 != null) goto L5;
    L11:
        boolean r3 = false;
    L12:
        if (r3 == true) goto L16;
        a("AP ADSP_TRIGGER rejected stale id=" + r7, System.currentTimeMillis());
        c(r7);
        return;
    L16:
        if (this.at != 2) goto L20;
        a("AP ADSP_TRIGGER completed shadow=true id=" + r7, System.currentTimeMillis());
        com.obric.cae.log.a.f("StarLocation-PoiManager", "DUAL_COMPARE shadow ADSP candidate id=" + r7 + ", reason=0");
        c(r7);
        return;
    L20:
        if (f() == true) goto L22;
    L37:
        a(com.obric.cae.libs.statemachine.d.a("AP ADSP_TRIGGER rejected id=", r7, " active=").append(f()).append(" pending=").append(this.aw).toString(), System.currentTimeMillis());
        com.obric.cae.log.a.h("StarLocation-PoiManager", "drop ADSP request id=" + r7 + ", mode=" + this.at + ", ready=" + this.au + ", pending=" + this.aw);
        c(r7);
        return;
    L22:
        if (this.aw != 0) goto L37;
        if (this.D != com.obric.cae.location.geosdk.poi.c.d) goto L27;
    L30:
        if (r1 == true) goto L32;
    L35:
        this.aU = 0;
        this.aV = SystemClock.elapsedRealtime() + 60000;
        this.aw = r7;
        this.ax = SystemClock.elapsedRealtime();
        this.Z.postDelayed(new $$Lambda$StarPoiManager$atGT3XIXANv16n4_dVE3snUFlGA(this, r7), j);
        com.obric.cae.log.a.f("StarLocation-PoiManager", "ADSP REQUEST_START id=" + r7 + ", reason=0, details=" + r8);
        a("AP LOCATION_REQUEST source=ADSP id=" + r7 + " reason=0 context=0", System.currentTimeMillis());
        p();
        return;
    L32:
        if (TextUtils.isEmpty(this.aL) == true) goto L35;
        a("AP ENTRY candidate rejected in active store poiId=" + this.aL + " reason=0", System.currentTimeMillis());
        c(r7);
        return;
    L27:
        if (this.D == com.obric.cae.location.geosdk.poi.c.e) goto L30;
        r1 = false;
        goto L30
    L5:
        if (r8.getInt("sessionEpoch", -1) != r2.getSessionEpoch()) goto L11;
        if (r8.getInt("stateVersion", -1) != r2.getStateVersion()) goto L11;
        if (r8.getInt("state", -1) != this.D.ordinal()) goto L11;
        r3 = true;
        goto L12
    }

    public final void a(int r6, String r7) {
        if (r6 != 0) goto L4;
        return;
    L4:
        if (r6 != this.aw) goto L25;
        i r0 = this.aX;
        if (r0 == null) goto L16;
        this.aX = null;
        if (r0.f7180b != 1) goto L22;
        o r1 = this.aR;
        e r2 = r0.f;
        if (r1.f7188a != p.f7191b) goto L22;
        if (Objects.equals(r1.f7189b, r2) == false) goto L22;
        r1.f7188a = p.f7190a;
    L22:
        long r3 = SystemClock.elapsedRealtime() - this.ax;
        this.aw = 0;
        this.ax = 0;
        this.aU = 0;
        this.aV = 0;
        c(r6);
        a("AP REQUEST_COMPLETE id=" + r6 + " source=" + r7 + " durationMs=" + r3 + " state=" + this.D, System.currentTimeMillis());
        com.obric.cae.log.a.f("StarLocation-PoiManager", "ADSP REQUEST_COMPLETE id=" + r6 + ", source=" + r7 + ", durationMs=" + r3 + ", state=" + this.D);
        return;
    L16:
        if (this.aU != 1) goto L22;
        o r4 = this.aR;
        e r5 = this.aM;
        if (r4.f7188a != p.f7191b) goto L22;
        if (Objects.equals(r4.f7189b, r5) == false) goto L22;
        r4.f7188a = p.f7190a;
        goto L22
    }

    public final void a(final BroadcastReceiver.PendingResult r5, final String r6, final String r7) {
        if ("entry".equals(r6) == true) goto L15;
        if ("exit".equals(r6) == true) goto L15;
        if (LocationAnnotation.LightLocationType.LIGHT_LOCATION_ALL.equals(r6) == false) goto L9;
        if (r7 == null) goto L15;
    L9:
        if (r7 != null) goto L11;
        String r4 = ", or all";
    L12:
        String r8 = "ERROR query target must be entry, exit".concat(r4);
        r5.setResultCode(1);
        r5.setResultData(r8);
        r5.finish();
        return;
    L11:
        r4 = "";
    L15:
        if ("entry".equals(r6) == false) goto L27;
        if (r7 != null) goto L18;
    L21:
        PoiAwareBridge r0 = this.av;
        if (r0 != null) goto L25;
        r5.setResultCode(1);
        r5.setResultData("ERROR entry bridge unavailable");
        r5.finish();
        return;
    L25:
        r0.requestConfigSnapshot();
    L43:
        j r1 = this.Z;
        if (r1 != null) goto L47;
        r5.setResultCode(1);
        r5.setResultData("ERROR worker unavailable");
        r5.finish();
        return;
    L47:
        r1.postDelayed(new $$Lambda$StarPoiManager$1s86yPmwmY1OVS2DjxpwLyQppOg(this, r5, r6, r7), 500);
        return;
    L18:
        if (f7165b.contains(r7) == true) goto L21;
        String r9 = "ERROR unknown entry key=".concat(r7);
        r5.setResultCode(1);
        r5.setResultData(r9);
        r5.finish();
        return;
    L27:
        if ("exit".equals(r6) == false) goto L37;
        if (r7 != null) goto L30;
    L33:
        PoiWifiScanBridge r2 = this.aH;
        if (r2 != null) goto L42;
        r5.setResultCode(1);
        r5.setResultData("ERROR exit bridge unavailable");
        r5.finish();
        return;
    L42:
        r2.queryConfig();
        goto L43
    L30:
        if (c.contains(r7) == true) goto L33;
        String r10 = "ERROR unknown exit key=".concat(r7);
        r5.setResultCode(1);
        r5.setResultData(r10);
        r5.finish();
        return;
    L37:
        PoiAwareBridge r3 = this.av;
        if (r3 == null) goto L40;
        r3.requestConfigSnapshot();
    L40:
        r2 = this.aH;
        if (r2 == null) goto L43;
        goto L42
    }

    public final void a(Context r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        int r0 = this.ai;
        int r1 = Settings.Global.getInt(r9.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_DELAY_SECONDS, r0);
        if (r1 <= 0) goto L5;
        r0 = r1;
    L6:
        this.ai = r0;
        int r2 = this.N;
        int r3 = Settings.Global.getInt(r9.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_POI_WALK_STEP_THRESHOLD, r2);
        if (r3 <= 0) goto L9;
        r2 = r3;
    L10:
        this.N = r2;
        int r4 = this.O;
        int r5 = Settings.Global.getInt(r9.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_DELTA_THRESHOLD, r4);
        if (r5 <= 0) goto L13;
        r4 = r5;
    L14:
        this.O = r4;
        long r6 = this.P;
        long r7 = Settings.Global.getLong(r9.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_CHECK_INTERVAL_MS, r6);
        if (r7 <= 0) goto L17;
        r6 = r7;
    L18:
        this.P = r6;
        float r10 = 0.6f;
        float r11 = Settings.Global.getFloat(r9.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_POI_CONFIDENCE_THRESHOLD, 0.6f);
        if (r11 >= 0.0f) goto L21;
    L23:
        com.obric.cae.log.a.h("StarLocation-PoiManager", "ignore invalid poi confidence threshold=" + r11);
    L24:
        this.M = r10;
        boolean r12 = true;
        if (Settings.Global.getInt(r9.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_POI_ACC_QUALIFIED_CHECK, 1) == 1) goto L28;
        r12 = false;
    L28:
        this.K = r12;
        k();
        com.obric.cae.log.a.f("StarLocation-PoiManager", "poi detect config updated, stationaryDelaySeconds=" + this.ai + ", walkStepThreshold=" + this.N + ", stationaryStepDeltaThreshold=" + this.O + ", stationaryStepCheckIntervalMs=" + this.P + ", poiConfidenceThreshold=" + this.M + ", poiAccQualifiedCheckEnabled=" + this.K);
        return;
    L21:
        if (r11 > 1.0f) goto L23;
        r10 = r11;
        goto L24
    L17:
        com.obric.cae.log.a.h("StarLocation-PoiManager", "ignore invalid long setting, key=cae_user_aware_poi_stationary_step_check_interval_ms, value=" + r7);
        goto L18
    L13:
        com.obric.cae.log.a.h("StarLocation-PoiManager", "ignore invalid int setting, key=cae_user_aware_poi_stationary_step_delta_threshold, value=" + r5);
        goto L14
    L9:
        com.obric.cae.log.a.h("StarLocation-PoiManager", "ignore invalid int setting, key=cae_user_aware_poi_walk_step_threshold, value=" + r3);
        goto L10
    L5:
        com.obric.cae.log.a.h("StarLocation-PoiManager", "ignore invalid int setting, key=cae_user_aware_poi_stationary_delay_seconds, value=" + r1);
        goto L6
    }

    public final void a(Context r3, String r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        Uri r6 = Settings.Global.getUriFor(r4);
        if (r6 == null) goto L6;
        ZeusProviderTransform.registerContentObserver(r5.getContentResolver(), r6, false, this.X, "com.obric.memorydata.plugin");
        return;
    }

    public final void a(final Bundle r22, int r23) {
        if (m() == true) goto L5;
        return;
    L5:
        boolean r10 = "131401".equals(r22.getString("new_type_code_l3"));
        if (this.D != com.obric.cae.location.geosdk.poi.c.f7219a) goto L10;
        if (r10 == true) goto L10;
        g("skip notifyNearPoiReport in detect stopped, extras=" + a(r22));
        return;
    L10:
        i r11 = this.aX;
        if (a(r10) == false) goto L59;
        long r2 = r22.getLong("timestamp", 0);
        monitor-enter(this);
    L56:
        th = move-exception;
        throw th;
    L15:
        if (r11 == this.aX) goto L18;
        monitor-exit(this);
        int r5 = -1;
    L48:
        if (r5 >= 0) goto L55;
        StringBuilder r0 = com.obric.cae.libs.statemachine.d.a("AP MIDDLEWARE_RESULT dropped staleGeneration=", r23, " pending=");
        if (r11 != null) goto L52;
        int r12 = 0;
    L53:
        a(r0.append(r12).toString(), System.currentTimeMillis());
        return;
    L52:
        r12 = r11.f7179a;
        goto L53
    L55:
        int r13 = r5;
    L61:
        if (r13 == 1) goto L65;
        if (r13 == 2) goto L65;
    L74:
        if (r13 == 1) goto L78;
        if (r13 == 2) goto L78;
        boolean r14 = false;
    L79:
        a("AP MIDDLEWARE_RESULT received state=" + this.D, System.currentTimeMillis());
        String r3 = r22.getString("near_the_poi");
        if ("true".equalsIgnoreCase(r3) == false) goto L82;
    L85:
        boolean r4 = true;
    L86:
        if (r4 == false) goto L88;
    L93:
        boolean r6 = true;
    L94:
        if (r6 == true) goto L98;
        a("AP MIDDLEWARE_RESULT rejected reason=invalid_near_poi", System.currentTimeMillis());
        a("INVALID", "INVALID_NEAR_POI", r11, false, com.obric.cae.location.geosdk.poi.b.f7217a, -1.0d);
        a(r11, false, "invalid_near_poi");
        return;
    L98:
        if ("true".equalsIgnoreCase(r3) == false) goto L100;
    L103:
        boolean r15 = true;
    L105:
        if (TextUtils.isEmpty(r22.getString("poi_id")) == true) goto L107;
    L114:
        boolean r7 = true;
    L115:
        if (r7 == true) goto L117;
    L160:
        boolean r8 = false;
    L161:
        if (r8 == false) goto L176;
        if (r15 == false) goto L176;
        String r9 = r22.getString("new_type_name_l1");
        String r16 = r22.getString("new_type_name_l2");
        r22.getString("new_type_name_l3");
        if (r9 == null) goto L176;
        Locale r17 = Locale.ROOT;
        String r18 = r9.toLowerCase(r17);
        if (TextUtils.isEmpty(r16) == true) goto L173;
        r16.toLowerCase(r17);
        com.obric.cae.location.geosdk.poi.b r19 = (com.obric.cae.location.geosdk.poi.b) ZeusTransformUtils.preCheckCast(this.bc.get((r9 + "_" + r16).toLowerCase(r17)), com.obric.cae.location.geosdk.poi.b.class, "com.obric.memorydata.plugin");
        if (r19 == null) goto L173;
        if (r19 == com.obric.cae.location.geosdk.poi.b.f7217a) goto L173;
    L177:
        int r20 = r22.getInt("is_acc_qualified_poi", 1);
        if (r15 == true) goto L180;
    L183:
        boolean r21 = r22.containsKey("poi_confidence");
        double r110 = r22.getDouble("poi_confidence", -1.0d);
        double r24 = this.M;
        boolean r25 = this.K;
        if (r15 == true) goto L187;
        l r26 = new l(m.c, com.obric.cae.location.geosdk.poi.b.f7217a);
    L186:
        l r111 = r26;
        String r27 = r111.f7184a.name();
        int r28 = r111.f7184a.ordinal();
        if (r28 == 1) goto L213;
        if (r28 != 2) goto L209;
        String r1 = "NEAR_POI_FALSE";
    L214:
        int r112 = r13;
        boolean r29 = r14;
        a(r27, r1, r11, r15, r111.f7185b, r22.getDouble("poi_confidence", -1.0d));
        m r30 = r111.f7184a;
        if (r30 != m.f7187b) goto L219;
        a("AP MIDDLEWARE_RESULT rejected reason=low_confidence", System.currentTimeMillis());
        a("low_poi_confidence", r22);
        a(r11, false, "low_confidence");
        return;
    L219:
        if (r30 != m.f7186a) goto L223;
        a("AP MIDDLEWARE_RESULT rejected reason=invalid_result", System.currentTimeMillis());
        g("skip notifyNearPoiReport invalid result extras=" + a(r22));
        a(r11, false, "invalid_result");
        return;
    L223:
        if (r30 != m.c) goto L234;
        a("AP MIDDLEWARE_RESULT trusted_negative reason=near_poi_false", System.currentTimeMillis());
        a(r11, true, "trusted_unknown");
        if (this.D != com.obric.cae.location.geosdk.poi.c.d) goto L227;
    L232:
        c("shadow_query");
        e("shadow_query");
        d("shadow_query");
        this.E = com.obric.cae.location.geosdk.poi.b.f7217a;
        b(com.obric.cae.location.geosdk.poi.c.c);
        return;
    L227:
        if (this.D == com.obric.cae.location.geosdk.poi.c.e) goto L232;
        if (this.D != com.obric.cae.location.geosdk.poi.c.c) goto L327;
        this.E = com.obric.cae.location.geosdk.poi.b.f7217a;
        this.al = System.currentTimeMillis();
        return;
    L327:
        return;
    L234:
        if (r15 == true) goto L236;
    L257:
        com.obric.cae.location.geosdk.poi.c r31 = this.D;
        com.obric.cae.location.geosdk.poi.c r32 = com.obric.cae.location.geosdk.poi.c.f7220b;
        if (r31 != r32) goto L266;
        if (r10 == true) goto L266;
        if (this.aj == 0) goto L264;
    L265:
        boolean r33 = true;
    L267:
        if (r33 == false) goto L271;
        a(r11, true, "inside_area_probe");
        a("inside_area_probe", r22);
        a("AP MIDDLEWARE_RESULT suppressed reason=inside_area_probe", System.currentTimeMillis());
        g("skip near poi callback for inside area probe, extras=" + a(r22));
        b(com.obric.cae.location.geosdk.poi.c.c);
        b(r111.f7185b);
        return;
    L271:
        if (this.D != r32) goto L274;
        if (r10 == true) goto L274;
        a("AP MIDDLEWARE_RESULT allow inside_area stationary confidence=" + r22.getDouble("poi_confidence", -1.0d), System.currentTimeMillis());
    L274:
        r22.putBoolean("is_enter", true);
        g("notifyNearPoiReport extras=" + a(r22));
        a("AP MIDDLEWARE_RESULT accepted poi=" + r22.getString("poi_name", "") + " confidence=" + r22.getDouble("poi_confidence", -1.0d), System.currentTimeMillis());
        String r34 = r22.getString("poi_id", "");
        final com.obric.cae.location.geosdk.poi.b r35 = r111.f7185b;
        String r36 = this.aL;
        if (r35 != com.obric.cae.location.geosdk.poi.b.f7217a) goto L277;
    L276:
        k r37 = k.c;
    L290:
        if (r37 != k.f7182a) goto L293;
        a(r11, true, "keep_current");
        a("AP SHADOW keep current poiId=" + this.aL + " reported=" + r34 + " context=" + r112, System.currentTimeMillis());
        return;
    L293:
        a(r11, true, "trusted_result");
        if (r37 != k.f7183b) goto L306;
        final e r38 = this.aM;
        PoiWifiScanBridge r39 = this.aH;
        if (r39 == null) goto L298;
        int r40 = r39.getSessionEpoch();
    L302:
        final e r41 = new e(r34, r40);
        a("AP SHADOW handoff oldPoiId=" + this.aL + " newPoiId=" + r34 + " context=" + r112, System.currentTimeMillis());
        if (r38 == null) goto L306;
        new h().a(new $$Lambda$StarPoiManager$_rvRd11N5hORU4vmipkCpLoreS4(this, r38), new $$Lambda$StarPoiManager$BWnEzK6HTgOZqEQrbshh3zVAUUg(this, r41, r22), new $$Lambda$StarPoiManager$nlESIzRufm6_71f9iIGM8ATVWh4(this, r22, r35, r41), new $$Lambda$StarPoiManager$kdeCBXcZVxlXJyHoX_RbINLvC4(this, r41));
        return;
    L298:
        PoiAwareBridge r42 = this.av;
        if (r42 != null) goto L301;
        r40 = 0;
        goto L302
    L301:
        r40 = r42.getSessionEpoch();
    L306:
        this.w = new Bundle(r22);
        b("enter", r22);
        if (r10 == false) goto L309;
        return;
    L309:
        b(r35);
        if (TextUtils.isEmpty(r34) == true) goto L322;
        if (a(this.D) == false) goto L322;
        PoiWifiScanBridge r43 = this.aH;
        if (r43 == null) goto L316;
        int r113 = r43.getSessionEpoch();
    L320:
        a(new e(r34, r113), r22);
        goto L322
    L316:
        PoiAwareBridge r44 = this.av;
        if (r44 != null) goto L319;
        r113 = 0;
        goto L320
    L319:
        r113 = r44.getSessionEpoch();
    L322:
        if (a(this.D) == false) goto L329;
        a(this.E);
        return;
    L329:
        return;
    L277:
        if (r29 == false) goto L276;
        if (r36 == null) goto L276;
        if (r36.isEmpty() == true) goto L276;
        if (r34 != null) goto L283;
    L288:
        r37 = k.f7182a;
        goto L290
    L283:
        if (r34.isEmpty() == true) goto L288;
        if (r36.equals(r34) == true) goto L288;
        r37 = k.f7183b;
        goto L290
    L264:
        if (r22.getDouble("poi_confidence", -1.0d) <= 0.8d) goto L265;
    L266:
        r33 = false;
        goto L267
    L236:
        if (this.I == false) goto L238;
    L253:
        boolean r45 = false;
    L254:
        if (r45 == false) goto L257;
        a("AP MIDDLEWARE_RESULT rejected reason=empty_poi", System.currentTimeMillis());
        a("empty_poi_name_non_mall_aoi", r22);
        g("skip notifyNearPoiReport empty poi name and unsupported aoi type, extras=" + a(r22));
        a(r11, false, "empty_poi");
        return;
    L238:
        if (TextUtils.isEmpty(r22.getString("poi_name")) == false) goto L253;
        if (d.contains(r22.getString("aoi_new_type_code_l3", "").trim()) == true) goto L250;
        String r46 = r22.getString("aoi_new_type_name_l3", "");
        if (r46.contains("美食城") == true) goto L250;
        if (r46.contains("商场") == true) goto L250;
        if (r46.contains("步行街") == true) goto L250;
        boolean r47 = false;
    L251:
        if (r47 == true) goto L253;
        r45 = true;
    L250:
        r47 = true;
        goto L251
    L209:
        if (r28 == 3) goto L211;
        r1 = "INVALID_RESULT";
        goto L214
    L211:
        r1 = "ENTER_CONFIRMED";
        goto L214
    L213:
        r1 = "LOW_CONFIDENCE";
        goto L214
    L187:
        if (r25 == true) goto L189;
    L190:
        if (r8 == true) goto L192;
    L191:
        r26 = new l(m.f7186a, com.obric.cae.location.geosdk.poi.b.f7217a);
        goto L186
    L192:
        if (r21 == true) goto L194;
    L200:
        if (r21 == true) goto L202;
    L204:
        r26 = new l(m.d, r19);
        goto L186
    L202:
        if (r110 >= r24) goto L204;
        r26 = new l(m.f7187b, com.obric.cae.location.geosdk.poi.b.f7217a);
        goto L186
    L194:
        if (Double.isFinite(r110) == true) goto L196;
    L199:
        r26 = new l(m.f7186a, com.obric.cae.location.geosdk.poi.b.f7217a);
        goto L186
    L196:
        if (r110 < 0.0d) goto L199;
        if (r110 <= 1.0d) goto L200;
    L189:
        if (r20 != 1) goto L191;
    L180:
        if (this.K == true) goto L183;
        if (r20 == 1) goto L183;
        a("AP MIDDLEWARE_RESULT acc_qualified bypassed raw=" + r20, System.currentTimeMillis());
    L173:
        r19 = (com.obric.cae.location.geosdk.poi.b) ZeusTransformUtils.preCheckCast(this.bb.get(r18), com.obric.cae.location.geosdk.poi.b.class, "com.obric.memorydata.plugin");
        if (r19 != null) goto L177;
    L176:
        r19 = com.obric.cae.location.geosdk.poi.b.f7217a;
        goto L177
    L117:
        if (r22.containsKey("timestamp") == true) goto L119;
    L135:
        boolean r48 = false;
    L136:
        if (r48 == true) goto L138;
    L157:
        boolean r49 = false;
    L158:
        if (r49 == false) goto L160;
        r8 = true;
        goto L161
    L138:
        if (r22.containsKey("sdk_logid") != r22.containsKey("scene_logid")) goto L140;
        boolean r50 = true;
    L141:
        if (r50 == false) goto L157;
        if (r22.containsKey("poi_id") != r22.containsKey("poi_confidence")) goto L145;
        boolean r51 = true;
    L146:
        if (r51 == false) goto L157;
        if (r22.containsKey("aoi_id") != r22.containsKey("aoi_confidence")) goto L150;
        boolean r52 = true;
    L151:
        if (r52 == false) goto L157;
        if (TextUtils.isEmpty(r22.getString("poi_name")) == true) goto L155;
    L156:
        r49 = true;
        goto L158
    L155:
        if (TextUtils.isEmpty(r22.getString("aoi_name")) == true) goto L157;
    L150:
        r52 = false;
        goto L151
    L145:
        r51 = false;
        goto L146
    L140:
        r50 = false;
        goto L141
    L119:
        if (r22.containsKey("near_the_poi") == false) goto L135;
        if (r22.containsKey("near_the_aoi") == false) goto L135;
        if (r22.containsKey("new_type_name_l1") == false) goto L135;
        if (r22.containsKey("new_type_name_l2") == false) goto L135;
        if (r22.containsKey("new_type_name_l3") == false) goto L135;
        if (r22.containsKey("new_type_code_l1") == false) goto L135;
        if (r22.containsKey("new_type_code_l2") == false) goto L135;
        if (r22.containsKey("new_type_code_l3") == false) goto L135;
        r48 = true;
        goto L136
    L107:
        if (TextUtils.isEmpty(r22.getString("poi_name")) == false) goto L114;
        if (TextUtils.isEmpty(r22.getString("aoi_id")) == false) goto L114;
        if (TextUtils.isEmpty(r22.getString("aoi_name")) == false) goto L114;
        r7 = false;
        goto L115
    L100:
        if ("1".equals(r3) == true) goto L103;
        r15 = false;
        goto L105
    L88:
        if ("false".equalsIgnoreCase(r3) == true) goto L93;
        if ("0".equals(r3) == true) goto L93;
        r6 = false;
        goto L94
    L82:
        if ("1".equals(r3) == true) goto L85;
        r4 = false;
    L78:
        r14 = true;
    L65:
        e r53 = this.aM;
        if (r11 != null) goto L68;
    L70:
        boolean r54 = false;
    L71:
        if (r54 == true) goto L74;
        a("AP MIDDLEWARE_RESULT rejected reason=active_identity_changed", System.currentTimeMillis());
        a(r11, false, "active_identity_changed");
        return;
    L68:
        if (Objects.equals(r11.f, r53) == false) goto L70;
        r54 = true;
        goto L71
    L18:
        long r55 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L56
        if (r11 != null) goto L21;
    L46:
        r5 = -1;
    L47:
        monitor-exit(this);
        goto L48
    L21:
        if (r11.g == true) goto L46;
        long r114 = r11.d;     // Catch: Throwable -> L56
        if (r55 > r114) goto L46;
        if (r23 != 0) goto L27;
        long r115 = r11.e;     // Catch: Throwable -> L56
        long r56 = r11.c;     // Catch: Throwable -> L56
        long r57 = (r55 - r56) + r115;     // Catch: Throwable -> L56
        long r116 = (r114 - r56) + r115;     // Catch: Throwable -> L56
        if (r2 < 1000000000) goto L36;
        if (r2 >= 10000000000L) goto L36;
        r2 = r2 * 1000;     // Catch: Throwable -> L56
    L40:
        if (r2 < r115) goto L46;
        if (r2 > Math.min(r116, r57 + 5000)) goto L46;
    L44:
        r11.g = true;     // Catch: Throwable -> L56
        r5 = r11.f7180b;     // Catch: Throwable -> L56
    L36:
        if (r2 >= 1000000000000L) goto L40;
        r2 = -1;
        goto L40
    L27:
        if (r23 == r11.f7179a) goto L44;
    L59:
        r13 = 0;
        goto L61
    }

    public final void a(final BDLocation r3) {
        j r0 = this.Z;
        if (r0 == null) goto L6;
        r0.post(new $$Lambda$StarPoiManager$QQovzsBQpVgKFNcZwgiKur2gneE(this, r3));
        return;
    }

    public final void a(BDLocation r17, String r18) {
        if (m() == true) goto L6;
        return;
    L6:
        if (this.at == 1) goto L8;
    L15:
        StringBuilder r0 = com.obric.cae.location.city.f.a("AP LOCATION_RESULT source=", r18, " state=").append(this.D).append(" valid=");
        if (r17 == null) goto L18;
        boolean r7 = true;
    L19:
        a(r0.append(r7).toString(), System.currentTimeMillis());
        if (this.D != com.obric.cae.location.geosdk.poi.c.f7219a) goto L24;
        a("AP LOCATION_RESULT ignored reason=state_stopped", System.currentTimeMillis());
        b("state_stopped");
        a(this.aw, "state_stopped");
        return;
    L24:
        if (r17 != null) goto L27;
        com.obric.cae.log.a.h("StarLocation-PoiManager", "skip null location, source=" + r18);
        b("null_location");
        a(this.aw, "null_location");
        return;
    L27:
        String r8 = r17.getExtra();
        com.obric.cae.log.a.d("StarLocation-PoiManager", com.obric.cae.location.city.f.a("source=", r18, ", submitLogId=").append(r17.getSubmitLogId()).append(", locationType=").append(r17.getLocationType()).append(", locationSdk=").append(r17.getLocationSDKName()).append(", poi=").append(r17.getPoi()).append(", aoi=").append(r17.getAoi()).append(", geoPoiList=").append(r17.getGeoPoiList()).append(", geoAoiList=").append(r17.getGeoAoiList()).append(", poiEntities=").append(a(r17.getPoiEntities())).append(", aoiEntities=").append(a(r17.getAoiEntities())).append(", locInfoRsp=").append(r17.getLocInfoRsp()).append(", locationResult=").append(r17.getLocationResult()).toString());
        String r1 = "rawExtra source=" + r18 + ", extra=";
        if (r8 != null) goto L32;
        StringBuilder r2 = new StringBuilder().append(r1).append("null");
    L30:
        com.obric.cae.log.a.d("StarLocation-PoiManager", r2.toString());
    L38:
        if (TextUtils.isEmpty(r8) == false) goto L53;
        com.obric.cae.log.a.f("StarLocation-PoiManager", "skip empty extra, source=" + r18);
        com.obric.cae.location.geosdk.poi.c r3 = this.D;
        if (r3 != com.obric.cae.location.geosdk.poi.c.c) goto L42;
    L47:
        boolean r5 = true;
    L48:
        if (r5 == false) goto L50;
        b(com.obric.cae.location.geosdk.poi.c.f7220b);
    L50:
        b("empty_location_extra");
        a(this.aw, "empty_location_extra");
        return;
    L42:
        if (r3 == com.obric.cae.location.geosdk.poi.c.d) goto L47;
        if (r3 == com.obric.cae.location.geosdk.poi.c.e) goto L47;
        r5 = false;
        goto L48
    L53:
        if (this.I == false) goto L56;
        a("AP LOCATION_GATE bypassed", System.currentTimeMillis());
        t();
        return;
    L56:
        Bundle r6 = null;
        JSONObject r10 = new JSONObject(r8);     // Catch: JSONException -> L89
        if (r10.has("common_general_restrict_nearby_the_poi") == true) goto L60;
    L66:
        String r11 = null;
    L68:
        if (r10.has("common_general_restrict_nearby_the_aoi") == true) goto L70;
    L76:
        String r12 = null;
    L78:
        if (TextUtils.isEmpty(r11) == true) goto L80;
    L82:
        Bundle r4 = new Bundle();     // Catch: JSONException -> L89
        if (TextUtils.isEmpty(r11) == true) goto L86;
        r4.putString("common_general_restrict_nearby_the_poi", r11);     // Catch: JSONException -> L89
    L86:
        if (TextUtils.isEmpty(r12) == true) goto L88;
        r4.putString("common_general_restrict_nearby_the_aoi", r12);     // Catch: JSONException -> L89
    L88:
        r6 = r4;
    L91:
        if (r6 != null) goto L105;
        com.obric.cae.location.geosdk.poi.c r9 = this.D;
        if (r9 != com.obric.cae.location.geosdk.poi.c.c) goto L95;
    L100:
        boolean r13 = true;
    L101:
        if (r13 == false) goto L103;
        b(com.obric.cae.location.geosdk.poi.c.f7220b);
    L103:
        b("near_fields_missing");
        a(this.aw, "near_fields_missing");
        return;
    L95:
        if (r9 == com.obric.cae.location.geosdk.poi.c.d) goto L100;
        if (r9 == com.obric.cae.location.geosdk.poi.c.e) goto L100;
        r13 = false;
        goto L101
    L105:
        this.u = r6.getString("common_general_restrict_nearby_the_poi", "false");
        this.v = r6.getString("common_general_restrict_nearby_the_aoi", "false");
        com.obric.cae.log.a.f("StarLocation-PoiManager", com.obric.cae.location.city.f.a("source=", r18, ", nearPoi=").append(this.u).append(", nearAoi=").append(this.v).toString());
        String r14 = this.u;
        if ("true".equalsIgnoreCase(r14) == false) goto L108;
    L111:
        boolean r15 = true;
    L112:
        String r16 = this.v;
        if ("true".equalsIgnoreCase(r16) == false) goto L115;
    L118:
        boolean r19 = true;
    L119:
        if (r15 == true) goto L124;
        if (r19 == true) goto L124;
        b("not_near_poi");
        a(this.aw, "not_near_poi");
        return;
    L124:
        if (this.D != com.obric.cae.location.geosdk.poi.c.f7220b) goto L126;
        a("AP LOCATION_GATE preserve INSIDE_AREA until middleware result", System.currentTimeMillis());
    L126:
        t();
        return;
    L115:
        if ("1".equals(r16) == true) goto L118;
        r19 = false;
        goto L119
    L108:
        if ("1".equals(r14) == true) goto L111;
        r15 = false;
        goto L112
    L80:
        if (TextUtils.isEmpty(r12) == false) goto L82;
        com.obric.cae.log.a.d("StarLocation-PoiManager", "skip missing near poi fields, source=" + r18 + ", keys=" + r10.names());     // Catch: JSONException -> L89
        goto L91
    L70:
        if (r10.isNull("common_general_restrict_nearby_the_aoi") == true) goto L76;
        Object r110 = r10.opt("common_general_restrict_nearby_the_aoi");     // Catch: JSONException -> L89
        if (r110 == null) goto L76;
        r12 = String.valueOf(r110);     // Catch: JSONException -> L89
        goto L78
    L60:
        if (r10.isNull("common_general_restrict_nearby_the_poi") == true) goto L66;
        Object r111 = r10.opt("common_general_restrict_nearby_the_poi");     // Catch: JSONException -> L89
        if (r111 == null) goto L66;
        r11 = String.valueOf(r111);     // Catch: JSONException -> L89
    L89:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-PoiManager", "invalid extra=" + r8, e);
        goto L91
    L32:
        if (r8.length() > 1800) goto L34;
        r2 = new StringBuilder().append(r1).append(r8);
        goto L30
    L34:
        int r112 = ((r8.length() + 1800) - 1) / 1800;
        int r113 = 0;
    L35:
        if (r113 >= r112) goto L38;
        int r114 = r113 * 1800;
        r113 = r113 + 1;
        com.obric.cae.log.a.d("StarLocation-PoiManager", com.obric.cae.libs.statemachine.e.a(new StringBuilder().append(r1).append("chunk="), r113, "/", r112, ", ").append(r8.substring(r114, Math.min(r8.length(), r114 + 1800))).toString());
        goto L35
    L18:
        r7 = false;
        goto L19
    L8:
        if (f() == false) goto L15;
        if (this.aw != 0) goto L15;
        if (this.aU != 0) goto L15;
        a("AP LOCATION_RESULT ignored reason=no_adsp_request", System.currentTimeMillis());
    }

    public final void a(e r4, Bundle r5) {
        if (r4.equals(this.aM) == false) goto L5;
        return;
    L5:
        this.aM = r4;
        this.aL = r4.f7172a;
        this.aN = new Bundle(r5);
        this.w = new Bundle(r5);
        this.aO = SystemClock.elapsedRealtime();
        this.aP = this.ab;
        this.aQ = 0;
        o r0 = this.aR;
        if (Objects.equals(r0.f7189b, r4) == true) goto L8;
        r0.f7189b = r4;
        r0.f7188a = p.f7190a;
        r0.c = -1;
    L8:
        this.aS = false;
        this.aT = false;
        a("AP ACTIVE_POI start poiId=" + r4.f7172a + " sessionEpoch=" + r4.f7173b + " entrySteps=" + this.aP, System.currentTimeMillis());
    }

    public final synchronized void a(i r4, boolean r5, String r6) {
        monitor-enter(this);
        if (r4 != null) goto L30;
    L28:
        monitor-exit(this);
        return;
    L30:
    L25:
        th = move-exception;
        throw th;
    L5:
        if (r4 != this.aX) goto L28;
        this.aX = null;     // Catch: Throwable -> L25
        if (r4.f7180b != 1) goto L22;
        if (r5 == false) goto L16;
        o r7 = this.aR;     // Catch: Throwable -> L25
        e r8 = r4.f;     // Catch: Throwable -> L25
        if (r7.f7188a == p.f7191b) goto L13;
    L15:
        this.aQ = 1;     // Catch: Throwable -> L25
    L21:
        a("AP SHADOW budget=" + this.aR.f7188a + " source=" + r6, System.currentTimeMillis());     // Catch: Throwable -> L25
        goto L22
    L13:
        if (Objects.equals(r7.f7189b, r8) == false) goto L15;
        r7.f7188a = p.c;     // Catch: Throwable -> L25
        goto L15
    L16:
        o r9 = this.aR;     // Catch: Throwable -> L25
        e r10 = r4.f;     // Catch: Throwable -> L25
        if (r9.f7188a != p.f7191b) goto L21;
        if (Objects.equals(r9.f7189b, r10) == false) goto L21;
        r9.f7188a = p.f7190a;     // Catch: Throwable -> L25
    L22:
        a(this.aw, "query_".concat(r6));     // Catch: Throwable -> L25
        monitor-exit(this);
    }

    public final synchronized void a(com.obric.cae.location.geosdk.poi.b r5) {
        monitor-enter(this);
        g();     // Catch: Throwable -> L24
        PoiWifiScanBridge r0 = this.aH;     // Catch: Throwable -> L24
        if (r0 != null) goto L7;
        monitor-exit(this);
        return;
    L7:
        int r6 = r5.ordinal();     // Catch: Throwable -> L24
        boolean r1 = false;
        int r2 = 2;
        if (r6 == 1) goto L11;
        if (r6 == 2) goto L13;
        r2 = 0;
    L13:
        if (this.aK == r2) goto L15;
        r1 = true;
    L15:
        this.aI = true;     // Catch: Throwable -> L24
        this.aK = r2;     // Catch: Throwable -> L24
        if (this.aJ == false) goto L21;
        if (r1 == false) goto L21;
        r0.updateTask(b(r2));     // Catch: Throwable -> L24
        com.obric.cae.log.a.f("StarLocation-PoiManager", "POI_WIFI production update storeType=" + r2);     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L21:
        h();     // Catch: Throwable -> L24
        monitor-exit(this);
        return;
    L11:
        r2 = 1;
    L24:
        th = move-exception;
        throw th;
    }

    public final void a(final PoiAwareBridge r3) {
        this.Z.postDelayed(new $$Lambda$StarPoiManager$aSZF_00rYCzTs0E7dBlGpLvtOQQ(this, r3), i);
    }

    public final void a(String r2, long r3) {
        String r4 = r3 + " " + r2;
        ArrayDeque<String> r5 = this.r;
        monitor-enter(r5);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.r.size() < 200) goto L7;
        this.r.removeFirst();     // Catch: Throwable -> L10
    L7:
        this.r.addLast(r4);     // Catch: Throwable -> L10
        monitor-exit(r5);     // Catch: Throwable -> L10
    }

    public final void a(String r12, String r13, i r14, boolean r15, com.obric.cae.location.geosdk.poi.b r16, double r17) {
        Context r2 = this.t;
        if (r2 != null) goto L5;
        return;
    L5:
        Bundle r10 = new Bundle();
        PoiWifiScanBridge r3 = this.aH;
        int r4 = 0;
        if (r3 == null) goto L8;
        int r5 = r3.getSessionEpoch();
    L12:
        r10.putInt("sessionEpoch", r5);
        PoiAwareBridge r6 = this.av;
        if (r6 != null) goto L15;
        int r7 = 0;
    L16:
        r10.putInt("stateVersion", r7);
        PoiWifiScanBridge r8 = this.aH;
        if (r8 != null) goto L19;
        int r9 = 0;
    L20:
        r10.putInt("configVersion", r9);
        r10.putString("state", this.D.name());
        r10.putInt("requestId", this.aw);
        r10.putBoolean("nearThePoi", r15);
        r10.putDouble("confidence", r17);
        r10.putString(EventBody.KEY_CATEGORY, r16.name());
        if (r14 == null) goto L24;
        r4 = r14.f7180b;
    L24:
        r10.putInt("queryContext", r4);
        PoiAdspTraceLogger.getInstance(r2).append("ap_result", "REQUEST_COMPLETE", "cae", "AP_POI_RESULT", r12, r13, r10);
        return;
    L19:
        r9 = r8.getConfig().configVersion;
        goto L20
    L15:
        r7 = r6.getStateVersion();
        goto L16
    L8:
        PoiAwareBridge r11 = this.av;
        if (r11 != null) goto L11;
        r5 = 0;
        goto L12
    L11:
        r5 = r11.getSessionEpoch();
        goto L12
    }

    public final boolean a(long r5) {
        long r0 = this.af;
        if (this.ae != 0) goto L5;
    L9:
        return false;
    L5:
        if (r0 <= 0) goto L9;
        if ((r5 - r0) > h) goto L9;
        return true;
    }

    public final PoiWifiScanBridge.Config b(int r8) {
        long r0 = SystemClock.elapsedRealtime();
        if (r0 < this.aO) goto L5;
        long r1 = r0 - this.aO;
    L6:
        PoiWifiScanBridge.Config r7 = new PoiWifiScanBridge.Config();
        r7.algorithmVersion = 130;
        r7.storeConfirmedElapsedMs = (int) Math.min(4294967295L, Math.max(0, r1));
        r7.scanWatchdogSeconds = 30;
        r7.eventAckTimeoutSeconds = 5;
        r7.retryBackoffInitialSeconds = 5;
        r7.retryBackoffMaxSeconds = 20;
        r7.minimumAnchorCountForStrongExit = 8;
        r7.minimumStrongExitDensityPercent = 25;
        r7.taskType = 2;
        r7.scheduleMode = 1;
        r7.intervalSeconds = 20;
        r7.reportMode = 0;
        r7.scanType = 1;
        r7.bandMask = 3;
        r7.radioChainPref = 2;
        r7.storeType = r8;
        return r7;
    L5:
        r1 = 0;
        goto L6
    }

    public final void b() {
        this.s.scheduleWithFixedDelay(new $$Lambda$MnzJdUPke6IzqxFEf9vKfZpPVIQ(this), 10000, e, TimeUnit.MILLISECONDS);
    }

    public void b(Context r14) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r14, Context.class, "com.obric.memorydata.plugin");
        if (this.m.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        com.obric.cae.log.a.f("StarLocation-PoiManager", CommonConsts.APM_INNER_EVENT_COST_INIT);
        this.t = ZeusTransformUtils.wrapperContext(r2, "com.obric.memorydata.plugin");
        if (Settings.Global.getInt(r2.getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_ENABLE_POI_DETECT_FUNCTION, 0) != 1) goto L8;
        boolean r4 = true;
    L9:
        this.f7166J = r4;
        this.L = com.obric.cae.location.city.a.a(r2);
        a(r2);
        com.obric.cae.location.geosdk.bytedance.a.a().a(r2);
        XmlResourceParser r6 = ZeusTransformUtils.getResources(r2, "com.obric.memorydata.plugin").getXml(ZeusTransformUtils.mapRes(com.obric.memorydata.plugin.R.xml.poi_category_mapping, "xml", "poi_category_mapping"));     // Catch: Throwable -> L55
        int r7 = r6.getEventType();     // Catch: Throwable -> L55
        com.obric.cae.location.geosdk.poi.b r8 = com.obric.cae.location.geosdk.poi.b.f7217a;     // Catch: Throwable -> L55
        String r9 = null;
    L11:
        if (r7 == 1) goto L53;
        String r10 = r6.getName();     // Catch: Throwable -> L55
        if (r7 == 2) goto L23;
        if (r7 != 3) goto L52;
        if ("category_l1".equals(r10) == false) goto L52;
        com.obric.cae.location.geosdk.poi.b r11 = com.obric.cae.location.geosdk.poi.b.f7217a;     // Catch: Throwable -> L55 Throwable -> L55
        r9 = null;
    L52:
        r7 = r6.next();     // Catch: Throwable -> L55 Throwable -> L55
        goto L11
    L23:
        if ("category_l1".equals(r10) == false) goto L38;
        String r12 = r6.getAttributeValue(null, ActivityLifecycle.NAME);     // Catch: Throwable -> L55 Throwable -> L55
        String r13 = r6.getAttributeValue(null, "default");     // Catch: Throwable -> L55 Throwable -> L55
        if (r13 != null) goto L27;
    L26:
        com.obric.cae.location.geosdk.poi.b r15 = com.obric.cae.location.geosdk.poi.b.f7217a;     // Catch: Throwable -> L55 Throwable -> L55
    L34:
        if (r12 == null) goto L36;
        this.bb.put(r12.toLowerCase(Locale.ROOT), r15);     // Catch: Throwable -> L55 Throwable -> L55
    L36:
        r9 = r12;
        goto L52
    L27:
        String r16 = r13.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L55 Throwable -> L55
        r16.getClass();     // Catch: Throwable -> L55 Throwable -> L55
        if (r16.equals("walkable") == false) goto L30;
        r15 = com.obric.cae.location.geosdk.poi.b.c;     // Catch: Throwable -> L55 Throwable -> L55
        goto L34
    L30:
        if (r16.equals("sittable") == false) goto L26;
        r15 = com.obric.cae.location.geosdk.poi.b.f7218b;     // Catch: Throwable -> L55 Throwable -> L55
        goto L34
    L38:
        if ("category_l2".equals(r10) == false) goto L52;
        if (r9 == null) goto L52;
        String r17 = r6.getAttributeValue(null, ActivityLifecycle.NAME);     // Catch: Throwable -> L55 Throwable -> L55
        String r18 = r6.getAttributeValue(null, "type");     // Catch: Throwable -> L55 Throwable -> L55
        if (r18 != null) goto L43;
    L42:
        com.obric.cae.location.geosdk.poi.b r19 = com.obric.cae.location.geosdk.poi.b.f7217a;     // Catch: Throwable -> L55 Throwable -> L55
    L50:
        if (r17 == null) goto L52;
        this.bc.put((r9 + "_" + r17).toLowerCase(Locale.ROOT), r19);     // Catch: Throwable -> L55 Throwable -> L55
        goto L52
    L43:
        String r20 = r18.toLowerCase(Locale.ROOT);     // Catch: Throwable -> L55 Throwable -> L55
        r20.getClass();     // Catch: Throwable -> L55 Throwable -> L55
        if (r20.equals("walkable") == false) goto L46;
        r19 = com.obric.cae.location.geosdk.poi.b.c;     // Catch: Throwable -> L55 Throwable -> L55
        goto L50
    L46:
        if (r20.equals("sittable") == false) goto L42;
        r19 = com.obric.cae.location.geosdk.poi.b.f7218b;     // Catch: Throwable -> L55 Throwable -> L55
        goto L50
    L53:
        com.obric.cae.log.a.f("StarLocation-PoiManager", "loadPoiCategoryConfig success: l1=" + this.bb.size() + ", l2=" + this.bc.size());     // Catch: Throwable -> L55 Throwable -> L55
    L57:
        b();
        if (this.n.compareAndSet(false, true) == true) goto L88;
    L64:
        this.Q = ((PowerManager) ZeusTransformUtils.preCheckCast(r2.getSystemService("power"), PowerManager.class, "com.obric.memorydata.plugin")).newWakeLock(1, "StarLocation-PoiManager");
        this.R = (AlarmManager) ZeusTransformUtils.preCheckCast(r2.getSystemService(NotificationCompat.CATEGORY_ALARM), AlarmManager.class, "com.obric.memorydata.plugin");
        String r110 = r2.getPackageName();
        this.S = PendingIntent.getBroadcast(r2, 1, new Intent("com.obric.cae.action.POI_ALARM_INSIDE_PERIOD").setPackage(r110), 201326592);
        this.T = PendingIntent.getBroadcast(r2, 4, new Intent("com.obric.cae.action.POI_ALARM_STATIONARY_STEP_CHECK").setPackage(r110), 201326592);
        this.U = PendingIntent.getBroadcast(r2, 5, new Intent("com.obric.cae.action.POI_ALARM_STATIONARY_DELAYED_QUERY").setPackage(r110), 201326592);
        HandlerThread r111 = new HandlerThread("StarPoiManagerThread");
        this.Y = r111;
        r111.start();
        this.Z = new j(this, this.Y.getLooper());
        if (this.f7166J == false) goto L67;
        g();
    L67:
        this.at = 1;
        j();
        Context r112 = this.t;
        if (r112 == null) goto L74;
        if (this.av != null) goto L74;
        PoiAwareBridge r0 = new PoiAwareBridge(r112, this.aY);
        this.av = r0;
        r0.start();
        a(this.av);
    L74:
        if (this.X != null) goto L77;
        this.X = new com.obric.cae.location.geosdk.poi.g(this, this.Z, r2);
        a(r2, AwareStateListener.SETTINGS_GLOBAL_ENABLE_POI_DETECT_FUNCTION);
        a(r2, AwareStateListener.SETTINGS_GLOBAL_ENABLE_POI_ACC_QUALIFIED_CHECK);
        a(r2, AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_DELAY_SECONDS);
        a(r2, AwareStateListener.SETTINGS_GLOBAL_POI_WALK_STEP_THRESHOLD);
        a(r2, AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_DELTA_THRESHOLD);
        a(r2, AwareStateListener.SETTINGS_GLOBAL_POI_STATIONARY_STEP_CHECK_INTERVAL_MS);
        a(r2, AwareStateListener.SETTINGS_GLOBAL_POI_CONFIDENCE_THRESHOLD);
        com.obric.cae.location.city.a.a(r2, this.X);
        a(r2, AwareStateListener.SETTINGS_GLOBAL_POI_TRIGGER_MODE);
    L77:
        this.aa = new com.obric.cae.location.geosdk.poi.h(this);
        UserAwareManager.getInstance().registerInnerCallback(this.aa);
        this.V = new com.obric.cae.location.geosdk.poi.i(this);
        IntentFilter r113 = new IntentFilter();
        r113.addAction("com.obric.cae.action.POI_ALARM_INSIDE_PERIOD");
        r113.addAction("com.obric.cae.action.POI_ALARM_STATIONARY_STEP_CHECK");
        r113.addAction("com.obric.cae.action.POI_ALARM_STATIONARY_DELAYED_QUERY");
        r113.addAction("android.intent.action.DATE_CHANGED");
        r113.addAction("android.intent.action.TIME_SET");
        r113.addAction("android.intent.action.TIMEZONE_CHANGED");
        ZeusTransformUtils.registerReceiver(r2, this.V, r113, 4, "com.obric.memorydata.plugin");
        if (this.W != null) goto L85;
        this.W = new com.obric.cae.location.geosdk.poi.j(this);
        IntentFilter r5 = new IntentFilter("com.obric.cae.poi.ALGORITHM_CONFIG");
        int r114 = Build.VERSION.SDK_INT;
        com.obric.cae.location.geosdk.poi.j r3 = this.W;
        j r21 = this.Z;
        if (r114 < 33) goto L83;
        ZeusTransformUtils.registerReceiver(r2, r3, r5, "android.permission.DUMP", r21, 2, "com.obric.memorydata.plugin");
        goto L85
    L83:
        ZeusTransformUtils.registerReceiver(r2, r3, r5, "android.permission.DUMP", r21, "com.obric.memorydata.plugin");
    L85:
        if (m() == true) goto L101;
        n();
        return;
    L101:
        return;
    L88:
        BDLocationAgent.addSubmitNotification(null, this.bd);     // Catch: Throwable -> L62
        com.obric.cae.log.a.f("StarLocation-PoiManager", "registered");     // Catch: Throwable -> L62
    L62:
        th = move-exception;
        this.n.set(false);
        com.obric.cae.log.a.b("StarLocation-PoiManager", "failed", th);
    L55:
        e = move-exception;
        com.obric.cae.log.a.b("StarLocation-PoiManager", "loadPoiCategoryConfig failed", e);
        goto L57
    L8:
        r4 = false;
        goto L9
    }

    public final void b(Bundle r18) {
        boolean r11 = false;
        if (f("wifi_identity_verify") == false) goto L11;
        int r2 = r18.getInt("wifiIdentityVerifyRetryCount", 0);
        if (r2 < 12) goto L7;
    L9:
        a("AP SHADOW verify rejected reason=transport_timeout", System.currentTimeMillis());
        return;
    L7:
        if (this.Z == null) goto L9;
        final Bundle r3 = new Bundle(r18);
        r3.putInt("wifiIdentityVerifyRetryCount", r2 + 1);
        this.Z.postDelayed(new $$Lambda$StarPoiManager$KrFQJp565miqNvCFUOaPkEkD6uU(this, r3), 5000);
        return;
    L11:
        monitor-enter(this);
    L58:
        th = move-exception;
        throw th;
    L13:
        if (this.aI == false) goto L63;
        PoiWifiScanBridge r7 = this.aH;     // Catch: Throwable -> L58
        if (r7 == null) goto L22;
        PoiWifiScanBridge.Config r13 = r7.getConfig();     // Catch: Throwable -> L58
        if (r18.getInt("sessionEpoch", -1) != r7.getSessionEpoch()) goto L22;
        if (r18.getInt("configVersion", -1) != r13.configVersion) goto L22;
        boolean r8 = true;
    L23:
        if (r8 == false) goto L63;
        if (TextUtils.isEmpty(this.aL) == true) goto L63;
        if (this.aM == null) goto L63;
        if (this.aX == null) goto L32;
    L52:
        int r4 = r18.getInt("wifiIdentityVerifyRetryCount", 0);     // Catch: Throwable -> L58
        if (r4 < 12) goto L55;
    L60:
        String r0 = "AP SHADOW verify rejected reason=query_busy_timeout poiId=" + this.aL;     // Catch: Throwable -> L58
        long r5 = System.currentTimeMillis();     // Catch: Throwable -> L58
    L57:
        a(r0, r5);     // Catch: Throwable -> L58
        monitor-exit(this);     // Catch: Throwable -> L58
        return;
    L55:
        if (this.Z == null) goto L60;
        final Bundle r6 = new Bundle(r18);     // Catch: Throwable -> L58
        int r9 = r4 + 1;     // Catch: Throwable -> L58
        r6.putInt("wifiIdentityVerifyRetryCount", r9);     // Catch: Throwable -> L58
        this.Z.postDelayed(new $$Lambda$StarPoiManager$8S6A_AQw3gESKEOo9DQKXg1R8pw(this, r6), 5000);     // Catch: Throwable -> L58
        r0 = "AP SHADOW verify deferred reason=query_busy poiId=" + this.aL + " retry=" + r9;     // Catch: Throwable -> L58
        r5 = System.currentTimeMillis();     // Catch: Throwable -> L58
        goto L57
    L32:
        if (this.o.get() == true) goto L52;
        long r10 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L58
        o r12 = this.aR;     // Catch: Throwable -> L58
        if (this.aM.equals(r12.f7189b) == true) goto L37;
    L44:
        if (r11 == true) goto L48;
        a("AP SHADOW verify rejected reason=budget poiId=" + this.aL + " state=" + this.aR.f7188a, System.currentTimeMillis());     // Catch: Throwable -> L58
        monitor-exit(this);     // Catch: Throwable -> L58
        return;
    L48:
        this.aU = 1;     // Catch: Throwable -> L58
        this.aV = r10 + 60000;     // Catch: Throwable -> L58
        a("AP SHADOW verify accepted source=POI_WIFI poiId=" + this.aL + " details=" + r18, System.currentTimeMillis());     // Catch: Throwable -> L58
        monitor-exit(this);     // Catch: Throwable -> L58
        p();
        return;
    L37:
        if (r12.f7188a != p.f7190a) goto L44;
        long r14 = r12.c;     // Catch: Throwable -> L58
        if (r14 >= 0) goto L41;
    L43:
        r12.f7188a = p.f7191b;     // Catch: Throwable -> L58
        r12.c = r10;     // Catch: Throwable -> L58
        r11 = true;
        goto L44
    L41:
        if ((r10 - r14) >= 300000) goto L43;
    L22:
        r8 = false;
    L63:
        a("AP SHADOW verify rejected reason=stale_or_no_active_poi details=" + r18, System.currentTimeMillis());     // Catch: Throwable -> L58
        monitor-exit(this);     // Catch: Throwable -> L58
    }

    public void b(Bundle r4, final int r5) {
        j r0 = this.Z;
        if (r0 != null) goto L5;
    L8:
        a(r4, r5);
        return;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        final Bundle r1 = new Bundle(r4);
        r0.post(new $$Lambda$StarPoiManager$Xvaf59C2_TM21A5_yQC2EV13nOo(this, r1, r5));
    }

    public final void b(com.obric.cae.location.geosdk.poi.b r4) {
        com.obric.cae.location.geosdk.poi.c r0 = this.D;
        com.obric.cae.location.geosdk.poi.c r1 = com.obric.cae.location.geosdk.poi.c.f7219a;
        if (r0 != r1) goto L7;
        com.obric.cae.log.a.h("StarLocation-PoiManager", "skip poi detect result in detect stopped");
        return;
    L7:
        if (r4 == com.obric.cae.location.geosdk.poi.b.f7217a) goto L9;
        int r2 = this.D.ordinal();
        if (r2 != 1) goto L16;
        b(com.obric.cae.location.geosdk.poi.c.c);
        if (r4 == com.obric.cae.location.geosdk.poi.b.f7218b) goto L24;
    L27:
        com.obric.cae.location.geosdk.poi.c r3 = com.obric.cae.location.geosdk.poi.c.e;
    L28:
        b(r3);
    L35:
        this.E = r4;
        this.al = System.currentTimeMillis();
        return;
    L24:
        r3 = com.obric.cae.location.geosdk.poi.c.d;
        goto L28
    L16:
        if (r2 == 2) goto L30;
        if (r2 == 3) goto L26;
        if (r2 == 4) goto L23;
        com.obric.cae.log.a.j("StarLocation-PoiManager", "unexpected state in handlePoiDetectResult: " + this.D);
        goto L35
    L23:
        if (r4 != com.obric.cae.location.geosdk.poi.b.f7218b) goto L35;
    L26:
        if (r4 != com.obric.cae.location.geosdk.poi.b.c) goto L35;
    L30:
        if (r4 != com.obric.cae.location.geosdk.poi.b.f7218b) goto L27;
    L9:
        if (this.D == r1) goto L12;
        r1 = com.obric.cae.location.geosdk.poi.c.c;
    L12:
        b(r1);
        goto L35
    }

    public final void b(com.obric.cae.location.geosdk.poi.c r10) {
        if (m() == false) goto L5;
    L7:
        com.obric.cae.location.geosdk.poi.c r0 = this.D;
        if (r0 != r10) goto L11;
        return;
    L11:
        if (this.aw != 0) goto L13;
    L17:
        boolean r1 = false;
    L18:
        if (r1 == false) goto L21;
        a(this.aw, "before_state_" + r10);
    L21:
        if (r10 != com.obric.cae.location.geosdk.poi.c.f7219a) goto L23;
    L24:
        e("state_" + r10);
        d("state_" + r10);
    L25:
        com.obric.cae.log.a.f("StarLocation-PoiManager", "transition: " + r0 + " -> " + r10 + ", steps=" + this.ab);
        a("AP STATE_TRANSITION " + r0 + " -> " + r10, System.currentTimeMillis());
        int r2 = r0.ordinal();
        if (r2 == 0) goto L37;
        if (r2 == 1) goto L32;
        if (r2 == 2) goto L37;
        if (r2 == 3) goto L37;
        if (r2 == 4) goto L37;
        com.obric.cae.log.a.j("StarLocation-PoiManager", "unexpected state exit: " + r0);
        goto L37
    L32:
        AlarmManager r3 = this.R;
        if (r3 == null) goto L37;
        PendingIntent r4 = this.S;
        if (r4 == null) goto L37;
        r3.cancel(r4);
    L37:
        this.D = r10;
        this.ba.getClass();
        this.ac = this.ab;
        int r5 = r10.ordinal();
        if (r5 == 0) goto L44;
        if (r5 == 1) goto L50;
        if (r5 == 2) goto L50;
        if (r5 == 3) goto L50;
        if (r5 == 4) goto L50;
        com.obric.cae.log.a.j("StarLocation-PoiManager", "unexpected state enter: " + r10);
    L50:
        c(0);
        return;
    L44:
        AlarmManager r11 = this.R;
        if (r11 == null) goto L49;
        PendingIntent r6 = this.S;
        if (r6 == null) goto L49;
        r11.cancel(r6);
    L49:
        o();
        goto L50
    L23:
        if (r10 != com.obric.cae.location.geosdk.poi.c.f7220b) goto L25;
    L13:
        if (r10 != com.obric.cae.location.geosdk.poi.c.f7219a) goto L15;
    L16:
        r1 = true;
        goto L18
    L15:
        if (r10 != com.obric.cae.location.geosdk.poi.c.f7220b) goto L17;
    L5:
        if (r10 == com.obric.cae.location.geosdk.poi.c.f7219a) goto L7;
    }

    public final synchronized void b(String r5) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (this.aU == 1) goto L8;
        monitor-exit(this);
        return;
    L8:
        o r0 = this.aR;     // Catch: Throwable -> L16
        e r1 = this.aM;     // Catch: Throwable -> L16
        if (r0.f7188a == p.f7191b) goto L11;
    L13:
        this.aU = 0;     // Catch: Throwable -> L16
        this.aV = 0;     // Catch: Throwable -> L16
        a("AP SHADOW budget=" + this.aR.f7188a + " source=" + r5, System.currentTimeMillis());     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L11:
        if (Objects.equals(r0.f7189b, r1) == false) goto L13;
        r0.f7188a = p.f7190a;     // Catch: Throwable -> L16
        goto L13
    }

    public final void b(String r10, Bundle r11) {
        Iterator<Map.Entry<Integer, f>> r3 = this.l.entrySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L19;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r3.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Integer r5 = (Integer) ZeusTransformUtils.preCheckCast(r4.getKey(), Integer.class, "com.obric.memorydata.plugin");
        f r6 = (f) ZeusTransformUtils.preCheckCast(r4.getValue(), f.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L4;
        if (r6 == null) goto L4;
        com.obric.cae.libs.location.poi.c r7 = r6.f7174a;
        if (r7 == null) goto L4;
        r7.a(new Bundle(r11));     // Catch: Throwable -> L13 RemoteException -> L15
        com.obric.cae.log.a.d("StarLocation-PoiManager", "notify " + r10 + " pid=" + r5);     // Catch: Throwable -> L13 RemoteException -> L15
    L15:
        e = move-exception;
        this.l.remove(r5);
        r6.f7174a.asBinder().unlinkToDeath(r6.f7175b, 0);     // Catch: Throwable -> L20
    L18:
        com.obric.cae.log.a.b("StarLocation-PoiManager", "notify " + r10 + " failed for pid=" + r5, e);
    L13:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-PoiManager", "notify " + r10 + " failed for pid=" + r5, th);
        goto L4
    }

    public final void c() {
        if (m() == true) goto L6;
        return;
    L6:
        if (this.q.get() == false) goto L16;
        return;
    L16:
        boolean r2 = com.obric.cae.location.geosdk.bytedance.a.a().c();     // Catch: Throwable -> L13
        if (r2 == false) goto L11;
        this.q.set(true);     // Catch: Throwable -> L13
    L11:
        com.obric.cae.log.a.f("StarLocation-PoiManager", "success=" + r2);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        com.obric.cae.log.a.b("StarLocation-PoiManager", "failed", th);
    }

    public final void c(int r8) {
        PoiAwareBridge r0 = this.av;
        if (r0 == null) goto L36;
        r0.syncState(this.D.ordinal(), r8);
        a("AP STATE_SYNC state=" + this.D + " version=" + r0.getStateVersion() + " completedRequestId=" + r8, System.currentTimeMillis());
        if (r8 != 0) goto L37;
        this.au = false;
        if (this.at == 1) goto L9;
    L34:
        a(r0);
        return;
    L9:
        if (a(this.D) == false) goto L34;
        if (m() == false) goto L22;
        this.ag = this.ab;
        System.currentTimeMillis();
        this.ah = false;
        if (m() == false) goto L21;
        AlarmManager r1 = this.R;
        if (r1 == null) goto L21;
        if (this.T == null) goto L21;
        r1.setExactAndAllowWhileIdle(0, System.currentTimeMillis() + this.P, this.T);
    L21:
        com.obric.cae.log.a.d("StarLocation-PoiManager", "startStationaryStepCheck baseSteps=" + this.ag + ", state=" + this.D);
    L22:
        com.obric.cae.location.geosdk.poi.c r2 = this.D;
        if (r2 != com.obric.cae.location.geosdk.poi.c.f7219a) goto L25;
    L28:
        boolean r3 = true;
    L29:
        if (r3 == false) goto L34;
        if (this.ad.compareAndSet(false, true) == false) goto L34;
        UserAwareManager.getInstance().getSensorCollectManager().registerUpDownStairSensor();
        goto L34
    L25:
        if (r2 == com.obric.cae.location.geosdk.poi.c.f7220b) goto L28;
        r3 = false;
        goto L29
    L37:
        return;
    }

    public final void c(String r5) {
        Bundle r0 = this.aN;
        if (r0 != null) goto L6;
        a("AP LEAVE skipped reason=no_active_snapshot source=".concat(r5), System.currentTimeMillis());
        return;
    L6:
        Bundle r1 = new Bundle(r0);
        r1.putLong("timestamp", System.currentTimeMillis());
        r1.putBoolean("is_enter", false);
        r1.putString("leave_reason", r5);
        g("notifyNearPoiReport leave source=" + r5 + " extras=" + a(r1));
        b("leave", r1);
    }

    public final boolean c(Bundle r8) {
        PoiAwareBridge r0 = this.av;
        int r2 = -1;
        int r1 = r8.getInt("stateVersion", -1);
        int r3 = r8.getInt("state", -1);
        int r9 = r8.getInt("har", -1);
        boolean r4 = true;
        if (r0 != null) goto L5;
    L22:
        r4 = false;
    L23:
        if (r4 == true) goto L29;
        StringBuilder r5 = com.obric.cae.libs.statemachine.d.a("ignore stale/invalid ADSP transport event: eventVersion=", r1, ", currentVersion=");
        if (r0 == null) goto L28;
        r2 = r0.getStateVersion();
    L28:
        com.obric.cae.log.a.h("StarLocation-PoiManager", com.obric.cae.libs.statemachine.e.a(r5, r2, ", eventState=", r3, ", currentState=").append(this.D).append(", har=").append(r9).toString());
    L29:
        return r4;
    L5:
        if (r1 != r0.getStateVersion()) goto L22;
        if (r3 != this.D.ordinal()) goto L22;
        if (r9 < 5) goto L13;
        if (r9 > 7) goto L13;
    L18:
        boolean r6 = true;
    L20:
        if (r6 == false) goto L22;
    L13:
        if (r9 < 9) goto L17;
        if (r9 <= 16) goto L18;
    L17:
        if (r9 == 18) goto L18;
        r6 = false;
        goto L20
    }

    public final void d(int r3) {
        PowerManager.WakeLock r0 = this.Q;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isHeld() == true) goto L9;
        this.ao = System.currentTimeMillis();
        this.ar = r3;
        this.aq++;
        com.obric.cae.log.a.d("StarLocation-PoiManager", com.obric.cae.libs.statemachine.d.a("acquireWakeLock timeoutMs=30000, source=", r3, ", count=").append(this.aq).toString());
        this.Q.acquire(30000);
        return;
    }

    public void d(Bundle r2) {
        b(r2, 0);
    }

    public final void d(String r9) {
        p r0 = this.aR.f7188a;
        p r1 = p.c;
        if (r0 != r1) goto L5;
        boolean r2 = true;
    L7:
        if (TextUtils.isEmpty(this.aL) == true) goto L9;
        a("AP ACTIVE_POI clear poiId=" + this.aL + " reason=" + r9, System.currentTimeMillis());
    L9:
        this.aL = "";
        this.aM = null;
        this.aN = null;
        this.aO = 0;
        this.aP = -1;
        this.aQ = 0;
        o r5 = this.aR;
        if (Objects.equals(r5.f7189b, null) == true) goto L12;
        r5.f7189b = null;
        r5.f7188a = p.f7190a;
        r5.c = -1;
    L12:
        if (r2 == false) goto L14;
        this.aR.f7188a = r1;
    L14:
        this.aS = false;
        this.aT = false;
        this.aU = 0;
        this.aV = 0;
        this.aX = null;
        return;
    L5:
        r2 = false;
        goto L7
    }

    public final boolean d() {
        if (this.p.get() == true) goto L6;
        return false;
    L6:
        if (System.currentTimeMillis() <= this.A) goto L9;
        this.p.set(false);
        this.A = 0;
        return false;
    L9:
        boolean r0 = this.p.compareAndSet(true, false);
        if (r0 == false) goto L12;
        this.A = 0;
    L12:
        return r0;
    }

    public final void e() {
        PowerManager.WakeLock r0 = this.Q;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isHeld() == false) goto L33;
        long r1 = System.currentTimeMillis() - this.ao;
        this.ap += r1;
        com.obric.cae.log.a.d("StarLocation-PoiManager", "releaseWakeLock duration=" + r1 + "ms, totalDuration=" + this.ap + "ms, count=" + this.aq);
        JSONObject r2 = new JSONObject();     // Catch: JSONException -> L26
        Context r5 = this.t;     // Catch: JSONException -> L26
        if (r5 == null) goto L15;
        PowerManager r6 = (PowerManager) ZeusTransformUtils.preCheckCast(r5.getSystemService("power"), PowerManager.class, "com.obric.memorydata.plugin");     // Catch: JSONException -> L26
        if (r6 == null) goto L15;
        if (r6.isInteractive() == false) goto L15;
        boolean r7 = true;
    L16:
        r2.put("is_screen_on", r7);     // Catch: JSONException -> L26
        r2.put("lock_reason", this.ar);     // Catch: JSONException -> L26
        int r8 = Integer.MAX_VALUE;
        if (r1 <= 2147483647L) goto L19;
        int r3 = Integer.MAX_VALUE;
    L20:
        r2.put("lock_time", r3);     // Catch: JSONException -> L26
        r2.put("lock_times", this.aq);     // Catch: JSONException -> L26
        long r11 = this.ap;     // Catch: JSONException -> L26
        if (r11 > 2147483647L) goto L24;
        r8 = (int) Math.max(r11, 0);     // Catch: JSONException -> L26
    L24:
        r2.put("total_time", r8);     // Catch: JSONException -> L26
        r2.put("device_id", MatrixDidUtils.getDid());     // Catch: JSONException -> L26
        com.obric.cae.cloud.applog.b.a("poi_power_evnt", r2);     // Catch: JSONException -> L26
    L28:
        this.Q.release();
        return;
    L19:
        r3 = (int) Math.max(r1, 0);     // Catch: JSONException -> L26
    L15:
        r7 = false;
    L26:
        e = move-exception;
        com.obric.cae.log.a.j("StarLocation-PoiManager", "report wake lock end event failed: " + e.getMessage());
        goto L28
    }

    public final synchronized void e(String r3) {
        monitor-enter(this);
        PoiWifiScanBridge r0 = this.aH;     // Catch: Throwable -> L13
        if (r0 != null) goto L6;
    L10:
        this.aI = false;     // Catch: Throwable -> L13
        this.aJ = false;     // Catch: Throwable -> L13
        this.aK = 0;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L6:
        if (this.aI == false) goto L8;
    L9:
        r0.stopTask();     // Catch: Throwable -> L13
        com.obric.cae.log.a.f("StarLocation-PoiManager", "POI_WIFI production stop reason=" + r3);     // Catch: Throwable -> L13
        goto L10
    L8:
        if (this.aJ == false) goto L10;
    L13:
        th = move-exception;
        throw th;
    }

    public final boolean f() {
        PoiAwareBridge r0 = this.av;
        if (this.at == 1) goto L5;
    L12:
        return false;
    L5:
        if (this.au == false) goto L12;
        if (r0 == null) goto L12;
        if (r0.isStateSynchronized() == false) goto L12;
        if (a(this.D) == false) goto L12;
        return true;
    }

    public final boolean f(String r3) {
        if (a(this.aj) == true) goto L6;
        return false;
    L6:
        com.obric.cae.log.a.d("StarLocation-PoiManager", com.obric.cae.location.city.f.a("skip poi query in transportation mode, source=", r3, ", harStatus=").append(this.aj).append(", state=").append(this.D).toString());
        return true;
    }

    public final synchronized void g() {
        monitor-enter(this);
        Context r0 = this.t;     // Catch: Throwable -> L13
        if (r0 != null) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.aH != null) goto L11;
        PoiWifiScanBridge r1 = PoiWifiScanBridge.getInstance(r0);     // Catch: Throwable -> L13
        this.aH = r1;     // Catch: Throwable -> L13
        r1.addListener(this.aZ);     // Catch: Throwable -> L13
        r1.start();     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public void g(String r1) {
        Context r0 = this.t;
        if (r0 != null) goto L6;
        com.obric.cae.log.a.d("StarLocation-PoiManager", r1);
        return;
    L6:
        com.obric.cae.location.geosdk.poi.a.a(r0).f(r1);
    }

    public final synchronized void h() {
        monitor-enter(this);
        PoiWifiScanBridge r0 = this.aH;     // Catch: Throwable -> L25
        if (r0 != null) goto L6;
    L23:
        monitor-exit(this);
        return;
    L6:
        if (this.aI == false) goto L23;
        Bundle r1 = r0.getDebugInfo();     // Catch: Throwable -> L25
        if (r1.getBoolean("connected") == false) goto L19;
        if (r1.getBoolean("ready") == false) goto L19;
        if (this.aJ == true) goto L16;
        r0.startTask(b(this.aK));     // Catch: Throwable -> L25
        this.aJ = true;     // Catch: Throwable -> L25
        com.obric.cae.log.a.f("StarLocation-PoiManager", "POI_WIFI production start storeType=" + this.aK + " report=OFF");     // Catch: Throwable -> L25
    L16:
        monitor-exit(this);
        return;
    L19:
        if (r1.getBoolean("connected") == true) goto L21;
        this.aJ = false;     // Catch: Throwable -> L25
    L21:
        monitor-exit(this);
        return;
    L25:
        th = move-exception;
        throw th;
    }

    public final int i() {
        long r0 = SystemClock.elapsedRealtime();
        monitor-enter(this);
        int r2 = this.aU;     // Catch: Throwable -> L20
        if (r0 > this.aV) goto L7;
        int r1 = this.aU;     // Catch: Throwable -> L20
    L9:
        if (r2 != 1) goto L17;
        if (r1 == 1) goto L17;
        o r3 = this.aR;     // Catch: Throwable -> L20
        e r4 = this.aM;     // Catch: Throwable -> L20
        if (r3.f7188a == p.f7191b) goto L14;
    L16:
        a("AP SHADOW budget=" + this.aR.f7188a + " source=context_expired", System.currentTimeMillis());     // Catch: Throwable -> L20
        goto L17
    L14:
        if (Objects.equals(r3.f7189b, r4) == false) goto L16;
        r3.f7188a = p.f7190a;     // Catch: Throwable -> L20
    L17:
        this.aU = 0;     // Catch: Throwable -> L20
        this.aV = 0;     // Catch: Throwable -> L20
        monitor-exit(this);
        return r1;
    L7:
        r1 = 0;
    L20:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    public final void j() {
        Context r0 = this.t;
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.f7166J == true) goto L8;
    L10:
        ?? r2 = 0;
    L15:
        Settings.Global.putInt(r0.getContentResolver(), "cae_user_aware_poi_adsp_trace_enabled", r2);     // Catch: SecurityException -> L13
        return;
    L13:
        com.obric.cae.log.a.h("StarLocation-PoiManager", "failed to sync POI ADSP trace enabled=" + r2);
        return;
    L8:
        if (this.at == 0) goto L10;
        r2 = 1;
        goto L15
    }

    public final void k() {
        PoiAwareBridge r3 = this.av;
        if (r3 != null) goto L5;
        return;
    L5:
        PoiAwareBridge.Config r0 = new PoiAwareBridge.Config();
        r0.algorithmVersion = 130;
        r0.stationaryDelaySeconds = 20;
        r0.walkStepThreshold = TypedValues.TransitionType.TYPE_DURATION;
        r0.stationaryStepDeltaThreshold = 20;
        r0.stationaryCheckIntervalMs = AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH;
        r0.upDownSuppressSeconds = 0;
        r0.stepWindowBucketCount = 3;
        r0.entryStepThreshold = 20;
        r0.requiredLowChecks = 1;
        r0.harHoldSeconds = 20;
        r0.harGuardStepThreshold = 50;
        r0.eventAckTimeoutSeconds = 5;
        r0.retryBackoffInitialSeconds = 5;
        r0.retryBackoffMaxSeconds = 20;
        r0.stepWindowSeconds = 60;
        r3.applyDefaultConfig(r0);
    }

    public final void l() {
        long r0 = this.aC;
        if (r0 == 0) goto L15;
        long r4 = this.aD;
        if (r4 == 0) goto L15;
        long r1 = Math.abs(r0 - r4);
        if (r1 <= k) goto L10;
    L12:
        this.aB++;
        StringBuilder r2 = new StringBuilder("MISMATCH dt=").append(r1).append("ms apReason=").append(this.aE).append(" adspReason=").append(this.aF);
    L13:
        this.aG = r2.toString();
        this.aC = 0;
        this.aD = 0;
        com.obric.cae.log.a.e("PoiTriggerComparator", this.aG);
        return;
    L10:
        if (this.aE != this.aF) goto L12;
        this.aA++;
        r2 = new StringBuilder("MATCH dt=").append(r1).append("ms");
    L15:
        this.aG = "WAITING_PAIR";
    }

    public final boolean m() {
        if (this.f7166J == false) goto L5;
    L8:
        return true;
    L5:
        if (this.L == true) goto L8;
        return false;
    }

    public final void n() {
        j();
        this.p.set(false);
        this.A = 0;
        e("feature_disabled");
        o();
        AlarmManager r0 = this.R;
        if (r0 == null) goto L7;
        PendingIntent r4 = this.S;
        if (r4 == null) goto L7;
        r0.cancel(r4);
    L7:
        AlarmManager r1 = this.R;
        if (r1 == null) goto L12;
        PendingIntent r5 = this.U;
        if (r5 == null) goto L12;
        r1.cancel(r5);
    L12:
        AlarmManager r2 = this.R;
        if (r2 == null) goto L17;
        PendingIntent r6 = this.T;
        if (r6 == null) goto L17;
        r2.cancel(r6);
    L17:
        this.ag = -1;
        this.ah = false;
        j r3 = this.Z;
        if (r3 == null) goto L20;
        r3.removeCallbacksAndMessages(null);
    L20:
        com.obric.cae.location.geosdk.poi.c r7 = this.D;
        int r8 = r7.ordinal();
        if (r8 != 0) goto L23;
    L36:
        this.D = com.obric.cae.location.geosdk.poi.c.f7219a;
        c(0);
        this.F = false;
        this.G = false;
        this.H = false;
        this.ah = false;
        this.ae = 0;
        this.af = 0;
        this.ak = 0;
        this.ac = this.ab;
        e();
        return;
    L23:
        if (r8 != 1) goto L25;
        AlarmManager r9 = this.R;
        if (r9 == null) goto L36;
        PendingIntent r10 = this.S;
        if (r10 == null) goto L36;
        r9.cancel(r10);
        goto L36
    L25:
        if (r8 == 2) goto L36;
        if (r8 == 3) goto L36;
        if (r8 == 4) goto L36;
        com.obric.cae.log.a.j("StarLocation-PoiManager", "unexpected state exit: " + r7);
        goto L36
    }

    public final void o() {
        if (this.ad.compareAndSet(true, false) == false) goto L6;
        UserAwareManager.getInstance().getSensorCollectManager().unregisterUpDownStairSensor();
        return;
    }

    public final void p() {
        if (m() == true) goto L7;
        a("AP LOCATION_REQUEST skipped reason=feature_disabled", System.currentTimeMillis());
        com.obric.cae.log.a.d("StarLocation-PoiManager", "skip trigger location, poi detect disabled");
        return;
    L7:
        if (f("triggerNearPoiLocation") == false) goto L24;
        a("AP LOCATION_REQUEST skipped reason=transport", System.currentTimeMillis());
        return;
    L24:
        int r4 = this.aw;     // Catch: Throwable -> L21
        if (this.at != 0) goto L14;
        boolean r5 = true;
    L15:
        if (r5 == false) goto L17;
        this.A = (System.currentTimeMillis() + com.obric.cae.location.geosdk.bytedance.a.f7092b) + f;     // Catch: Throwable -> L21
        this.p.set(true);     // Catch: Throwable -> L21
    L17:
        a("AP LOCATION_REQUEST sent state=" + this.D + " pendingId=" + r4, System.currentTimeMillis());     // Catch: Throwable -> L21
        a("near_poi_location_query");     // Catch: Throwable -> L21
        BDLocation r1 = com.obric.cae.location.geosdk.bytedance.a.a().a(true, "StarPoiManager-near-poi", com.obric.cae.location.geosdk.bytedance.a.f7092b);     // Catch: Throwable -> L21
        if (r5 == true) goto L26;
        a(r1, "sync_request_" + r4);     // Catch: Throwable -> L21
        return;
    L26:
        return;
    L14:
        r5 = false;
    L21:
        th = move-exception;
        this.p.set(false);
        this.A = 0;
        com.obric.cae.log.a.b("StarLocation-PoiManager", "triggerNearPoiLocation failed", th);
        a(this.aw, "location_exception");
    }

    public final Bundle q() {
        Bundle r0 = new Bundle();
        r0.putInt("state", this.D.ordinal());
        int r1 = this.E.ordinal();
        if (r1 != 1) goto L5;
        String r2 = "sittable";
    L9:
        r0.putString("poi_category", r2);
        r0.putInt(EventBody.KEY_CATEGORY, this.E.ordinal());
        r0.putBoolean("isStationary", this.F);
        r0.putInt("stationaryDelaySeconds", this.ai);
        r0.putInt("walkStepThreshold", this.N);
        r0.putInt("stationaryStepDeltaThreshold", this.O);
        r0.putLong("stationaryStepCheckIntervalMs", this.P);
        if (this.D.ordinal() == 4) goto L12;
        int r3 = Integer.MAX_VALUE;
    L13:
        r0.putInt("currentStepThreshold", r3);
        r0.putLong("lastDetectTimeMs", this.al);
        return r0;
    L12:
        r3 = this.N;
        goto L13
    L5:
        if (r1 == 2) goto L7;
        r2 = "unknown";
        goto L9
    L7:
        r2 = "walkable";
        goto L9
    }

    public com.obric.cae.libs.location.poi.d r() {
        return this.be;
    }

    public Bundle s() {
        Bundle r1 = this.w;
        if (r1 != null) goto L6;
        return null;
    L6:
        return new Bundle(r1);
    }

    public void t() {
        if (m() == true) goto L7;
        a("AP MIDDLEWARE_REQUEST skipped reason=feature_disabled", System.currentTimeMillis());
        b("query_feature_disabled");
        a(this.aw, "query_feature_disabled");
        return;
    L7:
        if (f("queryNearPoiData") == false) goto L11;
        a("AP MIDDLEWARE_REQUEST skipped reason=transport", System.currentTimeMillis());
        b("query_transport");
        a(this.aw, "query_transport");
        return;
    L11:
        if (this.o.compareAndSet(false, true) == true) goto L14;
        a("AP MIDDLEWARE_REQUEST skipped reason=duplicate", System.currentTimeMillis());
        com.obric.cae.log.a.f("StarLocation-PoiManager", "skip duplicate request");
        b("query_duplicate");
        a(this.aw, "query_duplicate");
        return;
    L14:
        final int r0 = this.aW.getAndIncrement();
        final int r11 = this.aw;
        int r12 = i();
        long r4 = SystemClock.elapsedRealtime();
        final i r13 = new i(r0, r12, r4, r4 + j, System.currentTimeMillis(), this.aM);
        monitor-enter(this);
        this.aX = r13;     // Catch: Throwable -> L20
        monitor-exit(this);     // Catch: Throwable -> L20
        a("AP MIDDLEWARE_REQUEST start requestId=" + this.aw + " state=" + this.D + " generation=" + r0 + " context=" + r12, System.currentTimeMillis());
        this.s.execute(new $$Lambda$StarPoiManager$sJmEhHcRYKXuEIHDENNf24DFUNk(this, r0, r11, r13));
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void u() {
        if (f("requestNearPoiLocationSafely") == false) goto L7;
        b(NotificationCompat.CATEGORY_TRANSPORT);
        return;
    L7:
        if (a(this.D) == true) goto L9;
    L16:
        p();
        return;
    L9:
        if (this.aU != 1) goto L11;
        int r0 = 2;
    L13:
        if (this.at != 2) goto L16;
        this.az++;
        this.aC = SystemClock.elapsedRealtime();
        this.aE = r0;
        l();
        goto L16
    L11:
        r0 = 1;
        goto L13
    }

    public void v() {
        com.obric.cae.log.a.f("StarLocation-PoiManager", "destroy");
        e("manager_destroyed");
        PoiWifiScanBridge r0 = this.aH;
        if (r0 == null) goto L5;
        r0.removeListener(this.aZ);
        this.aH = null;
    L5:
        o();
        AlarmManager r1 = this.R;
        if (r1 == null) goto L10;
        PendingIntent r2 = this.S;
        if (r2 == null) goto L10;
        r1.cancel(r2);
    L10:
        AlarmManager r3 = this.R;
        if (r3 == null) goto L15;
        PendingIntent r4 = this.U;
        if (r4 == null) goto L15;
        r3.cancel(r4);
    L15:
        AlarmManager r5 = this.R;
        if (r5 == null) goto L20;
        PendingIntent r6 = this.T;
        if (r6 == null) goto L20;
        r5.cancel(r6);
    L20:
        this.ag = -1;
        this.ah = false;
        e();
        PoiAwareBridge r7 = this.av;
        this.av = null;
        this.au = false;
        this.ba.f7224b = false;
        if (r7 == null) goto L23;
        r7.stop();
    L23:
        Context r8 = this.t;
        if (r8 != null) goto L26;
    L30:
        HandlerThread r9 = this.Y;
        if (r9 == null) goto L34;
        r9.quitSafely();
        this.Y = null;
        this.Z = null;
    L34:
        if (this.aa != null) goto L52;
    L37:
        if (r8 == null) goto L60;
        com.obric.cae.location.geosdk.poi.i r10 = this.V;
        if (r10 != null) goto L58;
    L42:
        com.obric.cae.location.geosdk.poi.j r11 = this.W;
        if (r11 == null) goto L61;
        ZeusTransformUtils.unregisterReceiver(r8, r11, "com.obric.memorydata.plugin");     // Catch: Throwable -> L49
    L46:
        this.W = null;
        return;
    L61:
        return;
    L58:
        ZeusTransformUtils.unregisterReceiver(r8, r10, "com.obric.memorydata.plugin");     // Catch: Throwable -> L50
    L41:
        this.V = null;
        goto L42
    L60:
        return;
    L52:
        UserAwareManager.getInstance().unregisterInnerCallback(this.aa);     // Catch: Throwable -> L51
    L36:
        this.aa = null;
        goto L37
    L26:
        if (this.X == null) goto L30;
        ZeusProviderTransform.unregisterContentObserver(r8.getContentResolver(), this.X, "com.obric.memorydata.plugin");     // Catch: Throwable -> L48
    L29:
        this.X = null;
        goto L30
    }
}
