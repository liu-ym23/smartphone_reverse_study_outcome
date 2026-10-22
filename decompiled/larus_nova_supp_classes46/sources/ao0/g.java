package ao0;

import com.bytedance.android.livehostapi.foundation.IHostApp;
import com.bytedance.android.livehostapi.foundation.depend.ITTNetNQEConfigHelper;
import com.bytedance.android.livesdk.config.md0;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.NetworkQuality;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.PacketLossMetrics;
import com.bytedance.ttnet.TTNetInit;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import jc1.k;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g {
    public static final Boolean a = null;

    static {
        a = (Boolean) md0.a.getValue();
    }

    @JvmStatic
    public static final JSONObject a() {
        LinkedHashMap r0 = new LinkedHashMap();
        NetworkQuality r1 = TTNetInit.getNetworkQuality();     // Catch: Exception -> L33
        r0.put("http_rtt", Integer.valueOf(r1.httpRttMs));     // Catch: Exception -> L33
        r0.put("tcp_rtt", Integer.valueOf(r1.transportRttMs));     // Catch: Exception -> L33
        r0.put("quic_rtt", Integer.valueOf(r1.transportRttMs));     // Catch: Exception -> L33
        r0.put("downstream_throughput_kbps", Integer.valueOf(r1.downstreamThroughputKbps));     // Catch: Exception -> L33
        if (a.booleanValue() == false) goto L12;
        PacketLossMetrics r2 = TTNetInit.getPacketLossRateMetrics(1);     // Catch: Exception -> L33
        r0.put("quic_send_loss_rate", Double.valueOf(r2.upstreamLossRate));     // Catch: Exception -> L33
        r0.put("quic_receive_loss_rate", Double.valueOf(r2.downstreamLossRate));     // Catch: Exception -> L33
        r0.put("net_effective_connection_type", Integer.valueOf(TTNetInit.getEffectiveConnectionType()));     // Catch: Exception -> L33
        IHostApp r3 = k.f(IHostApp.class);     // Catch: Exception -> L33
        if (r3 == null) goto L10;
        ITTNetNQEConfigHelper r4 = r3.getTTNetNQEConfigHelper();     // Catch: Exception -> L33
        if (r4 == null) goto L10;
        int r5 = r4.getAverageSpeedInKBps();     // Catch: Exception -> L33
    L11:
        r0.put("video_download_speed", Integer.valueOf(r5));     // Catch: Exception -> L33
    L36:
        return new JSONObject(r0);
    L10:
        r5 = -1;
        goto L11
    L12:
        IHostApp r6 = k.f(IHostApp.class);     // Catch: Exception -> L33
        Map r7 = null;
        if (r6 == null) goto L29;
        Map r8 = r6.getNQEParams();     // Catch: Exception -> L33
        if (r8 == null) goto L29;
        LinkedHashMap r9 = new LinkedHashMap(MapsKt.mapCapacity(r8.size()));     // Catch: Exception -> L33
        Iterator r10 = r8.entrySet().iterator();     // Catch: Exception -> L33
    L18:
        if (r10.hasNext() == false) goto L28;
        Object r11 = r10.next();     // Catch: Exception -> L33
        Object r12 = ((Map.Entry) r11).getKey();     // Catch: Exception -> L33
        Map.Entry r13 = (Map.Entry) r11;     // Catch: Exception -> L33
        Object r14 = StringsKt.toIntOrNull((String) r13.getValue());     // Catch: Exception -> L33
        if (r14 != null) goto L25;
        String r15 = (String) r13.getValue();     // Catch: Exception -> L33
        if (r15 == null) goto L24;
        r14 = StringsKt.toDoubleOrNull(r15);     // Catch: Exception -> L33
        goto L25
    L24:
        r14 = null;
    L25:
        if (r14 != null) goto L27;
        r14 = r13.getValue();     // Catch: Exception -> L33
    L27:
        r9.put(r12, r14);     // Catch: Exception -> L33
        goto L18
    L28:
        r7 = r9;
    L29:
        if (r7 != null) goto L31;
        r7 = MapsKt.emptyMap();     // Catch: Exception -> L33
    L31:
        r0.putAll(r7);     // Catch: Exception -> L33
    L33:
        e = move-exception;
        e.printStackTrace();
        goto L36
    }
}
