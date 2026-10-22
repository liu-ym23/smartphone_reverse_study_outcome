package com.larus.dora.impl.device.ota;

import com.larus.common.apphost.AppHost;
import com.larus.dora.api.model.FlowDoraConnectReason;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.DoraSimpleDevice;
import com.larus.dora.impl.trace.DarEvent;
import java.net.URL;
import java.util.Map;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTABuryPointManager$reportOtaEnd$1", f = "DoraOTABuryPointManager.kt", i = {}, l = {426}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOTABuryPointManager$reportOtaEnd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $failReason;
    final /* synthetic */ boolean $isSuccess;
    final /* synthetic */ String $otaReason;
    final /* synthetic */ int $retryCount;
    int label;

    public DoraOTABuryPointManager$reportOtaEnd$1(boolean r1, String r2, int r3, String r4, Continuation<? super DoraOTABuryPointManager$reportOtaEnd$1> r5) {
        this.$isSuccess = r1;
        this.$failReason = r2;
        this.$retryCount = r3;
        this.$otaReason = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new DoraOTABuryPointManager$reportOtaEnd$1(this.$isSuccess, this.$failReason, this.$retryCount, this.$otaReason, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        String r0 = "";
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        Pair[] r14 = new Pair[14];
        if (DoraOTABuryPointManager.r == false) goto L14;
        String r4 = "manual";
    L15:
        r14[0] = TuplesKt.to("update_method", r4);
        boolean r5 = this.$isSuccess;
        String r6 = FlowDoraConnectReason.SUCCESS;
        if (r5 == false) goto L18;
        Object r7 = FlowDoraConnectReason.SUCCESS;
    L19:
        r14[1] = TuplesKt.to("update_status", r7);
        r14[2] = TuplesKt.to("fail_reason", this.$failReason);
        r14[3] = TuplesKt.to("package_type", Boxing.boxInt(DoraOTABuryPointManager.o));
        r14[4] = TuplesKt.to("target_version", DoraOTABuryPointManager.l);
        r14[5] = TuplesKt.to("background", Boxing.boxInt(AppHost.a.a().isAppBackground() ? 1 : 0));
        r14[6] = TuplesKt.to("dora_link_state", Boxing.boxInt(kj4.a.g().getDoraLinkState(DoraOTABuryPointManager.q)));
        r14[7] = TuplesKt.to("bt_state", Boxing.boxInt(kj4.a.g().getBtConnectState(DoraOTABuryPointManager.q)));
        r14[8] = TuplesKt.to("download_error_code", Boxing.boxInt(DoraOTABuryPointManager.m));
        r14[9] = TuplesKt.to("idle_state", Boxing.boxInt(DoraOTABuryPointManager.p));
        if (DoraOTABuryPointManager.c == 0) goto L22;
    L25:
        r14[10] = TuplesKt.to("in_transfer", Boxing.boxBoolean(r3));
        String r8 = new URL(DoraOTABuryPointManager.n).getHost();     // Catch: Exception -> L28
        Intrinsics.checkNotNull(r8);     // Catch: Exception -> L28
    L29:
        r14[11] = TuplesKt.to("package_host", r8);
        r14[12] = TuplesKt.to("retry_time", Boxing.boxInt(this.$retryCount));
        r14[13] = TuplesKt.to("error_message", this.$otaReason);
        Map r15 = MapsKt.mutableMapOf(r14);
        long r9 = DoraOTABuryPointManager.h;
        if (r9 == (-1)) goto L32;
        r15.put("download_duration", Boxing.boxDouble(r9 / 1000.0d));
    L32:
        long r10 = DoraOTABuryPointManager.i;
        if (r10 == (-1)) goto L35;
        r15.put("transfer_duration", Boxing.boxDouble(r10 / 1000.0d));
    L35:
        String r11 = DoraOTABuryPointManager.l;
        if (DoraOTABuryPointManager.a() == true) goto L44;
        com.larus.dora.impl.util.b0.a.getClass();
        DoraSimpleDevice r12 = com.larus.dora.impl.util.b0.l();
        if (r12 == null) goto L44;
        String r16 = r12.getSerialNumber();
        if (r16 == null) goto L43;
        r0 = r16;
    L43:
        r15.put("series_no", r0);
    L44:
        DoraBuryPointManager.J(DoraBuryPointManager.a, "ota_update_end", r15, false, 12);
        DarEvent r17 = DarEvent.OtaUpdateEnd;
        r17.setMessage("reason:" + this.$failReason);
        Map<String, Object> r18 = r17.getExtra();
        if (this.$isSuccess == true) goto L48;
        r6 = "failure";
    L48:
        com.larus.utils.l.c(r18, "status", r6);
        com.larus.dora.impl.trace.a.a(r17);
        return Unit.INSTANCE;
    L28:
        r8 = "";
        goto L29
    L22:
        if (DoraOTABuryPointManager.d != 0) goto L25;
        r3 = false;
        goto L25
    L18:
        r7 = "failure";
        goto L19
    L14:
        r4 = "automatic";
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        this.label = 1;
        if (DelayKt.delay(1000, this) != r1) goto L11;
        return r1;
    }
}
