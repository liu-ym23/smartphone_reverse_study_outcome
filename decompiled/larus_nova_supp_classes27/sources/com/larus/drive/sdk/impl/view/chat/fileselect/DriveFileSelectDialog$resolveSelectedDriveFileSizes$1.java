package com.larus.drive.sdk.impl.view.chat.fileselect;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.chat.fileselect.DriveFileSelectDialog", f = "DriveFileSelectDialog.kt", i = {0, 0, 0}, l = {697}, m = "resolveSelectedDriveFileSizes", n = {"selectedList", "resolvedList", "item"}, s = {"L$0", "L$1", "L$3"})
final class DriveFileSelectDialog$resolveSelectedDriveFileSizes$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DriveFileSelectDialog this$0;

    public DriveFileSelectDialog$resolveSelectedDriveFileSizes$1(DriveFileSelectDialog r1, Continuation<? super DriveFileSelectDialog$resolveSelectedDriveFileSizes$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DriveFileSelectDialog.T90(this.this$0, null, this);
    }
}
