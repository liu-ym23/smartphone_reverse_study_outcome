package com.larus.bmhome.chat.component.bottom.multimodal.upload;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.UplinkFileEntity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.multimodal.upload.SharedAlbumUploadCoordinator$submit$replay$1$task$1$1", f = "SharedAlbumUploadCoordinator.kt", i = {}, l = {116}, m = "invokeSuspend", n = {}, s = {})
public final class SharedAlbumUploadCoordinator$submit$replay$1$task$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SharedAlbumUploadCoordinator.c $newTask;
    final /* synthetic */ q $param;
    final /* synthetic */ ns8.b $processConfig;
    final /* synthetic */ Function3<q, ns8.b, Continuation<? super Unit>, Object> $startUpload;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public SharedAlbumUploadCoordinator$submit$replay$1$task$1$1(Function3<? super q, ? super ns8.b, ? super Continuation<? super Unit>, ? extends Object> r1, q r2, SharedAlbumUploadCoordinator.c r3, ns8.b r4, Continuation<? super SharedAlbumUploadCoordinator$submit$replay$1$task$1$1> r5) {
        this.$startUpload = r1;
        this.$param = r2;
        this.$newTask = r3;
        this.$processConfig = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SharedAlbumUploadCoordinator$submit$replay$1$task$1$1(this.$startUpload, this.$param, this.$newTask, this.$processConfig, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r15);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        Function3<q, ns8.b, Continuation<? super Unit>, Object> r16 = this.$startUpload;
        q r2 = this.$param;
        SharedAlbumUploadCoordinator.e r6 = new SharedAlbumUploadCoordinator.e(this.$newTask);
        String r4 = r2.a;
        boolean r5 = r2.b;
        String r7 = r2.d;
        UplinkFileEntity r8 = r2.e;
        boolean r9 = r2.f;
        String r10 = r2.g;
        String r11 = r2.h;
        String r12 = r2.i;
        String r13 = r2.j;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r6, "listener");
        Intrinsics.checkNotNullParameter(r7, "fromScene");
        Intrinsics.checkNotNullParameter(r8, "entity");
        q r3 = new q(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
        ns8.b r14 = this.$processConfig;
        this.label = 1;
        if (r16.invoke(r3, r14, this) != r0) goto L12;
        return r0;
    }
}
