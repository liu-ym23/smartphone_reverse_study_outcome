package com.ss.android.lark.chat.entity.message;

import com.ss.android.lark.biz.im.api.ThreadTopic;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\b\u0012\u0004\u0012\u00020\u00000\u0004:\u0002+,BW\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n\u0012\"\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r`\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0000H\u0096\u0002J\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010!\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0000H\u0016J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\u0019\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nHÆ\u0003J%\u0010$\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r`\u000eHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0010HÆ\u0003J_\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0018\b\u0002\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2$\b\u0002\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r`\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010'\u001a\u00020\u001f2\b\u0010\u001d\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020\u001cHÖ\u0001J\t\u0010*\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R-\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\r`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006-"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageLink;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/larksuite/framework/utils/diff/Diffable;", "token", BuildConfig.FLAVOR, "entityIds", "Ljava/util/ArrayList;", BuildConfig.FLAVOR, "Lkotlin/collections/ArrayList;", "messageInfos", "Ljava/util/HashMap;", "Lcom/ss/android/lark/chat/entity/message/MessageInfo;", "Lkotlin/collections/HashMap;", "chatInfo", "Lcom/ss/android/lark/chat/entity/message/MessageLink$ChatInfo;", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;Ljava/util/HashMap;Lcom/ss/android/lark/chat/entity/message/MessageLink$ChatInfo;)V", "getToken", "()Ljava/lang/String;", "getEntityIds", "()Ljava/util/ArrayList;", "getMessageInfos", "()Ljava/util/HashMap;", "getChatInfo", "()Lcom/ss/android/lark/chat/entity/message/MessageLink$ChatInfo;", "compareTo", BuildConfig.FLAVOR, "other", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "hashCode", "toString", "Entity", "ChatInfo", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageLink implements Serializable, Cloneable, Comparable<MessageLink>, b<MessageLink> {
    private final ChatInfo chatInfo;
    private final ArrayList<Long> entityIds;
    private final HashMap<String, MessageInfo> messageInfos;
    private final String token;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003JA\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00072\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageLink$ChatInfo;", "Ljava/io/Serializable;", "chatName", BuildConfig.FLAVOR, "groupType", "Lcom/ss/android/lark/chat/entity/chat/Chat$Type;", "isP2PBot", BuildConfig.FLAVOR, "chatId", "isAuth", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chat/entity/chat/Chat$Type;ZLjava/lang/String;Z)V", "getChatName", "()Ljava/lang/String;", "getGroupType", "()Lcom/ss/android/lark/chat/entity/chat/Chat$Type;", "()Z", "getChatId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ChatInfo implements Serializable {
        private final String chatId;
        private final String chatName;
        private final Chat.Type groupType;
        private final boolean isAuth;
        private final boolean isP2PBot;

        public static /* synthetic */ ChatInfo copy$default(ChatInfo r3, String r4, Chat.Type r5, boolean r6, String r7, boolean r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.chatName;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.groupType;
        L8:
            Chat.Type r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.isP2PBot;
        L11:
            boolean r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.chatId;
        L14:
            String r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.isAuth;
        L17:
            String r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final String component1() {
            return this.chatName;
        }

        public final Chat.Type component2() {
            return this.groupType;
        }

        public final boolean component3() {
            return this.isP2PBot;
        }

        public final String component4() {
            return this.chatId;
        }

        public final boolean component5() {
            return this.isAuth;
        }

        public final ChatInfo copy(String r8, Chat.Type r9, boolean r10, String r11, boolean r12) {
            return new ChatInfo(r8, r9, r10, r11, r12);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ChatInfo) == true) goto L8;
            return false;
        L8:
            ChatInfo r6 = (ChatInfo) r5;
            if (Intrinsics.areEqual(this.chatName, r6.chatName) == true) goto L12;
            return false;
        L12:
            if (this.groupType == r6.groupType) goto L15;
            return false;
        L15:
            if (this.isP2PBot == r6.isP2PBot) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.chatId, r6.chatId) == true) goto L21;
            return false;
        L21:
            if (this.isAuth == r6.isAuth) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            String r0 = this.chatName;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            Chat.Type r4 = this.groupType;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            int r7 = 1231;
            if (this.isP2PBot == false) goto L13;
            int r8 = 1231;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.chatId;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            int r11 = (r9 + r1) * 31;
            if (this.isAuth == true) goto L23;
            r7 = 1237;
        L23:
            return r11 + r7;
        L13:
            r8 = 1237;
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "ChatInfo(chatName=" + this.chatName + ", groupType=" + this.groupType + ", isP2PBot=" + this.isP2PBot + ", chatId=" + this.chatId + ", isAuth=" + this.isAuth + ')';
        }

        public final String getChatId() {
            return this.chatId;
        }

        public final String getChatName() {
            return this.chatName;
        }

        public final Chat.Type getGroupType() {
            return this.groupType;
        }

        public final boolean isAuth() {
            return this.isAuth;
        }

        public final boolean isP2PBot() {
            return this.isP2PBot;
        }

        public ChatInfo(String r1, Chat.Type r2, boolean r3, String r4, boolean r5) {
            this.chatName = r1;
            this.groupType = r2;
            this.isP2PBot = r3;
            this.chatId = r4;
            this.isAuth = r5;
        }

        public /* synthetic */ ChatInfo(String r7, Chat.Type r8, boolean r9, String r10, boolean r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 8) == 0) goto L5;
            r10 = null;
        L5:
            String r4 = r10;
            if ((r12 & 16) == 0) goto L8;
            boolean r5 = true;
        L9:
            this(r7, r8, r9, r4, r5);
            return;
        L8:
            r5 = r11;
            goto L9
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/MessageLink$Entity;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "message", "Lcom/ss/android/lark/chat/entity/message/Message;", "thread", "Lcom/ss/android/lark/biz/im/api/ThreadTopic;", "<init>", "(Lcom/ss/android/lark/chat/entity/message/Message;Lcom/ss/android/lark/biz/im/api/ThreadTopic;)V", "getMessage", "()Lcom/ss/android/lark/chat/entity/message/Message;", "getThread", "()Lcom/ss/android/lark/biz/im/api/ThreadTopic;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Entity implements Serializable, Cloneable {
        private final Message message;
        private final ThreadTopic thread;

        public static /* synthetic */ Entity copy$default(Entity r0, Message r1, ThreadTopic r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.message;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.thread;
        L9:
            return r0.copy(r1, r2);
        }

        public final Message component1() {
            return this.message;
        }

        public final ThreadTopic component2() {
            return this.thread;
        }

        public final Entity copy(Message r2, ThreadTopic r3) {
            return new Entity(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Entity) == true) goto L8;
            return false;
        L8:
            Entity r6 = (Entity) r5;
            if (Intrinsics.areEqual(this.message, r6.message) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.thread, r6.thread) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            Message r0 = this.message;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            ThreadTopic r4 = this.thread;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "Entity(message=" + this.message + ", thread=" + this.thread + ')';
        }

        public Object clone() {
            return super.clone();
        }

        public final Message getMessage() {
            return this.message;
        }

        public final ThreadTopic getThread() {
            return this.thread;
        }

        public Entity(Message r1, ThreadTopic r2) {
            this.message = r1;
            this.thread = r2;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageLink copy$default(MessageLink r0, String r1, ArrayList r2, HashMap r3, ChatInfo r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.token;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.entityIds;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.messageInfos;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.chatInfo;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(MessageLink r2) {
        Intrinsics.checkNotNullParameter(r2, "other");
        return 0;
    }

    public final String component1() {
        return this.token;
    }

    public final ArrayList<Long> component2() {
        return this.entityIds;
    }

    public final HashMap<String, MessageInfo> component3() {
        return this.messageInfos;
    }

    public final ChatInfo component4() {
        return this.chatInfo;
    }

    public final MessageLink copy(String r2, ArrayList<Long> r3, HashMap<String, MessageInfo> r4, ChatInfo r5) {
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r3, "entityIds");
        Intrinsics.checkNotNullParameter(r4, "messageInfos");
        return new MessageLink(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MessageLink) == true) goto L8;
        return false;
    L8:
        MessageLink r6 = (MessageLink) r5;
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.entityIds, r6.entityIds) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.messageInfos, r6.messageInfos) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.chatInfo, r6.chatInfo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.token.hashCode() * 31) + this.entityIds.hashCode()) * 31) + this.messageInfos.hashCode()) * 31;
        ChatInfo r1 = this.chatInfo;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "MessageLink(token=" + this.token + ", entityIds=" + this.entityIds + ", messageInfos=" + this.messageInfos + ", chatInfo=" + this.chatInfo + ')';
    }

    public Object clone() {
        return super.clone();
    }

    public final ChatInfo getChatInfo() {
        return this.chatInfo;
    }

    public final ArrayList<Long> getEntityIds() {
        return this.entityIds;
    }

    public final HashMap<String, MessageInfo> getMessageInfos() {
        return this.messageInfos;
    }

    public final String getToken() {
        return this.token;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(MessageLink r1) {
        return compareTo2(r1);
    }

    public boolean isContentSame(MessageLink r4) {
        if (r4 != null) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.token, r4.token) == true) goto L9;
        return false;
    L9:
        if (y28.a.b(CollectionsKt.toMutableList(this.messageInfos.values()), CollectionsKt.toMutableList(r4.messageInfos.values())) == true) goto L11;
        return false;
    L11:
        ChatInfo r1 = this.chatInfo;
        if (r1 != null) goto L14;
    L16:
        boolean r5 = false;
    L17:
        if (r5 == false) goto L19;
        return false;
    L19:
        return true;
    L14:
        if (r1.equals(r4.chatInfo) == true) goto L16;
        r5 = true;
        goto L17
    }

    public boolean isItemSame(MessageLink r2) {
        if (Intrinsics.areEqual(this, r2) == false) goto L6;
        return true;
    L6:
        String r0 = this.token;
        if (r2 == null) goto L9;
        String r3 = r2.token;
    L11:
        return Intrinsics.areEqual(r0, r3);
    L9:
        r3 = null;
        goto L11
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((MessageLink) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((MessageLink) r1);
    }

    public MessageLink(String r2, ArrayList<Long> r3, HashMap<String, MessageInfo> r4, ChatInfo r5) {
        Intrinsics.checkNotNullParameter(r2, "token");
        Intrinsics.checkNotNullParameter(r3, "entityIds");
        Intrinsics.checkNotNullParameter(r4, "messageInfos");
        this.token = r2;
        this.entityIds = r3;
        this.messageInfos = r4;
        this.chatInfo = r5;
    }

    public /* synthetic */ MessageLink(String r1, ArrayList r2, HashMap r3, ChatInfo r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        this(r1, r2, r3, r4);
    }
}
