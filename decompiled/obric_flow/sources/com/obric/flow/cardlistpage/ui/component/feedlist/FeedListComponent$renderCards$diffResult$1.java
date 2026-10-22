package com.obric.flow.cardlistpage.ui.component.feedlist;

import androidx.recyclerview.widget.DiffUtil;
import com.obric.flow.cardlistpage.base.BaseCardModel;
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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.obric.flow.cardlistpage.ui.component.feedlist.FeedListComponent$renderCards$diffResult$1", f = "FeedListComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class FeedListComponent$renderCards$diffResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DiffUtil.DiffResult>, Object> {
    final /* synthetic */ List<BaseCardModel> $newCards;
    final /* synthetic */ List<BaseCardModel> $oldCards;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public FeedListComponent$renderCards$diffResult$1(List<? extends BaseCardModel> r5, List<? extends BaseCardModel> r10, Continuation<? super FeedListComponent$renderCards$diffResult$1> r11) {
        this.$oldCards = r5;
        this.$newCards = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        return new FeedListComponent$renderCards$diffResult$1(this.$oldCards, this.$newCards, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super DiffUtil.DiffResult> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r5);
        final List<BaseCardModel> r10 = this.$oldCards;
        final List<BaseCardModel> r11 = this.$newCards;
        return DiffUtil.calculateDiff(new AnonymousClass1(r10, r11));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super DiffUtil.DiffResult> r10) {
        return ((FeedListComponent$renderCards$diffResult$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
