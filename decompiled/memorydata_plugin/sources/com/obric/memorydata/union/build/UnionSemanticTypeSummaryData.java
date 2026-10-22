package com.obric.memorydata.union.build;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\bHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013¨\u0006#"}, d2 = {"Lcom/obric/memorydata/union/build/UnionSemanticTypeSummaryData;", "", "type", "", "treePath", "summary", "description", CommonConsts.COUNT_TYPE, "", "createTime", "modifyTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V", "getType", "()Ljava/lang/String;", "getTreePath", "getSummary", "getDescription", "getCount", "()I", "getCreateTime", "getModifyTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "memory_build_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnionSemanticTypeSummaryData {
    private final int count;
    private final int createTime;
    private final String description;
    private final int modifyTime;
    private final String summary;
    private final String treePath;
    private final String type;

    public UnionSemanticTypeSummaryData(String r2, String r3, String r4, String r5, int r6, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r2, "type");
        Intrinsics.checkNotNullParameter(r3, "treePath");
        Intrinsics.checkNotNullParameter(r4, "summary");
        Intrinsics.checkNotNullParameter(r5, "description");
        this.type = r2;
        this.treePath = r3;
        this.summary = r4;
        this.description = r5;
        this.count = r6;
        this.createTime = r7;
        this.modifyTime = r8;
    }

    public static /* synthetic */ UnionSemanticTypeSummaryData copy$default(UnionSemanticTypeSummaryData r5, String r6, String r7, String r8, String r9, int r10, int r11, int r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r6 = r5.type;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r7 = r5.treePath;
    L8:
        String r15 = r7;
        if ((r13 & 4) == 0) goto L11;
        r8 = r5.summary;
    L11:
        String r0 = r8;
        if ((r13 & 8) == 0) goto L14;
        r9 = r5.description;
    L14:
        String r1 = r9;
        if ((r13 & 16) == 0) goto L17;
        r10 = r5.count;
    L17:
        int r2 = r10;
        if ((r13 & 32) == 0) goto L20;
        r11 = r5.createTime;
    L20:
        int r3 = r11;
        if ((r13 & 64) == 0) goto L23;
        r12 = r5.modifyTime;
    L23:
        String r16 = r6;
        return r5.copy(r16, r15, r0, r1, r2, r3, r12);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.treePath;
    }

    public final String component3() {
        return this.summary;
    }

    public final String component4() {
        return this.description;
    }

    public final int component5() {
        return this.count;
    }

    public final int component6() {
        return this.createTime;
    }

    public final int component7() {
        return this.modifyTime;
    }

    public final UnionSemanticTypeSummaryData copy(String r9, String r10, String r11, String r12, int r13, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r9, "type");
        Intrinsics.checkNotNullParameter(r10, "treePath");
        Intrinsics.checkNotNullParameter(r11, "summary");
        Intrinsics.checkNotNullParameter(r12, "description");
        return new UnionSemanticTypeSummaryData(r9, r10, r11, r12, r13, r14, r15);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, UnionSemanticTypeSummaryData.class) == true) goto L8;
        return false;
    L8:
        UnionSemanticTypeSummaryData r6 = (UnionSemanticTypeSummaryData) ZeusTransformUtils.preCheckCast(r5, UnionSemanticTypeSummaryData.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.treePath, r6.treePath) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.summary, r6.summary) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.description, r6.description) == true) goto L21;
        return false;
    L21:
        if (this.count == r6.count) goto L24;
        return false;
    L24:
        if (this.createTime == r6.createTime) goto L27;
        return false;
    L27:
        if (this.modifyTime == r6.modifyTime) goto L29;
        return false;
    L29:
        return true;
    }

    public final int getCount() {
        return this.count;
    }

    public final int getCreateTime() {
        return this.createTime;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getModifyTime() {
        return this.modifyTime;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getTreePath() {
        return this.treePath;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((this.type.hashCode() * 31) + this.treePath.hashCode()) * 31) + this.summary.hashCode()) * 31) + this.description.hashCode()) * 31) + Integer.hashCode(this.count)) * 31) + Integer.hashCode(this.createTime)) * 31) + Integer.hashCode(this.modifyTime);
    }

    public String toString() {
        return "UnionSemanticTypeSummaryData(type=" + this.type + ", treePath=" + this.treePath + ", summary=" + this.summary + ", description=" + this.description + ", count=" + this.count + ", createTime=" + this.createTime + ", modifyTime=" + this.modifyTime + ')';
    }
}
