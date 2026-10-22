package com.ss.android.lark.inline.ai.api.knowledgeai;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0004\u000e\u000f\u0010\u0011B\u001d\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u0096\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f\u0082\u0001\u0004\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage;", "T", "Ljava/io/Serializable;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIMessage;", "type", "", "data", "<init>", "(Ljava/lang/String;Ljava/io/Serializable;)V", "getType", "()Ljava/lang/String;", "getData", "()Ljava/io/Serializable;", "Ljava/io/Serializable;", "OpenUrlMessage", "InsertToDocsMessage", "ClosePanelMessage", "OpenPanelMessage", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage$ClosePanelMessage;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage$InsertToDocsMessage;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage$OpenPanelMessage;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage$OpenUrlMessage;", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public abstract class KnowledgeAIMessage<T extends Serializable> implements Serializable, IKnowledgeAIMessage<T> {
    private final T data;
    private final String type;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0002HÖ\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage$ClosePanelMessage;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage;", "", "data", "<init>", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "component1", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class ClosePanelMessage extends KnowledgeAIMessage<String> {
        private final String data;

        public ClosePanelMessage() {
            String r0 = null;
            this(r0, 1, r0);
        }

        public static /* synthetic */ ClosePanelMessage copy$default(ClosePanelMessage r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.data;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.data;
        }

        public final ClosePanelMessage copy(String r2) {
            return new ClosePanelMessage(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof ClosePanelMessage) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.data, ((ClosePanelMessage) r4).data) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            String r0 = this.data;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "ClosePanelMessage(data=" + this.data + ')';
        }

        @Override // com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIMessage, com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
        public /* bridge */ /* synthetic */ Serializable getData() {
            return getData();
        }

        @Override // com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIMessage, com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
        public String getData() {
            return this.data;
        }

        public ClosePanelMessage(String r3) {
            super("closePanel", r3, null);
            this.data = r3;
        }

        public /* synthetic */ ClosePanelMessage(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage$InsertToDocsMessage;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage;", "", "data", "<init>", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "component1", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class InsertToDocsMessage extends KnowledgeAIMessage<String> {
        private final String data;

        public static /* synthetic */ InsertToDocsMessage copy$default(InsertToDocsMessage r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.data;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.data;
        }

        public final InsertToDocsMessage copy(String r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            return new InsertToDocsMessage(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof InsertToDocsMessage) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.data, ((InsertToDocsMessage) r4).data) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "InsertToDocsMessage(data=" + this.data + ')';
        }

        @Override // com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIMessage, com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
        public /* bridge */ /* synthetic */ Serializable getData() {
            return getData();
        }

        @Override // com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIMessage, com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
        public String getData() {
            return this.data;
        }

        public InsertToDocsMessage(String r3) {
            Intrinsics.checkNotNullParameter(r3, "data");
            super("insertToDocs", r3, null);
            this.data = r3;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0002HÖ\u0001R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage$OpenPanelMessage;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage;", "", "data", "<init>", "(Ljava/lang/String;)V", "getData", "()Ljava/lang/String;", "component1", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class OpenPanelMessage extends KnowledgeAIMessage<String> {
        private final String data;

        public OpenPanelMessage() {
            String r0 = null;
            this(r0, 1, r0);
        }

        public static /* synthetic */ OpenPanelMessage copy$default(OpenPanelMessage r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.data;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.data;
        }

        public final OpenPanelMessage copy(String r2) {
            return new OpenPanelMessage(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof OpenPanelMessage) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.data, ((OpenPanelMessage) r4).data) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            String r0 = this.data;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "OpenPanelMessage(data=" + this.data + ')';
        }

        @Override // com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIMessage, com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
        public /* bridge */ /* synthetic */ Serializable getData() {
            return getData();
        }

        @Override // com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIMessage, com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
        public String getData() {
            return this.data;
        }

        public OpenPanelMessage(String r3) {
            super("openPanel", r3, null);
            this.data = r3;
        }

        public /* synthetic */ OpenPanelMessage(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage$OpenUrlMessage;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIMessage;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/UrlData;", "data", "<init>", "(Lcom/ss/android/lark/inline/ai/api/knowledgeai/UrlData;)V", "getData", "()Lcom/ss/android/lark/inline/ai/api/knowledgeai/UrlData;", "component1", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "toString", "", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class OpenUrlMessage extends KnowledgeAIMessage<UrlData> {
        private final UrlData data;

        public static /* synthetic */ OpenUrlMessage copy$default(OpenUrlMessage r0, UrlData r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.data;
        L6:
            return r0.copy(r1);
        }

        public final UrlData component1() {
            return this.data;
        }

        public final OpenUrlMessage copy(UrlData r2) {
            Intrinsics.checkNotNullParameter(r2, "data");
            return new OpenUrlMessage(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof OpenUrlMessage) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.data, ((OpenUrlMessage) r4).data) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.data.hashCode();
        }

        public String toString() {
            return "OpenUrlMessage(data=" + this.data + ')';
        }

        @Override // com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIMessage, com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
        public /* bridge */ /* synthetic */ Serializable getData() {
            return getData();
        }

        @Override // com.ss.android.lark.inline.ai.api.knowledgeai.KnowledgeAIMessage, com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
        public UrlData getData() {
            return this.data;
        }

        public OpenUrlMessage(UrlData r3) {
            Intrinsics.checkNotNullParameter(r3, "data");
            super("openUrl", r3, null);
            this.data = r3;
        }
    }

    public KnowledgeAIMessage() {
        throw null;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
    public T getData() {
        return this.data;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIMessage
    public String getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public KnowledgeAIMessage(String r1, Serializable r2, DefaultConstructorMarker r3) {
        this.type = r1;
        this.data = r2;
    }

    public /* synthetic */ KnowledgeAIMessage(String r1, Serializable r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, null);
    }
}
