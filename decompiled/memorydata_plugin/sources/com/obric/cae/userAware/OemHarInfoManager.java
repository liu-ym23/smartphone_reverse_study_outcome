package com.obric.cae.userAware;

import android.content.Context;
import com.obric.cae.log.a;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
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

        public HarStateRecord(int r1, long r2) {
            this.state = r1;
            this.timestamp = r2;
        }
    }

    private OemHarInfoManager(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        this.mLastNotifyState = 0;
        this.mIsHarStatusRecoding = new AtomicBoolean(false);
        this.mIsHarEnableNotification = new AtomicBoolean(false);
        a.c(TAG, "OemHarInfoManager");
        this.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.memorydata.plugin");
        initHarRecordFile();
    }

    public static OemHarInfoManager getInstance(Context r2) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        if (sInstance != null) goto L15;
        monitor-enter(OemHarInfoManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new OemHarInfoManager(r3);     // Catch: Throwable -> L11
    L9:
        monitor-exit(OemHarInfoManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public static File getLocalDir(Context r2, String r3) {
        File r0 = new File(((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getFilesDir(), r3);
        if (r0.exists() == true) goto L5;
        r0.mkdirs();
    L5:
        return r0;
    }

    private void initHarRecordFile() {
        File r0 = new File(getLocalDir(this.mContext, "oem_har"), "har_status_events.log");
        r0.delete();
        r0.createNewFile();     // Catch: IOException -> L5
    L6:
        this.mHarRecordFile = r0;
        a.c(TAG, "initHarRecordFile, file: " + this.mHarRecordFile);
        a.a(KEY_FILE_HAR_STATE, this.mHarRecordFile);
        return;
    L5:
        a.i(TAG, "IO error occurred!");
        goto L6
    }

    public void clear() {
        a.c(TAG, "clear");
        sInstance = null;
    }

    public int getHarLastNotifyState() {
        return this.mLastNotifyState;
    }

    public void handleHarStateUpdate(int r1, long r2) {
        this.mLastNotifyState = r1;
        a.c(TAG, UserAwareUtil.getHarStateString(this.mContext, r1), this.mHarRecordFile);
    }

    public boolean isHarEnableNotification() {
        return this.mIsHarEnableNotification.get();
    }

    public void setHarEnableNotification(boolean r1) {
        this.mIsHarEnableNotification.set(r1);
    }

    public void startRecordHarStatus() {
        this.mIsHarStatusRecoding.set(true);
    }

    public void stopRecordHarStatus() {
        this.mIsHarStatusRecoding.set(false);
    }
}
