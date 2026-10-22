package com.obric.memorydata.union.build.storage;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\tHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/union/build/storage/SemanticConsumerCommitResult;", "", "success", "", "code", "", "currentCursor", "", "appliedCount", "", "<init>", "(ZLjava/lang/String;JI)V", "getSuccess", "()Z", "getCode", "()Ljava/lang/String;", "getCurrentCursor", "()J", "getAppliedCount", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SemanticConsumerCommitResult {

    @SerializedName("applied_count")
    private final int appliedCount;
    private final String code;

    @SerializedName("current_cursor")
    private final long currentCursor;
    private final boolean success;

    public SemanticConsumerCommitResult(boolean r2, String r3, long r4, int r6) {
        Intrinsics.checkNotNullParameter(r3, "code");
        this.success = r2;
        this.code = r3;
        this.currentCursor = r4;
        this.appliedCount = r6;
    }

    public /* synthetic */ SemanticConsumerCommitResult(boolean r7, String r8, long r9, int r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 8) == 0) goto L5;
        r11 = 0;
    L5:
        this(r7, r8, r9, r11);
    }

    public static /* synthetic */ SemanticConsumerCommitResult copy$default(SemanticConsumerCommitResult r3, boolean r4, String r5, long r6, int r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.success;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.code;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.currentCursor;
    L11:
        long r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r8 = r3.appliedCount;
    L14:
        boolean r7 = r4;
        return r3.copy(r7, r11, r0, r8);
    }

    public final boolean component1() {
        return this.success;
    }

    public final String component2() {
        return this.code;
    }

    public final long component3() {
        return this.currentCursor;
    }

    public final int component4() {
        return this.appliedCount;
    }

    public final SemanticConsumerCommitResult copy(boolean r7, String r8, long r9, int r11) {
        Intrinsics.checkNotNullParameter(r8, "code");
        return new SemanticConsumerCommitResult(r7, r8, r9, r11);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, SemanticConsumerCommitResult.class) == true) goto L8;
        return false;
    L8:
        SemanticConsumerCommitResult r10 = (SemanticConsumerCommitResult) ZeusTransformUtils.preCheckCast(r9, SemanticConsumerCommitResult.class, "com.obric.memorydata.plugin");
        if (this.success == r10.success) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.code, r10.code) == true) goto L15;
        return false;
    L15:
        if (this.currentCursor == r10.currentCursor) goto L18;
        return false;
    L18:
        if (this.appliedCount == r10.appliedCount) goto L20;
        return false;
    L20:
        return true;
    }

    public final int getAppliedCount() {
        return this.appliedCount;
    }

    public final String getCode() {
        return this.code;
    }

    public final long getCurrentCursor() {
        return this.currentCursor;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.success) * 31) + this.code.hashCode()) * 31) + Long.hashCode(this.currentCursor)) * 31) + Integer.hashCode(this.appliedCount);
    }

    public String toString() {
        return "SemanticConsumerCommitResult(success=" + this.success + ", code=" + this.code + ", currentCursor=" + this.currentCursor + ", appliedCount=" + this.appliedCount + ')';
    }
}
