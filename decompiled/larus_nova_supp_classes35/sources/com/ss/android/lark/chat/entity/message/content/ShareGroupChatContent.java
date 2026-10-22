package com.ss.android.lark.chat.entity.message.content;

import com.alibaba.fastjson.annotation.JSONType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0016J\u0012\u0010\u001f\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006!"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/ShareGroupChatContent;", "Lcom/ss/android/lark/chat/export/entity/message/Content;", "<init>", "()V", "chat", "Lcom/ss/android/lark/chat/entity/chat/Chat;", "getChat", "()Lcom/ss/android/lark/chat/entity/chat/Chat;", "setChat", "(Lcom/ss/android/lark/chat/entity/chat/Chat;)V", "joinToken", BuildConfig.FLAVOR, "getJoinToken", "()Ljava/lang/String;", "setJoinToken", "(Ljava/lang/String;)V", Keys.API_PARAM_KEY_SDK_EXPIRETIME, BuildConfig.FLAVOR, "getExpireTime", "()J", "setExpireTime", "(J)V", "joinChatErrState", "Lcom/ss/android/lark/chat/entity/message/content/ShareGroupChatContent$GroupState;", "getJoinChatErrState", "()Lcom/ss/android/lark/chat/entity/message/content/ShareGroupChatContent$GroupState;", "setJoinChatErrState", "(Lcom/ss/android/lark/chat/entity/message/content/ShareGroupChatContent$GroupState;)V", "isContentSame", BuildConfig.FLAVOR, "diffable", "isItemSame", "GroupState", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JSONType(typeName = "ShareGroupChatContent")
public final class ShareGroupChatContent extends Content {
    private Chat chat;
    private long expireTime;
    private GroupState joinChatErrState;
    private String joinToken;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/ShareGroupChatContent$GroupState;", "Ljava/io/Serializable;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "ALREADY_IN_GROUP", "JUST_SHOW_GROUP_INFO", "CAN_JOIN_DIRECTLY", "NEED_APPLY", "PENDING_APPROVAL", "NEED_CREATE_TENANT", "NEED_SWITCH_TENANT", "EXTERNAL_USERS_CANNOT_OPERATE", "INVITER_LEFT", "GROUP_DISBANDED", "SHARING_DISABLED", "SHARE_EXPIRED", "NO_EXTERNAL_COMMUNICATION_AUTHORITY", "GROUP_IS_FULL", "LINK_CERTIFIED_REFUSE", "QR_CODE_CERTIFIED_REFUSE", "SHARE_CARD_CERTIFIED_REFUSE", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum GroupState extends Enum<GroupState> implements Serializable {
        public static final GroupState ALREADY_IN_GROUP = null;
        public static final GroupState CAN_JOIN_DIRECTLY = null;
        public static final GroupState EXTERNAL_USERS_CANNOT_OPERATE = null;
        public static final GroupState GROUP_DISBANDED = null;
        public static final GroupState GROUP_IS_FULL = null;
        public static final GroupState INVITER_LEFT = null;
        public static final GroupState JUST_SHOW_GROUP_INFO = null;
        public static final GroupState LINK_CERTIFIED_REFUSE = null;
        public static final GroupState NEED_APPLY = null;
        public static final GroupState NEED_CREATE_TENANT = null;
        public static final GroupState NEED_SWITCH_TENANT = null;
        public static final GroupState NO_EXTERNAL_COMMUNICATION_AUTHORITY = null;
        public static final GroupState PENDING_APPROVAL = null;
        public static final GroupState QR_CODE_CERTIFIED_REFUSE = null;
        public static final GroupState SHARE_CARD_CERTIFIED_REFUSE = null;
        public static final GroupState SHARE_EXPIRED = null;
        public static final GroupState SHARING_DISABLED = null;
        public static final /* synthetic */ GroupState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<GroupState> getEntries() {
            return b;
        }

        static {
            GroupState r0 = new GroupState("ALREADY_IN_GROUP", 0);
            ALREADY_IN_GROUP = r0;
            GroupState r1 = new GroupState("JUST_SHOW_GROUP_INFO", 1);
            JUST_SHOW_GROUP_INFO = r1;
            GroupState r3 = new GroupState("CAN_JOIN_DIRECTLY", 2);
            CAN_JOIN_DIRECTLY = r3;
            GroupState r5 = new GroupState("NEED_APPLY", 3);
            NEED_APPLY = r5;
            GroupState r7 = new GroupState("PENDING_APPROVAL", 4);
            PENDING_APPROVAL = r7;
            GroupState r9 = new GroupState("NEED_CREATE_TENANT", 5);
            NEED_CREATE_TENANT = r9;
            GroupState r11 = new GroupState("NEED_SWITCH_TENANT", 6);
            NEED_SWITCH_TENANT = r11;
            GroupState r13 = new GroupState("EXTERNAL_USERS_CANNOT_OPERATE", 7);
            EXTERNAL_USERS_CANNOT_OPERATE = r13;
            GroupState r15 = new GroupState("INVITER_LEFT", 8);
            INVITER_LEFT = r15;
            GroupState r14 = new GroupState("GROUP_DISBANDED", 9);
            GROUP_DISBANDED = r14;
            GroupState r12 = new GroupState("SHARING_DISABLED", 10);
            SHARING_DISABLED = r12;
            GroupState r10 = new GroupState("SHARE_EXPIRED", 11);
            SHARE_EXPIRED = r10;
            GroupState r8 = new GroupState("NO_EXTERNAL_COMMUNICATION_AUTHORITY", 12);
            NO_EXTERNAL_COMMUNICATION_AUTHORITY = r8;
            GroupState r6 = new GroupState("GROUP_IS_FULL", 13);
            GROUP_IS_FULL = r6;
            GroupState r4 = new GroupState("LINK_CERTIFIED_REFUSE", 14);
            LINK_CERTIFIED_REFUSE = r4;
            GroupState r2 = new GroupState("QR_CODE_CERTIFIED_REFUSE", 15);
            QR_CODE_CERTIFIED_REFUSE = r2;
            GroupState r16 = new GroupState("SHARE_CARD_CERTIFIED_REFUSE", 16);
            SHARE_CARD_CERTIFIED_REFUSE = r16;
            GroupState[] r17 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14, r12, r10, r8, r6, r4, r2, r16};
            a = r17;
            b = EnumEntriesKt.enumEntries(r17);
        }

