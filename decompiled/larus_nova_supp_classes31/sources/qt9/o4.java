package qt9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/settings/provider/TimeFetchLatestSettingOnLibraVersionSwitchedConfig;", "", "<init>", "()V", "enable", "", "getEnable", "()Z", "fetchTimeCount", "", "getFetchTimeCount", "()I", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class o4 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("fetch_time_count")
    private final int fetchTimeCount;

    public o4() {
        this.fetchTimeCount = 60;
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.fetchTimeCount;
    }
}
