package com.larus.avlink.record.page;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.larus.avlink.impl.databinding.LayoutFragmentRecordMinutesBinding;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Pair;", "Lcom/larus/avlink/record/page/Action;", "", "Lcom/larus/avlink/record/page/RecordMinutesItemData;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.page.RecordMinutesFragment$initSubscribers$4", f = "RecordMinutesFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class RecordMinutesFragment$initSubscribers$4 extends SuspendLambda implements Function2<Pair<? extends Action, ? extends List<? extends i0>>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RecordMinutesFragment this$0;

    public RecordMinutesFragment$initSubscribers$4(RecordMinutesFragment r1, Continuation<? super RecordMinutesFragment$initSubscribers$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        RecordMinutesFragment$initSubscribers$4 r0 = new RecordMinutesFragment$initSubscribers$4(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((Pair) r1, (Continuation) r2);
    }

    public final Object invoke(Pair<? extends Action, ? extends List<i0>> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L29;
        ResultKt.throwOnFailure(r6);
        Pair r7 = (Pair) this.L$0;
        if (r7.getFirst() != Action.REFRESH_PULL) goto L11;
        LayoutFragmentRecordMinutesBinding r0 = this.this$0.e;
        if (r0 == null) goto L11;
        SwipeRefreshLayout r1 = r0.g;
        if (r1 == null) goto L11;
        r1.setRefreshing(false);
    L11:
        RecordMinutesAdapter r2 = this.this$0.g;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("recordAdapter");
        r2 = null;
    L14:
        List<i0> r3 = (List) r7.getSecond();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r3, "item");
        DiffUtil.DiffResult r4 = DiffUtil.calculateDiff(new RecordMinutesAdapter.a(r2.e, r3));
        r2.e = r3;
        r4.dispatchUpdatesTo(r2);
        if (r7.getFirst() == Action.DELETE) goto L24;
        if (r7.getFirst() == Action.UPLOAD_PROGRESS) goto L24;
        LayoutFragmentRecordMinutesBinding r5 = this.this$0.e;
        if (r5 == null) goto L24;
        RecyclerView r8 = r5.f;
        if (r8 == null) goto L24;
        r8.scrollToPosition(0);
    L24:
        if (r7.getFirst() == Action.UPLOAD_PROGRESS) goto L27;
        com.larus.avlink.n1.d("recordingFragment", "render list, action=" + r7.getFirst() + ", size=" + ((List) r7.getSecond()).size());
    L27:
        return Unit.INSTANCE;
    L29:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
