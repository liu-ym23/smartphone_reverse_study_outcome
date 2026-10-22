package com.obric.cae.cldReport.bluetooth;

import android.content.Context;
import com.obric.cae.cldReport.AbstractLogCollector;
import com.obric.cae.cldReport.CldCommon;
import com.obric.cae.cldReport.CldUtil;
import com.obric.cae.cldReport.LogCollectAsyncTask;
import com.obric.cae.libs.cldReport.ICldReportCallback;
import com.obric.cae.log.CaeLog;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class BluetoothLogCollector extends AbstractLogCollector {
    private static final int DEFAULT_DURATION = 1;
    private static final String TAG = "BluetoothLogCollector";
    private final CldCommon mCldCommon;
    private final Context mContext;

    public BluetoothLogCollector(Context r8, ICldReportCallback r10, boolean r11, boolean r12, CldCommon r13, CldCommon.CldSummary r14) {
        super(r8, r10, r11, r12, r14, 1);
        this.mContext = r8;
        this.mCldCommon = r13;
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public LogCollectAsyncTask createAsyncTask(AbstractLogCollector r8) {
        return new LogCollectAsyncTask(this, CldCommon.CldModuleToString(r8.mSummary.getModuleType()));
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public void doCopyLog(String r8) {
        CaeLog.d(TAG, "doCopyLog snoopLog to " + r8);
        CldUtil.copyDirectory(new File("/data/misc/bluetooth/logs"), new File(r8));
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public void doInbg(int r8) {
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public void startCollect(int r8) {
        CaeLog.i(TAG, "startCollect not implement");
    }

    @Override // com.obric.cae.cldReport.AbstractLogCollector
    public void stopCollect(int r8) {
        CaeLog.i(TAG, "stopCollect not implement");
    }
}
