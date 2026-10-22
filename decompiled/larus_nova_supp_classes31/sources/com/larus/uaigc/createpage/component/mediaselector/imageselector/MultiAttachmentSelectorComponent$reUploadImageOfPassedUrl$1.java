package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent", f = "MultiAttachmentSelectorComponent.kt", i = {0, 0, 0, 0, 0}, l = {3982, 4010}, m = "reUploadImageOfPassedUrl", n = {"resourceKey", "bitmap", "uploaderIdentifier", "isPrivate", "isAvatar"}, s = {"L$0", "L$1", "L$2", "Z$0", "Z$1"})
public final class MultiAttachmentSelectorComponent$reUploadImageOfPassedUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$reUploadImageOfPassedUrl$1(MultiAttachmentSelectorComponent r1, Continuation<? super MultiAttachmentSelectorComponent$reUploadImageOfPassedUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        MultiAttachmentSelectorComponent r0 = this.this$0;
        int r8 = MultiAttachmentSelectorComponent.Z;
        return r0.h5(null, null, false, false, this);
    }
}
