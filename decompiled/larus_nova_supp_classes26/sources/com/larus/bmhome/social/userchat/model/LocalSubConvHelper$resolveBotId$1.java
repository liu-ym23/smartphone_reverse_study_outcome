package com.larus.bmhome.social.userchat.model;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.social.userchat.model.LocalSubConvHelper", f = "LocalSubConvHelper.kt", i = {}, l = {153, 156}, m = "resolveBotId", n = {}, s = {})
public final class LocalSubConvHelper$resolveBotId$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocalSubConvHelper this$0;

    public LocalSubConvHelper$resolveBotId$1(LocalSubConvHelper r1, Continuation<? super LocalSubConvHelper$resolveBotId$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.f(null, this);
    }
}
