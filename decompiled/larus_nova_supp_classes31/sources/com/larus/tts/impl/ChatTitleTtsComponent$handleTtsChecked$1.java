package com.larus.tts.impl;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.tts.impl.ChatTitleTtsComponent", f = "ChatTitleTtsComponent.kt", i = {}, l = {910}, m = "handleTtsChecked", n = {}, s = {})
final class ChatTitleTtsComponent$handleTtsChecked$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatTitleTtsComponent this$0;

    public ChatTitleTtsComponent$handleTtsChecked$1(ChatTitleTtsComponent r1, Continuation<? super ChatTitleTtsComponent$handleTtsChecked$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r9) {
        this.result = r9;
        this.label |= Integer.MIN_VALUE;
        return ChatTitleTtsComponent.F2(this.this$0, false, null, null, false, null, null, this);
    }
}
