package com.obric.cae;

import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import com.obric.cae.BWDL.BWDLService;
import com.obric.cae.cldReport.CldReportService;
import com.obric.cae.cloud.CloudService;
import com.obric.cae.libs.utils.ManifestUtils;
import com.obric.cae.location.StarLocationService;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.smartBluetooth.SmartBluetoothService;
import com.obric.cae.smartBluetooth.dcf.CaeDcfScanService;
import com.obric.cae.smartNetwork.SmartNetworkService;
import com.obric.cae.smartNfc.SmartNfcService;
import com.obric.cae.statusReport.StatusReportService;
import com.obric.cae.userAware.UserAwareService;
import com.obric.cae.wifi.CaeWifiDatabaseService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class CaeServiceStarter {
    private static final int AWARE_SERVICE = 9;
    private static final int BWDL_SERVICE = 4;
    private static ArrayList<CaeServiceConfig> CAE_SERVICES_AND_FLAG = null;
    private static final int CLD_REPORT = 10;
    private static final int CLOUD_SERVICE = 1;
    private static final int DCF_SCAN = 13;
    private static final int LOCATION_SERVICE = 8;
    private static final int SMART_BLUETOOTH = 3;
    private static final String SMART_BLUETOOTH_SERVICE_NAME = "SmartBluetoothService";
    private static final int SMART_NETWORK = 2;
    private static final int SMART_NFC = 7;
    private static final int STATUS_REPORT = 6;
    private static final String TAG = "CaeServiceStarter";
    private static final int WIFI_DATABASE = 11;
    private static Class[] sCaeServices;

    public static class CaeServiceConfig {
        Class mClass;
        long mMask;
        int mSupported;

        public CaeServiceConfig(Class r8, int r10, long r11) {
            this.mClass = r8;
            this.mSupported = r10;
            this.mMask = r11;
        }
    }

    static {
        sCaeServices = new Class[0];
        CAE_SERVICES_AND_FLAG = new ArrayList(Arrays.asList(new CaeServiceConfig[]{new CaeServiceConfig(CloudService.class, R.bool.cae_supported_cloud_service, 2), new CaeServiceConfig(SmartNetworkService.class, R.bool.cae_supported_smart_network, 4), new CaeServiceConfig(SmartBluetoothService.class, R.bool.cae_supported_smart_bluetooth, 8), new CaeServiceConfig(BWDLService.class, R.bool.cae_supported_BWDL, 16), new CaeServiceConfig(StatusReportService.class, R.bool.cae_supported_status_report, 64), new CaeServiceConfig(SmartNfcService.class, R.bool.cae_supported_smart_nfc, 128), new CaeServiceConfig(StarLocationService.class, R.bool.cae_supported_location_service, 256), new CaeServiceConfig(UserAwareService.class, R.bool.cae_supported_user_aware_service, 512), new CaeServiceConfig(CldReportService.class, R.bool.cae_supported_cld_report, 1024), new CaeServiceConfig(CaeWifiDatabaseService.class, R.bool.cae_supported_wifi_database, 2048), new CaeServiceConfig(CaeDcfScanService.class, R.bool.cae_supported_dcf_scan, 8192)}));
    }

    public CaeServiceStarter() {
    }

    private static void init(Context r8) {
        ArrayList r10 = new ArrayList();
        Iterator<CaeServiceConfig> r11 = CAE_SERVICES_AND_FLAG.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        CaeServiceConfig r12 = r11.next();
        if (r8.getResources().getBoolean(r12.mSupported) == false) goto L4;
        if (r12.mClass == null) goto L4;
        CommSenseLog.i(TAG, "new add ".concat(r12.mClass.getSimpleName()));
        r10.add(r12.mClass);
        goto L4
    L10:
        sCaeServices = (Class[]) r10.toArray(new Class[r10.size()]);
    }

    public static void startCaeServices(Context r10) {
        CommSenseLog.i(TAG, "startCaeServices");
        init(r10);
        Class[] r8 = sCaeServices;
        int r11 = r8.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L9;
        Class r13 = r8[r12];
        String r14 = r13.getSimpleName();
        boolean r15 = ManifestUtils.isServiceSingleUser(r10, r13);
        CommSenseLog.d(TAG, "service: " + r14 + ", isSingleUser: " + r15);
        Intent r16 = new Intent(r10, r13);
        r16.addFlags(268435456);
        if (r15 == false) goto L7;
        UserHandle r17 = UserHandle.SYSTEM;
    L8:
        r10.startServiceAsUser(r16, r17);
        r12 = r12 + 1;
        goto L3
    L7:
        r17 = UserHandle.CURRENT;
        goto L8
    }
}
