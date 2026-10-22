package com.ss.android.lark.compose.chatsetting.groupmanage;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.runtime.MutableState;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageScreenKt$GroupManageScreen$3$1", f = "GroupManageScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GroupManageScreenKt$GroupManageScreen$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Boolean> $showTransferOwnerSheet$delegate;
    final /* synthetic */ MutableState<Integer> $transferOwnerInstance$delegate;
    final /* synthetic */ MutableTransitionState<Boolean> $transferOwnerVisibleState;
    int label;

    public GroupManageScreenKt$GroupManageScreen$3$1(MutableTransitionState<Boolean> r1, MutableState<Boolean> r2, MutableState<Integer> r3, Continuation<? super GroupManageScreenKt$GroupManageScreen$3$1> r4) {
        this.$transferOwnerVisibleState = r1;
        this.$showTransferOwnerSheet$delegate = r2;
        this.$transferOwnerInstance$delegate = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new GroupManageScreenKt$GroupManageScreen$3$1(this.$transferOwnerVisibleState, this.$showTransferOwnerSheet$delegate, this.$transferOwnerInstance$delegate, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r2);
        if (((Boolean) this.$showTransferOwnerSheet$delegate.getValue()).booleanValue() == false) goto L7;
        int r3 = ((Number) this.$transferOwnerInstance$delegate.getValue()).intValue();
        this.$transferOwnerInstance$delegate.setValue(Integer.valueOf(r3 + 1));
    L7:
        this.$transferOwnerVisibleState.setTargetState(Boxing.boxBoolean(((Boolean) this.$showTransferOwnerSheet$delegate.getValue()).booleanValue()));
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
