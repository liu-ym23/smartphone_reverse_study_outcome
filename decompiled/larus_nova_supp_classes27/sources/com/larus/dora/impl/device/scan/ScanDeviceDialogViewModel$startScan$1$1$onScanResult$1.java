package com.larus.dora.impl.device.scan;

import android.bluetooth.le.ScanResult;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.z;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.scan.ScanDeviceDialogViewModel$startScan$1$1$onScanResult$1", f = "ScanDeviceDialogViewModel.kt", i = {}, l = {71}, m = "invokeSuspend", n = {}, s = {})
public final class ScanDeviceDialogViewModel$startScan$1$1$onScanResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Set<String> $btConnectedDevices;
    final /* synthetic */ ScanResult $result;
    final /* synthetic */ Ref.LongRef $scanStartTime;
    int label;
    final /* synthetic */ ScanDeviceDialogViewModel this$0;

    public ScanDeviceDialogViewModel$startScan$1$1$onScanResult$1(ScanResult r1, Ref.LongRef r2, Set<String> r3, ScanDeviceDialogViewModel r4, Continuation<? super ScanDeviceDialogViewModel$startScan$1$1$onScanResult$1> r5) {
        this.$result = r1;
        this.$scanStartTime = r2;
        this.$btConnectedDevices = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new ScanDeviceDialogViewModel$startScan$1$1$onScanResult$1(this.$result, this.$scanStartTime, this.$btConnectedDevices, this.this$0, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L39:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        DoraDevice r9 = kj4.a.g().convertScanResultToDoraDevice(this.$result);
        g49.d.d("ScanDeviceDialogViewModel", "onDeviceFound: " + o59.a.h(r9));
        if (r9 == null) goto L41;
        if (r9.mac == null) goto L41;
        long r3 = this.$scanStartTime.element;
        if (r3 <= 0) goto L17;
        z r2 = z.a;
        z.d(r3);
        this.$scanStartTime.element = 0;
    L17:
        if (o59.a.t(r9) == true) goto L35;
        Set<String> r4 = this.$btConnectedDevices;
        boolean r5 = false;
        if ((r4 instanceof Collection) == true) goto L21;
    L23:
        Iterator<T> r6 = r4.iterator();
    L25:
        if (r6.hasNext() == false) goto L34;
        if (Intrinsics.areEqual((String) r6.next(), r9.mac) == true) goto L29;
    L31:
        boolean r7 = false;
    L32:
        if (r7 == false) goto L25;
        r5 = true;
        goto L34
    L29:
        if (kj4.a.g().getDoraLinkState(r9) == 2) goto L31;
        r7 = true;
    L34:
        if (r5 == false) goto L39;
    L21:
        if (r4.isEmpty() == false) goto L23;
    L35:
        j r10 = k.a(r9, kj4.a.g().getDoraLinkState(r9));
        MutableSharedFlow r11 = ScanDeviceDialogViewModel.access$get_scanDialogSharedFlow$p(this.this$0);
        this.label = 1;
        if (r11.emit(r10, this) != r0) goto L39;
        return r0;
    L41:
        return Unit.INSTANCE;
    }
}
