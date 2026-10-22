package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.MultiAttachmentSelectorComponent", f = "MultiAttachmentSelectorComponent.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {3942, 3971, 3975}, m = "explainResourceUrl", n = {"resourceKey", "url", "bitmap", "identifier", "resourceId", "localFilePath", "isPrivate", "isAvatar"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0", "Z$1"})
final class MultiAttachmentSelectorComponent$explainResourceUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    boolean Z$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiAttachmentSelectorComponent this$0;

    public MultiAttachmentSelectorComponent$explainResourceUrl$1(MultiAttachmentSelectorComponent r1, Continuation<? super MultiAttachmentSelectorComponent$explainResourceUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        return MultiAttachmentSelectorComponent.N2(this.this$0, null, null, null, null, null, null, false, false, this);
    }
}
