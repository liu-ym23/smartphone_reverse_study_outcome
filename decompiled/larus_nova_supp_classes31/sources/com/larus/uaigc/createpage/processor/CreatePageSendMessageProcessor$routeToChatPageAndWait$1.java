package com.larus.uaigc.createpage.processor;

import com.tencent.open.log.TraceLevel;
import java.util.Set;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.processor.CreatePageSendMessageProcessor", f = "CreatePageSendMessageProcessor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {407, 446, 448, 450}, m = "routeToChatPageAndWait", n = {"onSendParams", "localPath", "instructionParam", "data", "instructionPrompt", "messageExt", "creationSendTraceId", "hasImagePreprocessed", "shouldUseHostRoute", "shouldOpenNativeChatBelowHost", "openInSideBar"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "Z$0", "Z$1", "I$0", "Z$2"})
public final class CreatePageSendMessageProcessor$routeToChatPageAndWait$1 extends ContinuationImpl {
    int I$0;
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

    public CreatePageSendMessageProcessor$routeToChatPageAndWait$1(CreatePageSendMessageProcessor r1, Continuation<? super CreatePageSendMessageProcessor$routeToChatPageAndWait$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r11) {
        this.result = r11;
        this.label |= Integer.MIN_VALUE;
        CreatePageSendMessageProcessor r0 = this.this$0;
        Set<String> r12 = CreatePageSendMessageProcessor.h;
        return r0.o(null, null, null, null, null, false, null, null, this);
    }
}
