package com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import lsc.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.DefaultMarkdownCodeView$bindText$1", f = "DefaultMarkdownCodeView.kt", i = {}, l = {252}, m = "invokeSuspend", n = {}, s = {})
final class DefaultMarkdownCodeView$bindText$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $optimizeCode;
    final /* synthetic */ TextView $tv;
    int label;
    final /* synthetic */ DefaultMarkdownCodeView this$0;

    /* JADX INFO: renamed from: com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.DefaultMarkdownCodeView$bindText$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.larus.business.markdown.impl.markwon.core.spans.codeblock.replacementspan.normal.DefaultMarkdownCodeView$bindText$1$1", f = "DefaultMarkdownCodeView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SpannableStringBuilder $highlightText;
        final /* synthetic */ TextView $tv;
        int label;

        public AnonymousClass1(TextView r1, SpannableStringBuilder r2, Continuation<? super AnonymousClass1> r3) {
            this.$tv = r1;
            this.$highlightText = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            return new AnonymousClass1(this.$tv, this.$highlightText, r4);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            this.$tv.setText(this.$highlightText);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public DefaultMarkdownCodeView$bindText$1(DefaultMarkdownCodeView r1, String r2, TextView r3, Continuation<? super DefaultMarkdownCodeView$bindText$1> r4) {
        this.this$0 = r1;
        this.$optimizeCode = r2;
        this.$tv = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DefaultMarkdownCodeView$bindText$1(this.this$0, this.$optimizeCode, this.$tv, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        y.b r8 = new y(DefaultMarkdownCodeView.a(this.this$0).a(this.this$0.getCurrentLanguage(), this.$optimizeCode)).h();
        MainCoroutineDispatcher r2 = Dispatchers.getMain();
        AnonymousClass1 r3 = new AnonymousClass1(this.$tv, r8, null);
        this.label = 1;
        if (BuildersKt.withContext(r2, r3, this) != r0) goto L12;
        return r0;
    }
}
