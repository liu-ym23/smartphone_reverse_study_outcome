package com.larus.dora.impl.dynamic;

import android.text.TextUtils;
import com.bytedance.dora.device.DoraDevice;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class i0 implements Runnable {
    public final /* synthetic */ DoraDynamicFragment a;
    public final /* synthetic */ DoraDynamicViewModelV2.f b;

    public i0(DoraDynamicFragment r1, DoraDynamicViewModelV2.f r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        DoraDynamicFragment r0 = this.a;
        if (r0.f == null) goto L9;
        DoraDynamicViewModelV2.f r1 = this.b;
        DoraDevice r2 = r0.p;
        if (r2 != null) goto L7;
    L8:
        StringBuilder r3 = new StringBuilder("device connected, load data : ");
        DoraDynamicViewModelV2.f.a r4 = (DoraDynamicViewModelV2.f.a) r1;
        r3.append(r4.b.mac);
        g49.d.d("DoraDynamicFragment", r3.toString());
        r0.da0(r4.b.mac, "state:DeviceStateV2.Connected");
        goto L9
    L7:
        if (TextUtils.equals(r2.mac, ((DoraDynamicViewModelV2.f.a) r1).b.mac) == true) goto L8;
    L9:
        this.a.ea0();
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
