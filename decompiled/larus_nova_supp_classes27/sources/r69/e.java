package r69;

import android.content.Context;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.resource.DoraResourceDeviceType;
import com.larus.dora.impl.resource.j0;
import com.larus.utils.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ DoraDevice b;
    public final /* synthetic */ String c;

    public /* synthetic */ e(Context r1, DoraDevice r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context r6 = this.a;
        DoraDevice r7 = this.b;
        String r8 = this.c;
        i r9 = i.a;
        monitor-enter(r9);
        g49.d.a("DoraWearToastFactory", "toast util dismiss");     // Catch: Throwable -> L12
        t0.e(new g());     // Catch: Throwable -> L12
        monitor-exit(r9);
        j0 r0 = j0.a;
        DoraResourceDeviceType r2 = DoraResourceDeviceType.G1;
        boolean r1 = v19.h.a;
        if (v19.h.a(null) == false) goto L9;
        String r3 = "larus_icon_dora_g_wear_detection_dark";
    L10:
        c r10 = new c(j0.f(r0, r6, r2, r3, null, 24), o59.a.d(r7), r8);
        r9.a(r10);
        g49.d.a("DoraWearToastFactory", "toast utils show headphone mode");
        r10.show(r6, false);
        return;
    L9:
        r3 = "larus_icon_dora_g_wear_detection";
    L12:
        th = move-exception;
        throw th;
    }
}
