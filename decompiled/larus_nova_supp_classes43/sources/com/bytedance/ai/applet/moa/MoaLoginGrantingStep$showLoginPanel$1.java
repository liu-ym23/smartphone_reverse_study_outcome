package com.bytedance.ai.applet.moa;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaLoginGrantingStep", f = "MoaLoginGrantingStep.kt", i = {}, l = {422}, m = "showLoginPanel", n = {}, s = {})
public final class MoaLoginGrantingStep$showLoginPanel$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MoaLoginGrantingStep this$0;

    public MoaLoginGrantingStep$showLoginPanel$1(MoaLoginGrantingStep r1, Continuation<? super MoaLoginGrantingStep$showLoginPanel$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        MoaLoginGrantingStep r11 = this.this$0;
        int r0 = MoaLoginGrantingStep.m;
        return r11.o(this);
    }
}
