package com.larus.dora.impl.guide.service;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.guide.service.GuideSession", f = "DoraGuideServiceImpl.kt", i = {}, l = {646}, m = "dismissSafe", n = {}, s = {})
final class GuideSession$dismissSafe$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GuideSession this$0;

    public GuideSession$dismissSafe$1(GuideSession r1, Continuation<? super GuideSession$dismissSafe$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return GuideSession.a(this.this$0, null, this);
    }
}
