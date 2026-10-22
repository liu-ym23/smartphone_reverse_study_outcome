package com.larus.bmhome.chat.deepresearch.component;

import android.content.Context;
import androidx.collection.LruCache;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepresearch.DeepReSearchParam;
import com.larus.bmhome.chat.layout.holder.helper.s0;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepresearch.component.DeepReSearchTitleComponent$performCopy$1", f = "DeepReSearchTitleComponent.kt", i = {0}, l = {139, 155}, m = "invokeSuspend", n = {"msg"}, s = {"L$0"})
public final class DeepReSearchTitleComponent$performCopy$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ DeepReSearchTitleComponent this$0;

    public DeepReSearchTitleComponent$performCopy$1(DeepReSearchTitleComponent r1, Continuation<? super DeepReSearchTitleComponent$performCopy$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DeepReSearchTitleComponent$performCopy$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L11;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        ResultKt.throwOnFailure(r18);
    L48:
        t19.s r3 = t19.s.a;
        Context r4 = this.this$0.getContext();
        r3.getClass();
        t19.s.o(r4, 2131910467, false);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Message r5 = (Message) this.L$0;
        ResultKt.throwOnFailure(r18);
        Object r6 = r18;
    L10:
        Message r7 = r5;
        List<? extends lw8.l> r8 = (List) r6;
        if (r8 != null) goto L33;
        r8 = CollectionsKt.emptyList();
    L33:
        LruCache r9 = ko8.a.a;
        DeepReSearchTitleComponent r10 = this.this$0;
        int r11 = DeepReSearchTitleComponent.u;
        DeepReSearchParam r12 = r10.Y2();
        if (r12 == null) goto L38;
        Long r13 = r12.h;
        if (r13 == null) goto L38;
        long r14 = r13.longValue();
    L39:
        k0 r15 = (k0) this.this$0.n.getValue();
        if (r15 == null) goto L42;
        String r16 = r15.k();
    L43:
        ko8.a.j("header", r7, null, r14, r8, null, r16, null, null, 384);
        s0 r17 = ILegacyChatUiServiceDelegate.b.X8();
        if (r17 == null) goto L48;
        Context r19 = this.this$0.getContext();
        this.L$0 = null;
        this.label = 2;
        if (r17.e(r19, r8, null, this) != r1) goto L48;
        return r1;
    L42:
        r16 = null;
    L38:
        r14 = 0;
        goto L39
    L11:
        ResultKt.throwOnFailure(r18);
        DeepReSearchTitleComponent r20 = this.this$0;
        int r21 = DeepReSearchTitleComponent.u;
        DeepReSearchParam r22 = r20.Y2();
        if (r22 == null) goto L14;
        r5 = r22.f;
    L15:
        DeepReSearchParam r23 = this.this$0.Y2();
        if (r23 == null) goto L18;
        BotModel r24 = r23.g;
    L19:
        if (r5 == null) goto L51;
        if (r24 == null) goto L51;
        j0 r25 = (j0) this.this$0.o.getValue();
        if (r25 == null) goto L26;
        List<Block> r26 = r25.HK();
        if (r26 == null) goto L26;
    L27:
        CoroutineDispatcher r27 = Dispatchers.getIO();
        DeepReSearchTitleComponent$performCopy$1$markdownContentList$1 r28 = new DeepReSearchTitleComponent$performCopy$1$markdownContentList$1(this.this$0, r26, null);
        this.L$0 = r5;
        this.label = 1;
        r6 = BuildersKt.withContext(r27, r28, this);
        if (r6 != r1) goto L10;
        return r1;
    L26:
        r26 = CollectionsKt.emptyList();
    L51:
        return Unit.INSTANCE;
    L18:
        r24 = null;
        goto L19
    L14:
        r5 = null;
        goto L15
    }
}
