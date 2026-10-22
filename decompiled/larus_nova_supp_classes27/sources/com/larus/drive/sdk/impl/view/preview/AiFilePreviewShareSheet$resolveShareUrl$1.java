package com.larus.drive.sdk.impl.view.preview;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.view.preview.AiFilePreviewShareSheet", f = "AiFilePreviewShareSheet.kt", i = {}, l = {166}, m = "resolveShareUrl", n = {}, s = {})
final class AiFilePreviewShareSheet$resolveShareUrl$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AiFilePreviewShareSheet this$0;

    public AiFilePreviewShareSheet$resolveShareUrl$1(AiFilePreviewShareSheet r1, Continuation<? super AiFilePreviewShareSheet$resolveShareUrl$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return AiFilePreviewShareSheet.U90(this.this$0, null, this);
    }
}
