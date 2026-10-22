package b30;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lb30/g0;", "", "", "transactionId", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setTransactionId", "(Ljava/lang/String;)V", LiveSlardarConstants.EXTRA_KEY_URL, "b", "setUrl", "zhimaToken", "c", "setZhimaToken", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g0 {

    @SerializedName("transactionId")
    private String transactionId;

    @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
    private String url;

    @SerializedName("zhimaToken")
    private String zhimaToken;

    public g0() {
    }

    public final String a() {
        return this.transactionId;
    }

    public final String b() {
        return this.url;
    }

    public final String c() {
        return this.zhimaToken;
    }
}
