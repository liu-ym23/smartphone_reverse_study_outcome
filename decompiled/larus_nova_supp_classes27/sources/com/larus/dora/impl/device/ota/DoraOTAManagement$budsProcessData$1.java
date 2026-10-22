package com.larus.dora.impl.device.ota;

import com.bytedance.dora.device.DoraDevice;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import d49.c$f;
import d49.c$g;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAManagement$budsProcessData$1", f = "DoraOTAManagement.kt", i = {1, 1, 3, 3, 4, 5}, l = {1553, 1558, 1561, 1564, 1571, 1573}, m = "invokeSuspend", n = {"delayTime", "i", "delayTime", "i", "version", "version"}, s = {"J$0", "I$0", "J$0", "I$0", "L$0", "L$0"})
final class DoraOTAManagement$budsProcessData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DoraDevice $device;
    final /* synthetic */ int $otaTaskId;
    final /* synthetic */ z39.a $response;
    int I$0;
    long J$0;
    Object L$0;
    int label;

    public DoraOTAManagement$budsProcessData$1(z39.a r1, int r2, DoraDevice r3, Continuation<? super DoraOTAManagement$budsProcessData$1> r4) {
        this.$response = r1;
        this.$otaTaskId = r2;
        this.$device = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraOTAManagement$budsProcessData$1(this.$response, this.$otaTaskId, this.$device, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x010f -> B:50:0x0112). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        String r2 = null;
        String r5 = "";
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
        String r1 = (String) this.L$0;
        ResultKt.throwOnFailure(r15);
        DoraOTAManagement$budsProcessData$1 r3 = this;
    L76:
        com.larus.dora.impl.ota.b r16 = com.larus.dora.impl.ota.b.a;
        String r4 = r3.$device.sn;
        if (r4 == null) goto L80;
        r5 = r4;
    L80:
        r16.b(r5, r1);
        g49.d.d("DoraOTAManagement", "ota<" + r3.$otaTaskId + ">: budsProcessData success");
        DoraOTAManagement r17 = DoraOTAManagement.a;
        String r18 = DoraOTAManagement.q(r3.$device);
        if (new PolarisFileWrapper(r18).delete() == true) goto L84;
        g49.d.d("DoraOTAManagement", "delete file " + r18 + " failed");
    L84:
        return Unit.INSTANCE;
    L7:
        String r6 = (String) this.L$0;
        ResultKt.throwOnFailure(r15);
        r1 = r6;
        r3 = this;
    L68:
        if (DoraOTAManagement.H == false) goto L73;
        HashMap r7 = DoraOTAManagement.k;
        String r8 = r3.$device.mac;
        if (r8 != null) goto L72;
        r8 = "";
    L72:
        r7.remove(r8);
    L73:
        MutableSharedFlow r9 = DoraOTAManagement.i;
        Pair r10 = new Pair(r3.$device, r3.$response);
        r3.L$0 = r1;
        r3.label = 6;
        if (r9.emit(r10, r3) != r0) goto L76;
        return r0;
    L8:
        int r11 = this.I$0;
        long r12 = this.J$0;
        ResultKt.throwOnFailure(r15);
        DoraOTAManagement$budsProcessData$1 r110 = this;
    L50:
        int r13 = r11 + 1;
        r3 = r110;
        int r111 = r13;
    L37:
        if (r111 >= 101) goto L52;
        r3.J$0 = r12;
        r3.I$0 = r111;
        r3.label = 2;
        if (DelayKt.delay(r12, r3) != r0) goto L42;
        return r0;
    L42:
        if (DoraOTAManagement.z.get() == true) goto L46;
        String r112 = DoraOTABuryPointManager.l;
        DoraOTABuryPointManager.e(null);
        StateFlowImpl r113 = DoraOTAManagement.e;
        c$f r14 = new c$f(r3.$otaTaskId, r3.$response, 100);
        r3.label = 3;
        r113.setValue(r14);
        if (Unit.INSTANCE != r0) goto L52;
        return r0;
    L46:
        StateFlowImpl r20 = DoraOTAManagement.e;
        c$f r114 = new c$f(r3.$otaTaskId, r3.$response, r111);
        r3.J$0 = r12;
        r3.I$0 = r111;
        r3.label = 4;
        r20.setValue(r114);
        if (Unit.INSTANCE != r0) goto L49;
        return r0;
    L49:
        DoraOTAManagement$budsProcessData$1 r115 = r3;
        r11 = r111;
        r110 = r115;
    L52:
        if (DoraOTAManagement.z.get() == false) goto L54;
        String r116 = DoraOTABuryPointManager.l;
        DoraOTABuryPointManager.e("reconnect_timeout");
    L54:
        List<OTAUpdatePackage> r117 = r3.$response.b();
        if (r117 == null) goto L61;
        List r118 = CollectionsKt.filterNotNull(r117);
        if (r118 == null) goto L61;
        OTAUpdatePackage r119 = (OTAUpdatePackage) CollectionsKt.firstOrNull(r118);
        if (r119 == null) goto L61;
        r2 = r119.getVersion();
    L61:
        if (r2 != null) goto L63;
        r2 = "";
    L63:
        StateFlowImpl r120 = DoraOTAManagement.e;
        c$g r21 = new c$g(r3.$otaTaskId, r3.$response, r2);
        r3.L$0 = r2;
        r3.label = 5;
        r120.setValue(r21);
        if (Unit.INSTANCE != r0) goto L66;
        return r0;
    L66:
        r1 = r2;
        goto L68
    L9:
        ResultKt.throwOnFailure(r15);
        r3 = this;
        goto L52
    L10:
        int r22 = this.I$0;
        r12 = this.J$0;
        ResultKt.throwOnFailure(r15);
        r111 = r22;
        r3 = this;
        goto L42
    L11:
        ResultKt.throwOnFailure(r15);
    L30:
        r3 = this;
        goto L54
    L12:
        ResultKt.throwOnFailure(r15);
        List<OTAUpdatePackage> r121 = this.$response.b();
        boolean r23 = false;
        if (r121 == null) goto L19;
        List r122 = CollectionsKt.filterNotNull(r121);
        if (r122 == null) goto L19;
        OTAUpdatePackage r123 = (OTAUpdatePackage) CollectionsKt.firstOrNull(r122);
        if (r123 == null) goto L19;
        int r124 = r123.getType();
    L20:
        if (r124 != 2) goto L22;
        r23 = true;
    L22:
        if (r23 == false) goto L24;
        r12 = 7500;
    L26:
        if (DoraOTAManagement.H == true) goto L31;
        StateFlowImpl r125 = DoraOTAManagement.e;
        c$f r24 = new c$f(this.$otaTaskId, this.$response, 100);
        this.label = 1;
        r125.setValue(r24);
        if (Unit.INSTANCE != r0) goto L30;
        return r0;
    L31:
        String r126 = DoraOTABuryPointManager.l;
        if (DoraOTABuryPointManager.e != 0) goto L35;
        DoraOTABuryPointManager.e = System.currentTimeMillis();
        DoraOTABuryPointManager.k("ota_update_reboot", MapsKt.mapOf(TuplesKt.to("step", "start")));
    L35:
        DoraOTAManagement.z.set(true);
        r111 = 81;
        r3 = this;
        goto L37
    L24:
        r12 = 3000;
    L19:
        r124 = 0;
        goto L20
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
