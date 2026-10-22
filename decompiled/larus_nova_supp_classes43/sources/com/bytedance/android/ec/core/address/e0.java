package com.bytedance.android.ec.core.address;

import com.bytedance.bdlocation.BDLocation;
import com.bytedance.bdlocation.callback.BDLocationCallback;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e0 implements BDLocationCallback {
    public final /* synthetic */ wi.b a;

    public e0(m r1) {
        this.a = r1;
    }

    public final void onError(BDLocationException r10) {
        if (r10 == null) goto L5;
        this.a.onFailure(r10);
        return;
    }

    public final void onLocationChanged(BDLocation r20) {
        ArrayList r10 = new ArrayList();
        Object[] r11 = {r20};
        f06.b r12 = new f06.b();
        g06.a r0 = (g06.a) ApiHookConfig.b.get(101330);
        if (r0 == null) goto L5;
        f06.a[] r1 = r0.i;
    L6:
        f06.a[] r13 = r1;
        int r14 = r13.length;
        int r15 = 0;
    L8:
        if (r15 >= r14) goto L15;
        f06.a r16 = r13[r15];
        int r17 = r15;
        int r18 = r14;
        f06.a[] r19 = r13;
        f06.d r21 = r16.preInvoke(101330, "com/bytedance/android/ec/core/address/DefaultLocationHostService$tryToLocate$1", "onLocationChanged", this, r11, "void", r12);     // Catch: Exception -> L23
        if (r21.a == true) goto L17;
        r10.add(r16);     // Catch: Exception -> L23
    L17:
        if (r21.a == false) goto L19;
        return;
    L19:
        if (r20 != null) goto L21;
        this.a.onFailure(new Throwable("result is null"));
        return;
    L21:
        this.a.a(new wi.a(r20.getLatitude(), r20.getLongitude()));
        return;
    L14:
        r15 = r17 + 1;
        r14 = r18;
        r13 = r19;
        goto L8
    L15:
        r21 = new f06.d(false, null);
        goto L17
    L5:
        r1 = ApiHookConfig.d;
        goto L6
    }
}
