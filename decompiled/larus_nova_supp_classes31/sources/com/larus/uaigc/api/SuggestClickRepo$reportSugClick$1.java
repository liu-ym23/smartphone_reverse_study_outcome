package com.larus.uaigc.api;

import com.larus.platform.api.creation.UserCreationType;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.api.SuggestClickRepo", f = "SuggestClickRepo.kt", i = {}, l = {UserCreationType.RefAudio2Video}, m = "reportSugClick", n = {}, s = {})
public final class SuggestClickRepo$reportSugClick$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SuggestClickRepo this$0;

    public SuggestClickRepo$reportSugClick$1(SuggestClickRepo r1, Continuation<? super SuggestClickRepo$reportSugClick$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(null, null, this);
    }
}
