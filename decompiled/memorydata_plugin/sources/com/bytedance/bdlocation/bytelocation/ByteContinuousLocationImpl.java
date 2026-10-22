package com.bytedance.bdlocation.bytelocation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import androidx.core.app.FrameMetricsAggregator;
import com.bytedance.api.location.a.a.a;
import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.BDPoint;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitor;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 H2\u00020\u0001:\u0002HIB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0014\u0010 \u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\"\u001a\u00020\tH\u0016J\u0018\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%H\u0016J,\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u001a2\u0006\u0010+\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u0006H\u0002J,\u0010-\u001a\u00020(2\u0006\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u001a2\u0006\u0010+\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u0006H\u0002J4\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020\t2\u0006\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u001a2\u0006\u0010+\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u0006H\u0002J$\u00100\u001a\u00020(2\u0006\u00101\u001a\u0002022\b\u0010*\u001a\u0004\u0018\u00010\u001a2\b\u0010,\u001a\u0004\u0018\u00010\u0006H\u0002J,\u00103\u001a\u00020(2\u0006\u0010/\u001a\u00020\t2\u0006\u00101\u001a\u0002022\b\u0010*\u001a\u0004\u0018\u00010\u001a2\b\u0010,\u001a\u0004\u0018\u00010\u0006H\u0002J&\u00104\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010\u00062\b\u0010*\u001a\u0004\u0018\u00010\u001a2\b\u00105\u001a\u0004\u0018\u00010\u0013H\u0016J&\u00106\u001a\u00020(2\b\u0010,\u001a\u0004\u0018\u00010\u00062\b\u0010*\u001a\u0004\u0018\u00010\u001a2\b\u00105\u001a\u0004\u0018\u00010\u0013H\u0002J.\u00107\u001a\u00020(2\u0006\u0010/\u001a\u00020\t2\b\u0010,\u001a\u0004\u0018\u00010\u00062\b\u0010*\u001a\u0004\u0018\u00010\u001a2\b\u00105\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u00108\u001a\u00020(H\u0002J\u0006\u00109\u001a\u00020(J\u0018\u0010:\u001a\u00020(2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010/\u001a\u00020\tH\u0002J\b\u0010;\u001a\u00020(H\u0016J\u0012\u0010<\u001a\u00020(2\b\u0010/\u001a\u0004\u0018\u00010\tH\u0016J\u001c\u0010=\u001a\u0004\u0018\u00010\u000e2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020AH\u0003J\b\u0010B\u001a\u00020(H\u0002J\u0010\u0010C\u001a\u00020(2\u0006\u0010\u0002\u001a\u00020\nH\u0002J,\u0010D\u001a\u00020(2\b\u0010>\u001a\u0004\u0018\u00010\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u001a2\u0006\u0010+\u001a\u00020\t2\u0006\u0010E\u001a\u00020\tH\u0002J,\u0010F\u001a\u00020(2\b\u0010>\u001a\u0004\u0018\u00010\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u001a2\u0006\u0010+\u001a\u00020\t2\u0006\u0010E\u001a\u00020\tH\u0002J4\u0010G\u001a\u00020(2\u0006\u0010/\u001a\u00020\t2\b\u0010>\u001a\u0004\u0018\u00010\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u001a2\u0006\u0010+\u001a\u00020\t2\u0006\u0010E\u001a\u00020\tH\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006J"}, d2 = {"Lcom/bytedance/bdlocation/bytelocation/ByteContinuousLocationImpl;", "Lcom/bytedance/bdlocation/BaseLocate;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mCallback", "Lcom/bytedance/bdlocation/callback/BDLocationCallback;", "mContinuousClients", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/bytedance/bdlocation/bytelocation/ByteContinuousLocationImpl$ContinuousLocationContext;", "mIsFirstLocation", "", "mLastLocation", "Lcom/bytedance/bdlocation/BDLocation;", "mLastLocationStartTime", "", "mLastSetUploadNetSignalTime", "mLocationLooper", "Landroid/os/Looper;", "mLocationManager", "Lcom/bytedance/api/location/service/continuous/ContinuousLocationManager;", "mLocationRunning", "mLock", "", "mOption", "Lcom/bytedance/bdlocation/client/LocationOption;", "calculateLineDistance", "", "startLatlng", "Lcom/bytedance/bdlocation/client/BDPoint;", "endLatlng", "convertGCJ02", LocationInfoConst.WGS_84, "getLocateName", "isAMapDataAvailable", "latitude", "", "longitude", "onError", "", InfoRequestQPSOptTraceLogger.REASON, "option", "errorCode", "callback", "onErrorLegacy", "onErrorMulti", "businessId", "onSuccessLegacy", "result", "Lcom/bytedance/api/location/service/continuous/ContinuousLocationManager$LocationResult$Success;", "onSuccessMulti", "startLocation", "looper", "startLocationLegacy", "startLocationMulti", "stopAllBusinessLocations", "stopAllLocations", "stopContextSafely", "stopLocation", "stopLocationForBusiness", "transform", "location", "Landroid/location/Location;", "locationType", "", "uploadLastLocation", "uploadLastLocationForBusiness", "uploadMonitor", "errMessage", "uploadMonitorLegacy", "uploadMonitorMulti", "Companion", "ContinuousLocationContext", "bytelocation_release"}, k = 1, mv = {1, 1, 16})
public final class ByteContinuousLocationImpl extends BaseLocate {
    public static final Companion Companion = null;
    private static final String DEFAULT_BUSINESS_ID = "default_continuous_location";
    private BDLocationCallback mCallback;
    private final ConcurrentHashMap<String, ContinuousLocationContext> mContinuousClients;
    private volatile boolean mIsFirstLocation;
    private volatile BDLocation mLastLocation;
    private volatile long mLastLocationStartTime;
    private volatile long mLastSetUploadNetSignalTime;
    private Looper mLocationLooper;
    private a mLocationManager;
    private volatile boolean mLocationRunning;
    private final Object mLock;
    private LocationOption mOption;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/bytedance/bdlocation/bytelocation/ByteContinuousLocationImpl$Companion;", "", "()V", "DEFAULT_BUSINESS_ID", "", "bytelocation_release"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b/\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001Bi\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f¢\u0006\u0002\u0010\u0012J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u00107\u001a\u00020\rHÆ\u0003J\t\u00108\u001a\u00020\u000fHÆ\u0003J\t\u00109\u001a\u00020\rHÆ\u0003J\t\u0010:\u001a\u00020\u000fHÆ\u0003Jm\u0010;\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\u000fHÆ\u0001J\u0013\u0010<\u001a\u00020\u000f2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020?HÖ\u0001J\t\u0010@\u001a\u00020AHÖ\u0001R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0010\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010\u0011\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0017\"\u0004\b/\u0010\u0019R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001f\"\u0004\b1\u0010!¨\u0006B"}, d2 = {"Lcom/bytedance/bdlocation/bytelocation/ByteContinuousLocationImpl$ContinuousLocationContext;", "", "manager", "Lcom/bytedance/api/location/service/continuous/ContinuousLocationManager;", "looper", "Landroid/os/Looper;", "option", "Lcom/bytedance/bdlocation/client/LocationOption;", "callback", "Lcom/bytedance/bdlocation/callback/BDLocationCallback;", "lastLocation", "Lcom/bytedance/bdlocation/BDLocation;", "startTime", "", "isFirstLocation", "", "lastSetUploadNetSignalTime", "running", "(Lcom/bytedance/api/location/service/continuous/ContinuousLocationManager;Landroid/os/Looper;Lcom/bytedance/bdlocation/client/LocationOption;Lcom/bytedance/bdlocation/callback/BDLocationCallback;Lcom/bytedance/bdlocation/BDLocation;JZJZ)V", "getCallback", "()Lcom/bytedance/bdlocation/callback/BDLocationCallback;", "setCallback", "(Lcom/bytedance/bdlocation/callback/BDLocationCallback;)V", "()Z", "setFirstLocation", "(Z)V", "getLastLocation", "()Lcom/bytedance/bdlocation/BDLocation;", "setLastLocation", "(Lcom/bytedance/bdlocation/BDLocation;)V", "getLastSetUploadNetSignalTime", "()J", "setLastSetUploadNetSignalTime", "(J)V", "getLooper", "()Landroid/os/Looper;", "setLooper", "(Landroid/os/Looper;)V", "getManager", "()Lcom/bytedance/api/location/service/continuous/ContinuousLocationManager;", "setManager", "(Lcom/bytedance/api/location/service/continuous/ContinuousLocationManager;)V", "getOption", "()Lcom/bytedance/bdlocation/client/LocationOption;", "setOption", "(Lcom/bytedance/bdlocation/client/LocationOption;)V", "getRunning", "setRunning", "getStartTime", "setStartTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "", "bytelocation_release"}, k = 1, mv = {1, 1, 16})
    private static final class ContinuousLocationContext {
        private BDLocationCallback callback;
        private boolean isFirstLocation;
        private BDLocation lastLocation;
        private long lastSetUploadNetSignalTime;
        private Looper looper;
        private a manager;
        private LocationOption option;
        private boolean running;
        private long startTime;

        public ContinuousLocationContext() {
            this(null, null, null, null, null, 0, false, 0, false, FrameMetricsAggregator.EVERY_DURATION, null);
        }

        public ContinuousLocationContext(a r3, Looper r4, LocationOption r5, BDLocationCallback r6, BDLocation r7, long r8, boolean r10, long r11, boolean r13) {
            BDLocationCallback r9 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r6, BDLocationCallback.class, "com.obric.memorydata.plugin");
            this.manager = r3;
            this.looper = r4;
            this.option = r5;
            this.callback = r9;
            this.lastLocation = r7;
            this.startTime = r8;
            this.isFirstLocation = r10;
            this.lastSetUploadNetSignalTime = r11;
            this.running = r13;
        }

        public /* synthetic */ ContinuousLocationContext(a r13, Looper r14, LocationOption r15, BDLocationCallback r16, BDLocation r17, long r18, boolean r20, long r21, boolean r23, int r24, DefaultConstructorMarker r25) {
            BDLocationCallback r1 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r16, BDLocationCallback.class, "com.obric.memorydata.plugin");
            if ((r24 & 1) == 0) goto L5;
            a r3 = (a) ZeusTransformUtils.preCheckCast(null, a.class, "com.obric.memorydata.plugin");
        L7:
            if ((r24 & 2) == 0) goto L9;
            Looper r5 = (Looper) ZeusTransformUtils.preCheckCast(null, Looper.class, "com.obric.memorydata.plugin");
        L11:
            if ((r24 & 4) == 0) goto L13;
            LocationOption r6 = (LocationOption) ZeusTransformUtils.preCheckCast(null, LocationOption.class, "com.obric.memorydata.plugin");
        L15:
            if ((r24 & 8) == 0) goto L18;
            r1 = (BDLocationCallback) ZeusTransformUtils.preCheckCast(null, BDLocationCallback.class, "com.obric.memorydata.plugin");
        L18:
            if ((r24 & 16) == 0) goto L20;
            BDLocation r2 = (BDLocation) ZeusTransformUtils.preCheckCast(null, BDLocation.class, "com.obric.memorydata.plugin");
        L21:
            long r7 = 0;
            if ((r24 & 32) == 0) goto L24;
            long r9 = 0;
        L26:
            if ((r24 & 64) == 0) goto L28;
            boolean r4 = true;
        L30:
            if ((r24 & 128) != 0) goto L34;
            r7 = r21;
        L34:
            if ((r24 & 256) == 0) goto L36;
            boolean r0 = false;
        L37:
            this(r3, r5, r6, r1, r2, r9, r4, r7, r0);
            return;
        L36:
            r0 = r23;
            goto L37
        L28:
            r4 = r20;
            goto L30
        L24:
            r9 = r18;
            goto L26
        L20:
            r2 = r17;
            goto L21
        L13:
            r6 = r15;
            goto L15
        L9:
            r5 = r14;
            goto L11
        L5:
            r3 = r13;
            goto L7
        }

        public static /* synthetic */ ContinuousLocationContext copy$default(ContinuousLocationContext r12, a r13, Looper r14, LocationOption r15, BDLocationCallback r16, BDLocation r17, long r18, boolean r20, long r21, boolean r23, int r24, Object r25) {
            BDLocationCallback r2 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r16, BDLocationCallback.class, "com.obric.memorydata.plugin");
            if ((r24 & 1) == 0) goto L5;
            a r3 = r12.manager;
        L7:
            if ((r24 & 2) == 0) goto L9;
            Looper r4 = r12.looper;
        L11:
            if ((r24 & 4) == 0) goto L13;
            LocationOption r5 = r12.option;
        L15:
            if ((r24 & 8) == 0) goto L18;
            r2 = r12.callback;
        L18:
            if ((r24 & 16) == 0) goto L20;
            BDLocation r6 = r12.lastLocation;
        L22:
            if ((r24 & 32) == 0) goto L24;
            long r7 = r12.startTime;
        L26:
            if ((r24 & 64) == 0) goto L28;
            boolean r9 = r12.isFirstLocation;
        L30:
            if ((r24 & 128) == 0) goto L32;
            long r10 = r12.lastSetUploadNetSignalTime;
        L34:
            if ((r24 & 256) == 0) goto L36;
            boolean r1 = r12.running;
        L38:
            return r12.copy(r3, r4, r5, r2, r6, r7, r9, r10, r1);
        L36:
            r1 = r23;
            goto L38
        L32:
            r10 = r21;
            goto L34
        L28:
            r9 = r20;
            goto L30
        L24:
            r7 = r18;
            goto L26
        L20:
            r6 = r17;
            goto L22
        L13:
            r5 = r15;
            goto L15
        L9:
            r4 = r14;
            goto L11
        L5:
            r3 = r13;
            goto L7
        }

        public final a component1() {
            return this.manager;
        }

        public final Looper component2() {
            return this.looper;
        }

        public final LocationOption component3() {
            return this.option;
        }

        public final BDLocationCallback component4() {
            return this.callback;
        }

        public final BDLocation component5() {
            return this.lastLocation;
        }

        public final long component6() {
            return this.startTime;
        }

        public final boolean component7() {
            return this.isFirstLocation;
        }

        public final long component8() {
            return this.lastSetUploadNetSignalTime;
        }

        public final boolean component9() {
            return this.running;
        }

        public final ContinuousLocationContext copy(a r14, Looper r15, LocationOption r16, BDLocationCallback r17, BDLocation r18, long r19, boolean r21, long r22, boolean r24) {
            return new ContinuousLocationContext(r14, r15, r16, (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r17, BDLocationCallback.class, "com.obric.memorydata.plugin"), r18, r19, r21, r22, r24);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L5;
            return true;
        L5:
            if (ZeusTransformUtils.instanceOf(r5, ContinuousLocationContext.class) == false) goto L25;
            ContinuousLocationContext r6 = (ContinuousLocationContext) ZeusTransformUtils.preCheckCast(r5, ContinuousLocationContext.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.manager, r6.manager) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.looper, r6.looper) == true) goto L11;
            return false;
        L11:
            if (Intrinsics.areEqual(this.option, r6.option) == true) goto L13;
            return false;
        L13:
            if (Intrinsics.areEqual(this.callback, r6.callback) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.lastLocation, r6.lastLocation) == true) goto L17;
            return false;
        L17:
            if (this.startTime == r6.startTime) goto L19;
            return false;
        L19:
            if (this.isFirstLocation == r6.isFirstLocation) goto L21;
            return false;
        L21:
            if (this.lastSetUploadNetSignalTime == r6.lastSetUploadNetSignalTime) goto L23;
            return false;
        L23:
            if (this.running == r6.running) goto L38;
            return false;
        L38:
            return true;
        L25:
            return false;
        }

        public final BDLocationCallback getCallback() {
            return this.callback;
        }

        public final BDLocation getLastLocation() {
            return this.lastLocation;
        }

        public final long getLastSetUploadNetSignalTime() {
            return this.lastSetUploadNetSignalTime;
        }

        public final Looper getLooper() {
            return this.looper;
        }

        public final a getManager() {
            return this.manager;
        }

        public final LocationOption getOption() {
            return this.option;
        }

        public final boolean getRunning() {
            return this.running;
        }

        public final long getStartTime() {
            return this.startTime;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v14, types: [int] */
        /* JADX WARN: Type inference failed for: r0v18, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r2v10 */
        /* JADX WARN: Type inference failed for: r2v11, types: [int] */
        /* JADX WARN: Type inference failed for: r2v12 */
        public int hashCode() {
            a r0 = this.manager;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Looper r4 = this.looper;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            LocationOption r7 = this.option;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            BDLocationCallback r10 = this.callback;
            if (r10 == null) goto L17;
            int r11 = r10.hashCode();
        L18:
            int r12 = (r9 + r11) * 31;
            BDLocation r13 = this.lastLocation;
            if (r13 == null) goto L21;
            r1 = r13.hashCode();
        L21:
            int r14 = (r12 + r1) * 31;
            long r15 = this.startTime;
            int r16 = (r14 + ((int) (r15 ^ (r15 >>> 32)))) * 31;
            boolean r17 = this.isFirstLocation;
            ?? r18 = 1;
            ?? r19 = r17;
            if (r17 == false) goto L24;
            r19 = 1;
        L24:
            long r20 = this.lastSetUploadNetSignalTime;
            int r21 = (((r16 + r19) * 31) + ((int) (r20 ^ (r20 >>> 32)))) * 31;
            boolean r22 = this.running;
            if (r22 == true) goto L29;
            r18 = r22;
        L29:
            return r21 + r18;
        L17:
            r11 = 0;
            goto L18
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final boolean isFirstLocation() {
            return this.isFirstLocation;
        }

        public final void setCallback(BDLocationCallback r3) {
            this.callback = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r3, BDLocationCallback.class, "com.obric.memorydata.plugin");
        }

        public final void setFirstLocation(boolean r1) {
            this.isFirstLocation = r1;
        }

        public final void setLastLocation(BDLocation r1) {
            this.lastLocation = r1;
        }

        public final void setLastSetUploadNetSignalTime(long r1) {
            this.lastSetUploadNetSignalTime = r1;
        }

        public final void setLooper(Looper r1) {
            this.looper = r1;
        }

        public final void setManager(a r1) {
            this.manager = r1;
        }

        public final void setOption(LocationOption r1) {
            this.option = r1;
        }

        public final void setRunning(boolean r1) {
            this.running = r1;
        }

        public final void setStartTime(long r1) {
            this.startTime = r1;
        }

        public String toString() {
            return "ContinuousLocationContext(manager=" + this.manager + ", looper=" + this.looper + ", option=" + this.option + ", callback=" + this.callback + ", lastLocation=" + this.lastLocation + ", startTime=" + this.startTime + ", isFirstLocation=" + this.isFirstLocation + ", lastSetUploadNetSignalTime=" + this.lastSetUploadNetSignalTime + ", running=" + this.running + ")";
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ByteContinuousLocationImpl(Context r3) {
        super((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
        this.mLock = new Object();
        this.mIsFirstLocation = true;
        this.mContinuousClients = new ConcurrentHashMap();
    }

    public static final /* synthetic */ ConcurrentHashMap access$getMContinuousClients$p(ByteContinuousLocationImpl r0) {
        return r0.mContinuousClients;
    }

    public static final /* synthetic */ long access$getMLastSetUploadNetSignalTime$p(ByteContinuousLocationImpl r2) {
        return r2.mLastSetUploadNetSignalTime;
    }

    public static final /* synthetic */ void access$onErrorLegacy(ByteContinuousLocationImpl r2, String r3, LocationOption r4, String r5, BDLocationCallback r6) {
        r2.onErrorLegacy(r3, r4, r5, (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r6, BDLocationCallback.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$onErrorMulti(ByteContinuousLocationImpl r6, String r7, String r8, LocationOption r9, String r10, BDLocationCallback r11) {
        r6.onErrorMulti(r7, r8, r9, r10, (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r11, BDLocationCallback.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$onSuccessLegacy(ByteContinuousLocationImpl r2, a.AbstractC0076a.b r3, LocationOption r4, BDLocationCallback r5) {
        r2.onSuccessLegacy(r3, r4, (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r5, BDLocationCallback.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$onSuccessMulti(ByteContinuousLocationImpl r2, String r3, a.AbstractC0076a.b r4, LocationOption r5, BDLocationCallback r6) {
        r2.onSuccessMulti(r3, r4, r5, (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r6, BDLocationCallback.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ void access$setMLastSetUploadNetSignalTime$p(ByteContinuousLocationImpl r0, long r1) {
        r0.mLastSetUploadNetSignalTime = r1;
    }

    private final void onError(String r3, LocationOption r4, String r5, BDLocationCallback r6) {
        BDLocationCallback r7 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r6, BDLocationCallback.class, "com.obric.memorydata.plugin");
        BDLocationException r0 = new BDLocationException(r3, getLocateName(), r5);
        uploadMonitorLegacy(null, r4, r5, r3);
        if (r7 == null) goto L6;
        r7.onError(r0);
        return;
    }

    private final void onErrorLegacy(String r3, LocationOption r4, String r5, BDLocationCallback r6) {
        BDLocationCallback r7 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r6, BDLocationCallback.class, "com.obric.memorydata.plugin");
        BDLocationException r0 = new BDLocationException(r3, getLocateName(), r5);
        uploadMonitorLegacy(null, r4, r5, r3);
        if (r7 == null) goto L6;
        r7.onError(r0);
        return;
    }

    private final void onErrorMulti(String r9, String r10, LocationOption r11, String r12, BDLocationCallback r13) {
        BDLocationCallback r14 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r13, BDLocationCallback.class, "com.obric.memorydata.plugin");
        BDLocationException r0 = new BDLocationException(r10, getLocateName(), r12);
        uploadMonitorMulti(r9, null, r11, r12, r10);
        if (r14 == null) goto L6;
        r14.onError(r0);
        return;
    }

    private final void onSuccessLegacy(a.AbstractC0076a.b r7, LocationOption r8, BDLocationCallback r9) {
        BDLocationCallback r10 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r9, BDLocationCallback.class, "com.obric.memorydata.plugin");
        Location r1 = r7.a();     // Catch: Exception -> L15
        int r3 = r7.b();     // Catch: Exception -> L15
        Location r11 = r7.a();     // Catch: Exception -> L15
        if (r11 == null) goto L6;
        String r12 = r11.getProvider();     // Catch: Exception -> L15
    L7:
        Logger.i("location locationType: " + r3 + " - provider: " + r12);     // Catch: Exception -> L15
        BDLocation r13 = transform(r1, r3);     // Catch: Exception -> L15
        if (r13 != null) goto L11;
        onError("location is null", r8, BDLocationException.ERROR_UNKNOWN, r10);     // Catch: Exception -> L15
        return;
    L11:
        this.mLastLocation = r13;     // Catch: Exception -> L15
        uploadMonitorLegacy(r13, r8, BDLocationException.SUCCESS, "success");     // Catch: Exception -> L15
        if (r10 == null) goto L19;
        r10.onLocationChanged(r13);     // Catch: Exception -> L15
        return;
    L19:
        return;
    L6:
        r12 = null;
    L15:
        e = move-exception;
        Logger.e("onSuccessLegacy error:", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        onError("onSuccessLegacy error", r8, BDLocationException.ERROR_UNKNOWN, r10);
    }

    private final void onSuccessMulti(String r11, a.AbstractC0076a.b r12, LocationOption r13, BDLocationCallback r14) {
        BDLocationCallback r15 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r14, BDLocationCallback.class, "com.obric.memorydata.plugin");
        Location r1 = r12.a();     // Catch: Exception -> L17
        int r3 = r12.b();     // Catch: Exception -> L17
        Location r16 = r12.a();     // Catch: Exception -> L17
        if (r16 == null) goto L6;
        String r17 = r16.getProvider();     // Catch: Exception -> L17
    L7:
        Logger.i("location locationType: " + r3 + " - provider: " + r17 + ", businessId: " + r11);     // Catch: Exception -> L17
        BDLocation r18 = transform(r1, r3);     // Catch: Exception -> L17
        if (r18 != null) goto L11;
        onError("location is null", r13, BDLocationException.ERROR_UNKNOWN, r15);     // Catch: Exception -> L17
        return;
    L11:
        ContinuousLocationContext r2 = (ContinuousLocationContext) ZeusTransformUtils.preCheckCast(this.mContinuousClients.get(r11), ContinuousLocationContext.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L17
        if (r2 == null) goto L14;
        r2.setLastLocation(r18);     // Catch: Exception -> L17
        uploadMonitorMulti(r11, r18, r13, BDLocationException.SUCCESS, "success");     // Catch: Exception -> L17
    L14:
        if (r15 == null) goto L21;
        r15.onLocationChanged(r18);     // Catch: Exception -> L17
        return;
    L21:
        return;
    L6:
        r17 = null;
    L17:
        e = move-exception;
        Logger.e("onSuccessMulti error:", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        onError("onSuccessMulti error", r13, BDLocationException.ERROR_UNKNOWN, r15);
    }

    private final void startLocationLegacy(BDLocationCallback r8, final LocationOption r9, final Looper r10) {
        final BDLocationCallback r11 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r8, BDLocationCallback.class, "com.obric.memorydata.plugin");
        Object r0 = this.mLock;     // Catch: Exception -> L32
        monitor-enter(r0);     // Catch: Exception -> L32
        this.mLocationLooper = r10;     // Catch: Throwable -> L29
        this.mOption = r9;     // Catch: Throwable -> L29
        this.mCallback = r11;     // Catch: Throwable -> L29
        this.mIsFirstLocation = true;     // Catch: Throwable -> L29
        this.mLastLocationStartTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L29
        super.startLocation(r11, r9, r10);     // Catch: Throwable -> L29
        if (LocationUtil.isLocationEnabled() == true) goto L11;
        BDLocationException r12 = new BDLocationException("location service is disabled, please enable it in settings", getLocateName(), BDLocationException.ERROR_DEVICE_LOCATION_DISABLE);     // Catch: Throwable -> L29
        if (r11 == null) goto L26;
    L9:
        r11.onError(r12);     // Catch: Throwable -> L29
    L26:
        Unit r13 = Unit.INSTANCE;     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Exception -> L32
        return;
    L11:
        if (LocationUtil.checkBackground() == false) goto L15;
        if (r11 == null) goto L26;
        r12 = new BDLocationException("application is in background, not allow to locate", getLocateName(), BDLocationException.ERROR_BACKGROUND_LOCATE);     // Catch: Throwable -> L29
        goto L9
    L15:
        if (this.mContext != null) goto L19;
        r12 = new BDLocationException("mContext is null", getLocateName(), BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT);     // Catch: Throwable -> L29
        if (r11 == null) goto L26;
    L19:
        a r2 = this.mLocationManager;     // Catch: Throwable -> L29
        if (r2 == null) goto L22;
        r2.b();     // Catch: Throwable -> L29
    L22:
        Context r3 = this.mContext;     // Catch: Throwable -> L29
        Intrinsics.checkExpressionValueIsNotNull(r3, "mContext");     // Catch: Throwable -> L29
        a r4 = new a(r3, r9, r10, (Function1) ZeusTransformUtils.preCheckCast(new ByteContinuousLocationImpl$startLocationLegacy$$inlined$synchronized$lambda$1(this, r10, r9, r11), Function1.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L29
        this.mLocationManager = r4;     // Catch: Throwable -> L29
        if (r4 == null) goto L25;
        r4.a();     // Catch: Throwable -> L29
    L25:
        this.mLocationRunning = true;     // Catch: Throwable -> L29
        Logger.i("ByteContinuousLocationImpl startLocationLegacy completed");     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        throw th;     // Catch: Exception -> L32
    L32:
        e = move-exception;
        Logger.e("startLocation error:", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        onError("startLocation error", r9, BDLocationException.ERROR_UNKNOWN, r11);
    }

    private final void startLocationMulti(final String r23, BDLocationCallback r24, final LocationOption r25, final Looper r26) {
        final BDLocationCallback r4 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r24, BDLocationCallback.class, "com.obric.memorydata.plugin");
        Object r3 = this.mLock;     // Catch: Exception -> L38
        monitor-enter(r3);     // Catch: Exception -> L38
        stopLocationForBusiness(r23);     // Catch: Throwable -> L32
        super.startLocation(r4, r25, r26);     // Catch: Throwable -> L32
        if (LocationUtil.isLocationEnabled() == true) goto L11;
        BDLocationException r0 = new BDLocationException("location service is disabled, please enable it in settings", getLocateName(), BDLocationException.ERROR_DEVICE_LOCATION_DISABLE);     // Catch: Throwable -> L32
        if (r4 != null) goto L14;
    L15:
        Object r12 = r3;
    L27:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(r12);     // Catch: Exception -> L36
        return;
    L30:
        th = th;
    L34:
        monitor-exit(r12);     // Catch: Exception -> L36
        throw th;     // Catch: Exception -> L36
    L14:
        r4.onError(r0);     // Catch: Throwable -> L32
        goto L15
    L11:
        if (LocationUtil.checkBackground() == false) goto L17;
        if (r4 == null) goto L15;
        r0 = new BDLocationException("application is in background, not allow to locate", getLocateName(), BDLocationException.ERROR_BACKGROUND_LOCATE);     // Catch: Throwable -> L32
        goto L14
    L17:
        if (this.mContext != null) goto L21;
        r0 = new BDLocationException("mContext is null", getLocateName(), BDLocationException.ERROR_BYTE_CONTINUOUS_CLIENT);     // Catch: Throwable -> L32
        if (r4 == null) goto L15;
    L21:
        ContinuousLocationContext r2 = new ContinuousLocationContext(null, r26, r25, r4, null, SystemClock.elapsedRealtime(), true, 0, false, 17, null);     // Catch: Throwable -> L32
        Context r9 = this.mContext;     // Catch: Throwable -> L32
        Intrinsics.checkExpressionValueIsNotNull(r9, "mContext");     // Catch: Throwable -> L32
        r12 = r3;
        r2.setManager(new a(r9, r25, r26, (Function1) ZeusTransformUtils.preCheckCast(new ByteContinuousLocationImpl$startLocationMulti$$inlined$synchronized$lambda$1(this, r23, r4, r25, r26), Function1.class, "com.obric.memorydata.plugin")));     // Catch: Throwable -> L30
        a r5 = r2.getManager();     // Catch: Throwable -> L30
        if (r5 == null) goto L26;
        r5.a();     // Catch: Throwable -> L30
    L26:
        r2.setRunning(true);     // Catch: Throwable -> L30
        ((Map) ZeusTransformUtils.preCheckCast(this.mContinuousClients, Map.class, "com.obric.memorydata.plugin")).put(r23, r2);     // Catch: Throwable -> L30
        Logger.i("ByteContinuousLocationImpl startLocationMulti completed, businessId: " + r23 + ", total clients: " + this.mContinuousClients.size());     // Catch: Throwable -> L30
    L32:
        th = th;
        r12 = r3;
    L36:
        e = e;
    L40:
        Logger.e("startLocationMulti error:", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        onError("startLocationMulti error", r25, BDLocationException.ERROR_UNKNOWN, r4);
        return;
    L38:
        e = e;
        goto L40
    }

    private final void stopAllBusinessLocations() {
        Iterator r0 = ((Map) ZeusTransformUtils.preCheckCast(this.mContinuousClients, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin");
        stopContextSafely((ContinuousLocationContext) ZeusTransformUtils.preCheckCast(r1.getValue(), ContinuousLocationContext.class, "com.obric.memorydata.plugin"), r3);
        goto L4
    L6:
        this.mContinuousClients.clear();
        Logger.i("ByteContinuousLocationImpl stopAllBusinessLocations completed");
    }

    private final void stopContextSafely(ContinuousLocationContext r5, String r6) {
        a r1 = r5.getManager();     // Catch: Exception -> L13
        if (r1 != null) goto L18;
    L9:
        r5.setRunning(false);     // Catch: Exception -> L13
        r5.setManager((a) ZeusTransformUtils.preCheckCast(null, a.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L13
        r5.setLastSetUploadNetSignalTime(0);     // Catch: Exception -> L13
        if (BDLocationConfig.needUploadLastContinuousLocation() == false) goto L20;
        uploadLastLocationForBusiness(r5);     // Catch: Exception -> L13
        return;
    L20:
        return;
    L18:
        r1.b();     // Catch: Exception -> L7
    L7:
        e = move-exception;
        Logger.e("stopContextSafely error: " + e.getMessage() + ", businessId: " + r6);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Logger.e("ByteContinuousLocationImpl stopContextSafely error", (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private final BDLocation transform(Location r4, int r5) {
        if (r4 == null) goto L8;
        BDLocation r0 = new BDLocation(r4, getLocateName());
        r0.setLocationType(r5);
        r0.setLocationMs(System.currentTimeMillis());
        r0.setTrustedLevel(1);
        Bundle r3 = r4.getExtras();
        int r6 = 0;
        if (r3 == null) goto L6;
        r6 = r3.getInt("satellites", 0);
    L6:
        r0.setSatellites(r6);
        return r0;
    L8:
        return null;
    }

    private final void uploadLastLocation() {
        if (this.mLastLocation == null) goto L12;
        BDLocationCallback r0 = this.mCallback;
        if (r0 == null) goto L10;
        LocationOption r1 = this.mOption;
        if (r1 == null) goto L9;
        r1.setEnableUploadNetSignal(true);
    L9:
        Logger.i("uploadLastLocation");
        r0.onLocationChanged(this.mLastLocation);
    L10:
        this.mCallback = (BDLocationCallback) ZeusTransformUtils.preCheckCast(null, BDLocationCallback.class, "com.obric.memorydata.plugin");
        return;
    }

    private final void uploadLastLocationForBusiness(ContinuousLocationContext r3) {
        if (r3.getLastLocation() == null) goto L11;
        BDLocationCallback r2 = r3.getCallback();
        if (r2 == null) goto L12;
        LocationOption r0 = r3.getOption();
        if (r0 == null) goto L9;
        r0.setEnableUploadNetSignal(true);
    L9:
        Logger.i("uploadLastLocationForBusiness");
        r2.onLocationChanged(r3.getLastLocation());
        return;
    L12:
        return;
    }

    private final void uploadMonitor(BDLocation r1, LocationOption r2, String r3, String r4) {
        uploadMonitorLegacy(r1, r2, r3, r4);
    }

    private final void uploadMonitorLegacy(BDLocation r17, LocationOption r18, String r19, String r20) {
        long r11 = SystemClock.elapsedRealtime() - this.mLastLocationStartTime;
        StringBuilder r1 = new StringBuilder().append("uploadMonitorLegacy: ").append(r11).append("ms, provider: ");
        Integer r2 = null;
        if (r17 == null) goto L5;
        String r3 = r17.getProvider();
    L6:
        StringBuilder r4 = r1.append(r3).append(", locationType: ");
        if (r17 == null) goto L9;
        r2 = Integer.valueOf(r17.getLocationType());
    L9:
        Logger.i(r4.append(r2).append(", mIsFirstLocation: ").append(this.mIsFirstLocation).toString());
        String r5 = getLocateName();
        if (r18 == null) goto L12;
        boolean r6 = r18.isChineseRegion();
    L13:
        boolean r8 = r6;
        if (r17 == null) goto L16;
        int r9 = r17.getLocationType();
    L17:
        boolean r13 = this.mIsFirstLocation;
        if (r18 == null) goto L22;
        String r7 = r18.getUploadSource();
        if (r7 == null) goto L22;
    L23:
        LocationMonitor.doContinueLocation(r5, r19, r20, r8, r9, BuildConfig.BDLOCATION_VERSION, r11, r13, r7, null);
        this.mLastLocationStartTime = SystemClock.elapsedRealtime();
        this.mIsFirstLocation = false;
        return;
    L22:
        r7 = "unknown";
        goto L23
    L16:
        r9 = 0;
        goto L17
    L12:
        r6 = true;
        goto L13
    L5:
        r3 = null;
        goto L6
    }

    private final void uploadMonitorMulti(String r20, BDLocation r21, LocationOption r22, String r23, String r24) {
        Object r2 = this.mLock;
        monitor-enter(r2);
        ContinuousLocationContext r3 = (ContinuousLocationContext) ZeusTransformUtils.preCheckCast(this.mContinuousClients.get(r20), ContinuousLocationContext.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        if (r3 == null) goto L28;
        long r14 = SystemClock.elapsedRealtime() - r3.getStartTime();     // Catch: Throwable -> L31
        StringBuilder r4 = new StringBuilder().append("uploadMonitorMulti: ").append(r14).append("ms, provider: ");     // Catch: Throwable -> L31
        Integer r5 = null;
        if (r21 == null) goto L9;
        String r6 = r21.getProvider();     // Catch: Throwable -> L31
    L10:
        StringBuilder r7 = r4.append(r6).append(", locationType: ");     // Catch: Throwable -> L31
        if (r21 == null) goto L13;
        r5 = Integer.valueOf(r21.getLocationType());     // Catch: Throwable -> L31
    L13:
        Logger.i(r7.append(r5).append(", isFirstLocation: ").append(r3.isFirstLocation()).append(", businessId: ").append(r20).toString());     // Catch: Throwable -> L31
        String r8 = getLocateName();     // Catch: Throwable -> L31
        if (r22 == null) goto L16;
        boolean r0 = r22.isChineseRegion();     // Catch: Throwable -> L31
    L17:
        boolean r11 = r0;
        if (r21 == null) goto L20;
        int r12 = r21.getLocationType();     // Catch: Throwable -> L31
    L21:
        boolean r16 = r3.isFirstLocation();     // Catch: Throwable -> L31
        if (r22 == null) goto L26;
        String r1 = r22.getUploadSource();     // Catch: Throwable -> L31
        if (r1 == null) goto L26;
    L27:
        LocationMonitor.doContinueLocation(r8, r23, r24, r11, r12, BuildConfig.BDLOCATION_VERSION, r14, r16, r1, null);     // Catch: Throwable -> L31
        r3.setStartTime(SystemClock.elapsedRealtime());     // Catch: Throwable -> L31
        r3.setFirstLocation(false);     // Catch: Throwable -> L31
    L26:
        r1 = "unknown";
        goto L27
    L20:
        r12 = 0;
        goto L21
    L16:
        r0 = true;
        goto L17
    L9:
        r6 = null;
    L28:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r2);
        return;
    L31:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public float calculateLineDistance(BDPoint r1, BDPoint r2) {
        return -1.0f;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public BDPoint convertGCJ02(BDPoint r1) {
        return null;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public String getLocateName() {
        return LocationInfoConst.BYTE_CONTINUOUS;
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public boolean isAMapDataAvailable(double r1, double r3) {
        return false;
    }

    @Override // com.bytedance.bdlocation.BaseLocate, com.bytedance.bdlocation.api.ILocate
    public void startLocation(BDLocationCallback r4, LocationOption r5, Looper r6) {
        BDLocationCallback r7 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r4, BDLocationCallback.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L5;
        String r0 = r5.getBusinessId();
    L6:
        CharSequence r1 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L9;
    L12:
        boolean r2 = true;
    L13:
        if (r2 == false) goto L16;
        startLocationLegacy(r7, r5, r6);
        return;
    L16:
        startLocationMulti(r0, r7, r5, r6);
        return;
    L9:
        if (r1.length() == 0) goto L12;
        r2 = false;
        goto L13
    L5:
        r0 = null;
        goto L6
    }

    public final void stopAllLocations() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (this.mLocationRunning == false) goto L16;
        a r1 = this.mLocationManager;     // Catch: Throwable -> L19
        if (r1 != null) goto L22;
    L12:
        this.mLocationRunning = false;     // Catch: Throwable -> L19
        this.mLocationManager = (a) ZeusTransformUtils.preCheckCast(null, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L19
        this.mLastSetUploadNetSignalTime = 0;     // Catch: Throwable -> L19
        if (BDLocationConfig.needUploadLastContinuousLocation() == false) goto L15;
        uploadLastLocation();     // Catch: Throwable -> L19
    L15:
        this.mLastLocationStartTime = 0;     // Catch: Throwable -> L19
        goto L16
    L22:
        r1.b();     // Catch: Exception -> L10 Throwable -> L19
    L10:
        e = move-exception;
        Logger.e("stopLocation error: " + e.getMessage());     // Catch: Throwable -> L19
    L16:
        stopAllBusinessLocations();     // Catch: Throwable -> L19
        Logger.i("ByteContinuousLocationImpl stopAllLocations (legacy + all multi business)");     // Catch: Throwable -> L19
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L19
        monitor-exit(r0);
    }

    @Override // com.bytedance.bdlocation.api.ILocate
    public void stopLocation() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (this.mLocationRunning == true) goto L8;
        String r4 = "location is not running, stopLocation is ignored (legacy mode only)";
    L7:
        Logger.i(r4);     // Catch: Throwable -> L21
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r0);
        return;
    L8:
        a r1 = this.mLocationManager;     // Catch: Throwable -> L21
        if (r1 != null) goto L26;
    L14:
        this.mLocationRunning = false;     // Catch: Throwable -> L21
        this.mLocationManager = (a) ZeusTransformUtils.preCheckCast(null, a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        this.mLastSetUploadNetSignalTime = 0;     // Catch: Throwable -> L21
        if (BDLocationConfig.needUploadLastContinuousLocation() == false) goto L17;
        uploadLastLocation();     // Catch: Throwable -> L21
    L17:
        this.mLastLocationStartTime = 0;     // Catch: Throwable -> L21
        r4 = "ByteContinuousLocationImpl stopLocation (legacy mode only)";
        goto L7
    L26:
        r1.b();     // Catch: Exception -> L12 Throwable -> L21
    L12:
        e = move-exception;
        Logger.e("stopLocation error: " + e.getMessage());     // Catch: Throwable -> L21
        goto L14
    }

    @Override // com.bytedance.bdlocation.BaseLocate, com.bytedance.bdlocation.api.ILocate
    public void stopLocationForBusiness(String r5) {
        CharSequence r0 = (CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        Logger.w("ByteContinuousLocationImpl stopLocationForBusiness: businessId is null or empty");
        return;
    L12:
        Object r2 = this.mLock;
        monitor-enter(r2);
        ContinuousLocationContext r3 = (ContinuousLocationContext) ZeusTransformUtils.preCheckCast(this.mContinuousClients.remove(r5), ContinuousLocationContext.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L22
        if (r3 == null) goto L18;
        stopContextSafely(r3, r5);     // Catch: Throwable -> L22
        String r4 = "ByteContinuousLocationImpl stopLocationForBusiness: " + r5 + ", remaining clients: " + this.mContinuousClients.size();     // Catch: Throwable -> L22
    L17:
        Logger.i(r4);     // Catch: Throwable -> L22
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r2);
        return;
    L18:
        r4 = "ByteContinuousLocationImpl stopLocationForBusiness: businessId not found: " + r5;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        throw th;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }
}
