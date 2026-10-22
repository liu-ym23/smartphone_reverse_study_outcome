package com.larus.dora.impl.bean;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/larus/dora/impl/bean/ChatResponseEvent;", "", "seqId", "", "replyType", "conversationId", "commandList", "", "Lcom/larus/dora/impl/bean/Command;", "<init>", "(JJJLjava/util/List;)V", "getSeqId", "()J", "getReplyType", "getConversationId", "getCommandList", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatResponseEvent {

    @SerializedName("command_list")
    private final List<Command> commandList;

    @SerializedName("conversation_id")
    private final long conversationId;

    @SerializedName("reply_type")
    private final long replyType;

    @SerializedName("seq_id")
    private final long seqId;

    public ChatResponseEvent() {
        this(0, 0, 0, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChatResponseEvent copy$default(ChatResponseEvent r8, long r9, long r11, long r13, List r15, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        long r1 = r8.seqId;
    L7:
        if ((r16 & 2) == 0) goto L9;
        long r3 = r8.replyType;
    L11:
        if ((r16 & 4) == 0) goto L13;
        long r5 = r8.conversationId;
    L15:
        if ((r16 & 8) == 0) goto L17;
        List r7 = r8.commandList;
    L19:
        return r8.copy(r1, r3, r5, r7);
    L17:
        r7 = r15;
        goto L19
    L13:
        r5 = r13;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r9;
        goto L7
    }

    public final long component1() {
        return this.seqId;
    }

    public final long component2() {
        return this.replyType;
    }

    public final long component3() {
        return this.conversationId;
    }

    public final List<Command> component4() {
        return this.commandList;
    }

    public final ChatResponseEvent copy(long r10, long r12, long r14, List<Command> r16) {
        return new ChatResponseEvent(r10, r12, r14, r16);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ChatResponseEvent) == true) goto L8;
        return false;
    L8:
        ChatResponseEvent r9 = (ChatResponseEvent) r8;
        if (this.seqId == r9.seqId) goto L12;
        return false;
    L12:
        if (this.replyType == r9.replyType) goto L15;
        return false;
    L15:
        if (this.conversationId == r9.conversationId) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.commandList, r9.commandList) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        long r0 = this.seqId;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.replyType;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.conversationId;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        List<Command> r6 = this.commandList;
        if (r6 != null) goto L5;
        int r7 = 0;
    L7:
        return r5 + r7;
    L5:
        r7 = r6.hashCode();
        goto L7
    }

    public String toString() {
        return "ChatResponseEvent(seqId=" + this.seqId + ", replyType=" + this.replyType + ", conversationId=" + this.conversationId + ", commandList=" + this.commandList + ')';
    }

    public final List<Command> getCommandList() {
        return this.commandList;
    }

    public final long getConversationId() {
        return this.conversationId;
    }

    public final long getReplyType() {
        return this.replyType;
    }

    public final long getSeqId() {
        return this.seqId;
    }

    public ChatResponseEvent(long r1, long r3, long r5, List<Command> r7) {
        this.seqId = r1;
        this.replyType = r3;
        this.conversationId = r5;
        this.commandList = r7;
    }

    public /* synthetic */ ChatResponseEvent(long r7, long r9, long r11, List r13, int r14, DefaultConstructorMarker r15) {
        long r0 = 0;
        if ((r14 & 1) == 0) goto L5;
        long r2 = 0;
    L7:
        if ((r14 & 2) == 0) goto L9;
        long r4 = 0;
    L11:
        if ((r14 & 4) != 0) goto L15;
        r0 = r11;
    L15:
        if ((r14 & 8) == 0) goto L17;
        r13 = null;
    L17:
        this(r2, r4, r0, r13);
        return;
    L9:
        r4 = r9;
        goto L11
    L5:
        r2 = r7;
        goto L7
    }
}
