package com.larus.bmhome.view.actionbar.custom;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.view.actionbar.custom.ActionBarServiceImpl", f = "ActionBarServiceImpl.kt", i = {0}, l = {182, 185}, m = "getMainBotConversationInfo", n = {"callback"}, s = {"L$0"})
final class ActionBarServiceImpl$getMainBotConversationInfo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ActionBarServiceImpl this$0;

    public ActionBarServiceImpl$getMainBotConversationInfo$1(ActionBarServiceImpl r1, Continuation<? super ActionBarServiceImpl$getMainBotConversationInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return ActionBarServiceImpl.o(this.this$0, null, this);
    }
}
