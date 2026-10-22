package com.bytedance.ai.applet.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.domain.AppletDomainPolicyManager", f = "AppletDomainPolicyManager.kt", i = {0, 0, 0}, l = {173}, m = "ensureSocketAllowed", n = {com.bytedance.android.ec.core.event.a.KEY_URL, "normalizedAppKey", "origin"}, s = {"L$0", "L$1", "L$2"})
public final class AppletDomainPolicyManager$ensureSocketAllowed$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppletDomainPolicyManager this$0;

    public AppletDomainPolicyManager$ensureSocketAllowed$1(AppletDomainPolicyManager r1, Continuation<? super AppletDomainPolicyManager$ensureSocketAllowed$1> r10) {
        this.this$0 = r1;
        super(r10);
    }

    public final Object invokeSuspend(Object r10) {
        this.result = r10;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.e(null, null, this);
    }
}
