package com.bytedance.ai.applet.moa;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.moa.MoaExternalLoginGrantingStep", f = "MoaExternalLoginGrantingStep.kt", i = {0, 0, 0, 0, 0}, l = {219}, m = "requestMusicLogin", n = {"clientKey", "scopes", "state", "aiAbility", "traceInfo"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
public final class MoaExternalLoginGrantingStep$requestMusicLogin$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MoaExternalLoginGrantingStep this$0;

    public MoaExternalLoginGrantingStep$requestMusicLogin$1(MoaExternalLoginGrantingStep r1, Continuation<? super MoaExternalLoginGrantingStep$requestMusicLogin$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        MoaExternalLoginGrantingStep r11 = this.this$0;
        int r0 = MoaExternalLoginGrantingStep.d;
        return r11.f(null, this);
    }
}
