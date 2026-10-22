package com.larus.platform.model.action;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/larus/platform/model/action/SuggestedActionScene;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "AttachmentAreaSingleImg", "AttachmentAreaSingleFile", "AttachmentAreaMultiImg", "AttachmentAreaMultiFile", "PreviewArea", "ReferenceAction", "DocAiEditReferenceAction", "HomeworkCorrectionCamera", "PPTGenerationSingleImg", "EcomPageAttachmentAreaSingleImage", "EcomPageAttachmentAreaMultiImage", "EduAlbum", "EduSolveQuestionCamera", "AttachmentAreaAudio", "AttachmentAreaAudioFile", "AttachmentAreaAudioSheet", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final enum SuggestedActionScene extends Enum<SuggestedActionScene> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ SuggestedActionScene[] $VALUES = null;
    public static final SuggestedActionScene AttachmentAreaAudio = null;
    public static final SuggestedActionScene AttachmentAreaAudioFile = null;
    public static final SuggestedActionScene AttachmentAreaAudioSheet = null;
    public static final SuggestedActionScene AttachmentAreaMultiFile = null;
    public static final SuggestedActionScene AttachmentAreaMultiImg = null;
    public static final SuggestedActionScene AttachmentAreaSingleFile = null;
    public static final SuggestedActionScene AttachmentAreaSingleImg = null;
    public static final SuggestedActionScene DocAiEditReferenceAction = null;
    public static final SuggestedActionScene EcomPageAttachmentAreaMultiImage = null;
    public static final SuggestedActionScene EcomPageAttachmentAreaSingleImage = null;
    public static final SuggestedActionScene EduAlbum = null;
    public static final SuggestedActionScene EduSolveQuestionCamera = null;
    public static final SuggestedActionScene HomeworkCorrectionCamera = null;
    public static final SuggestedActionScene PPTGenerationSingleImg = null;
    public static final SuggestedActionScene PreviewArea = null;
    public static final SuggestedActionScene ReferenceAction = null;
    public static final SuggestedActionScene Unknown = null;
    private final int value;

    private static final /* synthetic */ SuggestedActionScene[] $values() {
        return new SuggestedActionScene[]{Unknown, AttachmentAreaSingleImg, AttachmentAreaSingleFile, AttachmentAreaMultiImg, AttachmentAreaMultiFile, PreviewArea, ReferenceAction, DocAiEditReferenceAction, HomeworkCorrectionCamera, PPTGenerationSingleImg, EcomPageAttachmentAreaSingleImage, EcomPageAttachmentAreaMultiImage, EduAlbum, EduSolveQuestionCamera, AttachmentAreaAudio, AttachmentAreaAudioFile, AttachmentAreaAudioSheet};
    }

    public static EnumEntries<SuggestedActionScene> getEntries() {
        return $ENTRIES;
    }

    static {
        Unknown = new SuggestedActionScene("Unknown", 0, 0);
        AttachmentAreaSingleImg = new SuggestedActionScene("AttachmentAreaSingleImg", 1, 1);
        AttachmentAreaSingleFile = new SuggestedActionScene("AttachmentAreaSingleFile", 2, 2);
        AttachmentAreaMultiImg = new SuggestedActionScene("AttachmentAreaMultiImg", 3, 3);
        AttachmentAreaMultiFile = new SuggestedActionScene("AttachmentAreaMultiFile", 4, 4);
        PreviewArea = new SuggestedActionScene("PreviewArea", 5, 5);
        ReferenceAction = new SuggestedActionScene("ReferenceAction", 6, 6);
        DocAiEditReferenceAction = new SuggestedActionScene("DocAiEditReferenceAction", 7, 7);
        HomeworkCorrectionCamera = new SuggestedActionScene("HomeworkCorrectionCamera", 8, 8);
        PPTGenerationSingleImg = new SuggestedActionScene("PPTGenerationSingleImg", 9, 9);
        EcomPageAttachmentAreaSingleImage = new SuggestedActionScene("EcomPageAttachmentAreaSingleImage", 10, 10);
        EcomPageAttachmentAreaMultiImage = new SuggestedActionScene("EcomPageAttachmentAreaMultiImage", 11, 11);
        EduAlbum = new SuggestedActionScene("EduAlbum", 12, 12);
        EduSolveQuestionCamera = new SuggestedActionScene("EduSolveQuestionCamera", 13, 13);
        AttachmentAreaAudio = new SuggestedActionScene("AttachmentAreaAudio", 14, 14);
        AttachmentAreaAudioFile = new SuggestedActionScene("AttachmentAreaAudioFile", 15, 15);
        AttachmentAreaAudioSheet = new SuggestedActionScene("AttachmentAreaAudioSheet", 16, 16);
        SuggestedActionScene[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
    }

    public static SuggestedActionScene[] values() {
        return (SuggestedActionScene[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static SuggestedActionScene valueOf(String r1) {
        return (SuggestedActionScene) r27.a.a(SuggestedActionScene.class, r1);
    }

    private SuggestedActionScene(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
