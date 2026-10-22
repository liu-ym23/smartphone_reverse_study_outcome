package com.obric.memorydata.database.legacy.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b/\b\u0087\b\u0018\u00002\u00020\u0001B\u0091\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0010\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00109\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010&J\t\u0010:\u001a\u00020\u0010HÆ\u0003J\t\u0010;\u001a\u00020\u0013HÆ\u0003J¨\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u0013HÆ\u0001¢\u0006\u0002\u0010=J\u0013\u0010>\u001a\u00020\u00132\b\u0010?\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010@\u001a\u00020\u0010HÖ\u0001J\t\u0010A\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b \u0010\u001eR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0019R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010'\u001a\u0004\b%\u0010&R\u001e\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010\u0012\u001a\u00020\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-¨\u0006B"}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/PendingMemoryCalendarOld;", "", OaidModel.KEY_ID, "", "title", "", "location", "eventType", "description", "dtstart", "dtend", "rrule", "sourceAppPackage", "sourceAppName", "memoryUuid", "entityType", "", "status", "personalDbSplitMigrated", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IZ)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "getLocation", "getEventType", "getDescription", "getDtstart", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDtend", "getRrule", "getSourceAppPackage", "getSourceAppName", "getMemoryUuid", "getEntityType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatus", "()I", "setStatus", "(I)V", "getPersonalDbSplitMigrated", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;IZ)Lcom/obric/memorydata/database/legacy/entity/PendingMemoryCalendarOld;", "equals", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PendingMemoryCalendarOld {
    private final String description;
    private final Long dtend;
    private final Long dtstart;
    private final Integer entityType;
    private final String eventType;
    private final long id;
    private final String location;
    private final String memoryUuid;
    private final boolean personalDbSplitMigrated;
    private final String rrule;
    private final String sourceAppName;
    private final String sourceAppPackage;
    private int status;
    private final String title;

    public PendingMemoryCalendarOld(long r8, String r10, String r11, String r12, String r13, Long r14, Long r15, String r16, String r17, String r18, String r19, Integer r20, int r21, boolean r22) {
        Intrinsics.checkNotNullParameter(r10, "title");
        Intrinsics.checkNotNullParameter(r12, "eventType");
        Intrinsics.checkNotNullParameter(r17, "sourceAppPackage");
        Intrinsics.checkNotNullParameter(r18, "sourceAppName");
        this.id = r8;
        this.title = r10;
        this.location = r11;
        this.eventType = r12;
        this.description = r13;
        this.dtstart = r14;
        this.dtend = r15;
        this.rrule = r16;
        this.sourceAppPackage = r17;
        this.sourceAppName = r18;
        this.memoryUuid = r19;
        this.entityType = r20;
        this.status = r21;
        this.personalDbSplitMigrated = r22;
    }

    public /* synthetic */ PendingMemoryCalendarOld(long r20, String r22, String r23, String r24, String r25, Long r26, Long r27, String r28, String r29, String r30, String r31, Integer r32, int r33, boolean r34, int r35, DefaultConstructorMarker r36) {
        if ((r35 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r35 & 4) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r35 & 16) == 0) goto L13;
        String r9 = null;
    L15:
        if ((r35 & 128) == 0) goto L17;
        String r12 = null;
    L19:
        if ((r35 & 4096) == 0) goto L21;
        int r17 = 0;
    L23:
        if ((r35 & 8192) == 0) goto L25;
        boolean r18 = false;
    L26:
        this(r4, r22, r7, r24, r9, r26, r27, r12, r29, r30, r31, r32, r17, r18);
        return;
    L25:
        r18 = r34;
        goto L26
    L21:
        r17 = r33;
        goto L23
    L17:
        r12 = r28;
        goto L19
    L13:
        r9 = r25;
        goto L15
    L9:
        r7 = r23;
        goto L11
    L5:
        r4 = r20;
        goto L7
    }

    public static /* synthetic */ PendingMemoryCalendarOld copy$default(PendingMemoryCalendarOld r16, long r17, String r19, String r20, String r21, String r22, Long r23, Long r24, String r25, String r26, String r27, String r28, Integer r29, int r30, boolean r31, int r32, Object r33) {
        if ((r32 & 1) == 0) goto L5;
        long r2 = r16.id;
    L7:
        if ((r32 & 2) == 0) goto L9;
        String r4 = r16.title;
    L11:
        if ((r32 & 4) == 0) goto L13;
        String r5 = r16.location;
    L15:
        if ((r32 & 8) == 0) goto L17;
        String r6 = r16.eventType;
    L19:
        if ((r32 & 16) == 0) goto L21;
        String r7 = r16.description;
    L23:
        if ((r32 & 32) == 0) goto L25;
        Long r8 = r16.dtstart;
    L27:
        if ((r32 & 64) == 0) goto L29;
        Long r9 = r16.dtend;
    L31:
        if ((r32 & 128) == 0) goto L33;
        String r10 = r16.rrule;
    L35:
        if ((r32 & 256) == 0) goto L37;
        String r11 = r16.sourceAppPackage;
    L39:
        if ((r32 & 512) == 0) goto L41;
        String r12 = r16.sourceAppName;
    L43:
        if ((r32 & 1024) == 0) goto L45;
        String r13 = r16.memoryUuid;
    L47:
        if ((r32 & 2048) == 0) goto L49;
        Integer r14 = r16.entityType;
    L51:
        if ((r32 & 4096) == 0) goto L53;
        int r15 = r16.status;
    L55:
        if ((r32 & 8192) == 0) goto L57;
        boolean r1 = r16.personalDbSplitMigrated;
    L59:
        return r16.copy(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r1);
    L57:
        r1 = r31;
        goto L59
    L53:
        r15 = r30;
        goto L55
    L49:
        r14 = r29;
        goto L51
    L45:
        r13 = r28;
        goto L47
    L41:
        r12 = r27;
        goto L43
    L37:
        r11 = r26;
        goto L39
    L33:
        r10 = r25;
        goto L35
    L29:
        r9 = r24;
        goto L31
    L25:
        r8 = r23;
        goto L27
    L21:
        r7 = r22;
        goto L23
    L17:
        r6 = r21;
        goto L19
    L13:
        r5 = r20;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component10() {
        return this.sourceAppName;
    }

    public final String component11() {
        return this.memoryUuid;
    }

    public final Integer component12() {
        return this.entityType;
    }

    public final int component13() {
        return this.status;
    }

    public final boolean component14() {
        return this.personalDbSplitMigrated;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.location;
    }

    public final String component4() {
        return this.eventType;
    }

    public final String component5() {
        return this.description;
    }

    public final Long component6() {
        return this.dtstart;
    }

    public final Long component7() {
        return this.dtend;
    }

    public final String component8() {
        return this.rrule;
    }

    public final String component9() {
        return this.sourceAppPackage;
    }

    public final PendingMemoryCalendarOld copy(long r18, String r20, String r21, String r22, String r23, Long r24, Long r25, String r26, String r27, String r28, String r29, Integer r30, int r31, boolean r32) {
        Intrinsics.checkNotNullParameter(r20, "title");
        Intrinsics.checkNotNullParameter(r22, "eventType");
        Intrinsics.checkNotNullParameter(r27, "sourceAppPackage");
        Intrinsics.checkNotNullParameter(r28, "sourceAppName");
        return new PendingMemoryCalendarOld(r18, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, PendingMemoryCalendarOld.class) == true) goto L8;
        return false;
    L8:
        PendingMemoryCalendarOld r10 = (PendingMemoryCalendarOld) ZeusTransformUtils.preCheckCast(r9, PendingMemoryCalendarOld.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.title, r10.title) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.location, r10.location) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.eventType, r10.eventType) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.description, r10.description) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.dtstart, r10.dtstart) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.dtend, r10.dtend) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.rrule, r10.rrule) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.sourceAppPackage, r10.sourceAppPackage) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.sourceAppName, r10.sourceAppName) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.memoryUuid, r10.memoryUuid) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.entityType, r10.entityType) == true) goto L45;
        return false;
    L45:
        if (this.status == r10.status) goto L48;
        return false;
    L48:
        if (this.personalDbSplitMigrated == r10.personalDbSplitMigrated) goto L50;
        return false;
    L50:
        return true;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Long getDtend() {
        return this.dtend;
    }

    public final Long getDtstart() {
        return this.dtstart;
    }

    public final Integer getEntityType() {
        return this.entityType;
    }

    public final String getEventType() {
        return this.eventType;
    }

    public final long getId() {
        return this.id;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getMemoryUuid() {
        return this.memoryUuid;
    }

    public final boolean getPersonalDbSplitMigrated() {
        return this.personalDbSplitMigrated;
    }

    public final String getRrule() {
        return this.rrule;
    }

    public final String getSourceAppName() {
        return this.sourceAppName;
    }

    public final String getSourceAppPackage() {
        return this.sourceAppPackage;
    }

    public final int getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int r0 = ((Long.hashCode(this.id) * 31) + this.title.hashCode()) * 31;
        String r1 = this.location;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.eventType.hashCode()) * 31;
        String r5 = this.description;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (r4 + r6) * 31;
        Long r8 = this.dtstart;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        Long r11 = this.dtend;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.rrule;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (((((r13 + r15) * 31) + this.sourceAppPackage.hashCode()) * 31) + this.sourceAppName.hashCode()) * 31;
        String r17 = this.memoryUuid;
        if (r17 != null) goto L25;
        int r18 = 0;
    L26:
        int r19 = (r16 + r18) * 31;
        Integer r20 = this.entityType;
        if (r20 == null) goto L31;
        r2 = r20.hashCode();
    L31:
        return ((((r19 + r2) * 31) + Integer.hashCode(this.status)) * 31) + Boolean.hashCode(this.personalDbSplitMigrated);
    L25:
        r18 = r17.hashCode();
        goto L26
    L21:
        r15 = r14.hashCode();
        goto L22
    L17:
        r12 = r11.hashCode();
        goto L18
    L13:
        r9 = r8.hashCode();
        goto L14
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final void setStatus(int r1) {
        this.status = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("PendingMemoryCalendarOld(id=").append(this.id).append(", title=").append(this.title).append(", location=").append(this.location).append(", eventType=").append(this.eventType).append(", description=").append(this.description).append(", dtstart=").append(this.dtstart).append(", dtend=").append(this.dtend).append(", rrule=").append(this.rrule).append(", sourceAppPackage=").append(this.sourceAppPackage).append(", sourceAppName=").append(this.sourceAppName).append(", memoryUuid=").append(this.memoryUuid).append(", entityType=");
        r0.append(this.entityType).append(", status=").append(this.status).append(", personalDbSplitMigrated=").append(this.personalDbSplitMigrated).append(')');
        return r0.toString();
    }
}
