package com.obric.memorydata.database.legacy.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aikernel.sdk.ext.Params;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\t2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0005HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006!"}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/BlockMemoryContentEntityOld;", "", OaidModel.KEY_ID, "", Params.CONTENT, "", "createTime", "modifyTime", "personalDbSplitMigrated", "", "<init>", "(JLjava/lang/String;JJZ)V", "getId", "()J", "setId", "(J)V", "getContent", "()Ljava/lang/String;", "getCreateTime", "getModifyTime", "getPersonalDbSplitMigrated", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class BlockMemoryContentEntityOld {
    private final String content;
    private final long createTime;
    private long id;
    private final long modifyTime;
    private final boolean personalDbSplitMigrated;

    public BlockMemoryContentEntityOld(long r2, String r4, long r5, long r7, boolean r9) {
        Intrinsics.checkNotNullParameter(r4, Params.CONTENT);
        this.id = r2;
        this.content = r4;
        this.createTime = r5;
        this.modifyTime = r7;
        this.personalDbSplitMigrated = r9;
    }

    public /* synthetic */ BlockMemoryContentEntityOld(long r12, String r14, long r15, long r17, boolean r19, int r20, DefaultConstructorMarker r21) {
        if ((r20 & 1) == 0) goto L5;
        long r3 = 0;
    L7:
        if ((r20 & 16) == 0) goto L9;
        boolean r10 = false;
    L10:
        this(r3, r14, r15, r17, r10);
        return;
    L9:
        r10 = r19;
        goto L10
    L5:
        r3 = r12;
        goto L7
    }

    public static /* synthetic */ BlockMemoryContentEntityOld copy$default(BlockMemoryContentEntityOld r9, long r10, String r12, long r13, long r15, boolean r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        long r1 = r9.id;
    L7:
        if ((r18 & 2) == 0) goto L9;
        String r3 = r9.content;
    L11:
        if ((r18 & 4) == 0) goto L13;
        long r4 = r9.createTime;
    L15:
        if ((r18 & 8) == 0) goto L17;
        long r6 = r9.modifyTime;
    L19:
        if ((r18 & 16) == 0) goto L21;
        boolean r8 = r9.personalDbSplitMigrated;
    L23:
        return r9.copy(r1, r3, r4, r6, r8);
    L21:
        r8 = r17;
        goto L23
    L17:
        r6 = r15;
        goto L19
    L13:
        r4 = r13;
        goto L15
    L9:
        r3 = r12;
        goto L11
    L5:
        r1 = r10;
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

    public final boolean component5() {
        return this.personalDbSplitMigrated;
    }

    public final BlockMemoryContentEntityOld copy(long r11, String r13, long r14, long r16, boolean r18) {
        Intrinsics.checkNotNullParameter(r13, Params.CONTENT);
        return new BlockMemoryContentEntityOld(r11, r13, r14, r16, r18);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, BlockMemoryContentEntityOld.class) == true) goto L8;
        return false;
    L8:
        BlockMemoryContentEntityOld r10 = (BlockMemoryContentEntityOld) ZeusTransformUtils.preCheckCast(r9, BlockMemoryContentEntityOld.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r10.content) == true) goto L15;
        return false;
    L15:
        if (this.createTime == r10.createTime) goto L18;
        return false;
    L18:
        if (this.modifyTime == r10.modifyTime) goto L21;
        return false;
    L21:
        if (this.personalDbSplitMigrated == r10.personalDbSplitMigrated) goto L23;
        return false;
    L23:
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

    public final boolean getPersonalDbSplitMigrated() {
        return this.personalDbSplitMigrated;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.id) * 31) + this.content.hashCode()) * 31) + Long.hashCode(this.createTime)) * 31) + Long.hashCode(this.modifyTime)) * 31) + Boolean.hashCode(this.personalDbSplitMigrated);
    }

    public final void setId(long r1) {
        this.id = r1;
    }

    public String toString() {
        return "BlockMemoryContentEntityOld(id=" + this.id + ", content=" + this.content + ", createTime=" + this.createTime + ", modifyTime=" + this.modifyTime + ", personalDbSplitMigrated=" + this.personalDbSplitMigrated + ')';
    }
}
