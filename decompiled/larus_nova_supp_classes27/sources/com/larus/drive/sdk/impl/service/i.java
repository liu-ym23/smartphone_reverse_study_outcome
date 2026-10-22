package com.larus.drive.sdk.impl.service;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.utils.logger.FLogger;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i implements nc5.a<SimpleRequestResult> {
    public final /* synthetic */ DriveFileItem a;
    public final /* synthetic */ DriveFileServiceDelegate b;
    public final /* synthetic */ v79.c<SimpleRequestResult> c;
    public final /* synthetic */ String d;

    public final void onFailure(Throwable r5) {
        Intrinsics.checkNotNullParameter(r5, "error");
        FLogger.a.e("DriveFileServiceDelegate", "[renameDriveFile] Rename failed; objToken=" + this.a.b + ", objType=" + this.a.d, r5);
        this.b.getClass();
        if ((r5 instanceof NetService.HttpErrorException) == false) goto L5;
        NetService.HttpErrorException r0 = (NetService.HttpErrorException) r5;
    L6:
        boolean r1 = false;
        if (r0 == null) goto L10;
        r1 = CollectionsKt.listOf(new Integer[]{672020010, 672020011, 900004230}).contains(Integer.valueOf(r0.getCode()));
    L10:
        if (r1 == false) goto L12;
        String r6 = "error_message_drive_update";
    L13:
        v79.c<SimpleRequestResult> r2 = this.c;
        if (r6 != null) goto L16;
        r6 = "";
    L16:
        r2.onFailure(r6);
        return;
    L12:
        r6 = r5.getMessage();
        goto L13
    L5:
        r0 = null;
        goto L6
    }

    public final void onSuccess(Object r4) {
        SimpleRequestResult r5 = (SimpleRequestResult) r4;
        Intrinsics.checkNotNullParameter(r5, "result");
        FLogger.a.i("DriveFileServiceDelegate", "[renameDriveFile] Rename succeeded; objToken=" + this.a.b + ", objType=" + this.a.d);
        this.c.onSuccess(r5);
        this.b.getClass();
        s79.a r6 = ((e89.b) t.h.getValue()).a();
        if (r6 == null) goto L6;
        r6.b(this.a.b, this.d);
        return;
    }

    public i(DriveFileItem r1, DriveFileServiceDelegate r2, com.larus.drive.sdk.impl.utils.t.a r3, String r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
