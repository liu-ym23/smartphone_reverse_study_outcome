package com.obric.matrix.platform.sdk.ones.ws;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.bytedance.common.wschannel.WsConstants;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/ws/WsMsgReceiver;", "Landroid/content/BroadcastReceiver;", "<init>", "()V", "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class WsMsgReceiver extends BroadcastReceiver {
    public WsMsgReceiver() {
    }

    public abstract void a();

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r10, Intent r11) {
        Log.d("WsMsgReceiver", "onReceive() called with: context = " + r10 + ", intent = " + r11);
        Serializable r5 = null;
        if (r11 == null) goto L5;
        Integer r12 = Integer.valueOf(r11.getIntExtra(WsConstants.KEY_CHANNEL_ID, 0));
    L7:
        if (r11 == null) goto L9;
        Long r13 = Long.valueOf(r11.getLongExtra("seq_id", 0));
    L10:
        if (r11 == null) goto L12;
        Long r14 = Long.valueOf(r11.getLongExtra("log_id", 0));
    L13:
        if (r11 == null) goto L15;
        Integer r15 = Integer.valueOf(r11.getIntExtra(NotificationCompat.CATEGORY_SERVICE, 0));
    L16:
        if (r11 == null) goto L18;
        Integer r16 = Integer.valueOf(r11.getIntExtra("method", 0));
    L19:
        if (r11 == null) goto L21;
        r5 = r11.getSerializableExtra("ws_headers");
    L21:
        if (r5 == null) goto L32;
        HashMap r17 = (HashMap) r5;
        if (r11 == null) goto L25;
        r11.getStringExtra("payload_type");
    L25:
        if (r11 == null) goto L27;
        r11.getStringExtra("payload_encoding");
    L27:
        if (r11 == null) goto L29;
        r11.getByteArrayExtra("payload");
    L29:
        Intrinsics.checkNotNull(r12);
        r12.getClass();
        Intrinsics.checkNotNull(r13);
        r13.getClass();
        Intrinsics.checkNotNull(r14);
        r14.getClass();
        Intrinsics.checkNotNull(r15);
        r15.getClass();
        Intrinsics.checkNotNull(r16);
        r16.getClass();
        a();
        return;
    L32:
        throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>{ kotlin.collections.TypeAliasesKt.HashMap<kotlin.String, kotlin.String> }");
    L18:
        r16 = null;
        goto L19
    L15:
        r15 = null;
        goto L16
    L12:
        r14 = null;
        goto L13
    L9:
        r13 = null;
        goto L10
    L5:
        r12 = null;
        goto L7
    }
}
