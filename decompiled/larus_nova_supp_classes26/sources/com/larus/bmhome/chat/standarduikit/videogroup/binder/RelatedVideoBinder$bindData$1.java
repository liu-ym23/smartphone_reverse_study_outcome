package com.larus.bmhome.chat.standarduikit.videogroup.binder;

import android.text.Spanned;
import android.widget.TextView;
import com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.k;
import fh8.f;
import fh8.h;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zn8.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.standarduikit.videogroup.binder.RelatedVideoBinder$bindData$1", f = "RelatedVideoBinder.kt", i = {0}, l = {50}, m = "invokeSuspend", n = {"markdownCommonInputData"}, s = {"L$0"})
public final class RelatedVideoBinder$bindData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, Object> $payload;
    final /* synthetic */ l $sizeData;
    final /* synthetic */ usc.e $span;
    final /* synthetic */ Spanned $text;
    final /* synthetic */ TextView $textView;
    Object L$0;
    int label;
    final /* synthetic */ RelatedVideoBinder this$0;

    public RelatedVideoBinder$bindData$1(Map<String, ? extends Object> r1, RelatedVideoBinder r2, Spanned r3, usc.e r4, l r5, TextView r6, Continuation<? super RelatedVideoBinder$bindData$1> r7) {
        this.$payload = r1;
        this.this$0 = r2;
        this.$text = r3;
        this.$span = r4;
        this.$sizeData = r5;
        this.$textView = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new RelatedVideoBinder$bindData$1(this.$payload, this.this$0, this.$text, this.$span, this.$sizeData, this.$textView, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        f r2 = (f) this.L$0;
        ResultKt.throwOnFailure(r10);
    L12:
        com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.a r11 = (com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.a) r10;
        if (r11 == null) goto L15;
        k r3 = new k(r2, this.$textView);
        ((wn8.c) this.this$0.b.getValue()).a(r11, r3);
        return Unit.INSTANCE;
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        f r12 = h.b(this.$payload);
        RelatedVideoBinder r4 = this.this$0;
        Spanned r5 = this.$text;
        usc.e r6 = this.$span;
        l r7 = this.$sizeData;
        this.L$0 = r12;
        this.label = 1;
        Object r8 = RelatedVideoBinder.g(r4, r5, r6, r12, r7, this);
        if (r8 != r0) goto L11;
        return r0;
    L11:
        r2 = r12;
        r10 = r8;
        goto L12
    }
}
