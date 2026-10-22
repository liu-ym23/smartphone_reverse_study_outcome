package com.larus.bmhome.chat.trace;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.ChatControlTrace", f = "ChatControlTrace.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {2678, 2754}, m = "onStreamResultInternal", n = {"conversation", "msg", "errResult", "botType", "multiQuestionCount", "$this$onStreamResultInternal_u24lambda_u24163", "receiveRecord", "instructionType", "actionBarKey", "isActionBar", "actionBarOptionInfo", "botId", "duration", "handleTimeAver", "receiveTimeAver", "isAppDownloadLink", "isSoftLink", "startTime", "conversation", "msg", "errResult", "botType", "multiQuestionCount", "$this$onStreamResultInternal_u24lambda_u24163", "instructionType", "actionBarKey", "isActionBar", "actionBarOptionInfo", "botId", "voice", "params", "actionBarUsrMsg", "chatType", "linkType", "containerEcommerce", "sheetService", "bitableService", "docService", "floatPercent", "driveFile", "isDriveFloatChat", "firstButtonBlock", "clarifyId", "resolvedMessageType", "handleTimeAver", "receiveTimeAver", "isAppDownloadLink", "isSoftLink", "mobDuration"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "J$0", "J$1", "J$2", "I$0", "I$1", "J$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$9", "L$10", "L$11", "L$12", "L$13", "L$14", "L$15", "L$16", "L$17", "L$18", "L$19", "L$20", "L$21", "L$22", "L$23", "L$24", "L$25", "J$0", "J$1", "I$0", "I$1", "J$2"})
public final class ChatControlTrace$onStreamResultInternal$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    long J$0;
    long J$1;
    long J$2;
    long J$3;
    long J$4;
    long J$5;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
    Object L$15;
    Object L$16;
    Object L$17;
    Object L$18;
    Object L$19;
    Object L$2;
    Object L$20;
    Object L$21;
    Object L$22;
    Object L$23;
    Object L$24;
    Object L$25;
    Object L$26;
    Object L$27;
    Object L$28;
    Object L$29;
    Object L$3;
    Object L$30;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatControlTrace this$0;

    public ChatControlTrace$onStreamResultInternal$1(ChatControlTrace r1, Continuation<? super ChatControlTrace$onStreamResultInternal$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r12) {
        this.result = r12;
        this.label |= Integer.MIN_VALUE;
        ChatControlTrace r0 = this.this$0;
        ChatControlTrace r13 = ChatControlTrace.b;
        return r0.Y(null, null, null, null, null, null, 0, null, this);
    }
}
