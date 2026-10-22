package com.obric.assistant.cocreationreview;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/cocreationreview/CocreationMemoryTraceReportRequest;", NameKeys.UnloadStrategy_No_Strategy, "uniqId", NameKeys.UnloadStrategy_No_Strategy, "logId", "extra", "Lcom/google/gson/JsonObject;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/google/gson/JsonObject;)V", "getUniqId", "()Ljava/lang/String;", "getLogId", "getExtra", "()Lcom/google/gson/JsonObject;", "component1", "component2", "component3", "copy", "equals", NameKeys.UnloadStrategy_No_Strategy, "other", "hashCode", NameKeys.UnloadStrategy_No_Strategy, "toString", "cocreationreview_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CocreationMemoryTraceReportRequest {

    @SerializedName("extra")
    private final JsonObject extra;

    @SerializedName("log_id")
    private final String logId;

    @SerializedName("uniq_id")
    private final String uniqId;

    public CocreationMemoryTraceReportRequest() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CocreationMemoryTraceReportRequest copy$default(CocreationMemoryTraceReportRequest r0, String r1, String r2, JsonObject r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.uniqId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.logId;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.extra;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.uniqId;
    }

    public final String component2() {
        return this.logId;
    }

    public final JsonObject component3() {
        return this.extra;
    }

    public final CocreationMemoryTraceReportRequest copy(String r2, String r3, JsonObject r4) {
        return new CocreationMemoryTraceReportRequest(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CocreationMemoryTraceReportRequest) == true) goto L8;
        return false;
    L8:
        CocreationMemoryTraceReportRequest r6 = (CocreationMemoryTraceReportRequest) r5;
        if (Intrinsics.areEqual(this.uniqId, r6.uniqId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.logId, r6.logId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.extra, r6.extra) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.uniqId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.logId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        JsonObject r7 = this.extra;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "CocreationMemoryTraceReportRequest(uniqId=" + this.uniqId + ", logId=" + this.logId + ", extra=" + this.extra + ')';
    }

    public final JsonObject getExtra() {
        return this.extra;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getUniqId() {
        return this.uniqId;
    }

    public CocreationMemoryTraceReportRequest(String r1, String r2, JsonObject r3) {
        this.uniqId = r1;
        this.logId = r2;
        this.extra = r3;
    }

    public /* synthetic */ CocreationMemoryTraceReportRequest(String r2, String r3, JsonObject r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
