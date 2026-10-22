package com.ss.android.lark.im.sdk.service;

import android.text.TextUtils;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.ContactSource;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.im.v1.ChatChatterKickInfo;
import com.bytedance.lark.pb.im.v1.CheckChattersInChatRequest;
import com.bytedance.lark.pb.im.v1.CheckChattersInChatResponse;
import com.bytedance.lark.pb.im.v1.CreateChatRequest;
import com.bytedance.lark.pb.im.v1.CreateChatResponse;
import com.bytedance.lark.pb.im.v1.CreateP2PChatSource;
import com.bytedance.lark.pb.im.v1.CreateP2PChatsRequest;
import com.bytedance.lark.pb.im.v1.CreateP2PChatsResponse;
import com.bytedance.lark.pb.im.v1.GetChatChatterKickRequest;
import com.bytedance.lark.pb.im.v1.GetChatChatterKickResponse;
import com.bytedance.lark.pb.im.v1.GetP2PChatsByChatterIdsRequest;
import com.bytedance.lark.pb.im.v1.GetP2PChatsByChatterIdsResponse;
import com.bytedance.lark.pb.im.v1.MGetChatsRequest;
import com.bytedance.lark.pb.im.v1.MGetChatsResponse;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.biz.im.api.ProfileSource;
import com.ss.android.lark.chat.api.service.impl.ChatService;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.utils.z0;
import com.ss.android.lark.im.sdk.utils.ExtensionsKt$toErrorIfNull$1;
import com.ss.android.lark.integrator.im.impl.ChatApiImpl$selectMessagesFromChat$1;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@UserScope
public final class f implements ImSdkChatService {
    public final String a;
    public final com.bytedance.lark.rustclient.api.l b;

    public static final class a {
    }

    public static final class b<T, R> implements Function {
        public final /* synthetic */ f a;

        public b(f r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            com.bytedance.lark.rustclient.api.s r4 = (com.bytedance.lark.rustclient.api.s) r3;
            Intrinsics.checkNotNullParameter(r4, "r");
            final f r1 = this.a;
            return com.bytedance.lark.rustclient.api.t.e(r4, new ImSdkChatServiceImplV2$asyncGetChats$1$1(r1));
        }
    }

    public static final class c<T, R> implements Function {
        public static final c<T, R> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final Object apply(Object r2) {
            com.bytedance.lark.rustclient.api.s r3 = (com.bytedance.lark.rustclient.api.s) r2;
            Intrinsics.checkNotNullParameter(r3, "r");
            return com.bytedance.lark.rustclient.api.t.e(r3, ImSdkChatServiceImplV2$checkChattersInChat$1$1.INSTANCE);
        }
    }

    public static final class d<T, R> implements Function {
        public final /* synthetic */ f a;

        public d(f r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            com.bytedance.lark.rustclient.api.s r4 = (com.bytedance.lark.rustclient.api.s) r3;
            Intrinsics.checkNotNullParameter(r4, "r");
            final f r1 = this.a;
            return com.bytedance.lark.rustclient.api.t.e(r4, new ImSdkChatServiceImplV2$createP2pChat$1$1(r1));
        }
    }

    public static final class e<T, R> implements Function {
        public static final e<T, R> a = null;

        static {
            a = new e();
        }

        public e() {
        }

