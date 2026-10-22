package com.larus.doc.impl.chat.component;

import com.larus.doc.impl.DocumentApi;
import com.larus.network.bean.BizResponse;
import com.larus.platform.service.AccountService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/doc/impl/chat/data/CreateNewDocRespV2;", "Lcom/larus/doc/impl/DocumentApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.chat.component.NewDocComponent$createNewDocV2$1$resp$1", f = "NewDocComponent.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
public final class NewDocComponent$createNewDocV2$1$resp$1 extends SuspendLambda implements Function2<DocumentApi, Continuation<? super BizResponse<h39.d>>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public NewDocComponent$createNewDocV2$1$resp$1(Continuation<? super NewDocComponent$createNewDocV2$1$resp$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        NewDocComponent$createNewDocV2$1$resp$1 r0 = new NewDocComponent$createNewDocV2$1$resp$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public final Object invoke(DocumentApi r1, Continuation<? super BizResponse<h39.d>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((DocumentApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        DocumentApi r7 = (DocumentApi) this.L$0;
        h39.c r2 = new h39.c(AccountService.a.getUserId(), 1, 0, 1);
        this.label = 1;
        r6 = r7.createNewDocV2(r2, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
