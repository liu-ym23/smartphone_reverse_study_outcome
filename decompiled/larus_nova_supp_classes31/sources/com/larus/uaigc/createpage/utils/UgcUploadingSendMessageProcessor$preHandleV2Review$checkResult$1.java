package com.larus.uaigc.createpage.utils;

import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.network.bean.BizResponse;
import com.larus.uaigc.api.ReviewUgcImageApi;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/uaigc/api/ReviewUgcImageApi$PreHandlerV2ReviewImageResponse;", "Lcom/larus/uaigc/api/ReviewUgcImageApi;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.createpage.utils.UgcUploadingSendMessageProcessor$preHandleV2Review$checkResult$1", f = "NestedFileSendMessageProcessor.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
public final class UgcUploadingSendMessageProcessor$preHandleV2Review$checkResult$1 extends SuspendLambda implements Function2<ReviewUgcImageApi, Continuation<? super BizResponse<ReviewUgcImageApi.b>>, Object> {
    final /* synthetic */ String $conversationId;
    final /* synthetic */ UplinkFileEntity $entity;
    final /* synthetic */ String $localMsgId;
    final /* synthetic */ String $sectionId;
    private /* synthetic */ Object L$0;
    int label;

    public UgcUploadingSendMessageProcessor$preHandleV2Review$checkResult$1(UplinkFileEntity r1, String r2, String r3, String r4, Continuation<? super UgcUploadingSendMessageProcessor$preHandleV2Review$checkResult$1> r5) {
        this.$entity = r1;
        this.$conversationId = r2;
        this.$sectionId = r3;
        this.$localMsgId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        UgcUploadingSendMessageProcessor$preHandleV2Review$checkResult$1 r6 = new UgcUploadingSendMessageProcessor$preHandleV2Review$checkResult$1(this.$entity, this.$conversationId, this.$sectionId, this.$localMsgId, r9);
        r6.L$0 = r8;
        return r6;
    }

    public final Object invoke(ReviewUgcImageApi r1, Continuation<? super BizResponse<ReviewUgcImageApi.b>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ReviewUgcImageApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L17:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        ReviewUgcImageApi r11 = (ReviewUgcImageApi) this.L$0;
        com.larus.bmhome.chat.api.e0 r2 = (com.larus.bmhome.chat.api.e0) AuthModelDelegate.b.e().getValue();
        if (r2 == null) goto L13;
        LaunchInfo r3 = r2.a;
        if (r3 == null) goto L13;
        String r4 = r3.W();
    L14:
        UplinkFileEntity r5 = this.$entity;
        String r6 = this.$conversationId;
        ReviewUgcImageApi.a r7 = new ReviewUgcImageApi.a(r5, r6, r4, this.$sectionId, this.$localMsgId);
        this.label = 1;
        r10 = r11.reviewImageByPreHandlerV2(r7, this);
        if (r10 != r0) goto L17;
        return r0;
    L13:
        r4 = null;
        goto L14
    }
}
