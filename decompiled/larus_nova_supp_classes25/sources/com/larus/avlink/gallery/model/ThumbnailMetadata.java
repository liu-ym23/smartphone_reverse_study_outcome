package com.larus.avlink.gallery.model;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.model.GeoLocationInfo;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b+\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0099\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\fHÆ\u0003J\t\u00107\u001a\u00020\fHÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\t\u0010;\u001a\u00020\u0007HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010=\u001a\u00020\u0003HÆ\u0003J\t\u0010>\u001a\u00020\fHÆ\u0003J\t\u0010?\u001a\u00020\u0017HÆ\u0003Jµ\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u0017HÆ\u0001J\u0013\u0010A\u001a\u00020\u00172\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020\fHÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001bR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u0011\u0010\u0015\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010.¨\u0006F"}, d2 = {"Lcom/larus/avlink/gallery/model/ThumbnailMetadata;", "Ljava/io/Serializable;", "fileId", "", "filePath", "fileName", "fileSize", "", "sn", "imageUuid", "mediaType", "width", "", "height", "duration", "createTime", "modifyTime", "downloadTime", "geoLocationInfo", "Lcom/larus/platform/model/GeoLocationInfo;", "sourceType", "processingStatus", "isSynced", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;IIJJJJLcom/larus/platform/model/GeoLocationInfo;Ljava/lang/String;IZ)V", "getFileId", "()Ljava/lang/String;", "getFilePath", "getFileName", "getFileSize", "()J", "getSn", "getImageUuid", "getMediaType", "getWidth", "()I", "getHeight", "getDuration", "getCreateTime", "getModifyTime", "getDownloadTime", "getGeoLocationInfo", "()Lcom/larus/platform/model/GeoLocationInfo;", "getSourceType", "getProcessingStatus", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "", "hashCode", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class ThumbnailMetadata implements Serializable {
    public static final int $stable = 8;
    private final long createTime;
    private final long downloadTime;
    private final long duration;
    private final String fileId;
    private final String fileName;
    private final String filePath;
    private final long fileSize;
    private final GeoLocationInfo geoLocationInfo;
    private final int height;
    private final long imageUuid;
    private final boolean isSynced;
    private final String mediaType;
    private final long modifyTime;
    private final int processingStatus;
    private final String sn;
    private final String sourceType;
    private final int width;

    public static /* synthetic */ ThumbnailMetadata copy$default(ThumbnailMetadata r17, String r18, String r19, String r20, long r21, String r23, long r24, String r26, int r27, int r28, long r29, long r31, long r33, long r35, GeoLocationInfo r37, String r38, int r39, boolean r40, int r41, Object r42) {
        if ((r41 & 1) == 0) goto L5;
        String r2 = r17.fileId;
    L7:
        if ((r41 & 2) == 0) goto L9;
        String r3 = r17.filePath;
    L11:
        if ((r41 & 4) == 0) goto L13;
        String r4 = r17.fileName;
    L15:
        if ((r41 & 8) == 0) goto L17;
        long r5 = r17.fileSize;
    L19:
        if ((r41 & 16) == 0) goto L21;
        String r7 = r17.sn;
    L23:
        if ((r41 & 32) == 0) goto L25;
        long r8 = r17.imageUuid;
    L27:
        if ((r41 & 64) == 0) goto L29;
        String r10 = r17.mediaType;
    L31:
        if ((r41 & 128) == 0) goto L33;
        int r11 = r17.width;
    L35:
        if ((r41 & 256) == 0) goto L37;
        int r12 = r17.height;
    L39:
        if ((r41 & 512) == 0) goto L41;
        long r13 = r17.duration;
    L42:
        long r210 = r13;
        if ((r41 & 1024) == 0) goto L45;
        long r14 = r17.createTime;
    L46:
        long r32 = r14;
        if ((r41 & 2048) == 0) goto L49;
        long r15 = r17.modifyTime;
    L50:
        long r34 = r15;
        if ((r41 & 4096) == 0) goto L53;
        long r16 = r17.downloadTime;
    L55:
        if ((r41 & 8192) == 0) goto L57;
        GeoLocationInfo r110 = r17.geoLocationInfo;
    L58:
        GeoLocationInfo r310 = r110;
        if ((r41 & 16384) == 0) goto L61;
        String r111 = r17.sourceType;
    L62:
        String r311 = r111;
        if ((r41 & 32768) == 0) goto L65;
        int r112 = r17.processingStatus;
    L67:
        if ((r41 & 65536) == 0) goto L69;
        boolean r1 = r17.isSynced;
    L71:
        return r17.copy(r2, r3, r4, r5, r7, r8, r10, r11, r12, r210, r32, r34, r16, r310, r311, r112, r1);
    L69:
        r1 = r40;
        goto L71
    L65:
        r112 = r39;
        goto L67
    L61:
        r111 = r38;
        goto L62
    L57:
        r110 = r37;
        goto L58
    L53:
        r16 = r35;
        goto L55
    L49:
        r15 = r33;
        goto L50
    L45:
        r14 = r31;
        goto L46
    L41:
        r13 = r29;
        goto L42
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
        r8 = r24;
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
        return this.fileId;
    }

    public final long component10() {
        return this.duration;
    }

    public final long component11() {
        return this.createTime;
    }

    public final long component12() {
        return this.modifyTime;
    }

    public final long component13() {
        return this.downloadTime;
    }

    public final GeoLocationInfo component14() {
        return this.geoLocationInfo;
    }

    public final String component15() {
        return this.sourceType;
    }

    public final int component16() {
        return this.processingStatus;
    }

    public final boolean component17() {
        return this.isSynced;
    }

    public final String component2() {
        return this.filePath;
    }

    public final String component3() {
        return this.fileName;
    }

    public final long component4() {
        return this.fileSize;
    }

    public final String component5() {
        return this.sn;
    }

    public final long component6() {
        return this.imageUuid;
    }

    public final String component7() {
        return this.mediaType;
    }

    public final int component8() {
        return this.width;
    }

    public final int component9() {
        return this.height;
    }

    public final ThumbnailMetadata copy(String r27, String r28, String r29, long r30, String r32, long r33, String r35, int r36, int r37, long r38, long r40, long r42, long r44, GeoLocationInfo r46, String r47, int r48, boolean r49) {
        Intrinsics.checkNotNullParameter(r27, "fileId");
        Intrinsics.checkNotNullParameter(r28, "filePath");
        Intrinsics.checkNotNullParameter(r29, "fileName");
        Intrinsics.checkNotNullParameter(r32, "sn");
        Intrinsics.checkNotNullParameter(r35, "mediaType");
        Intrinsics.checkNotNullParameter(r47, "sourceType");
        return new ThumbnailMetadata(r27, r28, r29, r30, r32, r33, r35, r36, r37, r38, r40, r42, r44, r46, r47, r48, r49);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ThumbnailMetadata) == true) goto L8;
        return false;
    L8:
        ThumbnailMetadata r9 = (ThumbnailMetadata) r8;
        if (Intrinsics.areEqual(this.fileId, r9.fileId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.filePath, r9.filePath) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.fileName, r9.fileName) == true) goto L18;
        return false;
    L18:
        if (this.fileSize == r9.fileSize) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sn, r9.sn) == true) goto L24;
        return false;
    L24:
        if (this.imageUuid == r9.imageUuid) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.mediaType, r9.mediaType) == true) goto L30;
        return false;
    L30:
        if (this.width == r9.width) goto L33;
        return false;
    L33:
        if (this.height == r9.height) goto L36;
        return false;
    L36:
        if (this.duration == r9.duration) goto L39;
        return false;
    L39:
        if (this.createTime == r9.createTime) goto L42;
        return false;
    L42:
        if (this.modifyTime == r9.modifyTime) goto L45;
        return false;
    L45:
        if (this.downloadTime == r9.downloadTime) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.geoLocationInfo, r9.geoLocationInfo) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.sourceType, r9.sourceType) == true) goto L54;
        return false;
    L54:
        if (this.processingStatus == r9.processingStatus) goto L57;
        return false;
    L57:
        if (this.isSynced == r9.isSynced) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        int r0 = ((((this.fileId.hashCode() * 31) + this.filePath.hashCode()) * 31) + this.fileName.hashCode()) * 31;
        long r1 = this.fileSize;
        int r2 = (((r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.sn.hashCode()) * 31;
        long r3 = this.imageUuid;
        int r4 = (((((((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.mediaType.hashCode()) * 31) + this.width) * 31) + this.height) * 31;
        long r5 = this.duration;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        long r7 = this.createTime;
        int r8 = (r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31;
        long r9 = this.modifyTime;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        long r11 = this.downloadTime;
        int r12 = (r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31;
        GeoLocationInfo r13 = this.geoLocationInfo;
        if (r13 != null) goto L5;
        int r14 = 0;
    L6:
        int r15 = (((((r12 + r14) * 31) + this.sourceType.hashCode()) * 31) + this.processingStatus) * 31;
        if (this.isSynced == false) goto L9;
        int r16 = 1231;
    L11:
        return r15 + r16;
    L9:
        r16 = 1237;
        goto L11
    L5:
        r14 = r13.hashCode();
        goto L6
    }

    public String toString() {
        return "ThumbnailMetadata(fileId=" + this.fileId + ", filePath=" + this.filePath + ", fileName=" + this.fileName + ", fileSize=" + this.fileSize + ", sn=" + this.sn + ", imageUuid=" + this.imageUuid + ", mediaType=" + this.mediaType + ", width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", createTime=" + this.createTime + ", modifyTime=" + this.modifyTime + ", downloadTime=" + this.downloadTime + ", geoLocationInfo=" + this.geoLocationInfo + ", sourceType=" + this.sourceType + ", processingStatus=" + this.processingStatus + ", isSynced=" + this.isSynced + ')';
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final long getDownloadTime() {
        return this.downloadTime;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getFileId() {
        return this.fileId;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final String getFilePath() {
        return this.filePath;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final GeoLocationInfo getGeoLocationInfo() {
        return this.geoLocationInfo;
    }

    public final int getHeight() {
        return this.height;
    }

    public final long getImageUuid() {
        return this.imageUuid;
    }

    public final String getMediaType() {
        return this.mediaType;
    }

    public final long getModifyTime() {
        return this.modifyTime;
    }

    public final int getProcessingStatus() {
        return this.processingStatus;
    }

    public final String getSn() {
        return this.sn;
    }

    public final String getSourceType() {
        return this.sourceType;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isSynced() {
        return this.isSynced;
    }

    public ThumbnailMetadata(String r9, String r10, String r11, long r12, String r14, long r15, String r17, int r18, int r19, long r20, long r22, long r24, long r26, GeoLocationInfo r28, String r29, int r30, boolean r31) {
        Intrinsics.checkNotNullParameter(r9, "fileId");
        Intrinsics.checkNotNullParameter(r10, "filePath");
        Intrinsics.checkNotNullParameter(r11, "fileName");
        Intrinsics.checkNotNullParameter(r14, "sn");
        Intrinsics.checkNotNullParameter(r17, "mediaType");
        Intrinsics.checkNotNullParameter(r29, "sourceType");
        this.fileId = r9;
        this.filePath = r10;
        this.fileName = r11;
        this.fileSize = r12;
        this.sn = r14;
        this.imageUuid = r15;
        this.mediaType = r17;
        this.width = r18;
        this.height = r19;
        this.duration = r20;
        this.createTime = r22;
        this.modifyTime = r24;
        this.downloadTime = r26;
        this.geoLocationInfo = r28;
        this.sourceType = r29;
        this.processingStatus = r30;
        this.isSynced = r31;
    }

    public /* synthetic */ ThumbnailMetadata(String r27, String r28, String r29, long r30, String r32, long r33, String r35, int r36, int r37, long r38, long r40, long r42, long r44, GeoLocationInfo r46, String r47, int r48, boolean r49, int r50, DefaultConstructorMarker r51) {
        if ((r50 & 8192) == 0) goto L5;
        GeoLocationInfo r22 = null;
    L7:
        if ((r50 & 16384) == 0) goto L9;
        String r23 = "thumbnail";
    L11:
        if ((32768 & r50) == 0) goto L13;
        int r24 = 0;
    L15:
        if ((r50 & 65536) == 0) goto L17;
        boolean r25 = false;
    L18:
        this(r27, r28, r29, r30, r32, r33, r35, r36, r37, r38, r40, r42, r44, r22, r23, r24, r25);
        return;
    L17:
        r25 = r49;
        goto L18
    L13:
        r24 = r48;
        goto L15
    L9:
        r23 = r47;
        goto L11
    L5:
        r22 = r46;
        goto L7
    }
}
