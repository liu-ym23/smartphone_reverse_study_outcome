package com.larus.bmhome.chat.detail.code.artifact.request;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\nJ\u0013\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J.\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/chat/detail/code/artifact/request/GetArtifactData;", "Ljava/io/Serializable;", "status", "", "nodes", "", "Lcom/larus/bmhome/chat/detail/code/artifact/request/CodeNodeContent;", "<init>", "(Ljava/lang/Integer;Ljava/util/List;)V", "getStatus", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNodes", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Integer;Ljava/util/List;)Lcom/larus/bmhome/chat/detail/code/artifact/request/GetArtifactData;", "equals", "", "other", "", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class GetArtifactData implements Serializable {

    @SerializedName("nodes")
    private final List<CodeNodeContent> nodes;

    @SerializedName("status")
    private final Integer status;

    /* JADX WARN: Multi-variable type inference failed */
    public GetArtifactData() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetArtifactData copy$default(GetArtifactData r0, Integer r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.status;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.nodes;
    L9:
        return r0.copy(r1, r2);
    }

    public final Integer component1() {
        return this.status;
    }

    public final List<CodeNodeContent> component2() {
        return this.nodes;
    }

    public final GetArtifactData copy(Integer r2, List<CodeNodeContent> r3) {
        return new GetArtifactData(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof GetArtifactData) == true) goto L8;
        return false;
    L8:
        GetArtifactData r6 = (GetArtifactData) r5;
        if (Intrinsics.areEqual(this.status, r6.status) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nodes, r6.nodes) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        Integer r0 = this.status;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<CodeNodeContent> r4 = this.nodes;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "GetArtifactData(status=" + this.status + ", nodes=" + this.nodes + ')';
    }

    public final List<CodeNodeContent> getNodes() {
        return this.nodes;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public GetArtifactData(Integer r1, List<CodeNodeContent> r2) {
        this.status = r1;
        this.nodes = r2;
    }

    public /* synthetic */ GetArtifactData(Integer r1, List r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = null;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = CollectionsKt.emptyList();
    L8:
        this(r1, r2);
    }
}
