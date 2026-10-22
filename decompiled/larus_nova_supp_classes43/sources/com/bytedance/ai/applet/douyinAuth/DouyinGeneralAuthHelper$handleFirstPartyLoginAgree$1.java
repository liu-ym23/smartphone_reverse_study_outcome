package com.bytedance.ai.applet.douyinAuth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper", f = "DouyinGeneralAuthHelper.kt", i = {0, 0, 0}, l = {217}, m = "handleFirstPartyLoginAgree", n = {"appMeta", "authTaskSession", "messageId"}, s = {"L$0", "L$1", "L$2"})
public final class DouyinGeneralAuthHelper$handleFirstPartyLoginAgree$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DouyinGeneralAuthHelper this$0;

    public DouyinGeneralAuthHelper$handleFirstPartyLoginAgree$1(DouyinGeneralAuthHelper r1, Continuation<? super DouyinGeneralAuthHelper$handleFirstPartyLoginAgree$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.c(null, null, null, null, this);
    }
}
