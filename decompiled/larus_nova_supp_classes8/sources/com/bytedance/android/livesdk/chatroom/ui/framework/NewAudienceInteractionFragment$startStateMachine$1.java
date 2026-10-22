package com.bytedance.android.livesdk.chatroom.ui.framework;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0082@"}, d2 = {"Lkotlin/coroutines/Continuation;", "", "continuation", "", "startStateMachine"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.livesdk.chatroom.ui.framework.NewAudienceInteractionFragment", f = "NewAudienceInteractionFragment.kt", i = {0}, l = {319, 320}, m = "startStateMachine", n = {"this"}, s = {"L$0"})
final class NewAudienceInteractionFragment$startStateMachine$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NewAudienceInteractionFragment this$0;

    public NewAudienceInteractionFragment$startStateMachine$1(NewAudienceInteractionFragment r1, Continuation r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return NewAudienceInteractionFragment.S90(this.this$0, this);
    }
}
