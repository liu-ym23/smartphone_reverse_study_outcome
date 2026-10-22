package com.ss.android.lark.passportc.ffi;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.picker.base.view.ItemViewType;
import gy7.e;
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
@DebugMetadata(c = "com.ss.android.lark.passportc.ffi.KmpGlobalConvention$1$invoke$1", f = "KmpGlobalConvention.kt", i = {}, l = {ItemViewType.ITEM_VIEW_TYPE_NO_MORE_FOOTER}, m = "invokeSuspend", n = {}, s = {})
final class KmpGlobalConvention$1$invoke$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ f0c.b $state;
    int label;
    final /* synthetic */ a this$0;

    public KmpGlobalConvention$1$invoke$1(a r1, f0c.b r2, Continuation<? super KmpGlobalConvention$1$invoke$1> r3) {
        this.this$0 = r1;
        this.$state = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new KmpGlobalConvention$1$invoke$1(this.this$0, this.$state, r4);
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
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        a r7 = this.this$0;
        int r2 = a.c;
        r7.getClass();
        e r8 = a.a();
        if (r8 != null) goto L12;
        Log.w("PassportKmpGlobalConvention", "handleObserver skipped: KMP global service not found");
        return Unit.INSTANCE;
    L12:
        int r3 = b.a;
        gy7.b r4 = new gy7.b(b.c(this.$state.b), b.b(this.$state.a()));
        this.label = 1;
        if (r8.e(r4) != r0) goto L16;
        return r0;
    }
}
