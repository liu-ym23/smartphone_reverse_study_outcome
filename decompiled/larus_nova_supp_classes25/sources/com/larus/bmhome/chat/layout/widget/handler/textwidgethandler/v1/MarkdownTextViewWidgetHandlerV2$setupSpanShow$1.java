package com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.v1;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.widget.handler.textwidgethandler.v1.MarkdownTextViewWidgetHandlerV2$setupSpanShow$1", f = "MarkdownTextViewWidgetHandlerV2.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MarkdownTextViewWidgetHandlerV2$setupSpanShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ lw8.l $currentNodeContent;
    final /* synthetic */ by7.e $trackNode;
    int label;
    final /* synthetic */ l this$0;

    public MarkdownTextViewWidgetHandlerV2$setupSpanShow$1(lw8.l r1, l r2, by7.e r3, Continuation<? super MarkdownTextViewWidgetHandlerV2$setupSpanShow$1> r4) {
        this.$currentNodeContent = r1;
        this.this$0 = r2;
        this.$trackNode = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MarkdownTextViewWidgetHandlerV2$setupSpanShow$1(this.$currentNodeContent, this.this$0, this.$trackNode, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L33;
        ResultKt.throwOnFailure(r5);
        lw8.l r6 = this.$currentNodeContent;
        if (r6 == null) goto L17;
        List r7 = r6.f();
        if (r7 == null) goto L17;
        l r0 = this.this$0;
        by7.e r1 = this.$trackNode;
        Iterator r8 = r7.iterator();
    L10:
        if (r8.hasNext() == false) goto L17;
        lw8.f r2 = (lw8.f) r8.next();
        fh8.r r3 = r0.d;
        if (r3 == null) goto L16;
        Function2<lw8.f, by7.e, Unit> r4 = r3.h;
        if (r4 == null) goto L16;
        r4.invoke(r2, r1);
    L16:
        r0.h().h(r2, r1);
    L17:
        lw8.l r9 = this.$currentNodeContent;
        if (r9 == null) goto L31;
        List r10 = r9.c();
        if (r10 == null) goto L31;
        l r11 = this.this$0;
        Iterator r12 = r10.iterator();
    L23:
        if (r12.hasNext() == false) goto L31;
        lw8.g r13 = (lw8.g) r12.next();
        fh8.r r14 = r11.d;
        if (r14 == null) goto L29;
        Function1<lw8.g, Unit> r15 = r14.g;
        if (r15 == null) goto L29;
        r15.invoke(r13);
    L29:
        r11.h().j(r13);
    L31:
        return Unit.INSTANCE;
    L33:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
