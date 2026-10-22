package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.y;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bw\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010%\u001a\u00020\u0006J\u0018\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003J\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020)J\u001a\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0006HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0003HÆ\u0003J\t\u00108\u001a\u00020\u0003HÆ\u0003Jy\u00109\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010:\u001a\u00020\u00062\b\u0010;\u001a\u0004\u0018\u00010<HÖ\u0003J\t\u0010=\u001a\u00020>HÖ\u0001J\t\u0010?\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0013R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\r\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u001f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0013R\u000e\u0010!\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010#\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b$\u0010\u0013¨\u0006@"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/statistics/core/MmRecordingCommonParam;", "Ljava/io/Serializable;", AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN, "", "recordId", "isHardware", "", "entrance", "meetingId", "userId", "recordingTraceId", "source", "Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;", "tenantId", "vcRecordingId", "sessionType", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getToken", "()Ljava/lang/String;", "getRecordId", "()Z", "getEntrance", "getMeetingId", "getUserId", "getRecordingTraceId", "getSource", "()Lcom/ss/android/lark/officesdk/minutes/api/recording/common/data/MmRecordingSource;", "getTenantId", "getVcRecordingId", "getSessionType", "encryptedUserId", "getEncryptedUserId", "encryptedTenantId", "createSourceForTracker", "trackerRecordId", "getTrackerRecordId", "isValid", "withRecordingIdReady", "recordingId", "asTrackerParams", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/statistics/core/MmRecordingTrackerParams;", "asRecordingDevTrackerParams", "putCommonParamsTo", "Lorg/json/JSONObject;", "jsonObject", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "", "hashCode", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmRecordingCommonParam implements Serializable {
    private final String createSourceForTracker;
    private final String encryptedTenantId;
    private final String encryptedUserId;
    private final String entrance;
    private final boolean isHardware;
    private final String meetingId;
    private final String recordId;
    private final String recordingTraceId;
    private final String sessionType;
    private final MmRecordingSource source;
    private final String tenantId;
    private final String token;
    private final String userId;
    private final String vcRecordingId;

    public MmRecordingCommonParam() {
        this(null, null, false, null, null, null, null, null, null, null, null, 2047, null);
    }

    public static /* synthetic */ MmRecordingCommonParam copy$default(MmRecordingCommonParam r12, String r13, String r14, boolean r15, String r16, String r17, String r18, String r19, MmRecordingSource r20, String r21, String r22, String r23, int r24, Object r25) {
        if ((r24 & 1) == 0) goto L5;
        String r2 = r12.token;
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = r12.recordId;
    L11:
        if ((r24 & 4) == 0) goto L13;
        boolean r4 = r12.isHardware;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r5 = r12.entrance;
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = r12.meetingId;
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r7 = r12.userId;
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r8 = r12.recordingTraceId;
    L31:
        if ((r24 & 128) == 0) goto L33;
        MmRecordingSource r9 = r12.source;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r10 = r12.tenantId;
    L39:
        if ((r24 & 512) == 0) goto L41;
        String r11 = r12.vcRecordingId;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        String r1 = r12.sessionType;
    L47:
        return r12.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r1);
    L45:
        r1 = r23;
        goto L47
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r2 = r13;
        goto L7
    }

    public final String component1() {
        return this.token;
    }

    public final String component10() {
        return this.vcRecordingId;
    }

    public final String component11() {
        return this.sessionType;
    }

    public final String component2() {
        return this.recordId;
    }

    public final boolean component3() {
        return this.isHardware;
    }

    public final String component4() {
        return this.entrance;
    }

    public final String component5() {
        return this.meetingId;
    }

    public final String component6() {
        return this.userId;
    }

    public final String component7() {
        return this.recordingTraceId;
    }

    public final MmRecordingSource component8() {
        return this.source;
    }

    public final String component9() {
        return this.tenantId;
    }

    public final MmRecordingCommonParam copy(String r14, String r15, boolean r16, String r17, String r18, String r19, String r20, MmRecordingSource r21, String r22, String r23, String r24) {
        Intrinsics.checkNotNullParameter(r14, AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN);
        Intrinsics.checkNotNullParameter(r15, "recordId");
        Intrinsics.checkNotNullParameter(r17, "entrance");
        Intrinsics.checkNotNullParameter(r18, "meetingId");
        Intrinsics.checkNotNullParameter(r19, "userId");
        Intrinsics.checkNotNullParameter(r20, "recordingTraceId");
        Intrinsics.checkNotNullParameter(r22, "tenantId");
        Intrinsics.checkNotNullParameter(r23, "vcRecordingId");
        Intrinsics.checkNotNullParameter(r24, "sessionType");
        return new MmRecordingCommonParam(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmRecordingCommonParam) == true) goto L8;
        return false;
    L8:
        MmRecordingCommonParam r6 = (MmRecordingCommonParam) r5;
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.recordId, r6.recordId) == true) goto L15;
        return false;
    L15:
        if (this.isHardware == r6.isHardware) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.entrance, r6.entrance) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.meetingId, r6.meetingId) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.userId, r6.userId) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.recordingTraceId, r6.recordingTraceId) == true) goto L30;
        return false;
    L30:
        if (this.source == r6.source) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.tenantId, r6.tenantId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.vcRecordingId, r6.vcRecordingId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.sessionType, r6.sessionType) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.token.hashCode() * 31) + this.recordId.hashCode()) * 31;
        if (this.isHardware == false) goto L5;
        int r1 = 1231;
    L6:
        int r2 = (((((((((r0 + r1) * 31) + this.entrance.hashCode()) * 31) + this.meetingId.hashCode()) * 31) + this.userId.hashCode()) * 31) + this.recordingTraceId.hashCode()) * 31;
        MmRecordingSource r3 = this.source;
        if (r3 != null) goto L9;
        int r4 = 0;
    L11:
        return ((((((r2 + r4) * 31) + this.tenantId.hashCode()) * 31) + this.vcRecordingId.hashCode()) * 31) + this.sessionType.hashCode();
    L9:
        r4 = r3.hashCode();
        goto L11
    L5:
        r1 = 1237;
        goto L6
    }

    public String toString() {
        return "MmRecordingCommonParam(token=" + this.token + ", recordId=" + this.recordId + ", isHardware=" + this.isHardware + ", entrance=" + this.entrance + ", meetingId=" + this.meetingId + ", userId=" + this.userId + ", recordingTraceId=" + this.recordingTraceId + ", source=" + this.source + ", tenantId=" + this.tenantId + ", vcRecordingId=" + this.vcRecordingId + ", sessionType=" + this.sessionType + ')';
    }

    public final d asRecordingDevTrackerParams() {
        if (Intrinsics.areEqual(this.sessionType, "STANDALONE_AI_INTERPRETATION") == true) goto L13;
        MmRecordingSource r0 = this.source;
        if (r0 == null) goto L9;
        boolean r1 = true;
        if (r0.isStandaloneAIInterpretationSource() != true) goto L9;
    L10:
        if (r1 == true) goto L13;
        String r2 = "record";
    L14:
        d r3 = asTrackerParams();
        r3.e("scene", r2);
        return r3;
    L9:
        r1 = false;
    L13:
        r2 = "independent_si";
        goto L14
    }

    public final d asTrackerParams() {
        d r0 = new d();
        r0.e(AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN, this.token);
        r0.e("record_id", getTrackerRecordId());
        r0.e("vc_recording_id", this.vcRecordingId);
        r0.e("recording_trace_id", this.recordingTraceId);
        r0.e("lark_user_unique_id", this.encryptedUserId);
        r0.e("is_hardware", String.valueOf(this.isHardware));
        r0.e("conference_id", this.meetingId);
        r0.e("create_app", this.createSourceForTracker);
        r0.e("session_type", this.sessionType);
        MmRecordingSource r1 = this.source;
        if (r1 == null) goto L7;
        boolean r2 = true;
        if (r1.isFeishuHost() != true) goto L7;
    L8:
        if (r2 == true) goto L10;
        r0.e("tenant_id", this.encryptedTenantId);
    L10:
        return r0;
    L7:
        r2 = false;
        goto L8
    }

    public final String getTrackerRecordId() {
        if (this.isHardware == false) goto L6;
        return this.recordId;
    L6:
        return this.meetingId;
    }

    public final boolean isValid() {
        if (this.meetingId.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getEncryptedUserId() {
        return this.encryptedUserId;
    }

    public final String getEntrance() {
        return this.entrance;
    }

    public final String getMeetingId() {
        return this.meetingId;
    }

    public final String getRecordId() {
        return this.recordId;
    }

    public final String getRecordingTraceId() {
        return this.recordingTraceId;
    }

    public final String getSessionType() {
        return this.sessionType;
    }

    public final MmRecordingSource getSource() {
        return this.source;
    }

    public final String getTenantId() {
        return this.tenantId;
    }

    public final String getToken() {
        return this.token;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final String getVcRecordingId() {
        return this.vcRecordingId;
    }

    public final boolean isHardware() {
        return this.isHardware;
    }

    public final JSONObject putCommonParamsTo(JSONObject r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "jsonObject");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        r4.put(AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN, this.token);     // Catch: Throwable -> L15
        r4.put("record_id", getTrackerRecordId());     // Catch: Throwable -> L15
        r4.put("vc_recording_id", this.vcRecordingId);     // Catch: Throwable -> L15
        r4.put("recording_trace_id", this.recordingTraceId);     // Catch: Throwable -> L15
        r4.put("is_hardware", String.valueOf(this.isHardware));     // Catch: Throwable -> L15
        r4.put("lark_user_unique_id", this.encryptedUserId);     // Catch: Throwable -> L15
        r4.put("conference_id", this.meetingId);     // Catch: Throwable -> L15
        r4.put("create_app", this.createSourceForTracker);     // Catch: Throwable -> L15
        r4.put("session_type", this.sessionType);     // Catch: Throwable -> L15
        MmRecordingSource r1 = this.source;     // Catch: Throwable -> L15
        boolean r2 = false;
        if (r1 != null) goto L6;
    L8:
        if (r2 == true) goto L10;
        r4.put("tenant_id", this.encryptedTenantId);     // Catch: Throwable -> L15
    L10:
        if (r5 == null) goto L12;
        JSONObject r6 = r4.put("source", r5);     // Catch: Throwable -> L15
    L13:
        Result.constructor-impl(r6);     // Catch: Throwable -> L15
    L17:
        return r4;
    L12:
        r6 = null;
        goto L13
    L6:
        if (r1.isFeishuHost() != true) goto L8;
        r2 = true;
    L15:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public final MmRecordingCommonParam withRecordingIdReady(String r16, String r17) {
        Intrinsics.checkNotNullParameter(r16, "recordingId");
        Intrinsics.checkNotNullParameter(r17, "meetingId");
        return copy$default(this, null, null, false, null, r17, null, null, null, null, r16, null, 1519, null);
    }

    public static /* synthetic */ JSONObject putCommonParamsTo$default(MmRecordingCommonParam r0, JSONObject r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = null;
    L6:
        return r0.putCommonParamsTo(r1, r2);
    }

    public static /* synthetic */ MmRecordingCommonParam withRecordingIdReady$default(MmRecordingCommonParam r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = r0.meetingId;
    L6:
        return r0.withRecordingIdReady(r1, r2);
    }

    public MmRecordingCommonParam(String r2, String r3, boolean r4, String r5, String r6, String r7, String r8, MmRecordingSource r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r2, AppbrandHostConstants.Schema_RESERVED_FIELD.TOKEN);
        Intrinsics.checkNotNullParameter(r3, "recordId");
        Intrinsics.checkNotNullParameter(r5, "entrance");
        Intrinsics.checkNotNullParameter(r6, "meetingId");
        Intrinsics.checkNotNullParameter(r7, "userId");
        Intrinsics.checkNotNullParameter(r8, "recordingTraceId");
        Intrinsics.checkNotNullParameter(r10, "tenantId");
        Intrinsics.checkNotNullParameter(r11, "vcRecordingId");
        Intrinsics.checkNotNullParameter(r12, "sessionType");
        this.token = r2;
        this.recordId = r3;
        this.isHardware = r4;
        this.entrance = r5;
        this.meetingId = r6;
        this.userId = r7;
        this.recordingTraceId = r8;
        this.source = r9;
        this.tenantId = r10;
        this.vcRecordingId = r11;
        this.sessionType = r12;
        this.encryptedUserId = y.b(r7);
        this.encryptedTenantId = y.b(r10);
        if (r9 == null) goto L6;
        String r13 = r9.toTrackSource();
        if (r13 == null) goto L6;
    L7:
        this.createSourceForTracker = r13;
        return;
    L6:
        r13 = "";
        goto L7
    }

    public /* synthetic */ MmRecordingCommonParam(String r13, String r14, boolean r15, String r16, String r17, String r18, String r19, MmRecordingSource r20, String r21, String r22, String r23, int r24, DefaultConstructorMarker r25) {
        String r2 = "";
        if ((r24 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r24 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r24 & 4) == 0) goto L13;
        boolean r4 = false;
    L15:
        if ((r24 & 8) == 0) goto L17;
        String r5 = "";
    L19:
        if ((r24 & 16) == 0) goto L21;
        String r6 = "";
    L23:
        if ((r24 & 32) == 0) goto L25;
        String r7 = "";
    L27:
        if ((r24 & 64) == 0) goto L29;
        String r8 = "";
    L31:
        if ((r24 & 128) == 0) goto L33;
        MmRecordingSource r9 = null;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r10 = "";
    L39:
        if ((r24 & 512) == 0) goto L41;
        String r11 = "";
    L43:
        if ((r24 & 1024) != 0) goto L46;
        r2 = r23;
    L46:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r2);
        return;
    L41:
        r11 = r22;
        goto L43
    L37:
        r10 = r21;
        goto L39
    L33:
        r9 = r20;
        goto L35
    L29:
        r8 = r19;
        goto L31
    L25:
        r7 = r18;
        goto L27
    L21:
        r6 = r17;
        goto L23
    L17:
        r5 = r16;
        goto L19
    L13:
        r4 = r15;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r13;
        goto L7
    }
}
