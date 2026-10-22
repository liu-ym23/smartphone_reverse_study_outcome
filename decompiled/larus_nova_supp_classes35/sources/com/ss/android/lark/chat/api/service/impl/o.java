package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.CreateAddChatChatterApplyRequest;
import com.bytedance.lark.pb.im.v1.CreateAddChatChatterApplyResponse;
import com.bytedance.lark.pb.im.v1.CreateChatLastReadPositionRequest;
import com.bytedance.lark.pb.im.v1.CreateChatLastReadPositionResponse;
import com.bytedance.lark.pb.im.v1.GetChatChatterKickRequest;
import com.bytedance.lark.pb.im.v1.GetChatChatterKickResponse;
import com.bytedance.lark.pb.im.v1.HideChatTranslatedNameRequest;
import com.bytedance.lark.pb.im.v1.HideChatTranslatedNameResponse;
import com.bytedance.lark.pb.im.v1.MGetChatsRequest;
import com.bytedance.lark.pb.im.v1.MGetChatsResponse;
import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.bytedance.lark.pb.im.v1.SubscribeChatEventResponse;
import com.bytedance.lark.pb.im.v1.TranslateChatNameRequest;
import com.bytedance.lark.pb.im.v1.TranslateChatNameResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.name.ChatNameRenderer$doHideTranslate$1;
import com.ss.android.lark.chat.name.ChatNameRenderer$doTranslate$1;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.Observable;
import java.util.Map;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class o implements a2b.a {
    public final com.bytedance.lark.rustclient.api.l a;

    @Inject
    public o(com.bytedance.lark.rustclient.api.l r2) {
        Intrinsics.checkNotNullParameter(r2, "userClient");
        this.a = r2;
    }

    @Override // a2b.a
    public final Map a(MGetChatsRequest.Builder r11, final a0 r12) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMap");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, MGetChatsResponse.ADAPTER, Command.MGET_CHATS, null, null, null, null, 248);
        return (Map) com.bytedance.lark.rustclient.api.t.c(com.bytedance.lark.rustclient.api.t.e(this.a.h(r0).execute(), new ChatRepositoryV2$syncGetChats$1(r12)), null);
    }

    @Override // a2b.a
    public final com.ss.android.lark.chat.entity.chat.b b(GetChatChatterKickRequest.Builder r11, final t r12) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMap");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, GetChatChatterKickResponse.ADAPTER, Command.GET_CHAT_CHATTER_KICK_INFO, null, null, null, null, 248);
        return (com.ss.android.lark.chat.entity.chat.b) com.bytedance.lark.rustclient.api.t.c(com.bytedance.lark.rustclient.api.t.e((com.bytedance.lark.rustclient.api.s) this.a.h(r0).a().blockingFirst(), new ChatRepositoryV2$getChatterKickInfo$1(r12)), null);
    }

    @Override // a2b.a
    public final Map f(MGetChatsRequest.Builder r11, final v r12) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMap");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, MGetChatsResponse.ADAPTER, Command.MGET_CHATS, null, null, null, null, 248);
        return (Map) com.bytedance.lark.rustclient.api.t.c(com.bytedance.lark.rustclient.api.t.e((com.bytedance.lark.rustclient.api.s) this.a.h(r0).a().blockingFirst(), new ChatRepositoryV2$syncGetChatsFromNet$1(r12)), null);
    }

    @Override // a2b.a
    public final void h(CreateChatLastReadPositionRequest.Builder r11, w r12) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMap");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, CreateChatLastReadPositionResponse.ADAPTER, Command.CREATE_CHAT_LAST_READ_POSITION, null, null, null, null, 248);
        Observable r13 = this.a.h(r0).a().map(new l(r12));
        Intrinsics.checkNotNullParameter(r13, "<this>");
        r13.subscribe(new com.ss.android.lark.im.sdk.utils.c(null), new com.ss.android.lark.im.sdk.utils.d(null));
    }

    @Override // a2b.a
    public final void c(CreateAddChatChatterApplyRequest.Builder r11, x r12, IGetDataCallback r13) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMap");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, CreateAddChatChatterApplyResponse.ADAPTER, Command.CREATE_ADD_CHAT_CHATTER_APPLY, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.b(this.a.h(r0).a().map(new j(r12)), r13);
    }

    @Override // a2b.a
    public final void d(HideChatTranslatedNameRequest.Builder r11, r r12, ChatNameRenderer$doHideTranslate$1 r13) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMap");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, HideChatTranslatedNameResponse.ADAPTER, Command.HIDE_CHAT_TRANSLATED_NAME, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.b(this.a.h(r0).a().map(new k(r12)), r13);
    }

    @Override // a2b.a
    public final void e(SubscribeChatEventRequest.Builder r11, b0 r12, IGetDataCallback r13) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMap");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, SubscribeChatEventResponse.ADAPTER, Command.SUBSCRIBE_CHAT_EVENT, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.b(this.a.h(r0).a().map(new m(r12)), r13);
    }

    @Override // a2b.a
    public final void g(TranslateChatNameRequest.Builder r11, e0 r12, ChatNameRenderer$doTranslate$1 r13) {
        Intrinsics.checkNotNullParameter(r11, "builder");
        Intrinsics.checkNotNullParameter(r12, "respMap");
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r11, TranslateChatNameResponse.ADAPTER, Command.TRANSLATE_CHAT_NAME, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.b(this.a.h(r0).a().map(new n(r12)), r13);
    }
}
