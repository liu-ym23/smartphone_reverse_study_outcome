package com.larus.slides.impl.select;

import android.widget.TextView;
import com.larus.slides.biz.impl.databinding.LarusSlidesPageGenerateImageBinding;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.slides.impl.select.GenerateImageFragment$refreshUIState$1$1$1", f = "GenerateImageFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class GenerateImageFragment$refreshUIState$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ p $state;
    final /* synthetic */ boolean $success;
    int label;
    final /* synthetic */ GenerateImageFragment this$0;

    public GenerateImageFragment$refreshUIState$1$1$1(boolean r1, GenerateImageFragment r2, p r3, Continuation<? super GenerateImageFragment$refreshUIState$1$1$1> r4) {
        this.$success = r1;
        this.this$0 = r2;
        this.$state = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new GenerateImageFragment$refreshUIState$1$1$1(this.$success, this.this$0, this.$state, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L25;
        ResultKt.throwOnFailure(r4);
        boolean r0 = true;
        if (this.$success == false) goto L10;
        GenerateImageFragment r5 = this.this$0;
        if (r5.m == true) goto L10;
        r5.m = true;
    L10:
        if (this.$state.b == true) goto L12;
    L14:
        r0 = false;
    L15:
        LarusSlidesPageGenerateImageBinding r6 = this.this$0.e;
        if (r6 == null) goto L23;
        TextView r1 = r6.b;
        if (r0 == false) goto L20;
        float r2 = 1.0f;
    L21:
        r1.setAlpha(r2);
        r6.b.setEnabled(r0);
        Unit r7 = Unit.INSTANCE;
        goto L23
    L20:
        r2 = 0.3f;
    L23:
        return Unit.INSTANCE;
    L12:
        if (this.this$0.m == false) goto L14;
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
