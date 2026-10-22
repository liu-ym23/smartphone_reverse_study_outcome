package com.ss.android.lark.chat.entity.message.content;

import com.alibaba.fastjson.annotation.JSONType;
import com.bytedance.lark.pb.basic.v1.Thread;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.chatter.ChatterInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.reaction.Reaction;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0001mB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0013\u0010h\u001a\u00020,2\b\u0010i\u001a\u0004\u0018\u00010jH\u0096\u0002J\b\u0010k\u001a\u00020cH\u0016J\b\u0010l\u001a\u00020\u0000H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\b\"\u0004\b\u001a\u0010\nR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\b\"\u0004\b\u001d\u0010\nR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\b\"\u0004\b \u0010\nR\u001c\u0010!\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\b\"\u0004\b#\u0010\nR(\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020&\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010-\"\u0004\b.\u0010/R\u001a\u00100\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010-\"\u0004\b1\u0010/R\u001c\u00102\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\b\"\u0004\b4\u0010\nR\u001a\u00105\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010-\"\u0004\b6\u0010/R\u001a\u00107\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010-\"\u0004\b8\u0010/R\u001c\u00109\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\b\"\u0004\b;\u0010\nR\u001c\u0010<\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\b\"\u0004\b>\u0010\nR\u001c\u0010?\u001a\u0004\u0018\u00010@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u001c\u0010E\u001a\u0004\u0018\u00010FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001a\u0010K\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\b\"\u0004\bM\u0010\nR\u001a\u0010N\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\b\"\u0004\bP\u0010\nR\u001a\u0010Q\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\b\"\u0004\bS\u0010\nR,\u0010T\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0\f0%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010(\"\u0004\bW\u0010*R&\u0010X\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020Y0%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010(\"\u0004\b[\u0010*R&\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020]0%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010(\"\u0004\b_\u0010*R\u001a\u0010`\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010-\"\u0004\ba\u0010/R\u001a\u0010b\u001a\u00020cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010g¨\u0006n"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/MergeForwardContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", BuildConfig.FLAVOR, "<init>", "()V", "threadOwnerDisplayName", BuildConfig.FLAVOR, "getThreadOwnerDisplayName", "()Ljava/lang/String;", "setThreadOwnerDisplayName", "(Ljava/lang/String;)V", "messages", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/message/Message;", "getMessages", "()Ljava/util/List;", "setMessages", "(Ljava/util/List;)V", IPortraitService.TYPE, "Lcom/ss/android/lark/chat/entity/chat/Chat$Type;", "getType", "()Lcom/ss/android/lark/chat/entity/chat/Chat$Type;", "setType", "(Lcom/ss/android/lark/chat/entity/chat/Chat$Type;)V", "groupChatName", "getGroupChatName", "setGroupChatName", "p2pCreatorName", "getP2pCreatorName", "setP2pCreatorName", "p2pPartnerName", "getP2pPartnerName", "setP2pPartnerName", "quasiTitle", "getQuasiTitle", "setQuasiTitle", "chatters", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/chatter/ChatterInfo;", "getChatters", "()Ljava/util/Map;", "setChatters", "(Ljava/util/Map;)V", "isTranslated", BuildConfig.FLAVOR, "()Z", "setTranslated", "(Z)V", "isManualTranslated", "setManualTranslated", "messageId", "getMessageId", "setMessageId", "isFromPrivateTopic", "setFromPrivateTopic", "isReplyInThread", "setReplyInThread", "title", "getTitle", "setTitle", "subtitle", "getSubtitle", "setSubtitle", "originChat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getOriginChat", "()Lcom/ss/android/lark/chat/entity/chat/Chat;", "setOriginChat", "(Lcom/ss/android/lark/chat/entity/chat/Chat;)V", "thread", "Lcom/bytedance/lark/pb/basic/v1/Thread;", "getThread", "()Lcom/bytedance/lark/pb/basic/v1/Thread;", "setThread", "(Lcom/bytedance/lark/pb/basic/v1/Thread;)V", "threadId", "getThreadId", "setThreadId", "p2pThreadCreatorName", "getP2pThreadCreatorName", "setP2pThreadCreatorName", "p2pThreadPartnerName", "getP2pThreadPartnerName", "setP2pThreadPartnerName", "reactionMap", "Lcom/ss/android/lark/chat/entity/reaction/Reaction;", "getReactionMap", "setReactionMap", "reactionChatterMap", "Lcom/ss/android/lark/chat/entity/chatter/Chatter;", "getReactionChatterMap", "setReactionChatterMap", "messageThreadMap", "Lcom/ss/android/lark/chat/entity/message/content/MergeForwardContent$MessageThread;", "getMessageThreadMap", "setMessageThreadMap", "isCopyFromDoubao", "setCopyFromDoubao", "fromType", BuildConfig.FLAVOR, "getFromType", "()I", "setFromType", "(I)V", "equals", "content", BuildConfig.FLAVOR, "hashCode", "clone", "MessageThread", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JSONType(typeName = "MergeForwardContent")
public final class MergeForwardContent extends Content implements Cloneable {
    private Map<String, ? extends ChatterInfo> chatters;
    private int fromType;
    private String groupChatName;
    private boolean isCopyFromDoubao;
    private boolean isFromPrivateTopic;
    private boolean isManualTranslated;
    private boolean isReplyInThread;
    private boolean isTranslated;
    private String messageId;
    private Map<String, MessageThread> messageThreadMap;
    private List<? extends Message> messages;
    private Chat originChat;
    private String p2pCreatorName;
    private String p2pPartnerName;
    private String p2pThreadCreatorName;
    private String p2pThreadPartnerName;
    private String quasiTitle;
    private Map<String, ? extends Chatter> reactionChatterMap;
    private Map<String, ? extends List<? extends Reaction>> reactionMap;
    private String subtitle;
    private Thread thread;
    private String threadId;
    private String threadOwnerDisplayName;
    private String title;
    private Chat.Type type;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0002J\b\u0010$\u001a\u00020\u0005H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R,\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00020\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a0\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/MergeForwardContent$MessageThread;", "Ljava/io/Serializable;", "<init>", "()V", "replyCount", BuildConfig.FLAVOR, "getReplyCount", "()I", "setReplyCount", "(I)V", "latestReplyTime", BuildConfig.FLAVOR, "getLatestReplyTime", "()J", "setLatestReplyTime", "(J)V", "childMessages", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/message/Message;", "getChildMessages", "()Ljava/util/List;", "setChildMessages", "(Ljava/util/List;)V", "reactionMap", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/reaction/Reaction;", "getReactionMap", "()Ljava/util/Map;", "setReactionMap", "(Ljava/util/Map;)V", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class MessageThread implements Serializable {
        private List<Message> childMessages;
        private long latestReplyTime;
        private Map<String, ? extends List<? extends Reaction>> reactionMap;
        private int replyCount;

