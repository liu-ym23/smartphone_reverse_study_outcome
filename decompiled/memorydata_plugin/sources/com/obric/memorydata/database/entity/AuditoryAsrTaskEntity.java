package com.obric.memorydata.database.entity;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b?\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bã\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\t\u00108\u001a\u00020\u0003HÆ\u0003J\t\u00109\u001a\u00020\u0003HÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0007HÆ\u0003J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010D\u001a\u00020\u0011HÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0007HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÆ\u0003J\t\u0010J\u001a\u00020\u0003HÆ\u0003J\t\u0010K\u001a\u00020\u0003HÆ\u0003J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\t\u0010M\u001a\u00020\u0007HÆ\u0003J\t\u0010N\u001a\u00020\u0007HÆ\u0003Jñ\u0001\u0010O\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u0007HÆ\u0001J\u0013\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010S\u001a\u00020\u0011HÖ\u0001J\t\u0010T\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0016\u0010\f\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0016\u0010\r\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0016\u0010\u000e\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001fR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001fR\u0016\u0010\u0010\u001a\u00020\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0016\u0010\u0012\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001fR\u0016\u0010\u0013\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010#R\u0016\u0010\u0014\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001fR\u0016\u0010\u0015\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001fR\u0016\u0010\u0016\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001fR\u0016\u0010\u0017\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001fR\u0016\u0010\u0018\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001fR\u0016\u0010\u0019\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001fR\u0016\u0010\u001a\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010#R\u0016\u0010\u001b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010#¨\u0006U"}, d2 = {"Lcom/obric/memorydata/database/entity/AuditoryAsrTaskEntity;", "", "taskId", "", "accountScope", "status", "audioStartMs", "", "audioEndMs", "audioStartTime", "audioEndTime", "audioTimezone", "audioPath", "manifest", "audioSha256", "tosKey", "retryCount", "", "lastError", "terminalAt", "observationId", "rawObservationIds", "submitLogId", "resultLogId", "requestLogIds", "evidenceState", "createdAt", "updatedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "getTaskId", "()Ljava/lang/String;", "getAccountScope", "getStatus", "getAudioStartMs", "()J", "getAudioEndMs", "getAudioStartTime", "getAudioEndTime", "getAudioTimezone", "getAudioPath", "getManifest", "getAudioSha256", "getTosKey", "getRetryCount", "()I", "getLastError", "getTerminalAt", "getObservationId", "getRawObservationIds", "getSubmitLogId", "getResultLogId", "getRequestLogIds", "getEvidenceState", "getCreatedAt", "getUpdatedAt", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "copy", "equals", "", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AuditoryAsrTaskEntity {
    private final String accountScope;
    private final long audioEndMs;
    private final String audioEndTime;
    private final String audioPath;
    private final String audioSha256;
    private final long audioStartMs;
    private final String audioStartTime;
    private final String audioTimezone;
    private final long createdAt;
    private final String evidenceState;
    private final String lastError;
    private final String manifest;
    private final String observationId;
    private final String rawObservationIds;
    private final String requestLogIds;
    private final String resultLogId;
    private final int retryCount;
    private final String status;
    private final String submitLogId;
    private final String taskId;
    private final long terminalAt;
    private final String tosKey;
    private final long updatedAt;

    public AuditoryAsrTaskEntity(String r17, String r18, String r19, long r20, long r22, String r24, String r25, String r26, String r27, String r28, String r29, String r30, int r31, String r32, long r33, String r35, String r36, String r37, String r38, String r39, String r40, long r41, long r43) {
        Intrinsics.checkNotNullParameter(r17, "taskId");
        Intrinsics.checkNotNullParameter(r18, "accountScope");
        Intrinsics.checkNotNullParameter(r19, "status");
        Intrinsics.checkNotNullParameter(r24, "audioStartTime");
        Intrinsics.checkNotNullParameter(r25, "audioEndTime");
        Intrinsics.checkNotNullParameter(r26, "audioTimezone");
        Intrinsics.checkNotNullParameter(r27, "audioPath");
        Intrinsics.checkNotNullParameter(r28, "manifest");
        Intrinsics.checkNotNullParameter(r29, "audioSha256");
        Intrinsics.checkNotNullParameter(r32, "lastError");
        Intrinsics.checkNotNullParameter(r35, "observationId");
        Intrinsics.checkNotNullParameter(r36, "rawObservationIds");
        Intrinsics.checkNotNullParameter(r37, "submitLogId");
        Intrinsics.checkNotNullParameter(r38, "resultLogId");
        Intrinsics.checkNotNullParameter(r39, "requestLogIds");
        Intrinsics.checkNotNullParameter(r40, "evidenceState");
        this.taskId = r17;
        this.accountScope = r18;
        this.status = r19;
        this.audioStartMs = r20;
        this.audioEndMs = r22;
        this.audioStartTime = r24;
        this.audioEndTime = r25;
        this.audioTimezone = r26;
        this.audioPath = r27;
        this.manifest = r28;
        this.audioSha256 = r29;
        this.tosKey = r30;
        this.retryCount = r31;
        this.lastError = r32;
        this.terminalAt = r33;
        this.observationId = r35;
        this.rawObservationIds = r36;
        this.submitLogId = r37;
        this.resultLogId = r38;
        this.requestLogIds = r39;
        this.evidenceState = r40;
        this.createdAt = r41;
        this.updatedAt = r43;
    }

    public /* synthetic */ AuditoryAsrTaskEntity(String r34, String r35, String r36, long r37, long r39, String r41, String r42, String r43, String r44, String r45, String r46, String r47, int r48, String r49, long r50, String r52, String r53, String r54, String r55, String r56, String r57, long r58, long r60, int r62, DefaultConstructorMarker r63) {
        if ((r62 & 16) == 0) goto L5;
        long r10 = 0;
    L7:
        if ((r62 & 32) == 0) goto L9;
        String r12 = "";
    L11:
        if ((r62 & 64) == 0) goto L13;
        String r13 = "";
    L15:
        if ((r62 & 128) == 0) goto L17;
        String r14 = "";
    L19:
        if ((r62 & 256) == 0) goto L21;
        String r15 = "";
    L23:
        if ((r62 & 512) == 0) goto L25;
        String r16 = "{}";
    L27:
        if ((r62 & 1024) == 0) goto L29;
        String r17 = "";
    L31:
        if ((r62 & 2048) == 0) goto L33;
        String r18 = null;
    L35:
        if ((r62 & 4096) == 0) goto L37;
        int r19 = 0;
    L39:
        if ((r62 & 8192) == 0) goto L41;
        String r20 = "";
    L43:
        if ((r62 & 16384) == 0) goto L45;
        long r21 = 0;
    L47:
        if ((32768 & r62) == 0) goto L49;
        String r23 = "";
    L51:
        if ((65536 & r62) == 0) goto L53;
        String r24 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L55:
        if ((131072 & r62) == 0) goto L57;
        String r25 = "";
    L59:
        if ((262144 & r62) == 0) goto L61;
        String r26 = "";
    L63:
        if ((524288 & r62) == 0) goto L65;
        String r27 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
    L67:
        if ((r62 & 1048576) == 0) goto L69;
        String r28 = "NONE";
    L70:
        this(r34, r35, r36, r37, r10, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r23, r24, r25, r26, r27, r28, r58, r60);
        return;
    L69:
        r28 = r57;
        goto L70
    L65:
        r27 = r56;
        goto L67
    L61:
        r26 = r55;
        goto L63
    L57:
        r25 = r54;
        goto L59
    L53:
        r24 = r53;
        goto L55
    L49:
        r23 = r52;
        goto L51
    L45:
        r21 = r50;
        goto L47
    L41:
        r20 = r49;
        goto L43
    L37:
        r19 = r48;
        goto L39
    L33:
        r18 = r47;
        goto L35
    L29:
        r17 = r46;
        goto L31
    L25:
        r16 = r45;
        goto L27
    L21:
        r15 = r44;
        goto L23
    L17:
        r14 = r43;
        goto L19
    L13:
        r13 = r42;
        goto L15
    L9:
        r12 = r41;
        goto L11
    L5:
        r10 = r39;
        goto L7
    }

    public static /* synthetic */ AuditoryAsrTaskEntity copy$default(AuditoryAsrTaskEntity r17, String r18, String r19, String r20, long r21, long r23, String r25, String r26, String r27, String r28, String r29, String r30, String r31, int r32, String r33, long r34, String r36, String r37, String r38, String r39, String r40, String r41, long r42, long r44, int r46, Object r47) {
        if ((r46 & 1) == 0) goto L5;
        String r2 = r17.taskId;
    L7:
        if ((r46 & 2) == 0) goto L9;
        String r3 = r17.accountScope;
    L11:
        if ((r46 & 4) == 0) goto L13;
        String r4 = r17.status;
    L15:
        if ((r46 & 8) == 0) goto L17;
        long r5 = r17.audioStartMs;
    L19:
        if ((r46 & 16) == 0) goto L21;
        long r7 = r17.audioEndMs;
    L23:
        if ((r46 & 32) == 0) goto L25;
        String r9 = r17.audioStartTime;
    L27:
        if ((r46 & 64) == 0) goto L29;
        String r10 = r17.audioEndTime;
    L31:
        if ((r46 & 128) == 0) goto L33;
        String r11 = r17.audioTimezone;
    L35:
        if ((r46 & 256) == 0) goto L37;
        String r12 = r17.audioPath;
    L39:
        if ((r46 & 512) == 0) goto L41;
        String r13 = r17.manifest;
    L43:
        if ((r46 & 1024) == 0) goto L45;
        String r14 = r17.audioSha256;
    L47:
        if ((r46 & 2048) == 0) goto L49;
        String r15 = r17.tosKey;
    L50:
        String r35 = r15;
        if ((r46 & 4096) == 0) goto L53;
        int r16 = r17.retryCount;
    L54:
        int r310 = r16;
        if ((r46 & 8192) == 0) goto L57;
        String r110 = r17.lastError;
    L58:
        String r311 = r110;
        String r312 = r14;
        if ((r46 & 16384) == 0) goto L61;
        long r111 = r17.terminalAt;
    L62:
        long r313 = r111;
        if ((r46 & 32768) == 0) goto L65;
        String r112 = r17.observationId;
    L67:
        if ((65536 & r46) == 0) goto L69;
        String r113 = r17.rawObservationIds;
    L70:
        String r314 = r113;
        if ((r46 & 131072) == 0) goto L73;
        String r114 = r17.submitLogId;
    L74:
        String r315 = r114;
        if ((r46 & 262144) == 0) goto L77;
        String r115 = r17.resultLogId;
    L78:
        String r316 = r115;
        if ((r46 & 524288) == 0) goto L81;
        String r116 = r17.requestLogIds;
    L82:
        String r43 = r116;
        if ((r46 & 1048576) == 0) goto L85;
        String r117 = r17.evidenceState;
    L86:
        String r317 = r112;
        String r45 = r117;
        if ((r46 & 2097152) == 0) goto L89;
        long r118 = r17.createdAt;
    L90:
        long r48 = r118;
        if ((r46 & 4194304) == 0) goto L93;
        long r119 = r17.updatedAt;
    L95:
        return r17.copy(r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r312, r35, r310, r311, r313, r317, r314, r315, r316, r43, r45, r48, r119);
    L93:
        r119 = r44;
        goto L95
    L89:
        r118 = r42;
        goto L90
    L85:
        r117 = r41;
        goto L86
    L81:
        r116 = r40;
        goto L82
    L77:
        r115 = r39;
        goto L78
    L73:
        r114 = r38;
        goto L74
    L69:
        r113 = r37;
        goto L70
    L65:
        r112 = r36;
        goto L67
    L61:
        r111 = r34;
        goto L62
    L57:
        r110 = r33;
        goto L58
    L53:
        r16 = r32;
        goto L54
    L49:
        r15 = r31;
        goto L50
    L45:
        r14 = r30;
        goto L47
    L41:
        r13 = r29;
        goto L43
    L37:
        r12 = r28;
        goto L39
    L33:
        r11 = r27;
        goto L35
    L29:
        r10 = r26;
        goto L31
    L25:
        r9 = r25;
        goto L27
    L21:
        r7 = r23;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.taskId;
    }

    public final String component10() {
        return this.manifest;
    }

    public final String component11() {
        return this.audioSha256;
    }

    public final String component12() {
        return this.tosKey;
    }

    public final int component13() {
        return this.retryCount;
    }

    public final String component14() {
        return this.lastError;
    }

    public final long component15() {
        return this.terminalAt;
    }

    public final String component16() {
        return this.observationId;
    }

    public final String component17() {
        return this.rawObservationIds;
    }

    public final String component18() {
        return this.submitLogId;
    }

    public final String component19() {
        return this.resultLogId;
    }

    public final String component2() {
        return this.accountScope;
    }

    public final String component20() {
        return this.requestLogIds;
    }

    public final String component21() {
        return this.evidenceState;
    }

    public final long component22() {
        return this.createdAt;
    }

    public final long component23() {
        return this.updatedAt;
    }

    public final String component3() {
        return this.status;
    }

    public final long component4() {
        return this.audioStartMs;
    }

    public final long component5() {
        return this.audioEndMs;
    }

    public final String component6() {
        return this.audioStartTime;
    }

    public final String component7() {
        return this.audioEndTime;
    }

    public final String component8() {
        return this.audioTimezone;
    }

    public final String component9() {
        return this.audioPath;
    }

    public final AuditoryAsrTaskEntity copy(String r31, String r32, String r33, long r34, long r36, String r38, String r39, String r40, String r41, String r42, String r43, String r44, int r45, String r46, long r47, String r49, String r50, String r51, String r52, String r53, String r54, long r55, long r57) {
        Intrinsics.checkNotNullParameter(r31, "taskId");
        Intrinsics.checkNotNullParameter(r32, "accountScope");
        Intrinsics.checkNotNullParameter(r33, "status");
        Intrinsics.checkNotNullParameter(r38, "audioStartTime");
        Intrinsics.checkNotNullParameter(r39, "audioEndTime");
        Intrinsics.checkNotNullParameter(r40, "audioTimezone");
        Intrinsics.checkNotNullParameter(r41, "audioPath");
        Intrinsics.checkNotNullParameter(r42, "manifest");
        Intrinsics.checkNotNullParameter(r43, "audioSha256");
        Intrinsics.checkNotNullParameter(r46, "lastError");
        Intrinsics.checkNotNullParameter(r49, "observationId");
        Intrinsics.checkNotNullParameter(r50, "rawObservationIds");
        Intrinsics.checkNotNullParameter(r51, "submitLogId");
        Intrinsics.checkNotNullParameter(r52, "resultLogId");
        Intrinsics.checkNotNullParameter(r53, "requestLogIds");
        Intrinsics.checkNotNullParameter(r54, "evidenceState");
        return new AuditoryAsrTaskEntity(r31, r32, r33, r34, r36, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r49, r50, r51, r52, r53, r54, r55, r57);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, AuditoryAsrTaskEntity.class) == true) goto L8;
        return false;
    L8:
        AuditoryAsrTaskEntity r10 = (AuditoryAsrTaskEntity) ZeusTransformUtils.preCheckCast(r9, AuditoryAsrTaskEntity.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.taskId, r10.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.accountScope, r10.accountScope) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.status, r10.status) == true) goto L18;
        return false;
    L18:
        if (this.audioStartMs == r10.audioStartMs) goto L21;
        return false;
    L21:
        if (this.audioEndMs == r10.audioEndMs) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.audioStartTime, r10.audioStartTime) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.audioEndTime, r10.audioEndTime) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.audioTimezone, r10.audioTimezone) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.audioPath, r10.audioPath) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.manifest, r10.manifest) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.audioSha256, r10.audioSha256) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.tosKey, r10.tosKey) == true) goto L45;
        return false;
    L45:
        if (this.retryCount == r10.retryCount) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.lastError, r10.lastError) == true) goto L51;
        return false;
    L51:
        if (this.terminalAt == r10.terminalAt) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.observationId, r10.observationId) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.rawObservationIds, r10.rawObservationIds) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.submitLogId, r10.submitLogId) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.resultLogId, r10.resultLogId) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.requestLogIds, r10.requestLogIds) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.evidenceState, r10.evidenceState) == true) goto L72;
        return false;
    L72:
        if (this.createdAt == r10.createdAt) goto L75;
        return false;
    L75:
        if (this.updatedAt == r10.updatedAt) goto L77;
        return false;
    L77:
        return true;
    }

    public final String getAccountScope() {
        return this.accountScope;
    }

    public final long getAudioEndMs() {
        return this.audioEndMs;
    }

    public final String getAudioEndTime() {
        return this.audioEndTime;
    }

    public final String getAudioPath() {
        return this.audioPath;
    }

    public final String getAudioSha256() {
        return this.audioSha256;
    }

    public final long getAudioStartMs() {
        return this.audioStartMs;
    }

    public final String getAudioStartTime() {
        return this.audioStartTime;
    }

    public final String getAudioTimezone() {
        return this.audioTimezone;
    }

    public final long getCreatedAt() {
        return this.createdAt;
    }

    public final String getEvidenceState() {
        return this.evidenceState;
    }

    public final String getLastError() {
        return this.lastError;
    }

    public final String getManifest() {
        return this.manifest;
    }

    public final String getObservationId() {
        return this.observationId;
    }

    public final String getRawObservationIds() {
        return this.rawObservationIds;
    }

    public final String getRequestLogIds() {
        return this.requestLogIds;
    }

    public final String getResultLogId() {
        return this.resultLogId;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getSubmitLogId() {
        return this.submitLogId;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final long getTerminalAt() {
        return this.terminalAt;
    }

    public final String getTosKey() {
        return this.tosKey;
    }

    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        int r0 = ((((((((((((((((((((this.taskId.hashCode() * 31) + this.accountScope.hashCode()) * 31) + this.status.hashCode()) * 31) + Long.hashCode(this.audioStartMs)) * 31) + Long.hashCode(this.audioEndMs)) * 31) + this.audioStartTime.hashCode()) * 31) + this.audioEndTime.hashCode()) * 31) + this.audioTimezone.hashCode()) * 31) + this.audioPath.hashCode()) * 31) + this.manifest.hashCode()) * 31) + this.audioSha256.hashCode()) * 31;
        String r1 = this.tosKey;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((((((((((((((((((((r0 + r2) * 31) + Integer.hashCode(this.retryCount)) * 31) + this.lastError.hashCode()) * 31) + Long.hashCode(this.terminalAt)) * 31) + this.observationId.hashCode()) * 31) + this.rawObservationIds.hashCode()) * 31) + this.submitLogId.hashCode()) * 31) + this.resultLogId.hashCode()) * 31) + this.requestLogIds.hashCode()) * 31) + this.evidenceState.hashCode()) * 31) + Long.hashCode(this.createdAt)) * 31) + Long.hashCode(this.updatedAt);
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("AuditoryAsrTaskEntity(taskId=").append(this.taskId).append(", accountScope=").append(this.accountScope).append(", status=").append(this.status).append(", audioStartMs=").append(this.audioStartMs).append(", audioEndMs=").append(this.audioEndMs).append(", audioStartTime=").append(this.audioStartTime).append(", audioEndTime=").append(this.audioEndTime).append(", audioTimezone=").append(this.audioTimezone).append(", audioPath=").append(this.audioPath).append(", manifest=").append(this.manifest).append(", audioSha256=").append(this.audioSha256).append(", tosKey=");
        r0.append(this.tosKey).append(", retryCount=").append(this.retryCount).append(", lastError=").append(this.lastError).append(", terminalAt=").append(this.terminalAt).append(", observationId=").append(this.observationId).append(", rawObservationIds=").append(this.rawObservationIds).append(", submitLogId=").append(this.submitLogId).append(", resultLogId=").append(this.resultLogId).append(", requestLogIds=").append(this.requestLogIds).append(", evidenceState=").append(this.evidenceState).append(", createdAt=").append(this.createdAt).append(", updatedAt=").append(this.updatedAt);
        r0.append(')');
        return r0.toString();
    }
}
