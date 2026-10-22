package com.obric.assistant.dora;

import com.bytedance.dora.device.DoraDevice;
import com.larus.utils.logger.FLogger;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import mj4.b;
import mj4.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class DoraMainProcessBridgeService$b implements h {
    public final /* synthetic */ DoraMainProcessBridgeService a;

    public final void J(byte[] r1) {
    }

    public final /* synthetic */ void N(int r1, int r2) {
    }

    public final void N0(DoraDevice r1, int[] r2) {
    }

    public final /* synthetic */ void P0(DoraDevice r1, int[] r2) {
    }

    public final /* synthetic */ void Y(int r1, int r2, int r3) {
    }

    public final void a0(DoraDevice r1, int[] r2) {
    }

    public final void a1(DoraDevice r1, b r2) {
    }

    public final /* synthetic */ void d1(DoraDevice r1, int r2) {
    }

    public final void e1(DoraDevice r1, int[] r2) {
    }

    public final void f1(int r1, byte r2) {
    }

    public final /* synthetic */ void l1(DoraDevice r1) {
    }

    public final /* synthetic */ void p(int r1) {
    }

    public final void u(DoraDevice r1, int r2) {
    }

    public final /* synthetic */ void y(DoraDevice r1, int r2, byte[] r3) {
    }

    public final /* synthetic */ void y0(DoraDevice r1, int[] r2) {
    }

    public DoraMainProcessBridgeService$b(DoraMainProcessBridgeService r1) {
        this.a = r1;
    }

    public final void D(DoraDevice r3, int[] r4) {
        DoraMainProcessBridgeService r0 = this.a;
        int r1 = DoraMainProcessBridgeService.i;
        r0.getClass();
        DoraDeviceInfo r5 = DoraDeviceInfo.a(DoraMainProcessBridgeService.h(r3), r4, null, 16375);
        DoraMainProcessBridgeService r6 = this.a;
        int r2 = r6.d.a;
        Intrinsics.checkNotNullParameter(r5, "deviceInfo");
        r6.d = new DoraMainProcessStateSnapshot(r2, r5);
        this.a.f(r5);
    }

    public final void b0(DoraDevice r5, int[] r6) {
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onBatteryChanged: device=");
        r1.append(r5.name);
        r1.append(", mac=");
        r1.append(r5.mac);
        r1.append(", sn=");
        r1.append(r5.getSerialNumber());
        r1.append(", battery=");
        if (r6 == null) goto L5;
        String r3 = Arrays.toString(r6);
    L6:
        r1.append(r3);
        r0.i("DoraMainProcessBridge", r1.toString());
        DoraMainProcessBridgeService r2 = this.a;
        int r4 = DoraMainProcessBridgeService.i;
        r2.getClass();
        DoraDeviceInfo r7 = DoraDeviceInfo.a(DoraMainProcessBridgeService.h(r5), null, r6, 16367);
        DoraMainProcessBridgeService r8 = this.a;
        int r9 = r8.d.a;
        Intrinsics.checkNotNullParameter(r7, "deviceInfo");
        r8.d = new DoraMainProcessStateSnapshot(r9, r7);
        this.a.e(r7);
        return;
    L5:
        r3 = null;
        goto L6
    }
}
