package com.ss.android.lark.intent.export.entity.output;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.intent.export.entity.output.common.CommonSuccessAsyncIntentOutput;
import com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import knb.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/QueryKnowledgeAIIntentOutput;", "", "<init>", "()V", "QueryKnowledgeAIIntentSyncOutput", "QueryKnowledgeAIIntentAsyncOutput", "Reference", "OpenUrlLinkOutput", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class QueryKnowledgeAIIntentOutput {
    public static final QueryKnowledgeAIIntentOutput INSTANCE = null;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u0003H\u0016J\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/QueryKnowledgeAIIntentOutput$OpenUrlLinkOutput;", "Lcom/ss/android/lark/intent/export/entity/output/common/CommonSuccessIntentOutput;", "url", "", "display", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getDisplay", "toString", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class OpenUrlLinkOutput extends CommonSuccessIntentOutput {
        public static final Parcelable.Creator<OpenUrlLinkOutput> CREATOR = null;
        private final String display;
        private final String url;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
        public static final class Creator implements Parcelable.Creator<OpenUrlLinkOutput> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final OpenUrlLinkOutput createFromParcel(Parcel r3) {
                Intrinsics.checkNotNullParameter(r3, "parcel");
                return new OpenUrlLinkOutput(r3.readString(), r3.readString());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ OpenUrlLinkOutput createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final OpenUrlLinkOutput[] newArray(int r1) {
                return new OpenUrlLinkOutput[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ OpenUrlLinkOutput[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = new Creator();
        }

        @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dest");
            r1.writeString(this.url);
            r1.writeString(this.display);
        }

        public String toString() {
            return "OpenUrlLinkOutput(url='" + a.a(this.url) + "')";
        }

        public final String getDisplay() {
            return this.display;
        }

        public final String getUrl() {
            return this.url;
        }

        public OpenUrlLinkOutput(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "url");
            super(Direction.WEB_URL, r3);
            this.url = r2;
            this.display = r3;
        }

        public /* synthetic */ OpenUrlLinkOutput(String r1, String r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001BI\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/QueryKnowledgeAIIntentOutput$QueryKnowledgeAIIntentAsyncOutput;", "Lcom/ss/android/lark/intent/export/entity/output/common/CommonSuccessAsyncIntentOutput;", "topicId", "", "markdown", "appLink", "references", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/intent/export/entity/output/QueryKnowledgeAIIntentOutput$Reference;", "Lkotlin/collections/ArrayList;", "display", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "getTopicId", "()Ljava/lang/String;", "getMarkdown", "getAppLink", "getReferences", "()Ljava/util/ArrayList;", "getDisplay", "toString", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class QueryKnowledgeAIIntentAsyncOutput extends CommonSuccessAsyncIntentOutput {
        public static final Parcelable.Creator<QueryKnowledgeAIIntentAsyncOutput> CREATOR = null;
        private final String appLink;
        private final String display;
        private final String markdown;
        private final ArrayList<Reference> references;
        private final String topicId;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
        public static final class Creator implements Parcelable.Creator<QueryKnowledgeAIIntentAsyncOutput> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final QueryKnowledgeAIIntentAsyncOutput createFromParcel(Parcel r8) {
                Intrinsics.checkNotNullParameter(r8, "parcel");
                String r2 = r8.readString();
                String r3 = r8.readString();
                String r4 = r8.readString();
                int r0 = r8.readInt();
                ArrayList r5 = new ArrayList(r0);
                int r1 = 0;
            L3:
                if (r1 == r0) goto L6;
                r5.add(Reference.CREATOR.createFromParcel(r8));
                r1 = r1 + 1;
                goto L3
            L6:
                return new QueryKnowledgeAIIntentAsyncOutput(r2, r3, r4, r5, r8.readString());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ QueryKnowledgeAIIntentAsyncOutput createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final QueryKnowledgeAIIntentAsyncOutput[] newArray(int r1) {
                return new QueryKnowledgeAIIntentAsyncOutput[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ QueryKnowledgeAIIntentAsyncOutput[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = new Creator();
        }

        @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessAsyncIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessAsyncIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
        public final void writeToParcel(Parcel r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "dest");
            r3.writeString(this.topicId);
            r3.writeString(this.markdown);
            r3.writeString(this.appLink);
            ArrayList<Reference> r0 = this.references;
            r3.writeInt(r0.size());
            Iterator<Reference> r1 = r0.iterator();
        L4:
            if (r1.hasNext() == false) goto L6;
            r1.next().writeToParcel(r3, r4);
            goto L4
        L6:
            r3.writeString(this.display);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("QueryKnowledgeAIIntentAsyncOutput(topicId='");
            r0.append(this.topicId);
            r0.append("', markdown=");
            String r1 = this.markdown;
            if (r1 == null) goto L5;
            String r2 = a.a(r1);
        L6:
            r0.append(r2);
            r0.append(", appLink='");
            r0.append(this.appLink);
            r0.append("', references=");
            r0.append(this.references);
            r0.append(')');
            return r0.toString();
        L5:
            r2 = null;
            goto L6
        }

        public final String getAppLink() {
            return this.appLink;
        }

        public final String getDisplay() {
            return this.display;
        }

        public final String getMarkdown() {
            return this.markdown;
        }

        public final ArrayList<Reference> getReferences() {
            return this.references;
        }

        public final String getTopicId() {
            return this.topicId;
        }

        public QueryKnowledgeAIIntentAsyncOutput(String r2, String r3, String r4, ArrayList<Reference> r5, String r6) {
            Intrinsics.checkNotNullParameter(r5, "references");
            super(Direction.QUERY_KNOWLEDGE_AI_ASYNC, r6);
            this.topicId = r2;
            this.markdown = r3;
            this.appLink = r4;
            this.references = r5;
            this.display = r6;
        }

        public /* synthetic */ QueryKnowledgeAIIntentAsyncOutput(String r7, String r8, String r9, ArrayList r10, String r11, int r12, DefaultConstructorMarker r13) {
            if ((r12 & 16) == 0) goto L5;
            r11 = null;
        L5:
            this(r7, r8, r9, r10, r11);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/QueryKnowledgeAIIntentOutput$QueryKnowledgeAIIntentSyncOutput;", "Lcom/ss/android/lark/intent/export/entity/output/common/CommonSuccessIntentOutput;", "topicId", "", "display", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTopicId", "()Ljava/lang/String;", "getDisplay", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class QueryKnowledgeAIIntentSyncOutput extends CommonSuccessIntentOutput {
        public static final Parcelable.Creator<QueryKnowledgeAIIntentSyncOutput> CREATOR = null;
        private final String display;
        private final String topicId;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
        public static final class Creator implements Parcelable.Creator<QueryKnowledgeAIIntentSyncOutput> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final QueryKnowledgeAIIntentSyncOutput createFromParcel(Parcel r3) {
                Intrinsics.checkNotNullParameter(r3, "parcel");
                return new QueryKnowledgeAIIntentSyncOutput(r3.readString(), r3.readString());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ QueryKnowledgeAIIntentSyncOutput createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final QueryKnowledgeAIIntentSyncOutput[] newArray(int r1) {
                return new QueryKnowledgeAIIntentSyncOutput[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ QueryKnowledgeAIIntentSyncOutput[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = new Creator();
        }

        @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // com.ss.android.lark.intent.export.entity.output.common.CommonSuccessIntentOutput, com.ss.android.lark.intent.export.entity.output.IntentOutput, android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dest");
            r1.writeString(this.topicId);
            r1.writeString(this.display);
        }

        public final String getDisplay() {
            return this.display;
        }

        public final String getTopicId() {
            return this.topicId;
        }

        public QueryKnowledgeAIIntentSyncOutput(String r2, String r3) {
            super(Direction.QUERY_KNOWLEDGE_AI_SYNC, r3);
            this.topicId = r2;
            this.display = r3;
        }

        public /* synthetic */ QueryKnowledgeAIIntentSyncOutput(String r1, String r2, int r3, DefaultConstructorMarker r4) {
            if ((r3 & 2) == 0) goto L5;
            r2 = null;
        L5:
            this(r1, r2);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0010R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/intent/export/entity/output/QueryKnowledgeAIIntentOutput$Reference;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "title", "", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getUrl", "toString", "component1", "component2", "copy", "describeContents", "", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "intent-export_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class Reference implements Parcelable, Serializable {
        public static final Parcelable.Creator<Reference> CREATOR = null;
        private final String title;
        private final String url;

        @Metadata(k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
        public static final class Creator implements Parcelable.Creator<Reference> {
            public Creator() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Reference createFromParcel(Parcel r3) {
                Intrinsics.checkNotNullParameter(r3, "parcel");
                return new Reference(r3.readString(), r3.readString());
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Reference createFromParcel(Parcel r1) {
                return createFromParcel(r1);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final Reference[] newArray(int r1) {
                return new Reference[r1];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Reference[] newArray(int r1) {
                return newArray(r1);
            }
        }

        static {
            CREATOR = new Creator();
        }

        public static /* synthetic */ Reference copy$default(Reference r0, String r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.title;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.url;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.title;
        }

        public final String component2() {
            return this.url;
        }

        public final Reference copy(String r2, String r3) {
            return new Reference(r2, r3);
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Reference) == true) goto L8;
            return false;
        L8:
            Reference r6 = (Reference) r5;
            if (Intrinsics.areEqual(this.title, r6.title) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.url, r6.url) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r0 = this.title;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.url;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel r1, int r2) {
            Intrinsics.checkNotNullParameter(r1, "dest");
            r1.writeString(this.title);
            r1.writeString(this.url);
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("Reference(title=");
            String r1 = this.title;
            String r2 = null;
            if (r1 == null) goto L5;
            String r3 = a.a(r1);
        L6:
            r0.append(r3);
            r0.append(", url=");
            String r4 = this.url;
            if (r4 == null) goto L9;
            r2 = a.a(r4);
        L9:
            r0.append(r2);
            r0.append(')');
            return r0.toString();
        L5:
            r3 = null;
            goto L6
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getUrl() {
            return this.url;
        }

        public Reference(String r1, String r2) {
            this.title = r1;
            this.url = r2;
        }
    }

    static {
        INSTANCE = new QueryKnowledgeAIIntentOutput();
    }

    private QueryKnowledgeAIIntentOutput() {
    }
}
