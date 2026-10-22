package com.obric.cae.userAware;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiScanner;
import com.obric.cae.log.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;

/* JADX INFO: loaded from: classes3.dex */
final class CommSenseScanTuningMarker {
    private static final byte FLAG_ENABLED = 1;
    private static final byte MARKER_TYPE = 83;
    private static final byte MARKER_VERSION = 1;
    private static final byte OUI_0 = 0;
    private static final byte OUI_1 = 19;
    private static final byte OUI_2 = 118;
    private static final int PAYLOAD_LEN = 48;
    private static final String TAG = "CommSenseScanTuningMarker";
    private static final int VENDOR_IE_ID = 221;

    private CommSenseScanTuningMarker() {
    }

    public static void attach(WifiScanner.ScanSettings r4, CommSenseScanTuningConfig r5) {
        WifiScanner.ScanSettings r6 = (WifiScanner.ScanSettings) ZeusTransformUtils.wrapperContextForParams(r4, WifiScanner.ScanSettings.class, "com.obric.memorydata.plugin");
        if (r6 == null) goto L12;
        if (r5 == null) goto L13;
        r6.setVendorIes(Collections.singletonList(new ScanResult.InformationElement(VENDOR_IE_ID, 0, buildPayload(r5))));     // Catch: Throwable -> L8
        a.e(TAG, "Attached scan tuning marker");     // Catch: Throwable -> L8
        return;
    L8:
        a.g(TAG, "Failed to attach scan tuning marker");
        return;
    L13:
        return;
    }

    private static byte[] buildPayload(CommSenseScanTuningConfig r5) {
        byte[] r0 = new byte[48];
        r0[0] = 0;
        r0[1] = OUI_1;
        r0[2] = OUI_2;
        r0[3] = MARKER_TYPE;
        r0[4] = 1;
        r0[5] = 1;
        r0[6] = 0;
        r0[7] = 0;
        writeProfile(r0, writeProfile(r0, 8, r5.dbsProfile), r5.nonDbsProfile);
        return r0;
    }

    private static int putLe16(byte[] r2, int r3, int r4) {
        int r0 = r3 + 1;
        r2[r3] = (byte) (r4 & 255);
        int r5 = r0 + 1;
        r2[r0] = (byte) ((r4 >> 8) & 255);
        return r5;
    }

    private static int writeProfile(byte[] r2, int r3, CommSenseScanTuningConfig.Profile r4) {
        int r5 = putLe16(r2, putLe16(r2, putLe16(r2, putLe16(r2, putLe16(r2, putLe16(r2, putLe16(r2, putLe16(r2, putLe16(r2, r3, r4.activeDwellMs), r4.activeDwell2gMs), r4.connectedActiveDwellMs), r4.connectedActiveDwell2gMs), r4.passiveDwellMs), r4.minRestMs), r4.maxRestMs), r4.idleMs), r4.burstDurationMs);
        int r0 = r5 + 1;
        r2[r5] = (byte) (r4.adaptiveDwellMode & 255);
        int r6 = r0 + 1;
        r2[r0] = (byte) (r4.probeCount & 255);
        return r6;
    }
}
