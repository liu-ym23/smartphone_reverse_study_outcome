package com.obric.cae.connectivity;

import android.content.Context;
import android.util.Log;
import com.bytedance.radioservice.modemrecord.IModemInfoRecordService;
import com.bytedance.radioservice.modemrecord.ModemCellRecord;
import com.bytedance.radioservice.modemrecord.a;
import com.obric.cae.utils.CaeUtil;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class CaeCellularInfoReport implements IAoiDataCollector {
    private static final int CONNECTIVITY_EVENT_FEATURE_ID = 143;
    private static final String TAG = "CaeCellularInfoReport";
    private static CaeCellularInfoReport sInstance;
    private Context mContext;
    private String mCurrentPoiName;
    private long mTriggerTime;

    public CaeCellularInfoReport() {
        this.mCurrentPoiName = "";
        this.mTriggerTime = 0;
    }

    private void collectAndReportCellularData() {
        IModemInfoRecordService r8 = a.a();     // Catch: Exception -> L32
        if (r8 != null) goto L7;
        Log.e(TAG, "IModemInfoRecordService is null");     // Catch: Exception -> L32
        return;
    L7:
        List<ModemCellRecord> r10 = r8.W1();     // Catch: Exception -> L32
        if (r10 != null) goto L10;
    L30:
        Log.i(TAG, "Cell record list is empty");     // Catch: Exception -> L32
        return;
    L10:
        if (r10.isEmpty() == true) goto L30;
        long r11 = System.currentTimeMillis();     // Catch: Exception -> L32
        CaeConnectivityDataProto.Builder r12 = CaeConnectivityDataProto.newBuilder();     // Catch: Exception -> L32
        CaeConnectivityProtoData.Builder r13 = CaeConnectivityProtoData.newBuilder();     // Catch: Exception -> L32
        long r14 = this.mTriggerTime;     // Catch: Exception -> L32
        if (r14 > 0) goto L16;
        r14 = r11;
    L16:
        CaeConnectivityProtoData.Builder r15 = r13.setDeviceTime(r14).setName(this.mCurrentPoiName);     // Catch: Exception -> L32
        Iterator<ModemCellRecord> r16 = r10.iterator();     // Catch: Exception -> L32
    L18:
        if (r16.hasNext() == false) goto L28;
        ModemCellRecord r17 = r16.next();     // Catch: Exception -> L32
        if (r17 == null) goto L18;
        CellularCellRecordReport.Builder r18 = CellularCellRecordReport.newBuilder();     // Catch: Exception -> L32
        String r19 = r17.f4041b;     // Catch: Exception -> L32
        if (r19 != null) goto L26;
        r19 = "";
    L26:
        r15.addCellularCellRecordReport(r18.setSpecificCellId(r19).setLeaveTimestampMs(r17.f4040a).setRsrp(r17.f4043n).setStepCount(r17.f4042m));     // Catch: Exception -> L32
        goto L18
    L28:
        if (r15.getCellularCellRecordReportCount() <= 0) goto L42;
        r12.addCaeConnectivityProto(r15);     // Catch: Exception -> L32
        CaeUtil.writePbEventSafely(r11, CONNECTIVITY_EVENT_FEATURE_ID, r12.build().toByteArray());     // Catch: Exception -> L32
        Log.i(TAG, "Reported " + r15.getCellularCellRecordReportCount() + " cell records to CaeConnectivityDataProto");     // Catch: Exception -> L32
        return;
    L42:
        return;
    L32:
        e = move-exception;
        Log.e(TAG, "Failed to collect and report cellular data", e);
    }

    public static synchronized CaeCellularInfoReport getInstance() {
        monitor-enter(CaeCellularInfoReport.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (sInstance != null) goto L7;
        sInstance = new CaeCellularInfoReport();     // Catch: Throwable -> L10
    L7:
        CaeCellularInfoReport r8 = sInstance;     // Catch: Throwable -> L10
        monitor-exit(CaeCellularInfoReport.class);
        return r8;
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public synchronized void destroy() {
        monitor-enter(this);
        stopCollect();     // Catch: Throwable -> L6
        this.mContext = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public int getCollectorType() {
        return 8;
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public void init(Context r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        this.mContext = r8.getApplicationContext();
        Log.i(TAG, "CaeCellularInfoReport initialized.");
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public synchronized void startCollect(String r8, long r10) {
        monitor-enter(this);
        if (r8 != null) goto L17;
        r8 = "";
    L17:
        this.mCurrentPoiName = r8;     // Catch: Throwable -> L5
        this.mTriggerTime = r10;     // Catch: Throwable -> L5
        if (this.mContext != null) goto L12;
        Log.e(TAG, "Cannot start collect: Not initialized.");     // Catch: Throwable -> L5
        monitor-exit(this);
        return;
    L12:
        Log.i(TAG, "Started collecting: Cellular info.");     // Catch: Throwable -> L5
        collectAndReportCellularData();     // Catch: Throwable -> L5
        monitor-exit(this);
        return;
    L5:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.cae.connectivity.IAoiDataCollector
    public void stopCollect() {
        Log.i(TAG, "Stopped collecting: Cellular info.");
    }
}
