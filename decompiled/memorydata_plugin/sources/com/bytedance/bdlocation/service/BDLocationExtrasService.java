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
import com.volcengine.zeus.transform.ZeusTransformUtils;

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
        sAmapLocate = (BaseLocate) ZeusTransformUtils.preCheckCast(getLocalManager(AMAP_CLASS_NAME), BaseLocate.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        BaseLocate r1 = sAmapLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    public static IBPEALocal getBPEAManager() {
        IBPEALocal r0 = sBPEAManager;
        if (r0 == null) goto L6;
        return r0;
    L6:
        monitor-enter(BDLocationExtrasService.class);
    L18:
        th = move-exception;
        throw th;
    L8:
        if (sBPEAManager != null) goto L13;
        if (BDLocationConfig.enableBpea() == false) goto L13;
        sBPEAManager = (IBPEALocal) ZeusTransformUtils.preCheckCast(getLocalManager(BPEA_CLASS_NAME), IBPEALocal.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L18
    L13:
        if (sBPEAManager != null) goto L15;
        sBPEAManager = new DefaultBpeaProvider();     // Catch: Throwable -> L18
    L15:
        IBPEALocal r1 = sBPEAManager;     // Catch: Throwable -> L18
        monitor-exit(BDLocationExtrasService.class);     // Catch: Throwable -> L18
        return r1;
    }

    public static IBPEALocal getBPEAManagerWithTag(boolean r0) {
        if (r0 == false) goto L6;
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
        sBeaconManager = (IBeaconManager) ZeusTransformUtils.preCheckCast(getLocalManager(BEACON_CLASS_NAME), IBeaconManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
    L8:
        if (sBeaconManager != null) goto L10;
        sBeaconManager = new DefaultBeaconProvider();     // Catch: Throwable -> L13
    L10:
        IBeaconManager r1 = sBeaconManager;     // Catch: Throwable -> L13
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    private static synchronized BaseLocate getByteContinuousLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sByteContinuousLocate != null) goto L7;
        sByteContinuousLocate = (BaseLocate) ZeusTransformUtils.preCheckCast(getLocalManager(BYTE_CONTINUOUS_CLASS_NAME), BaseLocate.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        BaseLocate r1 = sByteContinuousLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    private static synchronized BaseLocate getByteLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sByteLocate != null) goto L7;
        sByteLocate = (BaseLocate) ZeusTransformUtils.preCheckCast(getLocalManager(BYTE_CLASS_NAME), BaseLocate.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        BaseLocate r1 = sByteLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    private static synchronized BaseLocate getGmapLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sGmapLocate != null) goto L7;
        sGmapLocate = (BaseLocate) ZeusTransformUtils.preCheckCast(getLocalManager(GMAP_CLASS_NAME), BaseLocate.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        BaseLocate r1 = sGmapLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    private static IManager getLocalManager(String r7) {
        IManager r1 = null;
        IManager r0 = (IManager) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.forName(r7, "com.obric.memorydata.plugin").getConstructor(new Class[]{Context.class}).newInstance(new Object[]{(Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(BDLocationConfig.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")}), IManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
        Logger.d("getLocalManager:" + r7);     // Catch: Throwable -> L6
        return r0;
    L6:
        th = th;
        r1 = r0;
    L9:
        Logger.i("BDLocationExtrasService getLocalManager error：" + th.toString());
        return r1;
    L8:
        th = th;
        goto L9
    }

    public static synchronized BaseLocate getLocate(Context r3, int r4) {
        monitor-enter(BDLocationExtrasService.class);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        BaseLocate r1 = null;
        switch(r4) {
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            default: goto L14;
        };     // Catch: Throwable -> L16
    L7:
        r1 = getByteContinuousLocate();     // Catch: Throwable -> L16
        goto L14
    L8:
        r1 = getTmapLocate();     // Catch: Throwable -> L16
        goto L14
    L9:
        r1 = getMockLocate();     // Catch: Throwable -> L16
        goto L14
    L10:
        r1 = getByteLocate();     // Catch: Throwable -> L16
        goto L14
    L11:
        r1 = getGmapLocate();     // Catch: Throwable -> L16
        goto L14
    L12:
        r1 = getAmapLocate();     // Catch: Throwable -> L16
        goto L14
    L13:
        r1 = getSysLocate(r5);     // Catch: Throwable -> L16
    L14:
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    L16:
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
        sMockLocate = (BaseLocate) ZeusTransformUtils.preCheckCast(getLocalManager(MOCK_CLASS_NAME), BaseLocate.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        BaseLocate r1 = sMockLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    public static ILocate getNewAMapLocate() {
        return (ILocate) ZeusTransformUtils.preCheckCast(getLocalManager(AMAP_CLASS_NAME), ILocate.class, "com.obric.memorydata.plugin");
    }

    public static synchronized IRegionDataCore getRegionDataCore() {
        monitor-enter(BDLocationExtrasService.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sIRegionDataCore != null) goto L8;
        sIRegionDataCore = (IRegionDataCore) ZeusTransformUtils.preCheckCast(getLocalManager(REGION_DATA_CLASS_NAME), IRegionDataCore.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
    L8:
        if (sIRegionDataCore != null) goto L10;
        sIRegionDataCore = new DefaultRegionDataCore();     // Catch: Throwable -> L13
    L10:
        IRegionDataCore r1 = sIRegionDataCore;     // Catch: Throwable -> L13
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    public static synchronized IShakeManager getShakeManager() {
        monitor-enter(BDLocationExtrasService.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sShakeManager != null) goto L8;
        sShakeManager = (IShakeManager) ZeusTransformUtils.preCheckCast(getLocalManager(SHAKE_CLASS_NAME), IShakeManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
    L8:
        if (sShakeManager != null) goto L10;
        sShakeManager = new DefaultShakeProvider();     // Catch: Throwable -> L13
    L10:
        IShakeManager r1 = sShakeManager;     // Catch: Throwable -> L13
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    private static synchronized BaseLocate getSysLocate(Context r3) {
        monitor-enter(BDLocationExtrasService.class);
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (sSysLocate != null) goto L7;
        sSysLocate = new SystemBaseLocationImpl(r4);     // Catch: Throwable -> L10
    L7:
        BaseLocate r5 = sSysLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r5;
    L10:
        th = move-exception;
        throw th;
    }

    private static synchronized BaseLocate getTmapLocate() {
        monitor-enter(BDLocationExtrasService.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sTmapLocate != null) goto L7;
        sTmapLocate = (BaseLocate) ZeusTransformUtils.preCheckCast(getLocalManager(TMAP_CLASS_NAME), BaseLocate.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        BaseLocate r1 = sTmapLocate;     // Catch: Throwable -> L10
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    public static synchronized ITraceRouteManager getTraceRouteManager() {
        monitor-enter(BDLocationExtrasService.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sTraceRouteManager != null) goto L8;
        sTraceRouteManager = (ITraceRouteManager) ZeusTransformUtils.preCheckCast(getLocalManager(TRACEROUTE_CLASS_NAME), ITraceRouteManager.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
    L8:
        if (sTraceRouteManager != null) goto L10;
        sTraceRouteManager = new DefaultTraceRouteProvider();     // Catch: Throwable -> L13
    L10:
        ITraceRouteManager r1 = sTraceRouteManager;     // Catch: Throwable -> L13
        monitor-exit(BDLocationExtrasService.class);
        return r1;
    }

    private static void setAmapLocate(BaseLocate r0) {
        sAmapLocate = r0;
    }

    private static void setByteLocate(BaseLocate r0) {
        sByteLocate = r0;
    }

    private static void setGmapLocate(BaseLocate r0) {
        sGmapLocate = r0;
    }

    public static void setShakeManager(IShakeManager r2) {
        sShakeManager = (IShakeManager) ZeusTransformUtils.wrapperContextForParams(r2, IShakeManager.class, "com.obric.memorydata.plugin");
    }
}