        public int hashCode() {
            int r0 = this.replyCount * 31;
            long r1 = this.latestReplyTime;
            return ((((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.childMessages.hashCode()) * 31) + this.reactionMap.hashCode();
        }

        public MessageThread() {
            this.childMessages = new ArrayList();
            this.reactionMap = new HashMap();
        }

        public final List<Message> getChildMessages() {
            return this.childMessages;
        }

        public final long getLatestReplyTime() {
            return this.latestReplyTime;
        }

        public final Map<String, List<Reaction>> getReactionMap() {
            return this.reactionMap;
        }

        public final int getReplyCount() {
            return this.replyCount;
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof MessageThread) == true) goto L8;
            return false;
        L8:
            MessageThread r9 = (MessageThread) r8;
            if (this.replyCount == r9.replyCount) goto L11;
        L17:
            return false;
        L11:
            if (this.latestReplyTime != r9.latestReplyTime) goto L17;
            if (Intrinsics.areEqual(this.childMessages, r9.childMessages) == false) goto L17;
            if (Intrinsics.areEqual(this.reactionMap, r9.reactionMap) == false) goto L17;
            return true;
        }

        public final void setChildMessages(List<Message> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.childMessages = r2;
        }

        public final void setLatestReplyTime(long r1) {
            this.latestReplyTime = r1;
        }

        public final void setReactionMap(Map<String, ? extends List<? extends Reaction>> r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.reactionMap = r2;
        }

