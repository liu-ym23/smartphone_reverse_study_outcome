package com.larus.doc.impl;

import android.os.Bundle;
import com.larus.doc.api.IDocService;
import com.larus.doc.api.IDocService$Companion;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocFragment$offlineDocCreateHostAbility$1$refreshRemoteBinding$1", f = "DocFragment.kt", i = {}, l = {324}, m = "invokeSuspend", n = {}, s = {})
public final class DocFragment$offlineDocCreateHostAbility$1$refreshRemoteBinding$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $resourceType;
    int label;
    final /* synthetic */ DocFragment this$0;

    public DocFragment$offlineDocCreateHostAbility$1$refreshRemoteBinding$1(DocFragment r1, int r2, Continuation<? super DocFragment$offlineDocCreateHostAbility$1$refreshRemoteBinding$1> r3) {
        this.this$0 = r1;
        this.$resourceType = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DocFragment$offlineDocCreateHostAbility$1$refreshRemoteBinding$1(this.this$0, this.$resourceType, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L20:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        DocFragment r8 = this.this$0;
        int r2 = this.$resourceType;
        Pair[] r3 = new Pair[7];
        r3[0] = TuplesKt.to("key_doc_id", r8.f);
        r3[1] = TuplesKt.to("artifact_meta_id", r8.j);
        r3[2] = TuplesKt.to("key_artifact_version_id", r8.k);
        r3[3] = TuplesKt.to("resource_type", Integer.valueOf(r2));
        r3[4] = TuplesKt.to("argConversationId", r8.x);
        String r4 = r8.G;
        if (r4 != null) goto L16;
        r4 = r8.w;
        if (r4 != null) goto L16;
        Bundle r5 = r8.getArguments();
        if (r5 == null) goto L15;
        r4 = r5.getString("key_message_id", null);
        goto L16
    L15:
        r4 = null;
    L16:
        r3[5] = TuplesKt.to("key_message_id", r4);
        r3[6] = TuplesKt.to("argPreviousPage", r8.x1);
        Bundle r9 = com.larus.utils.f.c(r3);
        IDocService$Companion r6 = IDocService.a;
        DocFragment r10 = this.this$0;
        this.label = 1;
        if (r6.R9(r10, r9, this) != r0) goto L20;
        return r0;
    }
}
