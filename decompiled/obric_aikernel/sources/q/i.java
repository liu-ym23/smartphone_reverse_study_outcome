package q;

import android.app.usage.NetworkStatsManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class i extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long[] f12416e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Method f12417f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object f12418g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f12419h;

    public i() {
        super("traffic_all_interface");
        this.f12419h = false;
    }

    @RequiresApi(api = 23)
    private long[] i() {
        if (this.f12417f != null) goto L10;
        NetworkStatsManager r10 = (NetworkStatsManager) com.bytedance.apm.d.g().getSystemService("netstats");
        Field r11 = r10.getClass().getDeclaredField("mService");
        r11.setAccessible(true);
        Object r12 = r11.get(r10);
        this.f12418g = r12;
        Method[] r13 = r12.getClass().getDeclaredMethods();
        int r14 = r13.length;
        int r15 = 0;
    L5:
        if (r15 >= r14) goto L10;
        Method r16 = r13[r15];
        if (TextUtils.equals("getDataLayerSnapshotForUid", r16.getName()) == true) goto L8;
        r15 = r15 + 1;
        goto L5
    L8:
        this.f12417f = r16;
        r16.setAccessible(true);
    L10:
        Object r17 = this.f12417f.invoke(this.f12418g, new Object[]{Integer.valueOf(Process.myUid())});
        Field r18 = r17.getClass().getDeclaredField("rxBytes");
        r18.setAccessible(true);
        long[] r19 = (long[]) r18.get(r17);
        Field r20 = r17.getClass().getDeclaredField("txBytes");
        r20.setAccessible(true);
        long[] r21 = (long[]) r20.get(r17);
        Field r22 = r17.getClass().getDeclaredField("rxPackets");
        r22.setAccessible(true);
        long[] r23 = (long[]) r22.get(r17);
        Field r24 = r17.getClass().getDeclaredField("txPackets");
        r24.setAccessible(true);
        return new long[]{k(r19) + k(r21), k(r23) + k((long[]) r24.get(r17))};
    }

    private void j(boolean r12, long r13, String r15, String r16) {
        if (r13 < 0) goto L5;
        p.a.h().l(new b0.a(r12, System.currentTimeMillis(), "traffic_all_interface", this.f12394b, r13, r16, r15));
        return;
    L5:
        if (com.bytedance.apm.d.D() == false) goto L7;
        e0.e.d(e0.b.f8548b, new String[]{"BatteryTrafficAllInterface value error: " + r13});
    L7:
        e0.a.d("APM-Battery", "BatteryTrafficAllInterface value error: " + r13);
    }

    private long k(long[] r10) {
        long r11 = 0;
        if (r10 != null) goto L5;
    L10:
        return r11;
    L5:
        if (r10.length == 0) goto L10;
        int r12 = r10.length;
        int r13 = 0;
    L8:
        if (r13 >= r12) goto L10;
        r11 = r11 + r10[r13];
        r13 = r13 + 1;
        goto L8
    }

    @Override // q.b
    protected void c(boolean r10, boolean r11) {
        if (g() == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 23) goto L21;
        return;
    L21:
        long[] r12 = i();     // Catch: Throwable -> L13
        if (this.f12416e == null) goto L11;
        if (r11 == false) goto L11;
        String r13 = k.a.G().E();     // Catch: Throwable -> L13
        j(r10, r12[0] - this.f12416e[0], "source_bytes", r13);     // Catch: Throwable -> L13
        j(r10, r12[1] - this.f12416e[1], "source_packets", r13);     // Catch: Throwable -> L13
    L11:
        this.f12416e = r12;     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        if (com.bytedance.apm.d.D() == false) goto L18;
        e0.e.d(e0.b.f8548b, new String[]{"handleTrafficMonitor error: " + th.getCause()});
    L18:
        if (this.f12419h == true) goto L25;
        t4.a.d(th, "BatteryTrafficAllInterface");
        this.f12419h = true;
        return;
    }

    @Override // q.l
    public void e(p.b r10, b0.a r11) {
        if (r11.k() == false) goto L11;
        if (TextUtils.equals(r11.e(), "source_bytes") == false) goto L8;
        r10.k(r11.a());
        return;
    L8:
        if (TextUtils.equals(r11.e(), "source_packets") == false) goto L18;
        r10.o(r11.a());
        return;
    L18:
        return;
    L11:
        if (TextUtils.equals(r11.e(), "source_bytes") == false) goto L14;
        r10.a(r11.a());
        return;
    L14:
        if (TextUtils.equals(r11.e(), "source_packets") == false) goto L21;
        r10.e(r11.a());
        return;
    }
}
