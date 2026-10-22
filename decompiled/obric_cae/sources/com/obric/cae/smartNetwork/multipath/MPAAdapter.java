package com.obric.cae.smartNetwork.multipath;

import android.util.Log;
import com.obric.cae.libs.multipath.ICaeMultipathCallback;

/* JADX INFO: loaded from: classes2.dex */
public class MPAAdapter {
    private static final int ONLY_CELL_WHEN_DUAL = 2;
    private static final int ONLY_WIFI_WHEN_DUAL = 1;
    private static final String TAG = "MPAAdapter";
    private static final int UNSPECIFIED = 0;
    private static final int WIFI_AND_CELL_WHEN_DUAL = 3;
    private ICaeMultipathCallback mCaeMultipathCallback;

    public MPAAdapter() {
        this.mCaeMultipathCallback = null;
    }

    private boolean changePathCtlAction(String r8, int r10) {
        ICaeMultipathCallback r11 = this.mCaeMultipathCallback;
        if (r11 != null) goto L9;
    L8:
        return false;
    L9:
        return r11.changePathCtlAction(r8, r10);
    L6:
        e = move-exception;
        Log.e(TAG, e.getMessage());
        goto L8
    }

    public synchronized boolean setBothWifiAndCellular(String r8) {
        monitor-enter(this);
        boolean r10 = changePathCtlAction(r8, 3);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void setMultipathCallback(ICaeMultipathCallback r8) {
        monitor-enter(this);
        this.mCaeMultipathCallback = r8;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean setOnlyCellular(String r8) {
        monitor-enter(this);
        boolean r10 = changePathCtlAction(r8, 2);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized boolean setOnlyWifi(String r8) {
        monitor-enter(this);
        boolean r10 = changePathCtlAction(r8, 1);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void unsetMultipathCallback() {
        monitor-enter(this);
        this.mCaeMultipathCallback = null;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
