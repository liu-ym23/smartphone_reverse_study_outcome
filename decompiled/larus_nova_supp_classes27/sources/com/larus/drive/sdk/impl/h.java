package com.larus.drive.sdk.impl;

import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.larus.drive.biz.impl.viewmodel.r;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h implements a<SimpleRequestResult> {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ DriveSdkServiceImpl c;
    public final /* synthetic */ Function1<String, Unit> d;
    public final /* synthetic */ Function0<Unit> e;

    public final void onFailure(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("DriveSdkServiceImpl", "renameDriveFile failed, fileToken[" + this.a + "], driveObjType[" + this.b + ']', r4);
        if (DriveSdkServiceImpl.X(this.c, r4) == false) goto L5;
        String r5 = "error_message_drive_update";
    L6:
        Function1<String, Unit> r0 = this.d;
        if (r0 == null) goto L12;
        if (r5 != null) goto L10;
        r5 = "";
    L10:
        r0.invoke(r5);
        return;
    L12:
        return;
    L5:
        r5 = r4.getMessage();
        goto L6
    }

    public final void onSuccess(Object r7) {
        SimpleRequestResult r8 = (SimpleRequestResult) r7;
        Intrinsics.checkNotNullParameter(r8, "result");
        if (((Result) r8).code != 0) goto L7;
        FLogger.a.i("DriveSdkServiceImpl", "renameDriveFile succeeded, fileToken[" + this.a + "], driveObjType[" + this.b + ']');
        Function0<Unit> r9 = this.e;
        if (r9 == null) goto L17;
        r9.invoke();
        return;
    L17:
        return;
    L7:
        FLogger.a.e("DriveSdkServiceImpl", "renameDriveFile code != 0, fileToken[" + this.a + "], driveObjType[" + this.b + "], code[" + ((Result) r8).code + ']');
        DriveSdkServiceImpl r0 = this.c;
        int r1 = ((Result) r8).code;
        int r2 = DriveSdkServiceImpl.l;
        r0.getClass();
        if (DriveSdkServiceImpl.D0(r1) == false) goto L10;
        String r10 = "error_message_drive_update";
    L11:
        Function1<String, Unit> r3 = this.d;
        if (r3 == null) goto L19;
        if (r10 != null) goto L15;
        r10 = "";
    L15:
        r3.invoke(r10);
        return;
    L19:
        return;
    L10:
        r10 = ((Result) r8).msg;
        goto L11
    }

    public h(String r1, int r2, DriveSdkServiceImpl r3, r r4, com.larus.drive.biz.impl.viewmodel.q r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
