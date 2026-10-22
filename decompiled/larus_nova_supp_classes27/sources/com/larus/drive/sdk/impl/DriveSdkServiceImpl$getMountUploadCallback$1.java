package com.larus.drive.sdk.impl;

import android.os.SystemClock;
import com.bytedance.ee.bear.middleground.drive.export.DriveFile;
import com.bytedance.ee.bear.middleground.drive.export.UploadCallback;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J,\u0010\r\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"com/larus/drive/sdk/impl/DriveSdkServiceImpl$getMountUploadCallback$1", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback;", "updatingStatusInterval", "", "latestUpdatingStatusTime", "updateProgress", "", "key", "", "info", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$TransmissionInfo;", "extra", "Lcom/bytedance/ee/bear/middleground/drive/export/UploadCallback$Extra;", "onFailed", "errorCode", "", "mountNodePoint", "bytesTotal", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveSdkServiceImpl$getMountUploadCallback$1 implements UploadCallback {
    final /* synthetic */ y79.a $callback;
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
            r0[DriveFile.Status.FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[DriveFile.Status.PENDING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[DriveFile.Status.QUEUE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            a = r0;
        }
    }

    public DriveSdkServiceImpl$getMountUploadCallback$1(y79.a r3) {
        this.$callback = r3;
        this.updatingStatusInterval = 1000;
    }

    public boolean updateProgress(String r12, UploadCallback.b r13, UploadCallback.a r14) {
        Intrinsics.checkNotNullParameter(r13, "info");
        Intrinsics.checkNotNullParameter(r14, "extra");
        int r0 = a.a[r13.a.ordinal()];
        if (r0 != 1) goto L5;
        long r5 = SystemClock.elapsedRealtime();
        if ((r5 - this.latestUpdatingStatusTime) >= this.updatingStatusInterval) goto L22;
        return true;
    L22:
        this.latestUpdatingStatusTime = r5;
        FLogger.a.d("DriveSdkServiceImpl", "mountUpload.updateProgress, key[" + r12 + "], info[" + r13 + ']');
        this.$callback.b(r13.b, r13.c);
    L23:
        return true;
    L5:
        if (r0 != 2) goto L7;
        FLogger.a.i("DriveSdkServiceImpl", "mountUpload.success, key[" + r12 + "], fileToken[" + r14.a + "], mountNodeToken[" + r14.c + "], mountPoint[" + r14.d + ']');
        y79.a r6 = this.$callback;
        String r15 = r14.a;
        if (r15 != null) goto L18;
        r15 = "";
    L18:
        r6.a(r12, r15, r14.g, r14.c, r14.d);
        goto L23
    L7:
        if (r0 != 3) goto L9;
        FLogger.a.e("DriveSdkServiceImpl", "mountUpload.failed, key[" + r12 + "], info[" + r13 + ']');
        this.$callback.onFailed(r12, -1);
        goto L23
    L9:
        if (r0 == 4) goto L23;
        if (r0 == 5) goto L23;
        return false;
    }

    public boolean onFailed(String r4, int r5, String r6, long r7) {
        FLogger.a.e("DriveSdkServiceImpl", "mountUpload.onFailed, key[" + r4 + "], errorCode[" + r5 + "], mountNodePoint[" + r6 + "], bytesTotal[" + r7 + ']');
        this.$callback.onFailed(r4, r5);
        return true;
    }
}
