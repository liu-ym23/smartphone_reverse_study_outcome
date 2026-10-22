package com.obric.cae.cldReport.gnss;

import android.content.Context;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.cae.cldReport.AbstractLogCollector;
import com.obric.cae.cldReport.CldCommon;
import com.obric.cae.cldReport.CldUtil;
import com.obric.cae.cldReport.LogCollectAsyncTask;
import com.obric.cae.libs.cldReport.ICldReportCallback;
import com.obric.cae.log.CaeLog;
import defpackage.a;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class GnssLogCollector extends AbstractLogCollector {
    private static final String TAG = "StarLocation-LogCollector";
    private final CldCommon mCldCommon;

    public GnssLogCollector(Context r10, ICldReportCallback r11, boolean r12, boolean r13, CldCommon r14, CldCommon.CldSummary r15) {
        super(r10, r11, r12, r13, r15, GnssLogLevelConfig.getDuration(r15.getErrorCode()));
        this.mCldCommon = r14;
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public LogCollectAsyncTask createAsyncTask(AbstractLogCollector r8) {
        return new LogCollectAsyncTask(this, CldCommon.CldModuleToString(r8.mSummary.getModuleType()));
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public void doCopyLog(String r8) {
        CaeLog.i(TAG, "doCopyLog logPath=" + r8);
        File r10 = new File("/sdcard/diag_logs/modem");
        CldUtil.copyDirectory(r10, new File(a.e(r8, "/gps_diag_logs")));
        CldUtil.deleteDirectory(r10);
        CldUtil.dumpsys(r8 + "/dumpsys_location.txt", new String[]{LocationMonitorConst.LOCATION, "--NoFilesDump"});
        CldUtil.dumpsys(a.e(r8, "/dumpsys_StarLocationService.txt"), new String[]{"activity", "service", "com.obric.cae/.location.StarLocationService"});
        CldUtil.copyDirectory(new File("/data/location/logs"), new File(a.e(r8, "/location_logs")));
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public void doInbg(int r8) {
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public void setLogPath(String r8) {
        super.setLogPath(r8);
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public void setOnStoped(boolean r8) {
        super.setOnStoped(r8);
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public void startCollect(int r8) {
        a.i("startCollect errorCode=", r8, TAG);
        this.mCldCommon.enableModuleAndLogMasks(GnssLogLevelConfig.getGnssLogLevelMasks(r8), GnssLogLevelConfig.getDuration(r8), true);
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public void stopCollect(int r8) {
        a.i("stopCollect errorCode=", r8, TAG);
        this.mCldCommon.disableModuleAndLogMasks(GnssLogLevelConfig.getGnssLogLevelMasks(r8), GnssLogLevelConfig.getDuration(r8), true);
    }
}
