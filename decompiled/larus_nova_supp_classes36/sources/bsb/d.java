package bsb;

import com.ss.android.lark.monitor.callback.DevicePerfManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ DevicePerfManager a;
    public final /* synthetic */ DevicePerfManager.c b;
    public final /* synthetic */ DevicePerfManager.PerfType c;

    public /* synthetic */ d(DevicePerfManager r1, DevicePerfManager.c r2, DevicePerfManager.PerfType r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DevicePerfManager r0 = this.a;
        DevicePerfManager.c r1 = this.b;
        DevicePerfManager.PerfType r2 = this.c;
        r0.getClass();
        if (r2 != DevicePerfManager.PerfType.CPU) goto L6;
        int r3 = r0.e.e;
    L12:
        r1.a(r3);
        return;
    L6:
        if (r2 != DevicePerfManager.PerfType.MEMORY) goto L8;
        r3 = r0.e.g;
        goto L12
    L8:
        DevicePerfManager.PerfType r4 = DevicePerfManager.PerfType.TEMPERATURE;
        c r5 = r0.e;
        if (r2 != r4) goto L11;
        r3 = r5.c;
        goto L12
    L11:
        r3 = r5.a;
        goto L12
    }
}
