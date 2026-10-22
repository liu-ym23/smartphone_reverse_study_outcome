package com.larus.avlink.gallery.silent;

import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.silent.SilentSyncManager$appBackgroundListener$1$onAppForeground$1", f = "SilentSyncManager.kt", i = {}, l = {DoraCallStateCode.DOUBAO_STOP_RECORD_BY_GUI}, m = "invokeSuspend", n = {}, s = {})
public final class SilentSyncManager$appBackgroundListener$1$onAppForeground$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public SilentSyncManager$appBackgroundListener$1$onAppForeground$1(Continuation<? super SilentSyncManager$appBackgroundListener$1$onAppForeground$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new SilentSyncManager$appBackgroundListener$1$onAppForeground$1(r2);
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
        IDoraService r7 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r7 == null) goto L18;
        DeviceService r8 = r7.device();
        if (r8 == null) goto L18;
        if (r8.J() != true) goto L18;
    L20:
        if (r2 == false) goto L24;
        Job r3 = SilentSyncManager.a;
        if (SilentSyncManager.b() == false) goto L24;
        FLogger.a.i("SilentSyncManager", "app foreground and Dora connected, try start silent trans");
        SilentSyncManager.c();
    L26:
        return Unit.INSTANCE;
    L24:
        FLogger.a.i("SilentSyncManager", "app foreground, Dora connected: " + r2 + ", switch state: " + SilentSyncManager.e + ", skipping");
    L18:
        r2 = false;
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(3000, this) != r0) goto L11;
        return r0;
    }
}
