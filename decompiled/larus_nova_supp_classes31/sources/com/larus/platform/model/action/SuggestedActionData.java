package com.larus.platform.model.action;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BÇ\u0002\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010'\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\b\u0010(\u001a\u0004\u0018\u00010)J\u0013\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010-\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00101\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00102\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00103\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00105\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00106\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00107\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00108\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u00109\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003JÉ\u0002\u0010:\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010>\u001a\u00020?HÖ\u0001J\t\u0010@\u001a\u00020AHÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R \u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R \u0010\n\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0017R \u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R \u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R \u0010\u000f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R \u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R \u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017R \u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0017R \u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0017¨\u0006B"}, d2 = {"Lcom/larus/platform/model/action/SuggestedActionData;", "", "aiPPTSingleImage", "", "Lcom/larus/platform/model/action/SuggestedAction;", "attachmentAreaMultiFile", "attachmentAreaMultiImg", "attachmentAreaSingleFile", "attachmentAreaSingleImg", "previewArea", "homeworkCorrectionCamera", "eduAlbum", "eduSolveQuestionCamera", "referenceAction", "docAiEditAction", "ecomPageAttachmentAreaMultiImage", "ecomPageAttachmentAreaSingleImage", "attachmentAreaAudio", "attachmentAreaAudioFile", "attachmentAreaAudioSheet", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAiPPTSingleImage", "()Ljava/util/List;", "getAttachmentAreaMultiFile", "getAttachmentAreaMultiImg", "getAttachmentAreaSingleFile", "getAttachmentAreaSingleImg", "getPreviewArea", "getHomeworkCorrectionCamera", "getEduAlbum", "getEduSolveQuestionCamera", "getReferenceAction", "getDocAiEditAction", "getEcomPageAttachmentAreaMultiImage", "getEcomPageAttachmentAreaSingleImage", "getAttachmentAreaAudio", "getAttachmentAreaAudioFile", "getAttachmentAreaAudioSheet", "get", "scene", "Lcom/larus/platform/model/action/SuggestedActionScene;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "equals", "", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SuggestedActionData {

    @SerializedName("ai_ppt_single_img")
    private final List<SuggestedAction> aiPPTSingleImage;

    @SerializedName("attachment_area_audio")
    private final List<SuggestedAction> attachmentAreaAudio;

    @SerializedName("attachment_area_audio_file")
    private final List<SuggestedAction> attachmentAreaAudioFile;

    @SerializedName("attachment_area_audio_sheet")
    private final List<SuggestedAction> attachmentAreaAudioSheet;

    @SerializedName("attachment_area_multi_file")
    private final List<SuggestedAction> attachmentAreaMultiFile;

    @SerializedName("attachment_area_multi_img")
    private final List<SuggestedAction> attachmentAreaMultiImg;

    @SerializedName("attachment_area_single_file")
    private final List<SuggestedAction> attachmentAreaSingleFile;

    @SerializedName("attachment_area_single_img")
    private final List<SuggestedAction> attachmentAreaSingleImg;

    @SerializedName("doc_ai_edit")
    private final List<SuggestedAction> docAiEditAction;

    @SerializedName("ecom_page_attachment_area_multi_image")
    private final List<SuggestedAction> ecomPageAttachmentAreaMultiImage;

    @SerializedName("ecom_page_attachment_area_single_image")
    private final List<SuggestedAction> ecomPageAttachmentAreaSingleImage;

    @SerializedName("edu_album")
    private final List<SuggestedAction> eduAlbum;

    @SerializedName("edu_solve_question_camera")
    private final List<SuggestedAction> eduSolveQuestionCamera;

    @SerializedName("homework_correction_camera")
    private final List<SuggestedAction> homeworkCorrectionCamera;

    @SerializedName("preview_area")
    private final List<SuggestedAction> previewArea;

    @SerializedName("reference_action")
    private final List<SuggestedAction> referenceAction;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SuggestedActionScene.values().length];
            r0[SuggestedActionScene.AttachmentAreaSingleImg.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L55:
            r0[SuggestedActionScene.AttachmentAreaSingleFile.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L67:
            r0[SuggestedActionScene.AttachmentAreaMultiImg.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L41:
            r0[SuggestedActionScene.AttachmentAreaMultiFile.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L43:
            r0[SuggestedActionScene.AttachmentAreaAudio.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L51:
            r0[SuggestedActionScene.AttachmentAreaAudioFile.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L61:
            r0[SuggestedActionScene.AttachmentAreaAudioSheet.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L47:
            r0[SuggestedActionScene.PreviewArea.ordinal()] = 8;     // Catch: NoSuchFieldError -> L28
        L57:
            r0[SuggestedActionScene.ReferenceAction.ordinal()] = 9;     // Catch: NoSuchFieldError -> L29
        L59:
            r0[SuggestedActionScene.DocAiEditReferenceAction.ordinal()] = 10;     // Catch: NoSuchFieldError -> L30
        L39:
            r0[SuggestedActionScene.HomeworkCorrectionCamera.ordinal()] = 11;     // Catch: NoSuchFieldError -> L31
        L53:
            r0[SuggestedActionScene.PPTGenerationSingleImg.ordinal()] = 12;     // Catch: NoSuchFieldError -> L32
        L65:
            r0[SuggestedActionScene.EcomPageAttachmentAreaSingleImage.ordinal()] = 13;     // Catch: NoSuchFieldError -> L33
        L37:
            r0[SuggestedActionScene.EcomPageAttachmentAreaMultiImage.ordinal()] = 14;     // Catch: NoSuchFieldError -> L34
        L45:
            r0[SuggestedActionScene.EduAlbum.ordinal()] = 15;     // Catch: NoSuchFieldError -> L35
        L63:
            r0[SuggestedActionScene.EduSolveQuestionCamera.ordinal()] = 16;     // Catch: NoSuchFieldError -> L36
        L19:
            a = r0;
        }
    }

    public SuggestedActionData() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 65535, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SuggestedActionData copy$default(SuggestedActionData r17, List r18, List r19, List r20, List r21, List r22, List r23, List r24, List r25, List r26, List r27, List r28, List r29, List r30, List r31, List r32, List r33, int r34, Object r35) {
        if ((r34 & 1) == 0) goto L5;
        List r2 = r17.aiPPTSingleImage;
    L7:
        if ((r34 & 2) == 0) goto L9;
        List r3 = r17.attachmentAreaMultiFile;
    L11:
        if ((r34 & 4) == 0) goto L13;
        List r4 = r17.attachmentAreaMultiImg;
    L15:
        if ((r34 & 8) == 0) goto L17;
        List r5 = r17.attachmentAreaSingleFile;
    L19:
        if ((r34 & 16) == 0) goto L21;
        List r6 = r17.attachmentAreaSingleImg;
    L23:
        if ((r34 & 32) == 0) goto L25;
        List r7 = r17.previewArea;
    L27:
        if ((r34 & 64) == 0) goto L29;
        List r8 = r17.homeworkCorrectionCamera;
    L31:
        if ((r34 & 128) == 0) goto L33;
        List r9 = r17.eduAlbum;
    L35:
        if ((r34 & 256) == 0) goto L37;
        List r10 = r17.eduSolveQuestionCamera;
    L39:
        if ((r34 & 512) == 0) goto L41;
        List r11 = r17.referenceAction;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        List r12 = r17.docAiEditAction;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        List r13 = r17.ecomPageAttachmentAreaMultiImage;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        List r14 = r17.ecomPageAttachmentAreaSingleImage;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        List r15 = r17.attachmentAreaAudio;
    L58:
        List r36 = r15;
        if ((r34 & 16384) == 0) goto L61;
        List r16 = r17.attachmentAreaAudioFile;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        List r1 = r17.attachmentAreaAudioSheet;
    L67:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r36, r16, r1);
    L65:
        r1 = r33;
        goto L67
    L61:
        r16 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
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
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final List<SuggestedAction> component1() {
        return this.aiPPTSingleImage;
    }

    public final List<SuggestedAction> component10() {
        return this.referenceAction;
    }

    public final List<SuggestedAction> component11() {
        return this.docAiEditAction;
    }

    public final List<SuggestedAction> component12() {
        return this.ecomPageAttachmentAreaMultiImage;
    }

    public final List<SuggestedAction> component13() {
        return this.ecomPageAttachmentAreaSingleImage;
    }

    public final List<SuggestedAction> component14() {
        return this.attachmentAreaAudio;
    }

    public final List<SuggestedAction> component15() {
        return this.attachmentAreaAudioFile;
    }

    public final List<SuggestedAction> component16() {
        return this.attachmentAreaAudioSheet;
    }

    public final List<SuggestedAction> component2() {
        return this.attachmentAreaMultiFile;
    }

    public final List<SuggestedAction> component3() {
        return this.attachmentAreaMultiImg;
    }

    public final List<SuggestedAction> component4() {
        return this.attachmentAreaSingleFile;
    }

    public final List<SuggestedAction> component5() {
        return this.attachmentAreaSingleImg;
    }

    public final List<SuggestedAction> component6() {
        return this.previewArea;
    }

    public final List<SuggestedAction> component7() {
        return this.homeworkCorrectionCamera;
    }

    public final List<SuggestedAction> component8() {
        return this.eduAlbum;
    }

    public final List<SuggestedAction> component9() {
        return this.eduSolveQuestionCamera;
    }

    public final SuggestedActionData copy(List<SuggestedAction> r19, List<SuggestedAction> r20, List<SuggestedAction> r21, List<SuggestedAction> r22, List<SuggestedAction> r23, List<SuggestedAction> r24, List<SuggestedAction> r25, List<SuggestedAction> r26, List<SuggestedAction> r27, List<SuggestedAction> r28, List<SuggestedAction> r29, List<SuggestedAction> r30, List<SuggestedAction> r31, List<SuggestedAction> r32, List<SuggestedAction> r33, List<SuggestedAction> r34) {
        return new SuggestedActionData(r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SuggestedActionData) == true) goto L8;
        return false;
    L8:
        SuggestedActionData r6 = (SuggestedActionData) r5;
        if (Intrinsics.areEqual(this.aiPPTSingleImage, r6.aiPPTSingleImage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.attachmentAreaMultiFile, r6.attachmentAreaMultiFile) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.attachmentAreaMultiImg, r6.attachmentAreaMultiImg) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.attachmentAreaSingleFile, r6.attachmentAreaSingleFile) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.attachmentAreaSingleImg, r6.attachmentAreaSingleImg) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.previewArea, r6.previewArea) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.homeworkCorrectionCamera, r6.homeworkCorrectionCamera) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.eduAlbum, r6.eduAlbum) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.eduSolveQuestionCamera, r6.eduSolveQuestionCamera) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.referenceAction, r6.referenceAction) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.docAiEditAction, r6.docAiEditAction) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.ecomPageAttachmentAreaMultiImage, r6.ecomPageAttachmentAreaMultiImage) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.ecomPageAttachmentAreaSingleImage, r6.ecomPageAttachmentAreaSingleImage) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.attachmentAreaAudio, r6.attachmentAreaAudio) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.attachmentAreaAudioFile, r6.attachmentAreaAudioFile) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.attachmentAreaAudioSheet, r6.attachmentAreaAudioSheet) == true) goto L56;
        return false;
    L56:
        return true;
    }

    public int hashCode() {
        List<SuggestedAction> r0 = this.aiPPTSingleImage;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<SuggestedAction> r4 = this.attachmentAreaMultiFile;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        List<SuggestedAction> r7 = this.attachmentAreaMultiImg;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<SuggestedAction> r10 = this.attachmentAreaSingleFile;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<SuggestedAction> r13 = this.attachmentAreaSingleImg;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        List<SuggestedAction> r16 = this.previewArea;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        List<SuggestedAction> r19 = this.homeworkCorrectionCamera;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        List<SuggestedAction> r22 = this.eduAlbum;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        List<SuggestedAction> r25 = this.eduSolveQuestionCamera;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        List<SuggestedAction> r28 = this.referenceAction;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        List<SuggestedAction> r31 = this.docAiEditAction;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        List<SuggestedAction> r34 = this.ecomPageAttachmentAreaMultiImage;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        List<SuggestedAction> r37 = this.ecomPageAttachmentAreaSingleImage;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        List<SuggestedAction> r40 = this.attachmentAreaAudio;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        List<SuggestedAction> r43 = this.attachmentAreaAudioFile;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        List<SuggestedAction> r46 = this.attachmentAreaAudioSheet;
        if (r46 == null) goto L67;
        r1 = r46.hashCode();
    L67:
        return r45 + r1;
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
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
        return "SuggestedActionData(aiPPTSingleImage=" + this.aiPPTSingleImage + ", attachmentAreaMultiFile=" + this.attachmentAreaMultiFile + ", attachmentAreaMultiImg=" + this.attachmentAreaMultiImg + ", attachmentAreaSingleFile=" + this.attachmentAreaSingleFile + ", attachmentAreaSingleImg=" + this.attachmentAreaSingleImg + ", previewArea=" + this.previewArea + ", homeworkCorrectionCamera=" + this.homeworkCorrectionCamera + ", eduAlbum=" + this.eduAlbum + ", eduSolveQuestionCamera=" + this.eduSolveQuestionCamera + ", referenceAction=" + this.referenceAction + ", docAiEditAction=" + this.docAiEditAction + ", ecomPageAttachmentAreaMultiImage=" + this.ecomPageAttachmentAreaMultiImage + ", ecomPageAttachmentAreaSingleImage=" + this.ecomPageAttachmentAreaSingleImage + ", attachmentAreaAudio=" + this.attachmentAreaAudio + ", attachmentAreaAudioFile=" + this.attachmentAreaAudioFile + ", attachmentAreaAudioSheet=" + this.attachmentAreaAudioSheet + ')';
    }

    public final List<SuggestedAction> getAiPPTSingleImage() {
        return this.aiPPTSingleImage;
    }

    public final List<SuggestedAction> getAttachmentAreaAudio() {
        return this.attachmentAreaAudio;
    }

    public final List<SuggestedAction> getAttachmentAreaAudioFile() {
        return this.attachmentAreaAudioFile;
    }

    public final List<SuggestedAction> getAttachmentAreaAudioSheet() {
        return this.attachmentAreaAudioSheet;
    }

    public final List<SuggestedAction> getAttachmentAreaMultiFile() {
        return this.attachmentAreaMultiFile;
    }

    public final List<SuggestedAction> getAttachmentAreaMultiImg() {
        return this.attachmentAreaMultiImg;
    }

    public final List<SuggestedAction> getAttachmentAreaSingleFile() {
        return this.attachmentAreaSingleFile;
    }

    public final List<SuggestedAction> getAttachmentAreaSingleImg() {
        return this.attachmentAreaSingleImg;
    }

    public final List<SuggestedAction> getDocAiEditAction() {
        return this.docAiEditAction;
    }

    public final List<SuggestedAction> getEcomPageAttachmentAreaMultiImage() {
        return this.ecomPageAttachmentAreaMultiImage;
    }

    public final List<SuggestedAction> getEcomPageAttachmentAreaSingleImage() {
        return this.ecomPageAttachmentAreaSingleImage;
    }

    public final List<SuggestedAction> getEduAlbum() {
        return this.eduAlbum;
    }

    public final List<SuggestedAction> getEduSolveQuestionCamera() {
        return this.eduSolveQuestionCamera;
    }

    public final List<SuggestedAction> getHomeworkCorrectionCamera() {
        return this.homeworkCorrectionCamera;
    }

    public final List<SuggestedAction> getPreviewArea() {
        return this.previewArea;
    }

    public final List<SuggestedAction> getReferenceAction() {
        return this.referenceAction;
    }

    public final List<SuggestedAction> get(SuggestedActionScene r2) {
        if (r2 != null) goto L4;
        int r3 = -1;
    L5:
        switch(r3) {
            case 1: goto L23;
            case 2: goto L39;
            case 3: goto L38;
            case 4: goto L37;
            case 5: goto L36;
            case 6: goto L35;
            case 7: goto L34;
            case 8: goto L33;
            case 9: goto L32;
            case 10: goto L31;
            case 11: goto L30;
            case 12: goto L29;
            case 13: goto L28;
            case 14: goto L27;
            case 15: goto L26;
            case 16: goto L25;
            default: goto L6;
        };
    L6:
        return null;
    L25:
        return this.eduSolveQuestionCamera;
    L26:
        return this.eduAlbum;
    L27:
        return this.ecomPageAttachmentAreaMultiImage;
    L28:
        return this.ecomPageAttachmentAreaSingleImage;
    L29:
        return this.aiPPTSingleImage;
    L30:
        return this.homeworkCorrectionCamera;
    L31:
        return this.docAiEditAction;
    L32:
        return this.referenceAction;
    L33:
        return this.previewArea;
    L34:
        return this.attachmentAreaAudioSheet;
    L35:
        return this.attachmentAreaAudioFile;
    L36:
        return this.attachmentAreaAudio;
    L37:
        return this.attachmentAreaMultiFile;
    L38:
        return this.attachmentAreaMultiImg;
    L39:
        return this.attachmentAreaSingleFile;
    L23:
        return this.attachmentAreaSingleImg;
    L4:
        r3 = a.a[r2.ordinal()];
        goto L5
    }

    public SuggestedActionData(List<SuggestedAction> r3, List<SuggestedAction> r4, List<SuggestedAction> r5, List<SuggestedAction> r6, List<SuggestedAction> r7, List<SuggestedAction> r8, List<SuggestedAction> r9, List<SuggestedAction> r10, List<SuggestedAction> r11, List<SuggestedAction> r12, List<SuggestedAction> r13, List<SuggestedAction> r14, List<SuggestedAction> r15, List<SuggestedAction> r16, List<SuggestedAction> r17, List<SuggestedAction> r18) {
        this.aiPPTSingleImage = r3;
        this.attachmentAreaMultiFile = r4;
        this.attachmentAreaMultiImg = r5;
        this.attachmentAreaSingleFile = r6;
        this.attachmentAreaSingleImg = r7;
        this.previewArea = r8;
        this.homeworkCorrectionCamera = r9;
        this.eduAlbum = r10;
        this.eduSolveQuestionCamera = r11;
        this.referenceAction = r12;
        this.docAiEditAction = r13;
        this.ecomPageAttachmentAreaMultiImage = r14;
        this.ecomPageAttachmentAreaSingleImage = r15;
        this.attachmentAreaAudio = r16;
        this.attachmentAreaAudioFile = r17;
        this.attachmentAreaAudioSheet = r18;
    }

    public /* synthetic */ SuggestedActionData(List r18, List r19, List r20, List r21, List r22, List r23, List r24, List r25, List r26, List r27, List r28, List r29, List r30, List r31, List r32, List r33, int r34, DefaultConstructorMarker r35) {
        if ((r34 & 1) == 0) goto L5;
        List r1 = null;
    L7:
        if ((r34 & 2) == 0) goto L9;
        List r3 = null;
    L11:
        if ((r34 & 4) == 0) goto L13;
        List r4 = null;
    L15:
        if ((r34 & 8) == 0) goto L17;
        List r5 = null;
    L19:
        if ((r34 & 16) == 0) goto L21;
        List r6 = null;
    L23:
        if ((r34 & 32) == 0) goto L25;
        List r7 = null;
    L27:
        if ((r34 & 64) == 0) goto L29;
        List r8 = null;
    L31:
        if ((r34 & 128) == 0) goto L33;
        List r9 = null;
    L35:
        if ((r34 & 256) == 0) goto L37;
        List r10 = null;
    L39:
        if ((r34 & 512) == 0) goto L41;
        List r11 = null;
    L43:
        if ((r34 & 1024) == 0) goto L45;
        List r12 = null;
    L47:
        if ((r34 & 2048) == 0) goto L49;
        List r13 = null;
    L51:
        if ((r34 & 4096) == 0) goto L53;
        List r14 = null;
    L55:
        if ((r34 & 8192) == 0) goto L57;
        List r15 = null;
    L59:
        if ((r34 & 16384) == 0) goto L61;
        List r2 = null;
    L63:
        if ((r34 & 32768) == 0) goto L65;
        List r0 = null;
    L66:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r0);
        return;
    L65:
        r0 = r33;
        goto L66
    L61:
        r2 = r32;
        goto L63
    L57:
        r15 = r31;
        goto L59
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
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
        r3 = r19;
        goto L11
    L5:
        r1 = r18;
        goto L7
    }
}
