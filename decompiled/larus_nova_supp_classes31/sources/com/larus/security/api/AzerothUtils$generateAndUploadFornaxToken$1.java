package com.larus.security.api;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.security.api.AzerothUtils", f = "AzerothUtils.kt", i = {0, 0, 0, 0, 0, 0}, l = {75}, m = "generateAndUploadFornaxToken", n = {"curMsg", "dislikeDetailType", "detailContent", "msgId", "sectionId", "source"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"})
public final class AzerothUtils$generateAndUploadFornaxToken$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AzerothUtils this$0;

    public AzerothUtils$generateAndUploadFornaxToken$1(AzerothUtils r1, Continuation<? super AzerothUtils$generateAndUploadFornaxToken$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, 0, null, null, this);
    }
}
