package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent", f = "ImageSelectorComponent.kt", i = {0}, l = {1900}, m = "prepareAlbumUploadingUi", n = {"delayJob"}, s = {"L$0"})
final class ImageSelectorComponent$prepareAlbumUploadingUi$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageSelectorComponent this$0;

    public ImageSelectorComponent$prepareAlbumUploadingUi$1(ImageSelectorComponent r1, Continuation<? super ImageSelectorComponent$prepareAlbumUploadingUi$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return ImageSelectorComponent.m3(this.this$0, null, false, this);
    }
}
