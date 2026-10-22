package com.ss.android.lark.inline.ai.creationai;

import com.larksuite.component.universe_design.color.UDColorUtils;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.inline.ai.creationai.CreationAIDragView$setStatusBarColorAlpha$1", f = "CreationAIDragView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CreationAIDragView$setStatusBarColorAlpha$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.FloatRef $finalAlpha;
    int label;
    final /* synthetic */ CreationAIDragView this$0;

    public CreationAIDragView$setStatusBarColorAlpha$1(CreationAIDragView r1, Ref.FloatRef r2, Continuation<? super CreationAIDragView$setStatusBarColorAlpha$1> r3) {
        this.this$0 = r1;
        this.$finalAlpha = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CreationAIDragView$setStatusBarColorAlpha$1(this.this$0, this.$finalAlpha, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r4);
        Log.i("CreationAIDragView", "setStatusBarColorAlpha--->");
        CreationAIDragView r5 = this.this$0;
        vlb.d r0 = r5.i;
        if (r0 == null) goto L8;
        r0.b(UDColorUtils.getAlphaColor(r5.a, r5.e0, this.$finalAlpha.element));
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
