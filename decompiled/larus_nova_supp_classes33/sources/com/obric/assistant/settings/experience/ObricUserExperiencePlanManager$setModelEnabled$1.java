package com.obric.assistant.settings.experience;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.settings.experience.ObricUserExperiencePlanManager", f = "ObricUserExperiencePlanManager.kt", i = {0, 0, 1, 1, 1}, l = {246, 204}, m = "setModelEnabled", n = {"$this$withLock_u24default$iv", "enabled", "$this$withLock_u24default$iv", "accountUid", "enabled"}, s = {"L$0", "Z$0", "L$0", "L$1", "Z$0"})
public final class ObricUserExperiencePlanManager$setModelEnabled$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricUserExperiencePlanManager this$0;

    public ObricUserExperiencePlanManager$setModelEnabled$1(ObricUserExperiencePlanManager r1, Continuation<? super ObricUserExperiencePlanManager$setModelEnabled$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.i(false, this);
    }
}
