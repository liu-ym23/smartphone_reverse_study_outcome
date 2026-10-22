package com.larus.drive.sdk.api.gallery.datasource;

import com.larus.dora.impl.core.DoraLinkServiceStopReason;
import com.larus.drive.sdk.api.file.DriveFileItem;
import com.larus.drive.sdk.impl.gallery.datasource.DriveDataSourceHelper;
import com.larus.gallery.api.b0;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.api.gallery.datasource.BaseDriveDataSource", f = "BaseDriveDataSource.kt", i = {}, l = {DoraLinkServiceStopReason.DEVICE_IS_EMPTY}, m = "loadInitial$suspendImpl", n = {}, s = {})
final class BaseDriveDataSource$loadInitial$1<T> extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ a<T> this$0;

    public BaseDriveDataSource$loadInitial$1(a<T> r1, Continuation<? super BaseDriveDataSource$loadInitial$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r6) {
        this.result = r6;
        int r7 = this.label | Integer.MIN_VALUE;
        this.label = r7;
        a<T> r1 = this.this$0;
        if ((r7 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r7 - Integer.MIN_VALUE;
        BaseDriveDataSource$loadInitial$1<T> r8 = this;
    L6:
        Object r0 = r8.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        if (r3 == 0) goto L12;
        if (r3 != 1) goto L11;
        ResultKt.throwOnFailure(r0);
    L15:
        List r4 = (List) r0;
        if (r4 != null) goto L19;
        r4 = CollectionsKt.emptyList();
    L19:
        return new b0.b(r4, false, false, 6);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r0);
        DriveFileItem r5 = r1.a;
        r8.label = 1;
        r0 = DriveDataSourceHelper.a.b(r5, r8);
        if (r0 != r2) goto L15;
        return r2;
    L5:
        r8 = new BaseDriveDataSource$loadInitial$1(r1, this);
        goto L6
    }
}
