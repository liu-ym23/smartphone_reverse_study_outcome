package com.larus.drive.sdk.impl.gallery.datasource;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.gallery.datasource.DriveDataSourceHelper", f = "DriveDataSourceHelper.kt", i = {0, 0, 1, 1}, l = {26, 46}, m = "convertToGalleryData", n = {"file", "galleryService", "file", "galleryService"}, s = {"L$0", "L$1", "L$0", "L$1"})
public final class DriveDataSourceHelper$convertToGalleryData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DriveDataSourceHelper this$0;

    public DriveDataSourceHelper$convertToGalleryData$1(DriveDataSourceHelper r1, Continuation<? super DriveDataSourceHelper$convertToGalleryData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        DriveDataSourceHelper r3 = this.this$0;
        DriveDataSourceHelper r0 = DriveDataSourceHelper.a;
        return r3.a(null, this);
    }
}
