package com.larus.dora.dorag.res;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/larus/dora/dorag/res/DoraByteCastManager$registerWifiStateReceiver$receiver$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "dorag-res_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraByteCastManager$registerWifiStateReceiver$receiver$1 extends BroadcastReceiver {
    public static final /* synthetic */ int b = 0;
    public final /* synthetic */ DoraByteCastManager a;

    public DoraByteCastManager$registerWifiStateReceiver$receiver$1(DoraByteCastManager r1) {
        this.a = r1;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r2, Intent r3) {
        if (r3 == null) goto L4;
        String r4 = r3.getAction();
    L6:
        if (Intrinsics.areEqual(r4, "android.net.wifi.WIFI_STATE_CHANGED") == true) goto L8;
        return;
    L8:
        int r5 = r3.getIntExtra("wifi_state", 4);
        if (r5 != 1) goto L11;
        final DoraByteCastManager r6 = this.a;
        DoraByteCastManager.n(r6, new i(r6));
        return;
    L11:
        if (r5 != 3) goto L17;
        final DoraByteCastManager r7 = this.a;
        DoraByteCastManager.n(r7, new h(r7));
        return;
    L17:
        return;
    L4:
        r4 = null;
        goto L6
    }
}
