package com.larus.platform.model.showcase;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0014"}, d2 = {"Lcom/larus/platform/model/showcase/CaseMessageDataRequest;", "", "caseId", "", "<init>", "(Ljava/lang/Long;)V", "getCaseId", "()Ljava/lang/Long;", "setCaseId", "Ljava/lang/Long;", "component1", "copy", "(Ljava/lang/Long;)Lcom/larus/platform/model/showcase/CaseMessageDataRequest;", "equals", "", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CaseMessageDataRequest {

    @SerializedName("case_id")
    private Long caseId;

    public CaseMessageDataRequest() {
        Long r0 = null;
        this(r0, 1, r0);
    }

    public static /* synthetic */ CaseMessageDataRequest copy$default(CaseMessageDataRequest r0, Long r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.caseId;
    L6:
        return r0.copy(r1);
    }

    public final Long component1() {
        return this.caseId;
    }

    public final CaseMessageDataRequest copy(Long r2) {
        return new CaseMessageDataRequest(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof CaseMessageDataRequest) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.caseId, ((CaseMessageDataRequest) r4).caseId) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Long r0 = this.caseId;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "CaseMessageDataRequest(caseId=" + this.caseId + ')';
    }

    public final Long getCaseId() {
        return this.caseId;
    }

    public CaseMessageDataRequest(Long r1) {
        this.caseId = r1;
    }

    public final void setCaseId(Long r1) {
        this.caseId = r1;
    }

    public /* synthetic */ CaseMessageDataRequest(Long r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0L;
    L5:
        this(r1);
    }
}
