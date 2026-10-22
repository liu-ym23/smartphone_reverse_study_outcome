package i84;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.bdinstall.t;
import com.bytedance.common.utility.NetworkUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class k extends BroadcastReceiver {
    public final /* synthetic */ l a;

    public k(l r1) {
        this.a = r1;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r1, Intent r2) {
        l.d = NetworkUtils.getNetworkType(this.a.a);
        t.a("NetworkStatusProvider init broadcast receive that network type is " + l.d.name());
    }
}
