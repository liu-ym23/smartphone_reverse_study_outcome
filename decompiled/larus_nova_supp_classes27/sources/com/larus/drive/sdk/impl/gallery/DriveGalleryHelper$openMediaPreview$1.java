package com.larus.drive.sdk.impl.gallery;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.gallery.DriveGalleryHelper", f = "DriveGalleryHelper.kt", i = {0}, l = {194}, m = "openMediaPreview", n = {"galleryContext"}, s = {"L$0"})
final class DriveGalleryHelper$openMediaPreview$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DriveGalleryHelper this$0;

    public DriveGalleryHelper$openMediaPreview$1(DriveGalleryHelper r1, Continuation<? super DriveGalleryHelper$openMediaPreview$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return DriveGalleryHelper.a(this.this$0, null, this);
    }
}
