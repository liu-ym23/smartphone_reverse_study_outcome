package com.larus.voice_setting.voice.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.voice_setting.voice.utils.OpenBotHelper", f = "OpenBotHelper.kt", i = {0, 0, 0}, l = {89, 102, 122}, m = "findConversationIdByBot", n = {"botInfo", "botId", "createRemoteConversation"}, s = {"L$0", "L$1", "Z$0"})
public final class OpenBotHelper$findConversationIdByBot$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OpenBotHelper this$0;

    public OpenBotHelper$findConversationIdByBot$1(OpenBotHelper r1, Continuation<? super OpenBotHelper$findConversationIdByBot$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        OpenBotHelper r4 = this.this$0;
        OpenBotHelper r0 = OpenBotHelper.a;
        return r4.b(null, false, this);
    }
}
