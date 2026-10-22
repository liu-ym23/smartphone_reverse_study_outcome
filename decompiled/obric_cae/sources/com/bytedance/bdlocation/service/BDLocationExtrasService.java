package com.bytedance.bdlocation.service;

import android.content.Context;
import com.bytedance.bdlocation.BaseLocate;
import com.bytedance.bdlocation.api.IBPEALocal;
import com.bytedance.bdlocation.api.IBeaconManager;
import com.bytedance.bdlocation.api.ILocate;
import com.bytedance.bdlocation.api.IManager;
import com.bytedance.bdlocation.api.IRegionDataCore;
import com.bytedance.bdlocation.api.IShakeManager;
import com.bytedance.bdlocation.api.ITraceRouteManager;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.provider.DefaultBeaconProvider;
import com.bytedance.bdlocation.provider.DefaultBpeaProvider;
import com.bytedance.bdlocation.provider.DefaultRegionDataCore;
import com.bytedance.bdlocation.provider.DefaultShakeProvider;
import com.bytedance.bdlocation.provider.DefaultTraceRouteProvider;

/* JADX INFO: loaded from: classes.dex */
public class BDLocationExtrasService {
    private static final String AMAP_CLASS_NAME = "com.bytedance.bdlocation.amap.AMapLocationImpl";
    private static final String BEACON_CLASS_NAME = "com.bytedance.byte_beacon.BeaconManagerImpl";
    private static final String BPEA_CLASS_NAME = "com.bytedance.location_bpea.BPEAManager";
    private static final String BYTE_CLASS_NAME = "com.bytedance.bdlocation.bytelocation.ByteLocationImpl";
    private static final String BYTE_CONTINUOUS_CLASS_NAME = "com.bytedance.bdlocation.bytelocation.ByteContinuousLocationImpl";
    private static final String GMAP_CLASS_NAME = "com.bytedance.bdlocation.glocation.GoogleLocationImpl";
    private static final String H3CORE_CLASS_NAME = "com.uber.h3core.BDLocationH3Core";
    private static final String MOCK_CLASS_NAME = "com.bytedance.bdlocation.locationmock.MockLocationImpl";
    private static final String REGION_DATA_CLASS_NAME = "com.bytedance.region_data.RegionDataCore";
    private static final String SHAKE_CLASS_NAME = "com.bytedance.bdlocation_impl.shake.ShakeManager";
    private static final String TMAP_CLASS_NAME = "com.bytedance.bdlocation.tencent.TencentLocationImpl";
    private static final String TRACEROUTE_CLASS_NAME = "com.bytedance.bdlocation.traceroute.TraceRouterCore";
    private static BaseLocate sAmapLocate;
    private static volatile IBPEALocal sBPEAManager;
    private static IBeaconManager sBeaconManager;
    private static BaseLocate sByteContinuousLocate;
    private static BaseLocate sByteLocate;
    private static BaseLocate sGmapLocate;
    private static IRegionDataCore sIRegionDataCore;
    private static BaseLocate sMockLocate;
    private static IShakeManager sShakeManager;
    private static BaseLocate sSysLocate;
    private static BaseLocate sTmapLocate;
    private static ITraceRouteManager sTraceRouteManager;

    public BDLocationExtrasService() {
    }

