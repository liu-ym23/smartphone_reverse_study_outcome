package com.larus.drive.sdk.impl.view.chat.fileselect;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.DriveFileSelectDialog", f = "DriveFileSelectDialog.kt", i = {0}, l = {735}, m = "resolveDriveFileSize", n = {"fileToken"}, s = {"L$0"})
public final class DriveFileSelectDialog$resolveDriveFileSize$2 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DriveFileSelectDialog this$0;

    public DriveFileSelectDialog$resolveDriveFileSize$2(DriveFileSelectDialog r1, Continuation<? super DriveFileSelectDialog$resolveDriveFileSize$2> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        DriveFileSelectDialog r0 = this.this$0;
        int r8 = DriveFileSelectDialog.t;
        return r0.Y90(null, 0, 0, this);
    }
}
