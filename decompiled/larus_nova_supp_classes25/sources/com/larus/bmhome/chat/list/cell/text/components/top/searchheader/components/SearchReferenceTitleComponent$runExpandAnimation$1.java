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
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.components.top.searchheader.components.SearchReferenceTitleComponent$runExpandAnimation$1", f = "SearchReferenceTitleComponent.kt", i = {}, l = {346}, m = "invokeSuspend", n = {}, s = {})
final class SearchReferenceTitleComponent$runExpandAnimation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $expandHeight;
    final /* synthetic */ Ref.ObjectRef<Map<View, Integer>> $hashMap;
    final /* synthetic */ List<FlowListViewHolder<?>> $needExpandViewHolderList;
    final /* synthetic */ Ref.LongRef $totalAnimationDuration;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
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
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationEnd(r2);
            ViewGroup.LayoutParams r3 = this.a.getLayoutParams();
            r3.height = -2;
            this.a.setLayoutParams(r3);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            super.onAnimationStart(r2);
            hg8.z r3 = this.b;
            if ((r3 instanceof hg8.z) == false) goto L5;
            hg8.z r4 = r3;
        L7:
            if (r4 == null) goto L9;
            r4.i(0);
        L9:
            ViewGroup.LayoutParams r5 = this.a.getLayoutParams();
            r5.height = 0;
            this.a.setLayoutParams(r5);
            return;
        L5:
            r4 = null;
            goto L7
        }

        public a(View r1, IFlowListCell<? super ei9.f> r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public SearchReferenceTitleComponent$runExpandAnimation$1(List<FlowListViewHolder<?>> r1, Ref.ObjectRef<Map<View, Integer>> r2, Ref.IntRef r3, Ref.LongRef r4, Continuation<? super SearchReferenceTitleComponent$runExpandAnimation$1> r5) {
        this.$needExpandViewHolderList = r1;
        this.$hashMap = r2;
        this.$expandHeight = r3;
        this.$totalAnimationDuration = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new SearchReferenceTitleComponent$runExpandAnimation$1(this.$needExpandViewHolderList, this.$hashMap, this.$expandHeight, this.$totalAnimationDuration, r8);
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
        Iterator r2 = (Iterator) this.L$3;
        Ref.LongRef r3 = (Ref.LongRef) this.L$2;
        Ref.IntRef r4 = (Ref.IntRef) this.L$1;
        Ref.ObjectRef<Map<View, Integer>> r5 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r15);
    L10:
        if (r2.hasNext() == false) goto L19;
        FlowListViewHolder r6 = (FlowListViewHolder) r2.next();
        Integer r7 = (Integer) ((Map) r5.element).get(((RecyclerView.ViewHolder) r6).itemView);
        if (r7 == null) goto L14;
        int r8 = r7.intValue();
    L15:
        final View r9 = ((RecyclerView.ViewHolder) r6).itemView;
        IFlowListCell r10 = r6.b;
        long r11 = (long) ((r8 / r4.element) * r3.element);
        ValueAnimator r12 = ValueAnimator.ofInt(new int[]{0, r8}).setDuration(r11);
        r12.addUpdateListener(new g0(r9));
        r12.addListener(new a(r9, r10));
        r12.start();
        this.L$0 = r5;
        this.L$1 = r4;
        this.L$2 = r3;
        this.L$3 = r2;
        this.label = 1;
        if (DelayKt.delay(r11, this) != r0) goto L10;
        return r0;
    L14:
        r8 = 0;
        goto L15
    L19:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        List<FlowListViewHolder<?>> r16 = this.$needExpandViewHolderList;
        Ref.ObjectRef<Map<View, Integer>> r13 = this.$hashMap;
        Ref.IntRef r14 = this.$expandHeight;
        Ref.LongRef r17 = this.$totalAnimationDuration;
        r5 = r13;
        r2 = r16.iterator();
        r4 = r14;
        r3 = r17;
        goto L10
    }
}
