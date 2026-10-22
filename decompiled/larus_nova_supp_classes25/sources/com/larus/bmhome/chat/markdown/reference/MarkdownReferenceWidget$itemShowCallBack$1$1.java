package com.larus.bmhome.chat.markdown.reference;

import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import fh8.f;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.markdown.reference.MarkdownReferenceWidget$itemShowCallBack$1$1", f = "MarkdownReferenceWidget.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MarkdownReferenceWidget$itemShowCallBack$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ oi8.n.a $cardInfo;
    final /* synthetic */ int $index;
    final /* synthetic */ Message $message;
    int label;
    final /* synthetic */ MarkdownReferenceWidget this$0;

    public MarkdownReferenceWidget$itemShowCallBack$1$1(MarkdownReferenceWidget r1, oi8.n.a r2, Message r3, int r4, Continuation<? super MarkdownReferenceWidget$itemShowCallBack$1$1> r5) {
        this.this$0 = r1;
        this.$cardInfo = r2;
        this.$message = r3;
        this.$index = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MarkdownReferenceWidget$itemShowCallBack$1$1(this.this$0, this.$cardInfo, this.$message, this.$index, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r22);
        int r1 = oi8.n.a;
        SearchReferenceData r2 = this.this$0.d;
        String r3 = null;
        if (r2 == null) goto L7;
        Integer r6 = r2.getIdx();
    L8:
        ri8.c r4 = ri8.c.a;
        String r10 = ri8.c.g(Boxing.boxBoolean(true));
        MarkdownReferenceWidget r5 = this.this$0;
        f r7 = r5.n;
        if (r7 == null) goto L11;
        String r8 = r7.d;
    L12:
        if (r8 != null) goto L14;
        r8 = "";
    L14:
        String r9 = r8;
        ChatParam r11 = r5.l();
        oi8.n.a r12 = this.$cardInfo;
        if (r12 == null) goto L18;
        Object r13 = r12.a;
        if (r13 == null) goto L18;
    L19:
        String r14 = r13.toString();
        oi8.n.a r15 = this.$cardInfo;
        if (r15 == null) goto L22;
        String r16 = r15.b;
    L23:
        if (r15 == null) goto L25;
        r3 = r15.c;
    L25:
        oi8.n.b(this.$message, r11, Boxing.boxInt(this.$index), r6, r14, "link", r9, r10, Boxing.boxBoolean(true), null, r3, r16, this.this$0.c.getValue(), null, null, null, null, 246912);
        return Unit.INSTANCE;
    L22:
        r16 = null;
    L18:
        r13 = Boxing.boxInt(0);
        goto L19
    L11:
        r8 = null;
        goto L12
    L7:
        r6 = null;
        goto L8
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
