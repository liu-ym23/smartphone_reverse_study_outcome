package com.larus.bmhome.taskskill.interaction;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.larus.bmhome.taskskill.model.PcDevice;
import com.larus.utils.logger.FLogger;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a implements com.larus.platform.api.a {
    public final /* synthetic */ PcDevice a;
    public final /* synthetic */ PcDeviceSelectionHandler b;
    public final /* synthetic */ Context c;
    public final /* synthetic */ CoroutineScope d;

    public final void onSuccess(String r9, String r10) {
        FLogger.a.i("PcDeviceSelectionHandler", "[startMfaVerify] success, deviceId=" + this.a.getDeviceId() + ", verifyWay=" + r9);
        this.b.a(this.c, this.d, this.a, r10, false);
    }

    public final void a(int r4, String r5, Throwable r6) {
        PcDeviceSelectionHandler.a r0 = this.b.b;
        if (r0 == null) goto L5;
        r0.b(null);
    L5:
        FLogger.a.w("PcDeviceSelectionHandler", "[startMfaVerify] failed, deviceId=" + this.a.getDeviceId() + ", code=" + r4 + ", msg=" + r5, r6);
    }

    public a(PcDevice r1, PcDeviceSelectionHandler r2, Context r3, LifecycleCoroutineScope r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
