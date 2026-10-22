package com.obric.memorydata.union.build;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/union/build/UnionUserPersonaData;", "", "summary", "", "description", "createTime", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getSummary", "()Ljava/lang/String;", "getDescription", "getCreateTime", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnionUserPersonaData {
    private final int createTime;
    private final String description;
    private final String summary;

    public UnionUserPersonaData(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "summary");
        Intrinsics.checkNotNullParameter(r3, "description");
        this.summary = r2;
        this.description = r3;
        this.createTime = r4;
    }

    public static /* synthetic */ UnionUserPersonaData copy$default(UnionUserPersonaData r0, String r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.summary;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.description;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.createTime;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.summary;
    }

    public final String component2() {
        return this.description;
    }

    public final int component3() {
        return this.createTime;
    }

    public final UnionUserPersonaData copy(String r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "summary");
        Intrinsics.checkNotNullParameter(r2, "description");
        return new UnionUserPersonaData(r1, r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, UnionUserPersonaData.class) == true) goto L8;
        return false;
    L8:
        UnionUserPersonaData r6 = (UnionUserPersonaData) ZeusTransformUtils.preCheckCast(r5, UnionUserPersonaData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.summary, r6.summary) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L15;
        return false;
    L15:
        if (this.createTime == r6.createTime) goto L17;
        return false;
    L17:
        return true;
    }

    public final int getCreateTime() {
        return this.createTime;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getSummary() {
        return this.summary;
    }

    public int hashCode() {
        return (((this.summary.hashCode() * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.createTime);
    }

    public String toString() {
        return "UnionUserPersonaData(summary=" + this.summary + ", description=" + this.description + ", createTime=" + this.createTime + ')';
    }
}
