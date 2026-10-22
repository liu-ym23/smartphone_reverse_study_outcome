package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.visibility.params;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/params/MyAIMessageVisibleParams;", "Lcom/ss/android/lark/chat/chatwindow/chat/v2/component/message/visibility/params/MessageVisibleBizParams;", "isAIChat", BuildConfig.FLAVOR, "isP2PChat", "<init>", "(ZZ)V", "()Z", "component1", "component2", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "chat-core_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyAIMessageVisibleParams implements MessageVisibleBizParams {
    private final boolean isAIChat;
    private final boolean isP2PChat;

    public static /* synthetic */ MyAIMessageVisibleParams copy$default(MyAIMessageVisibleParams r0, boolean r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.isAIChat;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.isP2PChat;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.isAIChat;
    }

    public final boolean component2() {
        return this.isP2PChat;
    }

    public final MyAIMessageVisibleParams copy(boolean r2, boolean r3) {
        return new MyAIMessageVisibleParams(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MyAIMessageVisibleParams) == true) goto L8;
        return false;
    L8:
        MyAIMessageVisibleParams r6 = (MyAIMessageVisibleParams) r5;
        if (this.isAIChat == r6.isAIChat) goto L12;
        return false;
    L12:
        if (this.isP2PChat == r6.isP2PChat) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.isAIChat == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.isP2PChat == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "MyAIMessageVisibleParams(isAIChat=" + this.isAIChat + ", isP2PChat=" + this.isP2PChat + ')';
    }

    public final boolean isAIChat() {
        return this.isAIChat;
    }

    public final boolean isP2PChat() {
        return this.isP2PChat;
    }

    public MyAIMessageVisibleParams(boolean r1, boolean r2) {
        this.isAIChat = r1;
        this.isP2PChat = r2;
    }
}
