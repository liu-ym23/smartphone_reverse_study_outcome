package lx8;

import com.google.gson.annotations.SerializedName;
import com.larus.camera.impl.edulibs.camera.internal.idl.BusinessType;
import com.larus.camera.impl.edulibs.camera.internal.idl.Orientation;
import com.larus.camera.impl.edulibs.camera.internal.idl.ProcessType;
import com.larus.camera.impl.edulibs.cameraapi.SceneType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\b\u0086\b\u0018\u00002\u00020\u0001B\u008b\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u0013\u0010,\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0005HÆ\u0003J\u0010\u0010-\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010 J\u0013\u0010.\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u0092\u0001\u00102\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\b\u0002\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÆ\u0001¢\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00106\u001a\u00020\fHÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR \u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R \u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001aR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u00068"}, d2 = {"Lcom/larus/camera/impl/edulibs/camera/internal/idl/QuestionDetectionRequest;", "", "traceId", "", "imageDatas", "", "Lcom/larus/camera/impl/edulibs/camera/internal/idl/ImageReqData;", "returnQuestionImages", "", "imageOrientations", "Lcom/larus/camera/impl/edulibs/camera/internal/idl/Orientation;", "detectionType", "", "processTypes", "Lcom/larus/camera/impl/edulibs/camera/internal/idl/ProcessType;", "businessType", "Lcom/larus/camera/impl/edulibs/camera/internal/idl/BusinessType;", "sceneType", "Lcom/larus/camera/impl/edulibs/cameraapi/SceneType;", "graceStrategyTrack", "Lcom/larus/camera/impl/edulibs/camera/internal/idl/GraceStrategyTrackBeforeAlgorithmDetection;", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Lcom/larus/camera/impl/edulibs/camera/internal/idl/BusinessType;Lcom/larus/camera/impl/edulibs/cameraapi/SceneType;Lcom/larus/camera/impl/edulibs/camera/internal/idl/GraceStrategyTrackBeforeAlgorithmDetection;)V", "getTraceId", "()Ljava/lang/String;", "getImageDatas", "()Ljava/util/List;", "getReturnQuestionImages", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getImageOrientations", "getDetectionType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getProcessTypes", "getBusinessType", "()Lcom/larus/camera/impl/edulibs/camera/internal/idl/BusinessType;", "getSceneType", "()Lcom/larus/camera/impl/edulibs/cameraapi/SceneType;", "getGraceStrategyTrack", "()Lcom/larus/camera/impl/edulibs/camera/internal/idl/GraceStrategyTrackBeforeAlgorithmDetection;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Integer;Ljava/util/List;Lcom/larus/camera/impl/edulibs/camera/internal/idl/BusinessType;Lcom/larus/camera/impl/edulibs/cameraapi/SceneType;Lcom/larus/camera/impl/edulibs/camera/internal/idl/GraceStrategyTrackBeforeAlgorithmDetection;)Lcom/larus/camera/impl/edulibs/camera/internal/idl/QuestionDetectionRequest;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class c {

    @SerializedName("business_type")
    private final BusinessType businessType;

    @SerializedName("detection_type")
    private final Integer detectionType;

    @SerializedName("grace_strategy_track")
    private final a graceStrategyTrack;

    @SerializedName("ImageDatas")
    private final List<b> imageDatas;

    @SerializedName("ImageOrientations")
    private final List<Orientation> imageOrientations;

    @SerializedName("ProcessTypes")
    private final List<ProcessType> processTypes;

    @SerializedName("ReturnQuestionImages")
    private final Boolean returnQuestionImages;

    @SerializedName("scene_type")
    private final SceneType sceneType;

    @SerializedName("TraceId")
    private final String traceId;

    public c() {
        this(null, null, null, null, null, null, null, null, 511);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (Intrinsics.areEqual(this.traceId, r6.traceId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageDatas, r6.imageDatas) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.returnQuestionImages, r6.returnQuestionImages) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageOrientations, r6.imageOrientations) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.detectionType, r6.detectionType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.processTypes, r6.processTypes) == true) goto L27;
        return false;
    L27:
        if (this.businessType == r6.businessType) goto L30;
        return false;
    L30:
        if (this.sceneType == r6.sceneType) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.graceStrategyTrack, r6.graceStrategyTrack) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r0 = this.traceId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        List<b> r4 = this.imageDatas;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.returnQuestionImages;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<Orientation> r10 = this.imageOrientations;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.detectionType;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        List<ProcessType> r16 = this.processTypes;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        BusinessType r19 = this.businessType;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        SceneType r22 = this.sceneType;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        a r25 = this.graceStrategyTrack;
        if (r25 == null) goto L39;
        r1 = r25.hashCode();
    L39:
        return r24 + r1;
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
        return "QuestionDetectionRequest(traceId=" + this.traceId + ", imageDatas=" + this.imageDatas + ", returnQuestionImages=" + this.returnQuestionImages + ", imageOrientations=" + this.imageOrientations + ", detectionType=" + this.detectionType + ", processTypes=" + this.processTypes + ", businessType=" + this.businessType + ", sceneType=" + this.sceneType + ", graceStrategyTrack=" + this.graceStrategyTrack + ')';
    }

    public c(String r3, List r4, Boolean r5, Integer r6, List r7, BusinessType r8, SceneType r9, a r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r3 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r4 = null;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r5 = null;
    L12:
        if ((r11 & 16) == 0) goto L15;
        r6 = null;
    L15:
        if ((r11 & 32) == 0) goto L18;
        r7 = null;
    L18:
        if ((r11 & 64) == 0) goto L21;
        r8 = null;
    L21:
        if ((r11 & 128) == 0) goto L24;
        r9 = null;
    L24:
        if ((r11 & 256) == 0) goto L26;
        r10 = null;
    L26:
        this.traceId = r3;
        this.imageDatas = r4;
        this.returnQuestionImages = r5;
        this.imageOrientations = null;
        this.detectionType = r6;
        this.processTypes = r7;
        this.businessType = r8;
        this.sceneType = r9;
        this.graceStrategyTrack = r10;
    }
}
