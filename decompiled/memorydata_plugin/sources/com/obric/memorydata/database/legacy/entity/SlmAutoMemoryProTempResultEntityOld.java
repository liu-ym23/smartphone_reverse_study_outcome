package com.obric.memorydata.database.legacy.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001c\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\tHÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\rHÆ\u0003JY\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010%\u001a\u00020\r2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020\tHÖ\u0001J\t\u0010(\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/SlmAutoMemoryProTempResultEntityOld;", "", OaidModel.KEY_ID, "", "batchId", "", "ruleId", "appPackages", "enableIndex", "", "timeStamp", "data", "personalDbSplitMigrated", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IJLjava/lang/String;Z)V", "getId", "()J", "getBatchId", "()Ljava/lang/String;", "getRuleId", "getAppPackages", "getEnableIndex", "()I", "getTimeStamp", "getData", "getPersonalDbSplitMigrated", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SlmAutoMemoryProTempResultEntityOld {
    private final String appPackages;
    private final String batchId;
    private final String data;
    private final int enableIndex;
    private final long id;
    private final boolean personalDbSplitMigrated;
    private final String ruleId;
    private final long timeStamp;

    public SlmAutoMemoryProTempResultEntityOld() {
        this(0, null, null, null, 0, 0, null, false, 255, null);
    }

    public SlmAutoMemoryProTempResultEntityOld(long r2, String r4, String r5, String r6, int r7, long r8, String r10, boolean r11) {
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
        this.personalDbSplitMigrated = r11;
    }

    public /* synthetic */ SlmAutoMemoryProTempResultEntityOld(long r13, String r15, String r16, String r17, int r18, long r19, String r21, boolean r22, int r23, DefaultConstructorMarker r24) {
        long r2 = 0;
        if ((r23 & 1) == 0) goto L5;
        long r4 = 0;
    L6:
        String r6 = "";
        if ((r23 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r23 & 4) == 0) goto L13;
        String r7 = "";
    L15:
        if ((r23 & 8) == 0) goto L17;
        String r8 = "";
    L18:
        boolean r10 = false;
        if ((r23 & 16) == 0) goto L21;
        int r9 = 0;
    L23:
        if ((r23 & 32) != 0) goto L27;
        r2 = r19;
    L27:
        if ((r23 & 64) != 0) goto L31;
        r6 = r21;
    L31:
        if ((r23 & 128) != 0) goto L34;
        r10 = r22;
    L34:
        this(r4, r1, r7, r8, r9, r2, r6, r10);
        return;
    L21:
        r9 = r18;
        goto L23
    L17:
        r8 = r17;
        goto L18
    L13:
        r7 = r16;
        goto L15
    L9:
        r1 = r15;
        goto L11
    L5:
        r4 = r13;
        goto L6
    }

    public static /* synthetic */ SlmAutoMemoryProTempResultEntityOld copy$default(SlmAutoMemoryProTempResultEntityOld r11, long r12, String r14, String r15, String r16, int r17, long r18, String r20, boolean r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        long r2 = r11.id;
    L7:
        if ((r22 & 2) == 0) goto L9;
        String r4 = r11.batchId;
    L11:
        if ((r22 & 4) == 0) goto L13;
        String r5 = r11.ruleId;
    L15:
        if ((r22 & 8) == 0) goto L17;
        String r6 = r11.appPackages;
    L19:
        if ((r22 & 16) == 0) goto L21;
        int r7 = r11.enableIndex;
    L23:
        if ((r22 & 32) == 0) goto L25;
        long r8 = r11.timeStamp;
    L27:
        if ((r22 & 64) == 0) goto L29;
        String r10 = r11.data;
    L31:
        if ((r22 & 128) == 0) goto L33;
        boolean r1 = r11.personalDbSplitMigrated;
    L35:
        return r11.copy(r2, r4, r5, r6, r7, r8, r10, r1);
    L33:
        r1 = r21;
        goto L35
    L29:
        r10 = r20;
        goto L31
    L25:
        r8 = r18;
        goto L27
    L21:
        r7 = r17;
        goto L23
    L17:
        r6 = r16;
        goto L19
    L13:
        r5 = r15;
        goto L15
    L9:
        r4 = r14;
        goto L11
    L5:
        r2 = r12;
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

    public final boolean component8() {
        return this.personalDbSplitMigrated;
    }

    public final SlmAutoMemoryProTempResultEntityOld copy(long r13, String r15, String r16, String r17, int r18, long r19, String r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r15, "batchId");
        Intrinsics.checkNotNullParameter(r16, "ruleId");
        Intrinsics.checkNotNullParameter(r17, "appPackages");
        Intrinsics.checkNotNullParameter(r21, "data");
        return new SlmAutoMemoryProTempResultEntityOld(r13, r15, r16, r17, r18, r19, r21, r22);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, SlmAutoMemoryProTempResultEntityOld.class) == true) goto L8;
        return false;
    L8:
        SlmAutoMemoryProTempResultEntityOld r10 = (SlmAutoMemoryProTempResultEntityOld) ZeusTransformUtils.preCheckCast(r9, SlmAutoMemoryProTempResultEntityOld.class, "com.obric.memorydata.plugin");
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
        if (Intrinsics.areEqual(this.data, r10.data) == true) goto L30;
        return false;
    L30:
        if (this.personalDbSplitMigrated == r10.personalDbSplitMigrated) goto L32;
        return false;
    L32:
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

    public final boolean getPersonalDbSplitMigrated() {
        return this.personalDbSplitMigrated;
    }

    public final String getRuleId() {
        return this.ruleId;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public int hashCode() {
        return (((((((((((((Long.hashCode(this.id) * 31) + this.batchId.hashCode()) * 31) + this.ruleId.hashCode()) * 31) + this.appPackages.hashCode()) * 31) + Integer.hashCode(this.enableIndex)) * 31) + Long.hashCode(this.timeStamp)) * 31) + this.data.hashCode()) * 31) + Boolean.hashCode(this.personalDbSplitMigrated);
    }

    public String toString() {
        return "SlmAutoMemoryProTempResultEntityOld(id=" + this.id + ", batchId=" + this.batchId + ", ruleId=" + this.ruleId + ", appPackages=" + this.appPackages + ", enableIndex=" + this.enableIndex + ", timeStamp=" + this.timeStamp + ", data=" + this.data + ", personalDbSplitMigrated=" + this.personalDbSplitMigrated + ')';
    }
}
