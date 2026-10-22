package com.obric.matrix.platform.sdk.ones.ws;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsStatusReceiver;", "Landroid/content/BroadcastReceiver;", "a", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public class WsStatusReceiver extends BroadcastReceiver {
    public final Function4<Integer, Integer, Integer, Boolean, Unit> a;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WsStatusReceiver(Function4<? super Integer, ? super Integer, ? super Integer, ? super Boolean, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a = r2;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r5, Intent r6) {
        Objects.toString(r5);
        Objects.toString(r6);
        Boolean r0 = null;
        if (r6 == null) goto L5;
        Integer r1 = Integer.valueOf(r6.getIntExtra("ws_status_channel_id", 0));
    L6:
        if (r6 == null) goto L8;
        Integer r2 = Integer.valueOf(r6.getIntExtra("ws_status_channel_type", 0));
    L9:
        if (r6 == null) goto L11;
        Integer r3 = Integer.valueOf(r6.getIntExtra("ws_connection_state", 0));
    L12:
        if (r6 == null) goto L14;
        r0 = Boolean.valueOf(r6.getBooleanExtra("ws_is_connected", false));
    L14:
        Function4<Integer, Integer, Integer, Boolean, Unit> r7 = this.a;
        Intrinsics.checkNotNull(r2);
        Intrinsics.checkNotNull(r3);
        Intrinsics.checkNotNull(r1);
        Intrinsics.checkNotNull(r0);
        r7.invoke(r2, r3, r1, r0);
        return;
    L11:
        r3 = null;
        goto L12
    L8:
        r2 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
    }
}
