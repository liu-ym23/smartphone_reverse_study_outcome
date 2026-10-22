package com.larus.bmhome.share.network;

import com.larus.network.bean.BizResponse;
import com.larus.platform.service.z2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/share/network/SaveMessageShareInfo;", "Lcom/larus/bmhome/share/network/MessageShareApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.share.network.MessageShareApi$Companion$messageShareSave$2", f = "MessageShareApi.kt", i = {}, l = {46, 48}, m = "invokeSuspend", n = {}, s = {})
public final class MessageShareApi$Companion$messageShareSave$2 extends SuspendLambda implements Function2<MessageShareApi, Continuation<? super BizResponse<SaveMessageShareInfo>>, Object> {
    final /* synthetic */ f $request;
    private /* synthetic */ Object L$0;
    int label;

    public MessageShareApi$Companion$messageShareSave$2(f r1, Continuation<? super MessageShareApi$Companion$messageShareSave$2> r2) {
        this.$request = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MessageShareApi$Companion$messageShareSave$2 r0 = new MessageShareApi$Companion$messageShareSave$2(this.$request, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(MessageShareApi r1, Continuation<? super BizResponse<SaveMessageShareInfo>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((MessageShareApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r5);
    L24:
        return (BizResponse) r5;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r5);
    L23:
        return (BizResponse) r5;
    L10:
        ResultKt.throwOnFailure(r5);
        MessageShareApi r6 = (MessageShareApi) this.L$0;
        if (z2.a.getShareUnifyOpt() == false) goto L13;
    L19:
        f r2 = this.$request;
        this.label = 1;
        r5 = r6.messageShareSaveNew(r2, this);
        if (r5 != r0) goto L23;
        return r0;
    L13:
        if (sr8.c.a() == true) goto L19;
        f r3 = this.$request;
        this.label = 2;
        r5 = r6.messageShareSaveLegacy(r3, this);
        if (r5 != r0) goto L24;
        return r0;
    }
}
