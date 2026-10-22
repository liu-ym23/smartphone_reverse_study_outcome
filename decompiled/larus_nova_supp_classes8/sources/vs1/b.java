package vs1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\t\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\f\u001a\u00020\u000b8\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006¨\u0006\u0014"}, d2 = {"Lvs1/b;", "", "", "enableLivePBDecoder", "Z", "a", "()Z", "addHostPBDecoder", "getAddHostPBDecoder", "reportPBDecodeErrorCode", "getReportPBDecodeErrorCode", "", "errorMessageMaxCount", "I", "getErrorMessageMaxCount", "()I", "enableReconnectAfterLoginChange", "getEnableReconnectAfterLoginChange", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("add_host_pb_decoder")
    private final boolean addHostPBDecoder;

    @SerializedName("enable_live_pb_decoder")
    private final boolean enableLivePBDecoder;

    @SerializedName("enable_reconnect_after_login_change")
    private final boolean enableReconnectAfterLoginChange;

    @SerializedName("error_message_max_count")
    private final int errorMessageMaxCount;

    @SerializedName("report_pb_decoder_error_code")
    private final boolean reportPBDecodeErrorCode;

    public b() {
        this.enableLivePBDecoder = true;
        this.reportPBDecodeErrorCode = true;
        this.errorMessageMaxCount = 15;
        this.enableReconnectAfterLoginChange = true;
    }

    public final boolean a() {
        return this.enableLivePBDecoder;
    }
}
