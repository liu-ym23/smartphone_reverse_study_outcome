package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent", f = "ImageSelectorComponent.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {777, 801, 826}, m = "submitPassedRemoteResourceAccess", n = {"previewUrl", "rawUrl", "bitmap", "fileIdentifier", "previewUrl", "rawUrl", "bitmap", "fileIdentifier", "localFilePath"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4"})
final class ImageSelectorComponent$submitPassedRemoteResourceAccess$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageSelectorComponent this$0;

    public ImageSelectorComponent$submitPassedRemoteResourceAccess$1(ImageSelectorComponent r1, Continuation<? super ImageSelectorComponent$submitPassedRemoteResourceAccess$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ImageSelectorComponent.z3(this.this$0, null, null, null, this);
    }
}
