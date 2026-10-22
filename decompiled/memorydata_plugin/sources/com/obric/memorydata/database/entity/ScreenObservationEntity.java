package com.obric.memorydata.database.entity;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\bB\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 Y2\u00020\u0001:\u0001YB¿\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010>\u001a\u00020\u0003HÆ\u0003J\t\u0010?\u001a\u00020\u0003HÆ\u0003J\t\u0010@\u001a\u00020\u0006HÆ\u0003J\t\u0010A\u001a\u00020\u0006HÆ\u0003J\t\u0010B\u001a\u00020\u0006HÆ\u0003J\t\u0010C\u001a\u00020\u0006HÆ\u0003J\t\u0010D\u001a\u00020\u0006HÆ\u0003J\t\u0010E\u001a\u00020\u0006HÆ\u0003J\t\u0010F\u001a\u00020\u0006HÆ\u0003J\t\u0010G\u001a\u00020\u0006HÆ\u0003J\t\u0010H\u001a\u00020\u0006HÆ\u0003J\t\u0010I\u001a\u00020\u0006HÆ\u0003J\t\u0010J\u001a\u00020\u0006HÆ\u0003J\t\u0010K\u001a\u00020\u0012HÆ\u0003J\t\u0010L\u001a\u00020\u0006HÆ\u0003J\t\u0010M\u001a\u00020\u0012HÆ\u0003J\t\u0010N\u001a\u00020\u0012HÆ\u0003J\t\u0010O\u001a\u00020\u0012HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010Q\u001a\u00020\u0006HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0006HÆ\u0003Jß\u0001\u0010S\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00122\b\b\u0002\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u00122\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010T\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010W\u001a\u00020\u0012HÖ\u0001J\t\u0010X\u001a\u00020\u0006HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u001e\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010%R\u001e\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010 \"\u0004\b'\u0010%R\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0016\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0016\u0010\r\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010 R\u0016\u0010\u000e\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010 R\u0016\u0010\u000f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010 R\u0016\u0010\u0010\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010 R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001e\u0010\u0013\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010 \"\u0004\b3\u0010%R\u001e\u0010\u0014\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\u001e\u0010\u0015\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010/\"\u0004\b6\u00101R\u0016\u0010\u0016\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010/R \u0010\u0017\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010 \"\u0004\b9\u0010%R\u001e\u0010\u0018\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010 \"\u0004\b;\u0010%R \u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010 \"\u0004\b=\u0010%¨\u0006Z"}, d2 = {"Lcom/obric/memorydata/database/entity/ScreenObservationEntity;", "", OaidModel.KEY_ID, "", "timestamp", "triggerType", "", "appName", ObricMemoryConstants.KEY_PACKAGE_NAME, "screenshotPath", "imageTosKey", "location", "locationState", "movementState", "clickDetail", "scrollDetail", WsConstants.KEY_EXTRA, "state", "", TypedValues.AttributesType.S_TARGET, "filterResult", "isImageFilterFinished", "retryTime", "logId", "ruleIds", "activityName", "<init>", "(JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;IIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getTimestamp", "getTriggerType", "()Ljava/lang/String;", "getAppName", "getPackageName", "getScreenshotPath", "setScreenshotPath", "(Ljava/lang/String;)V", "getImageTosKey", "setImageTosKey", "getLocation", "getLocationState", "getMovementState", "getClickDetail", "getScrollDetail", "getExtra", "getState", "()I", "setState", "(I)V", "getTarget", "setTarget", "getFilterResult", "setFilterResult", "setImageFilterFinished", "getRetryTime", "getLogId", "setLogId", "getRuleIds", "setRuleIds", "getActivityName", "setActivityName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenObservationEntity {
    public static final a Companion = null;
    public static final int STATE_FINISHED = 2;
    public static final int STATE_NOT_PROCESS = 0;
    public static final int STATE_UPLOADED = 1;
    private String activityName;
    private final String appName;
    private final String clickDetail;
    private final String extra;
    private int filterResult;
    private final long id;
    private String imageTosKey;
    private int isImageFilterFinished;
    private final String location;
    private final String locationState;
    private String logId;
    private final String movementState;
    private final String packageName;
    private final int retryTime;
    private String ruleIds;
    private String screenshotPath;
    private final String scrollDetail;
    private int state;
    private String target;
    private final long timestamp;
    private final String triggerType;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/database/entity/ScreenObservationEntity$Companion;", "", "<init>", "()V", "STATE_NOT_PROCESS", "", "STATE_UPLOADED", "STATE_FINISHED", "fromJson", "Lcom/obric/memorydata/database/entity/ScreenObservationEntity;", "jsonObject", "Lorg/json/JSONObject;", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public ScreenObservationEntity(long r17, long r19, String r21, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, int r32, String r33, int r34, int r35, int r36, String r37, String r38, String r39) {
        Intrinsics.checkNotNullParameter(r21, "triggerType");
        Intrinsics.checkNotNullParameter(r22, "appName");
        Intrinsics.checkNotNullParameter(r23, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r24, "screenshotPath");
        Intrinsics.checkNotNullParameter(r25, "imageTosKey");
        Intrinsics.checkNotNullParameter(r26, "location");
        Intrinsics.checkNotNullParameter(r27, "locationState");
        Intrinsics.checkNotNullParameter(r28, "movementState");
        Intrinsics.checkNotNullParameter(r29, "clickDetail");
        Intrinsics.checkNotNullParameter(r30, "scrollDetail");
        Intrinsics.checkNotNullParameter(r31, WsConstants.KEY_EXTRA);
        Intrinsics.checkNotNullParameter(r33, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r38, "ruleIds");
        this.id = r17;
        this.timestamp = r19;
        this.triggerType = r21;
        this.appName = r22;
        this.packageName = r23;
        this.screenshotPath = r24;
        this.imageTosKey = r25;
        this.location = r26;
        this.locationState = r27;
        this.movementState = r28;
        this.clickDetail = r29;
        this.scrollDetail = r30;
        this.extra = r31;
        this.state = r32;
        this.target = r33;
        this.filterResult = r34;
        this.isImageFilterFinished = r35;
        this.retryTime = r36;
        this.logId = r37;
        this.ruleIds = r38;
        this.activityName = r39;
    }

    public /* synthetic */ ScreenObservationEntity(long r28, long r30, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, String r41, String r42, int r43, String r44, int r45, int r46, int r47, String r48, String r49, String r50, int r51, DefaultConstructorMarker r52) {
        if ((r51 & 1) == 0) goto L5;
        long r4 = 0;
    L7:
        if ((r51 & 16384) == 0) goto L9;
        String r20 = "screenObservation";
    L11:
        if ((131072 & r51) == 0) goto L13;
        int r23 = 0;
    L15:
        if ((262144 & r51) == 0) goto L17;
        String r24 = null;
    L19:
        if ((524288 & r51) == 0) goto L21;
        String r25 = "ALL";
    L23:
        if ((r51 & 1048576) == 0) goto L25;
        String r26 = null;
    L26:
        this(r4, r30, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r20, r45, r46, r23, r24, r25, r26);
        return;
    L25:
        r26 = r50;
        goto L26
    L21:
        r25 = r49;
        goto L23
    L17:
        r24 = r48;
        goto L19
    L13:
        r23 = r47;
        goto L15
    L9:
        r20 = r44;
        goto L11
    L5:
        r4 = r28;
        goto L7
    }

    public static /* synthetic */ ScreenObservationEntity copy$default(ScreenObservationEntity r17, long r18, long r20, String r22, String r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, int r33, String r34, int r35, int r36, int r37, String r38, String r39, String r40, int r41, Object r42) {
        if ((r41 & 1) == 0) goto L5;
        long r2 = r17.id;
    L7:
        if ((r41 & 2) == 0) goto L9;
        long r4 = r17.timestamp;
    L11:
        if ((r41 & 4) == 0) goto L13;
        String r6 = r17.triggerType;
    L15:
        if ((r41 & 8) == 0) goto L17;
        String r7 = r17.appName;
    L19:
        if ((r41 & 16) == 0) goto L21;
        String r8 = r17.packageName;
    L23:
        if ((r41 & 32) == 0) goto L25;
        String r9 = r17.screenshotPath;
    L27:
        if ((r41 & 64) == 0) goto L29;
        String r10 = r17.imageTosKey;
    L31:
        if ((r41 & 128) == 0) goto L33;
        String r11 = r17.location;
    L35:
        if ((r41 & 256) == 0) goto L37;
        String r12 = r17.locationState;
    L39:
        if ((r41 & 512) == 0) goto L41;
        String r13 = r17.movementState;
    L43:
        if ((r41 & 1024) == 0) goto L45;
        String r14 = r17.clickDetail;
    L47:
        if ((r41 & 2048) == 0) goto L49;
        String r15 = r17.scrollDetail;
    L50:
        String r310 = r15;
        if ((r41 & 4096) == 0) goto L53;
        String r16 = r17.extra;
    L54:
        String r311 = r16;
        if ((r41 & 8192) == 0) goto L57;
        int r19 = r17.state;
    L58:
        int r312 = r19;
        if ((r41 & 16384) == 0) goto L61;
        String r110 = r17.target;
    L62:
        String r313 = r110;
        if ((r41 & 32768) == 0) goto L65;
        int r111 = r17.filterResult;
    L66:
        int r314 = r111;
        if ((r41 & 65536) == 0) goto L69;
        int r112 = r17.isImageFilterFinished;
    L70:
        int r315 = r112;
        if ((r41 & 131072) == 0) goto L73;
        int r113 = r17.retryTime;
    L74:
        int r316 = r113;
        if ((r41 & 262144) == 0) goto L77;
        String r114 = r17.logId;
    L78:
        String r317 = r114;
        if ((r41 & 524288) == 0) goto L81;
        String r115 = r17.ruleIds;
    L83:
        if ((r41 & 1048576) == 0) goto L85;
        String r1 = r17.activityName;
    L87:
        return r17.copy(r2, r4, r6, r7, r8, r9, r10, r11, r12, r13, r14, r310, r311, r312, r313, r314, r315, r316, r317, r115, r1);
    L85:
        r1 = r40;
        goto L87
    L81:
        r115 = r39;
        goto L83
    L77:
        r114 = r38;
        goto L78
    L73:
        r113 = r37;
        goto L74
    L69:
        r112 = r36;
        goto L70
    L65:
        r111 = r35;
        goto L66
    L61:
        r110 = r34;
        goto L62
    L57:
        r19 = r33;
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
        r8 = r24;
        goto L23
    L17:
        r7 = r23;
        goto L19
    L13:
        r6 = r22;
        goto L15
    L9:
        r4 = r20;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final long component1() {
        return this.id;
    }

    public final String component10() {
        return this.movementState;
    }

    public final String component11() {
        return this.clickDetail;
    }

    public final String component12() {
        return this.scrollDetail;
    }

    public final String component13() {
        return this.extra;
    }

    public final int component14() {
        return this.state;
    }

    public final String component15() {
        return this.target;
    }

    public final int component16() {
        return this.filterResult;
    }

    public final int component17() {
        return this.isImageFilterFinished;
    }

    public final int component18() {
        return this.retryTime;
    }

    public final String component19() {
        return this.logId;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final String component20() {
        return this.ruleIds;
    }

    public final String component21() {
        return this.activityName;
    }

    public final String component3() {
        return this.triggerType;
    }

    public final String component4() {
        return this.appName;
    }

    public final String component5() {
        return this.packageName;
    }

    public final String component6() {
        return this.screenshotPath;
    }

    public final String component7() {
        return this.imageTosKey;
    }

    public final String component8() {
        return this.location;
    }

    public final String component9() {
        return this.locationState;
    }

    public final ScreenObservationEntity copy(long r26, long r28, String r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, int r41, String r42, int r43, int r44, int r45, String r46, String r47, String r48) {
        Intrinsics.checkNotNullParameter(r30, "triggerType");
        Intrinsics.checkNotNullParameter(r31, "appName");
        Intrinsics.checkNotNullParameter(r32, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r33, "screenshotPath");
        Intrinsics.checkNotNullParameter(r34, "imageTosKey");
        Intrinsics.checkNotNullParameter(r35, "location");
        Intrinsics.checkNotNullParameter(r36, "locationState");
        Intrinsics.checkNotNullParameter(r37, "movementState");
        Intrinsics.checkNotNullParameter(r38, "clickDetail");
        Intrinsics.checkNotNullParameter(r39, "scrollDetail");
        Intrinsics.checkNotNullParameter(r40, WsConstants.KEY_EXTRA);
        Intrinsics.checkNotNullParameter(r42, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r47, "ruleIds");
        return new ScreenObservationEntity(r26, r28, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, ScreenObservationEntity.class) == true) goto L8;
        return false;
    L8:
        ScreenObservationEntity r10 = (ScreenObservationEntity) ZeusTransformUtils.preCheckCast(r9, ScreenObservationEntity.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (this.timestamp == r10.timestamp) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.triggerType, r10.triggerType) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.appName, r10.appName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.packageName, r10.packageName) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.screenshotPath, r10.screenshotPath) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.imageTosKey, r10.imageTosKey) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.location, r10.location) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.locationState, r10.locationState) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.movementState, r10.movementState) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.clickDetail, r10.clickDetail) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.scrollDetail, r10.scrollDetail) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.extra, r10.extra) == true) goto L48;
        return false;
    L48:
        if (this.state == r10.state) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.target, r10.target) == true) goto L54;
        return false;
    L54:
        if (this.filterResult == r10.filterResult) goto L57;
        return false;
    L57:
        if (this.isImageFilterFinished == r10.isImageFilterFinished) goto L60;
        return false;
    L60:
        if (this.retryTime == r10.retryTime) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.logId, r10.logId) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.ruleIds, r10.ruleIds) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.activityName, r10.activityName) == true) goto L71;
        return false;
    L71:
        return true;
    }

    public final String getActivityName() {
        return this.activityName;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getClickDetail() {
        return this.clickDetail;
    }

    public final String getExtra() {
        return this.extra;
    }

    public final int getFilterResult() {
        return this.filterResult;
    }

    public final long getId() {
        return this.id;
    }

    public final String getImageTosKey() {
        return this.imageTosKey;
    }

    public final String getLocation() {
        return this.location;
    }

    public final String getLocationState() {
        return this.locationState;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final String getMovementState() {
        return this.movementState;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final int getRetryTime() {
        return this.retryTime;
    }

    public final String getRuleIds() {
        return this.ruleIds;
    }

    public final String getScreenshotPath() {
        return this.screenshotPath;
    }

    public final String getScrollDetail() {
        return this.scrollDetail;
    }

    public final int getState() {
        return this.state;
    }

    public final String getTarget() {
        return this.target;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final String getTriggerType() {
        return this.triggerType;
    }

    public int hashCode() {
        int r0 = ((((((((((((((((((((((((((((((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.timestamp)) * 31) + this.triggerType.hashCode()) * 31) + this.appName.hashCode()) * 31) + this.packageName.hashCode()) * 31) + this.screenshotPath.hashCode()) * 31) + this.imageTosKey.hashCode()) * 31) + this.location.hashCode()) * 31) + this.locationState.hashCode()) * 31) + this.movementState.hashCode()) * 31) + this.clickDetail.hashCode()) * 31) + this.scrollDetail.hashCode()) * 31) + this.extra.hashCode()) * 31) + Integer.hashCode(this.state)) * 31) + this.target.hashCode()) * 31) + Integer.hashCode(this.filterResult)) * 31) + Integer.hashCode(this.isImageFilterFinished)) * 31) + Integer.hashCode(this.retryTime)) * 31;
        String r1 = this.logId;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (((r0 + r3) * 31) + this.ruleIds.hashCode()) * 31;
        String r5 = this.activityName;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final int isImageFilterFinished() {
        return this.isImageFilterFinished;
    }

    public final void setActivityName(String r1) {
        this.activityName = r1;
    }

    public final void setFilterResult(int r1) {
        this.filterResult = r1;
    }

    public final void setImageFilterFinished(int r1) {
        this.isImageFilterFinished = r1;
    }

    public final void setImageTosKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.imageTosKey = r2;
    }

    public final void setLogId(String r1) {
        this.logId = r1;
    }

    public final void setRuleIds(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.ruleIds = r2;
    }

    public final void setScreenshotPath(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.screenshotPath = r2;
    }

    public final void setState(int r1) {
        this.state = r1;
    }

    public final void setTarget(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.target = r2;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("ScreenObservationEntity(id=").append(this.id).append(", timestamp=").append(this.timestamp).append(", triggerType=").append(this.triggerType).append(", appName=").append(this.appName).append(", packageName=").append(this.packageName).append(", screenshotPath=").append(this.screenshotPath).append(", imageTosKey=").append(this.imageTosKey).append(", location=").append(this.location).append(", locationState=").append(this.locationState).append(", movementState=").append(this.movementState).append(", clickDetail=").append(this.clickDetail).append(", scrollDetail=");
        r0.append(this.scrollDetail).append(", extra=").append(this.extra).append(", state=").append(this.state).append(", target=").append(this.target).append(", filterResult=").append(this.filterResult).append(", isImageFilterFinished=").append(this.isImageFilterFinished).append(", retryTime=").append(this.retryTime).append(", logId=").append(this.logId).append(", ruleIds=").append(this.ruleIds).append(", activityName=").append(this.activityName).append(')');
        return r0.toString();
    }
}
