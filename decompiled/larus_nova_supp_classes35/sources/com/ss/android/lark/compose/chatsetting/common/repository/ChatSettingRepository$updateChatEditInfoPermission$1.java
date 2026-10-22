package com.ss.android.lark.compose.chatsetting.common.repository;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.common.repository.ChatSettingRepository", f = "ChatSettingRepository.kt", i = {0}, l = {316}, m = "updateChatEditInfoPermission-0E7RQCE", n = {"chatId"}, s = {"L$0"})
public final class ChatSettingRepository$updateChatEditInfoPermission$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatSettingRepository this$0;

    public ChatSettingRepository$updateChatEditInfoPermission$1(ChatSettingRepository r1, Continuation<? super ChatSettingRepository$updateChatEditInfoPermission$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= PluginList.LEVEL_NOT_SET;
        Object r4 = this.this$0.q(null, false, this);
        if (r4 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r4;
    L6:
        return Result.box-impl(r4);
    }
}
