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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b)\n\u0002\u0010\b\n\u0002\b\u0002\b\u0081\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0005HÆ\u0003J\t\u0010-\u001a\u00020\u0005HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0014HÆ\u0003J¯\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001J\u0013\u0010;\u001a\u00020\u00142\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020>HÖ\u0001J\t\u0010?\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001aR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0016\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001aR\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001aR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0016\u0010\u000f\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0016\u0010\u0010\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001aR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001aR\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0018R\u0016\u0010\u0013\u001a\u00020\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006@"}, d2 = {"Lcom/obric/memorydata/database/legacy/entity/MemoryReviewFeedbackEntityOld;", "", OaidModel.KEY_ID, "", "recordId", "", "module", "vote", "reasonsJson", "comment", "displayedCardJson", "status", "error", "traceJson", "updateTime", "serverUniqId", "serverStatus", "serverError", "serverUpdateTime", "personalDbSplitMigrated", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V", "getId", "()J", "getRecordId", "()Ljava/lang/String;", "getModule", "getVote", "getReasonsJson", "getComment", "getDisplayedCardJson", "getStatus", "getError", "getTraceJson", "getUpdateTime", "getServerUniqId", "getServerStatus", "getServerError", "getServerUpdateTime", "getPersonalDbSplitMigrated", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "other", "hashCode", "", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryReviewFeedbackEntityOld {
    private final String comment;
    private final String displayedCardJson;
    private final String error;
    private final long id;
    private final String module;
    private final boolean personalDbSplitMigrated;
    private final String reasonsJson;
    private final String recordId;
    private final String serverError;
    private final String serverStatus;
    private final String serverUniqId;
    private final long serverUpdateTime;
    private final String status;
    private final String traceJson;
    private final long updateTime;
    private final String vote;

    public MemoryReviewFeedbackEntityOld(long r13, String r15, String r16, String r17, String r18, String r19, String r20, String r21, String r22, String r23, long r24, String r26, String r27, String r28, long r29, boolean r31) {
        Intrinsics.checkNotNullParameter(r15, "recordId");
        Intrinsics.checkNotNullParameter(r16, "module");
        Intrinsics.checkNotNullParameter(r17, "vote");
        Intrinsics.checkNotNullParameter(r18, "reasonsJson");
        Intrinsics.checkNotNullParameter(r19, "comment");
        Intrinsics.checkNotNullParameter(r20, "displayedCardJson");
        Intrinsics.checkNotNullParameter(r21, "status");
        Intrinsics.checkNotNullParameter(r26, "serverUniqId");
        Intrinsics.checkNotNullParameter(r27, "serverStatus");
        this.id = r13;
        this.recordId = r15;
        this.module = r16;
        this.vote = r17;
        this.reasonsJson = r18;
        this.comment = r19;
        this.displayedCardJson = r20;
        this.status = r21;
        this.error = r22;
        this.traceJson = r23;
        this.updateTime = r24;
        this.serverUniqId = r26;
        this.serverStatus = r27;
        this.serverError = r28;
        this.serverUpdateTime = r29;
        this.personalDbSplitMigrated = r31;
    }

    public /* synthetic */ MemoryReviewFeedbackEntityOld(long r25, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, String r35, long r36, String r38, String r39, String r40, long r41, boolean r43, int r44, DefaultConstructorMarker r45) {
        if ((r44 & 1) == 0) goto L5;
        long r5 = 0;
    L7:
        if ((r44 & 256) == 0) goto L9;
        String r14 = null;
    L11:
        if ((r44 & 512) == 0) goto L13;
        String r15 = null;
    L15:
        if ((r44 & 2048) == 0) goto L17;
        String r18 = "";
    L19:
        if ((r44 & 4096) == 0) goto L21;
        String r19 = "";
    L23:
        if ((r44 & 8192) == 0) goto L25;
        String r20 = null;
    L27:
        if ((r44 & 16384) == 0) goto L29;
        long r21 = 0;
    L31:
        if ((r44 & 32768) == 0) goto L33;
        boolean r23 = false;
    L34:
        this(r5, r27, r28, r29, r30, r31, r32, r33, r14, r15, r36, r18, r19, r20, r21, r23);
        return;
    L33:
        r23 = r43;
        goto L34
    L29:
        r21 = r41;
        goto L31
    L25:
        r20 = r40;
        goto L27
    L21:
        r19 = r39;
        goto L23
    L17:
        r18 = r38;
        goto L19
    L13:
        r15 = r35;
        goto L15
    L9:
        r14 = r34;
        goto L11
    L5:
        r5 = r25;
        goto L7
    }

    public static /* synthetic */ MemoryReviewFeedbackEntityOld copy$default(MemoryReviewFeedbackEntityOld r16, long r17, String r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, long r28, String r30, String r31, String r32, long r33, boolean r35, int r36, Object r37) {
        if ((r36 & 1) == 0) goto L5;
        long r2 = r16.id;
    L7:
        if ((r36 & 2) == 0) goto L9;
        String r4 = r16.recordId;
    L11:
        if ((r36 & 4) == 0) goto L13;
        String r5 = r16.module;
    L15:
        if ((r36 & 8) == 0) goto L17;
        String r6 = r16.vote;
    L19:
        if ((r36 & 16) == 0) goto L21;
        String r7 = r16.reasonsJson;
    L23:
        if ((r36 & 32) == 0) goto L25;
        String r8 = r16.comment;
    L27:
        if ((r36 & 64) == 0) goto L29;
        String r9 = r16.displayedCardJson;
    L31:
        if ((r36 & 128) == 0) goto L33;
        String r10 = r16.status;
    L35:
        if ((r36 & 256) == 0) goto L37;
        String r11 = r16.error;
    L39:
        if ((r36 & 512) == 0) goto L41;
        String r12 = r16.traceJson;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        long r13 = r16.updateTime;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        String r15 = r16.serverUniqId;
    L50:
        String r34 = r15;
        if ((r36 & 4096) == 0) goto L53;
        String r18 = r16.serverStatus;
    L54:
        String r38 = r18;
        if ((r36 & 8192) == 0) goto L57;
        String r110 = r16.serverError;
    L58:
        String r39 = r110;
        long r29 = r13;
        if ((r36 & 16384) == 0) goto L61;
        long r14 = r16.serverUpdateTime;
    L63:
        if ((r36 & 32768) == 0) goto L65;
        boolean r1 = r16.personalDbSplitMigrated;
    L67:
        return r16.copy(r2, r4, r5, r6, r7, r8, r9, r10, r11, r12, r29, r34, r38, r39, r14, r1);
    L65:
        r1 = r35;
        goto L67
    L61:
        r14 = r33;
        goto L63
    L57:
        r110 = r32;
        goto L58
    L53:
        r18 = r31;
        goto L54
    L49:
        r15 = r30;
        goto L50
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
        return this.traceJson;
    }

    public final long component11() {
        return this.updateTime;
    }

    public final String component12() {
        return this.serverUniqId;
    }

    public final String component13() {
        return this.serverStatus;
    }

    public final String component14() {
        return this.serverError;
    }

    public final long component15() {
        return this.serverUpdateTime;
    }

    public final boolean component16() {
        return this.personalDbSplitMigrated;
    }

    public final String component2() {
        return this.recordId;
    }

    public final String component3() {
        return this.module;
    }

    public final String component4() {
        return this.vote;
    }

    public final String component5() {
        return this.reasonsJson;
    }

    public final String component6() {
        return this.comment;
    }

    public final String component7() {
        return this.displayedCardJson;
    }

    public final String component8() {
        return this.status;
    }

    public final String component9() {
        return this.error;
    }

    public final MemoryReviewFeedbackEntityOld copy(long r22, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, long r33, String r35, String r36, String r37, long r38, boolean r40) {
        Intrinsics.checkNotNullParameter(r24, "recordId");
        Intrinsics.checkNotNullParameter(r25, "module");
        Intrinsics.checkNotNullParameter(r26, "vote");
        Intrinsics.checkNotNullParameter(r27, "reasonsJson");
        Intrinsics.checkNotNullParameter(r28, "comment");
        Intrinsics.checkNotNullParameter(r29, "displayedCardJson");
        Intrinsics.checkNotNullParameter(r30, "status");
        Intrinsics.checkNotNullParameter(r35, "serverUniqId");
        Intrinsics.checkNotNullParameter(r36, "serverStatus");
        return new MemoryReviewFeedbackEntityOld(r22, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r35, r36, r37, r38, r40);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, MemoryReviewFeedbackEntityOld.class) == true) goto L8;
        return false;
    L8:
        MemoryReviewFeedbackEntityOld r10 = (MemoryReviewFeedbackEntityOld) ZeusTransformUtils.preCheckCast(r9, MemoryReviewFeedbackEntityOld.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.recordId, r10.recordId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.module, r10.module) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.vote, r10.vote) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.reasonsJson, r10.reasonsJson) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.comment, r10.comment) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.displayedCardJson, r10.displayedCardJson) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.status, r10.status) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.error, r10.error) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.traceJson, r10.traceJson) == true) goto L39;
        return false;
    L39:
        if (this.updateTime == r10.updateTime) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.serverUniqId, r10.serverUniqId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.serverStatus, r10.serverStatus) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.serverError, r10.serverError) == true) goto L51;
        return false;
    L51:
        if (this.serverUpdateTime == r10.serverUpdateTime) goto L54;
        return false;
    L54:
        if (this.personalDbSplitMigrated == r10.personalDbSplitMigrated) goto L56;
        return false;
    L56:
        return true;
    }

    public final String getComment() {
        return this.comment;
    }

    public final String getDisplayedCardJson() {
        return this.displayedCardJson;
    }

    public final String getError() {
        return this.error;
    }

    public final long getId() {
        return this.id;
    }

    public final String getModule() {
        return this.module;
    }

    public final boolean getPersonalDbSplitMigrated() {
        return this.personalDbSplitMigrated;
    }

    public final String getReasonsJson() {
        return this.reasonsJson;
    }

    public final String getRecordId() {
        return this.recordId;
    }

    public final String getServerError() {
        return this.serverError;
    }

    public final String getServerStatus() {
        return this.serverStatus;
    }

    public final String getServerUniqId() {
        return this.serverUniqId;
    }

    public final long getServerUpdateTime() {
        return this.serverUpdateTime;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getTraceJson() {
        return this.traceJson;
    }

    public final long getUpdateTime() {
        return this.updateTime;
    }

    public final String getVote() {
        return this.vote;
    }

    public int hashCode() {
        int r0 = ((((((((((((((Long.hashCode(this.id) * 31) + this.recordId.hashCode()) * 31) + this.module.hashCode()) * 31) + this.vote.hashCode()) * 31) + this.reasonsJson.hashCode()) * 31) + this.comment.hashCode()) * 31) + this.displayedCardJson.hashCode()) * 31) + this.status.hashCode()) * 31;
        String r1 = this.error;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.traceJson;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((((r4 + r6) * 31) + Long.hashCode(this.updateTime)) * 31) + this.serverUniqId.hashCode()) * 31) + this.serverStatus.hashCode()) * 31;
        String r8 = this.serverError;
        if (r8 == null) goto L15;
        r2 = r8.hashCode();
    L15:
        return ((((r7 + r2) * 31) + Long.hashCode(this.serverUpdateTime)) * 31) + Boolean.hashCode(this.personalDbSplitMigrated);
    L9:
        r6 = r5.hashCode();
        goto L10
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("MemoryReviewFeedbackEntityOld(id=").append(this.id).append(", recordId=").append(this.recordId).append(", module=").append(this.module).append(", vote=").append(this.vote).append(", reasonsJson=").append(this.reasonsJson).append(", comment=").append(this.comment).append(", displayedCardJson=").append(this.displayedCardJson).append(", status=").append(this.status).append(", error=").append(this.error).append(", traceJson=").append(this.traceJson).append(", updateTime=").append(this.updateTime).append(", serverUniqId=");
        r0.append(this.serverUniqId).append(", serverStatus=").append(this.serverStatus).append(", serverError=").append(this.serverError).append(", serverUpdateTime=").append(this.serverUpdateTime).append(", personalDbSplitMigrated=").append(this.personalDbSplitMigrated).append(')');
        return r0.toString();
    }
}
