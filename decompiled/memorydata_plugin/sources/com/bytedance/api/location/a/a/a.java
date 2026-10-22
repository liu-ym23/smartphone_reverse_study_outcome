package com.bytedance.api.location.a.a;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b*\u0002 -\u0018\u00002\u00020\u0001:\u00018B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\fJ\b\u0010/\u001a\u00020\u000bH\u0002J\u0016\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020&\u0018\u000101H\u0002J\b\u00102\u001a\u00020\u0019H\u0002J\u0018\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u001c2\u0006\u00105\u001a\u00020&H\u0002J\b\u00106\u001a\u00020\u000bH\u0007J\b\u00107\u001a\u00020\u000bH\u0007R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0004\n\u0002\u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0004\n\u0002\u0010.¨\u00069"}, d2 = {"Lcom/bytedance/api/location/service/continuous/ContinuousLocationManager;", "", "context", "Landroid/content/Context;", "option", "Lcom/bytedance/bdlocation/client/LocationOption;", "looper", "Landroid/os/Looper;", "onLocationResult", "Lkotlin/Function1;", "Lcom/bytedance/api/location/service/continuous/ContinuousLocationManager$LocationResult;", "", "(Landroid/content/Context;Lcom/bytedance/bdlocation/client/LocationOption;Landroid/os/Looper;Lkotlin/jvm/functions/Function1;)V", "IMMEDIATE_CALLBACK_TOKEN", "Ljava/lang/Object;", "mBPEAManager", "Lcom/bytedance/bdlocation/api/IBPEALocal;", "mBackUpIntervalDiff", "", "mBackupIntervalMs", "mGpsLastUpdatedAt", "mGpsTimeoutMs", "mHandler", "Landroid/os/Handler;", "mIsRunning", "", "mLastCallbackTime", "mLatestGpsLocation", "Landroid/location/Location;", "mLatestNetworkLocation", "mLocationExpiredInterval", "mLocationListener", "com/bytedance/api/location/service/continuous/ContinuousLocationManager$mLocationListener$1", "Lcom/bytedance/api/location/service/continuous/ContinuousLocationManager$mLocationListener$1;", "mLocationLooper", "mLocationManager", "Landroid/location/LocationManager;", "mLocationMode", "", "mMinUpdateDistance", "", "mMinUpdateIntervalMs", "mNetworkLastUpdatedAt", "mOption", "periodicRunnable", "com/bytedance/api/location/service/continuous/ContinuousLocationManager$periodicRunnable$1", "Lcom/bytedance/api/location/service/continuous/ContinuousLocationManager$periodicRunnable$1;", "deliverBestAvailableResult", "getBestLocation", "Lkotlin/Pair;", "isGpsResultFresh", "scheduleImmediateCallback", "location", "locationType", "startLocation", "stopLocation", "LocationResult", "bytelocation_release"}, k = 1, mv = {1, 1, 16})
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Handler f1018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f1019b;
    private long c;
    private float d;
    private long e;
    private long f;
    private long g;
    private LocationManager h;
    private Function1<? super AbstractC0076a, Unit> i;
    private int j;
    private volatile Location k;
    private volatile Location l;
    private volatile long m;
    private volatile long n;
    private long o;
    private volatile boolean p;
    private volatile IBPEALocal q;
    private LocationOption r;
    private Looper s;
    private final b t;
    private final c u;
    private final Object v;

    /* JADX INFO: renamed from: com.bytedance.api.location.a.a.a$a, reason: collision with other inner class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/api/location/service/continuous/ContinuousLocationManager$LocationResult;", "", "()V", "Failure", "Success", "Lcom/bytedance/api/location/service/continuous/ContinuousLocationManager$LocationResult$Success;", "Lcom/bytedance/api/location/service/continuous/ContinuousLocationManager$LocationResult$Failure;", "bytelocation_release"}, k = 1, mv = {1, 1, 16})
    public static abstract class AbstractC0076a {

        /* JADX INFO: renamed from: com.bytedance.api.location.a.a.a$a$a, reason: collision with other inner class name */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/api/location/service/continuous/ContinuousLocationManager$LocationResult$Failure;", "Lcom/bytedance/api/location/service/continuous/ContinuousLocationManager$LocationResult;", InfoRequestQPSOptTraceLogger.REASON, "", "errorCode", "(Ljava/lang/String;Ljava/lang/String;)V", "getErrorCode", "()Ljava/lang/String;", "getReason", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "bytelocation_release"}, k = 1, mv = {1, 1, 16})
        public static final class C0077a extends AbstractC0076a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f1020a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final String f1021b;

            public C0077a(String r2, String r3) {
                Intrinsics.checkParameterIsNotNull(r2, InfoRequestQPSOptTraceLogger.REASON);
                Intrinsics.checkParameterIsNotNull(r3, "errorCode");
                super(null);
                this.f1020a = r2;
                this.f1021b = r3;
            }

            public final String a() {
                return this.f1020a;
            }

            public final String b() {
                return this.f1021b;
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L5;
                return true;
            L5:
                if (ZeusTransformUtils.instanceOf(r3, C0077a.class) == false) goto L11;
                C0077a r4 = (C0077a) ZeusTransformUtils.preCheckCast(r3, C0077a.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f1020a, r4.f1020a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f1021b, r4.f1021b) == true) goto L17;
                return false;
            L17:
                return true;
            L11:
                return false;
            }

            public int hashCode() {
                String r0 = this.f1020a;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                String r4 = this.f1021b;
                if (r4 == null) goto L10;
                r1 = r4.hashCode();
            L10:
                return r3 + r1;
            L5:
                r2 = 0;
                goto L6
            }

            public String toString() {
                return "Failure(reason=" + this.f1020a + ", errorCode=" + this.f1021b + ")";
            }
        }

        /* JADX INFO: renamed from: com.bytedance.api.location.a.a.a$a$b */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/api/location/service/continuous/ContinuousLocationManager$LocationResult$Success;", "Lcom/bytedance/api/location/service/continuous/ContinuousLocationManager$LocationResult;", "location", "Landroid/location/Location;", "locationType", "", "(Landroid/location/Location;I)V", "getLocation", "()Landroid/location/Location;", "getLocationType", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "bytelocation_release"}, k = 1, mv = {1, 1, 16})
        public static final class b extends AbstractC0076a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Location f1022a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final int f1023b;

            public b(Location r2, int r3) {
                Intrinsics.checkParameterIsNotNull(r2, "location");
                super(null);
                this.f1022a = r2;
                this.f1023b = r3;
            }

            public final Location a() {
                return this.f1022a;
            }

            public final int b() {
                return this.f1023b;
            }

            public boolean equals(Object r3) {
                if (this != r3) goto L5;
                return true;
            L5:
                if (ZeusTransformUtils.instanceOf(r3, b.class) == false) goto L11;
                b r4 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.memorydata.plugin");
                if (Intrinsics.areEqual(this.f1022a, r4.f1022a) == true) goto L9;
                return false;
            L9:
                if (this.f1023b == r4.f1023b) goto L17;
                return false;
            L17:
                return true;
            L11:
                return false;
            }

            public int hashCode() {
                Location r0 = this.f1022a;
                if (r0 == null) goto L5;
                int r1 = r0.hashCode();
            L7:
                return (r1 * 31) + this.f1023b;
            L5:
                r1 = 0;
                goto L7
            }

            public String toString() {
                return "Success(location=" + this.f1022a + ", locationType=" + this.f1023b + ")";
            }
        }

        private AbstractC0076a() {
        }

        public /* synthetic */ AbstractC0076a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J$\u0010\n\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0017¨\u0006\u000f"}, d2 = {"com/bytedance/api/location/service/continuous/ContinuousLocationManager$mLocationListener$1", "Landroid/location/LocationListener;", "onLocationChanged", "", "location", "Landroid/location/Location;", "onProviderDisabled", "provider", "", "onProviderEnabled", "onStatusChanged", "status", "", "extras", "Landroid/os/Bundle;", "bytelocation_release"}, k = 1, mv = {1, 1, 16})
    public static final class b implements LocationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f1024a;

        b(a r1) {
            this.f1024a = r1;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location r6) {
            Intrinsics.checkParameterIsNotNull(r6, "location");
            String r0 = r6.getProvider();
            Logger.i("ContinuousLocationManager onLocationChanged provider: " + r0);
            if (Intrinsics.areEqual("gps", r0) == false) goto L12;
            Bundle r1 = r6.getExtras();
            if (r1 == null) goto L12;
            if (r1.getBoolean("QUICKGPS", false) == false) goto L12;
            if (BDLocationConfig.isUseQuickGPS() == true) goto L12;
            Logger.i("ContinuousLocationManager onLocationChanged quickGPS");
            r6.setProvider("network");
            r0 = r6.getProvider();
        L12:
            if (Intrinsics.areEqual(r0, "network") == false) goto L18;
            Logger.i("ContinuousLocationManager onLocationChanged NETWORK");
            a.a(this.f1024a, r6);
            long r2 = System.currentTimeMillis();
            a.b(this.f1024a, r2);
            if (a.g(this.f1024a) == false) goto L16;
            return;
        L16:
            if ((r2 - a.c(this.f1024a)) < a.h(this.f1024a)) goto L22;
            a r5 = this.f1024a;
            int r3 = 4;
        L19:
            a.a(r5, r6, r3);
            return;
        L22:
            return;
        L18:
            Logger.i("ContinuousLocationManager onLocationChanged GPS");
            a.b(this.f1024a, r6);
            a.c(this.f1024a, System.currentTimeMillis());
            r5 = this.f1024a;
            r3 = 1;
            goto L19
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String r4) {
            Intrinsics.checkParameterIsNotNull(r4, "provider");
            Logger.i("ContinuousLocationManager onProviderDisabled provider: " + r4);
            if (Intrinsics.areEqual(r4, "gps") == false) goto L6;
            a.b(this.f1024a, (Location) ZeusTransformUtils.preCheckCast(null, Location.class, "com.obric.memorydata.plugin"));
            return;
        L6:
            if (Intrinsics.areEqual(r4, "network") == false) goto L10;
            a.a(this.f1024a, (Location) ZeusTransformUtils.preCheckCast(null, Location.class, "com.obric.memorydata.plugin"));
            return;
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String r2) {
            Intrinsics.checkParameterIsNotNull(r2, "provider");
            Logger.i("ContinuousLocationManager onProviderEnabled provider: " + r2);
        }

        @Override // android.location.LocationListener
        @Deprecated(message = "Deprecated in Java")
        public void onStatusChanged(String r1, int r2, Bundle r3) {
            Logger.i("ContinuousLocationManager onStatusChanged provider: " + r1 + " status: " + r2);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/bytedance/api/location/service/continuous/ContinuousLocationManager$periodicRunnable$1", "Ljava/lang/Runnable;", "run", "", "bytelocation_release"}, k = 1, mv = {1, 1, 16})
    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f1025a;

        c(a r1) {
            this.f1025a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.b(this.f1025a) == true) goto L5;
            return;
        L5:
            long r0 = System.currentTimeMillis();
            Logger.i("ContinuousLocationManager periodicRunnable now: " + r0 + ", mLastCallbackTime: " + a.c(this.f1025a) + ", mBackupIntervalMs: " + a.f(this.f1025a));
            if ((r0 - a.c(this.f1025a)) < a.f(this.f1025a)) goto L8;
            a.i(this.f1025a);
        L8:
            Handler r1 = a.d(this.f1025a);
            if (r1 == null) goto L12;
            r1.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.memorydata.plugin"), a.f(this.f1025a));
            return;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
    static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f1026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Location f1027b;
        final /* synthetic */ int c;

        d(a r1, Location r2, int r3) {
            this.f1026a = r1;
            this.f1027b = r2;
            this.c = r3;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (a.b(this.f1026a) == true) goto L5;
            return;
        L5:
            a.a(this.f1026a, System.currentTimeMillis());
            Function1 r0 = a.a(this.f1026a);
            if (r0 == null) goto L8;
            Unit r1 = (Unit) ZeusTransformUtils.preCheckCast(r0.invoke(new AbstractC0076a.b(this.f1027b, this.c)), Unit.class, "com.obric.memorydata.plugin");
        L8:
            Handler r2 = a.d(this.f1026a);
            if (r2 == null) goto L12;
            r2.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(a.e(this.f1026a), Runnable.class, "com.obric.memorydata.plugin"), a.f(this.f1026a));
            return;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 1, 16})
    static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ a f1028a;

        e(a r1) {
            this.f1028a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Function1 r3 = a.a(this.f1028a);
            if (r3 == null) goto L6;
            Unit r4 = (Unit) ZeusTransformUtils.preCheckCast(r3.invoke(new AbstractC0076a.C0077a("GPS and NETWORK Provider unavailable", BDLocationException.ERROR_LOCATION_NO_PROVIDER)), Unit.class, "com.obric.memorydata.plugin");
            return;
        }
    }

    public a(Context r7, LocationOption r8, Looper r9, Function1<? super AbstractC0076a, Unit> r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.memorydata.plugin");
        Function1<? super AbstractC0076a, Unit> r12 = (Function1) ZeusTransformUtils.wrapperContextForParams(r10, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkParameterIsNotNull(r11, "context");
        Intrinsics.checkParameterIsNotNull(r12, "onLocationResult");
        this.f1019b = 2000;
        this.c = 1000;
        this.e = 2000;
        this.f = 1000;
        this.g = 100000;
        this.i = r12;
        this.j = 2;
        this.r = r8;
        this.s = r9;
        Object r13 = r11.getSystemService("location");
        if (r13 == null) goto L39;
        this.h = (LocationManager) ZeusTransformUtils.preCheckCast(r13, LocationManager.class, "com.obric.memorydata.plugin");
        this.q = BDLocationExtrasService.getBPEAManager();
        if (r9 == null) goto L7;
        Handler r14 = new Handler(r9);
    L8:
        this.f1018a = r14;
        if (r8 == null) goto L11;
        long r15 = r8.getInterval();
    L12:
        this.c = r15;
        if (r15 > 0) goto L15;
        this.c = 1000;
    L15:
        if (r8 == null) goto L17;
        float r16 = r8.getMinUpdateDistance();
    L18:
        this.d = r16;
        if (r16 >= 0) goto L21;
        this.d = 0.0f;
    L21:
        if (r8 == null) goto L23;
        long r17 = r8.getBackupIntervalMs();
    L24:
        this.f1019b = r17;
        long r0 = this.c;
        if (r17 > r0) goto L27;
        this.f1019b = r0 + this.f;
    L27:
        if (r8 == null) goto L29;
        long r18 = r8.getGpsTimeoutMs();
    L30:
        this.e = r18;
        long r1 = this.c;
        if (r18 > r1) goto L33;
        this.e = r1 + this.f;
    L33:
        if (r8 == null) goto L35;
        int r19 = r8.getMode();
    L36:
        this.j = r19;
        Logger.i("ContinuousLocationManager constructor mMinUpdateIntervalMs: " + this.c + ", mMinUpdateDistance: " + this.d + ", mBackupIntervalMs: " + this.f1019b + ", mGpsTimeoutMs: " + this.e);
        this.t = new b(this);
        this.u = new c(this);
        this.v = new Object();
        return;
    L35:
        r19 = this.j;
        goto L36
    L29:
        r18 = this.e;
        goto L30
    L23:
        r17 = this.f1019b;
        goto L24
    L17:
        r16 = this.d;
        goto L18
    L11:
        r15 = this.c;
        goto L12
    L7:
        r14 = null;
        goto L8
    L39:
        throw new TypeCastException("null cannot be cast to non-null type android.location.LocationManager");
    }

    public static final /* synthetic */ Function1 a(a r0) {
        return r0.i;
    }

    private final void a(Location r5, int r6) {
    L16:
        e = move-exception;
        Logger.e("ContinuousLocationManager scheduleImmediateCallback", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        return;
    L4:
        if (this.p == true) goto L6;
        return;
    L6:
        Handler r1 = this.f1018a;     // Catch: Exception -> L16
        if (r1 == null) goto L9;
        r1.removeCallbacksAndMessages(this.v);     // Catch: Exception -> L16
    L9:
        Handler r2 = this.f1018a;     // Catch: Exception -> L16
        if (r2 == null) goto L12;
        r2.removeCallbacks((Runnable) ZeusTransformUtils.preCheckCast(this.u, Runnable.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L16
    L12:
        Handler r3 = this.f1018a;     // Catch: Exception -> L16
        if (r3 == null) goto L21;
        r3.postAtTime((Runnable) ZeusTransformUtils.preCheckCast(new d(this, r5, r6), Runnable.class, "com.obric.memorydata.plugin"), this.v, SystemClock.uptimeMillis());     // Catch: Exception -> L16
        return;
    }

    public static final /* synthetic */ void a(a r0, long r1) {
        r0.o = r1;
    }

    public static final /* synthetic */ void a(a r0, Location r1) {
        r0.l = r1;
    }

    public static final /* synthetic */ void a(a r0, Location r1, int r2) {
        r0.a(r1, r2);
    }

    public static final /* synthetic */ void b(a r0, long r1) {
        r0.n = r1;
    }

    public static final /* synthetic */ void b(a r0, Location r1) {
        r0.k = r1;
    }

    public static final /* synthetic */ boolean b(a r0) {
        return r0.p;
    }

    public static final /* synthetic */ long c(a r2) {
        return r2.o;
    }

    public static final /* synthetic */ void c(a r0, long r1) {
        r0.m = r1;
    }

    private final boolean c() {
        long r0 = System.currentTimeMillis();
        if (this.k != null) goto L5;
    L7:
        return false;
    L5:
        if ((r0 - this.m) >= this.e) goto L7;
        return true;
    }

    public static final /* synthetic */ Handler d(a r0) {
        return r0.f1018a;
    }

    private final Pair<Location, Integer> d() {
        long r0 = System.currentTimeMillis();
        if (c() == false) goto L12;
        if (this.k == null) goto L12;
        if ((r0 - this.m) >= (BDLocationConfig.getLocationExpiredInterval() + this.c)) goto L12;
        Location r10 = this.k;
        if (r10 != null) goto L20;
        return null;
    L20:
        return new Pair(r10, 1);
    L12:
        if (this.l != null) goto L14;
        return null;
    L14:
        if ((r0 - this.n) >= (BDLocationConfig.getLocationExpiredInterval() + this.c)) goto L22;
        Location r11 = this.l;
        if (r11 != null) goto L18;
        return null;
    L18:
        return new Pair(r11, 4);
    L22:
        return null;
    }

    public static final /* synthetic */ c e(a r0) {
        return r0.u;
    }

    private final void e() {
        Pair<Location, Integer> r0 = d();
        this.o = System.currentTimeMillis();
        if (r0 == null) goto L7;
        Function1<? super AbstractC0076a, Unit> r5 = this.i;
        if (r5 == null) goto L12;
        Unit r6 = r5.invoke(new AbstractC0076a.b((Location) ZeusTransformUtils.preCheckCast(r0.getFirst(), Location.class, "com.obric.memorydata.plugin"), ((Number) ZeusTransformUtils.preCheckCast(r0.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue()));
    L10:
        Unit r7 = (Unit) ZeusTransformUtils.preCheckCast(r6, Unit.class, "com.obric.memorydata.plugin");
        return;
    L12:
        return;
    L7:
        Logger.i("ContinuousLocationManager deliverBestAvailableResult No location available");
        Function1<? super AbstractC0076a, Unit> r8 = this.i;
        if (r8 == null) goto L13;
        r6 = r8.invoke(new AbstractC0076a.C0077a("No location available", BDLocationException.ERROR_NO_LOCATION));
        goto L10
    }

    public static final /* synthetic */ long f(a r2) {
        return r2.f1019b;
    }

    public static final /* synthetic */ boolean g(a r0) {
        return r0.c();
    }

    public static final /* synthetic */ long h(a r2) {
        return r2.c;
    }

    public static final /* synthetic */ void i(a r0) {
        r0.e();
    }

    public final void a() {
        Logger.i("ContinuousLocationManager startLocation isRunning: " + this.p);
        boolean r0 = true;
    L43:
        e = move-exception;
        Exception r4 = e;
        r0 = false;
    L45:
        Logger.e("ContinuousLocationManager startLocation exception: " + r4);
    L46:
        if (r0 == true) goto L51;
        this.p = false;
        Logger.e("ContinuousLocationManager startLocation GPS and NETWORK Provider unavailable");
        Handler r1 = this.f1018a;
        if (r1 == null) goto L59;
        r1.post((Runnable) ZeusTransformUtils.preCheckCast(new e(this), Runnable.class, "com.obric.memorydata.plugin"));
        return;
    L59:
        return;
    L51:
        Handler r2 = this.f1018a;
        if (r2 == null) goto L60;
        r2.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(this.u, Runnable.class, "com.obric.memorydata.plugin"), BDLocationConfig.getFirstLocationTimeoutMs());
        return;
    L60:
        return;
    L4:
        if (this.p == false) goto L6;
        return;
    L6:
        this.p = true;     // Catch: Exception -> L43
        LocationManager r5 = this.h;     // Catch: Exception -> L43
        if (r5 == null) goto L11;
        List<String> r6 = r5.getProviders(true);     // Catch: Exception -> L43
        if (r6 == null) goto L11;
    L12:
        Object r7 = null;
        if (r6.contains("gps") == false) goto L26;
        int r8 = this.j;     // Catch: Exception -> L43
        if (r8 == 2) goto L17;
        if (r8 != 1) goto L26;
    L17:
        IBPEALocal r9 = this.q;     // Catch: Exception -> L43
        if (r9 == null) goto L24;
        LocationManager r10 = this.h;     // Catch: Exception -> L43
        long r11 = this.c;     // Catch: Exception -> L43
        float r13 = this.d;     // Catch: Exception -> L43
        LocationListener r14 = (LocationListener) ZeusTransformUtils.preCheckCast(this.t, LocationListener.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L43
        Looper r15 = this.s;     // Catch: Exception -> L43
        LocationOption r12 = this.r;     // Catch: Exception -> L43
        if (r12 == null) goto L22;
        Object r16 = r12.getBpeaCert();     // Catch: Exception -> L43
    L23:
        r9.requestLocationUpdates(r10, "gps", r11, r13, r14, r15, r16);     // Catch: Exception -> L43
        goto L24
    L22:
        r16 = null;
    L24:
        Logger.i("ContinuousLocationManager startLocation GPS Provider started");     // Catch: Exception -> L43
        boolean r17 = true;
    L57:
    L41:
        e = move-exception;
        r4 = e;
        r0 = r17;
        goto L45
    L28:
        if (r6.contains("network") == false) goto L40;
        int r18 = this.j;     // Catch: Exception -> L41
        if (r18 == 2) goto L32;
        if (r18 != 0) goto L40;
    L32:
        IBPEALocal r19 = this.q;     // Catch: Exception -> L41
        if (r19 == null) goto L38;
        LocationManager r20 = this.h;     // Catch: Exception -> L41
        long r110 = this.c;     // Catch: Exception -> L41
        float r111 = this.d;     // Catch: Exception -> L41
        LocationListener r112 = (LocationListener) ZeusTransformUtils.preCheckCast(this.t, LocationListener.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L41
        Looper r113 = this.s;     // Catch: Exception -> L41
        LocationOption r21 = this.r;     // Catch: Exception -> L41
        if (r21 == null) goto L37;
        r7 = r21.getBpeaCert();     // Catch: Exception -> L41
    L37:
        r19.requestLocationUpdates(r20, "network", r110, r111, r112, r113, r7);     // Catch: Exception -> L41
    L38:
        Logger.i("ContinuousLocationManager startLocation NETWORK Provider started");     // Catch: Exception -> L41
    L40:
        r0 = r17;
    L26:
        r17 = false;
    L11:
        r6 = CollectionsKt.emptyList();     // Catch: Exception -> L43
        goto L12
    }

    public final void b() {
        this.p = false;     // Catch: Exception -> L14
        Handler r1 = this.f1018a;     // Catch: Exception -> L14
        if (r1 == null) goto L6;
        r1.removeCallbacks((Runnable) ZeusTransformUtils.preCheckCast(this.u, Runnable.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L14
    L6:
        Handler r2 = this.f1018a;     // Catch: Exception -> L14
        if (r2 == null) goto L9;
        r2.removeCallbacksAndMessages(this.v);     // Catch: Exception -> L14
    L9:
        LocationManager r3 = this.h;     // Catch: Exception -> L14
        if (r3 == null) goto L12;
        r3.removeUpdates((LocationListener) ZeusTransformUtils.preCheckCast(this.t, LocationListener.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L14
    L12:
        this.k = (Location) ZeusTransformUtils.preCheckCast(null, Location.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        this.l = (Location) ZeusTransformUtils.preCheckCast(null, Location.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L14
        this.m = 0;     // Catch: Exception -> L14
        this.o = 0;     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        Logger.e("ContinuousLocationManager stopLocation error:", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }
}
