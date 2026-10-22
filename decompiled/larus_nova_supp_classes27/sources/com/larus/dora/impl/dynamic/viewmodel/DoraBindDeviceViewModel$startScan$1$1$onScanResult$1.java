package com.larus.dora.impl.dynamic.viewmodel;

import android.bluetooth.le.ScanResult;
import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.core.z;
import com.larus.dora.impl.device.scan.j;
import com.larus.dora.impl.device.scan.k;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.dynamic.viewmodel.DoraBindDeviceViewModel$startScan$1$1$onScanResult$1", f = "DoraBindDeviceViewModel.kt", i = {0, 2}, l = {90, 91, 108, 109}, m = "invokeSuspend", n = {"deviceModel", "deviceModel"}, s = {"L$0", "L$0"})
public final class DoraBindDeviceViewModel$startScan$1$1$onScanResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Set<String> $btConnectedDevices;
    final /* synthetic */ Ref.ObjectRef<DoraDevice> $firstScannedDoraDevice;
    final /* synthetic */ boolean $hasInputMac;
    final /* synthetic */ ScanResult $result;
    final /* synthetic */ Ref.BooleanRef $scanNoLimit;
    final /* synthetic */ Ref.LongRef $scanStartTime;
    Object L$0;
    int label;
    final /* synthetic */ DoraBindDeviceViewModel this$0;

    public DoraBindDeviceViewModel$startScan$1$1$onScanResult$1(ScanResult r1, boolean r2, Ref.BooleanRef r3, Ref.LongRef r4, Set<String> r5, DoraBindDeviceViewModel r6, Ref.ObjectRef<DoraDevice> r7, Continuation<? super DoraBindDeviceViewModel$startScan$1$1$onScanResult$1> r8) {
        this.$result = r1;
        this.$hasInputMac = r2;
        this.$scanNoLimit = r3;
        this.$scanStartTime = r4;
        this.$btConnectedDevices = r5;
        this.this$0 = r6;
        this.$firstScannedDoraDevice = r7;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new DoraBindDeviceViewModel$startScan$1$1$onScanResult$1(this.$result, this.$hasInputMac, this.$scanNoLimit, this.$scanStartTime, this.$btConnectedDevices, this.this$0, this.$firstScannedDoraDevice, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 == 4) goto L12;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        j r2 = (j) this.L$0;
        ResultKt.throwOnFailure(r13);
    L52:
        MutableSharedFlow r14 = DoraBindDeviceViewModel.access$get_scanDialogSharedFlow$p(this.this$0);
        this.L$0 = null;
        this.label = 4;
        if (r14.emit(r2, this) != r0) goto L56;
        return r0;
    L56:
        return Unit.INSTANCE;
    L12:
        ResultKt.throwOnFailure(r13);
        goto L56
    L13:
        j r3 = (j) this.L$0;
        ResultKt.throwOnFailure(r13);
    L35:
        MutableSharedFlow r15 = DoraBindDeviceViewModel.access$get_scanDialogSharedFlow$p(this.this$0);
        this.L$0 = null;
        this.label = 2;
        if (r15.emit(r3, this) != r0) goto L56;
        return r0;
    L14:
        ResultKt.throwOnFailure(r13);
        DoraDevice r16 = kj4.a.g().convertScanResultToDoraDevice(this.$result);
        StringBuilder r4 = new StringBuilder("startScanAndLaunchOnboarding: onDeviceFound ");
        if (r16 == null) goto L17;
        String r7 = o59.a.h(r16);
    L18:
        r4.append(r7);
        r4.append(",hasInputMac=");
        r4.append(this.$hasInputMac);
        r4.append(", scanNoLimit=");
        r4.append(this.$scanNoLimit.element);
        g49.d.d(DoraDynamicViewModel.TAG, r4.toString());
        if (r16 == null) goto L58;
        String r5 = r16.mac;
        if (r5 == null) goto L58;
        long r8 = this.$scanStartTime.element;
        if (r8 <= 0) goto L27;
        z r11 = z.a;
        z.d(r8);
        this.$scanStartTime.element = 0;
    L27:
        if (this.$hasInputMac == false) goto L44;
        if (this.$scanNoLimit.element == true) goto L44;
        if (this.$btConnectedDevices.contains(r5) == false) goto L39;
        DoraBindDeviceViewModel.access$stopScan(this.this$0, "startScanAndLaunchOnboarding: launchOnBoarding");
        r3 = k.a(r16, kj4.a.g().getDoraLinkState(r16));
        MutableSharedFlow r6 = DoraBindDeviceViewModel.access$get_scanDeviceFlow$p(this.this$0);
        this.L$0 = r3;
        this.label = 1;
        if (r6.emit(r16, this) != r0) goto L35;
        return r0;
    L39:
        if (o59.a.t(r16) == false) goto L56;
        Ref.ObjectRef<DoraDevice> r9 = this.$firstScannedDoraDevice;
        if (r9.element != null) goto L56;
        r9.element = r16;
    L44:
        if (o59.a.t(r16) == false) goto L46;
    L49:
        DoraBindDeviceViewModel.access$stopScan(this.this$0, "startScanAndLaunchOnboarding: launchOnBoarding");
        r2 = k.a(r16, kj4.a.g().getDoraLinkState(r16));
        MutableSharedFlow r10 = DoraBindDeviceViewModel.access$get_scanDeviceFlow$p(this.this$0);
        this.L$0 = r2;
        this.label = 3;
        if (r10.emit(r16, this) != r0) goto L52;
        return r0;
    L46:
        if (this.$scanNoLimit.element == false) goto L56;
        if (this.$btConnectedDevices.contains(r5) == false) goto L56;
    L58:
        return Unit.INSTANCE;
    L17:
        r7 = null;
        goto L18
    }
}
