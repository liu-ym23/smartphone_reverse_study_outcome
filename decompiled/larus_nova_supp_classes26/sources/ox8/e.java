package ox8;

import com.google.gson.annotations.SerializedName;
import com.larus.camera.impl.edulibs.cameraapi.idl.RpcErrorCode;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b/\b\u0086\b\u0018\u00002\u00020\u0001BÕ\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0018\u00010\t\u0012\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t\u0018\u00010\t\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u000b\u00102\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u001b\u00105\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0018\u00010\tHÆ\u0003J\u001b\u00106\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t\u0018\u00010\tHÆ\u0003J\u0011\u00107\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tHÆ\u0003J\u0010\u00108\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010;\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010)J\u000b\u0010<\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010?\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0002\u00100JÜ\u0001\u0010@\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0018\u00010\t2\u001a\b\u0002\u0010\u000b\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t\u0018\u00010\t2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020\u00172\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020\u0007HÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR(\u0010\b\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R(\u0010\u000b\u001a\u0014\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\t\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\"R\u001a\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010 \u001a\u0004\b%\u0010\u001fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001bR\u0015\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\n\n\u0002\u00101\u001a\u0004\b/\u00100¨\u0006F"}, d2 = {"Lcom/larus/camera/impl/edulibs/cameraapi/idl/QuestionDetectionResponse;", "", "traceId", "", "rpcCode", "Lcom/larus/camera/impl/edulibs/cameraapi/idl/RpcErrorCode;", "elapsedTime", "", "questionBoxes", "", "Lcom/larus/camera/impl/edulibs/cameraapi/idl/QuestionPoly;", "questionImages", "centralBoxIndexList", "imageOrientation", "handWrittenRemovalBase64", "imageDewarpBase64", "detectionId", "", "statusInfo", "Lcom/larus/camera/impl/edulibs/cameraapi/idl/StatusInfo;", "requestId", "eduExtraParam", "homeworkCorrectionEnabled", "", "<init>", "(Ljava/lang/String;Lcom/larus/camera/impl/edulibs/cameraapi/idl/RpcErrorCode;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/camera/impl/edulibs/cameraapi/idl/StatusInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getTraceId", "()Ljava/lang/String;", "getRpcCode", "()Lcom/larus/camera/impl/edulibs/cameraapi/idl/RpcErrorCode;", "getElapsedTime", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getQuestionBoxes", "()Ljava/util/List;", "getQuestionImages", "getCentralBoxIndexList", "getImageOrientation", "getHandWrittenRemovalBase64", "getImageDewarpBase64", "getDetectionId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getStatusInfo", "()Lcom/larus/camera/impl/edulibs/cameraapi/idl/StatusInfo;", "getRequestId", "getEduExtraParam", "getHomeworkCorrectionEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "(Ljava/lang/String;Lcom/larus/camera/impl/edulibs/cameraapi/idl/RpcErrorCode;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lcom/larus/camera/impl/edulibs/cameraapi/idl/StatusInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/larus/camera/impl/edulibs/cameraapi/idl/QuestionDetectionResponse;", "equals", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {
    public final Boolean a;

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
    private final List<List<g>> questionBoxes;

    @SerializedName("QuestionImages")
    private final List<List<String>> questionImages;

    @SerializedName("request_id")
    private final String requestId;

    @SerializedName("RpcCode")
    private final RpcErrorCode rpcCode;

    @SerializedName("status_info")
    private final i statusInfo;

    @SerializedName("TraceId")
    private final String traceId;

    public e() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
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
        if (Intrinsics.areEqual(this.requestId, r6.requestId) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.eduExtraParam, r6.eduExtraParam) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L50;
        return false;
    L50:
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
        List<List<g>> r10 = this.questionBoxes;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        List<List<String>> r13 = this.questionImages;
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
        String r34 = this.requestId;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.eduExtraParam;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        Boolean r40 = this.a;
        if (r40 == null) goto L59;
        r1 = r40.hashCode();
    L59:
        return r39 + r1;
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

    public final String toString() {
        return "QuestionDetectionResponse(traceId=" + this.traceId + ", rpcCode=" + this.rpcCode + ", elapsedTime=" + this.elapsedTime + ", questionBoxes=" + this.questionBoxes + ", questionImages=" + this.questionImages + ", centralBoxIndexList=" + this.centralBoxIndexList + ", imageOrientation=" + this.imageOrientation + ", handWrittenRemovalBase64=" + this.handWrittenRemovalBase64 + ", imageDewarpBase64=" + this.imageDewarpBase64 + ", detectionId=" + this.detectionId + ", statusInfo=" + this.statusInfo + ", requestId=" + this.requestId + ", eduExtraParam=" + this.eduExtraParam + ", homeworkCorrectionEnabled=" + this.a + ')';
    }

    public final List<Integer> b() {
        return this.centralBoxIndexList;
    }

    public final Long c() {
        return this.detectionId;
    }

    public final String d() {
        return this.eduExtraParam;
    }

    public final String e() {
        return this.imageDewarpBase64;
    }

    public final Integer f() {
        return this.imageOrientation;
    }

    public final List<List<g>> g() {
        return this.questionBoxes;
    }

    public final List<List<String>> h() {
        return this.questionImages;
    }

    public final String i() {
        return this.requestId;
    }

    public final String j() {
        return this.traceId;
    }

    public static e a(e r19, Integer r20, String r21, String r22, Boolean r23, int r24) {
        i r3 = null;
        if ((r24 & 1) == 0) goto L5;
        String r5 = r19.traceId;
    L7:
        if ((r24 & 2) == 0) goto L9;
        RpcErrorCode r6 = r19.rpcCode;
    L11:
        if ((r24 & 4) == 0) goto L13;
        Integer r7 = r19.elapsedTime;
    L15:
        if ((r24 & 8) == 0) goto L17;
        List<List<g>> r8 = r19.questionBoxes;
    L19:
        if ((r24 & 16) == 0) goto L21;
        List<List<String>> r9 = r19.questionImages;
    L23:
        if ((r24 & 32) == 0) goto L25;
        List<Integer> r10 = r19.centralBoxIndexList;
    L27:
        if ((r24 & 64) == 0) goto L29;
        Integer r11 = r19.imageOrientation;
    L31:
        if ((r24 & 128) == 0) goto L33;
        String r12 = r19.handWrittenRemovalBase64;
    L35:
        if ((r24 & 256) == 0) goto L37;
        String r13 = r19.imageDewarpBase64;
    L39:
        if ((r24 & 512) == 0) goto L41;
        Long r14 = r19.detectionId;
    L43:
        if ((r24 & 1024) == 0) goto L45;
        r3 = r19.statusInfo;
    L45:
        i r15 = r3;
        if ((r24 & 2048) == 0) goto L48;
        String r16 = r19.requestId;
    L50:
        if ((r24 & 4096) == 0) goto L52;
        String r17 = r19.eduExtraParam;
    L54:
        if ((r24 & 8192) == 0) goto L56;
        Boolean r18 = r19.a;
    L58:
        return new e(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    L56:
        r18 = r23;
        goto L58
    L52:
        r17 = r22;
        goto L54
    L48:
        r16 = r21;
        goto L50
    L41:
        r14 = null;
        goto L43
    L37:
        r13 = null;
        goto L39
    L33:
        r12 = null;
        goto L35
    L29:
        r11 = r20;
        goto L31
    L25:
        r10 = null;
        goto L27
    L21:
        r9 = null;
        goto L23
    L17:
        r8 = null;
        goto L19
    L13:
        r7 = null;
        goto L15
    L9:
        r6 = null;
        goto L11
    L5:
        r5 = null;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(String r1, RpcErrorCode r2, Integer r3, List<? extends List<g>> r4, List<? extends List<String>> r5, List<Integer> r6, Integer r7, String r8, String r9, Long r10, i r11, String r12, String r13, Boolean r14) {
        this.traceId = r1;
        this.rpcCode = r2;
        this.elapsedTime = r3;
        this.questionBoxes = r4;
        this.questionImages = r5;
        this.centralBoxIndexList = r6;
        this.imageOrientation = r7;
        this.handWrittenRemovalBase64 = r8;
        this.imageDewarpBase64 = r9;
        this.detectionId = r10;
        this.statusInfo = r11;
        this.requestId = r12;
        this.eduExtraParam = r13;
        this.a = r14;
    }

    public /* synthetic */ e(String r16, RpcErrorCode r17, Integer r18, List r19, List r20, List r21, Integer r22, String r23, String r24, Long r25, i r26, String r27, String r28, Boolean r29, int r30) {
        Boolean r2 = null;
        if ((r30 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r30 & 2) == 0) goto L9;
        RpcErrorCode r3 = null;
    L11:
        if ((r30 & 4) == 0) goto L13;
        Integer r4 = null;
    L15:
        if ((r30 & 8) == 0) goto L17;
        List r5 = null;
    L19:
        if ((r30 & 16) == 0) goto L21;
        List r6 = null;
    L23:
        if ((r30 & 32) == 0) goto L25;
        List r7 = null;
    L27:
        if ((r30 & 64) == 0) goto L29;
        Integer r8 = null;
    L31:
        if ((r30 & 128) == 0) goto L33;
        String r9 = null;
    L35:
        if ((r30 & 256) == 0) goto L37;
        String r10 = null;
    L39:
        if ((r30 & 512) == 0) goto L41;
        Long r11 = null;
    L43:
        if ((r30 & 1024) == 0) goto L45;
        i r12 = null;
    L47:
        if ((r30 & 2048) == 0) goto L49;
        String r13 = null;
    L51:
        if ((r30 & 4096) == 0) goto L53;
        String r14 = null;
    L55:
        if ((r30 & 8192) != 0) goto L58;
        r2 = r29;
    L58:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r2);
        return;
    L53:
        r14 = r28;
        goto L55
    L49:
        r13 = r27;
        goto L51
    L45:
        r12 = r26;
        goto L47
    L41:
        r11 = r25;
        goto L43
    L37:
        r10 = r24;
        goto L39
    L33:
        r9 = r23;
        goto L35
    L29:
        r8 = r22;
        goto L31
    L25:
        r7 = r21;
        goto L27
    L21:
        r6 = r20;
        goto L23
    L17:
        r5 = r19;
        goto L19
    L13:
        r4 = r18;
        goto L15
    L9:
        r3 = r17;
        goto L11
    L5:
        r1 = r16;
        goto L7
    }
}
