package com.ss.android.lark.conditional.access.device.ui;

import com.ss.android.lark.conditional.access.network.model.response.ApplyDeviceData;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.device.ui.UserScopeDeviceDeclareFragment$initData$3$1$1", f = "UserScopeDeviceDeclareFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UserScopeDeviceDeclareFragment$initData$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ApplyDeviceData $it;
    final /* synthetic */ Ref.BooleanRef $showDialog;
    int label;
    final /* synthetic */ UserScopeDeviceDeclareFragment this$0;

    public UserScopeDeviceDeclareFragment$initData$3$1$1(UserScopeDeviceDeclareFragment r1, ApplyDeviceData r2, Ref.BooleanRef r3, Continuation<? super UserScopeDeviceDeclareFragment$initData$3$1$1> r4) {
        this.this$0 = r1;
        this.$it = r2;
        this.$showDialog = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new UserScopeDeviceDeclareFragment$initData$3$1$1(this.this$0, this.$it, this.$showDialog, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r3);
        UserScopeDeviceDeclareFragment r4 = this.this$0;
        int r0 = this.$it.getApplyStatus();
        int r1 = UserScopeDeviceDeclareFragment.m;
        r4.ca0(r0, null);
        UserScopeDeviceDeclareFragment.Y90(this.this$0, this.$it.getOwnership());
        if (this.$showDialog.element == false) goto L8;
        UserScopeDeviceDeclareFragment.Z90(this.this$0, this.$it.getApplyStatus());
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
