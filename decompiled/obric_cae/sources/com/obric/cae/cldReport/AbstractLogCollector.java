package com.obric.cae.cldReport;

import android.content.Context;
import android.os.AsyncTask;
import com.obric.cae.libs.cldReport.ICldReportCallback;

/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractLogCollector {
    private static final String TAG = "AbstractLogCollector";
    protected ICldReportCallback mCallback;
    protected Context mContext;
    protected int mDuration;
    protected boolean mIsNeedCallback;
    protected boolean mIsNeedUpload;
    protected String mLogPath;
    protected final int mModuleType;
    protected boolean mOnStoped;
    public final CldCommon.CldSummary mSummary;

    public AbstractLogCollector(Context r8, ICldReportCallback r10, boolean r11, boolean r12, CldCommon.CldSummary r13, int r14) {
        this.mOnStoped = false;
        this.mSummary = r13;
        this.mCallback = r10;
        this.mIsNeedCallback = r11;
        this.mIsNeedUpload = r12;
        this.mModuleType = r13.getModuleType();
        this.mDuration = r14;
        this.mContext = r8;
    }

    public final void collectAndUploadLog() {
        createAsyncTask(this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[0]);
    }

    public abstract LogCollectAsyncTask createAsyncTask(AbstractLogCollector r8);

    public abstract void doCopyLog(String r8);

    public abstract void doInbg(int r8);

    public void setLogPath(String r8) {
        this.mLogPath = r8;
    }

    public void setOnStoped(boolean r8) {
        this.mOnStoped = r8;
    }

    public abstract void startCollect(int r8);

    public abstract void stopCollect(int r8);
}
