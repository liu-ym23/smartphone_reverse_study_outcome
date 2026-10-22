package com.ss.android.lark.passport.flow.verify.viewmodel;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "", "f1", "f2", "f3"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCodeViewModel$countDownTime$1", f = "VerifyCodeViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class VerifyCodeViewModel$countDownTime$1 extends SuspendLambda implements Function4<Integer, Integer, Integer, Continuation<? super Triple<? extends Integer, ? extends Integer, ? extends Integer>>, Object> {
    /* synthetic */ int I$0;
    /* synthetic */ int I$1;
    /* synthetic */ int I$2;
    int label;

    public VerifyCodeViewModel$countDownTime$1(Continuation<? super VerifyCodeViewModel$countDownTime$1> r2) {
        super(4, r2);
    }

    public final Object invoke(int r2, int r3, int r4, Continuation<? super Triple<Integer, Integer, Integer>> r5) {
        VerifyCodeViewModel$countDownTime$1 r0 = new VerifyCodeViewModel$countDownTime$1(r5);
        r0.I$0 = r2;
        r0.I$1 = r3;
        r0.I$2 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2, Object r3, Object r4) {
        return invoke(((Number) r1).intValue(), ((Number) r2).intValue(), ((Number) r3).intValue(), (Continuation) r4);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        int r5 = this.I$0;
        int r0 = this.I$1;
        int r1 = this.I$2;
        return new Triple(Boxing.boxInt(r5), Boxing.boxInt(r0), Boxing.boxInt(r1));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
