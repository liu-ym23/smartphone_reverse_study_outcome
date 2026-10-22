package com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.preloaderv2.loader.ChatDataPreLoaderV2", f = "ChatDataPreLoaderV2.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2}, l = {45, 49, 53}, m = "preLoadData-gIAlu-s", n = {"task", "chatId", "messageId", "task", "chatId", "errorResult", "task", "chatId", "errorResult"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2"})
public final class ChatDataPreLoaderV2$preLoadData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatDataPreLoaderV2 this$0;

    public ChatDataPreLoaderV2$preLoadData$1(ChatDataPreLoaderV2 r1, Continuation<? super ChatDataPreLoaderV2$preLoadData$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        Object r3 = this.this$0.d(null, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
