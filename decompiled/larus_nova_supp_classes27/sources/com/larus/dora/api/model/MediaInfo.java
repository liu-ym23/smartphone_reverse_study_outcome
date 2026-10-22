package com.larus.dora.api.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0005\n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BÓ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u00108\u001a\u00020\tH\u0016J\u0013\u00109\u001a\u00020\u00152\b\u0010:\u001a\u0004\u0018\u00010;H\u0096\u0002J\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010=\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010A\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010$J\t\u0010B\u001a\u00020\tHÆ\u0003J\t\u0010C\u001a\u00020\tHÆ\u0003J\t\u0010D\u001a\u00020\u000eHÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010G\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u0010I\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010J\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u00102J\u0010\u0010K\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0002\u00102J\u0016\u0010L\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0003¢\u0006\u0002\u00106JÚ\u0001\u0010M\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018HÆ\u0001¢\u0006\u0002\u0010NJ\t\u0010O\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u001a\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010%\u001a\u0004\b&\u0010$R\u0016\u0010\u000b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0016\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010(R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b,\u0010\u001dR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b-\u0010\u001dR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010 R\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b/\u0010\u001dR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010 R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b4\u00102R \u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00107\u001a\u0004\b5\u00106¨\u0006P"}, d2 = {"Lcom/larus/dora/api/model/MediaInfo;", "Ljava/io/Serializable;", "mediaId", "", "mediaType", "", "format", "downloadUrl", "width", "", "height", "outVideoWidth", "outVideoHeight", "outputVideoCrop", "", "size", "duration", "mimeType", "createTime", "mediaName", "hasOcr", "", "hasThumbnail", "thumbnailTypes", "", "", "<init>", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;IIDLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;[Ljava/lang/Byte;)V", "getMediaId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMediaType", "()Ljava/lang/String;", "getFormat", "getDownloadUrl", "getWidth", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getHeight", "getOutVideoWidth", "()I", "getOutVideoHeight", "getOutputVideoCrop", "()D", "getSize", "getDuration", "getMimeType", "getCreateTime", "getMediaName", "getHasOcr", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getHasThumbnail", "getThumbnailTypes", "()[Ljava/lang/Byte;", "[Ljava/lang/Byte;", "hashCode", "equals", "other", "", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;IIDLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;[Ljava/lang/Byte;)Lcom/larus/dora/api/model/MediaInfo;", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaInfo implements Serializable {

    @SerializedName("create_time")
    private final Long createTime;

    @SerializedName("url")
    private final String downloadUrl;

    @SerializedName("duration")
    private final Long duration;

    @SerializedName("format")
    private final String format;

    @SerializedName("has_ocr")
    private final Boolean hasOcr;

    @SerializedName("has_thumbnail")
    private final Boolean hasThumbnail;

    @SerializedName("height")
    private final Integer height;

    @SerializedName("media_id")
    private final Long mediaId;

    @SerializedName("media_name")
    private final String mediaName;

    @SerializedName("media_type")
    private final String mediaType;

    @SerializedName("mime_type")
    private final String mimeType;

    @SerializedName("out_video_height")
    private final int outVideoHeight;

    @SerializedName("out_video_width")
    private final int outVideoWidth;

    @SerializedName("out_video_crop_radio")
    private final double outputVideoCrop;

    @SerializedName("size")
    private final Long size;

    @SerializedName("thumbnail_types")
    private final Byte[] thumbnailTypes;

    @SerializedName("width")
    private final Integer width;

    public MediaInfo() {
        this(null, null, null, null, null, null, 0, 0, 0.0d, null, null, null, null, null, null, null, null, 131071, null);
    }

    public static /* synthetic */ MediaInfo copy$default(MediaInfo r17, Long r18, String r110, String r20, String r21, Integer r22, Integer r23, int r24, int r25, double r26, Long r28, Long r210, String r30, Long r31, String r32, Boolean r33, Boolean r34, Byte[] r35, int r36, Object r37) {
        if ((r36 & 1) == 0) goto L5;
        Long r2 = r17.mediaId;
    L7:
        if ((r36 & 2) == 0) goto L9;
        String r3 = r17.mediaType;
    L11:
        if ((r36 & 4) == 0) goto L13;
        String r4 = r17.format;
    L15:
        if ((r36 & 8) == 0) goto L17;
        String r5 = r17.downloadUrl;
    L19:
        if ((r36 & 16) == 0) goto L21;
        Integer r6 = r17.width;
    L23:
        if ((r36 & 32) == 0) goto L25;
        Integer r7 = r17.height;
    L27:
        if ((r36 & 64) == 0) goto L29;
        int r8 = r17.outVideoWidth;
    L31:
        if ((r36 & 128) == 0) goto L33;
        int r9 = r17.outVideoHeight;
    L35:
        if ((r36 & 256) == 0) goto L37;
        double r10 = r17.outputVideoCrop;
    L39:
        if ((r36 & 512) == 0) goto L41;
        Long r12 = r17.size;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        Long r13 = r17.duration;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        String r14 = r17.mimeType;
    L51:
        if ((r36 & 4096) == 0) goto L53;
        Long r15 = r17.createTime;
    L54:
        Long r38 = r15;
        if ((r36 & 8192) == 0) goto L57;
        String r16 = r17.mediaName;
    L58:
        String r310 = r16;
        if ((r36 & 16384) == 0) goto L61;
        Boolean r111 = r17.hasOcr;
    L62:
        Boolean r311 = r111;
        if ((r36 & 32768) == 0) goto L65;
        Boolean r112 = r17.hasThumbnail;
    L67:
        if ((r36 & 65536) == 0) goto L69;
        Byte[] r1 = r17.thumbnailTypes;
    L71:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13, r14, r38, r310, r311, r112, r1);
    L69:
        r1 = r35;
        goto L71
    L65:
        r112 = r34;
        goto L67
    L61:
        r111 = r33;
        goto L62
    L57:
        r16 = r32;
        goto L58
    L53:
        r15 = r31;
        goto L54
    L49:
        r14 = r30;
        goto L51
    L45:
        r13 = r210;
        goto L47
    L41:
        r12 = r28;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r110;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final Long component1() {
        return this.mediaId;
    }

    public final Long component10() {
        return this.size;
    }

    public final Long component11() {
        return this.duration;
    }

    public final String component12() {
        return this.mimeType;
    }

    public final Long component13() {
        return this.createTime;
    }

    public final String component14() {
        return this.mediaName;
    }

    public final Boolean component15() {
        return this.hasOcr;
    }

    public final Boolean component16() {
        return this.hasThumbnail;
    }

    public final Byte[] component17() {
        return this.thumbnailTypes;
    }

    public final String component2() {
        return this.mediaType;
    }

    public final String component3() {
        return this.format;
    }

    public final String component4() {
        return this.downloadUrl;
    }

    public final Integer component5() {
        return this.width;
    }

    public final Integer component6() {
        return this.height;
    }

    public final int component7() {
        return this.outVideoWidth;
    }

    public final int component8() {
        return this.outVideoHeight;
    }

    public final double component9() {
        return this.outputVideoCrop;
    }

    public final MediaInfo copy(Long r21, String r22, String r23, String r24, Integer r25, Integer r26, int r27, int r28, double r210, Long r31, Long r32, String r33, Long r34, String r35, Boolean r36, Boolean r37, Byte[] r38) {
        return new MediaInfo(r21, r22, r23, r24, r25, r26, r27, r28, r210, r31, r32, r33, r34, r35, r36, r37, r38);
    }

    public String toString() {
        return "MediaInfo(mediaId=" + this.mediaId + ", mediaType=" + this.mediaType + ", format=" + this.format + ", downloadUrl=" + this.downloadUrl + ", width=" + this.width + ", height=" + this.height + ", outVideoWidth=" + this.outVideoWidth + ", outVideoHeight=" + this.outVideoHeight + ", outputVideoCrop=" + this.outputVideoCrop + ", size=" + this.size + ", duration=" + this.duration + ", mimeType=" + this.mimeType + ", createTime=" + this.createTime + ", mediaName=" + this.mediaName + ", hasOcr=" + this.hasOcr + ", hasThumbnail=" + this.hasThumbnail + ", thumbnailTypes=" + Arrays.toString(this.thumbnailTypes) + ')';
    }

    public int hashCode() {
        Long r0 = this.mediaId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Long r4 = this.createTime;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final Long getCreateTime() {
        return this.createTime;
    }

    public final String getDownloadUrl() {
        return this.downloadUrl;
    }

    public final Long getDuration() {
        return this.duration;
    }

    public final String getFormat() {
        return this.format;
    }

    public final Boolean getHasOcr() {
        return this.hasOcr;
    }

    public final Boolean getHasThumbnail() {
        return this.hasThumbnail;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final Long getMediaId() {
        return this.mediaId;
    }

    public final String getMediaName() {
        return this.mediaName;
    }

    public final String getMediaType() {
        return this.mediaType;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final int getOutVideoHeight() {
        return this.outVideoHeight;
    }

    public final int getOutVideoWidth() {
        return this.outVideoWidth;
    }

    public final double getOutputVideoCrop() {
        return this.outputVideoCrop;
    }

    public final Long getSize() {
        return this.size;
    }

    public final Byte[] getThumbnailTypes() {
        return this.thumbnailTypes;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public boolean equals(Object r3) {
        if ((r3 instanceof MediaInfo) == false) goto L12;
        MediaInfo r4 = (MediaInfo) r3;
        if (Intrinsics.areEqual(this.mediaId, r4.mediaId) == true) goto L7;
    L9:
        return false;
    L7:
        if (Intrinsics.areEqual(this.createTime, r4.createTime) == false) goto L9;
        return true;
    L12:
        return super.equals(r3);
    }

    public MediaInfo(Long r4, String r5, String r6, String r7, Integer r8, Integer r9, int r10, int r11, double r12, Long r14, Long r15, String r16, Long r17, String r18, Boolean r110, Boolean r20, Byte[] r21) {
        this.mediaId = r4;
        this.mediaType = r5;
        this.format = r6;
        this.downloadUrl = r7;
        this.width = r8;
        this.height = r9;
        this.outVideoWidth = r10;
        this.outVideoHeight = r11;
        this.outputVideoCrop = r12;
        this.size = r14;
        this.duration = r15;
        this.mimeType = r16;
        this.createTime = r17;
        this.mediaName = r18;
        this.hasOcr = r110;
        this.hasThumbnail = r20;
        this.thumbnailTypes = r21;
    }

    public /* synthetic */ MediaInfo(Long r20, String r21, String r22, String r23, Integer r24, Integer r25, int r26, int r27, double r28, Long r30, Long r31, String r32, Long r33, String r34, Boolean r35, Boolean r36, Byte[] r37, int r38, DefaultConstructorMarker r310) {
        if ((r38 & 1) == 0) goto L5;
        Long r1 = null;
    L7:
        if ((r38 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r38 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r38 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r38 & 16) == 0) goto L21;
        Integer r6 = 0;
    L23:
        if ((r38 & 32) == 0) goto L25;
        Integer r8 = 0;
    L27:
        if ((r38 & 64) == 0) goto L29;
        int r9 = 1920;
    L31:
        if ((r38 & 128) == 0) goto L33;
        int r10 = 1440;
    L35:
        if ((r38 & 256) == 0) goto L37;
        double r11 = 0.8d;
    L39:
        if ((r38 & 512) == 0) goto L41;
        Long r13 = 0L;
    L43:
        if ((r38 & 1024) == 0) goto L45;
        Long r2 = 0L;
    L47:
        if ((r38 & 2048) == 0) goto L49;
        String r7 = null;
    L50:
        String r16 = r7;
        if ((r38 & 4096) == 0) goto L53;
        Long r12 = 0L;
    L55:
        if ((r38 & 8192) == 0) goto L57;
        String r14 = null;
    L59:
        if ((r38 & 16384) == 0) goto L61;
        Boolean r15 = Boolean.FALSE;
    L63:
        if ((r38 & 32768) == 0) goto L65;
        Boolean r17 = Boolean.FALSE;
    L67:
        if ((r38 & 65536) == 0) goto L69;
        Byte[] r0 = new Byte[0];
    L70:
        this(r1, r3, r4, r5, r6, r8, r9, r10, r11, r13, r2, r16, r12, r14, r15, r17, r0);
        return;
    L69:
        r0 = r37;
        goto L70
    L65:
        r17 = r36;
        goto L67
    L61:
        r15 = r35;
        goto L63
    L57:
        r14 = r34;
        goto L59
    L53:
        r12 = r33;
        goto L55
    L49:
        r7 = r32;
        goto L50
    L45:
        r2 = r31;
        goto L47
    L41:
        r13 = r30;
        goto L43
    L37:
        r11 = r28;
        goto L39
    L33:
        r10 = r27;
        goto L35
    L29:
        r9 = r26;
        goto L31
    L25:
        r8 = r25;
        goto L27
    L21:
        r6 = r24;
        goto L23
    L17:
        r5 = r23;
        goto L19
    L13:
        r4 = r22;
        goto L15
    L9:
        r3 = r21;
        goto L11
    L5:
        r1 = r20;
        goto L7
    }
}
