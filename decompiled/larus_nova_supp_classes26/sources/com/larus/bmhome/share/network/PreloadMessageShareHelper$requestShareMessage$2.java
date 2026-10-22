package com.larus.bmhome.share.network;

import com.larus.network.bean.BizResponse;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/share/network/SaveMessageShareInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.share.network.PreloadMessageShareHelper$requestShareMessage$2", f = "PreloadMessageShareHelper.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
public final class PreloadMessageShareHelper$requestShareMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BizResponse<SaveMessageShareInfo>>, Object> {
    final /* synthetic */ f $request;
    int label;
    final /* synthetic */ PreloadMessageShareHelper this$0;

    public PreloadMessageShareHelper$requestShareMessage$2(PreloadMessageShareHelper r1, f r2, Continuation<? super PreloadMessageShareHelper$requestShareMessage$2> r3) {
        this.this$0 = r1;
        this.$request = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new PreloadMessageShareHelper$requestShareMessage$2(this.this$0, this.$request, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super BizResponse<SaveMessageShareInfo>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r21) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        ResultKt.throwOnFailure(r21);
        Object r3 = r21;
    L15:
        dm9.a.b r4 = (dm9.a) r3;
        if ((r4 instanceof dm9.a.b) == false) goto L20;
        return r4.a;
    L20:
        if ((r4 instanceof dm9.a.a) == false) goto L24;
        FLogger.a.i("PreloadMessageShareHelper", String.valueOf(((dm9.a.a) r4).c));
        return new BizResponse(-1, null, null, null, 14, null);
    L24:
        return new BizResponse(-1, null, null, null, 14, null);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r21);
        PreloadMessageShareHelper r5 = this.this$0;
        BizResponse<SaveMessageShareInfo> r6 = r5.a;
        if (r6 == null) goto L12;
        r5.a = null;
        return r6;
    L12:
        MessageShareApi.Companion r7 = MessageShareApi.a;
        f r8 = this.$request;
        this.label = 1;
        r7.getClass();
        r3 = MessageShareApi.Companion.a(r8, this);
        if (r3 != r1) goto L15;
        return r1;
    }
}
