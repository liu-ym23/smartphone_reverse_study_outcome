package com.obric.assistant.dora;

import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.os.IBinder;
import android.os.RemoteException;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class IDoraBleProtocolService$Default implements IDoraBleProtocolService {
    public IDoraBleProtocolService$Default() {
    }

    public IBinder asBinder() {
        return null;
    }

    public List<ScanFilter> getScanFilters() throws RemoteException {
        return null;
    }

    public DoraBleDevice parseScanResult(ScanResult r1) throws RemoteException {
        return null;
    }

    public void startAutoBindFlow(DoraBleDevice r1) throws RemoteException {
    }
}
