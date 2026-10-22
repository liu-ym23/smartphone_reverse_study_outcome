package com.obric.memorydata.database.entity;

import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 :2\u00020\u0001:\u0001:B\u007f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0005HÆ\u0003J\t\u0010*\u001a\u00020\u0005HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0005HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\t\u00102\u001a\u00020\u000fHÆ\u0003J\t\u00103\u001a\u00020\u000fHÆ\u0003J\u0081\u0001\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fHÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u00020\u000fHÖ\u0001J\t\u00109\u001a\u00020\u0005HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0016\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0016\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0016\u0010\u000b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u001e\u0010\f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\r\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u001fR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010%¨\u0006;"}, d2 = {"Lcom/obric/memorydata/database/entity/RawObservationEntity;", "", OaidModel.KEY_ID, "", "deviceId", "", AILabCheckPermissionTask.KEY_SOURCE, "timestamp", "spanStart", "spanEnd", "payload", "meta", "state", "clientState", "retryCount", "", "lastErrorCode", "<init>", "(JLjava/lang/String;Ljava/lang/String;JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "getId", "()J", "getDeviceId", "()Ljava/lang/String;", "getSource", "getTimestamp", "getSpanStart", "getSpanEnd", "getPayload", "getMeta", "getState", "setState", "(Ljava/lang/String;)V", "getClientState", "setClientState", "getRetryCount", "()I", "setRetryCount", "(I)V", "getLastErrorCode", "setLastErrorCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RawObservationEntity {
    public static final String CLIENT_STATE_DONE = "DONE";
    public static final String CLIENT_STATE_NONE = "NONE";
    public static final String CLIENT_STATE_PENDING = "PENDING";
    public static final a Companion = null;
    public static final String STATE_DONE = "DONE";
    public static final String STATE_FAILED = "FAILED";
    public static final String STATE_PENDING = "PENDING";
    public static final String STATE_WAIT_DEPENDENCY = "WAIT_DEPENDENCY";
    public static final String STATE_WAIT_MEDIA = "WAIT_MEDIA";
    private String clientState;
    private final String deviceId;
    private final long id;
    private int lastErrorCode;
    private final String meta;
    private final String payload;
    private int retryCount;
    private final String source;
    private final long spanEnd;
    private final long spanStart;
    private String state;
    private final long timestamp;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/database/entity/RawObservationEntity$Companion;", "", "<init>", "()V", "STATE_WAIT_MEDIA", "", "STATE_WAIT_DEPENDENCY", "STATE_PENDING", "STATE_DONE", "STATE_FAILED", "CLIENT_STATE_NONE", "CLIENT_STATE_PENDING", "CLIENT_STATE_DONE", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public RawObservationEntity() {
        this(0, null, null, 0, 0, 0, null, null, null, null, 0, 0, 4095, null);
    }

    public RawObservationEntity(long r10, String r12, String r13, long r14, long r16, long r18, String r20, String r21, String r22, String r23, int r24, int r25) {
        Intrinsics.checkNotNullParameter(r12, "deviceId");
        Intrinsics.checkNotNullParameter(r13, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r20, "payload");
        Intrinsics.checkNotNullParameter(r21, "meta");
        Intrinsics.checkNotNullParameter(r22, "state");
        Intrinsics.checkNotNullParameter(r23, "clientState");
        this.id = r10;
        this.deviceId = r12;
        this.source = r13;
        this.timestamp = r14;
        this.spanStart = r16;
        this.spanEnd = r18;
        this.payload = r20;
        this.meta = r21;
        this.state = r22;
        this.clientState = r23;
        this.retryCount = r24;
        this.lastErrorCode = r25;
    }

    public /* synthetic */ RawObservationEntity(long r18, String r20, String r21, long r22, long r24, long r26, String r28, String r29, String r30, String r31, int r32, int r33, int r34, DefaultConstructorMarker r35) {
        long r2 = 0;
        if ((r34 & 1) == 0) goto L5;
        long r4 = 0;
    L6:
        String r6 = "";
        if ((r34 & 2) == 0) goto L9;
        String r1 = "";
    L11:
        if ((r34 & 4) == 0) goto L13;
        String r7 = "";
    L15:
        if ((r34 & 8) == 0) goto L17;
        long r8 = 0;
    L19:
        if ((r34 & 16) == 0) goto L21;
        long r10 = 0;
    L23:
        if ((r34 & 32) != 0) goto L27;
        r2 = r26;
    L27:
        if ((r34 & 64) == 0) goto L29;
        String r12 = "";
    L31:
        if ((r34 & 128) != 0) goto L35;
        r6 = r29;
    L35:
        if ((r34 & 256) == 0) goto L37;
        String r13 = "PENDING";
    L39:
        if ((r34 & 512) == 0) goto L41;
        String r14 = "NONE";
    L42:
        int r16 = 0;
        if ((r34 & 1024) == 0) goto L45;
        int r15 = 0;
    L47:
        if ((r34 & 2048) != 0) goto L50;
        r16 = r33;
    L50:
        this(r4, r1, r7, r8, r10, r2, r12, r6, r13, r14, r15, r16);
        return;
    L45:
        r15 = r32;
        goto L47
    L41:
        r14 = r31;
        goto L42
    L37:
        r13 = r30;
        goto L39
    L29:
        r12 = r28;
        goto L31
    L21:
        r10 = r24;
        goto L23
    L17:
        r8 = r22;
        goto L19
    L13:
        r7 = r21;
        goto L15
    L9:
        r1 = r20;
        goto L11
    L5:
        r4 = r18;
        goto L6
    }

    public static /* synthetic */ RawObservationEntity copy$default(RawObservationEntity r16, long r17, String r19, String r20, long r21, long r23, long r25, String r27, String r28, String r29, String r30, int r31, int r32, int r33, Object r34) {
        if ((r33 & 1) == 0) goto L5;
        long r2 = r16.id;
    L7:
        if ((r33 & 2) == 0) goto L9;
        String r4 = r16.deviceId;
    L11:
        if ((r33 & 4) == 0) goto L13;
        String r5 = r16.source;
    L15:
        if ((r33 & 8) == 0) goto L17;
        long r6 = r16.timestamp;
    L19:
        if ((r33 & 16) == 0) goto L21;
        long r8 = r16.spanStart;
    L23:
        if ((r33 & 32) == 0) goto L25;
        long r10 = r16.spanEnd;
    L27:
        if ((r33 & 64) == 0) goto L29;
        String r12 = r16.payload;
    L31:
        if ((r33 & 128) == 0) goto L33;
        String r13 = r16.meta;
    L35:
        if ((r33 & 256) == 0) goto L37;
        String r14 = r16.state;
    L39:
        if ((r33 & 512) == 0) goto L41;
        String r15 = r16.clientState;
    L42:
        String r35 = r15;
        if ((r33 & 1024) == 0) goto L45;
        int r18 = r16.retryCount;
    L47:
        if ((r33 & 2048) == 0) goto L49;
        int r1 = r16.lastErrorCode;
    L51:
        return r16.copy(r2, r4, r5, r6, r8, r10, r12, r13, r14, r35, r18, r1);
    L49:
        r1 = r32;
        goto L51
    L45:
        r18 = r31;
        goto L47
    L41:
        r15 = r30;
        goto L42
    L37:
        r14 = r29;
        goto L39
    L33:
        r13 = r28;
        goto L35
    L29:
        r12 = r27;
        goto L31
    L25:
        r10 = r25;
        goto L27
    L21:
        r8 = r23;
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
        return this.clientState;
    }

    public final int component11() {
        return this.retryCount;
    }

    public final int component12() {
        return this.lastErrorCode;
    }

    public final String component2() {
        return this.deviceId;
    }

    public final String component3() {
        return this.source;
    }

    public final long component4() {
        return this.timestamp;
    }

    public final long component5() {
        return this.spanStart;
    }

    public final long component6() {
        return this.spanEnd;
    }

    public final String component7() {
        return this.payload;
    }

    public final String component8() {
        return this.meta;
    }

    public final String component9() {
        return this.state;
    }

    public final RawObservationEntity copy(long r19, String r21, String r22, long r23, long r25, long r27, String r29, String r30, String r31, String r32, int r33, int r34) {
        Intrinsics.checkNotNullParameter(r21, "deviceId");
        Intrinsics.checkNotNullParameter(r22, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r29, "payload");
        Intrinsics.checkNotNullParameter(r30, "meta");
        Intrinsics.checkNotNullParameter(r31, "state");
        Intrinsics.checkNotNullParameter(r32, "clientState");
        return new RawObservationEntity(r19, r21, r22, r23, r25, r27, r29, r30, r31, r32, r33, r34);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, RawObservationEntity.class) == true) goto L8;
        return false;
    L8:
        RawObservationEntity r10 = (RawObservationEntity) ZeusTransformUtils.preCheckCast(r9, RawObservationEntity.class, "com.obric.memorydata.plugin");
        if (this.id == r10.id) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.deviceId, r10.deviceId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.source, r10.source) == true) goto L18;
        return false;
    L18:
        if (this.timestamp == r10.timestamp) goto L21;
        return false;
    L21:
        if (this.spanStart == r10.spanStart) goto L24;
        return false;
    L24:
        if (this.spanEnd == r10.spanEnd) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.payload, r10.payload) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.meta, r10.meta) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.state, r10.state) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.clientState, r10.clientState) == true) goto L39;
        return false;
    L39:
        if (this.retryCount == r10.retryCount) goto L42;
        return false;
    L42:
        if (this.lastErrorCode == r10.lastErrorCode) goto L44;
        return false;
    L44:
        return true;
    }

    public final String getClientState() {
        return this.clientState;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final long getId() {
        return this.id;
    }

    public final int getLastErrorCode() {
        return this.lastErrorCode;
    }

    public final String getMeta() {
        return this.meta;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final int getRetryCount() {
        return this.retryCount;
    }

    public final String getSource() {
        return this.source;
    }

    public final long getSpanEnd() {
        return this.spanEnd;
    }

    public final long getSpanStart() {
        return this.spanStart;
    }

    public final String getState() {
        return this.state;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((((((((((((((((((((Long.hashCode(this.id) * 31) + this.deviceId.hashCode()) * 31) + this.source.hashCode()) * 31) + Long.hashCode(this.timestamp)) * 31) + Long.hashCode(this.spanStart)) * 31) + Long.hashCode(this.spanEnd)) * 31) + this.payload.hashCode()) * 31) + this.meta.hashCode()) * 31) + this.state.hashCode()) * 31) + this.clientState.hashCode()) * 31) + Integer.hashCode(this.retryCount)) * 31) + Integer.hashCode(this.lastErrorCode);
    }

    public final void setClientState(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.clientState = r2;
    }

    public final void setLastErrorCode(int r1) {
        this.lastErrorCode = r1;
    }

    public final void setRetryCount(int r1) {
        this.retryCount = r1;
    }

    public final void setState(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.state = r2;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("RawObservationEntity(id=").append(this.id).append(", deviceId=").append(this.deviceId).append(", source=").append(this.source).append(", timestamp=").append(this.timestamp).append(", spanStart=").append(this.spanStart).append(", spanEnd=").append(this.spanEnd).append(", payload=").append(this.payload).append(", meta=").append(this.meta).append(", state=").append(this.state).append(", clientState=").append(this.clientState).append(", retryCount=").append(this.retryCount).append(", lastErrorCode=");
        r0.append(this.lastErrorCode).append(')');
        return r0.toString();
    }
}
