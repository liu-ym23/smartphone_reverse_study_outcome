package hw0;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import w20.aa;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lhw0/i;", "Lw20/aa;", "", Constants.OperatorKey.CODE, "Ljava/lang/Number;", "getCode", "()Ljava/lang/Number;", "a", "(Ljava/lang/Number;)V", "", Constants.OperatorKey.MSG, "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "orderId", "getOrderId", "c", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class i implements aa {

    @SerializedName(Constants.OperatorKey.CODE)
    private Number code;

    @SerializedName(Constants.OperatorKey.MSG)
    private String msg;

    @SerializedName("orderId")
    private String orderId;

    public i() {
    }

    public final void a(Number r1) {
        this.code = r1;
    }

    public final void b(String r1) {
        this.msg = r1;
    }

    public final void c(String r1) {
        this.orderId = r1;
    }
}
