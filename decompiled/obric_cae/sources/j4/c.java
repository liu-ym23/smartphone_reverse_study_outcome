package j4;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import c4.m;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.common.wschannel.WsConstants;
import i4.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Handler.Callback {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final List<String> f8604p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f8606b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ConcurrentHashMap f8607m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SharedPreferences f8608n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final i4.c f8609o;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f8611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f8612c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f8613d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f8614e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f8615f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f8616g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f8617h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final long f8618i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final JSONObject f8619j;

        public a(String r8, String r10, long r11, boolean r12, int r13, int r14, long r15, String r16, long r17, JSONObject r18) {
            this.f8610a = r8;
            this.f8611b = r10;
            this.f8612c = r11;
            this.f8613d = r12;
            this.f8614e = r13;
            this.f8615f = r14;
            this.f8616g = r15;
            this.f8617h = r16;
            this.f8618i = r17;
            this.f8619j = r18;
        }

        public static a a(String r23) {
            if (TextUtils.isEmpty(r23) == false) goto L10;
            return null;
        L10:
            JSONObject r8 = new JSONObject(r23);     // Catch: Throwable -> L7
            return new a(r8.optString("request_id"), r8.optString(WsConstants.KEY_CONNECTION_URL), r8.optLong("req_body_length"), r8.optBoolean(LocationMonitorConst.IS_SUCCESS), r8.optInt("status_code"), r8.optInt("error_code"), r8.optLong("resp_body_length"), r8.optString("message"), r8.optLong("duration"), r8.optJSONObject("extras"));
        L7:
            th = move-exception;
            m.u().m(8, c.f8604p, "NetworkInfo fromJson failed", th, new Object[0]);
            return null;
        }

        public final JSONObject b() {
            JSONObject r8 = new JSONObject();
            r8.put("request_id", this.f8610a);     // Catch: Throwable -> L10
            r8.put(WsConstants.KEY_CONNECTION_URL, this.f8611b);     // Catch: Throwable -> L10
            r8.put("req_body_length", this.f8612c);     // Catch: Throwable -> L10
            r8.put(LocationMonitorConst.IS_SUCCESS, this.f8613d);     // Catch: Throwable -> L10
            r8.put("status_code", this.f8614e);     // Catch: Throwable -> L10
            r8.put("error_code", this.f8615f);     // Catch: Throwable -> L10
            r8.put("resp_body_length", this.f8616g);     // Catch: Throwable -> L10
            r8.put("message", this.f8617h);     // Catch: Throwable -> L10
            r8.put("duration", this.f8618i);     // Catch: Throwable -> L10
            JSONObject r10 = this.f8619j;
            if (r10 != null) goto L7;
        L12:
            return r8;
        L7:
            if (r10.length() <= 0) goto L12;
            r8.put("extras", r10);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            m.u().m(8, c.f8604p, "NetworkInfo toJson failed", th, new Object[0]);
            goto L12
        }
    }

    static {
        f8604p = Collections.singletonList("NetworkMonitor");
    }

    public c(i4.c r8) {
        this.f8605a = false;
        this.f8607m = new ConcurrentHashMap();
        this.f8609o = r8;
    }

    public static void a(Map r8, JSONArray r10) {
        if (r8.isEmpty() == false) goto L15;
        return;
    L15:
        Iterator r11 = r8.entrySet().iterator();     // Catch: Throwable -> L12
    L7:
        if (r11.hasNext() == false) goto L22;
        a r12 = (a) ((Map.Entry) r11.next()).getValue();     // Catch: Throwable -> L12
        if (r12 == null) goto L7;
        JSONObject r13 = new JSONObject();     // Catch: Throwable -> L12
        r13.put("event", "sdk_network");     // Catch: Throwable -> L12
        r13.put("params", r12.b());     // Catch: Throwable -> L12
        r13.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L12
        r13.put("event_id", h.f8232b.incrementAndGet());     // Catch: Throwable -> L12
        r13.put("datetime", h.a());     // Catch: Throwable -> L12
        r10.put(r13);     // Catch: Throwable -> L12
        goto L7
    L22:
        return;
    L12:
        th = move-exception;
        m.u().m(8, f8604p, "appendMapToJSONArray failed", th, new Object[0]);
    }

    public final Pair<Map<String, a>, Long> b(long r10) {
        if (this.f8607m.isEmpty() == true) goto L5;
        HashMap r8 = new HashMap();
        ConcurrentHashMap r11 = this.f8607m;
        monitor-enter(r11);
        Iterator r12 = this.f8607m.entrySet().iterator();     // Catch: Throwable -> L21
    L10:
        if (r12.hasNext() == false) goto L18;
        Map.Entry r13 = (Map.Entry) r12.next();     // Catch: Throwable -> L21
        String r14 = (String) r13.getKey();     // Catch: Throwable -> L21
        a r15 = (a) r13.getValue();     // Catch: Throwable -> L21
        if (r15 == null) goto L10;
        int r16 = r15.f8610a.length();     // Catch: Throwable -> L21
        int r17 = r15.f8611b.length() + r16;     // Catch: Throwable -> L21
        r10 = r10 - (((long) (r15.f8617h.length() + r17)) + 200);     // Catch: Throwable -> L21
        if (r10 <= 0) goto L18;
        r8.put(r14, r15);     // Catch: Throwable -> L21
    L18:
        monitor-exit(r11);     // Catch: Throwable -> L21
        return new Pair(r8, Long.valueOf(r10));
    L21:
        th = move-exception;
        throw th;
    L5:
        return new Pair(null, Long.valueOf(r10));
    }

    public final void c(Map<String, a> r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isEmpty() == true) goto L22;
        ConcurrentHashMap r10 = this.f8607m;
        monitor-enter(r10);
        Iterator<Map.Entry<String, a>> r11 = r8.entrySet().iterator();     // Catch: Throwable -> L15
    L10:
        if (r11.hasNext() == false) goto L12;
        String r12 = r11.next().getKey();     // Catch: Throwable -> L15
        this.f8607m.remove(r12);     // Catch: Throwable -> L15
        goto L10
    L12:
        monitor-exit(r10);     // Catch: Throwable -> L15
        this.f8606b.removeMessages(8);
        this.f8606b.sendEmptyMessageDelayed(8, 500);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r8) {
        int r10 = r8.what;
        if (r10 != 8) goto L5;
        SharedPreferences.Editor r11 = this.f8608n.edit();
        ConcurrentHashMap r12 = this.f8607m;
        monitor-enter(r12);
    L51:
        th = move-exception;
        throw th;
    L41:
        if (this.f8607m.size() <= 1000) goto L43;
        r11.clear();     // Catch: Throwable -> L51
        this.f8607m.clear();     // Catch: Throwable -> L51
    L43:
        Iterator r13 = this.f8607m.entrySet().iterator();     // Catch: Throwable -> L51
    L45:
        if (r13.hasNext() == false) goto L47;
        Map.Entry r14 = (Map.Entry) r13.next();     // Catch: Throwable -> L51
        r11.putString((String) r14.getKey(), ((a) r14.getValue()).b().toString());     // Catch: Throwable -> L51
        goto L45
    L47:
        monitor-exit(r12);     // Catch: Throwable -> L51
        r11.apply();
        return false;
    L5:
        if (r10 != 16) goto L7;
        a r15 = (a) r8.obj;
        this.f8607m.put(r15.f8610a, r15);
        Handler r16 = this.f8606b;
        if (r16 == null) goto L71;
        r16.removeMessages(8);
        this.f8606b.sendEmptyMessageDelayed(8, 500);
        return false;
    L71:
        return false;
    L7:
        if (r10 != 24) goto L73;
        SharedPreferences r17 = this.f8608n;
        if (r17 == null) goto L74;
        Map<String, ?> r18 = r17.getAll();
        if (r18.isEmpty() == true) goto L75;
        ConcurrentHashMap r19 = this.f8607m;
        monitor-enter(r19);
        Iterator<Map.Entry<String, ?>> r20 = r18.entrySet().iterator();     // Catch: Throwable -> L32
    L19:
        if (r20.hasNext() == false) goto L28;
        Map.Entry<String, ?> r21 = r20.next();     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r21.getKey()) == true) goto L19;
        if ("uptime".equals(r21.getKey()) == true) goto L19;
        a r22 = a.a((String) r21.getValue());     // Catch: Throwable -> L32
        if (r22 == null) goto L19;
        this.f8607m.put(r22.f8610a, r22);     // Catch: Throwable -> L32
        goto L19
    L28:
        monitor-exit(r19);     // Catch: Throwable -> L32
        Handler r23 = this.f8606b;
        if (r23 == null) goto L69;
        r23.removeMessages(8);
        this.f8606b.sendEmptyMessageDelayed(8, 500);
        return false;
    L69:
        return false;
    L32:
        th = move-exception;
        throw th;
    L75:
        return false;
    L74:
        return false;
    L73:
        return false;
    }
}
