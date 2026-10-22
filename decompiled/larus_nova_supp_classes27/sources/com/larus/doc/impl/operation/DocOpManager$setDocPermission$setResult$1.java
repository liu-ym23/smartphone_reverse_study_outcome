package com.larus.doc.impl.operation;

import com.larus.doc.impl.DocumentApi;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/doc/impl/DocumentApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$setDocPermission$setResult$1", f = "DocOpManager.kt", i = {}, l = {308}, m = "invokeSuspend", n = {}, s = {})
public final class DocOpManager$setDocPermission$setResult$1 extends SuspendLambda implements Function2<DocumentApi, Continuation<? super BizResponse<Object>>, Object> {
    final /* synthetic */ boolean $public;
    final /* synthetic */ String $resourceId;
    private /* synthetic */ Object L$0;
    int label;

    public DocOpManager$setDocPermission$setResult$1(String r1, boolean r2, Continuation<? super DocOpManager$setDocPermission$setResult$1> r3) {
        this.$resourceId = r1;
        this.$public = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        DocOpManager$setDocPermission$setResult$1 r0 = new DocOpManager$setDocPermission$setResult$1(this.$resourceId, this.$public, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(DocumentApi r1, Continuation<? super BizResponse<Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((DocumentApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L11:
        return r7;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        DocumentApi r8 = (DocumentApi) this.L$0;
        q r2 = new q(this.$resourceId, 22, this.$public);
        this.label = 1;
        r7 = r8.setDocPermission(r2, this);
        if (r7 != r0) goto L11;
        return r0;
    }
}
