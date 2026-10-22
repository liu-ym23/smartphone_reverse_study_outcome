package com.ss.android.lark.monitor.traffic;

import com.facebook.battery.metrics.network.NetworkMetrics;
import com.facebook.battery.metrics.network.NetworkMetricsCollector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.MonitorModule;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l extends com.ss.android.lark.monitor.e {
    public final NetworkMetricsCollector a;
    public final ConcurrentHashMap<String, b> b;
    public int c;

    public class a implements os3.g {
        public a() {
        }

        public final void a(long r4, long r6, long r8, long r10, long r12) {
            Log.i("ScenePerfMonitor", "During Scene:" + MonitorModule.e().d() + ",Used totalTraffic:" + (r4 / 1024) + "kb,Mobile Traffic:" + r10 + r12 + ",Wifi Traffic:" + r8 + r6);
        }
    }

    public class b {
        public NetworkMetrics a;
        public NetworkMetrics b;
        public long c;
        public long d;

        public b() {
        }
    }

    @Override // com.ss.android.lark.monitor.d
    public final void onAppFrontStateChanged(boolean r1) {
    }

    public l(com.ss.android.lark.monitor.i r2) {
        super(r2);
        this.b = new ConcurrentHashMap();
        this.c = 0;
        this.a = new NetworkMetricsCollector(r2.a);
        ws3.k.y = new a();
    }

    @Override // com.ss.android.lark.monitor.e
    public final void pauseScene(String r9) {
        b r0 = this.b.get(r9);
        if (r0 != null) goto L5;
        return;
    L5:
        NetworkMetrics r1 = this.a.createMetrics();
        this.a.getSnapshot(r1);
        NetworkMetrics r2 = r1.diff(r0.a);
        if (r0.b != null) goto L8;
        r0.b = new NetworkMetrics();
    L8:
        NetworkMetrics r3 = r0.b;
        r3.sum(r2, r3);
        long r4 = (System.currentTimeMillis() - r0.c) / 1000;
        r0.d += r4;
        long r5 = (r2.mobileBytesRx + r2.mobileBytesTx) / 1024;
        long r6 = (r2.wifiBytesRx + r2.wifiBytesTx) / 10024;
        Log.i("ScenePerfMonitor", "Pause Scene:" + r9.split("#hash")[0] + ",Cost MobileTrafficKB:" + r5 + ", wifiTrafficKB: " + r6 + ", Span(S):" + r4);
    }

    @Override // com.ss.android.lark.monitor.e
    public final void startScene(String r4) {
        if (r4.contains("vc_meeting_onthecall") == false) goto L5;
    L6:
        this.c++;
    L7:
        b r0 = this.b.get(r4);
        NetworkMetrics r1 = this.a.createMetrics();
        if (this.a.getSnapshot(r1) == true) goto L10;
        return;
    L10:
        if (r0 != null) goto L12;
        r0 = new b();
        this.b.put(r4, r0);
    L12:
        r0.a = r1;
        r0.c = System.currentTimeMillis();
        return;
    L5:
        if (r4.contains("ByteRTCMeetingActivityInstance") == false) goto L7;
        goto L6
    }

    @Override // com.ss.android.lark.monitor.e
    public final void stopScene(String r21, JSONObject r22) {
        if (this.c == 0) goto L5;
        boolean r2 = true;
    L7:
        if (r21.contains("vc_meeting_onthecall") == false) goto L9;
    L10:
        this.c--;
    L11:
        String r3 = r21.split("#hash")[0];
        b r5 = this.b.remove(r21);
        if (r5 != null) goto L15;
        return;
    L15:
        if (r5.b != null) goto L17;
        NetworkMetrics r0 = this.a.createMetrics();
        this.a.getSnapshot(r0);
        r5.b = r0.diff(r5.a);
        r5.d = (System.currentTimeMillis() - r5.c) / 1000;
    L17:
        NetworkMetrics r1 = r5.b;
        long r6 = r1.mobileBytesRx;
        long r8 = r1.mobileBytesTx;
        long r10 = (r6 + r8) / 1024;
        long r14 = r1.wifiBytesRx;
        long r4 = r1.wifiBytesTx;
        long r7 = (r14 + r4) / 10024;
        long r9 = (r6 + r14) / 1024;
        long r11 = (r8 + r4) / 10024;
        Log.i("ScenePerfMonitor", "End Scene:" + r3 + ",Cost MobileTrafficKB:" + r10 + ", wifiTrafficKB: " + r7 + ", Span(S):" + r5.d);
        long r15 = r10 + r7;
        if (r15 >= 1024) goto L36;
        return;
    L36:
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L22
        r12.put("scene", r3);     // Catch: Exception -> L22
        r12.put("traffic", r15);     // Catch: Exception -> L22
        r12.put("traffic_mobile", r10);     // Catch: Exception -> L22
        r12.put("traffic_wifi", r7);     // Catch: Exception -> L22
        r12.put("traffic_rx", r9);     // Catch: Exception -> L22
        r12.put("traffic_tx", r11);     // Catch: Exception -> L22
        r12.put("span", r5.d);     // Catch: Exception -> L22
        isb.a.a(r12, r22);     // Catch: Exception -> L22
        isb.a.c("scene_traffic_info", r12);     // Catch: Exception -> L22
    L24:
        if (r2 == true) goto L26;
    L27:
        if (r2 == false) goto L29;
        return;
    L29:
        if (r10 <= 204800) goto L39;
    L30:
        StringBuilder r13 = new StringBuilder();
        r13.append(r3);
        r13.append(" cost ");
        r13.append(r10 / 1024);
        r13.append(" M mobile traffic ");
        if (r2 == false) goto L33;
        String r16 = " during vc";
    L34:
        r13.append(r16);
        r13.append(", time interval is(s) ");
        r13.append(r5.d);
        Log.e("Scene TrafficException", new Throwable(r13.toString()), true);
        return;
    L33:
        r16 = "";
        goto L34
    L39:
        return;
    L26:
        if (r10 > 307200) goto L30;
    L22:
        e = move-exception;
        Log.e("ScenePerfMonitor", "stopScene", e);
        goto L24
    L9:
        if (r21.contains("ByteRTCMeetingActivityInstance") == false) goto L11;
    L5:
        r2 = false;
        goto L7
    }
}
