package com.obric.memorydata.database.legacy.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "需要迁移到personal数据库")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001a\b\u0081\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\bHÖ\u0001J\t\u0010%\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/UnionSemanticMemorySnapShotEntityOld;", "", OaidModel.KEY_ID, "", "unionSemanticMemoryId", "entityId", "", "version", "", "snapshotJson", "snapshotTime", "personalDbSplitMigrated", "", "<init>", "(JJLjava/lang/String;ILjava/lang/String;JZ)V", "getId", "()J", "getUnionSemanticMemoryId", "getEntityId", "()Ljava/lang/String;", "getVersion", "()I", "getSnapshotJson", "getSnapshotTime", "getPersonalDbSplitMigrated", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnionSemanticMemorySnapShotEntityOld {
    private final String entityId;
    private final long id;
    private final boolean personalDbSplitMigrated;
    private final String snapshotJson;
    private final long snapshotTime;
    private final long unionSemanticMemoryId;
    private final int version;

    public UnionSemanticMemorySnapShotEntityOld(long r2, long r4, String r6, int r7, String r8, long r9, boolean r11) {
        Intrinsics.checkNotNullParameter(r6, "entityId");
        Intrinsics.checkNotNullParameter(r8, "snapshotJson");
        this.id = r2;
        this.unionSemanticMemoryId = r4;
        this.entityId = r6;
        this.version = r7;
        this.snapshotJson = r8;
        this.snapshotTime = r9;
        this.personalDbSplitMigrated = r11;
    }

    public /* synthetic */ UnionSemanticMemorySnapShotEntityOld(long r14, long r16, String r18, int r19, String r20, long r21, boolean r23, int r24, DefaultConstructorMarker r25) {
        if ((r24 & 1) == 0) goto L5;
        long r3 = 0;
    L7:
        if ((r24 & 64) == 0) goto L9;
        boolean r12 = false;
    L10:
        this(r3, r16, r18, r19, r20, r21, r12);
        return;
    L9:
        r12 = r23;
        goto L10
    L5:
        r3 = r14;
        goto L7
    }

    public static /* synthetic */ UnionSemanticMemorySnapShotEntityOld copy$default(UnionSemanticMemorySnapShotEntityOld r11, long r12, long r14, String r16, int r17, String r18, long r19, boolean r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        long r1 = r11.id;
    L7:
        if ((r22 & 2) == 0) goto L9;
        long r3 = r11.unionSemanticMemoryId;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r5 = r11.entityId;
    L15:
        if ((r22 & 8) == 0) goto L17;
        int r6 = r11.version;
    L19:
        if ((r22 & 16) == 0) goto L21;
        String r7 = r11.snapshotJson;
    L23:
        if ((r22 & 32) == 0) goto L25;
        long r8 = r11.snapshotTime;
    L27:
        if ((r22 & 64) == 0) goto L29;
        boolean r10 = r11.personalDbSplitMigrated;
    L31:
        return r11.copy(r1, r3, r5, r6, r7, r8, r10);
    L29:
        r10 = r21;
        goto L31
    L25:
        r8 = r19;
        goto L27
    L21:
        r7 = r18;
        goto L23
    L17:
        r6 = r17;
        goto L19
    L13:
        r5 = r16;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final long component2() {
        return this.unionSemanticMemoryId;
    }

    public final String component3() {
        return this.entityId;
    }

    public final int component4() {
        return this.version;
    }

    public final String component5() {
        return this.snapshotJson;
    }

    public final long component6() {
        return this.snapshotTime;
    }

    public final boolean component7() {
        return this.personalDbSplitMigrated;
    }

    public final UnionSemanticMemorySnapShotEntityOld copy(long r13, long r15, String r17, int r18, String r19, long r20, boolean r22) {
        Intrinsics.checkNotNullParameter(r17, "entityId");
        Intrinsics.checkNotNullParameter(r19, "snapshotJson");
        return new UnionSemanticMemorySnapShotEntityOld(r13, r15, r17, r18, r19, r20, r22);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, UnionSemanticMemorySnapShotEntityOld.class) == true) goto L8;
        return false;
    L8:
        UnionSemanticMemorySnapShotEntityOld r10 = (UnionSemanticMemorySnapShotEntityOld) ZeusTransformUtils.preCheckCast(r9, UnionSemanticMemorySnapShotEntityOld.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (this.unionSemanticMemoryId == r10.unionSemanticMemoryId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.entityId, r10.entityId) == true) goto L18;
        return false;
    L18:
        if (this.version == r10.version) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.snapshotJson, r10.snapshotJson) == true) goto L24;
        return false;
    L24:
        if (this.snapshotTime == r10.snapshotTime) goto L27;
        return false;
    L27:
        if (this.personalDbSplitMigrated == r10.personalDbSplitMigrated) goto L29;
        return false;
    L29:
        return true;
    }

    public final String getEntityId() {
        return this.entityId;
    }

    public final long getId() {
        return this.id;
    }

    public final boolean getPersonalDbSplitMigrated() {
        return this.personalDbSplitMigrated;
    }

    public final String getSnapshotJson() {
        return this.snapshotJson;
    }

    public final long getSnapshotTime() {
        return this.snapshotTime;
    }

    public final long getUnionSemanticMemoryId() {
        return this.unionSemanticMemoryId;
    }

    public final int getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.unionSemanticMemoryId)) * 31) + this.entityId.hashCode()) * 31) + Integer.hashCode(this.version)) * 31) + this.snapshotJson.hashCode()) * 31) + Long.hashCode(this.snapshotTime)) * 31) + Boolean.hashCode(this.personalDbSplitMigrated);
    }

    public String toString() {
        return "UnionSemanticMemorySnapShotEntityOld(id=" + this.id + ", unionSemanticMemoryId=" + this.unionSemanticMemoryId + ", entityId=" + this.entityId + ", version=" + this.version + ", snapshotJson=" + this.snapshotJson + ", snapshotTime=" + this.snapshotTime + ", personalDbSplitMigrated=" + this.personalDbSplitMigrated + ')';
    }
}
