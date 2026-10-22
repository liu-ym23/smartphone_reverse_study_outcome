package com.ss.android.lark.passportc.ffi;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import f0c.h;
import gy7.u;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passportc.ffi.KmpUserConvention$1$invoke$1", f = "KmpUserConvention.kt", i = {}, l = {ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CHATTER}, m = "invokeSuspend", n = {}, s = {})
final class KmpUserConvention$1$invoke$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ h $userStatePayload;
    int label;
    final /* synthetic */ KmpUserConvention this$0;

    public KmpUserConvention$1$invoke$1(KmpUserConvention r1, h r2, Continuation<? super KmpUserConvention$1$invoke$1> r3) {
        this.this$0 = r1;
        this.$userStatePayload = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new KmpUserConvention$1$invoke$1(this.this$0, this.$userStatePayload, r4);
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
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        KmpUserConvention r5 = this.this$0;
        int r2 = KmpUserConvention.d;
        gy7.h r6 = (gy7.h) r5.c.getValue();
        if (r6 != null) goto L12;
        Log.w("PassportKmpUserConvention", "handleObserver skipped: KMP user service not found");
        return Unit.INSTANCE;
    L12:
        int r3 = b.a;
        u r7 = b.c(this.$userStatePayload);
        this.label = 1;
        if (r6.g(r7) != r0) goto L16;
        return r0;
    }
}
