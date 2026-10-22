package com.obric.cae.userAware.utils;

import android.os.IBinder;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.bytedance.radioservice.cellpoi.ICellPoiService;
import com.obric.cae.log.CommSenseLog;

/* JADX INFO: loaded from: classes2.dex */
public class CellPoiUtils {
    private static final String SERVICE_NAME = "cellpoi_service";
    private static final String TAG = "CellPoiUtils";
    private static IBinder sBinder;
    private static final Object sLock = null;
    private static ICellPoiService sService;

    static {
        sLock = new Object();
    }

    private CellPoiUtils() {
    }

    private static void clear() {
        Object r8 = sLock;
        monitor-enter(r8);
        sBinder = null;     // Catch: Throwable -> L8
        sService = null;     // Catch: Throwable -> L8
        monitor-exit(r8);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private static ICellPoiService getService() {
        Object r8 = sLock;
        monitor-enter(r8);
        IBinder r10 = ServiceManager.getService(SERVICE_NAME);     // Catch: Throwable -> L13
        if (r10 != null) goto L9;
        monitor-exit(r8);     // Catch: Throwable -> L13
        return null;
    L9:
        ICellPoiService r11 = ICellPoiService.Stub.H2(r10);     // Catch: Throwable -> L13
        r10.linkToDeath(new AnonymousClass1(), 0);     // Catch: Throwable -> L16
    L11:
        monitor-exit(r8);     // Catch: Throwable -> L13
        return r11;
    L13:
        th = move-exception;
        throw th;
    }

    public static String getStationName(int r10, int r11, int r12, long r13) {
        String r8 = TAG;
        StringBuilder r14 = defpackage.a.g("getStationName: cellPoiType=", r10, ", rat=", r11, ", tac=");
        r14.append(r12);
        r14.append(", cellId(36bit)=");
        r14.append(r13);
        CommSenseLog.i(r8, r14.toString());
        if (r11 != 3) goto L5;
    L7:
        ICellPoiService r15 = getService();
        if (r15 != null) goto L19;
        CommSenseLog.e(r8, "getStationName: service is null");
        return null;
    L19:
        String r16 = r15.o1(r10, r11, r12, r13);     // Catch: Throwable -> L15 RemoteException -> L17
        clear();
        return r16;
    L17:
        clear();
        return null;
    L15:
        clear();
        return null;
    L5:
        if (r11 == 6) goto L7;
        return null;
    }
}
