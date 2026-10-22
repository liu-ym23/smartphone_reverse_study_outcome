package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper;

import com.ss.android.lark.picker.base.view.ItemViewType;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.MmBaseNetReconnectHelper$onNetworkStatusChanged$1", f = "MmBaseNetReconnectHelper.kt", i = {}, l = {82, 85}, m = "invokeSuspend", n = {}, s = {})
final class MmBaseNetReconnectHelper$onNetworkStatusChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmBaseNetReconnectHelper this$0;

    public MmBaseNetReconnectHelper$onNetworkStatusChanged$1(MmBaseNetReconnectHelper r1, Continuation<? super MmBaseNetReconnectHelper$onNetworkStatusChanged$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmBaseNetReconnectHelper$onNetworkStatusChanged$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r7);
    L20:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
    L13:
        MmBaseNetReconnectHelper r8 = this.this$0;
        if (r8.d == false) goto L18;
        this.label = 2;
        if (MmBaseNetReconnectHelper.a(r8, this) != r0) goto L20;
        return r0;
    L18:
        lvb.a.e(r8.e(), "onNetworkStatusChanged, debounce failed, net unavailable again");
        goto L20
    L10:
        ResultKt.throwOnFailure(r7);
        long r4 = this.this$0.c();
        this.label = 1;
        if (DelayKt.delay(r4, this) != r0) goto L13;
        return r0;
    }
}
