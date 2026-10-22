package com.ss.android.lark.chat.chatwindow.chat.perload;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.chatwindow.chat.perload.ExtensionKt", f = "Extension.kt", i = {0, 0, 0, 0}, l = {63}, m = "fetchChatWindowData", n = {"chatId", "$this$fetchChatWindowData_u24lambda_u243", "$completion$iv", "position"}, s = {"L$0", "L$1", "L$2", "I$0"})
public final class ExtensionKt$fetchChatWindowData$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;

    public ExtensionKt$fetchChatWindowData$1(Continuation<? super ExtensionKt$fetchChatWindowData$1> r1) {
        super(r1);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= PluginList.LEVEL_NOT_SET;
        Object r3 = ExtensionKt.b(null, null, 0, this);
        if (r3 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r3;
    L6:
        return Result.box-impl(r3);
    }
}
