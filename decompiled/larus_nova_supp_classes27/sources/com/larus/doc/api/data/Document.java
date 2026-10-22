package com.larus.doc.api.data;

import com.google.gson.annotations.SerializedName;
import e39.a;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/larus/doc/api/data/Document;", "Ljava/io/Serializable;", "resourceId", "", "title", "updateTime", "", "nodeInfo", "Lcom/larus/doc/api/data/NodeInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLcom/larus/doc/api/data/NodeInfo;)V", "getResourceId", "()Ljava/lang/String;", "getTitle", "getUpdateTime", "()J", "getNodeInfo", "()Lcom/larus/doc/api/data/NodeInfo;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Document implements Serializable {

    @SerializedName("content")
    private final a nodeInfo;

    @SerializedName("key")
    private final String resourceId;

    @SerializedName("name")
    private final String title;

    @SerializedName("update_time")
    private final long updateTime;

    public Document() {
        this(null, null, 0, null, 15, null);
    }

    public static /* synthetic */ Document copy$default(Document r3, String r4, String r5, long r6, a r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.resourceId;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.title;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.updateTime;
    L11:
        long r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r8 = r3.nodeInfo;
    L14:
        String r7 = r4;
        return r3.copy(r7, r11, r0, r8);
    }

    public final String component1() {
        return this.resourceId;
    }

    public final String component2() {
        return this.title;
    }

    public final long component3() {
        return this.updateTime;
    }

    public final a component4() {
        return this.nodeInfo;
    }

    public final Document copy(String r8, String r9, long r10, a r12) {
        return new Document(r8, r9, r10, r12);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof Document) == true) goto L8;
        return false;
    L8:
        Document r9 = (Document) r8;
        if (Intrinsics.areEqual(this.resourceId, r9.resourceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r9.title) == true) goto L15;
        return false;
    L15:
        if (this.updateTime == r9.updateTime) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.nodeInfo, r9.nodeInfo) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.resourceId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.title;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        long r7 = this.updateTime;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        a r9 = this.nodeInfo;
        if (r9 == null) goto L15;
        r1 = r9.hashCode();
    L15:
        return r8 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "Document(resourceId=" + this.resourceId + ", title=" + this.title + ", updateTime=" + this.updateTime + ", nodeInfo=" + this.nodeInfo + ')';
    }

    public final a getNodeInfo() {
        return this.nodeInfo;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public Document(String r1, String r2, long r3, a r5) {
        this.resourceId = r1;
        this.title = r2;
        this.updateTime = r3;
        this.nodeInfo = r5;
    }

    public /* synthetic */ Document(String r5, String r6, long r7, a r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        r7 = 0;
    L13:
        long r2 = r7;
        if ((r10 & 8) == 0) goto L16;
        a r13 = null;
    L17:
        this(r12, r1, r2, r13);
        return;
    L16:
        r13 = r9;
        goto L17
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
