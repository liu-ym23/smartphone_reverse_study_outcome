package com.larus.doc.impl;

import com.larus.doc.sdk.api.IDocSdkBaseService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.doc.impl.DocFragment$integrateFloatChatFragment$1$1$1$1$2", f = "DocFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DocFragment$integrateFloatChatFragment$1$1$1$1$2 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;
    final /* synthetic */ DocFragment this$0;

    public DocFragment$integrateFloatChatFragment$1$1$1$1$2(DocFragment r1, Continuation<? super DocFragment$integrateFloatChatFragment$1$1$1$1$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        DocFragment$integrateFloatChatFragment$1$1$1$1$2 r0 = new DocFragment$integrateFloatChatFragment$1$1$1$1$2(this.this$0, r4);
        r0.I$0 = ((Number) r3).intValue();
        return r0;
    }

    public final Object invoke(int r1, Continuation<? super Unit> r2) {
        return create(Integer.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Number) r1).intValue(), (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r4);
        if (this.I$0 != 1) goto L11;
        IDocSdkBaseService r5 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r5 == null) goto L11;
        n39.l r6 = r5.getPartialRewriteService();
        if (r6 == null) goto L11;
        r6.enterStreamEditIfNeeded();
    L11:
        final DocFragment r7 = this.this$0;
        com.larus.utils.t0.d(new b1(r7), 400);
        DocFragment.za0(this.this$0, false, 3);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
