package vs1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087D¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lvs1/a;", "", "", "enableBytelink", "Z", "a", "()Z", "", "serverLimitMaxFetchIntervalMs", "J", "getServerLimitMaxFetchIntervalMs", "()J", "enableHttpFetchDuringWSConnecting", "getEnableHttpFetchDuringWSConnecting", "enableDirectHttpUpdatePublisherOnWSDisconnected", "getEnableDirectHttpUpdatePublisherOnWSDisconnected", "enableDirectConnectWSOnWSDisconnected", "getEnableDirectConnectWSOnWSDisconnected", "enableDelayConnectWSOnWSDisconnected", "getEnableDelayConnectWSOnWSDisconnected", "enablePersistCursor", "b", "", "persistCursorSaveInterval", "I", "getPersistCursorSaveInterval", "()I", "<init>", "()V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("enable_bytelink")
    private final boolean enableBytelink;

    @SerializedName("enable_delay_connect_ws_on_ws_disconnected")
    private final boolean enableDelayConnectWSOnWSDisconnected;

    @SerializedName("enable_direct_connect_ws_on_ws_disconnected")
    private final boolean enableDirectConnectWSOnWSDisconnected;

    @SerializedName("enable_direct_http_update_publisher_on_ws_disconnected")
    private final boolean enableDirectHttpUpdatePublisherOnWSDisconnected;

    @SerializedName("enable_http_fetch_during_ws_connecting")
    private final boolean enableHttpFetchDuringWSConnecting;

    @SerializedName("enable_persist_cursor")
    private final boolean enablePersistCursor;

    @SerializedName("time_for_save_persist_cursor")
    private final int persistCursorSaveInterval;

    @SerializedName("server_limit_max_fetch_interval_ms")
    private final long serverLimitMaxFetchIntervalMs;

    public a() {
        this.serverLimitMaxFetchIntervalMs = 80000;
        this.enableDirectConnectWSOnWSDisconnected = true;
        this.enableDelayConnectWSOnWSDisconnected = true;
        this.enablePersistCursor = true;
        this.persistCursorSaveInterval = 3;
    }

    public final boolean a() {
        return this.enableBytelink;
    }

    public final boolean b() {
        return this.enablePersistCursor;
    }
}
