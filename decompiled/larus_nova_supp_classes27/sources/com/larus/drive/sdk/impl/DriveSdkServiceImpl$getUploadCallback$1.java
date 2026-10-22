package com.larus.drive.sdk.impl;

import android.os.SystemClock;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import com.larus.drive.biz.api.model.DriveUploadStatus;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y79.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J,\u0010\r\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"com/larus/drive/sdk/impl/DriveSdkServiceImpl$getUploadCallback$1", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback;", "updatingStatusInterval", "", "latestUpdatingStatusTime", "updateProgress", "", "key", "", "info", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$TransmissionInfo;", "extra", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$Extra;", "onFailed", "errorCode", "", "mountNodePoint", "bytesTotal", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSdkServiceImpl$getUploadCallback$1 implements UploadCallback {
    final /* synthetic */ b $callback;
    private long latestUpdatingStatusTime;
    private final long updatingStatusInterval;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DriveFile.Status.values().length];
            r0[DriveFile.Status.INFLIGHT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[DriveFile.Status.SUCCESS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[DriveFile.Status.PENDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[DriveFile.Status.QUEUE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[DriveFile.Status.FAILED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public DriveSdkServiceImpl$getUploadCallback$1(b r3) {
        this.$callback = r3;
        this.updatingStatusInterval = 1000;
    }

    public boolean updateProgress(String r9, UploadCallback.b r10, UploadCallback.a r11) {
        Intrinsics.checkNotNullParameter(r10, "info");
        Intrinsics.checkNotNullParameter(r11, "extra");
        int r12 = a.a[r10.a.ordinal()];
        if (r12 != 1) goto L5;
        long r1 = SystemClock.elapsedRealtime();
        if ((r1 - this.latestUpdatingStatusTime) >= this.updatingStatusInterval) goto L21;
        return true;
    L21:
        this.latestUpdatingStatusTime = r1;
        DriveUploadStatus r13 = DriveUploadStatus.UPLOADING;
    L17:
        DriveUploadStatus r3 = r13;
        if (r10.a != DriveFile.Status.INFLIGHT) goto L25;
        FLogger.a.d("DriveSdkServiceImpl", "updateProgress, key[" + r9 + "], info[" + r10 + ']');
    L26:
        this.$callback.a(r9, r3, r10.b, r10.c);
        return true;
    L25:
        FLogger.a.i("DriveSdkServiceImpl", "updateProgress, key[" + r9 + "], info[" + r10 + ']');
        goto L26
    L5:
        if (r12 != 2) goto L7;
        r13 = DriveUploadStatus.FINISH;
        goto L17
    L7:
        if (r12 != 3) goto L9;
    L15:
        r13 = DriveUploadStatus.UNSTARTED;
        goto L17
    L9:
        if (r12 == 4) goto L15;
        if (r12 == 5) goto L14;
        return false;
    L14:
        r13 = DriveUploadStatus.FAILED;
        goto L17
    }

    public boolean onFailed(String r4, int r5, String r6, long r7) {
        FLogger.a.e("DriveSdkServiceImpl", "updateFailed, key[" + r4 + "], errorCode[" + r5 + "], mountNodePoint[" + r6 + "], bytesTotal[" + r7 + ']');
        this.$callback.onFailed(r4, r5);
        return true;
    }
}
