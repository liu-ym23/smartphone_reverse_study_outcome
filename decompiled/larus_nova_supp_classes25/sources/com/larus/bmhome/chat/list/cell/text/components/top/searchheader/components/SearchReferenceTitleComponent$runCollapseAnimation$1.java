package com.larus.bmhome.chat.list.cell.text.components.top.searchheader.components;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.list.arch.FlowListViewHolder;
import com.larus.list.arch.IFlowListCell;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.components.top.searchheader.components.SearchReferenceTitleComponent$runCollapseAnimation$1", f = "SearchReferenceTitleComponent.kt", i = {0}, l = {436}, m = "invokeSuspend", n = {"index$iv"}, s = {"I$0"})
final class SearchReferenceTitleComponent$runCollapseAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<RecyclerView.ViewHolder> $needExpandViewHolderList;
    final /* synthetic */ Ref.LongRef $totalAnimationDuration;
    final /* synthetic */ Ref.IntRef $totalHeight;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;
        public final /* synthetic */ IFlowListCell<ei9.f> b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationCancel(r2);
            ViewGroup.LayoutParams r3 = this.a.getLayoutParams();
            r3.height = -2;
            this.a.setLayoutParams(r3);
            hg8.z r4 = this.b;
            if ((r4 instanceof hg8.z) == false) goto L5;
            hg8.z r5 = r4;
        L6:
            if (r5 == null) goto L9;
            r5.i(8);
            return;
        L9:
            return;
        L5:
            r5 = null;
            goto L6
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            ViewGroup.LayoutParams r3 = this.a.getLayoutParams();
            r3.height = -2;
            this.a.setLayoutParams(r3);
            hg8.z r4 = this.b;
            if ((r4 instanceof hg8.z) == false) goto L5;
            hg8.z r5 = r4;
        L6:
            if (r5 == null) goto L9;
            r5.i(8);
            return;
        L9:
            return;
        L5:
            r5 = null;
            goto L6
        }

        public a(View r1, IFlowListCell<? super ei9.f> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public SearchReferenceTitleComponent$runCollapseAnimation$1(List<RecyclerView.ViewHolder> r1, Ref.IntRef r2, Ref.LongRef r3, Continuation<? super SearchReferenceTitleComponent$runCollapseAnimation$1> r4) {
        this.$needExpandViewHolderList = r1;
        this.$totalHeight = r2;
        this.$totalAnimationDuration = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new SearchReferenceTitleComponent$runCollapseAnimation$1(this.$needExpandViewHolderList, this.$totalHeight, this.$totalAnimationDuration, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        int r2 = this.I$0;
        Iterator r4 = (Iterator) this.L$2;
        Ref.LongRef r5 = (Ref.LongRef) this.L$1;
        Ref.IntRef r6 = (Ref.IntRef) this.L$0;
        ResultKt.throwOnFailure(r15);
        int r16 = r2;
    L10:
        if (r4.hasNext() == false) goto L25;
        Object r7 = r4.next();
        int r8 = r16 + 1;
        if (r16 >= 0) goto L14;
        CollectionsKt.throwIndexOverflow();
    L14:
        FlowListViewHolder r9 = (RecyclerView.ViewHolder) r7;
        int r17 = ((RecyclerView.ViewHolder) r9).itemView.getHeight();
        final View r10 = ((RecyclerView.ViewHolder) r9).itemView;
        long r11 = (long) ((r17 / r6.element) * r5.element);
        IFlowListCell r13 = null;
        if ((r9 instanceof FlowListViewHolder) == false) goto L17;
        FlowListViewHolder r12 = r9;
    L18:
        if (r12 == null) goto L20;
        r13 = r12.b;
    L20:
        ValueAnimator r18 = ValueAnimator.ofInt(new int[]{r17, 0}).setDuration(r11);
        r18.addUpdateListener(new f0(r10));
        r18.addListener(new a(r10, r13));
        r18.start();
        this.L$0 = r6;
        this.L$1 = r5;
        this.L$2 = r4;
        this.I$0 = r8;
        this.label = 1;
        if (DelayKt.delay(r11, this) == r0) goto L22;
        r16 = r8;
        goto L10
    L22:
        return r0;
    L17:
        r12 = null;
        goto L18
    L25:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        List<RecyclerView.ViewHolder> r19 = this.$needExpandViewHolderList;
        r6 = this.$totalHeight;
        r5 = this.$totalAnimationDuration;
        r4 = r19.iterator();
        r16 = 0;
        goto L10
    }
}
