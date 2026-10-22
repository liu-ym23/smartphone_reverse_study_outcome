package rc;

import com.bytedance.android.ec.core.utils.FontWeight;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.lazydata.LazyData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R(\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u000b\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000f¨\u0006&"}, d2 = {"Lrc/c;", "", "", "isEnable", "Z", "()Z", "setEnable", "(Z)V", "", "", "alogMonitorEvents", "Ljava/util/List;", "getAlogMonitorEvents", "()Ljava/util/List;", "setAlogMonitorEvents", "(Ljava/util/List;)V", "", "maxDiffCount", "I", "getMaxDiffCount", "()I", "setMaxDiffCount", "(I)V", "recordAlogTime", "getRecordAlogTime", "setRecordAlogTime", "", "loopTime", "J", "getLoopTime", "()J", "setLoopTime", "(J)V", "allMonitorPage", "getAllMonitorPage", "setAllMonitorPage", "<init>", "()V", "api_cnRelease"}, k = 1, mv = {1, 4, 0})
@LazyData
public final class c {

    @SerializedName("all_monitor_page")
    private List<String> allMonitorPage;

    @SerializedName("monitor_event")
    private List<String> alogMonitorEvents;

    @SerializedName("enable")
    private boolean isEnable;

    @SerializedName("loop_time")
    private long loopTime;

    @SerializedName("max_diff_count")
    private int maxDiffCount;

    @SerializedName("record_alog_time")
    private int recordAlogTime;

    public c() {
        this.alogMonitorEvents = new ArrayList();
        this.maxDiffCount = 2;
        this.recordAlogTime = FontWeight.WEIGHT_300;
        this.loopTime = 300;
        this.allMonitorPage = new ArrayList();
    }
}
