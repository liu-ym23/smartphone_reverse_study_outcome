package com.larus.uaigc.instruction;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.instruction.MultiAttachmentSelectorWidget", f = "MultiAttachmentSelectorWidget.kt", i = {}, l = {538, 549, 567}, m = "handlePassedImageAlbumPathToResourceItem", n = {}, s = {})
final class MultiAttachmentSelectorWidget$handlePassedImageAlbumPathToResourceItem$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MultiAttachmentSelectorWidget this$0;

    public MultiAttachmentSelectorWidget$handlePassedImageAlbumPathToResourceItem$1(MultiAttachmentSelectorWidget r1, Continuation<? super MultiAttachmentSelectorWidget$handlePassedImageAlbumPathToResourceItem$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return MultiAttachmentSelectorWidget.C6(this.this$0, null, 0, this);
    }
}
