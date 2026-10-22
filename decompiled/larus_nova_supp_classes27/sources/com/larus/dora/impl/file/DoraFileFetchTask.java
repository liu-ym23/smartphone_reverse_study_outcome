package com.larus.dora.impl.file;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b7\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BÓ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u00020\f2\b\b\u0002\u00103\u001a\u00020\bJ\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u00109\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010@\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u0010\u0010A\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÚ\u0001\u0010E\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010FJ\u0013\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020KHÖ\u0001J\t\u0010L\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u001a\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b,\u0010 R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b-\u0010 R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001bR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001bR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001b¨\u0006M"}, d2 = {"Lcom/larus/dora/impl/file/DoraFileFetchTask;", "", "id", "", "sn", "remotePath", "localPath", "downloadedBytes", "", "status", "Lcom/larus/dora/impl/file/DoraFileTaskStatus;", "originTrigger", "Lcom/larus/dora/impl/file/DoraTaskTrigger;", "lastTrigger", "triggerHistory", "fileType", "Lcom/larus/dora/impl/file/DoraFileType;", "fileName", "fileMd5", "fileCreateTimeMs", "fileTotalSize", "firmwareVersion", "transportType", "fetchFrom", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/dora/impl/file/DoraFileTaskStatus;Lcom/larus/dora/impl/file/DoraTaskTrigger;Lcom/larus/dora/impl/file/DoraTaskTrigger;Ljava/lang/String;Lcom/larus/dora/impl/file/DoraFileType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getSn", "getRemotePath", "getLocalPath", "getDownloadedBytes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStatus", "()Lcom/larus/dora/impl/file/DoraFileTaskStatus;", "getOriginTrigger", "()Lcom/larus/dora/impl/file/DoraTaskTrigger;", "getLastTrigger", "getTriggerHistory", "getFileType", "()Lcom/larus/dora/impl/file/DoraFileType;", "getFileName", "getFileMd5", "getFileCreateTimeMs", "getFileTotalSize", "getFirmwareVersion", "getTransportType", "getFetchFrom", "appendTrigger", "trigger", "timestampMillis", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/dora/impl/file/DoraFileTaskStatus;Lcom/larus/dora/impl/file/DoraTaskTrigger;Lcom/larus/dora/impl/file/DoraTaskTrigger;Ljava/lang/String;Lcom/larus/dora/impl/file/DoraFileType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/dora/impl/file/DoraFileFetchTask;", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraFileFetchTask {

    @SerializedName("downloaded_bytes")
    private final Long downloadedBytes;

    @SerializedName("fetch_from")
    private final String fetchFrom;

    @SerializedName("file_create_time_ms")
    private final Long fileCreateTimeMs;

    @SerializedName("file_md5")
    private final String fileMd5;

    @SerializedName("file_name")
    private final String fileName;

    @SerializedName("file_total_size")
    private final Long fileTotalSize;

    @SerializedName("file_type")
    private final DoraFileType fileType;

    @SerializedName("firmware_version")
    private final String firmwareVersion;

    @SerializedName("id")
    private final String id;

    @SerializedName("last_trigger")
    private final DoraTaskTrigger lastTrigger;

    @SerializedName("local_path")
    private final String localPath;

    @SerializedName("origin_trigger")
    private final DoraTaskTrigger originTrigger;

    @SerializedName("remote_path")
    private final String remotePath;

    @SerializedName("sn")
    private final String sn;

    @SerializedName("status")
    private final DoraFileTaskStatus status;

    @SerializedName("transport_type")
    private final String transportType;

    @SerializedName("trigger_history")
    private final String triggerHistory;

    public DoraFileFetchTask() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    public static /* synthetic */ DoraFileFetchTask copy$default(DoraFileFetchTask r17, String r18, String r110, String r20, String r21, Long r22, DoraFileTaskStatus r23, DoraTaskTrigger r24, DoraTaskTrigger r25, String r26, DoraFileType r27, String r28, String r210, Long r30, Long r31, String r32, String r33, String r34, int r35, Object r36) {
        if ((r35 & 1) == 0) goto L5;
        String r2 = r17.id;
    L7:
        if ((r35 & 2) == 0) goto L9;
        String r3 = r17.sn;
    L11:
        if ((r35 & 4) == 0) goto L13;
        String r4 = r17.remotePath;
    L15:
        if ((r35 & 8) == 0) goto L17;
        String r5 = r17.localPath;
    L19:
        if ((r35 & 16) == 0) goto L21;
        Long r6 = r17.downloadedBytes;
    L23:
        if ((r35 & 32) == 0) goto L25;
        DoraFileTaskStatus r7 = r17.status;
    L27:
        if ((r35 & 64) == 0) goto L29;
        DoraTaskTrigger r8 = r17.originTrigger;
    L31:
        if ((r35 & 128) == 0) goto L33;
        DoraTaskTrigger r9 = r17.lastTrigger;
    L35:
        if ((r35 & 256) == 0) goto L37;
        String r10 = r17.triggerHistory;
    L39:
        if ((r35 & 512) == 0) goto L41;
        DoraFileType r11 = r17.fileType;
    L43:
        if ((r35 & 1024) == 0) goto L45;
        String r12 = r17.fileName;
    L47:
        if ((r35 & 2048) == 0) goto L49;
        String r13 = r17.fileMd5;
    L51:
        if ((r35 & 4096) == 0) goto L53;
        Long r14 = r17.fileCreateTimeMs;
    L55:
        if ((r35 & 8192) == 0) goto L57;
        Long r15 = r17.fileTotalSize;
    L58:
        Long r37 = r15;
        if ((r35 & 16384) == 0) goto L61;
        String r16 = r17.firmwareVersion;
    L62:
        String r38 = r16;
        if ((r35 & 32768) == 0) goto L65;
        String r111 = r17.transportType;
    L67:
        if ((r35 & 65536) == 0) goto L69;
        String r1 = r17.fetchFrom;
    L71:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r37, r38, r111, r1);
    L69:
        r1 = r34;
        goto L71
    L65:
        r111 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r210;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
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

    public final String component1() {
        return this.id;
    }

    public final DoraFileType component10() {
        return this.fileType;
    }

    public final String component11() {
        return this.fileName;
    }

    public final String component12() {
        return this.fileMd5;
    }

    public final Long component13() {
        return this.fileCreateTimeMs;
    }

    public final Long component14() {
        return this.fileTotalSize;
    }

    public final String component15() {
        return this.firmwareVersion;
    }

    public final String component16() {
        return this.transportType;
    }

    public final String component17() {
        return this.fetchFrom;
    }

    public final String component2() {
        return this.sn;
    }

    public final String component3() {
        return this.remotePath;
    }

    public final String component4() {
        return this.localPath;
    }

    public final Long component5() {
        return this.downloadedBytes;
    }

    public final DoraFileTaskStatus component6() {
        return this.status;
    }

    public final DoraTaskTrigger component7() {
        return this.originTrigger;
    }

    public final DoraTaskTrigger component8() {
        return this.lastTrigger;
    }

    public final String component9() {
        return this.triggerHistory;
    }

    public final DoraFileFetchTask copy(String r20, String r21, String r22, String r23, Long r24, DoraFileTaskStatus r25, DoraTaskTrigger r26, DoraTaskTrigger r27, String r28, DoraFileType r210, String r30, String r31, Long r32, Long r33, String r34, String r35, String r36) {
        return new DoraFileFetchTask(r20, r21, r22, r23, r24, r25, r26, r27, r28, r210, r30, r31, r32, r33, r34, r35, r36);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof DoraFileFetchTask) == true) goto L8;
        return false;
    L8:
        DoraFileFetchTask r6 = (DoraFileFetchTask) r5;
        if (Intrinsics.areEqual(this.id, r6.id) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sn, r6.sn) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.remotePath, r6.remotePath) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.localPath, r6.localPath) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.downloadedBytes, r6.downloadedBytes) == true) goto L24;
        return false;
    L24:
        if (this.status == r6.status) goto L27;
        return false;
    L27:
        if (this.originTrigger == r6.originTrigger) goto L30;
        return false;
    L30:
        if (this.lastTrigger == r6.lastTrigger) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.triggerHistory, r6.triggerHistory) == true) goto L36;
        return false;
    L36:
        if (this.fileType == r6.fileType) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.fileName, r6.fileName) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.fileMd5, r6.fileMd5) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.fileCreateTimeMs, r6.fileCreateTimeMs) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.fileTotalSize, r6.fileTotalSize) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.firmwareVersion, r6.firmwareVersion) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.transportType, r6.transportType) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.fetchFrom, r6.fetchFrom) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public int hashCode() {
        String r0 = this.id;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.sn;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.remotePath;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.localPath;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Long r13 = this.downloadedBytes;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        DoraFileTaskStatus r16 = this.status;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        DoraTaskTrigger r20 = this.originTrigger;
        if (r20 != null) goto L29;
        int r21 = 0;
    L30:
        int r22 = (r18 + r21) * 31;
        DoraTaskTrigger r23 = this.lastTrigger;
        if (r23 != null) goto L33;
        int r24 = 0;
    L34:
        int r25 = (r22 + r24) * 31;
        String r26 = this.triggerHistory;
        if (r26 != null) goto L37;
        int r27 = 0;
    L38:
        int r28 = (r25 + r27) * 31;
        DoraFileType r30 = this.fileType;
        if (r30 != null) goto L41;
        int r31 = 0;
    L42:
        int r32 = (r28 + r31) * 31;
        String r33 = this.fileName;
        if (r33 != null) goto L45;
        int r34 = 0;
    L46:
        int r35 = (r32 + r34) * 31;
        String r36 = this.fileMd5;
        if (r36 != null) goto L49;
        int r37 = 0;
    L50:
        int r38 = (r35 + r37) * 31;
        Long r40 = this.fileCreateTimeMs;
        if (r40 != null) goto L53;
        int r41 = 0;
    L54:
        int r42 = (r38 + r41) * 31;
        Long r43 = this.fileTotalSize;
        if (r43 != null) goto L57;
        int r44 = 0;
    L58:
        int r45 = (r42 + r44) * 31;
        String r46 = this.firmwareVersion;
        if (r46 != null) goto L61;
        int r47 = 0;
    L62:
        int r48 = (r45 + r47) * 31;
        String r50 = this.transportType;
        if (r50 != null) goto L65;
        int r51 = 0;
    L66:
        int r52 = (r48 + r51) * 31;
        String r53 = this.fetchFrom;
        if (r53 == null) goto L71;
        r1 = r53.hashCode();
    L71:
        return r52 + r1;
    L65:
        r51 = r50.hashCode();
        goto L66
    L61:
        r47 = r46.hashCode();
        goto L62
    L57:
        r44 = r43.hashCode();
        goto L58
    L53:
        r41 = r40.hashCode();
        goto L54
    L49:
        r37 = r36.hashCode();
        goto L50
    L45:
        r34 = r33.hashCode();
        goto L46
    L41:
        r31 = r30.hashCode();
        goto L42
    L37:
        r27 = r26.hashCode();
        goto L38
    L33:
        r24 = r23.hashCode();
        goto L34
    L29:
        r21 = r20.hashCode();
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
        return "DoraFileFetchTask(id=" + this.id + ", sn=" + this.sn + ", remotePath=" + this.remotePath + ", localPath=" + this.localPath + ", downloadedBytes=" + this.downloadedBytes + ", status=" + this.status + ", originTrigger=" + this.originTrigger + ", lastTrigger=" + this.lastTrigger + ", triggerHistory=" + this.triggerHistory + ", fileType=" + this.fileType + ", fileName=" + this.fileName + ", fileMd5=" + this.fileMd5 + ", fileCreateTimeMs=" + this.fileCreateTimeMs + ", fileTotalSize=" + this.fileTotalSize + ", firmwareVersion=" + this.firmwareVersion + ", transportType=" + this.transportType + ", fetchFrom=" + this.fetchFrom + ')';
    }

    public final Long getDownloadedBytes() {
        return this.downloadedBytes;
    }

    public final String getFetchFrom() {
        return this.fetchFrom;
    }

    public final Long getFileCreateTimeMs() {
        return this.fileCreateTimeMs;
    }

    public final String getFileMd5() {
        return this.fileMd5;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final Long getFileTotalSize() {
        return this.fileTotalSize;
    }

    public final DoraFileType getFileType() {
        return this.fileType;
    }

    public final String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public final String getId() {
        return this.id;
    }

    public final DoraTaskTrigger getLastTrigger() {
        return this.lastTrigger;
    }

    public final String getLocalPath() {
        return this.localPath;
    }

    public final DoraTaskTrigger getOriginTrigger() {
        return this.originTrigger;
    }

    public final String getRemotePath() {
        return this.remotePath;
    }

    public final String getSn() {
        return this.sn;
    }

    public final DoraFileTaskStatus getStatus() {
        return this.status;
    }

    public final String getTransportType() {
        return this.transportType;
    }

    public final String getTriggerHistory() {
        return this.triggerHistory;
    }

    public final DoraFileFetchTask appendTrigger(DoraTaskTrigger r22, long r23) {
        Intrinsics.checkNotNullParameter(r22, "trigger");
        String r0 = "ts=" + r23 + ':' + r22.name();
        String r1 = this.triggerHistory;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L13;
        r0 = this.triggerHistory + ',' + r0;
    L13:
        return copy$default(this, null, null, null, null, null, null, null, r22, r0, null, null, null, null, null, null, null, null, 130687, null);
    L5:
        if (StringsKt.isBlank(r1) == true) goto L8;
        r2 = false;
        goto L9
    }

    public static /* synthetic */ DoraFileFetchTask appendTrigger$default(DoraFileFetchTask r0, DoraTaskTrigger r1, long r2, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = System.currentTimeMillis();
    L6:
        return r0.appendTrigger(r1, r2);
    }

    public DoraFileFetchTask(String r3, String r4, String r5, String r6, Long r7, DoraFileTaskStatus r8, DoraTaskTrigger r9, DoraTaskTrigger r10, String r11, DoraFileType r12, String r13, String r14, Long r15, Long r16, String r17, String r18, String r110) {
        this.id = r3;
        this.sn = r4;
        this.remotePath = r5;
        this.localPath = r6;
        this.downloadedBytes = r7;
        this.status = r8;
        this.originTrigger = r9;
        this.lastTrigger = r10;
        this.triggerHistory = r11;
        this.fileType = r12;
        this.fileName = r13;
        this.fileMd5 = r14;
        this.fileCreateTimeMs = r15;
        this.fileTotalSize = r16;
        this.firmwareVersion = r17;
        this.transportType = r18;
        this.fetchFrom = r110;
    }

    public /* synthetic */ DoraFileFetchTask(String r110, String r20, String r21, String r22, Long r23, DoraFileTaskStatus r24, DoraTaskTrigger r25, DoraTaskTrigger r26, String r27, DoraFileType r28, String r210, String r30, Long r31, Long r32, String r33, String r34, String r35, int r36, DefaultConstructorMarker r37) {
        if ((r36 & 1) == 0) goto L5;
        String r1 = "";
    L7:
        if ((r36 & 2) == 0) goto L9;
        String r3 = "";
    L11:
        if ((r36 & 4) == 0) goto L13;
        String r4 = "";
    L15:
        if ((r36 & 8) == 0) goto L17;
        String r5 = "";
    L19:
        if ((r36 & 16) == 0) goto L21;
        Long r6 = 0L;
    L23:
        if ((r36 & 32) == 0) goto L25;
        DoraFileTaskStatus r9 = DoraFileTaskStatus.PENDING;
    L27:
        if ((r36 & 64) == 0) goto L29;
        DoraTaskTrigger r10 = DoraTaskTrigger.UNKNOWN;
    L31:
        if ((r36 & 128) == 0) goto L33;
        DoraTaskTrigger r11 = r10;
    L35:
        if ((r36 & 256) == 0) goto L37;
        String r12 = "";
    L39:
        if ((r36 & 512) == 0) goto L41;
        DoraFileType r13 = DoraFileType.UNKNOWN;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        String r14 = "";
    L47:
        if ((r36 & 2048) == 0) goto L49;
        String r15 = "";
    L51:
        if ((r36 & 4096) == 0) goto L53;
        Long r2 = 0L;
    L54:
        Long r16 = r2;
        if ((r36 & 8192) == 0) goto L57;
        Long r7 = 0L;
    L59:
        if ((r36 & 16384) == 0) goto L61;
        String r8 = "";
    L63:
        if ((32768 & r36) == 0) goto L65;
        String r17 = "";
    L67:
        if ((r36 & 65536) == 0) goto L69;
        String r0 = "";
    L70:
        this(r1, r3, r4, r5, r6, r9, r10, r11, r12, r13, r14, r15, r16, r7, r8, r17, r0);
        return;
    L69:
        r0 = r35;
        goto L70
    L65:
        r17 = r34;
        goto L67
    L61:
        r8 = r33;
        goto L63
    L57:
        r7 = r32;
        goto L59
    L53:
        r2 = r31;
        goto L54
    L49:
        r15 = r30;
        goto L51
    L45:
        r14 = r210;
        goto L47
    L41:
        r13 = r28;
        goto L43
    L37:
        r12 = r27;
        goto L39
    L33:
        r11 = r26;
        goto L35
    L29:
        r10 = r25;
        goto L31
    L25:
        r9 = r24;
        goto L27
    L21:
        r6 = r23;
        goto L23
    L17:
        r5 = r22;
        goto L19
    L13:
        r4 = r21;
        goto L15
    L9:
        r3 = r20;
        goto L11
    L5:
        r1 = r110;
        goto L7
    }
}
