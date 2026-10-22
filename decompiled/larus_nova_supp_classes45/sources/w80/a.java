package w80;

import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class a {

    @SerializedName("age_larger_14")
    public int ageLargerFourteen;

    @SerializedName("api_request_params")
    public Map<String, String> apiRequestParams;

    @SerializedName("cert_token")
    public String certToken;

    @SerializedName("cert_type")
    public int certType;

    @SerializedName("children_cert_token")
    public String childrenCertToken;

    @SerializedName("merchant_id")
    public String merchantId;

    @SerializedName("msg")
    public String message;

    @SerializedName("status_code")
    public int statusCode;

    @SerializedName("ticket")
    public String ticket;

    @SerializedName("transaction_id")
    public String transactionId;

    @SerializedName(LiveSlardarConstants.EXTRA_KEY_URL)
    public String url;

    @SerializedName("verified_page_source")
    public String verifiedPageSource;

    @SerializedName("youth_cert_scene")
    public int youthCertScene;

    @SerializedName("zhima_token")
    public String zhimaToken;

    public a() {
    }
}
