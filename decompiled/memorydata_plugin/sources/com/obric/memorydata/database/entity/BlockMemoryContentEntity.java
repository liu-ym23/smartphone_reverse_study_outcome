package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/database/entity/BlockMemoryContentEntity;", "", OaidModel.KEY_ID, "", Params.CONTENT, "", "createTime", "modifyTime", "<init>", "(JLjava/lang/String;JJ)V", "getId", "()J", "setId", "(J)V", "getContent", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BlockMemoryContentEntity {
    private final String content;
    private final long createTime;
    private long id;
    private final long modifyTime;

    public BlockMemoryContentEntity(long r2, String r4, long r5, long r7) {
        Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
        this.id = r2;
        this.content = r4;
        this.createTime = r5;
        this.modifyTime = r7;
    }

    public /* synthetic */ BlockMemoryContentEntity(long r11, String r13, long r14, long r16, int r18, DefaultConstructorMarker r19) {
        if ((r18 & 1) == 0) goto L5;
        long r3 = 0;
    L6:
        this(r3, r13, r14, r16);
        return;
    L5:
        r3 = r11;
        goto L6
    }

    public static /* synthetic */ BlockMemoryContentEntity copy$default(BlockMemoryContentEntity r8, long r9, String r11, long r12, long r14, int r16, Object r17) {
        if ((r16 & 1) == 0) goto L5;
        long r1 = r8.id;
    L7:
        if ((r16 & 2) == 0) goto L9;
        String r3 = r8.content;
    L11:
        if ((r16 & 4) == 0) goto L13;
        long r4 = r8.createTime;
    L15:
        if ((r16 & 8) == 0) goto L17;
        long r6 = r8.modifyTime;
    L19:
        return r8.copy(r1, r3, r4, r6);
    L17:
        r6 = r14;
        goto L19
    L13:
        r4 = r12;
        goto L15
    L9:
        r3 = r11;
        goto L11
    L5:
        r1 = r9;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.content;
    }

    public final long component3() {
        return this.createTime;
    }

    public final long component4() {
        return this.modifyTime;
    }

    public final BlockMemoryContentEntity copy(long r9, String r11, long r12, long r14) {
        Intrinsics.checkNotNullParameter(r11, Params.CONTENT);
        return new BlockMemoryContentEntity(r9, r11, r12, r14);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, BlockMemoryContentEntity.class) == true) goto L8;
        return false;
    L8:
        BlockMemoryContentEntity r10 = (BlockMemoryContentEntity) ZeusTransformUtils.preCheckCast(r9, BlockMemoryContentEntity.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r10.content) == true) goto L15;
        return false;
    L15:
        if (this.createTime == r10.createTime) goto L18;
        return false;
    L18:
        if (this.modifyTime == r10.modifyTime) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final long getId() {
        return this.id;
    }

    public final long getModifyTime() {
        return this.modifyTime;
    }

    public int hashCode() {
        return (((((Long.hashCode(this.id) * 31) + this.content.hashCode()) * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.modifyTime);
    }

    public final void setId(long r1) {
        this.id = r1;
    }

    public String toString() {
        return "BlockMemoryContentEntity(id=" + this.id + ", content=" + this.content + ", createTime=" + this.createTime + ", modifyTime=" + this.modifyTime + ')';
    }
}
