package com.larus.dora.impl.device.settings.lab;

import com.larus.account.base.api.ILoginService;
import com.larus.dora.api.DoraByteCastManagerDelegate;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.protocol.FlowProtocolAbility;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.o0;
import com.larus.dora.impl.core.wifi.DoraP2pRtcSwitchSync;
import com.larus.dora.impl.core.wifi.DoraWifiLinkWrapper;
import com.larus.dora.impl.serviceimpl.AbilityService;
import com.larus.dora.impl.util.b0;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setRTCTransportMode$1$1$1", f = "LabSettingsViewModel.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 5, 5, 7, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8}, l = {391, 394, 404, 410, 420, 424, 430, 440, 443, 455}, m = "invokeSuspend", n = {"$this$withContext", "uid", "targetRTCVideoCallEnable", "targetBluetoothRTCEnable", "targetP2PRTCEnable", "oldBluetoothRTCEnable", "oldP2PRTCEnable", "oldRTCVideoCallEnable", "shouldSyncP2PRTCSwitch", "targetEffectiveP2PRTCEnable", "oldEffectiveP2PRTCEnable", "$this$withContext", "uid", "targetRTCVideoCallEnable", "targetBluetoothRTCEnable", "targetP2PRTCEnable", "oldBluetoothRTCEnable", "oldP2PRTCEnable", "oldRTCVideoCallEnable", "shouldSyncP2PRTCSwitch", "targetEffectiveP2PRTCEnable", "oldEffectiveP2PRTCEnable", "uid", "targetRTCVideoCallEnable", "targetBluetoothRTCEnable", "targetP2PRTCEnable", "oldBluetoothRTCEnable", "oldP2PRTCEnable", "oldRTCVideoCallEnable", "shouldSyncP2PRTCSwitch", "targetEffectiveP2PRTCEnable", "oldEffectiveP2PRTCEnable", "uid", "oldBluetoothRTCEnable", "uid", "targetRTCVideoCallEnable", "targetBluetoothRTCEnable", "targetP2PRTCEnable", "oldBluetoothRTCEnable", "oldP2PRTCEnable", "oldRTCVideoCallEnable", "uid", "targetBluetoothRTCEnable", "oldRTCVideoCallEnable", "ret"}, s = {"L$0", "L$1", "I$0", "I$1", "I$2", "Z$0", "Z$1", "I$3", "Z$2", "I$4", "I$5", "L$0", "L$1", "I$0", "I$1", "I$2", "Z$0", "Z$1", "I$3", "Z$2", "I$4", "I$5", "L$0", "I$0", "I$1", "I$2", "Z$0", "Z$1", "I$3", "Z$2", "I$4", "I$5", "L$0", "Z$0", "L$0", "I$0", "I$1", "I$2", "Z$0", "Z$1", "I$3", "L$0", "I$0", "I$1", "I$2"})
public final class LabSettingsViewModel$setRTCTransportMode$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RTCTransportMode $mode;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int I$4;
    int I$5;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    int label;
    final /* synthetic */ LabSettingsViewModel this$0;

    public LabSettingsViewModel$setRTCTransportMode$1$1$1(RTCTransportMode r1, LabSettingsViewModel r2, Continuation<? super LabSettingsViewModel$setRTCTransportMode$1$1$1> r3) {
        this.$mode = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        LabSettingsViewModel$setRTCTransportMode$1$1$1 r0 = new LabSettingsViewModel$setRTCTransportMode$1$1$1(this.$mode, this.this$0, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v23 */
    /* JADX WARN: Type inference failed for: r10v24 */
    /* JADX WARN: Type inference failed for: r10v25 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [int] */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v19 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v3, types: [int] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v20 */
    /* JADX WARN: Type inference failed for: r12v21 */
    /* JADX WARN: Type inference failed for: r12v4, types: [int] */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v9, types: [int] */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v24, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v32, types: [int] */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v91 */
    /* JADX WARN: Type inference failed for: r2v92 */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r2v94 */
    /* JADX WARN: Type inference failed for: r31v0 */
    /* JADX WARN: Type inference failed for: r31v1 */
    /* JADX WARN: Type inference failed for: r3v10, types: [int] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v52 */
    /* JADX WARN: Type inference failed for: r3v53 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    public final Object invokeSuspend(Object r34) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(this.label) {
            case 0: goto L16;
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        ResultKt.throwOnFailure(r34);
    L158:
        return Unit.INSTANCE;
    L7:
        int r2 = this.I$2;
        int r4 = this.I$1;
        int r10 = this.I$0;
        String r11 = (String) this.L$0;
        ResultKt.throwOnFailure(r34);
        Object r3 = r34;
        int r5 = r4;
        String r6 = ", ret=";
    L139:
        int r7 = ((Number) r3).intValue();
        StringBuilder r8 = new StringBuilder("setRTCTransportMode: rollback bluetooth=");
        if (r5 == 0) goto L142;
        boolean r9 = true;
    L143:
        r8.append(r9);
        r8.append(r6);
        r8.append(r7);
        g49.d.b(LabSettingsViewModel.TAG, r8.toString());
        if (LabSettingsViewModel.access$isRTCSwitchSyncAccepted(this.this$0, r7) == true) goto L154;
        LabSettingsViewModel r12 = this.this$0;
        if (r10 == 0) goto L148;
        boolean r13 = true;
    L149:
        LabSettingsViewModel.access$updateRTCTransportLocalState(r12, r11, r13, false);
        DoraByteCastManagerDelegate.b.d();
        IDoraService r14 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r14 == null) goto L154;
        AbilityService r15 = r14.o0();
        if (r15 == null) goto L154;
        r15.m();
        Boxing.boxBoolean(true);
        goto L154
    L148:
        r13 = false;
    L154:
        g49.d.b(LabSettingsViewModel.TAG, "setRTCTransportMode failed: enable effective P2P RTC failed, keep old P2P state, ret=" + r2);
        MutableSharedFlow r16 = LabSettingsViewModel.access$get_envActionSharedFlow$p(this.this$0);
        b.d r17 = new b.d(2131904037);
        this.L$0 = null;
        this.label = 10;
        if (r16.emit(r17, this) != r1) goto L158;
        return r1;
    L142:
        r9 = false;
        goto L143
    L8:
        int r18 = this.I$3;
        boolean r110 = this.Z$1;
        boolean r111 = this.Z$0;
        int r112 = this.I$2;
        int r113 = this.I$1;
        int r114 = this.I$0;
        String r115 = (String) this.L$0;
        ResultKt.throwOnFailure(r34);
        r5 = r18;
        r6 = ", ret=";
        boolean r20 = r110;
        r10 = r113;
        int r21 = r114;
        Object r22 = r34;
        boolean r116 = r111;
        r11 = r115;
    L129:
        r2 = ((Number) r22).intValue();
        if (LabSettingsViewModel.access$isRTCSwitchSyncAccepted(this.this$0, r2) == true) goto L159;
        if (r5 == r21) goto L154;
        LabSettingsViewModel r23 = this.this$0;
        if (r5 == 0) goto L135;
        boolean r24 = true;
    L136:
        this.L$0 = r11;
        this.I$0 = r10;
        this.I$1 = r5;
        this.I$2 = r2;
        this.label = 9;
        r3 = LabSettingsViewModel.access$syncBluetoothRTCVideoCallSwitch(r23, r24, this);
        if (r3 != r1) goto L139;
        return r1;
    L135:
        r24 = false;
        goto L136
    L159:
        String r25 = r11;
        int r117 = r112;
        int r31 = r10;
        boolean r118 = r20;
        ?? r26 = r31 == true ? 1 : 0;
    L160:
        b0 r27 = b0.a;
        if (r26 == 0) goto L163;
        boolean r28 = true;
    L164:
        r27.getClass();
        Intrinsics.checkNotNullParameter(r25, "uid");
        b0.j().storeBoolean("dora_enable_bluetooth_rtc_" + r25, r28);
        if (r117 == 0) goto L167;
        boolean r30 = true;
    L168:
        Intrinsics.checkNotNullParameter(r25, "uid");
        b0.j().storeBoolean("dora_enable_p2p_rtc_".concat(r25), r30);
        if (r21 == 0) goto L171;
        DoraByteCastManagerDelegate.b.d();
    L171:
        if (r116 != r26) goto L173;
        if (r118 != r117) goto L173;
    L178:
        DoraP2pRtcSwitchSync.d();
        boolean r32 = b0.p(r25);
        boolean r33 = b0.u(r25);
        g49.d.d(LabSettingsViewModel.TAG, "setRTCTransportMode success: mode=" + this.$mode + ", latestBluetooth=" + r32 + ", latestEffectiveP2PRTC=" + r33);
        if ((LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue() instanceof c.b) == false) goto L181;
        z0 r35 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0);
        Object r36 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue();
        Intrinsics.checkNotNull(r36, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
        r35.setValue(c.b.a((c.b) r36, false, false, false, false, false, false, false, r32, r33, false, false, false, false, 4182015));
    L181:
        DoraBuryPointManager r37 = DoraBuryPointManager.a;
        if (r32 == false) goto L184;
        int r38 = 2;
    L185:
        DoraBuryPointManager.J(r37, "d_bluetooth_rtc_switch_status", MapsKt.mapOf(TuplesKt.to("switch_status", Boxing.boxInt(r38))), false, 12);
        int r40 = 2;
        Pair[] r41 = new Pair[2];
        if (r33 == false) goto L188;
        int r42 = 2;
    L189:
        r41[0] = TuplesKt.to("switch_status", Boxing.boxInt(r42));
        if (r32 == true) goto L193;
        r40 = 1;
    L193:
        r41[1] = TuplesKt.to("rtc_master_switch", Boxing.boxInt(r40));
        DoraBuryPointManager.J(r37, "d_p2p_rtc_switch_status", MapsKt.mapOf(r41), false, 12);
        return Unit.INSTANCE;
    L188:
        r42 = 1;
        goto L189
    L184:
        r38 = 1;
    L173:
        IDoraService r43 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r43 == null) goto L178;
        AbilityService r44 = r43.o0();
        if (r44 == null) goto L178;
        r44.m();
        Boxing.boxBoolean(true);
        goto L178
    L167:
        r30 = false;
        goto L168
    L163:
        r28 = false;
        goto L164
    L9:
        ResultKt.throwOnFailure(r34);
    L122:
        return Unit.INSTANCE;
    L10:
        boolean r45 = this.Z$0;
        LabSettingsViewModel r46 = (LabSettingsViewModel) this.L$1;
        r25 = (String) this.L$0;
        ResultKt.throwOnFailure(r34);
        r116 = r45;
        Object r47 = r34;
    L114:
        int r48 = ((Number) r47).intValue();
        g49.d.b(LabSettingsViewModel.TAG, "setRTCTransportMode: rollback effective P2P RTC=true, ret=" + r48);
        if (LabSettingsViewModel.access$isRTCSwitchSyncAccepted(r46, r48) == true) goto L117;
        LabSettingsViewModel.access$updateRTCTransportLocalState(r46, r25, r116, false);
    L117:
        LabSettingsViewModel r50 = r46;
    L118:
        MutableSharedFlow r51 = LabSettingsViewModel.access$get_envActionSharedFlow$p(r50);
        b.d r52 = new b.d(2131904037);
        this.L$0 = null;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 7;
        if (r51.emit(r52, this) != r1) goto L122;
        return r1;
    L11:
        int r53 = this.I$5;
        int r119 = this.I$4;
        boolean r120 = this.Z$2;
        int r121 = this.I$3;
        boolean r122 = this.Z$1;
        r116 = this.Z$0;
        r117 = this.I$2;
        int r54 = this.I$1;
        int r55 = this.I$0;
        RTCTransportMode r56 = (RTCTransportMode) this.L$2;
        r50 = (LabSettingsViewModel) this.L$1;
        r25 = (String) this.L$0;
        ResultKt.throwOnFailure(r34);
        ?? r123 = r53;
        String r124 = ", ret=";
        Object r57 = r34;
        r21 = r55;
        int r58 = r119;
        r118 = r122;
        ?? r60 = r54;
    L102:
        int r61 = ((Number) r57).intValue();
        int r125 = r121;
        StringBuilder r126 = new StringBuilder("setRTCTransportMode: ");
        r126.append(r56);
        r126.append(", syncBluetooth=");
        if (r21 == 0) goto L105;
        boolean r62 = true;
    L106:
        r126.append(r62);
        r6 = r124;
        r126.append(r6);
        r126.append(r61);
        g49.d.d(LabSettingsViewModel.TAG, r126.toString());
        r26 = r60;
        r26 = r60;
        if (LabSettingsViewModel.access$isRTCSwitchSyncAccepted(r50, r61) == true) goto L123;
        if (r123 == 0) goto L118;
        if (r58 != 0) goto L118;
        this.L$0 = r25;
        this.L$1 = r50;
        this.L$2 = null;
        this.Z$0 = r116;
        this.label = 6;
        r47 = LabSettingsViewModel.access$syncEffectiveP2PRTCVideoCallSwitch(r50, true, this);
        if (r47 != r1) goto L113;
        return r1;
    L113:
        r46 = r50;
        goto L114
    L123:
        if (r120 == false) goto L160;
        if (r58 == 0) goto L160;
        LabSettingsViewModel r63 = this.this$0;
        this.L$0 = r25;
        this.L$1 = null;
        this.L$2 = null;
        this.I$0 = r21 == true ? 1 : 0;
        this.I$1 = r60 == true ? 1 : 0;
        this.I$2 = r117 == true ? 1 : 0;
        this.Z$0 = r116;
        this.Z$1 = r118;
        r5 = r125;
        this.I$3 = r5;
        this.label = 8;
        r22 = LabSettingsViewModel.access$syncEffectiveP2PRTCVideoCallSwitch(r63, true, this);
        if (r22 != r1) goto L128;
        return r1;
    L128:
        r11 = r25;
        r112 = r117 == true ? 1 : 0;
        boolean r310 = r118;
        r10 = r60 == true ? 1 : 0;
        r20 = r310;
        goto L129
    L105:
        r62 = false;
        goto L106
    L12:
        ResultKt.throwOnFailure(r34);
    L93:
        return Unit.INSTANCE;
    L13:
        int r64 = this.I$5;
        int r65 = this.I$4;
        boolean r66 = this.Z$2;
        int r67 = this.I$3;
        boolean r68 = this.Z$1;
        boolean r70 = this.Z$0;
        int r127 = this.I$2;
        int r128 = this.I$1;
        int r129 = this.I$0;
        String r130 = (String) this.L$1;
        CoroutineScope r131 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r34);
        r124 = ", ret=";
        Object r71 = r34;
        ?? r72 = r64;
        ?? r132 = r127;
        ?? r133 = r128;
        ?? r134 = r129;
    L87:
        int r73 = ((Number) r71).intValue();
        if (LabSettingsViewModel.access$isRTCSwitchSyncAccepted(this.this$0, r73) == true) goto L94;
        g49.d.b(LabSettingsViewModel.TAG, "setRTCTransportMode failed: disable effective P2P RTC failed, keep old state, ret=" + r73);
        MutableSharedFlow r74 = LabSettingsViewModel.access$get_envActionSharedFlow$p(this.this$0);
        b.d r75 = new b.d(2131904037);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 4;
        if (r74.emit(r75, this) != r1) goto L93;
        return r1;
    L94:
        ?? r311 = r132;
        int r135 = r65;
        ?? r76 = r133;
        r120 = r66;
        LabSettingsViewModel r77 = this.this$0;
        RTCTransportMode r136 = this.$mode;
        if (r134 == 0) goto L97;
        boolean r137 = true;
    L98:
        this.L$0 = r130;
        this.L$1 = r77;
        this.L$2 = r136;
        this.I$0 = r134;
        this.I$1 = r76;
        this.I$2 = r311 == true ? 1 : 0;
        this.Z$0 = r70;
        this.Z$1 = r68;
        this.I$3 = r67;
        this.Z$2 = r120;
        this.I$4 = r135;
        this.I$5 = r72;
        r123 = r72;
        this.label = 5;
        r57 = LabSettingsViewModel.access$syncBluetoothRTCVideoCallSwitch(r77, r137, this);
        if (r57 != r1) goto L101;
        return r1;
    L101:
        r117 = r311 == true ? 1 : 0;
        r56 = r136;
        r116 = r70;
        r25 = r130;
        ?? r312 = r134;
        r121 = r67;
        r50 = r77;
        r21 = r312 == true ? 1 : 0;
        r118 = r68;
        r58 = r135;
        r60 = r76;
        goto L102
    L97:
        r137 = false;
        goto L98
    L14:
        ResultKt.throwOnFailure(r34);
    L79:
        return Unit.INSTANCE;
    L15:
        int r78 = this.I$5;
        r65 = this.I$4;
        r66 = this.Z$2;
        int r80 = this.I$3;
        r68 = this.Z$1;
        r70 = this.Z$0;
        int r138 = this.I$2;
        int r139 = this.I$1;
        int r140 = this.I$0;
        r130 = (String) this.L$1;
        CoroutineScope r141 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r34);
        r124 = ", ret=";
        ?? r81 = r140;
        int r142 = r80;
        Object r82 = r34;
        ?? r83 = r78;
        ?? r143 = r138;
        ?? r144 = r139;
    L73:
        x39.b r84 = (x39.b) r82;
        if (r84 == null) goto L80;
        g49.d.b(LabSettingsViewModel.TAG, "setRTCTransportMode failed: permission denied " + r84);
        MutableSharedFlow r85 = LabSettingsViewModel.access$get_envActionSharedFlow$p(this.this$0);
        b.d r86 = new b.d(2131902876);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (r85.emit(r86, this) != r1) goto L79;
        return r1;
    L80:
        r67 = r142;
        r134 = r81;
        r72 = r83;
        r132 = r143;
        r133 = r144;
    L82:
        if (r66 == false) goto L94;
        if (r65 != 0) goto L94;
        LabSettingsViewModel r87 = this.this$0;
        this.L$0 = r141;
        this.L$1 = r130;
        this.I$0 = r134;
        this.I$1 = r133;
        this.I$2 = r132;
        this.Z$0 = r70;
        this.Z$1 = r68;
        this.I$3 = r67;
        this.Z$2 = r66;
        this.I$4 = r65;
        this.I$5 = r72;
        this.label = 3;
        r71 = LabSettingsViewModel.access$syncEffectiveP2PRTCVideoCallSwitch(r87, false, this);
        r72 = r72;
        r132 = r132;
        r133 = r133;
        r134 = r134;
        if (r71 != r1) goto L87;
        return r1;
    L16:
        ResultKt.throwOnFailure(r34);
        r141 = (CoroutineScope) this.L$0;
        com.larus.dora.impl.core.settingsconfig.c.a.getClass();
        if (com.larus.dora.impl.core.settingsconfig.c.j() == true) goto L19;
    L195:
        g49.d.e(LabSettingsViewModel.TAG, "setRTCTransportMode ignored: video streaming entrance hidden or not user_select");
        return Unit.INSTANCE;
    L19:
        if (com.larus.dora.impl.core.settingsconfig.c.g() == false) goto L195;
        RTCTransportMode r88 = this.$mode;
        RTCTransportMode r90 = RTCTransportMode.BLUETOOTH;
        if (r88 == r90) goto L24;
    L27:
        RTCTransportMode r91 = this.$mode;
        RTCTransportMode r92 = RTCTransportMode.WIFI;
        if (r91 == r92) goto L30;
    L33:
        String r93 = ILoginService.a.getAccountInfo().c;
        if (r93 != null) goto L36;
        r93 = "";
    L36:
        r130 = r93;
        RTCTransportMode r94 = this.$mode;
        RTCTransportMode r95 = RTCTransportMode.OFF;
        if (r94 == r95) goto L39;
        ?? r96 = 1;
    L40:
        if (r94 != r90) goto L42;
        ?? r97 = 1;
    L43:
        if (r94 != r92) goto L45;
        ?? r98 = 1;
    L46:
        b0.a.getClass();
        boolean r145 = b0.p(r130);
        boolean r146 = b0.u(r130);
        if (r145 == true) goto L51;
        if (r146 == true) goto L51;
        r142 = 0;
    L52:
        DoraWifiLinkWrapper.a.getClass();
        boolean r147 = o0.d(FlowProtocolAbility.FEATURE_P2P_RTC);
        boolean r148 = DoraWifiLinkWrapper.j();
        if (r98 == 0) goto L56;
        if (r148 == false) goto L56;
        r65 = 1;
    L57:
        if (r146 == false) goto L60;
        if (r148 == false) goto L60;
        ?? r100 = 1;
    L61:
        r124 = ", ret=";
        ?? r101 = new StringBuilder("setRTCTransportMode request: from=");
        RTCTransportMode.Companion.getClass();
        if (r146 == false) goto L64;
        RTCTransportMode r102 = r92;
    L67:
        r101.append(r102);
        r101.append(", to=");
        r101.append(this.$mode);
        r101.append(", oldBluetooth=");
        r101.append(r145);
        r101.append(", oldP2PRTC=");
        r101.append(r146);
        r101.append(", oldEffectiveP2PRTC=");
        r101.append(r100);
        r101.append(", targetBluetooth=");
        r101.append(r97);
        r101.append(", targetP2PRTC=");
        r101.append(r98);
        r101.append(", targetRTC=");
        r101.append(r96);
        g49.d.d(LabSettingsViewModel.TAG, r101.toString());
        if (r98 == 0) goto L81;
        this.L$0 = r141;
        this.L$1 = r130;
        this.I$0 = r96;
        this.I$1 = r97;
        this.I$2 = r98;
        this.Z$0 = r145;
        this.Z$1 = r146;
        this.I$3 = r142;
        this.Z$2 = r147;
        this.I$4 = r65;
        this.I$5 = r100;
        this.label = 1;
        r82 = DoraWifiLinkWrapper.e(this);
        if (r82 != r1) goto L72;
        return r1;
    L72:
        r81 = r96;
        r68 = r146;
        r144 = r97;
        r70 = r145;
        r143 = r98;
        r83 = r100;
        r66 = r147;
        goto L73
    L81:
        r67 = r142;
        r134 = r96;
        r68 = r146;
        r133 = r97;
        r70 = r145;
        r132 = r98;
        r72 = r100;
        r66 = r147;
        goto L82
    L64:
        if (r145 == false) goto L66;
        r102 = r90;
        goto L67
    L66:
        r102 = r95;
    L60:
        r100 = 0;
    L56:
        r65 = 0;
    L51:
        r142 = 1;
        goto L52
    L45:
        r98 = 0;
        goto L46
    L42:
        r97 = 0;
        goto L43
    L39:
        r96 = 0;
        goto L40
    L30:
        if (com.larus.dora.impl.core.settingsconfig.c.b().b.contains("p2p") == true) goto L33;
        g49.d.e(LabSettingsViewModel.TAG, "setRTCTransportMode ignored: p2p is not allowed");
        return Unit.INSTANCE;
    L24:
        if (com.larus.dora.impl.core.settingsconfig.c.b().b.contains("spp") == true) goto L27;
        g49.d.e(LabSettingsViewModel.TAG, "setRTCTransportMode ignored: spp is not allowed");
        return Unit.INSTANCE;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
