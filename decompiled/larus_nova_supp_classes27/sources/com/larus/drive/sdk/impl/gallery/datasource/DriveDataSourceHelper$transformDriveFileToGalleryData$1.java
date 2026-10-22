package com.larus.drive.sdk.impl.gallery.datasource;

import com.larus.dora.api.annotation.VUIWakeMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.gallery.datasource.DriveDataSourceHelper", f = "DriveDataSourceHelper.kt", i = {}, l = {VUIWakeMode.SILENT_LAUNCH}, m = "transformDriveFileToGalleryData", n = {}, s = {})
public final class DriveDataSourceHelper$transformDriveFileToGalleryData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DriveDataSourceHelper this$0;

    public DriveDataSourceHelper$transformDriveFileToGalleryData$1(DriveDataSourceHelper r1, Continuation<? super DriveDataSourceHelper$transformDriveFileToGalleryData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.b(null, this);
    }
}
