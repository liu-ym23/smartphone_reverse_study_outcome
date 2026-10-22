package com.bytedance.ai.applet.moa;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaExternalLoginGrantingStep", f = "MoaExternalLoginGrantingStep.kt", i = {}, l = {114}, m = "requestFirstPartyLogin", n = {}, s = {})
public final class MoaExternalLoginGrantingStep$requestFirstPartyLogin$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MoaExternalLoginGrantingStep this$0;

    public MoaExternalLoginGrantingStep$requestFirstPartyLogin$1(MoaExternalLoginGrantingStep r1, Continuation<? super MoaExternalLoginGrantingStep$requestFirstPartyLogin$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        MoaExternalLoginGrantingStep r11 = this.this$0;
        int r0 = MoaExternalLoginGrantingStep.d;
        return r11.e(null, this);
    }
}
