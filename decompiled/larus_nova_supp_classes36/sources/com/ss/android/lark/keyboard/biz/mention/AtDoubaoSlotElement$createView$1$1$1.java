package com.ss.android.lark.keyboard.biz.mention;

import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = AnchorFit.END)
@DebugMetadata(c = "com.ss.android.lark.keyboard.biz.mention.AtDoubaoSlotElement$createView$1$1$1", f = "AtDoubaoSlotElement.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
final class AtDoubaoSlotElement$createView$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ a this$0;

    public AtDoubaoSlotElement$createView$1$1$1(a r1, Continuation<? super AtDoubaoSlotElement$createView$1$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AtDoubaoSlotElement$createView$1$1$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L12;
        if (r0 != 1) goto L11;
        ResultKt.throwOnFailure(r3);
        Chatter r4 = (Chatter) r3;
        if (r4 == null) goto L8;
        r4.getId();
    L8:
        com.ss.android.lark.chat.utils.m.b(r4, ChatterNameDisplayRule.ALIAS_NAME, false);
        com.ss.android.lark.chat.utils.m.b(r4, ChatterNameDisplayRule.NAME, false);
        this.this$0.getClass();
        throw null;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r3);
        this.this$0.getClass();
        throw null;
    }
}
