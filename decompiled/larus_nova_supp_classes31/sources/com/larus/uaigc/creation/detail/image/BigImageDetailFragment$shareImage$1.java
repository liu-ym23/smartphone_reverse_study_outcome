package com.larus.uaigc.creation.detail.image;

import com.larus.bmhome.share.ShareScene;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.uaigc.service.ICreationShareService;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.creation.detail.image.BigImageDetailFragment$shareImage$1", f = "BigImageDetailFragment.kt", i = {}, l = {1126}, m = "invokeSuspend", n = {}, s = {})
final class BigImageDetailFragment$shareImage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $imageUrl;
    final /* synthetic */ String $messageId;
    int label;
    final /* synthetic */ BigImageDetailFragment this$0;

    public BigImageDetailFragment$shareImage$1(BigImageDetailFragment r1, String r2, String r3, Continuation<? super BigImageDetailFragment$shareImage$1> r4) {
        this.this$0 = r1;
        this.$messageId = r2;
        this.$imageUrl = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new BigImageDetailFragment$shareImage$1(this.this$0, this.$messageId, this.$imageUrl, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L11:
        UserCreationFromIM r7 = (UserCreationFromIM) r12;
        ICreationShareService.a.a(ICreationShareService.a, this.this$0.getContext(), this.$imageUrl, ShareScene.IMAGE_VIEWER_REPORT, new BigImageDetailFragment.b(String.valueOf(this.$messageId)), BigImageDetailFragment.X90(this.this$0, "picture_detail"), null, r7, null, null, 928);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        BigImageDetailFragment r13 = this.this$0;
        String r2 = this.$messageId;
        this.label = 1;
        int r3 = BigImageDetailFragment.I;
        r12 = r13.ea0(r2, this);
        if (r12 != r0) goto L11;
        return r0;
    }
}
