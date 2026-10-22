package com.obric.cae.cldReport;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import com.obric.cae.libs.cldReport.ICldReportCallback;
import com.obric.cae.log.CaeLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class LogCollectAsyncTask extends AsyncTask<String, String, String> {
    private static final String TAG = "LogCollectAsyncTask";
    private final ICldReportCallback mCallback;
    private final boolean mIsNeedCallback;
    private final boolean mIsNeedUpload;
    private final AbstractLogCollector mLogCollector;
    private String mLogPath;
    private final String mModuleTypeStr;
    private final String mSummaryStr;

    public LogCollectAsyncTask(AbstractLogCollector r8, String r10) {
        this.mModuleTypeStr = r10;
        String r11 = r8.mSummary.toString();
        this.mSummaryStr = r11;
        this.mLogCollector = r8;
        boolean r12 = r8.mIsNeedCallback;
        this.mIsNeedCallback = r12;
        ICldReportCallback r13 = r8.mCallback;
        this.mCallback = r13;
        boolean r14 = r8.mIsNeedUpload;
        this.mIsNeedUpload = r14;
        CaeLog.i(TAG, r10 + " " + r11 + " isneedcallback=" + r12 + " isneedupload=" + r14 + " mCallback=" + r13);
    }

    private String createLogFolder() {
        String r8 = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String r10 = "/data/syslog/monitor/cld/" + this.mModuleTypeStr + "_" + Integer.toString(this.mLogCollector.mSummary.getErrorCode()) + "_" + r8;
        CldUtil.createFolder(r10);
        return r10;
    }

    private void uploadToSlardar(String r8) {
        CaeLog.i(TAG, "uploadToSlardar summary:" + this.mSummaryStr + " path:" + r8);
        Intent r10 = new Intent("bytedance.slardaros.customerror");
        r10.putExtra("key_error_type", "cae_cld_report");
        r10.putExtra("key_error_summary", this.mSummaryStr);
        r10.putExtra("key_error_logpath", r8);
        r10.putExtra("key_error_isdelete", true);
        r10.putExtra("key_error_package", "com.obric.cae");
        r10.putExtra("key_error_catchlog", true);
        r10.addFlags(32);
        r10.addFlags(16777216);
        this.mLogCollector.mContext.sendBroadcastAsUser(r10, UserHandle.CURRENT, "slardaros.intent.permission");
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ String doInBackground(String[] r8) {
        return doInBackground2(r8);
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(String r8) {
        onPostExecute2(r8);
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        String r8 = createLogFolder();
        this.mLogPath = r8;
        this.mLogCollector.setLogPath(r8);
        AbstractLogCollector r10 = this.mLogCollector;
        r10.startCollect(r10.mSummary.getErrorCode());
        if (this.mIsNeedCallback == true) goto L14;
        return;
    L14:
        IBinder r11 = this.mCallback.asBinder();     // Catch: RemoteException -> L11
        if (r11.isBinderAlive() == false) goto L9;
        this.mCallback.onStarted(true, this.mLogCollector.mSummary.getModuleType());     // Catch: RemoteException -> L11
        CaeLog.d(TAG, "onPreExecute onStarted " + this.mLogPath + " success iBinder:" + r11 + " logcollector:" + this.mLogCollector);     // Catch: RemoteException -> L11
    L13:
        return;
    L9:
        CaeLog.e(TAG, "onPreExecute onStarted " + this.mLogPath + " failed iBinder:" + r11 + " logcollector:" + this.mLogCollector);     // Catch: RemoteException -> L11
    L11:
        CaeLog.e(TAG, "onPreExecute " + this.mLogPath + " onStarted failed");
    }

    /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
    public String doInBackground2(String... r12) {
        long r8 = SystemClock.elapsedRealtime();
        AbstractLogCollector r13 = this.mLogCollector;
        int r10 = r13.mDuration;
        long r11 = ((long) r10) * 1000;
        r13.doInbg(r10);
        long r14 = r11;
    L4:
        if (r14 <= 0) goto L12;
        if (this.mLogCollector.mOnStoped == true) goto L12;
        CaeLog.d(TAG, this.mLogPath + " doInBackground stoped=" + this.mLogCollector.mOnStoped + " timeLeftMs=" + r14);
        Thread.sleep(1000);     // Catch: InterruptedException -> L10
    L11:
        r14 = (r8 + r11) - SystemClock.elapsedRealtime();
    L10:
        Thread.currentThread().interrupt();
    L12:
        AbstractLogCollector r15 = this.mLogCollector;
        r15.doCopyLog(r15.mLogPath);
        return null;
    }

    /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
    public void onPostExecute2(String r8) {
        AbstractLogCollector r10 = this.mLogCollector;
        r10.stopCollect(r10.mSummary.getErrorCode());
        if (this.mIsNeedUpload == false) goto L6;
        uploadToSlardar(this.mLogPath);
    L6:
        if (this.mIsNeedCallback == true) goto L17;
        return;
    L17:
        IBinder r11 = this.mCallback.asBinder();     // Catch: RemoteException -> L14
        if (r11.isBinderAlive() == false) goto L12;
        this.mCallback.onStoped(true, this.mLogCollector.mSummary.getModuleType(), this.mLogPath);     // Catch: RemoteException -> L14
        CaeLog.d(TAG, "onPostExecute onStoped " + this.mLogPath + " success iBinder:" + r11 + " logcollector:" + this.mLogCollector);     // Catch: RemoteException -> L14
    L16:
        return;
    L12:
        CaeLog.e(TAG, "onPostExecute onStoped " + this.mLogPath + " failed iBinder:" + r11 + " logcollector:" + this.mLogCollector);     // Catch: RemoteException -> L14
    L14:
        CaeLog.e(TAG, "onPostExecute" + this.mModuleTypeStr + this.mSummaryStr + this.mLogPath + " onStoped failed");
    }
}
