package com.obric.memorydata.sdk.awareness;

import android.os.IBinder;
import android.os.RemoteException;
import com.obric.memorydata.sdk.MemoryResponse;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class IContextAwarenessService$Default implements IContextAwarenessService {
    public IContextAwarenessService$Default() {
    }

    public IBinder asBinder() {
        return null;
    }

    public MemoryResponse getFeature(String r1) throws RemoteException {
        return null;
    }

    public MemoryResponse getGeoFenceStatus(String r1) throws RemoteException {
        return null;
    }

    public MemoryResponse getLocation(String r1) throws RemoteException {
        return null;
    }

    public MemoryResponse registerEvent(String r1, IEventChangeListener r2) throws RemoteException {
        return null;
    }

    public MemoryResponse registerFeature(String r1, IFeatureChangeListener r2) throws RemoteException {
        return null;
    }

    public MemoryResponse registerFeatureDuration(String r1, String r2, long r3, boolean r5, IFeatureDurationListener r6) throws RemoteException {
        return null;
    }

    public MemoryResponse setLocation(String r1, double r2, double r4, String r6, String r7) throws RemoteException {
        return null;
    }

    public MemoryResponse unregisterFeature(String r1, IFeatureChangeListener r2) throws RemoteException {
        return null;
    }

    public MemoryResponse unregisterFeatureDuration(String r1, String r2, long r3, boolean r5, IFeatureDurationListener r6) throws RemoteException {
        return null;
    }
}
