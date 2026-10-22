package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.core.extension.ChatCoreRuntimeProvider;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatAppContainerV2$dataPreloadContainer$1 implements x {
    public final /* synthetic */ ChatAppContainerV2 a;

    public ChatAppContainerV2$dataPreloadContainer$1(ChatAppContainerV2 r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.x
    public final Object c(fxa.b r5, Continuation<? super Result<? extends i7b.a>> r6) {
        if ((r6 instanceof ChatAppContainerV2$dataPreloadContainer$1$fetchChatData$1) == false) goto L7;
        ChatAppContainerV2$dataPreloadContainer$1$fetchChatData$1 r0 = (ChatAppContainerV2$dataPreloadContainer$1$fetchChatData$1) r6;
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
        com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d r8 = this.a.J;
        w3b.a r4 = new w3b.a(r5);
        r0.label = 1;
        Object r9 = r8.B6(r4, r0);
        if (r9 != r2) goto L18;
        return r2;
    L18:
        return r9;
    L7:
        r0 = new ChatAppContainerV2$dataPreloadContainer$1$fetchChatData$1(this, r6);
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.x
    public final Object a(String r5, int r6, Continuation<? super Result<? extends ChatMessageResponse>> r7) {
        if ((r7 instanceof ChatAppContainerV2$dataPreloadContainer$1$fetchTeamVisitorChatWindowData$1) == false) goto L7;
        ChatAppContainerV2$dataPreloadContainer$1$fetchTeamVisitorChatWindowData$1 r0 = (ChatAppContainerV2$dataPreloadContainer$1$fetchTeamVisitorChatWindowData$1) r7;
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
        com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d r4 = this.a.J;
        r0.label = 1;
        Object r10 = r9.b(r4, r5, r6, r0);
        if (r10 != r2) goto L18;
        return r2;
    L18:
        return r10;
    L7:
        r0 = new ChatAppContainerV2$dataPreloadContainer$1$fetchTeamVisitorChatWindowData$1(this, r7);
        goto L8
    }

    @Override // com.ss.android.lark.chat.chatwindow.chat.v2.push.x
    public final Object b(String r5, int r6, Continuation<? super Result<? extends ChatMessageResponse>> r7) {
        if ((r7 instanceof ChatAppContainerV2$dataPreloadContainer$1$fetchChatWindowData$1) == false) goto L7;
        ChatAppContainerV2$dataPreloadContainer$1$fetchChatWindowData$1 r0 = (ChatAppContainerV2$dataPreloadContainer$1$fetchChatWindowData$1) r7;
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
        com.ss.android.lark.chat.chatwindow.chat.preloaderv2.d r9 = this.a.J;
        w3b.b r4 = new w3b.b(r5, r6);
        r0.label = 1;
        Object r10 = r9.B6(r4, r0);
        if (r10 != r2) goto L18;
        return r2;
    L18:
        return r10;
    L7:
        r0 = new ChatAppContainerV2$dataPreloadContainer$1$fetchChatWindowData$1(this, r7);
        goto L8
    }
}
