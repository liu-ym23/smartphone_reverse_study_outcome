package j4;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import c4.m;
import i4.h;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Handler.Callback {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final List<String> f8631p = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Handler f8633b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ConcurrentHashMap f8634m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SharedPreferences f8635n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final i4.c f8636o;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f8637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8638b;

        public a(String r8, int r10) {
            this.f8637a = r8;
            this.f8638b = r10;
        }
    }

    static {
        f8631p = Collections.singletonList("StatsMonitor");
    }

    public e(i4.c r8) {
        this.f8632a = true;
        this.f8634m = new ConcurrentHashMap();
        this.f8636o = r8;
    }

    public static void a(Map r8, JSONArray r10) {
        if (r8.isEmpty() == false) goto L5;
        return;
    L5:
        JSONObject r11 = new JSONObject();
        r11.put("event", "sdk_stats");     // Catch: Throwable -> L16
        JSONObject r12 = new JSONObject();     // Catch: Throwable -> L16
        Iterator r13 = r8.entrySet().iterator();     // Catch: Throwable -> L16
    L8:
        if (r13.hasNext() == false) goto L14;
        Map.Entry r14 = (Map.Entry) r13.next();     // Catch: Throwable -> L16
        Integer r15 = (Integer) r14.getValue();     // Catch: Throwable -> L16
        if (r15 == null) goto L8;
        if (r15.intValue() <= 0) goto L8;
        r12.put((String) r14.getKey(), r15);     // Catch: Throwable -> L16
        goto L8
    L14:
        r11.put("params", r12);     // Catch: Throwable -> L16
        r11.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L16
        r11.put("event_id", h.f8232b.incrementAndGet());     // Catch: Throwable -> L16
        r11.put("datetime", h.a());     // Catch: Throwable -> L16
    L18:
        r10.put(r11);
        return;
    L16:
        th = move-exception;
        m.u().m(8, f8631p, "appendMapToJSONArray failed", th, new Object[0]);
        goto L18
    }

    public final void b(int r8, String r10) {
        if (this.f8632a == true) goto L5;
        return;
    L5:
        a r11 = new a(r10, r8);
        Handler r12 = this.f8633b;
        if (r12 == null) goto L8;
        r12.sendMessageDelayed(r12.obtainMessage(16, r11), 16);
        return;
    L8:
        c(r11);
    }

    public final void c(a r8) {
        ConcurrentHashMap r10 = this.f8634m;
        monitor-enter(r10);
        Integer r11 = (Integer) this.f8634m.get(r8.f8637a);     // Catch: Throwable -> L14
        if (r11 == null) goto L7;
        int r12 = r11.intValue();     // Catch: Throwable -> L14
    L8:
        int r13 = r12 + r8.f8638b;     // Catch: Throwable -> L14
        this.f8634m.put(r8.f8637a, Integer.valueOf(r13));     // Catch: Throwable -> L14
        monitor-exit(r10);     // Catch: Throwable -> L14
        Handler r14 = this.f8633b;
        if (r14 == null) goto L19;
        r14.removeMessages(8);
        this.f8633b.sendEmptyMessageDelayed(8, 500);
        return;
    L19:
        return;
    L7:
        r12 = 0;
    L14:
        th = move-exception;
        throw th;
    }

    public final void d(Map<String, Integer> r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isEmpty() == true) goto L38;
        ConcurrentHashMap r10 = this.f8634m;
        monitor-enter(r10);
        Iterator<Map.Entry<String, Integer>> r11 = r8.entrySet().iterator();     // Catch: Throwable -> L24
    L10:
        if (r11.hasNext() == false) goto L21;
        Map.Entry<String, Integer> r12 = r11.next();     // Catch: Throwable -> L24
        String r13 = r12.getKey();     // Catch: Throwable -> L24
        if (r12.getValue() == null) goto L14;
        int r14 = r12.getValue().intValue();     // Catch: Throwable -> L24
    L15:
        Integer r15 = (Integer) this.f8634m.get(r13);     // Catch: Throwable -> L24
        if (r15 == null) goto L10;
        int r16 = Math.max(0, r15.intValue() - r14);     // Catch: Throwable -> L24
        if (r16 == 0) goto L19;
        this.f8634m.put(r13, Integer.valueOf(r16));     // Catch: Throwable -> L24
        goto L10
    L19:
        this.f8634m.remove(r13);     // Catch: Throwable -> L24
        goto L10
    L14:
        r14 = 0;
        goto L15
    L21:
        monitor-exit(r10);     // Catch: Throwable -> L24
        this.f8633b.removeMessages(8);
        this.f8633b.sendEmptyMessageDelayed(8, 500);
        return;
    L24:
        th = move-exception;
        throw th;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r8) {
        int r10 = r8.what;
        if (r10 != 8) goto L5;
        SharedPreferences.Editor r11 = this.f8635n.edit();
        r11.clear();
        ConcurrentHashMap r12 = this.f8634m;
        monitor-enter(r12);
        Iterator r13 = this.f8634m.entrySet().iterator();     // Catch: Throwable -> L59
    L50:
        if (r13.hasNext() == false) goto L56;
        Map.Entry r14 = (Map.Entry) r13.next();     // Catch: Throwable -> L59
        String r15 = (String) r14.getKey();     // Catch: Throwable -> L59
        if (r14.getValue() == null) goto L54;
        int r16 = ((Integer) r14.getValue()).intValue();     // Catch: Throwable -> L59
    L55:
        r11.putInt(r15, r16);     // Catch: Throwable -> L59
        goto L50
    L54:
        r16 = 0;
        goto L55
    L56:
        monitor-exit(r12);     // Catch: Throwable -> L59
        r11.putLong("uptime", System.currentTimeMillis());
        r11.apply();
    L58:
        return false;
    L59:
        th = move-exception;
        throw th;
    L5:
        if (r10 != 16) goto L7;
        c((a) r8.obj);
        goto L58
    L7:
        if (r10 != 24) goto L58;
        SharedPreferences r17 = this.f8635n;
        if (r17 == null) goto L58;
        long r18 = r17.getLong("uptime", 0);
        if (r18 > 0) goto L15;
    L17:
        Map<String, ?> r19 = this.f8635n.getAll();
        if (r19.isEmpty() == true) goto L58;
        ConcurrentHashMap r20 = this.f8634m;
        monitor-enter(r20);
        Iterator<Map.Entry<String, ?>> r21 = r19.entrySet().iterator();     // Catch: Throwable -> L42
    L24:
        if (r21.hasNext() == false) goto L38;
        Map.Entry<String, ?> r22 = r21.next();     // Catch: Throwable -> L42
        String r23 = r22.getKey();     // Catch: Throwable -> L42
        if (TextUtils.isEmpty(r23) == true) goto L24;
        if ("uptime".equals(r22.getKey()) == true) goto L24;
        if (r22.getValue() == null) goto L33;
        int r24 = ((Integer) r22.getValue()).intValue();     // Catch: Throwable -> L42
    L34:
        Integer r25 = (Integer) this.f8634m.get(r23);     // Catch: Throwable -> L42
        if (r25 == null) goto L36;
        this.f8634m.put(r23, Integer.valueOf(r24 + r25.intValue()));     // Catch: Throwable -> L42
        goto L24
    L36:
        this.f8634m.put(r23, Integer.valueOf(r24));     // Catch: Throwable -> L42
        goto L24
    L33:
        r24 = 0;
        goto L34
    L38:
        monitor-exit(r20);     // Catch: Throwable -> L42
        Handler r26 = this.f8633b;
        if (r26 == null) goto L58;
        r26.removeMessages(8);
        this.f8633b.sendEmptyMessageDelayed(8, 500);
    L42:
        th = move-exception;
        throw th;
    L15:
        if ((System.currentTimeMillis() - r18) <= TimeUnit.DAYS.toMillis(this.f8636o.f8164i)) goto L17;
        this.f8635n.edit().clear().apply();
        goto L58
    }
}
