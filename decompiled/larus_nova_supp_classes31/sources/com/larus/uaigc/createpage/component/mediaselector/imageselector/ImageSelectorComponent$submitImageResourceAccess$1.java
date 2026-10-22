package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent", f = "ImageSelectorComponent.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {2208}, m = "submitImageResourceAccess", n = {"localPath", "fileInfo", "sourceUri", "uploadSourceScene", "preprocessSubScene", "perfParentScene", "onPreprocessedLocalPathReady", "fileIdentifier", "successCallback", "failedCallback", "pipelineEnabled"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "Z$0"})
public final class ImageSelectorComponent$submitImageResourceAccess$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageSelectorComponent this$0;

    public ImageSelectorComponent$submitImageResourceAccess$1(ImageSelectorComponent r1, Continuation<? super ImageSelectorComponent$submitImageResourceAccess$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r12) {
        this.result = r12;
        this.label |= Integer.MIN_VALUE;
        ImageSelectorComponent r0 = this.this$0;
        Lazy<Long> r13 = ImageSelectorComponent.X;
        return r0.i5(null, null, null, null, null, null, null, null, null, this);
    }
}
