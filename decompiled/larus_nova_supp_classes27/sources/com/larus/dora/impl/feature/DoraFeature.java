package com.larus.dora.impl.feature;

import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.larus.account.base.api.ILoginService;
import com.larus.dora.api.DoraByteCastManagerDelegate;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.protocol.FlowProtocolAbility;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.settingsconfig.DoraXLinkTransportMode;
import com.larus.dora.impl.core.settingsconfig.c;
import com.larus.dora.impl.core.wifi.DoraP2pRtcSwitchSync;
import com.larus.dora.impl.core.wifi.DoraWifiLinkWrapper;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.larus.dora.impl.util.b0;
import com.larus.network.http.y;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import d59.f;
import d59.i;
import g49.d;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraFeature {
    public static final DoraFeature a = null;
    public static final Lazy b = null;

    public DoraFeature() {
    }

    static {
        a = new DoraFeature();
        b = LazyKt.lazy(new a());
    }

    public final Object a(Continuation<? super Unit> r32) {
        if ((r32 instanceof DoraFeature$handlerFeature$1) == false) goto L7;
        DoraFeature$handlerFeature$1 r8 = (DoraFeature$handlerFeature$1) r32;
        int r9 = r8.label;
        if ((r9 & Integer.MIN_VALUE) == 0) goto L7;
        r8.label = r9 - Integer.MIN_VALUE;
    L8:
        Object r0 = r8.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = r8.label;
        if (r11 == 0) goto L18;
        if (r11 == 1) goto L17;
        if (r11 != 2) goto L16;
        int r12 = r8.I$1;
        int r13 = r8.I$0;
        boolean r14 = r8.Z$2;
        boolean r15 = r8.Z$1;
        boolean r16 = r8.Z$0;
        String r17 = (String) r8.L$2;
        DoraXLinkTransportMode r18 = (DoraXLinkTransportMode) r8.L$1;
        DoraWifiLinkWrapper.a r20 = (DoraWifiLinkWrapper.a) r8.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L175
        String r22 = ", xLinkConfig=[";
        String r21 = "doInit: syncBluetoothRTCEnabled failed, keep local RTC config, oldP2PRTC=";
        String r23 = "doInit: syncP2PRTCEnabled: effective=";
        String r110 = "doInit: syncEffectiveP2PRTCEnabled failed, keep local P2P config, oldP2PRTC=";
        DoraXLinkTransportMode r3 = r18;
        boolean r24 = r16;
        String r111 = "doInit: sync disable effective P2P RTC failed, keep local P2P config, oldP2PRTC=";
        String r4 = r17;
    L67:
        if (((Boolean) r0).booleanValue() != true) goto L69;
        boolean r1 = true;
    L70:
        boolean r2 = r1;
        boolean r5 = r24;
        int r6 = r12;
        DoraWifiLinkWrapper.a r25 = r20;
    L72:
        if (r2 == false) goto L75;
        d.d("DoraFeature", "doInit: initByteCastManagerAfterAbilityNegotiation");     // Catch: Throwable -> L175
        DoraByteCastManagerDelegate.b.d();     // Catch: Throwable -> L175
    L75:
        kj4.a r7 = kj4.a.g();     // Catch: Throwable -> L175
        if (r13 == 0) goto L78;
        boolean r26 = true;
    L79:
        ak4.a r27 = r7.c.d;     // Catch: Throwable -> L175
        byte[] r28 = new byte[3];     // Catch: Throwable -> L175
        r28[0] = 35;     // Catch: Throwable -> L175
        r28[1] = 1;     // Catch: Throwable -> L175
        if (r26 == false) goto L82;
        int r30 = 2;
    L83:
        r28[2] = (byte) r30;     // Catch: Throwable -> L175
        int r31 = r27.j(1, 4, r28, 1200);     // Catch: Throwable -> L175
        StringBuilder r33 = new StringBuilder("doInit: syncBluetoothRTCEnabled: effective=");     // Catch: Throwable -> L175
        if (r13 == 0) goto L86;
        boolean r34 = true;
    L87:
        r33.append(r34);     // Catch: Throwable -> L175
        r33.append(", userBluetooth=");     // Catch: Throwable -> L175
        if (r5 == false) goto L90;
        boolean r35 = true;
    L91:
        r33.append(r35);     // Catch: Throwable -> L175
        r33.append(", linkMode=");     // Catch: Throwable -> L175
        r33.append(r3);     // Catch: Throwable -> L175
        r33.append(", ret=");     // Catch: Throwable -> L175
        r33.append(r31);     // Catch: Throwable -> L175
        String r36 = r22;
        r33.append(r36);     // Catch: Throwable -> L175
        r33.append(r4);     // Catch: Throwable -> L175
        r33.append(']');     // Catch: Throwable -> L175
        d.d("DoraFeature", r33.toString());     // Catch: Throwable -> L175
        if (r31 != (-3)) goto L96;
        d.b("DoraFeature", "doInit: syncBluetoothRTCEnabled timeout, state unknown, continue syncing P2P RTC switch");     // Catch: Throwable -> L175
    L116:
        CoroutineScope r37 = DoraP2pRtcSwitchSync.a;     // Catch: Throwable -> L175
        if (r6 == 0) goto L119;
        boolean r38 = true;
    L120:
        int r40 = DoraP2pRtcSwitchSync.g(r38, Boxing.boxLong(1200));     // Catch: Throwable -> L175
        StringBuilder r41 = new StringBuilder(r23);     // Catch: Throwable -> L175
        if (r6 == 0) goto L123;
        boolean r42 = true;
    L124:
        r41.append(r42);     // Catch: Throwable -> L175
        r41.append(", userP2P=");     // Catch: Throwable -> L175
        if (r15 == false) goto L127;
        boolean r43 = true;
    L128:
        r41.append(r43);     // Catch: Throwable -> L175
        r41.append(", hasPermissions=");     // Catch: Throwable -> L175
        r41.append(r25.a);     // Catch: Throwable -> L175
        r41.append(", hasAbility=");     // Catch: Throwable -> L175
        r41.append(r25.b);     // Catch: Throwable -> L175
        r41.append(", runtimeSupported=");     // Catch: Throwable -> L175
        if (r14 == false) goto L131;
        boolean r44 = true;
    L132:
        r41.append(r44);     // Catch: Throwable -> L175
        r41.append(", linkMode=");     // Catch: Throwable -> L175
        r41.append(r3);     // Catch: Throwable -> L175
        r41.append(", ret=");     // Catch: Throwable -> L175
        r41.append(r40);     // Catch: Throwable -> L175
        r41.append(r36);     // Catch: Throwable -> L175
        r41.append(r4);     // Catch: Throwable -> L175
        r41.append(']');     // Catch: Throwable -> L175
        d.d("DoraFeature", r41.toString());     // Catch: Throwable -> L175
        DoraP2pRtcSwitchSync.d();     // Catch: Throwable -> L175
        if (r40 != 0) goto L135;
    L173:
        DoraP2pRtcSwitchSync.b();
        return Unit.INSTANCE;
    L135:
        if (r40 != (-3)) goto L139;
        d.b("DoraFeature", "doInit: syncP2PRTCEnabled timeout, state unknown, skip rollback");     // Catch: Throwable -> L175
        Unit r45 = Unit.INSTANCE;     // Catch: Throwable -> L175
        DoraP2pRtcSwitchSync.b();
        return r45;
    L139:
        if (r6 != 0) goto L157;
        StringBuilder r46 = new StringBuilder(r111);     // Catch: Throwable -> L175
        if (r15 == false) goto L143;
        boolean r47 = true;
    L144:
        r46.append(r47);     // Catch: Throwable -> L175
        r46.append(", ret=");     // Catch: Throwable -> L175
        r46.append(r40);     // Catch: Throwable -> L175
        d.b("DoraFeature", r46.toString());     // Catch: Throwable -> L175
        IDoraService r48 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L175
        if (r48 == null) goto L149;
        AbilityService r50 = r48.o0();     // Catch: Throwable -> L175
        if (r50 == null) goto L149;
        r50.a();     // Catch: Throwable -> L175
    L149:
        IDoraService r51 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L175
        if (r51 == null) goto L154;
        AbilityService r52 = r51.o0();     // Catch: Throwable -> L175
        if (r52 == null) goto L154;
        r52.m();     // Catch: Throwable -> L175
        Boxing.boxBoolean(true);     // Catch: Throwable -> L175
    L154:
        Unit r53 = Unit.INSTANCE;     // Catch: Throwable -> L175
        DoraP2pRtcSwitchSync.b();
        return r53;
    L143:
        r47 = false;
        goto L144
    L157:
        boolean r54 = false;
        int r55 = DoraP2pRtcSwitchSync.g(false, null);     // Catch: Throwable -> L175
        IDoraService r56 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L175
        if (r56 == null) goto L163;
        AbilityService r57 = r56.o0();     // Catch: Throwable -> L175
        if (r57 == null) goto L163;
        r57.a();     // Catch: Throwable -> L175
    L163:
        StringBuilder r58 = new StringBuilder(r110);     // Catch: Throwable -> L175
        if (r15 == false) goto L166;
        r54 = true;
    L166:
        r58.append(r54);     // Catch: Throwable -> L175
        r58.append(", ret=");     // Catch: Throwable -> L175
        r58.append(r40);     // Catch: Throwable -> L175
        r58.append(", rollbackRet=");     // Catch: Throwable -> L175
        r58.append(r55);     // Catch: Throwable -> L175
        d.b("DoraFeature", r58.toString());     // Catch: Throwable -> L175
        if (r15 == false) goto L173;
        IDoraService r60 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L175
        if (r60 == null) goto L173;
        AbilityService r61 = r60.o0();     // Catch: Throwable -> L175
        if (r61 == null) goto L173;
        r61.m();     // Catch: Throwable -> L175
        Boxing.boxBoolean(true);     // Catch: Throwable -> L175
        goto L173
    L131:
        r44 = false;
        goto L132
    L127:
        r43 = false;
        goto L128
    L123:
        r42 = false;
        goto L124
    L119:
        r38 = false;
        goto L120
    L96:
        if (r31 == 0) goto L111;
        if (r13 == 0) goto L111;
        int r62 = DoraP2pRtcSwitchSync.g(false, null);     // Catch: Throwable -> L175
        IDoraService r63 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L175
        if (r63 == null) goto L104;
        AbilityService r64 = r63.o0();     // Catch: Throwable -> L175
        if (r64 == null) goto L104;
        r64.a();     // Catch: Throwable -> L175
    L104:
        DoraBuryPointManager.J(DoraBuryPointManager.a, "d_bluetooth_rtc_switch_status", MapsKt.mapOf(TuplesKt.to("switch_status", Boxing.boxInt(1))), false, 12);     // Catch: Throwable -> L175
        StringBuilder r65 = new StringBuilder(r21);     // Catch: Throwable -> L175
        if (r15 == false) goto L107;
        boolean r66 = true;
    L108:
        r65.append(r66);     // Catch: Throwable -> L175
        r65.append(", rollbackP2PRTCRet=");     // Catch: Throwable -> L175
        r65.append(r62);     // Catch: Throwable -> L175
        d.b("DoraFeature", r65.toString());     // Catch: Throwable -> L175
        Unit r67 = Unit.INSTANCE;     // Catch: Throwable -> L175
        DoraP2pRtcSwitchSync.b();
        return r67;
    L107:
        r66 = false;
    L111:
        DoraBuryPointManager r68 = DoraBuryPointManager.a;     // Catch: Throwable -> L175
        if (r13 == 0) goto L114;
        int r112 = 2;
    L115:
        DoraBuryPointManager.J(r68, "d_bluetooth_rtc_switch_status", MapsKt.mapOf(TuplesKt.to("switch_status", Boxing.boxInt(r112))), false, 12);     // Catch: Throwable -> L175
        goto L116
    L114:
        r112 = 1;
        goto L115
    L90:
        r35 = false;
        goto L91
    L86:
        r34 = false;
        goto L87
    L82:
        r30 = 1;
        goto L83
    L78:
        r26 = false;
        goto L79
    L69:
        r1 = false;
        goto L70
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        String r70 = (String) r8.L$0;
        ResultKt.throwOnFailure(r0);
    L45:
        b0.a.getClass();     // Catch: Throwable -> L175
        r5 = b0.p(r70);     // Catch: Throwable -> L175
        r15 = b0.u(r70);     // Catch: Throwable -> L175
        DoraWifiLinkWrapper.a.getClass();     // Catch: Throwable -> L175
        r25 = DoraWifiLinkWrapper.n();     // Catch: Throwable -> L175
        r14 = r25.a();     // Catch: Throwable -> L175
        c r113 = c.a;     // Catch: Throwable -> L175
        r110 = "doInit: syncEffectiveP2PRTCEnabled failed, keep local P2P config, oldP2PRTC=";
        if (r14 == false) goto L48;
        boolean r71 = true;
    L49:
        r111 = "doInit: sync disable effective P2P RTC failed, keep local P2P config, oldP2PRTC=";
        boolean r72 = DoraWifiLinkWrapper.j();     // Catch: Throwable -> L175
        r113.getClass();     // Catch: Throwable -> L175
        r3 = c.e(r5, r15, r71, r72);     // Catch: Throwable -> L175
        r4 = c.a();     // Catch: Throwable -> L175
        r23 = "doInit: syncP2PRTCEnabled: effective=";
        if (r3 == DoraXLinkTransportMode.OFF) goto L52;
        r13 = 1;
    L54:
        if (r3 != DoraXLinkTransportMode.WIFI) goto L56;
        r6 = 1;
    L57:
        if (r13 == 0) goto L74;
        r21 = "doInit: syncBluetoothRTCEnabled failed, keep local RTC config, oldP2PRTC=";
        r22 = ", xLinkConfig=[";
        IDoraService r73 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L175
        if (r73 == null) goto L71;
        AbilityService r74 = r73.o0();     // Catch: Throwable -> L175
        if (r74 == null) goto L71;
        r8.L$0 = r25;     // Catch: Throwable -> L175
        r8.L$1 = r3;     // Catch: Throwable -> L175
        r8.L$2 = r4;     // Catch: Throwable -> L175
        r8.Z$0 = r5;     // Catch: Throwable -> L175
        r8.Z$1 = r15;     // Catch: Throwable -> L175
        r8.Z$2 = r14;     // Catch: Throwable -> L175
        r8.I$0 = r13;     // Catch: Throwable -> L175
        r8.I$1 = r6;     // Catch: Throwable -> L175
        r8.label = 2;     // Catch: Throwable -> L175
        r0 = r74.i(FlowProtocolAbility.FEATURE_BLUETOOTH_RTC);     // Catch: Throwable -> L175
        if (r0 != r10) goto L65;
        return r10;
    L65:
        r12 = r6;
        r20 = r25;
        r24 = r5;
    L71:
        r5 = r5;
        r2 = false;
        goto L72
    L74:
        r22 = ", xLinkConfig=[";
        r21 = "doInit: syncBluetoothRTCEnabled failed, keep local RTC config, oldP2PRTC=";
        goto L75
    L56:
        r6 = 0;
        goto L57
    L52:
        r13 = 0;
        goto L54
    L48:
        r71 = false;
        goto L49
    L18:
        ResultKt.throwOnFailure(r0);
        String r75 = ILoginService.a.getAccountInfo().c;
        if (r75 != null) goto L21;
        r75 = "";
    L21:
        r70 = r75;
        f r76 = ((g59.c) b.getValue()).a();
        if (r76 == null) goto L26;
        Map<String, i> r77 = r76.a();
        if (r77 == null) goto L26;
        Set<String> r78 = r77.keySet();
    L27:
        if (r78 != null) goto L29;
        r78 = SetsKt.emptySet();
    L29:
        b0.a.getClass();
        if (b0.w() == true) goto L32;
    L34:
        boolean r80 = b0.w();
        d.d("DoraFeature", "doInit: syncQuickContinuousConversationSwitch: " + r80 + ", ret=" + kj4.a.g().v(r80));
        DoraDevice r81 = kj4.a.g().c.a(false);
        if (r81 != null) goto L37;
    L178:
        d.d("DoraFeature", "doInit: skip RTC sync for non-G device");
        return Unit.INSTANCE;
    L37:
        if (ProductNameType.isDoraGSeriesType(r81.type) == false) goto L178;
        CoroutineScope r82 = DoraP2pRtcSwitchSync.a;
        r8.L$0 = r70;
        r8.label = 1;
        Object r83 = DoraP2pRtcSwitchSync.c.a(null, r8);
        if (r83 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L43;
        r83 = Unit.INSTANCE;
    L43:
        if (r83 != r10) goto L45;
        return r10;
    L32:
        if (r78.contains("fuzzy_wakeup") == true) goto L34;
        b0.M(false);
    L26:
        r78 = null;
    L175:
        th = move-exception;
        DoraP2pRtcSwitchSync.b();
        throw th;
    L7:
        r8 = new DoraFeature$handlerFeature$1(this, r32);
        goto L8
    }

    public final Object b(Continuation<? super Boolean> r13) {
        if ((r13 instanceof DoraFeature$requestFeature$1) == false) goto L7;
        DoraFeature$requestFeature$1 r1 = (DoraFeature$requestFeature$1) r13;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r14 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        boolean r7 = true;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L18;
        if (r4 == 2) goto L17;
        if (r4 == 3) goto L17;
        if (r4 != 4) goto L15;
        Throwable r0 = (Throwable) r1.L$0;
        ResultKt.throwOnFailure(r14);
        throw r0;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        int r5 = r1.I$0;
        ResultKt.throwOnFailure(r14);
    L42:
        if (r5 != 0) goto L46;
        r7 = false;
    L46:
        return Boxing.boxBoolean(r7);
    L18:
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L27
    L24:
        y r15 = (com.larus.network.http.a) r14;     // Catch: Throwable -> L27
        if ((r15 instanceof y) == false) goto L30;
        f r16 = (f) ((com.larus.network.http.a) r15).b;     // Catch: Throwable -> L27
        d.d("DoraFeature", "loadLabSettingConfig success, config: " + r16);     // Catch: Throwable -> L27
        ((g59.c) b.getValue()).b(r16);     // Catch: Throwable -> L27
        int r17 = 1;
    L33:
        r1.I$0 = r17;
        r1.label = 2;
        if (a(r1) != r3) goto L36;
        return r3;
    L36:
        r5 = r17;
        goto L42
    L30:
        if ((r15 instanceof com.larus.network.http.f) == false) goto L32;
        d.c("DoraFeature", "loadLabSettingConfig failed", ((com.larus.network.http.f) r15).d);     // Catch: Throwable -> L27
    L32:
        r17 = 0;
        goto L33
    L20:
        ResultKt.throwOnFailure(r14);
        d.d("DoraFeature", "start request feature");     // Catch: Throwable -> L27
        com.larus.dora.api.network.a r18 = com.larus.dora.api.network.a.a;     // Catch: Throwable -> L27
        Map r11 = MapsKt.emptyMap();     // Catch: Throwable -> L27
        r1.label = 1;     // Catch: Throwable -> L27
        r14 = com.larus.dora.api.network.a.b(r18, f.class, "/alice/w/starweave/feature-visibility/matched", r11, r1);     // Catch: Throwable -> L27
        if (r14 != r3) goto L24;
        return r3;
    L27:
        th = move-exception;
        d.c("DoraFeature", "request feature err:", th);     // Catch: Throwable -> L47
        r1.I$0 = 0;
        r1.label = 3;
        if (a(r1) != r3) goto L41;
        return r3;
    L41:
        r5 = 0;
    L47:
        th = move-exception;
        r1.L$0 = th;
        r1.label = 4;
        if (a(r1) != r3) goto L55;
        return r3;
    L55:
        throw th;
    L7:
        r1 = new DoraFeature$requestFeature$1(this, r13);
        goto L8
    }
}
