package com.larus.doc.impl.operation;

import com.larus.doc.impl.DocumentApi;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "", "Lcom/larus/doc/impl/DocumentApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$updateDocumentBrief$1$result$1", f = "DocOpManager.kt", i = {}, l = {1068}, m = "invokeSuspend", n = {}, s = {})
public final class DocOpManager$updateDocumentBrief$1$result$1 extends SuspendLambda implements Function2<DocumentApi, Continuation<? super BizResponse<Object>>, Object> {
    final /* synthetic */ int $artifactType;
    final /* synthetic */ Long $parsedArtifactVersionId;
    final /* synthetic */ String $resourceId;
    private /* synthetic */ Object L$0;
    int label;

    public DocOpManager$updateDocumentBrief$1$result$1(String r1, int r2, Long r3, Continuation<? super DocOpManager$updateDocumentBrief$1$result$1> r4) {
        this.$resourceId = r1;
        this.$artifactType = r2;
        this.$parsedArtifactVersionId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        DocOpManager$updateDocumentBrief$1$result$1 r0 = new DocOpManager$updateDocumentBrief$1$result$1(this.$resourceId, this.$artifactType, this.$parsedArtifactVersionId, r6);
        r0.L$0 = r5;
        return r0;
    }

    public final Object invoke(DocumentApi r1, Continuation<? super BizResponse<Object>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((DocumentApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L11:
        return r9;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        DocumentApi r10 = (DocumentApi) this.L$0;
        r r2 = new r(this.$resourceId, this.$artifactType, this.$parsedArtifactVersionId, CollectionsKt.listOf(new String[]{"brief", "status"}));
        this.label = 1;
        r9 = r10.updateBrief(r2, this);
        if (r9 != r0) goto L11;
        return r0;
    }
}
