package com.bytedance.android.ec.base.api.ai.conversation;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B+\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J-\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0013\u0010\u0012R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/conversation/AIChatSchemaParams;", "", "", "component1", "component2", "component3", "conversationId", "originMessageId", "originBcmId", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getConversationId", "()Ljava/lang/String;", "getOriginMessageId", "getOriginBcmId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "a", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class AIChatSchemaParams {
    public static final a Companion = null;
    public static final AIChatSchemaParams EMPTY = null;
    private final String conversationId;
    private final String originBcmId;
    private final String originMessageId;

    public static final class a {
        public a() {
        }
    }

    public AIChatSchemaParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AIChatSchemaParams copy$default(AIChatSchemaParams r0, String r1, String r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r1 = r0.conversationId;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = r0.originMessageId;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = r0.originBcmId;
    L12:
        return r0.copy(r1, r10, r11);
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

    public final AIChatSchemaParams copy(String r10, String r11, String r12) {
        return new AIChatSchemaParams(r10, r11, r12);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof AIChatSchemaParams) == false) goto L12;
        AIChatSchemaParams r11 = (AIChatSchemaParams) r10;
        if (Intrinsics.areEqual(this.conversationId, r11.conversationId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.originMessageId, r11.originMessageId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.originBcmId, r11.originBcmId) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

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
        if (r15 == null) goto L14;
        r1 = r15.hashCode();
    L14:
        return r14 + r1;
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "AIChatSchemaParams(conversationId=" + this.conversationId + ", originMessageId=" + this.originMessageId + ", originBcmId=" + this.originBcmId + ")";
    }

    static {
        Companion = new a();
        EMPTY = new AIChatSchemaParams(null, null, null, 7, null);
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

    public AIChatSchemaParams(String r1, String r10, String r11) {
        this.conversationId = r1;
        this.originMessageId = r10;
        this.originBcmId = r11;
    }

    public /* synthetic */ AIChatSchemaParams(String r10, String r11, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L11;
        r12 = null;
    L11:
        this(r10, r11, r12);
    }
}
