package com.ss.android.lark.chat.api.chatpreview;

import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003Je\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\bHÆ\u0001J\u0013\u0010$\u001a\u00020\b2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0016R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0016R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0016¨\u0006*"}, d2 = {"Lcom/ss/android/lark/chat/api/chatpreview/BasicChatInfo;", "Ljava/io/Serializable;", "chatId", "Lcom/ss/android/lark/chat/api/chatpreview/ChatId;", "title", BuildConfig.FLAVOR, "avatarKey", "isThread", BuildConfig.FLAVOR, "isP2P", "p2pChatterId", "chatterType", "Lcom/ss/android/lark/chat/entity/chatter/Chatter$ChatterType;", "isSecret", "isAiKnowLedge", "<init>", "(Lcom/ss/android/lark/chat/api/chatpreview/ChatId;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Lcom/ss/android/lark/chat/entity/chatter/Chatter$ChatterType;ZZ)V", "getChatId", "()Lcom/ss/android/lark/chat/api/chatpreview/ChatId;", "getTitle", "()Ljava/lang/String;", "getAvatarKey", "()Z", "getP2pChatterId", "getChatterType", "()Lcom/ss/android/lark/chat/entity/chatter/Chatter$ChatterType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BasicChatInfo implements Serializable {
    private final String avatarKey;
    private final ChatId chatId;
    private final Chatter.ChatterType chatterType;
    private final boolean isAiKnowLedge;
    private final boolean isP2P;
    private final boolean isSecret;
    private final boolean isThread;
    private final String p2pChatterId;
    private final String title;

    public static /* synthetic */ BasicChatInfo copy$default(BasicChatInfo r10, ChatId r11, String r12, String r13, boolean r14, boolean r15, String r16, Chatter.ChatterType r17, boolean r18, boolean r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        ChatId r2 = r10.chatId;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.title;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.avatarKey;
    L15:
        if ((r20 & 8) == 0) goto L17;
        boolean r5 = r10.isThread;
    L19:
        if ((r20 & 16) == 0) goto L21;
        boolean r6 = r10.isP2P;
    L23:
        if ((r20 & 32) == 0) goto L25;
        String r7 = r10.p2pChatterId;
    L27:
        if ((r20 & 64) == 0) goto L29;
        Chatter.ChatterType r8 = r10.chatterType;
    L31:
        if ((r20 & 128) == 0) goto L33;
        boolean r9 = r10.isSecret;
    L35:
        if ((r20 & 256) == 0) goto L37;
        boolean r1 = r10.isAiKnowLedge;
    L39:
        return r10.copy(r2, r3, r4, r5, r6, r7, r8, r9, r1);
    L37:
        r1 = r19;
        goto L39
    L33:
        r9 = r18;
        goto L35
    L29:
        r8 = r17;
        goto L31
    L25:
        r7 = r16;
        goto L27
    L21:
        r6 = r15;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r2 = r11;
        goto L7
    }

    public final ChatId component1() {
        return this.chatId;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.avatarKey;
    }

    public final boolean component4() {
        return this.isThread;
    }

    public final boolean component5() {
        return this.isP2P;
    }

    public final String component6() {
        return this.p2pChatterId;
    }

    public final Chatter.ChatterType component7() {
        return this.chatterType;
    }

    public final boolean component8() {
        return this.isSecret;
    }

    public final boolean component9() {
        return this.isAiKnowLedge;
    }

    public final BasicChatInfo copy(ChatId r12, String r13, String r14, boolean r15, boolean r16, String r17, Chatter.ChatterType r18, boolean r19, boolean r20) {
        Intrinsics.checkNotNullParameter(r12, "chatId");
        Intrinsics.checkNotNullParameter(r13, "title");
        Intrinsics.checkNotNullParameter(r14, "avatarKey");
        Intrinsics.checkNotNullParameter(r17, "p2pChatterId");
        return new BasicChatInfo(r12, r13, r14, r15, r16, r17, r18, r19, r20);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BasicChatInfo) == true) goto L8;
        return false;
    L8:
        BasicChatInfo r6 = (BasicChatInfo) r5;
        if (Intrinsics.areEqual(this.chatId, r6.chatId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r6.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.avatarKey, r6.avatarKey) == true) goto L18;
        return false;
    L18:
        if (this.isThread == r6.isThread) goto L21;
        return false;
    L21:
        if (this.isP2P == r6.isP2P) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.p2pChatterId, r6.p2pChatterId) == true) goto L27;
        return false;
    L27:
        if (this.chatterType == r6.chatterType) goto L30;
        return false;
    L30:
        if (this.isSecret == r6.isSecret) goto L33;
        return false;
    L33:
        if (this.isAiKnowLedge == r6.isAiKnowLedge) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.chatId.hashCode() * 31) + this.title.hashCode()) * 31) + this.avatarKey.hashCode()) * 31;
        int r2 = 1231;
        if (this.isThread == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.isP2P == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (((r3 + r4) * 31) + this.p2pChatterId.hashCode()) * 31;
        Chatter.ChatterType r6 = this.chatterType;
        if (r6 != null) goto L13;
        int r7 = 0;
    L14:
        int r8 = (r5 + r7) * 31;
        if (this.isSecret == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (r8 + r9) * 31;
        if (this.isAiKnowLedge == true) goto L23;
        r2 = 1237;
    L23:
        return r10 + r2;
    L17:
        r9 = 1237;
        goto L18
    L13:
        r7 = r6.hashCode();
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "BasicChatInfo(chatId=" + this.chatId + ", title=" + this.title + ", avatarKey=" + this.avatarKey + ", isThread=" + this.isThread + ", isP2P=" + this.isP2P + ", p2pChatterId=" + this.p2pChatterId + ", chatterType=" + this.chatterType + ", isSecret=" + this.isSecret + ", isAiKnowLedge=" + this.isAiKnowLedge + ')';
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final ChatId getChatId() {
        return this.chatId;
    }

    public final Chatter.ChatterType getChatterType() {
        return this.chatterType;
    }

    public final String getP2pChatterId() {
        return this.p2pChatterId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isAiKnowLedge() {
        return this.isAiKnowLedge;
    }

    public final boolean isP2P() {
        return this.isP2P;
    }

    public final boolean isSecret() {
        return this.isSecret;
    }

    public final boolean isThread() {
        return this.isThread;
    }

    public BasicChatInfo(ChatId r2, String r3, String r4, boolean r5, boolean r6, String r7, Chatter.ChatterType r8, boolean r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r2, "chatId");
        Intrinsics.checkNotNullParameter(r3, "title");
        Intrinsics.checkNotNullParameter(r4, "avatarKey");
        Intrinsics.checkNotNullParameter(r7, "p2pChatterId");
        this.chatId = r2;
        this.title = r3;
        this.avatarKey = r4;
        this.isThread = r5;
        this.isP2P = r6;
        this.p2pChatterId = r7;
        this.chatterType = r8;
        this.isSecret = r9;
        this.isAiKnowLedge = r10;
    }

    public /* synthetic */ BasicChatInfo(ChatId r14, String r15, String r16, boolean r17, boolean r18, String r19, Chatter.ChatterType r20, boolean r21, boolean r22, int r23, DefaultConstructorMarker r24) {
        if ((r23 & 128) == 0) goto L5;
        boolean r11 = false;
    L7:
        if ((r23 & 256) == 0) goto L9;
        boolean r12 = false;
    L10:
        this(r14, r15, r16, r17, r18, r19, r20, r11, r12);
        return;
    L9:
        r12 = r22;
        goto L10
    L5:
        r11 = r21;
        goto L7
    }
}
