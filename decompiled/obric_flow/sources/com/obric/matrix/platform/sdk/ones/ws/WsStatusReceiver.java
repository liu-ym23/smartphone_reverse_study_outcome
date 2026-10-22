package com.obric.matrix.platform.sdk.ones.ws;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsStatusReceiver;", "Landroid/content/BroadcastReceiver;", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class WsStatusReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function4 f11905a;

    public WsStatusReceiver(Function4 r5) {
        Intrinsics.checkNotNullParameter(r5, "listener");
        this.f11905a = r5;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r5, Intent r10) {
        Log.d("WsStatusReceiver", "onReceive() called with: context = " + r5 + ", intent = " + r10);
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
        Intrinsics.checkNotNull(r13);
        Intrinsics.checkNotNull(r14);
        Intrinsics.checkNotNull(r12);
        Intrinsics.checkNotNull(r11);
        this.f11905a.invoke(r13, r14, r12, r11);
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
