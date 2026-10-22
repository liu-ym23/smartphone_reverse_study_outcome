package com.ss.android.lark.chat.entity.message.content;

import com.ss.android.lark.widget.richtext.RichText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0000\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState;", "Ljava/io/Serializable;", "<init>", "()V", "differ", BuildConfig.FLAVOR, "other", "WaitSdkResponse", "WaitServerResponse", "Reply", "Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState$Reply;", "Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState$WaitSdkResponse;", "Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState$WaitServerResponse;", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class UnreadAIReplyQueryState implements Serializable {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState$Reply;", "Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState;", "reply", "Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;", "<init>", "(Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;)V", "getReply", "()Lcom/ss/android/lark/chat/entity/message/content/AtKnowledgeReplyQueryState;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Reply extends UnreadAIReplyQueryState {
        private final AtKnowledgeReplyQueryState reply;

        public static /* synthetic */ Reply copy$default(Reply r0, AtKnowledgeReplyQueryState r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.reply;
        L6:
            return r0.copy(r1);
        }

        public final AtKnowledgeReplyQueryState component1() {
            return this.reply;
        }

        public final Reply copy(AtKnowledgeReplyQueryState r2) {
            Intrinsics.checkNotNullParameter(r2, "reply");
            return new Reply(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof Reply) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.reply, ((Reply) r4).reply) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.reply.hashCode();
        }

        public String toString() {
            return "Reply(reply=" + this.reply + ')';
        }

        public final AtKnowledgeReplyQueryState getReply() {
            return this.reply;
        }

        public Reply(AtKnowledgeReplyQueryState r2) {
            Intrinsics.checkNotNullParameter(r2, "reply");
            super(null);
            this.reply = r2;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState$WaitSdkResponse;", "Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState;", "queryId", BuildConfig.FLAVOR, "<init>", "(J)V", "getQueryId", "()J", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WaitSdkResponse extends UnreadAIReplyQueryState {
        private final long queryId;

        public static /* synthetic */ WaitSdkResponse copy$default(WaitSdkResponse r0, long r1, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.queryId;
        L6:
            return r0.copy(r1);
        }

        public final long component1() {
            return this.queryId;
        }

        public final WaitSdkResponse copy(long r2) {
            return new WaitSdkResponse(r2);
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof WaitSdkResponse) == true) goto L9;
            return false;
        L9:
            if (this.queryId == ((WaitSdkResponse) r8).queryId) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            long r0 = this.queryId;
            return (int) (r0 ^ (r0 >>> 32));
        }

        public String toString() {
            return "WaitSdkResponse(queryId=" + this.queryId + ')';
        }

        public final long getQueryId() {
            return this.queryId;
        }

        public WaitSdkResponse(long r2) {
            super(null);
            this.queryId = r2;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState$WaitServerResponse;", "Lcom/ss/android/lark/chat/entity/message/content/UnreadAIReplyQueryState;", "query", "Lcom/ss/android/lark/widget/richtext/RichText;", "<init>", "(Lcom/ss/android/lark/widget/richtext/RichText;)V", "getQuery", "()Lcom/ss/android/lark/widget/richtext/RichText;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WaitServerResponse extends UnreadAIReplyQueryState {
        private final RichText query;

        public static /* synthetic */ WaitServerResponse copy$default(WaitServerResponse r0, RichText r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.query;
        L6:
            return r0.copy(r1);
        }

        public final RichText component1() {
            return this.query;
        }

        public final WaitServerResponse copy(RichText r2) {
            Intrinsics.checkNotNullParameter(r2, "query");
            return new WaitServerResponse(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof WaitServerResponse) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.query, ((WaitServerResponse) r4).query) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.query.hashCode();
        }

        public String toString() {
            return "WaitServerResponse(query=" + this.query + ')';
        }

        public final RichText getQuery() {
            return this.query;
        }

        public WaitServerResponse(RichText r2) {
            Intrinsics.checkNotNullParameter(r2, "query");
            super(null);
            this.query = r2;
        }
    }

    private UnreadAIReplyQueryState() {
    }

    public /* synthetic */ UnreadAIReplyQueryState(DefaultConstructorMarker r1) {
        this();
    }

    public final boolean differ(UnreadAIReplyQueryState r9) {
        Intrinsics.checkNotNullParameter(r9, "other");
        if (Intrinsics.areEqual(this, r9) == false) goto L6;
        return true;
    L6:
        if ((this instanceof WaitServerResponse) == false) goto L13;
        if ((r9 instanceof WaitServerResponse) == false) goto L13;
        if (Intrinsics.areEqual(((WaitServerResponse) this).getQuery(), ((WaitServerResponse) r9).getQuery()) == false) goto L13;
        return true;
    L13:
        if ((this instanceof WaitSdkResponse) == false) goto L20;
        if ((r9 instanceof WaitSdkResponse) == false) goto L20;
        if (((WaitSdkResponse) this).getQueryId() != ((WaitSdkResponse) r9).getQueryId()) goto L20;
        return true;
    L20:
        if ((this instanceof Reply) == true) goto L22;
    L42:
        return false;
    L22:
        if ((r9 instanceof Reply) == false) goto L42;
        AtKnowledgeReplyQueryState r1 = ((Reply) this).getReply();
        AtKnowledgeReplyQueryState r10 = ((Reply) r9).getReply();
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r10, "other");
        if (Intrinsics.areEqual(r1, r10) == false) goto L27;
        return true;
    L27:
        if (r1.getQueryId() == r10.getQueryId()) goto L30;
    L28:
        return false;
    L30:
        if (r1.getSeqId() != r10.getSeqId()) goto L28;
        if (r1.getQueryCreateTime() != r10.getQueryCreateTime()) goto L28;
        if (Intrinsics.areEqual(r1.getSource(), r10.getSource()) == false) goto L28;
        if (r1.getTriggerScene() != r10.getTriggerScene()) goto L28;
        return true;
    }
}
