package com.larus.dora.impl.device.manage.viewmodel;

import com.bytedance.dora.device.DoraDevice;
import com.larus.dora.impl.device.manage.a1;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.manage.viewmodel.DoraGDeviceManagementViewModel$deviceStateCallback$1$onDoraLinkStateChanged$2", f = "DoraGDeviceManagementViewModel.kt", i = {1}, l = {266, 274, 278}, m = "invokeSuspend", n = {"event"}, s = {"L$0"})
public final class DoraGDeviceManagementViewModel$deviceStateCallback$1$onDoraLinkStateChanged$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $state;
    Object L$0;
    int label;
    final /* synthetic */ DoraGDeviceManagementViewModel this$0;

    public DoraGDeviceManagementViewModel$deviceStateCallback$1$onDoraLinkStateChanged$2(DoraGDeviceManagementViewModel r1, int r2, Continuation<? super DoraGDeviceManagementViewModel$deviceStateCallback$1$onDoraLinkStateChanged$2> r3) {
        this.this$0 = r1;
        this.$state = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraGDeviceManagementViewModel$deviceStateCallback$1$onDoraLinkStateChanged$2(this.this$0, this.$state, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r11);
    L38:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        com.larus.dora.impl.device.manage.a r2 = (com.larus.dora.impl.device.manage.a) this.L$0;
        ResultKt.throwOnFailure(r11);
    L29:
        a1 r12 = DoraGDeviceManagementViewModel.access$getDeviceSwitchListener$p(this.this$0);
        if (r12 == null) goto L33;
        r12.a(r2);
    L33:
        if (this.$state != 0) goto L38;
        DoraGDeviceManagementViewModel r13 = this.this$0;
        this.L$0 = null;
        this.label = 3;
        if (r13.updateOnlyFirmwareUpdateCard(true, this) != r0) goto L38;
        return r0;
    L11:
        ResultKt.throwOnFailure(r11);
    L15:
        List r14 = (List) r11;
        DoraGDeviceManagementViewModel r6 = this.this$0;
        Iterator r3 = r14.iterator();
    L17:
        if (r3.hasNext() == false) goto L21;
        Object r7 = r3.next();
        if (Intrinsics.areEqual(((DoraDevice) r7).mac, DoraGDeviceManagementViewModel.access$getCurrentDeviceMac$p(r6)) == false) goto L17;
    L22:
        DoraDevice r8 = (DoraDevice) r7;
        if (r8 != null) goto L25;
        r8 = (DoraDevice) CollectionsKt.firstOrNull(r14);
    L25:
        if (r8 == null) goto L33;
        r2 = new com.larus.dora.impl.device.manage.a(DoraGDeviceManagementViewModel.access$buildDeviceComponentData(this.this$0, r8).a);
        this.L$0 = r2;
        this.label = 2;
        if (DelayKt.delay(50, this) != r0) goto L29;
        return r0;
    L21:
        r7 = null;
        goto L22
    L12:
        ResultKt.throwOnFailure(r11);
        CoroutineDispatcher r15 = Dispatchers.getIO();
        DoraGDeviceManagementViewModel$deviceStateCallback$1$onDoraLinkStateChanged$2$rawBindList$1 r4 = new DoraGDeviceManagementViewModel$deviceStateCallback$1$onDoraLinkStateChanged$2$rawBindList$1(null);
        this.label = 1;
        r11 = BuildersKt.withContext(r15, r4, this);
        if (r11 != r0) goto L15;
        return r0;
    }
}
