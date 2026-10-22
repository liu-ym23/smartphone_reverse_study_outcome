package com.larus.audio.asr.sami.bean;

import com.google.gson.annotations.SerializedName;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.audio.asr.c0;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b+\b\u0087\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00103\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u00104\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00105\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u00106\u001a\u00020\fHÆ\u0003J\u009a\u0001\u00107\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u00108J\u0013\u00109\u001a\u00020\n2\b\u0010:\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010;\u001a\u00020\u000fHÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b&\u0010 R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010\u0013\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*¨\u0006="}, d2 = {"Lcom/larus/audio/asr/sami/bean/AsrTaskItem;", "", "taskId", "", "conversationId", "asrFilePath", "asrExtraInfo", "Lcom/larus/audio/asr/sami/bean/AsrExtraInfo;", "botId", "saveAudioFile", "", "duration", "", "bizScene", "vuiId", "", "preStartTime", "traceInfo", "Lcom/larus/audio/asr/AsrTraceInfo;", "minRecordDurationMs", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/audio/asr/sami/bean/AsrExtraInfo;Ljava/lang/String;ZLjava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Lcom/larus/audio/asr/AsrTraceInfo;J)V", "getTaskId", "()Ljava/lang/String;", "getConversationId", "getAsrFilePath", "getAsrExtraInfo", "()Lcom/larus/audio/asr/sami/bean/AsrExtraInfo;", "getBotId", "getSaveAudioFile", "()Z", "getDuration", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getBizScene", "getVuiId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPreStartTime", "getTraceInfo", "()Lcom/larus/audio/asr/AsrTraceInfo;", "getMinRecordDurationMs", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larus/audio/asr/sami/bean/AsrExtraInfo;Ljava/lang/String;ZLjava/lang/Long;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Lcom/larus/audio/asr/AsrTraceInfo;J)Lcom/larus/audio/asr/sami/bean/AsrTaskItem;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class AsrTaskItem {

    @SerializedName("asr_extra_info")
    private final AsrExtraInfo asrExtraInfo;

    @SerializedName("asr_file_path")
    private final String asrFilePath;

    @SerializedName("biz_scene")
    private final String bizScene;

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("conversation_id")
    private final String conversationId;

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("min_record_duration_ms")
    private final long minRecordDurationMs;

    @SerializedName("pre_start_time")
    private final Long preStartTime;

    @SerializedName("save_audio_file")
    private final boolean saveAudioFile;

    @SerializedName("task_id")
    private final String taskId;

    @SerializedName("trace_info")
    private final c0 traceInfo;

    @SerializedName("vui_id")
    private final Integer vuiId;

    public AsrTaskItem() {
        this(null, null, null, null, null, false, null, null, null, null, null, 0, 4095, null);
    }

    public static /* synthetic */ AsrTaskItem copy$default(AsrTaskItem r15, String r16, String r17, String r19, AsrExtraInfo r110, String r20, boolean r21, Long r22, String r23, Integer r24, Long r25, c0 r26, long r27, int r29, Object r30) {
        if ((r29 & 1) == 0) goto L5;
        String r2 = r15.taskId;
    L7:
        if ((r29 & 2) == 0) goto L9;
        String r3 = r15.conversationId;
    L11:
        if ((r29 & 4) == 0) goto L13;
        String r4 = r15.asrFilePath;
    L15:
        if ((r29 & 8) == 0) goto L17;
        AsrExtraInfo r5 = r15.asrExtraInfo;
    L19:
        if ((r29 & 16) == 0) goto L21;
        String r6 = r15.botId;
    L23:
        if ((r29 & 32) == 0) goto L25;
        boolean r7 = r15.saveAudioFile;
    L27:
        if ((r29 & 64) == 0) goto L29;
        Long r8 = r15.duration;
    L31:
        if ((r29 & 128) == 0) goto L33;
        String r9 = r15.bizScene;
    L35:
        if ((r29 & 256) == 0) goto L37;
        Integer r10 = r15.vuiId;
    L39:
        if ((r29 & 512) == 0) goto L41;
        Long r11 = r15.preStartTime;
    L43:
        if ((r29 & 1024) == 0) goto L45;
        c0 r12 = r15.traceInfo;
    L47:
        if ((r29 & 2048) == 0) goto L49;
        long r13 = r15.minRecordDurationMs;
    L51:
        return r15.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r110;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r2 = r16;
        goto L7
    }

    public final String component1() {
        return this.taskId;
    }

    public final Long component10() {
        return this.preStartTime;
    }

    public final c0 component11() {
        return this.traceInfo;
    }

    public final long component12() {
        return this.minRecordDurationMs;
    }

    public final String component2() {
        return this.conversationId;
    }

    public final String component3() {
        return this.asrFilePath;
    }

    public final AsrExtraInfo component4() {
        return this.asrExtraInfo;
    }

    public final String component5() {
        return this.botId;
    }

    public final boolean component6() {
        return this.saveAudioFile;
    }

    public final Long component7() {
        return this.duration;
    }

    public final String component8() {
        return this.bizScene;
    }

    public final Integer component9() {
        return this.vuiId;
    }

    public final AsrTaskItem copy(String r16, String r17, String r19, AsrExtraInfo r110, String r20, boolean r21, Long r22, String r23, Integer r24, Long r25, c0 r26, long r27) {
        return new AsrTaskItem(r16, r17, r19, r110, r20, r21, r22, r23, r24, r25, r26, r27);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof AsrTaskItem) == true) goto L8;
        return false;
    L8:
        AsrTaskItem r9 = (AsrTaskItem) r8;
        if (Intrinsics.areEqual(this.taskId, r9.taskId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.conversationId, r9.conversationId) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.asrFilePath, r9.asrFilePath) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.asrExtraInfo, r9.asrExtraInfo) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.botId, r9.botId) == true) goto L24;
        return false;
    L24:
        if (this.saveAudioFile == r9.saveAudioFile) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.duration, r9.duration) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.bizScene, r9.bizScene) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.vuiId, r9.vuiId) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.preStartTime, r9.preStartTime) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.traceInfo, r9.traceInfo) == true) goto L42;
        return false;
    L42:
        if (this.minRecordDurationMs == r9.minRecordDurationMs) goto L44;
        return false;
    L44:
        return true;
    }

    public int hashCode() {
        String r0 = this.taskId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.conversationId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.asrFilePath;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        AsrExtraInfo r10 = this.asrExtraInfo;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.botId;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        if (this.saveAudioFile == false) goto L25;
        int r16 = 1231;
    L26:
        int r17 = (r15 + r16) * 31;
        Long r19 = this.duration;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r17 + r20) * 31;
        String r22 = this.bizScene;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.vuiId;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Long r29 = this.preStartTime;
        if (r29 != null) goto L41;
        int r30 = 0;
    L42:
        int r31 = (r27 + r30) * 31;
        c0 r32 = this.traceInfo;
        if (r32 == null) goto L46;
        r1 = r32.hashCode();
    L46:
        int r33 = (r31 + r1) * 31;
        long r34 = this.minRecordDurationMs;
        return r33 + ((int) (r34 ^ (r34 >>> 32)));
    L41:
        r30 = r29.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r16 = 1237;
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AsrTaskItem(taskId=" + this.taskId + ", conversationId=" + this.conversationId + ", asrFilePath=" + this.asrFilePath + ", asrExtraInfo=" + this.asrExtraInfo + ", botId=" + this.botId + ", saveAudioFile=" + this.saveAudioFile + ", duration=" + this.duration + ", bizScene=" + this.bizScene + ", vuiId=" + this.vuiId + ", preStartTime=" + this.preStartTime + ", traceInfo=" + this.traceInfo + ", minRecordDurationMs=" + this.minRecordDurationMs + ')';
    }

    public final AsrExtraInfo getAsrExtraInfo() {
        return this.asrExtraInfo;
    }

    public final String getAsrFilePath() {
        return this.asrFilePath;
    }

    public final String getBizScene() {
        return this.bizScene;
    }

    public final String getBotId() {
        return this.botId;
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final long getMinRecordDurationMs() {
        return this.minRecordDurationMs;
    }

    public final Long getPreStartTime() {
        return this.preStartTime;
    }

    public final boolean getSaveAudioFile() {
        return this.saveAudioFile;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final c0 getTraceInfo() {
        return this.traceInfo;
    }

    public final Integer getVuiId() {
        return this.vuiId;
    }

    public AsrTaskItem(String r1, String r2, String r3, AsrExtraInfo r4, String r5, boolean r6, Long r7, String r8, Integer r9, Long r10, c0 r11, long r12) {
        this.taskId = r1;
        this.conversationId = r2;
        this.asrFilePath = r3;
        this.asrExtraInfo = r4;
        this.botId = r5;
        this.saveAudioFile = r6;
        this.duration = r7;
        this.bizScene = r8;
        this.vuiId = r9;
        this.preStartTime = r10;
        this.traceInfo = r11;
        this.minRecordDurationMs = r12;
    }

    public /* synthetic */ AsrTaskItem(String r17, String r19, String r110, AsrExtraInfo r20, String r21, boolean r22, Long r23, String r24, Integer r25, Long r26, c0 r27, long r29, int r30, DefaultConstructorMarker r31) {
        String r2 = "";
        if ((r30 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r30 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r30 & 4) != 0) goto L15;
        r2 = r110;
    L15:
        if ((r30 & 8) == 0) goto L17;
        AsrExtraInfo r4 = null;
    L19:
        if ((r30 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r30 & 32) == 0) goto L25;
        boolean r7 = false;
    L27:
        if ((r30 & 64) == 0) goto L29;
        Long r9 = null;
    L31:
        if ((r30 & 128) == 0) goto L33;
        String r10 = null;
    L35:
        if ((r30 & 256) == 0) goto L37;
        Integer r11 = null;
    L39:
        if ((r30 & 512) == 0) goto L41;
        Long r12 = null;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        c0 r13 = new c0(null, null, 0, 255);
    L47:
        if ((r30 & 2048) == 0) goto L49;
        long r14 = 500;
    L50:
        this(r1, r3, r2, r4, r6, r7, r9, r10, r11, r12, r13, r14);
        return;
    L49:
        r14 = r29;
        goto L50
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
        r7 = r22;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r4 = r20;
        goto L19
    L9:
        r3 = r19;
        goto L11
    L5:
        r1 = r17;
        goto L7
    }
}
