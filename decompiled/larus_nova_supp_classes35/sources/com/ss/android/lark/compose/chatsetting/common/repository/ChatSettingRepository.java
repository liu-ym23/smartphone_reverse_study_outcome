package com.ss.android.lark.compose.chatsetting.common.repository;

import com.lark.kmp.pb.basic.v1.ActionType;
import com.lark.kmp.pb.basic.v1.Chat;
import com.lark.kmp.pb.basic.v1.Chatter;
import com.lark.kmp.pb.basic.v1.ChattersAuthResult;
import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.basic.v1.DeniedReason;
import com.lark.kmp.pb.basic.v1.Entity;
import com.lark.kmp.pb.basic.v1.SyncDataStrategy;
import com.lark.kmp.pb.contact.v2.GetAuthChattersRequest;
import com.lark.kmp.pb.contact.v2.GetAuthChattersResponse;
import com.lark.kmp.pb.im.v1.AddChatChattersRequest;
import com.lark.kmp.pb.im.v1.AddChatChattersResponse;
import com.lark.kmp.pb.im.v1.ClearChatMessagesRequest;
import com.lark.kmp.pb.im.v1.ClearChatMessagesResponse;
import com.lark.kmp.pb.im.v1.DeleteChatChattersRequest;
import com.lark.kmp.pb.im.v1.DeleteChatChattersResponse;
import com.lark.kmp.pb.im.v1.GetChatAdminUsersRequest;
import com.lark.kmp.pb.im.v1.GetChatAdminUsersResponse;
import com.lark.kmp.pb.im.v1.GetChatChattersRequest;
import com.lark.kmp.pb.im.v1.GetChatChattersResponse;
import com.lark.kmp.pb.im.v1.MGetChatsRequest;
import com.lark.kmp.pb.im.v1.MGetChatsResponse;
import com.lark.kmp.pb.im.v1.PatchChatAdminUsersRequest;
import com.lark.kmp.pb.im.v1.PatchChatAdminUsersResponse;
import com.lark.kmp.pb.im.v1.PushChatChattersResponse;
import com.lark.kmp.pb.im.v1.SubscribeChatEventRequest;
import com.lark.kmp.pb.im.v1.SubscribeChatEventResponse;
import com.lark.kmp.pb.im.v1.UpdateChatRequest;
import com.lark.kmp.pb.im.v1.UpdateChatResponse;
import com.lark.kmp.rustclient.api.d;
import com.lark.kmp.rustclient.api.model.RustOutputKt$errorAsException$;
import com.lark.kmp.rustclient.api.model.c;
import com.lark.kmp.rustclient.api.model.g;
import com.lark.kmp.rustclient.api.model.i;
import com.lark.kmp.server.pb.entities.FeedCard;
import com.lark.kmp.server.pb.entities.FeedCardIdentity;
import com.lark.kmp.server.pb.feed.PatchFeedCardPinRequest;
import com.lark.kmp.server.pb.feed.PatchFeedCardPinResponse;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$;
import kotlinx.coroutines.flow.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ChatSettingRepository {
    public final d a;

    public final FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1 j() {
        final RustOutputKt$errorAsException$.inlined.map.1 r0 = i.a(this.a.a(Command.PUSH_CHAT_CHATTERS, PushChatChattersResponse.ADAPTER));
        return new FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1(new ChatSettingRepository$observeChatChattersPush$$inlined$map$1(r0), new ChatSettingRepository$observeChatChattersPush$2(null));
    }

    public final FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1 k() {
        final RustOutputKt$errorAsException$.inlined.map.1 r0 = i.a(this.a.a(Command.PUSH_CHATTERS, Entity.ADAPTER));
        return new FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1(new ChatSettingRepository$observeChatter$$inlined$map$1(r0), new ChatSettingRepository$observeChatter$2(null));
    }

    public ChatSettingRepository(d r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = r2;
    }

    public final FlowKt__TransformKt$filterNotNull$.inlined.unsafeTransform.1 i(final String r5) {
        Intrinsics.checkNotNullParameter(r5, "chatId");
        final FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1 r3 = new FlowKt__ErrorsKt$catch$.inlined.unsafeFlow.1(i.a(this.a.a(Command.PUSH_CHATS, Entity.ADAPTER)), new ChatSettingRepository$observeChat$1(null));
        return new FlowKt__TransformKt$filterNotNull$.inlined.unsafeTransform.1(new FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1(new ChatSettingRepository$observeChat$$inlined$map$1(r3, r5), new ChatSettingRepository$observeChat$3(r5, null)));
    }

    public final Object c(String r11, Continuation<? super Result<ClearChatMessagesResponse>> r12) {
        if ((r12 instanceof ChatSettingRepository$clearHistory$1) == false) goto L7;
        ChatSettingRepository$clearHistory$1 r0 = (ChatSettingRepository$clearHistory$1) r12;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L17:
        Object r14 = a.a((g) r13);
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L20;
        int r4 = c8b.a.a;
        c8b.a.a("[ChatSettingRepository.clearHistory] error: " + r15.getMessage());
    L20:
        return r14;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        ClearChatMessagesRequest.a r5 = new ClearChatMessagesRequest.a();
        r5.d = r11;
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r16 = this.a.b(new c(r5, ClearChatMessagesResponse.ADAPTER, Command.CLEAR_CHAT_MESSAGES, null, 120)).a();
        r0.label = 1;
        r13 = e.s(r16, r0);
        if (r13 != r2) goto L17;
        return r2;
    L7:
        r0 = new ChatSettingRepository$clearHistory$1(this, r12);
        goto L8
    }

    public final Object d(String r11, Continuation<? super Result<UpdateChatResponse>> r12) {
        if ((r12 instanceof ChatSettingRepository$disbandGroup$1) == false) goto L7;
        ChatSettingRepository$disbandGroup$1 r0 = (ChatSettingRepository$disbandGroup$1) r12;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L17:
        Object r14 = a.a((g) r13);
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L20;
        int r4 = c8b.a.a;
        c8b.a.a("[ChatSettingRepository.disbandGroup] error: " + r15.getMessage());
    L20:
        return r14;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        UpdateChatRequest.a r5 = new UpdateChatRequest.a();
        Intrinsics.checkNotNullParameter(r11, "chat_id");
        r5.d = r11;
        r5.t = Boxing.boxBoolean(true);
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r16 = this.a.b(new c(r5, UpdateChatResponse.ADAPTER, Command.UPDATE_CHAT, null, 120)).a();
        r0.label = 1;
        r13 = e.s(r16, r0);
        if (r13 != r2) goto L17;
        return r2;
    L7:
        r0 = new ChatSettingRepository$disbandGroup$1(this, r12);
        goto L8
    }

    public final Object e(String r12, Continuation<? super Result<Chat>> r13) {
        if ((r13 instanceof ChatSettingRepository$fetchChat$1) == false) goto L7;
        ChatSettingRepository$fetchChat$1 r1 = (ChatSettingRepository$fetchChat$1) r13;
        int r2 = r1.label;
        if ((r2 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r1.label = r2 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r14 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        r12 = (String) r1.L$0;
        ResultKt.throwOnFailure(r14);
    L17:
        Object r15 = a.a((g) r14);
        if (Result.isSuccess-impl(r15) == true) goto L35;
    L30:
        Object r16 = Result.constructor-impl(r15);
    L31:
        Throwable r0 = Result.exceptionOrNull-impl(r16);
        if (r0 == null) goto L34;
        int r5 = c8b.a.a;
        c8b.a.a("[ChatSettingRepository.fetchChat] error: " + r0.getMessage() + ", chatId: " + r12);
    L34:
        return r16;
    L35:
        Entity r17 = ((MGetChatsResponse) r15).getEntity();     // Catch: Throwable -> L28
        if (r17 == null) goto L27;
        Map r18 = r17.getChats();     // Catch: Throwable -> L28
        if (r18 == null) goto L27;
        Chat r19 = (Chat) r18.get(r12);     // Catch: Throwable -> L28
        if (r19 == null) goto L27;
        r16 = Result.constructor-impl(r19);     // Catch: Throwable -> L28
    L27:
        throw new IllegalStateException("Chat not found for chatId: " + r12);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r15 = ResultKt.createFailure(th);
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        MGetChatsRequest.a r7 = new MGetChatsRequest.a();
        List r110 = CollectionsKt.listOf(r12);
        Intrinsics.checkNotNullParameter(r110, "chat_ids");
        com.lark.wire.internal.a.a(r110);
        r7.d = r110;
        r7.f = SyncDataStrategy.TRY_LOCAL;
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r111 = this.a.b(new c(r7, MGetChatsResponse.ADAPTER, Command.MGET_CHATS, null, 120)).a();
        r1.L$0 = r12;
        r1.label = 1;
        r14 = e.s(r111, r1);
        if (r14 != r3) goto L17;
        return r3;
    L7:
        r1 = new ChatSettingRepository$fetchChat$1(this, r13);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v17, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v18, types: [java.util.ArrayList] */
    public final Object f(String r11, Continuation<? super Result<? extends List<Chatter>>> r12) {
        if ((r12 instanceof ChatSettingRepository$fetchChatAdminUsers$1) == false) goto L7;
        ChatSettingRepository$fetchChatAdminUsers$1 r0 = (ChatSettingRepository$fetchChatAdminUsers$1) r12;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r11 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L17:
        Object r14 = a.a((g) r13);
        if (Result.isSuccess-impl(r14) == false) goto L35;
        GetChatAdminUsersResponse r15 = (GetChatAdminUsersResponse) r14;
        List r4 = r15.getAdmin_users();
        Entity r16 = r15.getEntity();
        if (r16 == null) goto L34;
        Entity.ChatChatter r17 = (Entity.ChatChatter) r16.getChat_chatters().get(r11);
        if (r17 == null) goto L25;
        Map r18 = r17.getChatters();
        if (r18 == null) goto L25;
    L26:
        if (r18 == null) goto L34;
        r14 = new ArrayList();
        Iterator r5 = r4.iterator();
    L30:
        if (r5.hasNext() == false) goto L35;
        Chatter r6 = (Chatter) r18.get((String) r5.next());
        if (r6 == null) goto L30;
        r14.add(r6);
    L25:
        r18 = r16.getChatters();
    L34:
        r14 = CollectionsKt.emptyList();
    L35:
        Object r19 = Result.constructor-impl(r14);
        Throwable r110 = Result.exceptionOrNull-impl(r19);
        if (r110 == null) goto L38;
        int r7 = c8b.a.a;
        c8b.a.a("[ChatSettingRepository.fetchChatAdminUsers] error: " + r110.getMessage());
    L38:
        return r19;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        GetChatAdminUsersRequest.a r8 = new GetChatAdminUsersRequest.a();
        Intrinsics.checkNotNullParameter(r11, "chat_id");
        r8.d = r11;
        SyncDataStrategy r111 = SyncDataStrategy.FORCE_SERVER;
        Intrinsics.checkNotNullParameter(r111, "sync_data_strategy");
        r8.e = r111;
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r112 = this.a.b(new c(r8, GetChatAdminUsersResponse.ADAPTER, Command.GET_CHAT_ADMIN_USERS, null, 120)).a();
        r0.L$0 = r11;
        r0.label = 1;
        r13 = e.s(r112, r0);
        if (r13 != r2) goto L17;
        return r2;
    L7:
        r0 = new ChatSettingRepository$fetchChatAdminUsers$1(this, r12);
        goto L8
    }

    public final Object o(String r11, Continuation<? super Result<SubscribeChatEventResponse>> r12) {
        if ((r12 instanceof ChatSettingRepository$subscribeChatEvent$1) == false) goto L7;
        ChatSettingRepository$subscribeChatEvent$1 r0 = (ChatSettingRepository$subscribeChatEvent$1) r12;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r11 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);
    L21:
        Object r14 = a.a((g) r13);
        Throwable r4 = Result.exceptionOrNull-impl(r14);
        if (r4 == null) goto L24;
        int r5 = c8b.a.a;
        c8b.a.a("[ChatSettingRepository.subscribeChatEvent] error: " + r4.getMessage() + ", chatId: " + r11);
    L24:
        return r14;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        if (StringsKt.isBlank(r11) == false) goto L18;
        Result.Companion r15 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("chatId cannot be blank")));
    L18:
        SubscribeChatEventRequest.a r6 = new SubscribeChatEventRequest.a();
        List r16 = CollectionsKt.listOf(r11);
        Intrinsics.checkNotNullParameter(r16, "subscribe_chat_ids");
        com.lark.wire.internal.a.a(r16);
        r6.d = r16;
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r17 = this.a.b(new c(r6, SubscribeChatEventResponse.ADAPTER, Command.SUBSCRIBE_CHAT_EVENT, null, 120)).a();
        r0.L$0 = r11;
        r0.label = 1;
        r13 = e.s(r17, r0);
        if (r13 != r2) goto L21;
        return r2;
    L7:
        r0 = new ChatSettingRepository$subscribeChatEvent$1(this, r12);
        goto L8
    }

    public final Object a(String r11, List<String> r12, Continuation<? super Result<AddChatChattersResponse>> r13) {
        if ((r13 instanceof ChatSettingRepository$addChatChatters$1) == false) goto L7;
        ChatSettingRepository$addChatChatters$1 r0 = (ChatSettingRepository$addChatChatters$1) r13;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L17:
        Object r15 = a.a((g) r14);
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L20;
        int r17 = c8b.a.a;
        c8b.a.a("[ChatSettingRepository.addChatChatters] error: " + r16.getMessage());
    L20:
        return r15;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        AddChatChattersRequest.a r5 = new AddChatChattersRequest.a();
        r5.e = r11;
        Intrinsics.checkNotNullParameter(r12, "chatter_ids");
        com.lark.wire.internal.a.a(r12);
        r5.f = r12;
        r5.d = AddChatChattersRequest.Type.INVITATION;
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r18 = this.a.b(new c(r5, AddChatChattersResponse.ADAPTER, Command.ADD_CHAT_CHATTERS, null, 120)).a();
        r0.label = 1;
        r14 = e.s(r18, r0);
        if (r14 != r2) goto L17;
        return r2;
    L7:
        r0 = new ChatSettingRepository$addChatChatters$1(this, r13);
        goto L8
    }

    public final Object b(String r11, String r12, Continuation<? super Result<? extends DeniedReason>> r13) {
        if ((r13 instanceof ChatSettingRepository$checkUserRelationship$1) == false) goto L7;
        ChatSettingRepository$checkUserRelationship$1 r0 = (ChatSettingRepository$checkUserRelationship$1) r13;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r11 = (String) r0.L$0;
        ResultKt.throwOnFailure(r14);
    L17:
        Object r15 = a.a((g) r14);
        if (Result.isSuccess-impl(r15) == false) goto L25;
        ChattersAuthResult r16 = ((GetAuthChattersResponse) r15).getAuth_result();
        if (r16 == null) goto L24;
        Map r17 = r16.getDenied_reasons();
        if (r17 == null) goto L24;
        r15 = (DeniedReason) r17.get(r11);
    L24:
        r15 = null;
    L25:
        Object r18 = Result.constructor-impl(r15);
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L28;
        int r110 = c8b.a.a;
        c8b.a.a("[ChatSettingRepository.checkUserRelationship] error: " + r19.getMessage());
    L28:
        return r18;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        GetAuthChattersRequest.a r5 = new GetAuthChattersRequest.a();
        ActionType r111 = ActionType.INVITE_SAME_CHAT;
        Intrinsics.checkNotNullParameter(r111, "action_type");
        r5.d = r111;
        Map r112 = MapsKt.mapOf(TuplesKt.to(r11, r12));
        Intrinsics.checkNotNullParameter(r112, "chatters_auth_info");
        r5.e = r112;
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r113 = this.a.b(new c(r5, GetAuthChattersResponse.ADAPTER, Command.GET_AUTH_CHATTERS, null, 120)).a();
        r0.L$0 = r11;
        r0.label = 1;
        r14 = e.s(r113, r0);
        if (r14 != r2) goto L17;
        return r2;
    L7:
        r0 = new ChatSettingRepository$checkUserRelationship$1(this, r13);
        goto L8
    }

    public final Object h(String r11, String r12, Continuation<? super Result<DeleteChatChattersResponse>> r13) {
        if ((r13 instanceof ChatSettingRepository$leaveGroup$1) == false) goto L7;
        ChatSettingRepository$leaveGroup$1 r0 = (ChatSettingRepository$leaveGroup$1) r13;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r14 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L17:
        Object r15 = a.a((g) r14);
        Throwable r16 = Result.exceptionOrNull-impl(r15);
        if (r16 == null) goto L20;
        int r17 = c8b.a.a;
        c8b.a.a("[ChatSettingRepository.leaveGroup] error: " + r16.getMessage());
    L20:
        return r15;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        DeleteChatChattersRequest.a r5 = new DeleteChatChattersRequest.a();
        Intrinsics.checkNotNullParameter(r11, "chat_id");
        r5.d = r11;
        List r18 = CollectionsKt.listOf(r12);
        Intrinsics.checkNotNullParameter(r18, "chatter_ids");
        com.lark.wire.internal.a.a(r18);
        r5.e = r18;
        DeleteChatChattersRequest.DeleteChatChatterOption.a r19 = new DeleteChatChattersRequest.DeleteChatChatterOption.a();
        r19.d = Boxing.boxBoolean(false);
        r5.g = new DeleteChatChattersRequest.DeleteChatChatterOption(r19, r19.c(), null);
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r110 = this.a.b(new c(r5, DeleteChatChattersResponse.ADAPTER, Command.DELETE_CHAT_CHATTERS, null, 120)).a();
        r0.label = 1;
        r14 = e.s(r110, r0);
        if (r14 != r2) goto L17;
        return r2;
    L7:
        r0 = new ChatSettingRepository$leaveGroup$1(this, r13);
        goto L8
    }

    public final Object m(String r13, boolean r14, Continuation<? super Result<PatchFeedCardPinResponse>> r15) {
        if ((r15 instanceof ChatSettingRepository$patchFeedCardPin$1) == false) goto L7;
        ChatSettingRepository$patchFeedCardPin$1 r0 = (ChatSettingRepository$patchFeedCardPin$1) r15;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r16 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r14 = r0.Z$0;
        r13 = (String) r0.L$0;
        ResultKt.throwOnFailure(r16);
    L17:
        Object r17 = a.a((g) r16);
        Throwable r4 = Result.exceptionOrNull-impl(r17);
        if (r4 == null) goto L20;
        int r5 = c8b.a.a;
        c8b.a.a("[ChatSettingRepository.patchFeedCardPin] error: " + r4.getMessage() + ", chatId: " + r13 + ", pin: " + r14);
    L20:
        return r17;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        FeedCardIdentity.a r18 = new FeedCardIdentity.a();
        r18.e = FeedCard.Type.CHAT;
        r18.d = r13;
        FeedCardIdentity r6 = new FeedCardIdentity(r18, r18.c(), null);
        PatchFeedCardPinRequest.a r7 = new PatchFeedCardPinRequest.a();
        r7.d = r6;
        r7.e = Boxing.boxBoolean(r14);
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r19 = this.a.b(new c(r7, PatchFeedCardPinResponse.ADAPTER, Command.POST_GATEWAY, com.lark.kmp.server.pb.improto.Command.PATCH_FEED_CARD_PIN, 56)).a();
        r0.L$0 = r13;
        r0.Z$0 = r14;
        r0.label = 1;
        r16 = e.s(r19, r0);
        if (r16 != r2) goto L17;
        return r2;
    L7:
        r0 = new ChatSettingRepository$patchFeedCardPin$1(this, r15);
        goto L8
    }

    public final Object q(String r12, boolean r13, Continuation<? super Result<Chat>> r14) {
        if ((r14 instanceof ChatSettingRepository$updateChatEditInfoPermission$1) == false) goto L7;
        ChatSettingRepository$updateChatEditInfoPermission$1 r1 = (ChatSettingRepository$updateChatEditInfoPermission$1) r14;
        int r2 = r1.label;
        if ((r2 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r1.label = r2 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r15 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        r12 = (String) r1.L$0;
        ResultKt.throwOnFailure(r15);
    L17:
        Object r16 = a.a((g) r15);
        if (Result.isSuccess-impl(r16) == true) goto L35;
        Object r17 = Result.constructor-impl(r16);
    L31:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L34;
        int r19 = c8b.a.a;
        c8b.a.a("[ChatSettingRepository.updateChatEditInfoPermission] error: " + r18.getMessage());
    L34:
        return r17;
    L35:
        Entity r110 = ((UpdateChatResponse) r16).getEntity();     // Catch: Throwable -> L28
        if (r110 == null) goto L27;
        Map r111 = r110.getChats();     // Catch: Throwable -> L28
        if (r111 == null) goto L27;
        Chat r112 = (Chat) r111.get(r12);     // Catch: Throwable -> L28
        if (r112 == null) goto L27;
        r17 = Result.constructor-impl(r112);     // Catch: Throwable -> L28
    L27:
        throw new IllegalStateException("Chat entity is missing in response for chatId: " + r12);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        UpdateChatRequest.a r6 = new UpdateChatRequest.a();
        Intrinsics.checkNotNullParameter(r12, "chat_id");
        r6.d = r12;
        r6.r = Boxing.boxBoolean(r13);
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r114 = this.a.b(new c(r6, UpdateChatResponse.ADAPTER, Command.UPDATE_CHAT, null, 120)).a();
        r1.L$0 = r12;
        r1.label = 1;
        r15 = e.s(r114, r1);
        if (r15 != r3) goto L17;
        return r3;
    L7:
        r1 = new ChatSettingRepository$updateChatEditInfoPermission$1(this, r14);
        goto L8
    }

    public final Object r(String r12, String r13, Continuation<? super Result<Chat>> r14) {
        if ((r14 instanceof ChatSettingRepository$updateChatOwner$1) == false) goto L7;
        ChatSettingRepository$updateChatOwner$1 r1 = (ChatSettingRepository$updateChatOwner$1) r14;
        int r2 = r1.label;
        if ((r2 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r1.label = r2 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r15 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        r12 = (String) r1.L$0;
        ResultKt.throwOnFailure(r15);
    L17:
        Object r16 = a.a((g) r15);
        if (Result.isSuccess-impl(r16) == true) goto L35;
        Object r17 = Result.constructor-impl(r16);
    L31:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L34;
        int r19 = c8b.a.a;
        c8b.a.a("[ChatSettingRepository.updateChatOwner] error: " + r18.getMessage());
    L34:
        return r17;
    L35:
        Entity r110 = ((UpdateChatResponse) r16).getEntity();     // Catch: Throwable -> L28
        if (r110 == null) goto L27;
        Map r111 = r110.getChats();     // Catch: Throwable -> L28
        if (r111 == null) goto L27;
        Chat r112 = (Chat) r111.get(r12);     // Catch: Throwable -> L28
        if (r112 == null) goto L27;
        r17 = Result.constructor-impl(r112);     // Catch: Throwable -> L28
    L27:
        throw new IllegalStateException("Chat entity is missing in response for chatId: " + r12);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        UpdateChatRequest.a r6 = new UpdateChatRequest.a();
        Intrinsics.checkNotNullParameter(r12, "chat_id");
        r6.d = r12;
        r6.i = r13;
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r114 = this.a.b(new c(r6, UpdateChatResponse.ADAPTER, Command.UPDATE_CHAT, null, 120)).a();
        r1.L$0 = r12;
        r1.label = 1;
        r15 = e.s(r114, r1);
        if (r15 != r3) goto L17;
        return r3;
    L7:
        r1 = new ChatSettingRepository$updateChatOwner$1(this, r14);
        goto L8
    }

    public final Object s(String r12, boolean r13, Continuation<? super Result<Boolean>> r14) {
        if ((r14 instanceof ChatSettingRepository$updateChatRemind$1) == false) goto L7;
        ChatSettingRepository$updateChatRemind$1 r1 = (ChatSettingRepository$updateChatRemind$1) r14;
        int r2 = r1.label;
        if ((r2 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r1.label = r2 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r15 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        r12 = (String) r1.L$0;
        ResultKt.throwOnFailure(r15);
    L17:
        Object r16 = a.a((g) r15);
        if (Result.isSuccess-impl(r16) == true) goto L33;
        Object r17 = Result.constructor-impl(r16);
    L29:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L32;
        int r19 = c8b.a.a;
        c8b.a.a("[ChatSettingRepository.updateChatRemind] error: " + r18.getMessage());
    L32:
        return r17;
    L33:
        Chat r110 = (Chat) ((UpdateChatResponse) r16).getEntity().getChats().get(r12);     // Catch: Throwable -> L26
        if (r110 == null) goto L25;
        Boolean r111 = r110.is_remind();     // Catch: Throwable -> L26
        if (r111 == null) goto L25;
        r17 = Result.constructor-impl(Boxing.boxBoolean(r111.booleanValue()));     // Catch: Throwable -> L26
    L25:
        throw new IllegalStateException("Chat is_remind field is missing in response for chatId: " + r12);     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L29
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        UpdateChatRequest.a r6 = new UpdateChatRequest.a();
        Intrinsics.checkNotNullParameter(r12, "chat_id");
        r6.d = r12;
        r6.q = Boxing.boxBoolean(r13);
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r113 = this.a.b(new c(r6, UpdateChatResponse.ADAPTER, Command.UPDATE_CHAT, null, 120)).a();
        r1.L$0 = r12;
        r1.label = 1;
        r15 = e.s(r113, r1);
        if (r15 != r3) goto L17;
        return r3;
    L7:
        r1 = new ChatSettingRepository$updateChatRemind$1(this, r14);
        goto L8
    }

    public final Object g(String r11, boolean r12, int r13, Continuation<? super Result<GetChatChattersResponse>> r14) {
        if ((r14 instanceof ChatSettingRepository$fetchChatChatters$1) == false) goto L7;
        ChatSettingRepository$fetchChatChatters$1 r0 = (ChatSettingRepository$fetchChatChatters$1) r14;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L17:
        Object r16 = a.a((g) r15);
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L20;
        int r18 = c8b.a.a;
        c8b.a.a("[ChatSettingRepository.fetchChatChatters] error: " + r17.getMessage());
    L20:
        return r16;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        GetChatChattersRequest.a r5 = new GetChatChattersRequest.a();
        Intrinsics.checkNotNullParameter(r11, "chat_id");
        r5.d = r11;
        r5.e = Boxing.boxBoolean(r12);
        r5.i = Boxing.boxInt(r13);
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r19 = this.a.b(new c(r5, GetChatChattersResponse.ADAPTER, Command.GET_CHAT_CHATTERS, null, 120)).a();
        r0.label = 1;
        r15 = e.s(r19, r0);
        if (r15 != r2) goto L17;
        return r2;
    L7:
        r0 = new ChatSettingRepository$fetchChatChatters$1(this, r14);
        goto L8
    }

    public final Object l(String r11, List<String> r12, List<String> r13, Continuation<? super Result<PatchChatAdminUsersResponse>> r14) {
        if ((r14 instanceof ChatSettingRepository$patchChatAdminUsers$1) == false) goto L7;
        ChatSettingRepository$patchChatAdminUsers$1 r0 = (ChatSettingRepository$patchChatAdminUsers$1) r14;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L17:
        Object r16 = a.a((g) r15);
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L20;
        int r18 = c8b.a.a;
        c8b.a.a("[ChatSettingRepository.patchChatAdminUsers] error: " + r17.getMessage());
    L20:
        return r16;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        PatchChatAdminUsersRequest.a r5 = new PatchChatAdminUsersRequest.a();
        Intrinsics.checkNotNullParameter(r11, "chat_id");
        r5.d = r11;
        Intrinsics.checkNotNullParameter(r12, "to_add_user_ids");
        com.lark.wire.internal.a.a(r12);
        r5.e = r12;
        Intrinsics.checkNotNullParameter(r13, "to_del_user_ids");
        com.lark.wire.internal.a.a(r13);
        r5.f = r13;
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r19 = this.a.b(new c(r5, PatchChatAdminUsersResponse.ADAPTER, Command.PATCH_CHAT_ADMIN_USERS, null, 120)).a();
        r0.label = 1;
        r15 = e.s(r19, r0);
        if (r15 != r2) goto L17;
        return r2;
    L7:
        r0 = new ChatSettingRepository$patchChatAdminUsers$1(this, r14);
        goto L8
    }

    public final Object n(String r11, List<String> r12, boolean r13, Continuation<? super Result<DeleteChatChattersResponse>> r14) {
        if ((r14 instanceof ChatSettingRepository$removeChatChatters$1) == false) goto L7;
        ChatSettingRepository$removeChatChatters$1 r0 = (ChatSettingRepository$removeChatChatters$1) r14;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L17:
        Object r16 = a.a((g) r15);
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L20;
        int r18 = c8b.a.a;
        c8b.a.a("[ChatSettingRepository.removeChatChatters] error: " + r17.getMessage());
    L20:
        return r16;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        DeleteChatChattersRequest.a r5 = new DeleteChatChattersRequest.a();
        Intrinsics.checkNotNullParameter(r11, "chat_id");
        r5.d = r11;
        Intrinsics.checkNotNullParameter(r12, "chatter_ids");
        com.lark.wire.internal.a.a(r12);
        r5.e = r12;
        DeleteChatChattersRequest.DeleteChatChatterOption.a r19 = new DeleteChatChattersRequest.DeleteChatChatterOption.a();
        r19.d = Boxing.boxBoolean(r13);
        r5.g = new DeleteChatChattersRequest.DeleteChatChatterOption(r19, r19.c(), null);
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r110 = this.a.b(new c(r5, DeleteChatChattersResponse.ADAPTER, Command.DELETE_CHAT_CHATTERS, null, 120)).a();
        r0.label = 1;
        r15 = e.s(r110, r0);
        if (r15 != r2) goto L17;
        return r2;
    L7:
        r0 = new ChatSettingRepository$removeChatChatters$1(this, r14);
        goto L8
    }

    public final Object p(String r12, Chat.AddMemberPermission.Enum r13, Chat.ShareCardPermission.Enum r14, Continuation<? super Result<Chat>> r15) {
        if ((r15 instanceof ChatSettingRepository$updateChatAddMemberAndSharePermission$1) == false) goto L7;
        ChatSettingRepository$updateChatAddMemberAndSharePermission$1 r1 = (ChatSettingRepository$updateChatAddMemberAndSharePermission$1) r15;
        int r2 = r1.label;
        if ((r2 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r1.label = r2 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r16 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        r12 = (String) r1.L$0;
        ResultKt.throwOnFailure(r16);
    L17:
        Object r17 = a.a((g) r16);
        if (Result.isSuccess-impl(r17) == true) goto L35;
        Object r18 = Result.constructor-impl(r17);
    L31:
        Throwable r19 = Result.exceptionOrNull-impl(r18);
        if (r19 == null) goto L34;
        int r110 = c8b.a.a;
        c8b.a.a("[ChatSettingRepository.updateChatAddMemberAndSharePermission] error: " + r19.getMessage());
    L34:
        return r18;
    L35:
        Entity r111 = ((UpdateChatResponse) r17).getEntity();     // Catch: Throwable -> L28
        if (r111 == null) goto L27;
        Map r112 = r111.getChats();     // Catch: Throwable -> L28
        if (r112 == null) goto L27;
        Chat r113 = (Chat) r112.get(r12);     // Catch: Throwable -> L28
        if (r113 == null) goto L27;
        r18 = Result.constructor-impl(r113);     // Catch: Throwable -> L28
    L27:
        throw new IllegalStateException("Chat entity is missing in response for chatId: " + r12);     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r18 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r16);
        UpdateChatRequest.a r6 = new UpdateChatRequest.a();
        Intrinsics.checkNotNullParameter(r12, "chat_id");
        r6.d = r12;
        r6.D = r13;
        r6.H = r14;
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r115 = this.a.b(new c(r6, UpdateChatResponse.ADAPTER, Command.UPDATE_CHAT, null, 120)).a();
        r1.L$0 = r12;
        r1.label = 1;
        r16 = e.s(r115, r1);
        if (r16 != r3) goto L17;
        return r3;
    L7:
        r1 = new ChatSettingRepository$updateChatAddMemberAndSharePermission$1(this, r15);
        goto L8
    }

    public final Object t(String r11, Boolean r12, Boolean r13, Continuation<? super Result<Unit>> r14) {
        if ((r14 instanceof ChatSettingRepository$updateDoubaoSetting$1) == false) goto L7;
        ChatSettingRepository$updateDoubaoSetting$1 r0 = (ChatSettingRepository$updateDoubaoSetting$1) r14;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L27:
        Object r16 = a.a((g) r15);
        if (Result.isSuccess-impl(r16) == false) goto L30;
        UpdateChatResponse r17 = (UpdateChatResponse) r16;
        r16 = Unit.INSTANCE;
    L30:
        Object r18 = Result.constructor-impl(r16);
        if (Result.isSuccess-impl(r18) == false) goto L33;
        Unit r19 = (Unit) r18;
        c8b.a.b("[ChatSettingRepository.updateDoubaoSetting] success");
    L33:
        Throwable r110 = Result.exceptionOrNull-impl(r18);
        if (r110 == null) goto L36;
        int r111 = c8b.a.a;
        c8b.a.a("[ChatSettingRepository.updateDoubaoSetting] error: " + r110.getMessage());
    L36:
        return r18;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        if (r12 != null) goto L19;
        if (r13 != null) goto L19;
        Result.Companion r112 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(new IllegalArgumentException("At least one Doubao setting is required")));
    L19:
        int r113 = c8b.a.a;
        c8b.a.b("[ChatSettingRepository.updateDoubaoSetting] start, using=" + r12 + ", proactiveReply=" + r13);
        Chat.DoubaoSetting.a r114 = new Chat.DoubaoSetting.a();
        if (r12 == null) goto L22;
        r114.d = Boxing.boxBoolean(r12.booleanValue());
    L22:
        if (r13 == null) goto L24;
        r114.e = Boxing.boxBoolean(r13.booleanValue());
    L24:
        UpdateChatRequest.a r5 = new UpdateChatRequest.a();
        Intrinsics.checkNotNullParameter(r11, "chat_id");
        r5.d = r11;
        r5.Y = new Chat.DoubaoSetting(r114, r114.c(), null);
        FlowKt__TransformKt$onEach$.inlined.unsafeTransform.1 r115 = this.a.b(new c(r5, UpdateChatResponse.ADAPTER, Command.UPDATE_CHAT, null, 120)).a();
        r0.label = 1;
        r15 = e.s(r115, r0);
        if (r15 != r2) goto L27;
        return r2;
    L7:
        r0 = new ChatSettingRepository$updateDoubaoSetting$1(this, r14);
        goto L8
    }
}
