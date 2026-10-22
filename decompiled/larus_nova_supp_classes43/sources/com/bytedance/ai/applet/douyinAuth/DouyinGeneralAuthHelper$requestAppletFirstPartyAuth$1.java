package com.bytedance.ai.applet.douyinAuth;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.douyinAuth.DouyinGeneralAuthHelper", f = "DouyinGeneralAuthHelper.kt", i = {0, 0, 0, 0, 0, 0, 0}, l = {441}, m = "requestAppletFirstPartyAuth", n = {"clientKey", "scope", "trackInfo", "config", "authTaskSession", "aiAbility", "isMiniApplication"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "Z$0"})
public final class DouyinGeneralAuthHelper$requestAppletFirstPartyAuth$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DouyinGeneralAuthHelper this$0;

    public DouyinGeneralAuthHelper$requestAppletFirstPartyAuth$1(DouyinGeneralAuthHelper r1, Continuation<? super DouyinGeneralAuthHelper$requestAppletFirstPartyAuth$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.d(null, null, null, null, null, null, null, this);
    }
}
