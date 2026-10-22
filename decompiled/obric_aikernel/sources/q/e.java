package q;

import android.os.BatteryManager;
import android.os.Build;
import androidx.annotation.RequiresApi;

/* JADX INFO: loaded from: classes.dex */
public class e extends b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BatteryManager f12408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f12409f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f12410g;

    @RequiresApi(api = 21)
    public e() {
        super("battery_consume");
        this.f12409f = false;
        this.f12410g = -1;
        this.f12408e = (BatteryManager) com.bytedance.apm.d.g().getSystemService("batterymanager");
    }

    private void i(boolean r10, boolean r11) {
        if (Build.VERSION.SDK_INT < 21) goto L12;
        int r12 = this.f12408e.getIntProperty(1);
        if (r11 == true) goto L10;
        if (r10 == false) goto L10;
        if (this.f12409f == false) goto L10;
        h(true, Math.abs(r12 - this.f12410g), k.a.G().E());
    L10:
        this.f12410g = r12;
        this.f12409f = true;
        return;
    }

    @Override // q.b
    protected void c(boolean r10, boolean r11) {
        if (g() == true) goto L6;
        return;
    L6:
        if (r10 == true) goto L21;
    L13:
        boolean r12 = true;
    L14:
        i(r11, r12);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        if (com.bytedance.apm.d.D() == false) goto L19;
        e0.e.d(e0.b.f8548b, new String[]{"BatteryConsumeStatsImpl error: " + th.getCause()});
    L19:
        t4.a.a("BatteryConsumeStatsImpl");
        return;
    L21:
        if (this.f12394b == true) goto L13;
        r12 = false;
        goto L14
    }

    @Override // q.l
    public void e(p.b r10, b0.a r11) {
        r10.j(r11.a() / 1000);
    }
}
