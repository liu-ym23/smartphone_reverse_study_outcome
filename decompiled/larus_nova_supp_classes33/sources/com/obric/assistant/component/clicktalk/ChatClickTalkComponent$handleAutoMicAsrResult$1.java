package com.obric.assistant.component.clicktalk;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.component.clicktalk.ChatClickTalkComponent", f = "ChatClickTalkComponent.kt", i = {0, 0, 0, 0, 0, 0}, l = {2029}, m = "handleAutoMicAsrResult", n = {"autoMicService", "historyContent", "quitFun", "polishContent", "levelOneFailButLevelTwoPassThenNeedCheckRelavance", "start$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0", "J$0"})
public final class ChatClickTalkComponent$handleAutoMicAsrResult$1 extends ContinuationImpl {
    int I$0;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatClickTalkComponent this$0;

    public ChatClickTalkComponent$handleAutoMicAsrResult$1(ChatClickTalkComponent r1, Continuation<? super ChatClickTalkComponent$handleAutoMicAsrResult$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r7) {
        this.result = r7;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.rP(null, null, null, false, this);
    }
}
