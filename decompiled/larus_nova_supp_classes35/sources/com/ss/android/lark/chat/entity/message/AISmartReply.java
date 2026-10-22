package com.ss.android.lark.chat.entity.message;

import com.bytedance.lark.pb.basic.v1.AIReply;
import com.ss.android.lark.parser.internal.g0;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.richtext.i;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import iec.g;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u0000 92\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\u00020\u0003:\u00019B[\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010%\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0000H\u0016J\u0011\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0000H\u0096\u0002J\b\u0010)\u001a\u00020\fH\u0016J\u0006\u0010*\u001a\u00020#J\b\u0010+\u001a\u0004\u0018\u00010,J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00101\u001a\u00020\fHÆ\u0003J\t\u00102\u001a\u00020\fHÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\u0019\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012HÆ\u0003Jm\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012HÆ\u0001J\u0013\u00106\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u000107HÖ\u0003J\t\u00108\u001a\u00020'HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R!\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006:"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/AISmartReply;", "Lcom/larksuite/framework/utils/diff/Diffable;", BuildConfig.FLAVOR, "Ljava/io/Serializable;", "messageId", BuildConfig.FLAVOR, "status", "Lcom/ss/android/lark/chat/entity/message/Status;", "content", "Lcom/ss/android/lark/widget/richtext/RichText;", "references", "textWithoutCitation", BuildConfig.FLAVOR, "aiReplyId", "updateTime", "referenceItems", "Ljava/util/ArrayList;", "Lcom/bytedance/lark/pb/basic/v1/AIReply$ReferenceItem;", "Lkotlin/collections/ArrayList;", "<init>", "(JLcom/ss/android/lark/chat/entity/message/Status;Lcom/ss/android/lark/widget/richtext/RichText;Lcom/ss/android/lark/widget/richtext/RichText;Ljava/lang/String;Ljava/lang/String;JLjava/util/ArrayList;)V", "getMessageId", "()J", "getStatus", "()Lcom/ss/android/lark/chat/entity/message/Status;", "getContent", "()Lcom/ss/android/lark/widget/richtext/RichText;", "getReferences", "getTextWithoutCitation", "()Ljava/lang/String;", "getAiReplyId", "getUpdateTime", "getReferenceItems", "()Ljava/util/ArrayList;", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "compareTo", BuildConfig.FLAVOR, "other", "toString", "isApplyAnswerVisible", "parseToVO", "Lcom/ss/android/lark/chat/entity/message/AISmartReplyVO;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", BuildConfig.FLAVOR, "hashCode", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AISmartReply implements b<AISmartReply>, Comparable<AISmartReply>, Serializable {
    public static final a Companion = null;
    private final String aiReplyId;
    private final RichText content;
    private final long messageId;
    private final ArrayList<AIReply.ReferenceItem> referenceItems;
    private final RichText references;
    private final Status status;
    private final String textWithoutCitation;
    private final long updateTime;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static AISmartReply a(AIReply r13) {
            if (r13 != null) goto L5;
            return null;
        L5:
            long r2 = r13.message_id.longValue();
            Status.a r1 = Status.Companion;
            AIReply.Status r4 = r13.status;
            r1.getClass();
            return new AISmartReply(r2, Status.a.a(r4), g0.e(r13.rich_text, null), g0.e(r13.references, null), r13.text_without_citation, r13.ai_reply_id, r13.update_time.longValue(), new ArrayList(r13.reference_list));
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AISmartReply copy$default(AISmartReply r11, long r12, Status r14, RichText r15, RichText r16, String r17, String r18, long r19, ArrayList r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        long r2 = r11.messageId;
    L7:
        if ((r22 & 2) == 0) goto L9;
        Status r4 = r11.status;
    L11:
        if ((r22 & 4) == 0) goto L13;
        RichText r5 = r11.content;
    L15:
        if ((r22 & 8) == 0) goto L17;
        RichText r6 = r11.references;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r7 = r11.textWithoutCitation;
    L23:
        if ((r22 & 32) == 0) goto L25;
        String r8 = r11.aiReplyId;
    L27:
        if ((r22 & 64) == 0) goto L29;
        long r9 = r11.updateTime;
    L31:
        if ((r22 & 128) == 0) goto L33;
        ArrayList r1 = r11.referenceItems;
    L35:
        return r11.copy(r2, r4, r5, r6, r7, r8, r9, r1);
    L33:
        r1 = r21;
        goto L35
    L29:
        r9 = r19;
        goto L31
    L25:
        r8 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L13:
        r5 = r15;
        goto L15
    L9:
        r4 = r14;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    @JvmStatic
    public static final AISmartReply parsePbToAIReply(AIReply r1) {
        Companion.getClass();
        return a.a(r1);
    }

    public final long component1() {
        return this.messageId;
    }

    public final Status component2() {
        return this.status;
    }

    public final RichText component3() {
        return this.content;
    }

    public final RichText component4() {
        return this.references;
    }

    public final String component5() {
        return this.textWithoutCitation;
    }

    public final String component6() {
        return this.aiReplyId;
    }

    public final long component7() {
        return this.updateTime;
    }

    public final ArrayList<AIReply.ReferenceItem> component8() {
        return this.referenceItems;
    }

    public final AISmartReply copy(long r13, Status r15, RichText r16, RichText r17, String r18, String r19, long r20, ArrayList<AIReply.ReferenceItem> r22) {
        Intrinsics.checkNotNullParameter(r15, "status");
        Intrinsics.checkNotNullParameter(r18, "textWithoutCitation");
        Intrinsics.checkNotNullParameter(r19, "aiReplyId");
        Intrinsics.checkNotNullParameter(r22, "referenceItems");
        return new AISmartReply(r13, r15, r16, r17, r18, r19, r20, r22);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof AISmartReply) == true) goto L8;
        return false;
    L8:
        AISmartReply r9 = (AISmartReply) r8;
        if (this.messageId == r9.messageId) goto L12;
        return false;
    L12:
        if (this.status == r9.status) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r9.content) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.references, r9.references) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.textWithoutCitation, r9.textWithoutCitation) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.aiReplyId, r9.aiReplyId) == true) goto L27;
        return false;
    L27:
        if (this.updateTime == r9.updateTime) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.referenceItems, r9.referenceItems) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        long r0 = this.messageId;
        int r1 = ((((int) (r0 ^ (r0 >>> 32))) * 31) + this.status.hashCode()) * 31;
        RichText r2 = this.content;
        int r3 = 0;
        if (r2 != null) goto L5;
        int r4 = 0;
    L6:
        int r5 = (r1 + r4) * 31;
        RichText r6 = this.references;
        if (r6 == null) goto L10;
        r3 = r6.hashCode();
    L10:
        int r7 = (((((r5 + r3) * 31) + this.textWithoutCitation.hashCode()) * 31) + this.aiReplyId.hashCode()) * 31;
        long r8 = this.updateTime;
        return ((r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31) + this.referenceItems.hashCode();
    L5:
        r4 = r2.hashCode();
        goto L6
    }

    public final boolean isApplyAnswerVisible() {
        if (this.status != Status.OVER) goto L5;
        return true;
    L5:
        return false;
    }

    public String toString() {
        return "AISmartReply(messageId=" + this.messageId + ", status=" + this.status + ", aiReplyId='" + this.aiReplyId + "', updateTime=" + this.updateTime + ')';
    }

    public final f5b.a parseToVO() {
        if (isApplyAnswerVisible() == false) goto L6;
        g.a r0 = new g.a();
        r0.d.a = false;
        g r1 = r0.a();
        return new f5b.a(this.messageId, this.aiReplyId, i.d(this.content, r1));
    L6:
        return null;
    }

    public final String getAiReplyId() {
        return this.aiReplyId;
    }

    public final RichText getContent() {
        return this.content;
    }

    public final long getMessageId() {
        return this.messageId;
    }

    public final ArrayList<AIReply.ReferenceItem> getReferenceItems() {
        return this.referenceItems;
    }

    public final RichText getReferences() {
        return this.references;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final String getTextWithoutCitation() {
        return this.textWithoutCitation;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(AISmartReply r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        long r0 = this.updateTime;
        long r2 = r5.updateTime;
        if (r0 <= r2) goto L6;
        return 1;
    L6:
        if (r0 != r2) goto L8;
        return 0;
    L8:
        return -1;
    }

    public boolean isContentSame(AISmartReply r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if (r8 == null) goto L8;
        Class<AISmartReply> r2 = AISmartReply.class;
    L10:
        if (Intrinsics.areEqual(AISmartReply.class, r2) == true) goto L13;
        return false;
    L13:
        if (this.messageId == r8.messageId) goto L16;
        return false;
    L16:
        if (this.updateTime == r8.updateTime) goto L19;
        return false;
    L19:
        if (this.status == r8.status) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.content, r8.content) == true) goto L25;
        return false;
    L25:
        if (Intrinsics.areEqual(this.references, r8.references) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.textWithoutCitation, r8.textWithoutCitation) == true) goto L31;
        return false;
    L31:
        if (Intrinsics.areEqual(this.aiReplyId, r8.aiReplyId) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.referenceItems, r8.referenceItems) == true) goto L36;
        return false;
    L36:
        return true;
    L8:
        r2 = null;
        goto L10
    }

    public boolean isItemSame(AISmartReply r5) {
        String r0 = this.aiReplyId;
        if (r5 == null) goto L5;
        String r1 = r5.aiReplyId;
    L7:
        if (Intrinsics.areEqual(r0, r1) == true) goto L9;
    L11:
        return false;
    L9:
        if (this.messageId != r5.messageId) goto L11;
        return true;
    L5:
        r1 = null;
        goto L7
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(AISmartReply r1) {
        return compareTo2(r1);
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((AISmartReply) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((AISmartReply) r1);
    }

    public AISmartReply(long r2, Status r4, RichText r5, RichText r6, String r7, String r8, long r9, ArrayList<AIReply.ReferenceItem> r11) {
        Intrinsics.checkNotNullParameter(r4, "status");
        Intrinsics.checkNotNullParameter(r7, "textWithoutCitation");
        Intrinsics.checkNotNullParameter(r8, "aiReplyId");
        Intrinsics.checkNotNullParameter(r11, "referenceItems");
        this.messageId = r2;
        this.status = r4;
        this.content = r5;
        this.references = r6;
        this.textWithoutCitation = r7;
        this.aiReplyId = r8;
        this.updateTime = r9;
        this.referenceItems = r11;
    }
}
