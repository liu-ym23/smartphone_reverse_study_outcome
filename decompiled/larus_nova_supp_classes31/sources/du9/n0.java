package du9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001Bå\u0001\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0013\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00101\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u000b\u00103\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u000bHÆ\u0003J\t\u00105\u001a\u00020\rHÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u0013\u00108\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010:\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001eJ\u0013\u0010=\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003Jì\u0001\u0010>\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010?J\u0013\u0010@\u001a\u00020\r2\b\u0010A\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010B\u001a\u00020CHÖ\u0001J\t\u0010D\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R \u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001bR \u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR \u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR \u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b.\u0010\u001eR \u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001b¨\u0006E"}, d2 = {"Lcom/larus/settings/provider/chat/FlowMultiUploadConfig;", "", "uploadFileAllowedTypes", "", "", "driveUploadFileAllowedTypes", "uploadFileMaxSize", "", "uploadMultiEntityConf", "Lcom/larus/settings/provider/chat/UploadMultiEntityConf;", "uploadAudioEntityConf", "Lcom/larus/settings/provider/chat/UploadAudioEntityConf;", "enableLarkAudioAbility", "", "uploadVideoEntityConf", "Lcom/larus/settings/provider/chat/UploadVideoEntityConf;", "downloadVideoEntityConf", "Lcom/larus/settings/provider/chat/DownloadVideoEntityConf;", "taskModeFileTypeWhitelist", "taskModeFileTypeBlacklist", "enterpriseFileTypeWhitelist", "enterpriseFileTypeBlacklist", "taskModeUploadMaxSize", "normalModeFileTypeBlacklist", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Lcom/larus/settings/provider/chat/UploadMultiEntityConf;Lcom/larus/settings/provider/chat/UploadAudioEntityConf;ZLcom/larus/settings/provider/chat/UploadVideoEntityConf;Lcom/larus/settings/provider/chat/DownloadVideoEntityConf;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/util/List;)V", "getUploadFileAllowedTypes", "()Ljava/util/List;", "getDriveUploadFileAllowedTypes", "getUploadFileMaxSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getUploadMultiEntityConf", "()Lcom/larus/settings/provider/chat/UploadMultiEntityConf;", "getUploadAudioEntityConf", "()Lcom/larus/settings/provider/chat/UploadAudioEntityConf;", "getEnableLarkAudioAbility", "()Z", "getUploadVideoEntityConf", "()Lcom/larus/settings/provider/chat/UploadVideoEntityConf;", "getDownloadVideoEntityConf", "()Lcom/larus/settings/provider/chat/DownloadVideoEntityConf;", "getTaskModeFileTypeWhitelist", "getTaskModeFileTypeBlacklist", "getEnterpriseFileTypeWhitelist", "getEnterpriseFileTypeBlacklist", "getTaskModeUploadMaxSize", "getNormalModeFileTypeBlacklist", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Lcom/larus/settings/provider/chat/UploadMultiEntityConf;Lcom/larus/settings/provider/chat/UploadAudioEntityConf;ZLcom/larus/settings/provider/chat/UploadVideoEntityConf;Lcom/larus/settings/provider/chat/DownloadVideoEntityConf;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Long;Ljava/util/List;)Lcom/larus/settings/provider/chat/FlowMultiUploadConfig;", "equals", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class n0 {

    @SerializedName("download_video_entity_conf")
    private final j0 downloadVideoEntityConf;

    @SerializedName("drive_upload_file_allowed_types")
    private final List<String> driveUploadFileAllowedTypes;

    @SerializedName("enable_lark_audio_ability")
    private final boolean enableLarkAudioAbility;

    @SerializedName("enterprise_file_type_blacklist")
    private final List<String> enterpriseFileTypeBlacklist;

    @SerializedName("enterprise_file_type_whitelist")
    private final List<String> enterpriseFileTypeWhitelist;

    @SerializedName("normal_mode_file_type_blacklist")
    private final List<String> normalModeFileTypeBlacklist;

    @SerializedName("task_mode_file_type_blacklist")
    private final List<String> taskModeFileTypeBlacklist;

    @SerializedName("task_mode_file_type_whitelist")
    private final List<String> taskModeFileTypeWhitelist;

    @SerializedName("task_mode_upload_max_size")
    private final Long taskModeUploadMaxSize;

    @SerializedName("upload_audio_entity_conf")
    private final p2 uploadAudioEntityConf;

    @SerializedName("upload_file_allowed_types")
    private final List<String> uploadFileAllowedTypes;

    @SerializedName("upload_file_max_size")
    private final Long uploadFileMaxSize;

    @SerializedName("upload_multi_entity_conf")
    private final q2 uploadMultiEntityConf;

    @SerializedName("upload_video_entity_conf")
    private final r2 uploadVideoEntityConf;

    public n0() {
        this(null);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r6 = (n0) r5;
        if (Intrinsics.areEqual(this.uploadFileAllowedTypes, r6.uploadFileAllowedTypes) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.driveUploadFileAllowedTypes, r6.driveUploadFileAllowedTypes) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.uploadFileMaxSize, r6.uploadFileMaxSize) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.uploadMultiEntityConf, r6.uploadMultiEntityConf) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.uploadAudioEntityConf, r6.uploadAudioEntityConf) == true) goto L24;
        return false;
    L24:
        if (this.enableLarkAudioAbility == r6.enableLarkAudioAbility) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.uploadVideoEntityConf, r6.uploadVideoEntityConf) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.downloadVideoEntityConf, r6.downloadVideoEntityConf) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.taskModeFileTypeWhitelist, r6.taskModeFileTypeWhitelist) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.taskModeFileTypeBlacklist, r6.taskModeFileTypeBlacklist) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.enterpriseFileTypeWhitelist, r6.enterpriseFileTypeWhitelist) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.enterpriseFileTypeBlacklist, r6.enterpriseFileTypeBlacklist) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.taskModeUploadMaxSize, r6.taskModeUploadMaxSize) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.normalModeFileTypeBlacklist, r6.normalModeFileTypeBlacklist) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        List<String> r0 = this.uploadFileAllowedTypes;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.driveUploadFileAllowedTypes;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.uploadFileMaxSize;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        q2 r10 = this.uploadMultiEntityConf;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        p2 r13 = this.uploadAudioEntityConf;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        if (this.enableLarkAudioAbility == false) goto L25;
        int r16 = 1231;
    L26:
        int r17 = (r15 + r16) * 31;
        r2 r18 = this.uploadVideoEntityConf;
        if (r18 != null) goto L29;
        int r19 = 0;
    L30:
        int r20 = (r17 + r19) * 31;
        j0 r21 = this.downloadVideoEntityConf;
        if (r21 != null) goto L33;
        int r22 = 0;
    L34:
        int r23 = (r20 + r22) * 31;
        List<String> r24 = this.taskModeFileTypeWhitelist;
        if (r24 != null) goto L37;
        int r25 = 0;
    L38:
        int r26 = (r23 + r25) * 31;
        List<String> r27 = this.taskModeFileTypeBlacklist;
        if (r27 != null) goto L41;
        int r28 = 0;
    L42:
        int r29 = (r26 + r28) * 31;
        List<String> r30 = this.enterpriseFileTypeWhitelist;
        if (r30 != null) goto L45;
        int r31 = 0;
    L46:
        int r32 = (r29 + r31) * 31;
        List<String> r33 = this.enterpriseFileTypeBlacklist;
        if (r33 != null) goto L49;
        int r34 = 0;
    L50:
        int r35 = (r32 + r34) * 31;
        Long r36 = this.taskModeUploadMaxSize;
        if (r36 != null) goto L53;
        int r37 = 0;
    L54:
        int r38 = (r35 + r37) * 31;
        List<String> r39 = this.normalModeFileTypeBlacklist;
        if (r39 == null) goto L59;
        r1 = r39.hashCode();
    L59:
        return r38 + r1;
    L53:
        r37 = r36.hashCode();
        goto L54
    L49:
        r34 = r33.hashCode();
        goto L50
    L45:
        r31 = r30.hashCode();
        goto L46
    L41:
        r28 = r27.hashCode();
        goto L42
    L37:
        r25 = r24.hashCode();
        goto L38
    L33:
        r22 = r21.hashCode();
        goto L34
    L29:
        r19 = r18.hashCode();
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

    public final String toString() {
        return "FlowMultiUploadConfig(uploadFileAllowedTypes=" + this.uploadFileAllowedTypes + ", driveUploadFileAllowedTypes=" + this.driveUploadFileAllowedTypes + ", uploadFileMaxSize=" + this.uploadFileMaxSize + ", uploadMultiEntityConf=" + this.uploadMultiEntityConf + ", uploadAudioEntityConf=" + this.uploadAudioEntityConf + ", enableLarkAudioAbility=" + this.enableLarkAudioAbility + ", uploadVideoEntityConf=" + this.uploadVideoEntityConf + ", downloadVideoEntityConf=" + this.downloadVideoEntityConf + ", taskModeFileTypeWhitelist=" + this.taskModeFileTypeWhitelist + ", taskModeFileTypeBlacklist=" + this.taskModeFileTypeBlacklist + ", enterpriseFileTypeWhitelist=" + this.enterpriseFileTypeWhitelist + ", enterpriseFileTypeBlacklist=" + this.enterpriseFileTypeBlacklist + ", taskModeUploadMaxSize=" + this.taskModeUploadMaxSize + ", normalModeFileTypeBlacklist=" + this.normalModeFileTypeBlacklist + ')';
    }

    public final j0 a() {
        return this.downloadVideoEntityConf;
    }

    public final List<String> b() {
        return this.driveUploadFileAllowedTypes;
    }

    public final boolean c() {
        return this.enableLarkAudioAbility;
    }

    public final List<String> d() {
        return this.enterpriseFileTypeBlacklist;
    }

    public final List<String> e() {
        return this.enterpriseFileTypeWhitelist;
    }

    public final List<String> f() {
        return this.normalModeFileTypeBlacklist;
    }

    public final List<String> g() {
        return this.taskModeFileTypeBlacklist;
    }

    public final List<String> h() {
        return this.taskModeFileTypeWhitelist;
    }

    public final Long i() {
        return this.taskModeUploadMaxSize;
    }

    public final p2 j() {
        return this.uploadAudioEntityConf;
    }

    public final List<String> k() {
        return this.uploadFileAllowedTypes;
    }

    public final Long l() {
        return this.uploadFileMaxSize;
    }

    public final q2 m() {
        return this.uploadMultiEntityConf;
    }

    public final r2 n() {
        return this.uploadVideoEntityConf;
    }

    public n0(Object r58) {
        List<String> r1 = CollectionsKt.listOf(new String[]{"csv", "pdf", "txt", "xls", "xlsx", "ppt", "pptx", "doc", "docx", "json", "log", "md", "ini", "cfg", "yaml", "sql", "java", "py", "cpp", "cs", "php", "js", "css", "scss", "less", "jsx", "ts", "bat", "sh", "yml", "asp", "aspx", "jsp", "cgi", "pl", "rb", "lua", "ps1", "conf", "gitignore", "htaccess", "dat", "tab", "tex", "html", "h", "go", "tsx", "c", "py3", "cxx", "cc", "mobi", "epub", "tiff", "dng"});
        q2 r3 = new q2(0);
        p2 r5 = new p2(null);
        r2 r7 = new r2(0);
        j0 r8 = new j0(0);
        this.uploadFileAllowedTypes = r1;
        this.driveUploadFileAllowedTypes = null;
        this.uploadFileMaxSize = 104857600L;
        this.uploadMultiEntityConf = r3;
        this.uploadAudioEntityConf = r5;
        this.enableLarkAudioAbility = false;
        this.uploadVideoEntityConf = r7;
        this.downloadVideoEntityConf = r8;
        this.taskModeFileTypeWhitelist = null;
        this.taskModeFileTypeBlacklist = null;
        this.enterpriseFileTypeWhitelist = null;
        this.enterpriseFileTypeBlacklist = null;
        this.taskModeUploadMaxSize = 524288000L;
        this.normalModeFileTypeBlacklist = null;
    }
}
