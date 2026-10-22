package com.larus.avlink.gallery.coordinator;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.gallery.coordinator.MediaSyncCoordinator$startSyncFlow$2", f = "MediaSyncCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MediaSyncCoordinator$startSyncFlow$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MediaSyncCoordinator.SyncMode $mode;
    final /* synthetic */ Integer $photoCnt;
    final /* synthetic */ boolean $requestPermission;
    final /* synthetic */ Integer $videoCnt;
    int label;

    /* JADX INFO: renamed from: com.larus.avlink.gallery.coordinator.MediaSyncCoordinator$startSyncFlow$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "success", ""}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
    @DebugMetadata(c = "com.larus.avlink.gallery.coordinator.MediaSyncCoordinator$startSyncFlow$2$1", f = "MediaSyncCoordinator.kt", i = {}, l = {366}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
        final /* synthetic */ MediaSyncCoordinator.SyncMode $mode;
        final /* synthetic */ Integer $photoCnt;
        final /* synthetic */ boolean $requestPermission;
        final /* synthetic */ Integer $videoCnt;
        /* synthetic */ boolean Z$0;
        int label;

        public AnonymousClass1(MediaSyncCoordinator.SyncMode r1, Integer r2, Integer r3, boolean r4, Continuation<? super AnonymousClass1> r5) {
            this.$mode = r1;
            this.$photoCnt = r2;
            this.$videoCnt = r3;
            this.$requestPermission = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass1 r6 = new AnonymousClass1(this.$mode, this.$photoCnt, this.$videoCnt, this.$requestPermission, r9);
            r6.Z$0 = ((Boolean) r8).booleanValue();
            return r6;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
        }

        public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
            return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r11) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r11);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r11);
            if (this.Z$0 == false) goto L11;
            FLogger.a.i("MediaSyncCoordinator", "Recovery completed successfully, starting sync flow");
        L12:
            MediaSyncCoordinator r4 = MediaSyncCoordinator.a;
            MediaSyncCoordinator.SyncMode r5 = this.$mode;
            Integer r6 = this.$photoCnt;
            Integer r7 = this.$videoCnt;
            boolean r8 = this.$requestPermission;
            this.label = 1;
            if (MediaSyncCoordinator.b(r4, r5, r6, r7, r8, this) != r0) goto L16;
            return r0;
        L11:
            FLogger.a.w("MediaSyncCoordinator", "Recovery completed with errors, continuing with sync flow");
            goto L12
        }
    }

    public MediaSyncCoordinator$startSyncFlow$2(MediaSyncCoordinator.SyncMode r1, Integer r2, Integer r3, boolean r4, Continuation<? super MediaSyncCoordinator$startSyncFlow$2> r5) {
        this.$mode = r1;
        this.$photoCnt = r2;
        this.$videoCnt = r3;
        this.$requestPermission = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MediaSyncCoordinator$startSyncFlow$2(this.$mode, this.$photoCnt, this.$videoCnt, this.$requestPermission, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r13);
        MediaSyncCoordinator r14 = MediaSyncCoordinator.a;
        AnonymousClass1 r15 = new AnonymousClass1(this.$mode, this.$photoCnt, this.$videoCnt, this.$requestPermission, null);
        BuildersKt.launch$default(MediaSyncCoordinator.e(), null, null, new MediaSyncCoordinator$recoverIncompleteTasks$1(r15, null), 3, null);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
