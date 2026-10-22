package androidx.emoji2.text;

import android.content.Intent;
import android.location.Location;
import com.obric.cae.libs.location.geofence.StarGeofence;
import com.obric.cae.location.geosdk.poi.StarAoiBoardManager;
import com.obric.cae.smartNetwork.SmartNetworkPolicyManager;
import com.obric.cae.smartNetwork.networkMonitor.HttpConnectionProbe;
import com.ttnet.org.chromium.base.Callback;
import com.ttnet.org.chromium.base.ObservableSupplierImpl;
import java.net.URL;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1764a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f1765b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f1766m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ Object f1767n;

    public /* synthetic */ g(Object r8, Object r10, Object r11, int r12) {
        this.f1764a = r12;
        this.f1765b = r8;
        this.f1766m = r10;
        this.f1767n = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f1764a) {
            case 0: goto L13;
            case 1: goto L11;
            case 2: goto L9;
            case 3: goto L7;
            case 4: goto L5;
            default: goto L30;
        };
    L5:
        HttpConnectionProbe.a((HttpConnectionProbe) this.f1765b, (URL) this.f1766m, (HttpConnectionProbe.HttpProbeListener) this.f1767n);
        return;
    L7:
        SmartNetworkPolicyManager.BatteryInfoReceiver.a((SmartNetworkPolicyManager.BatteryInfoReceiver) this.f1765b, (String) this.f1766m, (Intent) this.f1767n);
        return;
    L9:
        StarAoiBoardManager.e((StarAoiBoardManager) this.f1765b, (StarGeofence) this.f1766m, (Location) this.f1767n);
        return;
    L11:
        androidx.room.n r8 = (androidx.room.n) this.f1765b;
        a1.e r10 = (a1.e) this.f1766m;
        androidx.room.o r11 = (androidx.room.o) this.f1767n;
        he.i.f(r8, "this$0");
        he.i.f(r10, "$query");
        he.i.f(r11, "$queryInterceptorProgram");
        r10.a();
        throw null;
    L13:
        EmojiCompatInitializer.b r12 = (EmojiCompatInitializer.b) this.f1765b;
        f.h r13 = (f.h) this.f1766m;
        ThreadPoolExecutor r14 = (ThreadPoolExecutor) this.f1767n;
        r12.getClass();
        l r15 = c.a(r12.f1739a);     // Catch: Throwable -> L27
        if (r15 == null) goto L26;
        l.b r16 = (l.b) r15.f1759a;     // Catch: Throwable -> L27
        Object r17 = r16.f1790d;     // Catch: Throwable -> L27
        monitor-enter(r17);     // Catch: Throwable -> L27
        r16.f1792f = r14;     // Catch: Throwable -> L22
        monitor-exit(r17);     // Catch: Throwable -> L22
        r15.f1759a.a(new h(r13, r14));     // Catch: Throwable -> L27
        return;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L26:
        throw new RuntimeException("EmojiCompat font provider not available on this device.");     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        r13.a(th);
        r14.shutdown();
        return;
    L30:
        ObservableSupplierImpl r18 = (ObservableSupplierImpl) this.f1765b;
        Callback r19 = (Callback) this.f1767n;
        ObservableSupplierImpl.a(r18, this.f1766m, r19);
    }
}
