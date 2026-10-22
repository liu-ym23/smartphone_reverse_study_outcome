package com.obric.memorydata.ability.impl;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationRequest;
import android.os.PowerManager;
import androidx.core.content.ContextCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.memorydata.constants.DevTrackerEventId;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.obric.memorydata.utils.ah;
import com.obric.memorydata.utils.location.Point;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0002&9\u0018\u0000 ?2\u00020\u00012\u00020\u0002:\u0001?B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0006H\u0017J\b\u0010+\u001a\u00020\u0010H\u0002J\u0010\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\tH\u0002J\u0018\u0010.\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u001bH\u0016J\u0010\u00100\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\tH\u0002J\u0018\u00101\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u001bH\u0016J\u0018\u00102\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u001bH\u0017J\u000e\u00103\u001a\u00020)H\u0083@¢\u0006\u0002\u00104J\u000e\u00105\u001a\u00020)H\u0083@¢\u0006\u0002\u00104J\b\u00106\u001a\u00020)H\u0016J\b\u00107\u001a\u00020)H\u0002J\b\u0010;\u001a\u00020\u0010H\u0002J\u0010\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020>H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u000f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\n \u0015*\u0004\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0004\n\u0002\u0010'R\u0010\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0004\n\u0002\u0010:¨\u0006@"}, d2 = {"Lcom/obric/memorydata/ability/impl/GeographyAbility;", "Lcom/obric/memorydata/ability/impl/IMetaAbility;", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "<init>", "()V", "abilityContext", "Lcom/obric/memorydata/ability/IAbilityContext;", "key2Mode", "Ljava/util/concurrent/ConcurrentHashMap;", "", "queryCountDownLatch", "Ljava/util/concurrent/CountDownLatch;", "geographyStandardData", "Lcom/obric/memorydata/ability/data/GeographyStandardData;", "mode2keys", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "", "locationManager", "Landroid/location/LocationManager;", "executor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "Ljava/util/concurrent/ExecutorService;", "isRequestingLocation", "lastLocation", "Landroid/location/Location;", "wifiSubscribeParams", "Lcom/obric/memorydata/ability/AbilityParams;", "hasRefreshCache", "lastWifiData", "Lcom/obric/memorydata/ability/data/WifiStandardData;", "lastUpdateTs", "", "networkLocationRequest", "Landroid/location/LocationRequest;", "gpsLocationRequest", "lastGpsRequestTimestamp", "passiveListener", "com/obric/memorydata/ability/impl/GeographyAbility$passiveListener$1", "Lcom/obric/memorydata/ability/impl/GeographyAbility$passiveListener$1;", "onCreate", "", "iAbilityContext", "hasPermission", "handleCollectGeographySubscribe", "key", "onSubscribe", TrackerImpl.PARAMS, "handleCollectGeographyUnsubscribe", "onUnsubscribe", "onQuery", "requestLocationByGps", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestLocationByNetwork", "onDestroy", "publishToAllReceiver", "listener", "com/obric/memorydata/ability/impl/GeographyAbility$listener$1", "Lcom/obric/memorydata/ability/impl/GeographyAbility$listener$1;", "canUseCache", "onDataReceive", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "Companion", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h implements i, com.obric.memorydata.ability.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8380a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.memorydata.ability.j f8381b;
    private final ConcurrentHashMap<String, String> c;
    private com.obric.memorydata.ability.data.g d;
    private final ConcurrentHashMap<String, ConcurrentHashMap.KeySetView<String, Boolean>> e;
    private final LocationManager f;
    private final ExecutorService g;
    private boolean h;
    private Location i;
    private final com.obric.memorydata.ability.f j;
    private boolean k;
    private com.obric.memorydata.ability.data.u l;
    private long m;
    private final LocationRequest n;
    private final LocationRequest o;
    private long p;
    private final c q;
    private final b r;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/ability/impl/GeographyAbility$Companion;", "", "<init>", "()V", "TAG", "", "DEFAULT_RADIUS", "", "MODE_KEY", "MODE_IN_GEOGRAPHY", "MODE_OUT_GEOGRAPHY", "MODE_COLLECT_GEOGRAPHY", "MAX_PASSIVE_FREQUENCY_TIME", "", "LOCATION_ACCURACY_DISTANCE", "GPS_LOCATION_MIN_TIME_INTERVAL", "", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/obric/memorydata/ability/impl/GeographyAbility$listener$1", "Lcom/obric/memorydata/ability/helper/MemoryGeoFenceListener;", "onTrigger", "", "key", "", "longitude", "", "latitude", "status", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.ability.a.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f8382a;

        b(h r1) {
            this.f8382a = r1;
        }

        @Override // com.obric.memorydata.ability.a.b
        public void a(String r10, double r11, double r13, String r15) {
            Intrinsics.checkNotNullParameter(r10, "key");
            Intrinsics.checkNotNullParameter(r15, "status");
            if (h.g(this.f8382a).get(r10) != null) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "geoFence onTrigger key2Mode[key] == null.", null, 4, null);
            return;
        L6:
            com.obric.memorydata.ability.data.g r0 = new com.obric.memorydata.ability.data.g(r11, r13, 0.0d);
            RunLog.INSTANCE.debug("GeographyAbility", "onTrigger status: " + r15 + "  " + r11 + " , " + r13);
            if (Intrinsics.areEqual(h.g(this.f8382a).get(r10), "in") == false) goto L12;
            if (Intrinsics.areEqual(r15, "in") == false) goto L12;
        L10:
            com.obric.memorydata.ability.j r9 = h.h(this.f8382a);
            Intrinsics.checkNotNull(r9);
            r9.a(r10, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r0, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
            return;
        L12:
            if (Intrinsics.areEqual(h.g(this.f8382a).get(r10), "out") == true) goto L14;
            return;
        L14:
            if (Intrinsics.areEqual(r15, "out") == true) goto L10;
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, d2 = {"com/obric/memorydata/ability/impl/GeographyAbility$passiveListener$1", "Landroid/location/LocationListener;", "onLocationChanged", "", "location", "Landroid/location/Location;", "onProviderEnabled", "provider", "", "onProviderDisabled", "ability_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f8383a;

        c(h r1) {
            this.f8383a = r1;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location r8) {
            Intrinsics.checkNotNullParameter(r8, "location");
            if (h.b(this.f8383a) == false) goto L5;
            return;
        L5:
            if (Intrinsics.areEqual(h.c(this.f8383a), r8) == true) goto L37;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "PASSIVE_PROVIDER onLocationChanged, accuracy: " + r8.getAccuracy(), false, 4, null);
            if (r8.getAccuracy() <= 40.0f) goto L11;
            return;
        L11:
            if (h.d(this.f8383a) == false) goto L21;
            com.obric.memorydata.ability.data.g r0 = h.a(this.f8383a);
            if (r0 == null) goto L15;
            Float r1 = Float.valueOf(r0.c());
        L16:
            if (r1 == null) goto L21;
            if (r1.floatValue() > r8.getAccuracy()) goto L21;
            RunLog.INSTANCE.debug("GeographyAbility", "Wi-Fi没发生变化");
            return;
        L15:
            r1 = null;
        L21:
            long r2 = System.currentTimeMillis();
            if ((r2 - h.e(this.f8383a)) > 60000) goto L24;
            return;
        L24:
            h.a(this.f8383a, r2);
            Point r3 = com.obric.memorydata.utils.location.a.a(r8.getLatitude(), r8.getLongitude());
            h.a(this.f8383a, new com.obric.memorydata.ability.data.g(r3.getLongitude(), r3.getLatitude()));
            com.obric.memorydata.ability.data.g r4 = h.a(this.f8383a);
            if (r4 == null) goto L27;
            r4.a(r8.getAccuracy());
        L27:
            com.obric.memorydata.ability.data.g r5 = h.a(this.f8383a);
            if (r5 != null) goto L30;
        L34:
            h.a(this.f8383a, true);
            h.f(this.f8383a);
            return;
        L30:
            if (r8.hasSpeed() == false) goto L32;
            float r9 = r8.getSpeed();
        L33:
            r5.b(r9);
            goto L34
        L32:
            r9 = -1.0f;
            goto L33
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String r7) {
            Intrinsics.checkNotNullParameter(r7, "provider");
            super.onProviderDisabled(r7);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "onProviderDisabled", false, 4, null);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String r7) {
            Intrinsics.checkNotNullParameter(r7, "provider");
            super.onProviderEnabled(r7);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "onProviderEnabled", false, 4, null);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f8384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f8385b;

        d(h r1, CountDownLatch r2) {
            this.f8384a = r1;
            this.f8385b = r2;
        }

        public final void a(Location r8) {
            if (r8 != null) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "request gps location error", null, 4, null);
            return;
        L6:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "find gps location " + r8.getAccuracy(), false, 4, null);
            com.obric.memorydata.ability.data.g r0 = h.a(this.f8384a);
            if (r0 == null) goto L9;
            float r1 = r0.c();
        L11:
            if (r8.getAccuracy() >= r1) goto L15;
            Point r2 = com.obric.memorydata.utils.location.a.a(r8.getLatitude(), r8.getLongitude());
            h.a(this.f8384a, new com.obric.memorydata.ability.data.g(r2.getLongitude(), r2.getLatitude()));
            com.obric.memorydata.ability.data.g r3 = h.a(this.f8384a);
            if (r3 == null) goto L15;
            r3.a(r8.getAccuracy());
        L15:
            h.a(this.f8384a, r8);
            this.f8385b.countDown();
            return;
        L9:
            r1 = Float.MAX_VALUE;
            goto L11
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ void accept(Object r3) {
            a((Location) ZeusTransformUtils.preCheckCast(r3, Location.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class e<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f8386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f8387b;

        e(h r1, CountDownLatch r2) {
            this.f8386a = r1;
            this.f8387b = r2;
        }

        public final void a(Location r8) {
            if (r8 != null) goto L6;
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "request network location error", null, 4, null);
            return;
        L6:
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "find network location " + r8.getAccuracy(), false, 4, null);
            com.obric.memorydata.ability.data.g r0 = h.a(this.f8386a);
            if (r0 == null) goto L9;
            float r1 = r0.c();
        L11:
            if (r8.getAccuracy() >= r1) goto L15;
            Point r2 = com.obric.memorydata.utils.location.a.a(r8.getLatitude(), r8.getLongitude());
            h.a(this.f8386a, new com.obric.memorydata.ability.data.g(r2.getLongitude(), r2.getLatitude()));
            com.obric.memorydata.ability.data.g r3 = h.a(this.f8386a);
            if (r3 == null) goto L15;
            r3.a(r8.getAccuracy());
        L15:
            h.a(this.f8386a, r8);
            this.f8387b.countDown();
            return;
        L9:
            r1 = Float.MAX_VALUE;
            goto L11
        }

        @Override // java.util.function.Consumer
        public /* synthetic */ void accept(Object r3) {
            a((Location) ZeusTransformUtils.preCheckCast(r3, Location.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        f8380a = new a(null);
    }

    public h() {
        this.c = new ConcurrentHashMap();
        this.e = new ConcurrentHashMap();
        Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("location");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.location.LocationManager");
        this.f = (LocationManager) ZeusTransformUtils.preCheckCast(r0, LocationManager.class, "com.obric.memorydata.plugin");
        this.g = Executors.newSingleThreadExecutor();
        this.j = new com.obric.memorydata.ability.f(100000002, MapsKt.emptyMap());
        LocationRequest r1 = new LocationRequest.Builder(1000).setQuality(100).setDurationMillis(2000).setMaxUpdates(3).build();
        Intrinsics.checkNotNullExpressionValue(r1, "build(...)");
        this.n = r1;
        LocationRequest r2 = new LocationRequest.Builder(1000).setQuality(100).setDurationMillis(3000).setMaxUpdates(3).build();
        Intrinsics.checkNotNullExpressionValue(r2, "build(...)");
        this.o = r2;
        this.q = new c(this);
        this.r = new b(this);
    }

    public static final /* synthetic */ com.obric.memorydata.ability.data.g a(h r0) {
        return r0.d;
    }

    public static final /* synthetic */ Object a(h r2, Continuation r3) {
        return r2.b((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object a(Continuation<? super Unit> r14) {
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        long r2 = System.currentTimeMillis();
        if ((r2 - this.p) > 30000) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "gps request too fast", false, 4, null);
        return Unit.INSTANCE;
    L6:
        this.p = r2;
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r15));
        Continuation r3 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.info("GeographyAbility", "request gps location", true);
        if (b() == true) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "gps location permission denied", null, 4, null);
    L10:
        Result.Companion r13 = Result.Companion;
        r3.resumeWith(Result.m1421constructorimpl(null));
        Object r16 = r0.getOrThrow();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L13;
        DebugProbesKt.probeCoroutineSuspended(r15);
    L13:
        return r16;
    L9:
        CountDownLatch r4 = new CountDownLatch(1);
        this.f.getCurrentLocation("gps", this.o, null, (Executor) ZeusTransformUtils.preCheckCast(this.g, Executor.class, "com.obric.memorydata.plugin"), (Consumer) ZeusTransformUtils.preCheckCast(new d(this, r4), Consumer.class, "com.obric.memorydata.plugin"));
        r4.await(3, TimeUnit.SECONDS);
        goto L10
    }

    public static final /* synthetic */ void a(h r0, long r1) {
        r0.m = r1;
    }

    public static final /* synthetic */ void a(h r0, Location r1) {
        r0.i = r1;
    }

    public static final /* synthetic */ void a(h r0, com.obric.memorydata.ability.data.g r1) {
        r0.d = r1;
    }

    public static final /* synthetic */ void a(h r0, boolean r1) {
        r0.k = r1;
    }

    private final boolean a(String r10) {
        ConcurrentHashMap.KeySetView r0 = (ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(this.e.get("collect_geography"), ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L9:
        return false;
    L5:
        if (r0.contains(r10) == true) goto L8;
        r0.add(r10);
        ((Map) ZeusTransformUtils.preCheckCast(this.c, Map.class, "com.obric.memorydata.plugin")).put(r10, "collect_geography");
        return true;
    L8:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "handleTeaTrackerSubscribe teaTrackerSubscriberKeySet already contains key(" + r10 + ").", null, 4, null);
        goto L9
    }

    public static final /* synthetic */ Object b(h r2, Continuation r3) {
        return r2.a((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    private final Object b(Continuation<? super Unit> r14) {
        Continuation r15 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        if (com.obric.memorydata.utils.h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == false) goto L13;
        SafeContinuation r0 = new SafeContinuation(IntrinsicsKt.intercepted(r15));
        Continuation r2 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
        RunLog.INSTANCE.info("GeographyAbility", "request network location", true);
        if (b() == true) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "network location permission denied", null, 4, null);
    L8:
        Result.Companion r13 = Result.Companion;
        r2.resumeWith(Result.m1421constructorimpl(null));
        Object r16 = r0.getOrThrow();
        if (r16 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        DebugProbesKt.probeCoroutineSuspended(r15);
    L11:
        return r16;
    L7:
        CountDownLatch r3 = new CountDownLatch(1);
        this.f.getCurrentLocation("network", this.n, null, (Executor) ZeusTransformUtils.preCheckCast(this.g, Executor.class, "com.obric.memorydata.plugin"), (Consumer) ZeusTransformUtils.preCheckCast(new e(this, r3), Consumer.class, "com.obric.memorydata.plugin"));
        r3.await(2, TimeUnit.SECONDS);
        goto L8
    L13:
        return Unit.INSTANCE;
    }

    private final boolean b() {
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.listOf(new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}), Iterable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r6, Collection.class) == true) goto L5;
    L7:
        Iterator r7 = r6.iterator();
    L9:
        if (r7.hasNext() == false) goto L15;
        if (ContextCompat.checkSelfPermission((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r7.next(), String.class, "com.obric.memorydata.plugin")) != 0) goto L13;
        boolean r0 = true;
    L14:
        if (r0 == true) goto L9;
        return false;
    L13:
        r0 = false;
    L15:
        return true;
    L5:
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L7;
        goto L7
    }

    public static final /* synthetic */ boolean b(h r0) {
        return r0.h;
    }

    private final boolean b(String r7) {
        ConcurrentHashMap.KeySetView r0 = (ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(this.e.get("collect_geography"), ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L6;
        r0.remove(r7);
        this.c.remove(r7);
        return true;
    L6:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "handleTeaTrackerUnsubscribe teaTrackerSubscriberKeySet not contains key: " + r7, null, 4, null);
        return false;
    }

    public static final /* synthetic */ Location c(h r0) {
        return r0.i;
    }

    private final void c() {
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$h$QvdPWscsVn4GzHsn3yYUW2hT68(this));
    }

    private final boolean d() {
        if (this.k == true) goto L5;
        return false;
    L5:
        com.obric.memorydata.ability.data.u r0 = this.l;
        if (r0 != null) goto L8;
    L10:
        boolean r1 = false;
    L11:
        if (r1 == false) goto L20;
        com.obric.memorydata.ability.data.u r4 = this.l;
        if (r4 != null) goto L15;
    L17:
        boolean r5 = false;
    L18:
        if (r5 == false) goto L20;
        return true;
    L15:
        if (r4.d() != true) goto L17;
        r5 = true;
    L20:
        return false;
    L8:
        if (r0.a() != 3) goto L10;
        r1 = true;
        goto L11
    }

    public static final /* synthetic */ boolean d(h r0) {
        return r0.d();
    }

    public static final /* synthetic */ long e(h r2) {
        return r2.m;
    }

    public static final /* synthetic */ void f(h r0) {
        r0.c();
    }

    public static final /* synthetic */ ConcurrentHashMap g(h r0) {
        return r0.c;
    }

    public static final /* synthetic */ com.obric.memorydata.ability.j h(h r0) {
        return r0.f8381b;
    }

    private static final void i(h r4) {
        com.obric.memorydata.ability.j r0 = r4.f8381b;
        if (r0 == null) goto L6;
        r0.a(r4.j, (com.obric.memorydata.ability.k) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.ability.k.class, "com.obric.memorydata.plugin"));
        return;
    }

    private static final void j(h r7) {
        a r0 = f8380a;
        monitor-enter(r0);
        ConcurrentHashMap.KeySetView r1 = (ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r7.e.get("collect_geography"), ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r1 == null) goto L14;
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r2, "iterator(...)");     // Catch: Throwable -> L17
    L8:
        if (r2.hasNext() == false) goto L14;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2.next(), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        com.obric.memorydata.ability.data.g r4 = r7.d;     // Catch: Throwable -> L17
        if (r4 == null) goto L8;
        com.obric.memorydata.ability.j r5 = r7.f8381b;     // Catch: Throwable -> L17
        if (r5 == null) goto L8;
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L17
        r5.a(r3, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L17
    L14:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r0);
        return;
    L17:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: lambda$-8p5AXIBN_nMDvrz1gRS5jMiM2U, reason: not valid java name */
    public static /* synthetic */ void m436lambda$8p5AXIBN_nMDvrz1gRS5jMiM2U(h r0) {
        i(r0);
    }

    /* JADX INFO: renamed from: lambda$QvdPWscsVn4G-zHsn3yYUW2hT68, reason: not valid java name */
    public static /* synthetic */ void m437lambda$QvdPWscsVn4GzHsn3yYUW2hT68(h r0) {
        j(r0);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "onDestroy", false, 4, null);
        this.c.clear();
        ConcurrentHashMap.KeySetView<String, Boolean> r0 = this.e.get("in");
        Intrinsics.checkNotNull(r0);
        ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r0, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).clear();
        ConcurrentHashMap.KeySetView<String, Boolean> r1 = this.e.get("out");
        Intrinsics.checkNotNull(r1);
        ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r1, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).clear();
        ConcurrentHashMap.KeySetView<String, Boolean> r2 = this.e.get("collect_geography");
        Intrinsics.checkNotNull(r2);
        ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r2, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).clear();
        this.e.clear();
        this.f.removeUpdates((LocationListener) ZeusTransformUtils.preCheckCast(this.q, LocationListener.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.ability.j r3 = this.f8381b;
        if (r3 == null) goto L6;
        r3.b(this.j, (com.obric.memorydata.ability.k) ZeusTransformUtils.preCheckCast(this, com.obric.memorydata.ability.k.class, "com.obric.memorydata.plugin"));
        return;
    }

    @Override // com.obric.memorydata.ability.k
    public void a(com.obric.memorydata.ability.data.h r10) {
        com.obric.memorydata.ability.data.h r11 = (com.obric.memorydata.ability.data.h) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "data");
        if (ZeusTransformUtils.instanceOf(r11, com.obric.memorydata.ability.data.u.class) == false) goto L21;
        RunLog.INSTANCE.debug("GeographyAbility", "receive wifi data, action: " + ((com.obric.memorydata.ability.data.u) ZeusTransformUtils.preCheckCast(r11, com.obric.memorydata.ability.data.u.class, "com.obric.memorydata.plugin")).a() + " bssid: " + ((com.obric.memorydata.ability.data.u) ZeusTransformUtils.preCheckCast(r11, com.obric.memorydata.ability.data.u.class, "com.obric.memorydata.plugin")).b());
        com.obric.memorydata.ability.data.u r0 = this.l;
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L19;
        com.obric.memorydata.ability.data.u r2 = this.l;
        if (r2 == null) goto L14;
        String r3 = r2.b();
    L16:
        if (Intrinsics.areEqual(r3, ((com.obric.memorydata.ability.data.u) ZeusTransformUtils.preCheckCast(r11, com.obric.memorydata.ability.data.u.class, "com.obric.memorydata.plugin")).b()) == false) goto L19;
        RunLog.INSTANCE.debug("GeographyAbility", "Wi-Fi状态未发生变化");
        return;
    L14:
        r3 = null;
    L19:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "wifi state change, action: " + ((com.obric.memorydata.ability.data.u) ZeusTransformUtils.preCheckCast(r11, com.obric.memorydata.ability.data.u.class, "com.obric.memorydata.plugin")).a(), false, 4, null);
        this.k = false;
        this.l = (com.obric.memorydata.ability.data.u) ZeusTransformUtils.preCheckCast(r11, com.obric.memorydata.ability.data.u.class, "com.obric.memorydata.plugin");
        return;
    L7:
        if (r0.a() != ((com.obric.memorydata.ability.data.u) ZeusTransformUtils.preCheckCast(r11, com.obric.memorydata.ability.data.u.class, "com.obric.memorydata.plugin")).a()) goto L9;
        r1 = true;
        goto L10
    }

    @Override // com.obric.memorydata.ability.impl.i
    public void a(com.obric.memorydata.ability.j r10) {
        com.obric.memorydata.ability.j r11 = (com.obric.memorydata.ability.j) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.memorydata.ability.j.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r11, "iAbilityContext");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "onCreate", false, 4, null);
        this.f8381b = r11;
        ((Map) ZeusTransformUtils.preCheckCast(this.e, Map.class, "com.obric.memorydata.plugin")).put("in", ConcurrentHashMap.newKeySet());
        ((Map) ZeusTransformUtils.preCheckCast(this.e, Map.class, "com.obric.memorydata.plugin")).put("out", ConcurrentHashMap.newKeySet());
        ((Map) ZeusTransformUtils.preCheckCast(this.e, Map.class, "com.obric.memorydata.plugin")).put("collect_geography", ConcurrentHashMap.newKeySet());
        if (com.obric.memorydata.b.a.f8796a.b() == true) goto L5;
    L7:
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$h$8p5AXIBN_nMDvrz1gRS5jMiM2U(this));
        return;
    L5:
        if (b() == false) goto L7;
        this.f.requestLocationUpdates("passive", 60000, 3.0f, (Executor) ZeusTransformUtils.preCheckCast(this.g, Executor.class, "com.obric.memorydata.plugin"), (LocationListener) ZeusTransformUtils.preCheckCast(this.q, LocationListener.class, "com.obric.memorydata.plugin"));
        goto L7
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(com.obric.memorydata.ability.f r1) {
        return i.a.a(this, r1);
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean a(String r19, com.obric.memorydata.ability.f r20) {
        Intrinsics.checkNotNullParameter(r19, "key");
        Intrinsics.checkNotNullParameter(r20, TrackerImpl.PARAMS);
        Object r2 = r20.b().getOrDefault("mode", "");
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type kotlin.String");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r2, String.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == false) goto L11;
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r5 = null;
        int r6 = 4;
        Object r7 = null;
        String r8 = "GeographyAbility";
        String r9 = "onSubscribe: this mode is empty.";
    L8:
        IRunLog.a.b(r1, r8, r9, r5, r6, r7);
        return false;
    L11:
        if (this.c.containsKey(r19) == false) goto L13;
        r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r5 = null;
        r6 = 4;
        r7 = null;
        r8 = "GeographyAbility";
        r9 = "onSubscribe: this key has not unsubscribe.";
        goto L8
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "onSubscribe " + r19 + ", mode: " + r3, false, 4, null);
        int r10 = r3.hashCode();
        if (r10 == (-1379735897)) goto L40;
        if (r10 == 3365) goto L24;
        if (r10 == 110414) goto L21;
    L41:
        r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r5 = null;
        r6 = 4;
        r7 = null;
        r8 = "GeographyAbility";
        r9 = "onSubscribe: mode error.";
        goto L8
    L21:
        if (r3.equals("out") == false) goto L41;
    L26:
        Object r11 = r20.b().getOrDefault("longitude", Double.valueOf(0.0d));
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type kotlin.Double");
        double r12 = ((Double) ZeusTransformUtils.preCheckCast(r11, Double.class, "com.obric.memorydata.plugin")).doubleValue();
        Object r13 = r20.b().getOrDefault("latitude", Double.valueOf(0.0d));
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.Double");
        double r14 = ((Double) ZeusTransformUtils.preCheckCast(r13, Double.class, "com.obric.memorydata.plugin")).doubleValue();
        if (r12 != 0.0d) goto L29;
        boolean r15 = true;
    L30:
        if (r15 == true) goto L32;
    L37:
        Object r16 = r20.b().getOrDefault("radius", Float.valueOf(100.0f));
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.Float");
        com.obric.memorydata.ability.a.a.f8298a.a(r19, new com.obric.memorydata.ability.a.c(r12, r14, ((Float) ZeusTransformUtils.preCheckCast(r16, Float.class, "com.obric.memorydata.plugin")).floatValue(), (com.obric.memorydata.ability.a.b) ZeusTransformUtils.preCheckCast(this.r, com.obric.memorydata.ability.a.b.class, "com.obric.memorydata.plugin")));
        ((Map) ZeusTransformUtils.preCheckCast(this.c, Map.class, "com.obric.memorydata.plugin")).put(r19, r3);
        ConcurrentHashMap.KeySetView<String, Boolean> r0 = this.e.get(r3);
        Intrinsics.checkNotNull(r0);
        ((ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(r0, ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin")).add(r19);
        return true;
    L32:
        if (r14 != 0.0d) goto L34;
        boolean r17 = true;
    L35:
        if (r17 == false) goto L37;
        return false;
    L34:
        r17 = false;
        goto L35
    L29:
        r15 = false;
        goto L30
    L24:
        if (r3.equals("in") == true) goto L26;
    L40:
        if (r3.equals("collect_geography") == false) goto L41;
        return a(r19);
    L5:
        r4 = false;
        goto L6
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean b(String r11, com.obric.memorydata.ability.f r12) {
        Intrinsics.checkNotNullParameter(r11, "key");
        Intrinsics.checkNotNullParameter(r12, TrackerImpl.PARAMS);
        Object r13 = r12.b().getOrDefault("mode", "");
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type kotlin.String");
        String r14 = (String) ZeusTransformUtils.preCheckCast(r13, String.class, "com.obric.memorydata.plugin");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L11;
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        Throwable r7 = null;
        int r8 = 4;
        Object r9 = null;
        String r5 = "GeographyAbility";
        String r6 = "onUnsubscribe: this mode is empty.";
    L8:
        IRunLog.a.b(r4, r5, r6, r7, r8, r9);
        return false;
    L11:
        if (this.c.containsKey(r11) == true) goto L13;
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = null;
        r8 = 4;
        r9 = null;
        r5 = "GeographyAbility";
        r6 = "onUnsubscribe: this key has not subscribe";
        goto L8
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "onUnsubscribe " + r11 + ", mode: " + r14, false, 4, null);
        int r1 = r14.hashCode();
        if (r1 == (-1379735897)) goto L32;
        if (r1 == 3365) goto L24;
        if (r1 == 110414) goto L21;
    L33:
        r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r7 = null;
        r8 = 4;
        r9 = null;
        r5 = "GeographyAbility";
        r6 = "onUnsubscribe: mode error.";
        goto L8
    L21:
        if (r14.equals("out") == false) goto L33;
    L26:
        this.c.remove(r11);
        ConcurrentHashMap.KeySetView r10 = (ConcurrentHashMap.KeySetView) ZeusTransformUtils.preCheckCast(this.e.get(r14), ConcurrentHashMap.KeySetView.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L29;
        r10.remove(r11);
    L29:
        com.obric.memorydata.ability.a.a.f8298a.a(r11);
        return true;
    L24:
        if (r14.equals("in") == true) goto L26;
    L32:
        if (r14.equals("collect_geography") == false) goto L33;
        return b(r11);
    L5:
        r0 = false;
        goto L6
    }

    @Override // com.obric.memorydata.ability.impl.i
    public boolean c(String r14, com.obric.memorydata.ability.f r15) {
        Intrinsics.checkNotNullParameter(r14, "key");
        Intrinsics.checkNotNullParameter(r15, TrackerImpl.PARAMS);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "onQuery " + r14, false, 4, null);
        if (b() == true) goto L5;
        return false;
    L5:
        Object r16 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("power");
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type android.os.PowerManager");
        boolean r17 = ((PowerManager) ZeusTransformUtils.preCheckCast(r16, PowerManager.class, "com.obric.memorydata.plugin")).isDeviceIdleMode();
        if (this.d == null) goto L17;
        if (r17 == false) goto L17;
        if (com.obric.memorydata.utils.h.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == true) goto L17;
        RunLog.INSTANCE.debug("GeographyAbility", "idle状态下无网就直接复用之前的定位结果");
        com.obric.memorydata.ability.data.g r18 = this.d;
        if (r18 == null) goto L16;
        com.obric.memorydata.ability.j r0 = this.f8381b;
        if (r0 == null) goto L15;
        r0.a(r14, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r18, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
    L15:
        c();
    L16:
        return true;
    L17:
        com.obric.memorydata.ability.data.g r19 = this.d;
        if (d() == false) goto L28;
        if (r19 == null) goto L28;
        if (r19.c() > 40.0f) goto L28;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "use cache location", false, 4, null);
        com.obric.memorydata.ability.j r1 = this.f8381b;
        if (r1 == null) goto L25;
        r1.a(r14, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r19, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
    L25:
        c();
        return true;
    L28:
        if (this.f.isLocationEnabled() == true) goto L30;
        return false;
    L30:
        this.h = true;
        this.d = null;
        long r5 = System.currentTimeMillis();
        kotlinx.coroutines.i.a(null, (Function2) ZeusTransformUtils.preCheckCast(new GeographyAbility$onQuery$2(this, null), Function2.class, "com.obric.memorydata.plugin"), 1, null);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "GeographyAbility", "finish location request", false, 4, null);
        DevTrackerEventId r110 = DevTrackerEventId.REQUEST_LOCATION_EVENT;
        JSONObject r2 = new JSONObject();
        if (this.d == null) goto L33;
        boolean r7 = true;
    L34:
        r2.put("isSuccess", r7);
        r2.put("costTime", System.currentTimeMillis() - r5);
        com.obric.memorydata.ability.data.g r6 = this.d;
        if (r6 == null) goto L37;
        Object r8 = Float.valueOf(r6.c());
    L38:
        r2.put(LocationMonitorConst.ACCURACY, r8);
        ah.a(r110, r2);
        com.obric.memorydata.ability.data.g r111 = this.d;
        if (r111 != null) goto L41;
    L47:
        this.h = false;
        if (this.d != null) goto L50;
        return false;
    L50:
        return true;
    L41:
        if (r111.c() > 40.0f) goto L43;
        this.k = true;
    L43:
        com.obric.memorydata.ability.j r3 = this.f8381b;
        if (r3 == null) goto L46;
        r3.a(r14, (com.obric.memorydata.ability.data.h) ZeusTransformUtils.preCheckCast(r111, com.obric.memorydata.ability.data.h.class, "com.obric.memorydata.plugin"));
    L46:
        c();
        goto L47
    L37:
        r8 = 0;
        goto L38
    L33:
        r7 = false;
        goto L34
    }

    @Override // com.obric.memorydata.ability.k
    public String g_() {
        return com.obric.memorydata.ability.k.a.a(this);
    }
}
