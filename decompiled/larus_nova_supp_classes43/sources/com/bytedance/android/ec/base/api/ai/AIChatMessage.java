package com.bytedance.android.ec.base.api.ai;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u001a\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u0015\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\nHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0081\u0001\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fHÆ\u0001J\u0013\u0010'\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020*HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012¨\u0006,"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/AIChatMessage;", "", "localMessageId", "", "messageId", "replyId", "conversationId", "messageStatusLocal", "Lcom/bytedance/android/ec/base/api/ai/AIChatMessageStatusLocal;", "isSelf", "", "isVisible", "isContentFinished", "payload", "ext", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/ec/base/api/ai/AIChatMessageStatusLocal;ZZZLjava/lang/String;Ljava/util/Map;)V", "getConversationId", "()Ljava/lang/String;", "getExt", "()Ljava/util/Map;", "()Z", "getLocalMessageId", "getMessageId", "getMessageStatusLocal", "()Lcom/bytedance/android/ec/base/api/ai/AIChatMessageStatusLocal;", "getPayload", "getReplyId", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class AIChatMessage {
    private final String conversationId;
    private final Map<String, String> ext;
    private final boolean isContentFinished;
    private final boolean isSelf;
    private final boolean isVisible;
    private final String localMessageId;
    private final String messageId;
    private final AIChatMessageStatusLocal messageStatusLocal;
    private final String payload;
    private final String replyId;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIChatMessage copy$default(AIChatMessage r11, String r12, String r13, String r14, String r15, AIChatMessageStatusLocal r16, boolean r17, boolean r18, boolean r19, String r20, Map r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        String r10 = r11.localMessageId;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r24 = r11.messageId;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r25 = r11.replyId;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r26 = r11.conversationId;
    L19:
        if ((r22 & 16) == 0) goto L21;
        AIChatMessageStatusLocal r27 = r11.messageStatusLocal;
    L23:
        if ((r22 & 32) == 0) goto L25;
        boolean r28 = r11.isSelf;
    L27:
        if ((r22 & 64) == 0) goto L29;
        boolean r29 = r11.isVisible;
    L31:
        if ((r22 & 128) == 0) goto L33;
        boolean r30 = r11.isContentFinished;
    L35:
        if ((r22 & 256) == 0) goto L37;
        String r110 = r11.payload;
    L39:
        if ((r22 & 512) == 0) goto L41;
        Map r1 = r11.ext;
    L43:
        return r11.copy(r10, r24, r25, r26, r27, r28, r29, r30, r110, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r110 = r20;
        goto L39
    L33:
        r30 = r19;
        goto L35
    L29:
        r29 = r18;
        goto L31
    L25:
        r28 = r17;
        goto L27
    L21:
        r27 = r16;
        goto L23
    L17:
        r26 = r15;
        goto L19
    L13:
        r25 = r14;
        goto L15
    L9:
        r24 = r13;
        goto L11
    L5:
        r10 = r12;
        goto L7
    }

    public final String component1() {
        return this.localMessageId;
    }

    public final Map<String, String> component10() {
        return this.ext;
    }

    public final String component2() {
        return this.messageId;
    }

    public final String component3() {
        return this.replyId;
    }

    public final String component4() {
        return this.conversationId;
    }

    public final AIChatMessageStatusLocal component5() {
        return this.messageStatusLocal;
    }

    public final boolean component6() {
        return this.isSelf;
    }

    public final boolean component7() {
        return this.isVisible;
    }

    public final boolean component8() {
        return this.isContentFinished;
    }

    public final String component9() {
        return this.payload;
    }

    public final AIChatMessage copy(String r13, String r14, String r15, String r16, AIChatMessageStatusLocal r17, boolean r18, boolean r19, boolean r20, String r21, Map<String, String> r22) {
        Intrinsics.checkNotNullParameter(r13, "localMessageId");
        Intrinsics.checkNotNullParameter(r17, "messageStatusLocal");
        Intrinsics.checkNotNullParameter(r22, "ext");
        return new AIChatMessage(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof AIChatMessage) == false) goto L26;
        AIChatMessage r11 = (AIChatMessage) r10;
        if (Intrinsics.areEqual(this.localMessageId, r11.localMessageId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.messageId, r11.messageId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.replyId, r11.replyId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationId, r11.conversationId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.messageStatusLocal, r11.messageStatusLocal) == true) goto L16;
        return false;
    L16:
        if (this.isSelf == r11.isSelf) goto L18;
        return false;
    L18:
        if (this.isVisible == r11.isVisible) goto L20;
        return false;
    L20:
        if (this.isContentFinished == r11.isContentFinished) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.payload, r11.payload) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ext, r11.ext) == true) goto L40;
        return false;
    L40:
        return true;
    L26:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        String r0 = this.localMessageId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.messageId;
        if (r12 == null) goto L9;
        int r13 = r12.hashCode();
    L10:
        int r14 = (r11 + r13) * 31;
        String r15 = this.replyId;
        if (r15 == null) goto L13;
        int r16 = r15.hashCode();
    L14:
        int r17 = (r14 + r16) * 31;
        String r18 = this.conversationId;
        if (r18 == null) goto L17;
        int r19 = r18.hashCode();
    L18:
        int r20 = (r17 + r19) * 31;
        AIChatMessageStatusLocal r21 = this.messageStatusLocal;
        if (r21 == null) goto L21;
        int r22 = r21.hashCode();
    L22:
        int r23 = (r20 + r22) * 31;
        boolean r24 = this.isSelf;
        ?? r25 = 1;
        ?? r26 = r24;
        if (r24 == false) goto L25;
        r26 = 1;
    L25:
        int r27 = (r23 + r26) * 31;
        boolean r28 = this.isVisible;
        ?? r29 = r28;
        if (r28 == false) goto L28;
        r29 = 1;
    L28:
        int r30 = (r27 + r29) * 31;
        boolean r31 = this.isContentFinished;
        if (r31 == true) goto L32;
        r25 = r31;
    L32:
        int r32 = (r30 + r25) * 31;
        String r33 = this.payload;
        if (r33 == null) goto L35;
        int r34 = r33.hashCode();
    L36:
        int r35 = (r32 + r34) * 31;
        Map<String, String> r36 = this.ext;
        if (r36 == null) goto L40;
        r1 = r36.hashCode();
    L40:
        return r35 + r1;
    L35:
        r34 = 0;
        goto L36
    L21:
        r22 = 0;
        goto L22
    L17:
        r19 = 0;
        goto L18
    L13:
        r16 = 0;
        goto L14
    L9:
        r13 = 0;
        goto L10
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "AIChatMessage(localMessageId=" + this.localMessageId + ", messageId=" + this.messageId + ", replyId=" + this.replyId + ", conversationId=" + this.conversationId + ", messageStatusLocal=" + this.messageStatusLocal + ", isSelf=" + this.isSelf + ", isVisible=" + this.isVisible + ", isContentFinished=" + this.isContentFinished + ", payload=" + this.payload + ", ext=" + this.ext + ")";
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final Map<String, String> getExt() {
        return this.ext;
    }

    public final String getLocalMessageId() {
        return this.localMessageId;
    }

    public final String getMessageId() {
        return this.messageId;
    }

    public final AIChatMessageStatusLocal getMessageStatusLocal() {
        return this.messageStatusLocal;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final String getReplyId() {
        return this.replyId;
    }

    public final boolean isContentFinished() {
        return this.isContentFinished;
    }

    public final boolean isSelf() {
        return this.isSelf;
    }

    public final boolean isVisible() {
        return this.isVisible;
    }

    public AIChatMessage(String r10, String r11, String r12, String r13, AIChatMessageStatusLocal r14, boolean r15, boolean r16, boolean r17, String r18, Map<String, String> r19) {
        Intrinsics.checkNotNullParameter(r10, "localMessageId");
        Intrinsics.checkNotNullParameter(r14, "messageStatusLocal");
        Intrinsics.checkNotNullParameter(r19, "ext");
        this.localMessageId = r10;
        this.messageId = r11;
        this.replyId = r12;
        this.conversationId = r13;
        this.messageStatusLocal = r14;
        this.isSelf = r15;
        this.isVisible = r16;
        this.isContentFinished = r17;
        this.payload = r18;
        this.ext = r19;
    }

    public /* synthetic */ AIChatMessage(String r11, String r12, String r13, String r14, AIChatMessageStatusLocal r15, boolean r16, boolean r17, boolean r18, String r19, Map r20, int r21, DefaultConstructorMarker r22) {
        String r10 = null;
        if ((r21 & 2) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r21 & 4) == 0) goto L9;
        String r23 = null;
    L11:
        if ((r21 & 8) == 0) goto L13;
        String r24 = null;
    L15:
        if ((r21 & 16) == 0) goto L17;
        AIChatMessageStatusLocal r25 = AIChatMessageStatusLocal.UNKNOWN;
    L19:
        if ((r21 & 32) == 0) goto L21;
        boolean r26 = false;
    L22:
        boolean r27 = true;
        if ((r21 & 64) == 0) goto L25;
        boolean r28 = true;
    L27:
        if ((r21 & 128) != 0) goto L31;
        r27 = r18;
    L31:
        if ((r21 & 256) != 0) goto L35;
        r10 = r19;
    L35:
        if ((r21 & 512) == 0) goto L37;
        Map r0 = MapsKt.emptyMap();
    L38:
        this(r11, r1, r23, r24, r25, r26, r28, r27, r10, r0);
        return;
    L37:
        r0 = r20;
        goto L38
    L25:
        r28 = r17;
        goto L27
    L21:
        r26 = r16;
        goto L22
    L17:
        r25 = r15;
        goto L19
    L13:
        r24 = r14;
        goto L15
    L9:
        r23 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
