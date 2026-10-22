package com.larus.doc.impl.operation;

import com.larus.doc.impl.DocumentApi;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.operation.DocOpManager$updateDocumentBrief$1", f = "DocOpManager.kt", i = {}, l = {1067}, m = "invokeSuspend", n = {}, s = {})
public final class DocOpManager$updateDocumentBrief$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $artifactType;
    final /* synthetic */ Long $parsedArtifactVersionId;
    final /* synthetic */ String $resourceId;
    int label;

    public DocOpManager$updateDocumentBrief$1(String r1, int r2, Long r3, Continuation<? super DocOpManager$updateDocumentBrief$1> r4) {
        this.$resourceId = r1;
        this.$artifactType = r2;
        this.$parsedArtifactVersionId = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DocOpManager$updateDocumentBrief$1(this.$resourceId, this.$artifactType, this.$parsedArtifactVersionId, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L11:
        FLogger.a.i("DocOpManager", "result:" + ((dm9.a) r8));
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        DocumentApi.a r9 = DocumentApi.a;
        DocOpManager$updateDocumentBrief$1$result$1 r2 = new DocOpManager$updateDocumentBrief$1$result$1(this.$resourceId, this.$artifactType, this.$parsedArtifactVersionId, null);
        this.label = 1;
        r9.getClass();
        r8 = DocumentApi.a.a(r2, this);
        if (r8 != r0) goto L11;
        return r0;
    }
}
