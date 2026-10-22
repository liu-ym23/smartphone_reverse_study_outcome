package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.v1;

import android.view.View;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import fh8.x;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.v1.MarkdownTextViewWidgetHandlerV2$setupSpanShow$2", f = "MarkdownTextViewWidgetHandlerV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MarkdownTextViewWidgetHandlerV2$setupSpanShow$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ lw8.l $currentNodeContent;
    final /* synthetic */ CustomMarkdownTextView $markdownTextView;
    int label;
    final /* synthetic */ l this$0;

    public MarkdownTextViewWidgetHandlerV2$setupSpanShow$2(lw8.l r1, l r2, CustomMarkdownTextView r3, Continuation<? super MarkdownTextViewWidgetHandlerV2$setupSpanShow$2> r4) {
        this.$currentNodeContent = r1;
        this.this$0 = r2;
        this.$markdownTextView = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MarkdownTextViewWidgetHandlerV2$setupSpanShow$2(this.$currentNodeContent, this.this$0, this.$markdownTextView, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L29;
        ResultKt.throwOnFailure(r7);
        lw8.l r8 = this.$currentNodeContent;
        l r0 = this.this$0;
        CustomMarkdownTextView r1 = this.$markdownTextView;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L24
        if (r8 == null) goto L21;
        Iterator<T> r9 = x.b(r8).iterator();     // Catch: Throwable -> L24
        int r3 = 0;
    L9:
        if (r9.hasNext() == false) goto L20;
        Object r4 = r9.next();     // Catch: Throwable -> L24
        int r5 = r3 + 1;     // Catch: Throwable -> L24
        if (r3 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();     // Catch: Throwable -> L24
    L13:
        lw8.k r6 = (lw8.k) r4;     // Catch: Throwable -> L24
        fh8.r r10 = r0.d;     // Catch: Throwable -> L24
        if (r10 == null) goto L18;
        Function3<Integer, lw8.k, View, Unit> r11 = r10.i;     // Catch: Throwable -> L24
        if (r11 == null) goto L18;
        r11.invoke(Boxing.boxInt(r3), r6, r1);     // Catch: Throwable -> L24
    L19:
        r3 = r5;
    L18:
        r0.h().k(r3, r6, r1);     // Catch: Throwable -> L24
        goto L19
    L20:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L24
    L22:
        Result.constructor-impl(r12);     // Catch: Throwable -> L24
    L27:
        return Unit.INSTANCE;
    L21:
        r12 = null;
    L24:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L27
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
