package com.obric.memorydata.memory.ui.list;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.AutoMemoryProEntity;
import com.obric.memorydata.database.entity.EpisodicMemoryEntity;
import com.obric.memorydata.database.entity.fj;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.memory.databinding.ItemMemoryListBinding;
import com.obric.memorydata.memory.tracker.MemoryEventTracker;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListItemViewHolderKt$delete$1", f = "MemoryListItemViewHolder.kt", i = {}, l = {1558, 1573, 1585, 1596}, m = "invokeSuspend", n = {}, s = {})
final class MemoryListItemViewHolderKt$delete$1 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
    final /* synthetic */ ItemMemoryListBinding $binding;
    final /* synthetic */ com.obric.memorydata.memory.ui.data.a $memoryItem;
    int label;

    /* JADX INFO: renamed from: com.obric.memorydata.memory.ui.list.MemoryListItemViewHolderKt$delete$1$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.memorydata.memory.ui.list.MemoryListItemViewHolderKt$delete$1$3", f = "MemoryListItemViewHolder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass3 extends SuspendLambda implements Function2<kotlinx.coroutines.al, Continuation<? super Unit>, Object> {
        final /* synthetic */ AutoMemoryProEntity $autoMemoryProEntity;
        int label;

        AnonymousClass3(AutoMemoryProEntity r3, Continuation<? super AnonymousClass3> r4) {
            Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
            this.$autoMemoryProEntity = r3;
            super(2, r5);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
            return (Continuation) ZeusTransformUtils.preCheckCast(new AnonymousClass3(this.$autoMemoryProEntity, r4), Continuation.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlin.jvm.functions.Function2
        public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
            return ((AnonymousClass3) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AnonymousClass3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r3);
            AutoMemoryProEntity r4 = (AutoMemoryProEntity) ZeusTransformUtils.preCheckCast(MemoryDbEngine.INSTANCE.getPersonalDbEngine().getAutoMemoryProDao().queryById(this.$autoMemoryProEntity.getId()), AutoMemoryProEntity.class, "com.obric.memorydata.plugin");
            if (r4 == null) goto L7;
            Boxing.boxBoolean(r4.delete());
        L7:
            MemoryDbEngine.INSTANCE.getPersonalDbEngine().getMemoryRuleDao().updateMemoryRuleCountById(this.$autoMemoryProEntity.getRuleId());
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    MemoryListItemViewHolderKt$delete$1(com.obric.memorydata.memory.ui.data.a r3, ItemMemoryListBinding r4, Continuation<? super MemoryListItemViewHolderKt$delete$1> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$memoryItem = r3;
        this.$binding = r4;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryListItemViewHolderKt$delete$1(this.$memoryItem, this.$binding, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
        return invoke2((kotlinx.coroutines.al) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.al r3, Continuation<? super Unit> r4) {
        return ((MemoryListItemViewHolderKt$delete$1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.al) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryListItemViewHolderKt$delete$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L11;
        if (r1 == 3) goto L11;
        if (r1 == 4) goto L11;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r11);
    L57:
        return Unit.INSTANCE;
    L12:
        ResultKt.throwOnFailure(r11);
        com.obric.memorydata.memory.ui.data.a r12 = this.$memoryItem;
        ViewModel r7 = null;
        if (ZeusTransformUtils.instanceOf(r12, com.obric.memorydata.memory.ui.data.a.h.class) == false) goto L23;
        ConstraintLayout r13 = this.$binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(r13, "getRoot(...)");
        ViewModelStoreOwner r14 = ViewTreeViewModelStoreOwner.get((View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.memorydata.plugin"));
        if (r14 == null) goto L17;
        r7 = new ViewModelProvider(r14).get(MemoryListViewModel.class);
    L17:
        MemoryListViewModel r15 = (MemoryListViewModel) ZeusTransformUtils.preCheckCast(r7, MemoryListViewModel.class, "com.obric.memorydata.plugin");
        if (r15 == null) goto L57;
        MemoryEntity r2 = ((com.obric.memorydata.memory.ui.data.a.h) ZeusTransformUtils.preCheckCast(this.$memoryItem, com.obric.memorydata.memory.ui.data.a.h.class, "com.obric.memorydata.plugin")).b();
        Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r15.deleteMemoryEntity(r2, r3) != r0) goto L57;
        return r0;
    L23:
        if (ZeusTransformUtils.instanceOf(r12, com.obric.memorydata.memory.ui.data.a.i.class) == false) goto L36;
        EpisodicMemoryEntity r16 = ((com.obric.memorydata.memory.ui.data.a.i) ZeusTransformUtils.preCheckCast(this.$memoryItem, com.obric.memorydata.memory.ui.data.a.i.class, "com.obric.memorydata.plugin")).b();
        AppEntity r4 = r16.convertToAppEntity();
        if (r4 == null) goto L27;
        MemoryEventTracker.f10515a.a(new AppEntity[]{r4}, MemoryEventTracker.DeleteMethod.GUI_DELETE.getValue());
    L27:
        ConstraintLayout r5 = this.$binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(r5, "getRoot(...)");
        ViewModelStoreOwner r6 = ViewTreeViewModelStoreOwner.get((View) ZeusTransformUtils.preCheckCast(r5, View.class, "com.obric.memorydata.plugin"));
        if (r6 == null) goto L30;
        r7 = new ViewModelProvider(r6).get(ScreenObservationViewModel.class);
    L30:
        ScreenObservationViewModel r8 = (ScreenObservationViewModel) ZeusTransformUtils.preCheckCast(r7, ScreenObservationViewModel.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L57;
        Continuation<? super Unit> r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 2;
        if (r8.deleteMemoryEntity(r16, r9) != r0) goto L57;
        return r0;
    L36:
        if (ZeusTransformUtils.instanceOf(r12, com.obric.memorydata.memory.ui.data.a.C0539a.class) == false) goto L49;
        fj r17 = ((com.obric.memorydata.memory.ui.data.a.C0539a) ZeusTransformUtils.preCheckCast(this.$memoryItem, com.obric.memorydata.memory.ui.data.a.C0539a.class, "com.obric.memorydata.plugin")).b();
        AppEntity r10 = r17.convertToAppEntity();
        if (r10 == null) goto L40;
        MemoryEventTracker.f10515a.a(new AppEntity[]{r10}, MemoryEventTracker.DeleteMethod.GUI_DELETE.getValue());
    L40:
        ConstraintLayout r18 = this.$binding.getRoot();
        Intrinsics.checkNotNullExpressionValue(r18, "getRoot(...)");
        ViewModelStoreOwner r19 = ViewTreeViewModelStoreOwner.get((View) ZeusTransformUtils.preCheckCast(r18, View.class, "com.obric.memorydata.plugin"));
        if (r19 == null) goto L43;
        r7 = new ViewModelProvider(r19).get(AudioMemoryListViewModel.class);
    L43:
        AudioMemoryListViewModel r20 = (AudioMemoryListViewModel) ZeusTransformUtils.preCheckCast(r7, AudioMemoryListViewModel.class, "com.obric.memorydata.plugin");
        if (r20 == null) goto L57;
        Continuation<? super Unit> r21 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 3;
        if (r20.deleteMemoryEntity(r17, r21) != r0) goto L57;
        return r0;
    L49:
        if (ZeusTransformUtils.instanceOf(r12, com.obric.memorydata.memory.ui.data.a.b.class) == false) goto L57;
        AutoMemoryProEntity r110 = ((com.obric.memorydata.memory.ui.data.a.b) ZeusTransformUtils.preCheckCast(this.$memoryItem, com.obric.memorydata.memory.ui.data.a.b.class, "com.obric.memorydata.plugin")).b();
        AppEntity r22 = r110.convertToAppEntity();
        if (r22 == null) goto L53;
        MemoryEventTracker.f10515a.a(new AppEntity[]{r22}, MemoryEventTracker.DeleteMethod.GUI_DELETE.getValue());
    L53:
        CoroutineContext r23 = (CoroutineContext) ZeusTransformUtils.preCheckCast(kotlinx.coroutines.ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin");
        Function2 r111 = (Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r110, null), Function2.class, "com.obric.memorydata.plugin");
        Continuation r24 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 4;
        if (kotlinx.coroutines.i.a(r23, r111, r24) != r0) goto L57;
        return r0;
    }
}
