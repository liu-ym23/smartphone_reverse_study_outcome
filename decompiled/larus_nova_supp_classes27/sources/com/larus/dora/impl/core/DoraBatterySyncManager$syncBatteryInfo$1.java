package com.larus.dora.impl.core;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.network.i;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.core.DoraBatterySyncManager$syncBatteryInfo$1", f = "DoraBatterySyncManager.kt", i = {}, l = {110}, m = "invokeSuspend", n = {}, s = {})
final class DoraBatterySyncManager$syncBatteryInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Pair<String, String>> $batteryInfoList;
    final /* synthetic */ int $currentBatteryHash;
    final /* synthetic */ DoraDevice $device;
    final /* synthetic */ boolean $forceUpload;
    final /* synthetic */ String $source;
    int label;

    public DoraBatterySyncManager$syncBatteryInfo$1(DoraDevice r1, List<Pair<String, String>> r2, int r3, boolean r4, String r5, Continuation<? super DoraBatterySyncManager$syncBatteryInfo$1> r6) {
        this.$device = r1;
        this.$batteryInfoList = r2;
        this.$currentBatteryHash = r3;
        this.$forceUpload = r4;
        this.$source = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new DoraBatterySyncManager$syncBatteryInfo$1(this.$device, this.$batteryInfoList, this.$currentBatteryHash, this.$forceUpload, this.$source, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
        Object r8 = ((Result) r7).unbox-impl();
    L11:
        int r2 = this.$currentBatteryHash;
        boolean r3 = this.$forceUpload;
        String r4 = this.$source;
        List<Pair<String, String>> r5 = this.$batteryInfoList;
        if (Result.isSuccess-impl(r8) == false) goto L17;
        i r6 = (i) r8;
        CoroutineScope r9 = i.a;
        i.c = Boxing.boxInt(r2);
        if (r3 == false) goto L16;
        i.d = false;
    L16:
        g49.d.d("DoraBatterySyncManager", r4 + ": sync success, forceUpload=" + r3 + ", info=" + r5);
    L17:
        String r10 = this.$source;
        boolean r11 = this.$forceUpload;
        Throwable r12 = Result.exceptionOrNull-impl(r8);
        if (r12 == null) goto L21;
        g49.d.c("DoraBatterySyncManager", r10 + ": sync failed, forceUpload=" + r11, r12);
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        DoraNetworkApi r13 = DoraNetworkApi.a;
        DoraDevice r14 = this.$device;
        List<Pair<String, String>> r15 = this.$batteryInfoList;
        this.label = 1;
        r8 = r13.y(r14, r15, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
