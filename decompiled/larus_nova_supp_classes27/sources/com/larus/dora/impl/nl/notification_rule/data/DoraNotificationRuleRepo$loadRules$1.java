package com.larus.dora.impl.nl.notification_rule.data;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.nl.notification_rule.data.DoraNotificationRuleRepo", f = "DoraNotificationRuleRepo.kt", i = {0}, l = {27}, m = "loadRules-IoAF18A", n = {"uid"}, s = {"L$0"})
public final class DoraNotificationRuleRepo$loadRules$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ DoraNotificationRuleRepo this$0;

    public DoraNotificationRuleRepo$loadRules$1(DoraNotificationRuleRepo r1, Continuation<? super DoraNotificationRuleRepo$loadRules$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        Object r3 = this.this$0.e(this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
