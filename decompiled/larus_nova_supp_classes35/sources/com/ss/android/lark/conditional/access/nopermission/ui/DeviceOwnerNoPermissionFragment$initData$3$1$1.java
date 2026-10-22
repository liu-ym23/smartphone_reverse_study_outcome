package com.ss.android.lark.conditional.access.nopermission.ui;

import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.conditional.access.network.model.response.GetDeviceInfoData;
import com.ss.android.lark.conditional.access.network.service.ConditionalAccessNetDependency;
import com.ss.android.lark.security.compliance.infra.log.ScsLogger;
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
@DebugMetadata(c = "com.ss.android.lark.conditional.access.nopermission.ui.DeviceOwnerNoPermissionFragment$initData$3$1$1", f = "DeviceOwnerNoPermissionFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DeviceOwnerNoPermissionFragment$initData$3$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ GetDeviceInfoData $info;
    int label;
    final /* synthetic */ DeviceOwnerNoPermissionFragment this$0;

    public DeviceOwnerNoPermissionFragment$initData$3$1$1(GetDeviceInfoData r1, DeviceOwnerNoPermissionFragment r2, Continuation<? super DeviceOwnerNoPermissionFragment$initData$3$1$1> r3) {
        this.$info = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DeviceOwnerNoPermissionFragment$initData$3$1$1(this.$info, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r4);
        CharSequence r1 = null;
        if (this.$info.getApplyStatus() != ConditionalAccessNetDependency.DeviceApplyStatus.Pass.getValue()) goto L10;
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionFragment", "hide switch");
        TextView r5 = this.this$0.S90().g;
        FragmentActivity r0 = this.this$0.getActivity();
        if (r0 == null) goto L9;
        r1 = r0.getText(2131890527);
    L9:
        r5.setText(r1);
        t4c.b.a(this.this$0.S90().c);
    L14:
        this.this$0.S90().e.b.cancelAnimation();
        t4c.b.a(this.this$0.S90().e.a);
        t4c.b.b(this.this$0.S90().f);
        return Unit.INSTANCE;
    L10:
        ScsLogger.d("SecurityPolicy_DeviceOwnerNoPermissionFragment", "show switch");
        TextView r6 = this.this$0.S90().g;
        FragmentActivity r2 = this.this$0.getActivity();
        if (r2 == null) goto L13;
        r1 = r2.getText(2131890470);
    L13:
        r6.setText(r1);
        t4c.b.b(this.this$0.S90().c);
        goto L14
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
