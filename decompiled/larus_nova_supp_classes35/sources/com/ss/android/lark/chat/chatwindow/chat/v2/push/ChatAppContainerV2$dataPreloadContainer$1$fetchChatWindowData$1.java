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
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV2$dataPreloadContainer$1", f = "ChatAppContainerV2.kt", i = {}, l = {251}, m = "fetchChatWindowData-0E7RQCE", n = {}, s = {})
public final class ChatAppContainerV2$dataPreloadContainer$1$fetchChatWindowData$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatAppContainerV2$dataPreloadContainer$1 this$0;

    public ChatAppContainerV2$dataPreloadContainer$1$fetchChatWindowData$1(ChatAppContainerV2$dataPreloadContainer$1 r1, Continuation<? super ChatAppContainerV2$dataPreloadContainer$1$fetchChatWindowData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= PluginList.LEVEL_NOT_SET;
        Object r4 = this.this$0.b(null, 0, this);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Result.box-impl(r4);
    }
}
