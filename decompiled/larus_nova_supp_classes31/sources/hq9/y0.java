package hq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/larus/platform/model/DoraAudioConfig;", "", "<init>", "()V", "defaultStyleId", "", "getDefaultStyleId", "()Ljava/lang/String;", "setDefaultStyleId", "(Ljava/lang/String;)V", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class y0 {

    @SerializedName("style_id")
    private String defaultStyleId;

    public y0() {
        this.defaultStyleId = "zh_female_wenroutaozi_v2_mars_bigtts";
    }

    public final String a() {
        return this.defaultStyleId;
    }
}
