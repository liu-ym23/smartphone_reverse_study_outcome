package com.larus.contextwindow.impl.membership;

import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.contextwindow.impl.membership.MembershipQuotaRepository", f = "MembershipQuotaRepository.kt", i = {0}, l = {92}, m = "requestMembershipQuota", n = {"request"}, s = {"L$0"})
public final class MembershipQuotaRepository$requestMembershipQuota$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MembershipQuotaRepository this$0;

    public MembershipQuotaRepository$requestMembershipQuota$1(MembershipQuotaRepository r1, Continuation<? super MembershipQuotaRepository$requestMembershipQuota$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        MembershipQuotaRepository r3 = this.this$0;
        Lazy<MembershipQuotaRepository> r0 = MembershipQuotaRepository.k;
        return r3.e(false, this);
    }
}
