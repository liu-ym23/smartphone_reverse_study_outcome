package a1c;

import com.larksuite.framework.utils.LogSafetyTools;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.LarkMetrics;
import com.ss.android.lark.monitor.traffic.j;
import com.ss.android.lark.statistics.Statistics;
import com.ss.ttvideoengine.DataLoaderHelper;
import com.ss.ttvideoengine.DataLoaderListener;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.utils.DataLoaderCDNLog;
import com.ss.ttvideoengine.utils.Error;
import java.util.HashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a implements DataLoaderListener {

    /* JADX INFO: renamed from: a1c.a$a, reason: collision with other inner class name */
    public static final class C0000a {
    }

    static {
    }

    public a() {
    }

    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "null", imports = {}))
    public final String apiStringForFetchVideoModel(Map<String, String> r1, String r2, Resolution r3) {
        return null;
    }

    @Deprecated(message = "Deprecated in Java", replaceWith = @ReplaceWith(expression = "null", imports = {}))
    public final String authStringForFetchVideoModel(String r1, Resolution r2) {
        return null;
    }

    public final String getCheckSumInfo(String r1) {
        return null;
    }

    public final HashMap<String, String> getCustomHttpHeaders(String r1) {
        return null;
    }

    public final boolean loadLibrary(String r1) {
        return false;
    }

    public final void onLoadProgress(DataLoaderHelper.DataLoaderTaskLoadProgress r1) {
    }

    public final /* synthetic */ void onMultiNetworkSwitch(String r1, String r2) {
        DataLoaderListener.-CC.$default$onMultiNetworkSwitch(this, r1, r2);
    }

    public final void onNotifyCDNLog(DataLoaderCDNLog r1) {
    }

    public final void onNotifyCDNLog(JSONObject r1) {
    }

    public final /* synthetic */ void onStartComplete() {
        DataLoaderListener.-CC.$default$onStartComplete(this);
    }

    public final void onTaskProgress(DataLoaderHelper.DataLoaderTaskProgressInfo r1) {
    }

    public final void dataLoaderError(String r3, int r4, Error r5) {
        Intrinsics.checkNotNullParameter(r3, "videoId");
        Intrinsics.checkNotNullParameter(r5, "error");
        Log.e("LarkDataLoaderListener", "dataLoaderError, videoId: " + r3 + ", errorType: " + r4 + ", error: " + r5);
    }

    public final void onLogInfo(int r4, String r5, JSONObject r6) {
        Intrinsics.checkNotNullParameter(r5, "logType");
        Intrinsics.checkNotNullParameter(r6, "log");
        Log.e("LarkDataLoaderListener", "onLogInfo, what:" + r4 + ", logType:" + r5 + ", log:" + LogSafetyTools.a(r6.toString()));
        Statistics.recordMiscLog(r5, r6);
    }

    public final void onLogInfoToMonitor(int r4, String r5, JSONObject r6) {
        Log.e("LarkDataLoaderListener", "onLogInfoToMonitor, what:" + r4 + ", logType:" + r5 + ", log:" + LogSafetyTools.a(String.valueOf(r6)));
        Statistics.recordMiscLog(r5, r6);
    }

    public final void onNotify(int r1, long r2, long r4, String r6) {
        if (r1 != 2) goto L8;
        j r3 = LarkMetrics.a.a.f;
        if (r3 == null) goto L9;
        r3.c(r2, r6);
        return;
    L9:
        return;
    }
}