        public static GroupState[] values() {
            return (GroupState[]) a.clone();
        }

        public static GroupState valueOf(String r1) {
            return (GroupState) r27.a.a(GroupState.class, r1);
        }

        public GroupState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public ShareGroupChatContent() {
    }

    public final Chat getChat() {
        return this.chat;
    }

    public final long getExpireTime() {
        return this.expireTime;
    }

    public final GroupState getJoinChatErrState() {
        return this.joinChatErrState;
    }

    public final String getJoinToken() {
        return this.joinToken;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isContentSame(Content r8) {
        if ((r8 instanceof ShareGroupChatContent) == true) goto L6;
        return false;
    L6:
        if (this != r8) goto L8;
        return true;
    L8:
        Chat r2 = this.chat;
        if (r2 == null) goto L22;
        ShareGroupChatContent r9 = (ShareGroupChatContent) r8;
        if (r9.chat == null) goto L25;
        Intrinsics.checkNotNull(r2);
        String r3 = r2.getId();
        Chat r4 = r9.chat;
        Intrinsics.checkNotNull(r4);
        if (Intrinsics.areEqual(r3, r4.getId()) == true) goto L17;
        return false;
    L17:
        if (this.expireTime == r9.expireTime) goto L19;
        return false;
    L19:
        if (this.joinChatErrState != r9.joinChatErrState) goto L24;
        return true;
    L24:
        return false;
    L25:
        return false;
    L22:
        return false;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public boolean isItemSame(Content r6) {
        if ((r6 instanceof ShareGroupChatContent) == true) goto L6;
        return false;
    L6:
        if (this != r6) goto L8;
        return true;
    L8:
        Chat r2 = this.chat;
        if (r2 == null) goto L26;
        ShareGroupChatContent r7 = (ShareGroupChatContent) r6;
        if (r7.chat == null) goto L29;
        String r3 = null;
        if (r2 == null) goto L16;
        String r4 = r2.getId();
    L17:
        Chat r5 = r7.chat;
        if (r5 == null) goto L21;
        r3 = r5.getId();
    L21:
        if (Intrinsics.areEqual(r4, r3) == true) goto L23;
        return false;
    L23:
        if (this.joinChatErrState != r7.joinChatErrState) goto L28;
        return true;
    L28:
        return false;
    L16:
        r4 = null;
        goto L17
    L29:
        return false;
    L26:
        return false;
    }

    public final void setChat(Chat r1) {
        this.chat = r1;
    }

    public final void setExpireTime(long r1) {
        this.expireTime = r1;
    }

    public final void setJoinChatErrState(GroupState r1) {
        this.joinChatErrState = r1;
    }

    public final void setJoinToken(String r1) {
        this.joinToken = r1;
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((Content) r1);
    }

    @Override // com.ss.android.lark.chat.export.entity.message.Content
    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((Content) r1);
    }
}
