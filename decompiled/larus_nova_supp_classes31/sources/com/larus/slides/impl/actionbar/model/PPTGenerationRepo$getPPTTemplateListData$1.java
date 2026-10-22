package com.larus.slides.impl.actionbar.model;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.impl.actionbar.model.PPTGenerationRepo", f = "PPTGenerationRepo.kt", i = {}, l = {TraceLevel.ERROR}, m = "getPPTTemplateListData", n = {}, s = {})
public final class PPTGenerationRepo$getPPTTemplateListData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PPTGenerationRepo this$0;

    public PPTGenerationRepo$getPPTTemplateListData$1(PPTGenerationRepo r1, Continuation<? super PPTGenerationRepo$getPPTTemplateListData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.a(0, 0, this);
    }
}
