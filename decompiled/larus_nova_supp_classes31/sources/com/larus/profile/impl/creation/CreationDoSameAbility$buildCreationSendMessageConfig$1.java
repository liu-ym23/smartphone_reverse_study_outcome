package com.larus.profile.impl.creation;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationDoSameAbility", f = "CreationDoSameAbility.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {2815, 2816}, m = "buildCreationSendMessageConfig", n = {"sendParam", "doSameInitParams", "userCreation", "actionBarCreationType", "targetCvsId", "sendParam", "doSameInitParams", "userCreation", "actionBarCreationType", "targetCvsId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4"})
final class CreationDoSameAbility$buildCreationSendMessageConfig$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationDoSameAbility this$0;

    public CreationDoSameAbility$buildCreationSendMessageConfig$1(CreationDoSameAbility r1, Continuation<? super CreationDoSameAbility$buildCreationSendMessageConfig$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return CreationDoSameAbility.c(this.this$0, null, null, null, null, this);
    }
}
