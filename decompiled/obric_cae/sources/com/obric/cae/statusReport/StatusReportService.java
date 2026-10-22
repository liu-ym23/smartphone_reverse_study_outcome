package com.obric.cae.statusReport;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.ServiceManager;
import com.obric.cae.libs.statusreport.ICaeStatusReportManager;
import com.obric.cae.log.CaeLog;
import com.obric.cae.statusReport.wifi.WifiStatusReport;

/* JADX INFO: loaded from: classes2.dex */
public class StatusReportService extends Service {
    private static final String SERVICE_NAME_STATUS_REPORT = "cae_status_report";
    private static final String TAG = "StatusReportService";
    private final ICaeStatusReportManager.Stub mBinder;
    private WifiStatusReport wifiStatusReport;

    public StatusReportService() {
        this.mBinder = new AnonymousClass1(this);
    }

    public static /* synthetic */ WifiStatusReport access$000(StatusReportService r8) {
        return r8.wifiStatusReport;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r8) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        CaeLog.d(TAG, "Service created");
        this.wifiStatusReport = new WifiStatusReport(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        CaeLog.d(TAG, "Service destroyed");
        this.wifiStatusReport.stopMonitoring();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r8, int r10, int r11) {
        CaeLog.d(TAG, "Service started");
        this.wifiStatusReport.startMonitoring();
        ServiceManager.addService(SERVICE_NAME_STATUS_REPORT, this.mBinder);
        return super.onStartCommand(r8, r10, r11);
    }
}
