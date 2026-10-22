package com.obric.assistant.feedback.voc;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.feedback.voc.VocApiKt", f = "VocApi.kt", i = {}, l = {53}, m = "submitVocRequest", n = {}, s = {})
public final class VocApiKt$submitVocRequest$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;

    public VocApiKt$submitVocRequest$1(Continuation<? super VocApiKt$submitVocRequest$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return VocApiKt.a(null, null, 0, null, null, this);
    }
}
