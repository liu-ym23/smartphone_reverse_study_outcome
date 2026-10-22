package oq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b;\b\u0086\b\u0018\u0000 P2\u00020\u0001:\u0001PBå\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010>\u001a\u00020\u000bHÆ\u0003J\t\u0010?\u001a\u00020\rHÆ\u0003J\t\u0010@\u001a\u00020\u000fHÆ\u0003J\u0010\u0010A\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010+J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010F\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u00102J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jì\u0001\u0010J\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010KJ\u0013\u0010L\u001a\u00020\u00162\b\u0010M\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010N\u001a\u00020\u000bHÖ\u0001J\t\u0010O\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001dR\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0016\u0010\u000e\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010,\u001a\u0004\b*\u0010+R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u001dR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001dR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001dR\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00103\u001a\u0004\b1\u00102R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001dR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\u001dR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u001d¨\u0006Q"}, d2 = {"Lcom/larus/platform/model/camera/EduCameraConfig;", "", "captureGeneralTipTitle", "", "captureGeneralTipSubTitle", "captureCalculationTipTitle", "captureCalculationTipSubTitle", "captureArticleTipTitle", "captureArticleTipSubTitle", "clipToast", "clipImageQuality", "", "cloudClipTimeoutMs", "", "imageReportSampleRate", "", "captureArticleImageCount", "captureGeneralIconTip", "captureArticleIconTip", "captureGaokaoIconTip", "captureCalculationIconTip", "enableMultiQuestion", "", "captureHomeworkTipTitle", "captureHomeworkTipSubTitle", "captureHomeworkIconTip", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJFLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCaptureGeneralTipTitle", "()Ljava/lang/String;", "getCaptureGeneralTipSubTitle", "getCaptureCalculationTipTitle", "getCaptureCalculationTipSubTitle", "getCaptureArticleTipTitle", "getCaptureArticleTipSubTitle", "getClipToast", "getClipImageQuality", "()I", "getCloudClipTimeoutMs", "()J", "getImageReportSampleRate", "()F", "getCaptureArticleImageCount", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCaptureGeneralIconTip", "getCaptureArticleIconTip", "getCaptureGaokaoIconTip", "getCaptureCalculationIconTip", "getEnableMultiQuestion", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCaptureHomeworkTipTitle", "getCaptureHomeworkTipSubTitle", "getCaptureHomeworkIconTip", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJFLjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/larus/platform/model/camera/EduCameraConfig;", "equals", "other", "hashCode", "toString", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class h {

    @SerializedName("capture_article_icon_tip")
    private final String captureArticleIconTip;

    @SerializedName("capture_article_image_count")
    private final Integer captureArticleImageCount;

    @SerializedName("capture_article_tip_sub_title")
    private final String captureArticleTipSubTitle;

    @SerializedName("capture_article_tip_title")
    private final String captureArticleTipTitle;

    @SerializedName("capture_calculation_icon_tip")
    private final String captureCalculationIconTip;

    @SerializedName("capture_calculation_tip_sub_title")
    private final String captureCalculationTipSubTitle;

    @SerializedName("capture_calculation_tip_title")
    private final String captureCalculationTipTitle;

    @SerializedName("capture_gaokao_icon_tip")
    private final String captureGaokaoIconTip;

    @SerializedName("capture_general_icon_tip")
    private final String captureGeneralIconTip;

    @SerializedName("capture_tip_sub_title")
    private final String captureGeneralTipSubTitle;

    @SerializedName("capture_tip_title")
    private final String captureGeneralTipTitle;

    @SerializedName("capture_homework_icon_tip")
    private final String captureHomeworkIconTip;

    @SerializedName("capture_homework_tip_sub_title")
    private final String captureHomeworkTipSubTitle;

    @SerializedName("capture_homework_tip_title")
    private final String captureHomeworkTipTitle;

    @SerializedName("clip_image_quality")
    private final int clipImageQuality;

    @SerializedName("clip_toast")
    private final String clipToast;

    @SerializedName("cloud_clip_timeout_ms")
    private final long cloudClipTimeoutMs;

    @SerializedName("enable_multi_question")
    private final Boolean enableMultiQuestion;

    @SerializedName("image_report_sample_rate")
    private final float imageReportSampleRate;

    public static final class a {
    }

    static {
    }

    public h() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof h) == true) goto L8;
        return false;
    L8:
        h r9 = (h) r8;
        if (Intrinsics.areEqual(this.captureGeneralTipTitle, r9.captureGeneralTipTitle) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.captureGeneralTipSubTitle, r9.captureGeneralTipSubTitle) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.captureCalculationTipTitle, r9.captureCalculationTipTitle) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.captureCalculationTipSubTitle, r9.captureCalculationTipSubTitle) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.captureArticleTipTitle, r9.captureArticleTipTitle) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.captureArticleTipSubTitle, r9.captureArticleTipSubTitle) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.clipToast, r9.clipToast) == true) goto L30;
        return false;
    L30:
        if (this.clipImageQuality == r9.clipImageQuality) goto L33;
        return false;
    L33:
        if (this.cloudClipTimeoutMs == r9.cloudClipTimeoutMs) goto L36;
        return false;
    L36:
        if (Float.compare(this.imageReportSampleRate, r9.imageReportSampleRate) == 0) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.captureArticleImageCount, r9.captureArticleImageCount) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.captureGeneralIconTip, r9.captureGeneralIconTip) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.captureArticleIconTip, r9.captureArticleIconTip) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.captureGaokaoIconTip, r9.captureGaokaoIconTip) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.captureCalculationIconTip, r9.captureCalculationIconTip) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.enableMultiQuestion, r9.enableMultiQuestion) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.captureHomeworkTipTitle, r9.captureHomeworkTipTitle) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.captureHomeworkTipSubTitle, r9.captureHomeworkTipSubTitle) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.captureHomeworkIconTip, r9.captureHomeworkIconTip) == true) goto L65;
        return false;
    L65:
        return true;
    }

    public final int hashCode() {
        String r0 = this.captureGeneralTipTitle;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.captureGeneralTipSubTitle;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.captureCalculationTipTitle;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.captureCalculationTipSubTitle;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.captureArticleTipTitle;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.captureArticleTipSubTitle;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.clipToast;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (((r18 + r20) * 31) + this.clipImageQuality) * 31;
        long r22 = this.cloudClipTimeoutMs;
        int r23 = (((r21 + ((int) (r22 ^ (r22 >>> 32)))) * 31) + Float.floatToIntBits(this.imageReportSampleRate)) * 31;
        Integer r24 = this.captureArticleImageCount;
        if (r24 != null) goto L33;
        int r25 = 0;
    L34:
        int r26 = (r23 + r25) * 31;
        String r27 = this.captureGeneralIconTip;
        if (r27 != null) goto L37;
        int r28 = 0;
    L38:
        int r29 = (r26 + r28) * 31;
        String r30 = this.captureArticleIconTip;
        if (r30 != null) goto L41;
        int r31 = 0;
    L42:
        int r32 = (r29 + r31) * 31;
        String r33 = this.captureGaokaoIconTip;
        if (r33 != null) goto L45;
        int r34 = 0;
    L46:
        int r35 = (r32 + r34) * 31;
        String r36 = this.captureCalculationIconTip;
        if (r36 != null) goto L49;
        int r37 = 0;
    L50:
        int r38 = (r35 + r37) * 31;
        Boolean r39 = this.enableMultiQuestion;
        if (r39 != null) goto L53;
        int r40 = 0;
    L54:
        int r41 = (r38 + r40) * 31;
        String r42 = this.captureHomeworkTipTitle;
        if (r42 != null) goto L57;
        int r43 = 0;
    L58:
        int r44 = (r41 + r43) * 31;
        String r45 = this.captureHomeworkTipSubTitle;
        if (r45 != null) goto L61;
        int r46 = 0;
    L62:
        int r47 = (r44 + r46) * 31;
        String r48 = this.captureHomeworkIconTip;
        if (r48 == null) goto L67;
        r1 = r48.hashCode();
    L67:
        return r47 + r1;
    L61:
        r46 = r45.hashCode();
        goto L62
    L57:
        r43 = r42.hashCode();
        goto L58
    L53:
        r40 = r39.hashCode();
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
        r28 = r27.hashCode();
        goto L38
    L33:
        r25 = r24.hashCode();
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
        return "EduCameraConfig(captureGeneralTipTitle=" + this.captureGeneralTipTitle + ", captureGeneralTipSubTitle=" + this.captureGeneralTipSubTitle + ", captureCalculationTipTitle=" + this.captureCalculationTipTitle + ", captureCalculationTipSubTitle=" + this.captureCalculationTipSubTitle + ", captureArticleTipTitle=" + this.captureArticleTipTitle + ", captureArticleTipSubTitle=" + this.captureArticleTipSubTitle + ", clipToast=" + this.clipToast + ", clipImageQuality=" + this.clipImageQuality + ", cloudClipTimeoutMs=" + this.cloudClipTimeoutMs + ", imageReportSampleRate=" + this.imageReportSampleRate + ", captureArticleImageCount=" + this.captureArticleImageCount + ", captureGeneralIconTip=" + this.captureGeneralIconTip + ", captureArticleIconTip=" + this.captureArticleIconTip + ", captureGaokaoIconTip=" + this.captureGaokaoIconTip + ", captureCalculationIconTip=" + this.captureCalculationIconTip + ", enableMultiQuestion=" + this.enableMultiQuestion + ", captureHomeworkTipTitle=" + this.captureHomeworkTipTitle + ", captureHomeworkTipSubTitle=" + this.captureHomeworkTipSubTitle + ", captureHomeworkIconTip=" + this.captureHomeworkIconTip + ')';
    }

    public final String a() {
        return this.captureArticleIconTip;
    }

    public final Integer b() {
        return this.captureArticleImageCount;
    }

    public final String c() {
        return this.captureArticleTipSubTitle;
    }

    public final String d() {
        return this.captureArticleTipTitle;
    }

    public final String e() {
        return this.captureCalculationIconTip;
    }

    public final String f() {
        return this.captureCalculationTipSubTitle;
    }

    public final String g() {
        return this.captureCalculationTipTitle;
    }

    public final String h() {
        return this.captureGaokaoIconTip;
    }

    public final String i() {
        return this.captureGeneralIconTip;
    }

    public final String j() {
        return this.captureGeneralTipSubTitle;
    }

    public final String k() {
        return this.captureGeneralTipTitle;
    }

    public final String l() {
        return this.captureHomeworkIconTip;
    }

    public final String m() {
        return this.captureHomeworkTipSubTitle;
    }

    public final String n() {
        return this.captureHomeworkTipTitle;
    }

    public final int o() {
        return this.clipImageQuality;
    }

    public final String p() {
        return this.clipToast;
    }

    public final long q() {
        return this.cloudClipTimeoutMs;
    }

    public final Boolean r() {
        return this.enableMultiQuestion;
    }

    public final float s() {
        return this.imageReportSampleRate;
    }

    public /* synthetic */ h(int r22) {
        this(null, null, null, null, null, null, null, 70, 800, 0.0f, 5, null, null, null, null, Boolean.FALSE, null, null, null);
    }

    public h(String r4, String r5, String r6, String r7, String r8, String r9, String r10, int r11, long r12, float r14, Integer r15, String r16, String r17, String r18, String r19, Boolean r20, String r21, String r22, String r23) {
        this.captureGeneralTipTitle = r4;
        this.captureGeneralTipSubTitle = r5;
        this.captureCalculationTipTitle = r6;
        this.captureCalculationTipSubTitle = r7;
        this.captureArticleTipTitle = r8;
        this.captureArticleTipSubTitle = r9;
        this.clipToast = r10;
        this.clipImageQuality = r11;
        this.cloudClipTimeoutMs = r12;
        this.imageReportSampleRate = r14;
        this.captureArticleImageCount = r15;
        this.captureGeneralIconTip = r16;
        this.captureArticleIconTip = r17;
        this.captureGaokaoIconTip = r18;
        this.captureCalculationIconTip = r19;
        this.enableMultiQuestion = r20;
        this.captureHomeworkTipTitle = r21;
        this.captureHomeworkTipSubTitle = r22;
        this.captureHomeworkIconTip = r23;
    }
}
