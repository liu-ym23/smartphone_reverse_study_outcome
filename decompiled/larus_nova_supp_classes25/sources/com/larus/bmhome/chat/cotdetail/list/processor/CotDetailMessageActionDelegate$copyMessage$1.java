package com.larus.bmhome.chat.cotdetail.list.processor;

import android.content.Context;
import androidx.collection.LruCache;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.api.SelectionRangeType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.layout.holder.helper.TargetDataSource;
import com.larus.bmhome.chat.layout.holder.helper.s0;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.cotdetail.list.processor.CotDetailMessageActionDelegate$copyMessage$1", f = "CotDetailMessageActionDelegate.kt", i = {}, l = {90, 108, DoraCallStateCode.DOUBAO_CMD_14}, m = "invokeSuspend", n = {}, s = {})
final class CotDetailMessageActionDelegate$copyMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ s0 $copyHelper;
    int label;
    final /* synthetic */ k this$0;

    public CotDetailMessageActionDelegate$copyMessage$1(s0 r1, Context r2, k r3, Continuation<? super CotDetailMessageActionDelegate$copyMessage$1> r4) {
        this.$copyHelper = r1;
        this.$context = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new CotDetailMessageActionDelegate$copyMessage$1(this.$copyHelper, this.$context, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r22) {
        Object r7 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L12;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        ResultKt.throwOnFailure(r22);
    L48:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r22);
        Object r1 = r22;
    L37:
        String r2 = (String) r1;
        if (((Boolean) this.this$0.i.invoke()).booleanValue() == true) goto L42;
        return Unit.INSTANCE;
    L42:
        if (this.$copyHelper.f(this.$context, r2) == false) goto L48;
        s r3 = s.a;
        Context r4 = this.$context;
        r3.getClass();
        s.o(r4, 2131910467, false);
        goto L48
    L11:
        ResultKt.throwOnFailure(r22);
        Object r5 = r22;
    L15:
        List<? extends lw8.l> r6 = (List) r5;
        k r8 = this.this$0;
        if (r8.h == true) goto L18;
    L21:
        LruCache r9 = ko8.a.a;
        k r10 = this.this$0;
        Message r11 = r10.c;
        f r12 = r10.j;
        if (r12 == null) goto L24;
        by7.e r13 = r12;
    L28:
        long r14 = ko8.a.g();
        k r15 = this.this$0;
        CustomMarkdownTextView r16 = r15.e;
        if (r15.h == false) goto L31;
        SelectionRangeType r18 = SelectionRangeType.ENTIRE;
    L32:
        ko8.a.j("long_press_answer", r11, r13, r14, r6, r16, null, r18, ChatDraftItem.TYPE_TEXT, 64);
        if (this.this$0.h == false) goto L44;
        s0 r17 = this.$copyHelper;
        this.label = 2;
        r1 = r17.b(r6, this);
        if (r1 != r7) goto L37;
        return r7;
    L44:
        s0 r19 = this.$copyHelper;
        Context r20 = this.$context;
        this.label = 3;
        if (r19.e(r20, r6, "bpea-thread-detail-text", this) != r7) goto L48;
        return r7;
    L31:
        r18 = null;
        goto L32
    L24:
        CustomMarkdownTextView r21 = r10.e;
        if (r21 == null) goto L27;
        r13 = by7.h.g(r21);
        goto L28
    L27:
        r13 = null;
        goto L28
    L18:
        if (((Boolean) r8.i.invoke()).booleanValue() == true) goto L21;
        return Unit.INSTANCE;
    L12:
        ResultKt.throwOnFailure(r22);
        s0 r23 = this.$copyHelper;
        Context r24 = this.$context;
        k r25 = this.this$0;
        Message r26 = r25.c;
        BotModel r27 = r25.d;
        TargetDataSource r28 = TargetDataSource.ALL;
        this.label = 1;
        r5 = r23.g(r24, r26, r27, r28, this);
        if (r5 != r7) goto L15;
        return r7;
    }
}
