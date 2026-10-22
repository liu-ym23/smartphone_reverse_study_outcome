package com.larus.bmhome.upload.instant;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.upload.instant.ImageInstantUploadStrategy", f = "ImageInstantUploadStrategy.kt", i = {0}, l = {351}, m = "toResourceUploadResult", n = {"registerInfo"}, s = {"L$0"})
public final class ImageInstantUploadStrategy$toResourceUploadResult$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageInstantUploadStrategy this$0;

    public ImageInstantUploadStrategy$toResourceUploadResult$1(ImageInstantUploadStrategy r1, Continuation<? super ImageInstantUploadStrategy$toResourceUploadResult$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ImageInstantUploadStrategy r3 = this.this$0;
        ImageInstantUploadStrategy r0 = ImageInstantUploadStrategy.a;
        return r3.n(null, null, null, this);
    }
}
