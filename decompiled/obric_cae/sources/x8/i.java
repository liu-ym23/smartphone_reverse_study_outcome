package x8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.retrofit2.SsHttpCall;
import com.bytedance.ttnet.TTNetInit;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class i implements SsHttpCall.IHttpCallThrottleControl {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static String f13716m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static i f13717n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f13719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f13720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f13721d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13722e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13723f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13724g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13725h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CopyOnWriteArraySet f13726i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ConcurrentHashMap f13727j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ConcurrentHashMap f13728k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicInteger f13729l;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConcurrentHashMap f13730a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final CopyOnWriteArraySet f13731b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13732c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f13733d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f13734e;

        public a() {
            this.f13730a = new ConcurrentHashMap();
            this.f13731b = new CopyOnWriteArraySet();
            this.f13732c = 1000;
            this.f13733d = 100;
            this.f13734e = 1000;
        }
    }

    public static final class b extends BroadcastReceiver {

        public class a extends s5.c {
            public a() {
                super(0);
            }

            @Override // s5.c, java.lang.Runnable
            public final void run() {
                if (j.f13735f == null) goto L5;
            L14:
                j.f13735f.a();
                return;
            L5:
                monitor-enter(j.class);
            L11:
                th = move-exception;
                throw th;
            L7:
                if (j.f13735f != null) goto L9;
                j.f13735f = new j();     // Catch: Throwable -> L11
            L9:
                monitor-exit(j.class);     // Catch: Throwable -> L11
                goto L14
            }
        }

        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context r8, Intent r10) {
            if (r10 != null) goto L4;
            return;
        L4:
            if ("com.bytedance.ttnet.config.appconfig.SYNC_APP_DELAY_CONFIG_ACTION".equals(r10.getAction()) == false) goto L8;
            new a().a();
            return;
        }
    }

    public i(Context r8, boolean r10) {
        this.f13720c = new ConcurrentHashMap();
        this.f13721d = "";
        this.f13722e = false;
        this.f13723f = false;
        this.f13724g = 1000;
        this.f13725h = 100;
        this.f13726i = new CopyOnWriteArraySet();
        this.f13727j = new ConcurrentHashMap();
        this.f13728k = new ConcurrentHashMap();
        this.f13729l = new AtomicInteger(0);
        this.f13718a = r8.getApplicationContext();
        this.f13719b = r10;
    }

    public static i a(Context r8) {
        monitor-enter(i.class);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (f13717n != null) goto L28;
        boolean r10 = l7.e.c(r8);     // Catch: Throwable -> L31
        f13717n = new i(r8, r10);     // Catch: Throwable -> L31
        f13716m = r8.getPackageName();     // Catch: Throwable -> L31
        if (r10 == false) goto L9;
        SsHttpCall.IHttpCallThrottleControl r11 = f13717n;     // Catch: Throwable -> L31
    L27:
        SsHttpCall.setThrottleControl(r11);     // Catch: Throwable -> L31
        goto L28
    L9:
        IntentFilter r12 = new IntentFilter();     // Catch: Throwable -> L31
        r12.addAction("com.bytedance.ttnet.config.appconfig.SYNC_APP_DELAY_CONFIG_ACTION");     // Catch: Throwable -> L31
        r8.registerReceiver(new b(), r12, null, null);     // Catch: Throwable -> L12
    L15:
        if (j.f13735f == null) goto L17;
    L26:
        r11 = j.f13735f;     // Catch: Throwable -> L31
        goto L27
    L17:
        monitor-enter(j.class);     // Catch: Throwable -> L31
    L23:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L19:
        if (j.f13735f != null) goto L21;
        j.f13735f = new j();     // Catch: Throwable -> L23
    L21:
        monitor-exit(j.class);     // Catch: Throwable -> L23
    L12:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L31
    L28:
        i r13 = f13717n;     // Catch: Throwable -> L31
        monitor-exit(i.class);     // Catch: Throwable -> L31
        return r13;
    }

    public final void b(JSONObject r12) {
        JSONArray r13 = r12.optJSONArray("tt_req_delay_config");
        ConcurrentHashMap r11 = this.f13720c;
        if (r13 != null) goto L6;
        r11.clear();
        return;
    L6:
        int r8 = 0;
    L8:
        if (r8 >= r13.length()) goto L44;
        a r10 = new a();
        JSONObject r14 = r13.optJSONObject(r8);
        if (r14 == null) goto L43;
        int r15 = r14.optInt("state", -2);
        if (r15 != (-1)) goto L15;
        y6.a.EnumC0198a r16 = y6.a.EnumC0198a.f14002b;
    L27:
        if (r14.isNull("bl_with_delay_ms") == true) goto L34;
        JSONObject r17 = r14.optJSONObject("bl_with_delay_ms");
        Iterator<String> r18 = r17.keys();
    L30:
        if (r18.hasNext() == false) goto L32;
        String r19 = r18.next();
        r10.f13730a.put(r19, Integer.valueOf(r17.optInt(r19)));
        goto L30
    L32:
        r10.f13732c = r14.optInt("bl_disable_time_ms", 1000);
    L42:
        r11.put(r16, r10);
        goto L43
    L34:
        if (r14.isNull("wl") == true) goto L42;
        JSONArray r20 = r14.optJSONArray("wl");
        if (r20 == null) goto L41;
        int r21 = 0;
    L39:
        if (r21 >= r20.length()) goto L41;
        r10.f13731b.add((String) r20.opt(r21));
        r21 = r21 + 1;
    L41:
        r10.f13733d = r14.optInt("delay_time_ms", 100);
        r10.f13734e = r14.optInt("wl_disable_time_ms", 1000);
        goto L42
    L15:
        if (r15 != 0) goto L18;
        r16 = y6.a.EnumC0198a.f14003m;
        goto L27
    L18:
        if (r15 != 1) goto L21;
        r16 = y6.a.EnumC0198a.f14004n;
        goto L27
    L21:
        if (r15 != 2) goto L24;
        r16 = y6.a.EnumC0198a.f14005o;
        goto L27
    L24:
        if (r15 != 3) goto L43;
        r16 = y6.a.EnumC0198a.f14006p;
    L43:
        r8 = r8 + 1;
        goto L8
    }

    public final void c(y6.a.EnumC0198a r8) {
        a r10 = (a) this.f13720c.get(r8);
        monitor-enter(this);
        this.f13723f = false;     // Catch: Throwable -> L23
        this.f13727j.clear();     // Catch: Throwable -> L23
        this.f13725h = 100;     // Catch: Throwable -> L23
        this.f13726i.clear();     // Catch: Throwable -> L23
        this.f13724g = 1000;     // Catch: Throwable -> L23
        this.f13728k.clear();     // Catch: Throwable -> L23
        if (r10 != null) goto L9;
        this.f13722e = false;     // Catch: Throwable -> L23
    L15:
        d();     // Catch: Throwable -> L23
        monitor-exit(this);
        y6.a.f14001b = r8;
        if (r8 == y6.a.EnumC0198a.f14003m) goto L20;
        return;
    L20:
        if (this.f13722e == false) goto L29;
        new Handler(Looper.getMainLooper()).postDelayed(new androidx.activity.d(this, 13), this.f13724g);
        return;
    L29:
        return;
    L9:
        if (r10.f13731b.isEmpty() == true) goto L12;
        this.f13722e = true;     // Catch: Throwable -> L23
        this.f13725h = r10.f13733d;     // Catch: Throwable -> L23
        this.f13726i = r10.f13731b;     // Catch: Throwable -> L23
        int r11 = r10.f13734e;     // Catch: Throwable -> L23
    L14:
        this.f13724g = r11;     // Catch: Throwable -> L23
        goto L15
    L12:
        if (r10.f13730a.isEmpty() == true) goto L15;
        this.f13722e = true;     // Catch: Throwable -> L23
        this.f13723f = true;     // Catch: Throwable -> L23
        this.f13727j = r10.f13730a;     // Catch: Throwable -> L23
        r11 = r10.f13732c;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public final void d() {
        LinkedHashMap r8 = new LinkedHashMap();
        if (this.f13722e == false) goto L5;
        r8.put("app_delay_enable", 1);
    L7:
        if (this.f13723f == false) goto L9;
        r8.put("app_delay_use_black_list", 1);
    L10:
        r8.put("app_delay_whitelist_delay_time", Integer.valueOf(this.f13725h));
        String[] r10 = (String[]) this.f13726i.toArray(new String[0]);
        StringBuilder r11 = new StringBuilder();
        int r12 = r10.length;
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L14;
        r11.append(r10[r13]);
        r11.append(",");
        r13 = r13 + 1;
        goto L11
    L14:
        if (r10.length <= 0) goto L16;
        String r14 = r11.substring(0, r11.length() - 1);
    L17:
        r8.put("app_delay_white_list", r14);
        r8.put("app_delay_black_list", new JSONObject(this.f13727j).toString());
        w8.c r15 = TTNetInit.getTTNetDepend();
        Context r16 = this.f13718a;
        r15.saveMapToProvider(r16, r8);
        Intent r17 = new Intent("com.bytedance.ttnet.config.appconfig.SYNC_APP_DELAY_CONFIG_ACTION");
        if (TextUtils.isEmpty(f13716m) == true) goto L20;
        r17.setPackage(f13716m);
    L20:
        r16.sendBroadcast(r17);
        return;
    L16:
        r14 = "";
        goto L17
    L9:
        r8.put("app_delay_use_black_list", 0);
        goto L10
    L5:
        r8.put("app_delay_enable", 0);
        goto L7
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public final int getDelayTimeByApp(String r8) {
        boolean r10 = this.f13723f;
        if (r10 == false) goto L17;
        ConcurrentHashMap r11 = this.f13727j;
        if (r11 == null) goto L17;
        Iterator r12 = r11.keySet().iterator();
    L8:
        if (r12.hasNext() == false) goto L21;
        String r13 = (String) r12.next();
        if (TextUtils.isEmpty(r13) == true) goto L8;
        if (r8.startsWith(r13) == false) goto L8;
        Integer r14 = (Integer) this.f13727j.get(r13);
        if (r14 == null) goto L21;
        int r15 = r14.intValue();
    L22:
        if (r15 <= 0) goto L24;
        this.f13729l.incrementAndGet();
        this.f13728k.put(r8, Integer.valueOf(r15));
    L24:
        return r15;
    L21:
        r15 = 0;
    L17:
        if (r10 == true) goto L21;
        if (defpackage.c.Q(r8, this.f13726i) == false) goto L21;
        r15 = this.f13725h;
        goto L22
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public final int getDispatchDelayTime(String r8, String r10) {
        return g7.j.e().a(r8, r10);
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public final boolean isAppDelayHandleEnable() {
        return this.f13722e;
    }

    @Override // com.bytedance.retrofit2.SsHttpCall.IHttpCallThrottleControl
    public final boolean isDispatchDelayEnabled() {
        return !g7.j.e().f7747f.isEmpty();
    }
}
