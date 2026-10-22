package com.larus.dora.impl.core;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.trace.DarEvent;
import com.larus.platform.service.AccountService;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class j0 implements Function0 {
    public final /* synthetic */ DoraLinkReceiver a;
    public final /* synthetic */ Intent b;

    public /* synthetic */ j0(DoraLinkReceiver r1, Context r2, Intent r3) {
        this.a = r1;
        this.b = r3;
    }

    public final Object invoke() {
        DoraLinkReceiver r0 = this.a;
        Intent r1 = this.b;
        int r2 = DoraLinkReceiver.a;
        r0.getClass();
        DoraSetting.a.getClass();
        if (DoraSetting.f() == true) goto L5;
        g49.d.d("DoraLinkReceiver", "onReceive " + r1.getAction() + ", DoraSetting enableDoraFeature is false");
        return null;
    L5:
        List r3 = DoraAdapterExtKt.j(kj4.a.g());
        g49.d.d("DoraLinkReceiver", "onReceive: d(" + r3.size() + ")" + r1.getAction() + ", " + r1.getExtras());
        byte r6 = 0;
        if (DoraSetting.j().e() == false) goto L14;
        int r4 = r1.getIntExtra("android.bluetooth.adapter.extra.STATE", 10);
        g49.d.d("DoraLinkReceiver", "btStateChanged: " + r4);
        if (r4 != 11) goto L11;
        DarEvent r5 = DarEvent.BluetoothTurnOn;
        r5.setMessage("manual turn open bluetooth");
        r5.getExtra().put("status", 0);
        com.larus.dora.impl.trace.a.a(r5);
        goto L14
    L11:
        if (r4 != 13) goto L14;
        DarEvent r7 = DarEvent.BluetoothTurnOFF;
        r7.setMessage("manual turn off bluetooth");
        r7.getExtra().put("status", 1);
        com.larus.dora.impl.trace.a.a(r7);
    L14:
        if (r3.isEmpty() == true) goto L68;
        int r8 = kj4.a.g().isReady();     // Catch: Throwable -> L62
        String r10 = r1.getAction();     // Catch: Throwable -> L62
        switch(r10.hashCode()) {
            case -1530327060: goto L31;
            case -1184851779: goto L28;
            case -301431627: goto L25;
            case 1123270207: goto L22;
            case 1821585647: goto L19;
            default: goto L33;
        };     // Catch: Throwable -> L62
    L33:
        r6 = -1;
    L34:
        if (r6 != 0) goto L36;
        g49.d.d("DoraLinkReceiver", "btStateChanged: " + r1.getIntExtra("android.bluetooth.adapter.extra.STATE", 10));     // Catch: Throwable -> L62
        return null;
    L36:
        if (r6 == 1) goto L49;
        if (r6 != 2) goto L79;
        BluetoothDevice r9 = (BluetoothDevice) r1.getParcelableExtra("android.bluetooth.device.extra.DEVICE");     // Catch: Throwable -> L62
        if (r9 == null) goto L69;
        if (r8 == 0) goto L44;
        if (r8 == 3) goto L44;
        return null;
    L44:
        if (r3.contains(DoraDevice.from(r9)) == true) goto L46;
        return null;
    L46:
        if (AccountService.a.isLogin().booleanValue() == false) goto L48;
        i0.a.a.i(3, r9.getAddress());     // Catch: Throwable -> L62
        return null;
    L48:
        g49.d.d("DoraLinkReceiver", "user not login, won't to link device");     // Catch: Throwable -> L62
        return null;
    L69:
        return null;
    L79:
        return null;
    L49:
        int r11 = r1.getIntExtra("android.bluetooth.adapter.extra.CONNECTION_STATE", 10);     // Catch: Throwable -> L62
        int r12 = r1.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE", 10);     // Catch: Throwable -> L62
        BluetoothDevice r13 = (BluetoothDevice) r1.getParcelableExtra("android.bluetooth.device.extra.DEVICE");     // Catch: Throwable -> L62
        g49.d.d("DoraLinkReceiver", "btConnectionStateChanged: " + r12 + " -> " + r11);     // Catch: Throwable -> L62
        if (r11 == 1) goto L52;
        if (r11 == 2) goto L52;
        return null;
    L52:
        if (r8 == 0) goto L55;
        if (r8 == 3) goto L55;
        return null;
    L55:
        if (r3.contains(DoraDevice.from(r13)) == true) goto L57;
        return null;
    L57:
        if (AccountService.a.isLogin().booleanValue() == false) goto L59;
        i0.a.a.i(2, r13.getAddress());     // Catch: Throwable -> L62
        return null;
    L59:
        g49.d.d("DoraLinkReceiver", "user not login, won't to link device");     // Catch: Throwable -> L62
        return null;
    L19:
        if (r10.equals("android.bluetooth.device.action.ACL_DISCONNECTED") == false) goto L33;
        r6 = 3;
        goto L34
    L22:
        if (r10.equals("android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED") == false) goto L33;
        r6 = 1;
        goto L34
    L25:
        if (r10.equals("android.bluetooth.device.action.ACL_CONNECTED") == false) goto L33;
        r6 = 2;
        goto L34
    L28:
        if (r10.equals("android.location.PROVIDERS_CHANGED") == false) goto L33;
        r6 = 4;
        goto L34
    L31:
        if (r10.equals("android.bluetooth.adapter.action.STATE_CHANGED") == false) goto L33;
    L62:
        th = move-exception;
        th.printStackTrace();
        return null;
    L68:
        return null;
    }
}
