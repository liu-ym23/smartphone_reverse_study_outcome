package pg;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u0004\u001a\u0004\b\u000e\u0010\u0006R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0010\u0010\f¨\u0006\u0013"}, d2 = {"Lpg/b;", "", "", "enableApplogUpload", "I", "getEnableApplogUpload", "()I", "", "", "applogEnabledFeatures", "Ljava/util/List;", "getApplogEnabledFeatures", "()Ljava/util/List;", "enableServerUpload", "getEnableServerUpload", "serverEnabledFeatures", "getServerEnabledFeatures", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("applog_enabled_features")
    private final List<String> applogEnabledFeatures;

    @SerializedName("enable_applog_upload")
    private final int enableApplogUpload;

    @SerializedName("enable_server_upload")
    private final int enableServerUpload;

    @SerializedName("server_enabled_features")
    private final List<String> serverEnabledFeatures;

    public b() {
        this.applogEnabledFeatures = CollectionsKt.emptyList();
        this.serverEnabledFeatures = CollectionsKt.emptyList();
    }
}
