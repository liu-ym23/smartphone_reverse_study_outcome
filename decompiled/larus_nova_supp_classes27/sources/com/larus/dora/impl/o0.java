package com.larus.dora.impl;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.api.IApmTrace;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.core.i;
import com.larus.dora.impl.device.settings.gesture.wakeup.GestureWakeupRepository;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.settings.SppLinkRetryConfig;
import com.mammon.audiosdk.SAMICore;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import g49.d;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import o59.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class o0 implements Function0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ DoraServiceImpl b;
    public final /* synthetic */ DoraDevice c;

    public /* synthetic */ o0(int r1, DoraServiceImpl r2, DoraDevice r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final Object invoke() {
        final int r1 = this.a;
        DoraServiceImpl r2 = this.b;
        DoraDevice r3 = this.c;
        if (r1 == (-1)) goto L6;
        if (r1 == 0) goto L6;
    L8:
        if (r1 == 0) goto L38;
        if (r1 != 2) goto L43;
        IApmTrace.a.d("connect_state", "DORA_CONNECT");
        if (r3 != null) goto L14;
    L16:
        boolean r7 = false;
    L17:
        if (r7 == false) goto L43;
        int r8 = r2.w1();
        d.d("DoraServiceImpl", "sync system volume on Dora G connected, lastVolume=" + r2.B + ", currentVolume=" + r8);
        r2.B = r8;
        r2.C1(r8);
        IDoraAVLinkService r9 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r9 == null) goto L21;
        List r10 = r9.E0();
    L22:
        List r11 = r10;
        if (r11 != null) goto L25;
    L28:
        boolean r12 = true;
    L29:
        if (r12 == true) goto L43;
        int r13 = r10.size();
        byte[] r14 = new byte[r13];
        int r15 = 0;
    L31:
        if (r15 >= r13) goto L33;
        r14[r15] = (byte) ((Number) ListProtector.get(r10, r15)).intValue();
        r15 = r15 + 1;
        goto L31
    L33:
        d.d("DoraServiceImpl", "syncIntentionCapabilitySet on connected: " + Arrays.toString(r14));
        IDoraService r16 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r16 == null) goto L43;
        DeviceService r17 = r16.device();
        if (r17 == null) goto L43;
        r17.F0(r14);
        goto L43
    L25:
        if (r11.isEmpty() == true) goto L28;
        r12 = false;
        goto L29
    L21:
        r10 = null;
        goto L22
    L14:
        if (a.l(r3) != true) goto L16;
        r7 = true;
    L43:
        if (r1 != 2) goto L54;
        AtomicBoolean r4 = DoraServiceImpl.V0;
        r2.getClass();
        if (r3.vendorId != 4096) goto L48;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraServiceImpl$uploadDeviceInfo$1(r3, null), 3, null);
    L50:
        i.a(true);
        int r5 = DoraPreWakeUpTask.d;
        DoraPreWakeUpTask.Companion.l();
        SAMICore.RegisterWakeupParamRequestCallback(new u());
        DoraPreWakeUpTask.Companion.m();
        GestureWakeupRepository.a.getClass();
        if (GestureWakeupRepository.g() == false) goto L53;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new DoraServiceImpl$doraLinkCallback$1$onDoraLinkStateChanged$2$1(null), 3, null);
    L53:
        r2.H0 = 2;
    L55:
        Function0 r6 = new p0(r1);
        AtomicBoolean r18 = DoraServiceImpl.V0;
        r2.getClass();
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new DoraServiceImpl$runOnMain$1(r6, null), 3, null);
        return Unit.INSTANCE;
    L48:
        if (a.m(Integer.valueOf(r3.productId)) == true) goto L50;
        d.d("DoraServiceImpl", "uploadDeviceInfo: skip basic_info, vendorId=" + r3.vendorId + ", productId=" + r3.productId);
        goto L50
    L54:
        i.a(false);
        r2.H0 = 1;
        int r20 = DoraPreWakeUpTask.d;
        DoraPreWakeUpTask.Companion.l();
        SAMICore.RegisterWakeupParamRequestCallback(new u());
        DoraPreWakeUpTask.Companion.m();
        goto L55
    L38:
        IApmTrace.a.d("connect_state", "DORA_DISCONNECT");
        DoraSetting.a.getClass();
        int r21 = com.larus.utils.l0.a;
        SppLinkRetryConfig r22 = (SppLinkRetryConfig) com.larus.utils.l0.a(new SppLinkRetryConfig(false, 0, 3, null), new com.larus.dora.impl.settings.x0());
        d.d("DoraServiceImpl", "conDoraLinkStateChanged enable: " + r22.getEnable() + " delayMS: " + r22.getDelayMs());
        if (r3.vendorId != 4096) goto L43;
        if (r22.getEnable() == false) goto L43;
        com.larus.dora.impl.core.i0.a.a.j(r3, r22.getDelayMs());
    L6:
        r2.I0(100);
        goto L8
    }
}
