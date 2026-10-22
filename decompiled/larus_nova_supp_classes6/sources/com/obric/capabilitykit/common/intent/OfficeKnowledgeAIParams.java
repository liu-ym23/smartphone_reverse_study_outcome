package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\u0012\u0010\u0017\u001a\u00020\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0015H\u0016J\t\u0010\u0019\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/obric/capabilitykit/common/intent/OfficeKnowledgeAIParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "query", "", "topicId", "(Ljava/lang/String;Ljava/lang/String;)V", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "getTopicId", "setTopicId", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class OfficeKnowledgeAIParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<OfficeKnowledgeAIParams> CREATOR = null;
    private String query;
    private String topicId;

    static {
        CREATOR = new a();
    }

    public OfficeKnowledgeAIParams() {
        String r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ OfficeKnowledgeAIParams copy$default(OfficeKnowledgeAIParams r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.query;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.topicId;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.query;
    }

    public final String component2() {
        return this.topicId;
    }

    public final OfficeKnowledgeAIParams copy(String r2, String r3) {
        return new OfficeKnowledgeAIParams(r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof OfficeKnowledgeAIParams) == true) goto L8;
        return false;
    L8:
        OfficeKnowledgeAIParams r6 = (OfficeKnowledgeAIParams) r5;
        if (Intrinsics.areEqual(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.topicId, r6.topicId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r0 = this.query;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.topicId;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "OfficeKnowledgeAIParams(query=" + this.query + ", topicId=" + this.topicId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(0);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.query);
        r1.writeString(this.topicId);
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getTopicId() {
        return this.topicId;
    }

    public IntentParams mergeParams(Object r3) {
        if ((r3 instanceof OfficeKnowledgeAIParams) == true) goto L5;
        return this;
    L5:
        String r0 = this.query;
        if (r0 != null) goto L8;
        r0 = ((OfficeKnowledgeAIParams) r3).query;
    L8:
        String r1 = this.topicId;
        if (r1 != null) goto L12;
        r1 = ((OfficeKnowledgeAIParams) r3).topicId;
    L12:
        return new OfficeKnowledgeAIParams(r0, r1);
    }

    public final void setQuery(String r1) {
        this.query = r1;
    }

    public final void setTopicId(String r1) {
        this.topicId = r1;
    }

    public OfficeKnowledgeAIParams(String r1, String r2) {
        this.query = r1;
        this.topicId = r2;
    }

    public /* synthetic */ OfficeKnowledgeAIParams(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
