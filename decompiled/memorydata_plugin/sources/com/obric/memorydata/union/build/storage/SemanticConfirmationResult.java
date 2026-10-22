package com.obric.memorydata.union.build.storage;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0011J:\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001e"}, d2 = {"Lcom/obric/memorydata/union/build/storage/SemanticConfirmationResult;", "", "success", "", "code", "", "entityId", "changeSeq", "", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getSuccess", "()Z", "getCode", "()Ljava/lang/String;", "getEntityId", "getChangeSeq", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "copy", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/obric/memorydata/union/build/storage/SemanticConfirmationResult;", "equals", "other", "hashCode", "", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SemanticConfirmationResult {

    @SerializedName("change_seq")
    private final Long changeSeq;
    private final String code;

    @SerializedName("entity_id")
    private final String entityId;
    private final boolean success;

    public SemanticConfirmationResult(boolean r2, String r3, String r4, Long r5) {
        Intrinsics.checkNotNullParameter(r3, "code");
        this.success = r2;
        this.code = r3;
        this.entityId = r4;
        this.changeSeq = r5;
    }

    public /* synthetic */ SemanticConfirmationResult(boolean r2, String r3, String r4, Long r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = null;
    L8:
        this(r2, r3, r4, r5);
    }

    public static /* synthetic */ SemanticConfirmationResult copy$default(SemanticConfirmationResult r0, boolean r1, String r2, String r3, Long r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.success;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.code;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.entityId;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.changeSeq;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final boolean component1() {
        return this.success;
    }

    public final String component2() {
        return this.code;
    }

    public final String component3() {
        return this.entityId;
    }

    public final Long component4() {
        return this.changeSeq;
    }

    public final SemanticConfirmationResult copy(boolean r1, String r2, String r3, Long r4) {
        Intrinsics.checkNotNullParameter(r2, "code");
        return new SemanticConfirmationResult(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SemanticConfirmationResult.class) == true) goto L8;
        return false;
    L8:
        SemanticConfirmationResult r6 = (SemanticConfirmationResult) ZeusTransformUtils.preCheckCast(r5, SemanticConfirmationResult.class, "com.obric.memorydata.plugin");
        if (this.success == r6.success) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.code, r6.code) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.entityId, r6.entityId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.changeSeq, r6.changeSeq) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final Long getChangeSeq() {
        return this.changeSeq;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        int r0 = ((Boolean.hashCode(this.success) * 31) + this.code.hashCode()) * 31;
        String r1 = this.entityId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        Long r5 = this.changeSeq;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        return "SemanticConfirmationResult(success=" + this.success + ", code=" + this.code + ", entityId=" + this.entityId + ", changeSeq=" + this.changeSeq + ')';
    }
}
