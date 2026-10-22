package k;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.bytedance.crash.dumper.Scraps;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends i0.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private BroadcastReceiver f9974l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private IntentFilter f9975m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f9976n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f9977o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f9978p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f9979q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f9980r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List<com.bytedance.apm.c.p> f9981s;

    class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f9982a;

        /* JADX INFO: renamed from: k.d$a$a, reason: collision with other inner class name */
        class RunnableC0212a implements Runnable {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final /* synthetic */ float f9983c;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ float f9984g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f9985h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ a f9986i;

            RunnableC0212a(a r10, float r11, float r12, String r13) {
                this.f9986i = r10;
                this.f9983c = r11;
                this.f9984g = r12;
                this.f9985h = r13;
            }

            @Override // java.lang.Runnable
            public void run() {
                JSONObject r10 = new JSONObject();     // Catch: Exception -> L21
                r10.put("battery_temperature", this.f9983c);     // Catch: Exception -> L21
                r10.put("remaining_energy", this.f9984g);     // Catch: Exception -> L21
                if (d.r(this.f9986i.f9982a) == false) goto L18;
                if (d.t(this.f9986i.f9982a) != null) goto L7;
            L12:
                JSONObject r11 = new JSONObject();     // Catch: Exception -> L21
                if (TextUtils.isEmpty(this.f9985h) == false) goto L15;
                String r12 = "background";
            L16:
                r11.put("scene", r12);     // Catch: Exception -> L21
                y.e r13 = new y.e("temperature", "", r10, r11, null);     // Catch: Exception -> L21
                i0.b.a(r13, false);     // Catch: Exception -> L21
                x.a.p().e(r13);     // Catch: Exception -> L21
                goto L18
            L15:
                r12 = this.f9985h;     // Catch: Exception -> L21
                goto L16
            L7:
                if (d.t(this.f9986i.f9982a).isEmpty() == true) goto L12;
                Iterator r14 = d.t(this.f9986i.f9982a).iterator();     // Catch: Exception -> L21
            L10:
                if (r14.hasNext() == false) goto L12;
                ((com.bytedance.apm.c.p) r14.next()).a(this.f9984g, this.f9983c, this.f9985h);     // Catch: Exception -> L21
            L18:
                if (d.s(this.f9986i.f9982a) == false) goto L25;
                e0.a.d("APM-BatteryLocal", r10.toString());     // Catch: Exception -> L21
                return;
            L25:
                return;
            }
        }

        a(d r10) {
            this.f9982a = r10;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            long r12 = SystemClock.elapsedRealtime();
            if ((r12 - d.o(this.f9982a)) <= (d.q(this.f9982a) * 1000)) goto L5;
            boolean r13 = true;
        L6:
            if (r13 == true) goto L8;
            return;
        L8:
            if (d.r(this.f9982a) == false) goto L10;
        L11:
            d.p(this.f9982a, r12);
            q0.b.f().i(new RunnableC0212a(this, r11.getIntExtra("temperature", 0) / 10.0f, (r11.getIntExtra("level", 0) * 100.0f) / r11.getIntExtra("scale", 100), ActivityLifeObserver.getInstance().getTopActivityClassName()));
            return;
        L10:
            if (d.s(this.f9982a) == true) goto L11;
            return;
        L5:
            r13 = false;
            goto L6
        }
    }

    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final d f9987a = null;

        static {
            f9987a = new d();
        }

        static /* synthetic */ d a() {
            return f9987a;
        }
    }

    public d() {
        this.f9977o = false;
        this.f9979q = 60;
        this.f9290j = Scraps.BATTERY;
    }

    static /* synthetic */ long o(d r10) {
        return r10.f9980r;
    }

    static /* synthetic */ long p(d r10, long r11) {
        r10.f9980r = r11;
        return r11;
    }

    static /* synthetic */ int q(d r10) {
        return r10.f9979q;
    }

    static /* synthetic */ boolean r(d r10) {
        return r10.f9977o;
    }

    static /* synthetic */ boolean s(d r10) {
        return r10.f9978p;
    }

    static /* synthetic */ List t(d r10) {
        return r10.f9981s;
    }

    public static d u() {
        return b.a();
    }

    private void w() {
        if (this.f9976n == false) goto L8;
        return;
    L8:
        com.bytedance.apm.d.g().registerReceiver(this.f9974l, this.f9975m);     // Catch: Exception -> L7
        this.f9976n = true;     // Catch: Exception -> L7
        return;
    }

    private void x() {
        if (this.f9976n == true) goto L8;
        return;
    L8:
        com.bytedance.apm.d.g().unregisterReceiver(this.f9974l);     // Catch: Exception -> L7
        this.f9976n = false;     // Catch: Exception -> L7
        return;
    }

    @Override // i0.a
    protected void c(JSONObject r10) {
        super.c(r10);
        boolean r11 = false;
        if (r10.optInt("temperature_enable_upload", 0) != 1) goto L5;
        r11 = true;
    L5:
        this.f9977o = r11;
        this.f9979q = r10.optInt("temperature_upload_interval", 60);
        if (this.f9977o == false) goto L8;
        return;
    L8:
        if (this.f9978p == true) goto L12;
        ActivityLifeObserver.getInstance().unregister(this);
        x();
        return;
    }

    @Override // i0.a
    protected boolean f() {
        return false;
    }

    @Override // i0.a
    protected void h() {
        this.f9974l = new a(this);
        this.f9975m = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        w();
    }

    @Override // i0.a
    protected long n() {
        return 0;
    }

    @Override // i0.a, t4.d
    public void onBackground(Activity r10) {
        super.onBackground(r10);
        x();
    }

    @Override // i0.a, t4.d
    public void onFront(Activity r10) {
        super.onFront(r10);
        w();
    }

    public void v(boolean r10) {
        this.f9978p = r10;
        d();
    }
}
