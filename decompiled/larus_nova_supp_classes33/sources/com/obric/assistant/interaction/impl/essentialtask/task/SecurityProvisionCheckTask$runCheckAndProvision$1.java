package com.obric.assistant.interaction.impl.essentialtask.task;

import com.obric.cae.libs.useraware.ApWakeEvent;
import com.obric.capabilitykit.common.ErrorCode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.task.SecurityProvisionCheckTask", f = "SecurityProvisionCheckTask.kt", i = {0}, l = {ErrorCode.REGISTER_ERROR, ApWakeEvent.WALKING_START}, m = "runCheckAndProvision", n = {"securityProvisionChecker"}, s = {"L$0"})
public final class SecurityProvisionCheckTask$runCheckAndProvision$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SecurityProvisionCheckTask this$0;

    public SecurityProvisionCheckTask$runCheckAndProvision$1(SecurityProvisionCheckTask r1, Continuation<? super SecurityProvisionCheckTask$runCheckAndProvision$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return SecurityProvisionCheckTask.access$runCheckAndProvision(this.this$0, this);
    }
}
