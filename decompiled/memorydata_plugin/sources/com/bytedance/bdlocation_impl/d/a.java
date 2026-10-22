package com.bytedance.bdlocation_impl.d;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.client.LocationOption;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.monitor.LocationTraceLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
public class a {
    public static BDLocation a(LocationOption r2) {
        LocationTraceLogger r0 = new LocationTraceLogger();
        r0.begin("total_duration");
        r0.begin(LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);
        r2.setLocationTraceLogger(r0);
        LBSLightLocationTraceLogger r1 = new LBSLightLocationTraceLogger();
        r1.begin(LBSLightLocationTraceLogger.TOTAL);
        r1.begin(LBSLightLocationTraceLogger.PREPARE);
        r2.setLBSLightLocationTraceLogger(r1);
        return com.bytedance.bdlocation_impl.c.a.a().a(r2);
    }

    public static void a(LocationOption r2, BDLocationCallback r3) {
        final BDLocationCallback r4 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r3, BDLocationCallback.class, "com.obric.memorydata.plugin");
        LocationTraceLogger r0 = new LocationTraceLogger();
        r0.begin("total_duration");
        r0.begin(LocationMonitorConst.LOCATION_RULE_CHECK_DURATION);
        r2.setLocationTraceLogger(r0);
        LBSLightLocationTraceLogger r1 = new LBSLightLocationTraceLogger();
        r1.begin(LBSLightLocationTraceLogger.TOTAL);
        r1.begin(LBSLightLocationTraceLogger.PREPARE);
        r2.setLBSLightLocationTraceLogger(r1);
        com.bytedance.bdlocation_impl.c.a.a().a(new AnonymousClass1(r4), r2);
    }

    public static void a(String r2, int r3, boolean r4, long r5, long r7, BDLocationCallback r9, Object r10) {
        BDLocationCallback r11 = (BDLocationCallback) ZeusTransformUtils.wrapperContextForParams(r9, BDLocationCallback.class, "com.obric.memorydata.plugin");
        LocationOption r0 = new LocationOption();
        r0.setUploadSource(r2);
        r0.setMaxCacheTime(r7);
        r0.setTriggerType(r3);
        r0.setUpload(r4);
        r0.setLocationTimeOutMs(r5);
        r0.setLocateType(BDLocationConfig.getLocateType());
        r0.setBpeaCert(r10);
        r0.setBpeaAction("getLocation");
        a(r0, r11);
    }
}
