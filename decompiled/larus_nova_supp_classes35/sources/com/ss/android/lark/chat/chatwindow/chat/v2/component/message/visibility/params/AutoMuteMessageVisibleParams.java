package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params;

import com.ss.android.lark.chat.entity.chat.AutoMuteConfig;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012*\u0010\u0006\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J-\u0010\u0015\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\nHÆ\u0003JK\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052,\b\u0002\u0010\u0006\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\nHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R5\u0010\u0006\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0007j\u0012\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/params/AutoMuteMessageVisibleParams;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/params/MessageVisibleBizParams;", "chatType", "Lcom/ss/android/lark/chat/entity/chat/Chat$Type;", "chatUserNum", BuildConfig.FLAVOR, "chatAutoMuteBots", "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chat/entity/chat/AutoMuteConfig;", "Lkotlin/collections/HashMap;", "<init>", "(Lcom/ss/android/lark/chat/entity/chat/Chat$Type;ILjava/util/HashMap;)V", "getChatType", "()Lcom/ss/android/lark/chat/entity/chat/Chat$Type;", "getChatUserNum", "()I", "getChatAutoMuteBots", "()Ljava/util/HashMap;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoMuteMessageVisibleParams implements MessageVisibleBizParams {
    private final HashMap<Long, AutoMuteConfig> chatAutoMuteBots;
    private final Chat.Type chatType;
    private final int chatUserNum;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutoMuteMessageVisibleParams copy$default(AutoMuteMessageVisibleParams r0, Chat.Type r1, int r2, HashMap r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.chatType;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.chatUserNum;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.chatAutoMuteBots;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final Chat.Type component1() {
        return this.chatType;
    }

    public final int component2() {
        return this.chatUserNum;
    }

    public final HashMap<Long, AutoMuteConfig> component3() {
        return this.chatAutoMuteBots;
    }

    public final AutoMuteMessageVisibleParams copy(Chat.Type r2, int r3, HashMap<Long, AutoMuteConfig> r4) {
        Intrinsics.checkNotNullParameter(r2, "chatType");
        return new AutoMuteMessageVisibleParams(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AutoMuteMessageVisibleParams) == true) goto L8;
        return false;
    L8:
        AutoMuteMessageVisibleParams r6 = (AutoMuteMessageVisibleParams) r5;
        if (this.chatType == r6.chatType) goto L12;
        return false;
    L12:
        if (this.chatUserNum == r6.chatUserNum) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.chatAutoMuteBots, r6.chatAutoMuteBots) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.chatType.hashCode() * 31) + this.chatUserNum) * 31;
        HashMap<Long, AutoMuteConfig> r1 = this.chatAutoMuteBots;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "AutoMuteMessageVisibleParams(chatType=" + this.chatType + ", chatUserNum=" + this.chatUserNum + ", chatAutoMuteBots=" + this.chatAutoMuteBots + ')';
    }

    public final HashMap<Long, AutoMuteConfig> getChatAutoMuteBots() {
        return this.chatAutoMuteBots;
    }

    public final Chat.Type getChatType() {
        return this.chatType;
    }

    public final int getChatUserNum() {
        return this.chatUserNum;
    }

    public AutoMuteMessageVisibleParams(Chat.Type r2, int r3, HashMap<Long, AutoMuteConfig> r4) {
        Intrinsics.checkNotNullParameter(r2, "chatType");
        this.chatType = r2;
        this.chatUserNum = r3;
        this.chatAutoMuteBots = r4;
    }
}
