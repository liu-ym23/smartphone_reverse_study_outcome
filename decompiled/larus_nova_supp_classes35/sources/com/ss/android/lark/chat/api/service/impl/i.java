package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.CreateAddChatChatterApplyRequest;
import com.bytedance.lark.pb.im.v1.CreateChatLastReadPositionRequest;
import com.bytedance.lark.pb.im.v1.GetChatChatterKickRequest;
import com.bytedance.lark.pb.im.v1.HideChatTranslatedNameRequest;
import com.bytedance.lark.pb.im.v1.MGetChatsRequest;
import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.bytedance.lark.pb.im.v1.TranslateChatNameRequest;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.name.ChatNameRenderer$doHideTranslate$1;
import com.ss.android.lark.chat.name.ChatNameRenderer$doTranslate$1;
import com.ss.android.lark.sdk.SdkSender;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements a2b.a {
    public i() {
    }

    @Override // a2b.a
    public final Map a(MGetChatsRequest.Builder r3, a0 r4) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        Intrinsics.checkNotNullParameter(r4, "respMap");
        return (Map) SdkSender.syncSend(Command.MGET_CHATS, r3, new f(r4));
    }

    @Override // a2b.a
    public final com.ss.android.lark.chat.entity.chat.b b(GetChatChatterKickRequest.Builder r3, t r4) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        Intrinsics.checkNotNullParameter(r4, "respMap");
        return (com.ss.android.lark.chat.entity.chat.b) SdkSender.sendRequest(Command.GET_CHAT_CHATTER_KICK_INFO, r3, new b(r4));
    }

    @Override // a2b.a
    public final Map f(MGetChatsRequest.Builder r3, v r4) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        Intrinsics.checkNotNullParameter(r4, "respMap");
        return (Map) SdkSender.sendRequest(Command.MGET_CHATS, r3, new g(r4));
    }

    @Override // a2b.a
    public final void h(CreateChatLastReadPositionRequest.Builder r3, w r4) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        Intrinsics.checkNotNullParameter(r4, "respMap");
        SdkSender.asynSendRequestNonWrap(Command.CREATE_CHAT_LAST_READ_POSITION, r3, null, new d(r4));
    }

    @Override // a2b.a
    public final void c(CreateAddChatChatterApplyRequest.Builder r3, x r4, IGetDataCallback r5) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        Intrinsics.checkNotNullParameter(r4, "respMap");
        SdkSender.asynSendRequestNonWrap(Command.CREATE_ADD_CHAT_CHATTER_APPLY, r3, r5, new a(r4));
    }

    @Override // a2b.a
    public final void d(HideChatTranslatedNameRequest.Builder r3, r r4, ChatNameRenderer$doHideTranslate$1 r5) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        Intrinsics.checkNotNullParameter(r4, "respMap");
        SdkSender.asynSendRequestNonWrap(Command.HIDE_CHAT_TRANSLATED_NAME, r3, r5, new c(r4));
    }

    @Override // a2b.a
    public final void e(SubscribeChatEventRequest.Builder r3, b0 r4, IGetDataCallback r5) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        Intrinsics.checkNotNullParameter(r4, "respMap");
        SdkSender.asynSendRequestNonWrap(Command.SUBSCRIBE_CHAT_EVENT, r3, r5, new e(r4));
    }

    @Override // a2b.a
    public final void g(TranslateChatNameRequest.Builder r3, e0 r4, ChatNameRenderer$doTranslate$1 r5) {
        Intrinsics.checkNotNullParameter(r3, "builder");
        Intrinsics.checkNotNullParameter(r4, "respMap");
        SdkSender.asynSendRequestNonWrap(Command.TRANSLATE_CHAT_NAME, r3, r5, new h(r4));
    }
}
