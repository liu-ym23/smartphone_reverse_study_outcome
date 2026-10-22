package com.bytedance.applog.map.api;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b4\u0018\u00002\u00020\u0001:\u0006XYZ[\\]Bÿ\u0001\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u0003\u0012\u0006\u0010\u001b\u001a\u00020\r\u0012\u0006\u0010\u001c\u001a\u00020\r\u0012\u0006\u0010\u001d\u001a\u00020\u0003\u0012\u0006\u0010\u001e\u001a\u00020\r\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\u0010!\u001a\u0004\u0018\u00010\"\u0012\b\u0010#\u001a\u0004\u0018\u00010$\u0012\u0006\u0010%\u001a\u00020\r\u0012\u0006\u0010&\u001a\u00020\u0013\u0012\u0006\u0010'\u001a\u00020\r\u0012\u0006\u0010(\u001a\u00020\u0013\u0012\u0006\u0010)\u001a\u00020*\u0012\u0006\u0010+\u001a\u00020\u0013¢\u0006\u0002\u0010,J\b\u0010W\u001a\u00020\u0005H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0011\u0010&\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010%\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0016\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b6\u00105R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u0011\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b9\u00105R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0011\u0010\u001e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b<\u00105R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b=\u00105R\u0011\u0010\u001c\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b>\u00105R\u0011\u0010+\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b?\u00103R\u0011\u0010\u001d\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010.R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0013\u0010#\u001a\u0004\u0018\u00010$¢\u0006\b\n\u0000\u001a\u0004\bC\u0010DR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bE\u00100R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bF\u00103R\u0011\u0010\u001b\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bG\u00105R\u0011\u0010\u0017\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bH\u00105R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\bK\u00100R\u0011\u0010\u001a\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bL\u0010.R\u0011\u0010)\u001a\u00020*¢\u0006\b\n\u0000\u001a\u0004\bM\u0010NR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0011\u0010'\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bQ\u00105R\u0011\u0010(\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\bR\u00103R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bS\u0010.R\u0013\u0010!\u001a\u0004\u0018\u00010\"¢\u0006\b\n\u0000\u001a\u0004\bT\u0010UR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bV\u0010.¨\u0006^"}, d2 = {"Lcom/bytedance/applog/map/api/MapConfig;", "", "aid", "", "os", "", "appName", "appVersion", "versionCode", "updateVersionCode", "mode", "Lcom/bytedance/applog/map/api/MapMode;", "logEnabled", "", "serverDomain", "httpClient", "Lcom/bytedance/applog/map/api/IMapNetworkClient;", "gzipEnabled", "reportInterval", "", "fragmentAsPageRatio", "", "floatButtonEnabled", "screenCaptureEnabled", "screenCaptureMethod", "Lcom/bytedance/applog/map/api/MapConfig$MapScreenCaptureMethod;", "snapshotQuality", "screenCaptureAsync", "mapInfoWithSnapshot", "maxReferFieldSize", "lightRefer", "triggerConfig", "Lcom/bytedance/applog/map/api/MapConfig$MapTriggerConfig;", "userInfoProvider", "Lcom/bytedance/applog/map/api/UserInfoProvider;", CommonConsts.LOG_REPORT_TYPE_DEFAULT, "Lcom/bytedance/applog/map/api/IMapMonitor;", "clickViewCacheable", "clickViewCacheDuration", "updateUuidAfterClick", "updateUuidAfterClickDelay", "surfaceViewCaptureConfig", "Lcom/bytedance/applog/map/api/MapConfig$SurfaceViewCaptureConfig;", "maxBitmapMemCacheSize", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IILcom/bytedance/applog/map/api/MapMode;ZLjava/lang/String;Lcom/bytedance/applog/map/api/IMapNetworkClient;ZJFZZLcom/bytedance/applog/map/api/MapConfig$MapScreenCaptureMethod;IZZIZLcom/bytedance/applog/map/api/MapConfig$MapTriggerConfig;Lcom/bytedance/applog/map/api/UserInfoProvider;Lcom/bytedance/applog/map/api/IMapMonitor;ZJZJLcom/bytedance/applog/map/api/MapConfig$SurfaceViewCaptureConfig;J)V", "getAid", "()I", "getAppName", "()Ljava/lang/String;", "getAppVersion", "getClickViewCacheDuration", "()J", "getClickViewCacheable", "()Z", "getFloatButtonEnabled", "getFragmentAsPageRatio", "()F", "getGzipEnabled", "getHttpClient", "()Lcom/bytedance/applog/map/api/IMapNetworkClient;", "getLightRefer", "getLogEnabled", "getMapInfoWithSnapshot", "getMaxBitmapMemCacheSize", "getMaxReferFieldSize", "getMode", "()Lcom/bytedance/applog/map/api/MapMode;", "getMonitor", "()Lcom/bytedance/applog/map/api/IMapMonitor;", "getOs", "getReportInterval", "getScreenCaptureAsync", "getScreenCaptureEnabled", "getScreenCaptureMethod", "()Lcom/bytedance/applog/map/api/MapConfig$MapScreenCaptureMethod;", "getServerDomain", "getSnapshotQuality", "getSurfaceViewCaptureConfig", "()Lcom/bytedance/applog/map/api/MapConfig$SurfaceViewCaptureConfig;", "getTriggerConfig", "()Lcom/bytedance/applog/map/api/MapConfig$MapTriggerConfig;", "getUpdateUuidAfterClick", "getUpdateUuidAfterClickDelay", "getUpdateVersionCode", "getUserInfoProvider", "()Lcom/bytedance/applog/map/api/UserInfoProvider;", "getVersionCode", "toString", "Builder", "MapScreenCaptureMethod", "MapTriggerConfig", "MapTriggerConfigBuilder", "SurfaceViewCaptureConfig", "SurfaceViewCaptureConfigBuilder", "map-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MapConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f1660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f1661b;
    private final boolean c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/applog/map/api/MapConfig$MapScreenCaptureMethod;", "", "(Ljava/lang/String;I)V", "Canvas", "PixCopy", "map-api_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final enum MapScreenCaptureMethod extends Enum<MapScreenCaptureMethod> {
        private static final /* synthetic */ MapScreenCaptureMethod[] $VALUES = null;
        public static final MapScreenCaptureMethod Canvas = null;
        public static final MapScreenCaptureMethod PixCopy = null;

        private static final /* synthetic */ MapScreenCaptureMethod[] $values() {
            return new MapScreenCaptureMethod[]{Canvas, PixCopy};
        }

        static {
            Canvas = new MapScreenCaptureMethod("Canvas", 0);
            PixCopy = new MapScreenCaptureMethod("PixCopy", 1);
            $VALUES = $values();
        }

        private MapScreenCaptureMethod(String r1, int r2) {
            super(r1, r2);
        }

        public static MapScreenCaptureMethod valueOf(String r2) {
            return (MapScreenCaptureMethod) ZeusTransformUtils.preCheckCast(Enum.valueOf(MapScreenCaptureMethod.class, r2), MapScreenCaptureMethod.class, "com.obric.memorydata.plugin");
        }

        public static MapScreenCaptureMethod[] values() {
            return (MapScreenCaptureMethod[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), MapScreenCaptureMethod[].class, "com.obric.memorydata.plugin");
        }
    }

    public String toString() {
        return "MapConfig[aid:" + this.f1660a + ", version:" + this.f1661b + ", log:" + this.c + ']';
    }
}
