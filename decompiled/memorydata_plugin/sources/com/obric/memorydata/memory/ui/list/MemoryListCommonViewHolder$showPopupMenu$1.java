package com.obric.memorydata.memory.ui.list;

import android.view.View;
import com.obric.oui.checkbox.OCheckBox;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KFunction;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListCommonViewHolder$showPopupMenu$1", f = "MemoryListItemViewHolder.kt", i = {}, l = {566}, m = "invokeSuspend", n = {}, s = {})
final class MemoryListCommonViewHolder$showPopupMenu$1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $anchor;
    final /* synthetic */ boolean $blockMemory;
    final /* synthetic */ String $blockMemoryContent;
    final /* synthetic */ boolean $isUpper;
    final /* synthetic */ int[] $location;
    final /* synthetic */ com.obric.memorydata.memory.ui.data.a $memoryItem;
    final /* synthetic */ OCheckBox $oCheckBox;
    final /* synthetic */ Function0<Unit> $onDismiss;
    int label;
    final /* synthetic */ v this$0;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListCommonViewHolder$showPopupMenu$1$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<com.obric.memorydata.memory.ui.data.a, Unit> {
        AnonymousClass1(Object r8) {
            super(1, r8, v.class, "onItemDelete", "onItemDelete(Lcom/obric/memorydata/memory/ui/data/MemoryItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.memorydata.memory.ui.data.a r3) {
            invoke2((com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.obric.memorydata.memory.ui.data.a r3) {
            Intrinsics.checkNotNullParameter(r3, "p0");
            v.a((v) ZeusTransformUtils.preCheckCast(this.receiver, v.class, "com.obric.memorydata.plugin"), r3);
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListCommonViewHolder$showPopupMenu$1$3, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<com.obric.memorydata.memory.ui.data.a, Unit> {
        AnonymousClass3(Object r8) {
            super(1, r8, v.class, "onItemFeedback", "onItemFeedback(Lcom/obric/memorydata/memory/ui/data/MemoryItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(com.obric.memorydata.memory.ui.data.a r3) {
            invoke2((com.obric.memorydata.memory.ui.data.a) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.memory.ui.data.a.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.obric.memorydata.memory.ui.data.a r3) {
            Intrinsics.checkNotNullParameter(r3, "p0");
            v.c((v) ZeusTransformUtils.preCheckCast(this.receiver, v.class, "com.obric.memorydata.plugin"), r3);
        }
    }

    MemoryListCommonViewHolder$showPopupMenu$1(v r3, boolean r4, com.obric.memorydata.memory.ui.data.a r5, View r6, int[] r7, Function0<Unit> r8, boolean r9, String r10, OCheckBox r11, Continuation<? super MemoryListCommonViewHolder$showPopupMenu$1> r12) {
        Function0<Unit> r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$blockMemory = r4;
        this.$memoryItem = r5;
        this.$anchor = r6;
        this.$location = r7;
        this.$onDismiss = r13;
        this.$isUpper = r9;
        this.$blockMemoryContent = r10;
        this.$oCheckBox = r11;
        super(2, r14);
    }

    private static final Unit invokeSuspend$lambda$0(v r0, com.obric.memorydata.memory.ui.data.a r1, String r2, com.obric.memorydata.memory.ui.data.a r3) {
        if (r2 != null) goto L4;
        r2 = "";
    L4:
        v.a(r0, r1, r2);
        return Unit.INSTANCE;
    }

    private static final Unit invokeSuspend$lambda$1(v r2, OCheckBox r3, com.obric.memorydata.memory.ui.data.a r4) {
        v.a(r2, r3, false, 2, null);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$lhZ2D6iDfbJun46FNFTsyk7S1p0(v r0, com.obric.memorydata.memory.ui.data.a r1, String r2, com.obric.memorydata.memory.ui.data.a r3) {
        return invokeSuspend$lambda$0(r0, r1, r2, r3);
    }

    public static /* synthetic */ Unit lambda$mdTePIvr1qLuvx9zacAPSJhC0cs(v r0, OCheckBox r1, com.obric.memorydata.memory.ui.data.a r2) {
        return invokeSuspend$lambda$1(r0, r1, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r13, Continuation<?> r14) {
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r14, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryListCommonViewHolder$showPopupMenu$1(this.this$0, this.$blockMemory, this.$memoryItem, this.$anchor, this.$location, this.$onDismiss, this.$isUpper, this.$blockMemoryContent, this.$oCheckBox, r11), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
        return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
        return ((MemoryListCommonViewHolder$showPopupMenu$1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryListCommonViewHolder$showPopupMenu$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r18) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r18);
        Object r3 = r18;
    L11:
        boolean r4 = ((Boolean) ZeusTransformUtils.preCheckCast(r3, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        KFunction r5 = null;
        if (r4 == false) goto L14;
        final v r6 = this.this$0;
        final com.obric.memorydata.memory.ui.data.a r7 = this.$memoryItem;
        final String r8 = this.$blockMemoryContent;
        Function1 r14 = new $$Lambda$MemoryListCommonViewHolder$showPopupMenu$1$lhZ2D6iDfbJun46FNFTsyk7S1p0(r6, r7, r8);
    L16:
        if (ZeusTransformUtils.instanceOf(this.$memoryItem, com.obric.memorydata.memory.ui.data.a.b.class) == false) goto L18;
        Function1<com.obric.memorydata.memory.ui.data.a, Unit> r12 = null;
    L19:
        View r9 = this.$anchor;
        com.obric.memorydata.memory.ui.data.a r10 = this.$memoryItem;
        int[] r11 = this.$location;
        Function1 r13 = (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this.this$0), Function1.class, "com.obric.memorydata.plugin");
        final v r15 = this.this$0;
        final OCheckBox r16 = this.$oCheckBox;
        Function1 r17 = new $$Lambda$MemoryListCommonViewHolder$showPopupMenu$1$mdTePIvr1qLuvx9zacAPSJhC0cs(r15, r16);
        if (v.b(this.this$0, this.$memoryItem) == false) goto L22;
        r5 = (KFunction) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.this$0), KFunction.class, "com.obric.memorydata.plugin");
    L22:
        com.obric.memorydata.memory.ui.g r19 = new com.obric.memorydata.memory.ui.g(r9, r10, r11, r13, r12, r17, r14, (Function1) ZeusTransformUtils.preCheckCast(r5, Function1.class, "com.obric.memorydata.plugin"), this.$onDismiss);
        if (this.$isUpper == false) goto L25;
        int r0 = 80;
    L26:
        r19.a(r0);
        return Unit.INSTANCE;
    L25:
        r0 = 48;
        goto L26
    L18:
        r12 = this.this$0.b();
        goto L19
    L14:
        r14 = null;
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r18);
        v r20 = this.this$0;
        boolean r21 = this.$blockMemory;
        Continuation r22 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        r3 = v.a(r20, r21, r22);
        if (r3 != r1) goto L11;
        return r1;
    }
}
