package com.ss.android.lark.conditional.access.device.ui;

import com.ss.android.lark.conditional.access.databinding.ScsFragmentDeviceDeclareOldBinding;
import com.ss.android.lark.conditional.access.network.model.response.GetDeviceApplySwitchData;
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
@DebugMetadata(c = "com.ss.android.lark.conditional.access.device.ui.UserScopeDeviceDeclareFragment$initData$2$1$1", f = "UserScopeDeviceDeclareFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UserScopeDeviceDeclareFragment$initData$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GetDeviceApplySwitchData $it;
    int label;
    final /* synthetic */ UserScopeDeviceDeclareFragment this$0;

    public UserScopeDeviceDeclareFragment$initData$2$1$1(GetDeviceApplySwitchData r1, UserScopeDeviceDeclareFragment r2, Continuation<? super UserScopeDeviceDeclareFragment$initData$2$1$1> r3) {
        this.$it = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new UserScopeDeviceDeclareFragment$initData$2$1$1(this.$it, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r2);
        if (this.$it.getSwitch() == false) goto L7;
        ((ScsFragmentDeviceDeclareOldBinding) this.this$0.T90()).c.setVisibility(0);
    L9:
        return Unit.INSTANCE;
    L7:
        ((ScsFragmentDeviceDeclareOldBinding) this.this$0.T90()).c.setVisibility(8);
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
