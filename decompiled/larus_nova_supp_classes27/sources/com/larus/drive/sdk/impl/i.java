package com.larus.drive.sdk.impl;

import com.bytedance.ee.bear.list.DocumentListInfo;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;
import nc5.a;
import u79.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i implements a<DocumentListInfo> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ b c;
    public final /* synthetic */ DriveSdkServiceImpl d;

    public final void onFailure(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("DriveSdkServiceImpl", "requestMyDriveFileList retry failed, token[" + this.a + "], loadMoreLabel[" + this.b + ']', r4);
        b r0 = this.c;
        String r5 = r4.getMessage();
        if (r5 != null) goto L5;
        r5 = "";
    L5:
        r0.onError(r5);
    }

    public final void onSuccess(Object r4) {
        DocumentListInfo r5 = (DocumentListInfo) r4;
        Intrinsics.checkNotNullParameter(r5, "result");
        FLogger.a.i("DriveSdkServiceImpl", "requestMyDriveFileList retry succeeded, token[" + this.a + "], loadMoreLabel[" + this.b + ']');
        b r0 = this.c;
        if (r5.isHasMore() == false) goto L5;
        String r1 = r5.getLastLabel();
    L6:
        r0.a(r1, DriveSdkServiceImpl.Z(this.d, r5));
        return;
    L5:
        r1 = null;
        goto L6
    }

    public i(String r1, String r2, b r3, DriveSdkServiceImpl r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
