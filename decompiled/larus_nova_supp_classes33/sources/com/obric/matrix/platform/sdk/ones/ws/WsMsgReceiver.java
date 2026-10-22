package com.obric.matrix.platform.sdk.ones.ws;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsMsgReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "a", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public abstract class WsMsgReceiver extends BroadcastReceiver {

    public static final class a {
    }

    static {
    }

    public abstract void a();

    public WsMsgReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r7, Intent r8) {
        Objects.toString(r7);
        Objects.toString(r8);
        Serializable r0 = null;
        if (r8 == null) goto L5;
        Integer r1 = Integer.valueOf(r8.getIntExtra("channel_id", 0));
    L7:
        if (r8 == null) goto L9;
        Long r4 = Long.valueOf(r8.getLongExtra("seq_id", 0));
    L10:
        if (r8 == null) goto L12;
        Long r2 = Long.valueOf(r8.getLongExtra("log_id", 0));
    L13:
        if (r8 == null) goto L15;
        Integer r3 = Integer.valueOf(r8.getIntExtra("service", 0));
    L16:
        if (r8 == null) goto L18;
        Integer r9 = Integer.valueOf(r8.getIntExtra("method", 0));
    L19:
        if (r8 == null) goto L21;
        r0 = r8.getSerializableExtra("ws_headers");
    L21:
        if (r0 == null) goto L32;
        HashMap r5 = (HashMap) r0;
        if (r8 == null) goto L25;
        r8.getStringExtra("payload_type");
    L25:
        if (r8 == null) goto L27;
        r8.getStringExtra("payload_encoding");
    L27:
        if (r8 == null) goto L29;
        r8.getByteArrayExtra("payload");
    L29:
        Intrinsics.checkNotNull(r1);
        r1.intValue();
        Intrinsics.checkNotNull(r4);
        r4.longValue();
        Intrinsics.checkNotNull(r2);
        r2.longValue();
        Intrinsics.checkNotNull(r3);
        r3.intValue();
        Intrinsics.checkNotNull(r9);
        r9.intValue();
        a();
        return;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
    L18:
        r9 = null;
        goto L19
    L15:
        r3 = null;
        goto L16
    L12:
        r2 = null;
        goto L13
    L9:
        r4 = null;
        goto L10
    L5:
        r1 = null;
        goto L7
    }
}
