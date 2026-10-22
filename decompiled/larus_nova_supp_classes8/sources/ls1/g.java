package ls1;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b(\u0010)R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\"\u0010\u0017\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\f\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lls1/g;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "firstRoomRefreshEnable", "", "firstRoomDurationThreshold", "J", "b", "()J", "setFirstRoomDurationThreshold", "(J)V", "refreshInterval", "f", "setRefreshInterval", "timerRefreshEnable", "g", "setTimerRefreshEnable", "timerRefreshInterval", "h", "setTimerRefreshInterval", "", "maxRefreshCount", "I", "e", "()I", "setMaxRefreshCount", "(I)V", "", "limitTimeList", "Ljava/util/List;", "d", "()Ljava/util/List;", "setLimitTimeList", "(Ljava/util/List;)V", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("first_room_duration_threshold")
    private long firstRoomDurationThreshold;

    @SerializedName("first_room_refresh_enable")
    private boolean firstRoomRefreshEnable;

    @SerializedName("limit_time_list")
    private List<Integer> limitTimeList;

    @SerializedName("max_refresh_count")
    private int maxRefreshCount;

    @SerializedName("refresh_interval")
    private long refreshInterval;

    @SerializedName("timer_refresh_enable")
    private boolean timerRefreshEnable;

    @SerializedName("timer_refresh_interval")
    private long timerRefreshInterval;

    public final boolean c() {
        if (this.enable == true) goto L5;
    L7:
        return false;
    L5:
        if (this.firstRoomRefreshEnable == false) goto L7;
        return true;
    }

    public g() {
        this.firstRoomDurationThreshold = 30000;
        this.refreshInterval = 180000;
        this.timerRefreshInterval = 300000;
        this.maxRefreshCount = 2;
    }

    public final boolean a() {
        return this.enable;
    }

    public final long b() {
        return this.firstRoomDurationThreshold;
    }

    public final List<Integer> d() {
        return this.limitTimeList;
    }

    public final int e() {
        return this.maxRefreshCount;
    }

    public final long f() {
        return this.refreshInterval;
    }

    public final boolean g() {
        return this.timerRefreshEnable;
    }

    public final long h() {
        return this.timerRefreshInterval;
    }
}
