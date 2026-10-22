package ct1;

import com.bytedance.android.live.core.utils.NetworkUtils;
import com.bytedance.android.livesdk.utils.LiveNetworkBroadcastReceiver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d implements LiveNetworkBroadcastReceiver.a {
    public final /* synthetic */ b a;

    public d(b r1) {
        this.a = r1;
    }

    public final void a(NetworkUtils.NetworkType r3) {
        if (r3 != NetworkUtils.NetworkType.NONE) goto L8;
        b.CountDownTimerC0377b r4 = this.a.c;
        if (r4 == null) goto L7;
        r4.cancel();
    L7:
        this.a.d = 2;
        return;
    L8:
        b r5 = this.a;
        r5.a(r5.b);
    }
}
