package com.larus.bmhome.chat.layout.holder.video.bean;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.CreationTaskType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b(\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 =2\u00020\u0001:\u0001=B£\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010*\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00101\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010#J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0018Jª\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u00106J\u0013\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0005HÖ\u0001J\t\u0010<\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0016R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010$\u001a\u0004\b\"\u0010#R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b'\u0010\u0018¨\u0006>"}, d2 = {"Lcom/larus/bmhome/chat/layout/holder/video/bean/AiGenVideoContentData;", "Ljava/io/Serializable;", "vid", "", "loadingWidth", "", "loadingHeight", "videoStatus", "videoCover", "Lcom/larus/bmhome/chat/layout/holder/video/bean/CoverItem;", "videoModel", "localUrl", "downloadUrl", "downloadFilehash", "duration", "", "videoType", "mobileSupport", "taskType", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/bmhome/chat/layout/holder/video/bean/CoverItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getVid", "()Ljava/lang/String;", "getLoadingWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLoadingHeight", "getVideoStatus", "getVideoCover", "()Lcom/larus/bmhome/chat/layout/holder/video/bean/CoverItem;", "getVideoModel", "getLocalUrl", "getDownloadUrl", "getDownloadFilehash", "getDuration", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getVideoType", "getMobileSupport", "getTaskType", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/larus/bmhome/chat/layout/holder/video/bean/CoverItem;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/bmhome/chat/layout/holder/video/bean/AiGenVideoContentData;", "equals", "", "other", "", "hashCode", "toString", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class AiGenVideoContentData implements Serializable {
    public static final a Companion = null;

    @SerializedName("download_filehash")
    private final String downloadFilehash;

    @SerializedName("download_url")
    private final String downloadUrl;

    @SerializedName("duration")
    private final Double duration;

    @SerializedName("loading_height")
    private final Integer loadingHeight;

    @SerializedName("loading_width")
    private final Integer loadingWidth;

    @SerializedName("local_url")
    private final String localUrl;

    @SerializedName("mobile_supported")
    private final String mobileSupport;

    @SerializedName("task_type")
    private final Integer taskType;

    @SerializedName("vid")
    private final String vid;

    @SerializedName("cover")
    private final CoverItem videoCover;

    @SerializedName("video_model")
    private final String videoModel;

    @SerializedName("video_status")
    private final String videoStatus;

    @SerializedName("video_type")
    private final String videoType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AiGenVideoContentData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public static /* synthetic */ AiGenVideoContentData copy$default(AiGenVideoContentData r14, String r15, Integer r16, Integer r17, String r18, CoverItem r19, String r20, String r21, String r22, String r23, Double r24, String r25, String r26, Integer r27, int r28, Object r29) {
        if ((r28 & 1) == 0) goto L5;
        String r2 = r14.vid;
    L7:
        if ((r28 & 2) == 0) goto L9;
        Integer r3 = r14.loadingWidth;
    L11:
        if ((r28 & 4) == 0) goto L13;
        Integer r4 = r14.loadingHeight;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r5 = r14.videoStatus;
    L19:
        if ((r28 & 16) == 0) goto L21;
        CoverItem r6 = r14.videoCover;
    L23:
        if ((r28 & 32) == 0) goto L25;
        String r7 = r14.videoModel;
    L27:
        if ((r28 & 64) == 0) goto L29;
        String r8 = r14.localUrl;
    L31:
        if ((r28 & 128) == 0) goto L33;
        String r9 = r14.downloadUrl;
    L35:
        if ((r28 & 256) == 0) goto L37;
        String r10 = r14.downloadFilehash;
    L39:
        if ((r28 & 512) == 0) goto L41;
        Double r11 = r14.duration;
    L43:
        if ((r28 & 1024) == 0) goto L45;
        String r12 = r14.videoType;
    L47:
        if ((r28 & 2048) == 0) goto L49;
        String r13 = r14.mobileSupport;
    L51:
        if ((r28 & 4096) == 0) goto L53;
        Integer r1 = r14.taskType;
    L55:
        return r14.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r1);
    L53:
        r1 = r27;
        goto L55
    L49:
        r13 = r26;
        goto L51
    L45:
        r12 = r25;
        goto L47
    L41:
        r11 = r24;
        goto L43
    L37:
        r10 = r23;
        goto L39
    L33:
        r9 = r22;
        goto L35
    L29:
        r8 = r21;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r2 = r15;
        goto L7
    }

    public final String component1() {
        return this.vid;
    }

    public final Double component10() {
        return this.duration;
    }

    public final String component11() {
        return this.videoType;
    }

    public final String component12() {
        return this.mobileSupport;
    }

    public final Integer component13() {
        return this.taskType;
    }

    public final Integer component2() {
        return this.loadingWidth;
    }

    public final Integer component3() {
        return this.loadingHeight;
    }

    public final String component4() {
        return this.videoStatus;
    }

    public final CoverItem component5() {
        return this.videoCover;
    }

    public final String component6() {
        return this.videoModel;
    }

    public final String component7() {
        return this.localUrl;
    }

    public final String component8() {
        return this.downloadUrl;
    }

    public final String component9() {
        return this.downloadFilehash;
    }

    public final AiGenVideoContentData copy(String r16, Integer r17, Integer r18, String r19, CoverItem r20, String r21, String r22, String r23, String r24, Double r25, String r26, String r27, @CreationTaskType Integer r28) {
        return new AiGenVideoContentData(r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AiGenVideoContentData) == true) goto L8;
        return false;
    L8:
        AiGenVideoContentData r6 = (AiGenVideoContentData) r5;
        if (Intrinsics.areEqual(this.vid, r6.vid) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.loadingWidth, r6.loadingWidth) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.loadingHeight, r6.loadingHeight) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.videoStatus, r6.videoStatus) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.videoCover, r6.videoCover) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.videoModel, r6.videoModel) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.localUrl, r6.localUrl) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.downloadUrl, r6.downloadUrl) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.downloadFilehash, r6.downloadFilehash) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.duration, r6.duration) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.videoType, r6.videoType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.mobileSupport, r6.mobileSupport) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.taskType, r6.taskType) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public int hashCode() {
        String r0 = this.vid;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.loadingWidth;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.loadingHeight;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.videoStatus;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        CoverItem r13 = this.videoCover;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.videoModel;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.localUrl;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.downloadUrl;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.downloadFilehash;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Double r28 = this.duration;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        String r31 = this.videoType;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.mobileSupport;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        Integer r37 = this.taskType;
        if (r37 == null) goto L55;
        r1 = r37.hashCode();
    L55:
        return r36 + r1;
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
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
        r17 = r16.hashCode();
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
        return "AiGenVideoContentData(vid=" + this.vid + ", loadingWidth=" + this.loadingWidth + ", loadingHeight=" + this.loadingHeight + ", videoStatus=" + this.videoStatus + ", videoCover=" + this.videoCover + ", videoModel=" + this.videoModel + ", localUrl=" + this.localUrl + ", downloadUrl=" + this.downloadUrl + ", downloadFilehash=" + this.downloadFilehash + ", duration=" + this.duration + ", videoType=" + this.videoType + ", mobileSupport=" + this.mobileSupport + ", taskType=" + this.taskType + ')';
    }

    public final String getDownloadFilehash() {
        return this.downloadFilehash;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final Double getDuration() {
        return this.duration;
    }

    public final Integer getLoadingHeight() {
        return this.loadingHeight;
    }

    public final Integer getLoadingWidth() {
        return this.loadingWidth;
    }

    public final String getLocalUrl() {
        return this.localUrl;
    }

    public final String getMobileSupport() {
        return this.mobileSupport;
    }

    public final Integer getTaskType() {
        return this.taskType;
    }

    public final String getVid() {
        return this.vid;
    }

    public final CoverItem getVideoCover() {
        return this.videoCover;
    }

    public final String getVideoModel() {
        return this.videoModel;
    }

    public final String getVideoStatus() {
        return this.videoStatus;
    }

    public final String getVideoType() {
        return this.videoType;
    }

    public AiGenVideoContentData(String r1, Integer r2, Integer r3, String r4, CoverItem r5, String r6, String r7, String r8, String r9, Double r10, String r11, String r12, @CreationTaskType Integer r13) {
        this.vid = r1;
        this.loadingWidth = r2;
        this.loadingHeight = r3;
        this.videoStatus = r4;
        this.videoCover = r5;
        this.videoModel = r6;
        this.localUrl = r7;
        this.downloadUrl = r8;
        this.downloadFilehash = r9;
        this.duration = r10;
        this.videoType = r11;
        this.mobileSupport = r12;
        this.taskType = r13;
    }

    public /* synthetic */ AiGenVideoContentData(String r15, Integer r16, Integer r17, String r18, CoverItem r19, String r20, String r21, String r22, String r23, Double r24, String r25, String r26, Integer r27, int r28, DefaultConstructorMarker r29) {
        String r2 = "";
        if ((r28 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r28 & 2) == 0) goto L9;
        Integer r3 = 512;
    L11:
        if ((r28 & 4) == 0) goto L13;
        Integer r4 = 512;
    L15:
        if ((r28 & 8) == 0) goto L17;
        String r5 = "";
    L19:
        if ((r28 & 16) == 0) goto L21;
        CoverItem r6 = null;
    L23:
        if ((r28 & 32) == 0) goto L25;
        String r7 = "";
    L27:
        if ((r28 & 64) == 0) goto L29;
        String r8 = "";
    L31:
        if ((r28 & 128) == 0) goto L33;
        String r9 = "";
    L35:
        if ((r28 & 256) == 0) goto L37;
        String r10 = "";
    L39:
        if ((r28 & 512) == 0) goto L41;
        Double r11 = Double.valueOf(0.0d);
    L43:
        if ((r28 & 1024) == 0) goto L45;
        String r12 = "mp4";
    L47:
        if ((r28 & 2048) != 0) goto L51;
        r2 = r26;
    L51:
        if ((r28 & 4096) == 0) goto L53;
        Integer r0 = 0;
    L54:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r2, r0);
        return;
    L53:
        r0 = r27;
        goto L54
    L45:
        r12 = r25;
        goto L47
    L41:
        r11 = r24;
        goto L43
    L37:
        r10 = r23;
        goto L39
    L33:
        r9 = r22;
        goto L35
    L29:
        r8 = r21;
        goto L31
    L25:
        r7 = r20;
        goto L27
    L21:
        r6 = r19;
        goto L23
    L17:
        r5 = r18;
        goto L19
    L13:
        r4 = r17;
        goto L15
    L9:
        r3 = r16;
        goto L11
    L5:
        r1 = r15;
        goto L7
    }
}
