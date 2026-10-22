package com.larus.bmhome.share.network;

import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.share.network.SharePanelShowHelper$interceptItemClick$1$response$loadingDeferred$1", f = "SharePanelShowHelper.kt", i = {}, l = {128}, m = "invokeSuspend", n = {}, s = {})
public final class SharePanelShowHelper$interceptItemClick$1$response$loadingDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ j $loadingAbility;
    int label;
    final /* synthetic */ SharePanelShowHelper this$0;

    public SharePanelShowHelper$interceptItemClick$1$response$loadingDeferred$1(SharePanelShowHelper r1, j r2, Continuation<? super SharePanelShowHelper$interceptItemClick$1$response$loadingDeferred$1> r3) {
        this.this$0 = r1;
        this.$loadingAbility = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SharePanelShowHelper$interceptItemClick$1$response$loadingDeferred$1(this.this$0, this.$loadingAbility, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        Deferred<BizResponse<SaveMessageShareInfo>> r7 = this.this$0.b;
        if (r7 != null) goto L14;
    L16:
        r2 = false;
    L17:
        if (r2 == false) goto L20;
        this.$loadingAbility.showLoading();
    L20:
        return Unit.INSTANCE;
    L14:
        if (r7.isCompleted() == true) goto L16;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        this.label = 1;
        if (DelayKt.delay(500, this) != r0) goto L11;
        return r0;
    }
}
