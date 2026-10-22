package com.larus.uaigc.createpage.component.digitalavatar;

import com.larus.network.bean.BizResponse;
import com.larus.uaigc.avatar.api.DigitalAvatarApi;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/uaigc/avatar/api/DigitalAvatarApi;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarComponent$realDeleteDigitalAvatar$1$result$1", f = "DigitalAvatarComponent.kt", i = {}, l = {629}, m = "invokeSuspend", n = {}, s = {})
public final class DigitalAvatarComponent$realDeleteDigitalAvatar$1$result$1 extends SuspendLambda implements Function2<DigitalAvatarApi, Continuation<? super BizResponse<?>>, Object> {
    final /* synthetic */ String $digitalAvatarId;
    private /* synthetic */ Object L$0;
    int label;

    public DigitalAvatarComponent$realDeleteDigitalAvatar$1$result$1(String r1, Continuation<? super DigitalAvatarComponent$realDeleteDigitalAvatar$1$result$1> r2) {
        this.$digitalAvatarId = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        DigitalAvatarComponent$realDeleteDigitalAvatar$1$result$1 r0 = new DigitalAvatarComponent$realDeleteDigitalAvatar$1$result$1(this.$digitalAvatarId, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(DigitalAvatarApi r1, Continuation<? super BizResponse<?>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((DigitalAvatarApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L11:
        return r5;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        DigitalAvatarApi r6 = (DigitalAvatarApi) this.L$0;
        ey9.d r2 = new ey9.d(this.$digitalAvatarId);
        this.label = 1;
        r5 = r6.deleteDigitalAvatar(r2, this);
        if (r5 != r0) goto L11;
        return r0;
    }
}
