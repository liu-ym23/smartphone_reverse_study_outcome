package hq9;

import com.google.gson.annotations.SerializedName;
import com.larus.platform.model.EnterpriseConfig;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b4\b\u0086\b\u0018\u00002\u00020\u0001Bå\u0001\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0013\u00101\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\u0006HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\t\u00105\u001a\u00020\nHÆ\u0003J\t\u00106\u001a\u00020\nHÆ\u0003J\t\u00107\u001a\u00020\rHÆ\u0003J\t\u00108\u001a\u00020\nHÆ\u0003J\u0013\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010:\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010;\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u0013\u0010=\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010>\u001a\u00020\nHÆ\u0003J\t\u0010?\u001a\u00020\u0006HÆ\u0003J\t\u0010@\u001a\u00020\u0006HÆ\u0003J\t\u0010A\u001a\u00020\u0006HÆ\u0003Jç\u0001\u0010B\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\n2\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0012\b\u0002\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0015\u001a\u00020\n2\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0006HÆ\u0001J\u0013\u0010C\u001a\u00020\u00062\b\u0010D\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010E\u001a\u00020\nHÖ\u0001J\t\u0010F\u001a\u00020\u0004HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u000e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R \u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR \u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR \u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R \u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001cR\u0016\u0010\u0015\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\"R\u0016\u0010\u0016\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001eR\u0016\u0010\u0017\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001eR\u0016\u0010\u0018\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001e¨\u0006G"}, d2 = {"Lcom/larus/platform/model/LarkDriveConfig;", "", "aiAskSupportPostfix", "", "", "showChatBottomDrive", "", "enableSendingVideo", "showSettingPageDrive", "uploadListSize", "", "fileNameMaxLength", "picSendMaxSize", "", "fileListPageLength", "fileCanNotSupportPreview", "mediaSupportSaveToAlbum", "driveListFileType", "enterpriseSettings", "Lcom/larus/platform/model/EnterpriseConfig;", "filePickerAllowedTypes", "fileUploadUiStyle", "enableListMultiSelect", "galleryTransitionOpt", "useNewList", "<init>", "(Ljava/util/List;ZZZIIJILjava/util/List;Ljava/util/List;Ljava/util/List;Lcom/larus/platform/model/EnterpriseConfig;Ljava/util/List;IZZZ)V", "getAiAskSupportPostfix", "()Ljava/util/List;", "getShowChatBottomDrive", "()Z", "getEnableSendingVideo", "getShowSettingPageDrive", "getUploadListSize", "()I", "getFileNameMaxLength", "getPicSendMaxSize", "()J", "getFileListPageLength", "getFileCanNotSupportPreview", "getMediaSupportSaveToAlbum", "getDriveListFileType", "getEnterpriseSettings", "()Lcom/larus/platform/model/EnterpriseConfig;", "getFilePickerAllowedTypes", "getFileUploadUiStyle", "getEnableListMultiSelect", "getGalleryTransitionOpt", "getUseNewList", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "copy", "equals", "other", "hashCode", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class c2 {

    @SerializedName("ai_ask_support_postfix")
    private final List<String> aiAskSupportPostfix;

    @SerializedName("drive_list_file_type")
    private final List<Integer> driveListFileType;

    @SerializedName("enable_list_multi_select")
    private final boolean enableListMultiSelect;

    @SerializedName("enable_sending_video")
    private final boolean enableSendingVideo;

    @SerializedName("enterprise_settings")
    private final EnterpriseConfig enterpriseSettings;

    @SerializedName("file_can_not_support_preview")
    private final List<String> fileCanNotSupportPreview;

    @SerializedName("file_list_page_length")
    private final int fileListPageLength;

    @SerializedName("file_name_max_length")
    private final int fileNameMaxLength;

    @SerializedName("file_picker_allowed_types")
    private final List<String> filePickerAllowedTypes;

    @SerializedName("file_upload_ui_style")
    private final int fileUploadUiStyle;

    @SerializedName("gallery_transition_opt")
    private final boolean galleryTransitionOpt;

    @SerializedName("media_support_save_to_album")
    private final List<String> mediaSupportSaveToAlbum;

    @SerializedName("pic_send_max_size")
    private final long picSendMaxSize;

    @SerializedName("show_chat_bottom_drive")
    private final boolean showChatBottomDrive;

    @SerializedName("show_setting_page_drive")
    private final boolean showSettingPageDrive;

    @SerializedName("upload_list_size")
    private final int uploadListSize;

    @SerializedName("use_new_list")
    private final boolean useNewList;

    public c2() {
        this(null);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof c2) == true) goto L8;
        return false;
    L8:
        c2 r9 = (c2) r8;
        if (Intrinsics.areEqual(this.aiAskSupportPostfix, r9.aiAskSupportPostfix) == true) goto L12;
        return false;
    L12:
        if (this.showChatBottomDrive == r9.showChatBottomDrive) goto L15;
        return false;
    L15:
        if (this.enableSendingVideo == r9.enableSendingVideo) goto L18;
        return false;
    L18:
        if (this.showSettingPageDrive == r9.showSettingPageDrive) goto L21;
        return false;
    L21:
        if (this.uploadListSize == r9.uploadListSize) goto L24;
        return false;
    L24:
        if (this.fileNameMaxLength == r9.fileNameMaxLength) goto L27;
        return false;
    L27:
        if (this.picSendMaxSize == r9.picSendMaxSize) goto L30;
        return false;
    L30:
        if (this.fileListPageLength == r9.fileListPageLength) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.fileCanNotSupportPreview, r9.fileCanNotSupportPreview) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.mediaSupportSaveToAlbum, r9.mediaSupportSaveToAlbum) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.driveListFileType, r9.driveListFileType) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.enterpriseSettings, r9.enterpriseSettings) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.filePickerAllowedTypes, r9.filePickerAllowedTypes) == true) goto L48;
        return false;
    L48:
        if (this.fileUploadUiStyle == r9.fileUploadUiStyle) goto L51;
        return false;
    L51:
        if (this.enableListMultiSelect == r9.enableListMultiSelect) goto L54;
        return false;
    L54:
        if (this.galleryTransitionOpt == r9.galleryTransitionOpt) goto L57;
        return false;
    L57:
        if (this.useNewList == r9.useNewList) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        List<String> r0 = this.aiAskSupportPostfix;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        int r4 = 1231;
        if (this.showChatBottomDrive == false) goto L9;
        int r5 = 1231;
    L10:
        int r6 = (r3 + r5) * 31;
        if (this.enableSendingVideo == false) goto L13;
        int r7 = 1231;
    L14:
        int r8 = (r6 + r7) * 31;
        if (this.showSettingPageDrive == false) goto L17;
        int r9 = 1231;
    L18:
        int r10 = (((((r8 + r9) * 31) + this.uploadListSize) * 31) + this.fileNameMaxLength) * 31;
        long r11 = this.picSendMaxSize;
        int r12 = (((r10 + ((int) (r11 ^ (r11 >>> 32)))) * 31) + this.fileListPageLength) * 31;
        List<String> r13 = this.fileCanNotSupportPreview;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        List<String> r16 = this.mediaSupportSaveToAlbum;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        List<Integer> r19 = this.driveListFileType;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        EnterpriseConfig r22 = this.enterpriseSettings;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        List<String> r25 = this.filePickerAllowedTypes;
        if (r25 == null) goto L38;
        r1 = r25.hashCode();
    L38:
        int r26 = (((r24 + r1) * 31) + this.fileUploadUiStyle) * 31;
        if (this.enableListMultiSelect == false) goto L41;
        int r27 = 1231;
    L42:
        int r28 = (r26 + r27) * 31;
        if (this.galleryTransitionOpt == false) goto L45;
        int r29 = 1231;
    L46:
        int r30 = (r28 + r29) * 31;
        if (this.useNewList == true) goto L51;
        r4 = 1237;
    L51:
        return r30 + r4;
    L45:
        r29 = 1237;
        goto L46
    L41:
        r27 = 1237;
        goto L42
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
        r9 = 1237;
        goto L18
    L13:
        r7 = 1237;
        goto L14
    L9:
        r5 = 1237;
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "LarkDriveConfig(aiAskSupportPostfix=" + this.aiAskSupportPostfix + ", showChatBottomDrive=" + this.showChatBottomDrive + ", enableSendingVideo=" + this.enableSendingVideo + ", showSettingPageDrive=" + this.showSettingPageDrive + ", uploadListSize=" + this.uploadListSize + ", fileNameMaxLength=" + this.fileNameMaxLength + ", picSendMaxSize=" + this.picSendMaxSize + ", fileListPageLength=" + this.fileListPageLength + ", fileCanNotSupportPreview=" + this.fileCanNotSupportPreview + ", mediaSupportSaveToAlbum=" + this.mediaSupportSaveToAlbum + ", driveListFileType=" + this.driveListFileType + ", enterpriseSettings=" + this.enterpriseSettings + ", filePickerAllowedTypes=" + this.filePickerAllowedTypes + ", fileUploadUiStyle=" + this.fileUploadUiStyle + ", enableListMultiSelect=" + this.enableListMultiSelect + ", galleryTransitionOpt=" + this.galleryTransitionOpt + ", useNewList=" + this.useNewList + ')';
    }

    public final boolean a() {
        return this.enableListMultiSelect;
    }

    public final List<String> b() {
        return this.fileCanNotSupportPreview;
    }

    public final int c() {
        return this.fileListPageLength;
    }

    public final int d() {
        return this.fileNameMaxLength;
    }

    public final int e() {
        return this.fileUploadUiStyle;
    }

    public final boolean f() {
        return this.galleryTransitionOpt;
    }

    public final List<String> g() {
        return this.mediaSupportSaveToAlbum;
    }

    public final long h() {
        return this.picSendMaxSize;
    }

    public final boolean i() {
        return this.showSettingPageDrive;
    }

    public final int j() {
        return this.uploadListSize;
    }

    public c2(Object r20) {
        List<String> r1 = CollectionsKt.listOf(new String[]{".pdf", ".docx", ".doc", ".xls", ".xlsx", ".csv", ".ppt", ".pptx", ".pps", ".dot", ".png", ".jpg", ".jpeg", ".txt", ".md", ".log"});
        List<String> r2 = CollectionsKt.listOf(new String[]{".svg", ".ai", ".eps", ".psd", ".psb", ".arw", ".ar3", ".cr2", ".cr3", ".ar2", ".ts", ".ogg", ".webm", ".tif", ".tiff"});
        List<String> r3 = CollectionsKt.listOf(new String[]{".jpg", ".jpeg", ".png", ".heic", ".heif", ".gif", ".bmp", ".tif", ".tiff", ".ico", ".dng", ".mp4", ".m4v", ".mp4v", ".mpg4", ".mov"});
        List<Integer> r4 = CollectionsKt.listOf(new Integer[]{0, 12, 22, 30, 3});
        EnterpriseConfig r6 = new EnterpriseConfig(null, 1, null);
        List<String> r8 = CollectionsKt.listOf(new String[]{"file", "doc", "sheet", "slides"});
        this.aiAskSupportPostfix = r1;
        this.showChatBottomDrive = true;
        this.enableSendingVideo = false;
        this.showSettingPageDrive = true;
        this.uploadListSize = 99;
        this.fileNameMaxLength = 256;
        this.picSendMaxSize = 52428800;
        this.fileListPageLength = 20;
        this.fileCanNotSupportPreview = r2;
        this.mediaSupportSaveToAlbum = r3;
        this.driveListFileType = r4;
        this.enterpriseSettings = r6;
        this.filePickerAllowedTypes = r8;
        this.fileUploadUiStyle = 0;
        this.enableListMultiSelect = false;
        this.galleryTransitionOpt = true;
        this.useNewList = true;
    }
}
