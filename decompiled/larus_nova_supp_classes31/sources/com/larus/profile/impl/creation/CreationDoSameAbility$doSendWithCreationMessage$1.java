package com.larus.profile.impl.creation;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.creation.CreationDoSameAbility", f = "CreationDoSameAbility.kt", i = {}, l = {2801}, m = "doSendWithCreationMessage", n = {}, s = {})
final class CreationDoSameAbility$doSendWithCreationMessage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreationDoSameAbility this$0;

    public CreationDoSameAbility$doSendWithCreationMessage$1(CreationDoSameAbility r1, Continuation<? super CreationDoSameAbility$doSendWithCreationMessage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return CreationDoSameAbility.e(this.this$0, null, this);
    }
}
