package com.ss.android.socialbase.downloader.depend;

import android.util.Pair;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class AbsDownloadListener implements IDownloadListener {
    private static final String TAG = null;

    public AbsDownloadListener() {
    }

    static {
        TAG = "AbsDownloadListener";
    }

    public void onCanceled(DownloadInfo r4) {
        if (Logger.debugScene(r4) == false) goto L7;
        if (r4 == null) goto L8;
        Logger.taskDebug(TAG, r4, "onCanceled", "Name: " + r4.getName());
        return;
    L8:
        return;
    }

    public void onFirstStart(DownloadInfo r4) {
        if (Logger.debugScene(r4) == false) goto L7;
        if (r4 == null) goto L8;
        Logger.taskDebug(TAG, r4, "onFirstStart", "Name: " + r4.getName());
        return;
    L8:
        return;
    }

    public void onFirstSuccess(DownloadInfo r4) {
        if (Logger.debugScene(r4) == false) goto L7;
        if (r4 == null) goto L8;
        Logger.taskDebug(TAG, r4, "onFirstSuccess", "Name: " + r4.getName());
        return;
    L8:
        return;
    }

    public void onIntercept(DownloadInfo r4) {
        if (Logger.debugScene(r4) == false) goto L7;
        if (r4 == null) goto L8;
        Logger.taskDebug(TAG, r4, "onIntercept", "Name: " + r4.getName());
        return;
    L8:
        return;
    }

    public void onPause(DownloadInfo r4) {
        if (Logger.debugScene(r4) == false) goto L7;
        if (r4 == null) goto L8;
        Logger.taskDebug(TAG, r4, "onPause", "Name: " + r4.getName());
        return;
    L8:
        return;
    }

    public void onPrepare(DownloadInfo r4) {
        if (Logger.debugScene(r4) == false) goto L7;
        if (r4 == null) goto L8;
        Logger.taskDebug(TAG, r4, "onPrepare", "Name: " + r4.getName());
        return;
    L8:
        return;
    }

    public void onProgress(DownloadInfo r6) {
        if (Logger.debugScene(r6) == false) goto L9;
        if (r6 != null) goto L6;
        return;
    L6:
        if (r6.getTotalBytes() == 0) goto L11;
        Logger.taskDebug(TAG, r6.getId(), "onProgress", String.format("Name: %s %.2f%%", new Object[]{r6.getName(), Float.valueOf((r6.getCurBytes() / r6.getTotalBytes()) * 100.0f)}));
        return;
    L11:
        return;
    }

    public void onStart(DownloadInfo r4) {
        if (Logger.debugScene(r4) == false) goto L7;
        if (r4 == null) goto L8;
        Logger.taskDebug(TAG, r4, "onStart", "Name: " + r4.getName());
        return;
    L8:
        return;
    }

    public void onSuccessed(DownloadInfo r4) {
        if (Logger.debugScene(r4) == false) goto L7;
        if (r4 == null) goto L8;
        Logger.taskDebug(TAG, r4, "onSuccessed", "Name: " + r4.getName() + " " + r4.isSuccessByCache());
        return;
    L8:
        return;
    }

    public void onFailed(DownloadInfo r5, BaseException r6) {
        if (Logger.debugScene(r5) == false) goto L11;
        if (r5 == null) goto L12;
        String r0 = TAG;
        Object[] r1 = new Object[2];
        r1[0] = r5.getName();
        if (r6 == null) goto L8;
        String r7 = r6.getErrorMessage();
    L9:
        r1[1] = r7;
        Logger.taskDebug(r0, r5, "onFailed", String.format("Name: %s because of : %s", r1));
        return;
    L8:
        r7 = "unkown";
        goto L9
    L12:
        return;
    }

    public void onReceiveHeader(DownloadInfo r4, List<Pair<String, String>> r5) {
        if (Logger.debugScene(r4) == false) goto L7;
        if (r4 == null) goto L8;
        Logger.taskDebug(TAG, r4, "onReceiveHeader", "Name: " + r4.getName() + " header:" + r5);
        return;
    L8:
        return;
    }

    public void onReceiveRequestLog(DownloadInfo r4, String r5) {
        if (Logger.debugScene(r4) == false) goto L7;
        if (r4 == null) goto L8;
        Logger.taskDebug(TAG, r4, "onReceiveRequestLog", "Name: " + r4.getName() + " requestLog:" + r5);
        return;
    L8:
        return;
    }

    public void onRetry(DownloadInfo r5, BaseException r6) {
        if (Logger.debugScene(r5) == false) goto L11;
        if (r5 == null) goto L12;
        String r0 = TAG;
        Object[] r1 = new Object[2];
        r1[0] = r5.getName();
        if (r6 == null) goto L8;
        String r7 = r6.getErrorMessage();
    L9:
        r1[1] = r7;
        Logger.taskDebug(r0, r5, "onRetry", String.format("Name: %s because of : %s", r1));
        return;
    L8:
        r7 = "unkown";
        goto L9
    L12:
        return;
    }

    public void onRetryDelay(DownloadInfo r5, BaseException r6) {
        if (Logger.debugScene(r5) == false) goto L11;
        if (r5 == null) goto L12;
        String r0 = TAG;
        Object[] r1 = new Object[2];
        r1[0] = r5.getName();
        if (r6 == null) goto L8;
        String r7 = r6.getErrorMessage();
    L9:
        r1[1] = r7;
        Logger.taskDebug(r0, r5, "onRetryDelay", String.format("Name: %s because of : %s", r1));
        return;
    L8:
        r7 = "unkown";
        goto L9
    L12:
        return;
    }

    public void onReceiveData(DownloadInfo r3, byte[] r4, int r5) {
        if (Logger.debugScene(r3) == false) goto L7;
        if (r3 == null) goto L8;
        Logger.taskDebug(TAG, r3, "onReceiveData", "Name: " + r3.getName() + " data len:" + r5);
        return;
    L8:
        return;
    }

    public void onReceiveSegmentData(DownloadInfo r3, long r4, byte[] r6, int r7) {
        if (Logger.debugScene(r3) == false) goto L7;
        if (r3 == null) goto L8;
        Logger.taskDebug(TAG, r3, "onReceiveSegmentData", "Name: " + r3.getName() + "offset:" + r4 + " data len:" + r7);
        return;
    L8:
        return;
    }
}
