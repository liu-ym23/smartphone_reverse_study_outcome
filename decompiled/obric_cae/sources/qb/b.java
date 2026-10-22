package qb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import ge.r;
import he.i;
import xd.j;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r<Integer, Integer, Integer, Boolean, j> f11290a;

    public b(a.C0143a r8) {
        i.f(r8, "listener");
        this.f11290a = r8;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r8, Intent r10) {
        Log.d("WsStatusReceiver", "onReceive() called with: context = " + r8 + ", intent = " + r10);
        Boolean r11 = null;
        if (r10 == null) goto L5;
        Integer r12 = Integer.valueOf(r10.getIntExtra("ws_status_channel_id", 0));
    L6:
        if (r10 == null) goto L8;
        Integer r13 = Integer.valueOf(r10.getIntExtra("ws_status_channel_type", 0));
    L9:
        if (r10 == null) goto L11;
        Integer r14 = Integer.valueOf(r10.getIntExtra("ws_connection_state", 0));
    L12:
        if (r10 == null) goto L14;
        r11 = Boolean.valueOf(r10.getBooleanExtra("ws_is_connected", false));
    L14:
        i.c(r13);
        i.c(r14);
        i.c(r12);
        i.c(r11);
        this.f11290a.d(r13, r14, r12, r11);
        return;
    L11:
        r14 = null;
        goto L12
    L8:
        r13 = null;
        goto L9
    L5:
        r12 = null;
        goto L6
    }
}
