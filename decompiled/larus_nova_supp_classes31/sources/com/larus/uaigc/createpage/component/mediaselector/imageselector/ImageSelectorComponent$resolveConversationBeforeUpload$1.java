package com.larus.uaigc.createpage.component.mediaselector.imageselector;

import com.tencent.open.log.TraceLevel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.mediaselector.imageselector.ImageSelectorComponent", f = "ImageSelectorComponent.kt", i = {}, l = {2342}, m = "resolveConversationBeforeUpload", n = {}, s = {})
public final class ImageSelectorComponent$resolveConversationBeforeUpload$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageSelectorComponent this$0;

    public ImageSelectorComponent$resolveConversationBeforeUpload$1(ImageSelectorComponent r1, Continuation<? super ImageSelectorComponent$resolveConversationBeforeUpload$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ImageSelectorComponent r3 = this.this$0;
        Lazy<Long> r0 = ImageSelectorComponent.X;
        return r3.W4(this);
    }
}
