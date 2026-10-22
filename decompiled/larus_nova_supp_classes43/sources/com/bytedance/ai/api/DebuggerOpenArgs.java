package com.bytedance.ai.api;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\""}, d2 = {"Lcom/bytedance/ai/api/DebuggerOpenArgs;", "Ljava/io/Serializable;", "conversationId", "", "botId", "sourceConversationId", "mode", "Lcom/bytedance/ai/api/DebuggerMode;", "entryFrom", "msgContent", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/ai/api/DebuggerMode;Ljava/lang/String;Ljava/lang/String;)V", "getConversationId", "()Ljava/lang/String;", "getBotId", "getSourceConversationId", "getMode", "()Lcom/bytedance/ai/api/DebuggerMode;", "getEntryFrom", "getMsgContent", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DebuggerOpenArgs implements Serializable {
    private final String botId;
    private final String conversationId;
    private final String entryFrom;
    private final DebuggerMode mode;
    private final String msgContent;
    private final String sourceConversationId;

    public static /* synthetic */ DebuggerOpenArgs copy$default(DebuggerOpenArgs r10, String r11, String r12, String r13, DebuggerMode r14, String r15, String r16, int r17, Object r18) {
        if ((r17 & 1) == 0) goto L6;
        r11 = r10.conversationId;
    L6:
        if ((r17 & 2) == 0) goto L8;
        r12 = r10.botId;
    L8:
        String r19 = r12;
        if ((r17 & 4) == 0) goto L11;
        r13 = r10.sourceConversationId;
    L11:
        String r0 = r13;
        if ((r17 & 8) == 0) goto L14;
        r14 = r10.mode;
    L14:
        DebuggerMode r1 = r14;
        if ((r17 & 16) == 0) goto L17;
        r15 = r10.entryFrom;
    L17:
        String r20 = r15;
        if ((r17 & 32) == 0) goto L20;
        r16 = r10.msgContent;
    L20:
        String r21 = r11;
        return r10.copy(r21, r19, r0, r1, r20, r16);
    }

    public final String component1() {
        return this.conversationId;
    }

    public final String component2() {
        return this.botId;
    }

    public final String component3() {
        return this.sourceConversationId;
    }

    public final DebuggerMode component4() {
        return this.mode;
    }

    public final String component5() {
        return this.entryFrom;
    }

    public final String component6() {
        return this.msgContent;
    }

    public final DebuggerOpenArgs copy(String r10, String r11, String r12, DebuggerMode r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r10, "conversationId");
        Intrinsics.checkNotNullParameter(r11, "botId");
        Intrinsics.checkNotNullParameter(r12, "sourceConversationId");
        Intrinsics.checkNotNullParameter(r13, "mode");
        Intrinsics.checkNotNullParameter(r14, "entryFrom");
        return new DebuggerOpenArgs(r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof DebuggerOpenArgs) == true) goto L8;
        return false;
    L8:
        DebuggerOpenArgs r11 = (DebuggerOpenArgs) r10;
        if (Intrinsics.areEqual(this.conversationId, r11.conversationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.botId, r11.botId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.sourceConversationId, r11.sourceConversationId) == true) goto L18;
        return false;
    L18:
        if (this.mode == r11.mode) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.entryFrom, r11.entryFrom) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.msgContent, r11.msgContent) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r0 = ((((((((this.conversationId.hashCode() * 31) + this.botId.hashCode()) * 31) + this.sourceConversationId.hashCode()) * 31) + this.mode.hashCode()) * 31) + this.entryFrom.hashCode()) * 31;
        String r1 = this.msgContent;
        if (r1 != null) goto L5;
        int r10 = 0;
    L7:
        return r0 + r10;
    L5:
        r10 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "DebuggerOpenArgs(conversationId=" + this.conversationId + ", botId=" + this.botId + ", sourceConversationId=" + this.sourceConversationId + ", mode=" + this.mode + ", entryFrom=" + this.entryFrom + ", msgContent=" + this.msgContent + ')';
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getEntryFrom() {
        return this.entryFrom;
    }

    public final DebuggerMode getMode() {
        return this.mode;
    }

    public final String getMsgContent() {
        return this.msgContent;
    }

    public final String getSourceConversationId() {
        return this.sourceConversationId;
    }

    public DebuggerOpenArgs(String r10, String r11, String r12, DebuggerMode r13, String r14, String r15) {
        Intrinsics.checkNotNullParameter(r10, "conversationId");
        Intrinsics.checkNotNullParameter(r11, "botId");
        Intrinsics.checkNotNullParameter(r12, "sourceConversationId");
        Intrinsics.checkNotNullParameter(r13, "mode");
        Intrinsics.checkNotNullParameter(r14, "entryFrom");
        this.conversationId = r10;
        this.botId = r11;
        this.sourceConversationId = r12;
        this.mode = r13;
        this.entryFrom = r14;
        this.msgContent = r15;
    }

    public /* synthetic */ DebuggerOpenArgs(String r10, String r11, String r12, DebuggerMode r13, String r14, String r15, int r16, DefaultConstructorMarker r17) {
        if ((r16 & 32) == 0) goto L5;
        r15 = null;
    L5:
        this(r10, r11, r12, r13, r14, r15);
    }
}
