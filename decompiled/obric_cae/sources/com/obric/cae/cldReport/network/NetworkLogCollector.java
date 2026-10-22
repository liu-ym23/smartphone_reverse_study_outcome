package com.obric.cae.cldReport.network;

import android.content.Context;
import com.obric.cae.cldReport.AbstractLogCollector;
import com.obric.cae.cldReport.AbstractLogLevelConfig;
import com.obric.cae.cldReport.CldCommon;
import com.obric.cae.cldReport.CldUtil;
import com.obric.cae.cldReport.LogCollectAsyncTask;
import com.obric.cae.libs.cldReport.ICldReportCallback;
import com.obric.cae.log.CaeLog;
import defpackage.a;
import defpackage.b;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class NetworkLogCollector extends AbstractLogCollector {
    private static final String TAG = "NetworkLogCollector";
    private final CldCommon mCldCommon;
    private final Context mContext;

    public NetworkLogCollector(Context r10, ICldReportCallback r11, boolean r12, boolean r13, CldCommon r14, CldCommon.CldSummary r15) {
        super(r10, r11, r12, r13, r15, NetworkLogLevelConfig.getDuration(r15.getErrorCode()));
        this.mContext = r10;
        this.mCldCommon = r14;
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public LogCollectAsyncTask createAsyncTask(AbstractLogCollector r8) {
        return new LogCollectAsyncTask(this, CldCommon.CldModuleToString(r8.mSummary.getModuleType()));
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public void doCopyLog(String r8) {
        CldUtil.dumpsys(a.e(r8, "/dumpsys_netpolicy.txt"), new String[]{"netpolicy"});
        CldUtil.dumpsys(a.e(r8, "/dumpsys_network_management.txt"), new String[]{"network_management"});
        CldUtil.dumpsys(a.e(r8, "/dumpsys_connectivity.txt"), new String[]{"connectivity"});
        CldUtil.dumpsys(a.e(r8, "/dumpsys_network_stack.txt"), new String[]{"network_stack"});
        CldUtil.dumpsys(a.e(r8, "/dumpsys_connmetrics.txt"), new String[]{"connmetrics"});
        CldUtil.dumpsys(a.e(r8, "/dumpsys_netstats.txt"), new String[]{"netstats"});
        CldUtil.dumpsys(a.e(r8, "/dumpsys_wifi.txt"), new String[]{"wifi"});
        File r10 = new File(r8);     // Catch: Exception -> L5
        CldUtil.copyDirectory(new File("/sdcard/Android/data/com.obric.cae/files/logs"), r10);     // Catch: Exception -> L5
        CldUtil.copyDirectory(new File("/data/capture"), r10);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        b.k(e, new StringBuilder("doCopyLog: "), TAG);
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public void doInbg(int r8) {
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public void startCollect(int r8) {
        AbstractLogLevelConfig.ModuleAndLogMasks[] r10 = NetworkLogLevelConfig.getNetworkLogLevelMasks(r8);
        int r11 = NetworkLogLevelConfig.getDuration(r8);
        this.mCldCommon.enableModuleAndLogMasks(r10, r11, true);
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public void stopCollect(int r8) {
        AbstractLogLevelConfig.ModuleAndLogMasks[] r10 = NetworkLogLevelConfig.getNetworkLogLevelMasks(r8);
        int r11 = NetworkLogLevelConfig.getDuration(r8);
        if (r10 == null) goto L6;
        this.mCldCommon.disableModuleAndLogMasks(r10, r11, true);
        CaeLog.i(TAG, "stopCollect");
        return;
    }
}
