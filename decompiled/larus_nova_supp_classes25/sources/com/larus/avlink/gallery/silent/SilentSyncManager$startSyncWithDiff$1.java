package com.larus.avlink.gallery.silent;

import com.larus.avlink.gallery.coordinator.MediaSyncCoordinator;
import com.larus.avlink.gallery.view.mob.GalleryMobHelper;
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
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.silent.SilentSyncManager$startSyncWithDiff$1", f = "SilentSyncManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class SilentSyncManager$startSyncWithDiff$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.BooleanRef $isApproved;
    final /* synthetic */ String $silentTaskId;
    int label;

    public SilentSyncManager$startSyncWithDiff$1(String r1, Ref.BooleanRef r2, Continuation<? super SilentSyncManager$startSyncWithDiff$1> r3) {
        this.$silentTaskId = r1;
        this.$isApproved = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SilentSyncManager$startSyncWithDiff$1(this.$silentTaskId, this.$isApproved, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L33;
        ResultKt.throwOnFailure(r8);
        IDoraService r9 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r9 == null) goto L9;
        VisionService r10 = r9.V();
        if (r10 == null) goto L9;
        Pair r11 = r10.l();
    L11:
        if (r11 == null) goto L13;
        int r1 = ((Number) r11.getFirst()).intValue();
    L14:
        if (r11 == null) goto L16;
        int r12 = ((Number) r11.getSecond()).intValue();
    L18:
        if (r1 > 0) goto L22;
        if (r12 > 0) goto L22;
        FLogger.a.i("SilentSyncManager", "preCheck: No new media found, skipping sync (photos=" + r1 + ", videos=" + r12 + ')');
        GalleryMobHelper r4 = GalleryMobHelper.a;
        String r5 = this.$silentTaskId;
        GalleryMobHelper.AlbumSyncInterceptionReason r6 = GalleryMobHelper.AlbumSyncInterceptionReason.HAS_NO_CONTENT;
        r4.getClass();
        GalleryMobHelper.h(false, r5, r6);
        this.$isApproved.element = false;
    L22:
        if (this.$isApproved.element == false) goto L24;
        GalleryMobHelper r7 = GalleryMobHelper.a;
        String r13 = this.$silentTaskId;
        GalleryMobHelper.AlbumSyncInterceptionReason r14 = GalleryMobHelper.AlbumSyncInterceptionReason.SUCCESS;
        r7.getClass();
        GalleryMobHelper.h(true, r13, r14);
        FLogger r15 = FLogger.a;
        r15.i("SilentSyncManager", "Starting silent sync: photos=" + r1 + ", videos=" + r12);
        r15.d("SilentSyncManager", "Executing sync flow on IO thread");     // Catch: Exception -> L28
        MediaSyncCoordinator.a.u(MediaSyncCoordinator.SyncMode.SILENT, false, Boxing.boxInt(r1), Boxing.boxInt(r12));     // Catch: Exception -> L28
        r15.d("SilentSyncManager", "Sync flow started on HardwareMediaLoadService");     // Catch: Exception -> L28
    L31:
        return Unit.INSTANCE;
    L28:
        e = move-exception;
        FLogger.a.e("SilentSyncManager", "Error starting sync flow", e);
        goto L31
    L24:
        return Unit.INSTANCE;
    L16:
        r12 = 0;
        goto L18
    L13:
        r1 = 0;
    L9:
        r11 = null;
        goto L11
    L33:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
