package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.BlockContent;
import com.larus.im.bean.message.block.TextBlock;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.layout.widget.AIDocTextBlockView$setupCardButtons$2$1", f = "AIDocTextBlockView.kt", i = {}, l = {335}, m = "invokeSuspend", n = {}, s = {})
final class AIDocTextBlockView$setupCardButtons$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ t this$0;

    public AIDocTextBlockView$setupCardButtons$2$1(t r1, Continuation<? super AIDocTextBlockView$setupCardButtons$2$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AIDocTextBlockView$setupCardButtons$2$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r39) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        t r3 = (t) this.L$0;
        ResultKt.throwOnFailure(r39);
    L29:
        t r4 = r3;
    L30:
        t19.s r5 = t19.s.a;
        Context r6 = r4.getContext();
        r5.getClass();
        t19.s.o(r6, 2131910467, false);
    L35:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r39);
        fb8.f r7 = this.this$0.g;
        if (r7 == null) goto L33;
        Block r8 = r7.a;
        if (r8 == null) goto L33;
        BlockContent r9 = r8.getContent();
        if (r9 == null) goto L33;
        TextBlock r10 = r9.getTextBlock();
        if (r10 == null) goto L33;
        String r11 = r10.text;
        if (r11 == null) goto L33;
        r4 = this.this$0;
        gw8.c.a.getClass();
        gw8.c r12 = gw8.c.a.b();
        if (r12 == null) goto L32;
        Context r13 = r4.getContext();
        int r14 = com.larus.utils.m0.a;
        lw8.l r15 = gw8.c.b.a(r12, r13, com.larus.utils.m0.b(r4.getContext()), r11, true, new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31), null, null, 224);
        if (r15 == null) goto L32;
        com.larus.bmhome.chat.layout.holder.helper.s0 r16 = ILegacyChatUiServiceDelegate.b.X8();
        if (r16 == null) goto L30;
        Context r17 = r4.getContext();
        List<? extends lw8.l> r18 = CollectionsKt.listOf(r15);
        this.L$0 = r4;
        this.label = 1;
        if (r16.e(r17, r18, null, this) != r1) goto L28;
        return r1;
    L28:
        r3 = r4;
    L32:
        return Unit.INSTANCE;
    L33:
        t19.s r19 = t19.s.a;
        Context r20 = this.this$0.getContext();
        r19.getClass();
        t19.s.s(r20, 2131899529);
        goto L35
    }
}
