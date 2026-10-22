package com.bytedance.bdlocation.scan.strategy;

import com.bytedance.bdlocation.LocationUtil;
import com.bytedance.bdlocation.client.BDLocationConfig;
import com.bytedance.bdlocation.log.Logger;
import com.bytedance.bdlocation.network.model.DeviceLocation;
import com.bytedance.bdlocation.network.model.DeviceStatus;
import com.bytedance.bdlocation.network.model.LocationUploadExtra;
import com.bytedance.bdlocation.network.response.LocInfoRspData;
import com.bytedance.bdlocation.network.response.LocationResp;
import com.bytedance.bdlocation.scan.wifi.WifiInfoManager;
import com.bytedance.bdlocation.service.BDLocationExtrasService;
import com.bytedance.bdlocation.thread.AppExecutors;
import com.bytedance.common.wschannel.WsConstants;
import he.i;

/* JADX INFO: loaded from: classes.dex */
public final class ScanWifiStrategy {
    public static final ScanWifiStrategy INSTANCE = null;
    private static final String tag = "[ScanWifiStrategy] ";

    /* JADX INFO: renamed from: com.bytedance.bdlocation.scan.strategy.ScanWifiStrategy$checkScanWifiStrategy$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        final /* synthetic */ DeviceLocation $deviceLocation;
        final /* synthetic */ DeviceStatus $deviceStatus;
        final /* synthetic */ LocationUploadExtra $extra;
        final /* synthetic */ LocationResp $locInfoRsp;

        public AnonymousClass1(LocationResp r8, DeviceLocation r10, DeviceStatus r11, LocationUploadExtra r12) {
            this.$locInfoRsp = r8;
            this.$deviceLocation = r10;
            this.$deviceStatus = r11;
            this.$extra = r12;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.$locInfoRsp != null) goto L7;
            Logger.i(ScanWifiStrategy.access$getTag$p(ScanWifiStrategy.INSTANCE) + "loc info resp is null, don't rescan");
            return;
        L7:
            if (BDLocationConfig.initIfNeed() == true) goto L9;
        L22:
            Logger.i(ScanWifiStrategy.access$getTag$p(ScanWifiStrategy.INSTANCE) + "bdlocation config no init or rescan count <= 0");
            return;
        L9:
            if (BDLocationConfig.rescanWifiCount() <= 0) goto L22;
            LocInfoRspData r8 = LocationUtil.parseLocInfoRsp(this.$locInfoRsp);
            if (r8 != null) goto L14;
        L20:
            Logger.i(ScanWifiStrategy.access$getTag$p(ScanWifiStrategy.INSTANCE) + "loc info resp data is null or wifirescan <= 0 && enbale rescan wifi is false");
            return;
        L14:
            if (r8.isWifiRescan <= 0) goto L16;
        L18:
            Logger.i(ScanWifiStrategy.access$getTag$p(ScanWifiStrategy.INSTANCE) + "wifi strategy is " + r8.isWifiRescan);
            new WifiInfoManager().getWifiScanInfos(BDLocationConfig.getContext(), new ScanWifiStrategy$checkScanWifiStrategy$1$wifiInfoCallback$1(this), BDLocationExtrasService.getBPEAManager().getBpeaCert("bpea-location_sdk_rescan_wifi"), null);
            return;
        L16:
            if (BDLocationConfig.enableRescanWifi() == true) goto L18;
            goto L18
        }
    }

    static {
        INSTANCE = new ScanWifiStrategy();
        tag = "[ScanWifiStrategy] ";
    }

    private ScanWifiStrategy() {
    }

    public static final /* synthetic */ String access$getTag$p(ScanWifiStrategy r8) {
        return tag;
    }

    public final void checkScanWifiStrategy(LocationResp r8, DeviceLocation r10, DeviceStatus r11, LocationUploadExtra r12) {
        i.g(r10, "deviceLocation");
        i.g(r11, "deviceStatus");
        i.g(r12, WsConstants.KEY_EXTRA);
        AppExecutors.getInstance().networkIO().execute(new AnonymousClass1(r8, r10, r11, r12));
    }
}
