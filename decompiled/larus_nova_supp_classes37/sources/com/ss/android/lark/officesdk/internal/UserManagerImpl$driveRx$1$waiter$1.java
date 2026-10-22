package com.ss.android.lark.officesdk.internal;

import com.ss.android.lark.officesdk.api.OfficeSDKDriveErrorCodes;
import com.ss.android.lark.officesdk.api.OfficeSDKDriveResult;
import com.ss.android.lark.picker.base.view.ItemViewType;
import io.reactivex.SingleEmitter;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.internal.UserManagerImpl$driveRx$1$waiter$1", f = "UserManagerImpl.kt", i = {}, l = {490}, m = "invokeSuspend", n = {}, s = {})
public final class UserManagerImpl$driveRx$1$waiter$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ UserManagerImpl.c $command;
    final /* synthetic */ SingleEmitter<OfficeSDKDriveResult> $emitter;
    final /* synthetic */ String $failureCode;
    final /* synthetic */ long $timeoutMs;
    int label;

    public UserManagerImpl$driveRx$1$waiter$1(long r1, String r3, SingleEmitter<OfficeSDKDriveResult> r4, UserManagerImpl.c r5, Continuation<? super UserManagerImpl$driveRx$1$waiter$1> r6) {
        this.$timeoutMs = r1;
        this.$failureCode = r3;
        this.$emitter = r4;
        this.$command = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new UserManagerImpl$driveRx$1$waiter$1(this.$timeoutMs, this.$failureCode, this.$emitter, this.$command, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        UserManagerImpl.a r8 = (UserManagerImpl.a) r7;
        if (r8 != null) goto L15;
        OfficeSDKDriveResult r9 = OfficeSDKDriveResult.Companion.failure$default(OfficeSDKDriveResult.Companion, OfficeSDKDriveErrorCodes.TIMEOUT, "drive command not finished within " + this.$timeoutMs + "ms", null, 4, null);
    L20:
        this.$emitter.onSuccess(r9);
        return Unit.INSTANCE;
    L15:
        if ((r8 instanceof UserManagerImpl.a.b) == false) goto L18;
        r9 = OfficeSDKDriveResult.Companion.success();
        goto L20
    L18:
        if ((r8 instanceof UserManagerImpl.a.C0010a) == false) goto L23;
        UserManagerImpl.a.C0010a r10 = (UserManagerImpl.a.C0010a) r8;
        r9 = OfficeSDKDriveResult.Companion.failure(this.$failureCode, r10.a.getMessage(), r10.a);
        goto L20
    L23:
        throw new NoWhenBranchMatchedException();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        long r3 = this.$timeoutMs;
        UserManagerImpl$driveRx$1$waiter$1$outcome$1 r11 = new UserManagerImpl$driveRx$1$waiter$1$outcome$1(this.$command, null);
        this.label = 1;
        r7 = TimeoutKt.c(r3, r11, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
