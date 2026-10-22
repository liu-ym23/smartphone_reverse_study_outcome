package com.bytedance.ai.applet.domain;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.domain.AppletDomainPolicyManager", f = "AppletDomainPolicyManager.kt", i = {0, 0, 0}, l = {271}, m = "fetchPolicyOnce-0E7RQCE", n = {"appKey", "existing", "deferred"}, s = {"L$0", "L$1", "L$2"})
public final class AppletDomainPolicyManager$fetchPolicyOnce$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletDomainPolicyManager this$0;

    public AppletDomainPolicyManager$fetchPolicyOnce$1(AppletDomainPolicyManager r1, Continuation<? super AppletDomainPolicyManager$fetchPolicyOnce$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        AppletDomainPolicyManager r11 = this.this$0;
        AppletDomainPolicyManager r0 = AppletDomainPolicyManager.a;
        Object r12 = r11.g(null, null, this);
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r12;
    L6:
        return Result.box-impl(r12);
    }
}
