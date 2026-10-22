package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b*\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u0000 >2\u00020\u0001:\u0001>B\u0087\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010*\u001a\u00020\u0005H\u0016J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0010\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00103\u001a\u00020\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00106\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0002\u0010$J\t\u00107\u001a\u00020\u0010HÆ\u0003J\u009e\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001cR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u001e\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006?"}, d2 = {"Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "", OaidModel.KEY_ID, "", "title", "", "location", "eventType", "description", "dtstart", "dtend", "rrule", "sourceAppPackage", "sourceAppName", "memoryUuid", "entityType", "", "status", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I)V", "getId", "()J", "getTitle", "()Ljava/lang/String;", "getLocation", "getEventType", "getDescription", "getDtstart", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getDtend", "getRrule", "getSourceAppPackage", "getSourceAppName", "getMemoryUuid", "getEntityType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getStatus", "()I", "setStatus", "(I)V", "toString", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;I)Lcom/obric/memorydata/database/entity/PendingMemoryCalendar;", "equals", "", "other", "hashCode", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PendingMemoryCalendar {
    public static final a Companion = null;
    public static final int STATUS_DONE = 1;
    public static final int STATUS_PENDING = 0;
    public static final String TYPE_EVENT = "EVENT";
    public static final String TYPE_TODO = "TODO";
    private final String description;
    private final Long dtend;
    private final Long dtstart;
    private final Integer entityType;
    private final String eventType;
    private final long id;
    private final String location;
    private final String memoryUuid;
    private final String rrule;
    private final String sourceAppName;
    private final String sourceAppPackage;
    private int status;
    private final String title;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/database/entity/PendingMemoryCalendar$Companion;", "", "<init>", "()V", "STATUS_PENDING", "", "STATUS_DONE", "TYPE_EVENT", "", "TYPE_TODO", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public PendingMemoryCalendar(long r2, String r4, String r5, String r6, String r7, Long r8, Long r9, String r10, String r11, String r12, String r13, Integer r14, int r15) {
        Intrinsics.checkNotNullParameter(r4, "title");
        Intrinsics.checkNotNullParameter(r6, "eventType");
        Intrinsics.checkNotNullParameter(r11, "sourceAppPackage");
        Intrinsics.checkNotNullParameter(r12, "sourceAppName");
        this.id = r2;
        this.title = r4;
        this.location = r5;
        this.eventType = r6;
        this.description = r7;
        this.dtstart = r8;
        this.dtend = r9;
        this.rrule = r10;
        this.sourceAppPackage = r11;
        this.sourceAppName = r12;
        this.memoryUuid = r13;
        this.entityType = r14;
        this.status = r15;
    }

    public /* synthetic */ PendingMemoryCalendar(long r19, String r21, String r22, String r23, String r24, Long r25, Long r26, String r27, String r28, String r29, String r30, Integer r31, int r32, int r33, DefaultConstructorMarker r34) {
        if ((r33 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r33 & 4) == 0) goto L9;
        String r7 = null;
    L11:
        if ((r33 & 16) == 0) goto L13;
        String r9 = null;
    L15:
        if ((r33 & 128) == 0) goto L17;
        String r12 = null;
    L19:
        if ((r33 & 4096) == 0) goto L21;
        int r17 = 0;
    L22:
        this(r4, r21, r7, r23, r9, r25, r26, r12, r28, r29, r30, r31, r17);
        return;
    L21:
        r17 = r32;
        goto L22
    L17:
        r12 = r27;
        goto L19
    L13:
        r9 = r24;
        goto L15
    L9:
        r7 = r22;
        goto L11
    L5:
        r4 = r19;
        goto L7
    }

    public static /* synthetic */ PendingMemoryCalendar copy$default(PendingMemoryCalendar r15, long r16, String r18, String r19, String r20, String r21, Long r22, Long r23, String r24, String r25, String r26, String r27, Integer r28, int r29, int r30, Object r31) {
        if ((r30 & 1) == 0) goto L5;
        long r2 = r15.id;
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r4 = r15.title;
    L11:
        if ((r30 & 4) == 0) goto L13;
        String r5 = r15.location;
    L15:
        if ((r30 & 8) == 0) goto L17;
        String r6 = r15.eventType;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r7 = r15.description;
    L23:
        if ((r30 & 32) == 0) goto L25;
        Long r8 = r15.dtstart;
    L27:
        if ((r30 & 64) == 0) goto L29;
        Long r9 = r15.dtend;
    L31:
        if ((r30 & 128) == 0) goto L33;
        String r10 = r15.rrule;
    L35:
        if ((r30 & 256) == 0) goto L37;
        String r11 = r15.sourceAppPackage;
    L39:
        if ((r30 & 512) == 0) goto L41;
        String r12 = r15.sourceAppName;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        String r13 = r15.memoryUuid;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        Integer r14 = r15.entityType;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        int r1 = r15.status;
    L55:
        return r15.copy(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r1);
    L53:
        r1 = r29;
        goto L55
    L49:
        r14 = r28;
        goto L51
    L45:
        r13 = r27;
        goto L47
    L41:
        r12 = r26;
        goto L43
    L37:
        r11 = r25;
        goto L39
    L33:
        r10 = r24;
        goto L35
    L29:
        r9 = r23;
        goto L31
    L25:
        r8 = r22;
        goto L27
    L21:
        r7 = r21;
        goto L23
    L17:
        r6 = r20;
        goto L19
    L13:
        r5 = r19;
        goto L15
    L9:
        r4 = r18;
        goto L11
    L5:
        r2 = r16;
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

    public final PendingMemoryCalendar copy(long r17, String r19, String r20, String r21, String r22, Long r23, Long r24, String r25, String r26, String r27, String r28, Integer r29, int r30) {
        Intrinsics.checkNotNullParameter(r19, "title");
        Intrinsics.checkNotNullParameter(r21, "eventType");
        Intrinsics.checkNotNullParameter(r26, "sourceAppPackage");
        Intrinsics.checkNotNullParameter(r27, "sourceAppName");
        return new PendingMemoryCalendar(r17, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, PendingMemoryCalendar.class) == true) goto L8;
        return false;
    L8:
        PendingMemoryCalendar r10 = (PendingMemoryCalendar) ZeusTransformUtils.preCheckCast(r9, PendingMemoryCalendar.class, "com.obric.memorydata.plugin");
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
        if (this.status == r10.status) goto L47;
        return false;
    L47:
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
        return ((r19 + r2) * 31) + Integer.hashCode(this.status);
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
        StringBuilder r0 = new StringBuilder().append("PendingMemoryCalendar(id=").append(this.id).append(", title=");
        if (AppContext.INSTANCE.isDebug() == false) goto L5;
        String r1 = this.title;
    L7:
        return r0.append(r1).append(", eventType='").append(this.eventType).append("', dtstart=").append(this.dtstart).append(", dtend=").append(this.dtend).append(", sourceAppPackage='").append(this.sourceAppPackage).append("', sourceAppName='").append(this.sourceAppName).append("', memoryUuid=").append(this.memoryUuid).append(", entityType=").append(this.entityType).append(", status=").append(this.status).append(')').toString();
    L5:
        r1 = com.obric.memorydata.utils.q.f13259a.b(this.title);
        goto L7
    }
}