        public final Object apply(Object r2) {
            com.bytedance.lark.rustclient.api.s r3 = (com.bytedance.lark.rustclient.api.s) r2;
            Intrinsics.checkNotNullParameter(r3, "r");
            return com.bytedance.lark.rustclient.api.t.e(r3, ImSdkChatServiceImplV2$createP2pChats$1$1.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.im.sdk.service.f$f, reason: collision with other inner class name */
    public static final class C0086f<T, R> implements Function {
        public final /* synthetic */ f a;

        public C0086f(f r1) {
            this.a = r1;
        }

        public final Object apply(Object r2) {
            com.bytedance.lark.rustclient.api.x r3 = (com.bytedance.lark.rustclient.api.x) r2;
            Intrinsics.checkNotNullParameter(r3, "it");
            f r0 = this.a;
            MGetChatsResponse r4 = (MGetChatsResponse) r3.c;
            r0.getClass();
            return f.c(r4);
        }
    }

    static {
    }

    public static Map c(MGetChatsResponse r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Entity r0 = r2.entity;
        return com.ss.android.lark.parser.internal.h.d(r0.chats, r2.chat_option_info, r0.mail_setting);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat B2(String r3) {
        Intrinsics.checkNotNullParameter(r3, "chatId");
        return (Chat) ((Map) ((com.bytedance.lark.rustclient.api.x) com.bytedance.lark.rustclient.api.t.b(a(CollectionsKt.listOf(r3), SyncDataStrategy.FORCE_SERVER)).blockingFirst()).c).get(r3);
    L5:
        th = move-exception;
        Log.e("ImSdkChatServiceImplV2", "getServerChat failed， error:" + th.getMessage());
        return null;
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final com.ss.android.lark.chat.entity.chat.b I0(String r11) {
        Intrinsics.checkNotNullParameter(r11, "chatId");
        GetChatChatterKickRequest.Builder r2 = new GetChatChatterKickRequest.Builder().chat_id(r11);
        Intrinsics.checkNotNull(r2);
        com.bytedance.lark.rustclient.api.d r12 = new com.bytedance.lark.rustclient.api.d(r2, GetChatChatterKickResponse.ADAPTER, Command.GET_CHAT_CHATTER_KICK_INFO, null, null, null, null, 248);
        GetChatChatterKickResponse r13 = (GetChatChatterKickResponse) com.bytedance.lark.rustclient.api.t.c(this.b.h(r12).execute(), null);
        if (r13 == null) goto L8;
        ChatChatterKickInfo r14 = r13.chat_chatter_kick_info;
        if (r14 != null) goto L7;
        return null;
    L7:
        return new com.ss.android.lark.chat.entity.chat.b(r14.chat_id, r14.reason);
    L8:
        return null;
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat getLocalChat(String r12) {
        Intrinsics.checkNotNullParameter(r12, "chatId");
        List r0 = CollectionsKt.listOf(r12);
        Intrinsics.checkNotNullParameter(r0, "chatIds");
        SyncDataStrategy r1 = SyncDataStrategy.TRY_LOCAL;
        z0.a();
        List r2 = r0;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        Map r4 = MapsKt.emptyMap();
    L16:
        return (Chat) r4.get(r12);
    L11:
        MGetChatsRequest.Builder r5 = new MGetChatsRequest.Builder().chat_ids(r0).strategy(r1);
        Intrinsics.checkNotNull(r5);
        com.bytedance.lark.rustclient.api.d r6 = new com.bytedance.lark.rustclient.api.d(r5, MGetChatsResponse.ADAPTER, Command.MGET_CHATS, null, null, null, null, 248);
        MGetChatsResponse r7 = (MGetChatsResponse) com.bytedance.lark.rustclient.api.t.c(this.b.h(r6).execute(), null);
        if (r7 == null) goto L14;
        r4 = c(r7);
        goto L16
    L14:
        r4 = MapsKt.emptyMap();
        goto L16
    L5:
        if (r2.isEmpty() == true) goto L8;
        r3 = false;
        goto L9
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final String getOtherP2PChatterId(Chat r5) {
        Intrinsics.checkNotNullParameter(r5, "chat");
        if (r5.getType() == Chat.Type.P2P) goto L7;
        return null;
    L7:
        if (TextUtils.isEmpty(r5.getP2pChatterId()) == false) goto L9;
        String r6 = r5.getKey();
        List r7 = new Regex(":").split(r6, 0);
        ArrayList r0 = new ArrayList();
        Iterator r8 = r7.iterator();
    L12:
        if (r8.hasNext() == false) goto L19;
        Object r2 = r8.next();
        if (((String) r2).length() <= 0) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == false) goto L12;
        r0.add(r2);
        goto L12
    L16:
        r3 = false;
        goto L17
    L19:
        String[] r9 = (String[]) r0.toArray(new String[0]);
        Iterator r1 = CollectionsKt.listOf(Arrays.copyOf(r9, r9.length)).iterator();
    L21:
        if (r1.hasNext() == false) goto L26;
        String r4 = (String) r1.next();
        if (Intrinsics.areEqual(r4, this.a) == true) goto L21;
        return r4;
    L26:
        return r9[0];
    L9:
        return r5.getP2pChatterId();
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final com.ss.android.lark.chat.entity.chat.a nd(String r2) {
        com.ss.android.lark.chat.entity.chat.a r0 = b(r2, true);
        if (r0 == null) goto L6;
        return r0;
    L6:
        return b(r2, false);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat we(String r4) {
        Intrinsics.checkNotNullParameter(r4, "chatId");
        List<String> r0 = CollectionsKt.listOf(r4);
        Intrinsics.checkNotNullParameter(r0, "chatIds");
        Map r1 = (Map) ((com.bytedance.lark.rustclient.api.x) com.bytedance.lark.rustclient.api.t.b(a(r0, SyncDataStrategy.TRY_LOCAL)).blockingFirst()).c;     // Catch: Throwable -> L5
    L8:
        return (Chat) r1.get(r4);
    L5:
        th = move-exception;
        Log.e("ImSdkChatServiceImplV2", "getChats failed， error:" + th.getMessage());
        r1 = MapsKt.emptyMap();
        goto L8
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat xc(String r12) {
        Intrinsics.checkNotNullParameter(r12, "chatterId");
        GetP2PChatsByChatterIdsRequest.Builder r3 = new GetP2PChatsByChatterIdsRequest.Builder().chatter_ids(CollectionsKt.listOf(r12));
        Intrinsics.checkNotNull(r3);
        com.bytedance.lark.rustclient.api.d r0 = new com.bytedance.lark.rustclient.api.d(r3, GetP2PChatsByChatterIdsResponse.ADAPTER, Command.GET_P2P_CHATS_BY_CHATTER_IDS, null, null, null, null, 248);
        GetP2PChatsByChatterIdsResponse r1 = (GetP2PChatsByChatterIdsResponse) com.bytedance.lark.rustclient.api.t.c(this.b.h(r0).execute(), null);
        if (r1 == null) goto L8;
        Map r2 = r1.chatter_id2chat;
        if (r2.keySet().contains(r12) == true) goto L7;
        return null;
    L7:
        return com.ss.android.lark.parser.internal.h.a((com.bytedance.lark.pb.basic.v1.Chat) r2.get(r12), null);
    L8:
        return null;
    }

    @Inject
    public f(String r2, com.bytedance.lark.rustclient.api.l r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "userClient");
        this.a = r2;
        this.b = r3;
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final void C2(List<String> r11, IGetDataCallback<Map<String, Chat>> r12) {
        Intrinsics.checkNotNullParameter(r11, "chatterIds");
        Intrinsics.checkNotNullParameter(r12, "callback");
        CreateP2PChatsRequest.Builder r2 = new CreateP2PChatsRequest.Builder().chatter_ids(r11);
        Intrinsics.checkNotNull(r2);
        com.bytedance.lark.rustclient.api.d r13 = new com.bytedance.lark.rustclient.api.d(r2, CreateP2PChatsResponse.ADAPTER, Command.CREATE_P2P_CHATS, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.b(this.b.h(r13).a().map(e.a), r12);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final Chat P6(String r11, ImSdkChatService.Source r12) {
        Intrinsics.checkNotNullParameter(r11, "chatId");
        Intrinsics.checkNotNullParameter(r12, "source");
        MGetChatsRequest.Builder r2 = new MGetChatsRequest.Builder().chat_ids(CollectionsKt.mutableListOf(new String[]{r11})).strategy(SyncDataStrategy.FORCE_SERVER).should_auth(Boolean.TRUE).source(MGetChatsRequest.Source.fromValue(r12.getValue()));     // Catch: Throwable -> L5
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L5
        return (Chat) ((Map) com.bytedance.lark.rustclient.api.t.b(this.b.h(new com.bytedance.lark.rustclient.api.d(r2, MGetChatsResponse.ADAPTER, Command.MGET_CHATS, null, null, null, null, 248)).a()).map(new C0086f(this)).blockingFirst()).get(r11);
    L5:
        th = move-exception;
        Log.e("ImSdkChatServiceImplV2", "getServerChat failed， error:" + th.getMessage());
        return null;
    }

    public final Observable<com.bytedance.lark.rustclient.api.s<com.bytedance.lark.sdk.refactor.b, Map<String, Chat>>> a(List<String> r10, SyncDataStrategy r11) {
        MGetChatsRequest.Builder r1 = new MGetChatsRequest.Builder().chat_ids(r10).strategy(r11).should_auth(Boolean.TRUE);
        Intrinsics.checkNotNull(r1);
        com.bytedance.lark.rustclient.api.d r12 = new com.bytedance.lark.rustclient.api.d(r1, MGetChatsResponse.ADAPTER, Command.MGET_CHATS, null, null, null, null, 248);
        return this.b.h(r12).a().map(new b(this));
    }

    public final com.ss.android.lark.chat.entity.chat.a b(String r12, boolean r13) {
        z0.a();
        if (r12 != null) goto L5;
    L8:
        boolean r0 = true;
    L10:
        if (r0 == false) goto L12;
        return null;
    L12:
        MGetChatsRequest.Builder r1 = new MGetChatsRequest.Builder().chat_ids(CollectionsKt.listOf(r12));
        if (r13 == false) goto L15;
        SyncDataStrategy r14 = SyncDataStrategy.TRY_LOCAL;
    L16:
        MGetChatsRequest.Builder r3 = r1.strategy(r14);
        Intrinsics.checkNotNull(r3);
        com.bytedance.lark.rustclient.api.d r15 = new com.bytedance.lark.rustclient.api.d(r3, MGetChatsResponse.ADAPTER, Command.MGET_CHATS, null, null, null, null, 248);
        MGetChatsResponse r16 = (MGetChatsResponse) com.bytedance.lark.rustclient.api.t.c(this.b.h(r15).execute(), null);
        if (r16 != null) goto L19;
        return null;
    L19:
        return ChatService.j(r12, r16);
    L15:
        r14 = SyncDataStrategy.FORCE_SERVER;
        goto L16
    L5:
        if (r12.length() == 0) goto L8;
        r0 = false;
        goto L10
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final void uc(List r2, ChatApiImpl$selectMessagesFromChat$1 r3) {
        Intrinsics.checkNotNullParameter(r2, "chatIds");
        Intrinsics.checkNotNullParameter(r3, "callback");
        com.ss.android.lark.im.sdk.utils.e.b(a(r2, SyncDataStrategy.TRY_LOCAL).map(g.a), r3);
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final void X5(String r11, ImSdkChatService.a r12, final IGetDataCallback<Chat> r13) {
        Intrinsics.checkNotNullParameter(r11, "chatterId");
        Intrinsics.checkNotNullParameter(r13, "callback");
        if (r12 == null) goto L5;
        boolean r1 = r12.a;
    L6:
        if (r12 == null) goto L8;
        ProfileSource r14 = r12.b;
    L9:
        CreateChatRequest.Builder r2 = new CreateChatRequest.Builder().type(com.bytedance.lark.pb.basic.v1.Chat.Type.P2P).chatter_ids(CollectionUtils.asList(new String[]{r11, this.a})).is_crypto(Boolean.valueOf(r1)).chat_mode(com.bytedance.lark.pb.basic.v1.Chat.ChatMode.DEFAULT);
        if (r14 == null) goto L12;
        r2.create_p2p_chat_source(new CreateP2PChatSource.Builder().source_type(ContactSource.fromValue(r14.a)).sender_id_v2(r14.b).source_id(r14.c).source_name(r14.d).build());
    L12:
        Intrinsics.checkNotNull(r2);
        Observable r15 = this.b.h(new com.bytedance.lark.rustclient.api.d(r2, CreateChatResponse.ADAPTER, Command.CREATE_CHAT, null, null, null, null, 248)).a().map(new d(this));
        Intrinsics.checkNotNullParameter(r13, "<this>");
        com.ss.android.lark.im.sdk.utils.e.b(r15, new ExtensionsKt$toErrorIfNull$1(r13));
        return;
    L8:
        r14 = null;
        goto L9
    L5:
        r1 = false;
        goto L6
    }

    @Override // com.ss.android.lark.im.sdk.service.ImSdkChatService
    public final void Y6(List<String> r10, String r11, IGetDataCallback<Map<String, Boolean>> r12) {
        Intrinsics.checkNotNullParameter(r10, "chatterIds");
        Intrinsics.checkNotNullParameter(r11, "chatId");
        Intrinsics.checkNotNullParameter(r12, "callback");
        CheckChattersInChatRequest.Builder r1 = new CheckChattersInChatRequest.Builder().chat_id(r11).chatter_ids(r10);
        Intrinsics.checkNotNull(r1);
        com.bytedance.lark.rustclient.api.d r13 = new com.bytedance.lark.rustclient.api.d(r1, CheckChattersInChatResponse.ADAPTER, Command.CHECK_CHATTERS_IN_CHAT, null, null, null, null, 248);
        com.ss.android.lark.im.sdk.utils.e.b(this.b.h(r13).a().map(c.a), r12);
    }
}
