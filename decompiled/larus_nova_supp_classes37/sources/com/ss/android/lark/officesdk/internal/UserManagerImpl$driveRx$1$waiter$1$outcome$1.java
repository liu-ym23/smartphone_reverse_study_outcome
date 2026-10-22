package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/officesdk/internal/UserManagerImpl$CommandOutcome;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.internal.UserManagerImpl$driveRx$1$waiter$1$outcome$1", f = "UserManagerImpl.kt", i = {}, l = {490}, m = "invokeSuspend", n = {}, s = {})
public final class UserManagerImpl$driveRx$1$waiter$1$outcome$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UserManagerImpl.a>, Object> {
    final /* synthetic */ UserManagerImpl.c $command;
    int label;

    public UserManagerImpl$driveRx$1$waiter$1$outcome$1(UserManagerImpl.c r1, Continuation<? super UserManagerImpl$driveRx$1$waiter$1$outcome$1> r2) {
        this.$command = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new UserManagerImpl$driveRx$1$waiter$1$outcome$1(this.$command, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super UserManagerImpl.a> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
    L11:
        return r4;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        CompletableDeferred<UserManagerImpl.a> r5 = this.$command.a;
        this.label = 1;
        r4 = r5.await(this);
        if (r4 != r0) goto L11;
        return r0;
    }
}
