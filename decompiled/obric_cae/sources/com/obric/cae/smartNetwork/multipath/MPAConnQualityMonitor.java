package com.obric.cae.smartNetwork.multipath;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class MPAConnQualityMonitor {
    public static final int ONLY_CELL_WHEN_DUAL = 2;
    public static final int ONLY_WIFI_WHEN_DUAL = 1;
    private static final String TAG = "MPAConnQualityMonitor";
    public static final int WIFI_AND_CELL_WHEN_DUAL = 3;
    private Set<MPAConnectionQualityCallback> mMPAConnectionQualityCallbackSet;

    public interface MPAConnectionQualityCallback {
        void onCellularMPAConnQualityReport(MPAConnQuality r8);

        void onPathCtlModeChanged(String r8, int r10);

        void onWiFiMPAConnQualityReport(MPAConnQuality r8);
    }

    public MPAConnQualityMonitor() {
        this.mMPAConnectionQualityCallbackSet = Collections.synchronizedSet(new HashSet());
    }

    public void registerMPAConnectionQualityCallback(MPAConnectionQualityCallback r8) {
        this.mMPAConnectionQualityCallbackSet.add(r8);
    }

    public void reportMPAConnectionQuality(MPAConnQuality r8) {
        Set<MPAConnectionQualityCallback> r10 = this.mMPAConnectionQualityCallbackSet;
        monitor-enter(r10);
        Iterator<MPAConnectionQualityCallback> r11 = this.mMPAConnectionQualityCallbackSet.iterator();     // Catch: Throwable -> L15
    L6:
        if (r11.hasNext() == false) goto L13;
        MPAConnectionQualityCallback r12 = r11.next();     // Catch: Throwable -> L15
        if (r8.getConnType() == 0) goto L9;
        if (r8.getConnType() != 1) goto L6;
        r12.onCellularMPAConnQualityReport(r8);     // Catch: Throwable -> L15
        goto L6
    L9:
        r12.onWiFiMPAConnQualityReport(r8);     // Catch: Throwable -> L15
        goto L6
    L13:
        monitor-exit(r10);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public void reportPathCtlModeChanged(String r8, int r10) {
        Set<MPAConnectionQualityCallback> r11 = this.mMPAConnectionQualityCallbackSet;
        monitor-enter(r11);
        Iterator<MPAConnectionQualityCallback> r12 = this.mMPAConnectionQualityCallbackSet.iterator();     // Catch: Throwable -> L10
    L6:
        if (r12.hasNext() == false) goto L8;
        r12.next().onPathCtlModeChanged(r8, r10);     // Catch: Throwable -> L10
        goto L6
    L8:
        monitor-exit(r11);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public void unregisterMPAConnectionQualityCallback(MPAConnectionQualityCallback r8) {
        this.mMPAConnectionQualityCallbackSet.remove(r8);
    }
}
