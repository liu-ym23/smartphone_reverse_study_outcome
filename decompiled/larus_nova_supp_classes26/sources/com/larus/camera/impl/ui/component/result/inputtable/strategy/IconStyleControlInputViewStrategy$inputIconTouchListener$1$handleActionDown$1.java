package com.larus.camera.impl.ui.component.result.inputtable.strategy;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.camera.impl.ui.component.result.inputtable.strategy.IconStyleControlInputViewStrategy$inputIconTouchListener$1$handleActionDown$1", f = "IconStyleControlInputViewStrategy.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
final class IconStyleControlInputViewStrategy$inputIconTouchListener$1$handleActionDown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ w this$0;
    final /* synthetic */ x this$1;

    public IconStyleControlInputViewStrategy$inputIconTouchListener$1$handleActionDown$1(w r1, x r2, Continuation<? super IconStyleControlInputViewStrategy$inputIconTouchListener$1$handleActionDown$1> r3) {
        this.this$0 = r1;
        this.this$1 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new IconStyleControlInputViewStrategy$inputIconTouchListener$1$handleActionDown$1(this.this$0, this.this$1, r4);
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
    L12:
        if (this.this$0.a == true) goto L21;
        final x r7 = this.this$1;
        Fragment r2 = r7.b;
        if (r2 == null) goto L16;
        Intrinsics.checkNotNullParameter(r2, "it");
        r7.j(new b(r2));
        Unit r3 = Unit.INSTANCE;
    L16:
        ViewGroup r4 = r7.c;
        if (r4 == null) goto L19;
        r4.post(new o(r7));
    L19:
        this.this$0.a = true;
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(200, this) != r0) goto L12;
        return r0;
    }
}
