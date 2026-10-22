package com.larus.avlink.gallery.model;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.utils.logger.FLogger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u008d\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u000b¢\u0006\u0004\b \u0010!J\u0006\u0010B\u001a\u00020CJ\u0006\u0010D\u001a\u00020CJ\u0006\u0010E\u001a\u00020CJ\u0006\u0010F\u001a\u00020CJ\u0006\u0010G\u001a\u00020\u0003J\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00030IJ\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00030IJ\u001c\u0010K\u001a\u00020C2\b\u0010L\u001a\u0004\u0018\u00010\u00032\b\u0010M\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010N\u001a\u00020\u0003J\t\u0010O\u001a\u00020\u0003HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\u0010\u0010Q\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010R\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010S\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u0010T\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010U\u001a\u00020\u000bHÆ\u0003J\t\u0010V\u001a\u00020\u000bHÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J\t\u0010X\u001a\u00020\u000bHÆ\u0003J\t\u0010Y\u001a\u00020\u000bHÆ\u0003J\t\u0010Z\u001a\u00020\u0011HÆ\u0003J\t\u0010[\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010^\u001a\u00020\u0017HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010f\u001a\u00020\u000bHÆ\u0003J\u0098\u0002\u0010g\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010hJ\u0013\u0010i\u001a\u00020C2\b\u0010j\u001a\u0004\u0018\u00010kHÖ\u0003J\t\u0010l\u001a\u00020\u000bHÖ\u0001J\t\u0010m\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010(\u001a\u0004\b*\u0010'R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010-R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010%R\u0011\u0010\u000e\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b0\u0010-R\u0011\u0010\u000f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010-R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b4\u0010%R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b7\u0010#R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b:\u00109R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010#R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b<\u0010#R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010#R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010#R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010#R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010#R\u0011\u0010\u001f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\bA\u0010-¨\u0006n"}, d2 = {"Lcom/larus/avlink/gallery/model/MediaMetadata;", "Ljava/io/Serializable;", "uniqId", "", "mediaId", "", "systemGalleryId", "fileName", "fileSize", "mediaType", "width", "", "height", "duration", "outVideoWidth", "outVideoHeight", "outputVideoCrop", "", "createTime", "geoLocationInfo", "Lcom/larus/platform/model/GeoLocationInfo;", "algorithmType", "lifecycleState", "Lcom/larus/avlink/gallery/model/MediaLifecycleState;", "failureStage", "failureReason", "downloadFilePath", "tempFilePath", "unpackDirPath", "processedFilePath", "finalFilePath", "activeMask", "<init>", "(Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;IIJIIDJLcom/larus/platform/model/GeoLocationInfo;Ljava/lang/String;Lcom/larus/avlink/gallery/model/MediaLifecycleState;Lcom/larus/avlink/gallery/model/MediaLifecycleState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "getUniqId", "()Ljava/lang/String;", "getMediaId", "()J", "getSystemGalleryId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getFileName", "getFileSize", "getMediaType", "getWidth", "()I", "getHeight", "getDuration", "getOutVideoWidth", "getOutVideoHeight", "getOutputVideoCrop", "()D", "getCreateTime", "getGeoLocationInfo", "()Lcom/larus/platform/model/GeoLocationInfo;", "getAlgorithmType", "getLifecycleState", "()Lcom/larus/avlink/gallery/model/MediaLifecycleState;", "getFailureStage", "getFailureReason", "getDownloadFilePath", "getTempFilePath", "getUnpackDirPath", "getProcessedFilePath", "getFinalFilePath", "getActiveMask", "isCompleted", "", "isFailed", "isSyncedToSystemAlbum", "isInProgress", "getCurrentFilePath", "getAllFilePaths", "", "getObsoleteFilePaths", "isSamePath", "path", "otherPath", "getFilePath", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "component21", "component22", "component23", "component24", "copy", "(Ljava/lang/String;JLjava/lang/Long;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;IIJIIDJLcom/larus/platform/model/GeoLocationInfo;Ljava/lang/String;Lcom/larus/avlink/gallery/model/MediaLifecycleState;Lcom/larus/avlink/gallery/model/MediaLifecycleState;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lcom/larus/avlink/gallery/model/MediaMetadata;", "equals", "other", "", "hashCode", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class MediaMetadata implements Serializable {
    public static final int $stable = 8;
    private final int activeMask;
    private final String algorithmType;
    private final long createTime;
    private final String downloadFilePath;
    private final long duration;
    private final String failureReason;
    private final MediaLifecycleState failureStage;
    private final String fileName;
    private final Long fileSize;
    private final String finalFilePath;
    private final GeoLocationInfo geoLocationInfo;
    private final int height;
    private final MediaLifecycleState lifecycleState;
    private final long mediaId;
    private final String mediaType;
    private final int outVideoHeight;
    private final int outVideoWidth;
    private final double outputVideoCrop;
    private final String processedFilePath;
    private final Long systemGalleryId;
    private final String tempFilePath;
    private final String uniqId;
    private final String unpackDirPath;
    private final int width;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MediaLifecycleState.values().length];
            r0[MediaLifecycleState.DOWNLOAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r0[MediaLifecycleState.DOWNLOADED_TEMP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r0[MediaLifecycleState.PROCESSING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r0[MediaLifecycleState.PROCESSED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[MediaLifecycleState.SYNCING_TO_SYSTEM_ALBUM.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r0[MediaLifecycleState.COMPLETED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r0[MediaLifecycleState.FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            a = r0;
        }
    }

    public static /* synthetic */ MediaMetadata copy$default(MediaMetadata r17, String r18, long r19, Long r21, String r22, Long r23, String r24, int r25, int r26, long r27, int r29, int r30, double r31, long r33, GeoLocationInfo r35, String r36, MediaLifecycleState r37, MediaLifecycleState r38, String r39, String r40, String r41, String r42, String r43, String r44, int r45, int r46, Object r47) {
        if ((r46 & 1) == 0) goto L5;
        String r2 = r17.uniqId;
    L7:
        if ((r46 & 2) == 0) goto L9;
        long r3 = r17.mediaId;
    L11:
        if ((r46 & 4) == 0) goto L13;
        Long r5 = r17.systemGalleryId;
    L15:
        if ((r46 & 8) == 0) goto L17;
        String r6 = r17.fileName;
    L19:
        if ((r46 & 16) == 0) goto L21;
        Long r7 = r17.fileSize;
    L23:
        if ((r46 & 32) == 0) goto L25;
        String r8 = r17.mediaType;
    L27:
        if ((r46 & 64) == 0) goto L29;
        int r9 = r17.width;
    L31:
        if ((r46 & 128) == 0) goto L33;
        int r10 = r17.height;
    L35:
        if ((r46 & 256) == 0) goto L37;
        long r11 = r17.duration;
    L39:
        if ((r46 & 512) == 0) goto L41;
        int r13 = r17.outVideoWidth;
    L43:
        if ((r46 & 1024) == 0) goto L45;
        int r14 = r17.outVideoHeight;
    L46:
        int r32 = r14;
        if ((r46 & 2048) == 0) goto L49;
        double r15 = r17.outputVideoCrop;
    L50:
        double r34 = r15;
        if ((r46 & 4096) == 0) goto L53;
        long r16 = r17.createTime;
    L54:
        long r310 = r16;
        if ((r46 & 8192) == 0) goto L57;
        GeoLocationInfo r110 = r17.geoLocationInfo;
    L59:
        if ((r46 & 16384) == 0) goto L61;
        String r111 = r17.algorithmType;
    L62:
        String r311 = r111;
        if ((r46 & 32768) == 0) goto L65;
        MediaLifecycleState r112 = r17.lifecycleState;
    L66:
        MediaLifecycleState r312 = r112;
        if ((r46 & 65536) == 0) goto L69;
        MediaLifecycleState r113 = r17.failureStage;
    L70:
        MediaLifecycleState r313 = r113;
        if ((r46 & 131072) == 0) goto L73;
        String r114 = r17.failureReason;
    L74:
        String r314 = r114;
        if ((r46 & 262144) == 0) goto L77;
        String r115 = r17.downloadFilePath;
    L78:
        String r48 = r115;
        if ((r46 & 524288) == 0) goto L81;
        String r116 = r17.tempFilePath;
    L82:
        String r49 = r116;
        if ((r46 & 1048576) == 0) goto L85;
        String r117 = r17.unpackDirPath;
    L86:
        String r410 = r117;
        if ((r46 & 2097152) == 0) goto L89;
        String r118 = r17.processedFilePath;
    L90:
        String r411 = r118;
        if ((r46 & 4194304) == 0) goto L93;
        String r119 = r17.finalFilePath;
    L95:
        if ((r46 & 8388608) == 0) goto L97;
        int r1 = r17.activeMask;
    L99:
        return r17.copy(r2, r3, r5, r6, r7, r8, r9, r10, r11, r13, r32, r34, r310, r110, r311, r312, r313, r314, r48, r49, r410, r411, r119, r1);
    L97:
        r1 = r45;
        goto L99
    L93:
        r119 = r44;
        goto L95
    L89:
        r118 = r43;
        goto L90
    L85:
        r117 = r42;
        goto L86
    L81:
        r116 = r41;
        goto L82
    L77:
        r115 = r40;
        goto L78
    L73:
        r114 = r39;
        goto L74
    L69:
        r113 = r38;
        goto L70
    L65:
        r112 = r37;
        goto L66
    L61:
        r111 = r36;
        goto L62
    L57:
        r110 = r35;
        goto L59
    L53:
        r16 = r33;
        goto L54
    L49:
        r15 = r31;
        goto L50
    L45:
        r14 = r30;
        goto L46
    L41:
        r13 = r29;
        goto L43
    L37:
        r11 = r27;
        goto L39
    L33:
        r10 = r26;
        goto L35
    L29:
        r9 = r25;
        goto L31
    L25:
        r8 = r24;
        goto L27
    L21:
        r7 = r23;
        goto L23
    L17:
        r6 = r22;
        goto L19
    L13:
        r5 = r21;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.uniqId;
    }

    public final int component10() {
        return this.outVideoWidth;
    }

    public final int component11() {
        return this.outVideoHeight;
    }

    public final double component12() {
        return this.outputVideoCrop;
    }

    public final long component13() {
        return this.createTime;
    }

    public final GeoLocationInfo component14() {
        return this.geoLocationInfo;
    }

    public final String component15() {
        return this.algorithmType;
    }

    public final MediaLifecycleState component16() {
        return this.lifecycleState;
    }

    public final MediaLifecycleState component17() {
        return this.failureStage;
    }

    public final String component18() {
        return this.failureReason;
    }

    public final String component19() {
        return this.downloadFilePath;
    }

    public final long component2() {
        return this.mediaId;
    }

    public final String component20() {
        return this.tempFilePath;
    }

    public final String component21() {
        return this.unpackDirPath;
    }

    public final String component22() {
        return this.processedFilePath;
    }

    public final String component23() {
        return this.finalFilePath;
    }

    public final int component24() {
        return this.activeMask;
    }

    public final Long component3() {
        return this.systemGalleryId;
    }

    public final String component4() {
        return this.fileName;
    }

    public final Long component5() {
        return this.fileSize;
    }

    public final String component6() {
        return this.mediaType;
    }

    public final int component7() {
        return this.width;
    }

    public final int component8() {
        return this.height;
    }

    public final long component9() {
        return this.duration;
    }

    public final MediaMetadata copy(String r32, long r33, Long r35, String r36, Long r37, String r38, int r39, int r40, long r41, int r43, int r44, double r45, long r47, GeoLocationInfo r49, String r50, MediaLifecycleState r51, MediaLifecycleState r52, String r53, String r54, String r55, String r56, String r57, String r58, int r59) {
        Intrinsics.checkNotNullParameter(r32, "uniqId");
        Intrinsics.checkNotNullParameter(r51, "lifecycleState");
        return new MediaMetadata(r32, r33, r35, r36, r37, r38, r39, r40, r41, r43, r44, r45, r47, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof MediaMetadata) == true) goto L8;
        return false;
    L8:
        MediaMetadata r9 = (MediaMetadata) r8;
        if (Intrinsics.areEqual(this.uniqId, r9.uniqId) == true) goto L12;
        return false;
    L12:
        if (this.mediaId == r9.mediaId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.systemGalleryId, r9.systemGalleryId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.fileName, r9.fileName) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.fileSize, r9.fileSize) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.mediaType, r9.mediaType) == true) goto L27;
        return false;
    L27:
        if (this.width == r9.width) goto L30;
        return false;
    L30:
        if (this.height == r9.height) goto L33;
        return false;
    L33:
        if (this.duration == r9.duration) goto L36;
        return false;
    L36:
        if (this.outVideoWidth == r9.outVideoWidth) goto L39;
        return false;
    L39:
        if (this.outVideoHeight == r9.outVideoHeight) goto L42;
        return false;
    L42:
        if (Double.compare(this.outputVideoCrop, r9.outputVideoCrop) == 0) goto L45;
        return false;
    L45:
        if (this.createTime == r9.createTime) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.geoLocationInfo, r9.geoLocationInfo) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.algorithmType, r9.algorithmType) == true) goto L54;
        return false;
    L54:
        if (this.lifecycleState == r9.lifecycleState) goto L57;
        return false;
    L57:
        if (this.failureStage == r9.failureStage) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.failureReason, r9.failureReason) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.downloadFilePath, r9.downloadFilePath) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.tempFilePath, r9.tempFilePath) == true) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.unpackDirPath, r9.unpackDirPath) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.processedFilePath, r9.processedFilePath) == true) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.finalFilePath, r9.finalFilePath) == true) goto L78;
        return false;
    L78:
        if (this.activeMask == r9.activeMask) goto L80;
        return false;
    L80:
        return true;
    }

    public final List<String> getAllFilePaths() {
        String[] r0 = new String[6];
        boolean r2 = false;
        r0[0] = this.downloadFilePath;
        r0[1] = this.tempFilePath;
        r0[2] = this.unpackDirPath;
        r0[3] = this.processedFilePath;
        r0[4] = this.finalFilePath;
        String r1 = getFilePath();
        if (r1.length() <= 0) goto L5;
        r2 = true;
    L5:
        if (r2 == true) goto L8;
        r1 = null;
    L8:
        r0[5] = r1;
        return CollectionsKt.distinct(CollectionsKt.listOfNotNull(r0));
    }

    public int hashCode() {
        int r0 = this.uniqId.hashCode() * 31;
        long r1 = this.mediaId;
        int r2 = (r0 + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        Long r3 = this.systemGalleryId;
        int r4 = 0;
        if (r3 != null) goto L5;
        int r5 = 0;
    L6:
        int r6 = (r2 + r5) * 31;
        String r7 = this.fileName;
        if (r7 != null) goto L9;
        int r8 = 0;
    L10:
        int r9 = (r6 + r8) * 31;
        Long r10 = this.fileSize;
        if (r10 != null) goto L13;
        int r11 = 0;
    L14:
        int r12 = (r9 + r11) * 31;
        String r13 = this.mediaType;
        if (r13 != null) goto L17;
        int r14 = 0;
    L18:
        int r15 = (((((r12 + r14) * 31) + this.width) * 31) + this.height) * 31;
        long r16 = this.duration;
        int r17 = (((((r15 + ((int) (r16 ^ (r16 >>> 32)))) * 31) + this.outVideoWidth) * 31) + this.outVideoHeight) * 31;
        long r18 = Double.doubleToLongBits(this.outputVideoCrop);
        int r19 = (r17 + ((int) (r18 ^ (r18 >>> 32)))) * 31;
        long r20 = this.createTime;
        int r21 = (r19 + ((int) (r20 ^ (r20 >>> 32)))) * 31;
        GeoLocationInfo r22 = this.geoLocationInfo;
        if (r22 != null) goto L21;
        int r23 = 0;
    L22:
        int r24 = (r21 + r23) * 31;
        String r25 = this.algorithmType;
        if (r25 != null) goto L25;
        int r26 = 0;
    L26:
        int r27 = (((r24 + r26) * 31) + this.lifecycleState.hashCode()) * 31;
        MediaLifecycleState r28 = this.failureStage;
        if (r28 != null) goto L29;
        int r29 = 0;
    L30:
        int r30 = (r27 + r29) * 31;
        String r31 = this.failureReason;
        if (r31 != null) goto L33;
        int r32 = 0;
    L34:
        int r33 = (r30 + r32) * 31;
        String r34 = this.downloadFilePath;
        if (r34 != null) goto L37;
        int r35 = 0;
    L38:
        int r36 = (r33 + r35) * 31;
        String r37 = this.tempFilePath;
        if (r37 != null) goto L41;
        int r38 = 0;
    L42:
        int r39 = (r36 + r38) * 31;
        String r40 = this.unpackDirPath;
        if (r40 != null) goto L45;
        int r41 = 0;
    L46:
        int r42 = (r39 + r41) * 31;
        String r43 = this.processedFilePath;
        if (r43 != null) goto L49;
        int r44 = 0;
    L50:
        int r45 = (r42 + r44) * 31;
        String r46 = this.finalFilePath;
        if (r46 == null) goto L55;
        r4 = r46.hashCode();
    L55:
        return ((r45 + r4) * 31) + this.activeMask;
    L49:
        r44 = r43.hashCode();
        goto L50
    L45:
        r41 = r40.hashCode();
        goto L46
    L41:
        r38 = r37.hashCode();
        goto L42
    L37:
        r35 = r34.hashCode();
        goto L38
    L33:
        r32 = r31.hashCode();
        goto L34
    L29:
        r29 = r28.hashCode();
        goto L30
    L25:
        r26 = r25.hashCode();
        goto L26
    L21:
        r23 = r22.hashCode();
        goto L22
    L17:
        r14 = r13.hashCode();
        goto L18
    L13:
        r11 = r10.hashCode();
        goto L14
    L9:
        r8 = r7.hashCode();
        goto L10
    L5:
        r5 = r3.hashCode();
        goto L6
    }

    public String toString() {
        return "MediaMetadata(uniqId=" + this.uniqId + ", mediaId=" + this.mediaId + ", systemGalleryId=" + this.systemGalleryId + ", fileName=" + this.fileName + ", fileSize=" + this.fileSize + ", mediaType=" + this.mediaType + ", width=" + this.width + ", height=" + this.height + ", duration=" + this.duration + ", outVideoWidth=" + this.outVideoWidth + ", outVideoHeight=" + this.outVideoHeight + ", outputVideoCrop=" + this.outputVideoCrop + ", createTime=" + this.createTime + ", geoLocationInfo=" + this.geoLocationInfo + ", algorithmType=" + this.algorithmType + ", lifecycleState=" + this.lifecycleState + ", failureStage=" + this.failureStage + ", failureReason=" + this.failureReason + ", downloadFilePath=" + this.downloadFilePath + ", tempFilePath=" + this.tempFilePath + ", unpackDirPath=" + this.unpackDirPath + ", processedFilePath=" + this.processedFilePath + ", finalFilePath=" + this.finalFilePath + ", activeMask=" + this.activeMask + ')';
    }

    public final String getCurrentFilePath() {
        String r1 = null;
        switch(a.a[this.lifecycleState.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        String r0 = null;
    L13:
        if (r0 != null) goto L15;
    L17:
        String r2 = getFilePath();
        boolean r4 = true;
        if (r2.length() <= 0) goto L20;
        boolean r3 = true;
    L21:
        if (r3 == true) goto L23;
    L25:
        String[] r5 = new String[6];
        r5[0] = this.finalFilePath;
        r5[1] = this.processedFilePath;
        r5[2] = this.tempFilePath;
        r5[3] = this.downloadFilePath;
        r5[4] = this.unpackDirPath;
        if (r2.length() > 0) goto L29;
        r4 = false;
    L29:
        if (r4 == false) goto L31;
        r1 = r2;
    L31:
        r5[5] = r1;
        Iterator r6 = CollectionsKt.listOfNotNull(r5).iterator();
    L33:
        if (r6.hasNext() == false) goto L40;
        String r7 = (String) r6.next();
        if (new PolarisFileWrapper(r7).exists() == false) goto L33;
        if (Intrinsics.areEqual(r7, r0) == true) goto L39;
        FLogger.a.w("MediaMetadata", "File found at unexpected path for " + this.uniqId + ": expected=" + r0 + ", actual=" + r7);
    L39:
        return r7;
    L40:
        if (r0 == null) goto L42;
        return r0;
    L42:
        return r2;
    L23:
        if (new PolarisFileWrapper(r2).exists() == false) goto L25;
        return r2;
    L20:
        r3 = false;
        goto L21
    L15:
        if (new PolarisFileWrapper(r0).exists() == false) goto L17;
        return r0;
    L7:
        r0 = this.finalFilePath;
        goto L13
    L8:
        r0 = this.processedFilePath;
        goto L13
    L9:
        r0 = this.processedFilePath;
        goto L13
    L10:
        r0 = this.tempFilePath;
        goto L13
    L11:
        r0 = this.tempFilePath;
        goto L13
    L12:
        r0 = this.downloadFilePath;
        goto L13
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final String getFilePath() {
        MediaLifecycleState r0 = this.lifecycleState;
        switch(a.a[r0.ordinal()]) {
            case 1: goto L23;
            case 2: goto L18;
            case 3: goto L15;
            case 4: goto L12;
            case 5: goto L9;
            case 6: goto L6;
            case 7: goto L23;
            default: goto L5;
        };
    L6:
        String r1 = this.finalFilePath;
        if (r1 != null) goto L22;
        return "";
    L22:
        return r1;
    L9:
        r1 = this.processedFilePath;
        if (r1 != null) goto L22;
        return "";
    L12:
        r1 = this.processedFilePath;
        if (r1 != null) goto L22;
        return "";
    L15:
        r1 = this.tempFilePath;
        if (r1 != null) goto L22;
        return "";
    L18:
        r1 = this.tempFilePath;
        if (r1 != null) goto L22;
        return "";
    L23:
        return "";
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final List<String> getObsoleteFilePaths() {
        switch(a.a[this.lifecycleState.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        List r0 = CollectionsKt.emptyList();
    L13:
        ArrayList r1 = new ArrayList();
        Iterator r2 = r0.iterator();
    L15:
        if (r2.hasNext() == false) goto L48;
        Object r3 = r2.next();
        String r5 = (String) r3;
        String r6 = this.downloadFilePath;
        if (r5 != null) goto L19;
    L22:
        boolean r7 = true;
    L23:
        if (r7 == true) goto L44;
        if (r6 != null) goto L26;
    L29:
        boolean r8 = true;
    L30:
        if (r8 == true) goto L44;
        PolarisFileWrapper r9 = new PolarisFileWrapper(r5);
        PolarisFileWrapper r10 = new PolarisFileWrapper(r6);
        if (Intrinsics.areEqual(r9.getAbsolutePath(), r10.getAbsolutePath()) == false) goto L49;
    L45:
        boolean r11 = true;
    L46:
        if (r11 == true) goto L15;
        r1.add(r3);
        goto L15
    L49:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L36
        Object r13 = Result.constructor-impl(Boolean.valueOf(Intrinsics.areEqual(r9.getCanonicalPath(), r10.getCanonicalPath())));     // Catch: Throwable -> L36
    L38:
        Boolean r14 = Boolean.FALSE;
        if (Result.isFailure-impl(r13) == false) goto L42;
        r13 = r14;
    L42:
        if (((Boolean) r13).booleanValue() == false) goto L44;
    L36:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L38
    L26:
        if (r6.length() == 0) goto L29;
        r8 = false;
    L44:
        r11 = false;
        goto L46
    L19:
        if (r5.length() == 0) goto L22;
        r7 = false;
        goto L23
    L48:
        return r1;
    L7:
        r0 = CollectionsKt.listOfNotNull(new String[]{this.downloadFilePath, this.tempFilePath, this.unpackDirPath, this.processedFilePath});
        goto L13
    L8:
        r0 = CollectionsKt.listOfNotNull(new String[]{this.downloadFilePath, this.tempFilePath, this.unpackDirPath});
        goto L13
    L9:
        r0 = CollectionsKt.listOfNotNull(new String[]{this.downloadFilePath, this.tempFilePath, this.unpackDirPath});
        goto L13
    L10:
        r0 = CollectionsKt.emptyList();
        goto L13
    L11:
        r0 = CollectionsKt.emptyList();
        goto L13
    L12:
        r0 = CollectionsKt.emptyList();
        goto L13
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isCompleted() {
        if (this.lifecycleState != MediaLifecycleState.COMPLETED) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isFailed() {
        if (this.lifecycleState != MediaLifecycleState.FAILED) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isInProgress() {
        MediaLifecycleState r0 = this.lifecycleState;
        if (r0 != MediaLifecycleState.COMPLETED) goto L5;
    L7:
        return false;
    L5:
        if (r0 == MediaLifecycleState.FAILED) goto L7;
        return true;
    }

    public final boolean isSyncedToSystemAlbum() {
        if (this.lifecycleState != MediaLifecycleState.COMPLETED) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getActiveMask() {
        return this.activeMask;
    }

    public final String getAlgorithmType() {
        return this.algorithmType;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public final String getDownloadFilePath() {
        return this.downloadFilePath;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final String getFailureReason() {
        return this.failureReason;
    }

    public final MediaLifecycleState getFailureStage() {
        return this.failureStage;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Long getFileSize() {
        return this.fileSize;
    }

    public final String getFinalFilePath() {
        return this.finalFilePath;
    }

    public final GeoLocationInfo getGeoLocationInfo() {
        return this.geoLocationInfo;
    }

    public final int getHeight() {
        return this.height;
    }

    public final MediaLifecycleState getLifecycleState() {
        return this.lifecycleState;
    }

    public final long getMediaId() {
        return this.mediaId;
    }

    public final String getMediaType() {
        return this.mediaType;
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

    public final String getProcessedFilePath() {
        return this.processedFilePath;
    }

    public final Long getSystemGalleryId() {
        return this.systemGalleryId;
    }

    public final String getTempFilePath() {
        return this.tempFilePath;
    }

    public final String getUniqId() {
        return this.uniqId;
    }

    public final String getUnpackDirPath() {
        return this.unpackDirPath;
    }

    public final int getWidth() {
        return this.width;
    }

    public MediaMetadata(String r6, long r7, Long r9, String r10, Long r11, String r12, int r13, int r14, long r15, int r17, int r18, double r19, long r21, GeoLocationInfo r23, String r24, MediaLifecycleState r25, MediaLifecycleState r26, String r27, String r28, String r29, String r30, String r31, String r32, int r33) {
        Intrinsics.checkNotNullParameter(r6, "uniqId");
        Intrinsics.checkNotNullParameter(r25, "lifecycleState");
        this.uniqId = r6;
        this.mediaId = r7;
        this.systemGalleryId = r9;
        this.fileName = r10;
        this.fileSize = r11;
        this.mediaType = r12;
        this.width = r13;
        this.height = r14;
        this.duration = r15;
        this.outVideoWidth = r17;
        this.outVideoHeight = r18;
        this.outputVideoCrop = r19;
        this.createTime = r21;
        this.geoLocationInfo = r23;
        this.algorithmType = r24;
        this.lifecycleState = r25;
        this.failureStage = r26;
        this.failureReason = r27;
        this.downloadFilePath = r28;
        this.tempFilePath = r29;
        this.unpackDirPath = r30;
        this.processedFilePath = r31;
        this.finalFilePath = r32;
        this.activeMask = r33;
    }

    public /* synthetic */ MediaMetadata(String r35, long r36, Long r38, String r39, Long r40, String r41, int r42, int r43, long r44, int r46, int r47, double r48, long r50, GeoLocationInfo r52, String r53, MediaLifecycleState r54, MediaLifecycleState r55, String r56, String r57, String r58, String r59, String r60, String r61, int r62, int r63, DefaultConstructorMarker r64) {
        if ((r63 & 4) == 0) goto L5;
        Long r9 = 0L;
    L7:
        if ((r63 & 8) == 0) goto L9;
        String r10 = "";
    L11:
        if ((r63 & 16) == 0) goto L13;
        Long r11 = 0L;
    L15:
        if ((r63 & 32) == 0) goto L17;
        String r12 = "image";
    L19:
        if ((r63 & 64) == 0) goto L21;
        int r13 = 3024;
    L23:
        if ((r63 & 128) == 0) goto L25;
        int r14 = 4032;
    L27:
        if ((r63 & 256) == 0) goto L29;
        long r15 = 0;
    L31:
        if ((r63 & 512) == 0) goto L33;
        int r17 = 1920;
    L35:
        if ((r63 & 1024) == 0) goto L37;
        int r18 = 1440;
    L39:
        if ((r63 & 2048) == 0) goto L41;
        double r19 = 0.8d;
    L43:
        if ((r63 & 4096) == 0) goto L45;
        long r21 = System.currentTimeMillis();
    L47:
        if ((r63 & 8192) == 0) goto L49;
        GeoLocationInfo r23 = null;
    L51:
        if ((r63 & 16384) == 0) goto L53;
        String r24 = null;
    L55:
        if ((32768 & r63) == 0) goto L57;
        MediaLifecycleState r25 = MediaLifecycleState.DOWNLOAD;
    L59:
        if ((65536 & r63) == 0) goto L61;
        MediaLifecycleState r26 = null;
    L63:
        if ((131072 & r63) == 0) goto L65;
        String r27 = null;
    L67:
        if ((262144 & r63) == 0) goto L69;
        String r28 = null;
    L71:
        if ((524288 & r63) == 0) goto L73;
        String r29 = null;
    L75:
        if ((1048576 & r63) == 0) goto L77;
        String r30 = null;
    L79:
        if ((2097152 & r63) == 0) goto L81;
        String r31 = null;
    L83:
        if ((4194304 & r63) == 0) goto L85;
        String r32 = null;
    L87:
        if ((r63 & 8388608) == 0) goto L89;
        int r33 = 0;
    L90:
        this(r35, r36, r9, r10, r11, r12, r13, r14, r15, r17, r18, r19, r21, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33);
        return;
    L89:
        r33 = r62;
        goto L90
    L85:
        r32 = r61;
        goto L87
    L81:
        r31 = r60;
        goto L83
    L77:
        r30 = r59;
        goto L79
    L73:
        r29 = r58;
        goto L75
    L69:
        r28 = r57;
        goto L71
    L65:
        r27 = r56;
        goto L67
    L61:
        r26 = r55;
        goto L63
    L57:
        r25 = r54;
        goto L59
    L53:
        r24 = r53;
        goto L55
    L49:
        r23 = r52;
        goto L51
    L45:
        r21 = r50;
        goto L47
    L41:
        r19 = r48;
        goto L43
    L37:
        r18 = r47;
        goto L39
    L33:
        r17 = r46;
        goto L35
    L29:
        r15 = r44;
        goto L31
    L25:
        r14 = r43;
        goto L27
    L21:
        r13 = r42;
        goto L23
    L17:
        r12 = r41;
        goto L19
    L13:
        r11 = r40;
        goto L15
    L9:
        r10 = r39;
        goto L11
    L5:
        r9 = r38;
        goto L7
    }
}
