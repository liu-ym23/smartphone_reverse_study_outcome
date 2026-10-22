package com.bytedance.android.ec.base.api.ai.conversation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J5\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/conversation/ConversationContext;", "", "conversationId", "", "originMessageId", "originBcmId", "isFirstOpenInSourcePage", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getConversationId", "()Ljava/lang/String;", "()Z", "getOriginBcmId", "getOriginMessageId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class ConversationContext {
    private final String conversationId;
    private final boolean isFirstOpenInSourcePage;
    private final String originBcmId;
    private final String originMessageId;

    public static /* synthetic */ ConversationContext copy$default(ConversationContext r0, String r1, String r10, String r11, boolean r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r1 = r0.conversationId;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r10 = r0.originMessageId;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r11 = r0.originBcmId;
    L12:
        if ((r13 & 8) == 0) goto L15;
        r12 = r0.isFirstOpenInSourcePage;
    L15:
        return r0.copy(r1, r10, r11, r12);
    }

    public final String component1() {
        return this.conversationId;
    }

    public final String component2() {
        return this.originMessageId;
    }

    public final String component3() {
        return this.originBcmId;
    }

    public final boolean component4() {
        return this.isFirstOpenInSourcePage;
    }

    public final ConversationContext copy(String r10, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "conversationId");
        return new ConversationContext(r10, r11, r12, r13);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof ConversationContext) == false) goto L14;
        ConversationContext r11 = (ConversationContext) r10;
        if (Intrinsics.areEqual(this.conversationId, r11.conversationId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.originMessageId, r11.originMessageId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.originBcmId, r11.originBcmId) == true) goto L12;
        return false;
    L12:
        if (this.isFirstOpenInSourcePage == r11.isFirstOpenInSourcePage) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r0 = this.conversationId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.originMessageId;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.originBcmId;
        if (r15 == null) goto L13;
        r1 = r15.hashCode();
    L13:
        int r16 = (r14 + r1) * 31;
        boolean r17 = this.isFirstOpenInSourcePage;
        ?? r18 = r17;
        if (r17 == false) goto L17;
        r18 = 1;
    L17:
        return r16 + r18;
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "ConversationContext(conversationId=" + this.conversationId + ", originMessageId=" + this.originMessageId + ", originBcmId=" + this.originBcmId + ", isFirstOpenInSourcePage=" + this.isFirstOpenInSourcePage + ")";
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getOriginBcmId() {
        return this.originBcmId;
    }

    public final String getOriginMessageId() {
        return this.originMessageId;
    }

    public final boolean isFirstOpenInSourcePage() {
        return this.isFirstOpenInSourcePage;
    }

    public ConversationContext(String r10, String r11, String r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "conversationId");
        this.conversationId = r10;
        this.originMessageId = r11;
        this.originBcmId = r12;
        this.isFirstOpenInSourcePage = r13;
    }

    public /* synthetic */ ConversationContext(String r10, String r11, String r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = null;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = true;
    L11:
        this(r10, r11, r12, r13);
    }
}
