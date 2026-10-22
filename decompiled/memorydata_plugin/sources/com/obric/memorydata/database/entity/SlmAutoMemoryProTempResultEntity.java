package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\tHÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000fR\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006%"}, d2 = {"Lcom/obric/memorydata/database/entity/SlmAutoMemoryProTempResultEntity;", "", OaidModel.KEY_ID, "", "batchId", "", "ruleId", "appPackages", "enableIndex", "", "timeStamp", "data", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;)V", "getId", "()J", "getBatchId", "()Ljava/lang/String;", "getRuleId", "getAppPackages", "getEnableIndex", "()I", "getTimeStamp", "getData", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SlmAutoMemoryProTempResultEntity {
    private final String appPackages;
    private final String batchId;
    private final String data;
    private final int enableIndex;
    private final long id;
    private final String ruleId;
    private final long timeStamp;

    public SlmAutoMemoryProTempResultEntity() {
        this(0, null, null, null, 0, 0, null, 127, null);
    }

    public SlmAutoMemoryProTempResultEntity(long r2, String r4, String r5, String r6, int r7, long r8, String r10) {
        Intrinsics.checkNotNullParameter(r4, "batchId");
        Intrinsics.checkNotNullParameter(r5, "ruleId");
        Intrinsics.checkNotNullParameter(r6, "appPackages");
        Intrinsics.checkNotNullParameter(r10, "data");
        this.id = r2;
        this.batchId = r4;
        this.ruleId = r5;
        this.appPackages = r6;
        this.enableIndex = r7;
        this.timeStamp = r8;
        this.data = r10;
    }

    public /* synthetic */ SlmAutoMemoryProTempResultEntity(long r4, String r6, String r7, String r8, int r9, long r10, String r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 1) == 0) goto L6;
        r4 = 0;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r6 = "";
    L9:
        if ((r13 & 4) == 0) goto L12;
        r7 = "";
    L12:
        if ((r13 & 8) == 0) goto L15;
        r8 = "";
    L15:
        if ((r13 & 16) == 0) goto L18;
        r9 = 0;
    L18:
        if ((r13 & 32) == 0) goto L21;
        r10 = 0;
    L21:
        if ((r13 & 64) == 0) goto L23;
        r12 = "";
    L23:
        this(r4, r6, r7, r8, r9, r10, r12);
    }

    public static /* synthetic */ SlmAutoMemoryProTempResultEntity copy$default(SlmAutoMemoryProTempResultEntity r10, long r11, String r13, String r14, String r15, int r16, long r17, String r19, int r20, Object r21) {
        if ((r20 & 1) == 0) goto L5;
        long r1 = r10.id;
    L7:
        if ((r20 & 2) == 0) goto L9;
        String r3 = r10.batchId;
    L11:
        if ((r20 & 4) == 0) goto L13;
        String r4 = r10.ruleId;
    L15:
        if ((r20 & 8) == 0) goto L17;
        String r5 = r10.appPackages;
    L19:
        if ((r20 & 16) == 0) goto L21;
        int r6 = r10.enableIndex;
    L23:
        if ((r20 & 32) == 0) goto L25;
        long r7 = r10.timeStamp;
    L27:
        if ((r20 & 64) == 0) goto L29;
        String r9 = r10.data;
    L31:
        return r10.copy(r1, r3, r4, r5, r6, r7, r9);
    L29:
        r9 = r19;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r1 = r11;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component2() {
        return this.batchId;
    }

    public final String component3() {
        return this.ruleId;
    }

    public final String component4() {
        return this.appPackages;
    }

    public final int component5() {
        return this.enableIndex;
    }

    public final long component6() {
        return this.timeStamp;
    }

    public final String component7() {
        return this.data;
    }

    public final SlmAutoMemoryProTempResultEntity copy(long r12, String r14, String r15, String r16, int r17, long r18, String r20) {
        Intrinsics.checkNotNullParameter(r14, "batchId");
        Intrinsics.checkNotNullParameter(r15, "ruleId");
        Intrinsics.checkNotNullParameter(r16, "appPackages");
        Intrinsics.checkNotNullParameter(r20, "data");
        return new SlmAutoMemoryProTempResultEntity(r12, r14, r15, r16, r17, r18, r20);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, SlmAutoMemoryProTempResultEntity.class) == true) goto L8;
        return false;
    L8:
        SlmAutoMemoryProTempResultEntity r10 = (SlmAutoMemoryProTempResultEntity) ZeusTransformUtils.preCheckCast(r9, SlmAutoMemoryProTempResultEntity.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.batchId, r10.batchId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.ruleId, r10.ruleId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appPackages, r10.appPackages) == true) goto L21;
        return false;
    L21:
        if (this.enableIndex == r10.enableIndex) goto L24;
        return false;
    L24:
        if (this.timeStamp == r10.timeStamp) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.data, r10.data) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final String getAppPackages() {
        return this.appPackages;
    }

    public final String getBatchId() {
        return this.batchId;
    }

    public final String getData() {
        return this.data;
    }

    public final int getEnableIndex() {
        return this.enableIndex;
    }

    public final long getId() {
        return this.id;
    }

    public final String getRuleId() {
        return this.ruleId;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.id) * 31) + this.batchId.hashCode()) * 31) + this.ruleId.hashCode()) * 31) + this.appPackages.hashCode()) * 31) + Integer.hashCode(this.enableIndex)) * 31) + Long.hashCode(this.timeStamp)) * 31) + this.data.hashCode();
    }

    public String toString() {
        return "SlmAutoMemoryProTempResultEntity(id=" + this.id + ", batchId=" + this.batchId + ", ruleId=" + this.ruleId + ", appPackages=" + this.appPackages + ", enableIndex=" + this.enableIndex + ", timeStamp=" + this.timeStamp + ", data=" + this.data + ')';
    }
}
