package bsb;

import android.os.Build;
import com.ss.android.lark.monitor.callback.DevicePerfManager;
import com.ss.android.lark.monitor.downgrade.DowngradeSetting;
import com.ss.android.lark.monitor.temperature.TemperaturePerfMonitor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class k implements TemperaturePerfMonitor.d {
    public final /* synthetic */ DevicePerfManager a;

    public k(DevicePerfManager r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.monitor.temperature.TemperaturePerfMonitor.d
    public final void a(float r6) {
        DevicePerfManager r0 = this.a;
        r0.e.j = r6;
        if (Build.VERSION.SDK_INT < 29) goto L5;
        return;
    L5:
        DowngradeSetting.c.a r1 = r0.g;
        boolean r3 = false;
        if (r6 <= r1.HIGH_TEMPERATURE) goto L9;
        int r2 = 3;
    L16:
        if (r6 <= r1.LIGHT_TEMPERATURE) goto L18;
        r3 = true;
    L18:
        r0.c(r3, r2);
        return;
    L9:
        if (r6 <= r1.MIDDLE_TEMPERATURE) goto L12;
        r2 = 2;
        goto L16
    L12:
        if (r6 <= r1.LIGHT_TEMPERATURE) goto L14;
        r2 = 1;
        goto L16
    L14:
        r2 = 0;
        goto L16
    }

    @Override // com.ss.android.lark.monitor.temperature.TemperaturePerfMonitor.d
    public final void onThermalStatusChanged(int r4) {
        boolean r0 = false;
        int r5 = Math.max(0, r4);
        if (r5 < 1) goto L5;
        r0 = true;
    L5:
        this.a.c(r0, Math.min(r5, 3));
    }
}
