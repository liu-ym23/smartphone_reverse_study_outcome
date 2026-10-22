package com.larus.drive.sdk.impl;

import com.larus.drive.biz.impl.viewmodel.a0;
import com.larus.drive.biz.impl.viewmodel.z;
import com.larus.utils.logger.FLogger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import nc5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g implements a<Boolean> {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ DriveSdkServiceImpl c;
    public final /* synthetic */ Function1<String, Unit> d;
    public final /* synthetic */ Function0<Unit> e;

    public final void onFailure(Throwable r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("DriveSdkServiceImpl", "moveDriveFile failed, fileToken[" + this.a + "], parentFolderToken[" + this.b + ']', r4);
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

    public final void onSuccess(Object r6) {
        if (((Boolean) r6).booleanValue() == false) goto L7;
        FLogger.a.i("DriveSdkServiceImpl", "moveDriveFile succeeded, fileToken[" + this.a + "], parentFolderToken[" + this.b + ']');
        Function0<Unit> r7 = this.e;
        if (r7 == null) goto L11;
        r7.invoke();
        return;
    L11:
        return;
    L7:
        FLogger.a.e("DriveSdkServiceImpl", "moveDriveFile failed, fileToken[" + this.a + "], parentFolderToken[" + this.b + ']');
        Function1<String, Unit> r8 = this.d;
        if (r8 == null) goto L13;
        r8.invoke("");
        return;
    }

    public g(String r1, String r2, DriveSdkServiceImpl r3, a0 r4, z r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
