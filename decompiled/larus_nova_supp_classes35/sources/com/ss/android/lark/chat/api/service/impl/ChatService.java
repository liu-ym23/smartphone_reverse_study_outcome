package com.ss.android.lark.chat.api.service.impl;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.lark.pb.basic.v1.AddChatChatterApply;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.Entity;
import com.bytedance.lark.pb.basic.v1.OpenApp;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.im.v1.AddChatChattersRequest;
import com.bytedance.lark.pb.im.v1.CheckChattersInChatRequest;
import com.bytedance.lark.pb.im.v1.CreateAddChatChatterApplyRequest;
import com.bytedance.lark.pb.im.v1.CreateChatLastReadPositionRequest;
import com.bytedance.lark.pb.im.v1.CreateChatRequest;
import com.bytedance.lark.pb.im.v1.DeleteChatChattersRequest;
import com.bytedance.lark.pb.im.v1.DisableChatSharedRequest;
import com.bytedance.lark.pb.im.v1.GetChatChatterKickRequest;
import com.bytedance.lark.pb.im.v1.GetChatChattersRequest;
import com.bytedance.lark.pb.im.v1.GetMentionChatChattersRequest;
import com.bytedance.lark.pb.im.v1.GetMentionChatChattersResponse;
import com.bytedance.lark.pb.im.v1.GetP2PChatsByChatterIdsRequest;
import com.bytedance.lark.pb.im.v1.GetP2PChatsByChatterIdsResponse;
import com.bytedance.lark.pb.im.v1.HideChatTranslatedNameRequest;
import com.bytedance.lark.pb.im.v1.MGetChatsRequest;
import com.bytedance.lark.pb.im.v1.MGetChatsResponse;
import com.bytedance.lark.pb.im.v1.SubscribeChatEventRequest;
import com.bytedance.lark.pb.im.v1.TranslateChatNameRequest;
import com.bytedance.lark.pb.media.v1.GetChatResourcesRequest;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.biz.im.api.ImageHistoryResponse;
import com.ss.android.lark.chat.api.service.IChatService;
import com.ss.android.lark.chat.entity.chat.AddChatChatterApply$Ways;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chat.ChatOptionInfo;
import com.ss.android.lark.chat.entity.chat.ChatSetting;
import com.ss.android.lark.chat.entity.chat.PickChatEntity;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterSensitiveInfo;
import com.ss.android.lark.chat.entity.wallpaper.ChatThemeInfo;
import com.ss.android.lark.chat.name.ChatNameRenderer$doHideTranslate$1;
import com.ss.android.lark.chat.name.ChatNameRenderer$doTranslate$1;
import com.ss.android.lark.dto.group.GroupRecallEntity;
import com.ss.android.lark.dto.usergroup.UserGroupEntity;
import com.ss.android.lark.im.sdk.ImSdkProxy;
import com.ss.android.lark.integrator.im.impl.IIMApiImpl;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.pb.chats.CheckWithdrawPickEntitiesInChatRequest;
import com.ss.android.lark.pb.chats.CheckWithdrawPickEntitiesInChatResponse;
import com.ss.android.lark.pb.chats.PickEntities;
import com.ss.android.lark.pb.chats.PickType;
import com.ss.android.lark.pb.chats.UpdateChatUserAutoMuteSettingResponse;
import com.ss.android.lark.pb.entities.ChatBackgroundEntity;
import com.ss.android.lark.pb.entities.ChatTheme;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@UserScope
public final class ChatService implements IChatService {
    public final okb.h a;
    public final okb.a b;
    public final a2b.a c;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.api.service.impl.ChatService$19, reason: invalid class name */
    class AnonymousClass19 implements IGetDataCallback<Map<String, Chat>> {
        final /* synthetic */ ChatService this$0;
        final /* synthetic */ IGetDataCallback val$callback;

        public void onError(ErrorResult r2) {
            this.val$callback.onError(r2);
        }

        public void onSuccess(Map<String, Chat> r4) {
            Iterator<String> r0 = r4.keySet().iterator();
        L4:
            if (r0.hasNext() == false) goto L8;
            if (r4.get(r0.next()).getRole().equals(Chat.Role.MEMBER) == false) goto L4;
            boolean r5 = true;
        L9:
            this.val$callback.onSuccess(Boolean.valueOf(r5));
            return;
        L8:
            r5 = false;
            goto L9
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((Map) r1);
        }

