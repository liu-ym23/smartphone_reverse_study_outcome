package com.ss.android.lark.officesdk.minutes.service.foundation.network.response.http;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.audiosave.d;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lvb.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u009b\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0006\u0010?\u001a\u00020@J\b\u0010A\u001a\u00020\u0003H\u0016R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#R\u001a\u0010\t\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010!\"\u0004\b'\u0010#R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010)\"\u0004\b0\u0010+R \u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0019\"\u0004\b2\u0010\u001bR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R \u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0019\"\u0004\b8\u0010\u001bR\u001e\u0010\u0013\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0019\"\u0004\b:\u0010\u001bR \u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmCreateAudioResponse;", "Ljava/io/Serializable;", "objectToken", "", "meetingId", "topic", "startTime", "", "stopTime", "duration", "canAudioCreateRetry", "", "finalAudioType", "", "isForceSaveAudio", "forceSaveReason", "unavailableReason", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmForceSaveUnavailableReason;", "benefitCenterUrl", "recordingId", "associatedIds", "Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmAssociatedIds;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJZIZLjava/lang/String;Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmForceSaveUnavailableReason;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmAssociatedIds;)V", "getObjectToken", "()Ljava/lang/String;", "setObjectToken", "(Ljava/lang/String;)V", "getMeetingId", "setMeetingId", "getTopic", "setTopic", "getStartTime", "()J", "setStartTime", "(J)V", "getStopTime", "setStopTime", "getDuration", "setDuration", "getCanAudioCreateRetry", "()Z", "setCanAudioCreateRetry", "(Z)V", "getFinalAudioType", "()I", "setFinalAudioType", "(I)V", "setForceSaveAudio", "getForceSaveReason", "setForceSaveReason", "getUnavailableReason", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmForceSaveUnavailableReason;", "setUnavailableReason", "(Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/audiosave/MmForceSaveUnavailableReason;)V", "getBenefitCenterUrl", "setBenefitCenterUrl", "getRecordingId", "setRecordingId", "getAssociatedIds", "()Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmAssociatedIds;", "setAssociatedIds", "(Lcom/ss/android/lark/officesdk/minutes/service/foundation/network/response/http/MmAssociatedIds;)V", "normalizeObjectToken", "", "toString", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmCreateAudioResponse implements Serializable {

    @SerializedName("associated_ids")
    private MmAssociatedIds associatedIds;

    @SerializedName("benefit_center_url")
    private String benefitCenterUrl;

    @SerializedName("can_retry")
    private boolean canAudioCreateRetry;
    private long duration;

    @SerializedName("final_audio_type")
    private int finalAudioType;

    @SerializedName("force_save_reason")
    private String forceSaveReason;

    @SerializedName("is_force_save")
    private boolean isForceSaveAudio;

    @SerializedName("meeting_id")
    private String meetingId;

    @SerializedName("object_token")
    private String objectToken;

    @SerializedName("recording_id")
    private String recordingId;

    @SerializedName("start_time")
    private long startTime;

    @SerializedName("stop_time")
    private long stopTime;
    private String topic;

    @SerializedName("unavailable_reason")
    private d unavailableReason;

    public MmCreateAudioResponse() {
        this(null, null, null, 0, 0, 0, false, 0, false, null, null, null, null, null, 16383, null);
    }

    public final void normalizeObjectToken() {
        MmAssociatedIds r0 = this.associatedIds;
        if (r0 == null) goto L17;
        String r1 = r0.getObjectToken();
        if (r1 == null) goto L17;
        String r2 = StringsKt.trim(r1).toString();
        if (r2 == null) goto L17;
        if (r2.length() <= 0) goto L11;
        boolean r3 = true;
    L12:
        if (r3 == true) goto L15;
        r2 = null;
    L15:
        if (r2 == null) goto L17;
    L18:
        this.objectToken = r2;
        return;
    L11:
        r3 = false;
    L17:
        r2 = this.objectToken;
        goto L18
    }

    public String toString() {
        return "MmCreateAudioResponse(objectToken='" + a.d(this.objectToken) + "', recordingId='" + this.recordingId + "', meetingId='" + this.meetingId + "', topic='" + this.topic + "', startTime=" + this.startTime + ", stopTime=" + this.stopTime + ", duration=" + this.duration + ", canAudioCreateRetry=" + this.canAudioCreateRetry + ", finalAudioType=" + this.finalAudioType + ", isForceSaveAudio=" + this.isForceSaveAudio + ", forceSaveReason=" + this.forceSaveReason + ')';
    }

    public final MmAssociatedIds getAssociatedIds() {
        return this.associatedIds;
    }

    public final String getBenefitCenterUrl() {
        return this.benefitCenterUrl;
    }

    public final boolean getCanAudioCreateRetry() {
        return this.canAudioCreateRetry;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getFinalAudioType() {
        return this.finalAudioType;
    }

    public final String getForceSaveReason() {
        return this.forceSaveReason;
    }

    public final String getMeetingId() {
        return this.meetingId;
    }

    public final String getObjectToken() {
        return this.objectToken;
    }

    public final String getRecordingId() {
        return this.recordingId;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final long getStopTime() {
        return this.stopTime;
    }

    public final String getTopic() {
        return this.topic;
    }

    public final d getUnavailableReason() {
        return this.unavailableReason;
    }

    public final boolean isForceSaveAudio() {
        return this.isForceSaveAudio;
    }

    public final void setAssociatedIds(MmAssociatedIds r1) {
        this.associatedIds = r1;
    }

    public final void setBenefitCenterUrl(String r1) {
        this.benefitCenterUrl = r1;
    }

    public final void setCanAudioCreateRetry(boolean r1) {
        this.canAudioCreateRetry = r1;
    }

    public final void setDuration(long r1) {
        this.duration = r1;
    }

    public final void setFinalAudioType(int r1) {
        this.finalAudioType = r1;
    }

    public final void setForceSaveAudio(boolean r1) {
        this.isForceSaveAudio = r1;
    }

    public final void setForceSaveReason(String r1) {
        this.forceSaveReason = r1;
    }

    public final void setMeetingId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.meetingId = r2;
    }

    public final void setObjectToken(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.objectToken = r2;
    }

    public final void setRecordingId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.recordingId = r2;
    }

    public final void setStartTime(long r1) {
        this.startTime = r1;
    }

    public final void setStopTime(long r1) {
        this.stopTime = r1;
    }

    public final void setTopic(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.topic = r2;
    }

    public final void setUnavailableReason(d r1) {
        this.unavailableReason = r1;
    }

    public MmCreateAudioResponse(String r7, String r8, String r9, long r10, long r12, long r14, boolean r16, int r17, boolean r18, String r19, d r20, String r21, String r22, MmAssociatedIds r23) {
        Intrinsics.checkNotNullParameter(r7, "objectToken");
        Intrinsics.checkNotNullParameter(r8, "meetingId");
        Intrinsics.checkNotNullParameter(r9, "topic");
        Intrinsics.checkNotNullParameter(r22, "recordingId");
        this.objectToken = r7;
        this.meetingId = r8;
        this.topic = r9;
        this.startTime = r10;
        this.stopTime = r12;
        this.duration = r14;
        this.canAudioCreateRetry = r16;
        this.finalAudioType = r17;
        this.isForceSaveAudio = r18;
        this.forceSaveReason = r19;
        this.unavailableReason = r20;
        this.benefitCenterUrl = r21;
        this.recordingId = r22;
        this.associatedIds = r23;
    }

    public /* synthetic */ MmCreateAudioResponse(String r18, String r19, String r20, long r21, long r23, long r25, boolean r27, int r28, boolean r29, String r30, d r31, String r32, String r33, MmAssociatedIds r34, int r35, DefaultConstructorMarker r36) {
        if ((r35 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r35 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r35 & 4) == 0) goto L13;
        String r4 = "";
    L14:
        long r6 = 0;
        if ((r35 & 8) == 0) goto L17;
        long r8 = 0;
    L19:
        if ((r35 & 16) == 0) goto L21;
        long r10 = 0;
    L23:
        if ((r35 & 32) != 0) goto L26;
        r6 = r25;
    L26:
        boolean r12 = false;
        if ((r35 & 64) == 0) goto L29;
        boolean r5 = false;
    L31:
        if ((r35 & 128) == 0) goto L33;
        int r13 = 0;
    L35:
        if ((r35 & 256) != 0) goto L39;
        r12 = r29;
    L39:
        if ((r35 & 512) == 0) goto L41;
        String r14 = null;
    L43:
        if ((r35 & 1024) == 0) goto L45;
        d r15 = null;
    L47:
        if ((r35 & 2048) == 0) goto L49;
        String r2 = null;
    L50:
        String r16 = r2;
        if ((r35 & 4096) == 0) goto L53;
        String r7 = "";
    L55:
        if ((r35 & 8192) == 0) goto L57;
        MmAssociatedIds r0 = null;
    L58:
        this(r1, r3, r4, r8, r10, r6, r5, r13, r12, r14, r15, r16, r7, r0);
        return;
    L57:
        r0 = r34;
        goto L58
    L53:
        r7 = r33;
        goto L55
    L49:
        r2 = r32;
        goto L50
    L45:
        r15 = r31;
        goto L47
    L41:
        r14 = r30;
        goto L43
    L33:
        r13 = r28;
        goto L35
    L29:
        r5 = r27;
        goto L31
    L21:
        r10 = r23;
        goto L23
    L17:
        r8 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L14
    L9:
        r3 = r19;
        goto L11
    L5:
        r1 = r18;
        goto L7
    }
}
