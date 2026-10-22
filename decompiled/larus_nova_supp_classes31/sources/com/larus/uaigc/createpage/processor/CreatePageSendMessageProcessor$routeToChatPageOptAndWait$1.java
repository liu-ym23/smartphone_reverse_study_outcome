package com.larus.uaigc.createpage.processor;

import com.tencent.open.log.TraceLevel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.processor.CreatePageSendMessageProcessor", f = "CreatePageSendMessageProcessor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4}, l = {472, 474, 490, 493, 503, 541, 543, 545}, m = "routeToChatPageOptAndWait", n = {"onSendParams", "data", "sendConfigData", "creationSendTraceId", "mainBotId", "hasImagePreprocessed", "shouldUseHostRoute", "shouldOpenNativeChatBelowHost", "openInSideBar", "isFromChatDoubleTemplate", "onSendParams", "data", "sendConfigData", "creationSendTraceId", "sendConversation", "hasImagePreprocessed", "shouldUseHostRoute", "shouldOpenNativeChatBelowHost", "openInSideBar", "isFromChatDoubleTemplate", "onSendParams", "data", "sendConfigData", "creationSendTraceId", "sendConversation", "targetBotId", "sendMessageConf", "hasImagePreprocessed", "shouldUseHostRoute", "shouldOpenNativeChatBelowHost", "openInSideBar", "onSendParams", "data", "sendConfigData", "creationSendTraceId", "sendConversation", "targetBotId", "sendMessageConf", "hasImagePreprocessed", "shouldUseHostRoute", "shouldOpenNativeChatBelowHost", "openInSideBar", "onSendParams", "data", "sendConfigData", "creationSendTraceId", "sendConversation", "targetBotId", "sendMessageConf", "hasImagePreprocessed", "shouldUseHostRoute", "shouldOpenNativeChatBelowHost", "openInSideBar"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "Z$1", "I$0", "Z$2", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "Z$0", "Z$1", "I$0", "Z$2", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "Z$1", "I$0", "Z$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "Z$1", "I$0", "Z$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "Z$1", "I$0", "Z$2"})
public final class CreatePageSendMessageProcessor$routeToChatPageOptAndWait$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreatePageSendMessageProcessor this$0;

    public CreatePageSendMessageProcessor$routeToChatPageOptAndWait$1(CreatePageSendMessageProcessor r1, Continuation<? super CreatePageSendMessageProcessor$routeToChatPageOptAndWait$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r8) {
        this.result = r8;
        this.label |= Integer.MIN_VALUE;
        CreatePageSendMessageProcessor r0 = this.this$0;
        Set<String> r9 = CreatePageSendMessageProcessor.h;
        return r0.q(null, null, null, false, null, this);
    }
}
