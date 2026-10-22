package com.ss.android.lark.chat.entity.message;

import com.bytedance.lark.pb.im.v1.AIRecommendQuestionsType;
import com.ss.android.lark.chat.entity.message.content.UnreadAIReplyQueryState;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import im.v1.QuestionItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0000\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002Bi\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u00106\u001a\u00020\r2\b\u00107\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u00108\u001a\u00020\r2\b\u00107\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u00109\u001a\u00020\r2\b\u0010:\u001a\u0004\u0018\u00010;H\u0096\u0002J\u0010\u0010<\u001a\u00020\r2\b\u0010=\u001a\u0004\u0018\u00010\u0000J\u0006\u0010>\u001a\u00020\rJ\t\u0010?\u001a\u00020\u0004HÆ\u0003J\t\u0010@\u001a\u00020\u0006HÆ\u0003J\t\u0010A\u001a\u00020\u0006HÆ\u0003J\u000f\u0010B\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010C\u001a\u00020\u0004HÆ\u0003J\t\u0010D\u001a\u00020\rHÆ\u0003J\t\u0010E\u001a\u00020\u000fHÆ\u0003J\t\u0010F\u001a\u00020\u0011HÆ\u0003J\u0010\u0010G\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010.J\u000b\u0010H\u001a\u0004\u0018\u00010\u0014HÆ\u0003J|\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u0010JJ\t\u0010K\u001a\u00020\u0006HÖ\u0001J\t\u0010L\u001a\u00020MHÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0018R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u00101\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105¨\u0006N"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/AIRecommendQuestions;", "Lcom/larksuite/framework/utils/diff/Diffable;", "Ljava/io/Serializable;", "chatId", BuildConfig.FLAVOR, "startPos", BuildConfig.FLAVOR, "endPos", "questions", BuildConfig.FLAVOR, "Lim/v1/QuestionItem;", "generateTimestamp", "isShowBottom", BuildConfig.FLAVOR, "spaceType", "Lcom/ss/android/lark/chat/entity/message/AIRecommendQuestionViewSpace;", IPortraitService.TYPE, "Lcom/bytedance/lark/pb/im/v1/AIRecommendQuestionsType;", "queryId", "aiReply", "Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState;", "<init>", "(JIILjava/util/List;JZLcom/ss/android/lark/chat/entity/message/AIRecommendQuestionViewSpace;Lcom/bytedance/lark/pb/im/v1/AIRecommendQuestionsType;Ljava/lang/Long;Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState;)V", "getChatId", "()J", "getStartPos", "()I", "setStartPos", "(I)V", "getEndPos", "setEndPos", "getQuestions", "()Ljava/util/List;", "getGenerateTimestamp", "()Z", "setShowBottom", "(Z)V", "getSpaceType", "()Lcom/ss/android/lark/chat/entity/message/AIRecommendQuestionViewSpace;", "setSpaceType", "(Lcom/ss/android/lark/chat/entity/message/AIRecommendQuestionViewSpace;)V", "getType", "()Lcom/bytedance/lark/pb/im/v1/AIRecommendQuestionsType;", "setType", "(Lcom/bytedance/lark/pb/im/v1/AIRecommendQuestionsType;)V", "getQueryId", "()Ljava/lang/Long;", "setQueryId", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getAiReply", "()Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState;", "setAiReply", "(Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState;)V", "isItemSame", "diffable", "isContentSame", "equals", "other", BuildConfig.FLAVOR, "isNeedScrollToBottom", "oldRecommend", "isShowAnswer", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(JIILjava/util/List;JZLcom/ss/android/lark/chat/entity/message/AIRecommendQuestionViewSpace;Lcom/bytedance/lark/pb/im/v1/AIRecommendQuestionsType;Ljava/lang/Long;Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState;)Lcom/ss/android/lark/chat/entity/message/AIRecommendQuestions;", "hashCode", "toString", BuildConfig.FLAVOR, "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AIRecommendQuestions implements b<AIRecommendQuestions>, Serializable {
    private UnreadAIReplyQueryState aiReply;
    private final long chatId;
    private int endPos;
    private final long generateTimestamp;
    private boolean isShowBottom;
    private Long queryId;
    private final List<QuestionItem> questions;
    private AIRecommendQuestionViewSpace spaceType;
    private int startPos;
    private AIRecommendQuestionsType type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AIRecommendQuestions copy$default(AIRecommendQuestions r13, long r14, int r16, int r17, List r18, long r19, boolean r21, AIRecommendQuestionViewSpace r22, AIRecommendQuestionsType r23, Long r24, UnreadAIReplyQueryState r25, int r26, Object r27) {
        if ((r26 & 1) == 0) goto L5;
        long r2 = r13.chatId;
    L7:
        if ((r26 & 2) == 0) goto L9;
        int r4 = r13.startPos;
    L11:
        if ((r26 & 4) == 0) goto L13;
        int r5 = r13.endPos;
    L15:
        if ((r26 & 8) == 0) goto L17;
        List r6 = r13.questions;
    L19:
        if ((r26 & 16) == 0) goto L21;
        long r7 = r13.generateTimestamp;
    L23:
        if ((r26 & 32) == 0) goto L25;
        boolean r9 = r13.isShowBottom;
    L27:
        if ((r26 & 64) == 0) goto L29;
        AIRecommendQuestionViewSpace r10 = r13.spaceType;
    L31:
        if ((r26 & 128) == 0) goto L33;
        AIRecommendQuestionsType r11 = r13.type;
    L35:
        if ((r26 & 256) == 0) goto L37;
        Long r12 = r13.queryId;
    L39:
        if ((r26 & 512) == 0) goto L41;
        UnreadAIReplyQueryState r1 = r13.aiReply;
    L43:
        return r13.copy(r2, r4, r5, r6, r7, r9, r10, r11, r12, r1);
    L41:
        r1 = r25;
        goto L43
    L37:
        r12 = r24;
        goto L39
    L33:
        r11 = r23;
        goto L35
    L29:
        r10 = r22;
        goto L31
    L25:
        r9 = r21;
        goto L27
    L21:
        r7 = r19;
        goto L23
    L17:
        r6 = r18;
        goto L19
    L13:
        r5 = r17;
        goto L15
    L9:
        r4 = r16;
        goto L11
    L5:
        r2 = r14;
        goto L7
    }

    public final long component1() {
        return this.chatId;
    }

    public final UnreadAIReplyQueryState component10() {
        return this.aiReply;
    }

    public final int component2() {
        return this.startPos;
    }

    public final int component3() {
        return this.endPos;
    }

    public final List<QuestionItem> component4() {
        return this.questions;
    }

    public final long component5() {
        return this.generateTimestamp;
    }

    public final boolean component6() {
        return this.isShowBottom;
    }

    public final AIRecommendQuestionViewSpace component7() {
        return this.spaceType;
    }

    public final AIRecommendQuestionsType component8() {
        return this.type;
    }

    public final Long component9() {
        return this.queryId;
    }

    public final AIRecommendQuestions copy(long r15, int r17, int r18, List<QuestionItem> r19, long r20, boolean r22, AIRecommendQuestionViewSpace r23, AIRecommendQuestionsType r24, Long r25, UnreadAIReplyQueryState r26) {
        Intrinsics.checkNotNullParameter(r19, "questions");
        Intrinsics.checkNotNullParameter(r23, "spaceType");
        Intrinsics.checkNotNullParameter(r24, IPortraitService.TYPE);
        return new AIRecommendQuestions(r15, r17, r18, r19, r20, r22, r23, r24, r25, r26);
    }

    public int hashCode() {
        long r0 = this.chatId;
        int r1 = ((((((((int) (r0 ^ (r0 >>> 32))) * 31) + this.startPos) * 31) + this.endPos) * 31) + this.questions.hashCode()) * 31;
        long r3 = this.generateTimestamp;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        if (this.isShowBottom == false) goto L5;
        int r4 = 1231;
    L6:
        int r5 = (((((r2 + r4) * 31) + this.spaceType.hashCode()) * 31) + this.type.hashCode()) * 31;
        Long r6 = this.queryId;
        int r7 = 0;
        if (r6 != null) goto L9;
        int r8 = 0;
    L10:
        int r9 = (r5 + r8) * 31;
        UnreadAIReplyQueryState r10 = this.aiReply;
        if (r10 == null) goto L15;
        r7 = r10.hashCode();
    L15:
        return r9 + r7;
    L9:
        r8 = r6.hashCode();
        goto L10
    L5:
        r4 = 1237;
        goto L6
    }

    public String toString() {
        return "AIRecommendQuestions(chatId=" + this.chatId + ", startPos=" + this.startPos + ", endPos=" + this.endPos + ", questions=" + this.questions + ", generateTimestamp=" + this.generateTimestamp + ", isShowBottom=" + this.isShowBottom + ", spaceType=" + this.spaceType + ", type=" + this.type + ", queryId=" + this.queryId + ", aiReply=" + this.aiReply + ')';
    }

    public final boolean isShowAnswer() {
        UnreadAIReplyQueryState r0 = this.aiReply;
        if ((r0 instanceof UnreadAIReplyQueryState.Reply) == false) goto L5;
        UnreadAIReplyQueryState.Reply r1 = (UnreadAIReplyQueryState.Reply) r0;
    L7:
        if (r1 != null) goto L10;
        return false;
    L10:
        if (r1.getReply().isComplete() == false) goto L12;
    L13:
        return true;
    L12:
        if (r1.getReply().isTransmitting() == true) goto L13;
        return false;
    L5:
        r1 = null;
        goto L7
    }

    public final UnreadAIReplyQueryState getAiReply() {
        return this.aiReply;
    }

    public final long getChatId() {
        return this.chatId;
    }

    public final int getEndPos() {
        return this.endPos;
    }

    public final long getGenerateTimestamp() {
        return this.generateTimestamp;
    }

    public final Long getQueryId() {
        return this.queryId;
    }

    public final List<QuestionItem> getQuestions() {
        return this.questions;
    }

    public final AIRecommendQuestionViewSpace getSpaceType() {
        return this.spaceType;
    }

    public final int getStartPos() {
        return this.startPos;
    }

    public final AIRecommendQuestionsType getType() {
        return this.type;
    }

    public final boolean isShowBottom() {
        return this.isShowBottom;
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof AIRecommendQuestions) == true) goto L10;
        return false;
    L10:
        return isContentSame((AIRecommendQuestions) r2);
    }

    public boolean isContentSame(AIRecommendQuestions r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (r7 == null) goto L8;
        Class<AIRecommendQuestions> r1 = AIRecommendQuestions.class;
    L10:
        if (Intrinsics.areEqual(AIRecommendQuestions.class, r1) == true) goto L13;
        return false;
    L13:
        if (this.chatId == r7.chatId) goto L16;
        return false;
    L16:
        if (this.startPos == r7.startPos) goto L19;
        return false;
    L19:
        if (this.endPos == r7.endPos) goto L22;
        return false;
    L22:
        if (this.generateTimestamp == r7.generateTimestamp) goto L25;
        return false;
    L25:
        if (this.isShowBottom == r7.isShowBottom) goto L28;
        return false;
    L28:
        if (this.spaceType == r7.spaceType) goto L31;
        return false;
    L31:
        if (this.type == r7.type) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.queryId, r7.queryId) == true) goto L36;
        return false;
    L36:
        UnreadAIReplyQueryState r0 = this.aiReply;
        UnreadAIReplyQueryState r2 = r7.aiReply;
        if (r0 == null) goto L43;
        if (r2 == null) goto L43;
        if (r0.differ(r2) == true) goto L45;
        return false;
    L45:
        List<QuestionItem> r3 = this.questions;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L47:
        if (r5.hasNext() == false) goto L49;
        r4.add(((QuestionItem) r5.next()).id);
        goto L47
    L49:
        Set r6 = CollectionsKt.toSet(r4);
        List<QuestionItem> r8 = r7.questions;
        ArrayList r9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r10 = r8.iterator();
    L51:
        if (r10.hasNext() == false) goto L54;
        r9.add(((QuestionItem) r10.next()).id);
        goto L51
    L54:
        return Intrinsics.areEqual(r6, CollectionsKt.toSet(r9));
    L43:
        if (Intrinsics.areEqual(r0, r2) == true) goto L45;
        return false;
    L8:
        r1 = null;
        goto L10
    }

    public boolean isItemSame(AIRecommendQuestions r8) {
        if (r8 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == true) goto L10;
    L12:
        return false;
    L10:
        if (this.generateTimestamp != r8.generateTimestamp) goto L12;
        return true;
    L5:
        if (this.chatId != r8.chatId) goto L7;
        r2 = true;
        goto L8
    }

    public final boolean isNeedScrollToBottom(AIRecommendQuestions r3) {
        if (r3 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L11;
        return false;
    L11:
        if (isShowAnswer() == false) goto L13;
        return true;
    L13:
        return false;
    L5:
        if (r3.isShowAnswer() != true) goto L7;
        r4 = true;
        goto L8
    }

    public final void setAiReply(UnreadAIReplyQueryState r1) {
        this.aiReply = r1;
    }

    public final void setEndPos(int r1) {
        this.endPos = r1;
    }

    public final void setQueryId(Long r1) {
        this.queryId = r1;
    }

    public final void setShowBottom(boolean r1) {
        this.isShowBottom = r1;
    }

    public final void setSpaceType(AIRecommendQuestionViewSpace r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.spaceType = r2;
    }

    public final void setStartPos(int r1) {
        this.startPos = r1;
    }

    public final void setType(AIRecommendQuestionsType r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.type = r2;
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((AIRecommendQuestions) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((AIRecommendQuestions) r1);
    }

    public AIRecommendQuestions(long r2, int r4, int r5, List<QuestionItem> r6, long r7, boolean r9, AIRecommendQuestionViewSpace r10, AIRecommendQuestionsType r11, Long r12, UnreadAIReplyQueryState r13) {
        Intrinsics.checkNotNullParameter(r6, "questions");
        Intrinsics.checkNotNullParameter(r10, "spaceType");
        Intrinsics.checkNotNullParameter(r11, IPortraitService.TYPE);
        this.chatId = r2;
        this.startPos = r4;
        this.endPos = r5;
        this.questions = r6;
        this.generateTimestamp = r7;
        this.isShowBottom = r9;
        this.spaceType = r10;
        this.type = r11;
        this.queryId = r12;
        this.aiReply = r13;
    }

    public /* synthetic */ AIRecommendQuestions(long r16, int r18, int r19, List r20, long r21, boolean r23, AIRecommendQuestionViewSpace r24, AIRecommendQuestionsType r25, Long r26, UnreadAIReplyQueryState r27, int r28, DefaultConstructorMarker r29) {
        if ((r28 & 32) == 0) goto L5;
        boolean r10 = true;
    L7:
        if ((r28 & 64) == 0) goto L9;
        AIRecommendQuestionViewSpace r11 = AIRecommendQuestionViewSpace.Normal;
    L11:
        if ((r28 & 128) == 0) goto L13;
        AIRecommendQuestionsType r12 = AIRecommendQuestionsType.UnreadSammary;
    L15:
        if ((r28 & 512) == 0) goto L17;
        UnreadAIReplyQueryState r14 = null;
    L18:
        this(r16, r18, r19, r20, r21, r10, r11, r12, r26, r14);
        return;
    L17:
        r14 = r27;
        goto L18
    L13:
        r12 = r25;
        goto L15
    L9:
        r11 = r24;
        goto L11
    L5:
        r10 = r23;
        goto L7
    }
}
