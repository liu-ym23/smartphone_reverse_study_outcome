package com.larus.doc.impl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocFragment$showMoreMenu$1$commonMenu$1$1", f = "DocFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DocFragment$showMoreMenu$1$commonMenu$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $buttonName;
    int label;
    final /* synthetic */ DocFragment this$0;

    public DocFragment$showMoreMenu$1$commonMenu$1$1(String r1, DocFragment r2, Continuation<? super DocFragment$showMoreMenu$1$commonMenu$1$1> r3) {
        this.$buttonName = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DocFragment$showMoreMenu$1$commonMenu$1$1(this.$buttonName, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        if (Intrinsics.areEqual(this.$buttonName, "copy_doc") == true) goto L7;
    L8:
        n39.f r5 = this.this$0.ca0();
        if (r5 == null) goto L12;
        final DocFragment r0 = this.this$0;
        final String r1 = this.$buttonName;
        r5.getDocVersionId(new d1(r0, r1));
    L12:
        return Unit.INSTANCE;
    L7:
        if (this.this$0.B == true) goto L12;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
