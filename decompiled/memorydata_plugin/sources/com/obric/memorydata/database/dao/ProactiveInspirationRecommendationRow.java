package com.obric.memorydata.database.dao;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.bdlocation.monitor.InfoRequestQPSOptTraceLogger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0006\n\u0002\bJ\b\u0086\b\u0018\u00002\u00020\u0001Bí\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0017\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u0019\u001a\u00020\n\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u0003\u0012\u0006\u0010\u001f\u001a\u00020\u0003\u0012\u0006\u0010 \u001a\u00020\u0003\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\"\u0010#J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\t\u0010H\u001a\u00020\u0003HÆ\u0003J\t\u0010I\u001a\u00020\u0007HÆ\u0003J\t\u0010J\u001a\u00020\u0007HÆ\u0003J\t\u0010K\u001a\u00020\nHÆ\u0003J\t\u0010L\u001a\u00020\u0007HÆ\u0003J\t\u0010M\u001a\u00020\u0007HÆ\u0003J\t\u0010N\u001a\u00020\u000eHÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0003HÆ\u0003J\t\u0010R\u001a\u00020\u0003HÆ\u0003J\t\u0010S\u001a\u00020\u0003HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010W\u001a\u00020\u0007HÆ\u0003J\t\u0010X\u001a\u00020\u0007HÆ\u0003J\t\u0010Y\u001a\u00020\nHÆ\u0003J\t\u0010Z\u001a\u00020\u0007HÆ\u0003J\t\u0010[\u001a\u00020\u0007HÆ\u0003J\t\u0010\\\u001a\u00020\u001dHÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0003HÆ\u0003J\t\u0010_\u001a\u00020\u0003HÆ\u0003J\u0010\u0010`\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010DJ¨\u0002\u0010a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0017\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u001b\u001a\u00020\u00072\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010bJ\u0013\u0010c\u001a\u00020\n2\b\u0010d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010e\u001a\u00020\u000eHÖ\u0001J\t\u0010f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010%R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010)R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b-\u0010)R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b.\u0010)R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010%R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b2\u0010%R\u0011\u0010\u0011\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b3\u0010%R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%R\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010%R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010%R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b8\u0010%R\u0011\u0010\u0017\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b9\u0010)R\u0011\u0010\u0018\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b:\u0010)R\u0011\u0010\u0019\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b;\u0010,R\u0011\u0010\u001a\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b<\u0010)R\u0011\u0010\u001b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b=\u0010)R\u0011\u0010\u001c\u001a\u00020\u001d¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010\u001e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010%R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010%R\u0011\u0010 \u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010%R\u0015\u0010!\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010E\u001a\u0004\bC\u0010D¨\u0006g"}, d2 = {"Lcom/obric/memorydata/database/dao/ProactiveInspirationRecommendationRow;", "", "inspirationId", "", "recommendId", "taskId", "inspirationCreated", "", "inspirationUpdated", "inspirationIsDelete", "", "inspirationTimestamp", "inspirationRowId", "recommendStatus", "", "inspirationFeedbackAction", "inspirationUserFeedback", "subscriptionId", "recommendText", "emoji", "actionExecuteInstruction", "actionContext", "sourcePackages", "recommendationCreated", "recommendationUpdated", "recommendationIsDelete", "recommendationTimestamp", "recommendationRowId", "score", "", InfoRequestQPSOptTraceLogger.REASON, "status", "type", "expireAtMs", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJZJJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJZJJDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getInspirationId", "()Ljava/lang/String;", "getRecommendId", "getTaskId", "getInspirationCreated", "()J", "getInspirationUpdated", "getInspirationIsDelete", "()Z", "getInspirationTimestamp", "getInspirationRowId", "getRecommendStatus", "()I", "getInspirationFeedbackAction", "getInspirationUserFeedback", "getSubscriptionId", "getRecommendText", "getEmoji", "getActionExecuteInstruction", "getActionContext", "getSourcePackages", "getRecommendationCreated", "getRecommendationUpdated", "getRecommendationIsDelete", "getRecommendationTimestamp", "getRecommendationRowId", "getScore", "()D", "getReason", "getStatus", "getType", "getExpireAtMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJZJJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJZJJDLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lcom/obric/memorydata/database/dao/ProactiveInspirationRecommendationRow;", "equals", "other", "hashCode", "toString", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveInspirationRecommendationRow {
    private final String actionContext;
    private final String actionExecuteInstruction;
    private final String emoji;
    private final Long expireAtMs;
    private final long inspirationCreated;
    private final String inspirationFeedbackAction;
    private final String inspirationId;
    private final boolean inspirationIsDelete;
    private final long inspirationRowId;
    private final long inspirationTimestamp;
    private final long inspirationUpdated;
    private final String inspirationUserFeedback;
    private final String reason;
    private final String recommendId;
    private final int recommendStatus;
    private final String recommendText;
    private final long recommendationCreated;
    private final boolean recommendationIsDelete;
    private final long recommendationRowId;
    private final long recommendationTimestamp;
    private final long recommendationUpdated;
    private final double score;
    private final String sourcePackages;
    private final String status;
    private final String subscriptionId;
    private final String taskId;
    private final String type;

    public ProactiveInspirationRecommendationRow(String r12, String r13, String r14, long r15, long r17, boolean r19, long r20, long r22, int r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, long r33, long r35, boolean r37, long r38, long r40, double r42, String r44, String r45, String r46, Long r47) {
        Intrinsics.checkNotNullParameter(r12, "inspirationId");
        Intrinsics.checkNotNullParameter(r13, "recommendId");
        Intrinsics.checkNotNullParameter(r14, "taskId");
        Intrinsics.checkNotNullParameter(r27, "subscriptionId");
        Intrinsics.checkNotNullParameter(r28, "recommendText");
        Intrinsics.checkNotNullParameter(r29, "emoji");
        Intrinsics.checkNotNullParameter(r44, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r45, "status");
        Intrinsics.checkNotNullParameter(r46, "type");
        this.inspirationId = r12;
        this.recommendId = r13;
        this.taskId = r14;
        this.inspirationCreated = r15;
        this.inspirationUpdated = r17;
        this.inspirationIsDelete = r19;
        this.inspirationTimestamp = r20;
        this.inspirationRowId = r22;
        this.recommendStatus = r24;
        this.inspirationFeedbackAction = r25;
        this.inspirationUserFeedback = r26;
        this.subscriptionId = r27;
        this.recommendText = r28;
        this.emoji = r29;
        this.actionExecuteInstruction = r30;
        this.actionContext = r31;
        this.sourcePackages = r32;
        this.recommendationCreated = r33;
        this.recommendationUpdated = r35;
        this.recommendationIsDelete = r37;
        this.recommendationTimestamp = r38;
        this.recommendationRowId = r40;
        this.score = r42;
        this.reason = r44;
        this.status = r45;
        this.type = r46;
        this.expireAtMs = r47;
    }

    public /* synthetic */ ProactiveInspirationRecommendationRow(String r39, String r40, String r41, long r42, long r44, boolean r46, long r47, long r49, int r51, String r52, String r53, String r54, String r55, String r56, String r57, String r58, String r59, long r60, long r62, boolean r64, long r65, long r67, double r69, String r71, String r72, String r73, Long r74, int r75, DefaultConstructorMarker r76) {
        if ((r75 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) == 0) goto L5;
        Long r37 = null;
    L6:
        this(r39, r40, r41, r42, r44, r46, r47, r49, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r62, r64, r65, r67, r69, r71, r72, r73, r37);
        return;
    L5:
        r37 = r74;
        goto L6
    }

    public static /* synthetic */ ProactiveInspirationRecommendationRow copy$default(ProactiveInspirationRecommendationRow r17, String r18, String r19, String r20, long r21, long r23, boolean r25, long r26, long r28, int r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, long r39, long r41, boolean r43, long r44, long r46, double r48, String r50, String r51, String r52, Long r53, int r54, Object r55) {
        if ((r54 & 1) == 0) goto L5;
        String r2 = r17.inspirationId;
    L7:
        if ((r54 & 2) == 0) goto L9;
        String r3 = r17.recommendId;
    L11:
        if ((r54 & 4) == 0) goto L13;
        String r4 = r17.taskId;
    L15:
        if ((r54 & 8) == 0) goto L17;
        long r5 = r17.inspirationCreated;
    L19:
        if ((r54 & 16) == 0) goto L21;
        long r7 = r17.inspirationUpdated;
    L23:
        if ((r54 & 32) == 0) goto L25;
        boolean r9 = r17.inspirationIsDelete;
    L27:
        if ((r54 & 64) == 0) goto L29;
        long r10 = r17.inspirationTimestamp;
    L31:
        if ((r54 & 128) == 0) goto L33;
        long r12 = r17.inspirationRowId;
    L35:
        if ((r54 & 256) == 0) goto L37;
        int r14 = r17.recommendStatus;
    L39:
        if ((r54 & 512) == 0) goto L41;
        String r15 = r17.inspirationFeedbackAction;
    L42:
        String r310 = r15;
        if ((r54 & 1024) == 0) goto L45;
        String r16 = r17.inspirationUserFeedback;
    L46:
        String r311 = r16;
        if ((r54 & 2048) == 0) goto L49;
        String r110 = r17.subscriptionId;
    L50:
        String r312 = r110;
        if ((r54 & 4096) == 0) goto L53;
        String r111 = r17.recommendText;
    L54:
        String r313 = r111;
        if ((r54 & 8192) == 0) goto L57;
        String r112 = r17.emoji;
    L58:
        String r314 = r112;
        if ((r54 & 16384) == 0) goto L61;
        String r113 = r17.actionExecuteInstruction;
    L62:
        String r315 = r113;
        if ((r54 & 32768) == 0) goto L65;
        String r114 = r17.actionContext;
    L66:
        String r316 = r114;
        if ((r54 & 65536) == 0) goto L69;
        String r115 = r17.sourcePackages;
    L70:
        int r317 = r14;
        String r318 = r115;
        if ((r54 & 131072) == 0) goto L73;
        long r116 = r17.recommendationCreated;
    L74:
        long r319 = r116;
        if ((r54 & 262144) == 0) goto L77;
        long r117 = r17.recommendationUpdated;
    L78:
        long r42 = r117;
        if ((r54 & 524288) == 0) goto L81;
        boolean r118 = r17.recommendationIsDelete;
    L82:
        boolean r45 = r118;
        if ((1048576 & r54) == 0) goto L85;
        long r119 = r17.recommendationTimestamp;
    L86:
        long r47 = r119;
        if ((r54 & 2097152) == 0) goto L89;
        long r120 = r17.recommendationRowId;
    L90:
        long r49 = r120;
        if ((r54 & 4194304) == 0) goto L93;
        double r121 = r17.score;
    L94:
        double r410 = r121;
        if ((r54 & 8388608) == 0) goto L97;
        String r122 = r17.reason;
    L99:
        if ((16777216 & r54) == 0) goto L101;
        String r123 = r17.status;
    L102:
        String r56 = r123;
        if ((r54 & 33554432) == 0) goto L105;
        String r124 = r17.type;
    L107:
        if ((r54 & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) == 0) goto L109;
        Long r1 = r17.expireAtMs;
    L111:
        return r17.copy(r2, r3, r4, r5, r7, r9, r10, r12, r317, r310, r311, r312, r313, r314, r315, r316, r318, r319, r42, r45, r47, r49, r410, r122, r56, r124, r1);
    L109:
        r1 = r53;
        goto L111
    L105:
        r124 = r52;
        goto L107
    L101:
        r123 = r51;
        goto L102
    L97:
        r122 = r50;
        goto L99
    L93:
        r121 = r48;
        goto L94
    L89:
        r120 = r46;
        goto L90
    L85:
        r119 = r44;
        goto L86
    L81:
        r118 = r43;
        goto L82
    L77:
        r117 = r41;
        goto L78
    L73:
        r116 = r39;
        goto L74
    L69:
        r115 = r38;
        goto L70
    L65:
        r114 = r37;
        goto L66
    L61:
        r113 = r36;
        goto L62
    L57:
        r112 = r35;
        goto L58
    L53:
        r111 = r34;
        goto L54
    L49:
        r110 = r33;
        goto L50
    L45:
        r16 = r32;
        goto L46
    L41:
        r15 = r31;
        goto L42
    L37:
        r14 = r30;
        goto L39
    L33:
        r12 = r28;
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
        return this.inspirationId;
    }

    public final String component10() {
        return this.inspirationFeedbackAction;
    }

    public final String component11() {
        return this.inspirationUserFeedback;
    }

    public final String component12() {
        return this.subscriptionId;
    }

    public final String component13() {
        return this.recommendText;
    }

    public final String component14() {
        return this.emoji;
    }

    public final String component15() {
        return this.actionExecuteInstruction;
    }

    public final String component16() {
        return this.actionContext;
    }

    public final String component17() {
        return this.sourcePackages;
    }

    public final long component18() {
        return this.recommendationCreated;
    }

    public final long component19() {
        return this.recommendationUpdated;
    }

    public final String component2() {
        return this.recommendId;
    }

    public final boolean component20() {
        return this.recommendationIsDelete;
    }

    public final long component21() {
        return this.recommendationTimestamp;
    }

    public final long component22() {
        return this.recommendationRowId;
    }

    public final double component23() {
        return this.score;
    }

    public final String component24() {
        return this.reason;
    }

    public final String component25() {
        return this.status;
    }

    public final String component26() {
        return this.type;
    }

    public final Long component27() {
        return this.expireAtMs;
    }

    public final String component3() {
        return this.taskId;
    }

    public final long component4() {
        return this.inspirationCreated;
    }

    public final long component5() {
        return this.inspirationUpdated;
    }

    public final boolean component6() {
        return this.inspirationIsDelete;
    }

    public final long component7() {
        return this.inspirationTimestamp;
    }

    public final long component8() {
        return this.inspirationRowId;
    }

    public final int component9() {
        return this.recommendStatus;
    }

    public final ProactiveInspirationRecommendationRow copy(String r39, String r40, String r41, long r42, long r44, boolean r46, long r47, long r49, int r51, String r52, String r53, String r54, String r55, String r56, String r57, String r58, String r59, long r60, long r62, boolean r64, long r65, long r67, double r69, String r71, String r72, String r73, Long r74) {
        Intrinsics.checkNotNullParameter(r39, "inspirationId");
        Intrinsics.checkNotNullParameter(r40, "recommendId");
        Intrinsics.checkNotNullParameter(r41, "taskId");
        Intrinsics.checkNotNullParameter(r54, "subscriptionId");
        Intrinsics.checkNotNullParameter(r55, "recommendText");
        Intrinsics.checkNotNullParameter(r56, "emoji");
        Intrinsics.checkNotNullParameter(r71, InfoRequestQPSOptTraceLogger.REASON);
        Intrinsics.checkNotNullParameter(r72, "status");
        Intrinsics.checkNotNullParameter(r73, "type");
        return new ProactiveInspirationRecommendationRow(r39, r40, r41, r42, r44, r46, r47, r49, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r62, r64, r65, r67, r69, r71, r72, r73, r74);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ProactiveInspirationRecommendationRow.class) == true) goto L8;
        return false;
    L8:
        ProactiveInspirationRecommendationRow r10 = (ProactiveInspirationRecommendationRow) ZeusTransformUtils.preCheckCast(r9, ProactiveInspirationRecommendationRow.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.inspirationId, r10.inspirationId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.recommendId, r10.recommendId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.taskId, r10.taskId) == true) goto L18;
        return false;
    L18:
        if (this.inspirationCreated == r10.inspirationCreated) goto L21;
        return false;
    L21:
        if (this.inspirationUpdated == r10.inspirationUpdated) goto L24;
        return false;
    L24:
        if (this.inspirationIsDelete == r10.inspirationIsDelete) goto L27;
        return false;
    L27:
        if (this.inspirationTimestamp == r10.inspirationTimestamp) goto L30;
        return false;
    L30:
        if (this.inspirationRowId == r10.inspirationRowId) goto L33;
        return false;
    L33:
        if (this.recommendStatus == r10.recommendStatus) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.inspirationFeedbackAction, r10.inspirationFeedbackAction) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.inspirationUserFeedback, r10.inspirationUserFeedback) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.subscriptionId, r10.subscriptionId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.recommendText, r10.recommendText) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.emoji, r10.emoji) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.actionExecuteInstruction, r10.actionExecuteInstruction) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.actionContext, r10.actionContext) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.sourcePackages, r10.sourcePackages) == true) goto L60;
        return false;
    L60:
        if (this.recommendationCreated == r10.recommendationCreated) goto L63;
        return false;
    L63:
        if (this.recommendationUpdated == r10.recommendationUpdated) goto L66;
        return false;
    L66:
        if (this.recommendationIsDelete == r10.recommendationIsDelete) goto L69;
        return false;
    L69:
        if (this.recommendationTimestamp == r10.recommendationTimestamp) goto L72;
        return false;
    L72:
        if (this.recommendationRowId == r10.recommendationRowId) goto L75;
        return false;
    L75:
        if (Double.compare(this.score, r10.score) == 0) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.reason, r10.reason) == true) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.status, r10.status) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.type, r10.type) == true) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.expireAtMs, r10.expireAtMs) == true) goto L89;
        return false;
    L89:
        return true;
    }

    public final String getActionContext() {
        return this.actionContext;
    }

    public final String getActionExecuteInstruction() {
        return this.actionExecuteInstruction;
    }

    public final String getEmoji() {
        return this.emoji;
    }

    public final Long getExpireAtMs() {
        return this.expireAtMs;
    }

    public final long getInspirationCreated() {
        return this.inspirationCreated;
    }

    public final String getInspirationFeedbackAction() {
        return this.inspirationFeedbackAction;
    }

    public final String getInspirationId() {
        return this.inspirationId;
    }

    public final boolean getInspirationIsDelete() {
        return this.inspirationIsDelete;
    }

    public final long getInspirationRowId() {
        return this.inspirationRowId;
    }

    public final long getInspirationTimestamp() {
        return this.inspirationTimestamp;
    }

    public final long getInspirationUpdated() {
        return this.inspirationUpdated;
    }

    public final String getInspirationUserFeedback() {
        return this.inspirationUserFeedback;
    }

    public final String getReason() {
        return this.reason;
    }

    public final String getRecommendId() {
        return this.recommendId;
    }

    public final int getRecommendStatus() {
        return this.recommendStatus;
    }

    public final String getRecommendText() {
        return this.recommendText;
    }

    public final long getRecommendationCreated() {
        return this.recommendationCreated;
    }

    public final boolean getRecommendationIsDelete() {
        return this.recommendationIsDelete;
    }

    public final long getRecommendationRowId() {
        return this.recommendationRowId;
    }

    public final long getRecommendationTimestamp() {
        return this.recommendationTimestamp;
    }

    public final long getRecommendationUpdated() {
        return this.recommendationUpdated;
    }

    public final double getScore() {
        return this.score;
    }

    public final String getSourcePackages() {
        return this.sourcePackages;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getSubscriptionId() {
        return this.subscriptionId;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int r0 = ((((((((((((((((this.inspirationId.hashCode() * 31) + this.recommendId.hashCode()) * 31) + this.taskId.hashCode()) * 31) + Long.hashCode(this.inspirationCreated)) * 31) + Long.hashCode(this.inspirationUpdated)) * 31) + Boolean.hashCode(this.inspirationIsDelete)) * 31) + Long.hashCode(this.inspirationTimestamp)) * 31) + Long.hashCode(this.inspirationRowId)) * 31) + Integer.hashCode(this.recommendStatus)) * 31;
        String r1 = this.inspirationFeedbackAction;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        String r5 = this.inspirationUserFeedback;
        if (r5 != null) goto L9;
        int r6 = 0;
    L10:
        int r7 = (((((((r4 + r6) * 31) + this.subscriptionId.hashCode()) * 31) + this.recommendText.hashCode()) * 31) + this.emoji.hashCode()) * 31;
        String r8 = this.actionExecuteInstruction;
        if (r8 != null) goto L13;
        int r9 = 0;
    L14:
        int r10 = (r7 + r9) * 31;
        String r11 = this.actionContext;
        if (r11 != null) goto L17;
        int r12 = 0;
    L18:
        int r13 = (r10 + r12) * 31;
        String r14 = this.sourcePackages;
        if (r14 != null) goto L21;
        int r15 = 0;
    L22:
        int r16 = (((((((((((((((((((r13 + r15) * 31) + Long.hashCode(this.recommendationCreated)) * 31) + Long.hashCode(this.recommendationUpdated)) * 31) + Boolean.hashCode(this.recommendationIsDelete)) * 31) + Long.hashCode(this.recommendationTimestamp)) * 31) + Long.hashCode(this.recommendationRowId)) * 31) + Double.hashCode(this.score)) * 31) + this.reason.hashCode()) * 31) + this.status.hashCode()) * 31) + this.type.hashCode()) * 31;
        Long r17 = this.expireAtMs;
        if (r17 == null) goto L27;
        r2 = r17.hashCode();
    L27:
        return r16 + r2;
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

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ProactiveInspirationRecommendationRow(inspirationId=").append(this.inspirationId).append(", recommendId=").append(this.recommendId).append(", taskId=").append(this.taskId).append(", inspirationCreated=").append(this.inspirationCreated).append(", inspirationUpdated=").append(this.inspirationUpdated).append(", inspirationIsDelete=").append(this.inspirationIsDelete).append(", inspirationTimestamp=").append(this.inspirationTimestamp).append(", inspirationRowId=").append(this.inspirationRowId).append(", recommendStatus=").append(this.recommendStatus).append(", inspirationFeedbackAction=").append(this.inspirationFeedbackAction).append(", inspirationUserFeedback=").append(this.inspirationUserFeedback).append(", subscriptionId=");
        r0.append(this.subscriptionId).append(", recommendText=").append(this.recommendText).append(", emoji=").append(this.emoji).append(", actionExecuteInstruction=").append(this.actionExecuteInstruction).append(", actionContext=").append(this.actionContext).append(", sourcePackages=").append(this.sourcePackages).append(", recommendationCreated=").append(this.recommendationCreated).append(", recommendationUpdated=").append(this.recommendationUpdated).append(", recommendationIsDelete=").append(this.recommendationIsDelete).append(", recommendationTimestamp=").append(this.recommendationTimestamp).append(", recommendationRowId=").append(this.recommendationRowId).append(", score=").append(this.score);
        r0.append(", reason=").append(this.reason).append(", status=").append(this.status).append(", type=").append(this.type).append(", expireAtMs=").append(this.expireAtMs).append(')');
        return r0.toString();
    }
}
