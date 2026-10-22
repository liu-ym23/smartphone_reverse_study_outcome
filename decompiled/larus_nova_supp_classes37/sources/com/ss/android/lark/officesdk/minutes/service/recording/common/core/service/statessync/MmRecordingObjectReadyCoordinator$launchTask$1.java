package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.profile.v2.entity.BaseField;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.statessync.MmRecordingObjectReadyCoordinator$launchTask$1", f = "MmRecordingObjectReadyCoordinator.kt", i = {}, l = {BaseField.FIELD_TYPE_S_DEPARTMENT}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingObjectReadyCoordinator$launchTask$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $block;
    final /* synthetic */ CompletableDeferred<Unit> $completion;
    int label;

    public MmRecordingObjectReadyCoordinator$launchTask$1(CompletableDeferred<Unit> r1, Function1<? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super MmRecordingObjectReadyCoordinator$launchTask$1> r3) {
        this.$completion = r1;
        this.$block = r2;
        super(1, r3);
    }

    public final Continuation<Unit> create(Continuation<?> r4) {
        return new MmRecordingObjectReadyCoordinator$launchTask$1(this.$completion, this.$block, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super Unit> r2) {
        return create(r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L12;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L7 CancellationException -> L9
    L20:
        this.$completion.complete(Unit.INSTANCE);     // Catch: Throwable -> L7 CancellationException -> L9
    L25:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r4);
        if (this.$completion.isActive() == false) goto L16;
        Function1<Continuation<? super Unit>, Object> r5 = this.$block;     // Catch: Throwable -> L7 CancellationException -> L9
        this.label = 1;     // Catch: Throwable -> L7 CancellationException -> L9
        if (r5.invoke(this) != r0) goto L20;
        return r0;
    L16:
        return Unit.INSTANCE;
    L9:
        e = move-exception;
        this.$completion.cancel(e);
    L7:
        th = move-exception;
        this.$completion.completeExceptionally(th);
        goto L25
    }
}
