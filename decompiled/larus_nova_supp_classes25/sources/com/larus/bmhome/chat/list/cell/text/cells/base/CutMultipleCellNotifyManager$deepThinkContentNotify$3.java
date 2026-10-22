package com.larus.bmhome.chat.list.cell.text.cells.base;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.cells.base.CutMultipleCellNotifyManager$deepThinkContentNotify$3", f = "CutMultipleCellNotifyManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class CutMultipleCellNotifyManager$deepThinkContentNotify$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $contentType;
    final /* synthetic */ dc8.c<bd8.b, ec8.b> $contextManager;
    final /* synthetic */ List<k> $listToBeUpdate;
    final /* synthetic */ String $messageId;
    final /* synthetic */ Object $payload;
    int label;
    final /* synthetic */ CutMultipleCellNotifyManager this$0;

    public CutMultipleCellNotifyManager$deepThinkContentNotify$3(List<k> r1, dc8.c<bd8.b, ec8.b> r2, String r3, CutMultipleCellNotifyManager r4, int r5, Object r6, Continuation<? super CutMultipleCellNotifyManager$deepThinkContentNotify$3> r7) {
        this.$listToBeUpdate = r1;
        this.$contextManager = r2;
        this.$messageId = r3;
        this.this$0 = r4;
        this.$contentType = r5;
        this.$payload = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new CutMultipleCellNotifyManager$deepThinkContentNotify$3(this.$listToBeUpdate, this.$contextManager, this.$messageId, this.this$0, this.$contentType, this.$payload, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L66;
        ResultKt.throwOnFailure(r25);
        List<k> r1 = this.$listToBeUpdate;
        dc8.c<bd8.b, ec8.b> r2 = this.$contextManager;
        String r3 = this.$messageId;
        final CutMultipleCellNotifyManager r4 = this.this$0;
        int r5 = this.$contentType;
        final Object r6 = this.$payload;
        Iterator<T> r7 = r1.iterator();
    L6:
        if (r7.hasNext() == false) goto L64;
        k r8 = (k) r7.next();
        if (r2 == null) goto L12;
        ec8.b r9 = (ec8.b) r2.X0(r3);
        if (r9 == null) goto L12;
        ec8.b.a r10 = r8.c;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r9.c = r10;
    L12:
        List<Integer> r11 = r8.b;
        List<wq8.a> r12 = r4.a.D7();
        ArrayList r13 = new ArrayList();
        Iterator<T> r14 = r12.iterator();
    L14:
        if (r14.hasNext() == false) goto L18;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((wq8.a) r15).getMessage().getMessageId(), r3) == false) goto L14;
        r13.add(r15);
        goto L14
    L18:
        ArrayList r16 = new ArrayList();
        Iterator r17 = r13.iterator();
    L20:
        if (r17.hasNext() == false) goto L50;
        Object r18 = r17.next();
        wq8.a r19 = (wq8.a) r18;
        boolean r110 = false;
        if (Intrinsics.areEqual(r19.getMessage().getMessageId(), r3) == true) goto L24;
    L34:
        boolean r111 = false;
    L36:
        if ((r19 instanceof hg8.g) == false) goto L38;
        hg8.g r112 = (hg8.g) r19;
    L39:
        if (r112 == null) goto L43;
        c r113 = r112.g;
        if (r113 == null) goto L43;
        int r114 = r113.b;
    L44:
        boolean r115 = r11.contains(Integer.valueOf(r114));
        if (r111 == true) goto L47;
        if (r115 == true) goto L47;
    L48:
        if (r110 == false) goto L20;
        r16.add(r18);
    L47:
        r110 = true;
    L43:
        r114 = Integer.MAX_VALUE;
        goto L44
    L38:
        r112 = null;
        goto L39
    L24:
        if (r19.getMessage().getContentType() != r5) goto L34;
        if ((r19 instanceof eg8.g) == false) goto L30;
        if (eg8.h.a((eg8.g) r19) == false) goto L30;
    L33:
        r111 = true;
    L30:
        if ((r19 instanceof fg8.f) == false) goto L34;
        if (fg8.g.a((fg8.f) r19) == false) goto L34;
    L50:
        final ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r20 = r16.iterator();
    L52:
        if (r20.hasNext() == false) goto L54;
        r116.add(Integer.valueOf(r4.a.D7().indexOf((wq8.a) r20.next())));
        goto L52
    L54:
        FLogger r21 = FLogger.a;
        r21.d("CutMultipleCellNotifyManager", " newNotifyDeepThinkItemChanged:positionList: update ====" + r116);
        ChatMessageList r22 = r4.a.B7();
        if (r22 == null) goto L57;
        RecyclerView.LayoutManager r23 = r22.getLayoutManager();
    L59:
        if ((r23 instanceof LinearLayoutManager) == false) goto L61;
        final LinearLayoutManager r117 = (LinearLayoutManager) r23;
    L62:
        t0.e(new d(r117, r116, r4, r6));
        r21.d("CutMultipleCellNotifyManager", "position = " + CollectionsKt.joinToString$default(r116, ",", null, null, 0, null, null, 62, null) + ", messageId = " + r3);
        r4.a.R7(r3);
        goto L6
    L61:
        r117 = null;
        goto L62
    L57:
        r23 = null;
        goto L59
    L64:
        return Unit.INSTANCE;
    L66:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
