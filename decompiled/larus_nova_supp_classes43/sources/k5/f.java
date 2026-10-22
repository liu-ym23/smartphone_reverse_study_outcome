package k5;

import com.bytedance.ai.monitor.AppletMonitorableEvent;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ j b;
    public final /* synthetic */ long c;

    public /* synthetic */ f(String r1, j r10, long r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String r0 = this.a;
        j r1 = this.b;
        long r10 = this.c;
        AppletMonitorableEvent r11 = new AppletMonitorableEvent(r0, AppletMonitorableEvent.EventOrigin.Native);
        r1.a(r11);
        r11.d = true;
        r11.e = r10;
        com.bytedance.ai.monitor.b.c(r11);
    }
}
