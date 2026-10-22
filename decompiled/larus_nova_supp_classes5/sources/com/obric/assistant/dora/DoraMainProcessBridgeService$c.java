package com.obric.assistant.dora;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.link.IDoraLinkCallback;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class DoraMainProcessBridgeService$c implements IDoraLinkCallback {
    public final /* synthetic */ DoraMainProcessBridgeService a;

    public final void onBtConnectStateChanged(DoraDevice r1, int r2, int r3) {
    }

    public final void onBtStateChanged(int r1, int r2) {
    }

    public final void onDeviceFound(DoraDevice r1) {
    }

    public final void onScanFailed(int r1) {
    }

    public DoraMainProcessBridgeService$c(DoraMainProcessBridgeService r1) {
        this.a = r1;
    }

    public final void onDoraLinkStateChanged(DoraDevice r17, int r18, int r19) {
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("onDoraLinkStateChanged: prevState=");
        r4.append(r18);
        r4.append(", state=");
        r4.append(r19);
        r4.append(", device=");
        String r5 = null;
        if (r17 == null) goto L5;
        String r6 = r17.name;
    L6:
        r4.append(r6);
        r4.append(", mac=");
        if (r17 == null) goto L9;
        String r7 = r17.mac;
    L10:
        r4.append(r7);
        r4.append(", sn=");
        if (r17 == null) goto L13;
        r5 = r17.getSerialNumber();
    L13:
        r4.append(r5);
        r3.i("DoraMainProcessBridge", r4.toString());
        if (r17 == null) goto L16;
        DoraMainProcessBridgeService r8 = this.a;
        int r9 = DoraMainProcessBridgeService.i;
        r8.getClass();
        DoraDeviceInfo r1 = DoraMainProcessBridgeService.h(r17);
    L17:
        DoraMainProcessBridgeService r10 = this.a;
        r10.d.getClass();
        Intrinsics.checkNotNullParameter(r1, "deviceInfo");
        r10.d = new DoraMainProcessStateSnapshot(r19, r1);
        this.a.g(r19, r1);
        return;
    L16:
        r1 = new DoraDeviceInfo(null, null, null, null, 0, 0, null, 0, 0, 0, 0, 16383);
        goto L17
    L9:
        r7 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }
}
