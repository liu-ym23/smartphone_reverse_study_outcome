package h64;

import android.app.Application;
import android.os.SystemClock;
import com.bytedance.awemeopen.servicesapi.context.AoHostService;
import com.bytedance.awemeopen.servicesapi.device.AoBpeaDeviceInfoService;
import com.bytedance.awemeopen.servicesapi.log.AoLogService;
import com.bytedance.awemeopen.servicesapi.network.AoNetworkMetric;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.NetworkQuality;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.ttnet.TTNetInit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    static {
    }

    @JvmStatic
    public static final List<Header> a(q64.c r4) {
        Intrinsics.checkNotNullParameter(r4, "bdpHeaders");
        ArrayList r0 = new ArrayList();
        Iterator<T> r5 = r4.a.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        q64.c.C0256c r1 = (q64.c.C0256c) r5.next();
        r0.add(new Header(r1.a, r1.b));
        goto L4
    L6:
        return r0;
    }

    @JvmStatic
    public static final q64.c b(List<Header> r4) {
        ArrayList r0 = new ArrayList();
        if (r4 == null) goto L12;
        Iterator<T> r5 = r4.iterator();
    L6:
        if (r5.hasNext() == false) goto L12;
        Header r1 = (Header) r5.next();
        String r2 = r1.getName();
        String r3 = r1.getValue();
        if (r2 == null) goto L6;
        if (r3 == null) goto L6;
        Intrinsics.checkNotNullParameter(r2, "key");
        Intrinsics.checkNotNullParameter(r3, "value");
        r0.add(new q64.c.C0256c(r2, r3));
    L12:
        return new q64.c(r0);
    }

    @JvmStatic
    public static final AoNetworkMetric c(BaseHttpRequestInfo<?> r29, RetrofitMetrics r30) {
        Intrinsics.checkNotNullParameter(r29, "requestInfo");
        AoHostService r2 = j64.a.a(AoHostService.class);
        Intrinsics.checkNotNull(r2);
        Application r3 = r2.getHostApplication();
        long r4 = SystemClock.elapsedRealtime();
        AoBpeaDeviceInfoService r5 = j64.a.a(AoBpeaDeviceInfoService.class);
        Intrinsics.checkNotNull(r5);
        String r6 = r5.o0(r3);
        long r7 = r29.requestStart;
        Long r8 = null;
        if (r7 > 0) goto L14;
        if (r30 == null) goto L7;
        Long r9 = Long.valueOf(r30.executeCallStartTime);
    L8:
        if (r9 != null) goto L10;
        Long r10 = null;
    L11:
        if (r10 == null) goto L13;
        r7 = r10.longValue();
        goto L14
    L13:
        r7 = 0;
        goto L14
    L10:
        r10 = Long.valueOf((r9.longValue() + System.currentTimeMillis()) - SystemClock.uptimeMillis());
        goto L11
    L7:
        r9 = null;
    L14:
        long r11 = r29.requestEnd;
        if (r11 > 0) goto L26;
        if (r30 == null) goto L19;
        Long r0 = Long.valueOf(r30.executeCallEndTime);
    L20:
        if (r0 == null) goto L23;
        r8 = Long.valueOf((r0.longValue() + System.currentTimeMillis()) - SystemClock.uptimeMillis());
    L23:
        if (r8 == null) goto L25;
        r11 = r8.longValue();
        goto L26
    L25:
        r11 = 0;
        goto L26
    L19:
        r0 = null;
    L26:
        long r12 = r29.totalTime;
        if (r12 > 0) goto L30;
        r12 = r11 - r7;
    L30:
        long r14 = r29.nativeRequestStartTime;
        long r13 = Math.max(r29.dnsTime, 0) + r14;
        long r15 = Math.max(r29.connectTime, 0) + r13;
        long r20 = r11;
        long r16 = Math.max(r13, r15 - Math.max(r29.sslTime, 0));
        JSONObject r1 = new JSONObject(r29.requestLog).optJSONObject("response");     // Catch: Exception -> L35
        if (r1 == null) goto L39;
        int r17 = r1.optInt("connection_info");     // Catch: Exception -> L35
    L40:
        switch(r17) {
            case 1: goto L52;
            case 2: goto L51;
            case 3: goto L51;
            case 4: goto L50;
            case 5: goto L42;
            case 6: goto L50;
            case 7: goto L50;
            case 8: goto L49;
            case 9: goto L48;
            default: goto L42;
        };
    L48:
        String r18 = "http/1.0";
    L83:
        NetworkQuality r19 = TTNetInit.getNetworkQuality();     // Catch: Exception -> L60
    L62:
        if (r29.remoteIp.length() <= 0) goto L64;
        boolean r110 = true;
    L65:
        if (r110 == false) goto L67;
        String r111 = r29.remoteIp;
    L68:
        NetworkQuality r28 = r19;
        int r112 = StringsKt.lastIndexOf$default(r111, ":", 0, false, 6, null);
        if (r112 < 0) goto L71;
        String r21 = r111.substring(0, r112);
    L72:
        if (r112 < 0) goto L78;
        int r113 = r112 + 1;
        String r23 = r21;
        if (r113 < r111.length()) goto L85;
    L79:
        int r22 = 0;
    L80:
        AoNetworkMetric r114 = new AoNetworkMetric();
        r114.g = (int) r12;
        r114.i = r7;
        r114.j = r20;
        r114.a = (int) r29.dnsTime;
        r114.c = (int) r29.sslTime;
        r114.b = (int) r29.connectTime;
        r114.d = (int) r29.sendTime;
        r114.e = (int) r29.ttfbMs;
        long r24 = r29.receiveTime;
        r114.f = (int) r24;
        r114.k = r14;
        r114.l = r13;
        r114.m = r13;
        r114.n = r15;
        r114.o = r16;
        r114.p = r15;
        long r25 = r29.responseBack;
        r114.q = r25;
        r114.r = r25 + r24;
        r114.u = r6;
        r114.s = r29.sentByteCount;
        r114.t = r29.receivedByteCount;
        r114.A = r29.httpClientType;
        r114.h = r29.isSocketReused;
        r114.v = r18;
        r114.y = r28.httpRttMs;
        r114.z = r28.downstreamThroughputKbps;
        r114.w = r23;
        r114.x = r22;
        r114.B = (int) (SystemClock.elapsedRealtime() - r4);
        return r114;
    L85:
        r22 = CastIntegerProtector.parseInt(r111.substring(r113));     // Catch: Exception -> L82
    L78:
        r23 = r21;
        goto L79
    L71:
        r21 = r111;
        goto L72
    L67:
        r111 = r29.reqContext.remoteIp;
        goto L68
    L64:
        r110 = false;
    L60:
        r19 = new NetworkQuality();
        goto L62
    L49:
        r18 = "http/0.9";
        goto L83
    L50:
        r18 = "h2";
        goto L83
    L51:
        r18 = "spdy";
        goto L83
    L52:
        r18 = "http/1.1";
        goto L83
    L42:
        if (r17 != 5) goto L44;
    L57:
        r18 = "quic";
        goto L83
    L44:
        if (10 <= r17) goto L46;
    L53:
        boolean r26 = false;
    L54:
        if (r26 == true) goto L57;
        r18 = "unknown";
        goto L83
    L46:
        if (r17 >= 28) goto L53;
        r26 = true;
    L39:
        r17 = 0;
    L35:
        e = move-exception;
        AoLogService r115 = j64.a.a(AoLogService.class);
        if (r115 == null) goto L39;
        r115.e("BdpTTNetHelper", e.getMessage());
        goto L39
    }
}
