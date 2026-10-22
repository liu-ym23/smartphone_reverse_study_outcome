package com.obric.assistant.onelogin;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.onelogin.ObricOneLoginActivity", f = "ObricOneLoginActivity.kt", i = {}, l = {275, 277}, m = "awaitForSettingsReady", n = {}, s = {})
final class ObricOneLoginActivity$awaitForSettingsReady$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricOneLoginActivity this$0;

    public ObricOneLoginActivity$awaitForSettingsReady$1(ObricOneLoginActivity r1, Continuation<? super ObricOneLoginActivity$awaitForSettingsReady$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ObricOneLoginActivity.N1(this.this$0, this);
    }
}
