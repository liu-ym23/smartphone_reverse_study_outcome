package mq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0002X\u0083\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\t\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/larus/platform/model/avatar/RecordResultInfoConfigV2;", "", "successTitle", "", "noFaceErrorTitle", "werFailErrorTitle", "werFailErrorDes", "angleErrorTitle", "defaultErrorTitle", "defaultErrorDes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "successTitleKey", "noFaceErrorTitleKey", "werFailErrorTitleKey", "werFailErrorDesKey", "angleErrorTitleKey", "defaultErrorTitleKey", "defaultErrorDesKey", "getSuccessTitle", "()Ljava/lang/String;", "getNoFaceErrorTitle", "getWerFailErrorTitle", "getWerFailErrorDes", "getAngleErrorTitle", "getDefaultErrorTitle", "getDefaultErrorDes", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class k {

    @SerializedName("angle_error_title")
    private final String angleErrorTitleKey;

    @SerializedName("default_error_des")
    private final String defaultErrorDesKey;

    @SerializedName("default_error_title")
    private final String defaultErrorTitleKey;

    @SerializedName("no_face_error_title")
    private final String noFaceErrorTitleKey;

    @SerializedName("success_title")
    private final String successTitleKey;

    @SerializedName("wer_fail_error_des")
    private final String werFailErrorDesKey;

    @SerializedName("wer_fail_error_title")
    private final String werFailErrorTitleKey;

    public k() {
        this(null, null, null, null, null, null, null);
    }

    public final String a() {
        return e.a(this.successTitleKey);
    }

    public final String b() {
        return e.a(this.werFailErrorDesKey);
    }

    public final String c() {
        return e.a(this.werFailErrorTitleKey);
    }

    public k(String r1, String r2, String r3, String r4, String r5, String r6, String r7) {
        this.successTitleKey = r1;
        this.noFaceErrorTitleKey = r2;
        this.werFailErrorTitleKey = r3;
        this.werFailErrorDesKey = r4;
        this.angleErrorTitleKey = r5;
        this.defaultErrorTitleKey = r6;
        this.defaultErrorDesKey = r7;
    }
}
