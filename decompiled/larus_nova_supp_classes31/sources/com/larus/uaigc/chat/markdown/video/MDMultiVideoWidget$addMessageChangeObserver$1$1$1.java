package com.larus.uaigc.chat.markdown.video;

import android.text.Spanned;
import android.widget.TextView;
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
@DebugMetadata(c = "com.larus.uaigc.chat.markdown.video.MDMultiVideoWidget$addMessageChangeObserver$1$1$1", f = "MDMultiVideoWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MDMultiVideoWidget$addMessageChangeObserver$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $maxWidth;
    final /* synthetic */ usc.e $span;
    final /* synthetic */ Spanned $text;
    final /* synthetic */ TextView $textView;
    int label;
    final /* synthetic */ MDMultiVideoWidget this$0;

    public MDMultiVideoWidget$addMessageChangeObserver$1$1$1(MDMultiVideoWidget r1, TextView r2, Spanned r3, usc.e r4, int r5, Continuation<? super MDMultiVideoWidget$addMessageChangeObserver$1$1$1> r6) {
        this.this$0 = r1;
        this.$textView = r2;
        this.$text = r3;
        this.$span = r4;
        this.$maxWidth = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new MDMultiVideoWidget$addMessageChangeObserver$1$1$1(this.this$0, this.$textView, this.$text, this.$span, this.$maxWidth, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r6);
        MDMultiVideoWidget r7 = this.this$0;
        TextView r0 = this.$textView;
        Spanned r1 = this.$text;
        usc.e r2 = this.$span;
        int r3 = this.$maxWidth;
        int r4 = MDMultiVideoWidget.w;
        r7.e(r0, r1, r2, r3);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
