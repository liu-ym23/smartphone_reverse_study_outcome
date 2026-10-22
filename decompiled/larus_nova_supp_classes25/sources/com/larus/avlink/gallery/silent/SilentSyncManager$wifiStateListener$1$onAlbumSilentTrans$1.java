package com.larus.avlink.gallery.silent;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.model.FlowDoraGlassOpenState;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.utils.logger.FLogger;
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
@DebugMetadata(c = "com.larus.avlink.gallery.silent.SilentSyncManager$wifiStateListener$1$onAlbumSilentTrans$1", f = "SilentSyncManager.kt", i = {}, l = {132}, m = "invokeSuspend", n = {}, s = {})
final class SilentSyncManager$wifiStateListener$1$onAlbumSilentTrans$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enable;
    int label;

    public SilentSyncManager$wifiStateListener$1$onAlbumSilentTrans$1(boolean r1, Continuation<? super SilentSyncManager$wifiStateListener$1$onAlbumSilentTrans$1> r2) {
        this.$enable = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SilentSyncManager$wifiStateListener$1$onAlbumSilentTrans$1(this.$enable, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L20:
        Job r5 = SilentSyncManager.a;
        SilentSyncManager.c();
    L35:
        SilentSyncManager.h = false;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        if (this.$enable == false) goto L29;
        IDoraService r6 = SilentSyncManager.c;
        if (r6 == null) goto L16;
        DeviceService r7 = r6.device();
        if (r7 == null) goto L16;
        r7.g(SilentSyncManager.m);
    L16:
        if (SilentSyncManager.h == false) goto L22;
        this.label = 1;
        if (DelayKt.delay(3000, this) != r0) goto L20;
        return r0;
    L22:
        if (SilentSyncManager.f != FlowDoraGlassOpenState.CLOSE.getValue()) goto L25;
        FLogger.a.i("SilentSyncManager", "Silent transfer switch enabled and glass is closed - triggering silent sync");
        Job r8 = SilentSyncManager.a;
        SilentSyncManager.c();
        goto L35
    L25:
        if (((Number) SilentSyncManager.g.getFirst()).intValue() <= 0) goto L27;
    L28:
        FLogger.a.i("SilentSyncManager", "Silent transfer switch enabled and album has media content - scheduling auto sync");
        SilentSyncManager.a("switch_on");
        goto L35
    L27:
        if (((Number) SilentSyncManager.g.getSecond()).intValue() <= 0) goto L35;
    L29:
        IDoraService r9 = SilentSyncManager.c;
        if (r9 == null) goto L34;
        DeviceService r10 = r9.device();
        if (r10 == null) goto L34;
        r10.w0(SilentSyncManager.m);
    L34:
        Job r11 = SilentSyncManager.a;
        SilentSyncManager.d("Switch Off");
        goto L35
    }
}
