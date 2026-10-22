package g7;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.bytedance.common.utility.Logger;
import com.obric.cae.BWDL.BwdlDrop.fileTransmission.BwdlDropActionFrame;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class j {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static volatile j f7740m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AtomicBoolean f7741n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f7742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f7743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicLong f7744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f7745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ReentrantReadWriteLock f7746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList f7747f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ReentrantReadWriteLock f7748g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f7749h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AtomicLong f7750i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ConcurrentHashMap f7751j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f7752k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f7753l;

    public static class a implements Comparator<g7.a> {
        @Override // java.util.Comparator
        public final int compare(g7.a r8, g7.a r10) {
            return r8.f7703i - r10.f7703i;
        }
    }

    static {
        f7741n = new AtomicBoolean(false);
    }

    public j() {
        this.f7742a = null;
        this.f7743b = new AtomicBoolean(true);
        this.f7744c = new AtomicLong(0);
        this.f7745d = new ArrayList();
        this.f7746e = new ReentrantReadWriteLock();
        this.f7747f = new ArrayList();
        this.f7748g = new ReentrantReadWriteLock();
        this.f7749h = new AtomicInteger(0);
        this.f7750i = new AtomicLong(0);
        this.f7751j = new ConcurrentHashMap();
    }

    public static j e() {
        if (f7740m != null) goto L15;
        monitor-enter(j.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f7740m != null) goto L9;
        f7740m = new j();     // Catch: Throwable -> L11
    L9:
        monitor-exit(j.class);     // Catch: Throwable -> L11
    L15:
        return f7740m;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int a(String r21, String r22) {
        if (Logger.debug() == false) goto L6;
        Logger.d("j", "getDelayResultForUrl: " + r21);
    L6:
        int r8 = 0;
        if (l7.g.a(r21) == false) goto L9;
        this.f7748g.readLock().lock();
        ArrayList r10 = new ArrayList();
        r10.add(0, 0);
        Iterator r11 = this.f7747f.iterator();
    L14:
        if (r11.hasNext() == false) goto L115;
        c r12 = (c) r11.next();
        if (Logger.debug() == false) goto L18;
        Logger.d("j", "current action priority is " + r12.f7703i);
    L18:
        r12.getClass();
        Logger.d("c", "take delay action");
        if (r12.c() == true) goto L21;
    L108:
        r11 = r11;
        r10.set(r8, Integer.valueOf(r8));
        g7.a.EnumC0079a r13 = g7.a.EnumC0079a.f7708a;
    L110:
        if (r13 == g7.a.EnumC0079a.f7711n) goto L112;
        r11 = r11;
        r8 = 0;
        goto L14
    L112:
        if (Logger.debug() == false) goto L115;
        Logger.d("j", "the url has been delayed by delay action, skip follow-up actions");
        goto L115
    L21:
        if (TextUtils.isEmpty(r21) == true) goto L108;
        Uri r14 = Uri.parse(r21);
        if (r14.getHost() == null) goto L45;
        if (r12.d(r14) == false) goto L45;
        if (r12.f7716q.isEmpty() == false) goto L35;
        r10.set(r8, Integer.valueOf(r12.g()));
        if (Logger.debug() == false) goto L33;
        Logger.d("c", "tnc tag map is empty, result delay time is " + r10.get(r8));
    L33:
        r13 = g7.a.EnumC0079a.f7711n;
        r11 = r11;
        goto L110
    L35:
        if (t6.a.f12275b.get() == true) goto L40;
        if (Logger.debug() == false) goto L45;
        Logger.d("c", "this action with tag is not enabled");
        goto L45
    L40:
        if ("".equals(r22) == false) goto L42;
        String r15 = "s=0;p=0";
    L43:
        HashMap r16 = new HashMap();
        ArrayList r17 = new ArrayList();
        if (t2.b.W(r15, ";", r17) == false) goto L45;
        Iterator r18 = r17.iterator();
    L48:
        if (r18.hasNext() == false) goto L50;
        Pair r19 = (Pair) r18.next();
        r16.put(r19.first, r19.second);
        goto L48
    L50:
        t6.a.EnumC0161a r110 = t6.a.EnumC0161a.f12280b;
        String r111 = Integer.toString(-1);
        if (t6.a.f12274a != r110) goto L53;
        r11 = r11;
    L83:
        r16.put("s", r111);
        Context r20 = e().f7742a;
        if (r20 == null) goto L86;
        boolean r23 = l7.e.c(r20);
    L87:
        r16.put("p", Integer.toString(!r23));
        if (Logger.debug() == false) goto L90;
        Logger.d("c", "request tag string is " + r15);
    L90:
        g7.a.EnumC0079a r24 = g7.a.EnumC0079a.f7711n;
        Iterator r25 = r12.f7716q.entrySet().iterator();
    L92:
        if (r25.hasNext() == false) goto L100;
        Map.Entry r26 = (Map.Entry) r25.next();
        String r112 = (String) r16.get(r26.getKey());
        if (r112 == null) goto L98;
        if (((Set) r26.getValue()).contains(r112) == true) goto L92;
    L98:
        r24 = g7.a.EnumC0079a.f7708a;
    L100:
        if (r24 != g7.a.EnumC0079a.f7711n) goto L103;
        r10.set(0, Integer.valueOf(r12.g()));
    L103:
        if (Logger.debug() == false) goto L105;
        Logger.d("c", "match tag result is " + r24);
        Logger.d("c", "will delay time is " + r10.get(0));
        Logger.d("c", "request tag map is " + r16);
        Logger.d("c", "tnc tag map is " + r12.f7716q);
    L105:
        r13 = r24;
        goto L110
    L86:
        r23 = 1;
        goto L87
    L53:
        if (Logger.debug() == false) goto L56;
        Logger.d("a", "get coldDuration hostDuration warmDuration " + t6.a.f12277d.get() + t6.a.f12278e.get() + t6.a.f12279f.get());
    L56:
        int r27 = t6.a.f12274a.ordinal();
        if (r27 != 1) goto L59;
        long r28 = t6.a.f12276c.get();
        if (((System.currentTimeMillis() / 1000) - r28) <= t6.a.f12277d.get()) goto L78;
        boolean r29 = true;
    L79:
        if (r29 == false) goto L81;
    L80:
        t6.a.f12274a = r110;
    L81:
        r111 = Integer.toString(t6.a.f12274a.f12282a);
        goto L83
    L78:
        r29 = false;
        goto L79
    L59:
        if (r27 != 2) goto L61;
        long r30 = t6.a.f12276c.get();
        if (((System.currentTimeMillis() / 1000) - r30) <= t6.a.f12278e.get()) goto L72;
        boolean r31 = true;
    L73:
        if (r31 == false) goto L81;
    L72:
        r31 = false;
        goto L73
    L61:
        if (r27 != 3) goto L81;
        long r32 = t6.a.f12276c.get();
        if (((System.currentTimeMillis() / 1000) - r32) <= t6.a.f12279f.get()) goto L66;
        boolean r33 = true;
    L67:
        if (r33 == false) goto L81;
    L66:
        r33 = false;
        goto L67
    L42:
        r15 = r22;
    L45:
        r11 = r11;
        r13 = g7.a.EnumC0079a.f7708a;
    L115:
        this.f7748g.readLock().unlock();
        return ((Integer) r10.get(0)).intValue();
    L9:
        if (Logger.debug() == false) goto L11;
        Logger.d("j", "illegal url");
    L11:
        return 0;
    }

    public final n4.b b(k r14) {
        StringBuilder r8 = new StringBuilder("getDispatchResultForUrl: ");
        String r10 = r14.f7754a;
        r8.append(r10);
        Logger.d("j", r8.toString());
        if (l7.g.a(r10) == true) goto L6;
        String r13 = "illegal url";
    L8:
        Logger.d("j", r13);
        return null;
    L6:
        if (this.f7743b.get() == true) goto L10;
        r13 = "dispatch is unabled by tnc";
        goto L8
    L10:
        n4.b r11 = new n4.b(1);
        ArrayList r12 = new ArrayList();
        ArrayList r15 = new ArrayList();
        r15.add(0, r10);
        ReentrantReadWriteLock r16 = this.f7746e;
        r16.readLock().lock();
        Iterator r17 = this.f7745d.iterator();
        String r18 = r10;
    L12:
        if (r17.hasNext() == false) goto L41;
        i r19 = (i) r17.next();
        Logger.d("j", "action url = " + r15);
        Logger.d("j", "current action priority is " + r19.f7703i);
        if (r14.f7756c <= r19.f7703i) goto L17;
        String r110 = "jump action: " + r19.f7705k + ", dispatchPriority: " + r14.f7756c + ", actionPriority: " + r19.f7703i;
    L23:
        Logger.d("a", r110);
        boolean r111 = false;
    L25:
        if (r111 == true) goto L27;
    L36:
        r15.set(0, r18);
        g7.a.EnumC0079a r20 = g7.a.EnumC0079a.f7708a;
    L37:
        String r21 = (String) r15.get(0);
        if (r20 == g7.a.EnumC0079a.f7710m) goto L39;
        r18 = r21;
        goto L12
    L39:
        Logger.d("j", "the url has been dropped by urldispatcher, skip follow-up actions");
        goto L41
    L27:
        if (TextUtils.isEmpty(r18) == true) goto L36;
        r20 = r19.g(r18, r15);
        d r112 = new d();
        if (r20 == g7.a.EnumC0079a.f7708a) goto L35;
        r112.f7720d = true;
        r112.f7718b = r19.f7704j;
        r112.f7719c = r19.f7703i;
        r112.f7721e = r19.h();
        r112.f7717a = r19.f7705k;
        if (r20 != g7.a.EnumC0079a.f7709b) goto L34;
        r112.f7723g = (String) r15.get(0);
        r112.f7722f = r19.f7739n;
    L34:
        r14.f7756c = r19.f7706l;
    L35:
        r12.add(r112);
        goto L37
    L17:
        if (r19.f7707m.isEmpty() == true) goto L24;
        String r113 = r14.f7755b;
        if (TextUtils.isEmpty(r113) == true) goto L24;
        if (r19.f7707m.contains(r113) == true) goto L24;
        r110 = defpackage.b.c("request method not support: ", r113);
    L24:
        r111 = r19.c();
    L41:
        Object r114 = (String) r15.get(0);
        r16.readLock().unlock();
        ArrayList r115 = new ArrayList();
        JSONObject r22 = new JSONObject();     // Catch: JSONException -> L51
        r22.put("origin_url", r10);     // Catch: JSONException -> L51
        r22.put("dispatched_url", r114);     // Catch: JSONException -> L51
        JSONArray r23 = new JSONArray();     // Catch: JSONException -> L51
        Iterator r24 = r12.iterator();     // Catch: JSONException -> L51
    L44:
        if (r24.hasNext() == false) goto L49;
        d r25 = (d) r24.next();     // Catch: JSONException -> L51
        if (r25.f7720d == false) goto L44;
        JSONObject r26 = new JSONObject();     // Catch: JSONException -> L51
        r115.add(Long.valueOf(r25.f7718b));     // Catch: JSONException -> L51
        r26.put("rule_id", r25.f7718b);     // Catch: JSONException -> L51
        r26.put("service_name", r25.f7717a);     // Catch: JSONException -> L51
        r26.put("priority", r25.f7719c);     // Catch: JSONException -> L51
        r23.put(r26);     // Catch: JSONException -> L51
        goto L44
    L49:
        r22.put("action_info_list", r23);     // Catch: JSONException -> L51
        JSONObject r27 = new JSONObject();     // Catch: JSONException -> L51
        r27.put("dispatch", r22);     // Catch: JSONException -> L51
        new JSONObject().put("dispatchersdk", r27);     // Catch: JSONException -> L51
    L53:
        r11.f9431b = r115;
        r11.f9430a = r114;
        r11.f9432c = r12;
        return r11;
    L51:
        e = move-exception;
        e.printStackTrace();
        goto L53
    }

    public final ConcurrentHashMap c() {
        return this.f7751j;
    }

    public final String d(String r8) {
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L45:
        return r8;
    L5:
        if (r8.contains("/network/get_network") == true) goto L45;
        if (r8.contains("/get_domains/v5") == true) goto L45;
        if (r8.contains("/ies/speed") == true) goto L45;
        String r10 = null;
        URL r11 = new URL(r8);     // Catch: Throwable -> L17
        String r12 = r11.getProtocol();     // Catch: Throwable -> L17
        r10 = r11.getHost();     // Catch: Throwable -> L15
    L21:
        if (TextUtils.isEmpty(r12) == true) goto L45;
        if ("http".equals(r12) == true) goto L27;
        if (LocationInfoConst.HTTPS.equals(r12) == false) goto L45;
    L27:
        if (TextUtils.isEmpty(r10) == true) goto L45;
        ConcurrentHashMap r13 = this.f7751j;
        if (r13 == null) goto L43;
        if (r13.containsKey(r10) == false) goto L43;
        String r14 = (String) r13.get(r10);
        if (TextUtils.isEmpty(r14) == false) goto L37;
        return r8;
    L37:
        Logger.d("j", "handleHostMapping, match, origin: ".concat(r8));
        String r15 = r12 + "://" + r10;
        String r16 = defpackage.a.f(r12, "://", r14);
        if (r8.startsWith(r15) == false) goto L40;
        r8 = r8.replaceFirst(r15, r16);
    L40:
        Logger.d("j", "handleHostMapping, target: " + r8);
        return r8;
    L43:
        if (Logger.debug() == false) goto L45;
        Logger.d("j", "handleHostMapping, nomatch: " + r10);
    L15:
        th = th;
    L19:
        th.printStackTrace();
    L17:
        th = th;
        r12 = null;
        goto L19
    }

    public final boolean f() {
        return this.f7745d.isEmpty();
    }

    public final void g(JSONObject r10, int r11, String r12, String r13, long r14) {
        ReentrantReadWriteLock r8 = this.f7746e;
        ReentrantReadWriteLock r15 = this.f7748g;
        ArrayList r16 = this.f7745d;
        ArrayList r17 = this.f7747f;
        Logger.d("j", "URLDispatcher::onServerConfigChanged, tnc source is " + r11 + "etag is " + r12);
        this.f7749h.set(r11);
        this.f7752k = r12;
        this.f7753l = r13;
        this.f7750i.set(r14);
        JSONArray r18 = r10.optJSONArray("request_delay_actions");
        r15.writeLock().lock();     // Catch: Throwable -> L47
        r17.clear();     // Catch: Throwable -> L47
        int r19 = 0;
        if (r18 == null) goto L13;
        int r110 = 0;
    L7:
        if (r110 >= r18.length()) goto L13;
        JSONObject r111 = r18.optJSONObject(r110);     // Catch: Throwable -> L47
        if (r111 == null) goto L11;
        i(r111);     // Catch: Throwable -> L47
    L11:
        r110 = r110 + 1;     // Catch: Throwable -> L47
    L13:
        if (r17.isEmpty() == true) goto L15;
        Collections.sort(r17, new a());     // Catch: Throwable -> L47
    L15:
        r15.writeLock().unlock();
        if (Logger.debug() == false) goto L18;
        Logger.d("j", "parse delay actions completed, actions size is " + r17.size());
    L18:
        int r112 = r10.optInt("ttnet_url_dispatcher_enabled", -1);
        if (r112 < 0) goto L25;
        AtomicBoolean r113 = this.f7743b;
        boolean r114 = true;
        if (r112 == 1) goto L24;
        r114 = false;
    L24:
        r113.set(r114);
    L25:
        long r115 = r10.optInt("ttnet_dispatch_actions_epoch", -1);
        AtomicLong r116 = this.f7744c;
        if (r115 != r116.get()) goto L30;
        String r20 = "dispatch action epoch not changed";
    L28:
        Logger.d("j", r20);
        return;
    L30:
        r116.set(r115);
        JSONArray r21 = r10.optJSONArray("ttnet_dispatch_actions");
        if (r21 != null) goto L52;
        return;
    L52:
        r8.writeLock().lock();     // Catch: Throwable -> L44
        r16.clear();     // Catch: Throwable -> L44
    L35:
        if (r19 >= r21.length()) goto L41;
        JSONObject r117 = r21.optJSONObject(r19);     // Catch: Throwable -> L44
        if (r117 == null) goto L39;
        h(r117);     // Catch: Throwable -> L44
    L39:
        r19 = r19 + 1;     // Catch: Throwable -> L44
        goto L35
    L41:
        if (r16.isEmpty() == true) goto L43;
        Collections.sort(r16, new a());     // Catch: Throwable -> L44
    L43:
        r8.writeLock().unlock();
        r20 = "parse dispatch actions completed, actions size is " + r16.size();
    L44:
        th = move-exception;
        r8.writeLock().unlock();
        Logger.d("j", "parse dispatch actions completed, actions size is " + r16.size());
        throw th;
    L47:
        th = move-exception;
        r15.writeLock().unlock();
        if (Logger.debug() == false) goto L51;
        Logger.d("j", "parse delay actions completed, actions size is " + r17.size());
    L51:
        throw th;
    }

    public final void h(JSONObject r20) {
        String r8 = r20.optString(BwdlDropActionFrame.HEADER);
        if (TextUtils.isEmpty(r8) == false) goto L5;
        return;
    L5:
        int r10 = r20.optInt("act_priority", -1);
        if (r10 >= 0) goto L8;
        return;
    L8:
        JSONObject r11 = r20.optJSONObject("param");
        if (r11 != null) goto L11;
        return;
    L11:
        String r12 = r20.optString("lifecycle");
        int r13 = 0;
        if ("".equals(r12) == false) goto L14;
        long r14 = 0;
    L20:
        long r15 = r14;
    L21:
        long r16 = r20.optInt("rule_id");
        String r17 = r20.optString("sign");
        ArrayList r18 = new ArrayList();
        JSONArray r19 = r20.optJSONArray("request_method");
        if (r19 != null) goto L24;
    L29:
        long r21 = r14;
        long r22 = r15;
        g7.a r23 = g7.a.a(r8, r11, r10, r21, r22, r16, r17, this.f7744c.get(), r18, r20.optInt("set_req_priority", r10));
        if ((r23 instanceof i) == false) goto L36;
        this.f7745d.add((i) r23);
        return;
    L36:
        return;
    L24:
        if (r13 >= r19.length()) goto L29;
        String r110 = r19.optString(r13);
        if (TextUtils.isEmpty(r110) == true) goto L28;
        r18.add(r110);
    L28:
        r13 = r13 + 1;
        goto L24
    L14:
        ArrayList r24 = new ArrayList();
        if (t2.b.X(r12, r24) == true) goto L17;
    L19:
        r14 = -1;
        goto L20
    L17:
        if (r24.size() != 2) goto L19;
        long r25 = ((Long) r24.get(0)).longValue();
        r15 = ((Long) r24.get(1)).longValue();
        r14 = r25;
        goto L21
    }

    public final void i(JSONObject r19) {
        int r8 = r19.optInt("act_priority", -1);
        if (r8 >= 0) goto L5;
        return;
    L5:
        JSONObject r10 = r19.optJSONObject("param");
        if (r10 != null) goto L8;
        return;
    L8:
        String r11 = r19.optString("lifecycle");
        if ("".equals(r11) == false) goto L11;
        long r12 = 0;
    L17:
        long r13 = r12;
        long r14 = r13;
    L18:
        g7.a r15 = g7.a.a("delay", r10, r8, r13, r14, 0, "", this.f7744c.get(), null, 0);
        if ((r15 instanceof c) == false) goto L22;
        this.f7747f.add((c) r15);
        return;
    L22:
        return;
    L11:
        ArrayList r16 = new ArrayList();
        if (t2.b.X(r11, r16) == true) goto L14;
    L16:
        r12 = -1;
        goto L17
    L14:
        if (r16.size() != 2) goto L16;
        r13 = ((Long) r16.get(0)).longValue();
        r14 = ((Long) r16.get(1)).longValue();
        goto L18
    }
}
