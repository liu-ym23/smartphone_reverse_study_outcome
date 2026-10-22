package com.larus.uaigc.createpage.bussiness.remove;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.bussiness.remove.ImageRemoveFragment", f = "ImageRemoveFragment.kt", i = {0, 0}, l = {972}, m = "ensureCreationSendConversation", n = {"config", "targetCvsId"}, s = {"L$0", "L$1"})
public final class ImageRemoveFragment$ensureCreationSendConversation$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ImageRemoveFragment this$0;

    public ImageRemoveFragment$ensureCreationSendConversation$1(ImageRemoveFragment r1, Continuation<? super ImageRemoveFragment$ensureCreationSendConversation$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ImageRemoveFragment r3 = this.this$0;
        int r0 = ImageRemoveFragment.v;
        return r3.W90(null, this);
    }
}
