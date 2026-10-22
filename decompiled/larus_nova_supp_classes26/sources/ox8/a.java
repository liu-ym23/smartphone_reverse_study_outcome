package ox8;

import com.google.gson.annotations.SerializedName;
import com.larus.camera.impl.edulibs.cameraapi.idl.RpcErrorCode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\t\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0013\u0010/\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tHÆ\u0003J\u0013\u00100\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\tHÆ\u0003J\u0013\u00101\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\tHÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u000b\u00103\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0002\u0010'J\u000b\u00106\u001a\u0004\u0018\u00010\u0014HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¶\u0001\u00108\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t2\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\t2\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010=\u001a\u00020\u0007HÖ\u0001J\t\u0010>\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R \u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b#\u0010\u001dR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0019R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019¨\u0006?"}, d2 = {"Lcom/larus/camera/impl/edulibs/cameraapi/idl/GetQuestionDetectionPiecesResponse;", "", "traceId", "", "rpcCode", "Lcom/larus/camera/impl/edulibs/cameraapi/idl/RpcErrorCode;", "elapsedTime", "", "questionBoxes", "", "Lcom/larus/camera/impl/edulibs/cameraapi/idl/QuestionPolyItems;", "questionImages", "Lcom/larus/camera/impl/edulibs/cameraapi/idl/QuestionImageItems;", "centralBoxIndexList", "imageOrientation", "handWrittenRemovalBase64", "imageDewarpBase64", "detectionId", "", "statusInfo", "Lcom/larus/camera/impl/edulibs/cameraapi/idl/StatusInfo;", "eduExtraParam", "<init>", "(Ljava/lang/String;Lcom/larus/camera/impl/edulibs/cameraapi/idl/RpcErrorCode;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/camera/impl/edulibs/cameraapi/idl/StatusInfo;Ljava/lang/String;)V", "getTraceId", "()Ljava/lang/String;", "getRpcCode", "()Lcom/larus/camera/impl/edulibs/cameraapi/idl/RpcErrorCode;", "getElapsedTime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getQuestionBoxes", "()Ljava/util/List;", "getQuestionImages", "getCentralBoxIndexList", "getImageOrientation", "getHandWrittenRemovalBase64", "getImageDewarpBase64", "getDetectionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStatusInfo", "()Lcom/larus/camera/impl/edulibs/cameraapi/idl/StatusInfo;", "getEduExtraParam", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "copy", "(Ljava/lang/String;Lcom/larus/camera/impl/edulibs/cameraapi/idl/RpcErrorCode;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/camera/impl/edulibs/cameraapi/idl/StatusInfo;Ljava/lang/String;)Lcom/larus/camera/impl/edulibs/cameraapi/idl/GetQuestionDetectionPiecesResponse;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("CentralBoxIndexList")
    private final List<Integer> centralBoxIndexList;

    @SerializedName("detection_id")
    private final Long detectionId;

    @SerializedName("edu_extra_param")
    private final String eduExtraParam;

    @SerializedName("ElapsedTime")
    private final Integer elapsedTime;

    @SerializedName("HandWrittenRemovalBase64")
    private final String handWrittenRemovalBase64;

    @SerializedName("ImageDewarpBase64")
    private final String imageDewarpBase64;

    @SerializedName("image_orientation")
    private final Integer imageOrientation;

    @SerializedName("QuestionBoxes")
    private final List<h> questionBoxes;

    @SerializedName("QuestionImages")
    private final List<f> questionImages;

    @SerializedName("RpcCode")
    private final RpcErrorCode rpcCode;

    @SerializedName("status_info")
    private final i statusInfo;

    @SerializedName("TraceId")
    private final String traceId;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.traceId, r6.traceId) == true) goto L12;
        return false;
    L12:
        if (this.rpcCode == r6.rpcCode) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.elapsedTime, r6.elapsedTime) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.questionBoxes, r6.questionBoxes) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.questionImages, r6.questionImages) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.centralBoxIndexList, r6.centralBoxIndexList) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.imageOrientation, r6.imageOrientation) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.handWrittenRemovalBase64, r6.handWrittenRemovalBase64) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.imageDewarpBase64, r6.imageDewarpBase64) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.detectionId, r6.detectionId) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.statusInfo, r6.statusInfo) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.eduExtraParam, r6.eduExtraParam) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        String r0 = this.traceId;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        RpcErrorCode r4 = this.rpcCode;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.elapsedTime;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        List<h> r10 = this.questionBoxes;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<f> r13 = this.questionImages;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        List<Integer> r16 = this.centralBoxIndexList;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.imageOrientation;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        String r22 = this.handWrittenRemovalBase64;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        String r25 = this.imageDewarpBase64;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Long r28 = this.detectionId;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        i r31 = this.statusInfo;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        String r34 = this.eduExtraParam;
        if (r34 == null) goto L51;
        r1 = r34.hashCode();
    L51:
        return r33 + r1;
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

    public final String toString() {
        return "GetQuestionDetectionPiecesResponse(traceId=" + this.traceId + ", rpcCode=" + this.rpcCode + ", elapsedTime=" + this.elapsedTime + ", questionBoxes=" + this.questionBoxes + ", questionImages=" + this.questionImages + ", centralBoxIndexList=" + this.centralBoxIndexList + ", imageOrientation=" + this.imageOrientation + ", handWrittenRemovalBase64=" + this.handWrittenRemovalBase64 + ", imageDewarpBase64=" + this.imageDewarpBase64 + ", detectionId=" + this.detectionId + ", statusInfo=" + this.statusInfo + ", eduExtraParam=" + this.eduExtraParam + ')';
    }

    public a() {
        this.traceId = null;
        this.rpcCode = null;
        this.elapsedTime = null;
        this.questionBoxes = null;
        this.questionImages = null;
        this.centralBoxIndexList = null;
        this.imageOrientation = null;
        this.handWrittenRemovalBase64 = null;
        this.imageDewarpBase64 = null;
        this.detectionId = null;
        this.statusInfo = null;
        this.eduExtraParam = null;
    }

    public final List<Integer> a() {
        return this.centralBoxIndexList;
    }

    public final Long b() {
        return this.detectionId;
    }

    public final String c() {
        return this.eduExtraParam;
    }

    public final Integer d() {
        return this.elapsedTime;
    }

    public final String e() {
        return this.handWrittenRemovalBase64;
    }

    public final String f() {
        return this.imageDewarpBase64;
    }

    public final Integer g() {
        return this.imageOrientation;
    }

    public final List<h> h() {
        return this.questionBoxes;
    }

    public final List<f> i() {
        return this.questionImages;
    }

    public final RpcErrorCode j() {
        return this.rpcCode;
    }

    public final i k() {
        return this.statusInfo;
    }

    public final String l() {
        return this.traceId;
    }
}
