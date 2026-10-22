package com.ss.android.lark.officesdk.minutes.service.foundation.utils.net;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.foundation.utils.net.MmNetworkUtils$launchNetworkChangeJob$dispatch$1", f = "MmNetworkUtils.kt", i = {}, l = {136}, m = "invokeSuspend", n = {}, s = {})
public final class MmNetworkUtils$launchNetworkChangeJob$dispatch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $debounceMs;
    final /* synthetic */ boolean $isAvailable;
    final /* synthetic */ String $logTag;
    final /* synthetic */ Function1<Boolean, Unit> $onNetworkAvailable;
    final /* synthetic */ String $source;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public MmNetworkUtils$launchNetworkChangeJob$dispatch$1(long r1, String r3, String r4, boolean r5, Function1<? super Boolean, Unit> r6, Continuation<? super MmNetworkUtils$launchNetworkChangeJob$dispatch$1> r7) {
        this.$debounceMs = r1;
        this.$logTag = r3;
        this.$source = r4;
        this.$isAvailable = r5;
        this.$onNetworkAvailable = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new MmNetworkUtils$launchNetworkChangeJob$dispatch$1(this.$debounceMs, this.$logTag, this.$source, this.$isAvailable, this.$onNetworkAvailable, r10);
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
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        lvb.a.e(this.$logTag, "[network] source=" + this.$source + ", isAvailable=" + this.$isAvailable);
        this.$onNetworkAvailable.invoke(Boxing.boxBoolean(this.$isAvailable));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        long r3 = this.$debounceMs;
        this.label = 1;
        if (DelayKt.delay(r3, this) != r0) goto L11;
        return r0;
    }
}
