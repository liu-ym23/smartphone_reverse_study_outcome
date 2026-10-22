package com.ss.android.lark.conditional.access.device.ui;

import com.ss.android.lark.conditional.access.network.model.response.GetDeviceInfoData;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
import com.ss.android.lark.storage.LarkKVStorage;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.conditional.access.device.ui.UserScopeDeviceDeclareFragment$initData$1$1$1", f = "UserScopeDeviceDeclareFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UserScopeDeviceDeclareFragment$initData$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GetDeviceInfoData $it;
    int label;
    final /* synthetic */ UserScopeDeviceDeclareFragment this$0;

    public UserScopeDeviceDeclareFragment$initData$1$1$1(GetDeviceInfoData r1, UserScopeDeviceDeclareFragment r2, Continuation<? super UserScopeDeviceDeclareFragment$initData$1$1$1> r3) {
        this.$it = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new UserScopeDeviceDeclareFragment$initData$1$1$1(this.$it, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r5);
        int r6 = ScsLogger.a;
        ScsLogger.d("SecurityPolicy_UserScopeDeviceDeclareFragment", "getDeviceInfo onSuccess setupUI, ownership: " + this.$it.getOwnership() + ", applyStatus: " + this.$it.getApplyStatus());
        Integer r7 = this.this$0.j;
        int r0 = this.$it.getApplyStatus();
        if (r7 != null) goto L8;
    L9:
        this.this$0.j = Boxing.boxInt(this.$it.getApplyStatus());
        UserScopeDeviceDeclareFragment r8 = this.this$0;
        int r1 = this.$it.getApplyStatus();
        com.ss.android.lark.storage.kv.storage.a r9 = r8.i;
        if (r9 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("kvStorage");
        r9 = null;
    L13:
        com.ss.android.lark.storage.a r2 = com.ss.android.lark.security.compliance.infra.storage.d.a;
        Intrinsics.checkNotNullParameter(r9, "user");
        LarkKVStorage.d(LarkKVStorage.a, r9, com.ss.android.lark.security.compliance.infra.storage.d.a, "common").putInt("scs_sp_conditional_access_apply_status", r1);
        boolean r10 = true;
    L15:
        UserScopeDeviceDeclareFragment.Y90(this.this$0, this.$it.getOwnership());
        this.this$0.ca0(this.$it.getApplyStatus(), this.$it.getRejectReason());
        if (r10 == false) goto L19;
        UserScopeDeviceDeclareFragment.Z90(this.this$0, this.$it.getApplyStatus());
    L19:
        return Unit.INSTANCE;
    L8:
        if (r7.intValue() != r0) goto L9;
        r10 = false;
        goto L15
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
