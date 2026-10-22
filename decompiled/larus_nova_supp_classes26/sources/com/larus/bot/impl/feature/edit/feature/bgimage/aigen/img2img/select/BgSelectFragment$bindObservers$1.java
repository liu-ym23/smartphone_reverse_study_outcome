package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

import androidx.recyclerview.widget.DiffUtil;
import com.larus.bot.impl.databinding.LarusPageBotBgSelectBinding;
import com.larus.utils.e1;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectFragment$bindObservers$1", f = "BgSelectFragment.kt", i = {}, l = {166}, m = "invokeSuspend", n = {}, s = {})
final class BgSelectFragment$bindObservers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BgSelectFragment this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ BgSelectFragment a;

        public a(BgSelectFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r5, Continuation r6) {
            l r7 = (l) r5;
            BgSelectFragment r8 = this.a;
            LarusPageBotBgSelectBinding r0 = r8.e;
            if (r0 == null) goto L17;
            BgSelectAdapter r9 = r8.h;
            if (r9 == null) goto L8;
            List<BgSelectViewHolder.a> r1 = r7.a;
            Intrinsics.checkNotNullParameter(r1, "data");
            DiffUtil.calculateDiff(new BgSelectAdapter.DiffCallback(r9.a, r1), false).dispatchUpdatesTo(r9);
            r9.a = r1;
        L8:
            if (r7.a.size() >= 2) goto L10;
            e1.q(r0.c);
        L11:
            r0.b.setEnabled(r7.b);
            if (r7.b == false) goto L14;
            r0.b.setAlpha(1.0f);
        L15:
            Unit r10 = Unit.INSTANCE;
            goto L17
        L14:
            r0.b.setAlpha(0.3f);
            goto L15
        L10:
            e1.x(r0.c);
        L17:
            return Unit.INSTANCE;
        }
    }

    public BgSelectFragment$bindObservers$1(BgSelectFragment r1, Continuation<? super BgSelectFragment$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BgSelectFragment$bindObservers$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        BgSelectFragment r6 = this.this$0;
        int r2 = BgSelectFragment.k;
        i1<l> r7 = r6.U90().getUiState();
        a r3 = new a(this.this$0);
        this.label = 1;
        if (r7.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
