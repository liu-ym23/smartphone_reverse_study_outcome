package com.larus.doc.api.data;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\bHÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\bHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/doc/api/data/ListResponse;", "Ljava/io/Serializable;", "documents", "", "Lcom/larus/doc/api/data/Document;", "hasMore", "", "nextCursor", "", "<init>", "(Ljava/util/List;ZLjava/lang/String;)V", "getDocuments", "()Ljava/util/List;", "getHasMore", "()Z", "getNextCursor", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ListResponse implements Serializable {

    @SerializedName("node_info_list")
    private final List<Document> documents;

    @SerializedName("has_more")
    private final boolean hasMore;

    @SerializedName("next_cursor")
    private final String nextCursor;

    public ListResponse() {
        this(null, false, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ListResponse copy$default(ListResponse r0, List r1, boolean r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.documents;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.hasMore;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.nextCursor;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final List<Document> component1() {
        return this.documents;
    }

    public final boolean component2() {
        return this.hasMore;
    }

    public final String component3() {
        return this.nextCursor;
    }

    public final ListResponse copy(List<Document> r2, boolean r3, String r4) {
        return new ListResponse(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ListResponse) == true) goto L8;
        return false;
    L8:
        ListResponse r6 = (ListResponse) r5;
        if (Intrinsics.areEqual(this.documents, r6.documents) == true) goto L12;
        return false;
    L12:
        if (this.hasMore == r6.hasMore) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nextCursor, r6.nextCursor) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        List<Document> r0 = this.documents;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        if (this.hasMore == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (r3 + r4) * 31;
        String r6 = this.nextCursor;
        if (r6 == null) goto L15;
        r1 = r6.hashCode();
    L15:
        return r5 + r1;
    L9:
        r4 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "ListResponse(documents=" + this.documents + ", hasMore=" + this.hasMore + ", nextCursor=" + this.nextCursor + ')';
    }

    public final List<Document> getDocuments() {
        return this.documents;
    }

    public final boolean getHasMore() {
        return this.hasMore;
    }

    public final String getNextCursor() {
        return this.nextCursor;
    }

    public ListResponse(List<Document> r1, boolean r2, String r3) {
        this.documents = r1;
        this.hasMore = r2;
        this.nextCursor = r3;
    }

    public /* synthetic */ ListResponse(List r1, boolean r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = false;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = "";
    L11:
        this(r1, r2, r3);
    }
}
