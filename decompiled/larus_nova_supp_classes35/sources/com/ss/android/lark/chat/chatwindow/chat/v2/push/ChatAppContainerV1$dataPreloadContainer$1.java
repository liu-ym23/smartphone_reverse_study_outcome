package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.chatwindow.chat.perload.ExtensionKt;
import com.ss.android.lark.chat.core.extension.ChatCoreRuntimeProvider;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatAppContainerV1$dataPreloadContainer$1 implements x {
    public ChatAppContainerV1$dataPreloadContainer$1() {
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.x
    public final Object c(fxa.b r5, Continuation<? super Result<? extends i7b.a>> r6) {
        if ((r6 instanceof ChatAppContainerV1$dataPreloadContainer$1$fetchChatData$1) == false) goto L7;
        ChatAppContainerV1$dataPreloadContainer$1$fetchChatData$1 r0 = (ChatAppContainerV1$dataPreloadContainer$1$fetchChatData$1) r6;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
        return ((Result) r7).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        com.ss.android.lark.chat.chatwindow.chat.perload.c r8 = com.ss.android.lark.chat.chatwindow.chat.perload.c.a.a;
        r0.label = 1;
        Object r9 = ExtensionKt.a(r8, r5, r0);
        if (r9 != r2) goto L18;
        return r2;
    L18:
        return r9;
    L7:
        r0 = new ChatAppContainerV1$dataPreloadContainer$1$fetchChatData$1(this, r6);
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.x
    public final Object a(String r5, int r6, Continuation<? super Result<? extends ChatMessageResponse>> r7) {
        if ((r7 instanceof ChatAppContainerV1$dataPreloadContainer$1$fetchTeamVisitorChatWindowData$1) == false) goto L7;
        ChatAppContainerV1$dataPreloadContainer$1$fetchTeamVisitorChatWindowData$1 r0 = (ChatAppContainerV1$dataPreloadContainer$1$fetchTeamVisitorChatWindowData$1) r7;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
        return ((Result) r8).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        ChatCoreRuntimeProvider r9 = ChatCoreRuntimeProvider.a;
        r0.label = 1;
        Object r10 = r9.f(r5, r6, r0);
        if (r10 != r2) goto L18;
        return r2;
    L18:
        return r10;
    L7:
        r0 = new ChatAppContainerV1$dataPreloadContainer$1$fetchTeamVisitorChatWindowData$1(this, r7);
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.x
    public final Object b(String r5, int r6, Continuation<? super Result<? extends ChatMessageResponse>> r7) {
        if ((r7 instanceof ChatAppContainerV1$dataPreloadContainer$1$fetchChatWindowData$1) == false) goto L7;
        ChatAppContainerV1$dataPreloadContainer$1$fetchChatWindowData$1 r0 = (ChatAppContainerV1$dataPreloadContainer$1$fetchChatWindowData$1) r7;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r8);
        return ((Result) r8).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r8);
        com.ss.android.lark.chat.chatwindow.chat.perload.c r9 = com.ss.android.lark.chat.chatwindow.chat.perload.c.a.a;
        r0.label = 1;
        Object r10 = ExtensionKt.b(r9, r5, r6, r0);
        if (r10 != r2) goto L18;
        return r2;
    L18:
        return r10;
    L7:
        r0 = new ChatAppContainerV1$dataPreloadContainer$1$fetchChatWindowData$1(this, r7);
        goto L8
    }
}