        public final void setReplyCount(int r1) {
            this.replyCount = r1;
        }
    }

    public int hashCode() {
        List<? extends Message> r0 = this.messages;
        int r1 = 0;
        if (r0 == null) goto L5;
        Intrinsics.checkNotNull(r0);
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Chat.Type r4 = this.type;
        if (r4 == null) goto L9;
        Intrinsics.checkNotNull(r4);
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.groupChatName;
        if (r7 == null) goto L13;
        Intrinsics.checkNotNull(r7);
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.p2pCreatorName;
        if (r10 == null) goto L17;
        Intrinsics.checkNotNull(r10);
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.p2pPartnerName;
        if (r13 == null) goto L22;
        Intrinsics.checkNotNull(r13);
        r1 = r13.hashCode();
    L22:
        return ((((((((r12 + r1) * 31) + this.p2pThreadCreatorName.hashCode()) * 31) + this.p2pThreadPartnerName.hashCode()) * 31) + this.threadOwnerDisplayName.hashCode()) * 31) + this.messageThreadMap.hashCode();
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public MergeForwardContent() {
        this.threadOwnerDisplayName = BuildConfig.FLAVOR;
        this.title = BuildConfig.FLAVOR;
        this.subtitle = BuildConfig.FLAVOR;
        this.threadId = BuildConfig.FLAVOR;
        this.p2pThreadCreatorName = BuildConfig.FLAVOR;
        this.p2pThreadPartnerName = BuildConfig.FLAVOR;
        this.reactionMap = new HashMap();
        this.reactionChatterMap = new HashMap();
        this.messageThreadMap = new HashMap();
        this.fromType = -1;
    }

    public MergeForwardContent clone() {
        Object r0 = super.clone();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.MergeForwardContent");
        MergeForwardContent r1 = (MergeForwardContent) r0;
        ArrayList r2 = new ArrayList();
        List<? extends Message> r3 = this.messages;
        if (r3 == null) goto L8;
        Iterator<T> r4 = r3.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r2.add(((Message) r4.next()).clone());
    L8:
        r1.messages = r2;
        return r1;
    }

    public final Map<String, ChatterInfo> getChatters() {
        return this.chatters;
    }

    public final int getFromType() {
        return this.fromType;
    }

    public final String getGroupChatName() {
        return this.groupChatName;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final Map<String, MessageThread> getMessageThreadMap() {
        return this.messageThreadMap;
    }

    public final List<Message> getMessages() {
        return this.messages;
    }

    public final Chat getOriginChat() {
        return this.originChat;
    }

    public final String getP2pCreatorName() {
        return this.p2pCreatorName;
    }

    public final String getP2pPartnerName() {
        return this.p2pPartnerName;
    }

    public final String getP2pThreadCreatorName() {
        return this.p2pThreadCreatorName;
    }

    public final String getP2pThreadPartnerName() {
        return this.p2pThreadPartnerName;
    }

    public final String getQuasiTitle() {
        return this.quasiTitle;
    }

    public final Map<String, Chatter> getReactionChatterMap() {
        return this.reactionChatterMap;
    }

    public final Map<String, List<Reaction>> getReactionMap() {
        return this.reactionMap;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final Thread getThread() {
        return this.thread;
    }

    public final String getThreadId() {
        return this.threadId;
    }

    public final String getThreadOwnerDisplayName() {
        return this.threadOwnerDisplayName;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Chat.Type getType() {
        return this.type;
    }

    public final boolean isCopyFromDoubao() {
        return this.isCopyFromDoubao;
    }

    public final boolean isFromPrivateTopic() {
        return this.isFromPrivateTopic;
    }

    public final boolean isManualTranslated() {
        return this.isManualTranslated;
    }

    public final boolean isReplyInThread() {
        return this.isReplyInThread;
    }

    public final boolean isTranslated() {
        return this.isTranslated;
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m526clone() {
        return clone();
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MergeForwardContent) == true) goto L8;
        return false;
    L8:
        List<? extends Message> r1 = this.messages;
        if (r1 == null) goto L14;
        if (Intrinsics.areEqual(r1, ((MergeForwardContent) r5).messages) == false) goto L15;
    L16:
        boolean r2 = false;
    L17:
        if (r2 == false) goto L19;
        return false;
    L19:
        MergeForwardContent r6 = (MergeForwardContent) r5;
        if (this.type == r6.type) goto L23;
        return false;
    L23:
        if (Intrinsics.areEqual(this.p2pThreadCreatorName, r6.p2pThreadCreatorName) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.p2pThreadPartnerName, r6.p2pThreadPartnerName) == true) goto L29;
        return false;
    L29:
        if (Intrinsics.areEqual(this.threadOwnerDisplayName, r6.threadOwnerDisplayName) == true) goto L31;
        return false;
    L31:
        String r3 = this.groupChatName;
        if (r3 == null) goto L37;
        if (Intrinsics.areEqual(r3, r6.groupChatName) == false) goto L38;
    L39:
        boolean r4 = false;
    L40:
        if (r4 == false) goto L42;
        return false;
    L42:
        String r7 = this.p2pCreatorName;
        if (r7 == null) goto L48;
        if (Intrinsics.areEqual(r7, r6.p2pCreatorName) == false) goto L49;
    L50:
        boolean r8 = false;
    L51:
        if (r8 == false) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.messageThreadMap, r6.messageThreadMap) == true) goto L56;
        return false;
    L56:
        Thread r9 = this.thread;
        if (r9 == null) goto L61;
        Integer r10 = r9.reply_count;
        if (r10 == null) goto L61;
        int r11 = r10.intValue();
    L62:
        Thread r12 = r6.thread;
        if (r12 == null) goto L66;
        Integer r13 = r12.reply_count;
        if (r13 == null) goto L66;
    L68:
        if (r11 == r13.intValue()) goto L70;
        return false;
    L70:
        String r14 = this.p2pPartnerName;
        String r15 = r6.p2pPartnerName;
        if (r14 != null) goto L77;
        if (r15 == null) goto L78;
        return false;
    L78:
        return true;
    L77:
        return Intrinsics.areEqual(r14, r15);
    L66:
        r13 = 0;
    L61:
        r11 = 0;
    L49:
        r8 = true;
        goto L51
    L48:
        if (r6.p2pCreatorName == null) goto L50;
    L38:
        r4 = true;
        goto L40
    L37:
        if (r6.groupChatName == null) goto L39;
    L15:
        r2 = true;
        goto L17
    L14:
        if (((MergeForwardContent) r5).messages == null) goto L16;
        goto L15
    }

    public final void setChatters(Map<String, ? extends ChatterInfo> r1) {
        this.chatters = r1;
    }

    public final void setCopyFromDoubao(boolean r1) {
        this.isCopyFromDoubao = r1;
    }

    public final void setFromPrivateTopic(boolean r1) {
        this.isFromPrivateTopic = r1;
    }

    public final void setFromType(int r1) {
        this.fromType = r1;
    }

    public final void setGroupChatName(String r1) {
        this.groupChatName = r1;
    }

    public final void setManualTranslated(boolean r1) {
        this.isManualTranslated = r1;
    }

    public final void setMessageId(String r1) {
        this.messageId = r1;
    }

    public final void setMessageThreadMap(Map<String, MessageThread> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.messageThreadMap = r2;
    }

    public final void setMessages(List<? extends Message> r1) {
        this.messages = r1;
    }

    public final void setOriginChat(Chat r1) {
        this.originChat = r1;
    }

    public final void setP2pCreatorName(String r1) {
        this.p2pCreatorName = r1;
    }

    public final void setP2pPartnerName(String r1) {
        this.p2pPartnerName = r1;
    }

    public final void setP2pThreadCreatorName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.p2pThreadCreatorName = r2;
    }

    public final void setP2pThreadPartnerName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.p2pThreadPartnerName = r2;
    }

    public final void setQuasiTitle(String r1) {
        this.quasiTitle = r1;
    }

    public final void setReactionChatterMap(Map<String, ? extends Chatter> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.reactionChatterMap = r2;
    }

    public final void setReactionMap(Map<String, ? extends List<? extends Reaction>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.reactionMap = r2;
    }

    public final void setReplyInThread(boolean r1) {
        this.isReplyInThread = r1;
    }

    public final void setSubtitle(String r1) {
        this.subtitle = r1;
    }

    public final void setThread(Thread r1) {
        this.thread = r1;
    }

    public final void setThreadId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.threadId = r2;
    }

    public final void setThreadOwnerDisplayName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.threadOwnerDisplayName = r2;
    }

    public final void setTitle(String r1) {
        this.title = r1;
    }

    public final void setTranslated(boolean r1) {
        this.isTranslated = r1;
    }

    public final void setType(Chat.Type r1) {
        this.type = r1;
    }
}
