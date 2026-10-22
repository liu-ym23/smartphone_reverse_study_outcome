package oh;

import android.app.Application;
import com.bytedance.pia.core.CompatEntry;
import com.bytedance.pia.core.spi.ConfigTask;
import com.bytedance.pia.core.utils.m;
import com.bytedance.vmsdk.worker.JsWorker;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f20573c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f20574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f20575b;

    static {
        f20573c = new c();
    }

    public c() {
        int r5 = 1;
        this.f20574a = System.currentTimeMillis();
        ConfigTask.get().run();
        nh.d.E = zg.b.f23438a.getApplicationContext();
        if (rh.h.f21760b == true) goto L15;
        if (rh.h.f21759a.compareAndSet(false, true) == false) goto L15;
        if (JsWorker.initialize() == false) goto L11;
        rh.h.f21760b = true;
        goto L15
    L11:
        String r10 = ak.a.a();
        JsWorker.preLoadPlugin(r10);
        if (JsWorker.initializeWithPlugin2(r10) == false) goto L15;
        rh.h.f21760b = true;
    L15:
        if (zg.b.f23439b != null) goto L21;
        com.bytedance.pia.core.bridge.methods.a r11 = new com.bytedance.pia.core.bridge.methods.a(9);
        if (zg.b.f23439b != null) goto L21;
        zg.b.f23439b = r11;
    L21:
        if (zg.b.f23440c != null) goto L26;
        com.bytedance.pia.core.bridge.methods.a r12 = new com.bytedance.pia.core.bridge.methods.a(10);
        if (zg.b.f23440c != null) goto L26;
        zg.b.f23440c = r12;
    L26:
        m.b(new f3.a(3));
        Application r13 = zg.b.f23438a;
        mh.c r14 = new mh.c(r5);
        nh.i r15 = nh.i.f20260b;
        nh.i r16 = r15.f20262a;
        if (r16 != null) goto L29;
        r15.f20262a = r14;
    L38:
        CompatEntry.class.getMethod("initialize", null).invoke(null, null);     // Catch: Throwable -> L37
    L35:
        this.f20575b = System.currentTimeMillis();
        return;
    L29:
        nh.i r17 = r16.f20262a;
    L30:
        nh.i r18 = r16;
        r16 = r17;
        if (r16 == null) goto L33;
        r17 = r16.f20262a;
        goto L30
    L33:
        r18.f20262a = r14;
        goto L38
    }
}
