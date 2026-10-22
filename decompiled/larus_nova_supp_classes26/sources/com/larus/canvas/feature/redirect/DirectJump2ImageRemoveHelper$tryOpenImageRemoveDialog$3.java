package com.larus.canvas.feature.redirect;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.redirect.DirectJump2ImageRemoveHelper", f = "DirectJump2ImageRemoveHelper.kt", i = {}, l = {104}, m = "tryOpenImageRemoveDialog", n = {}, s = {})
public final class DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$3 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DirectJump2ImageRemoveHelper this$0;

    public DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$3(DirectJump2ImageRemoveHelper r1, Continuation<? super DirectJump2ImageRemoveHelper$tryOpenImageRemoveDialog$3> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        DirectJump2ImageRemoveHelper r3 = this.this$0;
        DirectJump2ImageRemoveHelper r0 = DirectJump2ImageRemoveHelper.a;
        return r3.a(null, null, this);
    }
}
