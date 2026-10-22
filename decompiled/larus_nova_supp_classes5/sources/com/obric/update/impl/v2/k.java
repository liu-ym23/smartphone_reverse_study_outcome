package com.obric.update.impl.v2;

import android.net.ConnectivityManager;
import android.net.Network;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ ObricUpdateBitImpl a;

    public k(ObricUpdateBitImpl r1) {
        this.a = r1;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network r3) {
        Intrinsics.checkNotNullParameter(r3, "network");
        FLogger.a.i("ObricUpdateBitImpl", "networkCallback: onAvailable");
        ObricUpdateBitImpl r4 = this.a;
        int r0 = ObricUpdateBitImpl.i;
        r4.q().h(this.a.p().g);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network r3) {
        Intrinsics.checkNotNullParameter(r3, "network");
        FLogger.a.i("ObricUpdateBitImpl", "networkCallback: onLost");
        ObricUpdateBitImpl r4 = this.a;
        int r0 = ObricUpdateBitImpl.i;
        r4.q().h(this.a.p().g);
    }
}
