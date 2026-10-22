package com.obric.memorydata.recommend.ui.list;

import android.view.View;
import com.bytedance.obric.memory.model.MemoryData;
import com.bytedance.obric.memory.model.UserTodo;
import com.mcxtzhang.swipemenulib.SwipeMenuLayout;
import com.obric.memorydata.recommend.databinding.ItemRecommendMemoryCardBinding;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.recommend.ui.list.RecommendMemoryItemViewHolderKt$showDeleteDialog$2$1", f = "RecommendMemoryItemViewHolder.kt", i = {}, l = {394, 395, 396}, m = "invokeSuspend", n = {}, s = {})
final class RecommendMemoryItemViewHolderKt$showDeleteDialog$2$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ ItemRecommendMemoryCardBinding $binding;
    final /* synthetic */ f $memoryItem;
    int label;

    RecommendMemoryItemViewHolderKt$showDeleteDialog$2$1(f r3, ItemRecommendMemoryCardBinding r4, Continuation<? super RecommendMemoryItemViewHolderKt$showDeleteDialog$2$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$memoryItem = r3;
        this.$binding = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new RecommendMemoryItemViewHolderKt$showDeleteDialog$2$1(this.$memoryItem, this.$binding, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((RecommendMemoryItemViewHolderKt$showDeleteDialog$2$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), RecommendMemoryItemViewHolderKt$showDeleteDialog$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 == 1) goto L10;
        if (r1 == 2) goto L10;
        if (r1 == 3) goto L10;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r8);
    L33:
        return Unit.INSTANCE;
    L11:
        ResultKt.throwOnFailure(r8);
        f r9 = this.$memoryItem;
        if (ZeusTransformUtils.instanceOf(r9, f.b.class) == false) goto L19;
        SwipeMenuLayout r10 = this.$binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(r10, "getRoot(...)");
        MemoryListViewModel r11 = k.a((View) ZeusTransformUtils.preCheckCast(r10, View.class, "com.obric.memorydata.plugin"));
        if (r11 == null) goto L33;
        MemoryData r2 = ((f.b) ZeusTransformUtils.preCheckCast(this.$memoryItem, f.b.class, "com.obric.memorydata.plugin")).a();
        Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r11.deleteMemoryEntity(r2, r3) != r0) goto L33;
        return r0;
    L19:
        if (ZeusTransformUtils.instanceOf(r9, f.c.class) == false) goto L26;
        SwipeMenuLayout r12 = this.$binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(r12, "getRoot(...)");
        PortraitViewModel r13 = k.b((View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin"));
        if (r13 == null) goto L33;
        MemoryData r4 = ((f.c) ZeusTransformUtils.preCheckCast(this.$memoryItem, f.c.class, "com.obric.memorydata.plugin")).a();
        Continuation<? super Unit> r5 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 2;
        if (r13.deleteMemoryEntity(r4, r5) != r0) goto L33;
        return r0;
    L26:
        if (ZeusTransformUtils.instanceOf(r9, f.d.class) == false) goto L33;
        SwipeMenuLayout r14 = this.$binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(r14, "getRoot(...)");
        UserTodoViewModel r15 = k.c((View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin"));
        if (r15 == null) goto L33;
        UserTodo r6 = ((f.d) ZeusTransformUtils.preCheckCast(this.$memoryItem, f.d.class, "com.obric.memorydata.plugin")).a();
        Continuation<? super Unit> r7 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 3;
        if (r15.deleteMemoryEntity(r6, r7) != r0) goto L33;
        return r0;
    }
}
