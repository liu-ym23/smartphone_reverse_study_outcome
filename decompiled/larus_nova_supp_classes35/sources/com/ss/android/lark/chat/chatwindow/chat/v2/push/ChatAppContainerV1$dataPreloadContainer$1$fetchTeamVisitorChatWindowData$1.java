package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV1$dataPreloadContainer$1", f = "ChatAppContainerV1.kt", i = {}, l = {263}, m = "fetchTeamVisitorChatWindowData-0E7RQCE", n = {}, s = {})
public final class ChatAppContainerV1$dataPreloadContainer$1$fetchTeamVisitorChatWindowData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatAppContainerV1$dataPreloadContainer$1 this$0;

    public ChatAppContainerV1$dataPreloadContainer$1$fetchTeamVisitorChatWindowData$1(ChatAppContainerV1$dataPreloadContainer$1 r1, Continuation<? super ChatAppContainerV1$dataPreloadContainer$1$fetchTeamVisitorChatWindowData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= PluginList.LEVEL_NOT_SET;
        Object r4 = this.this$0.a(null, 0, this);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Result.box-impl(r4);
    }
}
