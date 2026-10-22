package com.obric.memorydata.sdk.entity.search;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.entity.meta.MetaValue;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BE\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0006HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011¨\u0006!"}, d2 = {"Lcom/obric/memorydata/sdk/entity/search/QueryParam;", "", "query", "", "Lcom/obric/memorydata/sdk/entity/search/SLMQuery;", MemorySourceLinkType.INTENT, "", "referenceAppEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "referenceMetaValue", "Lcom/obric/capabilitykit/entity/meta/MetaValue;", "queryId", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getQuery", "()Ljava/util/List;", "getIntent", "()Ljava/lang/String;", "getReferenceAppEntity", "getReferenceMetaValue", "getQueryId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class QueryParam {

    @SerializedName("Intent")
    private final String intent;

    @SerializedName("Query")
    private final List<SLMQuery> query;

    @SerializedName("QueryId")
    private final String queryId;

    @SerializedName("ReferenceAppEntity")
    private final List<AppEntity> referenceAppEntity;

    @SerializedName("ReferenceMetaValue")
    private final List<MetaValue> referenceMetaValue;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ QueryParam copy$default(QueryParam r3, List r4, String r5, List r6, List r7, String r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.query;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.intent;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.referenceAppEntity;
    L11:
        List r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.referenceMetaValue;
    L14:
        List r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.queryId;
    L17:
        List r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final List<SLMQuery> component1() {
        return this.query;
    }

    public final String component2() {
        return this.intent;
    }

    public final List<AppEntity> component3() {
        return this.referenceAppEntity;
    }

    public final List<MetaValue> component4() {
        return this.referenceMetaValue;
    }

    public final String component5() {
        return this.queryId;
    }

    public final QueryParam copy(List<SLMQuery> r8, String r9, List<? extends AppEntity> r10, List<? extends MetaValue> r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "query");
        Intrinsics.checkNotNullParameter(r10, "referenceAppEntity");
        Intrinsics.checkNotNullParameter(r11, "referenceMetaValue");
        Intrinsics.checkNotNullParameter(r12, "queryId");
        return new QueryParam(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof QueryParam) == true) goto L8;
        return false;
    L8:
        QueryParam r6 = (QueryParam) r5;
        if (Intrinsics.areEqual(this.query, r6.query) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.intent, r6.intent) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.referenceAppEntity, r6.referenceAppEntity) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.referenceMetaValue, r6.referenceMetaValue) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.queryId, r6.queryId) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = this.query.hashCode() * 31;
        String r1 = this.intent;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((r0 + r2) * 31) + this.referenceAppEntity.hashCode()) * 31) + this.referenceMetaValue.hashCode()) * 31) + this.queryId.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "QueryParam(query=" + this.query + ", intent=" + this.intent + ", referenceAppEntity=" + this.referenceAppEntity + ", referenceMetaValue=" + this.referenceMetaValue + ", queryId=" + this.queryId + ')';
    }

    public final String getIntent() {
        return this.intent;
    }

    public final List<SLMQuery> getQuery() {
        return this.query;
    }

    public final String getQueryId() {
        return this.queryId;
    }

    public final List<AppEntity> getReferenceAppEntity() {
        return this.referenceAppEntity;
    }

    public final List<MetaValue> getReferenceMetaValue() {
        return this.referenceMetaValue;
    }

    public QueryParam(List<SLMQuery> r2, String r3, List<? extends AppEntity> r4, List<? extends MetaValue> r5, String r6) {
        Intrinsics.checkNotNullParameter(r2, "query");
        Intrinsics.checkNotNullParameter(r4, "referenceAppEntity");
        Intrinsics.checkNotNullParameter(r5, "referenceMetaValue");
        Intrinsics.checkNotNullParameter(r6, "queryId");
        this.query = r2;
        this.intent = r3;
        this.referenceAppEntity = r4;
        this.referenceMetaValue = r5;
        this.queryId = r6;
    }

    public /* synthetic */ QueryParam(List r7, String r8, List r9, List r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = "";
    L5:
        this(r7, r8, r9, r10, r11);
    }
}
