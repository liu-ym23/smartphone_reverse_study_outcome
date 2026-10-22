package com.larus.bmhome.miniartifact.listpage;

import com.larus.bmhome.miniartifact.listpage.request.PageStatus;
import com.larus.utils.logger.FLogger;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/bmhome/miniartifact/listpage/request/PageStatus;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.miniartifact.listpage.MiniArtifactListPageTemplateComponent$subscribePageStatus$2", f = "MiniArtifactListPageTemplateComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MiniArtifactListPageTemplateComponent$subscribePageStatus$2 extends SuspendLambda implements Function2<PageStatus, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MiniArtifactListPageTemplateComponent this$0;

    public MiniArtifactListPageTemplateComponent$subscribePageStatus$2(MiniArtifactListPageTemplateComponent r1, Continuation<? super MiniArtifactListPageTemplateComponent$subscribePageStatus$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MiniArtifactListPageTemplateComponent$subscribePageStatus$2 r0 = new MiniArtifactListPageTemplateComponent$subscribePageStatus$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(PageStatus r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((PageStatus) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        PageStatus r5 = (PageStatus) this.L$0;
        FLogger.a.i("MiniArtifactListPage", "current load status:" + r5);
        MiniArtifactListPageTemplateComponent r0 = this.this$0;
        Lazy<Integer> r1 = MiniArtifactListPageTemplateComponent.D;
        r0.h3(r5);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
