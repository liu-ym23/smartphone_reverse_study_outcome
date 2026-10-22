package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.im.v1.GetTenantMessageConfResponse;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Lcom/bytedance/lark/pb/im/v1/GetTenantMessageConfResponse;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.ss.android.lark.chat.service.impl.MessageTenantConfService$fetch$1", f = "MessageTenantConfService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MessageTenantConfService$fetch$1 extends SuspendLambda implements Function2<GetTenantMessageConfResponse, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MessageTenantConfService this$0;

    public MessageTenantConfService$fetch$1(MessageTenantConfService r1, Continuation<? super MessageTenantConfService$fetch$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MessageTenantConfService$fetch$1 r0 = new MessageTenantConfService$fetch$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(GetTenantMessageConfResponse r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((GetTenantMessageConfResponse) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        GetTenantMessageConfResponse r4 = (GetTenantMessageConfResponse) this.L$0;
        MessageTenantConfService r0 = this.this$0;
        MessageTenantConfService.b(r0, r0.b, r4.conf);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
