package com.larus.bmhome.chat.resp;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.IMMsg;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u0003\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u0010\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u0003HÆ\u0003J\u0019\u0010\u0011\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\bHÆ\u0003JG\u0010\u0013\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u00032\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0014\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R&\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR&\u0010\u0006\u001a\u0012\u0012\f\u0012\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/larus/bmhome/chat/resp/MessageList;", "", "messageList", "", "Lcom/larus/im/bean/IMMsg;", "Lcom/larus/bmhome/chat/resp/PushMessage;", "regenList", "hasMore", "", "<init>", "(Ljava/util/List;Ljava/util/List;Z)V", "getMessageList", "()Ljava/util/List;", "getRegenList", "getHasMore", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MessageList {

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("message_list")
    private final List<IMMsg> messageList;

    @SerializedName("regen_list")
    private final List<IMMsg> regenList;

    public MessageList() {
        this(null, null, false, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MessageList copy$default(MessageList r0, List r1, List r2, boolean r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.messageList;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.regenList;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.hasMore;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final List<IMMsg> component1() {
        return this.messageList;
    }

    public final List<IMMsg> component2() {
        return this.regenList;
    }

    public final boolean component3() {
        return this.hasMore;
    }

    public final MessageList copy(List<IMMsg> r2, List<IMMsg> r3, boolean r4) {
        return new MessageList(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MessageList) == true) goto L8;
        return false;
    L8:
        MessageList r6 = (MessageList) r5;
        if (Intrinsics.areEqual(this.messageList, r6.messageList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.regenList, r6.regenList) == true) goto L15;
        return false;
    L15:
        if (this.hasMore == r6.hasMore) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<IMMsg> r0 = this.messageList;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<IMMsg> r4 = this.regenList;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        int r5 = (r3 + r1) * 31;
        if (this.hasMore == false) goto L13;
        int r6 = 1231;
    L15:
        return r5 + r6;
    L13:
        r6 = 1237;
        goto L15
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MessageList(messageList=" + this.messageList + ", regenList=" + this.regenList + ", hasMore=" + this.hasMore + ')';
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final List<IMMsg> getMessageList() {
        return this.messageList;
    }

    public final List<IMMsg> getRegenList() {
        return this.regenList;
    }

    public MessageList(List<IMMsg> r1, List<IMMsg> r2, boolean r3) {
        this.messageList = r1;
        this.regenList = r2;
        this.hasMore = r3;
    }

    public /* synthetic */ MessageList(List r1, List r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = CollectionsKt.emptyList();
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = CollectionsKt.emptyList();
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = false;
    L11:
        this(r1, r2, r3);
    }
}
