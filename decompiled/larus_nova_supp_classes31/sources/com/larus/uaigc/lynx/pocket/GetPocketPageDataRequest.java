package com.larus.uaigc.lynx.pocket;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/larus/uaigc/lynx/pocket/GetPocketPageDataRequest;", "", "hasReplica", "", "source", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;)V", "getHasReplica", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSource", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/String;)Lcom/larus/uaigc/lynx/pocket/GetPocketPageDataRequest;", "equals", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class GetPocketPageDataRequest {

    @SerializedName("has_replica")
    private final Boolean hasReplica;

    @SerializedName("source")
    private final String source;

    /* JADX WARN: Multi-variable type inference failed */
    public GetPocketPageDataRequest() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ GetPocketPageDataRequest copy$default(GetPocketPageDataRequest r0, Boolean r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.hasReplica;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.source;
    L9:
        return r0.copy(r1, r2);
    }

    public final Boolean component1() {
        return this.hasReplica;
    }

    public final String component2() {
        return this.source;
    }

    public final GetPocketPageDataRequest copy(Boolean r2, String r3) {
        return new GetPocketPageDataRequest(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GetPocketPageDataRequest) == true) goto L8;
        return false;
    L8:
        GetPocketPageDataRequest r6 = (GetPocketPageDataRequest) r5;
        if (Intrinsics.areEqual(this.hasReplica, r6.hasReplica) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.source, r6.source) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.hasReplica;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.source;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "GetPocketPageDataRequest(hasReplica=" + this.hasReplica + ", source=" + this.source + ')';
    }

    public final Boolean getHasReplica() {
        return this.hasReplica;
    }

    public final String getSource() {
        return this.source;
    }

    public GetPocketPageDataRequest(Boolean r1, String r2) {
        this.hasReplica = r1;
        this.source = r2;
    }

    public /* synthetic */ GetPocketPageDataRequest(Boolean r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
