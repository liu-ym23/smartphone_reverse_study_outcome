package com.obric.cae.userAware;

import android.content.Context;
import com.obric.cae.log.CommSenseLog;
import com.obric.cae.userAware.utils.UserAwareUtil;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class OemHarInfoManager {
    private static final String KEY_FILE_HAR_STATE = "har_state";
    private static final int STATE_CAR = 8;
    private static final int STATE_CYCLING = 6;
    private static final int STATE_ELECTRIC_BIKE = 7;
    private static final int STATE_OTHER = 9;
    private static final int STATE_RUNNING = 1;
    private static final int STATE_STATIONARY = 0;
    private static final int STATE_SUBWAY = 5;
    private static final int STATE_WALKING = 2;
    private static final String TAG = "OemHarInfoManager";
    private static volatile OemHarInfoManager sInstance;
    private final Context mContext;
    private File mHarRecordFile;
    private final AtomicBoolean mIsHarEnableNotification;
    private final AtomicBoolean mIsHarStatusRecoding;
    private int mLastNotifyState;

    public static class HarStateRecord {
        int state;
        long timestamp;

        public HarStateRecord(int r8, long r10) {
            this.state = r8;
            this.timestamp = r10;
        }
    }

    private OemHarInfoManager(Context r8) {
        this.mLastNotifyState = 0;
        this.mIsHarStatusRecoding = new AtomicBoolean(false);
        this.mIsHarEnableNotification = new AtomicBoolean(false);
        CommSenseLog.d(TAG, "OemHarInfoManager");
        this.mContext = r8;
        initHarRecordFile();
    }

    public static OemHarInfoManager getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(OemHarInfoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new OemHarInfoManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(OemHarInfoManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static File getLocalDir(Context r8, String r10) {
        File r11 = new File(r8.getFilesDir(), r10);
        if (r11.exists() == true) goto L5;
        r11.mkdirs();
    L5:
        return r11;
    }

    private void initHarRecordFile() {
        File r8 = new File(getLocalDir(this.mContext, "oem_har"), "har_status_events.log");
        r8.delete();
        r8.createNewFile();     // Catch: IOException -> L5
    L6:
        this.mHarRecordFile = r8;
        CommSenseLog.d(TAG, "initHarRecordFile, file: " + this.mHarRecordFile);
        CommSenseLog.recordFileWithKey("har_state", this.mHarRecordFile);
        return;
    L5:
        CommSenseLog.e(TAG, "IO error occurred!");
        goto L6
    }

    public void clear() {
        CommSenseLog.d(TAG, "clear");
        sInstance = null;
    }

    public int getHarLastNotifyState() {
        return this.mLastNotifyState;
    }

    public void handleHarStateUpdate(int r8, long r10) {
        this.mLastNotifyState = r8;
        CommSenseLog.dumpI(TAG, UserAwareUtil.getHarStateString(this.mContext, r8), this.mHarRecordFile);
    }

    public boolean isHarEnableNotification() {
        return this.mIsHarEnableNotification.get();
    }

    public void setHarEnableNotification(boolean r8) {
        this.mIsHarEnableNotification.set(r8);
    }

    public void startRecordHarStatus() {
        this.mIsHarStatusRecoding.set(true);
    }

    public void stopRecordHarStatus() {
        this.mIsHarStatusRecoding.set(false);
    }
}
