package com.larus.platform.model.chat;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u008f\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r\u0012\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010#\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010$\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010'\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0010\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016J\u0013\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rHÆ\u0003J\u0013\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rHÆ\u0003J\u0096\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r2\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0005HÖ\u0001J\t\u00101\u001a\u00020\u000eHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0018\u0010\u0016R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0016R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001a\u0010\u0013R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u001b\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u001d\u0010\u0016R \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR \u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001f¨\u00062"}, d2 = {"Lcom/larus/platform/model/chat/UploadVideoEntityLimitConf;", "", "maxVideoSize", "", "maxVideoWidth", "", "maxVideoHeight", "maxVideoFps", "maxVideoBitrate", "maxVideoDuration", "maxVideoCount", "maxImageVideoCount", "allowedVideoCodec", "", "", "allowedVideoTypes", "<init>", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)V", "getMaxVideoSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMaxVideoWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxVideoHeight", "getMaxVideoFps", "getMaxVideoBitrate", "getMaxVideoDuration", "getMaxVideoCount", "getMaxImageVideoCount", "getAllowedVideoCodec", "()Ljava/util/List;", "getAllowedVideoTypes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;)Lcom/larus/platform/model/chat/UploadVideoEntityLimitConf;", "equals", "", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class u0 {

    @SerializedName("allowed_video_codec")
    private final List<String> allowedVideoCodec;

    @SerializedName("allowed_video_types")
    private final List<String> allowedVideoTypes;

    @SerializedName("max_image_video_count")
    private final Integer maxImageVideoCount;

    @SerializedName("max_video_bitrate")
    private final Long maxVideoBitrate;

    @SerializedName("max_video_count")
    private final Integer maxVideoCount;

    @SerializedName("max_video_duration")
    private final Long maxVideoDuration;

    @SerializedName("max_video_fps")
    private final Integer maxVideoFps;

    @SerializedName("max_video_height")
    private final Integer maxVideoHeight;

    @SerializedName("max_video_size")
    private final Long maxVideoSize;

    @SerializedName("max_video_width")
    private final Integer maxVideoWidth;

    public u0() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof u0) == true) goto L8;
        return false;
    L8:
        u0 r6 = (u0) r5;
        if (Intrinsics.areEqual(this.maxVideoSize, r6.maxVideoSize) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.maxVideoWidth, r6.maxVideoWidth) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxVideoHeight, r6.maxVideoHeight) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.maxVideoFps, r6.maxVideoFps) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.maxVideoBitrate, r6.maxVideoBitrate) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.maxVideoDuration, r6.maxVideoDuration) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.maxVideoCount, r6.maxVideoCount) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.maxImageVideoCount, r6.maxImageVideoCount) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.allowedVideoCodec, r6.allowedVideoCodec) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.allowedVideoTypes, r6.allowedVideoTypes) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        Long r0 = this.maxVideoSize;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.maxVideoWidth;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.maxVideoHeight;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.maxVideoFps;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.maxVideoBitrate;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Long r16 = this.maxVideoDuration;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.maxVideoCount;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.maxImageVideoCount;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        List<String> r25 = this.allowedVideoCodec;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        List<String> r28 = this.allowedVideoTypes;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
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

    public final String toString() {
        return "UploadVideoEntityLimitConf(maxVideoSize=" + this.maxVideoSize + ", maxVideoWidth=" + this.maxVideoWidth + ", maxVideoHeight=" + this.maxVideoHeight + ", maxVideoFps=" + this.maxVideoFps + ", maxVideoBitrate=" + this.maxVideoBitrate + ", maxVideoDuration=" + this.maxVideoDuration + ", maxVideoCount=" + this.maxVideoCount + ", maxImageVideoCount=" + this.maxImageVideoCount + ", allowedVideoCodec=" + this.allowedVideoCodec + ", allowedVideoTypes=" + this.allowedVideoTypes + ')';
    }

    public final List<String> a() {
        return this.allowedVideoCodec;
    }

    public final List<String> b() {
        return this.allowedVideoTypes;
    }

    public final Integer c() {
        return this.maxImageVideoCount;
    }

    public final Long d() {
        return this.maxVideoBitrate;
    }

    public final Integer e() {
        return this.maxVideoCount;
    }

    public final Long f() {
        return this.maxVideoDuration;
    }

    public final Integer g() {
        return this.maxVideoFps;
    }

    public final Integer h() {
        return this.maxVideoHeight;
    }

    public final Long i() {
        return this.maxVideoSize;
    }

    public final Integer j() {
        return this.maxVideoWidth;
    }

    public /* synthetic */ u0(int r14) {
        this(2147483648L, 4096, 4096, 120, 314572800L, 3600L, 10, 20, CollectionsKt.listOf(new String[]{"h265", "h264"}), CollectionsKt.listOf(new String[]{"mp4", "mov", "3gp", "3g2"}));
    }

    public u0(Long r1, Integer r2, Integer r3, Integer r4, Long r5, Long r6, Integer r7, Integer r8, List<String> r9, List<String> r10) {
        this.maxVideoSize = r1;
        this.maxVideoWidth = r2;
        this.maxVideoHeight = r3;
        this.maxVideoFps = r4;
        this.maxVideoBitrate = r5;
        this.maxVideoDuration = r6;
        this.maxVideoCount = r7;
        this.maxImageVideoCount = r8;
        this.allowedVideoCodec = r9;
        this.allowedVideoTypes = r10;
    }
}
