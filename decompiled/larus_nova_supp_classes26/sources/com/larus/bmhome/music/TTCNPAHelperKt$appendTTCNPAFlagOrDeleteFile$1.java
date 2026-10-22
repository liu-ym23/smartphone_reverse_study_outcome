package com.larus.bmhome.music;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.music.TTCNPAHelperKt", f = "TTCNPAHelper.kt", i = {0}, l = {31}, m = "appendTTCNPAFlagOrDeleteFile", n = {"filePath"}, s = {"L$0"})
public final class TTCNPAHelperKt$appendTTCNPAFlagOrDeleteFile$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;

    public TTCNPAHelperKt$appendTTCNPAFlagOrDeleteFile$1(Continuation<? super TTCNPAHelperKt$appendTTCNPAFlagOrDeleteFile$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return TTCNPAHelperKt.b(null, null, this);
    }
}
