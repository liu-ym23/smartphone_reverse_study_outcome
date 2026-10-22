package com.larus.dora.impl.device.ota;

import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.dora.impl.log.engine.OTALogReason;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import d49.c$c;
import d49.c$f;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAManagement$checkUpdates$1$2$1", f = "DoraOTAManagement.kt", i = {4, 5}, l = {694, 695, 705, 706, 712, 713}, m = "invokeSuspend", n = {"packageInfo", "packageInfo"}, s = {"L$0", "L$0"})
public final class DoraOTAManagement$checkUpdates$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<DoraDevice> $device;
    final /* synthetic */ String $from;
    final /* synthetic */ String $logPrefix;
    final /* synthetic */ z39.a $response;
    Object L$0;
    int label;

    public DoraOTAManagement$checkUpdates$1$2$1(z39.a r1, String r2, Ref.ObjectRef<DoraDevice> r3, String r4, Continuation<? super DoraOTAManagement$checkUpdates$1$2$1> r5) {
        this.$response = r1;
        this.$logPrefix = r2;
        this.$device = r3;
        this.$from = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraOTAManagement$checkUpdates$1$2$1(this.$response, this.$logPrefix, this.$device, this.$from, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r7 = "";
        switch(this.label) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            default: goto L5;
        };
    L6:
        OTAUpdatePackage r1 = (OTAUpdatePackage) this.L$0;
        ResultKt.throwOnFailure(r13);
    L78:
        com.larus.dora.impl.ota.b r14 = com.larus.dora.impl.ota.b.a;
        String r2 = ((DoraDevice) this.$device.element).sn;
        if (r2 != null) goto L81;
        r2 = "";
    L81:
        String r3 = r1.getVersion();
        if (r3 == null) goto L85;
        r7 = r3;
    L85:
        r14.b(r2, r7);
        List<OTAUpdatePackage> r15 = this.$response.b();
        if (r15 == null) goto L90;
        List r16 = CollectionsKt.filterNotNull(r15);
        if (r16 == null) goto L90;
        OTAUpdatePackage r17 = (OTAUpdatePackage) CollectionsKt.firstOrNull(r16);
    L91:
        String r4 = DoraOTABuryPointManager.l;
        DoraOTABuryPointManager.i(true, FlowDoraConnectReason.SUCCESS, r17);
        if (Intrinsics.areEqual(this.$from, OTAUpdateFrom.StartAutoOta.getScene()) == false) goto L94;
    L97:
        g49.d.d("DoraOTAManagement", "try checkToAutoOta from : " + this.$from);
        DoraOTAManagement r18 = DoraOTAManagement.a;
        DoraDevice r110 = (DoraDevice) this.$device.element;
        z39.a r5 = this.$response;
        g49.d.d("DoraOTAManagement", "checkToAutoOta");
        if ((DoraOTAManagement.e.getValue() instanceof c$f) == false) goto L100;
        g49.d.d("DoraOTAManagement", "checkToAutoOta: already in ota progressing");
    L132:
        return Unit.INSTANCE;
    L100:
        DoraSetting.a.getClass();
        if (DoraSetting.j().e() == false) goto L105;
        String r6 = DoraOTAManagement.V;
        if (r6 == null) goto L105;
        com.larus.dora.impl.trace.a.b(r6);
    L105:
        List<OTAUpdatePackage> r8 = r5.b();
        if (r8 == null) goto L110;
        List r9 = CollectionsKt.filterNotNull(r8);
        if (r9 == null) goto L110;
        OTAUpdatePackage r10 = (OTAUpdatePackage) CollectionsKt.firstOrNull(r9);
    L111:
        DoraOTABuryPointManager.h(r10);
        DoraOTABuryPointManager.n();
        int r111 = DoraOTAManagement.u(r110);
        boolean r11 = e.a();
        g49.d.d("DoraOTAManagement", "checkToAutoOta: isTest=" + r11);
        if (r10 == null) goto L118;
        StringBuilder r12 = new StringBuilder();
        File r20 = AppHost.a.getApplication().getExternalFilesDir(null);
        if (r20 == null) goto L116;
        String r21 = r20.getAbsolutePath();
    L117:
        r12.append(r21);
        r12.append("/dora/ota");
        String r22 = r12.toString() + '/' + r10.getName();
        g49.d.d("DoraOTAManagement", "checkToAutoOta: filePath=" + r22);
        Ref.BooleanRef r23 = new Ref.BooleanRef();
        BuildersKt.runBlocking$default(null, new DoraOTAManagement$budsReceivedFile$1(r23, r22, null), 1, null);
        boolean r24 = r23.element;
    L119:
        g49.d.d("DoraOTAManagement", "checkToAutoOta: isPackageReceived=" + r24);
        com.larus.dora.impl.util.b0.a.getClass();
        if (com.larus.dora.impl.util.b0.j().getBoolean("dora_auto_ota_switch_", true) == false) goto L125;
        if (r11 == true) goto L124;
        if (r24 == true) goto L125;
        if (r111 >= 5) goto L125;
    L124:
        DoraOTAManagement.B(AppHost.a.getApplication().getApplicationContext(), r5, false);
    L125:
        g49.d.d("DoraOTAManagement", "not satisfy to auto ota");
        g49.d.d("DoraOTAManagement", "DoraRepo.isAutoOTA(): " + com.larus.dora.impl.util.b0.j().getBoolean("dora_auto_ota_switch_", true));
        g49.d.d("DoraOTAManagement", "isPackageReceived " + r24);
        g49.d.d("DoraOTAManagement", "todayCount " + r111);
        if (com.larus.dora.impl.util.b0.j().getBoolean("dora_auto_ota_switch_", true) == true) goto L128;
        DoraOTAManagement.U = true;
        DoraOTABuryPointManager.o("automatic_switch_close", OTALogReason.AUTOMATIC_SWITCH_CLOSE.getMessage());
        goto L132
    L128:
        if (r24 == true) goto L130;
        if (r111 < 5) goto L132;
    L130:
        DoraOTABuryPointManager.o("no_remaining_times", OTALogReason.NO_REMAINING_TIMES.getMessage());
        goto L132
    L116:
        r21 = null;
        goto L117
    L118:
        r24 = false;
    L110:
        r10 = null;
        goto L111
    L94:
        if (Intrinsics.areEqual(this.$from, OTAUpdateFrom.BudsChanged.getScene()) == true) goto L97;
        if (Intrinsics.areEqual(this.$from, OTAUpdateFrom.AutoSwitch.getScene()) == false) goto L132;
    L90:
        r17 = null;
        goto L91
    L7:
        OTAUpdatePackage r25 = (OTAUpdatePackage) this.L$0;
        ResultKt.throwOnFailure(r13);
        OTAUpdatePackage r112 = r25;
    L74:
        MutableSharedFlow r26 = DoraOTAManagement.i;
        Pair r27 = new Pair(this.$device.element, this.$response);
        this.L$0 = r112;
        this.label = 6;
        if (r26.emit(r27, this) != r0) goto L77;
        return r0;
    L77:
        r1 = r112;
        goto L78
    L8:
        ResultKt.throwOnFailure(r13);
    L52:
        com.larus.dora.impl.ota.b r113 = com.larus.dora.impl.ota.b.a;
        String r28 = ((DoraDevice) this.$device.element).sn;
        if (r28 != null) goto L55;
        r28 = "";
    L55:
        r113.b(r28, "");
        goto L132
    L9:
        ResultKt.throwOnFailure(r13);
    L49:
        MutableSharedFlow r114 = DoraOTAManagement.i;
        Pair r30 = new Pair(this.$device.element, this.$response);
        this.label = 4;
        if (r114.emit(r30, this) != r0) goto L52;
        return r0;
    L10:
        ResultKt.throwOnFailure(r13);
    L23:
        com.larus.dora.impl.ota.b r115 = com.larus.dora.impl.ota.b.a;
        String r31 = ((DoraDevice) this.$device.element).sn;
        if (r31 != null) goto L26;
        r31 = "";
    L26:
        r115.b(r31, "");
        String r116 = DoraOTABuryPointManager.l;
        DoraOTABuryPointManager.i(false, "packageInfo_is_null", null);
        goto L132
    L11:
        ResultKt.throwOnFailure(r13);
    L20:
        MutableSharedFlow r117 = DoraOTAManagement.i;
        Pair r32 = new Pair(this.$device.element, this.$response);
        this.label = 2;
        if (r117.emit(r32, this) != r0) goto L23;
        return r0;
    L12:
        ResultKt.throwOnFailure(r13);
        z39.a r118 = this.$response;
        if (r118 != null) goto L27;
        g49.d.d("DoraOTAManagement", this.$logPrefix + " response is null");
        HashMap r119 = DoraOTAManagement.k;
        String r33 = ((DoraDevice) this.$device.element).mac;
        if (r33 != null) goto L17;
        r33 = "";
    L17:
        r119.remove(r33);
        StateFlowImpl r120 = DoraOTAManagement.e;
        c$c r34 = new c$c(null, ((DoraDevice) this.$device.element).softVersion, "");
        this.label = 1;
        r120.setValue(r34);
        if (Unit.INSTANCE != r0) goto L20;
        return r0;
    L27:
        k0 r35 = DoraOTAReporter.a;
        DoraDevice r36 = (DoraDevice) this.$device.element;
        String r37 = r36.sn;
        if (r37 != null) goto L30;
        r37 = "";
    L30:
        String r38 = r36.typeName;
        if (r38 != null) goto L33;
        r38 = "OWS-Pro";
    L33:
        String r40 = r36.softVersion;
        String r121 = r118.d();
        if (r121 != null) goto L36;
        r121 = "";
    L36:
        DoraOTAReporter.a(r37, r38, r40, DoraObricDeviceHomeViewModel.DEFAULT_DEVICE_NAME, r121);
        List<OTAUpdatePackage> r122 = this.$response.b();
        if (r122 == null) goto L41;
        List r123 = CollectionsKt.filterNotNull(r122);
        if (r123 == null) goto L41;
        r112 = (OTAUpdatePackage) CollectionsKt.firstOrNull(r123);
    L42:
        if (r112 != null) goto L56;
        g49.d.d("DoraOTAManagement", this.$logPrefix + " packageInfo is null");
        HashMap r124 = DoraOTAManagement.k;
        String r41 = ((DoraDevice) this.$device.element).mac;
        if (r41 != null) goto L46;
        r41 = "";
    L46:
        r124.remove(r41);
        c$c r125 = new c$c(null, ((DoraDevice) this.$device.element).softVersion, "");
        DoraOTAManagement.I = r125;
        StateFlowImpl r42 = DoraOTAManagement.e;
        this.label = 3;
        r42.setValue(r125);
        if (Unit.INSTANCE != r0) goto L49;
        return r0;
    L56:
        g49.d.d("DoraOTAManagement", this.$logPrefix + " packageInfo " + r112 + ", " + this.$response.a());
        HashMap r43 = DoraOTAManagement.k;
        String r44 = ((DoraDevice) this.$device.element).mac;
        if (r44 != null) goto L59;
        r44 = "";
    L59:
        String r45 = r112.getVersion();
        if (r45 != null) goto L62;
        r45 = "";
    L62:
        r43.put(r44, r45);
        z39.a r46 = this.$response;
        DoraDevice r126 = (DoraDevice) this.$device.element;
        String r127 = r126.softVersion;
        if (r126 == null) goto L70;
        String r128 = r126.mac;
        if (r128 != null) goto L68;
        r128 = "";
    L68:
        String r47 = (String) r43.get(r128);
        if (r47 == null) goto L70;
    L71:
        c$c r48 = new c$c(r46, r127, r47);
        DoraOTAManagement.I = r48;
        StateFlowImpl r50 = DoraOTAManagement.e;
        this.L$0 = r112;
        this.label = 5;
        r50.setValue(r48);
        if (Unit.INSTANCE != r0) goto L74;
        return r0;
    L70:
        r47 = "";
    L41:
        r112 = null;
        goto L42
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
