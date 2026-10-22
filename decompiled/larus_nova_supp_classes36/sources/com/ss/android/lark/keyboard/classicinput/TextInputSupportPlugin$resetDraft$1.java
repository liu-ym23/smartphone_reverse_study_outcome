package com.ss.android.lark.keyboard.classicinput;

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
@DebugMetadata(c = "com.ss.android.lark.keyboard.classicinput.TextInputSupportPlugin$resetDraft$1", f = "TextInputSupportPlugin.kt", i = {}, l = {284, 286}, m = "invokeSuspend", n = {}, s = {})
final class TextInputSupportPlugin$resetDraft$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ bob.b $handler;
    int label;
    final /* synthetic */ a this$0;

    public TextInputSupportPlugin$resetDraft$1(a r1, bob.b r2, Continuation<? super TextInputSupportPlugin$resetDraft$1> r3) {
        this.this$0 = r1;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TextInputSupportPlugin$resetDraft$1(this.this$0, null, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L9;
        if (r0 != 2) goto L8;
        ResultKt.throwOnFailure(r4);
        bob.a r5 = (bob.a) r4;
    L10:
        this.this$0.r(r5);
        this.this$0.C = false;
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r4);
        r5 = (bob.a) r4;
        goto L10
    L12:
        ResultKt.throwOnFailure(r4);
        if (this.this$0.C == false) goto L16;
        this.label = 1;
        throw null;
    L16:
        this.label = 2;
        throw null;
    }
}
