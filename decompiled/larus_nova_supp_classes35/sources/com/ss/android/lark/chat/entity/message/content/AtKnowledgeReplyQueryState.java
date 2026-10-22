package com.ss.android.lark.chat.entity.message.content;

import com.bytedance.lark.pb.basic.v1.CommonAIReply;
import com.bytedance.lark.pb.basic.v1.TriggerScene;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0006\u000b\f\r\u000e\u000f\u0010B\t\b\u0004¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0007J\u0006\u0010\n\u001a\u00020\u0007\u0082\u0001\u0006\u0011\u0012\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;", "Ljava/io/Serializable;", "Lcom/ss/android/lark/chat/entity/message/content/IReplyState;", "Lcom/ss/android/lark/chat/entity/message/content/IAtKnowledgeProperty;", "<init>", "()V", "isTransmitting", BuildConfig.FLAVOR, "isComplete", "isClose", "isEndState", "Closed", "NoAnswer", "Error", "Cot", "Transmitting", "Over", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Closed;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Cot;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Error;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$NoAnswer;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Over;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Transmitting;", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class AtKnowledgeReplyQueryState implements Serializable {

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Closed;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;", "queryId", BuildConfig.FLAVOR, "queryCreateTime", "seqId", BuildConfig.FLAVOR, "aiReplyId", BuildConfig.FLAVOR, "query", "Lcom/ss/android/lark/widget/richtext/RichText;", "source", "Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "triggerScene", "Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "<init>", "(JJILjava/lang/String;Lcom/ss/android/lark/widget/richtext/RichText;Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;Lcom/bytedance/lark/pb/basic/v1/TriggerScene;)V", "getQueryId", "()J", "getQueryCreateTime", "getSeqId", "()I", "getAiReplyId", "()Ljava/lang/String;", "getQuery", "()Lcom/ss/android/lark/widget/richtext/RichText;", "getSource", "()Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "getTriggerScene", "()Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static class Closed extends AtKnowledgeReplyQueryState {
        private final String aiReplyId;
        private final RichText query;
        private final long queryCreateTime;
        private final long queryId;
        private final int seqId;
        private final AtAIKnowledgeSourceClient source;
        private final TriggerScene triggerScene;

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public String getAiReplyId() {
            return this.aiReplyId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public RichText getQuery() {
            return this.query;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryCreateTime() {
            return this.queryCreateTime;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryId() {
            return this.queryId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public int getSeqId() {
            return this.seqId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public AtAIKnowledgeSourceClient getSource() {
            return this.source;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public TriggerScene getTriggerScene() {
            return this.triggerScene;
        }

        public Closed(long r2, long r4, int r6, String r7, RichText r8, AtAIKnowledgeSourceClient r9, TriggerScene r10) {
            Intrinsics.checkNotNullParameter(r7, "aiReplyId");
            Intrinsics.checkNotNullParameter(r8, "query");
            super(null);
            this.queryId = r2;
            this.queryCreateTime = r4;
            this.seqId = r6;
            this.aiReplyId = r7;
            this.query = r8;
            this.source = r9;
            this.triggerScene = r10;
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0006HÆ\u0003J\t\u0010#\u001a\u00020\bHÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u000fHÆ\u0003J]\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001J\u0013\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,HÖ\u0003J\t\u0010-\u001a\u00020\u0006HÖ\u0001J\t\u0010.\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006/"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Cot;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;", "queryId", BuildConfig.FLAVOR, "queryCreateTime", "seqId", BuildConfig.FLAVOR, "aiReplyId", BuildConfig.FLAVOR, "query", "Lcom/ss/android/lark/widget/richtext/RichText;", "cotText", "source", "Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "triggerScene", "Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "<init>", "(JJILjava/lang/String;Lcom/ss/android/lark/widget/richtext/RichText;Ljava/lang/String;Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;Lcom/bytedance/lark/pb/basic/v1/TriggerScene;)V", "getQueryId", "()J", "getQueryCreateTime", "getSeqId", "()I", "getAiReplyId", "()Ljava/lang/String;", "getQuery", "()Lcom/ss/android/lark/widget/richtext/RichText;", "getCotText", "getSource", "()Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "getTriggerScene", "()Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Cot extends AtKnowledgeReplyQueryState {
        private final String aiReplyId;
        private final String cotText;
        private final RichText query;
        private final long queryCreateTime;
        private final long queryId;
        private final int seqId;
        private final AtAIKnowledgeSourceClient source;
        private final TriggerScene triggerScene;

        public static /* synthetic */ Cot copy$default(Cot r11, long r12, long r14, int r16, String r17, RichText r18, String r19, AtAIKnowledgeSourceClient r20, TriggerScene r21, int r22, Object r23) {
            if ((r22 & 1) == 0) goto L5;
            long r2 = r11.queryId;
        L7:
            if ((r22 & 2) == 0) goto L9;
            long r4 = r11.queryCreateTime;
        L11:
            if ((r22 & 4) == 0) goto L13;
            int r6 = r11.seqId;
        L15:
            if ((r22 & 8) == 0) goto L17;
            String r7 = r11.aiReplyId;
        L19:
            if ((r22 & 16) == 0) goto L21;
            RichText r8 = r11.query;
        L23:
            if ((r22 & 32) == 0) goto L25;
            String r9 = r11.cotText;
        L27:
            if ((r22 & 64) == 0) goto L29;
            AtAIKnowledgeSourceClient r10 = r11.source;
        L31:
            if ((r22 & 128) == 0) goto L33;
            TriggerScene r1 = r11.triggerScene;
        L35:
            return r11.copy(r2, r4, r6, r7, r8, r9, r10, r1);
        L33:
            r1 = r21;
            goto L35
        L29:
            r10 = r20;
            goto L31
        L25:
            r9 = r19;
            goto L27
        L21:
            r8 = r18;
            goto L23
        L17:
            r7 = r17;
            goto L19
        L13:
            r6 = r16;
            goto L15
        L9:
            r4 = r14;
            goto L11
        L5:
            r2 = r12;
            goto L7
        }

        public final long component1() {
            return this.queryId;
        }

        public final long component2() {
            return this.queryCreateTime;
        }

        public final int component3() {
            return this.seqId;
        }

        public final String component4() {
            return this.aiReplyId;
        }

        public final RichText component5() {
            return this.query;
        }

        public final String component6() {
            return this.cotText;
        }

        public final AtAIKnowledgeSourceClient component7() {
            return this.source;
        }

        public final TriggerScene component8() {
            return this.triggerScene;
        }

        public final Cot copy(long r13, long r15, int r17, String r18, RichText r19, String r20, AtAIKnowledgeSourceClient r21, TriggerScene r22) {
            Intrinsics.checkNotNullParameter(r18, "aiReplyId");
            Intrinsics.checkNotNullParameter(r19, "query");
            Intrinsics.checkNotNullParameter(r20, "cotText");
            return new Cot(r13, r15, r17, r18, r19, r20, r21, r22);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Cot) == true) goto L8;
            return false;
        L8:
            Cot r9 = (Cot) r8;
            if (this.queryId == r9.queryId) goto L12;
            return false;
        L12:
            if (this.queryCreateTime == r9.queryCreateTime) goto L15;
            return false;
        L15:
            if (this.seqId == r9.seqId) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.aiReplyId, r9.aiReplyId) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.query, r9.query) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.cotText, r9.cotText) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.source, r9.source) == true) goto L30;
            return false;
        L30:
            if (this.triggerScene == r9.triggerScene) goto L32;
            return false;
        L32:
            return true;
        }

        public int hashCode() {
            long r0 = this.queryId;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.queryCreateTime;
            int r2 = (((((((((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.seqId) * 31) + this.aiReplyId.hashCode()) * 31) + this.query.hashCode()) * 31) + this.cotText.hashCode()) * 31;
            AtAIKnowledgeSourceClient r4 = this.source;
            int r5 = 0;
            if (r4 != null) goto L5;
            int r6 = 0;
        L6:
            int r7 = (r2 + r6) * 31;
            TriggerScene r8 = this.triggerScene;
            if (r8 == null) goto L11;
            r5 = r8.hashCode();
        L11:
            return r7 + r5;
        L5:
            r6 = r4.hashCode();
            goto L6
        }

        public String toString() {
            return "Cot(queryId=" + this.queryId + ", queryCreateTime=" + this.queryCreateTime + ", seqId=" + this.seqId + ", aiReplyId=" + this.aiReplyId + ", query=" + this.query + ", cotText=" + this.cotText + ", source=" + this.source + ", triggerScene=" + this.triggerScene + ')';
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public String getAiReplyId() {
            return this.aiReplyId;
        }

        public final String getCotText() {
            return this.cotText;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public RichText getQuery() {
            return this.query;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryCreateTime() {
            return this.queryCreateTime;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryId() {
            return this.queryId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public int getSeqId() {
            return this.seqId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public AtAIKnowledgeSourceClient getSource() {
            return this.source;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public TriggerScene getTriggerScene() {
            return this.triggerScene;
        }

        public Cot(long r2, long r4, int r6, String r7, RichText r8, String r9, AtAIKnowledgeSourceClient r10, TriggerScene r11) {
            Intrinsics.checkNotNullParameter(r7, "aiReplyId");
            Intrinsics.checkNotNullParameter(r8, "query");
            Intrinsics.checkNotNullParameter(r9, "cotText");
            super(null);
            this.queryId = r2;
            this.queryCreateTime = r4;
            this.seqId = r6;
            this.aiReplyId = r7;
            this.query = r8;
            this.cotText = r9;
            this.source = r10;
            this.triggerScene = r11;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0006HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u000eHÆ\u0003JS\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020\u0006HÖ\u0001J\t\u0010+\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006,"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Error;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;", "queryId", BuildConfig.FLAVOR, "queryCreateTime", "seqId", BuildConfig.FLAVOR, "aiReplyId", BuildConfig.FLAVOR, "query", "Lcom/ss/android/lark/widget/richtext/RichText;", "source", "Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "triggerScene", "Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "<init>", "(JJILjava/lang/String;Lcom/ss/android/lark/widget/richtext/RichText;Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;Lcom/bytedance/lark/pb/basic/v1/TriggerScene;)V", "getQueryId", "()J", "getQueryCreateTime", "getSeqId", "()I", "getAiReplyId", "()Ljava/lang/String;", "getQuery", "()Lcom/ss/android/lark/widget/richtext/RichText;", "getSource", "()Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "getTriggerScene", "()Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Error extends AtKnowledgeReplyQueryState {
        private final String aiReplyId;
        private final RichText query;
        private final long queryCreateTime;
        private final long queryId;
        private final int seqId;
        private final AtAIKnowledgeSourceClient source;
        private final TriggerScene triggerScene;

        public static /* synthetic */ Error copy$default(Error r10, long r11, long r13, int r15, String r16, RichText r17, AtAIKnowledgeSourceClient r18, TriggerScene r19, int r20, Object r21) {
            if ((r20 & 1) == 0) goto L5;
            long r1 = r10.queryId;
        L7:
            if ((r20 & 2) == 0) goto L9;
            long r3 = r10.queryCreateTime;
        L11:
            if ((r20 & 4) == 0) goto L13;
            int r5 = r10.seqId;
        L15:
            if ((r20 & 8) == 0) goto L17;
            String r6 = r10.aiReplyId;
        L19:
            if ((r20 & 16) == 0) goto L21;
            RichText r7 = r10.query;
        L23:
            if ((r20 & 32) == 0) goto L25;
            AtAIKnowledgeSourceClient r8 = r10.source;
        L27:
            if ((r20 & 64) == 0) goto L29;
            TriggerScene r9 = r10.triggerScene;
        L31:
            return r10.copy(r1, r3, r5, r6, r7, r8, r9);
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
            r3 = r13;
            goto L11
        L5:
            r1 = r11;
            goto L7
        }

        public final long component1() {
            return this.queryId;
        }

        public final long component2() {
            return this.queryCreateTime;
        }

        public final int component3() {
            return this.seqId;
        }

        public final String component4() {
            return this.aiReplyId;
        }

        public final RichText component5() {
            return this.query;
        }

        public final AtAIKnowledgeSourceClient component6() {
            return this.source;
        }

        public final TriggerScene component7() {
            return this.triggerScene;
        }

        public final Error copy(long r12, long r14, int r16, String r17, RichText r18, AtAIKnowledgeSourceClient r19, TriggerScene r20) {
            Intrinsics.checkNotNullParameter(r17, "aiReplyId");
            Intrinsics.checkNotNullParameter(r18, "query");
            return new Error(r12, r14, r16, r17, r18, r19, r20);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Error) == true) goto L8;
            return false;
        L8:
            Error r9 = (Error) r8;
            if (this.queryId == r9.queryId) goto L12;
            return false;
        L12:
            if (this.queryCreateTime == r9.queryCreateTime) goto L15;
            return false;
        L15:
            if (this.seqId == r9.seqId) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.aiReplyId, r9.aiReplyId) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.query, r9.query) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.source, r9.source) == true) goto L27;
            return false;
        L27:
            if (this.triggerScene == r9.triggerScene) goto L29;
            return false;
        L29:
            return true;
        }

        public int hashCode() {
            long r0 = this.queryId;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.queryCreateTime;
            int r2 = (((((((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.seqId) * 31) + this.aiReplyId.hashCode()) * 31) + this.query.hashCode()) * 31;
            AtAIKnowledgeSourceClient r4 = this.source;
            int r5 = 0;
            if (r4 != null) goto L5;
            int r6 = 0;
        L6:
            int r7 = (r2 + r6) * 31;
            TriggerScene r8 = this.triggerScene;
            if (r8 == null) goto L11;
            r5 = r8.hashCode();
        L11:
            return r7 + r5;
        L5:
            r6 = r4.hashCode();
            goto L6
        }

        public String toString() {
            return "Error(queryId=" + this.queryId + ", queryCreateTime=" + this.queryCreateTime + ", seqId=" + this.seqId + ", aiReplyId=" + this.aiReplyId + ", query=" + this.query + ", source=" + this.source + ", triggerScene=" + this.triggerScene + ')';
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public String getAiReplyId() {
            return this.aiReplyId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public RichText getQuery() {
            return this.query;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryCreateTime() {
            return this.queryCreateTime;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryId() {
            return this.queryId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public int getSeqId() {
            return this.seqId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public AtAIKnowledgeSourceClient getSource() {
            return this.source;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public TriggerScene getTriggerScene() {
            return this.triggerScene;
        }

        public Error(long r2, long r4, int r6, String r7, RichText r8, AtAIKnowledgeSourceClient r9, TriggerScene r10) {
            Intrinsics.checkNotNullParameter(r7, "aiReplyId");
            Intrinsics.checkNotNullParameter(r8, "query");
            super(null);
            this.queryId = r2;
            this.queryCreateTime = r4;
            this.seqId = r6;
            this.aiReplyId = r7;
            this.query = r8;
            this.source = r9;
            this.triggerScene = r10;
        }

        public /* synthetic */ Error(long r12, long r14, int r16, String r17, RichText r18, AtAIKnowledgeSourceClient r19, TriggerScene r20, int r21, DefaultConstructorMarker r22) {
            if ((r21 & 4) == 0) goto L5;
            int r6 = -1;
        L7:
            if ((r21 & 8) == 0) goto L9;
            String r7 = BuildConfig.FLAVOR;
        L10:
            this(r12, r14, r6, r7, r18, r19, r20);
            return;
        L9:
            r7 = r17;
            goto L10
        L5:
            r6 = r16;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0010HÆ\u0003Jg\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÆ\u0001J\u0013\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\u0006HÖ\u0001J\t\u00101\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u00062"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$NoAnswer;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;", "queryId", BuildConfig.FLAVOR, "queryCreateTime", "seqId", BuildConfig.FLAVOR, "aiReplyId", BuildConfig.FLAVOR, "query", "Lcom/ss/android/lark/widget/richtext/RichText;", "content", "textWithoutCitation", "source", "Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "triggerScene", "Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "<init>", "(JJILjava/lang/String;Lcom/ss/android/lark/widget/richtext/RichText;Lcom/ss/android/lark/widget/richtext/RichText;Ljava/lang/String;Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;Lcom/bytedance/lark/pb/basic/v1/TriggerScene;)V", "getQueryId", "()J", "getQueryCreateTime", "getSeqId", "()I", "getAiReplyId", "()Ljava/lang/String;", "getQuery", "()Lcom/ss/android/lark/widget/richtext/RichText;", "getContent", "getTextWithoutCitation", "getSource", "()Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "getTriggerScene", "()Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NoAnswer extends AtKnowledgeReplyQueryState {
        private final String aiReplyId;
        private final RichText content;
        private final RichText query;
        private final long queryCreateTime;
        private final long queryId;
        private final int seqId;
        private final AtAIKnowledgeSourceClient source;
        private final String textWithoutCitation;
        private final TriggerScene triggerScene;

        public static /* synthetic */ NoAnswer copy$default(NoAnswer r12, long r13, long r15, int r17, String r18, RichText r19, RichText r20, String r21, AtAIKnowledgeSourceClient r22, TriggerScene r23, int r24, Object r25) {
            if ((r24 & 1) == 0) goto L5;
            long r2 = r12.queryId;
        L7:
            if ((r24 & 2) == 0) goto L9;
            long r4 = r12.queryCreateTime;
        L11:
            if ((r24 & 4) == 0) goto L13;
            int r6 = r12.seqId;
        L15:
            if ((r24 & 8) == 0) goto L17;
            String r7 = r12.aiReplyId;
        L19:
            if ((r24 & 16) == 0) goto L21;
            RichText r8 = r12.query;
        L23:
            if ((r24 & 32) == 0) goto L25;
            RichText r9 = r12.content;
        L27:
            if ((r24 & 64) == 0) goto L29;
            String r10 = r12.textWithoutCitation;
        L31:
            if ((r24 & 128) == 0) goto L33;
            AtAIKnowledgeSourceClient r11 = r12.source;
        L35:
            if ((r24 & 256) == 0) goto L37;
            TriggerScene r1 = r12.triggerScene;
        L39:
            return r12.copy(r2, r4, r6, r7, r8, r9, r10, r11, r1);
        L37:
            r1 = r23;
            goto L39
        L33:
            r11 = r22;
            goto L35
        L29:
            r10 = r21;
            goto L31
        L25:
            r9 = r20;
            goto L27
        L21:
            r8 = r19;
            goto L23
        L17:
            r7 = r18;
            goto L19
        L13:
            r6 = r17;
            goto L15
        L9:
            r4 = r15;
            goto L11
        L5:
            r2 = r13;
            goto L7
        }

        public final long component1() {
            return this.queryId;
        }

        public final long component2() {
            return this.queryCreateTime;
        }

        public final int component3() {
            return this.seqId;
        }

        public final String component4() {
            return this.aiReplyId;
        }

        public final RichText component5() {
            return this.query;
        }

        public final RichText component6() {
            return this.content;
        }

        public final String component7() {
            return this.textWithoutCitation;
        }

        public final AtAIKnowledgeSourceClient component8() {
            return this.source;
        }

        public final TriggerScene component9() {
            return this.triggerScene;
        }

        public final NoAnswer copy(long r14, long r16, int r18, String r19, RichText r20, RichText r21, String r22, AtAIKnowledgeSourceClient r23, TriggerScene r24) {
            Intrinsics.checkNotNullParameter(r19, "aiReplyId");
            Intrinsics.checkNotNullParameter(r20, "query");
            Intrinsics.checkNotNullParameter(r21, "content");
            Intrinsics.checkNotNullParameter(r22, "textWithoutCitation");
            return new NoAnswer(r14, r16, r18, r19, r20, r21, r22, r23, r24);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof NoAnswer) == true) goto L8;
            return false;
        L8:
            NoAnswer r9 = (NoAnswer) r8;
            if (this.queryId == r9.queryId) goto L12;
            return false;
        L12:
            if (this.queryCreateTime == r9.queryCreateTime) goto L15;
            return false;
        L15:
            if (this.seqId == r9.seqId) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.aiReplyId, r9.aiReplyId) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.query, r9.query) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.content, r9.content) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.textWithoutCitation, r9.textWithoutCitation) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.source, r9.source) == true) goto L33;
            return false;
        L33:
            if (this.triggerScene == r9.triggerScene) goto L35;
            return false;
        L35:
            return true;
        }

        public int hashCode() {
            long r0 = this.queryId;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.queryCreateTime;
            int r2 = (((((((((((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.seqId) * 31) + this.aiReplyId.hashCode()) * 31) + this.query.hashCode()) * 31) + this.content.hashCode()) * 31) + this.textWithoutCitation.hashCode()) * 31;
            AtAIKnowledgeSourceClient r4 = this.source;
            int r5 = 0;
            if (r4 != null) goto L5;
            int r6 = 0;
        L6:
            int r7 = (r2 + r6) * 31;
            TriggerScene r8 = this.triggerScene;
            if (r8 == null) goto L11;
            r5 = r8.hashCode();
        L11:
            return r7 + r5;
        L5:
            r6 = r4.hashCode();
            goto L6
        }

        public String toString() {
            return "NoAnswer(queryId=" + this.queryId + ", queryCreateTime=" + this.queryCreateTime + ", seqId=" + this.seqId + ", aiReplyId=" + this.aiReplyId + ", query=" + this.query + ", content=" + this.content + ", textWithoutCitation=" + this.textWithoutCitation + ", source=" + this.source + ", triggerScene=" + this.triggerScene + ')';
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public String getAiReplyId() {
            return this.aiReplyId;
        }

        public final RichText getContent() {
            return this.content;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public RichText getQuery() {
            return this.query;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryCreateTime() {
            return this.queryCreateTime;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryId() {
            return this.queryId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public int getSeqId() {
            return this.seqId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public AtAIKnowledgeSourceClient getSource() {
            return this.source;
        }

        public final String getTextWithoutCitation() {
            return this.textWithoutCitation;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public TriggerScene getTriggerScene() {
            return this.triggerScene;
        }

        public NoAnswer(long r2, long r4, int r6, String r7, RichText r8, RichText r9, String r10, AtAIKnowledgeSourceClient r11, TriggerScene r12) {
            Intrinsics.checkNotNullParameter(r7, "aiReplyId");
            Intrinsics.checkNotNullParameter(r8, "query");
            Intrinsics.checkNotNullParameter(r9, "content");
            Intrinsics.checkNotNullParameter(r10, "textWithoutCitation");
            super(null);
            this.queryId = r2;
            this.queryCreateTime = r4;
            this.seqId = r6;
            this.aiReplyId = r7;
            this.query = r8;
            this.content = r9;
            this.textWithoutCitation = r10;
            this.source = r11;
            this.triggerScene = r12;
        }

        public /* synthetic */ NoAnswer(long r14, long r16, int r18, String r19, RichText r20, RichText r21, String r22, AtAIKnowledgeSourceClient r23, TriggerScene r24, int r25, DefaultConstructorMarker r26) {
            if ((r25 & 4) == 0) goto L5;
            int r6 = -1;
        L7:
            if ((r25 & 8) == 0) goto L9;
            String r7 = BuildConfig.FLAVOR;
        L10:
            this(r14, r16, r6, r7, r20, r21, r22, r23, r24);
            return;
        L9:
            r7 = r19;
            goto L10
        L5:
            r6 = r18;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\t\u0010/\u001a\u00020\nHÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\u0019\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010HÆ\u0003J\t\u00102\u001a\u00020\bHÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u008b\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\b\b\u0002\u0010\u0011\u001a\u00020\b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109HÖ\u0003J\t\u0010:\u001a\u00020\u0006HÖ\u0001J\t\u0010;\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0011\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006<"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Over;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;", "queryId", BuildConfig.FLAVOR, "queryCreateTime", "seqId", BuildConfig.FLAVOR, "aiReplyId", BuildConfig.FLAVOR, "query", "Lcom/ss/android/lark/widget/richtext/RichText;", "content", "reference", "referenceList", "Ljava/util/ArrayList;", "Lcom/bytedance/lark/pb/basic/v1/CommonAIReply$ReferenceItem;", "Lkotlin/collections/ArrayList;", "textWithoutCitation", "source", "Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "triggerScene", "Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "<init>", "(JJILjava/lang/String;Lcom/ss/android/lark/widget/richtext/RichText;Lcom/ss/android/lark/widget/richtext/RichText;Lcom/ss/android/lark/widget/richtext/RichText;Ljava/util/ArrayList;Ljava/lang/String;Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;Lcom/bytedance/lark/pb/basic/v1/TriggerScene;)V", "getQueryId", "()J", "getQueryCreateTime", "getSeqId", "()I", "getAiReplyId", "()Ljava/lang/String;", "getQuery", "()Lcom/ss/android/lark/widget/richtext/RichText;", "getContent", "getReference", "getReferenceList", "()Ljava/util/ArrayList;", "getTextWithoutCitation", "getSource", "()Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "getTriggerScene", "()Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Over extends AtKnowledgeReplyQueryState {
        private final String aiReplyId;
        private final RichText content;
        private final RichText query;
        private final long queryCreateTime;
        private final long queryId;
        private final RichText reference;
        private final ArrayList<CommonAIReply.ReferenceItem> referenceList;
        private final int seqId;
        private final AtAIKnowledgeSourceClient source;
        private final String textWithoutCitation;
        private final TriggerScene triggerScene;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Over copy$default(Over r14, long r15, long r17, int r19, String r20, RichText r21, RichText r22, RichText r23, ArrayList r24, String r25, AtAIKnowledgeSourceClient r26, TriggerScene r27, int r28, Object r29) {
            if ((r28 & 1) == 0) goto L5;
            long r2 = r14.queryId;
        L7:
            if ((r28 & 2) == 0) goto L9;
            long r4 = r14.queryCreateTime;
        L11:
            if ((r28 & 4) == 0) goto L13;
            int r6 = r14.seqId;
        L15:
            if ((r28 & 8) == 0) goto L17;
            String r7 = r14.aiReplyId;
        L19:
            if ((r28 & 16) == 0) goto L21;
            RichText r8 = r14.query;
        L23:
            if ((r28 & 32) == 0) goto L25;
            RichText r9 = r14.content;
        L27:
            if ((r28 & 64) == 0) goto L29;
            RichText r10 = r14.reference;
        L31:
            if ((r28 & 128) == 0) goto L33;
            ArrayList r11 = r14.referenceList;
        L35:
            if ((r28 & 256) == 0) goto L37;
            String r12 = r14.textWithoutCitation;
        L39:
            if ((r28 & 512) == 0) goto L41;
            AtAIKnowledgeSourceClient r13 = r14.source;
        L43:
            if ((r28 & ChameleonContainerUtils.MAX_URL_LENGTH) == 0) goto L45;
            TriggerScene r1 = r14.triggerScene;
        L47:
            return r14.copy(r2, r4, r6, r7, r8, r9, r10, r11, r12, r13, r1);
        L45:
            r1 = r27;
            goto L47
        L41:
            r13 = r26;
            goto L43
        L37:
            r12 = r25;
            goto L39
        L33:
            r11 = r24;
            goto L35
        L29:
            r10 = r23;
            goto L31
        L25:
            r9 = r22;
            goto L27
        L21:
            r8 = r21;
            goto L23
        L17:
            r7 = r20;
            goto L19
        L13:
            r6 = r19;
            goto L15
        L9:
            r4 = r17;
            goto L11
        L5:
            r2 = r15;
            goto L7
        }

        public final long component1() {
            return this.queryId;
        }

        public final AtAIKnowledgeSourceClient component10() {
            return this.source;
        }

        public final TriggerScene component11() {
            return this.triggerScene;
        }

        public final long component2() {
            return this.queryCreateTime;
        }

        public final int component3() {
            return this.seqId;
        }

        public final String component4() {
            return this.aiReplyId;
        }

        public final RichText component5() {
            return this.query;
        }

        public final RichText component6() {
            return this.content;
        }

        public final RichText component7() {
            return this.reference;
        }

        public final ArrayList<CommonAIReply.ReferenceItem> component8() {
            return this.referenceList;
        }

        public final String component9() {
            return this.textWithoutCitation;
        }

        public final Over copy(long r16, long r18, int r20, String r21, RichText r22, RichText r23, RichText r24, ArrayList<CommonAIReply.ReferenceItem> r25, String r26, AtAIKnowledgeSourceClient r27, TriggerScene r28) {
            Intrinsics.checkNotNullParameter(r21, "aiReplyId");
            Intrinsics.checkNotNullParameter(r22, "query");
            Intrinsics.checkNotNullParameter(r23, "content");
            Intrinsics.checkNotNullParameter(r24, "reference");
            Intrinsics.checkNotNullParameter(r25, "referenceList");
            Intrinsics.checkNotNullParameter(r26, "textWithoutCitation");
            return new Over(r16, r18, r20, r21, r22, r23, r24, r25, r26, r27, r28);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Over) == true) goto L8;
            return false;
        L8:
            Over r9 = (Over) r8;
            if (this.queryId == r9.queryId) goto L12;
            return false;
        L12:
            if (this.queryCreateTime == r9.queryCreateTime) goto L15;
            return false;
        L15:
            if (this.seqId == r9.seqId) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.aiReplyId, r9.aiReplyId) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.query, r9.query) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.content, r9.content) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.reference, r9.reference) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.referenceList, r9.referenceList) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.textWithoutCitation, r9.textWithoutCitation) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.source, r9.source) == true) goto L39;
            return false;
        L39:
            if (this.triggerScene == r9.triggerScene) goto L41;
            return false;
        L41:
            return true;
        }

        public int hashCode() {
            long r0 = this.queryId;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.queryCreateTime;
            int r2 = (((((((((((((((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.seqId) * 31) + this.aiReplyId.hashCode()) * 31) + this.query.hashCode()) * 31) + this.content.hashCode()) * 31) + this.reference.hashCode()) * 31) + this.referenceList.hashCode()) * 31) + this.textWithoutCitation.hashCode()) * 31;
            AtAIKnowledgeSourceClient r4 = this.source;
            int r5 = 0;
            if (r4 != null) goto L5;
            int r6 = 0;
        L6:
            int r7 = (r2 + r6) * 31;
            TriggerScene r8 = this.triggerScene;
            if (r8 == null) goto L11;
            r5 = r8.hashCode();
        L11:
            return r7 + r5;
        L5:
            r6 = r4.hashCode();
            goto L6
        }

        public String toString() {
            return "Over(queryId=" + this.queryId + ", queryCreateTime=" + this.queryCreateTime + ", seqId=" + this.seqId + ", aiReplyId=" + this.aiReplyId + ", query=" + this.query + ", content=" + this.content + ", reference=" + this.reference + ", referenceList=" + this.referenceList + ", textWithoutCitation=" + this.textWithoutCitation + ", source=" + this.source + ", triggerScene=" + this.triggerScene + ')';
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public String getAiReplyId() {
            return this.aiReplyId;
        }

        public final RichText getContent() {
            return this.content;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public RichText getQuery() {
            return this.query;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryCreateTime() {
            return this.queryCreateTime;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryId() {
            return this.queryId;
        }

        public final RichText getReference() {
            return this.reference;
        }

        public final ArrayList<CommonAIReply.ReferenceItem> getReferenceList() {
            return this.referenceList;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public int getSeqId() {
            return this.seqId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public AtAIKnowledgeSourceClient getSource() {
            return this.source;
        }

        public final String getTextWithoutCitation() {
            return this.textWithoutCitation;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public TriggerScene getTriggerScene() {
            return this.triggerScene;
        }

        public Over(long r2, long r4, int r6, String r7, RichText r8, RichText r9, RichText r10, ArrayList<CommonAIReply.ReferenceItem> r11, String r12, AtAIKnowledgeSourceClient r13, TriggerScene r14) {
            Intrinsics.checkNotNullParameter(r7, "aiReplyId");
            Intrinsics.checkNotNullParameter(r8, "query");
            Intrinsics.checkNotNullParameter(r9, "content");
            Intrinsics.checkNotNullParameter(r10, "reference");
            Intrinsics.checkNotNullParameter(r11, "referenceList");
            Intrinsics.checkNotNullParameter(r12, "textWithoutCitation");
            super(null);
            this.queryId = r2;
            this.queryCreateTime = r4;
            this.seqId = r6;
            this.aiReplyId = r7;
            this.query = r8;
            this.content = r9;
            this.reference = r10;
            this.referenceList = r11;
            this.textWithoutCitation = r12;
            this.source = r13;
            this.triggerScene = r14;
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001Bk\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0016\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\t\u0010+\u001a\u00020\bHÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\t\u0010-\u001a\u00020\nHÆ\u0003J\t\u0010.\u001a\u00020\nHÆ\u0003J\u0019\u0010/\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0081\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\u0018\b\u0002\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u00020\u0006HÖ\u0001J\t\u00108\u001a\u00020\bHÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR!\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u00069"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState$Transmitting;", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;", "queryId", BuildConfig.FLAVOR, "queryCreateTime", "seqId", BuildConfig.FLAVOR, "aiReplyId", BuildConfig.FLAVOR, "query", "Lcom/ss/android/lark/widget/richtext/RichText;", "content", "reference", "referenceList", "Ljava/util/ArrayList;", "Lcom/bytedance/lark/pb/basic/v1/CommonAIReply$ReferenceItem;", "Lkotlin/collections/ArrayList;", "source", "Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "triggerScene", "Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "<init>", "(JJILjava/lang/String;Lcom/ss/android/lark/widget/richtext/RichText;Lcom/ss/android/lark/widget/richtext/RichText;Lcom/ss/android/lark/widget/richtext/RichText;Ljava/util/ArrayList;Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;Lcom/bytedance/lark/pb/basic/v1/TriggerScene;)V", "getQueryId", "()J", "getQueryCreateTime", "getSeqId", "()I", "getAiReplyId", "()Ljava/lang/String;", "getQuery", "()Lcom/ss/android/lark/widget/richtext/RichText;", "getContent", "getReference", "getReferenceList", "()Ljava/util/ArrayList;", "getSource", "()Lcom/ss/android/lark/chat/entity/message/content/AtAIKnowledgeSourceClient;", "getTriggerScene", "()Lcom/bytedance/lark/pb/basic/v1/TriggerScene;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Transmitting extends AtKnowledgeReplyQueryState {
        private final String aiReplyId;
        private final RichText content;
        private final RichText query;
        private final long queryCreateTime;
        private final long queryId;
        private final RichText reference;
        private final ArrayList<CommonAIReply.ReferenceItem> referenceList;
        private final int seqId;
        private final AtAIKnowledgeSourceClient source;
        private final TriggerScene triggerScene;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Transmitting copy$default(Transmitting r13, long r14, long r16, int r18, String r19, RichText r20, RichText r21, RichText r22, ArrayList r23, AtAIKnowledgeSourceClient r24, TriggerScene r25, int r26, Object r27) {
            if ((r26 & 1) == 0) goto L5;
            long r2 = r13.queryId;
        L7:
            if ((r26 & 2) == 0) goto L9;
            long r4 = r13.queryCreateTime;
        L11:
            if ((r26 & 4) == 0) goto L13;
            int r6 = r13.seqId;
        L15:
            if ((r26 & 8) == 0) goto L17;
            String r7 = r13.aiReplyId;
        L19:
            if ((r26 & 16) == 0) goto L21;
            RichText r8 = r13.query;
        L23:
            if ((r26 & 32) == 0) goto L25;
            RichText r9 = r13.content;
        L27:
            if ((r26 & 64) == 0) goto L29;
            RichText r10 = r13.reference;
        L31:
            if ((r26 & 128) == 0) goto L33;
            ArrayList r11 = r13.referenceList;
        L35:
            if ((r26 & 256) == 0) goto L37;
            AtAIKnowledgeSourceClient r12 = r13.source;
        L39:
            if ((r26 & 512) == 0) goto L41;
            TriggerScene r1 = r13.triggerScene;
        L43:
            return r13.copy(r2, r4, r6, r7, r8, r9, r10, r11, r12, r1);
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
            r8 = r20;
            goto L23
        L17:
            r7 = r19;
            goto L19
        L13:
            r6 = r18;
            goto L15
        L9:
            r4 = r16;
            goto L11
        L5:
            r2 = r14;
            goto L7
        }

        public final long component1() {
            return this.queryId;
        }

        public final TriggerScene component10() {
            return this.triggerScene;
        }

        public final long component2() {
            return this.queryCreateTime;
        }

        public final int component3() {
            return this.seqId;
        }

        public final String component4() {
            return this.aiReplyId;
        }

        public final RichText component5() {
            return this.query;
        }

        public final RichText component6() {
            return this.content;
        }

        public final RichText component7() {
            return this.reference;
        }

        public final ArrayList<CommonAIReply.ReferenceItem> component8() {
            return this.referenceList;
        }

        public final AtAIKnowledgeSourceClient component9() {
            return this.source;
        }

        public final Transmitting copy(long r15, long r17, int r19, String r20, RichText r21, RichText r22, RichText r23, ArrayList<CommonAIReply.ReferenceItem> r24, AtAIKnowledgeSourceClient r25, TriggerScene r26) {
            Intrinsics.checkNotNullParameter(r20, "aiReplyId");
            Intrinsics.checkNotNullParameter(r21, "query");
            Intrinsics.checkNotNullParameter(r22, "content");
            Intrinsics.checkNotNullParameter(r23, "reference");
            Intrinsics.checkNotNullParameter(r24, "referenceList");
            return new Transmitting(r15, r17, r19, r20, r21, r22, r23, r24, r25, r26);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof Transmitting) == true) goto L8;
            return false;
        L8:
            Transmitting r9 = (Transmitting) r8;
            if (this.queryId == r9.queryId) goto L12;
            return false;
        L12:
            if (this.queryCreateTime == r9.queryCreateTime) goto L15;
            return false;
        L15:
            if (this.seqId == r9.seqId) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.aiReplyId, r9.aiReplyId) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.query, r9.query) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.content, r9.content) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.reference, r9.reference) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.referenceList, r9.referenceList) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.source, r9.source) == true) goto L36;
            return false;
        L36:
            if (this.triggerScene == r9.triggerScene) goto L38;
            return false;
        L38:
            return true;
        }

        public int hashCode() {
            long r0 = this.queryId;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            long r3 = this.queryCreateTime;
            int r2 = (((((((((((((r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.seqId) * 31) + this.aiReplyId.hashCode()) * 31) + this.query.hashCode()) * 31) + this.content.hashCode()) * 31) + this.reference.hashCode()) * 31) + this.referenceList.hashCode()) * 31;
            AtAIKnowledgeSourceClient r4 = this.source;
            int r5 = 0;
            if (r4 != null) goto L5;
            int r6 = 0;
        L6:
            int r7 = (r2 + r6) * 31;
            TriggerScene r8 = this.triggerScene;
            if (r8 == null) goto L11;
            r5 = r8.hashCode();
        L11:
            return r7 + r5;
        L5:
            r6 = r4.hashCode();
            goto L6
        }

        public String toString() {
            return "Transmitting(queryId=" + this.queryId + ", queryCreateTime=" + this.queryCreateTime + ", seqId=" + this.seqId + ", aiReplyId=" + this.aiReplyId + ", query=" + this.query + ", content=" + this.content + ", reference=" + this.reference + ", referenceList=" + this.referenceList + ", source=" + this.source + ", triggerScene=" + this.triggerScene + ')';
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public String getAiReplyId() {
            return this.aiReplyId;
        }

        public final RichText getContent() {
            return this.content;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public RichText getQuery() {
            return this.query;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryCreateTime() {
            return this.queryCreateTime;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public long getQueryId() {
            return this.queryId;
        }

        public final RichText getReference() {
            return this.reference;
        }

        public final ArrayList<CommonAIReply.ReferenceItem> getReferenceList() {
            return this.referenceList;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public int getSeqId() {
            return this.seqId;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public AtAIKnowledgeSourceClient getSource() {
            return this.source;
        }

        @Override // com.ss.android.lark.chat.entity.message.content.AtKnowledgeReplyQueryState
        public TriggerScene getTriggerScene() {
            return this.triggerScene;
        }

        public Transmitting(long r2, long r4, int r6, String r7, RichText r8, RichText r9, RichText r10, ArrayList<CommonAIReply.ReferenceItem> r11, AtAIKnowledgeSourceClient r12, TriggerScene r13) {
            Intrinsics.checkNotNullParameter(r7, "aiReplyId");
            Intrinsics.checkNotNullParameter(r8, "query");
            Intrinsics.checkNotNullParameter(r9, "content");
            Intrinsics.checkNotNullParameter(r10, "reference");
            Intrinsics.checkNotNullParameter(r11, "referenceList");
            super(null);
            this.queryId = r2;
            this.queryCreateTime = r4;
            this.seqId = r6;
            this.aiReplyId = r7;
            this.query = r8;
            this.content = r9;
            this.reference = r10;
            this.referenceList = r11;
            this.source = r12;
            this.triggerScene = r13;
        }
    }

    private AtKnowledgeReplyQueryState() {
    }

    public /* synthetic */ AtKnowledgeReplyQueryState(DefaultConstructorMarker r1) {
        this();
    }

    public abstract /* synthetic */ String getAiReplyId();

    public abstract /* synthetic */ RichText getQuery();

    public abstract /* synthetic */ long getQueryCreateTime();

    public abstract /* synthetic */ long getQueryId();

    public abstract /* synthetic */ int getSeqId();

    public abstract /* synthetic */ AtAIKnowledgeSourceClient getSource();

    public abstract /* synthetic */ TriggerScene getTriggerScene();

    public final boolean isEndState() {
        if ((this instanceof Over) == false) goto L5;
    L10:
        return true;
    L5:
        if ((this instanceof Error) == true) goto L10;
        if ((this instanceof NoAnswer) == true) goto L10;
        return false;
    }

    public final boolean isTransmitting() {
        if ((this instanceof Transmitting) == false) goto L5;
    L8:
        return true;
    L5:
        if ((this instanceof Cot) == true) goto L8;
        return false;
    }

    public final boolean isClose() {
        return this instanceof Closed;
    }

    public final boolean isComplete() {
        return this instanceof Over;
    }
}
