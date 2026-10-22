package com.larus.drive.sdk.impl;

import com.bytedance.ee.bear.list.DocumentListInfo;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import nc5.a;
import u79.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class k implements a<DocumentListInfo> {
    public final /* synthetic */ String a;
    public final /* synthetic */ b b;
    public final /* synthetic */ DriveSdkServiceImpl c;

    public final void onFailure(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("DriveSdkServiceImpl", "requestRecentDriveFileList retry failed, loadMoreLabel[" + this.a + ']', r4);
        b r0 = this.b;
        String r5 = r4.getMessage();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r0.onError(r5);
    }

    public final void onSuccess(Object r4) {
        DocumentListInfo r5 = (DocumentListInfo) r4;
        Intrinsics.checkNotNullParameter(r5, "result");
        FLogger.a.i("DriveSdkServiceImpl", "requestRecentDriveFileList retry succeeded, loadMoreLabel[" + this.a + ']');
        b r0 = this.b;
        if (r5.isHasMore() == false) goto L5;
        String r1 = r5.getLastLabel();
    L6:
        r0.a(r1, DriveSdkServiceImpl.Z(this.c, r5));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public k(String r1, b r2, DriveSdkServiceImpl r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
