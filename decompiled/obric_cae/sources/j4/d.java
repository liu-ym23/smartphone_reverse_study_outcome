package j4;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import c4.m;
import i4.h;
import i4.i;
import i4.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Handler.Callback {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final List<String> f8620r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a> f8621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8622b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Handler f8623m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public SharedPreferences f8624n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final i4.c f8625o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f8626p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicBoolean f8627q;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f8628a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public i4.a f8629b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8630c;

        public a(i4.a r8, i r10) {
            this.f8630c = false;
            this.f8629b = r8;
            this.f8628a = r10;
        }

        public final String a() {
            StringBuilder r8 = new StringBuilder("v3|");
            i r10 = this.f8628a;
            if (TextUtils.isEmpty(r10.f8238e) == false) goto L5;
            String r11 = "";
        L6:
            r8.append(r11);
            r8.append("|");
            r8.append(r10.f8239f);
            r8.append("|");
            r8.append(this.f8629b.name());
            r8.append("|");
            r8.append(r10.f8234a);
            r8.append("|");
            r8.append(r10.f8236c);
            r8.append("|");
            r8.append(r10.f8237d.name());
            return r8.toString();
        L5:
            r11 = r10.f8238e;
            goto L6
        }
    }

    static {
        f8620r = Collections.singletonList("SentryMonitor");
    }

    public d(i4.c r8) {
        this.f8621a = Collections.synchronizedMap(new LinkedHashMap());
        this.f8622b = true;
        this.f8626p = true;
        this.f8627q = new AtomicBoolean(false);
        this.f8625o = r8;
    }

    public static void b(Map r10, JSONArray r11) {
        if (r10.isEmpty() == false) goto L5;
        return;
    L5:
        HashMap r8 = new HashMap();
        Iterator r12 = r10.values().iterator();
    L7:
        if (r12.hasNext() == false) goto L28;
        a r13 = (a) r12.next();
        JSONArray r14 = (JSONArray) r8.get(r13.f8629b);
        if (r14 != null) goto L11;
        r14 = new JSONArray();
        r8.put(r13.f8629b, r14);
    L11:
        i r15 = r13.f8628a;
        JSONObject r16 = new JSONObject();
        r16.put("monitor_id", r15.f8235b);     // Catch: Throwable -> L36
        j r17 = r15.f8237d;     // Catch: Throwable -> L36
        if (r17 == null) goto L16;
        r16.put("event_type", r17.f8246a);     // Catch: Throwable -> L36
    L16:
        if (TextUtils.isEmpty(r15.f8234a) == true) goto L18;
        r16.put("event", r15.f8234a);     // Catch: Throwable -> L36
    L18:
        long r18 = r15.f8236c;     // Catch: Throwable -> L36
        if (r18 <= 0) goto L22;
        r16.put("local_time_ms", r18);     // Catch: Throwable -> L36
    L22:
        if (TextUtils.isEmpty(r15.f8238e) == true) goto L24;
        r16.put("event_priority", r15.f8238e);     // Catch: Throwable -> L36
    L24:
        int r19 = r15.f8239f;     // Catch: Throwable -> L36
        if (r19 < 0) goto L27;
        r16.put("global_priority", r19);     // Catch: Throwable -> L36
    L27:
        r14.put(r16);
        goto L7
    L28:
        JSONObject r110 = new JSONObject();
        r110.put("event", "sdk_stage");     // Catch: Throwable -> L37
        JSONObject r20 = new JSONObject();     // Catch: Throwable -> L37
        Iterator r21 = r8.entrySet().iterator();     // Catch: Throwable -> L37
    L31:
        if (r21.hasNext() == false) goto L33;
        Map.Entry r22 = (Map.Entry) r21.next();     // Catch: Throwable -> L37
        r20.put(((i4.a) r22.getKey()).f8151a, r22.getValue());     // Catch: Throwable -> L37
        goto L31
    L33:
        r110.put("params", r20);     // Catch: Throwable -> L37
        r110.put("local_time_ms", System.currentTimeMillis());     // Catch: Throwable -> L37
        r110.put("event_id", h.f8232b.incrementAndGet());     // Catch: Throwable -> L37
        r110.put("datetime", h.a());     // Catch: Throwable -> L37
    L34:
        r11.put(r110);
    }

    public final void a(a r8) {
        m.u().l(8, f8620r, "start handle stage ({})", new Object[]{r8});
        Map<String, a> r10 = this.f8621a;
        monitor-enter(r10);
    L19:
        th = move-exception;
        throw th;
    L5:
        if (e(r8.f8628a.f8234a) == true) goto L8;
        monitor-exit(r10);     // Catch: Throwable -> L19
        return;
    L8:
        a r11 = this.f8621a.get(r8.f8628a.f8235b);     // Catch: Throwable -> L19
        if (r11 != null) goto L11;
        this.f8621a.put(r8.f8628a.f8235b, r8);     // Catch: Throwable -> L19
    L14:
        monitor-exit(r10);     // Catch: Throwable -> L19
        Handler r12 = this.f8623m;
        if (r12 == null) goto L23;
        r12.removeMessages(4);
        this.f8623m.sendEmptyMessageDelayed(4, 500);
        return;
    L23:
        return;
    L11:
        r11.f8630c = false;     // Catch: Throwable -> L19
        r11.f8628a.a(r8.f8628a);     // Catch: Throwable -> L19
        if (r8.f8629b.ordinal() <= r11.f8629b.ordinal()) goto L14;
        r11.f8629b = r8.f8629b;     // Catch: Throwable -> L19
        goto L14
    }

    public final Pair<Map<String, a>, Long> c(long r8) {
        if (this.f8621a.isEmpty() == true) goto L5;
        LinkedHashMap r10 = new LinkedHashMap();
        Map<String, a> r11 = this.f8621a;
        monitor-enter(r11);
        Iterator<Map.Entry<String, a>> r12 = this.f8621a.entrySet().iterator();     // Catch: Throwable -> L20
    L10:
        if (r12.hasNext() == false) goto L17;
        Map.Entry<String, a> r13 = r12.next();     // Catch: Throwable -> L20
        a r14 = r13.getValue();     // Catch: Throwable -> L20
        r10.put(r13.getKey(), r14);     // Catch: Throwable -> L20
        i r15 = r14.f8628a;     // Catch: Throwable -> L20
        if (r15 == null) goto L14;
        int r16 = r15.f8234a.length();     // Catch: Throwable -> L20
    L15:
        r8 = r8 - ((long) (r16 + 133));     // Catch: Throwable -> L20
        if (r8 >= 0) goto L10;
    L14:
        r16 = 0;
    L17:
        monitor-exit(r11);     // Catch: Throwable -> L20
        return new Pair(r10, Long.valueOf(r8));
    L20:
        th = move-exception;
        throw th;
    L5:
        return new Pair(null, Long.valueOf(r8));
    }

    public final boolean d() {
        if (this.f8626p == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f8625o.f8170o == true) goto L8;
        return false;
    }

    public final boolean e(String r8) {
        if (d() == false) goto L6;
        return true;
    L6:
        Map<String, Integer> r10 = this.f8625o.f8168m;
        if (r10 != null) goto L11;
        return false;
    L11:
        return r10.containsKey(r8);
    }

    public final void f(Map<String, a> r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (r8.isEmpty() == true) goto L34;
        SharedPreferences r10 = this.f8624n;
        if (r10 == null) goto L9;
        SharedPreferences.Editor r11 = r10.edit();
    L10:
        Map<String, a> r12 = this.f8621a;
        monitor-enter(r12);
        Iterator<String> r13 = r8.keySet().iterator();     // Catch: Throwable -> L22
    L14:
        if (r13.hasNext() == false) goto L18;
        String r14 = r13.next();     // Catch: Throwable -> L22
        this.f8621a.remove(r14);     // Catch: Throwable -> L22
        if (r11 == null) goto L14;
        r11.remove(r14);     // Catch: Throwable -> L22
        goto L14
    L18:
        monitor-exit(r12);     // Catch: Throwable -> L22
        if (r11 == null) goto L33;
        r11.apply();
        return;
    L33:
        return;
    L22:
        th = move-exception;
        throw th;
    L9:
        r11 = null;
        goto L10
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message r21) {
        int r8 = r21.what;
        int r10 = 1;
        if (r8 == 4) goto L85;
        if (r8 != 8) goto L6;
        a((a) r21.obj);
    L97:
        return false;
    L6:
        if (r8 != 12) goto L97;
        if (this.f8624n == null) goto L97;
        m.u().l(8, f8620r, "start load cache map from sp...", new Object[0]);
        long r11 = this.f8624n.getLong("uptime", 0);
        if (r11 > 0) goto L14;
    L16:
        Map<String, ?> r12 = this.f8624n.getAll();
        if (r12.isEmpty() == true) goto L97;
        int r13 = 2;
        HashMap r14 = new HashMap(r12.size() * 2);
        Iterator<Map.Entry<String, ?>> r15 = r12.entrySet().iterator();
    L21:
        if (r15.hasNext() == false) goto L68;
        Map.Entry<String, ?> r16 = r15.next();
        String r17 = r16.getKey();
        if (TextUtils.isEmpty(r17) == false) goto L25;
    L66:
        int r18 = r13;
    L67:
        r13 = r18;
        r10 = 1;
        goto L21
    L25:
        if ("uptime".equals(r17) == true) goto L66;
        String r19 = (String) r16.getValue();
        String r110 = null;
        a r111 = null;
        r111 = null;
        if (TextUtils.isEmpty(r19) == false) goto L30;
    L29:
        r18 = r13;
    L63:
        if (r111 == null) goto L67;
        r111.f8630c = true;
        r14.put(r17, r111);
        goto L67
    L30:
        AtomicLong r20 = h.f8231a;
        if (r19 != null) goto L33;
    L43:
        ArrayList r22 = new ArrayList();
    L45:
        if (r22.isEmpty() == true) goto L29;
        if (((String) r22.get(0)).equals("v3") == false) goto L57;
        int r23 = Integer.parseInt((String) r22.get(r13));     // Catch: Throwable -> L50
    L51:
        i4.a r112 = i4.a.valueOf((String) r22.get(3));
        if (TextUtils.isEmpty((CharSequence) r22.get(r10)) == true) goto L55;
        r110 = (String) r22.get(r10);
    L55:
        r111 = new a(r112, new i(r110, r23, (String) r22.get(4), r17, Long.parseLong((String) r22.get(5)), j.a((String) r22.get(6))));
    L62:
        r18 = 2;
    L50:
        r23 = -1;
        goto L51
    L57:
        if (r22.size() != 4) goto L60;
        r111 = new a(i4.a.valueOf((String) r22.get(0)), new i(Long.parseLong((String) r22.get(2)), j.f8240b, (String) r22.get(1), r17));
        goto L62
    L60:
        if (r22.size() != 5) goto L62;
        r18 = 2;
        r111 = new a(i4.a.valueOf((String) r22.get(0)), new i(Long.parseLong((String) r22.get(2)), j.a((String) r22.get(3)), (String) r22.get(1), r17));
        goto L63
    L33:
        if (r19.isEmpty() == true) goto L43;
        r22 = new ArrayList();
        int r113 = r19.length();
        int r114 = 0;
        int r115 = 0;
    L36:
        if (r114 >= r113) goto L41;
        if (r19.charAt(r114) != '|') goto L40;
        r22.add(r19.substring(r115, r114));
        r115 = r114 + 1;
    L40:
        r114 = r114 + 1;
        goto L36
    L41:
        if (r115 > r113) goto L45;
        r22.add(r19.substring(r115));
        goto L45
    L68:
        Map<String, a> r24 = this.f8621a;
        monitor-enter(r24);
        Iterator r25 = r14.entrySet().iterator();     // Catch: Throwable -> L81
    L72:
        if (r25.hasNext() == false) goto L79;
        Map.Entry r26 = (Map.Entry) r25.next();     // Catch: Throwable -> L81
        String r27 = (String) r26.getKey();     // Catch: Throwable -> L81
        a r28 = (a) r26.getValue();     // Catch: Throwable -> L81
        if (this.f8621a.containsKey(r26.getKey()) == false) goto L78;
        a r29 = this.f8621a.get(r26.getKey());     // Catch: Throwable -> L81
        if (r29 == null) goto L78;
        r28.f8630c = false;     // Catch: Throwable -> L81
        r28.f8628a.a(r29.f8628a);     // Catch: Throwable -> L81
    L78:
        this.f8621a.put(r27, r28);     // Catch: Throwable -> L81
        goto L72
    L79:
        monitor-exit(r24);     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        throw th;
    L14:
        if ((System.currentTimeMillis() - r11) <= TimeUnit.DAYS.toMillis(this.f8625o.f8164i)) goto L16;
        this.f8624n.edit().clear().apply();
        goto L97
    L85:
        m.u().l(8, f8620r, "start flush cache map (size={}) to sp...", new Object[]{Integer.valueOf(this.f8621a.size())});
        SharedPreferences.Editor r30 = this.f8624n.edit();
        Map<String, a> r31 = this.f8621a;
        monitor-enter(r31);
        Iterator<Map.Entry<String, a>> r32 = this.f8621a.entrySet().iterator();     // Catch: Throwable -> L98
    L89:
        if (r32.hasNext() == false) goto L95;
        a r33 = r32.next().getValue();     // Catch: Throwable -> L98
        if (r33.f8630c == true) goto L89;
        if (e(r33.f8628a.f8234a) == false) goto L89;
        r30.putString(r33.f8628a.f8235b, r33.a());     // Catch: Throwable -> L98
        r33.f8630c = true;     // Catch: Throwable -> L98
        goto L89
    L95:
        monitor-exit(r31);     // Catch: Throwable -> L98
        r30.putLong("uptime", System.currentTimeMillis());
        r30.apply();
    L98:
        th = move-exception;
        throw th;
    }
}
