package com.larus.dora.impl.device.settings.general;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(DoraDevice r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r4, "device");
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).sendBroadcast(new Intent("com.larus.dora.impl.action.WEAR_DETECTION_CHANGED").putExtra("device_serial_number", r4.getSerialNumber()).putExtra("device_mac", r4.mac).putExtra("enabled", r5));
    }
}
