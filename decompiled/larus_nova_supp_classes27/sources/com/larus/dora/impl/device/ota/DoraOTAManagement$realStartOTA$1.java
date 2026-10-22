package com.larus.dora.impl.device.ota;

import android.content.Context;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.api.device.ota.model.OTAUpdatePackage;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.DoraSimpleDevice;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.log.engine.OTALogReason;
import com.larus.dora.impl.settings.h1;
import d49.c$f;
import java.util.List;
import java.util.Map;
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
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTAManagement$realStartOTA$1", f = "DoraOTAManagement.kt", i = {}, l = {911, 923}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOTAManagement$realStartOTA$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ h1 $bypassStateDetectConfig;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isManual;
    final /* synthetic */ z39.a $response;
    int label;

    public DoraOTAManagement$realStartOTA$1(boolean r1, z39.a r2, h1 r3, Context r4, Continuation<? super DoraOTAManagement$realStartOTA$1> r5) {
        this.$isManual = r1;
        this.$response = r2;
        this.$bypassStateDetectConfig = r3;
        this.$context = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraOTAManagement$realStartOTA$1(this.$isManual, this.$response, this.$bypassStateDetectConfig, this.$context, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L55:
        String r15 = DoraOTABuryPointManager.l;
        OTALogReason r16 = OTALogReason.LOW_BATTERY;
        DoraOTABuryPointManager.o(r16.getMessage(), null);
        ck4.a.a.a.a("ota_update_pre_check#" + r16.getMessage(), false);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
    L44:
        String r17 = DoraOTABuryPointManager.l;
        OTALogReason r18 = OTALogReason.BUDS_NOT_READY;
        DoraOTABuryPointManager.o(FlowDoraConnectReason.SUCCESS, r18.getMessage());
        ck4.a.a.a.a("ota_update_pre_check#" + r18.getMessage(), false);
        DoraOTAManagement.T = true;
        return Unit.INSTANCE;
    L10:
        ResultKt.throwOnFailure(r14);
        if ((DoraOTAManagement.e.getValue() instanceof c$f) == false) goto L14;
        g49.d.d("DoraOTAManagement", "startOTA: already in ota progressing");
        return Unit.INSTANCE;
    L14:
        DoraDevice r110 = DoraAdapterExtKt.h(kj4.a.g());
        g49.d.d("DoraOTAManagement", "startOTA: device = " + r110);
        if (this.$isManual == false) goto L57;
        if (r110 != null) goto L19;
        g49.d.d("DoraOTAManagement", "device == null, not to download");
        return Unit.INSTANCE;
    L19:
        List<OTAUpdatePackage> r8 = this.$response.b();
        if (r8 == null) goto L24;
        List r9 = CollectionsKt.filterNotNull(r8);
        if (r9 == null) goto L24;
        OTAUpdatePackage r10 = (OTAUpdatePackage) CollectionsKt.firstOrNull(r9);
    L25:
        String r11 = DoraOTABuryPointManager.l;
        DoraOTABuryPointManager.h(r10);
        DoraOTABuryPointManager.n();
        g49.d.d("DoraOTAManagement", "realStartOTA: bypassBudsStateDetect is " + this.$bypassStateDetectConfig.b() + ", bypassBatteryDetect is " + this.$bypassStateDetectConfig.a());
        if (this.$bypassStateDetectConfig.b() == true) goto L47;
        int[] r12 = o59.a.i(r110);
        if (r12 != null) goto L30;
    L32:
        boolean r13 = false;
    L33:
        if (r13 == true) goto L47;
        int[] r20 = o59.a.i(r110);
        if (r20 != null) goto L37;
    L39:
        boolean r21 = false;
    L40:
        if (r21 == true) goto L47;
        g49.d.b("DoraOTAManagement", "startOTA: Interrupted due to buds connection");
        MutableSharedFlow r111 = DoraOTAManagement.g;
        j0.a r2 = j0.a.a;
        this.label = 1;
        if (r111.emit(r2, this) != r0) goto L44;
        return r0;
    L37:
        if (r20[2] != 0) goto L39;
        r21 = true;
        goto L40
    L30:
        if (r12[2] != 3) goto L32;
        r13 = true;
    L47:
        if (this.$bypassStateDetectConfig.a() == true) goto L60;
        DoraOTAManagement r22 = DoraOTAManagement.a;
        if (DoraOTAManagement.r(r110) >= DoraOTAManagement.s()) goto L51;
    L52:
        g49.d.b("DoraOTAManagement", "startOTA: Interrupted due to low battery");
        MutableSharedFlow r112 = DoraOTAManagement.g;
        j0.b r3 = j0.b.a;
        this.label = 2;
        if (r112.emit(r3, this) != r0) goto L55;
        return r0;
    L51:
        if (DoraOTAManagement.t(r110) < DoraOTAManagement.s()) goto L52;
    L60:
        g49.d.d("DoraOTAManagement", "start download");
        if (this.$isManual == true) goto L63;
        DoraOTAManagement.n.set(false);
    L63:
        DoraOTAManagement.x = !this.$isManual;
        DoraOTAManagement.e(0, this.$response, 0);
        String r4 = DoraOTABuryPointManager.l;
        DoraOTABuryPointManager.o(FlowDoraConnectReason.SUCCESS, null);
        Pair[] r5 = new Pair[1];
        if (DoraOTABuryPointManager.r == false) goto L66;
        String r6 = "manual";
    L67:
        r5[0] = TuplesKt.to("update_method", r6);
        Map r7 = MapsKt.mutableMapOf(r5);
        if (DoraOTABuryPointManager.a() == true) goto L75;
        com.larus.dora.impl.util.b0.a.getClass();
        DoraSimpleDevice r23 = com.larus.dora.impl.util.b0.l();
        if (r23 == null) goto L75;
        String r24 = r23.getSerialNumber();
        if (r24 != null) goto L74;
        r24 = "";
    L74:
        r7.put("series_no", r24);
    L75:
        DoraBuryPointManager.J(DoraBuryPointManager.a, "ota_update_start", r7, false, 12);
        DoraOTABuryPointManager.s = 0;
        DoraOTAManagement.a(this.$context, r110, this.$response);
        return Unit.INSTANCE;
    L66:
        r6 = "automatic";
    L24:
        r10 = null;
        goto L25
    L57:
        if (r110 != null) goto L60;
        g49.d.d("DoraOTAManagement", "device == null, not to download");
        return Unit.INSTANCE;
    }
}
