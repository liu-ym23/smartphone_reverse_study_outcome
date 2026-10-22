package com.larus.bmhome.chat.deepsearch.component;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.deepsearch.DeepSearchParam;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.deepsearch.component.DeepSearchTitleComponent$initFavoriteIcon$1", f = "DeepSearchTitleComponent.kt", i = {2}, l = {212, 214, 220}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
final class DeepSearchTitleComponent$initFavoriteIcon$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DeepSearchTitleComponent this$0;

    public DeepSearchTitleComponent$initFavoriteIcon$1(DeepSearchTitleComponent r1, Continuation<? super DeepSearchTitleComponent$initFavoriteIcon$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DeepSearchTitleComponent$initFavoriteIcon$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r48) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 == 2) goto L10;
        if (r2 != 3) goto L9;
        String r3 = (String) this.L$1;
        DeepSearchTitleComponent r4 = (DeepSearchTitleComponent) this.L$0;
        ResultKt.throwOnFailure(r48);
        Object r5 = r48;
    L61:
        Iterator r6 = ((List) r5).iterator();
    L63:
        if (r6.hasNext() == false) goto L72;
        Message r7 = (Message) r6.next();
        Map r8 = r7.getExt();
        if (r8 == null) goto L67;
        String r9 = (String) r8.get("deep_search_from_id");
    L69:
        if (Intrinsics.areEqual(r9, r3) == false) goto L63;
        DeepSearchTitleComponent.Y2(r4, r7);
        goto L63
    L67:
        r9 = null;
    L72:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r48);
        goto L72
    L11:
        ResultKt.throwOnFailure(r48);
        Object r10 = r48;
    L42:
        Message r11 = (Message) r10;
        if (r11 == null) goto L72;
        DeepSearchTitleComponent r12 = this.this$0;
        MainCoroutineDispatcher r13 = Dispatchers.getMain();
        DeepSearchTitleComponent$initFavoriteIcon$1$2$1 r14 = new DeepSearchTitleComponent$initFavoriteIcon$1$2$1(r12, r11, null);
        this.label = 2;
        if (BuildersKt.withContext(r13, r14, this) != r1) goto L72;
        return r1;
    L12:
        ResultKt.throwOnFailure(r48);
        DeepSearchTitleComponent r15 = this.this$0;
        int r16 = DeepSearchTitleComponent.r;
        DeepSearchParam r17 = r15.m3();
        if (r17 == null) goto L15;
        boolean r18 = Intrinsics.areEqual(r17.f, Boxing.boxBoolean(true));
    L16:
        if (r18 == false) goto L29;
        DeepSearchParam r19 = this.this$0.m3();
        if (r19 == null) goto L20;
        Message r20 = r19.g;
    L21:
        if (r20 == null) goto L29;
        DeepSearchParam r21 = this.this$0.m3();
        if (r21 == null) goto L72;
        Message r22 = r21.g;
        if (r22 == null) goto L72;
        Message r23 = Message.copy$default(r22, null, null, null, 0, 21, null, 0, false, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -17, 31, null);
        if (r23 == null) goto L72;
        DeepSearchTitleComponent.Y2(this.this$0, r23);
        goto L72
    L20:
        r20 = null;
    L29:
        DeepSearchParam r24 = this.this$0.m3();
        if (r24 == null) goto L32;
        String r25 = r24.a;
    L34:
        if (o0.d(r25) == false) goto L47;
        IChatRepoService r26 = zh8.a.a;
        IChatRepoService r27 = zh8.a.a;
        DeepSearchParam r28 = this.this$0.m3();
        if (r28 == null) goto L38;
        String r29 = r28.a;
    L39:
        String r30 = String.valueOf(r29);
        this.label = 1;
        r10 = r27.E1(r30, this);
        if (r10 != r1) goto L42;
        return r1;
    L38:
        r29 = null;
        goto L39
    L47:
        DeepSearchParam r31 = this.this$0.m3();
        if (r31 == null) goto L72;
        String r32 = r31.b;
        if (r32 == null) goto L72;
        DeepSearchTitleComponent r33 = this.this$0;
        IChatRepoService r34 = zh8.a.a;
        IChatRepoService r35 = zh8.a.a;
        DeepSearchParam r36 = r33.m3();
        if (r36 == null) goto L54;
        String r37 = r36.c;
    L55:
        if (r37 != null) goto L57;
        r37 = "";
    L57:
        this.L$0 = r33;
        this.L$1 = r32;
        this.label = 3;
        r5 = r35.o1(r37, 0, this);
        if (r5 != r1) goto L60;
        return r1;
    L60:
        r3 = r32;
        r4 = r33;
        goto L61
    L54:
        r37 = null;
        goto L55
    L32:
        r25 = null;
        goto L34
    L15:
        r18 = false;
        goto L16
    }
}
