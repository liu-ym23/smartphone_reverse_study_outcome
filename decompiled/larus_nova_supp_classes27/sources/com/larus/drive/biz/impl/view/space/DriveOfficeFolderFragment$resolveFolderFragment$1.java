package com.larus.drive.biz.impl.view.space;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.biz.impl.view.space.DriveOfficeFolderFragment", f = "DriveOfficeFolderFragment.kt", i = {0, 0}, l = {534}, m = "resolveFolderFragment", n = {"request", "officeSdkService"}, s = {"L$0", "L$1"})
final class DriveOfficeFolderFragment$resolveFolderFragment$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DriveOfficeFolderFragment this$0;

    public DriveOfficeFolderFragment$resolveFolderFragment$1(DriveOfficeFolderFragment r1, Continuation<? super DriveOfficeFolderFragment$resolveFolderFragment$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DriveOfficeFolderFragment.S90(this.this$0, null, this);
    }
}
