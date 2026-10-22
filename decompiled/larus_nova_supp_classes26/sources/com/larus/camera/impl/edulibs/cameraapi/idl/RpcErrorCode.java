package com.larus.camera.impl.edulibs.cameraapi.idl;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.chat.tips.GuideTipType;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u001f\b\u0087\u0081\u0002\u0018\u0000 !2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001!B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006\""}, d2 = {"Lcom/larus/camera/impl/edulibs/cameraapi/idl/RpcErrorCode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Succeed", "LineDetection_img_err", "LineDetection_proc_err", "LineDetection_bernard_err", "LineRecog_img_err", "LineRecog_proc_err", "LineRecog_bernard_err", "LineRecog_resource_insufficient", "FormulaDetection_img_err", "FormulaDetection_proc_err", "FormulaDetection_bernard_err", "FormulaRecog_img_err", "FormulaRecog_proc_err", "FormulaRecog_bernard_err", "Ocr_req_err", "Ocr_use_linedetection_err", "Ocr_use_linerecog_err", "Ocr_use_formuladetection_err", "Ocr_use_formularecog_err", "Ocr_line_detect_sd_err", "Ocr_formula_detect_sd_err", "Ocr_line_recog_sd_err", "Ocr_formula_recog_sd_err", "Ocr_exec_err", "Ocr_qps_err", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RpcErrorCode extends Enum<RpcErrorCode> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ RpcErrorCode[] $VALUES = null;
    public static final a Companion = null;

    @SerializedName("3003")
    public static final RpcErrorCode FormulaDetection_bernard_err = null;

    @SerializedName("3001")
    public static final RpcErrorCode FormulaDetection_img_err = null;

    @SerializedName("3002")
    public static final RpcErrorCode FormulaDetection_proc_err = null;

    @SerializedName("4003")
    public static final RpcErrorCode FormulaRecog_bernard_err = null;

    @SerializedName("4001")
    public static final RpcErrorCode FormulaRecog_img_err = null;

    @SerializedName("4002")
    public static final RpcErrorCode FormulaRecog_proc_err = null;

    @SerializedName("1003")
    public static final RpcErrorCode LineDetection_bernard_err = null;

    @SerializedName("1001")
    public static final RpcErrorCode LineDetection_img_err = null;

    @SerializedName("1002")
    public static final RpcErrorCode LineDetection_proc_err = null;

    @SerializedName("2003")
    public static final RpcErrorCode LineRecog_bernard_err = null;

    @SerializedName("2001")
    public static final RpcErrorCode LineRecog_img_err = null;

    @SerializedName("2002")
    public static final RpcErrorCode LineRecog_proc_err = null;

    @SerializedName("2004")
    public static final RpcErrorCode LineRecog_resource_insufficient = null;

    @SerializedName("9999")
    public static final RpcErrorCode Ocr_exec_err = null;

    @SerializedName("9007")
    public static final RpcErrorCode Ocr_formula_detect_sd_err = null;

    @SerializedName("9009")
    public static final RpcErrorCode Ocr_formula_recog_sd_err = null;

    @SerializedName("9006")
    public static final RpcErrorCode Ocr_line_detect_sd_err = null;

    @SerializedName("9008")
    public static final RpcErrorCode Ocr_line_recog_sd_err = null;

    @SerializedName("1604")
    public static final RpcErrorCode Ocr_qps_err = null;

    @SerializedName("9001")
    public static final RpcErrorCode Ocr_req_err = null;

    @SerializedName("9004")
    public static final RpcErrorCode Ocr_use_formuladetection_err = null;

    @SerializedName("9005")
    public static final RpcErrorCode Ocr_use_formularecog_err = null;

    @SerializedName("9002")
    public static final RpcErrorCode Ocr_use_linedetection_err = null;

    @SerializedName("9003")
    public static final RpcErrorCode Ocr_use_linerecog_err = null;

    @SerializedName(TriggerSendLoading.NO_LOADING)
    public static final RpcErrorCode Succeed = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ RpcErrorCode[] $values() {
        return new RpcErrorCode[]{Succeed, LineDetection_img_err, LineDetection_proc_err, LineDetection_bernard_err, LineRecog_img_err, LineRecog_proc_err, LineRecog_bernard_err, LineRecog_resource_insufficient, FormulaDetection_img_err, FormulaDetection_proc_err, FormulaDetection_bernard_err, FormulaRecog_img_err, FormulaRecog_proc_err, FormulaRecog_bernard_err, Ocr_req_err, Ocr_use_linedetection_err, Ocr_use_linerecog_err, Ocr_use_formuladetection_err, Ocr_use_formularecog_err, Ocr_line_detect_sd_err, Ocr_formula_detect_sd_err, Ocr_line_recog_sd_err, Ocr_formula_recog_sd_err, Ocr_exec_err, Ocr_qps_err};
    }

    public static EnumEntries<RpcErrorCode> getEntries() {
        return $ENTRIES;
    }

    static {
        Succeed = new RpcErrorCode("Succeed", 0, 0);
        LineDetection_img_err = new RpcErrorCode("LineDetection_img_err", 1, 1001);
        LineDetection_proc_err = new RpcErrorCode("LineDetection_proc_err", 2, 1002);
        LineDetection_bernard_err = new RpcErrorCode("LineDetection_bernard_err", 3, 1003);
        LineRecog_img_err = new RpcErrorCode("LineRecog_img_err", 4, 2001);
        LineRecog_proc_err = new RpcErrorCode("LineRecog_proc_err", 5, 2002);
        LineRecog_bernard_err = new RpcErrorCode("LineRecog_bernard_err", 6, 2003);
        LineRecog_resource_insufficient = new RpcErrorCode("LineRecog_resource_insufficient", 7, 2004);
        FormulaDetection_img_err = new RpcErrorCode("FormulaDetection_img_err", 8, 3001);
        FormulaDetection_proc_err = new RpcErrorCode("FormulaDetection_proc_err", 9, 3002);
        FormulaDetection_bernard_err = new RpcErrorCode("FormulaDetection_bernard_err", 10, 3003);
        FormulaRecog_img_err = new RpcErrorCode("FormulaRecog_img_err", 11, 4001);
        FormulaRecog_proc_err = new RpcErrorCode("FormulaRecog_proc_err", 12, 4002);
        FormulaRecog_bernard_err = new RpcErrorCode("FormulaRecog_bernard_err", 13, 4003);
        Ocr_req_err = new RpcErrorCode("Ocr_req_err", 14, 9001);
        Ocr_use_linedetection_err = new RpcErrorCode("Ocr_use_linedetection_err", 15, 9002);
        Ocr_use_linerecog_err = new RpcErrorCode("Ocr_use_linerecog_err", 16, 9003);
        Ocr_use_formuladetection_err = new RpcErrorCode("Ocr_use_formuladetection_err", 17, 9004);
        Ocr_use_formularecog_err = new RpcErrorCode("Ocr_use_formularecog_err", 18, 9005);
        Ocr_line_detect_sd_err = new RpcErrorCode("Ocr_line_detect_sd_err", 19, 9006);
        Ocr_formula_detect_sd_err = new RpcErrorCode("Ocr_formula_detect_sd_err", 20, 9007);
        Ocr_line_recog_sd_err = new RpcErrorCode("Ocr_line_recog_sd_err", 21, 9008);
        Ocr_formula_recog_sd_err = new RpcErrorCode("Ocr_formula_recog_sd_err", 22, 9009);
        Ocr_exec_err = new RpcErrorCode("Ocr_exec_err", 23, GuideTipType.FORCE_SHOW);
        Ocr_qps_err = new RpcErrorCode("Ocr_qps_err", 24, 1604);
        RpcErrorCode[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = EnumEntriesKt.enumEntries(r0);
        Companion = new a();
    }

    public static RpcErrorCode[] values() {
        return (RpcErrorCode[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final RpcErrorCode findByValue(int r1) {
        Companion.getClass();
        if (r1 == 0) goto L39;
        if (r1 == 1604) goto L64;
        if (r1 == 9999) goto L63;
        switch(r1) {
            case 1001: goto L43;
            case 1002: goto L42;
            case 1003: goto L41;
            default: goto L9;
        };
    L9:
        switch(r1) {
            case 2001: goto L47;
            case 2002: goto L46;
            case 2003: goto L45;
            case 2004: goto L44;
            default: goto L10;
        };
    L10:
        switch(r1) {
            case 3001: goto L50;
            case 3002: goto L49;
            case 3003: goto L48;
            default: goto L11;
        };
    L11:
        switch(r1) {
            case 4001: goto L53;
            case 4002: goto L52;
            case 4003: goto L51;
            default: goto L12;
        };
    L12:
        switch(r1) {
            case 9001: goto L62;
            case 9002: goto L61;
            case 9003: goto L60;
            case 9004: goto L59;
            case 9005: goto L58;
            case 9006: goto L57;
            case 9007: goto L56;
            case 9008: goto L55;
            case 9009: goto L54;
            default: goto L13;
        };
    L13:
        return null;
    L54:
        return Ocr_formula_recog_sd_err;
    L55:
        return Ocr_line_recog_sd_err;
    L56:
        return Ocr_formula_detect_sd_err;
    L57:
        return Ocr_line_detect_sd_err;
    L58:
        return Ocr_use_formularecog_err;
    L59:
        return Ocr_use_formuladetection_err;
    L60:
        return Ocr_use_linerecog_err;
    L61:
        return Ocr_use_linedetection_err;
    L62:
        return Ocr_req_err;
    L51:
        return FormulaRecog_bernard_err;
    L52:
        return FormulaRecog_proc_err;
    L53:
        return FormulaRecog_img_err;
    L48:
        return FormulaDetection_bernard_err;
    L49:
        return FormulaDetection_proc_err;
    L50:
        return FormulaDetection_img_err;
    L44:
        return LineRecog_resource_insufficient;
    L45:
        return LineRecog_bernard_err;
    L46:
        return LineRecog_proc_err;
    L47:
        return LineRecog_img_err;
    L41:
        return LineDetection_bernard_err;
    L42:
        return LineDetection_proc_err;
    L43:
        return LineDetection_img_err;
    L63:
        return Ocr_exec_err;
    L64:
        return Ocr_qps_err;
    L39:
        return Succeed;
    }

    public static RpcErrorCode valueOf(String r1) {
        return (RpcErrorCode) r27.a.a(RpcErrorCode.class, r1);
    }

    private RpcErrorCode(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
