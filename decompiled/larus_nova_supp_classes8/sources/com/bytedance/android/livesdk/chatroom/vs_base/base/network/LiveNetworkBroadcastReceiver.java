package com.bytedance.android.livesdk.chatroom.vs_base.base.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveNetworkBroadcastReceiver extends BroadcastReceiver {
    public WeakReference<Context> a;
    public NetworkUtils.NetworkType b;
    public final Map<WeakReference<a>, Cert> c;

    public interface a {
        void a(NetworkUtils.NetworkType r1);
    }

    static {
        TokenCert.with("bpea-livenetworkbroadcastceceiver_get_network_type");
    }

    public LiveNetworkBroadcastReceiver() {
        this.b = NetworkUtils.NetworkType.NONE;
        this.c = new HashMap();
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r4, Intent r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.getAction() != null) goto L6;
        return;
    L6:
        if (r5.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE") == false) goto L24;
        NetworkUtils.NetworkType r6 = this.b;
        Iterator r0 = ((HashMap) this.c).entrySet().iterator();
    L9:
        if (r0.hasNext() == false) goto L25;
        Map.Entry r1 = (Map.Entry) r0.next();
        a r2 = (a) ((WeakReference) r1.getKey()).get();
        if (r2 == null) goto L9;
        NetworkUtils.NetworkType r3 = NetworkUtils.b(r4, (Cert) r1.getValue());
        this.b = r3;
        if (r6 == r3) goto L9;
        r2.a(r3);
        goto L9
    L25:
        return;
    }
}
