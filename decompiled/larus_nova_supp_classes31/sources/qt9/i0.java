package qt9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/larus/settings/provider/CreationCanvasClientConfig;", "", "<init>", "()V", "generateTimeoutMs", "", "Ljava/lang/Long;", "streamPullRetryCount", "", "Ljava/lang/Integer;", "streamPullChunkTimeoutMs", "streamPullConnectTimeoutMs", "streamPullIntervalTimeoutMs", "streamPullWriteTimeoutMs", "streamPullProtectTimeoutMs", "maxGenerateCountPerRound", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class i0 {

    @SerializedName("generate_timeout_ms")
    public final Long generateTimeoutMs;

    @SerializedName("max_generate_count_per_round")
    public final Integer maxGenerateCountPerRound;

    @SerializedName("stream_pull_chunk_timeout_ms")
    public final Long streamPullChunkTimeoutMs;

    @SerializedName("stream_pull_connect_timeout_ms")
    public final Long streamPullConnectTimeoutMs;

    @SerializedName("stream_pull_interval_timeout_ms")
    public final Long streamPullIntervalTimeoutMs;

    @SerializedName("stream_pull_protect_timeout_ms")
    public final Long streamPullProtectTimeoutMs;

    @SerializedName("stream_pull_retry_count")
    public final Integer streamPullRetryCount;

    @SerializedName("stream_pull_write_timeout_ms")
    public final Long streamPullWriteTimeoutMs;

    public i0() {
        this.generateTimeoutMs = 60000L;
        this.streamPullRetryCount = 10;
        this.streamPullChunkTimeoutMs = 60000L;
        this.streamPullConnectTimeoutMs = 60000L;
        this.streamPullIntervalTimeoutMs = 60000L;
        this.streamPullWriteTimeoutMs = 60000L;
        this.streamPullProtectTimeoutMs = 180000L;
        this.maxGenerateCountPerRound = 20;
    }
}
