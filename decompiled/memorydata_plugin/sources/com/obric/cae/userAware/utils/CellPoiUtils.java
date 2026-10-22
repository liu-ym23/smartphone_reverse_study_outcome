package com.obric.cae.userAware.utils;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.bytedance.radioservice.a.b;
import com.obric.cae.log.a;

/* JADX INFO: loaded from: classes3.dex */
public class CellPoiUtils {
    private static final String SERVICE_NAME = "cellpoi_service";
    private static final String TAG = "CellPoiUtils";
    private static IBinder sBinder;
    private static final Object sLock = null;
    private static b sService;

    static {
        sLock = new Object();
    }

    private CellPoiUtils() {
    }

    private static void clear() {
        Object r0 = sLock;
        monitor-enter(r0);
        sBinder = null;     // Catch: Throwable -> L8
        sService = null;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static b getService() {
        Object r0 = sLock;
        monitor-enter(r0);
        IBinder r1 = ServiceManager.getService(SERVICE_NAME);     // Catch: Throwable -> L13
        if (r1 == null) goto L7;
        b r2 = b.a.a(r1);     // Catch: Throwable -> L13
        r1.linkToDeath(new AnonymousClass1(), 0);     // Catch: Throwable -> L16
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return r2;
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return null;
    L13:
        th = move-exception;
        throw th;
    }

    public static String getStationName(int r9, int r10, int r11, long r12) {
        String r0 = TAG;
        a.e(r0, com.obric.cae.location.b.a("getStationName: cellPoiType=", r9, ", rat=", r10, ", tac=").append(r11).append(", cellId(36bit)=").append(r12).toString());
        if (r10 != 3) goto L5;
    L7:
        b r3 = getService();
        if (r3 != null) goto L19;
        a.i(r0, "getStationName: service is null");
        return null;
    L19:
        String r13 = r3.a(r9, r10, r11, r12);     // Catch: Throwable -> L15 RemoteException -> L17
        clear();
        return r13;
    L17:
        clear();
        return null;
    L15:
        clear();
        return null;
    L5:
        if (r10 == 6) goto L7;
        return null;
    }
}
