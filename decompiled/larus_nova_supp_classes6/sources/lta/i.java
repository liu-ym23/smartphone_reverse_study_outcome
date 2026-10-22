package lta;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bytedance.common.utility.NetworkUtils;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class i extends BroadcastReceiver {
    public boolean a;
    public final /* synthetic */ h.b b;

    public i(h.b r1) {
        this.b = r1;
        this.a = true;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r2, Intent r3) {
        if (this.a == false) goto L6;
        this.a = false;
        return;
    L6:
        if (r3 != null) goto L9;
        return;
    L9:
        if (r3.getBooleanExtra("noConnectivity", false) == false) goto L12;
        return;
    L12:
        if (NetworkUtils.isNetworkAvailable(this.b.c) == false) goto L19;
        Iterator<WeakReference<h.b.a>> r4 = this.b.a.iterator();
    L15:
        if (r4.hasNext() == false) goto L25;
        h.b.a r5 = r4.next().get();
        if (r5 == null) goto L15;
        r5.onNetworkReady();
        goto L15
    L25:
        return;
    }
}
