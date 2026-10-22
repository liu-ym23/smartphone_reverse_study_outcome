package w20;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lw20/e8;", "", "", "feedback", "Ljava/lang/Integer;", "a", "()Ljava/lang/Integer;", "d", "(Ljava/lang/Integer;)V", "", "action", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "toast_info", "b", "e", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e8 {

    @SerializedName("action")
    private String action;

    @SerializedName("feedback")
    private Integer feedback;

    @SerializedName("toast_info")
    private String toast_info;

    public e8() {
    }

    public final Integer a() {
        return this.feedback;
    }

    public final String b() {
        return this.toast_info;
    }

    public final void c(String r1) {
        this.action = r1;
    }

    public final void d(Integer r1) {
        this.feedback = r1;
    }

    public final void e(String r1) {
        this.toast_info = r1;
    }
}
