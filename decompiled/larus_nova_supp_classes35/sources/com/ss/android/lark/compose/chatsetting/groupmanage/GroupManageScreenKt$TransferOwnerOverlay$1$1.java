package com.ss.android.lark.compose.chatsetting.groupmanage;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.ui.focus.FocusRequester;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.compose.chatsetting.groupmanage.GroupManageScreenKt$TransferOwnerOverlay$1$1", f = "GroupManageScreen.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class GroupManageScreenKt$TransferOwnerOverlay$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FocusRequester $focusRequester;
    final /* synthetic */ MutableTransitionState<Boolean> $visibleState;
    int label;

    public GroupManageScreenKt$TransferOwnerOverlay$1$1(MutableTransitionState<Boolean> r1, FocusRequester r2, Continuation<? super GroupManageScreenKt$TransferOwnerOverlay$1$1> r3) {
        this.$visibleState = r1;
        this.$focusRequester = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new GroupManageScreenKt$TransferOwnerOverlay$1$1(this.$visibleState, this.$focusRequester, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r4);
        if (((Boolean) this.$visibleState.getTargetState()).booleanValue() == false) goto L8;
        FocusRequester.requestFocus-3ESFkO8$default(this.$focusRequester, 0, 1, null);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
