package com.larus.drive.sdk.impl.service;

import com.larus.drive.sdk.impl.DriveSdkServiceImpl;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h implements nc5.c<com.bytedance.ee.bear.list.delete.e> {
    public final /* synthetic */ v79.a a;

    public h(DriveSdkServiceImpl.k r1) {
        this.a = r1;
    }

    public final void a(com.bytedance.ee.bear.list.delete.e r4) {
        Intrinsics.checkNotNullParameter(r4, "result");
        if (r4.a == false) goto L5;
        FLogger.a.i("DriveFileServiceDelegate", "[deleteMultiDriveFilesAndFolder] Delete succeeded");
        this.a.onSuccess();
        return;
    L5:
        FLogger.a.i("DriveFileServiceDelegate", "[deleteMultiDriveFilesAndFolder] Delete failed");
        this.a.a(r4.b);
    }
}
