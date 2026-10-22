package com.larus.avlink.notification;

import com.larus.applog.api.IApplog;
import com.larus.audio.AudioServiceDelegate;
import com.larus.avlink.n1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.network.FlowHttpConnection;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.notification.DoraLinkStatusReporter$reportMicOccupyStatus$1", f = "DoraLinkStatusReporter.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
public final class DoraLinkStatusReporter$reportMicOccupyStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isOccupy;
    int label;

    public DoraLinkStatusReporter$reportMicOccupyStatus$1(boolean r1, Continuation<? super DoraLinkStatusReporter$reportMicOccupyStatus$1> r2) {
        this.$isOccupy = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraLinkStatusReporter$reportMicOccupyStatus$1(this.$isOccupy, r3);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L36:
        dm9.a.a r15 = (dm9.a) r14;
        if ((r15 instanceof dm9.a.b) == false) goto L40;
        DoraLinkStatusReporter r16 = DoraLinkStatusReporter.a;
        n1.d("DoraLinkStatusReporter", "report mic occupy status is success, isOccupy is " + this.$isOccupy);
    L43:
        return Unit.INSTANCE;
    L40:
        if ((r15 instanceof dm9.a.a) == false) goto L43;
        DoraLinkStatusReporter r2 = DoraLinkStatusReporter.a;
        n1.d("DoraLinkStatusReporter", "report mic occupy status is error due to " + r15.b + ", isOccupy is " + this.$isOccupy);
        goto L43
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        IDoraService r17 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        boolean r3 = false;
        if (r17 == null) goto L13;
        DeviceService r18 = r17.device();
        if (r18 == null) goto L13;
        boolean r19 = r18.J();
    L14:
        if (r19 == true) goto L18;
        return Unit.INSTANCE;
    L18:
        if (this.$isOccupy == false) goto L20;
    L23:
        IApplog.Companion r110 = IApplog.a;
        if (r110.getUserID().length() != 0) goto L26;
        boolean r4 = true;
    L27:
        if (r4 == true) goto L45;
        if (r110.getDeviceId().length() != 0) goto L31;
        r3 = true;
    L31:
        if (r3 == true) goto L45;
        b r5 = new b(r110.getUserID(), r110.getDeviceId(), Boxing.boxBoolean(this.$isOccupy), 220);
        DoraLinkApi.a r111 = DoraLinkApi.a;
        DoraLinkStatusReporter$reportMicOccupyStatus$1$result$1 r6 = new DoraLinkStatusReporter$reportMicOccupyStatus$1$result$1(r5, null);
        this.label = 1;
        r111.getClass();
        FlowHttpConnection r112 = FlowHttpConnection.a;
        r14 = FlowHttpConnection.g("Audio", DoraLinkApi.class, r6, false, null, null, null, this, 248);
        if (r14 != r0) goto L36;
        return r0;
    L45:
        return Unit.INSTANCE;
    L26:
        r4 = false;
        goto L27
    L20:
        if (AudioServiceDelegate.a.P().isRecording() == false) goto L23;
        DoraLinkStatusReporter r113 = DoraLinkStatusReporter.a;
        n1.d("DoraLinkStatusReporter", "AiNoteManager isRecording, ignore report isOccupy(false)");
        return Unit.INSTANCE;
    L13:
        r19 = false;
        goto L14
    }
}
