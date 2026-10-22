package com.larus.avlink.gallery.silent;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.VisionService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.silent.SilentSyncManager$scheduleAutoSync$1$1", f = "SilentSyncManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class SilentSyncManager$scheduleAutoSync$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $triggerReason;
    int label;

    public SilentSyncManager$scheduleAutoSync$1$1(String r1, Continuation<? super SilentSyncManager$scheduleAutoSync$1$1> r2) {
        this.$triggerReason = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new SilentSyncManager$scheduleAutoSync$1$1(this.$triggerReason, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r7);
        IDoraService r8 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Exception -> L21
        if (r8 == null) goto L10;
        VisionService r9 = r8.V();     // Catch: Exception -> L21
        if (r9 == null) goto L10;
        Pair r10 = r9.l();     // Catch: Exception -> L21
    L11:
        if (r10 != null) goto L14;
        FLogger.a.w("SilentSyncManager", "Failed to get diffMedia, will retry next cycle");     // Catch: Exception -> L21
        return Unit.INSTANCE;
    L14:
        int r3 = ((Number) r10.getFirst()).intValue();     // Catch: Exception -> L21
        int r11 = ((Number) r10.getSecond()).intValue();     // Catch: Exception -> L21
        FLogger r4 = FLogger.a;     // Catch: Exception -> L21
        r4.d("SilentSyncManager", "Diff media check: photos=" + r3 + ", videos=" + r11);     // Catch: Exception -> L21
        if (r3 > 0) goto L19;
        if (r11 > 0) goto L19;
        r4.i("SilentSyncManager", "No new media found, will check again in next cycle");     // Catch: Exception -> L21
        return Unit.INSTANCE;
    L19:
        r4.i("SilentSyncManager", "Auto sync triggered: found " + r3 + " photos and " + r11 + " videos");     // Catch: Exception -> L21
        Job r12 = SilentSyncManager.a;     // Catch: Exception -> L21
        SilentSyncManager.c();     // Catch: Exception -> L21
    L24:
        return Unit.INSTANCE;
    L10:
        r10 = null;
    L21:
        e = move-exception;
        FLogger.a.e("SilentSyncManager", "Error in auto sync scheduling loop for " + this.$triggerReason, e);
        goto L24
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
