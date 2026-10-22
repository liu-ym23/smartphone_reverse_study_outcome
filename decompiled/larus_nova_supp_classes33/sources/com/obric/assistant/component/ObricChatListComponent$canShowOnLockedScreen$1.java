package com.obric.assistant.component;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.ObricChatListComponent", f = "ObricChatListComponent.kt", i = {0, 1, 1}, l = {353, 355}, m = "canShowOnLockedScreen", n = {"msgId", "msgId", "msg"}, s = {"L$0", "L$0", "L$1"})
public final class ObricChatListComponent$canShowOnLockedScreen$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricChatListComponent this$0;

    public ObricChatListComponent$canShowOnLockedScreen$1(ObricChatListComponent r1, Continuation<? super ObricChatListComponent$canShowOnLockedScreen$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.Dp(null, this);
    }
}