    private static synchronized BaseLocate getAmapLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sAmapLocate != null) goto L7;
        sAmapLocate = (BaseLocate) getLocalManager(AMAP_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        BaseLocate r8 = sAmapLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r8;
    }

    public static IBPEALocal getBPEAManager() {
        IBPEALocal r8 = sBPEAManager;
        if (r8 == null) goto L6;
        return r8;
    L6:
        monitor-enter(BDLocationExtrasService.class);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (sBPEAManager != null) goto L13;
        if (BDLocationConfig.enableBpea() == false) goto L13;
        sBPEAManager = (IBPEALocal) getLocalManager(BPEA_CLASS_NAME);     // Catch: Throwable -> L18
    L13:
        if (sBPEAManager != null) goto L15;
        sBPEAManager = new DefaultBpeaProvider();     // Catch: Throwable -> L18
    L15:
        IBPEALocal r10 = sBPEAManager;     // Catch: Throwable -> L18
        monitor-exit(BDLocationExtrasService.class);     // Catch: Throwable -> L18
        return r10;
    }

    public static IBPEALocal getBPEAManagerWithTag(boolean r8) {
        if (r8 == false) goto L6;
        return new DefaultBpeaProvider();
    L6:
        return getBPEAManager();
    }

    public static synchronized IBeaconManager getBeaconManager() {
        monitor-enter(BDLocationExtrasService.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sBeaconManager != null) goto L8;
        sBeaconManager = (IBeaconManager) getLocalManager(BEACON_CLASS_NAME);     // Catch: Throwable -> L13
    L8:
        if (sBeaconManager != null) goto L10;
        sBeaconManager = new DefaultBeaconProvider();     // Catch: Throwable -> L13
    L10:
        IBeaconManager r8 = sBeaconManager;     // Catch: Throwable -> L13
        monitor-exit(BDLocationExtrasService.class);
        return r8;
    }

    private static synchronized BaseLocate getByteContinuousLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sByteContinuousLocate != null) goto L7;
        sByteContinuousLocate = (BaseLocate) getLocalManager(BYTE_CONTINUOUS_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        BaseLocate r8 = sByteContinuousLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r8;
    }

    private static synchronized BaseLocate getByteLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sByteLocate != null) goto L7;
        sByteLocate = (BaseLocate) getLocalManager(BYTE_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        BaseLocate r8 = sByteLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r8;
    }

    private static synchronized BaseLocate getGmapLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sGmapLocate != null) goto L7;
        sGmapLocate = (BaseLocate) getLocalManager(GMAP_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        BaseLocate r8 = sGmapLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r8;
    }

    private static IManager getLocalManager(String r8) {
        IManager r10 = null;
        IManager r11 = (IManager) Class.forName(r8).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{BDLocationConfig.getContext()});     // Catch: Throwable -> L8
        Logger.d("getLocalManager:" + r8);     // Catch: Throwable -> L6
        return r11;
    L6:
        th = th;
        r10 = r11;
    L9:
        Logger.i("BDLocationExtrasService getLocalManager error：" + th.toString());
        return r10;
    L8:
        th = th;
        goto L9
    }

    public static synchronized BaseLocate getLocate(Context r8, int r10) {
        monitor-enter(BDLocationExtrasService.class);
        switch(r10) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L5:
        BaseLocate r11 = null;
    L17:
        monitor-exit(BDLocationExtrasService.class);
        return r11;
    L6:
        r11 = getByteContinuousLocate();     // Catch: Throwable -> L14
    L19:
        goto L17
    L7:
        r11 = getTmapLocate();     // Catch: Throwable -> L14
        goto L19
    L8:
        r11 = getMockLocate();     // Catch: Throwable -> L14
        goto L19
    L9:
        r11 = getByteLocate();     // Catch: Throwable -> L14
        goto L19
    L10:
        r11 = getGmapLocate();     // Catch: Throwable -> L14
        goto L19
    L11:
        r11 = getAmapLocate();     // Catch: Throwable -> L14
        goto L19
    L12:
        r11 = getSysLocate(r8);     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    private static synchronized BaseLocate getMockLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sMockLocate != null) goto L7;
        sMockLocate = (BaseLocate) getLocalManager(MOCK_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        BaseLocate r8 = sMockLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r8;
    }

    public static ILocate getNewAMapLocate() {
        return (ILocate) getLocalManager(AMAP_CLASS_NAME);
    }

    public static synchronized IRegionDataCore getRegionDataCore() {
        monitor-enter(BDLocationExtrasService.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sIRegionDataCore != null) goto L8;
        sIRegionDataCore = (IRegionDataCore) getLocalManager(REGION_DATA_CLASS_NAME);     // Catch: Throwable -> L13
    L8:
        if (sIRegionDataCore != null) goto L10;
        sIRegionDataCore = new DefaultRegionDataCore();     // Catch: Throwable -> L13
    L10:
        IRegionDataCore r8 = sIRegionDataCore;     // Catch: Throwable -> L13
        monitor-exit(BDLocationExtrasService.class);
        return r8;
    }

    public static synchronized IShakeManager getShakeManager() {
        monitor-enter(BDLocationExtrasService.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sShakeManager != null) goto L8;
        sShakeManager = (IShakeManager) getLocalManager(SHAKE_CLASS_NAME);     // Catch: Throwable -> L13
    L8:
        if (sShakeManager != null) goto L10;
        sShakeManager = new DefaultShakeProvider();     // Catch: Throwable -> L13
    L10:
        IShakeManager r8 = sShakeManager;     // Catch: Throwable -> L13
        monitor-exit(BDLocationExtrasService.class);
        return r8;
    }

    private static synchronized BaseLocate getSysLocate(Context r8) {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sSysLocate != null) goto L7;
        sSysLocate = new SystemBaseLocationImpl(r8);     // Catch: Throwable -> L10
    L7:
        BaseLocate r10 = sSysLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r10;
    }

    private static synchronized BaseLocate getTmapLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sTmapLocate != null) goto L7;
        sTmapLocate = (BaseLocate) getLocalManager(TMAP_CLASS_NAME);     // Catch: Throwable -> L10
    L7:
        BaseLocate r8 = sTmapLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r8;
    }

    public static synchronized ITraceRouteManager getTraceRouteManager() {
        monitor-enter(BDLocationExtrasService.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sTraceRouteManager != null) goto L8;
        sTraceRouteManager = (ITraceRouteManager) getLocalManager(TRACEROUTE_CLASS_NAME);     // Catch: Throwable -> L13
    L8:
        if (sTraceRouteManager != null) goto L10;
        sTraceRouteManager = new DefaultTraceRouteProvider();     // Catch: Throwable -> L13
    L10:
        ITraceRouteManager r8 = sTraceRouteManager;     // Catch: Throwable -> L13
        monitor-exit(BDLocationExtrasService.class);
        return r8;
    }

    private static void setAmapLocate(BaseLocate r8) {
        sAmapLocate = r8;
    }

    private static void setByteLocate(BaseLocate r8) {
        sByteLocate = r8;
    }

    private static void setGmapLocate(BaseLocate r8) {
        sGmapLocate = r8;
    }

    public static void setShakeManager(IShakeManager r8) {
        sShakeManager = r8;
    }
}
