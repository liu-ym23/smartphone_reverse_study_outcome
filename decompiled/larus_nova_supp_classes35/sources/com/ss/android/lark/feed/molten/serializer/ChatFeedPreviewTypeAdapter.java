package com.ss.android.lark.feed.molten.serializer;

import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.Tag;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.feed.shared.data.preview.ChatFeedPreview;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001Bo\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006\u0012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0006\u0012\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u0006\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0002H\u0016J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\r0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/ChatFeedPreviewTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/feed/shared/data/preview/ChatFeedPreview;", "fieldCodec", "Lcom/ss/android/lark/feed/molten/serializer/FeedPreviewFieldCodec;", "chatTypeAdapter", "Lcom/google/gson/TypeAdapter;", "Lcom/ss/android/lark/chat/entity/chat/Chat$Type;", "chatModeAdapter", "Lcom/ss/android/lark/chat/entity/chat/Chat$ChatMode;", "lastMessageTypeAdapter", "Lcom/ss/android/lark/chat/entity/message/Message$Type;", "tagListAdapter", BuildConfig.FLAVOR, "Lcom/bytedance/lark/pb/basic/v1/Tag;", "statusListAdapter", "Lcom/bytedance/lark/pb/basic/v1/Chatter$ChatterCustomStatus;", "chatRoleAdapter", "Lcom/ss/android/lark/chat/entity/chat/Chat$Role;", "<init>", "(Lcom/ss/android/lark/feed/molten/serializer/FeedPreviewFieldCodec;Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;Lcom/google/gson/TypeAdapter;)V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatFeedPreviewTypeAdapter extends JsonTreeTypeAdapter<ChatFeedPreview> {
    public final c a;
    public final TypeAdapter<Chat.Type> b;
    public final TypeAdapter<Chat.ChatMode> c;
    public final TypeAdapter<Message.Type> d;
    public final TypeAdapter<List<Tag>> e;
    public final TypeAdapter<List<Chatter.ChatterCustomStatus>> f;
    public final TypeAdapter<Chat.Role> g;

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final /* bridge */ /* synthetic */ ChatFeedPreview a(JsonObject r1) {
        return c(r1);
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final /* bridge */ /* synthetic */ JsonObject b(ChatFeedPreview r1) {
        return d(r1);
    }

    public final ChatFeedPreview c(JsonObject r6) {
        Intrinsics.checkNotNullParameter(r6, "json");
        ChatFeedPreview r0 = new ChatFeedPreview();
        this.a.a(r6, r0);
        Boolean r1 = a.c(r6, "isBotChat");
        int r2 = 0;
        if (r1 == null) goto L5;
        boolean r3 = r1.booleanValue();
    L6:
        r0.setBotChat(r3);
        Boolean r4 = a.c(r6, "isBotMute");
        if (r4 == null) goto L9;
        boolean r5 = r4.booleanValue();
    L10:
        r0.setBotMute(r5);
        Boolean r7 = a.c(r6, "isBlocked");
        if (r7 == null) goto L13;
        boolean r8 = r7.booleanValue();
    L14:
        r0.setBlocked(r8);
        Boolean r9 = a.c(r6, "isMeeting");
        if (r9 == null) goto L17;
        boolean r10 = r9.booleanValue();
    L18:
        r0.setMeeting(r10);
        Boolean r11 = a.c(r6, "isSecret");
        if (r11 == null) goto L21;
        boolean r12 = r11.booleanValue();
    L22:
        r0.setSecret(r12);
        Boolean r13 = a.c(r6, "isShowBotTag");
        if (r13 == null) goto L25;
        boolean r14 = r13.booleanValue();
    L26:
        r0.setShowBotTag(r14);
        Boolean r15 = a.c(r6, "isShowAgentTag");
        if (r15 == null) goto L29;
        boolean r16 = r15.booleanValue();
    L30:
        r0.setShowAgentTag(r16);
        Boolean r17 = a.c(r6, "isCrossWithKa");
        if (r17 == null) goto L33;
        boolean r18 = r17.booleanValue();
    L34:
        r0.setCrossWithKa(r18);
        Chat.Type r19 = (Chat.Type) a.k(r6, "chatType", this.b);
        if (r19 == null) goto L37;
        r0.setChatType(r19);
    L37:
        Chat.ChatMode r20 = (Chat.ChatMode) a.k(r6, "chatMode", this.c);
        if (r20 == null) goto L40;
        r0.setChatMode(r20);
    L40:
        Message.Type r21 = (Message.Type) a.k(r6, "lastMessageType", this.d);
        if (r21 == null) goto L43;
        r0.setLastMessageType(r21);
    L43:
        Boolean r22 = a.c(r6, "isDepartment");
        if (r22 == null) goto L46;
        boolean r23 = r22.booleanValue();
    L47:
        r0.setDepartment(r23);
        Boolean r24 = a.c(r6, "isTenantChat");
        if (r24 == null) goto L50;
        boolean r25 = r24.booleanValue();
    L51:
        r0.setTenantChat(r25);
        Boolean r26 = a.c(r6, "isSuper");
        if (r26 == null) goto L54;
        boolean r27 = r26.booleanValue();
    L55:
        r0.setSuper(r27);
        Boolean r28 = a.c(r6, "isPublic");
        if (r28 == null) goto L58;
        boolean r29 = r28.booleanValue();
    L59:
        r0.setPublic(r29);
        Boolean r30 = a.c(r6, "isOfficialOncall");
        if (r30 == null) goto L62;
        boolean r31 = r30.booleanValue();
    L63:
        r0.setOfficialOncall(r31);
        Boolean r32 = a.c(r6, "isOfflineOncall");
        if (r32 == null) goto L66;
        boolean r33 = r32.booleanValue();
    L67:
        r0.setOfflineOncall(r33);
        r0.setOnCallId(a.l(r6, "onCallId"));
        Long r34 = a.f(r6, "zenModeEndTime");
        if (r34 == null) goto L70;
        long r35 = r34.longValue();
    L71:
        r0.setZenModeEndTime(r35);
        r0.setMiniAvatarKey(a.l(r6, "miniAvatarKey"));
        r0.setP2pChatterId(a.l(r6, "p2pChatterId"));
        Boolean r36 = a.c(r6, "isMyThreadUpdated");
        if (r36 == null) goto L74;
        boolean r37 = r36.booleanValue();
    L75:
        r0.setMyThreadUpdated(r37);
        List<Tag> r38 = a.b(r6, "tags", this.e);
        if (r38 != null) goto L78;
        r38 = CollectionsKt.emptyList();
    L78:
        r0.setTags(r38);
        Integer r39 = a.e(r6, "chatterApplyCount");
        if (r39 == null) goto L81;
        int r40 = r39.intValue();
    L82:
        r0.setChatterApplyCount(r40);
        Boolean r41 = a.c(r6, "isSpecialFocus");
        if (r41 == null) goto L85;
        boolean r42 = r41.booleanValue();
    L86:
        r0.setSpecialFocus(r42);
        r0.setStatus(a.b(r6, "status", this.f));
        Chat.Role r43 = (Chat.Role) a.k(r6, "chatRole", this.g);
        if (r43 == null) goto L89;
        r0.setChatRole(r43);
    L89:
        r0.setOrderAvatarKey(a.l(r6, "orderAvatarKey"));
        Boolean r44 = a.c(r6, "showSwitch");
        if (r44 == null) goto L92;
        boolean r45 = r44.booleanValue();
    L93:
        r0.setShowSwitch(r45);
        Integer r46 = a.e(r6, "userCount");
        if (r46 == null) goto L96;
        int r47 = r46.intValue();
    L97:
        r0.setUserCount(r47);
        Boolean r48 = a.c(r6, "isUserCountVisible");
        if (r48 == null) goto L100;
        boolean r49 = r48.booleanValue();
    L101:
        r0.setUserCountVisible(r49);
        Boolean r50 = a.c(r6, "isFrozen");
        if (r50 == null) goto L104;
        boolean r51 = r50.booleanValue();
    L105:
        r0.setFrozen(r51);
        Integer r52 = a.e(r6, "chatReadable");
        if (r52 == null) goto L108;
        r2 = r52.intValue();
    L108:
        r0.setChatReadable(r2);
        return r0;
    L104:
        r51 = false;
        goto L105
    L100:
        r49 = true;
        goto L101
    L96:
        r47 = 0;
        goto L97
    L92:
        r45 = false;
        goto L93
    L85:
        r42 = false;
        goto L86
    L81:
        r40 = 0;
        goto L82
    L74:
        r37 = false;
        goto L75
    L70:
        r35 = 0;
        goto L71
    L66:
        r33 = false;
        goto L67
    L62:
        r31 = false;
        goto L63
    L58:
        r29 = false;
        goto L59
    L54:
        r27 = false;
        goto L55
    L50:
        r25 = false;
        goto L51
    L46:
        r23 = false;
        goto L47
    L33:
        r18 = false;
        goto L34
    L29:
        r16 = false;
        goto L30
    L25:
        r14 = false;
        goto L26
    L21:
        r12 = false;
        goto L22
    L17:
        r10 = false;
        goto L18
    L13:
        r8 = false;
        goto L14
    L9:
        r5 = false;
        goto L10
    L5:
        r3 = false;
        goto L6
    }

    public final JsonObject d(ChatFeedPreview r5) {
        Intrinsics.checkNotNullParameter(r5, "value");
        JsonObject r0 = new JsonObject();
        e.b(r0, r5);
        this.a.b(r0, r5);
        a.g(r0, "isBotChat", Boolean.valueOf(r5.isBotChat()));
        a.g(r0, "isBotMute", Boolean.valueOf(r5.isBotMute()));
        a.g(r0, "isBlocked", Boolean.valueOf(r5.isBlocked()));
        a.g(r0, "isMeeting", Boolean.valueOf(r5.isMeeting()));
        a.g(r0, "isSecret", Boolean.valueOf(r5.isSecret()));
        a.g(r0, "isShowBotTag", Boolean.valueOf(r5.isShowBotTag()));
        a.g(r0, "isShowAgentTag", Boolean.valueOf(r5.isShowAgentTag()));
        a.g(r0, "isCrossWithKa", Boolean.valueOf(r5.isCrossWithKa()));
        a.i(r0, "chatType", r5.getChatType(), this.b);
        a.i(r0, "chatMode", r5.getChatMode(), this.c);
        a.i(r0, "lastMessageType", r5.getLastMessageType(), this.d);
        a.g(r0, "isDepartment", Boolean.valueOf(r5.isDepartment()));
        a.g(r0, "isTenantChat", Boolean.valueOf(r5.isTenantChat()));
        a.g(r0, "isSuper", Boolean.valueOf(r5.isSuper()));
        a.g(r0, "isPublic", Boolean.valueOf(r5.isPublic()));
        a.g(r0, "isOfficialOncall", Boolean.valueOf(r5.isOfficialOncall()));
        a.g(r0, "isOfflineOncall", Boolean.valueOf(r5.isOfflineOncall()));
        a.j(r0, "onCallId", r5.getOnCallId());
        a.h(r0, "zenModeEndTime", Long.valueOf(r5.getZenModeEndTime()));
        a.j(r0, "miniAvatarKey", r5.getMiniAvatarKey());
        a.j(r0, "p2pChatterId", r5.getP2pChatterId());
        a.g(r0, "isMyThreadUpdated", Boolean.valueOf(r5.isMyThreadUpdated()));
        a.a(r0, "tags", r5.getTags(), this.e);
        a.h(r0, "chatterApplyCount", Integer.valueOf(r5.getChatterApplyCount()));
        a.g(r0, "isSpecialFocus", Boolean.valueOf(r5.isSpecialFocus()));
        a.a(r0, "status", r5.getStatus(), this.f);
        a.i(r0, "chatRole", r5.getChatRole(), this.g);
        a.j(r0, "orderAvatarKey", r5.getOrderAvatarKey());
        a.g(r0, "showSwitch", Boolean.valueOf(r5.getShowSwitch()));
        a.h(r0, "userCount", Integer.valueOf(r5.getUserCount()));
        a.g(r0, "isUserCountVisible", Boolean.valueOf(r5.isUserCountVisible()));
        a.g(r0, "isFrozen", Boolean.valueOf(r5.isFrozen()));
        a.h(r0, "chatReadable", Integer.valueOf(r5.getChatReadable()));
        return r0;
    }

    public ChatFeedPreviewTypeAdapter(c r2, TypeAdapter r3, TypeAdapter r4, TypeAdapter r5, ListTypeAdapter r6, ListTypeAdapter r7, TypeAdapter r8) {
        Intrinsics.checkNotNullParameter(r2, "fieldCodec");
        Intrinsics.checkNotNullParameter(r3, "chatTypeAdapter");
        Intrinsics.checkNotNullParameter(r4, "chatModeAdapter");
        Intrinsics.checkNotNullParameter(r5, "lastMessageTypeAdapter");
        Intrinsics.checkNotNullParameter(r6, "tagListAdapter");
        Intrinsics.checkNotNullParameter(r7, "statusListAdapter");
        Intrinsics.checkNotNullParameter(r8, "chatRoleAdapter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