        public AnonymousClass19(ChatService r1, IGetDataCallback r2) {
            this.this$0 = r1;
            this.val$callback = r2;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.chat.api.service.impl.ChatService$6, reason: invalid class name */
    class AnonymousClass6 implements IGetDataCallback<UpdateChatUserAutoMuteSettingResponse> {
        final /* synthetic */ ChatService this$0;
        final /* synthetic */ IGetDataCallback val$callback;

        public void onError(ErrorResult r2) {
            this.val$callback.onError(r2);
        }

        public void onSuccess(UpdateChatUserAutoMuteSettingResponse r2) {
            this.val$callback.onSuccess(Boolean.TRUE);
        }

        public /* bridge */ /* synthetic */ void onError(Object r1) {
            onError((ErrorResult) r1);
        }

        public /* bridge */ /* synthetic */ void onSuccess(Object r1) {
            onSuccess((UpdateChatUserAutoMuteSettingResponse) r1);
        }

        public AnonymousClass6(ChatService r1, IGetDataCallback r2) {
            this.this$0 = r1;
            this.val$callback = r2;
        }
    }

    public class a implements SdkSender.IParser<Chat> {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        public final Object parse(byte[] r3) throws IOException {
            Map r4 = ((GetP2PChatsByChatterIdsResponse) GetP2PChatsByChatterIdsResponse.ADAPTER.decode(r3)).chatter_id2chat;
            if (r4.keySet().contains(this.a) == true) goto L5;
            return null;
        L5:
            return com.ss.android.lark.parser.internal.h.a((com.bytedance.lark.pb.basic.v1.Chat) r4.get(this.a), null);
        }
    }

    public class b implements SdkSender.IParser<Chat> {
        public final /* bridge */ /* synthetic */ Object parse(byte[] r1) throws IOException {
            return null;
        }

        public b() {
        }
    }

    public static final class c {
        public static final ChatService a = null;

        static {
            a = new ChatService(new i());
        }
    }

    public static List g() {
        ArrayList r0 = new ArrayList();
        if (CollectionUtils.isEmpty(null) == false) goto L5;
        return r0;
    L5:
        throw null;
    }

    @Inject
    public ChatService(a2b.a r2) {
        this.a = ImSdkProxy.e();
        this.b = ImSdkProxy.b();
        this.c = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.ss.android.lark.chat.api.service.impl.t] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final com.ss.android.lark.chat.entity.chat.b I0(String r3) {
        return this.c.b(new GetChatChatterKickRequest.Builder().chat_id(r3), new t());
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final boolean checkLoginUserExistedInLocalChat(Chat r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if (r3.getRole() != Chat.Role.MEMBER) goto L9;
        return true;
    L9:
        return false;
    }

    public final com.ss.android.lark.chat.entity.chat.a f(final String r4) {
        com.ss.android.lark.chat.entity.chat.a r1 = null;
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return null;
    L5:
        List r0 = Collections.singletonList(r4);
        if (CollectionUtils.isEmpty(r0) == true) goto L9;
        com.ss.android.lark.chat.utils.z0.a();
        MGetChatsRequest.Builder r2 = new MGetChatsRequest.Builder().chat_ids(r0);
        r1 = (com.ss.android.lark.chat.entity.chat.a) SdkSender.syncSend(Command.MGET_CHATS, r2, new p(r4));
    L9:
        if (r1 != null) goto L11;
    L13:
        com.ss.android.lark.chat.utils.z0.a();
        com.ss.android.lark.chat.entity.chat.a r5 = (com.ss.android.lark.chat.entity.chat.a) SdkSender.sendRequest(Command.MGET_CHATS, new MGetChatsRequest.Builder().chat_ids(Collections.singletonList(r4)).should_auth(Boolean.TRUE), new n0(r4));
        if (r5 == null) goto L16;
        return r5;
    L16:
        return new com.ss.android.lark.chat.entity.chat.a();
    L11:
        if (r1.a == null) goto L13;
        return r1;
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final Chat getChatById(String r4) {
        com.ss.android.lark.chat.utils.z0.a();
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return null;
    L6:
        Chat r0 = getLocalChat(r4);
        if (r0 == null) goto L9;
        return r0;
    L9:
        Map<String, Chat> r1 = n(Collections.singletonList(r4));
        if (CollectionUtils.isEmpty(r1) == false) goto L12;
        return r0;
    L12:
        return r1.get(r4);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final Chat getLocalChat(String r2) {
        return i(Collections.singletonList(r2)).get(r2);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final Chat getP2pChatByChatterId(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        return null;
    L6:
        List r0 = Collections.singletonList(r4);
        GetP2PChatsByChatterIdsRequest.Builder r1 = new GetP2PChatsByChatterIdsRequest.Builder().chatter_ids(r0);
        return (Chat) SdkSender.syncSend(Command.GET_P2P_CHATS_BY_CHATTER_IDS, r1, new a(r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v7, types: [com.ss.android.lark.chat.api.service.impl.a0] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final int h(String r5) {
        List r0 = Collections.singletonList(r5);
        HashMap r1 = new HashMap();
        if (CollectionUtils.isEmpty(r0) == true) goto L14;
        Map r2 = new HashMap();
        if (CollectionUtils.isEmpty(r0) == true) goto L9;
        com.ss.android.lark.chat.utils.z0.a();
        MGetChatsRequest.Builder r3 = new MGetChatsRequest.Builder().chat_ids(r0);
        r2 = this.c.a(r3, new a0());
    L9:
        HashMap r4 = new HashMap();
        Iterator r6 = r2.values().iterator();
    L11:
        if (r6.hasNext() == false) goto L13;
        Chat r7 = (Chat) r6.next();
        r4.put(r7.getId(), Integer.valueOf(r7.getLastMessagePosition()));
        goto L11
    L13:
        r1 = r4;
    L14:
        Integer r8 = (Integer) r1.get(r5);
        if (r8 != null) goto L18;
        return 0;
    L18:
        return r8.intValue();
    }

    public final Map<String, Chat> i(List<String> r3) {
        HashMap r0 = new HashMap();
        if (CollectionUtils.isEmpty(r3) == false) goto L5;
        return r0;
    L5:
        com.ss.android.lark.chat.utils.z0.a();
        MGetChatsRequest.Builder r4 = new MGetChatsRequest.Builder().chat_ids(r3);
        Map<String, Chat> r5 = (Map) SdkSender.syncSend(Command.MGET_CHATS, r4, new y());
        if (r5 == null) goto L8;
        return r5;
    L8:
        return new HashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.ss.android.lark.chat.api.service.impl.v] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Map<String, Chat> n(List<String> r4) {
        ArrayList r0 = new ArrayList(r4);
        Map<String, Chat> r5 = i(r0);
        r0.removeAll(r5.keySet());
        if (r0.isEmpty() == false) goto L5;
        return r5;
    L5:
        com.ss.android.lark.chat.utils.z0.a();
        MGetChatsRequest.Builder r1 = new MGetChatsRequest.Builder().chat_ids(r0).should_auth(Boolean.TRUE).strategy(SyncDataStrategy.FORCE_SERVER);
        Map<? extends String, ? extends Chat> r2 = this.c.f(r1, new v());
        if (r2 != null) goto L8;
        r2 = new HashMap();
    L8:
        r5.putAll(r2);
        return r5;
    }

    public static com.ss.android.lark.chat.entity.chat.a j(String r17, MGetChatsResponse r18) {
        Entity r2 = r18.entity;
        l(r2.chats, new HashMap());
        HashMap r4 = new HashMap(com.ss.android.lark.parser.internal.j.b(r2, r17).a);
        Map r3 = r2.chats;
        Map r5 = r2.open_apps;
        Map r1 = r18.chat_option_info;
        Map r6 = r2.chat_themes;
        HashMap r7 = new HashMap();
        Iterator r8 = r3.keySet().iterator();
    L3:
        ChatThemeInfo r9 = null;
        ChatThemeInfo.ThemeType r10 = null;
        r9 = null;
        if (r8.hasNext() == false) goto L8;
        String r11 = (String) r8.next();
        Chat r12 = com.ss.android.lark.parser.internal.h.a((com.bytedance.lark.pb.basic.v1.Chat) r3.get(r11), null);
        if (r12 == null) goto L3;
        r7.put(r11, r12);
        goto L3
    L8:
        HashMap r13 = new HashMap();
        Iterator r14 = r5.keySet().iterator();
    L10:
        if (r14.hasNext() == false) goto L14;
        String r15 = (String) r14.next();
        OpenApp r16 = (OpenApp) r5.get(r15);
        if (r16 == null) goto L10;
        r13.put(r15, com.ss.android.lark.parser.internal.h.c(r16));
        goto L10
    L14:
        Iterator r19 = r4.entrySet().iterator();
    L16:
        if (r19.hasNext() == false) goto L22;
        Chatter r20 = (Chatter) ((Map.Entry) r19.next()).getValue();
        if (r20 == null) goto L16;
        if (r20.getType() != Chatter.ChatterType.BOT) goto L16;
    L23:
        Chat r21 = (Chat) r7.get(r17);
        ChatOptionInfo r22 = new ChatOptionInfo();
        if (CollectionUtils.isNotEmpty(r1) == true) goto L26;
    L30:
        if (r21 == null) goto L32;
        r21.setChatOptionInfo(r22);
    L32:
        if (r20 != null) goto L34;
    L39:
        com.ss.android.lark.biz.im.api.OpenApp r0 = new com.ss.android.lark.biz.im.api.OpenApp();
    L40:
        if (r21 == null) goto L77;
        long r23 = r21.getThemeId();
        int r24 = com.ss.android.lark.parser.internal.m.a;
        Intrinsics.checkNotNullParameter(r6, "chatThemes");
        ByteString r25 = (ByteString) r6.get(Long.valueOf(r23));
        if (r25 == null) goto L77;
        ChatTheme r26 = (ChatTheme) ChatTheme.ADAPTER.decode(r25);
        ChatBackgroundEntity r27 = r26.mbackground_entity;
        if (r27 == null) goto L57;
        com.ss.android.lark.chat.entity.wallpaper.ChatBackgroundEntity.BackgroundMode.a r28 = com.ss.android.lark.chat.entity.wallpaper.ChatBackgroundEntity.BackgroundMode.Companion;
        int r29 = r27.mmode.getValue();
        r28.getClass();
        com.ss.android.lark.chat.entity.wallpaper.ChatBackgroundEntity.BackgroundMode r30 = com.ss.android.lark.chat.entity.wallpaper.ChatBackgroundEntity.BackgroundMode.a.a(r29);
        ChatBackgroundEntity.ColorInfo r31 = r27.mcolor;
        if (r31 == null) goto L49;
        String r110 = r31.mud_token;
    L50:
        if (r31 == null) goto L52;
        Integer r111 = r31.mlight_color;
    L53:
        if (r31 == null) goto L55;
        Integer r32 = r31.mdark_color;
    L56:
        com.ss.android.lark.chat.entity.wallpaper.ChatBackgroundEntity r112 = new com.ss.android.lark.chat.entity.wallpaper.ChatBackgroundEntity(r30, new com.ss.android.lark.chat.entity.wallpaper.ChatBackgroundEntity.ColorInfo(r110, r111, r32), r27.mimage_key, r27.mfsunit);
    L58:
        ChatTheme.Scene r33 = r26.mcomponent_scene;
        if (r33 == null) goto L71;
        ChatThemeInfo.Scene.a r34 = ChatThemeInfo.Scene.Companion;
        int r35 = r33.getValue();
        r34.getClass();
        if (r35 != 0) goto L63;
        ChatThemeInfo.Scene r36 = ChatThemeInfo.Scene.DEFAULT_SCENE;
    L70:
        ChatThemeInfo.Scene r113 = r36;
    L72:
        Long r114 = r26.mid;
        String r115 = r26.mname;
        HashMap r116 = new HashMap();
        r116.putAll(r26.mi18n_name);
        ChatTheme.ThemeType r37 = r26.mtheme_type;
        if (r37 == null) goto L75;
        ChatThemeInfo.ThemeType.a r38 = ChatThemeInfo.ThemeType.Companion;
        Integer r39 = Integer.valueOf(r37.getValue());
        r38.getClass();
        r10 = ChatThemeInfo.ThemeType.a.a(r39);
    L75:
        r9 = new ChatThemeInfo(r114, r112, r113, r115, r116, r10);
        goto L77
    L63:
        if (r35 != 1) goto L65;
        r36 = ChatThemeInfo.Scene.DARK;
        goto L70
    L65:
        if (r35 == 2) goto L67;
        r36 = null;
        goto L70
    L67:
        r36 = ChatThemeInfo.Scene.BRIGHT;
        goto L70
    L71:
        r113 = null;
        goto L72
    L55:
        r32 = null;
        goto L56
    L52:
        r111 = null;
        goto L53
    L49:
        r110 = null;
        goto L50
    L57:
        r112 = null;
    L77:
        return new com.ss.android.lark.chat.entity.chat.a(r21, r0, r20, r9);
    L34:
        if (r13.size() == 0) goto L39;
        r0 = (com.ss.android.lark.biz.im.api.OpenApp) r13.get(r20.getOpenAppId());
        if (r0 != null) goto L40;
        r0 = new com.ss.android.lark.biz.im.api.OpenApp();
        goto L40
    L26:
        if (r1.get(r17) == null) goto L30;
        com.bytedance.lark.pb.basic.v1.ChatOptionInfo r40 = (com.bytedance.lark.pb.basic.v1.ChatOptionInfo) r1.get(r17);
        if (r40 == null) goto L30;
        r22.setAnnounceIsUnread(r40.announce.booleanValue());
        r22.setId(r40.id);
        goto L30
    L22:
        r20 = null;
        goto L23
    }

    public static void l(Map<String, com.bytedance.lark.pb.basic.v1.Chat> r6, Map<String, ChatSetting> r7) {
        Iterator<String> r0 = r6.keySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        String r1 = r0.next();
        com.bytedance.lark.pb.basic.v1.Chat r2 = r6.get(r1);
        ChatSetting r3 = new ChatSetting();
        r3.setChatId(r1);
        r3.setUpdateTime(r2.update_time.longValue());
        r3.setRemind(r2.is_remind.booleanValue());
        r3.setInBox(r2.is_in_box.booleanValue());
        ((HashMap) r7).put(r1, r3);
        goto L4
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void Ac(final String r4, UIGetDataCallback r5) {
        GetChatChattersRequest.Builder r0 = new GetChatChattersRequest.Builder().chat_id(r4).offset(0);
        r0.is_from_server(Boolean.TRUE);
        r0.filter(null);
        SdkSender.asynSendRequestNonWrap(Command.GET_CHAT_CHATTERS, r0, r5, new d0(this, r4));
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void U6(String r3, IGetDataCallback<Boolean> r4) {
        DisableChatSharedRequest.Builder r5 = new DisableChatSharedRequest.Builder().message_id(r3);
        SdkSender.asynSendRequestNonWrap(Command.DISABLE_CHAT_SHARED, r5, r4, new com.bytedance.ee.bear.middleground.drive.rustsdk.init.a());
    }

    public final void e(String r4, IGetDataCallback r5) {
        this.a.getCurrentUserId();
        SdkSender.asynSendRequestNonWrap(Command.CREATE_CHAT, new CreateChatRequest.Builder().type(com.bytedance.lark.pb.basic.v1.Chat.Type.P2P).chatter_ids(CollectionUtils.asList(new String[]{r4})).is_crypto(Boolean.FALSE).chat_mode(com.bytedance.lark.pb.basic.v1.Chat.ChatMode.DEFAULT), r5, new f0(this), new com.ss.android.lark.sdk.h());
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void getP2pChatCreatedByChatterId(final String r2, final IGetDataCallback<Chat> r3) {
        if (TextUtils.isEmpty(r2) == false) goto L6;
        r3.onError(new ErrorResult("chatterId is empty"));
        return;
    L6:
        RxScheduledExecutor.justInIO(new c0(this, r2, r3));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.ss.android.lark.chat.api.service.impl.r] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void y3(String r3, ChatNameRenderer$doHideTranslate$1 r4) {
        Long r5 = Long.valueOf(CastLongProtector.parseLong(r3));     // Catch: NumberFormatException -> L5
        HideChatTranslatedNameRequest.Builder r6 = new HideChatTranslatedNameRequest.Builder().chat_id(r5);
        this.c.d(r6, new r(), r4);
        return;
    }

    public static void b(String r2, Iterable r3, IGetDataCallback r4) {
        ArrayList r0 = new ArrayList();
        Iterator r5 = r3.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        r0.add((String) r5.next());
        goto L4
    L6:
        AddChatChattersRequest.Builder r6 = new AddChatChattersRequest.Builder().chat_id(r2).chatter_ids(r0).type(AddChatChattersRequest.Type.INVITATION);
        SdkSender.asynSendRequestNonWrap(Command.ADD_CHAT_CHATTERS, r6, r4, new b());
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void L9(String r1, String r2, final IIMApiImpl.peakFeedCard.1 r3) {
        Chat r4 = getP2pChatByChatterId(r1);
        if (r4 == null) goto L5;
        r3.onSuccess(r4);
        return;
    L5:
        e(r1, new AnonymousClass26(this, r3));
    }

    public final void c(List<String> r2, String r3, IGetDataCallback<Map<String, Boolean>> r4) {
        CheckChattersInChatRequest.Builder r5 = new CheckChattersInChatRequest.Builder().chat_id(r3).chatter_ids(r2);
        SdkSender.asynSendRequestNonWrap(Command.CHECK_CHATTERS_IN_CHAT, r5, r4, new s());
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void f2(List<GroupRecallEntity> r8, String r9, final IGetDataCallback<List<GroupRecallEntity>> r10) {
        final HashMap r0 = new HashMap(r8.size());
        Iterator<GroupRecallEntity> r1 = r8.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        GroupRecallEntity r2 = r1.next();
        r0.put(r2.b, r2);
        goto L4
    L6:
        CheckWithdrawPickEntitiesInChatRequest.Builder r3 = new CheckWithdrawPickEntitiesInChatRequest.Builder();
        r3.mchat_id = r9;
        int r11 = com.ss.android.lark.parser.internal.v.a;
        Intrinsics.checkNotNullParameter(r8, "sourcePickEntities");
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator<GroupRecallEntity> r13 = r8.iterator();
    L8:
        if (r13.hasNext() == false) goto L33;
        GroupRecallEntity r4 = r13.next();
        Integer r5 = Integer.valueOf(r4.a);
        if (r5 != null) goto L13;
    L15:
        if (r5 != null) goto L18;
    L20:
        if (r5 != null) goto L23;
    L25:
        PickType r6 = PickType.UNKNOWN;
    L26:
        Pair r7 = (Pair) r12.get(r6);
        if (r7 != null) goto L29;
        PickEntities.Builder r14 = new PickEntities.Builder().pick_type(r6);
        Pair r15 = new Pair(new ArrayList(), r14);
        r12.put(r6, r15);
        r7 = r15;
    L29:
        List r16 = (List) r7.first;
        String r17 = r4.b;
        if (r17 != null) goto L32;
        r17 = BuildConfig.FLAVOR;
    L32:
        r16.add(r17);
        goto L8
    L23:
        if (r5.intValue() != 3) goto L25;
        r6 = PickType.DEPT;
        goto L26
    L18:
        if (r5.intValue() != 1) goto L20;
        r6 = PickType.USER;
        goto L26
    L13:
        if (r5.intValue() != 2) goto L15;
        r6 = PickType.CHAT;
        goto L26
    L33:
        ArrayList r18 = new ArrayList(r12.values().size());
        Iterator r19 = r12.values().iterator();
    L35:
        if (r19.hasNext() == false) goto L37;
        Pair r20 = (Pair) r19.next();
        PickEntities.Builder r21 = (PickEntities.Builder) r20.second;
        r21.pick_ids((List) r20.first);
        r18.add(r21.build());
        goto L35
    L37:
        r3.mpick_entities = r18;
        com.ss.android.lark.pb.improto.Command r22 = com.ss.android.lark.pb.improto.Command.CHECK_WITHDRAW_PICK_ENTITIES_IN_CHAT;
        IGetDataCallback<CheckWithdrawPickEntitiesInChatResponse> r23 = new AnonymousClass7(this, r0, r10);
        final ProtoAdapter r110 = CheckWithdrawPickEntitiesInChatResponse.ADAPTER;
        Objects.requireNonNull(r110);
        SdkSender.sendPassThroughRequest(r22, r3, r23, new u(r110));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.ss.android.lark.chat.api.service.impl.w] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void t8(String r2, int r3, int r4) {
        CreateChatLastReadPositionRequest.Builder r0 = new CreateChatLastReadPositionRequest.Builder();
        r0.chat_id(r2).position(Integer.valueOf(r3)).offset(Float.valueOf(r4));
        this.c.h(r0, new w());
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void t9(String r2, String r3, UIGetDataCallback r4) {
        AddChatChattersRequest.Builder r5 = new AddChatChattersRequest.Builder().message_id(r2).join_token(r3).type(AddChatChattersRequest.Type.SHARE);
        SdkSender.asynSendRequestNonWrap(Command.ADD_CHAT_CHATTERS, r5, r4, new j0());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.ss.android.lark.chat.api.service.impl.b0] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void u2(List<String> r3, List<String> r4, SubscribeChatEventRequest.SubscriptionKey r5) {
        SubscribeChatEventRequest.Builder r0 = new SubscribeChatEventRequest.Builder();
        if (CollectionUtils.isNotEmpty(r3) == false) goto L6;
        r0.subscribe_chat_ids(r3);
    L6:
        if (CollectionUtils.isNotEmpty(r4) == false) goto L8;
        r0.unsubscribe_chat_ids(r4);
    L8:
        if (r5 == null) goto L10;
        r0.subscription_key(r5);
    L10:
        IGetDataCallback<String> r6 = new AnonymousClass31(this);
        this.c.e(r0, new b0(), r6);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final ImageHistoryResponse ze(String r2, String r3, ImageHistoryResponse.Direction r4) {
        GetChatResourcesRequest.Builder r5 = new GetChatResourcesRequest.Builder().chat_id(r2).direction(GetChatResourcesRequest.Direction.fromValue(r4.getNumber())).count(10);
        if (CollectionUtils.isEmpty(g()) == true) goto L6;
        r5.resource_types(g());
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L9;
        r5.message_id(r3);
    L9:
        return (ImageHistoryResponse) SdkSender.syncSend(Command.GET_CHAT_RESOURCES, r5, new l0(r2));
    }

    public static void a(String r3, List r4, List r5, com.ss.android.lark.chat.entity.chatter.a r6) {
        Iterator r7 = r4.iterator();
    L4:
        if (r7.hasNext() == false) goto L9;
        String r0 = (String) r7.next();
        ChatChatter r1 = r6.b(r3, r0);
        if (r1 != null) goto L7;
        Log.e("ChatService", "has no chatter entity, chatId: " + r3 + "  chatterId: " + r0);
        goto L4
    L7:
        ((ArrayList) r5).add(r1);
        goto L4
    }

    public static ccb.d k(String r9, String r10, GetMentionChatChattersResponse r11, boolean r12) {
        if (r11 == null) goto L39;
        Entity r0 = r11.entity;
        if (r0 == null) goto L39;
        com.ss.android.lark.chat.entity.chatter.a r1 = com.ss.android.lark.parser.internal.j.b(r0, r10);
        ArrayList r2 = new ArrayList();
        ArrayList r3 = new ArrayList();
        ArrayList r4 = new ArrayList();
        ArrayList r5 = new ArrayList();
        Iterator r6 = r11.wanted_mention_ids.iterator();
    L8:
        if (r6.hasNext() == false) goto L14;
        ChatChatter r7 = r1.b(r10, (String) r6.next());
        if (r7 == null) goto L8;
        r2.add(r7);
        if (r12 == true) goto L8;
        r7.setChatterSensitiveInfo(new ChatterSensitiveInfo());
        goto L8
    L14:
        Iterator r8 = r11.in_chat_chatter_ids.iterator();
    L16:
        if (r8.hasNext() == false) goto L22;
        ChatChatter r13 = r1.b(r10, (String) r8.next());
        if (r13 == null) goto L16;
        r3.add(r13);
        if (r12 == true) goto L16;
        r13.setChatterSensitiveInfo(new ChatterSensitiveInfo());
        goto L16
    L22:
        Iterator r14 = r11.out_chat_chatter_ids.iterator();
    L24:
        if (r14.hasNext() == false) goto L31;
        ChatChatter r15 = r1.b(r10, (String) r14.next());
        if (r15 == null) goto L24;
        r4.add(new ChatChatter(r15));
        if (r12 == true) goto L24;
        r15.setChatterSensitiveInfo(new ChatterSensitiveInfo());
        goto L24
    L31:
        if (vab.a.c == false) goto L37;
        Iterator r16 = r11.user_groups.iterator();
    L34:
        if (r16.hasNext() == false) goto L37;
        GetMentionChatChattersResponse.UserGroupEntity r17 = (GetMentionChatChattersResponse.UserGroupEntity) r16.next();
        r5.add(new UserGroupEntity(r17.group_id.toString(), r17.group_name, r17.group_member_count.toString(), r17.group_member_in_chat_count.toString()));
    L37:
        return new ccb.d(r2, r3, r4, r5, r11.wanted_mention_tags, r11.show_search.booleanValue(), r9);
    L39:
        return new ccb.d();
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void Dc(String r6, Iterable r7, Iterable r8, IGetDataCallback r9) {
        ArrayList r0 = new ArrayList();
        Iterator r10 = r7.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        r0.add((String) r10.next());
        goto L4
    L6:
        ArrayList r11 = new ArrayList();
        Iterator r12 = r8.iterator();
    L8:
        if (r12.hasNext() == false) goto L10;
        r11.add((PickChatEntity) r12.next());
        goto L8
    L10:
        List r13 = com.ss.android.lark.parser.internal.v.a(r11);
        if (CollectionUtils.isEmpty(r0) == false) goto L30;
        Intrinsics.checkNotNullParameter(r11, "sourcePickEntities");
        ArrayList r1 = new ArrayList();
        Iterator r14 = r11.iterator();
    L14:
        if (r14.hasNext() == false) goto L21;
        Object r3 = r14.next();
        if (((PickChatEntity) r3).a != 1) goto L18;
        boolean r4 = true;
    L19:
        if (r4 == false) goto L14;
        r1.add(r3);
        goto L14
    L18:
        r4 = false;
        goto L19
    L21:
        ArrayList r15 = new ArrayList();
        Iterator r2 = r1.iterator();
    L23:
        if (r2.hasNext() == false) goto L28;
        String r5 = ((PickChatEntity) r2.next()).b;
        if (r5 == null) goto L23;
        r15.add(r5);
        goto L23
    L28:
        if (CollectionUtils.isNotEmpty(r15) == false) goto L30;
        r0.addAll(r15);
    L30:
        DeleteChatChattersRequest.Builder r16 = new DeleteChatChattersRequest.Builder().chat_id(r6).chatter_ids(r0).pick_entities(r13).option(new DeleteChatChattersRequest.DeleteChatChatterOption.Builder().withdraw(true).build());
        SdkSender.asynSendRequestNonWrap(Command.DELETE_CHAT_CHATTERS, r16, r9, new com.bytedance.ee.bear.middleground.drive.rustsdk.init.a());
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final ccb.d M2(String r7, String r8, String r9, boolean r10) {
        return o(r7, r8, r9, r10, false);
    }

    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final ImageHistoryResponse Ne(String r2, String r3, ImageHistoryResponse.Direction r4, int r5) {
        GetChatResourcesRequest.Builder r6 = new GetChatResourcesRequest.Builder().chat_id(r2).direction(GetChatResourcesRequest.Direction.fromValue(r4.getNumber())).count(Integer.valueOf(r5));
        if (CollectionUtils.isEmpty(g()) == true) goto L6;
        r6.resource_types(g());
    L6:
        if (TextUtils.isEmpty(r3) == true) goto L9;
        r6.message_id(r3);
    L9:
        return (ImageHistoryResponse) SdkSender.syncSend(Command.GET_CHAT_RESOURCES, r6, new m0(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.ss.android.lark.chat.api.service.impl.e0] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.ss.android.lark.chat.api.service.IChatService
    public final void h3(String r3, String r4, boolean r5, ChatNameRenderer$doTranslate$1 r6) {
        Long r7 = Long.valueOf(CastLongProtector.parseLong(r3));     // Catch: NumberFormatException -> L5
        TranslateChatNameRequest.Builder r8 = new TranslateChatNameRequest.Builder().chat_id(r7).is_manual(Boolean.TRUE).target_language(r4).is_switch_language(Boolean.valueOf(r5));
        this.c.g(r8, new e0(), r6);
        return;
    }

    public final ccb.d o(final String r3, final String r4, final String r5, boolean r6, boolean r7) {
        GetMentionChatChattersRequest.Builder r0 = new GetMentionChatChattersRequest.Builder();
        r0.chat_id(r3).query(r4).is_from_server(Boolean.valueOf(r6)).enableAiKnowledge(Boolean.valueOf(r7));
        return (ccb.d) SdkSender.sendRequest(Command.GET_MENTION_CHAT_CHATTERS, r0, r5, new z(this, r5, r3, r4));
    }

    public final void m(final String r3, final String r4, final String r5, boolean r6, boolean r7, IGetDataCallback<ccb.d> r8) {
        GetMentionChatChattersRequest.Builder r0 = new GetMentionChatChattersRequest.Builder();
        r0.chat_id(r3).query(r4).is_from_server(Boolean.valueOf(r6)).enableAiKnowledge(Boolean.valueOf(r7));
        StringBuilder r9 = new StringBuilder("searchMentionChatChatters has query : ");
        r9.append(!TextUtils.isEmpty(r4));
        Log.i("ChatService", r9.toString());
        SdkSender.asynSendRequestNonWrap(Command.GET_MENTION_CHAT_CHATTERS, r0, r5, r8, new q(this, r5, r3, r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.ss.android.lark.chat.api.service.impl.x] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void d(String r2, AddChatChatterApply$Ways r3, List<String> r4, String r5, String r6, String r7, IGetDataCallback<Boolean> r8) {
        CreateAddChatChatterApplyRequest.Builder r9 = new CreateAddChatChatterApplyRequest.Builder().chat_id(r2).way(AddChatChatterApply.Ways.fromValue(r3.getValue())).reason(r5).chatter_ids(r4).inviter_id(r6).join_token(r7);
        if (TextUtils.isEmpty(null) == true) goto L5;
        r9.event_id(null);
    L5:
        this.c.c(r9, new x(), r8);
    }
}
