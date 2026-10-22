package com.larus.dora.impl.device.ota;

import com.bytedance.dora.device.DoraDevice;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.DoraSimpleDevice;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.ota.DoraOTABuryPointManager$reportOtaStageEvent$1", f = "DoraOTABuryPointManager.kt", i = {}, l = {365}, m = "invokeSuspend", n = {}, s = {})
public final class DoraOTABuryPointManager$reportOtaStageEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Object> $copyParams;
    final /* synthetic */ String $event;
    int label;

    public DoraOTABuryPointManager$reportOtaStageEvent$1(Map<String, Object> r1, String r2, Continuation<? super DoraOTABuryPointManager$reportOtaStageEvent$1> r3) {
        this.$copyParams = r1;
        this.$event = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraOTABuryPointManager$reportOtaStageEvent$1(this.$copyParams, this.$event, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        Map<String, Object> r7 = this.$copyParams;
        if (DoraOTABuryPointManager.r == false) goto L14;
        String r3 = "manual";
    L15:
        r7.put("update_method", r3);
        r7.put("package_type", Boxing.boxInt(DoraOTABuryPointManager.o));
        r7.put("target_version", DoraOTABuryPointManager.l);
        DoraDevice r4 = DoraOTABuryPointManager.q;
        if (r4 != null) goto L18;
    L20:
        boolean r5 = false;
    L21:
        r7.put("is_same_version", Boxing.boxBoolean(!r5));
        r7.put("background", Boxing.boxInt(AppHost.a.a().isAppBackground() ? 1 : 0));
        r7.put("idle_state", Boxing.boxInt(DoraOTABuryPointManager.p));
        r7.put("package_type_retry_count", Boxing.boxInt(DoraOTABuryPointManager.s));
        r7.put("dora_link_state", Boxing.boxInt(kj4.a.g().getDoraLinkState(DoraOTABuryPointManager.q)));
        r7.put("bt_state", Boxing.boxInt(kj4.a.g().getBtConnectState(DoraOTABuryPointManager.q)));
        DoraDevice r8 = DoraOTABuryPointManager.q;
        if (r8 == null) goto L34;
        int[] r9 = o59.a.i(r8);
        if (r9 == null) goto L34;
        if (r9.length > 2) goto L29;
        r2 = false;
    L29:
        if (r2 == true) goto L32;
        r9 = null;
    L32:
        if (r9 == null) goto L34;
        int r10 = r9[2];
    L35:
        r7.put("dora_ears_status", Boxing.boxInt(r10));
        String r11 = DoraOTABuryPointManager.l;
        if (DoraOTABuryPointManager.a() == true) goto L43;
        com.larus.dora.impl.util.b0.a.getClass();
        DoraSimpleDevice r12 = com.larus.dora.impl.util.b0.l();
        if (r12 == null) goto L43;
        Map<String, Object> r13 = this.$copyParams;
        String r14 = r12.getSerialNumber();
        if (r14 != null) goto L42;
        r14 = "";
    L42:
        r13.put("series_no", r14);
    L43:
        DoraBuryPointManager.J(DoraBuryPointManager.a, this.$event, this.$copyParams, false, 12);
        return Unit.INSTANCE;
    L34:
        r10 = -1;
        goto L35
    L18:
        if (r4.inconsistentVersions != 2) goto L20;
        r5 = true;
        goto L21
    L14:
        r3 = "automatic";
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L11;
        return r0;
    }
}
